package com.eu.evidence.rtdruid.vartree;


import java.util.NoSuchElementException;

import com.eu.evidence.rtdruid.vartree.IVariable.NotValidValueException;

/**	This interface give some handy methods for utilize shared variables identified by a path 
*	(see {@link com.eu.evidence.rtdruid.vartree.IVarTree VarTree}).
*
*	There isn't any control about synchronization.
*
* @author Nicola Serreli
*/
  public interface ITreeInterface {
// ----------------------    INFO  ----------------------

	/**	TiInfo class is a structure used in {@link com.eu.evidence.rtdruid.vartree.ITreeInterface#getAll getAll method} for return all info
	*	about a node.
	*
	* @author Nicola Serreli
	*/
	public interface TiInfo {
		
		// ----------------------    GET  ----------------------
		/** Return name 
		* @return	the name
		*/
		public String getName();
		
		/** Return variable or null if it isn't a leaf node
		* @return	the variable
		*/
		public IVariable getVariable();
	}
// ----------------------    FIELDS  ----------------------
	/** This special character is used in {@link com.eu.evidence.rtdruid.vartree.ITreeInterface#getAll getAll method},
	* {@link com.eu.evidence.rtdruid.vartree.ITreeInterface#getAllValues getAllValues method} 
	* and {@link com.eu.evidence.rtdruid.vartree.ITreeInterface#setAllValue setAllValue method} to point to a group of sibling node.
	*/
	final public static char SPECIAL = '*';
		
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
	public String addElement(String name, String type, String where) throws AddElementException;
	
	/** Destroy a variable that was shared.
	*
	*	@param	path	identify the shared variable (Absolute path, starting from root node).
	*
	*/
	public void remElement(String path);
	
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
	public IVariable	getValue(String path);

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
	public IVariable[] getAllValues(String path, String type);

	/**	Take all name of some siblings nodes, in case it's possible to look over only a particular type of node.
	*
	*	@param	path	identify the parent node.
	*	@param	type	identify which type of node will be examined. A null parameter means all type.
	*
	*	@return a array of names, order by alphabetical order.
	*			It can be empty if there isn't any child that respect both path parameter and type parameter.
	*/
	public String[] getAllName(String path, String type);
	
	/**	Tell if exist a node
	*
	*	@param	path	identify the node.
	*  @param type if not null, defined the last node's type
	*
	*	@return	true if exist a node with given path 
	*/
	public boolean exist(String path, String type);
	
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
	public TiInfo[] getAll(String path, String type);
	
// ----------------------    SET Value  ----------------------
	
	/**	Set the value of a leaf node. This method drops the older IVariable and store the given one.
	*
	*	@param	path	identify the shared variable (simple). A null path identify the root Element.
	*	@param var	the new value
	*
	*	@throws	IllegalStateException	if the node isn't a leaf
	*	@throws	NoSuchElementException	there isn't the node
	*/
	public void setValue(String path, IVariable var);	

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
	public void setValue(String path, String data);	
	
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
	public void setAllValue(String path, String type, IVariable[] var);

// ----------------------    Exceptions ----------------------
	
	/** This exception is throw if a exception is happening during a joined of a new shared variable
	 * @author Nicola Serreli 
	 */
	static public class AddElementException extends Exception {
		/**
		 * 
		 */
		private static final long serialVersionUID = -6291660748519317034L;

		public AddElementException(String msg) {
			super(msg);
		} 
	}
	
	public IVarTreePointer makePath(IVarTreePointer vtp, String[] names,
			String[] types);
}
