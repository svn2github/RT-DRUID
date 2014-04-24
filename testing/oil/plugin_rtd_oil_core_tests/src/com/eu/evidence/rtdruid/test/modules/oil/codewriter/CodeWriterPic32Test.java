package com.eu.evidence.rtdruid.test.modules.oil.codewriter;

import java.io.ByteArrayInputStream;

import org.junit.Test;

import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.CommentWriterCpp;



public class CodeWriterPic32Test extends AbstractCodeWriterTest {
	
	
	@Test public void testDS_PIC32_1() {
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
				"        CPU_DATA = PIC32 {\n" + 
				"			APP_SRC = \"code.c\";\n" + 
				"			APP_SRC = \"T1.S\";\n" + 
				"			MULTI_STACK = FALSE ;\n" + 
				"			ICD2 = TRUE;\n" + 
				"		};\n" + 
				
				"		BOARD_DATA = MICROCHIP_EXPLORER16 {\n"+
				"			USELEDS = TRUE;\n"+
				"			USELEDD10 = TRUE;\n"+
				"			USELCD = TRUE;\n"+
				"			USEANALOG = FALSE;\n"+
				"		};\n"+
				
				"\n" + 
				"		KERNEL_TYPE = BCC1;\n" + 
				"	};\n" + 
				"\n" + 
				"    TASK Task0 {\n" + 
				"        PRIORITY = 1;\n" + 
				"        ACTIVATION = 4;\n" + 
				"        STACK = SHARED;\n" + 
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

	@Test public void testDS_PIC32_2() {
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
				"        CPU_DATA = PIC32 {\n" + 
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

	@Test public void testDS_PIC32_BCC1() {
	    final String text =
		"CPU test_application {" + 
		"" + 
		"	OS EE {" + 
		"		EE_OPT = \"DEBUG\";" + 
		"" + 
		"		CPU_DATA = PIC32 {" + 
		"			APP_SRC = \"code.c\";" + 
		"			MULTI_STACK = FALSE;" + 
		"			ICD2 = TRUE;" + 
		"		};" + 
		"" + 
		"		MCU_DATA = PIC32 {" + 
		"			MODEL = PIC32MX360F512L;" + 
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

	@Test public void testDS_PIC32_LIB() {
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
				"        CPU_DATA = PIC32 {\n" + 
				"			APP_SRC = \"code.c\";\n" + 
				"			APP_SRC = \"T1.S\";\n" + 
				"			MULTI_STACK = FALSE;\n" + 
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
				"        STACK = SHARED;\n" + 
				"		SCHEDULE = FULL;\n" + 
				"		RESOURCE = MUTEX_sync;\n" + 
				"	};\n" + 
				"    RESOURCE MUTEX_sync { RESOURCEPROPERTY = STANDARD; };\n" + 
				"};\n";
		commonWriterTest(text, 1);
	}

	@Test public void testDS_PIC32_LIB_multi() {
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
				"        CPU_DATA = PIC32 {\n" + 
				"			APP_SRC = \"code.c\";\n" + 
				"			APP_SRC = \"T1.S\";\n" + 
				"			MULTI_STACK = FALSE;\n" + 
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
				"        STACK = SHARED;\n" + 
				"		SCHEDULE = FULL;\n" + 
				"		RESOURCE = MUTEX_sync;\n" + 
				"	};\n" + 
				"    RESOURCE MUTEX_sync { RESOURCEPROPERTY = STANDARD; };\n" + 
				"};\n";
		commonWriterTest(text, 1);
	}
	
	@Test public void testEmptyPIC32() {
		final String text = 
			
			"CPU mySystem {\n" +
			"	OS myOs {\n" +
			"		EE_OPT = \"some opts\";\n" +
			"		CPU_DATA = PIC32;\n" +
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
			"		CPU_DATA = PIC32;\n" +
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
			"		CPU_DATA = PIC32;\n" +
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
			"		CPU_DATA = PIC32;\n" +
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


	@Test public void testEDF_PIC32() {
		final String text = 
			"	CPU mySystem {\n" +
			"		OS myOs {\n" +
			"			EE_OPT = \"DEBUG\";\n" +
			"			CPU_DATA = PIC32 {\n" +
			"				APP_SRC = \"code.c\";\n" +
			"				MULTI_STACK = FALSE;\n" +
			"				ICD2 = TRUE;\n" +
			"			};\n" +
			"			MCU_DATA = PIC32 {\n" +
			"				MODEL = PIC32MX360F512L;\n" +
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
	@Test public void testEDF_PIC32_795() {
		final String text = 
			"	CPU mySystem {\n" +
			"		OS myOs {\n" +
			"			EE_OPT = \"DEBUG\";\n" +
			"			CPU_DATA = PIC32 {\n" +
			"				APP_SRC = \"code.c\";\n" +
			"				MULTI_STACK = FALSE;\n" +
			"				ICD2 = TRUE;\n" +
			"			};\n" +
			"			MCU_DATA = PIC32 {\n" +
			"				MODEL = PIC32MX795F512L;\n" +
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

	@Test public void testEDF_PIC32_CUSTOM() {
		final String text = 
			"	CPU mySystem {\n" +
			"		OS myOs {\n" +
			"			EE_OPT = \"DEBUG\";\n" +
			"			CPU_DATA = PIC32 {\n" +
			"				APP_SRC = \"code.c\";\n" +
			"				MULTI_STACK = FALSE;\n" +
			"				ICD2 = TRUE;\n" +
			"			};\n" +
			"			MCU_DATA = PIC32 {\n" +
			"				MODEL = CUSTOM {" +
			"					MODEL = \"modello\";\n" +
			"					DEV_LIB = \"devlib\";\n" +
			"					INCLUDE_C = \"inc.c\";\n" +
			"					INCLUDE_S = \"inc.s\";\n" +
			"				};\n" +
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

	@Test public void testDS_PIC32_ESK_1() {
	    final String text =
		"CPU test_application {" + 
		"" + 
		"	OS EE {" + 
		"		EE_OPT = \"DEBUG\";" + 
		"" + 
		"		CPU_DATA = PIC32 {" + 
		"			APP_SRC = \"code.c\";" + 
		"			MULTI_STACK = FALSE;" + 
		"			ICD2 = TRUE;" + 
		"		};" + 
		"" + 
		"		MCU_DATA = PIC32 {" + 
		"			MODEL = PIC32MX360F512L;" + 
		"		};" + 

		"		BOARD_DATA = MICROCHIP_ESK {\n" +
		"			USELEDS = TRUE;\n" +
		"		};\n" +
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

	@Test public void testDS_PIC32_ESK_2() {
	    final String text =
		"CPU test_application {" + 
		"" + 
		"	OS EE {" + 
		"		EE_OPT = \"DEBUG\";" + 
		"" + 
		"		CPU_DATA = PIC32 {" + 
		"			APP_SRC = \"code.c\";" + 
		"			MULTI_STACK = FALSE;" + 
		"			ICD2 = TRUE;" + 
		"		};" + 
		"" + 
		"		MCU_DATA = PIC32 {" + 
		"			MODEL = PIC32MX360F512L;" + 
		"		};" + 

		"		BOARD_DATA = MICROCHIP_ESK {\n" +
		"			USEBUTTONS = TRUE;\n" +
		"		};\n" +
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
	
	@Test public void testDS_PIC32_ESK_3() {
	    final String text =
		"CPU test_application {" + 
		"" + 
		"	OS EE {" + 
		"		EE_OPT = \"DEBUG\";" + 
		"" + 
		"		CPU_DATA = PIC32 {" + 
		"			APP_SRC = \"code.c\";" + 
		"			MULTI_STACK = FALSE;" + 
		"			ICD2 = TRUE;" + 
		"		};" + 
		"" + 
		"		MCU_DATA = PIC32 {" + 
		"			MODEL = PIC32MX360F512L;" + 
		"		};" + 

		"		BOARD_DATA = MICROCHIP_ESK {\n" +
		"			USELEDS = TRUE;\n" +
		"			USEBUTTONS = TRUE;\n" +
		"		};\n" +
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
	
	@Test public void testDS_PIC32_ESK_4() {
	    final String text =
		"CPU test_application {" + 
		"" + 
		"	OS EE {" + 
		"		EE_OPT = \"DEBUG\";" + 
		"" + 
		"		CPU_DATA = PIC32 {" + 
		"			APP_SRC = \"code.c\";" + 
		"			MULTI_STACK = FALSE;" + 
		"			ICD2 = TRUE;" + 
		"		};" + 
		"" + 
		"		MCU_DATA = PIC32 {" + 
		"			MODEL = PIC32MX360F512L;" + 
		"		};" + 

		"		BOARD_DATA = MICROCHIP_ESK {\n" +
		"			USELEDS = FALSE;\n" +
		"			USEBUTTONS = FALSE;\n" +
		"		};\n" +
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

	public DefaultTestResult commonWriterTest(String oil_text, int expected_cpu) {
		CommentWriterCpp cWriter = new CommentWriterCpp();
		System.out.println(cWriter.writerBanner("OIL") + oil_text);
		try {
			System.out.println(cWriter.writerBanner("XML") + oilToXmltext(new ByteArrayInputStream(oil_text.getBytes())));
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
		System.out.println(cWriter.writerBanner("OUTPUT"));
		DefaultTestResult result = super.commonWriterTest(oil_text, expected_cpu);
		return result;
	}

}
