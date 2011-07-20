/*
 * Created on Feb 21, 2005
 *
 * $Id: GSubsystem.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.mapping.functionalviewer.model;

import java.util.ArrayList;
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
public class GSubsystem extends GStructured {

	/**
	 * Describes a SubSystem RequiredInterface.
	 * 
	 * The subsystem provides a method to children and it requires a method from
	 * its siblings or its parent.
	 */
	public class GRequiredInterface {
		public final String externalMethod;
		public final GGate externalGate; 

		public final ProvidedMethod internalMethod;

		public GRequiredInterface(String external, GGate externalGate, ProvidedMethod internal) {
			this.externalMethod = external;
			this.externalGate = externalGate;
			this.internalMethod = internal;
		}
		
		
	}

	/**
	 * Describes a SubSystem ProvidedInterface.
	 * 
	 * The subsystem provides a method to its siblings or its parent and it
	 * requires a method from its children.
	 */
	public class GProvidedInterface {
		public final ProvidedMethod externalMethod;

		public final String internalMethod;
		public final GGate internalGate; 

		public GProvidedInterface(ProvidedMethod external, String internal, GGate internalGate) {
			this.externalMethod = external;
			this.internalMethod = internal;
			this.internalGate = internalGate;
		}
	}

	ArrayList providedInterfaces = new ArrayList();

	ArrayList requiredInterfaces = new ArrayList();

	protected static IPropertyDescriptor[] descriptors;
	
	static {
		descriptors = new IPropertyDescriptor[] {
				new PropertyDescriptor(NAME,"Name")
		};
	}

	/**
	 *  
	 */
	public GSubsystem(EObject emfModel, String name, String prefix) {
		super(emfModel, name, prefix);
	}

	// ------------- PROVIDED INTERFACE -----------------

	public GProvidedInterface searchProvidedInterface(ProvidedMethod externalMethod) {
		GProvidedInterface answer = null;
		for (Iterator iter = providedInterfaces.iterator(); answer == null
				&& iter.hasNext();) {
			GProvidedInterface tmp = (GProvidedInterface) iter.next();
			if (externalMethod == tmp.externalMethod) {
				answer = tmp;
			}
		}
		return answer;
	} 
	
	
	protected GProvidedInterface searchProvidedInterface(String externalId) {
		GProvidedInterface answer = null;
		for (Iterator iter = providedInterfaces.iterator(); answer == null
				&& iter.hasNext();) {
			GProvidedInterface tmp = (GProvidedInterface) iter.next();
			if (externalId.equals(tmp.externalMethod.getMethodName())) {
				answer = tmp;
			}
		}
		return answer;
	}

	public GProvidedInterface addProvidedInterface(String externalName,
			String internalMethodId) {
		GProvidedInterface gpi = searchProvidedInterface(externalName);

		if (gpi != null) {
			boolean ok = gpi.internalMethod == null ? internalMethodId == null
					: gpi.internalMethod.equals(internalMethodId);

			if (!ok) {
				throw new RuntimeException(
						"A provided interface that required 2 distinct internal methods.");
			}
			return gpi;
		}

		gpi = new GProvidedInterface(makeAProvidedMethod(externalName), internalMethodId, getNewGate());
		providedInterfaces.add(gpi);

		return gpi;
	}

	public GProvidedInterface[] getProvidedInterface() {
		return (GProvidedInterface[]) providedInterfaces
				.toArray(new GProvidedInterface[providedInterfaces.size()]);
	}

	// -------------------------

	public GRequiredInterface searchRequiredInterface(ProvidedMethod internalMethod) {
		GRequiredInterface answer = null;
		for (Iterator iter = requiredInterfaces.iterator(); answer == null
				&& iter.hasNext();) {
			GRequiredInterface tmp = (GRequiredInterface) iter.next();
			if (internalMethod == tmp.internalMethod) {
				answer = tmp;
			}
		}
		return answer;
	} 
	

	protected GRequiredInterface searchRequiredInterface(String internalId) {
		GRequiredInterface answer = null;
		for (Iterator iter = requiredInterfaces.iterator(); answer == null
				&& iter.hasNext();) {
			GRequiredInterface tmp = (GRequiredInterface) iter.next();
			if (internalId.equals(tmp.internalMethod.getMethodName())) {
				answer = tmp;
			}
		}
		return answer;
	}

	public GRequiredInterface addRequiredInterface(String externalMethodId,
			String internalName) {
		GRequiredInterface gpi = searchRequiredInterface(internalName);

		if (gpi != null) {
			boolean ok = gpi.externalMethod == null ? externalMethodId == null
					: gpi.externalMethod.equals(externalMethodId);

			if (!ok) {
				throw new RuntimeException(
						"A required interface that required 2 distinct external methods.");
			}
			return gpi;
		}

		gpi = new GRequiredInterface(externalMethodId, getNewGate(), makeAProvidedMethod(internalName));
		requiredInterfaces.add(gpi);

		return gpi;
	}

	public GRequiredInterface[] getRequiredInterface() {
		return (GRequiredInterface[]) requiredInterfaces
				.toArray(new GRequiredInterface[requiredInterfaces.size()]);
	}
	
	// ---------------------------------
	
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