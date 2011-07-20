/*
 * Created on Mar 18, 2005
 *
 * $Id: PartialOrderAnalyzer.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.mapping.functionalviewer.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * This class takes a Dag and analyzes it.
 * 
 * Availables operations are :
 * <ul>
 * <li><b>find cycles </b> that search if DAG contains a cycle</li>
 * <li><b>drop useless connections </b> remove connections from a node to all
 * descendats of its children. <br>
 * Ex. if a node <code>A</code> has two children <code>B</code> and
 * <code>C</code>;<code>B</code> has <code>C</code> as its child; The
 * connection from <code>A</code> to <code>C</code> is droped</li>
 * </ul>
 * 
 * @author Nicola Serreli
 */
final class PartialOrderAnalyzer {

	/**
	 * This interface is used to wrapper Node's method for
	 * <code>getChildren</code> and <code>remove a child</code>.
	 */
	public interface Helper {
		/**
		 * Returns all children of a node of the DAG.
		 * 
		 * The returned collection has to support iterator, with methods next(),
		 * hasNext(). Iterator's method remove is not used.
		 * 
		 * @param parent
		 *            a node of DAG. Cannot be null.
		 * 
		 * @return a not null collection with all children of an object. An
		 *         empty collection if parent has no child.
		 * 
		 * @throws NullPointerException
		 *             if parent is null.
		 */
		Collection getChildren(Object parent);

		/**
		 * Removes the connection from parent node to one of its child.
		 * 
		 * This method does nothing it <code>child</code> isn't a child of
		 * <code>parent</code> node. <br>
		 * If <code>parent</code> node contains the specified
		 * <code>child</code> more than one time, this method removes only
		 * one.
		 * 
		 * @param parent
		 *            a node of DAG. Cannot be null.
		 * @param child
		 *            a node of DAG. Cannot be null.
		 * 
		 * @throws NullPointerException
		 *             if parent or child is null.
		 * @throws IllegalArgumentException
		 *             if parent and child are the same object
		 */
		void removeChild(Object parent, Object child);
	}

	// -----------------------------------------------------------------

	/** List of Nodes from which start all computations */
	final private Object[] roots;

	/** Store the helper */
	final private Helper helper;

	// -----------------------------------------------------------------

	/**
	 * Makes a new PartialOrderAnalyser with specified roots and helper.
	 * 
	 * The analyzed DAG is formed by all specified nodes and all theirs
	 * descendants.
	 * 
	 * @param roots
	 *            is a set of nodes that allow to reach all nodes of DAG.
	 * @param helper
	 *            a class that permits to get and remove children from a node.
	 * 
	 * @throws NullPointerException
	 *             if roots is null or helper is null
	 */
	public PartialOrderAnalyzer(Object[] roots, Helper helper) {

		if (roots == null || helper == null) {
			throw new NullPointerException("Roots and helper cannot be null");
		}

		// copy the list of roots
		this.roots = new Object[roots.length];
		System.arraycopy(roots, 0, this.roots, 0, roots.length);

		this.helper = helper;
	}

	/***************************************************************************
	 * 
	 * CYCLE
	 *  
	 **************************************************************************/

	/**
	 * Checks if this DAG contains a cycle.
	 * 
	 * If true, returns the list of node that make the cycle; otherwise returns
	 * null.
	 * 
	 * @return the list of node that make the cycle; otherwise returns a null
	 *         array.
	 */
	public Object[] checkCycle() {

		/*
		 * Use an unique visited node's list for all check to don't check nodes
		 * descendants from more than one root
		 */
		final HashMap visited = new HashMap();
		Object[] answer = null;

		/* Check all roots */
		for (int i = 0; i < roots.length && answer == null; i++) {
			answer = checkCycle(roots[i], new Stack(), visited);
		}

		return answer;
	}

	/***************************************************************************
	 * 
	 * REMOVE USELESS CONNECTIONS
	 *  
	 **************************************************************************/

	/**
	 * Checks if this DAG contains a Useless Connection and then remove them.
	 * 
	 * A Connection is useless if it connect a node to a descendat of one of its
	 * children. <br>
	 * Ex. if a node <code>A</code> has two children <code>B</code> and
	 * <code>C</code>;<code>B</code> has <code>C</code> as its child;
	 * The connection from <code>A</code> to <code>C</code> is useless.
	 * 
	 * @throws IllegalArgumentException
	 *             if the DAG contains a cycle.
	 *  
	 */
	public void removeUselessConnections() {

		/* Check all roots */
		for (int i = 0; i < roots.length; i++) {
			removeUselessConnections(roots[i], new Stack(), new HashMap());
		}

	}

	/***************************************************************************
	 * 
	 * RECURSIVE CHECKS
	 *  
	 **************************************************************************/

	/**
	 * Checks if this current node and its descendants makes a cycle.
	 * 
	 * If true, returns the list of node that make the cycle; otherwise returns
	 * null.
	 * 
	 * @param current
	 *            identifies the current node inside the DAG.
	 * @param parents
	 *            identifies the list of all already visited parent nodes.
	 *            Cannot be null.
	 * @param visited
	 *            contains all nodes of whole DAG already visited. Cannot be
	 *            null.
	 * 
	 * @return the list of node that make the cycle; otherwise returns a null
	 *         array.
	 * 
	 * @throws NullPointerException
	 *             if parents or visited is null
	 */
	protected Object[] checkCycle(Object current, Stack parents, HashMap visited) {

		if (current == null) {
			/*
			 * Nothing to do
			 */
			return null;
		}

		/*
		 * If parents already contains this node, a Cycle is found !!!
		 */
		if (parents.contains(current)) {

			// prepare the list of nodes
			int pos = parents.indexOf(current);
			Object[] answer = new Object[parents.size() - pos];

			System.arraycopy(parents.toArray(), pos, answer, 0, answer.length);
			return answer;
		}

		/*
		 * If this node is already visited, go away
		 */
		if (visited.containsKey(current)) {
			return null;
		}
		visited.put(current, current);

		/*
		 * Check all current node's children
		 */
		Object[] answer = null;
		parents.push(current);

		for (Iterator iter = helper.getChildren(current).iterator(); iter
				.hasNext()
				&& answer == null;) {

			answer = checkCycle(iter.next(), parents, visited);
		}

		parents.pop();

		return answer;
	}

	/**
	 * Recursively remove all useless connections.
	 * 
	 * @param current
	 *            identifies the current node inside the DAG.
	 * @param parents
	 *            identifies the list of all already visited parent nodes.
	 *            Cannot be null.
	 * @param parentDescendants
	 *            will contains all descendants of current node's parent
	 * 
	 * @throws NullPointerException
	 *             if parents or visited is null
	 */
	protected void removeUselessConnections(Object current, Stack parents,
			HashMap parentDescendants) {

		if (current == null) {
			/*
			 * Nothing to do
			 */
			return;
		}

		/*
		 * If parents already contains this node, a Cycle is found !!!
		 */
		if (parents.contains(current)) {

			// prepare the list of nodes
			int pos = parents.indexOf(current);
			Object[] answer = new Object[parents.size() - pos];

			System.arraycopy(parents.toArray(), pos, answer, 0, answer.length);
			throw new IllegalStateException("Found a cycle : "
					+ Arrays.asList(answer));
		}

		/*
		 * If this node is already visited, go away
		 */
		if (parentDescendants.containsKey(current)) {
			return;
		}
		parentDescendants.put(current, current);

		/*
		 * Check all current node's children
		 * 
		 * ___allDescendants___ contains all descendants of current node's
		 * children
		 * 
		 * ___visited___ contains all already visisted children of current node
		 * 
		 * ___toDrop___ contains some children that will be removed (one
		 * instance/time for each object)
		 */
		HashMap allDescendants = new HashMap();
		HashMap visited = new HashMap();
		LinkedList toDrop = new LinkedList();
		parents.push(current);

		for (Iterator iter = helper.getChildren(current).iterator(); iter
				.hasNext();) {

			/*
			 * Get a new child
			 */
			Object child = iter.next();

			/*
			 * Check if current child is already an descendant of another child
			 * of if the same child is stored more than one time
			 */
			if (allDescendants.containsKey(child) || visited.containsKey(child)) {
				// remember to remove it
				toDrop.add(child);

				continue;
			}

			/*
			 * Get all descendant of a child
			 */
			HashMap descendant = new HashMap();
			removeUselessConnections(child, parents, descendant);

			descendant.remove(child);

			// store all descendant ...
			allDescendants.putAll(descendant);
			// ... set this child as "already visited" ...
			visited.put(child, child);
			// ... and set this child as a descendant of current node's parent
			parentDescendants.put(child, child);
		}

		parents.pop();

		/*
		 * Remove first all children stored inside the "toDrop" list
		 */
		for (Iterator iter = toDrop.iterator(); iter.hasNext();) {
			helper.removeChild(current, iter.next());
		}

		/*
		 * Then remove all children that are also descendants of some children
		 */
		for (Iterator iter = helper.getChildren(current).iterator(); iter
				.hasNext();) {

			Object child = iter.next();

			if (allDescendants.containsKey(child)) {
				helper.removeChild(current, child);
			}
		}

		// ... remember all other descendants
		parentDescendants.putAll(allDescendants);

	}

}