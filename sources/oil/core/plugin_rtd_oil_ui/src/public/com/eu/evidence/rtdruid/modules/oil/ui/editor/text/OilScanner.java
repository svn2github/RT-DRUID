/*
 * Created on Jan 26, 2005
 *
 * $Id: OilScanner.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.ui.editor.text;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WordRule;

/**
 * A rule based scanner for Oil KeyWords.
 * 
 * Know words are : *
 * <ul>
 * <li>{@link #typeKeywords TYPES }= types of all attribute</li>
 * <li>{@link #objKeywords OBJECTS }= all Oil Objects</li>
 * <li>{@link #objRefKeywords OBJECT'S REFERENCES }= reference to another Oil
 * Object</li>
 * <li>{@link #operatorKeywords OPERATORS }= all one char operators, like
 * <b>&#123; </b> or <b>&#061; </b></li>
 * </ul>
 * 
 * 
 * @author Nicola Serreli
 */
public class OilScanner extends RuleBasedScanner {

	/**
	 * A key word detector for UpperCase Chars, digits and &#095; (underscore
	 * char)
	 */
	static class MixedWordDetector implements IWordDetector {
		public boolean isWordStart(char c) {
			return Character.isUpperCase(c);
		}

		/** Return all letters (upperCase and lowerCase),
		 * digits and underscore '_' */
		public boolean isWordPart(char c) {
			return Character.isUpperCase(c)
					|| Character.isLowerCase(c)
					|| (c == '_')
					|| Character.isDigit(c);
		}
	}

	/**
	 * A detector for single character operators. See
	 * {@link OilScanner#operatorKeywords OPERATORS}.
	 */
	static class OperatorDetector implements IWordDetector {
		public boolean isWordStart(char c) {
			return (c == '{') || (c == '}') || (c == '[') || (c == ']')
					|| (c == '=') || (c == ',') || (c == ';') || (c == ':');
		}

		public boolean isWordPart(char c) {
			return false;
		}
	}

	/** Types of all attribute */
	private static String[] typeKeywords = { "UINT32", "INT32", "UINT64",
			"INT64", "FLOAT", "STRING", "BOOLEAN", "ENUM" };

	/** All Oil Objects */
	private static String[] objKeywords = { "OS", "TASK", "COUNTER", "ALARM",
			"RESOURCE", "EVENT", "ISR", "MESSAGE", "COM", "NM", "APPMODE",
			"IPDU" };

	/** Reference to another Oil Object */
	private static String[] objRefKeywords = { "OS_TYPE", "TASK_TYPE",
			"COUNTER_TYPE", "ALARM_TYPE", "RESOURCE_TYPE", "EVENT_TYPE",
			"ISR_TYPE", "MESSAGE_TYPE", "COM_TYPE", "NM_TYPE", "APPMODE_TYPE",
			"IPDU_TYPE" };

	/** All one character operators */
	private static String[] operatorKeywords = { "{", "}", "[", "]", "=", ",",
			";", ":" };

	/**
	 * Create a new Oil Text scanner.
	 * 
	 * @param provider
	 *            is the color manager
	 */
	public OilScanner(ColorManager provider) {
		super();

		/***********************************************************************
		 * Prepare all colors
		 **********************************************************************/
		final IToken it_operator = new Token(new TextAttribute(provider
				.getColor(ColorManager.RGB_OPERATOR)));
		final IToken it_type = new Token(new TextAttribute(provider
				.getColor(ColorManager.RGB_TYPE)));
		final IToken it_object = new Token(new TextAttribute(provider
				.getColor(ColorManager.RGB_OBJECT)));
		final IToken it_objectReference = new Token(new TextAttribute(provider
				.getColor(ColorManager.RGB_OBJECT_REFERENCE)));

		List list = new ArrayList();

		{
			/*******************************************************************
			 * Add word rule for Keywords
			 ******************************************************************/
			WordRule wordRule = new WordRule(new MixedWordDetector()) {
				protected OperatorDetector oDetector = new OperatorDetector();
				
				public IToken evaluate(ICharacterScanner scanner) {
				
					if (false) {
						return super.evaluate(scanner);
					}

					// if current character isn't the first of current row,
					// read the previous one and check that it's a white space or an operator
					if (scanner.getColumn() != 0) {
						scanner.unread();
						int c = scanner.read();
					
						if (!Character.isWhitespace((char) c) && !oDetector.isWordStart((char) c)) {
							return Token.UNDEFINED;
						}
					}
					
					return super.evaluate(scanner);
				}
			};
			// OBJECT REFERENCES
			for (int i = 0; i < objRefKeywords.length; i++) {
				wordRule.addWord(objRefKeywords[i], it_objectReference);
			}

			// OBJECT
			for (int i = 0; i < objKeywords.length; i++) {
				wordRule.addWord(objKeywords[i], it_object);
			}

			// OTHER TYPES
			for (int i = 0; i < typeKeywords.length; i++) {
				wordRule.addWord(typeKeywords[i], it_type);
			}
			list.add(wordRule);
		}

		{
			/*******************************************************************
			 * Add word rule for Operators
			 ******************************************************************/
			WordRule operatorRule = new WordRule(new OperatorDetector());
			for (int i = 0; i < typeKeywords.length; i++) {
				operatorRule.addWord(operatorKeywords[i], it_operator);
			}
			list.add(operatorRule);
		}

		// set all rules
		setRules((IRule[]) list.toArray(new IRule[list.size()]));
	}
}