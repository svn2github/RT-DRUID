package com.eu.evidence.rtdruid.modules.oil.implementation;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;

import com.eu.evidence.rtdruid.internal.modules.oil.implementation.OilEcoreCreatorImpl;
import com.eu.evidence.rtdruid.modules.oil.interfaces.IOilImplementation;

public abstract class OilEcoreCreator {

	protected OilEcoreCreator() {
		super();
	}

	public static OilEcoreCreator getCreator(IOilImplementation iimpl) {
		return new OilEcoreCreatorImpl(iimpl);
	}

	public static Resource save(EPackage ePackage, String file_name) {
		ResourceSet metaResourceSet = new ResourceSetImpl();
	
		/*
		 * Register XML Factory implementation to handle .ecore files
		 */
		metaResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("ecore", new XMLResourceFactoryImpl());
	
		/*
		 * Create empty resource with the given URI
		 */
		Resource metaResource = metaResourceSet.createResource(URI
				.createURI(file_name));
	
		/*
		 * Add bookStoreEPackage to contents list of the resource
		 */
		metaResource.getContents().add(ePackage);
	
		try {
			/*
			 * Save the resource
			 */
			metaResource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return metaResource;
	}

	public abstract EPackage buildPackage();
}