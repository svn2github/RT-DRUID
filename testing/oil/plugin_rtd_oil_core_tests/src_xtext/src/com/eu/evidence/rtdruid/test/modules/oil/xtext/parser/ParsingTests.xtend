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
class ParsingTests extends XtextTest {
	static String path = PackageProvider::DEFAULT.computeBundleClassPath(typeof(ParsingTests))
 	new() {
		super(path)
	}

	@Inject ParseHelper<OilFile> parser

	@Test
	def void simplePositiveTest() {
	    val model = parser.parse('''
			IMPLEMENTATION a {
				OS {
				// 112;
					BOOLEAN [
						TRUE {
							INT32 b;
							BOOLEAN d;
						},
						FALSE
					] a;
					ALARM_TYPE at;
				};
				ALARM {
				};
			};
			CPU s {
				OS aa {
					at = FALSE;
					
					b = 122 2 123123 . 4 {
						
					};
					at = TRUE { 
						
					} : "a
			asdasd";
					b = "1";
					at = aaaasd;
					
					at = AUTO;
				};
				COM aa1 {
					d = "qw";
				};
				ALARM aaa {
				};
			};
		''')
		val resource = model.eResource
		assertTrue( resource.errors.size == 0 && resource.warnings.size == 0 )
	}

	@Test
	def void emptyApplicationOnlyTest() {
	    val model = parser.parse('''
			CPU s {
			};
		''')
		val resource = model.eResource
		assertTrue( resource.errors.size == 0 && resource.warnings.size == 0 )
	}

	@Test
	def void applicationOnlyTest() {
	    val model = parser.parse('''
			CPU s {
				OS aa {
					at = FALSE;
					
					b = 122 2 123123 . 4 {
						
					};
					at = TRUE { 
						
					} : "a
			asdasd";
					b = "1";
					at = aaaasd;
					
					at = AUTO;
				};
				COM aa1 {
					d = "qw";
				};
				ALARM aaa {
				};
			};
		''')
		val resource = model.eResource
		assertTrue( resource.errors.size == 0 && resource.warnings.size == 0 )
	}
	
	@Test
	def void implementationOnlyTest() {
	    val model = parser.parse('''
				IMPLEMENTATION a {
					OS {
					// 112;
						BOOLEAN [
							TRUE {
								INT32 b1;
								BOOLEAN d;
							},
							FALSE
						] a;
						ALARM_TYPE at;
					};
					ALARM {
					};
				};
	    ''')
		
		val resource = model.eResource
//		System::out.println(resource.errors);
		assertEquals(0, resource.errors.size)
		assertEquals(0, resource.warnings.size)
	}

	@Test
	def void implementationOnlyTestBis() {
	    val model = parser.parse('''
				IMPLEMENTATION a {
					OS {
					// 112;
						BOOLEAN [
							TRUE {
								INT32 b1;
								BOOLEAN d;
							},
							FALSE
						] a;
						ALARM_TYPE WITH_AUTO at;
					};
					ALARM {
					};
				};
	    ''')
		
		val resource = model.eResource
//		System::out.println(resource.errors);
		assertEquals(1, resource.errors.size)
		assertEquals(0, resource.warnings.size)
	}
	
	
		@Test
	def void composedValueTest() {
	    val model = parser.parse('''
				IMPLEMENTATION a {
					OS {
						INT32 b1;
					};
				};
				CPU s {
					OS aa {
						b1 = -1 {
							b1 = 2;
						};
					};
				};
	    ''')
		
		val resource = model.eResource
		assertEquals(0, resource.errors.size)
		assertEquals(0, resource.warnings.size)
	}
	
		@Test
	def void negativeHexTest() {
	    val model = parser.parse('''
				IMPLEMENTATION a {
					OS {
						INT32 b1;
					};
				};
				CPU s {
					OS aa {
						b1 = -0x1;
					};
				};
	    ''')
		
		val resource = model.eResource
		assertEquals(0, resource.errors.size)
		assertEquals(0, resource.warnings.size)
	}
}

