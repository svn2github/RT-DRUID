package com.eu.evidence.rtdruid.modules.oil.implementation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.junit.Test;

import com.eu.evidence.rtdruid.Rtd_corePlugin;
import com.eu.evidence.rtdruid.epackage.EPackageFactory;
import com.eu.evidence.rtdruid.epackage.EPackageFactory.EPackageProviderException;
import com.eu.evidence.rtdruid.epackage.EPackageFactory.IEPackageFactoryElement;
import com.eu.evidence.rtdruid.epackage.EPackageUtility;
import com.eu.evidence.rtdruid.epackage.IEPackageMerge;
import com.eu.evidence.rtdruid.epackage.RTDEPackageBuildException;
import com.eu.evidence.rtdruid.internal.modules.oil.implementation.OilEcoreCreatorImpl;
import com.eu.evidence.rtdruid.internal.modules.oil.implementation.OilImplementation;
import com.eu.evidence.rtdruid.internal.modules.oil.reader.OilInfo;
import com.eu.evidence.rtdruid.internal.modules.oil.reader.OilParser;
import com.eu.evidence.rtdruid.internal.modules.oil.reader.ParseException;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OilImplFactory;
import com.eu.evidence.rtdruid.tests.vartree.data.FillVtUtil;
import com.eu.evidence.rtdruid.vartree.IVarTreePointer;
import com.eu.evidence.rtdruid.vartree.VarTreePointerEMF;
import com.eu.evidence.rtdruid.vartree.Vt2StringUtilities;

public class OilEcoreCreatorTest {
	class SimpleOilID implements IOilImplID {
		private final String name;
		
		public SimpleOilID(String name) {
			this.name = name;
		}
		
		public int compareTo(IOilImplID o) {
			return name.compareTo(o.getImplementationName());
		}
		
		public String getImplementationName() {
			return name;
		}
		public IOilImplID clone() {
			return new SimpleOilID(name);
		}
		
	}

	@Test
	public void testOilImplExample() throws ParseException, IOException {
		String res_path =// "/" + getClass().getPackage().getName().replace(".", "/")+ "/" + 
						"oil_impl_test.oil";
		OilParser op = new OilParser(this.getClass().getResourceAsStream(res_path));
		OilInfo oi = op.start();

		IOilImplementation impl = new OilImplementation(new SimpleOilID("test"), oi.getImpl());
		OilEcoreCreator oec = new OilEcoreCreatorImpl(impl);
		EPackage ePkg = oec.buildPackage();
		validateEPackage(ePkg);
		//String s = 
				EPackageUtility.instance.modelToString(ePkg);
//		System.out.println(s);
	}
	
	@Test
	public void testOilImplSimpleExample() throws ParseException, IOException, EPackageProviderException, RTDEPackageBuildException {
		String res_path =// "/" + getClass().getPackage().getName().replace(".", "/")+ "/" + 
						"oil_impl_simple_test.oil";
		OilParser op = new OilParser(this.getClass().getResourceAsStream(res_path));
		OilInfo oi = op.start();

		IOilImplementation impl = new OilImplementation(new SimpleOilID("test"), oi.getImpl());
		OilEcoreCreator oec = new OilEcoreCreatorImpl(impl);
		EPackage ePkg = oec.buildPackage();
		validateEPackage(ePkg);
//		String s = EPackageUtility.instance.modelToString(ePkg);
//		System.out.println(s);
		IEPackageFactoryElement basePackageElement = EPackageFactory.instance.getEPackageFactoryElement(Rtd_corePlugin.EPACKAGE_BASE_ID);
		EPackage basePkg = basePackageElement.getProvider(true).get();
		validateEPackage(basePkg);
		
		IEPackageMerge merger = EPackageUtility.instance.getPackageMerge();
		merger.addEPackage(basePkg);
		merger.addEPackage(ePkg);
		EPackage result = merger.getResult();
		validateEPackage(result);
		EPackageUtility.instance.modelToString(result);
		EClassifier sys = ePkg.getEClassifier("System");
		assertNull(sys);
		sys = basePkg.getEClassifier("System");
		assertNotNull(sys);
		assertTrue(sys instanceof EClass);
		sys = result.getEClassifier("System");
		assertNotNull(sys);
		assertTrue(sys instanceof EClass);
		
	}

	@Test
	public void testBuildPackageAllImplementations() throws IOException {
		
		OilImplFactory oif = OilImplFactory.getAnInstance(null);
		oif.reloadDefault();
		IOilImplID[] ids = oif.getImplNames();
		for (IOilImplID id : ids) {
		
			//System.out.println("Building " + id.getImplementationName());
			IOilImplementation impl = oif.getImpl(id);
			
			OilEcoreCreator oec = OilEcoreCreator.getCreator(impl);
			EPackage ePkg = oec.buildPackage();
			validateEPackage(ePkg);
//			String s = EPackageUtility.instance.modelToString(ePkg);
//			System.out.println("\n\n./prova_" + id.getImplementationName() + ".ecore\n" +s);
		}

	}
	
	
	@Test
	public void testBuildPackageMergeImplementations() throws IOException, RTDEPackageBuildException {
		
		OilImplFactory oif = OilImplFactory.getAnInstance(null);
		oif.reloadDefault();
		IOilImplID[] ids = oif.getImplNames();
		assertEquals(1, ids.length);
		EPackage ePkg = null;
		
		IEPackageFactoryElement basePackageElement = EPackageFactory.instance.getEPackageFactoryElement(Rtd_corePlugin.EPACKAGE_BASE_ID);
		EPackage basePkg = basePackageElement.getProvider(true).get();
		IEPackageMerge merger = EPackageUtility.instance.getPackageMerge();
		merger.addEPackage(basePkg);

		for (IOilImplID id : ids) {
			OilEcoreCreator oec = OilEcoreCreator.getCreator(oif.getImpl(id));
			ePkg = oec.buildPackage();
			validateEPackage(ePkg);
			merger.addEPackage(ePkg);
		}
		assertNotNull(ePkg);

		EPackage result = merger.getResult();
		validateEPackage(result);

		EClassifier sys = result.getEClassifier("System");
		assertNotNull(sys);
		assertTrue(sys instanceof EClass);

		EClassifier task_classifier = result.getEClassifier("Task");
		assertNotNull(task_classifier);
		assertTrue(task_classifier instanceof EClass);

		
		EClass task = (EClass) task_classifier;
		EList<EReference> refs = task.getEAllReferences();
		boolean found = false;
		for (EReference ref: refs) {
			if ("TASK_OIL_EXT".equalsIgnoreCase(ref.getName())) {
				found = true;
			}
		}
		
		assertTrue(found);
//		
//		
		System.out.println(EPackageUtility.instance.modelToString(ePkg));
	}

	@Test
	public void testFillRtdOilEcore() throws EPackageProviderException, RTDEPackageBuildException, IOException {
		IEPackageFactoryElement basePackageElement = EPackageFactory.instance.getEPackageFactoryElement(Rtd_corePlugin.EPACKAGE_BASE_ID);
		EPackage basePkg = basePackageElement.getProvider(true).get();
		IEPackageMerge merger = EPackageUtility.instance.getPackageMerge();
		merger.addEPackage(basePkg);

		OilImplFactory oif = OilImplFactory.getAnInstance(null);
		oif.reloadDefault();
		IOilImplID[] ids = oif.getImplNames();
		assertEquals(ids.length, 1);
		for (IOilImplID id : ids) {
			merger.addEPackage(OilEcoreCreator.getCreator(oif.getImpl(id)).buildPackage());
		}
		EPackage result = merger.getResult();
		validateEPackage(result);
		//System.out.println(EPackageUtility.instance.modelToString(result));

		EClassifier sys = result.getEClassifier("System");
		assertNotNull(sys);
		assertTrue(sys instanceof EClass);
		assertNotNull(result.getEFactoryInstance());
		EObject root = result.getEFactoryInstance().create((EClass)sys);

		FillVtUtil filler = new FillVtUtil();
		filler.fill(root);
		System.out.println(Vt2StringUtilities.varTreeToString(filler.getEditingDomain()));

		EList<EObject> elements = new BasicEList<EObject>();
		elements.add(root);
		IVarTreePointer vtp = new VarTreePointerEMF(elements, filler.getEditingDomain());
		
		assertTrue(vtp.goFirstChild()); // System
		assertTrue("System".equalsIgnoreCase(vtp.getType())); // System
		assertTrue(vtp.go("Architectural")); // DataPackage.Literals.ARCHITECTURAL.getName()
		assertTrue(vtp.go("TaskList")); // DataPackage.Literals.ARCHITECTURAL__TASK_LIST.getName()
		assertTrue(vtp.goFirstChild()); // A Task
		assertTrue(vtp.getType().equalsIgnoreCase("Task")); // DataPackage.Literals.TASK.getName()
		
		assertTrue(vtp.go("TASK_OIL_EXT")); // oil extention
		
	}

	private void validateEPackage(EPackage ppkg) {
		assertNotNull(ppkg);
		StringBuffer msg = new StringBuffer();
		boolean result = EPackageUtility.instance.modelValidate(ppkg, null, msg);
		assertTrue(msg.toString(), result);
	}

}
