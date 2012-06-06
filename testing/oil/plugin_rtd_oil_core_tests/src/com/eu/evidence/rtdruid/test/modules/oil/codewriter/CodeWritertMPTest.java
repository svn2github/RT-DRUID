/*
 * Created on Dec 2, 2004
 *
 * $Id: CodeWritertMPTest.java,v 1.5 2007/09/12 15:59:10 durin Exp $
 */
package com.eu.evidence.rtdruid.test.modules.oil.codewriter;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;

import org.junit.Test;

import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
import com.eu.evidence.rtdruid.internal.modules.oil.reader.OilReader;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.RtosFactory;
import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.VarTreeUtil;
import com.eu.evidence.rtdruid.vartree.Vt2StringUtilities;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;

/**
 * 
 * @author Nicola Serreli
 */
public class CodeWritertMPTest extends AbstractCodeWriterTest {
	
	// UPDRTD SPEZZARE X ARCHITTETURA

	final static private String S = "" + DataPath.SEPARATOR;

	final static public String DEFAULT_EE_IMPLEMENTATION ="";// CodeWritertTest.DEFAULT_EE_IMPLEMENTATION;

	final static protected String OIL_TEST_2_NIOS = DEFAULT_EE_IMPLEMENTATION
			+ "CPU EE {\n"
			+ "    OS EE {\n"
			+ "        EE_OPT = \"__ASSERT__\";\n"
			+ "        EE_OPT = \"__OSEKOS_NO_ALARMS__\";\n"
			+ "        EE_OPT = \"DEBUG\";\n"

			+ "        CFLAGS = \"-DALT_DEBUG -G0 -O0 -g\";\n"
			+ "        CFLAGS = \"-Wall -Wl,-Map -Wl,project.map\";\n"
			+ "        ASFLAGS = \"-g\";\n"
			+ "        LDDEPS = \"\\\";\n"
			+ "        LIBS = \"-lm\";\n"
			+ "        NIOS2_SYS_CONFIG = \"DEBUG\";\n"
			+ "        NIOS2_APP_CONFIG = \"DEBUG\";\n"
			+ "        NIOS2_DO_MAKE_OBJDUMP = TRUE;\n"
			+ "        NIOS2_JAM_FILE = \"test_file.jam\";\n"+
			"		   IPIC_GLOBAL_NAME = \"Ipic_subsystem\";\n" +
			"		NIOS2_PTF_FILE = \"C:/altera/81/nios2eds/examples/verilog/niosII_stratixII_2s60_RoHS/frsh_small/NiosII_stratixII_2s60_RoHS_small_sopc.ptf\";\n" +
			
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
			+ "        STACK_TOP = 0x20004000;\n"
//			+ "        STACK_BOTTOM = 0x20001800;\n"
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
			+ "        STACK_TOP = 0x20008000;\n"
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

	@Test
	public void testCodeWrite1() throws OilCodeWriterException {
		IVarTree vt = VarTreeUtil.newVarTree();
		(new OilReader()).load(new ByteArrayInputStream(OIL_TEST_2_NIOS.getBytes()),
				vt);

		DataPackage dpkg = DataPackage.eINSTANCE;
		String prefix1 = "EE" + S + dpkg.getSystem_Architectural().getName() + S
				+ dpkg.getArchitectural_EcuList().getName() + S + "EE" + S
				+ dpkg.getEcu_CpuList().getName() + S + "cpu1" + S
				+ dpkg.getCpu_Rtos().getName();

		assertTrue(vt.newTreeInterface().exist(prefix1,
				DataPackage.eINSTANCE.getRtos().getName()));

		String prefix2 = "EE" + S + dpkg.getSystem_Architectural().getName() + S
			+ dpkg.getArchitectural_EcuList().getName() + S + "EE" + S
			+ dpkg.getEcu_CpuList().getName() + S + "cpu2" + S
			+ dpkg.getCpu_Rtos().getName();
	
		assertTrue(vt.newTreeInterface().exist(prefix2,
				DataPackage.eINSTANCE.getRtos().getName()));

		IOilWriterBuffer[] buffers = null;
		buffers = RtosFactory.INSTANCE.write(vt, new String[] { prefix1, prefix2 });

		assertNotNull(buffers);
		assertEquals(2, buffers.length );
		System.out.println((buffers[0]).toString());
		System.out.println((buffers[1]).toString());

	}

	final static protected String OIL_TEST_2_NIOS_WITH_GLOBAL_RESOURCES = DEFAULT_EE_IMPLEMENTATION
			+ "CPU EE {\n"
			+ "    OS EE {\n"
			+ "        EE_OPT = \"__ASSERT__\";\n"
			+ "        EE_OPT = \"__OSEKOS_NO_ALARMS__\";\n"
			+ "        EE_OPT = \"DEBUG\";\n"

			+ "        CFLAGS = \"cflag1\";\n"
			+ "        CFLAGS = \"cflag2\";\n"
			+ "        CFLAGS = \"(coppia>>) cflag1 cflag2 (<<coppia)\";\n"
			+ "        CFLAGS = \"cflag3\";\n"
			+ "        CFLAGS = \"cflag3\";\n"
			+ "        CFLAGS = \"cflag3\";\n"
					
			+ "        ASFLAGS = \"-g\";\n"
			+ "        LDFLAGS = \"ldflag\";\n"
			+ "        LDDEPS = \"\\\";\n"
			+ "        LIBS = \"-lm\";\n"
			+ "        NIOS2_SYS_CONFIG = \"DEBUG\";\n"
			+ "        NIOS2_APP_CONFIG = \"DEBUG\";\n"
			+ "        NIOS2_DO_MAKE_OBJDUMP = TRUE;\n"+
			"		   IPIC_GLOBAL_NAME = \"Ipic_subsystem\";\n" +
			"		NIOS2_PTF_FILE = \"C:/altera/81/nios2eds/examples/verilog/niosII_stratixII_2s60_RoHS/frsh_small/NiosII_stratixII_2s60_RoHS_small_sopc.ptf\";\n" +
			
			"		MASTER_CPU = \"cpu2\";\n" +


			"		CPU_DATA = NIOSII {\n" +
			"			ID = \"cpu1\";\n" +
			"			MULTI_STACK = TRUE {\n" +
			"				IRQ_STACK = FALSE;\n" +
			"				DUMMY_STACK = SHARED;\n" +
			"			};\n" +
			"			\n" +
			"			APP_SRC = \"code_1.c\";\n" +
			"	\n" 
			+ "        STACK_TOP = 0x20004000;\n"
//			//+ "        STACK_BOTTOM = 0x20001800;\n"
			+ "        SYS_SIZE = 0x1002;\n" 
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
			+ "        STACK_TOP = 0x20008000;\n"
			//+ "        STACK_BOTTOM = 0x20004000;\n"
			+ "        SYS_SIZE = 0x1001;\n"
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
			+ "    };\n"
			+ "    TASK Task1 {\n"
			+ "        CPU_ID = \"cpu1\";"
			+ "        PRIORITY = 0x01;\n"
			+ "        ACTIVATION = 4;\n"
			+ "        SCHEDULE = FULL;\n"
			+ "        AUTOSTART = TRUE;\n"
			+ "        STACK = PRIVATE {\n"
			+ "            SYS_SIZE = 0x103;\n"
			+ "        };\n"
			+ "        EVENT = evento1;\n"
			+ "        RESOURCE = res1;\n"
			+ "        RESOURCE = res2;\n"
			+ "        RESOURCE = res4;\n"
			+ "    };\n"
			+ "    TASK Task2 {\n"
			+ "        CPU_ID = \"cpu1\";"
			+ "        PRIORITY = 0x02;\n"
			+ "        ACTIVATION = 1;\n"
			+ "        SCHEDULE = FULL;\n"
			+ "        AUTOSTART = TRUE;\n"
			+ "        STACK = SHARED;\n"
			+ "        RESOURCE = res1;\n"
			+ "    };\n"
			+ "    TASK Task3 {\n"
			+ "        CPU_ID = \"cpu2\";"
			+ "        PRIORITY = 0x04;\n"
			+ "        ACTIVATION = 1;\n"
			+ "        SCHEDULE = FULL;\n"
			+ "        AUTOSTART = TRUE;\n"
			+ "        STACK = SHARED;\n"
			+ "        RESOURCE = res1;\n"
			+ "        RESOURCE = res3;\n"
			+ "        RESOURCE = res4;\n"
			+ "    };\n"
			+ "	   EVENT evento1 {};\n"
			+ "    RESOURCE res1 {"
			+ "        RESOURCEPROPERTY = STANDARD;\n"
			+ "    };\n"
			+ "    RESOURCE res2 {"
			+ "        RESOURCEPROPERTY = STANDARD;\n"
			+ "    };\n"
			+ "    RESOURCE res3 {"
			+ "        RESOURCEPROPERTY = STANDARD;\n"
			+ "    };\n"
			+ "    RESOURCE res4 {"
			+ "        RESOURCEPROPERTY = STANDARD;\n"
			+ "    };\n"
			+ "};\n";

	@Test
	public void testGlobalResources() {
		IVarTree vt = VarTreeUtil.newVarTree();
		(new OilReader()).load(new ByteArrayInputStream(OIL_TEST_2_NIOS_WITH_GLOBAL_RESOURCES
				.getBytes()), vt);

		DataPackage dpkg = DataPackage.eINSTANCE;
		String prefix1 = "EE" + S + dpkg.getSystem_Architectural().getName()
				+ S + dpkg.getArchitectural_EcuList().getName() + S + "EE" + S
				+ dpkg.getEcu_CpuList().getName() + S + "cpu1" + S
				+ dpkg.getCpu_Rtos().getName();

		assertTrue(vt.newTreeInterface().exist(prefix1,
				DataPackage.eINSTANCE.getRtos().getName()));

		String prefix2 = "EE" + S + dpkg.getSystem_Architectural().getName()
				+ S + dpkg.getArchitectural_EcuList().getName() + S + "EE" + S
				+ dpkg.getEcu_CpuList().getName() + S + "cpu2" + S
				+ dpkg.getCpu_Rtos().getName();

		assertTrue(vt.newTreeInterface().exist(prefix2,
				DataPackage.eINSTANCE.getRtos().getName()));

		IOilWriterBuffer[] buffers = null;
		try {
			buffers = RtosFactory.INSTANCE.write(vt, new String[] { prefix1,
					prefix2 });
		} catch (OilCodeWriterException e) {
			e.printStackTrace();
			assertTrue(false);
		}

		assertNotNull(buffers);
		assertEquals(2, buffers.length );
		System.out.println((buffers[0]).toString());
		System.out.println((buffers[1]).toString());

	}

	final static protected String OIL_TEST_2_NIOS_WITH_GLOBAL_RESOURCES_BIS = DEFAULT_EE_IMPLEMENTATION
	+ "CPU EE {\n"
	+ "    OS EE {\n"
	+ "        EE_OPT = \"__ASSERT__\";\n"
	+ "        EE_OPT = \"__OSEKOS_NO_ALARMS__\";\n"
	+ "        EE_OPT = \"DEBUG\";\n"

	+ "        CFLAGS = \"cflag1\";\n"
	+ "        CFLAGS = \"cflag2\";\n"
	+ "        CFLAGS = \"(coppia>>) cflag1 cflag2 (<<coppia)\";\n"
	+ "        CFLAGS = \"cflag3\";\n"
	+ "        CFLAGS = \"cflag3\";\n"
	+ "        CFLAGS = \"cflag3\";\n"
			
	+ "        ASFLAGS = \"-g\";\n"
	+ "        LDFLAGS = \"ldflag\";\n"
	+ "        LDDEPS = \"\\\";\n"
	+ "        LIBS = \"-lm\";\n"
	+ "        NIOS2_SYS_CONFIG = \"DEBUG\";\n"
	+ "        NIOS2_APP_CONFIG = \"DEBUG\";\n"
	+ "        NIOS2_DO_MAKE_OBJDUMP = TRUE;\n"+
	"		   IPIC_GLOBAL_NAME = \"Ipic_subsystem\";\n" +
	"		NIOS2_PTF_FILE = \"C:/altera/81/nios2eds/examples/verilog/niosII_stratixII_2s60_RoHS/frsh_small/NiosII_stratixII_2s60_RoHS_small_sopc.ptf\";\n" +
	
	"		MASTER_CPU = \"cpu2\";\n" +


	"		CPU_DATA = NIOSII {\n" +
	"			ID = \"cpu1\";\n" +
	"			MULTI_STACK = TRUE {\n" +
	"				IRQ_STACK = FALSE;\n" +
	"				DUMMY_STACK = SHARED;\n" +
	"			};\n" +
	"			\n" +
	"			APP_SRC = \"code_1.c\";\n" +
	"	\n" 
	+ "        STACK_TOP = 0x20004000;\n"
//	//+ "        STACK_BOTTOM = 0x20001800;\n"
	+ "        SHARED_MIN_SYS_SIZE = 0x800;\n" 
	+ "        SYS_SIZE = 0x1002;\n" 
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
	+ "        STACK_TOP = 0x20008000;\n"
	//+ "        STACK_BOTTOM = 0x20004000;\n"
	+ "        SHARED_MIN_SYS_SIZE = 0x800;\n" 
	+ "        SYS_SIZE = 0x1001;\n"
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
	+ "    };\n"
	+ "    TASK Task1 {\n"
	+ "        CPU_ID = \"cpu1\";"
	+ "        PRIORITY = 0x01;\n"
	+ "        ACTIVATION = 4;\n"
	+ "        SCHEDULE = FULL;\n"
	+ "        AUTOSTART = TRUE;\n"
	+ "        STACK = PRIVATE {\n"
	+ "            SYS_SIZE = 0x103;\n"
	+ "        };\n"
	+ "        EVENT = evento1;\n"
	+ "        RESOURCE = res1;\n"
	+ "        RESOURCE = res2;\n"
	+ "    };\n"
	+ "    TASK Task2 {\n"
	+ "        CPU_ID = \"cpu1\";"
	+ "        PRIORITY = 0x02;\n"
	+ "        ACTIVATION = 1;\n"
	+ "        SCHEDULE = FULL;\n"
	+ "        AUTOSTART = TRUE;\n"
	+ "        STACK = SHARED;\n"
	+ "        RESOURCE = res1;\n"
	+ "    };\n"
	+ "    TASK Task3 {\n"
	+ "        CPU_ID = \"cpu2\";"
	+ "        PRIORITY = 0x04;\n"
	+ "        ACTIVATION = 1;\n"
	+ "        SCHEDULE = FULL;\n"
	+ "        AUTOSTART = TRUE;\n"
	+ "        STACK = SHARED;\n"
	+ "        RESOURCE = res1;\n"
	+ "        RESOURCE = res3;\n"
	+ "    };\n"
	+ "	   EVENT evento1 {};\n"
	+ "    RESOURCE res1 {"
	+ "        RESOURCEPROPERTY = STANDARD;\n"
	+ "    };\n"
	+ "    RESOURCE res2 {"
	+ "        RESOURCEPROPERTY = STANDARD;\n"
	+ "    };\n"
	+ "    RESOURCE res3 {"
	+ "        RESOURCEPROPERTY = STANDARD;\n"
	+ "    };\n"
	+ "};\n";

	@Test
	public void testGlobalResourcesBis() {
		IVarTree vt = VarTreeUtil.newVarTree();
		(new OilReader()).load(new ByteArrayInputStream(
				OIL_TEST_2_NIOS_WITH_GLOBAL_RESOURCES_BIS.getBytes()), vt);

		DataPackage dpkg = DataPackage.eINSTANCE;
		String prefix1 = "EE" + S + dpkg.getSystem_Architectural().getName()
				+ S + dpkg.getArchitectural_EcuList().getName() + S + "EE" + S
				+ dpkg.getEcu_CpuList().getName() + S + "cpu1" + S
				+ dpkg.getCpu_Rtos().getName();

		assertTrue(vt.newTreeInterface().exist(prefix1,
				DataPackage.eINSTANCE.getRtos().getName()));

		String prefix2 = "EE" + S + dpkg.getSystem_Architectural().getName()
				+ S + dpkg.getArchitectural_EcuList().getName() + S + "EE" + S
				+ dpkg.getEcu_CpuList().getName() + S + "cpu2" + S
				+ dpkg.getCpu_Rtos().getName();

		assertTrue(vt.newTreeInterface().exist(prefix2,
				DataPackage.eINSTANCE.getRtos().getName()));

		IOilWriterBuffer[] buffers = null;
		try {
			buffers = RtosFactory.INSTANCE.write(vt, new String[] { prefix1,
					prefix2 });
		} catch (OilCodeWriterException e) {
			e.printStackTrace();
			assertTrue(false);
		}

		assertNotNull(buffers);
		assertEquals(2, buffers.length );
		System.out.println((buffers[0]).toString());
		System.out.println((buffers[1]).toString());

	}

	final static protected String OIL_TEST_3_NIOS_WITH_GLOBAL_RESOURCES = DEFAULT_EE_IMPLEMENTATION
			+ "CPU EE {\n"
			+ "    OS EE {\n"
			+ "        EE_OPT = \"__ASSERT__\";\n"
			+ "        EE_OPT = \"__OSEKOS_NO_ALARMS__\";\n"
			+ "        EE_OPT = \"DEBUG\";\n"
			
			+ "        NIOS2_SYS_CONFIG = \"DEBUG\";\n"
			+ "        NIOS2_APP_CONFIG = \"DEBUG\";\n"
			+ "        NIOS2_DO_MAKE_OBJDUMP = FALSE;\n"+
			"		   IPIC_GLOBAL_NAME = \"Ipic_subsystem\";\n" +
			"		NIOS2_PTF_FILE = \"C:/altera/81/nios2eds/examples/verilog/niosII_stratixII_2s60_RoHS/frsh_small/NiosII_stratixII_2s60_RoHS_small_sopc.ptf\";\n" +
			
			"		MASTER_CPU = \"cpu2\";\n" +


			"		CPU_DATA = NIOSII {\n" +
			"			ID = \"cpu1\";\n" +
			"			MULTI_STACK = TRUE {\n" +
			"				IRQ_STACK = FALSE;\n" +
			"				DUMMY_STACK = SHARED;\n" +
			"			};\n" +
			"			\n" +
			"			APP_SRC = \"code_1.c\";\n" +
			"	\n" 
			+ "        STACK_TOP = 0x20004000;\n"
			//+ "        STACK_BOTTOM = 0x20001800;\n"
			+ "        SYS_SIZE = 0x1000;\n"
			+ "        SYSTEM_LIBRARY_NAME = \"library_name\";\n"
			+ "        SYSTEM_LIBRARY_PATH = \"path/library_name\";\n"+
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
			+ "        STACK_TOP = 0x20008000;\n"
			//+ "        STACK_BOTTOM = 0x20004000;\n"
			+ "        SYS_SIZE = 0x1000;\n"
			+ "        SYSTEM_LIBRARY_NAME = \"library_name\";\n"
			+ "        SYSTEM_LIBRARY_PATH = \"path/library_name\";\n" +
			"			IPIC_LOCAL_NAME = \"Ipic_subsystem_1\";\n" +
			"	\n" +
			"		};\n"+ 

			"		CPU_DATA = NIOSII {\n" +
			"			ID = \"cpu3\";\n" +
			"			MULTI_STACK = TRUE {\n" +
			"				IRQ_STACK = FALSE;\n" +
			"				DUMMY_STACK = SHARED;\n" +
			"			};\n" +
			"			\n" +
			"			APP_SRC = \"code_3.c\";\n" +
			"	\n" 
			+ "        STACK_TOP = \"alt_data_end\";\n"
//			//+ "        STACK_BOTTOM = 0x20004000;\n"
			+ "        SYS_SIZE = 0x1000;\n"
			+ "        SYSTEM_LIBRARY_NAME = \"library_name\";\n"
			+ "        SYSTEM_LIBRARY_PATH = \"path/library_name\";\n"+
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
			+ "    };\n"
			+ "    TASK Task_A_1 {\n"
			+ "        CPU_ID = \"cpu1\";"
			+ "        PRIORITY = 0x01;\n"
			+ "        ACTIVATION = 4;\n"
			+ "        STACK = PRIVATE {\n"
			+ "            SYS_SIZE = 0x100;\n"
			+ "        };\n"
			+ "        EVENT = evento1;\n"
			+ "        RESOURCE = resB_2_3;\n"
			+ "    };\n"
			+ "    TASK Task_A_2 {\n"
			+ "        CPU_ID = \"cpu1\";"
			+ "        PRIORITY = 0x02;\n"
			+ "        ACTIVATION = 1;\n"
			+ "        RESOURCE = resC_1_2;\n"
			+ "        STACK = SHARED;\n"
			+ "    };\n"
			+ "    TASK Task_B_1 {\n"
			+ "        CPU_ID = \"cpu2\";"
			+ "        PRIORITY = 0x04;\n"
			+ "        ACTIVATION = 1;\n"
			+ "        STACK = SHARED;\n"
			+ "        RESOURCE = resA_2;\n"
			+ "        RESOURCE = resC_1_2;\n"
			+ "    };\n"
			+ "    TASK Task_B_2 {\n"
			+ "        CPU_ID = \"cpu2\";"
			+ "        PRIORITY = 0x02;\n"
			+ "        ACTIVATION = 1;\n"
			+ "        STACK = SHARED;\n"
			+ "        RESOURCE = resD_2_3;\n"
			+ "    };\n"
			+ "    TASK Task_C_1 {\n"
			+ "        CPU_ID = \"cpu3\";"
			+ "        PRIORITY = 0x04;\n"
			+ "        RESOURCE = resB_2_3;\n"
			+ "        RESOURCE = resE_3;\n"
			+ "        STACK = SHARED;\n"
			+ "        ACTIVATION = 1;\n"
			+ "    };\n"
			+ "    TASK Task_C_2 {\n"
			+ "        CPU_ID = \"cpu3\";"
			+ "        PRIORITY = 0x01;\n"
			+ "        RESOURCE = resD_2_3;\n"
			+ "        STACK = SHARED;\n"
			+ "        ACTIVATION = 1;\n"
			+ "    };\n"
			+ "	   EVENT evento1 {};\n"
			+ "    RESOURCE resA_2 {"
			+ "        RESOURCEPROPERTY = STANDARD;\n"
			+ "    };\n"
			+ "    RESOURCE resB_2_3 {"
			+ "        RESOURCEPROPERTY = STANDARD;\n"
			+ "    };\n"
			+ "    RESOURCE resC_1_2 {"
			+ "        RESOURCEPROPERTY = STANDARD;\n"
			+ "    };\n"
			+ "    RESOURCE resD_2_3 {"
			+ "        RESOURCEPROPERTY = STANDARD;\n"
			+ "    };\n"
			+ "    RESOURCE resE_3 {"
			+ "        RESOURCEPROPERTY = STANDARD;\n"
			+ "    };\n"
			+ "    RESOURCE resF_unused {"
			+ "        RESOURCEPROPERTY = STANDARD;\n"
			+ "    };\n"
			+ "};\n";

	@Test
	public void test3cpuGlobalResources() {
		IVarTree vt = VarTreeUtil.newVarTree();
		(new OilReader()).load(new ByteArrayInputStream(
				OIL_TEST_3_NIOS_WITH_GLOBAL_RESOURCES.getBytes()), vt);

		System.out.println(Vt2StringUtilities.varTreeToString(vt));
		
		DataPackage dpkg = DataPackage.eINSTANCE;
		String prefix1 = "EE" + S + dpkg.getSystem_Architectural().getName()
				+ S + dpkg.getArchitectural_EcuList().getName() + S + "EE" + S
				+ dpkg.getEcu_CpuList().getName() + S + "cpu1" + S
				+ dpkg.getCpu_Rtos().getName();

		assertTrue(vt.newTreeInterface().exist(prefix1,
				DataPackage.eINSTANCE.getRtos().getName()));

		String prefix2 = "EE" + S + dpkg.getSystem_Architectural().getName()
				+ S + dpkg.getArchitectural_EcuList().getName() + S + "EE" + S
				+ dpkg.getEcu_CpuList().getName() + S + "cpu2" + S
				+ dpkg.getCpu_Rtos().getName();

		assertTrue(vt.newTreeInterface().exist(prefix2,
				DataPackage.eINSTANCE.getRtos().getName()));

		String prefix3 = "EE" + S + dpkg.getSystem_Architectural().getName()
				+ S + dpkg.getArchitectural_EcuList().getName() + S + "EE" + S
				+ dpkg.getEcu_CpuList().getName() + S + "cpu3" + S
				+ dpkg.getCpu_Rtos().getName();

		assertTrue(vt.newTreeInterface().exist(prefix2,
				DataPackage.eINSTANCE.getRtos().getName()));

		IOilWriterBuffer[] buffers = null;
		try {
			buffers = RtosFactory.INSTANCE.write(vt, new String[] { prefix1,
					prefix2, prefix3 });
		} catch (OilCodeWriterException e) {
			e.printStackTrace();
			assertTrue(false);
		}

		System.out.println((buffers[0]).toString());
		System.out.println((buffers[1]).toString());
		System.out.println((buffers[2]).toString());

	}


	final static protected String OIL_TEST_2_NIOS_FP = DEFAULT_EE_IMPLEMENTATION
			+ "CPU EE {\n"
			+ "    OS EE {\n"
			+ "        EE_OPT = \"__ASSERT__\";\n"
			+ "        EE_OPT = \"__OSEKOS_NO_ALARMS__\";\n"
			+ "        EE_OPT = \"DEBUG\";\n"

			+ "        NIOS2_SYS_CONFIG = \"DEBUG\";\n"
			+ "        NIOS2_APP_CONFIG = \"DEBUG\";\n"
			+ "        NIOS2_DO_MAKE_OBJDUMP = FALSE;\n"+
			"		   IPIC_GLOBAL_NAME = \"Ipic_subsystem\";\n" +
			"		MASTER_CPU = \"cpu1\";\n" +
			"		NIOS2_PTF_FILE = \"C:/altera/81/nios2eds/examples/verilog/niosII_stratixII_2s60_RoHS/frsh_small/NiosII_stratixII_2s60_RoHS_small_sopc.ptf\";\n" +


			"		CPU_DATA = NIOSII {\n" +
			"			ID = \"cpu1\";\n" +
			"			MULTI_STACK = TRUE {\n" +
			"				IRQ_STACK = FALSE;\n" +
			"				DUMMY_STACK = SHARED;\n" +
			"			};\n" +
			"			\n" +
			"			APP_SRC = \"code_1.c\";\n" +
			"	\n" 
			+ "        STACK_TOP = 0x20004000;\n"
			//+ "        STACK_BOTTOM = 0x20001800;\n"
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
			+ "        STACK_TOP = 0x20008000;\n"
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
			+ "        KERNEL_TYPE = FP {NESTED_IRQ = TRUE;};\n"
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
			+ "        RESOURCE = res1;\n"
			+ "        RESOURCE = res2;\n"
			+ "    };\n"
			+ "    TASK Task2 {\n"
			+ "        CPU_ID = \"cpu1\";"
			+ "        PRIORITY = 0x02;\n"
			+ "        ACTIVATION = 1;\n"
			+ "        SCHEDULE = FULL;\n"
			+ "        AUTOSTART = TRUE;\n"
			+ "        STACK = SHARED;\n"
			+ "        RESOURCE = res1;\n"
			+ "    };\n"
			+ "    TASK Task3 {\n"
			+ "        CPU_ID = \"cpu2\";"
			+ "        PRIORITY = 0x04;\n"
			+ "        ACTIVATION = 1;\n"
			+ "        SCHEDULE = FULL;\n"
			+ "        AUTOSTART = TRUE;\n"
			+ "        STACK = SHARED;\n"
			+ "        RESOURCE = res1;\n"
			+ "        RESOURCE = res3;\n"
			+ "    };\n"
			+ "	   EVENT evento1 {};\n"
			+ "    RESOURCE res1 {"
			+ "        RESOURCEPROPERTY = STANDARD;\n"
			+ "    };\n"
			+ "    RESOURCE res2 {"
			+ "        RESOURCEPROPERTY = STANDARD;\n"
			+ "    };\n"
			+ "    RESOURCE res3 {"
			+ "        RESOURCEPROPERTY = STANDARD;\n"
			+ "    };\n"
			+ "};\n";

	@Test
	public void testFP() {
		IVarTree vt = VarTreeUtil.newVarTree();
		(new OilReader()).load(new ByteArrayInputStream(OIL_TEST_2_NIOS_FP
				.getBytes()), vt);

		DataPackage dpkg = DataPackage.eINSTANCE;
		String prefix1 = "EE" + S + dpkg.getSystem_Architectural().getName()
				+ S + dpkg.getArchitectural_EcuList().getName() + S + "EE" + S
				+ dpkg.getEcu_CpuList().getName() + S + "cpu1" + S
				+ dpkg.getCpu_Rtos().getName();

		assertTrue(vt.newTreeInterface().exist(prefix1,
				DataPackage.eINSTANCE.getRtos().getName()));

		String prefix2 = "EE" + S + dpkg.getSystem_Architectural().getName()
				+ S + dpkg.getArchitectural_EcuList().getName() + S + "EE" + S
				+ dpkg.getEcu_CpuList().getName() + S + "cpu2" + S
				+ dpkg.getCpu_Rtos().getName();

		assertTrue(vt.newTreeInterface().exist(prefix2,
				DataPackage.eINSTANCE.getRtos().getName()));

		IOilWriterBuffer[] buffers = null;
		try {
			buffers = RtosFactory.INSTANCE.write(vt, new String[] { prefix1,
					prefix2 });
		} catch (OilCodeWriterException e) {
			e.printStackTrace();
			assertTrue(false);
		}

		assertNotNull(buffers);
		assertEquals(2, buffers.length );
		System.out.println((buffers[0]).toString());
		System.out.println((buffers[1]).toString());

	}

	protected final static String ALTERA_EXAMPLE = DEFAULT_EE_IMPLEMENTATION +
		"CPU test_application {\n" +
		"\n" +
		"    OS EE {\n"
		
		+ "        NIOS2_SYS_CONFIG = \"DEBUG\";\n"
		+ "        NIOS2_APP_CONFIG = \"DEBUG\";\n"
		+ "        NIOS2_DO_MAKE_OBJDUMP = TRUE;\n"+
		"		   IPIC_GLOBAL_NAME = \"Ipic_subsystem\";\n" +
		"		MASTER_CPU = \"cpu1\";\n" +
		"		NIOS2_PTF_FILE = \"C:/altera/81/nios2eds/examples/verilog/niosII_stratixII_2s60_RoHS/frsh_small/NiosII_stratixII_2s60_RoHS_small_sopc.ptf\";\n" +


		"    	CPU_DATA = NIOSII {\n" +
		"			ID = \"cpu0\";\n" +
		"			MULTI_STACK = FALSE;\n" +
		"			 \n" +
		"			APP_SRC = \"cpu0_startup.c\";\n" +
		"	 \n" +
		"	        STACK_TOP = 0x20004000;\n" +
		//"	        STACK_BOTTOM = 0x20001800;\n" +
		"	        SYS_SIZE = 0x1000; \n" +
		"	        SYSTEM_LIBRARY_NAME = \"standard_2cpu_cpu0\";\n" +
		"	        SYSTEM_LIBRARY_PATH = \"C:/altera/kits/nios2/examples/verilog/niosII_stratix_1s40/standard_2cpu/software/standard_2cpu_cpu0\";\n" +
		"			IPIC_LOCAL_NAME = \"Ipic_subsystem_0\";\n" +
		"		};\n" +
		"\n" +
		"		CPU_DATA = NIOSII {\n" +
		"			ID = \"cpu1\";\n" +
		"			MULTI_STACK = FALSE;\n" +
		"\n" +
		"			APP_SRC = \"cpu1_startup.c\";\n" +
		"		 \n" +
		"	        STACK_TOP = 0x20008000;\n" +
		//"	        STACK_BOTTOM = 0x20004000;\n" +
		"	        SYS_SIZE = 0x1000;\n" +
		"	        SYSTEM_LIBRARY_NAME = \"standard_2cpu_cpu1\";\n" +
		"	        SYSTEM_LIBRARY_PATH = \"C:/altera/kits/nios2/examples/verilog/niosII_stratix_1s40/standard_2cpu/software/standard_2cpu_cpu1\";\n" +
		"			IPIC_LOCAL_NAME = \"Ipic_subsystem_1\";\n" +
		"		};\n" +
		"    \n" +
		"    \n" +
		"    \n" +
		"		STATUS = STANDARD;\n" +
		"	\n" +
		"		STARTUPHOOK = FALSE;\n" +
		"		ERRORHOOK = FALSE;\n" +
		"		SHUTDOWNHOOK = FALSE;\n" +
		"		PRETASKHOOK = FALSE;\n" +
		"		POSTTASKHOOK = FALSE;\n" +
		"		USEGETSERVICEID = FALSE;\n" +
		"		USEPARAMETERACCESS = FALSE;\n" +
		"		USERESSCHEDULER = FALSE;\n" +
		"\n" +
		"       KERNEL_TYPE = BCC1;\n" +
		
//		"		MUTEX_DEVICE_NAME = \"/dev/mutex\";\n" +
		"    };\n" +
		"\n" +
		"    TASK thread0 {\n" +
		"       CPU_ID = \"cpu0\";\n" +
		"		APP_SRC = \"thread0.c\";\n" +
		"		APP_SRC = \"threadbody.h\";\n" +
		"		PRIORITY = 1;\n" +
		"		ACTIVATION = 1;\n" +
		"		SCHEDULE = FULL;\n" +
		"		AUTOSTART = FALSE;\n" +
		"		STACK = SHARED;\n" +
        "		RESOURCE = mymutex;\n" +
		"    };\n" +
		"\n" +
		"    TASK thread1 {\n" +
		"       CPU_ID = \"cpu0\";\n" +
		"		APP_SRC = \"thread1.c\";\n" +
		"		APP_SRC = \"threadbody.h\";\n" +
		"		PRIORITY = 2;\n" +
		"		ACTIVATION = 1;\n" +
		"		SCHEDULE = FULL;\n" +
		"		AUTOSTART = FALSE;\n" +
		"		STACK = SHARED;\n" +
        "		RESOURCE = mymutex;\n" +
		"    };\n" +
		"\n" +
		"    TASK thread2 {\n" +
		"       CPU_ID = \"cpu0\";\n" +
		"		APP_SRC = \"thread2.c\";\n" +
		"		APP_SRC = \"threadbody.h\";\n" +
		"		PRIORITY = 3;\n" +
		"		ACTIVATION = 1;\n" +
		"		SCHEDULE = FULL;\n" +
		"		AUTOSTART = FALSE;\n" +
		"		STACK = SHARED;\n" +
		"    };\n" +
		"\n" +
		"    TASK thread3 {\n" +
		"       CPU_ID = \"cpu0\";\n" +
		"		APP_SRC = \"thread3.c\";\n" +
		"		APP_SRC = \"threadbody.h\";\n" +
		"		PRIORITY = 4;\n" +
		"		ACTIVATION = 1;\n" +
		"		SCHEDULE = FULL;\n" +
		"		AUTOSTART = FALSE;\n" +
		"		STACK = SHARED;\n" +
		"    };\n" +
		"    \n" +
		"    COUNTER Counter_cpu0 {\n" +
		"       MINCYCLE = 2;\n" +
		"       MAXALLOWEDVALUE = 16 ;\n" +
		"       TICKSPERBASE = 1;\n" +
		"       CPU_ID = \"cpu0\";\n" +
		"    };\n" +
		"\n" +
		"    ALARM alarm_thread0 {\n" +
		"		COUNTER = \"Counter_cpu0\";\n" +
		"		ACTION = ACTIVATETASK { TASK = \"thread0\"; };\n" +
		"		AUTOSTART = FALSE;\n" +
		"    };\n" +
		"\n" +
		"    ALARM alarm_thread1 {\n" +
		"		COUNTER = \"Counter_cpu0\";\n" +
		"		ACTION = ACTIVATETASK { TASK = \"thread1\"; };\n" +
		"		AUTOSTART = FALSE;\n" +
		"    };\n" +
		"\n" +
		"    ALARM alarm_thread2 {\n" +
		"		COUNTER = \"Counter_cpu0\";\n" +
		"		ACTION = ACTIVATETASK { TASK = \"thread2\"; };\n" +
		"		AUTOSTART = FALSE;\n" +
		"    };\n" +
		"\n" +
		"    ALARM alarm_thread3 {\n" +
		"		COUNTER = \"Counter_cpu0\";\n" +
		"		ACTION = ACTIVATETASK { TASK = \"thread3\"; };\n" +
		"		AUTOSTART = FALSE;\n" +
		"    };\n" +
	    "	RESOURCE mymutex {\n" +
	    "	    RESOURCEPROPERTY = STANDARD;\n" +
	    "	};\n" +
		"};\n";
	@Test
	public void test4Task2Cpu() {
		IVarTree vt = VarTreeUtil.newVarTree();
		(new OilReader()).load(new ByteArrayInputStream(ALTERA_EXAMPLE
				.getBytes()), vt);

		DataPackage dpkg = DataPackage.eINSTANCE;
		String prefix1 = "test_application" + S + dpkg.getSystem_Architectural().getName()
				+ S + dpkg.getArchitectural_EcuList().getName() + S + "test_application" + S
				+ dpkg.getEcu_CpuList().getName() + S + "cpu0" + S
				+ dpkg.getCpu_Rtos().getName();

		assertTrue(vt.newTreeInterface().exist(prefix1,
				DataPackage.eINSTANCE.getRtos().getName()));

		String prefix2 = "test_application" + S + dpkg.getSystem_Architectural().getName()
				+ S + dpkg.getArchitectural_EcuList().getName() + S + "test_application" + S
				+ dpkg.getEcu_CpuList().getName() + S + "cpu1" + S
				+ dpkg.getCpu_Rtos().getName();

		assertTrue(vt.newTreeInterface().exist(prefix2,
				DataPackage.eINSTANCE.getRtos().getName()));

		IOilWriterBuffer[] buffers = null;
		try {
			buffers = RtosFactory.INSTANCE.write(vt, new String[] { prefix1,
					prefix2 });
		} catch (OilCodeWriterException e) {
			e.printStackTrace();
			assertTrue(false);
		}

		assertNotNull(buffers);
		assertEquals(2, buffers.length );
		System.out.println((buffers[0]).toString());
		System.out.println((buffers[1]).toString());

	}
	
	protected final static String ALTERA_EXAMPLE_always_rn = DEFAULT_EE_IMPLEMENTATION +
		"CPU test_application {\n" +
		"\n" +
		"    OS EE {\n"
		
		+ "        NIOS2_SYS_CONFIG = \"DEBUG\";\n"
		+ "        NIOS2_APP_CONFIG = \"DEBUG\";\n"
		+ "        NIOS2_DO_MAKE_OBJDUMP = TRUE;\n"+
		"		   IPIC_GLOBAL_NAME = \"Ipic_subsystem\";\n" +
		"		MASTER_CPU = \"cpu1\";\n" +
		"		NIOS2_PTF_FILE = \"C:/altera/81/nios2eds/examples/verilog/niosII_stratixII_2s60_RoHS/frsh_small/NiosII_stratixII_2s60_RoHS_small_sopc.ptf\";\n" +


		"    	CPU_DATA = NIOSII {\n" +
		"			ID = \"cpu0\";\n" +
		"			MULTI_STACK = FALSE;\n" +
		"			 \n" +
		"			APP_SRC = \"cpu0_startup.c\";\n" +
		"	 \n" +
		"	        STACK_TOP = 0x20004000;\n" +
		//"	        STACK_BOTTOM = 0x20001800;\n" +
		"	        SYS_SIZE = 0x1000; \n" +
		"	        SYSTEM_LIBRARY_NAME = \"standard_2cpu_cpu0\";\n" +
		"	        SYSTEM_LIBRARY_PATH = \"C:/altera/kits/nios2/examples/verilog/niosII_stratix_1s40/standard_2cpu/software/standard_2cpu_cpu0\";\n" +
		"			IPIC_LOCAL_NAME = \"Ipic_subsystem_0\";\n" +
		"		};\n" +
		"\n" +
		"		CPU_DATA = NIOSII {\n" +
		"			ID = \"cpu1\";\n" +
		"			MULTI_STACK = FALSE;\n" +
		"\n" +
		"			APP_SRC = \"cpu1_startup.c\";\n" +
		"		 \n" +
		"	        STACK_TOP = 0x20008000;\n" +
		//"	        STACK_BOTTOM = 0x20004000;\n" +
		"	        SYS_SIZE = 0x1000;\n" +
		"	        SYSTEM_LIBRARY_NAME = \"standard_2cpu_cpu1\";\n" +
		"	        SYSTEM_LIBRARY_PATH = \"C:/altera/kits/nios2/examples/verilog/niosII_stratix_1s40/standard_2cpu/software/standard_2cpu_cpu1\";\n" +
		"			IPIC_LOCAL_NAME = \"Ipic_subsystem_1\";\n" +
		"		};\n" +
		"    \n" +
		"    \n" +
		"    \n" +
		"		STATUS = STANDARD;\n" +
		"	\n" +
		"		STARTUPHOOK = FALSE;\n" +
		"		ERRORHOOK = FALSE;\n" +
		"		SHUTDOWNHOOK = FALSE;\n" +
		"		PRETASKHOOK = FALSE;\n" +
		"		POSTTASKHOOK = FALSE;\n" +
		"		USEGETSERVICEID = FALSE;\n" +
		"		USEPARAMETERACCESS = FALSE;\n" +
		"		USERESSCHEDULER = FALSE;\n" +
		"\n" +
		"       KERNEL_TYPE = BCC1;\n" +
		
		"		USEREMOTETASK = ALWAYS;\n" +
//		"		MUTEX_DEVICE_NAME = \"/dev/mutex\";\n" +
		"    };\n" +
		"\n" +
		"    TASK thread0 {\n" +
		"       CPU_ID = \"cpu0\";\n" +
		"		APP_SRC = \"thread0.c\";\n" +
		"		APP_SRC = \"threadbody.h\";\n" +
		"		PRIORITY = 1;\n" +
		"		ACTIVATION = 1;\n" +
		"		SCHEDULE = FULL;\n" +
		"		AUTOSTART = FALSE;\n" +
		"		STACK = SHARED;\n" +
	    "		RESOURCE = mymutex;\n" +
		"    };\n" +
		"\n" +
		"    TASK thread1 {\n" +
		"       CPU_ID = \"cpu0\";\n" +
		"		APP_SRC = \"thread1.c\";\n" +
		"		APP_SRC = \"threadbody.h\";\n" +
		"		PRIORITY = 2;\n" +
		"		ACTIVATION = 1;\n" +
		"		SCHEDULE = FULL;\n" +
		"		AUTOSTART = FALSE;\n" +
		"		STACK = SHARED;\n" +
	    "		RESOURCE = mymutex;\n" +
		"    };\n" +
		"\n" +
		"    TASK thread2 {\n" +
		"       CPU_ID = \"cpu0\";\n" +
		"		APP_SRC = \"thread2.c\";\n" +
		"		APP_SRC = \"threadbody.h\";\n" +
		"		PRIORITY = 3;\n" +
		"		ACTIVATION = 1;\n" +
		"		SCHEDULE = FULL;\n" +
		"		AUTOSTART = FALSE;\n" +
		"		STACK = SHARED;\n" +
		"    };\n" +
		"\n" +
		"    TASK thread3 {\n" +
		"       CPU_ID = \"cpu0\";\n" +
		"		APP_SRC = \"thread3.c\";\n" +
		"		APP_SRC = \"threadbody.h\";\n" +
		"		PRIORITY = 4;\n" +
		"		ACTIVATION = 1;\n" +
		"		SCHEDULE = FULL;\n" +
		"		AUTOSTART = FALSE;\n" +
		"		STACK = SHARED;\n" +
		"    };\n" +
		"    \n" +
		"    COUNTER Counter_cpu0 {\n" +
		"       MINCYCLE = 2;\n" +
		"       MAXALLOWEDVALUE = 16 ;\n" +
		"       TICKSPERBASE = 1;\n" +
		"       CPU_ID = \"cpu0\";\n" +
		"    };\n" +
		"\n" +
		"    ALARM alarm_thread0 {\n" +
		"		COUNTER = \"Counter_cpu0\";\n" +
		"		ACTION = ACTIVATETASK { TASK = \"thread0\"; };\n" +
		"		AUTOSTART = FALSE;\n" +
		"    };\n" +
		"\n" +
		"    ALARM alarm_thread1 {\n" +
		"		COUNTER = \"Counter_cpu0\";\n" +
		"		ACTION = ACTIVATETASK { TASK = \"thread1\"; };\n" +
		"		AUTOSTART = FALSE;\n" +
		"    };\n" +
		"\n" +
		"    ALARM alarm_thread2 {\n" +
		"		COUNTER = \"Counter_cpu0\";\n" +
		"		ACTION = ACTIVATETASK { TASK = \"thread2\"; };\n" +
		"		AUTOSTART = FALSE;\n" +
		"    };\n" +
		"\n" +
		"    ALARM alarm_thread3 {\n" +
		"		COUNTER = \"Counter_cpu0\";\n" +
		"		ACTION = ACTIVATETASK { TASK = \"thread3\"; };\n" +
		"		AUTOSTART = FALSE;\n" +
		"    };\n" +
	    "	RESOURCE mymutex {\n" +
	    "	    RESOURCEPROPERTY = STANDARD;\n" +
	    "	};\n" +
		"};\n";
	@Test
	public void test4Task2CpuAlwaysRN() {
		IVarTree vt = VarTreeUtil.newVarTree();
		(new OilReader()).load(new ByteArrayInputStream(ALTERA_EXAMPLE_always_rn
				.getBytes()), vt);
	
		DataPackage dpkg = DataPackage.eINSTANCE;
		String prefix1 = "test_application" + S + dpkg.getSystem_Architectural().getName()
				+ S + dpkg.getArchitectural_EcuList().getName() + S + "test_application" + S
				+ dpkg.getEcu_CpuList().getName() + S + "cpu0" + S
				+ dpkg.getCpu_Rtos().getName();
	
		assertTrue(vt.newTreeInterface().exist(prefix1,
				DataPackage.eINSTANCE.getRtos().getName()));
	
		String prefix2 = "test_application" + S + dpkg.getSystem_Architectural().getName()
				+ S + dpkg.getArchitectural_EcuList().getName() + S + "test_application" + S
				+ dpkg.getEcu_CpuList().getName() + S + "cpu1" + S
				+ dpkg.getCpu_Rtos().getName();
	
		assertTrue(vt.newTreeInterface().exist(prefix2,
				DataPackage.eINSTANCE.getRtos().getName()));
	
		IOilWriterBuffer[] buffers = null;
		try {
			buffers = RtosFactory.INSTANCE.write(vt, new String[] { prefix1,
					prefix2 });
		} catch (OilCodeWriterException e) {
			e.printStackTrace();
			assertTrue(false);
		}
	
		assertNotNull(buffers);
		assertEquals(2, buffers.length );
		System.out.println((buffers[0]).toString());
		System.out.println((buffers[1]).toString());
	
	}
	
	protected final static String ALTERA_EXAMPLE_split_tasks = DEFAULT_EE_IMPLEMENTATION +
		"CPU test_application {\n" +
		"\n" +
		"    OS EE {\n"
		+ "        NIOS2_SYS_CONFIG = \"DEBUG\";\n"
		+ "        NIOS2_APP_CONFIG = \"DEBUG\";\n"
		+ "        NIOS2_DO_MAKE_OBJDUMP = TRUE;\n"+
		"		   IPIC_GLOBAL_NAME = \"Ipic_subsystem\";\n" +
		"		MASTER_CPU = \"cpu1\";\n" +
		"		NIOS2_PTF_FILE = \"C:/altera/81/nios2eds/examples/verilog/niosII_stratixII_2s60_RoHS/frsh_small/NiosII_stratixII_2s60_RoHS_small_sopc.ptf\";\n" +


		"    	CPU_DATA = NIOSII {\n" +
		"			ID = \"cpu0\";\n" +
		"			MULTI_STACK = FALSE;\n" +
		"			 \n" +
		"			APP_SRC = \"cpu0_startup.c\";\n" +
		"	 \n" +
		"	        STACK_TOP = 0x20004000;\n" +
		//"	        STACK_BOTTOM = 0x20001800;\n" +
		"	        SYS_SIZE = 0x1000; \n" +
		"	        SYSTEM_LIBRARY_NAME = \"standard_2cpu_cpu0\";\n" +
		"	        SYSTEM_LIBRARY_PATH = \"C:/altera/kits/nios2/examples/verilog/niosII_stratix_1s40/standard_2cpu/software/standard_2cpu_cpu0\";\n" +
		"			IPIC_LOCAL_NAME = \"Ipic_subsystem_0\";\n" +
		"		};\n" +
		"\n" +
		"		CPU_DATA = NIOSII {\n" +
		"			ID = \"cpu1\";\n" +
		"			MULTI_STACK = FALSE;\n" +
		"\n" +
		"			APP_SRC = \"cpu1_startup.c\";\n" +
		"		 \n" +
		"	        STACK_TOP = 0x20008000;\n" +
		//"	        STACK_BOTTOM = 0x20004000;\n" +
		"	        SYS_SIZE = 0x1000;\n" +
		"	        SYSTEM_LIBRARY_NAME = \"standard_2cpu_cpu1\";\n" +
		"	        SYSTEM_LIBRARY_PATH = \"C:/altera/kits/nios2/examples/verilog/niosII_stratix_1s40/standard_2cpu/software/standard_2cpu_cpu1\";\n" +
		"			IPIC_LOCAL_NAME = \"Ipic_subsystem_1\";\n" +
		"		};\n" +
		"    \n" +
		"    \n" +
		"    \n" +
		"		STATUS = STANDARD;\n" +
		"	\n" +
		"		STARTUPSYNC = TRUE;\n" +
		"		STARTUPHOOK = FALSE;\n" +
		"		ERRORHOOK = FALSE;\n" +
		"		SHUTDOWNHOOK = FALSE;\n" +
		"		PRETASKHOOK = FALSE;\n" +
		"		POSTTASKHOOK = FALSE;\n" +
		"		USEGETSERVICEID = FALSE;\n" +
		"		USEPARAMETERACCESS = FALSE;\n" +
		"		USERESSCHEDULER = FALSE;\n" +
		"\n" +
		"       KERNEL_TYPE = BCC1;\n" +
		
		"		USEREMOTETASK = ALWAYS;\n" +
//		"		MUTEX_DEVICE_NAME = \"/dev/mutex\";\n" +
		"    };\n" +
		"\n" +
		"    TASK thread0 {\n" +
		"       CPU_ID = \"cpu0\";\n" +
		"		APP_SRC = \"thread0.c\";\n" +
		"		APP_SRC = \"threadbody.h\";\n" +
		"		PRIORITY = 1;\n" +
		"		ACTIVATION = 1;\n" +
		"		SCHEDULE = FULL;\n" +
		"		AUTOSTART = FALSE;\n" +
		"		STACK = SHARED;\n" +
	    "		RESOURCE = mymutex;\n" +
		"    };\n" +
		"\n" +
		"    TASK thread1 {\n" +
		"       CPU_ID = \"cpu1\";\n" +
		"		APP_SRC = \"thread1.c\";\n" +
		"		APP_SRC = \"threadbody.h\";\n" +
		"		PRIORITY = 2;\n" +
		"		ACTIVATION = 1;\n" +
		"		SCHEDULE = FULL;\n" +
		"		AUTOSTART = FALSE;\n" +
		"		STACK = SHARED;\n" +
	    "		RESOURCE = mymutex;\n" +
		"    };\n" +
		"\n" +
		"    TASK thread2 {\n" +
		"       CPU_ID = \"cpu0\";\n" +
		"		APP_SRC = \"thread2.c\";\n" +
		"		APP_SRC = \"threadbody.h\";\n" +
		"		PRIORITY = 3;\n" +
		"		ACTIVATION = 1;\n" +
		"		SCHEDULE = FULL;\n" +
		"		AUTOSTART = FALSE;\n" +
		"		STACK = SHARED;\n" +
		"    };\n" +
		"\n" +
		"    TASK thread3 {\n" +
		"       CPU_ID = \"cpu0\";\n" +
		"		APP_SRC = \"thread3.c\";\n" +
		"		APP_SRC = \"threadbody.h\";\n" +
		"		PRIORITY = 4;\n" +
		"		ACTIVATION = 1;\n" +
		"		SCHEDULE = FULL;\n" +
		"		AUTOSTART = FALSE;\n" +
		"		STACK = SHARED;\n" +
		"    };\n" +
		"    \n" +
		"    COUNTER Counter_cpu0 {\n" +
		"       MINCYCLE = 2;\n" +
		"       MAXALLOWEDVALUE = 16 ;\n" +
		"       TICKSPERBASE = 1;\n" +
		"       CPU_ID = \"cpu0\";\n" +
		"    };\n" +
		"\n" +
		"    ALARM alarm_thread0 {\n" +
		"		COUNTER = \"Counter_cpu0\";\n" +
		"		ACTION = ACTIVATETASK { TASK = \"thread0\"; };\n" +
		"		AUTOSTART = FALSE;\n" +
		"    };\n" +
		"\n" +
		"    ALARM alarm_thread1 {\n" +
		"		COUNTER = \"Counter_cpu0\";\n" +
		"		ACTION = ACTIVATETASK { TASK = \"thread1\"; };\n" +
		"		AUTOSTART = FALSE;\n" +
		"    };\n" +
		"\n" +
		"    ALARM alarm_thread2 {\n" +
		"		COUNTER = \"Counter_cpu0\";\n" +
		"		ACTION = ACTIVATETASK { TASK = \"thread2\"; };\n" +
		"		AUTOSTART = FALSE;\n" +
		"    };\n" +
		"\n" +
		"    ALARM alarm_thread3 {\n" +
		"		COUNTER = \"Counter_cpu0\";\n" +
		"		ACTION = ACTIVATETASK { TASK = \"thread3\"; };\n" +
		"		AUTOSTART = FALSE;\n" +
		"    };\n" +
	    "	RESOURCE mymutex {\n" +
	    "	    RESOURCEPROPERTY = STANDARD { APP_SRC = \"res.c\"; };\n" +
	    "	};\n" +
		"};\n";
	@Test
	public void test4Task2CpuSplitted() throws OilCodeWriterException {
		IVarTree vt = VarTreeUtil.newVarTree();
		(new OilReader()).load(new ByteArrayInputStream(ALTERA_EXAMPLE_split_tasks
				.getBytes()), vt);
	
		DataPackage dpkg = DataPackage.eINSTANCE;
		String prefix1 = "test_application" + S + dpkg.getSystem_Architectural().getName()
				+ S + dpkg.getArchitectural_EcuList().getName() + S + "test_application" + S
				+ dpkg.getEcu_CpuList().getName() + S + "cpu0" + S
				+ dpkg.getCpu_Rtos().getName();
	
		assertTrue(vt.newTreeInterface().exist(prefix1,
				DataPackage.eINSTANCE.getRtos().getName()));
	
		String prefix2 = "test_application" + S + dpkg.getSystem_Architectural().getName()
				+ S + dpkg.getArchitectural_EcuList().getName() + S + "test_application" + S
				+ dpkg.getEcu_CpuList().getName() + S + "cpu1" + S
				+ dpkg.getCpu_Rtos().getName();
	
		assertTrue(vt.newTreeInterface().exist(prefix2,
				DataPackage.eINSTANCE.getRtos().getName()));
	
		IOilWriterBuffer[] buffers = null;
		buffers = RtosFactory.INSTANCE.write(vt, new String[] { prefix1,
					prefix2 });
	
		assertNotNull(buffers);
		assertEquals(2, buffers.length );
		System.out.println((buffers[0]).toString());
		System.out.println((buffers[1]).toString());
	
	}

	
	final static protected String OIL_TEST_ORTI_1_NIOS = DEFAULT_EE_IMPLEMENTATION
			+ "CPU EE {\n"
			+ "    OS EE {\n"
			+ "        EE_OPT = \"__ASSERT__\";\n"
			+ "        EE_OPT = \"__OSEKOS_NO_ALARMS__\";\n"
			+ "        EE_OPT = \"DEBUG\";\n"
		
			+ "        CFLAGS = \"-DALT_DEBUG -G0 -O0 -g\";\n"
			+ "        CFLAGS = \"-Wall -Wl,-Map -Wl,project.map\";\n"
			+ "        ASFLAGS = \"-g\";\n"
			+ "        LDDEPS = \"\\\";\n"
			+ "        LIBS = \"-lm\";\n"
			+ "        NIOS2_SYS_CONFIG = \"DEBUG\";\n"
			+ "        NIOS2_APP_CONFIG = \"DEBUG\";\n"
			+ "        NIOS2_DO_MAKE_OBJDUMP = TRUE;\n"
			+ "        NIOS2_JAM_FILE = \"test_file.jam\";\n"+
			"		   IPIC_GLOBAL_NAME = \"Ipic_subsystem\";\n" +
			"		NIOS2_PTF_FILE = \"C:/altera/81/nios2eds/examples/verilog/niosII_stratixII_2s60_RoHS/frsh_small/NiosII_stratixII_2s60_RoHS_small_sopc.ptf\";\n" +
			
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
			+ "        STACK_TOP = 0x20004000;\n"
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
			+ "        STACK_TOP = 0x20008000;\n"
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

	@Test
	public void testOrti1() {
		IVarTree vt = VarTreeUtil.newVarTree();
		(new OilReader()).load(new ByteArrayInputStream(OIL_TEST_ORTI_1_NIOS
				.getBytes()), vt);

		DataPackage dpkg = DataPackage.eINSTANCE;
		String prefix1 = "EE" + S + dpkg.getSystem_Architectural().getName()
				+ S + dpkg.getArchitectural_EcuList().getName() + S + "EE" + S
				+ dpkg.getEcu_CpuList().getName() + S + "cpu1" + S
				+ dpkg.getCpu_Rtos().getName();

		assertTrue(vt.newTreeInterface().exist(prefix1,
				DataPackage.eINSTANCE.getRtos().getName()));

		String prefix2 = "EE" + S + dpkg.getSystem_Architectural().getName()
				+ S + dpkg.getArchitectural_EcuList().getName() + S + "EE" + S
				+ dpkg.getEcu_CpuList().getName() + S + "cpu2" + S
				+ dpkg.getCpu_Rtos().getName();

		assertTrue(vt.newTreeInterface().exist(prefix2,
				DataPackage.eINSTANCE.getRtos().getName()));

		IOilWriterBuffer[] buffers = null;
		try {
			buffers = RtosFactory.INSTANCE.write(vt, new String[] { prefix1,
					prefix2 });
		} catch (OilCodeWriterException e) {
			e.printStackTrace();
			assertTrue(false);
		}

		assertNotNull(buffers);
		assertEquals(2, buffers.length );
		System.out.println((buffers[0]).toString());
		System.out.println((buffers[1]).toString());

	}

	
}

