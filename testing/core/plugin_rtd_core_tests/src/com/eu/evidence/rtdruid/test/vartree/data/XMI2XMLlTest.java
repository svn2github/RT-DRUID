/*
 * Created on 6-giu-2004
 *
 * $Id: XMI2XMLlTest.java,v 1.2 2006/08/08 07:13:08 durin Exp $
 */
package com.eu.evidence.rtdruid.test.vartree.data;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.HashMap;

import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

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
public class XMI2XMLlTest extends TestCase {

	public XMI2XMLlTest(String name) {
		super(name);
//		System.err.println("Start free = " + Runtime.getRuntime().freeMemory()
//				+ "\t" + Runtime.getRuntime().totalMemory()
//				+ "\t" + Runtime.getRuntime().maxMemory());
	}

	public static Test suite() {
		TestSuite tests = new TestSuite(XMI2XMLlTest.class);
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
		
	}

	protected void tearDown() throws Exception {

//		System.gc();
//		System.runFinalization();
//		System.err.println("Down  free = " + Runtime.getRuntime().freeMemory()
//				+ "\t" + Runtime.getRuntime().totalMemory()
//				+ "\t" + Runtime.getRuntime().maxMemory());
		super.tearDown();
	}
	
	
	/**
	 * This class builds a big tree with all nodes (see
	 * {@link Vt2StringUtilities#fill Utility.fill()}), convert it from internal
	 * rappresentation to old (evidence DTD) rappresentation and back to
	 * internal rappresentation, using
	 * {@link com.eu.evidence.rtdruid.internal.vartree.data.init.MyXMIReaderImpl MyXMIReaderImpl}.
	 */
	public void testCheck() {
		
		IVTResource tree = prepareXMIReader();
		String t = (new VtCompare((EObject) tree.getContents().get(0),
				(EObject) tree.getContents().get(0))).getText(); assertTrue(t, t== null);


	}

	
	/**
	 * This class builds a big tree with all nodes (see
	 * {@link Vt2StringUtilities#fill Utility.fill()}), convert it from internal
	 * rappresentation to old (evidence DTD) rappresentation and back to
	 * internal rappresentation, using
	 * {@link com.eu.evidence.rtdruid.internal.vartree.data.init.MyXMIReaderImpl MyXMIReaderImpl}.
	 */
	public void testXmi2XmlERTD() {

		
		IVTResource first = prepareXMIReader();
		IVTResource second = createResource();
		
		first.setURI(URI.createFileURI("a.ertd"));
		second.setURI(URI.createFileURI("b.ertd"));

		try {
			PipedInputStream inPipe = new PipedInputStream();
			PipedOutputStream outPipe = new PipedOutputStream(inPipe);

			SaveThread st = new SaveThread(first, outPipe);
			st.start();
			LoadThread lt = new LoadThread(second, inPipe);
			lt.start();

			try {
				st.join();
				lt.join();
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		String t = (new VtCompare((EObject) first.getContents().get(0),
				(EObject) second.getContents().get(0))).getText(); assertTrue(t, t== null);
		//first.getContents().clear();
		//second.getContents().clear();
	}

	/**
	 * This class builds a big tree with all nodes (see
	 * {@link Vt2StringUtilities#fill Utility.fill()}), convert it from internal
	 * rappresentation to old (evidence DTD) rappresentation and back to
	 * internal rappresentation, using
	 * {@link com.eu.evidence.rtdruid.internal.vartree.data.init.MyXMIReaderImpl MyXMIReaderImpl}.
	 */
	public void testXmi2XmlRTD() {

		IVTResource first = prepareXMIReader();
		IVTResource second = createResource();

		first.setURI(URI.createFileURI("a.rtd"));
		second.setURI(URI.createFileURI("b.rtd"));

		try {
			PipedInputStream inPipe = new PipedInputStream();
			PipedOutputStream outPipe = new PipedOutputStream(inPipe);

			SaveThread st = new SaveThread(first, outPipe);
			st.start();
			LoadThread lt = new LoadThread(second, inPipe);
			lt.start();

			try {
				st.join();
				lt.join();
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		String t = (new VtCompare((EObject) first.getContents().get(0),
				(EObject) second.getContents().get(0))).getText(); assertTrue(t, t== null);
		//first.getContents().clear();
		//second.getContents().clear();
	}

	/**
	 * This class builds a big tree with all nodes (see
	 * {@link Vt2StringUtilities#fill Utility.fill()}), convert it from internal
	 * rappresentation to old (evidence DTD) rappresentation and back to
	 * internal rappresentation, using
	 * {@link com.eu.evidence.rtdruid.internal.vartree.data.init.MyXMIReaderImpl MyXMIReaderImpl}.
	 */
	public void testXmi2XmlRTD_bis() {
		IVTResource first = prepareXMIReader();
		IVTResource second = createResource();

		first.setURI(URI.createFileURI("a.rtd"));
		second.setURI(URI.createFileURI("b.rtd"));

		try {
			
			ByteArrayOutputStream output = new ByteArrayOutputStream();

			SaveThread st = new SaveThread(first, output);
			st.start();


			try {
				st.join();
			} catch (Exception e) {
				e.printStackTrace();
				fail();
			}

			
			InputStream input = new ByteArrayInputStream(output.toByteArray());
			LoadThread lt = new LoadThread(second, input);
			lt.start();

			try {
				lt.join();
			} catch (Exception e) {
				e.printStackTrace();
				fail();
			}

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		String t = (new VtCompare((EObject) first.getContents().get(0),
				(EObject) second.getContents().get(0))).getText(); assertTrue(t, t== null);
		//first.getContents().clear();
		//second.getContents().clear();
	}

	
	
	private IVTResource prepareXMIReader() {
		IVTResource answer = createResource();

		answer.getContents().add((new FillVtTest()).fill());
		return answer;
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
				resource.save(outstream, new HashMap());
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
				resource.load(instream, new HashMap());
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

	public void testNew() {
	    /*
	     * IMPORTANT If this test fails, ususaly means that some Required file was not found (LAST_DTD, xsl files) 
	     */
	    try {
	    	IVTResource reader = createResource();
	    } catch (NoClassDefFoundError e) {
	        e.printStackTrace();
	        assertTrue(false);
	    } catch (Error e) {
	        e.printStackTrace();
	        assertTrue(false);
	    }
			
	}

	public void testLoad() {
		String xmlInput1 = 
			"<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + 
			"<!DOCTYPE SYSTEM SYSTEM \"evidence_0.2.dtd\">" +
			"<SYSTEM xmlns:rtdruid.vartree.data=\"http://rtdruid.vartree.data\"  Name=\"hp_test5 (bug 223)\">" +
			"<SCHEDULABILITY>" +
			"<SCHEDULINGSCENARIO>" +
			"<CPUSCHED CpuRef=\"CPU0.erika\" Utilization=\"1.1484126984126983\" SpeedFactor=\"1.4285714285714286\" Boundary=\"0.7347722898562381\" Schedulable=\"false\"/>" +
			"<TASKSCHED TaskRef=\"t1\" Utilization=\"0.22222222222222222\" CDelta=\"-3\" Schedulable=\"true\" ResponseTime=\"2ms\"/>" +
			"<TASKSCHED TaskRef=\"t1\" Utilization=\"2\" CDelta=\"-3\" Schedulable=\"true\" ResponseTime=\"2ms\"/>" +
			"</SCHEDULINGSCENARIO>" +
			"</SCHEDULABILITY>" +
			"</SYSTEM>";
		
		boolean ok = false;
		try {
			Resource res = loadString(xmlInput1);
			res.getContents().clear();
		} catch (RuntimeException e) {
			ok = true;
		} catch (AssertionFailedError e) {
			ok = true;
		}
		assertTrue(ok);
			
	}
	
	/*
	public void testLoadBis() {
		String xmlInput1 = 	"<SYSTEM Name=\"hp_test5 (bug 223)\">" +
			"<SCHEDULABILITY>" +
			"<SCHEDULINGSCENARIO>" +
			"<TASKSCHED TaskRef=\"t1\" Utilization=\"0.2\" Schedulable=\"true\"/>" +
			"<TASKSCHED TaskRef=\"t1\" Utilization=\"2\" CDelta=\"-3\"/>" +
			"</SCHEDULINGSCENARIO>" +
			"</SCHEDULABILITY>" +
			"</SYSTEM>";
		
		Resource res = loadString(xmlInput1);
		
		System root = (System) res.getContents().get(0);
		assertTrue(root.getSchedulability().getSchedulingScenarioList().size() == 1);
		SchedulingScenario sScen = (SchedulingScenario) root.getSchedulability().getSchedulingScenarioList().get(0);
		assertTrue(sScen.getTaskSchedList().size() == 1);

		TaskSched ts = (TaskSched) sScen.getTaskSchedList().get(0);
		assertEquals("t1", ts.getObjectID()); 
		assertEquals("true", "" + ts.getSchedulable()); 
		assertEquals("0.2", "" + ts.getUtilization());
		assertTrue(ts.getCDelta() == null);
	}*/

	
	public void testUpcaseID() {
		String xmlInput1 = 
			"<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + 
			"<!DOCTYPE SYSTEM SYSTEM \"evidence_0.2.dtd\">" +
			"<SYSTEM xmlns:rtdruid.vartree.data=\"http://rtdruid.vartree.data\"  Name=\"upcase\">" +
			"<ANNOTATION>" +
			"  <EXECTIME Ref=\"TASKET\" Type=\"TASK\">" +
			"	<WORST Value=\"324us\"/>" +
			"  </EXECTIME>" +
			"  <EXECTIME Ref=\"TASKET\" Type=\"task\">" +
			"	<WORST Value=\"324us\"/>" +
			"  </EXECTIME>" +
			"</ANNOTATION>" +
			"</SYSTEM>";
		
		loadString(xmlInput1);
			
		String xmlInput2 = 
			"<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + 
			"<!DOCTYPE SYSTEM SYSTEM \"evidence_0.2.dtd\">" +
			"<SYSTEM xmlns:rtdruid.vartree.data=\"http://rtdruid.vartree.data\"  Name=\"wrong upcase\">" +
			"<ANNOTATION>" +
			"  <EXECTIME Ref=\"TASKET\" Type=\"TASK\">" +
			"	<WORST Value=\"324ms\"/>" +
			"  </EXECTIME>" +
			"  <EXECTIME Ref=\"TASKET\" Type=\"task\">" +
			"	<WORST Value=\"324us\"/>" +
			"  </EXECTIME>" +
			"</ANNOTATION>" +
			"</SYSTEM>";
		
		boolean ok = false;
		try {
			loadString(xmlInput2);
		} catch (RuntimeException e) {
			e.printStackTrace();
			ok = true;
		} catch (AssertionFailedError e) {
			//e.printStackTrace();
			ok = true;
		}
		assertTrue(ok);
			
	}

	
	public void test_rtd2xmi() {
		IVarTree tree = (new FillVtTest()).newFilledVT();
		
		String rtd = Vt2StringUtilities.varTreeToStringRtd(tree);
		IVarTree vt = Vt2StringUtilities.loadString(rtd);
		String xmi = Vt2StringUtilities.varTreeToStringErtd(vt);
		
		System.out.println(xmi);
	}
	
	/***/
	private Resource loadString(String input) {
		
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put(IRTDImporter.OPT_USE_IMPORTER_TYPE, "rtd");
		
		
		Resource res = (new RTD_XMI_Factory()).createResource(URI.createFileURI("empty path"));
		try {
			res.load(new ByteArrayInputStream(input.getBytes()), map);
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
		return res;
	}

	
	protected IVTResource createResource() {
		return (IVTResource) new RTD_XMI_Factory().createResource();
	}
}