/*
 * Created on Feb 21, 2005
 *
 * $Id: ImagesRepository.java,v 1.2 2005/10/20 09:54:47 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.mapping.functionalviewer;

import org.eclipse.swt.graphics.Image;

import com.eu.evidence.rtdruid.modules.jscan.ui.rtd_jscan_ui.Rtd_jscan_uiPlugin;


/**
 * 
 * This class contains some little images used by Functional Viewer.
 * 
 * @author Nicola Serreli
 */
public class ImagesRepository {

    protected final static String IMAGE_BASE = "/com/eu/evidence/rtdruid/modules/mapping/functionalviewer/images/";
    
	/** */
	protected static Image procImg = null;

	/** An image for a Var */
	protected static Image varImg = null;

	// -------------------
	/** It's unusefull to make a new instance of this class */
	protected ImagesRepository() {
	};

	/**
	 * Returns a first image
	 */
	public static Image getProcImg() {
		if (procImg == null) {
			procImg = new Image(
					null,
					Rtd_jscan_uiPlugin.class
							.getResourceAsStream(IMAGE_BASE + "proc.gif"));
		}

		return procImg;
	}

	/**
	 * Returns a first image
	 */
	public static Image getVarImg() {
		if (varImg == null) {
			varImg = new Image(
					null,
					Rtd_jscan_uiPlugin.class
							.getResourceAsStream(IMAGE_BASE + "var.gif"));
		}

		return varImg;
	}
}