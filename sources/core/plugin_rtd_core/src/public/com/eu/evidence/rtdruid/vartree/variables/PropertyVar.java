package com.eu.evidence.rtdruid.vartree.variables;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.vartree.IVariable;

/** This class implements a "Property" variable
*
*	@see rtdruid.vartree.variables.IVariable
*
*@author Nicola Serreli
*/
public class PropertyVar extends ObjectVar {

	public PropertyVar() {
		super.value = new Properties();
	}
	
	public PropertyVar(String value) {
		super.value = new Properties();
		set(value);
	}
	
	/**	This method is a frontend to default constructor
	*
	*	@return a new instance of this IntegerVar
	*/
	public IVariable instance() {
		return new PropertyVar();
	}

// ----------------------   SET & GET   ----------------------
	
	/**	Sets the value for a specific key
	*
	*	@param  key		the keyword (it can be null)
	*	@param	value	the datum (it can be null)
	*/
	public void set(String key, String value) {
		if (((Properties) super.value) == null) {
			super.value = new Properties();
		}
		Properties p = ((Properties) super.value);
 		if (value == null) {
			p.remove(key);
		} else {
			p.setProperty(key, value);
		}
	}

	/**	Sets the value of this IVariable.
	*	Accepts decimal, hexadecimal, and octal numbers given by the grammar
	*	specified in java.lang.Integer.decode.
	*
	*	@param	value	the datum (it can be null)
	*
	*	@throws NotValidValueException
	*	@throws	NumberFormatException	if the given String isn't a number.
	*/
	public void set(String value) throws NotValidValueException {
		
		if (value == null || value.length()==0) {
			get().clear();
			return;
		}
		
		// tries to convert to a Document
		Properties p = get();
		
		try {
			ByteArrayInputStream input = new ByteArrayInputStream(value.getBytes());
			p.loadFromXML(input);
			
		} catch (IOException e) {
			RtdruidLog.log("Cannot load " + value,e);
		}
		
	}
	
	
	/**	Get the value of a specific key
	*
	*	@param  key		the keyword (it can be null)
	*
	*	@return the value, or null if none
	*/
	public String get(String key) {
		return ((Properties) super.value).getProperty(key);
	}
	
	
	/**
	 * this IVariable returns a Property (is not a copy of internal structure) 
	 */
	@Override
	public Properties get() {
		return (Properties) super.get();
	}
	
	/**
	 * 
	 * @param key
	 * @return true if this property Var contains the specified key
	 */
	public boolean contains(String key) {
		return get().containsKey(key);
	}
	
	// -----------------
	
	/**
	 * @return the XML rapresentation of the Properity object stored inside this IVariable 
	 */
	public String toString() {
		
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			get().storeToXML(os, null);
		} catch (IOException e) {
			RtdruidLog.log(e);
		}
		return os.toString();
	}

}

