package com.eu.evidence.rtdruid.test.modules.oil.codewriter;

import org.junit.Test;



public class CodeWriterNiosIITest extends AbstractCodeWriterTest {
	

	
	
	@Test public void testTaskAutostart() {
	    final String text = 
			"	    CPU test_application {\n" +
			"\n" +
			"	        OS EE {\n" +
			"	                CFLAGS = \"-DALT_DEBUG -O0 -g\";\n" +
			"	                CFLAGS = \"-Wall\";\n" +
			"	                ASFLAGS = \"-g\";\n" +
			"	                LDFLAGS = \"-Wl,-Map -Wl,project.map\";\n" +
			"	                LDDEPS = \"\\\\\";\n" +
			"	                LIBS = \"-lm\";\n" +
			"	                NIOS2_SYS_CONFIG = \"Debug\";\n" +
			"	                NIOS2_APP_CONFIG = \"Debug\";\n" +
			"	                NIOS2_DO_MAKE_OBJDUMP = TRUE;\n" +
			"                   MASTER_CPU = \"cpu1\";\n" +
			"		NIOS2_PTF_FILE = \"C:/altera/81/nios2eds/examples/verilog/niosII_stratixII_2s60_RoHS/frsh_small/NiosII_stratixII_2s60_RoHS_small_sopc.ptf\";\n" +
			"\n" +
			"	                CPU_DATA = NIOSII {\n" +
			"	                        ID = \"cpu1\";\n" +
			"	                        MULTI_STACK = FALSE;\n" +
			"	                        STACK_TOP = \"__alt_stack_pointer\";\n" +
			"	                        SYS_SIZE = 0x1000; \n" +
			"	                        SYSTEM_LIBRARY_NAME = \"standard_syslib\";\n" +
			"	                        SYSTEM_LIBRARY_PATH = \"C:/altera/kits/nios2_51/examples/verilog/niosII_stratix_1s40/standard/software/standard_syslib\";\n" +
			"\n" +
			"	                        APP_SRC = \"code.c\";\n" +
			"	                };\n" +
			"	          \n" +
			"	                STATUS = EXTENDED;\n" +
			"	                STARTUPHOOK = FALSE;\n" +
			"	                ERRORHOOK = FALSE;\n" +
			"	                SHUTDOWNHOOK = FALSE;\n" +
			"	                PRETASKHOOK = FALSE;\n" +
			"	                POSTTASKHOOK = FALSE;\n" +
			"	                USEGETSERVICEID = FALSE;\n" +
			"	                USEPARAMETERACCESS = FALSE;\n" +
			"	                USERESSCHEDULER = TRUE;\n" +
			"\n" +
			"	        KERNEL_TYPE = BCC1;\n" +
			"\n" +
			"	                ORTI_SECTIONS = ALL;\n" +
			"	    };\n" +
			"\n" +
			"	    APPMODE ModeIncrement;\n" +
			"	    APPMODE ModeDecrement;\n" +
			"\n" +
			"	    TASK LowTask {\n" +
			"                   CPU_ID = \"cpu1\";\n" +
			"	                PRIORITY = 0x01;\n" +
			"	                ACTIVATION = 1;\n" +
			"	                SCHEDULE = FULL;\n" +
			"	                AUTOSTART = FALSE;\n" +
			"	                STACK = SHARED;\n" +
			"	                RESOURCE = Resource;\n" +
			"	    };\n" +
			"\n" +
			"	    TASK HighTask {\n" +
			"                   CPU_ID = \"cpu1\";\n" +
			"	                PRIORITY = 0x02;\n" +
			"	                ACTIVATION = 1;\n" +
			"	                SCHEDULE = FULL;\n" +
			"	                AUTOSTART = TRUE { APPMODE=ModeIncrement; };  \n" +
			"	                STACK = SHARED;\n" +
			"	                RESOURCE = Resource;\n" +
			"	    };\n" +
			"\n" +
			"	    RESOURCE Resource { RESOURCEPROPERTY = STANDARD; };\n" +
			"	};\n";
		commonWriterTest(text, 1);
	}
	
	@Test public void testOrtiIRQ_STACK() {
	    final String text ="CPU test_application {\n" +
			"	OS EE {\n" +
			"		CFLAGS = \"-DALT_DEBUG -O0 -g\";\n" +
			"		CFLAGS = \"-Wall\";\n" +
			"		ASFLAGS = \"-g\";\n" +
			"		LDFLAGS = \"-Wl,-Map -Wl,project.map\";\n" +
			"		LDDEPS = \"\\\\\";\n" +
			"		LIBS = \"-lm\";\n" +
			"		NIOS2_SYS_CONFIG = \"Debug\";\n" +
			"		NIOS2_APP_CONFIG = \"Debug\";\n" +
			"		NIOS2_DO_MAKE_OBJDUMP = TRUE;\n" +
			"		NIOS2_PTF_FILE = \"C:/altera/81/nios2eds/examples/verilog/niosII_stratixII_2s60_RoHS/frsh_small/NiosII_stratixII_2s60_RoHS_small_sopc.ptf\";\n" +
			"		\n" +
			"		CPU_DATA = NIOSII {\n" +
			"			MULTI_STACK = TRUE { \n" +
			"				IRQ_STACK = TRUE { \n" +
			"					SYS_SIZE = 0x200; \n" +
			"				}; \n" +
			"			};\n" +
			"			STACK_TOP = \"__alt_stack_pointer\";\n" +
			"			SYS_SIZE = 0x2000; \n" +
			"			SYSTEM_LIBRARY_NAME = \"standard_syslib\";\n" +
			"			SYSTEM_LIBRARY_PATH = \"C:/altera/kits/nios2_51/examples/verilog/niosII_stratix_1s40/standard/software/standard_syslib\";\n" +
			"			\n" +
			"			APP_SRC = \"code.c\";\n" +
			"		};\n" +
			"		  \n" +
			"		STATUS = EXTENDED;\n" +
			"		STARTUPHOOK = FALSE;\n" +
			"		ERRORHOOK = FALSE;\n" +
			"		SHUTDOWNHOOK = FALSE;\n" +
			"		PRETASKHOOK = FALSE;\n" +
			"		POSTTASKHOOK = FALSE;\n" +
			"		USEGETSERVICEID = FALSE;\n" +
			"		USEPARAMETERACCESS = FALSE;\n" +
			"		USERESSCHEDULER = TRUE;\n" +
			"		\n" +
			"		KERNEL_TYPE = BCC1;\n" +
			"		\n" +
			"		ORTI_SECTIONS = ALL;\n" +
			"	};\n" +
			"	\n" +
			"	APPMODE ModeIncrement;\n" +
			"	APPMODE ModeDecrement;\n" +
			"	\n" +
			"	TASK LowTask {\n" +
			"		PRIORITY = 0x01;\n" +
			"		ACTIVATION = 1;\n" +
			"		SCHEDULE = FULL;\n" +
			"		AUTOSTART = FALSE;\n" +
			"		STACK = PRIVATE { SYS_SIZE = 0x300; };\n" +
			"		RESOURCE = Resource;\n" +
			"	};\n" +
			"	\n" +
			"	TASK HighTask {\n" +
			"		PRIORITY = 0x02;\n" +
			"		ACTIVATION = 1;\n" +
			"		SCHEDULE = FULL;\n" +
			"		AUTOSTART = TRUE { APPMODE=ModeIncrement; };  \n" +
			"		STACK = PRIVATE { SYS_SIZE = 0x300; };\n" +
			"		RESOURCE = Resource;\n" +
			"	};\n" +
			"	\n" +
			"	RESOURCE Resource { RESOURCEPROPERTY = STANDARD; };\n" +
			"};\n";
		commonWriterTest(text, 1);
	}

	
	
	
	

	@Test public void testOrti1() {
		final String text = "CPU EE {\n"
			+ "    OS EE {\n"
			+ "        EE_OPT = \"__ASSERT__\";\n"
			+ "        EE_OPT = \"__OSEKOS_NO_ALARMS__\";\n"
			+ "        EE_OPT = \"DEBUG\";\n"
		
			+ "        CFLAGS = \"-DALT_DEBUG -G0 -O0 -g\";\n"
			+ "        CFLAGS = \"-Wall -Wl,-Map -Wl,project.map\";\n"
			+ "        ASFLAGS = \"-g\";\n"
			+ "        LDDEPS = \"\\\\\";\n"
			+ "        LIBS = \"-lm\";\n"
			+ "        NIOS2_SYS_CONFIG = \"DEBUG\";\n"
			+ "        NIOS2_APP_CONFIG = \"DEBUG\";\n"
			+ "        NIOS2_DO_MAKE_OBJDUMP = TRUE;\n"
			+ "        NIOS2_JAM_FILE = \"test_file.jam\";\n"+
			"		   IPIC_GLOBAL_NAME = \"Ipic_subsystem\";\n" +
			"		   NIOS2_PTF_FILE = \"ptf_file\";\n" +
			
			"		MASTER_CPU = \"cpu1\";\n" +
		
			"		CPU_DATA = NIOSII {\n" +
			"			ID = \"cpu1\";\n" +
			"			MULTI_STACK = TRUE {\n" +
			"				IRQ_STACK = FALSE;\n" +
			"				DUMMY_STACK = SHARED;\n" +
			"			};\n" +
			"			\n" +
			"			APP_SRC = \"code_1.c\";\n" +
			"	\n" 
			+ "        STACK_TOP = \"0x20004000\";\n"
		//	+ "        STACK_BOTTOM = 0x20001800;\n"
			+ "        SYS_SIZE = 0x1000;\n" 
			+ "        SYSTEM_LIBRARY_NAME = \"library_name\";\n"
			+ "        SYSTEM_LIBRARY_PATH = \"path/library_name\";\n" +
			"			IPIC_LOCAL_NAME = \"Ipic_subsystem_1\";\n" +
		
			"	\n" +
			"		};\n"+ 
			
			"		CPU_DATA = NIOSII {\n" +
			"			ID = \"cpu2\";\n" +
			"			MULTI_STACK = TRUE {\n" +
			"				IRQ_STACK = FALSE;\n" +
			"				DUMMY_STACK = SHARED;\n" +
			"			};\n" +
			"			\n" +
			"			APP_SRC = \"code_2.c\";\n" +
			"	\n" 
			+ "        STACK_TOP = \"0x20008000\";\n"
			//+ "        STACK_BOTTOM = 0x20004000;\n"
			+ "        SYS_SIZE = 0x1000;\n"
			+ "        SYSTEM_LIBRARY_NAME = \"library_name\";\n"
			+ "        SYSTEM_LIBRARY_PATH = \"path/library_name\";\n" +
			"			IPIC_LOCAL_NAME = \"Ipic_subsystem_1\";\n" +
			"	\n" +
			"		};\n"+ 
			
			  "        STATUS = EXTENDED;\n"
			+ "        STARTUPHOOK = TRUE;\n"
			+ "        ERRORHOOK = FALSE;\n"
			+ "        SHUTDOWNHOOK = FALSE;\n"
			+ "        PRETASKHOOK = FALSE;\n"
			+ "        POSTTASKHOOK = FALSE;\n"
			+ "        USEGETSERVICEID = FALSE;\n"
			+ "        USEPARAMETERACCESS = FALSE;\n"
			+ "        USERESSCHEDULER = TRUE;\n"
			+ "        KERNEL_TYPE = BCC1;\n"
			+ "        ORTI_SECTIONS = ALL;\n"
			+ "    };\n"
			+ "    TASK Task1 {\n"
			+ "        CPU_ID = \"cpu1\";"
			+ "        PRIORITY = 0x01;\n"
			+ "        ACTIVATION = 4;\n"
			+ "        SCHEDULE = FULL;\n"
			+ "        AUTOSTART = TRUE;\n"
			+ "        STACK = PRIVATE {\n"
			+ "            SYS_SIZE = 0x100;\n"
			+ "        };\n"
			+ "        EVENT = evento1;\n"
			+ "    };\n"
			+ "    TASK Task2 {\n"
			+ "        CPU_ID = \"cpu1\";"
			+ "        PRIORITY = 0x02;\n"
			+ "        ACTIVATION = 1;\n"
			+ "        SCHEDULE = FULL;\n"
			+ "        AUTOSTART = TRUE;\n"
			+ "        STACK = SHARED;\n"
			+ "    };\n"
			+ "    TASK Task3 {\n"
			+ "        CPU_ID = \"cpu2\";"
			+ "        PRIORITY = 0x04;\n"
			+ "        ACTIVATION = 1;\n"
			+ "        SCHEDULE = FULL;\n"
			+ "        AUTOSTART = TRUE;\n"
			+ "        STACK = SHARED;\n"
			+ "    };\n"
			+ "	 EVENT evento1 {};\n"
			+ "};\n";

		commonWriterTest(text, 2);
	}

	

	@Test public void testFRSH_multiNiosII() {
		String test = "CPU mySystem {" +
		"	OS myOs {" +
		"" 
		+ "        NIOS2_SYS_CONFIG = \"DEBUG\";\n"
		+ "        NIOS2_APP_CONFIG = \"DEBUG\";\n"
		+ "        NIOS2_DO_MAKE_OBJDUMP = TRUE;\n"
		+ "        NIOS2_JAM_FILE = \"test_file.jam\";\n"+
		"		   IPIC_GLOBAL_NAME = \"Ipic_subsystem\";\n" +
		"		   NIOS2_PTF_FILE = \"ptf_file\";\n" +
		
		"		MASTER_CPU = \"cpu1\";\n" +
	
		"		CPU_DATA = NIOSII {\n" +
		"			ID = \"cpu1\";\n" +
		"			MULTI_STACK = TRUE {\n" +
		"				IRQ_STACK = TRUE {" +
		"					SYS_SIZE=512;" +
		"				};" +
		"				DUMMY_STACK = SHARED;\n" +
		"			};\n" +
		"			\n" +
		"			APP_SRC = \"code_1.c\";\n" +
		"	\n" 
		+ "        STACK_TOP = \"0x20004000\";\n"
	//	+ "        STACK_BOTTOM = 0x20001800;\n"
		+ "        SYS_SIZE = 0x1000;\n" 
		+ "        SYSTEM_LIBRARY_NAME = \"library_name_1\";\n"
		+ "        SYSTEM_LIBRARY_PATH = \"path/library_name_1\";\n" +
		"			IPIC_LOCAL_NAME = \"Ipic_subsystem_1\";\n" +
		"			TIMER_FREERUNNING = \"HIGH_RES_TIMER_0\";\n" +
		"			FRSH_TIMERS = MULTIPLE {\n" +
		"				TIMER_IRQ_BUDGET = \"TIMER_CAPACITY_0\";\n" +
		"				TIMER_IRQ_RECHARGE = \"TIMER_RECHARGING_0\";\n" +
		"				TIMER_IRQ_DLCHECK = \"TIMER_DLCHECK_0\";\n" +
		"				TIMER_IRQ_SEM = \"TIMER_SEM_0\";\n" +
		"		     };\n" +
	
		"	\n" +
		"		};\n"+ 
		
		"		CPU_DATA = NIOSII {\n" +
		"			ID = \"cpu2\";\n" +
		"			MULTI_STACK = TRUE {\n" +
		"				IRQ_STACK = TRUE {" +
		"					SYS_SIZE=512;" +
		"				};" +
		"				DUMMY_STACK = SHARED;\n" +
		"			};\n" +
		"			\n" +
		"			APP_SRC = \"code_2.c\";\n" +
		"	\n" 
		+ "        STACK_TOP = \"0x20008000\";\n"
		//+ "        STACK_BOTTOM = 0x20004000;\n"
		+ "        SYS_SIZE = 0x1000;\n"
		+ "        SYSTEM_LIBRARY_NAME = \"library_name_2\";\n"
		+ "        SYSTEM_LIBRARY_PATH = \"path/library_name_2\";\n" +
		"			IPIC_LOCAL_NAME = \"Ipic_subsystem_2\";\n" +
		"			TIMER_FREERUNNING = \"HIGH_RES_TIMER_0\";\n" +
		"			FRSH_TIMERS = MULTIPLE {\n" +
		"				TIMER_IRQ_BUDGET = \"TIMER_CAPACITY_0\";\n" +
		"				TIMER_IRQ_RECHARGE = \"TIMER_RECHARGING_0\";\n" +
		"				TIMER_IRQ_DLCHECK = \"TIMER_DLCHECK_0\";\n" +
		"				TIMER_IRQ_SEM = \"TIMER_SEM_0\";\n" +
		"		     };\n" +
		"	\n" +
		"		};\n"+ 

		"		CPU_DATA = NIOSII {\n" +
//		"			ID = \"cpu1\";\n" + // default_cpu
		"			MULTI_STACK = TRUE {\n" +
		"				IRQ_STACK = TRUE {" +
		"					SYS_SIZE=512;" +
		"				};" +
		"				DUMMY_STACK = SHARED;\n" +
		"			};\n" +
		"			\n" +
		"			APP_SRC = \"code_def.c\";\n" +
		"	\n" 
		+ "        STACK_TOP = \"0x20004000\";\n"
	//	+ "        STACK_BOTTOM = 0x20001800;\n"
		+ "        SYS_SIZE = 0x1000;\n" 
		+ "        SYSTEM_LIBRARY_NAME = \"library_name_d\";\n"
		+ "        SYSTEM_LIBRARY_PATH = \"path/library_name_d\";\n" +
		"			IPIC_LOCAL_NAME = \"Ipic_subsystem_def\";\n" +
		"			TIMER_FREERUNNING = \"HIGH_RES_TIMER_0\";\n" +
		"			FRSH_TIMERS = MULTIPLE {\n" +
		"				TIMER_IRQ_BUDGET = \"TIMER_CAPACITY_0\";\n" +
		"				TIMER_IRQ_RECHARGE = \"TIMER_RECHARGING_0\";\n" +
		"				TIMER_IRQ_DLCHECK = \"TIMER_DLCHECK_0\";\n" +
		"				TIMER_IRQ_SEM = \"TIMER_SEM_0\";\n" +
		"		     };\n" +

		"	\n" +
		"		};\n"+ 
		"" +
		"		KERNEL_TYPE = FRSH {" +
		"" +
		"			CONTRACTS =  CONTRACT { " +
		"				NAME = \"C1\";" +
		"				BUDGET = 0x2000;" +
		"				PERIOD = 0x10000;" +
		"			};" +
		"" +
		"			CONTRACTS = CONTRACT { " +
		"				NAME = \"C2\";" +
		"				BUDGET = 0x2000;" +
		"				PERIOD = 0x20000;" +
		"				CPU_ID = \"cpu2\";" +
		"			};" +
		"" +
		"			CONTRACTS = CONTRACT { " +
		"				NAME = \"C3\";" +
		"				BUDGET = 0x2000;" +
		"				PERIOD = 0x40000;" +
		"				CPU_ID = \"cpu1\";" +
		"			};" +
		"" +
		"			CONTRACTS = CONTRACT { " +
		"				NAME = \"C4\";" +
		"				BUDGET = 0x2000;" +
		"				PERIOD = 0x80000;" +
		"				CPU_ID = \"cpu2\";" +
		"			};" +
		"" +
		"			CONTRACTS = CONTRACT { " +
		"				NAME = \"C5\";" +
		"				BUDGET = 0x2000;" +
		"				PERIOD = 0x160000;" +
		"			};" +
		"" +
		"		};" +
		"	};" +
		"" +
		"	TASK T1 {" +
		"		PRIORITY = 0x40;" +
		"		STACK = PRIVATE { " +
		"			SYS_SIZE = 512; " +
		"		}; " +
		"		SCHEDULE = FULL;" +
		"		CONTRACT = \"C1\";			" +
		"	};" +
		"" +
		"	TASK T2 {" +
		"		PRIORITY = 0x10;" +
		"		STACK = PRIVATE { " +
		"			SYS_SIZE = 512; " +
		"		}; " +
		"		SCHEDULE = FULL;" +
		"		CONTRACT = \"C2\";			" +
		"		CPU_ID = \"cpu2\";" +
		"	};" +
		"" +
		"	TASK T3 {" +
		"		PRIORITY = 0x04;" +
		"		STACK = PRIVATE { " +
		"			SYS_SIZE = 512; " +
		"		}; " +
		"		SCHEDULE = FULL;" +
		"		CONTRACT = \"C3\";			" +
		"		CPU_ID = \"cpu1\";" +
		"	};" +
		"" +
		"	TASK T4 {" +
		"		PRIORITY = 0x01;" +
		"		STACK = PRIVATE { " +
		"			SYS_SIZE = 512; " +
		"		}; " +
		"		SCHEDULE = FULL;" +
		"		CONTRACT = \"C4\";			" +
		"		CPU_ID = \"cpu2\";" +
		"	};" +
		"" +
		"	COUNTER myCounter;" +
		"" +
		"	ALARM AcquireAlarm {" +
		"		COUNTER = myCounter;" +
		"		ACTION = ACTIVATETASK { TASK = T1; };" +
		"	};" +
		"};		";
		commonWriterTest(test, 3);
	}

	
	@Test public void testFRSH_multiNiosII_2() {
		String test = "CPU test_application {\n" +
		"\n" +
		"	OS EE {\n" +
		"	\n" +
		"		CFLAGS = \"-DALT_DEBUG -O0 -g\";\n" +
		"		CFLAGS = \"-Wall\";\n" +
		"		LDFLAGS = \"-Wl,-Map -Wl,project.map\";\n" +
		"		ASFLAGS = \"-g\";\n" +
		"		LDDEPS = \"\\\\\";\n" +
		"		LIBS = \"-lm\";\n" +
		"		NIOS2_SYS_CONFIG = \"Debug\";\n" +
		"		NIOS2_APP_CONFIG = \"Debug\";\n" +
		"		NIOS2_DO_MAKE_OBJDUMP = TRUE;\n" +
		"		MASTER_CPU = \"cpu0\";			\n" +
		"		IPIC_GLOBAL_NAME = \"IPIC_OUTPUT\";\n" +
		"		NIOS2_JAM_FILE = \"C:/altera/81/nios2eds/examples/verilog/niosII_stratixII_2s60_RoHS/frsh_multi4/fpga.jam\";\n" +
		"		NIOS2_PTF_FILE = \"C:/altera/81/nios2eds/examples/verilog/niosII_stratixII_2s60_RoHS/frsh_multi4/NiosII_stratixII_2s60_RoHS_small_sopc.ptf\";\n" +
		"\n" +
		"		CPU_DATA = NIOSII {\n" +
		"			ID = \"cpu0\";\n" +
		"			APP_SRC = \"cpu0_main.c\";\n" +
		"			APP_SRC = \"cover.c\";\n" +
		"			STACK_TOP = \"__alt_stack_pointer\";\n" +
		"			SYSTEM_LIBRARY_NAME = \"frsh_multi4_syslib_0\";\n" +
		"			SYSTEM_LIBRARY_PATH = \"/cygdrive/c/Users/pj/workspaceFRSH81/frsh_multi4_syslib_0\";\n" +
		"			IPIC_LOCAL_NAME = \"IPIC_INPUT_0\";\n" +
		"			\n" +
		"			SYS_SIZE = 8096;			\n" +
		"			MULTI_STACK = TRUE {\n" +
		"				IRQ_STACK = TRUE {\n" +
		"					SYS_SIZE=512;\n" +
		"				};\n" +
		"				DUMMY_STACK = SHARED;\n" +
		"			};\n" +
		"			TIMER_FREERUNNING = \"HIGH_RES_TIMER_0\";\n" +
		"			FRSH_TIMERS = MULTIPLE {\n" +
		"				TIMER_IRQ_BUDGET = \"TIMER_CAPACITY_0\";\n" +
		"				TIMER_IRQ_RECHARGE = \"TIMER_RECHARGING_0\";\n" +
		"				TIMER_IRQ_DLCHECK = \"TIMER_DLCHECK_0\";\n" +
		"				TIMER_IRQ_SEM = \"TIMER_SEM_0\";\n" +
		"		     };\n" +
		"\n" +
		"		};\n" +
		"	\n" +
		"		CPU_DATA = NIOSII {\n" +
		"			ID = \"cpu1\";\n" +
		"			APP_SRC = \"cpu1_main.c\";\n" +
		"			STACK_TOP = \"__alt_stack_pointer\";\n" +
		"			SYSTEM_LIBRARY_NAME = \"frsh_multi4_syslib_1\";\n" +
		"			SYSTEM_LIBRARY_PATH = \"/cygdrive/c/Users/pj/workspaceFRSH81/frsh_multi4_syslib_1\";\n" +
		"			IPIC_LOCAL_NAME = \"IPIC_INPUT_1\";\n" +
		"			\n" +
		"			SYS_SIZE = 8096;			\n" +
		"			MULTI_STACK = TRUE {\n" +
		"				IRQ_STACK = TRUE {\n" +
		"					SYS_SIZE=512;\n" +
		"				};\n" +
		"				DUMMY_STACK = SHARED;\n" +
		"			};\n" +
		"			TIMER_FREERUNNING = \"HIGH_RES_TIMER_1\";\n" +
		"			FRSH_TIMERS = MULTIPLE {\n" +
		"				TIMER_IRQ_BUDGET = \"TIMER_CAPACITY_1\";\n" +
		"				TIMER_IRQ_RECHARGE = \"TIMER_RECHARGING_1\";\n" +
		"				TIMER_IRQ_DLCHECK = \"TIMER_DLCHECK_1\";\n" +
		"				TIMER_IRQ_SEM = \"TIMER_SEM_1\";\n" +
		"		     };\n" +
		"			\n" +
		"		};\n" +
		"\n" +
		"		CPU_DATA = NIOSII {\n" +
		"			ID = \"cpu2\";\n" +
		"			APP_SRC = \"cpu2_main.c\";\n" +
		"			STACK_TOP = \"__alt_stack_pointer\";\n" +
		"			SYSTEM_LIBRARY_NAME = \"frsh_multi4_syslib_2\";\n" +
		"			SYSTEM_LIBRARY_PATH = \"/cygdrive/c/Users/pj/workspaceFRSH81/frsh_multi4_syslib_2\";\n" +
		"			IPIC_LOCAL_NAME = \"IPIC_INPUT_2\";\n" +
		"			\n" +
		"			SYS_SIZE = 8096;			\n" +
		"			MULTI_STACK = TRUE {\n" +
		"				IRQ_STACK = TRUE {\n" +
		"					SYS_SIZE=512;\n" +
		"				};\n" +
		"				DUMMY_STACK = SHARED;\n" +
		"			};\n" +
		"			TIMER_FREERUNNING = \"HIGH_RES_TIMER_2\";\n" +
		"			FRSH_TIMERS = MULTIPLE {\n" +
		"				TIMER_IRQ_BUDGET = \"TIMER_CAPACITY_2\";\n" +
		"				TIMER_IRQ_RECHARGE = \"TIMER_RECHARGING_2\";\n" +
		"				TIMER_IRQ_DLCHECK = \"TIMER_DLCHECK_2\";\n" +
		"				TIMER_IRQ_SEM = \"TIMER_SEM_2\";\n" +
		"		     };\n" +
		"			\n" +
		"		};\n" +
		"\n" +
		"		CPU_DATA = NIOSII {\n" +
		"			ID = \"cpu3\";\n" +
		"			APP_SRC = \"cpu3_main.c\";\n" +
		"			STACK_TOP = \"__alt_stack_pointer\";\n" +
		"			SYSTEM_LIBRARY_NAME = \"frsh_multi4_syslib_3\";\n" +
		"			SYSTEM_LIBRARY_PATH = \"/cygdrive/c/Users/pj/workspaceFRSH81/frsh_multi4_syslib_3\";\n" +
		"			IPIC_LOCAL_NAME = \"IPIC_INPUT_3\";\n" +
		"			\n" +
		"			SYS_SIZE = 8096;			\n" +
		"			MULTI_STACK = TRUE {\n" +
		"				IRQ_STACK = TRUE {\n" +
		"					SYS_SIZE=512;\n" +
		"				};\n" +
		"				DUMMY_STACK = SHARED;\n" +
		"			};\n" +
		"			TIMER_FREERUNNING = \"HIGH_RES_TIMER_3\";\n" +
		"			FRSH_TIMERS = MULTIPLE {\n" +
		"				TIMER_IRQ_BUDGET = \"TIMER_CAPACITY_3\";\n" +
		"				TIMER_IRQ_RECHARGE = \"TIMER_RECHARGING_3\";\n" +
		"				TIMER_IRQ_DLCHECK = \"TIMER_DLCHECK_3\";\n" +
		"				TIMER_IRQ_SEM = \"TIMER_SEM_3\";\n" +
		"		     };\n" +
		"\n" +
		"		};\n" +
		"\n" +
		"		STARTUPSYNC = TRUE;\n" +
		"        	\n" +
		"		USEREMOTETASK = ALWAYS;\n" +
		"		NIOS2_MUTEX_BASE = \"MUTEX_BASE\";\n" +
		"\n" +
		"		ORTI_SECTIONS = ALL;\n" +
		"		\n" +
		"        KERNEL_TYPE = FRSH {\n" +
		"        		TICK_TIME = \"20ns\";\n" +
		"        		USE_SYNC_OBJ = FALSE;\n" +
		"        		CONTRACTS = CONTRACT {\n" +
		"        				CPU_ID = \"cpu0\";	NAME = \"c1_0\";\n" +
		"        				BUDGET = 20000;		PERIOD = 100000;        			};\n" +
		"        		CONTRACTS = CONTRACT {\n" +
		"        				CPU_ID = \"cpu0\";	NAME = \"c2_0\";\n" +
		"        				BUDGET = 20000;		PERIOD = 100000;        			};\n" +
		"        		CONTRACTS = CONTRACT {\n" +
		"        				CPU_ID = \"cpu0\";	NAME = \"c3_0\";\n" +
		"        				BUDGET = 20000;		PERIOD = 100000;        			};\n" +
		"        		CONTRACTS = CONTRACT {\n" +
		"        				CPU_ID = \"cpu0\";	NAME = \"c4_0\";\n" +
		"        				BUDGET = 20000;		PERIOD = 100000;        			};\n" +
		"        		CONTRACTS = CONTRACT {\n" +
		"        				CPU_ID = \"cpu0\";	NAME = \"c5_0\";\n" +
		"        				BUDGET = 40000;		PERIOD = 800000;        			};\n" +
		"        		CONTRACTS = CONTRACT {\n" +
		"        				CPU_ID = \"cpu0\";	NAME = \"c6_0\";\n" +
		"        				BUDGET = 40000;		PERIOD = 800000;        			};\n" +
		"        		CONTRACTS = CONTRACT {\n" +
		"        				CPU_ID = \"cpu0\";	NAME = \"c7_0\";\n" +
		"        				BUDGET = 40000;		PERIOD = 800000;        			};\n" +
		"\n" +
		"\n" +
		"        		CONTRACTS = CONTRACT {\n" +
		"        				CPU_ID = \"cpu1\";	NAME = \"c1_1\";\n" +
		"        				BUDGET = 20000;		PERIOD = 100000;        			};\n" +
		"        		CONTRACTS = CONTRACT {\n" +
		"        				CPU_ID = \"cpu1\";	NAME = \"c2_1\";\n" +
		"        				BUDGET = 20000;		PERIOD = 100000;        			};\n" +
		"        		CONTRACTS = CONTRACT {\n" +
		"        				CPU_ID = \"cpu1\";	NAME = \"c3_1\";\n" +
		"        				BUDGET = 20000;		PERIOD = 100000;        			};\n" +
		"        		CONTRACTS = CONTRACT {\n" +
		"        				CPU_ID = \"cpu1\";	NAME = \"c4_1\";\n" +
		"        				BUDGET = 20000;		PERIOD = 100000;        			};\n" +
		"        		CONTRACTS = CONTRACT {\n" +
		"        				CPU_ID = \"cpu1\";	NAME = \"c5_1\";\n" +
		"        				BUDGET = 40000;		PERIOD = 800000;        			};\n" +
		"        		CONTRACTS = CONTRACT {\n" +
		"        				CPU_ID = \"cpu1\";	NAME = \"c6_1\";\n" +
		"        				BUDGET = 40000;		PERIOD = 800000;        			};\n" +
		"        		CONTRACTS = CONTRACT {\n" +
		"        				CPU_ID = \"cpu1\";	NAME = \"c7_1\";\n" +
		"        				BUDGET = 40000;		PERIOD = 800000;        			};\n" +
		"\n" +
		"\n" +
		"\n" +
		"        		CONTRACTS = CONTRACT {\n" +
		"        				CPU_ID = \"cpu2\";	NAME = \"c1_2\";\n" +
		"        				BUDGET = 20000;		PERIOD = 100000;        			};\n" +
		"        		CONTRACTS = CONTRACT {\n" +
		"        				CPU_ID = \"cpu2\";	NAME = \"c2_2\";\n" +
		"        				BUDGET = 20000;		PERIOD = 100000;        			};\n" +
		"        		CONTRACTS = CONTRACT {\n" +
		"        				CPU_ID = \"cpu2\";	NAME = \"c3_2\";\n" +
		"        				BUDGET = 20000;		PERIOD = 100000;        			};\n" +
		"        		CONTRACTS = CONTRACT {\n" +
		"        				CPU_ID = \"cpu2\";	NAME = \"c4_2\";\n" +
		"        				BUDGET = 20000;		PERIOD = 100000;        			};\n" +
		"        		CONTRACTS = CONTRACT {\n" +
		"        				CPU_ID = \"cpu2\";	NAME = \"c5_2\";\n" +
		"        				BUDGET = 40000;		PERIOD = 800000;        			};\n" +
		"        		CONTRACTS = CONTRACT {\n" +
		"        				CPU_ID = \"cpu2\";	NAME = \"c6_2\";\n" +
		"        				BUDGET = 40000;		PERIOD = 800000;        			};\n" +
		"        		CONTRACTS = CONTRACT {\n" +
		"        				CPU_ID = \"cpu2\";	NAME = \"c7_2\";\n" +
		"        				BUDGET = 40000;		PERIOD = 800000;        			};\n" +
		"\n" +
		"\n" +
		"\n" +
		"        		CONTRACTS = CONTRACT {\n" +
		"        				CPU_ID = \"cpu3\";	NAME = \"c1_3\";\n" +
		"        				BUDGET = 20000;		PERIOD = 100000;        			};\n" +
		"        		CONTRACTS = CONTRACT {\n" +
		"        				CPU_ID = \"cpu3\";	NAME = \"c2_3\";\n" +
		"        				BUDGET = 20000;		PERIOD = 100000;        			};\n" +
		"        		CONTRACTS = CONTRACT {\n" +
		"        				CPU_ID = \"cpu3\";	NAME = \"c3_3\";\n" +
		"        				BUDGET = 20000;		PERIOD = 100000;        			};\n" +
		"        		CONTRACTS = CONTRACT {\n" +
		"        				CPU_ID = \"cpu3\";	NAME = \"c4_3\";\n" +
		"        				BUDGET = 20000;		PERIOD = 100000;        			};\n" +
		"        		CONTRACTS = CONTRACT {\n" +
		"        				CPU_ID = \"cpu3\";	NAME = \"c5_3\";\n" +
		"        				BUDGET = 40000;		PERIOD = 800000;        			};\n" +
		"        		CONTRACTS = CONTRACT {\n" +
		"        				CPU_ID = \"cpu3\";	NAME = \"c6_3\";\n" +
		"        				BUDGET = 40000;		PERIOD = 800000;        			};\n" +
		"        		CONTRACTS = CONTRACT {\n" +
		"        				CPU_ID = \"cpu3\";	NAME = \"c7_3\";\n" +
		"        				BUDGET = 40000;		PERIOD = 800000;        			};\n" +
		"\n" +
		"\n" +
		"        	};\n" +
		"	};\n" +
		"\n" +
		"    TASK Task1 {\n" +
		"		CPU_ID = \"cpu0\";\n" +
		"    	CONTRACT = \"c1_0\";\n" +
		"		PRIORITY = 0x01;\n" +
		"		STACK = PRIVATE {\n" +
		"			SYS_SIZE = 1024;\n" +
		"		};\n" +
		"		RESOURCE = myRes;\n" +
		"		RESOURCE = myRes2;\n" +
		"    };\n" +
		"\n" +
		"    TASK Task2 {\n" +
		"		CPU_ID = \"cpu0\";\n" +
		"    	CONTRACT = \"c2_0\";\n" +
		"		PRIORITY = 0x01;\n" +
		"		STACK = PRIVATE {\n" +
		"			SYS_SIZE = 1024;\n" +
		"		};\n" +
		"    };\n" +
		"    \n" +
		"    TASK Task3 {\n" +
		"		CPU_ID = \"cpu0\";\n" +
		"    	CONTRACT = \"c3_0\";\n" +
		"		PRIORITY = 0x01;\n" +
		"		STACK = PRIVATE {\n" +
		"			SYS_SIZE = 1024;\n" +
		"		};\n" +
		"    };\n" +
		"    \n" +
		"    TASK Task4 {\n" +
		"		CPU_ID = \"cpu0\";\n" +
		"    	CONTRACT = \"c4_0\";\n" +
		"		PRIORITY = 0x01;\n" +
		"		STACK = PRIVATE {\n" +
		"			SYS_SIZE = 1024;\n" +
		"		};\n" +
		"    };\n" +
		"\n" +
		"    TASK mytask0 {\n" +
		"		CPU_ID = \"cpu0\";\n" +
		"    	CONTRACT = \"c5_0\";\n" +
		"		APP_SRC = \"task0.c\";\n" +
		"		PRIORITY = 0x01;\n" +
		"		STACK = PRIVATE {\n" +
		"			SYS_SIZE = 1024;\n" +
		"		};\n" +
		"		RESOURCE = myRes;\n" +
		"    };\n" +
		"\n" +
		"    TASK mytask1 {\n" +
		"		CPU_ID = \"cpu1\";\n" +
		"    	CONTRACT = \"c5_1\";\n" +
		"		APP_SRC = \"task1.c\";\n" +
		"		PRIORITY = 0x01;\n" +
		"		STACK = PRIVATE {\n" +
		"			SYS_SIZE = 1024;\n" +
		"		};\n" +
		"    };\n" +
		"\n" +
		"    TASK mytask2 {\n" +
		"		CPU_ID = \"cpu2\";\n" +
		"    	CONTRACT = \"c2_2\";\n" +
		"		APP_SRC = \"task2.c\";\n" +
		"		PRIORITY = 0x01;\n" +
		"		STACK = PRIVATE {\n" +
		"			SYS_SIZE = 1024;\n" +
		"		};\n" +
		"    };\n" +
		"\n" +
		"    TASK mytask3 {\n" +
		"		CPU_ID = \"cpu3\";\n" +
		"    	CONTRACT = \"c1_3\";\n" +
		"		APP_SRC = \"task3.c\";\n" +
		"		PRIORITY = 0x01;\n" +
		"		STACK = PRIVATE {\n" +
		"			SYS_SIZE = 1024;\n" +
		"		};\n" +
		"    };\n" +
		"\n" +
		"    RESOURCE myRes { RESOURCEPROPERTY = STANDARD; };\n" +
		"    RESOURCE myRes2 { RESOURCEPROPERTY = STANDARD; };\n" +
		"};";
		commonWriterTest(test, 4);
	}

	
	
	@Test public void testFRSH_multiNiosII_3() {
		String test = "CPU test_application {\n" +
		"\n" +
		"	OS EE {\n" +
		"		CFLAGS = \"-DALT_DEBUG -O0 -g\";\n" +
		"		CFLAGS = \"-Wall\";\n" +
		"		ASFLAGS = \"-g\";\n" +
		"		LDFLAGS = \"-Wl,-Map -Wl,project.map\";\n" +
		"		LDDEPS = \"\\\\\";\n" +
		"		LIBS = \"-lm\";\n" +
		"		NIOS2_SYS_CONFIG = \"Debug\";\n" +
		"		NIOS2_APP_CONFIG = \"Debug\";\n" +
		"		NIOS2_DO_MAKE_OBJDUMP = TRUE;\n" +
		"		NIOS2_JAM_FILE = \"C:/altera/81/nios2eds/examples/verilog/niosII_stratixII_2s60_RoHS/frsh_small/fpga.jam\";\n" +
		"		NIOS2_PTF_FILE = \"C:/altera/81/nios2eds/examples/verilog/niosII_stratixII_2s60_RoHS/frsh_small/NiosII_stratixII_2s60_RoHS_small_sopc.ptf\";\n" +
		"\n" +
		"		CPU_DATA = NIOSII {\n" +
		"			STACK_TOP = \"__alt_stack_pointer\";\n" +
		"			SYS_SIZE = 8096;\n" +
		"			/* The full_featured example is useful if you have the tracer support! */\n" +
		"			SYSTEM_LIBRARY_NAME = \"frsh_small_syslib\";\n" +
		"			SYSTEM_LIBRARY_PATH = \"/cygdrive/c/Users/pj/workspaceFRSH81/frsh_small_syslib\";\n" +
		"\n" +
		"			MULTI_STACK = TRUE {\n" +
		"				IRQ_STACK = TRUE {\n" +
		"					SYS_SIZE=512;\n" +
		"				};\n" +
		"				DUMMY_STACK = SHARED;\n" +
		"			};\n" +
		"\n" +
		"			APP_SRC = \"code.c\";\n" +
		"			\n" +
		"			TIMER_FREERUNNING = \"HIGH_RES_TIMER_0\";\n" +
		"			FRSH_TIMERS = MULTIPLE {\n" +
		"				TIMER_IRQ_BUDGET = \"TIMER_CAPACITY_0\";\n" +
		"				TIMER_IRQ_RECHARGE = \"TIMER_RECHARGING_0\";\n" +
		"				TIMER_IRQ_DLCHECK = \"TIMER_DLCHECK_0\";\n" +
		"				TIMER_IRQ_SEM = \"TIMER_SEM_0\";\n" +
		"		     };\n" +
		"		};\n" +
		"	  \n" +
		"		STATUS = EXTENDED;\n" +
		"		STARTUPHOOK = TRUE; // this demo is using the StartupHook!\n" +
		"		ERRORHOOK = TRUE;\n" +
		"		SHUTDOWNHOOK = FALSE;\n" +
		"		PRETASKHOOK = FALSE;\n" +
		"		POSTTASKHOOK = FALSE;\n" +
		"		USEGETSERVICEID = FALSE;\n" +
		"		USEPARAMETERACCESS = FALSE;\n" +
		"		USERESSCHEDULER = TRUE;\n" +
		"\n" +
		"        KERNEL_TYPE = FRSH {\n" +
		"        		TICK_TIME = \"20ns\";\n" +
		"        		USE_SYNC_OBJ = TRUE;\n" +
		"        		CONTRACTS = CONTRACT {\n" +
		"        				NAME = \"c1\";\n" +
		"        				BUDGET = 20000;\n" +
		"        				PERIOD = 100000;\n" +
		"        			};\n" +
		"        		CONTRACTS = CONTRACT {\n" +
		"        				NAME = \"c2\";\n" +
		"        				BUDGET = 20000;\n" +
		"        				PERIOD = 100000;\n" +
		"        			};\n" +
		"        		CONTRACTS = CONTRACT {\n" +
		"        				NAME = \"c3\";\n" +
		"        				BUDGET = 20000;\n" +
		"        				PERIOD = 100000;\n" +
		"        			};\n" +
		"        		CONTRACTS = CONTRACT {\n" +
		"        				NAME = \"c4\";\n" +
		"        				BUDGET = 20000;\n" +
		"        				PERIOD = 100000;\n" +
		"        			};\n" +
		"        		CONTRACTS = CONTRACT {\n" +
		"        				NAME = \"c5\";\n" +
		"        				BUDGET = 40000;\n" +
		"        				PERIOD = 800000;\n" +
		"        			};\n" +
		"        		CONTRACTS = CONTRACT {\n" +
		"        				NAME = \"c6\";\n" +
		"        				BUDGET = 40000;\n" +
		"        				PERIOD = 800000;\n" +
		"        			};\n" +
		"        		CONTRACTS = CONTRACT {\n" +
		"        				NAME = \"c7\";\n" +
		"        				BUDGET = 40000;\n" +
		"        				PERIOD = 800000;\n" +
		"        			};\n" +
		"        	};\n" +
		"		\n" +
		"		/* This generates the ORTI File used by lauterbach Trace32! */\n" +
		"		ORTI_SECTIONS = ALL;\n" +
		"    };\n" +
		"\n" +
		"    TASK Task1 {\n" +
		"    	CONTRACT = \"c1\";\n" +
		"		PRIORITY = 0x01;\n" +
		"		STACK = PRIVATE {\n" +
		"			SYS_SIZE = 1024;\n" +
		"		};\n" +
		"		RESOURCE = myRes;\n" +
		"		RESOURCE = myRes2;\n" +
		"    };\n" +
		"\n" +
		"    TASK Task2 {\n" +
		"    	CONTRACT = \"c2\";\n" +
		"		PRIORITY = 0x01;\n" +
		"		STACK = PRIVATE {\n" +
		"			SYS_SIZE = 1024;\n" +
		"		};\n" +
		"    };\n" +
		"    \n" +
		"    TASK Task3 {\n" +
		"    	CONTRACT = \"c3\";\n" +
		"		PRIORITY = 0x01;\n" +
		"		STACK = PRIVATE {\n" +
		"			SYS_SIZE = 1024;\n" +
		"		};\n" +
		"    };\n" +
		"    \n" +
		"    TASK Task4 {\n" +
		"    	CONTRACT = \"c4\";\n" +
		"		PRIORITY = 0x01;\n" +
		"		STACK = PRIVATE {\n" +
		"			SYS_SIZE = 1024;\n" +
		"		};\n" +
		"    };\n" +
		"    \n" +
		"    RESOURCE myRes { RESOURCEPROPERTY = STANDARD; };\n" +
		"    RESOURCE myRes2 { RESOURCEPROPERTY = STANDARD; };\n" +
		"\n" +
		"    COUNTER Counter1;\n" +
		"\n" +
		"    ALARM AlarmTask2 {\n" +
		"                COUNTER = Counter1;\n" +
		"                ACTION = ACTIVATETASK { TASK = Task2; };\n" +
		"    };\n" +
		"    ALARM AlarmTask3 {\n" +
		"                COUNTER = Counter1;\n" +
		"                ACTION = ACTIVATETASK { TASK = Task3; };\n" +
		"    };\n" +
		"    ALARM AlarmTask4 {\n" +
		"                COUNTER = Counter1;\n" +
		"                ACTION = ACTIVATETASK { TASK = Task4; };\n" +
		"    };\n" +
		"\n" +
		"};\n";
		
		commonWriterTest(test, 1);
	}

	

	@Test public void testHR_1() {
		String test = "CPU test_application {\n" +
				"\n" +
				"	OS EE {\n" +
				"		CFLAGS = \"-DALT_DEBUG -Os -g\";\n" +
				"		CFLAGS = \"-Wall\";\n" +
				"		ASFLAGS = \"-g\";\n" +
				"		LDFLAGS = \"-Wl,-Map -Wl,project.map\";\n" +
				"		LDDEPS = \"\\\\\";\n" +
				"		LIBS = \"-lm\";\n" +
				"		NIOS2_SYS_CONFIG = \"Debug\";\n" +
				"		NIOS2_APP_CONFIG = \"Debug\";\n" +
				"		NIOS2_DO_MAKE_OBJDUMP = TRUE;\n" +
				"		NIOS2_JAM_FILE = \"C:/altera/81/nios2eds/examples/verilog/niosII_stratixII_2s60_RoHS/frsh_small/fpga.jam\";\n" +
				"		NIOS2_PTF_FILE = \"C:/altera/81/nios2eds/examples/verilog/niosII_stratixII_2s60_RoHS/frsh_small/NiosII_stratixII_2s60_RoHS_small_sopc.ptf\";\n" +
				"\n" +
				"		CPU_DATA = NIOSII {\n" +
				"			STACK_TOP = \"__alt_stack_pointer\";\n" +
				"			SYS_SIZE = 8096;\n" +
				"			/* The full_featured example is useful if you have the tracer support! */\n" +
				"			SYSTEM_LIBRARY_NAME = \"frsh_small_syslib\";\n" +
				"			SYSTEM_LIBRARY_PATH = \"/cygdrive/c/Users/pj/workspaceFRSH81/frsh_small_syslib\";\n" +
				"\n" +
				"			MULTI_STACK = TRUE {\n" +
				"				IRQ_STACK = TRUE {\n" +
				"					SYS_SIZE=512;\n" +
				"				};\n" +
				"				DUMMY_STACK = SHARED;\n" +
				"			};\n" +
				"\n" +
				"			APP_SRC = \"code.c\";\n" +
				"			\n" +
				"			TIMER_FREERUNNING = \"HIGH_RES_TIMER_0\";\n" +
				"			FRSH_TIMERS = MULTIPLE {\n" +
				"				TIMER_IRQ_BUDGET = \"TIMER_CAPACITY_0\";\n" +
				"				TIMER_IRQ_RECHARGE = \"TIMER_RECHARGING_0\";\n" +
				"				TIMER_IRQ_DLCHECK = \"TIMER_DLCHECK_0\";\n" +
				"				//TIMER_IRQ_SEM = \"TIMER_SEM_0\";\n" +
				"		     };\n" +
				"		};\n" +
				"	  \n" +
				"		STATUS = EXTENDED;\n" +
				"		STARTUPHOOK = TRUE; // this demo is using the StartupHook!\n" +
				"		ERRORHOOK = TRUE;\n" +
				"		SHUTDOWNHOOK = FALSE;\n" +
				"		PRETASKHOOK = FALSE;\n" +
				"		POSTTASKHOOK = FALSE;\n" +
				"		USEGETSERVICEID = FALSE;\n" +
				"		USEPARAMETERACCESS = FALSE;\n" +
				"		USERESSCHEDULER = TRUE;\n" +
				"\n" +
				"        KERNEL_TYPE = HR {\n" +
				"        		TICK_TIME = \"20ns\";\n" +
				"        		//USE_SYNC_OBJ = TRUE;\n" +
				"        		CONTRACTS = CONTRACT {\n" +
				"        				NAME = \"c1\";\n" +
				"						BANDWIDTH = 15;\n" +
				"						MAX_DELAY = \"17000000\";\n" +
				"						SCHED_POLICY = \"FP\";\n" +
				"        			};\n" +
				"        		CONTRACTS = CONTRACT {\n" +
				"        				NAME = \"c2\";\n" +
				"        				BUDGET = 20000;\n" +
				"        				PERIOD = 100000;\n" +
				"						SCHED_POLICY = \"EDF\";\n" +
				"        			};\n" +
				"        		CONTRACTS = CONTRACT {\n" +
				"        				NAME = \"c3\";\n" +
				"        				BUDGET = 20000;\n" +
				"        				PERIOD = 100000;\n" +
				"						SCHED_POLICY = \"FP\";\n" +
				"        			};\n" +
				"        		CONTRACTS = CONTRACT {\n" +
				"        				NAME = \"c4\";\n" +
				"        				BUDGET = 20000;\n" +
				"        				PERIOD = 100000;\n" +
				"						SCHED_POLICY = \"FP\";\n" +
				"        			};\n" +
				"        		CONTRACTS = CONTRACT {\n" +
				"        				NAME = \"c5\";\n" +
				"        				BUDGET = 40000;\n" +
				"        				PERIOD = 800000;\n" +
				"						SCHED_POLICY = \"FP\";\n" +
				"        			};\n" +
				"        		CONTRACTS = CONTRACT {\n" +
				"        				NAME = \"c6\";\n" +
				"        				BUDGET = 40000;\n" +
				"        				PERIOD = 800000;\n" +
				"						SCHED_POLICY = \"FP\";\n" +
				"        			};\n" +
				"        		CONTRACTS = CONTRACT {\n" +
				"        				NAME = \"c7\";\n" +
				"        				BUDGET = 40000;\n" +
				"        				PERIOD = 800000;\n" +
				"						SCHED_POLICY = \"FP\";\n" +
				"        			};\n" +
				"        		CONTRACTS = CONTRACT {\n" +
				"        				NAME = \"clong\";\n" +
				"        				BUDGET = 40000;\n" +
				"        				PERIOD = 80000000;\n" +
				"						SCHED_POLICY = \"FP\";\n" +
				"        			};\n" +
				"        	};\n" +
				"		\n" +
				"		/* This generates the ORTI File used by lauterbach Trace32! */\n" +
				"		ORTI_SECTIONS = ALL;\n" +
				"    };\n" +
				"\n" +
				"    TASK Task1 {\n" +
				"    	CONTRACT = \"c1\";\n" +
				"		PRIORITY = 0x01;\n" +
				"		STACK = PRIVATE {\n" +
				"			SYS_SIZE = 1024;\n" +
				"		};\n" +
				"		RESOURCE = myRes;\n" +
				"		RESOURCE = myRes2;\n" +
				"		MAX_SYSTEM_LOCK_TIME =  \"5000ns\";\n" +
				"    };\n" +
				"\n" +
				"    TASK Task2 {\n" +
				"    	CONTRACT = \"c1\";\n" +
				"		PRIORITY = 0x06;\n" +
				"		STACK = PRIVATE {\n" +
				"			SYS_SIZE = 1024;\n" +
				"		};\n" +
				"		RESOURCE = myRes;\n" +
				"    };\n" +
				"    \n" +
				"    TASK Task3 {\n" +
				"    	CONTRACT = \"c2\";\n" +
				"		REL_DEADLINE = \"0.5s\";\n" +
				"		//PRIORITY = 0x01;\n" +
				"		STACK = PRIVATE {\n" +
				"			SYS_SIZE = 1024;\n" +
				"		};\n" +
				"		RESOURCE = myRes;\n" +
				"    };\n" +
				"    \n" +
				"    TASK Task4 {\n" +
				"    	CONTRACT = \"c2\";\n" +
				"		REL_DEADLINE = \"0.1s\";\n" +
				"		//PRIORITY = 0x02;\n" +
				"		STACK = PRIVATE {\n" +
				"			SYS_SIZE = 1024;\n" +
				"		};\n" +
				"    };\n" +
				"\n" +
				"   TASK Task5 {\n" +
				"    	CONTRACT = \"clong\";\n" +
				"		PRIORITY = 0x01;\n" +
				"		STACK = PRIVATE {\n" +
				"			SYS_SIZE = 1024;\n" +
				"		};\n" +
				"		RESOURCE = myRes2;\n" +
				"    };\n" +
				"    \n" +
				"    RESOURCE myRes { RESOURCEPROPERTY = STANDARD; };\n" +
				"    RESOURCE myRes2 { RESOURCEPROPERTY = STANDARD; };\n" +
				"\n" +
				"    COUNTER Counter1;\n" +
				"\n" +
				"    ALARM AlarmTask2 {\n" +
				"                COUNTER = Counter1;\n" +
				"                ACTION = ACTIVATETASK { TASK = Task2; };\n" +
				"    };\n" +
				"    ALARM AlarmTask3 {\n" +
				"                COUNTER = Counter1;\n" +
				"                ACTION = ACTIVATETASK { TASK = Task3; };\n" +
				"    };\n" +
				"    ALARM AlarmTask4 {\n" +
				"                COUNTER = Counter1;\n" +
				"                ACTION = ACTIVATETASK { TASK = Task4; };\n" +
				"    };\n" +
				"\n" +
				"};\n";

		commonWriterTest(test, 1);
	}

	

	@Test public void testHR_2() {
		String test = "CPU test_application {\n" +
				"\n" +
				"	OS EE {\n" +
				"		CFLAGS = \"-DALT_DEBUG -Os -g\";\n" +
				"		CFLAGS = \"-Wall\";\n" +
				"		ASFLAGS = \"-g\";\n" +
				"		LDFLAGS = \"-Wl,-Map -Wl,project.map\";\n" +
				"		LDDEPS = \"\\\";\n" +
				"		LIBS = \"-lm\";\n" +
				"		NIOS2_SYS_CONFIG = \"Debug\";\n" +
				"		NIOS2_APP_CONFIG = \"Debug\";\n" +
				"		NIOS2_DO_MAKE_OBJDUMP = TRUE;\n" +
				"		NIOS2_JAM_FILE = \"C:/altera/81/nios2eds/examples/verilog/niosII_stratixII_2s60_RoHS/frsh_small/fpga.jam\";\n" +
				"		NIOS2_PTF_FILE = \"C:/altera/81/nios2eds/examples/verilog/niosII_stratixII_2s60_RoHS/frsh_small/NiosII_stratixII_2s60_RoHS_small_sopc.ptf\";\n" +
				"\n" +
				"		CPU_DATA = NIOSII {\n" +
				"			STACK_TOP = \"__alt_stack_pointer\";\n" +
				"			SYS_SIZE = 8096;\n" +
				"			/* The full_featured example is useful if you have the tracer support! */\n" +
				"			SYSTEM_LIBRARY_NAME = \"frsh_small_syslib\";\n" +
				"			SYSTEM_LIBRARY_PATH = \"/cygdrive/c/Users/pj/workspaceFRSH81/frsh_small_syslib\";\n" +
				"\n" +
				"			MULTI_STACK = TRUE {\n" +
				"				IRQ_STACK = TRUE {\n" +
				"					SYS_SIZE=512;\n" +
				"				};\n" +
				"				DUMMY_STACK = SHARED;\n" +
				"			};\n" +
				"\n" +
				"			APP_SRC = \"code.c\";\n" +
				"			\n" +
				"			TIMER_FREERUNNING = \"HIGH_RES_TIMER_0\";\n" +
				"			FRSH_TIMERS = MULTIPLE {\n" +
				"				TIMER_IRQ_BUDGET = \"TIMER_CAPACITY_0\";\n" +
				"				TIMER_IRQ_RECHARGE = \"TIMER_RECHARGING_0\";\n" +
				"				TIMER_IRQ_DLCHECK = \"TIMER_DLCHECK_0\";\n" +
				"				//TIMER_IRQ_SEM = \"TIMER_SEM_0\";\n" +
				"		     };\n" +
				"		};\n" +
				"	  \n" +
				"		STATUS = EXTENDED;\n" +
				"		STARTUPHOOK = TRUE; // this demo is using the StartupHook!\n" +
				"		ERRORHOOK = TRUE;\n" +
				"		SHUTDOWNHOOK = FALSE;\n" +
				"		PRETASKHOOK = FALSE;\n" +
				"		POSTTASKHOOK = FALSE;\n" +
				"		USEGETSERVICEID = FALSE;\n" +
				"		USEPARAMETERACCESS = FALSE;\n" +
				"		USERESSCHEDULER = TRUE;\n" +
				"\n" +
				"        KERNEL_TYPE = HR {\n" +
				"        		TICK_TIME = \"20ns\";\n" +
				"        		//USE_SYNC_OBJ = TRUE;\n" +
				"        		CONTRACTS = CONTRACT {\n" +
				"        				NAME = \"c1\";\n" +
				"						BANDWIDTH = 15;\n" +
				"						MAX_DELAY = 17000000;\n" +
				"						SCHED_POLICY = \"FP\";\n" +
				"        			};\n" +
				"        		CONTRACTS = CONTRACT {\n" +
				"        				NAME = \"c2\";\n" +
				"        				BUDGET = 20000;\n" +
				"        				PERIOD = 100000;\n" +
				"						SCHED_POLICY = \"EDF\";\n" +
				"        			};\n" +
				"        		CONTRACTS = CONTRACT {\n" +
				"        				NAME = \"c3\";\n" +
				"        				BUDGET = 20000;\n" +
				"        				PERIOD = 100000;\n" +
				"						SCHED_POLICY = \"FP\";\n" +
				"        			};\n" +
				"        		CONTRACTS = CONTRACT {\n" +
				"        				NAME = \"c4\";\n" +
				"        				BUDGET = 20000;\n" +
				"        				PERIOD = 100000;\n" +
				"						SCHED_POLICY = \"FP\";\n" +
				"        			};\n" +
				"        		CONTRACTS = CONTRACT {\n" +
				"        				NAME = \"c5\";\n" +
				"        				BUDGET = 40000;\n" +
				"        				PERIOD = 800000;\n" +
				"						SCHED_POLICY = \"FP\";\n" +
				"        			};\n" +
				"        		CONTRACTS = CONTRACT {\n" +
				"        				NAME = \"c6\";\n" +
				"        				BUDGET = 40000;\n" +
				"        				PERIOD = 800000;\n" +
				"						SCHED_POLICY = \"FP\";\n" +
				"        			};\n" +
				"        		CONTRACTS = CONTRACT {\n" +
				"        				NAME = \"c7\";\n" +
				"        				BUDGET = 40000;\n" +
				"        				PERIOD = 800000;\n" +
				"						SCHED_POLICY = \"FP\";\n" +
				"        			};\n" +
				"        		CONTRACTS = CONTRACT {\n" +
				"        				NAME = \"clong\";\n" +
				"        				BUDGET = 40000;\n" +
				"        				PERIOD = 80000000;\n" +
				"						SCHED_POLICY = \"FP\";\n" +
				"        			};\n" +
				"        	};\n" +
				"		\n" +
				"		/* This generates the ORTI File used by lauterbach Trace32! */\n" +
				"		ORTI_SECTIONS = ALL;\n" +
				"    };\n" +
				"\n" +
				"    TASK Task1 {\n" +
				"    	CONTRACT = \"c1\";\n" +
				"		PRIORITY = 0x01;\n" +
				"		STACK = PRIVATE {\n" +
				"			SYS_SIZE = 1024;\n" +
				"		};\n" +
				"		RESOURCE = myRes;\n" +
				"		RESOURCE = myRes2;\n" +
				"		MAX_SYSTEM_LOCK_TIME =  \"5000ns\";\n" +
				"    };\n" +
				"\n" +
				"    TASK Task2 {\n" +
				"    	CONTRACT = \"c1\";\n" +
				"		PRIORITY = 0x06;\n" +
				"		STACK = PRIVATE {\n" +
				"			SYS_SIZE = 1024;\n" +
				"		};\n" +
				"		RESOURCE = myRes;\n" +
				"    };\n" +
				"    \n" +
				"    TASK Task3 {\n" +
				"    	CONTRACT = \"c2\";\n" +
				"		REL_DEADLINE = \"0.5s\";\n" +
				"		//PRIORITY = 0x01;\n" +
				"		STACK = PRIVATE {\n" +
				"			SYS_SIZE = 1024;\n" +
				"		};\n" +
				"		RESOURCE = myRes;\n" +
				"    };\n" +
				"    \n" +
				"    TASK Task4 {\n" +
				"    	CONTRACT = \"c2\";\n" +
				"		REL_DEADLINE = \"0.1s\";\n" +
				"		//PRIORITY = 0x02;\n" +
				"		STACK = PRIVATE {\n" +
				"			SYS_SIZE = 1024;\n" +
				"		};\n" +
				"    };\n" +
				"\n" +
				"   TASK Task5 {\n" +
				"    	CONTRACT = \"clong\";\n" +
				"		PRIORITY = 0x01;\n" +
				"		STACK = PRIVATE {\n" +
				"			SYS_SIZE = 1024;\n" +
				"		};\n" +
				"		RESOURCE =  myRes2 ;\n" +
				"    };\n" +
				"    \n" +
				"    RESOURCE myRes { RESOURCEPROPERTY = STANDARD; };\n" +
				"    RESOURCE myRes2 { RESOURCEPROPERTY = STANDARD; };\n" +
				"\n" +
				"    COUNTER Counter1;\n" +
				"\n" +
				"    ALARM AlarmTask2 {\n" +
				"                COUNTER = Counter1 ;\n" +
				"                ACTION = ACTIVATETASK { TASK =  Task2 ; };\n" +
				"    };\n" +
				"    ALARM AlarmTask3 {\n" +
				"                COUNTER =  Counter1 ;\n" +
				"                ACTION = ACTIVATETASK { TASK =  Task3 ; };\n" +
				"    };\n" +
				"    ALARM AlarmTask4 {\n" +
				"                COUNTER =  Counter1 ;\n" +
				"                ACTION = ACTIVATETASK { TASK = Task4; };\n" +
				"    };\n" +
				"\n" +
				"};\n";
		commonWriterTest(test, 1);
	}	
}
