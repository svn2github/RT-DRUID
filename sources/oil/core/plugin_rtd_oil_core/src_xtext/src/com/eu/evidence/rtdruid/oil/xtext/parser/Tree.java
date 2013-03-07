/**
 * 23/lug/2012
 */
package com.eu.evidence.rtdruid.oil.xtext.parser;

import java.util.ArrayList;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
 public  class  Tree <T> implements Cloneable {
	 public interface CloneElement <R> {
		 public R clone();
	 }
	 
	 /**
	  * A node of the tree
	  *
	  * @author Nicola Serreli
	  * @since 2.0
	  *
	  * @param <R> The data type
	  */
	 protected static class Container<R> implements Cloneable {
		 final R element;
		 
		 Container<R> parent;
		 Container<R> next;
		 
		 ArrayList<Container<R>> children;
		 
		 /**
		 * 
		 */
		public Container(R element) {
			this.element = element;
			this.children = new ArrayList<Tree.Container<R>>();
		}
		
		/**
		 * Creates and add a new child node with the specified data
		 * 
		 * @param element is the data to store in the new child node
		 */
		public void addChild(R element) {
			addChild(new Container<R>(element));
		}
		
		/**
		 * Add a new child node. It adjust also pointers to and from the new child
		 * 
		 * @param element is the new child
		 */
		private void addChild(Container<R> newChild) {
			newChild.parent = this;
			if (children.size() >0) {
				Container<R> lastChild = children.get(children.size()-1);
				lastChild.next = newChild;
			}
			
			children.add(newChild);
		}
		
		/**
		 * Clones this node and all its descendants. Data elements are not cloned
		 */
		public Container<R> clone() {
			@SuppressWarnings("unchecked")
			R newElement = element instanceof CloneElement ? ((CloneElement<R>)element).clone() : element;
			Container<R> answer = new Container<R>(newElement);
			for (Container<R> child : children) {
				answer.addChild(child.clone());
			}
			return answer;
		}
	 }
	 
	 //----------------------------------
	 
	 /** The root of the tree */
	 protected Container<T> root = null;

	 /**
	 * 
	 */
	public Tree() {
	}
	
	/** Clone the tree. Data elements are not cloned */
	public Tree<T> clone() {
		Tree<T> newTree = new Tree<T>();
		if (root != null) {
			newTree.root = root.clone();
		}
		
		return newTree;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	// ------------------------------------
	
	/**
	 * Get a pointer to navigate the tree
	 */
	public TreePointer getPointer() {
		return new TreePointer(root);
	}
	
	
	/**
	 * A simple pointer that allow to navigate the tree
	 *
	 * @author Nicola Serreli
	 * @since 2.0
	 *
	 */
	public class TreePointer implements Cloneable {
		
		/** Current node */
		protected Container<T> pointer;
		
		/**
		 * 
		 * @param pointer
		 */
		protected TreePointer(Container<T> pointer) {
			this.pointer = pointer;
		}
		
		
		public T get() {
			return pointer.element;
		}
		
		public boolean hasSibling() {
			return pointer.next!=null;
		}
		
		public boolean hasChildren() {
			return !pointer.children.isEmpty();
		}
		
		public int childrenSize() {
			return pointer.children.size();
		}
		
		
		// -----------------
		
		/**
		 * 
		 */
		public boolean goParent() {
			if (pointer.parent != null) {
				pointer = pointer.parent;
				return true;
			}
			return false;
		}
		
		public boolean goFirstChildren() {
			if (pointer.children.size() >0) {
				pointer = pointer.children.get(0);
				return true;
			}
			return false;
		}
		
		public boolean goNextSibling() {
			if (pointer.next != null) {
				pointer = pointer.next;
				return true;
			}
			return false;
		}
		
		// -----------------
		
		public void addChild(T element) {
			if (pointer == null) {
				root = new Container<T>(element);
				pointer = root;
			} else {
				pointer.addChild(element);
			}
		}

		// the sibling is added as the last child
//		public void addSibling(T element) {
//			pointer.parent.addChild(element);
//		}
		
		public TreePointer clone() {
			return new TreePointer(pointer);
		}
		
		public void clone(TreePointer obj) {
			pointer = obj.pointer;
		}
	}
	

}
