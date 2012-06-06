package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.sectionwriter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * A task Event Map
 * 
 * @author Nicola Serreli
 *
 */
class TaskEventMap {
	
	private static class TEElement {
		final String task;
		final String event;
		final String id;
		
		public TEElement(String task, String event, String id) {
			this.task = task;
			this.event = event;
			this.id = id;
		}
		
		public String getStructureId() {
			return "event_to_call__" + id;
		}
	}

	private static class StringComparator implements Comparator<TEElement> {
		@Override
		public int compare(TEElement o1, TEElement o2) {
			
			int result = o1.task.compareTo(o2.task);
			if (result == 0) {
				result = o1.event.compareTo(o2.event);
			}
			
			return result;
		}
	}
	
	private static final StringComparator comparator = new StringComparator();
	
	private static class IdComparator implements Comparator<TEElement> {
		@Override
		public int compare(TEElement o1, TEElement o2) {
			
			return o1.id.compareTo(o2.id);
		}
	}
	
	private static final IdComparator idComparator = new IdComparator();

	
	private ArrayList<TEElement> map = new ArrayList<TEElement>();
	private int counter = 0;
	
	
	public void add(String task, String event) {
		TEElement tmp = new TEElement(task, event, "" +counter);
		int pos = Collections.binarySearch(map, tmp, comparator);
		if (pos <0) {
			map.add(-pos-1, tmp);
			counter ++;
		}
	}
	
	private TEElement getElement(String task, String event) {
		TEElement tmp = new TEElement(task, event, null);
		int pos = Collections.binarySearch(map, tmp, comparator);
		if (pos <0) {
			return null;
		} else {
			return map.get(pos);
		}
	}
	
	public String getStructureName(String task, String event) {
		TEElement tmp = getElement(task, event);
		if (tmp == null) {
			return null;
		} else {
			return tmp.getStructureId();
		}
	}

	
	public String getInitStructures() {
		ArrayList<TEElement> copy = new ArrayList<TaskEventMap.TEElement>(map);
		Collections.sort(copy, idComparator);
		
		StringBuffer buffer = new StringBuffer();
		for (TEElement elem: copy) {
			buffer.append("const struct EE_COM_event_notify "+elem.getStructureId() + " = {"+elem.task+", "+elem.event+"};\n");
		}
		
		return buffer.toString();
	}
	
	public int size() {
		return map.size();
	}
}
