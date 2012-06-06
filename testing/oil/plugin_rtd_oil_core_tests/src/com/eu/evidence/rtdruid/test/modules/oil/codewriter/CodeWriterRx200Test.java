package com.eu.evidence.rtdruid.test.modules.oil.codewriter;

import org.junit.Test;



public class CodeWriterRx200Test extends AbstractCodeWriterTest {
	
	@Test
	public void testPorting4() {
	    final String text = "CPU mySystem {\n" +
	    		"\n" +
	    		"	OS myOs {\n" +
	    		"\n" +
	    		"		EE_OPT = \"DEBUG\";\n" +
	    		"		EE_OPT = \"__ASSERT__\";\n" +
	    		"\n" +
	    		"		CPU_DATA = RX200 {\n" +
	    		"			APP_SRC = \"code.c\";\n" +
	    		"			COMPILER_TYPE = CCRX; \n" +
	    		"			MULTI_STACK = FALSE;\n" +
	    		"		};\n" +
	    		"\n" +
	    		"		MCU_DATA = RENESAS {\n" +
	    		"			MODEL = R5F5210x;\n" +
	    		"		};\n" +
	    		"\n" +
	    		"		EE_OPT = \"__USE_USER_LED__\";\n" +
	    		"		EE_OPT = \"__USE_SYSTICK__\";\n" +
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
	    		"	TASK Task1 {\n" +
	    		"		PRIORITY = 0x02;   /* High priority */\n" +
	    		"		STACK = SHARED;\n" +
	    		"		SCHEDULE = FULL;\n" +
	    		"	};\n" +
	    		"\n" +
	    		"	TASK Task2 {\n" +
	    		"		PRIORITY = 0x01;   /* Low priority */\n" +
	    		"		STACK = SHARED;\n" +
	    		"		SCHEDULE = FULL;\n" +
	    		"	};\n" +
	    		"\n" +
	    		"	ISR cmia0_handler {\n" +
	    		"		CATEGORY = 2;\n" +
	    		"		ENTRY = \"CMIA0\";\n" +
	    		"	};\n" +
	    		"\n" +
	    		"\n" +
	    		"};\n";
		commonWriterTest(text, 1);
	}
	
	@Test
	public void testStack1() {
	    final String text = "CPU mySystem {\n" +
	    		"\n" +
	    		"	OS myOs {\n" +
	    		"\n" +
	    		"		EE_OPT = \"DEBUG\";\n" +
	    		"		EE_OPT = \"__ASSERT__\";\n" +
	    		"\n" +
	    		"		CPU_DATA = RX200 {\n" +
	    		"			APP_SRC = \"code.c\";\n" +
	    		"			COMPILER_TYPE = CCRX; \n" +
				"			MULTI_STACK = TRUE {\n" +
				"				IRQ_STACK = TRUE {\n" +
				"					SYS_SIZE=512;\n" +
				"				};\n" +
				"			};\n" +
	    		"		};\n" +
	    		"\n" +
	    		"		MCU_DATA = RENESAS {\n" +
	    		"			MODEL = R5F5210x;\n" +
	    		"		};\n" +
	    		"\n" +
	    		"		EE_OPT = \"__USE_USER_LED__\";\n" +
	    		"		EE_OPT = \"__USE_SYSTICK__\";\n" +
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
	    		"	TASK Task1 {\n" +
	    		"		PRIORITY = 0x02;   /* High priority */\n" +
	    		"		STACK = SHARED;\n" +
	    		"		SCHEDULE = FULL;\n" +
	    		"	};\n" +
	    		"\n" +
	    		"	TASK Task2 {\n" +
	    		"		PRIORITY = 0x01;   /* Low priority */\n" +
				"		STACK = PRIVATE {\n" +
				"			SYS_SIZE = 512;\n" +
				"		};\n" +
	    		"		SCHEDULE = FULL;\n" +
	    		"	};\n" +
	    		"\n" +
	    		"	ISR cmia0_handler {\n" +
	    		"		CATEGORY = 2;\n" +
	    		"		ENTRY = \"CMIA0\";\n" +
	    		"	};\n" +
	    		"\n" +
	    		"\n" +
	    		"};\n";
		commonWriterTest(text, 1);
	}
}
