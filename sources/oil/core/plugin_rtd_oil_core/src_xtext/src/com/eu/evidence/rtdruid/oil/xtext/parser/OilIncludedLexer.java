/**
 * 10/lug/2012
 */
package com.eu.evidence.rtdruid.oil.xtext.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;

import com.eu.evidence.rtdruid.oil.xtext.parser.antlr.internal.InternalOilLexer;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class OilIncludedLexer extends InternalOilLexer {
	
	protected class LocalState {
		int tokenStartCharIndex = -1;
		int tokenStartCharPositionInLine = -1;
		int tokenStartLine = -1;

	};
	LocalState localState = new LocalState();

    /**
	 * 
	 */
	private static final int INCLUDE_PREFIX_LENGTH = "#include".length();

	public OilIncludedLexer() {;} 
    public OilIncludedLexer(CharStream input) {
        super(input);
//        (new Error()).printStackTrace();
    }
    public OilIncludedLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
//        (new Error()).printStackTrace();

    }
	
    /* (non-Javadoc)
     * @see org.antlr.runtime.Lexer#emit()
     */
    @Override
    public Token emit() {
    	if (input instanceof CharStreamWithInclude) {
	    	Token answer = null;
    		CharStreamWithInclude cinput = ((CharStreamWithInclude) input);
			// store the position
    		cinput.storePosition();

    		if (false) {
	    		CommonToken parentToken = cinput.getLastCharParentIncludeToken();
	    		if (parentToken != null) {
	    			HiddenToken t = new HiddenToken(input, state.type, Token.HIDDEN_CHANNEL, parentToken.getStartIndex(),  parentToken.getStopIndex());
		    		t.setLine(parentToken.getLine());
		    		t.setText(state.text);
		    		t.setCharPositionInLine(parentToken.getCharPositionInLine());
	
		    		t.setFullStart(state.tokenStartCharIndex);
		    		t.setFullStop(getCharIndex()-1);
		    		t.setFullStartCharPositionLine(state.tokenStartCharPositionInLine);
		    		t.setFullStartLine(state.tokenStartLine);
		    		
		    		answer = t;
	    		}
		    	
		    	if (answer == null) {
		    		// else "almost" super.emit()
					Token t = new CommonToken(input, state.type, state.channel, localState.tokenStartCharIndex, cinput.getLocalIndex()-1);
					t.setLine(localState.tokenStartLine);
					t.setText(input.substring(state.tokenStartCharIndex, getCharIndex()-1));
					t.setCharPositionInLine(localState.tokenStartCharPositionInLine);
					
					answer = t;
		    	}
    		}
    		
    		else {
	    		CommonToken parentToken = cinput.getLastCharParentIncludeToken();
	    		if (parentToken != null) {
	    			HiddenToken t = new HiddenToken(input, state.type, Token.HIDDEN_CHANNEL, state.tokenStartCharIndex,  getCharIndex()-1);
		    		t.setLine(parentToken.getLine());
		    		t.setText(state.text);
		    		t.setCharPositionInLine(parentToken.getCharPositionInLine());
	
		    		t.setFullStart(state.tokenStartCharIndex);
		    		t.setFullStop(getCharIndex()-1);
		    		t.setFullStartCharPositionLine(state.tokenStartCharPositionInLine);
		    		t.setFullStartLine(state.tokenStartLine);
		    		
		    		answer = t;
	    		}
		    	
		    	if (answer == null) {
		    		// else "almost" super.emit()
					Token t = new CommonToken(input, state.type, state.channel, state.tokenStartCharIndex,  getCharIndex()-1);
					t.setLine(localState.tokenStartLine);
					t.setText(input.substring(state.tokenStartCharIndex, getCharIndex()-1));
					t.setCharPositionInLine(localState.tokenStartCharPositionInLine);
					
					answer = t;
		    	}
    			
    		}
    		
    		
			emit(answer);
			return answer;
			
		} else {
			return super.emit();
		}		

    }
    
    /* (non-Javadoc)
     * @see org.antlr.runtime.Lexer#emit(org.antlr.runtime.Token)
     */
    @Override
    public void emit(Token token) {
    	super.emit(token);
    	
    	if (token.getType() == RULE_INCLUDE) {
    		String text = token.getText();
    		text = getIncludeText(text);
    		System.out.println("Trovato file " + text);
    		if (text.isEmpty()) {
//    			throw new 
    			reportError(new RecognitionException(input));
    		}
    		
    		if (input instanceof CharStreamWithInclude && token instanceof CommonToken) {
    			
    			if (text.trim().length()>0) {
	    			URI uri = ((CharStreamWithInclude) input).getCurrentStreamUri();
	    			if (uri != null) {
		    			String fileWsPath = uri.toPlatformString(false);
		    			String fileFsPath = uri.toFileString();
		    			if (fileWsPath != null) {
		    				IResource res = ResourcesPlugin.getWorkspace().getRoot().findMember(fileWsPath);
		    				IContainer container = res.getParent();
		    				res = container.findMember(text);
		    				if (res != null && res instanceof IFile) {
		    					try {
									((CharStreamWithInclude) input).setStream(
											URI.createPlatformResourceURI(res.getFullPath().toString(), false),
											new ANTLRInputStream(((IFile)res).getContents()),
											(CommonToken) token);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (CoreException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
		    				}
			    			
		    			} else if (fileFsPath != null) {
		    				
		    				
		    				// convert the file name in a File (and then in the absolute path)
		    				IPath p = new Path(text);
		    				if (!p.isAbsolute()) {
		    					p = new Path(fileFsPath);
		    					p = p.removeLastSegments(1).append(text);
		    				}
		    				
		    				
		    				File f = p.toFile();
		    				if (f != null && f.exists() && f.isFile() && f.canRead()) {
		    					try {
									((CharStreamWithInclude) input).setStream(URI.createFileURI(p.toOSString()), new ANTLRInputStream(new FileInputStream(f)));
								} catch (FileNotFoundException e) {
									e.printStackTrace();
								} catch (IOException e) {
									e.printStackTrace();
								}
		    				} else {
	    						reportError(new RecognitionException(input));
		    				}
		    			}
	    			}
    			}
//    			URI fpath  
    			
    			System.out.println("E' uno stream con supporto per l'include -> " + ((CharStreamWithInclude) input).getCurrentStreamUri() );
    		} else {
    			System.out.println("E' uno stream generico -> " + input );
    		}
    	}
    	
    }
	/**
	 * @param text
	 * @return
	 */
	public static String getIncludeText(String text) {
		text = text.substring(INCLUDE_PREFIX_LENGTH).trim();
		text = text.substring(1, text.length()-1);
		return text;
	}

    /* (non-Javadoc)
	 * @see org.antlr.runtime.Lexer#setCharStream(org.antlr.runtime.CharStream)
	 */
	@Override
	public void setCharStream(CharStream input) {
		if (!(input instanceof CharStreamWithInclude)) {
			CharStreamWithInclude newInput = new CharStreamWithInclude();
			String fname = input.getSourceName();
			URI uri = null;
			if (fname != null) {
				uri = URI.createFileURI(fname);
			}
			newInput.setStream(uri, input);
			input = newInput;
		}
		
		super.setCharStream(input);
	}
	
	public void setStreamName(URI name) {
		if (input instanceof CharStreamWithInclude) {
			((CharStreamWithInclude) input).setCurrentStreamUri(name);
		} else {
			CharStreamWithInclude newInput = new CharStreamWithInclude();
			newInput.setStream(name, input);
			input = newInput;
		}

	}
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.oil.xtext.parser.antlr.internal.InternalOilLexer#mTokens()
	 */
	@Override
	public void mTokens() throws RecognitionException {
		// save local State
		if ((input instanceof CharStreamWithInclude)) {
			CharStreamWithInclude cInput = (CharStreamWithInclude) input;
			this.localState.tokenStartCharIndex = cInput.getLocalIndex();
			this.localState.tokenStartCharPositionInLine = cInput.getLocalCharPositionInLine();
			this.localState.tokenStartLine = cInput.getLocalLine();
			
			// store the position
			cInput.storePosition();

		} else {
			this.localState.tokenStartCharIndex = -1;
		}

		
		super.mTokens();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.xtext.parser.antlr.Lexer#nextToken()
	 */
	@Override
	public Token nextToken() {
		Token answer = super.nextToken();
		if (answer == Token.EOF_TOKEN) {
			if (input instanceof CharStreamWithInclude) {
	    		((CharStreamWithInclude) input).storePosition();
			}
		}
		
		return answer;
	}
	
	/**
	 * @return the lineConverterHelper
	 */
	public ILineConverterHelper getLineConverterHelper() {
		if ((input instanceof CharStreamWithInclude)) {
			return ((CharStreamWithInclude) input).getLineConverterHelper();
		}
		return null;
	}
}
