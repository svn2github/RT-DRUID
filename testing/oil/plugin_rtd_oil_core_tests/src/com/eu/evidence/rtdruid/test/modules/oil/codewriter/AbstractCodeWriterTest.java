package com.eu.evidence.rtdruid.test.modules.oil.codewriter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.w3c.dom.Document;

import com.eu.evidence.rtdruid.Rtd_corePlugin;
import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.internal.modules.oil.reader.OilReader;
import com.eu.evidence.rtdruid.io.IVTResource;
import com.eu.evidence.rtdruid.io.MultiSourceImporterFactory;
import com.eu.evidence.rtdruid.io.RTD_XMI_Factory;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.CommonUtils;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.HostOsUtils;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OsType;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.RtosFactory;
import com.eu.evidence.rtdruid.modules.oil.implementation.IOilImplID;
import com.eu.evidence.rtdruid.modules.oil.transform.OilTransformFactory;
import com.eu.evidence.rtdruid.tests.AbstractNamedTest;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.VarTreeUtil;
import com.eu.evidence.rtdruid.vartree.Vt2StringUtilities;

/**
 * This class can be use to simplify and standardize a Code Writer test
 * 
 * @author Nicola Serreli
 *
 */
public abstract class AbstractCodeWriterTest extends AbstractNamedTest {
	
	protected String basePath = null;
	public final static String SYS_PROP_TEST_BASE_PATH = "RTD_OIL_TESTS_RESULT_PATH";
	public final static String SYS_PROP_TEST_BASE_ACTION = "RTD_OIL_TESTS_RESULT_ACTION";
	public final static String SYS_PROP_TEST_BASE_ACTION_WRITE = "write";
	public final static String SYS_PROP_TEST_BASE_ACTION_READ = "read";
	public final static String SYS_PROP_TEST_BASE_ACTION_DISABLED = "disable";
	
	protected final boolean enable_generation;
	protected final boolean enable_file_check;
	
	public final static Collection<OsType> defaultOsSequence;
	protected final Collection<OsType> osSequence;
	
	static {
		ArrayList<OsType> temp = new ArrayList<OsType>();
		switch (HostOsUtils.common.getCurrentSystem()) {
		case Cygwin:
		case Win:
			temp.add(OsType.Linux);
			temp.add(OsType.Cygwin);
			break;
		case Linux:
		default:
			temp.add(OsType.Cygwin);
			temp.add(OsType.Linux);				
			break;
		}
		defaultOsSequence = Collections.unmodifiableCollection(temp); 
	}
	
	/**
	 * 
	 */
	public AbstractCodeWriterTest() {
		super();
		boolean default_check = true;
		{
			String tmp = System.getenv(SYS_PROP_TEST_BASE_PATH);
			if (tmp != null) {
				basePath = tmp;
			} else if (Rtd_corePlugin.IS_RESOURCES_BUNDLE_ACTIVE) {
				default_check = false;
			}
		}
		{
			String tmp = System.getenv(SYS_PROP_TEST_BASE_ACTION);
			if (SYS_PROP_TEST_BASE_ACTION_WRITE.equalsIgnoreCase(tmp)) {
				enable_generation = true;
				enable_file_check = false;
			} else if (SYS_PROP_TEST_BASE_ACTION_READ.equalsIgnoreCase(tmp)) {
				enable_generation = false;
				enable_file_check = true;
			} else if (SYS_PROP_TEST_BASE_ACTION_DISABLED.equalsIgnoreCase(tmp)) {
				enable_generation = false;
				enable_file_check = false;
			}  else { // DEFAULT
				enable_generation = false;
				enable_file_check = default_check;
			}
		}
		
		if (enable_file_check || enable_generation) {
			osSequence = defaultOsSequence;
		} else {
			ArrayList<OsType> tmp = new ArrayList<OsType>();
			tmp.add(HostOsUtils.common.getCurrentSystem());
			osSequence = Collections.unmodifiableCollection(tmp);
		}
	}
	
	public static boolean DEBUG_OIL_GENERATION = true;

	
	/**
	 * @return the osSequence
	 */
	public Collection<OsType> getOsSequence() {
		return osSequence;
	}
	
	/**
	 * A small class used to retur the IVarTree and computed Buffers
	 * 
	 * @author Nicola Serreli
	 */
	public static class DefaultTestResult {
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

		IVarTree vt = loadVt(oil_text);
		IVarTree vt2 = loadVt(oil_text);

		DefaultTestResult answer = dowrite(expected_cpu, vt, osSequence);

		IStatus st = VarTreeUtil.compare(vt, vt2); assertTrue(st.getMessage(), st.isOK());
		
		return answer;
	}

	public static IVarTree loadVt(String oil_text) {
		IVarTree vt2 = VarTreeUtil.newVarTree();
		(new OilReader()).load(new ByteArrayInputStream(oil_text.getBytes()), vt2, null, null);
		return vt2;
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
//System.err.flush();
//System.out.flush();
System.out.println("\n\n-------------\n" + answer);


		IVarTree vt2 = loadVt(answer);
//		
System.err.flush();
System.out.flush();
System.out.println("\n\n-------------\n" + Vt2StringUtilities.varTreeToStringErtd(vt));
System.err.flush();
System.out.flush();

System.out.println("\n\n-------------\n" + Vt2StringUtilities.varTreeToStringErtd(vt2));
System.err.flush();
System.out.flush();
//		
		IStatus st = VarTreeUtil.compare(
				(EObject) ((Resource) vt.getResourceSet().getResources().get(0)).getContents().get(0),
				(EObject) ((Resource) vt2.getResourceSet().getResources().get(0)).getContents().get(0)
		); assertTrue(st.getMessage(), st.isOK());

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

				EObject root = helper.load();
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
		
		return dowrite(expected_cpu, vt, osSequence);
	}

	/**
	 * @param expected_cpu
	 * @param vt
	 * @return
	 */
	public DefaultTestResult dowrite(int expected_cpu, IVarTree vt, Collection<OsType> testList) {
		// -------------- search rtos ----------------
		String[] prefix = CommonUtils.getAllRtos(vt.newTreeInterface());

		// --------------- write -----------------
		OsType originalTarget = HostOsUtils.common.getTarget();
		try {
			HashMap<String, Object> options = new HashMap<String, Object>();
			options.put(IWritersKeywords.ERIKA_ENTERPRISE_LOCATION, "ee");
			DefaultTestResult answer = null;
			for (OsType os: testList) {
				HostOsUtils.common.setTarget(os);
			
				IOilWriterBuffer[] buffers = null;
				try {
					buffers = RtosFactory.INSTANCE.write(vt, prefix, options);
				} catch (OilCodeWriterException e) {
		//			System.out.println(e.getMessage());
					throw new RuntimeException("Write fail: " + e.getMessage(), e);
				}
		
				debug(buffers);
				writeTestResultToFile(buffers);
				checkTestResultWithFile(buffers);
		
				assertEquals(expected_cpu, buffers.length);
		
				answer = new DefaultTestResult(vt, buffers);
			}	
			return answer;
		} finally {
			HostOsUtils.common.setTarget(originalTarget);
		}
	}
	

	protected void mergeInput(IVarTree vt, IVTResource res) {
		EList<EObject> objList = res.getContents();
		if (objList.size() > 0) {
			IVarTree vtt = VarTreeUtil.newVarTree();
			vtt.setRoot(res);
			mergeInput(vt, objList.get(0));
		}
	}
	
	protected void mergeInput(IVarTree vt, EObject root) {
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

    
    /**
     * This method writes all provided test results to a file corresponding to current test 
     * 
     * @param buffers
     */
    protected void writeTestResultToFile(IOilWriterBuffer[] buffers) {
    	if (enable_generation) {
	    	assertNotNull("Missing the base path where write the result of code generation", basePath);
	    	String path = basePath + (basePath.length()>0 && !basePath.endsWith(File.separator) ? File.separator : ""
	    			) + HostOsUtils.common.getTarget().getText();
	    	writeTestResultToFile(buffers, path, getClass().getName() + "-" + name.getMethodName());
    	}
    }
    
    /**
     * This method writes all provided test results to a file corresponding to current test 
     * 
     * @param buffers
     */
    protected void checkTestResultWithFile(IOilWriterBuffer[] buffers) {
    	if (enable_file_check) {
	    	assertNotNull("Missing the base path where read the expected result of code generation", basePath);
	    	String path = basePath + (basePath.length()>0 && !basePath.endsWith(File.separator) ? File.separator : "") +
	    			HostOsUtils.common.getTarget().getText() + File.separator
	    			+getClass().getName() + "-" + name.getMethodName();
	    	checkTestResultWithFile(buffers, path);
    	}
    }
    /**
     * This method writes all provided test results to a generic file 
     * 
     * @param buffers
     */
    protected void writeTestResultToFile(IOilWriterBuffer[] buffers, String folderPath, String fileName) {
		String path = fileName;
		if (folderPath != null){ // test directory
			File f = new File(folderPath);
			if (f.exists()) {
				assertTrue(f.isDirectory());
			} else {
				f.mkdirs();
			}
			path = folderPath + (folderPath.length()>0 && !folderPath.endsWith(File.separator) ? File.separator : "") + fileName;
		}
		if (DEBUG_OIL_GENERATION) {
			System.out.println("Check " +path);
		}
		try {
	    	File f = new File(path);
	    	FileOutputStream out = new FileOutputStream(f);
	    	write(buffers, out);
	    	out.flush();
	    	out.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
    }
    /**
     * This method writes all provided test results to a generic file 
     * 
     * @param buffers
     */
    protected void checkTestResultWithFile(IOilWriterBuffer[] buffers, String filePath) {
		if (DEBUG_OIL_GENERATION) {
			System.out.println("Check " +filePath);
		}
		String expected = null;
		try {
	    	File f = new File(filePath);
	    	InputStream in = new BufferedInputStream(new FileInputStream(f));
	    	StringBuffer buff = new StringBuffer();
	    	for (int r = in.read(); r!=-1; r=in.read()) {
	    		buff.append((char)r);
	    	}
	    	expected = buff.toString();
	    	in.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		String actual = toString(buffers);
		
		assertEquals(expected, actual);
    }
    

	
	/**
	 * Write all buffers to standard output or to the given stream
	 * 
	 * @param buffers
	 */
	public void debug(IOilWriterBuffer[] buffers) {
		if (DEBUG_OIL_GENERATION) {
			write(buffers, System.out);
		}
	}
	
	/**
	 * Convert all buffers to a single String. Do not use this function to save buffers to output stream.
	 * 
	 * @param buffers
	 */
	public String toString(IOilWriterBuffer[] buffers) {
		ByteArrayOutputStream buff = new ByteArrayOutputStream();
		write(buffers, buff);
		return buff.toString();
	}
	
	/**
	 * Write all buffers to standard output or to the given stream
	 * 
	 * @param buffers
	 */
	public void write(IOilWriterBuffer[] buffers, OutputStream out) {
		try {
			for (int i=0; i<buffers.length; i++) {
				out.write(("buff " + i + ":\n").getBytes());
				out.write((buffers[i]).toString().getBytes());
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
    
}
