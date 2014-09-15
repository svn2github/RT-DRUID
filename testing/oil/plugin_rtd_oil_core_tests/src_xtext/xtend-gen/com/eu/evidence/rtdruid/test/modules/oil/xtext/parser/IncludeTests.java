package com.eu.evidence.rtdruid.test.modules.oil.xtext.parser;

import com.eu.evidence.rtdruid.oil.xtext.model.OilFile;
import com.eu.evidence.rtdruid.test.modules.oil.xtext.OilInjectorProvider;
import com.eu.evidence.rtdruid.test.modules.oil.xtext.PackageProvider;
import com.eu.evidence.rtdruid.test.modules.oil.xtext.parser.ParsingTests;
import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2;
import org.eclipselabs.xtext.utils.unittesting.XtextTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(value = XtextRunner2.class)
@InjectWith(value = OilInjectorProvider.class)
@SuppressWarnings("all")
public class IncludeTests extends XtextTest {
  private static String path = new Function0<String>() {
    public String apply() {
      String _computeBundleClassPath = PackageProvider.DEFAULT.computeBundleClassPath(ParsingTests.class);
      return _computeBundleClassPath;
    }
  }.apply();
  
  public IncludeTests() {
    super(IncludeTests.path);
  }
  
  @Inject
  private ParseHelper<OilFile> parser;
  
  @Test
  public void includeNothingTest1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("#include \"\"");
      _builder.newLine();
      final OilFile model = this.parser.parse(_builder);
      final Resource resource = model.eResource();
      EList<Diagnostic> _errors = resource.getErrors();
      String _string = _errors.toString();
      boolean _and = false;
      EList<Diagnostic> _errors_1 = resource.getErrors();
      int _size = _errors_1.size();
      boolean _equals = (_size == 0);
      if (!_equals) {
        _and = false;
      } else {
        EList<Diagnostic> _warnings = resource.getWarnings();
        int _size_1 = _warnings.size();
        boolean _equals_1 = (_size_1 == 0);
        _and = (_equals && _equals_1);
      }
      Assert.assertTrue(_string, _and);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void includeNothingTest2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("#include <>");
      _builder.newLine();
      final OilFile model = this.parser.parse(_builder);
      final Resource resource = model.eResource();
      EList<Diagnostic> _errors = resource.getErrors();
      String _string = _errors.toString();
      boolean _and = false;
      EList<Diagnostic> _errors_1 = resource.getErrors();
      int _size = _errors_1.size();
      boolean _equals = (_size == 0);
      if (!_equals) {
        _and = false;
      } else {
        EList<Diagnostic> _warnings = resource.getWarnings();
        int _size_1 = _warnings.size();
        boolean _equals_1 = (_size_1 == 0);
        _and = (_equals && _equals_1);
      }
      Assert.assertTrue(_string, _and);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void onlyIncludeTest1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("#include \"a\"");
      _builder.newLine();
      final OilFile model = this.parser.parse(_builder);
      final Resource resource = model.eResource();
      EList<Diagnostic> _errors = resource.getErrors();
      String _string = _errors.toString();
      boolean _and = false;
      EList<Diagnostic> _errors_1 = resource.getErrors();
      int _size = _errors_1.size();
      boolean _equals = (_size == 0);
      if (!_equals) {
        _and = false;
      } else {
        EList<Diagnostic> _warnings = resource.getWarnings();
        int _size_1 = _warnings.size();
        boolean _equals_1 = (_size_1 == 0);
        _and = (_equals && _equals_1);
      }
      Assert.assertTrue(_string, _and);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void onlyIncludeTest2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("#include <a>");
      _builder.newLine();
      final OilFile model = this.parser.parse(_builder);
      final Resource resource = model.eResource();
      EList<Diagnostic> _errors = resource.getErrors();
      String _string = _errors.toString();
      boolean _and = false;
      EList<Diagnostic> _errors_1 = resource.getErrors();
      int _size = _errors_1.size();
      boolean _equals = (_size == 0);
      if (!_equals) {
        _and = false;
      } else {
        EList<Diagnostic> _warnings = resource.getWarnings();
        int _size_1 = _warnings.size();
        boolean _equals_1 = (_size_1 == 0);
        _and = (_equals && _equals_1);
      }
      Assert.assertTrue(_string, _and);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void includeCpuContentTestFail1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("CPU s {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("#inlude");
      _builder.newLine();
      _builder.append("};");
      _builder.newLine();
      final OilFile model = this.parser.parse(_builder);
      final Resource resource = model.eResource();
      EList<Diagnostic> _errors = resource.getErrors();
      String _string = _errors.toString();
      boolean _and = false;
      EList<Diagnostic> _errors_1 = resource.getErrors();
      int _size = _errors_1.size();
      boolean _equals = (_size == 2);
      if (!_equals) {
        _and = false;
      } else {
        EList<Diagnostic> _warnings = resource.getWarnings();
        int _size_1 = _warnings.size();
        boolean _equals_1 = (_size_1 == 0);
        _and = (_equals && _equals_1);
      }
      Assert.assertTrue(_string, _and);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void includeCpuContentTestFail2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("CPU s {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("#include ");
      _builder.newLine();
      _builder.append("};");
      _builder.newLine();
      final OilFile model = this.parser.parse(_builder);
      final Resource resource = model.eResource();
      EList<Diagnostic> _errors = resource.getErrors();
      String _string = _errors.toString();
      boolean _and = false;
      EList<Diagnostic> _errors_1 = resource.getErrors();
      int _size = _errors_1.size();
      boolean _equals = (_size == 1);
      if (!_equals) {
        _and = false;
      } else {
        EList<Diagnostic> _warnings = resource.getWarnings();
        int _size_1 = _warnings.size();
        boolean _equals_1 = (_size_1 == 0);
        _and = (_equals && _equals_1);
      }
      Assert.assertTrue(_string, _and);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void includeCpuContentTest1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("CPU s {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("#include \"a\"");
      _builder.newLine();
      _builder.append("};");
      _builder.newLine();
      final OilFile model = this.parser.parse(_builder);
      final Resource resource = model.eResource();
      EList<Diagnostic> _errors = resource.getErrors();
      String _string = _errors.toString();
      boolean _and = false;
      EList<Diagnostic> _errors_1 = resource.getErrors();
      int _size = _errors_1.size();
      boolean _equals = (_size == 0);
      if (!_equals) {
        _and = false;
      } else {
        EList<Diagnostic> _warnings = resource.getWarnings();
        int _size_1 = _warnings.size();
        boolean _equals_1 = (_size_1 == 0);
        _and = (_equals && _equals_1);
      }
      Assert.assertTrue(_string, _and);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void includeCpuContentTest2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("CPU s {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("#include <a>");
      _builder.newLine();
      _builder.append("};");
      _builder.newLine();
      final OilFile model = this.parser.parse(_builder);
      final Resource resource = model.eResource();
      EList<Diagnostic> _errors = resource.getErrors();
      String _string = _errors.toString();
      boolean _and = false;
      EList<Diagnostic> _errors_1 = resource.getErrors();
      int _size = _errors_1.size();
      boolean _equals = (_size == 0);
      if (!_equals) {
        _and = false;
      } else {
        EList<Diagnostic> _warnings = resource.getWarnings();
        int _size_1 = _warnings.size();
        boolean _equals_1 = (_size_1 == 0);
        _and = (_equals && _equals_1);
      }
      Assert.assertTrue(_string, _and);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void includeCpuContentTest3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("CPU s {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("#include <a>};");
      _builder.newLine();
      final OilFile model = this.parser.parse(_builder);
      final Resource resource = model.eResource();
      EList<Diagnostic> _errors = resource.getErrors();
      String _string = _errors.toString();
      boolean _and = false;
      EList<Diagnostic> _errors_1 = resource.getErrors();
      int _size = _errors_1.size();
      boolean _equals = (_size == 0);
      if (!_equals) {
        _and = false;
      } else {
        EList<Diagnostic> _warnings = resource.getWarnings();
        int _size_1 = _warnings.size();
        boolean _equals_1 = (_size_1 == 0);
        _and = (_equals && _equals_1);
      }
      Assert.assertTrue(_string, _and);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void includeCpuContentTest4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("CPU s {#include <a>");
      _builder.newLine();
      _builder.append("};");
      _builder.newLine();
      final OilFile model = this.parser.parse(_builder);
      final Resource resource = model.eResource();
      EList<Diagnostic> _errors = resource.getErrors();
      String _string = _errors.toString();
      boolean _and = false;
      EList<Diagnostic> _errors_1 = resource.getErrors();
      int _size = _errors_1.size();
      boolean _equals = (_size == 0);
      if (!_equals) {
        _and = false;
      } else {
        EList<Diagnostic> _warnings = resource.getWarnings();
        int _size_1 = _warnings.size();
        boolean _equals_1 = (_size_1 == 0);
        _and = (_equals && _equals_1);
      }
      Assert.assertTrue(_string, _and);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void includeCpuContentTest5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("CPU s {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("#include \"a\"};");
      _builder.newLine();
      final OilFile model = this.parser.parse(_builder);
      final Resource resource = model.eResource();
      EList<Diagnostic> _errors = resource.getErrors();
      String _string = _errors.toString();
      boolean _and = false;
      EList<Diagnostic> _errors_1 = resource.getErrors();
      int _size = _errors_1.size();
      boolean _equals = (_size == 0);
      if (!_equals) {
        _and = false;
      } else {
        EList<Diagnostic> _warnings = resource.getWarnings();
        int _size_1 = _warnings.size();
        boolean _equals_1 = (_size_1 == 0);
        _and = (_equals && _equals_1);
      }
      Assert.assertTrue(_string, _and);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void includeCpuContentTest6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("CPU s {#include \"a\"");
      _builder.newLine();
      _builder.append("};");
      _builder.newLine();
      final OilFile model = this.parser.parse(_builder);
      final Resource resource = model.eResource();
      EList<Diagnostic> _errors = resource.getErrors();
      String _string = _errors.toString();
      boolean _and = false;
      EList<Diagnostic> _errors_1 = resource.getErrors();
      int _size = _errors_1.size();
      boolean _equals = (_size == 0);
      if (!_equals) {
        _and = false;
      } else {
        EList<Diagnostic> _warnings = resource.getWarnings();
        int _size_1 = _warnings.size();
        boolean _equals_1 = (_size_1 == 0);
        _and = (_equals && _equals_1);
      }
      Assert.assertTrue(_string, _and);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void includeNoSpace1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("CPU s {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}#include\"a\";");
      _builder.newLine();
      final OilFile model = this.parser.parse(_builder);
      final Resource resource = model.eResource();
      EList<Diagnostic> _errors = resource.getErrors();
      String _string = _errors.toString();
      boolean _and = false;
      EList<Diagnostic> _errors_1 = resource.getErrors();
      int _size = _errors_1.size();
      boolean _equals = (_size == 0);
      if (!_equals) {
        _and = false;
      } else {
        EList<Diagnostic> _warnings = resource.getWarnings();
        int _size_1 = _warnings.size();
        boolean _equals_1 = (_size_1 == 0);
        _and = (_equals && _equals_1);
      }
      Assert.assertTrue(_string, _and);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void includeNoSpace2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("CPU s {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}#include<a>;");
      _builder.newLine();
      final OilFile model = this.parser.parse(_builder);
      final Resource resource = model.eResource();
      EList<Diagnostic> _errors = resource.getErrors();
      String _string = _errors.toString();
      boolean _and = false;
      EList<Diagnostic> _errors_1 = resource.getErrors();
      int _size = _errors_1.size();
      boolean _equals = (_size == 0);
      if (!_equals) {
        _and = false;
      } else {
        EList<Diagnostic> _warnings = resource.getWarnings();
        int _size_1 = _warnings.size();
        boolean _equals_1 = (_size_1 == 0);
        _and = (_equals && _equals_1);
      }
      Assert.assertTrue(_string, _and);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void includeSpace1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("CPU s {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}#include\t\t\"a\";");
      _builder.newLine();
      final OilFile model = this.parser.parse(_builder);
      final Resource resource = model.eResource();
      EList<Diagnostic> _errors = resource.getErrors();
      String _string = _errors.toString();
      boolean _and = false;
      EList<Diagnostic> _errors_1 = resource.getErrors();
      int _size = _errors_1.size();
      boolean _equals = (_size == 0);
      if (!_equals) {
        _and = false;
      } else {
        EList<Diagnostic> _warnings = resource.getWarnings();
        int _size_1 = _warnings.size();
        boolean _equals_1 = (_size_1 == 0);
        _and = (_equals && _equals_1);
      }
      Assert.assertTrue(_string, _and);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void includeSpace2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("CPU s {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}#include \t <a>;");
      _builder.newLine();
      final OilFile model = this.parser.parse(_builder);
      final Resource resource = model.eResource();
      EList<Diagnostic> _errors = resource.getErrors();
      String _string = _errors.toString();
      boolean _and = false;
      EList<Diagnostic> _errors_1 = resource.getErrors();
      int _size = _errors_1.size();
      boolean _equals = (_size == 0);
      if (!_equals) {
        _and = false;
      } else {
        EList<Diagnostic> _warnings = resource.getWarnings();
        int _size_1 = _warnings.size();
        boolean _equals_1 = (_size_1 == 0);
        _and = (_equals && _equals_1);
      }
      Assert.assertTrue(_string, _and);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void includeNewLineTest1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("#include ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("\"a\"");
      _builder.newLine();
      final OilFile model = this.parser.parse(_builder);
      final Resource resource = model.eResource();
      EList<Diagnostic> _errors = resource.getErrors();
      String _string = _errors.toString();
      boolean _and = false;
      EList<Diagnostic> _errors_1 = resource.getErrors();
      int _size = _errors_1.size();
      boolean _equals = (_size == 2);
      if (!_equals) {
        _and = false;
      } else {
        EList<Diagnostic> _warnings = resource.getWarnings();
        int _size_1 = _warnings.size();
        boolean _equals_1 = (_size_1 == 0);
        _and = (_equals && _equals_1);
      }
      Assert.assertTrue(_string, _and);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void includeNewTest2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("#include ");
      _builder.newLine();
      _builder.append("<a>");
      _builder.newLine();
      final OilFile model = this.parser.parse(_builder);
      final Resource resource = model.eResource();
      EList<Diagnostic> _errors = resource.getErrors();
      String _string = _errors.toString();
      boolean _and = false;
      EList<Diagnostic> _errors_1 = resource.getErrors();
      int _size = _errors_1.size();
      boolean _equals = (_size == 2);
      if (!_equals) {
        _and = false;
      } else {
        EList<Diagnostic> _warnings = resource.getWarnings();
        int _size_1 = _warnings.size();
        boolean _equals_1 = (_size_1 == 0);
        _and = (_equals && _equals_1);
      }
      Assert.assertTrue(_string, _and);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
