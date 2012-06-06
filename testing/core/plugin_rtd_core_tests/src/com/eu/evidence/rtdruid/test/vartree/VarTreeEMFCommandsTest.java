/*
 * Created on Jul 28, 2004
 *
 * $Id: VarTreeEMFCommandsTest.java,v 1.1 2005/09/28 15:22:29 durin Exp $
 */
package com.eu.evidence.rtdruid.test.vartree;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertNotSame;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.junit.Before;
import org.junit.Test;

import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVarTreePointer;
import com.eu.evidence.rtdruid.vartree.VarTreeUtil;

/**
 * @author Nicola Serreli
 */
public class VarTreeEMFCommandsTest {
	private final static String S = "" + IVarTree.SEPARATOR;
	
	private IVarTree vt;

	@Before
	public void setUp() throws Exception {
		vt = VarTreeUtil.newVarTree();
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
	
	@Test
	public void testRemoveNode() {
		assertNull(vt.getCommandStack().getMostRecentCommand());
		populate();
		assertNotNull(vt.getCommandStack().getMostRecentCommand());
		Command c1 = vt.getCommandStack().getMostRecentCommand();
		
		assertNull( vt.getCurrentTransaction());
		vt.beginTransaction();
		assertNotNull(vt.getCurrentTransaction());
		
		IVarTreePointer vtp = vt.newVarTreePointer();
		assertTrue(vtp.go("MySystem"));
		assertTrue(vtp.go("Architectural"));
		assertTrue(vtp.go("TaskList"));
		assertTrue(vtp.go("myTask"));
		
		vtp.destroy();
		assertTrue("TaskList".equals(vtp.getName()));
		assertFalse(vtp.exist("myTask"));
		
		assertSame(vt.getCommandStack().getMostRecentCommand() , c1);
		assertNotNull(vt.getCurrentTransaction());
		CompoundCommand com = vt.getCurrentTransaction();

		vt.commitTransaction();
		assertNull(vt.getCurrentTransaction());
		assertSame(vt.getCommandStack().getMostRecentCommand() , com);

		assertTrue("TaskList".equals(vtp.getName()));
		assertFalse(vtp.exist("myTask"));
	}

	@Test
	public void testChain() {
		assertNull(vt.getCommandStack().getMostRecentCommand());
		vt.beginTransaction();
		CompoundCommand preCom = vt.getCurrentTransaction();

		populate();
		CompoundCommand com = vt.getCurrentTransaction();
		
//		 NB : populate() set the root and this operation flush all old command and restart the compound
		assertNotSame(com, preCom);	 

		assertNull(vt.getCommandStack().getMostRecentCommand());

		vt.commitTransaction();
		assertNull(vt.getCurrentTransaction());
		assertSame(vt.getCommandStack().getMostRecentCommand() , com);
	}

	@Test
	public void testChainUndo1() {
		assertNull(vt.getCommandStack().getMostRecentCommand());
		vt.beginTransaction();
		CompoundCommand preCom = vt.getCurrentTransaction();

		populate();
		CompoundCommand com = vt.getCurrentTransaction();
		
//		 NB : populate() set the root and this operation flush all old command and restart the compound
		assertNotSame(com, preCom);	 

		assertNull(vt.getCommandStack().getMostRecentCommand());
		assertNull(vt.getCommandStack().getUndoCommand());
		assertNull(vt.getCommandStack().getRedoCommand());

		vt.commitTransaction();
		assertNull(vt.getCurrentTransaction());
		assertSame(vt.getCommandStack().getMostRecentCommand() , com);
		assertSame(vt.getCommandStack().getUndoCommand() , com);
		assertNull(vt.getCommandStack().getRedoCommand());
		
		// try to undo
		assertTrue(vt.getCommandStack().canUndo());
		vt.getCommandStack().undo();
		
		assertSame(vt.getCommandStack().getMostRecentCommand() , com);
		assertNull(vt.getCommandStack().getUndoCommand());
		assertSame(vt.getCommandStack().getRedoCommand() , com);
		IVarTreePointer vtp = vt.newVarTreePointer();
		assertTrue(vtp.exist("MySystem")); // NB : add and remove system is undoable !!
		assertFalse(vtp.exist("MySystem" +S+ "Architectural"));
	}
}
