/**
 * 17/gen/2012
 */
package com.eu.evidence.rtdruid.epackage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class RTDEPackageBuildExceptionTest {

	@Test
	public void testSimpleConstructor() {
		Throwable e = new RTDEPackageBuildException();
		assertNull(e.getCause());
		assertNull(e.getMessage());
	}

	@Test
	public void testConstructorString() {
		String txt = "abc";
		Throwable e = new RTDEPackageBuildException(txt);
		assertNull(e.getCause());
		assertEquals(txt, e.getMessage());
	}

	@Test
	public void testConstructorThrowable() {
		Throwable main = new RuntimeException();
		Throwable e = new RTDEPackageBuildException(main);
		assertSame(main, e.getCause());
		assertNull(main.getMessage());
		assertNotNull(e.getMessage());
	}

	@Test
	public void testConstructorThrowableString() {
		String txt = "new text";
		Throwable main = new RuntimeException("abc");
		Throwable e = new RTDEPackageBuildException(txt, main);
		assertSame(main, e.getCause());
		assertEquals(txt, e.getMessage());
	}

	@Test
	public void testMessage() {
		Throwable main = new RuntimeException("abc");
		Throwable e = new RTDEPackageBuildException(main);
		assertSame(main, e.getCause());
		assertNotNull(main.getMessage());
		assertNotNull(e.getMessage());
	}

}
