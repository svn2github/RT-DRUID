package com.eu.evidence.rtdruid.oil.xtext.scoping;

import com.eu.evidence.rtdruid.oil.xtext.model.EType;
import com.eu.evidence.rtdruid.oil.xtext.model.EnumeratorType;
import com.eu.evidence.rtdruid.oil.xtext.model.ObjectType;
import com.eu.evidence.rtdruid.oil.xtext.model.OilApplication;
import com.eu.evidence.rtdruid.oil.xtext.model.OilFactory;
import com.eu.evidence.rtdruid.oil.xtext.model.OilFile;
import com.eu.evidence.rtdruid.oil.xtext.model.OilImplementation;
import com.eu.evidence.rtdruid.oil.xtext.model.OilObject;
import com.eu.evidence.rtdruid.oil.xtext.model.OilObjectImpl;
import com.eu.evidence.rtdruid.oil.xtext.model.Parameter;
import com.eu.evidence.rtdruid.oil.xtext.model.ParameterRef;
import com.eu.evidence.rtdruid.oil.xtext.model.ParameterType;
import com.eu.evidence.rtdruid.oil.xtext.model.VariantType;
import com.eu.evidence.rtdruid.oil.xtext.scoping.DefaultOilImplementationProvider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class OilTypesHelper {
  public static String DEFAULT_APP_MODE = "OSDEFAULTAPPMODE";
  
  public static boolean USECACHE = false;
  
  private static WeakHashMap<OilImplementation,Map<String,List<? extends EObject>>> implCache = new Function0<WeakHashMap<OilImplementation,Map<String,List<? extends EObject>>>>() {
    public WeakHashMap<OilImplementation,Map<String,List<? extends EObject>>> apply() {
      WeakHashMap<OilImplementation,Map<String,List<? extends EObject>>> _weakHashMap = new WeakHashMap<OilImplementation,Map<String,List<? extends EObject>>>();
      return _weakHashMap;
    }
  }.apply();
  
  private Logger logger = new Function0<Logger>() {
    public Logger apply() {
      Logger _logger = Logger.getLogger(com.eu.evidence.rtdruid.oil.xtext.scoping.OilTypesHelper.class);
      return _logger;
    }
  }.apply();
  
  public List<ParameterType> getParameterType(final List<String> path, final List<OilImplementation> roots) {
    ArrayList<ParameterType> _xblockexpression = null;
    {
      ArrayList<ParameterType> _arrayList = new ArrayList<ParameterType>();
      ArrayList<ParameterType> answer = _arrayList;
      List<? extends EObject> _elmentsType = this.getElmentsType(path, roots);
      Iterable<ParameterType> _filter = IterableExtensions.<ParameterType>filter(_elmentsType, com.eu.evidence.rtdruid.oil.xtext.model.ParameterType.class);
      CollectionExtensions.<ParameterType>addAll(answer, _filter);
      String _operator_plus = StringExtensions.operator_plus("Parameters for path ", path);
      String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, " = ");
      String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, answer);
      this.logger.debug(_operator_plus_2);
      _xblockexpression = (answer);
    }
    return _xblockexpression;
  }
  
  public List<EnumeratorType> getEnumeratorType(final List<String> path, final List<OilImplementation> roots) {
    ArrayList<EnumeratorType> _xblockexpression = null;
    {
      ArrayList<EnumeratorType> _arrayList = new ArrayList<EnumeratorType>();
      ArrayList<EnumeratorType> answer = _arrayList;
      List<? extends EObject> _elmentsType = this.getElmentsType(path, roots);
      Iterable<EnumeratorType> _filter = IterableExtensions.<EnumeratorType>filter(_elmentsType, com.eu.evidence.rtdruid.oil.xtext.model.EnumeratorType.class);
      CollectionExtensions.<EnumeratorType>addAll(answer, _filter);
      String _operator_plus = StringExtensions.operator_plus("Parameters for path ", path);
      String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, " = ");
      String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, answer);
      this.logger.debug(_operator_plus_2);
      _xblockexpression = (answer);
    }
    return _xblockexpression;
  }
  
  protected List<? extends EObject> getElmentsType(final List<String> path, final List<OilImplementation> roots) {
    List<? extends EObject> _xblockexpression = null;
    {
      boolean _operator_equals = ObjectExtensions.operator_equals(path, null);
      if (_operator_equals) {
        List<EObject> _emptyList = CollectionLiterals.<EObject>emptyList();
        return _emptyList;
      }
      ArrayList<EObject> _arrayList = new ArrayList<EObject>();
      List<? extends EObject> values = _arrayList;
      for (final OilImplementation obj : roots) {
        List<? extends EObject> _elmentsType = this.getElmentsType(path, obj);
        ((List) values).addAll(_elmentsType);
      }
      _xblockexpression = (values);
    }
    return _xblockexpression;
  }
  
  protected List<? extends EObject> getElmentsType(final List<String> path, final OilImplementation root) {
    List<? extends EObject> _xblockexpression = null;
    {
      List<? extends EObject> values = null;
      LinkedList<String> _linkedList = new LinkedList<String>();
      LinkedList<String> remaningPath = _linkedList;
      LinkedList<String> _linkedList_1 = new LinkedList<String>();
      LinkedList<String> handledPath = _linkedList_1;
      Map<String,List<? extends EObject>> map = null;
      boolean _containsKey = OilTypesHelper.implCache.containsKey(root);
      if (_containsKey) {
        {
          handledPath.addAll(path);
          Map<String,List<? extends EObject>> _get = OilTypesHelper.implCache.get(root);
          map = _get;
          {
            String _pathString = this.toPathString(handledPath);
            final String pathString = _pathString;
            boolean _containsKey_1 = map.containsKey(pathString);
            if (_containsKey_1) {
              List<? extends EObject> _get_1 = map.get(pathString);
              return _get_1;
            }
          }
          {
            String _removeLast = handledPath.removeLast();
            remaningPath.addFirst(_removeLast);
            boolean _operator_and = false;
            boolean _operator_equals = ObjectExtensions.operator_equals(values, null);
            if (!_operator_equals) {
              _operator_and = false;
            } else {
              boolean _isEmpty = handledPath.isEmpty();
              boolean _operator_not = BooleanExtensions.operator_not(_isEmpty);
              _operator_and = BooleanExtensions.operator_and(_operator_equals, _operator_not);
            }
            boolean _while = _operator_and;
            while (_while) {
              {
                String _pathString_1 = this.toPathString(handledPath);
                final String pathString_1 = _pathString_1;
                boolean _containsKey_2 = map.containsKey(pathString_1);
                if (_containsKey_2) {
                  List<? extends EObject> _get_2 = map.get(pathString_1);
                  values = _get_2;
                } else {
                  String _removeLast_1 = handledPath.removeLast();
                  remaningPath.addFirst(_removeLast_1);
                }
              }
              boolean _operator_and_1 = false;
              boolean _operator_equals_1 = ObjectExtensions.operator_equals(values, null);
              if (!_operator_equals_1) {
                _operator_and_1 = false;
              } else {
                boolean _isEmpty_1 = handledPath.isEmpty();
                boolean _operator_not_1 = BooleanExtensions.operator_not(_isEmpty_1);
                _operator_and_1 = BooleanExtensions.operator_and(_operator_equals_1, _operator_not_1);
              }
              _while = _operator_and_1;
            }
          }
        }
      } else {
        remaningPath.addAll(path);
      }
      boolean _operator_equals_1 = ObjectExtensions.operator_equals(values, null);
      if (_operator_equals_1) {
        {
          ArrayList<EObject> _arrayList = new ArrayList<EObject>();
          values = _arrayList;
          EList<OilObjectImpl> _oilObjects = root.getOilObjects();
          ((List) values).addAll(_oilObjects);
        }
      }
      for (final String pElem : remaningPath) {
        {
          ArrayList<EObject> _arrayList_1 = new ArrayList<EObject>();
          ArrayList<EObject> t = _arrayList_1;
          final Function1<EObject,Boolean> _function = new Function1<EObject,Boolean>() {
              public Boolean apply(final EObject it) {
                {
                  boolean matched = false;
                  if (!matched) {
                    if (it instanceof OilObjectImpl) {
                      final OilObjectImpl _oilObjectImpl = (OilObjectImpl)it;
                      matched=true;
                      ObjectType _type = _oilObjectImpl.getType();
                      String _name = _type.name();
                      boolean _operator_equals = ObjectExtensions.operator_equals(_name, pElem);
                      return Boolean.valueOf(_operator_equals);
                    }
                  }
                  if (!matched) {
                    if (it instanceof VariantType) {
                      final VariantType _variantType = (VariantType)it;
                      matched=true;
                      String _name = _variantType.getName();
                      boolean _operator_equals = ObjectExtensions.operator_equals(_name, pElem);
                      return Boolean.valueOf(_operator_equals);
                    }
                  }
                  if (!matched) {
                    if (it instanceof EnumeratorType) {
                      final EnumeratorType _enumeratorType = (EnumeratorType)it;
                      matched=true;
                      String _name = _enumeratorType.getName();
                      boolean _operator_equals = ObjectExtensions.operator_equals(_name, pElem);
                      return Boolean.valueOf(_operator_equals);
                    }
                  }
                  return Boolean.valueOf(false);
                }
              }
            };
          Iterable<? extends EObject> _filter = IterableExtensions.filter(values, _function);
          for (final EObject fElem : _filter) {
            List _switchResult = null;
            boolean matched = false;
            if (!matched) {
              if (fElem instanceof OilObjectImpl) {
                final OilObjectImpl _oilObjectImpl = (OilObjectImpl)fElem;
                matched=true;
                EList<ParameterType> _parameters = _oilObjectImpl.getParameters();
                _switchResult = _parameters;
              }
            }
            if (!matched) {
              if (fElem instanceof VariantType) {
                final VariantType _variantType = (VariantType)fElem;
                matched=true;
                EList<EnumeratorType> _enumerators = this.getEnumerators(_variantType);
                _switchResult = _enumerators;
              }
            }
            if (!matched) {
              if (fElem instanceof EnumeratorType) {
                final EnumeratorType _enumeratorType = (EnumeratorType)fElem;
                matched=true;
                EList<ParameterType> _parameters = _enumeratorType.getParameters();
                _switchResult = _parameters;
              }
            }
            if (!matched) {
              _switchResult = Collections.EMPTY_LIST;
            }
            CollectionExtensions.<EObject>addAll(t, _switchResult);
          }
          values = t;
          handledPath.addLast(pElem);
          boolean _operator_notEquals = ObjectExtensions.operator_notEquals(map, null);
          if (_operator_notEquals) {
            String _pathString_1 = this.toPathString(handledPath);
            map.put(_pathString_1, values);
          }
        }
      }
      String _operator_plus = StringExtensions.operator_plus("Object for path ", path);
      String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, " = ");
      String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, values);
      this.logger.debug(_operator_plus_2);
      _xblockexpression = (values);
    }
    return _xblockexpression;
  }
  
  private EList<EnumeratorType> getEnumerators(final VariantType fElem) {
    EList<EnumeratorType> _xblockexpression = null;
    {
      EType _type = fElem.getType();
      boolean _operator_equals = ObjectExtensions.operator_equals(_type, EType.BOOLEAN);
      if (_operator_equals) {
        {
          EList<EnumeratorType> _values = fElem.getValues();
          final Function1<EnumeratorType,Boolean> _function = new Function1<EnumeratorType,Boolean>() {
              public Boolean apply(final EnumeratorType it) {
                String _name = it.getName();
                boolean _equalsIgnoreCase = "TRUE".equalsIgnoreCase(_name);
                return Boolean.valueOf(_equalsIgnoreCase);
              }
            };
          Iterable<EnumeratorType> _filter = IterableExtensions.<EnumeratorType>filter(_values, _function);
          int _size = IterableExtensions.size(_filter);
          boolean _operator_equals_1 = IntegerExtensions.operator_equals(_size, 0);
          if (_operator_equals_1) {
            {
              EnumeratorType _createEnumeratorType = OilFactory.eINSTANCE.createEnumeratorType();
              final EnumeratorType trueType = _createEnumeratorType;
              trueType.setName("TRUE");
              EList<EnumeratorType> _values_1 = fElem.getValues();
              _values_1.add(trueType);
            }
          }
          EList<EnumeratorType> _values_2 = fElem.getValues();
          final Function1<EnumeratorType,Boolean> _function_1 = new Function1<EnumeratorType,Boolean>() {
              public Boolean apply(final EnumeratorType it) {
                String _name = it.getName();
                boolean _equalsIgnoreCase = "FALSE".equalsIgnoreCase(_name);
                return Boolean.valueOf(_equalsIgnoreCase);
              }
            };
          Iterable<EnumeratorType> _filter_1 = IterableExtensions.<EnumeratorType>filter(_values_2, _function_1);
          int _size_1 = IterableExtensions.size(_filter_1);
          boolean _operator_equals_2 = IntegerExtensions.operator_equals(_size_1, 0);
          if (_operator_equals_2) {
            {
              EnumeratorType _createEnumeratorType_1 = OilFactory.eINSTANCE.createEnumeratorType();
              final EnumeratorType trueType_1 = _createEnumeratorType_1;
              trueType_1.setName("FALSE");
              EList<EnumeratorType> _values_3 = fElem.getValues();
              _values_3.add(trueType_1);
            }
          }
        }
      }
      EList<EnumeratorType> _values_4 = fElem.getValues();
      _xblockexpression = (_values_4);
    }
    return _xblockexpression;
  }
  
  /**
   * Compute Path
   */
  public List<String> computePath(final EObject o, final boolean addEnum) {
      boolean _operator_equals = ObjectExtensions.operator_equals(o, null);
      if (_operator_equals) {
        List<String> _emptyList = CollectionLiterals.<String>emptyList();
        return _emptyList;
      }
      ArrayList<String> _arrayList = new ArrayList<String>();
      final List<String> answer = _arrayList;
      EObject obj = o;
      boolean _addEnum = addEnum;
      boolean _dowhile = false;
      do {
        {
          EObject _computePathElement = this.computePathElement(obj, _addEnum, answer);
          obj = _computePathElement;
          _addEnum = true;
        }
        boolean _operator_notEquals = ObjectExtensions.operator_notEquals(obj, null);
        _dowhile = _operator_notEquals;
      } while(_dowhile);
      String _operator_plus = StringExtensions.operator_plus("computed path ", o);
      String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, " = ");
      String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, answer);
      this.logger.debug(_operator_plus_2);
      return answer;
  }
  
  /**
   * Compute Path Element for Parameter
   */
  protected EObject _computePathElement(final Parameter it, final boolean addEnum, final List<String> path) {
    EObject _xblockexpression = null;
    {
      if (addEnum) {
        {
          ParameterRef _valueRef = it.getValueRef();
          ParameterRef vref = _valueRef;
          boolean _operator_and = false;
          boolean _operator_notEquals = ObjectExtensions.operator_notEquals(vref, null);
          if (!_operator_notEquals) {
            _operator_and = false;
          } else {
            _operator_and = BooleanExtensions.operator_and(_operator_notEquals, (vref instanceof EnumeratorType));
          }
          if (_operator_and) {
            String _name = ((EnumeratorType) vref).getName();
            path.add(0, _name);
          } else {
            {
              path.clear();
              return null;
            }
          }
        }
      }
      ParameterType _type = it.getType();
      final ParameterType type = _type;
      boolean _operator_equals = ObjectExtensions.operator_equals(type, null);
      if (_operator_equals) {
        {
          path.clear();
          return null;
        }
      }
      String _name_1 = type.getName();
      path.add(0, _name_1);
      EObject _eContainer = it.eContainer();
      _xblockexpression = (_eContainer);
    }
    return _xblockexpression;
  }
  
  /**
   * Compute Path Element for OilObject
   */
  protected EObject _computePathElement(final OilObject it, final boolean addEnum, final List<String> path) {
      ObjectType _type = it.getType();
      final ObjectType type = _type;
      boolean _operator_equals = ObjectExtensions.operator_equals(type, null);
      if (_operator_equals) {
        {
          path.clear();
          return null;
        }
      }
      String _name = type.name();
      path.add(0, _name);
      return null;
  }
  
  public List<OilImplementation> getOilImplementation(final EObject o) {
    List<OilImplementation> _xblockexpression = null;
    {
      ArrayList<OilImplementation> _arrayList = new ArrayList<OilImplementation>();
      List<OilImplementation> answer = _arrayList;
      Resource _eResource = o==null?(Resource)null:o.eResource();
      EList<EObject> _contents = _eResource.getContents();
      for (final EObject obj : _contents) {
        if ((obj instanceof OilFile)) {
          boolean _operator_and = false;
          boolean _operator_notEquals = ObjectExtensions.operator_notEquals(obj, null);
          if (!_operator_notEquals) {
            _operator_and = false;
          } else {
            OilImplementation _implementation = ((OilFile) obj).getImplementation();
            boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(_implementation, null);
            _operator_and = BooleanExtensions.operator_and(_operator_notEquals, _operator_notEquals_1);
          }
          if (_operator_and) {
            OilImplementation _implementation_1 = ((OilFile) obj).getImplementation();
            answer.add(_implementation_1);
          }
        }
      }
      boolean _isEmpty = answer.isEmpty();
      if (_isEmpty) {
        {
          List<OilImplementation> _implementations = DefaultOilImplementationProvider.instance.getImplementations();
          answer = _implementations;
          boolean _isEmpty_1 = OilTypesHelper.implCache.isEmpty();
          if (_isEmpty_1) {
            for (final OilImplementation impl : answer) {
              HashMap<String,List<? extends EObject>> _hashMap = new HashMap<String,List<? extends EObject>>();
              OilTypesHelper.implCache.put(impl, _hashMap);
            }
          }
        }
      }
      _xblockexpression = (answer);
    }
    return _xblockexpression;
  }
  
  public List<OilObject> getMainObjects(final Resource res, final ObjectType type) {
    ArrayList<OilObject> _xblockexpression = null;
    {
      boolean _operator_equals = ObjectExtensions.operator_equals(res, null);
      if (_operator_equals) {
        List<OilObject> _emptyList = CollectionLiterals.<OilObject>emptyList();
        return _emptyList;
      }
      ArrayList<OilObject> _arrayList = new ArrayList<OilObject>();
      ArrayList<OilObject> answer = _arrayList;
      EList<EObject> _contents = res==null?(EList<EObject>)null:res.getContents();
      for (final EObject ofile : _contents) {
        if ((ofile instanceof OilFile)) {
          OilApplication _application = ((OilFile) ofile).getApplication();
          EList<OilObject> _oilObjects = _application.getOilObjects();
          for (final OilObject obj : _oilObjects) {
            ObjectType _type = obj.getType();
            boolean _operator_equals_1 = ObjectExtensions.operator_equals(_type, type);
            if (_operator_equals_1) {
              answer.add(obj);
            }
          }
        }
      }
      _xblockexpression = (answer);
    }
    return _xblockexpression;
  }
  
  public OilObject addDefaultAppMode(final Resource res) {
      EList<OilObject> oilObjectList = null;
      EList<EObject> _contents = res==null?(EList<EObject>)null:res.getContents();
      for (final EObject ofile : _contents) {
        if ((ofile instanceof OilFile)) {
          {
            OilApplication _application = ((OilFile) ofile).getApplication();
            EList<OilObject> _oilObjects = _application.getOilObjects();
            oilObjectList = _oilObjects;
            for (final OilObject obj : oilObjectList) {
              ObjectType _type = obj.getType();
              boolean _operator_equals = ObjectExtensions.operator_equals(_type, ObjectType.APPMODE);
              if (_operator_equals) {
                String _name = obj.getName();
                boolean _equals = OilTypesHelper.DEFAULT_APP_MODE.equals(_name);
                if (_equals) {
                  return obj;
                }
              }
            }
          }
        }
      }
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(oilObjectList, null);
      if (_operator_notEquals) {
        {
          OilObject _createOilObject = OilFactory.eINSTANCE.createOilObject();
          final OilObject answer = _createOilObject;
          answer.setType(ObjectType.APPMODE);
          answer.setName(OilTypesHelper.DEFAULT_APP_MODE);
          oilObjectList.add(answer);
          return answer;
        }
      }
      return null;
  }
  
  private String toPathString(final List<String> path) {
    String _xblockexpression = null;
    {
      StringBuffer _stringBuffer = new StringBuffer();
      final StringBuffer buff = _stringBuffer;
      for (final String s : path) {
        {
          buff.append("/");
          buff.append(s);
        }
      }
      String _string = buff.toString();
      _xblockexpression = (_string);
    }
    return _xblockexpression;
  }
  
  public EObject computePathElement(final EObject it, final boolean addEnum, final List<String> path) {
    if (it instanceof OilObject) {
      return _computePathElement((OilObject)it, addEnum, path);
    } else if (it instanceof Parameter) {
      return _computePathElement((Parameter)it, addEnum, path);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, addEnum, path).toString());
    }
  }
}
