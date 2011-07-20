package com.eu.evidence.rtdruid.test.modules.oil.codewriter;

import com.eu.evidence.rtdruid.vartree.data.init.Vt2StringUtilities;




public class CodeWriterMpc567Test extends AbstractCodeWriterTest {
	

	public void testMpc567_multi_stack() {
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


	public void testMpc567_multi_stack_orit() {
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

	public void testMpc567_os_application() {
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
			"    OSAPPLICATION appl1 {\n" +
			"		TRUSTED = FALSE;\n" +
			"		IRQ_STACK_SIZE = 1024;\n" +
			"    };\n" +
			"    OSAPPLICATION appl2 {\n" +
			"		TRUSTED = FALSE;\n" +
			"		IRQ_STACK_SIZE = 512;\n" +
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
			"		APPLICATION = appl1;\n" +
			"		ACTIVATION = 1;    /* only one pending activation */\n" +
			"	};	\n" +
			"    ISR isr_base1 {\n" +
			"		CATEGORY = 2;\n" +
			"	};	\n" +			
			"    ISR isr_app1 {\n" +
			"		CATEGORY = 2;\n" +
			"		APPLICATION = appl1;\n" +
			"	};	\n" +			
			"    OS EE { \n" +
			"		KERNEL_TYPE = ECC2;\n" +
			"		ORTI_SECTIONS = ALL;\n" +
			"		MAX_NESTING_LEVEL = 8;\n" +
			"  }; 	\n" +
			"};";
		commonWriterTest(text, 1);
	}


	public void testMpc567_full_os_application() {
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
			
			"    OSAPPLICATION app1 {\n" +
			"		TRUSTED = FALSE;\n" +
			"		IRQ_STACK_SIZE = 512;\n" +
			"    };\n" +
			"    OSAPPLICATION app2 {\n" +
			"		TRUSTED = FALSE;\n" +
			"		IRQ_STACK_SIZE = 512;\n" +
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
			"		APPLICATION = app1;\n" +
			"	};	\n" +
			"    TASK TaskApp2 {\n" +
			"		PRIORITY = 0x08;\n" +
			"		APP_SRC = \"app2.c\";\n" +
			"		AUTOSTART = FALSE;\n" +
			"		STACK = PRIVATE {\n" +
			"			SYS_SIZE = 128;\n" +
			"		};\n" +
			"		APPLICATION = app2;\n" +
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

}
