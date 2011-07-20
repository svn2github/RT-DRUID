package com.eu.evidence.modules.oil.erikaenterprise.constants;

import java.util.ArrayList;

import junit.framework.TestCase;

public class EEPathsTest extends TestCase {

	public void testGetEe_base() {
		System.out.println("\nEE SRC_BASE");
		ArrayList<EE_src_distr> a = EEPaths.parseAllEEsrcExtensions();
		System.out.println(a);
	}

	public void testGetEvidence_base() {
		System.out.println("\nEE_BASE");
		ArrayList<String> a = EEPaths.parseAllEviExtensions();
		System.out.println(a);
	}

}
