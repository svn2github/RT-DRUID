/**
 * 02/ott/2012
 */
package com.eu.evidence.rtdruid.oil.xtext.ui.document;

import org.eclipse.xtext.ui.editor.model.TerminalsTokenTypeToPartitionMapper;

import com.eu.evidence.rtdruid.oil.xtext.parser.OilIncludedLexer;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class OilTokenTypeToPartitionMapper extends TerminalsTokenTypeToPartitionMapper {

	public final static String INCLUDE_PARTITION = "__include";
	
	protected static final String[] OIL_SUPPORTED_PARTITIONS;
	
	static {
		final int oldLength = SUPPORTED_PARTITIONS.length;
		OIL_SUPPORTED_PARTITIONS = new String[oldLength +1];
		System.arraycopy(SUPPORTED_PARTITIONS, 0, OIL_SUPPORTED_PARTITIONS, 0, oldLength);
		OIL_SUPPORTED_PARTITIONS[oldLength] = INCLUDE_PARTITION;
	}
	
	@Override
	protected String calculateId(String tokenName, int tokenType) {
		if ((tokenType == OilIncludedLexer.RULE_INCLUDE)
				|| ("RULE_INCLUDE".equals(tokenName))) {
			return INCLUDE_PARTITION;
		}
		return super.calculateId(tokenName, tokenType);
	}

	public String[] getSupportedPartitionTypes() {
		return OIL_SUPPORTED_PARTITIONS;
	}

}
