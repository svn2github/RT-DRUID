package com.eu.evidence.rtdruid.modules.oil.cdt.ui.cygwin;

import junit.framework.TestCase;

public class AutoCygwindSearchTest extends TestCase {

	public void testSearch() {
		String txt = AutoCygwindSearch.search();
		System.out.println("_" + txt + "_");
	}

}
