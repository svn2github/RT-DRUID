/**
 * 13/mag/2012
 */
package com.eu.evidence.rtdruid.test.modules.oil.codewriter.autosar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;

import org.eclipse.core.runtime.IStatus;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.eu.evidence.rtdruid.internal.modules.oil.reader.OilReader;
import com.eu.evidence.rtdruid.io.IRTDExporter;
import com.eu.evidence.rtdruid.io.IRTDImporter;
import com.eu.evidence.rtdruid.io.IVTResource;
import com.eu.evidence.rtdruid.io.RTD_XMI_Factory;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.CommonUtils;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.RtosFactory;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.AbstractCodeWriterTest;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.CodeWriterArm7Test;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.CodeWriterAvr5Test;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.CodeWriterComTest;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.CodeWriterCortexTest;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.CodeWriterCosmicS12Test;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.CodeWriterDsPicTest;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.CodeWriterMico32Test;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.CodeWriterMisraTest;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.CodeWriterMpc567Test;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.CodeWriterMpc5Test;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.CodeWriterMultiEcuTest;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.CodeWriterMultiPic30Test;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.CodeWriterNiosIITest;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.CodeWriterPic32Test;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.CodeWriterPpcMultiCoreTest;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.CodeWriterResourcesTest;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.CodeWriterRx200Test;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.CodeWriterTricore1Test;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.CodeWritertMPTest;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.CodeWritertTest;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.autosar.AutosarOilWriterTests.AutosarCodeWriterArm7Test;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.autosar.AutosarOilWriterTests.AutosarCodeWriterAvr5Test;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.autosar.AutosarOilWriterTests.AutosarCodeWriterComTest;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.autosar.AutosarOilWriterTests.AutosarCodeWriterCortexTest;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.autosar.AutosarOilWriterTests.AutosarCodeWriterCosmicS12Test;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.autosar.AutosarOilWriterTests.AutosarCodeWriterDsPicTest;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.autosar.AutosarOilWriterTests.AutosarCodeWriterMico32Test;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.autosar.AutosarOilWriterTests.AutosarCodeWriterMisraTest;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.autosar.AutosarOilWriterTests.AutosarCodeWriterMpc567Test;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.autosar.AutosarOilWriterTests.AutosarCodeWriterMpc5Test;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.autosar.AutosarOilWriterTests.AutosarCodeWriterMultiEcuTest;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.autosar.AutosarOilWriterTests.AutosarCodeWriterMultiPic30Test;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.autosar.AutosarOilWriterTests.AutosarCodeWriterNiosIITest;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.autosar.AutosarOilWriterTests.AutosarCodeWriterPic32Test;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.autosar.AutosarOilWriterTests.AutosarCodeWriterPpcMultiCoreTest;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.autosar.AutosarOilWriterTests.AutosarCodeWriterResourcesTest;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.autosar.AutosarOilWriterTests.AutosarCodeWriterRx200Test;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.autosar.AutosarOilWriterTests.AutosarCodeWriterTricore1Test;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.autosar.AutosarOilWriterTests.AutosarCodeWritertMPTest;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.autosar.AutosarOilWriterTests.AutosarCodeWritertTest;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.VarTreeUtil;
import com.eu.evidence.rtdruid.vartree.Vt2StringUtilities;

/**
 * 
 * @author Nicola Serreli
 * @since 2.0
 * 
 */
@RunWith(Suite.class)
@SuiteClasses({ AutosarCodeWriterArm7Test.class, AutosarCodeWriterAvr5Test.class, AutosarCodeWriterComTest.class, 
	AutosarCodeWriterCortexTest.class,
		AutosarCodeWriterCosmicS12Test.class, AutosarCodeWriterDsPicTest.class, AutosarCodeWriterMico32Test.class,
		AutosarCodeWriterMisraTest.class, AutosarCodeWriterMpc567Test.class, AutosarCodeWriterMpc5Test.class,
		AutosarCodeWriterMultiEcuTest.class,
		AutosarCodeWriterMultiPic30Test.class, AutosarCodeWriterNiosIITest.class, AutosarCodeWriterPic32Test.class,
		AutosarCodeWriterPpcMultiCoreTest.class, AutosarCodeWriterResourcesTest.class, 
		AutosarCodeWriterRx200Test.class, AutosarCodeWritertMPTest.class, AutosarCodeWriterTricore1Test.class,
		AutosarCodeWritertTest.class })
public class AutosarOilWriterTests extends AbstractCodeWriterTest {
	
	static String VT_PROP_AUTOSAR_FORMAT = "vt_property__autosar_format";

	public static class AutosarCodeWriterArm7Test extends CodeWriterArm7Test {
		@Override
		public DefaultTestResult commonWriterTest(String oil_text, int expected_cpu) {
			return AutosarOilWriterTests.writerAutosarTest(oil_text, expected_cpu)[0];
		}
	}

	
	public static class AutosarCodeWriterAvr5Test extends CodeWriterAvr5Test {
		@Override
		public DefaultTestResult commonWriterTest(String oil_text, int expected_cpu) {
			return AutosarOilWriterTests.writerAutosarTest(oil_text, expected_cpu)[0];
		}
	}

	public static class AutosarCodeWriterComTest extends CodeWriterComTest {
		@Override
		public DefaultTestResult commonWriterTest(String oil_text, int expected_cpu) {
			return AutosarOilWriterTests.writerAutosarTest(oil_text, expected_cpu)[0];
		}
	}

	public static class AutosarCodeWriterCortexTest extends CodeWriterCortexTest {
		@Override
		public DefaultTestResult commonWriterTest(String oil_text, int expected_cpu) {
			return AutosarOilWriterTests.writerAutosarTest(oil_text, expected_cpu)[0];
		}
	}

	public static class AutosarCodeWriterCosmicS12Test extends CodeWriterCosmicS12Test {
		@Override
		public DefaultTestResult commonWriterTest(String oil_text, int expected_cpu) {
			return AutosarOilWriterTests.writerAutosarTest(oil_text, expected_cpu)[0];
		}
	}

	public static class AutosarCodeWriterDsPicTest extends CodeWriterDsPicTest {
		@Override
		public DefaultTestResult commonWriterTest(String oil_text, int expected_cpu) {
			return AutosarOilWriterTests.writerAutosarTest(oil_text, expected_cpu)[0];
		}
	}

	public static class AutosarCodeWriterMico32Test extends CodeWriterMico32Test {
		@Override
		public DefaultTestResult commonWriterTest(String oil_text, int expected_cpu) {
			return AutosarOilWriterTests.writerAutosarTest(oil_text, expected_cpu)[0];
		}
	}

	public static class AutosarCodeWriterMisraTest extends CodeWriterMisraTest {
		@Override
		public DefaultTestResult commonWriterTest(String oil_text, int expected_cpu) {
			return AutosarOilWriterTests.writerAutosarTest(oil_text, expected_cpu)[0];
		}
	}

	public static class AutosarCodeWriterMpc567Test extends CodeWriterMpc567Test {
		@Override
		public DefaultTestResult commonWriterTest(String oil_text, int expected_cpu) {
			return AutosarOilWriterTests.writerAutosarTest(oil_text, expected_cpu)[0];
		}
	}

	public static class AutosarCodeWriterMpc5Test extends CodeWriterMpc5Test {
		@Override
		public DefaultTestResult commonWriterTest(String oil_text, int expected_cpu) {
			return AutosarOilWriterTests.writerAutosarTest(oil_text, expected_cpu)[0];
		}
	}

	public static class AutosarCodeWriterMultiEcuTest extends CodeWriterMultiEcuTest {
		@Override
		public DefaultTestResult commonWriterTest(String oil_text, int expected_cpu) {
			return AutosarOilWriterTests.writerAutosarTest(oil_text, expected_cpu)[0];
		}
	}

	public static class AutosarCodeWriterMultiPic30Test extends CodeWriterMultiPic30Test {
		@Override
		public DefaultTestResult commonWriterTest(String oil_text, int expected_cpu) {
			return AutosarOilWriterTests.writerAutosarTest(oil_text, expected_cpu)[0];
		}
	}

	public static class AutosarCodeWriterNiosIITest extends CodeWriterNiosIITest {
		@Override
		public DefaultTestResult commonWriterTest(String oil_text, int expected_cpu) {
			return AutosarOilWriterTests.writerAutosarTest(oil_text, expected_cpu)[0];
		}
	}

	public static class AutosarCodeWriterPic32Test extends CodeWriterPic32Test {
		@Override
		public DefaultTestResult commonWriterTest(String oil_text, int expected_cpu) {
			return AutosarOilWriterTests.writerAutosarTest(oil_text, expected_cpu)[0];
		}
	}

	public static class AutosarCodeWriterPpcMultiCoreTest extends CodeWriterPpcMultiCoreTest {
		@Override
		public DefaultTestResult commonWriterTest(String oil_text, int expected_cpu) {
			return AutosarOilWriterTests.writerAutosarTest(oil_text, expected_cpu)[0];
		}
	}

	public static class AutosarCodeWriterResourcesTest extends CodeWriterResourcesTest {
		@Override
		public DefaultTestResult commonWriterTest(String oil_text, int expected_cpu) {
			return AutosarOilWriterTests.writerAutosarTest(oil_text, expected_cpu)[0];
		}
	}

	public static class AutosarCodeWriterRx200Test extends CodeWriterRx200Test {
		@Override
		public DefaultTestResult commonWriterTest(String oil_text, int expected_cpu) {
			return AutosarOilWriterTests.writerAutosarTest(oil_text, expected_cpu)[0];
		}
	}

	public static class AutosarCodeWritertMPTest extends CodeWritertMPTest {
		@Override
		public DefaultTestResult commonWriterTest(String oil_text, int expected_cpu) {
			return AutosarOilWriterTests.writerAutosarTest(oil_text, expected_cpu)[0];
		}
	}

	public static class AutosarCodeWriterTricore1Test extends CodeWriterTricore1Test {
		@Override
		public DefaultTestResult commonWriterTest(String oil_text, int expected_cpu) {
			return AutosarOilWriterTests.writerAutosarTest(oil_text, expected_cpu)[0];
		}
	}


	public static class AutosarCodeWritertTest extends CodeWritertTest {
		@Override
		public DefaultTestResult commonWriterTest(String oil_text, int expected_cpu) {
			return AutosarOilWriterTests.writerAutosarTest(oil_text, expected_cpu)[0];
		}
	}


	
	// ----------------------------------------------------------------------
	
	
	public static DefaultTestResult[] writerAutosarTest(String oil_text, int expected_cpu) {
		DefaultTestResult[] answer = new DefaultTestResult[2];
		IVarTree vt1 = loadVt(oil_text);
		answer[0] = (new AutosarOilWriterTests()).commonWriterTest(oil_text, expected_cpu);
		IStatus st = VarTreeUtil.compare(vt1, answer[0].vt); assertTrue(st.getMessage(), st.isOK());
//		System.out.println("<<<--->>>\n\n" + Vt2StringUtilities.explodeOilVar(Vt2StringUtilities.varTreeToStringErtd(vt1)));
//		System.out.println("<<<--->>>\n\n" + Vt2StringUtilities.explodeOilVar(Vt2StringUtilities.varTreeToStringErtd(answer[0].vt)));
		

		try {
			answer[1] = commonAutosarWriterTest(oil_text, expected_cpu);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
		
		
		

		IOilWriterBuffer[] buffers_0 = answer[0].buffers;
		IOilWriterBuffer[] buffers_1 = answer[1].buffers;
		assertEquals(buffers_0.length , buffers_1.length);
		for (int i=0; i<expected_cpu; i++) {
			assertEquals((buffers_0[i]).toString(), (buffers_1[i]).toString());
		}
		
		return answer;
	}

	
	
	
	public static DefaultTestResult commonAutosarWriterTest(String oil_text, int expected_cpu) throws Throwable {
		{
			String[] exp =RTD_XMI_Factory.getAllExportTypes(); 
			assertNotNull(exp);
			boolean ok = false;
			for (String s: exp) {
				if ("arxml".equalsIgnoreCase(s)) {
					ok = true;
				}
			}
			assertTrue("arxml file export is not supported", ok);
		}
		{
			String[] exp =RTD_XMI_Factory.getAllImportTypes(); 
			assertNotNull(exp);
			boolean ok = false;
			for (String s: exp) {
				if ("arxml".equalsIgnoreCase(s)) {
					ok = true;
				}
			}
			assertTrue("arxml file import is not supported", ok);
		}
		
		
		// convert OIL to AUTOSAR
		String autosarFormat;
		{
			// LOAD AS OIL
			IVarTree oil_vt = VarTreeUtil.newVarTree();
			(new OilReader()).load(new ByteArrayInputStream(oil_text.getBytes()), oil_vt, null, null);

//			System.out.println(Vt2StringUtilities.explodeOilVar(Vt2StringUtilities.varTreeToStringErtd(oil_vt)));
			
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			HashMap<String, String> output_options = new HashMap<String, String>();
			output_options.put(IRTDExporter.OPT_USE_EXPORTER_TYPE, "arxml");
			oil_vt.getResourceSet().getResources().get(0).save(outputStream, output_options);
			autosarFormat = outputStream.toString();
		}

		System.out.println(autosarFormat);

		
		// reload everything from autosar
		IVarTree autosar_vt;
		{
			// LOAD AS OIL
			autosar_vt = VarTreeUtil.newVarTree();

		    IVTResource res = (IVTResource) new RTD_XMI_Factory().createResource();
		    HashMap<String, String> input_options = new HashMap<String, String>();
		    input_options.put(IRTDImporter.OPT_USE_IMPORTER_TYPE, "arxml");
			res.load(new ByteArrayInputStream(autosarFormat.getBytes()), input_options);
			
			autosar_vt.setRoot(res);
		}
		
		System.out.println(Vt2StringUtilities.explodeOilVar(Vt2StringUtilities.varTreeToStringErtd(autosar_vt)));

		
		
		// -------------- search rtos ----------------
		ITreeInterface ti = autosar_vt.newTreeInterface();

		String[] prefix = CommonUtils.getAllRtos(ti);
		assertEquals(expected_cpu, prefix.length );

		// --------------- write -----------------

		IOilWriterBuffer[] buffers = RtosFactory.INSTANCE.write(autosar_vt, prefix);

		assertNotNull(buffers);
		assertEquals(expected_cpu, buffers.length );
		for (int i=0; i<expected_cpu; i++)
			System.out.println("buff " + i + ":\n" + (buffers[i]).toString());
		
		autosar_vt.getProperties().put(VT_PROP_AUTOSAR_FORMAT, autosarFormat);
		
		return new DefaultTestResult(autosar_vt, buffers);
		
	}

}
