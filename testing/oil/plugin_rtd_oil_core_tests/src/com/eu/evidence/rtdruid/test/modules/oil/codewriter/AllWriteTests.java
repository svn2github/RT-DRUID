/**
 * 23/feb/2012
 */
package com.eu.evidence.rtdruid.test.modules.oil.codewriter;

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
@SuiteClasses({ CodeWriterArm7Test.class, CodeWriterAvr5Test.class, CodeWriterAvr8Test.class, CodeWriterComTest.class, 
	CodeWriterCortexTest.class,
		CodeWriterCosmicS12Test.class, CodeWriterDsPicTest.class, CodeWriterMico32Test.class,
		CodeWriterMisraTest.class, CodeWriterMpc567Test.class, CodeWriterMpc5Test.class,
		CodeWriterMultiEcuTest.class,
		CodeWriterMultiPic30Test.class, CodeWriterNiosIITest.class, CodeWriterPic32Test.class,
		CodeWriterPpcMultiCoreTest.class, CodeWriterResourcesTest.class, 
		CodeWriterRx200Test.class, CodeWritertMPTest.class, CodeWriterTricore1Test.class,
		CodeWriterX86Test.class,
		CodeWritertTest.class })
public class AllWriteTests {

}
