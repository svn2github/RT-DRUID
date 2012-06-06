package com.eu.evidence.rtdruid.internal.modules.project.templates;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

import com.eu.evidence.templates.Activator;
import com.eu.evidence.templates.interfaces.ITemplatePathProvider;

class PluginsTemplatePathProvider implements ITemplatePathProvider {

	final List<ITemplatesFolder> folders;
	
	public PluginsTemplatePathProvider() {
		ArrayList<ITemplatesFolder> answer = new ArrayList<ITemplatesFolder>();
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
							null) == null) {
						continue;
					}
					File f = FileLocator.getBundleFile(bundle);
					String bundlePath = null;
					if (f != null) {
						bundlePath = f.getAbsolutePath();
					}
					answer.add(new PluginTemplateItem(bundleName, bundlePath, fileName));
					
				} catch (Exception e) {
					Activator.log("Unable to get the specified template directory:\n bundle= " + 
							bundleName + "\n dir= " + fileName,
							e);
				}
			}

		folders = Collections.unmodifiableList(answer);
	}
	
	@Override
	public int priority() {
		return PLUGINS_PRIORITY;
	}

	@Override
	public boolean isDynamic() {
		return false;
	}

	@Override
	public String[] getPaths() {
		return null;
	}

	public List<ITemplatesFolder> getTemplatesFolder() {
		return folders;
	}
}
