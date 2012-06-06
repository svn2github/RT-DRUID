package com.eu.evidence.rtdruid.internal.modules.oil.templates;

import java.io.File;
import java.util.ArrayList;

import com.eu.evidence.templates.interfaces.ITemplatePathProvider;


public class DynamicTemplateProvider implements ITemplatePathProvider {
	
	private final static ArrayList<String> paths = new ArrayList<String>();

	public static void addPath(String path) {
		String[] elems = path != null ? path.split(File.pathSeparator) : new String[0];
		for (String elem: elems) {
			
			File f = new File(elem);
			if (f.exists() && f.isDirectory() && f.canRead() && !paths.contains(elem)) {
				paths.add(elem);
			}
		}
	}
	

	public DynamicTemplateProvider() {
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
		return 100;
	}
}
