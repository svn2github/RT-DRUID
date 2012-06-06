package com.eu.evidence.rtdruid.internal.modules.project.templates;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

import com.eu.evidence.templates.Activator;
import com.eu.evidence.templates.interfaces.ITemplatePathProvider;

/**
 * This class loads all available templates from Extension points.
 * 
 * @author Nicola Serreli
 */

public class ExpTemplateCollector {

	private static Map<ITemplatePathProvider, List<ITemplatesFolder>> templatesArray = null;
	private static List<ITemplatePathProvider> providersOrder = null;

	static {
		templatesArray = parseAllExtensions();
		providersOrder = new ArrayList<ITemplatePathProvider>(templatesArray.keySet());
		
		Collections.sort(providersOrder, new Comparator<ITemplatePathProvider>() {
			@Override
			public int compare(ITemplatePathProvider o1,
					ITemplatePathProvider o2) {
				return o1.priority() - o2.priority();
			}
		});
	}
	
	// ------------- INIT ALL -----------------
	/**
	 * Searches all templates folders 
	 * 
	 * @return the list of available templateFolders
	 */
	private static  Map<ITemplatePathProvider, List<ITemplatesFolder>> parseAllExtensions() {
		HashMap<ITemplatePathProvider, List<ITemplatesFolder>> answer = new LinkedHashMap<ITemplatePathProvider, List<ITemplatesFolder>>();
		parseEnvironment(answer);
		parseTemplatePathProviders(answer);
		parseTemplates(answer);
		return answer;
	}
	
	/**
	 * Check if the environment contains TEMPLATE_PATH variable. If true, stores
	 * them in the provided map. If the variable does not exist or if there is
	 * not any readable folder, the map is untouched.
	 * 
	 * @param answer
	 *            where store the connection between the TemplatePathProvider
	 *            and all TemplatesFolder related to the provider
	 */
	private static void parseEnvironment(Map<ITemplatePathProvider, List<ITemplatesFolder>> answer) {
		ITemplatePathProvider tpp = new EnvironmentTemplatePathProvider();
		ArrayList<ITemplatesFolder> folders = new ArrayList<ITemplatesFolder>();
		getPaths(tpp, folders);
		if (folders.size()>0) {
			answer.put(tpp, folders);
		}
	}
	
	/**
	 * Check if any plugin contains some readable template folder. If true, this method stores
	 * them in the provided map, otherwise the map is untouched.
	 * 
	 * @param answer
	 *            where store the connection between the TemplatePathProvider
	 *            and all TemplatesFolder related to the provider
	 */
	private static void parseTemplates(Map<ITemplatePathProvider, List<ITemplatesFolder>> answer) {
		PluginsTemplatePathProvider tpp = new PluginsTemplatePathProvider();
		List<ITemplatesFolder> folders = tpp.getTemplatesFolder();
		if (folders.size()>0) {
			answer.put(tpp, folders);
		}
		
	}

	/**
	 * Check if any plugin contains TemplatePathProvider with one or more template folder. If true, this method stores
	 * them in the provided map, otherwise the map is untouched.
	 * Dynamic providers are stored without check template folders (that will be checked when templates are required).
	 * 
	 * @param answer
	 *            where store the connection between the TemplatePathProvider
	 *            and all TemplatesFolder related to the provider
	 */
	private static void parseTemplatePathProviders(Map<ITemplatePathProvider, List<ITemplatesFolder>> answer) {
		
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
						answer.put(tpp, null);
						
					} else {
						ArrayList<ITemplatesFolder> folders = new ArrayList<ITemplatesFolder>();
						getPaths(tpp, folders);
						if (folders.size()>0) {
							answer.put(tpp, folders);
						}
					}
					
					
				} catch (Exception e) {
					Activator.log("Unable to get the specified template provider:\n " + config[i].getAttribute("provider"),
							e);
				}
			}
	}
	
	
	
	/**
	 * This is an Utility function to transform provider's path in FileSystemTemplateItems
	 * 
	 * @param provider the path provider
	 * @param answer where store all FileSystemTemplateItems
	 */
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

	// ----------------- Retrive paths ---------------------------
	
	
	/** Returns all available paths of templates. */
	public static ITemplatesFolder[] getTemplates() {
		ArrayList<ITemplatesFolder> temp = new ArrayList<ITemplatesFolder>();
		
		for (ITemplatePathProvider tpp: providersOrder) {
			if (tpp.isDynamic()) {
				getPaths(tpp, temp);
			} else {
				temp.addAll(templatesArray.get(tpp));
			}
		}
		return temp.toArray(new ITemplatesFolder[temp.size()]) ;
	}

}
