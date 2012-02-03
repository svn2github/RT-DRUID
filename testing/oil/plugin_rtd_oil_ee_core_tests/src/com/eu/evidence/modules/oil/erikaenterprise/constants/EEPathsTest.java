package com.eu.evidence.modules.oil.erikaenterprise.constants;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.eu.evidence.rtdruid.modules.oil.codewriter.options.PreferenceStorage;

public class EEPathsTest {

	@Test
	public void testGetEe_base() {
		System.out.println("\nEE SRC_BASE");
		ArrayList<EE_src_distr> a = EEPaths.parseAllEEsrcExtensions();
		System.out.println(a);
	}

	@Test
	public void testGetEvidence_base() {
		System.out.println("\nEE_BASE");
		ArrayList<String> a = EEPaths.parseAllEviExtensions();
		System.out.println(a);
	}

	@Test
	public void testGetAllEe_base() {
		System.out.println("\nEE_BASE");
		List<EE_src_distr> a = EEPaths.getAllEe_base();
		System.out.println(a);
	}
	
	@Test
	public void testConfEe_base() {
		System.out.println("\nConfiguration EE_BASE");
		String pkg_name = "/" + getClass().getPackage().getName().replace('.', '/') + "/";
		{
			System.out.println("default");
			List<EE_src_distr> a1 = EEPaths.parseAllEEsrcExtensions();
			System.out.println(a1);
		}
		{
			System.out.println("cwd");
			PreferenceStorage.getCommonIstance().load(getClass().getClassLoader().getResourceAsStream(pkg_name+"eebase_cwd.properties"));
			List<EE_src_distr> a2 = EEPaths.parseAllEEsrcExtensions();
			System.out.println(a2);
		}
		{
			System.out.println("absolute");
			PreferenceStorage.getCommonIstance().load(getClass().getClassLoader().getResourceAsStream(pkg_name+"eebase_absolute_path.properties"));
			List<EE_src_distr> a2 = EEPaths.parseAllEEsrcExtensions();
			System.out.println(a2);
		}
		{
			System.out.println("eclipse");
			PreferenceStorage.getCommonIstance().load(getClass().getClassLoader().getResourceAsStream(pkg_name+"eebase_eclipse_location.properties"));
			List<EE_src_distr> a2 = EEPaths.parseAllEEsrcExtensions();
			System.out.println(a2);
		}
		{
			System.out.println("eclipse/..");
			PreferenceStorage.getCommonIstance().load(getClass().getClassLoader().getResourceAsStream(pkg_name+"eebase_eclipse_parent.properties"));
			List<EE_src_distr> a2 = EEPaths.parseAllEEsrcExtensions();
			System.out.println(a2);
		}
	}
}
