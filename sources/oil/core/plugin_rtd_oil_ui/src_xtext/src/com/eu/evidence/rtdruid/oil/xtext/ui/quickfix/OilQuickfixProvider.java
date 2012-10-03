
package com.eu.evidence.rtdruid.oil.xtext.ui.quickfix;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.FindReplaceDocumentAdapter;
import org.eclipse.jface.text.IRegion;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.ICaseInsensitivityHelper;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.model.edit.ISemanticModification;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.ui.editor.quickfix.ReplaceModification;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.Issue;

import com.eu.evidence.rtdruid.oil.xtext.model.Range;
import com.eu.evidence.rtdruid.oil.xtext.parser.ILineConverterHelper;
import com.eu.evidence.rtdruid.oil.xtext.parser.Utils;
import com.eu.evidence.rtdruid.oil.xtext.validation.IValidationCodes;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

public class OilQuickfixProvider extends DefaultQuickfixProvider {
	
	private static final Logger logger = Logger.getLogger(OilQuickfixProvider.class);

	@Fix(IValidationCodes.AddQuotesToReferce_parametervalue)
	public void addQuotesToParameterValue(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Add quotes", "Transform the reference to a String adding quotes.", null, new IModification() {
			@Override
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
			@Override
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
			@Override
			public void apply(IModificationContext context) throws BadLocationException {
				IXtextDocument xtextDocument = context.getXtextDocument();
				xtextDocument.replace(issue.getOffset(), issue.getLength(), "");
			}
		});
// 		disabled because can be dangerous to change implementation section 
//		acceptor.accept(issue, "Add WITH_AUTO", "Add WITH_AUTO AUTO keyword.", null, new ISemanticModification() {
//			@Override
//			public void apply(EObject element, IModificationContext context) throws Exception {
//				ParameterType type = null;
//				if (element instanceof Parameter) {
//					type = ((Parameter) element).getType();
//				} else if (element instanceof ParameterType) {
//					type = (ParameterType) element;
//				} 
//				if (type != null) {
//					type.setWithAuto(true);
//				}
//			}
//		});
	}

	@Fix(IValidationCodes.MissingCpuSection) 
	public void addCpuSection(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Add CPU", "Add CPU Section.", null, new IModification() {
			@Override
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
	
	@Fix(IValidationCodes.ReplaceWithAValidValue)
	public void replaceValue(final Issue issue, IssueResolutionAcceptor acceptor) {
		for (final String s: issue.getData()) {
			acceptor.accept(issue, "Change to " + s, "Replace the current value with <b>" + s + "</b>.", null, new IModification() {
				@Override
				public void apply(IModificationContext context) throws BadLocationException {
					IXtextDocument xtextDocument = context.getXtextDocument();
					xtextDocument.replace(issue.getOffset(), issue.getLength(), s);
				}
			});	
		}
	}

	@Fix(IValidationCodes.InvertRangeBoundaries)
	public void invertRangeBoundaries(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Invert boundaries", "Invert the boudnaries", null, new ISemanticModification() {
			@Override
			public void apply(EObject element, IModificationContext context) throws Exception {
				if (element instanceof Range) {
					Range range = (Range) element;
					final String min = range.getMin();
					final String max = range.getMax();
					range.setMin(max);
					range.setMax(min);
				}
			}
		});	
	}
	
	
	// --------------------------------
	@Inject
	private ICaseInsensitivityHelper oilCaseInsensitivityHelper;
	@Inject
	private IValueConverterService oilValueConverter;
	
	private static Method findCrossReferenceMethod;
	
	static {
		try {
			findCrossReferenceMethod = DefaultQuickfixProvider.class.getDeclaredMethod("findCrossReference", new Class<?>[] {EObject.class, INode.class});
			findCrossReferenceMethod.setAccessible(true);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

	}


	/*
	 * Override this method in order to fix the usage of issue.getOffset(), used by parent method as both editor and model offset
	 * 
	 * (non-Javadoc)
	 * @see org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider#createLinkingIssueResolutions(org.eclipse.xtext.validation.Issue, org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor)
	 */
	@Override
	public void createLinkingIssueResolutions(final Issue issue, final IssueResolutionAcceptor issueResolutionAcceptor) {

		
		final IModificationContext modificationContext = getModificationContextFactory().createModificationContext(issue);
		final IXtextDocument xtextDocument = modificationContext.getXtextDocument();
		if (xtextDocument == null)
			return;
		xtextDocument.readOnly(new IUnitOfWork.Void<XtextResource>() {
			@Override
			public void process(XtextResource state) throws Exception {
				EObject target = state.getEObject(issue.getUriToProblem().fragment());
				EReference reference = getUnresolvedEReference(issue, target);
				if (reference == null)
					return;
				boolean caseInsensitive = oilCaseInsensitivityHelper.isIgnoreCase(reference);
				EObject crossReferenceTerminal = getCrossReference(issue, target);
				String ruleName = null;
				Keyword keyword = null;
				if (crossReferenceTerminal instanceof RuleCall) {
					RuleCall ruleCall = (RuleCall) crossReferenceTerminal;
					ruleName = ruleCall.getRule().getName();
				} else if (crossReferenceTerminal instanceof Keyword) {
					keyword = (Keyword) crossReferenceTerminal;
				}
				String issueString = xtextDocument.get(issue.getOffset(), issue.getLength());
				IScope scope = getScopeProvider().getScope(target, reference);
				List<IEObjectDescription> discardedDescriptions = Lists.newArrayList();
				Set<String> qualifiedNames = Sets.newHashSet();
				int addedDescriptions = 0;
				int checkedDescriptions = 0;
				for (IEObjectDescription referableElement : queryScope(scope)) {
					String referableElementQualifiedName = getQualifiedNameConverter().toString(referableElement.getQualifiedName());
					if (getSimilarityMatcher().isSimilar(issueString, getQualifiedNameConverter().toString(referableElement.getName()))) {
						addedDescriptions++;
						createResolution(issueString, referableElement, ruleName, keyword, caseInsensitive);
						qualifiedNames.add(referableElementQualifiedName);
					} else {
						if (qualifiedNames.add(referableElementQualifiedName))
							discardedDescriptions.add(referableElement);
					}
					checkedDescriptions++;
					if (checkedDescriptions>100)
						break;
				}
				if (discardedDescriptions.size() + addedDescriptions <= 5) {
					for(IEObjectDescription referableElement: discardedDescriptions) {
						createResolution(issueString, referableElement, ruleName, keyword, caseInsensitive);
					}
				}
			}

			protected AbstractElement getCrossReference(final Issue issue, EObject target) {
				final ICompositeNode node = NodeModelUtils.getNode(target);
				if (node == null)
					throw new IllegalStateException("Cannot happen since we found a reference");
				ICompositeNode rootNode = node.getRootNode();
				// convert editorOffset to modelOffset
				final int modelOffset;
				ILineConverterHelper helper = Utils.getLineHelper(rootNode);
				if (helper != null) {
					modelOffset = helper.getFullIndex(issue.getOffset()+1);
				} else {
					modelOffset = issue.getOffset()+1;
				}

				ILeafNode leaf = NodeModelUtils.findLeafNodeAtOffset(rootNode, modelOffset);
				CrossReference crossReference = privateFindCrossReference(target, leaf);
				return crossReference.getTerminal();
			}

			public void createResolution(String issueString, IEObjectDescription solution, String ruleName, Keyword keyword, boolean caseInsensitive) {
				String replacement = getQualifiedNameConverter().toString(solution.getName());
				String replaceLabel = fixCrossReferenceLabel(issueString, replacement);
				if (keyword != null) {
					if (caseInsensitive && !replacement.equalsIgnoreCase(keyword.getValue()))
						return;
					if (!caseInsensitive && !replacement.equals(keyword.getValue()))
						return;
				} else if (ruleName != null) {
					replacement = oilValueConverter.toString(replacement, ruleName);
				} else {
					logger.error("either keyword or ruleName have to present", new IllegalStateException());
				}
				issueResolutionAcceptor.accept(issue, replaceLabel, replaceLabel, fixCrossReferenceImage(
						issueString, replacement), new ReplaceModification(issue, replacement));
			}

		});
	}
	

	/*
	 * Override this method in order to fix the usage of issue.getOffset(), used by parent method as both editor and model offset
	 * 
	 * (non-Javadoc)
	 * @see org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider#getUnresolvedEReference(org.eclipse.xtext.validation.Issue, org.eclipse.emf.ecore.EObject)
	 */
	@Override
	protected EReference getUnresolvedEReference(final Issue issue, EObject target) {
		final ICompositeNode node = NodeModelUtils.getNode(target);
		if (node==null)
			return null;
		ICompositeNode rootNode = node.getRootNode();
		
		// convert editorOffset to modelOffset
		final int modelOffset;
		ILineConverterHelper helper = Utils.getLineHelper(rootNode);
		if (helper != null) {
			modelOffset = helper.getFullIndex(issue.getOffset()+1);
		} else {
			modelOffset = issue.getOffset()+1;
		}

		ILeafNode leaf = NodeModelUtils.findLeafNodeAtOffset(rootNode, modelOffset);
		CrossReference crossReference = privateFindCrossReference(target, leaf);
		if (crossReference != null) {
			return  GrammarUtil.getReference(crossReference, target.eClass());
		}
		return null;
	}

	/**
	 * A method to invoke super.findCrossReference() method
	 * 
	 * @param context
	 * @param node
	 * @return
	 */
	private CrossReference privateFindCrossReference(EObject context, INode node) {
		try {
			return (CrossReference) findCrossReferenceMethod.invoke(this, new Object[] {context, node});
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return null;
	}
}
