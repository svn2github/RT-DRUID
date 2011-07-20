/*
 * Created on Feb 22, 2005
 *
 * $Id: GGate.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.mapping.functionalviewer.model;

/**
 * This class represents a specific Gate of a GComponent.
 * 
 * @author Nicola Serreli
 */
public class GGate {

	/** Identifies the node that is the owner of this Gate */
	final public IGComponent parent;

	/**
	 * Construct a new instance of GGate.
	 * 
	 * @param parent
	 *            the node that has this gate.
	 * 
	 * @throws NullPointerException
	 *             if parent is null
	 */
	public GGate(IGComponent parent) {
		if (parent == null) {
			throw new NullPointerException("parent cannot be null");
		}
		this.parent = parent;
	}
}