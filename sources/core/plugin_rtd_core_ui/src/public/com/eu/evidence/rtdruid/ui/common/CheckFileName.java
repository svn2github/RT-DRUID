/*
 * Created on Jul 12, 2005
 *
 * $Id: CheckFileName.java,v 1.2 2007/10/03 09:50:41 durin Exp $
 */
package com.eu.evidence.rtdruid.ui.common;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;

/**
 * TODO Commentare && Tradurre
 * 
 * @author Nicola Serreli
 */
public class CheckFileName {

	protected String SUFFIX_ERROR;

	protected String[] suffix;

	public CheckFileName(String[] suffix) {
		this.suffix = suffix == null ? new String[0] : suffix;

		// prepare the SUFFIX_ERROR String
		StringBuffer tmp = new StringBuffer("The extention of file must be "
				+ (this.suffix.length > 1 ? "one of " : ""));
		for (int i = 0; i < this.suffix.length; i++) {
			tmp.append((i > 0 ? ", " : "") + this.suffix[i]);
		}
		SUFFIX_ERROR = tmp.toString();
	}

	/**
	 * Check if specified file name is a valid file name inside a valid path,
	 * and ends with specified suffix list.
	 */
	public String checkFileName(final String fileName) {

		Path ipath = new Path("");
		/*
		 * Check if config file is valid
		 */
		if (fileName.length() == 0) {
			return "File name cannot be empty";

		}

		if (!ipath.isValidPath(fileName)) {
			return "File name is invalid";
		}

		if (fileName.indexOf(IPath.DEVICE_SEPARATOR) != -1) {
			return "File name cannot contains the special char "
					+ IPath.DEVICE_SEPARATOR;
		}

		IWorkspace workspace = ResourcesPlugin.getWorkspace();

		// get segments
		String[] segments = ipath.append(fileName).segments();

		if (segments.length == 0) {
			return "File name is invalid";
		}

		// check that each segment is valid folder's name
		for (int i = 0; i < segments.length - 1; i++) {
			IStatus result = workspace.validateName(segments[i],
					IResource.FOLDER);

			if (!result.isOK()) {
				return result.getMessage();
			}
		}

		// check that last segment is valid file's name
		IStatus result = workspace.validateName(segments[segments.length - 1],
				IResource.FILE);
		if (!result.isOK()) {
			return result.getMessage();
		}

		// check that last segment ends with oil suffix
		boolean ok = suffix.length == 0;
		for (int i = 0; !ok && i < suffix.length; i++) {
			ok = suffix[i].equals(segments[segments.length - 1]);
		}
		if (!ok) {
			return SUFFIX_ERROR;
		}

		return null;
	}

	/**
	 * Check if specified file name is a valid file name inside a valid path,
	 * and ends with specified list. This method checks also that every folder
	 * is not a file and that the file is not a folder.
	 */
	public String checkFile(final String fileName) {

		Path ipath = new Path("");
		/*
		 * Check if config file is valid
		 */
		if (fileName.length() == 0) {
			return "File name cannot be empty";

		}

		if (!ipath.isValidPath(fileName)) {
			return "File name is invalid";
		}

		if (fileName.indexOf(IPath.DEVICE_SEPARATOR) != -1) {
			return "File name cannot contains the special char "
					+ IPath.DEVICE_SEPARATOR;
		}

		IWorkspace workspace = ResourcesPlugin.getWorkspace();

		// get segments
		String[] segments = ipath.append(fileName).segments();

		if (segments.length == 0) {
			return "File name is invalid";
		}

		IContainer parent = workspace.getRoot();
		IPath curentPath = new Path("");
		
		{ // project
			IStatus result = workspace.validateName(segments[0],
					IResource.PROJECT);

			if (!result.isOK()) {
				return result.getMessage();
			}
			
			curentPath = curentPath.append(segments[0]);
			IResource res = parent.findMember(segments[0]);
			if (res == null) {
				return curentPath.toString() + " doesn't exist";
				
			} else if (!(res instanceof IProject)) {
				return curentPath.toString() + "is not a project";
			}
			parent = (IContainer) res;

		}
		
		// check that each segment is valid folder's name
		for (int i = 1; i < segments.length - 1; i++) {
			IStatus result = workspace.validateName(segments[i],
					IResource.FOLDER);

			if (!result.isOK()) {
				return result.getMessage();
			}
			
			curentPath = curentPath.append(segments[i]);
			if (parent != null) {
				IResource res = parent.findMember(segments[i]);
				if (res != null && !(res instanceof IContainer)) {
					return curentPath.toString() + " is not a folder";
				}
				parent = (IContainer) res;
			}
		}

		if (segments.length == 1) {
			return "Required a file name";
		}

		// check that last segment is valid file's name
		IStatus result = workspace.validateName(segments[segments.length - 1],
				IResource.FILE);
		if (!result.isOK()) {
			return result.getMessage();
		}
		if (parent != null) {
			curentPath = curentPath.append(segments[segments.length - 1]);
			IResource res = parent.findMember(segments[segments.length - 1]);
			if (res != null && !(res instanceof IFile)) {
				return curentPath.toString() + " is not a file";
			}
		}

		// check that last segment ends with oil suffix
		boolean ok = suffix.length == 0;
		for (int i = 0; !ok && i < suffix.length; i++) {
			ok = suffix[i].equals(segments[segments.length - 1]);
		}
		if (!ok) {
			return SUFFIX_ERROR;
		}

		return null;
	}

}
