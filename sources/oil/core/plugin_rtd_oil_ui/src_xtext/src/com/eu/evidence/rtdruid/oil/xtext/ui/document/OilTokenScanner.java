/**
 * 21/set/2012
 */
package com.eu.evidence.rtdruid.oil.xtext.ui.document;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.xtext.ui.editor.syntaxcoloring.TokenScanner;

import com.eu.evidence.rtdruid.oil.xtext.parser.ILineConverterHelper;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class OilTokenScanner extends TokenScanner {
	
	private ILineConverterHelper helper;
	private int oilEditorTokenOffset = -1;
	private int oilEditorTokenLenght = -1;
	private int maxEditorOffset = -1;
	
	@Override
	public void setRange(IDocument document, final int offset,final int length) {
		
		maxEditorOffset = offset+length;
	
		helper = (document instanceof OilDocument) ?
					((OilDocument) document).getLineHelper()
					: null;
		
		final int full_offset;
		final int full_length;
		if (helper != null) {
			full_offset = helper.getFullIndex(offset);
			full_length = helper.getFullIndex(offset+length) - full_offset;
		} else {
			full_offset = offset;
			full_length = length;
		}
		
		super.setRange(document, full_offset, full_length);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.xtext.ui.editor.model.PartitionTokenScanner#getTokenOffset()
	 */
	@Override
	public int getTokenOffset() {
		return oilEditorTokenOffset;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.xtext.ui.editor.model.PartitionTokenScanner#getTokenLength()
	 */
	@Override
	public int getTokenLength() {
		return oilEditorTokenLenght;
	}
	
	private void updateOffsetLenght() {
		final int token_offset = oilEditorTokenOffset = super.getTokenOffset();
		final int token_lenght = oilEditorTokenLenght = super.getTokenLength();
		
		if (helper != null) {
			oilEditorTokenOffset = helper.getMainIndex(token_offset).getOffset();
			oilEditorTokenLenght = helper.getMainIndex(token_offset + token_lenght).getOffset() -
					oilEditorTokenOffset;
		}
		
		/* Check if the current token ends after the end of the required range */
		if (oilEditorTokenOffset > maxEditorOffset) {
			oilEditorTokenOffset = maxEditorOffset;
			oilEditorTokenLenght = 0;
		} else if ((oilEditorTokenOffset + oilEditorTokenLenght)> maxEditorOffset) {
			oilEditorTokenLenght = maxEditorOffset - oilEditorTokenOffset;
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.xtext.ui.editor.model.PartitionTokenScanner#nextToken()
	 */
	@Override
	public IToken nextToken() {
		// skip "hidden" tokens
		IToken token = super.nextToken();
		updateOffsetLenght();
		while (getTokenLength() == 0 && !token.isEOF()) {
			token = super.nextToken();
			updateOffsetLenght();
		}
		
		return token;
	}
}
