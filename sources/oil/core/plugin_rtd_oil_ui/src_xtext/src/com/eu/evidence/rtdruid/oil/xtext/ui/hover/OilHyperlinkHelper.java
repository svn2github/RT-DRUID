/**
 * 20/set/2012
 */
package com.eu.evidence.rtdruid.oil.xtext.ui.hover;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.hyperlinking.HyperlinkHelper;
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkAcceptor;
import org.eclipse.xtext.ui.editor.hyperlinking.XtextHyperlink;

import com.eu.evidence.rtdruid.oil.xtext.parser.EObjectAtIncludedOffsetHelper;
import com.eu.evidence.rtdruid.oil.xtext.parser.ILineConverterHelper;
import com.eu.evidence.rtdruid.oil.xtext.parser.Utils;
import com.google.inject.Inject;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class OilHyperlinkHelper extends HyperlinkHelper {
	
	@Inject
	private EObjectAtOffsetHelper this_eObjectAtOffsetHelper;
	
	
	/* (non-Javadoc)
	 * @see org.eclipse.xtext.ui.editor.hyperlinking.HyperlinkHelper#createHyperlinksByOffset(org.eclipse.xtext.resource.XtextResource, int, org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkAcceptor)
	 */
	@Override
	public void createHyperlinksByOffset(XtextResource resource, int editorOffset, IHyperlinkAcceptor acceptor) {
		
		EObjectAtIncludedOffsetHelper helper = (EObjectAtIncludedOffsetHelper) this_eObjectAtOffsetHelper;
		INode node = helper.getNode(resource, editorOffset);
		if (Utils.isIncludeNode(node)) {
			createIncludeHyperlink(resource, node, acceptor);
		} else {
			super.createHyperlinksByOffset(resource, editorOffset, acceptor);
		}
	}
	
	public void createHyperlinksTo(XtextResource from, Region region, EObject to, IHyperlinkAcceptor acceptor) {
		super.createHyperlinksTo(from, updateRegion(from, region), to, acceptor);
	}

	protected void createIncludeHyperlink(XtextResource resource, INode node, IHyperlinkAcceptor acceptor) {
		String text =  Utils.getIncludeText(node);
		URI toUri = null;
		URI mainUri = resource.getURI();
		String fileWsPath = mainUri.toPlatformString(false);
		String fileFsPath = mainUri.toFileString();
		if (fileWsPath != null) {
			IResource res = ResourcesPlugin.getWorkspace().getRoot().findMember(fileWsPath);
			IContainer container = res.getParent();
			res = container.findMember(text);
			toUri = URI.createPlatformResourceURI(res.getFullPath().toPortableString(), false);
			
		} else if (fileFsPath != null) {
			// convert the file name in a File (and then in the absolute path)
			IPath p = new Path(text);
			if (!p.isAbsolute()) {
				p = new Path(fileFsPath);
				p = p.removeLastSegments(1).append(text);
			}
			toUri = URI.createFileURI(p.toPortableString());
		}
		
		final URIConverter uriConverter = resource.getResourceSet().getURIConverter();
		final String hyperlinkText = "Open " + text;
		final URI normalized = uriConverter.normalize(toUri);

		Region region = new Region(node.getOffset(), node.getLength());
		region = updateRegion(resource, region);
		
		XtextHyperlink result = getHyperlinkProvider().get();
		result.setHyperlinkRegion(region);
		result.setURI(normalized);
		result.setHyperlinkText(hyperlinkText);
		acceptor.accept(result);
	}

	/**
	 * @param resource
	 * @param region
	 * @return
	 */
	public Region updateRegion(XtextResource resource, Region region) {
		ILineConverterHelper helper = Utils.getLineHelper(resource);
		if (helper != null) {
			final int editorOffset = helper.getMainIndex(region.getOffset()).getOffset();			
			final int editorlength = helper.getMainIndex(region.getOffset()+region.getLength()).getOffset() - editorOffset;
			region = new Region(editorOffset, editorlength);
		}
		return region;
	}
}
