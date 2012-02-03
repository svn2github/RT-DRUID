package com.eu.evidence.rtdruid.internal.modules.project.templates;

import java.io.File;

public class PluginTemplateItem implements ITemplatesFolder {
		/** The ID of the bundle that contains this set of templates */
		private final String bundleID;
		/** The path inside the file-system of current bundle */
		private final String bundlePath;
		/** The path of the templates' root inside the current bundle */
		private final String root;

		public PluginTemplateItem(String bundleID, String bundlePath, String rootPath) {
			this.bundleID = bundleID;
			this.bundlePath = bundlePath;
			this.root = rootPath;
		}
		
		public String getPath() {
			return bundlePath + File.separatorChar + root;
		}
		
		@Override
		public String toString() {
			return "Bundle " + bundleID + " [" + getPath()+"]";
		}
	}
