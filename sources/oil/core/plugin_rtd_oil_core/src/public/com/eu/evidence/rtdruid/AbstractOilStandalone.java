package com.eu.evidence.rtdruid;

import com.eu.evidence.rtdruid.desk.IVarTreeRequiredFactories;
import com.eu.evidence.rtdruid.vartree.data.oil.OilApplItemProviderAdapterFactory;

abstract class AbstractOilStandalone extends AbstractStandalone {

	static {

		try {
			IVarTreeRequiredFactories v = getVarTreeRequiredFactories();
			
//			v.pReload();
//			v.pAddFactory(new AdapterFactoryLoaderImpl());
			v.pAddFactory(new OilApplItemProviderAdapterFactory());
		} catch (Throwable e) {
			System.exit(-1);
		}
	}
	
}
