/*
 * Created on 29/9/2008
 * 
 * $Id$
 */
package com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw;

import java.util.HashMap;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.CpuHwDescription.IRequiresUpdates;

/**
 * This class manages the list of available HW descriptions
 * 
 * @author Nicola Serreli
 * @see CpuHwDescription
 */
public final class EECpuDescriptionManager {

	/** The unique instance of this manager */
	protected static EECpuDescriptionManager instance = new EECpuDescriptionManager();
	
	/** Description of each supported CPU */
	protected HashMap<String, CpuHwDescription> availableHWs = new HashMap<String, CpuHwDescription>();	

	
	protected final String EXT_POINT_ID = "com.eu.evidence.rtdruid.oil.ee.core.eeCpuDescription";
	
	/**
	 * Build a new manager
	 */ 
	protected EECpuDescriptionManager() {
		// Read From Extention Point
		IExtensionRegistry registry= Platform.getExtensionRegistry();

		IConfigurationElement[] elements= registry.getConfigurationElementsFor(EXT_POINT_ID);
		for (IConfigurationElement element : elements) {
			String className = null;
			try {
				
			    final String S_ELEM = "CPU";
			    final String S_ELEM_CLASS = "class";
			    
		    	String chName = element.getName();
			    /*
			     * Parse a CPU element
			     */
			    if (S_ELEM.equalsIgnoreCase(chName)) {
			        className = element.getAttribute(S_ELEM_CLASS);
			        Object o = element.createExecutableExtension(S_ELEM_CLASS);
			        
			        // check if current tmpClass extend CpuHWDescription
			        if ( ! (o instanceof CpuHwDescription)) {
			        	RtdruidLog.log(new RuntimeException("The class " + className + " isn't an CpuHwDescription"));
			            continue; // next child
			        }
			        
			        CpuHwDescription cpu = (CpuHwDescription) o;
				        
			        availableHWs.put(cpu.cpuType, cpu);
			    }
			} catch (Exception e) {
	            RtdruidLog.log(new RuntimeException("Not found the CPU descriptor class " + className, e));
	            continue;
			}
		}

	}
	
	
	
	/**
	 * @param hw_id a string that identifies a specific HW.
	 * 
	 * @return the description for specified HW
	 */
	public static CpuHwDescription getHWDescription(String hw_id) {
		CpuHwDescription answer = instance.availableHWs.get(hw_id);
		if (answer instanceof IRequiresUpdates) {
			try {
				answer = answer.getClass().newInstance();
			} catch (InstantiationException e) {
				RtdruidLog.log(e);
			} catch (IllegalAccessException e) {
				RtdruidLog.log(e);
			}
		}

		return answer;
	}

	/**
	 * @param hw_id a string that identifies a specific HW.
	 * 
	 * @return true if there is a description for specified HW
	 */
	public static boolean containsHWDescription(String hw_id) {
		return instance.availableHWs.containsKey(hw_id);
	}

}
