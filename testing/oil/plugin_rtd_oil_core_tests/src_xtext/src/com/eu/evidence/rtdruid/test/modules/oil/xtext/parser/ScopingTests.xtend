package com.eu.evidence.rtdruid.test.modules.oil.xtext.parser

import com.google.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.scoping.IScopeProvider
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2
import org.eclipselabs.xtext.utils.unittesting.XtextTest
import org.hamcrest.Matchers
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import com.eu.evidence.rtdruid.test.modules.oil.xtext.OilInjectorProvider
import com.eu.evidence.rtdruid.oil.xtext.model.OilFile
import com.eu.evidence.rtdruid.oil.xtext.model.ObjectType
import com.eu.evidence.rtdruid.oil.xtext.model.OilPackage

//@RunWith(typeof(ParameterizedXtextRunner))

@RunWith(typeof(XtextRunner2))
@InjectWith(typeof(OilInjectorProvider))
class ScopingTests extends XtextTest {

	@Inject private IScopeProvider scopeProvider
	@Inject ParseHelper<OilFile> parser

//	@ParameterSyntax("('@' offset=OFFSET)?")
//	@XpectCommaSeparatedValues
	@Test
	def void elementsInScope() {
		val model = parser.parse('''
			IMPLEMENTATION a {
				OS {
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
				};
			};
		''')
		val os = model.application.oilObjects.get(0)
		Assert::assertSame(ObjectType::OS, os.type)
		
		val scope = scopeProvider.getScope(os, OilPackage::eINSTANCE.oilObject_Parameters)
		println(scope.allElements.map[it.name.toString])
		Assert::assertEquals(2, scope.allElements.size)
		Assert::assertThat(scope.allElements.map[it.name.toString], Matchers::allOf(Matchers::hasItem("a"), Matchers::hasItem("at")))
	}

	@Test
	def void enumScope() {
		val model = parser.parse('''
			IMPLEMENTATION a {
				OS {
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
					a = TRUE { 
						
					} : "a
			asdasd";
				};
				ALARM alarm1 {
				};
			};
		''')
		val os = model.application.oilObjects.get(0)
		Assert::assertSame(ObjectType::OS, os.type)
		val a = os.parameters.get(0)
		Assert::assertEquals("a", a.type.name)
		{		
			val scope = scopeProvider.getScope(a, OilPackage::eINSTANCE.parameter_Type)
			println(scope.allElements.map[it.name.toString])
			Assert::assertEquals(2, scope.allElements.size)
			Assert::assertThat(scope.allElements.map[it.name.toString], Matchers::allOf(Matchers::hasItem("a"), Matchers::hasItem("at")))
		}
		{		
			val scope = scopeProvider.getScope(a, OilPackage::eINSTANCE.parameter_ValueRef)
			println(scope.allElements.map[it.name.toString])
			Assert::assertEquals(2, scope.allElements.size)
			Assert::assertThat(scope.allElements.map[it.name.toString], Matchers::allOf(Matchers::hasItem("TRUE"), Matchers::hasItem("FALSE")))
		}
		{		
			val scope = scopeProvider.getScope(a, OilPackage::eINSTANCE.parameter_Parameters)
			println(scope.allElements.map[it.name.toString])
			Assert::assertEquals(2, scope.allElements.size)
			Assert::assertThat(scope.allElements.map[it.name.toString], Matchers::allOf(Matchers::hasItem("b"), Matchers::hasItem("d")))
		}
	}


	@Test
	def void refScope() {
		val model = parser.parse('''
			IMPLEMENTATION a {
				OS {
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
					at = alarm1;
				};
				ALARM alarm1 {
				};
			};
		''')
		val os = model.application.oilObjects.get(0)
		Assert::assertSame(ObjectType::OS, os.type)
		val a = os.parameters.get(0)
		Assert::assertEquals("at", a.type.name)
		{		
			val scope = scopeProvider.getScope(a, OilPackage::eINSTANCE.parameter_ValueRef)
			println(scope.allElements.map[it.name.toString])
			Assert::assertEquals(1, scope.allElements.size)
			Assert::assertThat(scope.allElements.map[it.name.toString], Matchers::hasItem("alarm1"))
		}
	}

}
