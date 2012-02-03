/**
 * 14/nov/2011
 */
package com.eu.evidence.rtdruid.epackage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

/**
 * This class provides a EPackage loaded from an ecore file
 * 
 * @author Nicola Serreli
 * @since 2.0
 * 
 */
public abstract class EcoreEpackageProvider implements IEPackageProvider {

	/**
	 * This method ask the URI of this epackage
	 * 
	 * @return the URI related to the input stream
	 */
	protected abstract URI getUri();

	/**
	 * This method ask to load the ecore file
	 * 
	 * @return the input stream
	 */
	protected abstract InputStream getInput() throws IOException;

	/**
	 * This method return the option map used to load the ecore file
	 * 
	 * @return the input option map
	 */
	protected Map<?, ?> getInputMap() {
		return Collections.EMPTY_MAP;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.eu.evidence.rtdruid.epackage.IEPackageProvider#fill(org.eclipse.emf
	 * .ecore.EPackage)
	 */
	@Override
	public EPackage get() throws RTDEPackageBuildException {
		return doLoad();
	}

	protected EPackage doLoad() throws RTDEPackageBuildException {
		// Create a resource where load the EPackage
		ResourceSet resourceSet = new ResourceSetImpl();		
		EObject content = null;
		try {
			final Resource modelResource = createResource(getUri(), resourceSet);
			modelResource.load(getInput(), getInputMap());
			if (modelResource.getContents().size() > 0) {
				content = modelResource.getContents().get(0);
			}
			
		} catch (IOException e) {
			throw new RTDEPackageBuildException(e);
		}
		if (content instanceof EPackage) {
			// everything ok
			return (EPackage) content;
		}
		
		throw new RTDEPackageBuildException("Cannot load an EPackage form " + getUri());
	}

	/**
	 * This will create a {@link Resource} given the model extension it is intended for and a ResourceSet.
	 * 
	 * @param modelURI
	 *            {@link org.eclipse.emf.common.util.URI URI} where the model is stored.
	 * @param resourceSet
	 *            The {@link ResourceSet} to load the model in.
	 * @return The {@link Resource} given the model extension it is intended for.
	 */
	public static Resource createResource(URI modelURI, ResourceSet resourceSet) {
		String fileExtension = modelURI.fileExtension();
		if (fileExtension == null || fileExtension.length() == 0) {
			fileExtension = Resource.Factory.Registry.DEFAULT_EXTENSION;
		}

		// First search the resource set for our resource factory
		Resource.Factory.Registry registry = resourceSet.getResourceFactoryRegistry();
		Object resourceFactory = registry.getExtensionToFactoryMap().get(fileExtension);
		if (resourceFactory == null) {
			// then the global registry
			registry = Resource.Factory.Registry.INSTANCE;
			resourceFactory = registry.getExtensionToFactoryMap().get(fileExtension);
			if (resourceFactory != null) {
				resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
						.put(fileExtension, resourceFactory);
			} else {
				resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
						.put(fileExtension, new XMIResourceFactoryImpl());
			}
		}

		return resourceSet.createResource(modelURI);
	}
}
