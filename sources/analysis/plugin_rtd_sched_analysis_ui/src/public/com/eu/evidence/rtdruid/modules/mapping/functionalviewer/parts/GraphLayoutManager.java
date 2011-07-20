/*
 * Created on Feb 21, 2005
 * 
 * $Id: GraphLayoutManager.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.mapping.functionalviewer.parts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.graph.CompoundDirectedGraph;
import org.eclipse.draw2d.graph.CompoundDirectedGraphLayout;

/**
 * 
 * TODO : Commentare && Tradurre
 * 
 * @author Nicola Serreli
 */
class GraphLayoutManager extends AbstractLayout {

	private ActivityDiagramPart diagram;

	GraphLayoutManager(ActivityDiagramPart diagram) {
		this.diagram = diagram;
	}

	protected Dimension calculatePreferredSize(IFigure container, int wHint,
			int hHint) {
		//	if (state == PLAYBACK)
		//		return container.getSize();
		container.validate();
		List children = container.getChildren();
		Rectangle result = new Rectangle().setLocation(container
				.getClientArea().getLocation());
		for (int i = 0; i < children.size(); i++)
			result.union(((IFigure) children.get(i)).getBounds());
		result.resize(container.getInsets().getWidth(), container.getInsets()
				.getHeight());
		return result.getSize();
	}

	public void layout(IFigure container) {
		//	GraphAnimation.recordInitialState(container);
		//	if (GraphAnimation.playbackState(container))
		//		return;

		CompoundDirectedGraph graph = new CompoundDirectedGraph();
		Map partsToNodes = new HashMap();
		diagram.contributeNodesToGraph(graph, null, partsToNodes);
		diagram.contributeEdgesToGraph(graph, partsToNodes);
		new CompoundDirectedGraphLayout().visit(graph);
		diagram.applyGraphResults(graph, partsToNodes);
	}

}