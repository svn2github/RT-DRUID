/**
 * 26/giu/2012
 */
package com.eu.evidence.rtdruid.oil.xtext.scoping;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

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
import com.eu.evidence.rtdruid.oil.xtext.model.VType;
import com.eu.evidence.rtdruid.oil.xtext.model.VariantType;
import com.eu.evidence.rtdruid.oil.xtext.services.IOilTypesHelper;

/**
 * 
 * @author Nicola Serreli
 * @since 2.0
 * 
 */
public class OilTypesFastHelper implements IOilTypesHelper {

	public static String DEFAULT_APP_MODE = "OSDEFAULTAPPMODE";
	public static String RES_SCHEDULER = "RES_SCHEDULER";
	
	public static boolean USECACHE = false;

	private static Map<String, List<? extends EObject>> implCache = new HashMap<String, List<? extends EObject>>();
	private static List<OilImplementation> defaultOilImplementation = null; 

	private static Logger logger = Logger.getLogger(com.eu.evidence.rtdruid.oil.xtext.scoping.OilTypesFastHelper.class);
	private static boolean loggerEnabled = false; //logger.isDebugEnabled();

	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.oil.xtext.scoping.IOilTypeHelper#getParameterType(java.util.List, java.util.List)
	 */
	@Override
	public List<ParameterType> getParameterType(final List<String> path, final List<OilImplementation> roots) {
		List<ParameterType> answer = filterCollection( getElmentsType(path, roots), ParameterType.class);
		
		if (loggerEnabled) {
			logger.debug("Parameters for path " + path + " = " + answer);
		}
		return answer;
	}

	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.oil.xtext.scoping.IOilTypeHelper#getEnumeratorType(java.util.List, java.util.List)
	 */
	@Override
	public List<EnumeratorType> getEnumeratorType(final List<String> path, final List<OilImplementation> roots) {
		List<EnumeratorType> answer = filterCollection( getElmentsType(path, roots), EnumeratorType.class);

		if (loggerEnabled) {
			logger.debug("Parameters for path " + path + " = " + answer);
		}
		return answer;
	}

	/**
	 * @param path
	 * @param roots
	 * @param answer
	 */
	@SuppressWarnings("unchecked")
	protected <T extends EObject> List<T> filterCollection(final List<?> list, Class<T> type) {
		List<T> answer = new LinkedList<T>();
		for (Object o : list) {
			if (type.isInstance(o)) {
				answer.add((T)o);
			}
		}
		return answer;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected List<? extends EObject> getElmentsType(final List<String> path, final List<OilImplementation> roots) {
		if (path == null) 
			return Collections.emptyList();
		
		List<? extends EObject> values = null;
		LinkedList<String> remaningPath = new LinkedList<String>();
		LinkedList<String> handledPath = new LinkedList<String>();
		Map<String, List<? extends EObject>> map = null;
		
		// Check if the root is cached
		if (roots == defaultOilImplementation) {
			{
				handledPath.addAll(path);
				map = implCache; //.get(root);
				
				
				{	// already computed list
					final String key = toPathString(handledPath);
					if (map.containsKey(key)) {
						return map.get(key);
					}
				}
				
				if (!handledPath.isEmpty()) {	// search if something is already computed
					remaningPath.addFirst(handledPath.removeLast());
					while (values == null && !handledPath.isEmpty()) {
						final String key = toPathString(handledPath);
						if (map.containsKey(key)) {
							values = map.get(key);
						} else {
							remaningPath.addFirst(handledPath.removeLast());
						}
					}
				}
			}
		} else {
			remaningPath.addAll(path);
		}
		
		if (values == null) {
			values = new LinkedList<EObject>();
			for (OilImplementation root : roots) {
				((List) values).addAll(root.getOilObjects());
			}
		}
		
		// Following the path and Searching elements
		for (final String pElem : remaningPath) {
			ArrayList<EObject> t = new ArrayList<EObject>();
			
			for (final EObject fElem : values) {
				if (compareElementAndPath(fElem, pElem)) {
					addNextLevelItems(fElem, t);
				}
			}
			
			// update values and path
			values = t;
			handledPath.addLast(pElem);
			// if map is available, store last computed values
			if (map != null) {
				map.put(toPathString(handledPath), values);
			}
		}
	
		if (loggerEnabled) {
			logger.debug("Object for path " + path + " = " + values);
		}
		return values;
	}

	/**
	 * @param input
	 * @param destination
	 */
	private void addNextLevelItems(EObject input, ArrayList<EObject> destination) {
		if (input instanceof OilObjectImpl) {
			destination.addAll(((OilObjectImpl) input).getParameters());
		} else 	if (input instanceof VariantType) {
			destination.addAll(getEnumerators((VariantType) input));
		} else if (input instanceof EnumeratorType) {
			destination.addAll(((EnumeratorType) input).getParameters());
		}
	}

	private boolean compareElementAndPath(EObject it, String path) {
		if (path != null) {
			if (it instanceof OilObjectImpl) {
				final OilObjectImpl _oilObjectImpl = (OilObjectImpl) it;
				ObjectType _type = _oilObjectImpl.getType();
				String _name = _type == null ? null :  _type.name();
				return path.equals(_name);
				
			} else if (it instanceof VariantType) {
				return path.equals( ((VariantType) it).getName());
				
			} else  if (it instanceof EnumeratorType) {
				return path.equals( ((EnumeratorType) it).getName());
			}
		}
		return false;
	}
	
	private EList<EnumeratorType> getEnumerators(final VariantType fElem) {
		
		final EType _type = fElem.getType();
		if (_type == EType.BOOLEAN) {
			EList<EnumeratorType> _values = fElem.getValues();
			// missing TRUE item?
			if (!exist(_values, "TRUE")) {
				final EnumeratorType trueType = OilFactory.eINSTANCE.createEnumeratorType();
				trueType.setName("TRUE");
				_values.add(trueType);
			}
			// missing FALSE item?
			if (!exist(_values, "FALSE")) {
				final EnumeratorType falseType = OilFactory.eINSTANCE.createEnumeratorType();
				falseType.setName("FALSE");
				_values.add(falseType);
			}
		}
		
		return fElem.getValues();
	}
	
	private boolean exist(final EList<EnumeratorType> values, final String name) {
		for (EnumeratorType value: values) {
			if (name.equals(value.getName())) {
				return true;
			}
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.oil.xtext.scoping.IOilTypeHelper#computePath(org.eclipse.emf.ecore.EObject, boolean)
	 */
	@Override
	public List<String> computePath(final EObject o, final boolean addEnum) {
		
		if (o == null) {
			return Collections.emptyList();
		}
		
		final LinkedList<String> answer = new LinkedList<String>();;
		EObject obj = o;
		boolean _addEnum = addEnum;
		do {
			obj = computePathElement(obj, _addEnum, answer);
			_addEnum = true;
		} while (obj != null);
		
		if (loggerEnabled) {
			logger.debug("computed path " + o + " = " + answer);
		}
		return answer;
	}

	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.oil.xtext.scoping.IOilTypeHelper#getOilImplementation(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public List<OilImplementation> getOilImplementation(final EObject o) {
		List<OilImplementation> answer = new ArrayList<OilImplementation>();
		if (o!=null && o.eResource()!=null) {			
			for (final EObject obj : o.eResource().getContents()) {
				if (obj instanceof OilFile) {
					OilImplementation _implementation = ((OilFile) obj).getImplementation();
					if (_implementation != null) {
						answer.add(_implementation);
					}
				}
			}
		}
		if (defaultOilImplementation == null) {
			defaultOilImplementation = DefaultOilImplementationProvider.instance.getImplementations();
		}

		if (defaultOilImplementation.containsAll(answer)) {
			answer = defaultOilImplementation;
		}
		return answer;
	}

	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.oil.xtext.scoping.IOilTypeHelper#getMainObjects(org.eclipse.emf.ecore.resource.Resource, com.eu.evidence.rtdruid.oil.xtext.model.ObjectType)
	 */
	@Override
	public List<OilObject> getMainObjects(final Resource res, final ObjectType type) {
		if (res == null) {
			return Collections.emptyList();
		}
		ArrayList<OilObject> answer = new ArrayList<OilObject>();
		for (final EObject ofile : res.getContents()) {
			if (ofile instanceof OilFile) {
				OilApplication _application = ((OilFile) ofile).getApplication();
				if (_application != null) {
					for (final OilObject obj : _application.getOilObjects()) {
						if (type == obj.getType()) {
							answer.add(obj);
						}
					}
				}
			}
		}
		return answer;
	}

	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.oil.xtext.scoping.IOilTypeHelper#addDefaultAppMode(org.eclipse.emf.ecore.resource.Resource)
	 */
	@Override
	public OilObject addDefaultAppMode(final Resource res) {
		if (res != null && res.getContents() != null) {
			
			EList<OilObject> oilObjectList = null;
			for (final EObject ofile : res.getContents()) {
				if ((ofile instanceof OilFile)) {
					OilApplication _application = ((OilFile) ofile).getApplication();
					if (_application != null) {
						oilObjectList = _application.getOilObjects();
						for (final OilObject obj : oilObjectList) {
							if (obj.getType() == ObjectType.APPMODE && DEFAULT_APP_MODE.equals(obj.getName())) {
								return obj;
							}
						}
					}
				}
			}
			if (oilObjectList !=  null) {
				final OilObject answer = OilFactory.eINSTANCE.createOilObject();
				answer.setType(ObjectType.APPMODE);
				answer.setName(DEFAULT_APP_MODE);
				oilObjectList.add(answer);
				return answer;
			}
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.oil.xtext.scoping.IOilTypeHelper#addDefaultAppMode(org.eclipse.emf.ecore.resource.Resource)
	 */
	@Override
	public OilObject addResScheduler(final Resource res) {
		if (res != null && res.getContents() != null) {
			
			EList<OilObject> oilObjectList = null;
			for (final EObject ofile : res.getContents()) {
				if ((ofile instanceof OilFile)) {
					OilApplication _application = ((OilFile) ofile).getApplication();
					if (_application != null) {
						oilObjectList = _application.getOilObjects();
						for (final OilObject obj : oilObjectList) {
							if (obj.getType() == ObjectType.RESOURCE && RES_SCHEDULER.equals(obj.getName())) {
								return obj;
							}
						}
					}
				}
			}
			if (oilObjectList !=  null) {
				final OilObject answer = OilFactory.eINSTANCE.createOilObject();
				answer.setType(ObjectType.RESOURCE);
				answer.setName(RES_SCHEDULER);
				oilObjectList.add(answer);
				return answer;
			}
		}
		return null;
	}

	private String toPathString(final List<String> path) {
		final StringBuffer buff = new StringBuffer();
		for (final String s : path) {
			buff.append("/").append(s);
		}
		return buff.toString();
	}

	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.oil.xtext.scoping.IOilTypeHelper#computePathElement(org.eclipse.emf.ecore.EObject, boolean, java.util.LinkedList)
	 */
	@Override
	public EObject computePathElement(final EObject it, final boolean addEnum, final LinkedList<String> path) {
		if (it instanceof OilObject) {
			return _computePathElement((OilObject) it, addEnum, path);
			
		} else if (it instanceof Parameter) {
			return _computePathElement((Parameter) it, addEnum, path);
			
		} else if (it instanceof ParameterType) {
			return _computePathElement((ParameterType) it, addEnum, path);
			
		} else if (it instanceof EnumeratorType) {
			return _computePathElement((EnumeratorType) it, addEnum, path);
			
		} else if (it instanceof OilObjectImpl) {
				return _computePathElement((OilObjectImpl) it, addEnum, path);
				
		} else {
			throw new IllegalArgumentException("Unhandled parameter types: "
					+ Arrays.<Object> asList(it, addEnum, path).toString());
		}
	}

	/**
	 * Compute Path Element for Parameter
	 */
	protected EObject _computePathElement(final Parameter it, final boolean addEnum, final LinkedList<String> path) {
		if (addEnum) {
			ParameterRef vref = it.getValueRef();
			if (vref != null && vref instanceof EnumeratorType) {
				path.addFirst(((EnumeratorType) vref).getName());
			} else {
				path.clear();
				return null;
			}
		}
		
		final ParameterType type = it.getType();
		if (type == null) {
			path.clear();
			return null;
		}
		path.addFirst(type.getName());
		return it.eContainer();
	}

	/**
	 * Compute Path Element for OilObject
	 */
	protected EObject _computePathElement(final OilObject it, final boolean addEnum, final LinkedList<String> path) {
		final ObjectType type = it.getType();
		if (type == null) {
			path.clear();
		} else {
			path.addFirst(type.name());
		}
		return null;
	}
	
	/**
	 * Compute Path Element for OilObjectImpl
	 */
	protected EObject _computePathElement(final OilObjectImpl it, final boolean addEnum, final LinkedList<String> path) {
		final ObjectType type = it.getType();
		if (type == null) {
			path.clear();
		} else {
			path.addFirst(type.name());
		}
		return null;
	}
	
	/**
	 * Compute Path Element for ParameterType
	 */
	protected EObject _computePathElement(final ParameterType type, final boolean addEnum, final LinkedList<String> path) {
		if (type == null) {
			path.clear();
			return null;
		}
		path.addFirst(type.getName());
		return type.eContainer();
	}
	
	/**
	 * Compute Path Element for EnumeratorType
	 */
	protected EObject _computePathElement(final EnumeratorType type, final boolean addEnum, final LinkedList<String> path) {
		if (type == null) {
			path.clear();
			return null;
		}
		path.addFirst(type.getName());
		return type.eContainer();
	}

	@Override
	@SuppressWarnings("rawtypes")
	public Class<? extends Comparable> getType(VType vType) {
		Class<? extends Comparable> answer = null;
		switch (vType) {
		case FLOAT:  answer = Float.class;		break;
		case INT32:  answer = Integer.class;		break;
		case INT64:  answer = Long.class;		break;
		case UINT32:
		case UINT64: answer = BigInteger.class;		break;
		case STRING: answer = String.class;		break;
		}
		return answer;
	}

	
	/**
	 * This method transforms a String in the corresponding number/string, depending on VType
	 * 
	 */
	@Override
	public Comparable<?> computeValue(String value, VType type) {
		Comparable<?> answer = null;
		if (value != null) {
			try {

				switch (type) {
					case FLOAT : answer = new Float(value); break;
					case INT32 : answer = Integer.decode(value); break;
					case INT64 : answer = Long.decode(value); break;
					case UINT32 :
					case UINT64 :
						{
							if (MAX_INT_TXT.equals(value)) {
								if (type == VType.UINT32) {
									answer = MAX_UINT32;
								} else if (type == VType.UINT64) {
									answer = MAX_UINT64;
								} else {
									answer = MAX_INT;
								}
						
							} else if (value.startsWith("0x")) {
								answer = new BigInteger(value.substring(2), 16);
							} else {
								answer = new BigInteger(value);
							}
						}
						break;
					case STRING : answer = value;
				};
			} catch (NumberFormatException e) {
				// if this method is called on a validated model, it should not throw exceptions
			}
		}
		return answer;
	}

}
