/**
 * 27/giu/2012
 */
package com.eu.evidence.rtdruid.oil.xtext.ui.hover;

import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.WeakHashMap;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.documentation.impl.MultiLineCommentDocumentationProvider;

import com.eu.evidence.rtdruid.oil.xtext.model.EnumeratorType;
import com.eu.evidence.rtdruid.oil.xtext.model.OilApplication;
import com.eu.evidence.rtdruid.oil.xtext.model.OilObject;
import com.eu.evidence.rtdruid.oil.xtext.model.OilObjectImpl;
import com.eu.evidence.rtdruid.oil.xtext.model.Parameter;
import com.eu.evidence.rtdruid.oil.xtext.model.ParameterType;
import com.eu.evidence.rtdruid.oil.xtext.model.Range;
import com.eu.evidence.rtdruid.oil.xtext.model.VType;
import com.eu.evidence.rtdruid.oil.xtext.model.ValidValues;
import com.eu.evidence.rtdruid.oil.xtext.model.ValueList;
import com.eu.evidence.rtdruid.oil.xtext.model.ValueType;
import com.eu.evidence.rtdruid.oil.xtext.model.VariantType;
import com.eu.evidence.rtdruid.oil.xtext.services.IOilTypesHelper;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class OilEObjectDocumentationProvider extends MultiLineCommentDocumentationProvider {
	
	private static IOilTypesHelper typeHelper = IOilTypesHelper.DefaulHelper;
	
	private static WeakHashMap<VariantType, String> enumeratorTypeMap = new WeakHashMap<VariantType, String>();
	
	private static class EnumeratorChanged extends AdapterImpl {
		
		private final WeakReference<VariantType> ref;
		
		public EnumeratorChanged(VariantType ref) {
			this.ref = new WeakReference<VariantType>(ref);
		}
		
		public void notifyChanged(Notification notification) {
			VariantType vt = ref.get();
			if (vt != null) {
				enumeratorTypeMap.remove(ref);
			}
			if (target != null) {
				target.eAdapters().remove(this);
				target = null;
			}
		}
	}

	@Override
	public String getDocumentation(EObject o) {
		String descr = null;
		String append = "";
		if (o instanceof OilObject) {
			descr = ((OilObject) o).getDescription();
			
		} else if (o instanceof Parameter) {
			descr = ((Parameter) o).getDescription();
			
		} else if (o instanceof OilApplication) {
			descr = ((OilApplication) o).getDescription();
			
		} else if (o instanceof ParameterType) {
			descr = ((ParameterType) o).getDescription();
			
			if (o instanceof VariantType) {
				append = computeEnumeratorTypes((VariantType) o);
			} else if (o instanceof ValueType) {
				ValidValues vv = ((ValueType)o).getValidValues();
				if (vv != null) {
					
					final VType vt = ((ValueType)o).getType();
					
					if (vv instanceof Range) {
						final Range r = (Range) vv;
						if (typeHelper.computeValue(r.getMin(), vt) != null &&
								typeHelper.computeValue(r.getMax(), vt) != null) {
							append = "Valid values are in the range <b>" + r.getMin() + "</b>..<b>" +  r.getMax() + "</b>";
						}
						
					} else if (vv instanceof ValueList) {
						Set<String> values = new TreeSet<String>();
						StringBuffer tmp = new StringBuffer("Valid values are: ");
						
						for (String v : ((ValueList) vv).getValues()) {
							if (typeHelper.computeValue(v, vt) != null) {
								values.add(v);
							}
						}
						
						if (values.size()>0) {
							String comma = "";
							for (String name: values) {
								tmp.append(comma);
								tmp.append("<b>");
								tmp.append(name);
								tmp.append("</b>");
								comma = ", ";
							}
							append = tmp.toString();
						}
					}
				}
			}
			
		} else if (o instanceof OilObjectImpl) {
			descr = ((OilObjectImpl) o).getDescription();
			
		} else if (o instanceof EnumeratorType) {
			descr = ((EnumeratorType) o).getDescription();
		}
		if (descr == null || descr.isEmpty()) {
			descr = super.getDocumentation(o);
		}
		StringBuffer answer = new StringBuffer();
		if (descr != null) {
			answer.append(descr);
		}
		if (append != null) {
			if (answer.length()>0) {
				answer.append("<br>");
			}
			answer.append(append);
		}
		return answer.toString();
	}

	
	private String computeEnumeratorTypes(VariantType type) {
		if (enumeratorTypeMap.containsKey(type)) {
			return enumeratorTypeMap.get(type);
		}
		
		StringBuffer answer = new  StringBuffer("Valid values are: ");

		Set<String> names = new TreeSet<String>();
		
		List<EnumeratorType> list = typeHelper.getEnumeratorType(typeHelper.computePath(type, false), typeHelper.getOilImplementation(type));
		
		for (EnumeratorType et : list) {
			String name = et.getName();
			if (name != null) {
				names.add(name);
			}
			et.eAdapters().add(new EnumeratorChanged(type));
		}
		
		String comma = "";
		for (String name: names) {
			answer.append(comma);
			answer.append("<b>");
			answer.append(name);
			answer.append("</b>");
			comma = ", ";
		}
		
		String answerStr = answer.toString();
		
		enumeratorTypeMap.put(type, answerStr);
		
		return answerStr;
	}
}
