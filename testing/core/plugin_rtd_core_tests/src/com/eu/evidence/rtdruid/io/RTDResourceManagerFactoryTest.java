/**
 * 18/gen/2012
 */
package com.eu.evidence.rtdruid.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import com.eu.evidence.rtdruid.internal.io.RTDResourceManagerFactory;
import com.eu.evidence.rtdruid.internal.io.RTDResourceManagerFactory.ResExporter;
import com.eu.evidence.rtdruid.internal.io.RTDResourceManagerFactory.ResImporter;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class RTDResourceManagerFactoryTest {

	/**
	 * 
	 */
	@Test
	public void testGetAllImportTypes() {
		String[] importTypes = RTDResourceManagerFactory.getInstance().getAllImportTypes();
		assertNotNull(importTypes);
		
		String[] clone = Arrays.copyOf(importTypes, importTypes.length);
		assertEquals(clone.length, importTypes.length);
		for (int i=0; i<importTypes.length; i++) {
			assertNotNull(importTypes[i]);
			assertSame(clone[i], importTypes[i]);
			importTypes[i] = null;
		}
		
		String[] newImportTypes = RTDResourceManagerFactory.getInstance().getAllImportTypes();
		assertEquals(clone.length, newImportTypes.length);
		for (int i=0; i<newImportTypes.length; i++) {
			assertSame(clone[i], newImportTypes[i]);
			assertNull(importTypes[i]);
		}
	}

	/**
	 * 
	 */
	@Test
	public void testGetAllExportTypes() {
		String[] exportTypes = RTDResourceManagerFactory.getInstance().getAllExportTypes();
		assertNotNull(exportTypes);
		
		String[] clone = Arrays.copyOf(exportTypes, exportTypes.length);
		assertEquals(clone.length, exportTypes.length);
		for (int i=0; i<exportTypes.length; i++) {
			assertNotNull(exportTypes[i]);
			assertSame(clone[i], exportTypes[i]);
			exportTypes[i] = null;
		}
		
		String[] newExportTypes = RTDResourceManagerFactory.getInstance().getAllExportTypes();
		assertEquals(clone.length, newExportTypes.length);
		for (int i=0; i<newExportTypes.length; i++) {
			assertSame(clone[i], newExportTypes[i]);
			assertNull(exportTypes[i]);
		}
	}

	/**
	 * 
	 */
	@Test
	public void testGetImport() {
		RTDResourceManagerFactory rmf = RTDResourceManagerFactory.getInstance();
		String[] importTypes = rmf.getAllImportTypes();
		assertNotNull(importTypes);
		
		for (int i=0; i<importTypes.length; i++) {
			String type = importTypes[i];
			assertNotNull(type);
			assertTrue(rmf.supportImport(type));
			
			ResImporter importer = rmf.getImportRes(type);
			assertNotNull(importer);
			assertNotNull(importer.toString());
			assertNotNull(importer.getAnInstance());
			assertNotNull(rmf.getImport(type));
			assertSame(importer.getAnInstance().getClass(), rmf.getImport(type).getClass());
		}
		assertFalse(rmf.supportImport(null));
		assertFalse(rmf.supportImport("1234567890"));

		assertNull(rmf.getImportRes(null));
		assertNull(rmf.getImportRes("1234567890"));

		assertNull(rmf.getImport(null));
		assertNull(rmf.getImport("1234567890"));
	}


	/**
	 * 
	 */
	@Test
	public void testGetExport() {
		RTDResourceManagerFactory rmf = RTDResourceManagerFactory.getInstance();
		String[] exportTypes = rmf.getAllExportTypes();
		assertNotNull(exportTypes);
		
		for (int i=0; i<exportTypes.length; i++) {
			String type = exportTypes[i];
			assertNotNull(type);
			assertTrue(rmf.supportExport(type));
			
			ResExporter exporter = rmf.getExportRes(type);
			assertNotNull(exporter);
			assertNotNull(exporter.toString());
			assertNotNull(exporter.getAnInstance());
			assertNotNull(rmf.getExport(type));
			assertSame(exporter.getAnInstance().getClass(), rmf.getExport(type).getClass());
		}
		assertFalse(rmf.supportExport(null));
		assertFalse(rmf.supportExport("1234567890"));

		assertNull(rmf.getExportRes(null));
		assertNull(rmf.getExportRes("1234567890"));

		assertNull(rmf.getExport(null));
		assertNull(rmf.getExport("1234567890"));
	}

}
