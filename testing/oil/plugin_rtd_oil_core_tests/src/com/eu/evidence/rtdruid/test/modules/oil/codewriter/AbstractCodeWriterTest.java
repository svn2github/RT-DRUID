package com.eu.evidence.rtdruid.test.modules.oil.codewriter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.w3c.dom.Document;

import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
import com.eu.evidence.rtdruid.internal.modules.oil.reader.OilReader;
import com.eu.evidence.rtdruid.io.IVTResource;
import com.eu.evidence.rtdruid.io.MultiSourceImporterFactory;
import com.eu.evidence.rtdruid.io.RTD_XMI_Factory;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.CommonUtils;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.RtosFactory;
import com.eu.evidence.rtdruid.modules.oil.implementation.IOilImplID;
import com.eu.evidence.rtdruid.modules.oil.transform.OilTransformFactory;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.VarTreeUtil;

/**
 * This class can be use to simplify and standardize a Code Writer test
 * 
 * @author Nicola Serreli
 *
 */
public abstract class AbstractCodeWriterTest {
	
	@Rule public TestName name = new TestName();
	
	@Before
	public void setUp() throws Exception {
		System.err.flush();
		System.out.println("\n\n************\n TEST " + getClass().getName() + " - " + name.getMethodName() + "\n************\n\n");
		System.out.flush();
	}
	
	@After
	public void setDown() throws Exception {
		System.err.flush();
		System.out.flush();
	}
		
	/**
	 * A small class used to retur the IVarTree and computed Buffers
	 * 
	 * @author Nicola Serreli
	 */
	protected class DefaultTestResult {
		public final IVarTree vt;
		public final IOilWriterBuffer[] buffers;
		public DefaultTestResult(IVarTree vt, IOilWriterBuffer[] buffers) {
			this.vt = vt;
			this.buffers = buffers;
		}
	}
	

	/**
	 * This is a standard method that can be used to read an oil file, test oil transformation and write
	 * the configuration on standard output
	 * 
	 * @param oil_text
	 *            the oil configuration
	 * @param expected_cpu
	 *            the expected number of cpu
	 *            
	 * @return both the loaded IVarTree and computed Buffers
	 */
	public DefaultTestResult commonWriterTest(String oil_text, int expected_cpu) {
		checkOilTransformation(oil_text, expected_cpu);
		return writerTest(oil_text, expected_cpu);
	}
	
	/**
	 * This is a standard method that can be used to read an oil file and write
	 * the configuration on standard output
	 * 
	 * @param oil_text
	 *            the oil configuration
	 * @param expected_cpu
	 *            the expected number of cpu
	 *            
	 * @return both the loaded IVarTree and computed Buffers
	 */
	protected DefaultTestResult writerTest(String oil_text, int expected_cpu) {

		IVarTree vt = VarTreeUtil.newVarTree();
		(new OilReader()).load(new ByteArrayInputStream(oil_text.getBytes()), vt, null, null);

		// -------------- search rtos ----------------
		ITreeInterface ti = vt.newTreeInterface();

		String[] prefix = CommonUtils.getAllRtos(ti);
		//assertEquals(expected_cpu, prefix.length);

		// --------------- write -----------------

		IOilWriterBuffer[] buffers = null;
		try {
			buffers = RtosFactory.INSTANCE.write(vt, prefix);
		} catch (OilCodeWriterException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException("Write fail: " + e.getMessage(), e);
		}

		assertNotNull(buffers);
		assertEquals(expected_cpu, buffers.length);
		for (int i=0; i<expected_cpu; i++)
			System.out.println("buff " + i + ":\n" + (buffers[i]).toString());

		return new DefaultTestResult(vt, buffers);
	}
	
	/**
	 * This is a standard method that can be used to check the oil transformation
	 * 
	 * @param oil_text
	 *            the oil configuration
	 * @param expected_cpu
	 *            the expected number of cpu
	 *            
	 * @return both the loaded IVarTree and computed Buffers
	 */
	protected void checkOilTransformation(String oil_text, int expected_cpu) {
		// Load as VarTree
		IVarTree vt = VarTreeUtil.newVarTree();
		OilTransformFactory otf = OilTransformFactory.INSTANCE;
		(new OilReader()).load(new ByteArrayInputStream(oil_text.getBytes()),
				vt, null, null);
		
		// write as Oil
		String[] prefix = CommonUtils.getAllRtos(vt.newTreeInterface());
		assertEquals(prefix.length, expected_cpu);
		IOilImplID id = otf.getOilId("ee");
		String answer = otf.getTransform("ee").write(vt, id, prefix);
		assertNotNull(answer);

		// --------------------
		// Load the produced Oil as Vt and compare
		IVarTree vt2 = VarTreeUtil.newVarTree();
		(new OilReader()).load(new ByteArrayInputStream(answer.getBytes()),
				vt2, null, null);
		
		String t = VarTreeUtil.compare(
				(EObject) ((Resource) vt.getResourceSet().getResources().get(0)).getContents().get(0),
				(EObject) ((Resource) vt2.getResourceSet().getResources().get(0)).getContents().get(0)
		).getMessage(); assertNull(t, t);

	}

	/**
	 * This is a standard method that can be used to read an oil file and write
	 * the configuration on standard output
	 * 
	 * @param oil_text
	 *            the oil configuration
	 * @param expected_cpu
	 *            the expected number of cpu
	 *            
	 * @return both the loaded IVarTree and computed Buffers
	 * @throws IOException 
	 */
	public DefaultTestResult commonWriterTest(String[] input_text, String[] input_type, int expected_cpu) throws IOException {
		IVarTree vt = VarTreeUtil.newVarTree();
		assertEquals(input_text.length, input_type.length);
		
		{ //  ----------- LOAD ----------- 

			// prepare
			ArrayList<MultiSourceImporterFactory.LoadHelper> helpers = new ArrayList<MultiSourceImporterFactory.LoadHelper>();
			Set<String> simpleLoad = new HashSet<String>();
			for (int i=0; i<input_type.length; i++) {

				InputStream input = new ByteArrayInputStream(input_text[i].getBytes());

				boolean found = false;
				// check already existing helpers
				for (MultiSourceImporterFactory.LoadHelper helper : helpers) {
					if (helper.add(input_type[i], input)) {
						found = true;
						break;
					}
				}

				if (!found) {
					// check a new helper
					MultiSourceImporterFactory.LoadHelper helper = new MultiSourceImporterFactory.LoadHelper();
					if (helper.add(input_type[i], input)) {
						found = true;
						helpers.add(helper);
					}
				}

				if (!found) {
					// ok. it should be handled as single file
					simpleLoad.add(input_text[i]);
				}
			}

			// load
			for (MultiSourceImporterFactory.LoadHelper helper : helpers) {

				com.eu.evidence.rtdruid.vartree.data.System root = helper.load();
				mergeInput(vt, root);
			}
			
			// load
			for (int i=0; i<input_type.length; i++) {
				if (simpleLoad.contains(input_text[i])) {

					// load and parse the input file
					IVTResource res = (IVTResource) new RTD_XMI_Factory()
							.createResource(URI.createFileURI(input_type[i]));
					res.load(new ByteArrayInputStream(input_text[i].getBytes()), null);
					mergeInput(vt, res);
				}
			}
		}
		
		// -------------- search rtos ----------------
		ITreeInterface ti = vt.newTreeInterface();

		String[] prefix = CommonUtils.getAllRtos(ti);
//		assertTrue(prefix.length == expected_cpu);

		// --------------- write -----------------

		IOilWriterBuffer[] buffers = null;
		try {
			buffers = RtosFactory.INSTANCE.write(vt, prefix);
		} catch (OilCodeWriterException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException("Write fail: " + e.getMessage(), e);
		}

		assertNotNull(buffers);
		for (int i=0; i<buffers.length; i++)
			System.out.println("buff " + i + ":\n" + (buffers[i]).toString());

		assertEquals(expected_cpu, buffers.length);

		return new DefaultTestResult(vt, buffers);
	}
	
	

	protected void mergeInput(IVarTree vt, IVTResource res) {
		EList<EObject> objList = res.getContents();
		if (objList.size() > 0) {
			IVarTree vtt = VarTreeUtil.newVarTree();
			vtt.setRoot(res);
			mergeInput(vt, ((com.eu.evidence.rtdruid.vartree.data.System) objList.get(0)));
		}
	}
	
	protected void mergeInput(IVarTree vt, com.eu.evidence.rtdruid.vartree.data.System root) {
		// get the old root
		EList<Resource> resList = vt.getResourceSet().getResources();
		if (resList.size() == 0) {
			resList.add((new RTD_XMI_Factory()).createResource());
		}
		EList<EObject> objList = resList.get(0).getContents();
		if (objList.size() == 0) {
			// set the new root
			objList.add(root);
		} else {
			// merge old and new root
			VarTreeUtil.merge(objList.get(0), root, null, false);
		}
	}
	
    public static String oilToXmltext(InputStream input) throws TransformerFactoryConfigurationError, TransformerException {
        Document xml = (new OilReader()).loadAsXml(input, null, null);
        return xmlToText(xml);
    }

    public static String xmlToText(Document doc) throws TransformerFactoryConfigurationError, TransformerException {
    	ByteArrayOutputStream output = new ByteArrayOutputStream();

		Transformer transformer = TransformerFactory.newInstance()
				.newTransformer();

		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		// Transform the source XML
		transformer.transform(new DOMSource(doc), new StreamResult(output));

		return output.toString();
    }

}
