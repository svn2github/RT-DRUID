package com.eu.evidence.rtdruid.test.modules.oil.codewriter;



public class CodeWriterTricore1Test extends AbstractCodeWriterTest {
	
	
	public void testHello() {
	    final String text =
				"CPU mySystem {\n" + 
				"	OS myOs {\n" +
				"		EE_OPT = \"DEBUG\";" + 
				"		EE_OPT = \"VERBOSE\";" + 
				"       STATUS = EXTENDED;\n" + 
				"       USERESSCHEDULER = FALSE;\n" + 
				"       CPU_DATA = TRICORE1 {\n" + 
				"			APP_SRC = \"code.c\";\n" + 
				"			MODEL = \"tc1796\";\n" + 
				"		};\n" + 				
				"		KERNEL_TYPE = BCC1;\n" +
				"	};\n" + 
				"};\n";
		commonWriterTest(text, 1);
	}
	
	public void testIsr() {
	    final String text =
				"CPU mySystem {\n" + 
				"	OS myOs {\n" +
				"		EE_OPT = \"DEBUG\";" + 
				"		EE_OPT = \"VERBOSE\";" + 
				"       STATUS = EXTENDED;\n" + 
				"       USERESSCHEDULER = FALSE;\n" + 
				"       CPU_DATA = TRICORE1 {\n" + 
				"			APP_SRC = \"code.c\";\n" + 
				"			MODEL = \"tc1796\";\n" + 
				"		};\n" + 				
				"		KERNEL_TYPE = FP;\n" +
				"	};\n" + 
				"    TASK Task0 {\n" + 
				"        PRIORITY = 2;\n" + 
				"        ACTIVATION = 4;\n" + 
				"        STACK = SHARED;\n" + 
				"        SCHEDULE = FULL;\n" + 
				"    };\n" + 
				"    TASK Task1 {\n" + 
				"        PRIORITY = 3;\n" + 
				"        ACTIVATION = 4;\n" + 
				"		 STACK = SHARED;\n" + 
				"        SCHEDULE = FULL;\n" + 
				"    };\n" + 
				"	ISR Timer_isr2 {\n" +
				"		CATEGORY = 2;" +
				"		LEVEL = \"4\";\n" +
				"		HANDLER = \"isr2\";	// IRQ handler\n" +
				"	};\n" +
				"	ISR irq5_isr1 {\n" +
				"		CATEGORY = 1;" +
				"		LEVEL = \"5\";\n" +
				"		HANDLER = \"isr1\";	// IRQ handler\n" +
				"	};\n" +
				"	ISR trap_segfault {\n" +
				"		CATEGORY = 3;" +
				"		LEVEL = \"1\";\n" +
	  			"		HANDLER = \"segfault\";	// Trap handler\n" +
				"	};\n" +
				"	ISR trap_syscall {\n" +
				"		CATEGORY = 3;" +
				"		LEVEL = \"6\";\n" +
				"		HANDLER = \"syscall\";	// Trap handler\n" +
				"	};\n" +
				"};\n";
		commonWriterTest(text, 1);
	}
	

	public void testLed() {
	    final String text =
				"CPU mySystem {\n" + 
				"	OS myOs {\n" +
				"		EE_OPT = \"DEBUG\";" + 
				"		EE_OPT = \"VERBOSE\";" +
				"		EE_OPT = \"__HIGHTEC_TSIM__\";" + 
				"       STATUS = EXTENDED;\n" + 
				"       USERESSCHEDULER = FALSE;\n" + 
				"       CPU_DATA = TRICORE1 {\n" + 
				"			APP_SRC = \"code.c\";\n" + 
				"			MODEL = \"tc1796\";\n" + 
				"		};\n" + 				
				"		KERNEL_TYPE = FP;\n" +
				"	};\n" + 
				"    TASK Task0 {\n" + 
				"        PRIORITY = 2;\n" + 
				"        ACTIVATION = 4;\n" + 
				"        STACK = SHARED;\n" + 
				"        SCHEDULE = FULL;\n" + 
				"    };\n" + 
				"    TASK Task1 {\n" + 
				"        PRIORITY = 3;\n" + 
				"        ACTIVATION = 4;\n" + 
				"		 STACK = SHARED;\n" + 
				"        SCHEDULE = FULL;\n" + 
				"    };\n" + 
				"	ISR irq5_stm_isr {\n" +
				"		CATEGORY = 2;" +
				"		LEVEL = \"5\";\n" +
				"		HANDLER = \"stm_isr\";	// IRQ handler\n" +
				"	};\n" +
				"};\n";
		commonWriterTest(text, 1);
	}
	

	public void testMono() {
	    final String text =
				"CPU mySystem {\n" + 
				"	OS myOs {\n" +
				"		EE_OPT = \"DEBUG\";" + 
				"		EE_OPT = \"VERBOSE\";" +
				"		EE_OPT = \"__HIGHTEC_TSIM__\";" + 
				"       STATUS = EXTENDED;\n" + 
				"       USERESSCHEDULER = FALSE;\n" + 
				"       CPU_DATA = TRICORE1 {\n" + 
				"			APP_SRC = \"code.c\";\n" + 
				"			MODEL = \"tc1796\";\n" + 
				"		};\n" + 				
				"		KERNEL_TYPE = BCC1;\n" +
				"	};\n" + 
				"    TASK Task0 {\n" + 
				"        PRIORITY = 2;\n" + 
				"        ACTIVATION = 4;\n" + 
				"        STACK = SHARED;\n" + 
				"        SCHEDULE = FULL;\n" + 
				"        RESOURCE = \"res\";\n" + 
				"    };\n" + 
				"    TASK Task1 {\n" + 
				"        PRIORITY = 1;\n" + 
				"        ACTIVATION = 4;\n" + 
				"		 STACK = SHARED;\n" + 
				"        SCHEDULE = FULL;\n" + 
				"        AUTOSTART = TRUE;\n" + 
				"        RESOURCE = \"res\";\n" + 
				"    };\n" + 
				"    RESOURCE res { RESOURCEPROPERTY = STANDARD; };\n" + 
				"};\n";
		commonWriterTest(text, 1);
	}
	

	public void testMulti() {
	    final String text =
				"CPU mySystem {\n" + 
				"	OS myOs {\n" +
				"		EE_OPT = \"DEBUG\";" + 
				"		EE_OPT = \"VERBOSE\";" +
				"		EE_OPT = \"__HIGHTEC_TSIM__\";" + 
				"       STATUS = EXTENDED;\n" + 
				"       USERESSCHEDULER = TRUE;\n" + 
				"       CPU_DATA = TRICORE1 {\n" + 
				"			APP_SRC = \"code.c\";\n" + 
				"			MODEL = \"tc1796\";\n" + 
				"			MULTI_STACK = TRUE {\n" + 
				"				IRQ_STACK = TRUE {\n" + 
				"					SYS_SIZE=128;\n" + 
				"				};\n" + 
				"			};\n" + 
				"		};\n" + 				
				"		KERNEL_TYPE = FP;\n" +
				"	};\n" + 
				"    TASK Task0 {\n" + 
				"        PRIORITY = 1;\n" + 
				"        ACTIVATION = 4;\n" + 
				"        STACK = PRIVATE {\n" + 
				"			SYS_SIZE = 128;\n" + 
				"		};\n" + 
				"        SCHEDULE = FULL;\n" + 
				"    };\n" + 
				"    TASK Task1 {\n" + 
				"        PRIORITY = 2;\n" + 
				"        ACTIVATION = 4;\n" + 
				"        STACK = PRIVATE {\n" + 
				"			SYS_SIZE = 128;\n" + 
				"		};\n" + 
				"        SCHEDULE = FULL;\n" + 
				"    };\n" + 
				"	ISR irq5_cpu_isr {\n" +
				"		CATEGORY = 2;" +
				"		LEVEL = \"6\";\n" +
				"		HANDLER = \"cpu_isr\";	// IRQ handler\n" +
				"	};\n" +
				"};\n";
		commonWriterTest(text, 1);
	}
}
