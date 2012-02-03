package com.eu.evidence.rtdruid.vartree;

import org.eclipse.emf.ecore.EPackage;

public interface IEPackageProvider {
	
	String getNS();
	
	EPackage getEPackage(IVarTree vt);

}
