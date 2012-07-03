package com.eu.evidence.rtdruid.test.modules.oil.codewriter;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;




public class CodeWriterMultiEcuTest extends AbstractCodeWriterTest {
	
	@Test
	public void testMulti_PIC30() throws IOException {
		final String text1 = "CPU mySystem {\n" + 
		"\n" + 
		"   OS myOs {\n" + 
		"      EE_OPT = \"DEBUG1\";\n" + 
		"      \n" + 
		"      MASTER_CPU = \"cpu0\";\n" + 
		"\n" + 
		"      CPU_DATA = PIC30 {\n" + 
		"          ID = \"cpu0\";\n" + 
		"         APP_SRC = \"code.c\";\n" + 
		"         MULTI_STACK = FALSE;\n" + 
		"         ICD2 = FALSE;\n" + 
		"      };\n" + 
		"\n" + 
		"      MCU_DATA = PIC30 {\n" + 
		"         MODEL = PIC33FJ256MC710;\n" + 
		"      };\n" + 
		"      \n" + 
		"      KERNEL_TYPE = FP;\n" + 
		"\n" + 
		"      EE_OPT = \"__ADD_LIBS__\";\n" + 
		"      LIB = ENABLE {\n" + 
		"         NAME = \"CONSOLE\";\n" + 
		"      };   \n" + 
		"      EE_OPT = \"USE_CONSOLE\";\n" + 
		"      EE_OPT = \"USE_CONSOLE_SERIAL\";\n" + 
		"      EE_OPT = \"__USE_UART__\";\n" + 
		"      \n" + 
		"   };\n" + 
		"\n" + 
		"   COUNTER myCounter {\n" + 
		"      CPU_ID = \"cpu0\";\n" + 
		"   };\n" + 
		"   \n" + 
		"   ALARM AlarmSend {\n" + 
		"      COUNTER = myCounter;\n" + 
		"      ACTION = ACTIVATETASK { TASK = TaskSend; };\n" + 
		"   };\n" + 
		"   \n" + 
		"   TASK TaskSend {\n" + 
		"       CPU_ID = \"cpu0\";\n" + 
		"      PRIORITY = 1;\n" + 
		"      STACK = SHARED;\n" + 
		"      SCHEDULE = FULL;\n" + 
		"   };\n" + 
		"};";
		final String text2 = "CPU otherSystem {\n" + 
		"\n" + 
		"   OS myOs {\n" + 
		"      EE_OPT = \"VERBOSE2\";\n" + 
		"      \n" + 
		"      MASTER_CPU = \"cpu0\";\n" + 
		"\n" + 
		"      CPU_DATA = PIC30 {\n" + 
		"          ID = \"cpu0\";\n" + 
		"         APP_SRC = \"other.c\";\n" + 
		"      };\n" + 
		"\n" + 
		"      BOARD_DATA = EE_FLEX {\n" + 
		"         USELEDS = TRUE;\n" + 
		"         TYPE = DEMO {\n" + 
		"            OPTIONS = ALL;\n" + 
		"         };\n" + 
		"      };\n" + 
		"      \n" + 
		"      KERNEL_TYPE = FP;\n" + 
		"\n" + 
		"   };\n" + 
		"\n" + 
		"   COUNTER myCounter1 {\n" + 
		"      CPU_ID = \"cpu0\";\n" + 
		"   };\n" + 
		"   \n" + 
		"   ALARM AlarmSend1 {\n" + 
		"      COUNTER = myCounter1;\n" + 
		"      ACTION = ACTIVATETASK { TASK = TaskSend1; };\n" + 
		"   };\n" + 
		"   \n" + 
		"   TASK TaskSend1 {\n" + 
		"       CPU_ID = \"cpu0\";\n" + 
		"      PRIORITY = 1;\n" + 
		"      STACK = SHARED;\n" + 
		"      SCHEDULE = FULL;\n" + 
		"   };\n" + 
		"};";
		
		
		final String text_result = "CPU mySystem {\n" + 
		"\n" + 
		"   OS myOs {\n" + 
		"      EE_OPT = \"DEBUG1\";\n" + 
		"      \n" + 
		"      MASTER_CPU = \"cpu0\";\n" + 
		"\n" + 
		"      CPU_DATA = PIC30 {\n" + 
		"          ID = \"cpu0\";\n" + 
		"         APP_SRC = \"code.c\";\n" + 
		"         APP_SRC = \"other.c\";\n" + 
		"         MULTI_STACK = FALSE;\n" + 
		"         ICD2 = FALSE;\n" + 
		"      };\n" + 
		"\n" + 
		"      MCU_DATA = PIC30 {\n" + 
		"         MODEL = PIC33FJ256MC710;\n" + 
		"      };\n" + 
		"      BOARD_DATA = EE_FLEX {\n" + 
		"         USELEDS = TRUE;\n" + 
		"         TYPE = DEMO {\n" + 
		"            OPTIONS = ALL;\n" + 
		"         };\n" + 
		"      };\n" + 
		"      \n" + 
		"      KERNEL_TYPE = FP;\n" + 
		"\n" + 
		"      EE_OPT = \"__ADD_LIBS__\";\n" + 
		"      LIB = ENABLE {\n" + 
		"         NAME = \"CONSOLE\";\n" + 
		"      };   \n" + 
		"      EE_OPT = \"USE_CONSOLE\";\n" + 
		"      EE_OPT = \"USE_CONSOLE_SERIAL\";\n" + 
		"      EE_OPT = \"__USE_UART__\";\n" + 
		"      EE_OPT = \"VERBOSE2\";\n" + 
		"      \n" + 
		"   };\n" + 
		"\n" + 
		"   COUNTER myCounter {\n" + 
		"      CPU_ID = \"cpu0\";\n" + 
		"   };\n" + 
		"   \n" + 
		"   ALARM AlarmSend {\n" + 
		"      COUNTER = myCounter;\n" + 
		"      ACTION = ACTIVATETASK { TASK = TaskSend; };\n" + 
		"   };\n" + 
		"   \n" + 
		"   TASK TaskSend {\n" + 
		"       CPU_ID = \"cpu0\";\n" + 
		"      PRIORITY = 1;\n" + 
		"      STACK = SHARED;\n" + 
		"      SCHEDULE = FULL;\n" + 
		"   };\n" + 
		"   COUNTER myCounter1 {\n" + 
		"      CPU_ID = \"cpu0\";\n" + 
		"   };\n" + 
		"   \n" + 
		"   ALARM AlarmSend1 {\n" + 
		"      COUNTER = myCounter1;\n" + 
		"      ACTION = ACTIVATETASK { TASK = TaskSend1; };\n" + 
		"   };\n" + 
		"   \n" + 
		"   TASK TaskSend1 {\n" + 
		"       CPU_ID = \"cpu0\";\n" + 
		"      PRIORITY = 1;\n" + 
		"      STACK = SHARED;\n" + 
		"      SCHEDULE = FULL;\n" + 
		"   };\n" + 
		"};";
		
		
		DefaultTestResult results_multi = commonWriterTest(new String[] {text1, text2}, new String[] {"a.oil", "b.oil"}, 1);
		
		DefaultTestResult results_single = commonWriterTest(text_result, 1);
		
		assertEquals(results_multi.buffers.length, results_single.buffers.length);
		for (int i=0; i<results_multi.buffers.length; i++)
			assertEquals(results_multi.buffers[i].toString(), results_single.buffers[i].toString());

		

	}



}
