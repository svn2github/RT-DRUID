/**
 * 04/gen/2012
 */
package com.eu.evidence.rtdruid.test.vartree;

import static com.eu.evidence.rtdruid.tests.RtdAssert.assertGreater;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Test;

import com.eu.evidence.rtdruid.epackage.RTDEPackageBuildException;
import com.eu.evidence.rtdruid.io.IVTResource;
import com.eu.evidence.rtdruid.io.RTD_XMI_Factory;
import com.eu.evidence.rtdruid.tests.vartree.data.FillVtUtil;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.VarTreeUtil;
import com.eu.evidence.rtdruid.vartree.Vt2StringUtilities;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public abstract class FillVtUtilTest {
	
	protected abstract EPackage getEPackage() throws RTDEPackageBuildException;
	
	protected EObject getRoot() throws RTDEPackageBuildException {
		EPackage epkg = getEPackage();
		EClassifier root = epkg.getEClassifier("System");
		assertNotNull(root);
		return EcoreUtil.create((EClass) root);
	}

	@Test
	public void testNewNull() throws IOException {
		FillVtUtil filler = new FillVtUtil(VarTreeUtil.newVarTree(), null);

		assertNotNull(filler.getEditingDomain());
		assertTrue(filler.getEditingDomain() instanceof IVarTree);
		assertNotNull(filler.getResource());
		assertEquals(filler.getEditingDomain().getResourceSet().getResources().size(), 1);
		assertSame(filler.getEditingDomain().getResourceSet().getResources().get(0), filler.getResource());
	}
	@Test
	public void testNewResource() throws IOException {
		FillVtUtil filler = new FillVtUtil(VarTreeUtil.newVarTree(), (IVTResource) RTD_XMI_Factory.instance.createResource());

		assertNotNull(filler.getEditingDomain());
		assertTrue(filler.getEditingDomain() instanceof IVarTree);
		assertNotNull(filler.getResource());
		assertEquals(filler.getEditingDomain().getResourceSet().getResources().size(), 2);
		assertNotSame(filler.getEditingDomain().getResourceSet().getResources().get(0), filler.getResource());
		assertSame(filler.getEditingDomain().getResourceSet().getResources().get(1), filler.getResource());
	}
	@Test
	public void testNewVtCommandNull() throws IOException {
		FillVtUtil filler = new FillVtUtil(VarTreeUtil.newVarTree(new BasicCommandStack()), null);

		assertNotNull(filler.getEditingDomain());
		assertTrue(filler.getEditingDomain() instanceof IVarTree);
		assertNotNull(filler.getResource());
		assertEquals(filler.getEditingDomain().getResourceSet().getResources().size(), 1);
	}
	@Test
	public void testNewVtCommandResource() throws IOException {
		FillVtUtil filler = new FillVtUtil(VarTreeUtil.newVarTree(new BasicCommandStack()), (IVTResource) RTD_XMI_Factory.instance.createResource());

		assertNotNull(filler.getEditingDomain());
		assertTrue(filler.getEditingDomain() instanceof IVarTree);
		assertNotNull(filler.getResource());
		assertEquals(filler.getEditingDomain().getResourceSet().getResources().size(), 2);
		assertSame(filler.getEditingDomain().getResourceSet().getResources().get(1), filler.getResource());
	}
	
	@Test
	public void testFill() throws IOException, RTDEPackageBuildException {
		FillVtUtil filler = new FillVtUtil(VarTreeUtil.newVarTree(), null);
		EObject root = getRoot();
		filler.fill(root);

		assertNotNull(filler.getEditingDomain());
		assertTrue(filler.getEditingDomain() instanceof IVarTree);
		assertNotNull(filler.getResource());
		assertEquals(filler.getEditingDomain().getResourceSet().getResources().size(), 1);
		assertSame(filler.getEditingDomain().getResourceSet().getResources().get(0), filler.getResource());
		assertSame(filler.getResource().getContents().get(0), root);
		System.out.println(Vt2StringUtilities.varTreeToStringErtd(filler.getEditingDomain()));
		System.out.println(Vt2StringUtilities.varTreeToStringRtd(filler.getEditingDomain()));
	}

	@Test
	public void testMultiFill() throws IOException, RTDEPackageBuildException {
		FillVtUtil filler = new FillVtUtil(VarTreeUtil.newVarTree(), null);
		EObject root1 = getRoot();
		EObject root2 = getRoot();
		int root1_children_size = root1.eContents().size();
		int root2_children_size = root2.eContents().size();
		assertEquals(root1_children_size, root2_children_size);
		
		filler.fill(root1);
		int new_root1_children_size = root1.eContents().size();
		assertGreater(root1_children_size ,  new_root1_children_size);
		assertEquals(root2_children_size, root2.eContents().size());
		filler.fill(root2);
		assertGreater(root2_children_size ,  root2.eContents().size());
		assertEquals(new_root1_children_size, new_root1_children_size);
		assertEquals(new_root1_children_size, root2.eContents().size());

		assertNotNull(filler.getEditingDomain());
		assertTrue(filler.getEditingDomain() instanceof IVarTree);
		assertNotNull(filler.getResource());
		assertEquals(filler.getEditingDomain().getResourceSet().getResources().size(), 1);
		assertSame(filler.getEditingDomain().getResourceSet().getResources().get(0), filler.getResource());
		assertSame(filler.getResource().getContents().get(0), root1);
		assertSame(filler.getResource().getContents().get(1), root2);
	}
	
	@Test
	public void testGenericFill() throws IOException, RTDEPackageBuildException {
		FillVtUtil filler = new FillVtUtil();
		EObject root1 = getRoot();
		EObject root2 = getRoot();
		filler.fill(root1);
		filler.fill(root2);

		assertNotNull(filler.getEditingDomain());
		assertFalse(filler.getEditingDomain() instanceof IVarTree);
		assertNotNull(filler.getResource());
		assertEquals(filler.getEditingDomain().getResourceSet().getResources().size(), 1);
		assertSame(filler.getEditingDomain().getResourceSet().getResources().get(0), filler.getResource());
		assertSame(filler.getResource().getContents().get(0), root1);
		assertSame(filler.getResource().getContents().get(1), root2);
	}
}
