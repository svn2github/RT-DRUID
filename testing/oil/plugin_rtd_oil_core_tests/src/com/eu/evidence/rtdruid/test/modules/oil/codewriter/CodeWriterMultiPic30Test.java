package com.eu.evidence.rtdruid.test.modules.oil.codewriter;

import org.junit.Test;

import com.eu.evidence.rtdruid.vartree.Vt2StringUtilities;




public class CodeWriterMultiPic30Test extends AbstractCodeWriterTest {
	
	@Test public void testMulti_PIC30() {
		final String text = "CPU mySystem {\n" + 
		"\n" + 
		"   OS myOs {\n" + 
		"      EE_OPT = \"DEBUG\";\n" + 
		"      EE_OPT = \"VERBOSE\";\n" + 
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
		"        CPU_DATA = PIC30 {\n" + 
		"            ID = \"cpu1\";\n" + 
		"            APP_SRC = \"code_cpu1.c\";\n" + 
		"            MULTI_STACK = FALSE;\n" + 
		"            ICD2 = TRUE;\n" + 
		"        };\n" + 
		"\n" + 
		"      MCU_DATA = PIC30 {\n" + 
		"         MODEL = PIC33FJ256MC710;\n" + 
		"      };\n" + 
		"      \n" + 
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
		"      \n" + 
		"   };\n" + 
		"    APPMODE ModeIncremental;" +
		"    APPMODE ModeEdge;" +
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
		"   TASK TaskRecive {\n" + 
		"       CPU_ID = \"cpu1\";\n" + 
		"      PRIORITY = 1;\n" + 
		"      STACK = SHARED;\n" + 
		"      SCHEDULE = FULL;\n" + 
		"   };\n" + 
		"};";
		DefaultTestResult results = commonWriterTest(text, 2);
		System.out.println(Vt2StringUtilities.varTreeToStringErtd(results.vt));
		System.out.println(Vt2StringUtilities.explodeOilVar(Vt2StringUtilities.varTreeToStringErtd(results.vt)));
	}



}
