/**
 * 28/set/2012
 */
package com.eu.evidence.rtdruid.oil.xtext.ui.contentassist;

import org.eclipse.jface.text.Region;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AntlrProposalConflictHelper;
import org.eclipse.xtext.util.Strings;

import com.eu.evidence.rtdruid.oil.xtext.parser.ILineConverterHelper;
import com.eu.evidence.rtdruid.oil.xtext.parser.Utils;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class OilProposalConflictHelper extends AntlrProposalConflictHelper {

	
	@Override
	public boolean existsConflict(String proposal, ContentAssistContext context) {
		
		// hidden node between lastCompleteNode and currentNode?
		INode lastCompleteNode = context.getLastCompleteNode();
		ILineConverterHelper helper = Utils.getLineHelper(lastCompleteNode);
		final int lastCompleteNodeOffset = helper == null ? lastCompleteNode.getOffset() : helper.getMainIndex(lastCompleteNode.getOffset()).getOffset();
		
		Region replaceRegion = context.getReplaceRegion();
		int nodeEnd = lastCompleteNodeOffset + lastCompleteNode.getLength();
		if (nodeEnd < replaceRegion.getOffset())
			return false;
		
		return existsConflict(lastCompleteNode, replaceRegion.getOffset(), proposal, context);
	}
	
	@Override
	public boolean existsConflict(INode lastCompleteNode, int offset, String proposal, ContentAssistContext context) {
		ILineConverterHelper helper = Utils.getLineHelper(lastCompleteNode);
		final int modelOffset = helper == null ? offset : helper.getFullIndex(offset);
		
		String lastCompleteText = lastCompleteNode.getText();
		lastCompleteText = lastCompleteText.substring(0, modelOffset - lastCompleteNode.getTotalOffset());
		if (Strings.isEmpty(lastCompleteText))
			return false;
		return existsConflict(lastCompleteText, proposal, context);
	}
}
