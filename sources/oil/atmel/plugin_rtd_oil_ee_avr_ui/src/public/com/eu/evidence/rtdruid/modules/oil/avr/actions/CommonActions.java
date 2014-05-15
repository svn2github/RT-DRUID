/*
 * Created on 19/lug/07
 *
 * $Id: CommonActions.java,v 1.1 2007/07/20 06:57:06 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.avr.actions;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.cdt.internal.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.eu.evidence.rtdruid.desk.Messages;
import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.modules.oil.avr.preferencepages.Parameters;
import com.eu.evidence.rtdruid.ui.common.RTDConsole;

public class CommonActions {

	/**
	 * A class that erase memory and shows the status in the RTDConsole
	 * 
	 * @author Nicola Serreli
	 */
	public static class EraseAct implements IRunnableWithProgress {
		public void run(IProgressMonitor monitor)
				throws InvocationTargetException, InterruptedException {

			monitor.beginTask("Erase FLash Memory", 1);

			boolean outputEnable = false;
			try {
				RTDConsole console = RTDConsole.getConsole();
				if (console != null && console.getMessages() != null) {
					Messages.setCurrent(console.getMessages());
					Messages.clearNumbers();
					// console.clear();
					outputEnable = true;
				}

				Messages.sendTextNl("Erase Flash Memory");

				{ // check the serial port
					String tty = Parameters.instance.getDevTty();
					if (tty == null || tty.length() == 0) {
						Messages
								.sendError(
										"Please, set a serial port using window->preference->RTDruid->Oil->Avr",
										null, null, null);

						return; // --> EXIT
					}
				}

				final String command = Parameters.instance.getCommand_Erase();
				Messages.sendTextNl("\t" + command);

				// EXEC the command
				try {
					Process p = Runtime.getRuntime().exec(command);

					new BufferReaders.BuffRd2MsgStdOut(p.getInputStream());
					new BufferReaders.BuffRd2MsgStdOut(p.getErrorStream());

					int exitVal = p.waitFor();
					if (exitVal != 0) {
						Messages.sendErrorNl(
								"\nAbnormal termination (exit value = "
										+ exitVal + ")", null, null, null);
					}

				} catch (IOException e) {
					Messages.sendError("Cannot exec " + command, null, null,
							null);

				} catch (Throwable e) {
					Messages.sendError(e.getMessage() + command, null, null,
							null);
					RtdruidLog.log(e);
				}
			} finally {
				if (outputEnable)
					Messages.setPrevious();
			}

			// END
			monitor.worked(1);
		}
	};

	/**
	 * A class that disable JTag and shows the status in the RTDConsole
	 * 
	 * @author Nicola Serreli
	 */
	public static class JTagDisableAct implements IRunnableWithProgress {

		public void run(IProgressMonitor monitor)
				throws InvocationTargetException, InterruptedException {

			monitor.beginTask("Disable JTag", 1);

			boolean outputEnable = false;
			try {
				RTDConsole console = RTDConsole.getConsole();
				if (console != null && console.getMessages() != null) {
					Messages.setCurrent(console.getMessages());
					Messages.clearNumbers();
					// console.clear();
					outputEnable = true;
				}

				Messages.sendTextNl("Disable JTag");

				{ // check the serial port
					String tty = Parameters.instance.getDevTty();
					if (tty == null || tty.length() == 0) {
						Messages
								.sendError(
										"Please, set a serial port using window->preference->RTDruid->Oil->Avr",
										null, null, null);

						return; // --> EXIT
					}
				}

				final String command = Parameters.instance
						.getCommand_DisableJTag();
				Messages.sendTextNl("\t" + command);

				// EXEC the command
				try {
					Process p = Runtime.getRuntime().exec(command);

					new BufferReaders.BuffRd2MsgStdOut(p.getInputStream());
					new BufferReaders.BuffRd2MsgStdOut(p.getErrorStream());

					int exitVal = p.waitFor();
					if (exitVal != 0) {
						Messages.sendErrorNl(
								"\nAbnormal termination (exit value = "
										+ exitVal + ")", null, null, null);
					}

				} catch (IOException e) {
					Messages.sendError("Cannot exec " + command, null, null,
							null);

				} catch (Throwable e) {
					Messages.sendError(e.getMessage() + command, null, null,
							null);
					RtdruidLog.log(e);
				}
			} finally {
				if (outputEnable)
					Messages.setPrevious();
			}

			// END
			monitor.worked(1);
		}
	};

	/**
	 * A class that enable JTag and shows the status in the RTDConsole
	 * 
	 * @author Nicola Serreli
	 */
	public static class JTagEnableAct implements IRunnableWithProgress {

		public void run(IProgressMonitor monitor)
				throws InvocationTargetException, InterruptedException {

			monitor.beginTask("Enable JTag", 1);

			boolean outputEnable = false;
			try {
				RTDConsole console = RTDConsole.getConsole();
				if (console != null && console.getMessages() != null) {
					Messages.setCurrent(console.getMessages());
					Messages.clearNumbers();
					// console.clear();
					outputEnable = true;
				}

				Messages.sendTextNl("Enable JTag");

				{ // check the serial port
					String tty = Parameters.instance.getDevTty();
					if (tty == null || tty.length() == 0) {
						Messages
								.sendError(
										"Please, set a serial port using window->preference->RTDruid->Oil->Avr",
										null, null, null);

						return; // --> EXIT
					}
				}

				final String command = Parameters.instance
						.getCommand_EnableJTag();
				Messages.sendTextNl("\t" + command);

				// EXEC the command
				try {
					Process p = Runtime.getRuntime().exec(command);

					new BufferReaders.BuffRd2MsgStdOut(p.getInputStream());
					new BufferReaders.BuffRd2MsgStdOut(p.getErrorStream());

					int exitVal = p.waitFor();
					if (exitVal != 0) {
						Messages.sendErrorNl(
								"\nAbnormal termination (exit value = "
										+ exitVal + ")", null, null, null);
					}

				} catch (IOException e) {
					Messages.sendError("Cannot exec " + command, null, null,
							null);

				} catch (Throwable e) {
					Messages.sendError(e.getMessage() + command, null, null,
							null);
					RtdruidLog.log(e);
				}
			} finally {
				if (outputEnable)
					Messages.setPrevious();
			}

			// END
			monitor.worked(1);
		}
	};

	/**
	 * A class that reads fuses and shows the status in the RTDConsole
	 * 
	 * @author Nicola Serreli
	 */
	public static class ReadFuseAct implements IRunnableWithProgress {

		public void run(IProgressMonitor monitor)
				throws InvocationTargetException, InterruptedException {

			monitor.beginTask("ReadFuse", 1);

			boolean outputEnable = false;
			try {
				RTDConsole console = RTDConsole.getConsole();
				if (console != null && console.getMessages() != null) {
					Messages.setCurrent(console.getMessages());
					Messages.clearNumbers();
					// console.clear();
					outputEnable = true;
				}

				Messages.sendTextNl("Read Avr5 Fuse");

				{ // check the serial port
					String tty = Parameters.instance.getDevTty();
					if (tty == null || tty.length() == 0) {
						Messages
								.sendError(
										"Please, set a serial port using window->preference->RTDruid->Oil->Avr",
										null, null, null);

						return; // --> EXIT
					}
				}

				final String command = Parameters.instance
						.getCommand_ReadFuse();
				Messages.sendTextNl("\t" + command);

				// EXEC the command
				try {
					Process p = Runtime.getRuntime().exec(command);

					new BufferReaders.BuffRd2MsgStdOut(p.getInputStream());
					new BufferReaders.BuffRd2MsgStdOut(p.getErrorStream());

					int exitVal = p.waitFor();
					if (exitVal != 0) {
						Messages.sendErrorNl(
								"\nAbnormal termination (exit value = "
										+ exitVal + ")", null, null, null);
					}

				} catch (IOException e) {
					Messages.sendError("Cannot exec " + command, null, null,
							null);

				} catch (Throwable e) {
					Messages.sendError(e.getMessage() + command, null, null,
							null);
					RtdruidLog.log(e);
				}
			} finally {
				if (outputEnable)
					Messages.setPrevious();
			}

			// END
			monitor.worked(1);
		}
	};

	/**
	 * A class that program flash memory and shows the status in the RTDConsole
	 * 
	 * @author Nicola Serreli
	 */
	public static abstract class ProgrFlashAct implements IRunnableWithProgress {
		/** Contains the path of selected binary image */
		protected IFile binImg;
		/** The monitor (if there is one) */
		protected IProgressMonitor intMonitor;

		/** If setted to true, the process is aborted */
		protected boolean abort = false;

		public void run(IProgressMonitor monitor)
				throws InvocationTargetException, InterruptedException {

			intMonitor = monitor;

			monitor.beginTask("Program Flash Memory", 6);

			boolean outputEnable = false;
			try {
				RTDConsole console = RTDConsole.getConsole();
				if (console != null && console.getMessages() != null) {
					Messages.setCurrent(console.getMessages());
					Messages.clearNumbers();
					// console.clear();
					outputEnable = true;
				}

				Messages.sendTextNl("Program Avr5 Flash Memory ");

				{ // check the serial port
					String tty = Parameters.instance.getDevTty();
					if (tty == null || tty.length() == 0) {
						Messages
								.sendError(
										"Please, set a serial port using window->preference->RTDruid->Oil->Avr",
										null, null, null);

						return; // --> EXIT
					}
				}

				// ASK the "Binary Image"
				getBinImage();
				// CHECK if cancel was pressed
				if (abort) {
					monitor.setCanceled(true);
					return; // --->> EXIT !
				}
				monitor.worked(1);

				// PREPARE command
				String fileName = null;
				{
					Messages.sendTextNl("Writing " + binImg.getFullPath());

					if (!binImg.exists() || !binImg.isAccessible()) {
						Messages.sendErrorNl("\tSelected file cannot be read",
								null, "apisasdjdaqewqidjasodij", null);
						return; // --->> EXIT !
					}

					fileName = binImg.getLocation().toOSString();
					// } else if (o instanceof File) {
					// File f = (File) o;
					// Messages.sendTextNl("Writing " + f.getPath());
					// File parent = f.getParentFile();
					// String parentPath = parent == null ? null : parent
					// .getPath();
					//
					// IPath basePath = null;
					// if (parentPath != null) {
					//
					// IPath pt = new Path(parentPath);
					// if (pt.segmentCount() == 0) {
					// basePath = new Path("");
					//
					// } else if (pt.segmentCount() == 1) {
					// basePath = ResourcesPlugin.getWorkspace().getRoot()
					// .getProject(parentPath).getLocation();
					// } else {
					// basePath = ResourcesPlugin.getWorkspace().getRoot()
					// .getFolder(pt).getLocation();
					// }
					//
					// } else {
					// basePath = ResourcesPlugin.getWorkspace().getRoot()
					// .getLocation();
					// }
					// basePath.append(f.getName());
					//
					// File realFile = basePath.toFile();
					//
					// if (!realFile.canRead() || !realFile.exists()
					// || !realFile.isDirectory()) {
					// Messages.sendErrorNl("\tSelected file cannot be read",
					// null, "apisasdjdaqewqidjasodij", null);
					// return; // --->> EXIT !
					// }
					// fileName = basePath.toOSString();
				}
				monitor.worked(1);

				String command = "";

				// EXEC Erase -> write -> Verify
				try {

					// ERASE
					Messages.sendTextNl("\n\n\tErase Flash Memory ");
					command = Parameters.instance.getCommand_Erase();
					Process p = Runtime.getRuntime().exec(command);

					new BufferReaders.BuffRd2MsgStdOut(p.getInputStream());
					new BufferReaders.BuffRd2MsgStdOut(p.getErrorStream());

					int exitVal = p.waitFor();
					if (exitVal != 0) {
						Messages.sendErrorNl(
								"\nAbnormal termination (exit value = "
										+ exitVal + ")", null, null, null);
						return; // ---> EXIT
					}
					monitor.worked(1);

					// WRITE
					Messages.sendTextNl("\n\n\tWrite binary image");
					command = Parameters.instance.getCommand_Program(fileName);
					p = Runtime.getRuntime().exec(command);

					new BufferReaders.BuffRd2MsgStdOut(p.getInputStream());
					new BufferReaders.BuffRd2MsgStdOut(p.getErrorStream());

					exitVal = p.waitFor();
					if (exitVal != 0) {
						Messages.sendErrorNl(
								"\nAbnormal termination (exit value = "
										+ exitVal + ")", null, null, null);
					}
					monitor.worked(1);

					if (false) {// VERIFY
						Messages.sendTextNl("\n\n\tVerify data ");
						command = Parameters.instance
								.getCommand_Verify(fileName);
						p = Runtime.getRuntime().exec(command);

						new BufferReaders.BuffRd2MsgStdOut(p.getInputStream());
						new BufferReaders.BuffRd2MsgStdOut(p.getErrorStream());

						exitVal = p.waitFor();
						if (exitVal != 0) {
							Messages.sendErrorNl(
									"\nAbnormal termination (exit value = "
											+ exitVal + ")", null, null, null);
						}
						monitor.worked(1);
					}

				} catch (IOException e) {
					Messages.sendError("Cannot exec " + command, null, null,
							null);

				} catch (Throwable e) {
					Messages.sendError(e.getMessage() + command, null, null,
							null);
					RtdruidLog.log(e);
				}
			} finally {
				if (outputEnable)
					Messages.setPrevious();
			}

			// END
			monitor.worked(1);
		}

		abstract void getBinImage();
	} // end ProgrFlashAct

	/**
	 * A class that verifies the flash memory and shows the status in the
	 * RTDConsole
	 * 
	 * @author Nicola Serreli
	 */
	public static abstract class VerifyAct implements IRunnableWithProgress {
		/** Contains the path of selected binary image */
		protected IFile binImg;

		/** The monitor (if there is one) */
		protected IProgressMonitor intMonitor;

		/** If setted to true, the process is aborted */
		protected boolean abort = false;

		public void run(IProgressMonitor monitor)
				throws InvocationTargetException, InterruptedException {

			intMonitor = monitor;

			monitor.beginTask("Verify Flash Memory", 6);

			boolean outputEnable = false;
			try {
				RTDConsole console = RTDConsole.getConsole();
				if (console != null && console.getMessages() != null) {
					Messages.setCurrent(console.getMessages());
					Messages.clearNumbers();
					// console.clear();
					outputEnable = true;
				}

				Messages.sendTextNl("Verify Avr5 Flash Memory ");

				{ // check the serial port
					String tty = Parameters.instance.getDevTty();
					if (tty == null || tty.length() == 0) {
						Messages
								.sendError(
										"Please, set a serial port using window->preference->RTDruid->Oil->Avr",
										null, null, null);

						return; // --> EXIT
					}
				}

				// ASK the "Binary Image"
				getBinImage();
				// CHECK if cancel was pressed
				if (abort) {
					monitor.setCanceled(true);
					return; // --->> EXIT !
				}
				monitor.worked(1);

				// PREPARE command
				String fileName = null;
				{
					Messages.sendTextNl("Verifing " + binImg.getFullPath());

					if (!binImg.exists() || !binImg.isAccessible()) {
						Messages.sendErrorNl("\tSelected file cannot be read",
								null, "apisasdjdaqewqidjasodij", null);
						return; // --->> EXIT !
					}

					fileName = binImg.getLocation().toOSString();
				}
				monitor.worked(1);

				String command = "";

				// EXEC Verify
				try {
					// VERIFY
					command = Parameters.instance.getCommand_Verify(fileName);
					Process p = Runtime.getRuntime().exec(command);

					new BufferReaders.BuffRd2MsgStdOut(p.getInputStream());
					new BufferReaders.BuffRd2MsgStdOut(p.getErrorStream());

					int exitVal = p.waitFor();
					if (exitVal != 0) {
						Messages.sendErrorNl(
								"\nAbnormal termination (exit value = "
										+ exitVal + ")", null, null, null);
						return; // ---> EXIT
					}
					monitor.worked(1);

				} catch (IOException e) {
					Messages.sendError("Cannot exec " + command, null, null,
							null);

				} catch (Throwable e) {
					Messages.sendError(e.getMessage() + command, null, null,
							null);
					RtdruidLog.log(e);
				}
			} finally {
				if (outputEnable)
					Messages.setPrevious();
			}

			// END
			monitor.worked(1);
		}

		abstract void getBinImage();
	} // end Verify

	/**
	 * Searchs all *.srec files in every directory form specified root. It can
	 * be a folder or a project or the whole workspace
	 * 
	 * @param root
	 *            the Container where start the search
	 * @param monitor
	 *            a progress monitor
	 * 
	 * @return all found files with extention srec
	 */
	static protected IFile[] searchSRec(IContainer root,
			IProgressMonitor monitor) {
		ArrayList<IResource> answer = new ArrayList<IResource>();
		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}

		monitor.beginTask("Search +.srec files in "
				+ root.getFullPath().toString(), IProgressMonitor.UNKNOWN);
		searchSRec(root, answer, monitor);

		if (monitor.isCanceled()) {
			return new IFile[0];
		}
		monitor.worked(1);

		return answer.toArray(new IFile[answer.size()]);
	}

	/**
	 * Iteratly searchs all *.srec files in every directory form specified root.
	 * It can be a folder or a project or the whole workspace
	 * 
	 * @param root
	 *            the Container where start the search
	 * @param found
	 *            where store every found file
	 */
	static private void searchSRec(IContainer root, ArrayList<IResource> found,
			IProgressMonitor monitor) {
		boolean includePhantoms = false;
		IResource[] children = new IResource[0];
		try {
			children = root.members(includePhantoms);
		} catch (CoreException e) {
			RtdruidLog.log(e);
		}

		monitor.subTask("Search +.srec files in "
				+ root.getFullPath().toString());

		// first files
		for (int i = 0; i < children.length; i++) {

			// a file
			if (children[i] instanceof IFile) {

				// a srec file
				if ("srec".equalsIgnoreCase(((IFile) children[i])
						.getFileExtension())) {
					found.add(children[i]);
				}

				if (monitor.isCanceled()) {
					found.clear();
					return;
				}
				monitor.worked(1);
			}
		}

		// then containers
		for (int i = 0; i < children.length; i++) {

			// a container
			if (children[i] instanceof IContainer) {
				searchSRec((IContainer) children[i], found, monitor);

				if (monitor.isCanceled()) {
					found.clear();
					return;
				}
				monitor.worked(1);
			}

		}

	}

	/**
	 * 
	 * @param shell
	 *            current shell
	 * @param files
	 *            the list of files (not null, with size >0)
	 * 
	 * @return the choosed file or null if user pressed cancel button
	 * 
	 */
	static protected IFile askBinImage(final Shell shell, IFile[] files,
			final IFile defaultValue) {

		if (files == null || files.length == 0)
			return null;

		// NOTE : if this array contains 0 element means the cancel button
		// was pressed
		final ArrayList<Object> choosed = new ArrayList<Object>();

		// sort files
		final List<IFile> list = Arrays.asList(files);
		Collections.sort(list, new Comparator<IFile>() {

			public int compare(IFile arg0, IFile arg1) {
				// cannot be null
				String p0 = ((IFile) arg0).getFullPath().toString();
				String p1 = ((IFile) arg1).getFullPath().toString();

				return p0.compareTo(p1);
			}

		});

		// ASK the "Binary Image"
		try {
			final Display display = shell.getDisplay();
			display.syncExec(new Runnable() {
				public void run() {

					// show the file name as text
					ILabelProvider labProv = new LabelProvider() {
						public String getText(Object element) {
							if (element instanceof IFile) {
								IFile f = (IFile) element;
								return f.getFullPath().toString();
							}
							return "" + element;
						}
					};

					ElementListSelectionDialog dialog = new ElementListSelectionDialog(
							shell, labProv, false, false);
					final int exitVal;
					if (defaultValue == null) {
						exitVal = dialog.open(list);
					} else {
						exitVal = dialog.open(list, defaultValue.getFullPath()
								.toString());
					}
					if (exitVal == Dialog.OK) {
						Object[] r = dialog.getResult();
						if (r.length > 0)
							choosed.add(r[0]);
					}

				}
			});
		} catch (Throwable e) {
			RtdruidLog.log(e);
		}

		return choosed.size() == 0 ? null : (IFile) choosed.get(0);
	}

}
