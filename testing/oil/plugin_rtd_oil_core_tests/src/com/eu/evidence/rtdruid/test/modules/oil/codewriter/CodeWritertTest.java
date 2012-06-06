/*
 * Created on Dec 2, 2004
 *
 * $Id: CodeWritertTest.java,v 1.25 2008/06/09 10:28:53 durin Exp $
 */
package com.eu.evidence.rtdruid.test.modules.oil.codewriter;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.eclipse.core.runtime.Platform;
import org.eclipse.osgi.service.datalocation.Location;
import org.junit.Ignore;
import org.junit.Test;

import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.internal.modules.oil.reader.OilReader;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.AbstractRtosWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.RtosFactory;
import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.VarTreeUtil;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;

/**
 * 
 * @author Nicola Serreli
 */
public class CodeWritertTest extends AbstractCodeWriterTest {

	// UPDRTD SPEZZARE X ARCHITTETURA

	final static protected String S = "" + DataPath.SEPARATOR;
	final static protected String DEFAULT_CPU_NAME = IWritersKeywords.DEFAULT_CPU_NAME;
	
	/** Clear the OilImplFactory and RtosFactory before each test */
//	protected void setUp() throws Exception {
//		//OilImplFactory.INSTANCE.clear();
//		RtosFactory.INSTANCE.init();
//		super.setUp();
//	}

//	/** Clear the OilImplFactory and RtosFactory after each test */
//	protected void tearDown() throws Exception {
//		//OilImplFactory.INSTANCE.clear();
//		RtosFactory.INSTANCE.init();
//		super.tearDown();
//	}
	
	@Test public void testEclipseBasePath() {
		System.err.flush();
		System.out.flush();
		
		Location path = Platform.getInstallLocation();
		URL url = path.getURL();
		System.err.println("URL eclipse = " + url);
		System.err.println(url.getPath());
		//url.getPath().
		System.err.println(url.getFile());
		
		final String eclisePath;
    	if (url != null) {
    		String tmp = url.getFile();
    		tmp = tmp.startsWith("/") ? tmp.substring(1) : tmp;
    		
    		// ususally the path is
    		//      /C:/Programms/eclipse/
    		tmp = tmp.startsWith("/") ? tmp.substring(1) : tmp;
    		// converts all / into \
    		tmp = tmp.replace('/', '\\');
    		// remove last \
    		
			int pos = tmp.lastIndexOf('\\');
			int pos2 = tmp.lastIndexOf('\\', pos-1);

	    	System.err.println("size "+tmp.length()+" - pos1 "+pos+" - pos2 "+pos2 );

	    	System.err.println("sub1 "+tmp.substring(0,pos));
	    	System.err.println("sub2 "+tmp.substring(0,pos2));
	    	
	    	System.err.println("sub3 "+tmp.substring(pos2+1,pos));

    		tmp = tmp.endsWith("\\") ? tmp.substring(0, tmp.length()-1) : tmp;

    		
    		eclisePath = tmp; 
    	} else {
    		eclisePath = "";
			
    	}
    	System.err.println("eclipse path (windows) : " + eclisePath);
    	
    	String tmp = "abc\\\\efg";
		int pos = tmp.lastIndexOf('\\');
		int pos2 = tmp.lastIndexOf('\\', pos-1);

    	System.err.println("size "+tmp.length()+" - pos1 "+pos+" - pos2 "+pos2 );

    	System.err.println("sub1 "+tmp.substring(0,pos));
    	System.err.println("sub2 "+tmp.substring(0,pos2));
    	
    	System.err.println("sub3 "+tmp.substring(pos2+1,pos));
    	
		System.err.flush();
		System.out.flush();
	}

	/** Try to load an oil file and write all configuration files */
	@Test public void testStartRtos() {

	/*	RtosFactory rf = RtosFactory.INSTANCE;

		try {
			rf.write(new VarTree(), new String[0]);
		} catch (OilCodeWriterException e) {
			assertTrue(false);
		}

		// not valid writer

		boolean ok = false;
		try {
			rf.addWriter("test", new MyWriterForTests0());
		} catch (RuntimeException e) {
			ok = true;
		}
		assertTrue(ok);

		// add a valid writer

		rf.addWriter("test", new MyWriterForTests1());
		rf.addWriter("test", new MyWriterForTests1());

		// add a valid writer with an already used id
		ok = false;
		try {
			rf.addWriter("test", new MyWriterForTests2());
		} catch (RuntimeException e) {
			ok = true;
		}
		assertTrue(ok);

		// add valid writer with correct id
		rf.addWriter("test2", new MyWriterForTests2());
		rf.addWriter("test", new MyWriterForTests1());

		// add a valid writer with an already used id
		ok = false;
		try {
			rf.addWriter("test2", new MyWriterForTests1());
		} catch (RuntimeException e) {
			ok = true;
		}
		assertTrue(ok);*/
	}

	// --------------------------------
	
	final static public String DEFAULT_EE_IMPLEMENTATION;
	
	static {
		String tmp = null;
		try {
			InputStream input = CodeWritertTest.class.getResourceAsStream("/ee_appl.oil");
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			
			byte[] data = new byte[1024];
			try {
				for (int length = input.read(data); length != -1; length = input.read(data)) {
					output.write(data, 0, length);
				}
			} catch (IOException e) {
				// ???
				e.printStackTrace();
			}
			
			tmp = output.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} catch (Error e) {
			e.printStackTrace();
		}
		DEFAULT_EE_IMPLEMENTATION = tmp;
	}
	
	@Test public void testMask() {
		long mask = 1;
		System.out.println("Search ZERO using mask<<i:\n");

		for (int i=0; i<70; i++) {
			System.out.println("\t" + i + " " + (mask<<i));
		}

		System.out.println("Search ZERO using mask=mask<<1:\n");
		mask = 1;
		boolean ok = false;
		for (int i=0; i<200 && !ok; i++) {
			if (mask == 0) {
				ok = true;
			}
			System.out.println("\t" + i + " " + (mask));
			
			mask =mask<<1;
		}
		assertTrue(ok);
		

	}
	
	


	
	final static protected String OIL_TEST_DEFAULT_VALUE = DEFAULT_EE_IMPLEMENTATION
	+ "CPU EE {\n"
	+ "    OS EE {\n"
	+ "        EE_OPT = \"__ASSERT__\";\n"
	+ "        EE_OPT = \"__OSEKOS_NO_ALARMS__\";\n"
	+ "        EE_OPT = \"DEBUG\";\n"
	+ "        NIOS2_SYS_CONFIG = \"DEBUG\";\n"
	+ "        NIOS2_APP_CONFIG = \"DEBUG\";\n"
	+ "        NIOS2_DO_MAKE_OBJDUMP = TRUE;\n"
	+ "        NIOS2_JAM_FILE = \"test_file.jam\";\n"+
	"		   IPIC_GLOBAL_NAME = \"Ipic_subsystem\";\n" +
	"		   NIOS2_PTF_FILE = \"ptf_file\";\n" +
	
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
	+ "        SYS_SIZE = 0x1000;\n" +
	"	\n" +
	"		};\n" 
	+ "    };\n"
	+ "    TASK Task_A_2 {\n"
	+ "        CPU_ID = \"cpu1\";"
	+ "        PRIORITY = 0x02;\n"
	+ "    };\n"
	+ "};\n";
	@Test
	@Ignore
	public void testDefaultValue() {
		IVarTree vt = VarTreeUtil.newVarTree();
		(new OilReader()).load(new ByteArrayInputStream(
				OIL_TEST_DEFAULT_VALUE.getBytes()), vt);

		DataPackage dpkg = DataPackage.eINSTANCE;
		String prefix1 = "EE" + S + dpkg.getSystem_Architectural().getName()
				+ S + dpkg.getArchitectural_EcuList().getName() + S + "EE" + S
				+ dpkg.getEcu_CpuList().getName() + S + "cpu1" + S
				+ dpkg.getCpu_Rtos().getName();

		IOilWriterBuffer[] buffers = null;
		try {
			buffers = RtosFactory.INSTANCE.write(vt, new String[] { prefix1});
		} catch (OilCodeWriterException e) {
			e.printStackTrace();
			assertTrue(false);
		}

		assertNotNull(buffers);
		assertEquals(2, buffers.length);
		System.out.println((buffers[0]).toString());
		System.out.println((buffers[1]).toString());

	}

}

// --------------- WRITERS -----------------

/**
 * A writer without constructor
 */

class MyWriterForTests0 extends AbstractRtosWriter {
	/* (non-Javadoc)
	 * @see rtdruid.modules.oil.codewriter.crypted.AbstractRtosWriter#getHwOilId()
	 */
	protected String getHwOilId() {
		return null;
	}
	/* (non-Javadoc)
	 * @see rtdruid.modules.oil.codewriter.crypted.AbstractRtosWriter#getRtosOilId()
	 */
	protected String getRtosOilId() {
		return null;
	}
	/* (non-Javadoc)
	 * @see rtdruid.modules.oil.codewriter.crypted.AbstractRtosWriter#write()
	 */
	public IOilWriterBuffer[] write() throws OilCodeWriterException {
		return null;
	}
	
}

class MyWriterForTests1 extends MyWriterForTests0 {
}

class MyWriterForTests2 extends MyWriterForTests0 {
}
