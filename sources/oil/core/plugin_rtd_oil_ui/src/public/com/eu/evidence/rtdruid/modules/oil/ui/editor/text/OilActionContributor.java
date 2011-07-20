/*
 * Created on Jan 26, 2005
 *
 * $Id: OilActionContributor.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.ui.editor.text;

import java.util.ResourceBundle;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.editors.text.TextEditorActionContributor;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.eclipse.ui.texteditor.RetargetTextEditorAction;

/**
 * Contributes interesting Oil actions to the desktop's Edit menu and the
 * toolbar.
 * 
 * @author Nicola Serreli
 */
public class OilActionContributor extends TextEditorActionContributor {

	/** The action used to call the Content Assist Proposal */
	protected RetargetTextEditorAction fContentAssistProposal;

	//	protected RetargetTextEditorAction fContentAssistTip;

	/**
	 * Default constructor.
	 */
	public OilActionContributor() {
		super();
		ResourceBundle resBundle = OilTextEditorBundle.getResourceBundle();

		fContentAssistProposal = new RetargetTextEditorAction(resBundle,
				OilTextEditorBundle.CONTENT_ASSIST_PROPOSAL_PREFIX);
		fContentAssistProposal
				.setActionDefinitionId(ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS);
		//		fContentAssistTip= new RetargetTextEditorAction(resBundle,
		// "ContentAssistTip."); //$NON-NLS-1$
		//		fContentAssistTip.setActionDefinitionId(ITextEditorActionDefinitionIds.CONTENT_ASSIST_CONTEXT_INFORMATION);
	}

	/** debug use only */
	static int Marker_ID = 0;

	/*
	 * @see IEditorActionBarContributor#init(IActionBars)
	 * 
	 * 
	 * TODO: Sistemare un pochino e tradurre
	 * 
	 */
	public void init(IActionBars bars) {
		super.init(bars);

		IMenuManager menuManager = bars.getMenuManager();
		IMenuManager editMenu = menuManager
				.findMenuUsingPath(IWorkbenchActionConstants.M_EDIT);
		if (editMenu != null) {
			editMenu.add(new Separator());
			editMenu.add(fContentAssistProposal);

			// Un'azione per provare ad aggiungere un "errore ad una specificata
			// linea"
			editMenu.add(new Action("Aggiunge la segnalazione di un errore") {
				public void run() {

					/**
					 * Una mini classe per controllare che il numero sia intero
					 * positivo
					 */
					class Validator implements IInputValidator {
						final String message = "Required an integer greater than 0";

						public String isValid(String newText) {
							int i = 0;
							try {
								i = Integer.parseInt(newText);
							} catch (NumberFormatException e) {
								return message;
							}

							return i > 0 ? null : message;
						}
					}

					/** Richiedo la riga su cui settare l'errore */
					InputDialog id = new InputDialog(getPage()
							.getWorkbenchWindow().getShell(), "numero di riga",
							"Su quale riga applicare l'errore", "" + 1,
							new Validator());

					if (id.open() == InputDialog.CANCEL) {
						return;
					}

					int row = Integer.parseInt(id.getValue());

					IEditorPart iep = getPage().getActiveEditor();
					if (iep == null || !(iep instanceof OilTextEditor)) {
						return;
					}

					IResource theResource = (IResource) iep.getEditorInput()
							.getAdapter(IResource.class);

					if (theResource == null) {
						return;
					}

					// aggingo il marker
					try {
						IMarker m = theResource.createMarker(IMarker.PROBLEM);
						m.setAttribute(IMarker.LINE_NUMBER, row);
						m.setAttribute(IMarker.MESSAGE, "testo " + row + " ("
								+ Marker_ID + ")");
						m.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_HIGH);
						m
								.setAttribute(IMarker.SEVERITY,
										IMarker.SEVERITY_ERROR);

						Marker_ID++;
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			//			editMenu.add(fContentAssistTip);
		}
		
		
		if (false) {
			IMenuManager rtdruidMenu = menuManager
			.findMenuUsingPath("rtdruid.vartree.dataMenuID");
			
			if (rtdruidMenu == null) {
				rtdruidMenu = new MenuManager("&Rtdruid", "rtdruid.vartree.dataMenuID");
				rtdruidMenu.add(new Separator("settings"));
				rtdruidMenu.add(new Separator("views"));
				rtdruidMenu.add(new Separator("actions"));
				rtdruidMenu.add(new Separator("additions"));
				menuManager.add(rtdruidMenu);
			}
			
			IMenuManager oilMenu = rtdruidMenu
				.findMenuUsingPath("rtdruid.vartree.dataMenuID.oilID");
			if (oilMenu == null) {
				oilMenu = new MenuManager("Oil", "rtdruid.vartree.dataMenuID.oilID");
				oilMenu.add(new Separator("actions"));
				oilMenu.add(new Separator("additions"));
				rtdruidMenu.appendToGroup("views", oilMenu);
			}
			
			if (oilMenu != null) {
	
				// Un'azione per provare ad aggiungere un "errore ad una specificata
				// linea"
	//			oilMenu.appendToGroup("actions", new Action("Create Configuration's files") {
				Action owa = new OilWriteAction("Create Configuration's files");
				owa.setToolTipText("Create configuration's file from an Oil File open with a Oil Editor");
				rtdruidMenu.add(owa);
	
			}
		
		} else {
			Action owa = new OilWriteAction("Create Configuration's files");
			owa.setToolTipText("Create configuration's file from an Oil File open with a Oil Editor");
			editMenu.add(owa);
			
		}
	}

	/**
	 * Activate or disactivate all actions for OilTextEditor.
	 * 
	 * @param part
	 *            is the current editor. If is an not null OilTextEditor, then
	 *            all action are active.
	 */
	private void doSetActiveEditor(IEditorPart part) {
		super.setActiveEditor(part);

		ITextEditor editor = null;
		if (part instanceof ITextEditor)
			editor = (ITextEditor) part;

		fContentAssistProposal.setAction(getAction(editor,
				OilTextEditorBundle.CONTENT_ASSIST_PROPOSAL_PREFIX));
		//		fContentAssistTip.setAction(getAction(editor, "ContentAssistTip"));
	}

	/*
	 * @see IEditorActionBarContributor#setActiveEditor(IEditorPart)
	 */
	public void setActiveEditor(IEditorPart part) {
		super.setActiveEditor(part);
		doSetActiveEditor(part);
	}

	/*
	 * @see IEditorActionBarContributor#dispose()
	 */
	public void dispose() {
		doSetActiveEditor(null);
		super.dispose();
	}
}