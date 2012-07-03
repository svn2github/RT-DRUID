package com.eu.evidence.rtdruid.test.modules.oil.codewriter;

import org.junit.Test;



public class CodeWriterMpc5Test extends AbstractCodeWriterTest {
	

	@Test public void testMpc5CodeWriteWithoutResources() {
		final String text = "CPU EE {\n"
			+ "    OS EE {\n"+
			
			"		CPU_DATA = MPC5 {\n" +
			"			MULTI_STACK = TRUE {\n" +
			"				IRQ_STACK = TRUE { SYS_SIZE = 512; };\n" +
			"				DUMMY_STACK = SHARED;\n" +
			"			};\n" +
			"			\n" +
			"			APP_SRC = \"code.c\";\n" +
			"	\n" +
			"        STACK_BOTTOM = 0x0FFF0000;\n"+
			"        SYS_SIZE = 0x1000;\n"+
		
			"        HANDLER_LVL0 = \"handler lvl 0\";\n"+
			"        HANDLER_IRQ4 = \"handler irq 4\";\n"+
			"        HANDLER_IRQ7 = \"handler irq 7\";\n"+
			"	\n" +
			"		};\n" 
			
			+ "        STATUS = EXTENDED;\n"
			+ "        STARTUPHOOK = TRUE;\n"
			+ "        ERRORHOOK = FALSE;\n"
			+ "        SHUTDOWNHOOK = FALSE;\n"
			+ "        PRETASKHOOK = FALSE;\n"
			+ "        POSTTASKHOOK = FALSE;\n"
			+ "        USEGETSERVICEID = FALSE;\n"
			+ "        USEPARAMETERACCESS = FALSE;\n"
			+ "        USERESSCHEDULER = FALSE;\n"
			+ "        KERNEL_TYPE = BCC1;\n"
			+ "    };\n"
			+ "    TASK Task1 {\n"
			+ "        PRIORITY = 0x01;\n"
			+ "        ACTIVATION = 1;\n"
			+ "        SCHEDULE = FULL;\n"
			+ "        AUTOSTART = FALSE;\n"
			+ "        STACK = PRIVATE { SYS_SIZE = 1024; };\n"
			+ "    };\n"
			+ "    TASK Task2 {\n"
			+ "        PRIORITY = 0x02;\n"
			+ "        ACTIVATION = 1;\n"
			+ "        SCHEDULE = FULL;\n"
			+ "        AUTOSTART = FALSE;\n"
			+ "        STACK = SHARED;\n"
			+ "    };\n"
			+ "};\n";
		commonWriterTest(text, 1);
	}

// with APPMODE

	@Test public void testMpc5CodeWrite() {
		final String text =
			"CPU EE {\n"
			+ "    OS EE {\n"+
			
			"		CPU_DATA = MPC5 {\n" +
			"			MULTI_STACK = TRUE {\n" +
			"				IRQ_STACK = TRUE { SYS_SIZE = 512; };\n" +
			"				DUMMY_STACK = PRIVATE { SYS_SIZE = 512; };\n" +
			"			};\n" +
			"			\n" +
			"			APP_SRC = \"code.c\";\n" +
			"	\n" +
			"        STACK_BOTTOM = 0x0FFF0000;\n"+
			"        SYS_SIZE = 0x1000;\n"+
		
			"        HANDLER_LVL0 = \"pit_handler\";\n"+
			"        HANDLER_LVL1 = \"rt_clock_handler\";\n"+
			"        HANDLER_IRQ7 = \"handler_irq_7\";\n"+
			"	\n" +
			"		};\n" 
			
		//	+ "        STATUS = EXTENDED;\n"
		//	+ "        STARTUPHOOK = TRUE;\n"
		//	+ "        ERRORHOOK = FALSE;\n"
		//	+ "        SHUTDOWNHOOK = FALSE;\n"
		//	+ "        PRETASKHOOK = FALSE;\n"
		//	+ "        POSTTASKHOOK = FALSE;\n"
		//	+ "        USEGETSERVICEID = FALSE;\n"
		//	+ "        USEPARAMETERACCESS = FALSE;\n"
		//	+ "        USERESSCHEDULER = FALSE;\n"
			+ "        KERNEL_TYPE = FP;\n"
			+ "    };\n"
			+ "    TASK thread0 {\n"
			+ "        PRIORITY = 0x01;\n"
			+ "        ACTIVATION = 1;\n"
			+ "        SCHEDULE = FULL;\n"
			+ "        AUTOSTART = FALSE;\n"
			+ "        STACK = PRIVATE { SYS_SIZE = 512; };\n"
			+ "    };\n"
			+ "    TASK thread1 {\n"
			+ "        PRIORITY = 0x02;\n"
			+ "        ACTIVATION = 1;\n"
			+ "        SCHEDULE = FULL;\n"
			+ "        AUTOSTART = FALSE;\n"
			+ "        STACK = PRIVATE { SYS_SIZE = 512; };\n"
			+ "    };\n"
			+ "    TASK thread2 {\n"
			+ "        PRIORITY = 0x04;\n"
			+ "        ACTIVATION = 1;\n"
			+ "        SCHEDULE = FULL;\n"
			+ "        AUTOSTART = FALSE;\n"
			+ "        STACK = PRIVATE { SYS_SIZE = 512; };\n"
			+ "        RESOURCE = MUTEX_sync;"
			+ "    };\n"
			+ "    TASK thread3 {\n"
			+ "        PRIORITY = 0x19;\n"
			+ "        ACTIVATION = 1;\n"
			+ "        SCHEDULE = FULL;\n"
			+ "        AUTOSTART = FALSE;\n"
			+ "        STACK = PRIVATE { SYS_SIZE = 512; };\n"
			+ "    };\n"
			+ "    RESOURCE MUTEX_sync { RESOURCEPROPERTY = STANDARD; };"
			+ "};\n";
		commonWriterTest(text, 1);
	}

}
