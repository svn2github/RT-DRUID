/*
 * Created on 2-set-2005
 *
 * $Id: VarTreeTest.java,v 1.1 2005/09/28 15:22:29 durin Exp $
 */
package com.eu.evidence.rtdruid.test.vartree;

import junit.framework.TestCase;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.CommandStack;

import com.eu.evidence.rtdruid.desk.RTDFactory;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.data.init.RTD_XMI_Factory;

/**
 * 
 * TODO : Commentare && Tradurre
 * 
 * @author Nicola Serreli
 */
public class VarTreeTest extends TestCase {

    /*
     * Class under test for void VarTree()
     */
    public void testVarTree() {
        
        IVarTree vt = (IVarTree) RTDFactory.get(IVarTree.class);
        assertTrue(vt != null);
        
        assertTrue(vt.newTreeInterface() != null);
        assertTrue(vt.newVarTreePointer() != null);
    }

    /*
     * Class under test for void VarTree()
     */
    public void testVarTreeWithParameters() {
        class MyClass extends BasicCommandStack {
            public MyClass() {}
        };
        IVarTree vt = (IVarTree) RTDFactory.get(IVarTree.class, new Class[] {CommandStack.class}, new Object[] { new MyClass() });
        assertTrue(vt != null);
        
        assertTrue(vt.newTreeInterface() != null);
        boolean ok = false;
        try {
        	assertTrue(vt.newVarTreePointer() == null);
        } catch (Exception e) {
        	ok = true;
        }
        assertTrue(ok);

        vt.getResourceSet().getResources().add(new RTD_XMI_Factory().createResource());
        assertTrue(vt.newVarTreePointer() != null);
    }

}
