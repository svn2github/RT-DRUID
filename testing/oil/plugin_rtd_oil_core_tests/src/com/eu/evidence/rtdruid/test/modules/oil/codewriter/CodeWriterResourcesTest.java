package com.eu.evidence.rtdruid.test.modules.oil.codewriter;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CodeWriterResourcesTest extends AbstractCodeWriterTest {

	@Test
	public void testMpc567_monostack_linResScheduler() {
	    final String base = " CPU test_application {\n" +
				"\n" +
				"	OS EE {\n" +
				"		EE_OPT = \"DEBUG\";\n" +
				"		EE_OPT = \"__USE_LEDS__\";\n" +
				"		EE_OPT = \"__USE_BUTTONS__\";\n" +
				"		EE_OPT = \"__E200ZX_EXECUTE_FROM_RAM__\";\n" +
				"		EE_OPT = \"__CODEWARRIOR__\";\n" +
				"		EE_OPT = \"EE_ISR_DYNAMIC_TABLE\";\n" +
				"\n" +
				"		CFLAGS = \"\";\n" +
				"		ASFLAGS = \"\";\n" +
				"		LDFLAGS = \"\";\n" +
				"\n" +
				"		CPU_DATA = PPCE200ZX {\n" +
				"			MODEL = E200Z7;\n" +
				"			APP_SRC = \"code.c\";\n" +
				"			MULTI_STACK = FALSE;\n" +
				"			VLE = TRUE;\n" +
				"		};\n" +
				"\n" +
				"		MCU_DATA = PPCE200ZX {\n" +
				"			MODEL = MPC5674F;\n" +
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
				"		\n" +
				"        KERNEL_TYPE = BCC1;\n" +
				"        EE_OPT = \"__OO_STARTOS_OLD__\";\n" +
				"\n" +
				"//		ORTI_SECTIONS = ALL;\n" +
				"    };\n" +
				"\n" +
				"    APPMODE ModeIncrement;\n" +
				"    APPMODE ModeDecrement;\n" +
				"\n" +
				"    TASK LowTask {\n" +
				"		PRIORITY = 0x01;\n" +
				"		ACTIVATION = 1;\n" +
				"		SCHEDULE = FULL;\n" +
				"		AUTOSTART = FALSE;\n" +
				"		STACK = SHARED;\n" +
				"		RESOURCE = Resource;\n" +
				"		RESOURCE = ResourceA;\n" +
				"    };\n" +
				"\n" +
				"    TASK HighTask {\n" +
				"		PRIORITY = 0x02;\n" +
				"		ACTIVATION = 1;\n" +
				"		SCHEDULE = FULL;\n" +
				"		AUTOSTART = TRUE { APPMODE=ModeIncrement; };	\n" +
				"		STACK = SHARED;\n" +
				"		RESOURCE = ResourceB;\n" +
				"		RESOURCE = ResourceC;\n" +
				"    };\n" +
				"\n" +
				"    RESOURCE Resource { RESOURCEPROPERTY = LINKED { LINKEDRESOURCE = RES_SCHEDULER; }; };\n" +
				"    RESOURCE ResourceA { RESOURCEPROPERTY = STANDARD; };\n" +
				"    RESOURCE ResourceB { RESOURCEPROPERTY = LINKED { LINKEDRESOURCE = ResourceA; }; };\n" +
				"    RESOURCE ResourceC { RESOURCEPROPERTY = LINKED { LINKEDRESOURCE = RES_SCHEDULER; }; };\n";
	    
	    final String wrongText = base + 
				"	OS EE {\n" +
				"		USERESSCHEDULER = FALSE;\n" +
				"    };\n" +
	    		"};";
	    final String rightText = base + 
				"	OS EE {\n" +
				"		USERESSCHEDULER = TRUE;\n" +
				"    };\n" +
	    		"};";

	    boolean ok = false;
	    try {
	    	commonWriterTest(wrongText, 1);
	    } catch (RuntimeException e) {
	    	ok = true;
	    }
	    assertTrue(ok);
    	commonWriterTest(rightText, 1);
	}
	

	
    final String base = " CPU test_application {\n" +
			"\n" +
			"	OS EE {\n" +
			"		CPU_DATA = PPCE200ZX {\n" +
			"			MODEL = E200Z7;\n" +
			"		};\n" +
			"\n" +
			"		MCU_DATA = PPCE200ZX {\n" +
			"			MODEL = MPC5674F;\n" +
			"		};\n" +
			"		\n" +
			"		\n" +
			"        KERNEL_TYPE = BCC1;\n" +
			"    };\n" +
			"    TASK LowTask {\n" +
			"		PRIORITY = 0x01;\n" +
			"		SCHEDULE = FULL;\n" +
			"		RESOURCE = Resource;\n" +
			"    };\n" +
			"\n" +
			"    RESOURCE Resource { RESOURCEPROPERTY = LINKED { LINKEDRESOURCE = RES_SCHEDULER; }; };\n";

    
    final String warning1Text = base + 
			"    RESOURCE RES_SCHEDULER { RESOURCEPROPERTY = STANDARD; };\n" +
    		"	OS EE {\n" +
			"		USERESSCHEDULER = FALSE;\n" +
			"    };\n" +
    		"};";

    final String warning2Text = base + 
			"    RESOURCE resa { RESOURCEPROPERTY = STANDARD; };\n" +
			"    RESOURCE RES_SCHEDULER { RESOURCEPROPERTY = LINKED { LINKEDRESOURCE = resa; }; };\n" +
    		"	OS EE {\n" +
			"		USERESSCHEDULER = FALSE;\n" +
			"    };\n" +
    		"};";
    final String right1Text = base + 
			"	OS EE {\n" +
			"		USERESSCHEDULER = TRUE;\n" +
			"    };\n" +
    		"};";
    final String right2Text = base + 
			"    RESOURCE RES_SCHEDULER { RESOURCEPROPERTY = STANDARD; };\n" +
			"	OS EE {\n" +
			"		USERESSCHEDULER = TRUE;\n" +
			"    };\n" +
    		"};";
    final String wrongText = base + 
			"    RESOURCE resa { RESOURCEPROPERTY = STANDARD; };\n" +
			"    RESOURCE RES_SCHEDULER { RESOURCEPROPERTY = LINKED { LINKEDRESOURCE = resa; }; };\n" +
    		"	OS EE {\n" +
			"		USERESSCHEDULER = TRUE;\n" +
			"    };\n" +
    		"};";
	public void testResSchedulerDefWrong1() {
	    boolean ok = false;
	    try {
	    	commonWriterTest(wrongText, 1);
	    } catch (RuntimeException e) {
	    	ok = true;
	    }
	    assertTrue(ok);
	}
	@Test
	public void testResSchedulerDefWarning1() {
    	commonWriterTest(warning1Text, 1);
	}
	@Test
	public void testResSchedulerDefWaringn2() {
    	commonWriterTest(warning2Text, 1);
	}
	@Test
	public void testResSchedulerDefRight1() {
    	commonWriterTest(right1Text, 1);
	}
	@Test
	public void testResSchedulerDefRight2() {
    	commonWriterTest(right2Text, 1);
	}
}
