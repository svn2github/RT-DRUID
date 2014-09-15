package com.eu.evidence.rtdruid.test.modules.oil.xtext.validation;

import com.eu.evidence.rtdruid.oil.xtext.model.EnumeratorType;
import com.eu.evidence.rtdruid.oil.xtext.model.OilFile;
import com.eu.evidence.rtdruid.test.modules.oil.xtext.OilInjectorProvider;
import com.eu.evidence.rtdruid.test.modules.oil.xtext.PackageProvider;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipselabs.xtext.utils.unittesting.FluentIssueCollection;
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2;
import org.eclipselabs.xtext.utils.unittesting.XtextTest;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(value = XtextRunner2.class)
@InjectWith(value = OilInjectorProvider.class)
@SuppressWarnings("all")
public class EnumTests extends XtextTest {
  private static String path = new Function0<String>() {
    public String apply() {
      String _computeBundleClassPath = PackageProvider.DEFAULT.computeBundleClassPath(EnumTests.class);
      return _computeBundleClassPath;
    }
  }.apply();
  
  public EnumTests() {
    super(EnumTests.path);
  }
  
  @Inject
  private ParseHelper<OilFile> parser;
  
  @Inject
  private ValidationTestHelper tester;
  
  public ParseHelper<OilFile> getParser() {
    return this.parser;
  }
  
  public ValidationTestHelper getTester() {
    return this.tester;
  }
  
  @Test
  public void booleanDefinition() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("IMPLEMENTATION a {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("OS {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("BOOLEAN a;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("BOOLEAN [");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("TRUE,");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("FALSE");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("] b;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("BOOLEAN [");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("TRUE {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("INT32 b;");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("BOOLEAN d;");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("},");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("FALSE");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("] c;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("BOOLEAN [");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("a1");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("] d;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("BOOLEAN [");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("TRUE,");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("FALSE,");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("a2");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("] e;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("};");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("ALARM {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("};");
      _builder.newLine();
      _builder.append("};");
      _builder.newLine();
      _builder.append("CPU s {");
      _builder.newLine();
      _builder.append("};");
      _builder.newLine();
      final OilFile model = this.parser.parse(_builder);
      Resource _eResource = model.eResource();
      List<Issue> _validate = this.tester.validate(model);
      ArrayList<String> _arrayList = new ArrayList<String>();
      FluentIssueCollection _fluentIssueCollection = new FluentIssueCollection(_eResource, _validate, _arrayList);
      this.issues = _fluentIssueCollection;
      FluentIssueCollection _errorsOnly = this.issues.errorsOnly();
      FluentIssueCollection _inLine = _errorsOnly.inLine(16);
      FluentIssueCollection _under = _inLine.under(EnumeratorType.class);
      FluentIssueCollection _oneOfThemContains = _under.oneOfThemContains("TRUE");
      this.assertConstraints(_oneOfThemContains);
      FluentIssueCollection _errorsOnly_1 = this.issues.errorsOnly();
      FluentIssueCollection _inLine_1 = _errorsOnly_1.inLine(21);
      FluentIssueCollection _under_1 = _inLine_1.under(EnumeratorType.class);
      FluentIssueCollection _oneOfThemContains_1 = _under_1.oneOfThemContains("TRUE");
      this.assertConstraints(_oneOfThemContains_1);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
