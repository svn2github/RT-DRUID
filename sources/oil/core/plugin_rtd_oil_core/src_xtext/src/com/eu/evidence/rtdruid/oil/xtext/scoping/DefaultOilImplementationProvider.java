/**
 * 24/giu/2012
 */
package com.eu.evidence.rtdruid.oil.xtext.scoping;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.internal.modules.oil.implementation.OilImplCollector;
import com.eu.evidence.rtdruid.internal.modules.oil.implementation.OilImplCollector.InputNamedStream;
import com.eu.evidence.rtdruid.oil.xtext.OilStandaloneSetup;
import com.eu.evidence.rtdruid.oil.xtext.model.OilFile;
import com.eu.evidence.rtdruid.oil.xtext.model.OilImplementation;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */

public class DefaultOilImplementationProvider {

	private List<OilImplementation> oilImplementations = new ArrayList<OilImplementation>();
	
	public final static DefaultOilImplementationProvider instance = initDefaultValues();
	static {
		OilStandaloneSetup.doSetup();
	}
	
	public static DefaultOilImplementationProvider initDefaultValues() {
		DefaultOilImplementationProvider answer = new DefaultOilImplementationProvider();
		
		for (InputNamedStream path: OilImplCollector.getAllInputStream()) {
			try {
				answer.load(URI.createURI(FileLocator.find(path.getBundle(), new Path(path.getName()), null).toURI().toString()), path.getStream(), null);
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return answer;
	}
	
	
	public void load(URI path, InputStream in, HashMap<?, ?> options) {
		ResourceSet resourceSet = new ResourceSetImpl();
//		Resource resource = Resource.Factory.Registry.INSTANCE.getFactory(path, "oil").createResource(path);

		Resource resource = resourceSet.createResource(path);
		resourceSet.getResources().add(resource);
		try {
			resource.load(options);
			//resource.load(in, options);
			final OilFile root = (OilFile) (resource.getContents().isEmpty() ? null : resource.getContents().get(0));
			OilImplementation impl = root.getImplementation();
			if (impl != null) {
				oilImplementations.add(impl);
			}
		} catch (IOException e) {
			RtdruidLog.log(e);
		}
	}
	
	public List<OilImplementation> getImplementations() {
		return oilImplementations;
	}
	
	
	
}
