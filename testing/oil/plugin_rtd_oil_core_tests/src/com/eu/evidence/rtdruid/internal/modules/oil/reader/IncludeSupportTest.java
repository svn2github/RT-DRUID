package com.eu.evidence.rtdruid.internal.modules.oil.reader;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.junit.Test;
import org.osgi.framework.Bundle;

import com.eu.evidence.rtdruid.modules.oil.Rtd_oil_corePlugin;

public class IncludeSupportTest {
	
	private String getFile(String filename) {
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
		
		return loc.getFile();
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
