/**
 * <copyright>
 * </copyright>
 *
 * $Id: FunctionalItemProvider.java,v 1.1 2005/09/28 15:22:29 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.vartree.data.provider;




import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;

import com.eu.evidence.rtdruid.DataEditPlugin;
import com.eu.evidence.rtdruid.vartree.data.DataFactory;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.data.Functional;
import com.eu.evidence.rtdruid.vartree.data.init.ObjectWithIDItemProvider;

/**
 * This is the item provider adpater for a {@link rtdruid.vartree.data.Functional} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class FunctionalItemProvider
	extends ObjectWithIDItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionalItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Collection getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(DataPackage.eINSTANCE.getFunctional_EventList());
			childrenFeatures.add(DataPackage.eINSTANCE.getFunctional_PartialOrderList());
			childrenFeatures.add(DataPackage.eINSTANCE.getFunctional_Implementation());
			childrenFeatures.add(DataPackage.eINSTANCE.getFunctional_TimeConstList());
			childrenFeatures.add(DataPackage.eINSTANCE.getFunctional_TypeList());
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}


	/**
	 * This returns Functional.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return getResourceLocator().getImage("full/obj16/Functional");
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		return getString("_UI_Functional_type");
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Functional.class)) {
			case DataPackage.FUNCTIONAL__EVENT_LIST:
			case DataPackage.FUNCTIONAL__PARTIAL_ORDER_LIST:
			case DataPackage.FUNCTIONAL__IMPLEMENTATION:
			case DataPackage.FUNCTIONAL__TIME_CONST_LIST:
			case DataPackage.FUNCTIONAL__TYPE_LIST:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds to the collection of {@link org.eclipse.emf.edit.command.CommandParameter}s
	 * describing all of the children that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void collectNewChildDescriptors(Collection newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(DataPackage.eINSTANCE.getFunctional_EventList(),
				 DataFactory.eINSTANCE.createEvent()));

		newChildDescriptors.add
			(createChildParameter
				(DataPackage.eINSTANCE.getFunctional_PartialOrderList(),
				 DataFactory.eINSTANCE.createPartialOrder()));

		newChildDescriptors.add
			(createChildParameter
				(DataPackage.eINSTANCE.getFunctional_Implementation(),
				 DataFactory.eINSTANCE.createProc()));

		newChildDescriptors.add
			(createChildParameter
				(DataPackage.eINSTANCE.getFunctional_Implementation(),
				 DataFactory.eINSTANCE.createVar()));

		newChildDescriptors.add
			(createChildParameter
				(DataPackage.eINSTANCE.getFunctional_Implementation(),
				 DataFactory.eINSTANCE.createTrigger()));

		newChildDescriptors.add
			(createChildParameter
				(DataPackage.eINSTANCE.getFunctional_Implementation(),
				 DataFactory.eINSTANCE.createSubSystem()));

		newChildDescriptors.add
			(createChildParameter
				(DataPackage.eINSTANCE.getFunctional_TimeConstList(),
				 DataFactory.eINSTANCE.createTimeConst()));
		newChildDescriptors.add
			(createChildParameter
				(DataPackage.eINSTANCE.getFunctional_TypeList(),
				 DataFactory.eINSTANCE.createType()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceLocator getResourceLocator() {
		return DataEditPlugin.INSTANCE;
	}
}
