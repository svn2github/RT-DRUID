package com.eu.evidence.rtdruid.test.modules.oil.codewriter;

import org.junit.Test;

import com.eu.evidence.rtdruid.vartree.Vt2StringUtilities;



public class CodeWriterMico32Test extends AbstractCodeWriterTest {
	
	
	@Test public void testMICO_32_mono_stack() {
	    final String text ="CPU test_application {\n"+
			"\n"+
			"	OS EE {		\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\"; \n"+
			"\n"+
			"		CPU_DATA = LM32 {\n"+
			"			APP_SRC = \"main.c\";\n"+
			"			MULTI_STACK = FALSE;\n"+
//			"			USESTANDALONEPRINTF = FALSE; // Optional, default is FALSE\n"+
			"			USESTANDALONEPRINTF = TRUE; // Optional, default is FALSE\n"+
//			"			USESMALLC = TRUE; // Optional, defautl is FALSE\n"+
			"			USESMALLC = FALSE; // Optional, defautl is FALSE\n"+
			"		};\n"+
			"		\n"+
			"\n"+
			"		MCU_DATA = LATTICE_PLATFORM {\n"+
			"   			MODEL = LIBRARY {\n"+
			"				PLATFORM_LIB_PATH = \"../onchipramtimer_lib\";\n"+
			"				PLATFORM_NAME = \"onchipramtimer\";\n"+
			"				PLATFORM_BLD_CFG = \"Release\"; // Optional, default is \"\"\n"+
			"   			};\n"+
			"  		};\n"+
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
			"    };\n"+
			"    \n"+
			"    /* this is the OIL part for the first task */\n"+
			"    TASK Task1 {\n"+
			"		PRIORITY = 0x01;   /* Low priority */\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;    /* only one pending activation */\n"+
			"	};	\n"+
			"\n"+
			"    OS EE { KERNEL_TYPE = FP; }; 	\n"+
			"};";
		commonWriterTest(text, 1);
	}

	@Test public void testMICO_32_multi_stack() {
	    final String text = "CPU test_application {\n" +
			"\n" +
			"	OS EE {		\n" +
			"		EE_OPT = \"DEBUG_STACK\";\n" +
			"\n" +
			"		CFLAGS = \"-g2\";\n" +
			"		ASFLAGS = \"\";\n" +
			"		LDFLAGS = \"\"; \n" +
			"\n" +
			"		CPU_DATA = LM32 {\n" +
			"			APP_SRC = \"main.c\";\n" +
			"			MULTI_STACK = TRUE;\n" +
			"			USESTANDALONEPRINTF = TRUE; // Optional, default is FALSE\n" +
			"			USESMALLC = FALSE; // Optional, defautl is FALSE\n" +
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
			"		\n" +
			"    };\n" +
			"    \n" +
			"    /* this is the OIL part for the first task */\n" +
			"    TASK Task1 {\n" +
			"		PRIORITY = 0x01;   /* Low priority */\n" +
			"		AUTOSTART = FALSE;\n" +
			"		STACK = PRIVATE {\n" +
			"			SYS_SIZE = 512;\n" +
			"		};\n" +
			"		ACTIVATION = 1;    /* only one pending activation */\n" +
			"	};	\n" +
			"\n" +
			"    /* this is the OIL part for the second task */\n" +
			"    TASK Task2 {\n" +
			"		PRIORITY = 0x02;   /* High priority */\n" +
			"		AUTOSTART = FALSE;\n" +
			"		STACK = SHARED;\n" +
			"		ACTIVATION = 1;    /* only one pending activation */\n" +
			"	};	\n" +
			"\n" +
			"    OS EE { KERNEL_TYPE = FP; }; 	\n" +
			"};";
		commonWriterTest(text, 1);
	}

	@Test public void testMICO_32_OSEK_multi_stack() {
	    final String text = "CPU test_application {\n" +
			"\n" +
			"	OS EE {		\n" +
			"		EE_OPT = \"DEBUG_STACK\";\n" +
			"\n" +
			"		CFLAGS = \"-g2\";\n" +
			"		ASFLAGS = \"\";\n" +
			"		LDFLAGS = \"\"; \n" +
			"\n" +
			"		CPU_DATA = LM32 {\n" +
			"			APP_SRC = \"main.c\";\n" +
			"			MULTI_STACK = TRUE;\n" +
			"			USESTANDALONEPRINTF = TRUE; // Optional, default is FALSE\n" +
			"			USESMALLC = FALSE; // Optional, defautl is FALSE\n" +
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
			"		\n" +
			"    };\n" +
			"    \n" +
			"    /* this is the OIL part for the first task */\n" +
			"    TASK Task1 {\n" +
			"		PRIORITY = 0x01;   /* Low priority */\n" +
			"		AUTOSTART = FALSE;\n" +
			"		STACK = PRIVATE {\n" +
			"			SYS_SIZE = 512;\n" +
			"		};\n" +
			"		ACTIVATION = 1;    /* only one pending activation */\n" +
			"	};	\n" +
			"\n" +
			"    /* this is the OIL part for the second task */\n" +
			"    TASK Task2 {\n" +
			"		PRIORITY = 0x02;   /* High priority */\n" +
			"		AUTOSTART = FALSE;\n" +
			"		STACK = SHARED;\n" +
			"		ACTIVATION = 1;    /* only one pending activation */\n" +
			"	};	\n" +
			"\n" +
			"    OS EE { KERNEL_TYPE = ECC2; }; 	\n" +
			"};";
		commonWriterTest(text, 1);
	}

	
	@Test public void testMICO_32_FP_multi_stack_IRQ() {
	    final String text = "CPU test_application {\n" +
			"\n" +
			"	OS EE {		\n" +
			"		EE_OPT = \"DEBUG_STACK\";\n" +
			"\n" +
			"		CFLAGS = \"-g2\";\n" +
			"		ASFLAGS = \"\";\n" +
			"		LDFLAGS = \"\"; \n" +
			"\n" +
			"		CPU_DATA = LM32 {\n" +
			"			APP_SRC = \"main.c\";\n" +
			"			MULTI_STACK = TRUE {\n" + 
			"				IRQ_STACK = TRUE {\n" + 
			"					SYS_SIZE=512;\n" + 
			"				};\n" + 
			"			};\n" + 
			"			USESTANDALONEPRINTF = TRUE; // Optional, default is FALSE\n" +
			"			USESMALLC = FALSE; // Optional, defautl is FALSE\n" +
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
			"		\n" +
			"    };\n" +
			"    \n" +
			"    /* this is the OIL part for the first task */\n" +
			"    TASK Task1 {\n" +
			"		PRIORITY = 0x01;   /* Low priority */\n" +
			"		AUTOSTART = FALSE;\n" +
			"		STACK = PRIVATE {\n" +
			"			SYS_SIZE = 512;\n" +
			"		};\n" +
			"		ACTIVATION = 1;    /* only one pending activation */\n" +
			"	};	\n" +
//			"\n" +
//			"    /* this is the OIL part for the second task */\n" +
//			"    TASK Task2 {\n" +
//			"		PRIORITY = 0x02;   /* High priority */\n" +
//			"		AUTOSTART = FALSE;\n" +
//			"		STACK = SHARED;\n" +
//			"		ACTIVATION = 1;    /* only one pending activation */\n" +
//			"	};	\n" +
			"\n" +
			"    OS EE { KERNEL_TYPE = FP; }; 	\n" +
			"};";
		commonWriterTest(text, 1);
	}

	
	@Test public void testMICO_32_FP_multi_stack_IRQ_2() {
	    final String text = "CPU test_application {\n" +
			"\n" +
			"	OS EE {		\n" +
			"		EE_OPT = \"DEBUG_STACK\";\n" +
			"\n" +
			"		CFLAGS = \"-g2\";\n" +
			"		ASFLAGS = \"\";\n" +
			"		LDFLAGS = \"\"; \n" +
			"\n" +
			"		CPU_DATA = LM32 {\n" +
			"			APP_SRC = \"main.c\";\n" +
			"			MULTI_STACK = TRUE {\n" + 
			"				IRQ_STACK = TRUE {\n" + 
			"					SYS_SIZE=512;\n" + 
			"				};\n" + 
			"			};\n" + 
			"			USESTANDALONEPRINTF = TRUE; // Optional, default is FALSE\n" +
			"			USESMALLC = FALSE; // Optional, defautl is FALSE\n" +
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
			"		\n" +
			"    };\n" +
			"    \n" +
			"    TASK Task1 {\n" +
			"		PRIORITY = 0x01;   /* Low priority */\n" +
			"		AUTOSTART = FALSE;\n" +
			"		STACK = PRIVATE {\n" +
			"			SYS_SIZE = 512;\n" +
			"		};\n" +
			"		ACTIVATION = 1;    /* only one pending activation */\n" +
			"	};	\n" +
			"\n" +
			"    TASK Task2 {\n" +
			"		PRIORITY = 0x02;   /* High priority */\n" +
			"		AUTOSTART = FALSE;\n" +
			"		STACK = SHARED;\n" +
//			"		STACK = PRIVATE {\n" +
//			"			SYS_SIZE = 512;\n" +
//			"		};\n" +
			"		ACTIVATION = 1;    /* only one pending activation */\n" +
			"	};	\n" +
			"    TASK Task3 {\n" +
			"		PRIORITY = 0x01;   /* Low priority */\n" +
			"		AUTOSTART = FALSE;\n" +
			"		STACK = PRIVATE {\n" +
			"			SYS_SIZE = 512;\n" +
			"		};\n" +
			"		ACTIVATION = 1;    /* only one pending activation */\n" +
			"	};	\n" +
			"\n" +
			"    TASK Task4 {\n" +
			"		PRIORITY = 0x02;   /* High priority */\n" +
			"		AUTOSTART = FALSE;\n" +
			"		STACK = PRIVATE {\n" +
			"			SYS_SIZE = 512;\n" +
			"		};\n" +
			"		ACTIVATION = 1;    /* only one pending activation */\n" +
			"	};	\n" +
			"\n" +
			"    OS EE { KERNEL_TYPE = FP; }; 	\n" +
			"};";
		commonWriterTest(text, 1);
	}
	
	
	@Test public void testMICO_32_ISR() {
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
			"		COUNTER = MainTimer;\n" +
			"		ACTION = ACTIVATETASK {\n" +
			"			TASK = Task1;\n" +
			"		};\n" +
			"		/* Autstart is not supported on FP kernel! */\n" +
			"		AUTOSTART = FALSE;\n" +
			"	};\n" +
			"\n" +
			"	OS EE { KERNEL_TYPE = FP; }; 	\n" +
			"};";

    
    	DefaultTestResult result = commonWriterTest(text, 1);
    	
    	System.out.println(Vt2StringUtilities.varTreeToStringErtd(result.vt));
	}

	
	@Test public void testMICO_32_mcu_only() {
	    final String text ="CPU test_application {\n"+
			"\n"+
			"	OS EE {		\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\"; \n"+
			"\n"+
			"		CPU_DATA = LM32 {\n"+
			"			APP_SRC = \"main.c\";\n"+
			"			MULTI_STACK = FALSE;\n"+
//			"			USESTANDALONEPRINTF = FALSE; // Optional, default is FALSE\n"+
			"			USESTANDALONEPRINTF = TRUE; // Optional, default is FALSE\n"+
//			"			USESMALLC = TRUE; // Optional, defautl is FALSE\n"+
			"			USESMALLC = FALSE; // Optional, defautl is FALSE\n"+
			"		};\n"+
			"		\n"+
			"\n"+
			"		MCU_DATA = LATTICE_PLATFORM {\n"+
			"   			MODEL = LIBRARY {\n"+
			"				PLATFORM_LIB_PATH = \"../onchipramtimer_lib\";\n"+
			"				PLATFORM_NAME = \"onchipramtimer\";\n"+
			"				PLATFORM_BLD_CFG = \"Release\"; // Optional, default is \"\"\n"+
			"   			};\n"+
			"			DEVICE = UART{\n" +
			"				NAME = \"Uart_1\"; \n" +
			"				OPTIONS = UART_IRQ_SUPPORT; \n" +
			"			};\n" +
			"			DEVICE = UART{\n" +
			"				NAME = \"Uart_2\";\n" +
			"				OPTIONS = ALL;\n" +
			"			};\n" +
			"			DEVICE = SPI{\n" +
			"				NAME = \"spi_1\";\n" +
			"				OPTIONS = SPI_IRQ_SUPPORT;\n" +
			"				OPTIONS = ALL;\n" +
			"			};\n" +
			"			DEVICE = TIMER{\n" +
			"				NAME = \"system_timer_1\";\n" +
			"				OPTIONS = TIMER_IRQ_SUPPORT;\n" +
			"				OPTIONS = ALL;\n" +
			"			};\n" +
			"			DEVICE = TIMER{\n" +
			"				NAME = \"system_timer_2\";\n" +
			"				OPTIONS = ALL;\n" +
			"			};\n" +
			"			DEVICE = TIMER{\n" +
			"				NAME = \"system_timer_3\";\n" +
			"				OPTIONS = TIMER_IRQ_SUPPORT;\n" +
			"			};\n" +
			"			DEVICE = TIMER{\n" +
			"				NAME = \"system_timer_4\";\n" +
			"			};\n" +
			"			DEVICE = I2C{\n" +
			"				NAME = \"i2c_1\";\n" +
			"				OPTIONS = I2C_IRQ_SUPPORT;\n" +
			"			};\n" +

			"  		};\n"+
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
			"    };\n"+
			"    \n"+
			"    /* this is the OIL part for the first task */\n"+
			"    TASK Task1 {\n"+
			"		PRIORITY = 0x01;   /* Low priority */\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;    /* only one pending activation */\n"+
			"	};	\n"+
			"\n"+
			"    OS EE { KERNEL_TYPE = FP; }; 	\n"+
			"};";
		commonWriterTest(text, 1);
	}


	@Test public void testMICO_32_board_only_bee() {
	    final String text ="CPU test_application {\n"+
			"\n"+
			"	OS EE {		\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\"; \n"+
			"\n"+
			"		CPU_DATA = LM32 {\n"+
			"			APP_SRC = \"main.c\";\n"+
			"			MULTI_STACK = FALSE;\n"+
//			"			USESTANDALONEPRINTF = FALSE; // Optional, default is FALSE\n"+
			"			USESTANDALONEPRINTF = TRUE; // Optional, default is FALSE\n"+
//			"			USESMALLC = TRUE; // Optional, defautl is FALSE\n"+
			"			USESMALLC = FALSE; // Optional, defautl is FALSE\n"+
			"		};\n"+
			"		\n"+
			"\n"+
			"		MCU_DATA = LATTICE_PLATFORM {\n"+
			"   			MODEL = LIBRARY {\n"+
			"				PLATFORM_LIB_PATH = \"../onchipramtimer_lib\";\n"+
			"				PLATFORM_NAME = \"onchipramtimer\";\n"+
			"				PLATFORM_BLD_CFG = \"Release\"; // Optional, default is \"\"\n"+
			"   			};\n"+

			"  		};\n"+
			"\n"+
			"			BOARD_DATA = XP2_CAMERA_BOARD {\n" +
			"				OPTIONS = LIGHTSENSOR;\n" +
			"				OPTIONS = RS232;\n" +
			"				OPTIONS = RS232_IRQ_SUPPORT;\n" +
			"				OPTIONS = CAMERA;\n" +
			"				OPTIONS = CAMERA_IRQ_SUPPORT;\n" +
			"				OPTIONS = RTCLOCK;\n" +
			"				OPTIONS = RTCLOCK_IRQ_SUPPORT;\n" +
			"				OPTIONS = EXTSPI;\n" +
			"				OPTIONS = EXTSPI_IRQ_SUPPORT;\n" +
			"				OPTIONS = ZIGBEE;\n" +
			"				OPTIONS = ZIGBEE_IRQ_SUPPORT;\n" +
//			"				OPTIONS = ETHERNET;\n" +
//			"				OPTIONS = ETHERNET_IRQ_SUPPORT;\n" +
//			"				OPTIONS = ALL_ZIGBEE;\n" +
//			"				OPTIONS = ALL_ETHERNET;\n" +
			"			};\n" +
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
			"    };\n"+
			"    \n"+
			"    /* this is the OIL part for the first task */\n"+
			"    TASK Task1 {\n"+
			"		PRIORITY = 0x01;   /* Low priority */\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;    /* only one pending activation */\n"+
			"	};	\n"+
			"\n"+
			"    OS EE { KERNEL_TYPE = FP; }; 	\n"+
			"};";
		commonWriterTest(text, 1);
	}

	@Test public void testMICO_32_board_only_bee_bis() {
	    final String text ="CPU test_application {\n"+
			"\n"+
			"	OS EE {		\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\"; \n"+
			"\n"+
			"		CPU_DATA = LM32 {\n"+
			"			APP_SRC = \"main.c\";\n"+
			"			MULTI_STACK = FALSE;\n"+
//			"			USESTANDALONEPRINTF = FALSE; // Optional, default is FALSE\n"+
			"			USESTANDALONEPRINTF = TRUE; // Optional, default is FALSE\n"+
//			"			USESMALLC = TRUE; // Optional, defautl is FALSE\n"+
			"			USESMALLC = FALSE; // Optional, defautl is FALSE\n"+
			"		};\n"+
			"		\n"+
			"\n"+
			"		MCU_DATA = LATTICE_PLATFORM {\n"+
			"   			MODEL = LIBRARY {\n"+
			"				PLATFORM_LIB_PATH = \"../onchipramtimer_lib\";\n"+
			"				PLATFORM_NAME = \"onchipramtimer\";\n"+
			"				PLATFORM_BLD_CFG = \"Release\"; // Optional, default is \"\"\n"+
			"   			};\n"+

			"  		};\n"+
			"\n"+
			"			BOARD_DATA = XP2_CAMERA_BOARD {\n" +
//			"				OPTIONS = TIMER;\n" +
//			"				OPTIONS = TIMER_IRQ_SUPPORT;\n" +
//			"				OPTIONS = RS232;\n" +
//			"				OPTIONS = RS232_IRQ_SUPPORT;\n" +
//			"				OPTIONS = CAMERA;\n" +
//			"				OPTIONS = CAMERA_IRQ_SUPPORT;\n" +
//			"				OPTIONS = RTCLOCK;\n" +
//			"				OPTIONS = RTCLOCK_IRQ_SUPPORT;\n" +
			"				OPTIONS = EXTSPI;\n" +
			"				OPTIONS = EXTSPI_IRQ_SUPPORT;\n" +
//			"				OPTIONS = ZIGBEE;\n" +
//			"				OPTIONS = ZIGBEE_IRQ_SUPPORT;\n" +
//			"				OPTIONS = ETHERNET;\n" +
//			"				OPTIONS = ETHERNET_IRQ_SUPPORT;\n" +
			"				OPTIONS = ALL_ZIGBEE;\n" +
//			"				OPTIONS = ALL_ETHERNET;\n" +
			"			};\n" +
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
			"    };\n"+
			"    \n"+
			"    /* this is the OIL part for the first task */\n"+
			"    TASK Task1 {\n"+
			"		PRIORITY = 0x01;   /* Low priority */\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;    /* only one pending activation */\n"+
			"	};	\n"+
			"\n"+
			"    OS EE { KERNEL_TYPE = FP; }; 	\n"+
			"};";
		commonWriterTest(text, 1);
	}

	@Test public void testMICO_32_board_only_eth() {
	    final String text ="CPU test_application {\n"+
			"\n"+
			"	OS EE {		\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\"; \n"+
			"\n"+
			"		CPU_DATA = LM32 {\n"+
			"			APP_SRC = \"main.c\";\n"+
			"			MULTI_STACK = FALSE;\n"+
//			"			USESTANDALONEPRINTF = FALSE; // Optional, default is FALSE\n"+
			"			USESTANDALONEPRINTF = TRUE; // Optional, default is FALSE\n"+
//			"			USESMALLC = TRUE; // Optional, defautl is FALSE\n"+
			"			USESMALLC = FALSE; // Optional, defautl is FALSE\n"+
			"		};\n"+
			"		\n"+
			"\n"+
			"		MCU_DATA = LATTICE_PLATFORM {\n"+
			"   			MODEL = LIBRARY {\n"+
			"				PLATFORM_LIB_PATH = \"../onchipramtimer_lib\";\n"+
			"				PLATFORM_NAME = \"onchipramtimer\";\n"+
			"				PLATFORM_BLD_CFG = \"Release\"; // Optional, default is \"\"\n"+
			"   			};\n"+

			"  		};\n"+
			"\n"+
			"			BOARD_DATA = XP2_CAMERA_BOARD {\n" +
			"				OPTIONS = LIGHTSENSOR;\n" +
			"				OPTIONS = RS232;\n" +
			"				OPTIONS = RS232_IRQ_SUPPORT;\n" +
			"				OPTIONS = CAMERA;\n" +
			"				OPTIONS = CAMERA_IRQ_SUPPORT;\n" +
			"				OPTIONS = RTCLOCK;\n" +
			"				OPTIONS = RTCLOCK_IRQ_SUPPORT;\n" +
			"				OPTIONS = EXTSPI;\n" +
			"				OPTIONS = EXTSPI_IRQ_SUPPORT;\n" +
//			"				OPTIONS = ZIGBEE;\n" +
//			"				OPTIONS = ZIGBEE_IRQ_SUPPORT;\n" +
			"				OPTIONS = ETHERNET;\n" +
			"				OPTIONS = ETHERNET_IRQ_SUPPORT;\n" +
//			"				OPTIONS = ALL_ZIGBEE;\n" +
//			"				OPTIONS = ALL_ETHERNET;\n" +
			"			};\n" +
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
			"    };\n"+
			"    \n"+
			"    /* this is the OIL part for the first task */\n"+
			"    TASK Task1 {\n"+
			"		PRIORITY = 0x01;   /* Low priority */\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;    /* only one pending activation */\n"+
			"	};	\n"+
			"\n"+
			"    OS EE { KERNEL_TYPE = FP; }; 	\n"+
			"};";
		commonWriterTest(text, 1);
	}

	@Test public void testMICO_32_board_only_eth_bis() {
	    final String text ="CPU test_application {\n"+
			"\n"+
			"	OS EE {		\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\"; \n"+
			"\n"+
			"		CPU_DATA = LM32 {\n"+
			"			APP_SRC = \"main.c\";\n"+
			"			MULTI_STACK = FALSE;\n"+
//			"			USESTANDALONEPRINTF = FALSE; // Optional, default is FALSE\n"+
			"			USESTANDALONEPRINTF = TRUE; // Optional, default is FALSE\n"+
//			"			USESMALLC = TRUE; // Optional, defautl is FALSE\n"+
			"			USESMALLC = FALSE; // Optional, defautl is FALSE\n"+
			"		};\n"+
			"		\n"+
			"\n"+
			"		MCU_DATA = LATTICE_PLATFORM {\n"+
			"   			MODEL = LIBRARY {\n"+
			"				PLATFORM_LIB_PATH = \"../onchipramtimer_lib\";\n"+
			"				PLATFORM_NAME = \"onchipramtimer\";\n"+
			"				PLATFORM_BLD_CFG = \"Release\"; // Optional, default is \"\"\n"+
			"   			};\n"+

			"  		};\n"+
			"\n"+
			"			BOARD_DATA = XP2_CAMERA_BOARD {\n" +
			"				OPTIONS = LIGHTSENSOR;\n" +
//			"				OPTIONS = TIMER;\n" +
//			"				OPTIONS = TIMER_IRQ_SUPPORT;\n" +
//			"				OPTIONS = RS232;\n" +
//			"				OPTIONS = RS232_IRQ_SUPPORT;\n" +
			"				OPTIONS = CAMERA;\n" +
//			"				OPTIONS = CAMERA_IRQ_SUPPORT;\n" +
//			"				OPTIONS = RTCLOCK;\n" +
//			"				OPTIONS = RTCLOCK_IRQ_SUPPORT;\n" +
//			"				OPTIONS = EXTSPI;\n" +
//			"				OPTIONS = EXTSPI_IRQ_SUPPORT;\n" +
//			"				OPTIONS = ZIGBEE;\n" +
//			"				OPTIONS = ZIGBEE_IRQ_SUPPORT;\n" +
//			"				OPTIONS = ETHERNET;\n" +
//			"				OPTIONS = ETHERNET_IRQ_SUPPORT;\n" +
//			"				OPTIONS = ALL_ZIGBEE;\n" +
			"				OPTIONS = ALL_ETHERNET;\n" +
			"			};\n" +
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
			"    };\n"+
			"    \n"+
			"    /* this is the OIL part for the first task */\n"+
			"    TASK Task1 {\n"+
			"		PRIORITY = 0x01;   /* Low priority */\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;    /* only one pending activation */\n"+
			"	};	\n"+
			"\n"+
			"    OS EE { KERNEL_TYPE = FP; }; 	\n"+
			"};";
		commonWriterTest(text, 1);
	}

	@Test public void testMICO_32_mcu_board() {
	    final String text ="CPU test_application {\n"+
			"\n"+
			"	OS EE {		\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\"; \n"+
			"\n"+
			"		CPU_DATA = LM32 {\n"+
			"			APP_SRC = \"main.c\";\n"+
			"			MULTI_STACK = FALSE;\n"+
//			"			USESTANDALONEPRINTF = FALSE; // Optional, default is FALSE\n"+
			"			USESTANDALONEPRINTF = TRUE; // Optional, default is FALSE\n"+
//			"			USESMALLC = TRUE; // Optional, defautl is FALSE\n"+
			"			USESMALLC = FALSE; // Optional, defautl is FALSE\n"+
			"		};\n"+
			"		\n"+
			"\n"+
			"		MCU_DATA = LATTICE_PLATFORM {\n"+
			"   			MODEL = LIBRARY {\n"+
			"				PLATFORM_LIB_PATH = \"../onchipramtimer_lib\";\n"+
			"				PLATFORM_NAME = \"onchipramtimer\";\n"+
			"				PLATFORM_BLD_CFG = \"Release\"; // Optional, default is \"\"\n"+
			"   			};\n"+
			"			DEVICE = UART{\n" +
			"				NAME = \"Uart_1\"; \n" +
			"				OPTIONS = UART_IRQ_SUPPORT; \n" +
			"			};\n" +
			"			DEVICE = UART{\n" +
			"				NAME = \"Uart_2\";\n" +
			"				OPTIONS = ALL;\n" +
			"			};\n" +
			"			DEVICE = SPI{\n" +
			"				NAME = \"spi_1\";\n" +
			"				OPTIONS = SPI_IRQ_SUPPORT;\n" +
			"				OPTIONS = ALL;\n" +
			"			};\n" +
			"			DEVICE = TIMER{\n" +
			"				NAME = \"system_timer_1\";\n" +
			"				OPTIONS = TIMER_IRQ_SUPPORT;\n" +
			"				OPTIONS = ALL;\n" +
			"			};\n" +
			"			DEVICE = TIMER{\n" +
			"				NAME = \"system_timer_2\";\n" +
			"				OPTIONS = ALL;\n" +
			"			};\n" +
			"			DEVICE = TIMER{\n" +
			"				NAME = \"system_timer_3\";\n" +
			"				OPTIONS = TIMER_IRQ_SUPPORT;\n" +
			"			};\n" +
			"			DEVICE = TIMER{\n" +
			"				NAME = \"system_timer_4\";\n" +
			"			};\n" +
			"			DEVICE = I2C{\n" +
			"				NAME = \"i2c_1\";\n" +
			"				OPTIONS = I2C_IRQ_SUPPORT;\n" +
			"			};\n" +

			"  		};\n"+
			"\n"+
			"			BOARD_DATA = XP2_CAMERA_BOARD {\n" +
//			"				OPTIONS = TIMER;\n" +
//			"				OPTIONS = TIMER_IRQ_SUPPORT;\n" +
//			"				OPTIONS = RS232;\n" +
//			"				OPTIONS = RS232_IRQ_SUPPORT;\n" +
//			"				OPTIONS = CAMERA;\n" +
//			"				OPTIONS = CAMERA_IRQ_SUPPORT;\n" +
//			"				OPTIONS = RTCLOCK;\n" +
//			"				OPTIONS = RTCLOCK_IRQ_SUPPORT;\n" +
			"				OPTIONS = EXTSPI;\n" +
			"				OPTIONS = EXTSPI_IRQ_SUPPORT;\n" +
//			"				OPTIONS = ZIGBEE;\n" +
//			"				OPTIONS = ZIGBEE_IRQ_SUPPORT;\n" +
//			"				OPTIONS = ETHERNET;\n" +
//			"				OPTIONS = ETHERNET_IRQ_SUPPORT;\n" +
			"				OPTIONS = ALL_ZIGBEE;\n" +
//			"				OPTIONS = ALL_ETHERNET;\n" +
			"			};\n" +
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
			"    };\n"+
			"    \n"+
			"    /* this is the OIL part for the first task */\n"+
			"    TASK Task1 {\n"+
			"		PRIORITY = 0x01;   /* Low priority */\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;    /* only one pending activation */\n"+
			"	};	\n"+
			"\n"+
			"    OS EE { KERNEL_TYPE = FP; }; 	\n"+
			"};";
		commonWriterTest(text, 1);
	}

//	@Test public void testMICO_32_1() {
//	    final String text ="";
//		commonWriterTest(text, 1);
//	}


	@Test public void testMICO_32_mcu_gpio() {
	    final String text ="CPU test_application {\n"+
			"\n"+
			"	OS EE {		\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\"; \n"+
			"\n"+
			"		CPU_DATA = LM32 {\n"+
			"			APP_SRC = \"main.c\";\n"+
			"			MULTI_STACK = FALSE;\n"+
//			"			USESTANDALONEPRINTF = FALSE; // Optional, default is FALSE\n"+
			"			USESTANDALONEPRINTF = TRUE; // Optional, default is FALSE\n"+
//			"			USESMALLC = TRUE; // Optional, default is FALSE\n"+
			"			USESMALLC = FALSE; // Optional, default is FALSE\n"+
			"		};\n"+
			"		\n"+
			"\n"+
			"		MCU_DATA = LATTICE_PLATFORM {\n"+
			"   			MODEL = LIBRARY {\n"+
			"				PLATFORM_LIB_PATH = \"../onchipramtimer_lib\";\n"+
			"				PLATFORM_NAME = \"onchipramtimer\";\n"+
			"				PLATFORM_BLD_CFG = \"Release\"; // Optional, default is \"\"\n"+
			"   			};\n"+
			"			DEVICE = GPIO{\n" +
			"				NAME = \"gpio_3\"; \n" +
			"				OPTIONS = ALL; \n" +
			"			};\n" +
			"			DEVICE = UART{\n" +
			"				NAME = \"Uart_1\"; \n" +
			"				OPTIONS = UART_IRQ_SUPPORT; \n" +
			"			};\n" +
			"			DEVICE = UART{\n" +
			"				NAME = \"Uart_2\";\n" +
			"				OPTIONS = ALL;\n" +
			"			};\n" +
			"			DEVICE = SPI{\n" +
			"				NAME = \"spi_1\";\n" +
			"				OPTIONS = SPI_IRQ_SUPPORT;\n" +
			"				OPTIONS = ALL;\n" +
			"			};\n" +
			"			DEVICE = TIMER{\n" +
			"				NAME = \"system_timer_1\";\n" +
			"				OPTIONS = TIMER_IRQ_SUPPORT;\n" +
			"				OPTIONS = ALL;\n" +
			"			};\n" +
			"			DEVICE = TIMER{\n" +
			"				NAME = \"system_timer_2\";\n" +
			"				OPTIONS = ALL;\n" +
			"			};\n" +
			"			DEVICE = TIMER{\n" +
			"				NAME = \"system_timer_3\";\n" +
			"				OPTIONS = TIMER_IRQ_SUPPORT;\n" +
			"			};\n" +
			"			DEVICE = TIMER{\n" +
			"				NAME = \"system_timer_4\";\n" +
			"			};\n" +
			"			DEVICE = I2C{\n" +
			"				NAME = \"i2c_1\";\n" +
			"				OPTIONS = I2C_IRQ_SUPPORT;\n" +
			"			};\n" +

			"  		};\n"+
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
			"    };\n"+
			"    \n"+
			"    /* this is the OIL part for the first task */\n"+
			"    TASK Task1 {\n"+
			"		PRIORITY = 0x01;   /* Low priority */\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;    /* only one pending activation */\n"+
			"	};	\n"+
			"\n"+
			"    OS EE { KERNEL_TYPE = FP; }; 	\n"+
			"};";
		commonWriterTest(text, 1);
	}


	@Test public void testMICO_32_board_only_lcd_gpio() {
	    final String text ="CPU test_application {\n"+
			"\n"+
			"	OS EE {		\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\"; \n"+
			"\n"+
			"		CPU_DATA = LM32 {\n"+
			"			APP_SRC = \"main.c\";\n"+
			"			MULTI_STACK = FALSE;\n"+
//			"			USESTANDALONEPRINTF = FALSE; // Optional, default is FALSE\n"+
			"			USESTANDALONEPRINTF = TRUE; // Optional, default is FALSE\n"+
//			"			USESMALLC = TRUE; // Optional, defautl is FALSE\n"+
			"			USESMALLC = FALSE; // Optional, defautl is FALSE\n"+
			"		};\n"+
			"		\n"+
			"\n"+
			"		MCU_DATA = LATTICE_PLATFORM {\n"+
			"   			MODEL = LIBRARY {\n"+
			"				PLATFORM_LIB_PATH = \"../onchipramtimer_lib\";\n"+
			"				PLATFORM_NAME = \"onchipramtimer\";\n"+
			"				PLATFORM_BLD_CFG = \"Release\"; // Optional, default is \"\"\n"+
			"   			};\n"+

			"  		};\n"+
			"\n"+
			"			BOARD_DATA = XP2_CAMERA_BOARD {\n" +
			"				OPTIONS = LIGHTSENSOR;\n" +
			"			};\n" +
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
			"    };\n"+
			"    \n"+
			"    /* this is the OIL part for the first task */\n"+
			"    TASK Task1 {\n"+
			"		PRIORITY = 0x01;   /* Low priority */\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;    /* only one pending activation */\n"+
			"	};	\n"+
			"\n"+
			"    OS EE { KERNEL_TYPE = FP; }; 	\n"+
			"};";
		commonWriterTest(text, 1);
	}


	@Test public void testMICO_32_board_only_lcd_gpio_() {
	    final String text ="CPU test_application {\n"+
			"\n"+
			"	OS EE {		\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\"; \n"+
			"\n"+
			"		CPU_DATA = LM32 {\n"+
			"			APP_SRC = \"main.c\";\n"+
			"			MULTI_STACK = FALSE;\n"+
//			"			USESTANDALONEPRINTF = FALSE; // Optional, default is FALSE\n"+
			"			USESTANDALONEPRINTF = TRUE; // Optional, default is FALSE\n"+
//			"			USESMALLC = TRUE; // Optional, defautl is FALSE\n"+
			"			USESMALLC = FALSE; // Optional, defautl is FALSE\n"+
			"		};\n"+
			"		\n"+
			"\n"+
			"		MCU_DATA = LATTICE_PLATFORM {\n"+
			"   			MODEL = LIBRARY {\n"+
			"				PLATFORM_LIB_PATH = \"../onchipramtimer_lib\";\n"+
			"				PLATFORM_NAME = \"onchipramtimer\";\n"+
			"				PLATFORM_BLD_CFG = \"Release\"; // Optional, default is \"\"\n"+
			"   			};\n"+
			"			DEVICE = GPIO{\n" +
			"				NAME = \"gpio_3\"; \n" +
			"				OPTIONS = ALL; \n" +
			"			};\n" +

			"  		};\n"+
			"\n"+
			"			BOARD_DATA = XP2_CAMERA_BOARD {\n" +
			"			};\n" +
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
			"    };\n"+
			"    \n"+
			"    /* this is the OIL part for the first task */\n"+
			"    TASK Task1 {\n"+
			"		PRIORITY = 0x01;   /* Low priority */\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;    /* only one pending activation */\n"+
			"	};	\n"+
			"\n"+
			"    OS EE { KERNEL_TYPE = FP; }; 	\n"+
			"};";
		commonWriterTest(text, 1);
	}

	@Test public void testMICO_32_board_misc_gpio_() {
	    final String text ="CPU test_application {\n"+
			"\n"+
			"	OS EE {		\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\"; \n"+
			"\n"+
			"		CPU_DATA = LM32 {\n"+
			"			APP_SRC = \"main.c\";\n"+
			"			MULTI_STACK = FALSE;\n"+
//			"			USESTANDALONEPRINTF = FALSE; // Optional, default is FALSE\n"+
			"			USESTANDALONEPRINTF = TRUE; // Optional, default is FALSE\n"+
//			"			USESMALLC = TRUE; // Optional, defautl is FALSE\n"+
			"			USESMALLC = FALSE; // Optional, defautl is FALSE\n"+
			"		};\n"+
			"		\n"+
			"\n"+
			"		MCU_DATA = LATTICE_PLATFORM {\n"+
			"   			MODEL = LIBRARY {\n"+
			"				PLATFORM_LIB_PATH = \"../onchipramtimer_lib\";\n"+
			"				PLATFORM_NAME = \"onchipramtimer\";\n"+
			"				PLATFORM_BLD_CFG = \"Release\"; // Optional, default is \"\"\n"+
			"   			};\n"+
			"			DEVICE = GPIO{\n" +
			"				NAME = \"gpio_3\"; \n" +
			"				OPTIONS = ALL; \n" +
			"			};\n" +

			"  		};\n"+
			"\n"+
			"			BOARD_DATA = XP2_CAMERA_BOARD {\n" +
			"				OPTIONS = LEDS;\n" +
			"				OPTIONS = ZIGBEE;\n" +
			"			};\n" +
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
			"    };\n"+
			"    \n"+
			"    /* this is the OIL part for the first task */\n"+
			"    TASK Task1 {\n"+
			"		PRIORITY = 0x01;   /* Low priority */\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;    /* only one pending activation */\n"+
			"	};	\n"+
			"\n"+
			"    OS EE { KERNEL_TYPE = FP; }; 	\n"+
			"};";
		commonWriterTest(text, 1);
	}

	@Test public void testMICO_32_evboard() {
	    final String text ="CPU test_application {\n"+
			"\n"+
			"	OS EE {		\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\"; \n"+
			"\n"+
			"		CPU_DATA = LM32 {\n"+
			"			APP_SRC = \"main.c\";\n"+
			"			MULTI_STACK = FALSE;\n"+
//			"			USESTANDALONEPRINTF = FALSE; // Optional, default is FALSE\n"+
			"			USESTANDALONEPRINTF = TRUE; // Optional, default is FALSE\n"+
//			"			USESMALLC = TRUE; // Optional, defautl is FALSE\n"+
			"			USESMALLC = FALSE; // Optional, defautl is FALSE\n"+
			"		};\n"+
			"		\n"+
			"\n"+
			"		MCU_DATA = LATTICE_PLATFORM {\n"+
			"   			MODEL = LIBRARY {\n"+
			"				PLATFORM_LIB_PATH = \"../onchipramtimer_lib\";\n"+
			"				PLATFORM_NAME = \"onchipramtimer\";\n"+
			"				PLATFORM_BLD_CFG = \"Release\"; // Optional, default is \"\"\n"+
			"   			};\n"+
			"			DEVICE = GPIO{\n" +
			"				NAME = \"gpio_3\"; \n" +
			"				OPTIONS = ALL; \n" +
			"			};\n" +

			"  		};\n"+
			"\n"+
			"			BOARD_DATA = LATTICE_XP2_EV_BOARD {\n" +
			"				OPTIONS = LEDS;\n" +
			"				OPTIONS = CAMERA;\n" +
			"				OPTIONS = RS232;\n" +
			"			};\n" +
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
			"    };\n"+
			"    \n"+
			"    /* this is the OIL part for the first task */\n"+
			"    TASK Task1 {\n"+
			"		PRIORITY = 0x01;   /* Low priority */\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;    /* only one pending activation */\n"+
			"	};	\n"+
			"\n"+
			"    OS EE { KERNEL_TYPE = FP; }; 	\n"+
			"};";
		commonWriterTest(text, 1);
	}

}
