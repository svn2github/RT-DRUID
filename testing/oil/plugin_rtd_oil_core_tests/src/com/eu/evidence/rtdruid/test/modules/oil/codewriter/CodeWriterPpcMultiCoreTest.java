package com.eu.evidence.rtdruid.test.modules.oil.codewriter;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import com.eu.evidence.rtdruid.vartree.Vt2StringUtilities;





public class CodeWriterPpcMultiCoreTest extends AbstractCodeWriterTest {
	

	@Test public void testMulticore1() {
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

	@Test public void testOsSectionsMerge() {
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
	
	@Test public void testRemoteNotification() {
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
	
	@Test
	public void testIrqNested() {
	    final String text = 	
	    		"CPU test_application {\n"+
	    				"\n"+
	    				"	OS EE {\n"+
	    				"\n"+
	    				"		EE_OPT = \"DEBUG\";\n"+
	    				"		EE_OPT = \"DEBUG_STACK\";\n"+
	    				"		EE_OPT = \"__ASSERT__\";\n"+
	    				"		EE_OPT = \"__E200ZX_EXECUTE_FROM_RAM__\";\n"+
	    				"		//EE_OPT = \"__CODEWARRIOR__\";\n"+
	    				"\n"+
	    				"		CFLAGS = \"\";\n"+
	    				"		ASFLAGS = \"\";\n"+
	    				"		LDFLAGS = \"\"; \n"+
	    				"\n"+
	    				"		MASTER_CPU = \"master\";\n"+
	    				"\n"+
	    				"		CPU_DATA = PPCE200ZX {\n"+
	    				"			MODEL = E200Z6;\n"+
	    				"			ID = \"master\";\n"+
	    				"			APP_SRC = \"master.c\";\n"+
	    				"			MULTI_STACK = TRUE {\n"+
	    				"				IRQ_STACK = TRUE {\n"+
	    				"					SYS_SIZE=512;\n"+
	    				"				};\n"+
	    				"			};\n"+
	    				"			VLE = TRUE;\n"+
	    				"			SYS_STACK_SIZE = 4096;\n"+
	    				"		};\n"+
	    				"\n"+
	    				"		CPU_DATA = PPCE200ZX {\n"+
	    				"			MODEL = E200Z0;\n"+
	    				"			ID = \"slave\";\n"+
	    				"			APP_SRC = \"slave.c\";\n"+
	    				"			MULTI_STACK = TRUE {\n"+
	    				"				IRQ_STACK = TRUE {\n"+
	    				"					SYS_SIZE=512;\n"+
	    				"				};\n"+
	    				"			};\n"+
	    				"			VLE = TRUE;\n"+
	    				"			SYS_STACK_SIZE = 4096;\n"+
	    				"		};\n"+
	    				"\n"+
	    				"		MCU_DATA = PPCE200ZX {\n"+
	    				"			MODEL = MPC5668G;\n"+
	    				"		};\n"+
	    				"\n"+
	    				"		STATUS = EXTENDED;\n"+
	    				"		STARTUPHOOK = FALSE;\n"+
	    				"		ERRORHOOK = FALSE;\n"+
	    				"		SHUTDOWNHOOK = FALSE;\n"+
	    				"		PRETASKHOOK = FALSE;\n"+
	    				"		POSTTASKHOOK = FALSE;\n"+
	    				"		USEGETSERVICEID = FALSE;\n"+
	    				"		USEPARAMETERACCESS = FALSE;\n"+
	    				"		USERESSCHEDULER = FALSE;\n"+
	    				"\n"+
	    				"		USEREMOTETASK = ALWAYS;\n"+
	    				"\n"+
	    				"		KERNEL_TYPE = FP {\n"+
	    				"			NESTED_IRQ = TRUE;\n"+
	    				"		};\n"+
	    				"\n"+
	    				"	};\n"+
	    				"\n"+
	    				"	/* this is the OIL part for the first task */\n"+
	    				"	TASK TaskMaster {\n"+
	    				"		CPU_ID = \"master\";\n"+
	    				"		PRIORITY = 0x01;\n"+
	    				"		AUTOSTART = FALSE;\n"+
	    				"		STACK = PRIVATE {\n"+
	    				"			SYS_SIZE = 512;\n"+
	    				"		};\n"+
	    				"		ACTIVATION = 1;\n"+
	    				"	};\n"+
	    				"\n"+
	    				"	/* this is the OIL part for the first task */\n"+
	    				"	TASK Task1 {\n"+
	    				"		CPU_ID = \"slave\";\n"+
	    				"		PRIORITY = 0x01;\n"+
	    				"		AUTOSTART = FALSE;\n"+
	    				"		STACK = PRIVATE {\n"+
	    				"			SYS_SIZE = 512;\n"+
	    				"		};\n"+
	    				"		ACTIVATION = 1;\n"+
	    				"	};\n"+
	    				"\n"+
	    				"};\n";
	   DefaultTestResult res = commonWriterTest(text, 2);
	    System.out.println(Vt2StringUtilities.explodeOilVar(Vt2StringUtilities.varTreeToStringErtd(res.vt)));
	}
	
	@Test
	public void testMultiStack() {
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
			"			MULTI_STACK = TRUE {\n" +
			"				IRQ_STACK = TRUE {\n" +
			"					SYS_SIZE = 512;\n" +
			"				};\n" +
			"			};\n" +
			"			VLE = TRUE;\n" +
			"			SYS_STACK_SIZE = 4096;\n" +
			"		};\n" +
			"\n" +
			"		CPU_DATA = PPCE200ZX {\n" +
			"			MODEL = E200Z0;\n" +
			"			ID = \"slave\";\n" +
			"			APP_SRC = \"slave.c\";\n" +
			"			MULTI_STACK = TRUE {\n" +
			"				IRQ_STACK = TRUE {\n" +
			"					SYS_SIZE = 512;\n" +
			"				};\n" +
			"			};\n" +
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
			"		STACK = PRIVATE {\n" +
			"			SYS_SIZE = 1024;\n" +
			"		};\n" +
			"		ACTIVATION = 1;	   /* only one pending activation */\n" +
			"	};\n" +
			"\n" +
			"	TASK TaskZ0 {\n" +
			"		CPU_ID = \"slave\";\n" +
			"		PRIORITY = 0x01;   /* Low priority */\n" +
			"		AUTOSTART = TRUE;\n" +
			"		STACK = PRIVATE {\n" +
			"			SYS_SIZE = 1024;\n" +
			"		};\n" +
			"		ACTIVATION = 1;	   /* only one pending activation */\n" +
			"	};\n" +
			"};";
	   DefaultTestResult res = commonWriterTest(text, 2);
	    System.out.println(Vt2StringUtilities.explodeOilVar(Vt2StringUtilities.varTreeToStringErtd(res.vt)));
	}
	
	@Test
	public void testPragmaMultiStack() {
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
			"		EE_OPT = \"USE_PRAGMAS\";\n" +
			"\n" +
			"		MASTER_CPU = \"master\";\n" +
			"\n" +
			"		CPU_DATA = PPCE200ZX {\n" +
			"			ID = \"master\";\n" +
			"			MODEL = E200Z6;\n" +
			"			APP_SRC = \"master.c\";\n" +
			"			MULTI_STACK = TRUE {\n" +
			"				IRQ_STACK = TRUE {\n" +
			"					SYS_SIZE = 512;\n" +
			"				};\n" +
			"			};\n" +
			"			VLE = TRUE;\n" +
			"			SYS_STACK_SIZE = 4096;\n" +
			"		};\n" +
			"\n" +
			"		CPU_DATA = PPCE200ZX {\n" +
			"			MODEL = E200Z0;\n" +
			"			ID = \"slave\";\n" +
			"			APP_SRC = \"slave.c\";\n" +
			"			MULTI_STACK = TRUE {\n" +
			"				IRQ_STACK = TRUE {\n" +
			"					SYS_SIZE = 512;\n" +
			"				};\n" +
			"			};\n" +
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
			"		STACK = PRIVATE {\n" +
			"			SYS_SIZE = 1024;\n" +
			"		};\n" +
			"		ACTIVATION = 1;	   /* only one pending activation */\n" +
			"	};\n" +
			"\n" +
			"	TASK TaskZ0 {\n" +
			"		CPU_ID = \"slave\";\n" +
			"		PRIORITY = 0x01;   /* Low priority */\n" +
			"		AUTOSTART = TRUE;\n" +
			"		STACK = PRIVATE {\n" +
			"			SYS_SIZE = 1024;\n" +
			"		};\n" +
			"		ACTIVATION = 1;	   /* only one pending activation */\n" +
			"	};\n" +
			"};";
	   DefaultTestResult res = commonWriterTest(text, 2);
	    System.out.println(Vt2StringUtilities.explodeOilVar(Vt2StringUtilities.varTreeToStringErtd(res.vt)));
	}


	@Test
	public void testMpc567_alarm_counter_incr_multi() {
	    final String text = "CPU test_application {\n" +
			"\n" +
			"	OS EE {		\n" +
			"		EE_OPT = \"DEBUG_STACK\";\n" +
			"\n" +
			"		CFLAGS = \"-g2\";\n" +
			"		ASFLAGS = \"\";\n" +
			"		LDFLAGS = \"\"; \n" +
			"\n" +
			"		MASTER_CPU = \"master\";\n" +
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
			"		STATUS = EXTENDED;\n" +
			"		STARTUPHOOK = FALSE;\n" +
			"		ERRORHOOK = FALSE;\n" +
			"		SHUTDOWNHOOK = FALSE;\n" +
			"		PRETASKHOOK = FALSE;\n" +
			"		POSTTASKHOOK = FALSE;\n" +
			"		USEGETSERVICEID = FALSE;\n" +
			"		USEPARAMETERACCESS = FALSE;\n" +
			"		USERESSCHEDULER = FALSE;\n" +
			"		KERNEL_TYPE = ECC2;\n" +
			"		ORTI_SECTIONS = ALL;\n" +
			"    };\n" +
			"    \n" +
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
			"\n" +
			"	COUNTER myCounter1 {\n" +
			"		CPU_ID = \"slave\";\n" +
			"		MINCYCLE = 0;\n" +
			"		MAXALLOWEDVALUE = 10;\n" +
			"		TICKSPERBASE = 1;\n" +
			"	};\n" +
			"	COUNTER myCounter2 {\n" +
			"		CPU_ID = \"slave\";\n" +
			"		MINCYCLE = 0;\n" +
			"		MAXALLOWEDVALUE = 10;\n" +
			"		TICKSPERBASE = 1;\n" +
			"	};\n" +
			"	COUNTER myCounter3 {\n" +
			"		CPU_ID = \"master\";\n" +
			"		MINCYCLE = 0;\n" +
			"		MAXALLOWEDVALUE = 10;\n" +
			"		TICKSPERBASE = 1;\n" +
			"	};\n" +
			"	COUNTER myCounter4 {\n" +
			"		CPU_ID = \"master\";\n" +
			"		MINCYCLE = 0;\n" +
			"		MAXALLOWEDVALUE = 10;\n" +
			"		TICKSPERBASE = 1;\n" +
			"	};\n" +
			"	ALARM alarm1 {\n" +
			"		COUNTER = myCounter1;\n" +
			"		ACTION = ACTIVATETASK { TASK = TaskZ6; };\n" +
			"	};\n" +

			"	ALARM AcquireAlarm2 {\n" +
			"		COUNTER = myCounter2;\n" +
			"		ACTION = INCREMENTCOUNTER { COUNTER = myCounter1; };\n" +
			"	};\n" +
			"	ALARM AcquireAlarm3 {\n" +
			"		COUNTER = myCounter3;\n" +
			"		ACTION = INCREMENTCOUNTER { COUNTER = myCounter4; };\n" +
			"	};\n" +
			"	ALARM AcquireAlarm4 {\n" +
			"		COUNTER = myCounter4;\n" +
			"		ACTION =  ACTIVATETASK { TASK = TaskZ0; };\n" +
			"	};\n" +
			"};";
    	commonWriterTest(text, 2);
	}

	@Test
	public void testMpc567_alarm_counter_incr_multi_remote_counter() {
	    final String text = "CPU test_application {\n" +
			"\n" +
			"	OS EE {		\n" +
			"		EE_OPT = \"DEBUG_STACK\";\n" +
			"\n" +
			"		CFLAGS = \"-g2\";\n" +
			"		ASFLAGS = \"\";\n" +
			"		LDFLAGS = \"\"; \n" +
			"\n" +
			"		MASTER_CPU = \"master\";\n" +
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
			"		STATUS = EXTENDED;\n" +
			"		STARTUPHOOK = FALSE;\n" +
			"		ERRORHOOK = FALSE;\n" +
			"		SHUTDOWNHOOK = FALSE;\n" +
			"		PRETASKHOOK = FALSE;\n" +
			"		POSTTASKHOOK = FALSE;\n" +
			"		USEGETSERVICEID = FALSE;\n" +
			"		USEPARAMETERACCESS = FALSE;\n" +
			"		USERESSCHEDULER = FALSE;\n" +
			"		KERNEL_TYPE = ECC2;\n" +
			"		ORTI_SECTIONS = ALL;\n" +
			"    };\n" +
			"    \n" +
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
			"\n" +
			"	COUNTER myCounter1 {\n" +
			"		CPU_ID = \"slave\";\n" +
			"		MINCYCLE = 0;\n" +
			"		MAXALLOWEDVALUE = 10;\n" +
			"		TICKSPERBASE = 1;\n" +
			"	};\n" +
			"	COUNTER myCounter2 {\n" +
			"		CPU_ID = \"slave\";\n" +
			"		MINCYCLE = 0;\n" +
			"		MAXALLOWEDVALUE = 10;\n" +
			"		TICKSPERBASE = 1;\n" +
			"	};\n" +
			"	COUNTER myCounter3 {\n" +
			"		CPU_ID = \"master\";\n" +
			"		MINCYCLE = 0;\n" +
			"		MAXALLOWEDVALUE = 10;\n" +
			"		TICKSPERBASE = 1;\n" +
			"	};\n" +
			"	COUNTER myCounter4 {\n" +
			"		CPU_ID = \"slave\";\n" +
			"		MINCYCLE = 0;\n" +
			"		MAXALLOWEDVALUE = 10;\n" +
			"		TICKSPERBASE = 1;\n" +
			"	};\n" +
			"	ALARM alarm1 {\n" +
			"		COUNTER = myCounter1;\n" +
			"		ACTION = ACTIVATETASK { TASK = TaskZ6; };\n" +
			"	};\n" +

			"	ALARM AcquireAlarm2 {\n" +
			"		COUNTER = myCounter2;\n" +
			"		ACTION = INCREMENTCOUNTER { COUNTER = myCounter1; };\n" +
			"	};\n" +
			"	ALARM AcquireAlarm3 {\n" +
			"		COUNTER = myCounter3;\n" +
			"		ACTION = INCREMENTCOUNTER { COUNTER = myCounter2; };\n" +
			"	};\n" +
			"	ALARM AcquireAlarm4 {\n" +
			"		COUNTER = myCounter4;\n" +
			"		ACTION = INCREMENTCOUNTER { COUNTER = myCounter1; };\n" +
			"	};\n" +
			"};";
	    boolean ok = false;
	    try {
	    	commonWriterTest(text, 2);
	    } catch (RuntimeException e) {
	    	ok = true;
	    }
	    assertTrue(ok);
	}
	
	@Test
	public void testMpc567_multicore_isr() {
	    final String text = "CPU test_application {\n" +
			"\n" +
			"	OS EE {		\n" +
			"		EE_OPT = \"DEBUG_STACK\";\n" +
			"\n" +
			"		CFLAGS = \"-g2\";\n" +
			"		ASFLAGS = \"\";\n" +
			"		LDFLAGS = \"\"; \n" +
			"\n" +
			"		MASTER_CPU = \"master\";\n" +
		    "		CPU_DATA = PPCE200ZX {\n" +
		    "			ID = \"master\";\n" +
		    "			MODEL = E200Z6; /* NEW; also Z7 */\n" +
		    "			APP_SRC = \"master.c\";\n" +
		    "			MULTI_STACK = FALSE;\n" +
		    "			VLE = TRUE; /* NEW Default: FALSE for Z6 & Z7 */\n" +
		    "			SYS_STACK_SIZE = 4096;\n" +
			"			CPU_CLOCK = 98.5;\n" +
		    "		};\n" +
		    "\n" +
		    "		CPU_DATA = PPCE200ZX {\n" +
		    "			MODEL = E200Z0; /* -> __PPCE200Z0__ */\n" +
		    "			ID = \"slave\";\n" +
		    "			APP_SRC = \"slave.c\";\n" +
		    "			MULTI_STACK = FALSE;\n" +
		    "			VLE = TRUE; /* NEW Always TRUE for Z0 (default is TRUE) */\n" +
		    "			SYS_STACK_SIZE = 4096;\n" +
			"			CPU_CLOCK = 98.5;\n" +
		    "		};\n" +
		    "\n" +
		    "		MCU_DATA = PPCE200ZX {\n" +
		    "			MODEL = MPC5668G; /* Z6+Z0; Also MPC5674F (mono Z7) */\n" +
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
			"		KERNEL_TYPE = ECC2;\n" +
			"		ORTI_SECTIONS = ALL;\n" +
			"    };\n" +
			"    \n" +
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
			"\n" +
			"	ISR Generic_inter_isr_handler1 {\n" +
			"		CPU_ID = \"master\";\n" +
			"		CATEGORY = 2;\n" +
			"		PRIORITY = 1;\n" +
			"		ENTRY = \"7\";\n" +
			"	};\n" +
			"	ISR Generic_inter_isr_handler2 {\n" +
			"		CPU_ID = \"slave\";\n" +
			"		CATEGORY = 2;\n" +
			"		PRIORITY = 2;\n" +
			"		ENTRY = \"7\";\n" +
			"	};\n" +
			"	COUNTER myCounter1 {\n" +
			"		CPU_ID = \"slave\";\n" +
			"		MINCYCLE = 0;\n" +
			"		MAXALLOWEDVALUE = 10;\n" +
			"		TICKSPERBASE = 1;\n" +
			"		SECONDSPERTICK = 1.4;\n" +
			"		TYPE = HARDWARE { DEVICE=\"DECREMENTER\"; SYSTEM_TIMER=TRUE;};\n" +
			"	};\n" +
			"	COUNTER myCounter2 {\n" +
			"		CPU_ID = \"slave\";\n" +
			"		MINCYCLE = 0;\n" +
			"		MAXALLOWEDVALUE = 10;\n" +
			"		TICKSPERBASE = 1;\n" +
			"	};\n" +
			"	COUNTER myCounter3 {\n" +
			"		CPU_ID = \"master\";\n" +
			"		MINCYCLE = 0;\n" +
			"		MAXALLOWEDVALUE = 10;\n" +
			"		TICKSPERBASE = 1;\n" +
			"		SECONDSPERTICK = 1.4;\n" +
			"		TYPE = HARDWARE { DEVICE=\"DECREMENTER\"; SYSTEM_TIMER=TRUE;};\n" +
			"	};\n" +
			"	COUNTER myCounter4 {\n" +
			"		CPU_ID = \"slave\";\n" +
			"		MINCYCLE = 0;\n" +
			"		MAXALLOWEDVALUE = 10;\n" +
			"		TICKSPERBASE = 1;\n" +
			"	};\n" +
			"	ALARM alarm1 {\n" +
			"		COUNTER = myCounter1;\n" +
			"		ACTION = ACTIVATETASK { TASK = TaskZ6; };\n" +
			"	};\n" +

			"	ALARM AcquireAlarm2 {\n" +
			"		COUNTER = myCounter2;\n" +
			"		ACTION = INCREMENTCOUNTER { COUNTER = myCounter1; };\n" +
			"	};\n" +
			"	ALARM AcquireAlarm3 {\n" +
			"		COUNTER = myCounter3;\n" +
			"		ACTION = ACTIVATETASK { TASK = TaskZ6; };\n" +
			"	};\n" +
			"	ALARM AcquireAlarm4 {\n" +
			"		COUNTER = myCounter4;\n" +
			"		ACTION = INCREMENTCOUNTER { COUNTER = myCounter1; };\n" +
			"	};\n" +
			"};";
    	commonWriterTest(text, 2);
	}
	
	@Test
	public void testMpc567_multicore_oneClock() {
	    final String text = "CPU test_application {\n" +
			"\n" +
			"	OS EE {		\n" +
			"		EE_OPT = \"DEBUG_STACK\";\n" +
			"\n" +
			"		CFLAGS = \"-g2\";\n" +
			"		ASFLAGS = \"\";\n" +
			"		LDFLAGS = \"\"; \n" +
			"\n" +
			"		MASTER_CPU = \"master\";\n" +
		    "		CPU_DATA = PPCE200ZX {\n" +
		    "			ID = \"master\";\n" +
		    "			MODEL = E200Z6; /* NEW; also Z7 */\n" +
		    "			APP_SRC = \"master.c\";\n" +
		    "			MULTI_STACK = FALSE;\n" +
		    "			VLE = TRUE; /* NEW Default: FALSE for Z6 & Z7 */\n" +
		    "			SYS_STACK_SIZE = 4096;\n" +
			"			CPU_CLOCK = 98.5;\n" +
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
			"		STATUS = EXTENDED;\n" +
			"		STARTUPHOOK = FALSE;\n" +
			"		ERRORHOOK = FALSE;\n" +
			"		SHUTDOWNHOOK = FALSE;\n" +
			"		PRETASKHOOK = FALSE;\n" +
			"		POSTTASKHOOK = FALSE;\n" +
			"		USEGETSERVICEID = FALSE;\n" +
			"		USEPARAMETERACCESS = FALSE;\n" +
			"		USERESSCHEDULER = FALSE;\n" +
			"		KERNEL_TYPE = ECC2;\n" +
			"		ORTI_SECTIONS = ALL;\n" +
			"    };\n" +
			"    \n" +
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
			"\n" +
			"	ISR Generic_inter_isr_handler1 {\n" +
			"		CPU_ID = \"master\";\n" +
			"		CATEGORY = 2;\n" +
			"		PRIORITY = 1;\n" +
			"		ENTRY = \"7\";\n" +
			"	};\n" +
			"	ISR Generic_inter_isr_handler2 {\n" +
			"		CPU_ID = \"slave\";\n" +
			"		CATEGORY = 2;\n" +
			"		PRIORITY = 2;\n" +
			"		ENTRY = \"7\";\n" +
			"	};\n" +
			"	COUNTER myCounter1 {\n" +
			"		CPU_ID = \"slave\";\n" +
			"		MINCYCLE = 0;\n" +
			"		MAXALLOWEDVALUE = 10;\n" +
			"		TICKSPERBASE = 1;\n" +
			"		SECONDSPERTICK = 1.4;\n" +
			"		TYPE = HARDWARE { DEVICE=\"DECREMENTER\"; SYSTEM_TIMER=TRUE;};\n" +
			"	};\n" +
			"	COUNTER myCounter2 {\n" +
			"		CPU_ID = \"slave\";\n" +
			"		MINCYCLE = 0;\n" +
			"		MAXALLOWEDVALUE = 10;\n" +
			"		TICKSPERBASE = 1;\n" +
			"	};\n" +
			"	COUNTER myCounter3 {\n" +
			"		CPU_ID = \"master\";\n" +
			"		MINCYCLE = 0;\n" +
			"		MAXALLOWEDVALUE = 10;\n" +
			"		TICKSPERBASE = 1;\n" +
			"		SECONDSPERTICK = 1.4;\n" +
			"		TYPE = HARDWARE { DEVICE=\"DECREMENTER\"; SYSTEM_TIMER=TRUE;};\n" +
			"	};\n" +
			"	COUNTER myCounter4 {\n" +
			"		CPU_ID = \"slave\";\n" +
			"		MINCYCLE = 0;\n" +
			"		MAXALLOWEDVALUE = 10;\n" +
			"		TICKSPERBASE = 1;\n" +
			"	};\n" +
			"	ALARM alarm1 {\n" +
			"		COUNTER = myCounter1;\n" +
			"		ACTION = ACTIVATETASK { TASK = TaskZ6; };\n" +
			"	};\n" +

			"	ALARM AcquireAlarm2 {\n" +
			"		COUNTER = myCounter2;\n" +
			"		ACTION = INCREMENTCOUNTER { COUNTER = myCounter1; };\n" +
			"	};\n" +
			"	ALARM AcquireAlarm3 {\n" +
			"		COUNTER = myCounter3;\n" +
			"		ACTION = ACTIVATETASK { TASK = TaskZ6; };\n" +
			"	};\n" +
			"	ALARM AcquireAlarm4 {\n" +
			"		COUNTER = myCounter4;\n" +
			"		ACTION = INCREMENTCOUNTER { COUNTER = myCounter1; };\n" +
			"	};\n" +
			"};";
    	commonWriterTest(text, 2);
	}
	

	@Test
	public void testMpc567_multicore_isr2() {
	    final String text = "CPU test_application {\n" +
			"\n" +
			"	OS EE {		\n" +
			"		EE_OPT = \"DEBUG_STACK\";\n" +
			"\n" +
			"		CFLAGS = \"-g2\";\n" +
			"		ASFLAGS = \"\";\n" +
			"		LDFLAGS = \"\"; \n" +
			"\n" +
			"		MASTER_CPU = \"master\";\n" +
		    "		CPU_DATA = PPCE200ZX {\n" +
		    "			ID = \"master\";\n" +
		    "			MODEL = E200Z6; /* NEW; also Z7 */\n" +
		    "			APP_SRC = \"master.c\";\n" +
		    "			MULTI_STACK = FALSE;\n" +
		    "			VLE = TRUE; /* NEW Default: FALSE for Z6 & Z7 */\n" +
		    "			SYS_STACK_SIZE = 4096;\n" +
			"			CPU_CLOCK = 98.5;\n" +
		    "		};\n" +
		    "\n" +
		    "		CPU_DATA = PPCE200ZX {\n" +
		    "			MODEL = E200Z0; /* -> __PPCE200Z0__ */\n" +
		    "			ID = \"slave\";\n" +
		    "			APP_SRC = \"slave.c\";\n" +
		    "			MULTI_STACK = FALSE;\n" +
		    "			VLE = TRUE; /* NEW Always TRUE for Z0 (default is TRUE) */\n" +
		    "			SYS_STACK_SIZE = 4096;\n" +
			"			CPU_CLOCK = 98.5;\n" +
		    "		};\n" +
		    "\n" +
		    "		MCU_DATA = PPCE200ZX {\n" +
		    "			MODEL = MPC5668G; /* Z6+Z0; Also MPC5674F (mono Z7) */\n" +
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
			"		KERNEL_TYPE = ECC2;\n" +
			"		ORTI_SECTIONS = ALL;\n" +
			"    };\n" +
			"    \n" +
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
			"\n" +
			"	ISR Generic_inter_isr_master1 {\n" +
			"		CPU_ID = \"master\";\n" +
			"		CATEGORY = 2;\n" +
			"		PRIORITY = 1;\n" +
			"		ENTRY = \"1\";\n" +
			"	};\n" +
			"	ISR Generic_inter_isr_master7 {\n" +
			"		CPU_ID = \"master\";\n" +
			"		CATEGORY = 2;\n" +
			"		PRIORITY = 2;\n" +
			"		ENTRY = \"7\";\n" +
			"	};\n" +
			"	ISR Generic_inter_isr_slave7 {\n" +
			"		CPU_ID = \"slave\";\n" +
			"		CATEGORY = 2;\n" +
			"		PRIORITY = 2;\n" +
			"		ENTRY = \"7\";\n" +
			"	};\n" +
			"	ISR Generic_inter_isr_master5 {\n" +
			"		CPU_ID = \"master\";\n" +
			"		CATEGORY = 2;\n" +
			"		PRIORITY = 2;\n" +
			"		HANDLER = \"common_handler5\";\n" +
			"		ENTRY = \"5\";\n" +
			"	};\n" +
			"	ISR Generic_inter_isr_slave5 {\n" +
			"		CPU_ID = \"slave\";\n" +
			"		CATEGORY = 2;\n" +
			"		PRIORITY = 2;\n" +
			"		HANDLER = \"common_handler5\";\n" +
			"		ENTRY = \"5\";\n" +
			"	};\n" +
			"	ISR Generic_inter_isr_slave8 {\n" +
			"		CPU_ID = \"slave\";\n" +
			"		CATEGORY = 2;\n" +
			"		PRIORITY = 2;\n" +
			"		ENTRY = \"8\";\n" +
			"	};\n" +
			"	COUNTER myCounter1 {\n" +
			"		CPU_ID = \"slave\";\n" +
			"		MINCYCLE = 0;\n" +
			"		MAXALLOWEDVALUE = 10;\n" +
			"		TICKSPERBASE = 1;\n" +
			"		SECONDSPERTICK = 1.4;\n" +
			"		TYPE = HARDWARE { DEVICE=\"DECREMENTER\"; SYSTEM_TIMER=TRUE;};\n" +
			"	};\n" +
			"	COUNTER myCounter2 {\n" +
			"		CPU_ID = \"slave\";\n" +
			"		MINCYCLE = 0;\n" +
			"		MAXALLOWEDVALUE = 10;\n" +
			"		TICKSPERBASE = 1;\n" +
			"	};\n" +
			"	COUNTER myCounter3 {\n" +
			"		CPU_ID = \"master\";\n" +
			"		MINCYCLE = 0;\n" +
			"		MAXALLOWEDVALUE = 10;\n" +
			"		TICKSPERBASE = 1;\n" +
			"		SECONDSPERTICK = 1.4;\n" +
			"		TYPE = HARDWARE { DEVICE=\"DECREMENTER\"; SYSTEM_TIMER=TRUE;};\n" +
			"	};\n" +
			"	COUNTER myCounter4 {\n" +
			"		CPU_ID = \"slave\";\n" +
			"		MINCYCLE = 0;\n" +
			"		MAXALLOWEDVALUE = 10;\n" +
			"		TICKSPERBASE = 1;\n" +
			"	};\n" +
			"	ALARM alarm1 {\n" +
			"		COUNTER = myCounter1;\n" +
			"		ACTION = ACTIVATETASK { TASK = TaskZ6; };\n" +
			"	};\n" +

			"	ALARM AcquireAlarm2 {\n" +
			"		COUNTER = myCounter2;\n" +
			"		ACTION = INCREMENTCOUNTER { COUNTER = myCounter1; };\n" +
			"	};\n" +
			"	ALARM AcquireAlarm3 {\n" +
			"		COUNTER = myCounter3;\n" +
			"		ACTION = ACTIVATETASK { TASK = TaskZ6; };\n" +
			"	};\n" +
			"	ALARM AcquireAlarm4 {\n" +
			"		COUNTER = myCounter4;\n" +
			"		ACTION = INCREMENTCOUNTER { COUNTER = myCounter1; };\n" +
			"	};\n" +
			"};";
    	commonWriterTest(text, 2);
	}
	
	@Test public void testDoublez4_timer_decrementer() {
	    final String text = "CPU test_application {\n"+
			"\n"+
			"	OS EE {\n"+
			"		EE_OPT = \"__ASSERT__\";\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\";\n"+
			"\n"+
			"		EE_OPT = \"__E200ZX_EXECUTE_FROM_RAM__\";\n"+
			"\n"+
			"		MASTER_CPU = \"master\";\n"+
			"\n"+
			"		CPU_DATA = PPCE200ZX {\n"+
			"			ID = \"master\";\n"+
			"			MODEL = E200Z4;\n"+
			"			APP_SRC = \"master.c\";\n"+
			"			MULTI_STACK = FALSE;\n"+
			"			VLE = TRUE;\n"+
			"			SYS_STACK_SIZE = 4096;\n"+
			"			CPU_CLOCK = 98.5;\n" +
			"		};\n"+
			"\n"+
			"		CPU_DATA = PPCE200ZX {\n"+
			"			MODEL = E200Z4;\n"+
			"			ID = \"slave\";\n"+
			"			APP_SRC = \"slave.c\";\n"+
			"			MULTI_STACK = FALSE;\n"+
			"			VLE = TRUE;\n"+
			"			SYS_STACK_SIZE = 4096;\n"+
			"		};\n"+
			"\n"+
			"		MCU_DATA = PPCE200ZX {\n"+
			"			MODEL = MPC5643L;\n"+
			"		};\n"+
			"\n"+
			"		STATUS = EXTENDED;\n"+
			"		STARTUPHOOK = FALSE;\n"+
			"		ERRORHOOK = FALSE;\n"+
			"		SHUTDOWNHOOK = FALSE;\n"+
			"		PRETASKHOOK = FALSE;\n"+
			"		POSTTASKHOOK = FALSE;\n"+
			"		USEGETSERVICEID = FALSE;\n"+
			"		USEPARAMETERACCESS = FALSE;\n"+
			"		USERESSCHEDULER = FALSE;\n"+
			"\n"+
			"		USEREMOTETASK = ALWAYS;\n"+
			"		ORTI_SECTIONS = ALL;\n"+
			"\n"+
			"		KERNEL_TYPE = BCC1;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ6 {\n"+
			"		CPU_ID = \"master\";\n"+
			"		PRIORITY = 1;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ6b {\n"+
			"		CPU_ID = \"master\";\n"+
			"		PRIORITY = 3;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ6c {\n"+
			"		CPU_ID = \"master\";\n"+
			"		PRIORITY = 2;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ0 {\n"+
			"		CPU_ID = \"slave\";\n"+
			"		PRIORITY = 1;\n"+
			"		AUTOSTART = TRUE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ0b {\n"+
			"		CPU_ID = \"slave\";\n"+
			"		PRIORITY = 2;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ0c {\n"+
			"		CPU_ID = \"slave\";\n"+
			"		PRIORITY = 3;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"	COUNTER myCounter1 {\n" +
			"		CPU_ID = \"slave\";\n" +
			"		MINCYCLE = 0;\n" +
			"		MAXALLOWEDVALUE = 10;\n" +
			"		TICKSPERBASE = 1;\n" +
			"		SECONDSPERTICK = 1.4;\n" +
			"		TYPE = HARDWARE { DEVICE=\"DECREMENTER\"; SYSTEM_TIMER=TRUE;};\n" +
			"	};\n" +
			"	COUNTER myCounter {\n" +
			"		CPU_ID = \"slave\";\n" +
			"		MINCYCLE = 0;\n" +
			"		MAXALLOWEDVALUE = 10;\n" +
			"		TICKSPERBASE = 1;\n" +
			"	};\n" +
			"	ALARM AcquireAlarm {\n" +
			"		COUNTER = myCounter1;\n" +
			"		ACTION = INCREMENTCOUNTER { COUNTER = myCounter; };\n" +
			"	};\n" +
			"};\n";
		commonWriterTest(text, 2);
	}

	@Test public void testDoublez4_timer_stm() {
	    final String text = "CPU test_application {\n"+
			"\n"+
			"	OS EE {\n"+
			"		EE_OPT = \"__ASSERT__\";\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\";\n"+
			"\n"+
			"		EE_OPT = \"__E200ZX_EXECUTE_FROM_RAM__\";\n"+
			"\n"+
			"		MASTER_CPU = \"master\";\n"+
			"\n"+
			"		CPU_DATA = PPCE200ZX {\n"+
			"			ID = \"master\";\n"+
			"			MODEL = E200Z4;\n"+
			"			APP_SRC = \"master.c\";\n"+
			"			MULTI_STACK = FALSE;\n"+
			"			VLE = TRUE;\n"+
			"			SYS_STACK_SIZE = 4096;\n"+
			"			CPU_CLOCK = 98.5;\n" +
			"		};\n"+
			"\n"+
			"		CPU_DATA = PPCE200ZX {\n"+
			"			MODEL = E200Z4;\n"+
			"			ID = \"slave\";\n"+
			"			APP_SRC = \"slave.c\";\n"+
			"			MULTI_STACK = FALSE;\n"+
			"			VLE = TRUE;\n"+
			"			SYS_STACK_SIZE = 4096;\n"+
			"		};\n"+
			"\n"+
			"		MCU_DATA = PPCE200ZX {\n"+
			"			MODEL = MPC5643L;\n"+
			"		};\n"+
			"\n"+
			"		STATUS = EXTENDED;\n"+
			"		STARTUPHOOK = FALSE;\n"+
			"		ERRORHOOK = FALSE;\n"+
			"		SHUTDOWNHOOK = FALSE;\n"+
			"		PRETASKHOOK = FALSE;\n"+
			"		POSTTASKHOOK = FALSE;\n"+
			"		USEGETSERVICEID = FALSE;\n"+
			"		USEPARAMETERACCESS = FALSE;\n"+
			"		USERESSCHEDULER = FALSE;\n"+
			"\n"+
			"		USEREMOTETASK = ALWAYS;\n"+
			"		ORTI_SECTIONS = ALL;\n"+
			"\n"+
			"		KERNEL_TYPE = BCC1;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ6 {\n"+
			"		CPU_ID = \"master\";\n"+
			"		PRIORITY = 1;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ6b {\n"+
			"		CPU_ID = \"master\";\n"+
			"		PRIORITY = 3;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ6c {\n"+
			"		CPU_ID = \"master\";\n"+
			"		PRIORITY = 2;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ0 {\n"+
			"		CPU_ID = \"slave\";\n"+
			"		PRIORITY = 1;\n"+
			"		AUTOSTART = TRUE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ0b {\n"+
			"		CPU_ID = \"slave\";\n"+
			"		PRIORITY = 2;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ0c {\n"+
			"		CPU_ID = \"slave\";\n"+
			"		PRIORITY = 3;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"	ISR Generic_inter_isr_handler1 {\n" +
			"		CPU_ID = \"slave\";\n" +
			"		CATEGORY = 2;\n" +
			"		PRIORITY = 1;\n" +
			"		ENTRY = \"7\";\n" +
			"	};\n" +
			"	ISR Generic_inter_isr_handler2 {\n" +
			"		CPU_ID = \"slave\";\n" +
			"		CATEGORY = 2;\n" +
			"		PRIORITY = 2;\n" +
			"		ENTRY = \"19\";\n" +
			"	};\n" +
			"	COUNTER myCounter1 {\n" +
			"		CPU_ID = \"slave\";\n" +
			"		MINCYCLE = 0;\n" +
			"		MAXALLOWEDVALUE = 10;\n" +
			"		TICKSPERBASE = 1;\n" +
			"		SECONDSPERTICK = 1.4;\n" +
			"		TYPE = HARDWARE { DEVICE=\"STM\"; SYSTEM_TIMER=TRUE;};\n" +
			"	};\n" +
			"	COUNTER myCounter {\n" +
			"		CPU_ID = \"slave\";\n" +
			"		MINCYCLE = 0;\n" +
			"		MAXALLOWEDVALUE = 10;\n" +
			"		TICKSPERBASE = 1;\n" +
			"	};\n" +
			"	ALARM AcquireAlarm {\n" +
			"		COUNTER = myCounter1;\n" +
			"		ACTION = INCREMENTCOUNTER { COUNTER = myCounter; };\n" +
			"	};\n" +
			"};\n";
		commonWriterTest(text, 2);
	}

	@Test public void testDoublez4_timer_stm_handler() {
	    final String text = "CPU test_application {\n"+
			"\n"+
			"	OS EE {\n"+
			"		EE_OPT = \"__ASSERT__\";\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\";\n"+
			"\n"+
			"		EE_OPT = \"__E200ZX_EXECUTE_FROM_RAM__\";\n"+
			"\n"+
			"		MASTER_CPU = \"master\";\n"+
			"\n"+
			"		CPU_DATA = PPCE200ZX {\n"+
			"			ID = \"master\";\n"+
			"			MODEL = E200Z4;\n"+
			"			APP_SRC = \"master.c\";\n"+
			"			MULTI_STACK = FALSE;\n"+
			"			VLE = TRUE;\n"+
			"			SYS_STACK_SIZE = 4096;\n"+
			"			CPU_CLOCK = 98.5;\n" +
			"		};\n"+
			"\n"+
			"		CPU_DATA = PPCE200ZX {\n"+
			"			MODEL = E200Z4;\n"+
			"			ID = \"slave\";\n"+
			"			APP_SRC = \"slave.c\";\n"+
			"			MULTI_STACK = FALSE;\n"+
			"			VLE = TRUE;\n"+
			"			SYS_STACK_SIZE = 4096;\n"+
			"		};\n"+
			"\n"+
			"		MCU_DATA = PPCE200ZX {\n"+
			"			MODEL = MPC5643L;\n"+
			"		};\n"+
			"\n"+
			"		STATUS = EXTENDED;\n"+
			"		STARTUPHOOK = FALSE;\n"+
			"		ERRORHOOK = FALSE;\n"+
			"		SHUTDOWNHOOK = FALSE;\n"+
			"		PRETASKHOOK = FALSE;\n"+
			"		POSTTASKHOOK = FALSE;\n"+
			"		USEGETSERVICEID = FALSE;\n"+
			"		USEPARAMETERACCESS = FALSE;\n"+
			"		USERESSCHEDULER = FALSE;\n"+
			"\n"+
			"		USEREMOTETASK = ALWAYS;\n"+
			"		ORTI_SECTIONS = ALL;\n"+
			"\n"+
			"		KERNEL_TYPE = BCC1;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ6 {\n"+
			"		CPU_ID = \"master\";\n"+
			"		PRIORITY = 1;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ6b {\n"+
			"		CPU_ID = \"master\";\n"+
			"		PRIORITY = 3;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ6c {\n"+
			"		CPU_ID = \"master\";\n"+
			"		PRIORITY = 2;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ0 {\n"+
			"		CPU_ID = \"slave\";\n"+
			"		PRIORITY = 1;\n"+
			"		AUTOSTART = TRUE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ0b {\n"+
			"		CPU_ID = \"slave\";\n"+
			"		PRIORITY = 2;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ0c {\n"+
			"		CPU_ID = \"slave\";\n"+
			"		PRIORITY = 3;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"	ISR Generic_inter_isr_handler1 {\n" +
			"		CPU_ID = \"slave\";\n" +
			"		CATEGORY = 2;\n" +
			"		PRIORITY = 1;\n" +
			"		ENTRY = \"7\";\n" +
			"	};\n" +
			"	ISR Generic_inter_isr_handler2 {\n" +
			"		CPU_ID = \"slave\";\n" +
			"		CATEGORY = 2;\n" +
			"		PRIORITY = 2;\n" +
			"		ENTRY = \"19\";\n" +
			"	};\n" +
			"	COUNTER myCounter1 {\n" +
			"		CPU_ID = \"slave\";\n" +
			"		MINCYCLE = 0;\n" +
			"		MAXALLOWEDVALUE = 10;\n" +
			"		TICKSPERBASE = 1;\n" +
			"		SECONDSPERTICK = 1.4;\n" +
			"		TYPE = HARDWARE { DEVICE=\"STM\"; HANDLER=\"user_stm_handler\";};\n" +
			"	};\n" +
			"	COUNTER myCounter {\n" +
			"		CPU_ID = \"slave\";\n" +
			"		MINCYCLE = 0;\n" +
			"		MAXALLOWEDVALUE = 10;\n" +
			"		TICKSPERBASE = 1;\n" +
			"	};\n" +
			"	ALARM AcquireAlarm {\n" +
			"		COUNTER = myCounter1;\n" +
			"		ACTION = INCREMENTCOUNTER { COUNTER = myCounter; };\n" +
			"	};\n" +
			"};\n";
		commonWriterTest(text, 2);
	}

}
