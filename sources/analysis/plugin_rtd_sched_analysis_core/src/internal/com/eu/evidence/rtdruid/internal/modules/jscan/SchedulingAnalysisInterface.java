/*
 * Created on Aug 5, 2005
 *
 */
package com.eu.evidence.rtdruid.internal.modules.jscan;



import java.util.Map;

import com.eu.evidence.rtdruid.vartree.abstractions.old.TaskSet;


/**
 * This is the common interface for all Scheduling analysis classes
 * It contains: 
 * - a way to specify the properties used by the analysis
 * - a way to specify which parameters can be set
 * - the compute method 
 * 
 * @author durin
 *
 */
public interface SchedulingAnalysisInterface {
	/**
	 * This are the required properties. 
	 * For example, to do RTA we need computation times and periods, as a minimum 
	 * @return
	 */
	public String[] requiredProperties();
	
	/**
	 * These are optional properties. For example, we may need the offsets (but not always)
	 * @return
	 */
	public String[] optionalProperties();
	
	/**
	 * These are the properties that will be computed.
	 * @return
	 */
	public String[] computedProperties();
	
	/**
	 * Parameters of the analysis (for example, with or without offsets, and 
	 * extra parameters in case of sufficient analysis with offsets). In most cases,
	 * the first parameter will be cpuid for single processor analysis. 
	 * @return
	 */
	public String[] requiredParameters();
	
	/**
	 * Set the initial data on which the analysis must be performed
	 * @param t List of all task sets (one for each cpu).
	 * @param r List of all resources
	 * @param m Additional parameters (i.e. cpuid, and the parameters specified in
	 * the required parameter list). 
	 *  
	 */
	public void init(TaskSet t, MutexSet r, Map m);
	
	/**
	 * Performs the schedulability analysis and produces the outputs in computedProperties[].
	 *
	 */
	public void compute();
}
