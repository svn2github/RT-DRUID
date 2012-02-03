/*
 * Created on Jul 19, 2004
 *
 * $Id: PeriodSensitivityTest.java,v 1.1 2005/09/28 15:22:29 durin Exp $
 */
package com.eu.evidence.rtdruid.test.modules.jscan.common;

import junit.framework.TestCase;

import com.eu.evidence.rtdruid.internal.modules.jscan.common.PeriodSensitivity;

/**
 * @author sachin
 * 
 */

public class PeriodSensitivityTest extends TestCase {

	PeriodSensitivity myP;

	int numTasks = 4;
	int testCases = 4;

	double[][] period = { { 5, 3, 8, 10 }, { 5, 7, 6, 9 }, { 4, 8, 16, 12 }, { 6, 9, 8, 12 }, { 3, 7, 20, 8 },
			{ 120, 40, 55, 29 }, { 24, 45, 23, 17 }, { 40, 21, 23, 9 }, { 1305, 45023, 452234, 11221 },
			{ 1000, 1000, 1000, 1000 }, { 2, 3, 4, 5 }, { 1, 1, 1, 1 } };

	double[][] blocking = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
			{ 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };

	double[][] wcet = { { 1, 1, 2, 1 }, { 1, 1, 2, 1 }, { 1, 2, 3, 2 }, { 1, 2, 1, 1 }, { 2, 1, 4, 1 },
			{ 10, 9, 14, 5 }, { 12, 10, 5, 3 }, { 8, 10, 12, 12 }, { 1000, 1000, 1000, 1000 }, { 200, 310, 102, 452 },
			{ 1, 1, 1, 1 }, { 1, 1, 1, 1 } };

	double precision = 0.001;

	/***
	 * Priority assignement. In following array the task at array index 0 has
	 * highest priority, at array index 1 has second highest priority
	 */

	/*
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();

		myP = new PeriodSensitivity();
		myP.setPrecision(precision);
	}

	public void testGetTaskSensivityIndividualTaskSchedulableFP() {
		int i, j;
		double sensitivity;
		for (i = 0; i < testCases; i++) {
			for (j = 0; j < numTasks; j++) {

				myP.setTestParameters(period[i], blocking[i], wcet[i]);
				sensitivity = myP.getTaskSensivityIndividualTaskSchedulableFP(j);

				if (sensitivity > 0) {
					myP.setTestPeriod(j, sensitivity);
					assertEquals(true, myP.isFPSchedulable(j));

					/*********
					 * We are adding two time precision its needed when we get
					 * EDF bound as schedulable point
					 ****/

					myP.setTestPeriod(j, 1 / (1 / sensitivity + 1 / precision));
					myP.assignExistingPriorities();
					assertFalse(myP.isFPSchedulable(j));
				} else {
					assertFalse(myP.isFPSchedulable(j));
				}
			}
		}
	}

	public void testGetTaskSensivityAllTaskSchedulableFP() {
		int i, j;
		double sensitivity;
		for (i = 0; i < testCases; i++) {

			for (j = 0; j < numTasks; j++) {

				myP.setTestParameters(period[i], blocking[i], wcet[i]);
				sensitivity = myP.getTaskSensivityAllTaskSchedulableFP(j);

				if (sensitivity > 0) {
					myP.setTestPeriod(j, sensitivity);
					assertEquals(true, myP.isFPSchedulable());

					myP.setTestPeriod(j, 1 / (1 / sensitivity + 1 / precision));
					myP.assignExistingPriorities();
					assertFalse(myP.isFPSchedulable());
				} else {
					assertFalse(myP.isFPSchedulable(j));
				}
			}
		}

	}

	public void testGetTaskSensivityAllTaskSchedulableRM() {
		int i, j;
		double sensitivity;
		for (i = 0; i < testCases; i++) {
			for (j = 0; j < numTasks; j++) {

				myP.setTestParameters(period[i], blocking[i], wcet[i]);
				sensitivity = myP.getTaskSensivityAllTaskSchedulableRM(j);

				if (sensitivity > 0) {
					myP.setTestParameters(period[i], blocking[i], wcet[i]);
					myP.setTestPeriod(j, sensitivity);
					myP.assignDMPriorities();
					assertEquals(true, myP.isFPSchedulable());

					myP.setTestParameters(period[i], blocking[i], wcet[i]);
					myP.setTestPeriod(j, 1 / (1 / sensitivity + 1 / precision + 1 / precision));
					myP.assignDMPriorities();
					assertFalse(myP.isFPSchedulable());
				} else {
					myP.setTestParameters(period[i], blocking[i], wcet[i]);
					// k = myP.sortperiods(j);

					myP.assignDMPriorities();
					assertFalse(myP.isFPSchedulable());
				}
			}
		}
	}

	public void testGetEDFBoundForPeriod() {

		double period[] = { 4, 5, 10, 20 };
		double wcet[] = { 1, 1, 2, 3 };
		double expected[] = { 0.45, 0.4, 0.2, 0.116667 };
		int i;

		myP.setTestParameters(period, blocking[0], wcet);
		for (i = 0; i < 4; i++)
			assertEquals(expected[i], myP.getEDFBoundForPeriodWithAllSchedulable(i), 0.01);
	}

	public void testGetHyperBoundForPeriod() {
	}
}
