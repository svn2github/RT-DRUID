package com.eu.evidence.rtdruid.modules.oil;

import static org.junit.Assert.assertTrue;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.junit.Test;

import com.eu.evidence.rtdruid.desk.RTDFactory;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OilImplFactory;
import com.eu.evidence.rtdruid.modules.oil.implementation.OilEcoreCreator;
import com.eu.evidence.rtdruid.modules.oil.interfaces.IOilImplID;
import com.eu.evidence.rtdruid.modules.oil.interfaces.IOilImplementation;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVarTreePointer;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;

public class OilEcoreCreatorTest {
	@Test
	public void testBuildPackage() {
		
		IVarTree vt = (IVarTree) RTDFactory.get(IVarTree.class);;
		
		OilImplFactory oif = OilImplFactory.getAnInstance(vt);
		oif.reloadDefault();
		IOilImplID[] ids = oif.getImplNames();
		for (IOilImplID id : ids) {
		
			System.out.println("Building " + id.getImplementationName());
			IOilImplementation impl = oif.getImpl(id);
			
			
			OilEcoreCreator oec = OilEcoreCreator.getCreator(impl);
			EPackage ePkg = oec.buildPackage();
			OilEcoreCreator.save(ePkg, "./prova_" + id.getImplementationName() + ".ecore");
		}

	}
	
	
	@Test
	public void testRtdOilEcore() {

		IVarTree vt = (IVarTree) RTDFactory.get(IVarTree.class);;
		
		OilImplFactory oif = OilImplFactory.getAnInstance(vt);
		oif.reloadDefault();
		IOilImplID[] ids = oif.getImplNames();
		assertTrue(ids.length == 1);
		EPackage ePkg = null;
		for (IOilImplID id : ids) {
		
			System.out.println("Building " + id.getImplementationName());
			IOilImplementation impl = oif.getImpl(id);
			
			
			OilEcoreCreator oec = OilEcoreCreator.getCreator(impl);
			ePkg = oec.buildPackage();
		}
		assertTrue(ePkg != null);
		
		EClass task = DataPackage.eINSTANCE.getTask();
		EList<EReference> refs = task.getEAllReferences();
		boolean found = false;
		for (EReference ref: refs) {
			if ("TASK_OIL_EXT".equalsIgnoreCase(ref.getName())) {
				found = true;
			}
		}
		
		assertTrue(found);
		
		OilEcoreCreator.save(DataPackage.eINSTANCE, "./data.ecore");
	}

	@Test
	public void testFillRtdOilEcore() {

		IVarTree vt = (IVarTree) RTDFactory.get(IVarTree.class);;
		
		OilImplFactory oif = OilImplFactory.getAnInstance(vt);
		oif.reloadDefault();
		IOilImplID[] ids = oif.getImplNames();
		assertTrue(ids.length == 1);
		EPackage ePkg = null;
		for (IOilImplID id : ids) {
		
			System.out.println("Building " + id.getImplementationName());
			IOilImplementation impl = oif.getImpl(id);
			
			
			OilEcoreCreator oec = OilEcoreCreator.getCreator(impl);
			ePkg = oec.buildPackage();
		}
		assertTrue(ePkg != null);
		
		FillVtTest.fill(vt);
		IVarTreePointer vtp = vt.newVarTreePointer();
		assertTrue(vtp.goFirstChild()); // System
		assertTrue(vtp.go(DataPackage.Literals.ARCHITECTURAL.getName())); // Archtectural
		assertTrue(vtp.go(DataPackage.Literals.ARCHITECTURAL__TASK_LIST.getName())); // TaskList
		assertTrue(vtp.goFirstChild()); // A Task
		assertTrue(vtp.getType().equalsIgnoreCase(DataPackage.Literals.TASK.getName())); // TASK type
		
		assertTrue(vtp.go("TASK_OIL_EXT")); // oil extention
		
	}

}


