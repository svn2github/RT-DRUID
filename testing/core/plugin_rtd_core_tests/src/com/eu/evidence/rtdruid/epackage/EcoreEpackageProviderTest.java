/**
 * 22/nov/2011
 */
package com.eu.evidence.rtdruid.epackage;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Test;

import com.eu.evidence.rtdruid.internal.epackage.EPackageXmlMerge;

/**
 * 
 * @author Nicola Serreli
 * @since 2.0
 * 
 */
public class EcoreEpackageProviderTest {
	
	private final static EPackageTestUtility ebu = new EPackageTestUtility(); 

	@Test
	public void testLoadAddition()  throws RTDEPackageBuildException, IOException {
		EPackage local = EcoreFactory.eINSTANCE.createEPackage();
		local.setName("rtdruid");
		local.setNsPrefix("com.eu.evidence.rtdruid.data");
		local.setNsURI("http://www.evidence.eu.com/rtdruid/data");
		{
			EClass e_sys = ebu.createEmptyClass(local, "System");
			EClass e_obj = ebu.createEmptyClass(local, "ObjectWithID");
			EClass e_arc = ebu.createEmptyClass(local, "Architectural");
			EClass e_tsk = ebu.createEmptyClass(local, "Task");
			EDataType sVar = ebu.addType(local, "StringVar", "com.eu.evidence.rtdruid.vartree.variables.StringVar");
			EGenericType newEGenericType = EcoreFactory.eINSTANCE.createEGenericType();
		    newEGenericType.setEClassifier(e_obj);
			e_sys.getEGenericSuperTypes().add(EcoreUtil.copy(newEGenericType));
			ebu.addReference(e_sys, "Architectural", e_arc).setContainment(true);
			e_obj.setAbstract(true);
			e_arc.getEGenericSuperTypes().add(EcoreUtil.copy(newEGenericType));
			EReference tList = ebu.addReference(e_arc, "TaskList", e_tsk);
			tList.setContainment(true);
			tList.setLowerBound(1);
			tList.setUpperBound(ETypedElement.UNBOUNDED_MULTIPLICITY);
			
			e_tsk.getEGenericSuperTypes().add(EcoreUtil.copy(newEGenericType));
			ebu.addAttribute(e_tsk, "TaskAdd").setEType(sVar);
		}
//		System.out.println(">>LOCAL \n" + ebu.modelToString(local)+"\n<<");
		
		JavaEcoreEpackageProvider provider = new JavaEcoreEpackageProvider("addition.ecore", this.getClass());
		EPackage file = provider.get();
//		System.out.println(">>File \n" + ebu.modelToString(file)+"\n<<");
		
		assertTrue(EcoreUtil.equals(local, file));
	}

	@Test
	public void testLoadAddition2()  throws RTDEPackageBuildException, IOException {
		EPackage local = EcoreFactory.eINSTANCE.createEPackage();
		local.setName("rtdruid");
		local.setNsPrefix("com.eu.evidence.rtdruid.data");
		local.setNsURI("http://www.evidence.eu.com/rtdruid/data");
		{
			EClass e_sys = ebu.createEmptyClass(local, "System");
			EClass e_obj = ebu.createEmptyClass(local, "ObjectWithID");
			EClass e_arc = ebu.createEmptyClass(local, "Architectural");
			EClass e_tsk = ebu.createEmptyClass(local, "Task");
			EDataType sVar = ebu.addType(local, "StringVar", "com.eu.evidence.rtdruid.vartree.variables.StringVar");
			EGenericType newEGenericType = EcoreFactory.eINSTANCE.createEGenericType();
		    newEGenericType.setEClassifier(e_obj);
			e_sys.getEGenericSuperTypes().add(EcoreUtil.copy(newEGenericType));
			ebu.addReference(e_sys, "Architectural", e_arc).setContainment(true);
			e_obj.setAbstract(true);
			e_arc.getEGenericSuperTypes().add(EcoreUtil.copy(newEGenericType));
			EReference tList = ebu.addReference(e_arc, "TaskList", e_tsk);
			tList.setContainment(true);
			tList.setLowerBound(1);
			tList.setUpperBound(ETypedElement.UNBOUNDED_MULTIPLICITY);
			
			e_tsk.getEGenericSuperTypes().add(EcoreUtil.copy(newEGenericType));
			ebu.addAttribute(e_tsk, "TaskAdd").setEType(sVar);
		}
		System.out.println(">>LOCAL \n" + ebu.modelToString(local)+"\n<<");
		
		JavaEcoreEpackageProvider provider = new JavaEcoreEpackageProvider("addition.ecore", this.getClass());
		EPackage file = provider.get();
		System.out.println(">>File \n" + ebu.modelToString(file)+"\n<<");
		
		assertTrue(EcoreUtil.equals(local, file));
		
		EPackage result1;
		{
			IEPackageMerge merger = new EPackageXmlMerge();
			merger.addEPackage(file);
			merger.addEPackage(local);
			result1 = merger.getResult();
		}
		assertTrue(EcoreUtil.equals(result1, file));
		assertTrue(EcoreUtil.equals(result1, local));
	}

	
	@Test
	public void testMergeDataAddition()  throws RTDEPackageBuildException, IOException {
		EPackage add = new JavaEcoreEpackageProvider("addition.ecore", this.getClass()).get();
		EPackage data = new JavaEcoreEpackageProvider("data.ecore", this.getClass()).get();
		EPackage check = new JavaEcoreEpackageProvider("data_addition__result.ecore", this.getClass()).get();
//		System.out.println(">>File \n" + ebu.modelToString(file)+"\n<<");
		
		EPackage result1;
		{
			IEPackageMerge merger = EPackageUtility.instance.getPackageMerge();
			merger.addEPackage(data);
			merger.addEPackage(add);
			result1 = merger.getResult();
		}
		
		System.out.println(">>RESULT \n" + ebu.modelToString(result1)+"\n<<");
		System.out.println(">>CHECK \n" + ebu.modelToString(check)+"\n<<");
		assertTrue(EcoreUtil.equals(result1, check));
	}

}
