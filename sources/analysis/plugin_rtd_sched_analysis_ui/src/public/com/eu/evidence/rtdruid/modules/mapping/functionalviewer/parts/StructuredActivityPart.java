/*
 * Created on Feb 21, 2005
 *
 * $Id: StructuredActivityPart.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.mapping.functionalviewer.parts;

import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.graph.CompoundDirectedGraph;
import org.eclipse.draw2d.graph.Subgraph;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;

import com.eu.evidence.rtdruid.modules.mapping.functionalviewer.figures.SubSystemFigure;
import com.eu.evidence.rtdruid.modules.mapping.functionalviewer.model.GComponent;
import com.eu.evidence.rtdruid.modules.mapping.functionalviewer.model.GStructured;


/**
 * 
 * TODO : Commentare && Tradurre
 * 
 * @author Nicola Serreli
 */
public abstract class StructuredActivityPart extends ActivityPart implements
		NodeEditPart {

	static final Insets PADDING = new Insets(10);

	static final Insets INNER_PADDING = new Insets(0);
	
	protected void applyChildrenResults(CompoundDirectedGraph graph, Map map) {
		for (int i = 0; i < getChildren().size(); i++) {
			ActivityPart part = (ActivityPart) getChildren().get(i);
			part.applyGraphResults(graph, map);
		}
	}

	protected void applyGraphResults(CompoundDirectedGraph graph, Map map) {
		applyOwnResults(graph, map);
		applyChildrenResults(graph, map);
		
	}

	protected void applyOwnResults(CompoundDirectedGraph graph, Map map) {
		super.applyGraphResults(graph, map);
	}

	/**
	 * @see org.eclipse.gef.examples.flow.parts.ActivityPart#createEditPolicies()
	 */
	protected void createEditPolicies() {
	}

	public void contributeNodesToGraph(CompoundDirectedGraph graph, Subgraph s,
			Map map) {
		//	GraphAnimation.recordInitialState(getContentPane());
		Subgraph me = new Subgraph(this, s);
		me.outgoingOffset = 5;
		me.incomingOffset = 5;
		IFigure fig = getFigure();
		if (fig instanceof SubSystemFigure) {
			me.width = fig.getPreferredSize(me.width, me.height).width;
			int tagHeight = ((SubSystemFigure) fig).getHeader()
					.getPreferredSize().height;
			me.insets.top = tagHeight;
			me.insets.left = 0;
			me.insets.bottom = tagHeight;
		}
		me.innerPadding = INNER_PADDING;
		me.setPadding(PADDING);
		map.put(this, me);
		graph.nodes.add(me);
		for (int i = 0; i < getChildren().size(); i++) {
			ActivityPart activity = (ActivityPart) getChildren().get(i);
			activity.contributeNodesToGraph(graph, me, map);
		}
	}

	/**
	 * @see org.eclipse.gef.EditPart#performRequest(org.eclipse.gef.Request)
	 */
	public void performRequest(Request request) {
	}

	int getAnchorOffset() {
		return -1;
	}

	public IFigure getContentPane() {
		if (getFigure() instanceof SubSystemFigure)
			return ((SubSystemFigure) getFigure()).getContents();
		return getFigure();
	}

	protected List getModelChildren() {
		return getStructuredActivity().getChildren();
	}

	GStructured getStructuredActivity() {
		return (GStructured) getModel();
	}

	/**
	 * @see org.eclipse.gef.examples.flow.parts.ActivityPart#performDirectEdit()
	 */
	protected void performDirectEdit() {
	}

	/**
	 * @see org.eclipse.gef.editparts.AbstractEditPart#refreshVisuals()
	 */
	protected void refreshVisuals() {
		String name = ((GComponent) getActivity()).getName();
		
		((Label) ((SubSystemFigure) getFigure()).getHeader())
				.setText(name);
		((Label) ((SubSystemFigure) getFigure()).getFooter())
				.setText("/" + name);
	}

}