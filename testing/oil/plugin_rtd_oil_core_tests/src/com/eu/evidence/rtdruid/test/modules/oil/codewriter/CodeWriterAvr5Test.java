package com.eu.evidence.rtdruid.test.modules.oil.codewriter;

import org.junit.Ignore;
import org.junit.Test;



public class CodeWriterAvr5Test extends AbstractCodeWriterTest {
	@Test @Ignore public void testAVR_noboard() {
	    final String text =
				"CPU mySystem {\n" + 
				"	OS myOs {\n" + 
				"        CPU_DATA = AVR_5 {\n" + 
				"			STACK_BOTTOM = 0x08000;\n" +
				"			MULTI_STACK = FALSE;\n" + 
				"		};\n" + 
				"		KERNEL_TYPE = BCC1;\n" + 
				"	};\n" + 
				"};\n";
		commonWriterTest(text, 1);
	}

	@Test @Ignore public void testAVR_boards_NOBoard() {
		testAVR_boards("NO_BOARD");
	}
	@Test @Ignore public void testAVR_boards_STK50X() {
		testAVR_boards("ATMEGA_STK50X");
	}
	@Test @Ignore public void testAVR_boards_NOMIB5X0() {
		testAVR_boards("XBOW_MIB5X0");
	}

	private void testAVR_boards(String boardName) {
	    final String text =
				"CPU mySystem {\n" + 
				"	OS myOs {\n" + 
				"        CPU_DATA = AVR_5 {\n" + 
				"			STACK_BOTTOM = 0x08000;\n" +
				"			MULTI_STACK = FALSE;\n" + 
				"		};\n" + 
				"		KERNEL_TYPE = BCC1;\n" +
				"		BOARD_DATA = "+boardName+";\n" +
				"	};\n" + 
				"};\n";
		commonWriterTest(text, 1);
	}

}
