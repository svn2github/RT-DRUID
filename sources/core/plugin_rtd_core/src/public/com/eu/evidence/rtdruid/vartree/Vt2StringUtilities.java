/*
 * Created on 14-giu-2004
 */
package com.eu.evidence.rtdruid.vartree;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.eu.evidence.rtdruid.io.IRTDExporter;
import com.eu.evidence.rtdruid.io.IRTDImporter;
import com.eu.evidence.rtdruid.io.RTD_XMI_Factory;

/**
 * @author ni
 * 
 * This class is usefull to create a new filled tree and to compare two distinct
 * trees
 */
public class Vt2StringUtilities {

	/**   LOAD data from a string
	 * 
	 * @param input a string that contains all data
	 * @return 
	 * @throws IOException 
	 */ 
	public static IVarTree loadString(String input) throws IOException {
		return loadString(input, "rtd");
	}
	
	
	/**   LOAD data from a string
	 * 
	 * @param input a string that contains all data
	 * @return 
	 * @throws IOException 
	 */ 
	public static IVarTree loadString(String input, String format) throws IOException {
		return load(null, new ByteArrayInputStream(input.getBytes()), format);
	}

	/**   LOAD data from a string
	 * 
	 * @param input a string that contains all data
	 * @return 
	 * @throws IOException 
	 */ 
	public static IVarTree load(InputStream input, String format) throws IOException {
		return load(null, input, format);
	}
	/**   LOAD data from a string
	 * 
	 * @param input a string that contains all data
	 * @return 
	 * @throws IOException 
	 */ 
	public static IVarTree load(IVarTree vt_dest, InputStream input, String format) throws IOException {
		IVarTree vt = VarTreeUtil.newVarTree(); //prepare also Data Factory
		
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put(IRTDImporter.OPT_USE_IMPORTER_TYPE, format);
		
		Resource res = (Resource) vt.getResourceSet().getResources().get(0);
		res.load(input, map);
		
		if (vt_dest != null) {
			VarTreeUtil.merge(vt_dest, vt);
			vt = vt_dest;
		}
		return vt;
	}
	
	

	
	public static String varTreeToString(EObject obj) {
		return varTreeToString(obj, null);
	}
	public static String varTreeToString(EObject obj, String format) {
		HashMap<String, String> map = new HashMap<String, String>();
		if (format != null) {
			map.put(IRTDExporter.OPT_USE_EXPORTER_TYPE, format);
		}

		Resource res = RTD_XMI_Factory.instance.createResource();
		res.getContents().add(obj);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		try {
			res.save(output, null);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		return output.toString();
	}
	
	/**   Convert data into a string
	 * 
	 * @param input a string that contains all data
	 * @return 
	 */ 
	public static String writeString(EditingDomain input, String format) {
		HashMap<String, String> map = new HashMap<String, String>();
		if (format != null) {
			map.put(IRTDExporter.OPT_USE_EXPORTER_TYPE, format);
		}
		
		List<Resource> resources = input.getResourceSet().getResources();
		
		if (resources.size() == 0) {
			return null;
		}

		Resource res = (Resource) input.getResourceSet().getResources().get(0);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		try {
			res.save(output, map);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return output.toString();
	}
	
	public static String varTreeToString(EditingDomain vt) {
		return writeString(vt, null);
	}
	
	public static String varTreeToStringErtd(EditingDomain vt) {
		return writeString(vt, "ertd");
	}

	public static String varTreeToStringRtd(EditingDomain vt) {
		return writeString(vt, "rtd");
	}
	

	
	/**
	 * This function explode an oil var a xml tree
	 * An old function.
	 * It will become deprecated
	 * TODO: set as deprecated 
	 */
	public static String explodeOilVar(String txt) {
		return txt;
	}
	
	
}