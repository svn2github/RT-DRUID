package com.eu.evidence.rtdruid.test.modules.oil.codewriter;

import static org.junit.Assert.assertTrue;

import org.junit.Test;



public class CodeWriterCortexTest extends AbstractCodeWriterTest {
	

	@Test public void testCortexInternalResources() {
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
				"        CPU_DATA = CORTEX_MX {\n" + 
				"			MODEL = M0;\n" +
				"			APP_SRC = \"code.c\";\n" +
				"			MULTI_STACK = FALSE;\n" + 
				"		};\n" + 
				"		KERNEL_TYPE = FP;\n" + 
				"	};\n" + 
				"\n" + 
				"	TASK Task1 {\n"	 +
				"		SCHEDULE = FULL;\n"	 +
				"		PRIORITY = 0;\n"	 +
				"		ACTIVATION = 1;\n"	 +
				"		AUTOSTART = TRUE {\n"	 +
				"			APPMODE = OSDEFAULTAPPMODE;\n"	 +
				"		};\n"	 +
				"		RESOURCE = INT_Resource2;\n"	 +
				"	};\n"	 +
				"	\n"	 +
				"	TASK Task2 {\n"	 +
				"		SCHEDULE = FULL;\n"	 +
				"		PRIORITY = 2;\n"	 +
				"		ACTIVATION = 1;\n"	 +
				"		AUTOSTART = FALSE;\n"	 +
				"		RESOURCE = INT_Resource1;\n"	 +
				"	};\n"	 +
				"	\n"	 +
				"	TASK Task3 {\n"	 +
				"		SCHEDULE = FULL;\n"	 +
				"		PRIORITY = 4;\n"	 +
				"		ACTIVATION = 1;\n"	 +
				"		AUTOSTART = FALSE;\n"	 +
				"		RESOURCE = INT_Resource1;\n"	 +
				"	};\n"	 +
				"	\n"	 +
				"	TASK Task4 {\n"	 +
				"		SCHEDULE = FULL;\n"	 +
				"		PRIORITY = 6;\n"	 +
				"		ACTIVATION = 1;\n"	 +
				"		AUTOSTART = FALSE;\n"	 +
				"		RESOURCE = INT_Resource1;\n"	 +
				"	};\n"	 +
				"	\n"	 +
				"	TASK Task5 {\n"	 +
				"		SCHEDULE = FULL;\n"	 +
				"		PRIORITY = 1;\n"	 +
				"		ACTIVATION = 1;\n"	 +
				"		AUTOSTART = FALSE;\n"	 +
				"		RESOURCE = INT_Resource2;\n"	 +
				"	};\n"	 +
				"	\n"	 +
				"	RESOURCE INT_Resource1 {\n"	 +
				"		RESOURCEPROPERTY = INTERNAL;\n"	 +
				"	};\n"	 +
				"	\n"	 +
				"	RESOURCE INT_Resource2 {\n"	 +
				"		RESOURCEPROPERTY = INTERNAL;\n"	 +
				"	};\n" +
				"};\n";
		commonWriterTest(text, 1);
	}

	@Test public void testCortexDefaultCompiler() {
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
				"        CPU_DATA = CORTEX_MX {\n" + 
				"			MODEL = M0;\n" +
				"			APP_SRC = \"code.c\";\n" +
				"			MULTI_STACK = FALSE;\n" + 
				"		};\n" + 
				"		KERNEL_TYPE = FP;\n" + 
				"	};\n" + 
				"\n" + 
				"    TASK Task0 {\n" + 
				"        PRIORITY = 1;\n" + 
				"        ACTIVATION = 4;\n" + 
				"	};\n" + 
				"\n" + 
				"    TASK Task1 {\n" + 
				"        PRIORITY = 2;\n" + 
				"        ACTIVATION = 4;\n" + 
				"    };\n" + 
				"};\n";
		commonWriterTest(text, 1);
	}

	@Test
	public void testCortexCpuDataSplitted() {
	    final String text =
				"CPU mySystem {\n" + 
				"\n" + 
				"	OS myOs {\n" + 
				"	                \n" + 
				"		EE_OPT = \"DEBUG\";\n" + 
				"        STATUS = EXTENDED;\n" + 
				"        STARTUPHOOK = TRUE;\n" + 
				"        ERRORHOOK = FALSE;\n" + 
				"        SHUTDOWNHOOK = FALSE;\n" + 
				"        PRETASKHOOK = FALSE;\n" + 
				"        POSTTASKHOOK = FALSE;\n" + 
				"        USEGETSERVICEID = FALSE;\n" + 
				"        USEPARAMETERACCESS = FALSE;\n" + 
				"        USERESSCHEDULER = TRUE;\n" + 
				"        \n" + 
				"        CPU_DATA = CORTEX_MX {\n" + 
				"			MODEL = M0;\n" +
				"			APP_SRC = \"code.c\";\n" +
				"		};\n" + 
				"	};\n" + 
				"	OS myOs {\n" + 
				"        CPU_DATA = CORTEX_MX {\n" + 
				"			MODEL = M0;\n" +
				"			APP_SRC = \"code2.c\";\n" +
				"			MULTI_STACK = TRUE {\n" + 
				"				IRQ_STACK = TRUE {\n" + 
				"					SYS_SIZE=64;\n" + 
				"				};\n" + 
				"			};\n" + 
				"		};\n" + 
				"		KERNEL_TYPE = FP;\n" + 
				"	};\n" + 
				"\n" + 
				"    TASK Task0 {\n" + 
				"        PRIORITY = 1;\n" + 
				"        ACTIVATION = 4;\n" + 
				"	};\n" + 
				"\n" + 
				"    TASK Task1 {\n" + 
				"        PRIORITY = 2;\n" + 
				"        ACTIVATION = 4;\n" + 
				"    };\n" + 
				"};\n";
	    commonWriterTest(text, 1);
		//System.out.println(Vt2StringUtilities.explodeOilVar(Vt2StringUtilities.varTreeToStringErtd(commonWriterTest(text, 1).vt)));
	}
	
	@Test
	public void testCortexCpuDataSplittedBis() {
	    final String text =
				"CPU mySystem {\n" + 
				"\n" + 
				"	OS myOs {\n" + 
				"	                \n" + 
				"		EE_OPT = \"DEBUG\";\n" + 
				"        STATUS = EXTENDED;\n" + 
				"        STARTUPHOOK = TRUE;\n" + 
				"        ERRORHOOK = FALSE;\n" + 
				"        SHUTDOWNHOOK = FALSE;\n" + 
				"        PRETASKHOOK = FALSE;\n" + 
				"        POSTTASKHOOK = FALSE;\n" + 
				"        USEGETSERVICEID = FALSE;\n" + 
				"        USEPARAMETERACCESS = FALSE;\n" + 
				"        USERESSCHEDULER = TRUE;\n" + 
				"        \n" + 
				"        CPU_DATA = CORTEX_MX {\n" + 
				"			MODEL = M0;\n" +
				"			APP_SRC = \"code.c\";\n" +
				"			MULTI_STACK = TRUE {\n" + 
				"				IRQ_STACK = TRUE {\n" + 
				"					SYS_SIZE=64;\n" + 
				"				};\n" + 
				"			};\n" + 
				"			MULTI_STACK = TRUE {\n" + 
				"				IRQ_STACK = TRUE {\n" + 
				"					SYS_SIZE=64;\n" + 
				"				};\n" + 
				"			};\n" + 
				"		};\n" + 
				"        CPU_DATA = CORTEX_MX {\n" + 
				"			MODEL = M0;\n" +
				"			APP_SRC = \"code2.c\";\n" +
				"			MULTI_STACK = TRUE {\n" + 
				"				IRQ_STACK = TRUE {\n" + 
				"					SYS_SIZE=64;\n" + 
				"				};\n" + 
				"			};\n" + 
				"		};\n" + 
				"		KERNEL_TYPE = FP;\n" + 
				"	};\n" + 
				"\n" + 
				"    TASK Task0 {\n" + 
				"        PRIORITY = 1;\n" + 
				"        ACTIVATION = 4;\n" + 
				"	};\n" + 
				"\n" + 
				"    TASK Task1 {\n" + 
				"        PRIORITY = 2;\n" + 
				"        ACTIVATION = 4;\n" + 
				"    };\n" + 
				"};\n";
	    commonWriterTest(text, 1);
		//System.out.println(Vt2StringUtilities.explodeOilVar(Vt2StringUtilities.varTreeToStringErtd(commonWriterTest(text, 1).vt)));
	}

	
	@Test public void testCortexMono() {
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
				"        CPU_DATA = CORTEX_MX {\n" + 
				"			MODEL = M0;\n" +
				"			APP_SRC = \"code.c\";\n" +
				"			MULTI_STACK = FALSE;\n" + 
				"			JLINK = TRUE;\n" + 
				"			COMPILER_TYPE = IAR;\n" + 
				"		};\n" + 
				"		KERNEL_TYPE = FP;\n" + 
				"	};\n" + 
				"\n" + 
				"    TASK Task0 {\n" + 
				"        PRIORITY = 1;\n" + 
				"        ACTIVATION = 4;\n" + 
				"	};\n" + 
				"\n" + 
				"    TASK Task1 {\n" + 
				"        PRIORITY = 2;\n" + 
				"        ACTIVATION = 4;\n" + 
				"    };\n" + 
				"};\n";
		commonWriterTest(text, 1);
	}

	
	@Test public void testCortexMulti() {
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
				"        CPU_DATA = CORTEX_MX {\n" + 
				"			MODEL = M0;\n" +
				"			APP_SRC = \"code.c\";\n" +
				"			MULTI_STACK = TRUE {\n" + 
				"				IRQ_STACK = TRUE {\n" + 
				"					SYS_SIZE=64;\n" + 
				"				};\n" + 
				"			};\n" + 
				"			JLINK = TRUE;\n" + 
				"			COMPILER_TYPE = IAR;\n" + 
				"		};\n" + 
				"		KERNEL_TYPE = BCC1;\n" + 
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
				"    RESOURCE MUTEX_sync { RESOURCEPROPERTY = STANDARD; };\n" + 
				"};\n";
		commonWriterTest(text, 1);
	}
	
	@Test public void testCortexMcu() {
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
				"        CPU_DATA = CORTEX_MX {\n" + 
				"			MODEL = M0;\n" +
				"			APP_SRC = \"code.c\";\n" +
				"			MULTI_STACK = TRUE {\n" + 
				"				IRQ_STACK = TRUE {\n" + 
				"					SYS_SIZE=64;\n" + 
				"				};\n" + 
				"			};\n" + 
				"			JLINK = TRUE;\n" + 
				"			COMPILER_TYPE = IAR;\n" + 
				"		};\n" + 
				"		KERNEL_TYPE = BCC1;\n" + 
				
				"		MCU_DATA = LPCXPRESSO {\n" + 
				"			MODEL = CUSTOM {\n" + 
				"				MODEL = \"LPC1227\";\n" + 
				"				LINKERSCRIPT = \"../lpc12xx_flash.icf\";\n" +  // se e' presente un valore, aggiunge l'EE_OPT  __USE_CUSTOM_LINKER_SCRIPT__
				"				INCLUDE_C = \"LPC12xx.h\";\n" + 
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
				"    RESOURCE MUTEX_sync { RESOURCEPROPERTY = STANDARD; };\n" + 
				"};\n";
		commonWriterTest(text, 1);
	}

	
	@Test
	public void testIsrStellaris() {
	    final String text =
	    		"CPU mySystem {\n"+
	    				"\n"+
	    				"	OS myOs {\n"+
	    				"\n"+
	    				"		EE_OPT = \"DEBUG\";\n"+
	    				"		EE_OPT = \"__ASSERT__\";\n"+
	    				"\n"+
	    				"		CPU_DATA = CORTEX_MX {\n"+
	    				"			MODEL = M4;\n"+
	    				"			APP_SRC = \"code.c\";\n"+
	    				"			COMPILER_TYPE = CCS; \n"+
	    				"			MULTI_STACK = FALSE;\n"+
	    				"		};\n"+
	    				"\n"+
	    				"		MCU_DATA = STELLARIS {\n"+
	    				"			MODEL = LM4F232xxxx;\n"+
	    				"		};\n"+
	    				"\n"+
	    				"		EE_OPT = \"__USE_USER_LED__\";\n"+
	    				"		EE_OPT = \"__USE_SYSTICK__\";\n"+
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
	    				"		KERNEL_TYPE = FP;\n"+
	    				"\n"+
	    				"	};\n"+
	    				"\n"+
	    				"	TASK Task1 {\n"+
	    				"		PRIORITY = 0x01;   /* Low priority */\n"+
	    				"		AUTOSTART = FALSE;\n"+
	    				"		STACK = SHARED;\n"+
	    				"		ACTIVATION = 1;    /* only one pending activation */\n"+
	    				"	};\n"+
	    				"\n"+
	    				"	ISR systick_handler {\n"+
	    				"	  CATEGORY = 2;\n"+
	    				"	  ENTRY = \"SYSTICK\";\n"+
	    				"	  PRIORITY = 4;\n"+
	    				"	};\n"+
	    				"	ISR gpio_handler {\n"+
	    				"	  CATEGORY = 2;\n"+
	    				"	  ENTRY = \"GPIO_A\";\n"+
	    				"	  PRIORITY = 5;\n"+
	    				"	};\n"+
	    				"\n"+
	    				"};";
		commonWriterTest(text, 1);
	}
	
	@Test(expected=RuntimeException.class)
	public void testIsrStellaris_NW() {
	    final String text =
	    		"CPU mySystem {\n"+
	    				"\n"+
	    				"	OS myOs {\n"+
	    				"\n"+
	    				"		EE_OPT = \"DEBUG\";\n"+
	    				"		EE_OPT = \"__ASSERT__\";\n"+
	    				"\n"+
	    				"		CPU_DATA = CORTEX_MX {\n"+
	    				"			MODEL = M4;\n"+
	    				"			APP_SRC = \"code.c\";\n"+
	    				"			COMPILER_TYPE = CCS; \n"+
	    				"			MULTI_STACK = FALSE;\n"+
	    				"		};\n"+
	    				"\n"+
	    				"		MCU_DATA = STELLARIS {\n"+
	    				"			MODEL = LM4F232xxxx;\n"+
	    				"		};\n"+
	    				"\n"+
	    				"		EE_OPT = \"__USE_USER_LED__\";\n"+
	    				"		EE_OPT = \"__USE_SYSTICK__\";\n"+
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
	    				"		KERNEL_TYPE = FP;\n"+
	    				"\n"+
	    				"	};\n"+
	    				"\n"+
	    				"	TASK Task1 {\n"+
	    				"		PRIORITY = 0x01;   /* Low priority */\n"+
	    				"		AUTOSTART = FALSE;\n"+
	    				"		STACK = SHARED;\n"+
	    				"		ACTIVATION = 1;    /* only one pending activation */\n"+
	    				"	};\n"+
	    				"\n"+
	    				"	ISR systick_handler {\n"+
	    				"	  CATEGORY = 2;\n"+
	    				"	  ENTRY = \"SYSTICK\";\n"+
	    				"	  PRIORITY = 4;\n"+
	    				"	};\n"+
	    				"	ISR can1_handler {\n"+
	    				"	  CATEGORY = 2;\n"+
	    				"	  ENTRY = \"CAN1_TX\";\n"+
	    				"	  PRIORITY = 5;\n"+
	    				"	};\n"+
	    				"\n"+
	    				"};";
		commonWriterTest(text, 1);
	}
	
	@Test
	public void testIsrStm32() {
	    final String text =
	    		"CPU mySystem {\n"+
	    				"\n"+
	    				"	OS myOs {\n"+
	    				"\n"+
	    				"		EE_OPT = \"DEBUG\";\n"+
	    				"		EE_OPT = \"__ASSERT__\";\n"+
	    				"\n"+
	    				"		CPU_DATA = CORTEX_MX {\n"+
	    				"			MODEL = M4;\n"+
	    				"			APP_SRC = \"code.c\";\n"+
	    				"			COMPILER_TYPE = CCS; \n"+
	    				"			MULTI_STACK = FALSE;\n"+
	    				"		};\n"+
	    				"\n"+
	    				"		MCU_DATA = STM32 {\n"+
	    				"			MODEL = STM32F4xx;\n"+
	    				"		};\n"+
	    				"\n"+
	    				"		EE_OPT = \"__USE_USER_LED__\";\n"+
	    				"		EE_OPT = \"__USE_SYSTICK__\";\n"+
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
	    				"		KERNEL_TYPE = FP;\n"+
	    				"\n"+
	    				"	};\n"+
	    				"\n"+
	    				"	TASK Task1 {\n"+
	    				"		PRIORITY = 0x01;   /* Low priority */\n"+
	    				"		AUTOSTART = FALSE;\n"+
	    				"		STACK = SHARED;\n"+
	    				"		ACTIVATION = 1;    /* only one pending activation */\n"+
	    				"	};\n"+
	    				"\n"+
	    				"	ISR systick_handler {\n"+
	    				"	  CATEGORY = 2;\n"+
	    				"	  ENTRY = \"SYSTICK\";\n"+
	    				"	  PRIORITY = 4;\n"+
	    				"	};\n"+
	    				"	ISR can1_handler {\n"+
	    				"	  CATEGORY = 2;\n"+
	    				"	  ENTRY = \"CAN1_TX\";\n"+
	    				"	  PRIORITY = 5;\n"+
	    				"	};\n"+
	    				"\n"+
	    				"};";
		commonWriterTest(text, 1);
	}
	
	@Test
	public void testIsr1Stm32() {
	    final String text =
	    		"CPU mySystem {\n"+
	    				"\n"+
	    				"	OS myOs {\n"+
	    				"\n"+
	    				"		EE_OPT = \"DEBUG\";\n"+
	    				"		EE_OPT = \"__ASSERT__\";\n"+
	    				"\n"+
	    				"		CPU_DATA = CORTEX_MX {\n"+
	    				"			MODEL = M4;\n"+
	    				"			APP_SRC = \"code.c\";\n"+
	    				"			COMPILER_TYPE = CCS; \n"+
	    				"			MULTI_STACK = FALSE;\n"+
	    				"		};\n"+
	    				"\n"+
	    				"		MCU_DATA = STM32 {\n"+
	    				"			MODEL = STM32F4xx;\n"+
	    				"		};\n"+
	    				"\n"+
	    				"		EE_OPT = \"__USE_USER_LED__\";\n"+
	    				"		EE_OPT = \"__USE_SYSTICK__\";\n"+
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
	    				"		KERNEL_TYPE = FP;\n"+
	    				"\n"+
	    				"	};\n"+
	    				"\n"+
	    				"	TASK Task1 {\n"+
	    				"		PRIORITY = 0x01;   /* Low priority */\n"+
	    				"		AUTOSTART = FALSE;\n"+
	    				"		STACK = SHARED;\n"+
	    				"		ACTIVATION = 1;    /* only one pending activation */\n"+
	    				"	};\n"+
	    				"\n"+
	    				"	ISR systick_handler {\n"+
	    				"	  CATEGORY = 2;\n"+
	    				"	  ENTRY = \"SYSTICK\";\n"+
	    				"	  PRIORITY = 4;\n"+
	    				"	};\n"+
	    				"	ISR can1_handler {\n"+
	    				"	  CATEGORY = 1;\n"+
	    				"	  ENTRY = \"CAN1_TX\";\n"+
	    				"	  PRIORITY = 5;\n"+
	    				"	};\n"+
	    				"\n"+
	    				"};";
		commonWriterTest(text, 1);
	}
	
	@Test(expected=RuntimeException.class)
	public void testIsrStm32_NW() {
	    final String text =
	    		"CPU mySystem {\n"+
	    				"\n"+
	    				"	OS myOs {\n"+
	    				"\n"+
	    				"		EE_OPT = \"DEBUG\";\n"+
	    				"		EE_OPT = \"__ASSERT__\";\n"+
	    				"\n"+
	    				"		CPU_DATA = CORTEX_MX {\n"+
	    				"			MODEL = M4;\n"+
	    				"			APP_SRC = \"code.c\";\n"+
	    				"			COMPILER_TYPE = CCS; \n"+
	    				"			MULTI_STACK = FALSE;\n"+
	    				"		};\n"+
	    				"\n"+
	    				"		MCU_DATA = STM32 {\n"+
	    				"			MODEL = STM32F4xx;\n"+
	    				"		};\n"+
	    				"\n"+
	    				"		EE_OPT = \"__USE_USER_LED__\";\n"+
	    				"		EE_OPT = \"__USE_SYSTICK__\";\n"+
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
	    				"		KERNEL_TYPE = FP;\n"+
	    				"\n"+
	    				"	};\n"+
	    				"\n"+
	    				"	TASK Task1 {\n"+
	    				"		PRIORITY = 0x01;   /* Low priority */\n"+
	    				"		AUTOSTART = FALSE;\n"+
	    				"		STACK = SHARED;\n"+
	    				"		ACTIVATION = 1;    /* only one pending activation */\n"+
	    				"	};\n"+
	    				"\n"+
	    				"	ISR systick_handler {\n"+
	    				"	  CATEGORY = 2;\n"+
	    				"	  ENTRY = \"SYSTICK\";\n"+
	    				"	  PRIORITY = 4;\n"+
	    				"	};\n"+
	    				"\n"+
	    				"	ISR gpio_handler {\n"+
	    				"	  CATEGORY = 2;\n"+
	    				"	  ENTRY = \"GPIO_A\";\n"+
	    				"	  PRIORITY = 5;\n"+
	    				"	};\n"+
	    				"};";
		commonWriterTest(text, 1);
	}
		
		
	@Test
	public void testM4Keil() {
	    final String text =
	    		"CPU mySystem {\n"+
	    				"\n"+
	    				"	OS myOs {\n"+
	    				"\n"+
	    				"		EE_OPT = \"DEBUG\";\n"+
	    				"		EE_OPT = \"__ASSERT__\";\n"+
	    				"\n"+
	    				"		CPU_DATA = CORTEX_MX {\n"+
	    				"			MODEL = M4;\n"+
	    				"			APP_SRC = \"code.c\";\n"+
	    				"			COMPILER_TYPE = KEIL; \n"+
	    				"			MULTI_STACK = FALSE;\n"+
	    				"		};\n"+
	    				"\n"+
	    				"		MCU_DATA = STELLARIS {\n"+
	    				"			MODEL = LM4F232xxxx;\n"+
	    				"		};\n"+
	    				"\n"+
	    				"		EE_OPT = \"__USE_USER_LED__\";\n"+
	    				"		EE_OPT = \"__USE_SYSTICK__\";\n"+
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
	    				"		KERNEL_TYPE = FP;\n"+
	    				"\n"+
	    				"	};\n"+
	    				"\n"+
	    				"	TASK Task1 {\n"+
	    				"		PRIORITY = 0x01;   /* Low priority */\n"+
	    				"		AUTOSTART = FALSE;\n"+
	    				"		STACK = SHARED;\n"+
	    				"		ACTIVATION = 1;    /* only one pending activation */\n"+
	    				"	};\n"+
	    				"\n"+
	    				"	ISR systick_handler {\n"+
	    				"	  CATEGORY = 2;\n"+
	    				"	  ENTRY = \"SYSTICK\";\n"+
	    				"	};\n"+
	    				"\n"+
	    				"};";
		commonWriterTest(text, 1);
	}

	@Test
	public void testCortex_systemTimer() {
	    final String text = "CPU test_application {\n" +
			"\n" +
			"	OS EE {		\n" +
			"		EE_OPT = \"DEBUG_STACK\";\n" +
			"\n" +
			"		CFLAGS = \"-g2\";\n" +
			"		ASFLAGS = \"\";\n" +
			"		LDFLAGS = \"\"; \n" +
			"\n" +
			"		CPU_DATA = CORTEX_MX {\n"+
			"			MODEL = M4;\n"+
			"			APP_SRC = \"code.c\";\n"+
			"			COMPILER_TYPE = KEIL; \n"+
			"			MULTI_STACK = FALSE;\n"+
			"			CPU_CLOCK = 98.5;\n" +
			"		};\n"+
			"\n"+
			"		MCU_DATA = STELLARIS {\n"+
			"			MODEL = LM4F232xxxx;\n"+
			"		};\n"+
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
			"    OS EE { \n" +
			"		KERNEL_TYPE = ECC2;\n" +
			"		ORTI_SECTIONS = ALL;\n" +
			"  }; 	\n" +
			"	COUNTER myCounter0 {\n" +
			"		MINCYCLE = 0;\n" +
			"		MAXALLOWEDVALUE = 10;\n" +
			"		TICKSPERBASE = 1;\n" +
			"	};\n" +
			"	COUNTER myCounter1 {\n" +
			"		MINCYCLE = 0;\n" +
			"		MAXALLOWEDVALUE = 10;\n" +
			"		TICKSPERBASE = 1;\n" +
			"		SECONDSPERTICK = 1.4;\n" +
			"		TYPE = HARDWARE { DEVICE=\"DECREMENTER\";  SYSTEM_TIMER=TRUE;};\n" +
			"	};\n" +
			"	COUNTER myCounter {\n" +
			"		MINCYCLE = 0;\n" +
			"		MAXALLOWEDVALUE = 10;\n" +
			"		TICKSPERBASE = 1;\n" +
			"	};\n" +
			"	COUNTER myCounter2 {\n" +
			"		MINCYCLE = 0;\n" +
			"		MAXALLOWEDVALUE = 10;\n" +
			"		TICKSPERBASE = 1;\n" +
			"		SECONDSPERTICK = 0.004;\n" +
			"		TYPE = HARDWARE { DEVICE=\"INCREMENTER\"; PRIORITY=4; };\n" +
			"	};\n" +

			"	ALARM AcquireAlarm {\n" +
			"		COUNTER = myCounter;\n" +
			"		ACTION = INCREMENTCOUNTER { COUNTER = myCounter1; };\n" +
			"	};\n" +
			"};";
		commonWriterTest(text, 1);
	}

	@Test
	public void testCortex_multiLibs() {
	    final String text = "CPU test_application {\n" +
			"\n" +
			"	OS EE {\n" +
			"\n" +
			"		EE_OPT = \"DEBUG\";\n" +
			"		EE_OPT = \"__ASSERT__\";\n" +
			"\n" +
			"		CPU_DATA = CORTEX_MX {\n" +
			"			MODEL = M4;\n" +
			"			APP_SRC = \"main.c\";\n" +
			"			APP_SRC = \"Dio_Cfg.c\";\n" +
			"			APP_SRC = \"Icu_Cfg.c\";\n" +
			"			APP_SRC = \"Mcu_Cfg.c\";\n" +
			"			APP_SRC = \"Port_Cfg.c\";\n" +
			"			COMPILER_TYPE = KEIL;\n" +
			"			MULTI_STACK = FALSE;\n" +
			"		};\n" +
			"		\n" +
			"\n" +
			"		MCU_DATA = STELLARIS {\n" +
			"			MODEL = LM4F232xxxx;\n" +
			"		};\n" +
			"\n" +
			"		EE_OPT = \"__AUTOSAR_R4_0__\";\n" +
			"		EE_OPT = \"__AS_DIO_DRIVER__\";\n" +
			"		EE_OPT = \"__AS_MCU_DRIVER__\";\n" +
			"		EE_OPT = \"__AS_PORT_DRIVER__\";\n" +
			"\n" +
			"		EE_OPT = \"__AS_ICU_DRIVER__\";\n" +
			"\n" +
			"		/*\n" +
			"		 * Used to build separate libas.a and libassg.a without\n" +
			"		 * configuration.\n" +
			"		 */\n" +
			"		EE_OPT = \"__ADD_LIBS__\";\n" +
			"		LIB = ENABLE {\n" +
			"			NAME = \"AUTOSAR\";\n" +
			"		};\n" +
			"		LIB = ENABLE {\n" +
			"			NAME = \"AUTOSAR_SSG\";\n" +
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
			"		KERNEL_TYPE = FP;\n" +
			"\n" +
			"	};\n" +
			"\n" +
			"	/* this is the OIL part for the task */\n" +
			"	TASK Task1 {\n" +
			"		PRIORITY = 0x01;   /* Low priority */\n" +
			"		SCHEDULE = FULL;\n" +
			"		AUTOSTART = FALSE;\n" +
			"		ACTIVATION = 1;    /* only one pending activation */\n" +
			"		STACK = SHARED;\n" +
			"	};\n" +
			"\n" +
			"};";
		commonWriterTest(text, 1);
	}

	
	@Test
	public void testM4KeilStm32() {
	    final String text =
	    		"CPU mySystem {\n"+
	    				"\n"+
	    				"	OS myOs {\n"+
	    				"\n"+
	    				"		EE_OPT = \"DEBUG\";\n"+
	    				"		EE_OPT = \"__ASSERT__\";\n"+
	    				"\n"+
	    				"		CPU_DATA = CORTEX_MX {\n"+
	    				"			MODEL = M4;\n"+
	    				"			APP_SRC = \"code.c\";\n"+
	    				"			COMPILER_TYPE = KEIL; \n"+
	    				"			MULTI_STACK = FALSE;\n"+
	    				"		};\n"+
	    				"\n"+
	    				"		MCU_DATA = STM32 {\n"+
	    				"			MODEL = STM32F4xx;\n"+
	    				"		};\n"+
	    				"\n"+
	    				"		EE_OPT = \"__USE_USER_LED__\";\n"+
	    				"		EE_OPT = \"__USE_SYSTICK__\";\n"+
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
	    				"		KERNEL_TYPE = FP;\n"+
	    				"\n"+
	    				"	};\n"+
	    				"\n"+
	    				"	TASK Task1 {\n"+
	    				"		PRIORITY = 0x01;   /* Low priority */\n"+
	    				"		AUTOSTART = FALSE;\n"+
	    				"		STACK = SHARED;\n"+
	    				"		ACTIVATION = 1;    /* only one pending activation */\n"+
	    				"	};\n"+
	    				"\n"+
	    				"	ISR systick_handler {\n"+
	    				"	  CATEGORY = 2;\n"+
	    				"	  ENTRY = \"SYSTICK\";\n"+
	    				"	};\n"+
	    				"\n"+
	    				"};";
		commonWriterTest(text, 1);
	}

	
	@Test
	public void testCortex_multiLibsSysStack() {
	    final String text = "CPU test_application {\n" +
			"\n" +
			"	OS EE {\n" +
			"\n" +
			"		EE_OPT = \"DEBUG\";\n" +
			"		EE_OPT = \"__ASSERT__\";\n" +
			"\n" +
			"		CPU_DATA = CORTEX_MX {\n" +
			"			MODEL = M4;\n" +
			"			APP_SRC = \"main.c\";\n" +
			"			APP_SRC = \"Dio_Cfg.c\";\n" +
			"			APP_SRC = \"Icu_Cfg.c\";\n" +
			"			APP_SRC = \"Mcu_Cfg.c\";\n" +
			"			APP_SRC = \"Port_Cfg.c\";\n" +
			"			COMPILER_TYPE = KEIL;\n" +
			"			MULTI_STACK = FALSE;\n" +
			"			SYS_STACK_SIZE = 0xFFFF;\n" +			
			"		};\n" +
			"		\n" +
			"\n" +
			"		MCU_DATA = STELLARIS {\n" +
			"			MODEL = LM4F232xxxx;\n" +
			"		};\n" +
			"\n" +
			"		EE_OPT = \"__AUTOSAR_R4_0__\";\n" +
			"		EE_OPT = \"__AS_DIO_DRIVER__\";\n" +
			"		EE_OPT = \"__AS_MCU_DRIVER__\";\n" +
			"		EE_OPT = \"__AS_PORT_DRIVER__\";\n" +
			"\n" +
			"		EE_OPT = \"__AS_ICU_DRIVER__\";\n" +
			"\n" +
			"		/*\n" +
			"		 * Used to build separate libas.a and libassg.a without\n" +
			"		 * configuration.\n" +
			"		 */\n" +
			"		EE_OPT = \"__ADD_LIBS__\";\n" +
			"		LIB = ENABLE {\n" +
			"			NAME = \"AUTOSAR\";\n" +
			"		};\n" +
			"		LIB = ENABLE {\n" +
			"			NAME = \"AUTOSAR_SSG\";\n" +
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
			"		KERNEL_TYPE = FP;\n" +
			"\n" +
			"	};\n" +
			"\n" +
			"	/* this is the OIL part for the task */\n" +
			"	TASK Task1 {\n" +
			"		PRIORITY = 0x01;   /* Low priority */\n" +
			"		SCHEDULE = FULL;\n" +
			"		AUTOSTART = FALSE;\n" +
			"		ACTIVATION = 1;    /* only one pending activation */\n" +
			"		STACK = SHARED;\n" +
			"	};\n" +
			"\n" +
			"};";
		commonWriterTest(text, 1);
	}

	
	@Test
	public void testM4KeilStm32SyStack() {
	    final String text =
	    		"CPU mySystem {\n"+
	    				"\n"+
	    				"	OS myOs {\n"+
	    				"\n"+
	    				"		EE_OPT = \"DEBUG\";\n"+
	    				"		EE_OPT = \"__ASSERT__\";\n"+
	    				"\n"+
	    				"		CPU_DATA = CORTEX_MX {\n"+
	    				"			MODEL = M4;\n"+
	    				"			APP_SRC = \"code.c\";\n"+
	    				"			COMPILER_TYPE = KEIL; \n"+
	    				"			MULTI_STACK = FALSE;\n"+
	    				"			SYS_STACK_SIZE = 4000;\n" +			
	    				"		};\n"+
	    				"\n"+
	    				"		MCU_DATA = STM32 {\n"+
	    				"			MODEL = STM32F4xx;\n"+
	    				"		};\n"+
	    				"\n"+
	    				"		EE_OPT = \"__USE_USER_LED__\";\n"+
	    				"		EE_OPT = \"__USE_SYSTICK__\";\n"+
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
	    				"		KERNEL_TYPE = FP;\n"+
	    				"\n"+
	    				"	};\n"+
	    				"\n"+
	    				"	TASK Task1 {\n"+
	    				"		PRIORITY = 0x01;   /* Low priority */\n"+
	    				"		AUTOSTART = FALSE;\n"+
	    				"		STACK = SHARED;\n"+
	    				"		ACTIVATION = 1;    /* only one pending activation */\n"+
	    				"	};\n"+
	    				"\n"+
	    				"	ISR systick_handler {\n"+
	    				"	  CATEGORY = 2;\n"+
	    				"	  ENTRY = \"SYSTICK\";\n"+
	    				"	};\n"+
	    				"\n"+
	    				"};";
		commonWriterTest(text, 1);
	}


	@Test public void testCortexLib1() {
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
				"        CPU_DATA = CORTEX_MX {\n" + 
				"			MODEL = M0;\n" +
				"			APP_SRC = \"code.c\";\n" +
				"			MULTI_STACK = FALSE;\n" + 
				"		};\n" + 
				"		KERNEL_TYPE = FP;\n" + 
				
				"       LIB = ENABLE { NAME=\"STM32F4XX_SPD\"; \n" + 
				"       	STM32F4XX_SPD = ENABLE {\n" + 
				"		 USEALL = TRUE;\n" +
				"		 USEADC = TRUE;\n" +
				"		 USECAN = TRUE;\n" +
				"		 USECRC = TRUE;\n" +
				"		 USECRYP = TRUE;\n" +
				"		 USEDAC = TRUE;\n" +
				"		 USEDBGMCU = TRUE;\n" +
				"		 USEDCMI = TRUE;\n" +
				"		 USEDMA = TRUE;\n" +
				"		 USEEXTI = TRUE;\n" +
				"		 USEFLASH = TRUE;\n" +
				"		 USEFSMC = TRUE;\n" +
				"		 USEGPIO = TRUE;\n" +
				"		 USEHASH = TRUE;\n" +
				"		 USEI2C = TRUE;\n" +
				"		 USEIWDG = TRUE;\n" +
				"		 USEPWR = TRUE;\n" +
				"		 USERCC = TRUE;\n" +
				"		 USERNG = TRUE;\n" +
				"		 USERTC = TRUE;\n" +
				"		 USESDIO = TRUE;\n" +
				"		 USESPI = TRUE;\n" +
				"		 USESYSCFG = TRUE;\n" +
				"		 USETIM = TRUE;\n" +
				"		 USEUSART = TRUE;\n" +
				"		 USEWWDG = TRUE;\n" +
				"		 USEMISC = TRUE;\n" +
				"			};\n" + 

				"       	STM32F4_DISCOVERY = ENABLE {\n" + 
				"       		USEALL = TRUE;\n" +
				"       		USELEDS = TRUE;\n" +
				"       		USEBUTTONS = TRUE;\n" +
				"       		USECOM = TRUE;\n" +
				"       		USEAUDIO = TRUE;\n" +
				"       		USELCD = TRUE;\n" +
				"       		USELCDLOG = TRUE;\n" +
				"       		USEACCEL = TRUE;\n" +
				"       		USESD = TRUE;\n" +
				"       		USEUARTDEBUG = TRUE;\n" +
				"			};\n" + 
				"		};\n" + 

				"	};\n" + 
				"\n" + 
				"    TASK Task0 {\n" + 
				"        PRIORITY = 1;\n" + 
				"        ACTIVATION = 4;\n" + 
				"	};\n" + 
				"\n" + 
				"    TASK Task1 {\n" + 
				"        PRIORITY = 2;\n" + 
				"        ACTIVATION = 4;\n" + 
				"    };\n" + 
				"};\n";
		commonWriterTest(text, 1);
	}

	@Test public void testCortexAxXenPV() {
	    final String text =
				"CPU mySystem {\n" +
				"  OS myOs {\n" +
				"    EE_OPT = \"EE_DEBUG\";\n" +
				"    EE_OPT = \"__ASSERT__\";\n" +
				"    EE_OPT = \"EE_EXECUTE_FROM_RAM\";\n" +
				"\n" +
				"    STATUS = EXTENDED;\n" +
				"    USERESSCHEDULER = FALSE;\n" +
				"\n" +
				"    MCU_DATA = ALLWINNER {\n" +
				"      MODEL = A20;\n" +
				"    };\n" +
				"\n" +
				"    BOARD_DATA = CUBIEBOARD2;\n" +
				"\n" +
				"    MASTER_CPU = \"master\";\n" +
				"      CPU_DATA = CORTEX_AX_XENPV {\n" +
				"      CPU_CLOCK = 660.0;\n" +
				"      APP_SRC = \"main.c\";\n" +
				"      COMPILER_TYPE = GNU;\n" +
				"      MODEL = A7;\n" +
				"      ID = \"master\";\n" +
				"    };\n" +
				"\n" +
				"    EE_OPT = \"__OO_STARTOS_OLD__\";\n" +
				"    KERNEL_TYPE = BCC1;\n" +
				"\n" +
				"    ORTI_SECTIONS = ALL;\n" +
				"  };\n" +
				"\n" +
				"  TASK Hello_world_task {\n" +
				"    CPU_ID = \"master\";\n" +
				"    PRIORITY = 2;\n" +
				"    ACTIVATION = 1;\n" +
				"    STACK = SHARED;\n" +
				"    SCHEDULE = FULL;\n" +
				"  };\n" +
				"\n" +
				"};\n";
		commonWriterTest(text, 1);
	}
	
	

	@Test public void testCortexRx0() {
	    final String text =
				"CPU test_application {\n" +
				"	OS EE {\n" +
				"		EE_OPT = \"DEBUG\";\n" +
				"		EE_OPT = \"__ASSERT__\";\n" +
				"		\n" +
				"		CPU_DATA = CORTEX_RX {\n" +
				"			MODEL = R4;\n" +
				"			APP_SRC = \"code.c\";\n" +
				"			COMPILER_TYPE = CCS;\n" +
				"			MULTI_STACK = FALSE;\n" +
				"		};\n" +
				"		MCU_DATA = TI {\n" +
				"			MODEL = TMS570;\n" +
				"		};\n" +
				"		EE_OPT = \"__TI_DRIVER_LIB__\";\n" +
				"		EE_OPT = \"__USE_USER_LED__\";\n" +
				"		STATUS 				= EXTENDED;\n" +
				"		STARTUPHOOK 		= FALSE;\n" +
				"		ERRORHOOK 			= FALSE;\n" +
				"		SHUTDOWNHOOK 		= FALSE;\n" +
				"		PRETASKHOOK 		= FALSE;\n" +
				"		POSTTASKHOOK 		= FALSE;\n" +
				"		USEGETSERVICEID 	= FALSE;\n" +
				"		USEPARAMETERACCESS 	= FALSE;\n" +
				"		USERESSCHEDULER 	= FALSE;\n" +
				"		KERNEL_TYPE = FP;\n" +
				"	};\n" +
				"	TASK Task1 {\n" +
				"		PRIORITY = 0x01;\n" +
				"		SCHEDULE = FULL;\n" +
				"		AUTOSTART = FALSE;\n" +
				"		ACTIVATION = 1;\n" +
				"		STACK = SHARED;\n" +
				"	};\n" +
				"  TASK Task2 {\n" +
				"    PRIORITY = 0x02;\n" +
				"    AUTOSTART = FALSE;\n" +
				"    ACTIVATION = 1;\n" +
				"    STACK = SHARED;\n" +
				"  };\n" +
				"};\n";
		commonWriterTest(text, 1);
	}
	@Test public void testCortexRx1() {
	    final String text =
				"CPU mySystem {\n" +
				"	OS myOs {\n" +
				"		EE_OPT = \"DEBUG\";\n" +
				"		EE_OPT = \"__ASSERT__\";\n" +
				"		CPU_DATA = CORTEX_RX {\n" +
				"			MODEL = R4;\n" +
				"			APP_SRC = \"code.c\";\n" +
				"			COMPILER_TYPE = CCS; \n" +
				"			MULTI_STACK = FALSE;\n" +
				"		};\n" +
				"		MCU_DATA = TI {\n" +
				"			MODEL = TMS570;\n" +
				"		};\n" +
				"		EE_OPT = \"__USE_USER_LED__\";\n" +
				"		EE_OPT = \"__TI_DRIVER_LIB__\";\n" +
				"		EE_OPT = \"__ALLOW_NESTED_IRQ__\";\n" +
				"		KERNEL_TYPE = BCC1;\n" +
				"		EE_OPT = \"__OO_STARTOS_OLD__\";\n" +
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
				"	TASK Task1 {\n" +
				"		PRIORITY = 0x01;\n" +
				"		AUTOSTART = FALSE;\n" +
				"		STACK = SHARED;\n" +
				"		SCHEDULE = FULL;\n" +
				"		ACTIVATION = 1;\n" +
				"	};\n" +
				"	TASK Task2 {\n" +
				"		PRIORITY = 0x02;\n" +
				"		AUTOSTART = TRUE;\n" +
				"		STACK = SHARED;\n" +
				"		SCHEDULE = FULL;\n" +
				"	};\n" +
				"};\n";
		commonWriterTest(text, 1);
	}
	
	

	@Test public void test32Priorities_BCC1_RX() {
	    final String text = "CPU test_application {\n"+
			"\n"+
			"	OS EE {\n"+
			"		EE_OPT = \"__ASSERT__\";\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\";\n"+
			"\n"+
			"\n"+
			"		CPU_DATA = CORTEX_RX {\n" +
			"			MODEL = R4;\n" +
			"			APP_SRC = \"code.c\";\n" +
			"			COMPILER_TYPE = CCS;\n" +
			"			MULTI_STACK = FALSE;\n" +
			"		};\n" +
			"		MCU_DATA = TI {\n" +
			"			MODEL = TMS570;\n" +
			"		};\n" +
			"\n"+
			"		STATUS = EXTENDED;\n"+
			"\n"+
			"		KERNEL_TYPE = BCC1;\n"+
			"	};\n"+
			"\n"+
			"	TASK Task01 { PRIORITY = 1; };\n"+
			"	TASK Task02 { PRIORITY = 2; };\n"+
			"	TASK Task03 { PRIORITY = 3; };\n"+
			"	TASK Task04 { PRIORITY = 4; };\n"+
			"	TASK Task05 { PRIORITY = 5; };\n"+
			"	TASK Task06 { PRIORITY = 6; };\n"+
			"	TASK Task07 { PRIORITY = 7; };\n"+
			"	TASK Task08 { PRIORITY = 8; };\n"+
			"	TASK Task09 { PRIORITY = 9; };\n"+
			"	TASK Task10 { PRIORITY = 10; };\n"+
			"	TASK Task11 { PRIORITY = 11; };\n"+
			"	TASK Task12 { PRIORITY = 12; };\n"+
			"	TASK Task13 { PRIORITY = 13; };\n"+
			"	TASK Task14 { PRIORITY = 14; };\n"+
			"	TASK Task15 { PRIORITY = 15; };\n"+
			"	TASK Task16 { PRIORITY = 16; };\n"+
			"	TASK Task17 { PRIORITY = 17; };\n"+
			"	TASK Task18 { PRIORITY = 18; };\n"+
			"	TASK Task19 { PRIORITY = 19; };\n"+
			"	TASK Task20 { PRIORITY = 20; };\n"+
			"	TASK Task21 { PRIORITY = 21; };\n"+
			"	TASK Task22 { PRIORITY = 22; };\n"+
			"	TASK Task23 { PRIORITY = 23; };\n"+
			"	TASK Task24 { PRIORITY = 24; };\n"+
			"	TASK Task25 { PRIORITY = 25; };\n"+
			"	TASK Task26 { PRIORITY = 26; };\n"+
			"	TASK Task27 { PRIORITY = 27; };\n"+
			"	TASK Task28 { PRIORITY = 28; };\n"+
			"	TASK Task29 { PRIORITY = 29; };\n"+
			"	TASK Task30 { PRIORITY = 30; };\n"+
			"	TASK Task31 { PRIORITY = 31; };\n"+
			"	TASK Task32 { PRIORITY = 32; };\n"+
			"};\n";
	    boolean ok = false;
	    try {
	    	commonWriterTest(text, 1);
	    } catch (RuntimeException e) {
	    	ok = true;
	    }
	    assertTrue(ok);
	}
	
	@Test public void test32Priorities_BCC2_RX() {
	    final String text = "CPU test_application {\n"+
			"\n"+
			"	OS EE {\n"+
			"		EE_OPT = \"__ASSERT__\";\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\";\n"+
			"\n"+
			"\n"+
			"		CPU_DATA = CORTEX_RX {\n" +
			"			MODEL = R4;\n" +
			"			APP_SRC = \"code.c\";\n" +
			"			COMPILER_TYPE = CCS;\n" +
			"			MULTI_STACK = FALSE;\n" +
			"		};\n" +
			"		MCU_DATA = TI {\n" +
			"			MODEL = TMS570;\n" +
			"		};\n" +
			"\n"+
			"		STATUS = EXTENDED;\n"+
			"\n"+
			"		KERNEL_TYPE = BCC2;\n"+
			"	};\n"+
			"\n"+
			"	TASK Task01 { PRIORITY = 1; };\n"+
			"	TASK Task02 { PRIORITY = 2; };\n"+
			"	TASK Task03 { PRIORITY = 3; };\n"+
			"	TASK Task04 { PRIORITY = 4; };\n"+
			"	TASK Task05 { PRIORITY = 5; };\n"+
			"	TASK Task06 { PRIORITY = 6; };\n"+
			"	TASK Task07 { PRIORITY = 7; };\n"+
			"	TASK Task08 { PRIORITY = 8; };\n"+
			"};\n";
	    commonWriterTest(text, 1);
	}

	@Test public void test9Priorities_BCC2_RX() {
	    final String text = "CPU test_application {\n"+
			"\n"+
			"	OS EE {\n"+
			"		EE_OPT = \"__ASSERT__\";\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\";\n"+
			"\n"+
			"\n"+
			"		CPU_DATA = CORTEX_RX {\n" +
			"			MODEL = R4;\n" +
			"			APP_SRC = \"code.c\";\n" +
			"			COMPILER_TYPE = CCS;\n" +
			"			MULTI_STACK = FALSE;\n" +
			"		};\n" +
			"		MCU_DATA = TI {\n" +
			"			MODEL = TMS570;\n" +
			"		};\n" +
			"\n"+
			"		STATUS = EXTENDED;\n"+
			"\n"+
			"		KERNEL_TYPE = BCC2;\n"+
			"	};\n"+
			"\n"+
			"	TASK Task01 { PRIORITY = 1; };\n"+
			"	TASK Task02 { PRIORITY = 2; };\n"+
			"	TASK Task03 { PRIORITY = 3; };\n"+
			"	TASK Task04 { PRIORITY = 4; };\n"+
			"	TASK Task05 { PRIORITY = 5; };\n"+
			"	TASK Task06 { PRIORITY = 6; };\n"+
			"	TASK Task07 { PRIORITY = 7; };\n"+
			"	TASK Task08 { PRIORITY = 8; };\n"+
			"	TASK Task09 { PRIORITY = 9; };\n"+
			"};\n";
	    boolean ok = false;
	    try {
	    	commonWriterTest(text, 1);
	    } catch (RuntimeException e) {
	    	ok = true;
	    }
	    assertTrue(ok);
	}
	
	@Test public void test32Priorities_ECC1_RX() {
	    final String text = "CPU test_application {\n"+
			"\n"+
			"	OS EE {\n"+
			"		EE_OPT = \"__ASSERT__\";\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\";\n"+
			"\n"+
			"\n"+
			"		CPU_DATA = CORTEX_RX {\n" +
			"			MODEL = R4;\n" +
			"			APP_SRC = \"code.c\";\n" +
			"			COMPILER_TYPE = CCS;\n" +
			"			MULTI_STACK = FALSE;\n" +
			"		};\n" +
			"		MCU_DATA = TI {\n" +
			"			MODEL = TMS570;\n" +
			"		};\n" +
			"		STATUS = EXTENDED;\n"+
			"\n"+
			"		KERNEL_TYPE = ECC1;\n"+
			"	};\n"+
			"\n"+
			"	TASK Task01 { PRIORITY = 1; };\n"+
			"	TASK Task02 { PRIORITY = 2; };\n"+
			"	TASK Task03 { PRIORITY = 3; };\n"+
			"	TASK Task04 { PRIORITY = 4; };\n"+
			"	TASK Task05 { PRIORITY = 5; };\n"+
			"	TASK Task06 { PRIORITY = 6; };\n"+
			"	TASK Task07 { PRIORITY = 7; };\n"+
			"	TASK Task08 { PRIORITY = 8; };\n"+
			"	TASK Task09 { PRIORITY = 9; };\n"+
			"	TASK Task10 { PRIORITY = 10; };\n"+
			"	TASK Task11 { PRIORITY = 11; };\n"+
			"	TASK Task12 { PRIORITY = 12; };\n"+
			"	TASK Task13 { PRIORITY = 13; };\n"+
			"	TASK Task14 { PRIORITY = 14; };\n"+
			"	TASK Task15 { PRIORITY = 15; };\n"+
			"	TASK Task16 { PRIORITY = 16; };\n"+
			"	TASK Task17 { PRIORITY = 17; };\n"+
			"	TASK Task18 { PRIORITY = 18; };\n"+
			"	TASK Task19 { PRIORITY = 19; };\n"+
			"	TASK Task20 { PRIORITY = 20; };\n"+
			"	TASK Task21 { PRIORITY = 21; };\n"+
			"	TASK Task22 { PRIORITY = 22; };\n"+
			"	TASK Task23 { PRIORITY = 23; };\n"+
			"	TASK Task24 { PRIORITY = 24; };\n"+
			"	TASK Task25 { PRIORITY = 25; };\n"+
			"	TASK Task26 { PRIORITY = 26; };\n"+
			"	TASK Task27 { PRIORITY = 27; };\n"+
			"	TASK Task28 { PRIORITY = 28; };\n"+
			"	TASK Task29 { PRIORITY = 29; };\n"+
			"	TASK Task30 { PRIORITY = 30; };\n"+
			"	TASK Task31 { PRIORITY = 31; };\n"+
			"	TASK Task32 { PRIORITY = 32; };\n"+
			"};\n";
	    boolean ok = false;
	    try {
	    	commonWriterTest(text, 1);
	    } catch (RuntimeException e) {
	    	ok = true;
	    }
	    assertTrue(ok);
	}
	
	@Test public void test16Priorities_ECC2_RX() {
	    final String text = "CPU test_application {\n"+
			"\n"+
			"	OS EE {\n"+
			"		EE_OPT = \"__ASSERT__\";\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\";\n"+
			"\n"+
			"\n"+
			"		CPU_DATA = CORTEX_RX {\n" +
			"			MODEL = R4;\n" +
			"			APP_SRC = \"code.c\";\n" +
			"			COMPILER_TYPE = CCS;\n" +
			"			MULTI_STACK = FALSE;\n" +
			"		};\n" +
			"		MCU_DATA = TI {\n" +
			"			MODEL = TMS570;\n" +
			"		};\n" +
			"		STATUS = EXTENDED;\n"+
			"\n"+
			"		KERNEL_TYPE = ECC2;\n"+
			"	};\n"+
			"\n"+
			"	TASK Task01 { PRIORITY = 1; };\n"+
			"	TASK Task02 { PRIORITY = 2; };\n"+
			"	TASK Task03 { PRIORITY = 3; };\n"+
			"	TASK Task04 { PRIORITY = 4; };\n"+
			"	TASK Task05 { PRIORITY = 5; };\n"+
			"	TASK Task06 { PRIORITY = 6; };\n"+
			"	TASK Task07 { PRIORITY = 7; };\n"+
			"	TASK Task08 { PRIORITY = 8; };\n"+
			"	TASK Task09 { PRIORITY = 9; };\n"+
			"	TASK Task10 { PRIORITY = 10; };\n"+
			"	TASK Task11 { PRIORITY = 11; };\n"+
			"	TASK Task12 { PRIORITY = 12; };\n"+
			"	TASK Task13 { PRIORITY = 13; };\n"+
			"	TASK Task14 { PRIORITY = 14; };\n"+
			"	TASK Task15 { PRIORITY = 15; };\n"+
			"	TASK Task16 { PRIORITY = 16; };\n"+
			"};\n";
    	commonWriterTest(text, 1);
	}
	@Test public void test17PrioritiesECC2_RX() {
	    final String text = "CPU test_application {\n"+
			"\n"+
			"	OS EE {\n"+
			"		EE_OPT = \"__ASSERT__\";\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\";\n"+
			"\n"+
			"\n"+
			"		CPU_DATA = CORTEX_RX {\n" +
			"			MODEL = R4;\n" +
			"			APP_SRC = \"code.c\";\n" +
			"			COMPILER_TYPE = CCS;\n" +
			"			MULTI_STACK = FALSE;\n" +
			"		};\n" +
			"		MCU_DATA = TI {\n" +
			"			MODEL = TMS570;\n" +
			"		};\n" +
			"		STATUS = EXTENDED;\n"+
			"\n"+
			"		KERNEL_TYPE = ECC2;\n"+
			"	};\n"+
			"\n"+
			"	TASK Task01 { PRIORITY = 1; };\n"+
			"	TASK Task02 { PRIORITY = 2; };\n"+
			"	TASK Task03 { PRIORITY = 3; };\n"+
			"	TASK Task04 { PRIORITY = 4; };\n"+
			"	TASK Task05 { PRIORITY = 5; };\n"+
			"	TASK Task06 { PRIORITY = 6; };\n"+
			"	TASK Task07 { PRIORITY = 7; };\n"+
			"	TASK Task08 { PRIORITY = 8; };\n"+
			"	TASK Task09 { PRIORITY = 9; };\n"+
			"	TASK Task10 { PRIORITY = 10; };\n"+
			"	TASK Task11 { PRIORITY = 11; };\n"+
			"	TASK Task12 { PRIORITY = 12; };\n"+
			"	TASK Task13 { PRIORITY = 13; };\n"+
			"	TASK Task14 { PRIORITY = 14; };\n"+
			"	TASK Task15 { PRIORITY = 15; };\n"+
			"	TASK Task16 { PRIORITY = 16; };\n"+
			"	TASK Task17 { PRIORITY = 17; };\n"+
			"};\n";
	    boolean ok = false;
	    try {
	    	commonWriterTest(text, 1);
	    } catch (RuntimeException e) {
	    	ok = true;
	    }
	    assertTrue(ok);
	}

	@Test public void test32PrioritiesFP_RX() {
	    final String text = "CPU test_application {\n"+
			"\n"+
			"	OS EE {\n"+
			"		EE_OPT = \"__ASSERT__\";\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\";\n"+
			"\n"+
			"\n"+
			"		CPU_DATA = CORTEX_RX {\n" +
			"			MODEL = R4;\n" +
			"			APP_SRC = \"code.c\";\n" +
			"			COMPILER_TYPE = CCS;\n" +
			"			MULTI_STACK = FALSE;\n" +
			"		};\n" +
			"		MCU_DATA = TI {\n" +
			"			MODEL = TMS570;\n" +
			"		};\n" +
			"\n"+
			"		STATUS = EXTENDED;\n"+
			"\n"+
			"		KERNEL_TYPE = FP;\n"+
			"	};\n"+
			"\n"+
			"	TASK Task01 { PRIORITY = 1; };\n"+
			"	TASK Task02 { PRIORITY = 2; };\n"+
			"	TASK Task03 { PRIORITY = 3; };\n"+
			"	TASK Task04 { PRIORITY = 4; };\n"+
			"	TASK Task05 { PRIORITY = 5; };\n"+
			"	TASK Task06 { PRIORITY = 6; };\n"+
			"	TASK Task07 { PRIORITY = 7; };\n"+
			"	TASK Task08 { PRIORITY = 8; };\n"+
			"	TASK Task09 { PRIORITY = 9; };\n"+
			"	TASK Task10 { PRIORITY = 10; };\n"+
			"	TASK Task11 { PRIORITY = 11; };\n"+
			"	TASK Task12 { PRIORITY = 12; };\n"+
			"	TASK Task13 { PRIORITY = 13; };\n"+
			"	TASK Task14 { PRIORITY = 14; };\n"+
			"	TASK Task15 { PRIORITY = 15; };\n"+
			"	TASK Task16 { PRIORITY = 16; };\n"+
			"	TASK Task17 { PRIORITY = 17; };\n"+
			"	TASK Task18 { PRIORITY = 18; };\n"+
			"	TASK Task19 { PRIORITY = 19; };\n"+
			"	TASK Task20 { PRIORITY = 20; };\n"+
			"	TASK Task21 { PRIORITY = 21; };\n"+
			"	TASK Task22 { PRIORITY = 22; };\n"+
			"	TASK Task23 { PRIORITY = 23; };\n"+
			"	TASK Task24 { PRIORITY = 24; };\n"+
			"	TASK Task25 { PRIORITY = 25; };\n"+
			"	TASK Task26 { PRIORITY = 26; };\n"+
			"	TASK Task27 { PRIORITY = 27; };\n"+
			"	TASK Task28 { PRIORITY = 28; };\n"+
			"	TASK Task29 { PRIORITY = 29; };\n"+
			"	TASK Task30 { PRIORITY = 30; };\n"+
			"	TASK Task31 { PRIORITY = 31; };\n"+
			"	TASK Task32 { PRIORITY = 32; };\n"+
			"};\n";
		commonWriterTest(text, 1);
	}



	@Test public void test32Priorities_BCC1_MX() {
	    final String text = "CPU test_application {\n"+
			"\n"+
			"	OS EE {\n"+
			"		EE_OPT = \"__ASSERT__\";\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\";\n"+
			"\n"+
			"\n"+
			"        CPU_DATA = CORTEX_MX {\n" + 
			"			MODEL = M0;\n" +
			"			APP_SRC = \"code.c\";\n" +
			"			MULTI_STACK = FALSE;\n" + 
			"		};\n" + 
			"\n"+
			"		STATUS = EXTENDED;\n"+
			"\n"+
			"		KERNEL_TYPE = BCC1;\n"+
			"	};\n"+
			"\n"+
			"	TASK Task01 { PRIORITY = 1; };\n"+
			"	TASK Task02 { PRIORITY = 2; };\n"+
			"	TASK Task03 { PRIORITY = 3; };\n"+
			"	TASK Task04 { PRIORITY = 4; };\n"+
			"	TASK Task05 { PRIORITY = 5; };\n"+
			"	TASK Task06 { PRIORITY = 6; };\n"+
			"	TASK Task07 { PRIORITY = 7; };\n"+
			"	TASK Task08 { PRIORITY = 8; };\n"+
			"	TASK Task09 { PRIORITY = 9; };\n"+
			"	TASK Task10 { PRIORITY = 10; };\n"+
			"	TASK Task11 { PRIORITY = 11; };\n"+
			"	TASK Task12 { PRIORITY = 12; };\n"+
			"	TASK Task13 { PRIORITY = 13; };\n"+
			"	TASK Task14 { PRIORITY = 14; };\n"+
			"	TASK Task15 { PRIORITY = 15; };\n"+
			"	TASK Task16 { PRIORITY = 16; };\n"+
			"	TASK Task17 { PRIORITY = 17; };\n"+
			"	TASK Task18 { PRIORITY = 18; };\n"+
			"	TASK Task19 { PRIORITY = 19; };\n"+
			"	TASK Task20 { PRIORITY = 20; };\n"+
			"	TASK Task21 { PRIORITY = 21; };\n"+
			"	TASK Task22 { PRIORITY = 22; };\n"+
			"	TASK Task23 { PRIORITY = 23; };\n"+
			"	TASK Task24 { PRIORITY = 24; };\n"+
			"	TASK Task25 { PRIORITY = 25; };\n"+
			"	TASK Task26 { PRIORITY = 26; };\n"+
			"	TASK Task27 { PRIORITY = 27; };\n"+
			"	TASK Task28 { PRIORITY = 28; };\n"+
			"	TASK Task29 { PRIORITY = 29; };\n"+
			"	TASK Task30 { PRIORITY = 30; };\n"+
			"	TASK Task31 { PRIORITY = 31; };\n"+
			"	TASK Task32 { PRIORITY = 32; };\n"+
			"};\n";
    	commonWriterTest(text, 1);
	}
	
	@Test public void test32Priorities_BCC2_MX() {
	    final String text = "CPU test_application {\n"+
			"\n"+
			"	OS EE {\n"+
			"		EE_OPT = \"__ASSERT__\";\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\";\n"+
			"\n"+
			"\n"+
			"        CPU_DATA = CORTEX_MX {\n" + 
			"			MODEL = M0;\n" +
			"			APP_SRC = \"code.c\";\n" +
			"			MULTI_STACK = FALSE;\n" + 
			"		};\n" + 
			"\n"+
			"		STATUS = EXTENDED;\n"+
			"\n"+
			"		KERNEL_TYPE = BCC2;\n"+
			"	};\n"+
			"\n"+
			"	TASK Task01 { PRIORITY = 1; };\n"+
			"	TASK Task02 { PRIORITY = 2; };\n"+
			"	TASK Task03 { PRIORITY = 3; };\n"+
			"	TASK Task04 { PRIORITY = 4; };\n"+
			"	TASK Task05 { PRIORITY = 5; };\n"+
			"	TASK Task06 { PRIORITY = 6; };\n"+
			"	TASK Task07 { PRIORITY = 7; };\n"+
			"	TASK Task08 { PRIORITY = 8; };\n"+
			"};\n";
	    commonWriterTest(text, 1);
	}

	@Test public void test9Priorities_BCC2_MX() {
	    final String text = "CPU test_application {\n"+
			"\n"+
			"	OS EE {\n"+
			"		EE_OPT = \"__ASSERT__\";\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\";\n"+
			"\n"+
			"\n"+
			"        CPU_DATA = CORTEX_MX {\n" + 
			"			MODEL = M0;\n" +
			"			APP_SRC = \"code.c\";\n" +
			"			MULTI_STACK = FALSE;\n" + 
			"		};\n" + 
			"\n"+
			"		STATUS = EXTENDED;\n"+
			"\n"+
			"		KERNEL_TYPE = BCC2;\n"+
			"	};\n"+
			"\n"+
			"	TASK Task01 { PRIORITY = 1; };\n"+
			"	TASK Task02 { PRIORITY = 2; };\n"+
			"	TASK Task03 { PRIORITY = 3; };\n"+
			"	TASK Task04 { PRIORITY = 4; };\n"+
			"	TASK Task05 { PRIORITY = 5; };\n"+
			"	TASK Task06 { PRIORITY = 6; };\n"+
			"	TASK Task07 { PRIORITY = 7; };\n"+
			"	TASK Task08 { PRIORITY = 8; };\n"+
			"	TASK Task09 { PRIORITY = 9; };\n"+
			"};\n";
	    boolean ok = false;
	    try {
	    	commonWriterTest(text, 1);
	    } catch (RuntimeException e) {
	    	ok = true;
	    }
	    assertTrue(ok);
	}
	
	@Test public void test32Priorities_ECC1_MX() {
	    final String text = "CPU test_application {\n"+
			"\n"+
			"	OS EE {\n"+
			"		EE_OPT = \"__ASSERT__\";\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\";\n"+
			"\n"+
			"\n"+
			"        CPU_DATA = CORTEX_MX {\n" + 
			"			MODEL = M0;\n" +
			"			APP_SRC = \"code.c\";\n" +
			"			MULTI_STACK = FALSE;\n" + 
			"		};\n" + 
			"		STATUS = EXTENDED;\n"+
			"\n"+
			"		KERNEL_TYPE = ECC1;\n"+
			"	};\n"+
			"\n"+
			"	TASK Task01 { PRIORITY = 1; };\n"+
			"	TASK Task02 { PRIORITY = 2; };\n"+
			"	TASK Task03 { PRIORITY = 3; };\n"+
			"	TASK Task04 { PRIORITY = 4; };\n"+
			"	TASK Task05 { PRIORITY = 5; };\n"+
			"	TASK Task06 { PRIORITY = 6; };\n"+
			"	TASK Task07 { PRIORITY = 7; };\n"+
			"	TASK Task08 { PRIORITY = 8; };\n"+
			"	TASK Task09 { PRIORITY = 9; };\n"+
			"	TASK Task10 { PRIORITY = 10; };\n"+
			"	TASK Task11 { PRIORITY = 11; };\n"+
			"	TASK Task12 { PRIORITY = 12; };\n"+
			"	TASK Task13 { PRIORITY = 13; };\n"+
			"	TASK Task14 { PRIORITY = 14; };\n"+
			"	TASK Task15 { PRIORITY = 15; };\n"+
			"	TASK Task16 { PRIORITY = 16; };\n"+
			"	TASK Task17 { PRIORITY = 17; };\n"+
			"	TASK Task18 { PRIORITY = 18; };\n"+
			"	TASK Task19 { PRIORITY = 19; };\n"+
			"	TASK Task20 { PRIORITY = 20; };\n"+
			"	TASK Task21 { PRIORITY = 21; };\n"+
			"	TASK Task22 { PRIORITY = 22; };\n"+
			"	TASK Task23 { PRIORITY = 23; };\n"+
			"	TASK Task24 { PRIORITY = 24; };\n"+
			"	TASK Task25 { PRIORITY = 25; };\n"+
			"	TASK Task26 { PRIORITY = 26; };\n"+
			"	TASK Task27 { PRIORITY = 27; };\n"+
			"	TASK Task28 { PRIORITY = 28; };\n"+
			"	TASK Task29 { PRIORITY = 29; };\n"+
			"	TASK Task30 { PRIORITY = 30; };\n"+
			"	TASK Task31 { PRIORITY = 31; };\n"+
			"	TASK Task32 { PRIORITY = 32; };\n"+
			"};\n";
	    commonWriterTest(text, 1);
	}
	
	@Test public void test16Priorities_ECC2_MX() {
	    final String text = "CPU test_application {\n"+
			"\n"+
			"	OS EE {\n"+
			"		EE_OPT = \"__ASSERT__\";\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\";\n"+
			"\n"+
			"\n"+
			"        CPU_DATA = CORTEX_MX {\n" + 
			"			MODEL = M0;\n" +
			"			APP_SRC = \"code.c\";\n" +
			"			MULTI_STACK = FALSE;\n" + 
			"		};\n" + 
			"		STATUS = EXTENDED;\n"+
			"\n"+
			"		KERNEL_TYPE = ECC2;\n"+
			"	};\n"+
			"\n"+
			"	TASK Task01 { PRIORITY = 1; };\n"+
			"	TASK Task02 { PRIORITY = 2; };\n"+
			"	TASK Task03 { PRIORITY = 3; };\n"+
			"	TASK Task04 { PRIORITY = 4; };\n"+
			"	TASK Task05 { PRIORITY = 5; };\n"+
			"	TASK Task06 { PRIORITY = 6; };\n"+
			"	TASK Task07 { PRIORITY = 7; };\n"+
			"	TASK Task08 { PRIORITY = 8; };\n"+
			"	TASK Task09 { PRIORITY = 9; };\n"+
			"	TASK Task10 { PRIORITY = 10; };\n"+
			"	TASK Task11 { PRIORITY = 11; };\n"+
			"	TASK Task12 { PRIORITY = 12; };\n"+
			"	TASK Task13 { PRIORITY = 13; };\n"+
			"	TASK Task14 { PRIORITY = 14; };\n"+
			"	TASK Task15 { PRIORITY = 15; };\n"+
			"	TASK Task16 { PRIORITY = 16; };\n"+
			"};\n";
    	commonWriterTest(text, 1);
	}
	@Test public void test17PrioritiesECC2_MX() {
	    final String text = "CPU test_application {\n"+
			"\n"+
			"	OS EE {\n"+
			"		EE_OPT = \"__ASSERT__\";\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\";\n"+
			"\n"+
			"\n"+
			"        CPU_DATA = CORTEX_MX {\n" + 
			"			MODEL = M0;\n" +
			"			APP_SRC = \"code.c\";\n" +
			"			MULTI_STACK = FALSE;\n" + 
			"		};\n" + 
			"		STATUS = EXTENDED;\n"+
			"\n"+
			"		KERNEL_TYPE = ECC2;\n"+
			"	};\n"+
			"\n"+
			"	TASK Task01 { PRIORITY = 1; };\n"+
			"	TASK Task02 { PRIORITY = 2; };\n"+
			"	TASK Task03 { PRIORITY = 3; };\n"+
			"	TASK Task04 { PRIORITY = 4; };\n"+
			"	TASK Task05 { PRIORITY = 5; };\n"+
			"	TASK Task06 { PRIORITY = 6; };\n"+
			"	TASK Task07 { PRIORITY = 7; };\n"+
			"	TASK Task08 { PRIORITY = 8; };\n"+
			"	TASK Task09 { PRIORITY = 9; };\n"+
			"	TASK Task10 { PRIORITY = 10; };\n"+
			"	TASK Task11 { PRIORITY = 11; };\n"+
			"	TASK Task12 { PRIORITY = 12; };\n"+
			"	TASK Task13 { PRIORITY = 13; };\n"+
			"	TASK Task14 { PRIORITY = 14; };\n"+
			"	TASK Task15 { PRIORITY = 15; };\n"+
			"	TASK Task16 { PRIORITY = 16; };\n"+
			"	TASK Task17 { PRIORITY = 17; };\n"+
			"};\n";
	    boolean ok = false;
	    try {
	    	commonWriterTest(text, 1);
	    } catch (RuntimeException e) {
	    	ok = true;
	    }
	    assertTrue(ok);
	}

	@Test public void test32PrioritiesFP_MX() {
	    final String text = "CPU test_application {\n"+
			"\n"+
			"	OS EE {\n"+
			"		EE_OPT = \"__ASSERT__\";\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\";\n"+
			"\n"+
			"\n"+
			"        CPU_DATA = CORTEX_MX {\n" + 
			"			MODEL = M0;\n" +
			"			APP_SRC = \"code.c\";\n" +
			"			MULTI_STACK = FALSE;\n" + 
			"		};\n" + 
			"\n"+
			"		STATUS = EXTENDED;\n"+
			"\n"+
			"		KERNEL_TYPE = FP;\n"+
			"	};\n"+
			"\n"+
			"	TASK Task01 { PRIORITY = 1; };\n"+
			"	TASK Task02 { PRIORITY = 2; };\n"+
			"	TASK Task03 { PRIORITY = 3; };\n"+
			"	TASK Task04 { PRIORITY = 4; };\n"+
			"	TASK Task05 { PRIORITY = 5; };\n"+
			"	TASK Task06 { PRIORITY = 6; };\n"+
			"	TASK Task07 { PRIORITY = 7; };\n"+
			"	TASK Task08 { PRIORITY = 8; };\n"+
			"	TASK Task09 { PRIORITY = 9; };\n"+
			"	TASK Task10 { PRIORITY = 10; };\n"+
			"	TASK Task11 { PRIORITY = 11; };\n"+
			"	TASK Task12 { PRIORITY = 12; };\n"+
			"	TASK Task13 { PRIORITY = 13; };\n"+
			"	TASK Task14 { PRIORITY = 14; };\n"+
			"	TASK Task15 { PRIORITY = 15; };\n"+
			"	TASK Task16 { PRIORITY = 16; };\n"+
			"	TASK Task17 { PRIORITY = 17; };\n"+
			"	TASK Task18 { PRIORITY = 18; };\n"+
			"	TASK Task19 { PRIORITY = 19; };\n"+
			"	TASK Task20 { PRIORITY = 20; };\n"+
			"	TASK Task21 { PRIORITY = 21; };\n"+
			"	TASK Task22 { PRIORITY = 22; };\n"+
			"	TASK Task23 { PRIORITY = 23; };\n"+
			"	TASK Task24 { PRIORITY = 24; };\n"+
			"	TASK Task25 { PRIORITY = 25; };\n"+
			"	TASK Task26 { PRIORITY = 26; };\n"+
			"	TASK Task27 { PRIORITY = 27; };\n"+
			"	TASK Task28 { PRIORITY = 28; };\n"+
			"	TASK Task29 { PRIORITY = 29; };\n"+
			"	TASK Task30 { PRIORITY = 30; };\n"+
			"	TASK Task31 { PRIORITY = 31; };\n"+
			"	TASK Task32 { PRIORITY = 32; };\n"+
			"};\n";
		commonWriterTest(text, 1);
	}
}
