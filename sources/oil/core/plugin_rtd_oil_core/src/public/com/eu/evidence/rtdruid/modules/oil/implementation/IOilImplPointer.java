package com.eu.evidence.rtdruid.modules.oil.implementation;


public interface IOilImplPointer extends Cloneable {

	/** Identifies an object of First Level (Oil Objects as OS, TASK, ... ) */
	public final static int FIRST_LEVEL = 0;
	/** Identifies a description */
	public final static int DESCRIPTION = 1;
	/** Identifies an attribute (a STRING, a INT32, ... ) */
	public final static int ATTRIBUTE = 2;
	/** Identifies a reference (a TASK_TYPE, RESOURCE_TYPE, ... ) */
	public final static int REFERENCE = 3;
	/** Identifies a ENUM or a BOOLEAN */
	public final static int VARIANT = 4;
	/** Identifies a child of a ENUM/BOOLEAN */
	public final static int ENUMERATOR = 5;
	/** Identifies a value (one of valid values of an attribute) */
	public final static int VALUE = 6;
	/** Identifies a range (of an attribute) */
	public final static int RANGE = 7;
	/** Identifies a CDATA node */
	public final static int CDATA = -1;
	/** Identifies an UNKNOW node */
	public final static int UNKNOW = -2;

	/**
	 * Creates a new distinct Pointer with the same current node
	 * 
	 * @return a distinct OilImplPointer (that point to the same node)
	 */
	public IOilImplPointer clone();

	/**
	 * Tries to move pointer to node that is the parent of current node.
	 * 
	 * @return false only if current node is already the root node or if there
	 *         isn't any node.
	 * 
	 * @throws NullPointerException
	 *             if there is a problem with null nodes
	 */
	public boolean goParent();

	/**
	 * Tries to move pointer to node that is the first child of current node.
	 * 
	 * @return false only if current node hasn't children or if there isn't any
	 *         node.
	 */
	public boolean goFirstChild();

	/**
	 * Tries to move pointer to node that is the next sibling of current node.
	 * 
	 * @return false only if current node hasn't any "next" sibling or if there
	 *         isn't any node.
	 */
	public boolean goNextSibling();

	/**
	 * Tries to move pointer to a specified child of current node.
	 * 
	 * @param childName
	 *            identifies the name of a child.
	 * 
	 * @return false only if current node hasn't any child with specified name
	 *         or if there isn't any node.
	 */
	public boolean goChild(String childName);

	/** Returns the description of current node
	 * 
	 * @return the description of current node
	 */
	public IOilImplElementDescr getCurrentDescr();

	/** Returns the description of all children of current node
	 * 
	 * @return the description of all children of current node
	 */
	public IOilImplElementDescr[] getChildrenDescr();

}