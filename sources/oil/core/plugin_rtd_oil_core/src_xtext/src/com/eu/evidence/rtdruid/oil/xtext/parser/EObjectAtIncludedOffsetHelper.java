/**
 * 10/set/2012
 */
package com.eu.evidence.rtdruid.oil.xtext.parser;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.ITextRegion;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class EObjectAtIncludedOffsetHelper extends EObjectAtOffsetHelper {

	
	public INode getNode(XtextResource resource, int editorOffset) {
		IParseResult parseResult = resource.getParseResult();
		if (parseResult != null) {
			
			// change the offset
			//--------------
			ILineConverterHelper helper = Utils.getLineHelper(parseResult);
			int offset = editorOffset;
			if (helper != null) {
				offset = helper.getFullIndex(offset);
			}
			
			ILeafNode leaf = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), offset);
			return leaf;
		}
		return null;
	}
	
	@Override
	public INode getCrossReferenceNode(XtextResource resource, ITextRegion region) {
		IParseResult parseResult = resource.getParseResult();
		if (parseResult != null) {
			
			// change the offset
			//--------------
			ILineConverterHelper helper = Utils.getLineHelper(parseResult);
			int offset = region.getOffset();
			if (helper != null) {
				offset = helper.getFullIndex(offset);
			}
			
			ILeafNode leaf = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), offset);
			INode crossRefNode = findCrossReferenceNode(leaf);
			// if not a cross reference position and the cursor is at the beginning of a node try the previous one.
			if (crossRefNode == null && leaf != null && region.getLength()==0 && leaf.getOffset() == offset) {
				if (helper != null) {
					offset = helper.getFullIndex(region.getOffset()-1); /* see -1 later !!*/
				}
				leaf = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), offset /* - 1*/);
				return findCrossReferenceNode(leaf);
			} else if (crossRefNode != null && crossRefNode.getOffset()+crossRefNode.getLength() >= offset + region.getLength()) {
				return crossRefNode;
			}
		}
		return null;
	}
	
	protected EObject internalResolveElementAt(XtextResource resource, final int editorOffset, boolean containment) {
		if(!containment) {
			EObject crossRef = resolveCrossReferencedElementAt(resource, editorOffset);
			if (crossRef != null)
				return crossRef;
		}
		IParseResult parseResult = resource.getParseResult();
		if (parseResult != null) {
			
			// change the offset
			//--------------
			ILineConverterHelper helper = Utils.getLineHelper(parseResult);
			
			final int fullOffset = helper == null ? editorOffset : helper.getFullIndex(editorOffset);			
			
			ILeafNode leaf = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), fullOffset);
			if (leaf != null && leaf.isHidden() && leaf.getOffset() == fullOffset) {
				// warning: it can be outside the editor !! (mostly if the oil inclusion is wild/crazy)
				leaf = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), fullOffset - 1);
			}
			if (leaf != null) {
				return NodeModelUtils.findActualSemanticObjectFor(leaf);
			}
		}
		return null;
	}

}
