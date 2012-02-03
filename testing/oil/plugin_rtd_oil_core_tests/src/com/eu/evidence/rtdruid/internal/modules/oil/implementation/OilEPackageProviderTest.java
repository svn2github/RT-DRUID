/**
 * 10/gen/2012
 */
package com.eu.evidence.rtdruid.internal.modules.oil.implementation;

import static org.junit.Assert.*;

import org.junit.Test;

import com.eu.evidence.rtdruid.epackage.EPackageFactory;
import com.eu.evidence.rtdruid.epackage.IEPackageProvider;
import com.eu.evidence.rtdruid.epackage.EPackageFactory.IEPackageFactoryElement;
import com.eu.evidence.rtdruid.epackage.RTDEPackageBuildException;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class OilEPackageProviderTest {

	@Test
	public void test() throws RTDEPackageBuildException {
		IEPackageFactoryElement factoryElement = EPackageFactory.instance.getEPackageFactoryElement(OilEPackageProvider.ID);
		IEPackageProvider provider = factoryElement.getProvider(true);
		assertNotNull(provider);
		assertTrue(provider instanceof OilEPackageProvider);
		
		assertNotNull(provider.get());
	}
	
}
