/*
 * Created on Aug 30, 2004
 *
 * $Id: ISubVarTreePointer.java,v 1.1 2005/09/28 15:22:29 durin Exp $
 */
package com.eu.evidence.rtdruid.vartree;


import java.util.Stack;


/**
 * @author Nicola Serreli
 */
public interface ISubVarTreePointer {

	public final static int ERROR = -1;

	public final static int OK = 1;

	public final static int BACK_TO_PARENT = 2;

	// ---------------------- CONSTRUCTOR ----------------------

	/**
	 * Makes a copy of current pointer.
	 * 
	 * @return a copy of current pointer.
	 */
	public Object clone();

	// ---------------------- MOVING ----------------------

	/**
	 * Performs one or more steps.
	 * 
	 * @param path
	 *            all steps
	 * 
	 * @return one of ERROR, OK and BACK_TO_PARENT
	 */
	public int makeSteps(Stack path);

	/**
	 * Goes to the first child of the current element.
	 * 
	 * @return true if there's a child. Otherwise returns false and doesn't
	 *         change position on the tree.
	 */
	public int subGoFirstChild();

	/**
	 * Goes to next child, in alphabetical order, of the same parent.
	 * 
	 * @return true if there's a next node. Otherwise returns false and doesn't
	 *         change position on the tree.
	 */
	public int subGoNextSibling();

	/**
	 * Goes to parent node.
	 * 
	 * @return true if there's a parent node. Otherwise returns false and
	 *         doesn't change position on the tree (already on the root).
	 */
	public int subGoParent();

	// ---------------------- GET ----------------------

	/**
	 * Returns the number of children.
	 * 
	 * @return the number of children.
	 */
	public int getChildrenNumber();

	/**
	 * Returns the name of this node.
	 * 
	 * @return the name of this node.
	 */
	public String getName();

	/**
	 * Returns the type of this node.
	 * 
	 * @return the type of this node.
	 */
	public String getType();

	/**
	 * Returns true if this node is a container.
	 * 
	 * @return true if this node is a container, false otherwise.
	 */
	public boolean isContainer();

	/**
	 * Returns true if this node is a list.
	 * 
	 * @return true if this node is a list, false otherwise.
	 */
	public boolean isList();

	// ---------------------- VARIABLE ----------------------

	/**
	 * Returns the variable stored on this node.
	 * 
	 * @throws IllegalStateException
	 *             if current node is a container.
	 */
	public IVariable getVar();

	/**
	 * Returns a new variable valid for current node.
	 * 
	 * @throws IllegalStateException
	 *             if current node is a container.
	 */
	public IVariable getNewVar(String value);

	/**
	 * Sets a variable.
	 * 
	 * @param var
	 *            the new information that will be stored in this node.
	 * 
	 * @throws IllegalStateException
	 *             if current node is a container.
	 * @throws NullPointerException
	 *             if var is null.
	 */
	public void setVar(IVariable var);

	// ---------------------- ADD & REMOVE NODES ----------------------

	/**
	 * Add a new intermediate node to the current node as a new child. The new
	 * child must have a name different from all other children names.
	 * 
	 * @param name
	 *            the name of this node.
	 * @param type
	 *            the type of information.
	 * 
	 * @return the name of added node
	 * 
	 * @throws IllegalArgumentException .
	 * @throws IllegalStateException .
	 * @throws NullPointerException
	 *             if type is.
	 */
	public String add(String name, String type);

	/**
	 * Adds a new Leaf (IVariable) to the current node as a new child. The new
	 * child must have a name different from all other children names.
	 * 
	 * @param name
	 *            the name of this node.
	 * @param var
	 *            the information.
	 * 
	 * @return the name of added node
	 * 
	 * @throws IllegalArgumentException .
	 * @throws IllegalStateException .
	 * @throws NullPointerException
	 *             if name is null.
	 */
	public String add(String name, IVariable var);

	/**
	 * Destroies a node and all its descendants and moves to parent node. If the
	 * current node is the root, clear all the tree and set the pointer to root
	 * node. <br>
	 * NB. This method destroy nodes without notify it to obsesrvers
	 * 
	 * @return one of ERROR, OK and BACK_TO_PARENT
	 */
	public int subDestroy();

	/**
	 * Returns all acceptable child's types for current node. Sometimes a type
	 * is associated to a specific name, in this case that name is the second
	 * string of each element of result. <br>
	 * The answer is something like: { { "new Type", "specific name"},{ "another
	 * new type", null} ....}
	 *  
	 */
	public String[][] getNewChildTypes();

	// ---------------------- OBSERVER ----------------------
	/*
	 * /** Sends a notication to all observer of this node.
	 * 
	 * It needs the path for identify the current node in the tree.
	 * 
	 * @param path the position in the tree of current node. A null path
	 * identifies the root.
	 */
	/*
	 * public void handler(String path);
	 * 
	 * /** Adds an observer
	 * 
	 * @param o the observer.
	 * 
	 * @throws NullPointerException if o is null.
	 */
	/*
	 * public void addObserver(IObserver o);
	 * 
	 * /** Removes an observer. Do nothing if the given observer doesn't exist
	 * or is null.
	 * 
	 * @param o the observer.
	 */
	/*
	 * public void remObserver(IObserver o);
	 * 
	 * /** Removes all observers
	 */
	/*
	 * public void remAllObserver();
	 * 
	 * /** Gets all observers (one copy of the internal list)
	 * 
	 * @return a list of all observers (one copy of the internal list).
	 */
	/*
	 * public LinkedList getAllObserver();
	 */

}