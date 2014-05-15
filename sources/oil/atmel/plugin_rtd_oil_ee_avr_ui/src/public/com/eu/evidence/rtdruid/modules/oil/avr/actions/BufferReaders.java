/*
 * Created on 17/lug/07
 *
 * $Id: BufferReaders.java,v 1.1 2007/07/18 06:53:03 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.avr.actions;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.eu.evidence.rtdruid.desk.Messages;
import com.eu.evidence.rtdruid.desk.RtdruidLog;

interface BufferReaders {

	/**
	 * This method wait untill the internal process is finished
	 */
	public void waitFinish();

	// -----------------------------------------------------------------

	/**
	 * This class uses a Thread to costantly read data from an input stream and
	 * throw it away (like /dev/null )
	 * 
	 * @author Nicola Serreli
	 */
	public static class NullBuffRd implements BufferReaders {
		private Thread t;

		public NullBuffRd(final InputStream input) {
			try {
				(t = new Thread(new Runnable() {

					public void run() {
						try {
							InputStream in = new BufferedInputStream(input);
							for (int a = in.read(); a != -1; a = in.read()) {
								output((char) a);
							}
						} catch (IOException e) {
							RtdruidLog.log(e);
						}
						end();
					}

				})).start();
			} catch (Throwable e) {
				RtdruidLog.log(e);
			}
		}

		/**
		 * This method wait untill the internal process is finished
		 */
		public void waitFinish() {
			try {
				t.join();
			} catch (InterruptedException e) {
				RtdruidLog.log(e);
			}
		}

		/**
		 * This method is called when the input stream is closed or there was an
		 * exception
		 */
		protected void end() {
		}

		/**
		 * This method redirects input data
		 */
		protected void output(char c) {
			// do nothing
		}
	}

	// -----------------------------------------------------------------

	/**
	 * This class uses a Thread to costantly read data from an input stream and
	 * shows them using the System.out
	 * 
	 * @author Nicola Serreli
	 */
	public static class BuffRd2StdOut extends NullBuffRd {

		public BuffRd2StdOut(final InputStream input) {
			super(input);
		}

		/**
		 * This method redirects input data to Standard Output
		 */
		protected void output(char c) {
			System.out.print(c);
		}
	}

	// -----------------------------------------------------------------

	/**
	 * This class uses a Thread to costantly read data from an input stream and
	 * shows them using the System.err
	 * 
	 * @author Nicola Serreli
	 */
	public static class BuffRd2StdErr extends NullBuffRd {

		public BuffRd2StdErr(final InputStream input) {
			super(input);
		}

		/**
		 * This method redirects input data to Standard Error
		 */
		protected void output(char c) {
			System.err.print(c);
		}
	}

	// -----------------------------------------------------------------

	/**
	 * This class uses a Thread to costantly read data from an input stream and
	 * shows them using the System.out
	 * 
	 * @author Nicola Serreli
	 */
	public static class BuffRd2MsgStdOut extends NullBuffRd {
		private StringBuffer buffer = new StringBuffer(); 
		
		public BuffRd2MsgStdOut(final InputStream input) {
			super(input);
		}

		/**
		 * This method redirects input data to Standard Output
		 */
		protected void output(char c) {
			if (c == '\n') {
				Messages.sendTextNl(buffer.toString(), null, null, null);
				buffer.setLength(0);
			} else {
				buffer.append(c);
			}
		}
		
		/**
		 * This method redirects input data to Standard Output
		 */
		protected void end() {
			if (buffer.length() != 0) {
				Messages.sendTextNl(buffer.toString(), null, null, null);
				buffer.setLength(0);
			}
		}
	}

	// -----------------------------------------------------------------

	/**
	 * This class uses a Thread to costantly read data from an input stream and
	 * shows them using the System.err
	 * 
	 * @author Nicola Serreli
	 */
	public static class BuffRd2MsgStdErr extends NullBuffRd {
		private StringBuffer buffer = new StringBuffer(); 
		
		public BuffRd2MsgStdErr(final InputStream input) {
			super(input);
		}

		/**
		 * This method redirects input data to Standard Error
		 */
		protected void output(char c) {
			if (c == '\n') {
				Messages.sendErrorNl(buffer.toString(), null, null, null);
				buffer.setLength(0);
			} else {
				buffer.append(c);
			}
		}
		
		/**
		 * This method redirects input data to Standard Output
		 */
		protected void end() {
			if (buffer.length() != 0) {
				Messages.sendErrorNl(buffer.toString(), null, null, null);
				buffer.setLength(0);
			}
		}

	}

	// -----------------------------------------------------------------

	/**
	 * This class uses a Thread to costantly read data from an input stream and
	 * shows them using the System.err
	 * 
	 * @author Nicola Serreli
	 */
	public static class BuffRd2Buffer extends NullBuffRd {
		protected ByteArrayOutputStream buff;

		public BuffRd2Buffer(final InputStream input,
				ByteArrayOutputStream output) {
			super(input);
			buff = output;
		}

		/**
		 * This method redirects input data to Standard Error
		 */
		protected void output(char c) {
			buff.write(c);
		}
	}

}
