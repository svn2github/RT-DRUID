package com.eu.evidence.rtdruid.test.modules.oil.codewriter;

import org.junit.Test;



public class CodeWriterTricore1Test extends AbstractCodeWriterTest {
	
	
	@Test public void testHello() {
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
	
	@Test public void testIsr() {
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
	
	@Test public void testIsrPriority() {
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
				"        PRIORITY = 1;\n" + 
				"        ACTIVATION = 4;\n" + 
				"		 STACK = SHARED;\n" + 
				"        SCHEDULE = FULL;\n" + 
				"    };\n" + 
				"	ISR Timer_isr2a {\n" +
				"		CATEGORY = 2;" +
				"		LEVEL = \"4\";\n" +
				"        PRIORITY = 5;\n" +
				"		HANDLER = \"isr2a\";	// IRQ handler\n" +
				"	};\n" +
				"	ISR Timer_isr2b {\n" +
				"		CATEGORY = 2;" +
				"		LEVEL = \"5\";\n" +
				"        PRIORITY = 7;\n" +
				"		HANDLER = \"isr2b\";	// IRQ handler\n" +
				"	};\n" +
				"	ISR Timer_isr2c {\n" +
				"		CATEGORY = 2;" +
				"		LEVEL = \"6\";\n" +
				"        PRIORITY = 9;\n" +
				"		HANDLER = \"isr2c\";	// IRQ handler\n" +
				"	};\n" +
				"	ISR Timer_isr1a {\n" +
				"		CATEGORY = 1;" +
				"		LEVEL = \"1\";\n" +
				"        PRIORITY = 6;\n" +
				"		HANDLER = \"isr1a\";	// IRQ handler\n" +
				"	};\n" +
				"	ISR Timer_isr1b {\n" +
				"		CATEGORY = 1;" +
				"		LEVEL = \"2\";\n" +
				"        PRIORITY = 8;\n" +
				"		HANDLER = \"isr1b\";	// IRQ handler\n" +
				"	};\n" +
				"	ISR Timer_isr1c {\n" +
				"		CATEGORY = 1;" +
				"		LEVEL = \"3\";\n" +
				"        PRIORITY = 10;\n" +
	  			"		HANDLER = \"isr1c\";	// Trap handler\n" +
				"	};\n" +
				"};\n";
		commonWriterTest(text, 1);
	}

	@Test public void testIsrPriority2() {
	    final String text =
				"CPU mySystem {\n" + 
				"	OS myOs {\n" +
				"		EE_OPT = \"DEBUG\";" + 
				"		EE_OPT = \"VERBOSE\";" + 
				"       STATUS = EXTENDED;\n" + 
				"       USERESSCHEDULER = FALSE;\n" + 
				"		CPU_DATA = TRICORE {\n"+
				"			APP_SRC = \"slave.c\";\n"+
				"            CPU_CLOCK = 200.0;\n" +
				"			APP_SRC = \"master.c\";\n"+
				"            MULTI_STACK = TRUE {\n" +
				"                IRQ_STACK = TRUE {\n" +
				"                    SYS_SIZE = 256;\n" +
				"                };\n" +
				"            };\n" +
				"			SYS_STACK_SIZE = 4096;\n"+
				"			LINKERSCRIPT = \"slave2_link\";\n"+
				"		};\n"+
				"		KERNEL_TYPE = FP;\n" +
				"		MCU_DATA = TRICORE {\n"+
				"			MODEL = TC27x;\n"+
				"			LINKERSCRIPT = \"mcu_link\";\n"+
				"		};\n"+
				"	};\n" + 
				"    TASK Task0 {\n" + 
				"        PRIORITY = 2;\n" + 
				"        ACTIVATION = 4;\n" + 
				"        STACK = SHARED;\n" + 
				"        SCHEDULE = FULL;\n" + 
				"    };\n" + 
				"    TASK Task1 {\n" + 
				"        PRIORITY = 1;\n" + 
				"        ACTIVATION = 4;\n" + 
				"		 STACK = SHARED;\n" + 
				"        SCHEDULE = FULL;\n" + 
				"    };\n" + 
				"	ISR Timer_isr2a {\n" +
				"		CATEGORY = 2;" +
				"		LEVEL = \"4\";\n" +
				"        PRIORITY = 5;\n" +
				"		HANDLER = \"isr2a\";	// IRQ handler\n" +
				"	};\n" +
				"	ISR Timer_isr2b {\n" +
				"		CATEGORY = 2;" +
				"		LEVEL = \"5\";\n" +
				"        PRIORITY = 7;\n" +
				"		HANDLER = \"isr2b\";	// IRQ handler\n" +
				"	};\n" +
				"	ISR Timer_isr2c {\n" +
				"		CATEGORY = 2;" +
				"		LEVEL = \"6\";\n" +
				"        PRIORITY = 9;\n" +
				"		HANDLER = \"isr2c\";	// IRQ handler\n" +
				"	};\n" +
				"	ISR Timer_isr1a {\n" +
				"		CATEGORY = 1;" +
				"		LEVEL = \"1\";\n" +
				"        PRIORITY = 6;\n" +
				"		HANDLER = \"isr1a\";	// IRQ handler\n" +
				"	};\n" +
				"	ISR Timer_isr1b {\n" +
				"		CATEGORY = 1;" +
				"		LEVEL = \"2\";\n" +
				"        PRIORITY = 8;\n" +
				"		HANDLER = \"isr1b\";	// IRQ handler\n" +
				"	};\n" +
				"	ISR Timer_isr1c {\n" +
				"		CATEGORY = 1;" +
				"		LEVEL = \"3\";\n" +
				"        PRIORITY = 10;\n" +
	  			"		HANDLER = \"isr1c\";	// Trap handler\n" +
				"	};\n" +
				"};\n";
		commonWriterTest(text, 1);
	}

	@Test public void testLed() {
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
	

	@Test public void testMono() {
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
				"        RESOURCE = res;\n" + 
				"    };\n" + 
				"    TASK Task1 {\n" + 
				"        PRIORITY = 1;\n" + 
				"        ACTIVATION = 4;\n" + 
				"		 STACK = SHARED;\n" + 
				"        SCHEDULE = FULL;\n" + 
				"        AUTOSTART = TRUE;\n" + 
				"        RESOURCE = res;\n" + 
				"    };\n" + 
				"    RESOURCE res { RESOURCEPROPERTY = STANDARD; };\n" + 
				"};\n";
		commonWriterTest(text, 1);
	}
	

	@Test public void testMulti() {
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
	
	@Test public void testTc27x() {
	    final String text =
	    		"CPU test_application {\n" +
				"\n" +
				"    OS EE {\n" +
				"        EE_OPT = \"DEBUG\";\n" +
				"        EE_OPT = \"DEBUG\";\n" +
				"        EE_OPT = \"__ASSERT__\";\n" +
				"        STATUS = EXTENDED;\n" +
				"        USERESSCHEDULER = FALSE;\n" +
				"		MCU_DATA = TRICORE {\n"+
				"			MODEL = TC27x;\n"+
				"		};\n"+
				"\n"+
				"        CPU_DATA = TRICORE {\n" +
				"            CPU_CLOCK = 200.0;\n" +
				"            APP_SRC = \"main.c\";\n" +
				"        };\n" +
				"    };\n" +
				"\n" +
				"    TASK Task1 {\n" +
				"        PRIORITY = 0x01;   /* Low priority */\n" +
				"        AUTOSTART = FALSE;\n" +
				"        STACK = SHARED;\n" +
				"        ACTIVATION = 1;    /* only one pending activation */\n" +
				"    };    \n" +
				"    \n" +
				"    TASK Task2 {\n" +
				"        PRIORITY = 0x02;   /* High priority */\n" +
				"        SCHEDULE = FULL;\n" +
				"        AUTOSTART = TRUE;    \n" +
				"        STACK = SHARED;\n" +
				"    };\n" +
				"\n" +
				"    COUNTER system_timer {\n" +
				"        MINCYCLE = 1;\n" +
				"        MAXALLOWEDVALUE = 2147483647;\n" +
				"        TICKSPERBASE = 1;\n" +
				"        TYPE = HARDWARE {\n" +
				"            DEVICE = \"STM_SR0\";\n" +
				"            SYSTEM_TIMER = TRUE;\n" +
				"            PRIORITY = 1;\n" +
				"        };\n" +
				"        SECONDSPERTICK = 0.001;\n" +
				"    };\n" +
				"\n" +
				"    ALARM Alarm_TASK1_4s {\n" +
				"      COUNTER = system_timer;\n" +
				"      ACTION = ACTIVATETASK {\n" +
				"          TASK = Task1;\n" +
				"      };\n" +
				"      AUTOSTART = TRUE {\n" +
				"          ALARMTIME = 4000;\n" +
				"          CYCLETIME = 4000;\n" +
				"      };\n" +
				"    };\n" +
				"\n" +
				"    ISR Button_isr2 {\n" +
				"        CATEGORY = 2;\n" +
				"        LEVEL = \"2\";\n" +
				"        PRIORITY = 2;\n" +
				"        HANDLER = \"button_handler\"; // IRQ handler \n" +
				"    };\n" +
				"\n" +
				"\n" +
				"    OS EE { KERNEL_TYPE = BCC1; EE_OPT = \"__OO_STARTOS_OLD__\";}; \n" +
				"    TASK Task1 { SCHEDULE = FULL; };\n" +
				"    TASK Task2 { ACTIVATION = 1; };\n" +
				"};\n";
		commonWriterTest(text, 1);
	}

	@Test public void testTc27xIsr() {
	    final String text =
	    		"CPU test_application {\n" +
				"\n" +
				"    OS EE {\n" +
				"        EE_OPT = \"DEBUG\";\n" +
				"        EE_OPT = \"DEBUG\";\n" +
				"        EE_OPT = \"__ASSERT__\";\n" +
				"        STATUS = EXTENDED;\n" +
				"        USERESSCHEDULER = FALSE;\n" +
				"		MCU_DATA = TRICORE {\n"+
				"			MODEL = TC27x;\n"+
				"		};\n"+
				"\n"+

				"        CPU_DATA = TRICORE {\n" +
				"            CPU_CLOCK = 200.0;\n" +
				"            APP_SRC = \"main.c\";\n" +
				"        };\n" +
				"    };\n" +
				"\n" +
				"    TASK Task1 {\n" +
				"        PRIORITY = 0x01;   /* Low priority */\n" +
				"        AUTOSTART = FALSE;\n" +
				"        STACK = SHARED;\n" +
				"        ACTIVATION = 1;    /* only one pending activation */\n" +
				"    };    \n" +
				"    \n" +
				"    TASK Task2 {\n" +
				"        PRIORITY = 0x02;   /* High priority */\n" +
				"        SCHEDULE = FULL;\n" +
				"        AUTOSTART = TRUE;    \n" +
				"        STACK = SHARED;\n" +
				"    };\n" +
				"\n" +
				"    COUNTER system_timer {\n" +
				"        MINCYCLE = 1;\n" +
				"        MAXALLOWEDVALUE = 2147483647;\n" +
				"        TICKSPERBASE = 1;\n" +
				"        TYPE = HARDWARE {\n" +
				"            DEVICE = \"STM_SR0\";\n" +
				"            SYSTEM_TIMER = TRUE;\n" +
				"            PRIORITY = 1;\n" +
				"        };\n" +
				"        SECONDSPERTICK = 0.001;\n" +
				"    };\n" +
				"\n" +
				"    ALARM Alarm_TASK1_4s {\n" +
				"      COUNTER = system_timer;\n" +
				"      ACTION = ACTIVATETASK {\n" +
				"          TASK = Task1;\n" +
				"      };\n" +
				"      AUTOSTART = TRUE {\n" +
				"          ALARMTIME = 4000;\n" +
				"          CYCLETIME = 4000;\n" +
				"      };\n" +
				"    };\n" +
				"\n" +
				"    ISR Button_isr2 {\n" +
				"        CATEGORY = 2;\n" +
				"        LEVEL = \"2\";\n" +
				"        PRIORITY = 2;\n" +
				"        HANDLER = \"button_handler\"; // IRQ handler \n" +
				"    };\n" +
				"\n" +
				"\n" +
				"    OS EE { KERNEL_TYPE = BCC1; EE_OPT = \"__OO_STARTOS_OLD__\";}; \n" +
				"    TASK Task1 { SCHEDULE = FULL; };\n" +
				"    TASK Task2 { ACTIVATION = 1; };\n" +
				"};\n";
		commonWriterTest(text, 1);
	}

	@Test public void testTc27xMulti1() {
	    final String text =
	    		"CPU mySystem {\n" +
				"    OS myOs {\n" +
				"    EE_OPT = \"DEBUG\";\n" +
				"        EE_OPT = \"__ASSERT__\";\n" +
				"        STATUS = EXTENDED;\n" +
				"        USERESSCHEDULER = FALSE;\n" +
				"\n" +
				"        CPU_DATA = TRICORE {\n" +
				"            //CPU_CLOCK = 200.0;\n" +
				"            APP_SRC = \"main.c\";\n" +
				"            MULTI_STACK = TRUE;\n" +
				"        };\n" +
				"\n"+
				"		MCU_DATA = TRICORE {\n"+
				"			MODEL = TC27x;\n"+
				"		};\n"+
				"\n"+
				"        EE_OPT = \"__OO_STARTOS_OLD__\";\n" +
				"        KERNEL_TYPE = BCC1;\n" +
				"    };\n" +
				"\n" +
				"    TASK Task1 {\n" +
				"        PRIORITY = 1;\n" +
				"        ACTIVATION = 1;\n" +
				"        STACK = PRIVATE {\n" +
				"            SYS_SIZE = 512;\n" +
				"        };\n" +
				"        SCHEDULE = FULL;\n" +
				"    };\n" +
				"\n" +
				"    TASK Task2 {\n" +
				"        PRIORITY = 2;\n" +
				"        ACTIVATION = 1;\n" +
				"        STACK = SHARED;\n" +
				"        SCHEDULE = FULL;\n" +
				"    };\n" +
				"};";
		commonWriterTest(text, 1);
	}

	@Test public void testTc27xMultiStackIsr() {
	    final String text =
	    		"CPU mySystem {\n" +
				"    OS myOs {\n" +
				"    EE_OPT = \"DEBUG\";\n" +
				"        EE_OPT = \"__ASSERT__\";\n" +
				"        STATUS = EXTENDED;\n" +
				"        USERESSCHEDULER = FALSE;\n" +
				"\n" +
				"        CPU_DATA = TRICORE {\n" +
				"            CPU_CLOCK = 200.0;\n" +
				"            APP_SRC = \"main.c\";\n" +
				"            MULTI_STACK = TRUE {\n" +
				"                IRQ_STACK = TRUE {\n" +
				"                    SYS_SIZE=256;\n" +
				"                };\n" +
				"            };\n" +
				"        };\n" +
				"\n"+
				"		MCU_DATA = TRICORE {\n"+
				"			MODEL = TC27x;\n"+
				"		};\n"+
				"\n"+
				"        EE_OPT = \"__OO_STARTOS_OLD__\";\n" +
				"        KERNEL_TYPE = BCC1;\n" +
				"    };\n" +
				"\n" +
				"    TASK Task1 {\n" +
				"        PRIORITY = 1;\n" +
				"        ACTIVATION = 1;\n" +
				"        STACK = PRIVATE {\n" +
				"            SYS_SIZE = 256;\n" +
				"        };\n" +
				"        SCHEDULE = FULL;\n" +
				"    };\n" +
				"\n" +
				"    TASK Task2 {\n" +
				"        PRIORITY = 1;\n" +
				"        ACTIVATION = 1;\n" +
				"        STACK = PRIVATE {\n" +
				"            SYS_SIZE = 256;\n" +
				"        };\n" +
				"        SCHEDULE = FULL;\n" +
				"    };\n" +
				"\n" +
				"    ISR STM0_isr2 {\n" +
				"        CATEGORY = 2;\n" +
				"        LEVEL = \"2\";\n" +
				"        PRIORITY = 2;\n" +
				"        HANDLER = \"STM0_isr2\"; // IRQ handler \n" +
				"    };\n" +
				"\n" +
				"    ISR STM1_isr2 {\n" +
				"        CATEGORY = 2;\n" +
				"        LEVEL = \"3\";\n" +
				"        PRIORITY = 3;\n" +
				"        HANDLER = \"STM1_isr2\"; // IRQ handler \n" +
				"    };\n" +
				"};\n";
		commonWriterTest(text, 1);
	}

	@Test public void testTc27xModistarc() {
	    final String text =
			"CPU test_application {\n" +
			"    OS EE {\n" +
			"  EE_OPT = \"__ASSERT__\";\n" +
			"  EE_OPT = \"DEBUG\";\n" +
			"  STATUS = EXTENDED;\n" +
			"  STARTUPHOOK = FALSE;\n" +
			"  ERRORHOOK = FALSE;\n" +
			"  SHUTDOWNHOOK = FALSE;\n" +
			"  PRETASKHOOK = FALSE;\n" +
			"  POSTTASKHOOK = FALSE;\n" +
			"  USEGETSERVICEID = FALSE;\n" +
			"  USEPARAMETERACCESS = FALSE;\n" +
			"  USERESSCHEDULER = TRUE;\n" +
			"CPU_DATA = TRICORE {\n" +
			"    APP_SRC = \"code.c\";\n" +
			"         MULTI_STACK = FALSE;\n" +
			" };\n" +
			"        EE_OPT = \"__OO_STARTOS_OLD__\";\n" +
			"        KERNEL_TYPE = BCC1;\n" +
			"\n"+
			"		MCU_DATA = TRICORE {\n"+
			"			MODEL = TC27x;\n"+
			"		};\n"+
			"\n"+
			"    };\n" +
			"    TASK Task1 {\n" +
			"  PRIORITY = 0x01;\n" +
			"  ACTIVATION = 1;\n" +
			"  SCHEDULE = FULL;\n" +
			"  AUTOSTART = TRUE;\n" +
			"  STACK = SHARED;\n" +
			"    };\n" +
			"    TASK Task2 {\n" +
			"  PRIORITY = 0x02;\n" +
			"  ACTIVATION = 1;\n" +
			"  SCHEDULE = FULL;\n" +
			"  AUTOSTART = FALSE;\n" +
			"  STACK = SHARED;\n" +
			"    };\n" +
			"};";
			commonWriterTest(text, 1);
	}

	@Test public void testTc27xModistarcMultiStack() {
	    final String text =
	    		"CPU test_application {\n" +
	    				"    OS EE {\n" +
	    				"  EE_OPT = \"__ASSERT__\";\n" +
	    				"  EE_OPT = \"DEBUG\";\n" +
	    				"  STATUS = EXTENDED;\n" +
	    				"  STARTUPHOOK = FALSE;\n" +
	    				"  ERRORHOOK = FALSE;\n" +
	    				"  SHUTDOWNHOOK = FALSE;\n" +
	    				"  PRETASKHOOK = FALSE;\n" +
	    				"  POSTTASKHOOK = FALSE;\n" +
	    				"  USEGETSERVICEID = FALSE;\n" +
	    				"  USEPARAMETERACCESS = FALSE;\n" +
	    				"  USERESSCHEDULER = TRUE;\n" +
	    				"CPU_DATA = TRICORE {\n" +
	    				"    APP_SRC = \"code.c\";\n" +
	    				"         MULTI_STACK = TRUE {\n" +
				"                IRQ_STACK = TRUE {\n" +
				"                    SYS_SIZE=256;\n" +
				"                };\n" +
				"            };\n" +
	    				" };\n" +
	    				"        EE_OPT = \"__OO_STARTOS_OLD__\";\n" +
	    				"\n"+
	    				"		MCU_DATA = TRICORE {\n"+
	    				"			MODEL = TC27x;\n"+
	    				"		};\n"+
	    				"\n"+
	    				"        KERNEL_TYPE = BCC1;\n" +
	    				"        ORTI_SECTIONS = ALL;\n" +
	    				"    };\n" +
	    				"    TASK Task1 {\n" +
	    				"  PRIORITY = 0x01;\n" +
	    				"  ACTIVATION = 1;\n" +
	    				"  SCHEDULE = FULL;\n" +
	    				"  AUTOSTART = TRUE;\n" +
	    				"  STACK = SHARED;\n" +
	    				"    };\n" +
	    				"    TASK Task2 {\n" +
	    				"  PRIORITY = 0x02;\n" +
	    				"  ACTIVATION = 1;\n" +
	    				"  SCHEDULE = FULL;\n" +
	    				"  AUTOSTART = FALSE;\n" +
	    				"  STACK = PRIVATE {\n" +
				"            SYS_SIZE = 256;\n" +
				"        };\n" +
	    				"    };\n" +
	    				"};";
			commonWriterTest(text, 1);
	}
	
	@Test public void testTc27xSysTimer() {
	    final String text =
	    		"CPU test_application {\n" +
	    				"\n" +
	    				"    OS EE {\n" +
	    				"        EE_OPT = \"EE_DEBUG\";\n" +
	    				"        EE_OPT = \"__ASSERT__\";\n" +
	    				"        CPU_DATA = TRICORE {\n" +
	    				"            CPU_CLOCK = 200.0;\n" +
	    				"            APP_SRC = \"code.c\";\n" +
	    				"            MULTI_STACK = TRUE {\n" +
	    				"                IRQ_STACK = TRUE {\n" +
	    				"                    SYS_SIZE = 256;\n" +
	    				"                };\n" +
	    				"            };\n" +
	    				"        };\n" +
	    				"        STATUS = EXTENDED;\n" +
	    				"        STARTUPHOOK = TRUE;\n" +
	    				"        ERRORHOOK = TRUE;\n" +
	    				"        USERESSCHEDULER = FALSE;\n" +
	    				"\n"+
	    				"		MCU_DATA = TRICORE {\n"+
	    				"			MODEL = TC27x;\n"+
	    				"		};\n"+
	    				"\n"+
	    				"\n" +
	    				"        KERNEL_TYPE = ECC2;\n" +
	    				"        ORTI_SECTIONS = ALL;\n" +
	    				"    };\n" +
	    				"\n" +
	    				"    TASK Task1 {\n" +
	    				"        PRIORITY = 0x01;\n" +
	    				"        ACTIVATION = 1;\n" +
	    				"        SCHEDULE = FULL;\n" +
	    				"        AUTOSTART = TRUE;\n" +
	    				"        STACK = PRIVATE {\n" +
	    				"            SYS_SIZE = 256;\n" +
	    				"        };\n" +
	    				"        EVENT = TimerEvent;\n" +
	    				"        EVENT = ButtonEvent;\n" +
	    				"    };\n" +
	    				"\n" +
	    				"    TASK Task2 {\n" +
	    				"        PRIORITY = 0x02;\n" +
	    				"        ACTIVATION = 1;\n" +
	    				"        SCHEDULE = FULL;\n" +
	    				"        AUTOSTART = FALSE;\n" +
	    				"        STACK = SHARED;\n" +
	    				"    };\n" +
	    				"\n" +
	    				"    EVENT TimerEvent  { MASK = AUTO; };\n" +
	    				"    EVENT ButtonEvent { MASK = AUTO; };\n" +
	    				"\n" +
	    				"    COUNTER system_timer {\n" +
	    				"        MINCYCLE = 1;\n" +
	    				"        MAXALLOWEDVALUE = 2147483647;\n" +
	    				"        TICKSPERBASE = 1;\n" +
	    				"        TYPE = HARDWARE {\n" +
	    				"            DEVICE = \"STM_SR0\";\n" +
	    				"            SYSTEM_TIMER = TRUE;\n" +
	    				"            PRIORITY = 1;\n" +
	    				"        };\n" +
	    				"        SECONDSPERTICK = 0.001;\n" +
	    				"    };\n" +
	    				"\n" +
	    				"    ALARM AlarmTask1 {\n" +
	    				"        COUNTER = system_timer;\n" +
	    				"        ACTION = SETEVENT { TASK = Task1; EVENT = TimerEvent; };\n" +
	    				"        AUTOSTART = TRUE { ALARMTIME = 250; CYCLETIME = 500; };\n" +
	    				"    };\n" +
	    				"\n" +
	    				"    ALARM AlarmTask2 {\n" +
	    				"        COUNTER = system_timer;\n" +
	    				"        ACTION = ACTIVATETASK { TASK = Task2; };\n" +
	    				"        AUTOSTART = FALSE;\n" +
	    				"    };\n" +
	    				"\n" +
	    				"    ISR Button_isr2 {\n" +
	    				"        CATEGORY = 2;\n" +
	    				"        LEVEL = \"2\";\n" +
	    				"        PRIORITY = 2;\n" +
	    				"        HANDLER = \"button_handler\"; // IRQ handler \n" +
	    				"    };\n" +
	    				"};\n";
			commonWriterTest(text, 1);
	}
	
	@Test public void testTc27xMulticore() {
	    final String text = "CPU test_application {\n"+
			"\n"+
			"	OS EE {\n"+
			"		EE_OPT = \"__ASSERT__\";\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\";\n"+
			"\n"+
			"\n"+
			"		MASTER_CPU = \"master\";\n"+
			"\n"+
			"		CPU_DATA = TRICORE {\n"+
			"			ID = \"master\";\n"+
			"            CPU_CLOCK = 200.0;\n" +
			"			APP_SRC = \"master.c\";\n"+
			"            MULTI_STACK = TRUE {\n" +
			"                IRQ_STACK = TRUE {\n" +
			"                    SYS_SIZE = 256;\n" +
			"                };\n" +
			"            };\n" +
			"			SYS_STACK_SIZE = 4096;\n"+
			"		};\n"+
			"\n"+
			"		CPU_DATA = TRICORE {\n"+
			"			ID = \"slave1\";\n"+
			"			APP_SRC = \"slave.c\";\n"+
			"            CPU_CLOCK = 200.0;\n" +
			"			APP_SRC = \"master.c\";\n"+
			"            MULTI_STACK = TRUE {\n" +
			"                IRQ_STACK = TRUE {\n" +
			"                    SYS_SIZE = 256;\n" +
			"                };\n" +
			"            };\n" +
			"			SYS_STACK_SIZE = 4096;\n"+
			"		};\n"+
			"\n"+
			"		CPU_DATA = TRICORE {\n"+
			"			ID = \"slave2\";\n"+
			"			APP_SRC = \"slave.c\";\n"+
			"            CPU_CLOCK = 200.0;\n" +
			"			APP_SRC = \"master.c\";\n"+
			"            MULTI_STACK = TRUE {\n" +
			"                IRQ_STACK = TRUE {\n" +
			"                    SYS_SIZE = 256;\n" +
			"                };\n" +
			"            };\n" +
			"			SYS_STACK_SIZE = 4096;\n"+
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
			"		MCU_DATA = TRICORE {\n"+
			"			MODEL = TC27x;\n"+
			"		};\n"+
			"\n"+
			"		KERNEL_TYPE = BCC1;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskMaster1 {\n"+
			"		CPU_ID = \"master\";\n"+
			"		PRIORITY = 1;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskMaster2 {\n"+
			"		CPU_ID = \"master\";\n"+
			"		PRIORITY = 3;\n"+
			"		AUTOSTART = FALSE;\n"+
			"        STACK = PRIVATE {\n" +
			"            SYS_SIZE = 256;\n" +
			"        };\n" +
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskSlave1a {\n"+
			"		CPU_ID = \"slave1\";\n"+
			"		PRIORITY = 2;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskSlave1b {\n"+
			"		CPU_ID = \"slave1\";\n"+
			"		PRIORITY = 1;\n"+
			"		AUTOSTART = TRUE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskSlave2a {\n"+
			"		CPU_ID = \"slave2\";\n"+
			"		PRIORITY = 2;\n"+
			"		AUTOSTART = FALSE;\n"+
			"        STACK = PRIVATE {\n" +
			"            SYS_SIZE = 256;\n" +
			"        };\n" +
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskSlave2b {\n"+
			"		CPU_ID = \"slave2\";\n"+
			"		PRIORITY = 3;\n"+
			"		AUTOSTART = FALSE;\n"+
			"        STACK = PRIVATE {\n" +
			"            SYS_SIZE = 256;\n" +
			"        };\n" +
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"};\n";
		commonWriterTest(text, 3);
	}
	
	@Test public void testTc27xMulticoreLinker() {
	    final String text = "CPU test_application {\n"+
			"\n"+
			"	OS EE {\n"+
			"		EE_OPT = \"__ASSERT__\";\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\";\n"+
			"\n"+
			"\n"+
			"		MASTER_CPU = \"master\";\n"+
			"\n"+
			"		CPU_DATA = TRICORE {\n"+
			"			ID = \"master\";\n"+
			"            CPU_CLOCK = 200.0;\n" +
			"			APP_SRC = \"master.c\";\n"+
			"            MULTI_STACK = TRUE {\n" +
			"                IRQ_STACK = TRUE {\n" +
			"                    SYS_SIZE = 256;\n" +
			"                };\n" +
			"            };\n" +
			"			SYS_STACK_SIZE = 4096;\n"+
			"		};\n"+
			"\n"+
			"		CPU_DATA = TRICORE {\n"+
			"			ID = \"slave1\";\n"+
			"			APP_SRC = \"slave.c\";\n"+
			"            CPU_CLOCK = 200.0;\n" +
			"			APP_SRC = \"master.c\";\n"+
			"            MULTI_STACK = TRUE {\n" +
			"                IRQ_STACK = TRUE {\n" +
			"                    SYS_SIZE = 256;\n" +
			"                };\n" +
			"            };\n" +
			"			SYS_STACK_SIZE = 4096;\n"+
			"		};\n"+
			"\n"+
			"		CPU_DATA = TRICORE {\n"+
			"			ID = \"slave2\";\n"+
			"			APP_SRC = \"slave.c\";\n"+
			"            CPU_CLOCK = 200.0;\n" +
			"			APP_SRC = \"master.c\";\n"+
			"            MULTI_STACK = TRUE {\n" +
			"                IRQ_STACK = TRUE {\n" +
			"                    SYS_SIZE = 256;\n" +
			"                };\n" +
			"            };\n" +
			"			SYS_STACK_SIZE = 4096;\n"+
			"			LINKERSCRIPT = \"slave2_link\";\n"+
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
			"		MCU_DATA = TRICORE {\n"+
			"			MODEL = TC27x;\n"+
			"			LINKERSCRIPT = \"mcu_link\";\n"+
			"		};\n"+
			"\n"+
			"		KERNEL_TYPE = BCC1;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskMaster1 {\n"+
			"		CPU_ID = \"master\";\n"+
			"		PRIORITY = 1;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskMaster2 {\n"+
			"		CPU_ID = \"master\";\n"+
			"		PRIORITY = 3;\n"+
			"		AUTOSTART = FALSE;\n"+
			"        STACK = PRIVATE {\n" +
			"            SYS_SIZE = 256;\n" +
			"        };\n" +
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskSlave1a {\n"+
			"		CPU_ID = \"slave1\";\n"+
			"		PRIORITY = 2;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskSlave1b {\n"+
			"		CPU_ID = \"slave1\";\n"+
			"		PRIORITY = 1;\n"+
			"		AUTOSTART = TRUE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskSlave2a {\n"+
			"		CPU_ID = \"slave2\";\n"+
			"		PRIORITY = 2;\n"+
			"		AUTOSTART = FALSE;\n"+
			"        STACK = PRIVATE {\n" +
			"            SYS_SIZE = 256;\n" +
			"        };\n" +
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskSlave2b {\n"+
			"		CPU_ID = \"slave2\";\n"+
			"		PRIORITY = 3;\n"+
			"		AUTOSTART = FALSE;\n"+
			"        STACK = PRIVATE {\n" +
			"            SYS_SIZE = 256;\n" +
			"        };\n" +
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"};\n";
		commonWriterTest(text, 3);
	}
	
	@Test public void testTc27xMulticoreLinkerGnuTasking() {
	    final String text = "CPU test_application {\n"+
			"\n"+
			"	OS EE {\n"+
			"		EE_OPT = \"__ASSERT__\";\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\";\n"+
			"\n"+
			"\n"+
			"		MASTER_CPU = \"master\";\n"+
			"\n"+
			"		CPU_DATA = TRICORE {\n"+
			"			ID = \"master\";\n"+
			"            CPU_CLOCK = 200.0;\n" +
			"			APP_SRC = \"master.c\";\n"+
			"            MULTI_STACK = TRUE {\n" +
			"                IRQ_STACK = TRUE {\n" +
			"                    SYS_SIZE = 256;\n" +
			"                };\n" +
			"            };\n" +
			"			SYS_STACK_SIZE = 4096;\n"+
			"			COMPILER_TYPE = GNU;\n" +
			"		};\n"+
			"\n"+
			"		CPU_DATA = TRICORE {\n"+
			"			ID = \"slave1\";\n"+
			"			APP_SRC = \"slave.c\";\n"+
			"            CPU_CLOCK = 200.0;\n" +
			"			APP_SRC = \"master.c\";\n"+
			"            MULTI_STACK = TRUE {\n" +
			"                IRQ_STACK = TRUE {\n" +
			"                    SYS_SIZE = 256;\n" +
			"                };\n" +
			"            };\n" +
			"			SYS_STACK_SIZE = 4096;\n"+
			"			COMPILER_TYPE = TASKING;\n" +
			"		};\n"+
			"\n"+
			"		CPU_DATA = TRICORE {\n"+
			"			ID = \"slave2\";\n"+
			"			APP_SRC = \"slave.c\";\n"+
			"            CPU_CLOCK = 200.0;\n" +
			"			APP_SRC = \"master.c\";\n"+
			"            MULTI_STACK = TRUE {\n" +
			"                IRQ_STACK = TRUE {\n" +
			"                    SYS_SIZE = 256;\n" +
			"                };\n" +
			"            };\n" +
			"			SYS_STACK_SIZE = 4096;\n"+
			"			LINKERSCRIPT = \"slave2_link\";\n"+
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
			"		MCU_DATA = TRICORE {\n"+
			"			MODEL = TC27x;\n"+
			"			LINKERSCRIPT = \"mcu_link\";\n"+
			"		};\n"+
			"\n"+
			"		KERNEL_TYPE = BCC1;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskMaster1 {\n"+
			"		CPU_ID = \"master\";\n"+
			"		PRIORITY = 1;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskMaster2 {\n"+
			"		CPU_ID = \"master\";\n"+
			"		PRIORITY = 3;\n"+
			"		AUTOSTART = FALSE;\n"+
			"        STACK = PRIVATE {\n" +
			"            SYS_SIZE = 256;\n" +
			"        };\n" +
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskSlave1a {\n"+
			"		CPU_ID = \"slave1\";\n"+
			"		PRIORITY = 2;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskSlave1b {\n"+
			"		CPU_ID = \"slave1\";\n"+
			"		PRIORITY = 1;\n"+
			"		AUTOSTART = TRUE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskSlave2a {\n"+
			"		CPU_ID = \"slave2\";\n"+
			"		PRIORITY = 2;\n"+
			"		AUTOSTART = FALSE;\n"+
			"        STACK = PRIVATE {\n" +
			"            SYS_SIZE = 256;\n" +
			"        };\n" +
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskSlave2b {\n"+
			"		CPU_ID = \"slave2\";\n"+
			"		PRIORITY = 3;\n"+
			"		AUTOSTART = FALSE;\n"+
			"        STACK = PRIVATE {\n" +
			"            SYS_SIZE = 256;\n" +
			"        };\n" +
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"};\n";
		commonWriterTest(text, 3);
	}
	
	@Test public void testTc27xMulticoreLinkerTasking() {
	    final String text = "CPU test_application {\n"+
			"\n"+
			"	OS EE {\n"+
			"		EE_OPT = \"__ASSERT__\";\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\";\n"+
			"\n"+
			"\n"+
			"		MASTER_CPU = \"master\";\n"+
			"\n"+
			"		CPU_DATA = TRICORE {\n"+
			"			ID = \"master\";\n"+
			"            CPU_CLOCK = 200.0;\n" +
			"			APP_SRC = \"master.c\";\n"+
			"            MULTI_STACK = TRUE {\n" +
			"                IRQ_STACK = TRUE {\n" +
			"                    SYS_SIZE = 256;\n" +
			"                };\n" +
			"            };\n" +
			"			SYS_STACK_SIZE = 4096;\n"+
			"			COMPILER_TYPE = TASKING;\n" +
			"		};\n"+
			"\n"+
			"		CPU_DATA = TRICORE {\n"+
			"			ID = \"slave1\";\n"+
			"			APP_SRC = \"slave.c\";\n"+
			"            CPU_CLOCK = 200.0;\n" +
			"			APP_SRC = \"master.c\";\n"+
			"            MULTI_STACK = TRUE {\n" +
			"                IRQ_STACK = TRUE {\n" +
			"                    SYS_SIZE = 256;\n" +
			"                };\n" +
			"            };\n" +
			"			SYS_STACK_SIZE = 4096;\n"+
			"			COMPILER_TYPE = TASKING;\n" +
			"		};\n"+
			"\n"+
			"		CPU_DATA = TRICORE {\n"+
			"			ID = \"slave2\";\n"+
			"			APP_SRC = \"slave.c\";\n"+
			"            CPU_CLOCK = 200.0;\n" +
			"			APP_SRC = \"master.c\";\n"+
			"            MULTI_STACK = TRUE {\n" +
			"                IRQ_STACK = TRUE {\n" +
			"                    SYS_SIZE = 256;\n" +
			"                };\n" +
			"            };\n" +
			"			SYS_STACK_SIZE = 4096;\n"+
			"			COMPILER_TYPE = TASKING;\n" +
			"			LINKERSCRIPT = \"slave2_link\";\n"+
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
			"		MCU_DATA = TRICORE {\n"+
			"			MODEL = TC27x;\n"+
			"			LINKERSCRIPT = \"mcu_link\";\n"+
			"		};\n"+
			"\n"+
			"		KERNEL_TYPE = BCC1;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskMaster1 {\n"+
			"		CPU_ID = \"master\";\n"+
			"		PRIORITY = 1;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskMaster2 {\n"+
			"		CPU_ID = \"master\";\n"+
			"		PRIORITY = 3;\n"+
			"		AUTOSTART = FALSE;\n"+
			"        STACK = PRIVATE {\n" +
			"            SYS_SIZE = 256;\n" +
			"        };\n" +
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskSlave1a {\n"+
			"		CPU_ID = \"slave1\";\n"+
			"		PRIORITY = 2;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskSlave1b {\n"+
			"		CPU_ID = \"slave1\";\n"+
			"		PRIORITY = 1;\n"+
			"		AUTOSTART = TRUE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskSlave2a {\n"+
			"		CPU_ID = \"slave2\";\n"+
			"		PRIORITY = 2;\n"+
			"		AUTOSTART = FALSE;\n"+
			"        STACK = PRIVATE {\n" +
			"            SYS_SIZE = 256;\n" +
			"        };\n" +
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskSlave2b {\n"+
			"		CPU_ID = \"slave2\";\n"+
			"		PRIORITY = 3;\n"+
			"		AUTOSTART = FALSE;\n"+
			"        STACK = PRIVATE {\n" +
			"            SYS_SIZE = 256;\n" +
			"        };\n" +
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"};\n";
		commonWriterTest(text, 3);
	}

	
	@Test public void testTc27xMulticoreLinkerGnu() {
	    final String text = "CPU test_application {\n"+
			"\n"+
			"	OS EE {\n"+
			"		EE_OPT = \"__ASSERT__\";\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\";\n"+
			"\n"+
			"\n"+
			"		MASTER_CPU = \"master\";\n"+
			"\n"+
			"		CPU_DATA = TRICORE {\n"+
			"			ID = \"master\";\n"+
			"            CPU_CLOCK = 200.0;\n" +
			"			APP_SRC = \"master.c\";\n"+
			"            MULTI_STACK = TRUE {\n" +
			"                IRQ_STACK = TRUE {\n" +
			"                    SYS_SIZE = 256;\n" +
			"                };\n" +
			"            };\n" +
			"			SYS_STACK_SIZE = 4096;\n"+
			"			COMPILER_TYPE = GNU;\n" +
			"		};\n"+
			"\n"+
			"		CPU_DATA = TRICORE {\n"+
			"			ID = \"slave1\";\n"+
			"			APP_SRC = \"slave.c\";\n"+
			"            CPU_CLOCK = 200.0;\n" +
			"			APP_SRC = \"master.c\";\n"+
			"            MULTI_STACK = TRUE {\n" +
			"                IRQ_STACK = TRUE {\n" +
			"                    SYS_SIZE = 256;\n" +
			"                };\n" +
			"            };\n" +
			"			SYS_STACK_SIZE = 4096;\n"+
			"			COMPILER_TYPE = GNU;\n" +
			"		};\n"+
			"\n"+
			"		CPU_DATA = TRICORE {\n"+
			"			ID = \"slave2\";\n"+
			"			APP_SRC = \"slave.c\";\n"+
			"            CPU_CLOCK = 200.0;\n" +
			"			APP_SRC = \"master.c\";\n"+
			"            MULTI_STACK = TRUE {\n" +
			"                IRQ_STACK = TRUE {\n" +
			"                    SYS_SIZE = 256;\n" +
			"                };\n" +
			"            };\n" +
			"			SYS_STACK_SIZE = 4096;\n"+
			"			LINKERSCRIPT = \"slave2_link\";\n"+
			"			COMPILER_TYPE = GNU;\n" +
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
			"		MCU_DATA = TRICORE {\n"+
			"			MODEL = TC27x;\n"+
			"			LINKERSCRIPT = \"mcu_link\";\n"+
			"		};\n"+
			"\n"+
			"		KERNEL_TYPE = BCC1;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskMaster1 {\n"+
			"		CPU_ID = \"master\";\n"+
			"		PRIORITY = 1;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskMaster2 {\n"+
			"		CPU_ID = \"master\";\n"+
			"		PRIORITY = 3;\n"+
			"		AUTOSTART = FALSE;\n"+
			"        STACK = PRIVATE {\n" +
			"            SYS_SIZE = 256;\n" +
			"        };\n" +
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskSlave1a {\n"+
			"		CPU_ID = \"slave1\";\n"+
			"		PRIORITY = 2;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskSlave1b {\n"+
			"		CPU_ID = \"slave1\";\n"+
			"		PRIORITY = 1;\n"+
			"		AUTOSTART = TRUE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskSlave2a {\n"+
			"		CPU_ID = \"slave2\";\n"+
			"		PRIORITY = 2;\n"+
			"		AUTOSTART = FALSE;\n"+
			"        STACK = PRIVATE {\n" +
			"            SYS_SIZE = 256;\n" +
			"        };\n" +
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskSlave2b {\n"+
			"		CPU_ID = \"slave2\";\n"+
			"		PRIORITY = 3;\n"+
			"		AUTOSTART = FALSE;\n"+
			"        STACK = PRIVATE {\n" +
			"            SYS_SIZE = 256;\n" +
			"        };\n" +
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"};\n";
		commonWriterTest(text, 3);
	}

	@Test public void testIsrTc27x() {
	    final String text =
				"CPU mySystem {\n" + 
				"	OS myOs {\n" +
				"		EE_OPT = \"DEBUG\";" + 
				"		EE_OPT = \"VERBOSE\";" + 
				"       STATUS = EXTENDED;\n" + 
				"       USERESSCHEDULER = FALSE;\n" + 
				"        CPU_DATA = TRICORE {\n" +
				"            CPU_CLOCK = 200.0;\n" +
				"            APP_SRC = \"code.c\";\n" +
				"            MULTI_STACK = TRUE {\n" +
				"                IRQ_STACK = TRUE {\n" +
				"                    SYS_SIZE = 256;\n" +
				"                };\n" +
				"            };\n" +
				"        };\n" +
				"        STATUS = EXTENDED;\n" +
				"        STARTUPHOOK = TRUE;\n" +
				"        ERRORHOOK = TRUE;\n" +
				"        USERESSCHEDULER = FALSE;\n" +
				"\n"+
				"		MCU_DATA = TRICORE {\n"+
				"			MODEL = TC27x;\n"+
				"		};\n"+
				"		KERNEL_TYPE = ECC1;\n" +
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
				"		PRIORITY = 4;\n" +
				"		HANDLER = \"isr2\";	// IRQ handler\n" +
				"	};\n" +
				"	ISR irq5_isr1 {\n" +
				"		CATEGORY = 1;" +
				"		PRIORITY = 5;\n" +
				"		HANDLER = \"isr1\";	// IRQ handler\n" +
				"	};\n" +
				"	ISR trap_segfault {\n" +
				"		CATEGORY = 2;" +
				"		PRIORITY = 1;\n" +
				"		TRAP = TRUE;" +
	  			"		HANDLER = \"segfault\";	// Trap handler\n" +
				"	};\n" +
				"	ISR trap_halt {\n" +
				"		CATEGORY = 2;" +
				"		PRIORITY = 1;\n" +
				"		TRAP = TRUE;" +
				"		ENTRY = \"e_halt\";\n" +
	  			"		HANDLER = \"segfault\";	// Trap handler\n" +
				"	};\n" +
				"	ISR trap_syscall {\n" +
				"		CATEGORY = 2;" +
				"		TRAP = TRUE;" +
				"		LEVEL = \"l_syscall\";\n" +
				"		HANDLER = \"syscall\";	// Trap handler\n" +
				"	};\n" +
				"};\n";
		commonWriterTest(text, 1);
	}
	
}
