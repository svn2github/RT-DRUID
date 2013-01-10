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
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SectionWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.FileTypes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.ICommentWriter;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEWriterKeywords;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractObjectsExtentions;

public class SectionWriterIsr implements IEEWriterKeywords, IExtractObjectsExtentions {
	
	private static final String ISR_DISABLE_ENTRY = "isr_disable_entry";
	protected Set<String> entries;
	protected final String hw_id;
	
	protected Boolean checked;
	protected boolean sharedInterruptController = false;
	
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
	public void setSharedInterruptController(Boolean sharedInterruptController) {
		this.sharedInterruptController = sharedInterruptController;
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
			
			if (parent.checkKeyword(IWritersKeywords.KERNEL_MEMORY_PROTECTION)) {
				Messages.sendWarningNl("Static ISR Table is not tested to work with Memmory Protection");
			}
			
			List<List<ISimpleGenRes>> allIsr = new LinkedList<List<ISimpleGenRes>>();
			if (sharedInterruptController && oilObjects!= null) {
				
				for (IOilObjectList list : oilObjects) {
					if (list.getList(IOilObjectList.ISR).size()>0) {
						allIsr.add(list.getList(IOilObjectList.ISR));
					}
				}
				
			} else {
				if (ool.getList(IOilObjectList.ISR).size()>0) {
					allIsr.add(ool.getList(IOilObjectList.ISR));
				}
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
			String category = curr.containsProperty(ISimpleGenResKeywords.ISR_CATEGORY) ? curr.getString(ISimpleGenResKeywords.ISR_CATEGORY) : "";
			
			if ("1".equals(category)) {
				// HW
				buffer.append(commentWriterH.writerSingleLineComment("Category 1: " + curr.getName()));
			} else if ("2".equals(category)) {
				String handler = curr.getString(ISimpleGenResKeywords.ISR_GENERATED_HANDLER);
				String entry_id = curr.getString(ISimpleGenResKeywords.ISR_GENERATED_ENTRY);
				boolean disable = curr.containsProperty(ISR_DISABLE_ENTRY) && "true".equalsIgnoreCase(curr.getString(ISR_DISABLE_ENTRY));
				
				if (!filterId.contains(entry_id)) {
					filterId.add(entry_id);
					if (entries != null) {
						if (!entries.contains(entry_id)) {
							throw new OilCodeWriterException("Found a not valid isr entry: " + entry_id + " (ISR " + curr.getName() + ")");
						}
					}
	
	
					ArrayList<String> tempStrings = new ArrayList<String>();
					tempStrings.add("#define " + entry_id + " " + handler+"\n");
					if (curr.containsProperty(ISimpleGenResKeywords.ISR_GENERATED_PRIOID) && curr.containsProperty(ISimpleGenResKeywords.ISR_GENERATED_PRIORITY_STRING)) {
						String prio = curr.getString(ISimpleGenResKeywords.ISR_GENERATED_PRIORITY_STRING);
						tempStrings.add("#define " + curr.getString(ISimpleGenResKeywords.ISR_GENERATED_PRIOID) + " " + prio+"\n");
					}
	
					if (disable){
						Messages.sendWarningNl("Disabling static ISR define for " + curr.getName());
						for (int i=0; i<tempStrings.size(); i++) {
							tempStrings.set(i, 
									commentWriterH.writerSingleLineComment(tempStrings.get(i)));
						}
					}
					
					for (String s: tempStrings) {
						buffer.append(s);
					}
				}
			} else if ("3".equals(category)) {
				// trap
				buffer.append(commentWriterH.writerSingleLineComment("Category 3: " + curr.getName()));
			} else {
				buffer.append(commentWriterH.writerSingleLineComment("Unknow ISR Category: " + curr.getName()));
			}
		}
	}
	
	@Override
	public void updateObjects() {
		
		for (IOilObjectList ool : parent.getOilObjects()) {
			int max_level = 0;
			int size = 0;
			for (ISimpleGenRes sgr: ool.getList(IOilObjectList.ISR)) {
				String category = sgr.containsProperty(ISimpleGenResKeywords.ISR_CATEGORY) ? sgr.getString(ISimpleGenResKeywords.ISR_CATEGORY) : "";
				
				if ("2".equals(category)) {
					
					String entry = sgr.containsProperty(ISimpleGenResKeywords.ISR_ENTRY) ? sgr.getString(ISimpleGenResKeywords.ISR_ENTRY) : "";
					if (entry == null || entry.length() == 0) {
						Messages.sendWarningNl("Missing ISR ENTRY for isr " + sgr.getName());
						sgr.setProperty(ISR_DISABLE_ENTRY, "true");
					}
					String entry_id = "EE_"+hw_id+"_"+entry+"_ISR";
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
					
					{
						String[] tRes;
						if (sgr.containsProperty(ISimpleGenResKeywords.ISR_RESOURCE_LIST)) {
							tRes = (String[]) ((List) sgr.getObject(ISimpleGenResKeywords.ISR_RESOURCE_LIST)).toArray(new String[0]);
						} else {
							tRes = new String[0];
						}
						if (tRes.length != 0) {
							size ++;
							sgr.setProperty(ISimpleGenResKeywords.ISR_REQUIRES_RESOURCES, "true");
						}
					}
				}
			}
			
			
			if (size> 0) {
				ISimpleGenRes os = ool.getList(IOilObjectList.OS).get(0);
				os.setProperty(ISimpleGenResKeywords.OS_CPU__ISR_REQUIRES_RESOURCES, "true");
				os.setObject(ISimpleGenResKeywords.OS_CPU__ISR_REQUIRES_RESOURCES_MAX_PRIO, new Integer(max_level));
				os.setObject(ISimpleGenResKeywords.OS_CPU__ISR_REQUIRES_RESOURCES_SIZE, new Integer(size));
			}
			
		}
	}
	
}
