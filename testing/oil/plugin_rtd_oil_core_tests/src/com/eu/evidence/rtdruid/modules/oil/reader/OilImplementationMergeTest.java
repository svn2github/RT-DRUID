/*
 * Created on 11-nov-2004
 *
 * $Id: OilReaderTest.java,v 1.6 2008/03/26 18:23:51 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.reader;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;

import org.junit.Test;

import com.eu.evidence.rtdruid.internal.modules.oil.implementation.OilImplFactory_Impl;
import com.eu.evidence.rtdruid.internal.modules.oil.reader.OilReader;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OilImplFactory;
import com.eu.evidence.rtdruid.modules.oil.implementation.IOilImplID;
import com.eu.evidence.rtdruid.modules.oil.implementation.IOilImplementation;
import com.eu.evidence.rtdruid.tests.RtdAssert;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.VarTreeUtil;
import com.eu.evidence.rtdruid.vartree.tools.Search;

/**
 * @author Nicola Serreli
 */
public class OilImplementationMergeTest implements Examples {
    
    
    
    /** Try to load a splitted Oil Implementation Section */
	@Test
    public void testLoad_test_1_splitted() {
    	IVarTree vt = VarTreeUtil.newVarTree();
        IOilImplID[] oids = OilImplFactory_Impl.getAnInstance(vt).getImplNames();
        assertNotNull(oids);
        assertEquals(oids.length , 0);
        
        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1_IMPL_ONLY_ALARM.getBytes()), vt);
        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1_SPLITTED_IMPL_ONLY_ALARM.getBytes()), vt);
        oids = OilImplFactory_Impl.getAnInstance(vt).getImplNames();
        assertNotNull(oids);
        assertEquals(oids.length , 1);
    }

	@Test
    public void testLoad_test_1() {
    	final IVarTree vt = VarTreeUtil.newVarTree();
        IOilImplID[] oids = OilImplFactory_Impl.getAnInstance(vt).getImplNames();
        assertNotNull(oids);
        assertEquals(oids.length , 0);
        
        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1_IMPL_ONLY.getBytes()), vt);
        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1_IMPL_ONLY.getBytes()), vt);
        oids = OilImplFactory_Impl.getAnInstance(vt).getImplNames();
        assertNotNull(oids);
        assertEquals(oids.length , 1);
        
        
		(new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1_IMPL_ONLY_OS.getBytes()), vt);
		(new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1_IMPL_ONLY_ALARM.getBytes()), vt);
	        

        assertEquals(OilImplFactory_Impl.getAnInstance(vt).getImplNames().length , 1);
        
        OilImplFactory_Impl.getAnInstance(vt).clear();

        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1_IMPL_ONLY_OS.getBytes()), vt);
		(new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1_IMPL_ONLY_ALARM.getBytes()), vt);

        assertEquals(OilImplFactory_Impl.getAnInstance(vt).getImplNames().length , 1);
        
        OilImplFactory_Impl.getAnInstance(vt).clear();

		(new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1_IMPL_ONLY_ALARM.getBytes()), vt);

        assertEquals(OilImplFactory_Impl.getAnInstance(vt).getImplNames().length , 1);
    }

    
	@Test
    public void testLoad_test_implementationsMerge() {
    	IVarTree vt1 = VarTreeUtil.newVarTree();
    	IVarTree vt2 = VarTreeUtil.newVarTree();
    	OilImplFactory oif_1 = OilImplFactory.getAnInstance(vt1);
    	OilImplFactory oif_2 = OilImplFactory.getAnInstance(vt2);
    	
    	IOilImplID[] oids = null;
    	
    	oids = oif_1.getImplNames();
        assertNotNull(oids);
        assertEquals(oids.length , 0);
        oids = oif_2.getImplNames();
        assertNotNull(oids);
        assertEquals(oids.length , 0);
        
        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1_IMPL_ONLY_OS.getBytes()), vt1);
        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1_IMPL_ONLY_ALARM.getBytes()), vt2);

        assertEquals(oif_1.getImplNames().length , 1);
        assertEquals(oif_2.getImplNames().length , 1);
        
    	assertEquals(oif_1 , OilImplFactory.getAnInstance(vt1));
    	assertEquals(oif_2 , OilImplFactory.getAnInstance(vt2));
        
    	IOilImplementation oi_1 = oif_1.getImpl(oif_1.getImplNames()[0]);
    	IOilImplementation oi_2 = oif_2.getImpl(oif_1.getImplNames()[0]);
    	
    	String s1 = oi_1.toOil();
    	String s2 = oi_2.toOil();
    	
    	assertFalse(oi_1.equals(oi_2));
    	assertFalse(oi_1.equalsImpl(oi_2));
    	assertFalse(oi_2.equalsImpl(oi_1));
    	assertFalse(s1.equals(s2));
    	
    	
    	assertTrue(oi_1.mergeImpl(oi_2));
    	String s3 = oi_1.toOil();
    	System.out.println(">>>>>>> S1 \n"+ s1+"S1 <<<<<<<<\n");
    	System.out.println(">>>>>>> S2 \n"+ s2+"S2 <<<<<<<<\n");
    	System.out.println(">>>>>>> S3 \n"+ s3+"S3 <<<<<<<<\n");
    	assertFalse(s1.equals(s3));
    	
    }

    @Test(expected=RuntimeException.class)
    public void testLoad_test_enumWrong() throws RuntimeException {
        final String OIL_TEST_WRONG_ENUM =
        		"    CPU test {" +
        		"        OS testOS {" +
        		 "        EE_OPT = \"__ASSERT__\";\n"
        		+ "        EE_OPT = \"__OSEKOS_NO_ALARMS__\";\n"
        		+ "        EE_OPT = \"DEBUG\";\n"
        		+ "        NIOS2_DO_MAKE_OBJDUMP = FALSE;\n"+
        		"		CPU_DATA = NIOSII {\n" +
        		"			ID = \"cpu2\";\n" +
        		"	\n" +
        		"		};\n" 
        		+ "    };\n"
        		+ "ALARM AllIncluded {\n"
        		+ "    COUNTER = cc1;\n"
        		+ "    ACTION = ACTIVATETASK {\n"
        		+ "        TASK = Task2;\n"
        		+ "    };\n"
        		+ "    ACTION = SETEVENT {\n"
        		+ "        TASK = Task1;\n"
        		+ "       EVENT = vv;\n"
        		+ "   };\n"
        		+ "    ACTION = ALARMCALLBACK {\n"
        		+ "        ALARMCALLBACKNAME = \"WakeTaskB\";\n"
        		+ "    };\n"
        		+ "    AUTOSTART = TRUE {\n"
        		+ "        ALARMTIME = 50;\n"
        		+ "        CYCLETIME = 100;\n"
        		+ "    };\n"
        		+ "};\n"
        		+ "};\n";
        IOilImplID[] oids = OilImplFactory_Impl.getAnInstance(VarTreeUtil.newVarTree()).getImplNames();
        assertNotNull(oids);
        assertEquals(oids.length , 0);
        
        IVarTree vt = VarTreeUtil.newVarTree();
        boolean ok = false;
       	(new OilReader()).load(new ByteArrayInputStream(OIL_TEST_WRONG_ENUM.getBytes()), vt);
    }
}

