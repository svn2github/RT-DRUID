/*
 * Created on Jun 1, 2004
 */
package com.eu.evidence.rtdruid.vartree.data.init;


import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory;

import com.eu.evidence.rtdruid.internal.vartree.data.init.RTDResourceManager;
import com.eu.evidence.rtdruid.internal.vartree.data.init.RTDResourceManagerFactory;


/**
 * A little factory to create new {@see MyXMIReaderImpl MyXMIReaderImpl}
 * resource
 * 
 * @author Nicola Serreli
 */
public class RTD_XMI_Factory implements Factory {
	
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
}