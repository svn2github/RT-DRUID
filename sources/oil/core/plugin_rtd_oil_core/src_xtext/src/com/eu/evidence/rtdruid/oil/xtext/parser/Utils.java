/**
 * 11/set/2012
 */
package com.eu.evidence.rtdruid.oil.xtext.parser;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;

import com.eu.evidence.rtdruid.oil.xtext.OilStandaloneSetup;
import com.eu.evidence.rtdruid.oil.xtext.services.OilGrammarAccess;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class Utils {

	private static final OilGrammarAccess grammarAccess;
	private static final String includeRuleName;
	
	static {
		grammarAccess = (new OilStandaloneSetup()).createInjector().getInstance(OilGrammarAccess.class);
		includeRuleName = grammarAccess.getINCLUDERule().getName();
	}
	
	public static ILineConverterHelper getLineHelper(INode node) {
		EObject obj = node == null ? null : node.getSemanticElement();
		return obj == null ? null : getLineHelper(obj);
	}
	
	public static ILineConverterHelper getLineHelper(EObject obj) {
		for (EObject parent = obj.eContainer(); parent != null && parent instanceof EObject; parent = obj.eContainer()) {
			obj = parent;
		}

		return getLinerHelperFromRoot(obj);
	}

	public static ILineConverterHelper getLineHelper(IParseResult parseResult) {
		return getLinerHelperFromRoot( parseResult.getRootASTElement());
	}
	
	public static ILineConverterHelper getLineHelper(XtextResource resource) {
		IParseResult parseResult = resource.getParseResult();
		if (parseResult != null)
			return getLineHelper(parseResult);
		return null;
	}
	
	protected static ILineConverterHelper getLinerHelperFromRoot(EObject obj) {
		if (obj != null) {
			
			for (Adapter adapter : obj.eAdapters()) {
				if (adapter instanceof ILineConverterHelper)
					return (ILineConverterHelper) adapter;
			}
		}
		return null;
	}

	public static boolean isIncludeNode(INode node) {
		if (node == null) {
			return false;
		} else {
			EObject grammarElement = node.getGrammarElement(); 
			return grammarElement != null 
					&& grammarElement instanceof TerminalRule 
					&& includeRuleName.equals(((AbstractRule) grammarElement).getName());
		}
	}
	
	public static String getIncludeText(INode node) {
		return isIncludeNode(node) ? OilIncludedLexer.getIncludeText(node.getText()) : null;
	}
}
