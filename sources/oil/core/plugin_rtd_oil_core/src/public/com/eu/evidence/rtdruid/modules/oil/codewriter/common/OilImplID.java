/*
 * Created on Aug 25, 2004
 *
 * $Id: OilImplID.java,v 1.2 2008/03/26 18:23:52 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.codewriter.common;

/**
 * An Identifier for Oil Implementation Objects
 * 
 * @author Nicola Serreli
 */
public class OilImplID implements Comparable<OilImplID> {

	/** Contains the type of CPU */
	protected final String cpuType;

	/** Contains the type of RT-OS */
	protected final String rtosType;

	/** Contains the name of Implementation section insede the input oil file */
	protected final String implementationName;

	/**
	 * Construct a new OilImplID.
	 * 
	 * @param implName
	 *            the name of Implementation section insede the input oil file
	 * @param cpu
	 *            identifies a cpu (can be null)
	 * @param rtos
	 *            identifies a rt-os
	 */
	public OilImplID(String implName, String cpu, String rtos) {
		cpuType = cpu;
		rtosType = rtos;
		implementationName = implName;
	}

	/**
	 * Returns a string that rapresent current Id.
	 * 
	 * @return a string that rapresent current Id.
	 */
	public String toString() {
		return "HW = " + cpuType + ", RT-OS = " + rtosType;
	}

	/**
	 * Check if another OilImplId is equals to current OilImplId.
	 * 
	 * @param o
	 *            the object to be compared
	 * 
	 * @return true if specified object is an OilImplId with the same cpu type
	 *         and rtos type
	 */
	public boolean equals(Object o) {
		if (!(o instanceof OilImplID)) {
			return false;
		}
		OilImplID oi = (OilImplID) o;
		return (cpuType == null ? oi.cpuType == null : cpuType
				.equals(oi.cpuType))
				&& (rtosType == null ? oi.rtosType == null : rtosType
						.equals(oi.rtosType));
	}

	/**
	 * Compare another OilImplId with current OilImplId.
	 * Check first cpuType and then rtosType; null values comes first.
	 * 
	 * @param o
	 *            the Object to be compared.
	 * 
	 * @return a negative integer, zero, or a positive integer as this object is
	 *         less than, equal to, or greater than the specified object.
	 * 
	 * @throws NullPointerException
	 *             if specified object is Null
	 */
	public int compareTo(OilImplID o) {
		if (o == null) {
			throw new NullPointerException("Required a not null object");
		}
		OilImplID oi = (OilImplID) o;

		// first null values
		int res = 0;
		res = (cpuType == null ? (oi.cpuType == null ? 0 : -1)
				: (oi.cpuType == null ? 1 : cpuType.compareTo(oi.cpuType)));

		return res != 0 ? res : (rtosType == null ? (oi.rtosType == null ? 0
				: -1) : (oi.rtosType == null ? 1 : rtosType
				.compareTo(oi.rtosType)));
	}

	/**
	 * Returns the HW type
	 * 
	 * @return the cpu type
	 */
	public String getHW() {
		return cpuType;
	}

	/**
	 * Returns the RT-OS type
	 * 
	 * @return the rtos type
	 */
	public String getRtos() {
		return rtosType;
	}

	/**
	 * Returns the Implementation Name
	 * 
	 * @return the implementation name
	 */
	public String getImplementationName() {
		return implementationName;
	}
	
	/**
	 * Construct a new OilImplID.
	 * 
	 * @param implName
	 *            the name of Implementation section insede the input oil file
	 * @param cpu
	 *            identifies a cpu (can be null)
	 * @param rtos
	 *            identifies a rt-os
	 */
	public OilImplID clone() {
		return new OilImplID(implementationName, cpuType, rtosType);
	}

	
	/**
	 * Returns an hashcode for this object 
	 */
	public int hashCode() {
		int cpu_hash = cpuType == null ? 0 : cpuType.hashCode();
		int rtos_hash = rtosType == null ? 0 : rtosType.hashCode();
		
		return cpu_hash<<16 | (rtos_hash & 0x00FF);
	}
}