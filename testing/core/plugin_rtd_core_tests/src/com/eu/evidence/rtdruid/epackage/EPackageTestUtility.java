/**
 * 16/dic/2011
 */
package com.eu.evidence.rtdruid.epackage;

import java.io.IOException;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.eu.evidence.rtdruid.vartree.VarTreeUtil;

/**
 * this class helps during the build of an EPackage
 * 
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class EPackageTestUtility {
	
	protected static final EPackageUtility pkgUtil = new EPackageUtility(); 
	
	public static final EcoreFactory eCoreFactory = EcoreFactory.eINSTANCE;

	public EClass createClass(EPackage dest, String className) {
		EClass current_eclass = eCoreFactory.createEClass();
		current_eclass.setName(className);
		addAttribute(current_eclass, "name");
		dest.getEClassifiers().add(current_eclass);
		return current_eclass;
	}
	
	public EClass createEmptyClass(EPackage dest, String className) {
		EClass current_eclass = eCoreFactory.createEClass();
		current_eclass.setName(className);
		dest.getEClassifiers().add(current_eclass);
		return current_eclass;
	}


	public EAttribute addAttribute(EClass current_eclass, String attrName) {
		EAttribute eattr_type = eCoreFactory.createEAttribute();
		eattr_type.setName(attrName);
		eattr_type.setEType(EcorePackage.Literals.ESTRING);
		eattr_type.setChangeable(true);
		eattr_type.setLowerBound(1);
		eattr_type.setUpperBound(1);
		current_eclass.getEStructuralFeatures().add(eattr_type);
		return eattr_type;
	}
	
	public EReference addReference(EClass current_eclass, String attrName, EClass refType) {
		EReference eattr_type = eCoreFactory.createEReference();
		eattr_type.setName(attrName);
		eattr_type.setEType(refType);
		eattr_type.setChangeable(true);
		current_eclass.getEStructuralFeatures().add(eattr_type);
		return eattr_type;
	}
	
	public EDataType addType(EPackage dest, String typeName, String instanceClassName) {
		EDataType e_type = eCoreFactory.createEDataType();
		e_type.setName(typeName);
		e_type.setInstanceClassName(instanceClassName);
		dest.getEClassifiers().add(e_type);
		return e_type;
	}	

	public String modelToString(EditingDomain ed) throws IOException {
		return pkgUtil.modelToString(VarTreeUtil.getRtDruidEPackage(ed));
	}
	
	public String modelToString(EPackage ePackage) throws IOException {
		return pkgUtil.modelToString(ePackage);
	}

//	
//	public String modelDiff(EObject model1, EObject model2) throws IOException, InterruptedException {
//		model1 = EcoreUtil.copy(model1);
//		model2 = EcoreUtil.copy(model2);
//		
//		Resource res1 = (new ResourceSetImpl()).createResource(URI.createFileURI("res1.ecore"));
//		res1.getContents().add(model1);
//		Resource res2 = (new ResourceSetImpl()).createResource(URI.createFileURI("res2.ecore"));
//		res2.getContents().add(model2);
//		
//		String answer = null;
//		// Creates the match then the diff model for those two models
//		final MatchModel match = MatchService.doMatch(model1, model2,
//				Collections.<String, Object> emptyMap());
//		final DiffModel diff = DiffService.doDiff(match, false);
//		final List<DiffElement> differences = new ArrayList<DiffElement>(
//				diff.getOwnedElements());
//		// This will merge all references to the right model (second
//		// argument).
//		MergeService.merge(differences, true);
//
//		// Prints the results
//		System.out.println("MatchModel :\n"); //$NON-NLS-1$
//		System.out.println(ModelUtils.serialize(match));
//		System.out.println("DiffModel :\n"); //$NON-NLS-1$
//		System.out.println(answer = ModelUtils.serialize(diff));
//
//		// Serializes the result as "result.emfdiff" in the directory this
//		// class has been called from.
//		//				System.out.println("saving emfdiff as \"result.emfdiff\""); //$NON-NLS-1$
//		// final ModelInputSnapshot snapshot =
//		// DiffFactory.eINSTANCE.createModelInputSnapshot();
//		// snapshot.setDate(Calendar.getInstance().getTime());
//		// snapshot.setMatch(match);
//		// snapshot.setDiff(diff);
//		//				ModelUtils.serialize(snapshot); //$NON-NLS-1$
//		// } catch (IOException e) {
//		// // shouldn't be thrown
//		// e.printStackTrace();
//
//		return answer;
//	}
}
