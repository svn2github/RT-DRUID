/**
 * 04/gen/2012
 */
package com.eu.evidence.rtdruid.test.vartree;

import org.eclipse.emf.ecore.EPackage;

import com.eu.evidence.rtdruid.epackage.EPackageFactory;
import com.eu.evidence.rtdruid.epackage.RTDEPackageBuildException;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class FillVtUtilDynamicPackageTest extends FillVtUtilTest {
	
	protected EPackage getEPackage() throws RTDEPackageBuildException {
		return EPackageFactory.instance.getEPackage();
	}
}
