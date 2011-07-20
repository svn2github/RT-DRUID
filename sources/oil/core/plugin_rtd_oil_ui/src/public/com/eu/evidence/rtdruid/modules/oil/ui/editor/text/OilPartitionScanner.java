/*
 * Created on Jan 26, 2005
 *
 * $Id: OilPartitionScanner.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.ui.editor.text;

import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;

/**
 * A Partitioner for an Oil (Text) Document.
 * 
 * <br>
 * Valid Parts are :
 * <ul>
 * <li>{@link #STR_STRING STR_STRING }for strings : "xxxx"</li>
 * <li>{@link #STR_COMMENT STR_COMMENT }for one row comments : // xxxx</li>
 * <li>{@link #STR_LONG_COMMENT STR_LONG_COMMENT }for long comments (with 2
 * delimitators) : &#047;&#042; xxx xxx xxx &#042;&#047;</li>
 * </ul>
 * 
 * @author Nicola Serreli
 */
public class OilPartitionScanner extends RuleBasedPartitionScanner {
	/** One row strings : "xxx" */
	public final static String STR_STRING = "__oil_string";

	/** One row comments : &#047;&#047;xxxx */
	public final static String STR_COMMENT = "__oil_comment";

	/** Multi row comments : &#047;&#042; xxx xxx xxx &#042;&#047; */
	public final static String STR_LONG_COMMENT = "__oil_long_comment";

	/** The default constructor */
	public OilPartitionScanner() {

		IPredicateRule[] rules = new IPredicateRule[3];

		// Comment with more than one row
		rules[0] = new MultiLineRule("/*", "*/", new Token(STR_LONG_COMMENT),
				(char) 0, true);
		// Comment with only one row
		rules[1] = new SingleLineRule("//", null, new Token(STR_COMMENT),
				(char) 0, true);

		// Strings
		rules[2] = new SingleLineRule("\"", "\"", new Token(STR_STRING), '\\',
				true);

		// set all partition's rules
		setPredicateRules(rules);
	}
}