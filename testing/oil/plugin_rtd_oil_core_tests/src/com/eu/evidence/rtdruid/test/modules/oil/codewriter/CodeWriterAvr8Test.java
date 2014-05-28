package com.eu.evidence.rtdruid.test.modules.oil.codewriter;

import org.junit.Test;



public class CodeWriterAvr8Test extends AbstractCodeWriterTest {
	@Test public void testAVR8_noboard() {
	    final String text =
				"CPU mySystem {\n" + 
				"	OS myOs {\n" + 
				"        CPU_DATA = AVR8 {\n" + 
				"			MULTI_STACK = FALSE;\n" + 
				"		};\n" + 
				"		KERNEL_TYPE = BCC1;\n" + 
				"	};\n" + 
				"};\n";
		commonWriterTest(text, 1);
	}

//	@Test public void testAVR_boards_NOBoard() {
//		testAVR_boards("NO_BOARD");
//	}
//	@Test public void testAVR_boards_STK50X() {
//		testAVR_boards("ATMEGA_STK50X");
//	}
//	@Test public void testAVR_boards_NOMIB5X0() {
//		testAVR_boards("XBOW_MIB5X0");
//	}
//
//	private void testAVR_boards(String boardName) {
//	    final String text =
//				"CPU mySystem {\n" + 
//				"	OS myOs {\n" + 
//				"        CPU_DATA = AVR_5 {\n" + 
//				"			STACK_BOTTOM = 0x08000;\n" +
//				"			MULTI_STACK = FALSE;\n" + 
//				"		};\n" + 
//				"		KERNEL_TYPE = BCC1;\n" +
//				"		BOARD_DATA = "+boardName+";\n" +
//				"	};\n" + 
//				"};\n";
//		commonWriterTest(text, 1);
//	}
	
	@Test public void testAVR8_multistack0() {
	    final String text =
	    		"CPU mySystem {\n" +
	    				"	OS myOs {\n" +
	    				"		EE_OPT = \"DEBUG\";\n" +
	    				"		EE_OPT = \"__ASSERT__\";\n" +
	    				"		CPU_DATA = AVR8 {\n" +
	    				"			APP_SRC = \"code.c\";\n" +
	    				"			MULTI_STACK = TRUE;\n" +
	    				"		};\n" +
	    				"		MCU_DATA = XMEGA {\n" +
	    				"			MODEL = XMEGA_16d4;\n" +
	    				"		};\n" +
	    				"		KERNEL_TYPE = FP;\n" +
	    				"	};\n" +
	    				"	\n" +
	    				"	TASK Task1 {\n" +
	    				"		PRIORITY = 0x01;\n" +
	    				"		AUTOSTART = FALSE;\n" +
	    				"		ACTIVATION = 1;	\n" +
	    				"		STACK = SHARED;\n" +
	    				"		SCHEDULE = FULL;\n" +
	    				"	};\n" +
	    				"	TASK Task2 {\n" +
	    				"		PRIORITY = 0x02;\n" +
	    				"		SCHEDULE = FULL;\n" +
	    				"		AUTOSTART = FALSE;	\n" +
	    				"		STACK = SHARED;\n" +
	    				"		ACTIVATION = 1;	\n" +
	    				"	};\n" +
	    				"};\n";
		commonWriterTest(text, 1);
	}
	
	@Test public void testAVR8_board_ATMEL_STK50X_empty() {
	    final String text =
	    		"CPU mySystem {\n" +
	    				"	OS myOs {\n" +
	    				"		EE_OPT = \"DEBUG\";\n" +
	    				"		EE_OPT = \"__ASSERT__\";\n" +
	    				"		CPU_DATA = AVR8 {\n" +
	    				"			APP_SRC = \"code.c\";\n" +
	    				"			MULTI_STACK = TRUE;\n" +
	    				"		};\n" +
	    				"		BOARD_DATA = ATMEL_STK50X {\n" +
	    				"		};\n" +
	    				"		KERNEL_TYPE = FP;\n" +
	    				"	};\n" +
	    				"	\n" +
	    				"	TASK Task1 {\n" +
	    				"		PRIORITY = 0x01;\n" +
	    				"		AUTOSTART = FALSE;\n" +
	    				"		ACTIVATION = 1;	\n" +
	    				"		STACK = SHARED;\n" +
	    				"		SCHEDULE = FULL;\n" +
	    				"	};\n" +
	    				"	TASK Task2 {\n" +
	    				"		PRIORITY = 0x02;\n" +
	    				"		SCHEDULE = FULL;\n" +
	    				"		AUTOSTART = FALSE;	\n" +
	    				"		STACK = SHARED;\n" +
	    				"		ACTIVATION = 1;	\n" +
	    				"	};\n" +
	    				"};\n";
		commonWriterTest(text, 1);
	}
	
	@Test public void testAVR8_board_XBOW_MIB5X0() {
	    final String text =
	    		"CPU mySystem {\n" +
	    				"	OS myOs {\n" +
	    				"		EE_OPT = \"DEBUG\";\n" +
	    				"		EE_OPT = \"__ASSERT__\";\n" +
	    				"		CPU_DATA = AVR8 {\n" +
	    				"			APP_SRC = \"code.c\";\n" +
	    				"			MULTI_STACK = TRUE;\n" +
	    				"		};\n" +
	    				"		BOARD_DATA = XBOW_MIB5X0 {\n" +
	    				"			USELEDS = TRUE;\n" +
	    				"		};\n" +
	    				"		KERNEL_TYPE = FP;\n" +
	    				"	};\n" +
	    				"	\n" +
	    				"	TASK Task1 {\n" +
	    				"		PRIORITY = 0x01;\n" +
	    				"		AUTOSTART = FALSE;\n" +
	    				"		ACTIVATION = 1;	\n" +
	    				"		STACK = SHARED;\n" +
	    				"		SCHEDULE = FULL;\n" +
	    				"	};\n" +
	    				"	TASK Task2 {\n" +
	    				"		PRIORITY = 0x02;\n" +
	    				"		SCHEDULE = FULL;\n" +
	    				"		AUTOSTART = FALSE;	\n" +
	    				"		STACK = SHARED;\n" +
	    				"		ACTIVATION = 1;	\n" +
	    				"	};\n" +
	    				"};\n";
		commonWriterTest(text, 1);
	}
	
	@Test public void testAVR8_board_ATMEL_STK50X() {
	    final String text =
	    		"CPU mySystem {\n" +
	    				"	OS myOs {\n" +
	    				"		EE_OPT = \"DEBUG\";\n" +
	    				"		EE_OPT = \"__ASSERT__\";\n" +
	    				"		CPU_DATA = AVR8 {\n" +
	    				"			APP_SRC = \"code.c\";\n" +
	    				"			MULTI_STACK = TRUE;\n" +
	    				"		};\n" +
	    				"		BOARD_DATA = ATMEL_STK50X {\n" +
	    				"			USELEDS = TRUE;\n" +
	    				"			USEBUTTON = TRUE;\n" +
	    				"		};\n" +
	    				"		KERNEL_TYPE = FP;\n" +
	    				"	};\n" +
	    				"	\n" +
	    				"	TASK Task1 {\n" +
	    				"		PRIORITY = 0x01;\n" +
	    				"		AUTOSTART = FALSE;\n" +
	    				"		ACTIVATION = 1;	\n" +
	    				"		STACK = SHARED;\n" +
	    				"		SCHEDULE = FULL;\n" +
	    				"	};\n" +
	    				"	TASK Task2 {\n" +
	    				"		PRIORITY = 0x02;\n" +
	    				"		SCHEDULE = FULL;\n" +
	    				"		AUTOSTART = FALSE;	\n" +
	    				"		STACK = SHARED;\n" +
	    				"		ACTIVATION = 1;	\n" +
	    				"	};\n" +
	    				"};\n";
		commonWriterTest(text, 1);
	}
	
	@Test public void testAVR8_board_ATMEL_STK600() {
	    final String text =
	    		"CPU mySystem {\n" +
	    				"	OS myOs {\n" +
	    				"		EE_OPT = \"DEBUG\";\n" +
	    				"		EE_OPT = \"__ASSERT__\";\n" +
	    				"		CPU_DATA = AVR8 {\n" +
	    				"			APP_SRC = \"code.c\";\n" +
	    				"			MULTI_STACK = TRUE;\n" +
	    				"		};\n" +
	    				"		BOARD_DATA = ATMEL_STK600 {\n" +
	    				"			USELEDS = TRUE;\n" +
	    				"			LEDPORT = A;\n" +
	    				"		};\n" +
	    				"		KERNEL_TYPE = FP;\n" +
	    				"	};\n" +
	    				"	\n" +
	    				"	TASK Task1 {\n" +
	    				"		PRIORITY = 0x01;\n" +
	    				"		AUTOSTART = FALSE;\n" +
	    				"		ACTIVATION = 1;	\n" +
	    				"		STACK = SHARED;\n" +
	    				"		SCHEDULE = FULL;\n" +
	    				"	};\n" +
	    				"	TASK Task2 {\n" +
	    				"		PRIORITY = 0x02;\n" +
	    				"		SCHEDULE = FULL;\n" +
	    				"		AUTOSTART = FALSE;	\n" +
	    				"		STACK = SHARED;\n" +
	    				"		ACTIVATION = 1;	\n" +
	    				"	};\n" +
	    				"};\n";
		commonWriterTest(text, 1);
	}
	
	@Test public void testAVR8_board_ARDUINO_UNO() {
	    final String text =
	    		"CPU mySystem {\n" +
	    				"	OS myOs {\n" +
	    				"		EE_OPT = \"DEBUG\";\n" +
	    				"		EE_OPT = \"__ASSERT__\";\n" +
	    				"		CPU_DATA = AVR8 {\n" +
	    				"			APP_SRC = \"code.c\";\n" +
	    				"			MULTI_STACK = TRUE;\n" +
	    				"		};\n" +
	    				"		BOARD_DATA = ARDUINO_UNO {\n" +
	    				"			USELEDS = TRUE;\n" +
	    				"		};\n" +
	    				"		KERNEL_TYPE = FP;\n" +
	    				"	};\n" +
	    				"	\n" +
	    				"	TASK Task1 {\n" +
	    				"		PRIORITY = 0x01;\n" +
	    				"		AUTOSTART = FALSE;\n" +
	    				"		ACTIVATION = 1;	\n" +
	    				"		STACK = SHARED;\n" +
	    				"		SCHEDULE = FULL;\n" +
	    				"	};\n" +
	    				"	TASK Task2 {\n" +
	    				"		PRIORITY = 0x02;\n" +
	    				"		SCHEDULE = FULL;\n" +
	    				"		AUTOSTART = FALSE;	\n" +
	    				"		STACK = SHARED;\n" +
	    				"		ACTIVATION = 1;	\n" +
	    				"	};\n" +
	    				"};\n";
		commonWriterTest(text, 1);
	}
	
	@Test public void testAVR8_mcu_XMEGA_0() {
	    final String text =
	    		"CPU mySystem {\n" +
	    				"	OS myOs {\n" +
	    				"		EE_OPT = \"DEBUG\";\n" +
	    				"		EE_OPT = \"__ASSERT__\";\n" +
	    				"		CPU_DATA = AVR8 {\n" +
	    				"			APP_SRC = \"code.c\";\n" +
	    				"			MULTI_STACK = TRUE;\n" +
	    				"		};\n" +
	    				"		MCU_DATA = XMEGA {\n" +
	    				"		};\n" +
	    				"		KERNEL_TYPE = FP;\n" +
	    				"	};\n" +
	    				"	\n" +
	    				"	TASK Task1 {\n" +
	    				"		PRIORITY = 0x01;\n" +
	    				"		AUTOSTART = FALSE;\n" +
	    				"		ACTIVATION = 1;	\n" +
	    				"		STACK = SHARED;\n" +
	    				"		SCHEDULE = FULL;\n" +
	    				"	};\n" +
	    				"	TASK Task2 {\n" +
	    				"		PRIORITY = 0x02;\n" +
	    				"		SCHEDULE = FULL;\n" +
	    				"		AUTOSTART = FALSE;	\n" +
	    				"		STACK = SHARED;\n" +
	    				"		ACTIVATION = 1;	\n" +
	    				"	};\n" +
	    				"};\n";
		commonWriterTest(text, 1);
	}
	
	@Test public void testAVR8_mcu_XMEGA_1() {
	    final String text =
	    		"CPU mySystem {\n" +
	    				"	OS myOs {\n" +
	    				"		EE_OPT = \"DEBUG\";\n" +
	    				"		EE_OPT = \"__ASSERT__\";\n" +
	    				"		CPU_DATA = AVR8 {\n" +
	    				"			APP_SRC = \"code.c\";\n" +
	    				"			MULTI_STACK = TRUE;\n" +
	    				"		};\n" +
	    				"		MCU_DATA = XMEGA {\n" +
	    				"			MODEL = XMEGA_16d4;\n" +
	    				"		};\n" +
	    				"		KERNEL_TYPE = FP;\n" +
	    				"	};\n" +
	    				"	\n" +
	    				"	TASK Task1 {\n" +
	    				"		PRIORITY = 0x01;\n" +
	    				"		AUTOSTART = FALSE;\n" +
	    				"		ACTIVATION = 1;	\n" +
	    				"		STACK = SHARED;\n" +
	    				"		SCHEDULE = FULL;\n" +
	    				"	};\n" +
	    				"	TASK Task2 {\n" +
	    				"		PRIORITY = 0x02;\n" +
	    				"		SCHEDULE = FULL;\n" +
	    				"		AUTOSTART = FALSE;	\n" +
	    				"		STACK = SHARED;\n" +
	    				"		ACTIVATION = 1;	\n" +
	    				"	};\n" +
	    				"};\n";
		commonWriterTest(text, 1);
	}
	
	@Test public void testAVR8_mcu_XMEGA_2() {
	    final String text =
	    		"CPU mySystem {\n" +
	    				"	OS myOs {\n" +
	    				"		EE_OPT = \"DEBUG\";\n" +
	    				"		EE_OPT = \"__ASSERT__\";\n" +
	    				"		CPU_DATA = AVR8 {\n" +
	    				"			APP_SRC = \"code.c\";\n" +
	    				"			MULTI_STACK = TRUE;\n" +
	    				"		};\n" +
	    				"		MCU_DATA = XMEGA {\n" +
	    				"			MODEL = XMEGA_16d4;\n" +
	    				"			AVR_PGMSPACE = TRUE;\n" +
	    				"			USE_TC_HW = TRUE;\n" +
	    				
	    				"			ENABLE_MCU_DRIVER = TRUE {\n" +
	    				"				MCU_STATUS = EXTENDED;\n" +
	    				"				MCU_DEINIT_API = TRUE;\n" +
	    				"				MCU_INITCLOCK_API = TRUE;\n" +
	    				"				MCU_DEINITCLOCK_API = TRUE;\n" +
	    				"				MCU_GETCLOCKSTATUS_API = TRUE;\n" +
	    				"				MCU_DISTRIBUTECLOCK_API = TRUE;\n" +
	    				"				MCU_SETMODE_API = TRUE;\n" +
	    				"				MCU_GETRESETREASON_API = TRUE;\n" +
	    				"				MCU_PERFORMRESET_API = TRUE;\n" +
	    				"			};\n" +

	    				"			ENABLE_E2P_DRIVER = TRUE {\n" +
	    				"				E2P_STATUS = EXTENDED;\n" +
	    				"				E2P_INTERRUPT = TRUE;\n" +
	    				"				E2P_SYNCHRONOUS = TRUE;\n" +
	    				"				E2P_GETSTATUS_API = TRUE;\n" +
	    				"				E2P_DEINIT_API = TRUE;\n" +
	    				"				E2P_READ_API = TRUE;\n" +
	    				"				E2P_WRITE_API = TRUE;\n" +
	    				"				E2P_ERASE_API = TRUE;\n" +
	    				"				E2P_COMPARE_API = TRUE;\n" +
	    				"				E2P_CANCEL_API = TRUE;\n" +
	    				"			};\n" +
	    				
	    				"			ENABLE_GPIO_DRIVER = TRUE {\n" +
	    				"				GPIO_STATUS = EXTENDED;\n" +
	    				"				GPIO_DEINIT_API = TRUE;\n" +
	    				"				GPIO_READCHANNEL_API = TRUE;\n" +
	    				"				GPIO_READCHANNEL_NTS = TRUE;\n" +
	    				"				GPIO_WRITECHANNEL_API = TRUE;\n" +
	    				"				GPIO_WRITECHANNEL_NTS = TRUE;\n" +
	    				"				GPIO_FLIPCHANNEL_API = TRUE;\n" +
	    				"				GPIO_FLIPCHANNEL_NTS = TRUE;\n" +
	    				"				GPIO_ENABLENOTIF_API = TRUE;\n" +
	    				"				GPIO_DISABLENOTIF_API = TRUE;\n" +
	    				"			};\n" +

	    				"			ENABLE_GPT_DRIVER = TRUE {\n" +
	    				"				GPT_STATUS = EXTENDED;\n" +
	    				"				GPT_ONESHOT = TRUE;\n" +
	    				"				GPT_GETSTATUS_API = TRUE;\n" +
	    				"				GPT_DEINIT_API = TRUE;\n" +
	    				"				GPT_ENABLENOTIF_API = TRUE;\n" +
	    				"				GPT_DISABLENOTIF_API = TRUE;\n" +
	    				"				GPT_STOPTIMER_API = TRUE;\n" +
	    				"				GPT_GETTIMEELAPSED_API = TRUE;\n" +
	    				"				GPT_GETTIMEREMAINING_API = TRUE;\n" +

	    				"				GPT_CHANNEL_C_0 = DIV1;\n" +
	    				"				GPT_CHANNEL_D_0 = DIV2;\n" +
	    				"				GPT_CHANNEL_E_0 = DIV4;\n" +
	    				"				GPT_CHANNEL_F_0 = DIV8;\n" +

	    				"				GPT_CHANNEL_C_1 = DIV64;\n" +
	    				"				GPT_CHANNEL_D_1 = DIV256;\n" +
	    				"				GPT_CHANNEL_E_1 = DIV1024;\n" +
	    				"				GPT_CHANNEL_F_1 = DIV1;\n" +
	    				"			};\n" +

	    				"			ENABLE_PWM_DRIVER = TRUE {\n" +
	    				"				PWM_STATUS = EXTENDED;\n" +
	    				"				PWM_GETSTATUS_API = TRUE;\n" +
	    				"				PWM_DEINIT_API = TRUE;\n" +
	    				"				PWM_ENABLENOTIF_API = TRUE;\n" +
	    				"				PWM_DISABLENOTIF_API = TRUE;\n" +
	    				"				PWM_SETDUTYCYCLE_API = TRUE;\n" +
	    				"				PWM_GETOUTPUTSTATE_API = TRUE;\n" +

	    				"				PWM_CHANNEL_C_0 = DIV1;\n" +
	    				"				PWM_CHANNEL_D_0 = DIV2;\n" +
	    				"				PWM_CHANNEL_E_0 = DIV4;\n" +
	    				"				PWM_CHANNEL_F_0 = DIV8;\n" +

	    				"				PWM_CHANNEL_C_1 = DIV64;\n" +
	    				"				PWM_CHANNEL_D_1 = DIV256;\n" +
	    				"				PWM_CHANNEL_E_1 = DIV1024;\n" +
	    				"				PWM_CHANNEL_F_1 = DIV1;\n" +

	    				"				PWM_C_0_CC = A;\n" +
	    				"				PWM_D_0_CC = B;\n" +
	    				"				PWM_E_0_CC = C;\n" +
	    				"				PWM_F_0_CC = D;\n" +

	    				"				PWM_C_1_CC = A;\n" +
	    				"				PWM_D_1_CC = B;\n" +
	    				"				PWM_E_1_CC = A;\n" +
	    				"				PWM_F_1_CC = B;\n" +
	    				"			};\n" +

	    				"			ENABLE_RTC_DRIVER = TRUE {\n" +
	    				"				RTC_STATUS = EXTENDED;\n" +
	    				"				RTC_GETSTATUS_API = TRUE;\n" +
	    				"				RTC_DEINIT_API = TRUE;\n" +
	    				"				RTC_ENABLENOTIF_API = TRUE;\n" +
	    				"				RTC_DISABLENOTIF_API = TRUE;\n" +
	    				"				RTC_STOP_API = TRUE;\n" +
	    				"				RTC_GETCOUNTER_API = TRUE;\n" +
	    				"				RTC_SETCOUNTER_API = TRUE;\n" +

	    				"				RTC_CHANNEL_0 = DIV1;\n" +
	    				"			};\n" +

	    				"			ENABLE_SCI_DRIVER = TRUE {\n" +
	    				"				SCI_STATUS = EXTENDED;\n" +
	    				"				SCI_BAUDRATE_TABLE = TRUE;\n" +
	    				"				SCI_GETSTATUS_API = TRUE;\n" +
	    				"				SCI_DEINIT_API = TRUE;\n" +
	    				"				SCI_WRITETXDATA_API = TRUE;\n" +
	    				"				SCI_WRITETXDATA__NTS = TRUE;\n" +
	    				"				SCI_DISABLETX_API = TRUE;\n" +
	    				"				SCI_ENABLETX_API = TRUE;\n" +
	    				"				SCI_READRXDATA_API = TRUE;\n" +
	    				"				SCI_READRXDATA_NTS = TRUE;\n" +
	    				"				SCI_DISABLERX_API = TRUE;\n" +
	    				"				SCI_ENABLERX_API = TRUE;\n" +
	    				"				SCI_ENABLENOTIF_API = TRUE;\n" +
	    				"				SCI_DISABLENOTIF_API = TRUE;\n" +
	    				"			};\n" +

	    				"		};\n" +
	    				"		KERNEL_TYPE = FP;\n" +
	    				"	};\n" +
	    				"	\n" +
	    				"	TASK Task1 {\n" +
	    				"		PRIORITY = 0x01;\n" +
	    				"		AUTOSTART = FALSE;\n" +
	    				"		ACTIVATION = 1;	\n" +
	    				"		STACK = SHARED;\n" +
	    				"		SCHEDULE = FULL;\n" +
	    				"	};\n" +
	    				"	TASK Task2 {\n" +
	    				"		PRIORITY = 0x02;\n" +
	    				"		SCHEDULE = FULL;\n" +
	    				"		AUTOSTART = FALSE;	\n" +
	    				"		STACK = SHARED;\n" +
	    				"		ACTIVATION = 1;	\n" +
	    				"	};\n" +
	    				"};\n";
		commonWriterTest(text, 1);
	}
	
	@Test public void testAVR8_mcu_XMEGA_3() {
	    final String text =
	    		"CPU mySystem {\n" +
	    				"	OS myOs {\n" +
	    				"		EE_OPT = \"DEBUG\";\n" +
	    				"		EE_OPT = \"__ASSERT__\";\n" +
	    				"		CPU_DATA = AVR8 {\n" +
	    				"			APP_SRC = \"code.c\";\n" +
	    				"			MULTI_STACK = TRUE;\n" +
	    				"		};\n" +
	    				"		MCU_DATA = XMEGA {\n" +
	    				"			MODEL = XMEGA_16d4;\n" +
	    				"			AVR_PGMSPACE = TRUE;\n" +
//	    				"			USE_TC_HW = TRUE;\n" +
	    				
	    				"			ENABLE_MCU_DRIVER = TRUE {\n" +
	    				"				MCU_STATUS = EXTENDED;\n" +
	    				"				MCU_DEINIT_API = TRUE;\n" +
	    				"				MCU_INITCLOCK_API = TRUE;\n" +
	    				"				MCU_DEINITCLOCK_API = TRUE;\n" +
	    				"				MCU_GETCLOCKSTATUS_API = TRUE;\n" +
	    				"				MCU_DISTRIBUTECLOCK_API = TRUE;\n" +
	    				"				MCU_SETMODE_API = TRUE;\n" +
	    				"				MCU_GETRESETREASON_API = TRUE;\n" +
	    				"				MCU_PERFORMRESET_API = TRUE;\n" +
	    				"			};\n" +
	    				
	    				"			ENABLE_MCU_POWER_REDUCTION = TRUE {\n" +
	    				"				PULL_UP = TRUE;\n" +
	    				"				PORT_OUT = TRUE;\n" +
	    				"				JTAG = TRUE;\n" +
	    				"			};\n" +

	    				"			ENABLE_E2P_DRIVER = TRUE {\n" +
	    				"				E2P_STATUS = EXTENDED;\n" +
	    				"				E2P_INTERRUPT = TRUE;\n" +
	    				"				E2P_SYNCHRONOUS = TRUE;\n" +
	    				"				E2P_GETSTATUS_API = TRUE;\n" +
	    				"				E2P_DEINIT_API = TRUE;\n" +
	    				"				E2P_READ_API = TRUE;\n" +
	    				"				E2P_WRITE_API = TRUE;\n" +
	    				"				E2P_ERASE_API = TRUE;\n" +
	    				"				E2P_COMPARE_API = TRUE;\n" +
	    				"				E2P_CANCEL_API = TRUE;\n" +
	    				"			};\n" +
	    				
	    				"			ENABLE_GPIO_DRIVER = TRUE {\n" +
	    				"				GPIO_STATUS = EXTENDED;\n" +
	    				"				GPIO_DEINIT_API = TRUE;\n" +
	    				"				GPIO_READCHANNEL_API = TRUE;\n" +
	    				"				GPIO_READCHANNEL_NTS = TRUE;\n" +
	    				"				GPIO_WRITECHANNEL_API = TRUE;\n" +
	    				"				GPIO_WRITECHANNEL_NTS = TRUE;\n" +
	    				"				GPIO_FLIPCHANNEL_API = TRUE;\n" +
	    				"				GPIO_FLIPCHANNEL_NTS = TRUE;\n" +
	    				"				GPIO_ENABLENOTIF_API = TRUE;\n" +
	    				"				GPIO_DISABLENOTIF_API = TRUE;\n" +
	    				"			};\n" +

	    				"			ENABLE_GPT_DRIVER = TRUE {\n" +
	    				"				GPT_STATUS = EXTENDED;\n" +
	    				"				GPT_ONESHOT = TRUE;\n" +
	    				"				GPT_GETSTATUS_API = TRUE;\n" +
	    				"				GPT_DEINIT_API = TRUE;\n" +
	    				"				GPT_ENABLENOTIF_API = TRUE;\n" +
	    				"				GPT_DISABLENOTIF_API = TRUE;\n" +
	    				"				GPT_STOPTIMER_API = TRUE;\n" +
	    				"				GPT_GETTIMEELAPSED_API = TRUE;\n" +
	    				"				GPT_GETTIMEREMAINING_API = TRUE;\n" +

	    				"				GPT_CHANNEL_C_0 = DIV1;\n" +
	    				"				GPT_CHANNEL_D_0 = DIV2;\n" +
	    				"				GPT_CHANNEL_E_0 = DIV4;\n" +
	    				"				GPT_CHANNEL_F_0 = DIV8;\n" +

	    				"				GPT_CHANNEL_C_1 = DIV64;\n" +
	    				"				GPT_CHANNEL_D_1 = DIV256;\n" +
	    				"				GPT_CHANNEL_E_1 = DIV1024;\n" +
	    				"				GPT_CHANNEL_F_1 = DIV1;\n" +
	    				"			};\n" +

	    				"			ENABLE_PWM_DRIVER = TRUE {\n" +
	    				"				PWM_STATUS = EXTENDED;\n" +
	    				"				PWM_GETSTATUS_API = TRUE;\n" +
	    				"				PWM_DEINIT_API = TRUE;\n" +
	    				"				PWM_ENABLENOTIF_API = TRUE;\n" +
	    				"				PWM_DISABLENOTIF_API = TRUE;\n" +
	    				"				PWM_SETDUTYCYCLE_API = TRUE;\n" +
	    				"				PWM_GETOUTPUTSTATE_API = TRUE;\n" +

	    				"				PWM_CHANNEL_C_0 = DIV1;\n" +
	    				"				PWM_CHANNEL_D_0 = DIV2;\n" +
	    				"				PWM_CHANNEL_E_0 = DIV4;\n" +
	    				"				PWM_CHANNEL_F_0 = DIV8;\n" +

	    				"				PWM_CHANNEL_C_1 = DIV64;\n" +
	    				"				PWM_CHANNEL_D_1 = DIV256;\n" +
	    				"				PWM_CHANNEL_E_1 = DIV1024;\n" +
	    				"				PWM_CHANNEL_F_1 = DIV1;\n" +

	    				"				PWM_C_0_CC = A;\n" +
	    				"				PWM_D_0_CC = B;\n" +
	    				"				PWM_E_0_CC = C;\n" +
	    				"				PWM_F_0_CC = D;\n" +

	    				"				PWM_C_1_CC = A;\n" +
	    				"				PWM_D_1_CC = B;\n" +
	    				"				PWM_E_1_CC = A;\n" +
	    				"				PWM_F_1_CC = B;\n" +
	    				"			};\n" +

	    				"			ENABLE_RTC_DRIVER = TRUE {\n" +
	    				"				RTC_STATUS = EXTENDED;\n" +
	    				"				RTC_GETSTATUS_API = TRUE;\n" +
	    				"				RTC_DEINIT_API = TRUE;\n" +
	    				"				RTC_ENABLENOTIF_API = TRUE;\n" +
	    				"				RTC_DISABLENOTIF_API = TRUE;\n" +
	    				"				RTC_STOP_API = TRUE;\n" +
	    				"				RTC_GETCOUNTER_API = TRUE;\n" +
	    				"				RTC_SETCOUNTER_API = TRUE;\n" +

	    				"				RTC_CHANNEL_0 = DIV1;\n" +
	    				"			};\n" +

	    				"			ENABLE_SCI_DRIVER = TRUE {\n" +
	    				"				SCI_STATUS = EXTENDED;\n" +
	    				"				SCI_BAUDRATE_TABLE = TRUE;\n" +
	    				"				SCI_GETSTATUS_API = TRUE;\n" +
	    				"				SCI_DEINIT_API = TRUE;\n" +
	    				"				SCI_WRITETXDATA_API = TRUE;\n" +
	    				"				SCI_WRITETXDATA__NTS = TRUE;\n" +
	    				"				SCI_DISABLETX_API = TRUE;\n" +
	    				"				SCI_ENABLETX_API = TRUE;\n" +
	    				"				SCI_READRXDATA_API = TRUE;\n" +
	    				"				SCI_READRXDATA_NTS = TRUE;\n" +
	    				"				SCI_DISABLERX_API = TRUE;\n" +
	    				"				SCI_ENABLERX_API = TRUE;\n" +
	    				"				SCI_ENABLENOTIF_API = TRUE;\n" +
	    				"				SCI_DISABLENOTIF_API = TRUE;\n" +
	    				"			};\n" +

	    				"		};\n" +
	    				"		KERNEL_TYPE = FP;\n" +
	    				"	};\n" +
	    				"	\n" +
	    				"	TASK Task1 {\n" +
	    				"		PRIORITY = 0x01;\n" +
	    				"		AUTOSTART = FALSE;\n" +
	    				"		ACTIVATION = 1;	\n" +
	    				"		STACK = SHARED;\n" +
	    				"		SCHEDULE = FULL;\n" +
	    				"	};\n" +
	    				"	TASK Task2 {\n" +
	    				"		PRIORITY = 0x02;\n" +
	    				"		SCHEDULE = FULL;\n" +
	    				"		AUTOSTART = FALSE;	\n" +
	    				"		STACK = SHARED;\n" +
	    				"		ACTIVATION = 1;	\n" +
	    				"	};\n" +
	    				"};\n";
		commonWriterTest(text, 1);
	}
	
	@Test public void testAVR8_mcu_MEGA_1() {
	    final String text =
	    		"CPU mySystem {\n" +
	    				"	OS myOs {\n" +
	    				"		EE_OPT = \"DEBUG\";\n" +
	    				"		EE_OPT = \"__ASSERT__\";\n" +
	    				"		CPU_DATA = AVR8 {\n" +
	    				"			APP_SRC = \"code.c\";\n" +
	    				"			MULTI_STACK = TRUE;\n" +
	    				"		};\n" +
	    				"		MCU_DATA = MEGA {\n" +
	    				"			MODEL = MEGA_328p;\n" +
	    				"			USEIC = TRUE;\n" +
	    				"			USEUART = TRUE;\n" +
	    				"			USESPI = TRUE;\n" +

	    				"			TIMER0 = DIV32;\n" +
	    				"			TIMER1 = DIV8;\n" +
	    				"			TIMER2 = DIV64;\n" +
	    				"			TIMER3 = DIV1024;\n" +

	    				"		};\n" +
	    				"		KERNEL_TYPE = FP;\n" +
	    				"	};\n" +
	    				"	\n" +
	    				"	TASK Task1 {\n" +
	    				"		PRIORITY = 0x01;\n" +
	    				"		AUTOSTART = FALSE;\n" +
	    				"		ACTIVATION = 1;	\n" +
	    				"		STACK = SHARED;\n" +
	    				"		SCHEDULE = FULL;\n" +
	    				"	};\n" +
	    				"	TASK Task2 {\n" +
	    				"		PRIORITY = 0x02;\n" +
	    				"		SCHEDULE = FULL;\n" +
	    				"		AUTOSTART = FALSE;	\n" +
	    				"		STACK = SHARED;\n" +
	    				"		ACTIVATION = 1;	\n" +
	    				"	};\n" +
	    				"};\n";
		commonWriterTest(text, 1);
	}

	@Test public void testAVR8_ISR_XMEGA() {
	    final String text =
	    		"CPU singleCPU {\n" +
				"\n" +
				"	OS EE {\n" +
				"		EE_OPT = \"DEBUG\";\n" +
				"		EE_OPT = \"SKIP_END_FUNCTIONS\"; /* What's the meaning?!? */\n" +
				"\n" +
				"		CFLAGS = \"\";\n" +
				"		LDFLAGS = \"\";\n" +
				"        CFLAGS = \"-I../erika-lib/dio_lib\";\n" +
				"        CFLAGS = \"-I../erika-lib/core_lib\";\n" +
				"\n" +
				"		CPU_DATA = AVR8 {\n" +
				"            APP_SRC = \"data.c\";\n" +
				"            APP_SRC = \"task.c\";\n" +
				"            APP_SRC = \"main.c\";\n" +
				"			MULTI_STACK = FALSE;\n" +
				"		};\n" +
				"\n" +
				"		EE_OPT = \"__HAS_TYPES_H__\";\n" +
				"		EE_OPT = \"__AVR8_GCC_C99__\";\n" +
				"\n" +
				"		MCU_DATA = XMEGA {\n" +
				"			MODEL = XMEGA_16d4;\n" +
				"		};\n" +
				"\n" +
				"		EE_OPT = \"__ARDUINO_SDK__\";\n" +
				"		EE_OPT = \"__ARDUINO_SDK_LIB_TIMER1__\";\n" +
				"		EE_OPT = \"__ARDUINO_UNO_328__\";\n" +
				"		EE_OPT = \"__ADD_LIBS__\";\n" +
				"		LIB = ENABLE {\n" +
				"			NAME = \"ARDUINO_SDK\";\n" +
				"		};\n" +
				"		KERNEL_TYPE = BCC1;\n" +
				"	};\n" +
				"\n" +
				"	ISR timer1_handler {\n" +
				"		CATEGORY = 2;\n" +
				"		PRIORITY = 2;\n" +
				"		ENTRY = \"TIMER1_OVF\";\n" +
				"	};\n" +
				"	ISR timer2_handler {\n" +
				"		CATEGORY = 2;\n" +
				"		ENTRY = \"TIMER2\";\n" +
				"	};\n" +
				"\n" +
				"	COUNTER mainCounter {\n" +
				"		MINCYCLE = 1;\n" +
				"		MAXALLOWEDVALUE = 65535;\n" +
				"		TICKSPERBASE = 1;\n" +
				"	};\n" +
				"\n" +
				"	TASK mainTask {\n" +
				"		PRIORITY = 0x01;\n" +
				"		AUTOSTART = TRUE;\n" +
				"		STACK = SHARED;\n" +
				"		ACTIVATION = 1;\n" +
				"		SCHEDULE = FULL;\n" +
				"	};\n" +
				"\n" +
				"    TASK Task1 {\n" +
				"      PRIORITY = 2;\n" +
				"      STACK = SHARED;\n" +
				"      SCHEDULE = FULL;\n" +
				"    }; \n" +
				"    ALARM Task1_alarm {\n" +
				"      COUNTER = mainCounter;\n" +
				"      ACTION = ACTIVATETASK { TASK = Task1; };\n" +
				"      AUTOSTART = TRUE {\n" +
				"          ALARMTIME = 1;\n" +
				"          CYCLETIME = 1;\n" +
				"      };\n" +
				"    };\n" +
				"};";
		commonWriterTest(text, 1);
	}
	@Test public void testAVR8_ISR_MEGA() {
	    final String text =
	    		"CPU singleCPU {\n" +
				"\n" +
				"	OS EE {\n" +
				"		EE_OPT = \"DEBUG\";\n" +
				"		EE_OPT = \"SKIP_END_FUNCTIONS\"; /* What's the meaning?!? */\n" +
				"\n" +
				"		CFLAGS = \"\";\n" +
				"		LDFLAGS = \"\";\n" +
				"        CFLAGS = \"-I../erika-lib/dio_lib\";\n" +
				"        CFLAGS = \"-I../erika-lib/core_lib\";\n" +
				"\n" +
				"		CPU_DATA = AVR8 {\n" +
				"            APP_SRC = \"data.c\";\n" +
				"            APP_SRC = \"task.c\";\n" +
				"            APP_SRC = \"main.c\";\n" +
				"			MULTI_STACK = FALSE;\n" +
				"		};\n" +
				"\n" +
				"		EE_OPT = \"__HAS_TYPES_H__\";\n" +
				"		EE_OPT = \"__AVR8_GCC_C99__\";\n" +
				"\n" +
				"		MCU_DATA = MEGA {\n" +
				"			MODEL = MEGA_328p;\n" +
				"		};\n" +
				"\n" +
				"		EE_OPT = \"__ARDUINO_SDK__\";\n" +
				"		EE_OPT = \"__ARDUINO_SDK_LIB_TIMER1__\";\n" +
				"		EE_OPT = \"__ARDUINO_UNO_328__\";\n" +
				"		EE_OPT = \"__ADD_LIBS__\";\n" +
				"		LIB = ENABLE {\n" +
				"			NAME = \"ARDUINO_SDK\";\n" +
				"		};\n" +
				"		KERNEL_TYPE = BCC1;\n" +
				"	};\n" +
				"\n" +
				"	ISR timer1_handler {\n" +
				"		CATEGORY = 2;\n" +
				"		PRIORITY = 2;\n" +
				"		ENTRY = \"TIMER1_OVF\";\n" +
				"	};\n" +
				"	ISR timer2_handler {\n" +
				"		CATEGORY = 2;\n" +
				"		ENTRY = \"TIMER2\";\n" +
				"	};\n" +

				"\n" +
				"	COUNTER mainCounter {\n" +
				"		MINCYCLE = 1;\n" +
				"		MAXALLOWEDVALUE = 65535;\n" +
				"		TICKSPERBASE = 1;\n" +
				"	};\n" +
				"\n" +
				"	TASK mainTask {\n" +
				"		PRIORITY = 0x01;\n" +
				"		AUTOSTART = TRUE;\n" +
				"		STACK = SHARED;\n" +
				"		ACTIVATION = 1;\n" +
				"		SCHEDULE = FULL;\n" +
				"	};\n" +
				"\n" +
				"    TASK Task1 {\n" +
				"      PRIORITY = 2;\n" +
				"      STACK = SHARED;\n" +
				"      SCHEDULE = FULL;\n" +
				"    }; \n" +
				"    ALARM Task1_alarm {\n" +
				"      COUNTER = mainCounter;\n" +
				"      ACTION = ACTIVATETASK { TASK = Task1; };\n" +
				"      AUTOSTART = TRUE {\n" +
				"          ALARMTIME = 1;\n" +
				"          CYCLETIME = 1;\n" +
				"      };\n" +
				"    };\n" +
				"};";
		commonWriterTest(text, 1);
	}
	
	@Test public void testAVR8_XMEGA_CUSTOM() {
	    final String text =
	    		"CPU mySystem {\n" +
	    				"	OS myOs {\n" +
	    				"		EE_OPT = \"DEBUG\";\n" +
	    				"		EE_OPT = \"__ASSERT__\";\n" +
	    				"		CPU_DATA = AVR8 {\n" +
	    				"			APP_SRC = \"code.c\";\n" +
	    				"			MULTI_STACK = TRUE;\n" +
	    				"		};\n" +
	    				"		MCU_DATA = XMEGA {\n" +
	    				"			MODEL = CUSTOM { MODEL = \"abc\"; };\n" +
	    				"		};\n" +
	    				"		KERNEL_TYPE = FP;\n" +
	    				"	};\n" +
	    				"	\n" +
	    				"	TASK Task1 {\n" +
	    				"		PRIORITY = 0x01;\n" +
	    				"		AUTOSTART = FALSE;\n" +
	    				"		ACTIVATION = 1;	\n" +
	    				"		STACK = SHARED;\n" +
	    				"		SCHEDULE = FULL;\n" +
	    				"	};\n" +
	    				"	TASK Task2 {\n" +
	    				"		PRIORITY = 0x02;\n" +
	    				"		SCHEDULE = FULL;\n" +
	    				"		AUTOSTART = FALSE;	\n" +
	    				"		STACK = SHARED;\n" +
	    				"		ACTIVATION = 1;	\n" +
	    				"	};\n" +
	    				"};\n";
		commonWriterTest(text, 1);
	}

	
	@Test public void testAVR8_MEGA_CUSTOM() {
	    final String text =
	    		"CPU mySystem {\n" +
	    				"	OS myOs {\n" +
	    				"		EE_OPT = \"DEBUG\";\n" +
	    				"		EE_OPT = \"__ASSERT__\";\n" +
	    				"		CPU_DATA = AVR8 {\n" +
	    				"			APP_SRC = \"code.c\";\n" +
	    				"			MULTI_STACK = TRUE;\n" +
	    				"		};\n" +
	    				"		MCU_DATA = MEGA {\n" +
	    				"			MODEL = CUSTOM { MODEL = \"abc\"; };\n" +
	    				"		};\n" +
	    				"		KERNEL_TYPE = FP;\n" +
	    				"	};\n" +
	    				"	\n" +
	    				"	TASK Task1 {\n" +
	    				"		PRIORITY = 0x01;\n" +
	    				"		AUTOSTART = FALSE;\n" +
	    				"		ACTIVATION = 1;	\n" +
	    				"		STACK = SHARED;\n" +
	    				"		SCHEDULE = FULL;\n" +
	    				"	};\n" +
	    				"	TASK Task2 {\n" +
	    				"		PRIORITY = 0x02;\n" +
	    				"		SCHEDULE = FULL;\n" +
	    				"		AUTOSTART = FALSE;	\n" +
	    				"		STACK = SHARED;\n" +
	    				"		ACTIVATION = 1;	\n" +
	    				"	};\n" +
	    				"};\n";
		commonWriterTest(text, 1);
	}

}
