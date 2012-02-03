package com.eu.evidence.rtdruid.internal.vartree;


import java.util.LinkedList;
import java.util.NoSuchElementException;

import org.eclipse.core.runtime.Assert;

import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVarTreePointer;
import com.eu.evidence.rtdruid.vartree.IVariable;
import com.eu.evidence.rtdruid.vartree.IVariable.NotValidValueException;
import com.eu.evidence.rtdruid.vartree.data.init.DataPath;


/**	This class give some handy methods for utilize shared variables identified by a path 
*	(see {@link com.eu.evidence.rtdruid.vartree.IVarTree VarTree}).
*
*	There isn't any control about synchronization.
*
* @author Nicola Serreli
*/
  final public class TreeInterface implements ITreeInterface {
// ----------------------    INFO  ----------------------

	/**	TiInfo class is a structure used in {@link com.eu.evidence.rtdruid.vartree.ITreeInterface#getAll getAll method} for return all info
	*	about a node.
	*
	* @author Nicola Serreli
	*/
	final protected class TiInfoImpl implements ITreeInterface.TiInfo {
		// ----------------------    FIELDS  ----------------------
		
		/** Name */
		private String nome;
		/** IVariable */
		private IVariable dato;
		
		// ----------------------    CONSTRUCTOR  ----------------------
		
		/**	Makes a new TiInfo
		*
		*	@param	name	name
		*	@param	data	the variable
		*	@param	valid	true if this data is valid
		*	@param	defined	true if this node is defined
		*/
		public TiInfoImpl(String name, IVariable data) {
			nome = name;
			dato = data;
		}
		
		// ----------------------    GET  ----------------------
		/** Return name 
		* @return	the name
		*/
		public String getName() {		return nome;	}
		
		/** Return variable or null if it isn't a leaf node
		* @return	the variable
		*/
		public IVariable getVariable() {	return dato;	}
		
		/** Return true if data stored in this node (or in its child) are valid
		* @return	true if data are valid
		* @deprecated
		*/
		public boolean isValid() {		return dato==null ? false : dato.get() == null;	}
		
		/** Return true if this node is defined in Builder Storage
		* @return	true if this node is defined in Builder Storage
		* @deprecated
		*/
		public boolean isDefined() {	return true;	}
		
	}
// ----------------------    FIELDS  ----------------------
	
	private IVarTree vt;
	
// ----------------------    CONSTRUCTOR  ----------------------
	
	/**	Constructor */
	public TreeInterface(IVarTree vt) { this.vt = vt; }
		
// ----------------------    Add && Remove Variables ----------------------
	
	
	/**	Add a variable to share.
	*
	*	This variable can be a simple or a complex structure described into BuilderStorage (identify by type).
	*	Its identification will be the union of parent's identify ("where" parameter) and its name ("name" parameter); this
	*	identification must be different from all other variables.<br> If the parent node is a list of enumerators, the given name
	*	will be substitute with a new name relatives to this parent node.<br>
	*	if an exception occurred, any changes are made to shared tree.
	*	<br> If all ok, send a notification to all observer of parents nodes (one notification for each added node).
	*
	*	@param	name	the name of new variable. It must be different from other siblings' name.
	*	@param	type	the type of new variable. It must be define into BuilderStorage.
	*	@param	where	identify the parent node in the shared tree. It will be the "prefix" of new variable. A null prefix means root node.
	*					The parent node must exist.
	*
	*	@return	the name of new shared data.
	*
	*	@throws	NullPointerException	If one (or more) of name and type is null
	*	@throws	IllegalArgumentException	
	*	@throws	AddElementException	if there's some problems while trying to add the new shared data
	*/
	public String addElement(String name, String type, String where) throws AddElementException {
//		 TODO : attenzione : gestione delle eccezioni, caso : aggiunta di una foglia, observer
		if (type == null) {
			throw new NullPointerException("TreeInterface: addElement with a null type.\n");
		}		
		IVarTreePointer vtp = vt.newVarTreePointer();
		
		if (vtp.goAbsolute(where)) {
			return vtp.add(name, type);
		}
		
		// Not found
		throw new NoSuchElementException("TreeInterface: addElelemt on a not existing node (path =" +
			where + ").\n");
	}
	
	/** Destroy a variable that was shared.
	*
	*	@param	path	identify the shared variable (Absolute path, starting from root node).
	*
	*/
	public void remElement(String path) {
//		 TODO : attenzione : gestione delle eccezioni, observer
		IVarTreePointer vtp = vt.newVarTreePointer();
		
		if (vtp.goAbsolute(path)) {
			vtp.destroy();
		}
	}
	
	
// ----------------------    Add && Remove IObserver ----------------------

	/**	Add a observer to a node. In this way, the observer will know all changes about this node and its children.
	*	If a observer is added more than one time, they're seen like different objects, and if somebody sends a notification,
	*	this notification'll be sent to this observer the same number of times that it was added (and not dropped).
	*
	*	@param	path	identify the shared variable (simple or complex). A null path identify the root Element.
	*	@param	observer	object to which send the notification of a change about this node and/or its children
	*/
	public void addObserver(String path, com.eu.evidence.rtdruid.vartree.IObserver observer) {
		IVarTreePointer point = vt.newVarTreePointer();
		
		// go to the given node ...
		if ( point.goAbsolute(path)) {
			// ... and add the observer
			point.addObserver(observer);
		}
	}
	
	/**	Remove a observer from a node. In this way, the observer stop to know all changes about this node and its children.
	*	If the same observer was added more than one time, this method drops only one "copy".
	*
	*	@param	path	identify the shared variable (simple or complex).  A null path identify the root Element.
	*	@param	observer	a object that was add to this node, and don't want to know other changes about this node and its children.
	*/
	public void remObserver(String path, com.eu.evidence.rtdruid.vartree.IObserver observer) {
		IVarTreePointer point = vt.newVarTreePointer();
		
		// go to the given node ...
		if ( point.goAbsolute(path)) {
			// ... and remove the observer
			point.remObserver(observer);
		}
	}

	
	/** Send a notification to all observer of the node identify by path.
	*	If a observer was added more than one time, this notification'll be sent to this observer
	*	the same number of times that it was added (and not dropped).
	*
	*	@param	path	identify the shared variable (simple or complex). A null path identify the root Element.
	*/
	public void handler(String path) {
//		 TODO : gestione observer
	}
	

	
// ----------------------    GET Value ----------------------

	/**	Return the value of a leaf node.
	*
	*	@param	path	identify the shared variable (simple). A null path identify the root Element.
	*
	*	@return	the value
	*
	*	@throws	IllegalStateException	if the node isn't a leaf
	*	@throws	NoSuchElementException	if there isn't any node at given path
	*/
	public IVariable	getValue(String path) {
		// Pointer to visit the tree
		IVarTreePointer point = vt.newVarTreePointer();
		
		// go to given path
		if ( point.goAbsolute(path)) {
			// get variable
			IVariable tv = point.getVar();
			tv = tv == null ? point.getNewVar(null) : tv ;
			if (tv == null) { /*DEBUG*/			throw new Error("Try to get a not null var");		}
			return tv;
		}

		// Not found
		throw new NoSuchElementException("TreeInterface: getValue on a not existing node (path =" +
			path + ").\n");
	}

	
	/**	Take all values from a group of siblings nodes, in case it's possible to look over only a particular type of node;
	*	if that nodes are complex, it's possible to select the data from a particular component. Because only leaf node contains
	*	data (a value), only this nodes are used to make the answer.
	*
	*	@param	path	identify the path from root node to request node that contains the request data. This path is made with three
	*					parts : a prefix that identify the parent node, the special character that means "all children" and a suffix that
	*					identify the component (leaf node) in each sibling.
	*					<b>prefix / * / suffix</b><br>
	*					where "/" is defined in {@link com.eu.evidence.rtdruid.vartree.IVarTree#SEPARATOR rtdruid.vartree.VarTree.SEPARATOR}<br>
	*					where "*" is defined in {@link com.eu.evidence.rtdruid.vartree.ITreeInterface#SPECIAL rtdruid.vartree.TreeInterface.SEPARATOR}<br>
	*					and prefix and suffix are {@link rtdruid.vartree.VarTree "path"}.
	*	@param	type	a sibling node will be examined only if its type is equals to this parameter. If this parameter is null, all
	*					sibling node will be examined.
	*
	*	@return a array of values, order by the alphabetical order of sibling node that was examined. That array can be empty 
	*			if there isn't any node that respect both path parameter and type parameter.
	*
	*	@throws	NullPointerException	if "path" is null
	*	@throws	IllegalArgumentException	if "path" doesn't contains the substring / * /
	*/
	public IVariable[] getAllValues(String path, String type) {

		if (path == null) {
			throw new NullPointerException("TreeInterface: getAllValues with a null path.\n");
		}


		// Pointer to visit the tree
		IVarTreePointer point = vt.newVarTreePointer();
		
		// Split path and search the special character *
		String percorso[] = DataPath.splitPath(path);
		int index = 0;
		for (index = 0; index < percorso.length; index++) {
			if ( (percorso[index]).compareTo(Character.toString(SPECIAL))==0)
				break;	// found special character *
				
			// Move the pointer on the path to the last node before special character
			// might happen that the last node is the root node
			point.go(percorso[index]);
		}
		
		if (index == percorso.length) {
			throw new IllegalArgumentException("TreeInterface: Given path doesn't contains the substring /*/.\n\tPath = " +
				path);
		}

			
		StringBuffer tmp = new StringBuffer(path.length());
		// Rewrite the children path (after special character)
		if (index+1 < percorso.length) {
			tmp.append(percorso[index+1]);
		}
		for (int i=index+2; i < percorso.length; i++) {
			tmp.append(IVarTree.SEPARATOR);
			tmp.append(percorso[i]);
		}
		// children path
		String pathChild = tmp.toString();
		
		LinkedList risp = new LinkedList();
		
		// check if there're any child
		if (!point.goFirstChild()) 
			return (IVariable[]) risp.toArray(new IVariable[0]);
			
			
		// inspect all children
		do {
			IVarTreePointer figli = (IVarTreePointer) point.clone();

			// if the given type isn't null, I check if the type of this node is the given type
			if (type != null) {
				if ( !type.equals(figli.getType()) ) {
					// not match -> then inspect the next child
					continue;
				}
			}
			
			// move on the children path, if there is one
			if (pathChild.length() > 0) {
				if (!figli.go(pathChild) ) {
					// There isn't the request node -> then inspect the next child
					continue;
				}
					
			}
			
			// get variable, if it's a leaf node
			if ( !figli.isContainer() ) {
				IVariable tv = figli.getVar(); 
				if (tv != null) {
					//risp.add( tv == null ? point.getNewVar() : tv);
					risp.add(tv);
				}
			}

		} while (point.goNextSibling());
		
		return (IVariable[]) risp.toArray( new IVariable[0] );
	}


	/**	Take all name of some siblings nodes, in case it's possible to look over only a particular type of node.
	*
	*	@param	path	identify the parent node.
	*	@param	type	identify which type of node will be examined. A null parameter means all type.
	*
	*	@return a array of names, order by alphabetical order.
	*			It can be empty if there isn't any child that respect both path parameter and type parameter.
	*/
	public String[] getAllName(String path, String type) {
		
		// Pointer to visit the tree
		IVarTreePointer point = vt.newVarTreePointer();
		
		LinkedList risp = new LinkedList();

		// go to parent node
		if ( !point.goAbsolute(path) ) {
			return (String[]) risp.toArray( new String[0] );
		}
		
		// check if there're any child
		if (!point.goFirstChild()) 
			return (String[]) risp.toArray( new String[0] );
			
		// inspect all children
		do {
			
			// if the given type isn't null, I check if the type of this node is the given type
			if (type != null) {
				if ( !type.equalsIgnoreCase(point.getType()) ) {
					// not match -> then inspect the next child
					continue;
				}
			}
			
			// add the node's name to the answer
			risp.add(point.getName());

		} while (point.goNextSibling());
		
		return (String[]) risp.toArray( new String[0] );
	}

	/**	Tell if exist a node
	*
	*	@param	path	identify the node.
	*  @param type if not null, defined the last node's type
	*
	*	@return	true if exist a node with given path 
	*/
	public boolean exist(String path, String type) {

		// moving to requested node
		IVarTreePointer point = vt.newVarTreePointer();
		
		boolean risp = point.goAbsolute(path);
		if (type != null && risp) {
			risp &= point.getType().equals(type);
		}

		// the answer
		return risp;
	}

/*	/**	Tell if the data in a simple or complex node is valid or no. Checks all nodes in the path.
	*
	*	@param	path	identify the node.
	*
	*	@return	true if the data in a simple or complex node is valid, false otherwise.
	*	@deprecated
	*/
/*	public boolean isValid(String path) {
		boolean risp = true;
		
		// split path
		String[] pathElement = DataPath.splitPath(path);
		
		// moving to requested node
		IVarTreePointer point = vt.newVarTreePointer();
		
		for (int i =0; i< pathElement.length; i++) {
			risp &= point.go(pathElement[i]);	// go to request node
			risp &= point.isValid();			// take the answer
			
			// stop : the answer is false
			if ( !risp ) 
				return false;
		}
		// the answer
		return risp;
	}*/
	
/*	/**	Tell if the type of node (simple or complex) is defined in BuilderStorage or no. Checks all nodes in the path.
	*
	*	@param	path	identify the node.
	*
	*	@return	true if the type of given node is defined in BuilderStorage, false otherwise.
	*	@deprecated
	*/
/*	public boolean isDefined(String path) {
		boolean risp = true;
		
		// split path
		String[] pathElement = DataPath.splitPath(path);
		
		// moving to requested node
		IVarTreePointer point = vt.newVarTreePointer();
		
		for (int i =0; i< pathElement.length; i++) {
			risp &= point.go(pathElement[i]);	// go to request node
			risp &= point.isDefined();			// take the answer
			
			// stop : the answer is false
			if ( !risp ) 
				return false;
		}
		// the answer
		return risp;
	}*/

	
	
	/**	Take all info (name, value, isValid, isDefined) from a group of siblings nodes, in case it's possible to look over only a particular type of node;
	*	if that nodes are complex, it's possible to select the data from a particular component. Because only leaf node contains
	*	data (a value), only this nodes have a not null value.
	*
	*	@param	path	identify the path from root node to request node that contains the request data. This path is made with three
	*					parts : a prefix that identify the parent node, the special character that means "all children" and a suffix that
	*					identify the component (leaf node) in each sibling.
	*					<b>prefix / * / suffix</b><br>
	*					where "/" is defined in {@link com.eu.evidence.rtdruid.vartree.IVarTree#SEPARATOR rtdruid.vartree.VarTree.SEPARATOR}<br>
	*					where "*" is defined in {@link com.eu.evidence.rtdruid.vartree.ITreeInterface#SPECIAL rtdruid.vartree.TreeInterface.SEPARATOR}<br>
	*					and prefix and suffix are {@link rtdruid.vartree.VarTree "path"}.
	*	@param	type	a sibling node will be examined only if its type is equals to this parameter. If this parameter is null, all
	*					sibling node will be examined.
	*
	*	@return a array of {@link com.eu.evidence.rtdruid.vartree.ITreeInterface.TiInfo TiInfo}, order by the alphabetical order of sibling node that was examined.
	*		That array can be empty	if there isn't any node that respect both path parameter and type parameter.
	*
	*	@throws	IllegalArgumentException	if "path" doesn't contains the substring / * /
	*	@throws	NullPointerException	if "path" is null
	*/
	public TiInfo[] getAll(String path, String type) {
		
		if (path == null) {
			throw new NullPointerException("TreeInterface: getAllValues with a null path.\n");
		}
		
		// Pointer to visit the tree
		IVarTreePointer point = vt.newVarTreePointer();
		
		// Split path and search the special character *
		String percorso[] = DataPath.splitPath(path);
		
		int index = 0;
		for (index = 0; index < percorso.length; index++) {
			if ( (percorso[index]).compareTo(Character.toString(SPECIAL))==0)
				break;	// found special character *
				
			// Move the pointer on the path to the last node before special character
			// might happen that the last node is the root node
			if ( !point.go(percorso[index]) ) {
				// no elements
				return new TiInfo[0];
			}
		}
		
		if (index == percorso.length) {
			throw new IllegalArgumentException("TreeInterface: Given path doesn't contains the substring /*/.\n\tPath = " +
				path);
		}
		
		LinkedList risp = new LinkedList();
		// check if there're any child
		if (!point.goFirstChild()) 
			return (TiInfo[]) risp.toArray( new TiInfo[0] );
			
		// inspect all children
		do {
			
			IVarTreePointer figli = (IVarTreePointer) point.clone();

			// if the given type isn't null, I check if the type of this node is the given type
			if (type != null) {
				if ( !type.equals(figli.getType()) ) {
					// not match -> then inspect the next child
					continue;
				}
			}

			boolean stop = false;
			// move to requested node and save the valid value 
			for (int i=index+1; i < percorso.length; i++) {
				if ( !figli.go(percorso[i]) ) {
				// There isn't the request node -> then inspect the next child
					stop = true;
					break;
				}
				
			}
			if (stop) continue;
					
			// get all info about this node
			IVariable dato = null;
			if ( !figli.isContainer() ) {
				// get data, if this node is a leaf
				dato = figli.getVar();
			}
			// add info to answer
			risp.add( new TiInfoImpl( point.getName(), dato ) );
		} while (point.goNextSibling());
		
		return (TiInfo[]) risp.toArray( new TiInfo[0]);
	}
	
	
// ----------------------    SET Value  ----------------------
	
	/**	Set the value of a leaf node. This method drops the older IVariable and store the given one.
	*
	*	@param	path	identify the shared variable (simple). A null path identify the root Element.
	*	@param var	the new value
	*
	*	@throws	IllegalStateException	if the node isn't a leaf
	*	@throws	NoSuchElementException	there isn't the node
	*/
	public void setValue(String path, IVariable var) {
		// Pointer to visit the tree
		IVarTreePointer point = vt.newVarTreePointer();
		
		// go to given node
		if (!point.goAbsolute(path)) {
			// not found
			throw new NoSuchElementException( "TreeInterface : setValue(string,IVariable) at a no-existent node.\n");
		}
		// set variable
		point.setVar(var);
	}	

	
	/**	Set the value of a leaf node.
	*
	*	@param	path	identify the shared variable (simple). A null path identify the root Element.
	*	@param data		the string representation of new value
	*
	*	@throws	IllegalStateException	if the node isn't a leaf
	*	@throws	NoSuchElementException	there isn't the node
	*	@throws	OutOfBoundsException	if is set a range of acceptable values	and the given value isn't in this range.
	*	@throws NotValidValueException	if is set a list of acceptable values and the given value isn't in this list.
	*/
	public void setValue(String path, String data) {
		// Pointer to visit the tree
		IVarTreePointer point = vt.newVarTreePointer();
		
		// go to given node
		if (!point.goAbsolute(path)) {
			// not found
			throw new NoSuchElementException( "TreeInterface : setValue(string,String) at a no-existent node.\n\tpath = " + 
				path);
		}
		// set variable
		IVariable var = point.getVar();
		if (var == null) {
			var = point.getNewVar(data);
		} else {
			var.set(data);
		}
		point.setVar(var);
	}	
	
	/**	Set all values in a group of siblings nodes, in case it's possible to look over only a particular type of node;
	*	if that nodes are complex, it's possible to set the data in a particular component. Because only leaf node contains
	*	data (a value), only this nodes are used.  This method drops all Variables that were stored in nodes and replace them
	*	with given variables.
	*
	*	@param	path	identify the path from root node to request node that will contain the given data. This path is made with three
	*					parts : a prefix that identify the parent node, the special character that means "all children" and a suffix that
	*					identify the component (leaf node) in each sibling.
	*					<b>prefix / * / suffix</b><br>
	*					where "/" is defined in {@link com.eu.evidence.rtdruid.vartree.IVarTree#SEPARATOR rtdruid.vartree.VarTree.SEPARATOR}<br>
	*					where "*" is defined in {@link com.eu.evidence.rtdruid.vartree.ITreeInterface#SPECIAL rtdruid.vartree.TreeInterface.SEPARATOR}<br>
	*					and prefix and suffix are {@link rtdruid.vartree.VarTree "path"}.
	*	@param	type	a sibling node will be considerate only if its type is equals to this parameter. If this parameter is null, all
	*					sibling node will be considerate.
	*	@param	var		a array of values, order by the alphabetical order of sibling node in which data will be store. That array can be empty 
	*					and nothing will be store.
	*
	*	@throws	IllegalArgumentException	if "path" doesn't contains the substring / * /
	*	@throws	NullPointerException	if "path" is null
	*/
	public void setAllValue(String path, String type, IVariable[] var) {
		
		if (path == null) {
			throw new NullPointerException("TreeInterface: getAllValues with a null path.\n");
		}
		
		// Pointer to visit the tree
		IVarTreePointer point = vt.newVarTreePointer();
		
		// Split path and search the special character *
		String percorso[] = DataPath.splitPath(path);
		
		int index =0;
		for (index = 0; index < percorso.length; index++) {
			if ( (percorso[index]).compareTo(Character.toString(SPECIAL))==0)
				break;	// found special character *
				
			// Move the pointer on the path to the last node before special character
			// might happen that the last node is the root node
			point.go(percorso[index]);
		}

		if (index == percorso.length) {
			throw new IllegalArgumentException("TreeInterface: Given path doesn't contains the substring /*/.\n\tPath = " +
				path);
		}
			
		StringBuffer tmp = new StringBuffer(path.length());
		// Rewrite the children path (after special character)
		if (index+1 < percorso.length) {
			tmp.append(percorso[index+1]);
		}
		for (int i=index+2; i < percorso.length; i++) {
			tmp.append(IVarTree.SEPARATOR);
			tmp.append(percorso[i]);
		}
		// children path
		String pathChild = tmp.toString();
				
		// This variable help to count the position on the given array
		int nVar = 0;
		
		// inspect all children
		do {
			
			// check if I consume all data in the given array
			if (nVar >= var.length )
				break; // finish
			
			IVarTreePointer figli = (IVarTreePointer) point.clone();

			// if the given type isn't null, I check if the type of this node is the given type
			if (type != null) {
				if ( !type.equals(figli.getType()) ) {
					// not match -> then inspect the next child
					continue;
				}
			}
			
			// move on the children path, if there is one
			if (pathChild.length() > 0) {
				if (!figli.go(pathChild) ) {
					// There isn't the request node -> then inspect the next child
					continue;
				}
			}
			
			// set a new value for this node, if it's a leaf node
			if ( !figli.isContainer() ) {
				
				figli.setVar( var[nVar]);
				nVar++;
				
			}

		} while (point.goNextSibling());
		
	}

/*	/**	Set if the data in a simple or complex node is valid or no. This method doesn't change values of the nodes in the path.
	*
	*	@param	path	identify the node.
	*	@param	value	true if the data in a simple or complex node is valid, false otherwise.
	* @deprecated
	*/
/*	public void setValid(String path, boolean value) {
		IVarTreePointer point = vt.newVarTreePointer();
		if ( point.goAbsolute(path) )	// go to given node
			point.setValid(value);		// if it exist, set "isValid" value
	}*/
	
	/*
	 * 
	 */
	
	public IVarTreePointer makePath(IVarTreePointer vtp, String[] names,
			String[] types) {
		// if vtp, names or types is null it will throw an NullPointerException;
		// If the code is correct, it will never throw that exception.
		// Otherwise I need to add a check for array's lengths
		Assert.isLegal(names.length == types.length);

		//System.out.println("Path");
		//for (int i=0; i< names.length; i++) {
		//	System.out.println("\t" +names[i] + "-" + types[i]);
		//}
		// use a copy !
		vtp = (IVarTreePointer) vtp.clone();

		for (int i = 0; i < names.length; i++) {
			// try to go into the required node
			
			if (!vtp.go(names[i]/*DataPath.addSlash(names[i])*/)) {
				String newName = null;
				// try to add it
				try{
					newName = vtp.add(DataPath.removeSlash(names[i]), types[i]);
				}catch(Exception e){
					e.printStackTrace();
					throw new RuntimeException("Cannot create " + names[i] 
					        + " ("+types[i]+"): " + e.getMessage(), e);
				}

				// try again to go in the new node
				if (!vtp.go(names[i]/*DataPath.addSlash(names[i])*/)) {
					
					
					if (vtp.go(newName)) {
						// may happen with oil enumerators
						// RtdruidLog.showDebug("Check makePath .....");
					} else {
					
						if(vtp.getVar()==null){
							throw new RuntimeException(
									"Error when try to add a node :\n\t" + "name = "
										+ names[i] + " ,type = " + types[i]);
						}
					}
				}
			}
		}
		return vtp;
	}

}
