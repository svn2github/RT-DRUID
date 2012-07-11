/**
 * 11/lug/2012
 */
package com.eu.evidence.rtdruid.oil.xtext.ui.contentassist;

import org.eclipse.jface.text.IDocument;
import org.eclipse.xtext.ui.editor.autoedit.DefaultAutoEditStrategyProvider;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class OilEditStrategyProvider extends DefaultAutoEditStrategyProvider {

	@Override
	protected void configureCurlyBracesBlock(IEditStrategyAcceptor acceptor) {
		acceptor.accept(singleLineTerminals.newInstance("{", "};"),IDocument.DEFAULT_CONTENT_TYPE);
	}

	@Override
	protected void configureStringLiteral(IEditStrategyAcceptor acceptor) {
		super.configureStringLiteral(acceptor);
		acceptor.accept(partitionInsert.newInstance("<",">"),IDocument.DEFAULT_CONTENT_TYPE);
		acceptor.accept(partitionDeletion.newInstance("<",">"),IDocument.DEFAULT_CONTENT_TYPE);
	}
}
