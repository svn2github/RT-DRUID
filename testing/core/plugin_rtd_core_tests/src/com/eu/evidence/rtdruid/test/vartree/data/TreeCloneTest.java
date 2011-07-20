/*
 * Created on 14-giu-2004
 */
package com.eu.evidence.rtdruid.test.vartree.data;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import com.eu.evidence.rtdruid.desk.RTDFactory;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVariable;
import com.eu.evidence.rtdruid.vartree.data.DataFactory;
import com.eu.evidence.rtdruid.vartree.data.ObjectWithID;
import com.eu.evidence.rtdruid.vartree.data.Schedulability;
import com.eu.evidence.rtdruid.vartree.data.SchedulingScenario;
import com.eu.evidence.rtdruid.vartree.data.System;
import com.eu.evidence.rtdruid.vartree.data.TaskSched;
import com.eu.evidence.rtdruid.vartree.data.init.IVTResource;
import com.eu.evidence.rtdruid.vartree.data.init.RTD_XMI_Factory;
import com.eu.evidence.rtdruid.vartree.data.init.Vt2StringUtilities;
import com.eu.evidence.rtdruid.vartree.data.init.VtCompare;
import com.eu.evidence.rtdruid.vartree.variables.DoubleVar;


/**
 * This class thes if "clone tree" and "merge tree" work well
 * 
 * @author Nicola Serreli
 */
public class TreeCloneTest extends TestCase {
	
	public TreeCloneTest() {
		RTDFactory.get(IVarTree.class); // init all EMF Data Factory
	}

	public static Test suite() {
		return new TestSuite(TreeCloneTest.class);
	}

	/**
	 * Start the "clone tree" test
	 */
	public void testClone() {

		ObjectWithID root = (ObjectWithID) (new FillVtTest()).fill();

		ObjectWithID root2 = (ObjectWithID) root.clone();

		assertTrue(root != root2);
		String t = (new VtCompare(root, root2)).getText();
		assertTrue(t, t== null);
	}

	/**
	 * Start the "clone tree" test
	 */
	public void testClone2() {
		String t;

		ObjectWithID root1 = DataFactory.eINSTANCE.createSystem();
		root1.setObjectID("a\\b/\\*c");
		ObjectWithID root2 = (ObjectWithID) root1.clone();
		ObjectWithID root3 = DataFactory.eINSTANCE.createSystem();
		root3.setObjectID(root1.getObjectID());

		assertTrue(root1 != root2);
		assertTrue(root1 != root3);
		assertTrue(root2 != root3);

		t = (new VtCompare(root1, root2)).getText(); assertTrue(t, t== null);
		t = (new VtCompare(root1, root3)).getText(); assertTrue(t, t== null);
		t = (new VtCompare(root2, root3)).getText(); assertTrue(t, t== null);
		
	}

	/**
	 * Start the "merge tree" test
	 */
	public void testMerge() {

		ObjectWithID root1 = (ObjectWithID) (new FillVtTest()).fill();
		ObjectWithID root2 = (ObjectWithID) (new FillVtTest()).fill();

		ObjectWithID dest = DataFactory.eINSTANCE.createSystem();
//		MyXMIReaderImpl res = new MyXMIReaderImpl();
//		res.getContents().add(dest);

		// set the same system name for all trees!!!
		root1.setObjectID("MySystem");
		root2.setObjectID("MySystem");
		dest.setObjectID("MySystem");

		dest.merge(root1, "", false);
		assertTrue(dest != root1);
		String t;
		t = (new VtCompare(dest, root1)).getText(); assertTrue(t, t== null);
		t = (new VtCompare(root1, dest)).getText(); assertTrue(t, t== null);

		boolean ok = false;
		// anothers two times
		dest.merge(root1, "", false);
		dest.merge(root1, "", false);
		assertTrue(dest != root1);
		

		assertTrue( !(new VtCompare(dest, root1)).checkTrees());
		assertTrue( !(new VtCompare(root1, dest)).checkTrees());

		// and with the other tree
		dest.merge(root2, "", false);
		assertTrue(dest != root1);
		assertTrue(dest != root2);
		checkTrees(dest, new ObjectWithID[] { root1, root1, root1, root2 }, true);

		ok = false;
		try {
			checkTrees(dest, new ObjectWithID[] { root1, root1, root1 }, true);

		} catch (AssertionFailedError e) {
			//e.printStackTrace();
			ok = true;
		}
		assertTrue(ok);

		ok = false;
		try {
			checkTrees(dest, new ObjectWithID[] { root1, root1, root2 }, true);

		} catch (AssertionFailedError e) {
			//e.printStackTrace();
			ok = true;
		}
		assertTrue(ok);

		ok = false;
		try {
			checkTrees(dest, new ObjectWithID[] { root1, root1, root1, root2 }, false);

		} catch (AssertionFailedError e) {
			//e.printStackTrace();
			ok = true;
		}
		assertTrue(ok);

		ok = false;
		try {
			checkTrees(dest, new ObjectWithID[] { root1, root1, root1 }, false);

		} catch (AssertionFailedError e) {
			//e.printStackTrace();
			ok = true;
		}
		assertTrue(ok);

	}
	
	/**
	 * Start the "merge tree" test
	 */
	public void testMergeWithResource() {

		ObjectWithID root1 = (ObjectWithID) (new FillVtTest()).fill();
		ObjectWithID root2 = (ObjectWithID) (new FillVtTest()).fill();

		IVTResource res = createResource();
		ObjectWithID dest = DataFactory.eINSTANCE.createSystem();
		res.getContents().add(dest);
		
		assertTrue(dest.eResource() != null);

		// set the same system name for all trees!!!
		root1.setObjectID("MySystem");
		root2.setObjectID("MySystem");
		dest.setObjectID("MySystem");

		dest.merge(root1, "", false);
		assertTrue(dest != root1);
		String t;
		t = (new VtCompare(dest, root1)).getText(); assertTrue(t, t== null);
		t = (new VtCompare(root1, dest)).getText(); assertTrue(t, t== null);

		// anothers two times
		dest.merge(root1, "", false);
		dest.merge(root1, "", false);
		assertTrue(dest != root1);
		
		t = (new VtCompare(dest, root1)).getText(); assertTrue(t, t== null);
		t = (new VtCompare(root1, dest)).getText(); assertTrue(t, t== null);

		// and wit the other tree
		dest.merge(root2, "", false);
		assertTrue(dest != root1);
		assertTrue(dest != root2);
		checkTrees(dest, new ObjectWithID[] { root1, root1, root1, root2 }, false);
		checkTrees(dest, new ObjectWithID[] { root1, root2 }, false);
		checkTrees(dest, new ObjectWithID[] { root1, root2 }, true);

		boolean ok = false;
		try {
			checkTrees(dest, new ObjectWithID[] { root1, root1, root1 }, false);

		} catch (AssertionFailedError e) {
			//e.printStackTrace();
			ok = true;
		}
		assertTrue(ok);

		ok = false;
		try {
			checkTrees(dest, new ObjectWithID[] { root1, root1, root2 }, true);

		} catch (AssertionFailedError e) {
			//e.printStackTrace();
			ok = true;
		}
		assertTrue(ok);

		ok = false;
		try {
			checkTrees(dest, new ObjectWithID[] { root1 }, true);

		} catch (AssertionFailedError e) {
			//e.printStackTrace();
			ok = true;
		}
		assertTrue(ok);

	}
	
	
	public void testMerge2() {
		String xmlInput1 = 	
//			"<!DOCTYPE SYSTEM SYSTEM \"evidence_0.2.dtd\">" +
			"<SYSTEM Name=\"hp_test5 (bug 223)\">" +
			"<SCHEDULABILITY>" +
			"<SCHEDULINGSCENARIO>" +
			"<CPUSCHED CpuRef=\"CPU0.erika\" Utilization=\"1.1484126984126983\" SpeedFactor=\"1.4285714285714286\" Boundary=\"0.7347722898562381\" Schedulable=\"false\"/>" +
			"<TASKSCHED TaskRef=\"t1\" Utilization=\"0.22222222222222222\" CDelta=\"-3\" Schedulable=\"true\" ResponseTime=\"2ms\"/>" +
			"</SCHEDULINGSCENARIO>" +
			"</SCHEDULABILITY>" +
			"</SYSTEM>";
		String xmlInput2 =
//			"<!DOCTYPE SYSTEM SYSTEM \"evidence_0.2.dtd\">" +
			"<SYSTEM Name=\"hp_test5 (bug 223)\">" +
			"<SCHEDULABILITY>" +
			"<SCHEDULINGSCENARIO>" +
			"<CPUSCHED CpuRef=\"CPU0.erika\" Utilization=\"1.1484126984126983\" SpeedFactor=\"1.4285714285714286\" Boundary=\"0.7347722898562381\" Schedulable=\"false\"/>" +
			"<TASKSCHED TaskRef=\"t1\" Utilization=\"0.1\" CDelta=\"-3\" Schedulable=\"true\" ResponseTime=\"2ms\"/>" +
			"</SCHEDULINGSCENARIO>" +
			"</SCHEDULABILITY>" +
			"</SYSTEM>";
		
//		ObjectWithID root1 = (ObjectWithID) XMI2XMLlTest.loadString(xmlInput1).getContents().get(0);
//		ObjectWithID root2 = (ObjectWithID) XMI2XMLlTest.loadString(xmlInput2).getContents().get(0);

		ObjectWithID root1 = (ObjectWithID) Vt2StringUtilities.loadString(xmlInput1).getResourceSet().getResources().get(0).getContents().get(0);
		ObjectWithID root2 = (ObjectWithID) Vt2StringUtilities.loadString(xmlInput2).getResourceSet().getResources().get(0).getContents().get(0);

		String t;
		t = (new VtCompare(root1, root1)).getText(); assertTrue(t, t== null);
		t = (new VtCompare(root2, root2)).getText(); assertTrue(t, t== null);

		assertTrue( !(new VtCompare(root1, root2)).checkTrees());

		// without set a resource
		ObjectWithID root1_bis = (ObjectWithID) root1.clone();
		root1_bis.merge(root2, "/", false);

		// after set a resource
		IVTResource res = createResource();
		ObjectWithID root1_tris = (ObjectWithID) root1.clone();
		res.getContents().add(root1_tris);
		boolean ok = false;
		try {
//			root2.merge(root1_bis, "/");
			root1_tris.merge(root2, "/", false);
		} catch (RuntimeException e) { ok = true; } 
		assertTrue(ok);
	}

	
	public void testMerge3() {
		
		System root = DataFactory.eINSTANCE.createSystem();
		root.setObjectID("id");
		Schedulability sched = DataFactory.eINSTANCE.createSchedulability();
		root.setSchedulability(sched);
		SchedulingScenario sScen = DataFactory.eINSTANCE.createSchedulingScenario();
		sScen.setObjectID("Abc");
		sched.getSchedulingScenarioList().add(sScen);
		{
			TaskSched ts = DataFactory.eINSTANCE.createTaskSched();
			ts.setObjectID("t1");
			ts.setUtilization(new DoubleVar("0.1"));
			assertTrue(sScen.getTaskSchedList().add(ts));
		}
		{
			TaskSched ts = DataFactory.eINSTANCE.createTaskSched();
			ts.setObjectID("t1");
			ts.setUtilization(new DoubleVar("0.3"));
			assertTrue(sScen.getTaskSchedList().add(ts)); // NB
			assertTrue(!sScen.getTaskSchedList().add(ts)); // NB

			ts.setObjectID("t2");
			assertTrue(!sScen.getTaskSchedList().add(ts));

			ts.setObjectID("t1");
		}
		
		System root2 = DataFactory.eINSTANCE.createSystem();
		root2.setObjectID("id");

		root2.merge(root, "/", false);
	}
	
	public void testMerge3WithResource() {
	
		IVTResource res = createResource();
		System root = DataFactory.eINSTANCE.createSystem();
		res.getContents().add(root);
		
		root.setObjectID("id");
		Schedulability sched = DataFactory.eINSTANCE.createSchedulability();
		root.setSchedulability(sched);
		SchedulingScenario sScen = DataFactory.eINSTANCE.createSchedulingScenario();
		sScen.setObjectID("Abc");
		sched.getSchedulingScenarioList().add(sScen);
		{
			TaskSched ts = DataFactory.eINSTANCE.createTaskSched();
			ts.setObjectID("t1");
			ts.setUtilization(new DoubleVar("0.1"));
			assertTrue(sScen.getTaskSchedList().add(ts));
		}
		{
			TaskSched ts = DataFactory.eINSTANCE.createTaskSched();
			ts.setObjectID("t1");
			ts.setUtilization(new DoubleVar("0.3"));
			assertTrue(!sScen.getTaskSchedList().add(ts)); // NB
			assertTrue(!sScen.getTaskSchedList().add(ts)); // NB

			ts.setObjectID("t2");
			assertTrue(sScen.getTaskSchedList().add(ts));

			boolean ok = false;
			try {
				ts.setObjectID("t1");
			} catch (RuntimeException e) {
				ok = true;
			}
			assertTrue(ok);
		}
		
		System root2 = DataFactory.eINSTANCE.createSystem();
		root2.setObjectID("id");

		root2.merge(root, "/", false);
	}
	
	/*public void testMerge4() {
		String xmlInput1 = 	"<SYSTEM Name=\"hp_test5 (bug 223)\">" +
			"<SCHEDULABILITY>" +
			"<SCHEDULINGSCENARIO>" +
			"<TASKSCHED TaskRef=\"t1\" Utilization=\"0.22222222222222222\" CDelta=\"-3\" Schedulable=\"true\" ResponseTime=\"2ms\"/>" +
			"<TASKSCHED TaskRef=\"t1\" Utilization=\"0.1\" CDelta=\"-3\" Schedulable=\"true\" ResponseTime=\"2ms\"/>" +
			"</SCHEDULINGSCENARIO>" +
			"</SCHEDULABILITY>" +
			"</SYSTEM>";
		String xmlInput2 = 	"<SYSTEM Name=\"hp_test5 (bug 223)\">" +
			"<SCHEDULABILITY>" +
			"<SCHEDULINGSCENARIO>" +
			"<TASKSCHED TaskRef=\"t2\" Utilization=\"0.1\" CDelta=\"-3\" Schedulable=\"true\" ResponseTime=\"2ms\"/>" +
			"</SCHEDULINGSCENARIO>" +
			"</SCHEDULABILITY>" +
			"</SYSTEM>";
		
		ObjectWithID root1 = (ObjectWithID) XMI2XMLlTest.loadString(xmlInput1).getContents().get(0);
		ObjectWithID root2 = (ObjectWithID) XMI2XMLlTest.loadString(xmlInput2).getContents().get(0);
		
		Utility.checkTrees(root1, root1);

		Utility.checkTrees(root2, root2);
		
		boolean ok = false;
		try {
			Utility.checkTrees(root1, root2);
		} catch (AssertionFailedError e) { ok = true; } 
		assertTrue(ok);

		{
			ObjectWithID root1_bis = (ObjectWithID) root1.clone();
			root1_bis.merge(root2, "/");
		}
		{
			ObjectWithID root2_bis = (ObjectWithID) root2.clone();
			ok = false;
			try {
				root2_bis.merge(root1, "/");
			} catch (RuntimeException e) { ok = true; } 
			assertTrue(ok);
		}
	}*/


	/**
	 * Check a merged tree against its "parents"
	 */
	private void checkTrees(ObjectWithID dest, ObjectWithID[] sources, boolean multiValue) {
		if (sources.length == 0) {
			return;
		}
		for (int i = 0; i < sources.length; i++) {
			//assertTrue(dest.getClass().getName().equals(sources[i].getClass().getName()));
			assertTrue(dest.getClass() == sources[i].getClass());
		}

		EList attrList1 = dest.eClass().getEAllAttributes();

		for (int i = 0; i < attrList1.size(); i++) {
			EAttribute at1 = (EAttribute) attrList1.get(i);

			if (at1.isMany()) {
				EList el1 = (EList) dest.eGet(at1);

				LinkedList[] el2 = new LinkedList[sources.length];
				for (int h = 0; h < sources.length; h++) {
					el2[h] = new LinkedList((EList) sources[h].eGet(at1));
				}

				for (int j = 0; j < el1.size(); j++) {
					IVariable o1 = (IVariable) el1.get(j);
					remove(o1, el2);
				}

				// check that all parents are empty
				for (int h = 0; h < sources.length; h++) {
					assertTrue(el2[h].size() == 0);
				}

			} else {
				IVariable o1 = (IVariable) dest.eGet(at1);

				for (int h = 0; h < sources.length; h++) {
					if (o1 == null) {
						assertTrue(sources[h].eGet(at1) == null);
					} else {
						IVariable tv = (IVariable) sources[h].eGet(at1);
						if (tv != null) {
							assertTrue(o1.getClass() == tv.getClass());

							if (o1.get() == null) {
								assertTrue(tv.get() == null);
							} else {
								assertTrue(o1.toString().equals(tv.toString()));
							}
						}
					}
				}

			}
		}

		EList children1 = dest.eClass().getEAllReferences();

		for (int i = 0; i < children1.size(); i++) {

			EReference ref1 = (EReference) children1.get(i);

			if (ref1.isMany()) {
				EList el1 = (EList) dest.eGet(ref1);

				LinkedList[] el2 = new LinkedList[sources.length];
				for (int h = 0; h < sources.length; h++) {
					el2[h] = new LinkedList((EList) sources[h].eGet(ref1));
				}

				for (int j = 0; j < el1.size(); j++) {
					ObjectWithID o1 = (ObjectWithID) el1.get(j);
					ObjectWithID[] next = remove(o1, el2, multiValue);

					if (next.length == 0) {
						int a=0;
						a++;
					}
					assertTrue(next.length > 0);
					if (next.length == 1) {
						String t = (new VtCompare(o1, next[0])).getText(); assertTrue(t, t== null);
					} else {
						checkTrees(o1, next, multiValue);
					}
				}

				// check that all parents are empty
				for (int h = 0; h < sources.length; h++) {
					assertTrue(el2[h].size() == 0);
				}

			} else {
				ObjectWithID o1 = (ObjectWithID) dest.eGet(ref1);

				ArrayList next = new ArrayList();
				for (int h = 0; h < sources.length; h++) {
					ObjectWithID t = (ObjectWithID) sources[h].eGet(ref1);
					if (t != null) {
						next.add(t);
					}
				}

				assertTrue(next.size() > 0);
				if (next.size() == 1) {
					String t = (new VtCompare(o1, (EObject) next.get(0))).getText(); assertTrue(t, t== null);
				} else {
					checkTrees(o1, (ObjectWithID[]) next
							.toArray(new ObjectWithID[0]), multiValue);
				}

			}
		}

	}

	/**
	 * Check that the given var val appears at least in one parent list
	 */
	private void remove(IVariable value, LinkedList[] parents) {
		boolean found = false;

		for (int i = 0; i < parents.length; i++) {
			Iterator iter = parents[i].iterator();

			boolean go = false;
			while (!go && iter.hasNext()) {
				IVariable v = (IVariable) iter.next();
				if (v == null && value == null) {
					iter.remove();
					go = true;

				} else if (value != null && v != null) {
					Object v1 = v.get();
					Object v2 = value.get();
					boolean eq = (v1 == null ? v2 == null : v1.toString()
							.equals(v2.toString()));
					if (eq) {
						iter.remove();
						go = true;
					}
				}
			}

			found |= go;
		}

		assertTrue(found);
	}

	/**
	 * Check that the given ObjectWithID appears at least in one parent list
	 */
	private ObjectWithID[] remove(ObjectWithID val, LinkedList[] parents, boolean multiValues) {
		ArrayList answer = new ArrayList();

		String curID = val.getObjectID();

		for (int i = 0; i < parents.length; i++) {
			Iterator iter = parents[i].iterator();

			boolean go = false;
			while (!go && iter.hasNext()) {
				ObjectWithID v = (ObjectWithID) iter.next();

				String sourceID = v.getObjectID();
				if (curID == null ? sourceID == null : curID.equals(sourceID)) {

					iter.remove();
					answer.add(v);
					go = true;
				}
			}
			if (go && multiValues) {
				break;
			}
		}

		return (ObjectWithID[]) answer.toArray(new ObjectWithID[0]);
	}
	
	protected IVTResource createResource() {
		return (IVTResource) new RTD_XMI_Factory().createResource();
	}

}