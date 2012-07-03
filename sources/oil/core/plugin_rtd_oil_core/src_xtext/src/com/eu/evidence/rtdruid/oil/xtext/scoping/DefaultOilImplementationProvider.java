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

import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.internal.modules.oil.implementation.OilImplCollector;
import com.eu.evidence.rtdruid.internal.modules.oil.implementation.OilImplCollector.InputNamedStream;
import com.eu.evidence.rtdruid.oil.xtext.model.OilFile;
import com.eu.evidence.rtdruid.oil.xtext.model.OilImplementation;
import com.eu.evidence.rtdruid.oil.xtext.services.OilModelLoader;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */

public class DefaultOilImplementationProvider {

	private List<OilImplementation> oilImplementations = new ArrayList<OilImplementation>();
	
	public final static DefaultOilImplementationProvider instance = initDefaultValues();
	
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
	
	
	protected void load(URI path, InputStream in, HashMap<?, ?> options) {
		try {
			final OilFile root = OilModelLoader.instance.load(path, in, options);
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
