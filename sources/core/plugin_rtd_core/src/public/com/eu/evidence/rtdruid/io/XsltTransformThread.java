package com.eu.evidence.rtdruid.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import com.eu.evidence.rtdruid.desk.RtdruidLog;

/**
 * This class is able to read from a stream, transform it and put the output in
 * another stream, using an additional thread.
 * 
 * The input stream should be an xml file and the transformation file is a xlst
 * file. The output, usually, is an xml file.
 * 
 * @author Nicola Serreli
 * 
 */
class XsltTransformThread extends Thread {
	static class MyErrHandler implements ErrorHandler {

		StringBuffer buff = new StringBuffer();

		public void error(SAXParseException e) throws SAXException {
			buff.append("syntax error at line " + e.getLineNumber() + " : "
					+ e.getMessage() + " \n");
			// System.err.println("syntax error at line " +
			// e.getLineNumber()
			// + " : " + e.getMessage());
		}

		public void fatalError(SAXParseException e) throws SAXException {
			buff.append("fatal error at line " + e.getLineNumber() + " : "
					+ e.getMessage() + " \n");
			// System.err.println("fatal error at line " +
			// e.getLineNumber()
			// + " : " + e.getMessage());
		}

		public void warning(SAXParseException e) throws SAXException {
			buff.append("syntax warning at line " + e.getLineNumber() + " : "
					+ e.getMessage() + " \n");
			// System.err.println("syntax warning at line " +
			// e.getLineNumber()
			// + " : " + e.getMessage());
		}

		public String getLog() {
			return buff.toString();
		}
	}

	private InputStream input;
	private OutputStream output;
	private URL transformation;
	private URL dtd = null;
	private boolean close;
	private boolean validate = true;

	private boolean exception = false;

	private ErrorHandler handler = null;

	private String filePath = null;

	/**
	 * Builds a new instance of this tranformer.
	 * 
	 * @param input
	 *            contains the data that have to be transformed
	 * @param output
	 *            where store the output of the transformation
	 * @param transformation
	 *            the address of the transformation style sheet (xslt)
	 * @param close
	 *            if true, this class will try to close the output after the end
	 *            of the transformation
	 * @param validate
	 *            it contains the URL of a DTD that should be used to validate
	 *            the input xml. If this parameter is null, this class will not
	 *            validate the input.
	 */
	public XsltTransformThread(InputStream input, OutputStream output,
			URL transformation, boolean close, URL validate) {
		this.input = input;
		this.output = output;
		this.transformation = transformation;
		this.close = close;
		this.validate = validate != null;
		this.dtd = validate;
	}

	/**
	 * This method allows to set the path of the input file/stream, in order to
	 * identify it in a error message, if an error occur.
	 * 
	 * @param filePath
	 *            an identificator for the input
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public void run() {

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
								String where = (filePath == null ? "an internal file"
										: filePath);
								String tmp = "Load " + where + ": \n" + log;
// TODO : far arrivare fuori questa eccezione
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
					addException(e);

				} catch (ParserConfigurationException e) {
					addException(e);

				} catch (SAXException e) {
					addException(e);
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
					transformer.transform(new DOMSource(doc), new StreamResult(
							output));
				} catch (IOException e) {
					addException(e);

				} catch (TransformerConfigurationException e) {
					addException(e);

				} catch (TransformerException e) {
					addException(e);

				}

			} else {

				/*
				 * TRANSFORM : (direction depends on xslt file)
				 */

//				try {
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
//				} catch (IOException e) {
//					addException(e);
//
//				} catch (TransformerConfigurationException e) {
//					addException(e);
//
//				} catch (TransformerException e) {
//					addException(e);
//
//				}

			}

		} catch (Throwable e) {
			addException(e);
		} finally {
			if (close) {
				try {
					output.close();
				} catch (IOException e) {
					addException(e);
				}
			}
		}

	}

	private synchronized void addException(Throwable e) {
		exception = true;

		throw new RuntimeException(e.getMessage());
	}

	public synchronized boolean getException() {
		return exception;
	}

	public void setLoadHandler(ErrorHandler newHandler) {
		handler = newHandler;
	}

}
