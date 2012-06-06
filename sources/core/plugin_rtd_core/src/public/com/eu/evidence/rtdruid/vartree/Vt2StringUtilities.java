/*
 * Created on 14-giu-2004
 */
package com.eu.evidence.rtdruid.vartree;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.util.URI;
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
		
		IVarTree vt = VarTreeUtil.newVarTree(); //prepare also Data Factory
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put(IRTDImporter.OPT_USE_IMPORTER_TYPE, format);
		
		Resource res = (Resource) vt.getResourceSet().getResources().get(0);
		res.load(new ByteArrayInputStream(input.getBytes()), map);
		
		return vt;
	}
	
	public static String varTreeToString(EObject obj) {
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
	
	/**   LOAD data from a string
	 * 
	 * @param input a string that contains all data
	 * @return 
	 */ 
	public static String writeString(IVarTree input, String format) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put(IRTDExporter.OPT_USE_EXPORTER_TYPE, format);
		
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
		List<Resource> resources = vt.getResourceSet().getResources();
		
		if (resources.size() == 0) {
			return null;
		}
		Resource res = (Resource) resources.get(0);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		try {
			res.save(output, null);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		return output.toString();
	}
	
	public static String varTreeToStringErtd(EditingDomain vt) {
		List<Resource> resources = vt.getResourceSet().getResources();
		
		if (resources.size() == 0) {
			return null;
		}
		Resource res = (Resource) resources.get(0);
		res.setURI(URI.createFileURI("tmp.ertd"));
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		try {
			res.save(output, null);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		return output.toString();
	}
	


	public static String varTreeToStringRtd(EditingDomain vt) {
		List<Resource> resources = vt.getResourceSet().getResources();
		
		if (resources.size() == 0) {
			return null;
		}
		Resource res = (Resource) resources.get(0);
		res.setURI(URI.createFileURI("tmp.rtd"));
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		try {
			res.save(output, null);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		return output.toString();
	}
	

	
	/**
	 * This function explode an oil var a xml tree 
	 */
	public static String explodeOilVar(String txt) {
		
//		final String indent = " <!-- --> ";
//		
//		final String OIL_VAR = "OilVar=";
//		final int OIL_VAR_SIZE = "OilVar=".length();
//		if (txt != null) {
//		
//			int position = -1;
//			while ( (position = txt.indexOf(OIL_VAR)) >-1) {
//				int start = txt.indexOf('"', position);
//				int end = start >-1 ? txt.indexOf('"', start+1) : -1;
//				int containerEnd = end >-1 ? txt.indexOf('>', end) : -1;
//				
//				if (start == -1 || end == -1 || containerEnd == -1) {
//					break;
//				}
//				
//				String data = txt.substring(start+1, end);
//				data = data.replace("&lt;", "<");
//				data = data.replace("&gt;", ">");
//				data = data.replace("&quot;", "\"");
//				data = data.replace(">", ">\n");
//				data = data.replace("<", indent+"<");
//				data = data.substring(0, data.length()-1);
//				
//				String closing = txt.substring(end+1, containerEnd+1);
//				String closing2 = "";
//				boolean empty = closing.endsWith("/>");
//				if (empty) {
//					closing = closing.replace("/>", ">");
//				
//					int parentStart = (txt.substring(0, start)).lastIndexOf("<");
//					int nameEnd = txt.indexOf(" ", parentStart);
//					
//					if (parentStart == -1 || nameEnd == -1) {
//						break;
//					}
//					
//					closing2 = "</" + txt.substring(parentStart+1, nameEnd) + ">";
//				}
//				
//				
//				txt = txt.substring(0, start-OIL_VAR_SIZE) 
//						+ closing // close parent object 
//						+ "\n"+ data // add oilVar content
//						+ closing2 // the </ParentObject> element (if required)
//						+ txt.substring(containerEnd+1);
//				
//			}
//			
//		}
		return txt;
	}
	
	
}