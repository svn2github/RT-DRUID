package com.eu.evidence.rtdruid.modules.oil.erikaenterprise.location;

import static org.junit.Assert.assertNotNull;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.variables.VariablesPlugin;
import org.junit.Ignore;
import org.junit.Test;

import com.eu.evidence.rtdruid.tests.RtdAssert;

public class EEBaseDynamicVariableResolverTest {

	/* TODO:  This test should be moved to ui tests	 */
	@Test
	@Ignore
	public void testResolveValue() throws CoreException {
		String ee_path = VariablesPlugin.getDefault().getStringVariableManager().performStringSubstitution("${ee_base}");
		System.out.println(ee_path);
		assertNotNull(ee_path);
	}

	@Test
	public void testUnresolveValue() throws CoreException {
		new RtdAssert(CoreException.class) {
			protected void doCheck() throws Throwable {
				VariablesPlugin.getDefault().getStringVariableManager().performStringSubstitution("${ee_base}");
			};
		};
	}

}
