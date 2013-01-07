/*
 * Created on 6-giu-2004
 *
 * $Id: XMI2XMLlTest.java,v 1.2 2006/08/08 07:13:08 durin Exp $
 */
package com.eu.evidence.rtdruid.test.vartree.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Before;
import org.junit.Test;

import com.eu.evidence.rtdruid.io.IRTDImporter;
import com.eu.evidence.rtdruid.io.IVTResource;
import com.eu.evidence.rtdruid.io.RTD_XMI_Factory;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.VarTreeUtil;
import com.eu.evidence.rtdruid.vartree.Vt2StringUtilities;


/**
 * @author Nicola Serreli
 * 
 * Tests about load and store with
 * {@link com.eu.evidence.rtdruid.internal.vartree.data.init.MyXMIReaderImpl MyXMIReaderImpl}.
 */
public class VTLoadTest {
	
	private IVarTree correct = null;

	
	
	@Before
	public void setUp() throws Exception {
		
		correct = VarTreeUtil.newVarTree(); //prepare also Data Factory
		
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put(IRTDImporter.OPT_USE_IMPORTER_TYPE, "ertd");
		
		Resource res = (Resource) correct.getResourceSet().getResources().get(0);
		res.load(new ByteArrayInputStream(ertd_version.getBytes()), map);
	}
	
	private final static String ertd_version = 
		"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<com.eu.evidence.rtdruid.data:System xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:com.eu.evidence.rtdruid.data=\"http://www.evidence.eu.com/rtdruid/data\" Name=\"hp_test5 (bug 223)\">\n" +
		"  <Schedulability>\n" +
		"    <SchedulingScenarioList>\n" +
		"      <CpuSchedList Boundary=\"0.7347722898562381\" CpuRef=\"CPU0.erika\" Schedulable=\"false\" SpeedFactor=\"1.4285714285714286\" Utilization=\"1.1484126984126983\"/>\n" +
		"      <TaskSchedList CDelta=\"-3.0\" ResponseTime=\"2.0ms\" Schedulable=\"true\" TaskRef=\"t1\" Utilization=\"0.2222222222222222\"/>\n" +
		"      <TaskSchedList CDelta=\"-3.0\" ResponseTime=\"2.0ms\" Schedulable=\"true\" TaskRef=\"t2\" Utilization=\"2.0\"/>\n" +
		"    </SchedulingScenarioList>\n" +
		"  </Schedulability>\n" +
		"</com.eu.evidence.rtdruid.data:System>";
	
	private final static String common = 
		"<SYSTEM xmlns:com.eu.evidence.rtdruid.data=\"http://www.evidence.eu.com/rtdruid/data\"  Name=\"hp_test5 (bug 223)\">" +
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
		"<!DOCTYPE SYSTEM SYSTEM \"evidence_0.4.dtd\">" +
		common;
	
	private final static String xmlInput2 = 
		"<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + 
		common;
	
	private final static String xmlInput3 = 
		"<!DOCTYPE SYSTEM SYSTEM \"evidence_0.4.dtd\">" +
		common;
	
	private final static String xmlInput4 = 
		common;
	
	private final static String xmlInput5 = 
		"<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + 
		"<!DOCTYPE SYSTEM SYSTEM \"evidence_0.4.dtd\">" +
		common;

	@Test
	public void testNewResource() {
	    /*
	     * IMPORTANT If this test fails, ususaly means that some Required file was not found (LAST_DTD, xsl files) 
	     */
   		createResource();
	}

	@Test
	public void testNewVarTree() {
	    /*
	     * IMPORTANT If this test fails, ususaly means that some Required file was not found (LAST_DTD, xsl files) 
	     */
    	VarTreeUtil.newVarTree();
	}

	@Test
	public void testLoad_utility_1() throws IOException {
		
		IVarTree vt = 
			Vt2StringUtilities.loadString(xmlInput1);
//		System.out.println(xmlInput1 + "\n\n" + Utility.varTreeToString(vt));
		String t = VarTreeUtil.compare(vt, correct).getMessage(); assertNull(t, t);
	}

	
	@Test(expected=IOException.class)
	public void testLoad_null_null_1() throws IOException {
		loadString(xmlInput1, null, null, false);
	}
	@Test(expected=IOException.class)
	public void testLoad_null_ertd_1() throws IOException {
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put(IRTDImporter.OPT_USE_IMPORTER_TYPE, "ertd");
		
		loadString(xmlInput1, null, map, true);
	}
	@Test
	public void testLoad_null_null_ertd_1() throws IOException {
		String msg_null = null;
		try {
			loadString(xmlInput1, null, null, false);
		} catch (IOException e) {
			msg_null = e.getMessage();
		}

		String msg_ertd = null;
		try {
			HashMap<Object, Object> map = new HashMap<Object, Object>();
			map.put(IRTDImporter.OPT_USE_IMPORTER_TYPE, "ertd");
			
			loadString(xmlInput1, null, map, false);
		} catch (IOException e) {
			msg_ertd = e.getMessage();
		}

		assertNotNull(msg_null);
		assertNotNull(msg_ertd);
		assertTrue(msg_null.equals(msg_ertd));
	}

	@Test
	public void testLoad_null_rtd_1() throws IOException {
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put(IRTDImporter.OPT_USE_IMPORTER_TYPE, "rtd");
		
		loadString(xmlInput1, null, map, true);
	}
	
	@Test
	public void testLoad_rtd_rtd_1() throws IOException {
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put(IRTDImporter.OPT_USE_IMPORTER_TYPE, "rtd");
		
		loadString(xmlInput1, "file.rtd", map, true);
	}
	
	@Test
	public void testLoad_rtd_null_1() throws IOException {
		loadString(xmlInput1, "file.rtd", null, true);
	}
	
	
	
	
	@Test
	public void testLoad_utility_2() throws IOException {
		
		IVarTree vt = 
			Vt2StringUtilities.loadString(xmlInput2);
//		System.out.println(Utility.varTreeToString(vt));
		String t = VarTreeUtil.compare(vt, correct).getMessage(); assertNull(t, t);
	}

	
	@Test(expected=IOException.class)
	public void testLoad_null_null_2() throws IOException {
		loadString(xmlInput2, null, null, false);
	}
	@Test(expected=IOException.class)
	public void testLoad_null_ertd_2() throws IOException {
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put(IRTDImporter.OPT_USE_IMPORTER_TYPE, "ertd");
		
		loadString(xmlInput2, null, map, true);
	}
	@Test
	public void testLoad_null_null_ertd_2() throws IOException {
		String msg_null = null;
		try {
			loadString(xmlInput2, null, null, false);
		} catch (IOException e) {
			msg_null = e.getMessage();
		}

		String msg_ertd = null;
		try {
			HashMap<Object, Object> map = new HashMap<Object, Object>();
			map.put(IRTDImporter.OPT_USE_IMPORTER_TYPE, "ertd");
			
			loadString(xmlInput2, null, map, false);
		} catch (IOException e) {
			msg_ertd = e.getMessage();
		}

		assertNotNull(msg_null);
		assertNotNull(msg_ertd);
		assertTrue(msg_null.equals(msg_ertd));
	}

	@Test
	public void testLoad_null_rtd_2() throws IOException {
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put(IRTDImporter.OPT_USE_IMPORTER_TYPE, "rtd");
		
		loadString(xmlInput2, null, map, true);
	}
	
	@Test
	public void testLoad_rtd_rtd_2() throws IOException {
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put(IRTDImporter.OPT_USE_IMPORTER_TYPE, "rtd");
		
		loadString(xmlInput2, "file.rtd", map, true);
	}
	
	@Test
	public void testLoad_rtd_null_2() throws IOException {
		loadString(xmlInput2, "file.rtd", null, true);
	}
	
	
	
	
	
	@Test
	public void testLoad_utility_3() throws IOException {
		
		IVarTree vt = 
			Vt2StringUtilities.loadString(xmlInput3);
//		System.out.println(Utility.varTreeToString(vt));
		String t = VarTreeUtil.compare(vt, correct).getMessage(); assertNull(t, t);
	}

	
	@Test(expected=IOException.class)
	public void testLoad_null_null_3() throws IOException {
		loadString(xmlInput3, null, null, false);
	}
	@Test(expected=IOException.class)
	public void testLoad_null_ertd_3() throws IOException {
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put(IRTDImporter.OPT_USE_IMPORTER_TYPE, "ertd");
		
		loadString(xmlInput3, null, map, true);
	}
	@Test
	public void testLoad_null_null_ertd_3() throws IOException {
		String msg_null = null;
		try {
			loadString(xmlInput3, null, null, false);
		} catch (IOException e) {
			msg_null = e.getMessage();
		}

		String msg_ertd = null;
		try {
			HashMap<Object, Object> map = new HashMap<Object, Object>();
			map.put(IRTDImporter.OPT_USE_IMPORTER_TYPE, "ertd");
			
			loadString(xmlInput3, null, map, false);
		} catch (IOException e) {
			msg_ertd = e.getMessage();
		}

		assertNotNull(msg_null);
		assertNotNull(msg_ertd);
		assertTrue(msg_null.equals(msg_ertd));
	}

	@Test
	public void testLoad_null_rtd_3() throws IOException {
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put(IRTDImporter.OPT_USE_IMPORTER_TYPE, "rtd");
		
		loadString(xmlInput3, null, map, true);
	}
	
	@Test
	public void testLoad_rtd_rtd_3() throws IOException {
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put(IRTDImporter.OPT_USE_IMPORTER_TYPE, "rtd");
		
		loadString(xmlInput3, "file.rtd", map, true);
	}
	
	@Test
	public void testLoad_rtd_null_3() throws IOException {
		loadString(xmlInput3, "file.rtd", null, true);
	}	
	
	
	
	@Test
	public void testLoad_utility_4() throws IOException {
		IVarTree vt = 
			Vt2StringUtilities.loadString(xmlInput4);
//		System.out.println(Utility.varTreeToString(vt));
		String t = VarTreeUtil.compare(vt, correct).getMessage(); assertNull(t, t);
	}
	
	@Test(expected=IOException.class)
	public void testLoad_null_null_4() throws IOException {
		loadString(xmlInput4, null, null, false);
	}
	@Test(expected=IOException.class)
	public void testLoad_null_ertd_4() throws IOException {
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put(IRTDImporter.OPT_USE_IMPORTER_TYPE, "ertd");
		
		loadString(xmlInput4, null, map, true);
	}
	@Test
	public void testLoad_null_null_ertd_4() throws IOException {
		String msg_null = null;
		try {
			loadString(xmlInput4, null, null, false);
		} catch (IOException e) {
			msg_null = e.getMessage();
		}

		String msg_ertd = null;
		try {
			HashMap<Object, Object> map = new HashMap<Object, Object>();
			map.put(IRTDImporter.OPT_USE_IMPORTER_TYPE, "ertd");
			
			loadString(xmlInput4, null, map, false);
		} catch (IOException e) {
			msg_ertd = e.getMessage();
		}

		assertNotNull(msg_null);
		assertNotNull(msg_ertd);
		assertTrue(msg_null.equals(msg_ertd));
	}

	@Test
	public void testLoad_null_rtd_4() throws IOException {
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put(IRTDImporter.OPT_USE_IMPORTER_TYPE, "rtd");
		
		loadString(xmlInput4, null, map, true);
	}
	
	@Test
	public void testLoad_rtd_rtd_4() throws IOException {
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put(IRTDImporter.OPT_USE_IMPORTER_TYPE, "rtd");
		
		loadString(xmlInput4, "file.rtd", map, true);
	}
	
	@Test
	public void testLoad_rtd_null_4() throws IOException {
		loadString(xmlInput4, "file.rtd", null, true);
	}
	
	
	
	@Test
	public void testLoad_utility_5() throws IOException {
		
		IVarTree vt = 
			Vt2StringUtilities.loadString(xmlInput5);
//		System.out.println(xmlInput1 + "\n\n" + Utility.varTreeToString(vt));
		String t = VarTreeUtil.compare(vt, correct).getMessage(); assertNull(t, t);
	}

	
	@Test(expected=IOException.class)
	public void testLoad_null_null_5() throws IOException {
		loadString(xmlInput5, null, null, false);
	}
	@Test(expected=IOException.class)
	public void testLoad_null_ertd_5() throws IOException {
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put(IRTDImporter.OPT_USE_IMPORTER_TYPE, "ertd");
		
		loadString(xmlInput5, null, map, true);
	}
	@Test
	public void testLoad_null_null_ertd_5() throws IOException {
		String msg_null = null;
		try {
			loadString(xmlInput5, null, null, false);
		} catch (IOException e) {
			msg_null = e.getMessage();
		}

		String msg_ertd = null;
		try {
			HashMap<Object, Object> map = new HashMap<Object, Object>();
			map.put(IRTDImporter.OPT_USE_IMPORTER_TYPE, "ertd");
			
			loadString(xmlInput5, null, map, false);
		} catch (IOException e) {
			msg_ertd = e.getMessage();
		}

		assertNotNull(msg_null);
		assertNotNull(msg_ertd);
		assertTrue(msg_null.equals(msg_ertd));
	}

	@Test
	public void testLoad_null_rtd_5() throws IOException {
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put(IRTDImporter.OPT_USE_IMPORTER_TYPE, "rtd");
		
		loadString(xmlInput5, null, map, true);
	}
	
	@Test
	public void testLoad_rtd_rtd_5() throws IOException {
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put(IRTDImporter.OPT_USE_IMPORTER_TYPE, "rtd");
		
		loadString(xmlInput5, "file.rtd", map, true);
	}
	
	@Test
	public void testLoad_rtd_null_5() throws IOException {
		loadString(xmlInput5, "file.rtd", null, true);
	}
	
	/**
	 * @throws IOException */
	protected Resource loadString(String input, String path, HashMap<Object, Object> options, boolean expectedFail) throws IOException {
		if (options == null) {
			options = new HashMap<Object, Object>();
		}
		if (path == null) {
			path = "";
		}
		
		Resource res = (new RTD_XMI_Factory()).createResource(URI.createFileURI(path));
		res.load(new ByteArrayInputStream(input.getBytes()), options);

		
		boolean contains_res = res.getContents().size() > 0;
		assertEquals(expectedFail, contains_res);
		if (contains_res) {
			boolean contains_eobjects = res.getContents().get(0).eContents().size() > 0;
			assertEquals(expectedFail, contains_eobjects);
			
			if (contains_eobjects) {
				EObject croot = correct.getResourceSet().getResources().get(0).getContents().get(0);
				EObject testroot = res.getContents().get(0);

				String a = Vt2StringUtilities.varTreeToString(croot, "ertd");
				String b = Vt2StringUtilities.varTreeToString(testroot, "ertd");
				assertEquals(a, b);

//				String t = VarTreeUtil.compare(testroot, croot).getMessage(); assertNull(t, t);
			}
		}
		
		return res;
	}

	
	protected IVTResource createResource() {
		return (IVTResource) new RTD_XMI_Factory().createResource();
	}
}