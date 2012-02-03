package com.eu.evidence.rtdruid.modules.oil.cdt.ui.cygwin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import junit.framework.TestCase;

import org.eclipse.core.runtime.IPath;

import com.eu.evidence.rtdruid.modules.oil.cdt.ui.Rtd_oil_cdt_Plugin;
import com.eu.evidence.rtdruid.modules.oil.cdt.ui.cygwin.MyMakeBuilder.MyMakeEclipseRelativePath;
import com.eu.evidence.rtdruid.modules.oil.cdt.ui.cygwin.MyMakeBuilder.MyMakePath;


public class MyMakeBuilderTest extends TestCase {

	
	public void testGetLocation() {
		
		MyMakeBuilder builder = new MyMakeBuilder(null, null);
		MyMakePath p = builder.getLocation();
		System.out.println(p.osPath);
		if (p instanceof MyMakeEclipseRelativePath) {
			System.out.println(((MyMakeEclipseRelativePath) p).fsPath);
		}
	}
	
	public void testGetState() {
		
		MyMakeBuilder builder = new MyMakeBuilder(null, null);
		String s = builder.getLocation().osPath;
		assertTrue(s != null);
		
		{
			File f = new File(s);
			if (f.exists() && !f.isDirectory()) {
				f.delete();
			}
			
			assertTrue(!f.exists());
		}
		assertTrue(builder.checkFile() == MyMakeBuilder.FileStatus.writable);

		try {
			builder.buildFile();
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		assertTrue(builder.checkFile() == MyMakeBuilder.FileStatus.exist);
		try {
			File f = new File(s);
			assertTrue(f.exists());
			FileInputStream input = new FileInputStream(f);
			StringBuffer buff = new StringBuffer();
			int a;
			while ((a = input.read()) != -1) {
				buff.append( (char) a);
			}
			assertTrue(buff.toString().equals(builder.getFileContent()));
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	public void testStateLocation() {
		IPath path = Rtd_oil_cdt_Plugin.getDefault().getStateLocation();
		System.out.println(path);
	}
}

