/*
 * Created on 8-nov-2004
 *
 * $Id: AdapterFactoryLoaderImpl.java,v 1.5 2008/05/14 17:11:10 durin Exp $
 */
package com.eu.evidence.rtdruid.vartree.data.init;


import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;

import com.eu.evidence.rtdruid.internal.vartree.data.provider.DataItemProviderAdapterFactory;
import com.eu.evidence.rtdruid.vartree.AdapterFactoryLoader;


/**
 * @author Nicola Serreli
 */
public class AdapterFactoryLoaderImpl extends AdapterFactoryLoader {

    /** Returns factories required by rtdruid.vartree.data */
    @SuppressWarnings("unchecked")
	public Class<AdapterFactory>[] getFactoryies() {
        return (Class<AdapterFactory>[]) new Class[]
        {
        	DataItemProviderAdapterFactory.class,
        	ResourceItemProviderAdapterFactory.class,
        	ReflectiveItemProviderAdapterFactory.class
        	
        };
    }
    
    public AdapterFactoryLoaderImpl() {
		// nothing
	}
}
