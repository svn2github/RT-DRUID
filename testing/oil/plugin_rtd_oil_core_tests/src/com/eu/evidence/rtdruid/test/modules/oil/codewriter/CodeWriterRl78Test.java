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
				"			MODEL = R5F104LE;\n" +
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
				"			MODEL = R5F104LE;\n" +
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
	

	@Test
	public void testPortingMulti6_far_small() {
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
				"				MEMORY_MODEL = SMALL;\n" +
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
				"			MODEL = R5F104LE;\n" +
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
	public void testPortingMulti6_near_small() {
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
				"				MEMORY_MODEL = SMALL;\n" +
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
				"			MODEL = R5F104LE;\n" +
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
	
	
	
	@Test
	public void testMultIsr() {
	    final String text = 
			"CPU test_application {\n" +
			"\n" +
			"  OS EE {\n" +
			"    EE_OPT = \"__ASSERT__\";\n" +
			"    EE_OPT = \"DEBUG\";\n" +
			"\n" +
			"    STATUS = EXTENDED;\n" +
			"    STARTUPHOOK = FALSE;\n" +
			"    ERRORHOOK = FALSE;\n" +
			"    SHUTDOWNHOOK = FALSE;\n" +
			"    PRETASKHOOK = FALSE;\n" +
			"    POSTTASKHOOK = FALSE;\n" +
			"    USEGETSERVICEID = FALSE;\n" +
			"    USEPARAMETERACCESS = FALSE;\n" +
			"    USERESSCHEDULER = FALSE;\n" +
			"\n" +
			"		CPU_DATA = RL78 {\n" +
			"			APP_SRC = \"code.c\";\n" +
			"			CPU_CLOCK = 98.5;\n" +
			"			COMPILER_TYPE = CCRL {\n" +
			"				E2STUDIO = TRUE;\n" +
			"			};\n" +
			"			MULTI_STACK = TRUE {\n" +
			"        			IRQ_STACK = TRUE {\n" +
			"          				SYS_SIZE = 512;\n" +
			"        			};\n" +
			"      			};\n" +
			"			SYS_STACK_SIZE = 4096;\n" +
			"		};\n" +
			"		\n" +
			"\n" +
			"		MCU_DATA = R5F10XXX {\n" +
			"			MODEL = R5F104LE;\n" +
			"		};\n" +
			"\n" +
			"    KERNEL_TYPE = BCC1;\n" +
			"\n" +
			"    ORTI_SECTIONS = ALL;\n" +
			"  };\n" +
			"\n" +
			"  TASK time_slow {\n" +
			"    PRIORITY = 10;\n" +
			"    ACTIVATION = 1;\n" +
			"    SCHEDULE = FULL;\n" +
			"    AUTOSTART = FALSE;\n" +
			"    STACK = SHARED;\n" +
			"  };\n" +
			"\n" +
			"  COUNTER system_timer {\n" +
			"    MINCYCLE = 1;\n" +
			"    MAXALLOWEDVALUE = 2147483647;\n" +
			"    TICKSPERBASE = 1;\n" +
			"    TYPE = HARDWARE {\n" +
			"      DEVICE = \"DECREMENTER\";\n" +
			"      SYSTEM_TIMER = TRUE;\n" +
			"      PRIORITY = \"10\";\n" +
			"    };\n" +
			"    SECONDSPERTICK = 0.001;\n" +
//			"    CPU_ID = \"default_cpu\";\n" +
			"  };\n" +
			"  ALARM OSAlarm_2400ms {\n" +
			"      COUNTER = system_timer;\n" +
			"      ACTION = ACTIVATETASK {\n" +
			"          TASK = time_slow;\n" +
			"      };\n" +
			"      AUTOSTART = TRUE {\n" +
			"          ALARMTIME = 2400;\n" +
			"          CYCLETIME = 2400;\n" +
			"      };\n" +
			"  };\n" +
			"\n" +
			"  ISR isr1 {\n" +
			"      CATEGORY = 2;\n" +
			"      ENTRY = \"INT_01\";\n" +
			"      PRIORITY = \"1\";\n" +
			"  };\n" +
			"  ISR isr2 {\n" +
			"      CATEGORY = 2;\n" +
			"      ENTRY = \"INT_02\";\n" +
			"      PRIORITY = \"1\";\n" +
			"  };\n" +
			"  ISR isr3 {\n" +
			"      CATEGORY = 2;\n" +
			"      ENTRY = \"INT_03\";\n" +
			"      PRIORITY = \"120\";\n" +
			"  };\n" +
			"  ISR isr4 {\n" +
			"      CATEGORY = 2;\n" +
			"      ENTRY = \"INT_04\";\n" +
			"      PRIORITY = \"10\";\n" +
			"  };\n" +
			"  ISR isr5 {\n" +
			"      CATEGORY = 2;\n" +
			"      ENTRY = \"INT_05\";\n" +
			"      PRIORITY = \"102\";\n" +
			"  };\n" +			
			"};";
		commonWriterTest(text, 1);
	}
	
	@Test
	public void testSystemTimer1() {
	    final String text = 
			"CPU test_application {\n" +
			"\n" +
			"  OS EE {\n" +
			"		CPU_DATA = RL78 {\n" +
			"			CPU_CLOCK = 98.5;\n" +
			"			MULTI_STACK = FALSE;\n" +
			"		};\n" +
			"		MCU_DATA = R5F10XXX {\n" +
			"			MODEL = R5F104LE;\n" +
			"		};\n" +
			"    KERNEL_TYPE = BCC1;\n" +
			"\n" +
			"    ORTI_SECTIONS = ALL;\n" +
			"  };\n" +
			"\n" +
			"  COUNTER system_timer {\n" +
			"    MINCYCLE = 1;\n" +
			"    MAXALLOWEDVALUE = 2147483647;\n" +
			"    TICKSPERBASE = 1;\n" +
			"    TYPE = HARDWARE {\n" +
			"      DEVICE = \"TRJMR0_FCK\";\n" +
			"      SYSTEM_TIMER = TRUE;\n" +
			"      PRIORITY = \"10\";\n" +
			"    };\n" +
			"    SECONDSPERTICK = 0.001;\n" +
			"  };\n" +
			"};";
		commonWriterTest(text, 1);
	}
	
	@Test
	public void testSystemTimer2() {
	    final String text = 
			"CPU test_application {\n" +
			"\n" +
			"  OS EE {\n" +
			"		CPU_DATA = RL78 {\n" +
			"			CPU_CLOCK = 98.5;\n" +
			"			MULTI_STACK = FALSE;\n" +
			"		};\n" +
			"		MCU_DATA = R5F10XXX {\n" +
			"			MODEL = R5F104LE;\n" +
			"		};\n" +
			"    KERNEL_TYPE = BCC1;\n" +
			"\n" +
			"    ORTI_SECTIONS = ALL;\n" +
			"  };\n" +
			"\n" +
			"  COUNTER system_timer {\n" +
			"    MINCYCLE = 1;\n" +
			"    MAXALLOWEDVALUE = 2147483647;\n" +
			"    TICKSPERBASE = 1;\n" +
			"    TYPE = HARDWARE {\n" +
			"      DEVICE = \"TRJMR0_FCK8\";\n" +
			"      SYSTEM_TIMER = TRUE;\n" +
			"      PRIORITY = \"10\";\n" +
			"    };\n" +
			"    SECONDSPERTICK = 0.001;\n" +
			"  };\n" +
			"};";
		commonWriterTest(text, 1);
	}
	
	@Test
	public void testSystemTimer3() {
	    final String text = 
			"CPU test_application {\n" +
			"\n" +
			"  OS EE {\n" +
			"		CPU_DATA = RL78 {\n" +
			"			CPU_CLOCK = 98.5;\n" +
			"			MULTI_STACK = FALSE;\n" +
			"		};\n" +
			"		MCU_DATA = R5F10XXX {\n" +
			"			MODEL = R5F104LE;\n" +
			"		};\n" +
			"    KERNEL_TYPE = BCC1;\n" +
			"\n" +
			"    ORTI_SECTIONS = ALL;\n" +
			"  };\n" +
			"\n" +
			"  COUNTER system_timer {\n" +
			"    MINCYCLE = 1;\n" +
			"    MAXALLOWEDVALUE = 2147483647;\n" +
			"    TICKSPERBASE = 1;\n" +
			"    TYPE = HARDWARE {\n" +
			"      DEVICE = \"TRJMR0_FCK2\";\n" +
			"      SYSTEM_TIMER = TRUE;\n" +
			"      PRIORITY = \"10\";\n" +
			"    };\n" +
			"    SECONDSPERTICK = 0.001;\n" +
			"  };\n" +
			"};";
		commonWriterTest(text, 1);
	}
	
	@Test
	public void testSystemTimer4() {
	    final String text = 
			"CPU test_application {\n" +
			"\n" +
			"  OS EE {\n" +
			"		CPU_DATA = RL78 {\n" +
			"			CPU_CLOCK = 98.5;\n" +
			"			MULTI_STACK = FALSE;\n" +
			"		};\n" +
			"		MCU_DATA = R5F10XXX {\n" +
			"			MODEL = R5F104LE;\n" +
			"		};\n" +
			"    KERNEL_TYPE = BCC1;\n" +
			"\n" +
			"    ORTI_SECTIONS = ALL;\n" +
			"  };\n" +
			"\n" +
			"  COUNTER system_timer {\n" +
			"    MINCYCLE = 1;\n" +
			"    MAXALLOWEDVALUE = 2147483647;\n" +
			"    TICKSPERBASE = 1;\n" +
			"    TYPE = HARDWARE {\n" +
			"      DEVICE = \"TRJMR0_FIL\";\n" +
			"      SYSTEM_TIMER = TRUE;\n" +
			"      PRIORITY = \"10\";\n" +
			"    };\n" +
			"    SECONDSPERTICK = 0.001;\n" +
			"  };\n" +
			"};";
		commonWriterTest(text, 1);
	}
	
	@Test
	public void testSystemTimer5() {
	    final String text = 
			"CPU test_application {\n" +
			"\n" +
			"  OS EE {\n" +
			"		CPU_DATA = RL78 {\n" +
			"			CPU_CLOCK = 98.5;\n" +
			"			MULTI_STACK = FALSE;\n" +
			"		};\n" +
			"		MCU_DATA = R5F10XXX {\n" +
			"			MODEL = R5F104LE;\n" +
			"		};\n" +
			"    KERNEL_TYPE = BCC1;\n" +
			"\n" +
			"    ORTI_SECTIONS = ALL;\n" +
			"  };\n" +
			"\n" +
			"  COUNTER system_timer {\n" +
			"    MINCYCLE = 1;\n" +
			"    MAXALLOWEDVALUE = 2147483647;\n" +
			"    TICKSPERBASE = 1;\n" +
			"    TYPE = HARDWARE {\n" +
			"      DEVICE = \"TRJMR0_FSUB\";\n" +
			"      SYSTEM_TIMER = TRUE;\n" +
			"      PRIORITY = \"10\";\n" +
			"    };\n" +
			"    SECONDSPERTICK = 0.001;\n" +
			"  };\n" +
			"};";
		commonWriterTest(text, 1);
	}
	
	@Test
	public void testSystemTimer6a() {
	    final String text = 
			"CPU test_application {\n" +
			"\n" +
			"  OS EE {\n" +
			"		CPU_DATA = RL78 {\n" +
			"			CPU_CLOCK = 98.5;\n" +
			"			MULTI_STACK = FALSE;\n" +
			"		};\n" +
			"		MCU_DATA = R5F10XXX {\n" +
			"			MODEL = R5F104LE;\n" +
			"		};\n" +
			"    KERNEL_TYPE = BCC1;\n" +
			"\n" +
			"    ORTI_SECTIONS = ALL;\n" +
			"  };\n" +
			"\n" +
			"  COUNTER system_timer {\n" +
			"    MINCYCLE = 1;\n" +
			"    MAXALLOWEDVALUE = 2147483647;\n" +
			"    TICKSPERBASE = 1;\n" +
			"    TYPE = HARDWARE {\n" +
			"      DEVICE = \"TRJMR0_FSL\";\n" +
			"      SYSTEM_TIMER = TRUE;\n" +
			"      PRIORITY = \"10\";\n" +
			"    };\n" +
			"    SECONDSPERTICK = 0.001;\n" +
			"  };\n" +
			"};";
		commonWriterTest(text, 1);
	}
	@Test
	public void testSystemTimer6b() {
	    final String text = 
			"CPU test_application {\n" +
			"\n" +
			"  OS EE {\n" +
			"		CPU_DATA = RL78 {\n" +
			"			CPU_CLOCK = 98.5;\n" +
			"			MULTI_STACK = FALSE;\n" +
			"		};\n" +
			"		MCU_DATA = R5F10XXX {\n" +
			"			MODEL = R5F10BMG;\n" +
			"		};\n" +
			"    KERNEL_TYPE = BCC1;\n" +
			"\n" +
			"    ORTI_SECTIONS = ALL;\n" +
			"  };\n" +
			"\n" +
			"  COUNTER system_timer {\n" +
			"    MINCYCLE = 1;\n" +
			"    MAXALLOWEDVALUE = 2147483647;\n" +
			"    TICKSPERBASE = 1;\n" +
			"    TYPE = HARDWARE {\n" +
			"      DEVICE = \"TRJMR0_FSL\";\n" +
			"      SYSTEM_TIMER = TRUE;\n" +
			"      PRIORITY = \"10\";\n" +
			"    };\n" +
			"    SECONDSPERTICK = 0.001;\n" +
			"  };\n" +
			"};";
		commonWriterTest(text, 1);
	}
	@Test
	public void testSystemTimer6c() {
	    final String text = 
			"CPU test_application {\n" +
			"\n" +
			"  OS EE {\n" +
			"		CPU_DATA = RL78 {\n" +
			"			CPU_CLOCK = 98.5;\n" +
			"			MULTI_STACK = FALSE;\n" +
			"		};\n" +
			"		MCU_DATA = R5F10XXX {\n" +
			"			MODEL = R5F10PPJ;\n" +
			"		};\n" +
			"    KERNEL_TYPE = BCC1;\n" +
			"\n" +
			"    ORTI_SECTIONS = ALL;\n" +
			"  };\n" +
			"\n" +
			"  COUNTER system_timer {\n" +
			"    MINCYCLE = 1;\n" +
			"    MAXALLOWEDVALUE = 2147483647;\n" +
			"    TICKSPERBASE = 1;\n" +
			"    TYPE = HARDWARE {\n" +
			"      DEVICE = \"TRJMR0_FSL\";\n" +
			"      SYSTEM_TIMER = TRUE;\n" +
			"      PRIORITY = \"10\";\n" +
			"    };\n" +
			"    SECONDSPERTICK = 0.001;\n" +
			"  };\n" +
			"};";
		commonWriterTest(text, 1);
	}
	
	@Test
	public void testSystemTimer6d() {
	    final String text = 
			"CPU test_application {\n" +
			"\n" +
			"  OS EE {\n" +
			"		CPU_DATA = RL78 {\n" +
			"			CPU_CLOCK = 98.5;\n" +
			"			MULTI_STACK = FALSE;\n" +
			"		};\n" +
			"		MCU_DATA = R5F10XXX {\n" +
			"			MODEL = R5F10PLG;\n" +
			"		};\n" +
			"    KERNEL_TYPE = BCC1;\n" +
			"\n" +
			"    ORTI_SECTIONS = ALL;\n" +
			"  };\n" +
			"\n" +
			"  COUNTER system_timer {\n" +
			"    MINCYCLE = 1;\n" +
			"    MAXALLOWEDVALUE = 2147483647;\n" +
			"    TICKSPERBASE = 1;\n" +
			"    TYPE = HARDWARE {\n" +
			"      DEVICE = \"TRJMR0_FSL\";\n" +
			"      SYSTEM_TIMER = TRUE;\n" +
			"      PRIORITY = \"10\";\n" +
			"    };\n" +
			"    SECONDSPERTICK = 0.001;\n" +
			"  };\n" +
			"};";
		commonWriterTest(text, 1);
	}
	
	@Test
	public void testSystemTimer6e() {
	    final String text = 
			"CPU test_application {\n" +
			"\n" +
			"  OS EE {\n" +
			"		CPU_DATA = RL78 {\n" +
			"			CPU_CLOCK = 98.5;\n" +
			"			MULTI_STACK = FALSE;\n" +
			"		};\n" +
			"		MCU_DATA = R5F10XXX {\n" +
			"			MODEL = R5F10AGF;\n" +
			"		};\n" +
			"    KERNEL_TYPE = BCC1;\n" +
			"\n" +
			"    ORTI_SECTIONS = ALL;\n" +
			"  };\n" +
			"\n" +
			"  COUNTER system_timer {\n" +
			"    MINCYCLE = 1;\n" +
			"    MAXALLOWEDVALUE = 2147483647;\n" +
			"    TICKSPERBASE = 1;\n" +
			"    TYPE = HARDWARE {\n" +
			"      DEVICE = \"TRJMR0_FSL\";\n" +
			"      SYSTEM_TIMER = TRUE;\n" +
			"      PRIORITY = \"10\";\n" +
			"    };\n" +
			"    SECONDSPERTICK = 0.001;\n" +
			"  };\n" +
			"};";
		commonWriterTest(text, 1);
	}
	

	@Test
	public void testSystemTimer6f() {
	    final String text = 
			"CPU test_application {\n" +
			"\n" +
			"  OS EE {\n" +
			"		CPU_DATA = RL78 {\n" +
			"			CPU_CLOCK = 98.5;\n" +
			"			MULTI_STACK = FALSE;\n" +
			"		};\n" +
			"		MCU_DATA = R5F10XXX {\n" +
			"			MODEL = R5F10PLJ;\n" +
			"		};\n" +
			"    KERNEL_TYPE = BCC1;\n" +
			"\n" +
			"    ORTI_SECTIONS = ALL;\n" +
			"  };\n" +
			"\n" +
			"  COUNTER system_timer {\n" +
			"    MINCYCLE = 1;\n" +
			"    MAXALLOWEDVALUE = 2147483647;\n" +
			"    TICKSPERBASE = 1;\n" +
			"    TYPE = HARDWARE {\n" +
			"      DEVICE = \"TRJMR0_FSL\";\n" +
			"      SYSTEM_TIMER = TRUE;\n" +
			"      PRIORITY = \"10\";\n" +
			"    };\n" +
			"    SECONDSPERTICK = 0.001;\n" +
			"  };\n" +
			"};";
		commonWriterTest(text, 1);
	}
}
