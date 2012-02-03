/*
 * Created on Aug 30, 2004
 *
 * $Id: VarTreePointerEMFExtended.java,v 1.4 2007/03/09 09:12:40 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.vartree;


import java.util.Stack;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.eu.evidence.rtdruid.vartree.IMountPointVar;
import com.eu.evidence.rtdruid.vartree.ISubVarTreePointer;
import com.eu.evidence.rtdruid.vartree.IVarTreePointer;
import com.eu.evidence.rtdruid.vartree.IVariable;
import com.eu.evidence.rtdruid.vartree.VarTreePointerEMF;
import com.eu.evidence.rtdruid.vartree.data.DataFactory;


/**
 * @author Nicola Serreli
 */
class VarTreePointerEMFExtended extends VarTreePointerEMF {
	// TODO : aggiungere tutti i commenti !!
	
	protected class LittlePointerExtended extends LittlePointer {
		public ISubVarTreePointer subPointer;
		
		public LittlePointerExtended() {}
		public LittlePointerExtended(EObject pointer, EStructuralFeature attr, ISubVarTreePointer subPointer) {
			this.pointer = pointer;
			this.attr = attr;
			this.subPointer = subPointer;
		}
		public Object clone() {
			return new LittlePointerExtended(pointer, attr, (ISubVarTreePointer) subPointer.clone());
		}

		public LittlePointer toLittlePointer() {
			return new LittlePointer(pointer, attr);
		}
	}
	

	
	public VarTreePointerEMFExtended(EList<EObject> root, EditingDomain editingDomain) {
		super(root, editingDomain);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public IVarTreePointer clone(){
		VarTreePointerEMFExtended answer = new VarTreePointerEMFExtended(root, editingDomain);
		answer.point = (LittlePointer) this.point.clone();
		return answer;
	}
	
	// --------------------------

	/* (non-Javadoc)
	 * @see rtdruid.vartree.IVarTreePointer#add(java.lang.String, java.lang.String)
	 */
	public String add(String name, String type) {
		if (point instanceof LittlePointerExtended) {
			return ((LittlePointerExtended) point).subPointer.add(name, type);
			
		} else {
			if (checkMountPoint(point)) {
				return getSubPointer(point).add(name, type);
			}
			return super.add(name, type);
		}
	}
	/* (non-Javadoc)
	 * @see rtdruid.vartree.IVarTreePointer#add(java.lang.String, rtdruid.vartree.variables.IVariable)
	 */
	public String add(String name, IVariable var) {
		if (point instanceof LittlePointerExtended) {
			return ((LittlePointerExtended) point).subPointer.add(name, var);
			
		} else {
			if (checkMountPoint(point)) {
				return getSubPointer(point).add(name, var);
			}
			return super.add(name, var);
		}
	}
	
	// -----------------------------

	/* (non-Javadoc)
	 * @see rtdruid.vartree.IVarTreePointer#destroy()
	 */
	public void destroy() {
		if (point instanceof LittlePointerExtended) {
			if (((LittlePointerExtended) point).subPointer.subDestroy() == ISubVarTreePointer.BACK_TO_PARENT) {
				point = ((LittlePointerExtended) point).toLittlePointer();
			}
			return;
		} else {
			super.destroy();
		}
	}
	
	
	
	// -----------------------------
	
	
	/**
	 * @param path all steps
	 *
	 */
	protected LittlePointer makeSteps(Stack<String> path, LittlePointer current) {
		boolean answer = true;
		
		while (answer && path.size() >0) {
			
			
			// 1. already inside a subPointer
			if (current instanceof LittlePointerExtended) {

				switch ( ((LittlePointerExtended) current).subPointer.makeSteps(path) ) {
				
					case ISubVarTreePointer.ERROR : return null;
					
					case ISubVarTreePointer.BACK_TO_PARENT : //answer = true;
												current = ((LittlePointerExtended) current).toLittlePointer();
												break;
					
					case ISubVarTreePointer.OK : //answer = true;
												if (path.size() >0) {
													throw new IllegalStateException("Expected an empty stack!!");
												}
												break;
				}
				
				
				continue;
			}
			
			String step = (String) path.peek();
			// 2. in a mount point
			if (checkMountPoint(current) 
					&& !(GO_PARENT.equals(step))
					&& !(CURRENT.equals(step))) {
				
				// just set sub pointer and then loop again (go to point 1)
				current = new LittlePointerExtended(current.pointer, current.attr, getSubPointer(current));
				
				continue;
			}
			
			// 3. normal steps
			answer = super.makeAStep((String) path.pop(), current);
		}
		
		return answer ? current : null;
	}
	
	
	protected boolean makeAStep(String step, LittlePointer current) {
		throw new UnsupportedOperationException("Never use this method. use super.makeASteps or makeSteps!");
	}


	public boolean goFirstChild() {
		if (point instanceof LittlePointerExtended) {
			return ( (LittlePointerExtended) point).subPointer.subGoFirstChild() == ISubVarTreePointer.OK;
			
		} else { 
			if (checkMountPoint(point)) {
				
				// Use the subpointer
				LittlePointer current = new LittlePointerExtended(
						point.pointer, point.attr, getSubPointer(point));
				
				if ( ((LittlePointerExtended) current).subPointer.subGoFirstChild() 
							== ISubVarTreePointer.OK) {
					  point = current;
					  return true;
				}
					
				
				return false;
			}

			return super.goFirstChild();
		}
	}
	public boolean goNextSibling() {
		if (point instanceof LittlePointerExtended) {
			return ( (LittlePointerExtended) point).subPointer.subGoNextSibling() == ISubVarTreePointer.OK; 
		} else { 
			return super.goNextSibling();
		}
	}
	public boolean goParent() {
		return super.go(GO_PARENT);
	}
	// -----------------------------
	
	/* (non-Javadoc)
	 * @see rtdruid.vartree.IVarTreePointer#getChildrenNumber()
	 */
	public int getChildrenNumber() {
		if (point instanceof LittlePointerExtended) {
			return ( (LittlePointerExtended) point).subPointer.getChildrenNumber(); 

		} else { 
			if (checkMountPoint(point)) {
				
				getSubPointer(point).getChildrenNumber();
			}

			return super.getChildrenNumber();
		}
	}
	/* (non-Javadoc)
	 * @see rtdruid.vartree.IVarTreePointer#getName()
	 */
	public String getName() {
		if (point instanceof LittlePointerExtended) {
			return ( (LittlePointerExtended) point).subPointer.getName(); 
		} else { 
			return super.getName();
		}
	}
	/* (non-Javadoc)
	 * @see rtdruid.vartree.IVarTreePointer#getNewChildTypes()
	 */
	public String[][] getNewChildTypes() {
		if (point instanceof LittlePointerExtended) {
			return ( (LittlePointerExtended) point).subPointer.getNewChildTypes(); 
		} else { 
			if (checkMountPoint(point)) {
				
				getSubPointer(point).getChildrenNumber();
			}

			return super.getNewChildTypes();
		}
	}
	/* (non-Javadoc)
	 * @see rtdruid.vartree.IVarTreePointer#getNewVar()
	 */
	public IVariable getNewVar(String value) {
		if (point instanceof LittlePointerExtended) {
			return ( (LittlePointerExtended) point).subPointer.getNewVar(value); 
		} else { 
			return super.getNewVar(value);
		}
	}
	/* (non-Javadoc)
	 * @see rtdruid.vartree.IVarTreePointer#getType()
	 */
	public String getType() {
		if (point instanceof LittlePointerExtended) {
			return ( (LittlePointerExtended) point).subPointer.getType(); 
		} else { 
			return super.getType();
		}
	}
	/* (non-Javadoc)
	 * @see rtdruid.vartree.IVarTreePointer#getVar()
	 */
	public IVariable getVar() {
		if (point instanceof LittlePointerExtended) {
			return ( (LittlePointerExtended) point).subPointer.getVar(); 
		} else { 
			return super.getVar();
		}
	}
	/* (non-Javadoc)
	 * @see rtdruid.vartree.IVarTreePointer#isContainer()
	 */
	public boolean isContainer() {
		if (point instanceof LittlePointerExtended) {
			return ( (LittlePointerExtended) point).subPointer.isContainer(); 
		} else { 
			return super.isContainer();
		}
	}
	/* (non-Javadoc)
	 * @see rtdruid.vartree.IVarTreePointer#isList()
	 */
	public boolean isList() {
		if (point instanceof LittlePointerExtended) {
			return ( (LittlePointerExtended) point).subPointer.isList(); 
		} else { 
			return super.isList();
		}
	}
	/* (non-Javadoc)
	 * @see rtdruid.vartree.IVarTreePointer#setVar(rtdruid.vartree.variables.IVariable)
	 */
	public void setVar(IVariable var) {
		if (point instanceof LittlePointerExtended) {
			( (LittlePointerExtended) point).subPointer.setVar(var); 
		} else { 
			super.setVar(var);
		}
	}
	
	// -------------------
	
	protected boolean checkMountPoint(LittlePointer current) {
		
		if (current instanceof LittlePointerExtended) {
			throw new IllegalStateException("check Mount inside a subPointer");
		}
		
		// is a leaf ?
		if  (current.attr == null ? false : (current.attr instanceof EAttribute )) {
			return getVar(current, false) instanceof IMountPointVar;
		}
		return false;
	}
	
	/** look for SubPointer stored in given LittlePointer
	 * */
	protected ISubVarTreePointer getSubPointer(LittlePointer current) {
		
		// supposed to be called only when checkMountPoint = true
		
/*		if (current instanceof LittlePointerExtended) {
			throw new IllegalStateException("get sub Pointer inside a another subPointer");
		}
		
		// is a leaf ?
		if  (current.attr == null ? false : (current.attr instanceof EAttribute )) {
*/			IVariable var = getVar(current, true);
//			if (var instanceof IMountPointVar) {
				return ((IMountPointVar) var).getPointer(editingDomain);
//			}
/*		}
		throw new IllegalStateException("is required a mount point to get a sub Pointer");
*/	}

	/**
	 * Returns the variable identified by given LittlePointer.
	 * 
	 * Make a new one only if it was null.
	 * 
	 * Convert to a MultiValues if required.
	 * 
	 * Doesn't make any copy (clone) of stored values.
	 * 
	 * If "create" is true, adds the variable to the tree (if it doesn't exist)
	 */
	protected IVariable getVar(LittlePointer current, boolean create) {
		if (current.attr.isMany()) {
		
			return convert(
				( (EAttribute) current.attr).getEAttributeType().getInstanceClass(),
				(EList<?>) current.pointer.eGet(current.attr) );
		
		} else {
			IVariable risp = (IVariable) current.pointer.eGet(current.attr);  

			if (risp == null) {
//				risp = (IVariable) DataFactory.eINSTANCE.createExtendedVarFromString(( (EAttribute) current.attr).getEAttributeType(), null );
				risp = (IVariable) DataFactory.eINSTANCE.createFromString(( (EAttribute) current.attr).getEAttributeType(), null );
				if (create && risp != null) {
				    current.pointer.eSet(current.attr, risp);
				}
			} else {
				// DO NOTHING !!! : return the current instance of var
			}
			
			return risp;
		}			
	}
}
