/*
 * Created on 2-set-2005
 *
 * $Id: IVarTree.java,v 1.5 2008/03/26 18:23:51 durin Exp $
 */
package com.eu.evidence.rtdruid.vartree;


import java.util.HashMap;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.vartree.IAdapterFactoryEditingDomain;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTreePointer;

/**
 * This interface is the used to contain every data.
 * 
 *  Use RTDFactory to get a new instance of IVarTree
 * 
 * @author Nicola Serreli
 */
public interface IVarTree extends IAdapterFactoryEditingDomain {
    // ---------------------- COSTANTI ----------------------

    /**
     * This class is a fast way to build an transaction
     */
    public abstract class AbstractTransaction {
        
        /** The tree */
        public final IVarTree vt;
        
        /** The transaction name */
        public final String tName;
        
        /** 
         * Make a new "worker".
         * 
         * use "run" method to execute the transaction.
         */
        public AbstractTransaction(IVarTree vt) {
            this(vt, null);
        }
        
        /** 
         * Make a new "worker".
         * 
         * use "run" method to execute the transaction.
         * 
         * if is specified a not null name, it's used if is builded a new transaction.
         */
        public AbstractTransaction(IVarTree vt, String name) {
            if (vt == null) {
                throw new NullPointerException();
            }
            this.vt = vt;
            
            this.tName = name;
        }
        
        
        /**
         * This method ensure that the code of "doRun" method is protected by a transaction.
         */
        public final void run() {
		    final boolean aNewTransaction = vt.getCurrentTransaction() == null;
		    
		    if (aNewTransaction) {
		        CompoundCommand command = vt.beginTransaction();
		        if (tName != null) {
		            command.setLabel(tName);
		        }
		    }
		    try {

		        doRun();
	
		    } catch (RuntimeException e) {
		    	RtdruidLog.showDebug(e);
			    if (aNewTransaction) {
			        vt.rollbackTransaction();
			    }
			    throw e;
		        
		    } finally {
			    if (aNewTransaction) {
			        vt.commitTransaction();
			    }
	
		    }
        }
        
        protected abstract void doRun();
		    
    }
    /**
     * Special character used to separate the name of a Element and the name of
     * its child
     */
    final static public char SEPARATOR = DataPath.SEPARATOR;

    /** Special character used to protect all special characters */
    final static public char PROTECTOR = DataPath.PROTECTOR;

    /**
     * Destroys the tree and replace it with a new tree.
     */
    public void clear();

    // ---------------------- FACTORY ----------------------
    public IVarTreePointer newVarTreePointer();

    /**
     * Makes a {@link com.eu.evidence.rtdruid.vartree.IVarTreePointer IVarTreePointer}to visit
     * the tree. The start point is the root Element.
     * 
     * @return a pointer to the root node.
     */
    public ITreeInterface newTreeInterface();

    //private int transactionNumber = 0;
    public CompoundCommand beginTransaction();

    /**
     * Commit the transaction
     */
    public void commitTransaction();

    /**
     * Rollback the transaction
     */
    public void rollbackTransaction();

    /**
     * Return the command the contains the current transaction or null if no
     * transactions are running
     * 
     * @return the command the contains the current transaction or null if there
     *         isn't any transaction
     */
    public CompoundCommand getCurrentTransaction();

    //  ---------------------- ROOT ----------------------
    public void setRoot(EObject newRoot);
    /**
	 * Replace the old tree with the new one.
	 * 
	 * IMPORTANT : this operation cannot be undone and reset any transaction
	 * 
	 * @param newRoot
	 *            the new tree
	 */
    public void setRoot(Resource newRoot);

    /*
     * public EList getRoot () { return ((Resource)
     * resourceSet.getResources().get(0)).getContents(); }
     */
    public HashMap<String, Object> getProperties();

     
     public interface IThreadMonitor {

         /**
          * Try to lock the current thread. See also
          * {@link #unlock() unlock() method}.
          * 
          * @return true if the current thread was not locked, false otherwise
          */
         public boolean lock();

         /**
          * A thread can ask to "unlock/unproctect" only itself
          * 
          * @throws RuntimeException
          *             if try to unlock a not locked thread
          */
         public void unlock();

         public void kill(Thread newThread);

     }

    public abstract IThreadMonitor getThreadMonitor();
}