/*
 * Created on Jan 26, 2005
 *
 * $Id: OilTextEditorConfiguration.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.ui.editor.text;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DefaultAutoIndentStrategy;
import org.eclipse.jface.text.IAutoIndentStrategy;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.TextPresentation;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.ContextInformation;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposalExtension3;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationPresenter;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.source.IAnnotationHover;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;

/**
 * This class configures many things of an Oil Text Editor, like <b>indentation
 * </b>, <b>syntax's colors </b>, <b>completition </b> and <b>tooltips </b>.
 * 
 * @author Nicola Serreli
 */
class OilTextEditorConfiguration extends SourceViewerConfiguration {

	/** The keyword's scanner */
	final private OilScanner scanner;

	/** The color manager */
	final private ColorManager colorManager;

	/** The parent editor */
	final private OilTextEditor parentEditor;

	/** The Annotation Hover for parent instance of OilTextEditor */
	final private IAnnotationHover annotationHover;

	/** The Presentation reconcilier */
	final private PresentationReconciler reconciler;

	/** The Content Assistant */
	final private ContentAssistant assistant;

	/**
	 * The auto indentation policy. As default just uses the indentation of
	 * previous row.
	 */
	final private DefaultAutoIndentStrategy autoIndentStrategy = new DefaultAutoIndentStrategy();

	// ---------------------------------------------

	/**
	 * Default constructor. Init all internal variables.
	 * 
	 * @param colorManager
	 *            the color manager of parent Editor
	 * @param parent
	 *            the parent editor
	 */
	public OilTextEditorConfiguration(ColorManager colorManager,
			OilTextEditor parent) {
		this.colorManager = colorManager;
		this.parentEditor = parent;
		this.annotationHover = new OilAnnotationHover(parentEditor);

		{ // Init the scanner
			scanner = new OilScanner(colorManager);
			scanner.setDefaultReturnToken(new Token(new TextAttribute(
					colorManager.getColor(ColorManager.RGB_DEFAULT))));
		}

		{ // for each content type, set a Damager/Repairer
			reconciler = new PresentationReconciler();

			// default text
			DefaultDamagerRepairer dr = new DefaultDamagerRepairer(scanner);
			reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
			reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);

			{ // long comments
				PartitionBasedDamagerRepairer ndr = new PartitionBasedDamagerRepairer(
						new TextAttribute(colorManager
								.getColor(ColorManager.RGB_LONG_COMMENT)));
				reconciler
						.setDamager(ndr, OilPartitionScanner.STR_LONG_COMMENT);
				reconciler.setRepairer(ndr,
						OilPartitionScanner.STR_LONG_COMMENT);
			}

			{ // single line comments
				PartitionBasedDamagerRepairer ndr = new PartitionBasedDamagerRepairer(
						new TextAttribute(colorManager
								.getColor(ColorManager.RGB_LINE_COMMENT)));
				reconciler.setDamager(ndr, OilPartitionScanner.STR_COMMENT);
				reconciler.setRepairer(ndr, OilPartitionScanner.STR_COMMENT);
			}

			{ // Strings
				PartitionBasedDamagerRepairer ndr = new PartitionBasedDamagerRepairer(
						new TextAttribute(colorManager
								.getColor(ColorManager.RGB_STRING)));
				reconciler.setDamager(ndr, OilPartitionScanner.STR_STRING);
				reconciler.setRepairer(ndr, OilPartitionScanner.STR_STRING);
			}
		}

		{ // Init content assistant
			assistant = new ContentAssistant();
			assistant.setContentAssistProcessor(new OilCompletionProcessor(),
					IDocument.DEFAULT_CONTENT_TYPE);
			//		assistant.setContentAssistProcessor(new
			// JavaDocCompletionProcessor(),
			// JavaPartitionScanner.JAVA_DOC);

			assistant.enableAutoActivation(true);
			assistant.enablePrefixCompletion(true);
			assistant.setAutoActivationDelay(500);
			assistant
					.setProposalPopupOrientation(IContentAssistant.PROPOSAL_OVERLAY);
			assistant
					.setContextInformationPopupOrientation(IContentAssistant.CONTEXT_INFO_ABOVE);
			assistant.setContextInformationPopupBackground(colorManager
					.getColor(new RGB(150, 150, 0)));
		}

	}

	/**
	 * Returns all valid content Types. See also
	 * {@link OilPartitionScanner OilPartitionScanner}.
	 * 
	 * @param sourceViewer
	 *            the current sourceViewer
	 * 
	 * @return valid content types
	 */
	public String[] getConfiguredContentTypes(ISourceViewer sourceViewer) {
		return new String[] { IDocument.DEFAULT_CONTENT_TYPE,
				OilPartitionScanner.STR_STRING,
				OilPartitionScanner.STR_COMMENT,
				OilPartitionScanner.STR_LONG_COMMENT };
	}

	/**
	 * Returns the presentation reconciler ready to be used with the given
	 * source viewer.
	 * 
	 * @param sourceViewer
	 *            the source viewer
	 * @return the presentation reconciler
	 */
	public IPresentationReconciler getPresentationReconciler(
			ISourceViewer sourceViewer) {

		return reconciler;
	}

	/**
	 * Returns the text hover which will provide the information to be shown in
	 * a text hover popup window when requested for the given source viewer and
	 * the given content type. This implementation always returns <code>
	 * null</code>.
	 * 
	 * @param sourceViewer
	 *            the source viewer to be configured by this configuration
	 * @param contentType
	 *            the content type
	 * @return a text hover or <code>null</code> if no hover support should be
	 *         installed
	 *  
	 */
	public ITextHover getTextHover(ISourceViewer sourceViewer,
			String contentType) {
		return null; // new OilTextHover();
	}

	/**
	 * Returns the annotation hover which will provide the information to be
	 * shown in a hover popup window when requested for the given source viewer.
	 * 
	 * @param sourceViewer
	 *            the source viewer to be configured by this configuration
	 * @return the annotation hover
	 */
	public IAnnotationHover getAnnotationHover(ISourceViewer sourceViewer) {
		return annotationHover;
	}

	/**
	 * Returns the auto indentation strategy ready to be used with the given source viewer
	 * when manipulating text of the given content type.
	 *
	 * @param sourceViewer the source viewer to be configured by this configuration
	 * @param contentType the content type for which the strategy is applicable
	 * @return the auto indent strategy or <code>null</code> if automatic indentation is not to be enabled
	 */
	public IAutoIndentStrategy getAutoIndentStrategy(
			ISourceViewer sourceViewer, String contentType) {
		return autoIndentStrategy;
	}

	/**
	 * Restituisce la classe che si occupa di gestire la completazione
	 * automatica delle parole
	 */
	public IContentAssistant getContentAssistant(ISourceViewer sourceViewer) {
		return assistant;
	}
}

// --------------------------------------------------------------------------
// Other classes
//--------------------------------------------------------------------------

/**
 * Questa classe si occupa di fornire una descrizione della regione selezionata.
 * In questo caso si limita a visualizzare la selezione stessa
 */

class OilTextHover implements ITextHover {

	public String getHoverInfo(ITextViewer textViewer, IRegion hoverRegion) {
		if (hoverRegion != null) {
			try {
				if (hoverRegion.getLength() > -1)
					return textViewer.getDocument().get(
							hoverRegion.getOffset(), hoverRegion.getLength());
			} catch (BadLocationException x) {
			}
		}
		return "emptySelection";
	}

	public IRegion getHoverRegion(ITextViewer textViewer, int offset) {
		Point selection = textViewer.getSelectedRange();
		if (selection.x <= offset && offset < selection.x + selection.y)
			return new Region(selection.x, selection.y);
		return new Region(offset, 0);
	}
}

/**
 * Questa classe permette di visualizzare alcune informazioni della riga
 * corrente (Ponendo il mouse nella barra alla sinistra del testo). Per ora
 * mostra il contenuto della riga.
 */

class OilAnnotationHover implements IAnnotationHover {

	final protected OilTextEditor parentEditor;

	public OilAnnotationHover(OilTextEditor parent) {
		parentEditor = parent;
	}

	public String getHoverInfo(ISourceViewer sourceViewer, int lineNumber) {

		if (parentEditor == null) {
			return null;
		}

		IResource theResource = (IResource) parentEditor.getEditorInput()
				.getAdapter(IResource.class);

		if (theResource == null) {
			return null;
		}

		ArrayList answerList = new ArrayList();

		try {
			// ask for ALL markers (type == null)
			IMarker[] markers = theResource.findMarkers(null, true,
					IResource.DEPTH_INFINITE);

			String row = "" + (lineNumber + 1);
			if (markers != null) {
				for (int i = 0; i < markers.length; i++) {
					if (row.equals(""
							+ markers[i].getAttribute(IMarker.LINE_NUMBER))) {
						String txt = ""
								+ markers[i].getAttribute(IMarker.MESSAGE);
						if (txt != null) {
							answerList.add(txt);
						}
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		switch (answerList.size()) {
		case 0:
			return null;
		case 1:
			return (String) answerList.get(0);
		default: {
			StringBuffer answer = new StringBuffer(
					"Multiple markers at this line:");

			for (int i = 0; i < answerList.size(); i++) {
				answer.append("\n  - " + answerList.get(i));
			}

			return answer.toString();
		}
		}
	}
}

/**
 * Questa classe esamina il testo corrente e prova a completare la parola
 */

class OilCompletionProcessor implements IContentAssistProcessor {

	/**
	 * Simple content assist tip closer. The tip is valid in a range of 5
	 * characters around its popup location.
	 */
	protected static class Validator implements IContextInformationValidator,
			IContextInformationPresenter {

		protected int fInstallOffset;

		/*
		 * @see IContextInformationValidator#isContextInformationValid(int)
		 */
		public boolean isContextInformationValid(int offset) {
			return Math.abs(fInstallOffset - offset) < 5;
		}

		/*
		 * @see IContextInformationValidator#install(IContextInformation,
		 *      ITextViewer, int)
		 */
		public void install(IContextInformation info, ITextViewer viewer,
				int offset) {
			fInstallOffset = offset;
		}

		/*
		 * @see org.eclipse.jface.text.contentassist.IContextInformationPresenter#updatePresentation(int,
		 *      TextPresentation)
		 */
		public boolean updatePresentation(int documentPosition,
				TextPresentation presentation) {
			return false;
		}
	}

	protected static String[] fgProposals = { "UINT32", "INT32", "UINT64",
			"INT64", "FLOAT", "STRING", "BOOLEAN", "ENUM",

			"OS", "TASK", "COUNTER", "ALARM", "RESOURCE", "EVENT", "ISR",
			"MESSAGE", "COM", "NM", "APPMODE", "IPDU",

			"OS_TYPE", "TASK_TYPE", "COUNTER_TYPE", "ALARM_TYPE",
			"RESOURCE_TYPE", "EVENT_TYPE", "ISR_TYPE", "MESSAGE_TYPE",
			"COM_TYPE", "NM_TYPE", "APPMODE_TYPE", "IPDU_TYPE" };

	static {
		// just sort the array

		ArrayList tmp = new ArrayList(Arrays.asList(fgProposals));
		Collections.sort(tmp);
		fgProposals = (String[]) tmp.toArray(new String[tmp.size()]);
	}

	protected IContextInformationValidator fValidator = new Validator();

	/*
	 * (non-Javadoc) Method declared on IContentAssistProcessor
	 */
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer,
			int documentOffset) {

		final String typed = getTypedWord(viewer, documentOffset);

		final String[] values = extractWords(viewer, documentOffset, typed);

		if (values == null || values.length == 0) {
			return null;
		}

		ICompletionProposal[] result = new ICompletionProposal[values.length];
		final int typedSize = typed.length();
		for (int i = 0; i < values.length; i++) {
			String tValue = values[i].substring(typedSize) + " ";
			//			IContextInformation info= new ContextInformation(values[i],
			// values[i] );
			IContextInformation info = null;
			result[i] = new OilCompletiotionProposal(tValue, documentOffset, 0,
					tValue.length(), null, values[i], info, tValue);
		}
		return result;
	}

	/*
	 * (non-Javadoc) Method declared on IContentAssistProcessor
	 */
	public IContextInformation[] computeContextInformation(ITextViewer viewer,
			int documentOffset) {
		IContextInformation[] result = new IContextInformation[5];
		for (int i = 0; i < result.length; i++)
			result[i] = new ContextInformation(
					MessageFormat
							.format(
									"Id = {0}, offset = {1}", new Object[] { new Integer(i), new Integer(documentOffset) }), //$NON-NLS-1$
					MessageFormat
							.format(
									"Id = {0}, intervallo = [{1},{2}]", new Object[] { new Integer(i), new Integer(documentOffset - 5), new Integer(documentOffset + 5) })); //$NON-NLS-1$
		return result;
	}

	/*
	 * (non-Javadoc) Method declared on IContentAssistProcessor
	 */
	public char[] getCompletionProposalAutoActivationCharacters() {
		return new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'L',
				'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'Z', 'Y',
				'J', 'K', 'X', '_', '2', '4', '6' };
		//return new char[] { '.', '(' };
		//return null; // disable auto activation
	}

	/*
	 * (non-Javadoc) Method declared on IContentAssistProcessor
	 */
	public char[] getContextInformationAutoActivationCharacters() {
//		return new char[] { '#' };
		return null; // disable auto activation
	}

	/*
	 * (non-Javadoc) Method declared on IContentAssistProcessor
	 */
	public IContextInformationValidator getContextInformationValidator() {
		return fValidator;
	}

	/*
	 * (non-Javadoc) Method declared on IContentAssistProcessor
	 */
	public String getErrorMessage() {
		return null;
	}

	/**
	 * Cerca tutte le parole che iniziano con le lettere che precedono il
	 * cursore (considerando fino al primo spazio bianco o inizio riga)
	 */
	protected String[] extractWords(ITextViewer viewer, int documentOffset,
			String key) {
		ArrayList answer = new ArrayList();

		if (key == null) {
			return null;
		}

		// if the type is empty, return all words
		if (key.length() == 0) {
			return fgProposals;
		}

		for (int i = 0; i < fgProposals.length; i++) {
			if (fgProposals[i].startsWith(key)) {
				answer.add(fgProposals[i]);
			}
		}

		return (String[]) answer.toArray(new String[answer.size()]);
	}

	/**
	 * Cerco la parola che termina all'offset indicato. Considero come punto di
	 * partenza o l'inizio riga o il primo spazio bianco incontrato
	 */
	protected String getTypedWord(ITextViewer viewer, int documentOffset) {

		IDocument doc = viewer.getDocument();
		if (doc == null) {
			return null;
		}

		final IRegion row;
		try {
			row = doc.getLineInformationOfOffset(documentOffset);
		} catch (BadLocationException e) {
			return null;
		}

		int startWordOffset;
		try {
			final int startRow = startWordOffset = row.getOffset();
			// search the first white space
			for (int i = documentOffset - 1; startRow <= i; i--) {
				char c = doc.getChar(i);
				if (Character.isWhitespace(c)) {
					startWordOffset = i + 1;
					break;
				}
			}

			final String answer;
			if (startWordOffset > documentOffset) {
				answer = "";
			} else {
				answer = doc.get(startWordOffset, documentOffset
						- startWordOffset);
			}

			return answer;

		} catch (BadLocationException e) {
			throw new RuntimeException(e.getMessage());
		}

	}
}

/**
 * Questa classe e' necessaria in quanto, in alcune operazioni viene usata
 * l'interfaccia ICompletionProposal, mentre per altre solo la presenza
 * dell'interfaccia ICompletionProposalExtension3 permette la loro corretta
 * esecuzione. Un esempio e' autocompletamento della sezione comune tra le
 * parole rimaste, quando si preme ctrl+space.
 * 
 * Per non riscrivere le funzioni della ICompletionProposal, internamente usa
 * un'istanza di CompletionProposal, a cui sono delegate le varie funzioni.
 */

class OilCompletiotionProposal implements ICompletionProposal,
		ICompletionProposalExtension3 {

	/** Internal completition proposal */
	final private ICompletionProposal internalCompletitionProposal;

	/** The actual string to be inserted into the document */
	final private String replacement;

	/**
	 * Creates a new completion proposal. All fields are initialized based on
	 * the provided information.
	 * 
	 * @param replacementString
	 *            the actual string to be inserted into the document
	 * @param replacementOffset
	 *            the offset of the text to be replaced
	 * @param replacementLength
	 *            the length of the text to be replaced
	 * @param cursorPosition
	 *            the position of the cursor following the insert relative to
	 *            replacementOffset
	 * @param image
	 *            the image to display for this proposal
	 * @param displayString
	 *            the string to be displayed for the proposal
	 * @param contextInformation
	 *            the context information associated with this proposal
	 * @param additionalProposalInfo
	 *            the additional information associated with this proposal
	 */
	public OilCompletiotionProposal(String replacementString,
			int replacementOffset, int replacementLength, int cursorPosition,
			Image image, String displayString,
			IContextInformation contextInformation,
			String additionalProposalInfo) {
		internalCompletitionProposal = new CompletionProposal(
				replacementString, replacementOffset, replacementLength,
				cursorPosition, image, displayString, contextInformation,
				additionalProposalInfo);

		replacement = replacementString;
	}

	/***************************************************************************
	 * ICompletionProposal
	 **************************************************************************/

	/***/
	public void apply(IDocument document) {
		internalCompletitionProposal.apply(document);
	}

	/***/
	public String getAdditionalProposalInfo() {
		return internalCompletitionProposal.getAdditionalProposalInfo();
	}

	/***/
	public IContextInformation getContextInformation() {
		return internalCompletitionProposal.getContextInformation();
	}

	/***/
	public String getDisplayString() {
		return internalCompletitionProposal.getDisplayString();
	}

	/***/
	public Image getImage() {
		return internalCompletitionProposal.getImage();
	}

	/***/
	public Point getSelection(IDocument document) {
		return internalCompletitionProposal.getSelection(document);
	}

	/***************************************************************************
	 * ICompletionProposalExtension3
	 **************************************************************************/

	/***/
	public IInformationControlCreator getInformationControlCreator() {
		return null;
	}

	/***/
	public int getPrefixCompletionStart(IDocument document, int completionOffset) {
		return completionOffset;
	}

	/***/
	public CharSequence getPrefixCompletionText(IDocument document,
			int completionOffset) {
		return replacement;
	}
}