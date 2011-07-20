package com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.eu.evidence.rtdruid.internal.modules.oil.keywords.ISimpleGenResKeywords;
import com.eu.evidence.rtdruid.modules.oil.abstractions.ISimpleGenRes;

public class CpuUtility {
	
	public final static String CPU_APP_SRC = "cpu_data_app_src";

	
	public static boolean getSupportForNestedIRQ(ISimpleGenRes os) {
		boolean answer = CpuHwDescription.DEFAULT_supportForNestedIRQ;
	
		if (os.containsProperty(ISimpleGenResKeywords.OS_CPU_DESCRIPTOR)) {
			answer = ((CpuHwDescription) os.getObject(ISimpleGenResKeywords.OS_CPU_DESCRIPTOR)).supportForNestedIRQ;
		}
		return answer;
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
	
	public static String[] getSources(ISimpleGenRes os) {
		
		if (os.containsProperty(CPU_APP_SRC)) {
			return (String[]) os.getObject(CPU_APP_SRC);
		}
		return new String[0];
	}
}
