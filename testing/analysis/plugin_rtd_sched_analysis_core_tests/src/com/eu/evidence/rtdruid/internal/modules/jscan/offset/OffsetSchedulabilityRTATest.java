package com.eu.evidence.rtdruid.internal.modules.jscan.offset;

import junit.framework.TestCase;

public class OffsetSchedulabilityRTATest extends TestCase {

	long[][] period = { { 4, 5, 8 }, { 4, 5, 8 }, { 8, 12, 16 }, { 8, 12, 16 } };

	double[][] offset = { { 0, 0, 0 }, { 0, 0, 1.5 }, { 0, 0, 0 }, { 0, 2, 0 } };

	double[][] blocking = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };

	double[][] wcet = { { 1, 2, 2.5 }, { 1, 2, 2.5 }, { 2, 3, 7 }, { 2, 3, 7 } };

	double[][] deadline = { { 4, 5, 8 }, { 4, 5, 8 }, { 8, 12, 16 }, { 8, 12, 16 } };

	double[] zerooffset = { 0, 0, 0 };

	int testcases = 4;
	int numTasks = 3;
	int[] fixedtasks = { 2, 2, 1, 1 };

	boolean[] result = { false, true, false, true };
	boolean[] exactresult = { false, true, false, true };

	public void testCheckTask() {
		int i, k;

		boolean[] IsSchedulable;

		double WorstCaseResponceTime[];
		double CriticalActivation[];
		double WcetSensitivity[];
		OffsetDMSchedulabilityComplete o;
		o = new OffsetDMSchedulabilityComplete();

		IsSchedulable = new boolean[numTasks];
		CriticalActivation = new double[numTasks];
		WorstCaseResponceTime = new double[numTasks];
		WcetSensitivity = new double[numTasks];
		boolean result;
		for (i = 0; i < testcases; i++) {
			o.setTestParameters(period[i], deadline[i], blocking[i], wcet[i], offset[i]);
			o.checkTask(numTasks - 1, IsSchedulable, CriticalActivation, WorstCaseResponceTime, WcetSensitivity);
			result = true;
			for (k = 0; k < numTasks; k++)
				if (IsSchedulable[k] == false) {
					result = false;
					break;
				}

			assertEquals(result, exactresult[i]);
		}
	}

	public void testIsSchedulableWithCurrentOffsets() {

		int i, j;

		OffsetSchedulabilityRTA e;

		for (i = 0; i < testcases; i++) {
			e = new OffsetSchedulabilityRTA();
			e.setTotalFixedTask(fixedtasks[i]);
			e.initTest(period[i], deadline[i], blocking[i], wcet[i], offset[i]);
			assertEquals(result[i], e.isTaskSetSchedulable());
		}

		boolean currentresult1, currentresult2;

		for (i = 0; i < testcases; i++) {
			e = new OffsetSchedulabilityRTA();

			e.setTotalFixedTask(fixedtasks[i]);
			e.initTest(period[i], deadline[i], blocking[i], wcet[i], zerooffset);
			currentresult1 = e.isTaskSetSchedulable();

			e.initTest(period[i], deadline[i], blocking[i], wcet[i], offset[i]);
			currentresult2 = e.isTaskSetSchedulable();

			if (currentresult1)
				assertTrue(currentresult2);
		}

		for (i = 0; i < testcases; i++) {
			currentresult2 = false;
			for (j = 1; j < numTasks; j++) {
				e = new OffsetSchedulabilityRTA();
				e.setTotalFixedTask(j);
				e.initTest(period[i], deadline[i], blocking[i], wcet[i], zerooffset);
				currentresult1 = e.isTaskSetSchedulable();

				if (currentresult2)
					assertTrue(currentresult1);

				currentresult2 |= currentresult1;
			}
		}
	}

	/** @deprecated */
	public void testIsSchedulableWithCurrentOffsetsnew() {

		long[][] period = { { 4, 5, 8 }, { 4, 5, 8 }, { 8, 12, 16 }, { 8, 12, 16 } };

		double[][] offset = { { 0, 0, 0 }, { 0, 0, 1.5 }, { 0, 0, 0 }, { 0, 2, 0 } };

		double[][] blocking = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };

		double[][] wcet = { { 1, 2, 2.5 }, { 1, 2, 2.5 }, { 2, 3, 7 }, { 2, 3, 7 } };

		double[][] deadline = { { 4, 5, 8 }, { 4, 5, 8 }, { 8, 12, 16 }, { 8, 12, 16 } };

		double[] zerooffset = { 0, 0, 0 };

		int testcases = 4;
		int numTasks = 3;
		int[] fixedtasks = { 2, 2, 1, 1 };

		boolean[] result = { false, true, false, true };
		// boolean[] exactresult = {false,true,false,true} ;

		int i, j;

		OffsetSchedulabilityRTA e;

		for (i = 0; i < testcases; i++) {
			e = new OffsetSchedulabilityRTA();
			e.setTotalFixedTask(fixedtasks[i]);
			e.initTest(period[i], deadline[i], blocking[i], wcet[i], offset[i]);
			assertEquals(result[i], e.isTaskSetSchedulable());
		}

		boolean currentresult1, currentresult2;

		for (i = 0; i < testcases; i++) {
			e = new OffsetSchedulabilityRTA();

			e.setTotalFixedTask(fixedtasks[i]);
			e.initTest(period[i], deadline[i], blocking[i], wcet[i], zerooffset);
			currentresult1 = e.isTaskSetSchedulablenew();

			e.initTest(period[i], deadline[i], blocking[i], wcet[i], offset[i]);
			currentresult2 = e.isTaskSetSchedulablenew();

			if (currentresult1)
				assertTrue(currentresult2);
		}

		for (i = 0; i < testcases; i++) {
			currentresult2 = false;
			for (j = 1; j < numTasks; j++) {
				e = new OffsetSchedulabilityRTA();
				e.setTotalFixedTask(j);
				e.initTest(period[i], deadline[i], blocking[i], wcet[i], zerooffset);
				currentresult1 = e.isTaskSetSchedulablenew();

				if (currentresult2)
					assertTrue(currentresult1);

				currentresult2 |= currentresult1;
			}
		}
	}

	public void testResponceTimeofTaskwithOffsets() {

		// int numTasks = 3 ;

		long[][] period = { { 5, 10, 13 }, { 5, 10, 13 }, { 2, 50, 100 } };

		double[][] offset = { { 0, 2, 1 }, { 2, 6, 12 }, { 0, 0, 3 } };

		double[][] deadline = { { 4, 8, 7 }, { 4, 8, 7 }, { 2, 50, 100 } };

		double[][] blocking = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };

		double[][] wcet = { { 2, 3, 2 }, { 2, 3, 2 }, { 1.599, 10, 5 } };

		int testcases = 3;

		int[] task = { 2, 2, 1 };
		double[] result = { 8, 4, 49.975 };

		int i;
		OffsetSchedulabilityRTA e = new OffsetSchedulabilityRTA();

		for (i = 0; i < testcases; i++) {
			e.initTest(period[i], deadline[i], blocking[i], wcet[i], offset[i]);
			e.setRunTimeTestOffset(offset[i]);

			System.out.println("\nResponse Time" + i + "\t" + e.responceTimeofTaskwithOffsets(0, task[i]));

			assertEquals(result[i], e.responceTimeofTaskwithOffsets(0, task[i]), 0.001);
		}
	}

	/** @deprecated */
	public void testComparisionBetweensnewAndOldFunction() {

		long[][] period = { { 4, 5, 8 }, { 4, 5, 8 }, { 8, 12, 16 }, { 8, 12, 16 }, { 7, 11, 15, 35, 71, 101, 202 } };

		double[][] offset = { { 0, 0, 0 }, { 0, 0, 1.5 }, { 0, 0, 0 }, { 0, 2, 0 }, { 1, 4, 6, 3, 10, 10, 1 } };

		double[][] blocking = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 } };

		double[][] wcet = { { 1, 2, 2.5 }, { 1, 2, 2.5 }, { 2, 3, 7 }, { 3, 0001, 0.0001 }, { 1, 2, 1, 5, 7, 10, 2 } };

		double[][] deadline = { { 4, 5, 8 }, { 4, 5, 8 }, { 8, 12, 16 }, { 8, 12, 16 }, { 5, 10, 15, 35, 70, 100, 200 } };

		double rs1[], rs2[];
		rs1 = new double[10];
		rs2 = new double[10];

		int testcases = 5;

		int[] fixedtasks = { 2, 2, 1, 1, 3 };

		int i, j;
		long complexityold, complexitynew;
		OffsetSchedulabilityRTA e;

		for (i = 0; i < testcases; i++) {

			e = new OffsetSchedulabilityRTA();
			e.setTotalFixedTask(fixedtasks[i]);
			e.initTest(period[i], deadline[i], blocking[i], wcet[i], offset[i]);

			System.out.println(System.currentTimeMillis());
			complexitynew = System.currentTimeMillis();
			e.isTaskSetSchedulablenew();
			e.getResult(rs2);
			complexitynew = System.currentTimeMillis() - complexitynew;

			System.out.println(System.currentTimeMillis());
			complexityold = System.currentTimeMillis();
			e.isTaskSetSchedulable();
			e.getResult(rs1);
			complexityold = System.currentTimeMillis() - complexityold;

			System.out.println(System.currentTimeMillis());

			System.out.println("\nTest : " + i + "\tcomplexityold = " + complexityold + "\tcomplexitynew = "
					+ complexitynew + "\n");

			int numtasks = period[i].length;

			for (j = 0; j < numtasks; j++) {
				System.out.println(rs1[j] + "\t\t" + rs2[j]);
				assertEquals(rs1[j], rs2[j], 0.000001);
			}

		}

	}

}
