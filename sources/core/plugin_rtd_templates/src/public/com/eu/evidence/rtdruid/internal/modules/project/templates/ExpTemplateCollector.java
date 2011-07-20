package com.eu.evidence.rtdruid.internal.modules.project.templates;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

import com.eu.evidence.templates.Activator;

/**
 * This class loads all available templates from Extension points.
 * 
 * @author Nicola Serreli
 */

public class ExpTemplateCollector {

	private static ArrayList<ExtTemplItem> templatesArray = parseAllExtensions();

	@SuppressWarnings("unchecked")
	private static ArrayList<ExtTemplItem> parseAllExtensions() {
		ArrayList<ExtTemplItem> answer = new ArrayList<ExtTemplItem>();
		
		IConfigurationElement[] config = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(
						"com.eu.evidence.templates.core.template");
		assert (config != null);
		int l = config.length;

		for (int i = 0; i < l; i++)
			if ("template".equals(config[i].getName())) {
				String bundleName = "";
				String fileName = "";
				try {
					fileName = config[i].getAttribute("dir");
					
					if (fileName == null) {
						continue;
					}

					bundleName = config[i].getContributor().getName();
					Bundle bundle = Platform.getBundle(bundleName);
					assert (bundle != null);
					
					if (FileLocator.find(bundle, new Path(fileName),
							new HashMap()) == null) {
						continue;
					}
					File f = FileLocator.getBundleFile(bundle);
					String bundlePath = null;
					if (f != null) {
						bundlePath = f.getAbsolutePath();
					}
					answer.add(new ExtTemplItem(bundleName, bundlePath, fileName));
					
				} catch (Exception e) {
					Activator.log("Unable to get the specified template directory:\n bundle= " + 
							bundleName + "\n dir= " + fileName,
							e);
				}
			}
		return answer;
	}

	/** Returns all available paths of templates. */
	public static ExtTemplItem[] getTemplates() {
		return templatesArray.toArray(new ExtTemplItem[templatesArray.size()]) ;
	}

}
