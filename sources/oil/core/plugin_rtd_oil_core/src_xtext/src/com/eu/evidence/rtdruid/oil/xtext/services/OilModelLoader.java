/**
 * 27/giu/2012
 */
package com.eu.evidence.rtdruid.oil.xtext.services;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.eu.evidence.rtdruid.oil.xtext.OilStandaloneSetup;
import com.eu.evidence.rtdruid.oil.xtext.model.OilFile;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class OilModelLoader {

	public final static OilModelLoader instance = new OilModelLoader();
	static {
		OilStandaloneSetup.doSetup();
	}

	public OilFile load(URI path, HashMap<?, ?> options) throws IOException {
		ResourceSet resourceSet = new ResourceSetImpl();
//		Resource resource = Resource.Factory.Registry.INSTANCE.getFactory(path, "oil").createResource(path);

		Resource resource = resourceSet.createResource(path);
		resourceSet.getResources().add(resource);
		resource.load(options);
		return (OilFile) (resource.getContents().isEmpty() ? null : resource.getContents().get(0));
	}


	public OilFile load(URI path, InputStream in, HashMap<?, ?> options) throws IOException {
		if (path == null) {
			path = URI.createURI("undefined_file.oil");
		}
		ResourceSet resourceSet = new ResourceSetImpl();
//		Resource resource = Resource.Factory.Registry.INSTANCE.getFactory(path, "oil").createResource(path);

		Resource resource = resourceSet.createResource(path);
		resourceSet.getResources().add(resource);
//		resource.load(options);
		resource.load(in, options);
		return (OilFile) (resource.getContents().isEmpty() ? null : resource.getContents().get(0));
	}

	public OilFile load(URI path, String in, HashMap<?, ?> options) throws IOException {
		return load(path, new ByteArrayInputStream(in.getBytes()), null);
	}

	public OilFile load(String in) throws IOException {
		return load(null, in, null);
	}

}
