/*
 * Created on 11-dic-2006
 *
 * $Id: SearchTemplatesTest.java,v 1.2 2007/03/09 09:12:41 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.project.templates;

import com.eu.evidence.rtdruid.internal.modules.project.templates.ExampleTemplate;
import com.eu.evidence.rtdruid.internal.modules.project.templates.SearchTemplates;
import com.eu.evidence.rtdruid.internal.modules.project.templates.XmlToPlainText;

import junit.framework.TestCase;

/**
 * Tests about Example Templates
 * 
 * @author Nicola Serreli
 */
public class TemplatesConverterTest extends TestCase {

	
	/**
	 * Search plugins templates
	 */
	public void testBR() {
		String text = "a<ul>bc<br>efg <br> lmn \n.\n.<br>a";
		XmlToPlainText converter = new XmlToPlainText();
		System.out.println(">>\n"+text + "\n----\n" + converter.convert(text) + "\n<<<\n\n");
	}
	
	
	/**
	 * Search plugins templates
	 */
	public void testSearchAll() {
		
		ExampleTemplate[] answer = SearchTemplates.getConfigTemplates();

		XmlToPlainText converter = new XmlToPlainText();
		
		for (ExampleTemplate item : answer){
			System.out.println(item.fs_path + "\n");
			
			String txt = item.getLongDescr();
			System.out.println(">>\n"+txt + "\n----\n" + converter.convert(txt) + "\n<<<\n\n");
		}
		
		System.out.println("Tot templates are " + answer.length);
	}

}
