package com.eu.evidence.rtdruid.modules.oil.cdt.ui.linkvariable;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.variables.VariablesPlugin;
import org.junit.Test;

import com.eu.evidence.rtdruid.modules.oil.codewriter.common.HostOsUtils;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OsType;
import com.eu.evidence.rtdruid.modules.oil.ee.ui.location.EEBaseDynamicVariableResolver;
import com.eu.evidence.rtdruid.tests.RtdAssert;

public class LinkVariableTest {

	@Test
	public void uriTest() throws CoreException, URISyntaxException {
		URI value = null;
		final String ee_path = VariablesPlugin.getDefault().getStringVariableManager().performStringSubstitution("${"+EEBaseDynamicVariableResolver.DYNVAR_ERIKA_ENTERPRISE_LOCATION+"}");
		assertNotNull(ee_path);
		if (HostOsUtils.common.getCurrentSystem() == OsType.Cygwin || HostOsUtils.common.getCurrentSystem() == OsType.Win) {
			new RtdAssert(URISyntaxException.class) {
				/* (non-Javadoc)
				 * @see com.eu.evidence.rtdruid.tests.RtdAssert#doCheck()
				 */
				@Override
				protected void doCheck() throws Throwable {
					new URI("file:/"+ee_path);
				}
			};
		}
		value = new URI("file:/"+ee_path.replace("\\", "/"));
		assertNotNull(value);
	}
	
	@Test
	public void fileToUriTest() throws CoreException {
		URI value = null;
		String ee_path = VariablesPlugin.getDefault().getStringVariableManager().performStringSubstitution("${"+EEBaseDynamicVariableResolver.DYNVAR_ERIKA_ENTERPRISE_LOCATION+"}");
		assertNotNull(ee_path);
		File f = new File(ee_path);
		value = f.toURI();
		assertNotNull(value);
		System.out.println(value);
		
		
	}

}
