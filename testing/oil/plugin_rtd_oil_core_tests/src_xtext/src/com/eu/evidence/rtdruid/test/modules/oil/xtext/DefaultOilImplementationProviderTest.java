/**
 * 24/giu/2012
 */
package com.eu.evidence.rtdruid.test.modules.oil.xtext;

import static org.junit.Assert.*;

import org.junit.Test;

import com.eu.evidence.rtdruid.internal.modules.oil.implementation.OilImplCollector;
import com.eu.evidence.rtdruid.oil.xtext.model.OilImplementation;
import com.eu.evidence.rtdruid.oil.xtext.scoping.DefaultOilImplementationProvider;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class DefaultOilImplementationProviderTest {

	@Test
	public void test() {
		DefaultOilImplementationProvider provider = DefaultOilImplementationProvider.instance;
		assertEquals(OilImplCollector.getAllOilImplementation().length, provider.getImplementations().size());
		for (OilImplementation impl : provider.getImplementations()) {
			assertNotNull(impl);
		}
	}

}
