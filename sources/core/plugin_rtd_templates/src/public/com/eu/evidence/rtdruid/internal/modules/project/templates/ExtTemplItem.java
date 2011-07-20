package com.eu.evidence.rtdruid.internal.modules.project.templates;

public class ExtTemplItem {
		/** The ID of the bundle that contains this set of templates */
		final String bundleID;
		/** The path inside the file-system of current bundle */
		final String bundlePath;
		/** The path of the templates' root inside the current bundle */
		final String root;

		public ExtTemplItem(String bundleID, String bundlePath, String rootPath) {
			this.bundleID = bundleID;
			this.bundlePath = bundlePath;
			this.root = rootPath;
		}
	}
