package com.eu.evidence.rtdruid.modules.oil.implementation;

import org.eclipse.emf.ecore.EPackage;

import com.eu.evidence.rtdruid.internal.modules.oil.implementation.OilEcoreCreatorImpl;

/**
*
* @author Nicola Serreli
* @since 2.0
*
*/
public abstract class OilEcoreCreator {

	protected OilEcoreCreator() {
		super();
	}

	public static OilEcoreCreator getCreator(IOilImplementation iimpl) {
		return new OilEcoreCreatorImpl(iimpl);
	}

	public abstract EPackage buildPackage();
}