package com.eu.evidence.rtdruid.test.modules.oil.xtext.validation;

import com.eu.evidence.rtdruid.oil.xtext.model.ValueType;
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
public class StringTests extends XtextTest {
  private static String path = new Function0<String>() {
    public String apply() {
      String _computeBundleClassPath = PackageProvider.DEFAULT.computeBundleClassPath(StringTests.class);
      return _computeBundleClassPath;
    }
  }.apply();
  
  public StringTests() {
    super(StringTests.path);
  }
  
  @Test
  public void stringDefaultsTest() {
    this.ignoreFormattingDifferences();
    this.testFile("testStringDefault.oil");
    FluentIssueCollection _errorsOnly = this.issues.errorsOnly();
    FluentIssueCollection _inLine = _errorsOnly.inLine(5);
    FluentIssueCollection _under = _inLine.under(ValueType.class);
    FluentIssueCollection _oneOfThemContains = _under.oneOfThemContains("STRING");
    this.assertConstraints(_oneOfThemContains);
    FluentIssueCollection _errorsOnly_1 = this.issues.errorsOnly();
    FluentIssueCollection _inLine_1 = _errorsOnly_1.inLine(6);
    FluentIssueCollection _under_1 = _inLine_1.under(ValueType.class);
    FluentIssueCollection _oneOfThemContains_1 = _under_1.oneOfThemContains("STRING");
    this.assertConstraints(_oneOfThemContains_1);
    FluentIssueCollection _errorsOnly_2 = this.issues.errorsOnly();
    FluentIssueCollection _inLine_2 = _errorsOnly_2.inLine(7);
    FluentIssueCollection _under_2 = _inLine_2.under(ValueType.class);
    FluentIssueCollection _oneOfThemContains_2 = _under_2.oneOfThemContains("STRING");
    this.assertConstraints(_oneOfThemContains_2);
    FluentIssueCollection _errorsOnly_3 = this.issues.errorsOnly();
    FluentIssueCollection _inLine_3 = _errorsOnly_3.inLine(8);
    FluentIssueCollection _under_3 = _inLine_3.under(ValueType.class);
    FluentIssueCollection _oneOfThemContains_3 = _under_3.oneOfThemContains("STRING");
    this.assertConstraints(_oneOfThemContains_3);
    FluentIssueCollection _errorsOnly_4 = this.issues.errorsOnly();
    FluentIssueCollection _inLine_4 = _errorsOnly_4.inLine(9);
    FluentIssueCollection _under_4 = _inLine_4.under(ValueType.class);
    FluentIssueCollection _oneOfThemContains_4 = _under_4.oneOfThemContains("STRING");
    this.assertConstraints(_oneOfThemContains_4);
    FluentIssueCollection _errorsOnly_5 = this.issues.errorsOnly();
    FluentIssueCollection _inLine_5 = _errorsOnly_5.inLine(10);
    FluentIssueCollection _under_5 = _inLine_5.under(ValueType.class);
    FluentIssueCollection _oneOfThemContains_5 = _under_5.oneOfThemContains("STRING");
    this.assertConstraints(_oneOfThemContains_5);
    FluentIssueCollection _errorsOnly_6 = this.issues.errorsOnly();
    FluentIssueCollection _inLine_6 = _errorsOnly_6.inLine(11);
    FluentIssueCollection _under_6 = _inLine_6.under(ValueType.class);
    FluentIssueCollection _oneOfThemContains_6 = _under_6.oneOfThemContains("STRING");
    this.assertConstraints(_oneOfThemContains_6);
    FluentIssueCollection _errorsOnly_7 = this.issues.errorsOnly();
    FluentIssueCollection _inLine_7 = _errorsOnly_7.inLine(12);
    FluentIssueCollection _under_7 = _inLine_7.under(ValueType.class);
    FluentIssueCollection _oneOfThemContains_7 = _under_7.oneOfThemContains("STRING");
    this.assertConstraints(_oneOfThemContains_7);
    FluentIssueCollection _errorsOnly_8 = this.issues.errorsOnly();
    FluentIssueCollection _inLine_8 = _errorsOnly_8.inLine(13);
    FluentIssueCollection _under_8 = _inLine_8.under(ValueType.class);
    FluentIssueCollection _oneOfThemContains_8 = _under_8.oneOfThemContains("AUTO");
    this.assertConstraints(_oneOfThemContains_8);
    FluentIssueCollection _errorsOnly_9 = this.issues.errorsOnly();
    FluentIssueCollection _inLine_9 = _errorsOnly_9.inLine(15);
    FluentIssueCollection _under_9 = _inLine_9.under(ValueType.class);
    FluentIssueCollection _oneOfThemContains_9 = _under_9.oneOfThemContains("STRING");
    this.assertConstraints(_oneOfThemContains_9);
    FluentIssueCollection _errorsOnly_10 = this.issues.errorsOnly();
    FluentIssueCollection _inLine_10 = _errorsOnly_10.inLine(16);
    FluentIssueCollection _under_10 = _inLine_10.under(ValueType.class);
    FluentIssueCollection _oneOfThemContains_10 = _under_10.oneOfThemContains("STRING");
    this.assertConstraints(_oneOfThemContains_10);
  }
}
