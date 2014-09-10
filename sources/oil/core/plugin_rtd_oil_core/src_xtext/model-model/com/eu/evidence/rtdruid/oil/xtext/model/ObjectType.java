/**
 */
package com.eu.evidence.rtdruid.oil.xtext.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Object Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.eu.evidence.rtdruid.oil.xtext.model.OilPackage#getObjectType()
 * @model
 * @generated
 */
public enum ObjectType implements Enumerator {
	/**
	 * The '<em><b>OS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OS_VALUE
	 * @generated
	 * @ordered
	 */
	OS(0, "OS", "OS"),

	/**
	 * The '<em><b>ALARM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ALARM_VALUE
	 * @generated
	 * @ordered
	 */
	ALARM(1, "ALARM", "ALARM"),

	/**
	 * The '<em><b>APPMODE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #APPMODE_VALUE
	 * @generated
	 * @ordered
	 */
	APPMODE(2, "APPMODE", "APPMODE"),

	/**
	 * The '<em><b>COUNTER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COUNTER_VALUE
	 * @generated
	 * @ordered
	 */
	COUNTER(3, "COUNTER", "COUNTER"),

	/**
	 * The '<em><b>COM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COM_VALUE
	 * @generated
	 * @ordered
	 */
	COM(4, "COM", "COM"),

	/**
	 * The '<em><b>EVENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EVENT_VALUE
	 * @generated
	 * @ordered
	 */
	EVENT(5, "EVENT", "EVENT"),

	/**
	 * The '<em><b>IPDU</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IPDU_VALUE
	 * @generated
	 * @ordered
	 */
	IPDU(11, "IPDU", "IPDU"),

	/**
	 * The '<em><b>ISR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ISR_VALUE
	 * @generated
	 * @ordered
	 */
	ISR(8, "ISR", "ISR"),

	/**
	 * The '<em><b>MESSAGE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MESSAGE_VALUE
	 * @generated
	 * @ordered
	 */
	MESSAGE(9, "MESSAGE", "MESSAGE"),

	/**
	 * The '<em><b>NETWORKMESSAGE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NETWORKMESSAGE_VALUE
	 * @generated
	 * @ordered
	 */
	NETWORKMESSAGE(10, "NETWORKMESSAGE", "NETWORKMESSAGE"),

	/**
	 * The '<em><b>NM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NM_VALUE
	 * @generated
	 * @ordered
	 */
	NM(12, "NM", "NM"),

	/**
	 * The '<em><b>RESOURCE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RESOURCE_VALUE
	 * @generated
	 * @ordered
	 */
	RESOURCE(7, "RESOURCE", "RESOURCE"),

	/**
	 * The '<em><b>TASK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TASK_VALUE
	 * @generated
	 * @ordered
	 */
	TASK(6, "TASK", "TASK"), /**
	 * The '<em><b>APPLICATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #APPLICATION_VALUE
	 * @generated
	 * @ordered
	 */
	APPLICATION(13, "APPLICATION", "APPLICATION"), /**
	 * The '<em><b>SPINLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SPINLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	SPINLOCK(14, "SPINLOCK", "SPINLOCK"), /**
	 * The '<em><b>SCHEDULETABLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SCHEDULETABLE_VALUE
	 * @generated
	 * @ordered
	 */
	SCHEDULETABLE(15, "SCHEDULETABLE", "SCHEDULETABLE");

	/**
	 * The '<em><b>OS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int OS_VALUE = 0;

	/**
	 * The '<em><b>ALARM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ALARM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ALARM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ALARM_VALUE = 1;

	/**
	 * The '<em><b>APPMODE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>APPMODE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #APPMODE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int APPMODE_VALUE = 2;

	/**
	 * The '<em><b>COUNTER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COUNTER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COUNTER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COUNTER_VALUE = 3;

	/**
	 * The '<em><b>COM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COM_VALUE = 4;

	/**
	 * The '<em><b>EVENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EVENT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EVENT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int EVENT_VALUE = 5;

	/**
	 * The '<em><b>IPDU</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>IPDU</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IPDU
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int IPDU_VALUE = 11;

	/**
	 * The '<em><b>ISR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ISR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ISR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ISR_VALUE = 8;

	/**
	 * The '<em><b>MESSAGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MESSAGE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MESSAGE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MESSAGE_VALUE = 9;

	/**
	 * The '<em><b>NETWORKMESSAGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NETWORKMESSAGE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NETWORKMESSAGE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NETWORKMESSAGE_VALUE = 10;

	/**
	 * The '<em><b>NM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NM_VALUE = 12;

	/**
	 * The '<em><b>RESOURCE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RESOURCE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RESOURCE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RESOURCE_VALUE = 7;

	/**
	 * The '<em><b>TASK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TASK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TASK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TASK_VALUE = 6;

	/**
	 * The '<em><b>APPLICATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>APPLICATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #APPLICATION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int APPLICATION_VALUE = 13;

	/**
	 * The '<em><b>SPINLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SPINLOCK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SPINLOCK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SPINLOCK_VALUE = 14;

	/**
	 * The '<em><b>SCHEDULETABLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SCHEDULETABLE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SCHEDULETABLE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SCHEDULETABLE_VALUE = 15;

	/**
	 * An array of all the '<em><b>Object Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ObjectType[] VALUES_ARRAY =
		new ObjectType[] {
			OS,
			ALARM,
			APPMODE,
			COUNTER,
			COM,
			EVENT,
			IPDU,
			ISR,
			MESSAGE,
			NETWORKMESSAGE,
			NM,
			RESOURCE,
			TASK,
			APPLICATION,
			SPINLOCK,
			SCHEDULETABLE,
		};

	/**
	 * A public read-only list of all the '<em><b>Object Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ObjectType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Object Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ObjectType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ObjectType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Object Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ObjectType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ObjectType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Object Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ObjectType get(int value) {
		switch (value) {
			case OS_VALUE: return OS;
			case ALARM_VALUE: return ALARM;
			case APPMODE_VALUE: return APPMODE;
			case COUNTER_VALUE: return COUNTER;
			case COM_VALUE: return COM;
			case EVENT_VALUE: return EVENT;
			case IPDU_VALUE: return IPDU;
			case ISR_VALUE: return ISR;
			case MESSAGE_VALUE: return MESSAGE;
			case NETWORKMESSAGE_VALUE: return NETWORKMESSAGE;
			case NM_VALUE: return NM;
			case RESOURCE_VALUE: return RESOURCE;
			case TASK_VALUE: return TASK;
			case APPLICATION_VALUE: return APPLICATION;
			case SPINLOCK_VALUE: return SPINLOCK;
			case SCHEDULETABLE_VALUE: return SCHEDULETABLE;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private ObjectType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //ObjectType
