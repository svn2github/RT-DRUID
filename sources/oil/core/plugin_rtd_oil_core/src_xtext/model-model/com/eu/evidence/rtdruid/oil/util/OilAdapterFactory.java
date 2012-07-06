/**
 */
package com.eu.evidence.rtdruid.oil.util;

import com.eu.evidence.rtdruid.oil.xtext.model.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.eu.evidence.rtdruid.oil.xtext.model.OilPackage
 * @generated
 */
public class OilAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static OilPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OilAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = OilPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OilSwitch<Adapter> modelSwitch =
		new OilSwitch<Adapter>() {
			@Override
			public Adapter caseOilObject(OilObject object) {
				return createOilObjectAdapter();
			}
			@Override
			public Adapter caseParameter(Parameter object) {
				return createParameterAdapter();
			}
			@Override
			public Adapter caseOilApplication(OilApplication object) {
				return createOilApplicationAdapter();
			}
			@Override
			public Adapter caseOilImplementation(OilImplementation object) {
				return createOilImplementationAdapter();
			}
			@Override
			public Adapter caseOilObjectImpl(OilObjectImpl object) {
				return createOilObjectImplAdapter();
			}
			@Override
			public Adapter caseParameterType(ParameterType object) {
				return createParameterTypeAdapter();
			}
			@Override
			public Adapter caseValueType(ValueType object) {
				return createValueTypeAdapter();
			}
			@Override
			public Adapter caseEnumeratorType(EnumeratorType object) {
				return createEnumeratorTypeAdapter();
			}
			@Override
			public Adapter caseVariantType(VariantType object) {
				return createVariantTypeAdapter();
			}
			@Override
			public Adapter caseOilFile(OilFile object) {
				return createOilFileAdapter();
			}
			@Override
			public Adapter caseReferenceType(ReferenceType object) {
				return createReferenceTypeAdapter();
			}
			@Override
			public Adapter caseParameterRef(ParameterRef object) {
				return createParameterRefAdapter();
			}
			@Override
			public Adapter caseValidValues(ValidValues object) {
				return createValidValuesAdapter();
			}
			@Override
			public Adapter caseRange(Range object) {
				return createRangeAdapter();
			}
			@Override
			public Adapter caseValueList(ValueList object) {
				return createValueListAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.oil.xtext.model.OilObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.OilObject
	 * @generated
	 */
	public Adapter createOilObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.oil.xtext.model.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.Parameter
	 * @generated
	 */
	public Adapter createParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.oil.xtext.model.OilApplication <em>Application</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.OilApplication
	 * @generated
	 */
	public Adapter createOilApplicationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.oil.xtext.model.OilImplementation <em>Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.OilImplementation
	 * @generated
	 */
	public Adapter createOilImplementationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.oil.xtext.model.OilObjectImpl <em>Object Impl</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.OilObjectImpl
	 * @generated
	 */
	public Adapter createOilObjectImplAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.oil.xtext.model.ParameterType <em>Parameter Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.ParameterType
	 * @generated
	 */
	public Adapter createParameterTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.oil.xtext.model.ValueType <em>Value Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.ValueType
	 * @generated
	 */
	public Adapter createValueTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.oil.xtext.model.EnumeratorType <em>Enumerator Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.EnumeratorType
	 * @generated
	 */
	public Adapter createEnumeratorTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.oil.xtext.model.VariantType <em>Variant Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.VariantType
	 * @generated
	 */
	public Adapter createVariantTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.oil.xtext.model.OilFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.OilFile
	 * @generated
	 */
	public Adapter createOilFileAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.oil.xtext.model.ReferenceType <em>Reference Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.ReferenceType
	 * @generated
	 */
	public Adapter createReferenceTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.oil.xtext.model.ParameterRef <em>Parameter Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.ParameterRef
	 * @generated
	 */
	public Adapter createParameterRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.oil.xtext.model.ValidValues <em>Valid Values</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.ValidValues
	 * @generated
	 */
	public Adapter createValidValuesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.oil.xtext.model.Range <em>Range</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.Range
	 * @generated
	 */
	public Adapter createRangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.oil.xtext.model.ValueList <em>Value List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.ValueList
	 * @generated
	 */
	public Adapter createValueListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //OilAdapterFactory
