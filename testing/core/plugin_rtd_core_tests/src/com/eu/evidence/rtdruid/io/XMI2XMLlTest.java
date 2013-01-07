/*
 * Created on 6-giu-2004
 *
 * $Id: XMI2XMLlTest.java,v 1.2 2006/08/08 07:13:08 durin Exp $
 */
package com.eu.evidence.rtdruid.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Ignore;
import org.junit.Test;

import com.eu.evidence.rtdruid.tests.RtdAssert;
import com.eu.evidence.rtdruid.tests.vartree.data.FillVtUtil;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.VarTreeIdHandler;
import com.eu.evidence.rtdruid.vartree.VarTreeUtil;
import com.eu.evidence.rtdruid.vartree.Vt2StringUtilities;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;


/**
 * @author Nicola Serreli
 * 
 * Tests about load and store with
 * {@link com.eu.evidence.rtdruid.internal.vartree.data.init.MyXMIReaderImpl MyXMIReaderImpl}.
 */
public class XMI2XMLlTest {
	
	private final static String ID_SYSTEM = DataPackage.Literals.SYSTEM.getName();
	private final static String ID_SCHEDULING = DataPackage.Literals.SYSTEM__SCHEDULABILITY.getName();
	private final static String ID_SCHEDULING_SCENARIO = DataPackage.Literals.SCHEDULABILITY__SCHEDULING_SCENARIO_LIST.getName();
	private final static String ID_SCENARIO_TASK_LIST = DataPackage.Literals.SCHEDULING_SCENARIO__TASK_SCHED_LIST.getName();
	private final static String ID_TASK_SCHED_SCHEDULABLE = DataPackage.Literals.TASK_SCHED__SCHEDULABLE.getName();
	private final static String ID_TASK_SCHED_UTILIZATION = DataPackage.Literals.TASK_SCHED__UTILIZATION.getName();
	private final static String ID_TASK_SCHED_CDELTA = DataPackage.Literals.TASK_SCHED__CDELTA.getName();

	public final static String ERTD_EXAMPLE_STR = loadErtdExampleTxt().trim();
	public final static String RTD_EXAMPLE_STR = loadRtdExampleTxt().trim();
	
	
	@Test
	public void testLoadErtdExamples() throws InterruptedException, IOException {
		
		IVTResource first = (IVTResource) loadStringErtd(ERTD_EXAMPLE_STR);
		first.setURI(URI.createFileURI("a.ertd"));

		ByteArrayOutputStream output = new ByteArrayOutputStream();
		SaveThread st = new SaveThread(first, output);
		st.start();
		st.join();
		String result = toUnixEol(output.toString()).trim();
//		System.out.println("__"+result+"__\n\n");
//		System.out.println("__"+ERTD_EXAMPLE_STR+"__");
//		int line = 1;
//		char pos = 1;
//		assertEquals(result.length(), ERTD_EXAMPLE_STR.length());
//		for (int i=0; i<result.length(); i++) {
//			char c1 = result.charAt(i);
//			char c2 = ERTD_EXAMPLE_STR.charAt(i);
//			
//			assertEquals("Line " + line + ", pos " + pos, c1, c2);
//			
//			if (c1 == '\n') {
//				line ++;
//				pos = 1;
//			} else {
//				pos ++;
//			}
//		}
		assertTrue(ERTD_EXAMPLE_STR.equals(result));
	}

	@Test
	public void testLoadRtdExamples() throws InterruptedException, IOException {
		
		IVTResource first = (IVTResource) loadStringRtd(RTD_EXAMPLE_STR);
		first.setURI(URI.createFileURI("a.rtd"));

		ByteArrayOutputStream output = new ByteArrayOutputStream();

		SaveThread st = new SaveThread(first, output);
		st.start();

		st.join();
		String result = toUnixEol(output.toString()).trim();
//		System.out.println("__"+result+"__\n\n");
//		System.out.println("__"+RTD_EXAMPLE_STR+"__");
//		int line = 1;
//		char pos = 1;
//		assertEquals(result.length(), RTD_EXAMPLE_STR.length());
//		for (int i=0; i<result.length(); i++) {
//			char c1 = result.charAt(i);
//			char c2 = RTD_EXAMPLE_STR.charAt(i);
//			
//			assertEquals("Line " + line + ", pos " + pos, c1, c2);
//			
//			if (c1 == '\n') {
//				line ++;
//				pos = 1;
//			} else {
//				pos ++;
//			}
//		}
		assertTrue(RTD_EXAMPLE_STR.trim().equals(result));
	}

	/**
	 * This class builds a big tree with all nodes (see
	 * {@link Vt2StringUtilities#fill Utility.fill()}), convert it from internal
	 * rappresentation to old (evidence DTD) rappresentation and back to
	 * internal rappresentation, using
	 * {@link com.eu.evidence.rtdruid.internal.vartree.data.init.MyXMIReaderImpl MyXMIReaderImpl}.
	 * @throws Throwable 
	 */
	@Test
	public void testCheck() throws Throwable {
		
		IVTResource tree = prepareXMIReader();
		compare((EObject) tree.getContents().get(0),
				(EObject) tree.getContents().get(0));


	}

	
	/**
	 * This class builds a big tree with all nodes (see
	 * {@link Vt2StringUtilities#fill Utility.fill()}), convert it from internal
	 * rappresentation to old (evidence DTD) rappresentation and back to
	 * internal rappresentation, using
	 * {@link com.eu.evidence.rtdruid.internal.vartree.data.init.MyXMIReaderImpl MyXMIReaderImpl}.
	 * @throws Throwable 
	 */
	@Test
	@Ignore
	public void testXmi2XmlERTD() throws  Throwable {

		
		IVTResource first = prepareXMIReader(); // IOException
		IVTResource second = createResource();
		
		first.setURI(URI.createFileURI("a.ertd"));
		second.setURI(URI.createFileURI("b.ertd"));

		PipedInputStream inPipe = new PipedInputStream();
		PipedOutputStream outPipe = new PipedOutputStream(inPipe); // IOEXception

		SaveThread st = new SaveThread(first, outPipe);
		st.start();
		LoadThread lt = new LoadThread(second, inPipe);
		lt.start();

		st.join(); // InterruptException
		lt.join(); // InterruptedException

		compare((EObject) first.getContents().get(0),
				(EObject) second.getContents().get(0));
		//first.getContents().clear();
		//second.getContents().clear();
	}

	/**
	 * This class builds a big tree with all nodes (see
	 * {@link Vt2StringUtilities#fill Utility.fill()}), convert it from internal
	 * rappresentation to old (evidence DTD) rappresentation and back to
	 * internal rappresentation, using
	 * {@link com.eu.evidence.rtdruid.internal.vartree.data.init.MyXMIReaderImpl MyXMIReaderImpl}.
	 * @throws Throwable 
	 */
	@Test
	@Ignore
	public void testXmi2XmlRTD_using_pipes() throws Throwable {

		IVTResource first = (IVTResource) loadStringErtd(ERTD_EXAMPLE_STR);//prepareXMIReader();
		IVTResource second = createResource();

		first.setURI(URI.createFileURI("a.rtd"));
		second.setURI(URI.createFileURI("b.rtd"));

		PipedInputStream inPipe = new PipedInputStream();
		PipedOutputStream outPipe = new PipedOutputStream(inPipe);

		SaveThread st = new SaveThread(first, outPipe);
		st.start();
		LoadThread lt = new LoadThread(second, inPipe);
		lt.start();

		st.join();
		lt.join();

		compare((EObject) first.getContents().get(0),
				(EObject) second.getContents().get(0));
	}

	/**
	 * This class builds a big tree with all nodes (see
	 * {@link Vt2StringUtilities#fill Utility.fill()}), convert it from internal
	 * rappresentation to old (evidence DTD) rappresentation and back to
	 * internal rappresentation, using
	 * {@link com.eu.evidence.rtdruid.internal.vartree.data.init.MyXMIReaderImpl MyXMIReaderImpl}.
	 * @throws Throwable 
	 */
	@Test
	@Ignore
	public void testXmi2XmlRTD_using_buffers() throws Throwable {
		IVTResource first = (IVTResource) loadStringErtd(ERTD_EXAMPLE_STR); // prepareXMIReader();
		IVTResource second = createResource();

		first.setURI(URI.createFileURI("a.rtd"));
		second.setURI(URI.createFileURI("b.rtd"));

		ByteArrayOutputStream output = new ByteArrayOutputStream();

		SaveThread st = new SaveThread(first, output);
		st.start();

		st.join();
		
		InputStream input = new ByteArrayInputStream(output.toByteArray());
		LoadThread lt = new LoadThread(second, input);
		lt.start();

		lt.join();

		compare((EObject) first.getContents().get(0),
				(EObject) second.getContents().get(0));
	}

	
	

	@Test
	public void testNew() {
	    /*
	     * IMPORTANT If this test fails, ususaly means that some Required file was not found (LAST_DTD, xsl files) 
	     */
    	createResource();
	}

	@Test
	public void testLoad() throws IOException {
		String xmlInput1 = 
			"<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + 
			"<!DOCTYPE SYSTEM SYSTEM \"evidence_0.4.dtd\">" +
			"<SYSTEM xmlns:rtdruid.vartree.data=\"http://rtdruid.vartree.data\"  Name=\"hp_test5 (bug 223)\">" +
			"<SCHEDULABILITY>" +
			"<SCHEDULINGSCENARIO>" +
			"<CPUSCHED CpuRef=\"CPU0.erika\" Utilization=\"1.1484126984126983\" SpeedFactor=\"1.4285714285714286\" Boundary=\"0.7347722898562381\" Schedulable=\"false\"/>" +
			"<TASKSCHED TaskRef=\"t1\" Utilization=\"0.22222222222222222\" CDelta=\"-3\" Schedulable=\"true\" ResponseTime=\"2ms\"/>" +
			"<TASKSCHED TaskRef=\"t2\" Utilization=\"2\" CDelta=\"-3\" Schedulable=\"true\" ResponseTime=\"2ms\"/>" +
			"</SCHEDULINGSCENARIO>" +
			"</SCHEDULABILITY>" +
			"</SYSTEM>";
		
		Resource res = loadStringRtd(xmlInput1);
		
		EObject root = res.getContents().get(0);
		assertEquals(ID_SYSTEM, root.eClass().getName());
		EObject schedulability = (EObject) root.eGet(root.eClass().getEStructuralFeature(ID_SCHEDULING)); 
		assertNotNull(schedulability);
		EList<?> schedulingScenarioList = (EList<?>) schedulability.eGet(schedulability.eClass().getEStructuralFeature(ID_SCHEDULING_SCENARIO)); 
		assertNotNull(schedulingScenarioList);
		assertEquals(1, schedulingScenarioList.size());
		EObject sScen = (EObject) schedulingScenarioList.get(0);
		EList<?> taskSchedList = (EList<?>) sScen.eGet(sScen.eClass().getEStructuralFeature(ID_SCENARIO_TASK_LIST)); 
		assertNotNull(taskSchedList);
		assertEquals(2, taskSchedList.size());

		{
			EObject ts = (EObject) taskSchedList.get(0);
			assertEquals("t1", VarTreeIdHandler.getId(ts)); 
			assertEquals("true", "" +ts.eGet(ts.eClass().getEStructuralFeature(ID_TASK_SCHED_SCHEDULABLE))); 
			assertEquals("0.2222222222222222", "" +ts.eGet(ts.eClass().getEStructuralFeature(ID_TASK_SCHED_UTILIZATION)));
			assertEquals("-3.0", "" +ts.eGet(ts.eClass().getEStructuralFeature(ID_TASK_SCHED_CDELTA)));
		}
		{	
			EObject ts = (EObject) taskSchedList.get(1);
			assertEquals("t2", VarTreeIdHandler.getId(ts)); 
			assertEquals("true", "" +ts.eGet(ts.eClass().getEStructuralFeature(ID_TASK_SCHED_SCHEDULABLE))); 
			assertEquals("2.0", "" +ts.eGet(ts.eClass().getEStructuralFeature(ID_TASK_SCHED_UTILIZATION)));
			assertEquals("-3.0", "" +ts.eGet(ts.eClass().getEStructuralFeature(ID_TASK_SCHED_CDELTA)));
		}
	}
	
	@Test
	public void testLoadBis() throws IOException {
		final String xmlInput1 = 	"<SYSTEM Name=\"hp_test5 (bug 223)\">" +
			"<SCHEDULABILITY>" +
			"<SCHEDULINGSCENARIO>" +
			"<TASKSCHED TaskRef=\"t1\" Utilization=\"0.2\" Schedulable=\"true\"/>" +
			"<TASKSCHED TaskRef=\"t1\" Utilization=\"2\" CDelta=\"-3\"/>" +
			"</SCHEDULINGSCENARIO>" +
			"</SCHEDULABILITY>" +
			"</SYSTEM>";
		new RtdAssert(IllegalArgumentException.class) {
			protected void doCheck() throws Throwable {
				loadStringRtd(xmlInput1);
			};
		};
	}

	
	@Test
	public void test_rtd2xmi() throws IOException {
		IVarTree tree = prepareTree();
		
		String rtd = Vt2StringUtilities.varTreeToStringRtd(tree);
//		{
//			File f = new File("src/"+getClass().getPackage().getName().replace('.', '/') 
//					+ "/xmi2mxl_example.rtd");
//			FileOutputStream fo = new FileOutputStream(f);
//			fo.write(rtd.getBytes());
//			fo.flush();
//			fo.close();
//		}
		IVarTree vt = Vt2StringUtilities.loadString(rtd);
		//String xmi = 
				Vt2StringUtilities.varTreeToStringErtd(vt);
//		{
//			File f = new File("src/"+getClass().getPackage().getName().replace('.', '/') 
//					+ "/xmi2mxl_example.ertd");
//			FileOutputStream fo = new FileOutputStream(f);
//			fo.write(xmi.getBytes());
//			fo.flush();
//			fo.close();
//		}
	}
	
	/**
	 * @throws IOException */
	public static Resource loadStringErtd(String input) throws IOException {
		return Vt2StringUtilities.loadString(input, "ertd").getResourceSet().getResources().get(0);
	}
		
	/**
	 * @throws IOException */
	public static Resource loadStringRtd(String input) throws IOException {
		return Vt2StringUtilities.loadString(input, "rtd").getResourceSet().getResources().get(0);
	}


	private static IVTResource prepareXMIReader() throws IOException {
		FillVtUtil filler = new FillVtUtil(VarTreeUtil.newVarTree(),  null);
		filler.fill(VarTreeUtil.newVarTreeRoot(filler.getEditingDomain()));

		return (IVTResource) filler.getResource();
	}
	
	private static IVarTree prepareTree() throws IOException {
		FillVtUtil filler = new FillVtUtil(VarTreeUtil.newVarTree(), null);
		filler.fill(VarTreeUtil.newVarTreeRoot(filler.getEditingDomain()));

		return (IVarTree) filler.getEditingDomain();
	}


	
	private static IVTResource createResource() {
		return (IVTResource) new RTD_XMI_Factory().createResource();
	}
	
	/**
	 * @param dest
	 * @param root1
	 * @throws Throwable 
	 */
	private boolean compare(EObject dest, EObject root1) throws Throwable {
		IStatus s = VarTreeUtil.compare(dest, root1);
		Throwable t = s.getException();
		if (t == null) {
			return s.isOK();
		}
		throw t;
	}
	

	private class SaveThread extends Thread {

		private IVTResource resource;

		private OutputStream outstream;

		public SaveThread(IVTResource res, OutputStream out) {
			resource = res;
			outstream = out;
		}

		public void run() {
			try {
				resource.save(outstream, null);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					outstream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		protected void finalize() {
			System.err.println("SaveThread eliminato");
		}

	}

	private class LoadThread extends Thread {

		private IVTResource resource;

		private InputStream instream;

		public LoadThread(IVTResource res, InputStream in) {
			resource = res;
			instream = in;
		}

		public void run() {
			try {
				resource.load(instream, null);
			} catch (IOException e) {
				e.printStackTrace();
			}  finally {
				try {
					instream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		protected void finalize() {
			System.err.println("LoadThread eliminato ");
		}

	}
	
	private static String loadErtdExampleTxt() {
		try {
			InputStream input = new BufferedInputStream(XMI2XMLlTest.class.getResourceAsStream("xmi2mxl_example.ertd"));
			StringBuffer buff = new StringBuffer();
			
			for (int c = input.read(); c!= -1; c = input.read()) {
				if (c != '\r') {
					buff.append((char) c);
				}
			}
			return buff.toString();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}		
	}
	private static String loadRtdExampleTxt() {
		try {
			InputStream input = new BufferedInputStream(XMI2XMLlTest.class.getResourceAsStream("xmi2mxl_example.rtd"));
			StringBuffer buff = new StringBuffer();
			
			for (int c = input.read(); c!= -1; c = input.read()) {
				if (c != '\r') {
					buff.append((char) c);
				}
			}
			return buff.toString();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static String toUnixEol(String txt) {
		StringBuffer buff = new StringBuffer(txt.length());
		for (byte c : txt.getBytes()) {
			if (c != '\r') {
				buff.append((char) c);
			}
		}
		return buff.toString();
	}

}