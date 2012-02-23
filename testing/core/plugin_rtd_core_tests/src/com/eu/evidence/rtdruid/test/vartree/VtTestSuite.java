/**
 * 22/feb/2012
 */
package com.eu.evidence.rtdruid.test.vartree;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
@RunWith(Suite.class)
@SuiteClasses({
	EMFCommandsTest.class,
	FillVtUtilDataPackageTest.class,
	FillVtUtilDynamicPackageTest.class,
	VarTreeEMFCommandsTest.class,
	VarTreePointerEMF_noslashed_Test.class,
	VarTreePointerEMF_slashed_Test.class,
	VarTreeTest.class,
	VarTreeUtilTest.class
})
public class VtTestSuite {

}
