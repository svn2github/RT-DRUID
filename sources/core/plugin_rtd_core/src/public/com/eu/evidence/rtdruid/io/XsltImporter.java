package com.eu.evidence.rtdruid.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.net.URL;
import java.util.Map;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;

/**
 * This class implements a IRTDImporter that uses an xslt file to convert the
 * generic xml file to ertd formalism.
 * 
 * @author Nicola Serreli
 */
public class XsltImporter implements IRTDImporter {

	/** The xslt transformation file */
	protected URL xsltFile;
	/** The dtd used to validate the input document */
	protected URL dtdFile;

	/**
	 * Builds an new Importer
	 * 
	 * @param xsltFile
	 *            the xslt transformation file. Cannot be null
	 * @param dtdFile
	 *            the dtd uset to validate the input. Null means that no
	 *            validation is done.
	 */
	public XsltImporter(URL xsltFile, URL dtdFile) {
		Assert.isNotNull(xsltFile);
		this.xsltFile = xsltFile;
		this.dtdFile = dtdFile;
	}

	
	public EObject load(InputStream input,
			Map<?, ?> options) throws IOException {

		PipedInputStream inPipe = new PipedInputStream();
		PipedOutputStream outPipe = new PipedOutputStream(inPipe);
		// PipedOutputStream outPipe = new DebugPipedOutputStream(inPipe);

		XsltTransformThread tt = new XsltTransformThread(input, outPipe,
				xsltFile, true, dtdFile);
		tt.start();

		IRTDImporter parent = (IRTDImporter) options.get(OPT_PARENT_IMPORTER);
		return parent.load(inPipe, options);

		/*
		 * if (tt.isAlive()) {
		 * System.err.println("Transformation Thread already alive !!!"); }
		 */
	}

	/**
	 * A class used to debug purposes.
	 * 
	 * @author Nicola Serreli
	 */
	protected static class DebugPipedOutStream extends PipedOutputStream {
		public DebugPipedOutStream(PipedInputStream snk) throws IOException {
			super(snk);
		}

		public void write(int b) throws IOException {
			System.out.print((char) b);
			super.write(b);
		}

		public void write(byte[] b, int off, int len) throws IOException {
			for (int i = off; i < b.length && (i - off < len); i++) {
				System.out.print(b[i]);
			}
			super.write(b, off, len);
		}
	};
}
