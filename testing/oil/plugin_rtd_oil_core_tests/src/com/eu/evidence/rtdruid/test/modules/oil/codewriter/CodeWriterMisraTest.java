package com.eu.evidence.rtdruid.test.modules.oil.codewriter;

import org.junit.Test;


public class CodeWriterMisraTest extends AbstractCodeWriterTest {
	
	
	@Test public void testConf_bcc1() {
	    final String text = "CPU test_application {\n" +
	    		"\n" +
	    		"	OS EE {\n" +
	    		"		EE_OPT = \"DEBUG\";\n" +
	    		"		EE_OPT = \"NODEPS\";\n" +
	    		"		EE_OPT = \"__ASSERT__\";\n" +
	    		"		EE_OPT = \"__USE_LEDS__\";\n" +
	    		"		EE_OPT = \"__USE_BUTTONS__\";\n" +
	    		"\n" +
	    		"		CPU_DATA = PPCE200ZX {\n" +
	    		"			MODEL = E200Z7;\n" +
	    		"			APP_SRC = \"main.c\";\n" +
	    		"			MULTI_STACK = FALSE;\n" +
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
	    		"//		ORTI_SECTIONS = ALL;\n" +
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
	    		"		STACK = SHARED;\n" +
	    		"		RESOURCE = MyResource;\n" +
	    		"		EVENT = MyEvent;\n" +
	    		"	};\n" +
	    		"	EVENT MyEvent;\n" +
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
	    		"		AUTOSTART = FALSE;\n" +
	    		"	};\n" +
	    		"\n" +
	    		"	OS EE { KERNEL_TYPE = BCC1; };\n" +
	    		"	TASK Task1 { SCHEDULE = NON; };\n" +
	    		"	TASK Task2 { ACTIVATION = 1; };\n" +
	    		"};";
		commonWriterTest(text, 1);
	}
	@Test public void testConf_bcc2() {
	    final String text = "CPU test_application {\n" +
				"\n" +
				"	OS EE {\n" +
				"		EE_OPT = \"DEBUG\";\n" +
				"		EE_OPT = \"NODEPS\";\n" +
				"		EE_OPT = \"__ASSERT__\";\n" +
				"		EE_OPT = \"__USE_LEDS__\";\n" +
				"		EE_OPT = \"__USE_BUTTONS__\";\n" +
				"\n" +
				"		CPU_DATA = PPCE200ZX {\n" +
				"			MODEL = E200Z7;\n" +
				"			APP_SRC = \"main.c\";\n" +
				"			MULTI_STACK = FALSE;\n" +
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
				"//		ORTI_SECTIONS = ALL;\n" +
				"	};\n" +
				"\n" +
				"	TASK Task1 {\n" +
				"		PRIORITY = 0x01;\n" +
				"		AUTOSTART = FALSE;\n" +
				"		STACK = SHARED;\n" +
				"		ACTIVATION = 1;\n" +
				"	};\n" +
				"\n" +
				"	TASK Task2 {\n" +
				"		PRIORITY = 0x02;\n" +
				"		SCHEDULE = FULL;\n" +
				"		AUTOSTART = TRUE;\n" +
				"		STACK = SHARED;\n" +
				"	};\n" +
				"\n" +
				"	OS EE { EE_OPT = \"MYSCHEDULE\"; KERNEL_TYPE = BCC2; };\n" +
				"	TASK Task1 { SCHEDULE = NON; };\n" +
				"	TASK Task2 { ACTIVATION = 6; };\n" +
				"};";
		commonWriterTest(text, 1);
	}
	@Test public void testConf_ecc1() {
	    final String text = "CPU test_application {\n" +
				"\n" +
				"	OS EE {\n" +
				"		EE_OPT = \"DEBUG\";\n" +
				"		EE_OPT = \"NODEPS\";\n" +
				"		EE_OPT = \"__ASSERT__\";\n" +
				"		EE_OPT = \"__USE_LEDS__\";\n" +
				"		EE_OPT = \"__USE_BUTTONS__\";\n" +
				"\n" +
				"		CPU_DATA = PPCE200ZX {\n" +
				"			MODEL = E200Z7;\n" +
				"			APP_SRC = \"main.c\";\n" +
				"			MULTI_STACK = TRUE {\n" +
				"				IRQ_STACK = TRUE {\n" +
				"					SYS_SIZE = 512;\n" +
				"				};\n" +
				"			};\n" +
				"			SYS_STACK_SIZE = 2048;\n" +
				"			VLE = TRUE;\n" +
				"		};\n" +
				"\n" +
				"		MCU_DATA = PPCE200ZX {\n" +
				"			MODEL = MPC5674F;\n" +
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
				"		AUTOSTART = TRUE {" +
				"			ALARMTIME = 1;\n" +
				"			CYCLETIME = 1;\n" +
				"		};\n" +
				"	};\n" +
				"\n" +
				"	OS EE { KERNEL_TYPE = ECC1; };\n" +
				"	TASK Task1 { SCHEDULE = NON; };\n" +
				"	TASK Task2 { ACTIVATION = 1; };\n" +
				"};";
		commonWriterTest(text, 1);
	}
	@Test public void testConf_ecc2() {
	    final String text = "CPU test_application {\n" +
				"\n" +
				"	OS EE {\n" +
				"		EE_OPT = \"DEBUG\";\n" +
				"		EE_OPT = \"NODEPS\";\n" +
				"		EE_OPT = \"__ASSERT__\";\n" +
				"		EE_OPT = \"__USE_LEDS__\";\n" +
				"		EE_OPT = \"__USE_BUTTONS__\";\n" +
				"\n" +
				"		CPU_DATA = PPCE200ZX {\n" +
				"			MODEL = E200Z7;\n" +
				"			APP_SRC = \"main.c\";\n" +
				"			MULTI_STACK = TRUE;\n" +
				"		};\n" +
				"\n" +
				"		MCU_DATA = PPCE200ZX {\n" +
				"			MODEL = MPC5674F;\n" +
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
				"//		ORTI_SECTIONS = ALL;\n" +
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
				"		AUTOSTART = TRUE {" +
				"			ALARMTIME = 1;\n" +
				"			CYCLETIME = 1;\n" +
				"		};\n" +
				"	};\n" +
				"\n" +
				"	OS EE { KERNEL_TYPE = ECC2; };\n" +
				"	TASK Task1 { SCHEDULE = NON; };\n" +
				"	TASK Task2 { ACTIVATION = 1; };\n" +
				"};";
		commonWriterTest(text, 1);
	}
	@Test public void testConf_fp() {
	    final String text = "CPU test_application {\n" +
				"\n" +
				"	OS EE {\n" +
				"		EE_OPT = \"DEBUG\";\n" +
				"		EE_OPT = \"NODEPS\";\n" +
				"		EE_OPT = \"__ASSERT__\";\n" +
				"		EE_OPT = \"__USE_LEDS__\";\n" +
				"		EE_OPT = \"__USE_BUTTONS__\";\n" +
				"\n" +
				"		CPU_DATA = PPCE200ZX {\n" +
				"			MODEL = E200Z7;\n" +
				"			APP_SRC = \"main.c\";\n" +
				"			MULTI_STACK = FALSE;\n" +
				"		};\n" +
				"\n" +
				"		MCU_DATA = PPCE200ZX {\n" +
				"			MODEL = MPC5674F;\n" +
				"		};\n" +
				"\n" +
				"		USERESSCHEDULER = FALSE;\n" +
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
				"		AUTOSTART = FALSE;\n" +
				"		STACK = SHARED;\n" +
				"		RESOURCE = MyResource;\n" +
				"	};\n" +
				"\n" +
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
				"		/* Autstart is not supported on FP kernel! */\n" +
				"		AUTOSTART = FALSE;\n" +
				"	};\n" +
				"\n" +
				"	OS EE { KERNEL_TYPE = FP; };\n" +
				"	TASK Task1 { SCHEDULE = NON; };\n" +
				"	TASK Task2 { ACTIVATION = 1; };\n" +
				"};";
		commonWriterTest(text, 1);
	}
	@Test public void testConf_mp_bcc1() {
	    final String text = "CPU test_application {\n" +
				"\n" +
				"	OS EE {\n" +
				"		EE_OPT = \"DEBUG\";\n" +
				"		EE_OPT = \"NODEPS\";\n" +
				"		EE_OPT = \"__ASSERT__\";\n" +
				"		EE_OPT = \"__USE_LEDS__\";\n" +
				"		EE_OPT = \"__USE_BUTTONS__\";\n" +
				"\n" +
				"		MASTER_CPU = \"master\";\n" +
				"\n" +
				"		CPU_DATA = PPCE200ZX {\n" +
				"			ID = \"master\";\n" +
				"			MODEL = E200Z6;\n" +
				"			APP_SRC = \"main.c\";\n" +
				"			MULTI_STACK = FALSE;\n" +
				"			VLE = TRUE;\n" +
				"		};\n" +
				"\n" +
				"		CPU_DATA = PPCE200ZX {\n" +
				"			ID = \"slave\";\n" +
				"			MODEL = E200Z0;\n" +
				"			APP_SRC = \"main.c\";\n" +
				"			MULTI_STACK = FALSE;\n" +
				"			VLE = TRUE;\n" +
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
				"\n" +
				"//		ORTI_SECTIONS = ALL;\n" +
				"		KERNEL_TYPE = BCC1;\n" +
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


}
