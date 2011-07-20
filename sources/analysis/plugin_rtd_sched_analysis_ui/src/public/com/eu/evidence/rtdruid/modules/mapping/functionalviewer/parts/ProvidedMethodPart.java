/*
 * Created on Mar 17, 2005
 *
 * $Id: ProvidedMethodPart.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.mapping.functionalviewer.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PositionConstants;

import com.eu.evidence.rtdruid.modules.mapping.functionalviewer.ImagesRepository;
import com.eu.evidence.rtdruid.modules.mapping.functionalviewer.figures.SimpleActivityLabel;
import com.eu.evidence.rtdruid.modules.mapping.functionalviewer.model.GProvidedMethod;


/**
 * 
 * TODO : Commentare && Tradurre
 * 
 * @author Nicola Serreli
 */
public class ProvidedMethodPart extends SimpleActivityPart {
	/**
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
	 */
	protected IFigure createFigure() {
		Label l = new SimpleActivityLabel();
		l.setLabelAlignment(PositionConstants.LEFT);
		l.setIcon(ImagesRepository.getVarImg());
		return l;
	}
		
	/**
	 * @see org.eclipse.gef.editparts.AbstractEditPart#refreshVisuals()
	 */
	protected void refreshVisuals() {
		GProvidedMethod gpm = (GProvidedMethod) getModel();
		
		((Label) getFigure()).setText(gpm.getMethodName());
	}

}