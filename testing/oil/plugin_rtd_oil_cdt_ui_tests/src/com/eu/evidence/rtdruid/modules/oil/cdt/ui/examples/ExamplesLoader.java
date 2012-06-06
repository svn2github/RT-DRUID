/**
 * 04/giu/2012
 */
package com.eu.evidence.rtdruid.modules.oil.cdt.ui.examples;

import static junit.framework.Assert.assertNotNull;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class ExamplesLoader {
	public final static String EXAMPLES_PATH = "/" + ExamplesLoader.class.getPackage().getName().replace(".", "/")+"/";

	
	public final static ExamplesLoader instance = new ExamplesLoader();

	public static String safeLoad(String name) {
		String answer = null;
		try {
			answer = load(name);
		} catch (IOException e) {
			// do nothing
			answer = null;
		}
		return answer;
	}
	
	public static String load(String name) throws IOException {
		InputStream data = getInputStream(name);
		assertNotNull("Missing " + name + " oil test ", data);
		data = new BufferedInputStream(data);
		StringBuffer buff = new StringBuffer();
		int a=-1;
		while ((a = data.read()) != -1) {
			buff.append((char)a);
		}
			
		return buff.toString();
	}
	
	/**
	 * @return the inputStream related to this test
	 */
	public static InputStream getInputStream(String name) {
		return ExamplesLoader.class.getResourceAsStream(EXAMPLES_PATH + name+".oil");
	}

}
