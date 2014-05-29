package com.eu.evidence.rtdruid.modules.oil.codewriter.common;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.eu.evidence.rtdruid.internal.modules.oil.codewriter.common.SWCategory;
import com.eu.evidence.rtdruid.modules.oil.interfaces.ISWCategory;

public class SWCategoryManager {
	
	
	protected class SWCategoryComparator implements Comparator<String> {
		public int compare(String a, String b) {
			int answer = categoryLevel(a) - categoryLevel(b);
			if (answer == 0) {
				answer = a == null ? 
					(b == null ? 0 : -1)
					: (b == null ? 1 : a.compareTo(b))
					;
			}
			return answer;
		}
		
	}

	public final static String TYPE_INIT = "INIT";
	public final static String TYPE_CPU = "CPU";
	public final static String TYPE_KERNEL = "KERNEL";
	public final static String TYPE_BOARD = "BOARD";
	public final static String TYPE_HW = "HW";
	public final static String TYPE_OTHERS = "OTHERS";
	public final static String TYPE_MAKEFILE = "MAKEFILE";
	public final static String TYPE_END = "END";
	
	public final static int defaultPriority = 1000;
	public final static int defaultMakefilePriority = 10000000;
	public final static ISWCategory EMPTY_CATEGORY = new SWCategory(null, defaultPriority);
	
	public final static SWCategoryManager defaultInstance = new SWCategoryManager();
	protected SWCategoryComparator comp = new SWCategoryComparator();
	protected String[] levels;
	protected final int othersLevel;

	private SWCategoryManager() {
		levels = new String[] {
			TYPE_INIT,
			TYPE_CPU,
			TYPE_BOARD,
			TYPE_HW,
			TYPE_KERNEL,
			TYPE_OTHERS,
			TYPE_MAKEFILE,
			TYPE_END
		};
		
		// !!
		othersLevel = categoryLevel(TYPE_OTHERS);
	}
	
	public ISWCategory newCategory(String key) {
		return new SWCategory(new String[] {key}, defaultPriority);
	}

	public ISWCategory newCategory(String key, int priority) {
		return new SWCategory(new String[] {key}, priority);
	}

	public ISWCategory newCategory(String[] keys, int priority) {
		return new SWCategory(keys, priority);
	}

	public void sortKeys(List<String> keys) {
		Collections.sort(keys, getKeysComparator());
	}
	public Comparator<String> getKeysComparator() {
		return comp;
	}
	public int categoryLevel(String key) {
		// try to use fast equal
		for (int i=0; i<levels.length; i++) {
			if (levels[i] == key) {
				return i;
			}
		}
		
		// use equal function
		for (int i=0; i<levels.length; i++) {
			if (levels[i].equals(key)) {
				return i;
			}
		}
		
		return othersLevel;
	}
}
