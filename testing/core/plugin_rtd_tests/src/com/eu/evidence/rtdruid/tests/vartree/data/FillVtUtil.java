package com.eu.evidence.rtdruid.tests.vartree.data;
/*
 * Created on 14-giu-2004
 */


import static org.junit.Assert.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Properties;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;

/**
 * @author Nicola Serreli
 * 
 * This class is usefull to create a new filled tree
 */
public class FillVtUtil {
	private static final int MAX_LEVEL = 4;
	private static final int MAX_SIBLINGS = 3;
	
	private int nextID = 1;
	private int maxLevel = MAX_LEVEL;
	private int maxSiblings = MAX_SIBLINGS;
	private final EditingDomain ed;
//	private final EPackAGE EPKG;
//	PRIVATE FINAL EFACTory eFactory;
	private final Resource res;
	private EObject lastRoot = null;
	
	private boolean enableProperties = false;
	
	public FillVtUtil(EditingDomain editingDomain, Resource res) {
		this.ed = editingDomain;
		if (res == null) {
			if (ed.getResourceSet().getResources().size() >0) {
				res = ed.getResourceSet().getResources().get(0);
			}
		} else {
			ed.getResourceSet().getResources().add(res);
		}
		this.res = res;
	}
	
	public void setEnableProperties(boolean enableProperties) {
		this.enableProperties = enableProperties;
	}
	
	public FillVtUtil() {
		this(new AdapterFactoryEditingDomain(new ReflectiveItemProviderAdapterFactory(),  new BasicCommandStack()), new XMLResourceImpl());
	}

	/**
	 * @param maxLevel the maxLevel to set
	 */
	public void setMaxLevel(int maxLevel) {
		this.maxLevel = maxLevel;
	}
	
	/**
	 * @param nextID the nextID to set
	 */
	public void setNextID(int nextID) {
		this.nextID = nextID;
	}
	
	/**
	 * @return the ed
	 */
	public EditingDomain getEditingDomain() {
		return ed;
	}
	
	/**
	 * @return the resource
	 */
	public Resource getResource() {
		return res;
	}
	
	/**
	 * @return the nextID
	 */
	public int getNextID() {
		return nextID;
	}
	
	/**
	 * @return the lastRoot
	 */
	public EObject getLastRoot() {
		return lastRoot;
	}
	
	/**
	 * @param maxSiblings the maxSiblings to set
	 */
	public void setMaxSiblings(int maxSiblings) {
		this.maxSiblings = maxSiblings;
	}
	
	/**
	 * Creates a new tree filled with numbers (a serial id for each node and
	 * attribute)
	 */
	public void fill(EObject root) throws IOException {
		lastRoot = root;
		res.getContents().add(root);
		fill(root, 0);
	}

	/**
	 * Recursively adds all attribute and new children to current node. Stops
	 * (doesn't add new children) if level is bigger than MAX_LEVEL
	 */
	private void fill(EObject current, int level) throws IOException {
		//String spazi = (" ").substring(0, level+1);
		//System.out.println(spazi + "type = " + current.eClass().getName());
		

		EList<EAttribute> attrList = current.eClass().getEAllAttributes();
		for (int i = 0; i < attrList.size(); i++) {
			EAttribute at = (EAttribute) attrList.get(i);
			if (at.isChangeable()) {
				
				if (at.getName().equalsIgnoreCase("properties")) { // DataPackage.eINSTANCE.getObjectWithID_Properties().getName()
					if (enableProperties) {
						Properties p = new Properties();
						for (int c=0; c<maxSiblings; c++) {
							p.setProperty("" + ((char)('a'+c)), ""+nextID); nextID++;
						}
						
						ByteArrayOutputStream os = new ByteArrayOutputStream();
						// may throw IOException
						p.storeToXML(os, null);
						
						Object tmp = EcoreUtil.createFromString(at
								.getEAttributeType(), os.toString());
						current.eSet(at, tmp);
					}
					
					// do nothing
				} else if (at.isMany()) {
					ArrayList<Object> val = new ArrayList<Object>();
	
					for (int l = 0; l < maxSiblings; l++) {
						//	System.out.println(spazi + "attr = " + at.getName() + "
						// val = " + nextID);
						EDataType edt = at.getEAttributeType();
						if (edt.getName().toLowerCase().contains("boolean")) {
							val.add(EcoreUtil.createFromString(edt, "true"));
						} else {
							val.add(EcoreUtil.createFromString(edt, "" + nextID));
							nextID++;
						}
					}
					current.eSet(at, val);
	
				} else {
					//	System.out.println(spazi + "attr = " + at.getName() + " val =
					// " + nextID);
					Object tmp;
					EDataType edt = at.getEAttributeType();
					if (edt.getName().toLowerCase().contains("boolean")) {
						tmp = EcoreUtil.createFromString(edt, "true");
					} else {
						tmp =EcoreUtil.createFromString(edt, "" + nextID);
						nextID++;
					}
					current.eSet(at, tmp);
				}
			}
		}

		if (level > maxLevel)
			return;
		level++;

		Collection<?> children = ed.getNewChildDescriptors(current,
				null);

		Iterator<?> it = children.iterator();
		while (it.hasNext()) {
			Object o = it.next();

			// Expected a CommandParameter
			assertTrue(o instanceof CommandParameter);
			{
				CommandParameter cp = (CommandParameter) o;

				if (!cp.getEStructuralFeature().isMany()) {
					// add new node
					EObject newValue = cp.getEValue();

					current.eSet(cp.getEStructuralFeature(), newValue);
					fill(newValue, level);
				} else {
					@SuppressWarnings("unchecked")
					EList<EObject> newChildren = (EList<EObject>) current.eGet(cp
							.getEStructuralFeature());

					for (int i = 0; i < maxSiblings; i++) {
						// add new node
						EObject newValue = EcoreUtil.create(cp.getEValue().eClass());

						newChildren.add(newValue);
						fill(newValue, level);
					}

				}
//			} else {
//				throw new RuntimeException("Expected a commandParameter !!! why not found ?? "
//								+ o);
			}

		}

	}
}