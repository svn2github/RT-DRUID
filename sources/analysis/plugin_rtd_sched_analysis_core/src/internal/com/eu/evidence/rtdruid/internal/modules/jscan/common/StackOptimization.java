/*
 * Created on 5-ott-2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.eu.evidence.rtdruid.internal.modules.jscan.common;

import com.eu.evidence.rtdruid.desk.Messages;
import com.eu.evidence.rtdruid.internal.modules.jscan.Progress;
import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.abstractions.old.GenRes;
import com.eu.evidence.rtdruid.vartree.abstractions.old.Task;
import com.eu.evidence.rtdruid.vartree.abstractions.old.TaskSet;
import com.eu.evidence.rtdruid.vartree.variables.IntegerVar;

/**
 * @author mvc
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class StackOptimization {
	
	protected TaskSet taskSet;
	
	static final protected Progress DEFAULT_PROGRESS = new Progress() {
		public void addSteps(long steps) {}
		public void worked(long steps) {}
		public void done() {}
		public boolean stoped() {return false;}
	};
	protected Progress progress = DEFAULT_PROGRESS; 
	
	/** Abbreviation for VarTree.SEPARATOR */
	private final static char S = IVarTree.SEPARATOR;
	
	protected int[] maxStack_Size = null;
	
	static final protected String[][] taskP = {
			{ Task.STR_ACT_TYPE,    "__see_task__"},
			{ "wcet",    "__see_task__"},
			{ "period",  "__see_task__"},
			{ "threshold",  "__see_task__"},
			{ "stack",  "__see_task__"},
			{ "deadline","__see_task__"},
			{ "priority","__see_task__"},
			{ "resource",      "__see_task__"  },
			{ "offset",            "__see_task__"            },
			{ "ResponseTime",          "__see_task__"          },
//			{ "PreemptionGroupName",  "__see_task__"  },
//			{ "blocking",          "__see_task__"          },
			{ "schedulable",       "__see_task__"       },
			{ "utilization",       "__see_task__"       },
			{ "cDelta",              "__see_task__"              }
	};
	
	/**
	  	1. for each task ti
	 	2. worst[ti] = stack[ti];
	 	3. for each task ti h2l
	 	4. for each task tj that can preempt ti h2l
	 	5. worst[ti] = max( worst[ti], stack[ti]+worst[tj]);
	 	6. the_worst = max(for each ti, worst[ti]);
	 	
	 		(Note: h2l means “from highest to lowest priority”)
	 		
	 * @return int MaxStackSize
	 */
	public StackOptimization(){
		taskSet = null;
	}
	
	public StackOptimization(TaskSet tasks){
		taskSet = tasks;
		maxStack_Size = new int[taskSet.getPrefixNumber() - 1];
		fillProperties();
	}
	
	private void fillProperties(){
		for (int i=0; i<taskP.length; i++) {
			taskSet.setProperty(taskP[i][0],taskP[i][1],false);
		}
	}
	
	public int[] calculateMaximumStackSize(){
		//int maxStack_Size = 0;
		
		taskSet.sortByPriority();
		
		for (int rtosId=1; rtosId< taskSet.getPrefixNumber(); rtosId++) {
			int[] worst = new int[taskSet.getSize(rtosId)];
			int[] stack = new int[taskSet.getSize(rtosId)];
			int[] priority = new int[taskSet.getSize(rtosId)];
			int[] threshold = new int[taskSet.getSize(rtosId)];
			
			for (int i=0; i<taskSet.getSize(rtosId); ++i) {
		        GenRes t = taskSet.getItem(rtosId, i);
		        stack[i] = t.getInt("stack");
		        worst[i] = stack[i];
		        priority[i] = t.getInt("priority");
		        threshold[i] = t.getInt("threshold");
		        t.setTempProperty("stack", stack[i]);
		        
		        if (threshold[i]<priority[i]) {
		        	Messages.sendError("Task " +t.getName()+ " has a threshold lower than priority", null, "stackopt illegal threshold", null);
		        	throw new RuntimeException("Illegal threshold for task "+ t.getName());
		        }
			}
			
			for (int i=0; i<taskSet.getSize(rtosId); ++i) {		        
		        for(int j=0; j<taskSet.getSize(rtosId); ++j) {
		        	if(priority[j] > threshold[i]){
		        		worst[i] = Math.max( worst[i], stack[i]+ worst[j]);
		        	}					
		        }
		        progress.worked(1);
		     }
			maxStack_Size[rtosId - 1] = this.max(worst);
			storeCpuSched(rtosId, maxStack_Size[rtosId - 1]);
		}
		
		return maxStack_Size;
	}
	
	private void storeCpuSched(int cpuId, int stackSize){
			ITreeInterface ti = taskSet.getVarTree().newTreeInterface();
			String system = taskSet.getSystem();
			String cpu = taskSet.getPrefix(cpuId);
			String mode = taskSet.getMode();
			
			if (!ti.exist(system, "System")) {
				Messages.sendWarning("Store a report of a not existent System (" + system + ")"
						, null, "Schedulability analysis", null);
				return;
			}
			String path = null;
			
			
			try {
				// 1) search scheduling
				String ttpref = system;
				String ttnew = "Schedulability";
				if (!ti.exist(ttpref + S + ttnew, "Schedulability")) {
					ti.addElement(ttnew, "Schedulability", ttpref);
				}
				
				// 2) search scheduling scenario
				ttpref += S + ttnew + S +"SchedulingScenarioList"; // sys + sched + list
				ttnew = mode;
				String stnew = DataPath.makeSlashedId(mode);
				if (!ti.exist(ttpref + S + stnew, "SchedulingScenario")) {
					ti.addElement(ttnew, "SchedulingScenario", ttpref);
				}
				
				// 3) search CpuSched
				ttpref += S + stnew + S +"CpuSchedList"; // sys + sched + list + scenario + taskList
				ttnew = cpu;
				stnew = DataPath.makeSlashedId(cpu);
				if (!ti.exist(ttpref + S + stnew, "CpuSched")) {
					ti.addElement(ttnew, "CpuSched", ttpref);
				}
				
				path = ttpref + S + stnew;
				
			} catch (ITreeInterface.AddElementException e) {
				// why??? only if BuilderXML wasn't load
				e.printStackTrace();
				return;
			} catch (RuntimeException e) {
				// why??? only if BuilderXML wasn't load
				e.printStackTrace();
				return;
			}
			
			//Store maxStackSize
			try {
				ti.setValue(path + S + "MaxStackSize", new IntegerVar(new Integer(stackSize).toString()));
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public void setTaskSet(TaskSet t) { taskSet = t; }
	
	protected int max(int[] t) {
	    int maximum = t[0];   // start with the first value
	    for (int i=1; i<t.length; i++) {
	        if (t[i] > maximum) {
	            maximum = t[i];   // new maximum
	        }
	    }
	    return maximum;
	}//
	
	/**
	 * To set the progress bar.
	 */
	public void setProgress(Progress newProgress) {
		if (newProgress == null) {
			progress = DEFAULT_PROGRESS;
		} else {
			progress = newProgress;
		}
		addSteps();
	}
	
	protected void addSteps() {
	    for (int i=1; i<taskSet.getPrefixNumber(); i++) {
	        progress.addSteps(taskSet.getSize(i));
	    }
	}
	
	public void print(){
		String[] line = {"Task", "Priority", "Threshold", "Stack"};
		//System.out.format("%15s %10s %10s %10s %n%n", line);
		
		for (int rtosId=1; rtosId< taskSet.getPrefixNumber(); rtosId++) {
			System.out.println("Cpu Name: "+taskSet.getPrefix(rtosId));
			
			for (int i=0; i<taskSet.getSize(rtosId); ++i) {				
		        GenRes t = taskSet.getItem(rtosId, i);
		        String[] line2 = {t.getName(), new Integer(t.getInt("priority")).toString(), new Integer(t.getInt("threshold")).toString(), 
		        						new Integer(t.getTempInt("stack")).toString()};
				//System.out.format("%15s %10s %10s %10s %n", line2);
			}
			
			System.out.println("StackSize: "+maxStack_Size[rtosId - 1]+"\n\n");
		}		
	}
}
