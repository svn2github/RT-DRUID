/**
 * 31/mag/2012
 */
package com.eu.evidence.rtdruid.tests.ui.swtbot;

import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.swt.SWT;

/**
 * 
 * @author Nicola Serreli
 * @since 2.0
 * 
 */
public interface StandardWidgetTexts {
	
	/********************************************************************
	 * TIMEOUTS
	 ********************************************************************/
	/**
	 * Build timeout (currently one minute)
	 */
	long LONG_BUILD_TIMEOUT = 60000; 

	/********************************************************************
	 * BUTTONS
	 ********************************************************************/

	/** Standard button "Ok" */
	String BTN_TXT_OK = "OK";

	/** Standard button "Apply" */
	String BTN_TXT_APPLY = "Apply";

	/** Standard button "Cancel" */
	String BTN_TXT_CANCEL = "Cancel";

	/** Standard button "Next >" */
	String BTN_TXT_NEXT = "Next >";

	/** Standard button "Finish" */
	String BTN_TXT_FINISH = "Finish";

	/********************************************************************
	 * MENUS
	 ********************************************************************/

	/** Standard name of "File" menu */
	String MENU_FILE = "File";

	/** Standard name of "Project" menu */
	String MENU_PROJECT = "Project";

	/** Standard name of "Build Automatically" menu element */
	String MENU_BUILD_AUTOMATICALLY = "Build Automatically";

	/** Standard name of "Window" menu */
	String MENU_WINDOW = "Window";

	/** Standard name of "Show View" menu element */
	String MENU_SHOW_VIEW = "Show View";

	/********************************************************************
	 * CONTEXT MENUS
	 ********************************************************************/

	/** Standard element for clean a project (context menu) */
	String CMENU_CLEAN_PROJECT = "Clean Project";

	/** Standard element for build a project (context menu) */
	String CMENU_BUILD_PROJECT = "Build Project";

	/********************************************************************
	 * Window names
	 ********************************************************************/

	/** Standard name of "Show View" window */
	String WINDOW_SHOW_VIEW = MENU_SHOW_VIEW;

	/********************************************************************
	 * KEY STROKES
	 ********************************************************************/

	/** Equivalent to "Press enter" */
	KeyStroke[] KEY_ENTER = new KeyStroke[] {
//			KeyStroke.getInstance(SWT.LF), 
			KeyStroke.getInstance(SWT.LF)
	};

	/** Equivalent to "Press enter" */
	KeyStroke KEY_ESC = KeyStroke.getInstance(SWT.ESC);

	
	/********************************************************************
	 * FILE AND FOLDERS NAMES
	 ********************************************************************/

	
	/** conf.oil file */
	String FILE_CONF_OIL = "conf.oil";

	/** makefile file */
	String FILE_MAKEFILE = "makefile";
	
	/** Debug folder */
	String FOLDER_DEBUG = "Debug";
}
