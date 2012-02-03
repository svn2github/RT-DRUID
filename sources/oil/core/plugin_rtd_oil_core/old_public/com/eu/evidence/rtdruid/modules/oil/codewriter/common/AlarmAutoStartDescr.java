/*
 * Created on Mar 11, 2005
 *
 * $Id: AlarmAutoStartDescr.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.codewriter.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * This little class store data about Alarm's AutoStart
 */
public final class AlarmAutoStartDescr {
	protected final ArrayList modes;
	protected final long alarmTime;
	protected final long cycleTime;
	
	/**
	 * Create a new instance.
	 * 
	 * Stores directly the specified array (not a copy).
	 * 
	 * @param modes
	 *            contains the list of mode that will autostart this alarm.
	 *            a null array means all modes.
	 * @param alarmTime
	 *            is the Oil parameter "ALARMTIME"
	 * @param cycleTime
	 *            is the Oil parameter "CYCLETIME"
	 */
	public AlarmAutoStartDescr(String[] modes, long alarmTime, long cycleTime) {
		
		if (modes == null) {
			this.modes = null;
		} else {
			 ArrayList tmp = new ArrayList(Arrays.asList(modes));
			 Collections.sort(tmp);
			 this.modes = tmp;
		}
		this.alarmTime = alarmTime;
		this.cycleTime = cycleTime;
	}
	
	/**
	 * @return Returns the alarmTime.
	 */
	public long getAlarmTime() {
		return alarmTime;
	}
	
	/**
	 * @return Returns the cycleTime.
	 */
	public long getCycleTime() {
		return cycleTime;
	}
	
	/**
	 * Doesn't make a copy
	 * 
	 * @return Returns the modes.
	 */
	public String[] getModes() {
		return modes == null ? null : (String[]) modes.toArray(new String[modes.size()]);
	}

	/**
	 * Searchs if specified mode have to autostart this alarm.
	 * 
	 * If is specified a null mode, returns always false.
	 * 
	 * NB. Uses a binary search.
	 * 
	 * @param mode
	 *            the mode to search
	 * 
	 * @return Returns true if specified mode have to autostart this alarm.
	 */
	public boolean containsMode(String mode) {
		if (mode == null) {
			return false;
		}
		
		return modes == null ? true : Collections.binarySearch(modes, mode)>-1; 
	}
	
	
	/**
	 * Returns a summary for this Alarm's Autostart Description 
	 */
	public String toString() {
		return "AlarmTime = " + alarmTime + "\nCycleTime = " +cycleTime+ "\nModes = " +modes;
	}
	
}
