package com.eu.evidence.rtdruid.io;

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
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;

import com.eu.evidence.rtdruid.Rtd_corePlugin;
import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.io.XsltTransformThread.MyErrHandler;

public class XsltTransformThreadTest {

	private static final String filepath = "/xmi_example.xml";

	private InputStream getInput() {
		return XsltTransformThreadTest.class.getResourceAsStream(filepath);
	}

	private URL getXmi2Rtd() {
		// final URL XMI_2_XML =
		return RTDXsltImportExport.getXMI_2_XML();
//		return RTDXsltImportExport.class
//				.getResource(Rtd_corePlugin.TEMPLATES_PATH
//						+ "/EMFxmi_2_xml.xsl");
	}

	private URL getRtd2Xmi() {
		// final URL XMI_2_XML =
		return RTDXsltImportExport.getXML_2_XMI();
//		return RTDXsltImportExport.class
//				.getResource(Rtd_corePlugin.TEMPLATES_PATH
//						+ "/xml_2_EMFxmi.xsl");
	}

	private URL getRtdDTD() {
		// final URL XMI_2_XML =
		return RTDXsltImportExport.getLastDtdFile();
	}

	private void handleException(Throwable e) {
		e.printStackTrace();
		Assert.fail(e.getMessage());
	}

	@Test
	public void testLoadDoc() {
		// final URL urlFile =
		// XsltTransformThreadTest.class.getResource(filepath);

		InputStream input = getInput();
		byte[] output = null;

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setIgnoringElementContentWhitespace(true);
		factory.setIgnoringComments(true);
		factory.setValidating(false);

		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			Document doc;

			MyErrHandler meh = new MyErrHandler();

			builder.setErrorHandler(meh);

			try {
				doc = builder.parse(input);
			} finally {

				String log = meh.getLog();
				if (log.length() > 0) {
					String where = (filepath == null ? "an internal file"
							: filepath);
					String tmp = "Load " + where + ": \n" + log;

					RtdruidLog.log(new RuntimeException(tmp));
				}

			}

			Assert.assertTrue(doc != null);
			Assert.assertTrue(doc.getDocumentElement() != null);

			Transformer transformer;
			try {
				transformer = TransformerFactory.newInstance().newTransformer();
				transformer.setOutputProperty(OutputKeys.INDENT, "no");

				ByteArrayOutputStream tmp = new ByteArrayOutputStream();

				// Transform the source XML
				transformer
						.transform(new DOMSource(doc), new StreamResult(tmp));

				output = tmp.toByteArray();
				// System.out.println(tmp);

			} catch (TransformerConfigurationException tce) {
				handleException(tce);
			} catch (TransformerException te) {
				handleException(te);
			}

		} catch (ParserConfigurationException e) {
			handleException(e);
		} catch (IOException e) {
			handleException(e);
		} catch (SAXException e) {
			handleException(e);
		}

		try {
			input.close();
		} catch (Exception e) {
			// nothing
		}

		// input = XsltTransformThreadTest.class.getResourceAsStream(filepath);
		//
		// try {
		// int a;
		// int i=0;
		// int size = output.length;
		//			
		// while ((a=input.read()) >-1) {
		// if (i> size) {
		// Assert.fail("output different from input (lenght)");
		// }
		// if (a != output[i]) {
		// Assert.fail("output different from input ("
		// + ((char) a) + " " + ((char) output[i]) + ") pos " + i);
		// }
		// System.out.print((char) a);
		//				
		//				
		// i++;
		// }
		// if (i!= size) {
		// Assert.fail("output different from input (lenght)");
		// }
		// } catch (IOException e) {
		// Assert.fail(e.getMessage());
		// }
	}

	@Test
	public void testRun() {
		final String filepath = "/xmi_example.xml";

		InputStream input = getInput();
		ByteArrayOutputStream output = new ByteArrayOutputStream();

		final URL XMI_2_XML = getXmi2Rtd();

		XsltTransformThread thread = new XsltTransformThread(input, output,
				XMI_2_XML, false, null);

		thread.run();
	}

	@Test
	public void testTransform() {

		System.out.println("\n***********\n*\n* DIRECT ) \n*\n***********");

		final String filepath = "/xmi_example.xml";

		InputStream input = XsltTransformThreadTest.class
				.getResourceAsStream(filepath);
		ByteArrayOutputStream output = new ByteArrayOutputStream();

		try {
			// Create a transform factory instance.
			TransformerFactory tfactory = TransformerFactory.newInstance();

			// Create a transformer for the stylesheet.
			Transformer transformer = tfactory.newTransformer(new StreamSource(
					getXmi2Rtd().openStream()));

			// Transform the source XML
			transformer.transform(new StreamSource(input), new StreamResult(
					output));

			System.out.println(output.toString());
		} catch (IOException e) {
			handleException(e);
		} catch (TransformerConfigurationException e) {
			handleException(e);
		} catch (TransformerException e) {
			handleException(e);
		}
		
		
	}

	@Test
	public void testTransform2() {

		System.out.println("\n***********\n*\n* USE RUN \n*\n***********");

		final String filepath = "/xmi_example.xml";

		InputStream input = XsltTransformThreadTest.class
				.getResourceAsStream(filepath);
		ByteArrayOutputStream output = new ByteArrayOutputStream();

		run(input, output, getXmi2Rtd(), false);

		System.out.println(output.toString());

	}
	
	
	@Test
	public void testCompareRunAndDirect() {

		System.out.println("\n***********\n*\n* Compare ) \n*\n***********");

		final String filepath = "/xmi_example.xml";
		String output_direct;
		String output_run;
		{
	
			InputStream input = XsltTransformThreadTest.class
					.getResourceAsStream(filepath);
			ByteArrayOutputStream output = new ByteArrayOutputStream();
	
			try {
				// Create a transform factory instance.
				TransformerFactory tfactory = TransformerFactory.newInstance();
	
				// Create a transformer for the stylesheet.
				Transformer transformer = tfactory.newTransformer(new StreamSource(
						getXmi2Rtd().openStream()));
	
				// Transform the source XML
				transformer.transform(new StreamSource(input), new StreamResult(
						output));
	
				System.out.println(output.toString());
			} catch (IOException e) {
				handleException(e);
			} catch (TransformerConfigurationException e) {
				handleException(e);
			} catch (TransformerException e) {
				handleException(e);
			}
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
		Assert.assertTrue( ! output_direct.equals(output_run));
	}
	
	
	@Test
	public void testCompareRunAndDirect2() {

		System.out.println("\n***********\n*\n* Compare run2) \n*\n***********");

		final String filepath = "/xmi_example.xml";
		String output_direct;
		String output_run;
		{
	
			InputStream input = XsltTransformThreadTest.class
					.getResourceAsStream(filepath);
			ByteArrayOutputStream output = new ByteArrayOutputStream();
	
			try {
				// Create a transform factory instance.
				TransformerFactory tfactory = TransformerFactory.newInstance();
	
				// Create a transformer for the stylesheet.
				Transformer transformer = tfactory.newTransformer(new StreamSource(
						getXmi2Rtd().openStream()));
	
				// Transform the source XML
				transformer.transform(new StreamSource(input), new StreamResult(
						output));
	
				System.out.println(output.toString());
			} catch (IOException e) {
				handleException(e);
			} catch (TransformerConfigurationException e) {
				handleException(e);
			} catch (TransformerException e) {
				handleException(e);
			}
			output_direct = output.toString();
		}

		{
			InputStream input = XsltTransformThreadTest.class
					.getResourceAsStream(filepath);
			ByteArrayOutputStream output = new ByteArrayOutputStream();
	
			run2(input, output, getXmi2Rtd(), false);
			
			output_run = output.toString();

		}

		Assert.assertTrue(output_direct.equals(output_run));
	}

	

	@Test
	public void testCompareTransfThreadAndDirect() {

		System.out.println("\n***********\n*\n* Compare transformation thread) \n*\n***********");

		final String filepath = "/xmi_example.xml";
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

		Assert.assertTrue(output_direct.equals(output_run));
	}
	
	
//	@Test
//	public void testTransformBoth() {
	
//		disabled because "run()" function doesn't work correctly		
//
//		System.out.println("\n***********\n*\n* BOTH 1 ) \n*\n***********");
//
//		final String filepath = "/xmi_example.xml";
//
//		InputStream input = XsltTransformThreadTest.class
//				.getResourceAsStream(filepath);
//		ByteArrayOutputStream output = new ByteArrayOutputStream();
//
//		run(input, output, getXmi2Rtd(), false);
//
//		String outputTXT = output.toString();
//
//		System.out.println(outputTXT);
//
//		System.out.println("\n***********\n*\n* BOTH 2 ) \n*\n***********");
//
//		output = new ByteArrayOutputStream();
//		run(new ByteArrayInputStream(outputTXT.getBytes()), output,
//				getRtd2Xmi(), false);
//
//		String outputTXT2 = output.toString();
//		System.out.println(outputTXT2);
//	}
	

	
	@Test
	public void testTransformBoth2() {

		System.out.println("\n***********\n*\n* BOTH USING SPLI Tfunction - 1 ) \n*\n***********");

		final String filepath = "/xmi_example.xml";

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

		final String filepath = "/xmi_example.xml";

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
	 */
	private void run(InputStream input, OutputStream output, URL transformation,
			boolean validate) {

		ErrorHandler handler = null;
		URL dtd = XsltTransformThreadTest.class.getResource(Rtd_corePlugin.TEMPLATES_PATH + "/evidence_0.2.dtd");


		try {

			Document doc = null;

			/*
			 * VALIDATE THE DOCUMENT
			 */
			try {
				DocumentBuilderFactory factory = DocumentBuilderFactory
						.newInstance();
				factory.setIgnoringElementContentWhitespace(true);
				factory.setIgnoringComments(true);
				factory.setValidating(validate);

				DocumentBuilder builder = factory.newDocumentBuilder();

				if (handler == null) {
					MyErrHandler meh = new MyErrHandler();

					builder.setErrorHandler(meh);

					try {
						if (validate && dtd != null) {
							doc = builder.parse(input, dtd.toString());
						} else {
							doc = builder.parse(input);
						}
					} finally {

						String log = meh.getLog();
						if (log.length() > 0) {
							String where = (filepath == null ? "an internal file"
									: filepath);
							String tmp = "Load " + where + ": \n" + log;

							RtdruidLog.log(new RuntimeException(tmp));
						}

					}
				} else {
					builder.setErrorHandler(handler);
					if (validate && dtd != null) {
						doc = builder.parse(input, dtd.toString());
					} else {
						doc = builder.parse(input);
					}

				}

			} catch (IOException e) {
				handleException(e);
			} catch (ParserConfigurationException e) {
				handleException(e);
			} catch (SAXException e) {
				handleException(e);
			}

			if (doc == null) {
				return;
			}

			if (doc.getDocumentElement() == null) {
				return;
			}

			/*
			 * TRANSFORM : (direction depends on xslt file)
			 */

			try {
				// Create a transform factory instance.
				TransformerFactory tfactory = TransformerFactory.newInstance();

				// Create a transformer for the stylesheet.
				Transformer transformer = tfactory
						.newTransformer(new StreamSource(transformation
								.openStream()));

				// Transform the source XML
				// if (validate) {
				transformer.transform(new DOMSource(doc), new StreamResult(
						output));
				// } else {
				// transformer.transform(new StreamSource(input),
				// new StreamResult(output));
				// }
			} catch (IOException e) {
				handleException(e);
			} catch (TransformerConfigurationException e) {
				handleException(e);
			} catch (TransformerException e) {
				handleException(e);
			}
		} catch (Throwable e) {
			handleException(e);
		} finally {
			// if (close) {
			// try {
			// output.close();
			// } catch (IOException e) {
			// addException(e);
			// }
			// }
		}

	}

	public void run2(InputStream input, OutputStream output,
			URL transformation, boolean validate) {

		ErrorHandler handler = null;
		URL dtd = XsltTransformThreadTest.class.getResource(Rtd_corePlugin.TEMPLATES_PATH + "/evidence_0.2.dtd");
		
		try {

			if (validate) {

				Document doc = null;

				/*
				 * VALIDATE THE DOCUMENT
				 */
				try {
					DocumentBuilderFactory factory = DocumentBuilderFactory
							.newInstance();
					factory.setIgnoringElementContentWhitespace(true);
					factory.setIgnoringComments(true);
					factory.setValidating(validate);

					DocumentBuilder builder = factory.newDocumentBuilder();

					if (handler == null) {
						MyErrHandler meh = new MyErrHandler();

						builder.setErrorHandler(meh);

						try {
							if (validate && dtd != null) {
								doc = builder.parse(input, dtd.toString());
							} else {
								doc = builder.parse(input);
							}
						} finally {

							String log = meh.getLog();
							if (log.length() > 0) {
								String where = (filepath == null ? "an internal file"
										: filepath);
								String tmp = "Load " + where + ": \n" + log;

								RtdruidLog.log(new RuntimeException(tmp));
							}

						}
					} else {
						builder.setErrorHandler(handler);
						if (validate && dtd != null) {
							doc = builder.parse(input, dtd.toString());
						} else {
							doc = builder.parse(input);
						}

					}

				} catch (IOException e) {
					handleException(e);
				} catch (ParserConfigurationException e) {
					handleException(e);
				} catch (SAXException e) {
					handleException(e);
				}

				if (doc == null) {
					return;
				}

				if (doc.getDocumentElement() == null) {
					return;
				}

				/*
				 * TRANSFORM : (direction depends on xslt file)
				 */

				try {
					// Create a transform factory instance.
					TransformerFactory tfactory = TransformerFactory
							.newInstance();

					// Create a transformer for the stylesheet.
					Transformer transformer = tfactory
							.newTransformer(new StreamSource(transformation
									.openStream()));

					// Transform the source XML
					// if (validate) {
					transformer.transform(new DOMSource(doc), new StreamResult(
							output));
					// } else {
					// transformer.transform(new StreamSource(input),
					// new StreamResult(output));
					// }
				} catch (IOException e) {
					handleException(e);
				} catch (TransformerConfigurationException e) {
					handleException(e);
				} catch (TransformerException e) {
					handleException(e);
				}

			} else {

				try {
					// Create a transform factory instance.
					TransformerFactory tfactory = TransformerFactory
							.newInstance();

					// Create a transformer for the stylesheet.
					Transformer transformer = tfactory
							.newTransformer(new StreamSource(transformation
									.openStream()));

					// Transform the source XML
					transformer.transform(new StreamSource(input),
							new StreamResult(output));

				} catch (IOException e) {
					handleException(e);
				} catch (TransformerConfigurationException e) {
					handleException(e);
				} catch (TransformerException e) {
					handleException(e);
				}
			}

		} catch (Throwable e) {
			handleException(e);
		} finally {
			// if (close) {
			// try {
			// output.close();
			// } catch (IOException e) {
			// addException(e);
			// }
			// }
		}

	}

}
