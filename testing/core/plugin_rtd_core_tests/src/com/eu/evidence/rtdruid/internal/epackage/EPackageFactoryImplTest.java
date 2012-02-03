/**
 * 20/gen/2012
 */
package com.eu.evidence.rtdruid.internal.epackage;

import static org.junit.Assert.assertArrayEquals;

import java.util.LinkedList;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.junit.Test;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class EPackageFactoryImplTest extends com.eu.evidence.rtdruid.internal.epackage.EPackageFactoryImpl {

	
	/**
	 * Test method for {@link com.eu.evidence.rtdruid.internal.epackage.EPackageFactoryImpl#autoId(org.eclipse.core.runtime.IConfigurationElement)}.
	 */
	@Test
	public void testAutoId() {
		String[] id1 = computeId();	
		String[] id2 = computeId();
		
		assertArrayEquals(id1, id2);
	}
	
	private String[] computeId() {
		LinkedList<String> answer = new LinkedList<String>();

		IExtensionRegistry registry = Platform.getExtensionRegistry();
		for (IConfigurationElement element : registry.getConfigurationElementsFor(EPackageFactoryImpl.PLUGIN_ID, EXTENSION_POINT)) {
			answer.add( EPackageFactoryImpl.autoId(element));
		}
		
		return (String[]) answer.toArray(new String[answer.size()]);
	}

}
