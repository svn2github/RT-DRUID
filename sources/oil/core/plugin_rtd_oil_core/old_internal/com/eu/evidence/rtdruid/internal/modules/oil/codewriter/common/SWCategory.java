package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SWCategoryManager;
import com.eu.evidence.rtdruid.modules.oil.interfaces.ISWCategory;

public class SWCategory implements ISWCategory {
	
	protected ArrayList<String> keys;
	protected int priority;
	
	public SWCategory(String[] keys, int priority) {
		this.priority = priority;
		if (keys == null) {
			this.keys = new ArrayList<String>();
			return;
		}
		this.keys = new ArrayList<String>(Arrays.asList(keys));
		SWCategoryManager.defaultInstance.sortKeys(this.keys);
	}

	@Override
	public String[] getKeys() {
		return keys.toArray(new String[keys.size()]);
	}

	@Override
	public int getPriority() {
		return priority;
	}

	@Override
	public int compareTo(ISWCategory obj) {
		
		ArrayList<String> okeys = null;
		int opriority = Integer.MIN_VALUE;
		
		if (obj instanceof SWCategory) {
			opriority = ((SWCategory) obj).priority;
			okeys = ((SWCategory) obj).keys;
			
		} else {
			opriority = obj.getPriority();
			String[] okeyv = obj.getKeys();
			okeys = new ArrayList<String>(Arrays.asList(okeyv));
			SWCategoryManager.defaultInstance.sortKeys(okeys);
		}
		
		int answer = (keys.size() == 0 ? -1 : 0)
					+ (okeys.size() == 0 ? 1 : 0);
		
		if (keys.size() > 0 && okeys.size() > 0) {
			Comparator<String> comp = SWCategoryManager.defaultInstance.getKeysComparator();
			answer = comp.compare(keys.get(0), okeys.get(0));
		}
		if (answer == 0) {
			answer = priority - opriority;
		}
		
		return answer;
	}

	@Override
	public boolean equals(Object obj) {
		
		ArrayList<String> okeys = null;
		int opriority = Integer.MIN_VALUE;
		if (obj instanceof SWCategory) {
			opriority = ((SWCategory) obj).priority;
			okeys = ((SWCategory) obj).keys;
			
		} else if (obj instanceof ISWCategory) {
			opriority = ((ISWCategory) obj).getPriority();
			String[] okeyv = ((ISWCategory) obj).getKeys();
			okeys = new ArrayList<String>(Arrays.asList(okeyv));
			SWCategoryManager.defaultInstance.sortKeys(okeys);
		}
		
		if (okeys != null && okeys.size() == keys.size()) {

			for (int i=0; i<keys.size(); i++) {
				if (equalsStrings(keys.get(i), okeys.get(i))) {
					return false;
				}
			}
			
			return priority == opriority;
		}
		
		return false;
	}
	
	protected boolean equalsStrings(String a, String b) {
		return a == null ? b == null : a.equals(b);
	}

	@Override
	public String toString() {
		StringBuffer cat = new StringBuffer();
		for (String s : keys) {
			cat.append(s +" ");
		}
		return "Cat {"+ cat +" @@ " + priority + "}";
	}
}
