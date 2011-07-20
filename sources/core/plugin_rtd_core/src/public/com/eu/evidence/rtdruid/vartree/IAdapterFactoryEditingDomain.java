/*
 * Created on 2-set-2005
 *
 * $Id: IAdapterFactoryEditingDomain.java,v 1.2 2008/03/26 18:23:51 durin Exp $
 */
package com.eu.evidence.rtdruid.vartree;

import java.util.Map;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * 
 * TODO : Commentare && Tradurre
 * 
 * @author Nicola Serreli
 */
public interface IAdapterFactoryEditingDomain extends EditingDomain {
    /**
     * This returns the adapter factory used by this domain.
     */
    public abstract AdapterFactory getAdapterFactory();

    /**
     * This sets the adapter factory after the domain is already created.
     */
    public abstract void setAdapterFactory(AdapterFactory adapterFactory);


    public abstract Object getWrapper(Object object);

    /**
     * This sets whether or not copy command optimizations are safe in this domain.
     */
    public abstract void setOptimizeCopy(boolean optimizeCopy);

    /**
     * Returns the map of resource to a Boolean value indicating whether the resource is read only.
     */
    public abstract Map<Resource,Boolean> getResourceToReadOnlyMap();

    /**
     * Set the map of resource to a Boolean value indicating whether the resource is read only.
     */
    public abstract void setResourceToReadOnlyMap(Map<Resource,Boolean> resourceToReadOnlyMap);
}