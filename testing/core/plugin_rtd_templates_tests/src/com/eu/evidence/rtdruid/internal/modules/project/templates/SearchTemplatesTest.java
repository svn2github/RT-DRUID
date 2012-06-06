/*
 * Created on 11-dic-2006
 *
 * $Id: SearchTemplatesTest.java,v 1.2 2007/03/09 09:12:41 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.project.templates;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Ignore;
import org.junit.Test;

/**
 * Tests about Example Templates
 * 
 * @author Nicola Serreli
 */
public class SearchTemplatesTest {

	@Test
	public void testXMLParser() {
		final String category = "dspic/test su multi";
		final String title = "Title of this test";
		final String shortDescr = "&lt;b&gt;Short&lt;/b&gt; description of current test (html text).&lt;br&gt;\n" +
				"		It can contains more than one rows&lt;br&gt;\n" +
				"		(usually between one to four)";
		final String longDescr = "A &lt;b&gt;long&lt;/b&gt; description of current test.&lt;br&gt;\n" +
				"		&lt;ul&gt;\n" +
				"		&lt;li&gt;Punto 1	&lt;/li&gt;\n" +
				"		&lt;li&gt;Punto 2	&lt;/li&gt;\n" +
				"		&lt;li&gt;Punto 3	&lt;/li&gt;\n" +
				"		&lt;/ul&gt;";
		final String txt = 
				"<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n" +
		
				"<!DOCTYPE evidence_example [\n" +
				"  <!ELEMENT evidence_example (category, title, small_descr, long_descr, file_section, variables)>\n" +
				"  <!ATTLIST evidence_example\n" +
				"  	version CDATA \"1\"\n" +
				"  >\n" +
				"  <!ELEMENT category     (#PCDATA)>\n" +
				"  <!ELEMENT title        (#PCDATA)>\n" +
				"  <!ELEMENT small_descr  (#PCDATA)>\n" +
				"  <!ELEMENT long_descr  (#PCDATA)>\n" +
		
				"  <!ELEMENT file_section (file | directory | files)*>\n" +
		
				"  <!ELEMENT file (var_id)*>\n" +
				"  <!ATTLIST file\n" +
				"  	name CDATA #REQUIRED\n" +
				"  	vars CDATA \"false\"\n" +
				"  >\n" +
				"  <!ELEMENT directory (var_id)*>\n" +
				"  <!ATTLIST directory\n" +
				"  	name CDATA #REQUIRED\n" +
				"  	vars CDATA \"false\"\n" +
				"  >\n" +
				"  <!ELEMENT files (var_id)*>\n" +
				"  <!ATTLIST files\n" +
				"  	group CDATA #REQUIRED\n" +
				"  	recursive CDATA \"true\"\n" +
				"  	vars CDATA \"false\"\n" +
				"  >\n" +
				"  <!ELEMENT var_id EMPTY>\n" +
				"  <!ATTLIST var_id\n" +
				"  	name CDATA #REQUIRED\n" +
				"  >\n" +
		
				"  <!ELEMENT variables (user_var)>\n" +
		
				"  <!ELEMENT user_var  (gui_name, small_descr, default)>\n" +
				"  <!ATTLIST user_var\n" +
				"  	name CDATA #REQUIRED\n" +
				"  	type CDATA #REQUIRED\n" +
				"  	required CDATA \"true\"\n" +
				"  >\n" +
				"  <!ELEMENT gui_name  (#PCDATA)>\n" +
				"  <!ELEMENT default   (#PCDATA)>\n" +
				"]>\n" +
		
				"<evidence_example version=\"1\">\n" +
		
				"	<category>"+category+"</category>\n" +
				"	<title>"+title+"</title>\n" +
		
				"	<small_descr>"+shortDescr+"</small_descr>\n" +
		
				"	<long_descr>"+longDescr+"</long_descr>\n" +
		
				"	<!--\n" +
				"	I file listati vengono sempre COPIATI.\n" +
				"	Eventualmente un file, dopo essere stato copiato puo' essere MODIFICATO (vedi def. variabili)\n" +
				"	Permettere di selezionare DIRECTORY e/o *\n" +
				"	-->\n" +
				"	<file_section>\n" +
				"		<file      name=\"file_1.c\"/>\n" + "\n" +
				"		<directory name=\"directory/\"/>\n" +
				"		<files     group=\"*.c\" recursive=\"true\" />\n" + "\n" +
				"		<files     group=\"inc/*.h\" recursive=\"false\" />\n" +
		
				"		<file      name=\"file_1.h\" vars=\"true\"/> <!-- sostituisce tutte le variabili -->\n" +
				"		<file      name=\"file_2.h\" vars=\"true\">\n" +
				"			<var_id name=\"name1\"/>	<!-- listo le variabili da sostituire -->\n" +
				"		</file>\n" +
				"	</file_section>\n" +
				"	<variables>\n" +
		
				"	 	<!--\n" +
				"	Name\n" +
				"		identifica la variabile nei file, per fare la sostituzione.\n" + "\n" +
				"		Nel file il nome deve essere preceduto da {_{ e seguito da }_} : {_{name}_}\n" + "\n" +
				"	Type\n" +
				"		string int fileSystem_directory fileSystem_file eclipse_directory eclipse_file\n" +
				"\n" +	"\n" +	"\n" +
				"	GuiName\n" +
				"		e' il nome che comapre nell'interfaccia grafica\n" +
				"	small_descr\n" +
				"		e' il testo che spiega cosa contiene il campo\n" +
				"	required\n" +
				"		indica se il valore deve essere non vuoto per poter portare a termine la configurazione.\n" +
				"		In ogni caso, il valore viene sostituito nei file (dove specificato)\n" +
				"		-->\n" +
				"		<user_var name=\"name1\" type=\"string\" required=\"true\">\n" +
				"			<gui_name>Name of this field</gui_name>\n" +
				"			<small_descr>&lt;b&gt;Short&lt;/b&gt; description of current variable (html text).&lt;br&gt;\n" +
				"				It can contains more than one rows&lt;br&gt;\n" +
				"				(usually between one to four)\n" +
				"			</small_descr>\n" +
		
				"			<default></default> <!-- opzionale: valore di default -->\n" +
				"		</user_var>\n" +
		
				"		<!-- possono esistere altri tipi di variabili? -->\n" +
				"	</variables>\n" +
		
				"</evidence_example>\n";
		
		
		
			InputStream is = new ByteArrayInputStream(txt.getBytes());
			ExampleTemplate answer = SearchTemplates.loadTemplate(is, "path", "template");
			
			assertTrue(answer!= null);
			
			assertTrue("path".equals(answer.getFs_path()));
			System.out.println(answer.getLongDescr());
			System.out.println(longDescr);
			System.out.println();
			
			String l = longDescr.replaceAll("&lt;", "<").replaceAll("&gt;",">");
			assertTrue(l.equals(answer.getLongDescr()));
			
			String s = shortDescr.replaceAll("&lt;", "<").replaceAll("&gt;",">");
			assertTrue(s.equals(answer.getShortDescr()));
			
			assertTrue(title.equals(answer.getTitle()));
			
			ExampleTemplate.ExampleFile[] files = answer.getExampleFiles();
			assertTrue(files.length == 3);
			
		}
	
	/**
	 * Search files inside the fileSystem
	 *to run this is required some directories inside c:\Evidence\Examples :
	 *  "example1 -> with config file (title = example1)"
	 *  "example2 -> with config file (title = example2)"
	 *  "example3 -> with config file (title = example3)"
	 */
	@Test
	@Ignore
	public void testSearchFS() {
		final String FS_PATH = "C:\\evidence\\examples\\";
		
		ExampleTemplate[] answer = SearchTemplates.getConfigTemplates(FS_PATH, SearchTemplates.DEFAULT_CONFIG_NAME);
		
		assertTrue(answer.length == 3);

		answer = SearchTemplates.getConfigTemplates();
		
		assertTrue(answer.length == 3);
	}
	/**
	 * Search files inside the fileSystem
	 *to run this is required some directories inside c:\Evidence\Examples :
	 *  "example1 -> with config file (title = example1)"
	 *  "example2 -> with config file (title = example2)"
	 *  "example3 -> with config file (title = example3)"
	 */
	@Test
	public void testSearchAll() {
		// TODO: rewrote
		
		ExampleTemplate[] answer = SearchTemplates.getConfigTemplates();
		
		for (ExampleTemplate item : answer){
			System.out.println(item.fs_path);
		}
		
		System.out.println("Tot templates are " + answer.length);
	}

}
