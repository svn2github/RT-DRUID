/*
 * Created on 2-mar-2005
 *
 * $Id: GPartialOrderConnection.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.mapping.functionalviewer.model;

import org.eclipse.ui.views.properties.IPropertyDescriptor;

/**
 * 
 * This class is specialized to rappresent a single partial order between two modules
 * 
 * @author Nicola Serreli
 */
public class GPartialOrderConnection extends GConnection {

	public GPartialOrderConnection(GGate sourceGate, GGate targetGate) {

		super(sourceGate, targetGate);

	}
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.modules.mapping.functionalviewer.model.GConnection#getPropertyDescriptors()
	 */
	public IPropertyDescriptor[] getPropertyDescriptors() {
		// TODO Auto-generated method stub
		return null;
	}
}