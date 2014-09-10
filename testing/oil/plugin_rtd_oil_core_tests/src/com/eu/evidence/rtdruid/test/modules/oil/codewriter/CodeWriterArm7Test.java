package com.eu.evidence.rtdruid.test.modules.oil.codewriter;

import org.junit.Test;



public class CodeWriterArm7Test extends AbstractCodeWriterTest {
	

	@Test public void testCodeWrite1() {
		final String OIL_TEST_1 = "CPU EE {\n" + "    OS EE {\n"
		+ "        EE_OPT = \"__ASSERT__\";\n"
		+ "        EE_OPT = \"__OSEKOS_NO_ALARMS__\";\n"
		+ "        EE_OPT = \"DEBUG\";\n" +

		"		CPU_DATA = ARM7 {\n" + "			MULTI_STACK = TRUE {\n"
		+ "				IRQ_STACK = FALSE;\n" + "				DUMMY_STACK = SHARED;\n"
		+ "			};\n" + "			\n" + "			APP_SRC = \"code.c\";\n" + "	\n"
		+ "        STACK_TOP = 0x20004000;\n"
		+ "        STACK_BOTTOM = 0x20001800;\n"
		+ "        SYS_SIZE = 0x1000;\n" + "        IRQ_SIZE = 0x1000;\n"
		+ "        SVC_SIZE = 0x200;\n" + "        FIQ_SIZE = 0x200;\n"
		+ "        ABT_SIZE = 0x200;\n" + "        UND_SIZE = 0x200;\n"
		+ "	\n" + "		};\n" +

		"		MCU_DATA = SAMSUNG_KS32C50100 {\n"
		+ "          IRQ_EXT0       =\"Ext 0\";\n"
		+ "          IRQ_EXT1       =\"Ext 1\";\n"
		+ "          IRQ_EXT2       =\"Ext 2\";\n"
		+ "          IRQ_EXT3       =\"Ext 3\";\n"
		+ "          IRQ_UART0TX    =\"UART0 Tx\";\n"
		+ "          IRQ_UART0RX    =\"UART0 Rx & error\";\n"
		+ "          IRQ_UART1TX    =\"UART1 Tx\";\n"
		+ "          IRQ_UART1RX    =\"UART1 Rx & error\";\n"
		+ "          IRQ_GDMA0      =\"GDMA ch. 0\";\n"
		+ "          IRQ_GDMA1      =\"GDMA ch. 1\";\n"
		+ "          IRQ_TIMER0     =\"Timer 0\";\n"
		+ "          IRQ_TIMER1     =\"Timer 1\";\n"
		+ "          IRQ_HDLCATX    =\"HDLC A Tx\";\n"
		+ "          IRQ_HDLCARX    =\"HDLC A Rx\";\n"
		+ "          IRQ_HDLCBTX    =\"HDLC B Tx\";\n"
		+ "          IRQ_HDLCBRX    =\"HDLC B Rx\";\n"
		+ "          IRQ_ETHBDMATX  =\"Ethernet BDMA Tx\";\n"
		+ "          IRQ_ETHBDMARX  =\"Ethernet BDMA Rx\";\n"
		+ "          IRQ_ETHMACTX   =\"Ethernet MAC Tx\";\n"
		+ "          IRQ_ETHMACRX   =\"Ethernet MAC Rx\";\n"
		+ "          IRQ_I2C        =\"I2C-bus\";\n"
		+ "          IRQ_NO_PENDING =\"No Pending Interrupt\";\n"
		+ "		};\n"

		+ "        STATUS = EXTENDED;\n" + "        STARTUPHOOK = TRUE;\n"
		+ "        ERRORHOOK = FALSE;\n"
		+ "        SHUTDOWNHOOK = FALSE;\n"
		+ "        PRETASKHOOK = FALSE;\n"
		+ "        POSTTASKHOOK = FALSE;\n"
		+ "        USEGETSERVICEID = FALSE;\n"
		+ "        USEPARAMETERACCESS = FALSE;\n"
		+ "        USERESSCHEDULER = TRUE;\n"
		+ "        KERNEL_TYPE = BCC1;\n" + "    };\n"
		+ "    TASK Task1Act4 {\n"
		+ "        PRIORITY = 0x01;\n"
		+ "        ACTIVATION = 4;\n"
		+ "        SCHEDULE = FULL;\n"
		+ "        AUTOSTART = TRUE;\n"
		+ "        STACK = PRIVATE {\n"
		+ "            SYS_SIZE = 0x100;\n"
		// + "            IRQ_SIZE = 0x100;\n"
		+ "        };\n" + "        EVENT = evento1;\n" + "    };\n"
		+ "    TASK Task2 {\n" + "        PRIORITY = 0x02;\n"
		+ "        ACTIVATION = 1;\n" + "        SCHEDULE = FULL;\n"
		+ "        AUTOSTART = TRUE;\n" + "        STACK = SHARED;\n"
		+ "    };\n" + "	 EVENT evento1 {};\n" + "};\n";

		commonWriterTest(OIL_TEST_1, 1);
	}

	/***************************************************************************
	 * test 2 (from modistarc task 1)
	 **************************************************************************/

	@Test public void testCodeWrite2() {
		final String OIL_TEST_MODISTARC_TASK_1 = "CPU test_application {\n"
			+ "\n"
			+ "    OS EE {\n"
			+ "		EE_OPT = \"__OSEKOS_STARTOS_WITHOUT_IDLELOOP__\";\n"
			+ "        EE_OPT = \"__ASSERT__\";\n"
			+ "        EE_OPT = \"DEBUG\";\n"
			+ "\n"
			+ "		STATUS = EXTENDED;\n"
			+ "\n"
			+ "		STARTUPHOOK = FALSE;\n"
			+ "		ERRORHOOK = FALSE;\n"
			+ "		SHUTDOWNHOOK = FALSE;\n"
			+ "		PRETASKHOOK = FALSE;\n"
			+ "		POSTTASKHOOK = FALSE;\n"
			+ "		USEGETSERVICEID = FALSE;\n"
			+ "		USEPARAMETERACCESS = FALSE;\n"
			+ "		USERESSCHEDULER = TRUE;\n"
			+ "\n"
			+ "		CPU_DATA = ARM7 {\n"
			+ "			MULTI_STACK = TRUE {\n"
			+ "				IRQ_STACK = FALSE;\n"
			+ "				DUMMY_STACK = SHARED;\n"
			+ "			};\n"
			+ "			\n"
			+ "			APP_SRC = \"code.c\";\n"
			+ "	\n"
			+ "			STACK_TOP    = 0x80000;\n"
			+ "			STACK_BOTTOM = 0x20000;\n"
			+ "			SYS_SIZE     = 0x4000;\n"
			+ "			IRQ_SIZE     = 0x4000;\n"
			+ "			SVC_SIZE     = 0x4000;\n"
			+ "			FIQ_SIZE     = 0x4000;\n"
			+ "			ABT_SIZE     = 0x4000;\n"
			+ "			UND_SIZE     = 0x4000;\n"
			+ "	\n"
			+ "		};\n"
			+ "	\n"
			+ "		MCU_DATA = SAMSUNG_KS32C50100 {\n"
			+ "		  	IRQ_TIMER0 = \"myISR2\"; /* Timer 0 */\n"
			+ "		};\n"
			+ "\n"
			+ "		\n"
			+ "        EE_OPT = \"__TIMER_0_USED__\";\n"
			+ "\n"
			+ "		KERNEL_TYPE = ECC1;\n"
			+ "\n"
			+ "		ORTI_SECTIONS = ALL;\n"
			+ "\n"
			+ "    };\n"
			+ "\n"
			+ "    TASK Task1 {\n"
			+ "		PRIORITY = 0x01;\n"
			+ "		ACTIVATION = 1;\n"
			+ "		SCHEDULE = FULL;\n"
			+ "		AUTOSTART = TRUE;\n"
			+ "		STACK = SHARED;\n"
			+ "    };\n"
			+ "\n"
			+ "    TASK Task2 {\n"
			+ "		PRIORITY = 0x02;\n"
			+ "		ACTIVATION = 1;\n"
			+ "		SCHEDULE = FULL;\n"
			+ "		AUTOSTART = FALSE;	\n"
			+ "		STACK = SHARED;\n" + "    };\n" + "\n" + "};";

		commonWriterTest(OIL_TEST_MODISTARC_TASK_1, 1);
	}

	@Test public void testCodeWrite_FP1() {
		final String text = "CPU test_application {\n" + "\n" + "    OS EE {\n"
				+ "		EE_OPT = \"__OSEKOS_STARTOS_WITHOUT_IDLELOOP__\";\n"
				+ "        EE_OPT = \"__ASSERT__\";\n"
				+ "        EE_OPT = \"DEBUG\";\n"
				+ "\n"
				+ "		STATUS = EXTENDED;\n" + "\n" 
				+ "		STARTUPHOOK = FALSE;\n"
				+ "		ERRORHOOK = FALSE;\n" 
				+ "		SHUTDOWNHOOK = FALSE;\n"
				+ "		PRETASKHOOK = FALSE;\n" 
				+ "		POSTTASKHOOK = FALSE;\n"
				+ "		USEGETSERVICEID = FALSE;\n"
				+ "		USEPARAMETERACCESS = FALSE;\n"
				+ "		USERESSCHEDULER = TRUE;\n" + "\n"
				+ "		CPU_DATA = ARM7 {\n" 
				+ "			MULTI_STACK = TRUE {\n"
				+ "				IRQ_STACK = FALSE;\n" 
				+ "				DUMMY_STACK = SHARED;\n"
				+ "			};\n" + "			\n" 
				+ "			APP_SRC = \"code.c\";\n" + "	\n"
				+ "			STACK_TOP    = 0x80000;\n"
				+ "			STACK_BOTTOM = 0x20000;\n"
				+ "			SYS_SIZE     = 0x4000;\n" 
				+ "			IRQ_SIZE     = 0x4000;\n"
				+ "			SVC_SIZE     = 0x4000;\n" 
				+ "			FIQ_SIZE     = 0x4000;\n"
				+ "			ABT_SIZE     = 0x4000;\n" 
				+ "			UND_SIZE     = 0x4000;\n"
				+ "	\n" 
				+ "		};\n" + "		\n"
				+ "        EE_OPT = \"__TIMER_0_USED__\";\n" + "\n"
				+ "		KERNEL_TYPE = FP;\n" + "\n"
				+ "		BOARD_DATA = EVALUATOR7T;\n" 
				+ "    };\n" 
				+ "\n"
				+ "    TASK Task1 {\n" 
				+ "		PRIORITY = 0x01;\n"
				+ "		ACTIVATION = 1;\n" 
				+ "		SCHEDULE = FULL;\n"
				+ "		AUTOSTART = TRUE;\n" 
				+ "		STACK = SHARED;\n" 
				+ "    };\n"
				+ "\n" 
				+ "    TASK Task2 {\n" 
				+ "		PRIORITY = 0x02;\n"
				+ "		ACTIVATION = 1;\n" 
				+ "		SCHEDULE = FULL;\n"
				+ "		AUTOSTART = FALSE;	\n"
				+ "		STACK = SHARED;\n"
				+ "    };\n"
				+ "};";

		commonWriterTest(text, 1);
	}

	@Test public void testARM7WithAppmode() {
		final String text = "CPU test_application {" + ""
				+ "    OS EE {"
				+ "  EE_OPT = \"__OSEKOS_STARTOS_WITHOUT_IDLELOOP__\";"
				+ "         EE_OPT = \"__TIMER_0_USED__\";"
				+ "         EE_OPT = \"__BUTTON_USED__\";"
				+ "         EE_OPT = \"DEBUG\";" + "" + "  STATUS = EXTENDED;"
				+ "" + "  STARTUPHOOK = FALSE;" + "  ERRORHOOK = FALSE;"
				+ "  SHUTDOWNHOOK = FALSE;" + "  PRETASKHOOK = FALSE;"
				+ "  POSTTASKHOOK = FALSE;" + "  USEGETSERVICEID = FALSE;"
				+ "  USEPARAMETERACCESS = FALSE;" + "  USERESSCHEDULER = TRUE;"
				+ "" + "  CPU_DATA = ARM7 {" + "   APP_SRC = \"code.c\";" + ""
				+ "   STACK_TOP = 0x80000;" + "   STACK_BOTTOM = 0x20000;"
				+ "   SYS_SIZE = 0x4000;" + "   IRQ_SIZE = 0x4000;"
				+ "   SVC_SIZE = 0x4000;" + "   FIQ_SIZE = 0x4000;"
				+ "   ABT_SIZE = 0x4000;" + "   UND_SIZE = 0x4000;" + ""
				+ "   MULTI_STACK = TRUE {" + "    IRQ_STACK = FALSE;"
				+ "    DUMMY_STACK = SHARED;" + "   };" + "" + "  };" + ""
				+ "  MCU_DATA = SAMSUNG_KS32C50100 {"
				+ "   IRQ_EXT0 = \"ISR_Button\";"
				+ "     IRQ_TIMER0 = \"ISR_Timer\";" + "  };" + ""
				+ "         KERNEL_TYPE = ECC2;" + ""
				+ "  ORTI_SECTIONS = ALL;" + "" + "    };" + ""
				+ "    APPMODE ModeIncremental;" + "    APPMODE ModeEdge;" + ""
				+ "    TASK LedTaskLow {" + "  PRIORITY = 0x01;"
				+ "  ACTIVATION = 1;" + "  SCHEDULE = FULL;"
				+ "  AUTOSTART = FALSE;" + "  STACK = SHARED;"
				+ "  RESOURCE = Resource;" + "    };" + ""
				+ "    TASK LCDTask {" + "  PRIORITY = 0x02;"
				+ "  ACTIVATION = 1;" + "  SCHEDULE = FULL;"
				+ "  AUTOSTART = TRUE;" + "  STACK = SHARED;"
				+ "  RESOURCE = Resource;" + "    };" + ""
				+ "    TASK LedTaskHigh {" + "  PRIORITY = 0x03;"
				+ "  ACTIVATION = 1;" + "  SCHEDULE = FULL;"
				+ "  AUTOSTART = TRUE;" + "  STACK = SHARED;" + "    };" + ""
				+ "    RESOURCE Resource { RESOURCEPROPERTY = STANDARD; };"
				+ "" + "};";
		commonWriterTest(text, 1);
	}

	@Test public void testARM7_1stack() {
	    final String text =
			"CPU mySystem {\n" + 
			"\n" + 
			"OS myOs {\n" + 
			"\n" + 
			"	EE_OPT = \"__TIMER_0_USED__\";	// si possono omettere?\n" + 
			"	EE_OPT = \"__TIMER_1_USED__\";	// si possono omettere?\n" + 
			"	EE_OPT = \"DEBUG\";\n" + 
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
			"	CPU_DATA = ARM7 {\n" + 
			"		APP_SRC = \"code.c\";\n" + 
			"		STACK_TOP    = 0x80000;\n" + 
			"		STACK_BOTTOM = 0x20000;\n" + 
			"		SYS_SIZE     = 0x4000;\n" + 
			"		// IRQ_SIZE     = 0x4000; // -> SPARISCE (vale sempre 16)\n" + 
			"		SVC_SIZE     = 0x4000;\n" + 
			"		FIQ_SIZE     = 0x4000; // vale 8 + la dimensione massima degli stack dei vari \"handler fiq\"\n" + 
			"		ABT_SIZE     = 0x4000;\n" + 
			"		UND_SIZE     = 0x4000;\n" + 
			"		MULTI_STACK = TRUE {\n" + 
			"			IRQ_STACK = FALSE;\n" + 
			"			DUMMY_STACK = SHARED;\n" + 
			"		};\n" + 
			"\n" + 
			"	};\n" + 
			"\n" + 
			"	MCU_DATA = SAMSUNG_KS32C50100 {\n" + 
			"	  	IRQ_TIMER0 = \"timer1_handler\";\n" + 
			"	  	IRQ_TIMER1 = \"timer2_handler\";\n" + 
			"	};\n" + 
			"\n" + 
			"	KERNEL_TYPE = FP;\n" + 
			"};\n" + 
			"\n" + 
			"    TASK thread0 {\n" + 
			"        PRIORITY = 1;\n" + 
			"        ACTIVATION = 1;\n" + 
			"	STACK = PRIVATE {\n" + 
			"		SYS_SIZE = 512;\n" + 
			"	};\n" + 
			"        SCHEDULE = FULL;\n" + 
			"	RESOURCE = MUTEX_sync;\n" + 
			"    };\n" + 
			"\n" + 
			"    TASK thread1 {\n" + 
			"        PRIORITY = 2;\n" + 
			"        ACTIVATION = 1;\n" + 
			"	STACK = SHARED;\n" + 
			"        SCHEDULE = FULL;\n" + 
			"    };\n" + 
			"\n" + 
			"    TASK thread2 {\n" + 
			"        PRIORITY = 3;\n" + 
			"        ACTIVATION = 4;\n" + 
			"	STACK = SHARED;\n" + 
			"        SCHEDULE = FULL;\n" + 
			"	RESOURCE= MUTEX_sync;\n" + 
			"    };\n" + 
			"\n" + 
			"    TASK thread3 {\n" + 
			"        PRIORITY = 4;\n" + 
			"        ACTIVATION = 4;\n" + 
			"	STACK = SHARED;\n" + 
			"        SCHEDULE = FULL;\n" + 
			"    };\n" + 
			"    \n" + 
			"\n" + 
			"    RESOURCE MUTEX_sync { RESOURCEPROPERTY = STANDARD; };\n" + 
			"};";
			
		commonWriterTest(text, 1);
	}
	

	@Test public void testArm7Orti() {
		final String text = 
			"CPU test_application {\n" +
			"OS EE {\n" +
			"	EE_OPT = \"__ARM7GNU__\";\n" +
			"	EE_OPT = \"__ST_STA2051__\";\n" +
			"	EE_OPT = \"__COBRA_ICD30__\";\n" +
			"	EE_OPT = \"DEBUG\";\n" +
			"	EE_OPT = \"__TIMER_0_USED__\";\n" +
			"	EE_OPT = \"__TIMER_1_USED__\";\n" +
			"	EE_OPT = \"__OO_SEM__\";\n" +
			"\n" +
			"	CPU_DATA = ARM7 {\n" +
			"		APP_SRC = \"code.c\";\n" +
			"		APP_SRC = \"handlers.S\";\n" +
			"		STACK_TOP    = 0x10000;\n" +
			"		STACK_BOTTOM = 0x08000;\n" +
			"		SYS_SIZE     = 0x04000;\n" +
			"		SVC_SIZE     = 0x00800;\n" +
			"		FIQ_SIZE     = 0x00800;\n" +
			"		ABT_SIZE     = 0x00800;\n" +
			"		UND_SIZE     = 0x00800;\n" +
			"		MULTI_STACK = TRUE {\n" +
			"			IRQ_STACK = TRUE {\n" +
			"				SYS_SIZE=512;\n" +
			"			};\n" +
			"			DUMMY_STACK = SHARED;\n" +
			"		};\n" +
			"	};\n" +
			"  \n" +
			"	STATUS = STANDARD;\n" +
			"	STARTUPHOOK = FALSE;\n" +
			"	ERRORHOOK = FALSE;\n" +
			"	SHUTDOWNHOOK = FALSE;\n" +
			"	PRETASKHOOK = FALSE;\n" +
			"	POSTTASKHOOK = FALSE;\n" +
			"	USEGETSERVICEID = FALSE;\n" +
			"	USEPARAMETERACCESS = FALSE;\n" +
			"	USERESSCHEDULER = FALSE;\n" +
			"	\n" +
			"	ORTI_SECTIONS = ALL;\n" +
			"	KERNEL_TYPE = ECC2;\n" +
			"};\n" +
			"\n" +
			"TASK Task0 {\n" +
			"	PRIORITY = 0x01;   /* Low priority */\n" +
			"	SCHEDULE = FULL;\n" +
			"	AUTOSTART = FALSE;\n" +
			"	STACK = SHARED;\n" +
			"	ACTIVATION = 1;    /* only one pending activation */\n" +
			"	RESOURCE = Resource;\n" +
			"};	\n" +
			"\n" +
			"TASK Task1 {\n" +
			"	PRIORITY = 0x02;   /* High priority */\n" +
			"	SCHEDULE = FULL;\n" +
			"	AUTOSTART = TRUE;	\n" +
			"	STACK = SHARED;\n" +
			"	ACTIVATION = 1;\n" +
			"};\n" +
			"\n" +
			"RESOURCE Resource { RESOURCEPROPERTY = STANDARD; };\n" +
			"\n" +
			"COUNTER Counter1 {\n" +
			"        MINCYCLE = 2;\n" +
			"        MAXALLOWEDVALUE = -1 ;\n" +
			"        TICKSPERBASE = 1;\n" +
			"};\n" +
			"\n" +
			"ALARM AlarmTask2 {\n" +
			"            COUNTER = Counter1;\n" +
			"            ACTION = ACTIVATETASK { TASK = Task1; };\n" +
			"		AUTOSTART = TRUE {" +
			"			ALARMTIME = 1;\n" +
			"			CYCLETIME = 1;\n" +
			"		};\n" +
			"	};\n" +
			"};\n";

		commonWriterTest(text, 1);
	}

	@Test public void testCodeWrite_BOARD_eval7t() {
		final String text = "CPU test_application {\n" + "\n" + "    OS EE {\n"
				+ "		CPU_DATA = ARM7 {\n" 
				+ "			MULTI_STACK = TRUE {\n"
				+ "				IRQ_STACK = FALSE;\n" 
				+ "				DUMMY_STACK = SHARED;\n"
				+ "			};\n" + "			\n" 
				+ "			APP_SRC = \"code.c\";\n" + "	\n"
				+ "			STACK_TOP    = 0x80000;\n"
				+ "			STACK_BOTTOM = 0x20000;\n"
				+ "			SYS_SIZE     = 0x4000;\n" 
				+ "			IRQ_SIZE     = 0x4000;\n"
				+ "			SVC_SIZE     = 0x4000;\n" 
				+ "			FIQ_SIZE     = 0x4000;\n"
				+ "			ABT_SIZE     = 0x4000;\n" 
				+ "			UND_SIZE     = 0x4000;\n"
				+ "	\n" 
				+ "		};\n" + "		\n"
				+ "		KERNEL_TYPE = FP;\n" + "\n"
				+ "		BOARD_DATA = EVALUATOR7T;\n" 
				+ "    };\n" 
				+ "\n"
				+ "    TASK Task1 {\n" 
				+ "		PRIORITY = 0x01;\n"
				+ "		ACTIVATION = 1;\n" 
				+ "		SCHEDULE = FULL;\n"
				+ "		AUTOSTART = TRUE;\n" 
				+ "		STACK = SHARED;\n" 
				+ "    };\n"
				+ "\n" 
				+ "    TASK Task2 {\n" 
				+ "		PRIORITY = 0x02;\n"
				+ "		ACTIVATION = 1;\n" 
				+ "		SCHEDULE = FULL;\n"
				+ "		AUTOSTART = FALSE;	\n"
				+ "		STACK = SHARED;\n"
				+ "    };\n"
				+ "};";

		commonWriterTest(text, 1);
	}

	
	@Test public void testCodeWriteWithManyEvents() {
		final String text =
			"CPU EE {\n"
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
		
			"		MCU_DATA = SAMSUNG_KS32C50100;\n"
			
			+ "        STATUS = EXTENDED;\n"
			+ "        STARTUPHOOK = TRUE;\n"
			+ "        ERRORHOOK = FALSE;\n"
			+ "        SHUTDOWNHOOK = FALSE;\n"
			+ "        PRETASKHOOK = FALSE;\n"
			+ "        POSTTASKHOOK = FALSE;\n"
			+ "        USEGETSERVICEID = FALSE;\n"
			+ "        USEPARAMETERACCESS = FALSE;\n"
			+ "        USERESSCHEDULER = TRUE;\n"
			+ "        KERNEL_TYPE = ECC2;\n"
			+ "    };\n"
			+ "    TASK Task1 {\n"
			+ "        PRIORITY = 0x01;\n"
			+ "        ACTIVATION = 1;\n"
			+ "        SCHEDULE = FULL;\n"
			+ "        AUTOSTART = TRUE;\n"
			+ "        STACK = PRIVATE {\n"
			+ "            SYS_SIZE = 0x100;\n"
		//	+ "            IRQ_SIZE = 0x100;\n"
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
			+ "	 EVENT evento2 { MASK = 4; };\n"
			+ "	 EVENT evento3 {};\n"
			+ "	 EVENT evento4 {};\n"
			+ "	 EVENT evento5 {};\n"
			+ "	 EVENT evento6 {};\n"
			+ "	 EVENT evento7 { MASK = 8; };\n"
			+ "};\n";
		
		commonWriterTest(text, 1);
	}

// with alarms/counters

	@Test public void testCodeWriteAlarmAndCounter() {
		final String text = "CPU EE {\n"
			+ "    OS EE {\n"+
			
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
		
			"		MCU_DATA = SAMSUNG_KS32C50100;\n"
			
			+ "        STATUS = EXTENDED;\n"
			+ "        STARTUPHOOK = TRUE;\n"
			+ "        ERRORHOOK = FALSE;\n"
			+ "        SHUTDOWNHOOK = FALSE;\n"
			+ "        PRETASKHOOK = FALSE;\n"
			+ "        POSTTASKHOOK = FALSE;\n"
			+ "        USEGETSERVICEID = FALSE;\n"
			+ "        USEPARAMETERACCESS = FALSE;\n"
			+ "        USERESSCHEDULER = TRUE;\n"
			+ "        KERNEL_TYPE = ECC2;\n"
			+ "    };\n"
			+ "    TASK Task1 {\n"
			+ "        PRIORITY = 0x01;\n"
			+ "        ACTIVATION = 1;\n"
			+ "        SCHEDULE = FULL;\n"
			+ "        AUTOSTART = TRUE;\n"
			+ "        STACK = SHARED;\n"
			+ "    };\n"
			+ "    TASK Task2 {\n"
			+ "        PRIORITY = 0x02;\n"
			+ "        ACTIVATION = 1;\n"
			+ "        SCHEDULE = FULL;\n"
			+ "        AUTOSTART = TRUE;\n"
			+ "        STACK = SHARED;\n"
			+ "    };\n"
			+ "    COUNTER Counter1 {\n"
			+ "        MINCYCLE = 1;\n"
			+ "        MAXALLOWEDVALUE = 16 ;\n"
			+ "        TICKSPERBASE = 1;\n"
			+ "    };\n"
		
			+ "    ALARM Alarm1 {\n"
			+ "    	COUNTER = Counter1;\n"
			+ "    	ACTION = SETEVENT { TASK = Task2; EVENT = Event1; };\n"
			+ "    	AUTOSTART = FALSE;\n"
			+ "    };\n"
			
			+ "    ALARM Alarm2 {\n"
			+ "     COUNTER = Counter1;\n"
			+ "    	ACTION = ACTIVATETASK { TASK = Task1; };\n"
			+ "    	AUTOSTART = FALSE;\n"
			+ "    };\n"
			
			+ "	 EVENT Event1 {};\n"
			+ "};\n";
	
		commonWriterTest(text, 1);
	}

	@Test public void testCodeWriteAlarmAutostart() {
		final String text = "CPU EE {\n"
			+ "    OS EE {\n"+
			
			"		CPU_DATA = ARM7 {\n" +
			"			MULTI_STACK = TRUE {\n" +
			"				IRQ_STACK = TRUE {\n" +
				"                                    SYS_SIZE = 0x100;\n" +
		//		"                                    IRQ_SIZE = 0x400;\n" +
				"                                };\n" +
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
		
			"		MCU_DATA = SAMSUNG_KS32C50100;\n"
			
			+ "        STATUS = EXTENDED;\n"
			+ "        STARTUPHOOK = TRUE;\n"
			+ "        ERRORHOOK = FALSE;\n"
			+ "        SHUTDOWNHOOK = FALSE;\n"
			+ "        PRETASKHOOK = FALSE;\n"
			+ "        POSTTASKHOOK = FALSE;\n"
			+ "        USEGETSERVICEID = FALSE;\n"
			+ "        USEPARAMETERACCESS = FALSE;\n"
			+ "        USERESSCHEDULER = TRUE;\n"
			+ "        KERNEL_TYPE = ECC2;\n"
			+ "    };\n"
			+ "    TASK Task1 {\n"
			+ "        PRIORITY = 0x01;\n"
			+ "        ACTIVATION = 1;\n"
			+ "        SCHEDULE = FULL;\n"
			+ "        AUTOSTART = TRUE;\n"
			+ "        STACK = SHARED;\n"
			+ "    };\n"
			+ "    TASK Task2 {\n"
			+ "        PRIORITY = 0x02;\n"
			+ "        ACTIVATION = 1;\n"
			+ "        SCHEDULE = FULL;\n"
			+ "        AUTOSTART = TRUE;\n"
			+ "        STACK = SHARED;\n"
			+ "    };\n"
			+ "    TASK Task3 {\n"
			+ "        PRIORITY = 0x04;\n"
			+ "        ACTIVATION = 1;\n"
			+ "        SCHEDULE = FULL;\n"
			+ "        AUTOSTART = TRUE { APPMODE=ModeEdge;};\n"
			+ "        STACK = SHARED;\n"
			+ "    };\n"
			+ "    COUNTER Counter1 {\n"
			+ "        MINCYCLE = 1;\n"
			+ "        MAXALLOWEDVALUE = 16 ;\n"
			+ "        TICKSPERBASE = 1;\n"
			+ "    };\n"
		
			+ "    APPMODE ModeIncremental;"
			+ "    APPMODE ModeEdge;"
		
			+ "    ALARM Alarm1 {\n"
			+ "    	COUNTER = Counter1;\n"
			+ "    	ACTION = SETEVENT { TASK = Task2; EVENT = Event1; };\n"
			+ "    	AUTOSTART = TRUE { ALARMTIME=5; CYCLETIME=10; };\n"
			+ "    };\n"
			
			+ "    ALARM Alarm2 {\n"
			+ "     COUNTER = Counter1;\n"
			+ "    	ACTION = ACTIVATETASK { TASK = Task1; };\n"
			+ "    	AUTOSTART = TRUE { ALARMTIME=20; CYCLETIME=1; APPMODE=ModeIncremental; APPMODE=ModeEdge; };\n"
			+ "    };\n"
			
			+ "	 EVENT Event1 {};\n"
			+ "};\n";

		commonWriterTest(text, 1);
	}

// with RESOURCES

	@Test public void testCodeWriteWithoutResources() {
		final String text = "CPU EE {\n"
			+ "    OS EE {\n"+
			
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
		
			"		MCU_DATA = SAMSUNG_KS32C50100;\n"
			
			+ "        STATUS = EXTENDED;\n"
			+ "        STARTUPHOOK = TRUE;\n"
			+ "        ERRORHOOK = FALSE;\n"
			+ "        SHUTDOWNHOOK = FALSE;\n"
			+ "        PRETASKHOOK = FALSE;\n"
			+ "        POSTTASKHOOK = FALSE;\n"
			+ "        USEGETSERVICEID = FALSE;\n"
			+ "        USEPARAMETERACCESS = FALSE;\n"
			+ "        USERESSCHEDULER = FALSE;\n"
			+ "        KERNEL_TYPE = BCC1;\n"
			+ "    };\n"
			+ "    TASK Task0 {\n"
			+ "        PRIORITY = 0x08;\n"
			+ "        ACTIVATION = 1;\n"
			+ "        SCHEDULE = FULL;\n"
			+ "        AUTOSTART = TRUE;\n"
			+ "        STACK = SHARED;\n"
			+ "    };\n"
			+ "    TASK Task1 {\n"
			+ "        PRIORITY = 0x01;\n"
			+ "        ACTIVATION = 1;\n"
			+ "        SCHEDULE = FULL;\n"
			+ "       /* AUTOSTART = FALSE;\n*/"
			+ "        STACK = SHARED;\n"
			+ "    };\n"
			+ "    TASK Task2 {\n"
			+ "        PRIORITY = 0x02;\n"
			+ "        ACTIVATION = 1;\n"
			+ "        SCHEDULE = FULL;\n"
			+ "        AUTOSTART = FALSE;\n"
			+ "        STACK = SHARED;\n"
			+ "    };\n"
			+ "};\n";
		
		commonWriterTest(text, 1);
	}

// with RESOURCES

	@Test public void testCodeWriteResources() {
		final String text = "CPU EE {\n"
			+ "    OS EE {\n"+
			
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
		
			"		MCU_DATA = SAMSUNG_KS32C50100;\n"
			
			+ "        STATUS = EXTENDED;\n"
			+ "        STARTUPHOOK = TRUE;\n"
			+ "        ERRORHOOK = FALSE;\n"
			+ "        SHUTDOWNHOOK = FALSE;\n"
			+ "        PRETASKHOOK = FALSE;\n"
			+ "        POSTTASKHOOK = FALSE;\n"
			+ "        USEGETSERVICEID = FALSE;\n"
			+ "        USEPARAMETERACCESS = FALSE;\n"
			+ "        USERESSCHEDULER = TRUE;\n"
			+ "        KERNEL_TYPE = ECC2;\n"
			+ "    };\n"
			+ "    TASK Task1 {\n"
			+ "        PRIORITY = 0x01;\n"
			+ "        ACTIVATION = 1;\n"
			+ "        SCHEDULE = FULL;\n"
			+ "        AUTOSTART = TRUE;\n"
			+ "        STACK = SHARED;\n"
			+ "        RESOURCE = res1;\n"
			+ "        RESOURCE = res2;\n"
			+ "        RESOURCE = res5;\n"
			+ "        RESOURCE = res5_a;\n"
			+ "    };\n"
			+ "    TASK Task2 {\n"
			+ "        PRIORITY = 0x02;\n"
			+ "        ACTIVATION = 1;\n"
			+ "        SCHEDULE = FULL;\n"
			+ "        AUTOSTART = TRUE;\n"
			+ "        STACK = SHARED;\n"
			+ "        RESOURCE = res3;\n"
			+ "        RESOURCE = res5;\n"
			+ "        RESOURCE = res5_b;\n"
			+ "    };\n"
			+ "    RESOURCE res1 {\n"
			+ "        RESOURCEPROPERTY = STANDARD { APP_SRC=\"res1_src.c\"; };\n"
			+ "    };\n"
			+ "    RESOURCE res2L {\n"
			+ "        RESOURCEPROPERTY = LINKED { LINKEDRESOURCE = res2; } ;\n"
			+ "    };\n"
			+ "    RESOURCE res2 {\n"
			+ "        RESOURCEPROPERTY = STANDARD { APP_SRC=\"res2_src.c\"; };\n"
			+ "    };\n"
			+ "    RESOURCE res3 {\n"
			+ "        RESOURCEPROPERTY = STANDARD;\n"
			+ "    };\n"
			+ "    RESOURCE res4 {\n"
			+ "        RESOURCEPROPERTY = LINKED { LINKEDRESOURCE = res2; } ;\n"
			+ "    };\n"
			+ "    RESOURCE res_unused {\n"
			+ "        RESOURCEPROPERTY = STANDARD;\n"
			+ "    };\n"
			+ "    RESOURCE res5 {\n"
			+ "        RESOURCEPROPERTY = INTERNAL;\n"
			+ "    };\n"
			+ "    RESOURCE res5_a {\n"
			+ "        RESOURCEPROPERTY = STANDARD { APP_SRC=\"res5_a_src.c\"; };\n"
			+ "    };\n"
			+ "    RESOURCE res5_b {\n"
			+ "        RESOURCEPROPERTY = LINKED { LINKEDRESOURCE = res5_a; } ;\n"
			+ "    };\n"
			+ "};\n";

		commonWriterTest(text, 1);
	}

// with Many Tasks

	@Test public void testCodeWriteWithManyTasks() {
		final String text = "CPU EE {\n"
			+ "    OS EE {\n"+
			
			"		CPU_DATA = ARM7 {\n" +
			"			MULTI_STACK = TRUE {\n" +
			"				IRQ_STACK = FALSE;\n" +
			"				/*DUMMY_STACK = SHARED;\n*/" +
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
		
			"		MCU_DATA = SAMSUNG_KS32C50100;\n"
			
			+ "        STATUS = EXTENDED;\n"
			+ "        STARTUPHOOK = TRUE;\n"
			+ "        ERRORHOOK = FALSE;\n"
			+ "        SHUTDOWNHOOK = FALSE;\n"
			+ "        PRETASKHOOK = FALSE;\n"
			+ "        POSTTASKHOOK = FALSE;\n"
			+ "        USEGETSERVICEID = FALSE;\n"
			+ "        USEPARAMETERACCESS = FALSE;\n"
			+ "        USERESSCHEDULER = FALSE;\n"
			+ "        KERNEL_TYPE = ECC1;\n"
			+ "    };\n"
			+ "    TASK Task1 { PRIORITY = 1; ACTIVATION = 1; SCHEDULE = FULL; /*STACK = SHARED;*/ };\n"
			+ "    TASK Task2 { PRIORITY = 2; ACTIVATION = 1; SCHEDULE = FULL; STACK = SHARED; };\n"
			+ "    TASK Task3 { PRIORITY = 3; ACTIVATION = 1; SCHEDULE = FULL; STACK = SHARED; };\n"
			+ "    TASK Task4 { PRIORITY = 4; ACTIVATION = 1; SCHEDULE = FULL; STACK = SHARED; };\n"
			+ "    TASK Task5 { PRIORITY = 5; ACTIVATION = 1; SCHEDULE = FULL; STACK = SHARED; };\n"
			+ "    TASK Task6 { PRIORITY = 6; ACTIVATION = 1; SCHEDULE = FULL; STACK = SHARED; };\n"
			+ "    TASK Task7 { PRIORITY = 7; ACTIVATION = 1; SCHEDULE = FULL; STACK = SHARED; };\n"
			+ "    TASK Task8 { PRIORITY = 8; ACTIVATION = 1; SCHEDULE = FULL; STACK = SHARED; };\n"
			+ "    TASK Task9 { PRIORITY = 9; ACTIVATION = 1; SCHEDULE = FULL; STACK = SHARED; };\n"
			+ "    TASK Task10 { PRIORITY = 10; };\n"
			+ "    TASK Task11 { PRIORITY = 11; ACTIVATION = 1; SCHEDULE = FULL; STACK = SHARED; };\n"
			+ "    TASK Task12 { PRIORITY = 12; ACTIVATION = 1; SCHEDULE = FULL; STACK = SHARED; };\n"
			+ "    TASK Task13 { PRIORITY = 13; ACTIVATION = 1; SCHEDULE = FULL; STACK = SHARED; };\n"
			+ "    TASK Task14 { PRIORITY = 14; ACTIVATION = 1; SCHEDULE = FULL; STACK = SHARED; };\n"
			+ "    TASK Task15 { PRIORITY = 15; ACTIVATION = 1; SCHEDULE = FULL; STACK = SHARED; };\n"
			+ "    TASK Task16 { PRIORITY = 16; ACTIVATION = 1; SCHEDULE = FULL; STACK = SHARED; };\n"
			+ "    TASK Task17 { PRIORITY =  1; ACTIVATION = 1; SCHEDULE = FULL; STACK = SHARED; };\n"
			+ "    TASK Task18 { PRIORITY =  2; ACTIVATION = 1; SCHEDULE = FULL; STACK = SHARED; };\n"
			+ "    TASK Task19 { PRIORITY =  3; ACTIVATION = 1; SCHEDULE = FULL; STACK = SHARED; };\n"
			+ "    TASK Task10 {                ACTIVATION = 1; };\n"
			+ "    TASK Task20 { PRIORITY =  4; ACTIVATION = 1; SCHEDULE = FULL; STACK = SHARED; };\n"
			+ "    TASK Task21 { PRIORITY =  5; ACTIVATION = 1; SCHEDULE = FULL; STACK = SHARED; };\n"
			+ "    TASK Task22 { PRIORITY =  6; ACTIVATION = 1; SCHEDULE = FULL; STACK = SHARED; };\n"
			+ "    TASK Task23 { PRIORITY =  7; ACTIVATION = 1; SCHEDULE = FULL; STACK = SHARED; };\n"
			+ "    TASK Task24 { PRIORITY =  8; ACTIVATION = 1; SCHEDULE = FULL; STACK = SHARED; };\n"
			+ "    TASK Task25 { PRIORITY =  9; ACTIVATION = 1; SCHEDULE = FULL; STACK = SHARED; };\n"
			+ "    TASK Task26 { PRIORITY = 10; ACTIVATION = 1; SCHEDULE = FULL; STACK = SHARED; };\n"
			+ "    TASK Task27 { PRIORITY = 11; ACTIVATION = 1; SCHEDULE = FULL; STACK = SHARED; };\n"
			+ "    TASK Task28 { PRIORITY = 12; ACTIVATION = 1; SCHEDULE = FULL; STACK = SHARED; };\n"
			+ "    TASK Task29 { PRIORITY = 13; ACTIVATION = 1; SCHEDULE = FULL; STACK = SHARED; };\n"
			+ "    TASK Task10 {                                SCHEDULE = FULL; };\n"
			+ "    TASK Task30 { PRIORITY = 14; ACTIVATION = 1; SCHEDULE = FULL; STACK = SHARED; };\n"
			+ "    TASK Task31 { PRIORITY = 15; ACTIVATION = 1; SCHEDULE = FULL; STACK = SHARED; };\n"
			+ "    TASK Task32 { PRIORITY = 16; ACTIVATION = 1; SCHEDULE = FULL; STACK = SHARED; };\n"
			+ "    TASK Task33 { PRIORITY =  1; ACTIVATION = 1; SCHEDULE = FULL; STACK = SHARED; };\n"
			+ "    TASK Task34 { PRIORITY =  2; ACTIVATION = 1; SCHEDULE = FULL; STACK = SHARED; };\n"
			+ "    TASK Task35 { PRIORITY =  3; ACTIVATION = 1; SCHEDULE = FULL; STACK = SHARED; };\n"
			+ "    TASK Task10 {                                                 STACK = SHARED; };\n"
			+ "};\n";

		commonWriterTest(text, 1);
	}

	
	@Test public void testResScheduler() {
	    final String text =
				"CPU mySystem {\n" + 
				"	OS myOs {\n" +
				"		EE_OPT = \"DEBUG\";" + 
				"		EE_OPT = \"VERBOSE\";" + 
				"       STATUS = EXTENDED;\n" + 
				"       USERESSCHEDULER = FALSE;\n" + 
				"		CPU_DATA = ARM7 {\n" +
				"			MULTI_STACK = TRUE {\n" +
				"				IRQ_STACK = FALSE;\n" +
				"				/*DUMMY_STACK = SHARED;\n*/" +
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
			
				"		MCU_DATA = SAMSUNG_KS32C50100;\n"+
				"		KERNEL_TYPE = ECC2;\n" +
				"	};\n" + 
				"    TASK Task0 {\n" + 
				"        PRIORITY = 2;\n" + 
				"        ACTIVATION = 4;\n" + 
				"        STACK = SHARED;\n" + 
				"        SCHEDULE = FULL;\n" + 
				"				RESOURCE = RES_SCHEDULER;\n" + 
				"				RESOURCE = res1;\n" + 
				"    };\n" + 
				"    RESOURCE res1 { RESOURCEPROPERTY = STANDARD; };\n" + 
//				"    RESOURCE RES_SCHEDULER { RESOURCEPROPERTY = STANDARD; };\n" + 
//				"    RESOURCE res3 { RESOURCEPROPERTY = STANDARD; };\n" + 
				"};\n";
		commonWriterTest(text, 1);
	}


}
