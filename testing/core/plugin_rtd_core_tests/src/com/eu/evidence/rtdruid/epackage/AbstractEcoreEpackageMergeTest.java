/**
 * 22/nov/2011
 */
package com.eu.evidence.rtdruid.epackage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Test;

/**
 * 
 * @author Nicola Serreli
 * @since 2.0
 * 
 */
public abstract class AbstractEcoreEpackageMergeTest {
	
	private final static EPackageTestUtility ebu = new EPackageTestUtility();
	
	
	protected abstract IEPackageMerge getMerge();

	

	/**
	 * Test method for
	 * {@link com.eu.evidence.rtdruid.epackage.EcoreEpackageProvider#fill(org.eclipse.emf.ecore.EPackage)}
	 * .
	 * 
	 * @throws RTDEPackageBuildException
	 */
	@Test
	public void testCopy() throws RTDEPackageBuildException {
		EPackage dest = EcoreFactory.eINSTANCE.createEPackage();
		dest.setName("name");
		dest.setNsPrefix("name");
		dest.setNsURI("http:///com.eu.evidence.rtdruid.test.ecore");
		{
			ebu.createClass(dest, "EClass1");
			ebu.createClass(dest, "EClass2");
		}

		EPackage copy = EcoreUtil.copy(dest);

		assertEquals(dest.getEClassifiers().size(), 2);
		assertEquals(copy.getEClassifiers().size(), 2);
		
		EClassifier d_c1 = dest.getEClassifier("EClass1");
		EClassifier c_c1 = copy.getEClassifier("EClass1");
		EClassifier d_c2 = dest.getEClassifier("EClass2");
		EClassifier c_c2 = copy.getEClassifier("EClass2");
		
		assertNotNull(d_c1);
		assertTrue(d_c1 instanceof EClass);
		assertNotNull(c_c1);
		assertTrue(c_c1 instanceof EClass);
		assertNotNull(d_c2);
		assertTrue(d_c2 instanceof EClass);
		assertNotNull(c_c2);
		assertTrue(c_c2 instanceof EClass);

		assertNotSame(d_c1, c_c1);
		assertNotSame(d_c2, c_c2);
		
		assertTrue("EClass1".equals(d_c1.getName()));
		assertTrue("EClass1".equals(c_c1.getName()));
		assertTrue("EClass2".equals(d_c2.getName()));
		assertTrue("EClass2".equals(c_c2.getName()));

		assertTrue(EcoreUtil.equals(dest, copy));
		
		EClassifier d_c3 = dest.getEClassifier("EClass3");
		EClassifier c_c3 = copy.getEClassifier("EClass3");
		
		assertNull(d_c3);
		assertNull(c_c3);
	}
	

	@Test
	public void testSingle() throws RTDEPackageBuildException, IOException {

		EPackage input = EcoreFactory.eINSTANCE.createEPackage();
		{
			input.setName("input");
			input.setNsPrefix("input");
			input.setNsURI("http:///com.eu.evidence.rtdruid.test.input.ecore");
			ebu.createClass(input, "EClass1");
			ebu.createClass(input, "EClass2");
		}
		
		EPackage input_copy = EcoreUtil.copy(input); 

		
//		System.out.println(">>INPUT1 \n" + ebu.modelToString(input)+"\n<<");
//		System.out.println(">>INPUT2 \n" + ebu.modelToString(addition)+"\n<<");
		IEPackageMerge merger = getMerge();
		merger.addEPackage(input);
		EPackage result = merger.getResult();
		
//		System.out.println(">>INPUT1 \n" + ebu.modelToString(input)+"\n<<");
//		System.out.println(">>INPUT2 \n" + ebu.modelToString(addition)+"\n<<");
//		System.out.println(">>RESULT \n" + ebu.modelToString(result)+"\n<<");
//		System.out.println(">>CHECK \n" + ebu.modelToString(check)+"\n<<");
		
		assertTrue(EcoreUtil.equals(input, input_copy));
		assertTrue(EcoreUtil.equals(input, result));
	}

	@Test
	public void testEmpty1() throws RTDEPackageBuildException, IOException {

		EPackage empty = EcoreFactory.eINSTANCE.createEPackage();

		IEPackageMerge merger = getMerge();
		merger.addEPackage(empty);
		EPackage result = merger.getResult();
		
		assertTrue(EcoreUtil.equals(empty, EcoreFactory.eINSTANCE.createEPackage()));
		assertTrue(EcoreUtil.equals(empty, result));
	}

	@Test
	public void testEmpty2() throws RTDEPackageBuildException, IOException {

		EPackage empty = EcoreFactory.eINSTANCE.createEPackage();
		EPackage input = EcoreFactory.eINSTANCE.createEPackage();
		{
			input.setName("input");
			input.setNsPrefix("input");
			input.setNsURI("http:///com.eu.evidence.rtdruid.test.input.ecore");
			ebu.createClass(input, "EClass1");
			ebu.createClass(input, "EClass2");
		}
		
		EPackage input_copy = EcoreUtil.copy(input); 

		
//		System.out.println(">>INPUT1 \n" + ebu.modelToString(input)+"\n<<");
//		System.out.println(">>INPUT2 \n" + ebu.modelToString(addition)+"\n<<");
		IEPackageMerge merger = getMerge();
		merger.addEPackage(empty);
		merger.addEPackage(input);
		EPackage result = merger.getResult();
		
		System.out.println(">>INPUT1 \n" + ebu.modelToString(input)+"\n<<");
//		System.out.println(">>INPUT2 \n" + ebu.modelToString(addition)+"\n<<");
		System.out.println(">>RESULT \n" + ebu.modelToString(result)+"\n<<");
//		System.out.println(">>CHECK \n" + ebu.modelToString(check)+"\n<<");
		
		assertTrue(EcoreUtil.equals(input, input_copy));
		assertTrue(EcoreUtil.equals(input, result));
	}

	
	@Test
	public void testVerySimple() throws RTDEPackageBuildException, IOException {

		EPackage input = EcoreFactory.eINSTANCE.createEPackage();
		{
			input.setName("input");
			input.setNsPrefix("input");
			input.setNsURI("http:///com.eu.evidence.rtdruid.test.input.ecore");
			ebu.createClass(input, "EClass1");
			ebu.createClass(input, "EClass2");
		}
		EPackage addition = EcoreFactory.eINSTANCE.createEPackage();
		{
			addition.setName("dest");
			addition.setNsPrefix("dest");
			addition.setNsURI("http:///com.eu.evidence.rtdruid.test.dest.ecore");
		
			ebu.createClass(addition, "EClass1");
			ebu.createClass(addition, "EClass3");
		}
		EPackage check = EcoreFactory.eINSTANCE.createEPackage();
		{
			check.setName("input");
			check.setNsPrefix("input");
			check.setNsURI("http:///com.eu.evidence.rtdruid.test.input.ecore");
		
			ebu.createClass(check, "EClass1");
			ebu.createClass(check, "EClass2");
			ebu.createClass(check, "EClass3");
		}
		EPackage input_copy = EcoreUtil.copy(input); 
		EPackage dest_copy = EcoreUtil.copy(addition); 
	
		System.out.println(">>INPUT1 \n" + ebu.modelToString(input)+"\n<<");
		System.out.println(">>INPUT2 \n" + ebu.modelToString(addition)+"\n<<");
		IEPackageMerge merger = getMerge();
		merger.addEPackage(input);
		merger.addEPackage(addition);
		EPackage result = merger.getResult();
		
//		System.out.println(">>INPUT1 \n" + ebu.modelToString(input)+"\n<<");
//		System.out.println(">>INPUT2 \n" + ebu.modelToString(addition)+"\n<<");
		System.out.println(">>RESULT \n" + ebu.modelToString(result)+"\n<<");
		System.out.println(">>CHECK \n" + ebu.modelToString(check)+"\n<<");
		
		assertTrue(EcoreUtil.equals(input, input_copy));
		assertTrue(EcoreUtil.equals(addition, dest_copy));
		assertFalse(EcoreUtil.equals(input, result));
		assertFalse(EcoreUtil.equals(addition, result));
		assertTrue(EcoreUtil.equals(check, result));
	}
	
	@Test
	public void testSimple() throws RTDEPackageBuildException, IOException {

		EPackage input = EcoreFactory.eINSTANCE.createEPackage();
		{
			input.setName("input");
			input.setNsPrefix("input");
			input.setNsURI("http:///com.eu.evidence.rtdruid.test.input.ecore");
			ebu.createClass(input, "EClass1");
			ebu.createClass(input, "EClass2");
			ebu.addAttribute(ebu.createClass(input, "EClass4"), "attr_input");
		}
		EPackage dest = EcoreFactory.eINSTANCE.createEPackage();
		{
			dest.setName("dest");
			dest.setNsPrefix("dest");
			dest.setNsURI("http:///com.eu.evidence.rtdruid.test.dest.ecore");
		
			ebu.createClass(dest, "EClass1");
			ebu.createClass(dest, "EClass3");
			ebu.addAttribute(ebu.createClass(dest, "EClass4"), "attr_dest");
		}
		EPackage check = EcoreFactory.eINSTANCE.createEPackage();
		{
			check.setName("input");
			check.setNsPrefix("input");
			check.setNsURI("http:///com.eu.evidence.rtdruid.test.input.ecore");
		
			ebu.createClass(check, "EClass1");
			ebu.createClass(check, "EClass2");
			EClass c4 = ebu.createClass(check, "EClass4");
			ebu.addAttribute(c4, "attr_input");
			ebu.addAttribute(c4, "attr_dest");
			ebu.createClass(check, "EClass3");
		}
		/* Note that check2 contains the same elements of check and produces the same JavaCode,
		 * but for EcoreUtils.equals method they are different*/
		EPackage check2 = EcoreFactory.eINSTANCE.createEPackage();
		{
			check2.setName("input");
			check2.setNsPrefix("input");
			check2.setNsURI("http:///com.eu.evidence.rtdruid.test.input.ecore");
		
			ebu.createClass(check2, "EClass1");
			ebu.createClass(check2, "EClass2");
			ebu.createClass(check2, "EClass3");
			EClass c4 = ebu.createClass(check2, "EClass4");
			ebu.addAttribute(c4, "attr_input");
			ebu.addAttribute(c4, "attr_dest");
		}
		assertFalse(EcoreUtil.equals(check, check2));
		
		
		EPackage input_copy = EcoreUtil.copy(input); 
		EPackage dest_copy = EcoreUtil.copy(dest); 
		EPackage check_copy = EcoreUtil.copy(check); 

		
//		System.out.println(">>INPUT \n" + ebu.modelToString(input)+"\n<<");
//		System.out.println(">>DEST \n" + ebu.modelToString(dest)+"\n<<");
		IEPackageMerge merger = getMerge();
		merger.addEPackage(input);
		merger.addEPackage(dest);
		EPackage result = merger.getResult();
		
//		System.out.println(">>INPUT \n" + ebu.modelToString(input)+"\n<<");
//		System.out.println(">>DEST \n" + ebu.modelToString(dest)+"\n<<");
//		System.out.println(">>RESULT \n" + ebu.modelToString(result)+"\n<<");
//		System.out.println(">>CHECK \n" + ebu.modelToString(check)+"\n<<");
		
		assertTrue(EcoreUtil.equals(input, input_copy));
		assertTrue(EcoreUtil.equals(dest, dest_copy));
		assertTrue(EcoreUtil.equals(check, check_copy));
		assertFalse(EcoreUtil.equals(input, result));
		assertFalse(EcoreUtil.equals(dest, result));
		assertTrue(EcoreUtil.equals(check, result));
		assertFalse(EcoreUtil.equals(check2, result));
	}

	@Test
	public void testSameReference() throws RTDEPackageBuildException, IOException {

		EPackage input = EcoreFactory.eINSTANCE.createEPackage();
		{
			input.setName("input");
			input.setNsPrefix("input");
			input.setNsURI("http:///com.eu.evidence.rtdruid.test.input.ecore");
			EClass c1 = ebu.createClass(input, "EClass1");
			ebu.createClass(input, "EClass2");
			EClass c4 = ebu.createClass(input, "EClass4");
			ebu.addAttribute(c4, "attr_input");
			ebu.addReference(c1, "c1ref", c4);
		}
		EPackage dest = EcoreFactory.eINSTANCE.createEPackage();
		{
			dest.setName("dest");
			dest.setNsPrefix("dest");
			dest.setNsURI("http:///com.eu.evidence.rtdruid.test.dest.ecore");
		
			EClass c1 = ebu.createClass(dest, "EClass1");
			ebu.createClass(dest, "EClass3");
			EClass c4 = ebu.createClass(dest, "EClass4");
			ebu.addAttribute(c4, "attr_dest");
			ebu.addReference(c1, "c1ref", c4);
		}
		EPackage check = EcoreFactory.eINSTANCE.createEPackage();
		{
			check.setName("input");
			check.setNsPrefix("input");
			check.setNsURI("http:///com.eu.evidence.rtdruid.test.input.ecore");
		
			EClass c1 = ebu.createClass(check, "EClass1");
			ebu.createClass(check, "EClass2");
			EClass c4 = ebu.createClass(check, "EClass4");
			ebu.addAttribute(c4, "attr_input");
			ebu.addAttribute(c4, "attr_dest");
			ebu.createClass(check, "EClass3");
			
			ebu.addReference(c1, "c1ref", c4);
			
		}
		
		EPackage input_copy = EcoreUtil.copy(input); 
		EPackage dest_copy = EcoreUtil.copy(dest); 
		EPackage check_copy = EcoreUtil.copy(check); 

		
//		System.out.println(">>INPUT \n" + ebu.modelToString(input)+"\n<<");
//		System.out.println(">>DEST \n" + ebu.modelToString(dest)+"\n<<");
		IEPackageMerge merger = getMerge();
		merger.addEPackage(input);
		merger.addEPackage(dest);
		EPackage result = merger.getResult();
		
		System.out.println(">>INPUT \n" + ebu.modelToString(input)+"\n<<");
		System.out.println(">>DEST \n" + ebu.modelToString(dest)+"\n<<");
		System.out.println(">>RESULT \n" + ebu.modelToString(result)+"\n<<");
		System.out.println(">>CHECK \n" + ebu.modelToString(check)+"\n<<");
		
		assertTrue(EcoreUtil.equals(input, input_copy));
		assertTrue(EcoreUtil.equals(dest, dest_copy));
		assertTrue(EcoreUtil.equals(check, check_copy));
		assertFalse(EcoreUtil.equals(input, result));
		assertFalse(EcoreUtil.equals(dest, result));
		assertTrue(EcoreUtil.equals(check, result));
	}


	/**
	 * This test checks when one or more attribute are missing
	 * 
	 * @throws RTDEPackageBuildException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test
	public void testMissingAttributes()  throws RTDEPackageBuildException, IOException, InterruptedException {
		EPackage input1 = EcoreFactory.eINSTANCE.createEPackage();
		input1.setName("rtdruid");
		input1.setNsPrefix("com.eu.evidence.rtdruid.data");
		input1.setNsURI("http://www.evidence.eu.com/rtdruid/data");
		{
			EClass e_obj = ebu.createEmptyClass(input1, "ObjectWithID");
			EClass e_tsk = ebu.createEmptyClass(input1, "Task");
			EGenericType newEGenericType = EcoreFactory.eINSTANCE.createEGenericType();
		    newEGenericType.setEClassifier(e_obj);
			e_obj.setAbstract(true);
			e_tsk.getEGenericSuperTypes().add(EcoreUtil.copy(newEGenericType));
		}
		EPackage input2 = EcoreFactory.eINSTANCE.createEPackage();
		input2.setName("rtdruid");
		input2.setNsPrefix("com.eu.evidence.rtdruid.data");
		input2.setNsURI("http://www.evidence.eu.com/rtdruid/data");
		{
			EClass e_tsk = ebu.createEmptyClass(input2, "Task");
			ebu.addAttribute(e_tsk, "Task1");
		}
		EPackage check = EcoreFactory.eINSTANCE.createEPackage();
		check.setName("rtdruid");
		check.setNsPrefix("com.eu.evidence.rtdruid.data");
		check.setNsURI("http://www.evidence.eu.com/rtdruid/data");
		{
			EClass e_obj = ebu.createEmptyClass(check, "ObjectWithID");
			EClass e_tsk = ebu.createEmptyClass(check, "Task");
			ebu.addAttribute(e_tsk, "Task1");
			EGenericType newEGenericType = EcoreFactory.eINSTANCE.createEGenericType();
		    newEGenericType.setEClassifier(e_obj);
			e_obj.setAbstract(true);
			e_tsk.getEGenericSuperTypes().add(EcoreUtil.copy(newEGenericType));
		}
		
		IEPackageMerge merger = getMerge();
		merger.addEPackage(input1);
		merger.addEPackage(input2);
		EPackage result = merger.getResult();
		
		System.out.println(">>CHECK \n" + ebu.modelToString(check)+"\n<<");
		System.out.println(">>RESULT \n" + ebu.modelToString(result)+"\n<<");
		
		
		assertTrue(EcoreUtil.equals(result, check));
	}

	
	@Test
	public void testTypes()  throws RTDEPackageBuildException, IOException, InterruptedException {
		EPackage input1 = EcoreFactory.eINSTANCE.createEPackage();
		input1.setName("rtdruid");
		input1.setNsPrefix("com.eu.evidence.rtdruid.data");
		input1.setNsURI("http://www.evidence.eu.com/rtdruid/data");
		{
			EClass e_sys = ebu.createEmptyClass(input1, "System");
			EClass e_obj = ebu.createEmptyClass(input1, "ObjectWithID");
			EClass e_arc = ebu.createEmptyClass(input1, "Architectural");
			EClass e_tsk = ebu.createEmptyClass(input1, "Task");
			EClass e_cpu = ebu.createEmptyClass(input1, "Cpu");
			EDataType sVar = ebu.addType(input1, "StringVar", "com.eu.evidence.rtdruid.vartree.variables.StringVar");
			EGenericType newEGenericType = EcoreFactory.eINSTANCE.createEGenericType();
		    newEGenericType.setEClassifier(e_obj);
			e_sys.getEGenericSuperTypes().add(EcoreUtil.copy(newEGenericType));
			e_obj.setAbstract(true);
			e_arc.getEGenericSuperTypes().add(EcoreUtil.copy(newEGenericType));
			
			e_cpu.getEGenericSuperTypes().add(EcoreUtil.copy(newEGenericType));
			e_tsk.getEGenericSuperTypes().add(EcoreUtil.copy(newEGenericType));
			ebu.addAttribute(e_tsk, "Task1").setEType(sVar);
		}
		EPackage input2 = EcoreFactory.eINSTANCE.createEPackage();
		input2.setName("rtdruid");
		input2.setNsPrefix("com.eu.evidence.rtdruid.data");
		input2.setNsURI("http://www.evidence.eu.com/rtdruid/data");
		{
			EClass e_sys = ebu.createEmptyClass(input2, "System");
			EClass e_obj = ebu.createEmptyClass(input2, "ObjectWithID");
			EClass e_arc = ebu.createEmptyClass(input2, "Architectural");
			EClass e_isr = ebu.createEmptyClass(input2, "Isr");
			EClass e_tsk = ebu.createEmptyClass(input2, "Task");
			EDataType sVar = ebu.addType(input2, "StringVar", "com.eu.evidence.rtdruid.vartree.variables.StringVar");
			EGenericType newEGenericType = EcoreFactory.eINSTANCE.createEGenericType();
		    newEGenericType.setEClassifier(e_obj);
			e_sys.getEGenericSuperTypes().add(EcoreUtil.copy(newEGenericType));
			e_obj.setAbstract(true);
			e_arc.getEGenericSuperTypes().add(EcoreUtil.copy(newEGenericType));
			
			e_isr.getEGenericSuperTypes().add(EcoreUtil.copy(newEGenericType));
			e_tsk.getEGenericSuperTypes().add(EcoreUtil.copy(newEGenericType));
			ebu.addAttribute(e_tsk, "Task2").setEType(sVar);
		}
		EPackage check = EcoreFactory.eINSTANCE.createEPackage();
		check.setName("rtdruid");
		check.setNsPrefix("com.eu.evidence.rtdruid.data");
		check.setNsURI("http://www.evidence.eu.com/rtdruid/data");
		{
			EClass e_sys = ebu.createEmptyClass(check, "System");
			EClass e_obj = ebu.createEmptyClass(check, "ObjectWithID");
			EClass e_arc = ebu.createEmptyClass(check, "Architectural");
			EClass e_tsk = ebu.createEmptyClass(check, "Task");
			EClass e_cpu = ebu.createEmptyClass(check, "Cpu");
			EDataType sVar = ebu.addType(check, "StringVar", "com.eu.evidence.rtdruid.vartree.variables.StringVar");
			EClass e_isr = ebu.createEmptyClass(check, "Isr");
			EGenericType newEGenericType = EcoreFactory.eINSTANCE.createEGenericType();
		    newEGenericType.setEClassifier(e_obj);
			e_sys.getEGenericSuperTypes().add(EcoreUtil.copy(newEGenericType));
			e_obj.setAbstract(true);
			e_arc.getEGenericSuperTypes().add(EcoreUtil.copy(newEGenericType));
			
			e_cpu.getEGenericSuperTypes().add(EcoreUtil.copy(newEGenericType));
			e_isr.getEGenericSuperTypes().add(EcoreUtil.copy(newEGenericType));
			e_tsk.getEGenericSuperTypes().add(EcoreUtil.copy(newEGenericType));
			ebu.addAttribute(e_tsk, "Task1").setEType(sVar);
			ebu.addAttribute(e_tsk, "Task2").setEType(sVar);
		}
		
		IEPackageMerge merger = getMerge();
		merger.addEPackage(input1);
		merger.addEPackage(input2);
		EPackage result = merger.getResult();
		
		System.out.println(">>CHECK \n" + ebu.modelToString(check)+"\n<<");
		System.out.println(">>RESULT \n" + ebu.modelToString(result)+"\n<<");
		
		
		assertTrue(EcoreUtil.equals(result, check));
	}

	@Test
	public void testTypes2()  throws RTDEPackageBuildException, IOException, InterruptedException {
		EPackage input1 = EcoreFactory.eINSTANCE.createEPackage();
		input1.setName("rtdruid");
		input1.setNsPrefix("com.eu.evidence.rtdruid.data");
		input1.setNsURI("http://www.evidence.eu.com/rtdruid/data");
		{
			EClass e_sys = ebu.createEmptyClass(input1, "System");
			EClass e_obj = ebu.createEmptyClass(input1, "ObjectWithID");
			EClass e_arc = ebu.createEmptyClass(input1, "Architectural");
			EClass e_tsk = ebu.createEmptyClass(input1, "Task");
			EClass e_cpu = ebu.createEmptyClass(input1, "Cpu");
			EDataType sVar = ebu.addType(input1, "StringVar", "com.eu.evidence.rtdruid.vartree.variables.StringVar");
			EGenericType newEGenericType = EcoreFactory.eINSTANCE.createEGenericType();
		    newEGenericType.setEClassifier(e_obj);
			e_sys.getEGenericSuperTypes().add(EcoreUtil.copy(newEGenericType));
			ebu.addReference(e_sys, "Architectural", e_arc).setContainment(true);
			e_obj.setAbstract(true);
			e_arc.getEGenericSuperTypes().add(EcoreUtil.copy(newEGenericType));
			{
				EReference tList = ebu.addReference(e_arc, "TaskList", e_tsk);
				tList.setContainment(true);
				tList.setLowerBound(1);
				tList.setUpperBound(ETypedElement.UNBOUNDED_MULTIPLICITY);
			}
			{
				EReference tList = ebu.addReference(e_arc, "CpuList", e_cpu);
				tList.setContainment(true);
				tList.setLowerBound(1);
				tList.setUpperBound(ETypedElement.UNBOUNDED_MULTIPLICITY);
			}
			
			e_cpu.getEGenericSuperTypes().add(EcoreUtil.copy(newEGenericType));
			e_tsk.getEGenericSuperTypes().add(EcoreUtil.copy(newEGenericType));
			ebu.addAttribute(e_tsk, "Task1").setEType(sVar);
		}
		EPackage input2 = EcoreFactory.eINSTANCE.createEPackage();
		input2.setName("rtdruid");
		input2.setNsPrefix("com.eu.evidence.rtdruid.data");
		input2.setNsURI("http://www.evidence.eu.com/rtdruid/data");
		{
			EClass e_sys = ebu.createEmptyClass(input2, "System");
			EClass e_obj = ebu.createEmptyClass(input2, "ObjectWithID");
			EClass e_arc = ebu.createEmptyClass(input2, "Architectural");
			EClass e_isr = ebu.createEmptyClass(input2, "Isr");
			EClass e_tsk = ebu.createEmptyClass(input2, "Task");
			EDataType sVar = ebu.addType(input2, "StringVar", "com.eu.evidence.rtdruid.vartree.variables.StringVar");
			EGenericType newEGenericType = EcoreFactory.eINSTANCE.createEGenericType();
		    newEGenericType.setEClassifier(e_obj);
			e_sys.getEGenericSuperTypes().add(EcoreUtil.copy(newEGenericType));
			ebu.addReference(e_sys, "Architectural", e_arc).setContainment(true);
			e_obj.setAbstract(true);
			e_arc.getEGenericSuperTypes().add(EcoreUtil.copy(newEGenericType));
			{
				EReference tList = ebu.addReference(e_arc, "TaskList", e_tsk);
				tList.setContainment(true);
				tList.setLowerBound(1);
				tList.setUpperBound(ETypedElement.UNBOUNDED_MULTIPLICITY);
			}
			{
				EReference tList = ebu.addReference(e_arc, "isrList", e_isr);
				tList.setContainment(true);
				tList.setLowerBound(1);
				tList.setUpperBound(ETypedElement.UNBOUNDED_MULTIPLICITY);
			}

			
			e_isr.getEGenericSuperTypes().add(EcoreUtil.copy(newEGenericType));
			e_tsk.getEGenericSuperTypes().add(EcoreUtil.copy(newEGenericType));
			ebu.addAttribute(e_tsk, "Task2").setEType(sVar);
		}
		EPackage check = EcoreFactory.eINSTANCE.createEPackage();
		check.setName("rtdruid");
		check.setNsPrefix("com.eu.evidence.rtdruid.data");
		check.setNsURI("http://www.evidence.eu.com/rtdruid/data");
		{
			EClass e_sys = ebu.createEmptyClass(check, "System");
			EClass e_obj = ebu.createEmptyClass(check, "ObjectWithID");
			EClass e_arc = ebu.createEmptyClass(check, "Architectural");
			EClass e_tsk = ebu.createEmptyClass(check, "Task");
			EClass e_cpu = ebu.createEmptyClass(check, "Cpu");
			EDataType sVar = ebu.addType(check, "StringVar", "com.eu.evidence.rtdruid.vartree.variables.StringVar");
			EClass e_isr = ebu.createEmptyClass(check, "Isr");
			EGenericType newEGenericType = EcoreFactory.eINSTANCE.createEGenericType();
		    newEGenericType.setEClassifier(e_obj);
			e_sys.getEGenericSuperTypes().add(EcoreUtil.copy(newEGenericType));
			ebu.addReference(e_sys, "Architectural", e_arc).setContainment(true);
			e_obj.setAbstract(true);
			e_arc.getEGenericSuperTypes().add(EcoreUtil.copy(newEGenericType));
			{
				EReference tList = ebu.addReference(e_arc, "TaskList", e_tsk);
				tList.setContainment(true);
				tList.setLowerBound(1);
				tList.setUpperBound(ETypedElement.UNBOUNDED_MULTIPLICITY);
			}
			{
				EReference tList = ebu.addReference(e_arc, "CpuList", e_cpu);
				tList.setContainment(true);
				tList.setLowerBound(1);
				tList.setUpperBound(ETypedElement.UNBOUNDED_MULTIPLICITY);
			}
			{
				EReference tList = ebu.addReference(e_arc, "isrList", e_isr);
				tList.setContainment(true);
				tList.setLowerBound(1);
				tList.setUpperBound(ETypedElement.UNBOUNDED_MULTIPLICITY);
			}

			
			e_cpu.getEGenericSuperTypes().add(EcoreUtil.copy(newEGenericType));
			e_isr.getEGenericSuperTypes().add(EcoreUtil.copy(newEGenericType));
			e_tsk.getEGenericSuperTypes().add(EcoreUtil.copy(newEGenericType));
			ebu.addAttribute(e_tsk, "Task1").setEType(sVar);
			ebu.addAttribute(e_tsk, "Task2").setEType(sVar);
		}
		
		IEPackageMerge merger = getMerge();
		merger.addEPackage(input1);
		merger.addEPackage(input2);
		EPackage result = merger.getResult();
		
		System.out.println(">>CHECK \n" + ebu.modelToString(check)+"\n<<");
		System.out.println(">>RESULT \n" + ebu.modelToString(result)+"\n<<");
		
		
		assertTrue(EcoreUtil.equals(result, check));
	}

	@Test
	public void testOrder() throws RTDEPackageBuildException, IOException {

		EPackage pkg1 = EcoreFactory.eINSTANCE.createEPackage();
		{
			pkg1.setName("input");
			pkg1.setNsPrefix("input");
			pkg1.setNsURI("http:///com.eu.evidence.rtdruid.test.input.ecore");
		
			ebu.createClass(pkg1, "EClass1");
			ebu.createClass(pkg1, "EClass2");
			EClass c4 = ebu.createClass(pkg1, "EClass4");
			ebu.addAttribute(c4, "attr_input");
			ebu.addAttribute(c4, "attr_dest");
			ebu.createClass(pkg1, "EClass3");
		}
		/* Note that check2 contains the same elements of check and produces the same JavaCode,
		 * but for EcoreUtils.equals method they are different*/
		EPackage pkg2 = EcoreFactory.eINSTANCE.createEPackage();
		{
			pkg2.setName("input");
			pkg2.setNsPrefix("input");
			pkg2.setNsURI("http:///com.eu.evidence.rtdruid.test.input.ecore");
		
			ebu.createClass(pkg2, "EClass1");
			ebu.createClass(pkg2, "EClass2");
			ebu.createClass(pkg2, "EClass3");
			EClass c4 = ebu.createClass(pkg2, "EClass4");
			ebu.addAttribute(c4, "attr_input");
			ebu.addAttribute(c4, "attr_dest");
		}
		assertFalse(EcoreUtil.equals(pkg1, pkg2));
		
		
		EPackage pkg1_c = EcoreUtil.copy(pkg1); 
		EPackage pkg2_c = EcoreUtil.copy(pkg2); 

		EPackage result1;
		{
			IEPackageMerge merger = getMerge();
			merger.addEPackage(pkg1);
			merger.addEPackage(pkg2);
			result1 = merger.getResult();
		}
		assertTrue(EcoreUtil.equals(pkg1, pkg1_c));
		assertTrue(EcoreUtil.equals(pkg2, pkg2_c));
		EPackage result2;
		{
			IEPackageMerge merger = getMerge();
			merger.addEPackage(pkg2);
			merger.addEPackage(pkg1);
			result2 = merger.getResult();
		}
		assertTrue(EcoreUtil.equals(pkg1, pkg1_c));
		assertTrue(EcoreUtil.equals(pkg2, pkg2_c));
		
//		System.out.println(">>INPUT \n" + ebu.modelToString(input)+"\n<<");
//		System.out.println(">>DEST \n" + ebu.modelToString(dest)+"\n<<");
//		System.out.println(">>RESULT \n" + ebu.modelToString(result)+"\n<<");
//		System.out.println(">>CHECK \n" + ebu.modelToString(pkg1)+"\n<<");
		
		assertTrue(EcoreUtil.equals(pkg1, result1));
		assertFalse(EcoreUtil.equals(pkg1, result2));
		assertFalse(EcoreUtil.equals(pkg2, result1));
		assertTrue(EcoreUtil.equals(pkg2, result2));
	}

	@Test
	public void testReallyEmpty() throws RTDEPackageBuildException, IOException {
		IEPackageMerge merger = getMerge();
		assertNull(merger.getResult());
	}

	
	@Test(expected=IllegalStateException.class)
	public void testThrow1() throws RTDEPackageBuildException, IOException {
		EPackage empty = EcoreFactory.eINSTANCE.createEPackage();
		IEPackageMerge merger = getMerge();
		merger.addEPackage(empty); 
		merger.getResult();
		merger.addEPackage(empty);
	}
	
	@Test(expected=NullPointerException.class)
	public void testThrowNull() throws RTDEPackageBuildException, IOException {
		IEPackageMerge merger = getMerge();
		merger.addEPackage(null); 
	}
	
	@Test(expected=NullPointerException.class)
	public void testThrowNull2() throws RTDEPackageBuildException, IOException {
		EPackage empty = EcoreFactory.eINSTANCE.createEPackage();
		IEPackageMerge merger = getMerge();
		merger.addEPackage(empty); 
		merger.getResult();
		merger.addEPackage(null);
	}

	@Test(expected=RTDEPackageBuildException.class)
	public void testCollision() throws RTDEPackageBuildException, IOException {

		EPackage input1 = EcoreFactory.eINSTANCE.createEPackage();
		{
			input1.setName("input");
			input1.setNsPrefix("input");
			input1.setNsURI("http:///com.eu.evidence.rtdruid.test.input.ecore");
			EClass c1 = ebu.createClass(input1, "EClass1");
			EAttribute att = ebu.addAttribute(c1, "att1");
			att.setUpperBound(5);
		}
		
		EPackage input2 = EcoreFactory.eINSTANCE.createEPackage();
		{
			input2.setName("input");
			input2.setNsPrefix("input");
			input2.setNsURI("http:///com.eu.evidence.rtdruid.test.input.ecore");
			EClass c1 = ebu.createClass(input2, "EClass1");
			EAttribute att = ebu.addAttribute(c1, "att1");
			att.setUpperBound(2);
		}
		IEPackageMerge merger = getMerge();
		merger.addEPackage(input1);
		merger.addEPackage(input2);
	}
}
