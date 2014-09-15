package com.eu.evidence.rtdruid.test.modules.oil.xtext.validation;

import com.eu.evidence.rtdruid.oil.xtext.model.Parameter;
import com.eu.evidence.rtdruid.test.modules.oil.xtext.OilInjectorProvider;
import com.eu.evidence.rtdruid.test.modules.oil.xtext.PackageProvider;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipselabs.xtext.utils.unittesting.FluentIssueCollection;
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2;
import org.eclipselabs.xtext.utils.unittesting.XtextTest;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(value = XtextRunner2.class)
@InjectWith(value = OilInjectorProvider.class)
@SuppressWarnings("all")
public class SimpleTests extends XtextTest {
  private static String path = new Function0<String>() {
    public String apply() {
      String _computeBundleClassPath = PackageProvider.DEFAULT.computeBundleClassPath(SimpleTests.class);
      return _computeBundleClassPath;
    }
  }.apply();
  
  public SimpleTests() {
    super(SimpleTests.path);
  }
  
  @Test
  public void simpleNegativeTest001() {
    this.ignoreSerializationDifferences();
    this.testFile("test001.oil");
    FluentIssueCollection _errorsOnly = this.issues.errorsOnly();
    FluentIssueCollection _inLine = _errorsOnly.inLine(18);
    FluentIssueCollection _under = _inLine.under(Parameter.class);
    FluentIssueCollection _oneOfThemContains = _under.oneOfThemContains("Couldn\'t resolve reference");
    FluentIssueCollection _oneOfThemContains_1 = _oneOfThemContains.oneOfThemContains("\'not_existing_id\'");
    this.assertConstraints(_oneOfThemContains_1);
    FluentIssueCollection _errorsOnly_1 = this.issues.errorsOnly();
    FluentIssueCollection _inLine_1 = _errorsOnly_1.inLine(18);
    FluentIssueCollection _under_1 = _inLine_1.under(Parameter.class);
    FluentIssueCollection _oneOfThemContains_2 = _under_1.oneOfThemContains("Expected a valid");
    this.assertConstraints(_oneOfThemContains_2);
    FluentIssueCollection _errorsOnly_2 = this.issues.errorsOnly();
    FluentIssueCollection _inLine_2 = _errorsOnly_2.inLine(21);
    FluentIssueCollection _under_2 = _inLine_2.under(Parameter.class);
    FluentIssueCollection _oneOfThemContains_3 = _under_2.oneOfThemContains("Couldn\'t resolve reference");
    FluentIssueCollection _oneOfThemContains_4 = _oneOfThemContains_3.oneOfThemContains("\'TRUE\'");
    this.assertConstraints(_oneOfThemContains_4);
    FluentIssueCollection _errorsOnly_3 = this.issues.errorsOnly();
    FluentIssueCollection _inLine_3 = _errorsOnly_3.inLine(21);
    FluentIssueCollection _under_3 = _inLine_3.under(Parameter.class);
    FluentIssueCollection _oneOfThemContains_5 = _under_3.oneOfThemContains("Expected a valid");
    FluentIssueCollection _oneOfThemContains_6 = _oneOfThemContains_5.oneOfThemContains("ALARM");
    this.assertConstraints(_oneOfThemContains_6);
    FluentIssueCollection _errorsOnly_4 = this.issues.errorsOnly();
    FluentIssueCollection _inLine_4 = _errorsOnly_4.inLine(21);
    FluentIssueCollection _under_4 = _inLine_4.under(Parameter.class);
    FluentIssueCollection _oneOfThemContains_7 = _under_4.oneOfThemContains("Only one value");
    this.assertConstraints(_oneOfThemContains_7);
    FluentIssueCollection _errorsOnly_5 = this.issues.errorsOnly();
    FluentIssueCollection _inLine_5 = _errorsOnly_5.inLine(26);
    FluentIssueCollection _under_5 = _inLine_5.under(Parameter.class);
    FluentIssueCollection _oneOfThemContains_8 = _under_5.oneOfThemContains("Only one value");
    this.assertConstraints(_oneOfThemContains_8);
    FluentIssueCollection _errorsOnly_6 = this.issues.errorsOnly();
    FluentIssueCollection _inLine_6 = _errorsOnly_6.inLine(27);
    FluentIssueCollection _under_6 = _inLine_6.under(Parameter.class);
    FluentIssueCollection _oneOfThemContains_9 = _under_6.oneOfThemContains("Only one value");
    this.assertConstraints(_oneOfThemContains_9);
    FluentIssueCollection _errorsOnly_7 = this.issues.errorsOnly();
    FluentIssueCollection _inLine_7 = _errorsOnly_7.inLine(29);
    FluentIssueCollection _under_7 = _inLine_7.under(Parameter.class);
    FluentIssueCollection _oneOfThemContains_10 = _under_7.oneOfThemContains("Only one value");
    this.assertConstraints(_oneOfThemContains_10);
    FluentIssueCollection _errorsOnly_8 = this.issues.errorsOnly();
    FluentIssueCollection _inLine_8 = _errorsOnly_8.inLine(25);
    FluentIssueCollection _under_8 = _inLine_8.under(Parameter.class);
    FluentIssueCollection _oneOfThemContains_11 = _under_8.oneOfThemContains("Expected a valid");
    FluentIssueCollection _oneOfThemContains_12 = _oneOfThemContains_11.oneOfThemContains("STRING");
    this.assertConstraints(_oneOfThemContains_12);
    FluentIssueCollection _errorsOnly_9 = this.issues.errorsOnly();
    FluentIssueCollection _inLine_9 = _errorsOnly_9.inLine(25);
    FluentIssueCollection _under_9 = _inLine_9.under(Parameter.class);
    FluentIssueCollection _oneOfThemContains_13 = _under_9.oneOfThemContains("Couldn\'t resolve reference");
    FluentIssueCollection _oneOfThemContains_14 = _oneOfThemContains_13.oneOfThemContains("\'b1\'");
    this.assertConstraints(_oneOfThemContains_14);
    FluentIssueCollection _errorsOnly_10 = this.issues.errorsOnly();
    FluentIssueCollection _inLine_10 = _errorsOnly_10.inLine(26);
    FluentIssueCollection _under_10 = _inLine_10.under(Parameter.class);
    FluentIssueCollection _oneOfThemContains_15 = _under_10.oneOfThemContains("Expected a valid reference");
    FluentIssueCollection _oneOfThemContains_16 = _oneOfThemContains_15.oneOfThemContains("ALARM");
    this.assertConstraints(_oneOfThemContains_16);
    FluentIssueCollection _errorsOnly_11 = this.issues.errorsOnly();
    FluentIssueCollection _inLine_11 = _errorsOnly_11.inLine(26);
    FluentIssueCollection _under_11 = _inLine_11.under(Parameter.class);
    FluentIssueCollection _oneOfThemContains_17 = _under_11.oneOfThemContains("Couldn\'t resolve reference");
    FluentIssueCollection _oneOfThemContains_18 = _oneOfThemContains_17.oneOfThemContains("\'aaaasd\'");
    this.assertConstraints(_oneOfThemContains_18);
    FluentIssueCollection _errorsOnly_12 = this.issues.errorsOnly();
    FluentIssueCollection _inLine_12 = _errorsOnly_12.inLine(29);
    FluentIssueCollection _under_12 = _inLine_12.under(Parameter.class);
    FluentIssueCollection _oneOfThemContains_19 = _under_12.oneOfThemContains("does not support AUTO value");
    this.assertConstraints(_oneOfThemContains_19);
    FluentIssueCollection _errorsOnly_13 = this.issues.errorsOnly();
    FluentIssueCollection _inLine_13 = _errorsOnly_13.inLine(36);
    FluentIssueCollection _under_13 = _inLine_13.under(Parameter.class);
    FluentIssueCollection _oneOfThemContains_20 = _under_13.oneOfThemContains("Couldn\'t resolve reference");
    FluentIssueCollection _oneOfThemContains_21 = _oneOfThemContains_20.oneOfThemContains("\'d\'");
    this.assertConstraints(_oneOfThemContains_21);
  }
  
  @Test
  public void simpleNegativeTest002() {
    this.ignoreFormattingDifferences();
    this.testFile("test002.oil");
    FluentIssueCollection _errorsOnly = this.issues.errorsOnly();
    FluentIssueCollection _inLine = _errorsOnly.inLine(20);
    FluentIssueCollection _under = _inLine.under(Parameter.class);
    FluentIssueCollection _oneOfThemContains = _under.oneOfThemContains("Couldn\'t resolve reference");
    FluentIssueCollection _oneOfThemContains_1 = _oneOfThemContains.oneOfThemContains("\'not_existing_id\'");
    this.assertConstraints(_oneOfThemContains_1);
    FluentIssueCollection _errorsOnly_1 = this.issues.errorsOnly();
    FluentIssueCollection _inLine_1 = _errorsOnly_1.inLine(23);
    FluentIssueCollection _under_1 = _inLine_1.under(Parameter.class);
    FluentIssueCollection _oneOfThemContains_2 = _under_1.oneOfThemContains("Couldn\'t resolve reference");
    FluentIssueCollection _oneOfThemContains_3 = _oneOfThemContains_2.oneOfThemContains("\'b\'");
    this.assertConstraints(_oneOfThemContains_3);
    FluentIssueCollection _errorsOnly_2 = this.issues.errorsOnly();
    FluentIssueCollection _inLine_2 = _errorsOnly_2.inLine(18);
    FluentIssueCollection _under_2 = _inLine_2.under(Parameter.class);
    FluentIssueCollection _oneOfThemContains_4 = _under_2.oneOfThemContains("Couldn\'t resolve reference");
    FluentIssueCollection _oneOfThemContains_5 = _oneOfThemContains_4.oneOfThemContains("\'FALSE\'");
    this.assertConstraints(_oneOfThemContains_5);
    FluentIssueCollection _errorsOnly_3 = this.issues.errorsOnly();
    FluentIssueCollection _inLine_3 = _errorsOnly_3.inLine(18);
    FluentIssueCollection _under_3 = _inLine_3.under(Parameter.class);
    FluentIssueCollection _oneOfThemContains_6 = _under_3.oneOfThemContains("Expected a valid");
    FluentIssueCollection _oneOfThemContains_7 = _oneOfThemContains_6.oneOfThemContains("ALARM");
    this.assertConstraints(_oneOfThemContains_7);
    FluentIssueCollection _errorsOnly_4 = this.issues.errorsOnly();
    FluentIssueCollection _inLine_4 = _errorsOnly_4.inLine(21);
    FluentIssueCollection _under_4 = _inLine_4.under(Parameter.class);
    FluentIssueCollection _oneOfThemContains_8 = _under_4.oneOfThemContains("Couldn\'t resolve reference");
    FluentIssueCollection _oneOfThemContains_9 = _oneOfThemContains_8.oneOfThemContains("\'TRUE\'");
    this.assertConstraints(_oneOfThemContains_9);
    FluentIssueCollection _errorsOnly_5 = this.issues.errorsOnly();
    FluentIssueCollection _inLine_5 = _errorsOnly_5.inLine(21);
    FluentIssueCollection _under_5 = _inLine_5.under(Parameter.class);
    FluentIssueCollection _oneOfThemContains_10 = _under_5.oneOfThemContains("Expected a valid");
    FluentIssueCollection _oneOfThemContains_11 = _oneOfThemContains_10.oneOfThemContains("ALARM");
    this.assertConstraints(_oneOfThemContains_11);
    FluentIssueCollection _errorsOnly_6 = this.issues.errorsOnly();
    FluentIssueCollection _inLine_6 = _errorsOnly_6.inLine(18);
    FluentIssueCollection _under_6 = _inLine_6.under(Parameter.class);
    FluentIssueCollection _oneOfThemContains_12 = _under_6.oneOfThemContains("Only one value");
    this.assertConstraints(_oneOfThemContains_12);
    FluentIssueCollection _errorsOnly_7 = this.issues.errorsOnly();
    FluentIssueCollection _inLine_7 = _errorsOnly_7.inLine(21);
    FluentIssueCollection _under_7 = _inLine_7.under(Parameter.class);
    FluentIssueCollection _oneOfThemContains_13 = _under_7.oneOfThemContains("Only one value");
    this.assertConstraints(_oneOfThemContains_13);
    FluentIssueCollection _errorsOnly_8 = this.issues.errorsOnly();
    FluentIssueCollection _inLine_8 = _errorsOnly_8.inLine(24);
    FluentIssueCollection _under_8 = _inLine_8.under(Parameter.class);
    FluentIssueCollection _oneOfThemContains_14 = _under_8.oneOfThemContains("Only one value");
    this.assertConstraints(_oneOfThemContains_14);
    FluentIssueCollection _errorsOnly_9 = this.issues.errorsOnly();
    FluentIssueCollection _inLine_9 = _errorsOnly_9.inLine(26);
    FluentIssueCollection _under_9 = _inLine_9.under(Parameter.class);
    FluentIssueCollection _oneOfThemContains_15 = _under_9.oneOfThemContains("Only one value");
    this.assertConstraints(_oneOfThemContains_15);
    FluentIssueCollection _errorsOnly_10 = this.issues.errorsOnly();
    FluentIssueCollection _inLine_10 = _errorsOnly_10.inLine(24);
    FluentIssueCollection _under_10 = _inLine_10.under(Parameter.class);
    FluentIssueCollection _oneOfThemContains_16 = _under_10.oneOfThemContains("Expected a valid reference");
    FluentIssueCollection _oneOfThemContains_17 = _oneOfThemContains_16.oneOfThemContains("ALARM");
    this.assertConstraints(_oneOfThemContains_17);
    FluentIssueCollection _errorsOnly_11 = this.issues.errorsOnly();
    FluentIssueCollection _inLine_11 = _errorsOnly_11.inLine(24);
    FluentIssueCollection _under_11 = _inLine_11.under(Parameter.class);
    FluentIssueCollection _oneOfThemContains_18 = _under_11.oneOfThemContains("Couldn\'t resolve reference");
    FluentIssueCollection _oneOfThemContains_19 = _oneOfThemContains_18.oneOfThemContains("\'aaaasd\'");
    this.assertConstraints(_oneOfThemContains_19);
    FluentIssueCollection _errorsOnly_12 = this.issues.errorsOnly();
    FluentIssueCollection _inLine_12 = _errorsOnly_12.inLine(29);
    FluentIssueCollection _under_12 = _inLine_12.under(Parameter.class);
    FluentIssueCollection _oneOfThemContains_20 = _under_12.oneOfThemContains("Couldn\'t resolve reference");
    FluentIssueCollection _oneOfThemContains_21 = _oneOfThemContains_20.oneOfThemContains("\'d\'");
    this.assertConstraints(_oneOfThemContains_21);
  }
  
  @Test
  public void positiveTest003() {
    this.ignoreFormattingDifferences();
    this.testFile("test003.oil");
  }
  
  @Test
  public void positiveTest004() {
    this.ignoreFormattingDifferences();
    this.testFile("test004.oil");
  }
  
  @Test
  public void positiveTest005() {
    this.ignoreFormattingDifferences();
    this.testFile("test005.oil");
    FluentIssueCollection _errorsOnly = this.issues.errorsOnly();
    FluentIssueCollection _inLine = _errorsOnly.inLine(36);
    FluentIssueCollection _under = _inLine.under(Parameter.class);
    FluentIssueCollection _oneOfThemContains = _under.oneOfThemContains("Only one value expected");
    this.assertConstraints(_oneOfThemContains);
    FluentIssueCollection _errorsOnly_1 = this.issues.errorsOnly();
    FluentIssueCollection _inLine_1 = _errorsOnly_1.inLine(37);
    FluentIssueCollection _under_1 = _inLine_1.under(Parameter.class);
    FluentIssueCollection _oneOfThemContains_1 = _under_1.oneOfThemContains("Only one value expected");
    this.assertConstraints(_oneOfThemContains_1);
  }
  
  @Test
  public void positiveTest006() {
    this.suppressSerialization();
    this.testFile("test006.oil");
  }
  
  @Test
  public void positiveTest007() {
    this.ignoreSerializationDifferences();
    this.testFile("test007.oil");
  }
}
