/*
 * Created on Aug 25, 2004
 *
 * $Id: OilImplPointer.java,v 1.2 2008/03/26 18:23:51 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.oil.implementation;



import java.util.Properties;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import com.eu.evidence.rtdruid.modules.oil.implementation.IOilImplElementDescr;
import com.eu.evidence.rtdruid.modules.oil.implementation.IOilImplPointer;
import com.eu.evidence.rtdruid.modules.oil.keywords.IOilXMLLabels;



/**
 * A class used to navigate an Oil Implementation Tree. Common movement are
 * goFirstChild, goNextSibling, goParent and go to a specific Child. It's also
 * possible to get a description of current node or of children, using
 * ChildDescr Class.
 * 
 * @author Nicola Serreli
 */
public class OilImplPointer implements IOilImplPointer {

	// ------------------------- CONSTANTS ------------------------

	/**
	 * This little contains all description of a node. Internal fiels are all
	 * public and final.
	 */
	private static class ChildDescr implements IOilImplElementDescr {
		/** Contains the name of current node */
		final String name;

		/** Contains the type of current node (constants above) */
		final int type;

		/** Contains all others attributes */
		final Properties attributes;

		/**
		 * Create a a new Child Descr with all data. If Attributes filed is
		 * null, a new Properties is created, otherwise it's cloned. Name could
		 * be null.
		 * 
		 * @param name
		 *            contains the name of current node (or null if not
		 *            available)
		 * @param type
		 *            is the type of current node
		 * @param attributes
		 *            contains all others attributes of this node (or null if
		 *            none is set).
		 */
		ChildDescr(String name, int type, Properties attributes) {
			this.name = name;
			this.type = type;
			this.attributes = attributes == null ? new Properties()
					: (Properties) attributes.clone();
		}
		
		public String getName() {
			return name;
		}
		public int getType() {
			return type;
		}
		public Properties getAttributes() {
			return attributes;
		}
		
		@Override
		public String toString() {
			return "{name = " + name + ", type "+type + ", Prop = " + attributes + "}";
		}
	}

	// ------------------------- INTERNAL VARIABLES ------------------------

	/**
	 * Contains simplest children of a Boolean: a TRUE Enumerator and a FALSE
	 * Enumerator
	 */
	protected static ChildDescr[] DEFAULT_BOOLEAN_CHILDREN = new ChildDescr[] {
		new ChildDescr("TRUE",  ENUMERATOR, null),
		new ChildDescr("FALSE", ENUMERATOR, null) };

	/** A reference to Oil Implementation Tree (XML Document) */
	protected Document doc;

	/** The current node */
	protected Node point;

	// ------------------------- CONSTRUCTORS ------------------------

	/**
	 * Create a new Oil Implementation Pointer over specifed data
	 * 
	 * @param data
	 *            contains the Oil Implementation Tree
	 */
	public OilImplPointer(Document data) {
		if (data == null) {
			throw new NullPointerException("Required a not null document");
		}
		doc = data;
		point = doc.getDocumentElement();
	}

	/**
	 * Creates a new distinct Pointer with the same current node
	 * 
	 * @return a distinct OilImplPointer (that point to the same node)
	 */
	public IOilImplPointer clone() {
		OilImplPointer answer = new OilImplPointer(doc);
		answer.point = point;

		return answer;
	}

	// ------------------------- MOVEMENT ------------------------

	/**
	 * Tries to move pointer to node that is the parent of current node.
	 * 
	 * @return false only if current node is already the root node or if there
	 *         isn't any node.
	 * 
	 * @throws NullPointerException
	 *             if there is a problem with null nodes
	 */
	public boolean goParent() {
		if (point == null || point == doc.getDocumentElement()) {
			return false;
		}

		Node parent = point.getParentNode();
		if (parent == null) {
			throw new NullPointerException("Unexpected null parent node");
		}
		point = parent;
		return true;
	}

	/**
	 * Tries to move pointer to node that is the first child of current node.
	 * 
	 * @return false only if current node hasn't children or if there isn't any
	 *         node.
	 */
	public boolean goFirstChild() {
		if (point == null) {
			return false;
		}
		Node child = point.getFirstChild();
		if (child == null) {
			return false;
		}
		point = child;
		return true;
	}

	/**
	 * Tries to move pointer to node that is the next sibling of current node.
	 * 
	 * @return false only if current node hasn't any "next" sibling or if there
	 *         isn't any node.
	 */
	public boolean goNextSibling() {
		if (point == null) {
			return false;
		}
		Node Sibling = point.getNextSibling();
		if (Sibling == null) {
			return false;
		}
		point = Sibling;
		return true;
	}

	/**
	 * Tries to move pointer to a specified child of current node.
	 * 
	 * @param childName
	 *            identifies the name of a child.
	 * 
	 * @return false only if current node hasn't any child with specified name
	 *         or if there isn't any node.
	 */
	public boolean goChild(String childName) {
		if (point == null) {
			return false;
		}

		NodeList tmp = point.getChildNodes();

		// check all children
		for (int i = 0; i < tmp.getLength(); i++) {
			ChildDescr cd = getDescr(tmp.item(i));
			boolean eq = childName == null ? cd.name == null : childName
					.equals(cd.name);

			if (eq) {
				point = tmp.item(i);

				return true;
			}
		}
		return false;
	}

	// ------------------------- GET DESCRIPTIONS ------------------------

	/** Returns the description of current node
	 * 
	 * @return the description of current node
	 */
	public IOilImplElementDescr getCurrentDescr() {
		return getDescr(point);
	}

	/** Returns the description of all children of current node
	 * 
	 * @return the description of all children of current node
	 */
	public IOilImplElementDescr[] getChildrenDescr() {
		NodeList children = point.getChildNodes();

		// looks all children
		ChildDescr[] answer = new ChildDescr[children.getLength()];
		for (int i = 0; i < children.getLength(); i++) {
			answer[i] = getDescr(children.item(i));
		}
		
		// current node is a BOOLEAN without children
		if (answer.length == 0
				&& point instanceof Element
				&& IOilXMLLabels.ELEM_VARIANT.equalsIgnoreCase(point
						.getNodeName())
				&& "BOOLEAN".equalsIgnoreCase(((Element) point)
						.getAttribute(IOilXMLLabels.ATTR_TYPE))) {

			answer = DEFAULT_BOOLEAN_CHILDREN;

		}
		return answer;
	}

	/**
	 * Prepare the description of a specific node
	 * 
	 * @param cur a node
	 * 
	 * @return the description of specified node, or null if cur is null.
	 */
	protected ChildDescr getDescr(Node cur) {
		if (cur == null) {
			return null;
		}

		// Values
		String name = null;
		int type = UNKNOW;
		Properties attributes = new Properties();

		{
			NamedNodeMap nodeAttributes = cur.getAttributes();
			if (attributes != null && nodeAttributes != null) {
				for (int i = 0; i < nodeAttributes.getLength(); i++) {
					Node tmp = nodeAttributes.item(i);
					String n = tmp.getNodeName();
					String v = tmp.getNodeValue();
					if (n == null || v == null) {
						// Error ?
						continue;
					}

					attributes.setProperty(n, v);
				}
			}
		}

		// node's depended
		if (cur instanceof Element) {
			String nName = cur.getNodeName();
			if (IOilXMLLabels.ELEM_FIRST_LEVEL_OBJ.equalsIgnoreCase(nName)) {
				type = FIRST_LEVEL;
				name = attributes.getProperty(IOilXMLLabels.ATTR_OBJ_TYPE);

			} else if (IOilXMLLabels.ELEM_DESCRIPTION.equalsIgnoreCase(nName)) {
				type = DESCRIPTION;

			} else if (IOilXMLLabels.ELEM_ATTRIBUTE.equalsIgnoreCase(nName)) {
				type = ATTRIBUTE;
				name = attributes.getProperty(IOilXMLLabels.ATTR_NAME);

			} else if (IOilXMLLabels.ELEM_REFERENCE.equalsIgnoreCase(nName)) {
				type = REFERENCE;
				name = attributes.getProperty(IOilXMLLabels.ATTR_NAME);

			} else if (IOilXMLLabels.ELEM_VARIANT.equalsIgnoreCase(nName)) {
				type = VARIANT;
				name = attributes.getProperty(IOilXMLLabels.ATTR_NAME);

			} else if (IOilXMLLabels.ELEM_ENUMERATOR.equalsIgnoreCase(nName)) {
				type = ENUMERATOR;
				name = attributes.getProperty(IOilXMLLabels.ATTR_NAME);

			} else if (IOilXMLLabels.ELEM_VALUE.equalsIgnoreCase(nName)) {
				type = VALUE;

			} else if (IOilXMLLabels.ELEM_RANGE.equalsIgnoreCase(nName)) {
				type = RANGE;
			}
		} else if (cur instanceof Text) {
			type = CDATA;
			String v = cur.getNodeValue();
			if (v != null) {
				attributes.setProperty(IOilXMLLabels.ATTR_VALUE, v);
			}
		}

		return new ChildDescr(name, type, attributes);
	}

	/**
	 * @deprecated
	 */
	public void setName(String newChildName) {
		NamedNodeMap nnm = point.getAttributes();
		Node node;
		if ((node = nnm.getNamedItem(IOilXMLLabels.ATTR_OBJ_TYPE)) != null)
			node.setNodeValue(newChildName);
		if ((node = nnm.getNamedItem(IOilXMLLabels.ATTR_NAME)) != null)
			node.setNodeValue(newChildName);
		
	}


}
