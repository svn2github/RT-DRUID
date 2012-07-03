/**
 * 26/giu/2012
 */
package com.eu.evidence.rtdruid.oil.xtext.services;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.eu.evidence.rtdruid.oil.xtext.model.EnumeratorType;
import com.eu.evidence.rtdruid.oil.xtext.model.ObjectType;
import com.eu.evidence.rtdruid.oil.xtext.model.OilImplementation;
import com.eu.evidence.rtdruid.oil.xtext.model.OilObject;
import com.eu.evidence.rtdruid.oil.xtext.model.ParameterType;
import com.eu.evidence.rtdruid.oil.xtext.scoping.OilTypesFastHelper;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public interface IOilTypesHelper {
	
	public static String DEFAULT_APP_MODE = "OSDEFAULTAPPMODE";
	
	public static IOilTypesHelper DefaulHelper = new OilTypesFastHelper();


	public List<ParameterType> getParameterType(List<String> path, List<OilImplementation> roots);

	public List<EnumeratorType> getEnumeratorType(List<String> path, List<OilImplementation> roots);

	/**
	 * Compute Path
	 */
	public List<String> computePath(EObject o, boolean addEnum);

	public List<OilImplementation> getOilImplementation(EObject o);

	public List<OilObject> getMainObjects(Resource res, ObjectType type);

	public OilObject addDefaultAppMode(Resource res);
	
	public OilObject addResScheduler(Resource res);

	public EObject computePathElement(EObject it, boolean addEnum, LinkedList<String> path);

}