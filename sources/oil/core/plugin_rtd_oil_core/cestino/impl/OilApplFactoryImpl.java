/**
 * <copyright>
 * </copyright>
 *
 * $Id: OilApplFactoryImpl.java,v 1.3 2007/03/09 09:12:41 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.vartree.data.oil.impl;


import java.util.Arrays;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EFactoryImpl;

import com.eu.evidence.rtdruid.vartree.IVariable;
import com.eu.evidence.rtdruid.vartree.VarTreeIdHandler;
import com.eu.evidence.rtdruid.vartree.data.DataFactory;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.data.ExtendVar;
import com.eu.evidence.rtdruid.vartree.data.ExtendVarManager;
import com.eu.evidence.rtdruid.vartree.data.oil.Enumerator;
import com.eu.evidence.rtdruid.vartree.data.oil.HW;
import com.eu.evidence.rtdruid.vartree.data.oil.OilApplFactory;
import com.eu.evidence.rtdruid.vartree.data.oil.OilApplPackage;
import com.eu.evidence.rtdruid.vartree.data.oil.RTOS;
import com.eu.evidence.rtdruid.vartree.data.oil.Root;
import com.eu.evidence.rtdruid.vartree.data.oil.Value;
import com.eu.evidence.rtdruid.vartree.data.oil.Variant;
import com.eu.evidence.rtdruid.vartree.variables.BooleanVar;
import com.eu.evidence.rtdruid.vartree.variables.IntegerVar;
import com.eu.evidence.rtdruid.vartree.variables.OilVarMP;
import com.eu.evidence.rtdruid.vartree.variables.StringDescrVar;
import com.eu.evidence.rtdruid.vartree.variables.StringVar;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OilApplFactoryImpl extends EFactoryImpl implements OilApplFactory {
	/**
	 * Creates and instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OilApplFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case OilApplPackage.ROOT: return createRoot();
			case OilApplPackage.HW: return createHW();
			case OilApplPackage.RTOS: return createRTOS();
			case OilApplPackage.VARIANT: return createVariant();
			case OilApplPackage.VALUE: return createValue();
			case OilApplPackage.ENUMERATOR: return createEnumerator();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/** If the initValue is empty or null, return a null object */
	public Object createFromString(EDataType eDataType, String initialValue) {
	  	if (initialValue == null || initialValue.length() == 0) {
	  		return null; 
	  	}
	    
		return createFromStringGen(eDataType, initialValue);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object createFromStringGen(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case OilApplPackage.STRING_VAR:
				return createStringVarFromString(eDataType, initialValue);
			case OilApplPackage.VAR_WITH_DESCR_VAR:
				return createVarWithDescrVarFromString(eDataType, initialValue);
			case OilApplPackage.INTEGER_VAR:
				return createIntegerVarFromString(eDataType, initialValue);
			case OilApplPackage.BOOLEAN_VAR:
				return createBooleanVarFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case OilApplPackage.STRING_VAR:
				return convertStringVarToString(eDataType, instanceValue);
			case OilApplPackage.VAR_WITH_DESCR_VAR:
				return convertVarWithDescrVarToString(eDataType, instanceValue);
			case OilApplPackage.INTEGER_VAR:
				return convertIntegerVarToString(eDataType, instanceValue);
			case OilApplPackage.BOOLEAN_VAR:
				return convertBooleanVarToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Root createRoot() {
		RootImpl root = new RootImpl();
		return root;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HW createHW() {
		HWImpl hw = new HWImpl();
		return hw;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RTOS createRTOS() {
		RTOSImpl rtos = new RTOSImpl();
		return rtos;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variant createVariant() {
		VariantImpl variant = new VariantImpl();
		return variant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Value createValue() {
		ValueImpl value = new ValueImpl();
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Enumerator createEnumerator() {
		EnumeratorImpl enumerator = new EnumeratorImpl();
		return enumerator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public StringVar createStringVarFromString(EDataType eDataType, String initialValue) {
		return new StringVar(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertStringVarToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public StringDescrVar createVarWithDescrVarFromString(EDataType eDataType, String initialValue) {
		return new StringDescrVar(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVarWithDescrVarToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public IntegerVar createIntegerVarFromString(EDataType eDataType, String initialValue) {
		return new IntegerVar(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIntegerVarToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public BooleanVar createBooleanVarFromString(EDataType eDataType, String initialValue) {
		return new BooleanVar(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBooleanVarToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OilApplPackage getOilApplPackage() {
		return (OilApplPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static OilApplPackage getPackage() {
		return OilApplPackage.eINSTANCE;
	}

	static {
		ExtendVarManager.extendVariable(DataPackage.eINSTANCE.getOilVar(), OilVarMP.class,  new ExtendVar() {
			public Object createFromString(String initialValue) {
				return new OilVarMP(initialValue);
				}
		
			public String convertToString(Object instanceValue) {
				if (instanceValue == null) {
					return null;
				}
				if (instanceValue instanceof IVariable) {
					
					if (((OilVarMP) instanceValue).get() == null) {
						return null;
					}
				}

				return "" + instanceValue;
			}
		});
	}
	
} //OilApplFactoryImpl
