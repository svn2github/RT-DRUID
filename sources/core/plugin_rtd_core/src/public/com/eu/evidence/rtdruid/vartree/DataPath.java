/*
 * Created on May 7, 2004
 *
 *	$Id: DataPath.java,v 1.4 2007/03/09 09:12:41 durin Exp $
 */
package com.eu.evidence.rtdruid.vartree;

import java.util.Collection;
import java.util.LinkedList;

/**
 * @author Nicola Serreli
 */
public final class DataPath {


	/** Abbreviation for VarTree.SEPARATOR */
	public final static char SEPARATOR = '/';
	
	public final static char PROTECTOR = '\\'; // NB!!! = \
	
	public final static char ALL = '*';
	public final static String GO_PARENT = "..";
	public final static String CURRENT   = ".";
	public final static String NULL_ID   = "\\0"; // NB!!! = \0
	public final static String VOID_ID   = "\\_"; // NB!!! = \_
	public final static String FIRST_CHILD_ID   = "0"; // NB!!! = \_
	
	public final static String BOOLEAN_TYPE = "BooleanVar";
	public final static String DOUBLE_TYPE  = "DoubleVar";
	public final static String FLOAT_TYPE   = "FloatVar";
	public final static String INTEGER_TYPE = "IntegerVar";
	public final static String LONG_TYPE    = "LongVar";
	public final static String OIL_TYPE     = "OilVar";
	public final static String STRING_TYPE  = "StringVar";
	public final static String TIME_TYPE    = "TimeVar";

	public final static String BOOLEAN_M_TYPE = "BooleanVar[]";
	public final static String DOUBLE_M_TYPE  = "DoubleVar[]";
	public final static String FLOAT_M_TYPE   = "FloatVar[]";
	public final static String INTEGER_M_TYPE = "IntegerVar[]";
	public final static String LONG_M_TYPE    = "LongVar[]";
	public final static String OIL_M_TYPE     = "OilVar[]";
	public final static String STRING_M_TYPE  = "StringVar[]";
	public final static String TIME_M_TYPE    = "TimeVar[]";

	
	// ----------------------------------
	
	/** Makes an "ID" from a value.
	 * */
	public static String makeId(String value) {
		return makeId( new String[] { value } );
	}

	/** Makes an "ID" from a list of values and protects it with "Slash" (see {@link rtdruid.vartree.IVarTree#addSlash rtdruid.vartree.VarTree.addSlash}).
	 * */
	public static String makeSlashedId(String[] values) {
		return addSlash(makeId(values));
/*		StringBuffer risp = new StringBuffer();
		if (values == null) {
			throw new NullPointerException("Try to make an ID without values");
		}
		if (values.length == 0) {
			throw new IllegalArgumentException("Try to make an ID without values");
		}
		
/*		if (values.length == 1) {
			return values[0]; // could return null
		}
* /
		String pre = "";
		String slashedPre = addSlash(" " + SEPARATOR + " ");
		for (int i =0; i< values.length; i++) {
			risp.append( pre +( values[i] != null ? addSlash(addSlash(values[i])) : NULL_ID ) );
			pre = slashedPre;
		}
		
		return risp.toString();
*/	}

	/** Makes an "ID" from a value and protects it with "Slash" (see {@link rtdruid.vartree.IVarTree#addSlash rtdruid.vartree.VarTree.addSlash}).
	 * */
	public static String makeSlashedId(String value) {
		return addSlash(makeId( new String[] { value } ));
	}

	/** Makes an "ID" from a list of values.
	 * */
	public static String makeId(String[] values) {
		StringBuffer risp = new StringBuffer();
		if (values == null) {
			throw new NullPointerException("Try to make an ID without values");
		}
		if (values.length == 0) {
			throw new IllegalArgumentException("Try to make an ID without values");
		}
	/*	Cannot return null String that could make some problems with path 
	 *  and cannot return "not slashed id" because NULL_ID must be different from an ID with value NULL_ID  
	    if (values.length == 1) {
			return values[0]; // could return null
		}
	*/	
		String pre = "";
		for (int i =0; i< values.length; i++) {
			risp.append( pre +( values[i] != null ? addSlash(values[i]) : NULL_ID ) );
			pre = " " + SEPARATOR + " ";
		}
		
		return risp.toString();
	}
	

	/** Returns the list of values used to make given 'ID'.
	 * 
	 * @param values the id (without protection, see {@link rtdruid.vartree.IVarTree#addSlash rtdruid.vartree.VarTree.addSlash()})
	 * */
	public static String[] resolveId(String values) {
		String[] risp;
		if (values == null) {
//			RtdruidLog.showDebug("Try to resolve a null ID");

			return new String[] { null };
		}
		
		risp = values.split(" " + SEPARATOR + " ");//splitPath(values);
		
		// remove white spaces
//		if (risp.length >1) {
			for (int i=0; i< risp.length; i++) {
///*				if ((risp[i].trim()).equals(NULL_ID)) {
//					risp[i] = null;
//				} else {
//*/					int start = (i ==0 ? 0 : 1);
//					int end = risp[i].length() - (i == (risp.length -1) ? 0 : 1);
//					risp[i] = removeSlash(risp[i].substring(start, end)); // NB: removeSlash(NULL_ID) = null
				risp[i] = removeSlash(risp[i]); // NB: removeSlash(NULL_ID) = null
////				}
			}  
/*		} else {
			 if ((risp[0].trim()).equals(NULL_ID)) {
				risp[0] = null;
			 } else {
				risp[0] = removeSlash(risp[0]);
			 }
		} 
*/		
		return risp;
	}
	
	//--------------------------------------------
	
	/** Splits path in a list of names.
	*
	*	See above for the complete definition of "path".
	*	Drops all separator character in the end of the given path.  
	*
	*	@param	path	it identifies an Element in the tree.
	* 
	*	@return A list of Element's names (not null)
	*/
	public static String[] splitPath(String path) {

		if (path == null) { // Nothing to do
			return new String[0];			
		}
		
		if (path.length() == 0) { // Nothing to do
			String[] risp = { "" };
			return risp;
		}
	
		// search char after char
		char[] tmpString = path.toCharArray();
		LinkedList<String> risp = new LinkedList<String>();
		int lastPos=0; int curr=0;
		boolean protect= false;
		for (curr=0; curr<tmpString.length; curr++) {
			switch (tmpString[curr]) {
				case PROTECTOR : protect = !protect; break;
				case SEPARATOR  : if (!protect) {	// split
								// ignoring two adjacent separator character
								if (lastPos == curr) {
									lastPos++;
									break;
								}
					
								risp.add(path.substring(lastPos,curr));
								lastPos=curr+1;
							}
							protect = false;
							break;
				default   : protect = false;
			}
		}
		
		if (lastPos < curr) {	// add last string
			risp.add(path.substring(lastPos));
		}
				
		if (risp.size() == 0 && path.length() != 0) {
			risp.add("");
		}
		return (String[]) risp.toArray(new String[0]);
	}


	/** Makes a path from some elements.
	*
	*	See above for the complete definition of "path".
	*	Drops all separator character in the end of the given path.  
	*
	*	@param	elements	each string identifies an Element in the tree.
	* 
	*	@return the corresponding path
	*/
	public static String makePath(Collection<String> elements) {
		return makePath(
				elements == null ?
						(String[]) null :
						(String[])elements.toArray(new String[elements.size()])); 
	}

	/** Makes a path from some elements.
	*
	*	See above for the complete definition of "path".
	*	Drops all separator character in the end of the given path.  
	*
	*	@param	elements	each string identifies an Element in the tree.
	* 
	*	@return the corresponding path
	*/
	public static String makePath(String[] elements) {

		if (elements == null) { // Nothing to do
			return addSlash(null);			
		}
		
		StringBuffer answer = new StringBuffer();
		String tmp = "" +SEPARATOR;
		for (int i=0; i<elements.length; i++) {
			answer.append(
					(i==0 ? "" : tmp) +
					addSlash(elements[i])
			);
		}
		
		return answer.toString();		
	}

	/**	Test if a name is valid
	 * @deprecated
	*/ 
	public static boolean isValid(String name) {
		if (name == null || name.length() == 0) 
			return true;
		
		// search char after char
		char[] tmpString = name.toCharArray();
		boolean protect= false;
		for (int curr=0; curr<tmpString.length; curr++) {
			switch (tmpString[curr]) {
				case PROTECTOR  : protect = !protect; break;
				case SEPARATOR  :
				case ALL  :
							if (!protect) {	// error
								return false;
							}
							protect = false;
							break;
				default   : protect = false;
			}
		}
		
		return true;
	}

	/**	Searches for all special characters and protects them
	*/ 
	public static String addSlash(String name) {
		if (name == null) 
			return NULL_ID;
		
		StringBuffer tmp = new StringBuffer(name.length()*2);

		// check char after char
		char[] tmpString = name.toCharArray();
		boolean protect= false;
		for (int curr=0; curr<tmpString.length; curr++) {
			protect= false;
			switch (tmpString[curr]) {
				case PROTECTOR : 
				case SEPARATOR  :
				case ALL  :
							protect = true;
							break;
				default   : protect = false;
			}
			tmp.append("" + (protect ? "" + PROTECTOR : "") + tmpString[curr]);
		}
		return tmp.toString();
	}
	
	/**	Searches for all protected special characters and remove the "protection"
	*/ 
	public static String removeSlash(String name) {
		if (name == null || NULL_ID.equals(name))
			return null;
		
		StringBuffer tmp = new StringBuffer(name.length());

		// check char after char
		char[] tmpString = name.toCharArray();
		//boolean protect= false;
		for (int curr=0; curr<tmpString.length; curr++) {
			switch (tmpString[curr]) {
				case PROTECTOR : if (curr + 1<tmpString.length) {
								switch (tmpString[curr+1]) {
									case PROTECTOR : 
									case SEPARATOR :
									case ALL  :
												curr++;
												break;
									default   : break;
								}
							}
				default   : break;
			}
			tmp.append(tmpString[curr]);
		}
		return tmp.toString();
	}

	
	/**	Return the path without the last element
	*/ 
	public static String removeLastElement(String path) {
		if (path == null || NULL_ID.equals(path))
			return null;
		
		String[] elements = splitPath(path);
		if (elements.length == 0) {
			return null; // should never happen
		}
		
		String[] newElements = new String[elements.length-1]; 

		System.arraycopy(elements, 0, newElements, 0, newElements.length);
		return makePath(newElements);
	}

}
