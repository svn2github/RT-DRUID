package com.eu.evidence.rtdruid;

import com.eu.evidence.rtdruid.desk.CommonPaths;
import com.eu.evidence.rtdruid.desk.IVarTreeRequiredFactories;
import com.eu.evidence.rtdruid.desk.RTDFactory;
import com.eu.evidence.rtdruid.vartree.data.init.AdapterFactoryLoaderImpl;

public abstract class AbstractStandalone {
	
	protected final static String EVI_BASE_KEY = "EVIDENCEBASE";

	static {

		try {
			
			// init plugins and DataStructures
//			new Rtd_corePlugin();

			IVarTreeRequiredFactories v = getVarTreeRequiredFactories();
			v.pReload();
			v.pAddFactory(new AdapterFactoryLoaderImpl());
		} catch (Throwable e) {
			System.exit(-1);
		}
	}
	
	protected static void checkPath() {

		//String path = System.getenv(EVI_BASE_KEY);

		String path = System.getProperty(EVI_BASE_KEY, "");
		if (path != null && path.length() != 0 ) {
			CommonPaths.setEVIDENCE_BASE(path);
		}
	}

	public static IVarTreeRequiredFactories getVarTreeRequiredFactories() {
		
		return (IVarTreeRequiredFactories) RTDFactory.get(IVarTreeRequiredFactories.class);
	}
	
	protected static void end(String txt, int status) {
		System.err.println(txt);
		System.exit(status);
	}
	
	protected static void printOut(String txt) {
		System.out.println(txt);
	}

}
