/*
 * Created on 14/set/07
 *
 * $Id: ResourceUtility.java,v 1.2 2007/10/03 09:53:53 durin Exp $
 */
package com.eu.evidence.rtdruid.ui.common;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.variables.VariablesPlugin;

import com.eu.evidence.rtdruid.desk.Messages;
import com.eu.evidence.rtdruid.desk.RtdruidLog;

/**
 * A class useful to do some common operation on IFiles, like store data.
 * 
 * @see CheckFileName
 * 
 */
public class ResourceUtility {

	/** A cache used to speed up the construction of Eclipse folders */
	protected HashMap<String, IContainer> containersCache = new HashMap<String, IContainer>();

	/** The progress monitor, if the user set it */
	protected IProgressMonitor monitor = null;

	/**
	 * This method allows to set a progress monitor
	 */
	public void setMonitor(IProgressMonitor monitor) {
		this.monitor = monitor;
	}

	/**
	 * This method tries to write a new file or overwrite an old one, with the
	 * given data. The file is an Eclipse resource and then the workspace GUI is
	 * updated as soon as possible after the end of this method.
	 * 
	 * The full name of the file is <code>basePath</code> /
	 * <code>filePath</code> / <code>fileName</code>.
	 * 
	 * @param filePath
	 *            the folder that contain the file
	 * @param fileName
	 *            the name of the current file
	 * @param basePath
	 *            a prefix to filePath and fileName. Can be null.
	 * @param data
	 *            the new content of the file
	 * 
	 * @return true if everything works well
	 * 
	 * @throws RuntimeException
	 *             if the file parent is not a folder
	 */
	public boolean saveResourceFile(String filePath, String fileName,
			IPath basePath, byte[] data) {

		if (basePath == null) {
			basePath = new Path("");
		}
		String key = basePath.append(filePath).toString();

		/*
		 * Prepare folder
		 */
		final IContainer container;
		// final String messagePrefix1 = "\t" +
		// basePath.append(filePath).toString()+ "/"+ fileName;

		if (containersCache.containsKey(key)) {
			container = (IContainer) containersCache.get(key);
		} else {
			IPath requiredFolder = basePath.append(filePath);

			// final ContainerGenerator cg = new
			// ContainerGenerator(requiredFolder);
			Messages.sendTextNl("Check and fill folder "
					+ requiredFolder.toString());

			try {
				// container = cg.generateContainer(monitor);
				container = generateWsPath(requiredFolder);
			} catch (Exception e) {
				RtdruidLog.log(e);

				Messages
						.sendErrorNl(e.getMessage(), null, "rtjjasdfdgh;", null);

				return false;
			}
			containersCache.put(key, container);
		}

		// check if the folder exist
		if (!(container instanceof IFolder) && !(container instanceof IProject)) {
			RtdruidLog.log(filePath + " isn't a folder");
			throw new RuntimeException(filePath + " isn't a folder");
			// return false;
		}

		/*
		 * Save the file
		 */
		final IFile newFile = (container instanceof IFolder) ? ((IFolder) container)
				.getFile(fileName)
				: ((IProject) container).getFile(fileName);

		InputStream fileStream = new ByteArrayInputStream(data);

		final String messagePrefix = "\t"
				+ basePath.append(filePath).toString() + "/" + fileName;

		if (newFile.exists()) {
			// the current file already exist
			try {
				newFile.setContents(fileStream, IFile.FORCE, monitor);
			} catch (CoreException e) {
				RtdruidLog.log(e);
				Messages.sendErrorNl(messagePrefix + "\tERROR", null,
						"jasdfdgh;", null);
				return false;
			}
			Messages.sendTextNl(messagePrefix + "\tOK (overwritten)");
		} else {
			// build a new file
			try {
				newFile.create(fileStream, IFile.FORCE, monitor);
			} catch (CoreException e) {
				RtdruidLog.log(e);
				Messages.sendErrorNl(messagePrefix + "\tERROR", null, "jasdh;",
						null);
				return false;
			}
			Messages.sendTextNl(messagePrefix + "\tOK");
		}

		return true;
	}

	/**
	 * This method allows to build every IContainer that compose a path, and
	 * returns the deeper IContainer. <b>Note this method doesn't make new
	 * Projects.</b>
	 * 
	 * A path is like <code>/project_name/a/b/c/d</code>
	 * 
	 * @param requiredFolder
	 *            the path, starting from the workspace root.
	 * 
	 * @return the deeper container. Cannot be null.
	 * 
	 * @throws RuntimeException
	 *             if the user ask to create a new Project, or if one element
	 *             already exist and isn't a container, or if one element cannot
	 *             be created for some strange reason.
	 */
	public IContainer generateWsPath(IPath requiredFolder) {
		
		
		try {
			String newTxt = VariablesPlugin.getDefault()
					.getStringVariableManager().performStringSubstitution(
							requiredFolder.toString(), false);
			if (newTxt != null) {
				requiredFolder = new Path(newTxt);
			}
		} catch (CoreException e1) {
		}
		
		String[] segments = requiredFolder.segments();
		IContainer current = ResourcesPlugin.getWorkspace().getRoot();

		IPath currPath = new Path("");
		for (int i = 0; i < segments.length; i++) {
			currPath = currPath.append(segments[i]);
			IPath segment = new Path(requiredFolder.segment(i));

			// search if exist an element with specified name
			IResource res = current.findMember(segment);

			if (res == null) {
				// try to create a new folder

				if (current instanceof IWorkspaceRoot) { // the new element has
					// to be a Project
					// -> error
					throw new RuntimeException("Cannot create a new Project "
							+ currPath);

				}
				// else {

				// create the folder and test
				IFolder child = current.getFolder(segment);
				try {
					child.create(false, true, monitor);
				} catch (CoreException e) {
					throw new RuntimeException(currPath
							+ " doesn't exist and cannot be created", e);
				}

				if (!child.exists()) {
					throw new RuntimeException(currPath
							+ " doesn't exist and cannot be created");
				}
				current = child;

			} else {
				// the element exist , but we have to check the type

				if (res.getType() == IResource.FOLDER
						|| res.getType() == IResource.PROJECT) {
					current = (IContainer) res;

				} else {
					throw new RuntimeException(currPath
							+ " exists but it isn't a folder");
				}
			}
		}

		return current;
	}
	
	
	
	/**
	 * This method tries to enable the executable flag of a file. 
	 */
	public void setExecutable(IPath resource) {
		IContainer current = ResourcesPlugin.getWorkspace().getRoot();
		IResource res = current.findMember(resource);
		
		IPath local_path = res != null ? res.getLocation() : null;
		if (local_path != null) {
			File f = local_path.toFile();
			setExecutable(f);
		}
	}
	

	/**
	 * This method tries to enable the executable flag of a file. 
	 */
	public void setExecutable(File resource) {
		
		if (resource == null) {
			// do nothing
			return;
		}
		
		try {
			if (resource.setExecutable(true, false)) {
			//	return;
			}
		} catch (Throwable e) {
			RtdruidLog.log("Cannot use the setExecutable function", e);
		}
		
		
		// if the first one doesn't work, use chmod approach
		try {
			Process p = Runtime.getRuntime().exec("chmod a+x " + resource.getAbsolutePath());

			InputStream std_out = p.getInputStream(); // standard output
			InputStream std_err = p.getErrorStream(); // standard error
			
			StringBuffer buff = new StringBuffer();
			
			boolean open_out = true;
			boolean open_err = true;
			while (open_err && open_out) {
				if (open_err) {
					int c = std_err.read();
					if ( c == -1) {
						open_err = false;
					} else {
						buff.append(c);
					}
					
				} else if (open_out) {
					int c = std_out.read();
					if ( c == -1) {
						open_out = false;
					} else {
						buff.append(c);
					}
				} 
			}

			int exitVal = p.waitFor();
			if (exitVal != 0) {
				RtdruidLog.log("\nAbnormal termination (exit value = "
								+ exitVal + ")");
			}
			
			System.out.println("CHMOD : " + exitVal+ " \n"+buff);


		} catch (Throwable e) {
			if (!Platform.OS_WIN32.equals(Platform.getOS()) ) {
				RtdruidLog.log("Cannot set executable using chmod program", e);
			}
		}
		
	}
}
