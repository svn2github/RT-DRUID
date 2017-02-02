package com.eu.evidence.rtdruid.test.modules.oil.codewriter;

import org.junit.Test;



public class CodeWriterRl78Test extends AbstractCodeWriterTest {
	
	@Test
	public void testPortingMulti6_far() {
	    final String text = "CPU mySystem {\n" +
				"\n" +
				"	OS myOs {\n" +
				"\n" +
				"		EE_OPT = \"DEBUG\";\n" +
				"		EE_OPT = \"__ASSERT__\";\n" +
				"		EE_OPT = \"__SEM__\";\n" +
				"\n" +
				"		EE_OPT = \"EE_GEN_PREPROC_FILE\";\n" +
				"		EE_OPT = \"EE_GEN_ASM_FILE\";\n" +
				"		EE_OPT = \"EE_CHECK_MISRA\";\n" +
				"\n" +
				"		CFLAGS = \"\";\n" +
				"		LDFLAGS = \"-user_opt_byte=60FFE8 -ocdbg=84\";\n" +
				"		LDFLAGS = \"-debug_monitor=FE00-FFFF\";\n" +
				"		LDFLAGS = \"-security_id=00000000000000000000\";\n" +
				"\n" +
				"		CPU_DATA = RL78 {\n" +
				"			APP_SRC = \"main.c\";\n" +
				"			COMPILER_TYPE = CCRL {\n" +
				"				E2STUDIO = TRUE;\n" +
				"				MEMORY_MODEL = MEDIUM;\n" +
				"				FAR_DATA = TRUE;\n" +
				"			};\n" +
				"			MULTI_STACK = TRUE {\n" +
				"				IRQ_STACK = TRUE {\n" +
				"					SYS_SIZE = 256;\n" +
				"				};\n" +
				"			};\n" +
				"			SYS_STACK_SIZE = 4096;\n" +
				"		};\n" +
				"\n" +
				"		MCU_DATA = R5F10XXX {\n" +
				"			MODEL = R5F5104LE;\n" +
				"		};\n" +
				"\n" +
				"		KERNEL_TYPE = FP {\n" +
				"			NESTED_IRQ = TRUE;\n" +
				"		};\n" +
				"\n" +
				"		USERESSCHEDULER = FALSE;\n" +
				"\n" +
				"	};\n" +
				"\n" +
				"	TASK Task1 {\n" +
				"		PRIORITY = 0x01;\n" +
				"		AUTOSTART = FALSE;\n" +
				"		STACK = PRIVATE {\n" +
				"			SYS_SIZE = 256;\n" +
				"		};\n" +
				"		ACTIVATION = 1;	\n" +
				"		SCHEDULE = FULL;\n" +
				"	};\n" +
				"\n" +
				"	TASK Task2 {\n" +
				"		PRIORITY = 0x02;\n" +
				"		AUTOSTART = FALSE;\n" +
				"		STACK = PRIVATE {\n" +
				"			SYS_SIZE = 256;\n" +
				"		};\n" +
				"		ACTIVATION = 1;	\n" +
				"		SCHEDULE = FULL;\n" +
				"	};\n" +
				"};";
		commonWriterTest(text, 1);
	}
	@Test
	public void testPortingMulti6_near() {
	    final String text = "CPU mySystem {\n" +
				"\n" +
				"	OS myOs {\n" +
				"\n" +
				"		EE_OPT = \"DEBUG\";\n" +
				"		EE_OPT = \"__ASSERT__\";\n" +
				"		EE_OPT = \"__SEM__\";\n" +
				"\n" +
				"		EE_OPT = \"EE_GEN_PREPROC_FILE\";\n" +
				"		EE_OPT = \"EE_GEN_ASM_FILE\";\n" +
				"		EE_OPT = \"EE_CHECK_MISRA\";\n" +
				"\n" +
				"		CFLAGS = \"\";\n" +
				"		LDFLAGS = \"-user_opt_byte=60FFE8 -ocdbg=84\";\n" +
				"		LDFLAGS = \"-debug_monitor=FE00-FFFF\";\n" +
				"		LDFLAGS = \"-security_id=00000000000000000000\";\n" +
				"\n" +
				"		CPU_DATA = RL78 {\n" +
				"			APP_SRC = \"main.c\";\n" +
				"			COMPILER_TYPE = CCRL {\n" +
				"				E2STUDIO = TRUE;\n" +
				"				MEMORY_MODEL = MEDIUM;\n" +
//				"				FAR_DATA = FALSE;\n" +
				"			};\n" +
				"			MULTI_STACK = TRUE {\n" +
				"				IRQ_STACK = TRUE {\n" +
				"					SYS_SIZE = 128;\n" +
				"				};\n" +
				"			};\n" +
				"			SYS_STACK_SIZE = 4096;\n" +
				"		};\n" +
				"\n" +
				"		MCU_DATA = R5F10XXX {\n" +
				"			MODEL = R5F5104LE;\n" +
				"		};\n" +
				"\n" +
				"		KERNEL_TYPE = FP {\n" +
				"			NESTED_IRQ = TRUE;\n" +
				"		};\n" +
				"\n" +
				"		USERESSCHEDULER = FALSE;\n" +
				"\n" +
				"	};\n" +
				"\n" +
				"	TASK Task1 {\n" +
				"		PRIORITY = 0x01;\n" +
				"		AUTOSTART = FALSE;\n" +
				"		STACK = PRIVATE {\n" +
				"			SYS_SIZE = 128;\n" +
				"		};\n" +
				"		ACTIVATION = 1;	\n" +
				"		SCHEDULE = FULL;\n" +
				"	};\n" +
				"\n" +
				"	TASK Task2 {\n" +
				"		PRIORITY = 0x02;\n" +
				"		AUTOSTART = FALSE;\n" +
				"		STACK = PRIVATE {\n" +
				"			SYS_SIZE = 128;\n" +
				"		};\n" +
				"		ACTIVATION = 1;	\n" +
				"		SCHEDULE = FULL;\n" +
				"	};\n" +
				"};";
		commonWriterTest(text, 1);
	}
}
