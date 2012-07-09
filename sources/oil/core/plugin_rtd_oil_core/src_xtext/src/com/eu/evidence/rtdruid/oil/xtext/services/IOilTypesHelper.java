/**
 * 26/giu/2012
 */
package com.eu.evidence.rtdruid.oil.xtext.services;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.eu.evidence.rtdruid.oil.xtext.model.EnumeratorType;
import com.eu.evidence.rtdruid.oil.xtext.model.ObjectType;
import com.eu.evidence.rtdruid.oil.xtext.model.OilImplementation;
import com.eu.evidence.rtdruid.oil.xtext.model.OilObject;
import com.eu.evidence.rtdruid.oil.xtext.model.ParameterType;
import com.eu.evidence.rtdruid.oil.xtext.model.VType;
import com.eu.evidence.rtdruid.oil.xtext.scoping.OilTypesFastHelper;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public interface IOilTypesHelper {
	
	public static String DEFAULT_APP_MODE = "OSDEFAULTAPPMODE";
	public static BigInteger MAX_INT = BigInteger.ONE.negate();
	public static String MAX_INT_TXT = MAX_INT.toString();

	public static BigInteger MAX_UINT32 = new BigInteger("FFFFFFFF", 16);
	public static BigInteger MAX_UINT64 = new BigInteger("FFFFFFFFFFFFFFFF", 16);

	
	public static IOilTypesHelper DefaulHelper = new OilTypesFastHelper();


	public abstract List<ParameterType> getParameterType(List<String> path, List<OilImplementation> roots);

	public abstract List<EnumeratorType> getEnumeratorType(List<String> path, List<OilImplementation> roots);

	/**
	 * Compute Path
	 */
	public abstract List<String> computePath(EObject o, boolean addEnum);

	public abstract List<OilImplementation> getOilImplementation(EObject o);

	public abstract List<OilObject> getMainObjects(Resource res, ObjectType type);

	public abstract OilObject addDefaultAppMode(Resource res);
	
	public abstract OilObject addResScheduler(Resource res);

	public abstract EObject computePathElement(EObject it, boolean addEnum, LinkedList<String> path);

	

	@SuppressWarnings("rawtypes")
	public Class<? extends Comparable> getType(VType vType);

	
	/**
	 * This method transforms a String in the corresponding number/string, depending on VType
	 * 
	 */
	public Comparable<?> computeValue(String value, VType vType);
}