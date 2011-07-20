/*
 * Created on Jan 18, 2005
 *
 * $Id: SimpleTransformTest.java,v 1.6 2008/03/26 18:23:51 durin Exp $
 */
package com.eu.evidence.rtdruid.hidden.modules.oil.reader;


import java.io.ByteArrayInputStream;
import java.util.Arrays;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.eu.evidence.rtdruid.desk.RTDFactory;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.internal.modules.oil.reader.OilReader;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.CommonUtils;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OilImplID;
import com.eu.evidence.rtdruid.modules.oil.transform.OilTransformFactory;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.CodeWritertTest;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.data.init.DataPath;
import com.eu.evidence.rtdruid.vartree.data.init.Vt2StringUtilities;
import com.eu.evidence.rtdruid.vartree.data.init.VtCompare;
import com.eu.evidence.rtdruid.vartree.tools.Search;

/**
 *
 * Tests about tranformation: load and write Oil  
 *
 * @author Nicola Serreli
 */
public class SimpleTransformTest extends TestCase {

	final static private String S = "" + DataPath.SEPARATOR;
	final static protected String DEFAULT_CPU_NAME = IWritersKeywords.DEFAULT_CPU_NAME;

	
	final static protected String OIL_TEST_1 = CodeWritertTest.DEFAULT_EE_IMPLEMENTATION
			+ "CPU EE {\n"
			+ "    OS EE {\n"
			+ "        EE_OPT = \"__ASSERT__\";\n"
			+ "        EE_OPT = \"__OSEKOS_NO_ALARMS__\";\n"
			+ "        EE_OPT = \"DEBUG\";\n"+
			
			"		CPU_DATA = ARM7 {\n" +
			"			MULTI_STACK = TRUE {\n" +
			"				IRQ_STACK = FALSE;\n" +
			"				DUMMY_STACK = SHARED;\n" +
			"			};\n" +
			"			\n" +
			"			APP_SRC = \"code.c\";\n" +
			"	\n" 
			+ "        STACK_TOP = 0x20004000;\n"
			+ "        STACK_BOTTOM = 0x20001800;\n"
			+ "        SYS_SIZE = 0x1000;\n"
			+ "        IRQ_SIZE = 0x1000;\n"
			+ "        SVC_SIZE = 0x200;\n"
			+ "        FIQ_SIZE = 0x200;\n"
			+ "        ABT_SIZE = 0x200;\n"
			+ "        UND_SIZE = 0x200;\n"+
			"	\n" +
			"		};\n"+ 
		
			"		MCU_DATA = SAMSUNG_KS32C50100 {\n"+
			"          IRQ_EXT0       =\"Ext 0\";\n" +
			"          IRQ_EXT1       =\"Ext 1\";\n" +
			"          IRQ_EXT2       =\"Ext 2\";\n" +
			"          IRQ_EXT3       =\"Ext 3\";\n" +
			"          IRQ_UART0TX    =\"UART0 Tx\";\n" +
			"          IRQ_UART0RX    =\"UART0 Rx & error\";\n" +
			"          IRQ_UART1TX    =\"UART1 Tx\";\n" +
			"          IRQ_UART1RX    =\"UART1 Rx & error\";\n" +
			"          IRQ_GDMA0      =\"GDMA ch. 0\";\n" +
			"          IRQ_GDMA1      =\"GDMA ch. 1\";\n" +
			"          IRQ_TIMER0     =\"Timer 0\";\n" +
			"          IRQ_TIMER1     =\"Timer 1\";\n" +
			"          IRQ_HDLCATX    =\"HDLC A Tx\";\n" +
			"          IRQ_HDLCARX    =\"HDLC A Rx\";\n" +
			"          IRQ_HDLCBTX    =\"HDLC B Tx\";\n" +
			"          IRQ_HDLCBRX    =\"HDLC B Rx\";\n" +
			"          IRQ_ETHBDMATX  =\"Ethernet BDMA Tx\";\n" +
			"          IRQ_ETHBDMARX  =\"Ethernet BDMA Rx\";\n" +
			"          IRQ_ETHMACTX   =\"Ethernet MAC Tx\";\n" +
			"          IRQ_ETHMACRX   =\"Ethernet MAC Rx\";\n" +
			"          IRQ_I2C        =\"I2C-bus\";\n"+
			"          IRQ_NO_PENDING =\"No Pending Interrupt\";\n" +
			"		};\n"
			
			+ "        STATUS = EXTENDED;\n"
			+ "        STARTUPHOOK = TRUE;\n"
			+ "        ERRORHOOK = FALSE;\n"
			+ "        SHUTDOWNHOOK = FALSE;\n"
			+ "        PRETASKHOOK = FALSE;\n"
			+ "        POSTTASKHOOK = FALSE;\n"
			+ "        USEGETSERVICEID = FALSE;\n"
			+ "        USEPARAMETERACCESS = FALSE;\n"
			+ "        USERESSCHEDULER = TRUE;\n"
			+ "        KERNEL_TYPE = BCC1;\n"
			+ "    };\n"
			+ "    TASK Task1Act4 {\n"
			+ "        PRIORITY = 0x01;\n"
			+ "        ACTIVATION = 4;\n"
			+ "        SCHEDULE = FULL;\n"
			+ "        AUTOSTART = TRUE;\n"
			+ "        STACK = PRIVATE {\n"
			+ "            SYS_SIZE = 0x100;\n"
			+ "        };\n"
			+ "        EVENT = evento1;\n"
			+ "    };\n"
			+ "    TASK Task2 {\n"
			+ "        PRIORITY = 0x02;\n"
			+ "        ACTIVATION = 1;\n"
			+ "        SCHEDULE = FULL;\n"
			+ "        AUTOSTART = TRUE;\n"
			+ "        STACK = SHARED;\n"
			+ "    };\n"
			+ "	 EVENT evento1 {};\n"
			+ "};\n";

	public void testOilWrite1() {
		IVarTree vt = (IVarTree) RTDFactory.get(IVarTree.class);
		OilTransformFactory otf = OilTransformFactory.INSTANCE;
		(new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1.getBytes()),
				vt);

		DataPackage dpkg = DataPackage.eINSTANCE;
		String prefix = "EE" + S + dpkg.getSystem_Architectural().getName() + S
				+ dpkg.getArchitectural_EcuList().getName() + S + "EE" + S
				+ dpkg.getEcu_CpuList().getName() + S + DEFAULT_CPU_NAME + S
				+ dpkg.getCpu_Rtos().getName();
		OilImplID id = otf.getOilId("ee");
		
		String answer = otf.getTransform("ee").write(vt, id, prefix);

		assertTrue(answer != null);
		System.out.println(answer);

		// --------------------
		IVarTree vt2 = (IVarTree) RTDFactory.get(IVarTree.class);
		//(new OilReader()).load(new ByteArrayInputStream(OIL_TEST_WITH_RESOURCE.getBytes()),
		//		vt2);

		vt2 = (IVarTree) RTDFactory.get(IVarTree.class);
		(new OilReader()).load(new ByteArrayInputStream(answer.getBytes()),
				vt2);
		
		String t = (new VtCompare(
				(EObject) ((Resource) vt.getResourceSet().getResources().get(0)).getContents().get(0),
				(EObject) ((Resource) vt2.getResourceSet().getResources().get(0)).getContents().get(0)
		)).getText(); assertTrue(t, t== null);

	}

	final static protected String OIL_TEST_DEFAULT_VALUE = CodeWritertTest.DEFAULT_EE_IMPLEMENTATION
	+ "CPU EE {\n"
	+ "    OS EE {};\n"
	+ "    TASK Task1Act4 {\n"
	+ "        PRIORITY = 0x01;\n"
	+ "        STACK = PRIVATE {\n"
	+ "            SYS_SIZE = 0x100;\n"
	+ "        };\n"
	+ "        EVENT = evento1;\n"
	+ "    };\n"
	+ "};\n";

	public void testDefaultValue() {
		IVarTree vt = (IVarTree) RTDFactory.get(IVarTree.class);
		OilTransformFactory otf = OilTransformFactory.INSTANCE;
		
		(new OilReader()).load(new ByteArrayInputStream(OIL_TEST_DEFAULT_VALUE.getBytes()),
				vt);

		System.out.println(Vt2StringUtilities.varTreeToString(vt));
		
		DataPackage dpkg = DataPackage.eINSTANCE;
		String prefix = "EE" + S + dpkg.getSystem_Architectural().getName() + S
				+ dpkg.getArchitectural_EcuList().getName() + S + "EE" + S
				+ dpkg.getEcu_CpuList().getName() + S + DEFAULT_CPU_NAME + S
				+ dpkg.getCpu_Rtos().getName();
		OilImplID id = otf.getOilId("ee");

		
		String answer = otf.getTransform("ee").write(vt, id, prefix);

		assertTrue(answer != null);
		System.out.println(answer);

		// --------------------
		IVarTree vt2 = (IVarTree) RTDFactory.get(IVarTree.class);
		//(new OilReader()).load(new
		// ByteArrayInputStream(OIL_TEST_WITH_RESOURCE.getBytes()),
		//		vt2);

		vt2 = (IVarTree) RTDFactory.get(IVarTree.class);
		(new OilReader())
				.load(new ByteArrayInputStream(answer.getBytes()), vt2);

		String t = (new VtCompare((EObject) ((Resource) vt.getResourceSet()
				.getResources().get(0)).getContents().get(0),
				(EObject) ((Resource) vt2.getResourceSet().getResources()
						.get(0)).getContents().get(0))).getText(); assertTrue(t, t== null);

		// attenzione : come gestire i valori di default? dome memorizzarli?
		throw new RuntimeException("come gestire i valori di default? dome memorizzarli?");
	}

	final static protected String OIL_TEST_WITH_RESOURCE = CodeWritertTest.DEFAULT_EE_IMPLEMENTATION
		+ "CPU test_application {\n" +

		"    OS EE {\n" +
		"  EE_OPT = \"__OSEKOS_STARTOS_WITHOUT_IDLELOOP__\";\n" +
		"        EE_OPT = \"__ASSERT__\";\n" +
		"        EE_OPT = \"DEBUG\";\n" +

		"  STATUS = EXTENDED;\n" +

		"  STARTUPHOOK = FALSE;\n" +
		"  ERRORHOOK = FALSE;\n" +
		"  SHUTDOWNHOOK = FALSE;\n" +
		"  PRETASKHOOK = FALSE;\n" +
		"  POSTTASKHOOK = FALSE;\n" +
		"  USEGETSERVICEID = FALSE;\n" +
		"  USEPARAMETERACCESS = FALSE;\n" +
		"  USERESSCHEDULER = FALSE;\n" +

		"  MCU_DATA = SAMSUNG_KS32C50100 {\n" +
		"     IRQ_TIMER0 = \"myISR2\";\n" +
		"  };\n" +
		"        EE_OPT = \"__TIMER_0_USED__\";\n" +

		"  CPU_DATA = ARM7 {\n" +
		"   APP_SRC = \"code.c\";\n" +

		"   STACK_TOP = 0x80000;\n" +
		"   STACK_BOTTOM = 0x20000;\n" +
		"   SYS_SIZE = 0x4000;\n" +
		"   IRQ_SIZE = 0x4000;\n" +
		"   SVC_SIZE = 0x4000;\n" +
		"   FIQ_SIZE = 0x4000;\n" +
		"   ABT_SIZE = 0x4000;\n" +
		"   UND_SIZE = 0x4000;\n" +
		"   MULTI_STACK = FALSE;\n" +
		"  };\n" +

		"        KERNEL_TYPE = BCC1;\n" +
		"    };\n" +

		"    TASK Task1 {\n" +
		"  PRIORITY = 1;\n" +
		"  ACTIVATION = 1;\n" +
		"  SCHEDULE = FULL;\n" +
		"  AUTOSTART = TRUE;\n" +
		"  STACK = SHARED;\n" +
		"  RESOURCE = \"Resource1\";\n" +
		"  RESOURCE = \"Resource2\";\n" +
		"  RESOURCE = \"Resource3\";\n" +
		"  RESOURCE = \"Resource4\";\n" +
		"  RESOURCE = \"Resource5\";\n" +
		"  RESOURCE = \"Resource6\";\n" +
		"    };\n" +

		"    TASK Task2 {\n" +
		"  PRIORITY = 2;\n" +
		"  ACTIVATION = 1;\n" +
		"  SCHEDULE = FULL;\n" +
		"  AUTOSTART = FALSE;\n" +
		"  STACK = SHARED;\n" +
		"  RESOURCE = \"ResourceA\";\n" +
		"    };\n" +

		"    RESOURCE Resource1 { RESOURCEPROPERTY = STANDARD; };\n" +
		"    RESOURCE Resource2 { RESOURCEPROPERTY = STANDARD; };\n" +
		"    RESOURCE Resource3 { RESOURCEPROPERTY = STANDARD; };\n" +
		"    RESOURCE Resource4 { RESOURCEPROPERTY = STANDARD; };\n" +
		"    RESOURCE Resource5 { RESOURCEPROPERTY = STANDARD; };\n" +
		"    RESOURCE Resource6 { RESOURCEPROPERTY = STANDARD; };\n" +
		"    RESOURCE ResourceA { RESOURCEPROPERTY = STANDARD; };\n" +
		"};\n";
	
	public void testOilWriteWithResources() {
		IVarTree vt = (IVarTree) RTDFactory.get(IVarTree.class);
		OilTransformFactory otf = OilTransformFactory.INSTANCE;
		(new OilReader()).load(new ByteArrayInputStream(OIL_TEST_WITH_RESOURCE.getBytes()),
				vt);
		
		DataPackage dpkg = DataPackage.eINSTANCE;
		String prefix = "test_application" + S + dpkg.getSystem_Architectural().getName() + S
				+ dpkg.getArchitectural_EcuList().getName() + S + "test_application" + S
				+ dpkg.getEcu_CpuList().getName() + S + DEFAULT_CPU_NAME + S
				+ dpkg.getCpu_Rtos().getName();
		OilImplID id = otf.getOilId("ee");

		String answer = otf.getTransform("ee").write(vt, id, prefix);
		
		assertTrue(answer != null);
		System.out.println(answer);
		
		// --------------------
		IVarTree vt2 = (IVarTree) RTDFactory.get(IVarTree.class);
		//(new OilReader()).load(new ByteArrayInputStream(OIL_TEST_WITH_RESOURCE.getBytes()),
		//		vt2);

		vt2 = (IVarTree) RTDFactory.get(IVarTree.class);
		(new OilReader()).load(new ByteArrayInputStream(answer.getBytes()),
				vt2);
		
		String t = (new VtCompare(
				(EObject) ((Resource) vt.getResourceSet().getResources().get(0)).getContents().get(0),
				(EObject) ((Resource) vt2.getResourceSet().getResources().get(0)).getContents().get(0)
		)).getText(); assertTrue(t, t== null);

	}

	final static protected String OIL_TEST_2_NIOS = CodeWritertTest.DEFAULT_EE_IMPLEMENTATION
			+ "CPU EE {\n"
			+ "    OS EE {\n"
			+ "        EE_OPT = \"__ASSERT__\";\n"
			+ "        EE_OPT = \"__OSEKOS_NO_ALARMS__\";\n"
			+ "        EE_OPT = \"DEBUG\";\n"+
			
			"		CPU_DATA = NIOSII {\n" +
			"			ID = \"cpu1\";\n" +
			"			MULTI_STACK = TRUE {\n" +
			"				IRQ_STACK = FALSE;\n" +
			"				DUMMY_STACK = SHARED;\n" +
			"			};\n" +
			"			\n" +
			"			APP_SRC = \"code_1.c\";\n" +
			"	\n" 
			+ "        STACK_TOP = 0x20004000;\n"
			//+ "        STACK_BOTTOM = 0x20001800;\n"
			+ "        SYS_SIZE = 0x1000;\n" +
			"	\n" +
			"		};\n"+ 
			
			"		CPU_DATA = NIOSII {\n" +
			"			ID = \"cpu2\";\n" +
			"			MULTI_STACK = TRUE {\n" +
			"				IRQ_STACK = FALSE;\n" +
			"				DUMMY_STACK = SHARED;\n" +
			"			};\n" +
			"			\n" +
			"			APP_SRC = \"code_2.c\";\n" +
			"	\n" 
			+ "        STACK_TOP = 0x20008000;\n"
			//+ "        STACK_BOTTOM = 0x20004000;\n"
			+ "        SYS_SIZE = 0x1000;\n" +
			"	\n" +
			"		};\n"+ 
			
			  "        STATUS = EXTENDED;\n"
			+ "        STARTUPHOOK = TRUE;\n"
			+ "        ERRORHOOK = FALSE;\n"
			+ "        SHUTDOWNHOOK = FALSE;\n"
			+ "        PRETASKHOOK = FALSE;\n"
			+ "        POSTTASKHOOK = FALSE;\n"
			+ "        USEGETSERVICEID = FALSE;\n"
			+ "        USEPARAMETERACCESS = FALSE;\n"
			+ "        USERESSCHEDULER = TRUE;\n"
			+ "        KERNEL_TYPE = BCC1;\n"
			+ "    };\n"
			+ "    TASK Task1 {\n"
			+ "        CPU_ID = \"cpu1\";"
			+ "        PRIORITY = 0x01;\n"
			+ "        ACTIVATION = 4;\n"
			+ "        SCHEDULE = FULL;\n"
			+ "        AUTOSTART = TRUE;\n"
			+ "        STACK = PRIVATE {\n"
			+ "            SYS_SIZE = 0x100;\n"
			+ "        };\n"
			+ "        EVENT = evento1;\n"
			+ "    };\n"
			+ "    TASK Task2 {\n"
			+ "        CPU_ID = \"cpu1\";"
			+ "        PRIORITY = 0x02;\n"
			+ "        ACTIVATION = 1;\n"
			+ "        SCHEDULE = FULL;\n"
			+ "        AUTOSTART = TRUE;\n"
			+ "        STACK = SHARED;\n"
			+ "    };\n"
			+ "    TASK Task3 {\n"
			+ "        CPU_ID = \"cpu2\";"
			+ "        PRIORITY = 0x04;\n"
			+ "        ACTIVATION = 1;\n"
			+ "        SCHEDULE = FULL;\n"
			+ "        AUTOSTART = TRUE;\n"
			+ "        STACK = SHARED;\n"
			+ "    };\n"
			+ "	 EVENT evento1 {};\n"
			+ "};\n";

	public void testOilWriteWithTwoCpu() {
		IVarTree vt = (IVarTree) RTDFactory.get(IVarTree.class);
		OilTransformFactory otf = OilTransformFactory.INSTANCE;
		(new OilReader()).load(new ByteArrayInputStream(OIL_TEST_2_NIOS.getBytes()),
				vt);
		
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
		OilImplID id = otf.getOilId("ee");

		String answer = otf.getTransform("ee").write(vt, id, new String[] {prefix1, prefix2});
		
		assertTrue(answer != null);
		System.out.println(answer);
		
		// --------------------
		IVarTree vt2 = (IVarTree) RTDFactory.get(IVarTree.class);
		//(new OilReader()).load(new ByteArrayInputStream(OIL_TEST_2_NIOS.getBytes()),
		//		vt2);

		vt2 = (IVarTree) RTDFactory.get(IVarTree.class);
		(new OilReader()).load(new ByteArrayInputStream(answer.getBytes()),
				vt2);
		
		System.out.println(Vt2StringUtilities.varTreeToString(vt2));

		String t = (new VtCompare(
				(EObject) ((Resource) vt.getResourceSet().getResources().get(0)).getContents().get(0),
				(EObject) ((Resource) vt2.getResourceSet().getResources().get(0)).getContents().get(0)
		)).getText(); assertTrue(t, t== null);

	}

	
	
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
		
		
		IVarTree vt = (IVarTree) RTDFactory.get(IVarTree.class);
		OilTransformFactory otf = OilTransformFactory.INSTANCE;
		(new OilReader()).load(new ByteArrayInputStream(text.getBytes()),
				vt);
		
		String[] prefix = CommonUtils.getAllRtos(vt.newTreeInterface());

		OilImplID id = otf.getOilId("ee");

		String answer = otf.getTransform("ee").write(vt, id, prefix[0]);
		
		assertTrue(answer != null);
		System.out.println(answer);
		
		// --------------------
		IVarTree vt2 = (IVarTree) RTDFactory.get(IVarTree.class);
		//(new OilReader()).load(new ByteArrayInputStream(OIL_TEST_WITH_RESOURCE.getBytes()),
		//		vt2);

		vt2 = (IVarTree) RTDFactory.get(IVarTree.class);
		(new OilReader()).load(new ByteArrayInputStream(answer.getBytes()),
				vt2);
		
		String t = (new VtCompare(
				(EObject) ((Resource) vt.getResourceSet().getResources().get(0)).getContents().get(0),
				(EObject) ((Resource) vt2.getResourceSet().getResources().get(0)).getContents().get(0)
		)).getText(); assertTrue(t, t== null);

	}

	
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
		"	OSAPPLICATION myApplication;\n" +
		"	OSAPPLICATION another_application;\n" +
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
		
		
		IVarTree vt = (IVarTree) RTDFactory.get(IVarTree.class);
		OilTransformFactory otf = OilTransformFactory.INSTANCE;
		(new OilReader()).load(new ByteArrayInputStream(text.getBytes()),
				vt);
		
		String[] prefix = CommonUtils.getAllRtos(vt.newTreeInterface());

		OilImplID id = otf.getOilId("ee");

		String answer = otf.getTransform("ee").write(vt, id, prefix[0]);
		
		assertTrue(answer != null);
		System.out.println(answer);
		
		// --------------------
		IVarTree vt2 = (IVarTree) RTDFactory.get(IVarTree.class);
		//(new OilReader()).load(new ByteArrayInputStream(OIL_TEST_WITH_RESOURCE.getBytes()),
		//		vt2);

		vt2 = (IVarTree) RTDFactory.get(IVarTree.class);
		(new OilReader()).load(new ByteArrayInputStream(answer.getBytes()),
				vt2);
		
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
		
		
		String t = (new VtCompare(
				(EObject) ((Resource) vt.getResourceSet().getResources().get(0)).getContents().get(0),
				(EObject) ((Resource) vt2.getResourceSet().getResources().get(0)).getContents().get(0)
		)).getText(); assertTrue(t, t== null);
	}

}
