package com.eu.evidence.rtdruid.test.modules.oil.xtext.parser;

import com.eu.evidence.rtdruid.oil.xtext.model.OilFile;
import com.eu.evidence.rtdruid.test.modules.oil.xtext.OilInjectorProvider;
import com.eu.evidence.rtdruid.test.modules.oil.xtext.PackageProvider;
import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2;
import org.eclipselabs.xtext.utils.unittesting.XtextTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@SuppressWarnings("all")
@RunWith(XtextRunner2.class)
@InjectWith(OilInjectorProvider.class)
public class ParsingTests extends XtextTest {
  private static String path = new Function0<String>() {
    public String apply() {
      String _computeBundleClassPath = PackageProvider.DEFAULT.computeBundleClassPath(com.eu.evidence.rtdruid.test.modules.oil.xtext.parser.ParsingTests.class);
      return _computeBundleClassPath;
    }
  }.apply();
  
  public ParsingTests() {
    super(ParsingTests.path);
  }
  
  @Inject
  private ParseHelper<OilFile> parser;
  
  @Test
  public void simplePositiveTest() {
    try {
      {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("IMPLEMENTATION a {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("OS {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("// 112;");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("BOOLEAN a {");
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
        _builder.append("};");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("ALARM_TYPE WITH_AUTO at;");
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
        _builder.append("\t");
        _builder.append("OS aa {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("at = FALSE;");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("b = 122 2 123123 . 4 {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("};");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("at = TRUE { ");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("} : \"a");
        _builder.newLine();
        _builder.append("asdasd\";");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("b = \"1\";");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("at = aaaasd;");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("at = AUTO;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("};");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("COM aa1 {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("d = \"qw\";");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("};");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("ALARM aaa {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("};");
        _builder.newLine();
        _builder.append("};");
        _builder.newLine();
        OilFile _parse = this.parser.parse(_builder);
        final OilFile model = _parse;
        Resource _eResource = model.eResource();
        final Resource resource = _eResource;
        boolean _operator_and = false;
        EList<Diagnostic> _errors = resource.getErrors();
        int _size = _errors.size();
        boolean _operator_equals = IntegerExtensions.operator_equals(_size, 0);
        if (!_operator_equals) {
          _operator_and = false;
        } else {
          EList<Diagnostic> _warnings = resource.getWarnings();
          int _size_1 = _warnings.size();
          boolean _operator_equals_1 = IntegerExtensions.operator_equals(_size_1, 0);
          _operator_and = BooleanExtensions.operator_and(_operator_equals, _operator_equals_1);
        }
        Assert.assertTrue(_operator_and);
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void emptyApplicationOnlyTest() {
    try {
      {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("CPU s {");
        _builder.newLine();
        _builder.append("};");
        _builder.newLine();
        OilFile _parse = this.parser.parse(_builder);
        final OilFile model = _parse;
        Resource _eResource = model.eResource();
        final Resource resource = _eResource;
        boolean _operator_and = false;
        EList<Diagnostic> _errors = resource.getErrors();
        int _size = _errors.size();
        boolean _operator_equals = IntegerExtensions.operator_equals(_size, 0);
        if (!_operator_equals) {
          _operator_and = false;
        } else {
          EList<Diagnostic> _warnings = resource.getWarnings();
          int _size_1 = _warnings.size();
          boolean _operator_equals_1 = IntegerExtensions.operator_equals(_size_1, 0);
          _operator_and = BooleanExtensions.operator_and(_operator_equals, _operator_equals_1);
        }
        Assert.assertTrue(_operator_and);
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void applicationOnlyTest() {
    try {
      {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("CPU s {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("OS aa {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("at = FALSE;");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("b = 122 2 123123 . 4 {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("};");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("at = TRUE { ");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("} : \"a");
        _builder.newLine();
        _builder.append("asdasd\";");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("b = \"1\";");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("at = aaaasd;");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("at = AUTO;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("};");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("COM aa1 {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("d = \"qw\";");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("};");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("ALARM aaa {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("};");
        _builder.newLine();
        _builder.append("};");
        _builder.newLine();
        OilFile _parse = this.parser.parse(_builder);
        final OilFile model = _parse;
        Resource _eResource = model.eResource();
        final Resource resource = _eResource;
        boolean _operator_and = false;
        EList<Diagnostic> _errors = resource.getErrors();
        int _size = _errors.size();
        boolean _operator_equals = IntegerExtensions.operator_equals(_size, 0);
        if (!_operator_equals) {
          _operator_and = false;
        } else {
          EList<Diagnostic> _warnings = resource.getWarnings();
          int _size_1 = _warnings.size();
          boolean _operator_equals_1 = IntegerExtensions.operator_equals(_size_1, 0);
          _operator_and = BooleanExtensions.operator_and(_operator_equals, _operator_equals_1);
        }
        Assert.assertTrue(_operator_and);
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void implementationOnlyTest() {
    try {
      {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("IMPLEMENTATION a {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("OS {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("// 112;");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("BOOLEAN a {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("TRUE {");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("INT32 b1;");
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
        _builder.append("};");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("ALARM_TYPE at;");
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
        OilFile _parse = this.parser.parse(_builder);
        final OilFile model = _parse;
        Resource _eResource = model.eResource();
        final Resource resource = _eResource;
        EList<Diagnostic> _errors = resource.getErrors();
        System.out.println(_errors);
        EList<Diagnostic> _errors_1 = resource.getErrors();
        int _size = _errors_1.size();
        Assert.assertEquals(1, _size);
        EList<Diagnostic> _warnings = resource.getWarnings();
        int _size_1 = _warnings.size();
        Assert.assertEquals(0, _size_1);
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void composedValueTest() {
    try {
      {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("IMPLEMENTATION a {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("OS {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("INT32 b1;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("};");
        _builder.newLine();
        _builder.append("};");
        _builder.newLine();
        _builder.append("CPU s {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("OS aa {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("b1 = -1 {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("b1 = 2;");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("};");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("};");
        _builder.newLine();
        _builder.append("};");
        _builder.newLine();
        OilFile _parse = this.parser.parse(_builder);
        final OilFile model = _parse;
        Resource _eResource = model.eResource();
        final Resource resource = _eResource;
        EList<Diagnostic> _errors = resource.getErrors();
        int _size = _errors.size();
        Assert.assertEquals(0, _size);
        EList<Diagnostic> _warnings = resource.getWarnings();
        int _size_1 = _warnings.size();
        Assert.assertEquals(0, _size_1);
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void negativeHexTest() {
    try {
      {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("IMPLEMENTATION a {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("OS {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("INT32 b1;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("};");
        _builder.newLine();
        _builder.append("};");
        _builder.newLine();
        _builder.append("CPU s {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("OS aa {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("b1 = -0x1;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("};");
        _builder.newLine();
        _builder.append("};");
        _builder.newLine();
        OilFile _parse = this.parser.parse(_builder);
        final OilFile model = _parse;
        Resource _eResource = model.eResource();
        final Resource resource = _eResource;
        EList<Diagnostic> _errors = resource.getErrors();
        int _size = _errors.size();
        Assert.assertEquals(0, _size);
        EList<Diagnostic> _warnings = resource.getWarnings();
        int _size_1 = _warnings.size();
        Assert.assertEquals(0, _size_1);
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
