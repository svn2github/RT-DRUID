/**
 * 21/dic/2011
 */
package com.eu.evidence.rtdruid.epackage;

import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;

import com.eu.evidence.rtdruid.internal.epackage.EPackageDiffMerge;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
@SuppressWarnings("deprecation")
public class EPackageDiffMergeTest extends AbstractEcoreEpackageMergeTest {
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.epackage.AbstractEcoreEpackageMergeTest#getMerge()
	 */
	@Override
	protected IEPackageMerge getMerge() {
		return new EPackageDiffMerge();
	}

	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.epackage.AbstractEcoreEpackageMergeTest#testEmpty2()
	 */
	@Override
	@Test
	@Ignore
	public void testEmpty2() throws RTDEPackageBuildException, IOException {
		super.testEmpty2();
	}
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.epackage.AbstractEcoreEpackageMergeTest#testVerySimple()
	 */
	@Override
	@Test
	@Ignore
	public void testVerySimple() throws RTDEPackageBuildException, IOException {
		super.testVerySimple();
	}
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.epackage.AbstractEcoreEpackageMergeTest#testSimple()
	 */
	@Override
	@Test
	@Ignore
	public void testSimple() throws RTDEPackageBuildException, IOException {
		super.testSimple();
	}
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.epackage.AbstractEcoreEpackageMergeTest#testSameReference()
	 */
	@Override
	@Test
	@Ignore
	public void testSameReference() throws RTDEPackageBuildException,
			IOException {
		super.testSameReference();
	}
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.epackage.AbstractEcoreEpackageMergeTest#testSuperTypes()
	 */
	@Override
	@Test
	@Ignore
	public void testMissingAttributes() throws RTDEPackageBuildException, IOException,
			InterruptedException {
		super.testMissingAttributes();
	}
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.epackage.AbstractEcoreEpackageMergeTest#testTypes()
	 */
	@Override
	@Test
	@Ignore
	public void testTypes() throws RTDEPackageBuildException, IOException,
			InterruptedException {
		super.testTypes();
	}
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.epackage.AbstractEcoreEpackageMergeTest#testTypes2()
	 */
	@Override
	@Test
	@Ignore
	public void testTypes2() throws RTDEPackageBuildException, IOException,
			InterruptedException {
		super.testTypes2();
	}
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.epackage.AbstractEcoreEpackageMergeTest#testCollision()
	 */
	@Override
	@Test
	@Ignore
	public void testCollision() throws RTDEPackageBuildException, IOException {
		super.testCollision();
	}
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.epackage.AbstractEcoreEpackageMergeTest#testOrder()
	 */
	@Override
	@Test
	@Ignore
	public void testOrder() throws RTDEPackageBuildException, IOException {
		super.testOrder();
	}
}
