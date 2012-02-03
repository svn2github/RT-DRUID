package com.eu.evidence.rtdruid.internal.vartree.data.oil.impl;

import static org.junit.Assert.*;

import org.eclipse.emf.ecore.EPackage;
import org.junit.Test;

import com.eu.evidence.rtdruid.vartree.data.oil.OilApplFactory;
import com.eu.evidence.rtdruid.vartree.data.oil.OilApplPackage;

public class OilApplPackageImplTest {

	@Test
	public void testInit() {
		
		OilApplPackage oap = OilApplPackageImpl.init();
		assertTrue(oap != null);
		
		OilApplPackage oap2 = OilApplPackage.eINSTANCE;
		assertTrue(oap == oap2);
		assertTrue(oap == EPackage.Registry.INSTANCE.get(OilApplPackage.eNS_URI));
	}

	@Test
	public void testGet() {
		
		OilApplPackage oap = OilApplPackage.eINSTANCE;
		assertTrue(oap != null);
		
		assertTrue(oap.getEnumerator() != null);
		assertTrue(oap.getEnumerator_Index() != null);
		assertTrue(oap.getEnumerator_ParameterList() != null);
		assertTrue(oap.getEnumerator_Value() != null);

		OilApplFactory oaf = OilApplFactory.eINSTANCE;
		assertTrue(oaf != null);
		assertTrue(oap.getOilApplFactory() != null);
	}

}
