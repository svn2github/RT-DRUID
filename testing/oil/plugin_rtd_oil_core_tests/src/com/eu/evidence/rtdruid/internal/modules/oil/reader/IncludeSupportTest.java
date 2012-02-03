package com.eu.evidence.rtdruid.internal.modules.oil.reader;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.osgi.framework.Bundle;

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

	
	private URL getUrl(String filename) {
		Bundle b = Rtd_oil_corePlugin.getDefault().getBundle();
		URL url = b.getResource(filename);
		assertTrue(url != null);
		
		URL loc = null;
		try {
			loc = FileLocator.toFileURL(url);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		
		return loc;
	}
	
	private String getFile(String filename) {
		URL loc = getUrl(filename);		
		return loc.getFile();
	}
	
	private String getDir(String filename) {
		String host_filename = getFile(filename);
		File f = new File(host_filename);
		return f.getParent();
	}
	
	private InputStream getStream(String filename) {
//		return getClass().getClassLoader().getResourceAsStream(filename);
		URL loc = getUrl(filename);		
		try {
			return loc.openStream();
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		
		return null;
	}
	
	
	private String getMainPath() {
		return getFile("/com/eu/evidence/rtdruid/internal/modules/oil/reader/main.txt");
	}
	
	private String getLibPath() {
		return getFile("/com/eu/evidence/rtdruid/internal/modules/oil/reader/lib1");
	}
	

	@Test
	public void testIncludeSupport() {
		
		IncludeSupport incSup = new IncludeSupport(".");
		incSup.addLibPath(getLibPath());

		String out = null;
		try {
			out = incSup.compose(getMainPath(), false);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		//System.out.println(">>>\n"+out+"<<<");
		
		String result = loadFile(getFile("/com/eu/evidence/rtdruid/internal/modules/oil/reader/result.txt"));
		assertTrue(result.equals(out));
	}

	
	@Test
	public void testMultiDirIncludeSupport() {
		
		IncludeSupport incSup = new IncludeSupport(".");
		incSup.addLibPath(getLibPath());

		String out = null;
		try {
			out = incSup.compose(getFile("/com/eu/evidence/rtdruid/internal/modules/oil/reader/multi_dir_main.txt"), false);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		System.out.println(">>>\n"+out+"<<<");
		
		String result = loadFile(getFile("/com/eu/evidence/rtdruid/internal/modules/oil/reader/multi_dir_result.txt"));
		assertTrue(result.equals(out));
	}

	@Test
	public void testMultiDirIncludeSupportFirstChild() {

		IncludeSupport incSup = new IncludeSupport(".");
		incSup.addLibPath(getLibPath());

		String out = null;
		try {
			out = incSup.compose(getFile("/com/eu/evidence/rtdruid/internal/modules/oil/reader/incl_dir_1/first_dir_child.txt"), false);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		System.out.println(">>>\n"+out+"<<<");
		
		String result = loadFile(getFile("/com/eu/evidence/rtdruid/internal/modules/oil/reader/multi_dir_firstChild_result.txt"));
		assertTrue(result.equals(out));
	}

	
	@Test
	public void testMultiDirIncludeSupport__stream() {
		
		IncludeSupport incSup = new IncludeSupport(".");
		incSup.addLibPath(getLibPath());
		String filename = "/com/eu/evidence/rtdruid/internal/modules/oil/reader/multi_dir_main.txt";

		String out = null;
		try {
			out = incSup.compose(getStream(filename), getFile(filename), getDir(filename));
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		System.out.println(">>>\n"+out+"<<<");
		
		String result = loadFile(getFile("/com/eu/evidence/rtdruid/internal/modules/oil/reader/multi_dir_result.txt"));
		assertTrue(result.equals(out));
	}

	@Test
	public void testMultiDirIncludeSupportFirstChild__stream() {
		
		IncludeSupport incSup = new IncludeSupport(".");
		incSup.addLibPath(getLibPath());
		String filename = "/com/eu/evidence/rtdruid/internal/modules/oil/reader/incl_dir_1/first_dir_child.txt";

		String out = null;
		try {
			out = incSup.compose(getStream(filename), getFile(filename), getDir(filename));
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		System.out.println(">>>\n"+out+"<<<");
		
		String result = loadFile(getFile("/com/eu/evidence/rtdruid/internal/modules/oil/reader/multi_dir_firstChild_result.txt"));
		assertTrue(result.equals(out));
	}

	@Test
	public void testMultiDirIncludeSupport__stream__nopath() {
		
		IncludeSupport incSup = new IncludeSupport(".");
		incSup.addLibPath(getLibPath());
		String filename = "/com/eu/evidence/rtdruid/internal/modules/oil/reader/multi_dir_main.txt";

		String out = null;
		boolean ok = false;
		try {
			out = incSup.compose(getStream(filename), null, null);
		} catch (IOException e) {
			e.printStackTrace();
			//fail(e.getMessage());
			ok = true;
		}
		System.out.println(">>>\n"+out+"<<<");
		
		//String result = loadFile(getFile("/com/eu/evidence/rtdruid/internal/modules/oil/reader/multi_dir_result.txt"));
		//assertTrue(result.equals(out));
		assertTrue(ok);
	}
	
	
	@Test
	public void testSeed_include() {
		
		IncludeSupport incSup = new IncludeSupport(".");
		incSup.addLibPath(getLibPath());
		String filename = "/com/eu/evidence/rtdruid/internal/modules/oil/reader/seed/pic32/conf.oil";

		String out = null;
		try {
			out = incSup.compose(getStream(filename), getFile(filename), getDir(filename));
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
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
		System.out.println(">>>\n"+out+"<<<");
		
		String result = loadFile(getFile("/com/eu/evidence/rtdruid/internal/modules/oil/reader/seed/pic32/result.oil"));
		assertTrue(result.equals(out));
	}
	
	
	@Test
	public void testSeed_relative_paths_include() {
		
		IncludeSupport incSup = new IncludeSupport(".");
		incSup.addLibPath(getLibPath());
		String filepath = "src/com/eu/evidence/rtdruid/internal/modules/oil/reader/seed/pic32";
		String filename = filepath + "/conf.oil";

		
		File f = new File("."); // current working directory
		System.out.println(f.getAbsolutePath());
		
		File inputf = new File(filename);

		
		String out = null;
		try {
			out = incSup.compose(new FileInputStream(inputf), filename, filepath);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		System.out.println(">>>\n"+out+"<<<");
		
		String result = loadFile(getFile("/com/eu/evidence/rtdruid/internal/modules/oil/reader/seed/pic32/result.oil"));
		assertTrue(result.equals(out));
	}
	
	
	@Test
	public void testSeed_generation() {
		String filename = "/com/eu/evidence/rtdruid/internal/modules/oil/reader/seed/pic32/conf.oil";
		
		WorkerOilConfWriter writer = new WorkerOilConfWriter(new StdOutLogger());
		writer.setInputfile(getFile(filename));
		writer.setOutputdir("e:/seed_test");
		
		try {
			writer.execute();
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testSeed_relative_paths_generation() {
		
		// this test have to be run setting the correct "current working directory"
		String filename = "pic32/conf.oil";
		
		WorkerOilConfWriter writer = new WorkerOilConfWriter(new StdOutLogger());
		writer.setInputfile(filename);
		writer.setOutputdir("e:/seed_test");
		
		try {
			writer.execute();
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	
	private String loadFile(String path) {
		
		StringBuffer buffer = new StringBuffer(); 
		File f = new File(path);
	
		try {
			InputStream input = new BufferedInputStream(new FileInputStream(f));
			int a;
			while ((a = input.read()) != -1) {
				buffer.append((char) a);
			}
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

		return buffer.toString();
	}
}
