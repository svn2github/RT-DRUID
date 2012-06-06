package com.eu.evidence.rtdruid.vartree.variables;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVarTreePointer;
import com.eu.evidence.rtdruid.vartree.IVariable;
import com.eu.evidence.rtdruid.vartree.VarTreeUtil;
import com.eu.evidence.rtdruid.vartree.Vt2StringUtilities;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;

public class PropertyVarTest {

	@Test
	public void testHashWriteLoad() throws IOException {
		
		Properties p = new Properties();
		
		p.setProperty("P1", "v1");
		p.setProperty("P2", "v2");
		p.setProperty("P3", "v3");
		
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		p.storeToXML(os, null);
		
		System.out.println(os.toString());
	}
	
	
	@Test
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
	
	@Test
	public void testXmlPropertyVar() throws ParserConfigurationException, SAXException, IOException, TransformerException {
		PropertyVar var = new PropertyVar();
		var.set("P1", "v1");
		var.set("P2", "v2");
		var.set("P3", "v3");
		
		String t = var.toString();

		
		Document doc = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setIgnoringComments(true);
		factory.setIgnoringElementContentWhitespace(true);
		{
			DocumentBuilder builder = factory.newDocumentBuilder();
			doc = builder.newDocument();
		}
		
		Element root = doc.createElement("root");
		root.appendChild(doc.createTextNode(t));
		doc.appendChild(root);
		
		String out = writeXml(doc);
		System.out.println(out);
		
		{
			DocumentBuilder builder = factory.newDocumentBuilder();
			doc = builder.parse(new ByteArrayInputStream(out.getBytes()));
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
	
	
	@Test
	public void testVtProperty() {
		
		IVarTree vt = VarTreeUtil.newVarTree();
		
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
	
	
	
	protected String writeXml(Document doc) throws TransformerException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		{
			Transformer transformer = TransformerFactory.newInstance()
					.newTransformer();

			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			// Transform the source XML
			transformer.transform(new DOMSource(doc), new StreamResult(out));
		}
		
		return out.toString();
	}

	
}


