/**
 * 14/nov/2011
 */
package com.eu.evidence.rtdruid.internal.epackage;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.osgi.framework.Bundle;

import com.eu.evidence.rtdruid.Rtd_corePlugin;
import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.epackage.EPackageFactory;
import com.eu.evidence.rtdruid.epackage.EPackageUtility;
import com.eu.evidence.rtdruid.epackage.EcoreEpackageProvider;
import com.eu.evidence.rtdruid.epackage.IEPackageMerge;
import com.eu.evidence.rtdruid.epackage.IEPackageProvider;
import com.eu.evidence.rtdruid.epackage.RTDEPackageBuildException;

/**
 * 
 * @author Nicola Serreli
 * @since 2.0
 * 
 */
public class EPackageFactoryImpl extends EPackageFactory {

	private static final String LOADER = "loader";
	private static final String LOADER_CLASS = "class";
	private static final String PLUGIN_FILE = "ecoreFile";
	private static final String PLUGIN_FILE_NAME = "file";
	private static final String PKG_ID = "pkg_id";
	private static final String AUTO_CONTRIBUTE = "auto_contribute";

	protected static final String PLUGIN_ID = Rtd_corePlugin.PLUGIN_ID;
	public static final String EXTENSION_POINT = "rtdruidEPackages";
	
	
	
	/**
	 * This class stores all aready merged configuration of EPackage, in order
	 * to provide the same instance of EPackage instead of rebuild a new one.
	 * This is important if you want to allow interactions among models build
	 * from different "call" of EPackageFactory.
	 * 
	 * @author Nicola Serreli
	 * @since 2.0
	 * 
	 */
	private static class EPackageMergedCache {
		
		/**
		 * The cache
		 */
		private Map<Set<String>, EPackage> cache;
		
		/**
		 * Default constructor
		 */
		EPackageMergedCache() {
			cache = new LinkedHashMap<Set<String>, EPackage>();
		}
		
		/**
		 * Looks in the cache for an EPackage produced by the given list of
		 * {@link IEPackageFactoryElement}
		 * 
		 * @param pkgProviders
		 *            all contributors of the EPackage
		 * @return the EPackage related to the given list of contributors, or
		 *         null if not found.
		 * @throws RTDEPackageBuildException 
		 */
		EPackage getEpackage(IEPackageFactoryElement ... pkgProviders) throws RTDEPackageBuildException {
			for (Entry<Set<String>, EPackage> entry : cache.entrySet()) {
				if (match(entry.getKey(), pkgProviders)) {
					return entry.getValue();
				}
			}
			
			// not found !!
			IEPackageMerge merge = EPackageUtility.instance.getPackageMerge();
			merge.addEPackage(EcoreFactory.eINSTANCE.createEPackage());
			Set<String> key = new HashSet<String>();

			for (IEPackageFactoryElement pkgProvider : pkgProviders) {
				key.add(pkgProvider.getId());
				try {
					merge.addEPackage(pkgProvider.getProvider(false).get());
				} catch (EPackageProviderException e) {
					RtdruidLog.log(e);
				}
			}

			EPackage answer = merge.getResult();
			cache.put(key, answer);
			
			return answer;
		}
		
		
		/**
		 * Check if a set and an array contain the same set of elements (does
		 * not mater the order)
		 * 
		 * @param set
		 * @param array
		 * @return
		 */
		private boolean match(Set<String> set, IEPackageFactoryElement[] array) {
			boolean answer = set.size() == array.length;
			
			for (int i=0; answer && i<array.length; i++) {
				answer = set.contains(array[i].getId());
			}
			
			return answer;
		}
	}
	
	private static final EPackageMergedCache cache = new EPackageMergedCache();
	
	/**
	 * This element is related to "loader" extension point elements
	 * 
	 * @author Nicola Serreli
	 * @since 2.0
	 * 
	 */
	private class LoaderElement implements IEPackageFactoryElement {

		private final String id;
		private boolean isAuto;
		private final Class<IEPackageProvider> provider;

		LoaderElement(String id, Class<IEPackageProvider> provider) {
			this.id = id;
			this.provider = provider;
			this.isAuto = false;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.eu.evidence.rtdruid.epackage.EPackageFactory.EPackageFactoryElement
		 * #getFactory()
		 */
		@Override
		public EPackageFactoryImpl getFactory() {
			return EPackageFactoryImpl.this;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.eu.evidence.rtdruid.epackage.EPackageFactory.EPackageFactoryElement
		 * #getId()
		 */
		@Override
		public String getId() {
			return id;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.eu.evidence.rtdruid.epackage.EPackageFactory.EPackageFactoryElement
		 * #getProvider()
		 */
		@Override
		public IEPackageProvider getProvider(boolean fail) {
			IEPackageProvider af = null;
			try {
				af = (IEPackageProvider) (provider.getConstructor()).newInstance();
			} catch (Throwable e) {
				if (fail) {
					throw new EPackageProviderException(e);
				}
				RtdruidLog.log(e);
			}
			return af;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.eu.evidence.rtdruid.epackage.EPackageFactory.EPackageFactoryElement
		 * #isAutoContributionSet()
		 */
		@Override
		public boolean isAutoContributionSet() {
			return isAuto;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.eu.evidence.rtdruid.epackage.EPackageFactory.EPackageFactoryElement
		 * #setAutoContributionSet(boolean)
		 */
		@Override
		public void setAutoContributionSet(boolean value) {
			isAuto = value;
		}

	}

	/**
	 * This Element is related to ecoreFile extension point elements
	 * 
	 * @author Nicola Serreli
	 * @since 2.0
	 * 
	 */
	private class ECoreFileElement implements IEPackageFactoryElement {

		private final String id;
		private boolean isAuto;
		private final PluginEcoreEpackageProvider provider;

		/**
		 * 
		 */
		public ECoreFileElement(String id, PluginEcoreEpackageProvider provider) {
			this.id = id;
			this.provider = provider;
			this.isAuto = false;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.eu.evidence.rtdruid.epackage.EPackageFactory.EPackageFactoryElement
		 * #getFactory()
		 */
		@Override
		public EPackageFactoryImpl getFactory() {
			return EPackageFactoryImpl.this;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.eu.evidence.rtdruid.epackage.EPackageFactory.EPackageFactoryElement
		 * #getId()
		 */
		@Override
		public String getId() {
			return id;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.eu.evidence.rtdruid.epackage.EPackageFactory.EPackageFactoryElement
		 * #getProvider()
		 */
		@Override
		public IEPackageProvider getProvider(boolean fail) {
			if (provider == null) {
				if (fail) {
					throw new EPackageProviderException(new NullPointerException());
				} // else return null, i.e. return provider
			}
			return provider;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.eu.evidence.rtdruid.epackage.EPackageFactory.EPackageFactoryElement
		 * #isAutoContributionSet()
		 */
		@Override
		public boolean isAutoContributionSet() {
			return isAuto;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.eu.evidence.rtdruid.epackage.EPackageFactory.EPackageFactoryElement
		 * #setAutoContributionSet(boolean)
		 */
		@Override
		public void setAutoContributionSet(boolean value) {
			isAuto = value;
		}
	}

	/** Contains all contributions */
	protected List<IEPackageFactoryElement> factories = null;

	public EPackage getEPackage() throws RTDEPackageBuildException {
		
		return cache.getEpackage(doGetEPackageFactoryElements(false));
	}

	/* **************************
	 * 
	 * GET FACTORIES
	 * 
	 * *************************
	 */

	/** Creates a new instances each required factory */
	public IEPackageProvider[] getEPackageProviders() {
		return doGetEPackageProviders(true);
	}
	
	/** Creates a new instances each required factory */
	public IEPackageProvider[] doGetEPackageProviders(boolean alsoDisable) {
		
		// get factory list
		init();

		ArrayList<IEPackageProvider> answer = new ArrayList<IEPackageProvider>();
		for (IEPackageFactoryElement elem : factories) {
			
			if (alsoDisable || elem.isAutoContributionSet()) {
				IEPackageProvider af = elem.getProvider(false);
				if (af != null) {
					answer.add(af);
				}
			}
		}

		return (IEPackageProvider[]) answer.toArray(new IEPackageProvider[answer.size()]);
		
	}
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.epackage.EPackageFactory#getEPackageFactoryElement(java.lang.String)
	 */
	@Override
	public IEPackageFactoryElement getEPackageFactoryElement(String id) {
		if (id == null) {
			return null;
		}
		
		init();
		
		return doGetEPackageFactoryElement(factories, id);
	}
	
	private IEPackageFactoryElement doGetEPackageFactoryElement(List<IEPackageFactoryElement> list, String id) {
		if (id != null) {
			for (IEPackageFactoryElement elem: list) {
				if (id.equals(elem.getId())) {
					return elem;
				}
			}
		}
		return null;
		
	}
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.epackage.EPackageFactory#getEPackageFactoryElements()
	 */
	@Override
	public IEPackageFactoryElement[] getEPackageFactoryElements() {
		return doGetEPackageFactoryElements(true); 
	}
	
	/** Creates a new instances each required factory */
	private IEPackageFactoryElement[] doGetEPackageFactoryElements(boolean alsoDisable) {
	
		// get factory list
		init();

		ArrayList<IEPackageFactoryElement> answer = new ArrayList<IEPackageFactoryElement>();
		for (IEPackageFactoryElement elem : factories) {
			
			if (alsoDisable || elem.isAutoContributionSet()) {
				answer.add(elem);
			}
		}

		return (IEPackageFactoryElement[]) answer.toArray(new IEPackageFactoryElement[answer.size()]);
	}
	
	/* **************************
	 * 
	 * RELOAD EXTENTIONS
	 * 
	 * *************************
	 */

	/**
	 * Reads all extensions.
	 * <p>
	 * This method can be called more than once in order to reload from a
	 * changed extension registry.
	 * </p>
	 */
	protected void init() {
		if (factories == null) {
			reloadExtensions();
		}
	}

	public void reloadExtensions() {

		IExtensionRegistry registry = Platform.getExtensionRegistry();
		ArrayList<IEPackageFactoryElement> list = new ArrayList<IEPackageFactoryElement>();

		IConfigurationElement[] elements = registry.getConfigurationElementsFor(PLUGIN_ID, EXTENSION_POINT);
		for (IConfigurationElement element : elements) {
			try {

				String chName = element.getName();
				IEPackageFactoryElement tmp = null;
				if (LOADER.equalsIgnoreCase(chName)) {
					tmp = parseLoaderElement(element);
				} else if (PLUGIN_FILE.equalsIgnoreCase(chName)) {
					tmp = parsePluginElement(element);
				}
				if (tmp != null && doGetEPackageFactoryElement(list, tmp.getId()) == null) {
					list.add(tmp);
				}
			} catch (Throwable e) {
				RtdruidLog.log(e);
			}
		}
		factories = Collections.unmodifiableList(list);
	}

	@SuppressWarnings("unchecked")
	private IEPackageFactoryElement parseLoaderElement(IConfigurationElement element) {
		Assert.isNotNull(element);

		String chName = element.getName();
		Assert.isLegal(LOADER.equalsIgnoreCase(chName));
		IEPackageFactoryElement answer = null;
		/*
		 * Parse an Loader element
		 */

		String className = element.getAttribute(LOADER_CLASS);
		String id = element.getAttribute(PKG_ID);
		String auto = element.getAttribute(AUTO_CONTRIBUTE);
		
		if (id == null || id.isEmpty()) {
			id = autoId(element);
		}

		// load directly the factory's class doen't work always then
		// ask to eclipse framework to load the required class, and
		// store only the "Class" object
		try {
			Object o = element.createExecutableExtension(LOADER_CLASS);
			if (!((IEPackageProvider.class).isAssignableFrom(o.getClass()))) {
				RtdruidLog.log(new RuntimeException("The class " + className + " isn't an IEPackageProvider"));
			} else {
				answer = new LoaderElement(id, (Class<IEPackageProvider>) o.getClass());
				answer.setAutoContributionSet("TRUE".equalsIgnoreCase(auto));
			}
		} catch (Exception e) {
			RtdruidLog.log(new RuntimeException("Not found the adapter factory loader " + className, e));
		}

		return answer;
	}

	private IEPackageFactoryElement parsePluginElement(IConfigurationElement element) {
		Assert.isNotNull(element);

		IEPackageFactoryElement answer = null;

		String chName = element.getName();
		Assert.isLegal(PLUGIN_FILE.equalsIgnoreCase(chName));
		/*
		 * Parse an Loader element
		 */

		String file = element.getAttribute(PLUGIN_FILE_NAME);
		String id = element.getAttribute(PKG_ID);
		String auto = element.getAttribute(AUTO_CONTRIBUTE);
		String bundleName = element.getContributor().getName();
		Bundle bundle = Platform.getBundle(bundleName);

		if (id == null || id.isEmpty()) {
			id = autoId(element);
		}


		if (bundle == null) {
			RtdruidLog.log("Cannot find the bundle " + bundleName);
		} else {
			if (FileLocator.find(bundle, new Path(file), null) == null) {
				RtdruidLog.log("Cannot find the ecorePlugin file " + file + " provided by " + bundleName + " plugin");
			} else {
				answer = new ECoreFileElement(id, new PluginEcoreEpackageProvider(bundle, file));
				answer.setAutoContributionSet("TRUE".equalsIgnoreCase(auto));
			}
		}

		return answer;
	}
	
	

	/**
	 * @param element
	 * @return
	 */
	protected static String autoId(IConfigurationElement element) {
		return element.getContributor().getName() + element.hashCode();
	}



	protected static class PluginEcoreEpackageProvider extends EcoreEpackageProvider {

		protected final Bundle parent;
		protected final String file;

		public PluginEcoreEpackageProvider(Bundle parent, String file) {
			this.parent = parent;
			this.file = file;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.eu.evidence.rtdruid.epackage.EcoreEpackageProvider#getUri()
		 */
		@Override
		protected URI getUri() {
			final URL url = parent.getEntry(file);
			final URI answer;
			if (url == null) {
				answer = URI.createURI(file);
			} else {
				answer = URI.createURI(url.toString());
			}
			return answer;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.eu.evidence.rtdruid.epackage.EcoreEpackageProvider#getInput()
		 */
		@Override
		protected InputStream getInput() throws IOException {
			return FileLocator.openStream(parent, new Path(file), false);
		}
	}

}
