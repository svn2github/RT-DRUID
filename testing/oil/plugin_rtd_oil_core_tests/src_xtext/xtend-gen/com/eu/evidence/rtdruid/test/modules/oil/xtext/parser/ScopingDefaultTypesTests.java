package com.eu.evidence.rtdruid.test.modules.oil.xtext.parser;

import com.eu.evidence.rtdruid.oil.xtext.model.ObjectType;
import com.eu.evidence.rtdruid.oil.xtext.model.OilApplication;
import com.eu.evidence.rtdruid.oil.xtext.model.OilFile;
import com.eu.evidence.rtdruid.oil.xtext.model.OilObject;
import com.eu.evidence.rtdruid.oil.xtext.model.OilPackage;
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

@RunWith(value = XtextRunner2.class)
@InjectWith(value = OilInjectorProvider.class)
@SuppressWarnings("all")
public class ScopingDefaultTypesTests extends XtextTest {
  @Inject
  private IScopeProvider scopeProvider;
  
  @Inject
  private ParseHelper<OilFile> parser;
  
  @Test
  public void cpuData() {
    try {
      StringConcatenation _builder = new StringConcatenation();
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
      final OilFile model = this.parser.parse(_builder);
      OilApplication _application = model.getApplication();
      EList<OilObject> _oilObjects = _application.getOilObjects();
      final OilObject os = _oilObjects.get(0);
      ObjectType _type = os.getType();
      Assert.assertSame(ObjectType.OS, _type);
      EReference _oilObject_Parameters = OilPackage.eINSTANCE.getOilObject_Parameters();
      final IScope scope = this.scopeProvider.getScope(os, _oilObject_Parameters);
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
      Matcher<Integer> _greaterThan = Matchers.<Integer>greaterThan(Integer.valueOf(0));
      Assert.<Integer>assertThat(Integer.valueOf(_size), _greaterThan);
      Iterable<IEObjectDescription> _allElements_2 = scope.getAllElements();
      final Function1<IEObjectDescription,String> _function_1 = new Function1<IEObjectDescription,String>() {
          public String apply(final IEObjectDescription it) {
            QualifiedName _name = it.getName();
            String _string = _name.toString();
            return _string;
          }
        };
      Iterable<String> _map_1 = IterableExtensions.<IEObjectDescription, String>map(_allElements_2, _function_1);
      Matcher<Iterable<String>> _hasItem = Matchers.<String>hasItem("CPU_DATA");
      Assert.<Iterable<String>>assertThat(_map_1, _hasItem);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
