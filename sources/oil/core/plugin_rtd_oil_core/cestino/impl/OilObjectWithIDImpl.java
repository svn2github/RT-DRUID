/**
 * <copyright>
 * </copyright>
 *
 * $Id: OilObjectWithIDImpl.java,v 1.2 2007/03/09 09:12:41 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.vartree.data.oil.impl;



import org.eclipse.emf.ecore.EClass;

import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.PublicObjectWithIDImpl;
import com.eu.evidence.rtdruid.vartree.data.ObjectWithID;
import com.eu.evidence.rtdruid.vartree.data.oil.OilApplPackage;
import com.eu.evidence.rtdruid.vartree.data.oil.OilObjectWithID;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object With ID</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated NOT
 */
public abstract class OilObjectWithIDImpl extends PublicObjectWithIDImpl implements OilObjectWithID {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OilObjectWithIDImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return OilApplPackage.eINSTANCE.getOilObjectWithID();
	}

	 /** Makes a new Instance of this object */
	 protected ObjectWithID newInstance() {
	 	return (ObjectWithID) OilApplFactoryImpl.eINSTANCE.create(eClass());
	 }
	 
	 protected String[] resolveID(String newID) {
		 return DataPath.resolveId(newID);
	 }

} //OilObjectWithIDImpl
