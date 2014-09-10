/*
 * Created on Nov 25, 2004
 *
 * $Id: IOilXMLLabels.java,v 1.2 2007/03/09 09:12:41 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.keywords;

/**
 * This interface contains all labels used to store an Oil Tree inside an XML tree
 * 
 * See also OilParser.jj and .../oil/templates/*.dtd 
 * @author Nicola Serreli
 */
public interface IOilXMLLabels {

	/***************************************************************************
	 * ELEMENTS OF IMPLEMENTATION SECTION
	 **************************************************************************/

	/** Identifies the OS */
	public static final String OBJ_OS = "OS";

	/** Identifies an Application Mode */
	public static final String OBJ_APPMODE = "APPMODE";

	/** Identifies an Application Mode */
	public static final String OBJ_OSAPPLICATION = "APPLICATION";

	/** Identifies a Task */
	public static final String OBJ_TASK = "TASK";

	/** Identifies a Counter */
	public static final String OBJ_COUNTER = "COUNTER";

	/** Identifies an Alarm */
	public static final String OBJ_ALARM = "ALARM";

	/** Identifies a Resource that can be occupied by a Task */
	public static final String OBJ_RESOURCE = "RESOURCE";

	/** Identifies an Event that tasks may react on */
	public static final String OBJ_EVENT = "EVENT";

	/** Identifies a Interrupt Service Routines supported by current OS */
	public static final String OBJ_ISR = "ISR";

	/** Identifies a Message defined in OSEK COM */
	public static final String OBJ_MESSAGE = "MESSAGE";

	/** Identifies a Network Message */
	public static final String OBJ_NETWORKMESSAGE = "NETWORKMESSAGE";

	/** Identifies a Comunication System */
	public static final String OBJ_COM = "COM";

	/** Identifies a IPDU defined in OSEK COM */
	public static final String OBJ_IPDU = "IPDU";

	/** Identifies a Network Managment SubSystem */
	public static final String OBJ_NM = "NM";

	/** Identifies a SPINLOCK */
	public static final String OBJ_SPINLOCK = "SPINLOCK";

	/** Identifies a SCHEDULING TABLE */
	public static final String OBJ_SCHEDULETABLE = "SCHEDULETABLE";

	/** Identifies a CPU */
	public static final String OBJ_CPU = "CPU";

	/** Identifies a Default */
	public static final String DEFAULT = "Default";
	
	/***************************************************************************
	 * ELEMENTS OF IMPLEMENTATION SECTION
	 **************************************************************************/

	/** Identifies the root element of an Oil Implementation tree */
	public final static String ELEM_IMPLEMENTATION = "OIL_IMPLEMENTATION";

	/**
	 * Identifies the root element of an Oil Object (OS, TASK, RESOURCE, ...)
	 * inside the Implementation section
	 */
	public final static String ELEM_FIRST_LEVEL_OBJ = "FIRST_LEVEL_OBJ";

	/** Identifies an attribute/parameter (STRING, UINT32, INT32, ...) */
	public final static String ELEM_ATTRIBUTE = "ATTRIBUTE";

	/** Identifies a range of values */
	public final static String ELEM_RANGE = "RANGE";

	/** Identifies a single value of a parameter */
	public final static String ELEM_VALUE = "VALUE";

	/** Identifies a reference to another object */
	public final static String ELEM_REFERENCE = "REFERENCE";

	/** Identifies an enum or an boolean parameter (ENUM or BOOLEAN) */
	public final static String ELEM_VARIANT = "VARIANT";

	/** Identifies a single case of an enum/boolean */
	public final static String ELEM_ENUMERATOR = "ENUMERATOR";

	/** Identifies an HW element (inside the oil var) */
	public final static String ELEM_OILVAR_HW = "HW";
	/** Identifies a RT-OS element (inside the oil var) */
	public final static String ELEM_OILVAR_RTOS = "RTOS";
	/** Identifies the root element (inside the oil var) */
	public final static String ELEM_OILVAR_ROOT = "Root";

	/***************************************************************************
	 * ELEMENTS OF APPLICATION SECTION
	 **************************************************************************/

	/** Identifies the root element of an Oil Application tree */
	public final static String ELEM_APPLICATION = "application";

	/**
	 * Identifies the root element of an Oil Object (OS, TASK, RESOURCE, ...)
	 * inside the Application section
	 */
	public final static String ELEM_OBJECT = "object";

	/**
	 * Identifies a parameter (a STRING, a NUMBER, an OBJECT_REF, an
	 * ENUM/BOOLEAN)
	 */
	public final static String ELEM_PARAMETER = "parameter";

	/** Identifies the a case of an enum */
	public final static String ELEM_ENUM_VALUE = "enumerator";

	/***************************************************************************
	 * COMMON ELEMENTS
	 **************************************************************************/

	/** Identifies the element that contains a Description */
	public final static String ELEM_DESCRIPTION = "DESCRIPTION";

	/***************************************************************************
	 * Attributes
	 **************************************************************************/

	/** Identifies the name of an element */
	public final static String ATTR_NAME = "Name";

	/** Identifies the type of a object or a parameter */
	public final static String ATTR_TYPE = "Type";

	/** Identifies the type of an FIRST_LEVEL_OBJECT (OS, TASK, RESOURCE ...) */
	public final static String ATTR_OBJ_TYPE = "ObjectType";

	/**
	 * Identifies the type of a referenced object (OS_TYPE, TASK_TYPE,
	 * RESOURCE_TYPE ...)
	 */
	public final static String ATTR_OBJ_REF_TYPE = "ObjectRefType";

	/**
	 * Identifies if the IMPLEMENTATION ATTRIBUE/VARIANT has max one value or
	 * mode
	 */
	public final static String ATTR_MULTIPLE_VALUES = "MultipleValues";

	/**
	 * Identifies one of the valid values for an IMPLEMENTATION ATTRIBUE (a
	 * string or a number)
	 */
	public final static String ATTR_VALUE = "Value";

	/** Identifies the default value */
	public final static String ATTR_DEFAULT_VALUE = "DefaultValue";

	/** Identifies the max value (in a range) */
	public final static String ATTR_MAX = "MaxValue";

	/** Identifies the min value (in a range) */
	public final static String ATTR_MIN = "MinValue";

	/** Identifies a value set to AUTO */
	public final static String ATTR_AUTO = "Auto";

	/**
	 * Identifies if the value of the IMPLEMENTATION ATTRIBUE/VARIANT could be
	 * set to AUTO
	 */
	public final static String ATTR_WITH_AUTO = "WithAuto";

	/** Identifies a value (a string or a number) */
	public final static String ATTR_CURR_VALUE = "CurrValue";

}