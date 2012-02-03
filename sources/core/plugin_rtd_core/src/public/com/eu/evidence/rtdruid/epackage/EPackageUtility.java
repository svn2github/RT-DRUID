/**
 * 21/dic/2011
 */
package com.eu.evidence.rtdruid.epackage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;

import com.eu.evidence.rtdruid.internal.epackage.EPackageXmlMerge;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class EPackageUtility {
	
	public final static EPackageUtility instance = new EPackageUtility();
	
	
	public IEPackageMerge getPackageMerge() {
		return new EPackageXmlMerge();
	}

	public void modelToStream(EPackage ePackage, OutputStream stream, String filename) throws IOException {
		if (filename == null) {
			filename = "output.ecore";
		}
		ResourceSet metaResourceSet = new ResourceSetImpl();
		
		/*
		 * Register XML Factory implementation to handle .ecore files
		 * and create an empty resource
		 */
		metaResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("ecore", new XMLResourceFactoryImpl());
		Resource metaResource = metaResourceSet.createResource(URI
				.createURI(filename));
	
		metaResource.getContents().add(EcoreUtil.copy(ePackage));
	
		/* Save the resource */
		metaResource.save(stream, null);
	}

	public String modelToString(EPackage ePackage) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		modelToStream(ePackage, out, null);
		return out.toString();
	}
	
	public EPackage stringToModel(String txt) throws IOException {
		
		ResourceSet metaResourceSet = new ResourceSetImpl();
		
		/*
		 * Register XML Factory implementation to handle .ecore files
		 * and create an empty resource
		 */
		metaResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("ecore", new XMLResourceFactoryImpl());
		Resource metaResource = metaResourceSet.createResource(URI
				.createURI("output.ecore"));
	
		/*
		 * Save the resource
		 */
		metaResource.load(new ByteArrayInputStream( txt.getBytes() ), null);
		EList<EObject> cont = metaResource.getContents();
		
		EPackage answer = null;
		if (cont.size() > 0 ) {
			EObject first = cont.get(0);
			if (first instanceof EPackage) {
				answer = (EPackage) first;
			}
		}
		
		return answer;
	}
	
	public boolean modelValidate(EPackage ppkg, BasicDiagnostic diag, StringBuffer buff) {
		Diagnostician diagnostician = new Diagnostician();
		if (diag == null) {
			diag = new BasicDiagnostic();
		}
		boolean answer = diagnostician.validate(ppkg, diag, diagnostician.createDefaultContext());
		if (buff != null) {
			for (Diagnostic d : diag.getChildren()) {
				buff.append(d.getMessage());
				buff.append("\n");
			}
		}
		return answer;
	}
}
