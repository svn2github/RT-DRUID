package com.eu.evidence.rtdruid.desk;

import org.eclipse.emf.common.notify.AdapterFactory;

import com.eu.evidence.rtdruid.vartree.AdapterFactoryLoader;

public interface IVarTreeRequiredFactories {

	/*
	 * public interface
	 */
	public abstract void pAddFactory(AdapterFactoryLoader factories);

	public abstract void pAddFactory(AdapterFactory factories);

	public abstract void pReload();

}