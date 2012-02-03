/**
 * 04/gen/2012
 */
package com.eu.evidence.rtdruid.test.vartree;

import org.eclipse.emf.ecore.EPackage;

import com.eu.evidence.rtdruid.vartree.data.DataPackage;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class FillVtUtilDataPackageTest extends FillVtUtilTest {
	
	protected EPackage getEPackage() {
		return DataPackage.eINSTANCE;
	}
}
