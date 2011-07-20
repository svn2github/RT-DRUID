/*
 * Created on Feb 21, 2005
 *
 * $Id: GConnection.java,v 1.1 2005/09/28 15:22:29 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.mapping.functionalviewer.model;

import org.eclipse.ui.views.properties.IPropertyDescriptor;

/**
 * 
 * TODO : Commentare && Tradurre
 * 
 * @author Nicola Serreli
 */
abstract public class GConnection extends GraphicalElement {

	public static final String SOURCE = "source";
	public static final String TARGET = "target";

	public static final int DIRECT_CONN  = 0;
	public static final int REVERSE_CONN = 1;
	public static final int NONE_CONN    = 2;
	
	// ------------------------------------------
	
	final public GGate sourceGate;

	final public GGate targetGate;
	
	final public int connectionType;

	// ------------------------------------------
	
	public GConnection(GGate sourceGate, GGate targetGate) {
		this(sourceGate, targetGate, DIRECT_CONN);
	}

	
	public GConnection(GGate sourceGate, GGate targetGate, int connType) {
		
		// checks
		if (sourceGate == null || targetGate == null) {
			throw new IllegalArgumentException("Gates cannot be null");
		}
		
		// set up values

		this.sourceGate = sourceGate; 
		this.targetGate = targetGate;

		this.connectionType = connType;

		if (connType != NONE_CONN) {
			sourceGate.parent.addOutput(this);
			targetGate.parent.addInput(this);
		}
	}

	// -------------------------------------------
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eu.evidence.rtdruid.modules.mapping.functionalviewer.model.GraphicalElement#getPropertyDescriptors()
	 */
	abstract public IPropertyDescriptor[] getPropertyDescriptors();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eu.evidence.rtdruid.modules.mapping.functionalviewer.model.GraphicalElement#getPropertyValue(java.lang.Object)
	 */
	public Object getPropertyValue(Object propName) {
		if (SOURCE.equals(propName))
			return "" + sourceGate.parent;
		if (TARGET.equals(propName))
			return "" + targetGate.parent;
		return super.getPropertyValue(propName);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Connection from " + sourceGate.parent + " to " + targetGate.parent;
	}
}