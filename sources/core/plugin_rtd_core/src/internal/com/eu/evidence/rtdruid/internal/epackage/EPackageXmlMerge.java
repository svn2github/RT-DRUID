/**
 * 12/dic/2011
 */
package com.eu.evidence.rtdruid.internal.epackage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.emf.ecore.EPackage;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.eu.evidence.rtdruid.epackage.EPackageUtility;
import com.eu.evidence.rtdruid.epackage.IEPackageMerge;
import com.eu.evidence.rtdruid.epackage.RTDEPackageBuildException;

/**
 * This class merges EPackages (using xml representations)
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class EPackageXmlMerge implements IEPackageMerge {
	
	protected EpkgMerger merger;
	
	protected enum State {
		empty, merging, closed;
	}
	
	protected State currentState;
	
	public EPackageXmlMerge() {
		currentState = State.empty;
	}
	
	/**
	 * 
	 * @param pkg
	 * 
	 * @throws IllegalStateException if addPackage is called after call get result
	 */
	public void addEPackage(EPackage pkg) throws RTDEPackageBuildException {
		if (pkg == null) {
			throw new NullPointerException();
		}
		
		switch (currentState) {
			case closed : 
				throw new IllegalStateException("Cannot add a new EPackage after get the result");
			case empty : {
				merger = new EpkgMerger(pkg);
				currentState = State.merging;
				break;
			} 
			case merging : {
				merger.merge(pkg);
				break;
			}
		} 
	}
	
	
	/**
	 * This function returns the result of the merge. After this call it is not possible to add more packages.
	 * The result can be null, if addEPackages was never called;
	 * 
	 * 
	 * @return the result of the merge operation
	 */
	public EPackage getResult() {
		currentState = State.closed;
		return merger == null ? null : merger.getResult();
	}
	


	// ------------------------------------------------------
	//    Emf ID Manager
	// ------------------------------------------------------
	/**
	 * This class computes a String ID for an Emf element 
	 *
	 * @author Nicola Serreli
	 * @since 2.0
	 *
	 */
	protected static class EIdManager {
		
		public final static EIdManager mngr = new EIdManager();
		
		private EIdManager() {}

		public String getCategory(Element o) {
			return o.getNodeName();
		}

		public String getId(Element o) {
			String attrId = "details".equalsIgnoreCase(getCategory(o)) ? "key" : "name";
			NamedNodeMap attrs = o.getAttributes();
			for (int i = 0; i<attrs.getLength(); i++) {
				Node attr = attrs.item(i);
				if (attrId.equalsIgnoreCase(attr.getNodeName())) {
					return attr.getNodeValue();
				}
			}
			return null;
		}
	}

		
	// ------------------------------------------------------
	//    Emf Package Merger
	// ------------------------------------------------------
	/**
	 * This class merges one or more packages 
	 *
	 * @author Nicola Serreli
	 * @since 2.0
	 *
	 */
	protected static class EpkgMerger {
		protected final HashMap<Element, LinkedHashMap<String, LinkedHashMap<String, Element>>> fast = new HashMap<Element, LinkedHashMap<String, LinkedHashMap<String,Element>>>();
		protected final Document result;
		
		protected final EIdManager idmgr = EIdManager.mngr;
		
		protected final String XML_EPACKAGE = "ecore:EPackage";
		protected final String XML_ECLASS = "eClassifiers";
		
		/**
		 * 
		 */
		public EpkgMerger(EPackage dest) {
			result = emf2Dom(dest);
		}
		
		public void merge(EPackage addition) throws RTDEPackageBuildException {
			
			Document addDoc = emf2Dom(addition);
			Element addRoot = addDoc.getDocumentElement();
			
			if (addRoot != null) {
				Element resRoot = result.getDocumentElement();
				Element newRoot = merge(resRoot, addRoot);
				if (newRoot != resRoot) {
					if (resRoot != null) {
						result.removeChild(resRoot);
					}
					result.appendChild(newRoot);
				}
			}
		}
		
		/**
		 * @param old the old element. it can be null
		 * @param add contain the new element. Cannot be null
		 */
		protected Element merge(Element old, Element add) throws RTDEPackageBuildException {
			if (old == null) {
				return (Element) result.importNode(add, true);
			}
			
			// check attributes
			if (XML_EPACKAGE.equalsIgnoreCase(old.getNodeName())) {
				mergeEPackageAttributesDiff(old, add);
			} else if (XML_ECLASS.equalsIgnoreCase(old.getNodeName())) {
				mergeAttributesDiff(old, add);
			} else if (isAttributesDiff(old, add)) {
				throw new RTDEPackageBuildException("Two elements has differents attributes: " + old.getNodeName()+ "\n\t firstNode attribute list = " + attrList(old) + "\n\t firstNode attribute list = " + attrList(add));
			}
			
			LinkedHashMap<String, LinkedHashMap<String, Element>> mapOld = getFastMap(old);
			NodeList add_children = add.getChildNodes();

			for (int i=0; i<add_children.getLength(); i++) {
				Node addChild = add_children.item(i);
				if (addChild instanceof Element) {
					Element oldChild = getFast(mapOld, addChild);
					if (oldChild == null) {
						addChild = result.importNode(addChild, true);
						addFast(mapOld, addChild);
						old.appendChild(addChild);
					} else {
						merge(oldChild, (Element)addChild);
					}
				}
			}
			
			
			
			return old;
		}
		
		/**
		 * @param old
		 * @return
		 */
		private String attrList(Element old) {
			StringBuffer buff = new StringBuffer();
			
			NamedNodeMap attrList = old.getAttributes();
			
			for (int i=0; i<attrList.getLength(); i++) {
				Node attr = attrList.item(i);
				buff.append("(" + attr.getNodeName() + "= " + attr.getNodeValue()+")");
			}
			return buff.toString();
		}

		/**
		 * @return false if elem1 and elem2 contains the same set of attributes with the same value, true if there is a difference
		 */
		protected boolean isAttributesDiff(Element elem1, Element elem2) {
			boolean answer = true;
			
			NamedNodeMap attrList1 = elem1.getAttributes();
			NamedNodeMap attrList2 = elem2.getAttributes();
			
			answer = attrList1.getLength() == attrList2.getLength();
			for (int i=0; answer && i<attrList1.getLength(); i++) {
				Node attr1 = attrList1.item(i);
				String attrName = attr1.getNodeName();
				Node attr2 = attrList2.getNamedItem(attrName);
				answer = attr2 != null && strEqu(attr1.getNodeValue(), attr2.getNodeValue());
			}
			
			return !answer;
		}
		
		/**
		 * @return false if elem1 and elem2 contains the same set of attributes with the same value, true if there is a difference
		 */
		protected void mergeAttributesDiff(Element old, Element add) throws RTDEPackageBuildException {
			NamedNodeMap attrListOld = old.getAttributes();
			NamedNodeMap attrListAdd = add.getAttributes();
			
			for (int i=0; i<attrListAdd.getLength(); i++) {
				Node attr1 = attrListAdd.item(i);
				String attrName = attr1.getNodeName();
				
				Node attr2 = attrListOld.getNamedItem(attrName);
					
				if (attr2 == null) {
					old.setAttribute(attr1.getNodeName(), attr1.getNodeValue());
				} else if (!strEqu(attr1.getNodeValue(), attr2.getNodeValue())) {
					throw new RTDEPackageBuildException("Two elements has differents attributes: " + old.getNodeName()+ "\n\t firstNode attribute list = " + attrList(old) + "\n\t firstNode attribute list = " + attrList(add));
				}
			}
		}
		
		/**
		 * @return false if elem1 and elem2 contains the same set of attributes with the same value, true if there is a difference
		 */
		protected void mergeEPackageAttributesDiff(Element old, Element add) {
			NamedNodeMap attrListOld = old.getAttributes();
			NamedNodeMap attrListAdd = add.getAttributes();
			
			for (int i=0; i<attrListAdd.getLength(); i++) {
				Node attr1 = attrListAdd.item(i);
				String attrName = attr1.getNodeName();
				
				Node attr2 = attrListOld.getNamedItem(attrName);
					
				if (attr2 == null) {
					old.setAttribute(attr1.getNodeName(), attr1.getNodeValue());
				} else if (!strEqu(attr1.getNodeValue(), attr2.getNodeValue())) {
						// warning values are different
				}
			}
		}
		
		
		
		protected boolean strEqu(String s1, String s2) {
			return s1 == null ? s2 == null : s1.equals(s2);
		}
		
		/**
		 * @return the result
		 */
		public EPackage getResult() {
			return dom2Emf(result);
		}

		/**
		 * return the map of children of parent element
		 * 
		 * @param parent 
		 * @return
		 */
		protected LinkedHashMap<String, LinkedHashMap<String, Element>> getFastMap(Element parent) {
			LinkedHashMap<String, LinkedHashMap<String, Element>> answer;
			
			if (fast.containsKey(parent)) {
				answer = fast.get(parent);
			} else {
				answer = new LinkedHashMap<String, LinkedHashMap<String,Element>>();
				fast.put(parent, answer);
				
				// fill the map
				NodeList children = parent.getChildNodes();
				for (int i=0; i<children.getLength(); i++) {
					addFast(answer, children.item(i));
				}
			}
			
			return answer;
		}

		protected void addFast(LinkedHashMap<String, LinkedHashMap<String, Element>> map, Node o) {
			if (o instanceof Element) {
				Element e = (Element) o;
				String nodeName = idmgr.getCategory(e);
				
				LinkedHashMap<String, Element> list;
				if (map.containsKey(nodeName)) {
					list = map.get(nodeName);
				} else {
					list = new LinkedHashMap<String, Element>(); 
					map.put(nodeName, list);
				}

				list.put(idmgr.getId(e),e);
			}
		}

		protected Element getFast(LinkedHashMap<String, LinkedHashMap<String, Element>> map, Node o) {
			if (o instanceof Element) {
				Element e = (Element) o;
				String nodeName = idmgr.getCategory(e);
				
				LinkedHashMap<String, Element> list;
				if (map.containsKey(nodeName)) {
					list = map.get(nodeName);
				} else {
					return null;
				}

				String id = idmgr.getId(e);
				return list.containsKey(id) ? list.get(id): null;
			}
			return null;
		}

		
		protected void addFast(Element parent, Node o) {
			if (o instanceof Element) {
				addFast(getFastMap(parent), o);
			}
		}
		
		protected Element getFast(Element parent, Node o) {
			if (o instanceof Element) {
				return getFast(getFastMap(parent), o);
			}
			return null;
		}
		
		
		protected static Document emf2Dom(EPackage pkg) {
			Document result = null;
			try {
			
				final String xmlForm = (new EPackageUtility()).modelToString(pkg); 
//				System.out.println("__emf2Dom\n" + xmlForm + "\n__");
				
				{ // String to Dom
		            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
					result = docBuilder.parse (new ByteArrayInputStream(xmlForm.getBytes()));
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			} catch (SAXException e) {
				throw new RuntimeException(e);
			}catch(ParserConfigurationException e) {
				throw new RuntimeException(e);
			}

			return result;
		}
		
		protected static EPackage dom2Emf(Document doc) {
			String xmlForm = null;
			EPackage answer = null;
			
			{ // Dom to String
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				try {
					Transformer transformer = TransformerFactory.newInstance()
							.newTransformer();
	
					transformer.setOutputProperty(OutputKeys.INDENT, "yes");
					// Transform the source XML
					transformer.transform(new DOMSource(doc), new StreamResult(out));

					xmlForm = out.toString();
				} catch (TransformerConfigurationException tce) {
					throw new RuntimeException(tce);
	
				} catch (TransformerException te) {
					throw new RuntimeException(te);
				}
			}
//			System.out.println("__dom2Emf\n" + xmlForm + "\n__");
			
			{ // String to EPackage
				try {
					answer = (new EPackageUtility()).stringToModel(xmlForm);
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return answer;
		}

		
	}
	
}
