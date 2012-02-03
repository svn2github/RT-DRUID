/*
 * Created on Sep 28, 2004
 *
 * $Id: OilApplPointerTest.java,v 1.2 2007/03/09 09:12:41 durin Exp $
 */
package com.eu.evidence.rtdruid.hidden.modules.oil.vtextensions.pointer;




import java.util.Stack;

import junit.framework.TestCase;

import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.ISubVarTreePointer;
import com.eu.evidence.rtdruid.vartree.VarTreeUtil;
import com.eu.evidence.rtdruid.vartree.data.oil.OilApplPackage;
import com.eu.evidence.rtdruid.vartree.variables.OilVarMP;
import com.eu.evidence.rtdruid.vartree.variables.StringVar;

/**
 * @author Nicola Serreli
 */
public class OilApplPointerTest extends TestCase {
	protected final static OilApplPackage OAP = OilApplPackage.eINSTANCE;

	public void testCreateRoot() {
		OilVarMP ovm = new OilVarMP();

		ISubVarTreePointer svtp = ovm.getPointer(VarTreeUtil.newVarTree());
		assertTrue(svtp.getChildrenNumber() == 0);
		
		String chty[][] = svtp.getNewChildTypes();
		
		assertTrue(chty.length == 1);
		assertTrue(chty[0].length == 2);
		assertTrue(OAP.getRoot().getName().equals(chty[0][0]));
		assertTrue(null == chty[0][1]);
		
		String name = "myName";
		assertTrue(name.equals(svtp.add(name, chty[0][0])));
		
		assertTrue(svtp.getChildrenNumber() == 1);
		// check root node
		assertTrue(svtp.subGoFirstChild()==ISubVarTreePointer.OK);
		assertTrue(name.equals(svtp.getName()));
		assertTrue(chty[0][0].equals(svtp.getType()));
		assertTrue(svtp.getChildrenNumber() == 3);
		
		chty = svtp.getNewChildTypes();
		assertTrue(chty.length == 0);

		/*
		 * GO_FIRST_CHILD, GO_NEXT_SIBLING, GO_PARENT 
		 */
		
		//  cycle all children
		//		* HW_List
		assertTrue(svtp.subGoFirstChild() == ISubVarTreePointer.OK);
		assertTrue(OAP.getRoot_HwList().getName().equals(svtp.getName()));
		assertTrue(OAP.getRoot_HwList().getName().equals(svtp.getType()));
		assertTrue(svtp.getChildrenNumber() == 0);
		assertTrue(svtp.isContainer());
		assertTrue(svtp.subGoFirstChild() == ISubVarTreePointer.ERROR);

		//		* ObjectType
		assertTrue(svtp.subGoNextSibling() == ISubVarTreePointer.OK);
		assertTrue(OAP.getRoot_ObjectType().getName().equals(svtp.getName()));
		assertTrue("StringVar".equals(svtp.getType()));
		assertTrue(svtp.getChildrenNumber() == 0);
		assertTrue(!svtp.isContainer());
		assertTrue(name.equals(svtp.getVar().get()));

		//		* description // is empty !!!!
		assertTrue(svtp.subGoNextSibling() == ISubVarTreePointer.OK);
		assertTrue(OAP.getRoot_Description().getName().equals(svtp.getName()));
		assertTrue("StringVar".equals(svtp.getType()));
		assertTrue(svtp.getChildrenNumber() == 0);
		assertTrue(!svtp.isContainer());
		assertTrue(svtp.getVar() == null);
		assertTrue(svtp.subGoNextSibling() == ISubVarTreePointer.ERROR);

		assertTrue(svtp.subGoParent() == ISubVarTreePointer.OK);
		
		// cycle again : add a Description
		assertTrue(OAP.getRoot_Description().getName().equals(
				svtp.add(OAP.getRoot_Description().getName(), new StringVar(
						"A simple Desscription"))));

		//		* HW_List
		assertTrue(svtp.subGoFirstChild() == ISubVarTreePointer.OK);
		assertTrue(OAP.getRoot_HwList().getName().equals(svtp.getName()));
		assertTrue(OAP.getRoot_HwList().getName().equals(svtp.getType()));
		assertTrue(svtp.getChildrenNumber() == 0);
		assertTrue(svtp.isContainer());
		assertTrue(svtp.subGoFirstChild() == ISubVarTreePointer.ERROR);

		//		* ObjectType
		assertTrue(svtp.subGoNextSibling() == ISubVarTreePointer.OK);
		assertTrue(OAP.getRoot_ObjectType().getName().equals(svtp.getName()));
		assertTrue("StringVar".equals(svtp.getType()));
		assertTrue(svtp.getChildrenNumber() == 0);
		assertTrue(!svtp.isContainer());
		assertTrue(name.equals(svtp.getVar().get()));

		//		* description 
		assertTrue(svtp.subGoNextSibling() == ISubVarTreePointer.OK);
		assertTrue(OAP.getRoot_Description().getName().equals(svtp.getName()));
		assertTrue("StringVar".equals(svtp.getType()));
		assertTrue(svtp.getChildrenNumber() == 0);
		assertTrue(!svtp.isContainer());
		assertTrue("A simple Desscription".equals(svtp.getVar().get()));

		assertTrue(svtp.subGoNextSibling() == ISubVarTreePointer.ERROR);
		
		/*
		 *  MOVEMENT
		 */
		
		assertTrue(svtp.subGoParent() == ISubVarTreePointer.OK);
		Stack st = new Stack();
		
		st.push(OAP.getRoot_HwList().getName());
		assertTrue(svtp.makeSteps(st) == ISubVarTreePointer.OK);
		assertTrue(OAP.getRoot_HwList().getName().equals(svtp.getName()));
		assertTrue(st.empty());
		
		st.push(DataPath.GO_PARENT);
		assertTrue(svtp.makeSteps(st) == ISubVarTreePointer.OK);
		assertTrue(name.equals(svtp.getName()));
		assertTrue(st.empty());

		// -----------
		
		st.push(OAP.getRoot_ObjectType().getName());
		assertTrue(svtp.makeSteps(st) == ISubVarTreePointer.OK);
		assertTrue(OAP.getRoot_ObjectType().getName().equals(svtp.getName()));
		assertTrue(st.empty());
		
		st.push(DataPath.GO_PARENT);
		assertTrue(svtp.makeSteps(st) == ISubVarTreePointer.OK);
		assertTrue(name.equals(svtp.getName()));
		assertTrue(st.empty());
		
		// -----------
		
		st.push(OAP.getRoot_Description().getName());
		assertTrue(svtp.makeSteps(st) == ISubVarTreePointer.OK);
		assertTrue(OAP.getRoot_Description().getName().equals(svtp.getName()));
		assertTrue(st.empty());
		
		st.push(DataPath.GO_PARENT);
		assertTrue(svtp.makeSteps(st) == ISubVarTreePointer.OK);
		assertTrue(name.equals(svtp.getName()));
		assertTrue(st.empty());
		
		// -----------
		
		st.push(OAP.getRoot_ObjectType().getName());
		assertTrue(svtp.makeSteps(st) == ISubVarTreePointer.OK);
		assertTrue(OAP.getRoot_ObjectType().getName().equals(svtp.getName()));
		assertTrue(st.empty());
		
		st.push(OAP.getRoot_Description().getName());
		st.push(DataPath.GO_PARENT);
		assertTrue(svtp.makeSteps(st) == ISubVarTreePointer.OK);
		assertTrue(OAP.getRoot_Description().getName().equals(svtp.getName()));
		assertTrue(st.empty());
		
		/*
		 * GO_PARENT > BACK_TO_PARENT
		 */
		assertTrue(svtp.subGoParent() == ISubVarTreePointer.OK); // to root
		assertTrue(name.equals(svtp.getName()));
		assertTrue(svtp.subGoParent() == ISubVarTreePointer.BACK_TO_PARENT); // to null
		assertTrue(svtp.getName() == null);
		assertTrue(svtp.subGoParent() == ISubVarTreePointer.ERROR); // error
		assertTrue(svtp.getName() == null);
		
		/*
		 * DESTROY
		 */
		
		st.push(OAP.getRoot_Description().getName());
		st.push(name);
		assertTrue(svtp.makeSteps(st) == ISubVarTreePointer.OK);
		assertTrue(OAP.getRoot_Description().getName().equals(svtp.getName()));
		assertTrue(svtp.getVar() != null);

		assertTrue(svtp.subDestroy() == ISubVarTreePointer.OK);
		assertTrue(name.equals(svtp.getName()));
		
		st.push(OAP.getRoot_Description().getName());
		assertTrue(svtp.makeSteps(st) == ISubVarTreePointer.OK);
		assertTrue(svtp.getVar() == null);
		assertTrue(svtp.subGoParent() == ISubVarTreePointer.OK);
		assertTrue(name.equals(svtp.getName()));
		
		assertTrue(svtp.subDestroy() == ISubVarTreePointer.BACK_TO_PARENT);
		assertTrue(svtp.getName() == null);
		boolean ok = false;
		try {
			svtp.subDestroy();
		} catch (IllegalStateException e) {
			ok = true;
		}
		assertTrue(ok);
		assertTrue(svtp.getName() == null);
		
		/*
		 * CREATE Root with wrong type
		 */
		{
			svtp = (new OilVarMP()).getPointer(VarTreeUtil.newVarTree());
			
			chty = svtp.getNewChildTypes();
			assertTrue(chty.length == 1);
			assertTrue(chty[0].length == 2);
			assertTrue(OAP.getRoot().getName().equals(chty[0][0]));
			assertTrue(null == chty[0][1]);
	
		    assertTrue(name.equals(svtp.add(name, chty[0][0].toUpperCase())));
			assertTrue(svtp.getChildrenNumber() == 1);
		}
		{
			svtp = (new OilVarMP()).getPointer(VarTreeUtil.newVarTree());
			
			chty = svtp.getNewChildTypes();
			assertTrue(chty.length == 1);
			assertTrue(chty[0].length == 2);
			assertTrue(OAP.getRoot().getName().equals(chty[0][0]));
			assertTrue(null == chty[0][1]);
	
		    assertTrue(name.equals(svtp.add(name, chty[0][0].toLowerCase())));
			assertTrue(svtp.getChildrenNumber() == 1);
		}
		
		{
			svtp = (new OilVarMP()).getPointer(VarTreeUtil.newVarTree());
			
			chty = svtp.getNewChildTypes();
			assertTrue(chty.length == 1);
			assertTrue(chty[0].length == 2);
			assertTrue(OAP.getRoot().getName().equals(chty[0][0]));
			assertTrue(null == chty[0][1]);
	
		    assertTrue(name.equals(svtp.add(name, chty[0][0].toUpperCase())));
			assertTrue(svtp.getChildrenNumber() == 1);
	
		    assertTrue(name.equals(svtp.add(name, chty[0][0].toLowerCase())));
			assertTrue(svtp.getChildrenNumber() == 1);
			
			// add more than one root !!
		    assertTrue((name+"2").equals(svtp.add(name + "2", chty[0][0].toLowerCase())));
			assertTrue(svtp.getChildrenNumber() == 2);
		}
		svtp = (new OilVarMP()).getPointer(VarTreeUtil.newVarTree());
		ok = false;
		try {
		    assertTrue(name.equals(svtp.add(name, "")));
		} catch (RuntimeException e) {
		    ok = true;
		    e.printStackTrace();
		}
		assertTrue(ok);
		assertTrue(svtp.getChildrenNumber() == 0);
		
		svtp = (new OilVarMP()).getPointer(VarTreeUtil.newVarTree());
		ok = false;
		try {
		    assertTrue(name.equals(svtp.add(name, (String) null)));
		} catch (RuntimeException e) {
		    ok = true;
		    e.printStackTrace();
		}
		assertTrue(ok);
		assertTrue(svtp.getChildrenNumber() == 0);
		
		{ // add a root with a null ID
			svtp = (new OilVarMP()).getPointer(VarTreeUtil.newVarTree());
		    assertTrue(DataPath.makeSlashedId((String) null).equals(svtp.add(null, chty[0][0])));
			assertTrue(svtp.getChildrenNumber() == 1);
		}
	}

	
	public void testSlashedNames() {
		
		OilVarMP ovm = new OilVarMP();

		ISubVarTreePointer svtp = ovm.getPointer(VarTreeUtil.newVarTree());

        Stack path = new Stack();
        String type = OAP.getRoot().getName();
        
        // -------------- 1 ---------------
        String[] names = {
        		null,
				null
        };
        
        String name = DataPath.makeSlashedId(names);

        String newName = svtp.add(name, type);
        
        assertTrue(DataPath.addSlash(name).equals(newName));
        
        path.push(newName);
        assertTrue(svtp.makeSteps(path) == ISubVarTreePointer.OK);

		
	}
	/** Check HW elements */
	public void testHW() {
		OilVarMP ovm = new OilVarMP();

		ISubVarTreePointer svtp = ovm.getPointer(VarTreeUtil.newVarTree());
		assertTrue(svtp.getChildrenNumber() == 0);
		
		String rootName = "myRoot";
		assertTrue(rootName.equals(svtp.add(rootName, OAP.getRoot().getName())));
		
		assertTrue(svtp.getChildrenNumber() == 1);
		// check root node
		assertTrue(svtp.subGoFirstChild()==ISubVarTreePointer.OK);
		assertTrue(rootName.equals(svtp.getName()));
		assertTrue(OAP.getRoot().getName().equals(svtp.getType()));
		assertTrue(svtp.getChildrenNumber() == 3);
		
		Stack st = new Stack();
		
		// go to HW List  
		st.push(OAP.getRoot_HwList().getName());
		assertTrue(svtp.makeSteps(st) == ISubVarTreePointer.OK);
		assertTrue(OAP.getRoot_HwList().getName().equals(svtp.getName()));
		assertTrue(st.empty());
		
		String chty[][] = svtp.getNewChildTypes();
		
		assertTrue(chty.length == 1);
		assertTrue(chty[0].length == 2);
		assertTrue(OAP.getHW().getName().equals(chty[0][0]));
		assertTrue(null == chty[0][1]);

		/*
		 *  add one new node, move on it and remove it
		 */ 
		assertTrue(svtp.getChildrenNumber() == 0);
		String name1 = "myHW_1";
		{
			assertTrue(name1.equals(svtp.add(name1, chty[0][0])));
			assertTrue(svtp.getChildrenNumber() == 1);
			assertTrue(svtp.subGoFirstChild() == ISubVarTreePointer.OK);
			
			assertTrue(name1.equals(svtp.getName()));
			assertTrue(OAP.getHW().getName().equals(svtp.getType()));
			assertTrue(svtp.getChildrenNumber() == 3);
			
			//  cycle all children
			//		* RTOS_List
			assertTrue(svtp.subGoFirstChild() == ISubVarTreePointer.OK);
			assertTrue(OAP.getHW_RtosList().getName().equals(svtp.getName()));
			assertTrue(OAP.getHW_RtosList().getName().equals(svtp.getType()));
			assertTrue(svtp.getChildrenNumber() == 0);
			assertTrue(svtp.isContainer());
			assertTrue(svtp.subGoFirstChild() == ISubVarTreePointer.ERROR);

			//		* Name
			assertTrue(svtp.subGoNextSibling() == ISubVarTreePointer.OK);
			assertTrue(OAP.getHW_Name().getName().equals(svtp.getName()));
			assertTrue("StringVar".equals(svtp.getType()));
			assertTrue(svtp.getChildrenNumber() == 0);
			assertTrue(!svtp.isContainer());
			assertTrue(name1.equals(svtp.getVar().get()));

			//		* description // is empty !!!!
			assertTrue(svtp.subGoNextSibling() == ISubVarTreePointer.OK);
			assertTrue(OAP.getHW_Description().getName().equals(svtp.getName()));
			assertTrue("StringVar".equals(svtp.getType()));
			assertTrue(svtp.getChildrenNumber() == 0);
			assertTrue(!svtp.isContainer());
			assertTrue(svtp.getVar() == null);
			assertTrue(svtp.subGoNextSibling() == ISubVarTreePointer.ERROR);

			assertTrue(svtp.subGoParent() == ISubVarTreePointer.OK);
			
			// cycle again : add a Description
			assertTrue(OAP.getHW_Description().getName().equals(
					svtp.add(OAP.getHW_Description().getName(), new StringVar(
							"A simple Desscription"))));

			//		* RTOS_List
			assertTrue(svtp.subGoFirstChild() == ISubVarTreePointer.OK);
			assertTrue(OAP.getHW_RtosList().getName().equals(svtp.getName()));
			assertTrue(OAP.getHW_RtosList().getName().equals(svtp.getType()));
			assertTrue(svtp.getChildrenNumber() == 0);
			assertTrue(svtp.isContainer());
			assertTrue(svtp.subGoFirstChild() == ISubVarTreePointer.ERROR);

			//		* Name
			assertTrue(svtp.subGoNextSibling() == ISubVarTreePointer.OK);
			assertTrue(OAP.getHW_Name().getName().equals(svtp.getName()));
			assertTrue("StringVar".equals(svtp.getType()));
			assertTrue(svtp.getChildrenNumber() == 0);
			assertTrue(!svtp.isContainer());
			assertTrue(name1.equals(svtp.getVar().get()));

			//		* description 
			assertTrue(svtp.subGoNextSibling() == ISubVarTreePointer.OK);
			assertTrue(OAP.getHW_Description().getName().equals(svtp.getName()));
			assertTrue("StringVar".equals(svtp.getType()));
			assertTrue(svtp.getChildrenNumber() == 0);
			assertTrue(!svtp.isContainer());
			assertTrue("A simple Desscription".equals(svtp.getVar().get()));

			assertTrue(svtp.subGoNextSibling() == ISubVarTreePointer.ERROR);
			
			/*
			 *  MOVEMENT
			 */
			
			assertTrue(svtp.subGoParent() == ISubVarTreePointer.OK);
			st = new Stack();
			
			st.push(OAP.getHW_RtosList().getName());
			assertTrue(svtp.makeSteps(st) == ISubVarTreePointer.OK);
			assertTrue(OAP.getHW_RtosList().getName().equals(svtp.getName()));
			assertTrue(st.empty());
			
			st.push(DataPath.GO_PARENT);
			assertTrue(svtp.makeSteps(st) == ISubVarTreePointer.OK);
			assertTrue(name1.equals(svtp.getName()));
			assertTrue(st.empty());

			// -----------
			
			st.push(OAP.getHW_Name().getName());
			assertTrue(svtp.makeSteps(st) == ISubVarTreePointer.OK);
			assertTrue(OAP.getHW_Name().getName().equals(svtp.getName()));
			assertTrue(st.empty());
			
			st.push(DataPath.GO_PARENT);
			assertTrue(svtp.makeSteps(st) == ISubVarTreePointer.OK);
			assertTrue(name1.equals(svtp.getName()));
			assertTrue(st.empty());
			
			// -----------
			
			st.push(OAP.getHW_Description().getName());
			assertTrue(svtp.makeSteps(st) == ISubVarTreePointer.OK);
			assertTrue(OAP.getHW_Description().getName().equals(svtp.getName()));
			assertTrue(st.empty());
			
			st.push(DataPath.GO_PARENT);
			assertTrue(svtp.makeSteps(st) == ISubVarTreePointer.OK);
			assertTrue(name1.equals(svtp.getName()));
			assertTrue(st.empty());
			
			// -----------
			
			st.push(OAP.getHW_Name().getName());
			assertTrue(svtp.makeSteps(st) == ISubVarTreePointer.OK);
			assertTrue(OAP.getHW_Name().getName().equals(svtp.getName()));
			assertTrue(st.empty());
			
			st.push(OAP.getHW_Description().getName());
			st.push(DataPath.GO_PARENT);
			assertTrue(svtp.makeSteps(st) == ISubVarTreePointer.OK);
			assertTrue(OAP.getHW_Description().getName().equals(svtp.getName()));
			assertTrue(st.empty());
			
			// ---------------
			assertTrue(svtp.subGoParent() == ISubVarTreePointer.OK);
			assertTrue(name1.equals(svtp.getName()));
			assertTrue(svtp.subGoParent() == ISubVarTreePointer.OK);
			assertTrue(OAP.getRoot_HwList().getName().equals(svtp.getName()));
		}
		
		assertTrue(OAP.getRoot_HwList().getName().equals(svtp.getName()));
		assertTrue(svtp.getChildrenNumber() == 1);
		String name2 = "myHW_2";
		{
			assertTrue(name2.equals(svtp.add(name2, OAP.getHW().getName())));
			assertTrue(svtp.getChildrenNumber() == 2);
			assertTrue(svtp.subGoFirstChild() == ISubVarTreePointer.OK);
			
			assertTrue(name1.equals(svtp.getName()));
			assertTrue(OAP.getHW().getName().equals(svtp.getType()));
			assertTrue(svtp.getChildrenNumber() == 3);
			assertTrue(svtp.subGoNextSibling() == ISubVarTreePointer.OK);
			
			assertTrue(name2.equals(svtp.getName()));
			assertTrue(OAP.getHW().getName().equals(svtp.getType()));
			assertTrue(svtp.getChildrenNumber() == 3);
			assertTrue(svtp.subGoNextSibling() == ISubVarTreePointer.ERROR);
			
			assertTrue(svtp.subGoParent() == ISubVarTreePointer.OK);
		}
		
		assertTrue(OAP.getRoot_HwList().getName().equals(svtp.getName()));
		assertTrue(svtp.getChildrenNumber() == 2);
		String name3 = "myHW_3";
		{
			assertTrue(name3.equals(svtp.add(name3, OAP.getHW().getName())));
			assertTrue(svtp.getChildrenNumber() == 3);

			
			st = new Stack();
			st.push(name2);
			assertTrue(svtp.makeSteps(st) == ISubVarTreePointer.OK);
			assertTrue(name2.equals(svtp.getName()));
			assertTrue(st.empty());

			st.push(name1);
			st.push(DataPath.GO_PARENT);
			assertTrue(svtp.makeSteps(st) == ISubVarTreePointer.OK);
			assertTrue(name1.equals(svtp.getName()));
			assertTrue(st.empty());
			
			st.push(name3);
			st.push(DataPath.GO_PARENT);
			assertTrue(svtp.makeSteps(st) == ISubVarTreePointer.OK);
			assertTrue(name3.equals(svtp.getName()));
			assertTrue(st.empty());
			
			assertTrue(svtp.subGoParent() == ISubVarTreePointer.OK);
		}
		
		// DESTROY
		
		{
			st.push(name2);
			assertTrue(svtp.makeSteps(st) == ISubVarTreePointer.OK);
			assertTrue(name2.equals(svtp.getName()));
			assertTrue(st.empty());
			assertTrue(svtp.subDestroy() == ISubVarTreePointer.OK);
			assertTrue(OAP.getRoot_HwList().getName().equals(svtp.getName()));
			assertTrue(svtp.getChildrenNumber() == 2);
		}
		
		{
			st.push(name3);
			assertTrue(svtp.makeSteps(st) == ISubVarTreePointer.OK);
			assertTrue(name3.equals(svtp.getName()));
			assertTrue(st.empty());
			assertTrue(svtp.subDestroy() == ISubVarTreePointer.OK);
			assertTrue(OAP.getRoot_HwList().getName().equals(svtp.getName()));
			assertTrue(svtp.getChildrenNumber() == 1);
		}
		
		{
			st.push(name1);
			assertTrue(svtp.makeSteps(st) == ISubVarTreePointer.OK);
			assertTrue(name1.equals(svtp.getName()));
			assertTrue(st.empty());
			assertTrue(svtp.subGoNextSibling() == ISubVarTreePointer.ERROR);
			
			assertTrue(svtp.subDestroy() == ISubVarTreePointer.OK);
			assertTrue(OAP.getRoot_HwList().getName().equals(svtp.getName()));
			assertTrue(svtp.getChildrenNumber() == 0);
			assertTrue(svtp.subGoFirstChild() == ISubVarTreePointer.ERROR);
		}

		// Create new HW with wrong type
	    String name = "n";
		{
			assertTrue(OAP.getRoot_HwList().getName().equals(svtp.getName()));
		    assertTrue(name.equals(svtp.add(name, OAP.getHW().getName().toUpperCase())));
			assertTrue(svtp.getChildrenNumber() == 1);
			
			// clear
			assertTrue(svtp.subGoFirstChild() == ISubVarTreePointer.OK);
			assertTrue(svtp.subDestroy() == ISubVarTreePointer.OK);
			assertTrue(OAP.getRoot_HwList().getName().equals(svtp.getName()));
			assertTrue(svtp.getChildrenNumber() == 0);
		}
		{
			assertTrue(OAP.getRoot_HwList().getName().equals(svtp.getName()));
		    assertTrue(name.equals(svtp.add(name, OAP.getHW().getName().toLowerCase())));
			assertTrue(svtp.getChildrenNumber() == 1);
			
			// clear
			assertTrue(svtp.subGoFirstChild() == ISubVarTreePointer.OK);
			assertTrue(svtp.subDestroy() == ISubVarTreePointer.OK);
			assertTrue(OAP.getRoot_HwList().getName().equals(svtp.getName()));
			assertTrue(svtp.getChildrenNumber() == 0);
		}
		
		{
			assertTrue(OAP.getRoot_HwList().getName().equals(svtp.getName()));
		    assertTrue(name.equals(svtp.add(name, OAP.getHW().getName().toUpperCase())));
			assertTrue(svtp.getChildrenNumber() == 1);
			
			assertTrue(OAP.getRoot_HwList().getName().equals(svtp.getName()));
		    assertTrue(name.equals(svtp.add(name, OAP.getHW().getName().toUpperCase())));
			assertTrue(svtp.getChildrenNumber() == 1);
			
			assertTrue(OAP.getRoot_HwList().getName().equals(svtp.getName()));
		    assertTrue(name.equals(svtp.add(name, OAP.getHW().getName().toLowerCase())));
			assertTrue(svtp.getChildrenNumber() == 1);
			
			assertTrue(OAP.getRoot_HwList().getName().equals(svtp.getName()));
		    assertTrue(name.equals(svtp.add(name, OAP.getHW().getName())));
			assertTrue(svtp.getChildrenNumber() == 1);

			assertTrue(OAP.getRoot_HwList().getName().equals(svtp.getName()));
		    assertTrue((name+"2").equals(svtp.add((name+"2"), OAP.getHW().getName())));
			assertTrue(svtp.getChildrenNumber() == 2);
		}

		boolean ok = false;
		try {
		    assertTrue(name.equals(svtp.add(name, "")));
		} catch (RuntimeException e) {
		    ok = true;
		    e.printStackTrace();
		}
		assertTrue(ok);
		assertTrue(svtp.getChildrenNumber() == 2);
		
		ok = false;
		try {
		    assertTrue(name.equals(svtp.add(name, (String) null)));
		} catch (RuntimeException e) {
		    ok = true;
		    e.printStackTrace();
		}
		assertTrue(ok);
		assertTrue(svtp.getChildrenNumber() == 2);
		
		{ // add a child with a null ID
		    assertTrue(DataPath.makeSlashedId((String) null).equals(svtp.add(null, chty[0][0])));
			assertTrue(svtp.getChildrenNumber() == 3);
		}
		
		
	}

	/** Check RT-OS elements */
	public void testRTOS() {
		OilVarMP ovm = new OilVarMP();

		ISubVarTreePointer svtp = ovm.getPointer(VarTreeUtil.newVarTree());
		assertTrue(svtp.getChildrenNumber() == 0);
		
		String rootName = "my Root";
		assertTrue(rootName.equals(svtp.add(rootName, OAP.getRoot().getName())));
		
		assertTrue(svtp.getChildrenNumber() == 1);
		// check root node
		assertTrue(svtp.subGoFirstChild()==ISubVarTreePointer.OK);
		assertTrue(rootName.equals(svtp.getName()));
		assertTrue(OAP.getRoot().getName().equals(svtp.getType()));
		assertTrue(svtp.getChildrenNumber() == 3);
		
		Stack st = new Stack();
		
		// go to HW List  
		st.push(OAP.getRoot_HwList().getName());
		assertTrue(svtp.makeSteps(st) == ISubVarTreePointer.OK);
		assertTrue(OAP.getRoot_HwList().getName().equals(svtp.getName()));
		assertTrue(st.empty());

		// add a new HW
		String hwName = "my HW";
		assertTrue(hwName.equals(svtp.add(hwName, OAP.getHW().getName())));
		assertTrue(svtp.getChildrenNumber() == 1);
		// go to RTOS List  
		st.push(OAP.getHW_RtosList().getName());
		st.push(hwName);
		assertTrue(svtp.makeSteps(st) == ISubVarTreePointer.OK);
		assertTrue(OAP.getHW_RtosList().getName().equals(svtp.getName()));
		
		// check types
		String chty[][] = svtp.getNewChildTypes();
		
		assertTrue(chty.length == 1);
		assertTrue(chty[0].length == 2);
		assertTrue(OAP.getRTOS().getName().equals(chty[0][0]));
		assertTrue(null == chty[0][1]);

		/*
		 *  add one new node, move on it and remove it
		 */ 
		assertTrue(svtp.getChildrenNumber() == 0);
		String name1 = "my RTOS 1";
		{
			assertTrue(name1.equals(svtp.add(name1, chty[0][0])));
			assertTrue(svtp.getChildrenNumber() == 1);
			assertTrue(svtp.subGoFirstChild() == ISubVarTreePointer.OK);
			
			assertTrue(name1.equals(svtp.getName()));
			assertTrue(OAP.getRTOS().getName().equals(svtp.getType()));
			assertTrue(svtp.getChildrenNumber() == 3);
			
			//  cycle all children
			//		* Parameter_List
			assertTrue(svtp.subGoFirstChild() == ISubVarTreePointer.OK);
			assertTrue(OAP.getRTOS_ParameterList().getName().equals(svtp.getName()));
			assertTrue(OAP.getRTOS_ParameterList().getName().equals(svtp.getType()));
			assertTrue(svtp.getChildrenNumber() == 0);
			assertTrue(svtp.isContainer());
			assertTrue(svtp.subGoFirstChild() == ISubVarTreePointer.ERROR);

			//		* NAME
			assertTrue(svtp.subGoNextSibling() == ISubVarTreePointer.OK);
			assertTrue(OAP.getRTOS_Name().getName().equals(svtp.getName()));
			assertTrue("StringVar".equals(svtp.getType()));
			assertTrue(svtp.getChildrenNumber() == 0);
			assertTrue(!svtp.isContainer());
			assertTrue(name1.equals(svtp.getVar().get()));

			//		* description // is empty !!!!
			assertTrue(svtp.subGoNextSibling() == ISubVarTreePointer.OK);
			assertTrue(OAP.getRTOS_Description().getName().equals(svtp.getName()));
			assertTrue("StringVar".equals(svtp.getType()));
			assertTrue(svtp.getChildrenNumber() == 0);
			assertTrue(!svtp.isContainer());
			assertTrue(svtp.getVar() == null);
			assertTrue(svtp.subGoNextSibling() == ISubVarTreePointer.ERROR);

			assertTrue(svtp.subGoParent() == ISubVarTreePointer.OK);
			
			// cycle again : add a Description
			assertTrue(OAP.getRTOS_Description().getName().equals(
					svtp.add(OAP.getRTOS_Description().getName(), new StringVar(
							"A simple Desscription"))));

			//		* Parameter_list
			assertTrue(svtp.subGoFirstChild() == ISubVarTreePointer.OK);
			assertTrue(OAP.getRTOS_ParameterList().getName().equals(svtp.getName()));
			assertTrue(OAP.getRTOS_ParameterList().getName().equals(svtp.getType()));
			assertTrue(svtp.getChildrenNumber() == 0);
			assertTrue(svtp.isContainer());
			assertTrue(svtp.subGoFirstChild() == ISubVarTreePointer.ERROR);

			//		* Name
			assertTrue(svtp.subGoNextSibling() == ISubVarTreePointer.OK);
			assertTrue(OAP.getRTOS_Name().getName().equals(svtp.getName()));
			assertTrue("StringVar".equals(svtp.getType()));
			assertTrue(svtp.getChildrenNumber() == 0);
			assertTrue(!svtp.isContainer());
			assertTrue(name1.equals(svtp.getVar().get()));

			//		* description 
			assertTrue(svtp.subGoNextSibling() == ISubVarTreePointer.OK);
			assertTrue(OAP.getRTOS_Description().getName().equals(svtp.getName()));
			assertTrue("StringVar".equals(svtp.getType()));
			assertTrue(svtp.getChildrenNumber() == 0);
			assertTrue(!svtp.isContainer());
			assertTrue("A simple Desscription".equals(svtp.getVar().get()));

			assertTrue(svtp.subGoNextSibling() == ISubVarTreePointer.ERROR);
			
			/*
			 *  MOVEMENT
			 */
			
			assertTrue(svtp.subGoParent() == ISubVarTreePointer.OK);
			st = new Stack();
			
			st.push(OAP.getRTOS_ParameterList().getName());
			assertTrue(svtp.makeSteps(st) == ISubVarTreePointer.OK);
			assertTrue(OAP.getRTOS_ParameterList().getName().equals(svtp.getName()));
			assertTrue(st.empty());
			
			st.push(DataPath.GO_PARENT);
			assertTrue(svtp.makeSteps(st) == ISubVarTreePointer.OK);
			assertTrue(name1.equals(svtp.getName()));
			assertTrue(st.empty());

			// -----------
			
			st.push(OAP.getRTOS_Name().getName());
			assertTrue(svtp.makeSteps(st) == ISubVarTreePointer.OK);
			assertTrue(OAP.getRTOS_Name().getName().equals(svtp.getName()));
			assertTrue(st.empty());
			
			st.push(DataPath.GO_PARENT);
			assertTrue(svtp.makeSteps(st) == ISubVarTreePointer.OK);
			assertTrue(name1.equals(svtp.getName()));
			assertTrue(st.empty());
			
			// -----------
			
			st.push(OAP.getRTOS_Description().getName());
			assertTrue(svtp.makeSteps(st) == ISubVarTreePointer.OK);
			assertTrue(OAP.getRTOS_Description().getName().equals(svtp.getName()));
			assertTrue(st.empty());
			
			st.push(DataPath.GO_PARENT);
			assertTrue(svtp.makeSteps(st) == ISubVarTreePointer.OK);
			assertTrue(name1.equals(svtp.getName()));
			assertTrue(st.empty());
			
			// -----------
			
			st.push(OAP.getRTOS_Name().getName());
			assertTrue(svtp.makeSteps(st) == ISubVarTreePointer.OK);
			assertTrue(OAP.getRTOS_Name().getName().equals(svtp.getName()));
			assertTrue(st.empty());
			
			st.push(OAP.getRTOS_Description().getName());
			st.push(DataPath.GO_PARENT);
			assertTrue(svtp.makeSteps(st) == ISubVarTreePointer.OK);
			assertTrue(OAP.getRTOS_Description().getName().equals(svtp.getName()));
			assertTrue(st.empty());
			
			// ---------------
			assertTrue(svtp.subGoParent() == ISubVarTreePointer.OK);
			assertTrue(name1.equals(svtp.getName()));
			assertTrue(svtp.subGoParent() == ISubVarTreePointer.OK);
			assertTrue(OAP.getHW_RtosList().getName().equals(svtp.getName()));
		}
		
		assertTrue(OAP.getHW_RtosList().getName().equals(svtp.getName()));
		assertTrue(svtp.getChildrenNumber() == 1);
		String name2 = "my RTOS 2";
		{
			assertTrue(name2.equals(svtp.add(name2, OAP.getRTOS().getName())));
			assertTrue(svtp.getChildrenNumber() == 2);
			assertTrue(svtp.subGoFirstChild() == ISubVarTreePointer.OK);
			
			assertTrue(name1.equals(svtp.getName()));
			assertTrue(OAP.getRTOS().getName().equals(svtp.getType()));
			assertTrue(svtp.getChildrenNumber() == 3);
			assertTrue(svtp.subGoNextSibling() == ISubVarTreePointer.OK);
			
			assertTrue(name2.equals(svtp.getName()));
			assertTrue(OAP.getRTOS().getName().equals(svtp.getType()));
			assertTrue(svtp.getChildrenNumber() == 3);
			assertTrue(svtp.subGoNextSibling() == ISubVarTreePointer.ERROR);
			
			assertTrue(svtp.subGoParent() == ISubVarTreePointer.OK);
		}
		
		assertTrue(OAP.getHW_RtosList().getName().equals(svtp.getName()));
		assertTrue(svtp.getChildrenNumber() == 2);
		String name3 = "my RTOS 3";
		{
			assertTrue(name3.equals(svtp.add(name3, OAP.getRTOS().getName())));
			assertTrue(svtp.getChildrenNumber() == 3);

			
			st = new Stack();
			st.push(name2);
			assertTrue(svtp.makeSteps(st) == ISubVarTreePointer.OK);
			assertTrue(name2.equals(svtp.getName()));
			assertTrue(st.empty());

			st.push(name1);
			st.push(DataPath.GO_PARENT);
			assertTrue(svtp.makeSteps(st) == ISubVarTreePointer.OK);
			assertTrue(name1.equals(svtp.getName()));
			assertTrue(st.empty());
			
			st.push(name3);
			st.push(DataPath.GO_PARENT);
			assertTrue(svtp.makeSteps(st) == ISubVarTreePointer.OK);
			assertTrue(name3.equals(svtp.getName()));
			assertTrue(st.empty());
			
			assertTrue(svtp.subGoParent() == ISubVarTreePointer.OK);
		}
		
		// DESTROY
		
		{
			st.push(name2);
			assertTrue(svtp.makeSteps(st) == ISubVarTreePointer.OK);
			assertTrue(name2.equals(svtp.getName()));
			assertTrue(st.empty());
			assertTrue(svtp.subDestroy() == ISubVarTreePointer.OK);
			assertTrue(OAP.getHW_RtosList().getName().equals(svtp.getName()));
			assertTrue(svtp.getChildrenNumber() == 2);
		}
		
		{
			st.push(name3);
			assertTrue(svtp.makeSteps(st) == ISubVarTreePointer.OK);
			assertTrue(name3.equals(svtp.getName()));
			assertTrue(st.empty());
			assertTrue(svtp.subDestroy() == ISubVarTreePointer.OK);
			assertTrue(OAP.getHW_RtosList().getName().equals(svtp.getName()));
			assertTrue(svtp.getChildrenNumber() == 1);
		}
		
		{
			st.push(name1);
			assertTrue(svtp.makeSteps(st) == ISubVarTreePointer.OK);
			assertTrue(name1.equals(svtp.getName()));
			assertTrue(st.empty());
			assertTrue(svtp.subGoNextSibling() == ISubVarTreePointer.ERROR);
			
			assertTrue(svtp.subDestroy() == ISubVarTreePointer.OK);
			assertTrue(OAP.getHW_RtosList().getName().equals(svtp.getName()));
			assertTrue(svtp.getChildrenNumber() == 0);
			assertTrue(svtp.subGoFirstChild() == ISubVarTreePointer.ERROR);
		}

		// Create new HW with wrong type
	    String name = "n";
		{
			assertTrue(OAP.getHW_RtosList().getName().equals(svtp.getName()));
		    assertTrue(name.equals(svtp.add(name, OAP.getRTOS().getName().toUpperCase())));
			assertTrue(svtp.getChildrenNumber() == 1);
			
			// clear
			assertTrue(svtp.subGoFirstChild() == ISubVarTreePointer.OK);
			assertTrue(svtp.subDestroy() == ISubVarTreePointer.OK);
			assertTrue(OAP.getHW_RtosList().getName().equals(svtp.getName()));
			assertTrue(svtp.getChildrenNumber() == 0);
		}
		{
			assertTrue(OAP.getHW_RtosList().getName().equals(svtp.getName()));
		    assertTrue(name.equals(svtp.add(name, OAP.getRTOS().getName().toLowerCase())));
			assertTrue(svtp.getChildrenNumber() == 1);
			
			// clear
			assertTrue(svtp.subGoFirstChild() == ISubVarTreePointer.OK);
			assertTrue(svtp.subDestroy() == ISubVarTreePointer.OK);
			assertTrue(OAP.getHW_RtosList().getName().equals(svtp.getName()));
			assertTrue(svtp.getChildrenNumber() == 0);
		}
		
		{
			assertTrue(OAP.getHW_RtosList().getName().equals(svtp.getName()));
		    assertTrue(name.equals(svtp.add(name, OAP.getRTOS().getName().toUpperCase())));
			assertTrue(svtp.getChildrenNumber() == 1);
			
			assertTrue(OAP.getHW_RtosList().getName().equals(svtp.getName()));
		    assertTrue(name.equals(svtp.add(name, OAP.getRTOS().getName().toUpperCase())));
			assertTrue(svtp.getChildrenNumber() == 1);
			
			assertTrue(OAP.getHW_RtosList().getName().equals(svtp.getName()));
		    assertTrue(name.equals(svtp.add(name, OAP.getRTOS().getName().toLowerCase())));
			assertTrue(svtp.getChildrenNumber() == 1);
			
			assertTrue(OAP.getHW_RtosList().getName().equals(svtp.getName()));
		    assertTrue(name.equals(svtp.add(name, OAP.getRTOS().getName())));
			assertTrue(svtp.getChildrenNumber() == 1);

			assertTrue(OAP.getHW_RtosList().getName().equals(svtp.getName()));
		    assertTrue((name+"2").equals(svtp.add((name+"2"), OAP.getRTOS().getName())));
			assertTrue(svtp.getChildrenNumber() == 2);
		}

		boolean ok = false;
		try {
		    assertTrue(name.equals(svtp.add(name, "")));
		} catch (RuntimeException e) {
		    ok = true;
		    e.printStackTrace();
		}
		assertTrue(ok);
		assertTrue(svtp.getChildrenNumber() == 2);
		
		ok = false;
		try {
		    assertTrue(name.equals(svtp.add(name, (String) null)));
		} catch (RuntimeException e) {
		    ok = true;
		    e.printStackTrace();
		}
		assertTrue(ok);
		assertTrue(svtp.getChildrenNumber() == 2);
		
		{ // add a child with a null ID
		    assertTrue(DataPath.makeSlashedId((String) null).equals(svtp.add(null, OAP.getRTOS().getName())));
			assertTrue(svtp.getChildrenNumber() == 3);
		}
		
		
	}

	
	
	public void testGoParent() {
		/* 
		 * osservare come si comporta quando si va su e giu, dentro e fuori dall'oil
		 */
	}

	public void testGoGetChild() {
		/* 
		 * osservare se i tipi sono sempre quelli corretti
		 */
	}
	
	public void testPath() {
		/* 
		 * osservare se il path e' quello corretto,
		 * sia usando spostamenti senza nome (go...)
		 * sia usando spostamenti con nome (makeAStep)
		 */
	}
}
