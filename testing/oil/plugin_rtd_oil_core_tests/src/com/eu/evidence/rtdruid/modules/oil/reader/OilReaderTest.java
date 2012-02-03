/*
 * Created on 11-nov-2004
 *
 * $Id: OilReaderTest.java,v 1.6 2008/03/26 18:23:51 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.reader;



import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.w3c.dom.Document;

import com.eu.evidence.rtdruid.internal.modules.oil.implementation.OilImplFactory_Impl;
import com.eu.evidence.rtdruid.internal.modules.oil.reader.OilReader;
import com.eu.evidence.rtdruid.modules.oil.implementation.IOilImplID;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.VarTreeUtil;
import com.eu.evidence.rtdruid.vartree.Vt2StringUtilities;

/**
 * @author Nicola Serreli
 */
public class OilReaderTest implements Examples {

	@Rule public TestName name = new TestName();
	
	@Before
	public void setUp() throws Exception {
		System.err.flush();
		System.out.println("\n\n************\n TEST " + getClass().getName() + " - " + name.getMethodName() + "\n************\n\n");
		System.out.flush();
	}
	
	@After
	public void setDown() throws Exception {
		System.err.flush();
		System.out.flush();
	}
	    
    /** Try to load a splitted Oil Implementation Section */
    @Test
    public void testLoad_test_1_splitted() {
    	IVarTree vt = VarTreeUtil.newVarTree();
        IOilImplID[] oids = OilImplFactory_Impl.getAnInstance(vt).getImplNames();
        assertNotNull(oids);
        assertEquals(oids.length, 0);
        
        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1_IMPL_ONLY_ALARM.getBytes()), vt, null, null);
        vt.clear();
        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1_SPLITTED_IMPL_ONLY_ALARM.getBytes()), vt, null, null);
        oids = OilImplFactory_Impl.getAnInstance(vt).getImplNames();
        assertNotNull(oids);
        assertEquals(oids.length, 1);
    }

    @Test
    public void testLoad_test_1_vt() throws IOException {
    	IVarTree vt = VarTreeUtil.newVarTree();
        IOilImplID[] oids = OilImplFactory_Impl.getAnInstance(vt).getImplNames();
        assertNotNull(oids);
        assertEquals(oids.length, 0);
        
        {
	        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1.getBytes()), vt, null, null);
	        String vt_ertd = Vt2StringUtilities.varTreeToStringErtd(vt);
	        System.out.println(Vt2StringUtilities.explodeOilVar(vt_ertd));
	        IVarTree vt2 =Vt2StringUtilities.loadString(vt_ertd, "ertd");
			String t = VarTreeUtil.compare(vt, vt2).getMessage(); assertNull(t, t);
        }
        
        {
	        String vt_rappr = Vt2StringUtilities.varTreeToStringRtd(vt);
	        System.out.println("\n\n\n" + vt_rappr);
	        IVarTree vt3 =Vt2StringUtilities.loadString(vt_rappr, "rtd");
	        String t = VarTreeUtil.compare(vt, vt3).getMessage(); assertNull(t, t);
        }

    }
    
    @Test
    public void testLoad_test_1() {
    	IVarTree vt = VarTreeUtil.newVarTree();
        IOilImplID[] oids = OilImplFactory_Impl.getAnInstance(vt).getImplNames();
        assertNotNull(oids);
        assertEquals(oids.length, 0);
        
        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1.getBytes()), vt, null, null);
        vt.clear();
        
        oids = OilImplFactory_Impl.getAnInstance(vt).getImplNames();
        assertNotNull(oids);
        assertEquals(oids.length, 1);
        
        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1.getBytes()), vt, null, null);
        vt.clear();
        
        oids = OilImplFactory_Impl.getAnInstance(vt).getImplNames();
        assertNotNull(oids);
        assertEquals(oids.length, 1);
        
        OilImplFactory_Impl.getAnInstance(vt).clear();
        oids = OilImplFactory_Impl.getAnInstance(vt).getImplNames();
        assertNotNull(oids);
        assertEquals(oids.length, 0);

        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1.getBytes()), vt, null, null);
        vt.clear();
        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1_IMPL_ONLY.getBytes()), vt, null, null);
        vt.clear();
        oids = OilImplFactory_Impl.getAnInstance(vt).getImplNames();
        assertNotNull(oids);
        assertEquals(oids.length, 1);
        
        boolean ok = false;
        try {
            (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1_IMPL_ONLY_OS.getBytes()), vt, null, null);
            vt.clear();
        } catch(RuntimeException e){
            ok = true;
        }
        assertTrue(ok);
        
        ok = false;
        try {
	        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1_IMPL_ONLY_ALARM.getBytes()), vt, null, null);
	        vt.clear();
	    } catch(RuntimeException e){
	        ok = true;
	    }
	    assertTrue(ok);

        assertEquals(OilImplFactory_Impl.getAnInstance(vt).getImplNames().length, 1);
        
        OilImplFactory_Impl.getAnInstance(vt).clear();

        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1_IMPL_ONLY_OS.getBytes()), vt, null, null);
        vt.clear();
        ok = false;
        try {
            (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1_IMPL_ONLY_ALARM.getBytes()), vt, null, null);
            vt.clear();
	    } catch(RuntimeException e){
	        ok = true;
	    }
	    assertTrue(ok);
        assertEquals(OilImplFactory_Impl.getAnInstance(vt).getImplNames().length, 1);
    }
    
    
    @Test
    public void testLoad_test_1_and_2() {
    	IVarTree vt = VarTreeUtil.newVarTree();
        IOilImplID[] oids = OilImplFactory_Impl.getAnInstance(vt).getImplNames();
        assertNotNull(oids);
        assertEquals(oids.length, 0);
        
        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1.getBytes()), vt, null, null);
        vt.clear();
        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_2.getBytes()), vt, null, null);
        vt.clear();
        
        oids = OilImplFactory_Impl.getAnInstance(vt).getImplNames();
        assertNotNull(oids);
        assertEquals(oids.length, 2);
        
        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1.getBytes()), vt, null, null);
        vt.clear();
        
        oids = OilImplFactory_Impl.getAnInstance(vt).getImplNames();
        assertNotNull(oids);
        assertEquals(oids.length, 2);
        
        OilImplFactory_Impl.getAnInstance(vt).clear();
        oids = OilImplFactory_Impl.getAnInstance(vt).getImplNames();
        assertNotNull(oids);
        assertEquals(oids.length, 0);

        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_2.getBytes()), vt, null, null);
        vt.clear();
        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1.getBytes()), vt, null, null);
        vt.clear();
        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1_IMPL_ONLY.getBytes()), vt, null, null);
        vt.clear();
        oids = OilImplFactory_Impl.getAnInstance(vt).getImplNames();
        assertNotNull(oids);
        assertEquals(oids.length, 2);
        
        boolean ok = false;
        try {
            (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1_IMPL_ONLY_OS.getBytes()), vt, null, null);
            vt.clear();
        } catch(RuntimeException e){
            ok = true;
        }
        assertTrue(ok);
        
        ok = false;
        try {
	        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1_IMPL_ONLY_ALARM.getBytes()), vt, null, null);
	        vt.clear();
	    } catch(RuntimeException e){
	        ok = true;
	    }
	    assertTrue(ok);

        assertEquals(OilImplFactory_Impl.getAnInstance(vt).getImplNames().length, 2);
        
        OilImplFactory_Impl.getAnInstance(vt).clear();

        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_2.getBytes()), vt, null, null);
        vt.clear();
        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1_IMPL_ONLY_OS.getBytes()), vt, null, null);
        vt.clear();
        ok = false;
        try {
            (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1_IMPL_ONLY_ALARM.getBytes()), vt, null, null);
            vt.clear();
	    } catch(RuntimeException e){
	        ok = true;
	    }
	    assertTrue(ok);
        assertEquals(OilImplFactory_Impl.getAnInstance(vt).getImplNames().length, 2);
    }

    @Test
    public void testLoad_test_SenzaImplementation() {
        IOilImplID[] oids = OilImplFactory_Impl.getAnInstance(VarTreeUtil.newVarTree()).getImplNames();
        assertNotNull(oids);
        assertEquals(oids.length, 0);
        
        IVarTree vt = VarTreeUtil.newVarTree();
        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_SENZA_IMPL.getBytes()), vt, null, null);
        String vt_ertd = Vt2StringUtilities.varTreeToStringErtd(vt);
        System.out.println("\n\n\n" + vt_ertd);
    }
    
    @Test(expected=RuntimeException.class)
    public void testLoad_test_enumWrong() throws RuntimeException {
        IOilImplID[] oids = OilImplFactory_Impl.getAnInstance(VarTreeUtil.newVarTree()).getImplNames();
        assertNotNull(oids);
        assertEquals(oids.length, 0);
        
        IVarTree vt = VarTreeUtil.newVarTree();
       	(new OilReader()).load(new ByteArrayInputStream(OIL_TEST_WRONG_ENUM.getBytes()), vt, null, null);
    }
    
    @Test
    public void testLoad_xml() {
        Document xml = (new OilReader()).loadAsXml(new ByteArrayInputStream(OIL_TEST_SENZA_IMPL.getBytes()), null, null);
        assertNotNull(xml);
        assertNotNull(xml.getDocumentElement());
        System.out.println(xmlToText(xml));
    }
    
    public static String xmlToText(Document doc) {
    	ByteArrayOutputStream output = new ByteArrayOutputStream();
		try {
			Transformer transformer = TransformerFactory.newInstance()
					.newTransformer();

			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			// Transform the source XML
			transformer.transform(new DOMSource(doc), new StreamResult(output));

		} catch (TransformerConfigurationException tce) {
			// Error generated by the parser
			System.out.println("* Transformer Factory error");
			System.out.println("  " + tce.getMessage());

			// Use the contained exception, if any
			Throwable x = tce;
			if (tce.getException() != null)
				x = tce.getException();
			x.printStackTrace();

		} catch (TransformerException te) {
			// Error generated by the parser
			System.out.println("* Transformation error");
			System.out.println("  " + te.getMessage());

			// Use the contained exception, if any
			Throwable x = te;
			if (te.getException() != null)
				x = te.getException();
			x.printStackTrace();

		}

		return output.toString();
    }
    
    
}

