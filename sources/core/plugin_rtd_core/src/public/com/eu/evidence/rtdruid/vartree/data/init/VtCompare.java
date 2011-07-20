/*
 * Created on 14-giu-2004
 */
package com.eu.evidence.rtdruid.vartree.data.init;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;

import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVariable;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.data.ObjectWithID;

/**
 * @author ni
 * 
 * This class is usefull to create a new filled tree and to compare two distinct
 * trees
 */
public class VtCompare {
	
	private class CheckFailed extends Exception {
		private static final long serialVersionUID = 3011742488422006027L;
		
		String txt = null;
		public CheckFailed() {
		}

		public CheckFailed(String txt) {
			this.txt = txt;
		}
		public void set(String txt) {
			this.txt = txt;
		}
	}
	
	
	protected final EObject first;
	protected final EObject second;
	
	protected boolean checked = false;
	
	protected String result = null;
//	protected EObject firstObj = null;
//	protected EObject secondObj = null;
	
	
	public VtCompare(IVarTree first, IVarTree second) {
		this.first = (EObject) ((Resource) first.getResourceSet().getResources().get(0)).getContents().get(0);
		this.second = (EObject) ((Resource) second.getResourceSet().getResources().get(0)).getContents().get(0);
	}
	
	public VtCompare(EObject first, EObject second) {
		this.first = first;
		this.second = second;
	}

	/**
	 * This function recusrively compare all nodes of two trees
	 */
	public boolean checkTrees() {
		
		if (!checked) {
			try {
				checkTrees(first, second);
			} catch (CheckFailed e) {
				result = e.txt;
			}
		}
		return result == null;
	}
	
	public String getText() {
		
		if (!checked) {
			try {
				checkTrees(first, second);
			} catch (CheckFailed e) {
				result = e.txt;
			}
		}
		return result;
	}
	
	/**
	 * This function recusrively compare all nodes of two trees
	 */
	private void checkTrees(EObject first, EObject second) throws CheckFailed {
		try {
		
			//System.err.println("-- " + first + " #### " + second);
		
			//assertTrue(first.getClass().getName().equals(second.getClass().getName()));
			assertTrue(first.getClass() == second.getClass());
			EList<EAttribute> attrList1 = first.eClass().getEAllAttributes();
			//EList attrList2 = second.eClass().getEAllAttributes();
			//assertTrue (attrList1.size() == attrList2.size());
			for (int i = 0; i < attrList1.size(); i++) {
				EAttribute at1 = (EAttribute) attrList1.get(i);
				//EAttribute at2 = (EAttribute) attrList2.get(i);
		
				//assertTrue(at1.isMany() == at2.isMany());
		
				if (at1.isMany()) {
					EList<?> el1 = (EList<?>) first.eGet(at1);
					EList<?> el2 = (EList<?>) second.eGet(at1);
					//EList el2 = (EList) first.eGet(at2);
		
					assertTrue(el1.size() == el2.size());
					for (int j = 0; j < el1.size(); j++) {
						Object o1 = el1.get(j);
						Object o2 = el2.get(j);
						if (o1 == null) {
							assertTrue(o2 == null);
						} else {
							assertTrue(o2 != null);
		
							assertTrue(o1.getClass() == o2.getClass());
							//assertTrue(o1.getClass().getName().equals(o2.getClass().getName()));
		
							if (((IVariable) o1).get() == null) {
								assertTrue(((IVariable) o2).get() == null);
							} else {
								assertTrue(((IVariable) o1).toString().equals(
										((IVariable) o2).toString()));
							}
		
						}
					}
		
				} else {
					Object o1 = first.eGet(at1);
					Object o2 = second.eGet(at1);
					//Object o2 = second.eGet(at2);
					if (o1 == null) {
						assertTrue(o2 == null);
					} else {
						assertTrue(o2 != null);
						assertTrue(o1.getClass() == o2.getClass());
		
						if (!(o1 instanceof IVariable)) {
							System.err.println(o1 + " - " + o1.getClass() + " - "
									+ at1);
						}
						if (((IVariable) o1).get() == null) {
							assertTrue(((IVariable) o2).get() == null);
						} else {
							int at1_id = at1.getEAttributeType().getClassifierID();
							if (!(at1_id == DataPackage.FAST_TASK_TO_PROC_MAP_VAR )) {

								if (! ((IVariable) o1).toString().equals(
										((IVariable) o2).toString()) ) {
									System.err.println(first.getClass().getName() + " " + at1.getName());
								}
								
								assertTrue(((IVariable) o1).toString().equals(
										((IVariable) o2).toString()));
							}
						}
		
					}
				}
			}
		
			EList<EReference> children1 = first.eClass().getEAllReferences();
			EList<EReference> children2 = second.eClass().getEAllReferences();
			assertTrue(children1.size() == children2.size());
			for (int i = 0; i < children1.size(); i++) {
		
				EReference ref1 = (EReference) children1.get(i);
				EReference ref2 = (EReference) children2.get(i);
		
				assertTrue(ref1.isMany() == ref2.isMany());
		
				if (ref1.isMany()) {
					EList<?> el1 = (EList<?>) first.eGet(ref1);
					EList<?> el2 = (EList<?>) second.eGet(ref2);
		
					if (el1.size() != el2.size()) {
						System.err.println("First node children:");
						for (int l = 0; l < el1.size(); l++) {
							System.err.println("\t" + el1.get(l));
						}
		
						System.err.println("Second node children:");
						for (int l = 0; l < el2.size(); l++) {
							System.err.println("\t" + el2.get(l));
						}
		
						assertTrue(false);
					}
		
					ArrayList<?> sort1 = sorted(el1);
					ArrayList<?> sort2 = sorted(el2);
		
					assertTrue(el1.size() == sort1.size());
					assertTrue(el2.size() == sort2.size());
		
					for (int j = 0; j < sort1.size(); j++) {
						checkTrees((EObject) sort1.get(j), (EObject) sort2.get(j));
					}
		
				} else {
					Object o1 = first.eGet(ref1);
					Object o2 = second.eGet(ref2);
					if (o1 == null) {
						assertTrue(""+o1 + "("+ref1+") - "+ o2 + "("+ref2+")", o2 == null);
					} else {
						assertTrue(o2 != null);
		
						checkTrees((EObject) o1, (EObject) o2);
					}
				}
			}
		} catch (CheckFailed e) {
			e.set(" o1 = " + first + "\n o2 = " + second);
			throw e;
			
		}
	}

	private void assertTrue(boolean check) throws CheckFailed {
		if (!check) {
			throw new CheckFailed();
		}
	}

	private void assertTrue(String txt, boolean check) throws CheckFailed {
		if (!check) {
			throw new CheckFailed(txt);
		}
	}

	/** This function try to sort all data */
	private static ArrayList<?> sorted(EList data) {
		ArrayList<ObjectWithID> answer = new ArrayList<ObjectWithID>();

		answer.addAll(data);

		Collections.sort(answer, new Comparator<ObjectWithID>() {
			public int compare(ObjectWithID o1, ObjectWithID o2) {
				return ((ObjectWithID) o1).getObjectID().compareTo(
						((ObjectWithID) o2).getObjectID());
			}
		});

		return answer;
	}
}