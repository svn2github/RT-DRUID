package com.eu.evidence.rtdruid.test.modules.oil.xtext;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.eu.evidence.rtdruid.test.modules.oil.xtext.parser.ParsingTests;
import com.eu.evidence.rtdruid.test.modules.oil.xtext.parser.ScopingTests;
import com.eu.evidence.rtdruid.test.modules.oil.xtext.validation.EnumTests;
import com.eu.evidence.rtdruid.test.modules.oil.xtext.validation.NumberTests;
import com.eu.evidence.rtdruid.test.modules.oil.xtext.validation.SimpleTests;
import com.eu.evidence.rtdruid.test.modules.oil.xtext.validation.SplittedElementsTests;



@RunWith(Suite.class)
@Suite.SuiteClasses({
	ParsingTests.class,
	ScopingTests.class,
	SimpleTests.class,
	NumberTests.class,
	EnumTests.class,
	SplittedElementsTests.class,
	})
public class TestSuite {

}
