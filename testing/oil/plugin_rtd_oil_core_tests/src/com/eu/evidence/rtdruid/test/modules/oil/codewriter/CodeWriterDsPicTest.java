package com.eu.evidence.rtdruid.test.modules.oil.codewriter;

import org.junit.Test;

import com.eu.evidence.rtdruid.vartree.Vt2StringUtilities;



public class CodeWriterDsPicTest extends AbstractCodeWriterTest {
	

	@Test public void testDS_PIC30_splitted() {
	    final String text =
				"CPU mySystem {\n" + 
				"\n" + 
				"	OS myOs {\n" + 
				"	                \n" + 
				"		EE_OPT = \"DEBUG\";\n" + 
				"        STATUS = EXTENDED;\n" + 
				"\n" + 
				"        STARTUPHOOK = TRUE;\n" + 
				"        ERRORHOOK = FALSE;\n" + 
				"        SHUTDOWNHOOK = FALSE;\n" + 
				"    };\n" + 
//				"};\n" + 
//				"CPU mySystem {\n" + 
				"	OS myOs {\n" + 
				"		EE_OPT = \"DEBUG2\";\n" + 
				"        PRETASKHOOK = FALSE;\n" + 
				"        POSTTASKHOOK = FALSE;\n" + 
				"        USEGETSERVICEID = FALSE;\n" + 
				"        USEPARAMETERACCESS = FALSE;\n" + 
				"        USERESSCHEDULER = TRUE;\n" + 
				"        \n" + 
				"        CPU_DATA = PIC30 {\n" + 
				"			APP_SRC = \"code.c\";\n" +
				"        };\n" +
				"    };\n" + 
//				"};\n" + 
//				"CPU mySystem {\n" + 
				"	OS myOs {\n" + 
				"        CPU_DATA = PIC30 {\n" + 
				"			APP_SRC = \"T1.S\";\n" + 
				"			MULTI_STACK = TRUE {\n" + 
				"				IRQ_STACK = TRUE {\n" + 
				"					SYS_SIZE=64;\n" + 
				"				};\n" + 
//				"				DUMMY_STACK = SHARED;\n" + 
				"			};\n" + 
//				"			STACK_BOTTOM = 0xFFFF;\n" + 
//				"			SYS_SIZE = 256;    // available space for all user stacks\n" + 
//				"			SHARED_MIN_SYS_SIZE = 64;    // size of shared stack\n" + 
				"	\n" + 
				"			ICD2 = TRUE;\n" + 
				"				\n" + 
//				"			LINKER_SCRIPT = \"p30f2010.gld\";\n" + 
				"		};\n" + 
				"\n" + 
				"		KERNEL_TYPE = BCC1;\n" + 
				
				"		BOARD_DATA = EE_FLEX {\n" + 
				"			TYPE = STANDARD {" +
				"				OPTIONS = LEDS;\n" + 
				"				OPTIONS = LCD;\n" + 
				"			};\n" + 
				"		};\n" + 
				"	};\n" + 
				"\n" + 
				"    TASK Task0 {\n" + 
				"        PRIORITY = 1;\n" + 
				"        ACTIVATION = 4;\n" + 
				"        STACK = PRIVATE {\n" + 
				"			SYS_SIZE = 64;\n" + 
				"		};\n" + 
				"		SCHEDULE = FULL;\n" + 
				"		RESOURCE = MUTEX_sync;\n" + 
				"	};\n" + 
				"\n" + 
				"    TASK Task1 {\n" + 
				"        PRIORITY = 2;\n" + 
				"        ACTIVATION = 4;\n" + 
				"	};\n" + 
				"\n" + 
				"    TASK Task1 {\n" + 
				"        STACK = SHARED;\n" + 
				"        SCHEDULE = FULL;\n" + 
				"    };\n" + 
				"\n" + 
				"    TASK Task2 {\n" + 
				"        PRIORITY = 3;\n" + 
				"        ACTIVATION = 4;\n" + 
				"		STACK = SHARED;\n" + 
				"        SCHEDULE = FULL;\n" + 
				"        RESOURCE = MUTEX_sync;\n" + 
				"    };\n" + 
				"\n" + 
				"    TASK Task3 {\n" + 
				"        PRIORITY = 4;\n" + 
				"        ACTIVATION = 4;\n" + 
				"		STACK = SHARED;\n" + 
				"        SCHEDULE = FULL;\n" + 
				"    };\n" + 
				"\n" + 
				"    RESOURCE MUTEX_sync { RESOURCEPROPERTY = STANDARD; };\n" + 
				"};\n";
		commonWriterTest(text, 1);
	}

	@Test public void testDS_PIC30_1() {
	    final String text =
				"CPU mySystem {\n" + 
				"\n" + 
				"	OS myOs {\n" + 
				"	                \n" + 
				"		EE_OPT = \"DEBUG\";\n" + 
				"        STATUS = EXTENDED;\n" + 
				"\n" + 
				"        STARTUPHOOK = TRUE;\n" + 
				"        ERRORHOOK = FALSE;\n" + 
				"        SHUTDOWNHOOK = FALSE;\n" + 
				"        PRETASKHOOK = FALSE;\n" + 
				"        POSTTASKHOOK = FALSE;\n" + 
				"        USEGETSERVICEID = FALSE;\n" + 
				"        USEPARAMETERACCESS = FALSE;\n" + 
				"        USERESSCHEDULER = TRUE;\n" + 
				"        \n" + 
				"        CPU_DATA = PIC30 {\n" + 
				"			APP_SRC = \"code.c\";\n" + 
				"			APP_SRC = \"T1.S\";\n" + 
				"			MULTI_STACK = TRUE {\n" + 
				"				IRQ_STACK = TRUE {\n" + 
				"					SYS_SIZE=64;\n" + 
				"				};\n" + 
//				"				DUMMY_STACK = SHARED;\n" + 
				"			};\n" + 
//				"			STACK_BOTTOM = 0xFFFF;\n" + 
//				"			SYS_SIZE = 256;    // available space for all user stacks\n" + 
//				"			SHARED_MIN_SYS_SIZE = 64;    // size of shared stack\n" + 
				"	\n" + 
				"			ICD2 = TRUE;\n" + 
				"				\n" + 
//				"			LINKER_SCRIPT = \"p30f2010.gld\";\n" + 
				"		};\n" + 
				"\n" + 
				"		KERNEL_TYPE = BCC1;\n" + 
				
				"		BOARD_DATA = EE_FLEX {\n" + 
				"			TYPE = STANDARD {" +
				"				OPTIONS = LEDS;\n" + 
				"				OPTIONS = LCD;\n" + 
				"			};\n" + 
				"		};\n" + 
				"	};\n" + 
				"\n" + 
				"    TASK Task0 {\n" + 
				"        PRIORITY = 1;\n" + 
				"        ACTIVATION = 4;\n" + 
				"        STACK = PRIVATE {\n" + 
				"			SYS_SIZE = 64;\n" + 
				"		};\n" + 
				"		SCHEDULE = FULL;\n" + 
				"		RESOURCE = MUTEX_sync;\n" + 
				"	};\n" + 
				"\n" + 
				"    TASK Task1 {\n" + 
				"        PRIORITY = 2;\n" + 
				"        ACTIVATION = 4;\n" + 
				"        STACK = SHARED;\n" + 
				"        SCHEDULE = FULL;\n" + 
				"    };\n" + 
				"\n" + 
				"    TASK Task2 {\n" + 
				"        PRIORITY = 3;\n" + 
				"        ACTIVATION = 4;\n" + 
				"		STACK = SHARED;\n" + 
				"        SCHEDULE = FULL;\n" + 
				"        RESOURCE = MUTEX_sync;\n" + 
				"        APP_SRC = \"demo.c\";\n" + 
				"    };\n" + 
				"\n" + 
				"    TASK Task3 {\n" + 
				"        PRIORITY = 4;\n" + 
				"        ACTIVATION = 4;\n" + 
				"		STACK = SHARED;\n" + 
				"        SCHEDULE = FULL;\n" + 
				"        APP_SRC = \"demo1.c\";\n" + 
				"        APP_SRC = \"demo2.c\";\n" + 
				"    };\n" + 
				"    RESOURCE MUTEX_sync { RESOURCEPROPERTY = STANDARD {" +
				"        APP_SRC = \"demo3.c\";\n" + 
				"        APP_SRC = \"demo4.c\";\n" + 
				"    };};\n" + 
				"};\n";
		commonWriterTest(text, 1);
	}

	@Test public void testDS_PIC30_2() {
	    final String text =
				"CPU mySystem {\n" + 
				"\n" + 
				"	OS myOs {\n" + 
				"	                \n" + 
				"		 EE_OPT = \"DEBUG\";\n" + 
				"        STATUS = EXTENDED;\n" + 
				"\n" + 
				"        STARTUPHOOK = TRUE;\n" + 
				"        ERRORHOOK = FALSE;\n" + 
				"        SHUTDOWNHOOK = FALSE;\n" + 
				"        PRETASKHOOK = FALSE;\n" + 
				"        POSTTASKHOOK = FALSE;\n" + 
				"        USEGETSERVICEID = FALSE;\n" + 
				"        USEPARAMETERACCESS = FALSE;\n" + 
				"        USERESSCHEDULER = TRUE;\n" + 
				"        \n" + 
				"        CPU_DATA = PIC30 {\n" + 
				"			APP_SRC = \"code.c\";\n" + 
				"			APP_SRC = \"T1.S\";\n" + 
				"			MULTI_STACK = TRUE;\n" + 
				"	\n" + 
//				"			LINKER_SCRIPT = \"p30f2010.gld\";\n" + 
				"		};\n" + 
				"\n" + 
				"		KERNEL_TYPE = BCC1;\n" + 
				"	};\n" + 
				"\n" + 
				"    TASK Task0 {\n" + 
				"        PRIORITY = 1;\n" + 
				"        ACTIVATION = 4;\n" + 
				"        STACK = PRIVATE {\n" + 
				"			SYS_SIZE = 65;\n" + 
				"		};\n" + 
				"		SCHEDULE = FULL;\n" + 
				"		RESOURCE = MUTEX_sync;\n" + 
				"	};\n" + 
				"\n" + 
				"    TASK Task1 {\n" + 
				"        PRIORITY = 2;\n" + 
				"        ACTIVATION = 4;\n" + 
				"        STACK = SHARED;\n" + 
				"        SCHEDULE = FULL;\n" + 
				"    };\n" + 
				"\n" + 
				"    TASK Task2 {\n" + 
				"        PRIORITY = 3;\n" + 
				"        ACTIVATION = 4;\n" + 
				"		 STACK = SHARED;\n" + 
				"        SCHEDULE = FULL;\n" + 
				"        RESOURCE = MUTEX_sync;\n" + 
				"    };\n" + 
				"\n" + 
				"    TASK Task3 {\n" + 
				"        PRIORITY = 4;\n" + 
				"        ACTIVATION = 4;\n" + 
				"		 STACK = SHARED;\n" + 
				"        SCHEDULE = FULL;\n" + 
				"    };\n" + 
				"\n" + 
				"    RESOURCE MUTEX_sync { RESOURCEPROPERTY = STANDARD; };\n" + 
				"};\n";
		commonWriterTest(text, 1);
	}

	@Test public void testDS_PIC24HJ64GP502() {
	    final String text =
		"CPU test_application {" + 
		"" + 
		"	OS EE {" + 
		"		EE_OPT = \"DEBUG\";" + 
		"" + 
		"		CPU_DATA = PIC30 {" + 
		"			APP_SRC = \"code.c\";" + 
		"			MULTI_STACK = FALSE;" + 
		"			ICD2 = TRUE;" + 
		"		};" + 
		"" + 
		"		MCU_DATA = PIC30 {" + 
		"			MODEL = PIC24HJ64GP502;" + 
		"		};" + 
		"" + 
		"		STATUS = EXTENDED;" + 
		"		STARTUPHOOK = FALSE;" + 
		"		ERRORHOOK = FALSE;" + 
		"		SHUTDOWNHOOK = FALSE;" + 
		"		PRETASKHOOK = FALSE;" + 
		"		POSTTASKHOOK = FALSE;" + 
		"		USEGETSERVICEID = FALSE;" + 
		"		USEPARAMETERACCESS = FALSE;" + 
		"		USERESSCHEDULER = FALSE;" + 
		"		KERNEL_TYPE = BCC1;" +
		"	};" + 
		"" + 
		"	/* this is the OIL part for the task displaying the christmas tree */" + 
		"    TASK Task1 {" + 
		"		PRIORITY = 0x01;   /* Low priority */" + 
		"		AUTOSTART = FALSE;" + 
		"		STACK = SHARED;" + 
		"		SCHEDULE = FULL;" + 
		"		ACTIVATION = 1;    /* only one pending activation */" + 
		"	};	" + 
		"	" + 
		"	/* this is the OIL part for the task activated by the button press */" + 
		"    TASK Task2 {" + 
		"		PRIORITY = 0x02;   /* High priority */" + 
		"		SCHEDULE = FULL;" + 
		"		AUTOSTART = TRUE;	" + 
		"		STACK = SHARED;" +
		"		ACTIVATION = 1;" +
		"    };" + 
		"};";
		commonWriterTest(text, 1);
	}

	@Test public void testDS_PIC33FJ64MC802() {
	    final String text =
		"CPU test_application {" + 
		"" + 
		"	OS EE {" + 
		"		EE_OPT = \"DEBUG\";" + 
		"" + 
		"		CPU_DATA = PIC30 {" + 
		"			APP_SRC = \"code.c\";" + 
		"			MULTI_STACK = FALSE;" + 
		"			ICD2 = TRUE;" + 
		"		};" + 
		"" + 
		"		MCU_DATA = PIC30 {" + 
		"			MODEL = PIC33FJ64MC802;" + 
		"		};" + 
		"" + 
		"		STATUS = EXTENDED;" + 
		"		STARTUPHOOK = FALSE;" + 
		"		ERRORHOOK = FALSE;" + 
		"		SHUTDOWNHOOK = FALSE;" + 
		"		PRETASKHOOK = FALSE;" + 
		"		POSTTASKHOOK = FALSE;" + 
		"		USEGETSERVICEID = FALSE;" + 
		"		USEPARAMETERACCESS = FALSE;" + 
		"		USERESSCHEDULER = FALSE;" + 
		"		KERNEL_TYPE = BCC1;" +
		"	};" + 
		"" + 
		"	/* this is the OIL part for the task displaying the christmas tree */" + 
		"    TASK Task1 {" + 
		"		PRIORITY = 0x01;   /* Low priority */" + 
		"		AUTOSTART = FALSE;" + 
		"		STACK = SHARED;" + 
		"		SCHEDULE = FULL;" + 
		"		ACTIVATION = 1;    /* only one pending activation */" + 
		"	};	" + 
		"	" + 
		"	/* this is the OIL part for the task activated by the button press */" + 
		"    TASK Task2 {" + 
		"		PRIORITY = 0x02;   /* High priority */" + 
		"		SCHEDULE = FULL;" + 
		"		AUTOSTART = TRUE;	" + 
		"		STACK = SHARED;" +
		"		ACTIVATION = 1;" +
		"    };" + 
		"};";
		commonWriterTest(text, 1);
	}

	
	@Test public void testDS_PIC30_BCC1() {
	    final String text =
		"CPU test_application {" + 
		"" + 
		"	OS EE {" + 
		"		EE_OPT = \"DEBUG\";" + 
		"" + 
		"		CPU_DATA = PIC30 {" + 
		"			APP_SRC = \"code.c\";" + 
		"			MULTI_STACK = FALSE;" + 
		"			ICD2 = TRUE;" + 
		"		};" + 
		"" + 
		"		MCU_DATA = PIC30 {" + 
		"			MODEL = PIC33FJ256MC710;" + 
		"		};" + 
		"" + 
		"		BOARD_DATA = EE_FLEX {" + 
		"			TYPE = DEMO {" + 
		"				OPTIONS = ALL;" + 
		"			};" + 
		"		};" + 
		"" + 
		"		STATUS = EXTENDED;" + 
		"		STARTUPHOOK = FALSE;" + 
		"		ERRORHOOK = FALSE;" + 
		"		SHUTDOWNHOOK = FALSE;" + 
		"		PRETASKHOOK = FALSE;" + 
		"		POSTTASKHOOK = FALSE;" + 
		"		USEGETSERVICEID = FALSE;" + 
		"		USEPARAMETERACCESS = FALSE;" + 
		"		USERESSCHEDULER = FALSE;" + 
		"	};" + 
		"" + 
		"	/* this is the OIL part for the task displaying the christmas tree */" + 
		"    TASK Task1 {" + 
		"		PRIORITY = 0x01;   /* Low priority */" + 
		"		AUTOSTART = FALSE;" + 
		"		STACK = SHARED;" + 
		"		ACTIVATION = 1;    /* only one pending activation */" + 
		"	};	" + 
		"	" + 
		"	/* this is the OIL part for the task activated by the button press */" + 
		"    TASK Task2 {" + 
		"		PRIORITY = 0x02;   /* High priority */" + 
		"		SCHEDULE = FULL;" + 
		"		AUTOSTART = TRUE;	" + 
		"		STACK = SHARED;" + 
		"    };" + 
		"    OS EE { KERNEL_TYPE = BCC1; }; " + 
		"	TASK Task1 { SCHEDULE = NON; };" + 
		"	TASK Task2 { ACTIVATION = 1; };" + 
		"};";
		commonWriterTest(text, 1);
	}

	@Test public void testDS_PIC30_LIB() {
	    final String text =
				"CPU mySystem {\n" + 
				"\n" + 
				"	OS myOs {\n" + 
				"	                \n" + 
				"		 EE_OPT = \"DEBUG\";\n" + 
				"        STATUS = EXTENDED;\n" + 
				"\n" + 
				"        STARTUPHOOK = TRUE;\n" + 
				"        ERRORHOOK = FALSE;\n" + 
				"        SHUTDOWNHOOK = FALSE;\n" + 
				"        PRETASKHOOK = FALSE;\n" + 
				"        POSTTASKHOOK = FALSE;\n" + 
				"        USEGETSERVICEID = FALSE;\n" + 
				"        USEPARAMETERACCESS = FALSE;\n" + 
				"        USERESSCHEDULER = TRUE;\n" + 
				"        \n" + 
				"        CPU_DATA = PIC30 {\n" + 
				"			APP_SRC = \"code.c\";\n" + 
				"			APP_SRC = \"T1.S\";\n" + 
				"			MULTI_STACK = TRUE;\n" + 
				"	\n" + 
				"		};\n" + 
				"\n" + 
				"		LIB = ENABLE { NAME = \"T1.S\";  } ;\n" + 
				"		KERNEL_TYPE = BCC1;\n" + 
				"	};\n" + 
				"\n" + 
				"    TASK Task0 {\n" + 
				"        PRIORITY = 1;\n" + 
				"        ACTIVATION = 4;\n" + 
				"        STACK = PRIVATE {\n" + 
				"			SYS_SIZE = 65;\n" + 
				"		};\n" + 
				"		SCHEDULE = FULL;\n" + 
				"		RESOURCE = MUTEX_sync;\n" + 
				"	};\n" + 
				"    RESOURCE MUTEX_sync { RESOURCEPROPERTY = STANDARD; };\n" + 
				"};\n";
		commonWriterTest(text, 1);
	}

	@Test public void testDS_PIC30_LIB_multi() {
	    final String text =
				"CPU mySystem {\n" + 
				"\n" + 
				"	OS myOs {\n" + 
				"	                \n" + 
				"		 EE_OPT = \"DEBUG\";\n" + 
				"        STATUS = EXTENDED;\n" + 
				"\n" + 
				"        STARTUPHOOK = TRUE;\n" + 
				"        ERRORHOOK = FALSE;\n" + 
				"        SHUTDOWNHOOK = FALSE;\n" + 
				"        PRETASKHOOK = FALSE;\n" + 
				"        POSTTASKHOOK = FALSE;\n" + 
				"        USEGETSERVICEID = FALSE;\n" + 
				"        USEPARAMETERACCESS = FALSE;\n" + 
				"        USERESSCHEDULER = TRUE;\n" + 
				"        \n" + 
				"        CPU_DATA = PIC30 {\n" + 
				"			APP_SRC = \"code.c\";\n" + 
				"			APP_SRC = \"T1.S\";\n" + 
				"			MULTI_STACK = TRUE;\n" + 
				"	\n" + 
				"		};\n" + 
				"\n" + 
				"		LIB = ENABLE { NAME = \"T1.S\";  } ;\n" + 
				"		LIB = ENABLE { NAME = \"T2.S\";  } ;\n" + 
				"		LIB = ENABLE { NAME = \"T3.S\"; NAME = \"T2.S\"; NAME = \"T4.S\"; } ;\n" + 
				"		KERNEL_TYPE = BCC1;\n" + 
				"	};\n" + 
				"\n" + 
				"    TASK Task0 {\n" + 
				"        PRIORITY = 1;\n" + 
				"        ACTIVATION = 4;\n" + 
				"        STACK = PRIVATE {\n" + 
				"			SYS_SIZE = 65;\n" + 
				"		};\n" + 
				"		SCHEDULE = FULL;\n" + 
				"		RESOURCE = MUTEX_sync;\n" + 
				"	};\n" + 
				"    RESOURCE MUTEX_sync { RESOURCEPROPERTY = STANDARD; };\n" + 
				"};\n";
		commonWriterTest(text, 1);
	}
	
	@Test public void testEmptyPIC30() {
		final String text = 
			
			"CPU mySystem {\n" +
			"	OS myOs {\n" +
			"		EE_OPT = \"some opts\";\n" +
			"		CPU_DATA = PIC30;\n" +
			"		LIB = ENABLE {NAME=\"abc\"; };\n" +
			"	};\n" +
			"};\n";
		commonWriterTest(text, 1);
	}
	

	@Test public void testEDF() {
		final String text = 
			
			"CPU mySystem {\n" +
			"	OS myOs {\n" +
			"		EE_OPT = \"some opts\";\n" +
			"       LIBS = \"some_libs\";\n" +
			"       LIBS = \"more_libs\";\n" +
			"		CPU_DATA = PIC30;\n" +
			"		LIB = ENABLE {NAME=\"abc\"; };\n" +
			"		KERNEL_TYPE = EDF {TICK_TIME=\"123ms\"; };\n" +
			"	};\n" +
			"TASK Task0 {\n" +
			"	PRIORITY = 0x01;   /* Low priority */\n" +
			"	SCHEDULE = FULL;\n" +
			"	REL_DEADLINE = \"14\";\n" +
			"	AUTOSTART = FALSE;\n" +
			"	STACK = SHARED;\n" +
			"	ACTIVATION = 1;    /* only one pending activation */\n" +
			"	RESOURCE = Resource;\n" +
			"};	\n" +
			"\n" +
			"TASK Task1 {\n" +
			"	PRIORITY = 0x02;   /* High priority */\n" +
			"	REL_DEADLINE = \"300ms\";\n" +
			"	SCHEDULE = FULL;\n" +
			"	AUTOSTART = TRUE;	\n" +
			"	STACK = SHARED;\n" +
			"	ACTIVATION = 1;\n" +
			"};\n" +
			"    RESOURCE Resource { RESOURCEPROPERTY = STANDARD; };\n" + 
			"};\n";
		commonWriterTest(text, 1);
	}

	@Test public void testEDF_ram() {
		final String text = 
			
			"CPU mySystem {\n" +
			"	OS myOs {\n" +
			"		EE_OPT = \"some opts\";\n" +
			"		CPU_DATA = PIC30;\n" +
			"		LIB = ENABLE {NAME=\"abc\"; };\n" +
			"		KERNEL_TYPE = EDF {TICK_TIME=\"123ms\"; REL_DEADLINES_IN_RAM = TRUE; };\n" +
			"	};\n" +
			"TASK Task0 {\n" +
			"	PRIORITY = 0x01;   /* Low priority */\n" +
			"	SCHEDULE = FULL;\n" +
			"	REL_DEADLINE = \"14\";\n" +
			"	AUTOSTART = FALSE;\n" +
			"	STACK = SHARED;\n" +
			"	ACTIVATION = 1;    /* only one pending activation */\n" +
			"	RESOURCE = Resource;\n" +
			"};	\n" +
			"\n" +
			"TASK Task1 {\n" +
			"	PRIORITY = 0x02;   /* High priority */\n" +
			"	REL_DEADLINE = \"300ms\";\n" +
			"	SCHEDULE = FULL;\n" +
			"	AUTOSTART = TRUE;	\n" +
			"	STACK = SHARED;\n" +
			"	ACTIVATION = 1;\n" +
			"};\n" +
			"    RESOURCE Resource { RESOURCEPROPERTY = STANDARD; };\n" + 
			"};\n";
		commonWriterTest(text, 1);
	}
	
	@Test public void testEDF_rom() {
		final String text = 
			
			"CPU mySystem {\n" +
			"	OS myOs {\n" +
			"		EE_OPT = \"some opts\";\n" +
			"		CPU_DATA = PIC30;\n" +
			"		LIB = ENABLE {NAME=\"abc\"; };\n" +
			"		KERNEL_TYPE = EDF {TICK_TIME=\"123ms\"; REL_DEADLINES_IN_RAM = FALSE; };\n" +
			"	};\n" +
			"TASK Task0 {\n" +
			"	PRIORITY = 0x01;   /* Low priority */\n" +
			"	SCHEDULE = FULL;\n" +
			"	REL_DEADLINE = \"14\";\n" +
			"	AUTOSTART = FALSE;\n" +
			"	STACK = SHARED;\n" +
			"	ACTIVATION = 1;    /* only one pending activation */\n" +
			"	RESOURCE = Resource;\n" +
			"};	\n" +
			"\n" +
			"TASK Task1 {\n" +
			"	PRIORITY = 0x02;   /* High priority */\n" +
			"	REL_DEADLINE = \"300ms\";\n" +
			"	SCHEDULE = FULL;\n" +
			"	AUTOSTART = TRUE;	\n" +
			"	STACK = SHARED;\n" +
			"	ACTIVATION = 1;\n" +
			"};\n" +
			"    RESOURCE Resource { RESOURCEPROPERTY = STANDARD; };\n" + 
			"};\n";
		commonWriterTest(text, 1);
	}

//	@Test public void testEDFWrong_1() {
//		final String text = 
//			
//			"CPU mySystem {\n" +
//			"	OS myOs {\n" +
//			"		EE_OPT = \"some opts\";\n" +
//			"		CPU_DATA = PIC30;\n" +
//			"		LIB = ENABLE {NAME=\"abc\"; };\n" +
//			"		KERNEL_TYPE = EDF {TICK_TIME=\"123ms\"; };\n" +
//			"	};\n" +
//			"TASK Task0 {\n" +
//			"	PRIORITY = 0x01;   /* Low priority */\n" +
//			"	SCHEDULE = FULL;\n" +
////			"	REL_DEADLINE = \"14\";\n" +
//			"	AUTOSTART = FALSE;\n" +
//			"	STACK = SHARED;\n" +
//			"	ACTIVATION = 1;    /* only one pending activation */\n" +
//			"	RESOURCE = Resource;\n" +
//			"};	\n" +
//			"\n" +
//			"};\n";
//		commonWriterTest(text, 1);
//	}

	@Test public void testEDF_PIC() {
		final String text = 
			"	CPU mySystem {\n" +
			"		OS myOs {\n" +
			"			EE_OPT = \"DEBUG\";\n" +
			"			CPU_DATA = PIC30 {\n" +
			"				APP_SRC = \"code.c\";\n" +
			"				MULTI_STACK = FALSE;\n" +
			"				ICD2 = TRUE;\n" +
			"			};\n" +
			"			MCU_DATA = PIC30 {\n" +
			"				MODEL = PIC33FJ256GP710;\n" +
			"			};\n" +
			"			BOARD_DATA = EE_FLEX {\n" +
			"				USELEDS = TRUE;\n" +
			"			};\n" +
			"			KERNEL_TYPE = EDF { NESTED_IRQ = TRUE; TICK_TIME = \"10ns\";};\n" +
			"		};\n" +
			"		TASK myTask {\n" +
			"			REL_DEADLINE = \"10ms\";\n" +
			"			PRIORITY = 1;\n" +
			"			STACK = SHARED;\n" +
			"			SCHEDULE = FULL;\n" +
			"		};\n" +
			"		COUNTER myCounter;\n" +
			"		ALARM myAlarm {\n" +
			"			COUNTER = myCounter;\n" +
			"		    ACTION = ACTIVATETASK { TASK = myTask; };\n" +
			"		};\n" +
			"	};\n";
		commonWriterTest(text, 1);
	}

	@Test public void testEDF_PIC2() {
		final String text = 
			"CPU mySystem {\n" +
			"	OS myOs {\n" +
			"		EE_OPT = \"DEBUG\";\n" +

			"		CPU_DATA = PIC30 {\n" +
			"			APP_SRC = \"code.c\";\n" +
			"			MULTI_STACK = FALSE;\n" +
			"			ICD2 = TRUE;\n" +
			"		};\n" +

			"		MCU_DATA = PIC30 {\n" +
			"			MODEL = PIC33FJ256MC710;\n" +
			"		};\n" +

			"		BOARD_DATA = EE_FLEX {\n" +
			"			USELEDS = TRUE;\n" +
			"		};\n" +

			"		KERNEL_TYPE = EDF { NESTED_IRQ = TRUE; TICK_TIME = \"500ns\";};\n" +
					
			"	};\n" +

			"	TASK myTask {\n" +
			"		REL_DEADLINE = \"0.5s\";\n" +
			"		PRIORITY = 1;\n" +
			"		STACK = SHARED;\n" +
			"		SCHEDULE = FULL;\n" +
			"	};\n" +

			"	COUNTER myCounter;\n" +

			"	ALARM myAlarm {\n" +
			"		COUNTER = myCounter;\n" +
			"	    ACTION = ACTIVATETASK { TASK = myTask; };\n" +
			"	};\n" +
			"};\n";
		commonWriterTest(text, 1);
	}


	@Test public void testFP_PIC2() {
		final String text = 
			"CPU mySystem {\n" +
			"	OS myOs {\n" +
			"		EE_OPT = \"DEBUG\";\n" +
			"		EE_OPT = \"VERBOSE\";\n" +
			"		CPU_DATA = PIC30 {\n" +
			"			APP_SRC = \"code.c\";\n" +
			"			APP_SRC = \"eeuart.c\";\n" +
			"			MULTI_STACK = FALSE;\n" +
			"			ICD2 = TRUE;\n" +
			"		};\n" +

			"		MCU_DATA = PIC30 {\n" +
			"			MODEL = PIC33FJ256MC710;\n" +
			"		};\n" +

			"		BOARD_DATA = EE_FLEX {\n" +
			"			USELEDS = TRUE;\n" +
			"		};\n" +

			"		KERNEL_TYPE = FP;\n" +
			"	};\n" +

			"	TASK AcquireTask {\n" +
			"		PRIORITY = 2;\n" +
			"		STACK = SHARED;\n" +
			"		SCHEDULE = FULL;\n" +
			"	};\n" +

			"	TASK ComputeTask {\n" +
			"		PRIORITY = 1;\n" +
			"		STACK = SHARED;\n" +
			"		SCHEDULE = FULL;\n" +
			"	};\n" +

			"	EVENT myEvent{MASK=4;};\n" +

			"	COUNTER myCounter;\n" +

			"	ALARM AcquireAlarm {\n" +
			"		COUNTER = myCounter;\n" +
			"		ACTION = ACTIVATETASK { TASK = AcquireTask; };\n" +
			"	};\n" +
			"};\n";			
		DefaultTestResult res = commonWriterTest(text, 1);
		System.out.println(Vt2StringUtilities.varTreeToString(res.vt));
	}

	
//	@Test public void testIRIS_PIC() {
//		final String text = 
//			"CPU mySystem {\n" +
//			"	OS myOs {\n" +
//			"		EE_OPT = \"DEBUG\";\n" +
//			"		EE_OPT = \"__SEM_IRIS__\";\n" +
//			
//			"		CPU_DATA = PIC30 {\n" +
//			"			APP_SRC = \"code.c\";\n" +
//			"			APP_SRC = \"eeuart.c\";\n" +
//			"			MULTI_STACK = TRUE {\n" +
//			"				IRQ_STACK = TRUE {\n" +
//			"					SYS_SIZE=512;\n" +
//			"				};\n" +
////			"				DUMMY_STACK = SHARED;\n" +
//			"			};\n" +
//			"			ICD2 = TRUE;\n" +
//			"		};\n" +
//
//			"		MCU_DATA = PIC30 {\n" +
//			"			MODEL = PIC33FJ256MC710;\n" +
//			"		};\n" +
//
//			"		BOARD_DATA = EE_FLEX {\n" +
//			"			USELEDS = TRUE;\n" +
//			"		};\n" +
//
//			"		KERNEL_TYPE = IRIS {\n" +
//			
//			"			CONTRACTS =  CONTRACT {" +
//			"				NAME = \"C1\";\n" +
//			"				BUDGET = 0x2000;\n" +
//			"				PERIOD = 0x10000;\n" +
//			//"				INV_PROC_UTIL = 0x2000;\n" +
//			"			};\n" +
//
//			"			CONTRACTS = CONTRACT {" +
//			"				NAME = \"C2\";\n" +
//			"				BUDGET = 0x2000;\n" +
//			"				PERIOD = 0x20000;\n" +
//			"			};\n" +
//
//			"			CONTRACTS = CONTRACT {" +
//			"				NAME = \"C3\";\n" +
//			"				BUDGET = 0x2000;\n" +
//			"				PERIOD = 0x40000;\n" +
//			"			};\n" +
//
//			"			CONTRACTS = CONTRACT {" +
//			"				NAME = \"C4\";\n" +
//			"				BUDGET = 0x2000;\n" +
//			"				PERIOD = 0x80000;\n" +
//			"			};\n" +
//
//			"			CONTRACTS = CONTRACT {" +
//			"				NAME = \"C5\";\n" +
//			"				BUDGET = 0x2000;\n" +
//			"				PERIOD = 0x160000;\n" +
//			"			};\n" +
//
//			"		};\n" +
//			"	};\n" +
//
//			"	TASK T1 {\n" +
//			"		PRIORITY = 0x40;\n" +
//			"		STACK = PRIVATE {\n" + 
//			"			SYS_SIZE = 512;\n" + 
//			"		};\n" + 
//			"		SCHEDULE = FULL;\n" +
//			"		CONTRACT = \"C1\";\n" +			
//			"	};\n" +
//
//			"	TASK T2 {\n" +
//			"		PRIORITY = 0x10;\n" +
//			"		STACK = PRIVATE {\n" + 
//			"			SYS_SIZE = 512;\n" + 
//			"		};\n" + 
//			"		SCHEDULE = FULL;\n" +
//			"		CONTRACT = \"C2\";\n" +			
//			"	};\n" +
//
//			"	TASK T3 {\n" +
//			"		PRIORITY = 0x04;\n" +
//			"		STACK = PRIVATE {\n" + 
//			"			SYS_SIZE = 512;\n" + 
//			"		};\n" + 
//			"		SCHEDULE = FULL;\n" +
//			"		CONTRACT = \"C3\";\n" +			
//			"	};\n" +
//
//			"	TASK T4 {\n" +
//			"		PRIORITY = 0x01;\n" +
//			"		STACK = PRIVATE {\n" + 
//			"			SYS_SIZE = 512;\n" + 
//			"		};\n" + 
//			"		SCHEDULE = FULL;\n" +
//			"		CONTRACT = \"C4\";\n" +			
//			"	};\n" +
//
//			"	COUNTER myCounter;\n" +
//
//			"	ALARM AcquireAlarm {\n" +
//			"		COUNTER = myCounter;\n" +
//			"		ACTION = ACTIVATETASK { TASK = T1; };\n" +
//			"	};\n" +
//			"};\n";			
//		commonWriterTest(text, 1);
//	}

	
	
	@Test public void testFRSH_PIC() {
		final String text = 
			"CPU mySystem {\n" +
			"	OS myOs {\n" +
			"		EE_OPT = \"DEBUG\";\n" +
			"		EE_OPT = \"__SEM_IRIS__\";\n" +
			
			"		CPU_DATA = PIC30 {\n" +
			"			APP_SRC = \"code.c\";\n" +
			"			APP_SRC = \"eeuart.c\";\n" +
			"			MULTI_STACK = TRUE {\n" +
			"				IRQ_STACK = TRUE {\n" +
			"					SYS_SIZE=512;\n" +
			"				};\n" +
//			"				DUMMY_STACK = SHARED;\n" +
			"			};\n" +
			"			ICD2 = TRUE;\n" +
			"		};\n" +

			"		MCU_DATA = PIC30 {\n" +
			"			MODEL = PIC33FJ256MC710;\n" +
			"		};\n" +

			"		BOARD_DATA = EE_FLEX {\n" +
			"			USELEDS = TRUE;\n" +
			"		};\n" +

			"		KERNEL_TYPE = FRSH {\n" +
			
			"			CONTRACTS =  CONTRACT {" +
			"				NAME = \"C1\";\n" +
			"				BUDGET = 0x2000;\n" +
			"				PERIOD = 0x10000;\n" +
			//"				INV_PROC_UTIL = 0x2000;\n" +
			"			};\n" +

			"			CONTRACTS = CONTRACT {" +
			"				NAME = \"C2\";\n" +
			"				BUDGET = 0x2000;\n" +
			"				PERIOD = 0x20000;\n" +
			"			};\n" +

			"			CONTRACTS = CONTRACT {" +
			"				NAME = \"C3\";\n" +
			"				BUDGET = 0x2000;\n" +
			"				PERIOD = 0x40000;\n" +
			"			};\n" +

			"			CONTRACTS = CONTRACT {" +
			"				NAME = \"C4\";\n" +
			"				BUDGET = 0x2000;\n" +
			"				PERIOD = 0x80000;\n" +
			"			};\n" +

			"			CONTRACTS = CONTRACT {" +
			"				NAME = \"C5\";\n" +
			"				BUDGET = 0x2000;\n" +
			"				PERIOD = 0x160000;\n" +
			"			};\n" +

			"		};\n" +
			"	};\n" +

			"	TASK T1 {\n" +
			"		PRIORITY = 0x40;\n" +
			"		STACK = PRIVATE {\n" + 
			"			SYS_SIZE = 512;\n" + 
			"		};\n" + 
			"		SCHEDULE = FULL;\n" +
			"		CONTRACT = \"C1\";\n" +			
			"	};\n" +

			"	TASK T2 {\n" +
			"		PRIORITY = 0x10;\n" +
			"		STACK = PRIVATE {\n" + 
			"			SYS_SIZE = 512;\n" + 
			"		};\n" + 
			"		SCHEDULE = FULL;\n" +
			"		CONTRACT = \"C2\";\n" +			
			"	};\n" +

			"	TASK T3 {\n" +
			"		PRIORITY = 0x04;\n" +
			"		STACK = PRIVATE {\n" + 
			"			SYS_SIZE = 512;\n" + 
			"		};\n" + 
			"		SCHEDULE = FULL;\n" +
			"		CONTRACT = \"C3\";\n" +			
			"	};\n" +

			"	TASK T4 {\n" +
			"		PRIORITY = 0x01;\n" +
			"		STACK = PRIVATE {\n" + 
			"			SYS_SIZE = 512;\n" + 
			"		};\n" + 
			"		SCHEDULE = FULL;\n" +
			"		CONTRACT = \"C4\";\n" +			
			"	};\n" +

			"	COUNTER myCounter;\n" +

			"	ALARM AcquireAlarm {\n" +
			"		COUNTER = myCounter;\n" +
			"		ACTION = ACTIVATETASK { TASK = T1; };\n" +
			"	};\n" +
			"};\n";
		commonWriterTest(text, 1);
	}


	@Test public void testMINIFLEX_PIC() {
		final String text = 
			"CPU test_application {\n"+
			"\n"+
			"	OS EE {\n"+
			"		EE_OPT = \"DEBUG\";\n"+
			"\n"+
			"		CPU_DATA = PIC30 {\n"+
			"			APP_SRC = \"code.c\";\n"+
			"			MULTI_STACK = FALSE;\n"+
			"			ICD2 = TRUE;\n"+
			"		};\n"+
			"\n"+
			"		MCU_DATA = PIC30 {\n"+
			"			MODEL = PIC33FJ256MC710;\n"+
			"		};\n"+
			"\n"+
			"		BOARD_DATA = EE_MINIFLEX {\n"+
			"			USELEDS = TRUE;\n"+
			"			USEE2PROM = FALSE;\n"+
			"			TYPE = DEMO {\n"+
			"				OPTIONS = BUZZER;\n"+
			"				OPTIONS = ACCELEROMETER;\n"+
			"				OPTIONS = LIGHT;\n"+
			"				OPTIONS = RTC;\n"+
			"				OPTIONS = ALL;\n"+
			"				OPTIONS = ALL;\n"+
			"			};\n"+
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
			"		\n"+
			"        KERNEL_TYPE = BCC1;\n"+
			"    };\n"+
			"\n"+
			"    TASK LowTask {\n"+
			"		PRIORITY = 0x01;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		RESOURCE = Resource;\n"+
			"    };\n"+
			"\n"+
			"    TASK HighTask {\n"+
			"		PRIORITY = 0x02;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"		STACK = SHARED;\n"+
			"		RESOURCE = Resource;\n"+
			"    };\n"+
			"\n"+
			"    RESOURCE Resource { RESOURCEPROPERTY = STANDARD; };\n"+
			"};";
		commonWriterTest(text, 1);
	}
	
	@Test public void testOO_RES_PIC() {
		final String text = 
			"CPU test_application {\n"+
			"\n"+
			"	OS EE {\n"+
			"		EE_OPT = \"DEBUG\";\n"+
			"\n"+
			"		CPU_DATA = PIC30 {\n"+
			"			APP_SRC = \"code.c\";\n"+
			"			MULTI_STACK = FALSE;\n"+
			"			ICD2 = TRUE;\n"+
			"		};\n"+
			"\n"+
			"		MCU_DATA = PIC30 {\n"+
			"			MODEL = PIC33FJ256MC710;\n"+
			"		};\n"+
			"\n"+
			"		BOARD_DATA = EE_FLEX {\n"+
			"			TYPE = DEMO {\n"+
			"				OPTIONS = ALL;\n"+
			"			};\n"+
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
			"		\n"+
			"        KERNEL_TYPE = BCC1;\n"+
			"\n"+
			"//		ORTI_SECTIONS = ALL;\n"+
			"    };\n"+
			"\n"+
			"    APPMODE ModeIncrement;\n"+
			"    APPMODE ModeDecrement;\n"+
			"\n"+
			"    TASK LowTask {\n"+
			"		PRIORITY = 0x01;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		RESOURCE = Resource;\n"+
			"    };\n"+
			"\n"+
			"    TASK HighTask {\n"+
			"		PRIORITY = 0x02;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"		AUTOSTART = TRUE { APPMODE=ModeIncrement; };	\n"+
			"		STACK = SHARED;\n"+
			"		RESOURCE = Resource;\n"+
			"    };\n"+
			"\n"+
			"    RESOURCE Resource { RESOURCEPROPERTY = STANDARD; };\n"+
			"};";
		commonWriterTest(text, 1);
	}

	@Test
	public void testEasyLab() {
	    final String text =
				"CPU mySystem {\n" + 
				"\n" + 
				"	OS myOs {\n" + 
				"	                \n" + 
				"		EE_OPT = \"DEBUG\";\n" + 
				"        STATUS = EXTENDED;\n" + 
				"\n" + 
				"        STARTUPHOOK = TRUE;\n" + 
				"        ERRORHOOK = FALSE;\n" + 
				"        SHUTDOWNHOOK = FALSE;\n" + 
				"        PRETASKHOOK = FALSE;\n" + 
				"        POSTTASKHOOK = FALSE;\n" + 
				"        USEGETSERVICEID = FALSE;\n" + 
				"        USEPARAMETERACCESS = FALSE;\n" + 
				"        USERESSCHEDULER = TRUE;\n" + 
				"        \n" + 
				"        CPU_DATA = PIC30 {\n" + 
				"			APP_SRC = \"code.c\";\n" + 
				"			APP_SRC = \"T1.S\";\n" + 
				"			MULTI_STACK = TRUE {\n" + 
				"				IRQ_STACK = TRUE {\n" + 
				"					SYS_SIZE=64;\n" + 
				"				};\n" + 
				"			};\n" + 
				"			ICD2 = TRUE;\n" + 
				"		};\n" + 
				"\n" + 
				"		KERNEL_TYPE = BCC1;\n" + 
				"		BOARD_DATA = EE_EASYLAB {\n" +
				"			USETIMER  = TRUE;\n" +
				"			USEUART   = TRUE;\n" +
				"			USELEDS   = TRUE;\n" +
				"			USEDIO    = TRUE;\n" +
				"			USEBUZZER = TRUE; // Dovrebbe forzare la definizione dei timer (__USE_TIMER__)\n" +
				"			USEADC    = TRUE;\n" +
				"			USEPWM    = TRUE;\n" +
				"		};				\n" +
				"	};\n" + 
				"\n" + 
				"    TASK Task0 {\n" + 
				"        PRIORITY = 1;\n" + 
				"        ACTIVATION = 4;\n" + 
				"        STACK = PRIVATE {\n" + 
				"			SYS_SIZE = 64;\n" + 
				"		};\n" + 
				"		SCHEDULE = FULL;\n" + 
				"		RESOURCE = MUTEX_sync;\n" + 
				"	};\n" + 
				"\n" + 
				"    TASK Task1 {\n" + 
				"        PRIORITY = 2;\n" + 
				"        ACTIVATION = 4;\n" + 
				"        STACK = SHARED;\n" + 
				"        SCHEDULE = FULL;\n" + 
				"    };\n" + 
				"\n" + 
				"    TASK Task2 {\n" + 
				"        PRIORITY = 3;\n" + 
				"        ACTIVATION = 4;\n" + 
				"		STACK = SHARED;\n" + 
				"        SCHEDULE = FULL;\n" + 
				"        RESOURCE = MUTEX_sync;\n" + 
				"        APP_SRC = \"demo.c\";\n" + 
				"    };\n" + 
				"\n" + 
				"    TASK Task3 {\n" + 
				"        PRIORITY = 4;\n" + 
				"        ACTIVATION = 4;\n" + 
				"		STACK = SHARED;\n" + 
				"        SCHEDULE = FULL;\n" + 
				"        APP_SRC = \"demo1.c\";\n" + 
				"        APP_SRC = \"demo2.c\";\n" + 
				"    };\n" + 
				"    RESOURCE MUTEX_sync { RESOURCEPROPERTY = STANDARD {" +
				"        APP_SRC = \"demo3.c\";\n" + 
				"        APP_SRC = \"demo4.c\";\n" + 
				"    };};\n" + 
				"};\n";
		commonWriterTest(text, 1);
	}	
	
}
