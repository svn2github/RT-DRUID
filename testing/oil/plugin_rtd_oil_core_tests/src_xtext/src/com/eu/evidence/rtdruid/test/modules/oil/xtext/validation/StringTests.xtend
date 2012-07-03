package com.eu.evidence.rtdruid.test.modules.oil.xtext.validation

import com.eu.evidence.rtdruid.test.modules.oil.xtext.OilInjectorProvider
import com.eu.evidence.rtdruid.test.modules.oil.xtext.PackageProvider
import org.eclipse.xtext.junit4.InjectWith
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2
import org.eclipselabs.xtext.utils.unittesting.XtextTest
import org.junit.Test
import org.junit.runner.RunWith

import static com.eu.evidence.rtdruid.test.modules.oil.xtext.validation.StringTests.*
import com.eu.evidence.rtdruid.oil.xtext.model.ValueType

@RunWith(typeof(XtextRunner2))
@InjectWith(typeof(OilInjectorProvider))
class StringTests extends XtextTest {
	static String path = PackageProvider::DEFAULT.computeBundleClassPath(typeof(StringTests))
 	new() {
		super(path)
	}


	@Test
	def void stringDefaultsTest() {
		ignoreFormattingDifferences()
		testFile("testStringDefault.oil")
		
		assertConstraints(issues.errorsOnly.inLine(5).under(typeof(ValueType)).oneOfThemContains("STRING"))
		assertConstraints(issues.errorsOnly.inLine(6).under(typeof(ValueType)).oneOfThemContains("STRING"))
		assertConstraints(issues.errorsOnly.inLine(7).under(typeof(ValueType)).oneOfThemContains("STRING"))
		assertConstraints(issues.errorsOnly.inLine(8).under(typeof(ValueType)).oneOfThemContains("STRING"))
		assertConstraints(issues.errorsOnly.inLine(9).under(typeof(ValueType)).oneOfThemContains("STRING"))
		assertConstraints(issues.errorsOnly.inLine(10).under(typeof(ValueType)).oneOfThemContains("STRING"))
		assertConstraints(issues.errorsOnly.inLine(11).under(typeof(ValueType)).oneOfThemContains("STRING"))
		assertConstraints(issues.errorsOnly.inLine(12).under(typeof(ValueType)).oneOfThemContains("STRING"))
		assertConstraints(issues.errorsOnly.inLine(13).under(typeof(ValueType)).oneOfThemContains("AUTO"))
		assertConstraints(issues.errorsOnly.inLine(15).under(typeof(ValueType)).oneOfThemContains("STRING"))
		assertConstraints(issues.errorsOnly.inLine(16).under(typeof(ValueType)).oneOfThemContains("STRING"))
		
	}
}
