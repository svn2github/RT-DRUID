/*
 * Created on Feb 21, 2005
 *
 * $Id: GraphicalElement.java,v 1.1 2005/09/28 15:22:29 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.mapping.functionalviewer.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;

/**
 * A class common to all Graphical Elements
 * 
 * @author Nicola Serreli
 */
abstract public class GraphicalElement implements IPropertySource {

	/** All listeners */
	transient protected PropertyChangeSupport listeners = new PropertyChangeSupport(
			this);

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
	public void addPropertyChangeListener(PropertyChangeListener l) {
		listeners.addPropertyChangeListener(l);
	}

	/**
	 * Remove a PropertyChangeListener.
	 * 
	 * If the same listener was added more than one time, removes only one copy.
	 * If the listener isn't found no exception is throwed.
	 * 
	 * @param l
	 *            the PropertyChangeListener
	 */
	public void removePropertyChangeListener(PropertyChangeListener l) {
		listeners.removePropertyChangeListener(l);
	}

	/**
	 * Fire a PropertyChange event.
	 * 
	 * @param prop
	 *            a string that identifies the property
	 * @param old
	 *            the old value
	 * @param newValue
	 *            contains the new value
	 */
	protected void firePropertyChange(String prop, Object old, Object newValue) {
		listeners.firePropertyChange(prop, old, newValue);
	}

	/**
	 * Fire a PropertyChange event.
	 * 
	 * @param prop
	 *            a string that identifies the property
	 * @param child
	 *            contains the new value
	 */
	protected void fireStructureChange(String prop, Object child) {
		listeners.firePropertyChange(prop, null, child);
	}

	/***************************************************************************
	 * Properties
	 **************************************************************************/

	/** @inheritDoc */
	public Object getEditableValue() {
		return this;
	}

	/** @inheritDoc */
	public IPropertyDescriptor[] getPropertyDescriptors() {
		return new IPropertyDescriptor[0];
	}

	/** @inheritDoc */
	public Object getPropertyValue(Object propName) {
		return null;
	}

	/** @inheritDoc */
	public boolean isPropertySet(Object propName) {
		return true;
	}

	/** @inheritDoc */
	public void resetPropertyValue(Object propName) {
	}

	/** @inheritDoc */
	public void setPropertyValue(Object propName, Object val) {
	}

}