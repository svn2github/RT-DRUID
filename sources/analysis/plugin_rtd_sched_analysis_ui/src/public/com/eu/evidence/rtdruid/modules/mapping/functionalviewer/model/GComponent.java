/*
 * Created on Feb 21, 2005
 *
 * $Id: GComponent.java,v 1.2 2006/03/09 09:33:00 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.mapping.functionalviewer.model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.tools.Utility;

/**
 * This class describes a graphical element directly associated to an EMF
 * Object.
 * 
 * Usualy these elements have a name and a set of input and output connections. 
 * 
 * @author Nicola Serreli
 */
public abstract class GComponent extends GraphicalElement implements
		IGComponent {

	/***************************************************************************
	 * 
	 * Property's Keywords Definition
	 *  
	 **************************************************************************/

	/** Identifies the property Name */
	public static final String NAME = "name";

	/** Identifies the property with all Intput Connections */
	public static final String INPUTS = "inputs";

	/** Identifies the property with all Output Connections */
	public static final String OUTPUTS = "outputs";

	/** Prefix of root's nodes */
	public static final String ROOT_PREFIX = "";// + DataPath.SEPARATOR;

	/***************************************************************************
	 * 
	 * Internal data
	 *  
	 **************************************************************************/

	/** Identifies this object */
	private String name;

	/**
	 * Identifies the parent's path inside the VarTree structure (an VarTree
	 * Path)
	 */
	final protected String prefix;

	/** Contains all input connections */
	private ArrayList inputs = new ArrayList();

	/** Contains all output connections */
	private ArrayList outputs = new ArrayList();

	/** The EMF Object that this Graphical Component represents */
	final protected EObject emfModel;

	/***************************************************************************
	 * 
	 * Constructor
	 *  
	 **************************************************************************/

	/* *
	 * Constructs a new Graphical Component with a specified name.
	 * 
	 * The prefix is empty (see {@link GComponent#ROOT_PREFIX ROOT_PREFIX}).
	 * 
	 * @param o
	 *            the EMF Object represented by this GComponent
	 * @param name
	 *            a name for this object
	 * 
	 * @deprecated
	 * /
	public GComponent(EObject o, String name) {
		this.emfModel = o;
		this.name = name;
		this.prefix = ROOT_PREFIX;
	}*/

	/**
	 * Constructs a new Graphical Component with a specified name.
	 * 
	 * @param o
	 *            the EMF Object represented by this GComponent
	 * @param name
	 *            a name for this object
	 * @param prefix
	 *            identifies the container of this GComponent
	 */
	public GComponent(EObject o, String name, String prefix) {
		this.emfModel = o;
		this.name = name;
		this.prefix = prefix != null ? prefix : ROOT_PREFIX;
	}

	// -----------------------------------------------------------------

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eu.evidence.rtdruid.modules.mapping.functionalviewer.model.IGComponent#getEmfObject()
	 */
	public EObject getEmfObject() {
		return emfModel;
	}

	/**
	 * Returns the name of this GComponent
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set a new name
	 */
	protected void setName(String s) {
		name = s;
		firePropertyChange(NAME, null, s);
	}

	/***************************************************************************
	 * 
	 * Connections
	 *  
	 **************************************************************************/

	/**
	 * Adds a new input connection.
	 * 
	 * The connection is added and a Structure Change is fired, only if the
	 * specified connection isn't alredy an input connection of this GComponent.
	 * 
	 * @param connection
	 *            the new input connection
	 * 
	 * @throws NullPointerException
	 *             if the specified connection is null
	 * @throws IllegalArgumentException
	 *             if the specified connection is already an output connection
	 *             of this GComponent
	 */
	public void addInput(GConnection connection) {
		if (connection == null) {
			throw new NullPointerException(
					"Cannot add a null input connection.");
		}
		if (outputs.contains(connection)) {
//			throw new IllegalArgumentException(
//					"Cannot add an input connection that is already an output connection of this GComponent.");
		}
		if (!inputs.contains(connection)) {
			inputs.add(connection);
			fireStructureChange(INPUTS, connection);
		}
	}

	/**
	 * Adds a new output connection.
	 * 
	 * The connection is added and a Structure Change is fired, only if the
	 * specified connection isn't alredy an output connection of this
	 * GComponent.
	 * 
	 * @param connection
	 *            the new output connection
	 * 
	 * @throws NullPointerException
	 *             if the specified connection is null
	 * @throws IllegalArgumentException
	 *             if the specified connection is already an input connection of
	 *             this GComponent
	 */
	public void addOutput(GConnection connection) {
		if (connection == null) {
			throw new NullPointerException(
					"Cannot add a null output connection.");
		}
		if (inputs.contains(connection)) {
			throw new IllegalArgumentException(
					"Cannot add an output connection that is already an intput connection of this GComponent.");
		}
		if (!outputs.contains(connection)) {
			outputs.add(connection);
			fireStructureChange(OUTPUTS, connection);
		}
	}

	/**
	 * Returns all incoming connections
	 *
	 * @return a not null list with all incoming connections  
	 */
	public List getIncomingConnections() {
		return Collections.unmodifiableList(inputs);
	}

	/**
	 * Returns all outgoing connections
	 *
	 * @return a not null list with all outgoing connections  
	 */
	public List getOutgoingConnections() {
		return Collections.unmodifiableList(outputs);
	}

	public void removeInput(GConnection transition) {
		inputs.remove(transition);
		fireStructureChange(INPUTS, transition);
	}

	public void removeOutput(GConnection transition) {
		outputs.remove(transition);
		fireStructureChange(OUTPUTS, transition);
	}

	/***************************************************************************
	 * 
	 * Properties
	 *  
	 **************************************************************************/

	/**
	 * Sets the value of a given property with the value supplied.
	 * 
	 * @param id
	 *            Name of the parameter to be changed.
	 * @param value
	 *            Value to be set to the given parameter.
	 */
	public void setPropertyValue(Object id, Object value) {
		//if (id == NAME)
		//	setName((String) value);
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String className = getClass().getName();
		className = className.substring(className.lastIndexOf('.') + 1);
		return className + "(" + name + ")";
	}

	/***************************************************************************
	 * 
	 * Gate
	 *  
	 **************************************************************************/

	/**
	 * Constructs a new gate for this GComponent.
	 * 
	 * @return a new instance of GGate
	 */
	protected GGate getNewGate() {
		return new GGate(this);
	}

	/**
	 * Makes a new Method Provided by this GComponent with specified name.
	 * 
	 * Each ProvidedMethod is init with a distinct GGate.
	 * 
	 * @param methodName
	 *            identifies the method inside this GComponent
	 */
	protected ProvidedMethod makeAProvidedMethod(String methodName) {
		final char S = DataPath.SEPARATOR;

		// 1. prepare local ID
		final String localID = Utility.pathToEvidence(DataPath.addSlash(name)
				+ S + DataPath.addSlash(methodName));

		// 2. prepare global ID
		final String globalId = (ROOT_PREFIX.equals(prefix) ? "" : prefix + S) + localID;

		// 3. make the new ProvidedMethod
		return new GProvidedMethod(globalId, localID, methodName, getNewGate());
	}
}