/*
 * Created on 14-giu-2004
 */
package com.eu.evidence.rtdruid.vartree;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.eu.evidence.rtdruid.Rtd_corePlugin;

/**
 * @author Nicola Serreli
 * 
 * This class is usefull to create a new filled tree and to compare two distinct
 * trees
 */
class VtCompare {
	
	
	static class CheckFailed extends Exception {
		private static final long serialVersionUID = 3011742488422006027L;
		
		public CheckFailed(String txt) {
			super(txt);
		}
	}
	
	static class VtCompareStatus implements IStatus {
		
		protected final int status;
		protected final Exception exception;

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.core.runtime.IStatus#getChildren()
		 */
		@Override
		public IStatus[] getChildren() {
			return new IStatus[0];
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.core.runtime.IStatus#getCode()
		 */
		@Override
		public int getCode() {
			return OK;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.core.runtime.IStatus#getException()
		 */
		@Override
		public Throwable getException() {
			return exception;
		}
		
		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.core.runtime.IStatus#getMessage()
		 */
		@Override
		public String getMessage() {
			return exception != null ? exception.getMessage() : null;
		}
		
		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.core.runtime.IStatus#getPlugin()
		 */
		@Override
		public String getPlugin() {
			return Rtd_corePlugin.PLUGIN_ID;
		}
		
		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.core.runtime.IStatus#getSeverity()
		 */
		@Override
		public int getSeverity() {
			return status;
		}
		
		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.core.runtime.IStatus#isMultiStatus()
		 */
		@Override
		public boolean isMultiStatus() {
			return false;
		}
		
		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.core.runtime.IStatus#isOK()
		 */
		@Override
		public boolean isOK() {
			return status == OK;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.core.runtime.IStatus#matches(int)
		 */
		@Override
		public boolean matches(int severityMask) {
			return (status & severityMask) != 0;
		}

		/**
		 * 
		 */
		public VtCompareStatus(int status, Exception e) {
			this.status = status;
			exception = e;
		}

	}
	
	

	
	
	protected final EObject first;
	protected final EObject second;
	
	protected boolean checked = false;
	
	protected IStatus result = null;
//	protected EObject firstObj = null;
//	protected EObject secondObj = null;
	
	
	public VtCompare(IVarTree first, IVarTree second) {
		this.first = VarTreeUtil.getTreeRoot(first);
		this.second = VarTreeUtil.getTreeRoot(second);
	}

	public VtCompare(EObject first, EObject second) {
		this.first = first;
		this.second = second;
	}

	/**
	 * This function recusrively compare all nodes of two trees
	 */
	public IStatus checkTrees() {
		
		if (!checked) {
			result = new VtCompareStatus(IStatus.OK, null);
			try {
				checkTrees(first, second);
			} catch (CheckFailed e) {
				result = new VtCompareStatus(IStatus.ERROR, e);
			}
		}
		return result;
	}
	
	/**
	 * This function recusrively compare all nodes of two trees
	 */
	private void checkTrees(EObject first, EObject second) throws CheckFailed {
	
		//REMOVE.err.println("-- " + first + " #### " + second);
	
		//assertTrue(first.getClass().getName().equals(second.getClass().getName()));
		assertTrue(first.getClass() == second.getClass(), first, second);
		EList<EAttribute> attrList1 = first.eClass().getEAllAttributes();
		//EList attrList2 = second.eClass().getEAllAttributes();
		//assertTrue (attrList1.size() == attrList2.size());
		for (int i = 0; i < attrList1.size(); i++) {
			EAttribute at1 = (EAttribute) attrList1.get(i);
			EAttribute at2;
			{
				EStructuralFeature sf = second.eClass().getEStructuralFeature(at1.getName());
				assertTrue("Second node does not contain the attribute " + at1.getName(), sf != null && sf instanceof EAttribute, first, second);
				at2 = (EAttribute) sf;
			}
	
			if (at1.isMany()) {
				EList<?> el1 = (EList<?>) first.eGet(at1);
				EList<?> el2 = (EList<?>) second.eGet(at2);
	
				assertTrue(el1.size() == el2.size(), first, second);
				for (int j = 0; j < el1.size(); j++) {
					Object o1 = el1.get(j);
					Object o2 = el2.get(j);
					if (o1 == null) {
						assertTrue(o2 == null, first, second);
					} else {
						assertTrue(o2 != null, first, second);
	
						assertTrue(o1.getClass() == o2.getClass(), first, second);
	
						if (o1 instanceof IVariable) {
							
							if (((IVariable) o1).get() == null) {
								assertTrue(((IVariable) o2).get() == null, first, second);
							} else {
								assertTrue(((IVariable) o1).toString().equals(
										((IVariable) o2).toString()), first, second);
							}
						} else {
							assertTrue(o1.equals(o2), first, second);
						}
	
					}
				}
	
			} else {
				Object o1 = first.eGet(at1);
				Object o2 = second.eGet(at2);
				if (o1 == null) {
					assertTrue(o2 == null, first, second);
				} else {
					assertTrue(o2 != null, first, second);
					assertTrue(o1.getClass() == o2.getClass(), first, second);
	
					if (o1 instanceof IVariable) {
						if (((IVariable) o1).get() == null) {
							assertTrue(((IVariable) o2).get() == null, first, second);
						} else {
	//							int at1_id = at1.getEAttributeType().getClassifierID();
	//						if (!(at1_id == DataPackage.FAST_TASK_TO_PROC_MAP_VAR )) {
	
								assertTrue("fail at " + at1.getName(), ((IVariable) o1).toString().equals(
										((IVariable) o2).toString()), first, second);
	//						}
						}
					} else {
						assertTrue(o1.equals(o2), first, second);
					}
				}
			}
		}
	
		EList<EReference> children1 = first.eClass().getEAllReferences();
		EList<EReference> children2 = second.eClass().getEAllReferences();
		assertTrue(children1.size() == children2.size(), first, second);
		for (int i = 0; i < children1.size(); i++) {
	
			EReference ref1 = (EReference) children1.get(i);
			EReference ref2 = (EReference) children2.get(i);
	
			assertTrue(ref1.isMany() == ref2.isMany(), first, second);
	
			if (ref1.isMany()) {
				@SuppressWarnings("unchecked")
				EList<EObject> el1 = (EList<EObject>) first.eGet(ref1);
				@SuppressWarnings("unchecked")
				EList<EObject> el2 = (EList<EObject>) second.eGet(ref2);
	
				if (el1.size() != el2.size()) {
					StringBuffer buff = new StringBuffer();
					buff.append("First node children:\n");
					for (int l = 0; l < el1.size(); l++) {
						buff.append("\t" + el1.get(l) + "\n");
					}
	
					buff.append("Second node children:\n");
					for (int l = 0; l < el2.size(); l++) {
						buff.append("\t" + el2.get(l) + "\n");
					}
	
					assertTrue(buff.toString(), false, first, second);
				}
	
				ArrayList<EObject> sort1 = sorted(el1);
				ArrayList<EObject> sort2 = sorted(el2);
	
				assertTrue(el1.size() == sort1.size(), first, second);
				assertTrue(el2.size() == sort2.size(), first, second);
	
				for (int j = 0; j < sort1.size(); j++) {
					checkTrees((EObject) sort1.get(j), (EObject) sort2.get(j));
				}
	
			} else {
				Object o1 = first.eGet(ref1);
				Object o2 = second.eGet(ref2);
				if (o1 == null) {
					assertTrue(""+o1 + "("+ref1+") - "+ o2 + "("+ref2+")", o2 == null, first, second);
				} else {
					assertTrue(o2 != null, first, second);
	
					checkTrees((EObject) o1, (EObject) o2);
				}
			}
		}
	}

	private void assertTrue(boolean check, EObject first, EObject second) throws CheckFailed {
		if (!check) {
			throw new CheckFailed("Check " + first + " - " + second + " fail");
		}
	}

	private void assertTrue(String txt, boolean check, EObject first, EObject second) throws CheckFailed {
		if (!check) {
			throw new CheckFailed("Check " + first + " - " + second + " fail: " + txt);
		}
	}

	/** This function try to sort all data */
	private static ArrayList<EObject> sorted(EList<EObject> data) {
		ArrayList<EObject> answer = new ArrayList<EObject>();

		answer.addAll(data);

		Collections.sort(answer, new Comparator<EObject>() {
			
			protected String getId(EObject o) {
				return VarTreeIdHandler.getId(o);
			}
			
			
			
			public int compare(EObject o1, EObject o2) {
				String id1 = getId(o1);
				String id2 = getId(o2);
				return id1 == null ?
						(id2 == null ? 0 : Integer.MIN_VALUE ) :
						(id2 == null ? Integer.MAX_VALUE : id1.compareTo(id2));
			}
		});

		return answer;
	}

}