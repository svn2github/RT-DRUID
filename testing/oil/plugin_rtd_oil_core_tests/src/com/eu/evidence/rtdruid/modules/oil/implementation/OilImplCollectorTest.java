package com.eu.evidence.rtdruid.modules.oil.implementation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.util.HashSet;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.junit.Test;
import org.w3c.dom.Document;

import com.eu.evidence.rtdruid.internal.modules.oil.implementation.OilImplCollector;
import com.eu.evidence.rtdruid.internal.modules.oil.implementation.OilImplementation;
import com.eu.evidence.rtdruid.internal.modules.oil.reader.OilInfo;
import com.eu.evidence.rtdruid.internal.modules.oil.reader.OilParser;
import com.eu.evidence.rtdruid.internal.modules.oil.reader.ParseException;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OilImplFactory;
import com.eu.evidence.rtdruid.modules.oil.transform.OilTransformFactory;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.VarTreeUtil;


public class OilImplCollectorTest {

	@Test
	public void testImplementationsNumber() {
		IOilImplementation[] impls = OilImplCollector.getAllOilImplementation();
		
		IConfigurationElement[] config = Platform.getExtensionRegistry()
		.getConfigurationElementsFor("com.eu.evidence.rtdruid.oil.core.oil_implementation");

		assertTrue(config.length >= impls.length);
		assertTrue(config.length == impls.length);
	}
	
	
	@Test
	public void testGetAllImplementations() throws ParseException {
		IOilImplementation[] impls = OilImplCollector.getAllOilImplementation();

		for (IOilImplementation impl : impls) {
			assertNotNull(impl.getId());
			String oilTxt = impl.toOil();
			assertNotNull(oilTxt);
			assertFalse(oilTxt.isEmpty());
			
			String tmpOilTxt;
			if (oilTxt.startsWith("OIL_VERSION")) {
				tmpOilTxt = oilTxt;
			} else {
				tmpOilTxt = "OIL_VERSION = \"2.4\";\n\n" + oilTxt;
			}
			
			IOilImplementation parsed = parse(tmpOilTxt);
			assertNotSame(parsed, impl);
			assertEquals(0, impl.getId().compareTo(parsed.getId()));
			String oilTxt2 = parsed.toOil();
			assertNotNull(oilTxt2);
			assertTrue(oilTxt.equals(oilTxt2));
		}
	}
	
	@Test
	public void testMergeImplementations() throws ParseException {
		IOilImplementation[] impls = OilImplCollector.getAllOilImplementation();

		IVarTree vt = VarTreeUtil.newVarTree();
		OilImplFactory oif = OilImplFactory.getAnInstance(vt);
		
		HashSet<IOilImplID> ids = new HashSet<IOilImplID>();
		for (IOilImplementation impl : impls) {
			ids.add(impl.getId());
			oif.merge(impl);
		}
		
		for (IOilImplID id : ids) {
			IOilImplementation impl = oif.getImpl(id);

			assertNotNull(impl.getId());
			assertEquals(0, id.compareTo(impl.getId()));
			String oilTxt = impl.toOil();
			assertNotNull(oilTxt);
			assertFalse(oilTxt.isEmpty());
			

			String tmpOilTxt;
			if (oilTxt.startsWith("OIL_VERSION")) {
				tmpOilTxt = oilTxt;
			} else {
				tmpOilTxt = "OIL_VERSION = \"2.4\";\n\n" + oilTxt;
			}
			
			IOilImplementation parsed = parse(tmpOilTxt);
			assertNotSame(parsed, impl);
			assertEquals(0, impl.getId().compareTo(parsed.getId()));
			String oilTxt2 = parsed.toOil();
			assertNotNull(oilTxt2);
			assertTrue(oilTxt.equals(oilTxt2));
		}
	}
	
	private IOilImplementation parse(String oil) throws ParseException {
		OilParser op = new OilParser(new ByteArrayInputStream(oil.getBytes()));
		assertNotNull(op);
		OilInfo parsed = null;
		parsed = op.start();
		IOilImplID oiid = OilTransformFactory.INSTANCE.getOilId(parsed.getName());
		assertNotNull(oiid);
		Document data = parsed.getImpl();
		assertNotNull(data);
		OilImplementation out = new OilImplementation(oiid, data);
		return out;
	}
}
