/*
 * Created on 6-apr-2006
 *
 * $Id: EEStack.java,v 1.7 2008/05/14 17:13:37 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw;

import static com.eu.evidence.rtdruid.modules.oil.codewriter.common.AbstractRtosWriter.getOsProperties;
import static com.eu.evidence.rtdruid.modules.oil.codewriter.common.AbstractRtosWriter.getOsProperty;
import static com.eu.evidence.rtdruid.modules.oil.codewriter.common.CommonUtils.addToAllStrings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.eu.evidence.rtdruid.desk.Messages;
import com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.ErikaEnterpriseWriter;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.ISimpleGenResKeywords;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList;
import com.eu.evidence.rtdruid.modules.oil.abstractions.ISimpleGenRes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.CommonUtils;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEWriterKeywords;
import com.eu.evidence.rtdruid.modules.oil.implementation.OilObjectType;
import com.eu.evidence.rtdruid.modules.oil.implementation.OilPath;
import com.eu.evidence.rtdruid.vartree.IVarTree;

/**
 * This class store all data about stacks, and check for theirs consistency.
 * 
 * @author Nicola Serreli
 */
public final class EEStacks implements IEEWriterKeywords {
	
	/** Used to clear rules about shared stack */
	public final int AUTO = 0;
	/** Used to specify that dummy stack must be always the first stack.
	 * incompatible with FORCE_LAST  */
	public final int FORCE_FIRST  = 1<<1;
	/** Used to specify that dummy stack must be always the last stack.
	 * incompatible with FORCE_FIRST */
	public final int FORCE_LAST   = 1<<2;
	/** Used to specify that dummy stack must be always computed */
	public final int FORCE_ALWAYS = 1<<3;

	
	public final static String APPLICATION_IRQ_PREFIX = "__application_irq_prefix__";
	public final static String APPLICATION_SHARED_PREFIX = "__stack__shared_prefix__";
	public final static String STACK_BASE_NAME_PREFIX = "__stack__base_name_prefix__";
	private static final String APP_SHARED_STACK = "SHARED_STACK_SIZE";
	private static final String APP_IRQ_SIZE = "IRQ_STACK_SIZE";
	
	/**
	 * Contains the link between a task and its stacks (user and system)
	 * 
	 * @author Nicola Serreli
	 */
	private final class Tasks implements Comparable<Object> {
		private String nome;

		private String sId;

		/**
		 * Makes a new Tasks object without make any check
		 */
		public Tasks(String name, String stackId) {
			nome = name;
			sId = stackId;
		}

		// get
		public String getStackId() {
			return sId;
		}

		/**
		 * Compare this object to given object (a Tasks or a String)
		 */
		public int compareTo(Object o) {
			if (o instanceof Tasks) { // "o" is a Tasks
				Tasks p = (Tasks) o;
				return nome.compareTo(p.nome); // compare between two string
			}
			// else -> No problem if "o" is a string, exception otherwise
			return nome.compareTo(""+o);
		}
		
		public String toString() {
			return "Task = " + nome + ", stack = " + sId; 
		}
	}

	/**
	 * Contains the description of a stack
	 * 
	 * @author Nicola Serreli
	 */
	private final class StackDescr implements Comparable<Object> {
		private String id;

		/**
		 * Size dim[0] = user stack dim[1] = system stack
		 */
		private int dim[];
		
		/**
		 * number of tasks and isr that uses this kernel stack
		 */
		private int kernelSize;

		/**
		 * If set, this string identifies the memory partition 
		 * (of an os application) where this stack is allocated.  
		 */
		private String application;
		/**
		 * Makes a new Tasks object without make any check
		 */
		public StackDescr(String stackId, int[] stackSize, int kernelSize) {
			this(stackId, stackSize, kernelSize, null);
		}
		public StackDescr(String stackId, int[] stackSize, int kernelSize, String applicationId) {
			id = stackId;
			dim = new int[stackSize.length];
			System.arraycopy(stackSize, 0, dim, 0, stackSize.length);
			application = applicationId;
		}

		// get
		public int[] getSize() {
			return dim;
		}

		// get
		public void incrKernelSize() {
			kernelSize++;
		}
		
		// get
		public int getKernelSize() {
			return kernelSize;
		}
		
		public String getId() {
			return id;
		}
		
		protected void setSize(int[] newDim) {
			dim = newDim;
		}
		
		public String getApplicationId() {
			return application;
		}

		/**
		 * Compare this object to given object (a Tasks or a String)
		 */
		public int compareTo(Object o) {
			if (o instanceof StackDescr) { // "o" is a Tasks
				StackDescr p = (StackDescr) o;
				return id.compareTo(p.id); // compare between two number
			}
			// else -> No problem if "o" is a string, exception otherwise
			return id.compareTo(""+o);
		}
		
		public String toString() {
			StringBuffer tmp = new StringBuffer(id + " [");
			for (int i=0; i<dim.length; i++) {
				tmp.append((i>0 ? "," : "") + dim[i]); 
			}
			return tmp.toString() + "]"; 
		}
	}

	private ArrayList<Tasks> taskList; // Tasks

	private ArrayList<StackDescr> stackList; // StackDescr
	
	private CpuHwDescription currentStackDescription = null;
	
	private int dummyStackPolicy = AUTO;
	
	/** Contains the ID of Dummy stack */
	private String idDummy;

	private final IVarTree vt;
	private final ErikaEnterpriseWriter parent;

	/** Makes a empty object; only {@link #clone clone}uses this function. */
	private EEStacks(ErikaEnterpriseWriter parent) {
		this.parent = parent;
		this.vt = parent.getVt();
		
	}

	/** Makes a new list of link between task and stack.
	 *  Note: this function updates also the TaskProperty_TASK_STACK(sthard or private)*/
	@SuppressWarnings("unused")
	public EEStacks(ErikaEnterpriseWriter parent, IOilObjectList ool, int[] reserved) {
		this.parent = parent;
		this.vt = parent.getVt();

		// get current Cpu Type
		final String cpuType = getOsProperty(ool, ISimpleGenResKeywords.OS_CPU_TYPE);
		final String cpuName = ErikaEnterpriseWriter.getOSName(ool);
		List<String> currentCpuDataPrefixes = getOsProperties(ool, SGRK_OS_CPU_DATA_PREFIX);
		currentStackDescription = ErikaEnterpriseWriter.getCpuHwDescription(ool);
		
		if (currentStackDescription == null) {
			throw new RuntimeException("Unknow stack description for current cpu : " + cpuType);
		}
		final int STACK_UNIT = currentStackDescription.stackSize;
		
		if (reserved == null) {
			reserved = new int[currentStackDescription.stackNames.size()];
		}
		
		// prepare 
		taskList = new ArrayList<EEStacks.Tasks>();
		stackList = new ArrayList<EEStacks.StackDescr>();

		// check if single or multi stack
		Set<String> types = new HashSet<String>();
		final String defaultMultiStackPrefix;
		{
			String tmpPrefix = null;
			for (String cpuPrefix: currentCpuDataPrefixes) {
				String tpath = cpuPrefix + S + "MULTI_STACK";
				 
				ArrayList<String> child = new ArrayList<String>();
				ArrayList<String> tmps = CommonUtils.getAllChildrenEnumType(vt, tpath, child);
				if (tmps != null && tmps.size() > 0) {
					types.addAll(tmps);
					if (tmpPrefix == null) {
						tmpPrefix = tpath + child.get(0);
					}
					break;
				}
			}
			defaultMultiStackPrefix = tmpPrefix;
		}
		
		// if not one string -> send an exception
		if (types.size() != 1)
			throw new RuntimeException(
					"Stacks : Expected one and only one setting for OS/MULTI_STACK (found \n"
							+ types + ")");

		// take the maximum size of the sum of all stack's sizes
		int[] max_sizes =  new int[currentStackDescription.stackNames.size()];
		{
			//max_sizes = new int[currentStackDescription.stackNames.size()];
			
			int pos =0;
			for (Iterator<String> iter=currentStackDescription.stackNames.iterator(); iter.hasNext(); pos++) {
				
				String what = (String) iter.next();
				String[] tmp2 = parent.getCpuDataValue(ool, what);
				 

				if (tmp2 == null || tmp2.length == 0) {
					
					max_sizes[pos] = -1;
					
				} else {
					try {
						max_sizes[pos] = (Integer.decode(tmp2[0])).intValue();
					} catch (Exception e) {
						throw new RuntimeException("Stacks : Wrong "+what+" ("
								+ tmp2 + ") for stack size");
					}
				
					if ((max_sizes[pos] % STACK_UNIT) != 0) {
						Messages.sendWarningNl("Round stack size of cpu "+ cpuName +" ("
								+ max_sizes[pos] + ") to next multiple of "
								+ STACK_UNIT + " byte", null,
								"1872030128371023897", null);
						
						max_sizes[pos] += STACK_UNIT - (max_sizes[pos] % STACK_UNIT);
					}
				}
			}
		}
		
		/*
		 * add default shared stacks:
		 * If user specifies its size, use that value; otherwise uses available space.
		 */ 
		
		{
			int[] values = new int[currentStackDescription.stackNames.size()];
			int pos =0;
			for (Iterator<String> iter=currentStackDescription.sharedStackNames.iterator(); iter.hasNext(); pos++ ) {
				
				/*
				 * as default, set all sizes of shared stack to 0 
				 */
				values[pos] = 0;
				
				/* 
				 * check if user specifies some size
				 */ 
				String what = (String) iter.next();
				String[] tmp2 = parent.getCpuDataValue(ool, what);

				if (tmp2 != null && tmp2.length>0) {
					try {
						values[pos] = (Integer.decode(tmp2[0])).intValue();
					} catch (Exception e) {
						throw new RuntimeException("Stacks : Wrong "+what+" ("
								+ tmp2[0] + ") for shared stack size");
					}
					
					if ((values[pos] % STACK_UNIT) != 0) {
						Messages.sendWarningNl("Round shared stack size of cpu "+ cpuName +" ("
								+ values[pos] + ") to next multiple of "
								+ STACK_UNIT + " byte", null,
								"1872030128371023897", null);
						
						values[pos] += STACK_UNIT - (values[pos] % STACK_UNIT);
					}
					
				}

			}
			
			// store the shared stack
			stackList.add(new StackDescr(SHARED_STACK, values, 1));

		}

		int autoId = 0;

		{	
			/***************************************************************
			 * Stack for DUMMY thread
			 **************************************************************/
			String dummyPrefix = defaultMultiStackPrefix + "DUMMY_STACK";
			final String type;

			
			{	// compute STACK Type
				ArrayList<String> child = new ArrayList<String>();
				ArrayList<String> tmpType = CommonUtils.getAllChildrenEnumType(vt, dummyPrefix, child);
				
				if (tmpType == null) {
					// TODO: default value
					type = "SHARED";
				} else if (tmpType.size()>1) {
					throw new RuntimeException(
							"Stacks : Expected one and only one setting for DUMMY_STACK of cpu " + cpuName);
				} else {
					type = (String) tmpType.get(0);
					dummyPrefix += VARIANT_ELIST + child.get(0) + PARAMETER_LIST;
				}
			}
					

			// TODO : default value
			if (type.equals("") || type.equalsIgnoreCase("SHARED")) {
				idDummy = SHARED_STACK;
			} else if (type.equalsIgnoreCase("PRIVATE")) { //currentStackDescription.privateId)) {
				
				int[] values = new int[currentStackDescription.stackNames.size()];
				
				int pos =0;
				for (Iterator<String> iter=currentStackDescription.stackNames.iterator(); iter.hasNext(); ) {
					
					String what = (String) iter.next();
					String[] val = CommonUtils.getValue(vt, dummyPrefix + S + what);
					String tmp2 = val != null && val.length>0 ? val[0] : "";

					try {
						values[pos] = (Integer.decode(tmp2)).intValue();
					} catch (Exception e) {
						throw new RuntimeException("Stacks : Wrong "+what+" ("
								+ tmp2 + ") for Dummy_Stack");
					}
					if ((values[pos] % STACK_UNIT) != 0) {
						Messages.sendWarningNl("Dummy stack size of cpu "+ cpuName +" ("
								+ values[pos] + ") to next multiple of "
								+ STACK_UNIT + " byte", null,
								"18720301283710qwe7", null);
						
						values[pos] += STACK_UNIT - (values[pos] % STACK_UNIT);
					}
				
					pos++;
				}

				idDummy = new String("A" + autoId);
				autoId++;

				stackList.add(new StackDescr(idDummy, values, 1));
				
				
			} else {
				//throw new RuntimeException("Stacks : expected one of
				// SHARED or PRIVATE at OS/MULTI_STACK/TRUE/" + where);
				throw new RuntimeException(
						"Stacks : expected SHARED or PRIVATE at DUMMY_STACK of cpu "+ cpuName);
			}

			int index = Collections.binarySearch(taskList,
					IWritersKeywords.dummyName);
			if (index > -1) {
				throw new RuntimeException(
						"Stacks : multiple definition for Dummy stack of cpu "+ cpuName);
			}
			taskList.add(-index - 1, (new Tasks(IWritersKeywords.dummyName,
					idDummy)));

		} // END of dummy stack

		// sort all stack Description
		Collections.sort(stackList);

		/*******************************************************************
		 * stack for all OS APPLICATIONS
		 ******************************************************************/
		{
			String oilVarPrefix = (new OilPath(OilObjectType.OSAPPLICATION, null)).getPath();

			List<ISimpleGenRes> appls = ool.getList(IOilObjectList.OSAPPLICATION);
			for (ISimpleGenRes currAppl : appls) {
	
	
				String[] appl_paths = (String[]) currAppl.getObject(ISimpleGenResKeywords.OS_APPL_PATH);
				String sharedStack = S + oilVarPrefix + S
						+ APP_SHARED_STACK ;
				int shared = -1;
				{
					String[] val = CommonUtils.getValues(vt, addToAllStrings(appl_paths, sharedStack));
					
					if (val != null && val.length>0 && val[0] != null) {
						try {
							shared = (Integer.decode(val[0])).intValue();
						} catch (Exception e) {
							throw new RuntimeException("Stacks : Wrong value ("
									+ val[0] + ") for application " + currAppl.getName());
						}
						if ((shared % STACK_UNIT) != 0) {
							Messages.sendWarningNl("Round stack size of application "+currAppl.getName()+" ("
									+ shared + ") to next multiple of "
									+ STACK_UNIT + " byte", null,
									"187203ert71023897", null);
							
							shared += STACK_UNIT - (shared % STACK_UNIT);
						}
					} else {
						throw new RuntimeException("Stacks : Expected a shared stack (" + APP_SHARED_STACK + ") for application " + currAppl.getName());
					}
				}

				String irqStack = currAppl.getPath() + S + oilVarPrefix + S
						+ APP_IRQ_SIZE;

				int irq = -1;
				{
					String[] val = CommonUtils.getValue(vt, irqStack);
					
					if (val != null && val.length>0 && val[0] != null) {
						try {
							irq = (Integer.decode(val[0])).intValue();
						} catch (Exception e) {
							throw new RuntimeException("Stacks : Wrong value ("
									+ val[0] + ") for application " + currAppl.getName());
						}
						if ((irq % STACK_UNIT) != 0) {
							Messages.sendWarningNl("Round stack size of application "+currAppl.getName()+" ("
									+ irq + ") to next multiple of "
									+ STACK_UNIT + " byte", null,
									"187203ert71023897", null);
							
							irq += STACK_UNIT - (irq % STACK_UNIT);
						}
					} else {
						throw new RuntimeException("Stacks : Expected an irq stack (" + APP_IRQ_SIZE + ") for application " + currAppl.getName());
					}
				}

				if (shared != -1) {
					String idSt = new String("A" + autoId);
					autoId++;
	
					// store size
					stackList.add(new StackDescr(idSt, new int[]{shared}, 1, currAppl.getName()));
	
					
					int index = Collections.binarySearch(taskList, APPLICATION_SHARED_PREFIX + currAppl
							.getName());
					if (index > -1) {
						throw new RuntimeException(
								"Stacks : multiple definition for a task ("
										+ currAppl.getName() + ")");
					}
					taskList.add(-index - 1, (new Tasks(APPLICATION_SHARED_PREFIX + currAppl.getName(), idSt)));
				} else {
					throw new RuntimeException(
							"Stacks : missing " + APP_SHARED_STACK + " for OsApplication " + 
									currAppl.getName());					
				}

				if (irq != -1) {
					String idSt = new String("A" + autoId);
					autoId++;
	
					/** even if no isr, start counting from 1 */
					int numOfIsr = currAppl.containsProperty(ISimpleGenResKeywords.OS_APPL_LIST_REF_ISR) ? ((ArrayList) currAppl.getObject(ISimpleGenResKeywords.OS_APPL_LIST_REF_ISR)).size() : 0;
					if (numOfIsr <1) numOfIsr = 1;
					
					// store size
					stackList.add(new StackDescr(idSt, new int[]{irq}, numOfIsr, currAppl.getName()));
	
					
					int index = Collections.binarySearch(taskList, APPLICATION_IRQ_PREFIX + currAppl
							.getName());
					if (index > -1) {
						throw new RuntimeException(
								"Stacks : multiple definition for a task (" +APPLICATION_IRQ_PREFIX
										+ currAppl.getName() + "): the same name is used also to identify irq stack");
					}
					taskList.add(-index - 1, (new Tasks(APPLICATION_IRQ_PREFIX + currAppl.getName(), idSt)));
				} else {
					throw new RuntimeException(
							"Stacks : missing " + APP_IRQ_SIZE + " for OsApplication " + 
									currAppl.getName());					
				}

			}
		}
		

		// sort all stack Description
		Collections.sort(stackList);

		/*******************************************************************
		 * stack for all TASKS
		 ******************************************************************/
		List<ISimpleGenRes> tasks = ool.getList(IOilObjectList.TASK);
		for (Iterator<ISimpleGenRes> iter = tasks.iterator(); iter.hasNext();) {

			ISimpleGenRes currTask = (ISimpleGenRes) iter.next();

			String idSt; // store User and System task's id

			String oilVarPrefix = (new OilPath(OilObjectType.TASK, null)).getPath();

			String threadStack = currTask.getPath() + S + oilVarPrefix + S
					+ "STACK" ;

			final String type;
			{
				ArrayList<String> child = new ArrayList<String>();
				ArrayList<String> tmpType = CommonUtils.getAllChildrenEnumType(vt, threadStack, child);
				
				if (tmpType == null) {
					// TODO: default value
					type = "SHARED";
				} else if (tmpType.size()>1) {
					throw new RuntimeException(
							"Stacks : Expected one and only one setting for OS/TASK/STACK"
									+ "; task name = " + currTask.getName());
				} else {
					type = (String) tmpType.get(0);
//					threadStack += VARIANT_ELIST + child.get(0)+ PARAMETER_LIST;
				}
				
			}

			if (type.equalsIgnoreCase("SHARED")) {
				idSt = SHARED_STACK;
				
				// check if this task has events.
				if ("true".equals(currTask.getString(ISimpleGenResKeywords.TASK_EXTENDED))) {
					throw new RuntimeException(
							"Stacks : Task "+currTask.getName()
							+" uses events but has a shared stack. The stack must be private");
				}
				
				// store the "Stack type" into the Task structure
				currTask.setProperty(ISimpleGenResKeywords.TASK_STACK, ISimpleGenResKeywords.TASK_STACK_SHARED);
				
				
				// check if this task is connected to a specific OS_application
				if (currTask.containsProperty(ISimpleGenResKeywords.TASK_OS_APPLICATION_NAME)) {
					String os_appl_id = APPLICATION_SHARED_PREFIX + currTask.getString(ISimpleGenResKeywords.TASK_OS_APPLICATION_NAME);
					
					int index = Collections.binarySearch(taskList, os_appl_id);
					if (index > -1) {
						idSt = taskList.get(index).getStackId();
					}
				}
				
				incrKernelStack(idSt);

			} else if (type.equalsIgnoreCase(currentStackDescription.privateId)) {

				int[] values = new int[currentStackDescription.stackNames.size()];
				int pos =0;
				for (Iterator<String> iter2=currentStackDescription.stackNames.iterator(); iter2.hasNext(); ) {
					
					String what = (String) iter2.next();
					String[] val = CommonUtils.getValue(vt, threadStack + S + what);
					String tmp2 = val != null && val.length>0 ? val[0] : "";

					try {
						values[pos] = (Integer.decode(tmp2)).intValue();
					} catch (Exception e) {
						throw new RuntimeException("Stacks : Wrong "+what+" ("
								+ tmp2 + ") for task " + currTask.getName());
					}
					if ((values[pos] % STACK_UNIT) != 0) {
						Messages.sendWarningNl("Round stack size of task "+currTask.getName()+" ("
								+ values[pos] + ") to next multiple of "
								+ STACK_UNIT + " byte", null,
								"187203ert71023897", null);
						
						values[pos] += STACK_UNIT - (values[pos] % STACK_UNIT);
					}
				
					pos++;
				}

				idSt = new String("A" + autoId);
				autoId++;

				String os_appl_id = null;
				if (currTask.containsProperty(ISimpleGenResKeywords.TASK_OS_APPLICATION_NAME)) {
					os_appl_id = currTask.getString(ISimpleGenResKeywords.TASK_OS_APPLICATION_NAME);
				}

				// store size
				stackList.add(new StackDescr(idSt, values, 1, os_appl_id));

				// store the "Stack type" into the Task structure
				currTask.setProperty(ISimpleGenResKeywords.TASK_STACK, ISimpleGenResKeywords.TASK_STACK_PRIVATE);
				
			} else {
				throw new RuntimeException(
						"Stacks : expected one of SHARED or "+currentStackDescription.privateId+" at  OS/TASK/STACK"
								+ "; task name = " + currTask.getName());
			}

			int index = Collections.binarySearch(taskList, currTask
					.getName());
			if (index > -1) {
				throw new RuntimeException(
						"Stacks : multiple definition for a task ("
								+ currTask.getName() + ")");
			}
			taskList.add(-index - 1, (new Tasks(currTask.getName(), idSt)));

		}
		// sort all stack Description
		Collections.sort(stackList);
		
		{ // compute shared stack size
			StackDescr sharedStack = null;
			int[] sharedStackSize = null;
			
			// prepare the vector with the sum of all sizes
			int[] sum = new int[currentStackDescription.stackNames.size()];
			for (int i=0; i<sum.length; i++) {
				sum[i] = 0;
			}
			
			// search the shared stack and compute the sum
			for (int i=0; i<stackList.size(); i++) {
				StackDescr sd = (StackDescr) stackList.get(i);
				
				if (SHARED_STACK.equals(sd.getId())){
					sharedStack = sd;
					sharedStackSize = sd.getSize();
				} else {
					int[] val = sd.getSize();
					for (int si=0; si<sum.length; si++) {
						sum[si] += val[si];
					}
				}
			}
			
			/*
			 * Check that each stack segment is bigger than required 
			 */
			for (int si=0; si<sum.length; si++) {
				// add to required space also fixed shared Stack Sizes
				int plus = (sharedStackSize!= null ?sharedStackSize[si]:0); 
				if (max_sizes[si] >0 && (sum[si]+ plus)>(max_sizes[si]-reserved[si])) {
					
					
					throw new RuntimeException(
							"Stacks : is required a bigger stack for cpu "+cpuName+":\n\tStack type = "
							+ currentStackDescription.stackNames.get(si) 
							+ "\n\tAvailable space = " + max_sizes[si]
							+ "\n\tReserved space for special stacks = " + reserved[si]
							+ "\n\tRequired space by private stacks  = " + sum[si]
							+ (
							  sharedStack == null ? "" : 
							  "\n\tRequired by shared stack          = " + plus)
							);
				}
			}
			
			
			/*
			 * Compute the size of shared stack 
			 */
			if (sharedStack != null) {
				int[] newDim = new int[currentStackDescription.stackNames.size()];
				for (int si=0; si<sum.length; si++) {
				
					// always the required mininum size of shared stack is bigger than 
					// stack_size - (all_private_stack + reserved)
					
					if (false && sharedStackSize != null && sharedStackSize[si] !=0) {
						// if (FALSE ...) -> always shared stack greed available space 
						newDim[si] = sharedStackSize[si];
						
					} else if (max_sizes[si] <0) {
						newDim[si] = 0; // value not defined 
						
					} else if (sum[si] == (max_sizes[si]-reserved[si])) {
					
						
						String txt = sharedStackSize[si] == 0 ? 
								"1" :
								"" + sharedStackSize[si] ;
						throw new RuntimeException(
								"Stacks : No space left for shared stack for cpu "+cpuName+":\n\tStack type = "
								+ currentStackDescription.stackNames.get(si) 
								+ "\n\tAvailable space = " + max_sizes[si]
								+ "\n\tReserved space for special stacks   = " + reserved[si]
								+ "\n\tRequired space by private stacks    = " + sum[si]
								+ "\n\tRequired by shared stack (at least) = " + txt);
					} else {
						// Set shared stack size equals to available space
						newDim[si] = max_sizes[si] - sum[si] - reserved[si];
					}
				}
				
				sharedStack.setSize(newDim);
			}
		}
		
	}
	
	private void incrKernelStack(String idSt) {
		// search the shared stack and compute the sum
		for (int i=0; i<stackList.size(); i++) {
			StackDescr sd = (StackDescr) stackList.get(i);
			
			if (idSt.equals(sd.getId())){
				sd.incrKernelSize();
			}
		}
	}
	
	/**
	 * Set a new rule about dummy stack : 
	 * if always the first or the last, or if it's always present.
	 * 
	 * Example : always present as first (FORCE_ALWAYS | FORCE_FIRST)
	 * 
	 * @return the old rule 
	 * */
	public int setDummyStackPolicy(int newRule) {
		int old = dummyStackPolicy;
		
		if ((newRule & FORCE_FIRST)!=0 && (newRule & FORCE_LAST)!=0) {
			throw new RuntimeException("Cannot use FORCE_FIRST and FORCE_LAST at the same time");
		}
		
		dummyStackPolicy = newRule;
		
		return old;
	}

	/**
	 * Returns the size of ( <b>Distinct </b>) stacks used by given task
	 * lisk.
	 * 
	 * @param tNames
	 *            the task's names
	 * 
	 * @return the size of ( <b>Distinct </b>) stacks used by given tasks
	 *         and, as last object, the total size of stacks <br>
	 *         (for the link between a task and its stacks, use
	 *         {@link #taskStackLink taskStackLink};<br>
	 *         second index identifies all stack of the same task (see {@link #CPU_HW_DESCRIPTION STACK_KEYWORDS})
	 * 
	 * @throws NullPointerException
	 *             if tNames is null
	 * @throws RuntimeException
	 *             if there isn't any task with given name
	 */
	public int[][] stackSize(String[] tNames) {

		ArrayList<StackDescr> stacks = computeStacks(tNames);

		// prepare the list of offset
		// and calc tot stack sizes:
		int risp[][];
		risp = new int[stacks.size()][];

		// search taskId in already stored stack
		for (int j = 0; j < stacks.size(); j++) {
			int tmp[] = ((StackDescr) stacks.get(j)).getSize();

			risp[j] = new int[currentStackDescription.stackNames.size()];
			for (int i=0; i<currentStackDescription.stackNames.size(); i++) {
				risp[j][i] = tmp[i];
			}
			
		}

		// then ... finish
		return risp;
	}
	
	/**
	 * Returns the size of ( <b>Distinct </b>) kernel stacks used by given task
	 * lisk.
	 * 
	 * @param tNames
	 *            the task's names
	 * 
	 * @return the size of ( <b>Distinct </b>) kernel stacks used by given tasks
	 * 
	 * @throws NullPointerException
	 *             if tNames is null
	 * @throws RuntimeException
	 *             if there isn't any task with given name
	 */
	public int[] stackSysSize(String[] tNames) {

		ArrayList<StackDescr> stacks = computeStacks(tNames);

		// prepare the list of offset
		// and calc tot stack sizes:
		int risp[] = new int[stacks.size()];
		
		for (int j = 0; j < stacks.size(); j++) {
			risp[j] = ((StackDescr) stacks.get(j)).getKernelSize();
		}

		// then ... finish
		return risp;
	}

	/**
	 * Returns the offset of ( <b>Distinct </b>) stacks used by given task
	 * lisk.
	 * 
	 * @param tNames
	 *            the task's name
	 * 
	 * @return the size of ( <b>Distinct </b>) stacks used by given tasks
	 *         and, as last object, the total size of stacks <br>
	 *         (for the link between a task and its stacks, use
	 *         {@link #taskStackLink taskStackLink};<br>
	 *         second index identifies user stack (0) and system stack (1);
	 *         the last item contains the amount of memory required by all
	 *         stacks)
	 * 
	 * @throws NullPointerException
	 *             if tNames is null
	 * @throws RuntimeException
	 *             if there isn't any task with given name
	 */
	public int[][] taskOffsets(String[] tNames) {

		ArrayList<StackDescr> stacks = computeStacks(tNames);

		// prepare the list of offset
		// and calc tot stack sizes:
		int risp[][];
		risp = new int[stacks.size() + 1][];

		int offset[] = new int[currentStackDescription.stackNames.size()];
		for (int i=0; i<offset.length; i++) {
			offset[i] = 0;
		}

		// search taskId in already stored stack
		for (int j = 0; j < stacks.size(); j++) {
			int tmp[] = ((StackDescr) stacks.get(j)).getSize();

			risp[j] = new int[currentStackDescription.stackNames.size()];
			for (int i=0; i<offset.length; i++) {
				risp[j][i] = offset[i];
				offset[i] += tmp[i];
			}
		}
		risp[risp.length - 1] = offset;

		// then ... finish
		return risp;
	}

	/**
	 * Returns the link between a task and its stack offset. For stack
	 * offset use {@link #taskOffsets taskOffsets}
	 * 
	 * @param tNames
	 *            the task's name
	 * 
	 * @return for each task, the index used in taskOffset function to store
	 *         its stacks offset
	 * 
	 * @throws NullPointerException
	 *             if tNames is null
	 * @throws RuntimeException
	 *             if there isn't any task with given name
	 */
	public int[] taskStackLink(String[] tNames) {

		int risp[];
		risp = new int[tNames.length];

		// get all stacks required by those tasks
		ArrayList<StackDescr> stacks = computeStacks(tNames);

		// for each task, search its stack
		for (int i = 0; i < tNames.length; i++) {
			// search taskId
			int index = Collections.binarySearch(taskList, tNames[i]);
			if (index < 0) {
				throw new RuntimeException(
						"taskStackLink : There isn't any task with given name ("
								+ tNames[i] + ")");
			}

			String tmpId = ((Tasks) taskList.get(index)).getStackId();
			boolean trovato = false;

			// search taskId in already stored stack
			for (int j = 0; j < stacks.size(); j++) {
				if (((StackDescr) stacks.get(j)).getId().equals(tmpId)) {
					risp[i] = j;
					trovato = true;
					break;
				}
			}

			if (!trovato) { // search in Not already stored stack
				throw new RuntimeException(
						"taskStackLink : There isn't any stack for this task:"
								+ tNames[i]);
			}
		}

		// then ... finish
		return risp;
	}

	/**
	 * Returns the memory partition id for each ( <b>Distinct </b>) stacks used
	 * by given task list. Note that some id can be null.
	 * 
	 * @param tNames
	 *            the task's names
	 * 
	 * @return the memory partition id of ( <b>Distinct </b>) stacks used by
	 *         given tasks and, as last object, the total size of stacks <br>
	 *         (for the link between a task and its stacks, use
	 *         {@link #taskStackLink taskStackLink};<br>
	 *         second index identifies all stack of the same task (see
	 *         {@link #CPU_HW_DESCRIPTION STACK_KEYWORDS})
	 * 
	 * @throws NullPointerException
	 *             if tNames is null
	 * @throws RuntimeException
	 *             if there isn't any task with given name
	 */
	public String[] stackMemoryId(String[] tNames) {

		ArrayList<StackDescr> stacks = computeStacks(tNames);
		String answer[] = new String[stacks.size()];

		// for each stack, get the id
		for (int j = 0; j < stacks.size(); j++) {
			answer[j] = ((StackDescr) stacks.get(j)).getApplicationId();
		}

		// then ... finish
		return answer;
	}

	
	/**
	 * Compute the list of stacks required by specified task list
	 * 
	 * @return a not null ArrayList of StackDescr.
	 */
	protected ArrayList<StackDescr> computeStacks(String[] tNames) {
		if (tNames == null) {
			throw new NullPointerException(
					"Stacks: Given a null list of tasks");
		}

		ArrayList<StackDescr> stacks = new ArrayList<StackDescr>();
		
		/*
		 *  Add Shared Stack if required
		 */
		if ((dummyStackPolicy & FORCE_ALWAYS) != 0) {
			int index = Collections.binarySearch(stackList, idDummy);

			if (index != -1) {
					stacks.add(stackList.get(index));
			} else {
				throw new RuntimeException("not found shared stack");
			}
		}

		/*
		 *  make a temp list of stacks
		 */
		for (int i = 0; i < tNames.length; i++) {
			// search taskId
			int index = Collections.binarySearch(taskList, tNames[i]);
			if (index < 0) {
				throw new RuntimeException(
						"Stacks : There isn't any task with given name ("
								+ tNames[i] + ")");
			}

			String tmpId = ((Tasks) taskList.get(index)).getStackId();
			boolean found = false;

			// search taskId in already stored stack
			for (int j = 0; j < stacks.size(); j++) {
				if (((StackDescr) stacks.get(j)).getId().equals(tmpId)) {
					found = true;
					break;
				}
			}

			if (!found) { // search in Not already stored stack
				index = Collections.binarySearch(stackList, tmpId);
				if (index < 0) {
					throw new RuntimeException(
							"taskOffsets : There isn't any stack for this task:"
									+ tNames[i]);
				}

				// store this new stack
				stacks.add(stackList.get(index));
			}
		}
		
		
		/*
		 * Reorder if required (as FIRST or LAST) 
		 */
		if ((dummyStackPolicy & FORCE_FIRST) != 0 || (dummyStackPolicy & FORCE_LAST) != 0 ) {
			int index = -1;
			
			for (int j = 0; j < stacks.size(); j++) {
				if (((StackDescr) stacks.get(j)).getId().equals(idDummy)) {
					index = j;
					break;
				}
			}
			
			// only if exist
			if (index != -1) {
				StackDescr o = stacks.remove(index);
				
				if ((dummyStackPolicy & FORCE_FIRST) != 0) {
					// FIRST
					stacks.add(0, o);
					
				} else {
					// LAST
					stacks.add(stacks.size(), o);
				}
			}
		}

		return stacks;

	}

	/** Makes a new copy of this object. */
	public Object clone() {
		EEStacks tmp = new EEStacks(parent);

		// costant objects
		tmp.taskList = taskList;
		tmp.stackList = stackList;
		tmp.currentStackDescription = currentStackDescription;

		return tmp;
	}
}
