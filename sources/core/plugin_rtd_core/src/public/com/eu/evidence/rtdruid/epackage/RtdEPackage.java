package com.eu.evidence.rtdruid.epackage;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;

import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;

/**
 * The main (dynamic) EPackage for RT-Druid.
 * This EPackage is a proxy to the EPackage provided by {@link EPackageFactory}
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public final class RtdEPackage implements EPackage {
	
	private static final boolean USE_DYNAMIC_PACKAGES = true;

	/**
	 * Default (and unique) instance
	 */
	public final static RtdEPackage eINSTANCE = new RtdEPackage();
	
	/**
	 * 
	 */
	private final EPackage epkg;
	
	/**
	 * Init this proxy
	 */
	private RtdEPackage() {
		EPackage tmp = null;
		
		if (USE_DYNAMIC_PACKAGES) {
			try {
				tmp = EPackageFactory.instance.getEPackage();
			} catch (RTDEPackageBuildException e) {
				RtdruidLog.log(e);
			}
		} else {
			tmp = DataPackage.eINSTANCE;
		}
		if (tmp == null) {
			tmp = EcoreFactory.eINSTANCE.createEPackage();

			tmp.setName("rtdruid");
			tmp.setNsURI("http://www.evidence.eu.com/rtdruid/data");
			tmp.setNsPrefix("com.eu.evidence.rtdruid.data");
		}
		
		epkg = tmp;
	}
	

	@Override
	public String getName() {
		return epkg.getName();
	}

	@Override
	public void setName(String value) {
		epkg.setName(value);
	}

	@Override
	public EList<EAnnotation> getEAnnotations() {
		return epkg.getEAnnotations();
	}

	@Override
	public EAnnotation getEAnnotation(String source) {
		return epkg.getEAnnotation(source);
	}

	@Override
	public EClass eClass() {
		return epkg.eClass();
	}

	@Override
	public Resource eResource() {
		return epkg.eResource();
	}

	@Override
	public EObject eContainer() {
		return epkg.eContainer();
	}

	@Override
	public EStructuralFeature eContainingFeature() {
		return epkg.eContainingFeature();
	}

	@Override
	public EReference eContainmentFeature() {
		return epkg.eContainmentFeature();
	}

	@Override
	public EList<EObject> eContents() {
		return epkg.eContents();
	}

	@Override
	public TreeIterator<EObject> eAllContents() {
		return epkg.eAllContents();
	}

	@Override
	public boolean eIsProxy() {
		return epkg.eIsProxy();
	}

	@Override
	public EList<EObject> eCrossReferences() {
		return epkg.eCrossReferences();
	}

	@Override
	public Object eGet(EStructuralFeature feature) {
		return epkg.eGet(feature);
	}

	@Override
	public Object eGet(EStructuralFeature feature, boolean resolve) {
		return epkg.eGet(feature, resolve);
	}

	@Override
	public void eSet(EStructuralFeature feature, Object newValue) {
		epkg.eSet(feature, newValue);
	}

	@Override
	public boolean eIsSet(EStructuralFeature feature) {
		return epkg.eIsSet(feature);
	}

	@Override
	public void eUnset(EStructuralFeature feature) {
		epkg.eUnset(feature);
	}

	@Override
	public Object eInvoke(EOperation operation, EList<?> arguments) throws InvocationTargetException {
		return epkg.eInvoke(operation, arguments);
	}

	@Override
	public EList<Adapter> eAdapters() {
		return epkg.eAdapters();
	}

	@Override
	public boolean eDeliver() {
		return epkg.eDeliver();
	}

	@Override
	public void eSetDeliver(boolean deliver) {
		epkg.eSetDeliver(deliver);
	}

	@Override
	public void eNotify(Notification notification) {
		epkg.eNotify(notification);
	}

	@Override
	public String getNsURI() {
		return epkg.getNsURI();
	}

	@Override
	public void setNsURI(String value) {
		epkg.setNsURI(value);
	}

	@Override
	public String getNsPrefix() {
		return epkg.getNsPrefix();
	}

	@Override
	public void setNsPrefix(String value) {
		epkg.setNsPrefix(value);
	}

	@Override
	public EFactory getEFactoryInstance() {
		return epkg.getEFactoryInstance();
	}

	@Override
	public void setEFactoryInstance(EFactory value) {
		epkg.setEFactoryInstance(value);
	}

	@Override
	public EList<EClassifier> getEClassifiers() {
		return epkg.getEClassifiers();
	}

	@Override
	public EList<EPackage> getESubpackages() {
		return epkg.getESubpackages();
	}

	@Override
	public EPackage getESuperPackage() {
		return epkg.getESuperPackage();
	}

	@Override
	public EClassifier getEClassifier(String name) {
		return epkg.getEClassifier(name);
	}

}
