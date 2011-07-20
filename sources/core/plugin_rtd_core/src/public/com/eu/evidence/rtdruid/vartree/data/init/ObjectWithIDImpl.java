/**
 * <copyright>
 * </copyright>
 *
 * %W%
 * @version %I% %H%
 */
package com.eu.evidence.rtdruid.vartree.data.init;


import java.util.Iterator;
import java.util.LinkedList;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.eu.evidence.rtdruid.vartree.IVariable;
import com.eu.evidence.rtdruid.vartree.data.DataFactory;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.data.ObjectWithID;
import com.eu.evidence.rtdruid.vartree.data.init.DataPath;
import com.eu.evidence.rtdruid.vartree.variables.PropertyVar;
import com.eu.evidence.rtdruid.vartree.variables.StringVar;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object With ID</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class ObjectWithIDImpl extends EObjectImpl implements ObjectWithID
{
	/**
	 * The default value of the '{@link #getProperties() <em>Properties</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected static final PropertyVar PROPERTIES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected PropertyVar properties = PROPERTIES_EDEFAULT;

	
	
public static int cont =0;
	protected void finalize() {
		cont --;
		if (eAdapters != null) {
			eAdapters.clear();
		}
		eContainer = null;
		eProperties = null;
		  
		//System.err.println("ObjectWithIDImpl eliminato (altre " + cont + ")");
	}
	
	/**
	 * This flag is used to identify if this object is unused and has no ID. 
	 * 
	 * Is used to solve a bug with EMF copy, that tries to insert many new_&&_empty
	 * objects before fill them with theirs ID.
	 */
	private boolean new_object = true;
	
	public boolean isNew_object() {
		return new_object;
	}
	
	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected ObjectWithIDImpl() {
		super();
		cont ++;
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected EClass eStaticClass() {
		return DataPackage.eINSTANCE.getObjectWithID();
	}

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyVar getProperties() {
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProperties(PropertyVar newProperties) {
		PropertyVar oldProperties = properties;
		properties = newProperties;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.OBJECT_WITH_ID__PROPERTIES, oldProperties, properties));
	}


  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  abstract public String getObjectID(); // { throw new UnsupportedOperationException(); }

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated NOT
	 */
  abstract public boolean setObjectID(String newID);
  /*public boolean setObjectID(String newID) {
	// subclass must implement this method
		throw new UnsupportedOperationException();
	}*/

	/**
	 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DataPackage.OBJECT_WITH_ID__PROPERTIES:
				return getProperties();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DataPackage.OBJECT_WITH_ID__PROPERTIES:
				setProperties((PropertyVar)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case DataPackage.OBJECT_WITH_ID__PROPERTIES:
				setProperties(PROPERTIES_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DataPackage.OBJECT_WITH_ID__PROPERTIES:
				return PROPERTIES_EDEFAULT == null ? properties != null : !PROPERTIES_EDEFAULT.equals(properties);
		}
		return super.eIsSet(featureID);
	}
  
	/**
	 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String toString() {
	//		if (eIsProxy()) return super.toString();
	
			StringBuffer result = new StringBuffer(super.toString());
			result.append(" (ID: ");
			result.append(getObjectID());
			result.append(')');
			return result.toString();
		}
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public boolean checkNewID(String newID)
  {
  	String oldID = getObjectID();
  	if (newID == null ? oldID == null : newID.equals(oldID)) 
  		return true;
  	
	if (eContainer != null && eContainmentFeature()!= null) {
			Object parentList = eContainer.eGet(eContainmentFeature());

			if (parentList != null && parentList instanceof EList) {
/*					if ( !(parentList instanceof EObjectContainmentUniqueEList)) {
							System.err.println("\nWARNING: la lista non e' una EObjectContainmentUniqueEList -> potrebbe non fare i check correttamente\n");
					}*/
					if (((EList) parentList).contains(newID)) {
							throw new IllegalIDException("Try to use an already used ID : " + newID);
							//return false;
					}
			}
	}
	return true;
  }
  
  public boolean equals(Object o) {
  	return super.equals(o);
  }

 /**
  * 
  * */
 public boolean equalsByID(Object o) {
 	//System.err.println("This = " + getClass().getName() + "  - o = " 
 	//		+ (o == null ? null : o.getClass().getName()) + "  (" + super.equals(o) + ")");
 	EReference eFeature = eContainmentFeature();
	if (eContainer != null && eContainmentFeature()!= null) {
		Object parentList = eContainer.eGet(eFeature);
		
		if (parentList != null 
				&& parentList instanceof EList) {
		
		 	String tmp = getObjectID();
		 	if (o == null) {
		 		return (tmp == null);
		 	}
		 	if (o instanceof ObjectWithID
		 			&& eFeature.getEType().isInstance(o)) {
		 		String oTmp = ((ObjectWithID) o).getObjectID();
		 		return (tmp == null ? oTmp == null : tmp.equals(oTmp));
		 	} else if (o instanceof String) {
				return (tmp == null ? o == null : tmp.equals(o));
		 	}
		}
	}
 	
 	return (this == o);
 }
 
 // -------------------------------------------------
 
 /**
  * 
  * */
 private String makeID(IVariable[] values) {
 	
 	String[] tmp = new String[values.length];
 	for (int i=0; i<values.length; i++) {
 		IVariable var = values[i];
 		tmp[i] = (var == null ? null : (var.get() == null ? null : var.toString() ));
 	}
 	
 	return DataPath.makeId(tmp);
 }

 /**
  * 
  * */
 protected String makeSlahedID(IVariable[] values) {
 	return makeID(values);//DataPath.addSlash(makeID(values));
 }

 /**
  * 
  * */
 protected String[] resolveID(String values) {
 	return DataPath.resolveId(values);
 }
 
 protected String makeID(IVariable var) {
 	return makeID(new IVariable[] {var });
 }
 
 protected void didSetObjectID(String oldID) {

	if (eContainer != null && eContainmentFeature() != null) {
		Object parentList = eContainer.eGet(eContainmentFeature());

	  	String newID = getObjectID();
	  	boolean sameID = newID == null ? oldID == null : newID.equals(oldID);

		if (!sameID && parentList != null && parentList instanceof EObjectContainmentUniqueEList) {
			EObjectContainmentUniqueEList list = (EObjectContainmentUniqueEList) parentList;
			
			list.updateID(this, oldID, newID);
		}
	}
	 new_object = false;
 }
 
 // -------------------------------------------------
 
 /** Makes a new Instance of this object */
 protected ObjectWithID newInstance() {
 	return (ObjectWithID) DataFactory.eINSTANCE.create(eClass());
 }
 
 /** Make a distinct copy of current node and all its attributes and references
  * */
 public ObjectWithID clone() {
 	ObjectWithID answer = newInstance();

 	// copy all attributes
 	EList<EAttribute> attrs = eClass().getEAllAttributes();
 	for (int i=0; i<attrs.size(); i++) {
 		EAttribute attr = (EAttribute) attrs.get(i);
 		if (attr.isDerived()) {
 			// do nothing if this attribute is derived
 			continue;
 		}
 		if (attr.isMany()) {
 			EList children = (EList) eGet(attr);
 			EList newChildren = (EList) answer.eGet(attr);
 			
 			for (int j=0; j<children.size(); j++) {
 		 		IVariable var = (IVariable) children.get(j);
 		 		if (var != null) {
 		 			newChildren.add(var.clone());
 		 		}
 			}
 			
 		} else {
	 		IVariable var = (IVariable) eGet(attr);
	 		if (var != null) {
	 			answer.eSet(attr, var.clone());
	 		}
 		}
 	}
 	
 	// copy all references
 	EList<EReference> refs = eClass().getEReferences();
 	for (int i=0; i<refs.size(); i++) {
 		EReference ref = (EReference) refs.get(i);
 		if (ref.isMany()) {
 			EList children = (EList) eGet(ref);
 			EList newChildren = (EList) answer.eGet(ref);
 			
 			for (int j=0; j<children.size(); j++) {
 				
 		 		ObjectWithID child = (ObjectWithID) children.get(j);
 		 		if (child != null) {
 		 			newChildren.add(child.clone());
 		 		}
 			}
 			
 		} else {
			
	 		ObjectWithID child = (ObjectWithID) eGet(ref);
	 		if (child != null) {
	 			answer.eSet(ref, child.clone());
	 		}
 		}
 	}
 	
 	
 	return answer;
 }

 /** Try to merge current node with another Object of the same type (and all its attributes and references).
  * The result is stored in current node.
  * 
  * @throws IllegalArgumentException if two object are not compatible (or one of theirs descendants)
  * */
 public void merge(ObjectWithID source, String path, boolean overwrite) {
 	if (source.getClass() != getClass()) {
 		throw new IllegalArgumentException("Try to merge two not compatible objects: one " + getClass() + " and one " + source.getClass() + "\n\tpath = " + path);
 	}
 	//if (this.eResource() == null) {
 	//	throw new RuntimeException("Expected a not null resource. Perhaps it's a Bug!!!");
 	//}

 	{
	 	String curID = getObjectID();
	 	String sourceID = source.getObjectID();
	 	if (curID == null ? sourceID != null : !curID.equals(sourceID)) {
	 		throw new IllegalArgumentException("Try to merge two objects with differents ID: " + curID + " and " + sourceID + "\n\tpath = " + path);
	 	}
	 	
	 	path = (path == null ? "" : path) + DataPath.SEPARATOR + curID;
 	}
 	
 	// copy all attributes
 	EList<EAttribute> attrs = eClass().getEAllAttributes();
 	for (int i=0; i<attrs.size(); i++) {
 		EAttribute attr = (EAttribute) attrs.get(i);
 		if (attr.isDerived()) {
 			// do nothing
 		} else if (attr.isMany()) {
 			EList children = (EList) eGet(attr);
 			EList newChildren = (EList) source.eGet(attr);
 			
 			LinkedList tmpChildren = new LinkedList(children);
 			for (int j=0; j<newChildren.size(); j++) {
 				
 		 		IVariable var = (IVariable) newChildren.get(j);
 		 		if (var != null) {
 		 			if (!searchVar(tmpChildren, var)) {
 		 				children.add(var.clone());
 		 			}
 		 		}
 			}
 			
 		} else {
	 		IVariable var = (IVariable) eGet(attr);
	 		IVariable newVar = (IVariable) source.eGet(attr);
	 		if (var != null && newVar != null) {
	 			Object v1 = var.get();
	 			Object v2 = newVar.get();
	 			
	 			boolean eq = (v1 == null? v2 == null : 
	 				//v1.toString().equals(v2.toString())); // not work with TimeVar (var=1ms, newVar=1us)
	 				var.toString().equals(newVar.toString()));
	 			//if (var.getClass() != newVar.getClass() || !eq) { // if current and source are the same type, also two vars are the same type
	 			if (!eq) {
	 				if (overwrite) {
	 					eSet(attr, newVar);
	 				} else {
	 					
	 					// check if it was the  default value
	 					source.eUnset(attr);
	 					IVariable defaultValue = (IVariable) eGet(attr);
	 					Object def = defaultValue.get();
	 					boolean eq2 = (v1 == null? def == null : 
	 		 				//v1.toString().equals(v2.toString())); // not work with TimeVar (var=1ms, newVar=1us)
	 						var.toString().equals(defaultValue.toString()));
	 					
	 					if (eq2) {
		 					eSet(attr, newVar);
	 					} else {
		 					throw new IllegalArgumentException("Try to change the vaule of an already set attribute (mono value). " + "path = "
			 					 + path + DataPath.SEPARATOR + attr.getName());
	 					}
	 				}
	 			}

	 		} else {
	 			if (newVar != null) {
	 				eSet(attr, newVar.clone());
	 			}
	 		}
	 		
 		}
 	}
 	
 	// copy all references
 	EList<EReference> refs = eClass().getEReferences();
 	for (int i=0; i<refs.size(); i++) {
 		EReference ref = (EReference) refs.get(i);
 		if (ref.isMany()) {
 			EList children = (EList) eGet(ref);
 			EList newChildren = (EList) source.eGet(ref);
 			
 			for (int j=0; j<newChildren.size(); j++) {
 				
 		 		ObjectWithID newChild = (ObjectWithID) newChildren.get(j);
 		 		if (newChild != null) {
 		 			int pos = children.indexOf(newChild);
 		 			if (pos < 0) {
 		 				ObjectWithID child = (ObjectWithID) DataFactory.eINSTANCE.create(newChild.eClass());
 		 				child.setObjectID(newChild.getObjectID());

 		 				children.add(child);

 		 				// check the new child
 		 				child.merge(newChild, path, overwrite);

 		 			} else {
 		 				// check the old child
 		 				((ObjectWithID) children.get(pos)).merge(newChild, path, overwrite);
 		 			}
 		 		}
 			}
 			
 		} else {
			
	 		ObjectWithID child = (ObjectWithID) eGet(ref);
	 		ObjectWithID newChild = (ObjectWithID) source.eGet(ref);
	 		if (newChild != null) {
	 			if (child == null) {
	 				child = (ObjectWithID) DataFactory.eINSTANCE.create(newChild.eClass());
	 				child.setObjectID(newChild.getObjectID());

	 				eSet(ref, child);
	 				child.merge(newChild, path, overwrite);
	 			} else {
	 				child.merge(newChild, path, overwrite);
	 			}
	 		}
 		}
 	}
 }
 
 private boolean searchVar(LinkedList<IVariable> vars, IVariable value) {
 	boolean risp = false;
 	
 	Iterator<IVariable> iter = vars.iterator();
 	while (!risp && iter.hasNext()) {
 		IVariable v = (IVariable) iter.next();
 		if (v == null && value == null) {
			iter.remove(); 		
 			risp = true;
 			
 		} else if (value != null && v != null) {
 			Object v1 = v.get();
 			Object v2 = value.get();
 			boolean eq = (v1 == null? v2 == null : v1.toString().equals(v2.toString()));
 			if (eq) {
				iter.remove(); 		
	 			risp = true;
	 		}
 		}
 	}
 	
 	return risp;
 }
 
 protected StringVar varToUpperCase(StringVar value) {
 	StringVar answer = null;
 	if (value != null && value.get() != null) {
 		answer = new StringVar(value.toString().toUpperCase());
 	}
 	return answer;
 }

 /** This exception is throwed if someone try to set an already used id */
 public class IllegalIDException extends RuntimeException {
 	
 	/**
	 * 
	 */
	private static final long serialVersionUID = -7398854963194066874L;
	
	public IllegalIDException() {}
 	public IllegalIDException(String message) { super(message); }
 }
 
} //ObjectWithIDImpl
