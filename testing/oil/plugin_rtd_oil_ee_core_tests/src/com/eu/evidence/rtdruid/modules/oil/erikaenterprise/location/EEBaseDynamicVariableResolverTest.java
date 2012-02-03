package com.eu.evidence.rtdruid.modules.oil.erikaenterprise.location;

import static org.junit.Assert.*;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.variables.VariablesPlugin;
import org.junit.Test;

public class EEBaseDynamicVariableResolverTest {

	@Test
	public void testResolveValue() {
		
		try {
			String ee_path = VariablesPlugin.getDefault().getStringVariableManager().performStringSubstitution("${ee_base}");
			System.out.println(ee_path);
			assertNotNull(ee_path);
		} catch (CoreException e) {
			e.printStackTrace();
			fail();
		}
	}

}
