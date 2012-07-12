package com.eu.evidence.rtdruid.test.modules.oil.xtext.parser

import com.google.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2
import org.eclipselabs.xtext.utils.unittesting.XtextTest
import org.junit.Test
import org.junit.runner.RunWith

import static com.eu.evidence.rtdruid.test.modules.oil.xtext.parser.ParsingTests.*
import static org.junit.Assert.*
import com.eu.evidence.rtdruid.test.modules.oil.xtext.OilInjectorProvider
import com.eu.evidence.rtdruid.test.modules.oil.xtext.PackageProvider
import com.eu.evidence.rtdruid.oil.xtext.model.OilFile

@RunWith(typeof(XtextRunner2))
@InjectWith(typeof(OilInjectorProvider))
class IncludeTests extends XtextTest {
	static String path = PackageProvider::DEFAULT.computeBundleClassPath(typeof(ParsingTests))
 	new() {
		super(path)
	}

	@Inject ParseHelper<OilFile> parser

	@Test
	def void includeNothingTest1() {
	    val model = parser.parse('''
			#include ""
		''')
		val resource = model.eResource
		assertTrue(resource.errors.toString, resource.errors.size == 0 && resource.warnings.size == 0 )
	}

	@Test
	def void includeNothingTest2() {
	    val model = parser.parse('''
			#include <>
		''')
		val resource = model.eResource
		assertTrue(resource.errors.toString, resource.errors.size == 0 && resource.warnings.size == 0 )
	}
	
	@Test
	def void onlyIncludeTest1() {
	    val model = parser.parse('''
			#include "a"
		''')
		val resource = model.eResource
		assertTrue(resource.errors.toString, resource.errors.size == 0 && resource.warnings.size == 0 )
	}

	@Test
	def void onlyIncludeTest2() {
	    val model = parser.parse('''
			#include <a>
		''')
		val resource = model.eResource
		assertTrue(resource.errors.toString, resource.errors.size == 0 && resource.warnings.size == 0 )
	}

	@Test
	def void includeCpuContentTestFail1() {
	    val model = parser.parse('''
			CPU s {
				#inlude
			};
		''')
		val resource = model.eResource
		assertTrue(resource.errors.toString, resource.errors.size == 2 && resource.warnings.size == 0 )
	}
	
	@Test
	def void includeCpuContentTestFail2() {
	    val model = parser.parse('''
			CPU s {
				#include 
			};
		''')
		val resource = model.eResource
		assertTrue(resource.errors.toString, resource.errors.size == 1 && resource.warnings.size == 0 )
	}
	
	@Test
	def void includeCpuContentTest1() {
	    val model = parser.parse('''
			CPU s {
				#include "a"
			};
		''')
		val resource = model.eResource
		assertTrue(resource.errors.toString, resource.errors.size == 0 && resource.warnings.size == 0 )
	}
	
	@Test
	def void includeCpuContentTest2() {
	    val model = parser.parse('''
			CPU s {
				#include <a>
			};
		''')
		val resource = model.eResource
		assertTrue(resource.errors.toString, resource.errors.size == 0 && resource.warnings.size == 0 )
	}
	
	
	@Test
	def void includeCpuContentTest3() {
	    val model = parser.parse('''
			CPU s {
				#include <a>};
		''')
		val resource = model.eResource
		assertTrue(resource.errors.toString, resource.errors.size == 0 && resource.warnings.size == 0 )
	}
	
	@Test
	def void includeCpuContentTest4() {
	    val model = parser.parse('''
			CPU s {#include <a>
			};
		''')
		val resource = model.eResource
		assertTrue(resource.errors.toString, resource.errors.size == 0 && resource.warnings.size == 0 )
	}
	@Test
	def void includeCpuContentTest5() {
	    val model = parser.parse('''
			CPU s {
				#include "a"};
		''')
		val resource = model.eResource
		assertTrue(resource.errors.toString, resource.errors.size == 0 && resource.warnings.size == 0 )
	}
	
	@Test
	def void includeCpuContentTest6() {
	    val model = parser.parse('''
			CPU s {#include "a"
			};
		''')
		val resource = model.eResource
		assertTrue(resource.errors.toString, resource.errors.size == 0 && resource.warnings.size == 0 )
	}
	
	@Test
	def void includeNoSpace1() {
	    val model = parser.parse('''
			CPU s {
				
			}#include"a";
		''')
		val resource = model.eResource
		assertTrue(resource.errors.toString, resource.errors.size == 0 && resource.warnings.size == 0 )
	}
		@Test
	def void includeNoSpace2() {
	    val model = parser.parse('''
			CPU s {
				
			}#include<a>;
		''')
		val resource = model.eResource
		assertTrue(resource.errors.toString, resource.errors.size == 0 && resource.warnings.size == 0 )
	}
	@Test
	def void includeSpace1() {
	    val model = parser.parse('''
			CPU s {
				
			}#include		"a";
		''')
		val resource = model.eResource
		assertTrue(resource.errors.toString, resource.errors.size == 0 && resource.warnings.size == 0 )
	}
		@Test
	def void includeSpace2() {
	    val model = parser.parse('''
			CPU s {
				
			}#include 	 <a>;
		''')
		val resource = model.eResource
		assertTrue(resource.errors.toString, resource.errors.size == 0 && resource.warnings.size == 0 )
	}

	@Test
	def void includeNewLineTest1() {
	    val model = parser.parse('''
			#include 
				"a"
		''')
		val resource = model.eResource
		assertTrue(resource.errors.toString, resource.errors.size == 2 && resource.warnings.size == 0 )
	}

	@Test
	def void includeNewTest2() {
	    val model = parser.parse('''
			#include 
			<a>
		''')
		val resource = model.eResource
		assertTrue(resource.errors.toString, resource.errors.size == 2 && resource.warnings.size == 0 )
	}	
}

