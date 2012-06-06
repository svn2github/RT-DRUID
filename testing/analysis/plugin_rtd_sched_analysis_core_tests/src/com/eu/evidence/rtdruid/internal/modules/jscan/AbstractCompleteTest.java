/*
 * Created on Jul 12, 2004
 *
 * $Id: AbstractCompleteTest.java,v 1.1 2005/09/28 15:22:29 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.jscan;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.VarTreeUtil;

/**
 * @author Nicola Serreli
 */
public abstract class AbstractCompleteTest extends TestCase {

	/**
	 */
	public AbstractCompleteTest(String name) {
		super(name);
	}
	
	protected void check(IVarTree input, IVarTree expectedResult) {
		String t = VarTreeUtil.compare(
				(EObject) ((Resource) input.getResourceSet().getResources().get(0)).getContents().get(0),
				(EObject) ((Resource) expectedResult.getResourceSet().getResources().get(0)).getContents().get(0)
			).getMessage(); assertTrue(t, t== null);

	}
	
	@Override
	protected void setUp() throws Exception {
		System.out.println("\n\n************\n TEST " + getClass().getName() + " - " + getName() + "\n************\n\n");

		System.out.println("\n\n*******************************\n" +
				"  TEST " + getClass().getName() + " - " + getName() + "\n" +
				"*******************************\n");
		super.setUp();
	}
}
