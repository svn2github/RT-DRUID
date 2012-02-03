/*
 * Created on 2-set-2005
 *
 * $Id: IVTResource.java,v 1.1 2005/09/28 15:22:29 durin Exp $
 */
package com.eu.evidence.rtdruid.io;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.xml.sax.ErrorHandler;

/**
 * 
 * TODO : Commentare && Tradurre
 * 
 * @author Nicola Serreli
 */
public interface IVTResource extends Resource.Internal, XMIResource {
    void setLoadHandler(ErrorHandler newHandler);
}