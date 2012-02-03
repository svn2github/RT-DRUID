/*
 * Created on 6-giu-2004
 *
 * $Id: XMI2XMLlTest.java,v 1.2 2006/08/08 07:13:08 durin Exp $
 */
package com.eu.evidence.rtdruid.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;

import com.eu.evidence.rtdruid.tests.vartree.data.FillVtUtil;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.VarTreeUtil;
import com.eu.evidence.rtdruid.vartree.Vt2StringUtilities;
import com.eu.evidence.rtdruid.vartree.data.SchedulingScenario;
import com.eu.evidence.rtdruid.vartree.data.TaskSched;


/**
 * @author Nicola Serreli
 * 
 * Tests about load and store with
 * {@link com.eu.evidence.rtdruid.internal.vartree.data.init.MyXMIReaderImpl MyXMIReaderImpl}.
 */
public class XMI2XMLlTest {

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
		
		com.eu.evidence.rtdruid.vartree.data.System root = (com.eu.evidence.rtdruid.vartree.data.System) res.getContents().get(0);
		assertEquals(root.getSchedulability().getSchedulingScenarioList().size(), 1);
		SchedulingScenario sScen = (SchedulingScenario) root.getSchedulability().getSchedulingScenarioList().get(0);
		assertEquals(sScen.getTaskSchedList().size(), 2);

		{
			TaskSched ts = (TaskSched) sScen.getTaskSchedList().get(0);
			assertTrue("t1".equals(ts.getObjectID())); 
			assertTrue("true".equals("" + ts.getSchedulable())); 
			assertTrue("0.2222222222222222".equals("" + ts.getUtilization()));
			System.out.println("cdelta " +ts.getCDelta());
			assertTrue("-3.0".equals(""+ts.getCDelta()));
		}
		{	
			TaskSched ts = (TaskSched) sScen.getTaskSchedList().get(1);
			assertTrue("t2".equals(ts.getObjectID())); 
			assertTrue("true".equals("" + ts.getSchedulable())); 
			assertTrue("2.0".equals("" + ts.getUtilization()));
			assertTrue("-3.0".equals(""+ts.getCDelta()));
		}
	}
	
	@Test
	public void testLoadBis() throws IOException {
		String xmlInput1 = 	"<SYSTEM Name=\"hp_test5 (bug 223)\">" +
			"<SCHEDULABILITY>" +
			"<SCHEDULINGSCENARIO>" +
			"<TASKSCHED TaskRef=\"t1\" Utilization=\"0.2\" Schedulable=\"true\"/>" +
			"<TASKSCHED TaskRef=\"t1\" Utilization=\"2\" CDelta=\"-3\"/>" +
			"</SCHEDULINGSCENARIO>" +
			"</SCHEDULABILITY>" +
			"</SYSTEM>";
		
		Resource res = loadStringRtd(xmlInput1);
		
		com.eu.evidence.rtdruid.vartree.data.System root = (com.eu.evidence.rtdruid.vartree.data.System) res.getContents().get(0);
		assertEquals(root.getSchedulability().getSchedulingScenarioList().size(), 1);
		SchedulingScenario sScen = (SchedulingScenario) root.getSchedulability().getSchedulingScenarioList().get(0);
		assertEquals(sScen.getTaskSchedList().size(), 2);

		{
			TaskSched ts = (TaskSched) sScen.getTaskSchedList().get(0);
			assertTrue("t1".equals(ts.getObjectID())); 
			assertTrue("true".equals("" + ts.getSchedulable())); 
			assertTrue("0.2".equals("" + ts.getUtilization()));
			assertNull(ts.getCDelta());
		}
		{
			TaskSched ts = (TaskSched) sScen.getTaskSchedList().get(1);
			assertTrue("t1".equals(ts.getObjectID())); 
			System.out.println("sched " +ts.getSchedulable());
			assertNull(ts.getSchedulable()); 
			assertTrue("2.0".equals("" + ts.getUtilization()));
			assertTrue("-3.0".equals(""+ts.getCDelta()));
		}
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