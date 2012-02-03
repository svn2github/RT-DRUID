/*
 * Created on 14-giu-2004
 */
package com.eu.evidence.rtdruid.test.vartree.data;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.junit.Ignore;
import org.junit.Test;

import com.eu.evidence.rtdruid.io.IVTResource;
import com.eu.evidence.rtdruid.io.RTD_XMI_Factory;
import com.eu.evidence.rtdruid.io.XMI2XMLlTest;
import com.eu.evidence.rtdruid.tests.vartree.data.FillVtUtil;
import com.eu.evidence.rtdruid.vartree.IVariable;
import com.eu.evidence.rtdruid.vartree.VarTreeUtil;
import com.eu.evidence.rtdruid.vartree.Vt2StringUtilities;
import com.eu.evidence.rtdruid.vartree.data.DataFactory;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.data.ObjectWithID;
import com.eu.evidence.rtdruid.vartree.data.Schedulability;
import com.eu.evidence.rtdruid.vartree.data.SchedulingScenario;
import com.eu.evidence.rtdruid.vartree.data.System;
import com.eu.evidence.rtdruid.vartree.data.TaskSched;
import com.eu.evidence.rtdruid.vartree.variables.DoubleVar;


/**
 * This class thes if "clone tree" and "merge tree" work well
 * 
 * @author Nicola Serreli
 */
public class TreeCloneTest {

	/**
	 * Start the "clone tree" test
	 * @throws Throwable 
	 */
	@Test
	public void testClone() throws Throwable {

		ObjectWithID root = fill();

		EObject root2 = VarTreeUtil.copy(root);

		assertNotSame(root, root2);
		compare(root, root2);
	}

	/**
	 * Start the "clone tree" test
	 * @throws Throwable 
	 */
	@Test
	public void testClone2() throws Throwable {
		ObjectWithID root1 = DataFactory.eINSTANCE.createSystem();
		root1.setObjectID("a\\b/\\*c");
		EObject root2 = VarTreeUtil.copy(root1);
		ObjectWithID root3 = DataFactory.eINSTANCE.createSystem();
		root3.setObjectID(root1.getObjectID());
			
		assertNotSame(root1 , root2);
		assertNotSame(root1 , root3);
		assertNotSame(root2 , root3);

		compare(root1, root2);
		compare(root1, root3);
		compare(root2, root3);
		
	}

	/**
	 * Start the "merge tree" test
	 * @throws Throwable 
	 */
	@Test
	public void testMerge() throws Throwable {
		ObjectWithID root1 = fill();
		ObjectWithID root2 = fill();
		
		// note: root1 and root2 contains the same values
		compare(root1, root2);

		doTestMerge(root1, root2, DataFactory.eINSTANCE.createSystem());
	}
	
	/**
	 * Start the "merge tree" test
	 * @throws Throwable 
	 */
	@Test
	@Ignore
	public void testMergeDistinct() throws Throwable {

		FillVtUtil f1 = fillFiller();
		ObjectWithID root1 = (ObjectWithID) f1.getLastRoot();
		ObjectWithID root2 = (ObjectWithID)fillFiller(f1.getNextID()+1).getLastRoot();
		assertFalse(VarTreeUtil.compare(root1, root2).isOK());

		ObjectWithID dest = DataFactory.eINSTANCE.createSystem();
		doTestMerge(root1, root2, dest);
	}

	/**
	 * Start the "merge tree" test
	 * @throws Throwable 
	 */
	@Test
	public void testMergeWithResource() throws Throwable {

		ObjectWithID root1 = fill();
		ObjectWithID root2 = fill();

		IVTResource res = createResource();
		ObjectWithID dest = DataFactory.eINSTANCE.createSystem();
		res.getContents().add(dest);
		
		assertNotNull(dest.eResource());
		doTestMerge(root1, root2, dest);
	}
	
	private void doTestMerge(ObjectWithID root1, ObjectWithID root2, ObjectWithID dest) throws Throwable {
		// set the same system name for all trees!!!
		root1.setObjectID("MySystem");
		root2.setObjectID("MySystem");
		dest.setObjectID("MySystem");

		VarTreeUtil.merge(dest, root1);
		
		assertNotSame(dest , root1);
		compare(dest, root1);
		compare(root1, dest);

		boolean ok = false;
		// two more times
		VarTreeUtil.merge(dest, root1);
		VarTreeUtil.merge(dest, root1);
		assertNotSame(dest , root1);
		
		assertFalse(VarTreeUtil.compare(dest, root1).isOK());
		assertFalse(VarTreeUtil.compare(root1, dest).isOK());

		// and with the other tree
		VarTreeUtil.merge(dest, root2);
		assertNotSame(dest , root1);
		assertNotSame(dest , root2);
		checkTrees(dest, new ObjectWithID[] { root1, root1, root1, root2 }, true);

		ok = false;
		try {
			checkTrees(dest, new ObjectWithID[] { root1, root1, root1 }, true);

		} catch (AssertionError e) {
			//e.printStackTrace();
			ok = true;
		}
		assertTrue(ok);

		ok = false;
		try {
			checkTrees(dest, new ObjectWithID[] { root1, root1, root2 }, true);

		} catch (AssertionError e) {
			//e.printStackTrace();
			ok = true;
		}
		assertTrue(ok);

		ok = false;
		try {
			checkTrees(dest, new ObjectWithID[] { root1, root1, root1, root2 }, false);

		} catch (AssertionError e) {
			//e.printStackTrace();
			ok = true;
		}
		assertTrue(ok);

		ok = false;
		try {
			checkTrees(dest, new ObjectWithID[] { root1, root1, root1 }, false);

		} catch (AssertionError e) {
			//e.printStackTrace();
			ok = true;
		}
		assertTrue(ok);

	}
	
	

	@Test
	public void testMerge2() throws Throwable {
		String xmlInput1 = 	
			"<SYSTEM Name=\"hp_test5 (bug 223)\">" +
			"<SCHEDULABILITY>" +
			"<SCHEDULINGSCENARIO>" +
			"<CPUSCHED CpuRef=\"CPU0.erika\" Utilization=\"1.1484126984126983\" SpeedFactor=\"1.4285714285714286\" Boundary=\"0.7347722898562381\" Schedulable=\"false\"/>" +
			"<TASKSCHED TaskRef=\"t1\" Utilization=\"0.22222222222222222\" CDelta=\"-3\" Schedulable=\"true\" ResponseTime=\"2ms\"/>" +
			"</SCHEDULINGSCENARIO>" +
			"</SCHEDULABILITY>" +
			"</SYSTEM>";
		String xmlInput2 =
			"<SYSTEM Name=\"hp_test5 (bug 223)\">" +
			"<SCHEDULABILITY>" +
			"<SCHEDULINGSCENARIO>" +
			"<CPUSCHED CpuRef=\"CPU0.erika\" Utilization=\"1.1484126984126983\" SpeedFactor=\"1.4285714285714286\" Boundary=\"0.7347722898562381\" Schedulable=\"false\"/>" +
			"<TASKSCHED TaskRef=\"t1\" Utilization=\"0.1\" CDelta=\"-3\" Schedulable=\"true\" ResponseTime=\"2ms\"/>" +
			"</SCHEDULINGSCENARIO>" +
			"</SCHEDULABILITY>" +
			"</SYSTEM>";
		
		ObjectWithID root1 = (ObjectWithID) Vt2StringUtilities.loadString(xmlInput1).getResourceSet().getResources().get(0).getContents().get(0);
		ObjectWithID root2 = (ObjectWithID) Vt2StringUtilities.loadString(xmlInput2).getResourceSet().getResources().get(0).getContents().get(0);

		compare(root1, root1);
		compare(root2, root2);

		assertFalse(VarTreeUtil.compare(root1, root2).isOK());

		// without set a resource
		EObject root1_bis = VarTreeUtil.copy(root1);
		VarTreeUtil.merge(root1_bis, root2);

		// after set a resource
		IVTResource res = createResource();
		EObject root1_tris = VarTreeUtil.copy(root1);
		res.getContents().add(root1_tris);
		VarTreeUtil.merge(root1_tris, root2);
		compare(root1_bis, root1_tris);
	}

	
	@Test
	public void testMerge3() throws Throwable {
		doTestMerge3(DataFactory.eINSTANCE.createSystem());
	}
	
	@Test
	public void testMerge3WithResource() throws Throwable {
	
		IVTResource res = createResource();
		System root = DataFactory.eINSTANCE.createSystem();
		res.getContents().add(root);
		
		doTestMerge3(root);
	}
		
	private void doTestMerge3(System root) throws Throwable {
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
			assertFalse(sScen.getTaskSchedList().add(ts)); // NB

			ts.setObjectID("t2");
			assertFalse(sScen.getTaskSchedList().add(ts));

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

		VarTreeUtil.merge(root2, root);
		compare(root2, root);
	}
	
	@Test
	@Ignore
	public void testMerge4() throws IOException {
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
		
		ObjectWithID root1 = (ObjectWithID) XMI2XMLlTest.loadStringRtd(xmlInput1).getContents().get(0);
		ObjectWithID root2 = (ObjectWithID) XMI2XMLlTest.loadStringRtd(xmlInput2).getContents().get(0);
		
		assertTrue(VarTreeUtil.compare(root1, root1).isOK());

		assertTrue(VarTreeUtil.compare(root2, root2).isOK());
		
		assertFalse(VarTreeUtil.compare(root1, root2).isOK());
		
		boolean ok = false;
		{
			EObject root1_bis = VarTreeUtil.copy(root1);
			VarTreeUtil.merge(root1_bis, root2, "/", false);
		}
		{
			EObject root2_bis = VarTreeUtil.copy(root2);
			ok = false;
			try {
				VarTreeUtil.merge(root2_bis, root1, "/", false);
			} catch (RuntimeException e) { ok = true; } 
			assertTrue(ok);
		}
	}


	/**
	 * Check a merged tree against its "parents"
	 * @throws Throwable 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void checkTrees(ObjectWithID dest, ObjectWithID[] sources, boolean multiValue) throws Throwable {
		if (sources.length == 0) {
			return;
		}
		for (int i = 0; i < sources.length; i++) {
			//assertTrue(dest.getClass().getName().equals(sources[i].getClass().getName()));
			assertSame(dest.getClass() , sources[i].getClass());
		}

		EList<EAttribute> attrList1 = dest.eClass().getEAllAttributes();

		for (int i = 0; i < attrList1.size(); i++) {
			EAttribute at1 = (EAttribute) attrList1.get(i);

			if (at1.isMany()) {
				EList<IVariable> el1 = (EList<IVariable>) dest.eGet(at1);

				LinkedList<IVariable>[] el2 = new LinkedList[sources.length];
				for (int h = 0; h < sources.length; h++) {
					el2[h] = new LinkedList<IVariable>((EList) sources[h].eGet(at1));
				}

				for (int j = 0; j < el1.size(); j++) {
					IVariable o1 = (IVariable) el1.get(j);
					remove(o1, el2);
				}

				// check that all parents are empty
				for (int h = 0; h < sources.length; h++) {
					assertEquals(el2[h].size() , 0);
				}

			} else {
				IVariable o1 = (IVariable) dest.eGet(at1);

				for (int h = 0; h < sources.length; h++) {
					if (o1 == null) {
						assertNull(sources[h].eGet(at1));
					} else {
						IVariable tv = (IVariable) sources[h].eGet(at1);
						if (tv != null) {
							assertSame(o1.getClass() , tv.getClass());

							if (o1.get() == null) {
								assertNull(tv.get());
							} else {
								assertTrue(o1.toString().equals(tv.toString()));
							}
						}
					}
				}

			}
		}

		EList<EReference> children1 = dest.eClass().getEAllReferences();

		for (int i = 0; i < children1.size(); i++) {

			EReference ref1 = (EReference) children1.get(i);

			if (ref1.isMany()) {
				EList<ObjectWithID> el1 = (EList<ObjectWithID>) dest.eGet(ref1);

				LinkedList<ObjectWithID>[] el2 = new LinkedList[sources.length];
				for (int h = 0; h < sources.length; h++) {
					el2[h] = new LinkedList((EList<ObjectWithID>) sources[h].eGet(ref1));
				}

				for (int j = 0; j < el1.size(); j++) {
					ObjectWithID o1 = (ObjectWithID) el1.get(j);
					ObjectWithID[] next = remove(o1, el2, multiValue);

//					if (next.length == 0) {
//						int a=0;
//						a++;
//					}
					assertTrue(next.length > 0);
					if (next.length == 1) {
						compare(o1, next[0]);
					} else {
						checkTrees(o1, next, multiValue);
					}
				}

				// check that all parents are empty
				for (int h = 0; h < sources.length; h++) {
					assertEquals(el2[h].size() , 0);
				}

			} else {
				ObjectWithID o1 = (ObjectWithID) dest.eGet(ref1);

				ArrayList<ObjectWithID> next = new ArrayList<ObjectWithID>();
				for (int h = 0; h < sources.length; h++) {
					ObjectWithID t = (ObjectWithID) sources[h].eGet(ref1);
					if (t != null) {
						next.add(t);
					}
				}

				assertTrue(next.size() > 0);
				if (next.size() == 1) {
					compare(o1, (EObject) next.get(0));
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
	private void remove(IVariable value, LinkedList<IVariable>[] parents) {
		boolean found = false;

		for (int i = 0; i < parents.length; i++) {
			Iterator<IVariable> iter = parents[i].iterator();

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
	private ObjectWithID[] remove(ObjectWithID val, LinkedList<ObjectWithID>[] parents, boolean multiValues) {
		ArrayList<ObjectWithID> answer = new ArrayList<ObjectWithID>();

		String curID = val.getObjectID();

		for (int i = 0; i < parents.length; i++) {
			Iterator<ObjectWithID> iter = parents[i].iterator();

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

	/**
	 * @return
	 * @throws IOException 
	 */
	protected ObjectWithID fill() throws IOException {
		return (ObjectWithID) fillFiller().getLastRoot();
	}
	
	protected FillVtUtil fillFiller() throws IOException {
		return fillFiller(1);
	}
	
	protected FillVtUtil fillFiller(int startingValue) throws IOException {
		FillVtUtil filler = new FillVtUtil(VarTreeUtil.newVarTree(), DataPackage.eINSTANCE, createResource());
		filler.setNextID(startingValue);
		ObjectWithID root = DataFactory.eINSTANCE.createSystem();
		filler.fill(root);
		return filler;
	}

	
	protected IVTResource createResource() {
		return (IVTResource) RTD_XMI_Factory.instance.createResource();
	}


	/**
	 * @param dest
	 * @param root1
	 * @throws Throwable 
	 */
	private boolean compare(EObject dest, EObject root1) throws Throwable {
		IStatus s = VarTreeUtil.compare(dest, root1);
		Throwable t = s.getException();
		if (t != null) {
			throw t;
		}
		return s.isOK();
	}
}