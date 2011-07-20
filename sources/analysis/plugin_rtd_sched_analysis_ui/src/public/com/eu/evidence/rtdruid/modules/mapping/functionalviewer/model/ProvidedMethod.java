/*
 * Created on Feb 22, 2005
 *
 * $Id: ProvidedMethod.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.mapping.functionalviewer.model;

/**
 * This class represents a method provided by a proc, var or a subSystem.
 * 
 * It is identified by a global Id and a local Id. Usualy each provided method
 * has a distinct
 * {@link com.eu.evidence.rtdruid.modules.mapping.functionalviewer.model.GGate GGate}, that is
 * own by provider of that instance of ProvidedMethod.
 * 
 * @author Nicola Serreli
 */
public class ProvidedMethod {

	/** Identifies the method inside the all system, using the "Evidence Path" */
	protected final String globalID;

	/** Identifies the method inside the subSystem that own the method's provider */
	protected final String localID;

	/** Identifies the method inside the provider */
	protected final String methodName;

	/** Identifies the provider's gate related to this method */
	protected final GGate gate;

	/** Identifies the Component (Proc, Var, SubSystem) that provided this method */
	protected final GComponent provider;

	/**
	 * Make a new instace of ProvidedMethod.
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
	 * @throws NullPointerException
	 *             if the gate isn't related to a GComponent
	 */
	public ProvidedMethod(String globalID, String localID, String methodName,
			GGate gate) {
		if (gate == null) {
			throw new NullPointerException("The Gate cannot be null");
		}
		if (globalID == null || localID == null || methodName == null) {
			throw new NullPointerException("Identifiers cannot be null");
		}
		if (!(gate.parent instanceof GComponent)) {
			throw new IllegalArgumentException(
					"The gate must be related to a GComponent");
		}
		this.globalID = globalID;
		this.localID = localID;
		this.methodName = methodName;
		this.gate = gate;
		this.provider = (GComponent) gate.parent;
	}

	/**
	 * @return the global identifier
	 */
	public String getGlobalID() {
		return globalID;
	}

	/**
	 * @return the identifier local to provider's subSystem
	 */
	public String getLocalID() {
		return localID;
	}

	/**
	 * @return the identifier local to provider
	 */
	public String getMethodName() {
		return methodName;
	}

	/**
	 * @return the gate related to this method
	 */
	public GGate getGate() {
		return gate;
	}

	/**
	 * @return the method's provider
	 */
	public GComponent getProvider() {
		return provider;
	}

	/**
	 * @return a string representation of this ProvidedMethod
	 */
	public String toString() {
		return "" + provider + " provides to " + localID;
	}
}