/*
 * Created on Jan 26, 2005
 *
 * $Id: OilDocumentProvider.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.ui.editor.text;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.rules.DefaultPartitioner;
import org.eclipse.ui.editors.text.FileDocumentProvider;

/**
 * This class prepares the document for OilTextEditor.
 * 
 * @author Nicola Serreli
 */
public class OilDocumentProvider extends FileDocumentProvider {

	/**
	 * Makes a new Document from a IEditorPart. Also set DocumentPartitioner.
	 * 
	 * @param element
	 *            the object source
	 * 
	 * @return a new document or null if element is unknow.
	 */
	protected IDocument createDocument(Object element) throws CoreException {
		IDocument document = super.createDocument(element);
		if (document != null) {
			IDocumentPartitioner partitioner = new DefaultPartitioner(
					new OilPartitionScanner(), new String[] {
							OilPartitionScanner.STR_LONG_COMMENT,
							OilPartitionScanner.STR_COMMENT,
							OilPartitionScanner.STR_STRING });
			partitioner.connect(document);
			document.setDocumentPartitioner(partitioner);
		}
		return document;
	}
}