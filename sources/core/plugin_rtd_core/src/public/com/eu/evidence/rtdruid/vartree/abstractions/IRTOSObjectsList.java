/*
 * Created on 10-gen-2006
 *
 * $id$
 */
package com.eu.evidence.rtdruid.vartree.abstractions;


/**
 * Contains all elements refered to the same RT-OS
 * 
 * @author Nicola Serreli
 */
public interface IRTOSObjectsList {

	/** Identifies prefix for current OS */
	int OS = 0;

	/** Identifies all Application Modes */
	int APPMODE = 1;

	/** Identifies list of Tasks */
	int TASK = 2;

	/** Identifies list of Counters */
	int COUNTER = 3;

	/** Identifies list of Alarms */
	int ALARM = 4;

	/** Identifies list of Resource that can be occupied by a Task */
	int RESOURCE = 5;

	/** Identifies list of Event tasks may react on */
	int EVENT = 6;

	/** Identifies list of Interrupt Service Routines supported by current OS */
	int ISR = 7;

	/** Identifies list of Messages defined in OSEK COM */
	int MESSAGE = 8;

	/** Identifies list of Network Messages */
	int NETWORKMESSAGE = 9;

	/** Identifies list of Comunication Systems */
	int COM = 10;

	/** Identifies list of IPDU defined in OSEK COM */
	int IPDU = 11;

	/** Identifies list of Network Managment SubSystem */
	int NM = 12;

	/** Contains the number of valid objects */
	int OBJECT_NUMBER = 13;

	/** Is the Oil Cpu Object. Is not valid in this list */
	int CPU = OBJECT_NUMBER;

	/***************************************************************************
	 * 
	 * Methods
	 *  
	 **************************************************************************/

	/**
	 * @return the number of types of elements
	 */
	public int size();

	/**
	 * @return the list of types
	 */
	public int[] getListTypes();

	/**
	 * @param id
	 *            identifies the list
	 * 
	 * @return the specified list, or null if there isn't any list of specified
	 *         type
	 */
	public IGenResList getByListID(int id);

	/**
	 * @param index
	 *            position of required list
	 * 
	 * @return the specified list
	 * 
	 * @throws IndexOutOfBoundsException
	 *             if index is out of range 0..size-1
	 */
	public IGenResList get(int index);

	/**
	 * Set a new list or replace an old one. If the new list is null, only
	 * delete the old one.
	 * 
	 * @param id
	 *            identifies the list
	 * @param list
	 *            the new list
	 *  
	 */
	public void setList(int id, IGenResList list);

	/***************************************************************************
	 * 
	 * Utilities
	 *  
	 **************************************************************************/

	// public void getVarTree();
	/**
	 * Returns the RT-OS name
	 */
	public String getRtosName();
	
	/**
	 * Set the "save attribute" for all lists
	 */
	public void setSave(boolean value);
	
	/**
	 * Force "store" for all lists
	 */
	public void store();
	
	/**
	 * Force "reload" for all lists
	 */
	public void load();

}
