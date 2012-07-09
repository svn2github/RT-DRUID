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

import static com.eu.evidence.rtdruid.test.modules.oil.xtext.validation.SplittedElementsTests.*
import com.eu.evidence.rtdruid.test.modules.oil.xtext.OilInjectorProvider
import com.eu.evidence.rtdruid.test.modules.oil.xtext.PackageProvider
import com.eu.evidence.rtdruid.oil.xtext.model.OilFile
import com.eu.evidence.rtdruid.oil.xtext.model.Parameter

@RunWith(typeof(XtextRunner2))
@InjectWith(typeof(OilInjectorProvider))
class SplittedElementsTests extends XtextTest {
	static String path = PackageProvider::DEFAULT.computeBundleClassPath(typeof(SimpleTests))
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
	def void undefinedElement() {
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
					undefined = 1;
				};
			};
		''')
		issues = new FluentIssueCollection(model.eResource, tester.validate(model), new ArrayList<String>())
		
		assertConstraints(issues.errorsOnly
			.inLine(17)
			.under(typeof(Parameter))
			.oneOfThemContains("Couldn't resolve reference")
			.oneOfThemContains("'undefined'")
		)
		assertConstraints(issues.errorsOnly
			.inLine(17)
			.under(typeof(Parameter))
			.oneOfThemContains("Expected a valid")
		)
	}
	@Test
	def void splittedOS() {
		val model = parser.parse('''
			IMPLEMENTATION a {
				OS {
					ALARM_TYPE at;
				};
				ALARM {};
			};
			CPU s {
				ALARM alarm1 {};
				ALARM alarm2 {};
				OS aa {
					at = alarm1;
				};
				
				OS aa {
					at = alarm2;
				};
			};
		''')
		issues = new FluentIssueCollection(model.eResource, tester.validate(model), new ArrayList<String>())
		
		assertConstraints(issues.errorsOnly
			.inLine(11)
			.under(typeof(Parameter))
			.oneOfThemContains("Only one value expected")
		)
		assertConstraints(issues.errorsOnly
			.inLine(15)
			.under(typeof(Parameter))
			.oneOfThemContains("Only one value expected")
		)
	}
	@Test
	def void splittedOSEnum() {
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
				};
			};
			CPU s {
				OS aa {
					a = TRUE;
				};
				
				OS aa {
					a = TRUE;
					a = TRUE {
						b=1;
					};
				};
			};
		''')
		issues = new FluentIssueCollection(model.eResource, tester.validate(model), new ArrayList<String>())
	}
	@Test
	def void splittedOSEnum2() {
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
				};
			};
			CPU s {
				OS aa {
					a = TRUE {
						d = FALSE;
					};
				};
				
				OS aa {
					a = TRUE;
					a = TRUE {
						b=1;
					};
				};
			};
		''')
		issues = new FluentIssueCollection(model.eResource, tester.validate(model), new ArrayList<String>())
	}

	@Test
	def void splittedOSEnum3() {
		val model = parser.parse('''
			IMPLEMENTATION a {
				OS {
					BOOLEAN [
						TRUE {
							INT32 b1;
						},
						FALSE
					] a;
					BOOLEAN [
						TRUE {
							INT32 b2;
							BOOLEAN d;
						},
						FALSE
					] a;
				};
				OS {
					BOOLEAN [
						TRUE {
							INT32 b3;
						},
						FALSE
					] a;
				};
			};
			CPU s {
				OS aa {
					a = TRUE {
						d = FALSE;
					};
					a = TRUE {
						b3 = 3;
					};
				};
				
				OS aa {
					a = TRUE;
					a = TRUE {
						b1=1;
						b2=2;
					};
				};
			};
		''')
		issues = new FluentIssueCollection(model.eResource, tester.validate(model), new ArrayList<String>())
	}

	@Test
	def void splittedOSMultiValue() {
		val model = parser.parse('''
			IMPLEMENTATION a {
				OS {
					BOOLEAN [
						TRUE {
							INT32 b1[];
						},
						FALSE
					] a;
					BOOLEAN [
						TRUE {
							INT32 b2;
							BOOLEAN d;
						},
						FALSE
					] a;
				};
				OS {
					BOOLEAN [
						TRUE {
							INT32 b3;
						},
						FALSE
					] a;
				};
			};
			CPU s {
				OS aa {
					a = TRUE {
						b1=10;
						b1=11;
						d = FALSE;
					};
					a = TRUE {
						b1=1;
						b3 = 3;
					};
				};
				
				OS aa {
					a = TRUE;
					a = TRUE {
						b1=12;
						b2=2;
					};
				};
			};
		''')
		issues = new FluentIssueCollection(model.eResource, tester.validate(model), new ArrayList<String>())
	}
	
	@Test
	def void splittedOSMultiValueEnum() {
		val model = parser.parse('''
			IMPLEMENTATION a {
				OS {
					BOOLEAN [
						TRUE {
							INT32 b1[];
						},
						FALSE
					] a[];
					BOOLEAN [
						TRUE {
							INT32 b2;
							BOOLEAN d;
						},
						FALSE
					] a[];
				};
				OS {
					BOOLEAN [
						TRUE {
							INT32 b3;
						},
						FALSE
					] a[];
				};
			};
			CPU s {
				OS aa {
					a = TRUE {
						b1=10;
						b1=11;
						b3 = 31;
						d = FALSE;
					};
					a = TRUE {
						b1=1;
						b3 = 32;
						b2=22;
					};
				};
				
				OS aa {
					a = TRUE;
					a = TRUE {
						b1=12;
						b2=21;
						d = TRUE;
					};
				};
			};
		''')
		issues = new FluentIssueCollection(model.eResource, tester.validate(model), new ArrayList<String>())
	}
	
}
