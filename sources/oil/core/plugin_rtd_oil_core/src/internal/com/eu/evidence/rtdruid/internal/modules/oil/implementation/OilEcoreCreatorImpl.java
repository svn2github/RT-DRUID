package com.eu.evidence.rtdruid.internal.modules.oil.implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.modules.oil.implementation.IOilImplElementDescr;
import com.eu.evidence.rtdruid.modules.oil.implementation.IOilImplPointer;
import com.eu.evidence.rtdruid.modules.oil.implementation.IOilImplementation;
import com.eu.evidence.rtdruid.modules.oil.implementation.OilEcoreCreator;
import com.eu.evidence.rtdruid.modules.oil.implementation.OilPath;
import com.eu.evidence.rtdruid.modules.oil.keywords.IOilXMLLabels;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;

public class OilEcoreCreatorImpl extends OilEcoreCreator {

	/**
	 * If set to true, the code uses EMF references to store Oil references,
	 * otherwise it saves the reference as string
	 */
	public static final boolean REFERENCE_AS_EMF_REF = false;
	
	/*
	 * Instantiate EcoreFactory
	 */
	private static final EcoreFactory eCoreFactory = EcoreFactory.eINSTANCE;

	
	private HashMap<String, EClassifier> EMF_TYPES = null;
	private final IOilImplementation iimpl;
	
	
	private static class PendingRefs {
		final EReference ref;
		final String type;
		
		PendingRefs(EReference ref, String type) {
			this.ref = ref;
			this.type = type;
		}
	}
	
	private ArrayList<PendingRefs> pendingReferences = new ArrayList<OilEcoreCreatorImpl.PendingRefs>();
	
	private EPackage ePackage;
	private List<EPackage> allRelatedEPackages = new ArrayList<EPackage>();
	
	
	public OilEcoreCreatorImpl(IOilImplementation iimpl) {
		this.iimpl = iimpl;
	}
	
	/**
	 * Creates a new EPackage based on the provided oil implementation
	 * 
	 * @param impl
	 *            the oil implementation
	 * @return a new EPackage
	 */
	@Override
	public EPackage buildPackage() {
		
		if (ePackage == null) {
			
			/*
			 * Instantiate EPackage and provide unique URI to identify this package
			 */
			ePackage = eCoreFactory.createEPackage();
			allRelatedEPackages.add(ePackage);
			
			IOilImplPointer oip = iimpl.getPointer();
			
			//header
			String impl_name = iimpl.getId().getImplementationName();
			ePackage.setName(impl_name);
			ePackage.setNsPrefix(impl_name);
			ePackage
					.setNsURI("http:///com.eu.evidence.rtdruid.oil.autoecore."+impl_name+".ecore");
	
			
			// write all elements
			for (boolean go = oip.goFirstChild(); go; go=oip.goNextSibling()) {
				writeImplementation(ePackage, null, (IOilImplPointer) oip.clone(), new ArrayList<String>());
			}
			
			setPendingRefTypes();
		}

		return ePackage;
	}
	
	
	

	/**
	 * Write a piece of the implementation section
	 * 
	 * @param buffer the output (Oil)
	 * @param indent contains some white spaces to indent the output
	 * 
	 * @param id identifies the Implementation
	 * */
	@SuppressWarnings("unchecked")
	protected void writeImplementation(EPackage ePackage, EClass parent_class, IOilImplPointer oip, ArrayList<String> path) {
		path = (ArrayList<String>) path.clone();
		
		IOilImplElementDescr cd = oip.getCurrentDescr();

		boolean checkChildren = false;
		EClass current_eclass = null;
		
		switch (cd.getType()) {
			case IOilImplPointer.FIRST_LEVEL : {
				String type = cd.getAttributes().getProperty(IOilXMLLabels.ATTR_OBJ_TYPE);
				current_eclass = eCoreFactory.createEClass();
				path.add(type);
				current_eclass.setName(OilPath.compute_full_name(path));
				
				addAnnotation(ANNOTATION_OIL_1L_OBJ_TYPE, type, current_eclass);

				
				{
					EAttribute eattr_type = eCoreFactory.createEAttribute();
					eattr_type.setName("name");
					eattr_type.setEType(computeEType("STRING"));
					eattr_type.setChangeable(true);
					eattr_type.setLowerBound(1);
					eattr_type.setUpperBound(1);
					current_eclass.getEStructuralFeatures().add(eattr_type);
				}
				{
					EAttribute eattr_type = eCoreFactory.createEAttribute();
					eattr_type.setName("main_obj_id");
					eattr_type.setEType(computeEType("STRING"));
					eattr_type.setChangeable(true);
					eattr_type.setID(true);
					eattr_type.setLowerBound(1);
					eattr_type.setUpperBound(1);
					current_eclass.getEStructuralFeatures().add(eattr_type);
				}

				
				ePackage.getEClassifiers().add(current_eclass);
				checkChildren = true;
				
				
				
				EClass rtdEClass = getRtdEClass(type);
				if (rtdEClass != null) {
					String refName = getRtdEClassExtPoint(type);

					if (rtdEClass.getEStructuralFeature(refName) == null) {
						EReference eattr_type = eCoreFactory.createEReference();
						eattr_type.setName(refName);
						eattr_type.setEType(current_eclass);
						eattr_type.setChangeable(true);
						eattr_type.setLowerBound(1);
						eattr_type.setUpperBound(ETypedElement.UNBOUNDED_MULTIPLICITY);
						eattr_type.setContainment(true);
						rtdEClass.getEStructuralFeatures().add(eattr_type);
					} else {
						RtdruidLog.showDebug("Found the same reference more than once. Oil obj type = " + type);
					}
				}
				
				
			}
				break;
			case IOilImplPointer.ATTRIBUTE : {
				checkChildren = false;
				
				// from attributes
				String type = cd.getAttributes().getProperty(IOilXMLLabels.ATTR_TYPE);
				String name = cd.getAttributes().getProperty(IOilXMLLabels.ATTR_NAME);
				boolean auto = (cd.getAttributes().containsKey(IOilXMLLabels.ATTR_WITH_AUTO)
						&& "true".equalsIgnoreCase(cd.getAttributes().getProperty(IOilXMLLabels.ATTR_WITH_AUTO)));
				boolean multiple = (cd.getAttributes().containsKey(IOilXMLLabels.ATTR_MULTIPLE_VALUES)
						&& "true".equalsIgnoreCase(cd.getAttributes().getProperty(IOilXMLLabels.ATTR_MULTIPLE_VALUES)));

				boolean default_auto = (cd.getAttributes().containsKey(IOilXMLLabels.ATTR_AUTO)
						&& "true".equalsIgnoreCase(cd.getAttributes().getProperty(IOilXMLLabels.ATTR_AUTO)));
				String default_value =  default_auto ? null : null; //"AUTO":"";
				default_value = (cd.getAttributes().containsKey(IOilXMLLabels.ATTR_DEFAULT_VALUE)) 
						? cd.getAttributes().getProperty(IOilXMLLabels.ATTR_DEFAULT_VALUE) : default_value;
					
				// search range / value inside the children
				String values_key = null;
				StringBuffer values = new StringBuffer();
				{
					String range[] = null;
					ArrayList<String> value = new ArrayList<String>();
					IOilImplElementDescr cds[] = oip.getChildrenDescr();
					
					for (int i=0; i<cds.length; i++) {
						
						if (cds[i].getType() == IOilImplPointer.VALUE && cds[i].getAttributes().containsKey(IOilXMLLabels.ATTR_VALUE)) {
							value.add(cds[i].getAttributes().getProperty(IOilXMLLabels.ATTR_VALUE));
	
						} else if (cds[i].getType() == IOilImplPointer.RANGE) {
							range = new String[2];
							range[0] = cds[i].getAttributes().getProperty(IOilXMLLabels.ATTR_MIN);
							range[1] = cds[i].getAttributes().getProperty(IOilXMLLabels.ATTR_MAX);
						}
					}
					if (range != null) {
						values_key = "RANGE";
						values.append(range[0] + "\n" + range[1]);
						
					} else if (value.size() != 0) {
						values_key = "VALUE_LIST";
						for (int i=0; i<value.size(); i++) {
							values.append((i>0?"\n":"") + ((String) value.get(i)));
						}
					} // else {//nothing}
				}
				
				
				EAttribute attribute = eCoreFactory.createEAttribute();
				attribute.setName(name);
				attribute.setEType(computeEType(type));
				attribute.setDefaultValueLiteral(default_value);
				attribute.setLowerBound(0); // probably it should be 0 only if WITH_AUTO is true
				attribute.setUpperBound(multiple ? ETypedElement.UNBOUNDED_MULTIPLICITY : 1);
				
				addAnnotation("WITH_AUTO", "" + auto, attribute);
				addAnnotation("AUTO", "" + default_auto, attribute);
				if (values_key != null) {
					addAnnotation(values_key, values.toString(), attribute);
				}
				if (default_value != null && default_value.length()>0) {
					addAnnotation("DEFAULT_VALUE", default_value, attribute);
				}
				addAnnotation(ANNOTATION_OIL_ATTR, "true", attribute);


				parent_class.getEStructuralFeatures().add(attribute);
			}
				break;
			case IOilImplPointer.REFERENCE : {
				checkChildren = false;
				
				// from attributes
				String type = cd.getAttributes().getProperty(IOilXMLLabels.ATTR_OBJ_REF_TYPE);
				String name = cd.getAttributes().getProperty(IOilXMLLabels.ATTR_NAME);
				boolean multiple = (cd.getAttributes().containsKey(IOilXMLLabels.ATTR_MULTIPLE_VALUES)
						&& "true".equalsIgnoreCase(cd.getAttributes().getProperty(IOilXMLLabels.ATTR_MULTIPLE_VALUES)));
				
				if (REFERENCE_AS_EMF_REF) {
					EReference ref = eCoreFactory.createEReference();
					ref.setName(name);
					setRefType(ref, ePackage, type);
					ref.setLowerBound(0);
					ref.setUpperBound(multiple ? ETypedElement.UNBOUNDED_MULTIPLICITY : 1);
					ref.setContainment(false);
					addAnnotation(ANNOTATION_OIL_REF, "true", ref);
					
					// use ID as key?

					parent_class.getEStructuralFeatures().add(ref);
					
				} else {
					
					EAttribute attr_ref = eCoreFactory.createEAttribute();
					attr_ref.setName(name);
					attr_ref.setEType(computeEType("STRING"));
					attr_ref.setChangeable(true);
					attr_ref.setLowerBound(0);
					attr_ref.setUpperBound(multiple ? ETypedElement.UNBOUNDED_MULTIPLICITY : 1);

					addAnnotation("TYPE", type, attr_ref);
					addAnnotation(ANNOTATION_OIL_REF, "true", attr_ref);

					parent_class.getEStructuralFeatures().add(attr_ref);
				}

			}

				break;
			case IOilImplPointer.VARIANT : {
				checkChildren = true;

				// from attributes
				String type = cd.getAttributes().getProperty(IOilXMLLabels.ATTR_TYPE);
				String name = cd.getAttributes().getProperty(IOilXMLLabels.ATTR_NAME);
				boolean auto = (cd.getAttributes().containsKey(IOilXMLLabels.ATTR_AUTO)
						&& "true".equalsIgnoreCase(cd.getAttributes().getProperty(IOilXMLLabels.ATTR_AUTO)));
				boolean multiple = (cd.getAttributes().containsKey(IOilXMLLabels.ATTR_MULTIPLE_VALUES)
						&& "true".equalsIgnoreCase(cd.getAttributes().getProperty(IOilXMLLabels.ATTR_MULTIPLE_VALUES)));
				String default_value = (cd.getAttributes().containsKey(IOilXMLLabels.ATTR_DEFAULT_VALUE)) 
						? cd.getAttributes().getProperty(IOilXMLLabels.ATTR_DEFAULT_VALUE) : "";
							
				current_eclass = eCoreFactory.createEClass();
				path.add(name);
				current_eclass.setName(OilPath.compute_full_name(path));
				current_eclass.setAbstract(true);
				
				{
					addAnnotation(ANNOTATION_VARIANT_TYPE, "" + type, current_eclass);
//					EAttribute eattr_type = eCoreFactory.createEAttribute();
//					eattr_type.setName("variant_type");
//					eattr_type.setEType(computeEType("STRING"));
//					eattr_type.setDefaultValue(type);
//					eattr_type.setChangeable(false);
//					eattr_type.setLowerBound(1);
//					eattr_type.setUpperBound(1);
//					current_eclass.getEStructuralFeatures().add(eattr_type);
				}
				if (multiple) {
					EAttribute eattr_type = eCoreFactory.createEAttribute();
					eattr_type.setName("variant_id");
					eattr_type.setID(true);
					eattr_type.setEType(computeEType("STRING"));
					eattr_type.setChangeable(true);
					eattr_type.setLowerBound(0);
					eattr_type.setUpperBound(1);
					current_eclass.getEStructuralFeatures().add(eattr_type);
				}
				
				{ // containment reference
					
					EReference ref = eCoreFactory.createEReference();
					ref.setName(name);
					setRefType(ref, ePackage, OilPath.compute_full_name(path));
					ref.setLowerBound(0);
					ref.setUpperBound(multiple ? ETypedElement.UNBOUNDED_MULTIPLICITY : 1);
					ref.setContainment(true);

					addAnnotation("AUTO", "" + auto, ref);
					if (default_value != null && default_value.length()>0) {
						addAnnotation("DEFAULT_VALUE", "" + default_value, ref);
					}

					parent_class.getEStructuralFeatures().add(ref);
				}
				ePackage.getEClassifiers().add(current_eclass);
				
			}
				break;
			case IOilImplPointer.ENUMERATOR : {
				checkChildren = true;

				// from attributes
				String name = cd.getAttributes().getProperty(IOilXMLLabels.ATTR_NAME);
				
				current_eclass = eCoreFactory.createEClass();
				path.add(name);
				current_eclass.setName(OilPath.compute_full_name(path));
				current_eclass.setAbstract(false);
				current_eclass.getESuperTypes().add(parent_class);
				
				{
					addAnnotation(ANNOTATION_ENUM_TYPE, "" + name, current_eclass);
//					EAttribute eattr_type = eCoreFactory.createEAttribute();
//					eattr_type.setName("type");
//					eattr_type.setEType(computeEType("STRING"));
//					eattr_type.setDefaultValue(name);
//					eattr_type.setChangeable(false);
//					eattr_type.setLowerBound(1);
//					eattr_type.setUpperBound(1);
//					current_eclass.getEStructuralFeatures().add(eattr_type);
				}
				
				
				ePackage.getEClassifiers().add(current_eclass);
			}
				break;
			// ------------ UNUSED ------------------
			case IOilImplPointer.DESCRIPTION :
			case IOilImplPointer.VALUE :
			case IOilImplPointer.RANGE :
			case IOilImplPointer.CDATA :
			case IOilImplPointer.UNKNOW :
			default:
				// should not run this row
				RtdruidLog.showDebug("Check " + getClass().getName() +" for unused " + IOilImplPointer.class.getName() + " types ("+cd.getType()+")");
				//break;
				
		}
		
		// ------------- children -------------
		for (boolean go = oip.goFirstChild(); go; go=oip.goNextSibling()) {
			if (oip.getCurrentDescr().getType() == IOilImplPointer.DESCRIPTION) {
//				IOilImplPointer tmpoip = (IOilImplPointer) oip.clone();
//				boolean ok = tmpoip.goFirstChild();
//				IOilImplElementDescr tcd = tmpoip.getCurrentDescr();
//				ok &= tcd.getType() == IOilImplPointer.CDATA;
//				ok &= tcd.getAttributes().containsKey(IOilXMLLabels.ATTR_VALUE);
//				if (ok) {
//					description = (description.length() == 0 ? " : " : ". " )
//						+ tcd.getAttributes().getProperty(IOilXMLLabels.ATTR_VALUE);
//				}
//				
			} else if (checkChildren) {
				writeImplementation(ePackage, current_eclass, (IOilImplPointer) oip.clone(), path);
			}
		}
	}

	
	private HashMap<String, EClass> rtdEClass = new HashMap<String, EClass>();
	
	private EClass getRtdEClass(String type) {
		EClass answer = null;
		if (rtdEClass.containsKey(type)) {
			answer = rtdEClass.get(type);
		} else {
			answer = eCoreFactory.createEClass();
			if (IOilXMLLabels.OBJ_TASK.equalsIgnoreCase(type)) {
				answer.setName("Task");
			} else if (IOilXMLLabels.OBJ_ISR.equalsIgnoreCase(type)) {
				answer.setName("Task");
			} else if (IOilXMLLabels.OBJ_OS.equalsIgnoreCase(type)) {
				answer.setName("Rtos");
			} else if (IOilXMLLabels.OBJ_OSAPPLICATION.equalsIgnoreCase(type)) {
				answer.setName("OsApplication");
			} else if (IOilXMLLabels.OBJ_RESOURCE.equalsIgnoreCase(type)) {
				answer.setName("Mutex");
			} else if (IOilXMLLabels.OBJ_ALARM.equalsIgnoreCase(type) ||
					IOilXMLLabels.OBJ_COUNTER.equalsIgnoreCase(type) ||
					IOilXMLLabels.OBJ_EVENT.equalsIgnoreCase(type)) {
				answer.setName("Signal");
			} else if (IOilXMLLabels.OBJ_APPMODE.equalsIgnoreCase(type)) {
				answer.setName("Mode");
			} else if (IOilXMLLabels.OBJ_MESSAGE.equalsIgnoreCase(type) ||
					IOilXMLLabels.OBJ_NETWORKMESSAGE.equalsIgnoreCase(type)) {
				answer.setName("Frame");
			} else if (IOilXMLLabels.OBJ_COM.equalsIgnoreCase(type)) {
				answer.setName("Com");
			} else if (IOilXMLLabels.OBJ_SPINLOCK.equalsIgnoreCase(type)) {
				answer.setName("SpinLock");
			} else if (IOilXMLLabels.OBJ_SCHEDULETABLE.equalsIgnoreCase(type)) {
				answer.setName("ScheduleTable");
			} else {
				answer.setName("Rtos");
//				answer = null;
//				RtdruidLog.showDebug(/*new IllegalArgumentException*/("Unsupported rtd class " + type));
			}
			
			/*if (answer != null) */{
				EClassifier tmp = ePackage.getEClassifier(answer.getName());
				if (tmp != null) {
					answer = (EClass) tmp;
				} else {
					ePackage.getEClassifiers().add(answer);
				}
				rtdEClass.put(type, answer);
			}
			
		}
		return answer;
	}

	private void setRefType(EReference ref, EPackage ePackage, String type) {
		EClassifier ec = null;
		for (EPackage e: allRelatedEPackages) {
			ec = e.getEClassifier(type);
			if (ec != null) break;
		}
		if (ec != null) {
			ref.setEType(ec);
		} else {
			// ... store missing references and retry later
			pendingReferences.add(new PendingRefs(ref, type));
		}
	}


	private void setPendingRefTypes() {
		
		for (PendingRefs pendingRef: pendingReferences) {

			EClassifier ec = null;
			for (EPackage e: allRelatedEPackages) {
				ec = e.getEClassifier(pendingRef.type);
				if (ec != null) break;
			}
			if (ec != null) {
				pendingRef.ref.setEType(ec);
			} else {
				if (pendingRef.type.endsWith("_TYPE")) {
					String new_type = "OIL"+pendingRef.type.substring(0, pendingRef.type.length() - "_TYPE".length());
//					if (new_type.length()>1) {
//						new_type = Character.toUpperCase(new_type.charAt(0)) + new_type.substring(1).toLowerCase();
//					}
					
//					RtdruidLog.showDebug("Trying "+new_type + " instead of " + pendingRef.type+ "\n");

					for (EPackage e: allRelatedEPackages) {
						ec = e.getEClassifier(new_type);
						if (ec != null) break;
					}
				}
				if (ec != null) {
					pendingRef.ref.setEType(ec);
				} else {
//					RtdruidLog.showDebug("Cannot find required reference : " + pendingRef.type+ "\n");
				}
			}

		}
	}
	
	
	
	
	/* This method may be moved on a public utility function */
	private EClassifier computeEType(String type) {
		if (EMF_TYPES == null) {
			EMF_TYPES = new HashMap<String, EClassifier>();
			
			addType(DataPackage.Literals.INTEGER_VAR, "UINT32", "INT32");
			addType(DataPackage.Literals.LONG_VAR, "UINT64", "INT64");
			addType(DataPackage.Literals.FLOAT_VAR, "FLOAT");
			addType(DataPackage.Literals.DOUBLE_VAR, "DOUBLE");
			addType(DataPackage.Literals.STRING_VAR, "STRING");

//			addType(EcorePackage.Literals.EINT, "UINT32", "INT32");
//			addType(EcorePackage.Literals.ELONG, "UINT64", "INT64");
//			addType(EcorePackage.Literals.EFLOAT, "FLOAT");
//			addType(EcorePackage.Literals.EDOUBLE, "DOUBLE");
//			addType(EcorePackage.Literals.ESTRING, "STRING");
		}
		return EMF_TYPES.get(type);
	}
	
	private void addType(EDataType type, String ... ids) {
		type = EcoreUtil.copy(type);
		ePackage.getEClassifiers().add(type);
		for (String id : ids) {
			EMF_TYPES.put(id, type);
		}
	}
	
	
	/* This method should be moved on a public utility function */
	private static void addAnnotation(String key, String value, EModelElement obj) {
		
		EAnnotation annotation = obj.getEAnnotation(RTDRUID_ANNOTATIONS_SOURCE);
		if (annotation == null) {
			annotation = eCoreFactory.createEAnnotation();
			annotation.setSource(RTDRUID_ANNOTATIONS_SOURCE);
			obj.getEAnnotations().add(annotation);
		}
		
		annotation.getDetails().put(key, value);
	}
}
