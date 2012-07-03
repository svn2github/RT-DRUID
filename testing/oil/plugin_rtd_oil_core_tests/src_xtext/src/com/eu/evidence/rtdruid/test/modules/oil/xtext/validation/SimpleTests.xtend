package com.eu.evidence.rtdruid.test.modules.oil.xtext.validation

import org.eclipse.xtext.junit4.InjectWith
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2
import org.eclipselabs.xtext.utils.unittesting.XtextTest
import org.junit.Test
import org.junit.runner.RunWith

import static com.eu.evidence.rtdruid.test.modules.oil.xtext.validation.SimpleTests.*
import com.eu.evidence.rtdruid.test.modules.oil.xtext.OilInjectorProvider
import com.eu.evidence.rtdruid.test.modules.oil.xtext.PackageProvider
import com.eu.evidence.rtdruid.oil.xtext.model.Parameter

@RunWith(typeof(XtextRunner2))
@InjectWith(typeof(OilInjectorProvider))
class SimpleTests extends XtextTest {
	static String path = PackageProvider::DEFAULT.computeBundleClassPath(typeof(SimpleTests))
 	new() {
		super(path)
	}


	@Test
	def void simpleNegativeTest001() {
		ignoreSerializationDifferences()
		testFile("test001.oil")
		
		assertConstraints(issues.errorsOnly
			.inLine(20)
			.under(typeof(Parameter))
			.oneOfThemContains("Couldn't resolve reference")
			.oneOfThemContains("'not_existing_id'")
		)
		assertConstraints(issues.errorsOnly
			.inLine(27)
			.under(typeof(Parameter))
			.oneOfThemContains("Couldn't resolve reference")
			.oneOfThemContains("'b'")
		)
		assertConstraints(issues.errorsOnly
			.inLine(30)
			.under(typeof(Parameter))
			.oneOfThemContains("does not support AUTO")
		)
	}

	@Test
	def void simpleNegativeTest002() {
		ignoreFormattingDifferences()
		testFile("test002.oil")
		
		assertConstraints(issues.errorsOnly
			.inLine(20)
			.under(typeof(Parameter))
			.oneOfThemContains("Couldn't resolve reference")
			.oneOfThemContains("'not_existing_id'")
		)
		assertConstraints(issues.errorsOnly
			.inLine(23)
			.under(typeof(Parameter))
			.oneOfThemContains("Couldn't resolve reference")
			.oneOfThemContains("'b'")
		)
	}

	@Test
	def void positiveTest003() {
		ignoreFormattingDifferences()
		testFile("test003.oil")
	}
	
	
	@Test
	def void positiveTest004() {
		ignoreFormattingDifferences()
		testFile("test004.oil")
	}
	
	@Test
	def void positiveTest005() {
		ignoreFormattingDifferences()
		testFile("test005.oil")
		
		assertConstraints(issues.errorsOnly
			.inLine(36)
			.under(typeof(Parameter))
			.oneOfThemContains("Only one value expected")
		)
		assertConstraints(issues.errorsOnly
			.inLine(37)
			.under(typeof(Parameter))
			.oneOfThemContains("Only one value expected")
		)
	}
}
