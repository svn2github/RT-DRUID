/**
 * 18/gen/2012
 */
package com.eu.evidence.rtdruid.io;

import static com.eu.evidence.rtdruid.tests.RtdAssert.assertGreater;
import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class RTD_XMI_FactoryTest {

	/**
	 * Test method for {@link com.eu.evidence.rtdruid.io.RTD_XMI_Factory#getAllImportTypes()}.
	 */
	@Test
	public void testGetAllImportTypes() {
		String[] importTypes = RTD_XMI_Factory.getAllImportTypes();
		assertNotNull(importTypes);
		assertGreater(0, importTypes.length);
		
		{
			boolean found = false;
			for (String s: importTypes) {
				found |= "ertd".equalsIgnoreCase(s);
			}
			assertTrue(found);
		}
		
		String[] clone = Arrays.copyOf(importTypes, importTypes.length);
		assertEquals(clone.length, importTypes.length);
		for (int i=0; i<importTypes.length; i++) {
			assertNotNull(importTypes[i]);
			assertSame(clone[i], importTypes[i]);
			importTypes[i] = null;
		}
		
		String[] newImportTypes = RTD_XMI_Factory.getAllImportTypes();
		assertEquals(clone.length, newImportTypes.length);
		for (int i=0; i<newImportTypes.length; i++) {
			assertSame(clone[i], newImportTypes[i]);
			assertNull(importTypes[i]);
		}
	}

	/**
	 * Test method for {@link com.eu.evidence.rtdruid.io.RTD_XMI_Factory#getAllExportTypes()}.
	 */
	@Test
	public void testGetAllExportTypes() {
		String[] exportTypes = RTD_XMI_Factory.getAllExportTypes();
		assertNotNull(exportTypes);
		assertGreater(0, exportTypes.length);
		
		{
			boolean found = false;
			for (String s: exportTypes) {
				found |= "ertd".equalsIgnoreCase(s);
			}
			assertTrue(found);
		}
		
		String[] clone = Arrays.copyOf(exportTypes, exportTypes.length);
		assertEquals(clone.length, exportTypes.length);
		for (int i=0; i<exportTypes.length; i++) {
			assertNotNull(exportTypes[i]);
			assertSame(clone[i], exportTypes[i]);
			exportTypes[i] = null;
		}
		
		String[] newExportTypes = RTD_XMI_Factory.getAllExportTypes();
		assertEquals(clone.length, newExportTypes.length);
		for (int i=0; i<newExportTypes.length; i++) {
			assertSame(clone[i], newExportTypes[i]);
			assertNull(exportTypes[i]);
		}
	}

}
