/*
 * Created on Feb 22, 2005
 *
 * $Id: GProvidedMethod.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.mapping.functionalviewer.model;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.views.properties.IPropertyDescriptor;

/**
 * This class represents an Provided Method inside the Partial Order Flow.
 * 
 * This class add to
 * {@link com.eu.evidence.rtdruid.modules.mapping.functionalviewer.model.ProvidedMethod ProvidedMethod}
 * class the
 * {@link com.eu.evidence.rtdruid.modules.mapping.functionalviewer.model.IGComponent IGComponent}
 * interface, with the possibility to add input and output connections, like
 * {@link com.eu.evidence.rtdruid.modules.mapping.functionalviewer.model.GPartialOrderConnection PartialOrderConnection}.
 * 
 * @author Nicola Serreli
 */
public class GProvidedMethod extends ProvidedMethod implements IGComponent {

	/** Contains all input connections */
	private ArrayList inputs = new ArrayList();

	/** Contains all output connections */
	private ArrayList outputs = new ArrayList();
	
	/** The gate for Activation's event */
	private final GGate gateActivation;

	/** The gate for Begin's event */
	private final GGate gateBegin;

	/** The gate for End's event */
	private final GGate gateEnd;

	
	/**
	 * Make a new instace of GProvidedMethod.
	 * 
	 * @param globalID
	 *            contains the global identifier of this method
	 * @param localId
	 *            contains the local identifier of this method
	 * @param methodName
	 *            is the name of this method inside its provider
	 * @param gate
	 *            is the provider's gate related to this method
	 * 
	 * @throws NullPointerException
	 *             if one parameter is null
	 */
	public GProvidedMethod(String globalID, String localID, String methodName,
			GGate gate) {
		super(globalID, localID, methodName, gate);
		
		gateActivation = new GGate(this);
		gateBegin = new GGate(this);
		gateEnd = new GGate(this);
	}
	
	/**
	 * Adds a new intput connection.
	 * 
	 * The connection is added only if the specified connection isn't alredy an
	 * intput connection of this Graphical Component.
	 * 
	 * @param connection
	 *            the new output connection
	 * 
	 * @throws NullPointerException
	 *             if the specified connection is null
	 * @throws IllegalArgumentException
	 *             if the specified connection is already an output connection
	 *             of this Graphical Component
	 */
	public void addInput(GConnection connection) {
		if (connection == null) {
			throw new NullPointerException(
					"Cannot add a null input connection.");
		}
		if (outputs.contains(connection)) {
//			throw new IllegalArgumentException(
			System.out.println(connection + ": "+
					"Cannot add an input connection that is already an output connection of this GProvidedMethod.");
			return;
		}
		if (!inputs.contains(connection)) {
			inputs.add(connection);
		}
	}
	
	/**
	 * Adds a new output connection.
	 * 
	 * The connection is added only if the specified connection isn't alredy an
	 * output connection of this Graphical Component.
	 * 
	 * @param connection
	 *            the new output connection
	 * 
	 * @throws NullPointerException
	 *             if the specified connection is null
	 * @throws IllegalArgumentException
	 *             if the specified connection is already an input connection of
	 *             this Graphical Component
	 */
	public void addOutput(GConnection connection) {
		if (connection == null) {
			throw new NullPointerException(
					"Cannot add a null output connection.");
		}
		if (inputs.contains(connection)) {
//			throw new IllegalArgumentException(
			System.out.println(connection + ": "+
					"Cannot add an output connection that is already an intput connection of this GProvidedMethod.");
			return;
		}
		if (!outputs.contains(connection)) {
			outputs.add(connection);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.modules.mapping.functionalviewer.model.IGComponent#getIncomingConnections()
	 */
	public List getIncomingConnections() {
		return Collections.unmodifiableList(inputs);
	}
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.modules.mapping.functionalviewer.model.IGComponent#getOutgoingConnections()
	 */
	public List getOutgoingConnections() {
		return Collections.unmodifiableList(outputs);
	}
	
	/**
	 * Returns the EMF Object associated to current Graphical Component
	 */
	public EObject getEmfObject() {
		return provider == null ? null : provider.getEmfObject();
	}
	
	// ----------- PROPERTIES ------------
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.IPropertySource#getEditableValue()
	 */
	public Object getEditableValue() {
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.IPropertySource#getPropertyDescriptors()
	 */
	public IPropertyDescriptor[] getPropertyDescriptors() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.IPropertySource#getPropertyValue(java.lang.Object)
	 */
	public Object getPropertyValue(Object id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.IPropertySource#isPropertySet(java.lang.Object)
	 */
	public boolean isPropertySet(Object id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.IPropertySource#resetPropertyValue(java.lang.Object)
	 */
	public void resetPropertyValue(Object id) {
		// TODO Auto-generated method stub

	}
	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.IPropertySource#setPropertyValue(java.lang.Object, java.lang.Object)
	 */
	public void setPropertyValue(Object id, Object value) {
		// TODO Auto-generated method stub

	}
	
	
	// ------------ PROPERTY CHANGE LISTENER --------------
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.modules.mapping.functionalviewer.model.IGComponent#addPropertyChangeListener(java.beans.PropertyChangeListener)
	 */
	public void addPropertyChangeListener(PropertyChangeListener l) {
		// TODO Auto-generated method stub

	}
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.modules.mapping.functionalviewer.model.IGComponent#removePropertyChangeListener(java.beans.PropertyChangeListener)
	 */
	public void removePropertyChangeListener(PropertyChangeListener l) {
		// TODO Auto-generated method stub

	}
	
	
	
	// ----------- GATE -------------------
	
	/**
	 * @return the gate related to method's Activation's event
	 */
	public GGate getActivationGate() {
		return gateActivation;
	}
	
	/**
	 * @return the gate related to method's Begin's event
	 */
	public GGate getBeginGate() {
		return gateBegin;
	}
	
	/**
	 * @return the gate related to method's End's event
	 */
	public GGate getEndGate() {
		return gateEnd;
	}
}