package com.eu.evidence.rtdruid.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Map;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;

/**
 * This class combines both {@link IRTDExporter} and {@link IRTDImporter} for
 * xslt transformations.
 * 
 * @author Nicola Serreli
 */
public class XsltImportExport implements IRTDImporter, IRTDExporter {

	/** The xslt file used to import data inside RT-Druid */
	protected URL in_xsltFile;
	/** The xslt file used to export data from RT-Druid */
	protected URL out_xsltFile;
	/** The dtd file used to validate the xml file during the import phase */
	protected URL in_dtdFile;

	/**
	 * Builds a new instance to import and export data from RT-Druid to a
	 * specific xml format.
	 * 
	 * @param xml2rtd_xsltFile
	 *            the xslt file used to import data inside RT-Druid. Cannot be
	 *            null.
	 * @param dtdFile
	 *            the dtd file used to validate the xml file during the import.
	 *            phase
	 * @param rtd2xml_xsltFile
	 *            the xslt file used to export data from RT-Druid. Cannot be
	 *            null.
	 * 
	 * @throws NullPointerException
	 *             if xml2rtd_xsltFile o rtd2xml_xsltFile is null
	 */
	public XsltImportExport(URL xml2rtd_xsltFile, URL dtdFile,
			URL rtd2xml_xsltFile) {
		Assert.isNotNull(xml2rtd_xsltFile);
		Assert.isNotNull(rtd2xml_xsltFile);

		this.in_xsltFile = xml2rtd_xsltFile;
		this.out_xsltFile = rtd2xml_xsltFile;
		this.in_dtdFile = dtdFile;
	}

	public EObject load(InputStream input, Map<?, ?> options) throws IOException {
		XsltImporter in = new XsltImporter(in_xsltFile, in_dtdFile);
		return in.load(input, options);
	}

	
	public void export(OutputStream output, EObject data, Map<?, ?> options)
			throws IOException {
		XsltExporter out = new XsltExporter(out_xsltFile);
		out.export(output, data, options);
	}
}
