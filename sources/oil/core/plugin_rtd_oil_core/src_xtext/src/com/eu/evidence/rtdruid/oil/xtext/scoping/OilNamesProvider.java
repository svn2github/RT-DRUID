package com.eu.evidence.rtdruid.oil.xtext.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.util.SimpleAttributeResolver;

import com.google.inject.Inject;

public class OilNamesProvider extends IQualifiedNameProvider.AbstractImpl  {
	public static SimpleAttributeResolver<EObject, String> resolver = SimpleAttributeResolver.newResolver(String.class, "name");
	
	
	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;
	
	@Override
	public QualifiedName getFullyQualifiedName(EObject obj) {
		String name = resolver.apply(obj);
		if (name == null) {
			return null;
		}
		
		return qualifiedNameConverter.toQualifiedName(name);
	}
}
