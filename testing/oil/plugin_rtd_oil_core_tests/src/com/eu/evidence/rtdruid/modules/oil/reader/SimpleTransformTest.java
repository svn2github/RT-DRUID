/*
 * Created on Jan 18, 2005
 *
 * $Id: SimpleTransformTest.java,v 1.6 2008/03/26 18:23:51 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.reader;


import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Ignore;
import org.junit.Test;

import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.internal.modules.oil.reader.OilReader;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.CommonUtils;
import com.eu.evidence.rtdruid.modules.oil.implementation.IOilImplID;
import com.eu.evidence.rtdruid.modules.oil.transform.OilTransformFactory;
import com.eu.evidence.rtdruid.modules.oil.transform.SimpleTransform;
import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.VarTreeUtil;
import com.eu.evidence.rtdruid.vartree.Vt2StringUtilities;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.tools.Search;

/**
 *
 * Tests about tranformation: load and write Oil  
 *
 * @author Nicola Serreli
 */
public class SimpleTransformTest implements Examples {

	final static private String S = "" + DataPath.SEPARATOR;
	final static protected String DEFAULT_CPU_NAME = IWritersKeywords.DEFAULT_CPU_NAME;

	
	@Test
	public void testOilWrite1() throws IOException {
		IVarTree vt = VarTreeUtil.newVarTree();
		
		OilTransformFactory otf = OilTransformFactory.INSTANCE;
		(new OilReader()).load(new ByteArrayInputStream(OIL_TEST_ARM7.getBytes()),
				vt, null, null);
//		System.out.println(EPackageUtility.instance.modelToString(VarTreeUtil.getRtDruidEPackage(vt)));
		DataPackage dpkg = DataPackage.eINSTANCE;
		String prefix = "EE" + S + dpkg.getSystem_Architectural().getName() + S
				+ dpkg.getArchitectural_EcuList().getName() + S + "EE" + S
				+ dpkg.getEcu_CpuList().getName() + S + DEFAULT_CPU_NAME + S
				+ dpkg.getCpu_Rtos().getName();
		IOilImplID id = otf.getOilId("ee");
		//System.out.println(Vt2StringUtilities.explodeOilVar(Vt2StringUtilities.varTreeToStringErtd(vt)));
		System.out.println(Vt2StringUtilities.varTreeToStringErtd(vt));
		String answer = otf.getTransform("ee").write(vt, id, prefix);

		assertNotNull(answer);
		System.out.println(answer);

		// --------------------
		IVarTree vt2 = VarTreeUtil.newVarTree();
		//(new OilReader()).load(new ByteArrayInputStream(OIL_TEST_WITH_RESOURCE.getBytes()),
		//		vt2);

		vt2 = VarTreeUtil.newVarTree();
		(new OilReader()).load(new ByteArrayInputStream(answer.getBytes()),
				vt2, null, null);
		
		String t = VarTreeUtil.compare(
				(EObject) ((Resource) vt.getResourceSet().getResources().get(0)).getContents().get(0),
				(EObject) ((Resource) vt2.getResourceSet().getResources().get(0)).getContents().get(0)
		).getMessage(); assertNull(t, t);

	}


	@Test
	@Ignore
	public void testDefaultValue() {
		IVarTree vt = VarTreeUtil.newVarTree();
		OilTransformFactory otf = OilTransformFactory.INSTANCE;
		
		(new OilReader()).load(new ByteArrayInputStream(OIL_TEST_DEFAULT_VALUE.getBytes()),
				vt, null, null);

		System.out.println(Vt2StringUtilities.varTreeToString(vt));
		
		DataPackage dpkg = DataPackage.eINSTANCE;
		String prefix = "EE" + S + dpkg.getSystem_Architectural().getName() + S
				+ dpkg.getArchitectural_EcuList().getName() + S + "EE" + S
				+ dpkg.getEcu_CpuList().getName() + S + DEFAULT_CPU_NAME + S
				+ dpkg.getCpu_Rtos().getName();
		IOilImplID id = otf.getOilId("ee");

		
		String answer = otf.getTransform("ee").write(vt, id, prefix);

		assertNotNull(answer);
		System.out.println(answer);

		// --------------------
		IVarTree vt2 = VarTreeUtil.newVarTree();
		//(new OilReader()).load(new
		// ByteArrayInputStream(OIL_TEST_WITH_RESOURCE.getBytes()),
		//		vt2);

		vt2 = VarTreeUtil.newVarTree();
		(new OilReader())
				.load(new ByteArrayInputStream(answer.getBytes()), vt2, null, null);

		String t = VarTreeUtil.compare((EObject) ((Resource) vt.getResourceSet()
				.getResources().get(0)).getContents().get(0),
				(EObject) ((Resource) vt2.getResourceSet().getResources()
						.get(0)).getContents().get(0)).getMessage(); assertTrue(t, t== null);

		// attenzione : come gestire i valori di default? dome memorizzarli?
		throw new RuntimeException("come gestire i valori di default? dome memorizzarli?");
	}

	
	@Test
	public void testOilWriteWithResources() {
		IVarTree vt = VarTreeUtil.newVarTree();
		OilTransformFactory otf = OilTransformFactory.INSTANCE;
		(new OilReader()).load(new ByteArrayInputStream(OIL_TEST_WITH_RESOURCE.getBytes()),
				vt, null, null);
		
		DataPackage dpkg = DataPackage.eINSTANCE;
		String prefix = "test_application" + S + dpkg.getSystem_Architectural().getName() + S
				+ dpkg.getArchitectural_EcuList().getName() + S + "test_application" + S
				+ dpkg.getEcu_CpuList().getName() + S + DEFAULT_CPU_NAME + S
				+ dpkg.getCpu_Rtos().getName();
		IOilImplID id = otf.getOilId("ee");

		String answer = otf.getTransform("ee").write(vt, id, prefix);
		
		assertNotNull(answer);
		System.out.println(answer);
		
		// --------------------
		IVarTree vt2 = VarTreeUtil.newVarTree();
		//(new OilReader()).load(new ByteArrayInputStream(OIL_TEST_WITH_RESOURCE.getBytes()),
		//		vt2);

		vt2 = VarTreeUtil.newVarTree();
		(new OilReader()).load(new ByteArrayInputStream(answer.getBytes()),
				vt2, null, null);
		
		String t = VarTreeUtil.compare(
				(EObject) ((Resource) vt.getResourceSet().getResources().get(0)).getContents().get(0),
				(EObject) ((Resource) vt2.getResourceSet().getResources().get(0)).getContents().get(0)
		).getMessage(); assertTrue(t, t== null);

	}


	@Test
	public void testOilWriteWithTwoCpu() {
		IVarTree vt = VarTreeUtil.newVarTree();
		OilTransformFactory otf = OilTransformFactory.INSTANCE;
		(new OilReader()).load(new ByteArrayInputStream(OIL_TEST_2_NIOS.getBytes()),
				vt, null, null);
		
		System.out.println(OIL_TEST_2_NIOS);
		
		System.out.println(Vt2StringUtilities.varTreeToString(vt));

		
		DataPackage dpkg = DataPackage.eINSTANCE;
		String prefix1 = "EE" + S + dpkg.getSystem_Architectural().getName() + S
				+ dpkg.getArchitectural_EcuList().getName() + S + "EE" + S
				+ dpkg.getEcu_CpuList().getName() + S + "cpu1" + S
				+ dpkg.getCpu_Rtos().getName();
		String prefix2 = "EE" + S + dpkg.getSystem_Architectural().getName() + S
				+ dpkg.getArchitectural_EcuList().getName() + S + "EE" + S
				+ dpkg.getEcu_CpuList().getName() + S + "cpu2" + S
				+ dpkg.getCpu_Rtos().getName();
		IOilImplID id = otf.getOilId("ee");

		String answer = otf.getTransform("ee").write(vt, id, new String[] {prefix1, prefix2});
		
		assertNotNull(answer);
		System.out.println(answer);
		
		// --------------------
		IVarTree vt2 = VarTreeUtil.newVarTree();
		//(new OilReader()).load(new ByteArrayInputStream(OIL_TEST_2_NIOS.getBytes()),
		//		vt2);

		vt2 = VarTreeUtil.newVarTree();
		(new OilReader()).load(new ByteArrayInputStream(answer.getBytes()),
				vt2, null, null);
		
		System.out.println(Vt2StringUtilities.varTreeToString(vt2));

		String t = VarTreeUtil.compare(
				(EObject) ((Resource) vt.getResourceSet().getResources().get(0)).getContents().get(0),
				(EObject) ((Resource) vt2.getResourceSet().getResources().get(0)).getContents().get(0)
		).getMessage(); assertTrue(t, t== null);

	}

	
	
	@Test
	public void testOilWriteWithISR() {
	    final String text = "CPU test_application {\n" +
		"\n" +
		"	OS EE {		\n" +
		"		EE_OPT = \"__ASSERT__\";\n" +
		"		CFLAGS = \"-g2\";\n" +
		"\n" +
		"		CPU_DATA = LM32 {\n" +
		"			APP_SRC = \"main.c\";\n" +
		"			MULTI_STACK = FALSE;\n" +
		"			USESTANDALONEPRINTF = TRUE; // Optional, default is FALSE\n" +
		"			USESMALLC = FALSE; // Optional, default is FALSE\n" +
		"		};\n" +
		"		\n" +
		"\n" +
		"		MCU_DATA = LATTICE_PLATFORM {\n" +
		"   			MODEL = LIBRARY {\n" +
		"				PLATFORM_LIB_PATH = \"../onchipramtimer_lib\";\n" +
		"				PLATFORM_NAME = \"onchipramtimer\";\n" +
		"				PLATFORM_BLD_CFG = \"Release\"; // Optional, default is \"\"\n" +
		"   			};\n" +
		"  		};\n" +
		"\n" +
		"		STATUS = EXTENDED;\n" +
		"		STARTUPHOOK = FALSE;\n" +
		"		ERRORHOOK = FALSE;\n" +
		"		SHUTDOWNHOOK = FALSE;\n" +
		"		PRETASKHOOK = FALSE;\n" +
		"		POSTTASKHOOK = FALSE;\n" +
		"		USEGETSERVICEID = FALSE;\n" +
		"		USEPARAMETERACCESS = FALSE;\n" +
		"		USERESSCHEDULER = FALSE;\n" +
		"	};\n" +
		"\n" +
		"	/* this is the OIL part for the first task */\n" +
		"	TASK Task1 {\n" +
		"		PRIORITY = 0x01;   /* Low priority */\n" +
		"		AUTOSTART = FALSE;\n" +
		"		STACK = SHARED;\n" +
		"		ACTIVATION = 1;    /* only one pending activation */\n" +
		"	};\n" +
		"\n" +
		"	ISR Timer_isr {\n" +
		"		CATEGORY = 2;		// Only category 2 is supported on Mico32\n" +
		"		LEVEL = \"TIMER_IRQ\";	// Could be also a number\n" +
		"		HANDLER = \"timer_interrupt\";	// IRQ handler\n" +
		"	};\n" +
		"	ISR irq12_isr {\n" +
		"		CATEGORY = 2;		// Only category 2 is supported on Mico32\n" +
		"		LEVEL = \"12\";	// Could be also a number\n" +
		"		HANDLER = \"irq12_interrupt\";	// IRQ handler\n" +
		"	};\n" +
		"	ISR Button_isr {\n" +
		"		CATEGORY = 2;		// Only category 2 is supported on Mico32\n" +
		"		LEVEL = \"BUTTON2_IRQ\";	// Could be also a number\n" +
		"		HANDLER = \"button2_interrupt\";	// IRQ handler\n" +
		"	};\n" +
		"\n" +
		"	COUNTER MainTimer;\n" +
		"	\n" +
		"	ALARM MyAlarm {\n" +
		"		COUNTER = \"MainTimer\";\n" +
		"		ACTION = ACTIVATETASK {\n" +
		"			TASK = \"Task1\";\n" +
		"		};\n" +
		"		/* Autstart is not supported on FP kernel! */\n" +
		"		AUTOSTART = FALSE;\n" +
		"	};\n" +
		"\n" +
		"	OS EE { KERNEL_TYPE = FP; }; 	\n" +
		"};";
		
		
		IVarTree vt = VarTreeUtil.newVarTree();
		OilTransformFactory otf = OilTransformFactory.INSTANCE;
		(new OilReader()).load(new ByteArrayInputStream(text.getBytes()),
				vt, null, null);
		
		String[] prefix = CommonUtils.getAllRtos(vt.newTreeInterface());

		IOilImplID id = otf.getOilId("ee");

		String answer = otf.getTransform("ee").write(vt, id, prefix[0]);
		
		assertNotNull(answer);
		System.out.println(answer);
		
		// --------------------
		IVarTree vt2 = VarTreeUtil.newVarTree();
		//(new OilReader()).load(new ByteArrayInputStream(OIL_TEST_WITH_RESOURCE.getBytes()),
		//		vt2);

		vt2 = VarTreeUtil.newVarTree();
		(new OilReader()).load(new ByteArrayInputStream(answer.getBytes()),
				vt2, null, null);
		
		String t = VarTreeUtil.compare(
				(EObject) ((Resource) vt.getResourceSet().getResources().get(0)).getContents().get(0),
				(EObject) ((Resource) vt2.getResourceSet().getResources().get(0)).getContents().get(0)
		).getMessage(); assertTrue(t, t== null);

	}

	
	@Test
	public void testOilOsApplications() {
	    final String text = "CPU test_application {\n" +
		"\n" +
		"	OS EE {		\n" +
		"		EE_OPT = \"__ASSERT__\";\n" +
		"		CFLAGS = \"-g2\";\n" +
		"\n" +
		"		CPU_DATA = LM32 {\n" +
		"			APP_SRC = \"main.c\";\n" +
		"			MULTI_STACK = FALSE;\n" +
		"			USESTANDALONEPRINTF = TRUE; // Optional, default is FALSE\n" +
		"			USESMALLC = FALSE; // Optional, default is FALSE\n" +
		"		};\n" +
		"		\n" +
		"\n" +
		"		MCU_DATA = LATTICE_PLATFORM {\n" +
		"   			MODEL = LIBRARY {\n" +
		"				PLATFORM_LIB_PATH = \"../onchipramtimer_lib\";\n" +
		"				PLATFORM_NAME = \"onchipramtimer\";\n" +
		"				PLATFORM_BLD_CFG = \"Release\"; // Optional, default is \"\"\n" +
		"   			};\n" +
		"  		};\n" +
		"\n" +
		"		STATUS = EXTENDED;\n" +
		"		STARTUPHOOK = FALSE;\n" +
		"		ERRORHOOK = FALSE;\n" +
		"		SHUTDOWNHOOK = FALSE;\n" +
		"		PRETASKHOOK = FALSE;\n" +
		"		POSTTASKHOOK = FALSE;\n" +
		"		USEGETSERVICEID = FALSE;\n" +
		"		USEPARAMETERACCESS = FALSE;\n" +
		"		USERESSCHEDULER = FALSE;\n" +
		"	};\n" +
		"\n" +
		"	/* this is the OIL part for the first task */\n" +
		"	TASK Task1 {\n" +
		"		PRIORITY = 0x01;   /* Low priority */\n" +
		"		AUTOSTART = FALSE;\n" +
		"		STACK = SHARED;\n" +
		"		ACTIVATION = 1;    /* only one pending activation */\n" +
		"	};\n" +
		"\n" +
		"	ISR Timer_isr {\n" +
		"		CATEGORY = 2;		// Only category 2 is supported on Mico32\n" +
		"		LEVEL = \"TIMER_IRQ\";	// Could be also a number\n" +
		"		HANDLER = \"timer_interrupt\";	// IRQ handler\n" +
		"	};\n" +
		"	APPLICATION myApplication;\n" +
		"	APPLICATION another_application;\n" +
		"\n" +
		"	COUNTER MainTimer;\n" +
		"	\n" +
		"	ALARM MyAlarm {\n" +
		"		COUNTER = \"MainTimer\";\n" +
		"		ACTION = ACTIVATETASK {\n" +
		"			TASK = \"Task1\";\n" +
		"		};\n" +
		"		/* Autstart is not supported on FP kernel! */\n" +
		"		AUTOSTART = FALSE;\n" +
		"	};\n" +
		"\n" +
		"	OS EE { KERNEL_TYPE = FP; }; 	\n" +
		"};";
		
		
		IVarTree vt = VarTreeUtil.newVarTree();
		OilTransformFactory otf = OilTransformFactory.INSTANCE;
		(new OilReader()).load(new ByteArrayInputStream(text.getBytes()),
				vt, null, null);
		
		String[] prefix = CommonUtils.getAllRtos(vt.newTreeInterface());

		IOilImplID id = otf.getOilId("ee");

		String answer = otf.getTransform("ee").write(vt, id, prefix[0]);
		
		assertNotNull(answer);
		System.out.println(answer);
		
		// --------------------
		IVarTree vt2 = VarTreeUtil.newVarTree();
		//(new OilReader()).load(new ByteArrayInputStream(OIL_TEST_WITH_RESOURCE.getBytes()),
		//		vt2);

		vt2 = VarTreeUtil.newVarTree();
		(new OilReader()).load(new ByteArrayInputStream(answer.getBytes()),
				vt2, null, null);
		
		System.out.print(Vt2StringUtilities.explodeOilVar(Vt2StringUtilities.varTreeToStringErtd(vt)));
		System.out.print(Vt2StringUtilities.explodeOilVar(Vt2StringUtilities.varTreeToStringErtd(vt2)));
		
		final char S = DataPath.SEPARATOR;
		final DataPackage DPKG = DataPackage.eINSTANCE;

		final String[] rtosPaths = Search.allRtos(vt.newTreeInterface());
		assertTrue(rtosPaths.length == 1);
		String[] split = DataPath.splitPath(rtosPaths[0]);
		System.out.println("Rtos Path : " + Arrays.asList(split));
		assertTrue(split.length == 7);
		ITreeInterface ti = vt.newTreeInterface();
		String[] names = ti.getAllName(
				split[0] //sysName
				+S+ DPKG.getArchitectural().getName()
				+S+ DPKG.getArchitectural_EcuList().getName()
				+S+ split[3]
				+S+ DPKG.getEcu_CpuList().getName()
				+S+ split[5]
				+S+ DPKG.getCpu_OsApplication().getName()
				, null);
		
		assertTrue(names.length == 2);
		
		System.out.println("OsApplication names : " + Arrays.asList(names));
		
		
		String t = VarTreeUtil.compare(
				(EObject) ((Resource) vt.getResourceSet().getResources().get(0)).getContents().get(0),
				(EObject) ((Resource) vt2.getResourceSet().getResources().get(0)).getContents().get(0)
		).getMessage(); assertTrue(t, t== null);
	}

	

	
	@Test
	public void testOilOsSpinLock() {
	    final String text = "CPU test_application {\n" +
		"\n" +
		"	OS EE {		\n" +
		"		EE_OPT = \"__ASSERT__\";\n" +
		"		CFLAGS = \"-g2\";\n" +
		"\n" +
		"		CPU_DATA = LM32 {\n" +
		"			APP_SRC = \"main.c\";\n" +
		"			MULTI_STACK = FALSE;\n" +
		"			USESTANDALONEPRINTF = TRUE; // Optional, default is FALSE\n" +
		"			USESMALLC = FALSE; // Optional, default is FALSE\n" +
		"		};\n" +
		"		\n" +
		"\n" +
		"		MCU_DATA = LATTICE_PLATFORM {\n" +
		"   			MODEL = LIBRARY {\n" +
		"				PLATFORM_LIB_PATH = \"../onchipramtimer_lib\";\n" +
		"				PLATFORM_NAME = \"onchipramtimer\";\n" +
		"				PLATFORM_BLD_CFG = \"Release\"; // Optional, default is \"\"\n" +
		"   			};\n" +
		"  		};\n" +
		"\n" +
		"		STATUS = EXTENDED;\n" +
		"		STARTUPHOOK = FALSE;\n" +
		"		ERRORHOOK = FALSE;\n" +
		"		SHUTDOWNHOOK = FALSE;\n" +
		"		PRETASKHOOK = FALSE;\n" +
		"		POSTTASKHOOK = FALSE;\n" +
		"		USEGETSERVICEID = FALSE;\n" +
		"		USEPARAMETERACCESS = FALSE;\n" +
		"		USERESSCHEDULER = FALSE;\n" +
		"	};\n" +
		"\n" +
		"	/* this is the OIL part for the first task */\n" +
		"	TASK Task1 {\n" +
		"		PRIORITY = 0x01;   /* Low priority */\n" +
		"		AUTOSTART = FALSE;\n" +
		"		STACK = SHARED;\n" +
		"		ACTIVATION = 1;    /* only one pending activation */\n" +
		"	};\n" +
		"\n" +
		"	ISR Timer_isr {\n" +
		"		CATEGORY = 2;		// Only category 2 is supported on Mico32\n" +
		"		LEVEL = \"TIMER_IRQ\";	// Could be also a number\n" +
		"		HANDLER = \"timer_interrupt\";	// IRQ handler\n" +
		"	};\n" +
		"	APPLICATION myApplication;\n" +
		"	APPLICATION another_application;\n" +
		"\n" +
		"	COUNTER MainTimer;\n" +
		"	SPINLOCK spin1;\n" +
		"	SPINLOCK spin2;\n" +

		"	\n" +
		"	ALARM MyAlarm {\n" +
		"		COUNTER = \"MainTimer\";\n" +
		"		ACTION = ACTIVATETASK {\n" +
		"			TASK = \"Task1\";\n" +
		"		};\n" +
		"		/* Autstart is not supported on FP kernel! */\n" +
		"		AUTOSTART = FALSE;\n" +
		"	};\n" +
		"\n" +
		"	OS EE { KERNEL_TYPE = FP; }; 	\n" +
		"};";
		
		
		IVarTree vt = VarTreeUtil.newVarTree();
		OilTransformFactory otf = OilTransformFactory.INSTANCE;
		(new OilReader()).load(new ByteArrayInputStream(text.getBytes()),
				vt, null, null);
		
		String[] prefix = CommonUtils.getAllRtos(vt.newTreeInterface());

		IOilImplID id = otf.getOilId("ee");

		String answer = otf.getTransform("ee").write(vt, id, prefix[0]);
		
		assertNotNull(answer);
		System.out.println(answer);
		
		// --------------------
		IVarTree vt2 = VarTreeUtil.newVarTree();
		//(new OilReader()).load(new ByteArrayInputStream(OIL_TEST_WITH_RESOURCE.getBytes()),
		//		vt2);

		vt2 = VarTreeUtil.newVarTree();
		(new OilReader()).load(new ByteArrayInputStream(answer.getBytes()),
				vt2, null, null);
		
		String s1, s2;
		System.out.print(s1 = Vt2StringUtilities.explodeOilVar(Vt2StringUtilities.varTreeToStringErtd(vt)));
		System.out.print(s2 = Vt2StringUtilities.explodeOilVar(Vt2StringUtilities.varTreeToStringErtd(vt2)));
		
		final char S = DataPath.SEPARATOR;
		final DataPackage DPKG = DataPackage.eINSTANCE;

		final String[] rtosPaths = Search.allRtos(vt.newTreeInterface());
		assertTrue(rtosPaths.length == 1);
		String[] split = DataPath.splitPath(rtosPaths[0]);
		System.out.println("Rtos Path : " + Arrays.asList(split));
		assertTrue(split.length == 7);
		ITreeInterface ti = vt.newTreeInterface();
		String[] names = ti.getAllName(
				split[0] //sysName
				+S+ DPKG.getArchitectural().getName()
				+S+ SimpleTransform.SPIN_LOCK_LIST
				, SimpleTransform.SPIN_LOCK);
		
		assertTrue(names.length == 2);
		
		System.out.println("SpinLock names : " + Arrays.asList(names));
		String[] expNames = new String[] {"spin1", "spin2"}; 
		assertArrayEquals(expNames, names);
		assertEquals(s1, s2);
		
		
		String t = VarTreeUtil.compare(
				(EObject) ((Resource) vt.getResourceSet().getResources().get(0)).getContents().get(0),
				(EObject) ((Resource) vt2.getResourceSet().getResources().get(0)).getContents().get(0)
		).getMessage(); assertTrue(t, t== null);
	}
	
	@Test
	public void testOilOsScheduleTable() {
	    final String text = "CPU test_application {\n" +
		"\n" +
		"	OS EE {		\n" +
		"		EE_OPT = \"__ASSERT__\";\n" +
		"		CFLAGS = \"-g2\";\n" +
		"\n" +
		"		CPU_DATA = LM32 {\n" +
		"			APP_SRC = \"main.c\";\n" +
		"			MULTI_STACK = FALSE;\n" +
		"			USESTANDALONEPRINTF = TRUE; // Optional, default is FALSE\n" +
		"			USESMALLC = FALSE; // Optional, default is FALSE\n" +
		"		};\n" +
		"		\n" +
		"\n" +
		"		MCU_DATA = LATTICE_PLATFORM {\n" +
		"   			MODEL = LIBRARY {\n" +
		"				PLATFORM_LIB_PATH = \"../onchipramtimer_lib\";\n" +
		"				PLATFORM_NAME = \"onchipramtimer\";\n" +
		"				PLATFORM_BLD_CFG = \"Release\"; // Optional, default is \"\"\n" +
		"   			};\n" +
		"  		};\n" +
		"\n" +
		"		STATUS = EXTENDED;\n" +
		"		STARTUPHOOK = FALSE;\n" +
		"		ERRORHOOK = FALSE;\n" +
		"		SHUTDOWNHOOK = FALSE;\n" +
		"		PRETASKHOOK = FALSE;\n" +
		"		POSTTASKHOOK = FALSE;\n" +
		"		USEGETSERVICEID = FALSE;\n" +
		"		USEPARAMETERACCESS = FALSE;\n" +
		"		USERESSCHEDULER = FALSE;\n" +
		"	};\n" +
		"\n" +
		"	/* this is the OIL part for the first task */\n" +
		"	TASK Task1 {\n" +
		"		PRIORITY = 0x01;   /* Low priority */\n" +
		"		AUTOSTART = FALSE;\n" +
		"		STACK = SHARED;\n" +
		"		ACTIVATION = 1;    /* only one pending activation */\n" +
		"	};\n" +
		"\n" +
		"	ISR Timer_isr {\n" +
		"		CATEGORY = 2;		// Only category 2 is supported on Mico32\n" +
		"		LEVEL = \"TIMER_IRQ\";	// Could be also a number\n" +
		"		HANDLER = \"timer_interrupt\";	// IRQ handler\n" +
		"	};\n" +
		"	APPLICATION myApplication;\n" +
		"	APPLICATION another_application;\n" +
		"\n" +
		"	COUNTER MainTimer;\n" +
		"	SCHEDULETABLE table1;\n" +
		"	SPINLOCK spin1;\n" +
		"	SCHEDULETABLE table2;\n" +

		"	\n" +
		"	ALARM MyAlarm {\n" +
		"		COUNTER = \"MainTimer\";\n" +
		"		ACTION = ACTIVATETASK {\n" +
		"			TASK = \"Task1\";\n" +
		"		};\n" +
		"		/* Autstart is not supported on FP kernel! */\n" +
		"		AUTOSTART = FALSE;\n" +
		"	};\n" +
		"\n" +
		"	OS EE { KERNEL_TYPE = FP; }; 	\n" +
		"};";
		
		
		IVarTree vt = VarTreeUtil.newVarTree();
		OilTransformFactory otf = OilTransformFactory.INSTANCE;
		(new OilReader()).load(new ByteArrayInputStream(text.getBytes()),
				vt, null, null);
		
		String[] prefix = CommonUtils.getAllRtos(vt.newTreeInterface());

		IOilImplID id = otf.getOilId("ee");

		String answer = otf.getTransform("ee").write(vt, id, prefix[0]);
		
		assertNotNull(answer);
		System.out.println(answer);
		
		// --------------------
		IVarTree vt2 = VarTreeUtil.newVarTree();
		//(new OilReader()).load(new ByteArrayInputStream(OIL_TEST_WITH_RESOURCE.getBytes()),
		//		vt2);

		vt2 = VarTreeUtil.newVarTree();
		(new OilReader()).load(new ByteArrayInputStream(answer.getBytes()),
				vt2, null, null);
		
		String s1, s2;
		System.out.print(s1 = Vt2StringUtilities.explodeOilVar(Vt2StringUtilities.varTreeToStringErtd(vt)));
		System.out.print(s2 = Vt2StringUtilities.explodeOilVar(Vt2StringUtilities.varTreeToStringErtd(vt2)));
		
		final char S = DataPath.SEPARATOR;
		final DataPackage DPKG = DataPackage.eINSTANCE;

		final String[] rtosPaths = Search.allRtos(vt.newTreeInterface());
		assertTrue(rtosPaths.length == 1);
		String[] split = DataPath.splitPath(rtosPaths[0]);
		System.out.println("Rtos Path : " + Arrays.asList(split));
		assertTrue(split.length == 7);
		ITreeInterface ti = vt.newTreeInterface();
		String[] names = ti.getAllName(
				split[0] //sysName
				+S+ DPKG.getArchitectural().getName()
				+S+ SimpleTransform.SCHED_TABLE_LIST
				, SimpleTransform.SCHED_TABLE);
		
		assertTrue(names.length == 2);
		
		System.out.println("Schedule table names : " + Arrays.asList(names));
		String[] expNames = new String[] {"table1", "table2"}; 
		assertArrayEquals(expNames, names);
		assertEquals(s1, s2);
		
		
		String t = VarTreeUtil.compare(
				(EObject) ((Resource) vt.getResourceSet().getResources().get(0)).getContents().get(0),
				(EObject) ((Resource) vt2.getResourceSet().getResources().get(0)).getContents().get(0)
		).getMessage(); assertTrue(t, t== null);
	}

}
