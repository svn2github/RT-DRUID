/*
 * Created on 6-giu-2004
 *
 * $Id: XMI2XMLlTest.java,v 1.2 2006/08/08 07:13:08 durin Exp $
 */
package com.eu.evidence.rtdruid.test.vartree.data;

import java.io.ByteArrayInputStream;
import java.util.HashMap;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.eu.evidence.rtdruid.desk.RTDFactory;
import com.eu.evidence.rtdruid.io.IRTDImporter;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.data.init.IVTResource;
import com.eu.evidence.rtdruid.vartree.data.init.RTD_XMI_Factory;
import com.eu.evidence.rtdruid.vartree.data.init.Vt2StringUtilities;
import com.eu.evidence.rtdruid.vartree.data.init.VtCompare;


/**
 * @author Nicola Serreli
 * 
 * Tests about load and store with
 * {@link com.eu.evidence.rtdruid.internal.vartree.data.init.MyXMIReaderImpl MyXMIReaderImpl}.
 */
public class VTLoadTest extends TestCase {
	
	private IVarTree correct = null;

	public VTLoadTest(String name) {
		super(name);
//		System.err.println("Start free = " + Runtime.getRuntime().freeMemory()
//				+ "\t" + Runtime.getRuntime().totalMemory()
//				+ "\t" + Runtime.getRuntime().maxMemory());
	}

	public static Test suite() {
		TestSuite tests = new TestSuite(VTLoadTest.class);
		//		tests.addTest(new TestSuite(TreeCloneTest.class));
		return tests;
	}
	
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		System.out.println("/*****************************************************\n" +
				           " *  " + this.getClass().getName() + " -> " + getName() + "\n" +
				           " ****************************************************" +
				           "" +
				           "/\n");
		
		correct = (IVarTree) RTDFactory.get(IVarTree.class); //prepare also Data Factory
		
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put(IRTDImporter.OPT_USE_IMPORTER_TYPE, "ertd");
		
		Resource res = (Resource) correct.getResourceSet().getResources().get(0);
		try {
			res.load(new ByteArrayInputStream(ertd_version.getBytes()), map);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
		
	}

	protected void tearDown() throws Exception {
		correct = null;
		super.tearDown();
	}
	
	private final static String ertd_version = 
		"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<rtdruid.vartree.data:System xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:rtdruid.vartree.data=\"http://rtdruid.vartree.data\" Name=\"hp_test5 (bug 223)\">\n" +
		"  <Schedulability>\n" +
		"    <SchedulingScenarioList>\n" +
		"      <CpuSchedList Boundary=\"0.7347722898562381\" CpuRef=\"CPU0.erika\" Schedulable=\"false\" SpeedFactor=\"1.4285714285714286\" Utilization=\"1.1484126984126983\"/>\n" +
		"      <TaskSchedList CDelta=\"-3.0\" ResponseTime=\"2.0ms\" Schedulable=\"true\" TaskRef=\"t1\" Utilization=\"0.2222222222222222\"/>\n" +
		"      <TaskSchedList CDelta=\"-3.0\" ResponseTime=\"2.0ms\" Schedulable=\"true\" TaskRef=\"t2\" Utilization=\"2.0\"/>\n" +
		"    </SchedulingScenarioList>\n" +
		"  </Schedulability>\n" +
		"</rtdruid.vartree.data:System>";
	
	private final static String common = 
		"<SYSTEM xmlns:rtdruid.vartree.data=\"http://rtdruid.vartree.data\"  Name=\"hp_test5 (bug 223)\">" +
		"<SCHEDULABILITY>" +
		"<SCHEDULINGSCENARIO>" +
		"<CPUSCHED CpuRef=\"CPU0.erika\" Utilization=\"1.1484126984126983\" SpeedFactor=\"1.4285714285714286\" Boundary=\"0.7347722898562381\" Schedulable=\"false\"/>" +
		"<TASKSCHED TaskRef=\"t1\" Utilization=\"0.22222222222222222\" CDelta=\"-3\" Schedulable=\"true\" ResponseTime=\"2ms\"/>" +
		"<TASKSCHED TaskRef=\"t2\" Utilization=\"2\" CDelta=\"-3\" Schedulable=\"true\" ResponseTime=\"2ms\"/>" +
		"</SCHEDULINGSCENARIO>" +
		"</SCHEDULABILITY>" +
		"</SYSTEM>";
	
	private final static String xmlInput1 = 
		"<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + 
		"<!DOCTYPE SYSTEM SYSTEM \"evidence_0.2.dtd\">" +
		common;
	
	private final static String xmlInput2 = 
		"<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + 
		common;
	
	private final static String xmlInput3 = 
		"<!DOCTYPE SYSTEM SYSTEM \"evidence_0.2.dtd\">" +
		common;
	
	private final static String xmlInput4 = 
		common;
	
	private final static String xmlInput5 = 
		"<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + 
		"<!DOCTYPE SYSTEM SYSTEM \"evidence_0.4.dtd\">" +
		common;

	public void testNew() {
	    /*
	     * IMPORTANT If this test fails, ususaly means that some Required file was not found (LAST_DTD, xsl files) 
	     */
	    try {
	    	//IVTResource reader = 
	    		createResource();
	    } catch (NoClassDefFoundError e) {
	        e.printStackTrace();
	        assertTrue(false);
	    } catch (Error e) {
	        e.printStackTrace();
	        assertTrue(false);
	    }
		
	    try {
	    	//IVarTree vt = (IVarTree) 
	    	RTDFactory.get(IVarTree.class);
	    } catch (NoClassDefFoundError e) {
	        e.printStackTrace();
	        assertTrue(false);
	    } catch (Error e) {
	        e.printStackTrace();
	        assertTrue(false);
	    }
	}

	public void testLoad_utility_1() {
		
		IVarTree vt = 
			Vt2StringUtilities.loadString(xmlInput1);
//		System.out.println(xmlInput1 + "\n\n" + Utility.varTreeToString(vt));
		String t = (new VtCompare(vt, correct)).getText(); assertTrue(t, t== null);
	}

	
	public void testLoad_null_null_1() {
		loadString(xmlInput1, null, null, false);
	}

	public void testLoad_null_rtd_1() {
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put(IRTDImporter.OPT_USE_IMPORTER_TYPE, "rtd");
		
		loadString(xmlInput1, null, map, true);
	}
	
	public void testLoad_rtd_rtd_1() {
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put(IRTDImporter.OPT_USE_IMPORTER_TYPE, "rtd");
		
		loadString(xmlInput1, "file.rtd", map, true);
	}
	
	public void testLoad_rtd_null_1() {
		loadString(xmlInput1, "file.rtd", null, true);
	}
	
	
	
	
	public void testLoad_utility_2() {
		
		IVarTree vt = 
			Vt2StringUtilities.loadString(xmlInput2);
//		System.out.println(Utility.varTreeToString(vt));
		String t = (new VtCompare(vt, correct)).getText(); assertTrue(t, t== null);
	}

	
	public void testLoad_null_null_2() {
		loadString(xmlInput2, null, null, false);
	}

	public void testLoad_null_rtd_2() {
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put(IRTDImporter.OPT_USE_IMPORTER_TYPE, "rtd");
		
		loadString(xmlInput2, null, map, true);
	}
	
	public void testLoad_rtd_rtd_2() {
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put(IRTDImporter.OPT_USE_IMPORTER_TYPE, "rtd");
		
		loadString(xmlInput2, "file.rtd", map, true);
	}
	
	public void testLoad_rtd_null_2() {
		loadString(xmlInput2, "file.rtd", null, true);
	}
	
	
	
	
	
	public void testLoad_utility_3() {
		
		IVarTree vt = 
			Vt2StringUtilities.loadString(xmlInput3);
//		System.out.println(Utility.varTreeToString(vt));
		String t = (new VtCompare(vt, correct)).getText(); assertTrue(t, t== null);
	}

	
	public void testLoad_null_null_3() {
		loadString(xmlInput3, null, null, false);
	}

	public void testLoad_null_rtd_3() {
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put(IRTDImporter.OPT_USE_IMPORTER_TYPE, "rtd");
		
		loadString(xmlInput3, null, map, true);
	}
	
	public void testLoad_rtd_rtd_3() {
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put(IRTDImporter.OPT_USE_IMPORTER_TYPE, "rtd");
		
		loadString(xmlInput3, "file.rtd", map, true);
	}
	
	public void testLoad_rtd_null_3() {
		loadString(xmlInput3, "file.rtd", null, true);
	}	
	
	
	
	public void testLoad_utility_4() {
		IVarTree vt = 
			Vt2StringUtilities.loadString(xmlInput4);
//		System.out.println(Utility.varTreeToString(vt));
		String t = (new VtCompare(vt, correct)).getText(); assertTrue(t, t== null);
	}

	
	public void testLoad_null_null_4() {
		loadString(xmlInput4, null, null, false);
	}

	public void testLoad_null_rtd_4() {
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put(IRTDImporter.OPT_USE_IMPORTER_TYPE, "rtd");
		
		loadString(xmlInput4, null, map, true);
	}
	
	public void testLoad_rtd_rtd_4() {
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put(IRTDImporter.OPT_USE_IMPORTER_TYPE, "rtd");
		
		loadString(xmlInput4, "file.rtd", map, true);
	}
	
	public void testLoad_rtd_null_4() {
		loadString(xmlInput4, "file.rtd", null, true);
	}
	
	
	
	public void testLoad_utility_5() {
		
		IVarTree vt = 
			Vt2StringUtilities.loadString(xmlInput5);
//		System.out.println(xmlInput1 + "\n\n" + Utility.varTreeToString(vt));
		String t = (new VtCompare(vt, correct)).getText(); assertTrue(t, t== null);
	}

	
	public void testLoad_null_null_5() {
		loadString(xmlInput5, null, null, false);
	}

	public void testLoad_null_rtd_5() {
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put(IRTDImporter.OPT_USE_IMPORTER_TYPE, "rtd");
		
		loadString(xmlInput5, null, map, true);
	}
	
	public void testLoad_rtd_rtd_5() {
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put(IRTDImporter.OPT_USE_IMPORTER_TYPE, "rtd");
		
		loadString(xmlInput5, "file.rtd", map, true);
	}
	
	public void testLoad_rtd_null_5() {
		loadString(xmlInput5, "file.rtd", null, true);
	}
	
	/***/
	protected Resource loadString(String input, String path, HashMap<Object, Object> options, boolean expectedFail) {
		if (options == null) {
			options = new HashMap<Object, Object>();
		}
		if (path == null) {
			path = "";
		}
		
		Resource res = (new RTD_XMI_Factory()).createResource(URI.createFileURI(path));
		try {
			res.load(new ByteArrayInputStream(input.getBytes()), options);
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}

		
		boolean contains_res = res.getContents().size() > 0;
		assertTrue(expectedFail == contains_res);
		if (contains_res) {
			boolean contains_eobjects = res.getContents().get(0).eContents().size() > 0;
			assertTrue(expectedFail == contains_eobjects);
			
			if (contains_eobjects) {
				EObject croot = correct.getResourceSet().getResources().get(0).getContents().get(0);
				EObject testroot = res.getContents().get(0);
				String t = (new VtCompare(testroot, croot)).getText(); assertTrue(t, t== null);
			}
		}
		
		return res;
	}

	
	protected IVTResource createResource() {
		return (IVTResource) new RTD_XMI_Factory().createResource();
	}
}