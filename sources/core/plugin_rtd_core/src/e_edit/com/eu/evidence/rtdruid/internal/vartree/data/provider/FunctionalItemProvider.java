/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.internal.vartree.data.provider;


import com.eu.evidence.rtdruid.vartree.data.DataFactory;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.data.Functional;

import com.eu.evidence.rtdruid.vartree.variables.PropertyVar;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link com.eu.evidence.rtdruid.vartree.data.Functional} object.
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
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
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
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(DataPackage.Literals.FUNCTIONAL__EVENT_LIST);
			childrenFeatures.add(DataPackage.Literals.FUNCTIONAL__PARTIAL_ORDER_LIST);
			childrenFeatures.add(DataPackage.Literals.FUNCTIONAL__IMPLEMENTATION);
			childrenFeatures.add(DataPackage.Literals.FUNCTIONAL__TIME_CONST_LIST);
			childrenFeatures.add(DataPackage.Literals.FUNCTIONAL__TYPE_LIST);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Functional"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		PropertyVar labelValue = ((Functional)object).getProperties();
		String label = labelValue == null ? null : labelValue.toString();
		return label == null || label.length() == 0 ?
			getString("_UI_Functional_type") :
			getString("_UI_Functional_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(DataPackage.Literals.FUNCTIONAL__EVENT_LIST,
				 DataFactory.eINSTANCE.createEvent()));

		newChildDescriptors.add
			(createChildParameter
				(DataPackage.Literals.FUNCTIONAL__PARTIAL_ORDER_LIST,
				 DataFactory.eINSTANCE.createPartialOrder()));

		newChildDescriptors.add
			(createChildParameter
				(DataPackage.Literals.FUNCTIONAL__IMPLEMENTATION,
				 DataFactory.eINSTANCE.createProc()));

		newChildDescriptors.add
			(createChildParameter
				(DataPackage.Literals.FUNCTIONAL__IMPLEMENTATION,
				 DataFactory.eINSTANCE.createVar()));

		newChildDescriptors.add
			(createChildParameter
				(DataPackage.Literals.FUNCTIONAL__IMPLEMENTATION,
				 DataFactory.eINSTANCE.createTrigger()));

		newChildDescriptors.add
			(createChildParameter
				(DataPackage.Literals.FUNCTIONAL__IMPLEMENTATION,
				 DataFactory.eINSTANCE.createSubSystem()));

		newChildDescriptors.add
			(createChildParameter
				(DataPackage.Literals.FUNCTIONAL__TIME_CONST_LIST,
				 DataFactory.eINSTANCE.createTimeConst()));

		newChildDescriptors.add
			(createChildParameter
				(DataPackage.Literals.FUNCTIONAL__TYPE_LIST,
				 DataFactory.eINSTANCE.createType()));
	}

}
