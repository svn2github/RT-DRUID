package com.eu.evidence.rtdruid.test.modules.oil.xtext.validation

import org.eclipse.xtext.junit4.InjectWith
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2
import org.eclipselabs.xtext.utils.unittesting.XtextTest
import org.junit.Test
import org.junit.runner.RunWith

import static com.eu.evidence.rtdruid.test.modules.oil.xtext.validation.NumberTests.*
import com.eu.evidence.rtdruid.test.modules.oil.xtext.OilInjectorProvider
import com.eu.evidence.rtdruid.test.modules.oil.xtext.PackageProvider
import com.eu.evidence.rtdruid.oil.xtext.model.Parameter
import com.eu.evidence.rtdruid.oil.xtext.model.ValueType

@RunWith(typeof(XtextRunner2))
@InjectWith(typeof(OilInjectorProvider))
class NumberTests extends XtextTest {
	static String path = PackageProvider::DEFAULT.computeBundleClassPath(typeof(NumberTests))
 	new() {
		super(path)
	}


	@Test
	def void int32Test() {
		ignoreFormattingDifferences()
		testFile("testNumberInt32.oil")
		
		assertConstraints(issues.errorsOnly
			.inLine(19)
			.under(typeof(Parameter))
			.oneOfThemContains("Expected a valid")
			.oneOfThemContains("INT32")
			.oneOfThemContains("1.0")
		)
		assertConstraints(issues.errorsOnly
			.inLine(20)
			.under(typeof(Parameter))
			.oneOfThemContains("Expected a valid")
			.oneOfThemContains("INT32")
			.oneOfThemContains("-1.0")
		)
		assertConstraints(issues.errorsOnly
			.inLine(23)
			.under(typeof(Parameter))
			.oneOfThemContains("Expected a valid")
			.oneOfThemContains("INT32")
			.oneOfThemContains("0xFFFFFFFFF")
		)
		assertConstraints(issues.errorsOnly
			.inLine(25)
			.under(typeof(Parameter))
			.oneOfThemContains("does not support AUTO")
		)
		
	}

	@Test
	def void int64Test() {
		ignoreFormattingDifferences()
		testFile("testNumberInt64.oil")
		
		assertConstraints(issues.errorsOnly
			.inLine(19)
			.under(typeof(Parameter))
			.oneOfThemContains("Expected a valid")
			.oneOfThemContains("INT64")
			.oneOfThemContains("1.0")
		)
		assertConstraints(issues.errorsOnly
			.inLine(20)
			.under(typeof(Parameter))
			.oneOfThemContains("Expected a valid")
			.oneOfThemContains("INT64")
			.oneOfThemContains("-1.0")
		)
		assertConstraints(issues.errorsOnly
			.inLine(23)
			.under(typeof(Parameter))
			.oneOfThemContains("Expected a valid")
			.oneOfThemContains("INT64")
			.oneOfThemContains("0xFFFFFFFFF")
		)
		assertConstraints(issues.errorsOnly
			.inLine(25)
			.under(typeof(Parameter))
			.oneOfThemContains("does not support AUTO")
		)
	}

	@Test
	def void unit32Test() {
		ignoreFormattingDifferences()
		testFile("testNumberUInt32.oil")
		
		assertConstraints(issues.errorsOnly
			.inLine(27)
			.under(typeof(Parameter))
			.oneOfThemContains("Expected a positive value")
			.oneOfThemContains("-2")
		)
		assertConstraints(issues.warningsOnly
			.inLine(18)
			.under(typeof(Parameter))
			.oneOfThemContains("Assign -1")
			.oneOfThemContains("UINT32")
		)
		assertConstraints(issues.errorsOnly
			.inLine(19)
			.under(typeof(Parameter))
			.oneOfThemContains("Expected a valid")
			.oneOfThemContains("UINT32")
			.oneOfThemContains("1.0")
		)
		assertConstraints(issues.errorsOnly
			.inLine(20)
			.under(typeof(Parameter))
			.oneOfThemContains("Expected a valid")
			.oneOfThemContains("UINT32")
			.oneOfThemContains("-1.0")
		)
		assertConstraints(issues.errorsOnly
			.inLine(22)
			.under(typeof(Parameter))
			.oneOfThemContains("Expected a valid")
			.oneOfThemContains("UINT32")
			.oneOfThemContains("-0x1")
		)
		assertConstraints(issues.errorsOnly
			.inLine(23)
			.under(typeof(Parameter))
			.oneOfThemContains("does not fit")
			.oneOfThemContains("UINT32")
			.oneOfThemContains("0xFFFFFFFFF")
		)
		assertConstraints(issues.errorsOnly
			.inLine(25)
			.under(typeof(Parameter))
			.oneOfThemContains("does not support AUTO")
		)
	}
	@Test
	def void unit64Test() {
		ignoreFormattingDifferences()
		testFile("testNumberUInt64.oil")
		
		assertConstraints(issues.errorsOnly
			.inLine(27)
			.under(typeof(Parameter))
			.oneOfThemContains("Expected a positive value")
			.oneOfThemContains("-2")
		)
		assertConstraints(issues.warningsOnly
			.inLine(18)
			.under(typeof(Parameter))
			.oneOfThemContains("Assign -1")
			.oneOfThemContains("UINT64")
		)
		assertConstraints(issues.errorsOnly
			.inLine(19)
			.under(typeof(Parameter))
			.oneOfThemContains("Expected a valid")
			.oneOfThemContains("UINT64")
			.oneOfThemContains("1.0")
		)
		assertConstraints(issues.errorsOnly
			.inLine(20)
			.under(typeof(Parameter))
			.oneOfThemContains("Expected a valid")
			.oneOfThemContains("UINT64")
			.oneOfThemContains("-1.0")
		)
		assertConstraints(issues.errorsOnly
			.inLine(22)
			.under(typeof(Parameter))
			.oneOfThemContains("Expected a valid")
			.oneOfThemContains("UINT64")
			.oneOfThemContains("-0x1")
		)
		assertConstraints(issues.errorsOnly
			.inLine(23)
			.under(typeof(Parameter))
			.oneOfThemContains("does not fit")
			.oneOfThemContains("UINT64")
			.oneOfThemContains("0xFFFFFFFFF")
		)
		assertConstraints(issues.errorsOnly
			.inLine(25)
			.under(typeof(Parameter))
			.oneOfThemContains("does not support AUTO")
		)
	}
	@Test
	def void floatTest() {
		ignoreFormattingDifferences()
		testFile("testNumberFloat.oil")
		
		assertConstraints(issues.errorsOnly
			.inLine(20)
			.under(typeof(Parameter))
			.oneOfThemContains("Expected a valid")
			.oneOfThemContains("FLOAT")
			.oneOfThemContains("0x1")
		)
		assertConstraints(issues.errorsOnly
			.inLine(21)
			.under(typeof(Parameter))
			.oneOfThemContains("Expected a valid")
			.oneOfThemContains("FLOAT")
			.oneOfThemContains("0xFFFFFFFFF")
		)
		assertConstraints(issues.errorsOnly
			.inLine(22)
			.under(typeof(Parameter))
			.oneOfThemContains("Expected a valid")
			.oneOfThemContains("FLOAT")
			.oneOfThemContains("0xAFFFFFF")
		)
		assertConstraints(issues.errorsOnly
			.inLine(23)
			.under(typeof(Parameter))
			.oneOfThemContains("does not support AUTO")
		)
	}
	@Test
	def void doubleTest() {
		ignoreFormattingDifferences()
		testFile("testNumberDouble.oil")
		
		assertConstraints(issues.errorsOnly
			.inLine(20)
			.under(typeof(Parameter))
			.oneOfThemContains("Expected a valid")
			.oneOfThemContains("DOUBLE")
			.oneOfThemContains("0x1")
		)
		assertConstraints(issues.errorsOnly
			.inLine(21)
			.under(typeof(Parameter))
			.oneOfThemContains("Expected a valid")
			.oneOfThemContains("DOUBLE")
			.oneOfThemContains("0xFFFFFFFFF")
		)
		assertConstraints(issues.errorsOnly
			.inLine(22)
			.under(typeof(Parameter))
			.oneOfThemContains("Expected a valid")
			.oneOfThemContains("DOUBLE")
			.oneOfThemContains("0xFFFFFF")
		)
		assertConstraints(issues.errorsOnly
			.inLine(23)
			.under(typeof(Parameter))
			.oneOfThemContains("does not support AUTO")
		)
	}

	@Test
	def void composedNumberTest() {
		ignoreFormattingDifferences()
		testFile("testNumberComposed.oil")

		assertConstraints(issues.errorsOnly
			.inLine(22)
			.under(typeof(Parameter))
			.oneOfThemContains("cannot contain sub-element")
		)
		assertConstraints(issues.errorsOnly
			.inLine(23)
			.under(typeof(Parameter))
			.oneOfThemContains("cannot contain sub-element")
		)
		assertConstraints(issues.errorsOnly
			.inLine(24)
			.under(typeof(Parameter))
			.oneOfThemContains("cannot contain sub-element")
		)
		assertConstraints(issues.errorsOnly
			.inLine(25)
			.under(typeof(Parameter))
			.oneOfThemContains("cannot contain sub-element")
		)
		assertConstraints(issues.errorsOnly
			.inLine(26)
			.under(typeof(Parameter))
			.oneOfThemContains("cannot contain sub-element")
		)
		assertConstraints(issues.errorsOnly
			.inLine(27)
			.under(typeof(Parameter))
			.oneOfThemContains("cannot contain sub-element")
		)
		
		assertConstraints(issues.errorsOnly
			.inLine(29)
			.under(typeof(Parameter))
			.oneOfThemContains("cannot contain sub-element")
			.oneOfThemContains("set to AUTO")
		)
		assertConstraints(issues.errorsOnly
			.inLine(30)
			.under(typeof(Parameter))
			.oneOfThemContains("cannot contain sub-element")
			.oneOfThemContains("set to AUTO")
		)
		assertConstraints(issues.errorsOnly
			.inLine(31)
			.under(typeof(Parameter))
			.oneOfThemContains("cannot contain sub-element")
			.oneOfThemContains("set to AUTO")
		)
		assertConstraints(issues.errorsOnly
			.inLine(32)
			.under(typeof(Parameter))
			.oneOfThemContains("cannot contain sub-element")
			.oneOfThemContains("set to AUTO")
		)
		assertConstraints(issues.errorsOnly
			.inLine(33)
			.under(typeof(Parameter))
			.oneOfThemContains("cannot contain sub-element")
			.oneOfThemContains("set to AUTO")
		)
		assertConstraints(issues.errorsOnly
			.inLine(34)
			.under(typeof(Parameter))
			.oneOfThemContains("cannot contain sub-element")
			.oneOfThemContains("set to AUTO")
		)
	}

	@Test
	def void defaultNumberTest() {
		ignoreFormattingDifferences()
		testFile("testNumberDefault.oil")
		assertConstraints(issues.errorsOnly.inLine(7).under(typeof(ValueType)).oneOfThemContains("INT32"))
		assertConstraints(issues.errorsOnly.inLine(8).under(typeof(ValueType)).oneOfThemContains("INT32"))
//		assertConstraints(issues.errorsOnly.inLine(10).under(typeof(ValueType)).oneOfThemContains("INT32"))
		assertConstraints(issues.errorsOnly.inLine(11).under(typeof(ValueType)).oneOfThemContains("INT32"))
		assertConstraints(issues.errorsOnly.inLine(13).under(typeof(ValueType)).oneOfThemContains("AUTO"))
		assertConstraints(issues.errorsOnly.inLine(15).under(typeof(ValueType)).oneOfThemContains("INT32"))
		assertConstraints(issues.errorsOnly.inLine(16).under(typeof(ValueType)).oneOfThemContains("INT32"))
		assertConstraints(issues.errorsOnly.inLine(17).under(typeof(ValueType)).oneOfThemContains("INT32"))
		
		assertConstraints(issues.warningsOnly.inLine(21).under(typeof(ValueType)).oneOfThemContains("Assign -1"))
		assertConstraints(issues.errorsOnly.inLine(22).under(typeof(ValueType)).oneOfThemContains("positive"))
		assertConstraints(issues.errorsOnly.inLine(23).under(typeof(ValueType)).oneOfThemContains("UINT32"))
		assertConstraints(issues.errorsOnly.inLine(24).under(typeof(ValueType)).oneOfThemContains("UINT32"))
		assertConstraints(issues.errorsOnly.inLine(26).under(typeof(ValueType)).oneOfThemContains("UINT32"))
		assertConstraints(issues.errorsOnly.inLine(27).under(typeof(ValueType)).oneOfThemContains("UINT32"))
		assertConstraints(issues.errorsOnly.inLine(29).under(typeof(ValueType)).oneOfThemContains("AUTO"))
		assertConstraints(issues.errorsOnly.inLine(31).under(typeof(ValueType)).oneOfThemContains("UINT32"))
		assertConstraints(issues.errorsOnly.inLine(32).under(typeof(ValueType)).oneOfThemContains("UINT32"))
		assertConstraints(issues.errorsOnly.inLine(33).under(typeof(ValueType)).oneOfThemContains("UINT32"))
		
		assertConstraints(issues.errorsOnly.inLine(38).under(typeof(ValueType)).oneOfThemContains("INT64"))
		assertConstraints(issues.errorsOnly.inLine(39).under(typeof(ValueType)).oneOfThemContains("INT64"))
//		assertConstraints(issues.errorsOnly.inLine(41).under(typeof(ValueType)).oneOfThemContains("INT64"))
		assertConstraints(issues.errorsOnly.inLine(44).under(typeof(ValueType)).oneOfThemContains("AUTO"))
		assertConstraints(issues.errorsOnly.inLine(46).under(typeof(ValueType)).oneOfThemContains("INT64"))
		assertConstraints(issues.errorsOnly.inLine(47).under(typeof(ValueType)).oneOfThemContains("INT64"))
		assertConstraints(issues.errorsOnly.inLine(48).under(typeof(ValueType)).oneOfThemContains("INT64"))
		
		assertConstraints(issues.warningsOnly.inLine(52).under(typeof(ValueType)).oneOfThemContains("Assign -1"))
		assertConstraints(issues.errorsOnly.inLine(53).under(typeof(ValueType)).oneOfThemContains("positive"))
		assertConstraints(issues.errorsOnly.inLine(54).under(typeof(ValueType)).oneOfThemContains("UINT64"))
		assertConstraints(issues.errorsOnly.inLine(55).under(typeof(ValueType)).oneOfThemContains("UINT64"))
		assertConstraints(issues.errorsOnly.inLine(57).under(typeof(ValueType)).oneOfThemContains("UINT64"))
		assertConstraints(issues.errorsOnly.inLine(60).under(typeof(ValueType)).oneOfThemContains("AUTO"))
		assertConstraints(issues.errorsOnly.inLine(62).under(typeof(ValueType)).oneOfThemContains("UINT64"))
		assertConstraints(issues.errorsOnly.inLine(63).under(typeof(ValueType)).oneOfThemContains("UINT64"))
		assertConstraints(issues.errorsOnly.inLine(64).under(typeof(ValueType)).oneOfThemContains("UINT64"))
		
		assertConstraints(issues.errorsOnly.inLine(71).under(typeof(ValueType)).oneOfThemContains("FLOAT"))
		assertConstraints(issues.errorsOnly.inLine(72).under(typeof(ValueType)).oneOfThemContains("FLOAT"))
		assertConstraints(issues.errorsOnly.inLine(73).under(typeof(ValueType)).oneOfThemContains("FLOAT"))
		assertConstraints(issues.errorsOnly.inLine(74).under(typeof(ValueType)).oneOfThemContains("FLOAT"))
		assertConstraints(issues.errorsOnly.inLine(75).under(typeof(ValueType)).oneOfThemContains("AUTO"))
		assertConstraints(issues.errorsOnly.inLine(77).under(typeof(ValueType)).oneOfThemContains("FLOAT"))
		assertConstraints(issues.errorsOnly.inLine(78).under(typeof(ValueType)).oneOfThemContains("FLOAT"))
		assertConstraints(issues.errorsOnly.inLine(79).under(typeof(ValueType)).oneOfThemContains("FLOAT"))
		
		assertConstraints(issues.errorsOnly.inLine(86).under(typeof(ValueType)).oneOfThemContains("DOUBLE"))
		assertConstraints(issues.errorsOnly.inLine(87).under(typeof(ValueType)).oneOfThemContains("DOUBLE"))
		assertConstraints(issues.errorsOnly.inLine(88).under(typeof(ValueType)).oneOfThemContains("DOUBLE"))
		assertConstraints(issues.errorsOnly.inLine(89).under(typeof(ValueType)).oneOfThemContains("DOUBLE"))
		assertConstraints(issues.errorsOnly.inLine(90).under(typeof(ValueType)).oneOfThemContains("AUTO"))
		assertConstraints(issues.errorsOnly.inLine(92).under(typeof(ValueType)).oneOfThemContains("DOUBLE"))
		assertConstraints(issues.errorsOnly.inLine(93).under(typeof(ValueType)).oneOfThemContains("DOUBLE"))
		assertConstraints(issues.errorsOnly.inLine(94).under(typeof(ValueType)).oneOfThemContains("DOUBLE"))
	}	
}
