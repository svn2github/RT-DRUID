package com.eu.evidence.rtdruid.io;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.net.URL;
import java.util.Map;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;

import com.eu.evidence.rtdruid.desk.RtdruidLog;

/**
 * This class implements a IRTDExporter that uses an xslt file to convert the
 * ertd (EMF) formalism to a generic xml file.
 * 
 * @author Nicola Serreli
 */
public class XsltExporter implements IRTDExporter {

	/** Enable some debug information */
	private final static boolean DEBUG = false;

	/** The xslt transformation file */
	protected URL xsltFile;

	/**
	 * Builds a new Exporter
	 * 
	 * @param xsltFile
	 *            the xslt transformation file. Cannot be null
	 */
	public XsltExporter(URL xsltFile) {
		Assert.isNotNull(xsltFile);
		this.xsltFile = xsltFile;
	}

	
	public void export(OutputStream outputStream,
			final EObject data,
			Map<?, ?> options) throws IOException {

		IRTDExporter parent = (IRTDExporter) options.get(OPT_PARENT_EXPORTER);

		InputStream inPipe = new PipedInputStream();
		PipedOutputStream outPipe = new PipedOutputStream((PipedInputStream)inPipe);

		OutputStream out = outputStream;
		if (DEBUG) {
			/**
			 * An BufferedOutputStream useful for debug purposes
			 * 
			 * @author Nicola Serreli
			 */
			out = new BufferedOutputStream(out) {
				public void write(int b) throws IOException {
					System.out.print((char) b);
					super.write(b);
				}

				public void write(byte[] b) throws IOException {
					write(b, 0, b.length);
				}

				public void write(byte[] b, int off, int len) throws IOException {
					for (int i = off; i < b.length && (i - off < len); i++) {
						System.out.print(b[i]);
					}
					super.write(b, off, len);
				}
			};
		}

		class EMFThread extends Thread {
			IRTDExporter th_res;
			OutputStream th_output;
			Map<?, ?> th_options;

			public EMFThread(IRTDExporter res, OutputStream output,
					Map<?, ?> options) {
				th_res = res;
				th_output = output;
				th_options = options;
			}

			public void run() {
				try {
					th_res.export(th_output, data, th_options);
				} catch (IOException e) {
					RtdruidLog.log(e);
				} finally {
					try {
						th_output.close();
					} catch (IOException e) {
					}
				}
			}
		}
		EMFThread tt2 = new EMFThread(parent, outPipe, options);
		tt2.start();

		if (DEBUG) {
			StringBuffer buff = new StringBuffer();
			try {
				int a;
				while ( (a = inPipe.read()) != -1) {
					buff.append((char) a);
				}
			} catch(IOException e) {
				buff.append("\nERROR\n"+e.getMessage());
			}
			System.err.println(buff);
			
			// IMPORTANT !!! 
			// fill again the input for the next step !!!
			inPipe = new ByteArrayInputStream(buff.toString().getBytes());
		}

		XsltTransformThread tt = new XsltTransformThread(inPipe, out,
				xsltFile, false, null);
		tt.run(); // !!!!!

		try {
			tt2.join();
		} catch (InterruptedException e) {
			if (DEBUG) {
				e.printStackTrace();
			}
		}


	}
}
