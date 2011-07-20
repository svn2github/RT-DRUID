package com.eu.evidence.rtdruid.test.modules.oil.codewriter.autosar;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;

import com.eu.evidence.rtdruid.desk.RTDFactory;
import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
import com.eu.evidence.rtdruid.internal.modules.oil.reader.OilReader;
import com.eu.evidence.rtdruid.io.IRTDExporter;
import com.eu.evidence.rtdruid.io.IRTDImporter;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.CommonUtils;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.RtosFactory;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.AbstractCodeWriterTest;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.data.init.IVTResource;
import com.eu.evidence.rtdruid.vartree.data.init.RTD_XMI_Factory;
import com.eu.evidence.rtdruid.vartree.data.init.Vt2StringUtilities;

public class CodeWriterAutosar extends AbstractCodeWriterTest {

	private String VT_PROP_AUTOSAR_FORMAT = "vt_property__autosar_format";
	
	
	public void testAutosar_1() {
	    final String text =
				"CPU mySystem {\n" + 
				"\n" + 
				"	OS myOs {\n" + 
				"	                \n" + 
				"		EE_OPT = \"DEBUG\";\n" + 
				"        STATUS = EXTENDED;\n" + 
				"\n" + 
				"        STARTUPHOOK = TRUE;\n" + 
				"        ERRORHOOK = FALSE;\n" + 
				"        SHUTDOWNHOOK = FALSE;\n" + 
				"    };\n" + 
//				"};\n" + 
//				"CPU mySystem {\n" + 
				"	OS myOs {\n" + 
				"		EE_OPT = \"DEBUG2\";\n" + 
				"        PRETASKHOOK = FALSE;\n" + 
				"        POSTTASKHOOK = FALSE;\n" + 
				"        USEGETSERVICEID = FALSE;\n" + 
				"        USEPARAMETERACCESS = FALSE;\n" + 
				"        USERESSCHEDULER = TRUE;\n" + 
				"        \n" + 
				"        CPU_DATA = PIC30 {\n" + 
				"			APP_SRC = \"code.c\";\n" +
				"        };\n" +
				"    };\n" + 
//				"};\n" + 
//				"CPU mySystem {\n" + 
				"	OS myOs {\n" + 
				"        CPU_DATA = PIC30 {\n" + 
				"			APP_SRC = \"T1.S\";\n" + 
				"			MULTI_STACK = TRUE {\n" + 
				"				IRQ_STACK = TRUE {\n" + 
				"					SYS_SIZE=64;\n" + 
				"				};\n" + 
//				"				DUMMY_STACK = SHARED;\n" + 
				"			};\n" + 
//				"			STACK_BOTTOM = 0xFFFF;\n" + 
//				"			SYS_SIZE = 256;    // available space for all user stacks\n" + 
//				"			SHARED_MIN_SYS_SIZE = 64;    // size of shared stack\n" + 
				"	\n" + 
				"			ICD2 = TRUE;\n" + 
				"				\n" + 
//				"			LINKER_SCRIPT = \"p30f2010.gld\";\n" + 
				"		};\n" + 
				"\n" + 
				"		KERNEL_TYPE = BCC1;\n" + 
				
				"		BOARD_DATA = EE_FLEX {\n" + 
				"			TYPE = STANDARD {" +
				"				OPTIONS = LEDS;\n" + 
				"				OPTIONS = LCD;\n" + 
				"			};\n" + 
				"		};\n" + 
				"	};\n" + 
				"\n" + 
				"    TASK Task0 {\n" + 
				"        PRIORITY = 1;\n" + 
				"        ACTIVATION = 4;\n" + 
				"        STACK = PRIVATE {\n" + 
				"			SYS_SIZE = 64;\n" + 
				"		};\n" + 
				"		SCHEDULE = FULL;\n" + 
				"		RESOURCE = \"MUTEX_sync\";\n" + 
				"	};\n" + 
				"\n" + 
				"    TASK Task1 {\n" + 
				"        PRIORITY = 2;\n" + 
				"        ACTIVATION = 4;\n" + 
				"	};\n" + 
				"\n" + 
				"    TASK Task1 {\n" + 
				"        STACK = SHARED;\n" + 
				"        SCHEDULE = FULL;\n" + 
				"    };\n" + 
				"\n" + 
				"    TASK Task2 {\n" + 
				"        PRIORITY = 3;\n" + 
				"        ACTIVATION = 4;\n" + 
				"		STACK = SHARED;\n" + 
				"        SCHEDULE = FULL;\n" + 
				"        RESOURCE = \"MUTEX_sync\";\n" + 
				"    };\n" + 
				"\n" + 
				"    TASK Task3 {\n" + 
				"        PRIORITY = 4;\n" + 
				"        ACTIVATION = 4;\n" + 
				"		STACK = SHARED;\n" + 
				"        SCHEDULE = FULL;\n" + 
				"    };\n" + 
				"\n" + 
				"    RESOURCE MUTEX_sync { RESOURCEPROPERTY = STANDARD; };\n" + 
				"};\n";
	    
	    
		writerTest(text, 1);
	}
	
	
	
	// ------------------------------

	public DefaultTestResult[] writerTest(String oil_text, int expected_cpu) {
		DefaultTestResult[] answer = new DefaultTestResult[2];
		
		answer[0] = commonWriterTest(oil_text, expected_cpu);
		System.out.println(Vt2StringUtilities.explodeOilVar(Vt2StringUtilities.varTreeToStringErtd(answer[0].vt)));

		answer[1] = commonAutosarWriterTest(oil_text, expected_cpu);
		
		
		

		IOilWriterBuffer[] buffers_0 = answer[0].buffers;
		IOilWriterBuffer[] buffers_1 = answer[1].buffers;
		assertTrue(buffers_0.length == buffers_1.length);
		for (int i=0; i<expected_cpu; i++) {
			assertTrue((buffers_0[i]).toString().equals((buffers_1[i]).toString()));
		}
		
		return answer;
	}

	
	
	
	public DefaultTestResult commonAutosarWriterTest(String oil_text, int expected_cpu) {
		
		
		// convert OIL to AUTOSAR
		String autosarFormat;
		{
			// LOAD AS OIL
			IVarTree oil_vt = (IVarTree) RTDFactory.get(IVarTree.class);
			(new OilReader()).load(new ByteArrayInputStream(oil_text.getBytes()), oil_vt, null, null);

			
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			HashMap<String, String> output_options = new HashMap<String, String>();
			output_options.put(IRTDExporter.OPT_USE_EXPORTER_TYPE, "arxml");
			try {
				oil_vt.getResourceSet().getResources().get(0).save(outputStream, output_options);
			} catch (IOException e) {
				e.printStackTrace();
				fail(e.getMessage());
			}
			autosarFormat = outputStream.toString();
		}

		System.out.println(autosarFormat);

		
		// reload everything from autosar
		IVarTree autosar_vt;
		{
			// LOAD AS OIL
			autosar_vt = (IVarTree) RTDFactory.get(IVarTree.class);

			try {
			    IVTResource res = (IVTResource) new RTD_XMI_Factory().createResource();
			    HashMap<String, String> input_options = new HashMap<String, String>();
			    input_options.put(IRTDImporter.OPT_USE_IMPORTER_TYPE, "arxml");
				res.load(new ByteArrayInputStream(autosarFormat.getBytes()), input_options);
				
				autosar_vt.setRoot(res);
			} catch (IOException e) {
				e.printStackTrace();
				fail(e.getMessage());
			}
			
		}
		
		System.out.println(Vt2StringUtilities.explodeOilVar(Vt2StringUtilities.varTreeToStringErtd(autosar_vt)));

		
		
		// -------------- search rtos ----------------
		ITreeInterface ti = autosar_vt.newTreeInterface();

		String[] prefix = CommonUtils.getAllRtos(ti);
		assertTrue(prefix.length == expected_cpu);

		// --------------- write -----------------

		IOilWriterBuffer[] buffers = null;
		try {
			buffers = RtosFactory.INSTANCE.write(autosar_vt, prefix);
		} catch (OilCodeWriterException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException("Write fail: " + e.getMessage(), e);
		}

		assertTrue(buffers != null);
		assertTrue(buffers.length == expected_cpu);
		for (int i=0; i<expected_cpu; i++)
			System.out.println("buff " + i + ":\n" + (buffers[i]).toString());
		
		
		
		autosar_vt.getProperties().put(VT_PROP_AUTOSAR_FORMAT, autosarFormat);
		

		return new DefaultTestResult(autosar_vt, buffers);
		
	}
}
