/*
 * Created on 18/giu/07
 *
 * $Id: TimeVarTest.java,v 1.1 2007/06/18 13:36:14 durin Exp $
 */
package com.eu.evidence.rtdruid.vartree.variables;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TimeVarTest {
	
	@Test
	public void testRatio() {
		TimeVar a = new TimeVar("1h");
		a.setType(TimeVar.MINUTE);
		assertEquals(60, val(a), 0.0001);
		
		a.set("3600s");
		a.setType(TimeVar.HOUR);
		assertEquals(1, val(a), 0.0001);
		
	}

	@Test
	public void testCompare() {
		TimeVar a = new TimeVar("1h");
		TimeVar b = new TimeVar("3600s");
		TimeVar c = new TimeVar("3599s");
		assertEquals(a.compareTo(a), 0);
		assertEquals(b.compareTo(b), 0);
		assertEquals(c.compareTo(c), 0);
		
		
		assertEquals(a.compareTo(b), 0);
		assertTrue(a.compareTo(c) > 0);
		assertTrue(b.compareTo(c) > 0);

		assertEquals(b.compareTo(a), 0);
		assertTrue(c.compareTo(a) < 0);
		assertTrue(c.compareTo(b) < 0);
	}
	
	protected double val(TimeVar v) {
		return ((Double) v.get()).doubleValue();
	}
}
