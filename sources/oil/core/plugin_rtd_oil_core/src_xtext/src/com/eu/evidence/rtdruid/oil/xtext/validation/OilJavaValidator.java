package com.eu.evidence.rtdruid.oil.xtext.validation;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;

import com.eu.evidence.rtdruid.oil.xtext.model.EType;
import com.eu.evidence.rtdruid.oil.xtext.model.EnumeratorType;
import com.eu.evidence.rtdruid.oil.xtext.model.ObjectType;
import com.eu.evidence.rtdruid.oil.xtext.model.OilFile;
import com.eu.evidence.rtdruid.oil.xtext.model.OilImplementation;
import com.eu.evidence.rtdruid.oil.xtext.model.OilObject;
import com.eu.evidence.rtdruid.oil.xtext.model.OilPackage;
import com.eu.evidence.rtdruid.oil.xtext.model.Parameter;
import com.eu.evidence.rtdruid.oil.xtext.model.ParameterRef;
import com.eu.evidence.rtdruid.oil.xtext.model.ParameterType;
import com.eu.evidence.rtdruid.oil.xtext.model.Range;
import com.eu.evidence.rtdruid.oil.xtext.model.ReferenceType;
import com.eu.evidence.rtdruid.oil.xtext.model.VType;
import com.eu.evidence.rtdruid.oil.xtext.model.ValidValues;
import com.eu.evidence.rtdruid.oil.xtext.model.ValueList;
import com.eu.evidence.rtdruid.oil.xtext.model.ValueType;
import com.eu.evidence.rtdruid.oil.xtext.model.VariantType;
import com.eu.evidence.rtdruid.oil.xtext.scoping.OilTypesFastHelper;
import com.eu.evidence.rtdruid.oil.xtext.services.IOilTypesHelper;

 

public class OilJavaValidator extends AbstractOilJavaValidator {

	private final static Logger logger = Logger.getLogger(OilJavaValidator.class);
	private final static boolean enableDebug = logger.isDebugEnabled();
	
	private final IOilTypesHelper helper = new OilTypesFastHelper();
	
	private static final String STR_EXPECTED_A_VALID = "Expected a valid ";
	private static final String STR_EXPECTED_A_POSITIVE_VALUE = "Expected a positive value";
	private static final String STR_PROVIDED_VALUE_DOES_NOT_FIT = "Provided value does not fit in a ";

	@Check
	public void checkModel(OilFile parameter) {
		
		if (enableDebug) logger.debug("Check Model " + parameter);
		if (parameter.getApplication() == null) {
			warning("Expected a CPU section",parameter, OilPackage.Literals.OIL_FILE__APPLICATION, IValidationCodes.MissingCpuSection);
		}
		
		for (Map<String, List<OilObject>> map : groupOilObjects(parameter).values()) {
			for (List<OilObject> list : map.values()) {
				checkParameterUniqueness(list);
			}
		}
	}

	@Check
	public void checkEnumeratorType(EnumeratorType parameter) {
		if (enableDebug) logger.debug("Check Enumerator " + parameter);
		
		EObject parent = parameter.eContainer();
		if (parent != null && parent instanceof VariantType && ((VariantType) parent).getType() == EType.BOOLEAN) {
			if (!("TRUE".equals(parameter.getName()) || "FALSE".equals(parameter.getName()))) {
				error("Only TRUE and FALSE are valid Boolean values", OilPackage.Literals.ENUMERATOR_TYPE__NAME);
			}
		}
	}

	
	@Check
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void checkValueType(ValueType parameter) {
		if (enableDebug) logger.debug("Check ValueType " + parameter);
		
		String prefix = (parameter.getName() != null ? parameter.getName() + ": " : "") ;
		VType type = parameter.getType();
		if (type == null) {
			error(prefix + "Invalid type", OilPackage.Literals.VALUE_TYPE__TYPE);
		} else {
			
			ValidValues vv = parameter.getValidValues();
			if (vv != null) {
				if (type == VType.STRING) {
					error(prefix + "A String type cannot have value restrictions", parameter,  OilPackage.Literals.VALUE_TYPE__VALID_VALUES, IValidationCodes.StringRestrictions_valueType);
				} else {
					if (vv instanceof Range) {
						checkValueConformance(((Range)vv).getMin(), type, prefix, vv, OilPackage.Literals.RANGE__MIN);
						checkValueConformance(((Range)vv).getMax(), type, prefix, vv, OilPackage.Literals.RANGE__MAX);

						String sMin = ((Range) vv).getMin();
						Comparable cMin = helper.computeValue(sMin, type);
						String sMax = ((Range) vv).getMax();
						Comparable cMax = helper.computeValue(sMax, type);
						if (cMin != null && cMax != null) {
							if (cMax.compareTo(cMin) <0) {
								error(prefix + "The minimum valid value ("+sMin+") is bigger than maximum valid value ("+sMax+")", vv,  OilPackage.Literals.RANGE__MIN, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, IValidationCodes.InvertRangeBoundaries);
							}
						}
						
					} else if (vv instanceof ValueList) {
						EList<String> vlist = ((ValueList)vv).getValues();
						for (int i=0; i<vlist.size(); i++) {
							checkValueConformance(prefix, vlist.get(i), OilPackage.Literals.VALUE_LIST__VALUES, type, vv, i);
						}
					}
				}
			}
			
			if (parameter.isDefaultAuto()) {
				// = AUTO
				if (!parameter.isWithAuto()) {
					error(prefix + "Default value AUTO requires the WITH_AUTO keyword", parameter,  OilPackage.Literals.PARAMETER_TYPE__DEFAULT_AUTO, IValidationCodes.MissingWithAuto_valueType);
				}
			} else {
				String value = parameter.getDefaultValue();
				checkValueConformance(value, type, prefix, parameter, OilPackage.Literals.PARAMETER_TYPE__DEFAULT_VALUE);
				checkInRange(value, vv, type, prefix, parameter, OilPackage.Literals.PARAMETER_TYPE__DEFAULT_VALUE);
			}
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void checkInRange(String value, ValidValues range, VType type, String prefix, EObject obj, EAttribute attribute) {
		if (range == null) {
			return;
		}
		if (value == null) {
			return;
		}
		
		Comparable cValue = helper.computeValue(value, type);
		if (cValue != null) {
			if (range instanceof Range) {
				String sMin = ((Range) range).getMin();
				Comparable cMin = helper.computeValue(sMin, type);
				String sMax = ((Range) range).getMax();
				Comparable cMax = helper.computeValue(sMax, type);
				
				if (cMin != null && cValue.compareTo(cMin) <0) {
					error(prefix + "Value ("+value+") is smaller than minimum valid value ("+sMin+")", obj,  attribute, ValidationMessageAcceptor.INSIGNIFICANT_INDEX);
				}
				if (cMax != null && cValue.compareTo(cMax) >0) {
					error(prefix + "Value ("+value+") is bigger than maximum valid value ("+sMax+")", obj,  attribute, ValidationMessageAcceptor.INSIGNIFICANT_INDEX);
				}
				
			} else if (range instanceof ValueList) {
				boolean found = false;
				ArrayList<String> vvalues = new ArrayList<String>();
				for (String sV : ((ValueList)range).getValues()) {
					Comparable cV = helper.computeValue(sV, type);
					if (cV != null) {
						if (cValue.compareTo(cV) ==0) {
							found = true;
							break;
						}
						vvalues.add(sV);
					}
				}
				if (!found) {
					error(prefix + "Value (" + value + ") is not one of valid values: " + ((ValueList) range).getValues(),
							obj, attribute, // object and attribute
							ValidationMessageAcceptor.INSIGNIFICANT_INDEX, // index
							IValidationCodes.ReplaceWithAValidValue, // error code
							vvalues.toArray(new String[vvalues.size()])); // values
				}
			}
		}
	}
	
	@Check
	public void checkParameter(Parameter parameter) {
		if (enableDebug) logger.debug("Check Parameter " + parameter);
		
		ParameterType type = parameter.getType();
		if (type == null) {
			error("Invalid parameter name", OilPackage.Literals.PARAMETER__TYPE);
		} else {
			String prefix = (type.getName() != null ? type.getName() + ": " : "") ;
			
			if (parameter.isAuto()) {
				// = AUTO
				if (!type.isWithAuto()) {
					error(prefix +"This parameter does not support AUTO value", OilPackage.Literals.PARAMETER__AUTO);
				}
				

//				if (parameter.isStructured()) {
//					error("This parameter is set to AUTO and cannot contain sub-elements", OilPackage.Literals.PARAMETER__STRUCTURED);
//				}
				
				if (parameter.getParameters().size()>0) {
					error(prefix +"This parameter is set to AUTO and cannot contain sub-elements", OilPackage.Literals.PARAMETER__PARAMETERS);
				}
				
			} else {
				
				
				
				if (type instanceof ValueType) {
					checkParameterValue(parameter, (ValueType) type);
				} else if (type instanceof ReferenceType) {
					// REFERENCE Type
					checkParameterReference(parameter, (ReferenceType) type);
					
				} else if (type instanceof VariantType) {
					// VARIANT Type
					checkParameterVariant(parameter, (VariantType) type);

				} else {
					// ??
				}
			}
		}
	}
		
	private void checkParameterValue(Parameter parameter, ValueType type) {
		VType vType = type.getType();
		String prefix = (type.getName() != null ? type.getName() + ": " : "") ;
		
		if (parameter.getValueRef() != null) {
			final String what;
			if (vType == VType.STRING) {
				what = IValidationCodes.AddQuotesToReferce_parametervalue;
			} else {
				what = IValidationCodes.FixReference_parametervalue;
			}
			error(prefix +"Expected a " + vType.getName() + ", not a reference", parameter, OilPackage.Literals.PARAMETER__VALUE_REF, what);
		}
		
		if (parameter.getParameters().size()>0) {
			error(prefix +"A value cannot contain sub-elements", OilPackage.Literals.PARAMETER__PARAMETERS);
		}

		// = ....
		String value = parameter.getValue();
		final EAttribute parameterValue = OilPackage.Literals.PARAMETER__VALUE;
		if (value == null)  {
			// = null
			if (parameter.getValueRef() == null) {
				error(prefix +"Missing the value", parameterValue);
			}
		} else {

			checkValueConformance(value, vType, prefix, parameter, parameterValue);
			checkInRange(value, type.getValidValues(), vType, prefix, parameter, parameterValue);
		}
	}

	/**
	 * @param value
	 * @param vType
	 * @param attribute
	 */
	protected void checkValueConformance(String value, VType vType, String prefix, final EObject obj, final EAttribute attribute) {
		checkValueConformance(prefix, value, attribute, vType, obj, ValidationMessageAcceptor.INSIGNIFICANT_INDEX);
	}
	protected void checkValueConformance(String prefix, String value, final EAttribute attribute, VType vType, final EObject obj, final int index) {
		if (value != null) {
			switch (vType) {
			case FLOAT:
				try {
					Float.parseFloat(value);
				} catch (NumberFormatException e) {
					error(prefix+ STR_EXPECTED_A_VALID + vType.getName()+": " + value, obj, attribute, index);
				}
				break;
			case INT32:
				try {
					Integer.decode(value);
				} catch (NumberFormatException e) {
					error(prefix+ STR_EXPECTED_A_VALID + vType.getName()+": " + value, obj, attribute, index);
				}
				break;
			case INT64:
				try {
					Long.decode(value);
				} catch (NumberFormatException e) {
					error(prefix+ STR_EXPECTED_A_VALID + vType.getName()+": " + value, obj, attribute, index);
				}
				break;
			case UINT32: {
					BigInteger decimal = null;
					try {
						if (value.startsWith("0x")) {
							decimal = new BigInteger(value.substring(2), 16);
						} else {
							decimal = new BigInteger(value);
						}
					} catch (NumberFormatException e) {
						error(prefix+ STR_EXPECTED_A_VALID + vType.getName()+": " + value, obj, attribute, index);
					}
					if (decimal != null) {
						if (IOilTypesHelper.MAX_INT.compareTo(decimal)==0) {
							warning("Assign -1 to an " + vType.getName()+" means assign the maximum value", obj, attribute, index);
						} else if (decimal.signum() == -1) {
							error(prefix+ STR_EXPECTED_A_POSITIVE_VALUE +": " + value, obj, attribute, index);
						} else {
							if (decimal.bitLength() > 32) {
								error(prefix+ STR_PROVIDED_VALUE_DOES_NOT_FIT + vType.getName()+" (" + value + ")", obj, attribute, index);
							}
						}
					}
				}
				break;
			case UINT64: {
					BigInteger decimal = null;
					try {
						if (value.startsWith("0x")) {
							decimal = new BigInteger(value.substring(2), 16);
						} else {
							decimal = new BigInteger(value);
						}
					} catch (NumberFormatException e) {
						error(prefix+ STR_EXPECTED_A_VALID + vType.getName()+": " + value, obj, attribute, index);
					}
					if (decimal != null) {
						if (IOilTypesHelper.MAX_INT.compareTo(decimal)==0) {
							warning(prefix+ "Assign -1 to an " + vType.getName()+" means assign the maximum value", obj, attribute, index);
						} else if (decimal.signum() == -1) {
							error(prefix+ STR_EXPECTED_A_POSITIVE_VALUE +": " + value, obj, attribute, index);
						} else {
							if (decimal.bitLength() > 64) {
								error(prefix+ STR_PROVIDED_VALUE_DOES_NOT_FIT + vType.getName()+" (" + value + ")", obj, attribute, index);
							}
						}
					}
				}
				break;
			case STRING:
				if (!(value.startsWith("\"") && value.endsWith("\""))) {
					error(prefix+ STR_EXPECTED_A_VALID + vType.getName()+": " + value, obj, attribute, index);
				}
				break;
	//					default:
				// undefined type
			};
		}
	}
	
	private void checkParameterReference(Parameter parameter, ReferenceType type) {

		final String prefix = parameter.getType().getName() + ": ";
		if (parameter.getValue() != null) {
			String value = parameter.getValue();
			if (value.startsWith("\"") && value.endsWith("\"")) {
				error(prefix + STR_EXPECTED_A_VALID + "reference, not a String (" + value+")", parameter, OilPackage.Literals.PARAMETER__VALUE, IValidationCodes.RemoveQuotesToReferce_parametervalue);
			} else {
				error(prefix + STR_EXPECTED_A_VALID + "reference, not a String or a number (" + value+")", OilPackage.Literals.PARAMETER__VALUE);
			}
		}

//		if (parameter.isStructured()) {
//			error("A reference cannot contain sub-elements", OilPackage.Literals.PARAMETER__STRUCTURED);
//		}
		
		if (parameter.getParameters().size()>0) {
			error(prefix + "A reference cannot contain sub-elements", OilPackage.Literals.PARAMETER__PARAMETERS);
		}
		
		ParameterRef gRefValue = parameter.getValueRef();
		ObjectType refType = type.getType();
		if (gRefValue == null) {
			error(prefix + STR_EXPECTED_A_VALID + "reference", OilPackage.Literals.PARAMETER__VALUE_REF);
		} else {
			if (gRefValue instanceof OilObject) {
				if ( ((OilObject) gRefValue).getType() != refType) {
					error(prefix + STR_EXPECTED_A_VALID + "reference to a " + refType.getName(), OilPackage.Literals.PARAMETER__VALUE_REF);
				}
			} else {
				error(prefix + STR_EXPECTED_A_VALID + "reference to a " + refType.getName(), OilPackage.Literals.PARAMETER__VALUE_REF);
			}
		}
		
	}	
	private void checkParameterVariant(Parameter parameter, VariantType type) {
		final EType refType = type.getType();

		final String prefix = parameter.getType().getName() + ": ";
		if (parameter.getValue() != null) {
			error(prefix + STR_EXPECTED_A_VALID + refType.getName() + "(" + parameter.getValue() + ")", OilPackage.Literals.PARAMETER__VALUE);
		}
			
		ParameterRef gRefValue = parameter.getValueRef();
		if (gRefValue == null) {
			error(prefix + STR_EXPECTED_A_VALID + refType.getName(), OilPackage.Literals.PARAMETER__VALUE_REF);
		} else {
			if (gRefValue instanceof EnumeratorType) {
				if (((EnumeratorType) gRefValue).eContainer() != type) {
					if (!(helper.getEnumeratorType(helper.computePath(parameter, false), helper.getOilImplementation(parameter)).contains(gRefValue))) {
						error(prefix + STR_EXPECTED_A_VALID + refType.getName(), OilPackage.Literals.PARAMETER__VALUE_REF);
					}
				}
			} else {
				error(prefix + STR_EXPECTED_A_VALID + refType.getName(), OilPackage.Literals.PARAMETER__VALUE_REF);
			}
		}
			
	}

	private void checkParameterUniqueness(List<OilObject> objects) {
		if (objects.size()>0) {
//			final OilTypesHelper helper = new OilTypesHelper();
			final List<OilImplementation> oilImplementation = helper.getOilImplementation(objects.get(0));
		
			List<String> path = helper.computePath(objects.get(0), false);
			Map<String, List<ParameterType>> types = asMap(helper.getParameterType(path, oilImplementation));
			
			Map<String, List<Parameter>> map = new HashMap<String, List<Parameter>>();
			for (OilObject obj : objects) {
				for (Parameter param : obj.getParameters()) {
					ParameterType ptype = param.getType();
					if (ptype != null) {
						addToMapList(map, param, ptype.getName());
					}
				}
			}
			
			checkParameterUniqueness(types, map);
				
			checkParameterUniquenessNextLevel(helper, oilImplementation, map);
		}
	}



	private void checkParameterUniquenessNextLevel(final IOilTypesHelper helper,
			final List<OilImplementation> oilImplementation, 
			Map<String, List<Parameter>> allParameters) {
		
		Map<String, List<Parameter>> _allParameters = allParameters;
		
		for (Map<String, List<Parameter>>  filteredParameters = filterVariantTypes(_allParameters);
				!filteredParameters.isEmpty(); filteredParameters = filterVariantTypes(_allParameters)) {
			_allParameters = new HashMap<String, List<Parameter>>();
			
			for (List<Parameter> list : filteredParameters.values()) {
				List<String> gpath = helper.computePath(list.get(0), true);
				Map<String, List<ParameterType>> gtypes = asMap(helper.getParameterType(gpath, oilImplementation));
				Map<String, List<Parameter>> gmap = new HashMap<String, List<Parameter>>();
					
				for (Parameter obj : list) {
					for (Parameter param : obj.getParameters()) {
						ParameterType ptype = param.getType();
						if (ptype != null) {
							addToMapList(gmap, param, ptype.getName());
						}
					}
				}
				checkParameterUniqueness(gtypes, gmap);
					
				_allParameters.putAll(gmap);
			}
		}
	}

	private Map<String, List<Parameter>> filterVariantTypes(Map<String, List<Parameter>> allParameters) {
		Map<String, List<Parameter>> answer = new HashMap<String, List<Parameter>>();
		
		int counter = 0;
		for (Entry<String, List<Parameter>> list : allParameters.entrySet()) {
			final String key = list.getKey();
			for (Parameter p: list.getValue()) {
				final ParameterRef ref = p.getValueRef();
				final ParameterType type = p.getType();
				if (type instanceof VariantType && ref != null && ref instanceof EnumeratorType) {
					final String multiValue; 
					if (type.isMultiValue()) {
						multiValue = "." + counter;
						counter++;
					} else {
						multiValue = "";
					}
					addToMapList(answer, p, key+"/"+ type.getName()
							+ multiValue
							+"/"+((EnumeratorType)ref).getName());
				}
			}
		}
		
		return answer;
	}


	private void checkParameterUniqueness(
			Map<String, List<ParameterType>> types,
			Map<String, List<Parameter>> map) {
		for (Entry<String, List<Parameter>> entry : map.entrySet()) {
			final List<Parameter> valueList = entry.getValue();
			if (valueList.size()>1 && types.containsKey(entry.getKey())) {
				final ParameterType parameterType = types.get(entry.getKey()).get(0);
				final boolean multiValue = parameterType.isMultiValue();
				if (parameterType instanceof VariantType){
					Map<String, List<Parameter>> enumTypes = new HashMap<String, List<Parameter>>();
//					for (Parameter p: valueList) {
//						final ParameterRef valueRef = p.getValueRef();
//						if (valueRef instanceof EnumeratorType) {
//							addToMapList(map, p, ((EnumeratorType) valueRef).getName());
//						}
//					}
					if (multiValue) {
//							for (List<Parameter> list: enumTypes.values()) {
//								if (list.size()>1) {
//									for (Parameter p: list) {
//										warning("Handled as distinct element (no merge done)", p, OilPackage.Literals.PARAMETER__VALUE_REF, ValidationMessageAcceptor.INSIGNIFICANT_INDEX);
//									}	
//								}
//							}
					} else {
						if (enumTypes.size()>1) {
							for (Parameter p: valueList) {
								error(p.getType().getName() + ": " + "Only one distinct value expected", p, OilPackage.Literals.PARAMETER__VALUE_REF, ValidationMessageAcceptor.INSIGNIFICANT_INDEX);
							}
						} else {
//								if (entry.getValue().size()>1) {
//									for (Parameter p: valueList) {
//										warning("Merged with other elements", p, OilPackage.Literals.PARAMETER__VALUE_REF, ValidationMessageAcceptor.INSIGNIFICANT_INDEX);
//									}
//								}
						}
					}
				} else {
					if (!multiValue) { 
						for (Parameter p: valueList) {
							error(p.getType().getName() + ": " + "Only one value expected", p, OilPackage.Literals.PARAMETER__TYPE, ValidationMessageAcceptor.INSIGNIFICANT_INDEX);
						}
					}
				}
			}
		}
	}
	
	private Map<ObjectType, Map<String, List<OilObject>>> groupOilObjects(OilFile file) {
		Map<ObjectType, Map<String, List<OilObject>>> answer = new HashMap<ObjectType, Map<String,List<OilObject>>>();
		if (file.getApplication() != null) {
			for (OilObject obj : file.getApplication().getOilObjects()) {
				addToMapList(getMapToMapList(answer, obj.getType()), obj, obj.getName());
			}
		}
		
		return answer;
	}



	
	private Map<String, List<ParameterType>> asMap(List<ParameterType> values) {
		Map<String, List<ParameterType>> map = new HashMap<String, List<ParameterType>>();
		for (ParameterType param: values) {
			final String objName = param.getName();

			addToMapList(map, param, objName);
		}
		
		return map;
	}



	private <T,S> void  addToMapList(Map<S, List<T>> map,
			T param, final S objName) {
		final List<T> list;
		if (map.containsKey(objName)) {
			list = map.get(objName);
		} else {
			list = new LinkedList<T>();
			map.put(objName, list);
		}
		list.add(param);
	}
	private Map<String, List<OilObject>> getMapToMapList(
			Map<ObjectType, Map<String, List<OilObject>>> answer,
			final ObjectType type) {
		final Map<String, List<OilObject>> map;
		if (answer.containsKey(type)) {
			map = answer.get(type);
		} else {
			map = new HashMap<String, List<OilObject>>();
			answer.put(type, map);
		}
		return map;
	}

}
