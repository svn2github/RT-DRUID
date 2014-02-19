/*
 * Created on Dec 3, 2004
 *
 * $Id: CommonUtils.java,v 1.7 2008/04/18 15:25:09 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.codewriter.common;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;

import com.eu.evidence.rtdruid.io.RTD_XMI_Factory;
import com.eu.evidence.rtdruid.modules.oil.abstractions.ISimpleGenRes;
import com.eu.evidence.rtdruid.modules.oil.implementation.OilEcoreCreator;
import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.IMultiValues;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVarTreePointer;
import com.eu.evidence.rtdruid.vartree.IVariable;
import com.eu.evidence.rtdruid.vartree.tools.Search;

/**
 * This class contains some methods used from all Code Writers
 * 
 * @author Nicola Serreli
 */
public final class CommonUtils {

	/** a short cut to {@link DataPath.SEPARATOR DataPath.SEPARATOR} */
	protected final static String S = "" + DataPath.SEPARATOR;

	/** a suffix used to take the value list from a Value node inside a OilVar
	 * @deprecated 
	 */
	public final static String VALUE_VALUE = S
			;//+ OilApplPackage.eINSTANCE.getValue_Values().getName();

	/**
	 * a suffix used to take the Enumerator list from a Variant node inside a
	 * OilVar
	 * @deprecated 
	 */
	public final static String VARIANT_ELIST = S
			;//+ OilApplPackage.eINSTANCE.getVariant_EnumeratorList().getName()
			//+ S;

	/**
	 * a suffix used to take the Parameter list from an Enumerator node inside a
	 * OilVar
	 * @deprecated 
	 */
	public final static String PARAMETER_LIST = S
			;//+ OilApplPackage.eINSTANCE.getEnumerator_ParameterList().getName()+ S;

	/** a suffix used to take the type of an Enumerator node inside a OilVar
	 * @deprecated 
	 */

	public final static String ENUM_TYPE = S
			;//+ OilApplPackage.eINSTANCE.getEnumerator_Value().getName() + S;



	/**
	 * This method searchs the first child of the VARIANT node indentifies by
	 * path, and returns its Type. If the path is wrong or there isn't any
	 * child, this method returns null.
	 * 
	 * @param vt
	 *            contains all data
	 * @param path
	 *            identifies the Variant node
	 * 
	 * @return the type of first child of specified node
	 */
	public static String getFirstChildEnumType(IVarTree vt, String path) {
		return getFirstChildEnumType(vt, path, null);
	}

	/**
	 * This method searchs the first child of the VARIANT node indentifies by
	 * path, and returns its Type. If the path is wrong or there isn't any
	 * child, this method returns null. <br>
	 * If chidName isn't null and it has one or more elements, it will contain
	 * the name/identifier of the first child.
	 * 
	 * @param vt
	 *            contains all data
	 * @param path
	 *            identifies the Variant node
	 * @param childName
	 *            if it isn't null and it has one or more elements, it will
	 *            contain the name/identifier of the first child
	 * 
	 * @return the type of first child of specified node. Returns null if that
	 *         node is not found or doesn't contain any child
	 */
	public static String getFirstChildEnumType(IVarTree vt, String path,
			String[] childName) {
		IVarTreePointer vtp = vt.newVarTreePointer();
		boolean ok = true;
		String answer = null;
		String firstChildName = "";

		// search the node ....
		ok &= vtp.goAbsolute(path);
		
		//ok &= vtp.goFirstChild();
		// ... remember the name of First child
		
		if (ok) {
			IVarTreePointer.EmfPoint p = vtp.getEPoint();
			if (p.getCurrentFeature() != null) {
				firstChildName = vtp.getName();
				ok &= vtp.goFirstChild();
				p = vtp.getEPoint();
			}
			if (ok) {
				answer = OilEcoreCreator.getOilEnumType(vtp);
				
//				// if is required the name of First child ...
				if (childName != null && childName.length > 0) {
					childName[0] = firstChildName;
				}
			}
		}

		return answer;
	}

	/**
	 * This method searchs the first child of the VARIANT node indentifies by
	 * path, and returns its Type. If the path is wrong or there isn't any
	 * child, this method returns null. <br>
	 * If chidName isn't null and it has one or more elements, it will contain
	 * the name/identifier of the first child.
	 * 
	 * @param vt
	 *            contains all data
	 * @param path
	 *            identifies the Variant node
	 * @param childName
	 *            if it isn't null and it has one or more elements, it will
	 *            contain the name/identifier of the first child
	 * 
	 * @return the type of first child of specified node. Returns null if that
	 *         node is not found or doesn't contain any child
	 */
	public static String getFirstChildEnumType(IVarTree vt, String[] paths,
			String[] fullPath) {
		IVarTreePointer vtp = vt.newVarTreePointer();
		
		for (String path: paths) {
			boolean ok = true;
			String answer = null;
			
			// search the node ....
			ok &= vtp.goAbsolute(path);

			if (ok) {
				IVarTreePointer.EmfPoint p = vtp.getEPoint();
				String firstChildName = "";
				if (p.getCurrentFeature() != null) {
					ok &= vtp.goFirstChild();
					p = vtp.getEPoint();
					firstChildName = vtp.getName();
				}
				if (ok) {
					answer = OilEcoreCreator.getOilEnumType(vtp);
					
					// if is required the name of First child ...
					if (fullPath != null && fullPath.length > 0) {
						fullPath[0] = path + firstChildName;
					}
					return answer;
				}
			}
		}

		return null;
	}
	
	public static String[] addToAllStrings(String[] base, String addition) {
		String[] copy = Arrays.copyOf(base, base.length);
		for (int i=0; i<copy.length; i++) {
			copy[i] += addition;
		}
		return copy;
	}

	/**
	 * This method searches all children of the VARIANT node indentifies by
	 * path, and returns theirs Type. If the path is wrong or there isn't any
	 * child, this method returns null. <br>
	 * If chidName isn't null, it will be cleared and fill with contain
	 * the name/identifier of children (type and name of the same child are in the same position).
	 * 
	 * @param vt
	 *            contains all data
	 * @param path
	 *            identifies the Variant node
	 * @param childName
	 *            if it isn't null, it will
	 *            contain the name/identifier of children
	 * 
	 * @return the type of all children of specified node. Returns null if that
	 *         node is not found or doesn't contain any child
	 */
	public static ArrayList<String> getAllChildrenEnumType(IVarTree vt, String path,
			ArrayList<String> childName) {
		IVarTreePointer vtp = vt.newVarTreePointer();
		boolean ok = true;
		ArrayList<String> answer = null;
		if (childName != null) {
			childName.clear();
		}

		// search the node ....
		ok &= vtp.goAbsolute(path);
		if (ok) {
			answer = new ArrayList<String>();
			IVarTreePointer.EmfPoint p = vtp.getEPoint();
			if (p.getCurrentFeature() == null) {
//				String name = vtp.getName();
				String name = "";
				String type = OilEcoreCreator.getOilEnumType(vtp);
				
				answer.add(type);
				if (childName != null) {
					childName.add(name);
				}

			} else {
				
				for (ok = vtp.goFirstChild(); ok; ok = vtp.goNextSibling()) {
					p = vtp.getEPoint();
					String name = vtp.getName();
					String type = OilEcoreCreator.getOilEnumType(vtp);
					
					answer.add(type);
					if (childName != null) {
						childName.add(name);
					}
				}
			}
		}
		
		return answer;
	}

	/**
	 * This method searchs a Value node and returns all Values stored inside it.
	 * 
	 * @param vt
	 *            contains all data
	 * @param path
	 *            identifies the Value node
	 * 
	 * @return the all values of specified node. Returns null if that node is not
	 *         found or is unset
	 */
	public static String[] getValue(IVarTree vt, String path) {
		return getValue(vt, path, false);
	}
	/**
	 * This method searchs a Value node and returns all Values stored inside it.
	 * 
	 * @param vt
	 *            contains all data
	 * @param path
	 *            identifies the Value node
	 * 
	 * @return the all values of specified node. Returns null if that node is not
	 *         found or is unset
	 */
	public static String[] getValue(IVarTree vt, String path, boolean enableDefaultValue) {
		IVarTreePointer vtp = vt.newVarTreePointer();
		boolean ok = true;
		String[] answer = null;
		// search the node
		ok &= vtp.goAbsolute(path);
		if(!ok){
			ok = true;
			ok &= vtp.goAbsolute(path + ENUM_TYPE);
		}
		if (ok && !vtp.isContainer()) {
			if (vtp.isVarSet() || enableDefaultValue) {
				IVariable var = vtp.getVar(); // take the variable
	
				if (var != null && var.get() != null) {
					// store all values
					if (var instanceof IMultiValues) {
						answer = ((IMultiValues) var).getValues();
					} else {
						answer = new String[] { var.toString() };
					}
				}
			}
		}

		return answer;
	}

	/**
	 * This method searchs a Value node and returns all Values stored inside it.
	 * 
	 * @param vt
	 *            contains all data
	 * @param path
	 *            identifies the Value node
	 * 
	 * @return the all values of specified node. Returns null if that node is not
	 *         found or is unset
	 */
	public static String[] getValues(IVarTree vt, String[] paths) {
		IVarTreePointer vtp = vt.newVarTreePointer();
	
		Set<String> checkedPaths = new HashSet<String>();
		ArrayList<String> answer = new ArrayList<String>();
		
		for (String path: paths) {
			
			if (!checkedPaths.contains(path)) {
				checkedPaths.add(path);
			
				boolean ok = true;
				// search the node
				ok &= vtp.goAbsolute(path + VALUE_VALUE);
				if(!ok){
					ok = true;
					ok &= vtp.goAbsolute(path + ENUM_TYPE);
				}
				if (ok && !vtp.isContainer()) {
					if (vtp.isVarSet()) {
						IVariable var = vtp.getVar(); // take the variable
			
						if (var != null && var.get() != null) {
							// store all values
							if (var instanceof IMultiValues) {
								answer.addAll(Arrays.asList(((IMultiValues) var).getValues()));
							} else {
								answer.add(var.toString());
							}
						}
					}
				}
			}
		}

		return (String[]) answer.toArray(new String[answer.size()]);
	}
	
	/**
	 * This method searchs if <b>all</b> contains a collection with all end only
	 * elements specified inside the <b>current</b> parameter.
	 * 
	 * Null collections are are ingored. 
	 * 
	 * @param all
	 *            a list of all already available vectors. Null collections are
	 *            ignored.
	 * @param current
	 *            the current list of strings. If is null, returns -1
	 * 
	 * @return the index of collection the contains all end only elements
	 *         specified inside the current parameter. Otherwise returns -1
	 */
	public static int searchArray(Collection<String>[] all, String[] current) {
		
		// search only on not null parameters
		if (current != null && all!=null && all.length !=0) {
			
			// look on all collections
			for (int allId = 0; allId<all.length; allId++) {
				
				// work only on not null collections with the same size of "current" parameter
				if (all[allId]!=null && all[allId].size() == current.length) {
					
					
					// make a copy
					LinkedList<String> tmpList = new LinkedList<String>(all[allId]);
					
					// check if they contain the same Strings
					boolean next = true;
					for (int cId=0; cId<current.length && next; cId++) {
						
						next = tmpList.remove( current[cId] );
						
					}
					
					// found the rigth Collection ?
					if (next) {
						return allId;
					}
				}
			}
		}
		
		return -1;
	}

	/**
	 * This method searchs all rtos
	 * */
	public static String[] getAllRtos(ITreeInterface ti) {
		return Search.allRtos(ti);
	}
	
	
	/**
	 * This method adds the specified text to the property of sgr identified by key.
	 * 
	 * @param sgr
	 *            the object where store the property
	 * @param key
	 *            the propery ID
	 * @param value
	 *            the string that should be added
	 * 
	 * @throws NullPointerException
	 *             if one parameter is null
	 */
	public static void updateSgrProperty(ISimpleGenRes sgr, String key, String value) {
		Assert.isNotNull(key);
		Assert.isNotNull(value);
		
		String txt = null;
		if (sgr.containsProperty(key)) {
		    txt = sgr.getString(key);
		}
		if (txt == null) { 
	    	txt = "";
		}
		sgr.setProperty(key, txt + value);
		
	}

	/**
	 * Check if specified file name is a valid file name inside a valid path,
	 * and ends with OIL_SUFFIX.
	 * 
	 * @param fileName
	 *            the input file name
	 * 
	 * @return null if there isn't any problem; otherwise returns a string that
	 *         contains a short description of problem
	 */
	public static String checkConfigFileName(final String fileName) {
// TODO: remove frome here (move into an UI plugin.) If possible, use CheckFileName class	
		IPath ipath = new Path("");
		/*
		 * Check if config file is valid
		 */
		if (fileName.length() == 0) {
			return "Configuration file name cannot be empty";
	
		}
	
		if (!ipath.isValidPath(fileName)) {
			return "Configuration file name is invalid";
		}
	
		if (fileName.indexOf(IPath.DEVICE_SEPARATOR) != -1) {
			return "Configuration file name cannot contains the special char "
					+ IPath.DEVICE_SEPARATOR;
		}
	
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
	
		// get segments
		ipath = ipath.append(fileName);
		String[] segments = ipath.segments();
	
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
	
		{
			String[] types = RTD_XMI_Factory.getAllImportTypes();
			String ext = ipath.getFileExtension();
			
			boolean valid = false;
			if (ext != null) {
				for (String type:types) {
					if (ext.equalsIgnoreCase(type)) {
						valid = true;
						break;
					}
				}
			}
			// check that last segment ends with oil suffix
			if (!valid) {
				return "Configuration file must end with "
				+(types.length>1 ? " one of " : "") 
				+ Arrays.asList(types).toString();
			}
		}
	
		return null;
	}

	/** The default suffix of oil files */
	public static final String OIL_SUFFIX = ".oil";
	
	
	
	/**
	 * 
	 */
	public static String addMakefileDefinesInclude() {
		
		return 	"-include $(EEBASE)/pkg/cfg/path_helper.mk\n";
	}
	/**
	 * 
	 */
	public static String compilerMakefileDefines(String cleanPath, String compilerDefine, OsType os) {
		if (cleanPath == null) {
			cleanPath = "";
		}
		
		final String template = (os == OsType.Cygwin) ? "check_and_set_cygwin_compiler_path" : "check_and_set_linux_compiler_path";
		
		return 	"$(eval $(call "+template+","+compilerDefine+","+cleanPath+"))\n";
	}
}