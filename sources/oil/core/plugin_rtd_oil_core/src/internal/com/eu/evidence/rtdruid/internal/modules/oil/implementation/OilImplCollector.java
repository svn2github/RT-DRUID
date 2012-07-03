package com.eu.evidence.rtdruid.internal.modules.oil.implementation;

import java.io.InputStream;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;
import org.w3c.dom.Document;

import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.internal.modules.oil.reader.OilInfo;
import com.eu.evidence.rtdruid.internal.modules.oil.reader.OilParser;
import com.eu.evidence.rtdruid.modules.oil.implementation.IOilImplID;
import com.eu.evidence.rtdruid.modules.oil.implementation.IOilImplementation;
import com.eu.evidence.rtdruid.modules.oil.transform.OilTransformFactory;

/**
 * This class loads all available oil implementations.
 * 
 * @author Michele Pes
 */

public class OilImplCollector {
	
	private static OilImplementation[] oilImplementationArray;
	
	public static class InputNamedStream {
		private final String name;
		private final Bundle bundle;
		private final InputStream stream;
		public InputNamedStream(String n, Bundle bundle, InputStream in) {
			this.name = n;
			this.stream = in;
			this.bundle = bundle;
		}
		
		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}
		
		/**
		 * @return the stream
		 */
		public InputStream getStream() {
			return stream;
		}
		
		/**
		 * @return the bundle
		 */
		public Bundle getBundle() {
			return bundle;
		}
		
	}

	static { // load oil implementations from disk the first time
		InputNamedStream[] in = getAllInputStream();
		int v = 0, l = in.length;
		OilImplementation[] t = new OilImplementation[l];
		for (int i = 0; i < l; i++) {
			t[v] = (OilImplementation)getOilImplementation(in[i]);
			if (t[v] != null)
				v++;
		}
		oilImplementationArray = new OilImplementation[v];
		while (--v > -1)
			oilImplementationArray[v] = t[v];
	}

	public static InputNamedStream[] getAllInputStream() {
		InputNamedStream[] x = null;
			IConfigurationElement[] config = Platform.getExtensionRegistry()
					.getConfigurationElementsFor("com.eu.evidence.rtdruid.oil.core.oil_implementation");
			assert(config != null);
			int l = config.length;
			x = new InputNamedStream[l];
			for (int i = 0; i < l; i++)
				if ("implementation_file".equals(config[i].getName())) {
					try {
						String fileName = config[i].getAttribute("path");
						assert(fileName != null);
						Bundle bundle = Platform.getBundle(config[i].getContributor().getName());
						assert(bundle != null);
						x[i] = new InputNamedStream(fileName, bundle, FileLocator.openStream(bundle, new Path(fileName), false));
					}
					catch (Throwable e) {
						RtdruidLog.log(OilImplCollector.class.getName() + ": " +
			            		"Unable to get oil implementation InputStream.", e);
					}
				}
		return x;
	}
	
	private static OilImplementation getOilImplementation(InputNamedStream in) {
		if (in == null || in.stream == null)
			return null;
		OilParser op = new OilParser(in.stream);
		assert(op != null);
		OilInfo parsed = null;
		try { parsed = op.start(); }
		catch (Throwable e) {
			RtdruidLog.log(OilImplCollector.class.getName() + ": " +
            		"Unable to parse oil file ("+in.name+").", e);
			return null;
		}
		IOilImplID oiid = OilTransformFactory.INSTANCE.getOilId(parsed.getName());
		assert(oiid != null);
		Document data = parsed.getImpl();
		assert(data != null);
		OilImplementation out = new OilImplementation(oiid, data);
		return out;
	}

	/** Returns all available and valid OilImplementation. */
	public static IOilImplementation[] getAllOilImplementation() {
		int l = oilImplementationArray.length;
		OilImplementation[] out = new OilImplementation[l];
		for (int i = 0; i < l; i++)
			out[i] = (OilImplementation)oilImplementationArray[i].clone();
		return out;
	}

}
