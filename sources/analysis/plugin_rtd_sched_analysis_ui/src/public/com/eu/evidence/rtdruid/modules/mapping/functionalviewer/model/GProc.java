/*
 * Created on Feb 21, 2005
 *
 * $Id: GProc.java,v 1.1 2005/09/28 15:22:29 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.mapping.functionalviewer.model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.PropertyDescriptor;

/**
 * 
 * TODO : Commentare && Tradurre
 * 
 * @author Nicola Serreli
 */
public class GProc extends GComponent implements IGMethodsProvider,
		IGMethodsConsumer {
	protected HashMap providedMethods = new HashMap();

	protected ArrayList requiredMethods = new ArrayList();
	
	protected GGate outputGate;

	// -----------------------------
	
	protected IPropertyDescriptor[] descriptors = null;
	protected HashMap propertiesValues = null;

	public static final String METHOD_REF = "method ref";

	public static final String METHOD = "method";
	
	// ---------------------------------------------
	
	public GProc(EObject emfModel, String name, String prefix) {
		super(emfModel, name, prefix);
		outputGate = getNewGate();
		
		addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				descriptors = null;
			}
		});
	}

	public ProvidedMethod addProvidedMethods(String method) {
		
		if (!providedMethods.containsKey(method)) {
			ProvidedMethod answer = makeAProvidedMethod(method);
			providedMethods.put(method, answer);
			return answer;
		}
		return (ProvidedMethod) providedMethods.get(method);
	}

	// -------------------------

	public boolean addRequiredMethods(String method) {
		if (!requiredMethods.contains(method)) {
			requiredMethods.add(method);
			return true;
		}
		return false;
	}

	public boolean addRequiredMethods(String[] methods) {
		if (methods == null) {
			return false;
		}

		boolean ok = false;
		for (int i = 0; i < methods.length; i++) {
			boolean t = addRequiredMethods(methods[i]);
			ok |= t;
		}

		return ok;
	}

	public String[] getRequiredMethods() {
		return (String[]) requiredMethods.toArray(new String[requiredMethods
				.size()]);
	}

	// ----------------------------
	
	public GGate getOutputGate() {
		return outputGate;
	}
	
	//-----------------------------
	
	protected void computeProperties() {
		if (descriptors != null) {
			return;
		}
		descriptors = new IPropertyDescriptor[1+providedMethods.size() + requiredMethods.size()];
		propertiesValues = new HashMap();
		
		int index =0;
		descriptors[index] = new PropertyDescriptor(NAME,"Name");
		propertiesValues.put(NAME, getName());
		index++;
		
		{ // add providedMethods
			Collection values = providedMethods.values();
			
			for (Iterator iter = values.iterator(); iter.hasNext(); index++) {
				String key = METHOD+index;
				ProvidedMethod gpm = (ProvidedMethod) iter.next();
				
				descriptors[index] = new PropertyDescriptor(key, gpm.getMethodName());
				((PropertyDescriptor) descriptors[index]).setCategory("Methods");
				propertiesValues.put(key, gpm.getLocalID());
			}
			
		}
		
		{ // add providedMethods

			for (Iterator iter = requiredMethods.iterator(); iter.hasNext(); index++) {
				String key = METHOD_REF+index;
				String o = (String) iter.next();
				
				descriptors[index] = new PropertyDescriptor(key, o);
				((PropertyDescriptor) descriptors[index]).setCategory("Methods Ref");
				propertiesValues.put(key, o);
			}
			
		}
		
		
	}

	
	/**
	 * Returns an Object which represents the appropriate value for the property
	 * name supplied.
	 * 
	 * @param propName
	 *            Name of the property for which the the values are needed.
	 * @return Object which is the value of the property.
	 */
	public Object getPropertyValue(Object propName) {
		if (propertiesValues!=null) {
			if (propertiesValues.containsKey(propName)) {
				return propertiesValues.get(propName);
			}
		}
		return super.getPropertyValue(propName);
	}
	/**
	 * Returns useful property descriptors for the use in property sheets. this
	 * supports location and size.
	 * 
	 * @return Array of property descriptors.
	 */
	public IPropertyDescriptor[] getPropertyDescriptors() {
		computeProperties();
		return descriptors;
	}

}