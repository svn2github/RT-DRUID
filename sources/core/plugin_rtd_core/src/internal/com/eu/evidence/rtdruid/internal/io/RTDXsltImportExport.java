package com.eu.evidence.rtdruid.internal.io;

import java.net.URL;

import com.eu.evidence.rtdruid.Rtd_corePlugin;
import com.eu.evidence.rtdruid.io.IRTDExporter;
import com.eu.evidence.rtdruid.io.IRTDImporter;
import com.eu.evidence.rtdruid.io.XsltImportExport;

/**
 * This class implements {@link IRTDExporter} and {@link IRTDImporter} in order
 * to support RTD files.
 * 
 * @author Nicola Serreli
 */
public final class RTDXsltImportExport extends XsltImportExport {

	/** Path to XSLT file to convert an Evidence XML file into a Evidence XMI file (for EMF) */
	private final static String XML_2_XMI_TRANSFORMATION = Rtd_corePlugin.TEMPLATES_PATH + "/xml_2_EMFxmi.xsl"; 
		//MyXMIReaderImpl.class.getResource("/rtdruid/vartree/data/init/xml_2_EMFxmi.xsl");
	
	/** Path to XSLT file to convert an Evidence XMI (EMF) file into a Evidence XML file */
	private final static String XMI_2_XML_TRANSFORMATION = Rtd_corePlugin.TEMPLATES_PATH + "/EMFxmi_2_xml.xsl";
		//MyXMIReaderImpl.class.getResource("/rtdruid/vartree/data/init/EMFxmi_2_xml.xsl");

	/** Default DTD*/
	private final static String DEFAULT_VERSION = "evidence_0.4.dtd";
	
	/** Path to last DTD file */
	private final static String LAST_DTD_FILE = Rtd_corePlugin.TEMPLATES_PATH + "/" + DEFAULT_VERSION;
	
	private static final URL lastDtdFile;
	private static final URL XMI_2_XML;
	private static final URL XML_2_XMI;

	static {
	    lastDtdFile = getLastDtdFile();
	    XMI_2_XML = getXMI_2_XML();
	    XML_2_XMI = getXML_2_XMI();
	    
	    if (lastDtdFile == null || XMI_2_XML == null || XML_2_XMI == null) {
	        throw new Error("Some required files not found");
	    }
	    
	}

	
	/**
	 * The defaul constructor. Init the {@link XsltImportExport} with style
	 * sheet required to load and write RTD files.
	 */
	public RTDXsltImportExport() {
		super(XML_2_XMI, lastDtdFile, XMI_2_XML);
	}

	public static URL getXMI_2_XML() {
		return RTDXsltImportExport.class.getResource(XMI_2_XML_TRANSFORMATION);
	}
	public static URL getXML_2_XMI() {
		return RTDXsltImportExport.class.getResource(XML_2_XMI_TRANSFORMATION);
	}
	public static URL getLastDtdFile() {
		return RTDXsltImportExport.class.getResource(LAST_DTD_FILE);
	}
	
}
