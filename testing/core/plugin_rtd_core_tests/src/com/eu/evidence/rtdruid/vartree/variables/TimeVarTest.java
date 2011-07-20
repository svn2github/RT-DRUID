/*
 * Created on 18/giu/07
 *
 * $Id: TimeVarTest.java,v 1.1 2007/06/18 13:36:14 durin Exp $
 */
package com.eu.evidence.rtdruid.vartree.variables;

import junit.framework.TestCase;

public class TimeVarTest extends TestCase {
	
	public void testRatio() {
		TimeVar a = new TimeVar("1h");
		a.setType(TimeVar.MINUTE);
		System.err.println(val(a));
		assertTrue(60 == val(a));
		
		a.set("3600s");
		a.setType(TimeVar.HOUR);
		System.err.println(val(a));
		assertTrue(1 == val(a));
		
	}

	public void testCompare() {
		TimeVar a = new TimeVar("1h");
		TimeVar b = new TimeVar("3600s");
		TimeVar c = new TimeVar("3599s");
		assertTrue(a.compareTo(a) == 0);
		assertTrue(b.compareTo(b) == 0);
		assertTrue(c.compareTo(c) == 0);
		
		
		assertTrue(a.compareTo(b) == 0);
		assertTrue(a.compareTo(c) > 0);
		assertTrue(b.compareTo(c) > 0);

		assertTrue(b.compareTo(a) == 0);
		assertTrue(c.compareTo(a) < 0);
		assertTrue(c.compareTo(b) < 0);
	}

	
	public void testShift() {
		for (int i=0; i<70; i++) {
			long timerSize =  1l<<i;
			System.err.println("i=" + i +"\t" +  timerSize);
		}
	}
	
	
	protected double val(TimeVar v) {
		return ((Double) v.get()).doubleValue();
	}
}
