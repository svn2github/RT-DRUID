/**
 * 15/ott/2012
 */
package com.eu.evidence.rtdruid.oil.xtext.ui.document;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.ui.editor.doubleClicking.LexerTokenAndCharacterPairAwareStrategy;

import com.eu.evidence.rtdruid.oil.xtext.parser.ILineConverterHelper;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class OilLexerTokenAndCharacterPairAwareStrategy extends LexerTokenAndCharacterPairAwareStrategy {

	/* (non-Javadoc)
	 * @see org.eclipse.xtext.ui.editor.doubleClicking.LexerTokenAndCharacterPairAwareStrategy#findWord(org.eclipse.jface.text.IDocument, int)
	 */
	@Override
	protected IRegion findWord(IDocument document, final int editorOffset) {
		
		if (document instanceof OilDocument) {
			
			ILineConverterHelper helper = ((OilDocument)document).getLineHelper();
			if (helper != null) {
				
				IRegion region = super.findWord(document, helper.getFullIndex(editorOffset));
				
				final int editorRegionOffset = helper.getMainIndex(region.getOffset()).getOffset();			
				final int editorRegionLength = helper.getMainIndex(region.getOffset()+region.getLength()).getOffset() - editorRegionOffset;
				
				return new Region(editorRegionOffset, editorRegionLength);
			}
		}
		return super.findWord(document, editorOffset);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.xtext.ui.editor.doubleClicking.LexerTokenAndCharacterPairAwareStrategy#findExtendedDoubleClickSelection(org.eclipse.jface.text.IDocument, int)
	 */
	@Override
	protected IRegion findExtendedDoubleClickSelection(IDocument document, final int editorOffset) {
		if (document instanceof OilDocument) {
			
			ILineConverterHelper helper = ((OilDocument)document).getLineHelper();
			if (helper != null) {
				
				IRegion region = super.findExtendedDoubleClickSelection(document, editorOffset);
				
				final int editorRegionOffset = helper.getMainIndex(region.getOffset()).getOffset();			
				final int editorRegionLength = helper.getMainIndex(region.getOffset()+region.getLength()).getOffset() - editorRegionOffset;
				
				return new Region(editorRegionOffset, editorRegionLength);
			}
		}
		return super.findExtendedDoubleClickSelection(document, editorOffset);
	}
}
