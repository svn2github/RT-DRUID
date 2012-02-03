/**
 * <copyright>
 * </copyright>
 *
 * $Id: ObjectWithIDItemProvider.java,v 1.1 2005/09/28 15:22:29 durin Exp $
 */
package com.eu.evidence.rtdruid.vartree;



import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.eu.evidence.rtdruid.internal.vartree.data.provider.ObjectWithIDItemProvider;

/**
 * This is the item provider adpater for a {@link rtdruid.vartree.data.ObjectWithID} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public abstract class PublicObjectWithIDItemProvider
	extends ObjectWithIDItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PublicObjectWithIDItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}
	
	public EStructuralFeature getChildFeatureContainer(Object owner,
			Object child) {
		return child == null ? null : getChildFeature(owner, child);
	}
}
