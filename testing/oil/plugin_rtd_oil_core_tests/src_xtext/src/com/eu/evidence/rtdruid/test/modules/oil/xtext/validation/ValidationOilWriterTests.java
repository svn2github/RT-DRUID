package com.eu.evidence.rtdruid.test.modules.oil.xtext.validation;
/**
 * 27/06/2012
 */


import java.util.ArrayList;

import junit.framework.Assert;

import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipselabs.xtext.utils.unittesting.FluentIssueCollection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.eu.evidence.rtdruid.oil.xtext.model.OilFile;
import com.eu.evidence.rtdruid.oil.xtext.services.OilModelLoader;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.CodeWriterArm7Test;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.CodeWriterAvr5Test;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.CodeWriterAvr8Test;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.CodeWriterComTest;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.CodeWriterCortexTest;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.CodeWriterCosmicS12Test;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.CodeWriterDsPicTest;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.CodeWriterMico32Test;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.CodeWriterMisraTest;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.CodeWriterMpc567Test;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.CodeWriterMpc5Test;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.CodeWriterMultiEcuTest;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.CodeWriterMultiPic30Test;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.CodeWriterNiosIITest;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.CodeWriterPic32Test;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.CodeWriterPpcMultiCoreTest;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.CodeWriterResourcesTest;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.CodeWriterRx200Test;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.CodeWriterTricore1Test;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.CodeWritertMPTest;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.CodeWritertTest;
import com.eu.evidence.rtdruid.test.modules.oil.xtext.validation.ValidationOilWriterTests.ValidationOilInputArm7Test;
import com.eu.evidence.rtdruid.test.modules.oil.xtext.validation.ValidationOilWriterTests.ValidationOilInputAvr5Test;
import com.eu.evidence.rtdruid.test.modules.oil.xtext.validation.ValidationOilWriterTests.ValidationOilInputAvr8Test;
import com.eu.evidence.rtdruid.test.modules.oil.xtext.validation.ValidationOilWriterTests.ValidationOilInputComTest;
import com.eu.evidence.rtdruid.test.modules.oil.xtext.validation.ValidationOilWriterTests.ValidationOilInputCortexTest;
import com.eu.evidence.rtdruid.test.modules.oil.xtext.validation.ValidationOilWriterTests.ValidationOilInputCosmicS12Test;
import com.eu.evidence.rtdruid.test.modules.oil.xtext.validation.ValidationOilWriterTests.ValidationOilInputDsPicTest;
import com.eu.evidence.rtdruid.test.modules.oil.xtext.validation.ValidationOilWriterTests.ValidationOilInputMico32Test;
import com.eu.evidence.rtdruid.test.modules.oil.xtext.validation.ValidationOilWriterTests.ValidationOilInputMisraTest;
import com.eu.evidence.rtdruid.test.modules.oil.xtext.validation.ValidationOilWriterTests.ValidationOilInputMpc567Test;
import com.eu.evidence.rtdruid.test.modules.oil.xtext.validation.ValidationOilWriterTests.ValidationOilInputMpc5Test;
import com.eu.evidence.rtdruid.test.modules.oil.xtext.validation.ValidationOilWriterTests.ValidationOilInputMultiEcuTest;
import com.eu.evidence.rtdruid.test.modules.oil.xtext.validation.ValidationOilWriterTests.ValidationOilInputMultiPic30Test;
import com.eu.evidence.rtdruid.test.modules.oil.xtext.validation.ValidationOilWriterTests.ValidationOilInputNiosIITest;
import com.eu.evidence.rtdruid.test.modules.oil.xtext.validation.ValidationOilWriterTests.ValidationOilInputPic32Test;
import com.eu.evidence.rtdruid.test.modules.oil.xtext.validation.ValidationOilWriterTests.ValidationOilInputPpcMultiCoreTest;
import com.eu.evidence.rtdruid.test.modules.oil.xtext.validation.ValidationOilWriterTests.ValidationOilInputResourcesTest;
import com.eu.evidence.rtdruid.test.modules.oil.xtext.validation.ValidationOilWriterTests.ValidationOilInputRx200Test;
import com.eu.evidence.rtdruid.test.modules.oil.xtext.validation.ValidationOilWriterTests.ValidationOilInputTricore1Test;
import com.eu.evidence.rtdruid.test.modules.oil.xtext.validation.ValidationOilWriterTests.ValidationOilInputtMPTest;
import com.eu.evidence.rtdruid.test.modules.oil.xtext.validation.ValidationOilWriterTests.ValidationOilInputtTest;

/**
 * 
 * @author Nicola Serreli
 * @since 2.0
 * 
 */
@RunWith(Suite.class)
@SuiteClasses({ ValidationOilInputArm7Test.class, ValidationOilInputAvr5Test.class, ValidationOilInputAvr8Test.class, ValidationOilInputComTest.class, 
	ValidationOilInputCortexTest.class,
		ValidationOilInputCosmicS12Test.class, ValidationOilInputDsPicTest.class, ValidationOilInputMico32Test.class,
		ValidationOilInputMisraTest.class, ValidationOilInputMpc567Test.class, ValidationOilInputMpc5Test.class,
		ValidationOilInputMultiEcuTest.class,
		ValidationOilInputMultiPic30Test.class, ValidationOilInputNiosIITest.class, ValidationOilInputPic32Test.class,
		ValidationOilInputPpcMultiCoreTest.class, ValidationOilInputResourcesTest.class, 
		ValidationOilInputRx200Test.class, ValidationOilInputtMPTest.class, ValidationOilInputTricore1Test.class,
		ValidationOilInputtTest.class })
public class ValidationOilWriterTests {

	static String VT_PROP_AUTOSAR_FORMAT = "vt_property__autosar_format";

	public static class ValidationOilInputArm7Test extends CodeWriterArm7Test {
		@Override
		public DefaultTestResult commonWriterTest(String oil_text, int expected_cpu) {
			ValidationOilWriterTests.validateTest(oil_text);
			return super.commonWriterTest(oil_text, expected_cpu);
		}
	}

	
	public static class ValidationOilInputAvr5Test extends CodeWriterAvr5Test {
		@Override
		public DefaultTestResult commonWriterTest(String oil_text, int expected_cpu) {
			ValidationOilWriterTests.validateTest(oil_text);
			return super.commonWriterTest(oil_text, expected_cpu);
		}
	}
	
	public static class ValidationOilInputAvr8Test extends CodeWriterAvr8Test {
		@Override
		public DefaultTestResult commonWriterTest(String oil_text, int expected_cpu) {
			ValidationOilWriterTests.validateTest(oil_text);
			return super.commonWriterTest(oil_text, expected_cpu);
		}
	}

	public static class ValidationOilInputComTest extends CodeWriterComTest {
		@Override
		public DefaultTestResult commonWriterTest(String oil_text, int expected_cpu) {
			ValidationOilWriterTests.validateTest(oil_text);
			return super.commonWriterTest(oil_text, expected_cpu);
		}
	}

	public static class ValidationOilInputCortexTest extends CodeWriterCortexTest {
		@Override
		public DefaultTestResult commonWriterTest(String oil_text, int expected_cpu) {
			ValidationOilWriterTests.validateTest(oil_text);
			return super.commonWriterTest(oil_text, expected_cpu);
		}
	}

	public static class ValidationOilInputCosmicS12Test extends CodeWriterCosmicS12Test {
		@Override
		public DefaultTestResult commonWriterTest(String oil_text, int expected_cpu) {
			ValidationOilWriterTests.validateTest(oil_text);
			return super.commonWriterTest(oil_text, expected_cpu);
		}
	}

	public static class ValidationOilInputDsPicTest extends CodeWriterDsPicTest {
		@Override
		public DefaultTestResult commonWriterTest(String oil_text, int expected_cpu) {
			ValidationOilWriterTests.validateTest(oil_text);
			return super.commonWriterTest(oil_text, expected_cpu);
		}
	}

	public static class ValidationOilInputMico32Test extends CodeWriterMico32Test {
		@Override
		public DefaultTestResult commonWriterTest(String oil_text, int expected_cpu) {
			ValidationOilWriterTests.validateTest(oil_text);
			return super.commonWriterTest(oil_text, expected_cpu);
		}
	}

	public static class ValidationOilInputMisraTest extends CodeWriterMisraTest {
		@Override
		public DefaultTestResult commonWriterTest(String oil_text, int expected_cpu) {
			ValidationOilWriterTests.validateTest(oil_text);
			return super.commonWriterTest(oil_text, expected_cpu);
		}
	}

	public static class ValidationOilInputMpc567Test extends CodeWriterMpc567Test {
		@Override
		public DefaultTestResult commonWriterTest(String oil_text, int expected_cpu) {
			ValidationOilWriterTests.validateTest(oil_text);
			return super.commonWriterTest(oil_text, expected_cpu);
		}
	}

	public static class ValidationOilInputMpc5Test extends CodeWriterMpc5Test {
		@Override
		public DefaultTestResult commonWriterTest(String oil_text, int expected_cpu) {
			ValidationOilWriterTests.validateTest(oil_text);
			return super.commonWriterTest(oil_text, expected_cpu);
		}
	}

	public static class ValidationOilInputMultiEcuTest extends CodeWriterMultiEcuTest {
		@Override
		public DefaultTestResult commonWriterTest(String oil_text, int expected_cpu) {
			ValidationOilWriterTests.validateTest(oil_text);
			return super.commonWriterTest(oil_text, expected_cpu);
		}
	}

	public static class ValidationOilInputMultiPic30Test extends CodeWriterMultiPic30Test {
		@Override
		public DefaultTestResult commonWriterTest(String oil_text, int expected_cpu) {
			ValidationOilWriterTests.validateTest(oil_text);
			return super.commonWriterTest(oil_text, expected_cpu);
		}
	}

	public static class ValidationOilInputNiosIITest extends CodeWriterNiosIITest {
		
		@Override
		@Test
		public void testHR_2() {
			
		}
		
		@Override
		public DefaultTestResult commonWriterTest(String oil_text, int expected_cpu) {
			ValidationOilWriterTests.validateTest(oil_text);
			return super.commonWriterTest(oil_text, expected_cpu);
		}
	}

	public static class ValidationOilInputPic32Test extends CodeWriterPic32Test {
		@Override
		public DefaultTestResult commonWriterTest(String oil_text, int expected_cpu) {
			ValidationOilWriterTests.validateTest(oil_text);
			return super.commonWriterTest(oil_text, expected_cpu);
		}
	}

	public static class ValidationOilInputPpcMultiCoreTest extends CodeWriterPpcMultiCoreTest {
		@Override
		public DefaultTestResult commonWriterTest(String oil_text, int expected_cpu) {
			ValidationOilWriterTests.validateTest(oil_text);
			return super.commonWriterTest(oil_text, expected_cpu);
		}
	}

	public static class ValidationOilInputResourcesTest extends CodeWriterResourcesTest {
		@Override
		public DefaultTestResult commonWriterTest(String oil_text, int expected_cpu) {
			ValidationOilWriterTests.validateTest(oil_text);
			return super.commonWriterTest(oil_text, expected_cpu);
		}
	}

	public static class ValidationOilInputRx200Test extends CodeWriterRx200Test {
		@Override
		public DefaultTestResult commonWriterTest(String oil_text, int expected_cpu) {
			ValidationOilWriterTests.validateTest(oil_text);
			return super.commonWriterTest(oil_text, expected_cpu);
		}
	}

	public static class ValidationOilInputtMPTest extends CodeWritertMPTest {
		@Override
		public DefaultTestResult commonWriterTest(String oil_text, int expected_cpu) {
			ValidationOilWriterTests.validateTest(oil_text);
			return super.commonWriterTest(oil_text, expected_cpu);
		}
	}

	public static class ValidationOilInputTricore1Test extends CodeWriterTricore1Test {
		@Override
		public DefaultTestResult commonWriterTest(String oil_text, int expected_cpu) {
			ValidationOilWriterTests.validateTest(oil_text);
			return super.commonWriterTest(oil_text, expected_cpu);
		}
	}


	public static class ValidationOilInputtTest extends CodeWritertTest {
		@Override
		public DefaultTestResult commonWriterTest(String oil_text, int expected_cpu) {
			ValidationOilWriterTests.validateTest(oil_text);
			return super.commonWriterTest(oil_text, expected_cpu);
		}
	}


	
	// ----------------------------------------------------------------------

	public static void validateTest(String oil_text) {
		ValidationTestHelper tester = new ValidationTestHelper();
		
		OilFile model;
		try {
			model = OilModelLoader.instance.load(oil_text);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		FluentIssueCollection	issues = new FluentIssueCollection(model.eResource(), tester.validate(model), new ArrayList<String>());

    	if (issues.errorsOnly().getIssues().size() != 0) {
    		Assert.fail("\n\nfound unasserted issues " + issues.getSummary() + "\n\n");
    	}

	}

}
