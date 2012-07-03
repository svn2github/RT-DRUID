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
class ScopingDefaultTypesTests extends XtextTest {

	@Inject private IScopeProvider scopeProvider
	@Inject ParseHelper<OilFile> parser

//	@ParameterSyntax("('@' offset=OFFSET)?")
//	@XpectCommaSeparatedValues
	@Test
	def void cpuData() {
		val model = parser.parse('''
			CPU s {
				OS aa {
				};
			};
		''')
		val os = model.application.oilObjects.get(0)
		Assert::assertSame(ObjectType::OS, os.type)
		
		val scope = scopeProvider.getScope(os, OilPackage::eINSTANCE.oilObject_Parameters)
		println(scope.allElements.map[it.name.toString])
		Assert::assertThat(scope.allElements.size, Matchers::greaterThan(0))
		Assert::assertThat(scope.allElements.map[it.name.toString], Matchers::hasItem("CPU_DATA"))
	}

}
