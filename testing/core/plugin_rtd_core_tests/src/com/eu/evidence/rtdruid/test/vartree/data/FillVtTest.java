package com.eu.evidence.rtdruid.test.vartree.data;
/*
 * Created on 14-giu-2004
 */



import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Properties;

import junit.framework.AssertionFailedError;
import junit.framework.TestCase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.CommandParameter;

import com.eu.evidence.rtdruid.desk.Messages;
import com.eu.evidence.rtdruid.desk.RTDFactory;
import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVariable;
import com.eu.evidence.rtdruid.vartree.data.DataFactory;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.data.ObjectWithID;
import com.eu.evidence.rtdruid.vartree.data.init.Vt2StringUtilities;

/**
 * @author ni
 * 
 * This class is usefull to create a new filled tree and to compare two distinct
 * trees
 */
public class FillVtTest extends TestCase {
	private static int nextID = 1;

	private static final int MAX_LEVEL = 4;

	IVarTree vt;

	public FillVtTest() {

		// Create the editing domain with a special command stack.
		//
		vt = ((IVarTree) RTDFactory.get(IVarTree.class));
	}

	
	/**
	 * Creates a new tree filled with numbers (a serial id for each node and
	 * attribute)
	 */
	public IVarTree newFilledVT() {
		IVarTree tree = ((IVarTree) RTDFactory.get(IVarTree.class));
		
		EList<EObject> base = tree.getResourceSet().getResources().get(0).getContents();
		base.clear();
		EObject root = DataFactory.eINSTANCE.createSystem();
		base.add(root);
		
		fill(root, 0);

		return tree;
	}
	
	/**
	 * Creates a new tree filled with numbers (a serial id for each node and
	 * attribute)
	 */
	public EObject fill() {
		EObject root = DataFactory.eINSTANCE.createSystem();

		fill(root, 0);

		return root;
	}

	/**
	 * Recursively adds all attribute and new children to current node. Stops
	 * (doesn't add new children) if level is bigger than MAX_LEVEL
	 */
	private void fill(EObject current, int level) {
		//String spazi = (" ").substring(0, level+1);
		//System.out.println(spazi + "type = " + current.eClass().getName());

		EList<EAttribute> attrList = current.eClass().getEAllAttributes();
		for (int i = 0; i < attrList.size(); i++) {
			EAttribute at = (EAttribute) attrList.get(i);

			
			if (at.getName().equals(DataPackage.eINSTANCE.getObjectWithID_Properties().getName())) {
				
				Properties p = new Properties();
				p.setProperty("a", ""+nextID); nextID++;
				p.setProperty("b", ""+nextID); nextID++;
				p.setProperty("c", ""+nextID); nextID++;
				
				ByteArrayOutputStream os = new ByteArrayOutputStream();
				try {
					p.storeToXML(os, null);
				} catch (IOException e) {
					RtdruidLog.log(e);
					continue;
				}
				
				Object tmp = DataFactory.eINSTANCE.createFromString(at
						.getEAttributeType(), os.toString());
				current.eSet(at, tmp);
				
//			} else if (at.getName().equals(DataPackage.eINSTANCE.getMapping_InverseTaskToProc().getName())) {
				
				// do nothing
			} else if (at.isMany()) {
				ArrayList<Object> val = new ArrayList<Object>();

				for (int l = 0; l < 3; l++) {
					//	System.out.println(spazi + "attr = " + at.getName() + "
					// val = " + nextID);
					val.add(DataFactory.eINSTANCE.createFromString(at
							.getEAttributeType(), "" + nextID));
					nextID++;
				}
				current.eSet(at, val);

			} else {
				//	System.out.println(spazi + "attr = " + at.getName() + " val =
				// " + nextID);
				Object tmp = DataFactory.eINSTANCE.createFromString(at
						.getEAttributeType(), "" + nextID);
				nextID++;
				current.eSet(at, tmp);
			}
		}

		if (level > MAX_LEVEL)
			return;
		level++;

		Collection<?> children = vt.getNewChildDescriptors(current,
				null);

		Iterator<?> it = children.iterator();
		while (it.hasNext()) {
			Object o = it.next();

			if (o instanceof CommandParameter) {
				CommandParameter cp = (CommandParameter) o;

				if (!cp.getEStructuralFeature().isMany()) {
					// add new node
					EObject newValue = cp.getEValue();

					current.eSet(cp.getEStructuralFeature(), newValue);
					fill(newValue, level);
				} else {
					EList<EObject> newChildren = (EList<EObject>) current.eGet(cp
							.getEStructuralFeature());

					for (int i = 0; i < 3; i++) {
						// add new node
						EObject newValue = DataFactory.eINSTANCE.create(cp
								.getEValue().eClass());

						newChildren.add(newValue);
						fill(newValue, level);
					}

				}
			} else {
				Messages
						.sendDebugNl("Expected a commandParameter !!! why not found ?? "
								+ o);
				assertTrue(false);
			}

		}

	}

	/**
	 * This function recusrively compare all nodes of two trees
	 */
	public static void checkTrees(IVarTree first, IVarTree second) {
		checkTrees(
				(EObject) ((Resource) first.getResourceSet().getResources().get(0)).getContents().get(0),
				(EObject) ((Resource) second.getResourceSet().getResources().get(0)).getContents().get(0));
	}
	/**
	 * This function recusrively compare all nodes of two trees
	 */
	public static void checkTrees(EObject first, EObject second) {
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
//							if (!(at1_id == DataPackage.FAST_TASK_TO_PROC_MAP_VAR )) 
							{

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
		} catch (AssertionFailedError e) {
			System.err.println(" o1 = " + first
				+ "\n o2 = " + second);
			throw e;
			
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
	
	
	public void testFill() {
		IVarTree vt = newFilledVT();
		
		System.out.println(Vt2StringUtilities.varTreeToStringErtd(vt));
	}
}