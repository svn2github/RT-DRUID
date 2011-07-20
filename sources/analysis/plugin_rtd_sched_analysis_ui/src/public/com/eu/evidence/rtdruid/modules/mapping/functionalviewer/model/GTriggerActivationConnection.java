/*
 * Created on 17-mar-2005
 *
 * $Id: GTriggerActivationConnection.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.mapping.functionalviewer.model;

import org.eclipse.ui.views.properties.IPropertyDescriptor;

/**
 * 
 * This class is specialized to rappresent a trigger's activation.
 * 
 * @author Nicola Serreli
 */
public class GTriggerActivationConnection extends GConnection {

	public GTriggerActivationConnection(GGate sourceGate, GGate targetGate) {

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