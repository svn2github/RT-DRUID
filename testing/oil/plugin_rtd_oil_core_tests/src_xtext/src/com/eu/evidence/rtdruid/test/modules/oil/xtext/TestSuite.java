package com.eu.evidence.rtdruid.test.modules.oil.xtext;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.eu.evidence.rtdruid.test.modules.oil.xtext.parser.ParsingNumberRangeTests;
import com.eu.evidence.rtdruid.test.modules.oil.xtext.parser.ParsingTests;
import com.eu.evidence.rtdruid.test.modules.oil.xtext.parser.ScopingDefaultTypesTests;
import com.eu.evidence.rtdruid.test.modules.oil.xtext.parser.ScopingTests;
import com.eu.evidence.rtdruid.test.modules.oil.xtext.validation.DefaultTypesTests;
import com.eu.evidence.rtdruid.test.modules.oil.xtext.validation.EnumTests;
import com.eu.evidence.rtdruid.test.modules.oil.xtext.validation.NumberTests;
import com.eu.evidence.rtdruid.test.modules.oil.xtext.validation.SimpleTests;
import com.eu.evidence.rtdruid.test.modules.oil.xtext.validation.SplittedElementsTests;
import com.eu.evidence.rtdruid.test.modules.oil.xtext.validation.StringTests;
import com.eu.evidence.rtdruid.test.modules.oil.xtext.validation.ValidationOilWriterTests;
import com.eu.evidence.rtdruid.vartree.variables.OilVar;



@RunWith(Suite.class)
@Suite.SuiteClasses({
	ParsingTests.class,
	ScopingTests.class,
	ScopingDefaultTypesTests.class,
	SimpleTests.class,
	NumberTests.class,
	EnumTests.class,
	StringTests.class,
	SplittedElementsTests.class,
	DefaultTypesTests.class,
	ValidationOilWriterTests.class,
	ParsingNumberRangeTests.class
	})
public class TestSuite {

}
