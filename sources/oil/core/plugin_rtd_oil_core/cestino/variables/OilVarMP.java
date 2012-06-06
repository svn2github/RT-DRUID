/*
 * Created on Aug 26, 2004
 *
 * $Id: OilVarMP.java,v 1.5 2008/01/09 17:47:10 durin Exp $
 */
package com.eu.evidence.rtdruid.vartree.variables;



import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;

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

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilTransformException;
import com.eu.evidence.rtdruid.internal.vartree.data.oil.impl.OilApplPointer;
import com.eu.evidence.rtdruid.modules.oil.keywords.IOilXMLLabels;
import com.eu.evidence.rtdruid.vartree.IMountPointVar;
import com.eu.evidence.rtdruid.vartree.ISubVarTreePointer;
import com.eu.evidence.rtdruid.vartree.IVariable;
import com.eu.evidence.rtdruid.vartree.VarTreeUtil;
import com.eu.evidence.rtdruid.vartree.data.oil.Enumerator;
import com.eu.evidence.rtdruid.vartree.data.oil.HW;
import com.eu.evidence.rtdruid.vartree.data.oil.OilApplFactory;
import com.eu.evidence.rtdruid.vartree.data.oil.OilApplPackage;
import com.eu.evidence.rtdruid.vartree.data.oil.OilObjectWithID;
import com.eu.evidence.rtdruid.vartree.data.oil.RTOS;
import com.eu.evidence.rtdruid.vartree.data.oil.Root;
import com.eu.evidence.rtdruid.vartree.data.oil.Value;
import com.eu.evidence.rtdruid.vartree.data.oil.Variant;

/**
 * @author Nicola Serreli
 */
public class OilVarMP extends OilVar implements IMountPointVar {
	
    private static Transformer transformer;
	final protected OilApplPackage OAPKG = OilApplPackage.eINSTANCE;
    final protected OilApplFactory OAF = OilApplFactory.eINSTANCE;

	public interface DocumentState {
		void modified();
	}
	
	public static final int STR  =0;
	public static final int EMF  =1;
	public static final int BOTH =2;

	protected int current;
	protected EList<OilObjectWithID> emfDoc;
	//protected EList value;


	public OilVarMP() {
		this.current = STR;
		this.value = null;
		this.emfDoc = null;
	}
	
	public OilVarMP(String value) {
		this.current = STR;
		this.value = value;
		this.emfDoc = null;
	}
	
//	private OilVarMP(EList<Object> value) {
//		this.current = EMF;
//		this.emfDoc = value;
//		this.value = null;
//	}	
	
	//-------------------------
	
	/**	This method is a frontend to default constructor
	*
	*	@return a new instance of this OilVarMP
	*/
	public IVariable instance() {
		return new OilVarMP();
	}
	
	public Object clone() {
		OilVarMP answer = new OilVarMP();
		
		answer.current  = this.current;
		answer.value    = this.value;
		
		if (this.emfDoc != null) {
		    answer.emfDoc   = new BasicEList<OilObjectWithID>();
		    for (int i=0; i<this.emfDoc.size(); i++) { 
		    	answer.emfDoc.add(this.emfDoc.get(i)); // DEBUG : VarTreeCopy is not working with OilVarMP . this is valid until the bug is fixed
		        //answer.emfDoc.add(VarTreeCopy.copy(( (OilObjectWithID) this.emfDoc.get(i))));
		    }
		} else { 
		    answer.emfDoc   = null;
		}
		
		return answer;
	}

	public void dispose() {
		this.value = null;
		this.emfDoc.clear(); this.emfDoc = null;
		current = STR;
	}

	public boolean equals(Object o) {
		if (o instanceof OilVarMP) {
			String a = toString();
			String b = o.toString();
			return a == null ? b == null : a.equals(b);
		}
		
		return false;
	}
	//	 ----------------------   SET & GET   ----------------------
	
	/**	Sets the value of this IVariable
	*
	*	@param	value	the datum (it can be null)
	*/
	public void set(String value) {
		this.value = value;
	}
	public Object get() {
		return toString();
	}
	public String toString() {
		if (current == EMF) {
			this.value = toString(emfDoc);
			current = BOTH;
		}
		return this.value == null ? "null" : (String) this.value;
	}
	
	
	protected void popolateEmf() {
		if (current == STR) {
			emfDoc = parse( (String) this.value);
			current = BOTH;
		}
	}
	
	/**
	 * @retun  null if this object doesn't contains data, a IVarTreePointer otherwise
	 */
	public ISubVarTreePointer getPointer(EditingDomain editingDomain) {
		
		popolateEmf();
		
		return new OilApplPointer(emfDoc, editingDomain, new DocumentState() {
			public void modified() {
				current = EMF;
				resetString();
			}
		});
	}
	
	protected void resetString() {
		this.value = null;
	}
	//-------------------
	
	protected EList<OilObjectWithID> parse(String data) {//, OilImplID implId) {
		EList<OilObjectWithID> tmpDoc = new BasicEList<OilObjectWithID>();
		// return a void tree
        if (data == null) {
			return tmpDoc;
		}

		
	    Document doc = null;
		try {
	
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setIgnoringElementContentWhitespace(true);
			factory.setIgnoringComments(true);
			DocumentBuilder builder = factory.newDocumentBuilder();
			String tmp = "<a>" + data + "</a>";
			
			doc = builder.parse(new ByteArrayInputStream(tmp.getBytes()));
			
		} catch(IOException e) {
			// JOptionPane.showMessageDialog(Desk.instance(), e);
			throw new IllegalStateException( e.getMessage() );
		} catch(ParserConfigurationException e) {
			// JOptionPane.showMessageDialog(Desk.instance(), e);
			throw new IllegalStateException( e.getMessage() );
		} catch(SAXException e) {
			// JOptionPane.showMessageDialog(Desk.instance(), e);
			throw new IllegalStateException( e.getMessage() );
		}

		if (doc.getDocumentElement() != null) {
			NodeList children = doc.getDocumentElement().getChildNodes();
			for (int i=0; i<children.getLength(); i++) {
				if (children.item(i) instanceof Element) {
					tmpDoc.add((OilObjectWithID) storeInsideAOilVar((Element) children.item(i), null));
				}
			}
		}
		
		// TODO : scrivere la funzione che effettua il parsing (da stringa-Oil ad XML)
		return tmpDoc;
	}
	
    /**
     * Recursively stores an sub Oil tree (XML) inside the current
     * subVarTreePointer.
     * 
     * @param svtp
     *            where add the new data
     * @param current
     *            the new data
     * @param typePath
     *            identifies the type of parent node, inside the Oil
     *            Implementation tree. typePath[0] is the FIRST_LEVEL_OBJECT
     *            tpye and typePath[size-1] is the type of parent node.
     * 
     * @throws OilTransformException
     *             if there are some problems
     */
    protected Object storeInsideAOilVar(Element current, OilObjectWithID parent)
    		throws OilTransformException {
        
        String elemType = current.getNodeName();
        OilObjectWithID answer = null;
        EList childrenList = null;
        
        if (IOilXMLLabels.ELEM_OILVAR_ROOT.equals(elemType)) {
            /***********************************************************************
             * Store the root
             **********************************************************************/
        	answer = OAF.createRoot();
        	
			if (current.hasAttribute(IOilXMLLabels.ATTR_OBJ_TYPE)) {
				String att = current.getAttribute(IOilXMLLabels.ATTR_OBJ_TYPE);
				((Root) answer).setObjectType(new StringVar(att));
			}
        	
        	childrenList = ((Root) answer).getHwList();
        	
        } else if (IOilXMLLabels.ELEM_OILVAR_HW.equals(elemType)) {
            /***********************************************************************
             * Store an HW
             **********************************************************************/
        	answer = OAF.createHW();
        	
			if (current.hasAttribute(IOilXMLLabels.ATTR_NAME)) {
				String att = current.getAttribute(IOilXMLLabels.ATTR_NAME);
				((HW) answer).setName(new StringVar(att));
			} else {
				((HW) answer).setName(null);
			}
        	
			childrenList = ((HW) answer).getRtosList();

        } else if (IOilXMLLabels.ELEM_OILVAR_RTOS.equals(elemType)) {
            /***********************************************************************
             * Store a RT-OS
             **********************************************************************/
        	answer = OAF.createRTOS();
        	
			if (current.hasAttribute(IOilXMLLabels.ATTR_NAME)) {
				String att = current.getAttribute(IOilXMLLabels.ATTR_NAME);
				((RTOS) answer).setName(new StringVar(att));
			} else {
				((RTOS) answer).setName(null);
			}
        	
			childrenList = ((RTOS) answer).getParameterList();

        } else if (IOilXMLLabels.ELEM_ATTRIBUTE.equals(elemType)) {
            /***********************************************************************
             * Store an Attribute (String, Int, Double, ...)
             **********************************************************************/
        	answer = OAF.createValue();
        	
			if (current.hasAttribute(IOilXMLLabels.ATTR_NAME)) {
				String att = current.getAttribute(IOilXMLLabels.ATTR_NAME);
				((Value) answer).setName(new StringVar(att));
			}
        	
			childrenList = ((Value) answer).getValues();
        	
        } else if (IOilXMLLabels.ELEM_VALUE.equals(elemType)) {
            /***********************************************************************
             * Store one value of an Attribute
             **********************************************************************/
        	answer = null;
        	
			if (current.hasAttribute(IOilXMLLabels.ATTR_CURR_VALUE)) {
				return new StringDescrVar(current.getAttribute(IOilXMLLabels.ATTR_CURR_VALUE));
			}

        } else if (IOilXMLLabels.ELEM_VARIANT.equals(elemType)) {
            /***********************************************************************
             * Store a list
             **********************************************************************/
        	answer = OAF.createVariant();
        	
			if (current.hasAttribute(IOilXMLLabels.ATTR_NAME)) {
				String att = current.getAttribute(IOilXMLLabels.ATTR_NAME);
				((Variant) answer).setName(new StringVar(att));
			}
        	
			childrenList = ((Variant) answer).getEnumeratorList();
        	
        } else if (IOilXMLLabels.ELEM_ENUMERATOR.equals(elemType)) {
            /***********************************************************************
             * Store an element of a list (an Enumerator)
             **********************************************************************/
        	answer = OAF.createEnumerator();
        	
			if (current.hasAttribute(IOilXMLLabels.ATTR_VALUE)) {
				String att = current.getAttribute(IOilXMLLabels.ATTR_VALUE);
				((Enumerator) answer).setValue(new StringVar(att));
			}
        	
			childrenList = ((Enumerator) answer).getParameterList();
        	
        } else if (IOilXMLLabels.ELEM_DESCRIPTION.equals(elemType)) {
        	/*TODO : add Description*/
        } else {
        	/// ???
        }
        
        
        if (childrenList != null) {
        	NodeList children = current.getChildNodes();
        	for (int i=0; i<children.getLength(); i++) {
        		Node n = children.item(i);
        		if (n instanceof Element) {
	        		Object child = storeInsideAOilVar((Element)n, answer);
	        		if (child != null) {
	        			childrenList.add(child);
	        		}
        		}
        	}
        }
        
                
        return answer;
    }
    /**
     * Searchs an attribute, ingoring case
     */
    protected String getAttribute(Element elem, String attrName) {

        NamedNodeMap attrs = elem.getAttributes();

        // search
        for (int i = 0; i < attrs.getLength(); i++) {
            if (attrName.equalsIgnoreCase(attrs.item(i).getNodeName())) {
                return attrs.item(i).getNodeValue();
            }
        }
        return null;
    }
    /**
     * If the condition is false, throws a new OilTransform exception
     * 
     * @param value
     *            the condition
     * @param msg
     *            the message for the OilTransformException
     * @throws OilTransformException
     *             if value is false
     */
    protected void checkTrue(boolean value, String msg)
            throws OilTransformException {
        throw new OilTransformException(msg);
    }
//    protected ISubVarTreePointer makePath(ISubVarTreePointer svtp, String[] names,
//            String[] types) throws OilTransformException {
//        throw new OilTransformException("");
//    }
    /**
     * Check if two strings are equals (or also if they are togheter null).
     * 
     * @param a
     *            the first string
     * @param b
     *            the second string
     * 
     * @return true if <code>a == null and b == null</code> or if
     *         <code>a != null and a.equals(b)</code>
     */
    protected boolean checkStrings(String a, String b) {
        return a == null ? b == null : a.equals(b);
    }

	
	protected static String toString(EList<OilObjectWithID> data) {
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();

		Document doc;
        try {
        	doc = docFactory.newDocumentBuilder().newDocument();
        } catch (ParserConfigurationException e) {
                throw new IllegalStateException("exception during creation of a new Document:\n\t"
                        + e.getMessage());
        }
        
        if (data == null) {
        	return null;
        }

        if (transformer == null) {
    		try {
            	transformer = TransformerFactory.newInstance()
            		.newTransformer();
            	transformer.setOutputProperty(OutputKeys.INDENT, "no");

    		} catch (TransformerConfigurationException tce) {
    			RtdruidLog.log(tce);
    			return "";
    		}
        }
        
        StringBuffer buffer = new StringBuffer();
        for (Iterator<OilObjectWithID> iter=data.iterator(); iter.hasNext();){
        	OilObjectWithID curr = (OilObjectWithID) iter.next();
        	Element elem = curr.getXmlRapresentation(doc);
        	ByteArrayOutputStream tmp = new ByteArrayOutputStream();
        	
    		try {
    			// Transform the source XML
    			transformer.transform(new DOMSource(elem), new StreamResult(tmp));
    		} catch (TransformerException te) {
    			RtdruidLog.log(te);
    		}

    		String tmpSt = tmp.toString();
    		int index = tmpSt.indexOf("?>");
    		if (index > -1) {
    			tmpSt = tmpSt.substring(index+2);
    		}
        	buffer.append(tmpSt);
        }
        
		return buffer.toString();
	}
	
	
	@Override
	public void merge(IMountPointVar var, String path, boolean overwrite) {
		if (var == null) {
			return;
		}
		if (!(var instanceof OilVarMP)) {
			throw new IllegalArgumentException();
		}
		
		// ensure emfDoc are full
		OilVarMP newVar = (OilVarMP) var;
		newVar.popolateEmf();
		popolateEmf();
		
		for (OilObjectWithID rroot : newVar.emfDoc) {
			boolean newElem = true;
			for (Iterator<OilObjectWithID> iter = emfDoc.iterator(); iter.hasNext() && newElem;) {
				OilObjectWithID elem = iter.next();
				if (checkStrings(elem.getObjectID(), rroot.getObjectID())) {
					newElem = false;
					VarTreeCopy.merge(elem, rroot, path, overwrite);
				}
			}
			if (newElem) {
				emfDoc.add(rroot.clone());
			}
		}
	}
}
