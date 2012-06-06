/*
 * Created on Jul 12, 2004
 *
 * $Id: CompleteTest3.java,v 1.3 2008/03/26 18:23:51 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.jscan;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Properties;

import org.junit.Test;

import com.eu.evidence.rtdruid.internal.modules.jscan.common.RTASchedulability;
import com.eu.evidence.rtdruid.internal.modules.jscan.offset.OffSetSchedulability;
import com.eu.evidence.rtdruid.internal.modules.jscan.offset.OffsetDMSchedulabilityComplete;
import com.eu.evidence.rtdruid.internal.modules.jscan.offset.OffsetSchedulabilityRTA;
import com.eu.evidence.rtdruid.vartree.VarTreeUtil;
import com.eu.evidence.rtdruid.vartree.abstractions.old.Cpu;
import com.eu.evidence.rtdruid.vartree.abstractions.old.GenRes;
import com.eu.evidence.rtdruid.vartree.abstractions.old.GenResList;
import com.eu.evidence.rtdruid.vartree.abstractions.old.Task;
import com.eu.evidence.rtdruid.vartree.abstractions.old.TaskSet;


/**
 * @author Nicola Serreli
 */
public class CompleteTest3 extends AbstractCompleteTest {

	private class MyTaskSet extends TaskSet {
		private class MyTask extends GenRes {

			public MyTask(GenResList parent, String name, String prefix) {
				super(parent, name, prefix);
			}

			public void set(int priority, double wcet, double period,
					double deadline, double offset, double blocking) {
				set(priority, wcet, period, deadline, offset, blocking, "periodic");
			}
			public void set(int priority, double wcet, double period,
						double deadline, double offset, double blocking, String type) {
				prop.put("wcet", new Double(wcet));
				prop.put("period", new Double(period));
				prop.put("deadline", new Double(deadline));
				prop.put("offset", new Double(offset));
				prop.put("blocking", new Double(blocking));

				prop.put("priority", new Integer(priority));

				// required by all tests
				prop.put(Task.STR_ACT_TYPE, type);
			}
			
			public void setProperty(String p, String v) {
				if ("blocking".equalsIgnoreCase(p)) {
					return;
				}
				super.setProperty(p, v);
			}
		}

		@SuppressWarnings("unchecked")
		public MyTaskSet(double[] wcet, double[] period, double[] deadline,
				double[] offset, double[] blocking, String[][] properties) {
			super(VarTreeUtil.newVarTree(), "", "");

			prefissi = new String[] { "not mapped", "cpu0" };
			elenco = new ArrayList[] { new ArrayList<GenRes>(), new ArrayList<GenRes>() };
			elenco_cpu = new GenRes[] {null, new Cpu(this, prefissi[1], "") };

			parametri = new Properties();
			for (int i = 0; i < properties.length; i++) {
				parametri.setProperty(properties[i][0].toLowerCase(), "");
			}

			for (int i = 0; i < wcet.length; i++) {
				MyTask task = new MyTask(this, "Task" + i, "mySystem");
				task.set((wcet.length - i), wcet[i], period[i], deadline[i],
						offset[i], blocking[i]);

				elenco[1].add(task);
			}
		}
		@SuppressWarnings("unchecked")
		public MyTaskSet(double[] wcet, double[] period, double[] deadline,
				double[] offset, double[] blocking, String[] type, String[][] properties) {
			super(VarTreeUtil.newVarTree(), "", "");

			prefissi = new String[] { "not mapped", "cpu0" };
			elenco = new ArrayList[] { new ArrayList<GenRes>(), new ArrayList<GenRes>() };
			elenco_cpu = new GenRes[] {null, new Cpu(this, prefissi[1], "") };

			parametri = new Properties();
			for (int i = 0; i < properties.length; i++) {
				parametri.setProperty(properties[i][0].toLowerCase(), "");
			}

			for (int i = 0; i < wcet.length; i++) {
				MyTask task = new MyTask(this, "Task" + i, "mySystem");
				task.set((wcet.length - i), wcet[i], period[i], deadline[i],
						offset[i], blocking[i], type[i]);

				elenco[1].add(task);
			}
		}
	}

	@Test
	public void testWithoutBlocking() {
		
		GenResList resources = new GenResList(VarTreeUtil.newVarTree(), new String[] {""}, "Resources");
		double[][] period = {
				{ 8, 12, 16 },
				{ 8, 12, 16 },
				{ 4, 6, 10 },
				{ 4, 6, 10 },
				{ 4, 5, 8 },
				{ 4, 5, 8 },
				{ 10000, 10000*60, 10000*60*60 },
		};

		double[][] offset = {
				{ 0, 0, 0 },
				{ 0, 2, 0 },
				{ 0, 0, 0 },
				{ 0, 0, 1 },
				{ 0, 0, 1.5 },
				{ 0, 2, 1 },
				{ 0, 0, 0 },
		};

		double[][] deadline = {
				{ 8, 12, 16 },
				{ 8, 12, 16 },
				{ 4, 6, 10 },
				{ 4, 6, 10 },
				{ 4, 5, 8 },
				{ 2, 3, 4 },
				{ 10000, 10000*60, 10000*60*60 },
		};

		double[][] blocking = {
				{ 0, 0, 0 },
				{ 0, 0, 0 },
				{ 0, 0, 0 },
				{ 0, 0, 0 },
				{ 0, 0, 0 },
				{ 0, 0, 0 },
				{ 0, 0, 0 }
		};

		double[][] wcet = {
				{ 2, 3, 7 },
				{ 2, 3, 7 },
				{ 2, 1, 3 },
				{ 2, 1, 3 },
				{ 1, 2, 2.5 },
				{ 1.5, 3, 3.5 },
				{ 2000, 3e4, 7e5 },
		};
		
		for (int testId=0; testId<period.length; testId++) {
			// init RTA
			MyTaskSet mts_RTA = new MyTaskSet(wcet[testId], period[testId], deadline[testId],
					offset[testId], blocking[testId], JScan.tasksRTASchedulability);
			Schedulability rta = new RTASchedulability();
			rta.setTaskSet(mts_RTA);
			rta.setResourceSet(resources);
			
			// init EXACT
			MyTaskSet mts_EXACT = new MyTaskSet(wcet[testId], period[testId], deadline[testId],
					offset[testId], blocking[testId], JScan.tasksOffSetSchedulability);
			Schedulability exact = new OffsetDMSchedulabilityComplete();
			exact.setTaskSet(mts_EXACT);
			exact.setResourceSet(resources);
			
			// init SUFFICIENT _ 1
			MyTaskSet mts_SUFF_1 = new MyTaskSet(wcet[testId], period[testId], deadline[testId],
					offset[testId], blocking[testId], JScan.tasksOffSetSchedulability);
			Schedulability suff_1 = new OffsetSchedulabilityRTA();
			((OffSetSchedulability) suff_1).setTotalFixedTask(1);
			suff_1.setTaskSet(mts_SUFF_1);
			suff_1.setResourceSet(resources);

			// init SUFFICIENT _ 2
			MyTaskSet mts_SUFF_2 = new MyTaskSet(wcet[testId], period[testId], deadline[testId],
					offset[testId], blocking[testId], JScan.tasksOffSetSchedulability);
			Schedulability suff_2 = new OffsetSchedulabilityRTA();
			((OffSetSchedulability) suff_2).setTotalFixedTask(2);
			suff_2.setTaskSet(mts_SUFF_2);
			suff_2.setResourceSet(resources);

			// init SUFFICIENT _ 3
			MyTaskSet mts_SUFF_3 = null;
			Schedulability suff_3 = null;
			if (period[testId].length>3) {
				mts_SUFF_3 = new MyTaskSet(wcet[testId], period[testId], deadline[testId],
						offset[testId], blocking[testId], JScan.tasksOffSetSchedulability);
				suff_3 = new OffsetSchedulabilityRTA();
				((OffSetSchedulability) suff_3).setTotalFixedTask(2);
				suff_3.setTaskSet(mts_SUFF_3);
				suff_3.setResourceSet(resources);
			}
			
			rta.compute();
			exact.compute();
			suff_1.compute();
			suff_2.compute();
			if (suff_3 != null) { suff_3.compute(); }
			
			for (int ntask=0; ntask<period[testId].length; ntask++) {
				assertTrue(mts_RTA.getItem(1,ntask).getDouble("responsetime")>=mts_SUFF_1.getItem(1,ntask).getDouble("responsetime"));
				assertTrue(mts_SUFF_1.getItem(1,ntask).getDouble("responsetime")>=mts_SUFF_2.getItem(1,ntask).getDouble("responsetime"));
				if (mts_SUFF_3 != null) {
					assertTrue(mts_SUFF_2.getItem(1,ntask).getDouble("responsetime")>=mts_SUFF_3.getItem(1,ntask).getDouble("responsetime"));
					assertTrue(mts_SUFF_3.getItem(1,ntask).getDouble("responsetime")>=mts_EXACT.getItem(1,ntask).getDouble("responsetime"));
				} else {
					assertTrue(mts_SUFF_2.getItem(1,ntask).getDouble("responsetime")>=mts_EXACT.getItem(1,ntask).getDouble("responsetime"));
				}
				
			}
		}
	}

	@Test
	public void testWithBlocking() {
		GenResList resources = new GenResList(VarTreeUtil.newVarTree(), new String[] {""}, "Resources");
		
		ArrayList<double[][]> tests = new ArrayList<double[][]>();
		
		tests.add(new double[][] {
				{ 8, 12, 16 },	// period
				{ 0, 0, 0 },	// offset
				{ 8, 12, 16 },	// deadline
				{ 1, 1, 0 },	// blocking
				{ 2, 3, 7 }	// wcet
		});
		tests.add(new double[][] {
				{ 8, 12, 16 },	// period
				{ 0, 2, 0 },	// offset
				{ 8, 12, 16 },	// deadline
				{ 1.5, 1, 0 },	// blocking
				{ 2, 3, 7 }	// wcet
		});
		tests.add(new double[][] {
				{ 4, 6, 10 },	// period
				{ 0, 0, 0 },	// offset
				{ 4, 6, 10 },	// deadline
				{ 1, 1, 0 },	// blocking
				{ 2, 1, 3 }	// wcet
		});
		tests.add(new double[][] {
				{ 4, 6, 10 },	// period
				{ 0, 0, 1 },	// offset
				{ 4, 6, 10 },	// deadline
				{ 2, 1, 0 },	// blocking
				{ 2, 1, 3 }	// wcet
		});
		tests.add(new double[][] {
				{ 4, 5, 8 },	// period
				{ 0, 0, 1.5 },	// offset
				{ 4, 5, 8 },	// deadline
				{ 2, 1, 0 },	// blocking
				{ 1, 2, 2.5 }	// wcet
		});
		tests.add(new double[][] {
				{ 5, 5,  40, 40 },	// period
				{ 0, 3,   5,  1 },	// offset
				{ 1, 5,  35,  5 },	// deadline
				{ 0, 0.1, 0,  0 },	// blocking
				{ 1, 1,  12,  2 }	// wcet
		});		
		tests.add(new double[][] {
				{ 5, 40, 5,  40 },	// period
				{ 0,  1, 3,   5 },	// offset
				{ 1,  5, 5,  35 },	// deadline
				{ 0,  0, 0.1, 0 },	// blocking
				{ 1,  2, 1,  12 }	// wcet
		});		
		for (int testId=0; testId<tests.size(); testId++) {
			double[][] data = (double[][]) tests.get(testId);
			double[] period = data[0];
			double[] offset = data[1];
			double[] deadline = data[2];
			double[] blocking = data[3];
			double[] wcet = data[4];
			// init RTA
			MyTaskSet mts_RTA = new MyTaskSet(wcet, period, deadline,
					offset, blocking, JScan.tasksRTASchedulability);
			Schedulability rta = new RTASchedulability();
			rta.setTaskSet(mts_RTA);
			rta.setResourceSet(resources);
			
			// init EXACT
			MyTaskSet mts_EXACT = new MyTaskSet(wcet, period, deadline,
					offset, blocking, JScan.tasksOffSetSchedulability);
			Schedulability exact = new OffsetDMSchedulabilityComplete();
			exact.setTaskSet(mts_EXACT);
			exact.setResourceSet(resources);
			
			// init SUFFICIENT _ 1
			MyTaskSet mts_SUFF_1 = new MyTaskSet(wcet, period, deadline,
					offset, blocking, JScan.tasksOffSetSchedulability);
			Schedulability suff_1 = new OffsetSchedulabilityRTA();
			((OffSetSchedulability) suff_1).setTotalFixedTask(1);
			suff_1.setTaskSet(mts_SUFF_1);
			suff_1.setResourceSet(resources);

			// init SUFFICIENT _ 2
			MyTaskSet mts_SUFF_2 = new MyTaskSet(wcet, period, deadline,
					offset, blocking, JScan.tasksOffSetSchedulability);
			Schedulability suff_2 = new OffsetSchedulabilityRTA();
			((OffSetSchedulability) suff_2).setTotalFixedTask(2);
			suff_2.setTaskSet(mts_SUFF_2);
			suff_2.setResourceSet(resources);

			// init SUFFICIENT _ 3
			MyTaskSet mts_SUFF_3 = null;
			Schedulability suff_3 = null;
			if (period.length>3) {
				mts_SUFF_3 = new MyTaskSet(wcet, period, deadline,
						offset, blocking, JScan.tasksOffSetSchedulability);
				suff_3 = new OffsetSchedulabilityRTA();
				((OffSetSchedulability) suff_3).setTotalFixedTask(3);
				suff_3.setTaskSet(mts_SUFF_3);
				suff_3.setResourceSet(resources);
			}
			
			rta.compute();
			exact.compute();
			suff_1.compute();
			suff_2.compute();
			if (suff_3 != null) { suff_3.compute(); }
			
			System.out.println("Test " + testId +":\n"
					+ "\t\tTASK,     WCET\t PERIOD\t OFFSET\t RTA\t SUFF1\t SUFF2\t "+(mts_SUFF_3!=null?" SUFF3\t":"")+"EXACT\n");
			
			for (int ntask=0; ntask<period.length; ntask++) {

				System.out.println("\t\t" + ntask + "\t"
						+ wcet[ntask] + "\t"
						+ period[ntask] + "\t "
						+ offset[ntask] + "\t "
						+ mts_RTA.getItem(1,ntask).getDouble("responsetime") + "\t "
						+ mts_SUFF_1.getItem(1,ntask).getDouble("responsetime") + "\t "
						+ mts_SUFF_2.getItem(1,ntask).getDouble("responsetime") + "\t "
						+ (mts_SUFF_3!=null?mts_SUFF_3.getItem(1,ntask).getDouble("responsetime") + "\t ":"")
						+ mts_EXACT.getItem(1,ntask).getDouble("responsetime")
				);

				assertTrue(mts_RTA.getItem(1,ntask).getDouble("responsetime")>=mts_SUFF_1.getItem(1,ntask).getDouble("responsetime"));
				assertTrue(mts_SUFF_1.getItem(1,ntask).getDouble("responsetime")>=mts_SUFF_2.getItem(1,ntask).getDouble("responsetime"));
				if (mts_SUFF_3 != null) {
					assertTrue(mts_SUFF_2.getItem(1,ntask).getDouble("responsetime")>=mts_SUFF_3.getItem(1,ntask).getDouble("responsetime"));
					assertTrue(mts_SUFF_3.getItem(1,ntask).getDouble("responsetime")>=mts_EXACT.getItem(1,ntask).getDouble("responsetime"));
				} else {
					assertTrue(mts_SUFF_2.getItem(1,ntask).getDouble("responsetime")>=mts_EXACT.getItem(1,ntask).getDouble("responsetime"));
				}
				
			}
		}
	}

	@Test
	public void testWithBlockingAndSporadic() {
		class TestWithBlockingAndType {
			public double[] period;
			public double[] offset;
			public double[] deadline;
			public double[] blocking;
			public double[] wcet;
			public String[] type;
			
			public TestWithBlockingAndType(
					double[] period,
					double[] offset,
					double[] deadline,
					double[] blocking,
					double[] wcet,
					String[] type) {
				this.period = period;
				this.offset = offset;
				this.deadline = deadline;
				this.blocking = blocking;
				this.wcet = wcet;
				this.type = type;
			}
		}
		final String P = "periodic";
		final String S = "sporadic";
		GenResList resources = new GenResList(VarTreeUtil.newVarTree(), new String[] {""}, "Resources");
		
		ArrayList<Object> tests = new ArrayList<Object>();
		
		// 0
		tests.add(new TestWithBlockingAndType(
				new double[] { 8, 12, 16 },	// period
				new double[] { 0, 0, 0 },	// offset
				new double[] { 8, 12, 16 },	// deadline
				new double[] { 1, 1, 0 },	// blocking
				new double[] { 2, 3, 7 },	// wcet
				new String[] { P, S, P}
		));
		// 1
		tests.add(new TestWithBlockingAndType(
				new double[] { 8, 12, 16 },	// period
				new double[] { 0, 2, 0 },	// offset
				new double[] { 8, 12, 16 },	// deadline
				new double[] { 1.5, 1, 0 },	// blocking
				new double[] { 2, 3, 7 },	// wcet
				new String[] { P, S, P}
		));
		// 2
		tests.add(new TestWithBlockingAndType(
				new double[] { 4, 6, 10 },	// period
				new double[] { 0, 0, 0 },	// offset
				new double[] { 4, 6, 10 },	// deadline
				new double[] { 1, 1, 0 },	// blocking
				new double[] { 2, 1, 3 },	// wcet
				new String[] { P, S, P}
		));
		// 3
		tests.add(new TestWithBlockingAndType(
				new double[] { 4, 6, 10 },	// period
				new double[] { 0, 0, 1 },	// offset
				new double[] { 4, 6, 10 },	// deadline
				new double[] { 2, 1, 0 },	// blocking
				new double[] { 2, 1, 3 },	// wcet
				new String[] { P, S, P}
		));
		// 4
		tests.add(new TestWithBlockingAndType(
				new double[] { 4, 5, 8 },	// period
				new double[] { 0, 0, 1.5 },	// offset
				new double[] { 4, 5, 8 },	// deadline
				new double[] { 2, 1, 0 },	// blocking
				new double[] { 1, 2, 2.5 },	// wcet
				new String[] { P, S, P}
		));
		tests.add(new TestWithBlockingAndType(
				new double[] { 5, 5,  40, 40 },	// period
				new double[] { 0, 3,   5,  1 },	// offset
				new double[] { 1, 5,  35,  5 },	// deadline
				new double[] { 0, 0.1, 0,  0 },	// blocking
				new double[] { 1, 1,  12,  2 },	// wcet
				new String[] { P, P,   P,  S}
		));
		tests.add(new TestWithBlockingAndType(
				new double[] { 5, 40, 5,  40 },	// period
				new double[] { 0,  1, 3,   5 },	// offset
				new double[] { 1,  5, 5,  35 },	// deadline
				new double[] { 0,  0, 0.1, 0 },	// blocking
				new double[] { 1,  2, 1,  12 },	// wcet
				new String[] { P,  S, P,   P}
		));
		for (int testId=0; testId<tests.size(); testId++) {
			TestWithBlockingAndType data = (TestWithBlockingAndType) tests.get(testId);
			double[] period = data.period;
			double[] offset = data.offset;
			double[] deadline = data.deadline;
			double[] blocking = data.blocking;
			double[] wcet = data.wcet;
			String[] type = data.type;
			// init RTA
			MyTaskSet mts_RTA = new MyTaskSet(wcet, period, deadline,
					offset, blocking, type, JScan.tasksRTASchedulability);
			Schedulability rta = new RTASchedulability();
			rta.setTaskSet(mts_RTA);
			rta.setResourceSet(resources);
			
			// init EXACT
			MyTaskSet mts_EXACT = new MyTaskSet(wcet, period, deadline,
					offset, blocking, type, JScan.tasksOffSetSchedulability);
			Schedulability exact = new OffsetDMSchedulabilityComplete();
			exact.setTaskSet(mts_EXACT);
			exact.setResourceSet(resources);
			
			// init SUFFICIENT _ 1
			MyTaskSet mts_SUFF_1 = new MyTaskSet(wcet, period, deadline,
					offset, blocking, type, JScan.tasksOffSetSchedulability);
			Schedulability suff_1 = new OffsetSchedulabilityRTA();
			((OffSetSchedulability) suff_1).setTotalFixedTask(1);
			suff_1.setTaskSet(mts_SUFF_1);
			suff_1.setResourceSet(resources);

			// init SUFFICIENT _ 2
			MyTaskSet mts_SUFF_2 = new MyTaskSet(wcet, period, deadline,
					offset, blocking, type, JScan.tasksOffSetSchedulability);
			Schedulability suff_2 = new OffsetSchedulabilityRTA();
			((OffSetSchedulability) suff_2).setTotalFixedTask(2);
			suff_2.setTaskSet(mts_SUFF_2);
			suff_2.setResourceSet(resources);

			// init SUFFICIENT _ 3
			MyTaskSet mts_SUFF_3 = null;
			Schedulability suff_3 = null;
			if (period.length>3) {
				mts_SUFF_3 = new MyTaskSet(wcet, period, deadline,
						offset, blocking, type, JScan.tasksOffSetSchedulability);
				suff_3 = new OffsetSchedulabilityRTA();
				((OffSetSchedulability) suff_3).setTotalFixedTask(3);
				suff_3.setTaskSet(mts_SUFF_3);
				suff_3.setResourceSet(resources);
			}
			
			rta.compute();
			exact.compute();
			suff_1.compute();
			suff_2.compute();
			if (suff_3 != null) { suff_3.compute(); }
			
			System.out.println("Test " + testId +":\n"
					+ "\t\tTASK,     WCET\t PERIOD\t OFFSET\t RTA\t SUFF1\t SUFF2\t "+(mts_SUFF_3!=null?" SUFF3\t":"")+"EXACT\n");
			
			for (int ntask=0; ntask<period.length; ntask++) {

				System.out.println("\t\t" + ntask + "\t"
						+ wcet[ntask] + "\t"
						+ period[ntask] + "\t "
						+ offset[ntask] + "\t "
						+ mts_RTA.getItem(1,ntask).getDouble("responsetime") + "\t "
						+ mts_SUFF_1.getItem(1,ntask).getDouble("responsetime") + "\t "
						+ mts_SUFF_2.getItem(1,ntask).getDouble("responsetime") + "\t "
						+ (mts_SUFF_3!=null?mts_SUFF_3.getItem(1,ntask).getDouble("responsetime") + "\t ":"")
						+ mts_EXACT.getItem(1,ntask).getDouble("responsetime")
				);

				assertTrue(mts_RTA.getItem(1,ntask).getDouble("responsetime")>=mts_SUFF_1.getItem(1,ntask).getDouble("responsetime"));
				assertTrue(mts_SUFF_1.getItem(1,ntask).getDouble("responsetime")>=mts_SUFF_2.getItem(1,ntask).getDouble("responsetime"));
				if (mts_SUFF_3 != null) {
					assertTrue(mts_SUFF_2.getItem(1,ntask).getDouble("responsetime")>=mts_SUFF_3.getItem(1,ntask).getDouble("responsetime"));
					assertTrue(mts_SUFF_3.getItem(1,ntask).getDouble("responsetime")>=mts_EXACT.getItem(1,ntask).getDouble("responsetime"));
				} else {
					assertTrue(mts_SUFF_2.getItem(1,ntask).getDouble("responsetime")>=mts_EXACT.getItem(1,ntask).getDouble("responsetime"));
				}
				
			}
		}
	}

	@Test
	public void testModes() {
		
		GenResList resources = new GenResList(VarTreeUtil.newVarTree(), new String[] {""}, "Resources");
		double[][] period = {
				//	15		14	11		10		9		8	7	6	
				{	 		5, 							5,	20,	65	}, // Mode_0
				{ 50, 		5, 50,  	50,		50,		5,	20,	65	}, // Mode_1
				{ 83.333, 	5, 83.333, 	83.333,	83.333,	5,	20,	65	}, // Mode_2
				{ 116.666, 	5, 116.666, 116.666,116.666,5,	20,	65	}, // Mode_3
				{ 150, 		5, 150, 	150,	150,	5,	20,	65	}, // Mode_4
				{ 183.333, 	5, 183.333, 183.333,183.333,5,	20,	65	}  // Mode_5
		};

		double[][] offset = {
				//	15		14	11		10		9		8	7	6	
				{	 		0, 							0,	0,	0	}, // Mode_0
				{ 0, 		0, 0,	  	0,		0,		0,	0,	0	}, // Mode_1
				{ 0, 		0, 0,	  	0,		0,		0,	0,	0	}, // Mode_2
				{ 0, 		0, 0,	  	0,		0,		0,	0,	0	}, // Mode_3
				{ 0, 		0, 0,	  	0,		0,		0,	0,	0	}, // Mode_4
				{ 0, 		0, 0,	  	0,		0,		0,	0,	0	}  // Mode_5
		};

		double[][] deadline = {
				//	15		14	11		10		9		8	7	6	
				{	 		5, 							5,	20,	65	}, // Mode_0
				{ 50, 		5, 50,  	50,		50,		5,	20,	65	}, // Mode_1
				{ 83.333, 	5, 83.333, 	83.333,	83.333,	5,	20,	65	}, // Mode_2
				{ 116.666, 	5, 116.666, 116.666,116.666,5,	20,	65	}, // Mode_3
				{ 150, 		5, 150, 	150,	150,	5,	20,	65	}, // Mode_4
				{ 183.333, 	5, 183.333, 183.333,183.333,5,	20,	65	}  // Mode_5
		};

		double[][] blocking = {
				//	15		14	11		10		9		8	7	6	
				{	 		0, 							0,	0,	0	}, // Mode_0
				{ 0, 		0, 0,	  	0,		0,		0,	0,	0	}, // Mode_1
				{ 0, 		0, 0,	  	0,		0,		0,	0,	0	}, // Mode_2
				{ 0, 		0, 0,	  	0,		0,		0,	0,	0	}, // Mode_3
				{ 0, 		0, 0,	  	0,		0,		0,	0,	0	}, // Mode_4
				{ 0, 		0, 0,	  	0,		0,		0,	0,	0	}  // Mode_5
		};

		double[][] wcet = {
				//	15		14		11		10		9		8		7		6	
				{ 		 	0.763, 							1.1,	5.82,	10.775	}, // Mode_0
				{ 0.324, 	0.763, 0.072,  	0.048,	1.057,	1.1,	5.82,	10.775	}, // Mode_1
				{ 0.324, 	0.763, 0.072,  	0.048,	1.057,	1.1,	5.82,	10.775	}, // Mode_2
				{ 0.324, 	0.763, 0.072,  	0.048,	1.057,	1.1,	5.82,	10.775	}, // Mode_3
				{ 0.324, 	0.763, 0.072,  	0.048,	1.057,	1.1,	5.82,	10.775	}, // Mode_4
				{ 0.324, 	0.763, 0.072,  	0.048,	1.057,	1.1,	5.82,	10.775	}  // Mode_5
		};
		
		for (int testId=0; testId<period.length; testId++) {
			// init RTA
			MyTaskSet mts_RTA = new MyTaskSet(wcet[testId], period[testId], deadline[testId],
					offset[testId], blocking[testId], JScan.tasksRTASchedulability);
			Schedulability rta = new RTASchedulability();
			rta.setTaskSet(mts_RTA);
			rta.setResourceSet(resources);
			
			// init EXACT
			MyTaskSet mts_EXACT = new MyTaskSet(wcet[testId], period[testId], deadline[testId],
					offset[testId], blocking[testId], JScan.tasksOffSetSchedulability);
			Schedulability exact = new OffsetDMSchedulabilityComplete();
			exact.setTaskSet(mts_EXACT);
			exact.setResourceSet(resources);
			
			// init SUFFICIENT _ 1
			MyTaskSet mts_SUFF_1 = new MyTaskSet(wcet[testId], period[testId], deadline[testId],
					offset[testId], blocking[testId], JScan.tasksOffSetSchedulability);
			Schedulability suff_1 = new OffsetSchedulabilityRTA();
			((OffSetSchedulability) suff_1).setTotalFixedTask(1);
			suff_1.setTaskSet(mts_SUFF_1);
			suff_1.setResourceSet(resources);

			// init SUFFICIENT _ 2
			MyTaskSet mts_SUFF_2 = new MyTaskSet(wcet[testId], period[testId], deadline[testId],
					offset[testId], blocking[testId], JScan.tasksOffSetSchedulability);
			Schedulability suff_2 = new OffsetSchedulabilityRTA();
			((OffSetSchedulability) suff_2).setTotalFixedTask(2);
			suff_2.setTaskSet(mts_SUFF_2);
			suff_2.setResourceSet(resources);

			rta.compute();
			exact.compute();
			suff_1.compute();
			suff_2.compute();
			
			System.out.println("Test " + testId +":\n"
					+ "\t\tTASK,     WCET\t PERIOD\t RTA\t SUFF1\t SUFF2\t EXACT\n");
			
			for (int ntask=0; ntask<period[testId].length; ntask++) {

				System.out.println("\t\t" + ntask + "\t"
						+ wcet[testId][ntask] + "\t"
						+ period[testId][ntask] + "\t "
						+ mts_RTA.getItem(1,ntask).getDouble("responsetime") + "\t "
						+ mts_SUFF_1.getItem(1,ntask).getDouble("responsetime") + "\t "
						+ mts_SUFF_2.getItem(1,ntask).getDouble("responsetime") + "\t "
						+ mts_EXACT.getItem(1,ntask).getDouble("responsetime")
				);

				assertTrue(mts_RTA.getItem(1,ntask).getDouble("responsetime")>=mts_SUFF_1.getItem(1,ntask).getDouble("responsetime"));
				assertTrue(mts_SUFF_1.getItem(1,ntask).getDouble("responsetime")>=mts_SUFF_2.getItem(1,ntask).getDouble("responsetime"));
				assertTrue(mts_SUFF_2.getItem(1,ntask).getDouble("responsetime")>=mts_EXACT.getItem(1,ntask).getDouble("responsetime"));
			}
		}
	}
	
}