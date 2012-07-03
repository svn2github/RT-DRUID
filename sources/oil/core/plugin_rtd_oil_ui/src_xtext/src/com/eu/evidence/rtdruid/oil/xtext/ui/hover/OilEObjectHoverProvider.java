/**
 * 27/giu/2012
 */
package com.eu.evidence.rtdruid.oil.xtext.ui.hover;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider;

import com.eu.evidence.rtdruid.oil.xtext.model.EnumeratorType;
import com.eu.evidence.rtdruid.oil.xtext.model.OilApplication;
import com.eu.evidence.rtdruid.oil.xtext.model.OilObject;
import com.eu.evidence.rtdruid.oil.xtext.model.OilObjectImpl;
import com.eu.evidence.rtdruid.oil.xtext.model.Parameter;
import com.eu.evidence.rtdruid.oil.xtext.model.ParameterType;
import com.eu.evidence.rtdruid.oil.xtext.model.ReferenceType;
import com.eu.evidence.rtdruid.oil.xtext.model.ValueType;
import com.eu.evidence.rtdruid.oil.xtext.model.VariantType;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class OilEObjectHoverProvider  extends DefaultEObjectHoverProvider {

	@Override
	protected String getFirstLine(EObject o) {
		
		if (o instanceof OilObjectImpl) {
			return ((OilObjectImpl) o).getType().getName();

		} else if (o instanceof ParameterType) {
			return _getFirstLine((ParameterType) o);

		} else if (o instanceof EnumeratorType) {
			return "Option <b>" + ((EnumeratorType) o).getName()+"</b>";

		} else if (o instanceof OilObject) {
			OilObject obj = ((OilObject) o);
			return obj.getType().getName() + " <b>" + obj.getName()+"</b>";

		} else if (o instanceof Parameter) {
			Parameter obj = ((Parameter) o);
			return _getFirstLine(obj.getType());
			
		} else if (o instanceof OilApplication) {
			OilApplication obj = ((OilApplication) o);
			return "Oil Application section (" +obj.getName()+ ")";
			
		}
		
		return super.getFirstLine(o);
	}
	
	protected String _getFirstLine(ParameterType type) {
		if (type instanceof ValueType) {
			ValueType obj = ((ValueType) type);
			return obj.getType().getName() + " <b>" + obj.getName()+"</b>";
			
		} else if (type instanceof VariantType) {
			VariantType obj = ((VariantType) type);
			return obj.getType().getName() + " <b>" + obj.getName()+"</b>";
			
		} else if (type instanceof ReferenceType) {
			ReferenceType obj = ((ReferenceType) type);
			return obj.getType().getName() + " reference <b>" + obj.getName()+"</b>";			
		}
		return "";
	}

}