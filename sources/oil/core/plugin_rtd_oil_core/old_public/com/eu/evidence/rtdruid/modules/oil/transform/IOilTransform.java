/*
 * Created on 11-nov-2004
 *
 * $Id: OilTransform.java,v 1.1 2008/03/27 12:16:47 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.transform;



import org.w3c.dom.Document;

import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilTransformException;
import com.eu.evidence.rtdruid.modules.oil.implementation.IOilImplID;
import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.IVarTree;

/**
 * @author Nicola Serreli
 */
public interface IOilTransform {

	final static String S = "" + DataPath.SEPARATOR;

	/**
	 * Store all given data inside the given VarTree. It requireds also the id
	 * of HW and RT-OS.
	 * 
	 * @param vt
	 *            where store all data
	 * @param appl
	 *            the data
	 * @param id
	 *            HW and RT-OS ids for data
	 * 
	 * @throws OilTransformException
	 *             if there are some problems
	 */
	public void load(IVarTree vt, Document appl, IOilImplID id)
			throws OilTransformException;

	/**
	 * Take all data from the given VarTree and write the rigth Oil File. It
	 * requireds also the id of HW and RT-OS.
	 * 
	 * @param vt
	 *            where store all data
	 * @param id
	 *            HW and RT-OS ids for data
	 * @param rtosPath
	 *            identifies the rtos needed to write the oil file
	 * 
	 * @return a string with Oil syntax
	 * 
	 * @throws OilTransformException
	 *             if there are some problems
	 */
	public String write(IVarTree vt, IOilImplID id, String rtosPath)
			throws OilTransformException;

	/**
	 * Take all data from the given VarTree and write the rigth Oil File. It
	 * requireds also the id of HW and RT-OS.
	 * 
	 * @param vt
	 *            where store all data
	 * @param id
	 *            HW and RT-OS ids for data
	 * @param rtosPaths
	 *            identifies all rtos needed to write the oil file
	 * 
	 * @return a string with Oil syntax
	 * 
	 * @throws OilTransformException
	 *             if there are some problems
	 */
	public String write(IVarTree vt, IOilImplID id, String[] rtosPaths)
			throws OilTransformException;

}