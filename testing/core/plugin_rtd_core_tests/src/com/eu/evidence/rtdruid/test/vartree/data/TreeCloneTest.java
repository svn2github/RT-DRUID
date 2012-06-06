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
import org.junit.Test;

import com.eu.evidence.rtdruid.io.IVTResource;
import com.eu.evidence.rtdruid.io.RTD_XMI_Factory;
import com.eu.evidence.rtdruid.io.XMI2XMLlTest;
import com.eu.evidence.rtdruid.tests.RtdAssert;
import com.eu.evidence.rtdruid.tests.vartree.data.FillVtUtil;
import com.eu.evidence.rtdruid.vartree.IVariable;
import com.eu.evidence.rtdruid.vartree.VarTreeIdHandler;
import com.eu.evidence.rtdruid.vartree.VarTreeUtil;
import com.eu.evidence.rtdruid.vartree.Vt2StringUtilities;
import com.eu.evidence.rtdruid.vartree.data.DataFactory;
import com.eu.evidence.rtdruid.vartree.data.Schedulability;
import com.eu.evidence.rtdruid.vartree.data.SchedulingScenario;
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

		EObject root = fill();

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
		EObject root1 = VarTreeUtil.newVarTreeRoot(VarTreeUtil.newVarTree());
		VarTreeIdHandler.setId(root1, "a\\b/\\*c");
		EObject root2 = VarTreeUtil.copy(root1);
		EObject root3 = VarTreeUtil.newVarTreeRoot(VarTreeUtil.newVarTree());
		VarTreeIdHandler.setId(root3, VarTreeIdHandler.getId(root1));
			
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
		EObject root1 = fill();
		EObject root2 = fill();
		
		// note: root1 and root2 contains the same values
		compare(root1, root2);

		doTestMerge(root1, root2, VarTreeUtil.newVarTreeRoot(VarTreeUtil.newVarTree()));
	}
	
	/**
	 * Start the "merge tree" test
	 * @throws Throwable 
	 */
	@Test
	public void testMergeDistinct() throws Throwable {

		doTestMergeDistinct(false);
		doTestMergeDistinct(true);
	}

	/**
	 * Start the "merge tree" test
	 * @throws Throwable 
	 */
	private void doTestMergeDistinct(boolean enableProperties) throws Throwable {

		FillVtUtil f1 = fillFiller(enableProperties);
		final EObject root1 = f1.getLastRoot();
		final EObject root2 = fillFiller(f1.getNextID()+1, enableProperties).getLastRoot();
		final EObject dest = VarTreeUtil.newVarTreeRoot(VarTreeUtil.newVarTree());
		assertFalse(VarTreeUtil.compare(root1, root2).isOK());

		if (enableProperties) {
			new RtdAssert(IllegalArgumentException.class) {
				@Override
				protected void doCheck() throws Throwable {
					doTestMerge(root1, root2, dest);
				}
			};
		} else {
			doTestMerge(root1, root2, dest);
		}
	}
	/**
	 * Start the "merge tree" test
	 * @throws Throwable 
	 */
	@Test
	public void testMergeWithResource() throws Throwable {

		EObject root1 = fill();
		EObject root2 = fill();

		IVTResource res = createResource();
		EObject dest = VarTreeUtil.newVarTreeRoot(VarTreeUtil.newVarTree());
		res.getContents().add(dest);
		
		assertNotNull(dest.eResource());
		doTestMerge(root1, root2, dest);
	}
	
	private void doTestMerge(final EObject root1, final EObject root2, final EObject dest) throws Throwable {
		// set the same system name for all trees!!!
		VarTreeIdHandler.setId(root1, "MySystem");
		VarTreeIdHandler.setId(root2, "MySystem");
		VarTreeIdHandler.setId(dest, "MySystem");

		VarTreeUtil.merge(dest, root1);
		
		assertNotSame(dest , root1);
		compare(dest, root1);
		compare(root1, dest);

		// two more times
		VarTreeUtil.merge(dest, root1);
		VarTreeUtil.merge(dest, root1);
		assertNotSame(dest , root1);
		
		assertTrue(VarTreeUtil.compare(dest, root1).isOK());
		assertTrue(VarTreeUtil.compare(root1, dest).isOK());

		// and with the other tree
		VarTreeUtil.merge(dest, root2);
		assertNotSame(dest , root1);
		assertNotSame(dest , root2);
		checkTrees(dest, new EObject[] { root1, root1, root1, root2 }, false);

		new RtdAssert() {
			protected void doCheck() throws Throwable {
				checkTrees(dest, new EObject[] { root1, root1, root1 }, true);
			};
		};
		new RtdAssert() {
			protected void doCheck() throws Throwable {
				checkTrees(dest, new EObject[] { root1, root1, root2 }, true);
			};
		};
		new RtdAssert() {
			protected void doCheck() throws Throwable {
				checkTrees(dest, new EObject[] { root1, root1, root1, root2 }, true);
			};
		};
		
		if (VarTreeUtil.compare(dest, root1).isOK()) {
			checkTrees(dest, new EObject[] { root1 }, false);
			checkTrees(dest, new EObject[] { root2 }, false);
			checkTrees(dest, new EObject[] { root1, root1, root1 }, false);
			checkTrees(dest, new EObject[] { root2, root2, root2 }, false);
		} else {
			new RtdAssert() {
				protected void doCheck() throws Throwable {
					checkTrees(dest, new EObject[] { root1 }, false);
				};
			};
			new RtdAssert() {
				protected void doCheck() throws Throwable {
					checkTrees(dest, new EObject[] { root2 }, false);
				};
			};
			new RtdAssert() {
				protected void doCheck() throws Throwable {
					checkTrees(dest, new EObject[] { root1, root1, root1 }, false);
				};
			};
			new RtdAssert() {
				protected void doCheck() throws Throwable {
					checkTrees(dest, new EObject[] { root2, root2, root2 }, false);
				};
			};
		}

	}
	
	@Test
	public void testCheck() throws Throwable {
		final EObject root1 = fill();
		EObject root1_copy1 = VarTreeUtil.copy(root1);
		EObject root1_copy2 = VarTreeUtil.copy(root1);
		checkTrees(root1_copy1, new EObject[] { root1_copy2 }, false);
		IStatus st;
		st = VarTreeUtil.compare(root1, root1_copy1); assertTrue(st.getMessage(), st.isOK());
		st = VarTreeUtil.compare(root1, root1_copy2); assertTrue(st.getMessage(), st.isOK());
		st = VarTreeUtil.compare(root1_copy1, root1_copy2); assertTrue(st.getMessage(), st.isOK());
		
		checkTrees(root1, new EObject[] { root1 }, false);
		checkTrees(root1, new EObject[] { root1 }, true);
		new RtdAssert() {
			protected void doCheck() throws Throwable {
				checkTrees(root1, new EObject[] { root1, root1}, true);
			};
		};
		checkTrees(root1, new EObject[] { root1, root1, root1 }, false);
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
		
		final EObject root1 = Vt2StringUtilities.loadString(xmlInput1).getResourceSet().getResources().get(0).getContents().get(0);
		final EObject root2 = Vt2StringUtilities.loadString(xmlInput2).getResourceSet().getResources().get(0).getContents().get(0);

		compare(root1, root1);
		compare(root2, root2);

		assertFalse(VarTreeUtil.compare(root1, root2).isOK());

		new RtdAssert(IllegalArgumentException.class) {
			protected void doCheck() throws Throwable {
				// without set a resource
				EObject root1_bis = VarTreeUtil.copy(root1);
				VarTreeUtil.merge(root1_bis, root2);		
			};
		};

		new RtdAssert(IllegalArgumentException.class) {
			protected void doCheck() throws Throwable {
				// after set a resource
				IVTResource res = createResource();
				EObject root1_tris = VarTreeUtil.copy(root1);
				res.getContents().add(root1_tris);
				VarTreeUtil.merge(root1_tris, root2);
//				compare(root1_bis, root1_tris);
			};
		};

	}

	
	@Test
	public void testMerge3() throws Throwable {
		doTestMerge3(DataFactory.eINSTANCE.createSystem());
	}
	
	@Test
	public void testMerge3WithResource() throws Throwable {
	
		IVTResource res = createResource();
		com.eu.evidence.rtdruid.vartree.data.System root = DataFactory.eINSTANCE.createSystem();
		res.getContents().add(root);
		
		doTestMerge3(root);
	}
		
	private void doTestMerge3(final com.eu.evidence.rtdruid.vartree.data.System root) throws Throwable {
		VarTreeIdHandler.setId(root, "id");
		Schedulability sched = DataFactory.eINSTANCE.createSchedulability();
		root.setSchedulability(sched);
		SchedulingScenario sScen = DataFactory.eINSTANCE.createSchedulingScenario();
		VarTreeIdHandler.setId(sScen, "Abc");
		sched.getSchedulingScenarioList().add(sScen);
		{
			TaskSched ts = DataFactory.eINSTANCE.createTaskSched();
			VarTreeIdHandler.setId(ts, "t1");
			ts.setUtilization(new DoubleVar("0.1"));
			assertTrue(sScen.getTaskSchedList().add(ts));
		}
		{
			TaskSched ts = DataFactory.eINSTANCE.createTaskSched();
			VarTreeIdHandler.setId(ts, "t1");
			ts.setUtilization(new DoubleVar("0.3"));
			assertTrue(sScen.getTaskSchedList().add(ts)); // NB
			assertFalse(sScen.getTaskSchedList().add(ts)); // NB

			assertEquals(2, sScen.getTaskSchedList().size());
			assertEquals("t1", VarTreeIdHandler.getId(sScen.getTaskSchedList().get(0)));
			assertEquals("t1", VarTreeIdHandler.getId(sScen.getTaskSchedList().get(1)));

			VarTreeIdHandler.setId(ts, "t2");
			assertFalse(sScen.getTaskSchedList().add(ts));

			assertEquals(2, sScen.getTaskSchedList().size());
			assertEquals("t1", VarTreeIdHandler.getId(sScen.getTaskSchedList().get(0)));
			assertEquals("t2", VarTreeIdHandler.getId(sScen.getTaskSchedList().get(1)));

			{
				final EObject root2 =  DataFactory.eINSTANCE.createSystem();
				VarTreeIdHandler.setId(root2, "id");
				VarTreeUtil.merge(root2, root);
			}
			assertEquals(2, sScen.getTaskSchedList().size());
			assertEquals("t1", VarTreeIdHandler.getId(sScen.getTaskSchedList().get(0)));
			assertEquals("t2", VarTreeIdHandler.getId(sScen.getTaskSchedList().get(1)));

			VarTreeIdHandler.setId(ts, "t1");
			
			assertEquals(2, sScen.getTaskSchedList().size());
			assertEquals("t1", VarTreeIdHandler.getId(sScen.getTaskSchedList().get(0)));
			assertEquals("t1", VarTreeIdHandler.getId(sScen.getTaskSchedList().get(1)));
		}
		
		{
			final EObject root2 =  DataFactory.eINSTANCE.createSystem();
			VarTreeIdHandler.setId(root2, "id");
	
			new RtdAssert(IllegalArgumentException.class) {
				@Override
				protected void doCheck() throws Throwable {
					VarTreeUtil.merge(root2, root);
				}
			};
		}
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testMerge4() throws IOException {
		String xmlInput1 = 	"<SYSTEM Name=\"hp_test5 (bug 223)\">" +
			"<SCHEDULABILITY>" +
			"<SCHEDULINGSCENARIO>" +
			"<TASKSCHED TaskRef=\"t1\" Utilization=\"0.22222222222222222\" CDelta=\"-3\" Schedulable=\"true\" ResponseTime=\"2ms\"/>" +
			"<TASKSCHED TaskRef=\"t1\" Utilization=\"0.1\" CDelta=\"-3\" Schedulable=\"true\" ResponseTime=\"2ms\"/>" +
			"</SCHEDULINGSCENARIO>" +
			"</SCHEDULABILITY>" +
			"</SYSTEM>";

		XMI2XMLlTest.loadStringRtd(xmlInput1).getContents().get(0);
	}

	@Test
	public void testMerge5() throws IOException {
		String xmlInput1 = 	"<SYSTEM Name=\"hp_test5 (bug 223)\">" +
			"<SCHEDULABILITY>" +
			"<SCHEDULINGSCENARIO>" +
			"<TASKSCHED TaskRef=\"t1\" Utilization=\"0.22222222222222222\" CDelta=\"-3\" Schedulable=\"true\" ResponseTime=\"2ms\"/>" +
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
		
		EObject root1 = XMI2XMLlTest.loadStringRtd(xmlInput1).getContents().get(0);
		EObject root2 = XMI2XMLlTest.loadStringRtd(xmlInput2).getContents().get(0);
		
		assertTrue(VarTreeUtil.compare(root1, root1).isOK());

		assertTrue(VarTreeUtil.compare(root2, root2).isOK());
		
		assertFalse(VarTreeUtil.compare(root1, root2).isOK());
		
		{
			EObject root1_bis = VarTreeUtil.copy(root1);
			VarTreeUtil.merge(root1_bis, root2, "/", false);
		}
		{
			EObject root2_bis = VarTreeUtil.copy(root2);
			VarTreeUtil.merge(root2_bis, root1, "/", false);
		}
	}


	/**
	 * Check a merged tree against its "parents"
	 * @throws Throwable 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void checkTrees(EObject dest, EObject[] sources, boolean multiValue) throws Throwable {
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
					assertEquals(0, el2[h].size());
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
				EList<EObject> el1 = (EList<EObject>) dest.eGet(ref1);

				LinkedList<EObject>[] el2 = new LinkedList[sources.length];
				for (int h = 0; h < sources.length; h++) {
					el2[h] = new LinkedList((EList<EObject>) sources[h].eGet(ref1));
				}

				for (int j = 0; j < el1.size(); j++) {
					EObject o1 = el1.get(j);
					EObject[] next = remove(o1, el2, multiValue);

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
					assertEquals(0, el2[h].size());
				}

			} else {
				EObject o1 = (EObject) dest.eGet(ref1);

				ArrayList<EObject> next = new ArrayList<EObject>();
				for (int h = 0; h < sources.length; h++) {
					EObject t = (EObject) sources[h].eGet(ref1);
					if (t != null) {
						next.add(t);
					}
				}
				
				if (o1 == null) {
					assertEquals(0, next.size());
				} else {
	
					assertTrue(next.size() > 0);
					if (next.size() == 1) {
						compare(o1, (EObject) next.get(0));
					} else {
						checkTrees(o1, (EObject[]) next
								.toArray(new EObject[0]), multiValue);
					}
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
	 * Check that the given EObject appears at least in one parent list
	 */
	private EObject[] remove(EObject val, LinkedList<EObject>[] parents, boolean multiValues) {
		ArrayList<EObject> answer = new ArrayList<EObject>();

		String curID = VarTreeIdHandler.getId(val);

		for (int i = 0; i < parents.length; i++) {
			Iterator<EObject> iter = parents[i].iterator();

			boolean go = false;
			while (!go && iter.hasNext()) {
				EObject v = iter.next();

				String sourceID = VarTreeIdHandler.getId(v);
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

		return (EObject[]) answer.toArray(new EObject[0]);
	}

	/**
	 * @return
	 * @throws IOException 
	 */
	protected EObject fill() throws IOException {
		return (EObject) fillFiller(true).getLastRoot();
	}
	
	protected FillVtUtil fillFiller(boolean enableProperties) throws IOException {
		return fillFiller(1, enableProperties);
	}
	
	protected FillVtUtil fillFiller(int startingValue, boolean enableProperties) throws IOException {
		FillVtUtil filler = new FillVtUtil(VarTreeUtil.newVarTree(), createResource());
		filler.setEnableProperties(enableProperties);
		filler.setNextID(startingValue);
		EObject root = VarTreeUtil.newVarTreeRoot(filler.getEditingDomain());
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