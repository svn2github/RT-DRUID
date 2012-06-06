package com.eu.evidence.rtdruid.test.modules.oil.codewriter.autosar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.junit.Test;

import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
import com.eu.evidence.rtdruid.internal.modules.oil.reader.OilReader;
import com.eu.evidence.rtdruid.internal.modules.oil.workers.OilWorkerException;
import com.eu.evidence.rtdruid.internal.modules.oil.workers.StdOutLogger;
import com.eu.evidence.rtdruid.internal.modules.oil.workers.WorkerOilConfWriter;
import com.eu.evidence.rtdruid.io.IRTDMultiFileImporter;
import com.eu.evidence.rtdruid.io.MultiSourceImporterFactory;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.CommonUtils;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.RtosFactory;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.AbstractCodeWriterTest;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.VarTreeUtil;
import com.eu.evidence.rtdruid.vartree.Vt2StringUtilities;

public class CodeWriterMultiAutosar extends AbstractCodeWriterTest {

	@Test
	public void test1() throws IOException {

		String text = "CPU ActiveEcuC {\n" +
				"	OS EE {\n" +
				"		EE_OPT = \"DEBUG\";\n" +
				"		EE_OPT = \"__USE_BUTTONS__\";\n" +
				"		EE_OPT = \"__E200ZX_EXECUTE_FROM_RAM__\";\n" +
				"		EE_OPT = \"__STATIC_ISR_TABLE__\";\n" +
				"		CFLAGS = \"-tPPC5554EF:simple\";\n" +
				"		CFLAGS = \"-I.. -I../include -DUSE_QUOTE_INCLUDES\";\n" +
				"		LDFLAGS = \"-tPPC5554EF:simple -lc -lm -m6\";\n" +
				"		ASFLAGS = \"\";\n" +
				"		CPU_DATA = PPCE200ZX {\n" +
				"			MODEL = E200Z7;\n" +
				"			CPU_CLOCK = 60.0;\n" +
				"			APP_SRC = \"./Autosar_Stubs.c\";\n" +
				"			APP_SRC = \"./bsw_init.c\";\n" +
				"			APP_SRC = \"./main.c\";\n" +
				"			APP_SRC = \"./src/Appl_Dcm.c\";\n" +
				"			APP_SRC = \"./src/BswM.c\";\n" +
				"			APP_SRC = \"./src/BswM_LCfg.c\";\n" +
				"			APP_SRC = \"./src/Can.c\";\n" +
				"			APP_SRC = \"./src/CanIf.c\";\n" +
				"			APP_SRC = \"./src/CanIf_Lcfg.c\";\n" +
				"			APP_SRC = \"./src/CanIf_PBcfg.c\";\n" +
				"			APP_SRC = \"./src/Can_Irq.c\";\n" +
				"			APP_SRC = \"./src/Can_Lcfg.c\";\n" +
				"			APP_SRC = \"./src/Can_PBcfg.c\";\n" +
				"			APP_SRC = \"./src/CanSM.c\";\n" +
				"			APP_SRC = \"./src/CanSM_Lcfg.c\";\n" +
				"			APP_SRC = \"./src/CanSM_PBcfg.c\";\n" +
				"			APP_SRC = \"./src/CanTp.c\";\n" +
				"			MULTI_STACK = TRUE {\n" +
				"				IRQ_STACK = TRUE {\n" +
				"					SYS_SIZE = 128;\n" +
				"				};\n" +
				"			};\n" +
				"		};\n" +
				"		MCU_DATA = PPCE200ZX {\n" +
				"			MODEL = MPC5674F;\n" +
				"		};\n" +
				"		\n" +
				"		KERNEL_TYPE = ECC1;\n" +
				"	};\n" +
				"};\n";
		
		File dir = new File("D:\\work\\autosar_test\\all");
		File[] files = dir.listFiles();
		ArrayList<String> types = new ArrayList<String>();
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<InputStream> inputs = new ArrayList<InputStream>();
		for (File f: files) {
			if (f.getName().endsWith(".arxml")) {
				types.add("arxml");
				names.add(f.getAbsolutePath());
				inputs.add(new FileInputStream(f));
			}
		}
		
		IRTDMultiFileImporter importer = MultiSourceImporterFactory.getFactory().getImporterFor(types.toArray(new String[types.size()]));
		assertNotNull(importer);
		IVarTree vt = VarTreeUtil.newVarTree();
		EObject root = importer.load((InputStream[]) inputs.toArray(new InputStream[inputs.size()]), names.toArray(new String[names.size()]), null);
		assertNotNull(root);
		vt.setRoot(root);
		
		System.out.println("\t------------OIL------------\n\n");
		System.out.println(Vt2StringUtilities.writeString(vt, "oil"));
		System.out.println("\t------------FINE OIL------------\n\n");
		
		
		(new OilReader()).load(new ByteArrayInputStream(text.getBytes()), vt);

		System.out.println("\t------------ERTD------------\n\n");
		System.out.println(Vt2StringUtilities.explodeOilVar(Vt2StringUtilities.writeString(vt, "ertd")));
		System.out.println("\t------------FINE ERTD------------\n\n");

		System.out.println("\t------------ALTRO OIL------------\n\n");
		String OIL = Vt2StringUtilities.writeString(vt, "oil");
		System.out.println(OIL);
		System.out.println("\t------------FINE ALTRO OIL------------\n\n");

		// -------------- search rtos ----------------
		ITreeInterface ti = vt.newTreeInterface();

		String[] prefix = CommonUtils.getAllRtos(ti);
		assertEquals(1, prefix.length);

		// --------------- write -----------------

		IOilWriterBuffer[] buffers = null;
		try {
			buffers = RtosFactory.INSTANCE.write(vt, prefix);
		} catch (OilCodeWriterException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException("Write fail: " + e.getMessage(), e);
		}

		final int expectedSize = 1;
		assertNotNull(buffers);
		assertEquals(expectedSize, buffers.length);

	    DefaultTestResult result = commonWriterTest(OIL, 1);
		for (int i=0; i<expectedSize; i++) {
			assertEquals(buffers[i].toString(), result.buffers[i].toString());
		}
	}

	@Test
	public void testMulti() throws IOException, OilWorkerException {
		
		WorkerOilConfWriter worker = new WorkerOilConfWriter(new StdOutLogger()) {
			// override worker's save method
			@Override
			protected void save(IOilWriterBuffer[] buffers) {
				for (IOilWriterBuffer buff : buffers) {
					System.out.println(buff.toString());
				}
			}
		};
		
		
		File dir = new File("D:\\work\\autosar_test\\sd");
		File[] files = dir.listFiles();
		for (File f: files) {
			if (f.getName().endsWith(".arxml") || f.getName().endsWith(".oil") ) {
				worker.addInputfile(f.getAbsolutePath());
			}
		}

		worker.setOutputdir("e:/");
		worker.execute();
	}

	@Test
	public void testMixedMulti() throws IOException, OilWorkerException {
		
		WorkerOilConfWriter worker = new WorkerOilConfWriter(new StdOutLogger()) {
			// override worker's save method
			@Override
			protected void save(IOilWriterBuffer[] buffers) {
				for (IOilWriterBuffer buff : buffers) {
					System.out.println(buff.toString());
				}
			}
		};
		
//		{
//			File dir = new File("D:\\work\\autosar_test\\e");
//			File[] files = dir.listFiles();
//			for (File f: files) {
//				if (f.getName().endsWith(".oil") ) {
//					worker.addInputfile(f.getAbsolutePath());
//				}
//			}
//		}

		{
			File dir = new File("D:\\work\\autosar_test\\all");
			File[] files = dir.listFiles();
			for (File f: files) {
				if (f.getName().endsWith(".arxml") || f.getName().endsWith(".oil") ) {
					worker.addInputfile(f.getAbsolutePath());
				}
			}
		}
		
		{
			File dir = new File("D:\\work\\autosar_test\\sd");
			File[] files = dir.listFiles();
			for (File f: files) {
				if (f.getName().endsWith(".arxml") || f.getName().endsWith(".oil") ) {
					worker.addInputfile(f.getAbsolutePath());
				}
			}
		}


		worker.setOutputdir("e:/");
		worker.execute();
	}

	
	@Test
	public void testsplitted_os_application() {
	    final String text1 = "CPU test_application {\n" +
			"\n" +
			"	OS EE {		\n" +
			"		EE_OPT = \"DEBUG_STACK\";\n" +
			"\n" +
			"		CFLAGS = \"-g2\";\n" +
			"		ASFLAGS = \"\";\n" +
			"		LDFLAGS = \"\"; \n" +
			"\n" +
			"		CPU_DATA = PPCE200ZX {\n" +
			"			APP_SRC = \"main.c\";\n" +
			"			MULTI_STACK = TRUE {\n" + 
			"				IRQ_STACK = TRUE {\n" + 
			"					SYS_SIZE=64;\n" + 
			"				};\n" + 
			"			};\n" + 
			"			MODEL = E200Z6;\n" +
			"		};\n" +
			"		\n" +
			"		MCU_DATA = PPCE200ZX {\n" +
			"			MODEL = MPC5668G;\n" + 
			"		};\n" +
			"		\n" +
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
			"    };\n" +
			"    \n" +
			"    APPLICATION appl1 {\n" +
			"		TRUSTED = FALSE;\n" +
			"		IRQ_STACK_SIZE = 1024;\n" +
    		"		SHARED_STACK_SIZE = 512;\n"+
			"		TASK=Task1;\n" +
			"    };\n" +
			"    \n" +
			"    APPLICATION appl1 {\n" +
			"		TASK=Task_app1;\n" +
			"       ISR = isr_base1;\n" +
			"       ISR = isr_app1;\n" +
    		"		MEMORY_BASE = 0x40020000;\n"+
    		"		MEMORY_SIZE = 0x10000;\n"+
			"    };\n" +
			"    APPLICATION appl2 {\n" +
			"		TRUSTED = FALSE;\n" +
			"		IRQ_STACK_SIZE = 512;\n" +
    		"		SHARED_STACK_SIZE = 512;\n"+
			"		TASK=Task2;\n" +
    		"		MEMORY_BASE = 0x40020000;\n"+
    		"		MEMORY_SIZE = 0x10000;\n"+
			"    };\n" +
			"    /* this is the OIL part for the first task */\n" +
			"    TASK Task1 {\n" +
			"		PRIORITY = 0x01;   /* Low priority */\n" +
			"		AUTOSTART = FALSE;\n" +
			"		STACK = PRIVATE {\n" +
			"			SYS_SIZE = 512;\n" +
			"		};\n" +
			"		ACTIVATION = 1;    /* only one pending activation */\n" +
			"	};	\n" +
			"\n" +
			"    /* this is the OIL part for the second task */\n" +
			"    TASK Task2 {\n" +
			"		PRIORITY = 0x02;   /* High priority */\n" +
			"		AUTOSTART = FALSE;\n" +
			"		STACK = SHARED;\n" +
			"		ACTIVATION = 1;    /* only one pending activation */\n" +
			"	};	\n" +
			"\n" +
			"    TASK Task_app1 {\n" +
			"		PRIORITY = 0x01;   /* Low priority */\n" +
			"		AUTOSTART = FALSE;\n" +
			"		STACK = PRIVATE {\n" +
			"			SYS_SIZE = 512;\n" +
			"		};\n" +
			"		ACTIVATION = 1;    /* only one pending activation */\n" +
			"	};	\n" +
			"    ISR isr_base1 {\n" +
			"		CATEGORY = 2;\n" +
			"	};	\n" +			
			"    ISR isr_app1 {\n" +
			"		CATEGORY = 2;\n" +
			"	};	\n" +			
			"    OS EE { \n" +
			"		KERNEL_TYPE = ECC2;\n" +
			"		ORTI_SECTIONS = ALL;\n" +
			"		MAX_NESTING_LEVEL = 8;\n" +
			"  }; 	\n" +
			"};";
	    
	    final String expectedResult = "CPU test_application {\n" +
				"\n" +
				"	OS EE {		\n" +
				"		EE_OPT = \"DEBUG_STACK\";\n" +
				"\n" +
				"		CFLAGS = \"-g2\";\n" +
				"		ASFLAGS = \"\";\n" +
				"		LDFLAGS = \"\"; \n" +
				"\n" +
				"		CPU_DATA = PPCE200ZX {\n" +
				"			APP_SRC = \"main.c\";\n" +
				"			MULTI_STACK = TRUE {\n" + 
				"				IRQ_STACK = TRUE {\n" + 
				"					SYS_SIZE=64;\n" + 
				"				};\n" + 
				"			};\n" + 
				"			MODEL = E200Z6;\n" +
				"		};\n" +
				"		\n" +
				"		MCU_DATA = PPCE200ZX {\n" +
				"			MODEL = MPC5668G;\n" + 
				"		};\n" +
				"		\n" +
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
				"    };\n" +
				"    \n" +
				"    APPLICATION appl1 {\n" +
				"		TRUSTED = FALSE;\n" +
				"		IRQ_STACK_SIZE = 1024;\n" +
	    		"		SHARED_STACK_SIZE = 512;\n"+
				"		TASK=Task1;\n" +
				"		TASK=Task_app1;\n" +
				"       ISR = isr_base1;\n" +
				"       ISR = isr_app1;\n" +
	    		"		MEMORY_BASE = 0x40020000;\n"+
	    		"		MEMORY_SIZE = 0x10000;\n"+
				"    };\n" +
				"    APPLICATION appl2 {\n" +
				"		TRUSTED = FALSE;\n" +
				"		IRQ_STACK_SIZE = 512;\n" +
	    		"		SHARED_STACK_SIZE = 512;\n"+
				"		TASK=Task2;\n" +
	    		"		MEMORY_BASE = 0x40020000;\n"+
	    		"		MEMORY_SIZE = 0x10000;\n"+
				"    };\n" +
				"    /* this is the OIL part for the first task */\n" +
				"    TASK Task1 {\n" +
				"		PRIORITY = 0x01;   /* Low priority */\n" +
				"		AUTOSTART = FALSE;\n" +
				"		STACK = PRIVATE {\n" +
				"			SYS_SIZE = 512;\n" +
				"		};\n" +
				"		ACTIVATION = 1;    /* only one pending activation */\n" +
				"	};	\n" +
				"\n" +
				"    /* this is the OIL part for the second task */\n" +
				"    TASK Task2 {\n" +
				"		PRIORITY = 0x02;   /* High priority */\n" +
				"		AUTOSTART = FALSE;\n" +
				"		STACK = SHARED;\n" +
				"		ACTIVATION = 1;    /* only one pending activation */\n" +
				"	};	\n" +
				"\n" +
				"    TASK Task_app1 {\n" +
				"		PRIORITY = 0x01;   /* Low priority */\n" +
				"		AUTOSTART = FALSE;\n" +
				"		STACK = PRIVATE {\n" +
				"			SYS_SIZE = 512;\n" +
				"		};\n" +
				"		ACTIVATION = 1;    /* only one pending activation */\n" +
				"	};	\n" +
				"    ISR isr_base1 {\n" +
				"		CATEGORY = 2;\n" +
				"	};	\n" +			
				"    ISR isr_app1 {\n" +
				"		CATEGORY = 2;\n" +
				"	};	\n" +			
				"    OS EE { \n" +
				"		KERNEL_TYPE = ECC2;\n" +
				"		ORTI_SECTIONS = ALL;\n" +
				"		MAX_NESTING_LEVEL = 8;\n" +
				"  }; 	\n" +
				"};";
	    
		DefaultTestResult r1 = commonWriterTest(text1, 1);
		DefaultTestResult r2 = commonWriterTest(expectedResult, 1);
		
		assertEquals(r1.buffers.length, r2.buffers.length);
		for (int i = 0; i<r1.buffers.length; i++) {
			assertEquals(r1.buffers[i].toString(), r2.buffers[i].toString());
			
		}
	}
	
	@Test
	public void testsplitted_os_application2() throws IOException {
	    final String input1 = "CPU test_application {\n" +
			"\n" +
			"	OS EE {		\n" +
			"		EE_OPT = \"DEBUG_STACK\";\n" +
			"\n" +
			"		CFLAGS = \"-g2\";\n" +
			"		ASFLAGS = \"\";\n" +
			"		LDFLAGS = \"\"; \n" +
			"\n" +
			"		CPU_DATA = PPCE200ZX {\n" +
			"			APP_SRC = \"main.c\";\n" +
			"			MULTI_STACK = TRUE {\n" + 
			"				IRQ_STACK = TRUE {\n" + 
			"					SYS_SIZE=64;\n" + 
			"				};\n" + 
			"			};\n" + 
			"			MODEL = E200Z6;\n" +
			"		};\n" +
			"		\n" +
			"		MCU_DATA = PPCE200ZX {\n" +
			"			MODEL = MPC5668G;\n" + 
			"		};\n" +
			"		\n" +
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
			"    };\n" +
			"    \n" +
			"    APPLICATION appl1 {\n" +
			"		TRUSTED = FALSE;\n" +
			"		IRQ_STACK_SIZE = 1024;\n" +
    		"		SHARED_STACK_SIZE = 512;\n"+
			"		TASK=Task1;\n" +
			"    };\n" +
			"};\n";

	    final String input2 = "CPU another_test_application {\n" +
			"    \n" +
			"    APPLICATION appl1 {\n" +
			"		TASK=Task_app1;\n" +
			"       ISR = isr_base1;\n" +
			"       ISR = isr_app1;\n" +
    		"		MEMORY_BASE = 0x40020000;\n"+
    		"		MEMORY_SIZE = 0x10000;\n"+
			"    };\n" +
			"    APPLICATION appl2 {\n" +
			"		TRUSTED = FALSE;\n" +
			"		IRQ_STACK_SIZE = 512;\n" +
    		"		SHARED_STACK_SIZE = 512;\n"+
			"		TASK=Task2;\n" +
    		"		MEMORY_BASE = 0x40020000;\n"+
    		"		MEMORY_SIZE = 0x10000;\n"+
			"    };\n" +
			"    /* this is the OIL part for the first task */\n" +
			"    TASK Task1 {\n" +
			"		PRIORITY = 0x01;   /* Low priority */\n" +
			"		AUTOSTART = FALSE;\n" +
			"		STACK = PRIVATE {\n" +
			"			SYS_SIZE = 512;\n" +
			"		};\n" +
			"		ACTIVATION = 1;    /* only one pending activation */\n" +
			"	};	\n" +
			"\n" +
			"    /* this is the OIL part for the second task */\n" +
			"    TASK Task2 {\n" +
			"		PRIORITY = 0x02;   /* High priority */\n" +
			"		AUTOSTART = FALSE;\n" +
			"		STACK = SHARED;\n" +
			"		ACTIVATION = 1;    /* only one pending activation */\n" +
			"	};	\n" +
			"\n" +
			"    TASK Task_app1 {\n" +
			"		PRIORITY = 0x01;   /* Low priority */\n" +
			"		AUTOSTART = FALSE;\n" +
			"		STACK = PRIVATE {\n" +
			"			SYS_SIZE = 512;\n" +
			"		};\n" +
			"		ACTIVATION = 1;    /* only one pending activation */\n" +
			"	};	\n" +
			"    ISR isr_base1 {\n" +
			"		CATEGORY = 2;\n" +
			"	};	\n" +			
			"    ISR isr_app1 {\n" +
			"		CATEGORY = 2;\n" +
			"	};	\n" +			
			"    OS EE { \n" +
			"		KERNEL_TYPE = ECC2;\n" +
			"		ORTI_SECTIONS = ALL;\n" +
			"		MAX_NESTING_LEVEL = 8;\n" +
			"  }; 	\n" +
			"};";
	    
	    final String expectedResult = "CPU test_application {\n" +
				"\n" +
				"	OS EE {		\n" +
				"		EE_OPT = \"DEBUG_STACK\";\n" +
				"\n" +
				"		CFLAGS = \"-g2\";\n" +
				"		ASFLAGS = \"\";\n" +
				"		LDFLAGS = \"\"; \n" +
				"\n" +
				"		CPU_DATA = PPCE200ZX {\n" +
				"			APP_SRC = \"main.c\";\n" +
				"			MULTI_STACK = TRUE {\n" + 
				"				IRQ_STACK = TRUE {\n" + 
				"					SYS_SIZE=64;\n" + 
				"				};\n" + 
				"			};\n" + 
				"			MODEL = E200Z6;\n" +
				"		};\n" +
				"		\n" +
				"		MCU_DATA = PPCE200ZX {\n" +
				"			MODEL = MPC5668G;\n" + 
				"		};\n" +
				"		\n" +
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
				"    };\n" +
				"    \n" +
				"    APPLICATION appl1 {\n" +
				"		TRUSTED = FALSE;\n" +
				"		IRQ_STACK_SIZE = 1024;\n" +
	    		"		SHARED_STACK_SIZE = 512;\n"+
				"		TASK=Task1;\n" +
				"		TASK=Task_app1;\n" +
				"       ISR = isr_base1;\n" +
				"       ISR = isr_app1;\n" +
	    		"		MEMORY_BASE = 0x40020000;\n"+
	    		"		MEMORY_SIZE = 0x10000;\n"+
				"    };\n" +
				"    APPLICATION appl2 {\n" +
				"		TRUSTED = FALSE;\n" +
				"		IRQ_STACK_SIZE = 512;\n" +
	    		"		SHARED_STACK_SIZE = 512;\n"+
				"		TASK=Task2;\n" +
	    		"		MEMORY_BASE = 0x40020000;\n"+
	    		"		MEMORY_SIZE = 0x10000;\n"+
				"    };\n" +
				"    /* this is the OIL part for the first task */\n" +
				"    TASK Task1 {\n" +
				"		PRIORITY = 0x01;   /* Low priority */\n" +
				"		AUTOSTART = FALSE;\n" +
				"		STACK = PRIVATE {\n" +
				"			SYS_SIZE = 512;\n" +
				"		};\n" +
				"		ACTIVATION = 1;    /* only one pending activation */\n" +
				"	};	\n" +
				"\n" +
				"    /* this is the OIL part for the second task */\n" +
				"    TASK Task2 {\n" +
				"		PRIORITY = 0x02;   /* High priority */\n" +
				"		AUTOSTART = FALSE;\n" +
				"		STACK = SHARED;\n" +
				"		ACTIVATION = 1;    /* only one pending activation */\n" +
				"	};	\n" +
				"\n" +
				"    TASK Task_app1 {\n" +
				"		PRIORITY = 0x01;   /* Low priority */\n" +
				"		AUTOSTART = FALSE;\n" +
				"		STACK = PRIVATE {\n" +
				"			SYS_SIZE = 512;\n" +
				"		};\n" +
				"		ACTIVATION = 1;    /* only one pending activation */\n" +
				"	};	\n" +
				"    ISR isr_base1 {\n" +
				"		CATEGORY = 2;\n" +
				"	};	\n" +			
				"    ISR isr_app1 {\n" +
				"		CATEGORY = 2;\n" +
				"	};	\n" +			
				"    OS EE { \n" +
				"		KERNEL_TYPE = ECC2;\n" +
				"		ORTI_SECTIONS = ALL;\n" +
				"		MAX_NESTING_LEVEL = 8;\n" +
				"  }; 	\n" +
				"};";
	    
		DefaultTestResult r1 = commonWriterTest(new String[] {input1, input2}, new String[] {"input1.oil", "input1.oil"}, 1);
		DefaultTestResult r2 = commonWriterTest(expectedResult, 1);
		
		assertEquals(r1.buffers.length, r2.buffers.length);
		for (int i = 0; i<r1.buffers.length; i++) {
			assertEquals(r1.buffers[i].toString(), r2.buffers[i].toString());
			
		}
	}
}
