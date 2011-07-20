/*
 * Created on Feb 21, 2005
 *
 * $Id: SubSystemActivityPart.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.mapping.functionalviewer.parts;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.ConnectionEditPart;

import com.eu.evidence.rtdruid.modules.mapping.functionalviewer.figures.SubSystemFigure;
import com.eu.evidence.rtdruid.modules.mapping.functionalviewer.model.GConnection;
import com.eu.evidence.rtdruid.modules.mapping.functionalviewer.model.GGate;
import com.eu.evidence.rtdruid.modules.mapping.functionalviewer.model.GSubsystem;


/**
 * 
 * TODO : Commentare && Tradurre
 * 
 * @author Nicola Serreli
 */
public class SubSystemActivityPart extends StructuredActivityPart {

	
	
	
	protected IFigure createFigure() {
		SubSystemFigure ssf = new SubSystemFigure();
			
		/*
		ssf.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent me) {
				//System.out.println("Pressed !!!");
				//me.consume();
			}

			public void mouseReleased(MouseEvent me) {
				//System.out.println("Relesead !!!");
				//me.consume();
				//setSelected(SELECTED);
			}

			public void mouseDoubleClicked(MouseEvent me) {
				//me.consume();
				System.out.println("Double Click !!!");
				if (me.getState() == MouseEvent.BUTTON1) {
					System.out.println("\tbutton 1");
				}
				if (me.getState() == MouseEvent.BUTTON2) {
					System.out.println("\tbutton 2");
				}
				if (me.getState() == MouseEvent.BUTTON3) {
					System.out.println("\tbutton 3");
				}
			}
		});*/
		
		GSubsystem currentSubSystem = (GSubsystem) getModel();
		ssf.setProvidedInterfacesNumber(currentSubSystem.getProvidedInterface().length);
		ssf.setRequiredInterfacesNumber(currentSubSystem.getRequiredInterface().length);
		return ssf;
	}

	/**
	 * @see org.eclipse.gef.EditPart#setSelected(int)
	 */
	public void setSelected(int value) {
		super.setSelected(value);
		SubSystemFigure sf = (SubSystemFigure) getFigure();
		sf.setSelected(value != SELECTED_NONE);
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

		GSubsystem currentSubSystem = (GSubsystem) getModel();
		
		GConnection conn = (GConnection) connection.getModel();
		
		GGate sg = conn.sourceGate;
		GGate tg = conn.targetGate;
		
		{
			GSubsystem.GRequiredInterface[] reqInterf =currentSubSystem.getRequiredInterface();
			
			for (int i=0; i<reqInterf.length; i++) {
				if (reqInterf[i].internalMethod.getGate() == sg || reqInterf[i].internalMethod.getGate() == tg) {
					return new BorderAnchor(getFigure(), BorderAnchor.BOTTOM, i, reqInterf.length, -SubSystemFigure.BOTTOM_WITDH);
				}
				if (reqInterf[i].externalGate == sg || reqInterf[i].externalGate == tg) {
					return new BorderAnchor(getFigure(), BorderAnchor.BOTTOM, i, reqInterf.length, 0);
				}
			}
		}

		{
			GSubsystem.GProvidedInterface[] provInterf =currentSubSystem.getProvidedInterface();

			for (int i=0; i<provInterf.length; i++) {
				if (provInterf[i].externalMethod.getGate() == sg || provInterf[i].externalMethod.getGate() == tg) {
					return new BorderAnchor(getFigure(), BorderAnchor.TOP, i, provInterf.length, 0);
				}
				if (provInterf[i].internalGate == sg || provInterf[i].internalGate == tg) {
					return new BorderAnchor(getFigure(), BorderAnchor.TOP, i, provInterf.length, SubSystemFigure.TOP_WITDH );
				}
			}
		}

		return null;
	}

	
	
}