/*
 * Created on 29-ago-2005
 *
 * $Id: RtD_standAlone_oilStartTest.java,v 1.3 2008/03/26 18:23:52 durin Exp $
 */
package com.eu.evidence.rtdruid.test;

import junit.framework.Test;
import junit.framework.TestCase;

import com.eu.evidence.rtdruid.AbstractStandalone;
import com.eu.evidence.rtdruid.Rtd_corePlugin;
import com.eu.evidence.rtdruid.desk.IVarTreeRequiredFactories;
import com.eu.evidence.rtdruid.vartree.data.init.AdapterFactoryLoaderImpl;
import com.eu.evidence.rtdruid.vartree.data.oil.OilApplItemProviderAdapterFactory;




/**
 * 
 * TODO : Commentare && Tradurre
 * 
 * @author Nicola Serreli
 */
public class RtD_standAlone_oilStartTest extends TestCase {

	static {
		new Rtd_corePlugin();
		IVarTreeRequiredFactories vtf = AbstractStandalone.getVarTreeRequiredFactories();
		vtf.pReload();
		vtf.pAddFactory(new AdapterFactoryLoaderImpl());
		vtf.pAddFactory(new OilApplItemProviderAdapterFactory());
	}

	public static Test suite() {
		
		return RtD_OilStartTest.suite();
	}

}
