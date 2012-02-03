/**
 * 12/dic/2011
 */
package com.eu.evidence.rtdruid.internal.epackage;

import java.util.LinkedHashMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.eu.evidence.rtdruid.epackage.IEPackageMerge;
import com.eu.evidence.rtdruid.epackage.RTDEPackageBuildException;

/**
 * This class merges EPackages
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 * @deprecated not fully working
 */
public class EPackageEmfMerge implements IEPackageMerge {
	
	protected EpkgMerger merger;
	
	protected enum State {
		empty, merging, closed;
	}
	
	protected State currentState;
	
	public EPackageEmfMerge() {
		currentState = State.empty;
	}
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.epackage.IEPackageMerge#addEPackage(org.eclipse.emf.ecore.EPackage)
	 */
	@Override
	public void addEPackage(EPackage pkg) throws RTDEPackageBuildException {
		if (pkg == null) {
			throw new NullPointerException();
		}
		
		switch (currentState) {
			case closed : 
				throw new IllegalStateException("Cannot add a new EPackage after get the result");
			case empty : {
				merger = new EpkgMerger(EcoreUtil.copy(pkg));
				currentState = State.merging;
				break;
			} 
			case merging : {
				merger.merge(pkg);
				break;
			}
		} 
	}
	
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.epackage.IEPackageMerge#getResult()
	 */
	@Override
	public EPackage getResult() {
		currentState = State.closed;
		return merger == null ? null : merger.getResult();
	}
	


	// ------------------------------------------------------
	//    Emf ID Manager
	// ------------------------------------------------------
	/**
	 * This class computes a String ID for an Emf element 
	 *
	 * @author Nicola Serreli
	 * @since 2.0
	 *
	 */
	protected static class EIdManager {
		
		public final static EIdManager mngr = new EIdManager();
		
		private EIdManager() {}
		
		public Class<?> getCategory(EObject o) {
			if (o instanceof EClass) {
				return EClass.class;
			} else if (o instanceof EStructuralFeature) {
				return EStructuralFeature.class;
			} else if (o instanceof EDataType) {
				return EDataType.class;
			} else {
				return o.getClass();
			}
			
		}
		
		public String getId(EObject o) {
			if (o instanceof ENamedElement) {
				return ((ENamedElement) o).getName();
			} else if (o instanceof EStructuralFeature) {
				return ((EStructuralFeature) o).getName();
			} else if (o instanceof EGenericType) {
				EGenericType type = (EGenericType) o;
				EClassifier cl = type.getEClassifier();
				if (cl != null) {
					return cl.getName();
				}
				return null;
			} else {
				throw new UnsupportedOperationException("unsupported " + o.getClass() + " (" + o +")");
			}
		}
	}

		
	// ------------------------------------------------------
	//    Emf Package Merger
	// ------------------------------------------------------
	/**
	 * This class merges one or more packages 
	 *
	 * @author Nicola Serreli
	 * @since 2.0
	 *
	 */
	protected static class EpkgMerger {
		protected final LinkedHashMap<Class<?>, LinkedHashMap<String, EObject>> fast = new LinkedHashMap<Class<?>, LinkedHashMap<String,EObject>>();
		protected final EPackage result;
		
		protected final EIdManager idmgr = EIdManager.mngr;
		
		/**
		 * 
		 */
		public EpkgMerger(EPackage dest) {
			result = dest;

			for (EObject o: result.eContents()) {
				addFast(o);
			}
		}
		
		public void merge(EPackage addition) throws RTDEPackageBuildException {
			
			if (result.getName() == null) {
				result.setName(addition.getName());
			}
			if (result.getNsPrefix() == null) {
				result.setNsPrefix(addition.getNsPrefix());
			}
			if (result.getNsURI() == null) {
				result.setNsURI(addition.getNsURI());
			}
		
			for (EObject add: addition.eContents()) {
				EObject old = getFast(add);
				if (old == null) {
					if (add instanceof EClass) {
						result.getEClassifiers().add((EClass) EcoreUtil.copy(add));
					} else if (add instanceof EDataType) {
						result.getEClassifiers().add((EDataType) EcoreUtil.copy(add));
					} else { throw new UnsupportedOperationException(); }
					addFast(add);
				} else {
					// check if it is possible to solve conflicts
					if (add instanceof EClass) {
						EclassMerger cm = new EclassMerger((EClass) old);
						cm.merge((EClass) add);
					} else if (add instanceof EDataType) {
						EDataTypeMerger cm = new EDataTypeMerger((EDataType) old);
						cm.merge((EDataType) add);
					} else { throw new UnsupportedOperationException(); }
				}
			}
		}

		
		/**
		 * @return the result
		 */
		public EPackage getResult() {
			return result;
		}

		protected void addFast(EObject o) {
			Class<?> c = idmgr.getCategory(o);
			LinkedHashMap<String, EObject> list;
			if (fast.containsKey(c)) {
				list = fast.get(c);
			} else {
				list = new LinkedHashMap<String, EObject>(); 
				fast.put(c, list);
			}
			
			list.put(idmgr.getId(o), o);
		}
		
		protected EObject getFast(EObject o) {
			Class<?> c = idmgr.getCategory(o);
			LinkedHashMap<String, EObject> list;
			if (fast.containsKey(c)) {
				list = fast.get(c);
			} else {
				return null;
			}
			String id = idmgr.getId(o);
			return list.containsKey(id) ? list.get(id): null;			
		}
		
		
	}
	
	// ------------------------------------------------------
	//    Emf Class Merger
	// ------------------------------------------------------
	/**
	 * This class merges one or more EClass object 
	 *
	 * @author Nicola Serreli
	 * @since 2.0
	 *
	 */
	protected static class EclassMerger {
		protected final LinkedHashMap<Class<?>, LinkedHashMap<String, EObject>> fast = new LinkedHashMap<Class<?>, LinkedHashMap<String,EObject>>();
		protected final EClass result;

		protected final EIdManager idmgr = EIdManager.mngr;
		/**
		 * 
		 */
		public EclassMerger(EClass dest) {
			if (dest == null) {
				throw new NullPointerException("Required a not null EClass");
			}
			result = dest;

			for (EObject o: result.eContents()) {
				addFast(o);
			}
		}
		
		public void merge(EClass addition) throws RTDEPackageBuildException {
		
			for (EObject add: addition.eContents()) {
				EObject old = getFast(add);
				if (old == null) {
					if (add instanceof EStructuralFeature) {
						result.getEStructuralFeatures().add((EStructuralFeature) EcoreUtil.copy(add));
					} else { throw new UnsupportedOperationException(); }


					addFast(add);
				} else {
					// check if it is possible to solve conflicts
					if (add instanceof EStructuralFeature) {
						EStrFeatureMerger cm = new EStrFeatureMerger((EStructuralFeature) old);
						cm.merge((EStructuralFeature) add);
					} else if (add instanceof EGenericType) {
						EGenericTypeMerger cm = new EGenericTypeMerger((EGenericType) old);
						cm.merge((EGenericType) add);
					} else { 
						throw new UnsupportedOperationException(add.toString());
					}

				}
			}
		}

		
		/**
		 * @return the result
		 */
		public EClass getResult() {
			return result;
		}

		protected void addFast(EObject o) {
			if (o == null) {
				return;
			}
			
			Class<?> c = idmgr.getCategory(o);
			LinkedHashMap<String, EObject> list;
			if (fast.containsKey(c)) {
				list = fast.get(c);
			} else {
				list = new LinkedHashMap<String, EObject>(); 
				fast.put(c, list);
			}
			
			list.put(idmgr.getId(o), o);
		}
		
		protected EObject getFast(EObject o) {
			if (o == null) {
				return null;
			}
			
			Class<?> c = idmgr.getCategory(o);
			LinkedHashMap<String, EObject> list;
			if (fast.containsKey(c)) {
				list = fast.get(c);
			} else {
				return null;
			}
			String id = idmgr.getId(o);
			return list.containsKey(id) ? list.get(id): null;			
		}
		
		
	}
	
	// ------------------------------------------------------
	//    Emf Structural Feature Merger
	// ------------------------------------------------------
	/**
	 * This class merges EStructuralFeacture. In this case, merge, means check
	 * if two (or more) EStructuralFeactures are equals
	 * 
	 * @author Nicola Serreli
	 * @since 2.0
	 * 
	 */
	protected static class EStrFeatureMerger {
		protected final EStructuralFeature result;
		
		/**
		 * 
		 */
		public EStrFeatureMerger(EStructuralFeature dest) {
			if (dest == null) {
				throw new NullPointerException("Required a not null EStructuralFeature");
			}
			result = dest;
		}
		
		public void merge(EStructuralFeature addition) throws RTDEPackageBuildException {
			
			EStructuralFeature c1 = EcoreUtil.copy(result);
			EStructuralFeature c2 = EcoreUtil.copy(addition);
			
			if (c1 instanceof EReference) {
				// we need to "clear" the connection of reference types to their package, otherwise the compare may fail 
				c1.setEType( EcoreUtil.copy(c1.getEType()));
				c2.setEType( EcoreUtil.copy(c1.getEType()));
			}
			if (!EcoreUtil.equals(c1, c2)) {
				throw new RTDEPackageBuildException("StructuralFeature collision: " + result + " - " + addition);
			}
		}
		/**
		 * @return the result
		 */
		public EStructuralFeature getResult() {
			return result;
		}
	}

	// ------------------------------------------------------
	//    Emf Data Type Merger
	// ------------------------------------------------------
	/**
	 * This class merges EDataType. In this case, merge, means check
	 * if two (or more) EDataType are equals
	 * 
	 * @author Nicola Serreli
	 * @since 2.0
	 * 
	 */
	protected static class EDataTypeMerger {
		protected final EDataType result;
		
		/**
		 * 
		 */
		public EDataTypeMerger(EDataType dest) {
			if (dest == null) {
				throw new NullPointerException("Required a not null EDataType");
			}
			result = dest;
		}
		
		public void merge(EDataType addition) throws RTDEPackageBuildException {
			
			if (!EcoreUtil.equals(EcoreUtil.copy(result), EcoreUtil.copy(addition))) {
				throw new RTDEPackageBuildException("EDataType collision: " + result + " - " + addition);
			}
		}
		/**
		 * @return the result
		 */
		public EDataType getResult() {
			return result;
		}
	}


	// ------------------------------------------------------
	//    Emf Generic Type Merger
	// ------------------------------------------------------
	/**
	 * This class merges EGenericType. In this case, merge, means check
	 * if two (or more) EGenericType are equals
	 * 
	 * @author Nicola Serreli
	 * @since 2.0
	 * 
	 */
	protected static class EGenericTypeMerger {
		protected final EGenericType result;
		
		/**
		 * 
		 */
		public EGenericTypeMerger(EGenericType dest) {
			if (dest == null) {
				throw new NullPointerException("Required a not null EGenericType");
			}
			result = dest;
		}
		
		public void merge(EGenericType addition) throws RTDEPackageBuildException {
			
			EGenericType c1 = EcoreUtil.copy(result);
			EGenericType c2 = EcoreUtil.copy(addition);
			// we need to "clear" the connection between types and their package, otherwise the compare may fail 
			c1.setEClassifier( EcoreUtil.copy(c1.getEClassifier()));
			c2.setEClassifier( EcoreUtil.copy(c1.getEClassifier()));
			
			if (!EcoreUtil.equals(c1, c2)) {
				throw new RTDEPackageBuildException("EGenericType collision: " + result + " - " + addition);
			}
		}
		/**
		 * @return the result
		 */
		public EGenericType getResult() {
			return result;
		}
	}

}
