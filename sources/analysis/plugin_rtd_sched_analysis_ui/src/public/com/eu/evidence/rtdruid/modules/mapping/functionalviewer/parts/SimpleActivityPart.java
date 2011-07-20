/*
 * Created on Feb 21, 2005
 *
 * $Id: SimpleActivityPart.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.mapping.functionalviewer.parts;

import java.util.Map;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.graph.CompoundDirectedGraph;
import org.eclipse.draw2d.graph.Node;
import org.eclipse.draw2d.graph.Subgraph;

import com.eu.evidence.rtdruid.modules.mapping.functionalviewer.ImagesRepository;
import com.eu.evidence.rtdruid.modules.mapping.functionalviewer.figures.SimpleActivityLabel;
import com.eu.evidence.rtdruid.modules.mapping.functionalviewer.model.GComponent;


/**
 * 
 * TODO : Commentare && Tradurre
 * 
 * @author Nicola Serreli
 */
public class SimpleActivityPart extends ActivityPart {

	public void contributeNodesToGraph(CompoundDirectedGraph graph, Subgraph s,
			Map map) {
		Node n = new Node(this, s);
		n.outgoingOffset = getAnchorOffset();
		n.incomingOffset = getAnchorOffset();
		n.width = getFigure().getPreferredSize().width;
		n.height = getFigure().getPreferredSize().height;
		n.setPadding(new Insets(10, 8, 10, 12));
		map.put(this, n);
		graph.nodes.add(n);
	}

	/**
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
	 */
	protected IFigure createFigure() {
		Label l = new SimpleActivityLabel();
		l.setLabelAlignment(PositionConstants.LEFT);
		l.setIcon(ImagesRepository.getProcImg());
		return l;
	}

	int getAnchorOffset() {
		return 9;
	}

	protected void performDirectEdit() {
	}

	/**
	 * @see org.eclipse.gef.editparts.AbstractEditPart#refreshVisuals()
	 */
	protected void refreshVisuals() {
		((Label) getFigure()).setText(((GComponent) getActivity()).getName());
	}

}