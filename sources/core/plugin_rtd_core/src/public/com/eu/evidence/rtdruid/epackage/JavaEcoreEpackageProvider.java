package com.eu.evidence.rtdruid.epackage;

import java.io.InputStream;

import org.eclipse.emf.common.util.URI;

/**
 * This class returns the EPackage stored inside a file in the a JarFile using
 * the Java ClassLoader. Note that the classloader should be related to the
 * JarFile that contains the ecore file.
 * 
 * This class is not able to get data from a generic file in the filesystem.
 */
class JavaEcoreEpackageProvider extends EcoreEpackageProvider {

	final String path;
	final ClassLoader loader;

	/**
	 * Build a provider based on the path of ecore file inside a java jar file.
	 * It is expected to be something like
	 * <code> "/" + MyClass.class.getPackage().getName().replace('.', '/') + "/" + file_name</code>
	 * 
	 * This method allows to set the class classLoader that should be used to
	 * load the required file.
	 * 
	 * @param path
	 *            the path of the ecore file (inside a java plugin)
	 * @param loader
	 *            the classLoader that should be used to get the ecore stream
	 */
	public JavaEcoreEpackageProvider(String path, ClassLoader loader) {
		this.path = path;
		this.loader = loader;
	}

	/**
	 * Build a provider based on the path of ecore file inside a java jar file.
	 * It is expected to be something like
	 * <code> "/" + MyClass.class.getPackage().getName().replace('.', '/') + "/" + file_name</code>
	 * 
	 * This method allows to set the class classLoader that should be used to
	 * load the required file and uses the provided loader package name as
	 * prefix of required ecore file.
	 * 
	 * @param fileName
	 *            the name of the ecore file inside the package of the specified
	 *            class
	 * @param loader
	 *            this class is used to get the classLoader that should be used
	 *            to get the ecore stream and the packaged where the file can be
	 *            found
	 */
	public JavaEcoreEpackageProvider(String fileName, Class<?> loader) {
		this("/" + loader.getPackage().getName().replace('.', '/') + "/"
				+ fileName, loader.getClassLoader());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eu.evidence.rtdruid.epackage.EcoreEpackageProvider#getInput()
	 */
	@Override
	protected InputStream getInput() {
		return loader.getResourceAsStream(path);
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