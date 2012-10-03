/**
 * 26/set/2012
 */
package com.eu.evidence.rtdruid.oil.xtext.ui.contentassist;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.Token;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.RootNode;
import org.eclipse.xtext.resource.DerivedStateAwareResource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.IContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.ParserBasedContentAssistContextFactory.StatefulFactory;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
import org.eclipse.xtext.util.Strings;

import com.eu.evidence.rtdruid.oil.xtext.parser.ILineConverterHelper;
import com.eu.evidence.rtdruid.oil.xtext.parser.Utils;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class OilStatefulFactory extends StatefulFactory {

	private static Field completionOffsetField;
	private static Field selectionField;
	private static Field currentNodeField;
	private static Field currentModelField;
	private static Field lastCompleteNodeField;
	private static Field datatypeNodeField;
	private static Field lexerField;
	private static Field parserField;
	private static Field contextBuildersField;

	
	static {
		try {
			completionOffsetField = StatefulFactory.class.getDeclaredField("completionOffset");
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		completionOffsetField.setAccessible(true);
		
		try {
			selectionField = StatefulFactory.class.getDeclaredField("selection");
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		selectionField.setAccessible(true);
		
		try {
			currentNodeField = StatefulFactory.class.getDeclaredField("currentNode");
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		currentNodeField.setAccessible(true);
		try {
			currentModelField = StatefulFactory.class.getDeclaredField("currentModel");
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		currentModelField.setAccessible(true);
		try {
			lastCompleteNodeField = StatefulFactory.class.getDeclaredField("lastCompleteNode");
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		lastCompleteNodeField.setAccessible(true);
		try {
			datatypeNodeField = StatefulFactory.class.getDeclaredField("datatypeNode");
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		datatypeNodeField.setAccessible(true);
		try {
			lexerField = StatefulFactory.class.getDeclaredField("lexer");
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		lexerField.setAccessible(true);
		try {
			parserField = StatefulFactory.class.getDeclaredField("parser");
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		parserField.setAccessible(true);
		
		
		try {
			contextBuildersField = StatefulFactory.class.getDeclaredField("contextBuilders");
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		contextBuildersField.setAccessible(true);
		
	}

	
	/**
	 *  The offset related to the editor content 
	 */
	private int editorOffset;
	/**
	 *  The offset related to the model content 
	 */
	private int modelOffset;
	
	/**
	 *  The offset related to the model content 
	 */
	private int origCompletitionOffset = Integer.MIN_VALUE;
	
	/**
	 * The model text
	 */
	private String oilCompleteText;

	/**
	 * The model text
	 */
	private ICompositeNode oilRootNode;

	
	/**
	 * The line converter
	 */
	private ILineConverterHelper helper;
	
	
	/* (non-Javadoc)
	 * @see org.eclipse.xtext.ui.editor.contentassist.antlr.ParserBasedContentAssistContextFactory.StatefulFactory#create(org.eclipse.jface.text.ITextViewer, int, org.eclipse.xtext.resource.XtextResource)
	 */
	@Override
	public ContentAssistContext[] create(ITextViewer viewer, int offset, XtextResource resource)
			throws BadLocationException {
		
		//This is called to make sure late initialization is done.
		if (resource instanceof DerivedStateAwareResource) {
			resource.getContents();
		}
		
		editorOffset = offset;
		
		helper = Utils.getLineHelper(resource.getParseResult());
		modelOffset = helper == null ? offset : helper.getFullIndex(editorOffset);
		
		if (modelOffset != editorOffset) {
			oilRootNode = resource.getParseResult().getRootNode();
			oilCompleteText = ((RootNode)oilRootNode).getCompleteContent();
		}
		
		return super.create(viewer, offset, resource);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.xtext.ui.editor.contentassist.antlr.ParserBasedContentAssistContextFactory.StatefulFactory#initializeAndAdjustCompletionOffset(int)
	 */
	@Override
	protected void initializeAndAdjustCompletionOffset(int offset) {
		super.initializeAndAdjustCompletionOffset(offset);

		if (editorOffset != modelOffset) {
			// replace the content of completionOffset with the offset related to the model
			if (origCompletitionOffset == Integer.MIN_VALUE) {
				origCompletitionOffset = getPrivateInt(completionOffsetField);
				if (origCompletitionOffset == editorOffset) {
					setPrivateValue(completionOffsetField, modelOffset);
				} else {
					setPrivateValue(completionOffsetField, helper == null ? offset : helper.getFullIndex(origCompletitionOffset));
				}
			}
		}
	}
	
	
	/* (non-Javadoc)
	 * @see org.eclipse.xtext.ui.editor.contentassist.antlr.ParserBasedContentAssistContextFactory.StatefulFactory#initializeAndAdjustCompletionOffset(int)
	 */
	@Override
	protected void createContextsForLastCompleteNode(EObject previousModel, boolean strict) throws BadLocationException {
		
		if (editorOffset == modelOffset) {
			super.createContextsForLastCompleteNode(previousModel, strict);
		} else {
			/*
			 * Obtain parent private variables required by this method 
			 */
			final INode priv_currentNode = (INode) getPrivateValue(currentNodeField);
			final INode priv_lastCompleteNode = (INode) getPrivateValue(lastCompleteNodeField);
			final Lexer priv_lexer = (Lexer) getPrivateValue(lexerField);
			final IContentAssistParser priv_parser = (IContentAssistParser) getPrivateValue(parserField);
			
			/*
			 * The code is a copy of the parent method, except that the complete text comes from model text (not from editor)
			 */
			String currentNodePrefix = getPrefix(priv_currentNode);
			if (!Strings.isEmpty(currentNodePrefix) && !priv_currentNode.getText().equals(currentNodePrefix)) {
				priv_lexer.setCharStream(new ANTLRStringStream(currentNodePrefix));
				Token token = priv_lexer.nextToken();
				if (token == Token.EOF_TOKEN) { // error case - nothing could be parsed
					return;
				}
				while(token != Token.EOF_TOKEN) {
					if (isErrorToken(token))
						return;
					token = priv_lexer.nextToken();
				}
			}
			String prefix = "";
			String completeInput = oilCompleteText.substring(0, getPrivateInt(completionOffsetField));
			Collection<FollowElement> followElements = priv_parser.getFollowElements(completeInput, strict);
			doCreateContexts(priv_lastCompleteNode, priv_currentNode, prefix, previousModel, followElements);
		}
	}
		
	
	/* (non-Javadoc)
	 * @see org.eclipse.xtext.ui.editor.contentassist.antlr.ParserBasedContentAssistContextFactory.StatefulFactory#initializeAndAdjustCompletionOffset(int)
	 */
	@Override
	public ContentAssistContext.Builder doCreateContext(
			INode lastCompleteNode, 
			EObject currentModel, EObject previousModel,
			INode currentNode, String prefix) {
		ContentAssistContext.Builder context = super.doCreateContext(lastCompleteNode, currentModel, previousModel, currentNode, prefix); 
				
		if (editorOffset != modelOffset) {
			context.setOffset(origCompletitionOffset);
			
			ITextSelection selection = (ITextSelection) getPrivateValue(selectionField);
			int regionLength = prefix.length();
			if (selection.getLength() > 0)
				regionLength = regionLength + selection.getLength();
			Region region = new Region(origCompletitionOffset - prefix.length(), regionLength);
			context.setReplaceRegion(region);
		}
		
		
		return context;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.xtext.ui.editor.contentassist.antlr.ParserBasedContentAssistContextFactory.StatefulFactory#getNodeTextUpToCompletionOffset(org.eclipse.xtext.nodemodel.INode)
	 */
	@Override
	public String getNodeTextUpToCompletionOffset(INode currentNode) {
		if (editorOffset == modelOffset) {
			return super.getNodeTextUpToCompletionOffset(currentNode);
		} else {
			/*
			 * The code is a copy of the parent method, except that the complete text comes from model text (not from editor)
			 */
			
			int startOffset = currentNode.getOffset();
			int length = modelOffset - startOffset;
			String nodeText = ((ILeafNode) currentNode).getText();
			String trimmedNodeText = length > nodeText.length() ? nodeText : nodeText.substring(0, length);
			
			try {
				String text = oilCompleteText.substring(startOffset, startOffset+ trimmedNodeText.length());
				if (trimmedNodeText.equals(text))
					return text;
				return oilCompleteText.substring(startOffset, startOffset+ length);
			} catch (IndexOutOfBoundsException e) {
//				log.error(e.getMessage(), e);
			}
			
			return trimmedNodeText;
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.xtext.ui.editor.contentassist.antlr.ParserBasedContentAssistContextFactory.StatefulFactory#handleLastCompleteNodeIsAtEndOfDatatypeNode()
	 */
	@Override
	protected void handleLastCompleteNodeIsAtEndOfDatatypeNode() throws BadLocationException {
		if (editorOffset == modelOffset) {
			super.handleLastCompleteNodeIsAtEndOfDatatypeNode();
		} else {
			/*
			 * Obtain parent private variables required by this method 
			 */
			final INode priv_currentNode = (INode) getPrivateValue(currentNodeField);
			final INode priv_lastCompleteNode = (INode) getPrivateValue(lastCompleteNodeField);
			final IContentAssistParser priv_parser = (IContentAssistParser) getPrivateValue(parserField);
			@SuppressWarnings({ "unchecked", "rawtypes" })
			final List<ContentAssistContext.Builder> priv_contextBuilders = (List) getPrivateValue(contextBuildersField);
			
			/*
			 * The code is a copy of the parent method, except that the complete text comes from model text (not from editor)
			 */
			
			String prefix = getPrefix(priv_lastCompleteNode);
			String completeInput = oilCompleteText.substring(0, priv_lastCompleteNode.getOffset());
			INode previousNode = getLastCompleteNodeByOffset(oilRootNode, priv_lastCompleteNode.getOffset());
			EObject previousModel = previousNode.getSemanticElement();
			INode currentDatatypeNode = getContainingDatatypeRuleNode(priv_currentNode);
			Collection<FollowElement> followElements = priv_parser.getFollowElements(completeInput, false);
			int prevSize = priv_contextBuilders.size();
			doCreateContexts(previousNode, currentDatatypeNode, prefix, previousModel, followElements);
			
			if (priv_lastCompleteNode instanceof ILeafNode && priv_lastCompleteNode.getGrammarElement() == null && priv_contextBuilders.size() != prevSize) {
				handleLastCompleteNodeHasNoGrammarElement(priv_contextBuilders.subList(prevSize, priv_contextBuilders.size()), previousModel);
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.xtext.ui.editor.contentassist.antlr.ParserBasedContentAssistContextFactory.StatefulFactory#handleLastCompleteNodeAsPartOfDatatypeNode()
	 */
	@Override
	protected void handleLastCompleteNodeAsPartOfDatatypeNode() throws BadLocationException {
		if (editorOffset == modelOffset) {
			super.handleLastCompleteNodeAsPartOfDatatypeNode();
		} else {
			/*
			 * Obtain parent private variables required by this method 
			 */
			final INode priv_datatypeNode = (INode) getPrivateValue(datatypeNodeField);
			final EObject priv_currentModel = (EObject) getPrivateValue(currentModelField);
			final IContentAssistParser priv_parser = (IContentAssistParser) getPrivateValue(parserField);
			
			/*
			 * The code is a copy of the parent method, except that the complete text comes from model text (not from editor)
			 */
			String prefix = getPrefix(priv_datatypeNode);
			String completeInput = oilCompleteText.substring(0, priv_datatypeNode.getOffset());
			Collection<FollowElement> followElements = priv_parser.getFollowElements(completeInput, false);
			INode lastCompleteNodeBeforeDatatype = getLastCompleteNodeByOffset(oilRootNode, priv_datatypeNode.getTotalOffset());
			doCreateContexts(lastCompleteNodeBeforeDatatype, priv_datatypeNode, prefix, priv_currentModel, followElements);
		}

	}
	
	
	//---------------------------------------------
	
	/**
	 * A method to force the value of "private" variable. Required to set the correct value of variables like the current node
	 * 
	 * @param field
	 * @param value
	 */
	private int getPrivateInt(Field field) {
		try {
			return field.getInt(this);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	
	/**
	 * A method to force the value of "private" variable. Required to set the correct value of variables like the current node
	 * 
	 * @param field
	 * @param value
	 */
	private Object getPrivateValue(Field field) {
		try {
			return field.get(this);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * A method to force the value of "private" variable. Required to set the correct value of variables like the current node
	 * 
	 * @param field
	 * @param value
	 */
	private void setPrivateValue(Field field, int value) {
		try {
			field.set(this, value);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

}
