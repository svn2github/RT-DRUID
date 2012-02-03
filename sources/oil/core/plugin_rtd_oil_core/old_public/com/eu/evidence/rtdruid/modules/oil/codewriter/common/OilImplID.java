/*
 * Created on Aug 25, 2004
 *
 * $Id: OilImplID.java,v 1.2 2008/03/26 18:23:52 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.codewriter.common;

import com.eu.evidence.rtdruid.modules.oil.implementation.IOilImplID;

/**
 * An Identifier for Oil Implementation Objects
 * 
 * @author Nicola Serreli
 */
public class OilImplID implements IOilImplID {

	/** Contains the type of CPU */
	protected final String cpuType;

	/** Contains the type of RT-OS */
	protected final String rtosType;

	/** Contains the name of Implementation section inside the input oil file */
	protected final String implementationName;

	/**
	 * Construct a new OilImplID.
	 * 
	 * @param implName
	 *            the name of Implementation section inside the input oil file
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

	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.modules.oil.codewriter.common.IOilImplID#compareTo(com.eu.evidence.rtdruid.modules.oil.codewriter.common.OilImplID)
	 */
	@Override
	public int compareTo(IOilImplID o) {
		if (o == null) {
			throw new NullPointerException("Required a not null object");
		}
		
		if (o instanceof OilImplID) {
			
			OilImplID oi = (OilImplID) o;
	
			// first null values
			int res = 0;
			res = (cpuType == null ? (oi.cpuType == null ? 0 : -1)
					: (oi.cpuType == null ? 1 : cpuType.compareTo(oi.cpuType)));
	
			return res != 0 ? res : (rtosType == null ? (oi.rtosType == null ? 0
					: -1) : (oi.rtosType == null ? 1 : rtosType
					.compareTo(oi.rtosType)));
		} else {
			return implementationName == null ?
					(o.getImplementationName() == null ? 0 : -1)
					: (o.getImplementationName() == null ? 1 : implementationName.compareTo(o.getImplementationName()));
		}
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

	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.modules.oil.codewriter.common.IOilImplID#getImplementationName()
	 */
	@Override
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
	public IOilImplID clone() {
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