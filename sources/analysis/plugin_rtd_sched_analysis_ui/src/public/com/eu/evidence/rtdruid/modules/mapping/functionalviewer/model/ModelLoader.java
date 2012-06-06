/*
 * Created on Feb 21, 2005
 *
 * $Id: ModelLoader.java,v 1.1 2005/09/28 15:22:29 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.mapping.functionalviewer.model;



import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;

import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVarTreePointer;
import com.eu.evidence.rtdruid.vartree.IVariable;
import com.eu.evidence.rtdruid.vartree.VarTreePointerEMF;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.tools.Search;
import com.eu.evidence.rtdruid.vartree.tools.Utility;
import com.eu.evidence.rtdruid.vartree.variables.MultiValues;

/**
 * 
 * TODO : Commentare && Tradurre
 * 
 * @author Nicola Serreli
 */
public class ModelLoader {
	protected final DataPackage dpkg = DataPackage.eINSTANCE;

	protected final char S = DataPath.SEPARATOR;

	protected final static String[] PROC_STD_METHODS = new String[] { "run" };

	protected final static String[] VAR_STD_METHODS = new String[] { "read",
			"write" };

	protected final static String METHOD_PROVIDED_EXCEPTION = "A method is provided by two distinct objects.";

	static protected class ReqMethod {
		public final String methodID;

		public final GGate consumer;

		public ReqMethod(String methodId, GGate consumer) {
			this.methodID = methodId;
			this.consumer = consumer;
		}

		public String toString() {
			return "" + consumer.parent + " requires " + methodID;
		}
	}

	public ModelLoader() {

	}

	/***************************************************************************
	 * 
	 * DATA FLOW MODEL
	 *  
	 **************************************************************************/

	/**
	 * This method loads a Data Flow from a specified VarTree
	 * 
	 * @param vt
	 *            contains all data. If null, returns an empty model
	 * 
	 * @return a GSystem that contains a Data Flow model for specified VarTree
	 */
	public GSystem loadDataFlow(IVarTree vt) {

		if (vt == null) {
			return new GSystem(null, "");
		}

		GSystem system;

		IVarTreePointer vtp = vt.newVarTreePointer();
		ITreeInterface ti = vt.newTreeInterface();

		String[] names = ti.getAllName(null, dpkg.getSystem().getName());

		if (names != null && names.length != 0) {

			system = new GSystem(null, names[0]);

			String path = names[0] + S + dpkg.getSystem_Functional().getName()
					+ S;

			boolean ok = vtp.goAbsolute("" + S + path
					+ dpkg.getFunctional_Implementation().getName());
			ok &= vtp.getChildrenNumber() > 0;
			if (ok) {
				vtp.goFirstChild();
				loadDataFlow(system, GComponent.ROOT_PREFIX, vtp, null, null);
			}
		} else {
			system = new GSystem(null, "");
		}

		return system;
	}

	/**
	 * This method recursively loads a Data Flow from a specified point of a
	 * VarTree.
	 * 
	 * Adds all children of current node and calls new instances of this method
	 * on all subsystem of this node.
	 * 
	 * @param parent
	 *            identifies the model's object that represents current node.
	 * @param prefix
	 *            contains the absolute identifier of the model's object that
	 *            represents current node.
	 * @param vtp
	 *            identifies the current node
	 * @param requiredMethods
	 *            all methods required by parent node
	 * @param providedMethods
	 *            all methods provided by parent node
	 */
	protected void loadDataFlow(GStructured parent, String prefix,
			IVarTreePointer vtp, ArrayList requiredMethods,
			HashMap providedMethods) {
		boolean ok;

		if (requiredMethods == null) {
			requiredMethods = new ArrayList();
		}
		if (providedMethods == null) {
			providedMethods = new HashMap();
		}

		// load all objects (proc, var, subsystem)
		do {

			if (checkStrings(vtp.getType(), dpkg.getProc().getName())) {
				/***************************************************************
				 * P R O C
				 **************************************************************/
				IVarTreePointer lvtp = (IVarTreePointer) vtp.clone();

				String name = lvtp.getName();
				GProc proc = new GProc(getEObject(lvtp), name, prefix);
				parent.addChild(proc);

				{
					// add "run" (as default method)
					addLocalProvidedMethod(providedMethods, proc,
							PROC_STD_METHODS);

					// add all declared methods
					ok = lvtp.go(dpkg.getProc_Methods().getName());
					ok &= !lvtp.isContainer();
					if (ok) {
						IVariable var = lvtp.getVar();

						String[] values = varToArray(var);

						addLocalProvidedMethod(providedMethods, proc, values);
					}
				}

				{
					lvtp = (IVarTreePointer) vtp.clone();
					ok = lvtp.go(dpkg.getProc_MethodRefList().getName());
					ok &= lvtp.getChildrenNumber() > 0;
					if (ok) {
						for (ok = lvtp.goFirstChild(); ok; ok = lvtp
								.goNextSibling()) {

							String methName = getValue(lvtp, dpkg
									.getMethodRef_MethodName().getName());

							if (methName != null) {
								proc.addRequiredMethods(methName);

								requiredMethods.add(new ReqMethod(methName,
										proc.getOutputGate()));
							}

						}

					}
				}

			} else if (checkStrings(vtp.getType(), dpkg.getVar().getName())) {
				/***************************************************************
				 * V A R
				 **************************************************************/
				IVarTreePointer lvtp = (IVarTreePointer) vtp.clone();

				String name = lvtp.getName();
				GVar gvar = new GVar(getEObject(lvtp), name, prefix);
				parent.addChild(gvar);

				{
					// add "read" and "write" (as default methods)
					addLocalProvidedMethod(providedMethods, gvar,
							VAR_STD_METHODS);

					// add all declared methods
					ok = lvtp.go(dpkg.getProc_Methods().getName());
					ok &= !lvtp.isContainer();
					if (ok) {
						IVariable var = lvtp.getVar();

						String[] values = varToArray(var);

						addLocalProvidedMethod(providedMethods, gvar, values);
					}
				}

			} else if (checkStrings(vtp.getType(), dpkg.getTrigger().getName())) {

			} else if (checkStrings(vtp.getType(), dpkg.getSubSystem()
					.getName())) {
				/***************************************************************
				 * S U B S Y S T E M
				 **************************************************************/
				IVarTreePointer lvtp = (IVarTreePointer) vtp.clone();

				String name = lvtp.getName();
				GSubsystem subsystem = new GSubsystem(getEObject(lvtp), name,
						prefix);
				parent.addChild(subsystem);

				ArrayList subSystemIntMethRef = new ArrayList();
				HashMap subSystemIntProvMeth = new HashMap();

				{ // PROVIDED INTERFACE
					lvtp = (IVarTreePointer) vtp.clone();
					ok = lvtp.go(dpkg.getSubSystem_ProvidedInterfaceList()
							.getName());
					ok &= lvtp.getChildrenNumber() > 0;
					if (ok) {
						for (ok = lvtp.goFirstChild(); ok; ok = lvtp
								.goNextSibling()) {

							String extName = getValue(lvtp, dpkg
									.getProvidedInterface_Name().getName());
							String intName = null;
							{
								String intMethName = getValue(lvtp, dpkg
										.getProvidedInterface_LocalMethodRef()
										.getName());
								String intObjName = getValue(lvtp, dpkg
										.getProvidedInterface_LocalObjectRef()
										.getName());
								if (intMethName != null && intObjName != null) {
									intName = Utility.pathToEvidence(DataPath
											.addSlash(intObjName)
											+ S
											+ DataPath.addSlash(intMethName));
								}
							}

							if (extName != null) {
								GSubsystem.GProvidedInterface gpi = subsystem
										.addProvidedInterface(extName, intName);

								Object o = providedMethods
										.get(gpi.externalMethod.getLocalID());
								if (o != null) {
									if (o != subsystem) {
										throw new RuntimeException(
												METHOD_PROVIDED_EXCEPTION);
									}
								} else {
									providedMethods.put(gpi.externalMethod
											.getLocalID(), gpi.externalMethod);
								}

								if (intName != null) {
									subSystemIntMethRef.add(new ReqMethod(
											intName, gpi.internalGate));
								}
							}
						}
					}
				}

				{ // REQURIED INTERFACE
					lvtp = (IVarTreePointer) vtp.clone();
					ok = lvtp.go(dpkg.getSubSystem_RequiredInterfaceList()
							.getName());
					ok &= lvtp.getChildrenNumber() > 0;
					if (ok) {
						for (ok = lvtp.goFirstChild(); ok; ok = lvtp
								.goNextSibling()) {

							String intName = getValue(lvtp, dpkg
									.getRequiredInterface_Name().getName());
							String extName = getValue(lvtp, dpkg
									.getRequiredInterface_ExternalMethodRef()
									.getName());

							if (intName != null) {
								GSubsystem.GRequiredInterface gri = subsystem
										.addRequiredInterface(extName, intName);

								subSystemIntProvMeth.put(gri.internalMethod
										.getLocalID(), gri.internalMethod);

								if (extName != null) {
									requiredMethods.add(new ReqMethod(extName,
											gri.externalGate));
								}

							}
						}
					}
				}

				{ // CHILD
					lvtp = (IVarTreePointer) vtp.clone();
					ok = lvtp.go(dpkg.getSubSystem_Implementation().getName());
					ok &= lvtp.getChildrenNumber() > 0;
					if (ok) {
						lvtp.goFirstChild();
						loadDataFlow(subsystem, prefix + S
								+ Utility.pathToEvidence(name), lvtp,
								subSystemIntMethRef, subSystemIntProvMeth);
					}
				}

			}

		} while (vtp.goNextSibling());

		// make all Connections

		for (int i = 0; i < requiredMethods.size(); i++) {

			ReqMethod reqMethod = (ReqMethod) requiredMethods.get(i);

			ProvidedMethod pm = (ProvidedMethod) providedMethods
					.get(reqMethod.methodID);
			if (pm != null) {
				if (pm.getProvider() instanceof GVar
						&& reqMethod.methodID.endsWith("read")) {
					new GMethodRefConnection(pm.getGate(), reqMethod.consumer,
							pm);

				} else {

					new GMethodRefConnection(reqMethod.consumer, pm.getGate(),
							pm);
				}
			}

		}

	}

	/***************************************************************************
	 * 
	 * FUNCTIONAL FLOW MODEL
	 *  
	 **************************************************************************/

	/**
	 * This method loads a Functional Flow from a specified VarTree
	 * 
	 * @param vt
	 *            contains all data. If null, returns an empty model
	 * 
	 * @return a GSystem that contains a Functional Flow model for specified
	 *         VarTree
	 */
	public GSystem loadFunctionalFlow(IVarTree vt) {

		if (vt == null) {
			return new GSystem(null, "");
		}

		GSystem system;

		IVarTreePointer vtp = vt.newVarTreePointer();
		ITreeInterface ti = vt.newTreeInterface();

		String[] names = ti.getAllName(null, dpkg.getSystem().getName());

		if (names != null && names.length != 0) {


			// load the model
			system = new GSystem(null, names[0]);

			String path = ""+S+names[0] + S + dpkg.getSystem_Functional().getName()
					+ S;

			boolean ok = vtp.goAbsolute(path
					+ dpkg.getFunctional_Implementation().getName());
			ok &= vtp.getChildrenNumber() > 0;
			if (ok) {

				HashMap referencedMethods = new HashMap();

				loadTrigger(system, vt, path +dpkg.getFunctional_Implementation().getName(), referencedMethods);
				
				// load all partial order
				loadPartialOrder(system, vt, path, null, referencedMethods);
				
			}


		} else {
			system = new GSystem(null, "");
		}

		return system;
	}

	/**
	 * Loads all triggers and methods referenced by them.
	 * 
	 * Referenced methods will be stored inside the specified hashMap, using
	 * MethodRefName as key and GProvidedMethod as Object.
	 * 
	 * @param system
	 *            is the current model elemento for the System
	 * @param vt
	 *            contains all data
	 * @param path
	 *            identifies the implementation node inside the System's
	 *            Functional element
	 * @param referencedMethods
	 *            will contains all referencedMethods.
	 *  
	 */
	protected void loadTrigger(GSystem system, IVarTree vt, String path, HashMap referencedMethods) {

		// go to Implementation Node
		IVarTreePointer vtp = vt.newVarTreePointer();
		vtp.goAbsolute(path);
		vtp.goFirstChild(); // First Functional's implementation's child
		
		// compute all Provided Methods
		HashMap allProvidedMethods = new HashMap();
		loadMethodProvided(GComponent.ROOT_PREFIX, (IVarTreePointer) vtp.clone(),
					allProvidedMethods);
		
		
		boolean ok;
		
		// check only for Triggers
		do {

			if (checkStrings(vtp.getType(), dpkg.getTrigger().getName())) {
				/***************************************************************
				 * T R I G G E R
				 **************************************************************/

				 IVarTreePointer lvtp = (IVarTreePointer) vtp.clone();
				 String name = lvtp.getName();
				 
				 boolean addTrigger = false;
				 
				 GTrigger trigger = new GTrigger(getEObject(lvtp), name);
				 {
						lvtp = (IVarTreePointer) vtp.clone();
						ok = lvtp.go(dpkg.getProc_MethodRefList().getName());
						ok &= lvtp.getChildrenNumber() > 0;
						if (ok) {
							for (ok = lvtp.goFirstChild(); ok; ok = lvtp
									.goNextSibling()) {
				
								String methodRefName = lvtp.getName();
								String methName = getValue(lvtp, dpkg
										.getMethodRef_MethodName().getName());
				
								// search the method (if not null)
								if (methName != null && allProvidedMethods.containsKey(methName)) {
									addTrigger = true;
									
									GProvidedMethod gpm = (GProvidedMethod) allProvidedMethods.get(methName);
									
									referencedMethods.put(Utility.pathToEvidence(name)+S+methodRefName, gpm);
									
									if (!system.getChildren().contains(gpm)) {
										system.addChild(gpm);
									}
									
									new GTriggerActivationConnection(trigger.getOutputGate(), gpm.getActivationGate());
									
								}
				
							}
						}
				 }
				 
				 // if this trigger has at least one valid methodRef, add it to Model
				 if (addTrigger) {
				 	system.addChild(trigger);
				 }
				
			}
		} while (vtp.goNextSibling());

	}
	
	
	/**
	 * This method recursively searchs all Methods and stores them inside the
	 * provided hashMap.
	 * 
	 * Each new method is identified by its globalId
	 * 
	 * @param prefix
	 *            contains the absolute identifier of the model's object that
	 *            represents current node.
	 * @param vtp
	 *            identifies the current node
	 * @param allProvidedMethods
	 *            where store all Methods
	 */
	protected void loadMethodProvided(String prefix, IVarTreePointer vtp,
			HashMap allProvidedMethods) {
		boolean ok;

		// load all methods (from proc, var and subsystem)
		do {

			if (checkStrings(vtp.getType(), dpkg.getProc().getName())) {
				/***************************************************************
				 * P R O C
				 **************************************************************/
				IVarTreePointer lvtp = (IVarTreePointer) vtp.clone();

				String name = lvtp.getName();
				GProc proc = new GProc(getEObject(lvtp), name, prefix);

				{
					// add "run" (as default method)
					addGlobalProvidedMethod(allProvidedMethods, proc,
							PROC_STD_METHODS);

					// add all declared methods
					ok = lvtp.go(dpkg.getProc_Methods().getName());
					ok &= !lvtp.isContainer();
					if (ok) {
						IVariable var = lvtp.getVar();

						String[] values = varToArray(var);

						addGlobalProvidedMethod(allProvidedMethods, proc,
								values);
					}
				}

			} else if (checkStrings(vtp.getType(), dpkg.getVar().getName())) {
				/***************************************************************
				 * V A R
				 **************************************************************/
				//IVarTreePointer lvtp = (IVarTreePointer) vtp.clone();
				//
				//String name = lvtp.getName();
				//GVar gvar = new GVar(getEObject(lvtp), name, prefix);
				//
				//{
				//	// add "read" and "write" (as default methods)
				//	addGlobalProvidedMethod(allProvidedMethods, gvar,
				//			VAR_STD_METHODS);
				//
				//	// add all declared methods
				//	ok = lvtp.go(dpkg.getProc_Methods().getName());
				//	ok &= !lvtp.isContainer();
				//	if (ok) {
				//		IVariable var = lvtp.getVar();
				//
				//		String[] values = varToArray(var);
				//
				//		addGlobalProvidedMethod(allProvidedMethods, gvar,
				//				values);
				//	}
				//}

			} else if (checkStrings(vtp.getType(), dpkg.getSubSystem()
					.getName())) {
				/***************************************************************
				 * S U B S Y S T E M
				 **************************************************************/
				IVarTreePointer lvtp = (IVarTreePointer) vtp.clone();

				String name = lvtp.getName();
				GSubsystem subsystem = new GSubsystem(getEObject(lvtp), name,
						prefix);

				{ // PROVIDED INTERFACE
					lvtp = (IVarTreePointer) vtp.clone();
					ok = lvtp.go(dpkg.getSubSystem_ProvidedInterfaceList()
							.getName());
					ok &= lvtp.getChildrenNumber() > 0;
					if (ok) {
						for (ok = lvtp.goFirstChild(); ok; ok = lvtp
								.goNextSibling()) {

							String extName = getValue(lvtp, dpkg
									.getProvidedInterface_Name().getName());
							String intName = null;
							{
								String intMethName = getValue(lvtp, dpkg
										.getProvidedInterface_LocalMethodRef()
										.getName());
								String intObjName = getValue(lvtp, dpkg
										.getProvidedInterface_LocalObjectRef()
										.getName());
								if (intMethName != null && intObjName != null) {
									intName = Utility.pathToEvidence(DataPath
											.addSlash(intObjName)
											+ S
											+ DataPath.addSlash(intMethName));
								}
							}

							if (extName != null) {
								subsystem
										.addProvidedInterface(extName, intName);

								GSubsystem.GProvidedInterface gpi = subsystem
										.addProvidedInterface(extName, intName);

								Object o = allProvidedMethods
										.get(gpi.externalMethod.getGlobalID());
								if (o != null) {
									if (o != subsystem) {
										throw new RuntimeException(
												METHOD_PROVIDED_EXCEPTION);
									}
								} else {
									allProvidedMethods.put(gpi.externalMethod
											.getGlobalID(), gpi.externalMethod);
								}

							}
						}
					}
				}

				/* REQURIED INTERFACE are not useful for this model */

				{ // CHILD
					lvtp = (IVarTreePointer) vtp.clone();
					ok = lvtp.go(dpkg.getSubSystem_Implementation().getName());
					ok &= lvtp.getChildrenNumber() > 0;
					if (ok) {
						lvtp.goFirstChild();
						loadMethodProvided(prefix + S
								+ Utility.pathToEvidence(name), lvtp,
								allProvidedMethods);
					}
				}

			}

		} while (vtp.goNextSibling());
	}

	/**
	 * This method search all PartialOrder and adds all connections between
	 * procs.
	 * 
	 * @param system
	 *            identifies the Functional Model.
	 * @param vt
	 *            contains all data
	 * @param path
	 *            identifies the path of a particular Partial Order (for a
	 *            specific mode)
	 * @param mode
	 *            the mode of Partial Order
	 */
	protected void loadPartialOrder(GSystem system, IVarTree vt, String path,
			String mode, HashMap referencedMethods) {

		String systemPrefix = DataPath.splitPath(path)[0];

		ITreeInterface ti = vt.newTreeInterface();

		path += S + dpkg.getFunctional_PartialOrderList().getName() + S
				+ DataPath.addSlash(mode) + S
				+ dpkg.getPartialOrder_OrderList().getName();

		String[] partialOrderNames = ti.getAllName(path, dpkg.getOrder()
				.getName());

		for (int i = 0; i < partialOrderNames.length; i++) {
			final boolean enableOutput = true;
			// get data about current partialorder
			final String currPath = path + S + partialOrderNames[i] + S;

			if (enableOutput) {
				System.out.println("\nPartial Order \nName    "
						+ partialOrderNames[i]);
			}

			/*******************************************************************
			 * FIRST EVENT
			 ******************************************************************/
			final GGate first;
			{
				final String firstEvent = varToString(ti.getValue(currPath
						+ dpkg.getOrder_FirstEvent().getName()));
				if (enableOutput) {
					System.out.println("First   " + firstEvent);
				}
				if (firstEvent == null)
					continue;

				final String eventPath1 = Search.anEvent(ti, systemPrefix,
						firstEvent);
				if (enableOutput) {
					System.out.println("Event   " + eventPath1);
				}
				if (eventPath1 == null)
					continue;

				final String eventMethodRef1 = varToString(ti
						.getValue(eventPath1 + S
								+ dpkg.getEvent_MethodRefName().getName()));
				if (enableOutput) {
					System.out.println("MethRef " + eventMethodRef1);
				}
				if (eventMethodRef1 == null)
					continue;

				
				final GProvidedMethod gpm = getComponentByMethodRef(eventMethodRef1, referencedMethods);
				first = gpm == null ? null : gpm.getEndGate();
				if (first == null)
					continue;
			}

			/*******************************************************************
			 * SECOND EVENT
			 ******************************************************************/
			final GGate second;
			{
				final String secondEvent = varToString(ti.getValue(currPath
						+ dpkg.getOrder_SecondEvent().getName()));
				if (enableOutput) {
					System.out.println("First   " + secondEvent);
				}
				if (secondEvent == null)
					continue;

				final String eventPath2 = Search.anEvent(ti, systemPrefix,
						secondEvent);
				if (enableOutput) {
					System.out.println("Event   " + eventPath2);
				}
				if (eventPath2 == null)
					continue;

				final String eventMethodRef2 = varToString(ti
						.getValue(eventPath2 + S
								+ dpkg.getEvent_MethodRefName().getName()));
				if (enableOutput) {
					System.out.println("MethRef " + eventMethodRef2);
				}
				if (eventMethodRef2 == null)
					continue;

				final GProvidedMethod gpm = getComponentByMethodRef(eventMethodRef2, referencedMethods);
				second = gpm == null ? null : gpm.getActivationGate();
				if (second == null)
					continue;
			}

			/*******************************************************************
			 * CONNECT EVENTS BY PARTIAL ORDER
			 ******************************************************************/

			new GPartialOrderConnection(first, second);

			/*
			 * System.out.println("Partial Order \n"+ "Name " +
			 * partialOrderNames[i] +"\n"+ "First " + var1 + "\n"+ "Second " +
			 * var2 + "\n"+ "Event1 " + eventPath1 + "\n"+ "Event2 " +
			 * eventPath2) ;
			 *  
			 */
		}
	}

	/**
	 * Searchs a Trigger's MethodRef and then searchs the referenced method
	 * using its identificator as path ( [subsystem/]*objName/methodName).
	 * ObjName is a subSystem or a Proc or a Var.
	 * 
	 * Before returns the Graphical Element that represent the required method,
	 * this method adds it to specified GSystem.
	 * 
	 * @param vt contains all data
	 * @param methodRef
	 *            the methodRef identificator (writed using Evidence path rules)
	 * @param system
	 *            contains all elements that represents this system
	 * 
	 * @return the Graphical Element that represent the required method, or null
	 *         if not found
	 * 
	 * @throws NullPointerException
	 *             if system or methodName is null
	 */
	protected GProvidedMethod getComponentByMethodRef(String methodRef, HashMap referencedMethods) {

		// search the referenced method
		Object o = referencedMethods.get(methodRef);
		if (o instanceof GProvidedMethod) {
			return (GProvidedMethod) o;
		}
		return null;
	}

	/***************************************************************************
	 * UTILITIES
	 **************************************************************************/

	/**
	 * This methos checks if two strings contains the same value or are both
	 * null.
	 * 
	 * @return true only if a and b have the same value or if a and b are null.
	 */
	protected boolean checkStrings(String a, String b) {
		return a == null ? b == null : a.equals(b);
	}

	/**
	 * Get the string representetion of value stored inside a child.
	 * 
	 * If the child contains a MultiValues IVariable, take only the first value.
	 * 
	 * @return the value stored inside the var of specified child. Returns only
	 *         the first value of a MultiValues Var. If the child is not found
	 *         or if it isn't a leaf or if has a null IVariable, this method
	 *         returns null.
	 */
	protected String getValue(IVarTreePointer vtp, String child) {
		vtp = (IVarTreePointer) vtp.clone();
		boolean ok = vtp.go(child);
		ok &= !vtp.isContainer();
		if (ok) {
			IVariable var = vtp.getVar();
			String[] values = varToArray(var);
			if (values != null && values.length > 0) {
				return values[0];
			}
		}
		return null;
	}

	/**
	 * Take the value stored in a specified IVariable.
	 * 
	 * If the IVariable is null or empty, returns a null string. If the var is a
	 * MultiValues IVariable returns the first value (if there is one or more).
	 * 
	 * @return a null string if the var is null or empty. If the var is a
	 *         MultiValues IVariable returns the first value (if it has one or
	 *         more values).
	 */
	protected String varToString(IVariable var) {
		if (var == null) {
			return null;
		}

		String answer = null;
		if (var instanceof MultiValues) {
			String[] t = ((MultiValues) var).getValues();
			if (t != null && t.length > 0) {
				answer = t[0];
			}
		} else {
			answer = var.get() == null ? null : var.toString();
		}

		return answer;
	}

	/**
	 * Take all values stored in a specified IVariable.
	 * 
	 * If the IVariable is null or empty, returns a null array. Otherwise returns
	 * an array of String, even if the var isn't a MultiValues IVariable (in that
	 * case the answer is an array with only one value).
	 * 
	 * Each string is the "string representetion" of each value.
	 * 
	 * @return a null array if the var is null or empty. Otherwise returns a not
	 *         null array of String, even if the var isn't a MultiValues
	 *         IVariable (in that case the answer is an array with only one
	 *         value).
	 */
	protected String[] varToArray(IVariable var) {
		if (var == null) {
			return null;
		}

		String[] answer = null;
		if (var instanceof MultiValues) {
			answer = ((MultiValues) var).getValues();
		} else {
			answer = var.get() == null ? null : new String[] { var.toString() };
		}

		return answer;
	}

	/**
	 * Add one or more methods to ProvidedMethod_List of a specified
	 * methodProvider. Then these methods are added to the list of all methods
	 * availables at current level (subSystem).
	 * 
	 * Each providedMethod is stored using its LocalId as HashMap's Key.
	 * 
	 * @param providedMethods
	 *            is the current list of all available methods at the current
	 *            level (subSystem) .
	 * @param methodsProvider
	 *            is the object the provide all specified methods
	 * @param methodNames
	 *            is the list of all methods
	 */
	protected void addLocalProvidedMethod(HashMap providedMethods,
			IGMethodsProvider methodsProvider, String[] methodNames) {

		if (methodNames == null) {
			// nothing to do
			return;
		}

		// store all methods
		for (int i = 0; i < methodNames.length; i++) {

			// register a new method
			ProvidedMethod pm = methodsProvider
					.addProvidedMethods(methodNames[i]);

			if (providedMethods != null) {
				// search the new method inside the complete list
				ProvidedMethod o = (ProvidedMethod) providedMethods.get(pm
						.getLocalID());
				if (o != null) {
					// check if it's all ok
					if (o.getProvider() != methodsProvider) {
						throw new RuntimeException(METHOD_PROVIDED_EXCEPTION);
					}
				} else {
					// add a new one
					providedMethods.put(pm.getLocalID(), pm);
				}
			}
		}
	}

	/**
	 * Add one or more methods to ProvidedMethod_List of a specified
	 * methodProvider. Then these methods are added to the list of all methods
	 * availables inside the all system.
	 * 
	 * Each providedMethod is stored using its GlobalId as HashMap's Key.
	 * 
	 * @param providedMethods
	 *            is the current list of all available methods inside the all
	 *            system.
	 * @param methodsProvider
	 *            is the object the provide all specified methods
	 * @param methodNames
	 *            is the list of all methods
	 */
	protected void addGlobalProvidedMethod(HashMap providedMethods,
			IGMethodsProvider methodsProvider, String[] methodNames) {

		if (methodNames == null) {
			// nothing to do
			return;
		}

		// store all methods
		for (int i = 0; i < methodNames.length; i++) {

			// register a new method
			ProvidedMethod pm = methodsProvider
					.addProvidedMethods(methodNames[i]);

			if (providedMethods != null) {
				// search the new method inside the complete list
				final String key = pm.getGlobalID();
				ProvidedMethod o = (ProvidedMethod) providedMethods.get(key);
				if (o != null) {
					// check if it's all ok
					if (o.getProvider() != methodsProvider) {
						throw new RuntimeException(METHOD_PROVIDED_EXCEPTION);
					}
				} else {
					// add a new one
					providedMethods.put(key, pm);
				}
			}
		}
	}

	/**
	 * Searchs a trigger inside the list of System's children.
	 * 
	 * If the list is null, returns null.
	 * 
	 * @param children all avaliable children
	 * @param name the name of  required trigger.
	 * 
	 * @return a trigger with specified name or null if no one is found.
	 */
	protected GTrigger getTrigger(Collection children, String name) {
		
		// nothing to do
		if (children == null) {
			return null;
		}
		
		// check all children
		for (Iterator iter = children.iterator(); iter.hasNext(); ) {
			
			Object o = iter.next();
			if (o instanceof GTrigger) {
				// check name
				if (checkStrings(name, ((GTrigger) o).getName())) {
					return (GTrigger) o;
				}
			}
		}
		
		// not found
		return null;
	}
	
	/**
	 * Extracts the EMF Object pointed by specified IVarTreePointer.
	 * 
	 * If the pointer is null or it isn't an instance of VarTreePointerEMF,
	 * return null.
	 * 
	 * @param vtp
	 *            identifies a node inside the VarTree
	 * 
	 * @return the EMF Object identified by vtp. Return null if vtp is null or
	 *         it isn't an instance of VarTreePointerEMF.
	 */
	protected EObject getEObject(IVarTreePointer vtp) {
		if (vtp != null && vtp instanceof VarTreePointerEMF) {
			return ((VarTreePointerEMF) vtp).getEPoint().getEObject();
		}

		return null;
	}

}