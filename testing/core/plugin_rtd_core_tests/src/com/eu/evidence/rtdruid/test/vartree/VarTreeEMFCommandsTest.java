/*
 * Created on Jul 28, 2004
 *
 * $Id: VarTreeEMFCommandsTest.java,v 1.1 2005/09/28 15:22:29 durin Exp $
 */
package com.eu.evidence.rtdruid.test.vartree;

import junit.framework.TestCase;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;

import com.eu.evidence.rtdruid.desk.RTDFactory;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVarTreePointer;

/**
 * @author Nicola Serreli
 */
public class VarTreeEMFCommandsTest extends TestCase {
	private final static String S = "" + IVarTree.SEPARATOR;
	
	private IVarTree vt;

	public VarTreeEMFCommandsTest() {
	}
	
	/*
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();

		vt = RTDFactory.newVarTree();
	}

	/**
	 */
	private void populate() {
		IVarTreePointer vtp = vt.newVarTreePointer();

		assertTrue("MySystem".equals(vtp.add("MySystem","System")));
		assertTrue(vtp.go("MySystem"));

		assertTrue("Architectural".equals(vtp.add("Architectural","Architectural")));

		assertTrue(vtp.go("Architectural"));
		assertTrue(vtp.go("TaskList"));

		assertTrue("myTask".equals(vtp.add("myTask","Task")));
		
		////
	}
	
	public void testRemoveNode() {
		assertTrue(vt.getCommandStack().getMostRecentCommand() == null);
		populate();
		assertTrue(vt.getCommandStack().getMostRecentCommand() != null);
		Command c1 = vt.getCommandStack().getMostRecentCommand();
		
		assertTrue( vt.getCurrentTransaction() == null );
		vt.beginTransaction();
		assertTrue( vt.getCurrentTransaction() != null);
		
		IVarTreePointer vtp = vt.newVarTreePointer();
		assertTrue(vtp.go("MySystem"));
		assertTrue(vtp.go("Architectural"));
		assertTrue(vtp.go("TaskList"));
		assertTrue(vtp.go("myTask"));
		
		vtp.destroy();
		assertTrue("TaskList".equals(vtp.getName()));
		assertTrue(!vtp.exist("myTask"));
		
		assertTrue(vt.getCommandStack().getMostRecentCommand() == c1);
		assertTrue( vt.getCurrentTransaction() != null);
		CompoundCommand com = vt.getCurrentTransaction();

		vt.commitTransaction();
		assertTrue( vt.getCurrentTransaction() == null);
		assertTrue(vt.getCommandStack().getMostRecentCommand() == com);

		assertTrue("TaskList".equals(vtp.getName()));
		assertTrue(!vtp.exist("myTask"));
	}

	public void testChain() {
		assertTrue(vt.getCommandStack().getMostRecentCommand() == null);
		vt.beginTransaction();
		CompoundCommand preCom = vt.getCurrentTransaction();

		populate();
		CompoundCommand com = vt.getCurrentTransaction();
		
//		 NB : populate() set the root and this operation flush all old command and restart the compound
		assertTrue(com != preCom);	 

		assertTrue(vt.getCommandStack().getMostRecentCommand() == null);

		vt.commitTransaction();
		assertTrue( vt.getCurrentTransaction() == null);
		assertTrue(vt.getCommandStack().getMostRecentCommand() == com);
	}

	public void testChainUndo1() {
		assertTrue(vt.getCommandStack().getMostRecentCommand() == null);
		vt.beginTransaction();
		CompoundCommand preCom = vt.getCurrentTransaction();

		populate();
		CompoundCommand com = vt.getCurrentTransaction();
		
//		 NB : populate() set the root and this operation flush all old command and restart the compound
		assertTrue(com != preCom);	 

		assertTrue(vt.getCommandStack().getMostRecentCommand() == null);
		assertTrue(vt.getCommandStack().getUndoCommand() == null);
		assertTrue(vt.getCommandStack().getRedoCommand() == null);

		vt.commitTransaction();
		assertTrue( vt.getCurrentTransaction() == null);
		assertTrue(vt.getCommandStack().getMostRecentCommand() == com);
		assertTrue(vt.getCommandStack().getUndoCommand() == com);
		assertTrue(vt.getCommandStack().getRedoCommand() == null);
		
		// try to undo
		assertTrue(vt.getCommandStack().canUndo());
		vt.getCommandStack().undo();
		
		assertTrue(vt.getCommandStack().getMostRecentCommand() == com);
		assertTrue(vt.getCommandStack().getUndoCommand() == null);
		assertTrue(vt.getCommandStack().getRedoCommand() == com);
		IVarTreePointer vtp = vt.newVarTreePointer();
		assertTrue(vtp.exist("MySystem")); // NB : add and remove system is undoable !!
		assertTrue(!vtp.exist("MySystem" +S+ "Architectural"));
	}
}
