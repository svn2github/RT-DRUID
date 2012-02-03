/**
 * 21/dic/2011
 */
package com.eu.evidence.rtdruid.epackage;

import org.eclipse.emf.ecore.EPackage;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public interface IEPackageMerge {

	/**
	 * 
	 * @param pkg
	 * 
	 * @throws IllegalStateException if addPackage is called after call get result
	 */
	public void addEPackage(EPackage pkg) throws RTDEPackageBuildException;

	/**
	 * This function returns the result of the merge. After this call it is not possible to add more packages.
	 * The result can be null, if addEPackages was never called;
	 * 
	 * 
	 * @return the result of the merge operation
	 */
	public EPackage getResult();

}