package com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.eu.evidence.rtdruid.desk.Messages;
import com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.ErikaEnterpriseWriter;
import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.ISimpleGenResKeywords;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.abstractions.ISimpleGenRes;
import com.eu.evidence.rtdruid.modules.oil.abstractions.SimpleGenRes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.AbstractRtosWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SectionWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.FileTypes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.ICommentWriter;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEWriterKeywords;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractObjectsExtentions;

public class SectionWriterIsr implements IEEWriterKeywords, IExtractObjectsExtentions {
	
	public static enum ShareType {
		None, CommonOnly, All;
	}
	
	private static final String ISR_DISABLE_ENTRY = "isr_disable_entry";
	protected Set<String> entries;
	protected final String hw_id;
	
	protected Boolean checked;
	protected ShareType sharedInterruptController = ShareType.None;
	protected boolean generateDefineCategory = false;
	protected boolean generateDefineIsrId = false;
	protected boolean computeEntryFromPriority = false;
	protected boolean computeIDFromPriority = false;
	protected boolean enableOsAppRpcIsr = false;
	protected int rpcIsrId = 0;
	
	protected final ErikaEnterpriseWriter parent;

	
	public SectionWriterIsr(ErikaEnterpriseWriter parent, String hw_id) {
		this.parent = parent;
		this.hw_id = hw_id;
		entries = null;
		checked = null;
	}
	
	/**
	 * @param sharedInterruptController the sharedInterruptController to set
	 */
	public void setSharedInterruptController(ShareType sharedInterruptController) {
		this.sharedInterruptController = sharedInterruptController;
	}

	/**
	 * @param generateDefineCategory the generateDefineCategory to set
	 */
	public void setGenerateDefineCategory(boolean generateDefineCategory) {
		this.generateDefineCategory = generateDefineCategory;
	}
	
	/**
	 * @param generateDefineIsrId the generateDefineIsrId to set
	 */
	public void setGenerateDefineIsrId(boolean generateDefineIsrId) {
		this.generateDefineIsrId = generateDefineIsrId;
	}
	
	/**
	 * @param computeEntryFromPriority the computeEntryFromPriority to set
	 */
	public void setComputeEntryFromPriority(boolean computeEntryFromPriority) {
		this.computeEntryFromPriority = computeEntryFromPriority;
	}
	
	/**
	 * @param computeIDFromPriority the computeIDFromPriority to set
	 */
	public void setComputeIDFromPriority(boolean computeIDFromPriority) {
		this.computeIDFromPriority = computeIDFromPriority;
	}
	
	public void setEnableOsAppRpcIsr(boolean enableOsAppRpcIsr) {
		this.enableOsAppRpcIsr = enableOsAppRpcIsr;
	}
	
	public void setRpcIsrId(int rpcIsrId) {
		this.rpcIsrId = rpcIsrId;
	}
	
	public void setValidEntries(Set<String> entries) {
		if (entries == null) {
			this.entries = null;
		} else {
			this.entries = new LinkedHashSet<String>();
			this.entries.addAll(entries);
		}
	}

	public void setValidEntries(String[] entries) {
		if (entries == null) {
			this.entries = null;
		} else {
			this.entries = new LinkedHashSet<String>();
			this.entries.addAll(Arrays.asList(entries));
		}
	}
	
	protected boolean checkStaticIsrTable(int currentRtosId) {
		if (checked == null) {
			checked = checkStaticIsrTable(parent, currentRtosId);
		}
		return checked.booleanValue();
	}
	public static boolean checkStaticIsrTable(ErikaEnterpriseWriter parent, int currentRtosId) {
		boolean answer = true;
		String[] existing = parent.extractUserOptions(currentRtosId);
		for (String s: existing) {
			if ("EE_ISR_DYNAMIC_TABLE".equals(s)) {
				answer = Boolean.FALSE;
				break;
			}
		}
		return answer;
	}


	
	public void writeIsr(int currentRtosId, IOilObjectList ool, IOilWriterBuffer oilWBuff) throws OilCodeWriterException {
		writeIsr(null, currentRtosId, ool, oilWBuff);
	}
	public void writeIsr(IOilObjectList[] oilObjects, int currentRtosId, IOilObjectList ool, IOilWriterBuffer oilWBuff) throws OilCodeWriterException {

		if (checkStaticIsrTable(currentRtosId)) {
			
			List<List<ISimpleGenRes>> allIsr = new LinkedList<List<ISimpleGenRes>>();
			switch (sharedInterruptController) {
			case None:
			case CommonOnly: // the same as None, but the priority should be set with "shared" flag
				if (ool.getList(IOilObjectList.ISR).size()>0) {
					allIsr.add(ool.getList(IOilObjectList.ISR));
				}
				break;
			case All:
				for (IOilObjectList list : oilObjects) {
					if (list.getList(IOilObjectList.ISR).size()>0) {
						allIsr.add(list.getList(IOilObjectList.ISR));
					}
				}
				break;
			default:
				
			}
	
			if (allIsr.size()>0) {
				final StringBuffer buffer = oilWBuff.get(FILE_EE_CFG_H);
				final ICommentWriter commentWriterH = SectionWriter.getCommentWriter(ool, FileTypes.H);
				Set<String> filterId = new HashSet<String>();
		
				buffer.append(commentWriterH.writerBanner("ISR definition")); // \n");
				for (List<ISimpleGenRes> isrList : allIsr) {
					doWriteIsrs(isrList, buffer, commentWriterH, filterId);
				}
			}
		}
	}

	/**
	 * @param isrList
	 * @param buffer
	 * @param commentWriterH
	 * @throws OilCodeWriterException
	 */
	public void doWriteIsrs(List<ISimpleGenRes> isrList, final StringBuffer buffer, final ICommentWriter commentWriterH, Set<String> filterId)
			throws OilCodeWriterException {
		for (ISimpleGenRes curr : isrList) {
			boolean trap = curr.containsProperty(ISimpleGenResKeywords.ISR_TRAP) ? ((Boolean) curr.getObject(ISimpleGenResKeywords.ISR_TRAP)).booleanValue() : false;
			String category = curr.containsProperty(ISimpleGenResKeywords.ISR_CATEGORY) ? curr.getString(ISimpleGenResKeywords.ISR_CATEGORY) : "";
			if (trap || "3".equals(category)) {
				
				IsrInfo info = new IsrInfo();
				info.category = category;
				info.name = curr.getName();
				info.handler = curr.getString(ISimpleGenResKeywords.ISR_GENERATED_HANDLER);
				info.entry_id = curr.getString(ISimpleGenResKeywords.ISR_GENERATED_ENTRY);
				info.disable = curr.containsProperty(ISR_DISABLE_ENTRY) && "true".equalsIgnoreCase(curr.getString(ISR_DISABLE_ENTRY));
			
				doWriteTrap(buffer, commentWriterH, info);
				
			} else if ("1".equals(category) || "2".equals(category)) {

				String entry_id = curr.getString(ISimpleGenResKeywords.ISR_GENERATED_ENTRY);
				if (!filterId.contains(entry_id)) {
					filterId.add(entry_id);

					IsrInfo info = new IsrInfo();
					info.category = category;
					info.name = curr.getName();
					info.handler = curr.getString(ISimpleGenResKeywords.ISR_GENERATED_HANDLER);
					info.entry_id = curr.getString(ISimpleGenResKeywords.ISR_GENERATED_ENTRY);
					info.disable = curr.containsProperty(ISR_DISABLE_ENTRY) && "true".equalsIgnoreCase(curr.getString(ISR_DISABLE_ENTRY));
					info.generated_prioid = curr.containsProperty(ISimpleGenResKeywords.ISR_GENERATED_PRIOID) ? curr.getString(ISimpleGenResKeywords.ISR_GENERATED_PRIOID): null;
					info.generated_isrid = curr.containsProperty(ISimpleGenResKeywords.ISR_ID_TXT) ? curr.getString(ISimpleGenResKeywords.ISR_ID_TXT): null;
					info.generated_prio_string = curr.containsProperty(ISimpleGenResKeywords.ISR_GENERATED_PRIORITY_STRING) ? curr.getString(ISimpleGenResKeywords.ISR_GENERATED_PRIORITY_STRING): null;

					doWriteIsr12(buffer, commentWriterH, info);
				}
			} else {
				buffer.append(commentWriterH.writerSingleLineComment("Unknow ISR Category: " + curr.getName()));
			}
		}
	}
	
	public static class IsrInfo {

		public String name;
		public String category;
		public String handler;
		public String entry_id;
		public boolean disable;
		
		public String generated_isrid;
		public String generated_prioid;
		public String generated_prio_string;
		

	}
	

	/**
	 * @param buffer
	 * @param commentWriterH
	 * @param curr
	 * @throws OilCodeWriterException
	 */
	protected void doWriteTrap(final StringBuffer buffer, final ICommentWriter commentWriterH, IsrInfo info)
			throws OilCodeWriterException {
		
		if (entries != null) {
			if (!entries.contains(info.entry_id)) {
				throw new OilCodeWriterException("Found a not valid isr entry: " + info.entry_id + " (ISR " + info.name + ")");
			}
		}

		ArrayList<String> tempStrings = new ArrayList<String>();
		tempStrings.add("#define " + info.entry_id + " " + info.handler+"\n");

		if (info.disable){
			Messages.sendWarningNl("Disabling static ISR define for " + info.name);
			for (int i=0; i<tempStrings.size(); i++) {
				tempStrings.set(i, 
						commentWriterH.writerSingleLineComment(tempStrings.get(i)));
			}
		}
		
		for (String s: tempStrings) {
			buffer.append(s);
		}
	}

	/**
	 * @param buffer
	 * @param commentWriterH
	 * @param curr
	 * @throws OilCodeWriterException
	 */
	void doWriteIsr12(final StringBuffer buffer, final ICommentWriter commentWriterH, IsrInfo info)
			throws OilCodeWriterException {
		
		if (entries != null) {
			if (!entries.contains(info.entry_id)) {
				throw new OilCodeWriterException("Found a not valid isr entry: " + info.entry_id + " (ISR " + info.name + ")");
			}
		}
	
		ArrayList<String> tempStrings = new ArrayList<String>();
		tempStrings.add("#define " + info.entry_id + " " + info.handler+"\n");
		if (info.generated_prioid != null && info.generated_prio_string != null) {
			tempStrings.add("#define " + info.generated_prioid + " " + info.generated_prio_string+"\n");
		}
	
		if (generateDefineCategory) {
			tempStrings.add("#define " + info.entry_id + "_CAT "+info.category+"\n");
		}
		
		if (generateDefineIsrId && info.generated_isrid !=null) {
			tempStrings.add("#define EE_ISR"+("1".equals(info.category)?"":"2")+"_ID_" + info.handler + " " +info.generated_isrid+"\n");
		}
	
		if (info.disable){
			Messages.sendWarningNl("Disabling static ISR define for " + info.name);
			for (int i=0; i<tempStrings.size(); i++) {
				tempStrings.set(i, 
						commentWriterH.writerSingleLineComment(tempStrings.get(i)));
			}
		}
		
		for (String s: tempStrings) {
			buffer.append(s);
		}
	}
	
	@Override
	public void updateObjects() {
		int rtosId = -1;
		for (IOilObjectList ool : parent.getOilObjects()) {
			rtosId ++;
			int max_level = 0;
			int isr2ResNumber = 0;
			int isr2Number = 0;
			int starting_isr_id = 0;
//			{
//				Object o = AbstractRtosWriter.getOsObject(ool, ISimpleGenResKeywords.OS_CPU__ISR2_ADDITIONAL);
//				isr2Number += (o == null ? 0 : ((Integer) o).intValue()) ;
//			}
			
			if (enableOsAppRpcIsr && parent.getOilObjects().length >1 && parent.checkKeyword(IWritersKeywords.KERNEL_OS_APPLICATION)) {
				ArrayList<ISimpleGenRes> tempList = new ArrayList<ISimpleGenRes>();
				
				Object obj = AbstractRtosWriter.getOsObject(ool, ISimpleGenResKeywords.OS_CPU__ISR2_ADDITIONAL_SGR_LIST);
				if (obj != null) {
					tempList.addAll((ArrayList) obj);
				}
				
				ISimpleGenRes sgr = new SimpleGenRes("Internally defined", null);
				sgr.setObject(ISimpleGenResKeywords.ISR_ID, new Integer(rpcIsrId));
				sgr.setProperty(ISimpleGenResKeywords.ISR_GENERATED_HANDLER, "EE_"+hw_id+"_iirq_handler");
				sgr.setProperty(ISimpleGenResKeywords.ISR_CATEGORY, "2");
				tempList.add(sgr);
				
				for (ISimpleGenRes os : ool.getList(IOilObjectList.OS)) {
					os.setObject( ISimpleGenResKeywords.OS_CPU__ISR2_ADDITIONAL_SGR_LIST, tempList);
				}
				
				starting_isr_id += tempList.size();
			}

			for (ISimpleGenRes sgr: ool.getList(IOilObjectList.ISR)) {
				String category = sgr.containsProperty(ISimpleGenResKeywords.ISR_CATEGORY) ? sgr.getString(ISimpleGenResKeywords.ISR_CATEGORY) : "";
				boolean isIsr1 = "1".equals(category);
				boolean isIsr2 = "2".equals(category);
				boolean trap = sgr.containsProperty(ISimpleGenResKeywords.ISR_TRAP) ? ((Boolean) sgr.getObject(ISimpleGenResKeywords.ISR_TRAP)).booleanValue() : false;
				if (trap || "3".equals(category)) {
					
					final String entry_id;
					{
						final String entry = sgr.containsProperty(ISimpleGenResKeywords.ISR_ENTRY) ? sgr.getString(ISimpleGenResKeywords.ISR_ENTRY) : "";
						final String level = sgr.containsProperty(ISimpleGenResKeywords.ISR_LEVEL) ? sgr.getString(ISimpleGenResKeywords.ISR_LEVEL) : "";
						String text = "";
						if (entry == null || entry.length() == 0) {
							if (level == null || level.length() == 0) {
								Messages.sendWarningNl("Missing ISR ENTRY and LEVEL for isr " + sgr.getName());
								sgr.setProperty(ISR_DISABLE_ENTRY, "true");
							} else {
								text = level;
							}
						} else {
							if (level == null || entry.length() == 0) {
								Messages.sendWarningNl("ISR LEVEL is override by ISR ENTRY for isr " + sgr.getName());
							}
							text = entry;
						}
						entry_id = "EE_"+hw_id+"_"+text+"_TRAP";
					}
					sgr.setProperty(ISimpleGenResKeywords.ISR_GENERATED_ENTRY, entry_id);
					
					{ // handler
						String handler = sgr.containsProperty(ISimpleGenResKeywords.ISR_HANDLER) ? sgr.getString(ISimpleGenResKeywords.ISR_HANDLER) : sgr.getName();
						sgr.setProperty(ISimpleGenResKeywords.ISR_GENERATED_HANDLER, handler);
					}
					
				
				} else if (isIsr1 || isIsr2) {
					
					final String entry_id;
					if (computeEntryFromPriority) {
						
						if (sgr.containsProperty(ISimpleGenResKeywords.ISR_USER_PRIORITY)) {
							String priority = sgr.getString(ISimpleGenResKeywords.ISR_USER_PRIORITY);
							
							if (sgr.containsProperty(ISimpleGenResKeywords.ISR_ENTRY) &&
									!priority.equals(sgr.getString(ISimpleGenResKeywords.ISR_ENTRY))) {
								Messages.sendWarningNl("ISR ENTRY and ISR PRIORITY of isr " + sgr.getName() + " does not contain the same value. Using the PRIORITY", null, "isr01", null);
							}
							
							entry_id = "EE_"+hw_id+"_"+sgr.getString(ISimpleGenResKeywords.ISR_GENERATED_PRIORITY_VALUE)+"_ISR";
							
						} else {
							Messages.sendWarningNl("Missing ISR PRIORITY for isr " + sgr.getName(), null, "isr01", null);
							sgr.setProperty(ISR_DISABLE_ENTRY, "true");
							entry_id = "";
						}
						
					} else {
						final String entry = sgr.containsProperty(ISimpleGenResKeywords.ISR_ENTRY) ? sgr.getString(ISimpleGenResKeywords.ISR_ENTRY) : "";
						final String level = sgr.containsProperty(ISimpleGenResKeywords.ISR_LEVEL) ? sgr.getString(ISimpleGenResKeywords.ISR_LEVEL) : "";
						String text = "";
						if (entry == null || entry.length() == 0) {
							if (level == null || level.length() == 0) {
								Messages.sendWarningNl("Missing ISR ENTRY and LEVEL for isr " + sgr.getName());
								sgr.setProperty(ISR_DISABLE_ENTRY, "true");
							} else {
								text = level;
							}
						} else {
							if (level == null || entry.length() == 0) {
								Messages.sendWarningNl("ISR LEVEL is override by ISR ENTRY for isr " + sgr.getName());
							}
							text = entry;
						}
						
						entry_id = "EE_"+hw_id+"_"+text+"_ISR";

					}
					sgr.setProperty(ISimpleGenResKeywords.ISR_GENERATED_ENTRY, entry_id);

					String prioId = entry_id+"_PRI";
					sgr.setProperty(ISimpleGenResKeywords.ISR_GENERATED_PRIOID, prioId);

					
					{ // handler
						String handler = sgr.containsProperty(ISimpleGenResKeywords.ISR_HANDLER) ? sgr.getString(ISimpleGenResKeywords.ISR_HANDLER) : sgr.getName();
						sgr.setProperty(ISimpleGenResKeywords.ISR_GENERATED_HANDLER, handler);
					}
					
					{ // priority
						if (sgr.containsProperty(ISimpleGenResKeywords.ISR_GENERATED_PRIORITY_VALUE)) {
							int prioVal = sgr.getInt(ISimpleGenResKeywords.ISR_GENERATED_PRIORITY_VALUE);
							
							if (prioVal>max_level) {
								max_level = prioVal;
							}
						}
					}
					
					if (isIsr2) {
						isr2Number ++;
						String[] tRes;
						if (sgr.containsProperty(ISimpleGenResKeywords.ISR_RESOURCE_LIST)) {
							tRes = (String[]) ((List) sgr.getObject(ISimpleGenResKeywords.ISR_RESOURCE_LIST)).toArray(new String[0]);
						} else {
							tRes = new String[0];
						}
						if (tRes.length != 0) {
							isr2ResNumber ++;
							sgr.setProperty(ISimpleGenResKeywords.ISR_REQUIRES_RESOURCES, "true");
						}
					}
				}
			}
			
			
			{// Set ISR ID
				List<ISimpleGenRes> isrs = ool.getList(IOilObjectList.ISR);
				if (computeIDFromPriority) {
					for (ISimpleGenRes isr : isrs) {
						if (isr.containsProperty(ISimpleGenResKeywords.ISR_GENERATED_PRIORITY_VALUE) && !isr.containsProperty(ISimpleGenResKeywords.ISR_ID)) {
							int prioVal = isr.getInt(ISimpleGenResKeywords.ISR_GENERATED_PRIORITY_VALUE);
							isr.setObject(ISimpleGenResKeywords.ISR_ID, new Integer(prioVal));
							isr.setObject(ISimpleGenResKeywords.ISR_ID_TXT, "" + prioVal);
						}
					}
				} else {
					int isr_id = starting_isr_id;
					for (ISimpleGenRes isr : isrs) {
						String category = isr.containsProperty(ISimpleGenResKeywords.ISR_CATEGORY) ? isr.getString(ISimpleGenResKeywords.ISR_CATEGORY) : "";
						boolean isIsr1 = "1".equals(category);
						boolean isIsr2 = "2".equals(category);
						if ( (isIsr1 || isIsr2) && !isr.containsProperty(ISimpleGenResKeywords.ISR_ID)) {
							isr.setObject(ISimpleGenResKeywords.ISR_ID, new Integer(isr_id));
							isr.setObject(ISimpleGenResKeywords.ISR_ID_TXT, "" + isr_id);
							isr_id ++;
						}
		
					}
				}
			}
			
			ISimpleGenRes os = ool.getList(IOilObjectList.OS).get(0);
			os.setObject(ISimpleGenResKeywords.OS_CPU__ISR2_NUMBER, new Integer(isr2Number));
			
			if (isr2ResNumber> 0) {
				os.setProperty(ISimpleGenResKeywords.OS_CPU__ISR_REQUIRES_RESOURCES, "true");
				os.setObject(ISimpleGenResKeywords.OS_CPU__ISR_REQUIRES_RESOURCES_MAX_PRIO, new Integer(max_level));
				os.setObject(ISimpleGenResKeywords.OS_CPU__ISR_REQUIRES_RESOURCES_SIZE, new Integer(isr2ResNumber));
			}
			
		}
	}
	
	
	/**
	 * This method builds a new list of isr (and other objects that requires an isr, hw counters), sorting isr by ID. Only isr that
	 * contains an ID are in the resulting list. The position of the isr
	 * corresponds to the isr's Id. The size of the resulting list is the
	 * maximum value among ID. The result may contains null elements if there is
	 * no isr that has an ID corresponding to that position.
	 * 
	 * 
	 * @param isrs
	 * @return an ordered list of isr, where at the position i there is an isr with the same ID or null 
	 */
	public static List<ISimpleGenRes> getIsrByID(IOilObjectList ool) {
		List<ISimpleGenRes> answer = new ArrayList<ISimpleGenRes>();
		
		Object obj = AbstractRtosWriter.getOsObject(ool, ISimpleGenResKeywords.OS_CPU__ISR2_ADDITIONAL_SGR_LIST);
		if (obj != null) {
			ArrayList<ISimpleGenRes> isrList = (ArrayList) obj;
			for (ISimpleGenRes isr : isrList) {
				String category = isr.containsProperty(ISimpleGenResKeywords.ISR_CATEGORY) ? isr.getString(ISimpleGenResKeywords.ISR_CATEGORY) : "";
				boolean isIsr1 = "1".equals(category);
				boolean isIsr2 = "2".equals(category);
				if ( (isIsr1 || isIsr2) && isr.containsProperty(ISimpleGenResKeywords.ISR_ID)) {
					int id = isr.getInt(ISimpleGenResKeywords.ISR_ID);
					while (answer.size()<=id) {
						answer.add(null);
					}
					answer.set(id, isr);
				}
			}
		}
		
		for (ISimpleGenRes isr : ool.getList(IOilObjectList.ISR)) {
			String category = isr.containsProperty(ISimpleGenResKeywords.ISR_CATEGORY) ? isr.getString(ISimpleGenResKeywords.ISR_CATEGORY) : "";
			boolean isIsr1 = "1".equals(category);
			boolean isIsr2 = "2".equals(category);
			if ( (isIsr1 || isIsr2) && isr.containsProperty(ISimpleGenResKeywords.ISR_ID)) {
				int id = isr.getInt(ISimpleGenResKeywords.ISR_ID);
				while (answer.size()<=id) {
					answer.add(null);
				}
				answer.set(id, isr);
			}
		}
		
		for (ISimpleGenRes sgr: ool.getList(IOilObjectList.COUNTER)) {
			if (sgr.containsProperty(ISimpleGenResKeywords.COUNTER_TYPE) && 
					ISimpleGenResKeywords.COUNTER_TYPE_HW.equalsIgnoreCase(sgr.getString(ISimpleGenResKeywords.COUNTER_TYPE)) &&
					sgr.containsProperty(ISimpleGenResKeywords.COUNTER_ISR_ID)) {
				int id = sgr.getInt(ISimpleGenResKeywords.COUNTER_ISR_ID);
				while (answer.size()<=id) {
					answer.add(null);
				}
				answer.set(id, sgr);
			}
		}

		return answer;
	}
}
