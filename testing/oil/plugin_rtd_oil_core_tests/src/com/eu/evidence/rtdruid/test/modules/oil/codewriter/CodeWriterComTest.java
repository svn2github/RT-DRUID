package com.eu.evidence.rtdruid.test.modules.oil.codewriter;

import org.junit.Test;

public class CodeWriterComTest extends AbstractCodeWriterTest {

	@Test
	public void testcortex_com_1() {
	    final String text =
		"CPU mySystem {\n" +
				"\n" +
				"	OS EE {\n" +
				"		EE_OPT = \"DEBUG\";\n" +
				"\n" +
				"		CPU_DATA = CORTEX_MX {\n" +
				"			MODEL = M0;\n" +
				"			APP_SRC = \"code.c\";\n" +
				"			APP_SRC = \"initosekcom.c\";\n" +
				"			JLINK = TRUE;\n" +
				"			COMPILER_TYPE = IAR; \n" +
				"			MULTI_STACK = FALSE;\n" +
				"		};\n" +
				"\n" +
				"		MCU_DATA = LPCXPRESSO {\n" +
				"			MODEL = LPC12xx;\n" +
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
				"\n" +
				"		KERNEL_TYPE = FP;\n" +
				"\n" +
				"		EE_OPT = \"__ADD_LIBS__\";\n" +
				"		LIB = ENABLE {\n" +
				"			NAME = \"CMSIS\";\n" +
				"		};\n" +
				"		EE_OPT = \"__USE_LPC12XX_CMSIS_V2__\";\n" +
				"		EE_OPT = \"__USE_CMSIS_IOCON__\";\n" +
				"		EE_OPT = \"__USE_CMSIS_SYSCTRL__\";\n" +
				"		EE_OPT = \"__USE_CMSIS_GPIO__\";\n" +
				"		\n" +
				"		\n" +
//				"		EE_OPT = \"__COM_CCCA__\";\n" +
				"	};\n" +
				"	\n" +
				"	COM myCom {\n" +
				"		COMERRORHOOK = FALSE;\n" +
				"		COMUSEGETSERVICEID =FALSE;\n" +
				"		COMUSEPARAMETERACCESS = FALSE; \n" +
				"		COMSTARTCOMEXTENSION = FALSE; \n" +
				"		COMAPPMODE = \"EE_COM_MODE_A\"; \n" +
				"		COMSTATUS = COMSTANDARD;\n" +
				"		COMTYPE = CCCA;\n" +
				"	};\n" +
				"	\n" +
				"	TASK Task0 {\n" +
				"		PRIORITY = 0x01; \n" +
				"		AUTOSTART = FALSE;\n" +
				"		ACTIVATION = 1;\n" +
				"		STACK = SHARED;\n" +
				"		RESOURCE = EE_MUTEX_COM_MSG;\n" +
				"		MESSAGE = ABS;\n" +
				"	};\n" +
				"	TASK Task1 {\n" +
				"		PRIORITY = 0x03; \n" +
				"		AUTOSTART = FALSE;\n" +
				"		ACTIVATION = 1;\n" +
				"		STACK = SHARED;\n" +
				"		RESOURCE = EE_MUTEX_COM_MSG;\n" +
				"		MESSAGE = RECEIVER1;\n" +
				"	};\n" +
				"	TASK Task2 {\n" +
				"		PRIORITY = 0x03; \n" +
				"		AUTOSTART = FALSE;\n" +
				"		ACTIVATION = 1;\n" +
				"		STACK = SHARED;\n" +
				"		RESOURCE = EE_MUTEX_COM_MSG;\n" +
				"		MESSAGE = RECEIVER2;\n" +
				"	};\n" +
				"	TASK Task3 {\n" +
				"		PRIORITY = 0x03; \n" +
				"		AUTOSTART = FALSE;\n" +
				"		ACTIVATION = 1;\n" +
				"		STACK = SHARED;\n" +
				"		RESOURCE = EE_MUTEX_COM_MSG;\n" +
				"		MESSAGE = RECEIVER2;\n" +
				"	};\n" +
				"	\n" +
				"	COUNTER myCounter {\n" +
				"		MAXALLOWEDVALUE = 65535;\n" +
				"		TICKSPERBASE    = 1;\n" +
				"		MINCYCLE        = 1;\n" +
				"	};\n" +
				"\n" +
				"	ALARM AlarmTask0 {\n" +
				"		COUNTER = myCounter;\n" +
				"		ACTION = ACTIVATETASK { TASK = Task0; };\n" +
				"	};\n" +
				"	\n" +
				"	RESOURCE EE_MUTEX_COM_MSG { RESOURCEPROPERTY = STANDARD; };\n" +
				"\n" +
				"	MESSAGE ABS {\n" +
				"		MESSAGEPROPERTY = SEND_STATIC_INTERNAL {\n" +
				"			CDATATYPE = \"EE_UINT32\";\n" +
				"		};\n" +
				"		NOTIFICATION = NONE;\n" +
				"	};\n" +
				"	\n" +
				"	MESSAGE RECEIVER1 {\n" +
				"		MESSAGEPROPERTY = RECEIVE_UNQUEUED_INTERNAL {\n" +
				"			SENDINGMESSAGE = ABS;\n" +
				"			FILTER = ALWAYS;\n" +
				"			INITIALVALUE = 0;\n" +
				"		};\n" +
				"		NOTIFICATION = ACTIVATETASK { TASK = Task1; }; \n" +
				"	};\n" +
				"	\n" +
				"	MESSAGE RECEIVER2 {\n" +
				"		MESSAGEPROPERTY = RECEIVE_UNQUEUED_INTERNAL {\n" +
				"			SENDINGMESSAGE = ABS;\n" +
				"			FILTER = ALWAYS;\n" +
				"			INITIALVALUE = 0;\n" +
				"		};\n" +
				"		NOTIFICATION = COMCALLBACK { \n" +
				"			CALLBACKROUTINENAME = \"callback\"; \n" +
				"			MESSAGE = RECEIVER2;\n" +
				"		};\n" +
				"	};\n" +
				"};";
//		DefaultTestResult res = 
				commonWriterTest(text, 1);
//		System.out.println(Vt2StringUtilities.explodeOilVar(Vt2StringUtilities.varTreeToStringErtd(res.vt)));
	}

	@Test
	public void testcortex_com_2() {
	    final String text =
		"CPU mySystem {\n" +
				"\n" +
				"	OS EE {\n" +
				"		EE_OPT = \"DEBUG\";\n" +
			"\n" +
				"		CPU_DATA = CORTEX_MX {\n" +
				"			MODEL = M0;\n" +
				"			APP_SRC = \"code.c\";\n" +
				"			APP_SRC = \"initosekcom.c\";\n" +
				"			JLINK = TRUE;\n" +
				"			COMPILER_TYPE = IAR; \n" +
				"			MULTI_STACK = FALSE;\n" +
				"		};\n" +
				"\n" +
				"		MCU_DATA = LPCXPRESSO {\n" +
				"			MODEL = LPC12xx;\n" +
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
				"\n" +
				"		KERNEL_TYPE = FP;\n" +
				"\n" +
				"		EE_OPT = \"__ADD_LIBS__\";\n" +
				"		LIB = ENABLE {\n" +
				"			NAME = \"CMSIS\";\n" +
				"		};\n" +
				"		EE_OPT = \"__USE_LPC12XX_CMSIS_V2__\";\n" +
				"		EE_OPT = \"__USE_CMSIS_IOCON__\";\n" +
				"		EE_OPT = \"__USE_CMSIS_SYSCTRL__\";\n" +
				"		EE_OPT = \"__USE_CMSIS_GPIO__\";\n" +
				"		\n" +
				"		\n" +
//				"		EE_OPT = \"__COM_CCCA__\";\n" +
				"	};\n" +
				"	\n" +
				"	COM myCom {\n" +
				"		COMERRORHOOK = FALSE;\n" +
				"		COMUSEGETSERVICEID =FALSE;\n" +
				"		COMUSEPARAMETERACCESS = FALSE; \n" +
				"		COMSTARTCOMEXTENSION = FALSE; \n" +
				"		COMAPPMODE = \"EE_COM_MODE_A\"; \n" +
				"		COMSTATUS = COMSTANDARD;\n" +
				"		COMTYPE = CCCA;\n" +
				"	};\n" +
				"	\n" +
				"	TASK Task0 {\n" +
				"		PRIORITY = 0x01; \n" +
				"		AUTOSTART = FALSE;\n" +
				"		ACTIVATION = 1;\n" +
				"		STACK = SHARED;\n" +
				"		RESOURCE = EE_MUTEX_COM_MSG;\n" +
				"		MESSAGE = ABS;\n" +
				"	};\n" +
				"	TASK Task1 {\n" +
				"		PRIORITY = 0x03; \n" +
				"		AUTOSTART = FALSE;\n" +
				"		ACTIVATION = 1;\n" +
				"		STACK = SHARED;\n" +
				"		RESOURCE = EE_MUTEX_COM_MSG;\n" +
				"		MESSAGE = RECEIVER1;\n" +
				"	};\n" +
				"	TASK Task2 {\n" +
				"		PRIORITY = 0x03; \n" +
				"		AUTOSTART = FALSE;\n" +
				"		ACTIVATION = 1;\n" +
				"		STACK = SHARED;\n" +
				"		RESOURCE = EE_MUTEX_COM_MSG;\n" +
				"		MESSAGE = RECEIVER2;\n" +
				"	};\n" +
				"	TASK Task3 {\n" +
				"		PRIORITY = 0x03; \n" +
				"		AUTOSTART = FALSE;\n" +
				"		ACTIVATION = 1;\n" +
				"		STACK = SHARED;\n" +
				"		RESOURCE = EE_MUTEX_COM_MSG;\n" +
				"		MESSAGE = RECEIVER2;\n" +
				"	};\n" +
				"	\n" +
				"	COUNTER myCounter {\n" +
				"		MAXALLOWEDVALUE = 65535;\n" +
				"		TICKSPERBASE    = 1;\n" +
				"		MINCYCLE        = 1;\n" +
				"	};\n" +
				"\n" +
				"	ALARM AlarmTask0 {\n" +
				"		COUNTER = myCounter;\n" +
				"		ACTION = ACTIVATETASK { TASK = Task0; };\n" +
				"	};\n" +
				"	\n" +
				"	RESOURCE EE_MUTEX_COM_MSG { RESOURCEPROPERTY = STANDARD; };\n" +
				"\n" +
				"	MESSAGE ABS {\n" +
				"		MESSAGEPROPERTY = SEND_STATIC_INTERNAL {\n" +
				"			CDATATYPE = \"unsigned char\";\n" +
				"		};\n" +
				"		NOTIFICATION = NONE;\n" +
				"	};\n" +
				"	\n" +
				"	MESSAGE RECEIVER1 {\n" +
				"		MESSAGEPROPERTY = RECEIVE_UNQUEUED_INTERNAL {\n" +
				"			SENDINGMESSAGE = ABS;\n" +
				"			FILTER = ALWAYS;\n" +
				"			INITIALVALUE = 0;\n" +
				"		};\n" +
				"		NOTIFICATION = ACTIVATETASK { TASK = Task1; }; \n" +
				"	};\n" +
				"	\n" +
				"	MESSAGE RECEIVER2 {\n" +
				"		MESSAGEPROPERTY = RECEIVE_UNQUEUED_INTERNAL {\n" +
				"			SENDINGMESSAGE = ABS;\n" +
				"			FILTER = ALWAYS;\n" +
				"			INITIALVALUE = 0;\n" +
				"		};\n" +
				"		NOTIFICATION = COMCALLBACK { \n" +
				"			CALLBACKROUTINENAME = \"callback\"; \n" +
				"			MESSAGE = RECEIVER2;\n" +
				"		};\n" +
				"	};\n" +
				"};";
//		DefaultTestResult res = 
				commonWriterTest(text, 1);
//		System.out.println(Vt2StringUtilities.explodeOilVar(Vt2StringUtilities.varTreeToStringErtd(res.vt)));
	}

	@Test
	public void testcortex_com_3() {
	    final String text =
		"CPU mySystem {\n" +
				"\n" +
				"	OS EE {\n" +
				"		EE_OPT = \"DEBUG\";\n" +
				"\n" +
				"		CPU_DATA = CORTEX_MX {\n" +
				"			MODEL = M0;\n" +
				"			APP_SRC = \"code.c\";\n" +
				"			APP_SRC = \"initosekcom.c\";\n" +
				"			JLINK = TRUE;\n" +
				"			COMPILER_TYPE = IAR; \n" +
				"			MULTI_STACK = FALSE;\n" +
				"		};\n" +
				"\n" +
				"		MCU_DATA = LPCXPRESSO {\n" +
				"			MODEL = LPC12xx;\n" +
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
				"\n" +
				"		KERNEL_TYPE = FP;\n" +
				"\n" +
				"		EE_OPT = \"__ADD_LIBS__\";\n" +
				"		LIB = ENABLE {\n" +
				"			NAME = \"CMSIS\";\n" +
				"		};\n" +
				"		EE_OPT = \"__USE_LPC12XX_CMSIS_V2__\";\n" +
				"		EE_OPT = \"__USE_CMSIS_IOCON__\";\n" +
				"		EE_OPT = \"__USE_CMSIS_SYSCTRL__\";\n" +
				"		EE_OPT = \"__USE_CMSIS_GPIO__\";\n" +
				"		\n" +
				"		\n" +
//				"		EE_OPT = \"__COM_CCCA__\";\n" +
				"	};\n" +
				"	\n" +
				"	COM myCom {\n" +
				"		COMERRORHOOK = FALSE;\n" +
				"		COMUSEGETSERVICEID =FALSE;\n" +
				"		COMUSEPARAMETERACCESS = FALSE; \n" +
				"		COMSTARTCOMEXTENSION = FALSE; \n" +
				"		COMAPPMODE = \"EE_COM_MODE_A\"; \n" +
				"		COMSTATUS = COMSTANDARD;\n" +
				"		COMTYPE = CCCA;\n" +
				"	};\n" +
				"	\n" +
				"	TASK Task0 {\n" +
				"		PRIORITY = 0x01; \n" +
				"		AUTOSTART = FALSE;\n" +
				"		ACTIVATION = 1;\n" +
				"		STACK = SHARED;\n" +
				"		RESOURCE = EE_MUTEX_COM_MSG;\n" +
				"		MESSAGE = ABS;\n" +
				"	};\n" +
				"	TASK Task1 {\n" +
				"		PRIORITY = 0x03; \n" +
				"		AUTOSTART = FALSE;\n" +
				"		ACTIVATION = 1;\n" +
				"		STACK = SHARED;\n" +
				"		RESOURCE = EE_MUTEX_COM_MSG;\n" +
				"		MESSAGE = RECEIVER1;\n" +
				"	};\n" +
				"	TASK Task2 {\n" +
				"		PRIORITY = 0x03; \n" +
				"		AUTOSTART = FALSE;\n" +
				"		ACTIVATION = 1;\n" +
				"		STACK = SHARED;\n" +
				"		RESOURCE = EE_MUTEX_COM_MSG;\n" +
				"		MESSAGE = RECEIVER2;\n" +
				"	};\n" +
				"	TASK Task3 {\n" +
				"		PRIORITY = 0x03; \n" +
				"		AUTOSTART = FALSE;\n" +
				"		ACTIVATION = 1;\n" +
				"		STACK = SHARED;\n" +
				"		RESOURCE = EE_MUTEX_COM_MSG;\n" +
				"		MESSAGE = RECEIVER2;\n" +
				"	};\n" +
				"	\n" +
				"	COUNTER myCounter {\n" +
				"		MAXALLOWEDVALUE = 65535;\n" +
				"		TICKSPERBASE    = 1;\n" +
				"		MINCYCLE        = 1;\n" +
				"	};\n" +
				"\n" +
				"	ALARM AlarmTask0 {\n" +
				"		COUNTER = myCounter;\n" +
				"		ACTION = ACTIVATETASK { TASK = Task0; };\n" +
				"	};\n" +
				"	\n" +
				"	RESOURCE EE_MUTEX_COM_MSG { RESOURCEPROPERTY = STANDARD; };\n" +
				"\n" +
				"	MESSAGE ABS {\n" +
				"		MESSAGEPROPERTY = SEND_STATIC_INTERNAL {\n" +
				"			CDATATYPE = \"EE_UINT32\";\n" +
				"		};\n" +
				"		NOTIFICATION = NONE;\n" +
				"	};\n" +
				"	\n" +
				"	MESSAGE RECEIVER1 {\n" +
				"		MESSAGEPROPERTY = RECEIVE_UNQUEUED_INTERNAL {\n" +
				"			SENDINGMESSAGE = ABS;\n" +
				"			FILTER = ALWAYS;\n" +
				"			INITIALVALUE = 0x1;\n" +
				"		};\n" +
				"		NOTIFICATION = ACTIVATETASK { TASK = Task1; }; \n" +
				"	};\n" +
				"	\n" +
				"	MESSAGE RECEIVER2 {\n" +
				"		MESSAGEPROPERTY = RECEIVE_UNQUEUED_INTERNAL {\n" +
				"			SENDINGMESSAGE = ABS;\n" +
				"			FILTER = ALWAYS;\n" +
				"			INITIALVALUE = 0;\n" +
				"		};\n" +
				"		NOTIFICATION = COMCALLBACK { \n" +
				"			CALLBACKROUTINENAME = \"callback\"; \n" +
				"			MESSAGE = RECEIVER2;\n" +
				"		};\n" +
				"	};\n" +
				"};";
//		DefaultTestResult res = 
				commonWriterTest(text, 1);
//		System.out.println(Vt2StringUtilities.explodeOilVar(Vt2StringUtilities.varTreeToStringErtd(res.vt)));
	}

	@Test
	public void testcortex_com_4() {
	    final String text =
		"CPU mySystem {\n" +
				"\n" +
				"	OS EE {\n" +
				"		EE_OPT = \"DEBUG\";\n" +
				"\n" +
				"		CPU_DATA = CORTEX_MX {\n" +
				"			MODEL = M0;\n" +
				"			APP_SRC = \"code.c\";\n" +
				"			APP_SRC = \"initosekcom.c\";\n" +
				"			JLINK = TRUE;\n" +
				"			COMPILER_TYPE = IAR; \n" +
				"			MULTI_STACK = FALSE;\n" +
				"		};\n" +
				"\n" +
				"		MCU_DATA = LPCXPRESSO {\n" +
				"			MODEL = LPC12xx;\n" +
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
				"\n" +
				"		KERNEL_TYPE = FP;\n" +
				"\n" +
				"		EE_OPT = \"__ADD_LIBS__\";\n" +
				"		LIB = ENABLE {\n" +
				"			NAME = \"CMSIS\";\n" +
				"		};\n" +
				"		EE_OPT = \"__USE_LPC12XX_CMSIS_V2__\";\n" +
				"		EE_OPT = \"__USE_CMSIS_IOCON__\";\n" +
				"		EE_OPT = \"__USE_CMSIS_SYSCTRL__\";\n" +
				"		EE_OPT = \"__USE_CMSIS_GPIO__\";\n" +
				"		\n" +
				"		\n" +
//				"		EE_OPT = \"__COM_CCCA__\";\n" +
				"	};\n" +
				"	\n" +
				"	COM myCom {\n" +
				"		COMERRORHOOK = FALSE;\n" +
				"		COMUSEGETSERVICEID =FALSE;\n" +
				"		COMUSEPARAMETERACCESS = FALSE; \n" +
				"		COMSTARTCOMEXTENSION = TRUE; \n" +
				"		COMAPPMODE = \"EE_COM_MODE_A\"; \n" +
				"		COMSTATUS = COMEXTENDED;\n" +
				"		COMTYPE = CCCA;\n" +
				"	};\n" +
				"	\n" +
				"	TASK Task0 {\n" +
				"		PRIORITY = 0x01; \n" +
				"		AUTOSTART = FALSE;\n" +
				"		ACTIVATION = 1;\n" +
				"		STACK = SHARED;\n" +
				"		RESOURCE = EE_MUTEX_COM_MSG;\n" +
				"		MESSAGE = ABS;\n" +
				"	};\n" +
				"	TASK Task1 {\n" +
				"		PRIORITY = 0x03; \n" +
				"		AUTOSTART = FALSE;\n" +
				"		ACTIVATION = 1;\n" +
				"		STACK = SHARED;\n" +
				"		RESOURCE = EE_MUTEX_COM_MSG;\n" +
				"		MESSAGE = RECEIVER1;\n" +
				"	};\n" +
				"	TASK Task2 {\n" +
				"		PRIORITY = 0x03; \n" +
				"		AUTOSTART = FALSE;\n" +
				"		ACTIVATION = 1;\n" +
				"		STACK = SHARED;\n" +
				"		RESOURCE = EE_MUTEX_COM_MSG;\n" +
				"		MESSAGE = RECEIVER2;\n" +
				"	};\n" +
				"	TASK Task3 {\n" +
				"		PRIORITY = 0x03; \n" +
				"		AUTOSTART = FALSE;\n" +
				"		ACTIVATION = 1;\n" +
				"		STACK = SHARED;\n" +
				"		RESOURCE = EE_MUTEX_COM_MSG;\n" +
				"		MESSAGE = RECEIVER2;\n" +
				"	};\n" +
				"	\n" +
				"	COUNTER myCounter {\n" +
				"		MAXALLOWEDVALUE = 65535;\n" +
				"		TICKSPERBASE    = 1;\n" +
				"		MINCYCLE        = 1;\n" +
				"	};\n" +
				"\n" +
				"	ALARM AlarmTask0 {\n" +
				"		COUNTER = myCounter;\n" +
				"		ACTION = ACTIVATETASK { TASK = Task0; };\n" +
				"	};\n" +
				"	\n" +
				"	RESOURCE EE_MUTEX_COM_MSG { RESOURCEPROPERTY = STANDARD; };\n" +
				"\n" +
				"	MESSAGE ABS {\n" +
				"		MESSAGEPROPERTY = SEND_STATIC_INTERNAL {\n" +
				"			CDATATYPE = \"EE_UINT32\";\n" +
				"		};\n" +
				"		NOTIFICATION = NONE;\n" +
				"	};\n" +
				"	\n" +
				"	MESSAGE RECEIVER1 {\n" +
				"		MESSAGEPROPERTY = RECEIVE_UNQUEUED_INTERNAL {\n" +
				"			SENDINGMESSAGE = ABS;\n" +
				"			FILTER = ALWAYS;\n" +
				"			INITIALVALUE = 0x1;\n" +
				"		};\n" +
				"		NOTIFICATION = ACTIVATETASK { TASK = Task1; }; \n" +
				"	};\n" +
				"	\n" +
				"	MESSAGE RECEIVER2 {\n" +
				"		MESSAGEPROPERTY = RECEIVE_UNQUEUED_INTERNAL {\n" +
				"			SENDINGMESSAGE = ABS;\n" +
				"			FILTER = ALWAYS;\n" +
				"			INITIALVALUE = 0;\n" +
				"		};\n" +
				"		NOTIFICATION = COMCALLBACK { \n" +
				"			CALLBACKROUTINENAME = \"callback\"; \n" +
				"			MESSAGE = RECEIVER2;\n" +
				"		};\n" +
				"	};\n" +
				"};";
//		DefaultTestResult res = 
				commonWriterTest(text, 1);
//		System.out.println(Vt2StringUtilities.explodeOilVar(Vt2StringUtilities.varTreeToStringErtd(res.vt)));
	}

	@Test
	public void testcortex_com_5() {
	    final String text =
		"CPU mySystem {\n" +
				"\n" +
				"	OS EE {\n" +
				"		EE_OPT = \"DEBUG\";\n" +
				"\n" +
				"		CPU_DATA = CORTEX_MX {\n" +
				"			MODEL = M0;\n" +
				"			APP_SRC = \"code.c\";\n" +
				"			APP_SRC = \"initosekcom.c\";\n" +
				"			JLINK = TRUE;\n" +
				"			COMPILER_TYPE = IAR; \n" +
				"			MULTI_STACK = FALSE;\n" +
				"		};\n" +
				"\n" +
				"		MCU_DATA = LPCXPRESSO {\n" +
				"			MODEL = LPC12xx;\n" +
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
				"\n" +
				"		KERNEL_TYPE = FP;\n" +
				"\n" +
				"		EE_OPT = \"__ADD_LIBS__\";\n" +
				"		LIB = ENABLE {\n" +
				"			NAME = \"CMSIS\";\n" +
				"		};\n" +
				"		EE_OPT = \"__USE_LPC12XX_CMSIS_V2__\";\n" +
				"		EE_OPT = \"__USE_CMSIS_IOCON__\";\n" +
				"		EE_OPT = \"__USE_CMSIS_SYSCTRL__\";\n" +
				"		EE_OPT = \"__USE_CMSIS_GPIO__\";\n" +
				"		\n" +
				"		\n" +
//				"		EE_OPT = \"__COM_CCCA__\";\n" +
				"	};\n" +
				"	\n" +
				"	COM myCom {\n" +
				"		COMERRORHOOK = FALSE;\n" +
				"		COMUSEGETSERVICEID =FALSE;\n" +
				"		COMUSEPARAMETERACCESS = FALSE; \n" +
				"		COMSTARTCOMEXTENSION = FALSE; \n" +
				"		COMAPPMODE = \"EE_COM_MODE_A\"; \n" +
				"		COMSTATUS = COMEXTENDED;\n" +
				"		COMTYPE = CCCA;\n" +
				"	};\n" +
				"	\n" +
				"	TASK Task0 {\n" +
				"		PRIORITY = 0x01; \n" +
				"		AUTOSTART = FALSE;\n" +
				"		ACTIVATION = 1;\n" +
				"		STACK = SHARED;\n" +
				"		RESOURCE = EE_MUTEX_COM_MSG;\n" +
				"		MESSAGE = ABS;\n" +
				"	};\n" +
				"	TASK Task1 {\n" +
				"		PRIORITY = 0x03; \n" +
				"		AUTOSTART = FALSE;\n" +
				"		ACTIVATION = 1;\n" +
				"		STACK = SHARED;\n" +
				"		RESOURCE = EE_MUTEX_COM_MSG;\n" +
				"		MESSAGE = RECEIVER1;\n" +
				"	};\n" +
				"	TASK Task2 {\n" +
				"		PRIORITY = 0x03; \n" +
				"		AUTOSTART = FALSE;\n" +
				"		ACTIVATION = 1;\n" +
				"		STACK = SHARED;\n" +
				"		RESOURCE = EE_MUTEX_COM_MSG;\n" +
				"		MESSAGE = RECEIVER2;\n" +
				"	};\n" +
				"	TASK Task3 {\n" +
				"		PRIORITY = 0x03; \n" +
				"		AUTOSTART = FALSE;\n" +
				"		ACTIVATION = 1;\n" +
				"		STACK = SHARED;\n" +
				"		RESOURCE = EE_MUTEX_COM_MSG;\n" +
				"		MESSAGE = RECEIVER2;\n" +
				"	};\n" +
				"	\n" +
				"	COUNTER myCounter {\n" +
				"		MAXALLOWEDVALUE = 65535;\n" +
				"		TICKSPERBASE    = 1;\n" +
				"		MINCYCLE        = 1;\n" +
				"	};\n" +
				"\n" +
				"	ALARM AlarmTask0 {\n" +
				"		COUNTER = myCounter;\n" +
				"		ACTION = ACTIVATETASK { TASK = Task0; };\n" +
				"	};\n" +
				"	\n" +
				"	RESOURCE EE_MUTEX_COM_MSG { RESOURCEPROPERTY = STANDARD; };\n" +
				"\n" +
				"	MESSAGE ABS {\n" +
				"		MESSAGEPROPERTY = SEND_STATIC_INTERNAL {\n" +
				"			CDATATYPE = \"EE_UINT32\";\n" +
				"		};\n" +
				"		NOTIFICATION = NONE;\n" +
				"	};\n" +
				"	\n" +
				"	MESSAGE RECEIVER1 {\n" +
				"		MESSAGEPROPERTY = RECEIVE_UNQUEUED_INTERNAL {\n" +
				"			SENDINGMESSAGE = ABS;\n" +
				"			FILTER = ALWAYS;\n" +
				"			INITIALVALUE = 0x1;\n" +
				"		};\n" +
				"		NOTIFICATION = ACTIVATETASK { TASK = Task1; }; \n" +
				"	};\n" +
				"	\n" +
				"	MESSAGE RECEIVER2 {\n" +
				"		MESSAGEPROPERTY = RECEIVE_UNQUEUED_INTERNAL {\n" +
				"			SENDINGMESSAGE = ABS;\n" +
				"			FILTER = ALWAYS;\n" +
				"			INITIALVALUE = 0;\n" +
				"		};\n" +
				"		NOTIFICATION = COMCALLBACK { \n" +
				"			CALLBACKROUTINENAME = \"callback\"; \n" +
				"			MESSAGE = RECEIVER2;\n" +
				"		};\n" +
				"	};\n" +
				"};";
//		DefaultTestResult res = 
				commonWriterTest(text, 1);
//		System.out.println(Vt2StringUtilities.explodeOilVar(Vt2StringUtilities.varTreeToStringErtd(res.vt)));
	}

	@Test
	public void testcortex_com_6() {
	    final String text =
		"CPU mySystem {\n" +
				"\n" +
				"	OS EE {\n" +
				"		EE_OPT = \"DEBUG\";\n" +
				"\n" +
				"		CPU_DATA = CORTEX_MX {\n" +
				"			MODEL = M0;\n" +
				"			APP_SRC = \"code.c\";\n" +
				"			APP_SRC = \"initosekcom.c\";\n" +
				"			JLINK = TRUE;\n" +
				"			COMPILER_TYPE = IAR; \n" +
				"			MULTI_STACK = FALSE;\n" +
				"		};\n" +
				"\n" +
				"		MCU_DATA = LPCXPRESSO {\n" +
				"			MODEL = LPC12xx;\n" +
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
				"\n" +
				"		KERNEL_TYPE = FP;\n" +
				"\n" +
				"		EE_OPT = \"__ADD_LIBS__\";\n" +
				"		LIB = ENABLE {\n" +
				"			NAME = \"CMSIS\";\n" +
				"		};\n" +
				"		EE_OPT = \"__USE_LPC12XX_CMSIS_V2__\";\n" +
				"		EE_OPT = \"__USE_CMSIS_IOCON__\";\n" +
				"		EE_OPT = \"__USE_CMSIS_SYSCTRL__\";\n" +
				"		EE_OPT = \"__USE_CMSIS_GPIO__\";\n" +
				"		\n" +
				"		\n" +
//				"		EE_OPT = \"__COM_CCCA__\";\n" +
				"	};\n" +
				"	\n" +
				"	COM myCom {\n" +
				"		COMERRORHOOK = TRUE;\n" +
				"		COMUSEGETSERVICEID =FALSE;\n" +
				"		COMUSEPARAMETERACCESS = FALSE; \n" +
				"		COMSTARTCOMEXTENSION = TRUE; \n" +
				"		COMAPPMODE = \"EE_COM_MODE_A\"; \n" +
				"		COMSTATUS = COMSTANDARD;\n" +
				"		COMTYPE = CCCA;\n" +
				"		INCLUDES = \"test.h\";\n" +
				"		INCLUDES = \"test.h\";\n" +
				"		INCLUDES = \"test2.h\";\n" +
				"	};\n" +
				"	\n" +
				"	TASK Task0 {\n" +
				"		PRIORITY = 0x01; \n" +
				"		AUTOSTART = FALSE;\n" +
				"		ACTIVATION = 1;\n" +
				"		STACK = SHARED;\n" +
				"		RESOURCE = EE_MUTEX_COM_MSG;\n" +
				"		MESSAGE = ABS;\n" +
				"	};\n" +
				"	TASK Task1 {\n" +
				"		PRIORITY = 0x03; \n" +
				"		AUTOSTART = FALSE;\n" +
				"		ACTIVATION = 1;\n" +
				"		STACK = SHARED;\n" +
				"		RESOURCE = EE_MUTEX_COM_MSG;\n" +
				"		MESSAGE = RECEIVER1;\n" +
				"	};\n" +
				"	TASK Task2 {\n" +
				"		PRIORITY = 0x03; \n" +
				"		AUTOSTART = FALSE;\n" +
				"		ACTIVATION = 1;\n" +
				"		STACK = SHARED;\n" +
				"		RESOURCE = EE_MUTEX_COM_MSG;\n" +
				"		MESSAGE = RECEIVER2;\n" +
				"	};\n" +
				"	TASK Task3 {\n" +
				"		PRIORITY = 0x03; \n" +
				"		AUTOSTART = FALSE;\n" +
				"		ACTIVATION = 1;\n" +
				"		STACK = SHARED;\n" +
				"		RESOURCE = EE_MUTEX_COM_MSG;\n" +
				"		MESSAGE = RECEIVER2;\n" +
				"	};\n" +
				"	\n" +
				"	COUNTER myCounter {\n" +
				"		MAXALLOWEDVALUE = 65535;\n" +
				"		TICKSPERBASE    = 1;\n" +
				"		MINCYCLE        = 1;\n" +
				"	};\n" +
				"\n" +
				"	ALARM AlarmTask0 {\n" +
				"		COUNTER = myCounter;\n" +
				"		ACTION = ACTIVATETASK { TASK = Task0; };\n" +
				"	};\n" +
				"	\n" +
				"	RESOURCE EE_MUTEX_COM_MSG { RESOURCEPROPERTY = STANDARD; };\n" +
				"\n" +
				"	MESSAGE ABS {\n" +
				"		MESSAGEPROPERTY = SEND_STATIC_INTERNAL {\n" +
				"			CDATATYPE = \"EE_UINT32\";\n" +
				"		};\n" +
				"		NOTIFICATION = NONE;\n" +
				"	};\n" +
				"	\n" +
				"	MESSAGE RECEIVER1 {\n" +
				"		MESSAGEPROPERTY = RECEIVE_UNQUEUED_INTERNAL {\n" +
				"			SENDINGMESSAGE = ABS;\n" +
				"			FILTER = ALWAYS;\n" +
				"			INITIALVALUE = 0x1;\n" +
				"		};\n" +
				"		NOTIFICATION = ACTIVATETASK { TASK = Task1; }; \n" +
				"	};\n" +
				"	\n" +
				"	MESSAGE RECEIVER2 {\n" +
				"		MESSAGEPROPERTY = RECEIVE_UNQUEUED_INTERNAL {\n" +
				"			SENDINGMESSAGE = ABS;\n" +
				"			FILTER = ALWAYS;\n" +
				"			INITIALVALUE = 0;\n" +
				"		};\n" +
				"		NOTIFICATION = COMCALLBACK { \n" +
				"			CALLBACKROUTINENAME = \"callback\"; \n" +
				"			MESSAGE = RECEIVER2;\n" +
				"		};\n" +
				"	};\n" +
				"};";
//		DefaultTestResult res = 
				commonWriterTest(text, 1);
//		System.out.println(Vt2StringUtilities.explodeOilVar(Vt2StringUtilities.varTreeToStringErtd(res.vt)));
	}

	
	@Test
	public void testcortex_com_cccb() {
	    final String text =

			"CPU mySystem {\n" +
			"\n" +
			"	OS myOs {\n" +
			"		EE_OPT = \"DEBUG\";\n" +
			"		/***************************************************/\n" +
			"		/* These symbols, ABS etc., should go into eecfg.h */\n" +
			"		/***************************************************/\n" +
			"		/*CFLAGS = \"-D ABS=0\";\n" +
			"		CFLAGS = \"-D RECEIVER1=1\";\n" +
			"		CFLAGS = \"-D RECEIVER2=2\";\n" +
			"		CFLAGS = \"-D EE_COM_N_MSG=3\";\n" +
			"		CFLAGS = \"-D EE_COM_N_MODE=1\";\n" +
			"		CFLAGS = \"-D EE_COM_MODE_A=0\";*/\n" +
			"		/***************************************************/\n" +
			"\n" +
			"\n" +
			"		CPU_DATA = CORTEX_MX {\n" +
			"			MODEL = M0;\n" +
			"			APP_SRC = \"code.c\";\n" +
			"			//APP_SRC = \"initosekcom.c\";\n" +
			"			//JLINK = TRUE;\n" +
			"			//COMPILER_TYPE = IAR;\n" +
			"			COMPILER_TYPE = KEIL; \n" +
			"			MULTI_STACK = FALSE;\n" +
			"		};\n" +
			"\n" +
			"		MCU_DATA = LPCXPRESSO {\n" +
			"			MODEL = LPC12xx;\n" +
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
			"		KERNEL_TYPE = FP;\n" +
			"\n" +
			"\n" +
			"		LIB = ENABLE {\n" +
			"			NAME = \"CMSIS\";\n" +
			"		};\n" +
			"		EE_OPT = \"__USE_LPC12XX_CMSIS_V2__\";\n" +
			"		/* Uncomment the following EE_OPT to include all library functions */\n" +
			"		/*EE_OPT = \"__USE_CMSIS_ALL__\";*/\n" +
			"		EE_OPT = \"__USE_CMSIS_IOCON__\";\n" +
			"		EE_OPT = \"__USE_CMSIS_SYSCTRL__\";\n" +
			"		EE_OPT = \"__USE_CMSIS_GPIO__\";\n" +
			"		\n" +
			"		EE_OPT = \"__ADD_LIBS__\";\n" +
			"		\n" +
			"		/*OSEK COM EE_OPT*/\n" +
			"		//EE_OPT = \"__COM_CCCB__\";\n" +
			"	};\n" +
			"	\n" +
			"	/* this is the OIL part for the task */\n" +
			"	TASK Task0 {\n" +
			"		PRIORITY = 0x03; \n" +
			"		AUTOSTART = FALSE;\n" +
			"		ACTIVATION = 1;    /* only one pending activation */\n" +
			"		STACK = SHARED;\n" +
			"		RESOURCE = EE_MUTEX_COM_MSG;\n" +
			"		MESSAGE = ABS;\n" +
			"	};\n" +
			"	/* this is the OIL part for the task */\n" +
			"	TASK Task1 {\n" +
			"		PRIORITY = 0x04; \n" +
			"		AUTOSTART = FALSE;\n" +
			"		ACTIVATION = 1;    /* only one pending activation */\n" +
			"		STACK = SHARED;\n" +
			"		RESOURCE = EE_MUTEX_COM_MSG;\n" +
			"		MESSAGE = RECEIVER2;\n" +
			"	};\n" +
			"	\n" +
			"	TASK Task2 {\n" +
			"		PRIORITY = 0x02; \n" +
			"		AUTOSTART = FALSE;\n" +
			"		ACTIVATION = 1;    /* only one pending activation */\n" +
			"		STACK = SHARED;\n" +
			"		RESOURCE = EE_MUTEX_COM_MSG;\n" +
			"		MESSAGE = RECEIVER1;\n" +
			"		\n" +
			"	};\n" +
			"	\n" +
			"	/* General purpose counter for all the needed alarms  */\n" +
			"	COUNTER myCounter {\n" +
			"		MAXALLOWEDVALUE = 65535;\n" +
			"		TICKSPERBASE    = 1;\n" +
			"		MINCYCLE        = 1;\n" +
			"	};\n" +
			"\n" +
			"	/* Alarm to that cyclically activate Kitt effect */\n" +
			"	ALARM AlarmTask0 {\n" +
			"		COUNTER = myCounter;\n" +
			"	    ACTION = ACTIVATETASK { TASK = Task0; };\n" +
			"	};\n" +
			"	\n" +
			"	ALARM AlarmTask1 {\n" +
			"		COUNTER = myCounter;\n" +
			"	    ACTION = ACTIVATETASK { TASK = Task1; };\n" +
			"	};\n" +
			"	\n" +
			"	RESOURCE EE_MUTEX_COM_MSG { RESOURCEPROPERTY = STANDARD; };\n" +
			"	\n" +
			"	/*   \n" +
			"	* OSEK COM sub-system properties.\n" +
			"	* Vedi \"OIL: OSEK Implementation Language Specification 2.5\", pag.31. \n" +
			"	*/\n" +
			"	\n" +
			"	COM myCom {\n" +
			"			COMERRORHOOK = FALSE;\n" +
			"			COMUSEGETSERVICEID =FALSE;\n" +
			"			COMUSEPARAMETERACCESS = FALSE; \n" +
			"			COMSTARTCOMEXTENSION = FALSE; \n" +
			"			COMAPPMODE = \"EE_COM_MODE_A\"; \n" +
			"			COMSTATUS = COMSTANDARD;\n" +
			"			\n" +
			"			COMTYPE = CCCB;\n" +
			"		};\n" +
			"	\n" +
			"	/*\n" +
			"	* Message definitions;\n" +
			"	*/\n" +
			"	\n" +
			"	MESSAGE ABS {\n" +
			"		MESSAGEPROPERTY = SEND_STATIC_INTERNAL {\n" +
			"			CDATATYPE = \"EE_UINT32\";\n" +
			"		};\n" +
			"		NOTIFICATION = NONE; /* In CCCB, there isn't any notification for message transmission.*/ \n" +
			"	};\n" +
			"	\n" +
			"	MESSAGE RECEIVER1 {\n" +
			"		MESSAGEPROPERTY = RECEIVE_UNQUEUED_INTERNAL {\n" +
			"			SENDINGMESSAGE = ABS;\n" +
			"			FILTER = ALWAYS;\n" +
			"			INITIALVALUE = 0;\n" +
			"		};\n" +
			"		NOTIFICATION = ACTIVATETASK { TASK = Task2; }; \n" +
			"	};\n" +
			"	\n" +
			"	MESSAGE RECEIVER2 {\n" +
			"		MESSAGEPROPERTY = RECEIVE_QUEUED_INTERNAL {\n" +
			"			SENDINGMESSAGE = ABS;\n" +
			"			FILTER = ALWAYS;\n" +
			"			INITIALVALUE = 0;\n" +
			"			QUEUESIZE = 2;\n" +
			"		};\n" +
			"		NOTIFICATION = FLAG { FLAGNAME = \"data_in\"; };\n" +
			"	};\n" +
			"\n" +
			"};";
//		DefaultTestResult res = 
				commonWriterTest(text, 1);
//		System.out.println(Vt2StringUtilities.explodeOilVar(Vt2StringUtilities.varTreeToStringErtd(res.vt)));
	}
	
	@Test
	public void testcortex_com_cccb_setEvent() {
	    final String text =

			"CPU mySystem {\n" +
			"\n" +
			"	OS myOs {\n" +
			"		EE_OPT = \"DEBUG\";\n" +
			"		CPU_DATA = CORTEX_MX {\n" +
			"			MODEL = M0;\n" +
			"			APP_SRC = \"code.c\";\n" +
			"			//APP_SRC = \"initosekcom.c\";\n" +
			"			//JLINK = TRUE;\n" +
			"			//COMPILER_TYPE = IAR;\n" +
			"			COMPILER_TYPE = KEIL; \n" +
			"			MULTI_STACK = FALSE;\n" +
			"		};\n" +
			"\n" +
			"		MCU_DATA = LPCXPRESSO {\n" +
			"			MODEL = LPC12xx;\n" +
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
			"		KERNEL_TYPE = FP;\n" +
			"\n" +
			"\n" +
			"		LIB = ENABLE {\n" +
			"			NAME = \"CMSIS\";\n" +
			"		};\n" +
			"		EE_OPT = \"__USE_LPC12XX_CMSIS_V2__\";\n" +
			"		/* Uncomment the following EE_OPT to include all library functions */\n" +
			"		/*EE_OPT = \"__USE_CMSIS_ALL__\";*/\n" +
			"		EE_OPT = \"__USE_CMSIS_IOCON__\";\n" +
			"		EE_OPT = \"__USE_CMSIS_SYSCTRL__\";\n" +
			"		EE_OPT = \"__USE_CMSIS_GPIO__\";\n" +
			"		\n" +
			"		EE_OPT = \"__ADD_LIBS__\";\n" +
			"		\n" +
			"		/*OSEK COM EE_OPT*/\n" +
			"		//EE_OPT = \"__COM_CCCB__\";\n" +
			"	};\n" +
			"	\n" +
			"	/* this is the OIL part for the task */\n" +
			"	TASK Task0 {\n" +
			"		PRIORITY = 0x03; \n" +
			"		AUTOSTART = FALSE;\n" +
			"		ACTIVATION = 1;    /* only one pending activation */\n" +
			"		STACK = SHARED;\n" +
			"		RESOURCE = EE_MUTEX_COM_MSG;\n" +
			"		MESSAGE = ABS;\n" +
			"	};\n" +
			"	/* this is the OIL part for the task */\n" +
			"	TASK Task1 {\n" +
			"		PRIORITY = 0x04; \n" +
			"		AUTOSTART = FALSE;\n" +
			"		ACTIVATION = 1;    /* only one pending activation */\n" +
			"		STACK = SHARED;\n" +
			"		RESOURCE = EE_MUTEX_COM_MSG;\n" +
			"		MESSAGE = RECEIVER2;\n" +
			"		EVENT = Event12;\n" +
			"		EVENT = Event22;\n" +
			"		EVENT = Event13;\n" +
			"		EVENT = Event23;\n" +

			"	};\n" +
			"	\n" +
			"	EVENT Event12 { MASK = AUTO; };\n" +
			"	EVENT Event22 { MASK = AUTO; };\n" +
			"	EVENT Event13 { MASK = AUTO; };\n" +
			"	EVENT Event23 { MASK = AUTO; };\n" +

			"	TASK Task2 {\n" +
			"		PRIORITY = 0x02; \n" +
			"		AUTOSTART = FALSE;\n" +
			"		ACTIVATION = 1;    /* only one pending activation */\n" +
			"		STACK = SHARED;\n" +
			"		RESOURCE = EE_MUTEX_COM_MSG;\n" +
			"		MESSAGE = RECEIVER1;\n" +
			"		\n" +
			"	};\n" +
			"	\n" +
			"	/* General purpose counter for all the needed alarms  */\n" +
			"	COUNTER myCounter {\n" +
			"		MAXALLOWEDVALUE = 65535;\n" +
			"		TICKSPERBASE    = 1;\n" +
			"		MINCYCLE        = 1;\n" +
			"	};\n" +
			"\n" +
			"	/* Alarm to that cyclically activate Kitt effect */\n" +
			"	ALARM AlarmTask0 {\n" +
			"		COUNTER = myCounter;\n" +
			"	    ACTION = ACTIVATETASK { TASK = Task0; };\n" +
			"	};\n" +
			"	\n" +
			"	ALARM AlarmTask1 {\n" +
			"		COUNTER = myCounter;\n" +
			"	    ACTION = ACTIVATETASK { TASK = Task1; };\n" +
			"	};\n" +
			"	\n" +
			"	RESOURCE EE_MUTEX_COM_MSG { RESOURCEPROPERTY = STANDARD; };\n" +
			"	\n" +
			"	/*   \n" +
			"	* OSEK COM sub-system properties.\n" +
			"	* Vedi \"OIL: OSEK Implementation Language Specification 2.5\", pag.31. \n" +
			"	*/\n" +
			"	\n" +
			"	COM myCom {\n" +
			"			COMERRORHOOK = FALSE;\n" +
			"			COMUSEGETSERVICEID =FALSE;\n" +
			"			COMUSEPARAMETERACCESS = FALSE; \n" +
			"			COMSTARTCOMEXTENSION = FALSE; \n" +
			"			COMAPPMODE = \"EE_COM_MODE_A\"; \n" +
			"			COMSTATUS = COMSTANDARD;\n" +
			"			\n" +
			"			COMTYPE = CCCB;\n" +
			"		};\n" +
			"	\n" +
			"	/*\n" +
			"	* Message definitions;\n" +
			"	*/\n" +
			"	\n" +
			"	MESSAGE ABS {\n" +
			"		MESSAGEPROPERTY = SEND_STATIC_INTERNAL {\n" +
			"			CDATATYPE = \"EE_UINT32\";\n" +
			"		};\n" +
			"		NOTIFICATION = NONE; /* In CCCB, there isn't any notification for message transmission.*/ \n" +
			"	};\n" +
			"	\n" +
			"	MESSAGE RECEIVER1 {\n" +
			"		MESSAGEPROPERTY = RECEIVE_UNQUEUED_INTERNAL {\n" +
			"			SENDINGMESSAGE = ABS;\n" +
			"			FILTER = ALWAYS;\n" +
			"			INITIALVALUE = 0;\n" +
			"		};\n" +
			"		NOTIFICATION = SETEVENT { TASK = Task1; EVENT = Event13; }; \n" +
			"	};\n" +
			"	MESSAGE RECEIVER3 {\n" +
			"		MESSAGEPROPERTY = RECEIVE_UNQUEUED_INTERNAL {\n" +
			"			SENDINGMESSAGE = ABS;\n" +
			"			FILTER = ALWAYS;\n" +
			"			INITIALVALUE = 0;\n" +
			"		};\n" +
			"		NOTIFICATION = SETEVENT { TASK = Task1; EVENT = Event12; }; \n" +
			"	};\n" +
			"	MESSAGE RECEIVER4 {\n" +
			"		MESSAGEPROPERTY = RECEIVE_UNQUEUED_INTERNAL {\n" +
			"			SENDINGMESSAGE = ABS;\n" +
			"			FILTER = ALWAYS;\n" +
			"			INITIALVALUE = 0;\n" +
			"		};\n" +
			"		NOTIFICATION = SETEVENT { TASK = Task1; EVENT = Event13; }; \n" +
			"	};\n" +
			"	\n" +
			"	MESSAGE RECEIVER2 {\n" +
			"		MESSAGEPROPERTY = RECEIVE_QUEUED_INTERNAL {\n" +
			"			SENDINGMESSAGE = ABS;\n" +
			"			FILTER = ALWAYS;\n" +
			"			INITIALVALUE = 0;\n" +
			"			QUEUESIZE = 2;\n" +
			"		};\n" +
			"		NOTIFICATION = SETEVENT { TASK = Task1; EVENT = Event23; }; \n" +
			"	};\n" +
			"\n" +
			"};";
//		DefaultTestResult res = 
				commonWriterTest(text, 1);
//		System.out.println(Vt2StringUtilities.explodeOilVar(Vt2StringUtilities.varTreeToStringErtd(res.vt)));
	}

}
