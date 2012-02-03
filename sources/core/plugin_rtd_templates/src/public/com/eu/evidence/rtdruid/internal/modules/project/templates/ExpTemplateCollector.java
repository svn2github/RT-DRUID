package com.eu.evidence.rtdruid.internal.modules.project.templates;

import java.io.File;
import java.util.ArrayList;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

import com.eu.evidence.templates.Activator;
import com.eu.evidence.templates.interfaces.ITemplatePathProvider;

/**
 * This class loads all available templates from Extension points.
 * 
 * @author Nicola Serreli
 */

public class ExpTemplateCollector {

	private static final Object RTD_TEMPLATE_ENV_VARIABLE_ID = "RTDRUID_TEMPLATES_PATH";
	private static ArrayList<ITemplatesFolder> templatesArray = null;
	private static ArrayList<ITemplatePathProvider> dynamicProviders = null;

	static {
		dynamicProviders = new ArrayList<ITemplatePathProvider>();
		templatesArray = parseAllExtensions();
	}
	
	private static ArrayList<ITemplatesFolder> parseAllExtensions() {
		ArrayList<ITemplatesFolder> answer = new ArrayList<ITemplatesFolder>();
		answer.addAll(parseTemplates());
		answer.addAll(parseTemplatePathProviders());
		answer.addAll(parseEnvironment());
		return answer;
	}
	
	private static ArrayList<ITemplatesFolder> parseEnvironment() {
		ArrayList<ITemplatesFolder> answer = new ArrayList<ITemplatesFolder>();
		String paths = System.getenv().containsKey(RTD_TEMPLATE_ENV_VARIABLE_ID) ? System.getenv().get(RTD_TEMPLATE_ENV_VARIABLE_ID) : "";
		
		String[] elems = paths != null ? paths.split(File.pathSeparator) : new String[0];
		for (String elem: elems) {
			
			File f = new File(elem);
			if (f.exists() && f.isDirectory() && f.canRead()) {
				answer.add(new FileSystemTemplateItem("env", "environment", elem));
			}
		}
		
		return answer;

	}
	
	private static ArrayList<ITemplatesFolder> parseTemplates() {
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
		return answer;
	}

	private static ArrayList<ITemplatesFolder> parseTemplatePathProviders() {
		ArrayList<ITemplatesFolder> answer = new ArrayList<ITemplatesFolder>();
		
		IConfigurationElement[] config = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(
						"com.eu.evidence.templates.core.template");
		assert (config != null);
		int l = config.length;

		for (int i = 0; i < l; i++)
			if ("templatePathProvider".equals(config[i].getName())) {
				try {
					Object provider = config[i].createExecutableExtension("provider");
					
					if (provider == null || !(provider instanceof ITemplatePathProvider)) {
						continue;
					}
					ITemplatePathProvider tpp = (ITemplatePathProvider) provider;
					if (tpp.isDynamic()) {
						dynamicProviders.add(tpp);
					} else {
						getPaths(tpp, answer);
					}
					
				} catch (Exception e) {
					Activator.log("Unable to get the specified template provider:\n " + config[i].getAttribute("provider"),
							e);
				}
			}
		return answer;
	}
	
	private static void getPaths(ITemplatePathProvider provider, ArrayList<ITemplatesFolder> answer) {
		String[] paths = provider.getPaths();
		if (paths == null) {
			return;
		}
		String name = provider.getClass().getName();
		
		for (String path: paths) {
			if (path != null) {
				File f = new File(path);
				if (f.exists() && f.canRead()) {
					answer.add(new FileSystemTemplateItem("", name, path));
				}
			}
		}
		
	}

	
	/** Returns all available paths of templates. */
	public static ITemplatesFolder[] getTemplates() {
		ArrayList<ITemplatesFolder> temp = new ArrayList<ITemplatesFolder>();
		for (ITemplatePathProvider tpp: dynamicProviders) {
			getPaths(tpp, temp);
		}
		if (temp.size() == 0) {
			temp = templatesArray;
		} else {
			temp.addAll(templatesArray);
		}
		return temp.toArray(new ITemplatesFolder[templatesArray.size()]) ;
	}

}
