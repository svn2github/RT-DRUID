package com.eu.evidence.rtdruid.test.modules.oil.codewriter;

import com.eu.evidence.rtdruid.vartree.data.init.Vt2StringUtilities;





public class CodeWriterPpcMultiCoreTest extends AbstractCodeWriterTest {
	

	public void testMulticore1() {
	    final String text = "CPU test_application {\n" +
	    "\n" +
	    "	OS EE {\n" +
	    "		EE_OPT = \"__ASSERT__\";\n" +
	    "		CFLAGS = \"-g2\";\n" +
	    "		ASFLAGS = \"\";\n" +
	    "		LDFLAGS = \"\"; \n" +
	    "\n" +
	    "		EE_OPT = \"__E200ZX_EXECUTE_FROM_RAM__\";\n" +
	    "\n" +
	    "		MASTER_CPU = \"master\";\n" +
	    "\n" +
	    "		CPU_DATA = PPCE200ZX {\n" +
	    "			ID = \"master\";\n" +
	    "			MODEL = E200Z6; /* NEW; also Z7 */\n" +
	    "			APP_SRC = \"master.c\";\n" +
	    "			MULTI_STACK = FALSE;\n" +
	    "			VLE = TRUE; /* NEW Default: FALSE for Z6 & Z7 */\n" +
	    "			SYS_STACK_SIZE = 4096;\n" +
	    "		};\n" +
	    "\n" +
	    "		CPU_DATA = PPCE200ZX {\n" +
	    "			MODEL = E200Z0; /* -> __PPCE200Z0__ */\n" +
	    "			ID = \"slave\";\n" +
	    "			APP_SRC = \"slave.c\";\n" +
	    "			MULTI_STACK = FALSE;\n" +
	    "			VLE = TRUE; /* NEW Always TRUE for Z0 (default is TRUE) */\n" +
	    "			SYS_STACK_SIZE = 4096;\n" +
	    "		};\n" +
	    "\n" +
	    "		MCU_DATA = PPCE200ZX {\n" +
	    "			MODEL = MPC5668G; /* Z6+Z0; Also MPC5674F (mono Z7) */\n" +
	    "		};\n" +
	    "\n" +
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
	    "		KERNEL_TYPE = FP; 	\n" +
	    "	};\n" +
	    "\n" +
	    "	/* this is the OIL part for the first task */\n" +
	    "	TASK Task1 {\n" +
	    "		PRIORITY = 0x01;   /* Low priority */\n" +
	    "		AUTOSTART = FALSE;\n" +
	    "		STACK = SHARED;\n" +
	    "		ACTIVATION = 1;	   /* only one pending activation */\n" +
		"       CPU_ID = \"master\";\n" + 	    
	    "	};\n" +
	    "	\n" +
//	    "	OS EE { KERNEL_TYPE = FP; };	\n" +
	    "};";
	    DefaultTestResult res = commonWriterTest(text, 2);
	    System.out.println(Vt2StringUtilities.explodeOilVar(Vt2StringUtilities.varTreeToStringErtd(res.vt)));
	}

	public void testOsSectionsMerge() {
	    final String text = "CPU test_application {\n" +
	    "\n" +
	    "	OS EE {\n" +
	    "		EE_OPT = \"__ASSERT__\";\n" +
	    "		CFLAGS = \"-g2\";\n" +
	    "		ASFLAGS = \"\";\n" +
	    "		LDFLAGS = \"\"; \n" +
	    "\n" +
	    "		EE_OPT = \"__E200ZX_EXECUTE_FROM_RAM__\";\n" +
	    "\n" +
	    "		MASTER_CPU = \"master\";\n" +
	    "\n" +
	    "		CPU_DATA = PPCE200ZX {\n" +
	    "			ID = \"master\";\n" +
	    "			MODEL = E200Z6; /* NEW; also Z7 */\n" +
	    "			APP_SRC = \"master.c\";\n" +
	    "			MULTI_STACK = FALSE;\n" +
	    "			VLE = TRUE; /* NEW Default: FALSE for Z6 & Z7 */\n" +
	    "			SYS_STACK_SIZE = 4096;\n" +
	    "		};\n" +
	    "\n" +
	    "		CPU_DATA = PPCE200ZX {\n" +
	    "			MODEL = E200Z0; /* -> __PPCE200Z0__ */\n" +
	    "			ID = \"slave\";\n" +
	    "			APP_SRC = \"slave.c\";\n" +
	    "			MULTI_STACK = FALSE;\n" +
	    "			VLE = TRUE; /* NEW Always TRUE for Z0 (default is TRUE) */\n" +
	    "			SYS_STACK_SIZE = 4096;\n" +
	    "		};\n" +
	    "\n" +
	    "		MCU_DATA = PPCE200ZX {\n" +
	    "			MODEL = MPC5668G; /* Z6+Z0; Also MPC5674F (mono Z7) */\n" +
	    "		};\n" +
	    "\n" +
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
	    "		ACTIVATION = 1;	   /* only one pending activation */\n" +
		"       CPU_ID = \"master\";\n" + 	    
	    "	};\n" +
	    "	\n" +
	    "	OS EE { KERNEL_TYPE = FP; };	\n" +
	    "};";
	    DefaultTestResult res = commonWriterTest(text, 2);
	    System.out.println(Vt2StringUtilities.explodeOilVar(Vt2StringUtilities.varTreeToStringErtd(res.vt)));
	}
	
	public void testRemoteNotification() {
	    final String text = 	
			"CPU test_application {\n" +
			"\n" +
			"	OS EE {\n" +
			"		EE_OPT = \"__ASSERT__\";\n" +
			"		CFLAGS = \"-g2\";\n" +
			"		ASFLAGS = \"\";\n" +
			"		LDFLAGS = \"\";\n" +
			"\n" +
			"		EE_OPT = \"__E200ZX_EXECUTE_FROM_RAM__\";\n" +
			"\n" +
			"		MASTER_CPU = \"master\";\n" +
			"\n" +
			"		CPU_DATA = PPCE200ZX {\n" +
			"			ID = \"master\";\n" +
			"			MODEL = E200Z6;\n" +
			"			APP_SRC = \"master.c\";\n" +
			"			MULTI_STACK = FALSE;\n" +
			"			VLE = TRUE;\n" +
			"			SYS_STACK_SIZE = 4096;\n" +
			"		};\n" +
			"\n" +
			"		CPU_DATA = PPCE200ZX {\n" +
			"			MODEL = E200Z0;\n" +
			"			ID = \"slave\";\n" +
			"			APP_SRC = \"slave.c\";\n" +
			"			MULTI_STACK = FALSE;\n" +
			"			VLE = TRUE;\n" +
			"			SYS_STACK_SIZE = 4096;\n" +
			"		};\n" +
			"\n" +
			"		MCU_DATA = PPCE200ZX {\n" +
			"			MODEL = MPC5668G;\n" +
			"		};\n" +
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
			"\n" +
			"		USEREMOTETASK = ALWAYS;\n" +
			"\n" +
			"		KERNEL_TYPE = BCC1;\n" +
			"	};\n" +
			"\n" +
			"	TASK TaskZ6 {\n" +
			"		CPU_ID = \"master\";\n" +
			"		PRIORITY = 0x01;   /* Low priority */\n" +
			"		AUTOSTART = FALSE;\n" +
			"		STACK = SHARED;\n" +
			"		ACTIVATION = 1;	   /* only one pending activation */\n" +
			"	};\n" +
			"\n" +
			"	TASK TaskZ0 {\n" +
			"		CPU_ID = \"slave\";\n" +
			"		PRIORITY = 0x01;   /* Low priority */\n" +
			"		AUTOSTART = TRUE;\n" +
			"		STACK = SHARED;\n" +
			"		ACTIVATION = 1;	   /* only one pending activation */\n" +
			"	};\n" +
			"};";
	   DefaultTestResult res = commonWriterTest(text, 2);
	    System.out.println(Vt2StringUtilities.explodeOilVar(Vt2StringUtilities.varTreeToStringErtd(res.vt)));
	}
}
