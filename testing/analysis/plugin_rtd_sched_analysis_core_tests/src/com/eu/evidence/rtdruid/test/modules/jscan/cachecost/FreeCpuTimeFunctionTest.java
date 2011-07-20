package com.eu.evidence.rtdruid.test.modules.jscan.cachecost;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.eu.evidence.rtdruid.internal.modules.jscan.cachecost.FreeCpuTimeFunction;
import com.eu.evidence.rtdruid.internal.modules.jscan.cachecost.IFreeCpuTimeFunction;

public class FreeCpuTimeFunctionTest {

	@Test
	public void testPeriod() {
		
		{
			OpenFreeCpuTimeFunction open = new OpenFreeCpuTimeFunction();
			assertTrue(open.openGetPeriod() == Double.POSITIVE_INFINITY);
		}
		
		{
			OpenFreeCpuTimeFunction open = new OpenFreeCpuTimeFunction(5);
			assertTrue(open.openGetPeriod() == 5);
		}
		
		{
			OpenFreeCpuTimeFunction open = new OpenFreeCpuTimeFunction(Double.POSITIVE_INFINITY);
			assertTrue(open.openGetPeriod() == Double.POSITIVE_INFINITY);
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
		assertTrue(open.openGetPeriod() == Double.POSITIVE_INFINITY);
		
		{
			double[] free = open.openGetFrees();
			double[] real = open.openGetReals();
			
			assertTrue(free.length == 1);
			assertTrue(real.length == 1);
			
			assertTrue(free[0] == 0);
			assertTrue(real[0] == 0);
		}
		
		open.addAPoint(2, 2);
		assertTrue(open.openGetPeriod() == Double.POSITIVE_INFINITY);
		{
			double[] free = open.openGetFrees();
			double[] real = open.openGetReals();
			
			assertTrue(free.length == 2);
			assertTrue(real.length == 2);
			
			assertTrue(free[0] == 0);
			assertTrue(free[1] == 2);
			
			assertTrue(real[0] == 0);
			assertTrue(free[1] == 2);
		}

		open.addAPoint(4, 10);
		{
			double[] free = open.openGetFrees();
			double[] real = open.openGetReals();
			
			assertTrue(free.length == 3);
			assertTrue(real.length == 3);
			
			assertTrue(free[0] == 0);
			assertTrue(free[1] == 2);
			assertTrue(free[2] == 4);
			
			assertTrue(real[0] == 0);
			assertTrue(real[1] == 2);
			assertTrue(real[2] == 10);
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
		assertTrue(func.getRealTime(5) == 5);
		
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
		assertTrue(func.getRealTime(2) == 2);
		assertTrue(func.getRealTime(3) == 5);
		assertTrue(func.getRealTime(5) == 7);
	}
	
	@Test
	public void testGetRealTimeFin() {
		
		FreeCpuTimeFunction func = new FreeCpuTimeFunction(10);
		assertTrue(func.getRealTime(5) == 5);
		assertTrue(func.getRealTime(12) == 12);
		assertTrue(func.getRealTime(20) == 20);
		assertTrue(func.getRealTime(22) == 22);
		
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
		assertTrue(func.getRealTime(2) == 2);
		assertTrue(func.getRealTime(3) == 5);
		assertTrue(func.getRealTime(5) == 7);
		
		// every period, only 8 free cpu time
		assertTrue(func.getRealTime(10) == 12); // 8+2
		assertTrue(func.getRealTime(12) == 16); // 8+4
		assertTrue(func.getRealTime(13) == 17);
		
		assertTrue(func.getRealTime(18) == 22); // 8x2 + 2
		assertTrue(func.getRealTime(20) == 26); // 8x2 +4
		assertTrue(func.getRealTime(22) == 28);
		assertTrue(func.getRealTime(23) == 29);
		
		assertTrue(func.getRealTime(28) == 36); // 8x3+4

		
	}
	
	@Test
	public void testGetPreemptionInf() {
		
		FreeCpuTimeFunction func = new FreeCpuTimeFunction();
		assertTrue(func.getPreemptions(0) == 1);
		assertTrue(func.getPreemptions(5) == 1);
		
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
		assertTrue(func.getPreemptions(2) == 1);
		assertTrue(func.getPreemptions(3) == 2);
		assertTrue(func.getPreemptions(5) == 2);
		assertTrue(func.getPreemptions(1000) == 2);
	}
	
	@Test
	public void testGetPreemptionFin() {
		
		FreeCpuTimeFunction func = new FreeCpuTimeFunction(10);
		assertTrue(func.getPreemptions(0) == 1);
		assertTrue(func.getPreemptions(5) == 1);
		assertTrue(func.getPreemptions(8) == 1);
		assertTrue(func.getPreemptions(10) == 2);
		assertTrue(func.getPreemptions(12) == 2);
		assertTrue(func.getPreemptions(20) == 3);
		
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
		assertTrue(func.getPreemptions(0) == 1);
		assertTrue(func.getPreemptions(2) == 1);
		assertTrue(func.getPreemptions(3) == 2);
		assertTrue(func.getPreemptions(5) == 2);

		assertTrue(func.getPreemptions(8) == 3);
		assertTrue(func.getPreemptions(10) == 3);
		assertTrue(func.getPreemptions(11) == 4);
		assertTrue(func.getPreemptions(12) == 4);

		assertTrue(func.getPreemptions(18) == 5);
		assertTrue(func.getPreemptions(20) == 6);
		
		
	}

}
