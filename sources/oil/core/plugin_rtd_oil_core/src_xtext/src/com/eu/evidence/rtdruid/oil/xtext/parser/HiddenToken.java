/**
 * 05/set/2012
 */
package com.eu.evidence.rtdruid.oil.xtext.parser;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;


/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class HiddenToken extends CommonToken {
	
	protected int fullStart = -1;
	protected int fullStop = -1;
	protected int fullStartLine;
	protected int fullStartCharIndex;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4329050118362780541L;

	public HiddenToken(int type) {
		super(type);
	}

	public HiddenToken(CharStream input, int type, int channel, int start, int stop) {
		super(input, type, channel, start, stop);
	}

	public HiddenToken(int type, String text) {
		super(type, text);
	}

	public HiddenToken(Token oldToken) {
		super(oldToken);
	}
	
	/**
	 * @param fullStart the fullStart to set
	 */
	public void setFullStart(int fullStart) {
		this.fullStart = fullStart;
	}
	
	/**
	 * @param fullStartCharIndex the fullStartCharIndex to set
	 */
	public void setFullStartCharPositionLine(int fullStartCharPositionLine) {
		this.fullStartCharIndex = fullStartCharPositionLine;
	}
	
	/**
	 * @param fullStartLine the fullStartLine to set
	 */
	public void setFullStartLine(int fullStartLine) {
		this.fullStartLine = fullStartLine;
	}
	
	/**
	 * @param fullStop the fullStop to set
	 */
	public void setFullStop(int fullStop) {
		this.fullStop = fullStop;
	}
	
	/* (non-Javadoc)
	 * @see org.antlr.runtime.CommonToken#getText()
	 */
	@Override
	public String getText() {
		if ( text!=null ) {
			return text;
		}
		if ( input==null || fullStart == -1 || fullStop == -1) {
			return null;
		}
		text = input.substring(fullStart,fullStop);
		return text;
	}
}
