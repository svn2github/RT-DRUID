/**
 * 28/dic/2011
 */
package com.eu.evidence.rtdruid.epackage;

import static com.eu.evidence.rtdruid.tests.RtdAssert.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.eclipse.emf.ecore.EPackage;
import org.junit.Test;

import com.eu.evidence.rtdruid.Rtd_corePlugin;
import com.eu.evidence.rtdruid.epackage.EPackageFactory.IEPackageFactoryElement;
import com.eu.evidence.rtdruid.tests.RtdAssert;


/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class EcoreEpackageExtentionTest {
	
	private final static String RTD_CORE_BASE_CONTR_ID = Rtd_corePlugin.EPACKAGE_BASE_ID;

	
	@Test
	public void testGetProviders() {
		IEPackageProvider[] providers = EPackageFactory.instance.getEPackageProviders();
		assertNotNull(providers);
	}

	@Test
	public void testGetTheSameDefaultEPackage()  throws RTDEPackageBuildException, IOException {
		EPackage pkg1 = EPackageFactory.instance.getEPackage();
		EPackage pkg2 = EPackageFactory.instance.getEPackage();
		assertNotNull(pkg1);
		assertNotNull(pkg2);
		
		EPackageTestUtility ptu = new EPackageTestUtility();
		assertEquals(ptu.modelToString(pkg1), ptu.modelToString(pkg2));
		
		assertSame(pkg1, pkg2);
	}

	@Test
	public void testGetTheSameEPackage1()  throws RTDEPackageBuildException, IOException {
		EPackage pkg1 = EPackageFactory.instance.getEPackage();
		EPackage pkg2 = EPackageFactory.getFactory().getEPackage();
		assertNotNull(pkg1);
		assertNotNull(pkg2);
		
		EPackageTestUtility ptu = new EPackageTestUtility();
		assertEquals(ptu.modelToString(pkg1), ptu.modelToString(pkg2));
		
		assertSame(pkg1, pkg2);
	}

	@Test
	public void testGetTheSameEPackage2()  throws RTDEPackageBuildException, IOException {
		EPackage pkg1 = EPackageFactory.getFactory().getEPackage();
		EPackage pkg2 = EPackageFactory.getFactory().getEPackage();
		assertNotNull(pkg1);
		assertNotNull(pkg2);
		
		EPackageTestUtility ptu = new EPackageTestUtility();
		assertEquals(ptu.modelToString(pkg1), ptu.modelToString(pkg2));
		
		assertSame(pkg1, pkg2);
	}

	@Test
	public void testGetEPackage()  throws RTDEPackageBuildException, IOException {
		RtdAssert.assertGreater(0, EPackageFactory.instance.getEPackageProviders().length);

		EPackage pkg = EPackageFactory.instance.getEPackage();
		assertNotNull(pkg);
		
		String s = EPackageUtility.instance.modelToString(pkg);
		System.out.println(s);
	}

	@Test
	public void testGetEPackage_DefaultPackage()  throws RTDEPackageBuildException, IOException {
		EPackageFactory epkgf = EPackageFactory.getFactory();
		EPackageUtility epu = EPackageUtility.instance;

		EPackage pkg = epkgf.getEPackage();
		assertNotNull(pkg);
		
		IEPackageFactoryElement[] factoryElements = epkgf.getEPackageFactoryElements();
		IEPackageProvider[] providers = epkgf.getEPackageProviders();
		IEPackageMerge merge = epu.getPackageMerge();
		// add an empty package
		merge.addEPackage(EPackageTestUtility.eCoreFactory.createEPackage());
		// add only enabled elements
		for (int i=0; i<factoryElements.length; i++) {
			if (factoryElements[i].isAutoContributionSet()) {
				EPackage ppkg = providers[i].get();
				assertNotNull(ppkg);
				merge.addEPackage(ppkg);
			}
		}
		EPackage result = merge.getResult();
		
		String sp1 = epu.modelToString(pkg);
		String sp2 = epu.modelToString(result);
		assertNotNull(sp1);
		assertNotNull(sp2);
		assertTrue(sp1.equals(sp2));
	}
	
	@Test
	public void testGetEPackage_AllPackage()  throws RTDEPackageBuildException, IOException {
		EPackageFactory epkgf = EPackageFactory.getFactory();
		EPackageUtility epu = EPackageUtility.instance;

		
		IEPackageMerge merge = epu.getPackageMerge();
		// add an empty package
		merge.addEPackage(EPackageTestUtility.eCoreFactory.createEPackage());
		for (IEPackageProvider elem : epkgf.getEPackageProviders()) {
			EPackage ppkg = elem.get();
			assertNotNull(ppkg);
			merge.addEPackage(ppkg);
		}
		EPackage result = merge.getResult();
		
		IEPackageFactoryElement[] factoryElements = epkgf.getEPackageFactoryElements();
		// enable all elements
		for (IEPackageFactoryElement elem : factoryElements) {
			elem.setAutoContributionSet(true);
		}
		EPackage pkg = epkgf.getEPackage();
		assertNotNull(pkg);
		
		String sp1 = epu.modelToString(pkg);
		String sp2 = epu.modelToString(result);
		assertNotNull(sp1);
		assertNotNull(sp2);
		assertTrue(sp1.equals(sp2));
	}
	
	@Test
	public void testGetEPackage_selectingProviders()  throws RTDEPackageBuildException, IOException {
		EPackageFactory epkgf = EPackageFactory.getFactory();
		EPackageUtility epu = EPackageUtility.instance;

		IEPackageFactoryElement[] factoryElements = epkgf.getEPackageFactoryElements();
		IEPackageProvider[] providers = epkgf.getEPackageProviders();
		assertEquals(factoryElements.length, providers.length);
		
		final int max = 1 << Math.min( factoryElements.length, 3); 
		//System.out.println("f "+factoryElements.length + " m " + max);
		
		// disable all elements
		for (IEPackageFactoryElement elem : factoryElements) {
			elem.setAutoContributionSet(false);
		}
		
		// using selection's bits to select which factoryElement enable
		for (int selection = 0; selection < max; selection++) {
			
			IEPackageMerge merge = epu.getPackageMerge();
			// add an empty package
			merge.addEPackage(EPackageTestUtility.eCoreFactory.createEPackage());
			
			
			// enable only few elements
			for (int i=0; i<factoryElements.length; i++) {
				IEPackageFactoryElement elem = factoryElements[i];
				final boolean select = (selection & (1<<i)) != 0;
				//System.out.println("s "+selection + " i " + i + " " + select);
				elem.setAutoContributionSet(select);
				
				if (select) {
					EPackage ppkg = providers[i].get();
					assertNotNull(ppkg);
					merge.addEPackage(ppkg);
				}
			}

			// auto computed merge
			EPackage pkg = epkgf.getEPackage();
			EPackage result = merge.getResult();
			assertNotNull(pkg);
			assertNotNull(result);
			
			String sp1 = epu.modelToString(pkg);
			String sp2 = epu.modelToString(result);
			assertNotNull(sp1);
			assertNotNull(sp2);
			assertTrue("Failed configuration " + selection, sp1.equals(sp2));
		}
		
	}

	
	@Test
	public void testGetEPackageFactory()  throws RTDEPackageBuildException, IOException {
		EPackageFactory default_epk = EPackageFactory.instance;
		assertNotNull(default_epk);
		
		EPackageFactory new_epk_1 = EPackageFactory.getFactory();
		assertNotNull(new_epk_1);
		assertNotSame(default_epk, new_epk_1);

		EPackageFactory new_epk_2 = EPackageFactory.getFactory();
		assertNotNull(new_epk_2);
		assertNotSame(default_epk, new_epk_2);
		assertNotSame(new_epk_1, new_epk_2);
	}
	
	@Test
	public void testGetEPackageFactoryElements()  throws RTDEPackageBuildException, IOException {
		EPackageFactory default_epk = EPackageFactory.instance;
		EPackageFactory new_epk = EPackageFactory.getFactory();
		assertNotNull(default_epk);
		assertNotNull(new_epk);
		assertNotSame(default_epk, new_epk);
		

		IEPackageFactoryElement[] el_def1 = default_epk.getEPackageFactoryElements();
		assertNotNull(el_def1);
		RtdAssert.assertGreater(0, el_def1.length);
		for (IEPackageFactoryElement el :  el_def1) {
			assertNotNull(el.getProvider(true));
		}

		IEPackageFactoryElement[] el_def2 = default_epk.getEPackageFactoryElements();
		assertNotNull(el_def2);
		RtdAssert.assertGreater(0, el_def2.length);
		for (IEPackageFactoryElement el :  el_def2) {
			assertNotNull(el.getProvider(true));
		}

		IEPackageFactoryElement[] el_new1 = new_epk.getEPackageFactoryElements();
		assertNotNull(el_new1);
		RtdAssert.assertGreater(0, el_new1.length);
		for (IEPackageFactoryElement el :  el_new1) {
			assertNotNull(el.getProvider(true));
		}
		
		checkSimilarElementList(el_def1, el_new1);
		checkVerySimilarElementList(el_def1, el_def2);
	}



	@Test
	public void testModifyAutoContribution()  throws RTDEPackageBuildException, IOException {
		EPackageFactory default_epk = EPackageFactory.instance;
		EPackageFactory new_epk_1 = EPackageFactory.getFactory();
		EPackageFactory new_epk_2 = EPackageFactory.getFactory();
		assertNotSame(default_epk, new_epk_1);
		assertNotSame(default_epk, new_epk_2);
		assertNotSame(new_epk_1, new_epk_2);

		// Elements list retrived before the change
		IEPackageFactoryElement[] el_bef_def1 = default_epk.getEPackageFactoryElements();
		IEPackageFactoryElement[] el_bef_new1a = new_epk_1.getEPackageFactoryElements();
		IEPackageFactoryElement[] el_bef_new1b = new_epk_1.getEPackageFactoryElements();
		IEPackageFactoryElement[] el_bef_new2 = new_epk_2.getEPackageFactoryElements();
		
		IEPackageFactoryElement[] modified = new_epk_2.getEPackageFactoryElements();
		assertNotNull(modified);
		RtdAssert.assertGreater(0, modified.length);

		checkSimilarElementList(el_bef_def1, el_bef_new1a, el_bef_new2);
		checkVerySimilarElementList(el_bef_new1a, el_bef_new1b);
		checkVerySimilarElementList(el_bef_new2, modified);
		
		boolean[] oldValues = new boolean[modified.length];
		for(int i=0; i<modified.length; i++) {
			oldValues[i] = modified[i].isAutoContributionSet();
			boolean notOldValue = not(oldValues[i]);
			modified[i].setAutoContributionSet( notOldValue );
			assertEquals(notOldValue, modified[i].isAutoContributionSet());
		}

		IEPackageFactoryElement[] el_after_def1 = default_epk.getEPackageFactoryElements();
		IEPackageFactoryElement[] el_after_new1a = new_epk_1.getEPackageFactoryElements();
		IEPackageFactoryElement[] el_after_new1b = new_epk_1.getEPackageFactoryElements();
		IEPackageFactoryElement[] el_after_new2 = new_epk_2.getEPackageFactoryElements();

		checkSimilarElementList(el_bef_def1, el_bef_new1a);
		checkVerySimilarElementList(el_bef_def1, el_after_def1);
		checkVerySimilarElementList(el_bef_new1a, el_bef_new1b, el_after_new1a, el_after_new1b);
		checkVerySimilarElementList(el_bef_new2, modified, el_after_new2);

		checkNotSimilarElementList(el_bef_new2, el_bef_def1, el_bef_new1a, el_bef_new1b, el_after_def1, el_after_new1a, el_after_new1b);
		checkNotSimilarElementList(modified, el_bef_def1, el_bef_new1a, el_bef_new1b, el_after_def1, el_after_new1a, el_after_new1b);
		checkNotSimilarElementList(el_after_new2, el_bef_def1, el_bef_new1a, el_bef_new1b, el_after_def1, el_after_new1a, el_after_new1b);

	}
		
	@Test
	public void testReload()  throws RTDEPackageBuildException, IOException {
		EPackageFactory default_epk = EPackageFactory.instance;
		EPackageFactory new_epk_1 = EPackageFactory.getFactory();
		EPackageFactory new_epk_2 = EPackageFactory.getFactory();
		assertNotSame(default_epk, new_epk_1);
		assertNotSame(default_epk, new_epk_2);
		assertNotSame(new_epk_1, new_epk_2);

		// Elements list retrived before the change
		IEPackageFactoryElement[] el_bef_def1 = default_epk.getEPackageFactoryElements();
		IEPackageFactoryElement[] el_bef_new1 = new_epk_1.getEPackageFactoryElements();
		IEPackageFactoryElement[] modified = new_epk_2.getEPackageFactoryElements();

		checkSimilarElementList(el_bef_def1, el_bef_new1, modified);
		
		boolean[] oldValues = new boolean[modified.length];
		for(int i=0; i<modified.length; i++) {
			oldValues[i] = modified[i].isAutoContributionSet();
			boolean notOldValue = not(oldValues[i]);
			modified[i].setAutoContributionSet( notOldValue );
			assertEquals(notOldValue, modified[i].isAutoContributionSet());
		}

		IEPackageFactoryElement[] el_after_def1 = default_epk.getEPackageFactoryElements();
		IEPackageFactoryElement[] el_after_new1 = new_epk_1.getEPackageFactoryElements();
		IEPackageFactoryElement[] el_after_new2 = new_epk_2.getEPackageFactoryElements();

		checkSimilarElementList(el_bef_def1, el_bef_new1);
		checkVerySimilarElementList(el_bef_def1, el_after_def1);
		checkVerySimilarElementList(el_bef_new1, el_after_new1);
		checkVerySimilarElementList(modified, el_after_new2);

		// reload epk_2
		new_epk_2.reloadExtensions();
		IEPackageFactoryElement[] el_reload_new2 = new_epk_2.getEPackageFactoryElements();
		

		checkNotSimilarElementList(modified, el_reload_new2);
		checkSimilarElementList(el_bef_def1, el_bef_new1, el_reload_new2);
		checkVerySimilarElementList(el_bef_def1, el_after_def1);
		checkVerySimilarElementList(el_bef_new1, el_after_new1);
	}


	@Test
	public void testRemoveElement()  throws RTDEPackageBuildException, IOException {
		EPackageFactory default_epk = EPackageFactory.instance;

		// Elements list retrived before the change
		IEPackageFactoryElement[] modified = default_epk.getEPackageFactoryElements();
		assertNotNull(modified);
		RtdAssert.assertGreater(0, modified.length);
		
		for (int i=0; i<modified.length; i++) {
			modified[i] = null;
		}
		
		IEPackageFactoryElement[] el_after_def1 = default_epk.getEPackageFactoryElements();
		assertNotNull(el_after_def1);
		assertEquals(modified.length, el_after_def1.length);		
	}

	@Test
	public void testGetNullId()  throws RTDEPackageBuildException, IOException {
		EPackageFactory default_epk = EPackageFactory.instance;
		assertNull(default_epk.getEPackageFactoryElement(null));
		assertNull(EPackageFactory.getFactory().getEPackageFactoryElement(null));

		assertNull(default_epk.getEPackageFactoryElement("unknown element ID"));
		assertNull(EPackageFactory.getFactory().getEPackageFactoryElement("unknown element ID"));

	}
	
	@Test
	public void testGetId()  throws RTDEPackageBuildException, IOException {
		EPackageFactory default_epk = EPackageFactory.instance;

		IEPackageFactoryElement rtd_core_base_contribution = null;
		for (IEPackageFactoryElement elem : default_epk.getEPackageFactoryElements()) {
			if (RTD_CORE_BASE_CONTR_ID.equalsIgnoreCase(elem.getId())) {
				rtd_core_base_contribution = elem;
			}
		}
		assertNotNull(rtd_core_base_contribution);
		assertSame(rtd_core_base_contribution, default_epk.getEPackageFactoryElement(RTD_CORE_BASE_CONTR_ID));
		
		IEPackageFactoryElement theSameElement = EPackageFactory.getFactory().getEPackageFactoryElement(RTD_CORE_BASE_CONTR_ID);
		assertNotSame(rtd_core_base_contribution, theSameElement);
		checkSimilarElement(rtd_core_base_contribution, theSameElement, true);
	}

	
	@Test
	public void testGetParentFactory()  throws RTDEPackageBuildException, IOException {
		EPackageFactory default_epk = EPackageFactory.instance;
		EPackageFactory diff_epk = EPackageFactory.getFactory();

		IEPackageFactoryElement[] list_1 = diff_epk.getEPackageFactoryElements();
		checkVerySimilarElementList(list_1, diff_epk.getEPackageFactoryElements());
		
		for (IEPackageFactoryElement elem : list_1) {
			assertNotSame(default_epk, elem.getFactory());
			assertSame(diff_epk, elem.getFactory());
		}
		
		diff_epk.reloadExtensions();
		IEPackageFactoryElement[] list_2 = diff_epk.getEPackageFactoryElements();
		checkSimilarElementList(list_1, list_2);
		
		for (int h=0; h<list_1.length; h++) {
			IEPackageFactoryElement el1 = list_1[h];
			IEPackageFactoryElement el2 = list_2[h];
			
			checkSimilarElement(el1, el2, true);
			assertNotSame(el1, el2);
			assertNotSame(default_epk, el1.getFactory());
			assertNotSame(default_epk, el2.getFactory());
			assertSame(diff_epk, el1.getFactory());
			assertSame(diff_epk, el2.getFactory());
		}
	}

	
	@Test
	public void testValidateGetEPackage_DefaultPackages()  throws RTDEPackageBuildException, IOException {
		EPackageFactory epkgf = EPackageFactory.getFactory();
		
		for(IEPackageProvider provider : epkgf.getEPackageProviders()) {
			validateEPackage(provider.getClass().getName(),provider.get());
		}
	}
	
	@Test
	public void testValidateDefaultPackage()  throws RTDEPackageBuildException, IOException {
		validateEPackage("default", EPackageFactory.getFactory().getEPackage());
	}

	private void validateEPackage(String name, EPackage ppkg) {
		assertNotNull(ppkg);
		StringBuffer msg = new StringBuffer(name+"\n");
		boolean result = EPackageUtility.instance.modelValidate(ppkg, null, msg);
		assertTrue(msg.toString(), result);
	}


	/**
	 * Compare two ElementList computed from different EPackageFactory
	 * 
	 * @param elems
	 */
	private void checkSimilarElementList(IEPackageFactoryElement[]... elems) {
		for(int i=0; i<elems.length; i++) {
			IEPackageFactoryElement[] first = elems[i];
			for(int j=i+1; j<elems.length; j++) {
				IEPackageFactoryElement[] second = elems[j];
				
				assertNotSame(first, second);
				assertEquals(first.length, second.length);
	
				for (int h=0; h<first.length; h++) {
					checkSimilarElement(first[h], second[h], true);
				}
			}
		}
	}
	
	/**
	 * Compare two ElementList computed from the same EPackageFactory (they points to the same objects)
	 * 
	 * @param elems
	 */
	private void checkVerySimilarElementList(IEPackageFactoryElement[]... elems) {
		for(int i=0; i<elems.length; i++) {
			IEPackageFactoryElement[] first = elems[i];
			for(int j=i+1; j<elems.length; j++) {
				IEPackageFactoryElement[] second = elems[j];
				
				assertNotSame(first, second);
				assertEquals(first.length, second.length);
	
				for (int h=0; h<first.length; h++) {
					assertSame(first[h], second[h]);
				}
			}
		}
	}

	/**
	 * The diff list contains a list of elements with a different value of isAutoContribution
	 * 
	 * @param diff
	 * @param elems
	 */
	private void checkNotSimilarElementList(IEPackageFactoryElement[] diff, IEPackageFactoryElement[]... elems) {
		IEPackageFactoryElement[] first = diff;
		for(int j=1; j<elems.length; j++) {
			IEPackageFactoryElement[] second = elems[j];
			
			assertNotSame(first, second);
			assertEquals(first.length, second.length);

			for (int h=0; h<first.length; h++) {
				checkSimilarElement(first[h], second[h], false);
			}
		}
	}

	
	private void checkSimilarElement(IEPackageFactoryElement el1, IEPackageFactoryElement el2, boolean sameAutoContribution) {
		assertNotSame(el1, el2);

		assertEquals(el1.getId(), el2.getId());

		if (sameAutoContribution) {
			assertEquals(el1.isAutoContributionSet(), el2.isAutoContributionSet());
		} else {
			assertEquals(el1.isAutoContributionSet(), not(el2.isAutoContributionSet()));
		}
	}

}
