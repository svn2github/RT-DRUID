/**
 * 14/nov/2011
 */
package com.eu.evidence.rtdruid.epackage;

import org.eclipse.emf.ecore.EPackage;


/**
 * This interface provide an extension to RT-Druid Ecore Package
 * 
 * @author Nicola Serreli
 * @since 2.0
 * 
 */
public interface IEPackageProvider {

	/**
	 * Return some elements that should be added to an already existing RT-Druid ecore package.
	 * 
	 * @return a contribution to the RT-Druid package.
	 * 
	 * @throws a
	 *             RTDEPackageBuildException if there is a problem during the
	 *             fill operation
	 */
	EPackage get() throws RTDEPackageBuildException;
}
