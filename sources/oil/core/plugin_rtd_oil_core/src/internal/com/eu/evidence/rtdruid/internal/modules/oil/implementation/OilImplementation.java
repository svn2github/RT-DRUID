/*
 * Created on Aug 25, 2004
 *
 * $Id: OilImplementation.java,v 1.2 2008/03/26 18:23:51 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.oil.implementation;



import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.BitSet;

import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.internal.modules.oil.implementation.OilImplPointer;
import com.eu.evidence.rtdruid.internal.modules.oil.reader.MergeHelper;
import com.eu.evidence.rtdruid.internal.modules.oil.reader.OilInfo;
import com.eu.evidence.rtdruid.internal.modules.oil.reader.OilParser;
import com.eu.evidence.rtdruid.modules.oil.implementation.IOilImplElementDescr;
import com.eu.evidence.rtdruid.modules.oil.implementation.IOilImplID;
import com.eu.evidence.rtdruid.modules.oil.implementation.IOilImplPointer;
import com.eu.evidence.rtdruid.modules.oil.implementation.IOilImplementation;
import com.eu.evidence.rtdruid.modules.oil.keywords.IOilXMLLabels;



/**
 * This class contains an Implementation part of an Oil File.
 * 
 * @author Nicola Serreli
 */
public class OilImplementation implements IOilImplementation {

	/** Indentation used to format Oil output */
    protected final static String INDENT = "    ";

    // ---------------------------------------------

	/** The identifier of this Implementation */
	final protected IOilImplID name;

	/** All data */
	final protected Document doc;
	
	/** A string that rapresent this object with Oil Syntax */
	protected String oilRapresentation;

	/** A counter for multiple definition of the same Implementation */
	protected int counter;


	/**
	 * Clone this object
	 */
	public IOilImplementation clone() {
		OilImplementation answer = new OilImplementation(name.clone(), (Document) doc.cloneNode(true));
		answer.counter = this.counter;
		answer.oilRapresentation = this.oilRapresentation;
		return answer;
	}

	/**
	 * Create a new Implementation with specified ID and data.
	 * 
	 * @param id
	 *            identifies this Implementation
	 * @param data
	 *            contains the xml rapresentation of Oil Implementation part
	 */
	public OilImplementation(IOilImplID id, Document data) {
		if (id == null) {
			throw new NullPointerException("Required a not null ID");
		}
		if (data == null) {
			throw new NullPointerException("Required a not null document");
		}

		// TODO: check if data is a well formed XML Document with valid Oil Data (?)  

		oilRapresentation = null;
		name = id;
		doc = data;
		counter = 1;
	}

	/**
	 * Return the id.
	 * 
	 * @return the identifier.
	 */
	public IOilImplID getId() {
		return name;
	}

	/**
	 * Return the number of definition of current Implementation.
	 * 
	 * @return number of current definition.
	 */
	public int getCounter() {
		return counter;
	}

	/**
	 * Increment the number of definition of current Implementation.
	 */
	public void incrCounter() {
		counter++;
	}

	/**
	 * Decrement the number of definition of current Implementation.
	 * 
	 * @return the new number of current definition.
	 */
	public int decrCounter() {
		counter--;
		return counter;
	}

	/**
	 * Returns current implementation with Oil Syntax
	 * 
	 * @return a string that contains this Oil Implementation part writed with
	 *         Oil Syntax
	 */
	public String toOil() {
		
		// check cache before compute
		if (oilRapresentation == null) {
			
			StringBuffer buffer = new StringBuffer();
			
			IOilImplPointer oip = getPointer();
			
			//header
			buffer.append("IMPLEMENTATION " + name.getImplementationName() +" {\n");
			
			// write all elements
			for (boolean go = oip.goFirstChild(); go; go=oip.goNextSibling()) {
				writeImplementation(buffer, INDENT, (IOilImplPointer) oip.clone());
			}
			
			//end
			buffer.append("};\n\n");
			
			// cache data
			oilRapresentation = buffer.toString();
		}
			
		return oilRapresentation;
	}
	
	
	/**
	 * Write a piece of the implementation section
	 * 
	 * @param buffer the output (Oil)
	 * @param indent contains some white spaces to indent the output
	 * 
	 * @param id identifies the Implementation
	 * */
	protected void writeImplementation(StringBuffer buffer, String indent, IOilImplPointer oip) {
		
		IOilImplElementDescr cd = oip.getCurrentDescr();
		String header="";
		String[] end= { "", ""}; // before and after a description
		String newIndent = indent;
		boolean checkChildren = false;
		boolean removeComma = false;
			
		
		switch (cd.getType()) {
			case IOilImplPointer.FIRST_LEVEL : {
				String type = cd.getAttributes().getProperty(IOilXMLLabels.ATTR_OBJ_TYPE);
				header=indent + type +" {\n";
				end= new String[] {indent+"}", ";\n"};
				checkChildren = true;
				newIndent = indent+INDENT;
			}
				break;
			case IOilImplPointer.ATTRIBUTE : {
				checkChildren = false;
				
				// from attributes
				String type = cd.getAttributes().getProperty(IOilXMLLabels.ATTR_TYPE);
				String name = cd.getAttributes().getProperty(IOilXMLLabels.ATTR_NAME);
				String auto = (cd.getAttributes().containsKey(IOilXMLLabels.ATTR_WITH_AUTO)
						&& "true".equalsIgnoreCase(cd.getAttributes().getProperty(IOilXMLLabels.ATTR_WITH_AUTO))) 
						? "WITH_AUTO " : "";
				String multiple = (cd.getAttributes().containsKey(IOilXMLLabels.ATTR_MULTIPLE_VALUES)
						&& "true".equalsIgnoreCase(cd.getAttributes().getProperty(IOilXMLLabels.ATTR_MULTIPLE_VALUES))) 
						? "[]" : "";

				String quotes = ("STRING".equalsIgnoreCase(type)) ? "\"" : "";

				String default_value = (cd.getAttributes().containsKey(IOilXMLLabels.ATTR_AUTO)
						&& "true".equalsIgnoreCase(cd.getAttributes().getProperty(IOilXMLLabels.ATTR_AUTO))) 
						? " = AUTO" : "";
				 default_value = (cd.getAttributes().containsKey(IOilXMLLabels.ATTR_DEFAULT_VALUE)) 
						? " = " +quotes+cd.getAttributes().getProperty(IOilXMLLabels.ATTR_DEFAULT_VALUE)+quotes : default_value;
						
			
				// search range / value inside the children
				String range[] = null;
				ArrayList<String> value = new ArrayList<String>();
				IOilImplElementDescr cds[] = oip.getChildrenDescr();
				
				for (int i=0; i<cds.length; i++) {
					
					if (cds[i].getType() == IOilImplPointer.VALUE && cds[i].getAttributes().containsKey(IOilXMLLabels.ATTR_VALUE)) {
						value.add(quotes+cds[i].getAttributes().getProperty(IOilXMLLabels.ATTR_VALUE)+quotes);

					} else if (cds[i].getType() == IOilImplPointer.RANGE) {
						range = new String[2];
						range[0] = cds[i].getAttributes().getProperty(IOilXMLLabels.ATTR_MIN);
						range[1] = cds[i].getAttributes().getProperty(IOilXMLLabels.ATTR_MAX);
					}
				}

				// prepare Header
				String range_value = "";
				if (range != null) {
					range_value += " [" +range[0] + ".." + range[1]+"] ";
				} else if (value.size() != 0) {
					range_value += " [";
					for (int i=0; i<value.size(); i++) {
						range_value += (i!=0?", ":"") + ((String) value.get(i));
					}
					range_value += "] ";
				} // else {//nothing}

				header=indent + type + " " +auto+range_value+ name+multiple+default_value;
			
				// prepare the end
				end= new String[] {"", ";\n"};
				
			}
				break;
			case IOilImplPointer.REFERENCE : {
				checkChildren = false;
				
				// from attributes
				String type = cd.getAttributes().getProperty(IOilXMLLabels.ATTR_OBJ_REF_TYPE);
				String name = cd.getAttributes().getProperty(IOilXMLLabels.ATTR_NAME);
				String multiple = (cd.getAttributes().containsKey(IOilXMLLabels.ATTR_MULTIPLE_VALUES)
						&& "true".equalsIgnoreCase(cd.getAttributes().getProperty(IOilXMLLabels.ATTR_MULTIPLE_VALUES))) 
						? "[]" : "";
			
				// prepare Header
				header=indent + type + " " + name+multiple;
			
				// prepare the end
				end= new String[] {"", ";\n"};
				
			}

				break;
			case IOilImplPointer.VARIANT : {
				checkChildren = true;
				removeComma = true;
				newIndent = indent+INDENT;
				
				// from attributes
				String type = cd.getAttributes().getProperty(IOilXMLLabels.ATTR_TYPE);
				String name = cd.getAttributes().getProperty(IOilXMLLabels.ATTR_NAME);
				String with_auto = (cd.getAttributes().containsKey(IOilXMLLabels.ATTR_WITH_AUTO)
						&& "true".equalsIgnoreCase(cd.getAttributes().getProperty(IOilXMLLabels.ATTR_WITH_AUTO))) 
						? " WITH_AUTO " : "";
				boolean auto = (cd.getAttributes().containsKey(IOilXMLLabels.ATTR_AUTO)
						&& "true".equalsIgnoreCase(cd.getAttributes().getProperty(IOilXMLLabels.ATTR_AUTO))); 
//						? " AUTO " : "";
				String multiple = (cd.getAttributes().containsKey(IOilXMLLabels.ATTR_MULTIPLE_VALUES)
						&& "true".equalsIgnoreCase(cd.getAttributes().getProperty(IOilXMLLabels.ATTR_MULTIPLE_VALUES))) 
						? "[]" : "";
				String default_value = auto ? 
						"AUTO" : (
							(cd.getAttributes().containsKey(IOilXMLLabels.ATTR_DEFAULT_VALUE)) 
							? " = " +cd.getAttributes().getProperty(IOilXMLLabels.ATTR_DEFAULT_VALUE) : ""
						);
			
				// prepare Header
				header=indent + type+with_auto + " [\n" ;
			
				// prepare the end
				end= new String[] {indent+"] "+name+multiple+default_value, ";\n"};
				
			}
				break;
			case IOilImplPointer.ENUMERATOR : {
				newIndent = indent+INDENT;
				
				// from attributes
				String name = cd.getAttributes().getProperty(IOilXMLLabels.ATTR_NAME);
			
				// search an attribute/reference/variant
				boolean ok = false;
				IOilImplElementDescr cds[] = oip.getChildrenDescr();
				
				for (int i=0; !ok && i<cds.length; i++) {
					
					ok = cds[i].getType() == IOilImplPointer.ATTRIBUTE 
							 || cds[i].getType() == IOilImplPointer.REFERENCE
							 || cds[i].getType() == IOilImplPointer.VARIANT;
				}

				
				// prepare Header
				header=indent + name;
				if (ok) {
					checkChildren = true;
					header += " {\n" ;
					newIndent=indent+INDENT;
				}
			
				// prepare the end
				end= new String[] {(ok ? indent+"}":""), ",\n"};
			}
				break;
			// ------------ UNUSED ------------------
			case IOilImplPointer.DESCRIPTION :
			case IOilImplPointer.VALUE :
			case IOilImplPointer.RANGE :
			case IOilImplPointer.CDATA :
			case IOilImplPointer.UNKNOW :
			default:
				// cannot run this row
				throw new RuntimeException("?????ID=wueh8931074-128947?????");
				//break;
				
		}
		
		// ------------- header -------------
		buffer.append(header);
		
		String description = "";
		// ------------- children -------------
		for (boolean go = oip.goFirstChild(); go; go=oip.goNextSibling()) {
			if (oip.getCurrentDescr().getType() == IOilImplPointer.DESCRIPTION) {
				IOilImplPointer tmpoip = (IOilImplPointer) oip.clone();
				boolean ok = tmpoip.goFirstChild();
				IOilImplElementDescr tcd = tmpoip.getCurrentDescr();
				ok &= tcd.getType() == IOilImplPointer.CDATA;
				ok &= tcd.getAttributes().containsKey(IOilXMLLabels.ATTR_VALUE);
				if (ok) {
					String ndescr = tcd.getAttributes().getProperty(IOilXMLLabels.ATTR_VALUE);
							
					if (!(description.contains(ndescr))) {
						description = (description.length() == 0 ? " : \"" : description+ ". " )
								+ ndescr;
					}
				}
				
			} else if (checkChildren) {
				writeImplementation(buffer, newIndent, (IOilImplPointer) oip.clone());
			}
		}
		
		// if the children are enumerator, check if is required to remove the last comma
		if (removeComma) {
			String txt = ",\n";
			char txtc[] = new char[txt.length()];
			txt.getChars(0,txt.length(), txtc, 0);
			int oldlength = buffer.length();
			boolean remove = buffer.length()>txt.length();
			for (int i=1; i<=txt.length() && remove; i++) {
				remove = buffer.charAt(oldlength-i) == txtc[txt.length()-i]; 
			}
			if (remove) {
				buffer.setLength(oldlength - txt.length());
				buffer.append("\n");
			}
		}
		// ------------- end -------------
		if (description.length() > 0) {
			description +="\""; 
		}
		buffer.append(end[0]+description+end[1]);
	}


	/**
	 * Returns an OilImplPointer to navigate this implementation.
	 * 
	 * @return an OilImplPointer to navigate this implementation.
	 */
	public IOilImplPointer getPointer() {
		return new OilImplPointer(doc);
	}

	/**
	 * Compare this Object to another. If objects are both OilImplementation,
	 * compare theirs Identifiers. <br>
	 * 
	 * @see java.lang.Comparable
	 * 
	 * @param o
	 *            the Object to be compared.
	 * 
	 * @return a negative integer, zero, or a positive integer as this object is
	 *         less than, equal to, or greater than the specified object.
	 * 
	 * @throws NullPointerException
	 *             if specified object is Null
	 */
	public int compareTo(Object o) {
		if (o == null) {
			throw new NullPointerException("Required a not null object");
		}
		if (o instanceof IOilImplementation) {
			return name.compareTo(((IOilImplementation) o).getId());
		}
		if (o instanceof IOilImplID) {
			return name.compareTo((IOilImplID) o);
		}

		throw new IllegalArgumentException("Not a valid type " + o);
	}

	/**
	 * Checks if this OilImplementation contains the same data on another.
	 * 
	 * @param o
	 *            the Object to be compared.
	 * 
	 * @return true if the specified object contains the same data of this one.
	 */
	public boolean equalsImpl(IOilImplementation o) {
		// if they are the same thing, return immediately
		if (this == o) {
			return true;
		}
		
		if (o instanceof OilImplementation)
			// if not null, check data
			return o != null && equalsImpl(((OilImplementation) o).doc);
		else {
			// convert the given implementation
			try {
				OilInfo info = new OilParser(new ByteArrayInputStream(o.toOil().getBytes())).start();
				return equalsImpl(info.getImpl());
			} catch (Exception e) {
				RtdruidLog.log(e);
			}
		}
		return false;
	}

	/**
	 * Checks if this OilImplementation contains the same data on a specified
	 * XML Document.
	 * 
	 * @param o
	 *            the Object to be compared.
	 * 
	 * @return true if the specified object contains the same data of this one.
	 */
	public boolean equalsImpl(Document o) {

		// if they are the same thing, return immediately
		if (this.doc == o) {
			return true;
		}

		// check for null values
		if (this.doc == null || o == null) {
			return this.doc == o;
		}

		// compare all nodes
		return equalsImpl(doc.getDocumentElement(), o.getDocumentElement());
	}

	/**
	 * Recursively checks all node and theirs attributes.
	 * 
	 * @param current
	 *            contains a node of this OilImplementation
	 * @param other
	 *            contains a node of another Document
	 */
	protected boolean equalsImpl(Node current, Node other) {
		// check for null nodes
		if (current == null || other == null) {
			return current == other;
		}

		// same name and same class
		if (!checkString(current.getNodeName(), other.getNodeName())
				|| current.getClass() != other.getClass()) {
			return false;
		}

		/***********************************************************************
		 * Attributes
		 **********************************************************************/

		// check attributes
		if (current instanceof Element) {
			// also other is an Element

			NamedNodeMap attr_curr = current.getAttributes();
			NamedNodeMap attr_oth = other.getAttributes();

			if (attr_curr.getLength() != attr_oth.getLength()) {
				return false;
			}

			for (int i = 0; i < attr_curr.getLength(); i++) {
				Node att = attr_curr.item(i);
				Node att_2 = attr_oth.getNamedItem(att.getNodeName());

				if (att_2 == null
						|| !checkString(att.getNodeValue(), att_2
								.getNodeValue())) {
					return false;
				}
			}
		}

		/***********************************************************************
		 * Children (empty list)
		 **********************************************************************/

		// check children
		NodeList ch_curr = current.getChildNodes();
		NodeList ch_oth = other.getChildNodes();

		// ignore comments and texts like white spaces (only descriptions are
		// text nodes and we can ignore it)
		if (ch_curr == null) {
			if (ch_oth != null) {
				for (int i = 0; i < ch_oth.getLength(); i++) {
					if (!(ch_oth.item(i) instanceof Comment)
							&& !(ch_oth.item(i) instanceof Text)) {
						return false;
					}
				}
			}
			return true;
		} else if (ch_oth == null) {
//			if (ch_oth != null) {
//				for (int i = 0; i < ch_oth.getLength(); i++) {
//
//					//if (!(ch_oth.item(i) instanceof Comment)
//					//        && !(ch_oth.item(i) instanceof Text)) {
//					if (ch_oth.item(i) instanceof Element) {
//						return false;
//					}
//				}
//			}
			return true;
		}

		/***********************************************************************
		 * Check all Children
		 **********************************************************************/
		
		// set to true all bits corrisponding to already checked nodes
		BitSet checked = new BitSet(ch_oth.getLength());

		for (int i = 0; i < ch_curr.getLength(); i++) {

			Node att = ch_curr.item(i);
			// check only elements (discard Comments, Descriptions and White
			// Spaces)
			if (att instanceof Element) {
				int pos = searchElement(checked, ch_oth, (Element) att);
				if (pos == -1) {
					return false;
				}
				Node att_2 = ch_oth.item(pos);

				if (!equalsImpl(att, att_2)) {
					return false;
				}
			}
		}

		// check if all children are checked
		for (int i = 0; i < ch_oth.getLength(); i++) {
			// already checked
			if (checked.get(i)) {
				continue;
			}

			if (ch_oth.item(i) instanceof Element) {
				return false;
			}
		}

		// all ok !!
		return true;
	}

	/**
	 * Compares two string.
	 * 
	 * @param a
	 *            first string
	 * @param b
	 *            second string
	 * 
	 * @return true if specified strings are equals or both null.
	 */
	protected boolean checkString(String a, String b) {
		return a == null ? b == null : a.equals(b);
	}

	/**
	 * Searchs an Element, with a specified parameter, in a node list, excluding
	 * already checked nodes.
	 * 
	 * @param checked
	 *            contains a bit set to true for each node that is already
	 *            checked
	 * @param list
	 *            contains all nodes
	 * @param name
	 *            the node name : Node.getNodeName()
	 * 
	 * @return the position of first Element with specified properties, or -1 if
	 *         no one was found
	 */
	protected int searchElement(BitSet checked, NodeList list, Element reference) {
		
		String name = reference.getNodeName();
		
		String attrName = null;
		
		if (IOilXMLLabels.ELEM_ATTRIBUTE.equals(name) ||
				IOilXMLLabels.ELEM_ENUMERATOR.equals(name) ||
				IOilXMLLabels.ELEM_REFERENCE.equals(name) ||
				IOilXMLLabels.ELEM_VARIANT.equals(name)) {
			attrName = IOilXMLLabels.ATTR_NAME;
			
		} else if (IOilXMLLabels.ELEM_FIRST_LEVEL_OBJ.equals(name)) {
			attrName = IOilXMLLabels.ATTR_OBJ_TYPE;
			
		} 
		
		for (int i = 0; i < list.getLength(); i++) {
			// already checked
			if (checked.get(i)) {
				continue;
			}

			Node item = list.item(i);
			if (item instanceof Element
					&& checkString(item.getNodeName(), name)) {
				
				boolean ok = false;
				if (attrName != null) {
					String a1 = reference.hasAttribute(attrName) ? reference.getAttribute(attrName) : null ;
					String a2 = ((Element) item).hasAttribute(attrName) ? ((Element) item).getAttribute(attrName) : null ;
					
					ok = checkString(a1, a2);
				}
				
				if (ok) {
					checked.set(i);
					return i;
				}
			}
		}
		return -1;
	}

	/*
	 *  MERGE 
	 * 
	 */

	/**
	 * Checks if this OilImplementation contains the same data on another.
	 * 
	 * @param o
	 *            the Object to be compared.
	 * 
	 * @return true if the specified object contains the same data of this one.
	 */
	public boolean mergeImpl(IOilImplementation o) {
		// if they are the same thing, return immediately
		if (this == o) {
			return true;
		}
		
		if (o instanceof OilImplementation)
			// if not null, check data
			return o != null && mergeImpl(((OilImplementation) o).doc);
		else {
			// convert the given implementation
			try {
				OilInfo info = new OilParser(new ByteArrayInputStream(o.toOil().getBytes())).start();
				return mergeImpl(info.getImpl());
			} catch (Exception e) {
				RtdruidLog.log(e);
			}
		}
		
		return false;
	}

	/**
	 * Checks if this OilImplementation contains the same data on a specified
	 * XML Document.
	 * 
	 * @param o
	 *            the Object to be compared.
	 * 
	 * @return true if the specified object contains the same data of this one.
	 */
	public boolean mergeImpl(Document o) {

		// if they are the same thing, return immediately
		if (this.doc == o) {
			return true;
		}

		// check for null values
		if (this.doc == null || o == null) {
			return this.doc == o;
		}
		
		// compare all nodes
		try {
            // make a new copy of each document
			Element oldChild = doc.getDocumentElement();
			Element a = (Element) oldChild.getOwnerDocument().importNode(oldChild, true);
			assert(a != oldChild);
			Element b = o.getDocumentElement();
			b = (Element) b.getOwnerDocument().importNode(b, true);
			
			MergeHelper.mergeImplementations(a, b);
			
			// now a contains everything
			
			this.doc.removeChild(oldChild);
			this.doc.appendChild(a);
			this.oilRapresentation = null;

		} catch (Exception e) {
			RtdruidLog.log(e);
			return false;
		}
		return true;
	}

	
}