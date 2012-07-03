package com.eu.evidence.rtdruid.test.modules.oil.xtext.validation;

import com.eu.evidence.rtdruid.test.modules.oil.xtext.OilInjectorProvider;
import com.eu.evidence.rtdruid.test.modules.oil.xtext.PackageProvider;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipselabs.xtext.utils.unittesting.FluentIssueCollection;
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2;
import org.eclipselabs.xtext.utils.unittesting.XtextTest;
import org.junit.Test;
import org.junit.runner.RunWith;

@SuppressWarnings("all")
@RunWith(XtextRunner2.class)
@InjectWith(OilInjectorProvider.class)
public class SimpleTests extends XtextTest {
  private static String path = new Function0<String>() {
    public String apply() {
      String _computeBundleClassPath = PackageProvider.DEFAULT.computeBundleClassPath(com.eu.evidence.rtdruid.test.modules.oil.xtext.validation.SimpleTests.class);
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
      FluentIssueCollection _inLine = _errorsOnly.inLine(20);
      FluentIssueCollection _under = _inLine.under(com.eu.evidence.rtdruid.oil.xtext.model.Parameter.class);
      FluentIssueCollection _oneOfThemContains = _under.oneOfThemContains("Couldn\'t resolve reference");
      FluentIssueCollection _oneOfThemContains_1 = _oneOfThemContains.oneOfThemContains("\'not_existing_id\'");
      this.assertConstraints(_oneOfThemContains_1);
      FluentIssueCollection _errorsOnly_1 = this.issues.errorsOnly();
      FluentIssueCollection _inLine_1 = _errorsOnly_1.inLine(27);
      FluentIssueCollection _under_1 = _inLine_1.under(com.eu.evidence.rtdruid.oil.xtext.model.Parameter.class);
      FluentIssueCollection _oneOfThemContains_2 = _under_1.oneOfThemContains("Couldn\'t resolve reference");
      FluentIssueCollection _oneOfThemContains_3 = _oneOfThemContains_2.oneOfThemContains("\'b\'");
      this.assertConstraints(_oneOfThemContains_3);
      FluentIssueCollection _errorsOnly_2 = this.issues.errorsOnly();
      FluentIssueCollection _inLine_2 = _errorsOnly_2.inLine(30);
      FluentIssueCollection _under_2 = _inLine_2.under(com.eu.evidence.rtdruid.oil.xtext.model.Parameter.class);
      FluentIssueCollection _oneOfThemContains_4 = _under_2.oneOfThemContains("does not support AUTO");
      this.assertConstraints(_oneOfThemContains_4);
  }
  
  @Test
  public void simpleNegativeTest002() {
      this.ignoreFormattingDifferences();
      this.testFile("test002.oil");
      FluentIssueCollection _errorsOnly = this.issues.errorsOnly();
      FluentIssueCollection _inLine = _errorsOnly.inLine(20);
      FluentIssueCollection _under = _inLine.under(com.eu.evidence.rtdruid.oil.xtext.model.Parameter.class);
      FluentIssueCollection _oneOfThemContains = _under.oneOfThemContains("Couldn\'t resolve reference");
      FluentIssueCollection _oneOfThemContains_1 = _oneOfThemContains.oneOfThemContains("\'not_existing_id\'");
      this.assertConstraints(_oneOfThemContains_1);
      FluentIssueCollection _errorsOnly_1 = this.issues.errorsOnly();
      FluentIssueCollection _inLine_1 = _errorsOnly_1.inLine(23);
      FluentIssueCollection _under_1 = _inLine_1.under(com.eu.evidence.rtdruid.oil.xtext.model.Parameter.class);
      FluentIssueCollection _oneOfThemContains_2 = _under_1.oneOfThemContains("Couldn\'t resolve reference");
      FluentIssueCollection _oneOfThemContains_3 = _oneOfThemContains_2.oneOfThemContains("\'b\'");
      this.assertConstraints(_oneOfThemContains_3);
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
      FluentIssueCollection _under = _inLine.under(com.eu.evidence.rtdruid.oil.xtext.model.Parameter.class);
      FluentIssueCollection _oneOfThemContains = _under.oneOfThemContains("Only one value expected");
      this.assertConstraints(_oneOfThemContains);
      FluentIssueCollection _errorsOnly_1 = this.issues.errorsOnly();
      FluentIssueCollection _inLine_1 = _errorsOnly_1.inLine(37);
      FluentIssueCollection _under_1 = _inLine_1.under(com.eu.evidence.rtdruid.oil.xtext.model.Parameter.class);
      FluentIssueCollection _oneOfThemContains_1 = _under_1.oneOfThemContains("Only one value expected");
      this.assertConstraints(_oneOfThemContains_1);
  }
}
