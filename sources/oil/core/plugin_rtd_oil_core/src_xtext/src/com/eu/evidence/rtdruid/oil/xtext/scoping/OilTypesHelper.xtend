package com.eu.evidence.rtdruid.oil.xtext.scoping

import com.sun.istack.internal.NotNull
import com.sun.istack.internal.Nullable
import java.util.ArrayList
import java.util.Collections
import java.util.List
import org.apache.log4j.Logger
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import com.eu.evidence.rtdruid.oil.xtext.model.ParameterType
import com.eu.evidence.rtdruid.oil.xtext.model.OilImplementation
import com.eu.evidence.rtdruid.oil.xtext.model.EnumeratorType
import com.eu.evidence.rtdruid.oil.xtext.model.VariantType
import com.eu.evidence.rtdruid.oil.xtext.model.EType
import com.eu.evidence.rtdruid.oil.xtext.model.OilFactory
import com.eu.evidence.rtdruid.oil.xtext.model.OilObjectImpl
import com.eu.evidence.rtdruid.oil.xtext.model.Parameter
import com.eu.evidence.rtdruid.oil.xtext.model.OilObject
import com.eu.evidence.rtdruid.oil.xtext.model.OilFile
import com.eu.evidence.rtdruid.oil.xtext.model.ObjectType

class OilTypesHelper {
	
	Logger logger = Logger::getLogger(typeof(OilTypesHelper))

	def public List<ParameterType> getParameterType(List<String> path, @NotNull List<OilImplementation> roots) {
		var answer = new ArrayList<ParameterType>()
		answer.addAll(getElmentsType(path, roots).filter(typeof(ParameterType)))
		logger.debug("Parameters for path " + path + " = " + answer)
		answer
	}

	def public List<EnumeratorType> getEnumeratorType(List<String> path, @NotNull List<OilImplementation> roots) {
		var answer = new ArrayList<EnumeratorType>()
		answer.addAll(getElmentsType(path, roots).filter(typeof(EnumeratorType)))
		logger.debug("Parameters for path " + path + " = " + answer)
		answer
	}
	
	def protected List<? extends EObject> getElmentsType(List<String> path, @NotNull List<OilImplementation> roots) {
		if (path == null) return emptyList()
		var List<? extends EObject> values = new ArrayList<EObject>() 
		for (obj : roots) 
			(values as List).addAll(obj.oilObjects)
 		
		for (pElem : path) {
			
			var t = new ArrayList<EObject>()
			for (fElem : values.filter[
					switch (it) {
						OilObjectImpl : return it.type.name == pElem
						VariantType : return it.name == pElem
						EnumeratorType : return it.name == pElem
					}
					return false
				]) {
				
				
				t.addAll(
					switch (fElem) {
						OilObjectImpl : fElem.parameters
						VariantType : fElem.getEnumerators
						EnumeratorType : fElem.parameters
						default: Collections::EMPTY_LIST
					}
				) 
			}
			values = t
		}
		
		logger.debug("Object for path " + path + " = " + values)

		values
	}


	def private getEnumerators(VariantType fElem) {
		if (fElem.type == EType::BOOLEAN) {
			if (fElem.values.filter[EnumeratorType it | "TRUE".equalsIgnoreCase(it.name)].size == 0) {
				val trueType = OilFactory::eINSTANCE.createEnumeratorType()
				trueType.setName("TRUE")
				fElem.values.add(trueType)
			}
			if (fElem.values.filter[EnumeratorType it | "FALSE".equalsIgnoreCase(it.name)].size == 0) {
				val trueType = OilFactory::eINSTANCE.createEnumeratorType()
				trueType.setName("FALSE")
				fElem.values.add(trueType)
			}
		}
		
		fElem.values
	}


	/** Compute Path */
	def public List<String> computePath( EObject o, boolean addEnum) {
		if (o == null) { 
			return emptyList()
		}
		val List<String> answer = new ArrayList<String>()
		var obj = o
		var _addEnum = addEnum 
		do {
			obj = computePathElement(obj, _addEnum, answer)
			_addEnum = true
		} while ( obj != null)
		
		logger.debug("computed path " + o + " = " + answer)
		
		return answer
	 }


	/** Compute Path Element for Parameter */
	def dispatch EObject computePathElement(@NotNull Parameter it, boolean addEnum, @NotNull List<String> path) {
		if (addEnum) {
			var vref = it.valueRef
			if (vref != null && vref instanceof EnumeratorType) {
				path.add(0, (vref as EnumeratorType).name)
			} else {
				path.clear
				return null
			}
		}
		
		val ParameterType type = it.getType()
		if (type == null) {
			path.clear
			return null
		}
		path.add(0, type.name)
		
		it.eContainer
	}
	
	/** Compute Path Element for OilObject */
	def dispatch EObject computePathElement(@NotNull  OilObject it, boolean addEnum, @NotNull List<String> path) {
		val ObjectType type = it.getType()
		if (type == null) {
			path.clear
			return null
		}
		path.add(0, type.name)
		
		return null
	} 


	def public List<OilImplementation> getOilImplementation(@Nullable EObject o) {
		var answer = new ArrayList<OilImplementation>()
		
		for (obj: o?.eResource.contents){
			if (obj instanceof OilFile) 
				answer.add((obj as OilFile).implementation)
		}
		
		answer
	}
	
	def public List<OilObject> getMainObjects(@Nullable Resource res, ObjectType type) {
		if (res == null)
			return emptyList()
			
		var answer = new ArrayList<OilObject>()
		
		for (ofile: res?.contents){
			if (ofile instanceof OilFile) 
				for (obj: (ofile as OilFile).application.oilObjects)
					if (obj.type == type)
						answer.add(obj)
		}
		
		answer
	}

}
