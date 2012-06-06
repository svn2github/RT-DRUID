package com.eu.evidence.rtdruid.io;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.junit.Ignore;
import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.eu.evidence.rtdruid.Rtd_corePlugin;
import com.eu.evidence.rtdruid.internal.io.RTDXsltImportExport;
import com.eu.evidence.rtdruid.io.XsltTransformThread.MyErrHandler;

public class XsltTransformThreadTest {

	private static final String filepath = "full_xmi_example.xml";

	private InputStream getInput() {
		return XsltTransformThreadTest.class.getResourceAsStream(filepath);
	}

	private URL getXmi2Rtd() {
		return RTDXsltImportExport.getXMI_2_XML();
	}

	private URL getRtd2Xmi() {
		return RTDXsltImportExport.getXML_2_XMI();
	}

	private URL getRtdDTD() {
		return RTDXsltImportExport.getLastDtdFile();
	}


	@Test
	public void testLoadDoc() throws ParserConfigurationException, SAXException, IOException, TransformerFactoryConfigurationError, TransformerException {

		InputStream input = getInput();

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setIgnoringElementContentWhitespace(true);
		factory.setIgnoringComments(true);
		factory.setValidating(false);

		DocumentBuilder builder;
		builder = factory.newDocumentBuilder();
		Document doc;

		MyErrHandler meh = new MyErrHandler();

		builder.setErrorHandler(meh);

		doc = builder.parse(input);

		assertNotNull(doc);
		assertNotNull(doc.getDocumentElement());

		Transformer transformer;
			transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "no");

			ByteArrayOutputStream tmp = new ByteArrayOutputStream();

			// Transform the source XML
			transformer
					.transform(new DOMSource(doc), new StreamResult(tmp));


		input.close();
	}

	@Test
	public void testRun() {
		InputStream input = getInput();
		ByteArrayOutputStream output = new ByteArrayOutputStream();

		final URL XMI_2_XML = getXmi2Rtd();

		XsltTransformThread thread = new XsltTransformThread(input, output,
				XMI_2_XML, false, null);

		thread.run();
	}

	@Test
	public void testTransform() throws IOException, TransformerException {

		System.out.println("\n***********\n*\n* DIRECT ) \n*\n***********");

				InputStream input = XsltTransformThreadTest.class
				.getResourceAsStream(filepath);
		ByteArrayOutputStream output = new ByteArrayOutputStream();

		// Create a transform factory instance.
		TransformerFactory tfactory = TransformerFactory.newInstance();

		// Create a transformer for the stylesheet.
		Transformer transformer = tfactory.newTransformer(new StreamSource(
				getXmi2Rtd().openStream()));

		// Transform the source XML
		transformer.transform(new StreamSource(input), new StreamResult(
				output));

		System.out.println(output.toString());
	}

	@Test
	public void testTransform2() throws ParserConfigurationException, SAXException, IOException, TransformerException {

		System.out.println("\n***********\n*\n* USE RUN \n*\n***********");

		InputStream input = XsltTransformThreadTest.class
				.getResourceAsStream(filepath);
		ByteArrayOutputStream output = new ByteArrayOutputStream();

		run(input, output, getXmi2Rtd(), false);

		System.out.println(output.toString());

	}
	
	
	@Test
	public void testCompareRunAndDirect() throws IOException, TransformerException, ParserConfigurationException, SAXException {

		System.out.println("\n***********\n*\n* Compare ) \n*\n***********");

		String output_direct;
		String output_run;
		{
	
			InputStream input = XsltTransformThreadTest.class
					.getResourceAsStream(filepath);
			ByteArrayOutputStream output = new ByteArrayOutputStream();
	
			// Create a transform factory instance.
			TransformerFactory tfactory = TransformerFactory.newInstance();

			// Create a transformer for the stylesheet.
			Transformer transformer = tfactory.newTransformer(new StreamSource(
					getXmi2Rtd().openStream()));

			// Transform the source XML
			transformer.transform(new StreamSource(input), new StreamResult(
					output));

			System.out.println(output.toString());
			output_direct = output.toString();
		}

		{
			InputStream input = XsltTransformThreadTest.class
					.getResourceAsStream(filepath);
			ByteArrayOutputStream output = new ByteArrayOutputStream();
	
			run(input, output, getXmi2Rtd(), false);
			
			output_run = output.toString();

		}

		// NOTE !!!! 
		assertFalse( output_direct.equals(output_run));
	}
	
	
	@Test
	public void testCompareRunAndDirect2() throws TransformerException, IOException, ParserConfigurationException, SAXException {

		System.out.println("\n***********\n*\n* Compare run2) \n*\n***********");

		String output_direct;
		String output_run;
		{
	
			InputStream input = XsltTransformThreadTest.class
					.getResourceAsStream(filepath);
			ByteArrayOutputStream output = new ByteArrayOutputStream();
	
			// Create a transform factory instance.
			TransformerFactory tfactory = TransformerFactory.newInstance();

			// Create a transformer for the stylesheet.
			Transformer transformer = tfactory.newTransformer(new StreamSource(
					getXmi2Rtd().openStream()));

			// Transform the source XML
			transformer.transform(new StreamSource(input), new StreamResult(
					output));

			System.out.println(output.toString());
			output_direct = output.toString();
		}

		{
			InputStream input = XsltTransformThreadTest.class
					.getResourceAsStream(filepath);
			ByteArrayOutputStream output = new ByteArrayOutputStream();
	
			run2(input, output, getXmi2Rtd(), false);
			
			output_run = output.toString();

		}

		assertTrue(output_direct.equals(output_run));
	}

	

	@Test
	public void testCompareTransfThreadAndDirect() throws TransformerException, ParserConfigurationException, SAXException, IOException {

		System.out.println("\n***********\n*\n* Compare transformation thread) \n*\n***********");

		String output_direct;
		String output_run;
		{
			InputStream input = XsltTransformThreadTest.class
					.getResourceAsStream(filepath);
			ByteArrayOutputStream output = new ByteArrayOutputStream();

			XsltTransformThread th = new XsltTransformThread(input, output, getXmi2Rtd(), false, null);
			th.run();

			output_direct = output.toString();
		}

		{
			InputStream input = XsltTransformThreadTest.class
					.getResourceAsStream(filepath);
			ByteArrayOutputStream output = new ByteArrayOutputStream();
	
			run2(input, output, getXmi2Rtd(), false);
			
			output_run = output.toString();

		}

		assertTrue(output_direct.equals(output_run));
	}
	
	
	@Test
	@Ignore
	public void testTransformBoth() throws ParserConfigurationException, SAXException, IOException, TransformerException {
	
		//disabled because this function doesn't work correctly		

		System.out.println("\n***********\n*\n* BOTH 1 ) \n*\n***********");

		InputStream input = XsltTransformThreadTest.class
				.getResourceAsStream(filepath);
		ByteArrayOutputStream output = new ByteArrayOutputStream();

		run(input, output, getXmi2Rtd(), false);

		String outputTXT = output.toString();

		System.out.println(outputTXT);

		System.out.println("\n***********\n*\n* BOTH 2 ) \n*\n***********");

		output = new ByteArrayOutputStream();
		run(new ByteArrayInputStream(outputTXT.getBytes()), output,
				getRtd2Xmi(), false);

		String outputTXT2 = output.toString();
		System.out.println(outputTXT2);
	}
	

	
	@Test
	public void testTransformBoth2() throws TransformerException, ParserConfigurationException, SAXException, IOException {

		System.out.println("\n***********\n*\n* BOTH USING SPLI Tfunction - 1 ) \n*\n***********");

		InputStream input = XsltTransformThreadTest.class
				.getResourceAsStream(filepath);
		ByteArrayOutputStream output = new ByteArrayOutputStream();

		run2(input, output, getXmi2Rtd(), false);

		String outputTXT = output.toString();

		System.out.println(outputTXT);

		System.out.println("\n***********\n*\n* BOTH USING SPLI Tfunction - 2 ) \n*\n***********");

		output = new ByteArrayOutputStream();
		run2(new ByteArrayInputStream(outputTXT.getBytes()), output,
				getRtd2Xmi(), true);

		String outputTXT2 = output.toString();
		System.out.println(outputTXT2);
	}
	
	@Test
	public void testTransformBothThread() {

		System.out.println("\n***********\n*\n* BOTH USING Xslt thread - 1 ) \n*\n***********");

		InputStream input = XsltTransformThreadTest.class
				.getResourceAsStream(filepath);
		ByteArrayOutputStream output = new ByteArrayOutputStream();


		XsltTransformThread th = new XsltTransformThread(input, output, getXmi2Rtd(), false, null);
		th.run();

		String outputTXT = output.toString();

		System.out.println(outputTXT);

		System.out.println("\n***********\n*\n* BOTH USING Xslt thread - 2 ) \n*\n***********");

		output = new ByteArrayOutputStream();
		XsltTransformThread th2 = new XsltTransformThread(new ByteArrayInputStream(outputTXT.getBytes()), output,
					getRtd2Xmi(), true, getRtdDTD());
		th2.run();

		String outputTXT2 = output.toString();
		System.out.println(outputTXT2);
	}

	/**
	 * This method doesn't work correctly if there is no validation !!!
	 * 
	 * @param input
	 * @param output
	 * @param transformation
	 * @param validate
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws TransformerException 
	 */
	private void run(InputStream input, OutputStream output, URL transformation,
			boolean validate) throws ParserConfigurationException, SAXException, IOException, TransformerException {

		// ErrorHandler handler = null;
		URL dtd = XsltTransformThreadTest.class.getResource(Rtd_corePlugin.TEMPLATES_PATH + "/evidence_0.2.dtd");

		Document doc = null;

		/*
		 * VALIDATE THE DOCUMENT
		 */
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setIgnoringElementContentWhitespace(true);
		factory.setIgnoringComments(true);
		factory.setValidating(validate);

		DocumentBuilder builder = factory.newDocumentBuilder();

		// if (handler == null) {
		MyErrHandler meh = new MyErrHandler();

		builder.setErrorHandler(meh);

		{
			if (validate && dtd != null) {
				doc = builder.parse(input, dtd.toString());
			} else {
				doc = builder.parse(input);
			}
		}


		String log = meh.getLog();
		if (log.length() > 0) {
			String where = (filepath == null ? "an internal file" : filepath);
			String tmp = "Load " + where + ": \n" + log;

			throw new RuntimeException(tmp);
		}

		/*
		 * TRANSFORM : (direction depends on xslt file)
		 */

		// Create a transform factory instance.
		TransformerFactory tfactory = TransformerFactory.newInstance();

		// Create a transformer for the stylesheet.
		Transformer transformer = tfactory.newTransformer(new StreamSource(transformation.openStream()));

		// Transform the source XML
		// if (validate) {
		transformer.transform(new DOMSource(doc), new StreamResult(output));
		// } else {
		// transformer.transform(new StreamSource(input),
		// new StreamResult(output));
		// }

	}

	private void run2(InputStream input, OutputStream output,
			URL transformation, boolean validate) throws TransformerException, ParserConfigurationException, SAXException, IOException {

		// ErrorHandler handler = null;
		URL dtd = XsltTransformThreadTest.class.getResource(Rtd_corePlugin.TEMPLATES_PATH + "/evidence_0.2.dtd");

		if (validate) {

			Document doc = null;

			/*
			 * VALIDATE THE DOCUMENT
			 */
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setIgnoringElementContentWhitespace(true);
			factory.setIgnoringComments(true);
			factory.setValidating(validate);

			DocumentBuilder builder = factory.newDocumentBuilder();

			// if (handler == null) {
			MyErrHandler meh = new MyErrHandler();

			builder.setErrorHandler(meh);

			{
				if (validate && dtd != null) {
					doc = builder.parse(input, dtd.toString());
				} else {
					doc = builder.parse(input);
				}
			}


			String log = meh.getLog();
			if (log.length() > 0) {
				String where = (filepath == null ? "an internal file" : filepath);
				String tmp = "Load " + where + ": \n" + log;

				throw new RuntimeException(tmp);
			}

			/*
			 * TRANSFORM : (direction depends on xslt file)
			 */

			// Create a transform factory instance.
			TransformerFactory tfactory = TransformerFactory.newInstance();

			// Create a transformer for the stylesheet.
			Transformer transformer = tfactory.newTransformer(new StreamSource(transformation.openStream()));

			// Transform the source XML
			// if (validate) {
			transformer.transform(new DOMSource(doc), new StreamResult(output));
			// } else {
			// transformer.transform(new StreamSource(input),
			// new StreamResult(output));
			// }

		} else {
			// Create a transform factory instance.
			TransformerFactory tfactory = TransformerFactory.newInstance();

			// Create a transformer for the stylesheet.
			Transformer transformer = tfactory.newTransformer(new StreamSource(transformation.openStream()));

			// Transform the source XML
			transformer.transform(new StreamSource(input), new StreamResult(output));

		}


	}

}
