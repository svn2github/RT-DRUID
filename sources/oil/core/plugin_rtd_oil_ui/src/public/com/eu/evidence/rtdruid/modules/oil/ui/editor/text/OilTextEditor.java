/*
 * Created on Jan 26, 2005
 *
 * $Id: OilTextEditor.java,v 1.4 2008/01/24 16:00:21 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.ui.editor.text;



import java.io.ByteArrayInputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.eclipse.ui.texteditor.TextOperationAction;

import com.eu.evidence.rtdruid.desk.Messages;
import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OilReaderFactory;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVarTreeProvider;
import com.eu.evidence.rtdruid.vartree.VarTreeUtil;

/**
 * This class is a text editor for oil files
 * 
 * @author Nicola Serreli
 */
public class OilTextEditor extends TextEditor implements IVarTreeProvider {

	/**
	 * per visualizzare degli errori su una risorsa, usare :
	 * 
	 * IResource.createMarker(...).
	 * 
	 * Per eliminarlo IResource.deleteMarkers(...).
	 * 
	 * 
	 * Possibili attributi :
	 * 
	 * IMarker.LINE_NUMBER IMarker.MESSAGE
	 * IMarker.PRIORITY,IMarker.PRIORITY_HIGH);
	 * IMarker.SEVERITY,IMarker.SEVERITY_ERROR); IMarker.CHAR_START and
	 * IMarker.CHAR_END (per sottolineare la zona del problema)
	 * 
	 * tipo ... IMarker m = res.createMarker(IMarker.PROBLEM);
	 * m.setAttribute(IMarker.LINE_NUMBER, line);
	 * m.setAttribute(IMarker.MESSAGE, msg);
	 * m.setAttribute(IMarker.PRIORITY,IMarker.PRIORITY_HIGH);
	 * m.setAttribute(IMarker.SEVERITY,IMarker.SEVERITY_ERROR);
	 *  
	 */
	/** The color manager for current instance of OilTextEditor */	
	private ColorManager colorManager;

	/**
	 * The default constructor. Init Syntax Colors and Word's completion.
	 */
	public OilTextEditor() {
		super();
		colorManager = new ColorManager();
		setSourceViewerConfiguration(new OilTextEditorConfiguration(
				colorManager, this));
		setDocumentProvider(new OilDocumentProvider());
	}

	/** Dispose this editor and it's elements. */
	public void dispose() {
		colorManager.dispose();
		super.dispose();
	}

	/**
	 * Handles an external change of the editor's input element. Subclasses may
	 * extend.
	 */
	public void handleEditorInputChanged() {
		super.handleEditorInputChanged();
	}
	
	/** Handles a potential change of the cursor position. */
	protected void handleCursorPositionChanged() {
		super.handleCursorPositionChanged();
		/*
		 * e' possibilile, usando questa funzione evidenziare l'area in cui si
		 * trova il cursore, come quando l'editor java mostra la zona di una
		 * funzione.
		 * 
		 * 1) prelevare l'inizio e la fine della sezione dal documento.
		 * 
		 * final int ret = getSourceViewer().getTextWidget().getCaretOffset();
		 * 
		 * 2) cercare la sezione di appartenenza e i suoi confini.
		 * 
		 * ????
		 * 
		 * 3) evidenziare tale area.
		 * 
		 * setHighlightRange( start, length, false );
		 *  
		 */
	}

	/**
	 * Enable line's numbers.
	 * 
	 * @return true
	 */
	protected boolean isLineNumberRulerVisible() {
		return true;
	}

	/**
	 * Adds some actions for this Editor, like Content_Assist_Proposal.
	 */
	protected void createActions() {
		super.createActions();

		IAction a = new TextOperationAction(OilTextEditorBundle
				.getResourceBundle(),
				OilTextEditorBundle.CONTENT_ASSIST_PROPOSAL_PREFIX, this,
				ISourceViewer.CONTENTASSIST_PROPOSALS);
		a.setActionDefinitionId(
				ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS);
		setAction(OilTextEditorBundle.CONTENT_ASSIST_PROPOSAL_PREFIX, a);
	}
	
	

	// ---------------------------------------------------

	/**
	 * Returns the document of this Editor.
	 * 
	 * @return the current document or null, if there isn't any
	 */
	public IDocument getDocument() {
		final ISourceViewer sv = getSourceViewer();
		final IDocument ret = sv == null ? null : sv.getDocument();
		return ret;
	}

	// ---------------------------------------------------
	
	/* (non-Javadoc)
	 * @see rtdruid.vartree.IVarTreeProvider#getVarTree()
	 */
	public IVarTree getVarTree() {
    	IDocument doc = getDocument();
    	if (doc == null) {
    		return null;
    	}

    	String txt = doc.get();
    	if (txt == null) {
    		return null;
    	}
    	
		IVarTree vt = VarTreeUtil.newVarTree();
        try {
        	IEditorInput input= getEditorInput();
        	
        	String inputName = input.getName();
        	String inputPath = null;
        	IProject project = null;
        	if (input instanceof IFileEditorInput) {
        		IFile inputFile = ((IFileEditorInput) input).getFile();
        		project = inputFile.getProject();
        		
        		IPath tmp = inputFile.getParent().getLocation();
        		inputPath = tmp != null ? tmp.toOSString() : null;
        	}

        	(OilReaderFactory.getAnOilReader()).load(
        			new ByteArrayInputStream(txt.getBytes()), vt,
        			inputName, inputPath);

        	if (project != null) {
        	    vt.getProperties().put(IWritersKeywords.VTProperty_OilProjectName, project.getName());
        	    IPath path = project.getLocation();
        	    
       	        vt.getProperties().put(IWritersKeywords.VTProperty_OilProjectPath,
       	                path == null ? project.getName() : path.toString());
        	}
        } catch (Exception e) {
			//e.printStackTrace();
        	Messages.sendError(e.getMessage(), null, "oiltexteditor__oil_parsing", null);
            
            RtdruidLog.log(e);
			return null;
        }

		return vt;
	}
	
	public void performSave(boolean overwrite, IProgressMonitor progressMonitor) {
		super.performSave(overwrite, progressMonitor);
	}
}