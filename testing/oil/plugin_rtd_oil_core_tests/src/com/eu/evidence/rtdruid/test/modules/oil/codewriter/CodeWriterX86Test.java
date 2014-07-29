package com.eu.evidence.rtdruid.test.modules.oil.codewriter;

import org.junit.Test;



public class CodeWriterX86Test extends AbstractCodeWriterTest {
	@Test public void testPortingMono0() {
	    final String text = "CPU mySystem {\n" +
	    		"	OS myOs {\n" +
	    		"		EE_OPT = \"DEBUG\";\n" +
	    		"		EE_OPT = \"__ASSERT__\";\n" +
	    		"		CPU_DATA = X86 {\n" +
	    		"			APP_SRC = \"code.c\";\n" +
	    		"			COMPILER_TYPE = GCC;\n" +
	    		"			MULTI_STACK = FALSE;\n" +
	    		"			USE_UART = TRUE;\n" +
	    		"		};\n" +
	    		"       STATUS = EXTENDED;\n" +
	    		"		STARTUPHOOK = FALSE;\n" +
	    		"		ERRORHOOK = FALSE;\n" +
	    		"		SHUTDOWNHOOK = FALSE;\n" +
	    		"		PRETASKHOOK = FALSE;\n" +
	    		"		POSTTASKHOOK = FALSE;\n" +
	    		"		USEGETSERVICEID = FALSE;\n" +
	    		"		USEPARAMETERACCESS = FALSE;\n" +
	    		"		USERESSCHEDULER = FALSE;\n" +
	    		"		KERNEL_TYPE = FP;\n" +
	    		"	};\n" +
	    		"	TASK Task1 {\n" +
	    		"		PRIORITY = 0x01;\n" +
	    		"		SCHEDULE = FULL;\n" +
	    		"		AUTOSTART = FALSE;\n" +
	    		"		ACTIVATION = 1;\n" +
	    		"		STACK = SHARED;\n" +
	    		"	};\n" +
	    		"\n" +
	    		"};\n";
		commonWriterTest(text, 1);
	}

	@Test public void testPortingMono1() {
	    final String text = "CPU test_application {\n" +
	    		"	OS EE {\n" +
	    		"		EE_OPT = \"DEBUG\";\n" +
	    		"		EE_OPT = \"__ASSERT__\";\n" +
	    		"		CPU_DATA = X86 {\n" +
	    		"			APP_SRC = \"code.c\";\n" +
	    		"			COMPILER_TYPE = GCC;\n" +
	    		"			USE_UART = TRUE;\n" +
	    		"			MULTI_STACK = FALSE;\n" +
	    		"		};\n" +
	    		"		STATUS = EXTENDED;\n" +
	    		"		STARTUPHOOK = FALSE;\n" +
	    		"		ERRORHOOK = FALSE;\n" +
	    		"		SHUTDOWNHOOK = FALSE;\n" +
	    		"		PRETASKHOOK = FALSE;\n" +
	    		"		POSTTASKHOOK = FALSE;\n" +
	    		"		USEGETSERVICEID = FALSE;\n" +
	    		"		USEPARAMETERACCESS = FALSE;\n" +
	    		"		USERESSCHEDULER = FALSE;\n" +
	    		"		KERNEL_TYPE = FP;\n" +
	    		"    };\n" +
	    		"    TASK Task1 {\n" +
	    		"		PRIORITY = 0x01;\n" +
	    		"		AUTOSTART = FALSE;\n" +
	    		"		STACK = PRIVATE {\n" +
	    		"			SYS_SIZE = 256;\n" +
	    		"		};\n" +
	    		"			ACTIVATION = 1;\n" +
	    		"		SCHEDULE = FULL;\n" +
	    		"	};\n" +
	    		"     TASK Task2 {\n" +
	    		"		PRIORITY = 0x02;\n" +
	    		"		AUTOSTART = FALSE;\n" +
	    		"		STACK = PRIVATE {\n" +
	    		"			SYS_SIZE = 256;\n" +
	    		"		};\n" +
	    		"		ACTIVATION = 1;\n" +
	    		"		SCHEDULE = FULL;\n" +
	    		"	};\n" +
	    		"};\n";
		commonWriterTest(text, 1);
	}

	@Test public void testPortingMono2() {
	    final String text = "CPU test_application {\n" +
	    		"	OS EE {\n" +
	    		"		EE_OPT = \"DEBUG\";\n" +
	    		"		EE_OPT = \"__ASSERT__\";\n" +
	    		"		CPU_DATA = X86 {\n" +
	    		"			APP_SRC = \"code.c\";\n" +
	    		"			COMPILER_TYPE = GCC;\n" +
	    		"			MULTI_STACK = TRUE {\n" +
	    		"				IRQ_STACK = TRUE {\n" +
	    		"					SYS_SIZE = 256;\n" +
	    		"				};\n" +
	    		"			};\n" +
	    		"		};\n" +
	    		"		KERNEL_TYPE = FP;\n" +
	    		"    };\n" +
	    		"    TASK Task1 {\n" +
	    		"		PRIORITY = 0x01;\n" +
	    		"		AUTOSTART = FALSE;\n" +
	    		"		STACK = PRIVATE {\n" +
	    		"			SYS_SIZE = 256;\n" +
	    		"		};\n" +
	    		"		ACTIVATION = 1;\n" +
	    		"		SCHEDULE = FULL;\n" +
	    		"	};\n" +
	    		"     TASK Task2 {\n" +
	    		"		PRIORITY = 0x02;\n" +
	    		"		AUTOSTART = FALSE;\n" +
	    		"		STACK = PRIVATE {\n" +
	    		"			SYS_SIZE = 256;\n" +
	    		"		};\n" +
	    		"		ACTIVATION = 1;\n" +
	    		"		SCHEDULE = FULL;\n" +
	    		"	};\n" +
	    		"};\n";
		commonWriterTest(text, 1);
	}

	@Test public void testPortingMono3() {
	    final String text = "CPU test_application {\n" +
	    		"	OS EE {\n" +
	    		"		EE_OPT = \"DEBUG\";\n" +
	    		"		EE_OPT = \"__ASSERT__\";\n" +
	    		"		EE_OPT = \"__X86__\";\n" +
	    		"		CFLAGS = \"\";\n" +
	    		"		ASFLAGS = \"\";\n" +
	    		"		LDFLAGS = \"\";\n" +
	    		"		CPU_DATA = X86 {\n" +
	    		"			APP_SRC = \"code.c\";\n" +
	    		"			COMPILER_TYPE = GCC;\n" +
	    		"			MULTI_STACK = FALSE;\n" +
	    		"		};\n" +
	    		"		STATUS = EXTENDED;\n" +
	    		"		STARTUPHOOK = FALSE;\n" +
	    		"		ERRORHOOK = FALSE;\n" +
	    		"		SHUTDOWNHOOK = FALSE;\n" +
	    		"		PRETASKHOOK = FALSE;\n" +
	    		"		POSTTASKHOOK = FALSE;\n" +
	    		"		USEGETSERVICEID = FALSE;\n" +
	    		"		USEPARAMETERACCESS = FALSE;\n" +
	    		"		USERESSCHEDULER = FALSE;\n" +
	    		"    };\n" +
	    		"	/* this is the OIL part for the first task */\n" +
	    		"    TASK Task1 {\n" +
	    		"		PRIORITY = 0x01;   /* Low priority */\n" +
	    		"		AUTOSTART = FALSE;\n" +
	    		"		STACK = SHARED;\n" +
	    		"		ACTIVATION = 1;    /* only one pending activation */\n" +
	    		"		SCHEDULE = FULL;\n" +
	    		"	};\n" +
	    		"     TASK Task2 {\n" +
	    		"		PRIORITY = 0x02;   /* Low priority */\n" +
	    		"		AUTOSTART = FALSE;\n" +
	    		"		STACK = SHARED;\n" +
	    		"		ACTIVATION = 1;    /* only one pending activation */	\n" +
	    		"		SCHEDULE = FULL;\n" +
	    		"	};	\n" +
	    		"    OS EE { KERNEL_TYPE = FP; };\n" +
	    		"};\n";
		commonWriterTest(text, 1);
	}

	@Test public void testPortingMono4() {
	    final String text = "CPU test_application {\n" +
	    		"	OS EE {\n" +
	    		"		EE_OPT = \"DEBUG\";\n" +
	    		"		EE_OPT = \"__ASSERT__\";\n" +
	    		"		EE_OPT = \"__X86__\";\n" +
	    		"		CFLAGS = \"\";\n" +
	    		"		ASFLAGS = \"\";\n" +
	    		"		LDFLAGS = \"\";\n" +
	    		"		CPU_DATA = X86 {\n" +
	    		"			APP_SRC = \"code.c\";\n" +
	    		"			COMPILER_TYPE = GCC;\n" +
	    		"			MULTI_STACK = FALSE;\n" +
	    		"		};\n" +
	    		"		STATUS = EXTENDED;\n" +
	    		"		STARTUPHOOK = FALSE;\n" +
	    		"		ERRORHOOK = FALSE;\n" +
	    		"		SHUTDOWNHOOK = FALSE;\n" +
	    		"		PRETASKHOOK = FALSE;\n" +
	    		"		POSTTASKHOOK = FALSE;\n" +
	    		"		USEGETSERVICEID = FALSE;\n" +
	    		"		USEPARAMETERACCESS = FALSE;\n" +
	    		"		USERESSCHEDULER = FALSE;\n" +
	    		"    };\n" +
	    		"	/* this is the OIL part for the first task */\n" +
	    		"    TASK Task1 {\n" +
	    		"		PRIORITY = 0x02;   /* Low priority */\n" +
	    		"		AUTOSTART = FALSE;\n" +
	    		"		STACK = SHARED;\n" +
	    		"		ACTIVATION = 1;    /* only one pending activation */\n" +
	    		"		SCHEDULE = FULL;\n" +
	    		"	};\n" +
	    		"     TASK Task2 {\n" +
	    		"		PRIORITY = 0x01;   /* Low priority */\n" +
	    		"		AUTOSTART = FALSE;\n" +
	    		"		STACK = SHARED;\n" +
	    		"		ACTIVATION = 1;    /* only one pending activation */\n" +
	    		"		SCHEDULE = FULL;\n" +
	    		"	};\n" +
	    		"   OS EE { KERNEL_TYPE = FP; };\n" +
	    		"};\n" ;
		commonWriterTest(text, 1);
	}

	@Test public void testPortingMono5() {
	    final String text = "CPU test_application {\n" +
	    		"	OS EE {\n" +
	    		"		EE_OPT = \"DEBUG\";\n" +
	    		"		EE_OPT = \"__ASSERT__\";\n" +
	    		"		EE_OPT = \"__X86__\";\n" +
	    		"		CFLAGS = \"\";\n" +
	    		"		ASFLAGS = \"\";\n" +
	    		"		LDFLAGS = \"\";\n" +
	    		"		CPU_DATA = X86 {\n" +
	    		"			APP_SRC = \"code.c\";\n" +
	    		"			COMPILER_TYPE = GCC;\n" +
	    		"			MULTI_STACK = FALSE;\n" +
	    		"		};\n" +
	    		"		KERNEL_TYPE = FP {\n" +
	    		"			NESTED_IRQ = TRUE;\n" +
	    		"		};\n" +
	    		"    };\n" +
	    		"	/* this is the OIL part for the first task */\n" +
	    		"    TASK Task1 {\n" +
	    		"		PRIORITY = 0x02;   /* Low priority */\n" +
	    		"		AUTOSTART = FALSE;\n" +
	    		"		STACK = SHARED;\n" +
	    		"		ACTIVATION = 1;    /* only one pending activation */\n" +
	    		"		SCHEDULE = FULL;\n" +
	    		"	};\n" +
	    		"     TASK Task2 {\n" +
	    		"		PRIORITY = 0x01;   /* Low priority */\n" +
	    		"		AUTOSTART = FALSE;\n" +
	    		"		STACK = SHARED;\n" +
	    		"		ACTIVATION = 1;    /* only one pending activation */\n" +
	    		"		SCHEDULE = FULL;\n" +
	    		"	};\n" +
	    		"};\n";
		commonWriterTest(text, 1);
	}

	@Test public void testPortingMono6() {
	    final String text = "CPU test_application {\n" +
	    		"	OS EE {\n" +
	    		"		EE_OPT = \"DEBUG\";\n" +
	    		"		EE_OPT = \"__ASSERT__\";\n" +
	    		"		CFLAGS = \"\";\n" +
	    		"		ASFLAGS = \"\";\n" +
	    		"		LDFLAGS = \"\";\n" +
	    		"		CPU_DATA = X86 {\n" +
	    		"			APP_SRC = \"code.c\";\n" +
	    		"			COMPILER_TYPE = GCC;\n" +
	    		"			MULTI_STACK = FALSE;\n" +
	    		"		};\n" +
	    		"    	KERNEL_TYPE = BCC1;\n" +
	    		"		EE_OPT = \"__OO_STARTOS_OLD__\";" +
	    		"		STATUS = EXTENDED;\n" +
	    		"		STARTUPHOOK = FALSE;\n" +
	    		"		ERRORHOOK = FALSE;\n" +
	    		"		SHUTDOWNHOOK = FALSE;\n" +
	    		"		PRETASKHOOK = FALSE;\n" +
	    		"		POSTTASKHOOK = FALSE;\n" +
	    		"		USEGETSERVICEID = FALSE;\n" +
	    		"		USEPARAMETERACCESS = FALSE;\n" +
	    		"		USERESSCHEDULER = FALSE;\n" +
	    		"    };\n" +
	    		"	/* this is the OIL part for the first task */\n" +
	    		"    TASK Task1 {\n" +
	    		"		PRIORITY = 0x01;   /* Low priority */\n" +
	    		"		AUTOSTART = FALSE;\n" +
	    		"		STACK = SHARED;\n" +
	    		"		ACTIVATION = 1;    /* only one pending activation */\n" +
	    		"		SCHEDULE = FULL;\n" +
	    		"	};\n" +
	    		"     TASK Task2 {\n" +
	    		"		PRIORITY = 0x01;   /* Low priority */\n" +
	    		"		AUTOSTART = FALSE;\n" +
	    		"		STACK = SHARED;\n" +
	    		"		ACTIVATION = 1;    /* only one pending activation */\n" +
	    		"		SCHEDULE = FULL;\n" +
	    		"	};\n" +
	    		"};\n";
		commonWriterTest(text, 1);
	}

	@Test public void testPortingMono7() {
	    final String text = "CPU test_application {\n" +
	    		"	OS EE {\n" +
	    		"		EE_OPT = \"DEBUG\";\n" +
	    		"		EE_OPT = \"__ASSERT__\";\n" +
	    		"		EE_OPT = \"__X86__\";\n" +
	    		"		CFLAGS = \"\";\n" +
	    		"		ASFLAGS = \"\";\n" +
	    		"		LDFLAGS = \"\";\n" +
	    		"		CPU_DATA = X86 {\n" +
	    		"			APP_SRC = \"code.c\";\n" +
	    		"			COMPILER_TYPE = GCC;\n" +
	    		"			MULTI_STACK = FALSE;\n" +
	    		"		};\n" +
	    		"		KERNEL_TYPE = BCC2;\n" +
	    		"		EE_OPT = \"__OO_STARTOS_OLD__\";\n" +
	    		"		STATUS = EXTENDED;\n" +
	    		"		STARTUPHOOK = FALSE;\n" +
	    		"		ERRORHOOK = FALSE;\n" +
	    		"		SHUTDOWNHOOK = FALSE;\n" +
	    		"		PRETASKHOOK = FALSE;\n" +
	    		"		POSTTASKHOOK = FALSE;\n" +
	    		"		USEGETSERVICEID = FALSE;\n" +
	    		"		USEPARAMETERACCESS = FALSE;\n" +
	    		"		USERESSCHEDULER = FALSE;\n" +
	    		"    };\n" +
	    		"	/* this is the OIL part for the first task */\n" +
	    		"    TASK Task1 {\n" +
	    		"		PRIORITY = 0x01;   /* Low priority */\n" +
	    		"		AUTOSTART = FALSE;\n" +
	    		"		STACK = SHARED;\n" +
	    		"		ACTIVATION = 1;    /* only one pending activation */\n" +
	    		"		SCHEDULE = FULL;\n" +
	    		"	};\n" +
	    		"     TASK Task2 {\n" +
	    		"		PRIORITY = 0x02;   /* Low priority */\n" +
	    		"		AUTOSTART = FALSE;\n" +
	    		"		STACK = SHARED;\n" +
	    		"		ACTIVATION = 1;    /* only one pending activation */\n" +
	    		"		SCHEDULE = FULL;\n" +
	    		"	};\n" +
	    		"};\n";
		commonWriterTest(text, 1);
	}

	@Test public void testPortingMono8() {
	    final String text = "CPU test_application {\n" +
	    		"	OS EE {\n" +
	    		"		EE_OPT = \"DEBUG\";\n" +
	    		"		EE_OPT = \"__ASSERT__\";\n" +
	    		"		CFLAGS = \"\";\n" +
	    		"		ASFLAGS = \"\";\n" +
	    		"		LDFLAGS = \"\";\n" +
	    		"		CPU_DATA = X86 {\n" +
	    		"			APP_SRC = \"code.c\";\n" +
	    		"			COMPILER_TYPE = GCC;\n" +
	    		"			MULTI_STACK = FALSE;\n" +
	    		"		};\n" +
	    		"		KERNEL_TYPE = FP;\n" +
	    		"    };\n" +
	    		"	/* this is the OIL part for the first task */\n" +
	    		"    TASK Task1 {\n" +
	    		"		PRIORITY = 0x01;   /* Low priority */\n" +
	    		"		AUTOSTART = FALSE;\n" +
	    		"		STACK = SHARED;\n" +
	    		"		ACTIVATION = 1;    /* only one pending activation */\n" +
	    		"		SCHEDULE = FULL;\n" +
	    		"		RESOURCE = Resource;\n" +
	    		"	};\n" +
	    		"     TASK Task2 {\n" +
	    		"		PRIORITY = 0x02;   /* Low priority */\n" +
	    		"		AUTOSTART = FALSE;\n" +
	    		"		STACK = SHARED;\n" +
	    		"		ACTIVATION = 1;    /* only one pending activation */\n" +
	    		"		SCHEDULE = FULL;\n" +
	    		"		RESOURCE = Resource;\n" +
	    		"	};\n" +
	    		"     RESOURCE Resource { RESOURCEPROPERTY = STANDARD; };\n" +
	    		"};\n";
		commonWriterTest(text, 1);
	}

	@Test public void testPortingMulti0() {
	    final String text = "CPU test_application {\n" +
	    		"	OS EE {\n" +
	    		"		EE_OPT = \"DEBUG\";\n" +
	    		"		EE_OPT = \"__ASSERT__\";\n" +
	    		"		CFLAGS = \"\";\n" +
	    		"		ASFLAGS = \"\";\n" +
	    		"		LDFLAGS = \"\";\n" +
	    		"		CPU_DATA = X86 {\n" +
	    		"			APP_SRC = \"code.c\";\n" +
	    		"			COMPILER_TYPE = GCC;\n" +
	    		"			MULTI_STACK = TRUE;\n" +
	    		"		};\n" +
	    		"		KERNEL_TYPE = FP;\n" +
	    		"    };\n" +
	    		"	/* this is the OIL part for the first task */\n" +
	    		"    TASK Task1 {\n" +
	    		"		PRIORITY = 0x01;   /* Low priority */\n" +
	    		"		AUTOSTART = FALSE;\n" +
	    		"		STACK = SHARED;\n" +
	    		"		ACTIVATION = 1;    /* only one pending activation */\n" +
	    		"		SCHEDULE = FULL;\n" +
	    		"	};\n" +
	    		"     TASK Task2 {\n" +
	    		"		PRIORITY = 0x02;   /* Low priority */\n" +
	    		"		AUTOSTART = FALSE;\n" +
	    		"		STACK = SHARED;\n" +
	    		"		ACTIVATION = 1;    /* only one pending activation */\n" +
	    		"		SCHEDULE = FULL;\n" +
	    		"	};\n" +
	    		"};\n";
		commonWriterTest(text, 1);
	}

	@Test public void testPortingMulti1() {
	    final String text = "CPU test_application {\n" +
	    		"	OS EE {\n" +
	    		"		EE_OPT = \"DEBUG\";\n" +
	    		"		EE_OPT = \"__ASSERT__\";\n" +
	    		"		CPU_DATA = X86 {\n" +
	    		"			APP_SRC = \"code.c\";\n" +
	    		"			COMPILER_TYPE = GCC;\n" +
	    		"			MULTI_STACK = FALSE;\n" +
	    		"		};\n" +
	    		"		STATUS = EXTENDED;\n" +
	    		"		STARTUPHOOK = FALSE;\n" +
	    		"		ERRORHOOK = FALSE;\n" +
	    		"		SHUTDOWNHOOK = FALSE;\n" +
	    		"		PRETASKHOOK = FALSE;\n" +
	    		"		POSTTASKHOOK = FALSE;\n" +
	    		"		USEGETSERVICEID = FALSE;\n" +
	    		"		USEPARAMETERACCESS = FALSE;\n" +
	    		"		USERESSCHEDULER = FALSE;\n" +
	    		"		KERNEL_TYPE = FP;\n" +
	    		"    };\n" +
	    		"	/* this is the OIL part for the first task */\n" +
	    		"    TASK Task1 {\n" +
	    		"		PRIORITY = 0x01;   /* Low priority */\n" +
	    		"		AUTOSTART = FALSE;\n" +
	    		"		STACK = PRIVATE {\n" +
	    		"			SYS_SIZE = 256;\n" +
	    		"		};\n" +
	    		"			ACTIVATION = 1;    /* only one pending activation */\n" +
	    		"		SCHEDULE = FULL;\n" +
	    		"	};\n" +
	    		"     TASK Task2 {\n" +
	    		"		PRIORITY = 0x02;   /* Low priority */\n" +
	    		"		AUTOSTART = FALSE;\n" +
	    		"		STACK = PRIVATE {\n" +
	    		"			SYS_SIZE = 256;\n" +
	    		"		};\n" +
	    		"		ACTIVATION = 1;    /* only one pending activation */\n" +
	    		"		SCHEDULE = FULL;\n" +
	    		"	};\n" +
	    		"};\n";
		commonWriterTest(text, 1);
	}

	@Test public void testPortingMulti2() {
	    final String text = "CPU test_application {\n" +
	    		"	OS EE {\n" +
	    		"		EE_OPT = \"DEBUG\";\n" +
	    		"		EE_OPT = \"__ASSERT__\";\n" +
	    		"		CPU_DATA = X86 {\n" +
	    		"			APP_SRC = \"code.c\";\n" +
	    		"			COMPILER_TYPE = GCC;\n" +
	    		"			MULTI_STACK = TRUE {\n" +
	    		"				IRQ_STACK = TRUE {\n" +
	    		"					SYS_SIZE = 256;\n" +
	    		"				};\n" +
	    		"			};\n" +
	    		"		};\n" +
	    		"		KERNEL_TYPE = FP;\n" +
	    		"    };\n" +
	    		"    TASK Task1 {\n" +
	    		"		PRIORITY = 0x01;   /* Low priority */\n" +
	    		"		AUTOSTART = FALSE;\n" +
	    		"		STACK = PRIVATE {\n" +
	    		"			SYS_SIZE = 256;\n" +
	    		"		};\n" +
	    		"		ACTIVATION = 1;    /* only one pending activation */\n" +
	    		"		SCHEDULE = FULL;\n" +
	    		"	};\n" +
	    		"     TASK Task2 {\n" +
	    		"		PRIORITY = 0x02;   /* Low priority */\n" +
	    		"		AUTOSTART = FALSE;\n" +
	    		"		STACK = PRIVATE {\n" +
	    		"			SYS_SIZE = 256;\n" +
	    		"		};\n" +
	    		"		ACTIVATION = 1;    /* only one pending activation */\n" +
	    		"		SCHEDULE = FULL;\n" +
	    		"	};\n" +
	    		"};\n";
		commonWriterTest(text, 1);
	}

	@Test public void testPortingMulti3() {
	    final String text = "CPU test_application {\n" +
	    		"	OS EE {\n" +
	    		"		EE_OPT = \"DEBUG\";\n" +
	    		"		EE_OPT = \"__ASSERT__\";\n" +
	    		"		CPU_DATA = X86 {\n" +
	    		"			APP_SRC = \"code.c\";\n" +
	    		"			COMPILER_TYPE = GCC;\n" +
	    		"			MULTI_STACK = FALSE;\n" +
	    		"		};\n" +
	    		"		KERNEL_TYPE = FP {\n" +
	    		"			NESTED_IRQ = TRUE;\n" +
	    		"		};\n" +
	    		"    };\n" +
	    		"	/* this is the OIL part for the first task */\n" +
	    		"    TASK Task1 {\n" +
	    		"		PRIORITY = 0x01;   /* Low priority */\n" +
	    		"		AUTOSTART = FALSE;\n" +
	    		"		STACK = PRIVATE {\n" +
	    		"			SYS_SIZE = 256;\n" +
	    		"		};\n" +
	    		"		ACTIVATION = 1;    /* only one pending activation */\n" +
	    		"		SCHEDULE = FULL;\n" +
	    		"	};\n" +
	    		"     TASK Task2 {\n" +
	    		"		PRIORITY = 0x02;   /* Low priority */\n" +
	    		"		AUTOSTART = FALSE;\n" +
	    		"		STACK = PRIVATE {\n" +
	    		"			SYS_SIZE = 256;\n" +
	    		"		};\n" +
	    		"		ACTIVATION = 1;    /* only one pending activation */\n" +
	    		"		SCHEDULE = FULL;\n" +
	    		"	};\n" +
	    		"};\n";
		commonWriterTest(text, 1);
	}

	@Test public void testPortingMulti4() {
	    final String text = "CPU test_application {\n" +
	    		"	OS EE {\n" +
	    		"		EE_OPT = \"DEBUG\";\n" +
	    		"		EE_OPT = \"__ASSERT__\";\n" +
	    		"		CPU_DATA = X86 {\n" +
	    		"			APP_SRC = \"code.c\";\n" +
	    		"			COMPILER_TYPE = GCC;\n" +
	    		"			MULTI_STACK = FALSE;\n" +
	    		"		};\n" +
	    		"		KERNEL_TYPE = FP {\n" +
	    		"			NESTED_IRQ = TRUE;\n" +
	    		"		};\n" +
	    		"    };\n" +
	    		"	/* this is the OIL part for the first task */\n" +
	    		"    TASK Task1 {\n" +
	    		"		PRIORITY = 0x01;   /* Low priority */\n" +
	    		"		AUTOSTART = FALSE;\n" +
	    		"		STACK = PRIVATE {\n" +
	    		"			SYS_SIZE = 256;\n" +
	    		"		};\n" +
	    		"		ACTIVATION = 1;    /* only one pending activation */\n" +
	    		"		SCHEDULE = FULL;\n" +
	    		"	};\n" +
	    		"     TASK Task2 {\n" +
	    		"		PRIORITY = 0x02;   /* Low priority */\n" +
	    		"		AUTOSTART = FALSE;\n" +
	    		"		STACK = PRIVATE {\n" +
	    		"			SYS_SIZE = 256;\n" +
	    		"		};\n" +
	    		"		ACTIVATION = 1;    /* only one pending activation */\n" +
	    		"		SCHEDULE = FULL;\n" +
	    		"	};\n" +
	    		"};\n";
		commonWriterTest(text, 1);
	}

	@Test public void testPortingMulti5() {
	    final String text = "CPU test_application {\n" +
	    		"	OS EE {\n" +
	    		"		EE_OPT = \"DEBUG\";\n" +
	    		"		EE_OPT = \"__ASSERT__\";\n" +
	    		"		EE_OPT = \"__SEM__\";\n" +
	    		"		CPU_DATA = X86 {\n" +
	    		"			APP_SRC = \"code.c\";\n" +
	    		"			COMPILER_TYPE = GCC;\n" +
	    		"			MULTI_STACK = TRUE {\n" +
	    		"				IRQ_STACK = TRUE {\n" +
	    		"						SYS_SIZE = 256;\n" +
	    		"				};\n" +
	    		"			};\n" +
	    		"		};\n" +
	    		"		KERNEL_TYPE = FP {\n" +
	    		"			NESTED_IRQ = TRUE;\n" +
	    		"		};\n" +
	    		"    };\n" +
	    		"	/* this is the OIL part for the first task */\n" +
	    		"    TASK Task1 {\n" +
	    		"		PRIORITY = 0x02;   /* Low priority */\n" +
	    		"		AUTOSTART = FALSE;\n" +
	    		"		STACK = PRIVATE {\n" +
	    		"			SYS_SIZE = 256;\n" +
	    		"		};\n" +
	    		"		ACTIVATION = 1;    /* only one pending activation */\n" +
	    		"		SCHEDULE = FULL;\n" +
	    		"	};\n" +
	    		"     TASK Task2 {\n" +
	    		"		PRIORITY = 0x01;   /* Low priority */\n" +
	    		"		AUTOSTART = FALSE;\n" +
	    		"		STACK = PRIVATE {\n" +
	    		"			SYS_SIZE = 256;\n" +
	    		"		};\n" +
	    		"		ACTIVATION = 1;    /* only one pending activation */\n" +
	    		"		SCHEDULE = FULL;\n" +
	    		"	};\n" +
	    		"};\n";
		commonWriterTest(text, 1);
	}

	@Test public void testPortingMulti6() {
	    final String text = "CPU test_application {\n" +
	    		"	OS EE {\n" +
	    		"		EE_OPT = \"DEBUG\";\n" +
	    		"		EE_OPT = \"__ASSERT__\";\n" +
	    		"		EE_OPT = \"__SEM__\";\n" +
	    		"		CPU_DATA = X86 {\n" +
	    		"			APP_SRC = \"code.c\";\n" +
	    		"			COMPILER_TYPE = GCC;\n" +
	    		"			MULTI_STACK = TRUE {\n" +
	    		"				IRQ_STACK = TRUE {\n" +
	    		"					SYS_SIZE = 256;\n" +
	    		"				};\n" +
	    		"			};\n" +
	    		"		};\n" +
	    		"		KERNEL_TYPE = FP {\n" +
	    		"			NESTED_IRQ = TRUE;\n" +
	    		"		};\n" +
	    		"    };\n" +
	    		"	/* this is the OIL part for the first task */\n" +
	    		"    TASK Task1 {\n" +
	    		"		PRIORITY = 0x01;   /* Low priority */\n" +
	    		"		AUTOSTART = FALSE;\n" +
	    		"		STACK = PRIVATE {\n" +
	    		"			SYS_SIZE = 256;\n" +
	    		"		};\n" +
	    		"		ACTIVATION = 1;    /* only one pending activation */\n" +
	    		"		SCHEDULE = FULL;\n" +
	    		"	};\n" +
	    		"     TASK Task2 {\n" +
	    		"		PRIORITY = 0x02;   /* Low priority */\n" +
	    		"		AUTOSTART = FALSE;\n" +
	    		"		STACK = PRIVATE {\n" +
	    		"			SYS_SIZE = 256;\n" +
	    		"		};\n" +
	    		"		ACTIVATION = 1;    /* only one pending activation */\n" +
	    		"		SCHEDULE = FULL;\n" +
	    		"	};\n" +
	    		"};\n";
		commonWriterTest(text, 1);
	}

}
