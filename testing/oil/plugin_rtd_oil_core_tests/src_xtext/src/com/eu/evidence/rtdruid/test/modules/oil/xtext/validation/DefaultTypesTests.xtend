package com.eu.evidence.rtdruid.test.modules.oil.xtext.validation

import com.eu.evidence.rtdruid.test.modules.oil.xtext.OilInjectorProvider
import com.eu.evidence.rtdruid.test.modules.oil.xtext.PackageProvider
import org.eclipse.xtext.junit4.InjectWith
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2
import org.eclipselabs.xtext.utils.unittesting.XtextTest
import org.junit.Test
import org.junit.runner.RunWith

import static com.eu.evidence.rtdruid.test.modules.oil.xtext.validation.DefaultTypesTests.*
import org.junit.Ignore

@RunWith(typeof(XtextRunner2))
@InjectWith(typeof(OilInjectorProvider))
class DefaultTypesTests extends XtextTest {
	static String path = PackageProvider::DEFAULT.computeBundleClassPath(typeof(DefaultTypesTests))
 	new() {
		super(path)
	}

	@Test
	def void complexTest() {
		suppressSerialization()
		testFile("complexDefaultImpl001.oil")
	}

	@Test
	@Ignore
	def void complexTestTiming() {
		suppressSerialization()
		var int i = 0;
		do { 
			testFile("complexDefaultImpl001.oil")
			i = i+1
		} while (i<100);
	}
	
}
