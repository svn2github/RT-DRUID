package com.eu.evidence.rtdruid.oil.xtext.scoping

import com.eu.evidence.rtdruid.oil.xtext.model.ObjectType
import com.eu.evidence.rtdruid.oil.xtext.model.OilObject
import com.eu.evidence.rtdruid.oil.xtext.model.Parameter
import com.eu.evidence.rtdruid.oil.xtext.model.ReferenceType
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.Scopes
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider
import com.eu.evidence.rtdruid.oil.xtext.services.IOilTypesHelper

class OilScopeProvider extends AbstractDeclarativeScopeProvider {
	
	extension IOilTypesHelper = IOilTypesHelper::DefaulHelper
	private static boolean enableLogger = false
	
	def IScope getOilScope(List<? extends EObject> elements) {
		Scopes::scopeFor(elements, QualifiedName::wrapper(OilNamesProvider::resolver), IScope::NULLSCOPE)
	}
	
	def IScope scope_OilObject_Parameters(OilObject prop, EReference ref){
		if (enableLogger) logger.debug("Scope OP " + prop + " -> " + ref)
		getOilScope(getParameterType(computePath(prop, false), getOilImplementation(prop)))
	}

	def IScope scope_Parameter_Type(Parameter prop, EReference ref){
		val boolean requireEnum = prop.eContainer instanceof Parameter// false; //prop.type instanceof VariantType && prop.valueRef != null
		if (enableLogger) logger.debug("Scope PT " + prop +  " -> " + ref) //"("+prop.type?.name+" - " + requireEnum+")" +
		
		getOilScope(getParameterType(computePath(prop.eContainer, requireEnum), getOilImplementation(prop)))
	}
	
	def IScope scope_Parameter_ValueRef(Parameter prop, EReference ref){
		if (enableLogger) logger.debug("Scope PV " + prop + " -> " + ref)
		
		if (prop.type instanceof ReferenceType) {
			if ((prop.type as ReferenceType).type == ObjectType::APPMODE) {
				addDefaultAppMode(prop.eResource)
			} else if ((prop.type as ReferenceType).type == ObjectType::RESOURCE) {
				addResScheduler(prop.eResource)
			}
	
			getOilScope(getMainObjects(prop.eResource, (prop.type as ReferenceType).type))
			
		} else {
		
			getOilScope(getEnumeratorType(computePath(prop, false), getOilImplementation(prop)))
		}
	}
	
	def IScope scope_Parameter_Parameters(Parameter prop, EReference ref){
		if (enableLogger) logger.debug("Scope PP " + prop + "(" +prop.valueRef+ ") -> " + ref)
		getOilScope(getParameterType(computePath(prop, true), getOilImplementation(prop)))
	}
}
