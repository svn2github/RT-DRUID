package com.eu.evidence.rtdruid.vartree;

import java.util.Collection;

import org.eclipse.core.runtime.AssertionFailedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;





/**	This interface affords to visit the tree of shared variables ({@link com.eu.evidence.rtdruid.vartree.IVarTree}).
 * 
 * @author Nicola Serreli
*/
public interface IVarTreePointer extends Cloneable {
	
	// ----------------------    CONSTRUCTOR  ----------------------
	
	/** Makes a copy of current pointer.
	*
	*	@return	a copy of current pointer.
	*/
	public IVarTreePointer clone();
	
	// ----------------------    MOVING ----------------------
	
	/**	Goes to the variable identified by path, starting from root node.
	*	For the complete definition of path see {@link com.eu.evidence.rtdruid.vartree.IVarTree VarTree}.
	*
	*	@param	path	position of variable in the tree (from the root).
	*
	*	@return	true if it exist. Otherwise returns false and doesn't change position in the tree.
	*/
	public boolean goAbsolute(String path);
	
	/**	Goes to the variable identified by path, starting from current Element.
	*	For the complete definition of path see {@link com.eu.evidence.rtdruid.vartree.IVarTree VarTree}.
	*
	*	@param	path	position of variable in the tree (from the current Element).
	*
	*	@return	true if it exist. Otherwise returns false and doesn't change position in the tree.
	*
	*	@throws	NullPointerException	if path is null.
	*/
	public boolean go(String path);

	/**	Tells if the variable identified by path exist, starting from root.
	*	For the complete definition of path see {@link com.eu.evidence.rtdruid.vartree.IVarTree VarTree}.
	*
	*	@param	path	position of variable in the tree (from the root). A null path means the root node.
	*
	*	@return	true if it exist, false otherwise.
	*/
	public boolean existAbsolute(String path);
	
	/**	Tells if the variable identified by path exist, starting from current Element.
	*	For the complete definition of path see {@link com.eu.evidence.rtdruid.vartree.IVarTree VarTree}.
	*
	*	@param	path	position of variable in the tree (from the current Element).
	*
	*	@throws	NullPointerException	if path is null.
	*
	*	@return	true if it exist, false otherwise.
	*/
	public boolean exist(String path);

	/** Goes to the first child of the current element.
	*
	*	@return	true if there's a child. Otherwise returns false and doesn't change position on the tree.
	*/
	public boolean goFirstChild();

	/**	Returns the number of children.
	*
	*	@return the number of children.
	*/
	public int getChildrenNumber();

	/** Goes to next child, in alphabetical order, of the same parent.
	*
	*	@return	true if there's a next node. Otherwise returns false and doesn't change position on the tree.
	*/
	public boolean goNextSibling();

	/** Goes to parent node.
	*
	*	@return	true if there's a parent node. Otherwise returns false and doesn't change position on the tree (already on the root).
	*/
	public boolean goParent();	
	
	// ----------------------    READ & WRITE  ----------------------
	
	/** Returns true if there is a variable stored on this node.
	*
	*	@throws IllegalStateException	if current node is a container.
	*/
	public boolean isVarSet();

	/** Returns the variable stored on this node.
	*
	*	@throws IllegalStateException	if current node is a container.
	*/
	public IVariable getVar();

	/** Returns a new variable valid for current node.
	*
	*	@throws IllegalStateException	if current node is a container.
	*/
	public IVariable getNewVar();
	
	/** Returns a new variable valid for current node.
	*
	*	@throws IllegalStateException	if current node is a container.
	*/
	public IVariable getNewVar(String initialValue);

	/** Returns the default value of a new variable valid for current node.
	*
	*	@throws IllegalStateException	if current node is a container.
	*/
	public Object getDefaultValue();
	
	/** Sets a variable.
	*
	*	@param	var	the new information that will be stored in this node. 
	*
	*	@throws IllegalStateException	if current node is a container.
	*	@throws	NullPointerException	if var is null.
	*/
	public void setVar(IVariable var);

	/** Returns the name of this node.
	*
	*	@return	the name of this node.
	*/
	public String getName();

	/** Returns the description of this node.
	*
	*	@return	the description of this node.
	*	@deprecated
	*/
//	public String getDescription();

	/**	Sets the description of this node.
	*
	*	@param 	txt		the description or null to remove the old one.
	*	@deprecated
	*/
//	public void setDescr(String txt);
	
	/** Returns the type of this node.
	*
	*	@return the type of this node.
	*/
	public String getType();

	/**	Returns true if this node is a container.
	*
	*	@return true if this node is a container, false otherwise.
	*/
	public boolean isContainer();
	
	/**     Returns true if this node is a List.
	*
	*	@return true if this node is a list, false otherwise.
	*/
	public boolean isList(); 

	/**     Returns true if this node is a reference.
	*
	*       @return true if this node is a reference, false otherwise.
	*	@deprecated
	*/
//	public boolean isReference();

	/**	Sets if this node is defined in {@link rtdruid.vartree.BuilderStorage BuilderStorage}.
	*
	*	@param 	value	the new value.
	*	@deprecated
	*/
//	public void setDefined(boolean value); 

	/**	Sets if data in this node are valid.
	*
	*	@param 	value	the new value.
	*	@deprecated
	*/
//	public void setValid(boolean value);

	/**	Gets if this node is defined.
	*
	*	@return 	true if this node is defined.
	*	@deprecated
	*/
//	public boolean isDefined();

	/**	Gets if data in this node are valid.
	*
	*	@return 	true if data are valid.
	*	@deprecated
	*/
//	public boolean isValid();	

	/**	Sets if option "WITH_AUTO" is set for data in this node.
	*
	*	@param 	value	the new value.
	*	@deprecated
	*/
//	public void setWithAuto(boolean value);

	/**	Gets if option "WITH_AUTO" is set for data in this node.
	*
	*	@return 	true if option is set.
	*	@deprecated
	*/
//	public boolean getWithAuto();	
	
	
	/** Tells if this node (LIST) can have more then one values
	*
	*	@return	true if this node can have more than one child
	*
	*   @throws IllegalStateException    if the current Node isn't a list.
	*	@deprecated
	*/
//	public boolean getMultipleValuesList();

	/** Tells the next serial number for this node (LIST)
	*
	*	@return	true the next serial number for this node (LIST)
	*
	*   @throws IllegalStateException    if the current Node isn't a list.
	*	@deprecated
	*/
//	public int getSerialNumber();
	
	// ----------------------    ADD & REMOVE NODES  ----------------------
	
	/** Adds a new list of nodes in the tree.
	*	The new child must have a name different from all other children names.
	*
	*	@param name		the name of this node.
	*	@param type 	the type of this list.
	*	@param text		a description about this node (optional).
	*	@param multipleValues	true if this list can have more the one child
	*
	*	@return the name of added node
	*
	*	@throws	IllegalArgumentException	if name is a zero length name or if the name contain a separator character.
	*	@throws	IllegalStateException	 if the current Node is a leaf or if there is already another child with the same name of the given one.
	*	@throws NullPointerException	 if one (or more) of this parameter is null: name, type or variable.
	*	@deprecated
	*/	
//	public String addList(String name, String type, String text, boolean multipleValues);
	
	/** Add sa new reference to another node in the tree.
	*	The new child must have a name different from all other children names.
	*
	*	@param name		the name of this node.
	*	@param type 	the type of referenced node.
	*	@param var		the path of referenced node.
	*	@param text		a description about this reference (optional).
	*
	*	@return the name of added node
	*
	*	@throws	IllegalArgumentException	if name is a zero length name or if the name contain a separator character.
	*	@throws	IllegalStateException	 if the current Node is a leaf or if there is already another child with the same name of the given one.
	*	@throws NullPointerException	 if one (or more) of this parameter is null: name, type or variable.
	*	@deprecated
	*/	
//	public String addReference(String name, String type, IVariable var, String text);

	/** Adds a new Leaf (IVariable) to the current node as a new child.
	*	The new child must have a name different from all other children names.
	*
	*	@param name		the name of this node.
	*	@param type 	the type of information.
	*	@param var		the information.
	*	@param text		a description about this leaf (optional).
	*
	*	@return the name of added node
	*
	*	@throws	IllegalArgumentException	if name is a zero length name or if the name contain a separator character.
	*	@throws	IllegalStateException	 if the current Node is a leaf or if there is already another child with the same name of the given one.
	*	@throws NullPointerException	 if one (or more) of this parameter is null: name, type or variable.
	*	@deprecated
	*/	
//	public String add(String name, String type, IVariable var, String text); 

	/** Add a new intermediate node to the current node as a new child.
	*	The new child must have a name different from all other children names.
	*
	*	@param name		the name of this node.
	*	@param type 	the type of information.
	*	@param text		a description about this node (optional).
	*
	*	@return the name of added node
	*
	*	@throws	IllegalArgumentException	if name is a zero length name or if the name contain a separator character.
	*	@throws	IllegalStateException	 if the current Node is a leaf or if there is already another child with the same name of the given one.
	*	@throws NullPointerException	if one (or more) of this parameter is null: name, type or variable.
	*	@deprecated
	*/	
//	public String add(String name, String type, String text);

	
	/** Add a new intermediate node to the current node as a new child.
	*	The new child must have a name different from all other children names.
	*
	*	@param name		the name of this node.
	*	@param type 	the type of information.
	*
	*	@return the name of added node
	*
	*	@throws	IllegalArgumentException	.
	*	@throws	IllegalStateException	 .
	*	@throws NullPointerException	if type is.
	*/	
	public String add(String name, String type);
	
	/** Adds a new Leaf (IVariable) to the current node as a new child.
	*	The new child must have a name different from all other children names.
	*
	*	@param name		the name of this node.
	*	@param var		the information.
	*
	*	@return the name of added node
	*
	*	@throws	IllegalArgumentException	.
	*	@throws	IllegalStateException	 .
	*	@throws NullPointerException	 if name is null.
	*/	
	public String add(String name, IVariable var);

	
	/** Destroies a node and all its descendants and moves to parent node.
	*	If the current node is the root, clear all the tree and set the pointer to root node.
	*	<br>NB. This method destroy nodes without notify it to obsesrvers
	*/
	public void destroy();

	/** Returns all aceptables child's types for current node.
	 * Sometimes a type is associated to a specific name, in this case that name 
	 * is the second string of each element of result. <br>
	 * The answer is something like: { { "new Type", "specific name"},{ "another new type", null} ....} 
	 * 
	 * */
	public String[][] getNewChildTypes();

// ----------------------    type Path  ----------------------

	/**	Returns a String with contains all types from root node to current node, first fair parents and at the end the current node.
	*
	*	@param	separator the character used to separate a type from another ( maybe {@link rtdruid.vartree.BuilderStorage#SEPARATOR
	*	rtdruid.vartree.BuilderStorage.SEPARATOR})
	*
	*	@return all types, from root node to current node. Null if this is root node
	*@deprecated
	*/
//	public String typePath(char separator);

	
	/**
	 * This method ensure that a path exist; if one or more elements doesn't
	 * exist, the method creates them; Throws a RuntimeException if there are
	 * some problems. <br>
	 * Current IVarTreePointer is modified and it will point to the last node of
	 * the given path.
	 * 
	 * @param names
	 *            names of each step (without slashes)
	 * @param types
	 *            the type of each step
	 * 
	 * @return a reference to this pointer.
	 * 
	 * @throws AssertionFailedException if names or types is null.
	 * 
	 * @throws IllegalArgumentException if names and types parameters have different size
	 * 
	 * @throws RuntimeException
	 *             if there is a problem adding elements.
	 */
	public IVarTreePointer makePath(Collection<String> names, Collection<String> types);
	
	/**
	 * This method ensure that a path exist; if one or more elements doesn't
	 * exist, the method creates them; Throws a RuntimeException if there are
	 * some problems. <br>
	 * Current IVarTreePointer is modified and it will point to the last node of
	 * the given path.
	 * 
	 * @param names
	 *            names of each step (without slashes)
	 * @param types
	 *            the type of each step
	 * 
	 * @return a reference to this pointer.
	 * 
	 * @throws AssertionFailedException if names or types is null.
	 * 
	 * @throws IllegalArgumentException if names and types parameters have different size
	 * 
	 * @throws RuntimeException
	 *             if there is a problem adding elements.
	 */
	public IVarTreePointer makePath(String[] names, String[] types);
	
	
	interface EmfPoint {
		public EObject getEObject();
		public EStructuralFeature getCurrentFeature();
	}

	public EmfPoint getEPoint();
}

