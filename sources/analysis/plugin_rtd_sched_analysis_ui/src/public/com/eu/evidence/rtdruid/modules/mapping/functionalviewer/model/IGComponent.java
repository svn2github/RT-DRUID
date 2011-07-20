/*
 * Created on Feb 22, 2005
 *
 * $Id: IGComponent.java,v 1.1 2005/09/28 15:22:29 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.mapping.functionalviewer.model;

import java.beans.PropertyChangeListener;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.views.properties.IPropertySource;

/**
 * A Graphical component that is associated to an EMF Object.
 * 
 * @author Nicola Serreli
 */
public interface IGComponent extends IPropertySource {
	
		
	/**
	 * Returns the EMF Object associated to current Graphical Component
	 */
	public EObject getEmfObject();

	/**
	 * Adds a new intput connection.
	 * 
	 * The connection is added and a Structure Change is fired, only if the
	 * specified connection isn't alredy an intput connection of this
	 * Graphical Component.
	 * 
	 * @param connection
	 *            the new output connection
	 * 
	 * @throws NullPointerException
	 *             if the specified connection is null
	 * @throws IllegalArgumentException
	 *             if the specified connection is already an output connection of
	 *             this Graphical Component
	 */
	public void addInput(GConnection connection);
	
	/**
	 * Adds a new output connection.
	 * 
	 * The connection is added and a Structure Change is fired, only if the
	 * specified connection isn't alredy an output connection of this
	 * Graphical Component.
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
	public void addOutput(GConnection connection);

	/**
	 * Returns all incoming connections
	 *
	 * @return a not null list with all incoming connections  
	 */
	public List getIncomingConnections();

	/**
	 * Returns all outgoing connections
	 *
	 * @return a not null list with all outgoing connections  
	 */
	public List getOutgoingConnections();

	
	/***************************************************************************
	 * Listner
	 **************************************************************************/

	/**
	 * Add a new PropertyChangeListener.
	 * 
	 * If the same listener is added more than one time, that listener is called
	 * more than one time.
	 * 
	 * @param l
	 *            the PropertyChangeListener
	 */
	public void addPropertyChangeListener(PropertyChangeListener l);

	/**
	 * Remove a PropertyChangeListener.
	 * 
	 * If the same listener was added more than one time, removes only one copy.
	 * If the listener isn't found no exception is throwed.
	 * 
	 * @param l
	 *            the PropertyChangeListener
	 */
	public void removePropertyChangeListener(PropertyChangeListener l);

}