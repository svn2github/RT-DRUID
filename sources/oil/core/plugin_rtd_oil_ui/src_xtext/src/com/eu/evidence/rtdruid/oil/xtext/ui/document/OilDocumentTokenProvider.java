/**
 * 18/lug/2012
 */
package com.eu.evidence.rtdruid.oil.xtext.ui.document;

import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.ui.editor.model.DocumentTokenSource;
import org.eclipse.xtext.ui.editor.model.XtextDocument;

import com.eu.evidence.rtdruid.oil.xtext.parser.ILineConverterHelper;
import com.eu.evidence.rtdruid.oil.xtext.parser.OilIncludedLexer;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class OilDocumentTokenProvider extends DocumentTokenSource {

	protected URI uri = null;
	
	/* (non-Javadoc)
	 * @see org.eclipse.xtext.ui.editor.model.DocumentTokenSource#computeDamageRegion(org.eclipse.jface.text.DocumentEvent)
	 */
	@Override
	protected IRegion computeDamageRegion(DocumentEvent e) {
		IDocument doc = e.getDocument();
		if (doc instanceof XtextDocument) {
			uri = ((XtextDocument)doc).getResourceURI();
		}
		// reset token-list: force full document damage list
		setTokens(Collections.<DocumentTokenSource.TokenInfo>emptyList());
		
		return super.computeDamageRegion(e);
	}
	
	public void updateStructure(final DocumentEvent e) {
		IDocument doc = e.getDocument();
		if (doc instanceof XtextDocument) {
			uri = ((XtextDocument)doc).getResourceURI();
		}
		
		super.updateStructure(e);
	}
	
	private Lexer lastLexer = null;
	
	/* (non-Javadoc)
	 * @see org.eclipse.xtext.ui.editor.model.DocumentTokenSource#createLexer(java.lang.String)
	 */
	@Override
	protected Lexer createLexer(String string) {
		lastLexer = super.createLexer(string);
		if (lastLexer instanceof OilIncludedLexer && uri != null) {
			((OilIncludedLexer)lastLexer).setStreamName(uri);
		}
		return lastLexer;
	}
	
	/**
	 * @return the lineConverterHelper
	 */
	public ILineConverterHelper getLineConverterHelper() {
		if (lastLexer != null && (lastLexer instanceof OilIncludedLexer)) {
			return ((OilIncludedLexer) lastLexer).getLineConverterHelper();
		}
		return null;
	}

}
