/*
 * Created on May 11, 2004
 *
 */
package com.eu.evidence.rtdruid.vartree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Properties;
import java.util.Stack;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.CreateChildCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.eu.evidence.rtdruid.desk.Messages;
import com.eu.evidence.rtdruid.vartree.variables.BooleanMVar;
import com.eu.evidence.rtdruid.vartree.variables.BooleanVar;
import com.eu.evidence.rtdruid.vartree.variables.DoubleMVar;
import com.eu.evidence.rtdruid.vartree.variables.DoubleVar;
import com.eu.evidence.rtdruid.vartree.variables.FloatMVar;
import com.eu.evidence.rtdruid.vartree.variables.FloatVar;
import com.eu.evidence.rtdruid.vartree.variables.IntegerMVar;
import com.eu.evidence.rtdruid.vartree.variables.IntegerVar;
import com.eu.evidence.rtdruid.vartree.variables.LongMVar;
import com.eu.evidence.rtdruid.vartree.variables.LongVar;
import com.eu.evidence.rtdruid.vartree.variables.MultiValues;
import com.eu.evidence.rtdruid.vartree.variables.PropertyVar;
import com.eu.evidence.rtdruid.vartree.variables.StringMVar;
import com.eu.evidence.rtdruid.vartree.variables.StringVar;
import com.eu.evidence.rtdruid.vartree.variables.TimeMVar;
import com.eu.evidence.rtdruid.vartree.variables.TimeVar;

/**
 * An instance of IVarTreePointer to look on an "EMF structure".
 * 
 * NOTA_BENE_(ITALIANO) EMF accetta id nulli o pari a stringhe vuote,
 * 		quindi deve essere possibile muoversi verso nodi con
 * 		tali id. Il problema nasce quando si vuole costruire un path:
 * 		 +  inserire una sequenza di "escape" che significa "id nullo"?
 * 		 +  inserire una sequenza di "escape" che significa "id vuoto"?
 *		Anche perche' mi sembra + logico identificare due separatori consecutivi
 *		come un unico separatore (molto "utile se il path e' il risultato di una elaborazione")
 * 	 
 * 
 * @author Nicola Serreli
 */
 public class VarTreePointerEMF implements IVarTreePointer {
	public final static String GO_PARENT = DataPath.GO_PARENT; // ..
	public final static String CURRENT =   DataPath.CURRENT;   // .
	public final static String NULL_ID =   DataPath.NULL_ID;   // \0
	public final static String VOID_ID =   DataPath.VOID_ID;   // \_
	
	protected static class LittlePointer implements EmfPoint, Cloneable {
		protected EObject pointer;
		protected EStructuralFeature attr;
		
		public LittlePointer() {}
		public LittlePointer(EObject pointer, EStructuralFeature attr) {
			this.pointer = pointer;
			this.attr = attr;	
		}
		public LittlePointer clone() {
			return new LittlePointer(pointer, attr);
		}
		
		public String toString() {
			return "(Node " + pointer + " & attr "+ attr +")";
		}
		/* (non-Javadoc)
		 * @see com.eu.evidence.rtdruid.vartree.IVarTreePointer.EmfPoint#getCurrentFeature()
		 */
		@Override
		public EStructuralFeature getCurrentFeature() {
			return attr;
		}
		/* (non-Javadoc)
		 * @see com.eu.evidence.rtdruid.vartree.IVarTreePointer.EmfPoint#getEObject()
		 */
		@Override
		public EObject getEObject() {
			return pointer;
		}
	}
	
	// ----------------------
	
	final protected EList<EObject> root;
	protected LittlePointer point;
	
	protected EditingDomain editingDomain;
	
	// ----------------------
	
	public VarTreePointerEMF(EList<EObject> root, EditingDomain editingDomain) {
		this.root = root;
		this.point = new LittlePointer(null, null);
		this.editingDomain = editingDomain;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public IVarTreePointer clone() {
		VarTreePointerEMF answer = new VarTreePointerEMF(root, editingDomain);
		answer.point = (LittlePointer) this.point.clone();
		
		return answer;
	}

	// -------------------- COMMAND -----------
	
	/**
	 *  check if current editingDomain is a VarTree and, in this case try to get the compound Command
	 */
	protected CompoundCommand getComp() {
		
		if (editingDomain instanceof IVarTree && ((IVarTree) editingDomain).getCurrentTransaction() != null) {
			return ((IVarTree) editingDomain).getCurrentTransaction();
		}

		return null;
	}
	
	/**
	 * Simply flush all commands from commandStack. If there was a chain, start a new chain
	 */
	protected void execFlushCommandStack() {
		if (getComp() != null) {
			((IVarTree) editingDomain).commitTransaction();
			((IVarTree) editingDomain).beginTransaction();
		}
		
		editingDomain.getCommandStack().flush();
	}

	/**
	 *  Set the value of an attribute (value could be null)
	 * 
	 * @param owner the parent node
	 * @param feature identifies the attribute
	 * @param value the new value. if null, "unset" the old value
	 */
	protected void execSetValueCommand(EObject owner, EAttribute feature, Object value) {

		Command valueCommand = SetCommand.create(editingDomain, owner, feature, value);
		CompoundCommand cc = getComp();
		if (cc != null) {
			cc.appendAndExecute(valueCommand);
		} else { 
			editingDomain.getCommandStack().execute(valueCommand);
		}
	}

	/** Unset a Feature (for example a list of children)
	 * 
	 * @param owner the parent node
	 * @param feature the reference to unset
	 */ 
	protected void execClearCommand(EObject owner, EReference feature) {

		Command clearCommand = SetCommand.create(editingDomain, owner, feature, feature.isMany() ? new BasicEList<EObject>() : null);
		CompoundCommand cc = getComp();
		if (cc != null) {
			cc.appendAndExecute(clearCommand);
		} else { 
			editingDomain.getCommandStack().execute(clearCommand);
		}
	}
	
	/**
	 *  Remove one or more children from a multivalue EReference. 
	 *  For unset a list or remove a child from a "not multivalue" EReference,
	 *  use {@link execClearCommand execClearCommand} 
	 * 
	 * @param owner the parent node
	 * @param feature the multivalue Reference 
	 * @param objects a list of "old children"
	 */
	protected void execRemoveCommand(EObject owner, EReference feature, Collection<?> objects) {
		
//		((EList)((EObject)owner).eGet((EStructuralFeature)feature)).removeAll((Collection)objects);
		/*if (cc != null) {
			cc.appendAndExecute(remCommand);
		} else { 
			editingDomain.getCommandStack().execute(remCommand);
		}*/
		
	//	if (true) return;
		Command remCommand = RemoveCommand.create(editingDomain, owner, feature, objects);
		CompoundCommand cc = getComp();
		if (cc != null) {
			cc.appendAndExecute(remCommand);
		} else { 
			editingDomain.getCommandStack().execute(remCommand);
		}
	}

	/** Add a new child
	 * 
	 * @param owner the parent node
	 * @param command contains all data : the new node and the reference 
	 */
	protected void execAddCommand(EObject owner, CommandParameter command) {
		
		ArrayList<EObject> al = new ArrayList<EObject>();
		al.add(owner);
		
		Command addCommand = CreateChildCommand.create(editingDomain, owner, command, al);
		CompoundCommand cc = getComp();
		if (cc != null) {
			cc.appendAndExecute(addCommand);
		} else { 
			editingDomain.getCommandStack().execute(addCommand);
		}
	}

	// -------------------- ADD -------------

	/** ITALIANO
	 * 
	 * Casi : attr == null -> confronto il nome fornito con quello degli 
	 * 				attributi > causa un errore
	 * 				contenitori > ignorato se contenitore 1 a molti, aggiunto un elemento se contenitore uno ad uno.
	 * 					Se gia' presente, non viene sostituito e se e'
	 * 						dello stesso tipo viene segnalato come debug
	 * 						di tipo diverso causa un errore
	 * 		  attr != null -> creo un nuovo oggetto del tipo richiesto, se questo e' valido per l'attributo corrente.
	 * 				Se il nome non e' univoco non viene sostituito e se e'
	 * 						dello stesso tipo viene segnalato come debug
	 * 						di tipo diverso causa un errore
	 * 
	 * 
	 * 
	 * ATTENZIONE : se l'ID del nodo e' composto da un unico elemento questo viene protetto
	 *              altrimenti viene lasciato integro.
	 *              questo crea MOLTA confusione !!!!!
	*/	
	public String add(String name, String type) {
		String nameId = DataPath.makeId(name);
		if (type == null)
			 throw new NullPointerException("required a not null type");

		if (point.pointer == null) {
			if (!"System".equals(type)) {
				throw new IllegalArgumentException("required System as type for root node");
			}
			
			if (root.size() != 0) {
				throw new IllegalStateException("Try to add more than one system");
			}
			
			EObject newRoot = VarTreeUtil.newVarTreeRoot(editingDomain);
			VarTreeIdHandler.setId(newRoot, nameId);//new String[] {nameId});
			root.add(newRoot);
			execFlushCommandStack();
			
			return DataPath.addSlash(VarTreeIdHandler.getId(newRoot));
		}
		
		
		if (point.attr == null) {
			
			// check if exist an attr or a reference with given name
			EStructuralFeature esf = point.pointer.eClass().getEStructuralFeature(name);
			if (esf == null) {
				Messages.sendErrorNl("try to add an unssuported feature (" + name + ")", null, null, null);
				throw new IllegalArgumentException("Unsupported name for current node (no feature with given name:" + name + ")");
			} 

			if (esf instanceof EAttribute) { // check for an attribute
				//EList attrList = point.pointer.eClass().getEAllAttributes();
				//for (int i=0; i<attrList.size(); i++) {
					//if (((EAttribute) attrList.get(i)).getName().equals(name)){
						Messages.sendErrorNl("try to add an attribute as 'a node'", null, null, null);
						throw new RuntimeException("Try to add an attribute ");
				//	}
				//}
			}

			if (esf instanceof EReference) { // check for an "Reference"
				/*EList refList = point.pointer.eClass().getEReferences();
				for (int i=0; i<refList.size(); i++) {
					EReference ref = (EReference) refList.get(i);
					if (ref.getName().equals(name)){
				*/		
						EReference ref = (EReference) esf;
						// is it a reference "one-to-one"?
						if (ref.isMany()) {
							if (!type.equals(name)) {
								Messages.sendErrorNl("try to add a reference to many, with wrong Type - Name", null, null, null);
								throw new RuntimeException("try to add a reference to many, with wrong Type - Name (" + type + ", " + name + ")");
							}
							
							
							Messages.sendDebugNl("try to add a reference to many");
/**/						return name;
						}
						
						// add a new node

						Collection<?> childs = editingDomain.getNewChildDescriptors(point.pointer, null);

						Iterator<?> it = childs.iterator();
						while (it.hasNext()) {
							Object o = it.next();
							
							if (o instanceof CommandParameter) {
								CommandParameter cp = (CommandParameter) o;
								if (cp.getEStructuralFeature().getName().equals(name) && // check for reference name
									(cp.getValue() instanceof EObject && // check new object type
											((EObject) cp.getValue()).eClass().getName().equals(type))
									) {
									// add new node
									EObject newValue = cp.getEValue();
									String newValueId = VarTreeIdHandler.getId(newValue);
									if (DataPath.resolveId(newValueId).length > 1) {
										nameId = name; // TODO: correzione temporanea !!!
									}
									
									if (!VarTreeIdHandler.checkNewID(newValue, nameId)) {
										Properties prop = new Properties();
										prop.setProperty("path", editingDomain.getTreePath(newValue).toString());
										prop.setProperty("Node", point.pointer.toString());
										prop.setProperty("new type", "" + type);
										prop.setProperty("new name", "" + name);
										Messages.sendErrorNl("Try to set an illegal id", null, null, prop);

/***/										throw new IllegalArgumentException("(abc879253) Node = " + point.pointer.toString()
												+ " new name = " + name + " type = " + type);
									}
									VarTreeIdHandler.setId(newValue, nameId);

									{ // check if already exist a node for given Feature. If yes .. they have the same type and Id ?
										if (point.pointer.eGet(cp.getEStructuralFeature()) != null) {
											EObject obj = (EObject) point.pointer.eGet(cp.getEStructuralFeature()); 
											if ( !(obj.eClass().getName().equals(type)) ) {
												Properties prop = new Properties();
												prop.setProperty("path", editingDomain.getTreePath(obj).toString());
												prop.setProperty("Node", point.pointer.toString());
												prop.setProperty("new type", "" + type);
												prop.setProperty("new name", "" + name);
												Messages.sendErrorNl("Try to overwrite an existent node with different type", null, null, prop);

		/***/										throw new IllegalArgumentException("(abc879253) Node = " + point.pointer.toString()
														+ " new name = " + name + " type = " + type);
		
											} else if ( !VarTreeIdHandler.getId(obj).equals(name)) {
												Properties prop = new Properties();
												prop.setProperty("path", editingDomain.getTreePath(obj).toString());
												prop.setProperty("Node", point.pointer.toString());
												prop.setProperty("new type", "" + type);
												prop.setProperty("new name", "" + name);
												Messages.sendErrorNl("Try to overwrite an existent node with different id", null, null, prop);

		/***/										throw new IllegalArgumentException("(abc2345654) Node = " + point.pointer.toString()
														+ " new name = " + name + " type = " + type);
												
 
											} else {
												Messages.sendDebugNl("try to add an already existent node");
/**/											return name;
											}
										}
										
										
										// add the new node
										execAddCommand(point.pointer, cp);
										//point.pointer.eSet( cp.getEStructuralFeature(), cp.getValue());
										
									}
									
									return DataPath.addSlash(VarTreeIdHandler.getId(newValue));
								}
							} else {
								Messages.sendDebugNl("Expected a commandParameter !!! why not found ?? " + o);
							}
							
						}
						
/**/					//break;
					//}
				//}
			}
			// reference not found

			throw new IllegalArgumentException("(abc178946) Node = " + point.pointer.toString()
					+ " new name = " + name + " type = " + type);
		}
		
		
				
		
		
		// check for a new child
		String attrName = point.attr.getName();
		Collection<?> childs = editingDomain.getNewChildDescriptors(point.pointer, null);
		// return CommandParameter
		Iterator<?> it = childs.iterator();
		while (it.hasNext()) {
			Object o = it.next();
			
			if (o instanceof CommandParameter) {
				CommandParameter cp = (CommandParameter) o;
				if (cp.getEStructuralFeature().getName().equals(attrName) && // check for reference name
					(cp.getValue() instanceof EObject && // check new object type
							((EObject) cp.getValue()).eClass().getName().equals(type))
					) {
					
					// correct the ID ? (remove or not the Slash)
					EObject newValue = cp.getEValue();
					if (DataPath.resolveId(VarTreeIdHandler.getId(newValue)).length > 1) {
						nameId = name; // TODO: correzione temporanea !!!
					}
					
					if (! VarTreeIdHandler.checkNewID(newValue, nameId)) {
						Properties prop = new Properties();
						prop.setProperty("path", editingDomain.getTreePath(newValue).toString());
						prop.setProperty("Node", point.pointer.toString());
						prop.setProperty("new type", "" + type);
						prop.setProperty("new name", "" + name);
						Messages.sendErrorNl("Try to set an illegal id", null, null, prop);

/***/					throw new IllegalArgumentException("(abc0912734) Node = " + point.pointer.toString()
								+ " new name = " + name + " type = " + type);
						
					}
					VarTreeIdHandler.setId(newValue, nameId);

					{ // check if already exist a node with given ID
						EList<?> currentChilds = (EList<?>) point.pointer.eGet( cp.getEStructuralFeature());
						int pos = currentChilds.indexOf(newValue);
						if (pos > -1) { // already exist
							EObject obj = (EObject) currentChilds.get(pos); 
							
							// check for type
							if (obj.eClass().getName().equals(type)) {
								Messages.sendDebugNl("try to add an already existent node");
/**/							return DataPath.addSlash(VarTreeIdHandler.getId(newValue));
							}
							
							
							Properties prop = new Properties();
							prop.setProperty("path", editingDomain.getTreePath(obj).toString());
							prop.setProperty("Node", point.pointer.toString());
							prop.setProperty("new type", "" + type);
							prop.setProperty("new name", "" + name);
							Messages.sendErrorNl("Try to add a node with a not unique id", null, null, prop);

/***/						throw new IllegalArgumentException("(abc0912374) Node = " + point.pointer.toString()
									+ " new name = " + name + " type = " + type);
						}
//						currentChilds.add(newValue);
					}

					// add the new node
					execAddCommand(point.pointer, cp);

					return DataPath.addSlash(VarTreeIdHandler.getId(newValue));

				}
			} else {
				Messages.sendDebugNl("Expected a commandParameter !!! why not found ?? " + o);
			}
		}
		
/***/	throw new IllegalArgumentException("(abc72834213) Type non found. Node = " + point.pointer.toString()
				+ " new name = " + name + " type = " + type);
	}
	
	
	/** Returns all aceptables child's types for current node.
	 * Sometimes a type is associated to a specific name, in this case that name 
	 * is the second string of each element of result. <br>
	 * The answer is something like: { { "new Type", "specific name"},{ "another new type", null} ....} 
	 * */
	public String[][] getNewChildTypes() {
		
		ArrayList<String[]> answer = new ArrayList<String[]>();
		
		Collection<?> childs = editingDomain.getNewChildDescriptors(point.pointer, null);
		// return CommandParameter
		Iterator<?> it = childs.iterator();
		while (it.hasNext()) {
			Object o = it.next();
			
			if (o instanceof CommandParameter) {
				CommandParameter cp = (CommandParameter) o;
				String[] tmp = new String[2];
				
				if (point.attr != null) {
					if (!cp.getEStructuralFeature().getName().equals(point.attr.getName())) { // check for reference name
						continue; // next command
					}
					tmp[1] = null;
				} else {
					if (cp.getEStructuralFeature() instanceof EReference 
							&& cp.getEStructuralFeature().isMany()) { // a reference one to many requires point.attr != null 
						continue; // next command
					}
					tmp[1] = cp.getEStructuralFeature().getName();
					
				}
				if (cp.getValue() instanceof EObject) {
					tmp[0] = ((EObject) cp.getValue()).eClass().getName();
					
					answer.add(tmp);
				}
			}
			
		}
		
		String[][] ok = new String[answer.size()][];
		for (int i=0; i<answer.size(); i++) {
			ok[i] = (String[]) answer.get(i);
		}
		return ok;
	}
	
	// ------------------- LEAF -------------------
	
	/** ITALIANO
	 * 	
	 * attr != null >  (errore)
	 * 		foglia > errore
	 * 		cont. mono > bo? > errore
	 * 		cont. multi > errore
	 * 
	 * attr == null > cerco un attr con il nome fornito (se e' presente qualcosa, lo elimina)
	*/
	public String add(String name, IVariable var) {
		if (name == null)
			 throw new NullPointerException("required a not null attribute's name");
		
		if (point.pointer == null) {
			throw new IllegalStateException("try to add a leaf as root node");
		}
		
		if (point.attr != null) {
			throw new IllegalStateException("(ITALIANO) IVarTreePointer su un contenitore > attr non nullo");
		}
			
		// check for an attribute
		EList<EAttribute> attrList = point.pointer.eClass().getEAllAttributes();
		for (int i=0; i<attrList.size(); i++) {
			EAttribute at = (EAttribute) attrList.get(i); 
			if (at.getName().equals(name)){
				
				if (at.isMany()) {
					BasicEList<Object> val = new BasicEList<Object>();
					
					if (var != null) {
						if (var instanceof MultiValues) {
							IMultiValues mv = (IMultiValues) var;
							for (int l=0; l< mv.sizeValues(); l++) {
								val.add(EcoreUtil.createFromString(at.getEAttributeType(), mv.getValues(l) ));
							}
							
							
						} else {
							if (var.get() != null) {
								val.add(EcoreUtil.createFromString(at.getEAttributeType(), var.toString() ));
							}
							
						}
					}

					{ // set the new value
						execSetValueCommand(point.pointer, at, val);
						//point.pointer.eSet( at, val);
						return name;
					}

				} else {
					Object tmp = null;

					if (var != null) {
						if (var instanceof MultiValues) {
							throw new IllegalArgumentException("Not valid argument: try to use a MultiValues for a mono value attribute !!!");
							
						} else {
							if (var.get() != null) {
								tmp = EcoreUtil.createFromString(at.getEAttributeType(), var.toString() );
							}
							
						}
					}

					{ // set the new value
						execSetValueCommand(point.pointer, at, tmp);
						//point.pointer.eSet( at, tmp);
						return name;
					}

					
				}
			}
		}
			
		
/***/	throw new IllegalArgumentException("(abc23452) Attribute non found. Node = " + point.pointer.toString()
				+ " new name = " + name + " var = " + var);
	}
	
	// ----------------------------------------------------
	
	// JAVADOC : commentare
	/**
	 * @param path all steps
	 *
	 * @return a LittlePointer if is all ok, null if there is an error
	 */
	protected LittlePointer makeSteps(Stack<String> path, LittlePointer current) {
		boolean answer = true;
		
		while (answer && path.size() >0) {
			answer = makeAStep((String) path.pop(), current);
		}
		
		return answer ? current : null;
	}
	
	// JAVADOC : commentare
	protected Stack<String> pathToStack(String path) {
		Stack<String> answer = new Stack<String>();
		
		String[] steps = path == null ? new String[] {DataPath.NULL_ID} : DataPath.splitPath(path);
		for (int i=steps.length-1; i>=0; i--) {
			answer.push( steps[i] );
		}
		
		return answer;
	}
	
	
	/** If step is not null or special command (GO_PARENT, CURRENT and NULL_ID) it must be protected
	 * */
	protected boolean makeAStep(String step, LittlePointer current) {
		if (current == null) {
			throw new NullPointerException("Required a not null current");
		}
		
		step = DataPath.removeSlash(step);
		boolean risp = false;
		
		if (GO_PARENT.equals(step)) { // goParent
			if (current.pointer == null) {
				//  risp = false
			} else if (current.attr != null) {
				current.attr = null;
				risp = true;
			} else {
				EObject parent = current.pointer.eContainer();
				if (parent != null) {
					current.attr = (current.pointer.eContainmentFeature().isMany() ? current.pointer.eContainmentFeature() : null);
					current.pointer = parent;
				} else {
					current.attr = null;
					current.pointer = null;
				}
				risp = true;				
			}
			
			//
		} else if (CURRENT.equals(step)) { // do nothing
			risp = true;
			
		} else if (step == null || NULL_ID.equals(step)) { // try to go to a child with a id == null (unsetted)
			if (current.pointer == null) {
				if (root.size() >0) {
					String txt = VarTreeIdHandler.getId(root.get(0));
					if (NULL_ID.equals(txt)) {
						current.pointer = root.get(0);
						current.attr = null;
						risp = true;
					}
				}
				// else risp = false
			} else if (current.attr != null) {
				Object child = current.pointer.eGet(current.attr);
				
				if (child instanceof EList) {
					
					// look for a child with given name
					EList<?> refList = ((EList<?>) child);
					for (int i=0; i<refList.size(); i++) {
						EObject ref = (EObject) refList.get(i);
						if (NULL_ID.equals(VarTreeIdHandler.getId(ref))) {
							current.pointer = ref;
							current.attr = null;
							risp = true;
							break;
	
						}
					}

					
					/*int pos = ((EList) child).indexOf(NULL_ID);
				
					if (pos > -1) {
						ObjectWithID newObj = (ObjectWithID) ((EList) child).get(pos);
						
						if (newObj != null) {
							current.pointer = newObj;
							current.attr = null;
							risp = true;
						}
					}*/
				}
			} // else risp = false
		
		} else if ("".equals(step) || VOID_ID.equals(step)) { // try to go to a child with a id == "" (void)

			if (current.pointer == null) {
				if (root.size() >0) {
					String txt = VarTreeIdHandler.getId(root.get(0));
					if ("".equals(txt)) {
						current.pointer = root.get(0);
						current.attr = null;
						risp = true;
					}
				}
				// else risp = false
			} else if (current.attr != null) {
				Object child = current.pointer.eGet(current.attr);
				
				if (child instanceof EList) {
					
					// look for a child with given name
					EList<?> refList = ((EList<?>) child);
					for (int i=0; i<refList.size(); i++) {
						EObject ref = (EObject) refList.get(i);
						if ("".equals(VarTreeIdHandler.getId(ref))) {
							current.pointer = ref;
							current.attr = null;
							risp = true;
							break;
	
						}
					}

/*					
					int pos = ((EList) child).indexOf("");
				
					if (pos > -1) {
						ObjectWithID newObj = (ObjectWithID) ((EList) child).get(pos);
						
						if (newObj != null) {
							current.pointer = newObj;
							current.attr = null;
							risp = true;
						}
					}
*/				}
			} // else risp = false

		} else { // try to go to a child with a not null id
			
			if (current.pointer == null) {
				if (root.size() >0) {
					String txt = VarTreeIdHandler.getId(root.get(0));
					if (step.equals(txt)) {
						current.pointer = root.get(0);
						current.attr = null;
						risp = true;
					}
				}
				// else risp = false
			} else if (current.attr == null) {
				
				// look for given feature's name
				EStructuralFeature esf = current.pointer.eClass().getEStructuralFeature(step);
				
				if (esf != null) {
				
					if (esf instanceof EAttribute) { // attribute
							current.attr = esf;
							risp = true;
							
					} else if (esf instanceof EReference) { // reference
						
						if (esf.isMany() ) { // one to many
							current.attr = esf;
							risp = true;
							
						} else { // one to one
							EObject newObj = (EObject) current.pointer.eGet(esf);
							if (newObj != null) {
								current.pointer = newObj;
								current.attr = null;
								risp = true;

							}
						}
					}
				}				
			} else {
				
				// check current feature
				if (current.attr instanceof EAttribute) {
					// nothing to do !!! -> risp = false
				} else if (current.attr instanceof EReference) { // only one to many
					
					// look for a child with given name
					EList<?> refList = (EList<?>) current.pointer.eGet(current.attr);
					
//					if (refList instanceof EObjectContainmentUniqueEList<?>) {
//						EObjectContainmentUniqueEList<?> list = (EObjectContainmentUniqueEList<?>) refList;
//						int pos = list.indexOfById(step);
//						if (pos >=0) {
//							current.pointer = (EObject) list.get(pos);
//							current.attr = null;
//							risp = true;
//							
//						}
//						
//					} else 
					{
					for (int i=0; i<refList.size(); i++) {
						EObject ref = (EObject) refList.get(i);
						if (step.equals(VarTreeIdHandler.getId(ref))) {
							current.pointer = ref;
							current.attr = null;
							risp = true;
							break;
	
						}
					}
					}
				}
			
			}
		}
		
		if (!risp) {
	/*		Messages.sendDebug("Step = " + step + "\n\tpointer = " + current.pointer + "\n\tattr = " + current.attr 
					+ (current.attr != null ? "\n\tfeature = " + current.pointer.eGet(current.attr) : "") + "\n");
			try {
				throw new IllegalStateException();
			} catch (IllegalStateException e) {
				
			}
	*/	}
		
		
		return risp;
	}
	
	/* (non-Javadoc)
	 * @see rtdruid.vartree.IVarTreePointer#goAbsolute(java.lang.String)
	 */
	public boolean goAbsolute(String path) {
		LittlePointer lp = new LittlePointer(null, null);

		if (path == null ) { // old standard
			point = lp;

		} else {
/*			
			// more than one step
			if (!(path.length() > 0 && path.startsWith("" + VarTree.SEPARATOR)	 )) {
				Messages.sendDebug("path start without VarTree.SEPARATOR; use go(...) instead of goAbsolute(...)");
			}
*/	
			lp = makeSteps( pathToStack(path), lp);

			if (lp != null) {
				point = lp;
			}
		}
		
		return lp != null;
	}
	/* (non-Javadoc)
	 * @see rtdruid.vartree.IVarTreePointer#go(java.lang.String)
	 */
	public boolean go(String path) {
		LittlePointer lp = (LittlePointer) point.clone();
/*
		// check if start without SEPARATOR
		if (path.length() > 0 && path.startsWith("" + VarTree.SEPARATOR)	 ) {
			Messages.sendDebug("path start with VarTree.SEPARATOR; use goAbsolute(...) instead of go(...)");
		}
*/	
		// walk
		lp = makeSteps( pathToStack(path), lp);

		// store ?
		if (lp != null) {
			point = lp;
		}

		return lp != null;
	}
	/* (non-Javadoc)
	 * @see rtdruid.vartree.IVarTreePointer#existAbsolute(java.lang.String)
	 */
	public boolean existAbsolute(String path) {
		LittlePointer lp = new LittlePointer(null, null);

		if (path == null ) { // old standard
			return true;

		} else {
/*			
			// more than one step
			if (!(path.length() > 0 && path.startsWith("" + VarTree.SEPARATOR)	 )) {
				Messages.sendDebug("path start without VarTree.SEPARATOR; use exist(...) instead of existAbsolute(...)");
			}
*/	
			lp = makeSteps( pathToStack(path), lp);
		}
		
		return lp != null;
	}
	/* (non-Javadoc)
	 * @see rtdruid.vartree.IVarTreePointer#exist(java.lang.String)
	 */
	public boolean exist(String path) {
		LittlePointer lp = (LittlePointer) point.clone();
/*
		// check if start without SEPARATOR
		if (path.length() > 0 && path.startsWith("" + VarTree.SEPARATOR)	 ) {
			Messages.sendDebug("path start with VarTree.SEPARATOR; use existAbsolute(...) instead of exist(...)");
		}
*/	
		// walk
		lp = makeSteps( pathToStack(path), lp);

		return lp != null;
	}
	
	/* (non-Javadoc)
	 * @see rtdruid.vartree.IVarTreePointer#goFirstChild()
	 */
	public boolean goFirstChild() {
		if (point.pointer == null) {
			if (root.size() >0) {
				point.pointer = (EObject) root.get(0);
				point.attr = null;
				return true;
			}
			
		} else if (point.attr == null) {
		
			EList<EStructuralFeature> all = point.pointer.eClass().getEAllStructuralFeatures();
			
			for (int i=0; i<all.size(); i++) {
				Object o = all.get(i);
				if (o instanceof EAttribute) {
					point.attr = (EAttribute) o;
					return true;
					
				} else if (o instanceof EReference) {
					EReference ref = (EReference) o;
					if ( ref.isMany() ) {
						point.attr = ref;
						return true;
					}// else {
					
					EObject newObj = (EObject) point.pointer.eGet(ref);
					if (newObj != null) {
						point.pointer = newObj;
						// point.attr = null;
						return true;
					}
				} else {
				
					Messages.sendDebugNl("goFirstChild ?? unsupported feature");
				}
				
			}
		} else {
		
			// check current feature
			if (point.attr instanceof EAttribute) {
				return false;
				
			} else if (point.attr instanceof EReference) {
				EReference ref = (EReference) point.attr;
				if ( ref.isMany() ) {
					EList<?> newObj = (EList<?>) point.pointer.eGet(ref);
					if (newObj != null && newObj.size()>0) {
						point.pointer = (EObject) newObj.get(0);
						point.attr = null;
						return true;
					}
				}// else {
				
				// return false
			} else {
			
				Messages.sendDebugNl("goFirstChild ?? unsupported feature");
			}
		
		}
		return false;
	}
	/* (non-Javadoc)
	 * @see rtdruid.vartree.IVarTreePointer#getChildrenNumber()
	 */
	public int getChildrenNumber() {
		int tot = 0;
		if (point.pointer == null) {
			return root!=null ? root.size() : 0;
		}
		
		if (point.attr == null) {
		
			EList<EStructuralFeature> all = point.pointer.eClass().getEAllStructuralFeatures();
			
			for (int i=0; i<all.size(); i++) {
				Object o = all.get(i);
				if (o instanceof EAttribute) {
					tot++;
					
				} else if (o instanceof EReference) {
					EReference ref = (EReference) o;
					if ( ref.isMany() ) {
						tot++;
					} else {
						tot += point.pointer.eGet(ref) == null ? 0 : 1;
					
					}
				} else {
				
					Messages.sendDebugNl("goFirstChild ?? unsupported feature");
				}
			}
		} else {
		
			// check current feature
			if (point.attr instanceof EAttribute) {
				// tot = 0;
				
			} else if (point.attr instanceof EReference) {
				EReference ref = (EReference) point.attr;
				if ( ref.isMany() ) {
					EList<?> newObj = (EList<?>) point.pointer.eGet(ref);
					tot = newObj != null ? newObj.size() : 0;
				}// else {
				
				// tot = 0;
			} else {
			
				Messages.sendDebugNl("goFirstChild ?? unsupported feature");
			}
		
		}
		return tot;
	}
	/* (non-Javadoc)
	 * @see rtdruid.vartree.IVarTreePointer#goNextSibling()
	 */
	public boolean goNextSibling() {
		boolean risp = false;
		
		if (point.pointer == null) {
			return false;
			
		} else if (point.attr == null) {
			
			// check on parent's child (in the same feature)
			EObject parent = point.pointer.eContainer();
			if (parent != null) {
			
				EReference esf = point.pointer.eContainmentFeature();
				
				if (esf.isMany()) {
				
					EList<?> newObj = (EList<?>) parent.eGet(esf);
					int pos = -1;
					{
						for (int i=0; i<newObj.size(); i++) {
							if (point.pointer == newObj.get(i)) {
								pos = i;
								break;
							}
						}
					}
					// int pos = newObj.indexOf(point.pointer); // NOT work if more than one object have the same ID (is an error!!!)
					if (pos == -1) {
						throw new RuntimeException("(8071246) pos cannot be <0 !!!!");
					}
					if (pos +1< newObj.size()) { // pos cannot be <0 !!!!
						
						point.pointer = (EObject) newObj.get(pos +1);	
						// point.attr = null;
						risp = true;
					}
				
				} else {
				
					EList<EStructuralFeature> all = parent.eClass().getEAllStructuralFeatures();
					int pos = all.indexOf(esf);
					if (pos == -1) {
						throw new RuntimeException("(07891354) pos cannot be <0 !!!!");
					}
							
					for (int i=pos +1; i<all.size() && !risp; i++) {
						Object o = all.get(i);
						if (o instanceof EAttribute) {
							point.pointer = parent;
							point.attr = (EAttribute) o;
							risp = true;
							
						} else if (o instanceof EReference) {
							EReference ref = (EReference) o;
							if ( ref.isMany() ) {
								point.pointer = parent;
								point.attr = ref;
								risp = true;
							} else {
								
								EObject newObj = (EObject) parent.eGet(ref);
								if (newObj != null) {
									point.pointer = newObj;
									point.attr = null;
									risp = true;
								}
							}
						} else {
						
							Messages.sendDebugNl("goNextChild ?? unsupported feature");
						}
						
					}
				
				}
			} // else parent == null -> return false
		
		} else {
			EList<EStructuralFeature> all = point.pointer.eClass().getEAllStructuralFeatures();
			int pos = all.indexOf(point.attr);
			if (pos == -1) {
				throw new RuntimeException("(249835) pos cannot be <0 !!!!");
			}
					
			for (int i=pos +1; i<all.size() && !risp; i++) {
				Object o = all.get(i);
				if (o instanceof EAttribute) {
					point.attr = (EAttribute) o;
					risp = true;
					
				} else if (o instanceof EReference) {
					EReference ref = (EReference) o;
					if ( ref.isMany() ) {
						point.attr = ref;
						risp = true;
					} else {
						
						EObject newObj = (EObject) point.pointer.eGet(ref);
						if (newObj != null) {
							point.pointer = newObj;
							point.attr = null;
							risp = true;
						}
					}
				} else {
				
					Messages.sendDebugNl("goNextChild ?? unsupported feature");
				}
				
			}
		
		}
		return risp;
	}
	/* (non-Javadoc)
	 * @see rtdruid.vartree.IVarTreePointer#goParent()
	 */
	public boolean goParent() {
		return go(GO_PARENT);
	}
	
	
	//-------------------------------
	
	protected IVariable convert(Class<?> type, EList<?> values) {
		MultiValues risp = null;
		
		if (type == StringVar.class) {			risp = new StringMVar(); }
		else if (type == IntegerVar.class) {	risp = new IntegerMVar(); }
		else if (type == LongVar.class) {		risp = new LongMVar(); }
		else if (type == DoubleVar.class) {		risp = new DoubleMVar(); }
		else if (type == FloatVar.class) {		risp = new FloatMVar(); }
		else if (type == BooleanVar.class) {	risp = new BooleanMVar(); }
		else if (type == TimeVar.class) {		risp = new TimeMVar(); }
		else { throw new RuntimeException("Illegal var type :" + type); }
	
		if (values != null) {
			for (int i=0; i< values.size(); i++) {
				IVariable v = (IVariable) values.get(i);
				risp.appendValue( v.toString() );
				
			}
		}
	
		return risp;
	}

	protected IVariable getEmptyVar(Class<?> type) {
		IVariable risp = null;
		
		if (type == StringVar.class) {			risp = new StringVar(); }
		else if (type == IntegerVar.class) {	risp = new IntegerVar(); }
		else if (type == LongVar.class) {		risp = new LongVar(); }
		else if (type == DoubleVar.class) {		risp = new DoubleVar(); }
		else if (type == FloatVar.class) {		risp = new FloatVar(); }
		else if (type == BooleanVar.class) {	risp = new BooleanVar(); }
		else if (type == TimeVar.class) {		risp = new TimeVar(); }
		else if (type == PropertyVar.class) {	risp = new PropertyVar(); }
		else { throw new RuntimeException("Illegal var type :" + type); }
	
		return risp;
	}
	
	/* (non-Javadoc)
	 * @see rtdruid.vartree.IVarTreePointer#getVar()
	 */
	public boolean isVarSet() {
		if (point.attr != null && point.attr instanceof EAttribute) {
			return point.pointer.eIsSet(point.attr);  
		}
		throw new IllegalStateException("try to get a var from a container");
	}

	/* (non-Javadoc)
	 * @see rtdruid.vartree.IVarTreePointer#getVar()
	 */
	public IVariable getVar() {
		if (point.attr != null && point.attr instanceof EAttribute) {

			if (point.attr.isMany()) {
			
				return convert(
					( (EAttribute) point.attr).getEAttributeType().getInstanceClass(),
					(EList<?>) point.pointer.eGet(point.attr) );
			
			} else {
				IVariable risp = (IVariable) point.pointer.eGet(point.attr);  

				if (risp == null) {
				    
//				    if ( treeFactory instanceof DataFactory) {
//				        risp = (IVariable) ((DataFactoryImpl) treeFactory).createExtendedVarFromString(( (EAttribute) point.attr).getEAttributeType(), null );
//				    } else 
				    {
				        risp = (IVariable) EcoreUtil.createFromString(( (EAttribute) point.attr).getEAttributeType(), null );
				    }
				} else {
					risp = (IVariable) risp.clone();
				}
				
				return risp;
			}			
			
		}
		throw new IllegalStateException("try to get a var from a container");
	}


	/* (non-Javadoc)
	 * @see rtdruid.vartree.IVarTreePointer#getVar()
	 */
	public IVariable getNewVar() {
		return getNewVar(null);
	}
	/* (non-Javadoc)
	 * @see rtdruid.vartree.IVarTreePointer#getVar()
	 */
	public IVariable getNewVar(String value) {
		if (point.attr != null && point.attr instanceof EAttribute) {

			EAttribute at = (EAttribute) point.attr;
			EDataType atType = at.getEAttributeType();
			Class<?> type = atType.getInstanceClass();

			IVariable risp = null;
			
			if (at.isMany()) {
				risp = convert(type, null);
				if (value != null) {
					risp.set(value);
					///*DEBUG*/			throw new Error("Values must be set: " + value);
				}

	
			} else {

//				if (treeFactory instanceof DataFactory) {
//					risp = (IVariable) ((DataFactoryImpl) treeFactory)
//							.createExtendedVarFromString(atType, value);
//				} else
				{
					risp = (IVariable) EcoreUtil.createFromString(atType, value);
				}
				
				if (risp == null) {
					risp = getEmptyVar(type);
				}
			}

			return risp;
			
		}
		throw new IllegalStateException("try to get a var from a container");
	}

	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.vartree.IVarTreePointer#getDefaultValue()
	 */
	@Override
	public Object getDefaultValue() {
		if (point.attr != null && point.attr instanceof EAttribute) {

			EAttribute at = (EAttribute) point.attr;
			return at.getDefaultValue();
		}
		throw new IllegalStateException("try to get a var from a container");
	}
	
	/* (non-Javadoc)
	 * @see rtdruid.vartree.IVarTreePointer#setVar(rtdruid.vartree.variables.IVariable)
	 */
	public void setVar(IVariable var) {
		if (point.attr != null && point.attr instanceof EAttribute) {
			EAttribute at = (EAttribute) point.attr;
			if (at.isMany()) {
				BasicEList<Object> val = new BasicEList<Object>();
				
				if (var != null) {
					if (var instanceof MultiValues) {
						IMultiValues mv = (IMultiValues) var;
						for (int l=0; l< mv.sizeValues(); l++) {
							val.add(EcoreUtil.createFromString(at.getEAttributeType(), mv.getValues(l) ));
						}
						
						
					} else {
						if (var.get() != null) {
						    Object o = EcoreUtil.createFromString(at.getEAttributeType(), var.toString() );
							if (o!= null) {
							    val.add(o);
							}
							
						}
						
					}
				}

				{ // set the new value
					execSetValueCommand(point.pointer, at, val);
					//point.pointer.eSet( at, val);
					return ;
				}

			} else {
				Object tmp = null;

				if (var != null) {
					if (var instanceof MultiValues) {
						throw new IllegalArgumentException("Not valid argument: try to use a MultiValues for a mono value attribute !!!");
						
					} else {
						if (var.get() != null) {
							if (at.getEAttributeType().getInstanceClass().isInstance(var)) {
								tmp = var.clone();
							} else {
							// check type 
								tmp = EcoreUtil.createFromString(at.getEAttributeType(), var.toString() );
							}
						}
						
					}
				}

				{ // set the new value
					execSetValueCommand(point.pointer, at, tmp);
					// point.pointer.eSet( at, tmp);
					return ;
				}

				
			}
		}
		throw new IllegalStateException("try to set a var in a container");
	}
	/* (non-Javadoc)
	 * @see rtdruid.vartree.IVarTreePointer#getName()
	 */
	public String getName() {
		if (point.pointer == null) {
			return null;
		}
		
		if (point.attr != null) {
			return point.attr.getName();
		}
		//return ((ObjectWithID) point.pointer).getObjectID();
		return DataPath.addSlash(VarTreeIdHandler.getId(point.pointer));
	}
	/* (non-Javadoc)
	 * @see rtdruid.vartree.IVarTreePointer#getType()
	 */
	public String getType() {
		if (point.pointer == null) {
			return "root_Node's_Type";
		}
		if (point.attr != null) {
			if (point.attr instanceof EAttribute) {
				return ((EAttribute) point.attr).getEAttributeType().getName()
					 + (point.attr.isMany() ? "[]" : "");
			}
			else if (point.attr instanceof EReference) {
				if (point.attr.isMany()) {
					return point.attr.getName();	
				} //else {
				
				throw new IllegalStateException("Cannot have getType of a one to one reference");
				
			} // else {
			
			throw new IllegalStateException("Unknow structural feature");
		}
		
		return point.pointer.eClass().getName();
	}
	/* (non-Javadoc)
	 * @see rtdruid.vartree.IVarTreePointer#isContainer()
	 */
	public boolean isContainer() {
		return (point.attr == null ? true :
			(point.attr instanceof EReference ));
	}
	/* (non-Javadoc)
	 * @see rtdruid.vartree.IVarTreePointer#isList()
	 */
	public boolean isList() {
		return point.attr != null && point.attr.isMany();
	}
	
	/**
	 */
	public void destroy() {
		if (point.attr != null) {
			
			if (point.attr instanceof EAttribute) {
				// remove current attribute
				execSetValueCommand(point.pointer, (EAttribute) point.attr, null);
			} else {
				// remove a Reference
				execClearCommand(point.pointer, (EReference) point.attr);
			}
//			point.pointer.eUnset(point.attr);
			point.attr = null;
		} else {
			LittlePointer lp = (LittlePointer) point.clone();
			EObject parent = lp.pointer.eContainer();

			if (parent == null) { // current node is "System"
				root.clear();
				point.pointer = null;
				point.attr = null;
				execFlushCommandStack();
			} else {
				point.pointer = parent;
				EReference ref = lp.pointer.eContainmentFeature(); 
				if (ref.isMany()) {
					point.attr = ref;
					//EList childs = (EList) point.pointer.eGet(ref);
					//childs.remove(lp.pointer);
					BasicEList<EObject> col = new BasicEList<EObject>();
					col.add(lp.pointer);
					execRemoveCommand(point.pointer, ref, col);
				} else {
					point.attr = null;
					//point.pointer.eUnset(ref);
					execClearCommand(point.pointer, ref);
				}
			}
		}
	}

	// ------------------------------------------
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.vartree.IVarTreePointer#getEPoint()
	 */
	@Override
	public EmfPoint getEPoint() {
		return point.clone();
	}
	
	
	// ------------------------------------------

	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.vartree.IVarTreePointer#makePath(java.util.Collection, java.util.Collection)
	 */
	@Override
	public IVarTreePointer makePath(Collection<String> names, Collection<String> types) {
		String[] tnames = names == null? null : (String[]) names.toArray(new String[names.size()]);
		String[] ttypes = types == null? null : (String[]) types.toArray(new String[types.size()]);
		return makePath(tnames, ttypes);
	}

	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.vartree.IVarTreePointer#makePath(java.lang.String[], java.lang.String[])
	 */
	@Override
	public IVarTreePointer makePath(String[] names, String[] types) {
		// if vtp, names or types is null it will throw an NullPointerException;
		// If the code is correct, it will never throw that exception.
		// Otherwise I need to add a check for array's lengths
		Assert.isNotNull(names);
		Assert.isNotNull(types);
		Assert.isLegal(names.length == types.length);

		for (int i = 0; i < names.length; i++) {
			// try to go into the required node

			if (!go(names[i]/* DataPath.addSlash(names[i]) */)) {
				String newName = null;
				// try to add it
				try {
					newName = add(DataPath.removeSlash(names[i]), types[i]);
				} catch (Exception e) {
					throw new RuntimeException("Cannot create " + names[i] + " (" + types[i] + "): " + e.getMessage(),
							e);
				}

				// try again to go in the new node
				if (!go(names[i]/* DataPath.addSlash(names[i]) */)) {

					if (go(newName)) {
						// may happen with oil enumerators
						// RtdruidLog.showDebug("Check makePath .....");
					} else {

						if (getVar() == null) {
							throw new RuntimeException("Error when try to add a node :\n\t" + "name = " + names[i]
									+ " ,type = " + types[i]);
						}
					}
				}
			}
		}
		return this;
	}
}
