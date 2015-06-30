package com.eu.evidence.rtdruid.test.modules.oil.codewriter;

import static org.junit.Assert.assertTrue;

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

	@Test public void testTaskTimingProtection() {
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
				"				RESOURCE = res1;\n" + 
				"		TIMING_PROTECTION = TRUE {\n" +
				"			MAXALLINTERRUPTLOCKTIME = 1.0;" +
				"			EXECUTIONBUDGET = 2.0;" +
				"			MAXOSINTERRUPTLOCKTIME = 3.0;" +
				"			TIMEFRAME = 4.0;" +
				"	       RESOURCE = RESOURCELOCK {\n" + 
				"				RESOURCELOCKTIME = 5.0;\n" + 
				"				RESOURCE = res1;\n" + 
				"			};\n" + 				
				"		};\n" +
				"    };\n" + 
				"    TASK Task1 {\n" + 
				"        PRIORITY = 3;\n" + 
				"        ACTIVATION = 4;\n" + 
				"		 STACK = SHARED;\n" + 
				"        SCHEDULE = FULL;\n" + 
				"				RESOURCE = res1;\n" + 
				"				RESOURCE = res2;\n" + 
				"				RESOURCE = res3;\n" + 
				"		TIMING_PROTECTION = TRUE {\n" +
				"			MAXALLINTERRUPTLOCKTIME = 1.0;" +
				"			EXECUTIONBUDGET = 2.0;" +
				"			MAXOSINTERRUPTLOCKTIME = 3.0;" +
				"			TIMEFRAME = 4.0;" +
				"	       RESOURCE = RESOURCELOCK {\n" + 
				"				RESOURCELOCKTIME = 5.0;\n" + 
				"				RESOURCE = res1;\n" + 
				"			};\n" + 				
				"	       RESOURCE = RESOURCELOCK {\n" + 
				"				RESOURCELOCKTIME = 6.0;\n" + 
				"				RESOURCE = res2;\n" + 
				"			};\n" + 				
				"	       RESOURCE = RESOURCELOCK {\n" + 
				"				RESOURCELOCKTIME = 7.0;\n" + 
				"				RESOURCE = res3;\n" + 
				"			};\n" + 				
				"		};\n" +
				"    };\n" + 
				"	ISR irq5_isr1 {\n" +
				"		CATEGORY = 1;" +
				"		LEVEL = \"5\";\n" +
				"		HANDLER = \"isr1\";	// IRQ handler\n" +
				"	};\n" +
				"	ISR trap_segfault {\n" +
				"		CATEGORY = 3;" +
				"		LEVEL = \"1\";\n" +
	  			"		HANDLER = \"segfault\";	// Trap handler\n" +
				"		TIMING_PROTECTION = FALSE;\n" +
				"	};\n" +
				"	ISR trap_syscall {\n" +
				"		CATEGORY = 3;" +
				"		LEVEL = \"6\";\n" +
				"		HANDLER = \"syscall\";	// Trap handler\n" +
				"	};\n" +
				"    RESOURCE res1 { RESOURCEPROPERTY = STANDARD; };\n" + 
				"    RESOURCE res2 { RESOURCEPROPERTY = STANDARD; };\n" + 
				"    RESOURCE res3 { RESOURCEPROPERTY = STANDARD; };\n" + 
				"};\n";
		commonWriterTest(text, 1);
	}
	
	@Test public void testIsrTimingProtection() {
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
				"		TIMING_PROTECTION = TRUE {\n" +
				"			MAXALLINTERRUPTLOCKTIME = 1.0;" +
				"			EXECUTIONTIME = 2.0;" +
				"			MAXOSINTERRUPTLOCKTIME = 3.0;" +
				"			TIMEFRAME = 4.0;" +
				"	       RESOURCE = LOCKINGTIME {\n" + 
				"				MAXRESOURCELOCKTIME = 5.0;\n" + 
				"				RESOURCE = res1;\n" + 
				"			};\n" + 				
				"		};\n" +
				"	};\n" +
				"	ISR irq5_isr1 {\n" +
				"		CATEGORY = 1;" +
				"		LEVEL = \"5\";\n" +
				"		HANDLER = \"isr1\";	// IRQ handler\n" +
				"		TIMING_PROTECTION = TRUE {\n" +
				"			MAXALLINTERRUPTLOCKTIME = 1.0;" +
				"			EXECUTIONTIME = 2.0;" +
				"			MAXOSINTERRUPTLOCKTIME = 3.0;" +
				"			TIMEFRAME = 4.0;" +
				"	       RESOURCE = LOCKINGTIME {\n" + 
				"				MAXRESOURCELOCKTIME = 5.0;\n" + 
				"				RESOURCE = res1;\n" + 
				"			};\n" + 				
				"	       RESOURCE = LOCKINGTIME {\n" + 
				"				MAXRESOURCELOCKTIME = 6.0;\n" + 
				"				RESOURCE = res2;\n" + 
				"			};\n" + 				
				"	       RESOURCE = LOCKINGTIME {\n" + 
				"				MAXRESOURCELOCKTIME = 7.0;\n" + 
				"				RESOURCE = res3;\n" + 
				"			};\n" + 				
				"		};\n" +
				"	};\n" +
				"	ISR trap_segfault {\n" +
				"		CATEGORY = 3;" +
				"		LEVEL = \"1\";\n" +
	  			"		HANDLER = \"segfault\";	// Trap handler\n" +
				"		TIMING_PROTECTION = FALSE;\n" +
				"	};\n" +
				"	ISR trap_syscall {\n" +
				"		CATEGORY = 3;" +
				"		LEVEL = \"6\";\n" +
				"		HANDLER = \"syscall\";	// Trap handler\n" +
				"	};\n" +
				"    RESOURCE res1 { RESOURCEPROPERTY = STANDARD; };\n" + 
				"    RESOURCE res2 { RESOURCEPROPERTY = STANDARD; };\n" + 
				"    RESOURCE res3 { RESOURCEPROPERTY = STANDARD; };\n" + 
				"};\n";
		commonWriterTest(text, 1);
	}
	
	@Test public void testTaskTimingProtection_sc1() {
	    final String text =
				"CPU mySystem {\n" + 
				"	OS myOs {\n" +
				"		EE_OPT = \"DEBUG\";" + 
				"		EE_OPT = \"VERBOSE\";" + 
				"       STATUS = EXTENDED;\n" + 
				"       USERESSCHEDULER = FALSE;\n" + 
				"       SCALABILITYCLASS = SC1;\n" + 
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
				"				RESOURCE = res1;\n" + 
				"		TIMING_PROTECTION = TRUE {\n" +
				"			MAXALLINTERRUPTLOCKTIME = 1.0;" +
				"			EXECUTIONBUDGET = 2.0;" +
				"			MAXOSINTERRUPTLOCKTIME = 3.0;" +
				"			TIMEFRAME = 4.0;" +
				"	       RESOURCE = RESOURCELOCK {\n" + 
				"				RESOURCELOCKTIME = 5.0;\n" + 
				"				RESOURCE = res1;\n" + 
				"			};\n" + 				
				"		};\n" +
				"    };\n" + 
				"    TASK Task1 {\n" + 
				"        PRIORITY = 3;\n" + 
				"        ACTIVATION = 4;\n" + 
				"		 STACK = SHARED;\n" + 
				"        SCHEDULE = FULL;\n" + 
				"				RESOURCE = res1;\n" + 
				"				RESOURCE = res2;\n" + 
				"				RESOURCE = res3;\n" + 
				"		TIMING_PROTECTION = TRUE {\n" +
				"			MAXALLINTERRUPTLOCKTIME = 1.0;" +
				"			EXECUTIONBUDGET = 2.0;" +
				"			MAXOSINTERRUPTLOCKTIME = 3.0;" +
				"			TIMEFRAME = 4.0;" +
				"	       RESOURCE = RESOURCELOCK {\n" + 
				"				RESOURCELOCKTIME = 5.0;\n" + 
				"				RESOURCE = res1;\n" + 
				"			};\n" + 				
				"	       RESOURCE = RESOURCELOCK {\n" + 
				"				RESOURCELOCKTIME = 6.0;\n" + 
				"				RESOURCE = res2;\n" + 
				"			};\n" + 				
				"	       RESOURCE = RESOURCELOCK {\n" + 
				"				RESOURCELOCKTIME = 7.0;\n" + 
				"				RESOURCE = res3;\n" + 
				"			};\n" + 				
				"		};\n" +
				"    };\n" + 
				"	ISR irq5_isr1 {\n" +
				"		CATEGORY = 1;" +
				"		LEVEL = \"5\";\n" +
				"		HANDLER = \"isr1\";	// IRQ handler\n" +
				"	};\n" +
				"	ISR trap_segfault {\n" +
				"		CATEGORY = 3;" +
				"		LEVEL = \"1\";\n" +
	  			"		HANDLER = \"segfault\";	// Trap handler\n" +
				"		TIMING_PROTECTION = FALSE;\n" +
				"	};\n" +
				"	ISR trap_syscall {\n" +
				"		CATEGORY = 3;" +
				"		LEVEL = \"6\";\n" +
				"		HANDLER = \"syscall\";	// Trap handler\n" +
				"	};\n" +
				"    RESOURCE res1 { RESOURCEPROPERTY = STANDARD; };\n" + 
				"    RESOURCE res2 { RESOURCEPROPERTY = STANDARD; };\n" + 
				"    RESOURCE res3 { RESOURCEPROPERTY = STANDARD; };\n" + 
				"};\n";
		commonWriterTest(text, 1);
	}
	
	@Test(expected=RuntimeException.class)
	public void testIsrTimingProtection_sc1() {
	    final String text =
				"CPU mySystem {\n" + 
				"	OS myOs {\n" +
				"		EE_OPT = \"DEBUG\";" + 
				"		EE_OPT = \"VERBOSE\";" + 
				"       STATUS = EXTENDED;\n" + 
				"       USERESSCHEDULER = FALSE;\n" + 
				"       SCALABILITYCLASS = SC1;\n" + 
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
				"		TIMING_PROTECTION = TRUE {\n" +
				"			MAXALLINTERRUPTLOCKTIME = 1.0;" +
				"			EXECUTIONTIME = 2.0;" +
				"			MAXOSINTERRUPTLOCKTIME = 3.0;" +
				"			TIMEFRAME = 4.0;" +
				"	       RESOURCE = LOCKINGTIME {\n" + 
				"				MAXRESOURCELOCKTIME = 5.0;\n" + 
				"				RESOURCE = res1;\n" + 
				"			};\n" + 				
				"		};\n" +
				"	};\n" +
				"	ISR irq5_isr1 {\n" +
				"		CATEGORY = 1;" +
				"		LEVEL = \"5\";\n" +
				"		HANDLER = \"isr1\";	// IRQ handler\n" +
				"		TIMING_PROTECTION = TRUE {\n" +
				"			MAXALLINTERRUPTLOCKTIME = 1.0;" +
				"			EXECUTIONTIME = 2.0;" +
				"			MAXOSINTERRUPTLOCKTIME = 3.0;" +
				"			TIMEFRAME = 4.0;" +
				"	       RESOURCE = LOCKINGTIME {\n" + 
				"				MAXRESOURCELOCKTIME = 5.0;\n" + 
				"				RESOURCE = res1;\n" + 
				"			};\n" + 				
				"	       RESOURCE = LOCKINGTIME {\n" + 
				"				MAXRESOURCELOCKTIME = 6.0;\n" + 
				"				RESOURCE = res2;\n" + 
				"			};\n" + 				
				"	       RESOURCE = LOCKINGTIME {\n" + 
				"				MAXRESOURCELOCKTIME = 7.0;\n" + 
				"				RESOURCE = res3;\n" + 
				"			};\n" + 				
				"		};\n" +
				"	};\n" +
				"	ISR trap_segfault {\n" +
				"		CATEGORY = 3;" +
				"		LEVEL = \"1\";\n" +
	  			"		HANDLER = \"segfault\";	// Trap handler\n" +
				"		TIMING_PROTECTION = FALSE;\n" +
				"	};\n" +
				"	ISR trap_syscall {\n" +
				"		CATEGORY = 3;" +
				"		LEVEL = \"6\";\n" +
				"		HANDLER = \"syscall\";	// Trap handler\n" +
				"	};\n" +
				"    RESOURCE res1 { RESOURCEPROPERTY = STANDARD; };\n" + 
				"    RESOURCE res2 { RESOURCEPROPERTY = STANDARD; };\n" + 
				"    RESOURCE res3 { RESOURCEPROPERTY = STANDARD; };\n" + 
				"};\n";
		commonWriterTest(text, 1);
	}
	
	@Test public void testIsrTimingProtection_sc2() {
	    final String text =
				"CPU mySystem {\n" + 
				"	OS myOs {\n" +
				"		EE_OPT = \"DEBUG\";" + 
				"		EE_OPT = \"VERBOSE\";" + 
				"       STATUS = EXTENDED;\n" + 
				"       USERESSCHEDULER = FALSE;\n" + 
				"       SCALABILITYCLASS = SC2;\n" + 
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
				"		TIMING_PROTECTION = TRUE {\n" +
				"			MAXALLINTERRUPTLOCKTIME = 1.0;" +
				"			EXECUTIONTIME = 2.0;" +
				"			MAXOSINTERRUPTLOCKTIME = 3.0;" +
				"			TIMEFRAME = 4.0;" +
				"	       RESOURCE = LOCKINGTIME {\n" + 
				"				MAXRESOURCELOCKTIME = 5.0;\n" + 
				"				RESOURCE = res1;\n" + 
				"			};\n" + 				
				"		};\n" +
				"	};\n" +
				"	ISR irq5_isr1 {\n" +
				"		CATEGORY = 1;" +
				"		LEVEL = \"5\";\n" +
				"		HANDLER = \"isr1\";	// IRQ handler\n" +
				"		TIMING_PROTECTION = TRUE {\n" +
				"			MAXALLINTERRUPTLOCKTIME = 1.0;" +
				"			EXECUTIONTIME = 2.0;" +
				"			MAXOSINTERRUPTLOCKTIME = 3.0;" +
				"			TIMEFRAME = 4.0;" +
				"	       RESOURCE = LOCKINGTIME {\n" + 
				"				MAXRESOURCELOCKTIME = 5.0;\n" + 
				"				RESOURCE = res1;\n" + 
				"			};\n" + 				
				"	       RESOURCE = LOCKINGTIME {\n" + 
				"				MAXRESOURCELOCKTIME = 6.0;\n" + 
				"				RESOURCE = res2;\n" + 
				"			};\n" + 				
				"	       RESOURCE = LOCKINGTIME {\n" + 
				"				MAXRESOURCELOCKTIME = 7.0;\n" + 
				"				RESOURCE = res3;\n" + 
				"			};\n" + 				
				"		};\n" +
				"	};\n" +
				"	ISR trap_segfault {\n" +
				"		CATEGORY = 3;" +
				"		LEVEL = \"1\";\n" +
	  			"		HANDLER = \"segfault\";	// Trap handler\n" +
				"		TIMING_PROTECTION = FALSE;\n" +
				"	};\n" +
				"	ISR trap_syscall {\n" +
				"		CATEGORY = 3;" +
				"		LEVEL = \"6\";\n" +
				"		HANDLER = \"syscall\";	// Trap handler\n" +
				"	};\n" +
				"    RESOURCE res1 { RESOURCEPROPERTY = STANDARD; };\n" + 
				"    RESOURCE res2 { RESOURCEPROPERTY = STANDARD; };\n" + 
				"    RESOURCE res3 { RESOURCEPROPERTY = STANDARD; };\n" + 
				"};\n";
		commonWriterTest(text, 1);
	}
	
	@Test public void testIsrTaskTimingProtection() {
	    final String text =
				"CPU mySystem {\n" + 
				"	OS myOs {\n" +
				"		EE_OPT = \"DEBUG\";" + 
				"		EE_OPT = \"VERBOSE\";" + 
				"       STATUS = EXTENDED;\n" + 
				"       USERESSCHEDULER = FALSE;\n" + 
				"    CPU_DATA = TRICORE {\n" +
				"      CPU_CLOCK = 200.0;\n" +
				"      APP_SRC = \"code.c\";\n" +
				"      MULTI_STACK = TRUE;\n" +
				"      COMPILER_TYPE = GNU;\n" +
				"    };\n" +
				"\n" +
				"    MCU_DATA = TRICORE {\n" +
				"      MODEL = TC27x;\n" +
				"    };\n" +
				"		KERNEL_TYPE = ECC2;\n" +
				"	};\n" + 
				"    TASK Task0 {\n" + 
				"        PRIORITY = 2;\n" + 
				"        ACTIVATION = 4;\n" + 
				"        STACK = SHARED;\n" + 
				"        SCHEDULE = FULL;\n" + 
				"				RESOURCE = res1;\n" + 
				"		TIMING_PROTECTION = TRUE {\n" +
				"			MAXALLINTERRUPTLOCKTIME = 1.0;" +
				"			EXECUTIONBUDGET = 2.0;" +
				"			MAXOSINTERRUPTLOCKTIME = 3.0;" +
				"			TIMEFRAME = 4.0;" +
				"	       RESOURCE = RESOURCELOCK {\n" + 
				"				RESOURCELOCKTIME = 5.0;\n" + 
				"				RESOURCE = res1;\n" + 
				"			};\n" + 				
				"		};\n" +
				"    };\n" + 
				"    TASK Task1 {\n" + 
				"        PRIORITY = 3;\n" + 
				"        ACTIVATION = 4;\n" + 
				"		 STACK = SHARED;\n" + 
				"        SCHEDULE = FULL;\n" + 
				"				RESOURCE = res1;\n" + 
				"				RESOURCE = res2;\n" + 
				"				RESOURCE = res3;\n" + 
				"		TIMING_PROTECTION = TRUE {\n" +
				"			MAXALLINTERRUPTLOCKTIME = 1.0;" +
				"			EXECUTIONBUDGET = 2.0;" +
				"			MAXOSINTERRUPTLOCKTIME = 3.0;" +
				"			TIMEFRAME = 4.0;" +
				"	       RESOURCE = RESOURCELOCK {\n" + 
				"				RESOURCELOCKTIME = 5.0;\n" + 
				"				RESOURCE = res1;\n" + 
				"			};\n" + 				
				"	       RESOURCE = RESOURCELOCK {\n" + 
				"				RESOURCELOCKTIME = 6.0;\n" + 
				"				RESOURCE = res2;\n" + 
				"			};\n" + 				
				"	       RESOURCE = RESOURCELOCK {\n" + 
				"				RESOURCELOCKTIME = 7.0;\n" + 
				"				RESOURCE = res3;\n" + 
				"			};\n" + 				
				"		};\n" +
				"    };\n" + 
				"	ISR Timer_isr2 {\n" +
				"		CATEGORY = 2;" +
				"		LEVEL = \"4\";\n" +
				"       PRIORITY = 4;\n" +
				"		HANDLER = \"isr2\";	// IRQ handler\n" +
				"				RESOURCE = res1;\n" + 
				"		TIMING_PROTECTION = TRUE {\n" +
				"			MAXALLINTERRUPTLOCKTIME = 1.0;" +
				"			EXECUTIONTIME = 2.0;" +
				"			MAXOSINTERRUPTLOCKTIME = 3.0;" +
				"			TIMEFRAME = 4.0;" +
				"	       RESOURCE = LOCKINGTIME {\n" + 
				"				MAXRESOURCELOCKTIME = 5.0;\n" + 
				"				RESOURCE = res1;\n" + 
				"			};\n" + 				
				"		};\n" +
				"	};\n" +
				"	ISR irq5_isr1 {\n" +
				"		CATEGORY = 2;" +
				"		LEVEL = \"5\";\n" +
				"       PRIORITY = 5;\n" +
				"		HANDLER = \"isr1\";	// IRQ handler\n" +
				"				RESOURCE = res1;\n" + 
				"				RESOURCE = res2;\n" + 
				"				RESOURCE = res3;\n" + 
				"		TIMING_PROTECTION = TRUE {\n" +
				"			MAXALLINTERRUPTLOCKTIME = 1.0;" +
				"			EXECUTIONTIME = 2.0;" +
				"			MAXOSINTERRUPTLOCKTIME = 3.0;" +
				"			TIMEFRAME = 4.0;" +
				"	       RESOURCE = LOCKINGTIME {\n" + 
				"				MAXRESOURCELOCKTIME = 5.0;\n" + 
				"				RESOURCE = res1;\n" + 
				"			};\n" + 				
				"	       RESOURCE = LOCKINGTIME {\n" + 
				"				MAXRESOURCELOCKTIME = 6.0;\n" + 
				"				RESOURCE = res2;\n" + 
				"			};\n" + 				
				"	       RESOURCE = LOCKINGTIME {\n" + 
				"				MAXRESOURCELOCKTIME = 7.0;\n" + 
				"				RESOURCE = res3;\n" + 
				"			};\n" + 				
				"		};\n" +
				"	};\n" +
				"    RESOURCE res1 { RESOURCEPROPERTY = STANDARD; };\n" + 
				"    RESOURCE res2 { RESOURCEPROPERTY = STANDARD; };\n" + 
				"    RESOURCE res3 { RESOURCEPROPERTY = STANDARD; };\n" + 
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


	@Test public void testTc26xIsr() {
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
				"			MODEL = TC26x;\n"+
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
	
	@Test public void testOsAppl() {
	    final String text =
			"CPU PerfTestApp {\n" +
			"  OS EE {\n" +
			"    EE_OPT = \"EE_DEBUG\";\n" +
			"    EE_OPT = \"__ASSERT__\";\n" +
			"    EE_OPT = \"EE_SAVE_TEMP_FILES\";\n" +
			"\n" +
			"    MEMORY_PROTECTION = TRUE;\n" +
			"    STACKMONITORING = TRUE;\n" +
			"\n" +
			"    /* Used to enable static map of OS-Applications on protection sets\n" +
			"       optimization */\n" +
			"    EE_OPT = \"EE_OS_APP_MAPPED_ON_PROTECTION_SETS\";\n" +
			"\n" +
			"    CPU_DATA = TRICORE {\n" +
			"      CPU_CLOCK = 200.0;\n" +
			"      APP_SRC = \"code.c\";\n" +
			"      APP_SRC = \"app.c\";\n" +
			"      COMPILER_TYPE = DIAB;\n" +
			"      MULTI_STACK = TRUE {\n" +
			"        IRQ_STACK = TRUE {\n" +
			"            SYS_SIZE = 256;\n" +
			"        };\n" +
			"      };\n" +
			"      SYS_CSA_SIZE=0x2000;\n" +
			"    };\n" +
			"\n" +
			"    MCU_DATA = TRICORE {\n" +
			"      MODEL = TC27x;\n" +
			"    };\n" +
			"\n" +
			"    STATUS = EXTENDED;\n" +
			"    USEPARAMETERACCESS = FALSE;\n" +
			"    USERESSCHEDULER = FALSE;\n" +
			"    SHUTDOWNHOOK = TRUE;\n" +
			"\n" +
			"    PROTECTIONHOOK = TRUE;\n" +
			"    KERNEL_TYPE    = BCC1;\n" +
			"    ORTI_SECTIONS  = ALL;\n" +
			"  };\n" +
			"\n" +
			"  TASK TaskApp1Prio1 {\n" +
			"    PRIORITY = 2;\n" +
			"    ACTIVATION = 1;\n" +
			"    SCHEDULE = FULL;\n" +
			"    AUTOSTART = TRUE;\n" +
			"    STACK = SHARED;\n" +
			"  };\n" +
			"\n" +
			"  TASK TaskApp1Prio2 {\n" +
			"    PRIORITY = 2;\n" +
			"    ACTIVATION = 1;\n" +
			"    SCHEDULE = FULL;\n" +
			"    AUTOSTART = FALSE;\n" +
			"    STACK = SHARED;\n" +
			"  };\n" +
			"\n" +
			"  APPLICATION UserApp1 {\n" +
			"    TRUSTED = FALSE;\n" +
			"    TASK=TaskApp1Prio1;\n" +
			"    TASK=TaskApp1Prio2;\n" +
			"    MEMORY_SIZE = 0x1000;\n" +
			"    SHARED_STACK_SIZE = 256;\n" +
			"    IRQ_STACK_SIZE = 256;\n" +
			"  };\n" +
			"};\n";
		commonWriterTest(text, 1);
	}

	@Test public void testOsAppl_kernel() {
	    final String text =
			"CPU PerfTestApp {\n" +
			"  OS EE {\n" +
			"    EE_OPT = \"EE_DEBUG\";\n" +
			"    EE_OPT = \"__ASSERT__\";\n" +
			"    EE_OPT = \"EE_SAVE_TEMP_FILES\";\n" +
			"\n" +
			"    KERNEL_STACKS = TRUE;\n" +
			"    MEMORY_PROTECTION = TRUE;\n" +
			"    STACKMONITORING = TRUE;\n" +
			"\n" +
			"    /* Used to enable static map of OS-Applications on protection sets\n" +
			"       optimization */\n" +
			"    EE_OPT = \"EE_OS_APP_MAPPED_ON_PROTECTION_SETS\";\n" +
			"\n" +
			"    CPU_DATA = TRICORE {\n" +
			"      CPU_CLOCK = 200.0;\n" +
			"      APP_SRC = \"code.c\";\n" +
			"      APP_SRC = \"app.c\";\n" +
			"      COMPILER_TYPE = DIAB;\n" +
			"      MULTI_STACK = TRUE {\n" +
			"        IRQ_STACK = TRUE {\n" +
			"            SYS_SIZE = 256;\n" +
			"        };\n" +
			"      };\n" +
			"      SYS_CSA_SIZE=0x2000;\n" +
			"    };\n" +
			"\n" +
			"    MCU_DATA = TRICORE {\n" +
			"      MODEL = TC27x;\n" +
			"    };\n" +
			"\n" +
			"    STATUS = EXTENDED;\n" +
			"    USEPARAMETERACCESS = FALSE;\n" +
			"    USERESSCHEDULER = FALSE;\n" +
			"    SHUTDOWNHOOK = TRUE;\n" +
			"\n" +
			"    PROTECTIONHOOK = TRUE;\n" +
			"    KERNEL_TYPE    = BCC1;\n" +
			"    ORTI_SECTIONS  = ALL;\n" +
			"  };\n" +
			"\n" +
			"  TASK TaskApp1Prio1 {\n" +
			"    PRIORITY = 2;\n" +
			"    ACTIVATION = 1;\n" +
			"    SCHEDULE = FULL;\n" +
			"    AUTOSTART = TRUE;\n" +
			"    STACK = SHARED;\n" +
			"  };\n" +
			"\n" +
			"  TASK TaskApp1Prio2 {\n" +
			"    PRIORITY = 2;\n" +
			"    ACTIVATION = 1;\n" +
			"    SCHEDULE = FULL;\n" +
			"    AUTOSTART = FALSE;\n" +
			"    STACK = SHARED;\n" +
			"  };\n" +
			"\n" +
			"  APPLICATION UserApp1 {\n" +
			"    TRUSTED = FALSE;\n" +
			"    TASK=TaskApp1Prio1;\n" +
			"    TASK=TaskApp1Prio2;\n" +
			"    MEMORY_SIZE = 0x1000;\n" +
			"    SHARED_STACK_SIZE = 256;\n" +
			"    IRQ_STACK_SIZE = 256;\n" +
			"  };\n" +
			"};\n";
		commonWriterTest(text, 1);
	}
	
	@Test public void testTc_memProt_09() {
	    final String text =
			"CPU PerfTestApp {\n" +
			"  OS EE {\n" +
			"    EE_OPT = \"EE_DEBUG\";\n" +
			"    EE_OPT = \"__ASSERT__\";\n" +
			"    //EE_OPT = \"EE_EXECUTE_FROM_RAM\";\n" +
			"    EE_OPT = \"EE_SAVE_TEMP_FILES\";\n" +
			"    //EE_OPT = \"EE_MM_OPT\";\n" +
			"\n" +
			"    MEMORY_PROTECTION = TRUE;\n" +
			"    STACKMONITORING = TRUE;\n" +
			"\n" +
			"    /* Used to enable static map of OS-Applications on protection sets\n" +
			"       optimization */\n" +
			"    EE_OPT = \"EE_OS_APP_MAPPED_ON_PROTECTION_SETS\";\n" +
			"\n" +
			"    CPU_DATA = TRICORE {\n" +
			"      CPU_CLOCK = 200.0;\n" +
			"      APP_SRC = \"code.c\";\n" +
			"      APP_SRC = \"app.c\";\n" +
			"      APP_SRC = \"test_irq.c\";\n" +
			"      COMPILER_TYPE = DIAB;\n" +
			"      MULTI_STACK = TRUE {\n" +
			"        IRQ_STACK = TRUE {\n" +
			"            SYS_SIZE = 256;\n" +
			"        };\n" +
			"      };\n" +
			"      SYS_CSA_SIZE=0x2000;\n" +
			"    };\n" +
			"\n" +
			"    MCU_DATA = TRICORE {\n" +
			"      MODEL = TC27x;\n" +
			"    };\n" +
			"\n" +
			"    STATUS = EXTENDED;\n" +
			"    USEPARAMETERACCESS = FALSE;\n" +
			"    USERESSCHEDULER = FALSE;\n" +
			"    STARTUPHOOK=TRUE;\n" +
			"    SHUTDOWNHOOK=TRUE;\n" +
			"    ERRORHOOK=TRUE;\n" +
			"\n" +
			"    KERNEL_TYPE = ECC2;\n" +
			"\n" +
			"    ORTI_SECTIONS = ALL;\n" +
			"  };\n" +
			"\n" +
			"  TASK MainTask {\n" +
			"    PRIORITY = 1;\n" +
			"    ACTIVATION = 1;\n" +
			"    SCHEDULE = NON;\n" +
			"    AUTOSTART = TRUE;\n" +
			"    STACK = SHARED;\n" +
			"  };\n" +
			"\n" +
			"  TASK TaskApp1Prio2 {\n" +
			"    PRIORITY = 2;\n" +
			"    ACTIVATION = 1;\n" +
			"    SCHEDULE = FULL;\n" +
			"    AUTOSTART = FALSE;\n" +
			"    STACK = SHARED;\n" +
			"  };\n" +
			"\n" +
			"  TASK TaskApp1Prio4 {\n" +
			"    PRIORITY = 4;\n" +
			"    ACTIVATION = 1;\n" +
			"    SCHEDULE = NON;\n" +
			"    AUTOSTART = FALSE;\n" +
			"    STACK = PRIVATE {\n" +
			"      SYS_SIZE = 256;\n" +
			"    };\n" +
			"    EVENT = DummyEvent;\n" +
			"  };\n" +
			"\n" +
			"  TASK TaskApp1Prio6 {\n" +
			"    PRIORITY = 6;\n" +
			"    ACTIVATION = 1;\n" +
			"    SCHEDULE = FULL;\n" +
			"    AUTOSTART = FALSE;\n" +
			"    STACK = SHARED;\n" +
			"  };\n" +
			"\n" +
			"  TASK TaskApp2Prio3 {\n" +
			"    PRIORITY = 3;\n" +
			"    ACTIVATION = 1;\n" +
			"    SCHEDULE = FULL;\n" +
			"    AUTOSTART = FALSE;\n" +
			"    STACK = SHARED;\n" +
			"  };\n" +
			"\n" +
			"  TASK TaskApp2Prio5 {\n" +
			"    PRIORITY = 5;\n" +
			"    ACTIVATION = 1;\n" +
			"    SCHEDULE = NON;\n" +
			"    AUTOSTART = FALSE;\n" +
			"    STACK = PRIVATE {\n" +
			"      SYS_SIZE = 256;\n" +
			"    };\n" +
			"    EVENT = DummyEvent;\n" +
			"  };\n" +
			"\n" +
			"  ISR App1Isr1 {\n" +
			"    CATEGORY = 2;\n" +
			"    PRIORITY = 1;\n" +
			"  };\n" +
			"\n" +
			"  ISR App1Isr2 {\n" +
			"    CATEGORY = 2;\n" +
			"    PRIORITY = 2;\n" +
			"  };\n" +
			"\n" +
			"  ISR App2Isr3 {\n" +
			"    CATEGORY = 2;\n" +
			"    PRIORITY = 3;\n" +
			"  };\n" +
			"\n" +
			"  EVENT DummyEvent  { MASK = AUTO; };\n" +
			"\n" +
			"  APPLICATION UserApp1 {\n" +
			"    TRUSTED = FALSE;\n" +
			"    ISR  = App1Isr1;\n" +
			"    ISR  = App1Isr2;\n" +
			"    TASK = TaskApp1Prio2;\n" +
			"    TASK = TaskApp1Prio4;\n" +
			"    TASK = TaskApp1Prio6;\n" +
			"    MEMORY_SIZE = 0x1000;\n" +
			"    SHARED_STACK_SIZE = 256;\n" +
			"    IRQ_STACK_SIZE = 256;\n" +
			"    STARTUPHOOK=TRUE;\n" +
			"    SHUTDOWNHOOK=TRUE;\n" +
			"    ERRORHOOK=TRUE;\n" +
			"  };\n" +
			"\n" +
			"  APPLICATION TrustedApp2 {\n" +
			"    TRUSTED = TRUE {\n" +
			"      TRUSTED_FUNCTION = TRUE {\n" +
			"        NAME = \"test_fire_irq\";\n" +
			"      };\n" +
			"    };\n" +
			"    ISR  = App2Isr3;\n" +
			"    TASK = TaskApp2Prio3;\n" +
			"    TASK = TaskApp2Prio5;\n" +
			"    TASK = MainTask;\n" +
			"    MEMORY_SIZE = 0x1000;\n" +
			"    SHARED_STACK_SIZE = 256;\n" +
			"    IRQ_STACK_SIZE = 256;\n" +
			"    STARTUPHOOK=TRUE;\n" +
			"    SHUTDOWNHOOK=TRUE;\n" +
			"    ERRORHOOK=TRUE;\n" +
			"  };\n" +
			"};\n";
			commonWriterTest(text, 1);
		}

	@Test public void testIsrPriority2_memProt() {
	    final String text =
				"CPU mySystem {\n" + 
				"	OS myOs {\n" +
				"		EE_OPT = \"DEBUG\";" + 
				"		EE_OPT = \"VERBOSE\";" + 
				"       STATUS = EXTENDED;\n" + 
				"       USERESSCHEDULER = FALSE;\n" + 
				" 	   MEMORY_PROTECTION = TRUE;\n" +
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
				"APPLICATION appl1 {\n" +
				"		TRUSTED = FALSE;\n" +
				"		IRQ_STACK_SIZE = 1024;\n" +
	    		"		SHARED_STACK_SIZE = 512;\n"+
				"		TASK=Task0;\n" +
				"       ISR = Timer_isr2c;\n" +
				"       ISR = Timer_isr1a;\n" +
				"       ISR = Timer_isr1b;\n" +
	    		"		MEMORY_SIZE = 0x10000;\n"+
				"		STARTUPHOOK = FALSE;\n" +
				"		ERRORHOOK = TRUE;\n" +
				"		SHUTDOWNHOOK = FALSE;\n" +
				"    };\n" +
				"APPLICATION appl2 {\n" +
				"		TRUSTED = TRUE;\n" +
				"		IRQ_STACK_SIZE = 1024;\n" +
	    		"		SHARED_STACK_SIZE = 512;\n"+
				"		TASK=Task1;\n" +
				"       ISR = Timer_isr2a;\n" +
				"       ISR = Timer_isr2b;\n" +
				"       ISR = Timer_isr1c;\n" +
				"       COUNTER = system_timer;\n" +
				"		MEMORY_SIZE = 0x10000;\n"+
				"		STARTUPHOOK = FALSE;\n" +
				"		ERRORHOOK = TRUE;\n" +
				"		SHUTDOWNHOOK = FALSE;\n" +
				"    };\n" +
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
				"};\n";
		commonWriterTest(text, 1);
	}

	@Test public void testIsrPriority2_memProt_resttask() {
	    final String text =
				"CPU mySystem {\n" + 
				"	OS myOs {\n" +
				"		EE_OPT = \"DEBUG\";" + 
				"		EE_OPT = \"VERBOSE\";" + 
				"       STATUS = EXTENDED;\n" + 
				"       USERESSCHEDULER = FALSE;\n" + 
				" 	   MEMORY_PROTECTION = TRUE;\n" +
				" 	   PROTECTIONHOOK = TRUE;\n" +
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
				"APPLICATION appl1 {\n" +
				"		TRUSTED = FALSE;\n" +
				"		IRQ_STACK_SIZE = 1024;\n" +
	    		"		SHARED_STACK_SIZE = 512;\n"+
				"		TASK=Task0;\n" +
				"		RESTARTTASK=Task0;\n" +
				"       ISR = Timer_isr2c;\n" +
				"       ISR = Timer_isr1a;\n" +
				"       ISR = Timer_isr1b;\n" +
	    		"		MEMORY_SIZE = 0x10000;\n"+
				"		STARTUPHOOK = FALSE;\n" +
				"		ERRORHOOK = TRUE;\n" +
				"		SHUTDOWNHOOK = FALSE;\n" +
				"    };\n" +
				"APPLICATION appl2 {\n" +
				"		TRUSTED = TRUE;\n" +
				"		IRQ_STACK_SIZE = 1024;\n" +
	    		"		SHARED_STACK_SIZE = 512;\n"+
				"		TASK=Task1;\n" +
				"		RESTARTTASK=Task1;\n" +
				"       ISR = Timer_isr2a;\n" +
				"       ISR = Timer_isr2b;\n" +
				"       ISR = Timer_isr1c;\n" +
				"       COUNTER = system_timer;\n" +
				"		MEMORY_SIZE = 0x10000;\n"+
				"		STARTUPHOOK = FALSE;\n" +
				"		ERRORHOOK = TRUE;\n" +
				"		SHUTDOWNHOOK = FALSE;\n" +
				"    };\n" +
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
				"};\n";
		commonWriterTest(text, 1);
	}

	@Test public void testIsrPriority2_stackmonitoring_resttask() {
	    final String text =
				"CPU mySystem {\n" + 
				"	OS myOs {\n" +
				"		EE_OPT = \"DEBUG\";" + 
				"		EE_OPT = \"VERBOSE\";" + 
				"       STATUS = EXTENDED;\n" + 
				"       USERESSCHEDULER = FALSE;\n" + 
				" 	   STACKMONITORING = TRUE;\n" +
				" 	   PROTECTIONHOOK = TRUE;\n" +
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
				"		KERNEL_TYPE = ECC1;\n" +
				"		MCU_DATA = TRICORE {\n"+
				"			MODEL = TC27x;\n"+
				"			LINKERSCRIPT = \"mcu_link\";\n"+
				"		};\n"+
				"	};\n" + 
				"APPLICATION appl1 {\n" +
				"		TRUSTED = FALSE;\n" +
				"		IRQ_STACK_SIZE = 1024;\n" +
	    		"		SHARED_STACK_SIZE = 512;\n"+
				"		TASK=Task0;\n" +
				"		RESTARTTASK=Task0;\n" +
				"       ISR = Timer_isr2c;\n" +
				"       ISR = Timer_isr1a;\n" +
				"       ISR = Timer_isr1b;\n" +
	    		"		MEMORY_SIZE = 0x10000;\n"+
				"		STARTUPHOOK = FALSE;\n" +
				"		ERRORHOOK = TRUE;\n" +
				"		SHUTDOWNHOOK = FALSE;\n" +
				"    };\n" +
				"APPLICATION appl2 {\n" +
				"		TRUSTED = TRUE;\n" +
				"		IRQ_STACK_SIZE = 1024;\n" +
	    		"		SHARED_STACK_SIZE = 512;\n"+
				"		TASK=Task1;\n" +
				"		RESTARTTASK=Task1;\n" +
				"       ISR = Timer_isr2a;\n" +
				"       ISR = Timer_isr2b;\n" +
				"       ISR = Timer_isr1c;\n" +
				"       COUNTER = system_timer;\n" +
				"		MEMORY_SIZE = 0x10000;\n"+
				"		STARTUPHOOK = FALSE;\n" +
				"		ERRORHOOK = TRUE;\n" +
				"		SHUTDOWNHOOK = FALSE;\n" +
				"    };\n" +
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
				"};\n";
		commonWriterTest(text, 1);
	}

	@Test public void testIsrPriority2_memProt_onlyHwCounter() {
	    final String text =
				"CPU mySystem {\n" + 
				"	OS myOs {\n" +
				"		EE_OPT = \"DEBUG\";" + 
				"		EE_OPT = \"VERBOSE\";" + 
				"       STATUS = EXTENDED;\n" + 
				"       USERESSCHEDULER = FALSE;\n" + 
				" 	   MEMORY_PROTECTION = TRUE;\n" +
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
				"APPLICATION appl1 {\n" +
				"		TRUSTED = FALSE;\n" +
				"		IRQ_STACK_SIZE = 1024;\n" +
	    		"		SHARED_STACK_SIZE = 512;\n"+
				"		TASK=Task0;\n" +
	    		"		MEMORY_SIZE = 0x10000;\n"+
				"		STARTUPHOOK = FALSE;\n" +
				"		ERRORHOOK = TRUE;\n" +
				"		SHUTDOWNHOOK = FALSE;\n" +
				"    };\n" +
				"APPLICATION appl2 {\n" +
				"		TRUSTED = TRUE;\n" +
				"		IRQ_STACK_SIZE = 1024;\n" +
	    		"		SHARED_STACK_SIZE = 512;\n"+
				"		TASK=Task1;\n" +
				"       COUNTER = system_timer;\n" +
				"		MEMORY_SIZE = 0x10000;\n"+
				"		STARTUPHOOK = FALSE;\n" +
				"		ERRORHOOK = TRUE;\n" +
				"		SHUTDOWNHOOK = FALSE;\n" +
				"    };\n" +
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
	
	@Test public void testTc26x() {
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
				"			MODEL = TC26x;\n"+
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
	
	@Test(expected=RuntimeException.class)
	public void testTc27xMulticoreLinkerGnuTasking() {
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


	@Test(expected=RuntimeException.class)
	public void testTc27xMulticoreQueuedSpinlockFail() {
	    final String text = "CPU test_application {\n"+
			"\n"+
			"	OS EE {\n"+
			"		EE_OPT = \"__ASSERT__\";\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\";\n"+
			"		SPINLOCKS = QUEUED;\n"+
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
			"        RESOURCE = MUTEX_1;\n" + 
			"        RESOURCE = MUTEX_2;\n" + 
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
			"        RESOURCE = MUTEX_2;\n" + 
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
			"        RESOURCE = MUTEX_2;\n" + 
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
			"        RESOURCE = MUTEX_2;\n" + 
			"	};\n"+
			"\n"+
			"	TASK TaskSlave2b {\n"+
			"		CPU_ID = \"slave2\";\n"+
			"		PRIORITY = 3;\n"+
			"		AUTOSTART = FALSE;\n"+
			"        STACK = PRIVATE {\n" +
			"            SYS_SIZE = 256;\n" +
			"        };\n" +
			"        RESOURCE = MUTEX_3;\n" + 
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"    RESOURCE MUTEX_1 { RESOURCEPROPERTY = STANDARD; };\n" + 
			"    RESOURCE MUTEX_2 { RESOURCEPROPERTY = STANDARD; };\n" + 
			"    RESOURCE MUTEX_3 { RESOURCEPROPERTY = STANDARD; };\n" + 
			"};\n";
		commonWriterTest(text, 3);
	}
	
	@Test public void testTc27xMulticoreQueuedSpinlock() {
	    final String text = "CPU test_application {\n"+
			"\n"+
			"	OS EE {\n"+
			"		EE_OPT = \"__ASSERT__\";\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\";\n"+
			"		SPINLOCKS = QUEUED;\n"+
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
			"        RESOURCE = MUTEX_1;\n" + 
			"        RESOURCE = MUTEX_2;\n" + 
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
			"        RESOURCE = MUTEX_2;\n" + 
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
//			"        RESOURCE = MUTEX_2;\n" + 
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
//			"        RESOURCE = MUTEX_2;\n" + 
			"	};\n"+
			"\n"+
			"	TASK TaskSlave2b {\n"+
			"		CPU_ID = \"slave2\";\n"+
			"		PRIORITY = 3;\n"+
			"		AUTOSTART = FALSE;\n"+
			"        STACK = PRIVATE {\n" +
			"            SYS_SIZE = 256;\n" +
			"        };\n" +
			"        RESOURCE = MUTEX_3;\n" + 
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"    RESOURCE MUTEX_1 { RESOURCEPROPERTY = STANDARD; };\n" + 
			"    RESOURCE MUTEX_2 { RESOURCEPROPERTY = STANDARD; };\n" + 
			"    RESOURCE MUTEX_3 { RESOURCEPROPERTY = STANDARD; };\n" + 
			"};\n";
		commonWriterTest(text, 3);
	}
	
	@Test public void testTc27xMulticoreSpinlock() {
	    final String text = "CPU test_application {\n"+
			"\n"+
			"	OS EE {\n"+
			"		EE_OPT = \"__ASSERT__\";\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\";\n"+
//			"		SPINLOCKS = QUEUED;\n"+
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
			"        RESOURCE = MUTEX_1;\n" + 
			"        RESOURCE = MUTEX_2;\n" + 
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
			"        RESOURCE = MUTEX_2;\n" + 
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
//			"        RESOURCE = MUTEX_2;\n" + 
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
//			"        RESOURCE = MUTEX_2;\n" + 
			"	};\n"+
			"\n"+
			"	TASK TaskSlave2b {\n"+
			"		CPU_ID = \"slave2\";\n"+
			"		PRIORITY = 3;\n"+
			"		AUTOSTART = FALSE;\n"+
			"        STACK = PRIVATE {\n" +
			"            SYS_SIZE = 256;\n" +
			"        };\n" +
			"        RESOURCE = MUTEX_3;\n" + 
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"    RESOURCE MUTEX_1 { RESOURCEPROPERTY = STANDARD; };\n" + 
			"    RESOURCE MUTEX_2 { RESOURCEPROPERTY = STANDARD; };\n" + 
			"    RESOURCE MUTEX_3 { RESOURCEPROPERTY = STANDARD; };\n" + 
			"};\n";
		commonWriterTest(text, 3);
	}
	
	@Test public void testTc27xMulticoreSpinlockUnordered() {
	    final String text = "CPU test_application {\n"+
			"\n"+
			"	OS EE {\n"+
			"		EE_OPT = \"__ASSERT__\";\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\";\n"+
//			"		SPINLOCKS = QUEUED;\n"+
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
			"        RESOURCE = MUTEX_1;\n" + 
			"        RESOURCE = MUTEX_2;\n" + 
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
			"        RESOURCE = MUTEX_2;\n" + 
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
//			"        RESOURCE = MUTEX_2;\n" + 
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
//			"        RESOURCE = MUTEX_2;\n" + 
			"	};\n"+
			"\n"+
			"	TASK TaskSlave2b {\n"+
			"		CPU_ID = \"slave2\";\n"+
			"		PRIORITY = 3;\n"+
			"		AUTOSTART = FALSE;\n"+
			"        STACK = PRIVATE {\n" +
			"            SYS_SIZE = 256;\n" +
			"        };\n" +
			"        RESOURCE = MUTEX_3;\n" + 
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"    RESOURCE MUTEX_1 { RESOURCEPROPERTY = STANDARD; };\n" + 
			"    RESOURCE MUTEX_2 { RESOURCEPROPERTY = STANDARD; };\n" + 
			"    RESOURCE MUTEX_3 { RESOURCEPROPERTY = STANDARD; };\n" + 
			"    SPINLOCK MUTEX_1 {  };\n" + 
			"    SPINLOCK MUTEX_2 {  };\n" + 
			"    SPINLOCK MUTEX_3 {  };\n" + 
			"};\n";
		commonWriterTest(text, 3);
	}

	@Test public void testTc27xMulticoreQueuesSpinlockUnordered() {
	    final String text = "CPU test_application {\n"+
			"\n"+
			"	OS EE {\n"+
			"		EE_OPT = \"__ASSERT__\";\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\";\n"+
			"		SPINLOCKS = QUEUED;\n"+
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
			"        RESOURCE = MUTEX_1;\n" + 
			"        RESOURCE = MUTEX_2;\n" + 
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
			"        RESOURCE = MUTEX_2;\n" + 
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
//			"        RESOURCE = MUTEX_2;\n" + 
			"	};\n"+
			"\n"+
			"	TASK TaskSlave1c {\n"+
			"		CPU_ID = \"slave1\";\n"+
			"		PRIORITY = 2;\n"+
			"		AUTOSTART = FALSE;\n"+
			"        STACK = PRIVATE {\n" +
			"            SYS_SIZE = 256;\n" +
			"        };\n" +
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
//			"        RESOURCE = MUTEX_2;\n" + 
			"	};\n"+
			"\n"+
			"	TASK TaskSlave2b {\n"+
			"		CPU_ID = \"slave2\";\n"+
			"		PRIORITY = 3;\n"+
			"		AUTOSTART = FALSE;\n"+
			"        STACK = PRIVATE {\n" +
			"            SYS_SIZE = 256;\n" +
			"        };\n" +
			"        RESOURCE = MUTEX_3;\n" + 
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"    RESOURCE MUTEX_1 { RESOURCEPROPERTY = STANDARD; };\n" + 
			"    RESOURCE MUTEX_2 { RESOURCEPROPERTY = STANDARD; };\n" + 
			"    RESOURCE MUTEX_3 { RESOURCEPROPERTY = STANDARD; };\n" + 
			"    SPINLOCK SPIN_1 {  };\n" + 
			"    SPINLOCK SPIN_2 {  };\n" + 
			"    SPINLOCK SPIN_3 {  };\n" + 
			"    SPINLOCK SPIN_4 {  };\n" + 
			"    SPINLOCK SPIN_5 {  };\n" + 
			"};\n";
		commonWriterTest(text, 3);
	}

	@Test public void testTc27xMulticoreQueuesSpinlockOrdered() {
	    final String text = "CPU test_application {\n"+
			"\n"+
			"	OS EE {\n"+
			"		EE_OPT = \"__ASSERT__\";\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\";\n"+
			"		SPINLOCKS = QUEUED;\n"+
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
			"        RESOURCE = MUTEX_1;\n" + 
			"        RESOURCE = MUTEX_2;\n" + 
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
			"        RESOURCE = MUTEX_2;\n" + 
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
//			"        RESOURCE = MUTEX_2;\n" + 
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
//			"        RESOURCE = MUTEX_2;\n" + 
			"	};\n"+
			"\n"+
			"	TASK TaskSlave2b {\n"+
			"		CPU_ID = \"slave2\";\n"+
			"		PRIORITY = 3;\n"+
			"		AUTOSTART = FALSE;\n"+
			"        STACK = PRIVATE {\n" +
			"            SYS_SIZE = 256;\n" +
			"        };\n" +
			"        RESOURCE = MUTEX_3;\n" + 
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"    RESOURCE MUTEX_1 { RESOURCEPROPERTY = STANDARD; };\n" + 
			"    RESOURCE MUTEX_2 { RESOURCEPROPERTY = STANDARD; };\n" + 
			"    RESOURCE MUTEX_3 { RESOURCEPROPERTY = STANDARD; };\n" + 
			"    SPINLOCK MUTEX_1 {  };\n" + 
			"    SPINLOCK MUTEX_2 {  };\n" + 
			"    SPINLOCK MUTEX_3 { NEXT_SPINLOCK=MUTEX_2; };\n" + 
			"};\n";
		commonWriterTest(text, 3);
	}


	@Test public void testTc27xMulticoreSpinlockWithGlobalResources() {
	    final String text = "CPU test_application {\n"+
			"\n"+
			"	OS EE {\n"+
			"		EE_OPT = \"__ASSERT__\";\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\";\n"+
//			"		SPINLOCKS = QUEUED;\n"+
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
			"        RESOURCE = MUTEX_1;\n" + 
			"        RESOURCE = MUTEX_2;\n" + 
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
			"        RESOURCE = MUTEX_2;\n" + 
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
			"        RESOURCE = MUTEX_2;\n" + 
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
			"        RESOURCE = MUTEX_2;\n" + 
			"	};\n"+
			"\n"+
			"	TASK TaskSlave2b {\n"+
			"		CPU_ID = \"slave2\";\n"+
			"		PRIORITY = 3;\n"+
			"		AUTOSTART = FALSE;\n"+
			"        STACK = PRIVATE {\n" +
			"            SYS_SIZE = 256;\n" +
			"        };\n" +
			"        RESOURCE = MUTEX_3;\n" + 
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"    RESOURCE MUTEX_1 { RESOURCEPROPERTY = STANDARD; };\n" + 
			"    RESOURCE MUTEX_2 { RESOURCEPROPERTY = STANDARD; };\n" + 
			"    RESOURCE MUTEX_3 { RESOURCEPROPERTY = STANDARD; };\n" + 
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
	
	

	@Test public void testTc27x_os_application() {
	    final String text = "CPU test_application {\n" +
			"\n" +
			"	OS EE {		\n" +
			"		EE_OPT = \"DEBUG_STACK\";\n" +
			"\n" +
			"		CFLAGS = \"-g2\";\n" +
			"		ASFLAGS = \"\";\n" +
			"		LDFLAGS = \"\"; \n" +
			"\n" +
			"		 CPU_DATA = TRICORE {\n" +
			"            CPU_CLOCK = 200.0;\n" +
			"            APP_SRC = \"code.c\";\n" +
			"            MULTI_STACK = TRUE {\n" +
			"                IRQ_STACK = TRUE {\n" +
			"                    SYS_SIZE = 256;\n" +
			"                };\n" +
			"            };\n" +
			"        };\n" +
			"		\n" +
			"		MCU_DATA = TRICORE {\n"+
			"			MODEL = TC27x;\n"+
			"		};\n"+
			"		\n" +
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
			"    APPLICATION appl1 {\n" +
			"		TRUSTED = FALSE;\n" +
			"		IRQ_STACK_SIZE = 1024;\n" +
    		"		SHARED_STACK_SIZE = 512;\n"+
			"		TASK=Task1;\n" +
			"		TASK=Task_app1;\n" +
			"       ISR = isr_base1;\n" +
			"       ISR = isr_app1;\n" +
    		"		MEMORY_BASE = \"0x40020000\";\n"+
    		"		MEMORY_SIZE = 0x10000;\n"+
			"		STARTUPHOOK = FALSE;\n" +
			"		ERRORHOOK = TRUE;\n" +
			"		SHUTDOWNHOOK = FALSE;\n" +
			"    };\n" +
			"    APPLICATION appl2 {\n" +
			"		TRUSTED = FALSE;\n" +
			"		IRQ_STACK_SIZE = 512;\n" +
    		"		SHARED_STACK_SIZE = 512;\n"+
			"		TASK=Task2;\n" +
    		"		MEMORY_BASE = \"0x40020000\";\n"+
    		"		MEMORY_SIZE = 0x10000;\n"+
			"		STARTUPHOOK = TRUE;\n" +
			"		ERRORHOOK = TRUE;\n" +
			"		SHUTDOWNHOOK = TRUE;\n" +
			"    };\n" +
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
			"    TASK Task_app1 {\n" +
			"		PRIORITY = 0x01;   /* Low priority */\n" +
			"		AUTOSTART = FALSE;\n" +
			"		STACK = PRIVATE {\n" +
			"			SYS_SIZE = 512;\n" +
			"		};\n" +
			"		ACTIVATION = 1;    /* only one pending activation */\n" +
			"	};	\n" +
			"    ISR isr_base1 {\n" +
			"		CATEGORY = 2;\n" +
			"	};	\n" +			
			"    ISR isr_app1 {\n" +
			"		CATEGORY = 2;\n" +
			"	};	\n" +			
			"    OS EE { \n" +
			"		KERNEL_TYPE = ECC2;\n" +
			"		ORTI_SECTIONS = ALL;\n" +
			"		MAX_NESTING_LEVEL = 8;\n" +
			"  }; 	\n" +
			"};";
		commonWriterTest(text, 1);
	}


	@Test public void testTc27xMulticoreCustomStartup() {
	    final String text = "CPU test_application {\n"+
			"\n"+
			"	OS EE {\n"+
			"		EE_OPT = \"__ASSERT__\";\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\";\n"+
			"		SPINLOCKS = QUEUED;\n"+
			"\n"+
			"\n"+
			"		MASTER_CPU = \"master\";\n"+
			"       CUSTOM_STARTUP_CODE = TRUE;\n" +
			"\n"+
			"		CPU_DATA = TRICORE {\n"+
			"			ID = \"master\";\n"+
			"			STARTUP_ADDRESS = \"master_startup\";\n"+
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
			"			STARTUP_ADDRESS = \"slave_startup\";\n"+
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
			"        RESOURCE = MUTEX_1;\n" + 
			"        RESOURCE = MUTEX_2;\n" + 
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
			"        RESOURCE = MUTEX_2;\n" + 
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
//			"        RESOURCE = MUTEX_2;\n" + 
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
//			"        RESOURCE = MUTEX_2;\n" + 
			"	};\n"+
			"\n"+
			"	TASK TaskSlave2b {\n"+
			"		CPU_ID = \"slave2\";\n"+
			"		PRIORITY = 3;\n"+
			"		AUTOSTART = FALSE;\n"+
			"        STACK = PRIVATE {\n" +
			"            SYS_SIZE = 256;\n" +
			"        };\n" +
			"        RESOURCE = MUTEX_3;\n" + 
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"    RESOURCE MUTEX_1 { RESOURCEPROPERTY = STANDARD; };\n" + 
			"    RESOURCE MUTEX_2 { RESOURCEPROPERTY = STANDARD; };\n" + 
			"    RESOURCE MUTEX_3 { RESOURCEPROPERTY = STANDARD; };\n" + 
			"    SPINLOCK MUTEX_1 {  };\n" + 
			"    SPINLOCK MUTEX_2 {  };\n" + 
			"    SPINLOCK MUTEX_3 { NEXT_SPINLOCK=MUTEX_2; };\n" + 
			"};\n";
		commonWriterTest(text, 3);
	}

	@Test public void testTc27xOsApplMultiCore_restartTask() {
	    final String text = "CPU test_application {\n" +
	    		"\n" +
	    		"  OS EE {\n" +
	    		"    EE_OPT = \"EE_DEBUG\";\n" +
	    		"    EE_OPT = \"__ASSERT__\";\n" +
	    		"    EE_OPT = \"EE_EXECUTE_FROM_RAM\";\n" +
	    		"\n" +
	    		"    REMOTENOTIFICATION = USE_RPC;\n" +
	    		"\n" +
	    		"    MASTER_CPU = \"master\";\n" +
	    		"\n" +
	    		"    CPU_DATA = TRICORE {\n" +
	    		"      ID = \"master\";\n" +
	    		"      CPU_CLOCK = 200.0;\n" +
	    		"      APP_SRC = \"custom_cstart.c\";\n" +
	    		"      APP_SRC = \"master.c\";\n" +
	    		"      MULTI_STACK = TRUE;\n" +
	    		"      SYS_STACK_SIZE = 4096;\n" +
	    		"      COMPILER_TYPE = GNU;\n" +
	    		"    };\n" +
	    		"\n" +
	    		"    CPU_DATA = TRICORE {\n" +
	    		"      ID = \"slave1\";\n" +
	    		"      APP_SRC = \"custom_cstart.c\";\n" +
	    		"      APP_SRC = \"slave1.c\";\n" +
	    		"      MULTI_STACK = TRUE;\n" +
	    		"      SYS_STACK_SIZE = 4096;\n" +
	    		"      COMPILER_TYPE = GNU;\n" +
	    		"    };\n" +
	    		"\n" +
	    		"    CPU_DATA = TRICORE {\n" +
	    		"      ID = \"slave2\";\n" +
	    		"      APP_SRC = \"custom_cstart.c\";\n" +
	    		"      APP_SRC = \"slave2.c\";\n" +
	    		"      MULTI_STACK = TRUE;\n" +
	    		"      SYS_STACK_SIZE = 4096;\n" +
	    		"      COMPILER_TYPE = GNU;\n" +
	    		"    };\n" +
	    		"\n" +
	    		"    MCU_DATA = TRICORE {\n" +
	    		"      MODEL = TC27x;\n" +
	    		"    };\n" +
	    		"\n" +
	    		"    STATUS = STANDARD;\n" +
	    		"    KERNEL_TYPE = BCC1;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  TASK TaskMaster {\n" +
	    		"    CPU_ID = \"master\";\n" +
	    		"    PRIORITY = 1;\n" +
	    		"    AUTOSTART = TRUE;\n" +
	    		"    STACK = SHARED;\n" +
	    		"    ACTIVATION = 1;\n" +
	    		"    SCHEDULE = FULL;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  TASK TaskSlave1 {\n" +
	    		"    CPU_ID = \"slave1\";\n" +
	    		"    PRIORITY = 1;\n" +
	    		"    AUTOSTART = FALSE;\n" +
	    		"    STACK = SHARED;\n" +
	    		"    ACTIVATION = 1;\n" +
	    		"    SCHEDULE = FULL;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  TASK TaskSlave2a {\n" +
	    		"    CPU_ID = \"slave2\";\n" +
	    		"    PRIORITY = 1;\n" +
	    		"    AUTOSTART = FALSE;\n" +
	    		"    STACK = SHARED;\n" +
	    		"    ACTIVATION = 1;\n" +
	    		"    SCHEDULE = FULL;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  TASK TaskSlave2b {\n" +
	    		"    CPU_ID = \"slave2\";\n" +
	    		"    PRIORITY = 1;\n" +
	    		"    AUTOSTART = FALSE;\n" +
	    		"    STACK = SHARED;\n" +
	    		"    ACTIVATION = 1;\n" +
	    		"    SCHEDULE = FULL;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  ISR STM0_isr2_core0 {\n" +
	    		"    CPU_ID = \"master\";\n" +
	    		"    CATEGORY = 2;\n" +
	    		"    PRIORITY = 2;\n" +
	    		"    HANDLER = \"STM0_isr2\"; // IRQ handler \n" +
	    		"  };\n" +
	    		"\n" +
	    		"  ISR STM0_isr2_core1 {\n" +
	    		"    CPU_ID = \"slave1\";\n" +
	    		"    CATEGORY = 2;\n" +
	    		"    PRIORITY = 2;\n" +
	    		"    HANDLER = \"STM0_isr2\"; // IRQ handler \n" +
	    		"  };\n" +
	    		"\n" +
	    		"  ISR STM0_isr2_core2 {\n" +
	    		"    CPU_ID = \"slave2\";\n" +
	    		"    CATEGORY = 2;\n" +
	    		"    PRIORITY = 2;\n" +
	    		"    HANDLER = \"STM0_isr2\"; // IRQ handler \n" +
	    		"  };\n" +
	    		"\n" +
	    		"  APPLICATION MasterApplication {\n" +
	    		"    CPU_ID = \"master\";\n" +
	    		"    TRUSTED = TRUE;\n" +
	    		"    ISR = STM0_isr2_core0;\n" +
	    		"    TASK = TaskMaster;\n" +
	    		"  MEMORY_BASE = \"0x70030000\";\n" +
	    		"    MEMORY_SIZE = 0x00010000;\n" +
	    		"    SHARED_STACK_SIZE = 512;\n" +
	    		"    IRQ_STACK_SIZE = 512;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  APPLICATION Slave1Application {\n" +
	    		"    CPU_ID = \"slave1\";\n" +
	    		"    TRUSTED = TRUE;\n" +
	    		"    ISR = STM0_isr2_core1;\n" +
	    		"    TASK = TaskSlave1;\n" +
	    		"//  MEMORY_BASE = 0x60030000;\n" +
	    		"//  MEMORY_SIZE = 0x00010000;\n" +
	    		"    SHARED_STACK_SIZE = 512;\n" +
	    		"    IRQ_STACK_SIZE = 512;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  APPLICATION Slave2aApplication {\n" +
	    		"    CPU_ID = \"slave2\";\n" +
	    		"    TRUSTED = TRUE;\n" +
	    		"    ISR = STM0_isr2_core2;\n" +
	    		"    TASK = TaskSlave2a;\n" +
	    		"    RESTARTTASK = TaskSlave2a;\n" +
	    		"//  MEMORY_BASE = 0x50030000;\n" +
	    		"//  MEMORY_SIZE = 0x00010000;\n" +
	    		"    SHARED_STACK_SIZE = 512;\n" +
	    		"    IRQ_STACK_SIZE = 512;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  APPLICATION Slave2bApplication {\n" +
	    		"    CPU_ID = \"slave2\";\n" +
	    		"    TRUSTED = TRUE;\n" +
	    		"    TASK = TaskSlave2b;\n" +
	    		"    RESTARTTASK = TaskSlave2b;\n" +
	    		"//  MEMORY_BASE = 0x50030000;\n" +
	    		"//  MEMORY_SIZE = 0x00010000;\n" +
	    		"    SHARED_STACK_SIZE = 512;\n" +
	    		"    IRQ_STACK_SIZE = 512;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"};\n";
		commonWriterTest(text, 3);
	}
	
	@Test public void testTc27xOsApplMultiCore() {
	    final String text = "CPU test_application {\n" +
	    		"\n" +
	    		"  OS EE {\n" +
	    		"    EE_OPT = \"EE_DEBUG\";\n" +
	    		"    EE_OPT = \"__ASSERT__\";\n" +
	    		"    EE_OPT = \"EE_EXECUTE_FROM_RAM\";\n" +
	    		"\n" +
	    		"    REMOTENOTIFICATION = USE_RPC;\n" +
	    		"\n" +
	    		"    MASTER_CPU = \"master\";\n" +
	    		"\n" +
	    		"    CPU_DATA = TRICORE {\n" +
	    		"      ID = \"master\";\n" +
	    		"      CPU_CLOCK = 200.0;\n" +
	    		"      APP_SRC = \"custom_cstart.c\";\n" +
	    		"      APP_SRC = \"master.c\";\n" +
	    		"      MULTI_STACK = TRUE;\n" +
	    		"      SYS_STACK_SIZE = 4096;\n" +
	    		"      COMPILER_TYPE = GNU;\n" +
	    		"    };\n" +
	    		"\n" +
	    		"    CPU_DATA = TRICORE {\n" +
	    		"      ID = \"slave1\";\n" +
	    		"      APP_SRC = \"custom_cstart.c\";\n" +
	    		"      APP_SRC = \"slave1.c\";\n" +
	    		"      MULTI_STACK = TRUE;\n" +
	    		"      SYS_STACK_SIZE = 4096;\n" +
	    		"      COMPILER_TYPE = GNU;\n" +
	    		"    };\n" +
	    		"\n" +
	    		"    CPU_DATA = TRICORE {\n" +
	    		"      ID = \"slave2\";\n" +
	    		"      APP_SRC = \"custom_cstart.c\";\n" +
	    		"      APP_SRC = \"slave2.c\";\n" +
	    		"      MULTI_STACK = TRUE;\n" +
	    		"      SYS_STACK_SIZE = 4096;\n" +
	    		"      COMPILER_TYPE = GNU;\n" +
	    		"    };\n" +
	    		"\n" +
	    		"    MCU_DATA = TRICORE {\n" +
	    		"      MODEL = TC27x;\n" +
	    		"    };\n" +
	    		"\n" +
	    		"    STATUS = STANDARD;\n" +
	    		"    KERNEL_TYPE = BCC1;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  TASK TaskMaster {\n" +
	    		"    CPU_ID = \"master\";\n" +
	    		"    PRIORITY = 1;\n" +
	    		"    AUTOSTART = TRUE;\n" +
	    		"    STACK = SHARED;\n" +
	    		"    ACTIVATION = 1;\n" +
	    		"    SCHEDULE = FULL;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  TASK TaskSlave1 {\n" +
	    		"    CPU_ID = \"slave1\";\n" +
	    		"    PRIORITY = 1;\n" +
	    		"    AUTOSTART = FALSE;\n" +
	    		"    STACK = SHARED;\n" +
	    		"    ACTIVATION = 1;\n" +
	    		"    SCHEDULE = FULL;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  TASK TaskSlave2a {\n" +
	    		"    CPU_ID = \"slave2\";\n" +
	    		"    PRIORITY = 1;\n" +
	    		"    AUTOSTART = FALSE;\n" +
	    		"    STACK = SHARED;\n" +
	    		"    ACTIVATION = 1;\n" +
	    		"    SCHEDULE = FULL;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  TASK TaskSlave2b {\n" +
	    		"    CPU_ID = \"slave2\";\n" +
	    		"    PRIORITY = 1;\n" +
	    		"    AUTOSTART = FALSE;\n" +
	    		"    STACK = SHARED;\n" +
	    		"    ACTIVATION = 1;\n" +
	    		"    SCHEDULE = FULL;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  ISR STM0_isr2_core0 {\n" +
	    		"    CPU_ID = \"master\";\n" +
	    		"    CATEGORY = 2;\n" +
	    		"    PRIORITY = 2;\n" +
	    		"    HANDLER = \"STM0_isr2\"; // IRQ handler \n" +
	    		"  };\n" +
	    		"\n" +
	    		"  ISR STM0_isr2_core1 {\n" +
	    		"    CPU_ID = \"slave1\";\n" +
	    		"    CATEGORY = 2;\n" +
	    		"    PRIORITY = 2;\n" +
	    		"    HANDLER = \"STM0_isr2\"; // IRQ handler \n" +
	    		"  };\n" +
	    		"\n" +
	    		"  ISR STM0_isr2_core2 {\n" +
	    		"    CPU_ID = \"slave2\";\n" +
	    		"    CATEGORY = 2;\n" +
	    		"    PRIORITY = 2;\n" +
	    		"    HANDLER = \"STM0_isr2\"; // IRQ handler \n" +
	    		"  };\n" +
	    		"\n" +
	    		"  APPLICATION MasterApplication {\n" +
	    		"    CPU_ID = \"master\";\n" +
	    		"    TRUSTED = TRUE;\n" +
	    		"    ISR = STM0_isr2_core0;\n" +
	    		"    TASK = TaskMaster;\n" +
	    		"//  MEMORY_BASE = 0x70030000;\n" +
	    		"//  MEMORY_SIZE = 0x00010000;\n" +
	    		"    SHARED_STACK_SIZE = 512;\n" +
	    		"    IRQ_STACK_SIZE = 512;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  APPLICATION Slave1Application {\n" +
	    		"    CPU_ID = \"slave1\";\n" +
	    		"    TRUSTED = TRUE;\n" +
	    		"    ISR = STM0_isr2_core1;\n" +
	    		"    TASK = TaskSlave1;\n" +
	    		"//  MEMORY_BASE = 0x60030000;\n" +
	    		"//  MEMORY_SIZE = 0x00010000;\n" +
	    		"    SHARED_STACK_SIZE = 512;\n" +
	    		"    IRQ_STACK_SIZE = 512;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  APPLICATION Slave2aApplication {\n" +
	    		"    CPU_ID = \"slave2\";\n" +
	    		"    TRUSTED = TRUE;\n" +
	    		"    ISR = STM0_isr2_core2;\n" +
	    		"    TASK = TaskSlave2a;\n" +
	    		"//  MEMORY_BASE = 0x50030000;\n" +
	    		"//  MEMORY_SIZE = 0x00010000;\n" +
	    		"    SHARED_STACK_SIZE = 512;\n" +
	    		"    IRQ_STACK_SIZE = 512;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  APPLICATION Slave2bApplication {\n" +
	    		"    CPU_ID = \"slave2\";\n" +
	    		"    TRUSTED = TRUE;\n" +
	    		"    TASK = TaskSlave2b;\n" +
	    		"//  MEMORY_BASE = 0x50030000;\n" +
	    		"//  MEMORY_SIZE = 0x00010000;\n" +
	    		"    SHARED_STACK_SIZE = 512;\n" +
	    		"    IRQ_STACK_SIZE = 512;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"};\n";
		commonWriterTest(text, 3);
	}
	

	@Test public void testTc27xOsApplMultiCore_accessMask() {
	    final String text = "CPU test_application {\n" +
	    		"\n" +
	    		"  OS EE {\n" +
	    		"    EE_OPT = \"EE_DEBUG\";\n" +
	    		"    EE_OPT = \"__ASSERT__\";\n" +
	    		"    EE_OPT = \"EE_EXECUTE_FROM_RAM\";\n" +
	    		"\n" +
	    		"    REMOTENOTIFICATION = USE_RPC;\n" +
	    		"\n" +
	    		"    MASTER_CPU = \"master\";\n" +
	    		"\n" +
	    		"    CPU_DATA = TRICORE {\n" +
	    		"      ID = \"master\";\n" +
	    		"      CPU_CLOCK = 200.0;\n" +
	    		"      APP_SRC = \"custom_cstart.c\";\n" +
	    		"      APP_SRC = \"master.c\";\n" +
	    		"      MULTI_STACK = TRUE;\n" +
	    		"      SYS_STACK_SIZE = 4096;\n" +
	    		"      COMPILER_TYPE = GNU;\n" +
	    		"    };\n" +
	    		"\n" +
	    		"    CPU_DATA = TRICORE {\n" +
	    		"      ID = \"slave1\";\n" +
	    		"      APP_SRC = \"custom_cstart.c\";\n" +
	    		"      APP_SRC = \"slave1.c\";\n" +
	    		"      MULTI_STACK = TRUE;\n" +
	    		"      SYS_STACK_SIZE = 4096;\n" +
	    		"      COMPILER_TYPE = GNU;\n" +
	    		"    };\n" +
	    		"\n" +
	    		"    CPU_DATA = TRICORE {\n" +
	    		"      ID = \"slave2\";\n" +
	    		"      APP_SRC = \"custom_cstart.c\";\n" +
	    		"      APP_SRC = \"slave2.c\";\n" +
	    		"      MULTI_STACK = TRUE;\n" +
	    		"      SYS_STACK_SIZE = 4096;\n" +
	    		"      COMPILER_TYPE = GNU;\n" +
	    		"    };\n" +
	    		"\n" +
	    		"    MCU_DATA = TRICORE {\n" +
	    		"      MODEL = TC27x;\n" +
	    		"    };\n" +
	    		"\n" +
	    		"    STATUS = STANDARD;\n" +
	    		"    KERNEL_TYPE = BCC1;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  TASK TaskMaster {\n" +
	    		"    CPU_ID = \"master\";\n" +
	    		"    PRIORITY = 1;\n" +
	    		"    AUTOSTART = TRUE;\n" +
	    		"    STACK = SHARED;\n" +
	    		"    ACTIVATION = 1;\n" +
	    		"    SCHEDULE = FULL;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  TASK TaskMaster_b {\n" +
	    		"    CPU_ID = \"master\";\n" +
	    		"    PRIORITY = 1;\n" +
	    		"    AUTOSTART = TRUE;\n" +
	    		"    STACK = SHARED;\n" +
	    		"    ACTIVATION = 1;\n" +
	    		"    SCHEDULE = FULL;\n" +
	    		"	 ACCESSING_APPLICATION = MasterApplication;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  TASK TaskSlave1 {\n" +
	    		"    CPU_ID = \"slave1\";\n" +
	    		"    PRIORITY = 1;\n" +
	    		"    AUTOSTART = FALSE;\n" +
	    		"    STACK = SHARED;\n" +
	    		"    ACTIVATION = 1;\n" +
	    		"    SCHEDULE = FULL;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  TASK TaskSlave2a {\n" +
	    		"    CPU_ID = \"slave2\";\n" +
	    		"    PRIORITY = 1;\n" +
	    		"    AUTOSTART = FALSE;\n" +
	    		"    STACK = SHARED;\n" +
	    		"    ACTIVATION = 1;\n" +
	    		"    SCHEDULE = FULL;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  TASK TaskSlave2b {\n" +
	    		"    CPU_ID = \"slave2\";\n" +
	    		"    PRIORITY = 1;\n" +
	    		"    AUTOSTART = FALSE;\n" +
	    		"    STACK = SHARED;\n" +
	    		"    ACTIVATION = 1;\n" +
	    		"    SCHEDULE = FULL;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  ISR STM0_isr2_core0 {\n" +
	    		"    CPU_ID = \"master\";\n" +
	    		"    CATEGORY = 2;\n" +
	    		"    PRIORITY = 2;\n" +
	    		"    HANDLER = \"STM0_isr2\"; // IRQ handler \n" +
	    		"  };\n" +
	    		"\n" +
	    		"  ISR STM0_isr2_core1 {\n" +
	    		"    CPU_ID = \"slave1\";\n" +
	    		"    CATEGORY = 2;\n" +
	    		"    PRIORITY = 2;\n" +
	    		"    HANDLER = \"STM0_isr2\"; // IRQ handler \n" +
	    		"  };\n" +
	    		"\n" +
	    		"  ISR STM0_isr2_core2 {\n" +
	    		"    CPU_ID = \"slave2\";\n" +
	    		"    CATEGORY = 2;\n" +
	    		"    PRIORITY = 2;\n" +
	    		"    HANDLER = \"STM0_isr2\"; // IRQ handler \n" +
	    		"  };\n" +
	    		"\n" +
	    		"  APPLICATION MasterApplication {\n" +
	    		"    CPU_ID = \"master\";\n" +
	    		"    TRUSTED = TRUE;\n" +
	    		"    ISR = STM0_isr2_core0;\n" +
	    		"    TASK = TaskMaster;\n" +
	    		"//  MEMORY_BASE = 0x70030000;\n" +
	    		"//  MEMORY_SIZE = 0x00010000;\n" +
	    		"    SHARED_STACK_SIZE = 512;\n" +
	    		"    IRQ_STACK_SIZE = 512;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  APPLICATION MasterApplication_b {\n" +
	    		"    CPU_ID = \"master\";\n" +
	    		"    TRUSTED = TRUE;\n" +
	    		"    TASK = TaskMaster_b;\n" +
	    		"//  MEMORY_BASE = 0x70030000;\n" +
	    		"//  MEMORY_SIZE = 0x00010000;\n" +
	    		"    SHARED_STACK_SIZE = 512;\n" +
	    		"    IRQ_STACK_SIZE = 512;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  APPLICATION Slave1Application {\n" +
	    		"    CPU_ID = \"slave1\";\n" +
	    		"    TRUSTED = TRUE;\n" +
	    		"    ISR = STM0_isr2_core1;\n" +
	    		"    TASK = TaskSlave1;\n" +
	    		"//  MEMORY_BASE = 0x60030000;\n" +
	    		"//  MEMORY_SIZE = 0x00010000;\n" +
	    		"    SHARED_STACK_SIZE = 512;\n" +
	    		"    IRQ_STACK_SIZE = 512;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  APPLICATION Slave2aApplication {\n" +
	    		"    CPU_ID = \"slave2\";\n" +
	    		"    TRUSTED = TRUE;\n" +
	    		"    ISR = STM0_isr2_core2;\n" +
	    		"    TASK = TaskSlave2a;\n" +
	    		"//  MEMORY_BASE = 0x50030000;\n" +
	    		"//  MEMORY_SIZE = 0x00010000;\n" +
	    		"    SHARED_STACK_SIZE = 512;\n" +
	    		"    IRQ_STACK_SIZE = 512;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  APPLICATION Slave2bApplication {\n" +
	    		"    CPU_ID = \"slave2\";\n" +
	    		"    TRUSTED = TRUE;\n" +
	    		"    TASK = TaskSlave2b;\n" +
	    		"//  MEMORY_BASE = 0x50030000;\n" +
	    		"//  MEMORY_SIZE = 0x00010000;\n" +
	    		"    SHARED_STACK_SIZE = 512;\n" +
	    		"    IRQ_STACK_SIZE = 512;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"};\n";
		commonWriterTest(text, 3);
	}
	@Test public void testTc27xOsApplMultiCore_accessMask2() {
	    final String text = "CPU test_application {\n" +
	    		"\n" +
	    		"  OS EE {\n" +
	    		"    EE_OPT = \"EE_DEBUG\";\n" +
	    		"    EE_OPT = \"__ASSERT__\";\n" +
	    		"    EE_OPT = \"EE_EXECUTE_FROM_RAM\";\n" +
	    		"\n" +
	    		"    REMOTENOTIFICATION = USE_RPC;\n" +
	    		"    SERVICE_PROTECTION = TRUE;\n" +
	    		"\n" +
	    		"    MASTER_CPU = \"master\";\n" +
	    		"\n" +
	    		"    CPU_DATA = TRICORE {\n" +
	    		"      ID = \"master\";\n" +
	    		"      CPU_CLOCK = 200.0;\n" +
	    		"      APP_SRC = \"custom_cstart.c\";\n" +
	    		"      APP_SRC = \"master.c\";\n" +
	    		"      MULTI_STACK = TRUE;\n" +
	    		"      SYS_STACK_SIZE = 4096;\n" +
	    		"      COMPILER_TYPE = GNU;\n" +
	    		"    };\n" +
	    		"\n" +
	    		"    CPU_DATA = TRICORE {\n" +
	    		"      ID = \"slave1\";\n" +
	    		"      APP_SRC = \"custom_cstart.c\";\n" +
	    		"      APP_SRC = \"slave1.c\";\n" +
	    		"      MULTI_STACK = TRUE;\n" +
	    		"      SYS_STACK_SIZE = 4096;\n" +
	    		"      COMPILER_TYPE = GNU;\n" +
	    		"    };\n" +
	    		"\n" +
	    		"    CPU_DATA = TRICORE {\n" +
	    		"      ID = \"slave2\";\n" +
	    		"      APP_SRC = \"custom_cstart.c\";\n" +
	    		"      APP_SRC = \"slave2.c\";\n" +
	    		"      MULTI_STACK = TRUE;\n" +
	    		"      SYS_STACK_SIZE = 4096;\n" +
	    		"      COMPILER_TYPE = GNU;\n" +
	    		"    };\n" +
	    		"\n" +
	    		"    MCU_DATA = TRICORE {\n" +
	    		"      MODEL = TC27x;\n" +
	    		"    };\n" +
	    		"\n" +
	    		"    STATUS = STANDARD;\n" +
	    		"    KERNEL_TYPE = BCC1;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  TASK TaskMaster {\n" +
	    		"    CPU_ID = \"master\";\n" +
	    		"    PRIORITY = 1;\n" +
	    		"    AUTOSTART = TRUE;\n" +
	    		"    STACK = SHARED;\n" +
	    		"    ACTIVATION = 1;\n" +
	    		"    SCHEDULE = FULL;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  TASK TaskMaster_b {\n" +
	    		"    CPU_ID = \"master\";\n" +
	    		"    PRIORITY = 1;\n" +
	    		"    AUTOSTART = TRUE;\n" +
	    		"    STACK = SHARED;\n" +
	    		"    ACTIVATION = 1;\n" +
	    		"    SCHEDULE = FULL;\n" +
	    		"	 ACCESSING_APPLICATION = MasterApplication;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  TASK TaskSlave1 {\n" +
	    		"    CPU_ID = \"slave1\";\n" +
	    		"    PRIORITY = 1;\n" +
	    		"    AUTOSTART = FALSE;\n" +
	    		"    STACK = SHARED;\n" +
	    		"    ACTIVATION = 1;\n" +
	    		"    SCHEDULE = FULL;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  TASK TaskSlave2a {\n" +
	    		"    CPU_ID = \"slave2\";\n" +
	    		"    PRIORITY = 1;\n" +
	    		"    AUTOSTART = FALSE;\n" +
	    		"    STACK = SHARED;\n" +
	    		"    ACTIVATION = 1;\n" +
	    		"    SCHEDULE = FULL;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  TASK TaskSlave2b {\n" +
	    		"    CPU_ID = \"slave2\";\n" +
	    		"    PRIORITY = 1;\n" +
	    		"    AUTOSTART = FALSE;\n" +
	    		"    STACK = SHARED;\n" +
	    		"    ACTIVATION = 1;\n" +
	    		"    SCHEDULE = FULL;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  ISR STM0_isr2_core0 {\n" +
	    		"    CPU_ID = \"master\";\n" +
	    		"    CATEGORY = 2;\n" +
	    		"    PRIORITY = 2;\n" +
	    		"    HANDLER = \"STM0_isr2\"; // IRQ handler \n" +
	    		"  };\n" +
	    		"\n" +
	    		"  ISR STM0_isr2_core1 {\n" +
	    		"    CPU_ID = \"slave1\";\n" +
	    		"    CATEGORY = 2;\n" +
	    		"    PRIORITY = 2;\n" +
	    		"    HANDLER = \"STM0_isr2\"; // IRQ handler \n" +
	    		"  };\n" +
	    		"\n" +
	    		"  ISR STM0_isr2_core2 {\n" +
	    		"    CPU_ID = \"slave2\";\n" +
	    		"    CATEGORY = 2;\n" +
	    		"    PRIORITY = 2;\n" +
	    		"    HANDLER = \"STM0_isr2\"; // IRQ handler \n" +
	    		"  };\n" +
	    		"\n" +
	    		"  APPLICATION MasterApplication {\n" +
	    		"    CPU_ID = \"master\";\n" +
	    		"    TRUSTED = TRUE;\n" +
	    		"    ISR = STM0_isr2_core0;\n" +
	    		"    TASK = TaskMaster;\n" +
	    		"//  MEMORY_BASE = 0x70030000;\n" +
	    		"//  MEMORY_SIZE = 0x00010000;\n" +
	    		"    SHARED_STACK_SIZE = 512;\n" +
	    		"    IRQ_STACK_SIZE = 512;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  APPLICATION MasterApplication_b {\n" +
	    		"    CPU_ID = \"master\";\n" +
	    		"    TRUSTED = TRUE;\n" +
	    		"    TASK = TaskMaster_b;\n" +
	    		"//  MEMORY_BASE = 0x70030000;\n" +
	    		"//  MEMORY_SIZE = 0x00010000;\n" +
	    		"    SHARED_STACK_SIZE = 512;\n" +
	    		"    IRQ_STACK_SIZE = 512;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  APPLICATION Slave1Application {\n" +
	    		"    CPU_ID = \"slave1\";\n" +
	    		"    TRUSTED = TRUE;\n" +
	    		"    ISR = STM0_isr2_core1;\n" +
	    		"    TASK = TaskSlave1;\n" +
	    		"//  MEMORY_BASE = 0x60030000;\n" +
	    		"//  MEMORY_SIZE = 0x00010000;\n" +
	    		"    SHARED_STACK_SIZE = 512;\n" +
	    		"    IRQ_STACK_SIZE = 512;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  APPLICATION Slave2aApplication {\n" +
	    		"    CPU_ID = \"slave2\";\n" +
	    		"    TRUSTED = TRUE;\n" +
	    		"    ISR = STM0_isr2_core2;\n" +
	    		"    TASK = TaskSlave2a;\n" +
	    		"//  MEMORY_BASE = 0x50030000;\n" +
	    		"//  MEMORY_SIZE = 0x00010000;\n" +
	    		"    SHARED_STACK_SIZE = 512;\n" +
	    		"    IRQ_STACK_SIZE = 512;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  APPLICATION Slave2bApplication {\n" +
	    		"    CPU_ID = \"slave2\";\n" +
	    		"    TRUSTED = TRUE;\n" +
	    		"    TASK = TaskSlave2b;\n" +
	    		"//  MEMORY_BASE = 0x50030000;\n" +
	    		"//  MEMORY_SIZE = 0x00010000;\n" +
	    		"    SHARED_STACK_SIZE = 512;\n" +
	    		"    IRQ_STACK_SIZE = 512;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"};\n";
		commonWriterTest(text, 3);
	}
	
	@Test public void testTc27xOsApplMultiCore_accessMask_sysTimer() {
	    final String text = "CPU test_application {\n" +
	    		"\n" +
	    		"  OS EE {\n" +
	    		"    EE_OPT = \"EE_DEBUG\";\n" +
	    		"    EE_OPT = \"__ASSERT__\";\n" +
	    		"    EE_OPT = \"EE_EXECUTE_FROM_RAM\";\n" +
	    		"\n" +
	    		"    REMOTENOTIFICATION = USE_RPC;\n" +
	    		"    SERVICE_PROTECTION = TRUE;\n" +
	    		"\n" +
	    		"    MASTER_CPU = \"master\";\n" +
	    		"\n" +
	    		"    CPU_DATA = TRICORE {\n" +
	    		"      ID = \"master\";\n" +
	    		"      CPU_CLOCK = 200.0;\n" +
	    		"      APP_SRC = \"custom_cstart.c\";\n" +
	    		"      APP_SRC = \"master.c\";\n" +
	    		"      MULTI_STACK = TRUE;\n" +
	    		"      SYS_STACK_SIZE = 4096;\n" +
	    		"      COMPILER_TYPE = GNU;\n" +
	    		"    };\n" +
	    		"\n" +
	    		"    CPU_DATA = TRICORE {\n" +
	    		"      ID = \"slave1\";\n" +
	    		"      APP_SRC = \"custom_cstart.c\";\n" +
	    		"      APP_SRC = \"slave1.c\";\n" +
	    		"      MULTI_STACK = TRUE;\n" +
	    		"      SYS_STACK_SIZE = 4096;\n" +
	    		"      COMPILER_TYPE = GNU;\n" +
	    		"    };\n" +
	    		"\n" +
	    		"    CPU_DATA = TRICORE {\n" +
	    		"      ID = \"slave2\";\n" +
	    		"      APP_SRC = \"custom_cstart.c\";\n" +
	    		"      APP_SRC = \"slave2.c\";\n" +
	    		"      MULTI_STACK = TRUE;\n" +
	    		"      SYS_STACK_SIZE = 4096;\n" +
	    		"      COMPILER_TYPE = GNU;\n" +
	    		"    };\n" +
	    		"\n" +
	    		"    MCU_DATA = TRICORE {\n" +
	    		"      MODEL = TC27x;\n" +
	    		"    };\n" +
	    		"\n" +
	    		"    STATUS = STANDARD;\n" +
	    		"    KERNEL_TYPE = BCC1;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  TASK TaskMaster {\n" +
	    		"    CPU_ID = \"master\";\n" +
	    		"    PRIORITY = 1;\n" +
	    		"    AUTOSTART = TRUE;\n" +
	    		"    STACK = SHARED;\n" +
	    		"    ACTIVATION = 1;\n" +
	    		"    SCHEDULE = FULL;\n" +
	    		"	 ACCESSING_APPLICATION = MasterApplication_b;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  TASK TaskMaster_b {\n" +
	    		"    CPU_ID = \"master\";\n" +
	    		"    PRIORITY = 1;\n" +
	    		"    AUTOSTART = TRUE;\n" +
	    		"    STACK = SHARED;\n" +
	    		"    ACTIVATION = 1;\n" +
	    		"    SCHEDULE = FULL;\n" +
	    		"	 ACCESSING_APPLICATION = MasterApplication;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  TASK TaskSlave1 {\n" +
	    		"    CPU_ID = \"slave1\";\n" +
	    		"    PRIORITY = 1;\n" +
	    		"    AUTOSTART = FALSE;\n" +
	    		"    STACK = SHARED;\n" +
	    		"    ACTIVATION = 1;\n" +
	    		"    SCHEDULE = FULL;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  TASK TaskSlave2a {\n" +
	    		"    CPU_ID = \"slave2\";\n" +
	    		"    PRIORITY = 1;\n" +
	    		"    AUTOSTART = FALSE;\n" +
	    		"    STACK = SHARED;\n" +
	    		"    ACTIVATION = 1;\n" +
	    		"    SCHEDULE = FULL;\n" +
	    		"	 ACCESSING_APPLICATION = MasterApplication;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  TASK TaskSlave2b {\n" +
	    		"    CPU_ID = \"slave2\";\n" +
	    		"    PRIORITY = 1;\n" +
	    		"    AUTOSTART = FALSE;\n" +
	    		"    STACK = SHARED;\n" +
	    		"    ACTIVATION = 1;\n" +
	    		"    SCHEDULE = FULL;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  ISR STM0_isr2_core0 {\n" +
	    		"    CPU_ID = \"master\";\n" +
	    		"    CATEGORY = 2;\n" +
	    		"    PRIORITY = 2;\n" +
	    		"    HANDLER = \"STM0_isr2\"; // IRQ handler \n" +
	    		"  };\n" +
	    		"\n" +
	    		"  ISR STM0_isr2_core1 {\n" +
	    		"    CPU_ID = \"slave1\";\n" +
	    		"    CATEGORY = 2;\n" +
	    		"    PRIORITY = 2;\n" +
	    		"    HANDLER = \"STM0_isr2\"; // IRQ handler \n" +
	    		"  };\n" +
	    		"\n" +
	    		"  ISR STM0_isr2_core2 {\n" +
	    		"    CPU_ID = \"slave2\";\n" +
	    		"    CATEGORY = 2;\n" +
	    		"    PRIORITY = 2;\n" +
	    		"    HANDLER = \"STM0_isr2\"; // IRQ handler \n" +
	    		"  };\n" +
	    		"\n" +
	    		
				"    EVENT TimerEvent  { MASK = AUTO; };\n" +
				"    EVENT ButtonEvent { MASK = AUTO; };\n" +
				"\n" +
				"    COUNTER system_timer {\n" +
	    		"        CPU_ID = \"master\";\n" +
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
				"    SCHEDULETABLE SchedTab1 {\n" +
	    		"        CPU_ID = \"master\";\n" +
				"        DURATION = 10;\n" +
				"        REPEATING = TRUE;\n" +
				"        COUNTER = system_timer;\n" +
				"        EXPIRE_POINT = ACTION {\n" +
				"        		EXPIRE_VALUE = 3;\n" +
				"        		ACTION = SETEVENT     { TASK = TaskMaster; EVENT = TimerEvent; };\n" +
				"        		ACTION = ACTIVATETASK { TASK = TaskMaster_b; };\n" +
				"    	 };\n" +
				"        EXPIRE_POINT = ACTION {\n" +
				"        		EXPIRE_VALUE = 6;\n" +
				"        		ACTION = SETEVENT     { TASK = TaskMaster_b; EVENT = TimerEvent; };\n" +
				"        		ACTION = ACTIVATETASK { TASK = TaskSlave2a; };\n" +
				"        		SYNC_ADJUSTMENT = TRUE { MAX_POSOSITIVE_ADJ = 1; MAX_NEGATIVE_ADJ = 2; };\n" +
				"    	 };\n" +
				"        AUTOSTART = TRUE { START_VALUE = 25; TYPE = ABSOLUTE; };\n" +
				"    };\n" +
				"\n" +
				"    SCHEDULETABLE SchedTab2 {\n" +
	    		"        CPU_ID = \"master\";\n" +
				"        DURATION = 20;\n" +
				"        REPEATING = TRUE;\n" +
				"        COUNTER = system_timer;\n" +
				"        EXPIRE_POINT = ACTION {\n" +
				"        		EXPIRE_VALUE = 4;\n" +
				"        		ACTION = SETEVENT     { TASK = TaskMaster; EVENT = TimerEvent; };\n" +
				"    	 };\n" +
				"        EXPIRE_POINT = ACTION {\n" +
				"        		EXPIRE_VALUE = 7;\n" +
				"        		ACTION = ACTIVATETASK { TASK = TaskMaster; };\n" +
				"        		SYNC_ADJUSTMENT = TRUE { MAX_POSOSITIVE_ADJ = 1; MAX_NEGATIVE_ADJ = 2; };\n" +
				"    	 };\n" +
				"        EXPIRE_POINT = ACTION {\n" +
				"        		EXPIRE_VALUE = 12;\n" +
				"        		ACTION = SETEVENT     { TASK = TaskMaster; EVENT = TimerEvent; };\n" +
				"        		ACTION = ACTIVATETASK { TASK = TaskMaster_b; };\n" +
				"    	 };\n" +
				"        EXPIRE_POINT = ACTION {\n" +
				"        		EXPIRE_VALUE = 16;\n" +
				"        		ACTION = ACTIVATETASK { TASK = TaskMaster; };\n" +
				"        		SYNC_ADJUSTMENT = TRUE { MAX_POSOSITIVE_ADJ = 1; MAX_NEGATIVE_ADJ = 2; };\n" +
				"    	 };\n" +
				"        AUTOSTART = TRUE { START_VALUE = 125; TYPE = SYNCHRON; };\n" +
				"        LOCAL_TO_GLOBAL_TIME_SYNCHRONIZATION = TRUE { EXPLICIT_PRECISION = 125; SYNC_STRATEGY = EXPLICIT; };\n" +
				"    };\n" +
				"\n" +
				"    ALARM AlarmTask1 {\n" +
				"        COUNTER = system_timer;\n" +
				"        ACTION = SETEVENT { TASK = TaskSlave2a; EVENT = TimerEvent; };\n" +
				"        AUTOSTART = TRUE { ALARMTIME = 250; CYCLETIME = 500; };\n" +
				"    };\n" +
				"\n" +
				"    ALARM AlarmTask2 {\n" +
				"        COUNTER = system_timer;\n" +
				"        ACTION = ACTIVATETASK { TASK = TaskMaster_b; };\n" +
				"        AUTOSTART = FALSE;\n" +
				"    };\n" +
	    		
				
	    		"  APPLICATION MasterApplication {\n" +
	    		"    CPU_ID = \"master\";\n" +
	    		"    TRUSTED = TRUE;\n" +
	    		"    ISR = STM0_isr2_core0;\n" +
	    		"    TASK = TaskMaster;\n" +
	    		"    SCHEDULETABLE = SchedTab1;\n" +
	    		"    ALARM = AlarmTask1;\n" +
	    		"    ALARM = AlarmTask2;\n" +
	    		"//  MEMORY_BASE = 0x70030000;\n" +
	    		"//  MEMORY_SIZE = 0x00010000;\n" +
	    		"    SHARED_STACK_SIZE = 512;\n" +
	    		"    IRQ_STACK_SIZE = 512;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  APPLICATION MasterApplication_b {\n" +
	    		"    CPU_ID = \"master\";\n" +
	    		"    TRUSTED = TRUE;\n" +
	    		"    TASK = TaskMaster_b;\n" +
	    		"    SCHEDULETABLE = SchedTab2;\n" +
	    		"//  MEMORY_BASE = 0x70030000;\n" +
	    		"//  MEMORY_SIZE = 0x00010000;\n" +
	    		"    SHARED_STACK_SIZE = 512;\n" +
	    		"    IRQ_STACK_SIZE = 512;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  APPLICATION Slave1Application {\n" +
	    		"    CPU_ID = \"slave1\";\n" +
	    		"    TRUSTED = TRUE;\n" +
	    		"    ISR = STM0_isr2_core1;\n" +
	    		"    TASK = TaskSlave1;\n" +
	    		"//  MEMORY_BASE = 0x60030000;\n" +
	    		"//  MEMORY_SIZE = 0x00010000;\n" +
	    		"    SHARED_STACK_SIZE = 512;\n" +
	    		"    IRQ_STACK_SIZE = 512;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  APPLICATION Slave2aApplication {\n" +
	    		"    CPU_ID = \"slave2\";\n" +
	    		"    TRUSTED = TRUE;\n" +
	    		"    ISR = STM0_isr2_core2;\n" +
	    		"    TASK = TaskSlave2a;\n" +
	    		"//  MEMORY_BASE = 0x50030000;\n" +
	    		"//  MEMORY_SIZE = 0x00010000;\n" +
	    		"    SHARED_STACK_SIZE = 512;\n" +
	    		"    IRQ_STACK_SIZE = 512;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  APPLICATION Slave2bApplication {\n" +
	    		"    CPU_ID = \"slave2\";\n" +
	    		"    TRUSTED = TRUE;\n" +
	    		"    TASK = TaskSlave2b;\n" +
	    		"//  MEMORY_BASE = 0x50030000;\n" +
	    		"//  MEMORY_SIZE = 0x00010000;\n" +
	    		"    SHARED_STACK_SIZE = 512;\n" +
	    		"    IRQ_STACK_SIZE = 512;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"};\n";
		commonWriterTest(text, 3);
	}

	
	@Test public void testTc27xMulticoreRpc() {
	    final String text = "CPU test_application {\n"+
			"\n"+
			"	OS EE {\n"+
			"		EE_OPT = \"__ASSERT__\";\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\";\n"+
			"		SPINLOCKS = QUEUED;\n"+
			"		REMOTENOTIFICATION = USE_RPC;\n"+
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
			"        RESOURCE = MUTEX_1;\n" + 
			"        RESOURCE = MUTEX_2;\n" + 
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
			"        RESOURCE = MUTEX_2;\n" + 
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
//			"        RESOURCE = MUTEX_2;\n" + 
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
//			"        RESOURCE = MUTEX_2;\n" + 
			"	};\n"+
			"\n"+
			"	TASK TaskSlave2b {\n"+
			"		CPU_ID = \"slave2\";\n"+
			"		PRIORITY = 3;\n"+
			"		AUTOSTART = FALSE;\n"+
			"        STACK = PRIVATE {\n" +
			"            SYS_SIZE = 256;\n" +
			"        };\n" +
			"        RESOURCE = MUTEX_3;\n" + 
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			
			"	COUNTER myCounter1 {\n" +
			"		CPU_ID = \"slave1\";\n" +
			"		MINCYCLE = 0;\n" +
			"		MAXALLOWEDVALUE = 10;\n" +
			"		TICKSPERBASE = 1;\n" +
			"	};\n" +
			"	COUNTER myCounter2 {\n" +
			"		CPU_ID = \"slave1\";\n" +
			"		MINCYCLE = 0;\n" +
			"		MAXALLOWEDVALUE = 10;\n" +
			"		TICKSPERBASE = 1;\n" +
			"	};\n" +
			"	COUNTER myCounter3 {\n" +
			"		CPU_ID = \"master\";\n" +
			"		MINCYCLE = 0;\n" +
			"		MAXALLOWEDVALUE = 10;\n" +
			"		TICKSPERBASE = 1;\n" +
			"	};\n" +
			"	COUNTER myCounter4 {\n" +
			"		CPU_ID = \"master\";\n" +
			"		MINCYCLE = 0;\n" +
			"		MAXALLOWEDVALUE = 10;\n" +
			"		TICKSPERBASE = 1;\n" +
			"	};\n" +
			"	ALARM alarm1 {\n" +
			"		COUNTER = myCounter1;\n" +
			"		ACTION = ACTIVATETASK { TASK = TaskSlave2a; };\n" +
			"	};\n" +

			"	ALARM AcquireAlarm2 {\n" +
			"		COUNTER = myCounter2;\n" +
			"		ACTION = INCREMENTCOUNTER { COUNTER = myCounter1; };\n" +
			"	};\n" +
			"	ALARM AcquireAlarm3 {\n" +
			"		COUNTER = myCounter3;\n" +
			"		ACTION = INCREMENTCOUNTER { COUNTER = myCounter4; };\n" +
			"	};\n" +
			"	ALARM AcquireAlarm4 {\n" +
			"		COUNTER = myCounter4;\n" +
			"		ACTION =  ACTIVATETASK { TASK = TaskSlave1a; };\n" +
			"	};\n" +
			"    RESOURCE MUTEX_1 { RESOURCEPROPERTY = STANDARD; };\n" + 
			"    RESOURCE MUTEX_2 { RESOURCEPROPERTY = STANDARD; };\n" + 
			"    RESOURCE MUTEX_3 { RESOURCEPROPERTY = STANDARD; };\n" + 
			"};\n";
		commonWriterTest(text, 3);
	}

		
	@Test public void testTc27xMulticoreRpcWithSpinlock() {
		String text = "CPU test_application {\n" +
				"\n" +
				"	OS EE {\n" +
				"    EE_OPT = \"EE_DEBUG\";\n" +
				"    EE_OPT = \"__ASSERT__\";\n" +
				"    EE_OPT = \"EE_EXECUTE_FROM_RAM\";\n" +
				"    EE_OPT = \"EE_ICACHE_ENABLED\";\n" +
				"    EE_OPT = \"EE_DCACHE_ENABLED\";\n" +
				"    EE_OPT = \"EE_AS_IOC__\";\n" +
				"\n" +
				"    REMOTENOTIFICATION = USE_RPC;\n" +
				"    MASTER_CPU = \"master\";\n" +
				"\n" +
				"    CPU_DATA = TRICORE {\n" +
				"      ID = \"master\";\n" +
				"      APP_SRC = \"master.c\";\n" +
				"      APP_SRC = \"ioc_common.c\";\n" +
				"      MULTI_STACK = TRUE;\n" +
				"      SYS_STACK_SIZE = 4096;\n" +
				"      COMPILER_TYPE = GNU;\n" +
				"    };\n" +
				"\n" +
				"    CPU_DATA = TRICORE {\n" +
				"      ID = \"slave1\";\n" +
				"      APP_SRC = \"slave1.c\";\n" +
				"      APP_SRC = \"ioc_slave1.c\";\n" +
				"      MULTI_STACK = TRUE;\n" +
				"      SYS_STACK_SIZE = 4096;\n" +
				"      COMPILER_TYPE = GNU;\n" +
				"    };\n" +
				"\n" +
				"    CPU_DATA = TRICORE {\n" +
				"      ID = \"slave2\";\n" +
				"      APP_SRC = \"slave2.c\";\n" +
				"      APP_SRC = \"ioc_slave2.c\";\n" +
				"      MULTI_STACK = TRUE;\n" +
				"      SYS_STACK_SIZE = 4096;\n" +
				"      COMPILER_TYPE = GNU;\n" +
				"    };\n" +
				"\n" +
				"    MCU_DATA = TRICORE {\n" +
				"      MODEL = TC27x;\n" +
				"    };\n" +
				"\n" +
				"    STATUS = EXTENDED;\n" +
				"    USERESSCHEDULER = FALSE;\n" +
				"\n" +
				"    ORTI_SECTIONS = ALL;\n" +
				"\n" +
				"    KERNEL_TYPE = BCC1;\n" +
				"  };\n" +
				"\n" +
				"	TASK TaskSend1 {\n" +
				"		CPU_ID = \"master\";\n" +
				"		PRIORITY = 0x02;\n" +
				"		AUTOSTART = TRUE;\n" +
				"		STACK = PRIVATE {\n" +
				"			SYS_SIZE = 128;\n" +
				"		};\n" +
				"		ACTIVATION = 1;\n" +
				"		SCHEDULE = FULL;\n" +
				"	};\n" +
				"\n" +
				"    TASK master_receive1 {\n" +
				"		CPU_ID = \"master\";\n" +
				"		PRIORITY = 0x04;\n" +
				"		AUTOSTART = FALSE;\n" +
				"		STACK = PRIVATE {\n" +
				"			SYS_SIZE = 128;\n" +
				"		};\n" +
				"		ACTIVATION = 1;\n" +
				"		SCHEDULE = FULL;\n" +
				"	};\n" +
				"\n" +
				"    TASK TaskSlave1 {\n" +
				"		CPU_ID = \"slave1\";\n" +
				"		PRIORITY = 0x2;\n" +
				"		AUTOSTART = FALSE;\n" +
				"		STACK = PRIVATE {\n" +
				"			SYS_SIZE = 128;\n" +
				"		};\n" +
				"		ACTIVATION = 1;\n" +
				"		SCHEDULE = FULL;\n" +
				"	};\n" +
				"\n" +
				"    TASK TaskSlave2 {\n" +
				"		CPU_ID = \"slave2\";\n" +
				"		PRIORITY = 0x2;\n" +
				"		AUTOSTART = FALSE;\n" +
				"		STACK = PRIVATE {\n" +
				"			SYS_SIZE = 128;\n" +
				"		};\n" +
				"		ACTIVATION = 1;\n" +
				"		SCHEDULE = FULL;\n" +
				"	};\n" +
				"\n" +
				"    SPINLOCK spinlock_1 { };\n" +
				"    SPINLOCK spinlock_2 { };\n" +
				"    SPINLOCK spinlock_3 { };\n" +
				"};\n";
		commonWriterTest(text, 3);
	}
	
	@Test public void testTc27xMulticoreBoard() {
		String text = "CPU test_application {\n" +
				"\n" +
				"	OS EE {\n" +
				"    EE_OPT = \"EE_DEBUG\";\n" +
				"    EE_OPT = \"__ASSERT__\";\n" +
				"    EE_OPT = \"EE_EXECUTE_FROM_RAM\";\n" +
				"    EE_OPT = \"EE_ICACHE_ENABLED\";\n" +
				"    EE_OPT = \"EE_DCACHE_ENABLED\";\n" +
				"    EE_OPT = \"EE_AS_IOC__\";\n" +
				"\n" +
				"    REMOTENOTIFICATION = USE_RPC;\n" +
				"    MASTER_CPU = \"master\";\n" +
				"\n" +
				"    CPU_DATA = TRICORE {\n" +
				"      ID = \"master\";\n" +
				"      APP_SRC = \"master.c\";\n" +
				"      APP_SRC = \"ioc_common.c\";\n" +
				"      MULTI_STACK = TRUE;\n" +
				"      SYS_STACK_SIZE = 4096;\n" +
				"      COMPILER_TYPE = GNU;\n" +
				"    };\n" +
				"\n" +
				"    CPU_DATA = TRICORE {\n" +
				"      ID = \"slave1\";\n" +
				"      APP_SRC = \"slave1.c\";\n" +
				"      APP_SRC = \"ioc_slave1.c\";\n" +
				"      MULTI_STACK = TRUE;\n" +
				"      SYS_STACK_SIZE = 4096;\n" +
				"      COMPILER_TYPE = GNU;\n" +
				"    };\n" +
				"\n" +
				"    CPU_DATA = TRICORE {\n" +
				"      ID = \"slave2\";\n" +
				"      APP_SRC = \"slave2.c\";\n" +
				"      APP_SRC = \"ioc_slave2.c\";\n" +
				"      MULTI_STACK = TRUE;\n" +
				"      SYS_STACK_SIZE = 4096;\n" +
				"      COMPILER_TYPE = GNU;\n" +
				"    };\n" +
				"\n" +
				"    MCU_DATA = TRICORE {\n" +
				"      MODEL = TC27x;\n" +
				"    };\n" +
				"    BOARD_DATA = TRIBOARD_TC2X5;\n" +
				"\n" +
				"    STATUS = EXTENDED;\n" +
				"    USERESSCHEDULER = FALSE;\n" +
				"\n" +
				"    ORTI_SECTIONS = ALL;\n" +
				"\n" +
				"    KERNEL_TYPE = BCC1;\n" +
				"  };\n" +
				"\n" +
				"	TASK TaskSend1 {\n" +
				"		CPU_ID = \"master\";\n" +
				"		PRIORITY = 0x02;\n" +
				"		AUTOSTART = TRUE;\n" +
				"		STACK = PRIVATE {\n" +
				"			SYS_SIZE = 128;\n" +
				"		};\n" +
				"		ACTIVATION = 1;\n" +
				"		SCHEDULE = FULL;\n" +
				"	};\n" +
				"\n" +
				"    TASK master_receive1 {\n" +
				"		CPU_ID = \"master\";\n" +
				"		PRIORITY = 0x04;\n" +
				"		AUTOSTART = FALSE;\n" +
				"		STACK = PRIVATE {\n" +
				"			SYS_SIZE = 128;\n" +
				"		};\n" +
				"		ACTIVATION = 1;\n" +
				"		SCHEDULE = FULL;\n" +
				"	};\n" +
				"\n" +
				"    TASK TaskSlave1 {\n" +
				"		CPU_ID = \"slave1\";\n" +
				"		PRIORITY = 0x2;\n" +
				"		AUTOSTART = FALSE;\n" +
				"		STACK = PRIVATE {\n" +
				"			SYS_SIZE = 128;\n" +
				"		};\n" +
				"		ACTIVATION = 1;\n" +
				"		SCHEDULE = FULL;\n" +
				"	};\n" +
				"\n" +
				"    TASK TaskSlave2 {\n" +
				"		CPU_ID = \"slave2\";\n" +
				"		PRIORITY = 0x2;\n" +
				"		AUTOSTART = FALSE;\n" +
				"		STACK = PRIVATE {\n" +
				"			SYS_SIZE = 128;\n" +
				"		};\n" +
				"		ACTIVATION = 1;\n" +
				"		SCHEDULE = FULL;\n" +
				"	};\n" +
				"};\n";
		commonWriterTest(text, 3);
	}
	
	@Test public void testTc27xMemoryProtection() {
		String text = "CPU PerfTestApp {\n" +
				"  OS EE {\n" +
				"    EE_OPT = \"EE_DEBUG\";\n" +
				"    EE_OPT = \"__ASSERT__\";\n" +
				"\n" +
				"    //EE_OPT = \"EE_EXECUTE_FROM_RAM\";\n" +
				"    EE_OPT = \"EE_SAVE_TEMP_FILES\";\n" +
				"    //EE_OPT = \"EE_MM_OPT\";\n" +
				"\n" +
				"    MEMORY_PROTECTION = TRUE;\n" +
				"\n" +
				"    CPU_DATA = TRICORE {\n" +
				"      CPU_CLOCK = 200.0;\n" +
				"      APP_SRC = \"code.c\";\n" +
				"      APP_SRC = \"app1.c\";\n" +
				"      APP_SRC = \"app2.c\";\n" +
				"      APP_SRC = \"trusted.c\";\n" +
				"      COMPILER_TYPE = GNU;\n" +
				"      MULTI_STACK = TRUE {\n" +
				"        IRQ_STACK = TRUE {\n" +
				"            SYS_SIZE = 128;\n" +
				"        };\n" +
				"      };\n" +
				"    };\n" +
				"\n" +
				"    MCU_DATA = TRICORE {\n" +
				"        MODEL = TC27x;\n" +
				"    };\n" +
				"\n" +
				"    STATUS = EXTENDED;\n" +
				"    USEGETSERVICEID = FALSE;\n" +
				"    USEPARAMETERACCESS = FALSE;\n" +
				"    USERESSCHEDULER = FALSE;\n" +
				"\n" +
				"    KERNEL_TYPE = BCC1;\n" +
				"\n" +
				"    ORTI_SECTIONS = ALL;\n" +
				"  };\n" +
				"\n" +
				"  TASK MainTask {\n" +
				"    PRIORITY = 10;\n" +
				"    ACTIVATION = 1;\n" +
				"    SCHEDULE = FULL;\n" +
				"    AUTOSTART = TRUE;\n" +
				"    STACK = SHARED;\n" +
				"  };\n" +
				"\n" +
				"  TASK TrustedTask1 {\n" +
				"    PRIORITY = 1;\n" +
				"    ACTIVATION = 1;\n" +
				"    SCHEDULE = FULL;\n" +
				"    AUTOSTART = FALSE;\n" +
				"    STACK = SHARED;\n" +
				"  };\n" +
				"\n" +
				"  TASK App1Task {\n" +
				"    PRIORITY = 4;\n" +
				"    ACTIVATION = 1;\n" +
				"    SCHEDULE = FULL;\n" +
				"    AUTOSTART = FALSE;\n" +
				"    STACK = SHARED;\n" +
				"  };\n" +
				"\n" +
				"  TASK App2Task {\n" +
				"    PRIORITY = 4;\n" +
				"    ACTIVATION = 1;\n" +
				"    SCHEDULE = FULL;\n" +
				"    AUTOSTART = FALSE;\n" +
				"    STACK = SHARED;\n" +
				"  };\n" +
				"\n" +
				"  ISR TrustedIsr {\n" +
				"    CATEGORY = 2;\n" +
				"    PRIORITY = 3;\n" +
				"  };\n" +
				"\n" +
				"  ISR App1Isr {\n" +
				"    CATEGORY = 2;\n" +
				"    PRIORITY = 2;\n" +
				"  };\n" +
				"\n" +
				"  ISR App2Isr {\n" +
				"    CATEGORY = 2;\n" +
				"    PRIORITY = 1;\n" +
				"  };\n" +
				"\n" +
				"  APPLICATION TrustedApp {\n" +
				"    TRUSTED = TRUE;\n" +
				"    ISR = TrustedIsr;\n" +
				"    TASK = MainTask;\n" +
				"    TASK = TrustedTask1;\n" +
				"    MEMORY_BASE = \"0x40010000\";\n" +
				"    MEMORY_SIZE = 0x10000;\n" +
				"    SHARED_STACK_SIZE = 128;\n" +
				"    IRQ_STACK_SIZE = 128;\n" +
				"  };\n" +
				"\n" +
				"  APPLICATION App1 {\n" +
				"    TRUSTED = FALSE;\n" +
				"    ISR = App1Isr;\n" +
				"    TASK = App1Task;\n" +
				"    MEMORY_BASE = \"0x40020000\";\n" +
				"    MEMORY_SIZE = 0x10000;\n" +
				"    SHARED_STACK_SIZE = 128;\n" +
				"    IRQ_STACK_SIZE = 128;\n" +
				"  };\n" +
				"\n" +
				"  APPLICATION App2 {\n" +
				"    TRUSTED = FALSE;\n" +
				"    ISR = App2Isr;\n" +
				"    TASK = App2Task;\n" +
				"    MEMORY_BASE = \"0x40030000\";\n" +
				"    MEMORY_SIZE = 0x4000;\n" +
				"    SHARED_STACK_SIZE = 128;\n" +
				"    IRQ_STACK_SIZE = 128;\n" +
				"  };\n" +
				"};\n";
		commonWriterTest(text, 1);
	}
	
	
	@Test public void test290_ecc1() {
	    final String text =
	    		"CPU test_application {\n" +
	    				"\n" +
	    				"	OS EE {\n" +
	    				"		EE_OPT = \"EE_DEBUG\";\n" +
	    				"		EE_OPT = \"__OO_SEM__\";\n" +
	    				"		EE_OPT = \"NODEPS\";\n" +
	    				"		EE_OPT = \"__ASSERT__\";\n" +
	    				"        	EE_OPT = \"EE_SAVE_TEMP_FILES\";\n" +
	    				"		EE_OPT=\"EE_MM_OPT\";\n" +
	    				"        	EE_OPT = \"EE_FIND_COMPILER_IN_PATH\";    /* Used by Lin */\n" +
	    				"\n" +                                                                                                                                                       
	    				"		CPU_DATA = TRICORE {\n" +
	    				"			CPU_CLOCK = 200.0;\n" +
	    				"            		COMPILER_TYPE = GNU;\n" +
	    				"            		APP_SRC = \"main.c\";\n" +
	    				"			MULTI_STACK = TRUE {\n" +
	    				"				IRQ_STACK = TRUE {\n" +
	    				"					SYS_SIZE = 512;\n" +
	    				"				};\n" +
	    				"			};\n" +
	    				"			SYS_STACK_SIZE = 2048;\n" +
	    				"		};\n" +
	    				"\n" +
	    				"		MCU_DATA = TRICORE {\n" +
	    				"			MODEL = TC27x;\n" +
	    				"		};\n" +
	    				"\n" +
	    				"		STATUS = EXTENDED;\n" +
	    				"		STARTUPHOOK = TRUE;\n" +
	    				"		ERRORHOOK = TRUE;\n" +
	    				"		SHUTDOWNHOOK = TRUE;\n" +
	    				"		PRETASKHOOK = FALSE;\n" +
	    				"		POSTTASKHOOK = FALSE;\n" +
	    				"		USEGETSERVICEID = FALSE;\n" +
	    				"		USEPARAMETERACCESS = FALSE;\n" +
	    				"		USERESSCHEDULER = FALSE;\n" +
	    				"\n" +
	    				"		ORTI_SECTIONS = ALL;\n" +
	    				"	};\n" +
	    				"\n" +
	    				"    COUNTER SystemTimer {\n" +
	    				"    MINCYCLE = 1;\n" +
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
	    				"	TASK Task1 {\n" +
	    				"		PRIORITY = 0x01;\n" +
	    				"		AUTOSTART = FALSE;\n" +
	    				"		STACK = SHARED;\n" +
	    				"		ACTIVATION = 1;\n" +
	    				"		RESOURCE = MyResource;\n" +
	    				"	};\n" +
	    				"\n" +
	    				"	TASK Task2 {\n" +
	    				"		PRIORITY = 0x02;\n" +
	    				"		SCHEDULE = FULL;\n" +
	    				"		AUTOSTART = TRUE;\n" +
	    				"		STACK = PRIVATE {\n" +
	    				"			SYS_SIZE = 1024;\n" +
	    				"		};\n" +
	    				"		RESOURCE = MyResource;\n" +
	    				"		EVENT = MyEvent;\n" +
	    				"	};\n" +
	    				"\n" +
	    				"	EVENT MyEvent { MASK = AUTO; };\n" +
	    				"\n" +
	    				"	RESOURCE MyResource { RESOURCEPROPERTY = STANDARD; };\n" +
	    				"\n" +
	    				"	COUNTER MainTimer {\n" +
	    				"		MINCYCLE = 2;\n" +
	    				"		MAXALLOWEDVALUE = 100;\n" +
	    				"		TICKSPERBASE = 1;\n" +
	    				"	};\n" +
	    				"\n" +
	    				"	ALARM MyAlarm {\n" +
	    				"		COUNTER = MainTimer;\n" +
	    				"		ACTION = ACTIVATETASK {\n" +
	    				"			TASK = Task1;\n" +
	    				"		};\n" +
	    				"		AUTOSTART = TRUE{\n" +
	    				"			ALARMTIME = 12;\n" +
	    				"			CYCLETIME = 12;\n" +
	    				"		};\n" +
	    				"	};\n" +
	    				"\n" +
	    				"	OS EE { KERNEL_TYPE = ECC1; EE_OPT = \"__OO_STARTOS_OLD__\";};\n" +
	    				"	TASK Task1 { SCHEDULE = NON; };\n" +
	    				"	TASK Task2 { ACTIVATION = 1; };\n" +
	    				"};";
		commonWriterTest(text, 1);
	}
	@Test public void test290_ecc2() {
	    final String text =
	    		"CPU test_application {\n" +
				"\n" +
				"	OS EE {\n" +
				"		EE_OPT = \"EE_DEBUG\";\n" +
				"		EE_OPT = \"__OO_SEM__\";\n" +
				"		EE_OPT = \"NODEPS\";\n" +
				"		EE_OPT = \"__ASSERT__\";\n" +
				"		EE_OPT = \"EE_SAVE_TEMP_FILES\";\n" +
				"		EE_OPT=\"EE_MM_OPT\";\n" +
				"        	EE_OPT = \"EE_FIND_COMPILER_IN_PATH\";    /* Used by Lin */\n" +
				"\n" +
				"		CPU_DATA = TRICORE {\n" +
				"			CPU_CLOCK = 200.0;\n" +
				"            COMPILER_TYPE = GNU;\n" +
				"            APP_SRC = \"main.c\";\n" +
				"			MULTI_STACK = TRUE;\n" +
				"		};\n" +
				"\n" +
				"		MCU_DATA = TRICORE {\n" +
				"			MODEL = TC27x;\n" +
				"		};\n" +
				"\n" +
				"		STATUS = EXTENDED;\n" +
				"		STARTUPHOOK = TRUE;\n" +
				"		ERRORHOOK = TRUE;\n" +
				"		SHUTDOWNHOOK = TRUE;\n" +
				"		PRETASKHOOK = FALSE;\n" +
				"		POSTTASKHOOK = FALSE;\n" +
				"		USEGETSERVICEID = FALSE;\n" +
				"		USEPARAMETERACCESS = FALSE;\n" +
				"		USERESSCHEDULER = FALSE;\n" +
				"\n" +
				"		ORTI_SECTIONS = ALL;\n" +
				"	};\n" +
				"\n" +
				"	COUNTER SystemTimer {\n" +
				"	MINCYCLE = 1;\n" +
				"        MAXALLOWEDVALUE = 2147483647;\n" +
				"        TICKSPERBASE = 1;\n" +
				"        TYPE = HARDWARE {\n" +
				"		DEVICE = \"STM_SR0\";\n" +
				"		SYSTEM_TIMER = TRUE;\n" +
				"		PRIORITY = 1;\n" +
				"        };\n" +
				"        SECONDSPERTICK = 0.001;\n" +
				"	};\n" +
				"\n" +
				"	TASK Task1 {\n" +
				"		PRIORITY = 0x01;\n" +
				"		AUTOSTART = FALSE;\n" +
				"		STACK = SHARED;\n" +
				"		ACTIVATION = 1;\n" +
				"		RESOURCE = MyResource;\n" +
				"	};\n" +
				"\n" +
				"	TASK Task2 {\n" +
				"		PRIORITY = 0x02;\n" +
				"		SCHEDULE = FULL;\n" +
				"		AUTOSTART = TRUE;\n" +
				"		STACK = PRIVATE {\n" +
				"			SYS_SIZE = 1024;\n" +
				"		};\n" +
				"		RESOURCE = MyResource;\n" +
				"		EVENT = MyEvent;\n" +
				"	};\n" +
				"\n" +
				"	EVENT MyEvent { MASK = AUTO; };\n" +
				"\n" +
				"	RESOURCE MyResource { RESOURCEPROPERTY = STANDARD; };\n" +
				"\n" +
				"	COUNTER MainTimer {\n" +
				"		MINCYCLE = 2;\n" +
				"		MAXALLOWEDVALUE = 100;\n" +
				"		TICKSPERBASE = 1;\n" +
				"	};\n" +
				"\n" +
				"	ALARM MyAlarm {\n" +
				"		COUNTER = MainTimer;\n" +
				"		ACTION = ACTIVATETASK {\n" +
				"			TASK = Task1;\n" +
				"		};\n" +
				"		AUTOSTART = TRUE{\n" +
				"			ALARMTIME = 12;\n" +
				"			CYCLETIME = 12;\n" +
				"		};\n" +
				"	};\n" +
				"\n" +
				"	OS EE { KERNEL_TYPE = ECC2; EE_OPT = \"__OO_STARTOS_OLD__\";};\n" +
				"	TASK Task1 { SCHEDULE = NON; };\n" +
				"	TASK Task2 { ACTIVATION = 1; };\n" +
				"};";
		commonWriterTest(text, 1);
	}

	@Test public void test302_mp_ecc2() {
		String text = "CPU test_application {\n" +
				"\n" +
				"	OS EE {\n" +
				"		EE_OPT = \"EE_DEBUG\";\n" +
				"		EE_OPT = \"NODEPS\";\n" +
				"		EE_OPT = \"__ASSERT__\";\n" +
				"		EE_OPT = \"EE_SAVE_TEMP_FILES\";\n" +
				"		EE_OPT=\"EE_MM_OPT\";\n" +
				"        	EE_OPT = \"EE_FIND_COMPILER_IN_PATH\";    /* Used by Lin */\n" +
				"\n" +
				"		REMOTENOTIFICATION = USE_RPC;	/* Required by Inter-core communication mechanism */\n" +
				"\n" +
				"		MASTER_CPU = \"master\";\n" +
				"\n" +
				"		CPU_DATA = TRICORE {\n" +
				"			ID = \"master\";\n" +
				"			CPU_CLOCK = 200.0;\n" +
				"            COMPILER_TYPE = GNU;\n" +
				"            APP_SRC = \"main.c\";\n" +
				"			MULTI_STACK = TRUE;\n" +
				"		};\n" +
				"\n" +
				"		CPU_DATA = TRICORE {\n" +
				"			ID = \"slave\";\n" +
				"			CPU_CLOCK = 200.0;\n" +
				"            COMPILER_TYPE = GNU;\n" +
				"            APP_SRC = \"main.c\";\n" +
				"			MULTI_STACK = TRUE;\n" +
				"		};\n" +
				"\n" +
				"		MCU_DATA = TRICORE {\n" +
				"			MODEL = TC27x;\n" +
				"		};\n" +
				"\n" +
				"		STATUS = EXTENDED;\n" +
				"		STARTUPHOOK = FALSE;\n" +
				"		ERRORHOOK = FALSE;\n" +
				"		SHUTDOWNHOOK = FALSE;\n" +
				"		PRETASKHOOK = TRUE;\n" +
				"		POSTTASKHOOK = TRUE;\n" +
				"		USEGETSERVICEID = FALSE;\n" +
				"		USEPARAMETERACCESS = FALSE;\n" +
				"		USERESSCHEDULER = FALSE;\n" +
				"\n" +
				"		USEREMOTETASK = ALWAYS;\n" +
				"		USEREMOTEEVENT = ALWAYS;\n" +
				"\n" +
				"		ORTI_SECTIONS = ALL;\n" +
				"		KERNEL_TYPE = ECC2;\n" +
				"                EE_OPT = \"__OO_STARTOS_OLD__\";\n" +
				"	};\n" +
				"\n" +
				"	COUNTER SystemTimerMaster {\n" +
				"	MINCYCLE = 1;\n" +
				"        MAXALLOWEDVALUE = 2147483647;\n" +
				"        TICKSPERBASE = 1;\n" +
				"        TYPE = HARDWARE {\n" +
				"		DEVICE = \"STM_SR0\";\n" +
				"		SYSTEM_TIMER = TRUE;\n" +
				"		PRIORITY = 2;\n" +
				"        };\n" +
				"        SECONDSPERTICK = 0.001;\n" +
				"        CPU_ID = \"master\";\n" +
				"	};\n" +
				"\n" +
				"	COUNTER SystemTimerSlave {\n" +
				"	MINCYCLE = 1;\n" +
				"        MAXALLOWEDVALUE = 2147483647;\n" +
				"        TICKSPERBASE = 1;\n" +
				"        TYPE = HARDWARE {\n" +
				"		DEVICE = \"STM_SR0\";\n" +
				"		SYSTEM_TIMER = TRUE;\n" +
				"		PRIORITY = 2;\n" +
				"        };\n" +
				"        SECONDSPERTICK = 0.001;\n" +
				"        CPU_ID = \"slave\";\n" +
				"	};\n" +
				"\n" +
				"	TASK Task1 {\n" +
				"		PRIORITY = 0x01;\n" +
				"		SCHEDULE = NON;\n" +
				"		AUTOSTART = FALSE;\n" +
				"		STACK = SHARED;\n" +
				"		ACTIVATION = 1;\n" +
				"		RESOURCE = MyResource;\n" +
				"		CPU_ID = \"master\";\n" +
				"	};\n" +
				"\n" +
				"	TASK Task2 {\n" +
				"		PRIORITY = 0x02;\n" +
				"		SCHEDULE = FULL;\n" +
				"		AUTOSTART = TRUE;\n" +
				"		STACK = PRIVATE {\n" +
				"			SYS_SIZE = 1024;\n" +
				"		};\n" +
				"		ACTIVATION = 1;\n" +
				"		RESOURCE = MyResource;\n" +
				"		EVENT = MyEvent;\n" +
				"		CPU_ID = \"master\";\n" +
				"	};\n" +
				"\n" +
				"	TASK Task3 {\n" +
				"		PRIORITY = 0x02;\n" +
				"		SCHEDULE = FULL;\n" +
				"		AUTOSTART = TRUE;\n" +
				"		STACK = SHARED;\n" +
				"		ACTIVATION = 1;\n" +
				"		RESOURCE = MyOtherResource;\n" +
				"		CPU_ID = \"slave\";\n" +
				"	};\n" +
				"\n" +
				"	EVENT MyEvent { MASK = AUTO; };\n" +
				"\n" +
				"	RESOURCE MyResource { RESOURCEPROPERTY = STANDARD; };\n" +
				"\n" +
				"	RESOURCE MyOtherResource { RESOURCEPROPERTY = STANDARD; };\n" +
				"\n" +
				"	COUNTER MainTimer {\n" +
				"		MINCYCLE = 2;\n" +
				"		MAXALLOWEDVALUE = 100;\n" +
				"		TICKSPERBASE = 1;\n" +
				"		CPU_ID = \"master\";\n" +
				"	};\n" +
				"\n" +
				"	ALARM MyAlarm {\n" +
				"		COUNTER = MainTimer;\n" +
				"		ACTION = ACTIVATETASK {\n" +
				"			TASK = Task1;\n" +
				"		};\n" +
				"		AUTOSTART = FALSE;\n" +
				"	};\n" +
				"\n" +
				"	COUNTER OtherTimer {\n" +
				"		MINCYCLE = 2;\n" +
				"		MAXALLOWEDVALUE = 100;\n" +
				"		TICKSPERBASE = 1;\n" +
				"		CPU_ID = \"slave\";\n" +
				"	};\n" +
				"\n" +
				"	ALARM OtherAlarm {\n" +
				"		COUNTER = OtherTimer;\n" +
				"		ACTION = ACTIVATETASK {\n" +
				"			TASK = Task1;\n" +
				"		};\n" +
				"		AUTOSTART = FALSE;\n" +
				"	};\n" +
				"};";
		commonWriterTest(text, 2);
	}
	@Test public void test302_mp_bcc1() {
		String text = "CPU test_application {\n" +
				"\n" +
				"	OS EE {\n" +
				"		EE_OPT = \"EE_DEBUG\";\n" +
				"		EE_OPT = \"NODEPS\";\n" +
				"		EE_OPT = \"__ASSERT__\";\n" +
				"        	EE_OPT = \"EE_SAVE_TEMP_FILES\";\n" +
				"		EE_OPT=\"EE_MM_OPT\";\n" +
				"        	EE_OPT = \"EE_FIND_COMPILER_IN_PATH\";    /* Used by Lin */\n" +
				"\n" +
				"		REMOTENOTIFICATION = USE_RPC;	/* Required by Inter-core communication mechanism */\n" +
				"\n" +
				"		MASTER_CPU = \"master\";\n" +
				"\n" +
				"		CPU_DATA = TRICORE {\n" +
				"			ID = \"master\";\n" +
				"			CPU_CLOCK = 200.0;\n" +
				"            COMPILER_TYPE = GNU;\n" +
				"            APP_SRC = \"main.c\";\n" +
				"			MULTI_STACK = FALSE;\n" +
				"		};\n" +
				"\n" +
				"		CPU_DATA = TRICORE {\n" +
				"			ID = \"slave\";\n" +
				"			CPU_CLOCK = 200.0;\n" +
				"            COMPILER_TYPE = GNU;\n" +
				"            APP_SRC = \"main.c\";\n" +
				"			MULTI_STACK = FALSE;\n" +
				"		};\n" +
				"\n" +
				"		MCU_DATA = TRICORE {\n" +
				"			MODEL = TC27x;\n" +
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
				"		USEREMOTETASK = ALWAYS;\n" +
				"\n" +
				"		ORTI_SECTIONS = ALL;\n" +
				"		KERNEL_TYPE = BCC1;\n" +
				"                EE_OPT = \"__OO_STARTOS_OLD__\";\n" +
				"	};\n" +
				"\n" +
				"	COUNTER SystemTimerMaster {\n" +
				"	MINCYCLE = 1;\n" +
				"        MAXALLOWEDVALUE = 2147483647;\n" +
				"        TICKSPERBASE = 1;\n" +
				"        TYPE = HARDWARE {\n" +
				"		DEVICE = \"STM_SR0\";\n" +
				"		SYSTEM_TIMER = TRUE;\n" +
				"		PRIORITY = 2;\n" +
				"        };\n" +
				"        SECONDSPERTICK = 0.001;\n" +
				"        CPU_ID = \"master\";\n" +
				"	};\n" +
				"\n" +
				"	COUNTER SystemTimerSlave {\n" +
				"	MINCYCLE = 1;\n" +
				"        MAXALLOWEDVALUE = 2147483647;\n" +
				"        TICKSPERBASE = 1;\n" +
				"        TYPE = HARDWARE {\n" +
				"		DEVICE = \"STM_SR0\";\n" +
				"		SYSTEM_TIMER = TRUE;\n" +
				"		PRIORITY = 2;\n" +
				"        };\n" +
				"        SECONDSPERTICK = 0.001;\n" +
				"        CPU_ID = \"slave\";\n" +
				"	};\n" +
				"\n" +
				"	TASK Task1 {\n" +
				"		PRIORITY = 0x01;\n" +
				"		SCHEDULE = NON;\n" +
				"		AUTOSTART = FALSE;\n" +
				"		STACK = SHARED;\n" +
				"		ACTIVATION = 1;\n" +
				"		RESOURCE = MyResource;\n" +
				"		CPU_ID = \"master\";\n" +
				"	};\n" +
				"\n" +
				"	TASK Task2 {\n" +
				"		PRIORITY = 0x02;\n" +
				"		SCHEDULE = FULL;\n" +
				"		AUTOSTART = TRUE;\n" +
				"		STACK = SHARED;\n" +
				"		ACTIVATION = 1;\n" +
				"		RESOURCE = MyResource;\n" +
				"		CPU_ID = \"master\";\n" +
				"	};\n" +
				"\n" +
				"	TASK Task3 {\n" +
				"		PRIORITY = 0x02;\n" +
				"		SCHEDULE = FULL;\n" +
				"		AUTOSTART = TRUE;\n" +
				"		STACK = SHARED;\n" +
				"		ACTIVATION = 1;\n" +
				"		RESOURCE = MyOtherResource;\n" +
				"		CPU_ID = \"slave\";\n" +
				"	};\n" +
				"\n" +
				"	RESOURCE MyResource { RESOURCEPROPERTY = STANDARD; };\n" +
				"\n" +
				"	RESOURCE MyOtherResource { RESOURCEPROPERTY = STANDARD; };\n" +
				"\n" +
				"	COUNTER MainTimer {\n" +
				"		MINCYCLE = 2;\n" +
				"		MAXALLOWEDVALUE = 100;\n" +
				"		TICKSPERBASE = 1;\n" +
				"		CPU_ID = \"master\";\n" +
				"	};\n" +
				"\n" +
				"	ALARM MyAlarm {\n" +
				"		COUNTER = MainTimer;\n" +
				"		ACTION = ACTIVATETASK {\n" +
				"			TASK = Task1;\n" +
				"		};\n" +
				"		AUTOSTART = FALSE;\n" +
				"	};\n" +
				"\n" +
				"	COUNTER OtherTimer {\n" +
				"		MINCYCLE = 2;\n" +
				"		MAXALLOWEDVALUE = 100;\n" +
				"		TICKSPERBASE = 1;\n" +
				"		CPU_ID = \"slave\";\n" +
				"	};\n" +
				"\n" +
				"	ALARM OtherAlarm {\n" +
				"		COUNTER = OtherTimer;\n" +
				"		ACTION = ACTIVATETASK {\n" +
				"			TASK = Task1;\n" +
				"		};\n" +
				"		AUTOSTART = FALSE;\n" +
				"	};\n" +
				"};";
		commonWriterTest(text, 2);
	}

	

	@Test public void testTc27xCsa_GNU() {
		String text = "CPU test_application {\n" +
				"\n" +
				"	OS EE {\n" +
				"    EE_OPT = \"EE_DEBUG\";\n" +
				"    EE_OPT = \"__ASSERT__\";\n" +
				"    EE_OPT = \"EE_EXECUTE_FROM_RAM\";\n" +
				"    EE_OPT = \"EE_ICACHE_ENABLED\";\n" +
				"    EE_OPT = \"EE_DCACHE_ENABLED\";\n" +
				"    EE_OPT = \"EE_AS_IOC__\";\n" +
				"\n" +
				"    REMOTENOTIFICATION = USE_RPC;\n" +
				"    MASTER_CPU = \"master\";\n" +
				"\n" +
				"    CPU_DATA = TRICORE {\n" +
				"      ID = \"master\";\n" +
				"      APP_SRC = \"master.c\";\n" +
				"      APP_SRC = \"ioc_common.c\";\n" +
				"      MULTI_STACK = TRUE;\n" +
				"      SYS_STACK_SIZE = 4096;\n" +
				"      COMPILER_TYPE = GNU;\n" +
				"    };\n" +
				"\n" +
				"    CPU_DATA = TRICORE {\n" +
				"      ID = \"slave1\";\n" +
				"      APP_SRC = \"slave1.c\";\n" +
				"      APP_SRC = \"ioc_slave1.c\";\n" +
				"      MULTI_STACK = TRUE;\n" +
				"      SYS_STACK_SIZE = 4096;\n" +
				"      SYS_CSA_SIZE = 4096;\n" +
				"      COMPILER_TYPE = GNU;\n" +
				"    };\n" +
				"\n" +
				"    CPU_DATA = TRICORE {\n" +
				"      ID = \"slave2\";\n" +
				"      APP_SRC = \"slave2.c\";\n" +
				"      APP_SRC = \"ioc_slave2.c\";\n" +
				"      MULTI_STACK = TRUE;\n" +
				"      SYS_CSA_SIZE = 4100;\n" +
				"      COMPILER_TYPE = GNU;\n" +
				"    };\n" +
				"\n" +
				"    MCU_DATA = TRICORE {\n" +
				"      MODEL = TC27x;\n" +
				"    };\n" +
				"\n" +
				"    STATUS = EXTENDED;\n" +
				"    USERESSCHEDULER = FALSE;\n" +
				"\n" +
				"    ORTI_SECTIONS = ALL;\n" +
				"\n" +
				"    KERNEL_TYPE = BCC1;\n" +
				"  };\n" +
				"\n" +
				"	TASK TaskSend1 {\n" +
				"		CPU_ID = \"master\";\n" +
				"		PRIORITY = 0x02;\n" +
				"		AUTOSTART = TRUE;\n" +
				"		STACK = PRIVATE {\n" +
				"			SYS_SIZE = 128;\n" +
				"		};\n" +
				"		ACTIVATION = 1;\n" +
				"		SCHEDULE = FULL;\n" +
				"	};\n" +
				"\n" +
				"    TASK master_receive1 {\n" +
				"		CPU_ID = \"master\";\n" +
				"		PRIORITY = 0x04;\n" +
				"		AUTOSTART = FALSE;\n" +
				"		STACK = PRIVATE {\n" +
				"			SYS_SIZE = 128;\n" +
				"		};\n" +
				"		ACTIVATION = 1;\n" +
				"		SCHEDULE = FULL;\n" +
				"	};\n" +
				"\n" +
				"    TASK TaskSlave1 {\n" +
				"		CPU_ID = \"slave1\";\n" +
				"		PRIORITY = 0x2;\n" +
				"		AUTOSTART = FALSE;\n" +
				"		STACK = PRIVATE {\n" +
				"			SYS_SIZE = 128;\n" +
				"		};\n" +
				"		ACTIVATION = 1;\n" +
				"		SCHEDULE = FULL;\n" +
				"	};\n" +
				"\n" +
				"    TASK TaskSlave2 {\n" +
				"		CPU_ID = \"slave2\";\n" +
				"		PRIORITY = 0x2;\n" +
				"		AUTOSTART = FALSE;\n" +
				"		STACK = PRIVATE {\n" +
				"			SYS_SIZE = 128;\n" +
				"		};\n" +
				"		ACTIVATION = 1;\n" +
				"		SCHEDULE = FULL;\n" +
				"	};\n" +
				"\n" +
				"    SPINLOCK spinlock_1 { };\n" +
				"    SPINLOCK spinlock_2 { };\n" +
				"    SPINLOCK spinlock_3 { };\n" +
				"};\n";
		commonWriterTest(text, 3);
	}
	@Test public void testTc27xCsa_TASKING() {
		String text = "CPU test_application {\n" +
				"\n" +
				"	OS EE {\n" +
				"    EE_OPT = \"EE_DEBUG\";\n" +
				"    EE_OPT = \"__ASSERT__\";\n" +
				"    EE_OPT = \"EE_EXECUTE_FROM_RAM\";\n" +
				"    EE_OPT = \"EE_ICACHE_ENABLED\";\n" +
				"    EE_OPT = \"EE_DCACHE_ENABLED\";\n" +
				"    EE_OPT = \"EE_AS_IOC__\";\n" +
				"\n" +
				"    REMOTENOTIFICATION = USE_RPC;\n" +
				"    MASTER_CPU = \"master\";\n" +
				"\n" +
				"    CPU_DATA = TRICORE {\n" +
				"      ID = \"master\";\n" +
				"      APP_SRC = \"master.c\";\n" +
				"      APP_SRC = \"ioc_common.c\";\n" +
				"      MULTI_STACK = TRUE;\n" +
				"      SYS_STACK_SIZE = 4096;\n" +
				"      COMPILER_TYPE = TASKING;\n" +
				"    };\n" +
				"\n" +
				"    CPU_DATA = TRICORE {\n" +
				"      ID = \"slave1\";\n" +
				"      APP_SRC = \"slave1.c\";\n" +
				"      APP_SRC = \"ioc_slave1.c\";\n" +
				"      MULTI_STACK = TRUE;\n" +
				"      SYS_STACK_SIZE = 4096;\n" +
				"      SYS_CSA_SIZE = 4096;\n" +
				"      COMPILER_TYPE = TASKING;\n" +
				"    };\n" +
				"\n" +
				"    CPU_DATA = TRICORE {\n" +
				"      ID = \"slave2\";\n" +
				"      APP_SRC = \"slave2.c\";\n" +
				"      APP_SRC = \"ioc_slave2.c\";\n" +
				"      MULTI_STACK = TRUE;\n" +
				"      SYS_CSA_SIZE = 4100;\n" +
				"      COMPILER_TYPE = TASKING;\n" +
				"    };\n" +
				"\n" +
				"    MCU_DATA = TRICORE {\n" +
				"      MODEL = TC27x;\n" +
				"    };\n" +
				"\n" +
				"    STATUS = EXTENDED;\n" +
				"    USERESSCHEDULER = FALSE;\n" +
				"\n" +
				"    ORTI_SECTIONS = ALL;\n" +
				"\n" +
				"    KERNEL_TYPE = BCC1;\n" +
				"  };\n" +
				"\n" +
				"	TASK TaskSend1 {\n" +
				"		CPU_ID = \"master\";\n" +
				"		PRIORITY = 0x02;\n" +
				"		AUTOSTART = TRUE;\n" +
				"		STACK = PRIVATE {\n" +
				"			SYS_SIZE = 128;\n" +
				"		};\n" +
				"		ACTIVATION = 1;\n" +
				"		SCHEDULE = FULL;\n" +
				"	};\n" +
				"\n" +
				"    TASK master_receive1 {\n" +
				"		CPU_ID = \"master\";\n" +
				"		PRIORITY = 0x04;\n" +
				"		AUTOSTART = FALSE;\n" +
				"		STACK = PRIVATE {\n" +
				"			SYS_SIZE = 128;\n" +
				"		};\n" +
				"		ACTIVATION = 1;\n" +
				"		SCHEDULE = FULL;\n" +
				"	};\n" +
				"\n" +
				"    TASK TaskSlave1 {\n" +
				"		CPU_ID = \"slave1\";\n" +
				"		PRIORITY = 0x2;\n" +
				"		AUTOSTART = FALSE;\n" +
				"		STACK = PRIVATE {\n" +
				"			SYS_SIZE = 128;\n" +
				"		};\n" +
				"		ACTIVATION = 1;\n" +
				"		SCHEDULE = FULL;\n" +
				"	};\n" +
				"\n" +
				"    TASK TaskSlave2 {\n" +
				"		CPU_ID = \"slave2\";\n" +
				"		PRIORITY = 0x2;\n" +
				"		AUTOSTART = FALSE;\n" +
				"		STACK = PRIVATE {\n" +
				"			SYS_SIZE = 128;\n" +
				"		};\n" +
				"		ACTIVATION = 1;\n" +
				"		SCHEDULE = FULL;\n" +
				"	};\n" +
				"\n" +
				"    SPINLOCK spinlock_1 { };\n" +
				"    SPINLOCK spinlock_2 { };\n" +
				"    SPINLOCK spinlock_3 { };\n" +
				"};\n";
		commonWriterTest(text, 3);
	}
	@Test public void testTc27x_newStack_Structure() {
		String text = "CPU test_application {\n" +
				"\n" +
				"    OS EE {\n" +
				"        EE_OPT = \"EE_DEBUG\";\n" +
				"        EE_OPT = \"__ASSERT__\";\n" +
				"\n" +
				"        MCU_DATA = TRICORE {\n" +
				"            MODEL = TC27x;\n" +
				"        };\n" +
				"\n" +
				"        CPU_DATA = TRICORE {\n" +
				"            CPU_CLOCK = 200.0;\n" +
				"            APP_SRC = \"code.c\";\n" +
				"            COMPILER_TYPE = TASKING;\n" +
				"            MULTI_STACK = TRUE {\n" +
				"                IRQ_STACK = TRUE {\n" +
				"                    SYS_SIZE = 256;\n" +
				"                };\n" +
				"            };\n" +
				"        };\n" +
				"\n" +
				"        BOARD_DATA = TRIBOARD_TC2X5;\n" +
				"\n" +
				"        STATUS = EXTENDED;\n" +
				"        STARTUPHOOK = TRUE;\n" +
				"        ERRORHOOK = TRUE;\n" +
				"        USERESSCHEDULER = FALSE;\n" +
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
	
	@Test public void testTc26xExportFile_1() {
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
				"           COMPILER_TYPE = GNU {\n" +
				"               EXPORT_FILE = \"expFile1\";\n" +
				"           };\n" +
				"		};\n"+
				"		KERNEL_TYPE = FP;\n" +
				"		MCU_DATA = TRICORE {\n"+
				"			MODEL = TC26x;\n"+
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
	
	@Test public void testTc27xExportFile_1() {
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
			"           COMPILER_TYPE = GNU {\n" +
			"               EXPORT_FILE = \"expFile1\";\n" +
			"           };\n" +
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
			"           COMPILER_TYPE = GNU {\n" +
			"               EXPORT_FILE = \"expFile2\";\n" +
			"           };\n" +
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
			"           COMPILER_TYPE = GNU {\n" +
			"               EXPORT_FILE = \"expFile3\";\n" +
			"           };\n" +
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

	@Test public void testTc27xOrti() {
	    final String text = "CPU test_application {\n" +
	    		"\n" +
	    		"    OS EE {\n" +
	    		"        EE_OPT = \"EE_DEBUG\";\n" +
	    		"\n" +
	    		"        EE_OPT = \"EE_EXECUTE_FROM_RAM\";\n" +
	    		"\n" +
	    		"        SERVICE_PROTECTION = TRUE;\n" +
	    		"\n" +
	    		"        MCU_DATA = TRICORE {\n" +
	    		"            MODEL = TC27x;\n" +
	    		"        };\n" +
	    		"\n" +
	    		"        CPU_DATA = TRICORE {\n" +
	    		"            CPU_CLOCK = 200.0;\n" +
	    		"            APP_SRC = \"code.c\";\n" +
	    		"            COMPILER_TYPE = GNU;\n" +
	    		"            MULTI_STACK = TRUE {\n" +
	    		"                IRQ_STACK = TRUE {\n" +
	    		"                    SYS_SIZE = 256;\n" +
	    		"                };\n" +
	    		"            };\n" +
	    		"        };\n" +
	    		"\n" +
	    		"        BOARD_DATA = TRIBOARD_TC2X5;\n" +
	    		"\n" +
	    		"        STATUS = EXTENDED;\n" +
	    		"        STARTUPHOOK = TRUE;\n" +
	    		"        ERRORHOOK = TRUE;\n" +
	    		"\n" +
	    		"        KERNEL_TYPE = ECC1;\n" +
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
	
	@Test public void testTc27x_rpc4() {
		String text = "CPU test_application {\n" +
				"\n" +
				"  OS EE {\n" +
				"    EE_OPT = \"EE_DEBUG\";\n" +
				"    EE_OPT = \"__ASSERT__\";\n" +
				"    EE_OPT = \"EE_EXECUTE_FROM_RAM\";\n" +
				"    //EE_OPT = \"EE_SAVE_TEMP_FILES\";\n" +
				"    //EE_OPT = \"EE_MM_OPT\";\n" +
				"    EE_OPT = \"EE_ICACHE_ENABLED\";\n" +
				"    EE_OPT = \"EE_DCACHE_ENABLED\";\n" +
				"\n" +
				"    REMOTENOTIFICATION = USE_RPC;\n" +
				"\n" +
				"    //SPINLOCKS = QUEUED;\n" +
				"\n" +
				"    MASTER_CPU = \"master\";\n" +
				"\n" +
				"    CPU_DATA = TRICORE {\n" +
				"      ID = \"master\";\n" +
				"      CPU_CLOCK = 200.0;\n" +
				"      APP_SRC = \"master.c\";\n" +
				"      MULTI_STACK = TRUE;\n" +
				"      SYS_STACK_SIZE = 4096;\n" +
				"      COMPILER_TYPE = GNU;\n" +
				"      //COMPILER_TYPE = TASKING;\n" +
				"    };\n" +
				"\n" +
				"    CPU_DATA = TRICORE {\n" +
				"      ID = \"slave1\";\n" +
				"      APP_SRC = \"slave1.c\";\n" +
				"      MULTI_STACK = TRUE;\n" +
				"      SYS_STACK_SIZE = 4096;\n" +
				"      COMPILER_TYPE = GNU;\n" +
				"      //COMPILER_TYPE = TASKING;\n" +
				"    };\n" +
				"\n" +
				"    CPU_DATA = TRICORE {\n" +
				"      ID = \"slave2\";\n" +
				"      APP_SRC = \"slave2.c\";\n" +
				"      MULTI_STACK = TRUE;\n" +
				"      SYS_STACK_SIZE = 4096;\n" +
				"      COMPILER_TYPE = GNU;\n" +
				"      //COMPILER_TYPE = TASKING;\n" +
				"    };\n" +
				"\n" +
				"    MCU_DATA = TRICORE {\n" +
				"      MODEL = TC27x;\n" +
				"    };\n" +
				"\n" +
				"    STATUS = EXTENDED;\n" +
				"    ERRORHOOK = TRUE;\n" +
				"\n" +
				"    ORTI_SECTIONS = ALL;\n" +
				"\n" +
				"    KERNEL_TYPE = ECC1;\n" +
				"  };\n" +
				"\n" +
				"  TASK TaskMaster {\n" +
				"    CPU_ID = \"master\";\n" +
				"    PRIORITY = 1;\n" +
				"    AUTOSTART = TRUE;\n" +
				"    STACK = PRIVATE {\n" +
				"      SYS_SIZE = 256;\n" +
				"    };\n" +
				"    ACTIVATION = 1;\n" +
				"    SCHEDULE = FULL;\n" +
				"    EVENT = EventMaster;\n" +
				"  };\n" +
				"\n" +
				"  TASK TaskSlave1 {\n" +
				"    CPU_ID = \"slave1\";\n" +
				"    PRIORITY = 1;\n" +
				"    AUTOSTART = FALSE;\n" +
				"    STACK = PRIVATE {\n" +
				"      SYS_SIZE = 128;\n" +
				"    };\n" +
				"    ACTIVATION = 1;\n" +
				"    SCHEDULE = FULL;\n" +
				"    EVENT = EventSlave1;\n" +
				"  };\n" +
				"\n" +
				"  TASK TaskSlave2 {\n" +
				"    CPU_ID = \"slave2\";\n" +
				"    PRIORITY = 1;\n" +
				"    AUTOSTART = FALSE;\n" +
				"    STACK = SHARED;\n" +
				"    ACTIVATION = 1;\n" +
				"    SCHEDULE = FULL;\n" +
				"  };\n" +
				"\n" +
				"  EVENT EventMaster { MASK = AUTO; };\n" +
				"  EVENT EventSlave1 { MASK = AUTO; };\n" +
				"\n" +
				"  COUNTER CounterSlave2 {\n" +
				"    CPU_ID = \"slave2\";\n" +
				"    MINCYCLE = 1;\n" +
				"    MAXALLOWEDVALUE = 1;\n" +
				"    TICKSPERBASE = 1;\n" +
				"  };\n" +
				"\n" +
				"  ALARM AlarmSlave2 {\n" +
				"    COUNTER = CounterSlave2;\n" +
				"    ACTION = SETEVENT { TASK = TaskSlave1; EVENT = EventSlave1; };\n" +
				"  };\n" +
				"};\n";
			commonWriterTest(text, 3);
		}

	@Test public void testTc27x_event() {
		String text = "CPU test_application {\n" +
				"\n" +
				"    OS EE {\n" +
				"        EE_OPT = \"EE_DEBUG\";\n" +
				"        EE_OPT = \"__ASSERT__\";\n" +
				"\n" +
				"        EE_OPT = \"EE_EXECUTE_FROM_RAM\";\n" +
				"\n" +
				"        MCU_DATA = TRICORE {\n" +
				"            MODEL = TC27x;\n" +
				"        };\n" +
				"\n" +
				"        CPU_DATA = TRICORE {\n" +
				"            CPU_CLOCK = 200.0;\n" +
				"            APP_SRC = \"code.c\";\n" +
				"            COMPILER_TYPE = GNU;\n" +
				"            MULTI_STACK = TRUE {\n" +
				"                IRQ_STACK = TRUE {\n" +
				"                    SYS_SIZE = 256;\n" +
				"                };\n" +
				"            };\n" +
				"        };\n" +
				"\n" +
				"        BOARD_DATA = TRIBOARD_TC2X5;\n" +
				"\n" +
				"        STATUS = EXTENDED;\n" +
				"        STARTUPHOOK = TRUE;\n" +
				"        ERRORHOOK = TRUE;\n" +
				"        USERESSCHEDULER = FALSE;\n" +
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
	@Test public void testTc27x_sched_tab() {
		String text = "CPU test_application {\n" +
				"\n" +
				"    OS EE {\n" +
				"        EE_OPT = \"EE_DEBUG\";\n" +
				"        EE_OPT = \"__ASSERT__\";\n" +
				"\n" +
				"        EE_OPT = \"EE_EXECUTE_FROM_RAM\";\n" +
				"\n" +
				"        MCU_DATA = TRICORE {\n" +
				"            MODEL = TC27x;\n" +
				"        };\n" +
				"\n" +
				"        CPU_DATA = TRICORE {\n" +
				"            CPU_CLOCK = 200.0;\n" +
				"            APP_SRC = \"code.c\";\n" +
				"            COMPILER_TYPE = GNU;\n" +
				"            MULTI_STACK = TRUE {\n" +
				"                IRQ_STACK = TRUE {\n" +
				"                    SYS_SIZE = 256;\n" +
				"                };\n" +
				"            };\n" +
				"        };\n" +
				"\n" +
				"        BOARD_DATA = TRIBOARD_TC2X5;\n" +
				"\n" +
				"        STATUS = EXTENDED;\n" +
				"        STARTUPHOOK = TRUE;\n" +
				"        ERRORHOOK = TRUE;\n" +
				"        USERESSCHEDULER = FALSE;\n" +
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
				"    TASK Task3 {\n" +
				"        PRIORITY = 0x02;\n" +
				"        ACTIVATION = 1;\n" +
				"        SCHEDULE = FULL;\n" +
				"        AUTOSTART = FALSE;\n" +
				"        STACK = SHARED;\n" +
				"    };\n" +
				"    TASK Task4 {\n" +
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
				"    SCHEDULETABLE SchedTab1 {\n" +
				"        DURATION = 10;\n" +
				"        REPEATING = TRUE;\n" +
				"        COUNTER = system_timer;\n" +
				"        EXPIRE_POINT = ACTION {\n" +
				"        		EXPIRE_VALUE = 3;\n" +
				"        		ACTION = SETEVENT     { TASK = Task1; EVENT = TimerEvent; };\n" +
				"        		ACTION = ACTIVATETASK { TASK = Task2; };\n" +
				"    	 };\n" +
				"        EXPIRE_POINT = ACTION {\n" +
				"        		EXPIRE_VALUE = 6;\n" +
				"        		ACTION = SETEVENT     { TASK = Task2; EVENT = TimerEvent; };\n" +
				"        		ACTION = ACTIVATETASK { TASK = Task1; };\n" +
				"        		SYNC_ADJUSTMENT = TRUE { MAX_POSOSITIVE_ADJ = 1; MAX_NEGATIVE_ADJ = 2; };\n" +
				"    	 };\n" +
				"        AUTOSTART = TRUE { START_VALUE = 25; TYPE = ABSOLUTE; };\n" +
				"    };\n" +
				"\n" +
				"    SCHEDULETABLE SchedTab2 {\n" +
				"        DURATION = 20;\n" +
				"        REPEATING = TRUE;\n" +
				"        COUNTER = system_timer;\n" +
				"        EXPIRE_POINT = ACTION {\n" +
				"        		EXPIRE_VALUE = 4;\n" +
				"        		ACTION = SETEVENT     { TASK = Task1; EVENT = TimerEvent; };\n" +
				"    	 };\n" +
				"        EXPIRE_POINT = ACTION {\n" +
				"        		EXPIRE_VALUE = 7;\n" +
				"        		ACTION = ACTIVATETASK { TASK = Task1; };\n" +
				"        		SYNC_ADJUSTMENT = TRUE { MAX_POSOSITIVE_ADJ = 1; MAX_NEGATIVE_ADJ = 2; };\n" +
				"    	 };\n" +
				"        EXPIRE_POINT = ACTION {\n" +
				"        		EXPIRE_VALUE = 12;\n" +
				"        		ACTION = SETEVENT     { TASK = Task1; EVENT = TimerEvent; };\n" +
				"        		ACTION = ACTIVATETASK { TASK = Task2; };\n" +
				"    	 };\n" +
				"        EXPIRE_POINT = ACTION {\n" +
				"        		EXPIRE_VALUE = 16;\n" +
				"        		ACTION = ACTIVATETASK { TASK = Task1; };\n" +
				"        		SYNC_ADJUSTMENT = TRUE { MAX_POSOSITIVE_ADJ = 1; MAX_NEGATIVE_ADJ = 2; };\n" +
				"    	 };\n" +
				"        AUTOSTART = TRUE { START_VALUE = 125; TYPE = SYNCHRON; };\n" +
				"        LOCAL_TO_GLOBAL_TIME_SYNCHRONIZATION = TRUE { EXPLICIT_PRECISION = 125; SYNC_STRATEGY = EXPLICIT; };\n" +
				"    };\n" +
				"\n" +
				"    ALARM AlarmTask1 {\n" +
				"        COUNTER = system_timer;\n" +
				"        ACTION = SETEVENT { TASK = Task3; EVENT = TimerEvent; };\n" +
				"        AUTOSTART = TRUE { ALARMTIME = 250; CYCLETIME = 500; };\n" +
				"    };\n" +
				"\n" +
				"    ALARM AlarmTask2 {\n" +
				"        COUNTER = system_timer;\n" +
				"        ACTION = ACTIVATETASK { TASK = Task4; };\n" +
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

	@Test public void testTc27xOsApplMultiCore_kernelStack() {
	    final String text = "CPU test_application {\n" +
	    		"\n" +
	    		"  OS EE {\n" +
	    		"    EE_OPT = \"EE_DEBUG\";\n" +
	    		"    EE_OPT = \"__ASSERT__\";\n" +
	    		"    EE_OPT = \"EE_EXECUTE_FROM_RAM\";\n" +
	    		"\n" +
	    		"    REMOTENOTIFICATION = USE_RPC;\n" +
	    		"    MEMORY_PROTECTION = TRUE;\n" +
	    		"    KERNEL_STACKS = TRUE;\n" +
	    		"\n" +
	    		"    MASTER_CPU = \"master\";\n" +
	    		"\n" +
	    		"    CPU_DATA = TRICORE {\n" +
	    		"      ID = \"master\";\n" +
	    		"      CPU_CLOCK = 200.0;\n" +
	    		"      APP_SRC = \"custom_cstart.c\";\n" +
	    		"      APP_SRC = \"master.c\";\n" +
	    		"      MULTI_STACK = TRUE;\n" +
	    		"      SYS_STACK_SIZE = 4096;\n" +
	    		"      COMPILER_TYPE = GNU;\n" +
	    		"    };\n" +
	    		"\n" +
	    		"    CPU_DATA = TRICORE {\n" +
	    		"      ID = \"slave1\";\n" +
	    		"      APP_SRC = \"custom_cstart.c\";\n" +
	    		"      APP_SRC = \"slave1.c\";\n" +
	    		"      MULTI_STACK = TRUE;\n" +
	    		"      SYS_STACK_SIZE = 4096;\n" +
	    		"      COMPILER_TYPE = GNU;\n" +
	    		"    };\n" +
	    		"\n" +
	    		"    CPU_DATA = TRICORE {\n" +
	    		"      ID = \"slave2\";\n" +
	    		"      APP_SRC = \"custom_cstart.c\";\n" +
	    		"      APP_SRC = \"slave2.c\";\n" +
	    		"      MULTI_STACK = TRUE;\n" +
	    		"      SYS_STACK_SIZE = 4096;\n" +
	    		"      COMPILER_TYPE = GNU;\n" +
	    		"    };\n" +
	    		"\n" +
	    		"    MCU_DATA = TRICORE {\n" +
	    		"      MODEL = TC27x;\n" +
	    		"    };\n" +
	    		"\n" +
	    		"    STATUS = STANDARD;\n" +
	    		"    KERNEL_TYPE = BCC1;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  TASK TaskMaster {\n" +
	    		"    CPU_ID = \"master\";\n" +
	    		"    PRIORITY = 1;\n" +
	    		"    AUTOSTART = TRUE;\n" +
	    		"    STACK = SHARED;\n" +
	    		"    ACTIVATION = 1;\n" +
	    		"    SCHEDULE = FULL;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  TASK TaskSlave1 {\n" +
	    		"    CPU_ID = \"slave1\";\n" +
	    		"    PRIORITY = 1;\n" +
	    		"    AUTOSTART = FALSE;\n" +
	    		"    STACK = SHARED;\n" +
	    		"    ACTIVATION = 1;\n" +
	    		"    SCHEDULE = FULL;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  TASK TaskSlave2a {\n" +
	    		"    CPU_ID = \"slave2\";\n" +
	    		"    PRIORITY = 1;\n" +
	    		"    AUTOSTART = FALSE;\n" +
	    		"    STACK = SHARED;\n" +
	    		"    ACTIVATION = 1;\n" +
	    		"    SCHEDULE = FULL;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  TASK TaskSlave2b {\n" +
	    		"    CPU_ID = \"slave2\";\n" +
	    		"    PRIORITY = 1;\n" +
	    		"    AUTOSTART = FALSE;\n" +
	    		"    STACK = SHARED;\n" +
	    		"    ACTIVATION = 1;\n" +
	    		"    SCHEDULE = FULL;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  ISR STM0_isr2_core0 {\n" +
	    		"    CPU_ID = \"master\";\n" +
	    		"    CATEGORY = 2;\n" +
	    		"    PRIORITY = 2;\n" +
	    		"    HANDLER = \"STM0_isr2\"; // IRQ handler \n" +
	    		"  };\n" +
	    		"\n" +
	    		"  ISR STM0_isr2_core1 {\n" +
	    		"    CPU_ID = \"slave1\";\n" +
	    		"    CATEGORY = 2;\n" +
	    		"    PRIORITY = 2;\n" +
	    		"    HANDLER = \"STM0_isr2\"; // IRQ handler \n" +
	    		"  };\n" +
	    		"\n" +
	    		"  ISR STM0_isr2_core2 {\n" +
	    		"    CPU_ID = \"slave2\";\n" +
	    		"    CATEGORY = 2;\n" +
	    		"    PRIORITY = 2;\n" +
	    		"    HANDLER = \"STM0_isr2\"; // IRQ handler \n" +
	    		"  };\n" +
	    		"\n" +
	    		"  APPLICATION MasterApplication {\n" +
	    		"    CPU_ID = \"master\";\n" +
	    		"    TRUSTED = TRUE;\n" +
	    		"    ISR = STM0_isr2_core0;\n" +
	    		"    TASK = TaskMaster;\n" +
	    		"//  MEMORY_BASE = 0x70030000;\n" +
	    		"//  MEMORY_SIZE = 0x00010000;\n" +
	    		"    SHARED_STACK_SIZE = 512;\n" +
	    		"    IRQ_STACK_SIZE = 512;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  APPLICATION Slave1Application {\n" +
	    		"    CPU_ID = \"slave1\";\n" +
	    		"    TRUSTED = TRUE;\n" +
	    		"    ISR = STM0_isr2_core1;\n" +
	    		"    TASK = TaskSlave1;\n" +
	    		"//  MEMORY_BASE = 0x60030000;\n" +
	    		"//  MEMORY_SIZE = 0x00010000;\n" +
	    		"    SHARED_STACK_SIZE = 512;\n" +
	    		"    IRQ_STACK_SIZE = 512;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  APPLICATION Slave2aApplication {\n" +
	    		"    CPU_ID = \"slave2\";\n" +
	    		"    TRUSTED = TRUE;\n" +
	    		"    ISR = STM0_isr2_core2;\n" +
	    		"    TASK = TaskSlave2a;\n" +
	    		"//  MEMORY_BASE = 0x50030000;\n" +
	    		"//  MEMORY_SIZE = 0x00010000;\n" +
	    		"    SHARED_STACK_SIZE = 512;\n" +
	    		"    IRQ_STACK_SIZE = 512;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  APPLICATION Slave2bApplication {\n" +
	    		"    CPU_ID = \"slave2\";\n" +
	    		"    TRUSTED = TRUE;\n" +
	    		"    TASK = TaskSlave2b;\n" +
	    		"//  MEMORY_BASE = 0x50030000;\n" +
	    		"//  MEMORY_SIZE = 0x00010000;\n" +
	    		"    SHARED_STACK_SIZE = 512;\n" +
	    		"    IRQ_STACK_SIZE = 512;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"};\n";
		commonWriterTest(text, 3);
	}


	@Test public void testTc27xOsApplMultiCore_kernelStack_servprot() {
	    final String text = "CPU test_application {\n" +
	    		"\n" +
	    		"  OS EE {\n" +
	    		"    EE_OPT = \"EE_DEBUG\";\n" +
	    		"    EE_OPT = \"__ASSERT__\";\n" +
	    		"    EE_OPT = \"EE_EXECUTE_FROM_RAM\";\n" +
	    		"\n" +
	    		"    REMOTENOTIFICATION = USE_RPC;\n" +
	    		"    MEMORY_PROTECTION = TRUE;\n" +
	    		"    KERNEL_STACKS = TRUE;\n" +
	    		"    SERVICE_PROTECTION = TRUE;\n" +
	    		"\n" +
	    		"    MASTER_CPU = \"master\";\n" +
	    		"\n" +
	    		"    CPU_DATA = TRICORE {\n" +
	    		"      ID = \"master\";\n" +
	    		"      CPU_CLOCK = 200.0;\n" +
	    		"      APP_SRC = \"custom_cstart.c\";\n" +
	    		"      APP_SRC = \"master.c\";\n" +
	    		"      MULTI_STACK = TRUE;\n" +
	    		"      SYS_STACK_SIZE = 4096;\n" +
	    		"      COMPILER_TYPE = GNU;\n" +
	    		"    };\n" +
	    		"\n" +
	    		"    CPU_DATA = TRICORE {\n" +
	    		"      ID = \"slave1\";\n" +
	    		"      APP_SRC = \"custom_cstart.c\";\n" +
	    		"      APP_SRC = \"slave1.c\";\n" +
	    		"      MULTI_STACK = TRUE;\n" +
	    		"      SYS_STACK_SIZE = 4096;\n" +
	    		"      COMPILER_TYPE = GNU;\n" +
	    		"    };\n" +
	    		"\n" +
	    		"    CPU_DATA = TRICORE {\n" +
	    		"      ID = \"slave2\";\n" +
	    		"      APP_SRC = \"custom_cstart.c\";\n" +
	    		"      APP_SRC = \"slave2.c\";\n" +
	    		"      MULTI_STACK = TRUE;\n" +
	    		"      SYS_STACK_SIZE = 4096;\n" +
	    		"      COMPILER_TYPE = GNU;\n" +
	    		"    };\n" +
	    		"\n" +
	    		"    MCU_DATA = TRICORE {\n" +
	    		"      MODEL = TC27x;\n" +
	    		"    };\n" +
	    		"\n" +
	    		"    STATUS = STANDARD;\n" +
	    		"    KERNEL_TYPE = BCC1;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  TASK TaskMaster {\n" +
	    		"    CPU_ID = \"master\";\n" +
	    		"    PRIORITY = 1;\n" +
	    		"    AUTOSTART = TRUE;\n" +
	    		"    STACK = SHARED;\n" +
	    		"    ACTIVATION = 1;\n" +
	    		"    SCHEDULE = FULL;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  TASK TaskSlave1 {\n" +
	    		"    CPU_ID = \"slave1\";\n" +
	    		"    PRIORITY = 1;\n" +
	    		"    AUTOSTART = FALSE;\n" +
	    		"    STACK = SHARED;\n" +
	    		"    ACTIVATION = 1;\n" +
	    		"    SCHEDULE = FULL;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  TASK TaskSlave2a {\n" +
	    		"    CPU_ID = \"slave2\";\n" +
	    		"    PRIORITY = 1;\n" +
	    		"    AUTOSTART = FALSE;\n" +
	    		"    STACK = SHARED;\n" +
	    		"    ACTIVATION = 1;\n" +
	    		"    SCHEDULE = FULL;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  TASK TaskSlave2b {\n" +
	    		"    CPU_ID = \"slave2\";\n" +
	    		"    PRIORITY = 1;\n" +
	    		"    AUTOSTART = FALSE;\n" +
	    		"    STACK = SHARED;\n" +
	    		"    ACTIVATION = 1;\n" +
	    		"    SCHEDULE = FULL;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  ISR STM0_isr2_core0 {\n" +
	    		"    CPU_ID = \"master\";\n" +
	    		"    CATEGORY = 2;\n" +
	    		"    PRIORITY = 2;\n" +
	    		"    HANDLER = \"STM0_isr2\"; // IRQ handler \n" +
	    		"  };\n" +
	    		"\n" +
	    		"  ISR STM0_isr2_core1 {\n" +
	    		"    CPU_ID = \"slave1\";\n" +
	    		"    CATEGORY = 2;\n" +
	    		"    PRIORITY = 2;\n" +
	    		"    HANDLER = \"STM0_isr2\"; // IRQ handler \n" +
	    		"  };\n" +
	    		"\n" +
	    		"  ISR STM0_isr2_core2 {\n" +
	    		"    CPU_ID = \"slave2\";\n" +
	    		"    CATEGORY = 2;\n" +
	    		"    PRIORITY = 2;\n" +
	    		"    HANDLER = \"STM0_isr2\"; // IRQ handler \n" +
	    		"  };\n" +
	    		"\n" +
	    		"  APPLICATION MasterApplication {\n" +
	    		"    CPU_ID = \"master\";\n" +
	    		"    TRUSTED = TRUE;\n" +
	    		"    ISR = STM0_isr2_core0;\n" +
	    		"    TASK = TaskMaster;\n" +
	    		"//  MEMORY_BASE = 0x70030000;\n" +
	    		"//  MEMORY_SIZE = 0x00010000;\n" +
	    		"    SHARED_STACK_SIZE = 512;\n" +
	    		"    IRQ_STACK_SIZE = 512;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  APPLICATION Slave1Application {\n" +
	    		"    CPU_ID = \"slave1\";\n" +
	    		"    TRUSTED = TRUE;\n" +
	    		"    ISR = STM0_isr2_core1;\n" +
	    		"    TASK = TaskSlave1;\n" +
	    		"//  MEMORY_BASE = 0x60030000;\n" +
	    		"//  MEMORY_SIZE = 0x00010000;\n" +
	    		"    SHARED_STACK_SIZE = 512;\n" +
	    		"    IRQ_STACK_SIZE = 512;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  APPLICATION Slave2aApplication {\n" +
	    		"    CPU_ID = \"slave2\";\n" +
	    		"    TRUSTED = TRUE;\n" +
	    		"    ISR = STM0_isr2_core2;\n" +
	    		"    TASK = TaskSlave2a;\n" +
	    		"//  MEMORY_BASE = 0x50030000;\n" +
	    		"//  MEMORY_SIZE = 0x00010000;\n" +
	    		"    SHARED_STACK_SIZE = 512;\n" +
	    		"    IRQ_STACK_SIZE = 512;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  APPLICATION Slave2bApplication {\n" +
	    		"    CPU_ID = \"slave2\";\n" +
	    		"    TRUSTED = TRUE;\n" +
	    		"    TASK = TaskSlave2b;\n" +
	    		"//  MEMORY_BASE = 0x50030000;\n" +
	    		"//  MEMORY_SIZE = 0x00010000;\n" +
	    		"    SHARED_STACK_SIZE = 512;\n" +
	    		"    IRQ_STACK_SIZE = 512;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"};\n";
		commonWriterTest(text, 3);
	}


	@Test public void testTc27x_04_rpc_OsApplMultiCore_memProt() {
	    final String text = "CPU test_application {\n" +
	    		"\n" +
	    		"  OS EE {\n" +
	    		"    EE_OPT = \"EE_DEBUG\";\n" +
	    		"    EE_OPT = \"__ASSERT__\";\n" +
	    		"    //EE_OPT = \"EE_EXECUTE_FROM_RAM\";\n" +
	    		"    EE_OPT = \"EE_SAVE_TEMP_FILES\";\n" +
	    		"    //EE_OPT = \"EE_MM_OPT\";\n" +
	    		"    EE_OPT = \"EE_ICACHE_ENABLED\";\n" +
	    		"    EE_OPT = \"EE_DCACHE_ENABLED\";\n" +
	    		"\n" +
	    		"    //MEMORY_PROTECTION = TRUE;\n" +
	    		"    STACKMONITORING = TRUE;\n" +
	    		"    REMOTENOTIFICATION = USE_RPC;\n" +
	    		"\n" +
	    		"    //SPINLOCKS = QUEUED;\n" +
	    		"\n" +
	    		"    MASTER_CPU = \"master\";\n" +
	    		"\n" +
	    		"    CPU_DATA = TRICORE {\n" +
	    		"      ID = \"master\";\n" +
	    		"      CPU_CLOCK = 200.0;\n" +
	    		"      APP_SRC = \"master.c\";\n" +
	    		"      MULTI_STACK = TRUE;\n" +
	    		"      SYS_STACK_SIZE = 4096;\n" +
	    		"      COMPILER_TYPE = GNU;\n" +
	    		"      //COMPILER_TYPE = TASKING;\n" +
	    		"    };\n" +
	    		"\n" +
	    		"    CPU_DATA = TRICORE {\n" +
	    		"      ID = \"slave1\";\n" +
	    		"      APP_SRC = \"slave1.c\";\n" +
	    		"      MULTI_STACK = TRUE;\n" +
	    		"      SYS_STACK_SIZE = 4096;\n" +
	    		"      COMPILER_TYPE = GNU;\n" +
	    		"      //COMPILER_TYPE = TASKING;\n" +
	    		"    };\n" +
	    		"\n" +
	    		"    CPU_DATA = TRICORE {\n" +
	    		"      ID = \"slave2\";\n" +
	    		"      APP_SRC = \"slave2.c\";\n" +
	    		"      MULTI_STACK = TRUE;\n" +
	    		"      SYS_STACK_SIZE = 4096;\n" +
	    		"      COMPILER_TYPE = GNU;\n" +
	    		"      //COMPILER_TYPE = TASKING;\n" +
	    		"    };\n" +
	    		"\n" +
	    		"    MCU_DATA = TRICORE {\n" +
	    		"      MODEL = TC27x;\n" +
	    		"    };\n" +
	    		"\n" +
	    		"    STATUS = EXTENDED;\n" +
	    		"    ERRORHOOK = TRUE;\n" +
	    		"\n" +
	    		"    ORTI_SECTIONS = ALL;\n" +
	    		"\n" +
	    		"    KERNEL_TYPE = ECC1;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  TASK TaskMaster {\n" +
	    		"    CPU_ID = \"master\";\n" +
	    		"    PRIORITY = 1;\n" +
	    		"    AUTOSTART = TRUE;\n" +
	    		"    STACK = PRIVATE {\n" +
	    		"      SYS_SIZE = 256;\n" +
	    		"    };\n" +
	    		"    ACTIVATION = 1;\n" +
	    		"    SCHEDULE = FULL;\n" +
	    		"    EVENT = EventMaster;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  TASK TaskSlave1 {\n" +
	    		"    CPU_ID = \"slave1\";\n" +
	    		"    PRIORITY = 1;\n" +
	    		"    AUTOSTART = FALSE;\n" +
	    		"    STACK = PRIVATE {\n" +
	    		"      SYS_SIZE = 128;\n" +
	    		"    };\n" +
	    		"    ACTIVATION = 1;\n" +
	    		"    SCHEDULE = FULL;\n" +
	    		"    EVENT = EventSlave1;\n" +
	    		"	 ACCESSING_APPLICATION = Core2App;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  TASK TaskSlave2 {\n" +
	    		"    CPU_ID = \"slave2\";\n" +
	    		"    PRIORITY = 1;\n" +
	    		"    AUTOSTART = FALSE;\n" +
	    		"    STACK = SHARED;\n" +
	    		"    ACTIVATION = 1;\n" +
	    		"    SCHEDULE = FULL;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  EVENT EventMaster { MASK = AUTO; };\n" +
	    		"  EVENT EventSlave1 { MASK = AUTO; };\n" +
	    		"\n" +
	    		"  COUNTER CounterSlave2 {\n" +
	    		"    CPU_ID = \"slave2\";\n" +
	    		"    MINCYCLE = 1;\n" +
	    		"    MAXALLOWEDVALUE = 1;\n" +
	    		"    TICKSPERBASE = 1;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  ALARM AlarmSlave2 {\n" +
	    		"    COUNTER = CounterSlave2;\n" +
	    		"    ACTION = SETEVENT { TASK = TaskSlave1; EVENT = EventSlave1; };\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  APPLICATION Core0App {\n" +
	    		"    CPU_ID  = \"master\";\n" +
	    		"    TRUSTED = TRUE;\n" +
	    		"    TASK    = TaskMaster;\n" +
	    		"    MEMORY_SIZE = 0x1000;\n" +
	    		"    SHARED_STACK_SIZE = 256;\n" +
	    		"    IRQ_STACK_SIZE = 256;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  APPLICATION Core1App {\n" +
	    		"    CPU_ID  = \"slave1\";\n" +
	    		"    TRUSTED = FALSE;\n" +
	    		"    TASK    = TaskSlave1;\n" +
	    		"    MEMORY_SIZE = 0x1000;\n" +
	    		"    SHARED_STACK_SIZE = 256;\n" +
	    		"    IRQ_STACK_SIZE = 256;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  APPLICATION Core2App {\n" +
	    		"    CPU_ID  = \"slave2\";\n" +
	    		"    TRUSTED = FALSE;\n" +
	    		"    TASK    = TaskSlave2;\n" +
	    		"    COUNTER = CounterSlave2;\n" +
	    		"    ALARM   = AlarmSlave2;\n" +
	    		"    MEMORY_SIZE = 0x1000;\n" +
	    		"    SHARED_STACK_SIZE = 256;\n" +
	    		"    IRQ_STACK_SIZE = 256;\n" +
	    		"  };\n" +
	    		"};";
		commonWriterTest(text, 3);
	}


	@Test public void testTc27x_sched_multiCore() {
	    final String text = "CPU test_application {\n" +
	    		"\n" +
	    		"  OS EE {\n" +
	    		"    MEMORY_PROTECTION   = TRUE;\n" +
	    		"    //SERVICE_PROTECTION  = TRUE;\n" +
	    		"    STACKMONITORING     = TRUE;\n" +
	    		"    REMOTENOTIFICATION  = USE_RPC;\n" +
	    		"\n" +
	    		"    //SPINLOCKS = QUEUED;\n" +
	    		"\n" +
	    		"    MASTER_CPU = \"master\";\n" +
	    		"\n" +
	    		"    CPU_DATA = TRICORE {\n" +
	    		"      ID = \"master\";\n" +
	    		"      CPU_CLOCK = 200.0;\n" +
	    		"      APP_SRC = \"master.c\";\n" +
	    		"      MULTI_STACK = TRUE;\n" +
	    		"      SYS_STACK_SIZE = 4096;\n" +
	    		"      COMPILER_TYPE = GNU;\n" +
	    		"    };\n" +
	    		"\n" +
	    		"    CPU_DATA = TRICORE {\n" +
	    		"      ID = \"slave1\";\n" +
	    		"      APP_SRC = \"slave1.c\";\n" +
	    		"      MULTI_STACK = TRUE;\n" +
	    		"      SYS_STACK_SIZE = 4096;\n" +
	    		"      COMPILER_TYPE = GNU;\n" +
	    		"    };\n" +
	    		"\n" +
	    		"    CPU_DATA = TRICORE {\n" +
	    		"      ID = \"slave2\";\n" +
	    		"      APP_SRC = \"slave2.c\";\n" +
	    		"      MULTI_STACK = TRUE;\n" +
	    		"      SYS_STACK_SIZE = 4096;\n" +
	    		"      COMPILER_TYPE = GNU;\n" +
	    		"    };\n" +
	    		"\n" +
	    		"    MCU_DATA = TRICORE {\n" +
	    		"      MODEL = TC27x;\n" +
	    		"    };\n" +
	    		"\n" +
	    		"    STATUS = EXTENDED;\n" +
	    		"    ERRORHOOK = TRUE;\n" +
	    		"\n" +
	    		"    ORTI_SECTIONS = ALL;\n" +
	    		"\n" +
	    		"    KERNEL_TYPE = ECC1;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  TASK TaskMaster {\n" +
	    		"    CPU_ID = \"master\";\n" +
	    		"    PRIORITY = 1;\n" +
	    		"    AUTOSTART = TRUE;\n" +
	    		"    STACK = PRIVATE {\n" +
	    		"      SYS_SIZE = 256;\n" +
	    		"    };\n" +
	    		"    ACTIVATION = 1;\n" +
	    		"    SCHEDULE = FULL;\n" +
	    		"    EVENT = EventMaster;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  TASK TaskSlave1 {\n" +
	    		"    CPU_ID = \"slave1\";\n" +
	    		"    PRIORITY = 1;\n" +
	    		"    AUTOSTART = FALSE;\n" +
	    		"    STACK = PRIVATE {\n" +
	    		"      SYS_SIZE = 128;\n" +
	    		"    };\n" +
	    		"    ACTIVATION = 1;\n" +
	    		"    SCHEDULE = FULL;\n" +
	    		"    EVENT = EventSlave1;\n" +
	    		"    ACCESSING_APPLICATION = Core2App;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  TASK TaskSlave2 {\n" +
	    		"    CPU_ID = \"slave2\";\n" +
	    		"    PRIORITY = 1;\n" +
	    		"    AUTOSTART = FALSE;\n" +
	    		"    STACK = SHARED;\n" +
	    		"    ACTIVATION = 1;\n" +
	    		"    SCHEDULE = FULL;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  EVENT EventMaster { MASK = AUTO; };\n" +
	    		"  EVENT EventSlave1 { MASK = AUTO; };\n" +
	    		"\n" +
	    		"  COUNTER CounterSlave2 {\n" +
	    		"    CPU_ID = \"slave2\";\n" +
	    		"    MINCYCLE = 1;\n" +
	    		"    MAXALLOWEDVALUE = 1;\n" +
	    		"    TICKSPERBASE = 1;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  ALARM AlarmSlave2 {\n" +
	    		"    COUNTER = CounterSlave2;\n" +
	    		"    ACTION = SETEVENT { TASK = TaskSlave1; EVENT = EventSlave1; };\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  SCHEDULETABLE ScheduleTableSlave2 {\n" +
	    		"    CPU_ID  = \"slave2\";\n" +
	    		"    COUNTER = CounterSlave2;\n" +
	    		"    DURATION = 1;\n" +
	    		"    REPEATING = FALSE;\n" +
	    		"    AUTOSTART = FALSE;\n" +
	    		"    EXPIRE_POINT = ACTION {\n" +
	    		"      EXPIRE_VALUE = 1;\n" +
	    		"      ACTION = SETEVENT { TASK = TaskSlave1; EVENT = EventSlave1; };\n" +
	    		"      SYNC_ADJUSTMENT = FALSE;\n" +
	    		"    };\n" +
	    		"    LOCAL_TO_GLOBAL_TIME_SYNCHRONIZATION = FALSE;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  APPLICATION Core0App {\n" +
	    		"    CPU_ID  = \"master\";\n" +
	    		"    TRUSTED = TRUE;\n" +
	    		"    TASK    = TaskMaster;\n" +
	    		"    MEMORY_SIZE = 0x1000;\n" +
	    		"    SHARED_STACK_SIZE = 256;\n" +
	    		"    IRQ_STACK_SIZE = 256;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  APPLICATION Core1App {\n" +
	    		"    CPU_ID  = \"slave1\";\n" +
	    		"    TRUSTED = FALSE;\n" +
	    		"    TASK    = TaskSlave1;\n" +
	    		"    MEMORY_SIZE = 0x1000;\n" +
	    		"    SHARED_STACK_SIZE = 256;\n" +
	    		"    IRQ_STACK_SIZE = 256;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  APPLICATION Core2App {\n" +
	    		"    CPU_ID  = \"slave2\";\n" +
	    		"    TRUSTED = FALSE;\n" +
	    		"    TASK    = TaskSlave2;\n" +
	    		"    COUNTER = CounterSlave2;\n" +
	    		"    ALARM   = AlarmSlave2;\n" +
	    		"    SCHEDULETABLE = ScheduleTableSlave2;\n" +
	    		"    MEMORY_SIZE = 0x1000;\n" +
	    		"    SHARED_STACK_SIZE = 256;\n" +
	    		"    IRQ_STACK_SIZE = 256;\n" +
	    		"  };\n" +
	    		"};\n";
		commonWriterTest(text, 3);
	}

	@Test public void testTc27x_sched_multiCore_osAppl() {
	    final String text = "CPU test_application {\n" +
	    		"  OS EE {\n" +
	    		"    MEMORY_PROTECTION   = TRUE;\n" +
	    		"    //SERVICE_PROTECTION  = TRUE;\n" +
	    		"    STACKMONITORING     = TRUE;\n" +
	    		"    REMOTENOTIFICATION  = USE_RPC;\n" +
	    		"\n" +
	    		"    //SPINLOCKS = QUEUED;\n" +
	    		"\n" +
	    		"    MASTER_CPU = \"master\";\n" +
	    		"\n" +
	    		"    CPU_DATA = TRICORE {\n" +
	    		"      ID = \"master\";\n" +
	    		"      CPU_CLOCK = 200.0;\n" +
	    		"      APP_SRC = \"master.c\";\n" +
	    		"      MULTI_STACK = TRUE;\n" +
	    		"      SYS_STACK_SIZE = 4096;\n" +
	    		"      COMPILER_TYPE = GNU;\n" +
	    		"    };\n" +
	    		"\n" +
	    		"    CPU_DATA = TRICORE {\n" +
	    		"      ID = \"slave1\";\n" +
	    		"      APP_SRC = \"slave1.c\";\n" +
	    		"      MULTI_STACK = TRUE;\n" +
	    		"      SYS_STACK_SIZE = 4096;\n" +
	    		"      COMPILER_TYPE = GNU;\n" +
	    		"    };\n" +
	    		"\n" +
	    		"    CPU_DATA = TRICORE {\n" +
	    		"      ID = \"slave2\";\n" +
	    		"      APP_SRC = \"slave2.c\";\n" +
	    		"      MULTI_STACK = TRUE;\n" +
	    		"      SYS_STACK_SIZE = 4096;\n" +
	    		"      COMPILER_TYPE = GNU;\n" +
	    		"    };\n" +
	    		"\n" +
	    		"    MCU_DATA = TRICORE {\n" +
	    		"      MODEL = TC27x;\n" +
	    		"    };\n" +
	    		"\n" +
	    		"    STATUS = EXTENDED;\n" +
	    		"    ERRORHOOK = TRUE;\n" +
	    		"\n" +
	    		"    ORTI_SECTIONS = ALL;\n" +
	    		"\n" +
	    		"    KERNEL_TYPE = ECC1;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  TASK TaskMaster {\n" +
	    		"    CPU_ID = \"master\";\n" +
	    		"    PRIORITY = 1;\n" +
	    		"    AUTOSTART = TRUE;\n" +
	    		"    STACK = PRIVATE {\n" +
	    		"      SYS_SIZE = 256;\n" +
	    		"    };\n" +
	    		"    ACTIVATION = 1;\n" +
	    		"    SCHEDULE = FULL;\n" +
	    		"    EVENT = EventMaster;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  TASK TaskSlave1 {\n" +
	    		"    CPU_ID = \"slave1\";\n" +
	    		"    PRIORITY = 1;\n" +
	    		"    AUTOSTART = FALSE;\n" +
	    		"    STACK = PRIVATE {\n" +
	    		"      SYS_SIZE = 128;\n" +
	    		"    };\n" +
	    		"    ACTIVATION = 1;\n" +
	    		"    SCHEDULE = FULL;\n" +
	    		"    EVENT = EventSlave1;\n" +
	    		"    ACCESSING_APPLICATION = Core0App;\n" +
	    		"    ACCESSING_APPLICATION = Core2App;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  TASK TaskSlave2 {\n" +
	    		"    CPU_ID = \"slave2\";\n" +
	    		"    PRIORITY = 1;\n" +
	    		"    AUTOSTART = FALSE;\n" +
	    		"    STACK = SHARED;\n" +
	    		"    ACTIVATION = 1;\n" +
	    		"    SCHEDULE = FULL;\n" +
	    		"    ACCESSING_APPLICATION = Core0App;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  EVENT EventMaster { MASK = AUTO; };\n" +
	    		"  EVENT EventSlave1 { MASK = AUTO; };\n" +
	    		"\n" +
	    		"  COUNTER CounterSlave2 {\n" +
	    		"    CPU_ID = \"slave2\";\n" +
	    		"    MINCYCLE = 1;\n" +
	    		"    MAXALLOWEDVALUE = 1;\n" +
	    		"    TICKSPERBASE = 1;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  ALARM AlarmSlave2 {\n" +
	    		"    COUNTER = CounterSlave2;\n" +
	    		"    ACTION = SETEVENT { TASK = TaskSlave1; EVENT = EventSlave1; };\n" +
	    		"    ACCESSING_APPLICATION = Core0App;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  SCHEDULETABLE ScheduleTableSlave2 {\n" +
	    		"    CPU_ID  = \"slave2\";\n" +
	    		"    COUNTER = CounterSlave2;\n" +
	    		"    DURATION = 1;\n" +
	    		"    REPEATING = FALSE;\n" +
	    		"    AUTOSTART = FALSE;\n" +
	    		"    EXPIRE_POINT = ACTION {\n" +
	    		"      EXPIRE_VALUE = 1;\n" +
	    		"      ACTION = SETEVENT { TASK = TaskSlave1; EVENT = EventSlave1; };\n" +
	    		"      SYNC_ADJUSTMENT = FALSE;\n" +
	    		"    };\n" +
	    		"    LOCAL_TO_GLOBAL_TIME_SYNCHRONIZATION = FALSE;\n" +
	    		"    ACCESSING_APPLICATION = Core0App;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  APPLICATION Core0App {\n" +
	    		"    CPU_ID  = \"master\";\n" +
	    		"    TRUSTED = TRUE;\n" +
	    		"    TASK    = TaskMaster;\n" +
	    		"    MEMORY_SIZE = 0x1000;\n" +
	    		"    SHARED_STACK_SIZE = 256;\n" +
	    		"    IRQ_STACK_SIZE = 256;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  APPLICATION Core1App {\n" +
	    		"    CPU_ID  = \"slave1\";\n" +
	    		"    TRUSTED = FALSE;\n" +
	    		"    TASK    = TaskSlave1;\n" +
	    		"    MEMORY_SIZE = 0x1000;\n" +
	    		"    SHARED_STACK_SIZE = 256;\n" +
	    		"    IRQ_STACK_SIZE = 256;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  APPLICATION Core2App {\n" +
	    		"    CPU_ID  = \"slave2\";\n" +
	    		"    TRUSTED = FALSE;\n" +
	    		"    TASK    = TaskSlave2;\n" +
	    		"    COUNTER = CounterSlave2;\n" +
	    		"    ALARM   = AlarmSlave2;\n" +
	    		"    SCHEDULETABLE = ScheduleTableSlave2;\n" +
	    		"    MEMORY_SIZE = 0x1000;\n" +
	    		"    SHARED_STACK_SIZE = 256;\n" +
	    		"    IRQ_STACK_SIZE = 256;\n" +
	    		"  };\n" +
	    		"};\n";
		commonWriterTest(text, 3);
	}

	@Test public void testTc27x_sched_multiCore_osAppl_2() {
	    final String text = "CPU test_application {\n" +
	    		"  OS EE {\n" +
	    		"    MEMORY_PROTECTION   = TRUE;\n" +
	    		"    SERVICE_PROTECTION  = TRUE;\n" +
	    		"    STACKMONITORING     = TRUE;\n" +
	    		"    REMOTENOTIFICATION  = USE_RPC;\n" +
	    		"\n" +
	    		"    //SPINLOCKS = QUEUED;\n" +
	    		"\n" +
	    		"    MASTER_CPU = \"master\";\n" +
	    		"\n" +
	    		"    CPU_DATA = TRICORE {\n" +
	    		"      ID = \"master\";\n" +
	    		"      CPU_CLOCK = 200.0;\n" +
	    		"      APP_SRC = \"master.c\";\n" +
	    		"      MULTI_STACK = TRUE;\n" +
	    		"      SYS_STACK_SIZE = 4096;\n" +
	    		"      COMPILER_TYPE = GNU;\n" +
	    		"    };\n" +
	    		"\n" +
	    		"    CPU_DATA = TRICORE {\n" +
	    		"      ID = \"slave1\";\n" +
	    		"      APP_SRC = \"slave1.c\";\n" +
	    		"      MULTI_STACK = TRUE;\n" +
	    		"      SYS_STACK_SIZE = 4096;\n" +
	    		"      COMPILER_TYPE = GNU;\n" +
	    		"    };\n" +
	    		"\n" +
	    		"    CPU_DATA = TRICORE {\n" +
	    		"      ID = \"slave2\";\n" +
	    		"      APP_SRC = \"slave2.c\";\n" +
	    		"      MULTI_STACK = TRUE;\n" +
	    		"      SYS_STACK_SIZE = 4096;\n" +
	    		"      COMPILER_TYPE = GNU;\n" +
	    		"    };\n" +
	    		"\n" +
	    		"    MCU_DATA = TRICORE {\n" +
	    		"      MODEL = TC27x;\n" +
	    		"    };\n" +
	    		"\n" +
	    		"    STATUS = EXTENDED;\n" +
	    		"    ERRORHOOK = TRUE;\n" +
	    		"\n" +
	    		"    ORTI_SECTIONS = ALL;\n" +
	    		"\n" +
	    		"    KERNEL_TYPE = ECC1;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  TASK TaskMaster {\n" +
	    		"    CPU_ID = \"master\";\n" +
	    		"    PRIORITY = 1;\n" +
	    		"    AUTOSTART = TRUE;\n" +
	    		"    STACK = PRIVATE {\n" +
	    		"      SYS_SIZE = 256;\n" +
	    		"    };\n" +
	    		"    ACTIVATION = 1;\n" +
	    		"    SCHEDULE = FULL;\n" +
	    		"    EVENT = EventMaster;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  TASK TaskSlave1 {\n" +
	    		"    CPU_ID = \"slave1\";\n" +
	    		"    PRIORITY = 1;\n" +
	    		"    AUTOSTART = FALSE;\n" +
	    		"    STACK = PRIVATE {\n" +
	    		"      SYS_SIZE = 128;\n" +
	    		"    };\n" +
	    		"    ACTIVATION = 1;\n" +
	    		"    SCHEDULE = FULL;\n" +
	    		"    EVENT = EventSlave1;\n" +
	    		"    ACCESSING_APPLICATION = Core0App;\n" +
	    		"    ACCESSING_APPLICATION = Core2App;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  TASK TaskSlave2 {\n" +
	    		"    CPU_ID = \"slave2\";\n" +
	    		"    PRIORITY = 1;\n" +
	    		"    AUTOSTART = FALSE;\n" +
	    		"    STACK = SHARED;\n" +
	    		"    ACTIVATION = 1;\n" +
	    		"    SCHEDULE = FULL;\n" +
	    		"    ACCESSING_APPLICATION = Core0App;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  EVENT EventMaster { MASK = AUTO; };\n" +
	    		"  EVENT EventSlave1 { MASK = AUTO; };\n" +
	    		"\n" +
	    		"  COUNTER CounterSlave2 {\n" +
	    		"    CPU_ID = \"slave2\";\n" +
	    		"    MINCYCLE = 1;\n" +
	    		"    MAXALLOWEDVALUE = 1;\n" +
	    		"    TICKSPERBASE = 1;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  ALARM AlarmSlave2 {\n" +
	    		"    COUNTER = CounterSlave2;\n" +
	    		"    ACTION = SETEVENT { TASK = TaskSlave1; EVENT = EventSlave1; };\n" +
	    		"    ACCESSING_APPLICATION = Core0App;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  SCHEDULETABLE ScheduleTableSlave2 {\n" +
	    		"    CPU_ID  = \"slave2\";\n" +
	    		"    COUNTER = CounterSlave2;\n" +
	    		"    DURATION = 1;\n" +
	    		"    REPEATING = FALSE;\n" +
	    		"    AUTOSTART = FALSE;\n" +
	    		"    EXPIRE_POINT = ACTION {\n" +
	    		"      EXPIRE_VALUE = 1;\n" +
	    		"      ACTION = SETEVENT { TASK = TaskSlave1; EVENT = EventSlave1; };\n" +
	    		"      SYNC_ADJUSTMENT = FALSE;\n" +
	    		"    };\n" +
	    		"    LOCAL_TO_GLOBAL_TIME_SYNCHRONIZATION = FALSE;\n" +
	    		"    ACCESSING_APPLICATION = Core0App;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  APPLICATION Core0App {\n" +
	    		"    CPU_ID  = \"master\";\n" +
	    		"    TRUSTED = TRUE;\n" +
	    		"    TASK    = TaskMaster;\n" +
	    		"    MEMORY_SIZE = 0x1000;\n" +
	    		"    SHARED_STACK_SIZE = 256;\n" +
	    		"    IRQ_STACK_SIZE = 256;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  APPLICATION Core1App {\n" +
	    		"    CPU_ID  = \"slave1\";\n" +
	    		"    TRUSTED = FALSE;\n" +
	    		"    TASK    = TaskSlave1;\n" +
	    		"    MEMORY_SIZE = 0x1000;\n" +
	    		"    SHARED_STACK_SIZE = 256;\n" +
	    		"    IRQ_STACK_SIZE = 256;\n" +
	    		"  };\n" +
	    		"\n" +
	    		"  APPLICATION Core2App {\n" +
	    		"    CPU_ID  = \"slave2\";\n" +
	    		"    TRUSTED = FALSE;\n" +
	    		"    TASK    = TaskSlave2;\n" +
	    		"    COUNTER = CounterSlave2;\n" +
	    		"    ALARM   = AlarmSlave2;\n" +
	    		"    SCHEDULETABLE = ScheduleTableSlave2;\n" +
	    		"    MEMORY_SIZE = 0x1000;\n" +
	    		"    SHARED_STACK_SIZE = 256;\n" +
	    		"    IRQ_STACK_SIZE = 256;\n" +
	    		"  };\n" +
	    		"};\n";
	    commonWriterTest(text, 3);
	}
	
	@Test public void testTc27xOsApplMultiCore_accessMask3() {
		final String text = "CPU test_application {\n" +
			"  OS EE {\n" +
			"    EE_OPT = \"EE_DEBUG\";\n" +
			"    EE_OPT = \"__ASSERT__\";\n" +
			"    EE_OPT = \"EE_ICACHE_ENABLED\";\n" +
			"    EE_OPT = \"EE_DCACHE_ENABLED\";\n" +
			"\n" +
			"    //SPINLOCKS = QUEUED;\n" +
			"    MEMORY_PROTECTION   = TRUE;\n" +
			"    STACKMONITORING     = TRUE;\n" +
			"    REMOTENOTIFICATION  = USE_RPC;\n" +
			"\n" +
			"    MASTER_CPU = \"master\";\n" +
			"\n" +
			"    CPU_DATA = TRICORE {\n" +
			"      ID = \"master\";\n" +
			"      CPU_CLOCK = 200.0;\n" +
			"      APP_SRC = \"master.c\";\n" +
			"      MULTI_STACK = TRUE;\n" +
			"      SYS_STACK_SIZE = 4096;\n" +
			"      COMPILER_TYPE = GNU;\n" +
			"    };\n" +
			"\n" +
			"    CPU_DATA = TRICORE {\n" +
			"      ID = \"slave1\";\n" +
			"      APP_SRC = \"slave1.c\";\n" +
			"      MULTI_STACK = TRUE;\n" +
			"      SYS_STACK_SIZE = 4096;\n" +
			"      COMPILER_TYPE = GNU;\n" +
			"    };\n" +
			"\n" +
			"    CPU_DATA = TRICORE {\n" +
			"      ID = \"slave2\";\n" +
			"      APP_SRC = \"slave2.c\";\n" +
			"      MULTI_STACK = TRUE;\n" +
			"      SYS_STACK_SIZE = 4096;\n" +
			"      COMPILER_TYPE = GNU;\n" +
			"    };\n" +
			"\n" +
			"    MCU_DATA = TRICORE {\n" +
			"      MODEL = TC27x;\n" +
			"    };\n" +
			"\n" +
			"    STATUS = EXTENDED;\n" +
			"    STARTUPHOOK   = TRUE;\n" +
			"    ERRORHOOK     = TRUE;\n" +
			"    SHUTDOWNHOOK     = TRUE;\n" +
			"\n" +
			"    USEREMOTETASK = ALWAYS;\n" +
			"    ORTI_SECTIONS = ALL;\n" +
			"\n" +
			"    KERNEL_TYPE = ECC1;\n" +
			"  };\n" +
			"\n" +
			"  TASK TaskMaster {\n" +
			"    CPU_ID = \"master\";\n" +
			"    PRIORITY = 1;\n" +
			"    AUTOSTART = TRUE;\n" +
			"    STACK = PRIVATE {\n" +
			"      SYS_SIZE = 512;\n" +
			"    };\n" +
			"    ACTIVATION = 1;\n" +
			"    SCHEDULE = FULL;\n" +
			"    EVENT = Event1;\n" +
			"    EVENT = Event2;\n" +
			"  };\n" +
			"\n" +
			"  TASK TaskMaster2 {\n" +
			"    CPU_ID = \"master\";\n" +
			"    PRIORITY = 2;\n" +
			"    AUTOSTART = FALSE;\n" +
			"    STACK = PRIVATE {\n" +
			"      SYS_SIZE = 512;\n" +
			"    };\n" +
			"    ACTIVATION = 1;\n" +
			"    SCHEDULE = FULL;\n" +
			"    EVENT = Event1;\n" +
			"    EVENT = Event2;\n" +
			"  };\n" +
			"\n" +
			"  TASK TaskSlave1 {\n" +
			"    CPU_ID = \"slave1\";\n" +
			"    PRIORITY = 1;\n" +
			"    AUTOSTART = FALSE;\n" +
			"    STACK = SHARED;\n" +
			"    ACTIVATION = 1;\n" +
			"    SCHEDULE = FULL;\n" +
			"    ACCESSING_APPLICATION = MasterApp;\n" +
			"  };\n" +
			"\n" +
			"  TASK TaskSlave2 {\n" +
			"    CPU_ID = \"slave2\";\n" +
			"    PRIORITY = 1;\n" +
			"    AUTOSTART = FALSE;\n" +
			"    STACK = SHARED;\n" +
			"    ACTIVATION = 1;\n" +
			"    SCHEDULE = FULL;\n" +
			"    ACCESSING_APPLICATION = MasterApp;\n" +
			"  };\n" +
			"\n" +
			"  ISR isr_spin {\n" +
			"    CPU_ID = \"master\";\n" +
			"    CATEGORY = 2;\n" +
			"    PRIORITY = 2;\n" +
			"  };\n" +
			"\n" +
			"  SPINLOCK spinlock_1 { NEXT_SPINLOCK=spinlock_2; };\n" +
			"  SPINLOCK spinlock_2 { NEXT_SPINLOCK=spinlock_3; };\n" +
			"  SPINLOCK spinlock_3 {  };\n" +
			"\n" +
			"  EVENT Event1 { MASK = AUTO; };\n" +
			"  EVENT Event2 { MASK = AUTO; };\n" +
			"\n" +
			"  APPLICATION MasterApp {\n" +
			"    CPU_ID  = \"master\";\n" +
			"    TRUSTED = TRUE;\n" +
			"    TASK    = TaskMaster;\n" +
			"    TASK    = TaskMaster2;\n" +
			"    ISR     = isr_spin;\n" +
			"    //MEMORY_SIZE = 0x1000;\n" +
			"    SHARED_STACK_SIZE = 256;\n" +
			"    IRQ_STACK_SIZE = 256;\n" +
			"  };\n" +
			"\n" +
			"  APPLICATION Slave1App {\n" +
			"    CPU_ID  = \"slave1\";\n" +
			"    TRUSTED = FALSE;\n" +
			"    TASK    = TaskSlave1;\n" +
			"    SHARED_STACK_SIZE = 256;\n" +
			"    IRQ_STACK_SIZE = 256;\n" +
			"  };\n" +
			"\n" +
			"  APPLICATION Slave2App {\n" +
			"    CPU_ID  = \"slave2\";\n" +
			"    TRUSTED = FALSE;\n" +
			"    TASK    = TaskSlave2;\n" +
			"    SHARED_STACK_SIZE = 256;\n" +
			"    IRQ_STACK_SIZE = 256;\n" +
			"  };\n" +
			"};";
		commonWriterTest(text, 3);
	}

		
	@Test public void testTc27xMulticoreRpcWithSpinlock_osAppl() {
		String text = "CPU test_application {\n" +
				"\n" +
				"  OS EE {\n" +
				"    EE_OPT = \"EE_DEBUG\";\n" +
				"    EE_OPT = \"__ASSERT__\";\n" +
				"    EE_OPT = \"EE_SAVE_TEMP_FILES\";\n" +
				"    EE_OPT = \"EE_ICACHE_ENABLED\";\n" +
				"    EE_OPT = \"EE_DCACHE_ENABLED\";\n" +
				"\n" +
				"    //SPINLOCKS = QUEUED;\n" +
				"    MEMORY_PROTECTION   = TRUE;\n" +
				"    REMOTENOTIFICATION  = USE_RPC;\n" +
				"\n" +
				"    MASTER_CPU = \"master\";\n" +
				"\n" +
				"    CPU_DATA = TRICORE {\n" +
				"      ID = \"master\";\n" +
				"      CPU_CLOCK = 200.0;\n" +
				"      APP_SRC = \"master.c\";\n" +
				"      MULTI_STACK = TRUE;\n" +
				"      SYS_STACK_SIZE = 4096;\n" +
				"      COMPILER_TYPE = GNU;\n" +
				"    };\n" +
				"\n" +
				"    CPU_DATA = TRICORE {\n" +
				"      ID = \"slave1\";\n" +
				"      APP_SRC = \"slave1.c\";\n" +
				"      MULTI_STACK = TRUE;\n" +
				"      SYS_STACK_SIZE = 4096;\n" +
				"      COMPILER_TYPE = GNU;\n" +
				"    };\n" +
				"\n" +
				"    CPU_DATA = TRICORE {\n" +
				"      ID = \"slave2\";\n" +
				"      APP_SRC = \"slave2.c\";\n" +
				"      MULTI_STACK = TRUE;\n" +
				"      SYS_STACK_SIZE = 4096;\n" +
				"      COMPILER_TYPE = GNU;\n" +
				"    };\n" +
				"\n" +
				"    MCU_DATA = TRICORE {\n" +
				"      MODEL = TC27x;\n" +
				"    };\n" +
				"\n" +
				"    STATUS = EXTENDED;\n" +
				"    STARTUPHOOK   = TRUE;\n" +
				"    ERRORHOOK     = TRUE;\n" +
				"\n" +
				"    USEREMOTETASK = ALWAYS;\n" +
				"    ORTI_SECTIONS = ALL;\n" +
				"\n" +
				"    KERNEL_TYPE = ECC1;\n" +
				"  };\n" +
				"\n" +
				"  TASK TaskMaster {\n" +
				"    CPU_ID = \"master\";\n" +
				"    PRIORITY = 1;\n" +
				"    AUTOSTART = TRUE;\n" +
				"    STACK = PRIVATE {\n" +
				"      SYS_SIZE = 512;\n" +
				"    };\n" +
				"    ACTIVATION = 1;\n" +
				"    SCHEDULE = FULL;\n" +
				"    EVENT = Event1;\n" +
				"    EVENT = Event2;\n" +
				"  };\n" +
				"\n" +
				"  TASK TaskMaster2 {\n" +
				"    CPU_ID = \"master\";\n" +
				"    PRIORITY = 2;\n" +
				"    AUTOSTART = FALSE;\n" +
				"    STACK = PRIVATE {\n" +
				"      SYS_SIZE = 512;\n" +
				"    };\n" +
				"    ACTIVATION = 1;\n" +
				"    SCHEDULE = FULL;\n" +
				"    EVENT = Event1;\n" +
				"    EVENT = Event2;\n" +
				"  };\n" +
				"\n" +
				"  TASK TaskSlave1 {\n" +
				"    CPU_ID = \"slave1\";\n" +
				"    PRIORITY = 1;\n" +
				"    AUTOSTART = FALSE;\n" +
				"    STACK = SHARED;\n" +
				"    ACTIVATION = 1;\n" +
				"    SCHEDULE = FULL;\n" +
				"    ACCESSING_APPLICATION = MasterApp;\n" +
				"  };\n" +
				"\n" +
				"  TASK TaskSlave2 {\n" +
				"    CPU_ID = \"slave2\";\n" +
				"    PRIORITY = 1;\n" +
				"    AUTOSTART = FALSE;\n" +
				"    STACK = SHARED;\n" +
				"    ACTIVATION = 1;\n" +
				"    SCHEDULE = FULL;\n" +
				"    ACCESSING_APPLICATION = MasterApp;\n" +
				"  };\n" +
				"\n" +
				"  ISR isr_spin {\n" +
				"    CPU_ID = \"master\";\n" +
				"    CATEGORY = 2;\n" +
				"    PRIORITY = 2;\n" +
				"  };\n" +
				"\n" +
				"  SPINLOCK spinlock_1 {\n" +
				"    NEXT_SPINLOCK=spinlock_2;\n" +
				"    ACCESSING_APPLICATION = MasterApp;\n" +
				"  };\n" +
				"  SPINLOCK spinlock_2 {\n" +
				"    NEXT_SPINLOCK=spinlock_3;\n" +
				"    ACCESSING_APPLICATION = MasterApp;\n" +
				"    ACCESSING_APPLICATION = Slave2App;\n" +
				"  };\n" +
				"\n" +
				"  SPINLOCK spinlock_3 {\n" +
				"    ACCESSING_APPLICATION = MasterApp;\n" +
				"    ACCESSING_APPLICATION = Slave1App;\n" +
				"  };\n" +
				"\n" +
				"  EVENT Event1 { MASK = AUTO; };\n" +
				"  EVENT Event2 { MASK = AUTO; };\n" +
				"\n" +
				"  APPLICATION MasterApp {\n" +
				"    CPU_ID  = \"master\";\n" +
				"    TRUSTED = TRUE;\n" +
				"    TASK    = TaskMaster;\n" +
				"    TASK    = TaskMaster2;\n" +
				"    ISR     = isr_spin;\n" +
				"    //MEMORY_SIZE = 0x1000;\n" +
				"    SHARED_STACK_SIZE = 256;\n" +
				"    IRQ_STACK_SIZE = 256;\n" +
				"  };\n" +
				"\n" +
				"  APPLICATION Slave1App {\n" +
				"    CPU_ID  = \"slave1\";\n" +
				"    TRUSTED = FALSE;\n" +
				"    TASK    = TaskSlave1;\n" +
				"    SHARED_STACK_SIZE = 256;\n" +
				"    IRQ_STACK_SIZE = 256;\n" +
				"  };\n" +
				"\n" +
				"  APPLICATION Slave2App {\n" +
				"    CPU_ID  = \"slave2\";\n" +
				"    TRUSTED = FALSE;\n" +
				"    TASK    = TaskSlave2;\n" +
				"    SHARED_STACK_SIZE = 256;\n" +
				"    IRQ_STACK_SIZE = 256;\n" +
				"  };\n" +
				"};";
			commonWriterTest(text, 3);
		}
	
		
		@Test public void testTc27xTimingProtection() {
			String text = "CPU test_application {\n" +
					"\n" +
					"  OS EE {\n" +
					"    EE_OPT = \"EE_DEBUG\";\n" +
					"    EE_OPT = \"__ASSERT__\";\n" +
					"    EE_OPT = \"EE_EXECUTE_FROM_RAM\";\n" +
					"    EE_OPT = \"EE_SAVE_TEMP_FILES\";\n" +
					"\n" +
					"    SERVICE_PROTECTION = TRUE;\n" +
					"\n" +
					"    CPU_DATA = TRICORE {\n" +
					"      CPU_CLOCK = 200.0;\n" +
					"      APP_SRC = \"code.c\";\n" +
					"      MULTI_STACK = TRUE;\n" +
					"      COMPILER_TYPE = GNU;\n" +
					"    };\n" +
					"\n" +
					"    MCU_DATA = TRICORE {\n" +
					"      MODEL = TC27x;\n" +
					"    };\n" +
					"\n" +
					"    STATUS        = EXTENDED;\n" +
					"    SHUTDOWNHOOK  = TRUE;\n" +
					"    KERNEL_TYPE = ECC1;\n" +
					"  };\n" +
					"\n" +
					"  TASK TaskPrio2 {\n" +
					"    PRIORITY = 2;\n" +
					"    AUTOSTART = FALSE;\n" +
					"    STACK = SHARED;\n" +
					"    ACTIVATION = 1;\n" +
					"    SCHEDULE = FULL;\n" +
			
					"    TIMING_PROTECTION = TRUE {\n" +
					"      MAXALLINTERRUPTLOCKTIME = 2;\n" +
					"      EXECUTIONBUDGET = 3;\n" +
					"      MAXOSINTERRUPTLOCKTIME = 4;\n" +
					"      TIMEFRAME = 5;\n" +
					"    };\n" +
					"  };\n" +
					"\n" +
					"  TASK TaskPrio1 {\n" +
					"    PRIORITY = 1;\n" +
					"    AUTOSTART = TRUE;\n" +
					"    STACK = PRIVATE {\n" +
					"      SYS_SIZE = 256;\n" +
					"    };\n" +
					"    ACTIVATION = 1;\n" +
					"    SCHEDULE = FULL;\n" +
					"    EVENT = EventTaskPrio1;\n" +
					"  };\n" +
					"\n" +
					"  EVENT EventTaskPrio1 { MASK = AUTO; };\n" +
					"\n" +
					"  COUNTER system_timer {\n" +
					"    MINCYCLE = 1;\n" +
					"    MAXALLOWEDVALUE = 2147483647;\n" +
					"    TICKSPERBASE = 1;\n" +
					"    TYPE = HARDWARE {\n" +
					"      DEVICE = \"STM_SR0\";\n" +
					"      SYSTEM_TIMER = TRUE;\n" +
					"      PRIORITY = 1;\n" +
					"    };\n" +
					"    SECONDSPERTICK = 0.001;\n" +
					"  };\n" +
					"\n" +
					"  SCHEDULETABLE ScheduleTable1 {\n" +
					"    COUNTER = system_timer;\n" +
					"    DURATION = 1;\n" +
					"    REPEATING = FALSE;\n" +
					"    AUTOSTART = TRUE {\n" +
					"      TYPE = ABSOLUTE;\n" +
					"      START_VALUE = 0;\n" +
					"    };\n" +
					"    EXPIRE_POINT = ACTION {\n" +
					"      EXPIRE_VALUE = 1;\n" +
					"      ACTION = ACTIVATETASK { TASK = TaskPrio2; };\n" +
					"      SYNC_ADJUSTMENT = FALSE;\n" +
					"    };\n" +
					"    EXPIRE_POINT = ACTION {\n" +
					"      EXPIRE_VALUE = 3;\n" +
					"      ACTION = SETEVENT { TASK = TaskPrio1; EVENT = EventTaskPrio1; };\n" +
					"      SYNC_ADJUSTMENT = FALSE;\n" +
					"    };\n" +
					"    LOCAL_TO_GLOBAL_TIME_SYNCHRONIZATION = FALSE;\n" +
					"  };\n" +
					"};\n";
		commonWriterTest(text, 1);
	}
		
		@Test public void testTc27xTimingProtection2() {
			String text = "CPU test_application {\n" +
					"\n" +
					"  OS EE {\n" +
					"    EE_OPT = \"EE_DEBUG\";\n" +
					"    EE_OPT = \"__ASSERT__\";\n" +
					"    EE_OPT = \"EE_EXECUTE_FROM_RAM\";\n" +
					"    EE_OPT = \"EE_SAVE_TEMP_FILES\";\n" +
					"\n" +
					"    SERVICE_PROTECTION = TRUE;\n" +
					"\n" +
					"    CPU_DATA = TRICORE {\n" +
					"      CPU_CLOCK = 200.0;\n" +
					"      APP_SRC = \"code.c\";\n" +
					"      MULTI_STACK = TRUE;\n" +
					"      COMPILER_TYPE = GNU;\n" +
					"    };\n" +
					"\n" +
					"    MCU_DATA = TRICORE {\n" +
					"      MODEL = TC27x;\n" +
					"    };\n" +
					"\n" +
					"    STATUS        = EXTENDED;\n" +
					"    SHUTDOWNHOOK  = TRUE;\n" +
					"    KERNEL_TYPE = ECC1;\n" +
					"  };\n" +
					"\n" +
					"  TASK TaskPrio2 {\n" +
					"    PRIORITY = 2;\n" +
					"    AUTOSTART = FALSE;\n" +
					"    STACK = SHARED;\n" +
					"    ACTIVATION = 1;\n" +
					"    SCHEDULE = FULL;\n" +
					"  };\n" +
					"\n" +
					"  TASK TaskPrio1 {\n" +
					"    PRIORITY = 1;\n" +
					"    AUTOSTART = TRUE;\n" +
					"    STACK = PRIVATE {\n" +
					"      SYS_SIZE = 256;\n" +
					"    };\n" +
					"    ACTIVATION = 1;\n" +
					"    SCHEDULE = FULL;\n" +
					"    EVENT = EventTaskPrio1;\n" +
					"	 RESOURCE = res1;\n" + 

					"    TIMING_PROTECTION = TRUE {\n" +
					"      MAXALLINTERRUPTLOCKTIME = 0.0001;\n" +
					"      EXECUTIONBUDGET = 0.0025;\n" +
					"      TIMEFRAME = 5;\n" +
					"	   RESOURCE = RESOURCELOCK {\n" + 
					"			RESOURCELOCKTIME = 0.0002;\n" + 
					"			RESOURCE = res1;\n" + 
					"			};\n" + 				
					"		};\n" +
					"  };\n" +
					"    RESOURCE res1 { RESOURCEPROPERTY = STANDARD; };\n" + 

					
					"  EVENT EventTaskPrio1 { MASK = AUTO; };\n" +
					"\n" +
					"  COUNTER system_timer {\n" +
					"    MINCYCLE = 1;\n" +
					"    MAXALLOWEDVALUE = 2147483647;\n" +
					"    TICKSPERBASE = 1;\n" +
					"    TYPE = HARDWARE {\n" +
					"      DEVICE = \"STM_SR0\";\n" +
					"      SYSTEM_TIMER = TRUE;\n" +
					"      PRIORITY = 1;\n" +
					"    };\n" +
					"    SECONDSPERTICK = 0.001;\n" +
					"  };\n" +
					"\n" +
					"  SCHEDULETABLE ScheduleTable1 {\n" +
					"    COUNTER = system_timer;\n" +
					"    DURATION = 1;\n" +
					"    REPEATING = FALSE;\n" +
					"    AUTOSTART = TRUE {\n" +
					"      TYPE = ABSOLUTE;\n" +
					"      START_VALUE = 0;\n" +
					"    };\n" +
					"    EXPIRE_POINT = ACTION {\n" +
					"      EXPIRE_VALUE = 1;\n" +
					"      ACTION = ACTIVATETASK { TASK = TaskPrio2; };\n" +
					"      SYNC_ADJUSTMENT = FALSE;\n" +
					"    };\n" +
					"    EXPIRE_POINT = ACTION {\n" +
					"      EXPIRE_VALUE = 3;\n" +
					"      ACTION = SETEVENT { TASK = TaskPrio1; EVENT = EventTaskPrio1; };\n" +
					"      SYNC_ADJUSTMENT = FALSE;\n" +
					"    };\n" +
					"    LOCAL_TO_GLOBAL_TIME_SYNCHRONIZATION = FALSE;\n" +
					"  };\n" +
					"};\n";
		commonWriterTest(text, 1);
	}

		
		@Test public void testTpTask() {
			String text = "CPU test_application {\n" +
					"\n" +
					"  OS EE {\n" +
					"    EE_OPT = \"EE_DEBUG\";\n" +
					"    EE_OPT = \"__ASSERT__\";\n" +
					"    EE_OPT = \"EE_EXECUTE_FROM_RAM\";\n" +
					"    EE_OPT = \"EE_SAVE_TEMP_FILES\";\n" +
					"\n" +
					"    SERVICE_PROTECTION = TRUE;\n" +
					"    TIMEFRAMERECLAMATION = FALSE;\n" +
					"\n" +
					"    CPU_DATA = TRICORE {\n" +
					"      CPU_CLOCK = 200.0;\n" +
					"      APP_SRC = \"code.c\";\n" +
					"      MULTI_STACK = TRUE;\n" +
					"      COMPILER_TYPE = GNU;\n" +
					"    };\n" +
					"\n" +
					"    MCU_DATA = TRICORE {\n" +
					"      MODEL = TC26x;\n" +
					"    };\n" +
					"\n" +
					"    STATUS        = EXTENDED;\n" +
					"    SHUTDOWNHOOK  = TRUE;\n" +
					"    KERNEL_TYPE = ECC1;\n" +
					"  };\n" +
					"\n" +
					"  TASK TaskPrio2 {\n" +
					"    PRIORITY = 2;\n" +
					"    AUTOSTART = FALSE;\n" +
					"    STACK = SHARED;\n" +
					"    ACTIVATION = 1;\n" +
					"    SCHEDULE = FULL;\n" +
					"    RESOURCE = RES_SCHEDULER;\n" +
					"  };\n" +
					"\n" +
					"  TASK TaskPrio1 {\n" +
					"    PRIORITY = 1;\n" +
					"    AUTOSTART = TRUE;\n" +
					"    STACK = PRIVATE {\n" +
					"      SYS_SIZE = 256;\n" +
					"    };\n" +
					"    ACTIVATION = 1;\n" +
					"    SCHEDULE = FULL;\n" +
					"    EVENT = EventTaskPrio1;\n" +
					"    RESOURCE = RES_SCHEDULER;\n" +
					"    TIMING_PROTECTION = TRUE {\n" +
					"      EXECUTIONBUDGET         = 0.0025;\n" +
					"      MAXALLINTERRUPTLOCKTIME = 0.0001;\n" +
					"      RESOURCE = RESOURCELOCK {\n" +
					"        RESOURCELOCKTIME = 0.0002;\n" +
					"        RESOURCE = RES_SCHEDULER;\n" +
					"      };\n" +
					"    };\n" +
					"  };\n" +
					"\n" +
					"  RESOURCE RES_SCHEDULER { RESOURCEPROPERTY = STANDARD; };\n" +
					"  EVENT EventTaskPrio1 { MASK = AUTO; };\n" +
					"\n" +
					"  COUNTER system_timer {\n" +
					"    MINCYCLE = 1;\n" +
					"    MAXALLOWEDVALUE = 2147483647;\n" +
					"    TICKSPERBASE = 1;\n" +
					"    TYPE = HARDWARE {\n" +
					"      DEVICE = \"STM_SR0\";\n" +
					"      SYSTEM_TIMER = TRUE;\n" +
					"      PRIORITY = 1;\n" +
					"    };\n" +
					"    SECONDSPERTICK = 0.001;\n" +
					"  };\n" +
					"\n" +
					"  SCHEDULETABLE ScheduleTable1 {\n" +
					"    COUNTER = system_timer;\n" +
					"    DURATION = 1;\n" +
					"    REPEATING = FALSE;\n" +
					"    AUTOSTART = TRUE {\n" +
					"      TYPE = ABSOLUTE;\n" +
					"      START_VALUE = 0;\n" +
					"    };\n" +
					"    EXPIRE_POINT = ACTION {\n" +
					"      EXPIRE_VALUE = 1;\n" +
					"      ACTION = ACTIVATETASK { TASK = TaskPrio2; };\n" +
					"      SYNC_ADJUSTMENT = FALSE;\n" +
					"    };\n" +
					"    EXPIRE_POINT = ACTION {\n" +
					"      EXPIRE_VALUE = 3;\n" +
					"      ACTION = SETEVENT { TASK = TaskPrio1; EVENT = EventTaskPrio1; };\n" +
					"      SYNC_ADJUSTMENT = FALSE;\n" +
					"    };\n" +
					"    LOCAL_TO_GLOBAL_TIME_SYNCHRONIZATION = FALSE;\n" +
					"  };\n" +
					"};\n";
			commonWriterTest(text, 1);
			}
		
	@Test public void testSchedTab() {
		String text = "CPU test_application {\n" +
			"\n" +
			"  OS EE {\n" +
			"    EE_OPT = \"EE_DEBUG\";\n" +
			"    EE_OPT = \"__ASSERT__\";\n" +
			"    EE_OPT = \"EE_EXECUTE_FROM_RAM\";\n" +
			"    EE_OPT = \"EE_SAVE_TEMP_FILES\";\n" +
			"\n" +
			"    MEMORY_PROTECTION   = TRUE;\n" +
			"    STACKMONITORING     = TRUE;\n" +
			"    SERVICE_PROTECTION  = TRUE;\n" +
			"    PROTECTIONHOOK      = TRUE;\n" +
			"\n" +
			"    /* I need to do checks in Idle Loop */\n" +
			"    EE_OPT = \"__OO_STARTOS_OLD__\";\n" +
			"\n" +
			"    CPU_DATA = TRICORE {\n" +
			"      CPU_CLOCK = 200.0;\n" +
			"      APP_SRC = \"code.c\";\n" +
			"      MULTI_STACK = TRUE;\n" +
			"      //SYS_STACK_SIZE = 4096;\n" +
			"      COMPILER_TYPE = GNU;\n" +
			"      //COMPILER_TYPE = TASKING;\n" +
			"    };\n" +
			"\n" +
			"    MCU_DATA = TRICORE {\n" +
			"      MODEL = TC27x;\n" +
			"    };\n" +
			"\n" +
			"    BOARD_DATA = TRIBOARD_TC2X5;\n" +
			"\n" +
			"    STATUS        = EXTENDED;\n" +
			"    SHUTDOWNHOOK  = TRUE;\n" +
			"    //ORTI_SECTIONS = ALL;\n" +
			"    KERNEL_TYPE = ECC1;\n" +
			"  };\n" +
			"\n" +
			"  TASK TaskPrio1 {\n" +
			"    PRIORITY = 1;\n" +
			"    AUTOSTART = TRUE;\n" +
			"    STACK = PRIVATE {\n" +
			"      SYS_SIZE = 128;\n" +
			"    };\n" +
			"    ACTIVATION = 1;\n" +
			"    SCHEDULE = FULL;\n" +
			"    EVENT = EventTaskPrio1;\n" +
			"    TIMING_PROTECTION = TRUE {\n" +
			"      TIMEFRAME               = 3;\n" +
			"      EXECUTIONBUDGET         = 0.0025;\n" +
			"      MAXALLINTERRUPTLOCKTIME = 0.0001;\n" +
			"    };\n" +
			"  };\n" +
			"\n" +
			"  TASK TaskPrio2 {\n" +
			"    PRIORITY = 2;\n" +
			"    AUTOSTART = FALSE;\n" +
			"    STACK = SHARED;\n" +
			"    ACTIVATION = 1;\n" +
			"    SCHEDULE = FULL;\n" +
			"    TIMING_PROTECTION = TRUE {\n" +
			"      TIMEFRAME               = 2;\n" +
			"      EXECUTIONBUDGET         = 0.0005;\n" +
			"      MAXALLINTERRUPTLOCKTIME = 0.0001;\n" +
			"    };\n" +
			"  };\n" +
			"\n" +
			"  ISR Button_ISR2 {\n" +
			"    CATEGORY = 2;\n" +
			"    PRIORITY = 2;\n" +
			"    HANDLER = \"button_handler\"; // IRQ handler\n" +
			"    TIMING_PROTECTION = TRUE {\n" +
			"      TIMEFRAME               = 1;\n" +
			"      EXECUTIONTIME           = 0.0055;\n" +
			"      MAXALLINTERRUPTLOCKTIME = 0.0001;\n" +
			"    };\n" +
			"  };\n" +
			"\n" +
			"  EVENT EventTaskPrio1 { MASK = AUTO; };\n" +
			"\n" +
			"  COUNTER system_timer {\n" +
			"    MINCYCLE = 1;\n" +
			"    MAXALLOWEDVALUE = 2147483647;\n" +
			"    TICKSPERBASE = 1;\n" +
			"    TYPE = HARDWARE {\n" +
			"      DEVICE = \"STM_SR0\";\n" +
			"      SYSTEM_TIMER = TRUE;\n" +
			"      PRIORITY = 1;\n" +
			"    };\n" +
			"    SECONDSPERTICK = 0.001;\n" +
			"  };\n" +
			"\n" +
			"  SCHEDULETABLE ScheduleTable1 {\n" +
			"    COUNTER = system_timer;\n" +
			"    DURATION = 5;\n" +
			"    REPEATING = FALSE;\n" +
			"    AUTOSTART = TRUE {\n" +
			"      TYPE = ABSOLUTE;\n" +
			"      START_VALUE = 0;\n" +
			"    };\n" +
			"    EXPIRE_POINT = ACTION {\n" +
			"      EXPIRE_VALUE = 1;\n" +
			"      ACTION = ACTIVATETASK { TASK = TaskPrio2; };\n" +
			"      SYNC_ADJUSTMENT = FALSE;\n" +
			"    };\n" +
			"    EXPIRE_POINT = ACTION {\n" +
			"      EXPIRE_VALUE = 3;\n" +
			"      ACTION = SETEVENT { TASK = TaskPrio1; EVENT=EventTaskPrio1; };\n" +
			"      SYNC_ADJUSTMENT = FALSE;\n" +
			"    };\n" +
			"    EXPIRE_POINT = ACTION {\n" +
			"      EXPIRE_VALUE = 4;\n" +
			"      ACTION = SETEVENT { TASK = TaskPrio1; EVENT=EventTaskPrio1; };\n" +
			"      SYNC_ADJUSTMENT = FALSE;\n" +
			"    };\n" +
			"    LOCAL_TO_GLOBAL_TIME_SYNCHRONIZATION = FALSE;\n" +
			"  };\n" +
			"\n" +
			"  APPLICATION App1 {\n" +
			"    TRUSTED           = FALSE;\n" +
			"    TASK              = TaskPrio1;\n" +
			"    TASK              = TaskPrio2;\n" +
			"    ISR               = Button_ISR2;\n" +
			"    SCHEDULETABLE     = ScheduleTable1;\n" +
			"    SHARED_STACK_SIZE = 128;\n" +
			"    IRQ_STACK_SIZE    = 128;\n" +
			"  };\n" +
			"};\n";
		commonWriterTest(text, 1);
		}
	
	@Test public void testTimeFrame() {
		String text = "CPU test_application {\n" +
				"\n" +
				"  OS EE {\n" +
				"    EE_OPT = \"EE_DEBUG\";\n" +
				"    EE_OPT = \"__ASSERT__\";\n" +
				"    EE_OPT = \"EE_EXECUTE_FROM_RAM\";\n" +
				"    EE_OPT = \"EE_SAVE_TEMP_FILES\";\n" +

				"    MEMORY_PROTECTION   = TRUE;\n" +
				"    STACKMONITORING     = TRUE;\n" +
				"    SERVICE_PROTECTION  = TRUE;\n" +
				"    PROTECTIONHOOK      = TRUE;\n" +

				"    /* I need to do checks in Idle Loop */\n" +
				"    EE_OPT = \"__OO_STARTOS_OLD__\";\n" +
				"\n" +
				"    CPU_DATA = TRICORE {\n" +
				"      CPU_CLOCK = 200.0;\n" +
				"      APP_SRC = \"code.c\";\n" +
				"      MULTI_STACK = TRUE;\n" +
				"      COMPILER_TYPE = GNU;\n" +
				"    };\n" +
				"\n" +
				"    MCU_DATA = TRICORE {\n" +
				"      MODEL = TC27x;\n" +
				"    };\n" +
				"\n" +
				"    BOARD_DATA = TRIBOARD_TC2X5;\n" +
				"\n" +
				"    STATUS        = EXTENDED;\n" +
				"    SHUTDOWNHOOK  = TRUE;\n" +
				"    //ORTI_SECTIONS = ALL;\n" +
				"    KERNEL_TYPE = ECC1;\n" +
				"  };\n" +
				"\n" +
				"  TASK TaskPrio1 {\n" +
				"    PRIORITY = 1;\n" +
				"    AUTOSTART = TRUE;\n" +
				"    STACK = PRIVATE {\n" +
				"      SYS_SIZE = 128;\n" +
				"    };\n" +
				"    ACTIVATION = 1;\n" +
				"    SCHEDULE = FULL;\n" +
				"    EVENT = EventTaskPrio1;\n" +
				"    TIMING_PROTECTION = TRUE {\n" +
				"      TIMEFRAME               = 0.0020;\n" +
				"      EXECUTIONBUDGET         = 0.0025;\n" +
				"      MAXALLINTERRUPTLOCKTIME = 0.0001;\n" +
				"    };\n" +
				"  };\n" +
				"\n" +
				"  TASK TaskPrio2 {\n" +
				"    PRIORITY = 2;\n" +
				"    AUTOSTART = FALSE;\n" +
				"    STACK = SHARED;\n" +
				"    ACTIVATION = 1;\n" +
				"    SCHEDULE = FULL;\n" +
				"    TIMING_PROTECTION = TRUE {\n" +
				"      TIMEFRAME               = 0.0025;\n" +
				"      EXECUTIONBUDGET         = 0.0005;\n" +
				"      MAXALLINTERRUPTLOCKTIME = 0.0001;\n" +
				"    };\n" +
				"  };\n" +
				"\n" +
				"  ISR Button_ISR2 {\n" +
				"    CATEGORY = 2;\n" +
				"    PRIORITY = 2;\n" +
				"    HANDLER = \"button_handler\"; // IRQ handler\n" +
				"    TIMING_PROTECTION = TRUE {\n" +
				"      TIMEFRAME               = 1;\n" +
				"      EXECUTIONTIME           = 0.0055;\n" +
				"      MAXALLINTERRUPTLOCKTIME = 0.0001;\n" +
				"    };\n" +
				"  };\n" +
				"\n" +
				"  EVENT EventTaskPrio1 { MASK = AUTO; };\n" +
				"\n" +
				"  COUNTER system_timer {\n" +
				"    MINCYCLE = 1;\n" +
				"    MAXALLOWEDVALUE = 2147483647;\n" +
				"    TICKSPERBASE = 1;\n" +
				"    TYPE = HARDWARE {\n" +
				"      DEVICE = \"STM_SR0\";\n" +
				"      SYSTEM_TIMER = TRUE;\n" +
				"      PRIORITY = 1;\n" +
				"    };\n" +
				"    SECONDSPERTICK = 0.001;\n" +
				"  };\n" +
				"\n" +
				"  SCHEDULETABLE ScheduleTable1 {\n" +
				"    COUNTER = system_timer;\n" +
				"    DURATION = 5;\n" +
				"    REPEATING = FALSE;\n" +
				"    AUTOSTART = TRUE {\n" +
				"      TYPE = ABSOLUTE;\n" +
				"      START_VALUE = 0;\n" +
				"    };\n" +
				"    EXPIRE_POINT = ACTION {\n" +
				"      EXPIRE_VALUE = 1;\n" +
				"      ACTION = ACTIVATETASK { TASK = TaskPrio2; };\n" +
				"      SYNC_ADJUSTMENT = FALSE;\n" +
				"    };\n" +
				"    EXPIRE_POINT = ACTION {\n" +
				"      EXPIRE_VALUE = 3;\n" +
				"      ACTION = ACTIVATETASK { TASK = TaskPrio2; };\n" +
				"      SYNC_ADJUSTMENT = FALSE;\n" +
				"    };\n" +
				"    EXPIRE_POINT = ACTION {\n" +
				"      EXPIRE_VALUE = 4;\n" +
				"      ACTION = ACTIVATETASK { TASK = TaskPrio2; };\n" +
				"      SYNC_ADJUSTMENT = FALSE;\n" +
				"    };\n" +
				"    LOCAL_TO_GLOBAL_TIME_SYNCHRONIZATION = FALSE;\n" +
				"  };\n" +
				"\n" +
				"  APPLICATION App1 {\n" +
				"    TRUSTED           = FALSE;\n" +
				"    TASK              = TaskPrio1;\n" +
				"    TASK              = TaskPrio2;\n" +
				"    ISR               = Button_ISR2;\n" +
				"    SCHEDULETABLE     = ScheduleTable1;\n" +
				"    SHARED_STACK_SIZE = 128;\n" +
				"    IRQ_STACK_SIZE    = 128;\n" +
				"  };\n" +
				"};\n";
		commonWriterTest(text, 1);
		}


	@Test public void testSATURATED() {
	    final String text =
			"CPU test_application {\n" +
			"\n" +
			"  OS EE {\n" +
			"    EE_OPT = \"EE_DEBUG\";\n" +
			"    EE_OPT = \"__ASSERT__\";\n" +
			"    EE_OPT = \"EE_EXECUTE_FROM_RAM\";\n" +
			"    EE_OPT = \"EE_SAVE_TEMP_FILES\";\n" +
			"    SERVICE_PROTECTION  = TRUE;\n" +
			"    PROTECTIONHOOK      = TRUE;\n" +
			"    EE_OPT = \"EE_AS_HAS_PROTECTIONHOOK__\";\n" +
			"    EE_OPT = \"__OO_STARTOS_OLD__\";\n" +
			"\n" +
			"    CPU_DATA = TRICORE {\n" +
			"      CPU_CLOCK = 200.0;\n" +
			"      APP_SRC = \"code.c\";\n" +
			"      MULTI_STACK = TRUE;\n" +
			"      COMPILER_TYPE = GNU;\n" +
			"    };\n" +
			"\n" +
			"    MCU_DATA = TRICORE {\n" +
			"      MODEL = TC27x;\n" +
			"    };\n" +
			"\n" +
			"    BOARD_DATA = TRIBOARD_TC2X5;\n" +
			"\n" +
			"    STATUS        = EXTENDED;\n" +
			"    SHUTDOWNHOOK  = TRUE;\n" +
			"    KERNEL_TYPE = ECC1;\n" +
			"  };\n" +
			"\n" +
			"  TASK TaskPrio1 {\n" +
			"    PRIORITY = 1;\n" +
			"    AUTOSTART = TRUE;\n" +
			"    STACK = PRIVATE {\n" +
			"      SYS_SIZE = 128;\n" +
			"    };\n" +
			"    ACTIVATION = 1;\n" +
			"    SCHEDULE = FULL;\n" +
			"    EVENT = EventTaskPrio1;\n" +
			"    TIMING_PROTECTION = TRUE {\n" +
			"      TIMEFRAME               = 0.0020;\n" +
			"      EXECUTIONBUDGET         = 0.0025;\n" +
			"      MAXALLINTERRUPTLOCKTIME = 0.0001;\n" +
			"    };\n" +
			"  };\n" +
			"\n" +
			"  TASK TaskPrio2 {\n" +
			"    PRIORITY = 2;\n" +
			"    AUTOSTART = FALSE;\n" +
			"    STACK = SHARED;\n" +
			"    ACTIVATION = 1;\n" +
			"    SCHEDULE = FULL;\n" +
			"    TIMING_PROTECTION = TRUE {\n" +
			"      TIMEFRAME               = 0.0025;\n" +
			"      EXECUTIONBUDGET         = 0.0005;\n" +
			"      MAXALLINTERRUPTLOCKTIME = 0.0001;\n" +
			"    };\n" +
			"  };\n" +
			"\n" +
			"  ISR Button_ISR2 {\n" +
			"    CATEGORY = 2;\n" +
			"    PRIORITY = 2;\n" +
			"    HANDLER = \"button_handler\";\n" +
			"    TIMING_PROTECTION = TRUE {\n" +
			"      TIMEFRAME               = 1;\n" +
			"      EXECUTIONTIME           = 0.0055;\n" +
			"      MAXALLINTERRUPTLOCKTIME = 0.0001;\n" +
			"    };\n" +
			"  };\n" +
			"\n" +
			"  EVENT EventTaskPrio1 { MASK = AUTO; };\n" +
			"\n" +
			"  COUNTER system_timer {\n" +
			"    MINCYCLE = 1;\n" +
			"    MAXALLOWEDVALUE = 2147483647;\n" +
			"    TICKSPERBASE = 1;\n" +
			"    TYPE = HARDWARE {\n" +
			"      DEVICE = \"STM_SR0\";\n" +
			"      SYSTEM_TIMER = TRUE;\n" +
			"      PRIORITY = 1;\n" +
			"    };\n" +
			"    SECONDSPERTICK = 0.001;\n" +
			"  };\n" +
			"\n" +
			"  SCHEDULETABLE ScheduleTable1 {\n" +
			"    COUNTER = system_timer;\n" +
			"    DURATION = 5;\n" +
			"    REPEATING = FALSE;\n" +
			"    AUTOSTART = TRUE {\n" +
			"      TYPE = ABSOLUTE;\n" +
			"      START_VALUE = 0;\n" +
			"    };\n" +
			"    EXPIRE_POINT = ACTION {\n" +
			"      EXPIRE_VALUE = 1;\n" +
			"      ACTION = ACTIVATETASK { TASK = TaskPrio2; };\n" +
			"      SYNC_ADJUSTMENT = FALSE;\n" +
			"    };\n" +
			"    EXPIRE_POINT = ACTION {\n" +
			"      EXPIRE_VALUE = 3;\n" +
			"      ACTION = ACTIVATETASK { TASK = TaskPrio2; };\n" +
			"      SYNC_ADJUSTMENT = FALSE;\n" +
			"    };\n" +
			"    EXPIRE_POINT = ACTION {\n" +
			"      EXPIRE_VALUE = 4;\n" +
			"      ACTION = ACTIVATETASK { TASK = TaskPrio2; };\n" +
			"      SYNC_ADJUSTMENT = FALSE;\n" +
			"    };\n" +
			"    LOCAL_TO_GLOBAL_TIME_SYNCHRONIZATION = FALSE;\n" +
			"  };\n" +
			"};\n";
		commonWriterTest(text, 1);
		}
	
	
	

	@Test public void test32Priorities_BCC1() {
	    final String text = "CPU test_application {\n"+
			"\n"+
			"	OS EE {\n"+
			"		EE_OPT = \"__ASSERT__\";\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\";\n"+
			"\n"+
			"\n"+
			"    CPU_DATA = TRICORE {\n" +
			"      CPU_CLOCK = 200.0;\n" +
			"      APP_SRC = \"code.c\";\n" +
			"      MULTI_STACK = TRUE;\n" +
			"      COMPILER_TYPE = GNU;\n" +
			"    };\n" +
			"\n" +
			"    MCU_DATA = TRICORE {\n" +
			"      MODEL = TC27x;\n" +
			"    };\n" +
			"\n" +
			"    BOARD_DATA = TRIBOARD_TC2X5;\n" +
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
	
	@Test public void test32Priorities_BCC2() {
	    final String text = "CPU test_application {\n"+
			"\n"+
			"	OS EE {\n"+
			"		EE_OPT = \"__ASSERT__\";\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\";\n"+
			"\n"+
			"\n"+
			"    CPU_DATA = TRICORE {\n" +
			"      CPU_CLOCK = 200.0;\n" +
			"      APP_SRC = \"code.c\";\n" +
			"      MULTI_STACK = TRUE;\n" +
			"      COMPILER_TYPE = GNU;\n" +
			"    };\n" +
			"\n" +
			"    MCU_DATA = TRICORE {\n" +
			"      MODEL = TC27x;\n" +
			"    };\n" +
			"\n" +
			"    BOARD_DATA = TRIBOARD_TC2X5;\n" +
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

	@Test public void test9Priorities_BCC2() {
	    final String text = "CPU test_application {\n"+
			"\n"+
			"	OS EE {\n"+
			"		EE_OPT = \"__ASSERT__\";\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\";\n"+
			"\n"+
			"\n"+
			"    CPU_DATA = TRICORE {\n" +
			"      CPU_CLOCK = 200.0;\n" +
			"      APP_SRC = \"code.c\";\n" +
			"      MULTI_STACK = TRUE;\n" +
			"      COMPILER_TYPE = GNU;\n" +
			"    };\n" +
			"\n" +
			"    MCU_DATA = TRICORE {\n" +
			"      MODEL = TC27x;\n" +
			"    };\n" +
			"\n" +
			"    BOARD_DATA = TRIBOARD_TC2X5;\n" +
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
	
	@Test public void test32PrioritiesECC1() {
	    final String text = "CPU test_application {\n"+
			"\n"+
			"	OS EE {\n"+
			"		EE_OPT = \"__ASSERT__\";\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\";\n"+
			"\n"+
			"\n"+
			"    CPU_DATA = TRICORE {\n" +
			"      CPU_CLOCK = 200.0;\n" +
			"      APP_SRC = \"code.c\";\n" +
			"      MULTI_STACK = TRUE;\n" +
			"      COMPILER_TYPE = GNU;\n" +
			"    };\n" +
			"\n" +
			"    MCU_DATA = TRICORE {\n" +
			"      MODEL = TC27x;\n" +
			"    };\n" +
			"\n" +
			"    BOARD_DATA = TRIBOARD_TC2X5;\n" +
			
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
	
	@Test public void test16PrioritiesECC2() {
	    final String text = "CPU test_application {\n"+
			"\n"+
			"	OS EE {\n"+
			"		EE_OPT = \"__ASSERT__\";\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\";\n"+
			"\n"+
			"\n"+
			"    CPU_DATA = TRICORE {\n" +
			"      CPU_CLOCK = 200.0;\n" +
			"      APP_SRC = \"code.c\";\n" +
			"      MULTI_STACK = TRUE;\n" +
			"      COMPILER_TYPE = GNU;\n" +
			"    };\n" +
			"\n" +
			"    MCU_DATA = TRICORE {\n" +
			"      MODEL = TC27x;\n" +
			"    };\n" +
			"\n" +
			"    BOARD_DATA = TRIBOARD_TC2X5;\n" +
			
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
	@Test public void test17PrioritiesECC2() {
	    final String text = "CPU test_application {\n"+
			"\n"+
			"	OS EE {\n"+
			"		EE_OPT = \"__ASSERT__\";\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\";\n"+
			"\n"+
			"\n"+
			"    CPU_DATA = TRICORE {\n" +
			"      CPU_CLOCK = 200.0;\n" +
			"      APP_SRC = \"code.c\";\n" +
			"      MULTI_STACK = TRUE;\n" +
			"      COMPILER_TYPE = GNU;\n" +
			"    };\n" +
			"\n" +
			"    MCU_DATA = TRICORE {\n" +
			"      MODEL = TC27x;\n" +
			"    };\n" +
			"\n" +
			"    BOARD_DATA = TRIBOARD_TC2X5;\n" +
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

	@Test public void test32PrioritiesFP() {
	    final String text = "CPU test_application {\n"+
			"\n"+
			"	OS EE {\n"+
			"		EE_OPT = \"__ASSERT__\";\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\";\n"+
			"\n"+
			"\n"+
			"    CPU_DATA = TRICORE {\n" +
			"      CPU_CLOCK = 200.0;\n" +
			"      APP_SRC = \"code.c\";\n" +
			"      MULTI_STACK = TRUE;\n" +
			"      COMPILER_TYPE = GNU;\n" +
			"    };\n" +
			"\n" +
			"    MCU_DATA = TRICORE {\n" +
			"      MODEL = TC27x;\n" +
			"    };\n" +
			"\n" +
			"    BOARD_DATA = TRIBOARD_TC2X5;\n" +
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
