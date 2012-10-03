/**
 * 29/set/2012
 */
package com.eu.evidence.rtdruid.oil.xtext.validation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.validation.DiagnosticConverterImpl;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.validation.Issue.IssueImpl;
import org.eclipse.xtext.validation.RangeBasedDiagnostic;

import com.eu.evidence.rtdruid.oil.xtext.parser.ILineConverterHelper;
import com.eu.evidence.rtdruid.oil.xtext.parser.ILineConverterHelper.ILineConvertData;
import com.eu.evidence.rtdruid.oil.xtext.parser.Utils;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class OilDiagnosticConverter extends DiagnosticConverterImpl {

	private static Method getNodeMethod;
	
	static {
		try {
			getNodeMethod = AbstractDiagnostic.class.getDeclaredMethod("getNode", (Class[])null);
			getNodeMethod.setAccessible(true);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.xtext.validation.DiagnosticConverterImpl#convertResourceDiagnostic(org.eclipse.emf.ecore.resource.Resource.Diagnostic, org.eclipse.xtext.diagnostics.Severity, org.eclipse.xtext.util.IAcceptor)
	 */
	@Override
	public void convertResourceDiagnostic(Diagnostic diagnostic, Severity severity, IAcceptor<Issue> acceptor) {
		ILineConverterHelper helper = null;
		if (diagnostic instanceof AbstractDiagnostic) {
			
			INode diagNode = null;
			try {
				diagNode = (INode) getNodeMethod.invoke(diagnostic, (Object[])null);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			}
			
			helper = Utils.getLineHelper(diagNode);
		}
		super.convertResourceDiagnostic(diagnostic, severity, new OilIssueAcceptor(helper, acceptor));
	}
	
	
	protected IssueLocation getLocationData(org.eclipse.emf.common.util.Diagnostic diagnostic) {
		if (diagnostic instanceof RangeBasedDiagnostic) {
			EObject causer = getCauser(diagnostic);
			if (causer != null) {
				RangeBasedDiagnostic castedDiagnostic = (RangeBasedDiagnostic) diagnostic;
				INode parserNode = NodeModelUtils.getNode(causer);

				ILineConverterHelper helper = Utils.getLineHelper(parserNode);
				if (helper != null) {
					IssueLocation result = new IssueLocation();
					
					ILineConvertData start = helper.getMainIndex(castedDiagnostic.getOffset());
					ILineConvertData end = helper.getMainIndex(castedDiagnostic.getOffset()+castedDiagnostic.getLength());
					
					result.lineNumber = start.getLine();
					result.offset = start.getOffset();
					result.length = end.getOffset() - start.getOffset();
					return result;
				}
			}
		}
		// if something fails, use the parent method
		return super.getLocationData(diagnostic);
	}

	
	protected IssueLocation getLocationForNode(INode node) {
		ILineConverterHelper helper = Utils.getLineHelper(node);
		if (helper == null) {
			return super.getLocationForNode(node);
		} else {
			IssueLocation result = new IssueLocation();
			
			ILineConvertData start = helper.getMainIndex(node.getOffset());
			ILineConvertData end = helper.getMainIndex(node.getOffset()+node.getLength());
			
			result.lineNumber = start.getLine();
			result.offset = start.getOffset();
			result.length = end.getOffset() - start.getOffset();
			return result;
		}
	}


	private static class OilIssueAcceptor implements IAcceptor<Issue> {
		
		private IAcceptor<Issue> list;
		private ILineConverterHelper helper;
		
		/**
		 * 
		 */
		public OilIssueAcceptor(ILineConverterHelper helper, IAcceptor<Issue> list) {
			this.helper = helper;
			this.list = list;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.xtext.util.IAcceptor#accept(java.lang.Object)
		 */
		@Override
		public void accept(Issue t) {
			
			if (helper != null && t instanceof IssueImpl) {

				ILineConvertData start = helper.getMainIndex(t.getOffset());
				ILineConvertData end = helper.getMainIndex(t.getOffset()+t.getLength());
				
				((IssueImpl)t).setLineNumber(start.getLine());
				((IssueImpl)t).setOffset(start.getOffset());
				((IssueImpl)t).setLength(end.getOffset() - start.getOffset());
			}
			
			list.accept(t);
		}
	}
}
