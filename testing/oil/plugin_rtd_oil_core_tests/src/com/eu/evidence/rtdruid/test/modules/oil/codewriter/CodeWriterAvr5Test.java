package com.eu.evidence.rtdruid.test.modules.oil.codewriter;



public class CodeWriterAvr5Test extends AbstractCodeWriterTest {
	public void testAVR_noboard() {
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

	public void testAVR_boards() {
		String names[] = new String[] {
				"NO_BOARD", "ATMEGA_STK50X","XBOW_MIB5X0"
		};

		for (int i=0; i<names.length; i++) {
		    final String text =
					"CPU mySystem {\n" + 
					"	OS myOs {\n" + 
					"        CPU_DATA = AVR_5 {\n" + 
					"			STACK_BOTTOM = 0x08000;\n" +
					"			MULTI_STACK = FALSE;\n" + 
					"		};\n" + 
					"		KERNEL_TYPE = BCC1;\n" +
					"		BOARD_DATA = "+names[i]+";\n" +
					"	};\n" + 
					"};\n";
			commonWriterTest(text, 1);
		}
	}

}
