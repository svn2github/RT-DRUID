/*
 * Created on Feb 21, 2005
 *
 * $Id: TransitionPart.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.mapping.functionalviewer.parts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.AbsoluteBendpoint;
import org.eclipse.draw2d.BendpointConnectionRouter;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.graph.CompoundDirectedGraph;
import org.eclipse.draw2d.graph.Edge;
import org.eclipse.draw2d.graph.Node;
import org.eclipse.draw2d.graph.NodeList;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;

/**
 * 
 * TODO : Commentare && Tradurre
 * 
 * @author Nicola Serreli
 */
public class TransitionPart extends AbstractConnectionEditPart {

	protected void applyGraphResults(CompoundDirectedGraph graph, Map map) {
		Edge e = (Edge) map.get(this);
		NodeList nodes = e.vNodes;
		PolylineConnection conn = (PolylineConnection) getConnectionFigure();
		conn.setTargetDecoration(new PolygonDecoration());
		if (nodes != null) {
			List bends = new ArrayList();
			for (int i = 0; i < nodes.size(); i++) {
				Node vn = nodes.getNode(i);
				int x = vn.x;
				int y = vn.y;
				if (e.isFeedback) {
					bends.add(new AbsoluteBendpoint(x, y + vn.height));
					bends.add(new AbsoluteBendpoint(x, y));

				} else {
					bends.add(new AbsoluteBendpoint(x, y));
					bends.add(new AbsoluteBendpoint(x, y + vn.height));
				}
			}
			conn.setRoutingConstraint(bends);
		} else {
			conn.setRoutingConstraint(Collections.EMPTY_LIST);
		}
	}

	/**
	 * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
	 */
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE, null);
				//new ConnectionEndpointEditPolicy());
	}

	/**
	 * @see org.eclipse.gef.editparts.AbstractConnectionEditPart#createFigure()
	 */
	protected IFigure createFigure() {
		
		PolylineConnection conn = (PolylineConnection) super.createFigure();
		conn.setLineStyle(Graphics.LINE_DASH);
		conn.setConnectionRouter(
				
				/**/
				new BendpointConnectionRouter() {
					String tmp="";
					public String toString() {
						return getModel().toString() + " {"+ tmp+ "}";
					}
					public void route(Connection conn) {
						tmp = ""+getConstraint(conn);
						super.route(conn);
					}
					
					public void setConstraint(Connection connection,
							Object constraint) {
						if (constraint instanceof Collection && !((Collection)constraint).isEmpty()) {
							System.out.print("");
						}
						super.setConstraint(connection, constraint);
					}
				}
				//new FanRouter()
				//new ManhattanConnectionRouter()
				
				/*new BendpointConnectionRouter() {
			public void route(Connection conn) {
				//			GraphAnimation.recordInitialState(conn);
				//			if (!GraphAnimation.playbackState(conn))
				super.route(conn);
			}
		}*/);

		conn.setTargetDecoration(new PolygonDecoration());
		return conn;
	}

	/**
	 * @see org.eclipse.gef.EditPart#setSelected(int)
	 */
	public void setSelected(int value) {
		super.setSelected(value);
		if (value != EditPart.SELECTED_NONE)
			((PolylineConnection) getFigure()).setLineWidth(2);
		else
			((PolylineConnection) getFigure()).setLineWidth(1);
	}

	public void contributeToGraph(CompoundDirectedGraph graph, Map map) {
		//	GraphAnimation.recordInitialState(getConnectionFigure());
		Node source = (Node) map.get(getSource());
		Node target = (Node) map.get(getTarget());
		Edge e = new Edge(this, source, target);
		e.weight = 2;
		graph.edges.add(e);
		map.put(this, e);
	}

}