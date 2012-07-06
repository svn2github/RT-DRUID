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
import com.eu.evidence.rtdruid.oil.xtext.model.Range
import com.eu.evidence.rtdruid.oil.xtext.model.ValueList

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
	}	
	
		@Test
	def void numberRangeTest() {
		ignoreFormattingDifferences()
		testFile("testRange.oil")
		
		assertConstraints(issues.errorsOnly.inLine(7).under(typeof(Range)).oneOfThemContains("bigger"))
		assertConstraints(issues.errorsOnly.inLine(19).under(typeof(ValueType)).oneOfThemContains("bigger"))
		assertConstraints(issues.errorsOnly.inLine(22).under(typeof(ValueType)).oneOfThemContains("bigger"))
		assertConstraints(issues.errorsOnly.inLine(24).under(typeof(ValueType)).oneOfThemContains("bigger"))
		assertConstraints(issues.errorsOnly.inLine(42).under(typeof(ValueType)).oneOfThemContains("bigger"))
		assertConstraints(issues.errorsOnly.inLine(45).under(typeof(ValueType)).oneOfThemContains("bigger"))
		assertConstraints(issues.errorsOnly.inLine(46).under(typeof(ValueType)).oneOfThemContains("bigger"))
		assertConstraints(issues.errorsOnly.inLine(49).under(typeof(Range)).oneOfThemContains("bigger").oneOfThemContains("-1"))
		assertConstraints(issues.errorsOnly.inLine(49).under(typeof(ValueType)).oneOfThemContains("bigger").oneOfThemContains("0x4"))
		assertConstraints(issues.errorsOnly.inLine(55).under(typeof(Range)).oneOfThemContains("bigger"))
		assertConstraints(issues.errorsOnly.inLine(67).under(typeof(ValueType)).oneOfThemContains("bigger"))
		assertConstraints(issues.errorsOnly.inLine(70).under(typeof(ValueType)).oneOfThemContains("bigger"))
		assertConstraints(issues.errorsOnly.inLine(72).under(typeof(ValueType)).oneOfThemContains("bigger"))
		assertConstraints(issues.errorsOnly.inLine(90).under(typeof(ValueType)).oneOfThemContains("bigger"))
		assertConstraints(issues.errorsOnly.inLine(93).under(typeof(ValueType)).oneOfThemContains("bigger"))
		assertConstraints(issues.errorsOnly.inLine(94).under(typeof(ValueType)).oneOfThemContains("bigger"))
		assertConstraints(issues.errorsOnly.inLine(97).under(typeof(Range)).oneOfThemContains("bigger"))
		assertConstraints(issues.errorsOnly.inLine(103).under(typeof(Range)).oneOfThemContains("bigger"))
		assertConstraints(issues.errorsOnly.inLine(115).under(typeof(ValueType)).oneOfThemContains("bigger"))
		assertConstraints(issues.errorsOnly.inLine(118).under(typeof(ValueType)).oneOfThemContains("bigger"))
		assertConstraints(issues.errorsOnly.inLine(137).under(typeof(Parameter)).oneOfThemContains("bigger"))
		assertConstraints(issues.errorsOnly.inLine(139).under(typeof(Parameter)).oneOfThemContains("bigger"))
		assertConstraints(issues.errorsOnly.inLine(149).under(typeof(Parameter)).oneOfThemContains("bigger"))
		assertConstraints(issues.errorsOnly.inLine(150).under(typeof(Parameter)).oneOfThemContains("bigger"))
		assertConstraints(issues.errorsOnly.inLine(161).under(typeof(Parameter)).oneOfThemContains("bigger"))
		assertConstraints(issues.errorsOnly.inLine(163).under(typeof(Parameter)).oneOfThemContains("bigger"))
		assertConstraints(issues.errorsOnly.inLine(173).under(typeof(Parameter)).oneOfThemContains("bigger"))
		assertConstraints(issues.errorsOnly.inLine(174).under(typeof(Parameter)).oneOfThemContains("bigger"))
		assertConstraints(issues.errorsOnly.inLine(185).under(typeof(Parameter)).oneOfThemContains("bigger"))
		
		assertConstraints(issues.errorsOnly.inLine(9).under(typeof(Range)).oneOfThemContains("Expected").oneOfThemContains("INT32"))
		assertConstraints(issues.errorsOnly.inLine(10).under(typeof(Range)).oneOfThemContains("Expected").oneOfThemContains("INT32"))
		assertConstraints(issues.errorsOnly.inLine(29).under(typeof(Range)).oneOfThemContains("Expected").oneOfThemContains("positive"))
		assertConstraints(issues.errorsOnly.inLine(32).under(typeof(Range)).oneOfThemContains("Expected").oneOfThemContains("UINT32"))
		assertConstraints(issues.errorsOnly.inLine(33).under(typeof(Range)).oneOfThemContains("Expected").oneOfThemContains("UINT32"))
		assertConstraints(issues.errorsOnly.inLine(57).under(typeof(Range)).oneOfThemContains("Expected").oneOfThemContains("INT64"))
		assertConstraints(issues.errorsOnly.inLine(58).under(typeof(Range)).oneOfThemContains("Expected").oneOfThemContains("INT64"))
		assertConstraints(issues.errorsOnly.inLine(77).under(typeof(Range)).oneOfThemContains("Expected").oneOfThemContains("positive"))
		assertConstraints(issues.errorsOnly.inLine(80).under(typeof(Range)).oneOfThemContains("Expected").oneOfThemContains("UINT64"))
		assertConstraints(issues.errorsOnly.inLine(81).under(typeof(Range)).oneOfThemContains("Expected").oneOfThemContains("UINT64"))
		assertConstraints(issues.errorsOnly.inLine(119).under(typeof(ValueType)).oneOfThemContains("Expected").oneOfThemContains("FLOAT"))
		assertConstraints(issues.errorsOnly.inLine(121).under(typeof(Range)).oneOfThemContains("Expected").oneOfThemContains("FLOAT"))
		assertConstraints(issues.errorsOnly.inLine(122).under(typeof(Range)).oneOfThemContains("Expected").oneOfThemContains("FLOAT"))
		assertConstraints(issues.errorsOnly.inLine(123).under(typeof(Range)).oneOfThemContains("Expected").oneOfThemContains("FLOAT").oneOfThemContains("0x0"))
		assertConstraints(issues.errorsOnly.inLine(123).under(typeof(Range)).oneOfThemContains("Expected").oneOfThemContains("FLOAT").oneOfThemContains("0x5"))
		assertConstraints(issues.errorsOnly.inLine(186).under(typeof(Parameter)).oneOfThemContains("Expected").oneOfThemContains("FLOAT"))
		assertConstraints(issues.errorsOnly.inLine(188).under(typeof(Parameter)).oneOfThemContains("Expected").oneOfThemContains("FLOAT"))

		assertConstraints(issues.errorsOnly.inLine(18).under(typeof(ValueType)).oneOfThemContains("smaller"))
		assertConstraints(issues.errorsOnly.inLine(20).under(typeof(ValueType)).oneOfThemContains("smaller"))
		assertConstraints(issues.errorsOnly.inLine(23).under(typeof(ValueType)).oneOfThemContains("smaller"))
		assertConstraints(issues.errorsOnly.inLine(41).under(typeof(ValueType)).oneOfThemContains("smaller"))
		assertConstraints(issues.errorsOnly.inLine(43).under(typeof(ValueType)).oneOfThemContains("smaller"))
		assertConstraints(issues.errorsOnly.inLine(48).under(typeof(ValueType)).oneOfThemContains("smaller"))
		assertConstraints(issues.errorsOnly.inLine(49).under(typeof(ValueType)).oneOfThemContains("smaller"))
		assertConstraints(issues.errorsOnly.inLine(66).under(typeof(ValueType)).oneOfThemContains("smaller"))
		assertConstraints(issues.errorsOnly.inLine(68).under(typeof(ValueType)).oneOfThemContains("smaller"))
		assertConstraints(issues.errorsOnly.inLine(71).under(typeof(ValueType)).oneOfThemContains("smaller"))
		assertConstraints(issues.errorsOnly.inLine(89).under(typeof(ValueType)).oneOfThemContains("smaller"))
		assertConstraints(issues.errorsOnly.inLine(91).under(typeof(ValueType)).oneOfThemContains("smaller"))
		assertConstraints(issues.errorsOnly.inLine(96).under(typeof(ValueType)).oneOfThemContains("smaller"))
		assertConstraints(issues.errorsOnly.inLine(97).under(typeof(ValueType)).oneOfThemContains("smaller"))
		assertConstraints(issues.errorsOnly.inLine(114).under(typeof(ValueType)).oneOfThemContains("smaller"))
		assertConstraints(issues.errorsOnly.inLine(116).under(typeof(ValueType)).oneOfThemContains("smaller"))
		
		assertConstraints(issues.errorsOnly.inLine(131).under(typeof(Parameter)).oneOfThemContains("smaller"))
		assertConstraints(issues.errorsOnly.inLine(136).under(typeof(Parameter)).oneOfThemContains("smaller"))
		assertConstraints(issues.errorsOnly.inLine(143).under(typeof(Parameter)).oneOfThemContains("smaller"))
		assertConstraints(issues.errorsOnly.inLine(148).under(typeof(Parameter)).oneOfThemContains("smaller"))
		assertConstraints(issues.errorsOnly.inLine(155).under(typeof(Parameter)).oneOfThemContains("smaller"))
		assertConstraints(issues.errorsOnly.inLine(160).under(typeof(Parameter)).oneOfThemContains("smaller"))
		assertConstraints(issues.errorsOnly.inLine(167).under(typeof(Parameter)).oneOfThemContains("smaller"))
		assertConstraints(issues.errorsOnly.inLine(172).under(typeof(Parameter)).oneOfThemContains("smaller"))
		assertConstraints(issues.errorsOnly.inLine(179).under(typeof(Parameter)).oneOfThemContains("smaller"))
		assertConstraints(issues.errorsOnly.inLine(184).under(typeof(Parameter)).oneOfThemContains("smaller"))
		
		assertConstraints(issues.warningsOnly.inLine(30).under(typeof(Range)).oneOfThemContains("Assign -1"))
		assertConstraints(issues.warningsOnly.inLine(46).under(typeof(ValueType)).oneOfThemContains("Assign -1"))
//		assertConstraints(issues.warningsOnly.inLine(47).under(typeof(Range)).oneOfThemContains("Assign -1"))
		assertConstraints(issues.warningsOnly.inLine(47).under(typeof(Range)).oneOfThemContains("Assign -1"))
		assertConstraints(issues.warningsOnly.inLine(47).under(typeof(ValueType)).oneOfThemContains("Assign -1"))
		assertConstraints(issues.warningsOnly.inLine(49).under(typeof(Range)).oneOfThemContains("Assign -1"))
		assertConstraints(issues.warningsOnly.inLine(50).under(typeof(Range)).oneOfThemContains("Assign -1"))
		assertConstraints(issues.warningsOnly.inLine(78).under(typeof(Range)).oneOfThemContains("Assign -1"))
		assertConstraints(issues.warningsOnly.inLine(94).under(typeof(ValueType)).oneOfThemContains("Assign -1"))
//		assertConstraints(issues.warningsOnly.inLine(95).under(typeof(Range)).oneOfThemContains("Assign -1"))
		assertConstraints(issues.warningsOnly.inLine(95).under(typeof(Range)).oneOfThemContains("Assign -1"))
		assertConstraints(issues.warningsOnly.inLine(95).under(typeof(ValueType)).oneOfThemContains("Assign -1"))
		assertConstraints(issues.warningsOnly.inLine(97).under(typeof(Range)).oneOfThemContains("Assign -1"))
		assertConstraints(issues.warningsOnly.inLine(98).under(typeof(Range)).oneOfThemContains("Assign -1"))
		assertConstraints(issues.warningsOnly.inLine(151).under(typeof(Parameter)).oneOfThemContains("Assign -1"))
		assertConstraints(issues.warningsOnly.inLine(175).under(typeof(Parameter)).oneOfThemContains("Assign -1"))
		
	}	

		@Test
	def void numberListTest() {
		ignoreSerializationDifferences()
		testFile("testList.oil")
		
		assertConstraints(issues.warningsOnly.inLine(21).under(typeof(ValueList)).oneOfThemContains("Assign -1"))
		assertConstraints(issues.warningsOnly.inLine(23).under(typeof(ValueList)).oneOfThemContains("Assign -1"))
		assertConstraints(issues.warningsOnly.inLine(24).under(typeof(ValueList)).oneOfThemContains("Assign -1"))
		assertConstraints(issues.warningsOnly.inLine(29).under(typeof(ValueList)).oneOfThemContains("Assign -1"))
		assertConstraints(issues.warningsOnly.inLine(30).under(typeof(ValueList)).oneOfThemContains("Assign -1"))
		assertConstraints(issues.warningsOnly.inLine(30).under(typeof(ValueType)).oneOfThemContains("Assign -1"))
		assertConstraints(issues.warningsOnly.inLine(31).under(typeof(ValueList)).oneOfThemContains("Assign -1"))
		assertConstraints(issues.warningsOnly.inLine(53).under(typeof(ValueList)).oneOfThemContains("Assign -1"))
		assertConstraints(issues.warningsOnly.inLine(55).under(typeof(ValueList)).oneOfThemContains("Assign -1"))
		assertConstraints(issues.warningsOnly.inLine(56).under(typeof(ValueList)).oneOfThemContains("Assign -1"))
		assertConstraints(issues.warningsOnly.inLine(61).under(typeof(ValueList)).oneOfThemContains("Assign -1"))
		assertConstraints(issues.warningsOnly.inLine(62).under(typeof(ValueList)).oneOfThemContains("Assign -1"))
		assertConstraints(issues.warningsOnly.inLine(62).under(typeof(ValueType)).oneOfThemContains("Assign -1"))
		assertConstraints(issues.warningsOnly.inLine(63).under(typeof(ValueList)).oneOfThemContains("Assign -1"))
		
		
		assertConstraints(issues.errorsOnly.inLine(13).under(typeof(ValueType)).oneOfThemContains("is not").oneOfThemContains("valid"))
		assertConstraints(issues.errorsOnly.inLine(29).under(typeof(ValueType)).oneOfThemContains("is not").oneOfThemContains("valid"))
		assertConstraints(issues.errorsOnly.inLine(45).under(typeof(ValueType)).oneOfThemContains("is not").oneOfThemContains("valid"))
		assertConstraints(issues.errorsOnly.inLine(61).under(typeof(ValueType)).oneOfThemContains("is not").oneOfThemContains("valid"))
		assertConstraints(issues.errorsOnly.inLine(77).under(typeof(ValueType)).oneOfThemContains("is not").oneOfThemContains("valid"))
		assertConstraints(issues.errorsOnly.inLine(80).under(typeof(ValueType)).oneOfThemContains("is not").oneOfThemContains("valid"))
		assertConstraints(issues.errorsOnly.inLine(91).under(typeof(Parameter)).oneOfThemContains("is not").oneOfThemContains("valid"))
		assertConstraints(issues.errorsOnly.inLine(93).under(typeof(Parameter)).oneOfThemContains("is not").oneOfThemContains("valid"))
		assertConstraints(issues.errorsOnly.inLine(95).under(typeof(Parameter)).oneOfThemContains("is not").oneOfThemContains("valid"))
		assertConstraints(issues.errorsOnly.inLine(96).under(typeof(Parameter)).oneOfThemContains("is not").oneOfThemContains("valid"))
		assertConstraints(issues.errorsOnly.inLine(100).under(typeof(Parameter)).oneOfThemContains("is not").oneOfThemContains("valid"))
		assertConstraints(issues.errorsOnly.inLine(102).under(typeof(Parameter)).oneOfThemContains("is not").oneOfThemContains("valid"))
		assertConstraints(issues.errorsOnly.inLine(104).under(typeof(Parameter)).oneOfThemContains("is not").oneOfThemContains("valid"))
		assertConstraints(issues.errorsOnly.inLine(108).under(typeof(Parameter)).oneOfThemContains("is not").oneOfThemContains("valid"))
		assertConstraints(issues.errorsOnly.inLine(110).under(typeof(Parameter)).oneOfThemContains("is not").oneOfThemContains("valid"))
		assertConstraints(issues.errorsOnly.inLine(112).under(typeof(Parameter)).oneOfThemContains("is not").oneOfThemContains("valid"))
		assertConstraints(issues.errorsOnly.inLine(113).under(typeof(Parameter)).oneOfThemContains("is not").oneOfThemContains("valid"))
		assertConstraints(issues.errorsOnly.inLine(117).under(typeof(Parameter)).oneOfThemContains("is not").oneOfThemContains("valid"))
		assertConstraints(issues.errorsOnly.inLine(119).under(typeof(Parameter)).oneOfThemContains("is not").oneOfThemContains("valid"))
		assertConstraints(issues.errorsOnly.inLine(121).under(typeof(Parameter)).oneOfThemContains("is not").oneOfThemContains("valid"))
		assertConstraints(issues.errorsOnly.inLine(125).under(typeof(Parameter)).oneOfThemContains("is not").oneOfThemContains("valid"))
		assertConstraints(issues.errorsOnly.inLine(128).under(typeof(Parameter)).oneOfThemContains("is not").oneOfThemContains("valid"))
		
		
		assertConstraints(issues.errorsOnly.inLine(10).under(typeof(ValueList)).oneOfThemContains("Expected").oneOfThemContains("INT32"))
		assertConstraints(issues.errorsOnly.inLine(26).under(typeof(ValueList)).oneOfThemContains("Expected").oneOfThemContains("UINT32"))
		assertConstraints(issues.errorsOnly.inLine(31).under(typeof(ValueList)).oneOfThemContains("Expected").oneOfThemContains("positive"))
		assertConstraints(issues.errorsOnly.inLine(42).under(typeof(ValueList)).oneOfThemContains("Expected").oneOfThemContains("INT64"))
		assertConstraints(issues.errorsOnly.inLine(58).under(typeof(ValueList)).oneOfThemContains("Expected").oneOfThemContains("UINT64"))
		assertConstraints(issues.errorsOnly.inLine(63).under(typeof(ValueList)).oneOfThemContains("Expected").oneOfThemContains("positive"))
		assertConstraints(issues.errorsOnly.inLine(75).under(typeof(ValueList)).oneOfThemContains("Expected").oneOfThemContains("FLOAT"))
		assertConstraints(issues.errorsOnly.inLine(76).under(typeof(ValueList)).oneOfThemContains("Expected").oneOfThemContains("FLOAT").oneOfThemContains("0x1"))
		assertConstraints(issues.errorsOnly.inLine(76).under(typeof(ValueList)).oneOfThemContains("Expected").oneOfThemContains("FLOAT").oneOfThemContains("0x5"))
		assertConstraints(issues.errorsOnly.inLine(81).under(typeof(ValueList)).oneOfThemContains("Expected").oneOfThemContains("FLOAT"))
		assertConstraints(issues.errorsOnly.inLine(82).under(typeof(ValueType)).oneOfThemContains("Expected").oneOfThemContains("FLOAT"))
		assertConstraints(issues.errorsOnly.inLine(129).under(typeof(Parameter)).oneOfThemContains("Expected").oneOfThemContains("FLOAT"))
		
	}	
}
