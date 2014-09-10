/*
 * Created on Sep 7, 2005
 *
 * $Id: IOilObjectList.java,v 1.2 2008/05/14 17:15:38 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.abstractions;


import java.util.List;

/**
 * TODO Commentare && Tradurre
 * 
 * @author Nicola Serreli
 */
public interface IOilObjectList {
	/** Identifies prefix for current OS */
	public static final int OS = 0;

	/** Identifies all Application Modes */
	public static final int OSAPPLICATION = 1;

	/** Identifies all Application Modes */
	public static final int APPMODE = 2;

	/** Identifies list of Tasks */
	public static final int TASK = 3;

	/** Identifies list of Counters */
	public static final int COUNTER = 4;

	/** Identifies list of Alarms */
	public static final int ALARM = 5;

	/** Identifies list of Resource that can be occupied by a Task */
	public static final int RESOURCE = 6;

	/** Identifies list of Event tasks may react on */
	public static final int EVENT = 7;

	/** Identifies list of Interrupt Service Routines supported by current OS */
	public static final int ISR = 8;

	/** Identifies list of Messages defined in OSEK COM */
	public static final int MESSAGE = 9;

	/** Identifies list of Network Messages */
	public static final int NETWORKMESSAGE = 10;

	/** Identifies list of Comunication Systems */
	public static final int COM = 11;

	/** Identifies list of IPDU defined in OSEK COM */
	public static final int IPDU = 12;

	/** Identifies list of Network Managment SubSystem */
	public static final int NM = 13;

	/** Identifies list of Spinlocks */
	public static final int SPINLOCK = 14;

	/** Identifies list of Scheduling tables */
	public static final int SCHEDULE_TABLE = 15;

	/** Contains the number of valid objects */
	public static final int OBJECT_NUMBER = 16;

	/** Is the Oil Cpu Object. Is not valid in this list */
	public static final int CPU = OBJECT_NUMBER;

	// ------------------------------------------------------------------
	void setList(int id, List<? extends ISimpleGenRes> list);

	/**
	 * Stores a list of specific OSEK objects. <br>
	 * Each Object is identifed by a String (the path of that object in the
	 * owner VarTree).
	 * 
	 * @param id
	 *            identifies the type of objects
	 * @param list
	 *            the objects
	 * 
	 * @throws IndexOutOfBoundsException
	 *             if id isn't a valid identifer (see contants declared above).
	 */
	void setList(int id, ISimpleGenRes[] list);

	/**
	 * Returns an unmodificable list of specific OSEK objects. <br>
	 * Each Object is identifed by a SimpleGenRes.
	 * 
	 * @param id
	 *            identifies the type of objects
	 * 
	 * @return an unmodificable list of specific OSEK objects.
	 */
	List<ISimpleGenRes> getList(int id);
	
	/**
	 * Adds all elements of the given IOilObjecList. If copy parameter is true,
	 * it does a copy before add to this IOilObjectList
	 * 
	 * @param ool
	 *            the list of elment to add
	 * 
	 * @param doCopy
	 *            if true, do a copy of each object before add them to the list
	 * 
	 * 
	 * @return an unmodificable list of specific OSEK objects.
	 */
	void merge(IOilObjectList ool, boolean doCopy);
}