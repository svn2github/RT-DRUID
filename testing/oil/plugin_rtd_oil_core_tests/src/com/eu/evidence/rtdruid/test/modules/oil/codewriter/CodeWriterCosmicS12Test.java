package com.eu.evidence.rtdruid.test.modules.oil.codewriter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;



public class CodeWriterCosmicS12Test extends AbstractCodeWriterTest {
	
	
	@Test public void testCosmic_S12_1() {
		final String text_old =
		    	"CPU test_application {\n" +
		    	"\n" +
				"    APPMODE ModeIncrement;\n"+
				"    APPMODE ModeDecrement;\n"+
		    	"	OS EE {\n" +
		    	"		EE_OPT = \"DEBUG\";\n" +
		    	"		EE_OPT = \"NODEPS\";\n" +
		    	
		    	"		CFLAGS = \"-l +modf +fast +nowiden +warn +sprec #-v -wa921638 -wb1224\";\n" +
		    	"		ASFLAGS = \"-c -v -l \";\n" +
		    	"		LDFLAGS = \"-p -sa -m mapfile.map\";\n" + 

		    	"\n" +
		    	"		CPU_DATA = MC9S12XS {\n" +
		    	"			APP_SRC = \"main.c\";\n" +
		    	"			MULTI_STACK = FALSE;\n" +
		    	"		};\n" +
		    	"\n" +
		    	"		MCU_DATA = S12XS {\n" +
		    	"			MODEL = MC9S12XS128;\n" +
		    	"		};\n" +
		    	"\n" +
		    	"		BOARD_DATA = DEMO9S12XSFAME {\n" +
		    	"			OPTIONS = ALL;\n" +
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
		    	"//		ORTI_SECTIONS = ALL;\n" +
		    	"    };\n" +
		    	"\n" +
		    	"	/* this is the OIL part for the first task */\n" +
		    	"    TASK Task1 {\n" +
		    	"		PRIORITY = 0x01;   /* Low priority */\n" +
				"		AUTOSTART = TRUE { APPMODE=ModeIncrement; };	\n"+
		    	"		STACK = SHARED;\n" +
		    	"		ACTIVATION = 1;    /* only one pending activation */\n" +
		    	"	};	\n" +
		    	"	\n" +
		    	"	/* this is the OIL part for the second task */\n" +
		    	"    TASK Task2 {\n" +
		    	"		PRIORITY = 0x02;   /* High priority */\n" +
		    	"		SCHEDULE = FULL;\n" +
		    	"		AUTOSTART = TRUE;	\n" +
		    	"		STACK = SHARED;\n" +
		    	"    };\n" +
		    	"\n" +
		    	"    OS EE { KERNEL_TYPE = BCC1; }; \n" +
		    	"	TASK Task1 { SCHEDULE = FULL; };\n" +
		    	"	TASK Task2 { ACTIVATION = 1; };\n" +
		    	"		\n" +
		    	"};\n";
	    final String text_new =
	    	"CPU test_application {\n" +
	    	"\n" +
			"    APPMODE ModeIncrement;\n"+
			"    APPMODE ModeDecrement;\n"+
	    	"	OS EE {\n" +
	    	"		EE_OPT = \"DEBUG\";\n" +
	    	"		EE_OPT = \"NODEPS\";\n" +
	    	
	    	"		CFLAGS = \"-l +modf +fast +nowiden +warn +sprec #-v -wa921638 -wb1224\";\n" +
	    	"		ASFLAGS = \"-c -v -l \";\n" +
	    	"		LDFLAGS = \"-p -sa -m mapfile.map\";\n" + 

	    	"\n" +
	    	"		CPU_DATA = MC9S12 {\n" +
	    	"			APP_SRC = \"main.c\";\n" +
	    	"			MULTI_STACK = FALSE;\n" +
	    	"		};\n" +
	    	"\n" +
	    	"		MCU_DATA = MC9S12 {\n" +
	    	"			MODEL = MC9S12XS128;\n" +
	    	"		};\n" +
	    	"\n" +
	    	"		BOARD_DATA = DEMO9S12XSFAME {\n" +
	    	"			OPTIONS = ALL;\n" +
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
	    	"//		ORTI_SECTIONS = ALL;\n" +
	    	"    KERNEL_TYPE = BCC1; };\n" +
	    	"\n" +
	    	"	/* this is the OIL part for the first task */\n" +
	    	"    TASK Task1 {\n" +
	    	"		PRIORITY = 0x01;   /* Low priority */\n" +
			"		AUTOSTART = TRUE { APPMODE=ModeIncrement; };	\n"+
	    	"		STACK = SHARED;\n" +
	    	"		ACTIVATION = 1;    /* only one pending activation */\n" +
	    	"	};	\n" +
	    	"	\n" +
	    	"	/* this is the OIL part for the second task */\n" +
	    	"    TASK Task2 {\n" +
	    	"		PRIORITY = 0x02;   /* High priority */\n" +
	    	"		SCHEDULE = FULL;\n" +
	    	"		AUTOSTART = TRUE;	\n" +
	    	"		STACK = SHARED;\n" +
	    	"    };\n" +
	    	"\n" +
//	    	"    OS EE { KERNEL_TYPE = BCC1; }; \n" +
	    	"	TASK Task1 { SCHEDULE = FULL; };\n" +
	    	"	TASK Task2 { ACTIVATION = 1; };\n" +
	    	"		\n" +
	    	"};\n";


	    DefaultTestResult result_old = commonWriterTest(text_old, 1);
	    DefaultTestResult result_new = commonWriterTest(text_new, 1);
	    
	    assertEquals(1, result_old.buffers.length);
	    assertEquals(1, result_new.buffers.length);
	    assertEquals(result_new.buffers[0].toString(), result_old.buffers[0].toString());
	}

	
	@Test public void testCosmic_S12_2() {
		final String text_old =
				"CPU test_application {\n" +
				"\n" +
				"	OS EE {\n" +
				"		EE_OPT = \"DEBUG\";\n" +
				"		EE_OPT = \"NODEPS\";\n" +
				"\n" +
				"		CFLAGS = \"-l +modf +fast +nowiden +warn +sprec\";\n" +
				"		ASFLAGS = \"-c -v -l \";\n" +
				"		LDFLAGS = \"-p -sa -m mapfile.map\"; \n" +
				"\n" +
				"		CPU_DATA = MC9S12XS {\n" +
				"			APP_SRC = \"main.c\";\n" +
				"			MULTI_STACK = FALSE;\n" +
				"		};\n" +
				"		\n" +
				"		MCU_DATA = S12XS {\n" +
				"   			MODEL = CUSTOM{\n" +
				"    			MODEL = \"MC9S12XS128\";\n" +
				"    			LINKERSCRIPT = \"mc9s12xs128.lkf\";\n" +
				"    			INCLUDE_H = \"hs12xsregs.h\";\n" +
				"    			INCLUDE_C = \"vector_s12x.c\";\n" +
				"    			INCLUDE_S = \"crtsx.S\";\n" +
				"   			};\n" +
				"  		};\n" +
				"\n" +
				"		BOARD_DATA = DEMO9S12XSFAME {\n" +
				"			OPTIONS = ALL;\n" +
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
				"//		ORTI_SECTIONS = ALL;\n" +
				"    };\n" +
				"\n" +
				"	/* this is the OIL part for the first task */\n" +
				"    TASK Task1 {\n" +
				"		PRIORITY = 0x01;   /* Low priority */\n" +
				"		AUTOSTART = FALSE;\n" +
				"		STACK = SHARED;\n" +
				"		ACTIVATION = 1;    /* only one pending activation */\n" +
				"	};	\n" +
				"\n" +
				"    OS EE { KERNEL_TYPE = FP; }; 	\n" +
				"};";
	    final String text_new =
			"CPU test_application {\n" +
			"\n" +
			"	OS EE {\n" +
			"		EE_OPT = \"DEBUG\";\n" +
			"		EE_OPT = \"NODEPS\";\n" +
			"\n" +
			"		CFLAGS = \"-l +modf +fast +nowiden +warn +sprec\";\n" +
			"		ASFLAGS = \"-c -v -l \";\n" +
			"		LDFLAGS = \"-p -sa -m mapfile.map\"; \n" +
			"\n" +
			"		CPU_DATA = MC9S12 {\n" +
			"			APP_SRC = \"main.c\";\n" +
			"			MULTI_STACK = FALSE;\n" +
			"		};\n" +
			"		\n" +
			"		MCU_DATA = MC9S12 {\n" +
			"   			MODEL = CUSTOM{\n" +
			"    			MODEL = \"MC9S12XS128\";\n" +
			"    			LINKERSCRIPT = \"mc9s12xs128.lkf\";\n" +
			"    			INCLUDE_H = \"hs12xsregs.h\";\n" +
			"    			INCLUDE_C = \"vector_s12x.c\";\n" +
			"    			INCLUDE_S = \"crtsx.S\";\n" +
			"   			};\n" +
			"  		};\n" +
			"\n" +
			"		BOARD_DATA = DEMO9S12XSFAME {\n" +
			"			OPTIONS = ALL;\n" +
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
			"//		ORTI_SECTIONS = ALL;\n" +
			"    };\n" +
			"\n" +
			"	/* this is the OIL part for the first task */\n" +
			"    TASK Task1 {\n" +
			"		PRIORITY = 0x01;   /* Low priority */\n" +
			"		AUTOSTART = FALSE;\n" +
			"		STACK = SHARED;\n" +
			"		ACTIVATION = 1;    /* only one pending activation */\n" +
			"	};	\n" +
			"\n" +
			"    OS EE { KERNEL_TYPE = FP; }; 	\n" +
			"};";
	    DefaultTestResult result_old = commonWriterTest(text_old, 1);
	    DefaultTestResult result_new = commonWriterTest(text_new, 1);
	    
	    assertEquals(1, result_old.buffers.length);
	    assertEquals(1, result_new.buffers.length);
	    assertEquals(result_new.buffers[0].toString(), result_old.buffers[0].toString());
	}
	
	
	@Test public void testCosmic_S12_3() {
		final String text_old =
		    	"CPU test_application {\n" +
		    	"\n" +
				"    APPMODE ModeIncrement;\n"+
				"    APPMODE ModeDecrement;\n"+
		    	"	OS EE {\n" +
		    	"		EE_OPT = \"DEBUG\";\n" +
		    	"		EE_OPT = \"NODEPS\";\n" +
		    	
		    	"		CFLAGS = \"-l +modf +fast +nowiden +warn +sprec #-v -wa921638 -wb1224\";\n" +
		    	"		ASFLAGS = \"-c -v -l \";\n" +
		    	"		LDFLAGS = \"-p -sa -m mapfile.map\";\n" + 

		    	"\n" +
		    	"		CPU_DATA = MC9S12XS {\n" +
		    	"			APP_SRC = \"main.c\";\n" +
		    	"			MULTI_STACK = FALSE;\n" +
		    	"		};\n" +
		    	"\n" +
		    	"		MCU_DATA = S12XS {\n" +
		    	"			MODEL = MC9S12XS128;\n" +
		    	"			SERIAL = TRUE;\n" +
		    	"			TIMER = TRUE;\n" +
		    	"		};\n" +
		    	"\n" +
		    	"		BOARD_DATA = DEMO9S12XSFAME {\n" +
		    	"			OPTIONS = ALL;\n" +
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
		    	"//		ORTI_SECTIONS = ALL;\n" +
		    	"    };\n" +
		    	"\n" +
		    	"	/* this is the OIL part for the first task */\n" +
		    	"    TASK Task1 {\n" +
		    	"		PRIORITY = 0x01;   /* Low priority */\n" +
				"		AUTOSTART = TRUE { APPMODE=ModeIncrement; };	\n"+
		    	"		STACK = SHARED;\n" +
		    	"		ACTIVATION = 1;    /* only one pending activation */\n" +
		    	"	};	\n" +
		    	"	\n" +
		    	"	/* this is the OIL part for the second task */\n" +
		    	"    TASK Task2 {\n" +
		    	"		PRIORITY = 0x02;   /* High priority */\n" +
		    	"		SCHEDULE = FULL;\n" +
		    	"		AUTOSTART = FALSE;	\n" +
		    	"		STACK = SHARED;\n" +
		    	"    };\n" +
		    	"\n" +
		    	"    OS EE { KERNEL_TYPE = BCC1; }; \n" +
		    	"	TASK Task1 { SCHEDULE = FULL; };\n" +
		    	"	TASK Task2 { ACTIVATION = 1; };\n" +
		    	"		\n" +
		    	"};\n";
	    final String text_new =
	    	"CPU test_application {\n" +
	    	"\n" +
			"    APPMODE ModeIncrement;\n"+
			"    APPMODE ModeDecrement;\n"+
	    	"	OS EE {\n" +
	    	"		EE_OPT = \"DEBUG\";\n" +
	    	"		EE_OPT = \"NODEPS\";\n" +
	    	
	    	"		CFLAGS = \"-l +modf +fast +nowiden +warn +sprec #-v -wa921638 -wb1224\";\n" +
	    	"		ASFLAGS = \"-c -v -l \";\n" +
	    	"		LDFLAGS = \"-p -sa -m mapfile.map\";\n" + 

	    	"\n" +
	    	"		CPU_DATA = MC9S12 {\n" +
	    	"			APP_SRC = \"main.c\";\n" +
	    	"			MULTI_STACK = FALSE;\n" +
	    	"		};\n" +
	    	"\n" +
	    	"		MCU_DATA = MC9S12 {\n" +
	    	"			MODEL = MC9S12XS128;\n" +
	    	"			SERIAL = TRUE;\n" +
	    	"			TIMER = TRUE;\n" +
	    	"		};\n" +
	    	"\n" +
	    	"		BOARD_DATA = DEMO9S12XSFAME {\n" +
	    	"			OPTIONS = ALL;\n" +
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
	    	"//		ORTI_SECTIONS = ALL;\n" +
	    	"    };\n" +
	    	"\n" +
	    	"	/* this is the OIL part for the first task */\n" +
	    	"    TASK Task1 {\n" +
	    	"		PRIORITY = 0x01;   /* Low priority */\n" +
			"		AUTOSTART = TRUE { APPMODE=ModeIncrement; };	\n"+
	    	"		STACK = SHARED;\n" +
	    	"		ACTIVATION = 1;    /* only one pending activation */\n" +
	    	"	};	\n" +
	    	"	\n" +
	    	"	/* this is the OIL part for the second task */\n" +
	    	"    TASK Task2 {\n" +
	    	"		PRIORITY = 0x02;   /* High priority */\n" +
	    	"		SCHEDULE = FULL;\n" +
	    	"		AUTOSTART = FALSE;	\n" +
	    	"		STACK = SHARED;\n" +
	    	"    };\n" +
	    	"\n" +
	    	"    OS EE { KERNEL_TYPE = BCC1; }; \n" +
	    	"	TASK Task1 { SCHEDULE = FULL; };\n" +
	    	"	TASK Task2 { ACTIVATION = 1; };\n" +
	    	"		\n" +
	    	"};\n";

	    DefaultTestResult result_old = commonWriterTest(text_old, 1);
	    DefaultTestResult result_new = commonWriterTest(text_new, 1);
	    
	    assertEquals(1, result_old.buffers.length);
	    assertEquals(1, result_new.buffers.length);
	    assertEquals(result_new.buffers[0].toString(), result_old.buffers[0].toString());
	}

	@Test public void testCosmic_S12_4() {
	    final String text_old =
			"CPU test_application {\n" +
			"\n" +
			"	OS EE {\n" +
			"		EE_OPT = \"DEBUG\";\n" +
			"		EE_OPT = \"NODEPS\";\n" +
			"		EE_OPT = \"__SEM__\";\n" +
			"\n" +
			"		CFLAGS = \"-l +modf +fast +nowiden +warn +sprec\";\n" +
			"		ASFLAGS = \"-c -v -l \";\n" +
			"		LDFLAGS = \"-p -sa -m mapfile.map\"; \n" +
			"\n" +
			"		CPU_DATA = MC9S12XS {\n" +
			"			APP_SRC = \"main.c\";\n" +
			"			MULTI_STACK = TRUE {\n" +
			"				IRQ_STACK = TRUE {\n" +
			"					SYS_SIZE=512;\n" +
			"				};\n" +
			"			};\n" +
			"		};\n" +
			"		\n" +
			"		MCU_DATA = S12XS {\n" +
			"   			MODEL = CUSTOM{\n" +
			"    			MODEL = \"MC9S12XS128\";\n" +
			"    			LINKERSCRIPT = \"mc9s12xs128.lkf\";\n" +
			"    			INCLUDE_H = \"hs12xsregs.h\";\n" +
			"    			INCLUDE_C = \"vector_s12x.c\";\n" +
			"    			INCLUDE_S = \"crtsx.S\";\n" +
			"   			};\n" +
			"   			TIMER = TRUE;\n" +
			"  		};\n" +
			"\n" +
			"		BOARD_DATA = DEMO9S12XSFAME {\n" +
			"				OPTIONS = ALL;\n" +
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
			"//		ORTI_SECTIONS = ALL;\n" +
			"    };\n" +
			"\n" +
			"	/* this is the OIL part for the task displaying the christmas tree */\n" +
			"    TASK Task1 {\n" +
			"		PRIORITY = 0x01;   /* Low priority */\n" +
			"		AUTOSTART = FALSE;\n" +
			"		STACK = PRIVATE {\n" +
			"			SYS_SIZE = 512;\n" +
			"		};\n" +
			"		ACTIVATION = 1;    /* only one pending activation */\n" +
			"		SCHEDULE = FULL;\n" +
			"	};	\n" +
			"	\n" +
			"	/* this is the OIL part for the task activated by the button press */\n" +
			"    TASK Task2 {\n" +
			"		PRIORITY = 0x02;   /* High priority */\n" +
			"		SCHEDULE = FULL;\n" +
			"		AUTOSTART = FALSE;	\n" +
			"		STACK = PRIVATE {\n" +
			"			SYS_SIZE = 512;\n" +
			"		};\n" +
			"		ACTIVATION = 1;\n" +
			"    };\n" +
			"\n" +
			"    OS EE { \n" +
			"    	KERNEL_TYPE = FP{\n" +
			"    		NESTED_IRQ = TRUE;\n" +
			"   		}; \n" +
			"   	}; 	 \n" +
			"};";

	    final String text_new =
			"CPU test_application {\n" +
			"\n" +
			"	OS EE {\n" +
			"		EE_OPT = \"DEBUG\";\n" +
			"		EE_OPT = \"NODEPS\";\n" +
			"		EE_OPT = \"__SEM__\";\n" +
			"\n" +
			"		CFLAGS = \"-l +modf +fast +nowiden +warn +sprec\";\n" +
			"		ASFLAGS = \"-c -v -l \";\n" +
			"		LDFLAGS = \"-p -sa -m mapfile.map\"; \n" +
			"\n" +
			"		CPU_DATA = MC9S12 {\n" +
			"			APP_SRC = \"main.c\";\n" +
			"			MULTI_STACK = TRUE {\n" +
			"				IRQ_STACK = TRUE {\n" +
			"					SYS_SIZE=512;\n" +
			"				};\n" +
			"			};\n" +
			"		};\n" +
			"		\n" +
			"		MCU_DATA = MC9S12 {\n" +
			"   			MODEL = CUSTOM{\n" +
			"    			MODEL = \"MC9S12XS128\";\n" +
			"    			LINKERSCRIPT = \"mc9s12xs128.lkf\";\n" +
			"    			INCLUDE_H = \"hs12xsregs.h\";\n" +
			"    			INCLUDE_C = \"vector_s12x.c\";\n" +
			"    			INCLUDE_S = \"crtsx.S\";\n" +
			"   			};\n" +
			"   			TIMER = TRUE;\n" +
			"  		};\n" +
			"\n" +
			"		BOARD_DATA = DEMO9S12XSFAME {\n" +
			"				OPTIONS = ALL;\n" +
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
			"//		ORTI_SECTIONS = ALL;\n" +
			"    };\n" +
			"\n" +
			"	/* this is the OIL part for the task displaying the christmas tree */\n" +
			"    TASK Task1 {\n" +
			"		PRIORITY = 0x01;   /* Low priority */\n" +
			"		AUTOSTART = FALSE;\n" +
			"		STACK = PRIVATE {\n" +
			"			SYS_SIZE = 512;\n" +
			"		};\n" +
			"		ACTIVATION = 1;    /* only one pending activation */\n" +
			"		SCHEDULE = FULL;\n" +
			"	};	\n" +
			"	\n" +
			"	/* this is the OIL part for the task activated by the button press */\n" +
			"    TASK Task2 {\n" +
			"		PRIORITY = 0x02;   /* High priority */\n" +
			"		SCHEDULE = FULL;\n" +
			"		AUTOSTART = FALSE;	\n" +
			"		STACK = PRIVATE {\n" +
			"			SYS_SIZE = 512;\n" +
			"		};\n" +
			"		ACTIVATION = 1;\n" +
			"    };\n" +
			"\n" +
			"    OS EE { \n" +
			"    	KERNEL_TYPE = FP{\n" +
			"    		NESTED_IRQ = TRUE;\n" +
			"   		}; \n" +
			"   	}; 	 \n" +
			"};";
	    DefaultTestResult result_old = commonWriterTest(text_old, 1);
	    DefaultTestResult result_new = commonWriterTest(text_new, 1);
	    
	    assertEquals(1, result_old.buffers.length);
	    assertEquals(1, result_new.buffers.length);
	    assertEquals(result_new.buffers[0].toString(), result_old.buffers[0].toString());
	}
	
	
	@Test public void testCosmic_S12_5() {
		final String text_old =
				"CPU test_application {\n"+
				"\n"+
				"	OS EE {\n"+
				"		EE_OPT = \"DEBUG\";\n"+
				"\n"+
				"		CPU_DATA = MC9S12XS {\n" +
				"			APP_SRC = \"main.c\";\n" +
				"			MULTI_STACK = TRUE {\n" +
				"				IRQ_STACK = TRUE {\n" +
				"					SYS_SIZE=512;\n" +
				"				};\n" +
				"			};\n" +
				"		};\n" +
				"		\n" +
				"		MCU_DATA = S12XS {\n" +
				"   			MODEL = CUSTOM{\n" +
				"    			MODEL = \"MC9S12XS128\";\n" +
				"    			LINKERSCRIPT = \"mc9s12xs128.lkf\";\n" +
				"    			INCLUDE_H = \"hs12xsregs.h\";\n" +
				"    			INCLUDE_C = \"vector_s12x.c\";\n" +
				"    			INCLUDE_S = \"crtsx.S\";\n" +
				"   			};\n" +
				"   			TIMER = TRUE;\n" +
				"  		};\n" +
				"\n" +
				"		BOARD_DATA = DEMO9S12XSFAME {\n" +
				"				OPTIONS = ALL;\n" +
				"		};\n" +
				"\n"+
				"		STATUS = EXTENDED;\n"+
				"		STARTUPHOOK = TRUE; // this demo is using the StartupHook!\n"+
				"		ERRORHOOK = TRUE;\n"+
				"		SHUTDOWNHOOK = FALSE;\n"+
				"		PRETASKHOOK = FALSE;\n"+
				"		POSTTASKHOOK = FALSE;\n"+
				"		USEGETSERVICEID = FALSE;\n"+
				"		USEPARAMETERACCESS = FALSE;\n"+
				"		USERESSCHEDULER = TRUE;\n"+
				"\n"+
				"        KERNEL_TYPE = ECC2;\n"+
				"		\n"+
				"		/* This generates the ORTI File used by lauterbach Trace32! */\n"+
				"		//ORTI_SECTIONS = ALL;\n"+
				"    };\n"+
				"\n"+
				"    TASK Task1 {\n"+
				"		PRIORITY = 0x01;\n"+
				"		ACTIVATION = 1;\n"+
				"		SCHEDULE = FULL;\n"+
				"		AUTOSTART = TRUE;\n"+
				"		STACK = PRIVATE {\n"+
				"			SYS_SIZE = 1024;\n"+
				"		};\n"+
				"		EVENT = TimerEvent;\n"+
				"		EVENT = ButtonEvent;\n"+
				"    };\n"+
				"\n"+
				"    TASK Task2 {\n"+
				"		PRIORITY = 0x02;\n"+
				"		ACTIVATION = 1;\n"+
				"		SCHEDULE = FULL;\n"+
				"		AUTOSTART = FALSE;\n"+
				"		STACK = SHARED;\n"+
				"    };\n"+
				"\n"+
				"    EVENT TimerEvent  { MASK = AUTO; };\n"+
				"    EVENT ButtonEvent { MASK = AUTO; };\n"+
				"\n"+
				"    COUNTER Counter1 {\n"+
				"        MINCYCLE = 2;\n"+
				"        MAXALLOWEDVALUE = 0xFFFF ;\n"+
				"        TICKSPERBASE = 1;\n"+
				"    };\n"+
				"\n"+
				"    ALARM AlarmTask1 {\n"+
				"                COUNTER = Counter1;\n"+
				"                ACTION = SETEVENT { TASK = Task1; EVENT = TimerEvent; };\n"+
				"                AUTOSTART = TRUE { ALARMTIME = 250; CYCLETIME = 500; };\n"+
				"    };\n"+
				"\n"+
				"    ALARM AlarmTask2 {\n"+
				"                COUNTER = Counter1;\n"+
				"                ACTION = ACTIVATETASK { TASK = Task2; };\n"+
				"                AUTOSTART = FALSE;\n"+
				"    };\n"+
				"};";
	    final String text_new =
			"CPU test_application {\n"+
			"\n"+
			"	OS EE {\n"+
			"		EE_OPT = \"DEBUG\";\n"+
			"\n"+
			"		CPU_DATA = MC9S12 {\n" +
			"			APP_SRC = \"main.c\";\n" +
			"			MULTI_STACK = TRUE {\n" +
			"				IRQ_STACK = TRUE {\n" +
			"					SYS_SIZE=512;\n" +
			"				};\n" +
			"			};\n" +
			"		};\n" +
			"		\n" +
			"		MCU_DATA = MC9S12 {\n" +
			"   			MODEL = CUSTOM{\n" +
			"    			MODEL = \"MC9S12XS128\";\n" +
			"    			LINKERSCRIPT = \"mc9s12xs128.lkf\";\n" +
			"    			INCLUDE_H = \"hs12xsregs.h\";\n" +
			"    			INCLUDE_C = \"vector_s12x.c\";\n" +
			"    			INCLUDE_S = \"crtsx.S\";\n" +
			"   			};\n" +
			"   			TIMER = TRUE;\n" +
			"  		};\n" +
			"\n" +
			"		BOARD_DATA = DEMO9S12XSFAME {\n" +
			"				OPTIONS = ALL;\n" +
			"		};\n" +
			"\n"+
			"		STATUS = EXTENDED;\n"+
			"		STARTUPHOOK = TRUE; // this demo is using the StartupHook!\n"+
			"		ERRORHOOK = TRUE;\n"+
			"		SHUTDOWNHOOK = FALSE;\n"+
			"		PRETASKHOOK = FALSE;\n"+
			"		POSTTASKHOOK = FALSE;\n"+
			"		USEGETSERVICEID = FALSE;\n"+
			"		USEPARAMETERACCESS = FALSE;\n"+
			"		USERESSCHEDULER = TRUE;\n"+
			"\n"+
			"        KERNEL_TYPE = ECC2;\n"+
			"		\n"+
			"		/* This generates the ORTI File used by lauterbach Trace32! */\n"+
			"		//ORTI_SECTIONS = ALL;\n"+
			"    };\n"+
			"\n"+
			"    TASK Task1 {\n"+
			"		PRIORITY = 0x01;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"		AUTOSTART = TRUE;\n"+
			"		STACK = PRIVATE {\n"+
			"			SYS_SIZE = 1024;\n"+
			"		};\n"+
			"		EVENT = TimerEvent;\n"+
			"		EVENT = ButtonEvent;\n"+
			"    };\n"+
			"\n"+
			"    TASK Task2 {\n"+
			"		PRIORITY = 0x02;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"    };\n"+
			"\n"+
			"    EVENT TimerEvent  { MASK = AUTO; };\n"+
			"    EVENT ButtonEvent { MASK = AUTO; };\n"+
			"\n"+
			"    COUNTER Counter1 {\n"+
			"        MINCYCLE = 2;\n"+
			"        MAXALLOWEDVALUE = 0xFFFF ;\n"+
			"        TICKSPERBASE = 1;\n"+
			"    };\n"+
			"\n"+
			"    ALARM AlarmTask1 {\n"+
			"                COUNTER = Counter1;\n"+
			"                ACTION = SETEVENT { TASK = Task1; EVENT = TimerEvent; };\n"+
			"                AUTOSTART = TRUE { ALARMTIME = 250; CYCLETIME = 500; };\n"+
			"    };\n"+
			"\n"+
			"    ALARM AlarmTask2 {\n"+
			"                COUNTER = Counter1;\n"+
			"                ACTION = ACTIVATETASK { TASK = Task2; };\n"+
			"                AUTOSTART = FALSE;\n"+
			"    };\n"+
			"};";
	    DefaultTestResult result_old = commonWriterTest(text_old, 1);
	    DefaultTestResult result_new = commonWriterTest(text_new, 1);
	    
	    assertEquals(1, result_old.buffers.length);
	    assertEquals(1, result_new.buffers.length);
	    assertEquals(result_new.buffers[0].toString(), result_old.buffers[0].toString());
	}
	
	
	@Test public void testCosmic_S12_6() {
		final String text_old =
				"CPU test_application {\n"+
				"\n"+
				"	OS EE {\n"+
				"		EE_OPT = \"DEBUG\";\n"+
				"\n"+
				"		CPU_DATA = MC9S12XS {\n" +
				"			APP_SRC = \"main.c\";\n" +
				"			MULTI_STACK = TRUE {\n" +
				"				IRQ_STACK = TRUE {\n" +
				"					SYS_SIZE=512;\n" +
				"				};\n" +
				"			};\n" +
				"		};\n" +
				"		\n" +
				"		MCU_DATA = S12XS {\n" +
				"   			MODEL = CUSTOM{\n" +
				"    			MODEL = \"MC9S12XS128\";\n" +
				"    			LINKERSCRIPT = \"mc9s12xs128.lkf\";\n" +
				"    			INCLUDE_H = \"hs12xsregs.h\";\n" +
				"    			INCLUDE_C = \"vector_s12x.c\";\n" +
				"    			INCLUDE_S = \"crtsx.S\";\n" +
				"   			};\n" +
				"   			TIMER = TRUE;\n" +
				"  		};\n" +
				"\n" +
				"		BOARD_DATA = DEMO9S12XSFAME {\n" +
				"				OPTIONS = ALL;\n" +
				"		};\n" +
				"\n"+
				"		STATUS = EXTENDED;\n"+
				"		STARTUPHOOK = TRUE; // this demo is using the StartupHook!\n"+
				"		ERRORHOOK = TRUE;\n"+
				"		SHUTDOWNHOOK = FALSE;\n"+
				"		PRETASKHOOK = FALSE;\n"+
				"		POSTTASKHOOK = FALSE;\n"+
				"		USEGETSERVICEID = FALSE;\n"+
				"		USEPARAMETERACCESS = FALSE;\n"+
				"		USERESSCHEDULER = TRUE;\n"+
				"\n"+
				"        KERNEL_TYPE = ECC2;\n"+
				"		\n"+
				"		/* This generates the ORTI File used by lauterbach Trace32! */\n"+
				"		//ORTI_SECTIONS = ALL;\n"+
				"    };\n"+
				"\n"+
				"    TASK Task1 {\n"+
				"		PRIORITY = 0x01;\n"+
				"		ACTIVATION = 1;\n"+
				"		SCHEDULE = FULL;\n"+
				"		AUTOSTART = TRUE;\n"+
				"		STACK = PRIVATE {\n"+
				"			SYS_SIZE = 1024;\n"+
				"		};\n"+
				"		EVENT = TimerEvent;\n"+
				"		EVENT = ButtonEvent;\n"+
				"    };\n"+
				"\n"+
				"    TASK Task2 {\n"+
				"		PRIORITY = 0x02;\n"+
				"		ACTIVATION = 1;\n"+
				"		SCHEDULE = FULL;\n"+
				"		AUTOSTART = FALSE;\n"+
				"		STACK = SHARED;\n"+
				"    };\n"+
				"\n"+
				"    EVENT TimerEvent  { MASK = AUTO; };\n"+
				"    EVENT ButtonEvent { MASK = AUTO; };\n"+
				"\n"+
				"    COUNTER Counter1 {\n"+
				"        MINCYCLE = 2;\n"+
				"        MAXALLOWEDVALUE = 0xFFFF ;\n"+
				"        TICKSPERBASE = 1;\n"+
				"    };\n"+
				"\n"+
				"    ALARM AlarmTask1 {\n"+
				"                COUNTER = Counter1;\n"+
				"                ACTION = SETEVENT { TASK = Task1; EVENT = TimerEvent; };\n"+
				"                AUTOSTART = FALSE;\n"+
				"    };\n"+
				"\n"+
				"    ALARM AlarmTask2 {\n"+
				"                COUNTER = Counter1;\n"+
				"                ACTION = ACTIVATETASK { TASK = Task2; };\n"+
//				"                AUTOSTART = FALSE;\n"+
				"    };\n"+
				"};";
	    final String text_new =
			"CPU test_application {\n"+
			"\n"+
			"	OS EE {\n"+
			"		EE_OPT = \"DEBUG\";\n"+
			"\n"+
			"		CPU_DATA = MC9S12 {\n" +
			"			APP_SRC = \"main.c\";\n" +
			"			MULTI_STACK = TRUE {\n" +
			"				IRQ_STACK = TRUE {\n" +
			"					SYS_SIZE=512;\n" +
			"				};\n" +
			"			};\n" +
			"		};\n" +
			"		\n" +
			"		MCU_DATA = MC9S12 {\n" +
			"   			MODEL = CUSTOM{\n" +
			"    			MODEL = \"MC9S12XS128\";\n" +
			"    			LINKERSCRIPT = \"mc9s12xs128.lkf\";\n" +
			"    			INCLUDE_H = \"hs12xsregs.h\";\n" +
			"    			INCLUDE_C = \"vector_s12x.c\";\n" +
			"    			INCLUDE_S = \"crtsx.S\";\n" +
			"   			};\n" +
			"   			TIMER = TRUE;\n" +
			"  		};\n" +
			"\n" +
			"		BOARD_DATA = DEMO9S12XSFAME {\n" +
			"				OPTIONS = ALL;\n" +
			"		};\n" +
			"\n"+
			"		STATUS = EXTENDED;\n"+
			"		STARTUPHOOK = TRUE; // this demo is using the StartupHook!\n"+
			"		ERRORHOOK = TRUE;\n"+
			"		SHUTDOWNHOOK = FALSE;\n"+
			"		PRETASKHOOK = FALSE;\n"+
			"		POSTTASKHOOK = FALSE;\n"+
			"		USEGETSERVICEID = FALSE;\n"+
			"		USEPARAMETERACCESS = FALSE;\n"+
			"		USERESSCHEDULER = TRUE;\n"+
			"\n"+
			"        KERNEL_TYPE = ECC2;\n"+
			"		\n"+
			"		/* This generates the ORTI File used by lauterbach Trace32! */\n"+
			"		//ORTI_SECTIONS = ALL;\n"+
			"    };\n"+
			"\n"+
			"    TASK Task1 {\n"+
			"		PRIORITY = 0x01;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"		AUTOSTART = TRUE;\n"+
			"		STACK = PRIVATE {\n"+
			"			SYS_SIZE = 1024;\n"+
			"		};\n"+
			"		EVENT = TimerEvent;\n"+
			"		EVENT = ButtonEvent;\n"+
			"    };\n"+
			"\n"+
			"    TASK Task2 {\n"+
			"		PRIORITY = 0x02;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"    };\n"+
			"\n"+
			"    EVENT TimerEvent  { MASK = AUTO; };\n"+
			"    EVENT ButtonEvent { MASK = AUTO; };\n"+
			"\n"+
			"    COUNTER Counter1 {\n"+
			"        MINCYCLE = 2;\n"+
			"        MAXALLOWEDVALUE = 0xFFFF ;\n"+
			"        TICKSPERBASE = 1;\n"+
			"    };\n"+
			"\n"+
			"    ALARM AlarmTask1 {\n"+
			"                COUNTER = Counter1;\n"+
			"                ACTION = SETEVENT { TASK = Task1; EVENT = TimerEvent; };\n"+
			"                AUTOSTART = FALSE;\n"+
			"    };\n"+
			"\n"+
			"    ALARM AlarmTask2 {\n"+
			"                COUNTER = Counter1;\n"+
			"                ACTION = ACTIVATETASK { TASK = Task2; };\n"+
//			"                AUTOSTART = FALSE;\n"+
			"    };\n"+
			"};";
	    DefaultTestResult result_old = commonWriterTest(text_old, 1);
	    DefaultTestResult result_new = commonWriterTest(text_new, 1);
	    
	    assertEquals(1, result_old.buffers.length);
	    assertEquals(1, result_new.buffers.length);
	    assertEquals(result_new.buffers[0].toString(), result_old.buffers[0].toString());
	}

	@Test
	public void testCosmic_S12g_6() {
		
	    final String text_new =
			"CPU test_application {\n"+
			"\n"+
			"	OS EE {\n"+
			"		EE_OPT = \"DEBUG\";\n"+
			"		EE_OPT = \"__CODEWARRIOR__\";\n"+
			"\n"+
			"		CPU_DATA = MC9S12 {\n" +
			"			APP_SRC = \"main.c\";\n" +
			"			MULTI_STACK = TRUE {\n" +
			"				IRQ_STACK = TRUE {\n" +
			"					SYS_SIZE=512;\n" +
			"				};\n" +
			"			};\n" +
			"		};\n" +
			"		\n" +
			"		MCU_DATA = MC9S12 {\n" +
			"   			MODEL = MC9S12G128;\n" +
			"   			TIMER = TRUE;\n" +
			"  		};\n" +
			"\n" +
			"		BOARD_DATA = TWRS12G128 {\n" +
			"				OPTIONS = ALL;\n" +
			"		};\n" +
			"\n"+
			"		STATUS = EXTENDED;\n"+
			"		STARTUPHOOK = TRUE; // this demo is using the StartupHook!\n"+
			"		ERRORHOOK = TRUE;\n"+
			"		SHUTDOWNHOOK = FALSE;\n"+
			"		PRETASKHOOK = FALSE;\n"+
			"		POSTTASKHOOK = FALSE;\n"+
			"		USEGETSERVICEID = FALSE;\n"+
			"		USEPARAMETERACCESS = FALSE;\n"+
			"		USERESSCHEDULER = TRUE;\n"+
			"\n"+
			"        KERNEL_TYPE = ECC2;\n"+
			"		\n"+
			"		/* This generates the ORTI File used by lauterbach Trace32! */\n"+
			"		//ORTI_SECTIONS = ALL;\n"+
			"    };\n"+
			"\n"+
			"    TASK Task1 {\n"+
			"		PRIORITY = 0x01;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"		AUTOSTART = TRUE;\n"+
			"		STACK = PRIVATE {\n"+
			"			SYS_SIZE = 1024;\n"+
			"		};\n"+
			"		EVENT = TimerEvent;\n"+
			"		EVENT = ButtonEvent;\n"+
			"    };\n"+
			"\n"+
			"    TASK Task2 {\n"+
			"		PRIORITY = 0x02;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"    };\n"+
			"\n"+
			"    EVENT TimerEvent  { MASK = AUTO; };\n"+
			"    EVENT ButtonEvent { MASK = AUTO; };\n"+
			"\n"+
			"    COUNTER Counter1 {\n"+
			"        MINCYCLE = 2;\n"+
			"        MAXALLOWEDVALUE = 0xFFFF ;\n"+
			"        TICKSPERBASE = 1;\n"+
			"    };\n"+
			"\n"+
			"    ALARM AlarmTask1 {\n"+
			"                COUNTER = Counter1;\n"+
			"                ACTION = SETEVENT { TASK = Task1; EVENT = TimerEvent; };\n"+
			"                AUTOSTART = FALSE;\n"+
			"    };\n"+
			"\n"+
			"    ALARM AlarmTask2 {\n"+
			"                COUNTER = Counter1;\n"+
			"                ACTION = ACTIVATETASK { TASK = Task2; };\n"+
//			"                AUTOSTART = FALSE;\n"+
			"    };\n"+
			"};";
	    commonWriterTest(text_new, 1);
	}

	@Test
	public void testCosmic_S12_autostart_false() {
		
	    final String text_new =
			"CPU test_application {\n"+
			"\n"+
			"	OS EE {\n"+
			"		EE_OPT = \"DEBUG\";\n"+
			"		EE_OPT = \"__CODEWARRIOR__\";\n"+
			"\n"+
			"		CPU_DATA = MC9S12 {\n" +
			"			APP_SRC = \"main.c\";\n" +
			"			MULTI_STACK = TRUE {\n" +
			"				IRQ_STACK = TRUE {\n" +
			"					SYS_SIZE=512;\n" +
			"				};\n" +
			"			};\n" +
			"		};\n" +
			"		\n" +
			"		MCU_DATA = MC9S12 {\n" +
			"   			MODEL = MC9S12G128;\n" +
			"   			TIMER = TRUE;\n" +
			"  		};\n" +
			"\n" +
			"		BOARD_DATA = TWRS12G128 {\n" +
			"				OPTIONS = ALL;\n" +
			"		};\n" +
			"\n"+
			"		STATUS = EXTENDED;\n"+
			"		STARTUPHOOK = TRUE; // this demo is using the StartupHook!\n"+
			"		ERRORHOOK = TRUE;\n"+
			"		SHUTDOWNHOOK = FALSE;\n"+
			"		PRETASKHOOK = FALSE;\n"+
			"		POSTTASKHOOK = FALSE;\n"+
			"		USEGETSERVICEID = FALSE;\n"+
			"		USEPARAMETERACCESS = FALSE;\n"+
			"		USERESSCHEDULER = TRUE;\n"+
			"\n"+
			"        KERNEL_TYPE = ECC2;\n"+
			"		\n"+
			"		/* This generates the ORTI File used by lauterbach Trace32! */\n"+
			"		//ORTI_SECTIONS = ALL;\n"+
			"    };\n"+
			"\n"+
			"    TASK Task1 {\n"+
			"		PRIORITY = 0x01;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"		AUTOSTART = TRUE;\n"+
			"		STACK = PRIVATE {\n"+
			"			SYS_SIZE = 1024;\n"+
			"		};\n"+
			"		EVENT = TimerEvent;\n"+
			"		EVENT = ButtonEvent;\n"+
			"    };\n"+
			"\n"+
			"    TASK Task2 {\n"+
			"		PRIORITY = 0x02;\n"+
			"		ACTIVATION = 1;\n"+
			"		SCHEDULE = FULL;\n"+
			"		AUTOSTART = FALSE;\n"+
			"		STACK = SHARED;\n"+
			"    };\n"+
			"\n"+
			"    EVENT TimerEvent  { MASK = AUTO; };\n"+
			"    EVENT ButtonEvent { MASK = AUTO; };\n"+
			"\n"+
			"    COUNTER Counter1 {\n"+
			"        MINCYCLE = 2;\n"+
			"        MAXALLOWEDVALUE = 0xFFFF ;\n"+
			"        TICKSPERBASE = 1;\n"+
			"    };\n"+
			"\n"+
			"    ALARM AlarmTask1 {\n"+
			"                COUNTER = Counter1;\n"+
			"                ACTION = SETEVENT { TASK = Task1; EVENT = TimerEvent; };\n"+
			"                AUTOSTART = FALSE;\n"+
			"    };\n"+
			"\n"+
			"    ALARM AlarmTask2 {\n"+
			"                COUNTER = Counter1;\n"+
			"                ACTION = ACTIVATETASK { TASK = Task2; };\n"+
			"                AUTOSTART = FALSE { ALARMTIME = 55; CYCLETIME = 66; };\n"+
			"    };\n"+
			"};";
	    
	    boolean ok = false;
	    try {
	    	commonWriterTest(text_new, 1);
	    } catch (Throwable e) {
	    	ok = true;
	    }
	    assertTrue(ok);
	}

}






