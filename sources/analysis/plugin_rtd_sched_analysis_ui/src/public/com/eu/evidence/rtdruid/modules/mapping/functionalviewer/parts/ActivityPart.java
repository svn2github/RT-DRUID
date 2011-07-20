/*
 * Created on Feb 21, 2005
 *
 * $Id: ActivityPart.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.mapping.functionalviewer.parts;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.graph.CompoundDirectedGraph;
import org.eclipse.draw2d.graph.Node;
import org.eclipse.draw2d.graph.Subgraph;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.swt.graphics.Color;

import com.eu.evidence.rtdruid.modules.mapping.functionalviewer.model.GComponent;
import com.eu.evidence.rtdruid.modules.mapping.functionalviewer.model.GStructured;
import com.eu.evidence.rtdruid.modules.mapping.functionalviewer.model.IGComponent;


/**
 * 
 * TODO : Commentare && Tradurre
 * 
 * @author Nicola Serreli
 */
public abstract class ActivityPart extends AbstractGraphicalEditPart implements
		PropertyChangeListener, NodeEditPart {

	/**
	 * @see org.eclipse.gef.EditPart#activate()
	 */
	public void activate() {
		super.activate();
		getActivity().addPropertyChangeListener(this);
	}
	
	protected void applyGraphResults(CompoundDirectedGraph graph, Map map) {
		Node n = (Node) map.get(this);
		getFigure().setBounds(new Rectangle(n.x, n.y, n.width, n.height));

		for (int i = 0; i < getSourceConnections().size(); i++) {
			TransitionPart trans = (TransitionPart) getSourceConnections().get(
					i);
			trans.applyGraphResults(graph, map);
		}
	}

	public void contributeEdgesToGraph(CompoundDirectedGraph graph, Map map) {
		List outgoing = getSourceConnections();
		for (int i = 0; i < outgoing.size(); i++) {
			TransitionPart part = (TransitionPart) getSourceConnections()
					.get(i);
			part.contributeToGraph(graph, map);
		}
		for (int i = 0; i < getChildren().size(); i++) {
			ActivityPart child = (ActivityPart) children.get(i);
			child.contributeEdgesToGraph(graph, map);
		}
	}

	public abstract void contributeNodesToGraph(CompoundDirectedGraph graph,
			Subgraph s, Map map);

	/**
	 * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
	 */
	protected void createEditPolicies() {
	}

	/**
	 * @see org.eclipse.gef.EditPart#deactivate()
	 */
	public void deactivate() {
		super.deactivate();
		getActivity().removePropertyChangeListener(this);
	}

	/**
	 * Returns the Activity model associated with this EditPart
	 * 
	 * @return the Activity model
	 */
	protected IGComponent getActivity() {
		return (IGComponent) getModel();
	}

	/**
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#getModelSourceConnections()
	 * @deprecated
	 */
	protected List getModelSourceConnections() {
		return getActivity().getOutgoingConnections();
	}

	/**
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#getModelTargetConnections()
	 * @deprecated
	 */
	protected List getModelTargetConnections() {
		return getActivity().getIncomingConnections();
	}

	abstract int getAnchorOffset();

	/**
	 * @see NodeEditPart#getSourceConnectionAnchor(org.eclipse.gef.ConnectionEditPart)
	 */
	public ConnectionAnchor getSourceConnectionAnchor(
			ConnectionEditPart connection) {
		return new BorderAnchor(getFigure(), BorderAnchor.BOTTOM, getAnchorOffset());
	}

	/**
	 * @see org.eclipse.gef.NodeEditPart#getSourceConnectionAnchor(org.eclipse.gef.Request)
	 */
	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		return new BorderAnchor(getFigure(), BorderAnchor.BOTTOM, getAnchorOffset());
	}

	/**
	 * @see NodeEditPart#getTargetConnectionAnchor(org.eclipse.gef.ConnectionEditPart)
	 */
	public ConnectionAnchor getTargetConnectionAnchor(
			ConnectionEditPart connection) {
		return new BorderAnchor(getFigure(), BorderAnchor.TOP, getAnchorOffset());
	}

	/**
	 * @see org.eclipse.gef.NodeEditPart#getTargetConnectionAnchor(org.eclipse.gef.Request)
	 */
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		return new BorderAnchor(getFigure(), BorderAnchor.TOP, getAnchorOffset());
	}

	/**
	 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
	 */
	public void propertyChange(PropertyChangeEvent evt) {
		String prop = evt.getPropertyName();
		if (GStructured.CHILDREN.equals(prop))
			refreshChildren();
		else if (GComponent.INPUTS.equals(prop))
			refreshTargetConnections();
		else if (GComponent.OUTPUTS.equals(prop))
			refreshSourceConnections();
		else if (GComponent.NAME.equals(prop))
			refreshVisuals();

		// Causes Graph to re-layout
		((GraphicalEditPart) (getViewer().getContents())).getFigure()
				.revalidate();
	}

	/**
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#setFigure(org.eclipse.draw2d.IFigure)
	 */
	protected void setFigure(IFigure figure) {
		figure.getBounds().setSize(0, 0);
		super.setFigure(figure);
	}

	/**
	 * @see org.eclipse.gef.editparts.AbstractEditPart#toString()
	 */
	public String toString() {
		return getModel().toString();
	}

	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractEditPart#setSelected(int)
	 */
	public void setSelected(int value) {
		super.setSelected(value);
		
		final int lineWidth = value != EditPart.SELECTED_NONE ? 2 : 1;
		final Color lineColor = value != EditPart.SELECTED_NONE ? ColorConstants.red : ColorConstants.black;
		

		if (sourceConnections!= null) {
			for (Iterator iter = sourceConnections.iterator(); iter.hasNext(); ) {
				PolylineConnection pc = (PolylineConnection) ((TransitionPart) iter.next()).getFigure();
				
				pc.setLineWidth(lineWidth);
				pc.setForegroundColor(lineColor);
			}
		}
		if (targetConnections!= null) {
			for (Iterator iter = targetConnections.iterator(); iter.hasNext(); ) {
				PolylineConnection pc = (PolylineConnection) ((TransitionPart) iter.next()).getFigure();
				
				pc.setLineWidth(lineWidth);
				pc.setForegroundColor(lineColor);

				/*Object o = iter.next();
				if (o instanceof PolylineConnection) {
					((PolylineConnection) getFigure()).setLineWidth(lineWidth);
				} else if (o instanceof TransitionPart) {
					((PolylineConnection) ((TransitionPart) o).getFigure())
							.setLineWidth(lineWidth);
				}*/
			}
		}
	}

}