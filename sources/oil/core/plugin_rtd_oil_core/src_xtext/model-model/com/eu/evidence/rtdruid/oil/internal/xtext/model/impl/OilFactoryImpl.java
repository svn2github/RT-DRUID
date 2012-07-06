/**
 */
package com.eu.evidence.rtdruid.oil.internal.xtext.model.impl;

import com.eu.evidence.rtdruid.oil.xtext.model.EType;
import com.eu.evidence.rtdruid.oil.xtext.model.EnumeratorType;
import com.eu.evidence.rtdruid.oil.xtext.model.ObjectType;
import com.eu.evidence.rtdruid.oil.xtext.model.OilApplication;
import com.eu.evidence.rtdruid.oil.xtext.model.OilFactory;
import com.eu.evidence.rtdruid.oil.xtext.model.OilFile;
import com.eu.evidence.rtdruid.oil.xtext.model.OilImplementation;
import com.eu.evidence.rtdruid.oil.xtext.model.OilObject;
import com.eu.evidence.rtdruid.oil.xtext.model.OilPackage;
import com.eu.evidence.rtdruid.oil.xtext.model.PType;
import com.eu.evidence.rtdruid.oil.xtext.model.Parameter;
import com.eu.evidence.rtdruid.oil.xtext.model.Range;
import com.eu.evidence.rtdruid.oil.xtext.model.ReferenceType;
import com.eu.evidence.rtdruid.oil.xtext.model.VType;
import com.eu.evidence.rtdruid.oil.xtext.model.ValueList;
import com.eu.evidence.rtdruid.oil.xtext.model.ValueType;
import com.eu.evidence.rtdruid.oil.xtext.model.VariantType;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OilFactoryImpl extends EFactoryImpl implements OilFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OilFactory init() {
		try {
			OilFactory theOilFactory = (OilFactory)EPackage.Registry.INSTANCE.getEFactory("http://com.eu.evidence.rtdruid.oil.xtext.model"); 
			if (theOilFactory != null) {
				return theOilFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new OilFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OilFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case OilPackage.OIL_OBJECT: return createOilObject();
			case OilPackage.PARAMETER: return createParameter();
			case OilPackage.OIL_APPLICATION: return createOilApplication();
			case OilPackage.OIL_IMPLEMENTATION: return createOilImplementation();
			case OilPackage.OIL_OBJECT_IMPL: return createOilObjectImpl();
			case OilPackage.VALUE_TYPE: return createValueType();
			case OilPackage.ENUMERATOR_TYPE: return createEnumeratorType();
			case OilPackage.VARIANT_TYPE: return createVariantType();
			case OilPackage.OIL_FILE: return createOilFile();
			case OilPackage.REFERENCE_TYPE: return createReferenceType();
			case OilPackage.RANGE: return createRange();
			case OilPackage.VALUE_LIST: return createValueList();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case OilPackage.OBJECT_TYPE:
				return createObjectTypeFromString(eDataType, initialValue);
			case OilPackage.VTYPE:
				return createVTypeFromString(eDataType, initialValue);
			case OilPackage.ETYPE:
				return createETypeFromString(eDataType, initialValue);
			case OilPackage.PTYPE:
				return createPTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case OilPackage.OBJECT_TYPE:
				return convertObjectTypeToString(eDataType, instanceValue);
			case OilPackage.VTYPE:
				return convertVTypeToString(eDataType, instanceValue);
			case OilPackage.ETYPE:
				return convertETypeToString(eDataType, instanceValue);
			case OilPackage.PTYPE:
				return convertPTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OilObject createOilObject() {
		OilObjectImpl oilObject = new OilObjectImpl();
		return oilObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter createParameter() {
		ParameterImpl parameter = new ParameterImpl();
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OilApplication createOilApplication() {
		OilApplicationImpl oilApplication = new OilApplicationImpl();
		return oilApplication;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OilImplementation createOilImplementation() {
		OilImplementationImpl oilImplementation = new OilImplementationImpl();
		return oilImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public com.eu.evidence.rtdruid.oil.xtext.model.OilObjectImpl createOilObjectImpl() {
		OilObjectImplImpl oilObjectImpl = new OilObjectImplImpl();
		return oilObjectImpl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueType createValueType() {
		ValueTypeImpl valueType = new ValueTypeImpl();
		return valueType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumeratorType createEnumeratorType() {
		EnumeratorTypeImpl enumeratorType = new EnumeratorTypeImpl();
		return enumeratorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariantType createVariantType() {
		VariantTypeImpl variantType = new VariantTypeImpl();
		return variantType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OilFile createOilFile() {
		OilFileImpl oilFile = new OilFileImpl();
		return oilFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceType createReferenceType() {
		ReferenceTypeImpl referenceType = new ReferenceTypeImpl();
		return referenceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Range createRange() {
		RangeImpl range = new RangeImpl();
		return range;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueList createValueList() {
		ValueListImpl valueList = new ValueListImpl();
		return valueList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectType createObjectTypeFromString(EDataType eDataType, String initialValue) {
		ObjectType result = ObjectType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertObjectTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VType createVTypeFromString(EDataType eDataType, String initialValue) {
		VType result = VType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EType createETypeFromString(EDataType eDataType, String initialValue) {
		EType result = EType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertETypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PType createPTypeFromString(EDataType eDataType, String initialValue) {
		PType result = PType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OilPackage getOilPackage() {
		return (OilPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static OilPackage getPackage() {
		return OilPackage.eINSTANCE;
	}

} //OilFactoryImpl
