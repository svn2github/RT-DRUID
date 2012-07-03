/**
 * 28/giu/2012
 */
package com.eu.evidence.rtdruid.oil.xtext.services;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.eu.evidence.rtdruid.desk.IModelValidator;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class OilModelValidator implements IModelValidator {
	
	protected List<Issue> issues = null;
	
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.oil.xtext.services.IModelValidator#validate(java.io.InputStream)
	 */
	@Override
	public boolean validate(InputStream input) throws IOException {
		validate(OilModelLoader.instance.load(null,input,null));
		return !containsErrors();
	}
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.oil.xtext.services.IModelValidator#validate(java.lang.String)
	 */
	@Override
	public boolean validate(String input) throws IOException {
		return validate(new ByteArrayInputStream(input.getBytes()));
	}
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.oil.xtext.services.IModelValidator#containsErrors()
	 */
	@Override
	public boolean containsErrors() {
		return !(filter(issues, Severity.ERROR).isEmpty());
	}
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.oil.xtext.services.IModelValidator#containsWarnings()
	 */
	@Override
	public boolean containsWarnings() {
		return !(filter(issues, Severity.WARNING).isEmpty()); 
	}
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.oil.xtext.services.IModelValidator#getReport()
	 */
	@Override
	public String getReport() {
		if (issues.size() == 0)
			return "No issues";
		
		StringBuffer sb = new StringBuffer();
		sb.append("Issues:");
		for (Issue issue : issues) {
			sb.append("\n  - "+ issue.getSeverity() + "( line "+issue.getLineNumber()+"): " +issue.getMessage());
		}
		return sb.toString();
	}
	
	
	protected void validate(EObject model) {
		IResourceValidator validator = ((XtextResource) model.eResource()).getResourceServiceProvider()
				.getResourceValidator();
		issues = validator.validate(model.eResource(), CheckMode.ALL, CancelIndicator.NullImpl);
	}
	
	private List<Issue> filter(List<Issue> list, Severity type) {
		List<Issue> answer = new ArrayList<Issue>();
		if (list != null) {
			for (Issue elem : list) {
				if (elem.getSeverity() == type) {
					answer.add(elem);
				}
			}
		}
		return answer;
	}
}
	