package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.sectionwriter;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

import com.eu.evidence.rtdruid.internal.modules.oil.keywords.ISimpleGenResKeywords;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList;
import com.eu.evidence.rtdruid.modules.oil.abstractions.ISimpleGenRes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.AbstractRtosWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.CommonUtils;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.CpuUtility;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEWriterKeywords;
import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.IVarTree;

public class MakefileUtils {
	
	public static LinkedHashSet<String> getSources(IOilObjectList ool, IVarTree vt) {
		
		LinkedHashSet<String> src_files = new LinkedHashSet<String>();
		// get Task's files
		for (Iterator<ISimpleGenRes> iter = ool.getList(IOilObjectList.TASK).iterator(); iter.hasNext(); ) {
			ISimpleGenRes task = (ISimpleGenRes) iter.next();
			
			if (task.containsProperty(ISimpleGenResKeywords.TASK_SRC_FILE_LIST)) {
				Object o = task.getObject(ISimpleGenResKeywords.TASK_SRC_FILE_LIST);
				if (o instanceof String[]) {
					String[] files = (String[]) o;
					for (String s : files) {
						src_files.add(s);
					}
				} else if (o instanceof List) {
					for (Object s : (List<?>) o) {
						if (s!=null) src_files.add(""+s);
					}
				} else if (o instanceof String) {
					src_files.add((String) o);
				}

			}
		}
		// get Resource's files
		for (Iterator<ISimpleGenRes> iter = ool.getList(IOilObjectList.RESOURCE).iterator(); iter.hasNext(); ) {
			ISimpleGenRes resource = (ISimpleGenRes) iter.next();
			
			if (resource.containsProperty(ISimpleGenResKeywords.RESOURCE_SRC)) {
				Object o = resource.getObject(ISimpleGenResKeywords.RESOURCE_SRC);
				if (o instanceof String[]) {
					String[] files = (String[]) o;
					for (String s : files) {
						src_files.add(s);
					}
				} else if (o instanceof List) {
					for (Object s : (List<?>) o) {
						if (s!=null) src_files.add(""+s);
					}
				} else if (o instanceof String) {
					src_files.add((String) o);
				}
			}
		}

		// CPU
		for (ISimpleGenRes sgrCpu: ool.getList(IOilObjectList.OS)){
			src_files.addAll(Arrays.asList(CpuUtility.getSources(sgrCpu)));
		
		final List<String> currentCpuPrefixes = AbstractRtosWriter.getOsProperties(ool, IEEWriterKeywords.SGRK_OS_CPU_DATA_PREFIX);
		for (String currentCpuPrefix: currentCpuPrefixes) {

			String[] tmp = CommonUtils.getValue(vt, currentCpuPrefix
					+ DataPath.SEPARATOR + "APP_SRC");

			if (tmp != null) {
				for (int i = 0; i < tmp.length; i++) {
					src_files.add(tmp[i]);
				}
			}

		}
		
		}
		
		
		return src_files;
	}
}
