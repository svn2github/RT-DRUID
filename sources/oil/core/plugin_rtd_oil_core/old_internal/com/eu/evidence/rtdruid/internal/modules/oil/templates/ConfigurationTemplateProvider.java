package com.eu.evidence.rtdruid.internal.modules.oil.templates;

import java.io.File;
import java.util.ArrayList;

import com.eu.evidence.rtdruid.modules.oil.codewriter.options.PreferenceStorage;
import com.eu.evidence.templates.interfaces.ITemplatePathProvider;


public class ConfigurationTemplateProvider implements ITemplatePathProvider {
	
	private final static ArrayList<String> paths = checkConfigurationOptions();
	private static final String CONFIG_FILE___TEMPLATE_LOCATION = "templates_path";
	
	private static ArrayList<String> checkConfigurationOptions() {
		ArrayList<String> answer = new ArrayList<String>();
		
		PreferenceStorage prefs = PreferenceStorage.getCommonIstance();
		String base = prefs.getValue(CONFIG_FILE___TEMPLATE_LOCATION);
		String[] elems = base != null ? base.split(File.pathSeparator) : new String[0];
		for (String elem: elems) {
			
			File f = new File(elem);
			if (f.exists() && f.isDirectory() && f.canRead()) {
				answer.add(elem);
			}
		}
		
		return answer;
	}


	public ConfigurationTemplateProvider() {
	}

	@Override
	public String[] getPaths() {
		return (String[]) paths.toArray(new String[paths.size()]);
	}

	@Override
	public boolean isDynamic() {
		return true;
	}
	
	@Override
	public int priority() {
		return 10;
	}
}
