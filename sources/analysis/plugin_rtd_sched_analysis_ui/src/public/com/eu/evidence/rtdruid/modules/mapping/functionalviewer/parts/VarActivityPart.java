/*
 * Created on Feb 22, 2005
 *
 * $Id: VarActivityPart.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.mapping.functionalviewer.parts;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.gef.ConnectionEditPart;

import com.eu.evidence.rtdruid.modules.mapping.functionalviewer.ImagesRepository;
import com.eu.evidence.rtdruid.modules.mapping.functionalviewer.figures.SimpleActivityLabel;
import com.eu.evidence.rtdruid.modules.mapping.functionalviewer.model.GMethodRefConnection;


/**
 * 
 * TODO : Commentare && Tradurre
 * 
 * @author Nicola Serreli
 */
public class VarActivityPart extends SimpleActivityPart {
	/**
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
	 */
	protected IFigure createFigure() {
		Label l = new SimpleActivityLabel();
		l.setLabelAlignment(PositionConstants.LEFT);
		l.setIcon(ImagesRepository.getVarImg());
		return l;
	}

	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.modules.mapping.functionalviewer.parts.ActivityPart#getSourceConnectionAnchor(org.eclipse.gef.ConnectionEditPart)
	 */
	public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
		ConnectionAnchor answer = makeConnectionAnchor(connection);
		return answer != null ? answer : super.getSourceConnectionAnchor(connection);
	}

	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.modules.mapping.functionalviewer.parts.ActivityPart#getTargetConnectionAnchor(org.eclipse.gef.ConnectionEditPart)
	 */
	public ConnectionAnchor getTargetConnectionAnchor(
			ConnectionEditPart connection) {
		ConnectionAnchor answer = makeConnectionAnchor(connection);
		return answer != null ? answer : super.getTargetConnectionAnchor(connection);
	}

	protected ConnectionAnchor makeConnectionAnchor(
			ConnectionEditPart connection) {

		if (connection.getModel() instanceof GMethodRefConnection) {
			GMethodRefConnection conn = (GMethodRefConnection) connection.getModel();
			
			if (conn.methodRef.getLocalID().endsWith("read")) {
				return new BorderAnchor(getFigure(), BorderAnchor.BOTTOM, getAnchorOffset());
				//return new BorderAnchor(getFigure(), BorderAnchor.RIGHT, getAnchorOffset());
				
			} else if (conn.methodRef.getLocalID().endsWith("write")) {
				return new BorderAnchor(getFigure(), BorderAnchor.TOP, getAnchorOffset());
				//return new BorderAnchor(getFigure(), BorderAnchor.LEFT, getAnchorOffset());
	
			}
		}

		return null;
	}
}