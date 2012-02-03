/*
 * Created on 8-nov-2004
 *
 * $Id: AdapterFactoryLoader.java,v 1.2 2008/03/26 18:23:51 durin Exp $
 */
package com.eu.evidence.rtdruid.vartree;

import org.eclipse.emf.common.notify.AdapterFactory;

/**
 * @author Nicola Serreli
 */
public abstract class AdapterFactoryLoader {

    /** Return classes of all required Adapter Factories */
    abstract public Class<AdapterFactory>[] getFactoryies();
}
