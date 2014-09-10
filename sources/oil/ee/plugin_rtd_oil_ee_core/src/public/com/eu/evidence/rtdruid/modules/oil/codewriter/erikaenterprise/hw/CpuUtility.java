package com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.ErikaEnterpriseWriter;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.ISimpleGenResKeywords;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList;
import com.eu.evidence.rtdruid.modules.oil.abstractions.ISimpleGenRes;

public class CpuUtility {
	
	public final static String CPU_APP_SRC = "cpu_data_app_src";

	
	public static boolean getSupportForNestedIRQ(IOilObjectList ool) {
		boolean answer = CpuHwDescription.DEFAULT_supportForNestedIRQ;
	
		CpuHwDescription descr = ErikaEnterpriseWriter.getCpuHwDescription(ool);
		if (descr != null) {
			answer = descr.supportForNestedIRQ;
		}
		return answer;
	}

	public static void addSources(IOilObjectList ool, String[] file) {
		addSources(ool.getList(IOilObjectList.OS).get(0), file);
	}

	public static void addSources(ISimpleGenRes os, String file) {
		addSources(os, new String[] {file});
	}

	public static void addSources(ISimpleGenRes os, String[] files) {
		
		List<String> src_files = new ArrayList<String>();
		if (os.containsProperty(CPU_APP_SRC)) {
			String[] tmp_files = (String[]) os.getObject(CPU_APP_SRC);
			src_files.addAll(Arrays.asList(tmp_files));
		}
		
		for (String s: files) {
		
			if (!src_files.contains(s)) {
				src_files.add(s);
			}
		}
		os.setObject(CPU_APP_SRC, src_files.toArray(new String[src_files.size()]));

	}

	public static String[] getSources(IOilObjectList ool) {
		ArrayList<String> answer = new ArrayList<String>();
		
		for (ISimpleGenRes os: ool.getList(IOilObjectList.OS)) {
			answer.addAll(Arrays.asList(getSources(os)));
		}
		return (String[]) answer.toArray(new String[answer.size()]);
	}

	public static String[] getSources(ISimpleGenRes os) {
		
		if (os.containsProperty(CPU_APP_SRC)) {
			return (String[]) os.getObject(CPU_APP_SRC);
		}
		return new String[0];
	}
	
	@SuppressWarnings("unchecked")
	public static String getOsAccessBitMask(ISimpleGenRes object, IOilObjectList ool, StringBuilder description) {
		if (object == null) return "0x0";
		
		BitSet answerBitSet = new BitSet();
		answerBitSet.set(0);
		
		Set<String> validOsApplNames = new HashSet<String>();
		if (object.containsProperty(ISimpleGenResKeywords.GENERIC_ACCESSING_OS_APPL_LIST)) {
			validOsApplNames.addAll((List<String>)object.getObject(ISimpleGenResKeywords.GENERIC_ACCESSING_OS_APPL_LIST) );
		}
		if (object.containsProperty(ISimpleGenResKeywords.OS_APPL_NAME)) {
			validOsApplNames.add(object.getString(ISimpleGenResKeywords.OS_APPL_NAME) );
		}
		
		
		List<ISimpleGenRes> osAppls = ool.getList(IOilObjectList.OSAPPLICATION);
		for (int i=0; i<osAppls.size(); i++) {
			ISimpleGenRes sgr = osAppls.get(i);
			if (validOsApplNames.contains(sgr.getName())) {
				answerBitSet.set(sgr.getInt(ISimpleGenResKeywords.OS_APPL_ID)+1);
			}
		}
		
		StringBuilder answerText = new StringBuilder();
		for (int i=0; i<answerBitSet.length(); i+=4) {
			int val = (answerBitSet.get(i) ? 1 : 0) +
					(answerBitSet.get(i+1) ? 2 : 0) +
					(answerBitSet.get(i+2) ? 4 : 0) +
					(answerBitSet.get(i+3) ? 8 : 0);
			answerText.insert(0, (char)
					(val<10 ? '0'+val : 'A'+(val-10))
			);
		}
		if (answerText.length()==0) answerText.append("0");
		answerText.insert(0, "0x");
				
		return answerText.toString();
	}
}
