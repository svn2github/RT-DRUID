/*
 * Created on Jul 12, 2004
 *
 * $Id: AbstractCompleteTest.java,v 1.1 2005/09/28 15:22:29 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.jscan;

import static org.junit.Assert.assertTrue;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.eu.evidence.rtdruid.tests.AbstractNamedTest;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.VarTreeUtil;

/**
 * @author Nicola Serreli
 */
public abstract class AbstractCompleteTest extends AbstractNamedTest {

	protected void check(IVarTree input, IVarTree expectedResult) {
		IStatus st = VarTreeUtil.compare(
				(EObject) ((Resource) input.getResourceSet().getResources().get(0)).getContents().get(0),
				(EObject) ((Resource) expectedResult.getResourceSet().getResources().get(0)).getContents().get(0)
			);
		assertTrue(st.getMessage(), st.isOK());
	}
}
