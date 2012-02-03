/*
 * Created on 2-feb-2007
 *
 */
package com.eu.evidence.rtdruid.internal.desk;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.eu.evidence.rtdruid.desk.ReadVersion;

/**
 * @author Nicola Serreli
 *
 */
public class ReadVersionTest {

	@Test
	public void testLoadVersions () {
		
		String rtd_version = ReadVersion.getRTDruidVersion();
		assertNotNull(rtd_version);
	}
}
