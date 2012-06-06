/*
 * Created on 15-set-2004
 *
 * $Id: EMFCommandsTest.java,v 1.2 2008/05/14 17:00:33 durin Exp $
 */
package com.eu.evidence.rtdruid.test.vartree;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;

import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.CopyToClipboardCommand;
import org.junit.Before;
import org.junit.Test;

import com.eu.evidence.rtdruid.internal.io.RTDResourceManager;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.VarTreeUtil;
import com.eu.evidence.rtdruid.vartree.data.Architectural;
import com.eu.evidence.rtdruid.vartree.data.DataFactory;
import com.eu.evidence.rtdruid.vartree.data.Scheduling;
import com.eu.evidence.rtdruid.vartree.data.Task;
import com.eu.evidence.rtdruid.vartree.variables.StringVar;


/**
 * @author Nicola Serreli
 *
 */
public class EMFCommandsTest {
	
	IVarTree vt;

	@Before
	public void setUp() {
		vt = VarTreeUtil.newVarTree();
	}

	@Test
	public void testCopyCommand() {
		
		Architectural arch = DataFactory.eINSTANCE.createArchitectural();
		Task task = DataFactory.eINSTANCE.createTask();
		arch.getTaskList().add(task);
		
		Scheduling[] scheds = {
				DataFactory.eINSTANCE.createScheduling(),
				DataFactory.eINSTANCE.createScheduling(),
				DataFactory.eINSTANCE.createScheduling(),
				DataFactory.eINSTANCE.createScheduling(),
				DataFactory.eINSTANCE.createScheduling()
		};
		for (int i=0; i<scheds.length; i++) {
			scheds[i].setModeRef( new StringVar("Mode" +i) );
		}
		for (int i=0; i<scheds.length; i++) {
			task.getSchedulingList().add(scheds[i]);
		}
		
		Command com = CopyToClipboardCommand.create(vt, task);
//		Command com = vt.createCommand(CopyToClipboardCommand.class, new CommandParameter(arch, task.eContainingFeature(), task));
		
		assertTrue(com.canExecute());
		com.execute();
		Collection<Object> col = vt.getClipboard();
		assertNotNull(col);
		assertEquals(1, col.size() );
		
		Object result = col.toArray()[0];
		assertTrue(result instanceof Task);
		String t = VarTreeUtil.compare(task, (Task) result).getMessage(); assertNull(t, t);

//		for (Object o : ((EObjectContainmentUniqueEList) ((Task) result).getSchedulingList()).getFastSearch().entrySet()) {
//			System.out.println(o);
//		}
//		System.out.println(result);
		
		for (int i=0; i<scheds.length; i++) {
			
			assertTrue(task.getSchedulingList().contains(scheds[i]));
			assertFalse(((Task) result).getSchedulingList().contains(scheds[i]));
			
			EList<Scheduling> list = ((Task) result).getSchedulingList(); 
			for (Scheduling s: list) {
				int match = 0;
				for (int check_id=0; check_id<scheds.length; check_id++) {
					if (EcoreUtil.equals(s, scheds[check_id])) {
						match++;
					}
				}
				assertEquals(1, match );
			}
		}
		
	}

	@Test
	public void testCopyCommandWithResource() {
		
		RTDResourceManager xmiri = new RTDResourceManager(); 
		Architectural arch = DataFactory.eINSTANCE.createArchitectural();
		xmiri.getContents().add(arch);
		Task task = DataFactory.eINSTANCE.createTask();
		arch.getTaskList().add(task);
		
		Scheduling[] scheds = {
				DataFactory.eINSTANCE.createScheduling(),
				DataFactory.eINSTANCE.createScheduling(),
				DataFactory.eINSTANCE.createScheduling(),
				DataFactory.eINSTANCE.createScheduling(),
				DataFactory.eINSTANCE.createScheduling()
		};
		for (int i=0; i<scheds.length; i++) {
			scheds[i].setModeRef( new StringVar("Mode" +i) );
		}
		for (int i=0; i<scheds.length; i++) {
			task.getSchedulingList().add(scheds[i]);
		}
		
		for (int i=0; i<scheds.length; i++) {
			assertNotNull(scheds[i].eResource());
		}

		
		Command com = CopyToClipboardCommand.create(vt, task);
//		Command com = vt.createCommand(CopyToClipboardCommand.class, new CommandParameter(arch, task.eContainingFeature(), task));
		
		assertTrue(com.canExecute());
		com.execute();
		Collection<Object> col = vt.getClipboard();
		assertNotNull(col);
		assertEquals(1, col.size() );
		
		Object result = col.toArray()[0];
		assertTrue(result instanceof Task);
		String t = VarTreeUtil.compare(task, (Task) result).getMessage(); assertNull(t, t);
		assertTrue(EcoreUtil.equals(task, (Task) result));
	}

}
