/*
 * Created on Jun 1, 2004
 *
 * $Id: MyXMIReaderImpl.java,v 1.1 2005/09/28 15:22:29 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.io;

//import java.io.BufferedOutputStream;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.xml.sax.ErrorHandler;

import com.eu.evidence.rtdruid.io.IRTDExporter;
import com.eu.evidence.rtdruid.io.IRTDImporter;
import com.eu.evidence.rtdruid.io.IVTResource;
import com.eu.evidence.rtdruid.vartree.VarTreeIdHandler;
import com.eu.evidence.rtdruid.vartree.VarTreeUtil;

/** 
 * This class convert an Evidence XML file into a Evidence XMI file (for EMF) and vice versa
 * 
 * @author Nicola Serreli
 */
public class RTDResourceManager extends XMIResourceImpl implements IVTResource {
		
//	private ErrorHandler handler = null;
	
	/**
	 * Constructor for MyXMIReader.
	 */
	public RTDResourceManager() {
		super();
	}

	/**
	 * Constructor for MyXMIReaderImpl.
	 * 
	 * @param uri
	 */
	public RTDResourceManager(URI uri) {
		super(uri);
	}

	/**
	 */
	protected void finalize() {
		if (contents != null) {
			try {
				contents.clear();
			} catch (Exception e) {
				// ignore it
			}
		}
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.ecore.resource.impl.ResourceImpl#doLoad(java.io.InputStream,
	 *      java.util.Map)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void doLoad(InputStream inputStream, Map options) throws IOException {
	
		try {
			
			String imp_type = null;
			
			if (options != null && options.containsKey(IRTDImporter.OPT_USE_IMPORTER_TYPE) &&
					options.get(IRTDImporter.OPT_USE_IMPORTER_TYPE) instanceof String) {
				imp_type = (String) options.get(IRTDImporter.OPT_USE_IMPORTER_TYPE);
			} else if (uri != null && uri.fileExtension() != null ) {
				imp_type = uri.fileExtension();
			}
			/*
			 * Check the extension and call the right IRTDImporter 
			 */
			if (imp_type != null) {
				IRTDImporter importer = RTDResourceManagerFactory.getInstance().getImport(imp_type);
				if (importer != null) {
					// set the parent Importer
					if (options == null) {
						options = new HashMap<String, Object>();
					}
					options.put(IRTDImporter.OPT_PARENT_IMPORTER, new IRTDImporter() {
					
						public EObject load(InputStream input, Map<?, ?> options) throws IOException {
							doSuperLoad(input, options);
							return getContents().get(0);
						}
					});

					if (uri != null) {
						String full_name = null;
						if (uri.isPlatformResource() && EMFPlugin.IS_RESOURCES_BUNDLE_AVAILABLE) {
							IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
							if (root != null) {
								IFile f = root.getFile(new Path(uri.toPlatformString(true)));
								IPath p = f.getLocation();
								full_name = p != null ? p.toOSString() : null; 
							}
						} else {
							full_name = uri.toFileString();
						}
						  
						options.put(IRTDImporter.OPT_FILE_FULLNAME, full_name != null ? full_name : uri.toString());
					}
		
					// Run the RTD importer
					EObject root = importer.load(inputStream, options);
					if (root != null) {
						if (getContents().size() != 0) {
							getContents().set(0,root);
						} else {
							getContents().add(root);
						}
					}
					return;
				}
			}
	
			/*
			 * Check if this InputStream is empty 
			 */
			{
				boolean emptyFile = false;
				if (!inputStream.markSupported()) {
					inputStream = new BufferedInputStream(inputStream);
				}
		
				inputStream.mark(100);
				emptyFile = (inputStream.read() == -1);
				inputStream.reset();
		
				if (emptyFile) { // is empty .. then add the first one element
					final EObject root;
					if (resourceSet == null) {
						root = VarTreeUtil.newVarTreeRoot(VarTreeUtil.newVarTree());
					} else {
						root = VarTreeUtil.newVarTreeRoot(resourceSet.getPackageRegistry());
					}
					VarTreeIdHandler.setId(root, "default system");
					getContents().add(root);
					return;
				}
			}
			
			
			/*
			 * Load the default file : ertd
			 */
			super.doLoad(inputStream, options);			

		} catch (Exception e) {
			throw new IOException(e.getMessage(), e);
		} finally {
			
			if (getContents().size() > 0) {
				/*
				 *  before return, compact multiple instance of the same node
				 *  (two o more node with the same id)
				 */
				EObject oldRoot = getContents().get(0);
				if (oldRoot != null) {
					EObject newRoot = EcoreUtil.create(oldRoot.eClass());
					getContents().set(0, newRoot);
					VarTreeIdHandler.setId(newRoot, VarTreeIdHandler.getId(oldRoot));
					VarTreeUtil.merge(newRoot, oldRoot);//newRoot.merge(oldRoot, "", false);
				}
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.ecore.resource.impl.ResourceImpl#doSave(java.io.OutputStream, java.util.Map)
	 */
	@SuppressWarnings({"unchecked", "rawtypes"})
	public void doSave(OutputStream outputStream, Map options) throws IOException {
		
		
		String exp_type = null;
		
		if (options != null && options.containsKey(IRTDExporter.OPT_USE_EXPORTER_TYPE) &&
				options.get(IRTDExporter.OPT_USE_EXPORTER_TYPE) instanceof String) {
			exp_type = (String) options.get(IRTDExporter.OPT_USE_EXPORTER_TYPE);
		} else if (uri != null && uri.fileExtension() != null ) {
			exp_type = uri.fileExtension();
		}
		
		
		/*
		 * Check the extension and call the right IRTDExporter 
		 */
		if (exp_type != null) {
			// Prepare the parent Exporter
			if (options == null) {
				options = new HashMap<String, Object>();
			}
			options.put(IRTDExporter.OPT_PARENT_EXPORTER, new IRTDExporter() {
			
				public void export(OutputStream output, EObject data, Map<?, ?> options)
						throws IOException {
					doSuperSave(output, options);
				}
			});

			// Run the RTD exporter
			IRTDExporter exporter = RTDResourceManagerFactory.getInstance().getExport(exp_type);
			if (exporter != null && getContents().size()>0) {
				EObject root = getContents().get(0);
				exporter.export(outputStream, root, options);
				if (!getContents().contains(root)) {
					// set the root here again
					getContents().add(0, root);
				}
				return;
			}
		}


		/*
		 * Store using the default file : ertd
		 */
        super.doSave(outputStream, options);
	}
	
		
	public void setLoadHandler(ErrorHandler newHandler) {
//		handler = newHandler;
	}
	
	public void doSuperLoad(InputStream inputStream, Map<?,?> options) throws IOException {
		super.doLoad(inputStream, options);
	}

	public void doSuperSave(OutputStream outputStream, Map<?,?> options) throws IOException {
		super.doSave(outputStream, options);
	}

}
