package com.eu.evidence.rtdruid.internal.modules.oil.reader;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

import com.eu.evidence.rtdruid.desk.RtdruidLog;

/**
 * This class is used to collect oil libraries, using the Extension Point
 * 
 * 
 * @author Nicola Serreli
 * 
 */
public class OilLibsFactory {

	/** All directories. */
	private List<String> directories;

	/**
	 * Builds a new Factory. The list is loaded lazily.
	 */
	public OilLibsFactory() {
		// do nothing
	}

	/**
	 * Returns the list of OIL Library directories from extension point. The
	 * list is loaded only the first time.
	 * 
	 * @return the list of found directories.
	 */
	public List<String> getDirectories() {
		if (directories == null) {
			directories = getAllInputStream();
		}

		return directories;
	}

	/**
	 * This function collects OIL library directories from extension point.
	 * 
	 * @return the list of found directories
	 */
	private static List<String> getAllInputStream() {
		List<String> answer = new ArrayList<String>();
		IConfigurationElement[] configs = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(
						"com.eu.evidence.rtdruid.oil.core.oil_library_path");

		for (IConfigurationElement config : configs) {
			if ("library_path".equals(config.getName())) {
				try {
					String path = config.getAttribute("path");

					if (path == null) {
						continue; // nothing to do
					}

					Bundle bundle = Platform.getBundle(config.getContributor()
							.getName());
					assert (bundle != null);

					URL url = bundle.getResource(path);
					if (url == null) {
						RtdruidLog.log("Oil library not found " + path);
						continue; // next
					}

					URL loc = null;
					try {
						loc = FileLocator.toFileURL(url);
					} catch (IOException e) {
						RtdruidLog
								.log("Cannot open the Oil library " + path, e);
						continue; // next
					}

					String file = loc.getFile();
					if (file != null) {

						File f = new File(file);
						if (f.exists() && f.canRead() && f.isDirectory()) {
							if (!answer.contains(file)) {
								answer.add(file);
							}
						} else {
							RtdruidLog
									.log("Cannot find or read the specified Oil library directory "
											+ file);
							continue; // next
						}
					}
				} catch (Exception e) {
					RtdruidLog.log("Unable to get oil library directory.", e);
				}
			}
		}

		return answer;
	}
}
