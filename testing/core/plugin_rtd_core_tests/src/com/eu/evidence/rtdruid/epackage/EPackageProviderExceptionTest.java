/**
 * 17/gen/2012
 */
package com.eu.evidence.rtdruid.epackage;

import static org.junit.Assert.*;

import org.junit.Test;

import com.eu.evidence.rtdruid.epackage.EPackageFactory.EPackageProviderException;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class EPackageProviderExceptionTest {

	@Test
	public void testConstructor() {
		Throwable main = new RuntimeException();
		Throwable e = new EPackageProviderException(main);
		assertSame(main, e.getCause());
		assertNull(main.getMessage());
		assertNotNull(e.getMessage());
	}

	@Test
	public void testMessage() {
		Throwable main = new RuntimeException("abc");
		Throwable e = new EPackageProviderException(main);
		assertSame(main, e.getCause());
		assertNotNull(main.getMessage());
		assertNotNull(e.getMessage());
	}

}
