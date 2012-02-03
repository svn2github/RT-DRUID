package com.eu.evidence.rtdruid.internal.vartree.data.oil;

import org.eclipse.emf.ecore.EPackage;

import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OilImplFactory;
import com.eu.evidence.rtdruid.modules.oil.implementation.OilEcoreCreator;
import com.eu.evidence.rtdruid.modules.oil.interfaces.IOilImplID;
import com.eu.evidence.rtdruid.modules.oil.interfaces.IOilImplementation;
import com.eu.evidence.rtdruid.vartree.IEPackageProvider;
import com.eu.evidence.rtdruid.vartree.IVarTree;

public class OilEPackageLoader implements IEPackageProvider {
	
	static EPackage ePkg = null;
	

	public OilEPackageLoader() {
	}

	@Override
	public EPackage getEPackage(IVarTree vt) {
		if (ePkg == null) {
			OilImplFactory oif = OilImplFactory.getAnInstance(vt);
			oif.reloadDefault();
			IOilImplID[] ids = oif.getImplNames();
			for (IOilImplID id : ids) {
			
				IOilImplementation impl = oif.getImpl(id);
				
				OilEcoreCreator oec = OilEcoreCreator.getCreator(impl);
				ePkg = oec.buildPackage();
			}
		}
		
		
		return ePkg;
	}

	@Override
	public String getNS() {
		return null;
	}
}
