package com.eu.evidence.rtdruid.epackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.common.util.URI;

/**
 * This class returns the EPackage stored inside a file in the filesystem.
 */
class FileSystemEcoreEpackageProvider extends EcoreEpackageProvider {

		final String path;

		/**
		 * 
		 * @param useBasePath if true, the package of this class is used as prefix of the path
		 * @param path the path of the ecore file (inside a java plugin)
		 */
		public FileSystemEcoreEpackageProvider(String path) {
			this.path = path;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.eu.evidence.rtdruid.epackage.EcoreEpackageProvider#getInput()
		 */
		@Override
		protected InputStream getInput() throws IOException {
			File f = new File(path);
			if (!f.exists() || !f.canRead() || !f.isFile()) {
				throw new IOException("Cannot read " + path + " file");
			}
			return new FileInputStream(f);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.eu.evidence.rtdruid.epackage.EcoreEpackageProvider#getUri()
		 */
		@Override
		protected URI getUri() {
			return URI.createURI(path);
		}
	}