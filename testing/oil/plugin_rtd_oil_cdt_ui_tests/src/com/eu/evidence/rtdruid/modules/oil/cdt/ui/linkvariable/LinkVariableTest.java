package com.eu.evidence.rtdruid.modules.oil.cdt.ui.linkvariable;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.variables.VariablesPlugin;
import org.junit.Test;

import com.eu.evidence.rtdruid.modules.oil.ee.ui.location.EEBaseDynamicVariableResolver;

public class LinkVariableTest {

	@Test
	public void uriTest() {
		URI value = null;
		try {
			String ee_path = VariablesPlugin.getDefault().getStringVariableManager().performStringSubstitution("${"+EEBaseDynamicVariableResolver.DYNVAR_ERIKA_ENTERPRISE_LOCATION+"}");
			if (ee_path != null) {
				value = new URI("file:/"+ee_path);
			} else {
				fail();
			}
		} catch (CoreException e) {
			fail(e.getMessage());
		} catch (URISyntaxException e) {
			fail(e.getMessage());
		}
		assertNotNull(value);
		
		
	}
	
	@Test
	public void fileToUriTest() {
		URI value = null;
		try {
			String ee_path = VariablesPlugin.getDefault().getStringVariableManager().performStringSubstitution("${"+EEBaseDynamicVariableResolver.DYNVAR_ERIKA_ENTERPRISE_LOCATION+"}");
			if (ee_path != null) {
				File f = new File(ee_path);
				value = f.toURI();
			} else {
				fail();
			}
		} catch (CoreException e) {
			fail(e.getMessage());
		}
		assertNotNull(value);
		
		
	}

}
