/**
 * 12/dic/2011
 */
package com.eu.evidence.rtdruid.internal.epackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.FactoryException;
import org.eclipse.emf.compare.diff.merge.service.MergeService;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.service.DiffService;
import org.eclipse.emf.compare.match.engine.AbstractSimilarityChecker;
import org.eclipse.emf.compare.match.engine.GenericMatchEngine;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.match.service.MatchService;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.eu.evidence.rtdruid.epackage.IEPackageMerge;
import com.eu.evidence.rtdruid.epackage.RTDEPackageBuildException;

/**
 * This class merges EPackages
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 * @deprecated not completed
 */
public class EPackageDiffMerge implements IEPackageMerge {
	
	protected EpkgMerger merger;
	
	protected enum State {
		empty, merging, closed;
	}
	
	protected State currentState;
	
	public EPackageDiffMerge() {
		currentState = State.empty;
	}
	
	/**
	 * 
	 * @param pkg
	 * 
	 * @throws IllegalStateException if addPackage is called after call get result
	 */
	public void addEPackage(EPackage pkg) throws RTDEPackageBuildException {
		if (pkg == null) {
			throw new NullPointerException();
		}
		
		switch (currentState) {
			case closed : 
				throw new IllegalStateException("Cannot add a new EPackage after get the result");
			case empty : {
				merger = new EpkgMerger(pkg);
				currentState = State.merging;
				break;
			} 
			case merging : {
				merger.merge(pkg);
				break;
			}
		} 
	}
	
	
	/**
	 * This function returns the result of the merge. After this call it is not possible to add more packages.
	 * The result can be null, if addEPackages was never called;
	 * 
	 * 
	 * @return the result of the merge operation
	 */
	public EPackage getResult() {
		currentState = State.closed;
		return merger == null ? null : merger.getResult();
	}
	
		
	// ------------------------------------------------------
	//    Emf Package Merger
	// ------------------------------------------------------
	/**
	 * This class merges one or more packages 
	 *
	 * @author Nicola Serreli
	 * @since 2.0
	 *
	 */
	protected static class EpkgMerger {
		protected final EPackage result;
		protected final ResourceSet resourceSet;
		
		/**
		 * 
		 */
		public EpkgMerger(EPackage dest) {
			result = EcoreUtil.copy(dest);
			resourceSet = new ResourceSetImpl();
			Resource res = resourceSet.createResource(URI.createFileURI("result.ecore"));
			res.getContents().add(dest);
			
		}
		
		public void merge(EPackage addition) throws RTDEPackageBuildException {
		
			addition = EcoreUtil.copy(addition);

			try {
				Resource res = resourceSet.createResource(URI.createFileURI("result.ecore"));
				res.getContents().add(addition);

				final MatchModel match = MatchService.doMatch(result, addition, Collections
						.<String, Object> emptyMap());
				final DiffModel diff = DiffService.doDiff(match, false);
				
				final List<DiffElement> differences = new ArrayList<DiffElement>(diff.getOwnedElements());
				MergeService.merge(differences, false);

//				// Prints the results
//				try {
//					System.out.println("MatchModel :\n"); //$NON-NLS-1$
//					System.out.println(ModelUtils.serialize(match));
//					System.out.println("DiffModel :\n"); //$NON-NLS-1$
//					System.out.println(ModelUtils.serialize(diff));
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}

		
		/**
		 * @return the result
		 */
		public EPackage getResult() {
			return result;
		}
	}
	
	
	public class LibraryMatchEngine extends GenericMatchEngine {

		@Override
		protected AbstractSimilarityChecker prepareChecker() {
			return new AbstractSimilarityChecker(filter) {

				/**
				 * Should determine whether an element is similar to the other one or not.
				 * 
				 * @param obj1
				 *            an element.
				 * @param obj2
				 *            another element.
				 * @return true if those elements have the same identity.
				 */
				@Override
				public boolean isSimilar(EObject obj1, EObject obj2) throws FactoryException {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public double absoluteMetric(EObject obj1, EObject obj2) throws FactoryException {
					// TODO Auto-generated method stub
					return 0;
				}
						
				@Override
				public void init(Resource leftResource, Resource rightResource) throws FactoryException {
					// TODO Auto-generated method stub
			
				}
			
				@Override
				public void init(EObject leftObject, EObject rightObject) throws FactoryException {
					// TODO Auto-generated method stub
			
				}
			
			};
		}
	}


}
