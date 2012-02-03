/**
 * 14/nov/2011
 */
package com.eu.evidence.rtdruid.epackage;

import org.eclipse.emf.ecore.EPackage;

import com.eu.evidence.rtdruid.internal.epackage.EPackageFactoryImpl;

/**
 * 
 * @author Nicola Serreli
 * @since 2.0
 * 
 */
public abstract class EPackageFactory {

	/**
	 * This interface can be used to get a detailed view of EPackage
	 * contribution in a EPackage factory. Note that is possible to change
	 * values of EPackageFactory elements throw this interface.
	 * 
	 * @author Nicola Serreli
	 * @since 2.0
	 * 
	 */
	public static interface IEPackageFactoryElement {

		/**
		 * @return the EPackageFactory linked to this Element
		 */
		EPackageFactory getFactory();

		/**
		 * @param fail
		 *            if set to true, any problem during the provider
		 *            instantiation throws an exception, otherwise return
		 * 
		 * @return the contribution
		 */
		IEPackageProvider getProvider(boolean fail) throws EPackageProviderException;

		/**
		 * @return true if this EPackage contribution is considered during the
		 *         build of global EPackage.
		 */
		boolean isAutoContributionSet();

		/**
		 * This method can be used to change the value of auto_contribution
		 * attribute. Please note that this
		 * 
		 * @value if set to true, this EPackage contribution is considered
		 *        during the build of global EPackage.
		 */
		void setAutoContributionSet(boolean value);

		/**
		 * @return the EPackageContributor id. It should be not null.
		 */
		String getId();
	}

	/**
	 * This exception is thrown if there is a problem during the instantiation
	 * of a IEPackageProvider
	 * 
	 * @author Nicola Serreli
	 * @since 2.0
	 * 
	 */
	public static class EPackageProviderException extends RuntimeException {

		/**
		 * 
		 */
		private static final long serialVersionUID = 3057714393866177574L;

		/**
		 * 
		 */
		public EPackageProviderException(Throwable e) {
			super(e);
		}
	}

	
	/* **************************
	 * 
	 * GET FACTORIES
	 * 
	 * *************************
	 */
	
	/**
	 * Default EPackageFactory.
	 */
	public static EPackageFactory instance = getFactory();
	
	/**
	 * @return a new EPackageFactory
	 */
	public static EPackageFactory getFactory() {
		return new EPackageFactoryImpl();
	}

	/** Creates a new instances each required factory */
	public abstract IEPackageProvider[] getEPackageProviders();

	/** Returns all elements of this EPackageFactory */
	public abstract IEPackageFactoryElement[] getEPackageFactoryElements();

	/** Returns an element of this EPackageFactory, or null if not found.
	 * Note that if the id parameters is set to null, this function always return null. */
	public abstract IEPackageFactoryElement getEPackageFactoryElement(String id);

	/**
	 * @return the composition of all Elements with Auto_contribution set to
	 *         true
	 * 
	 * @throws RTDEPackageBuildException
	 */
	public abstract EPackage getEPackage() throws RTDEPackageBuildException;

	/* **************************
	 * 
	 * RELOAD EXTENTIONS
	 * 
	 * *************************
	 */

	/**
	 * Reads all extensions and reset the EPackage contributions to default
	 * ones.
	 */
	public abstract void reloadExtensions();

}
