package com.eu.evidence.rtdruid.test.modules.jscan.multiframe;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.eu.evidence.rtdruid.internal.modules.jscan.multiframe.MultiFrameTaskSchedulability;

public class MultiFrameTaskSchedulabilityTest {

	@Test
	public void testIsAccumulativelyMonotonic() {
		
		{
			double[] values = null;
			MultiFrameTaskSchedulability test = new MultiFrameTaskSchedulability();
			assertTrue(test.isAccumulativelyMonotonic(values) == true);
		}
		{
			double[] values = new double[] {};
			MultiFrameTaskSchedulability test = new MultiFrameTaskSchedulability();
			assertTrue(test.isAccumulativelyMonotonic(values) == true);
		}
		{
			double[] values = new double[] {3,2,1};
			MultiFrameTaskSchedulability test = new MultiFrameTaskSchedulability();
			assertTrue(test.isAccumulativelyMonotonic(values) == true);
		}
		{
			double[] values = new double[] {4,1,3,3};
			MultiFrameTaskSchedulability test = new MultiFrameTaskSchedulability();
			assertTrue(test.isAccumulativelyMonotonic(values) == false);
		}
		{
			//4+2+3 < 3+3+4
			double[] values = new double[] {4,2,3,3};
			MultiFrameTaskSchedulability test = new MultiFrameTaskSchedulability();
			assertTrue(test.isAccumulativelyMonotonic(values) == false);
		}
		{
			double[] values = new double[] {4,2,3,2};
			MultiFrameTaskSchedulability test = new MultiFrameTaskSchedulability();
			assertTrue(test.isAccumulativelyMonotonic(values) == true);
		}
		{
			// fail 4+2+1+3+1 < 3+1+2+4+2
			double[] values = new double[] {4,2,1,3,1,2};
			MultiFrameTaskSchedulability test = new MultiFrameTaskSchedulability();
			assertTrue(test.isAccumulativelyMonotonic(values) == false);
		}
		{
			double[] values = new double[] {6,2,2,4,3,2,5,3,2};
			MultiFrameTaskSchedulability test = new MultiFrameTaskSchedulability();
			assertTrue(test.isAccumulativelyMonotonic(values) == false);
		}
		{
			double[] values = new double[] {6,4,2,4,3,2,5,3,2};
			MultiFrameTaskSchedulability test = new MultiFrameTaskSchedulability();
			assertTrue(test.isAccumulativelyMonotonic(values) == false);
		}
		{
			double[] values = new double[] {6,4,2,4,3,2,4,3,2};
			MultiFrameTaskSchedulability test = new MultiFrameTaskSchedulability();
			assertTrue(test.isAccumulativelyMonotonic(values) == true);
		}
		{
			double[] values = new double[] {4,3,2,6,4,2,4,3,2};
			MultiFrameTaskSchedulability test = new MultiFrameTaskSchedulability();
			assertTrue(test.isAccumulativelyMonotonic(values) == true);
		}
		{
			double[] values = new double[] {4,2,4,3,2,4,3,2,6};
			MultiFrameTaskSchedulability test = new MultiFrameTaskSchedulability();
			assertTrue(test.isAccumulativelyMonotonic(values) == true);
		}
		{
			// 6+4 < 5+6 
			double[] values = new double[] {1,2,3,4,5,6,4,3,2};
			MultiFrameTaskSchedulability test = new MultiFrameTaskSchedulability();
			assertTrue(test.isAccumulativelyMonotonic(values) == false);
		}
		{
			double[] values = new double[] {1,2,3,4,5,10,1,2,3,4,5};
			MultiFrameTaskSchedulability test = new MultiFrameTaskSchedulability();
			assertTrue(test.isAccumulativelyMonotonic(values) == false);
		}
		{	// 33 = 12+1+2+3+4+5+1+2+3 < 2+3+4+5+4+3+2+1+12 = 36
			double[] values = new double[] {1,2,3,4,5,4,3,2,1,12,1,2,3,4,5};
			MultiFrameTaskSchedulability test = new MultiFrameTaskSchedulability();
			assertTrue(test.isAccumulativelyMonotonic(values) == false);
		}
		{
			double[] values = new double[] {1,2,3,4,5,4,3,2,1,500,1,2,3,4,5};
			MultiFrameTaskSchedulability test = new MultiFrameTaskSchedulability();
			assertTrue(test.isAccumulativelyMonotonic(values) == false);
		}
		{
			double[] values = new double[] {5,4,3,3,8,4,3,2,1,500,4,2,5,4,5};
			MultiFrameTaskSchedulability test = new MultiFrameTaskSchedulability();
			assertTrue(test.isAccumulativelyMonotonic(values) == true);
		}

	}

}
