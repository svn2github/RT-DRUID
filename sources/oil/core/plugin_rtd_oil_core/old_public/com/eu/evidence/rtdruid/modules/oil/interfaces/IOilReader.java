/*
 * Created on Sep 7, 2005
 *
 * $Id: IOilReader.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.interfaces;

import java.io.InputStream;

import org.w3c.dom.Document;

import com.eu.evidence.rtdruid.modules.oil.Rtd_oil_corePlugin;
import com.eu.evidence.rtdruid.vartree.IVarTree;

/**
 * TODO Commentare && Tradurre
 * 
 * @author Nicola Serreli
 */
public interface IOilReader {
	public final static String DEFAULT_EE_IMPL = Rtd_oil_corePlugin.TEMPLATES_PATH
			+ "ee_appl.oil";

	/**
	 * This method loads an Oil File. To do it, this uses
	 * {@link #load(InputStream, VarTree) load(InputStream, VarTree)}.
	 * 
	 * @param where
	 *            identifies the file from which load all data.
	 * @param vt
	 *            the data tree where store all results
	 */
	void load(String where, IVarTree vt);

	/**
	 * This method tries to parse an input stream as Oil Data; then it stores
	 * the implementation part into OilImplFactory and the application part
	 * inside the given VarTree. To do this last point, uses Oil-Transform
	 * classes. <br>
	 * <br>
	 * If there is some errors, it throw some Runtime exception and doen't store
	 * data inside the OilImplFactory and, only if a transaction is started
	 * inside this function, it tries to undo all changes inside the VarTree.
	 * 
	 * @param stream
	 *            identifies the stream of data.
	 * @param vt
	 *            the data tree where store all results
	 * 
	 * @deprecated use load(String where, IVarTree vt) or load(InputStream
	 *             stream, IVarTree vt, String fileName, String filePath)
	 */
	void load(InputStream stream, IVarTree vt);

	/**
	 * This method tries to parse an input stream as Oil Data; then it stores
	 * the implementation part into OilImplFactory and the application part
	 * inside the given VarTree. To do this last point, uses Oil-Transform
	 * classes. <br>
	 * <br>
	 * If there is some errors, it throw some Runtime exception and doen't store
	 * data inside the OilImplFactory and, only if a transaction is started
	 * inside this function, it tries to undo all changes inside the VarTree.
	 * 
	 * @param stream
	 *            identifies the stream of data.
	 * @param vt
	 *            the data tree where store all results
	 * @param fileName
	 *            used for error messages
	 * @param filePath
	 *            used to include relative paths
	 */
	void load(InputStream stream, IVarTree vt, String fileName, String filePath);

	/**
	 * This method tries to parse an input stream as Oil Data; then it translate the
	 * application part into a xml document. <br>
	 * 
	 * @param stream
	 *            identifies the stream of data.
	 * @param fileName
	 *            used for error messages
	 * @param filePath
	 *            used to include relative paths
	 */
	public Document loadAsXml(InputStream stream, String fileName, String filePath);
}