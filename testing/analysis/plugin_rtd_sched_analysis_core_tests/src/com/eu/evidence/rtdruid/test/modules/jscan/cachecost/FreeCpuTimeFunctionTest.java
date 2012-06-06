package com.eu.evidence.rtdruid.test.modules.jscan.cachecost;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.eu.evidence.rtdruid.internal.modules.jscan.cachecost.FreeCpuTimeFunction;
import com.eu.evidence.rtdruid.internal.modules.jscan.cachecost.IFreeCpuTimeFunction;

public class FreeCpuTimeFunctionTest {
	
	private static final double DELTA = 0.00001;

	@Test
	public void testPeriod() {
		
		{
			OpenFreeCpuTimeFunction open = new OpenFreeCpuTimeFunction();
			assertEquals(open.openGetPeriod() , Double.POSITIVE_INFINITY, DELTA);
		}
		
		{
			OpenFreeCpuTimeFunction open = new OpenFreeCpuTimeFunction(5);
			assertEquals(open.openGetPeriod() , 5, DELTA);
		}
		
		{
			OpenFreeCpuTimeFunction open = new OpenFreeCpuTimeFunction(Double.POSITIVE_INFINITY);
			assertEquals(open.openGetPeriod() , Double.POSITIVE_INFINITY, DELTA);
		}
		
		{
			boolean ok = false;
			try {
				new FreeCpuTimeFunction(0);
			} catch (IllegalArgumentException e) {
				ok = true;
			}
			assertTrue(ok);
		}
		
		{
			boolean ok = false;
			try {
				new FreeCpuTimeFunction(-5);
			} catch (IllegalArgumentException e) {
				ok = true;
			}
			assertTrue(ok);
		}

	}

	@Test
	public void testAddAPoint() {
		
		OpenFreeCpuTimeFunction open = new OpenFreeCpuTimeFunction();
		assertEquals(open.openGetPeriod() , Double.POSITIVE_INFINITY, DELTA);
		
		{
			double[] free = open.openGetFrees();
			double[] real = open.openGetReals();
			
			assertEquals(free.length , 1);
			assertEquals(real.length , 1);
			
			assertEquals(free[0] , 0, DELTA);
			assertEquals(real[0] , 0, DELTA);
		}
		
		open.addAPoint(2, 2);
		assertEquals(open.openGetPeriod() , Double.POSITIVE_INFINITY, DELTA);
		{
			double[] free = open.openGetFrees();
			double[] real = open.openGetReals();
			
			assertEquals(free.length , 2);
			assertEquals(real.length , 2);
			
			assertEquals(free[0] , 0, DELTA);
			assertEquals(free[1] , 2, DELTA);
			
			assertEquals(real[0] , 0, DELTA);
			assertEquals(free[1] , 2, DELTA);
		}

		open.addAPoint(4, 10);
		{
			double[] free = open.openGetFrees();
			double[] real = open.openGetReals();
			
			assertEquals(free.length , 3);
			assertEquals(real.length , 3);
			
			assertEquals(free[0] , 0, DELTA);
			assertEquals(free[1] , 2, DELTA);
			assertEquals(free[2] , 4, DELTA);
			
			assertEquals(real[0] , 0, DELTA);
			assertEquals(real[1] , 2, DELTA);
			assertEquals(real[2] , 10, DELTA);
		}
		
		// checks
		{
			boolean ok = false;
			try {
				open.addAPoint(2, 2);
			} catch (IllegalArgumentException e) {
				ok = true;
			}
			assertTrue(ok);
		}
		{
			boolean ok = false;
			try {
				open.addAPoint(-1, 2);
			} catch (IllegalArgumentException e) {
				ok = true;
			}
			assertTrue(ok);
		}
		{
			boolean ok = false;
			FreeCpuTimeFunction tmp = new FreeCpuTimeFunction();
			try {
				tmp.addAPoint(-1, 2);
			} catch (IllegalArgumentException e) {
				ok = true;
			}
			assertTrue(ok);
		}
		{
			boolean ok = false;
			FreeCpuTimeFunction tmp = new FreeCpuTimeFunction();
			try {
				tmp.addAPoint(4, -1);
			} catch (IllegalArgumentException e) {
				ok = true;
			}
			assertTrue(ok);
		}
		{
			boolean ok = false;
			FreeCpuTimeFunction tmp = new FreeCpuTimeFunction();
			try {
				tmp.addAPoint(4, 3);
			} catch (IllegalArgumentException e) {
				ok = true;
			}
			assertTrue(ok);
		}
		
		{
			boolean ok = false;
			FreeCpuTimeFunction tmp = new FreeCpuTimeFunction();
			tmp.addAPoint(2, 4);
			try {
				tmp.addAPoint(4, 5);
			} catch (IllegalArgumentException e) {
				ok = true;
			}
			assertTrue(ok);
		}
	}

	@Test
	public void testGetRealTimeInf() {
		
		FreeCpuTimeFunction func = new FreeCpuTimeFunction();
		assertEquals(func.getRealTime(5) , 5, DELTA);
		
		{
			boolean ok = false;
			IFreeCpuTimeFunction tmp = new FreeCpuTimeFunction();
			try {
				tmp.getRealTime(-1);
			} catch (IllegalArgumentException e) {
				ok = true;
			}
			assertTrue(ok);
		}
		
		func.addAPoint(3,5);
		assertEquals(func.getRealTime(2) , 2, DELTA);
		assertEquals(func.getRealTime(3) , 5, DELTA);
		assertEquals(func.getRealTime(5) , 7, DELTA);
	}
	
	@Test
	public void testGetRealTimeFin() {
		
		FreeCpuTimeFunction func = new FreeCpuTimeFunction(10);
		assertEquals(func.getRealTime(5) , 5, DELTA);
		assertEquals(func.getRealTime(12) , 12, DELTA);
		assertEquals(func.getRealTime(20) , 20, DELTA);
		assertEquals(func.getRealTime(22) , 22, DELTA);
		
		{
			boolean ok = false;
			IFreeCpuTimeFunction tmp = new FreeCpuTimeFunction();
			try {
				tmp.getRealTime(-1);
			} catch (IllegalArgumentException e) {
				ok = true;
			}
			assertTrue(ok);
		}
		
		func.addAPoint(3,5);
		assertEquals(func.getRealTime(2) , 2, DELTA);
		assertEquals(func.getRealTime(3) , 5, DELTA);
		assertEquals(func.getRealTime(5) , 7, DELTA);
		
		// every period, only 8 free cpu time
		assertEquals(func.getRealTime(10) , 12, DELTA); // 8+2
		assertEquals(func.getRealTime(12) , 16, DELTA); // 8+4
		assertEquals(func.getRealTime(13) , 17, DELTA);
		
		assertEquals(func.getRealTime(18) , 22, DELTA); // 8x2 + 2
		assertEquals(func.getRealTime(20) , 26, DELTA); // 8x2 +4
		assertEquals(func.getRealTime(22) , 28, DELTA);
		assertEquals(func.getRealTime(23) , 29, DELTA);
		
		assertEquals(func.getRealTime(28) , 36, DELTA); // 8x3+4

		
	}
	
	@Test
	public void testGetPreemptionInf() {
		
		FreeCpuTimeFunction func = new FreeCpuTimeFunction();
		assertEquals(func.getPreemptions(0) , 1);
		assertEquals(func.getPreemptions(5) , 1);
		
		{
			boolean ok = false;
			IFreeCpuTimeFunction tmp = new FreeCpuTimeFunction();
			try {
				tmp.getPreemptions(-1);
			} catch (IllegalArgumentException e) {
				ok = true;
			}
			assertTrue(ok);
		}
		
		func.addAPoint(3,5);
		assertEquals(func.getPreemptions(2) , 1);
		assertEquals(func.getPreemptions(3) , 2);
		assertEquals(func.getPreemptions(5) , 2);
		assertEquals(func.getPreemptions(1000) , 2);
	}
	
	@Test
	public void testGetPreemptionFin() {
		
		FreeCpuTimeFunction func = new FreeCpuTimeFunction(10);
		assertEquals(func.getPreemptions(0) , 1);
		assertEquals(func.getPreemptions(5) , 1);
		assertEquals(func.getPreemptions(8) , 1);
		assertEquals(func.getPreemptions(10) , 2);
		assertEquals(func.getPreemptions(12) , 2);
		assertEquals(func.getPreemptions(20) , 3);
		
		{
			boolean ok = false;
			IFreeCpuTimeFunction tmp = new FreeCpuTimeFunction();
			try {
				tmp.getPreemptions(-1);
			} catch (IllegalArgumentException e) {
				ok = true;
			}
			assertTrue(ok);
		}
		
		// every period, only 8 free cpu time
		func.addAPoint(3,5);
		assertEquals(func.getPreemptions(0) , 1);
		assertEquals(func.getPreemptions(2) , 1);
		assertEquals(func.getPreemptions(3) , 2);
		assertEquals(func.getPreemptions(5) , 2);

		assertEquals(func.getPreemptions(8) , 3);
		assertEquals(func.getPreemptions(10) , 3);
		assertEquals(func.getPreemptions(11) , 4);
		assertEquals(func.getPreemptions(12) , 4);

		assertEquals(func.getPreemptions(18) , 5);
		assertEquals(func.getPreemptions(20) , 6);
		
		
	}

}
