package com.eu.evidence.rtdruid.test.modules.oil.xtext.validation

import com.google.inject.Inject
import java.util.ArrayList
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipselabs.xtext.utils.unittesting.FluentIssueCollection
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2
import org.eclipselabs.xtext.utils.unittesting.XtextTest
import org.junit.Test
import org.junit.runner.RunWith

import static com.eu.evidence.rtdruid.test.modules.oil.xtext.validation.EnumTests.*
import com.eu.evidence.rtdruid.test.modules.oil.xtext.OilInjectorProvider
import com.eu.evidence.rtdruid.test.modules.oil.xtext.PackageProvider
import com.eu.evidence.rtdruid.oil.xtext.model.OilFile
import com.eu.evidence.rtdruid.oil.xtext.model.EnumeratorType

@RunWith(typeof(XtextRunner2))
@InjectWith(typeof(OilInjectorProvider))
class EnumTests extends XtextTest {
	static String path = PackageProvider::DEFAULT.computeBundleClassPath(typeof(EnumTests))
 	new() {
		super(path)
	}

	@Inject ParseHelper<OilFile> parser
	@Inject ValidationTestHelper tester

//	ValidatorTester<OilJavaValidator> tester

//	@Before
//	def void setUp() {
////		with(MyLanguageStandaloneSetup.class);
////		OilJavaValidator validator = get(MyLanguageValidator.class);
//		tester = new ValidatorTester<OilJavaValidator>(new OilJavaValidator())//, new OilInjectorProvider().injector);
//	}

	@Test
	def void booleanDefinition() {
		val model = parser.parse('''
			IMPLEMENTATION a {
				OS {
					BOOLEAN a;
					BOOLEAN b {
						TRUE,
						FALSE
					};
					BOOLEAN c {
						TRUE {
							INT32 b;
							BOOLEAN d;
						},
						FALSE
					};
					BOOLEAN d {
						a1
					};
					BOOLEAN e {
						TRUE,
						FALSE,
						a2
					};
				};
				ALARM {
				};
			};
			CPU s {
			};
		''')
		issues = new FluentIssueCollection(model.eResource, tester.validate(model), new ArrayList<String>())
		assertConstraints(issues.errorsOnly
			.inLine(16)
			.under(typeof(EnumeratorType))
			.oneOfThemContains("a1")
		)
		assertConstraints(issues.errorsOnly
			.inLine(21)
			.under(typeof(EnumeratorType))
			.oneOfThemContains("a2")
		)
	}
	
}
