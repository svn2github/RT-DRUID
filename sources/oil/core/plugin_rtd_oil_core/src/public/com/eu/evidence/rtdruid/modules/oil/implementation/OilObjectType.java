/**
 * 24/apr/2012
 */
package com.eu.evidence.rtdruid.modules.oil.implementation;

import java.util.HashMap;
import java.util.Map;

import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList;
import com.eu.evidence.rtdruid.modules.oil.keywords.IOilXMLLabels;

/**
 * Identifies all Oil Object Types
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public enum OilObjectType {

	/** Identifies the OS */
	OS(IOilXMLLabels.OBJ_OS),
	/** Identifies an Application Mode */
	APPMODE(IOilXMLLabels.OBJ_APPMODE),
	/** Identifies an Application Mode */
	OSAPPLICATION(IOilXMLLabels.OBJ_OSAPPLICATION),
	/** Identifies a Task */
	TASK(IOilXMLLabels.OBJ_TASK),
	/** Identifies a Counter */
	COUNTER(IOilXMLLabels.OBJ_COUNTER),
	/** Identifies an Alarm */
	ALARM(IOilXMLLabels.OBJ_ALARM),
	/** Identifies a Resource that can be occupied by a Task */
	RESOURCE(IOilXMLLabels.OBJ_RESOURCE),
	/** Identifies an Event that tasks may react on */
	EVENT(IOilXMLLabels.OBJ_EVENT),
	/** Identifies a Interrupt Service Routines supported by current OS */
	ISR(IOilXMLLabels.OBJ_ISR),
	/** Identifies a Message defined in OSEK COM */
	MESSAGE(IOilXMLLabels.OBJ_MESSAGE),
	/** Identifies a Network Message */
	NETWORKMESSAGE(IOilXMLLabels.OBJ_NETWORKMESSAGE),
	/** Identifies a Communication System */
	COM(IOilXMLLabels.OBJ_COM),
	/** Identifies a IPDU defined in OSEK COM */
	IPDU(IOilXMLLabels.OBJ_IPDU),
	/** Identifies a Network Management SubSystem */
	NM(IOilXMLLabels.OBJ_NM),
	/** Identifies a SpinLock */
	SPINLOCK(IOilXMLLabels.OBJ_SPINLOCK),
	/** Identifies a Scheduling table */
	SCHEDULETABLE(IOilXMLLabels.OBJ_SCHEDULETABLE),
	/** Identifies a CPU */
	CPU(IOilXMLLabels.OBJ_CPU);

	private final String text;
	private static Map<String, OilObjectType> elements = null;
	
	static {
		elements = new HashMap<String, OilObjectType>();
		for (OilObjectType p : OilObjectType.values()) {
			elements.put(p.getText(), p);
		}
	}
	
	OilObjectType(String text) {
		this.text = text;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	
	public static OilObjectType get(String objID) {
		OilObjectType answer = elements.get(objID);
		if (answer == null) {
			throw new IllegalArgumentException("Unknow id " + objID);
		}
		return answer ;
	}
	public static OilObjectType get(int objID) {
		switch (objID) {
		case IOilObjectList.OS: return OS; 
		case IOilObjectList.OSAPPLICATION: return OSAPPLICATION;
		case IOilObjectList.TASK: return TASK;
		case IOilObjectList.ISR: return ISR;
		case IOilObjectList.EVENT: return EVENT;
		case IOilObjectList.ALARM: return ALARM;
		case IOilObjectList.COUNTER: return COUNTER;
		case IOilObjectList.SPINLOCK: return SPINLOCK;
		case IOilObjectList.SCHEDULE_TABLE: return SCHEDULETABLE;
		case IOilObjectList.RESOURCE: return RESOURCE;
		case IOilObjectList.NETWORKMESSAGE: return NETWORKMESSAGE;
		case IOilObjectList.MESSAGE: return MESSAGE;
		case IOilObjectList.COM: return COM;
		case IOilObjectList.NM: return NM;
		case IOilObjectList.IPDU: return IPDU;
		default: throw new IllegalArgumentException("Unknow id " + objID);
		}
	}
}
