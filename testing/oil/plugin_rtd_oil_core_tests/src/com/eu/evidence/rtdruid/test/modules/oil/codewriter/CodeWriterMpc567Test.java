package com.eu.evidence.rtdruid.test.modules.oil.codewriter;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.eu.evidence.rtdruid.vartree.Vt2StringUtilities;




public class CodeWriterMpc567Test extends AbstractCodeWriterTest {
	
	
	@Test public void testDoublez4() {
	    final String text = "CPU test_application {\n"+
			"\n"+
			"	OS EE {\n"+
			"		EE_OPT = \"__ASSERT__\";\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\";\n"+
			"\n"+
			"		EE_OPT = \"__E200ZX_EXECUTE_FROM_RAM__\";\n"+
			"\n"+
			"		MASTER_CPU = \"master\";\n"+
			"\n"+
			"		CPU_DATA = PPCE200ZX {\n"+
			"			ID = \"master\";\n"+
			"			MODEL = E200Z4;\n"+
			"			APP_SRC = \"master.c\";\n"+
			"			MULTI_STACK = FALSE;\n"+
			"			VLE = TRUE;\n"+
			"			SYS_STACK_SIZE = 4096;\n"+
			"		};\n"+
			"\n"+
			"		CPU_DATA = PPCE200ZX {\n"+
			"			MODEL = E200Z4;\n"+
			"			ID = \"slave\";\n"+
			"			APP_SRC = \"slave.c\";\n"+
			"			MULTI_STACK = FALSE;\n"+
			"			VLE = TRUE;\n"+
			"			SYS_STACK_SIZE = 4096;\n"+
			"		};\n"+
			"\n"+
			"		MCU_DATA = PPCE200ZX {\n"+
			"			MODEL = MPC5643L;\n"+
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
			"		KERNEL_TYPE = BCC1;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ6 {\n"+
			"		CPU_ID = \"master\";\n"+
			"		PRIORITY = 1;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ6b {\n"+
			"		CPU_ID = \"master\";\n"+
			"		PRIORITY = 3;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ6c {\n"+
			"		CPU_ID = \"master\";\n"+
			"		PRIORITY = 2;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ0 {\n"+
			"		CPU_ID = \"slave\";\n"+
			"		PRIORITY = 1;\n"+
			"		AUTOSTART = TRUE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ0b {\n"+
			"		CPU_ID = \"slave\";\n"+
			"		PRIORITY = 2;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ0c {\n"+
			"		CPU_ID = \"slave\";\n"+
			"		PRIORITY = 3;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"};\n";
		commonWriterTest(text, 2);
	}

	@Test public void testDoublez4Linkerscript() {
	    final String text = "CPU test_application {\n"+
			"\n"+
			"	OS EE {\n"+
			"		EE_OPT = \"__ASSERT__\";\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\";\n"+
			"\n"+
			"		EE_OPT = \"__E200ZX_EXECUTE_FROM_RAM__\";\n"+
			"\n"+
			"		MASTER_CPU = \"master\";\n"+
			"\n"+
			"		CPU_DATA = PPCE200ZX {\n"+
			"			ID = \"master\";\n"+
			"			MODEL = E200Z4;\n"+
			"			APP_SRC = \"master.c\";\n"+
			"			MULTI_STACK = FALSE;\n"+
			"			VLE = TRUE;\n"+
			"			SYS_STACK_SIZE = 4096;\n"+
			"			LINKERSCRIPT = \"linker_script_cpu.ld\";\n"+
			"		};\n"+
			"\n"+
			"		CPU_DATA = PPCE200ZX {\n"+
			"			MODEL = E200Z4;\n"+
			"			ID = \"slave\";\n"+
			"			APP_SRC = \"slave.c\";\n"+
			"			MULTI_STACK = FALSE;\n"+
			"			VLE = TRUE;\n"+
			"			SYS_STACK_SIZE = 4096;\n"+
			"		};\n"+
			"\n"+
			"		MCU_DATA = PPCE200ZX {\n"+
			"			MODEL = MPC5643L;\n"+
			"			LINKERSCRIPT = \"linker_script_mcu.ld\";\n"+
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
			"		KERNEL_TYPE = BCC1;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ6 {\n"+
			"		CPU_ID = \"master\";\n"+
			"		PRIORITY = 1;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ6b {\n"+
			"		CPU_ID = \"master\";\n"+
			"		PRIORITY = 3;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ6c {\n"+
			"		CPU_ID = \"master\";\n"+
			"		PRIORITY = 2;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ0 {\n"+
			"		CPU_ID = \"slave\";\n"+
			"		PRIORITY = 1;\n"+
			"		AUTOSTART = TRUE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ0b {\n"+
			"		CPU_ID = \"slave\";\n"+
			"		PRIORITY = 2;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ0c {\n"+
			"		CPU_ID = \"slave\";\n"+
			"		PRIORITY = 3;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"};\n";
		commonWriterTest(text, 2);
	}

	@Test public void testMpc567_bug88() {
	    final String text = "CPU test_application {\n"+
			"\n"+
			"	OS EE {\n"+
			"		EE_OPT = \"__ASSERT__\";\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\";\n"+
			"\n"+
			"		EE_OPT = \"__E200ZX_EXECUTE_FROM_RAM__\";\n"+
			"\n"+
			"		MASTER_CPU = \"master\";\n"+
			"\n"+
			"		CPU_DATA = PPCE200ZX {\n"+
			"			ID = \"master\";\n"+
			"			MODEL = E200Z6;\n"+
			"			APP_SRC = \"master.c\";\n"+
			"			MULTI_STACK = FALSE;\n"+
			"			VLE = TRUE;\n"+
			"			SYS_STACK_SIZE = 4096;\n"+
			"		};\n"+
			"\n"+
			"		CPU_DATA = PPCE200ZX {\n"+
			"			MODEL = E200Z0;\n"+
			"			ID = \"slave\";\n"+
			"			APP_SRC = \"slave.c\";\n"+
			"			MULTI_STACK = FALSE;\n"+
			"			VLE = TRUE;\n"+
			"			SYS_STACK_SIZE = 4096;\n"+
			"		};\n"+
			"\n"+
			"		MCU_DATA = PPCE200ZX {\n"+
			"			MODEL = MPC5668G;\n"+
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
			"		KERNEL_TYPE = BCC1;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ6 {\n"+
			"		CPU_ID = \"master\";\n"+
			"		PRIORITY = 1;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ6b {\n"+
			"		CPU_ID = \"master\";\n"+
			"		PRIORITY = 3;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ6c {\n"+
			"		CPU_ID = \"master\";\n"+
			"		PRIORITY = 2;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ0 {\n"+
			"		CPU_ID = \"slave\";\n"+
			"		PRIORITY = 1;\n"+
			"		AUTOSTART = TRUE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ0b {\n"+
			"		CPU_ID = \"slave\";\n"+
			"		PRIORITY = 2;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ0c {\n"+
			"		CPU_ID = \"slave\";\n"+
			"		PRIORITY = 3;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"};\n";
		commonWriterTest(text, 2);
	}


	@Test public void testMpc567_multi_stack() {
	    final String text = "CPU test_application {\n" +
			"\n" +
			"	OS EE {		\n" +
			"		EE_OPT = \"DEBUG_STACK\";\n" +
			"\n" +
			"		CFLAGS = \"-g2\";\n" +
			"		ASFLAGS = \"\";\n" +
			"		LDFLAGS = \"\"; \n" +
			"\n" +
			"		CPU_DATA = PPCE200ZX {\n" +
			"			APP_SRC = \"main.c\";\n" +
			"			MULTI_STACK = TRUE;\n" +
			"			MODEL = E200Z7;\n" +
			"			SYS_STACK_SIZE = 128;\n" +
			"			VLE = TRUE;\n" +
			"		};\n" +
			"		\n" +
			"		MCU_DATA = PPCE200ZX {\n" +
			"			MODEL = MPC5674F;\n" + 
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

	@Test public void testMpc567_linkerscriptcpu() {
	    final String text = "CPU test_application {\n" +
			"\n" +
			"	OS EE {		\n" +
			"		EE_OPT = \"DEBUG_STACK\";\n" +
			"\n" +
			"		CFLAGS = \"-g2\";\n" +
			"		ASFLAGS = \"\";\n" +
			"		LDFLAGS = \"\"; \n" +
			"\n" +
			"		CPU_DATA = PPCE200ZX {\n" +
			"			APP_SRC = \"main.c\";\n" +
			"			MULTI_STACK = TRUE;\n" +
			"			MODEL = E200Z7;\n" +
			"			SYS_STACK_SIZE = 128;\n" +
			"			VLE = TRUE;\n" +
			"			LINKERSCRIPT = \"linker_script_cpu.ld\";\n"+
			"		};\n" +
			"		\n" +
			"		MCU_DATA = PPCE200ZX {\n" +
			"			MODEL = MPC5674F;\n" + 
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

	@Test public void testMpc567_linkerscriptmcu() {
	    final String text = "CPU test_application {\n" +
			"\n" +
			"	OS EE {		\n" +
			"		EE_OPT = \"DEBUG_STACK\";\n" +
			"\n" +
			"		CFLAGS = \"-g2\";\n" +
			"		ASFLAGS = \"\";\n" +
			"		LDFLAGS = \"\"; \n" +
			"\n" +
			"		CPU_DATA = PPCE200ZX {\n" +
			"			APP_SRC = \"main.c\";\n" +
			"			MULTI_STACK = TRUE;\n" +
			"			MODEL = E200Z7;\n" +
			"			SYS_STACK_SIZE = 128;\n" +
			"			VLE = TRUE;\n" +
			"		};\n" +
			"		\n" +
			"		MCU_DATA = PPCE200ZX {\n" +
			"			MODEL = MPC5674F;\n" + 
			"			LINKERSCRIPT = \"linker_script_mcu.ld\";\n"+
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


	@Test public void testMpc567_multi_stack_orit() {
	    final String text = "CPU test_application {\n" +
			"\n" +
			"	OS EE {		\n" +
			"		EE_OPT = \"DEBUG_STACK\";\n" +
			"\n" +
			"		CFLAGS = \"-g2\";\n" +
			"		ASFLAGS = \"\";\n" +
			"		LDFLAGS = \"\"; \n" +
			"\n" +
			"		CPU_DATA = PPCE200ZX {\n" +
			"			APP_SRC = \"main.c\";\n" +
			"			MULTI_STACK = TRUE {\n" + 
			"				IRQ_STACK = TRUE {\n" + 
			"					SYS_SIZE=64;\n" + 
			"				};\n" + 
			"			};\n" + 
			"			MODEL = E200Z7;\n" +
			"			VLE = FALSE;\n" +
			"		};\n" +
			"		\n" +
			"		MCU_DATA = PPCE200ZX {\n" +
			"			MODEL = MPC5674F;\n" + 
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
			"};";
		commonWriterTest(text, 1);
	}

	@Test public void testMpc567_os_application() {
	    final String text = "CPU test_application {\n" +
			"\n" +
			"	OS EE {		\n" +
			"		EE_OPT = \"DEBUG_STACK\";\n" +
			"\n" +
			"		CFLAGS = \"-g2\";\n" +
			"		ASFLAGS = \"\";\n" +
			"		LDFLAGS = \"\"; \n" +
			"\n" +
			"		CPU_DATA = PPCE200ZX {\n" +
			"			APP_SRC = \"main.c\";\n" +
			"			MULTI_STACK = TRUE {\n" + 
			"				IRQ_STACK = TRUE {\n" + 
			"					SYS_SIZE=64;\n" + 
			"				};\n" + 
			"			};\n" + 
			"			MODEL = E200Z6;\n" +
			"		};\n" +
			"		\n" +
			"		MCU_DATA = PPCE200ZX {\n" +
			"			MODEL = MPC5668G;\n" + 
			"		};\n" +
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
    		"		MEMORY_BASE = \"0xD0020000\";\n"+
    		"		MEMORY_SIZE = 0x10000;\n"+
			"    };\n" +
			"    APPLICATION appl2 {\n" +
			"		TRUSTED = FALSE;\n" +
			"		IRQ_STACK_SIZE = 512;\n" +
    		"		SHARED_STACK_SIZE = 512;\n"+
			"		TASK=Task2;\n" +
    		"		MEMORY_BASE = \"0x40020000\";\n"+
    		"		MEMORY_SIZE = 0x10000;\n"+
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

	@Test public void testMpc567_bug_86() {
	    final String text = "CPU PerfTestApp {\n"+
	    		"	OS EE {\n"+
	    		"		CFLAGS = \"-I../inc\";\n"+
	    		"		CFLAGS = \"-Xsmall-data=0\";\n"+
	    		"		MEMORY_PROTECTION = TRUE;\n"+
	    		"\n"+
	    		"		CPU_DATA = PPCE200ZX {\n"+
	    		"			MODEL = E200Z7;\n"+
	    		"			APP_SRC = \"code.c\";\n"+
	    		"			APP_SRC = \"app1.c\";\n"+
	    		"			APP_SRC = \"app2.c\";\n"+
	    		"			APP_SRC = \"trusted.c\";\n"+
	    		"			MULTI_STACK = TRUE;\n"+
	    		"		};\n"+
	    		"\n"+
	    		"		MCU_DATA = PPCE200ZX {\n"+
	    		"			MODEL = MPC5674F;\n"+
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
	    		"		KERNEL_TYPE = ECC2;\n"+
	    		"		SCALABILITYCLASS = SC4;\n"+
	    		"\n"+
	    		"//		ORTI_SECTIONS = ALL;\n"+
	    		"	};\n"+
	    		"\n"+
	    		"	TASK MainTask {\n"+
	    		"		PRIORITY = 10;\n"+
	    		"		ACTIVATION = 1;\n"+
	    		"		SCHEDULE = FULL;\n"+
	    		"		AUTOSTART = TRUE;\n"+
	    		"		STACK = SHARED;\n"+
	    		"	};\n"+
	    		"\n"+
	    		"	TASK TrustedTask1 {\n"+
	    		"		PRIORITY = 1;\n"+
	    		"		ACTIVATION = 1;\n"+
	    		"		SCHEDULE = FULL;\n"+
	    		"		AUTOSTART = FALSE;\n"+
	    		"		STACK = SHARED;\n"+
	    		"	};\n"+
	    		"\n"+
	    		"	TASK App1Task {\n"+
	    		"		PRIORITY = 4;\n"+
	    		"		ACTIVATION = 1;\n"+
	    		"		SCHEDULE = FULL;\n"+
	    		"		AUTOSTART = FALSE;\n"+
	    		"		STACK = SHARED;\n"+
	    		"	};\n"+
	    		"\n"+
	    		"	TASK App2Task {\n"+
	    		"		PRIORITY = 4;\n"+
	    		"		ACTIVATION = 1;\n"+
	    		"		SCHEDULE = FULL;\n"+
	    		"		AUTOSTART = FALSE;\n"+
	    		"		STACK = SHARED;\n"+
	    		"	};\n"+
	    		"\n"+
	    		"	ISR TrustedIsr {\n"+
	    		"		CATEGORY = 2;\n"+
	    		"	};\n"+
	    		"\n"+
	    		"	ISR App1Isr {\n"+
	    		"		CATEGORY = 2;\n"+
	    		"	};\n"+
	    		"\n"+
	    		"	ISR App2Isr {\n"+
	    		"		CATEGORY = 2;\n"+
	    		"	};\n"+
	    		"\n"+
	    		"	APPLICATION TrustedApp {\n"+
	    		"		TRUSTED = TRUE;\n"+
	    		"		ISR = TrustedIsr;\n"+
	    		"		TASK = MainTask;\n"+
	    		"		TASK = TrustedTask1;\n"+
	    		"		MEMORY_BASE = \"0x40010000\";\n"+
	    		"		MEMORY_SIZE = 0x10000;\n"+
	    		"		SHARED_STACK_SIZE = 512;\n"+
				"		IRQ_STACK_SIZE = 512;\n" +
	    		"	};\n"+
	    		"\n"+
	    		"	APPLICATION App1 {\n"+
	    		"		TRUSTED = FALSE;\n"+
	    		"		ISR = App1Isr;\n"+
	    		"		TASK = App1Task;\n"+
	    		"		MEMORY_BASE = \"0x40020000\";\n"+
	    		"		MEMORY_SIZE = 0x10000;\n"+
	    		"		SHARED_STACK_SIZE = 512;\n"+
				"		IRQ_STACK_SIZE = 512;\n" +
	    		"	};\n"+
	    		"\n"+
	    		"	APPLICATION App2 {\n"+
	    		"		TRUSTED = FALSE;\n"+
	    		"		ISR = App2Isr;\n"+
	    		"		TASK = App2Task;\n"+
	    		"		MEMORY_BASE = \"0x40030000\";\n"+
	    		"		MEMORY_SIZE = 0x4000;\n"+
	    		"		SHARED_STACK_SIZE = 512;\n"+
				"		IRQ_STACK_SIZE = 512;\n" +
	    		"	};\n"+
	    		"};";
		commonWriterTest(text, 1);
	}


	@Test public void testMpc567_full_os_application() {
	    final String text = "CPU test_application {\n" +
			"\n" +
			"	OS EE {		\n" +
			"		EE_OPT = \"DEBUG_STACK\";\n" +
			"\n" +
			"		CFLAGS = \"-g2\";\n" +
			"		ASFLAGS = \"\";\n" +
			"		LDFLAGS = \"\"; \n" +
			"\n" +
			"		CPU_DATA = PPCE200ZX {\n" +
			"			APP_SRC = \"main.c\";\n" +
			"			MULTI_STACK = TRUE {\n" + 
			"				IRQ_STACK = TRUE {\n" + 
			"					SYS_SIZE=512;\n" + 
			"				};\n" + 
			"			};\n" + 
			"			MODEL = E200Z6;\n" +
			"		};\n" +
			"		\n" +
//			"		MCU_DATA = PPCE200ZX {\n" +
//			"			MODEL = MPC5668G;\n" + 
//			"		};\n" +
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

			"    APPLICATION main_app {\n" +
			"		TRUSTED = TRUE;\n" +
			"		IRQ_STACK_SIZE = 512;\n" +
			"       TASK = MainTask;\n" +
			"       TASK = MyTask1;\n" +
			"       TASK = MyTask3;\n" +
			"       TASK = MyTask4;\n" +
			
			"       ISR = isr2entry_isr2;\n" +
			"       ISR = isrentry_isr1;\n" +
			"       ISR = isrexit_isr1;\n" +
			"       ISR = istentry_isr2;\n" +
			"       ISR = istexit_isr2;\n" +
			
    		"		SHARED_STACK_SIZE = 512;\n"+
    		"		MEMORY_BASE = \"0x40020000\";\n"+
    		"		MEMORY_SIZE = 0x10000;\n"+
			"    };\n" +

			"    APPLICATION app1 {\n" +
			"		TRUSTED = FALSE;\n" +
			"		IRQ_STACK_SIZE = 512;\n" +
			"       TASK = TaskApp1;\n" +
    		"		SHARED_STACK_SIZE = 512;\n"+
    		"		MEMORY_BASE = \"0x40020000\";\n"+
    		"		MEMORY_SIZE = 0x10000;\n"+
			"    };\n" +
			"    APPLICATION app2 {\n" +
			"		TRUSTED = FALSE;\n" +
			"		IRQ_STACK_SIZE = 512;\n" +
    		"		SHARED_STACK_SIZE = 512;\n"+
    		"		MEMORY_BASE = \"0x40020000\";\n"+
    		"		MEMORY_SIZE = 0x10000;\n"+
			"       TASK = TaskApp2;\n" +
			"    };\n" +
			
			"    /* this is the OIL part for the first task */\n" +
			"    TASK MainTask {\n" +
			"		PRIORITY = 0x02;\n" +
			"		AUTOSTART = TRUE;\n" +
			"		STACK = PRIVATE {\n" +
			"			SYS_SIZE = 128;\n" +
			"		};\n" +
			"		ACTIVATION = 1;    /* only one pending activation */\n" +
			"	};	\n" +
			"\n" +
			"    /* this is the OIL part for the second task */\n" +
			"    TASK MyTask1 {\n" +
			"		PRIORITY = 0x01;\n" +
			"		AUTOSTART = FALSE;\n" +
			"		STACK = PRIVATE {\n" +
			"			SYS_SIZE = 128;\n" +
			"		};\n" +
			"		ACTIVATION = 1;    /* only one pending activation */\n" +
			"	};	\n" +
			"    TASK MyTask3 {\n" +
			"		PRIORITY = 0x04;\n" +
			"		AUTOSTART = FALSE;\n" +
			"		STACK = PRIVATE {\n" +
			"			SYS_SIZE = 128;\n" +
			"		};\n" +
			"		ACTIVATION = 1;    /* only one pending activation */\n" +
			"	};	\n" +
			"    TASK MyTask4 {\n" +
			"		PRIORITY = 0x08;\n" +
			"		AUTOSTART = FALSE;\n" +
			"		STACK = PRIVATE {\n" +
			"			SYS_SIZE = 128;\n" +
			"		};\n" +
			"		ACTIVATION = 1;    /* only one pending activation */\n" +
			"	};	\n" +
			"    TASK TaskApp1 {\n" +
			"		PRIORITY = 0x08;\n" +
			"		APP_SRC = \"app1.c\";\n" +
			"		AUTOSTART = FALSE;\n" +
			"		STACK = PRIVATE {\n" +
			"			SYS_SIZE = 128;\n" +
			"		};\n" +
			"		ACTIVATION = 1;    /* only one pending activation */\n" +
			"	};	\n" +
			"    TASK TaskApp2 {\n" +
			"		PRIORITY = 0x08;\n" +
			"		APP_SRC = \"app2.c\";\n" +
			"		AUTOSTART = FALSE;\n" +
			"		STACK = PRIVATE {\n" +
			"			SYS_SIZE = 128;\n" +
			"		};\n" +
			"		ACTIVATION = 1;    /* only one pending activation */\n" +
			"	};	\n" +
			
			"    ISR isr2entry_isr2 {\n" +
			"		CATEGORY = 2;\n" +
			"	};	\n" +			
			"    ISR isrentry_isr1 {\n" +
			"		CATEGORY = 2;\n" +
			"	};	\n" +			
			"    ISR isrexit_isr1 {\n" +
			"		CATEGORY = 2;\n" +
			"	};	\n" +			
			"    ISR istentry_isr2 {\n" +
			"		CATEGORY = 2;\n" +
			"	};	\n" +			
			"    ISR istexit_isr2 {\n" +
			"		CATEGORY = 2;\n" +
			"	};	\n" +		
			
			"    OS EE { \n" +
			"		KERNEL_TYPE = ECC2;\n" +
			"		ORTI_SECTIONS = ALL;\n" +
			"		MAX_NESTING_LEVEL = 8;\n" +
			"		MEMORY_PROTECTION = TRUE;\n" +
			"  }; 	\n" +
			"};";
		DefaultTestResult result = commonWriterTest(text, 1);
		System.out.println(Vt2StringUtilities.explodeOilVar(Vt2StringUtilities.varTreeToStringErtd(result.vt)));
	}

	@Test public void testMpc567_full_os_application__pragma() {
	    final String text = "CPU test_application {\n" +
			"\n" +
			"	OS EE {\n" +
			"		EE_OPT = \"DEBUG_STACK\";\n" +
			"		EE_OPT = \"USE_PRAGMAS\";\n" +
			"\n" +
			"		CFLAGS = \"-g2\";\n" +
			"		ASFLAGS = \"\";\n" +
			"		LDFLAGS = \"\";\n" +
			"\n" +
			"		CPU_DATA = PPCE200ZX {\n" +
			"			APP_SRC = \"main.c\";\n" +
			"			MULTI_STACK = TRUE {\n" +
			"				IRQ_STACK = TRUE {\n" + 
			"					SYS_SIZE=512;\n" + 
			"				};\n" + 
			"			};\n" +
			"			MODEL = E200Z6;\n" +
			"		};\n" +
			"\n" +
//			"		MCU_DATA = PPCE200ZX {\n" +
//			"			MODEL = MPC5668G;\n" + 
//			"		};\n" +
			"\n" +
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
			"    };\n" +
			"\n" +

			"    APPLICATION main_app {\n" +
			"		TRUSTED = TRUE;\n" +
			"		IRQ_STACK_SIZE = 512;\n" +
			"       TASK = MainTask;\n" +
			"       TASK = MyTask1;\n" +
			"       TASK = MyTask3;\n" +
			"       TASK = MyTask4;\n" +
			
			"       ISR = isr2entry_isr2;\n" +
			"       ISR = isrentry_isr1;\n" +
			"       ISR = isrexit_isr1;\n" +
			"       ISR = istentry_isr2;\n" +
			"       ISR = istexit_isr2;\n" +
			
    		"		SHARED_STACK_SIZE = 512;\n"+
    		"		MEMORY_BASE = \"0x40020000\";\n"+
    		"		MEMORY_SIZE = 0x10000;\n"+
			"    };\n" +

			"    APPLICATION app1 {\n" +
			"		TRUSTED = FALSE;\n" +
			"		IRQ_STACK_SIZE = 512;\n" +
			"       TASK = TaskApp1;\n" +
    		"		SHARED_STACK_SIZE = 512;\n"+
    		"		MEMORY_BASE = \"0x40020000\";\n"+
    		"		MEMORY_SIZE = 0x10000;\n"+
			"	};\n" +
			"    APPLICATION app2 {\n" +
			"		TRUSTED = FALSE;\n" +
			"		IRQ_STACK_SIZE = 512;\n" +
    		"		SHARED_STACK_SIZE = 512;\n"+
    		"		MEMORY_BASE = \"0x40020000\";\n"+
    		"		MEMORY_SIZE = 0x10000;\n"+
			"       TASK = TaskApp2;\n" +
			"	};\n" +
			
			"    /* this is the OIL part for the first task */\n" +
			"    TASK MainTask {\n" +
			"		PRIORITY = 0x02;\n" +
			"		AUTOSTART = TRUE;\n" +
			"		STACK = PRIVATE {\n" +
			"			SYS_SIZE = 128;\n" +
			"		};\n" +
			"		ACTIVATION = 1;    /* only one pending activation */\n" +
			"	};\n" +
			"\n" +
			"    /* this is the OIL part for the second task */\n" +
			"    TASK MyTask1 {\n" +
			"		PRIORITY = 0x01;\n" +
			"		AUTOSTART = FALSE;\n" +
			"		STACK = PRIVATE {\n" +
			"			SYS_SIZE = 128;\n" +
			"		};\n" +
			"		ACTIVATION = 1;    /* only one pending activation */\n" +
			"	};\n" +
			"    TASK MyTask3 {\n" +
			"		PRIORITY = 0x04;\n" +
			"		AUTOSTART = FALSE;\n" +
			"		STACK = PRIVATE {\n" +
			"			SYS_SIZE = 128;\n" +
			"			};\n" +
			"		ACTIVATION = 1;    /* only one pending activation */\n" +
			"	};	\n" +
			"    TASK MyTask4 {\n" +
			"		PRIORITY = 0x08;\n" +
			"		AUTOSTART = FALSE;\n" +
			"		STACK = PRIVATE {\n" +
			"			SYS_SIZE = 128;\n" +
			"		};\n" +
			"		ACTIVATION = 1;    /* only one pending activation */\n" +
			"	};	\n" +
			"    TASK TaskApp1 {\n" +
			"		PRIORITY = 0x08;\n" +
			"		APP_SRC = \"app1.c\";\n" +
			"		AUTOSTART = FALSE;\n" +
			"		STACK = PRIVATE {\n" +
			"			SYS_SIZE = 128;\n" +
			"		};\n" +
			"		ACTIVATION = 1;    /* only one pending activation */\n" +
			"	};	\n" +
			"    TASK TaskApp2 {\n" +
			"		PRIORITY = 0x08;\n" +
			"		APP_SRC = \"app2.c\";\n" +
			"		AUTOSTART = FALSE;\n" +
			"		STACK = PRIVATE {\n" +
			"			SYS_SIZE = 128;\n" +
			"		};\n" +
			"		ACTIVATION = 1;    /* only one pending activation */\n" +
			"	};	\n" +
			
			"    ISR isr2entry_isr2 {\n" +
			"		CATEGORY = 2;\n" +
			"	};	\n" +			
			"    ISR isrentry_isr1 {\n" +
			"		CATEGORY = 2;\n" +
			"	};	\n" +			
			"    ISR isrexit_isr1 {\n" +
			"		CATEGORY = 2;\n" +
			"	};	\n" +			
			"    ISR istentry_isr2 {\n" +
			"		CATEGORY = 2;\n" +
			"	};	\n" +			
			"    ISR istexit_isr2 {\n" +
			"		CATEGORY = 2;\n" +
			"	};	\n" +		
			
			"    OS EE { \n" +
			"		KERNEL_TYPE = ECC2;\n" +
			"		ORTI_SECTIONS = ALL;\n" +
			"		MAX_NESTING_LEVEL = 8;\n" +
			"		MEMORY_PROTECTION = TRUE;\n" +
			"  }; 	\n" +
			"};";
		DefaultTestResult result = commonWriterTest(text, 1);
		System.out.println(Vt2StringUtilities.explodeOilVar(Vt2StringUtilities.varTreeToStringErtd(result.vt)));
	}
	
	@Test public void testMpc567_bug90_stack() {
	    final String text = "CPU test_application {\n" +
			"\n" +
			"	OS EE {\n" +
			"		EE_OPT = \"__ASSERT__\";\n" +
			"		CFLAGS = \"-g2\";\n" +
			"		ASFLAGS = \"\";\n" +
			"		LDFLAGS = \"\";\n" +
			"\n" +
			"		EE_OPT = \"__E200ZX_EXECUTE_FROM_RAM__\";\n" +
			"\n" +
			"		MASTER_CPU = \"master\";\n" +
			"\n" +
			"		CPU_DATA = PPCE200ZX {\n" +
			"			ID = \"master\";\n" +
			"			MODEL = E200Z6;\n" +
			"			APP_SRC = \"master.c\";\n" +
			"			APP_SRC = \"shared.c\";\n" +
			"			MULTI_STACK = TRUE {\n" +
			"				IRQ_STACK = FALSE;\n" +
			"			};\n" +
			"			VLE = TRUE;\n" +
			"			SYS_STACK_SIZE = 4096;\n" +
			"		};\n" +
			"\n" +
			"		CPU_DATA = PPCE200ZX {\n" +
			"			MODEL = E200Z0;\n" +
			"			ID = \"slave\";\n" +
			"			APP_SRC = \"slave.c\";\n" +
			"			MULTI_STACK = TRUE {\n" +
			"				IRQ_STACK = FALSE;\n" +
			"			};\n" +
			"			VLE = TRUE;\n" +
			"			SYS_STACK_SIZE = 2048;\n" +
			"		};\n" +
			"\n" +
			"		MCU_DATA = PPCE200ZX {\n" +
			"			MODEL = MPC5668G;\n" +
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
			"		USEREMOTEEVENT = ALWAYS;\n" +
			"		ORTI_SECTIONS = ALL;\n" +
			"\n" +
			"		KERNEL_TYPE = ECC1;\n" +
			"	};\n" +
			"\n" +
			"	TASK TaskZ6 {\n" +
			"		CPU_ID = \"master\";\n" +
			"		PRIORITY = 1;\n" +
			"		AUTOSTART = FALSE;\n" +
			"		STACK = SHARED;\n" +
			"		ACTIVATION = 1;\n" +
			"		SCHEDULE = FULL;\n" +
			"	};\n" +
			"\n" +
			"\n" +
			"	TASK TaskZ0Main {\n" +
			"		CPU_ID = \"slave\";\n" +
			"		PRIORITY = 5;\n" +
			"		AUTOSTART = TRUE;\n" +
			"		STACK = PRIVATE {\n" +
			"			SYS_SIZE = 512;\n" +
			"		};\n" +
			"		ACTIVATION = 1;\n" +
			"		SCHEDULE = FULL;\n" +
			"		EVENT = Event1;\n" +
			"		EVENT = Event2;\n" +
			"	};\n" +
			"\n" +
			"	TASK TaskZ0Bkg {\n" +
			"		CPU_ID = \"slave\";\n" +
			"		PRIORITY = 1;\n" +
			"		AUTOSTART = FALSE;\n" +
			"		STACK = SHARED;\n" +
			"		ACTIVATION = 1;\n" +
			"		SCHEDULE = FULL;\n" +
			"	};\n" +
			"\n" +
			"	EVENT Event1 { MASK = AUTO; };\n" +
			"	EVENT Event2 { MASK = AUTO; };\n" +
			"};";
		commonWriterTest(text, 2);
	}
	
	@Test public void testMpc567_bug90_events() {
	    final String text = "CPU test_application {\n" +
			"\n" +
			"	OS EE {\n" +
			"		EE_OPT = \"__ASSERT__\";\n" +
			"		CFLAGS = \"-g2\";\n" +
			"		ASFLAGS = \"\";\n" +
			"		LDFLAGS = \"\";\n" +
			"\n" +
			"		EE_OPT = \"__E200ZX_EXECUTE_FROM_RAM__\";\n" +
			"\n" +
			"		MASTER_CPU = \"master\";\n" +
			"\n" +
			"		CPU_DATA = PPCE200ZX {\n" +
			"			ID = \"master\";\n" +
			"			MODEL = E200Z6;\n" +
			"			APP_SRC = \"master.c\";\n" +
			"			APP_SRC = \"shared.c\";\n" +
			"			MULTI_STACK = TRUE {\n" +
			"				IRQ_STACK = FALSE;\n" +
			"			};\n" +
			"			VLE = TRUE;\n" +
			"			SYS_STACK_SIZE = 4096;\n" +
			"		};\n" +
			"\n" +
			"		CPU_DATA = PPCE200ZX {\n" +
			"			MODEL = E200Z0;\n" +
			"			ID = \"slave\";\n" +
			"			APP_SRC = \"slave.c\";\n" +
			"			MULTI_STACK = TRUE {\n" +
			"				IRQ_STACK = FALSE;\n" +
			"			};\n" +
			"			VLE = TRUE;\n" +
			"			SYS_STACK_SIZE = 2048;\n" +
			"		};\n" +
			"\n" +
			"		MCU_DATA = PPCE200ZX {\n" +
			"			MODEL = MPC5668G;\n" +
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
//			"		USEREMOTEEVENT = ALWAYS;\n" +
			"		ORTI_SECTIONS = ALL;\n" +
			"\n" +
			"		KERNEL_TYPE = ECC1;\n" +
			"	};\n" +
			"\n" +
			"	TASK TaskZ6 {\n" +
			"		CPU_ID = \"master\";\n" +
			"		PRIORITY = 1;\n" +
			"		AUTOSTART = FALSE;\n" +
			"		ACTIVATION = 1;\n" +
			"		SCHEDULE = FULL;\n" +

			"		STACK = PRIVATE {\n" +
			"			SYS_SIZE = 512;\n" +
			"		};\n" +
			"		EVENT = Event2;\n" +

			"	};\n" +
			"\n" +
			"\n" +
			"	TASK TaskZ0Main {\n" +
			"		CPU_ID = \"slave\";\n" +
			"		PRIORITY = 5;\n" +
			"		AUTOSTART = TRUE;\n" +
			"		STACK = PRIVATE {\n" +
			"			SYS_SIZE = 512;\n" +
			"		};\n" +
			"		ACTIVATION = 1;\n" +
			"		SCHEDULE = FULL;\n" +
			"		EVENT = Event1;\n" +
			"		EVENT = Event2;\n" +
			"	};\n" +
			"\n" +
			"	TASK TaskZ0Bkg {\n" +
			"		CPU_ID = \"slave\";\n" +
			"		PRIORITY = 1;\n" +
			"		AUTOSTART = FALSE;\n" +
			"		STACK = SHARED;\n" +
			"		ACTIVATION = 1;\n" +
			"		SCHEDULE = FULL;\n" +
			"	};\n" +
			"\n" +
			"	EVENT Event1 { MASK = AUTO; };\n" +
			"	EVENT Event2 { MASK = AUTO; };\n" +
			"};";
		commonWriterTest(text, 2);
	}

	
	@Test public void testMpc567_bug106() {
	    final String text = "CPU PerfTestApp {\n" +
				"	OS EE {\n" +
				"		CFLAGS = \"-Xsmall-data=0\";\n" +
				"		MEMORY_PROTECTION = TRUE;\n" +
				"\n" +
				"		CPU_DATA = PPCE200ZX {\n" +
				"			MODEL = E200Z7;\n" +
				"			APP_SRC = \"code.c\";\n" +
				"			APP_SRC = \"app1.c\";\n" +
				"			APP_SRC = \"app2.c\";\n" +
				"			APP_SRC = \"trusted.c\";\n" +
				"			MULTI_STACK = TRUE;\n" +
				"		};\n" +
				"\n" +
				"		MCU_DATA = PPCE200ZX {\n" +
				"			MODEL = MPC5674F;\n" +
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
				"		KERNEL_TYPE = ECC2;\n" +
				"		SCALABILITYCLASS = SC4;\n" +
				"\n" +
				"		EE_OPT = \"DEBUG\";\n" +
				"		ORTI_SECTIONS = ALL;\n" +
				"	};\n" +
				"\n" +
				"	TASK MainTask {\n" +
				"		PRIORITY = 10;\n" +
				"		ACTIVATION = 1;\n" +
				"		SCHEDULE = FULL;\n" +
				"		AUTOSTART = TRUE;\n" +
				"		STACK = SHARED;\n" +
				"	};\n" +
				"\n" +
				"	TASK TrustedTask1 {\n" +
				"		PRIORITY = 1;\n" +
				"		ACTIVATION = 1;\n" +
				"		SCHEDULE = FULL;\n" +
				"		AUTOSTART = FALSE;\n" +
				"		STACK = SHARED;\n" +
				"	};\n" +
				"\n" +
				"	TASK ErrorTask {\n" +
				"		PRIORITY = 100;\n" +
				"		ACTIVATION = 1;\n" +
				"		SCHEDULE = NON;\n" +
				"		AUTOSTART = FALSE;\n" +
				"		STACK = SHARED;\n" +
				"	};\n" +
				"\n" +
				"	TASK App1Init {\n" +
				"		PRIORITY = 2;\n" +
				"		ACTIVATION = 1;\n" +
				"		SCHEDULE = FULL;\n" +
				"		AUTOSTART = FALSE;\n" +
				"		STACK = SHARED;\n" +
				"	};\n" +
				"\n" +
				"	TASK App1Task {\n" +
				"		PRIORITY = 4;\n" +
				"		ACTIVATION = 1;\n" +
				"		SCHEDULE = FULL;\n" +
				"		AUTOSTART = FALSE;\n" +
				"		STACK = SHARED;\n" +
				"	};\n" +
				"\n" +
				"	TASK App1Ack {\n" +
				"		PRIORITY = 10;\n" +
				"		ACTIVATION = 1;\n" +
				"		SCHEDULE = FULL;\n" +
				"		AUTOSTART = FALSE;\n" +
				"		STACK = SHARED;\n" +
				"	};\n" +
				"\n" +
				"	TASK App1Bkg {\n" +
				"		PRIORITY = 1;\n" +
				"		ACTIVATION = 1;\n" +
				"		SCHEDULE = FULL;\n" +
				"		AUTOSTART = FALSE;\n" +
				"		STACK = PRIVATE {\n" +
				"			SYS_SIZE = 512;\n" +
				"		};\n" +
				"	};\n" +
				"\n" +
				"	TASK App2Init {\n" +
				"		PRIORITY = 2;\n" +
				"		ACTIVATION = 1;\n" +
				"		SCHEDULE = FULL;\n" +
				"		AUTOSTART = FALSE;\n" +
				"		STACK = SHARED;\n" +
				"	};\n" +
				"\n" +
				"	TASK App2Task {\n" +
				"		PRIORITY = 5;\n" +
				"		ACTIVATION = 1;\n" +
				"		SCHEDULE = FULL;\n" +
				"		AUTOSTART = FALSE;\n" +
				"		STACK = PRIVATE {\n" +
				"			SYS_SIZE = 512;\n" +
				"		};\n" +
				"	};\n" +
				"\n" +
				"	TASK App2Ack {\n" +
				"		PRIORITY = 10;\n" +
				"		ACTIVATION = 1;\n" +
				"		SCHEDULE = FULL;\n" +
				"		AUTOSTART = FALSE;\n" +
				"		STACK = SHARED;\n" +
				"	};\n" +
				"\n" +
				"	TASK App2HiPriTask {\n" +
				"		PRIORITY = 1000;\n" +
				"		ACTIVATION = 1;\n" +
				"		SCHEDULE = FULL;\n" +
				"		AUTOSTART = FALSE;\n" +
				"		STACK = SHARED;\n" +
				"	};\n" +
				"\n" +
				"	ISR TrustedIsr {\n" +
				"		CATEGORY = 2;\n" +
				"	};\n" +
				"\n" +
				"	ISR App1Isr {\n" +
				"		CATEGORY = 2;\n" +
				"	};\n" +
				"\n" +
				"	ISR App2Isr {\n" +
				"		CATEGORY = 2;\n" +
				"	};\n" +
				"\n" +
				"	APPLICATION TrustedApp {\n" +
				"		TRUSTED = TRUE {\n" +
				"			TRUSTED_FUNCTION = TRUE {\n" +
				"				NAME = \"MyTaskTrustedService\";\n" +
				"			};\n" +
				"			TRUSTED_FUNCTION = TRUE {\n" +
				"				NAME = \"MyIsrTrustedService\";\n" +
				"			};\n" +
				"			TRUSTED_FUNCTION = TRUE {\n" +
				"				NAME = \"MyQuickTrustedService\";\n" +
				"			};\n" +
				"		};\n" +
				"		ISR = TrustedIsr;\n" +
				"		TASK = MainTask;\n" +
				"		TASK = TrustedTask1;\n" +
				"		TASK = ErrorTask;\n" +
				"		MEMORY_BASE = \"0x40010000\";\n" +
				"		MEMORY_SIZE = 0x10000;\n" +
				"		SHARED_STACK_SIZE = 512;\n" +
				"		IRQ_STACK_SIZE = 512;\n" +
				"	};\n" +
				"\n" +
				"	APPLICATION App1 {\n" +
				"		TRUSTED = FALSE;\n" +
				"		ISR = App1Isr;\n" +
				"		TASK = App1Init;\n" +
				"		TASK = App1Task;\n" +
				"		TASK = App1Ack;\n" +
				"		TASK = App1Bkg;\n" +
				"		MEMORY_BASE = \"0x40020000\";\n" +
				"		MEMORY_SIZE = 0x10000;\n" +
				"		SHARED_STACK_SIZE = 512;\n" +
				"		IRQ_STACK_SIZE = 512;\n" +
				"	};\n" +
				"\n" +
				"	APPLICATION App2 {\n" +
				"		TRUSTED = FALSE;\n" +
				"		ISR = App2Isr;\n" +
				"		TASK = App2Init;\n" +
				"		TASK = App2Task;\n" +
				"		TASK = App2Ack;\n" +
				"		TASK = App2HiPriTask;\n" +
				"		MEMORY_BASE = \"0x40030000\";\n" +
				"		MEMORY_SIZE = 0x4000;\n" +
				"		SHARED_STACK_SIZE = 512;\n" +
				"		IRQ_STACK_SIZE = 512;\n" +
				"	};\n" +
				"};";
		commonWriterTest(text, 1);
	}

	@Test public void testMpc567_isr2_orti() {
	    final String text =
				"CPU test_application {\n" +
				"	OS EE {\n" +
				"		EE_OPT = \"DEBUG\";\n" +
				"		EE_OPT = \"__ASSERT__\";\n" +
				"		EE_OPT = \"__E200ZX_EXECUTE_FROM_RAM__\";\n" +
				"//		EE_OPT = \"__CODEWARRIOR__\";\n" +
				"\n" +
				"		CFLAGS = \"\";\n" +
				"		ASFLAGS = \"\";\n" +
				"		LDFLAGS = \"\";\n" +
				"\n" +
				"		CPU_DATA = PPCE200ZX {\n" +
				"			MODEL = E200Z7;\n" +
				"			APP_SRC = \"main.c\";\n" +
				"			MULTI_STACK = FALSE;\n" +
				"			VLE = TRUE;\n" +
				"			SYS_STACK_SIZE = 2048;\n" +
				"		};\n" +
				"\n" +
				"		MCU_DATA = PPCE200ZX {\n" +
				"			MODEL = MPC5674F;\n" +
				"		};\n" +
				"		\n" +
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
				"		ORTI_SECTIONS = ALL;\n" +
				"	};\n" +
				"\n" +
				"	TASK Task0 {\n" +
				"		PRIORITY = 1;   /* Lowest priority */\n" +
				"		SCHEDULE = FULL;\n" +
				"		AUTOSTART = TRUE;\n" +
				"		STACK = SHARED;\n" +
				"	};	\n" +
				"	\n" +
				"	TASK Task1 {\n" +
				"		PRIORITY = 2;   /* Low priority */\n" +
				"		SCHEDULE = FULL;\n" +
				"		AUTOSTART = FALSE;\n" +
				"		STACK = SHARED;\n" +
				"	};	\n" +
				"	\n" +
				"	TASK Task2 {\n" +
				"		PRIORITY = 10;   /* High priority */\n" +
				"		SCHEDULE = FULL;\n" +
				"		AUTOSTART = FALSE;\n" +
				"		STACK = SHARED;\n" +
				"	};\n" +
				"\n" +
				"	ISR DecrIsr {\n" +
				"		CATEGORY = 2;\n" +
				"	};\n" +
				"\n" +
				"	ISR FixedIntvIsr {\n" +
				"		CATEGORY = 2;\n" +
				"	};\n" +
				"\n" +
				" 	OS EE { KERNEL_TYPE = BCC1; }; \n" +
				"};\n";
		commonWriterTest(text, 1);
	}
	

	@Test
	public void testMpc567_alarm_counter_incr() {
	    final String text = "CPU test_application {\n" +
			"\n" +
			"	OS EE {		\n" +
			"		EE_OPT = \"DEBUG_STACK\";\n" +
			"\n" +
			"		CFLAGS = \"-g2\";\n" +
			"		ASFLAGS = \"\";\n" +
			"		LDFLAGS = \"\"; \n" +
			"\n" +
			"		CPU_DATA = PPCE200ZX {\n" +
			"			APP_SRC = \"main.c\";\n" +
			"			MULTI_STACK = TRUE {\n" + 
			"				IRQ_STACK = TRUE {\n" + 
			"					SYS_SIZE=64;\n" + 
			"				};\n" + 
			"			};\n" + 
			"			MODEL = E200Z7;\n" +
			"			VLE = FALSE;\n" +
			"		};\n" +
			"		\n" +
			"		MCU_DATA = PPCE200ZX {\n" +
			"			MODEL = MPC5674F;\n" + 
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
			"	COUNTER myCounter1 {\n" +
			"		MINCYCLE = 0;\n" +
			"		MAXALLOWEDVALUE = 10;\n" +
			"		TICKSPERBASE = 1;\n" +
			"	};\n" +
			"	COUNTER myCounter {\n" +
			"		MINCYCLE = 0;\n" +
			"		MAXALLOWEDVALUE = 10;\n" +
			"		TICKSPERBASE = 1;\n" +
			"	};\n" +

			"	ALARM AcquireAlarm {\n" +
			"		COUNTER = myCounter;\n" +
			"		ACTION = INCREMENTCOUNTER { COUNTER = myCounter1; };\n" +
			"	};\n" +
			"};";
		commonWriterTest(text, 1);
	}
	
	@Test
	public void testMpc567_alarm_counter_incr_cycle() {
	    final String text = "CPU test_application {\n" +
			"\n" +
			"	OS EE {		\n" +
			"		EE_OPT = \"DEBUG_STACK\";\n" +
			"\n" +
			"		CFLAGS = \"-g2\";\n" +
			"		ASFLAGS = \"\";\n" +
			"		LDFLAGS = \"\"; \n" +
			"\n" +
			"		CPU_DATA = PPCE200ZX {\n" +
			"			APP_SRC = \"main.c\";\n" +
			"			MULTI_STACK = TRUE {\n" + 
			"				IRQ_STACK = TRUE {\n" + 
			"					SYS_SIZE=64;\n" + 
			"				};\n" + 
			"			};\n" + 
			"			MODEL = E200Z7;\n" +
			"			VLE = FALSE;\n" +
			"		};\n" +
			"		\n" +
			"		MCU_DATA = PPCE200ZX {\n" +
			"			MODEL = MPC5674F;\n" + 
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
			"	COUNTER myCounter1 {\n" +
			"		MINCYCLE = 0;\n" +
			"		MAXALLOWEDVALUE = 10;\n" +
			"		TICKSPERBASE = 1;\n" +
			"	};\n" +
			"	COUNTER myCounter {\n" +
			"		MINCYCLE = 0;\n" +
			"		MAXALLOWEDVALUE = 10;\n" +
			"		TICKSPERBASE = 1;\n" +
			"	};\n" +
			"	ALARM AcquireAlarm {\n" +
			"		COUNTER = myCounter1;\n" +
			"		ACTION = INCREMENTCOUNTER { COUNTER = myCounter1; };\n" +
			"	};\n" +

			"};";
	    boolean ok = false;
	    try {
	    	commonWriterTest(text, 1);
	    } catch (RuntimeException e) {
	    	ok = true;
	    }
	    assertTrue(ok);
	}
	
	@Test
	public void testMpc567_alarm_counter_incr_cycle1() {
	    final String text = "CPU test_application {\n" +
			"\n" +
			"	OS EE {		\n" +
			"		EE_OPT = \"DEBUG_STACK\";\n" +
			"\n" +
			"		CFLAGS = \"-g2\";\n" +
			"		ASFLAGS = \"\";\n" +
			"		LDFLAGS = \"\"; \n" +
			"\n" +
			"		CPU_DATA = PPCE200ZX {\n" +
			"			APP_SRC = \"main.c\";\n" +
			"			MULTI_STACK = TRUE {\n" + 
			"				IRQ_STACK = TRUE {\n" + 
			"					SYS_SIZE=64;\n" + 
			"				};\n" + 
			"			};\n" + 
			"			MODEL = E200Z7;\n" +
			"			VLE = FALSE;\n" +
			"		};\n" +
			"		\n" +
			"		MCU_DATA = PPCE200ZX {\n" +
			"			MODEL = MPC5674F;\n" + 
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
			"	COUNTER myCounter1 {\n" +
			"		MINCYCLE = 0;\n" +
			"		MAXALLOWEDVALUE = 10;\n" +
			"		TICKSPERBASE = 1;\n" +
			"	};\n" +
			"	COUNTER myCounter {\n" +
			"		MINCYCLE = 0;\n" +
			"		MAXALLOWEDVALUE = 10;\n" +
			"		TICKSPERBASE = 1;\n" +
			"	};\n" +
			"	ALARM AcquireAlarm {\n" +
			"		COUNTER = myCounter1;\n" +
			"		ACTION = INCREMENTCOUNTER { COUNTER = myCounter; };\n" +
			"	};\n" +

			"	ALARM AcquireAlarm2 {\n" +
			"		COUNTER = myCounter;\n" +
			"		ACTION = INCREMENTCOUNTER { COUNTER = myCounter1; };\n" +
			"	};\n" +
			"};";
	    boolean ok = false;
	    try {
	    	commonWriterTest(text, 1);
	    } catch (RuntimeException e) {
	    	ok = true;
	    }
	    assertTrue(ok);
	}

	
	@Test
	public void testMpc567_alarm_counter_incr_2() {
	    final String text = "CPU test_application {\n" +
			"\n" +
			"	OS EE {		\n" +
			"		EE_OPT = \"DEBUG_STACK\";\n" +
			"\n" +
			"		CFLAGS = \"-g2\";\n" +
			"		ASFLAGS = \"\";\n" +
			"		LDFLAGS = \"\"; \n" +
			"\n" +
			"		CPU_DATA = PPCE200ZX {\n" +
			"			APP_SRC = \"main.c\";\n" +
			"			MULTI_STACK = TRUE {\n" + 
			"				IRQ_STACK = TRUE {\n" + 
			"					SYS_SIZE=64;\n" + 
			"				};\n" + 
			"			};\n" + 
			"			MODEL = E200Z7;\n" +
			"			VLE = FALSE;\n" +
			"		};\n" +
			"		\n" +
			"		MCU_DATA = PPCE200ZX {\n" +
			"			MODEL = MPC5674F;\n" + 
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
			"	COUNTER myCounter1 {\n" +
			"		MINCYCLE = 0;\n" +
			"		MAXALLOWEDVALUE = 10;\n" +
			"		TICKSPERBASE = 1;\n" +
			"	};\n" +
			"	COUNTER myCounter2 {\n" +
			"		MINCYCLE = 0;\n" +
			"		MAXALLOWEDVALUE = 10;\n" +
			"		TICKSPERBASE = 1;\n" +
			"	};\n" +
			"	COUNTER myCounter3 {\n" +
			"		MINCYCLE = 0;\n" +
			"		MAXALLOWEDVALUE = 10;\n" +
			"		TICKSPERBASE = 1;\n" +
			"	};\n" +
			"	COUNTER myCounter4 {\n" +
			"		MINCYCLE = 0;\n" +
			"		MAXALLOWEDVALUE = 10;\n" +
			"		TICKSPERBASE = 1;\n" +
			"	};\n" +
			"	ALARM alarm1 {\n" +
			"		COUNTER = myCounter1;\n" +
			"		ACTION = ACTIVATETASK { TASK = Task1; };\n" +
			"	};\n" +

			"	ALARM AcquireAlarm2 {\n" +
			"		COUNTER = myCounter2;\n" +
			"		ACTION = INCREMENTCOUNTER { COUNTER = myCounter1; };\n" +
			"	};\n" +
			"	ALARM AcquireAlarm3 {\n" +
			"		COUNTER = myCounter3;\n" +
			"		ACTION = INCREMENTCOUNTER { COUNTER = myCounter2; };\n" +
			"	};\n" +
			"	ALARM AcquireAlarm4 {\n" +
			"		COUNTER = myCounter4;\n" +
			"		ACTION = INCREMENTCOUNTER { COUNTER = myCounter1; };\n" +
			"	};\n" +
			"};";
    	commonWriterTest(text, 1);
	}

	@Test
	public void testMpc567_systemTimer() {
	    final String text = "CPU test_application {\n" +
			"\n" +
			"	OS EE {		\n" +
			"		EE_OPT = \"DEBUG_STACK\";\n" +
			"\n" +
			"		CFLAGS = \"-g2\";\n" +
			"		ASFLAGS = \"\";\n" +
			"		LDFLAGS = \"\"; \n" +
			"\n" +
			"		CPU_DATA = PPCE200ZX {\n" +
			"			APP_SRC = \"main.c\";\n" +
			"			MULTI_STACK = TRUE {\n" + 
			"				IRQ_STACK = TRUE {\n" + 
			"					SYS_SIZE=64;\n" + 
			"				};\n" + 
			"			};\n" + 
			"			MODEL = E200Z7;\n" +
			"			CPU_CLOCK = 98.5;\n" +
			"			VLE = FALSE;\n" +
			"		};\n" +
			"		\n" +
			"		MCU_DATA = PPCE200ZX {\n" +
			"			MODEL = MPC5674F;\n" + 
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
			"		TYPE = HARDWARE { DEVICE=\"DECREMENTER\"; SYSTEM_TIMER=TRUE;};\n" +
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
			"		TYPE = HARDWARE { DEVICE=\"INCREMENTER\";};\n" +
			"	};\n" +

			"	ALARM AcquireAlarm {\n" +
			"		COUNTER = myCounter;\n" +
			"		ACTION = INCREMENTCOUNTER { COUNTER = myCounter1; };\n" +
			"	};\n" +
			"};";
		commonWriterTest(text, 1);
	}

	@Test
	public void testMpc567_Timer_STM() {
	    final String text = "CPU test_application {\n" +
			"\n" +
			"	OS EE {		\n" +
			"		EE_OPT = \"DEBUG_STACK\";\n" +
			"\n" +
			"		CFLAGS = \"-g2\";\n" +
			"		ASFLAGS = \"\";\n" +
			"		LDFLAGS = \"\"; \n" +
			"\n" +
			"		CPU_DATA = PPCE200ZX {\n" +
			"			APP_SRC = \"main.c\";\n" +
			"			MULTI_STACK = TRUE {\n" + 
			"				IRQ_STACK = TRUE {\n" + 
			"					SYS_SIZE=64;\n" + 
			"				};\n" + 
			"			};\n" + 
			"			MODEL = E200Z4;\n" +
			"			CPU_CLOCK = 98.5;\n" +
			"			VLE = FALSE;\n" +
			"		};\n" +
			"		\n" +
			"		MCU_DATA = PPCE200ZX {\n" +
			"			MODEL = MPC5643L;\n" + 
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
			"		TYPE = HARDWARE { DEVICE=\"DECREMENTER\"; SYSTEM_TIMER=TRUE;};\n" +
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
			"		TYPE = HARDWARE { DEVICE=\"STM\";};\n" +
			"	};\n" +

			"	ALARM AcquireAlarm {\n" +
			"		COUNTER = myCounter;\n" +
			"		ACTION = INCREMENTCOUNTER { COUNTER = myCounter1; };\n" +
			"	};\n" +
			"};";
		commonWriterTest(text, 1);
	}

	@Test
	public void testMpc567_isr_resources() {
	    final String text = " CPU test_application {\n" + 
	    		" \n" + 
	    		"   OS EE {\n" + 
	    		"     EE_OPT = \"__ASSERT__\";\n" + 
	    		"     EE_OPT = \"DEBUG\";\n" + 
	    		" \n" + 
	    		"     STATUS = STANDARD;\n" + 
	    		" \n" + 
	    		"     STARTUPHOOK = FALSE;\n" + 
	    		"     ERRORHOOK = TRUE;\n" + 
	    		"     SHUTDOWNHOOK = FALSE;\n" + 
	    		"     PRETASKHOOK = FALSE;\n" + 
	    		"     POSTTASKHOOK = FALSE;\n" + 
	    		" \n" + 
	    		"     USEGETSERVICEID = FALSE;\n" + 
	    		"     USEPARAMETERACCESS = FALSE;\n" + 
	    		"     USERESSCHEDULER = FALSE;\n" + 
	    		" \n" + 
	    		"     EE_OPT = \"__E200ZX_EXECUTE_FROM_RAM__\";\n" + 
	    		"     EE_OPT = \"__CODEWARRIOR__\";\n" + 
	    		"     //EE_OPT = \"EEOPT_DIAB_5_8\";\n" + 
//	    		"     EE_OPT = \"EE_ISR_DYNAMIC_TABLE\";\n" + 
	    		" \n" + 
	    		"     MCU_DATA = PPCE200ZX {\n" + 
	    		"       MODEL = MPC5674F;\n" + 
	    		"     };\n" + 
	    		" \n" + 
	    		"     CPU_DATA = PPCE200ZX {\n" + 
	    		"       MODEL = E200Z7;\n" + 
	    		"       APP_SRC = \"code.c\";\n" + 
	    		"       APP_SRC = \"testcase/common/e200zx/test_irq.c\";\n" + 
	    		"       VLE = FALSE;\n" + 
	    		"       SYS_STACK_SIZE=2048;\n" + 
	    		" \n" + 
	    		"       MULTI_STACK = TRUE {\n" + 
	    		"         IRQ_STACK = FALSE;\n" + 
	    		"       };\n" + 
	    		"     };\n" + 
	    		" \n" + 
	    		"     KERNEL_TYPE = ECC1;\n" + 
	    		"     EE_OPT = \"__OO_STARTOS_OLD__\";\n" + 
	    		"   };\n" + 
	    		" \n" + 
	    		"   TASK Task1 {\n" + 
	    		"     PRIORITY = 1;\n" + 
	    		"     ACTIVATION = 1;\n" + 
	    		"     SCHEDULE = FULL;\n" + 
	    		"     AUTOSTART = FALSE;\n" + 
	    		"     STACK = SHARED;\n" + 
	    		"     RESOURCE = Resource1;\n" + 
	    		"     RESOURCE = ResourceA;\n" + 
	    		"     RESOURCE = ResourceB;\n" + 
	    		"   };\n" + 
	    		" \n" + 
	    		"   ISR IsrLow {\n" + 
	    		"     CATEGORY = 2;\n" + 
	    		"     PRIORITY = 1;\n" + 
	    		"     RESOURCE = ResourceA;\n" + 
	    		"     RESOURCE = ResourceB;\n" + 
	    	    "     ENTRY = \"0\";\n" +
	    		"   };\n" + 
	    		" \n" + 
	    		"   ISR IsrMedium {\n" + 
	    		"     CATEGORY = 2;\n" + 
	    		"     PRIORITY = 2;\n" + 
	    	    "     ENTRY = \"1\";\n" +
	    		"   };\n" + 
	    		" \n" + 
	    		"   ISR IsrHigh {\n" + 
	    		"     CATEGORY = 2;\n" + 
	    		"     PRIORITY = 3;\n" + 
	    		"     RESOURCE = ResourceB;\n" + 
	    	    "     ENTRY = \"2\";\n" +
	    		"   };\n" + 
	    		" \n" + 
	    		"   RESOURCE Resource1 { RESOURCEPROPERTY = STANDARD; };\n" + 
	    		"   RESOURCE ResourceA { RESOURCEPROPERTY = STANDARD; };\n" + 
	    		"   RESOURCE ResourceB { RESOURCEPROPERTY = STANDARD; };\n" + 
	    		" };\n";
    	commonWriterTest(text, 1);
	}
	
	@Test
	public void testMpc567_isr1_resources() {
	    final String text = " CPU test_application {\n" + 
	    		" \n" + 
	    		"   OS EE {\n" + 
	    		"     EE_OPT = \"__ASSERT__\";\n" + 
	    		"     EE_OPT = \"DEBUG\";\n" + 
	    		" \n" + 
	    		"     STATUS = STANDARD;\n" + 
	    		" \n" + 
	    		"     STARTUPHOOK = FALSE;\n" + 
	    		"     ERRORHOOK = TRUE;\n" + 
	    		"     SHUTDOWNHOOK = FALSE;\n" + 
	    		"     PRETASKHOOK = FALSE;\n" + 
	    		"     POSTTASKHOOK = FALSE;\n" + 
	    		" \n" + 
	    		"     USEGETSERVICEID = FALSE;\n" + 
	    		"     USEPARAMETERACCESS = FALSE;\n" + 
	    		"     USERESSCHEDULER = FALSE;\n" + 
	    		" \n" + 
	    		"     EE_OPT = \"__E200ZX_EXECUTE_FROM_RAM__\";\n" + 
	    		"     EE_OPT = \"__CODEWARRIOR__\";\n" + 
	    		"     //EE_OPT = \"EEOPT_DIAB_5_8\";\n" + 
//	    		"     EE_OPT = \"EE_ISR_DYNAMIC_TABLE\";\n" + 
	    		" \n" + 
	    		"     MCU_DATA = PPCE200ZX {\n" + 
	    		"       MODEL = MPC5674F;\n" + 
	    		"     };\n" + 
	    		" \n" + 
	    		"     CPU_DATA = PPCE200ZX {\n" + 
	    		"       MODEL = E200Z7;\n" + 
	    		"       APP_SRC = \"code.c\";\n" + 
	    		"       APP_SRC = \"testcase/common/e200zx/test_irq.c\";\n" + 
	    		"       VLE = FALSE;\n" + 
	    		"       SYS_STACK_SIZE=2048;\n" + 
	    		" \n" + 
	    		"       MULTI_STACK = TRUE {\n" + 
	    		"         IRQ_STACK = FALSE;\n" + 
	    		"       };\n" + 
	    		"     };\n" + 
	    		" \n" + 
	    		"     KERNEL_TYPE = ECC1;\n" + 
	    		"     EE_OPT = \"__OO_STARTOS_OLD__\";\n" + 
	    		"   };\n" + 
	    		" \n" + 
	    		"   TASK Task1 {\n" + 
	    		"     PRIORITY = 1;\n" + 
	    		"     ACTIVATION = 1;\n" + 
	    		"     SCHEDULE = FULL;\n" + 
	    		"     AUTOSTART = FALSE;\n" + 
	    		"     STACK = SHARED;\n" + 
	    		"     RESOURCE = Resource1;\n" + 
	    		"     RESOURCE = ResourceA;\n" + 
	    		"     RESOURCE = ResourceB;\n" + 
	    		"   };\n" + 
	    		" \n" + 
	    		"   ISR IsrLow {\n" + 
	    		"     CATEGORY = 2;\n" + 
	    		"     PRIORITY = 1;\n" + 
	    		"     RESOURCE = ResourceA;\n" + 
	    		"     RESOURCE = ResourceB;\n" + 
	    	    "     ENTRY = \"0\";\n" +
	    		"   };\n" + 
	    		" \n" + 
	    		"   ISR IsrMedium {\n" + 
	    		"     CATEGORY = 1;\n" + 
	    		"     PRIORITY = 2;\n" + 
	    	    "     ENTRY = \"1\";\n" +
	    		"   };\n" + 
	    		" \n" + 
	    		"   ISR IsrHigh {\n" + 
	    		"     CATEGORY = 2;\n" + 
	    		"     PRIORITY = 3;\n" + 
	    		"     RESOURCE = ResourceB;\n" + 
	    	    "     ENTRY = \"2\";\n" +
	    		"   };\n" + 
	    		" \n" + 
	    		"   RESOURCE Resource1 { RESOURCEPROPERTY = STANDARD; };\n" + 
	    		"   RESOURCE ResourceA { RESOURCEPROPERTY = STANDARD; };\n" + 
	    		"   RESOURCE ResourceB { RESOURCEPROPERTY = STANDARD; };\n" + 
	    		" };\n";
    	commonWriterTest(text, 1);
	}

	@Test
	public void testMpc567_monostack_resource() {
	    final String text = " CPU test_application {\n" +
				"\n" +
				"	OS EE {\n" +
				"		EE_OPT = \"DEBUG\";\n" +
				"		EE_OPT = \"__USE_LEDS__\";\n" +
				"		EE_OPT = \"__USE_BUTTONS__\";\n" +
				"		EE_OPT = \"__E200ZX_EXECUTE_FROM_RAM__\";\n" +
				"		EE_OPT = \"__CODEWARRIOR__\";\n" +
				"		EE_OPT = \"EE_ISR_DYNAMIC_TABLE\";\n" +
				"\n" +
				"		CFLAGS = \"\";\n" +
				"		ASFLAGS = \"\";\n" +
				"		LDFLAGS = \"\";\n" +
				"\n" +
				"		CPU_DATA = PPCE200ZX {\n" +
				"			MODEL = E200Z7;\n" +
				"			APP_SRC = \"code.c\";\n" +
				"			MULTI_STACK = FALSE;\n" +
				"			VLE = TRUE;\n" +
				"		};\n" +
				"\n" +
				"		MCU_DATA = PPCE200ZX {\n" +
				"			MODEL = MPC5674F;\n" +
				"		};\n" +
				"		\n" +
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
				"        KERNEL_TYPE = BCC1;\n" +
				"        EE_OPT = \"__OO_STARTOS_OLD__\";\n" +
				"\n" +
				"//		ORTI_SECTIONS = ALL;\n" +
				"    };\n" +
				"\n" +
				"    APPMODE ModeIncrement;\n" +
				"    APPMODE ModeDecrement;\n" +
				"\n" +
				"    TASK LowTask {\n" +
				"		PRIORITY = 0x01;\n" +
				"		ACTIVATION = 1;\n" +
				"		SCHEDULE = FULL;\n" +
				"		AUTOSTART = FALSE;\n" +
				"		STACK = SHARED;\n" +
				"		RESOURCE = Resource;\n" +
				"    };\n" +
				"\n" +
				"    TASK HighTask {\n" +
				"		PRIORITY = 0x02;\n" +
				"		ACTIVATION = 1;\n" +
				"		SCHEDULE = FULL;\n" +
				"		AUTOSTART = TRUE { APPMODE=ModeIncrement; };	\n" +
				"		STACK = SHARED;\n" +
				"		RESOURCE = Resource;\n" +
				"    };\n" +
				"\n" +
				"    RESOURCE Resource { RESOURCEPROPERTY = STANDARD; };\n" +
				"};";
    	commonWriterTest(text, 1);
	}
	
	
	
	@Test public void testDoublez4_CW() {
	    final String text = "CPU test_application {\n"+
			"\n"+
			"	OS EE {\n"+
			"		EE_OPT = \"__ASSERT__\";\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\";\n"+
			"\n"+
			"		EE_OPT = \"__E200ZX_EXECUTE_FROM_RAM__\";\n"+
			"\n"+
			"		MASTER_CPU = \"master\";\n"+
			"\n"+
			"		CPU_DATA = PPCE200ZX {\n"+
			"			ID = \"master\";\n"+
			"			MODEL = E200Z4;\n"+
			"			APP_SRC = \"master.c\";\n"+
			"			MULTI_STACK = FALSE;\n"+
			"			VLE = TRUE;\n"+
			"			SYS_STACK_SIZE = 4096;\n"+
			"			COMPILER_TYPE = CODEWARRIOR;\n"+
			"		};\n"+
			"\n"+
			"		CPU_DATA = PPCE200ZX {\n"+
			"			MODEL = E200Z4;\n"+
			"			ID = \"slave\";\n"+
			"			APP_SRC = \"slave.c\";\n"+
			"			MULTI_STACK = FALSE;\n"+
			"			VLE = TRUE;\n"+
			"			SYS_STACK_SIZE = 4096;\n"+
			"			COMPILER_TYPE = CODEWARRIOR;\n"+
			"		};\n"+
			"\n"+
			"		MCU_DATA = PPCE200ZX {\n"+
			"			MODEL = MPC5643L;\n"+
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
			"		KERNEL_TYPE = BCC1;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ6 {\n"+
			"		CPU_ID = \"master\";\n"+
			"		PRIORITY = 1;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ6b {\n"+
			"		CPU_ID = \"master\";\n"+
			"		PRIORITY = 3;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ6c {\n"+
			"		CPU_ID = \"master\";\n"+
			"		PRIORITY = 2;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ0 {\n"+
			"		CPU_ID = \"slave\";\n"+
			"		PRIORITY = 1;\n"+
			"		AUTOSTART = TRUE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ0b {\n"+
			"		CPU_ID = \"slave\";\n"+
			"		PRIORITY = 2;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ0c {\n"+
			"		CPU_ID = \"slave\";\n"+
			"		PRIORITY = 3;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"};\n";
		commonWriterTest(text, 2);
	}
	@Test public void testDoublez4_DIAB() {
	    final String text = "CPU test_application {\n"+
			"\n"+
			"	OS EE {\n"+
			"		EE_OPT = \"__ASSERT__\";\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\";\n"+
			"\n"+
			"		EE_OPT = \"__E200ZX_EXECUTE_FROM_RAM__\";\n"+
			"\n"+
			"		MASTER_CPU = \"master\";\n"+
			"\n"+
			"		CPU_DATA = PPCE200ZX {\n"+
			"			ID = \"master\";\n"+
			"			MODEL = E200Z4;\n"+
			"			APP_SRC = \"master.c\";\n"+
			"			MULTI_STACK = FALSE;\n"+
			"			VLE = TRUE;\n"+
			"			SYS_STACK_SIZE = 4096;\n"+
			"			COMPILER_TYPE = DIAB;\n"+
			"		};\n"+
			"\n"+
			"		CPU_DATA = PPCE200ZX {\n"+
			"			MODEL = E200Z4;\n"+
			"			ID = \"slave\";\n"+
			"			APP_SRC = \"slave.c\";\n"+
			"			MULTI_STACK = FALSE;\n"+
			"			VLE = TRUE;\n"+
			"			SYS_STACK_SIZE = 4096;\n"+
			"			COMPILER_TYPE = DIAB;\n"+
			"		};\n"+
			"\n"+
			"		MCU_DATA = PPCE200ZX {\n"+
			"			MODEL = MPC5643L;\n"+
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
			"		KERNEL_TYPE = BCC1;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ6 {\n"+
			"		CPU_ID = \"master\";\n"+
			"		PRIORITY = 1;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ6b {\n"+
			"		CPU_ID = \"master\";\n"+
			"		PRIORITY = 3;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ6c {\n"+
			"		CPU_ID = \"master\";\n"+
			"		PRIORITY = 2;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ0 {\n"+
			"		CPU_ID = \"slave\";\n"+
			"		PRIORITY = 1;\n"+
			"		AUTOSTART = TRUE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ0b {\n"+
			"		CPU_ID = \"slave\";\n"+
			"		PRIORITY = 2;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ0c {\n"+
			"		CPU_ID = \"slave\";\n"+
			"		PRIORITY = 3;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"};\n";
		commonWriterTest(text, 2);
	}
	@Test public void testDoublez4_GNU() {
	    final String text = "CPU test_application {\n"+
			"\n"+
			"	OS EE {\n"+
			"		EE_OPT = \"__ASSERT__\";\n"+
			"		CFLAGS = \"-g2\";\n"+
			"		ASFLAGS = \"\";\n"+
			"		LDFLAGS = \"\";\n"+
			"\n"+
			"		EE_OPT = \"__E200ZX_EXECUTE_FROM_RAM__\";\n"+
			"\n"+
			"		MASTER_CPU = \"master\";\n"+
			"\n"+
			"		CPU_DATA = PPCE200ZX {\n"+
			"			ID = \"master\";\n"+
			"			MODEL = E200Z4;\n"+
			"			APP_SRC = \"master.c\";\n"+
			"			MULTI_STACK = FALSE;\n"+
			"			VLE = TRUE;\n"+
			"			SYS_STACK_SIZE = 4096;\n"+
			"			COMPILER_TYPE = GNU;\n"+
			"		};\n"+
			"\n"+
			"		CPU_DATA = PPCE200ZX {\n"+
			"			MODEL = E200Z4;\n"+
			"			ID = \"slave\";\n"+
			"			APP_SRC = \"slave.c\";\n"+
			"			MULTI_STACK = FALSE;\n"+
			"			VLE = TRUE;\n"+
			"			SYS_STACK_SIZE = 4096;\n"+
			"			COMPILER_TYPE = GNU;\n"+
			"		};\n"+
			"\n"+
			"		MCU_DATA = PPCE200ZX {\n"+
			"			MODEL = MPC5643L;\n"+
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
			"		KERNEL_TYPE = BCC1;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ6 {\n"+
			"		CPU_ID = \"master\";\n"+
			"		PRIORITY = 1;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ6b {\n"+
			"		CPU_ID = \"master\";\n"+
			"		PRIORITY = 3;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ6c {\n"+
			"		CPU_ID = \"master\";\n"+
			"		PRIORITY = 2;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ0 {\n"+
			"		CPU_ID = \"slave\";\n"+
			"		PRIORITY = 1;\n"+
			"		AUTOSTART = TRUE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ0b {\n"+
			"		CPU_ID = \"slave\";\n"+
			"		PRIORITY = 2;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"\n"+
			"	TASK TaskZ0c {\n"+
			"		CPU_ID = \"slave\";\n"+
			"		PRIORITY = 3;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"	};\n"+
			"};\n";
		commonWriterTest(text, 2);
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
			"		CPU_DATA = PPCE200ZX {\n"+
			"			MODEL = E200Z4;\n"+
			"			APP_SRC = \"slave.c\";\n"+
			"			MULTI_STACK = FALSE;\n"+
			"			VLE = TRUE;\n"+
			"			SYS_STACK_SIZE = 4096;\n"+
			"		};\n"+
			"\n"+
			"		MCU_DATA = PPCE200ZX {\n"+
			"			MODEL = MPC5643L;\n"+
			"		};\n"+
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
			"		CPU_DATA = PPCE200ZX {\n"+
			"			MODEL = E200Z4;\n"+
			"			APP_SRC = \"slave.c\";\n"+
			"			MULTI_STACK = FALSE;\n"+
			"			VLE = TRUE;\n"+
			"			SYS_STACK_SIZE = 4096;\n"+
			"		};\n"+
			"\n"+
			"		MCU_DATA = PPCE200ZX {\n"+
			"			MODEL = MPC5643L;\n"+
			"		};\n"+
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
			"		CPU_DATA = PPCE200ZX {\n"+
			"			MODEL = E200Z4;\n"+
			"			APP_SRC = \"slave.c\";\n"+
			"			MULTI_STACK = FALSE;\n"+
			"			VLE = TRUE;\n"+
			"			SYS_STACK_SIZE = 4096;\n"+
			"		};\n"+
			"\n"+
			"		MCU_DATA = PPCE200ZX {\n"+
			"			MODEL = MPC5643L;\n"+
			"		};\n"+
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
			"		CPU_DATA = PPCE200ZX {\n"+
			"			MODEL = E200Z4;\n"+
			"			APP_SRC = \"slave.c\";\n"+
			"			MULTI_STACK = FALSE;\n"+
			"			VLE = TRUE;\n"+
			"			SYS_STACK_SIZE = 4096;\n"+
			"		};\n"+
			"\n"+
			"		MCU_DATA = PPCE200ZX {\n"+
			"			MODEL = MPC5643L;\n"+
			"		};\n"+
			"\n"+
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
			"		CPU_DATA = PPCE200ZX {\n"+
			"			MODEL = E200Z4;\n"+
			"			APP_SRC = \"slave.c\";\n"+
			"			MULTI_STACK = FALSE;\n"+
			"			VLE = TRUE;\n"+
			"			SYS_STACK_SIZE = 4096;\n"+
			"		};\n"+
			"\n"+
			"		MCU_DATA = PPCE200ZX {\n"+
			"			MODEL = MPC5643L;\n"+
			"		};\n"+
			"\n"+
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
			"		CPU_DATA = PPCE200ZX {\n"+
			"			MODEL = E200Z4;\n"+
			"			APP_SRC = \"slave.c\";\n"+
			"			MULTI_STACK = FALSE;\n"+
			"			VLE = TRUE;\n"+
			"			SYS_STACK_SIZE = 4096;\n"+
			"		};\n"+
			"\n"+
			"		MCU_DATA = PPCE200ZX {\n"+
			"			MODEL = MPC5643L;\n"+
			"		};\n"+
			"\n"+
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
			"		CPU_DATA = PPCE200ZX {\n"+
			"			MODEL = E200Z4;\n"+
			"			APP_SRC = \"slave.c\";\n"+
			"			MULTI_STACK = FALSE;\n"+
			"			VLE = TRUE;\n"+
			"			SYS_STACK_SIZE = 4096;\n"+
			"		};\n"+
			"\n"+
			"		MCU_DATA = PPCE200ZX {\n"+
			"			MODEL = MPC5643L;\n"+
			"		};\n"+
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
