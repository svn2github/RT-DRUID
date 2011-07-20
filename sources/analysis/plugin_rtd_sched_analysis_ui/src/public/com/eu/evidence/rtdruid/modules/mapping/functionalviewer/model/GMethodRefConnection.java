/*
 * Created on 2-mar-2005
 *
 * $Id: GMethodRefConnection.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.mapping.functionalviewer.model;

import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.PropertyDescriptor;

/**
 * 
 * This class is specialized to rappresent connection between modules using a
 * Method Ref
 * 
 * @author Nicola Serreli
 */
public class GMethodRefConnection extends GConnection {

	protected static IPropertyDescriptor[] descriptors;


	final public ProvidedMethod methodRef;

	public GMethodRefConnection(GGate sourceGate, GGate targetGate, ProvidedMethod methodId) {
		super(sourceGate, targetGate, computeConnectionType(sourceGate, targetGate, methodId));
		
		this.methodRef = methodId;
	}
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.modules.mapping.functionalviewer.model.GConnection#getPropertyDescriptors()
	 */
	public IPropertyDescriptor[] getPropertyDescriptors() {
		return descriptors;
	}
	
	// ---------------------------------------
	
	static {
		descriptors = new IPropertyDescriptor[] {
				new PropertyDescriptor(SOURCE, "Source"),
				new PropertyDescriptor(TARGET, "Target") };
	}
	
	private static int computeConnectionType(GGate source, GGate target, ProvidedMethod method) {

		int answer = DIRECT_CONN;
		
		if (method != null && method.gate != null) {
			if (method.gate == source) {
				answer = REVERSE_CONN;
			} else if (method.gate != target) {
				throw new RuntimeException(
						"Specified provided method doesn't contains neither the source gate and the target gate.");
			}
		}
		
		return answer;
	}
}