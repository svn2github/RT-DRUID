
package com.eu.evidence.rtdruid.oil.xtext.ui.quickfix;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.FindReplaceDocumentAdapter;
import org.eclipse.jface.text.IRegion;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.validation.Issue;

import com.eu.evidence.rtdruid.oil.xtext.validation.IValidationCodes;

public class OilQuickfixProvider extends DefaultQuickfixProvider {

	@Fix(IValidationCodes.AddQuotesToReferce_parametervalue)
	public void addQuotesToParameterValue(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Add quotes", "Transform the reference to a String adding quotes.", null, new IModification() {
			public void apply(IModificationContext context) throws BadLocationException {
				IXtextDocument xtextDocument = context.getXtextDocument();
				String txt = xtextDocument.get(issue.getOffset(), issue.getLength());
				xtextDocument.replace(issue.getOffset(), issue.getLength(), "\""+txt+"\"");
			}
		});
	}
	
	@Fix(IValidationCodes.RemoveQuotesToReferce_parametervalue)
	public void removeQuotesFromParameterValue(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Remove quotes", "Transform the string to reference removing quotes.", null, new IModification() {
			public void apply(IModificationContext context) throws BadLocationException {
				IXtextDocument xtextDocument = context.getXtextDocument();
				String txt_orig = xtextDocument.get(issue.getOffset(), issue.getLength());
				int init_offset = txt_orig.startsWith("\"") ? 1 : 0;
				int end_offset = txt_orig.endsWith("\"") ? 1 : 0;
				String txt = xtextDocument.get(issue.getOffset()+init_offset, issue.getLength()-(init_offset+end_offset));
				xtextDocument.replace(issue.getOffset(), issue.getLength(), txt);
			}
		});
	}
	
	
	@Fix(IValidationCodes.MissingWithAuto_valueType)
	public void capitalizeName(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Remove AUTO", "Remove AUTO keyword.", null, new IModification() {
			public void apply(IModificationContext context) throws BadLocationException {
				IXtextDocument xtextDocument = context.getXtextDocument();
				xtextDocument.replace(issue.getOffset(), issue.getLength(), "");
			}
		});
	}

	@Fix(IValidationCodes.MissingCpuSection) 
	public void addCpuSection(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Add CPU", "Add CPU Section.", null, new IModification() {
			public void apply(IModificationContext context) throws BadLocationException {
				IXtextDocument xtextDocument = context.getXtextDocument();
				FindReplaceDocumentAdapter finder = new FindReplaceDocumentAdapter(xtextDocument); 
				IRegion reg = finder.find(-1, ";", false, false, false, false);
				int position = xtextDocument.getLength()-1;
				if (reg != null) {
					position = reg.getOffset()+1;
				}
				xtextDocument.replace(position, 0, "\nCPU ee {\n};" );
			}
		});
	}
}
