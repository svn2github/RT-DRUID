package com.eu.evidence.rtdruid.vartree.variables;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import junit.framework.TestCase;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

import com.eu.evidence.rtdruid.desk.RTDFactory;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVarTreePointer;
import com.eu.evidence.rtdruid.vartree.IVariable;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.data.init.Vt2StringUtilities;

public class PropertyVarTest extends TestCase {

	public void testHashWriteLoad() {
		
		Properties p = new Properties();
		
		p.setProperty("P1", "v1");
		p.setProperty("P2", "v2");
		p.setProperty("P3", "v3");
		
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			p.storeToXML(os, null);
		} catch (IOException e) {
			fail(e.getMessage());
		}
		
		System.out.println(os.toString());
	}
	
	
	public void testPropertyVar() {
		
		PropertyVar var = new PropertyVar();
		var.set("P1", "v1");
		var.set("P2", "v2");
		var.set("P3", "v3");
		
		String t = var.toString();
		
		System.out.println(t);
		
		PropertyVar var2 = new PropertyVar(t);
		
		System.out.println(var2.toString());
		assertTrue(var2.toString().equals(t));
	}
	
	public void testXmlPropertyVar() {
		PropertyVar var = new PropertyVar();
		var.set("P1", "v1");
		var.set("P2", "v2");
		var.set("P3", "v3");
		
		String t = var.toString();

		
		Document doc = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setIgnoringComments(true);
		factory.setIgnoringElementContentWhitespace(true);
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			doc = builder.newDocument();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		Element root = doc.createElement("root");
		root.appendChild(doc.createTextNode(t));
		doc.appendChild(root);
		
		String out = writeXml(doc);
		System.out.println(out);
		
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			doc = builder.parse(new ByteArrayInputStream(out.getBytes()));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		
		Element root2 = doc.getDocumentElement();
		assertTrue(root2 != null);
		assertTrue(root2.getNodeName().equals("root"));
		assertTrue(root2.getChildNodes().getLength() == 1);
		Node ch = root2.getFirstChild();
		assertTrue(ch instanceof Text);
		String txt = ((Text) ch).getNodeValue();
		IVariable v2 = new PropertyVar(txt);
		
		System.out.println(v2.toString());
		
		assertTrue(var.equals(v2));
	}
	
	
	public void testVtProperty() {
		
		IVarTree vt = (IVarTree) RTDFactory.get(IVarTree.class);
		
		IVarTreePointer vtp = vt.newVarTreePointer();
		assertTrue("System".equals(vtp.add("System", DataPackage.eINSTANCE.getSystem().getName())));
		assertTrue(vtp.goFirstChild());
		
		assertTrue(vtp.go(DataPackage.eINSTANCE.getObjectWithID_Properties().getName()));
		IVariable v = vtp.getVar();
		if (v == null) {
			v = vtp.getNewVar(null);
		}
		assertTrue(v instanceof PropertyVar);
		((PropertyVar) v).set("k1", "v1");
		
		vtp.setVar(v);
		
		
		String txt = Vt2StringUtilities.varTreeToStringErtd(vt);
		System.out.println(txt);
	}
	
	
	
	protected String writeXml(Document doc) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		try {
			Transformer transformer = TransformerFactory.newInstance()
					.newTransformer();

			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			// Transform the source XML
			transformer.transform(new DOMSource(doc), new StreamResult(out));

		} catch (TransformerConfigurationException tce) {
			// Use the contained exception, if any
			Throwable x = tce;
			if (tce.getException() != null)
				x = tce.getException();
			throw new RuntimeException("Cannot produce the xml file", x);

		} catch (TransformerException te) {
			// Use the contained exception, if any
			Throwable x = te;
			if (te.getException() != null)
				x = te.getException();
			throw new RuntimeException("Cannot produce the xml file", x);

		}
		
		return out.toString();
	}

	
}


