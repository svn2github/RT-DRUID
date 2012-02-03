package com.eu.evidence.rtdruid.internal.modules.oil.workers;

import java.util.HashMap;

public interface IWorkerExampleWriter {

	/**
	 * Adds a group of options
	 * 
	 * @param opt
	 *            a group of options
	 */
	public abstract void setOptions(HashMap<String, ? extends Object> opt);

	
	/**
	 * Specifies the absolute path of directory that will contains the output
	 * 
	 * @param value
	 *            the output directory name
	 */
	public abstract void setOutputDirectory(String value);

	/**
	 * Start works. Check specified parameters, load file, compute buffers and
	 * write all outputs
	 * 
	 * @throws OilWorkerException
	 *             if there is an error.
	 */
	public abstract void execute() throws OilWorkerException;

	
}