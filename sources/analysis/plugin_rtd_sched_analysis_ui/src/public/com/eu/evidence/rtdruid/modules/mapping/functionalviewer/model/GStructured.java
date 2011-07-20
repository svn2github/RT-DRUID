/*
 * Created on Feb 21, 2005
 *
 * $Id: GStructured.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.mapping.functionalviewer.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * 
 * TODO : Commentare && Tradurre
 * 
 * @author Nicola Serreli
 */
public abstract class GStructured extends GComponent {


	/** Identifies the property "Children", used by all structured objects */
	public static final String CHILDREN = "Children";

	protected List children = new ArrayList();

	public GStructured(EObject emfModel, String name, String prefix) {
		super(emfModel, name, prefix);
	}

	public void addChild(IGComponent child) {
		addChild(child, -1);
	}

	public void addChild(IGComponent child, int index) {
		if (index >= 0)
			children.add(index, child);
		else
			children.add(child);
		fireStructureChange(CHILDREN, child);
	}

	public List getChildren() {
		return children;
	}
/*
	public void removeChild(IGComponent child) {
		children.remove(child);
		fireStructureChange(CHILDREN, child);
	}
*/
}