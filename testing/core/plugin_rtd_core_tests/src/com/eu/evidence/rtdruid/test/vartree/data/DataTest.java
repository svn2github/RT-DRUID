/*
 * Created on May 6, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.eu.evidence.rtdruid.test.vartree.data;



import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.junit.Before;
import org.junit.Test;

import com.eu.evidence.rtdruid.internal.vartree.data.provider.DataItemProviderAdapterFactory;
import com.eu.evidence.rtdruid.vartree.VarTreeUtil;


/**
 * @author durin
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class DataTest {
	
	private AdapterFactoryEditingDomain editingDomain;

	private ComposedAdapterFactory adapterFactory;

	@Before
	public void setup() {

		// Create an adapter factory that yields item providers.
		//
		List<AdapterFactory> factories = new ArrayList<AdapterFactory>();
		factories.add(new ResourceItemProviderAdapterFactory());
		factories.add(new DataItemProviderAdapterFactory());
		factories.add(new ReflectiveItemProviderAdapterFactory());

		adapterFactory = new ComposedAdapterFactory(factories);

		// Create the command stack that will notify this editor as commands are
		// executed.
		//
		BasicCommandStack commandStack = new BasicCommandStack();

		// Create the editing domain with a special command stack.
		//
		editingDomain = new AdapterFactoryEditingDomain(adapterFactory,
				commandStack);

	}
	
	/**
	 * Check that all classes extends ObjectWithID
	 */ 
	@Test
	public void testObjectWithID() {
		EObject root = VarTreeUtil.newVarTreeRoot(VarTreeUtil.newVarTree());
		
		checkObjectWithID(root, new ArrayList<Class<?>>());
	}
	
	private void checkObjectWithID(EObject current, ArrayList<Class<?>> path) {
		if (path.contains(current.getClass())) return;
		path.add(current.getClass());
		
		
		Collection<?> children = editingDomain.getNewChildDescriptors(current,
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
					checkObjectWithID(newValue, path);
				} else {
					@SuppressWarnings("unchecked")
					EList<EObject> newChildren = (EList<EObject>) current.eGet(cp
							.getEStructuralFeature());

					// add new node
					EObject newValue = EcoreUtil.create(cp.getEValue().eClass());

					newChildren.add(newValue);
					checkObjectWithID(newValue, path);

				}
			} else {
				assertTrue(false);
			}
		}

		
		/*
		EList childs = current.eClass().getEAllStructuralFeatures();
		
		if (childs == null) return;
		
		for (int i=0; i<childs.size(); i++) {
			if ( !(((EStructuralFeature) childs.get(i)).getEType() instanceof EClass)) continue;
			
			EClass cl = (EClass) ((EStructuralFeature) childs.get(i)).getEType();
			if (cl.isAbstract() || cl.isInterface()) {
				continue;
			}
			Object next = df.create( cl );
			if (next instanceof EObject) {
				if (!(next instanceof ObjectWithID)) {
					java.lang.System.err.println("" + next);
					assertTrue(false);
				}
				
				checkObjectWithID((EObject) next, path);
			}
		}
		*/
	}

	/**
	 * @param b
	 */
	private void assertTrue(boolean b) {
		// TODO Auto-generated method stub
		
	}
	
	//	TODO: controllare che tutte le "structuralFeatures" siano ordinate in modo alfabetico (anche se questo non viene garantito) 
	
	//	TODO: controllare che venga rispettata l'unicita' dei nomi all'interno di una lista 
}
