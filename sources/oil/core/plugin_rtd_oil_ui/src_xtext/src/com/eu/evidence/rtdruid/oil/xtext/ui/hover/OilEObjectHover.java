/**
 * 11/set/2012
 */
package com.eu.evidence.rtdruid.oil.xtext.ui.hover;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.TextUtilities;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.hover.DispatchingEObjectTextHover;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

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
public class OilEObjectHover extends DispatchingEObjectTextHover {

	@Inject
	private EObjectAtOffsetHelper this_eObjectAtOffsetHelper;

	@Inject
	private ILocationInFileProvider this_locationInFileProvider;
	
	/* (non-Javadoc)
	 * @see org.eclipse.xtext.ui.editor.hover.AbstractEObjectHover#getXtextElementAt(org.eclipse.xtext.resource.XtextResource, int)
	 */
	@Override
	protected Pair<EObject, IRegion> getXtextElementAt(XtextResource resource, int editorOffset) {
		{
			Logger log = Logger.getLogger(OilEObjectHover.class);
			log.debug("Hover - " + editorOffset);
		}

		if (EObjectAtIncludedOffsetHelper.class.isAssignableFrom(this_eObjectAtOffsetHelper.getClass())){
			EObjectAtIncludedOffsetHelper helper = (EObjectAtIncludedOffsetHelper) this_eObjectAtOffsetHelper;
			String includeText = Utils.getIncludeText( helper.getNode(resource, editorOffset) );
			
			if (includeText != null) {
				
				
				return null;
			}
			
		}

		
		// check for cross reference
		EObject crossLinkedEObject = this_eObjectAtOffsetHelper.resolveCrossReferencedElementAt(resource, editorOffset);
		if (crossLinkedEObject != null) {
			if (!crossLinkedEObject.eIsProxy()) {
				IParseResult parseResult = resource.getParseResult();
				if (parseResult != null) {
					ILineConverterHelper helper = Utils.getLineHelper(parseResult);
					final int fullOffset = helper == null ? editorOffset : helper.getFullIndex(editorOffset);			
					
					
					ILeafNode leafNode = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), fullOffset);
					if(leafNode != null && leafNode.isHidden() && leafNode.getOffset() == fullOffset) {
						// warning: it can be outside the editor !! (mostly if the oil inclusion is wild/crazy)
						leafNode = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), fullOffset - 1);
					}
					if (leafNode != null) {
						// Convert offsets to editor ones
						int leafEditorOffset = leafNode.getOffset();
						if (helper != null) {
							leafEditorOffset = helper.getMainIndex(leafEditorOffset).getOffset();
						}
						
						return Tuples.create(crossLinkedEObject, (IRegion) new Region(leafEditorOffset, leafNode.getLength()));
					}
				}
			}
		} else {
			EObject o = this_eObjectAtOffsetHelper.resolveElementAt(resource, editorOffset);
			if (o != null) {
				ITextRegion region = this_locationInFileProvider.getSignificantTextRegion(o);
				final IRegion region2 = new Region(region.getOffset(), region.getLength());
				if (TextUtilities.overlaps(region2, new Region(editorOffset, 0)))
					return Tuples.create(o, region2);
			}
		}
		return null;
	}
}
