/**
 * 04/lug/2012
 */
package com.eu.evidence.rtdruid.oil.xtext.scoping;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;

import com.eu.evidence.rtdruid.oil.xtext.model.ObjectType;
import com.eu.evidence.rtdruid.oil.xtext.model.OilObject;
import com.eu.evidence.rtdruid.oil.xtext.model.Parameter;
import com.eu.evidence.rtdruid.oil.xtext.model.ParameterType;
import com.eu.evidence.rtdruid.oil.xtext.model.ReferenceType;
import com.eu.evidence.rtdruid.oil.xtext.services.IOilTypesHelper;

/**
 * 
 * @author Nicola Serreli
 * @since 2.0
 * 
 */
public class OilScopeProvider extends AbstractDeclarativeScopeProvider {
	private IOilTypesHelper helper = IOilTypesHelper.DefaulHelper;

	private static boolean enableLogger = false;

	public IScope getOilScope(final List<? extends EObject> elements) {
		return Scopes.scopeFor(elements, QualifiedName.<EObject> wrapper(OilNamesProvider.resolver), IScope.NULLSCOPE);
	}

	public IScope scope_OilObject_Parameters(final OilObject prop, final EReference ref) {
		if (enableLogger) {
			logger.debug("Scope OP " + prop + " -> " + ref);
		}
		return getOilScope(helper.getParameterType(helper.computePath(prop, false), helper.getOilImplementation(prop)));
	}

	public IScope scope_Parameter_Type(final Parameter prop, final EReference ref) {
		if (enableLogger) {
			this.logger.debug("Scope PT " + prop + " -> " + ref);
		}
		EObject _eContainer = prop.eContainer();
		final boolean requireEnum = (_eContainer instanceof Parameter);
		return getOilScope(helper.getParameterType(helper.computePath(_eContainer, requireEnum), helper.getOilImplementation(prop)));
	}



	public IScope scope_Parameter_ValueRef(final Parameter prop, final EReference ref) {
		if (enableLogger) {
			logger.debug("Scope PV " + prop + " -> " + ref);
		}
		IScope answer = null;
		ParameterType _type = prop.getType();
		if ((_type instanceof ReferenceType)) {

			ObjectType objType = ((ReferenceType) _type).getType();

			if (objType == ObjectType.APPMODE) {
				helper.addDefaultAppMode(prop.eResource());

			} else if (objType == ObjectType.RESOURCE) {
				helper.addResScheduler(prop.eResource());
			}

			answer = getOilScope(helper.getMainObjects(prop.eResource(), objType));
		} else {

			answer = getOilScope(helper.getEnumeratorType(helper.computePath(prop, false), helper.getOilImplementation(prop)));
		}
		return (answer);
	}

	public IScope scope_Parameter_Parameters(final Parameter prop, final EReference ref) {
		if (enableLogger) {
			logger.debug("Scope PP " + prop + "(" + prop.getValueRef() + ") -> " + ref);
		}
		return getOilScope(helper.getParameterType(helper.computePath(prop, true), helper.getOilImplementation(prop)));
	}
}
