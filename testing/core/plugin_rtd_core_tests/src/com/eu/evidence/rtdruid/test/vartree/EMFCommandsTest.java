/*
 * Created on 15-set-2004
 *
 * $Id: EMFCommandsTest.java,v 1.2 2008/05/14 17:00:33 durin Exp $
 */
package com.eu.evidence.rtdruid.test.vartree;


import java.util.Collection;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.CopyToClipboardCommand;

import com.eu.evidence.rtdruid.desk.RTDFactory;
import com.eu.evidence.rtdruid.internal.vartree.data.init.RTDResourceManager;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.data.Architectural;
import com.eu.evidence.rtdruid.vartree.data.DataFactory;
import com.eu.evidence.rtdruid.vartree.data.Scheduling;
import com.eu.evidence.rtdruid.vartree.data.Task;
import com.eu.evidence.rtdruid.vartree.data.init.VtCompare;
import com.eu.evidence.rtdruid.vartree.variables.StringVar;


/**
 * @author Nicola Serreli
 *
 */
public class EMFCommandsTest extends TestCase {
	
	IVarTree vt;

	/**
	 * Constructor for UtilityTest.
	 * @param arg0
	 */
	public EMFCommandsTest(String arg0) {
		super(arg0);
		
		vt = RTDFactory.newVarTree();
	}

	public static Test suite() {
		return new TestSuite(EMFCommandsTest.class) ;
	}
	
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
		assertTrue(col != null);
		assertTrue(col.size() == 1);
		
		Object result = col.toArray()[0];
		assertTrue(result instanceof Task);
		String t = (new VtCompare(task, (Task) result)).getText(); assertTrue(t, t== null);

//		for (Object o : ((EObjectContainmentUniqueEList) ((Task) result).getSchedulingList()).getFastSearch().entrySet()) {
//			System.out.println(o);
//		}
//		System.out.println(result);
		
		for (int i=0; i<scheds.length; i++) {
			
			assertTrue(task.getSchedulingList().contains(scheds[i]));
			assertTrue(!((Task) result).getSchedulingList().contains(scheds[i]));
			
			EList<Scheduling> list = ((Task) result).getSchedulingList(); 
			for (Scheduling s: list) {
				int match = 0;
				for (int check_id=0; check_id<scheds.length; check_id++) {
					if (EcoreUtil.equals(s, scheds[check_id])) {
						match++;
					}
				}
				assertTrue(match == 1);
			}
		}
		
	}

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
			assertTrue(scheds[i].eResource() != null);
		}

		
		Command com = CopyToClipboardCommand.create(vt, task);
//		Command com = vt.createCommand(CopyToClipboardCommand.class, new CommandParameter(arch, task.eContainingFeature(), task));
		
		assertTrue(com.canExecute());
		com.execute();
		Collection<Object> col = vt.getClipboard();
		assertTrue(col != null);
		assertTrue(col.size() == 1);
		
		Object result = col.toArray()[0];
		assertTrue(result instanceof Task);
		String t = (new VtCompare(task, (Task) result)).getText(); assertTrue(t, t== null);
		assertTrue(EcoreUtil.equals(task, (Task) result));
	}

}
