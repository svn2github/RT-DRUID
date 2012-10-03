/**
 * 21/set/2012
 */
package com.eu.evidence.rtdruid.oil.xtext.ui.document;

import org.eclipse.xtext.ui.editor.model.DocumentTokenSource;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.ITextEditComposer;

import com.eu.evidence.rtdruid.oil.xtext.parser.ILineConverterHelper;
import com.google.inject.Inject;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class OilDocument extends XtextDocument {

	private OilDocumentTokenProvider this_tokenSource;
	
	/**
	 * @param tokenSource
	 * @param composer
	 */
	@Inject
	public OilDocument(DocumentTokenSource tokenSource, ITextEditComposer composer) {
		super(tokenSource, composer);
		if (tokenSource instanceof OilDocumentTokenProvider) {
			this_tokenSource = (OilDocumentTokenProvider) tokenSource;
		}
	}

	/**
	 * @return
	 */
	public ILineConverterHelper getLineHelper() {
		return this_tokenSource == null ? null : this_tokenSource.getLineConverterHelper();
	}

}
