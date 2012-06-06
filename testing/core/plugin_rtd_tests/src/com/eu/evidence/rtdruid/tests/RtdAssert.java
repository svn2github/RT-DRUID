/**
 * 17/gen/2012
 */
package com.eu.evidence.rtdruid.tests;

import static org.junit.Assert.fail;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Nicola Serreli
 * @since 2.0
 * 
 */
public class RtdAssert {

	protected Set<Class<?>> exceptions;

	/**
	 * This constructor check the doCheck method against assertionError. If
	 * doCheck does not throw this exception, the constructor fails.
	 */
	public RtdAssert() {
		this(AssertionError.class);
	}

	/**
	 * This constructor check the doCheck method against assertionError. If
	 * doCheck does not throw this exception, the constructor fails reporting
	 * the provided message.
	 */
	public RtdAssert(String message) {
		this(message, AssertionError.class);
	}

	/**
	 * This constructor check the doCheck method against the list of exception
	 * types. If doCheck does not throw one of these exceptions, the constructor
	 * fails.
	 */
	public RtdAssert(Class<?>... exceptions) {
		this(null, exceptions);
	}

	/**
	 * This constructor check the doCheck method against the list of exception
	 * types. If doCheck does not throw one of these exceptions, the constructor
	 * fails reporting the provided message.
	 */
	public RtdAssert(String message, Class<?>... exceptions) {
		this.exceptions = new HashSet<Class<?>>();
		for (Class<?> t : exceptions) {
			this.exceptions.add(t);
		}
	
		String currException = "\n No exception";
		try {
			doCheck();
		} catch (Throwable e) {
			for (Class<?> t : exceptions) {
				if (t.isAssignableFrom(e.getClass())) {
					return;
				}
			}
			currException = "\nReal exception is " + e.getClass().getName() + ":\n"+e.getMessage();
		}
		fail(message + currException);
	}

	/**
	 * This method is checked against
	 */
	protected void doCheck() throws Throwable {
		// by default, do nothing
	}

	/**
	 * Asserts that an integer is greater than another. If it isn't it throws an
	 * AssertionFailedError with the given message.
	 */
	static public void assertGreater(String message, int small, int bigger) {
		if (small >= bigger) {
			String formatted = "";
			if (message != null)
				formatted = message + " ";
			fail(formatted + "expected greater:<" + small + "> was not smaller than <" + bigger + ">");
		}
	}

	/**
	 * Asserts that an integer is greater than another. If it isn't it throws an
	 * AssertionFailedError.
	 */
	static public void assertGreater(int small, int bigger) {
		assertGreater(null, small, bigger);
	}

	/**
	 * Not function
	 * 
	 * @return the false if value was true, and viceversa.
	 */
	static public boolean not(boolean value) {
		return !value;
	}
}
