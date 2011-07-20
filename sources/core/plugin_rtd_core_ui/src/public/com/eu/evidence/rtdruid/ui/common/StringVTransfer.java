/*
 * Created on 28/nov/07
 *
 * $Id: StringVTransfer.java,v 1.1 2008/01/09 17:53:03 durin Exp $
 */
package com.eu.evidence.rtdruid.ui.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.swt.dnd.ByteArrayTransfer;
import org.eclipse.swt.dnd.TransferData;

public class StringVTransfer extends ByteArrayTransfer {

	public final static String RTOS_ID = "RTOS";
	public final static String TASK_ID = "Task";
	public final static String PROC_ID = "Proc";

	private static final String MY_TYPE_NAME = "StringV";

	private static final int MY_TYPE_ID = registerType(MY_TYPE_NAME);

	private static StringVTransfer _instance = new StringVTransfer();

	private StringVTransfer() {
	}

	public static StringVTransfer getInstance() {
		return _instance;
	}

	protected String[] getTypeNames() {
		return new String[] { MY_TYPE_NAME };
	}

	protected int[] getTypeIds() {
		return new int[] { MY_TYPE_ID };
	}

	public void javaToNative(Object object, TransferData transferData) {
		if (object == null || !(object instanceof String[]))
			return;

		if (isSupportedType(transferData)) {
			String[] myTypes = (String[]) object;
			try {
				// write data to a byte array and then ask super to convert to
				// pMedium
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				DataOutputStream writeOut = new DataOutputStream(out);

				for (int i = 0, length = myTypes.length; i < length; i++) {
					byte[] buffer = myTypes[i].getBytes();
					writeOut.writeInt(buffer.length);
					writeOut.write(buffer);
				}
				byte[] buffer = out.toByteArray();
				writeOut.close();

				super.javaToNative(buffer, transferData);

			} catch (IOException e) {
			}
		}
	}

	public Object nativeToJava(TransferData transferData) {

		if (isSupportedType(transferData)) {

			try {
			byte[] buffer = (byte[]) super.nativeToJava(transferData);
			if (buffer == null)
				return null;

			ArrayList<String> myData = new ArrayList<String>();
			try {
				ByteArrayInputStream in = new ByteArrayInputStream(buffer);
				DataInputStream readIn = new DataInputStream(in);
				while (readIn.available() > 1) {
					String datum = new String();
					int size = readIn.readInt();
					byte[] name = new byte[size];
					readIn.read(name);
					datum = new String(name);

					myData.add(datum);
				}
				readIn.close();
			} catch (IOException ex) {
				return null;
			}
			return myData.toArray(new String[myData.size()]);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}

		return null;
	}

}
