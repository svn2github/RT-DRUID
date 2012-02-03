package com.eu.evidence.rtdruid.internal.modules.project.templates;


public class FileSystemTemplateItem implements ITemplatesFolder {
		/** The ID of the bundle that contains this set of templates */
		private final String bundleID;
		/** The name of the class that provides these paths */
		private final String provider;
		/** The path of the templates' root inside the filesystem */
		private final String root;

		public FileSystemTemplateItem(String bundleID, String provider, String rootPath) {
			this.bundleID = bundleID;
			this.provider = provider;
			this.root = rootPath;
		}
		
		public String getPath() {
			return root;
		}
		
		@Override
		public String toString() {
			return "Bundle " + bundleID + " - provider " + provider + "[" + getPath()+"]";
		}
	}
