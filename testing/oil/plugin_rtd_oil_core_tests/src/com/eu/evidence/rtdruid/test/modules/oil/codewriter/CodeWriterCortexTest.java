package com.eu.evidence.rtdruid.test.modules.oil.codewriter;

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

}
