package com.eu.evidence.rtdruid.oil.xtext.scoping;

import com.eu.evidence.rtdruid.oil.xtext.model.EnumeratorType;
import com.eu.evidence.rtdruid.oil.xtext.model.ObjectType;
import com.eu.evidence.rtdruid.oil.xtext.model.OilImplementation;
import com.eu.evidence.rtdruid.oil.xtext.model.OilObject;
import com.eu.evidence.rtdruid.oil.xtext.model.Parameter;
import com.eu.evidence.rtdruid.oil.xtext.model.ParameterRef;
import com.eu.evidence.rtdruid.oil.xtext.model.ParameterType;
import com.eu.evidence.rtdruid.oil.xtext.model.ReferenceType;
import com.eu.evidence.rtdruid.oil.xtext.scoping.OilNamesProvider;
import com.eu.evidence.rtdruid.oil.xtext.scoping.OilTypesHelper;
import com.google.common.base.Function;
import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class OilScopeProvider extends AbstractDeclarativeScopeProvider {
  @Inject
  private OilTypesHelper _oilTypesHelper;
  
  public IScope getOilScope(final List<? extends EObject> elements) {
    Function<EObject,QualifiedName> _wrapper = QualifiedName.<EObject>wrapper(OilNamesProvider.resolver);
    IScope _scopeFor = Scopes.scopeFor(elements, _wrapper, IScope.NULLSCOPE);
    return _scopeFor;
  }
  
  public IScope scope_OilObject_Parameters(final OilObject prop, final EReference ref) {
    IScope _xblockexpression = null;
    {
      String _operator_plus = StringExtensions.operator_plus("Scope OP ", prop);
      String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, " -> ");
      String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, ref);
      this.logger.debug(_operator_plus_2);
      List<String> _computePath = this._oilTypesHelper.computePath(prop, false);
      List<OilImplementation> _oilImplementation = this._oilTypesHelper.getOilImplementation(prop);
      List<ParameterType> _parameterType = this._oilTypesHelper.getParameterType(_computePath, _oilImplementation);
      IScope _oilScope = this.getOilScope(_parameterType);
      _xblockexpression = (_oilScope);
    }
    return _xblockexpression;
  }
  
  public IScope scope_Parameter_Type(final Parameter prop, final EReference ref) {
    IScope _xblockexpression = null;
    {
      EObject _eContainer = prop.eContainer();
      final boolean requireEnum = (_eContainer instanceof Parameter);
      String _operator_plus = StringExtensions.operator_plus("Scope PT ", prop);
      String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, " -> ");
      String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, ref);
      this.logger.debug(_operator_plus_2);
      EObject _eContainer_1 = prop.eContainer();
      List<String> _computePath = this._oilTypesHelper.computePath(_eContainer_1, requireEnum);
      List<OilImplementation> _oilImplementation = this._oilTypesHelper.getOilImplementation(prop);
      List<ParameterType> _parameterType = this._oilTypesHelper.getParameterType(_computePath, _oilImplementation);
      IScope _oilScope = this.getOilScope(_parameterType);
      _xblockexpression = (_oilScope);
    }
    return _xblockexpression;
  }
  
  public IScope scope_Parameter_ValueRef(final Parameter prop, final EReference ref) {
    IScope _xblockexpression = null;
    {
      String _operator_plus = StringExtensions.operator_plus("Scope PV ", prop);
      String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, " -> ");
      String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, ref);
      this.logger.debug(_operator_plus_2);
      IScope _xifexpression = null;
      ParameterType _type = prop.getType();
      if ((_type instanceof ReferenceType)) {
        Resource _eResource = prop.eResource();
        ParameterType _type_1 = prop.getType();
        ObjectType _type_2 = ((ReferenceType) _type_1).getType();
        List<OilObject> _mainObjects = this._oilTypesHelper.getMainObjects(_eResource, _type_2);
        IScope _oilScope = this.getOilScope(_mainObjects);
        _xifexpression = _oilScope;
      } else {
        List<String> _computePath = this._oilTypesHelper.computePath(prop, false);
        List<OilImplementation> _oilImplementation = this._oilTypesHelper.getOilImplementation(prop);
        List<EnumeratorType> _enumeratorType = this._oilTypesHelper.getEnumeratorType(_computePath, _oilImplementation);
        IScope _oilScope_1 = this.getOilScope(_enumeratorType);
        _xifexpression = _oilScope_1;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public IScope scope_Parameter_Parameters(final Parameter prop, final EReference ref) {
    IScope _xblockexpression = null;
    {
      String _operator_plus = StringExtensions.operator_plus("Scope PP ", prop);
      String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, "(");
      ParameterRef _valueRef = prop.getValueRef();
      String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, _valueRef);
      String _operator_plus_3 = StringExtensions.operator_plus(_operator_plus_2, ") -> ");
      String _operator_plus_4 = StringExtensions.operator_plus(_operator_plus_3, ref);
      this.logger.debug(_operator_plus_4);
      List<String> _computePath = this._oilTypesHelper.computePath(prop, true);
      List<OilImplementation> _oilImplementation = this._oilTypesHelper.getOilImplementation(prop);
      List<ParameterType> _parameterType = this._oilTypesHelper.getParameterType(_computePath, _oilImplementation);
      IScope _oilScope = this.getOilScope(_parameterType);
      _xblockexpression = (_oilScope);
    }
    return _xblockexpression;
  }
}
