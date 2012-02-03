package com.eu.evidence.rtdruid.modules.oil;
/*
 * Created on 14-giu-2004
 */



import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Properties;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.CommandParameter;

import com.eu.evidence.rtdruid.desk.Messages;
import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.data.DataFactory;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;

/**
 * @author ni
 * 
 * This class is usefull to create a new filled tree and to compare two distinct
 * trees
 */
public class FillVtTest {
	private int nextID = 1;

	private static final int MAX_LEVEL = 4;

	IVarTree vt;

	private FillVtTest(IVarTree vt) {
		this.vt = vt;
	}

	
	/**
	 * Creates a new tree filled with numbers (a serial id for each node and
	 * attribute)
	 */
	public static void fill(IVarTree vt) {
		FillVtTest filler = new FillVtTest(vt);
//		IVarTree tree = ((IVarTree) RTDFactory.get(IVarTree.class));
		
		EList<EObject> base = vt.getResourceSet().getResources().get(0).getContents();
		base.clear();
		base.add(filler.fill());
	}
	
	/**
	 * Creates a new tree filled with numbers (a serial id for each node and
	 * attribute)
	 */
	public EObject fill() {
		EObject root = DataFactory.eINSTANCE.createSystem();

		fill(root, 0);

		return root;
	}

	/**
	 * Recursively adds all attribute and new children to current node. Stops
	 * (doesn't add new children) if level is bigger than MAX_LEVEL
	 */
	private void fill(EObject current, int level) {
		//String spazi = (" ").substring(0, level+1);
		//System.out.println(spazi + "type = " + current.eClass().getName());

		EList<EAttribute> attrList = current.eClass().getEAllAttributes();
		for (int i = 0; i < attrList.size(); i++) {
			EAttribute at = (EAttribute) attrList.get(i);

			
			if (at.getName().equals(DataPackage.eINSTANCE.getObjectWithID_Properties().getName())) {
				
				Properties p = new Properties();
				p.setProperty("a", ""+nextID); nextID++;
				p.setProperty("b", ""+nextID); nextID++;
				p.setProperty("c", ""+nextID); nextID++;
				
				ByteArrayOutputStream os = new ByteArrayOutputStream();
				try {
					p.storeToXML(os, null);
				} catch (IOException e) {
					RtdruidLog.log(e);
					continue;
				}
				
				Object tmp = DataFactory.eINSTANCE.createFromString(at
						.getEAttributeType(), os.toString());
				current.eSet(at, tmp);
				
//			} else if (at.getName().equals(DataPackage.eINSTANCE.getMapping_InverseTaskToProc().getName())) {
				
				// do nothing
			} else if (at.isMany()) {
				ArrayList<Object> val = new ArrayList<Object>();

				for (int l = 0; l < 3; l++) {
					//	System.out.println(spazi + "attr = " + at.getName() + "
					// val = " + nextID);
					val.add(DataFactory.eINSTANCE.createFromString(at
							.getEAttributeType(), "" + nextID));
					nextID++;
				}
				current.eSet(at, val);

			} else {
				//	System.out.println(spazi + "attr = " + at.getName() + " val =
				// " + nextID);
				Object tmp = DataFactory.eINSTANCE.createFromString(at
						.getEAttributeType(), "" + nextID);
				nextID++;
				current.eSet(at, tmp);
			}
		}

		if (level > MAX_LEVEL)
			return;
		level++;

		Collection<?> children = vt.getNewChildDescriptors(current,
				null);

		Iterator<?> it = children.iterator();
		while (it.hasNext()) {
			Object o = it.next();

			if (o instanceof CommandParameter) {
				CommandParameter cp = (CommandParameter) o;

				if (!cp.getEStructuralFeature().isMany()) {
					// add new node
					EObject newValue = cp.getEValue();

					current.eSet(cp.getEStructuralFeature(), newValue);
					fill(newValue, level);
				} else {
					EList<EObject> newChildren = (EList<EObject>) current.eGet(cp
							.getEStructuralFeature());

					for (int i = 0; i < 3; i++) {
						// add new node
						EObject newValue = DataFactory.eINSTANCE.create(cp
								.getEValue().eClass());

						newChildren.add(newValue);
						fill(newValue, level);
					}

				}
			} else {
				Messages
						.sendDebugNl("Expected a commandParameter !!! why not found ?? "
								+ o);
			}

		}

	}
}