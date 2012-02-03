/**
 * 21/dic/2011
 */
package com.eu.evidence.rtdruid.epackage;

import com.eu.evidence.rtdruid.internal.epackage.EPackageXmlMerge;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class EPackageXmlMergeTest extends AbstractEcoreEpackageMergeTest {
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.epackage.AbstractEcoreEpackageMergeTest#getMerge()
	 */
	@Override
	protected IEPackageMerge getMerge() {
		return new EPackageXmlMerge();
	}

}
