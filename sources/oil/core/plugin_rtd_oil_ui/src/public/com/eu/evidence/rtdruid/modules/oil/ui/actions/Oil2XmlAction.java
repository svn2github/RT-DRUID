package com.eu.evidence.rtdruid.modules.oil.ui.actions;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.w3c.dom.Document;

import com.eu.evidence.rtdruid.desk.Messages;
import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OilReaderFactory;
import com.eu.evidence.rtdruid.ui.common.RTDConsole;

public class Oil2XmlAction implements IObjectActionDelegate {

	/** Remembers the previous selection */
	protected static IFile element;
//
//	/** Remembers the previous choosed file */
//	protected static IFile previous = null;
	
	/** The shell */
	private Shell shell;

	/**
	 * The constructor.
	 */
	public Oil2XmlAction() {
	}

	/**
	 * The action has been activated. The argument of the method represents the
	 * 'real' action sitting in the workbench UI.
	 * 
	 * @see IWorkbenchWindowActionDelegate#run
	 */
	public void run(IAction action) {

		try {
			
			IRunnableWithProgress op = new IRunnableWithProgress() {

				public void run(IProgressMonitor monitor)
						throws InvocationTargetException, InterruptedException {

					if (element == null) {
						return;
					}
					monitor.beginTask("Converting an autosar file into a RT-Druid file", IProgressMonitor.UNKNOWN);

					boolean outputEnable = false;
					String rtd_name = "";
					try {
						RTDConsole console = RTDConsole.getConsole();
						if (console != null && console.getMessages() != null) {
							Messages.setCurrent(console.getMessages());
							Messages.clearNumbers();
							// console.clear();
							outputEnable = true;
						}

						Messages.sendTextNl("Converting an oil file into a xml file");

						
						// open the autosar file
						if (!element.isAccessible()) {
							Messages.sendErrorNl("Cannot open the autosar file", null, "autosar_convertion_1", null);
							return;
						}
						
						// new rtd_file name
						rtd_name = element.getName();
						String autosar_ext = element.getFileExtension();
						if (autosar_ext != null && rtd_name.length()>(autosar_ext.length()+1)) {
							rtd_name = rtd_name.substring(0, rtd_name.length()-(autosar_ext.length()+1));
						}
						
						rtd_name += ".xml"; // add the extention

						IContainer parent = element.getParent();
						
						IResource res = parent.findMember(rtd_name);
						if (res != null) {
							if( !(res instanceof IFile) || !res.isAccessible()) {
								Messages.sendErrorNl("Cannot write the rtdfile ("+rtd_name+")", null, "autosar_convertion_2", null);
								return;
							}
						} else {
							res = parent.getFile(new Path(rtd_name));
						}

						// open the rtd-file (if possible)
						InputStream input = element.getContents();
						Document xml = (OilReaderFactory.getAnOilReader()).loadAsXml(input, res.getName(), res.getFullPath().removeLastSegments(1).toOSString());
						
						String txt = xmlToText(xml);

						if (res.exists()) {
							// the current file already exist
							((IFile) res).setContents(new ByteArrayInputStream(txt.getBytes()), IFile.FORCE, monitor);
							Messages.sendTextNl("Wrote " + res.getFullPath() + " (overwritten)");
						} else {
							// build a new file
							((IFile) res).create(new ByteArrayInputStream(txt.getBytes()), IFile.FORCE, monitor);
							Messages.sendTextNl("Wrote " + res.getFullPath());
						}

					} catch (CoreException e) {
						Messages.sendErrorNl("Cannot convert the specified oil file into a xml file ("+element.getName()+"):\n"+e.getMessage(), null, "autosar_convertion_2", null);
						RtdruidLog.log(e);
						
					} catch (Throwable e) {
						Messages.sendErrorNl("Cannot convert the specified oil file into a xml file ("+rtd_name+"):\n"+e.getMessage(), null, "autosar_convertion_2", null);
						RtdruidLog.log(e);
					} finally {
						if (outputEnable)
							Messages.setPrevious();
					}

					// END
					monitor.worked(1);
				}
			};

			new ProgressMonitorDialog(shell).run(true, false, op);
		} catch (InvocationTargetException e) {
			// handle exception
		} catch (InterruptedException e) {
			// handle cancelation
		}
	}

	/**
	 * Selection in the workbench has been changed. We can change the state of
	 * the 'real' action here if we want, but this can only happen after the
	 * delegate has been created.
	 * 
	 * @see IWorkbenchWindowActionDelegate#selectionChanged
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		element = null;
		if (!selection.isEmpty() && selection instanceof IStructuredSelection) {
			Object o = ((IStructuredSelection) selection).getFirstElement();
			if (o instanceof IFile) {
				element = (IFile) o;
			}
		}
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
	}

	
	 protected static String xmlToText(Document doc) {
	    	ByteArrayOutputStream output = new ByteArrayOutputStream();
			try {
				Transformer transformer = TransformerFactory.newInstance()
						.newTransformer();

				transformer.setOutputProperty(OutputKeys.INDENT, "yes");
				// Transform the source XML
				transformer.transform(new DOMSource(doc), new StreamResult(output));

			} catch (TransformerConfigurationException tce) {
				// Error generated by the parser
				System.out.println("* Transformer Factory error");
				System.out.println("  " + tce.getMessage());

				// Use the contained exception, if any
				Throwable x = tce;
				if (tce.getException() != null)
					x = tce.getException();
				x.printStackTrace();

			} catch (TransformerException te) {
				// Error generated by the parser
				System.out.println("* Transformation error");
				System.out.println("  " + te.getMessage());

				// Use the contained exception, if any
				Throwable x = te;
				if (te.getException() != null)
					x = te.getException();
				x.printStackTrace();

			}

			return output.toString();
	    }
}
