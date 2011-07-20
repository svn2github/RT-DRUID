/*
 * Created on Feb 21, 2005
 *
 * $Id: GVar.java,v 1.1 2005/09/28 15:22:29 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.mapping.functionalviewer.model;

import java.util.HashMap;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.PropertyDescriptor;

/**
 * 
 * TODO : Commentare && Tradurre
 * 
 * @author Nicola Serreli
 */
public class GVar extends GComponent implements IGMethodsProvider {
	
	protected static IPropertyDescriptor[] descriptors;
	
	static {
		descriptors = new IPropertyDescriptor[] {
				new PropertyDescriptor(NAME,"Name")
		};
	}

	
	HashMap providedMethods = new HashMap();

	
	public GVar(EObject emfModel, String name, String prefix) {
		super(emfModel, name, prefix);
	}

	public ProvidedMethod addProvidedMethods(String method) {
		
		if (!providedMethods.containsKey(method)) {
			ProvidedMethod answer = makeAProvidedMethod(method);
			providedMethods.put(method, answer);
			return answer;
		}
		return (ProvidedMethod) providedMethods.get(method);
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
		if (NAME.equals(propName))
			return getName();
		return super.getPropertyValue(propName);
	}
	/**
	 * Returns useful property descriptors for the use in property sheets. this
	 * supports location and size.
	 * 
	 * @return Array of property descriptors.
	 */
	public IPropertyDescriptor[] getPropertyDescriptors() {
		return descriptors;
	}

}