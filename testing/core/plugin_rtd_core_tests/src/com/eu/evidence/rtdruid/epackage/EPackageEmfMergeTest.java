/**
 * 21/dic/2011
 */
package com.eu.evidence.rtdruid.epackage;

import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;

import com.eu.evidence.rtdruid.internal.epackage.EPackageEmfMerge;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
@SuppressWarnings("deprecation")
public class EPackageEmfMergeTest extends AbstractEcoreEpackageMergeTest {
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.epackage.AbstractEcoreEpackageMergeTest#getMerge()
	 */
	@Override
	protected IEPackageMerge getMerge() {
		return new EPackageEmfMerge();
	}
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.epackage.AbstractEcoreEpackageMergeTest#testSuperTypes()
	 */
	@Override
	@Test
	@Ignore
	public void testMissingAttributes() throws RTDEPackageBuildException, IOException,
			InterruptedException {
	}
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.epackage.AbstractEcoreEpackageMergeTest#testTypes()
	 */
	@Override
	@Test
	@Ignore
	public void testTypes() throws RTDEPackageBuildException, IOException,
			InterruptedException {
	}

	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.epackage.AbstractEcoreEpackageMergeTest#testTypes2()
	 */
	@Override
	@Test
	@Ignore
	public void testTypes2() throws RTDEPackageBuildException, IOException,
			InterruptedException {
	}
}
