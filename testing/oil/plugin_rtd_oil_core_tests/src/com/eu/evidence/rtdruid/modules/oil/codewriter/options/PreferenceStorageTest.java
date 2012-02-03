package com.eu.evidence.rtdruid.modules.oil.codewriter.options;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class PreferenceStorageTest {

	@Test
	public void testPreferenceStorage() {
		PreferenceStorage pref = PreferenceStorage.getCommonIstance();
		assertNotNull(pref);
	}

	@Test
	@Ignore
	public void testLookForWorkspaceFile() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testLookForInstallationFile() {
		fail("Not yet implemented");
	}

}
