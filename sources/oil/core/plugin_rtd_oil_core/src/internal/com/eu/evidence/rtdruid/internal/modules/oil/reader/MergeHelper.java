/**
 * Created on 31/ott/2008
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.internal.modules.oil.reader;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.eu.evidence.rtdruid.modules.oil.keywords.IOilXMLLabels;

/**
 * @author Nicola Serreli
 * 
 */
public class MergeHelper implements IParserConstants {
	
	/**
	 * Tries to merge two Implementation Nodes.
	 * 
	 * NOTE both can be modified !!
	 * 
	 */
	public static void mergeImplementations(Element destination, Element additions)
			throws ParseException {
		final String OBJ_TYPE = IOilXMLLabels.ATTR_OBJ_TYPE;
		
		assert(IOilXMLLabels.ELEM_IMPLEMENTATION.equals(destination.getNodeName()));
		assert(IOilXMLLabels.ELEM_IMPLEMENTATION.equals(additions.getNodeName()));
		
		NodeList list = additions.getChildNodes();
//		for (int i= 0 ; i< list.getLength(); i= (child != list.item(i) ? i : i+1)) {
		// 
		for (int i= 0 ; i< list.getLength(); i++) {
			Node child = list.item(i);
			
			Element d_ch = searchElement(destination, IOilXMLLabels.ELEM_FIRST_LEVEL_OBJ, OBJ_TYPE, child.getAttributes().getNamedItem(OBJ_TYPE).getNodeValue());
			if (d_ch != null) {

				// parse every child of a FirtLevel OBJ
				NodeList ch_list = child.getChildNodes();
				for (int j= 0 ; j< ch_list.getLength(); j++) {
					Node cc = ch_list.item(j);
					if (cc instanceof Element) {
						mergeElement(d_ch, (Element) cc);
					}
				}

			} else {
				
				// add a copy of new node
				destination.appendChild(destination.getOwnerDocument().importNode(child, true));
				i--;
			}
			
			
			
			
		}
	}

	/**
	 * Search a child with specified properties.
	 */
	protected static Element searchElement(Node parent, String elemName,
			String attrName, String attrValue) {
		NodeList children = parent.getChildNodes();

		for (int i = 0; i < children.getLength(); i++) {
			Node n = children.item(i);

			if (n instanceof Element) {
				Element child = (Element) n;

				// check properties
				boolean ok = checkStrings(elemName, child.getNodeName());
				if (ok && attrName != null) {
					ok = checkStrings(attrValue, child.getAttribute(attrName));
				}
				if (ok) { // found
					return child;
				}
			}
		}

		return null;
	}

	/**
	 * Add an Element to a "parent" element. If already exist an element with
	 * the same "id" (ATTR_NAME, or something else), try to merge them.
	 */
	protected static void mergeElement(Element parent, Element child)
			throws ParseException {
		String nodeName = child.getNodeName();

		// -----------------------------------------------
		// ATTRIBUTE - REFERENCE - VARIANT
		// -----------------------------------------------
		if (IOilXMLLabels.ELEM_ATTRIBUTE.equals(nodeName)) {
			String attName = child.getAttribute(IOilXMLLabels.ATTR_NAME);

			NodeList children = parent.getChildNodes();

			for (int i = 0; i < children.getLength(); i++) {
				Node n = children.item(i);

				if (n instanceof Element) {
					Element ch = (Element) n;

					// check properties
					boolean ok_1 = checkStrings(IOilXMLLabels.ELEM_ATTRIBUTE,
							ch.getNodeName());
					boolean ok_2 = checkStrings(IOilXMLLabels.ELEM_REFERENCE,
							ch.getNodeName())
							|| checkStrings(IOilXMLLabels.ELEM_VARIANT, ch
									.getNodeName());

					boolean ok = false;
					if (ok_1 || ok_2) {
						ok = checkStrings(attName, ch
								.getAttribute(IOilXMLLabels.ATTR_NAME));
					}
					if (ok) { // found
						if (ok_2) {
							throw new ParseException(
									"Found an element declared more than one time with differents proterties.\n"
											+ attName
											+ " declared as ATTRIBUTE and as "
											+ ch.getNodeName() + "\n"
											+ child.getAttribute(LOCATION));
						}

						// only one
						if ((ch.hasAttribute(IOilXMLLabels.ATTR_DEFAULT_VALUE) && child
								.hasAttribute(IOilXMLLabels.ATTR_WITH_AUTO))
								|| (ch
										.hasAttribute(IOilXMLLabels.ATTR_WITH_AUTO) && child
										.hasAttribute(IOilXMLLabels.ATTR_DEFAULT_VALUE))) {

							throw new ParseException(
									"Found an element declared more than one time with differents proterties.\n"
											+ "A default value and AUTO are setted\n"
											+ child.getAttribute(LOCATION));
						}

						mergeAttributes(ch, child, ATTR_ATT_LIST);
						mergeAll(ch, child.getChildNodes());

						return;
					}
				}
			}

			removeLocation(child);
//			Node cp = child.getParentNode();
//			if (cp != null) {
//				cp.removeChild(child);
//			}
			
//			if (child.getOwnerDocument() != parent.getOwnerDocument())
//			parent.appendChild(parent.getOwnerDocument().importNode(child, true));
//		else
//			parent.appendChild(child);
			parent.appendChild(parent.getOwnerDocument().importNode(child, true));


		} else if (IOilXMLLabels.ELEM_REFERENCE.equals(nodeName)) {
			String attName = child.getAttribute(IOilXMLLabels.ATTR_NAME);

			NodeList children = parent.getChildNodes();

			for (int i = 0; i < children.getLength(); i++) {
				Node n = children.item(i);

				if (n instanceof Element) {
					Element ch = (Element) n;

					// check properties
					boolean ok_1 = checkStrings(IOilXMLLabels.ELEM_REFERENCE,
							ch.getNodeName());
					boolean ok_2 = checkStrings(IOilXMLLabels.ELEM_ATTRIBUTE,
							ch.getNodeName())
							|| checkStrings(IOilXMLLabels.ELEM_VARIANT, ch
									.getNodeName());

					boolean ok = false;
					if (ok_1 || ok_2) {
						ok = checkStrings(attName, ch
								.getAttribute(IOilXMLLabels.ATTR_NAME));
					}
					if (ok) { // found
						if (ok_2) {
							throw new ParseException(
									"Found an element declared more than one time with differents proterties.\n"
											+ attName
											+ " declared as REFERENCE and as "
											+ ch.getNodeName() + "\n"
											+ child.getAttribute(LOCATION));
						}

						mergeAttributes(ch, child, ATTR_REF_LIST);
						mergeAll(ch, child.getChildNodes());

						return;
					}
				}
			}

			removeLocation(child);
//			Node cp = child.getParentNode();
//			if (cp != null) {
//				cp.removeChild(child);
//			}
//			if (child.getOwnerDocument() != parent.getOwnerDocument())
//			parent.appendChild(parent.getOwnerDocument().importNode(child, true));
//		else
//			parent.appendChild(child);
			parent.appendChild(parent.getOwnerDocument().importNode(child, true));

		} else if (IOilXMLLabels.ELEM_VARIANT.equals(nodeName)) {
			String attName = child.getAttribute(IOilXMLLabels.ATTR_NAME);

			NodeList children = parent.getChildNodes();

			for (int i = 0; i < children.getLength(); i++) {
				Node n = children.item(i);

				if (n instanceof Element) {
					Element ch = (Element) n;

					// check properties
					boolean ok_1 = checkStrings(IOilXMLLabels.ELEM_VARIANT, ch
							.getNodeName());
					boolean ok_2 = checkStrings(IOilXMLLabels.ELEM_ATTRIBUTE,
							ch.getNodeName())
							|| checkStrings(IOilXMLLabels.ELEM_REFERENCE, ch
									.getNodeName());

					boolean ok = false;
					if (ok_1 || ok_2) {
						ok = checkStrings(attName, ch
								.getAttribute(IOilXMLLabels.ATTR_NAME));
					}
					if (ok) { // found
						if (ok_2) {
							System.out.println("Parent = " + parent
									+ "\nChild = " + child);
							throw new ParseException(
									"Found an element declared more than one time with differents proterties.\n"
											+ attName
											+ " declared as VARIANT and as "
											+ ch.getNodeName() + "\n"
											+ child.getAttribute(LOCATION));
						}

						// only one
						if ((ch.hasAttribute(IOilXMLLabels.ATTR_DEFAULT_VALUE) && child
								.hasAttribute(IOilXMLLabels.ATTR_WITH_AUTO))
								|| (ch
										.hasAttribute(IOilXMLLabels.ATTR_WITH_AUTO) && child
										.hasAttribute(IOilXMLLabels.ATTR_DEFAULT_VALUE))) {

							throw new ParseException(
									"Found an element declared more than one time with differents proterties.\n"
											+ "A default value and AUTO are setted\n"
											+ child.getAttribute(LOCATION));
						}

						mergeAttributes(ch, child, ATTR_VAR_LIST);
						mergeAll(ch, child.getChildNodes());

						return;
					}
				}
			}

			removeLocation(child);
//			Node cp = child.getParentNode();
//			if (cp != null) {
//				cp.removeChild(child);
//			}
			parent.appendChild(parent.getOwnerDocument().importNode(child, true));

		}
		// -----------------------------------------------
		// RANGE - VALUE
		// -----------------------------------------------
		else if (IOilXMLLabels.ELEM_RANGE.equals(nodeName)) {

			NodeList children = parent.getChildNodes();

			for (int i = 0; i < children.getLength(); i++) {
				Node n = children.item(i);

				if (n instanceof Element) {
					Element ch = (Element) n;

					// check properties
					boolean ok_1 = checkStrings(IOilXMLLabels.ELEM_VALUE, ch
							.getNodeName());
					boolean ok_2 = checkStrings(IOilXMLLabels.ELEM_RANGE, ch
							.getNodeName());

					if (ok_1) {
						mergeAttributes(ch, child, ATTR_RANGE_LIST);
						return;

					} else if (ok_2) {
						throw new ParseException(
								"Found an element declared more than one time with differents proterties.\n"
										+ "Declared a VALUE and a RANGE\n"
										+ child.getAttribute(LOCATION));
					}
				}
			}

			removeLocation(child);
//			Node cp = child.getParentNode();
//			if (cp != null) {
//				cp.removeChild(child);
//			}
			parent.appendChild(parent.getOwnerDocument().importNode(child, true));

		} else if (IOilXMLLabels.ELEM_VALUE.equals(nodeName)) {
			String attValue = child.getAttribute(IOilXMLLabels.ATTR_VALUE);

			NodeList children = parent.getChildNodes();

			for (int i = 0; i < children.getLength(); i++) {
				Node n = children.item(i);

				if (n instanceof Element) {
					Element ch = (Element) n;

					// check properties
					boolean ok_1 = checkStrings(IOilXMLLabels.ELEM_VALUE, ch
							.getNodeName());
					boolean ok_2 = checkStrings(IOilXMLLabels.ELEM_RANGE, ch
							.getNodeName());

					boolean ok = false;
					if (ok_1) {
						ok = checkStrings(attValue, ch
								.getAttribute(IOilXMLLabels.ATTR_VALUE));

					} else if (ok_2) {
						throw new ParseException(
								"Found an element declared more than one time with differents proterties.\n"
										+ "Declared a VALUE and a RANGE\n"
										+ child.getAttribute(LOCATION));
					}

					if (ok) { // found
						return;
					}
				}
			}

			removeLocation(child);
//			Node cp = child.getParentNode();
//			if (cp != null) {
//				cp.removeChild(child);
//			}
			parent.appendChild(parent.getOwnerDocument().importNode(child, true));
		}
		// -----------------------------------------------
		// ENUMERATOR
		// -----------------------------------------------
		else if (IOilXMLLabels.ELEM_ENUMERATOR.equals(nodeName)) {
			String attName = child.getAttribute(IOilXMLLabels.ATTR_NAME);

			NodeList children = parent.getChildNodes();

			for (int i = 0; i < children.getLength(); i++) {
				Node n = children.item(i);

				if (n instanceof Element) {
					Element ch = (Element) n;

					// check properties
					boolean ok = checkStrings(IOilXMLLabels.ELEM_ENUMERATOR, ch
							.getNodeName());
					ok &= checkStrings(attName, ch
							.getAttribute(IOilXMLLabels.ATTR_NAME));

					if (ok) { // found
						mergeAll(ch, child.getChildNodes());

						return;
					}
				}
			}

			removeLocation(child);
//			Node cp = child.getParentNode();
//			if (cp != null) {
//				cp.removeChild(child);
//			}
			parent.appendChild(parent.getOwnerDocument().importNode(child, true));

		}
		// -----------------------------------------------
		// DESCRIPTION
		// -----------------------------------------------
		else if (IOilXMLLabels.ELEM_DESCRIPTION.equals(nodeName)) {
			parent.appendChild(parent.getOwnerDocument().importNode(child, true));

		} else {
			throw new RuntimeException("Not valid node Name :\n " + child);
		}

		// parent.appendChild( child );
	}

	/** Check if two string contain the same value or if they are all null */
	protected static boolean checkStrings(String a, String b) {
		return a == null ? b == null : a.equals(b);
	}

	protected static void mergeAttributes(Element dest, Element newElem,
			String[] attributes) throws ParseException {

		for (int i = 0; i < attributes.length; i++) {
			String n = attributes[i];
			if (newElem.hasAttribute(n)) {
				if (dest.hasAttribute(n)) {

					if (!checkStrings(dest.getAttribute(n), newElem
							.getAttribute(n))) {
						throw new ParseException(
								"Found an element declared more than one time with differents proterties.\n"
										+ "property = " + n + "; old value = "
										+ dest.getAttribute(n)
										+ "; new value = "
										+ newElem.getAttribute(n) + "\n"
										+ newElem.getAttribute(LOCATION));
					}
				}
			}

		}
	}

	protected static void mergeAll(Element parent, NodeList children)
			throws ParseException {
		if (children == null) {
			return;
		}

		for (int cc = 0; cc < children.getLength(); cc++) {
			Node cn = children.item(cc);
			if (cn instanceof Element) {
				mergeElement(parent, (Element) cn);
			}
		}

	}

	protected static void removeLocation(Element elem) {
		elem.removeAttribute(LOCATION);

		NodeList children = elem.getChildNodes();
		for (int cc = 0; cc < children.getLength(); cc++) {
			Node cn = children.item(cc);
			if (cn instanceof Element) {
				removeLocation((Element) cn);
			}
		}

	}

}
