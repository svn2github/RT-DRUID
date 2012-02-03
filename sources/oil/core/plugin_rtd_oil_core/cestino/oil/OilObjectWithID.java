/**
 * <copyright>
 * </copyright>
 *
 * $Id: OilObjectWithID.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.vartree.data.oil;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.eu.evidence.rtdruid.vartree.data.ObjectWithID;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object With ID</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see com.eu.evidence.rtdruid.vartree.data.oil.OilApplPackage#getOilObjectWithID()
 * @model abstract="true"
 * @generated NOT
 */
public interface OilObjectWithID extends ObjectWithID {

	/** Returns the type of current object, using the oil syntax */
	public abstract String getOilType();
	
	/** Returns the xml rapresentation of current object and its descendants */
	public abstract Element getXmlRapresentation(Document doc);
} // OilObjectWithID
