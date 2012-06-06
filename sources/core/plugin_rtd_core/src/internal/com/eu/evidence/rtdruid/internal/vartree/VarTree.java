package com.eu.evidence.rtdruid.internal.vartree;


import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;

import com.eu.evidence.rtdruid.internal.vartree.data.provider.DataItemProviderAdapterFactory;
import com.eu.evidence.rtdruid.io.RTD_XMI_Factory;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVarTreePointer;
import com.eu.evidence.rtdruid.vartree.VarTreePointerEMF;


/**
 * VarTree implements an editing domain that contains: <br>
 * a tree of shared variables <br>
 * a command stack <br>
 * an adapter Factory (useful to make new nodes). <br>
 * <br>
 * Each variables is identify by a unambiguous path. <br>
 * VarTree is not more a singletone. <br>
 * <br>
 * 
 * A right <b><i>path </i> </b> is :<br>
 * <b><i>child_name </i>[. <i>path <i>] </b> <br>
 * Where :<b><i>child_name </i> </b> is a generic string without the special
 * separator character (see {@link com.eu.evidence.rtdruid.vartree.IVarTree#SEPARATOR SEPARATOR})
 * or the {@link com.eu.evidence.rtdruid.vartree.ITreeInterface#SPECIAL special character}used
 * in rtdruid.vartree.TreeInterface; <br>
 * &nbsp;&nbsp;&nbsp;&nbsp; <b><i>. </i> </b> represent the special separator
 * character (see {@link com.eu.evidence.rtdruid.vartree.IVarTree#SEPARATOR SEPARATOR});
 * 
 * @author Nicola Serreli
 * @see com.eu.evidence.rtdruid.vartree.DataPath
 */
final public class VarTree extends AdapterFactoryEditingDomain implements IVarTree {

    // ---------------------- COSTANTI ----------------------

    protected final HashMap<String, Object> properties = new HashMap<String, Object>();

    /**
     * Create an instance from the adapter factory, and the specialized command
     * stack.
     */
    public VarTree(CommandStack commandStack) {
        super(getFactories(), commandStack);
    }

    /**
     * Create an instance from the adapter factory, and the specialized command
     * stack.
     */
    public VarTree(CommandStack commandStack, AdapterFactory adapterFactory) {
        super(adapterFactory, commandStack);
    }

//    /**
//     * Create an instance from the adapter factory, the specialized command
//     * stack, and the map used to maintain read only state.
//     */
//    public VarTree(CommandStack commandStack, Map<Resource, Boolean> resourceToReadOnlyMap) {
//        super(getFactories(), commandStack, resourceToReadOnlyMap);
//    }
//
//    /**
//     * Create an instance from the adapter factory, the specialized command
//     * stack, and the specialized resource set. If the resource set's context is
//     * null, one will be created here; otherwize, the existing context should
//     * implement {@link org.eclipse.emf.edit.domain.IEditingDomainProvider}.
//     */
//    public VarTree(CommandStack commandStack,
//            ResourceSet resourceSet) {
//        super(getFactories(), commandStack, resourceSet);
//    }

    /**
     * Makes a new tree with deafult values
     */
    public VarTree() {
        super(getFactories(), new BasicCommandStack());
        resourceSet.getResources().add(
                (new RTD_XMI_Factory()).createResource());
    };
 
    
    /**
     * Makes a new ComposedAdapterFactory
     * */
    protected static ComposedAdapterFactory getFactories() {
    	return new ComposedAdapterFactory( new AdapterFactory[] {
    	        	new DataItemProviderAdapterFactory(),
    	        	new ResourceItemProviderAdapterFactory(),
    	        	new ReflectiveItemProviderAdapterFactory()
    	        });
//    	return new ComposedAdapterFactory(
//                VarTreeRequiredFactories.getFactories());
    }

    /**
     * Destroys the tree and replace it with a new tree.
     */
    public void clear() {
        ((Resource) resourceSet.getResources().get(0)).getContents().clear();
    };

    /**
     * */
    protected void finalize() {
        //System.err.println("VarTree eliminata");
        properties.clear();
        properties.clear();
        commandStack.flush();
        adapterFactory = null;
        resourceSet.getResources().clear();
    }

    // ---------------------- FACTORY ----------------------

    /**
     * Makes a {@link com.eu.evidence.rtdruid.vartree.IVarTreePointer IVarTreePointer}to visit
     * the tree. The start point is the root Element.
     * 
     * @return a pointer to the root node.
     */
    public IVarTreePointer newVarTreePointer() {
        EList<EObject> root = ((Resource) resourceSet.getResources().get(0))
                .getContents();
        return new VarTreePointerEMF(root, this);
        //return new VarTreePointerEMFExtended(root, this);
    }

    /**
     * Makes a {@link com.eu.evidence.rtdruid.vartree.IVarTreePointer IVarTreePointer}to visit
     * the tree. The start point is the root Element.
     * 
     * @return a pointer to the root node.
     */
    public ITreeInterface newTreeInterface() {
        return new TreeInterface(this);
    }

    //  ---------------------- TRANSACTIONS ----------------------

    /** A composed command that contains all the transaction */
    private class RTDCompoundCommand extends CompoundCommand {
    	
    	/** This flag is used only to disable the first execution. */
    	private boolean enableExecution = false;
        	
    	@Override
    	public void execute() {
    		if (enableExecution)
    			super.execute();
    		enableExecution = true;
    	}
    	
    }
    private RTDCompoundCommand compCom;

    //private int transactionNumber = 0;

    /**
     * Start a new transaction
     * 
     * @return the command that will contains the transaction
     * 
     * @throws IllegalStateException
     *             if another transaction is already running
     */
    public CompoundCommand beginTransaction() {
        if (compCom != null) {
            throw new IllegalStateException(
                    "Start a new Transaction when another one is running");

            // transactionNumber ++;
        }
        compCom = new RTDCompoundCommand();
        return compCom;
    }

    /**
     * Commit the transaction
     */
    public void commitTransaction() {
        if (compCom != null) {
            /*
             * transactionNumber --; if (transactionNumber == 0) {
             */
            if (compCom.getCommandList().size() > 0) {
                commandStack.execute(compCom);
            }
            compCom = null;

            // }
        }
    }

    /**
     * Rollback the transaction
     */
    public void rollbackTransaction() {
        if (compCom != null) {
            /*
             * transactionNumber = 0;
             */
            compCom.undo();
            compCom = null;
        }
    }

    /**
     * Return the command the contains the current transaction or null if no
     * transactions are running
     * 
     * @return the command the contains the current transaction or null if there
     *         isn't any transaction
     */
    public CompoundCommand getCurrentTransaction() {
        return compCom;
    }

    //  ---------------------- ROOT ----------------------

    /**
     * Replace the old tree with the new one
     * 
     * @param newRoot
     *            the new tree
     */
    public void setRoot(EObject newRoot) {
        EList<EObject> el1 = ((Resource) resourceSet.getResources().get(0))
                .getContents();
        if (el1.size() == 0) {
            el1.add(newRoot);
        } else {
            el1.set(0, newRoot);
        }
    }

    /**
	 * Replace the old tree with the new one.
	 * 
	 * IMPORTANT : this operation cannot be undone and reset any transaction
	 * 
	 * @param newRoot
	 *            the new tree
	 * 
	 */
    public void setRoot(Resource newRoot) {
        resourceSet.getResources().set(0, newRoot);
        if (compCom != null) {
        	commandStack.flush();
        	
        	compCom = new RTDCompoundCommand();
        }
    }


    /*
     * public EList getRoot () { return ((Resource)
     * resourceSet.getResources().get(0)).getContents(); }
     */

    /**
     */
    public HashMap<String, Object> getProperties() {
        return properties;
    }

    //  ---------------------- Monitor Is Cancel ----------------------

    // JAVADOC : aggiungere la descrizione
    /**
     * Classe che si occupa di posticipare la terminazione di un thread qualora
     * stia lavorando su una struttra condivisa (e' comunque necessario stare
     * attenti nell'uso della thread.stop()!!)
     */
    public class ThreadMonitor implements IVarTree.IThreadMonitor {
        protected ArrayList<Thread> threads = new ArrayList<Thread>();

        protected ArrayList<Thread> waitForKill = new ArrayList<Thread>();

        /**
         * Try to lock the current thread. See also
         * {@link #unlock() unlock() method}.
         * 
         * @return true if the current thread was not locked, false otherwise
         */
        synchronized public boolean lock() {
            Thread newThread = Thread.currentThread();
            boolean answer = !(threads.contains(newThread));

            if (answer) {
                threads.add(newThread);
            }
            //			System.err.println("lock ("+answer +") " +
            // System.currentTimeMillis());

            return answer;
        }

        /**
         * A thread can ask to "unlock/unproctect" only itself
         * 
         * @throws RuntimeException
         *             if try to unlock a not locked thread
         */
        @SuppressWarnings("deprecation")
		synchronized public void unlock() {
            //			System.err.println("unlock " + System.currentTimeMillis());
            Thread newThread = Thread.currentThread();

            int index = threads.indexOf(newThread);
            if (index < 0) {
                throw new RuntimeException("Unlock a not locked thread");
            }

            threads.remove(index);

            if (waitForKill.contains(newThread)) {
                waitForKill.remove(newThread);
                newThread.stop();
            }
        }

        @SuppressWarnings("deprecation")
		synchronized public void kill(Thread newThread) {
            if (threads.contains(newThread)) {
                waitForKill.add(newThread);
            } else {
                newThread.stop();
            }
        }

    }

    private ThreadMonitor thMonitor;

    public IThreadMonitor getThreadMonitor() {
    	if (thMonitor == null) {
    		thMonitor = new ThreadMonitor();
    	}
        return thMonitor;
    }
}

