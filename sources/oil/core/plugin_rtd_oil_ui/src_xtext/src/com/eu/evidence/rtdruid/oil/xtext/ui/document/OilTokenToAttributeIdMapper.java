/**
 * 03/ott/2012
 */
package com.eu.evidence.rtdruid.oil.xtext.ui.document;

import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultAntlrTokenToAttributeIdMapper;

import com.eu.evidence.rtdruid.oil.xtext.parser.OilIncludedLexer;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class OilTokenToAttributeIdMapper extends DefaultAntlrTokenToAttributeIdMapper {

	/* (non-Javadoc)
	 * @see org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultAntlrTokenToAttributeIdMapper#calculateId(java.lang.String, int)
	 */
	@Override
	protected String calculateId(String tokenName, int tokenType) {
		if ((tokenType == OilIncludedLexer.RULE_INCLUDE)
				|| ("RULE_INCLUDE".equals(tokenName))) {
			return OilHighlightingConfiguration.INCLUDE_ID;
		}
		return super.calculateId(tokenName, tokenType);
	}
}
