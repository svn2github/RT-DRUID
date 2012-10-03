/**
 * 03/ott/2012
 */
package com.eu.evidence.rtdruid.oil.xtext.ui.document;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class OilHighlightingConfiguration extends DefaultHighlightingConfiguration {

	public static final String INCLUDE_ID = "include";

	public void configure(IHighlightingConfigurationAcceptor acceptor) {
		super.configure(acceptor);
		acceptor.acceptDefaultHighlighting(INCLUDE_ID, "Include", includeTextStyle());
	}
	
	public TextStyle includeTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(128, 0, 0));
		textStyle.setStyle(SWT.ITALIC);
		return textStyle;
	}
}
