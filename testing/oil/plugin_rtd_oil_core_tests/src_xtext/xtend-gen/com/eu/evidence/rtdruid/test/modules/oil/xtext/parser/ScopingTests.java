package com.eu.evidence.rtdruid.test.modules.oil.xtext.parser;

import com.eu.evidence.rtdruid.oil.xtext.model.ObjectType;
import com.eu.evidence.rtdruid.oil.xtext.model.OilApplication;
import com.eu.evidence.rtdruid.oil.xtext.model.OilFile;
import com.eu.evidence.rtdruid.oil.xtext.model.OilObject;
import com.eu.evidence.rtdruid.oil.xtext.model.OilPackage;
import com.eu.evidence.rtdruid.oil.xtext.model.Parameter;
import com.eu.evidence.rtdruid.oil.xtext.model.ParameterType;
import com.eu.evidence.rtdruid.test.modules.oil.xtext.OilInjectorProvider;
import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2;
import org.eclipselabs.xtext.utils.unittesting.XtextTest;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@SuppressWarnings("all")
@RunWith(XtextRunner2.class)
@InjectWith(OilInjectorProvider.class)
public class ScopingTests extends XtextTest {
  @Inject
  private IScopeProvider scopeProvider;
  
  @Inject
  private ParseHelper<OilFile> parser;
  
  @Test
  public void elementsInScope() {
    try {
      {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("IMPLEMENTATION a {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("OS {");
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
        _builder.append("] a;");
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
        _builder.append("CPU s {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("OS aa {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("};");
        _builder.newLine();
        _builder.append("};");
        _builder.newLine();
        OilFile _parse = this.parser.parse(_builder);
        final OilFile model = _parse;
        OilApplication _application = model.getApplication();
        EList<OilObject> _oilObjects = _application.getOilObjects();
        OilObject _get = _oilObjects.get(0);
        final OilObject os = _get;
        ObjectType _type = os.getType();
        Assert.assertSame(ObjectType.OS, _type);
        EReference _oilObject_Parameters = OilPackage.eINSTANCE.getOilObject_Parameters();
        IScope _scope = this.scopeProvider.getScope(os, _oilObject_Parameters);
        final IScope scope = _scope;
        Iterable<IEObjectDescription> _allElements = scope.getAllElements();
        final Function1<IEObjectDescription,String> _function = new Function1<IEObjectDescription,String>() {
            public String apply(final IEObjectDescription it) {
              QualifiedName _name = it.getName();
              String _string = _name.toString();
              return _string;
            }
          };
        Iterable<String> _map = IterableExtensions.<IEObjectDescription, String>map(_allElements, _function);
        InputOutput.<Iterable<String>>println(_map);
        Iterable<IEObjectDescription> _allElements_1 = scope.getAllElements();
        int _size = IterableExtensions.size(_allElements_1);
        Assert.assertEquals(2, _size);
        Iterable<IEObjectDescription> _allElements_2 = scope.getAllElements();
        final Function1<IEObjectDescription,String> _function_1 = new Function1<IEObjectDescription,String>() {
            public String apply(final IEObjectDescription it) {
              QualifiedName _name = it.getName();
              String _string = _name.toString();
              return _string;
            }
          };
        Iterable<String> _map_1 = IterableExtensions.<IEObjectDescription, String>map(_allElements_2, _function_1);
        Matcher<Iterable<String>> _hasItem = Matchers.<String>hasItem("a");
        Matcher<Iterable<String>> _hasItem_1 = Matchers.<String>hasItem("at");
        Matcher<Iterable<String>> _allOf = Matchers.<Iterable<String>>allOf(_hasItem, _hasItem_1);
        Assert.<Iterable<String>>assertThat(_map_1, _allOf);
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void enumScope() {
    try {
      {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("IMPLEMENTATION a {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("OS {");
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
        _builder.append("] a;");
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
        _builder.append("CPU s {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("OS aa {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("a = TRUE { ");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("} : \"a");
        _builder.newLine();
        _builder.append("asdasd\";");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("};");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("ALARM alarm1 {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("};");
        _builder.newLine();
        _builder.append("};");
        _builder.newLine();
        OilFile _parse = this.parser.parse(_builder);
        final OilFile model = _parse;
        OilApplication _application = model.getApplication();
        EList<OilObject> _oilObjects = _application.getOilObjects();
        OilObject _get = _oilObjects.get(0);
        final OilObject os = _get;
        ObjectType _type = os.getType();
        Assert.assertSame(ObjectType.OS, _type);
        EList<Parameter> _parameters = os.getParameters();
        Parameter _get_1 = _parameters.get(0);
        final Parameter a = _get_1;
        ParameterType _type_1 = a.getType();
        String _name = _type_1.getName();
        Assert.assertEquals("a", _name);
        {
          EReference _parameter_Type = OilPackage.eINSTANCE.getParameter_Type();
          IScope _scope = this.scopeProvider.getScope(a, _parameter_Type);
          final IScope scope = _scope;
          Iterable<IEObjectDescription> _allElements = scope.getAllElements();
          final Function1<IEObjectDescription,String> _function = new Function1<IEObjectDescription,String>() {
              public String apply(final IEObjectDescription it) {
                QualifiedName _name = it.getName();
                String _string = _name.toString();
                return _string;
              }
            };
          Iterable<String> _map = IterableExtensions.<IEObjectDescription, String>map(_allElements, _function);
          InputOutput.<Iterable<String>>println(_map);
          Iterable<IEObjectDescription> _allElements_1 = scope.getAllElements();
          int _size = IterableExtensions.size(_allElements_1);
          Assert.assertEquals(2, _size);
          Iterable<IEObjectDescription> _allElements_2 = scope.getAllElements();
          final Function1<IEObjectDescription,String> _function_1 = new Function1<IEObjectDescription,String>() {
              public String apply(final IEObjectDescription it) {
                QualifiedName _name = it.getName();
                String _string = _name.toString();
                return _string;
              }
            };
          Iterable<String> _map_1 = IterableExtensions.<IEObjectDescription, String>map(_allElements_2, _function_1);
          Matcher<Iterable<String>> _hasItem = Matchers.<String>hasItem("a");
          Matcher<Iterable<String>> _hasItem_1 = Matchers.<String>hasItem("at");
          Matcher<Iterable<String>> _allOf = Matchers.<Iterable<String>>allOf(_hasItem, _hasItem_1);
          Assert.<Iterable<String>>assertThat(_map_1, _allOf);
        }
        {
          EReference _parameter_ValueRef = OilPackage.eINSTANCE.getParameter_ValueRef();
          IScope _scope_1 = this.scopeProvider.getScope(a, _parameter_ValueRef);
          final IScope scope_1 = _scope_1;
          Iterable<IEObjectDescription> _allElements_3 = scope_1.getAllElements();
          final Function1<IEObjectDescription,String> _function_2 = new Function1<IEObjectDescription,String>() {
              public String apply(final IEObjectDescription it) {
                QualifiedName _name = it.getName();
                String _string = _name.toString();
                return _string;
              }
            };
          Iterable<String> _map_2 = IterableExtensions.<IEObjectDescription, String>map(_allElements_3, _function_2);
          InputOutput.<Iterable<String>>println(_map_2);
          Iterable<IEObjectDescription> _allElements_4 = scope_1.getAllElements();
          int _size_1 = IterableExtensions.size(_allElements_4);
          Assert.assertEquals(2, _size_1);
          Iterable<IEObjectDescription> _allElements_5 = scope_1.getAllElements();
          final Function1<IEObjectDescription,String> _function_3 = new Function1<IEObjectDescription,String>() {
              public String apply(final IEObjectDescription it) {
                QualifiedName _name = it.getName();
                String _string = _name.toString();
                return _string;
              }
            };
          Iterable<String> _map_3 = IterableExtensions.<IEObjectDescription, String>map(_allElements_5, _function_3);
          Matcher<Iterable<String>> _hasItem_2 = Matchers.<String>hasItem("TRUE");
          Matcher<Iterable<String>> _hasItem_3 = Matchers.<String>hasItem("FALSE");
          Matcher<Iterable<String>> _allOf_1 = Matchers.<Iterable<String>>allOf(_hasItem_2, _hasItem_3);
          Assert.<Iterable<String>>assertThat(_map_3, _allOf_1);
        }
        {
          EReference _parameter_Parameters = OilPackage.eINSTANCE.getParameter_Parameters();
          IScope _scope_2 = this.scopeProvider.getScope(a, _parameter_Parameters);
          final IScope scope_2 = _scope_2;
          Iterable<IEObjectDescription> _allElements_6 = scope_2.getAllElements();
          final Function1<IEObjectDescription,String> _function_4 = new Function1<IEObjectDescription,String>() {
              public String apply(final IEObjectDescription it) {
                QualifiedName _name = it.getName();
                String _string = _name.toString();
                return _string;
              }
            };
          Iterable<String> _map_4 = IterableExtensions.<IEObjectDescription, String>map(_allElements_6, _function_4);
          InputOutput.<Iterable<String>>println(_map_4);
          Iterable<IEObjectDescription> _allElements_7 = scope_2.getAllElements();
          int _size_2 = IterableExtensions.size(_allElements_7);
          Assert.assertEquals(2, _size_2);
          Iterable<IEObjectDescription> _allElements_8 = scope_2.getAllElements();
          final Function1<IEObjectDescription,String> _function_5 = new Function1<IEObjectDescription,String>() {
              public String apply(final IEObjectDescription it) {
                QualifiedName _name = it.getName();
                String _string = _name.toString();
                return _string;
              }
            };
          Iterable<String> _map_5 = IterableExtensions.<IEObjectDescription, String>map(_allElements_8, _function_5);
          Matcher<Iterable<String>> _hasItem_4 = Matchers.<String>hasItem("b");
          Matcher<Iterable<String>> _hasItem_5 = Matchers.<String>hasItem("d");
          Matcher<Iterable<String>> _allOf_2 = Matchers.<Iterable<String>>allOf(_hasItem_4, _hasItem_5);
          Assert.<Iterable<String>>assertThat(_map_5, _allOf_2);
        }
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void refScope() {
    try {
      {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("IMPLEMENTATION a {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("OS {");
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
        _builder.append("] a;");
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
        _builder.append("CPU s {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("OS aa {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("at = alarm1;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("};");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("ALARM alarm1 {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("};");
        _builder.newLine();
        _builder.append("};");
        _builder.newLine();
        OilFile _parse = this.parser.parse(_builder);
        final OilFile model = _parse;
        OilApplication _application = model.getApplication();
        EList<OilObject> _oilObjects = _application.getOilObjects();
        OilObject _get = _oilObjects.get(0);
        final OilObject os = _get;
        ObjectType _type = os.getType();
        Assert.assertSame(ObjectType.OS, _type);
        EList<Parameter> _parameters = os.getParameters();
        Parameter _get_1 = _parameters.get(0);
        final Parameter a = _get_1;
        ParameterType _type_1 = a.getType();
        String _name = _type_1.getName();
        Assert.assertEquals("at", _name);
        {
          EReference _parameter_ValueRef = OilPackage.eINSTANCE.getParameter_ValueRef();
          IScope _scope = this.scopeProvider.getScope(a, _parameter_ValueRef);
          final IScope scope = _scope;
          Iterable<IEObjectDescription> _allElements = scope.getAllElements();
          final Function1<IEObjectDescription,String> _function = new Function1<IEObjectDescription,String>() {
              public String apply(final IEObjectDescription it) {
                QualifiedName _name = it.getName();
                String _string = _name.toString();
                return _string;
              }
            };
          Iterable<String> _map = IterableExtensions.<IEObjectDescription, String>map(_allElements, _function);
          InputOutput.<Iterable<String>>println(_map);
          Iterable<IEObjectDescription> _allElements_1 = scope.getAllElements();
          int _size = IterableExtensions.size(_allElements_1);
          Assert.assertEquals(1, _size);
          Iterable<IEObjectDescription> _allElements_2 = scope.getAllElements();
          final Function1<IEObjectDescription,String> _function_1 = new Function1<IEObjectDescription,String>() {
              public String apply(final IEObjectDescription it) {
                QualifiedName _name = it.getName();
                String _string = _name.toString();
                return _string;
              }
            };
          Iterable<String> _map_1 = IterableExtensions.<IEObjectDescription, String>map(_allElements_2, _function_1);
          Matcher<Iterable<String>> _hasItem = Matchers.<String>hasItem("alarm1");
          Assert.<Iterable<String>>assertThat(_map_1, _hasItem);
        }
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
