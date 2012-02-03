/*
 * Created on Jun 1, 2004
 */
package com.eu.evidence.rtdruid.io;


import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory;

import com.eu.evidence.rtdruid.internal.io.RTDResourceManager;
import com.eu.evidence.rtdruid.internal.io.RTDResourceManagerFactory;


/**
 * A little factory to create new {@see MyXMIReaderImpl MyXMIReaderImpl}
 * resource
 * 
 * @author Nicola Serreli
 */
public class RTD_XMI_Factory implements Factory,  Factory.Descriptor {
	
	public static final RTD_XMI_Factory instance = new RTD_XMI_Factory(); 
	
	public static void registrFactory() {
		
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.ecore.resource.Resource.Factory#createResource(org.eclipse.emf.common.util.URI)
	 */
	public Resource createResource(URI uri) {
		return new RTDResourceManager(uri); 
	}
	public Resource createResource() {
		return new RTDResourceManager(); 
	}
	
	/**
	 * @return all supported export types (or an empty array if none)
	 */
	public static String[] getAllImportTypes() {
		String[] tmp = RTDResourceManagerFactory.getInstance().getAllImportTypes();
		String[] answer = new String[tmp.length +1];
		answer[0] = "ertd";
		System.arraycopy(tmp, 0, answer, 1, tmp.length);
		return answer;
	}
	
	/**
	 * @return all supported export types (or an empty array if none)
	 */
	public static String[] getAllExportTypes() {
		String[] tmp = RTDResourceManagerFactory.getInstance().getAllExportTypes();
		String[] answer = new String[tmp.length +1];
		answer[0] = "ertd";
		System.arraycopy(tmp, 0, answer, 1, tmp.length);
		return answer;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.ecore.resource.Resource.Factory.Descriptor#createFactory()
	 */
	@Override
	public Factory createFactory() {
		return instance;
	}
}