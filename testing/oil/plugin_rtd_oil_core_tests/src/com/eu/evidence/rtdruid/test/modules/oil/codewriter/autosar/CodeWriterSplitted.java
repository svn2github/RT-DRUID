package com.eu.evidence.rtdruid.test.modules.oil.codewriter.autosar;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import com.eu.evidence.rtdruid.test.modules.oil.codewriter.AbstractCodeWriterTest;

public class CodeWriterSplitted extends AbstractCodeWriterTest {

	@Test
	public void testsplitted_os_application() {
	    final String text1 = "CPU test_application {\n" +
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
			"    };\n" +
			"    \n" +
			"    APPLICATION appl1 {\n" +
			"		TASK=Task_app1;\n" +
			"       ISR = isr_base1;\n" +
			"       ISR = isr_app1;\n" +
    		"		MEMORY_BASE = \"0x40020000\";\n"+
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
	    
	    final String expectedResult = "CPU test_application {\n" +
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
	    		"		MEMORY_BASE = \"0x40020000\";\n"+
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
	    
		DefaultTestResult r1 = commonWriterTest(text1, 1);
		DefaultTestResult r2 = commonWriterTest(expectedResult, 1);
		
		assertEquals(r1.buffers.length, r2.buffers.length);
		for (int i = 0; i<r1.buffers.length; i++) {
			assertEquals(r1.buffers[i].toString(), r2.buffers[i].toString());
			
		}
	}
	
	@Test
	public void testsplitted_os_application2() throws IOException {
	    final String input1 = "CPU test_application {\n" +
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
			"    };\n" +
			"};\n";

	    final String input2 = "CPU another_test_application {\n" +
			"    \n" +
			"    APPLICATION appl1 {\n" +
			"		TASK=Task_app1;\n" +
			"       ISR = isr_base1;\n" +
			"       ISR = isr_app1;\n" +
    		"		MEMORY_BASE = \"0x40020000\";\n"+
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
	    
	    final String expectedResult = "CPU test_application {\n" +
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
	    		"		MEMORY_BASE = \"0x40020000\";\n"+
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
	    
		DefaultTestResult r1 = commonWriterTest(new String[] {input1, input2}, new String[] {"input1.oil", "input1.oil"}, 1);
		DefaultTestResult r2 = commonWriterTest(expectedResult, 1);
		
		assertEquals(r1.buffers.length, r2.buffers.length);
		for (int i = 0; i<r1.buffers.length; i++) {
			assertEquals(r1.buffers[i].toString(), r2.buffers[i].toString());
			
		}
	}
}
