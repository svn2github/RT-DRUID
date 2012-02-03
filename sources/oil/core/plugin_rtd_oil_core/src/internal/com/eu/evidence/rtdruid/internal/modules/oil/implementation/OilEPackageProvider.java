/**
 * 10/gen/2012
 */
package com.eu.evidence.rtdruid.internal.modules.oil.implementation;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;

import com.eu.evidence.rtdruid.epackage.EPackageUtility;
import com.eu.evidence.rtdruid.epackage.IEPackageMerge;
import com.eu.evidence.rtdruid.epackage.IEPackageProvider;
import com.eu.evidence.rtdruid.epackage.RTDEPackageBuildException;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OilImplFactory;
import com.eu.evidence.rtdruid.modules.oil.implementation.IOilImplID;
import com.eu.evidence.rtdruid.modules.oil.implementation.IOilImplementation;
import com.eu.evidence.rtdruid.modules.oil.implementation.OilEcoreCreator;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class OilEPackageProvider implements IEPackageProvider {
	
	public final static String ID = "RT-Druid Oil - Oil implementations";
	
	private static EPackage defaultEpackage = null;
	

	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.epackage.IEPackageProvider#get()
	 */
	@Override
	public EPackage get() throws RTDEPackageBuildException {
		
		if (defaultEpackage == null) {
			
			IEPackageMerge merger = EPackageUtility.instance.getPackageMerge();
			merger.addEPackage(EcoreFactory.eINSTANCE.createEPackage());
	
			
			OilImplFactory oif = OilImplFactory.getAnInstance(null);
			oif.reloadDefault();
			IOilImplID[] ids = oif.getImplNames();
			for (IOilImplID id : ids) {
				IOilImplementation impl = oif.getImpl(id);
				
				OilEcoreCreator oec = OilEcoreCreator.getCreator(impl);
				EPackage ePkg = oec.buildPackage();
				if (ePkg != null) {
					merger.addEPackage(ePkg);
				}
			}
			defaultEpackage = merger.getResult();
		}
		return defaultEpackage;
	}

}
