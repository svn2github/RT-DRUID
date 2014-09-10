package com.eu.evidence.rtdruid.test.modules.oil.codewriter.autosar;

import org.junit.Test;

import com.eu.evidence.rtdruid.test.modules.oil.codewriter.AbstractCodeWriterTest;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.autosar.AutosarOilWriterTests.DirectWriter;

public class CodeWriterAutosar extends AbstractCodeWriterTest implements DirectWriter {
	@Override
	public DefaultTestResult doWrite(String oil_text, int expected_cpu) {
		return super.commonWriterTest(oil_text, expected_cpu);
	}

	@Test
	public void testAutosar_1() {
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
				"    };\n" + 
//				"};\n" + 
//				"CPU mySystem {\n" + 
				"	OS myOs {\n" + 
				"		EE_OPT = \"DEBUG2\";\n" + 
				"        PRETASKHOOK = FALSE;\n" + 
				"        POSTTASKHOOK = FALSE;\n" + 
				"        USEGETSERVICEID = FALSE;\n" + 
				"        USEPARAMETERACCESS = FALSE;\n" + 
				"        USERESSCHEDULER = TRUE;\n" + 
				"        \n" + 
				"        CPU_DATA = PIC30 {\n" + 
				"			APP_SRC = \"code.c\";\n" +
				"        };\n" +
				"    };\n" + 
//				"};\n" + 
//				"CPU mySystem {\n" + 
				"	OS myOs {\n" + 
				"        CPU_DATA = PIC30 {\n" + 
				"			APP_SRC = \"T1.S\";\n" + 
				"			MULTI_STACK = TRUE {\n" + 
				"				IRQ_STACK = TRUE {\n" + 
				"					SYS_SIZE=64;\n" + 
				"				};\n" + 
//				"				DUMMY_STACK = SHARED;\n" + 
				"			};\n" + 
//				"			STACK_BOTTOM = 0xFFFF;\n" + 
//				"			SYS_SIZE = 256;    // available space for all user stacks\n" + 
//				"			SHARED_MIN_SYS_SIZE = 64;    // size of shared stack\n" + 
				"	\n" + 
				"			ICD2 = TRUE;\n" + 
				"				\n" + 
//				"			LINKER_SCRIPT = \"p30f2010.gld\";\n" + 
				"		};\n" + 
				"\n" + 
				"		KERNEL_TYPE = BCC1;\n" + 
				
				"		BOARD_DATA = EE_FLEX {\n" + 
				"			TYPE = STANDARD {" +
				"				OPTIONS = LEDS;\n" + 
				"				OPTIONS = LCD;\n" + 
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
				"		RESOURCE = \"MUTEX_sync\";\n" + 
				"	};\n" + 
				"\n" + 
				"    TASK Task1 {\n" + 
				"        PRIORITY = 2;\n" + 
				"        ACTIVATION = 4;\n" + 
				"	};\n" + 
				"\n" + 
				"    TASK Task1 {\n" + 
				"        STACK = SHARED;\n" + 
				"        SCHEDULE = FULL;\n" + 
				"    };\n" + 
				"\n" + 
				"    TASK Task2 {\n" + 
				"        PRIORITY = 3;\n" + 
				"        ACTIVATION = 4;\n" + 
				"		STACK = SHARED;\n" + 
				"        SCHEDULE = FULL;\n" + 
				"        RESOURCE = \"MUTEX_sync\";\n" + 
				"    };\n" + 
				"\n" + 
				"    TASK Task3 {\n" + 
				"        PRIORITY = 4;\n" + 
				"        ACTIVATION = 4;\n" + 
				"		STACK = SHARED;\n" + 
				"        SCHEDULE = FULL;\n" + 
				"    };\n" + 
				"\n" + 
				"    RESOURCE MUTEX_sync { RESOURCEPROPERTY = STANDARD; };\n" + 
				"};\n";
	    
	    
	    AutosarOilWriterTests.writerAutosarTest(this, text, 1);
	}
	
	
	@Test
	public void testAutosar_2() {
	    final String text =
	    		"CPU PerfTestApp {\n" +
			"	OS EE {\n" +
			"		CFLAGS = \"-I../inc\";\n" +
			"		CFLAGS = \"-Xsmall-data=0\";\n" +

//			"		EE_OPT = \"__OO_SEM__\";\n" +

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
			"\n" +
			"//		ORTI_SECTIONS = ALL;\n" +
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
			"	TASK TrustedTask {\n" +
			"		PRIORITY = 1;\n" +
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
			"	TASK App2Task {\n" +
			"		PRIORITY = 4;\n" +
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
			"		TRUSTED = TRUE;\n" +
			"		ISR = TrustedIsr;\n" +
			"		TASK = MainTask;\n" +
			"		TASK = TrustedTask;\n" +
			
			"		MEMORY_BASE = \"0x40010000\";\n" +
			"		MEMORY_SIZE = 0x10000;\n" +

			"		SHARED_STACK_SIZE = 512;\n" +
			"		IRQ_STACK_SIZE = 1024;\n" +
			"	};\n" +
			"\n" +
			"	APPLICATION App1 {\n" +
			"		TRUSTED = FALSE;\n" +
			"		ISR = \"App1Isr\";\n" +
			"		TASK = \"App1Task\";\n" +

			"		MEMORY_BASE = \"0x40020000\";\n" +
			"		MEMORY_SIZE = 0x10000;\n" +

			"		SHARED_STACK_SIZE = 512;\n" +
			"		IRQ_STACK_SIZE = 1024;\n" +
			"	};\n" +
			"\n" +
			"	APPLICATION App2 {\n" +
			"		TRUSTED = FALSE;\n" +
			"		ISR = App2Isr;\n" +
			"		TASK = App2Task;\n" +

			"		MEMORY_BASE = \"0x40030000\";\n" +
			"		MEMORY_SIZE = 0x4000;\n" +
			"		SHARED_STACK_SIZE = 512;\n" +
			"		IRQ_STACK_SIZE = 1024;\n" +
			"	};\n" +
			"};\n";
  
	    AutosarOilWriterTests.writerAutosarTest(this, text, 1);
	}

}
