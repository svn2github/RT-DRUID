package com.eu.evidence.rtdruid.modules.oil.codewriter.options;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.Ignore;
import org.junit.Test;

public class PreferenceStorageTest {

	@Test
	public void testPreferenceStorage() {
		PreferenceStorage pref = PreferenceStorage.getCommonIstance();
		assertNotNull(pref);
	}

	@Test
	@Ignore
	public void testLookForWorkspaceFile() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testLookForInstallationFile() {
		fail("Not yet implemented");
	}

	@Test
	public void testSavePreferenceStorage() {
		PreferenceStorage pref = PreferenceStorage.getCommonIstance();
		assertNotNull(pref);
		pref.setCurrentFile(new File("test.properties"));
		pref.setValue("Test1", "c:\\ciao");
		pref.save();
	}

	@Test
	public void testSaveJavaProperties() throws IOException {
		
		Properties p = new Properties();
		p.setProperty("Test1", "c:\\ciao");
		p.store(new FileOutputStream(new File("test_java.properties")), null);
	}
	
	@Test
	public void testLoadJavaProperties() throws IOException {
		String testo = 
				"Test1_id=c:\\ciao\n" + // c:\ciao
				"Test2_id=c:\\\\ciao"; //  c:\\ciao
		Properties p = new Properties();
		p.load(new ByteArrayInputStream(testo.getBytes()));
		assertEquals("c:ciao",   p.getProperty("Test1_id"));
		assertEquals("c:\\ciao", p.getProperty("Test2_id"));
	}
	
	
	@Test
	public void testLoadSaveJavaProperties() throws IOException {
		String testo_in = 
				"#comment\n" + // c:\ciao
				"Test1_id=c:\\ciao\n" + // c:\ciao
				"#comment\n" + // c:\ciao
				"Test2_id=c:\\\\ciao"; //  c:\\ciao
		Properties p = new Properties();
		p.load(new ByteArrayInputStream(testo_in.getBytes()));
		p.setProperty("Test3", "val");
		assertEquals("c:ciao",   p.getProperty("Test1_id"));
		assertEquals("c:\\ciao", p.getProperty("Test2_id"));
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		p.store(out, null);
		System.out.println(out.toString());
		
		// perde i commenti
		assertTrue(out.toString().contains("comment") == false);
	}
}
