/*
 * Created on 2-set-2005
 *
 * $Id: VarTreeTest.java,v 1.1 2005/09/28 15:22:29 durin Exp $
 */
package com.eu.evidence.rtdruid.test.vartree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.junit.Test;

import com.eu.evidence.rtdruid.io.RTD_XMI_Factory;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.VarTreeUtil;

/**
 * @author Nicola Serreli
 */
public class VarTreeTest {

    /*
     * Class under test for void VarTree()
     */
	@Test
	public void testVarTree() {
        
        IVarTree vt = VarTreeUtil.newVarTree();
        assertNotNull(vt);
        
        assertNotNull(vt.newTreeInterface());
        assertNotNull(vt.newVarTreePointer());
    }

    /*
     * Class under test for void VarTree()
     */
	@Test
	public void testVarTreeWithParameters() {
        IVarTree vt = VarTreeUtil.newVarTree( new BasicCommandStack() );
        assertNotNull(vt);
        
        assertNotNull(vt.newTreeInterface());
        
        // cannot get a VTP if there isn't any resource
        assertEquals(vt.getResourceSet().getResources().size(), 0);        
        boolean ok = false;
        try {
        	assertTrue(vt.newVarTreePointer() == null);
        } catch (IndexOutOfBoundsException e) {
        	ok = true;
        }
        assertTrue(ok);

        vt.getResourceSet().getResources().add(new RTD_XMI_Factory().createResource());
        assertNotNull(vt.newVarTreePointer());
    }

}
