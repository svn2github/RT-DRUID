package com.eu.evidence.rtdruid.modules.oil.reader.inclusion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.osgi.framework.Bundle;

import com.eu.evidence.rtdruid.internal.modules.oil.reader.IncludeSupport;
import com.eu.evidence.rtdruid.internal.modules.oil.workers.OilWorkerException;
import com.eu.evidence.rtdruid.internal.modules.oil.workers.StdOutLogger;
import com.eu.evidence.rtdruid.internal.modules.oil.workers.WorkerOilConfWriter;
import com.eu.evidence.rtdruid.modules.oil.Rtd_oil_corePlugin;

public class IncludeSupportTest {
	
	
	@Rule public TestName name = new TestName();
	
	@Before
	public void setUp() throws Exception {
		System.err.flush();
		System.out.println("\n\n************\n TEST " + getClass().getName() + " - " + name.getMethodName() + "\n************\n\n");
		System.out.flush();
	}

	private final String BASE_PATH = "/"+IncludeSupportTest.class.getPackage().getName().replace('.', '/');
	
	private URL getUrl(String filename) throws IOException {
		Bundle b = Rtd_oil_corePlugin.getDefault().getBundle();
		URL url = b.getResource(filename);
		assertNotNull(url);
		
		return FileLocator.toFileURL(url);
	}
	
	private String getFile(String filename) throws IOException {
		URL loc = getUrl(filename);		
		return loc.getFile();
	}
	
	private String getDir(String filename) throws IOException {
		String host_filename = getFile(filename);
		File f = new File(host_filename);
		return f.getParent();
	}
	
	private InputStream getStream(String filename) throws IOException {
//		return getClass().getClassLoader().getResourceAsStream(filename);
		URL loc = getUrl(filename);		
		return loc.openStream();
	}
	
	
	private String getMainPath() throws IOException {
		return getFile(BASE_PATH+"/main.txt");
	}
	
	private String getLibPath() throws IOException {
		return getFile(BASE_PATH+"/lib1");
	}

	private String trim(String txt) throws IOException {
		return txt.replace("\r", "").trim();
	}


	@Test
	public void testIncludeSupport() throws IOException {
		
		IncludeSupport incSup = new IncludeSupport(".");
		incSup.addLibPath(getLibPath());

		String out = trim(incSup.compose(getMainPath(), false));
		
		String result = loadFile(getFile(BASE_PATH+"/result.txt"));
		assertEquals(result, out);
	}

	
	@Test
	public void testMultiDirIncludeSupport() throws IOException {
		
		IncludeSupport incSup = new IncludeSupport(".");
		incSup.addLibPath(getLibPath());

		String out = trim(incSup.compose(getFile(BASE_PATH+"/multi_dir_main.txt"), false));
//		System.out.println(">>>\n"+out+"<<<");
		
		String result = loadFile(getFile(BASE_PATH+"/multi_dir_result.txt"));
		assertEquals(result, out);
	}

	@Test
	public void testMultiDirIncludeSupportFirstChild() throws IOException {

		IncludeSupport incSup = new IncludeSupport(".");
		incSup.addLibPath(getLibPath());

		String out = trim(incSup.compose(getFile(BASE_PATH+"/incl_dir_1/first_dir_child.txt"), false));
//		System.out.println(">>>\n"+out+"<<<");
		
		String result = loadFile(getFile(BASE_PATH+"/multi_dir_firstChild_result.txt"));
		assertEquals(result, out);
	}

	
	@Test
	public void testMultiDirIncludeSupport__stream() throws IOException {
		
		IncludeSupport incSup = new IncludeSupport(".");
		incSup.addLibPath(getLibPath());
		String filename = BASE_PATH+"/multi_dir_main.txt";

		String out = trim(incSup.compose(getStream(filename), getFile(filename), getDir(filename)));
//		System.out.println(">>>\n"+out+"<<<");
		
		String result = loadFile(getFile(BASE_PATH+"/multi_dir_result.txt"));
		assertEquals(result, out);
	}

	@Test
	public void testMultiDirIncludeSupportFirstChild__stream() throws IOException {
		
		IncludeSupport incSup = new IncludeSupport(".");
		incSup.addLibPath(getLibPath());
		String filename = BASE_PATH+"/incl_dir_1/first_dir_child.txt";

		String out = trim(incSup.compose(getStream(filename), getFile(filename), getDir(filename)));
//		System.out.println(">>>\n"+out+"<<<");
		
		String result = loadFile(getFile(BASE_PATH+"/multi_dir_firstChild_result.txt"));
		assertEquals(result, out);
	}

	@Test(expected=IOException.class)
	public void testMultiDirIncludeSupport__stream__nopath() throws IOException {
		
		IncludeSupport incSup = new IncludeSupport(".");
		incSup.addLibPath(getLibPath());
		String filename = BASE_PATH+"/multi_dir_main.txt";

		incSup.compose(getStream(filename), null, null);		
	}
	
	
	@Test
	public void testSeed_include() throws IOException {
		
		IncludeSupport incSup = new IncludeSupport(".");
		incSup.addLibPath(getLibPath());
		String filename = BASE_PATH+"/seed/pic32/conf.oil";

		String out = trim(incSup.compose(getStream(filename), getFile(filename), getDir(filename)));
//		File f= new File("e:/pippo.oil");
//		try {
//			FileWriter fw = new FileWriter(f);
//			fw.append(out);
//			fw.flush();
//			fw.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//			fail(e.getMessage());
//		}
//		System.out.println(">>>\n"+out+"<<<");
		
		String result = loadFile(getFile(BASE_PATH+"/seed/pic32/result.oil"));
		assertEquals(result, out);
	}
	
	
	@Test
	public void testSeed_relative_paths_include() throws IOException {
		
		IncludeSupport incSup = new IncludeSupport(".");
		incSup.addLibPath(getLibPath());
		String filepath = "src" + BASE_PATH + "/seed/pic32";
		String filename = filepath + "/conf.oil";

		Assume.assumeTrue(new File(filename).exists());
		
//		File f = new File("."); // current working directory
//		System.out.println(f.getAbsolutePath());
		
		File inputf = new File(filename);

		
		String out = trim(incSup.compose(new FileInputStream(inputf), filename, filepath));
//		System.out.println(">>>\n"+out+"<<<");
		
		String result = loadFile(getFile(BASE_PATH+"/seed/pic32/result.oil"));
		assertEquals(result, out);
	}
	
	
	@Test
	public void testSeed_generation() throws IOException, OilWorkerException {
		String filename = getFile( BASE_PATH+"/seed/pic32/conf.oil");

		assertTrue((new File(filename).exists()));

		WorkerOilConfWriter writer = new WorkerOilConfWriter(new StdOutLogger());
		writer.setInputfile(filename);
		writer.setOutputdir("e:/seed_test");
		
		writer.execute();
	}
	
	@Test
	public void testSeed_relative_paths_generation() throws OilWorkerException {

		File f = new File("."); // current working directory
		System.out.println(f.getAbsolutePath());
		
		// this test have to be run setting the correct "current working directory"
		String filename = "src" + BASE_PATH + 
				"/seed/pic32/conf.oil";
		Assume.assumeTrue(new File(filename).exists());
		
		assertTrue(filename, (new File(filename).exists()));
		
		
		WorkerOilConfWriter writer = new WorkerOilConfWriter(new StdOutLogger());
		writer.setInputfile(filename);
		writer.setOutputdir("e:/seed_test");
		
		writer.execute();
	}
	
	
	private String loadFile(String path) throws IOException {
		
		StringBuffer buffer = new StringBuffer(); 
		File f = new File(path);
	
		InputStream input = new BufferedInputStream(new FileInputStream(f));
		int a;
		while ((a = input.read()) != -1) {
			buffer.append((char) a);
		}

		return trim(buffer.toString());
	}
}
