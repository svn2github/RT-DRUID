package com.eu.evidence.rtdruid.modules.oil.erikaenterprise.location;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.variables.IStringVariableManager;
import org.eclipse.core.variables.VariablesPlugin;
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
	public void testGetAllEe_base() {
		System.out.println("\nEE_BASE");
		List<EE_src_distr> a = EEPaths.getAllEe_base();
		System.out.println(a);
	}
	
	@Test
	public void testConfEe_base() {
		String pkg_name = "/" + getClass().getPackage().getName().replace('.', '/') + "/";
		{
			List<EE_src_distr> a1 = EEPaths.parseAllEEsrcExtensions();
			System.out.println(a1);
			check("${eclipse_home}/features", a1);
		}
		{
			PreferenceStorage.getCommonIstance().load(getClass().getClassLoader().getResourceAsStream(pkg_name+"eebase_cwd.properties"));
			List<EE_src_distr> a2 = EEPaths.parseAllEEsrcExtensions();
			check(".", a2);
		}
		{
			PreferenceStorage.getCommonIstance().load(getClass().getClassLoader().getResourceAsStream(pkg_name+"eebase_absolute_path.properties"));
			List<EE_src_distr> a2 = EEPaths.parseAllEEsrcExtensions();
			check("c:/", a2);
		}
		{
			PreferenceStorage.getCommonIstance().load(getClass().getClassLoader().getResourceAsStream(pkg_name+"eebase_eclipse_location.properties"));
			List<EE_src_distr> a2 = EEPaths.parseAllEEsrcExtensions();
			check("${eclipse_home}/plugins", a2);
		}
		{
			PreferenceStorage.getCommonIstance().load(getClass().getClassLoader().getResourceAsStream(pkg_name+"eebase_eclipse_parent.properties"));
			List<EE_src_distr> a2 = EEPaths.parseAllEEsrcExtensions();
			check("${eclipse_home}/..", a2);
		}


	}
	
	protected void check(String expectedExpression, List<EE_src_distr> values) {
		
		IStringVariableManager isvm = VariablesPlugin.getDefault().getStringVariableManager();
		assert(isvm != null);
		
		String expectedFile = null;
		try {
			expectedFile = isvm.performStringSubstitution(expectedExpression, true);
		} catch (CoreException e) {
			fail(e.getMessage());
		}
		
		File cRoot = new File(expectedFile); 
		String expectedPath = null;
		try {
			expectedPath = cRoot.getCanonicalPath();
		} catch (IOException e) {
			fail(e.getMessage());
		}

		
		boolean found = false;

		for (EE_src_distr v: values) {
			found |= expectedPath.equals(v.erikaFilesLocation);
		}
		
		System.out.println(expectedExpression + "\t" +found+"\t" + values);
		
		assertTrue(found);

	}
}
