package com.eu.evidence.rtdruid.internal.modules.oil.implementation;

import org.eclipse.emf.common.notify.AdapterFactory;

import com.eu.evidence.rtdruid.vartree.AdapterFactoryLoader;

public class OilECoreFactoryLoader extends AdapterFactoryLoader {

	public OilECoreFactoryLoader() {
	}

	@Override
	public Class<AdapterFactory>[] getFactoryies() {
		
//		IVarTree vt = VarTreeUtil.newVarTree();;
//		
//		OilImplFactory oif = OilImplFactory.getAnInstance(vt);
//		oif.reloadDefault();
//		IOilImplID[] ids = oif.getImplNames();
//		EPackage ePkg = null;
//		for (IOilImplID id : ids) {
//		
//			System.out.println("Building " + id.getImplementationName());
//			IOilImplementation impl = oif.getImpl(id);
//			
//			
//			OilEcoreCreator oec = OilEcoreCreator.getCreator(impl);
//			ePkg = oec.buildPackage();
//			break;
//		}
//		if (ePkg != null) {
////			return ePkg.getEFactoryInstance();
//		}

		// TODO Auto-generated method stub
		return new Class[0];
	}

}
