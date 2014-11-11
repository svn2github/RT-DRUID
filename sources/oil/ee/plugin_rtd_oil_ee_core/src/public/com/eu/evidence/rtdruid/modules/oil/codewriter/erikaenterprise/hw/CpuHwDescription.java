package com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.ErikaEnterpriseWriter;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.CommentsManager;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IMacrosForSharedData;
import com.eu.evidence.rtdruid.vartree.IVarTree;

/**
 * This class is used to store some attributes required by a lot of common
 * functions, like find stacks and compute maximum priority value.
 * 
 * @author Nicola Serreli
 */
public class CpuHwDescription {
	
	public static class McuCounterDevice {
		protected final String id;
		protected final String mcu_id;
		protected final int prio;
		protected final String entry;
		protected final String handler;
		
		
		public McuCounterDevice(final String id, final String mcu_id, final int prio, final String entry, final String handler) {
			this.id = id;
			this.mcu_id = mcu_id;
			this.prio = prio;
			this.entry = entry;
			this.handler = handler;
		}
		/**
		 * @return the id
		 */
		public String getDeviveId() {
			return id;
		}
		/**
		 * @return the entry
		 */
		public String getEntry() {
			return entry;
		}
		/**
		 * @return the mcu_id
		 */
		public String getMcu_id() {
			return mcu_id;
		}
		/**
		 * @return the prio
		 */
		public int getPrio() {
			return prio;
		}
		/**
		 * @return the handler
		 */
		public String getHandler() {
			return handler;
		}
	}

	public static class OsApplicationAreas {
		protected List<String> constAreas;
		protected List<String> areas;
		
		protected List<String> constKAreas;
		protected List<String> kareas;

		/**
		 * 
		 */
		public OsApplicationAreas(String[] cAreas, String[] areas, String[] cKAreas, String[] kareas) {
			this.constAreas = Collections.unmodifiableList(Arrays.asList(cAreas));
			this.areas = Collections.unmodifiableList(Arrays.asList(areas));
			this.constKAreas = Collections.unmodifiableList(Arrays.asList(cKAreas));
			this.kareas = Collections.unmodifiableList(Arrays.asList(kareas));
		}
		
		/**
		 * @return the areas
		 */
		public List<String> getAreas() {
			return areas;
		}
		/**
		 * @return the constAreas
		 */
		public List<String> getConstAreas() {
			return constAreas;
		}
		
		/**
		 * @return the areas
		 */
		public List<String> getKAreas() {
			return kareas;
		}
		/**
		 * @return the constAreas
		 */
		public List<String> getConstKAreas() {
			return constKAreas;
		}
	}
	
	public interface IRequiresUpdates {
		public void update(ErikaEnterpriseWriter parent, IVarTree vt, IOilObjectList[] objects, int currentCpuId);
	}
	
	
	/**
	 * Number of bytes used to store the stack address.
	 */
	public final static boolean DEFAULT_supportForNestedIRQ = true;



	public static final int DEFAULT_MAX_NESTING_LEVEL = 16;
	
	

	/** A identifier for this cpu */
	public final String cpuType;
	/**
	 * Oil ID that identifies if is required a PRIVATE stack (opposite of
	 * "share" stack)
	 */
	public final String privateId;
	/** Oil identifiers for all stacks that are present in a "PRIVATE stack" */
	public final List<String> stackNames;
	/** Oil identifiers for all stacks that are present in a "SHARED stack" */
	public final List<String> sharedStackNames;
	/** OsApplication sections */
	protected OsApplicationAreas osApplicationNames = new OsApplicationAreas(
			new String[] { "ee_load_data" },
			new String[] { "ee_sstack", "ee_sdata", "ee_sbss", "ee_ebss"},
			new String[] { },
			new String[] { }
	);
	/** Number of bits used to represent a priority */
	public final int prioSize;
	/**
	 * Number of bytes of each minimum stack unit. It means that the stack must
	 * be a multiple of this value.
	 */
	public final int stackSize;
	/**
	 * Number of bits used by the cpu timer.
	 */
	public final int timerSize;

	/**
	 * Number of bytes used to store the stack address.
	 */
	public final int stackAddress;

	/**
	 * Number of bytes used to store the stack address.
	 */
	public final boolean supportForNestedIRQ;

	/**
	 * The comment manager for this architecture.
	 */
	public final CommentsManager commentManager;

	/**
	 * Suports Orti ISR2 section
	 */
	protected boolean supportOrtiISR2 = false;
	
	
	/**
	 * Able to handle empty vectors
	 */
	protected boolean handlesEmpyVector = true;
	
	/**
	 * True if the current architecture has the mmu module
	 */
	protected boolean mmuAvailable = false;
	
	/**
	 * 
	 */
	protected IMacrosForSharedData macros = new EmptyMacrosForSharedData();
	
	/**
	 * The maximum number of nested interrupts 
	 */
	protected int maxNestedInts = DEFAULT_MAX_NESTING_LEVEL;

	protected int startingIsrPriority = 0;

	protected Map<String, McuCounterDevice> mcuCounterDevices = new HashMap<String, CpuHwDescription.McuCounterDevice>();

	/**
	 * Pack isr priorities
	 */
	protected boolean packIsrPriorities = true;

	/**
	 * Build a new Cpu HW Description
	 */
	public CpuHwDescription(String ct, String pi, String[] stkNames,
			String[] sharedStkNames, int prio, int stkSize, int stkAddr,
			int timer) {
		cpuType = ct;
		privateId = pi;
		stackNames = Collections.unmodifiableList(Arrays.asList(stkNames));
		sharedStackNames = Collections.unmodifiableList(Arrays
				.asList(sharedStkNames));
		prioSize = prio;
		stackSize = stkSize;
		stackAddress = stkAddr;
		timerSize = timer;
		supportForNestedIRQ = DEFAULT_supportForNestedIRQ;
		commentManager = CommentsManager.getDefaultsWriters();
	}

	/**
	 * Build a new Cpu HW Description
	 */
	public CpuHwDescription(String ct, String pi, String[] stkNames,
			String[] sharedStkNames, int prio, int stkSize, int stkAddr,
			int timer, boolean supportIRQ) {
		cpuType = ct;
		privateId = pi;
		stackNames = Collections.unmodifiableList(Arrays.asList(stkNames));
		sharedStackNames = Collections.unmodifiableList(Arrays
				.asList(sharedStkNames));
		prioSize = prio;
		stackSize = stkSize;
		stackAddress = stkAddr;
		timerSize = timer;
		supportForNestedIRQ = supportIRQ;
		commentManager = CommentsManager.getDefaultsWriters();
	}
	
	/**
	 * @return true if the default compiler for this processor is able to handle empty vectors 
	 */
	public boolean isAbleToHandleEmpyVector() {
		return handlesEmpyVector;
	}
	
	
	/**
	 * Returns the code used to init an empty vector, i.e. the code between '=' and ';'.
	 * Default value is '{}'.
	 * 
	 * @return the text used to init an empty vector, i.e. the code between '=' and ';' 
	 */
	public String initEmptyVector() {
		return  "{}";
	}
	
	/**
	 * 
	 */
	public IMacrosForSharedData getShareDataMacros() {
		return macros;
	}
	
	public int getMaxNestedInts() {
		return maxNestedInts;
	}
	
	public boolean isSupportOrtiISR2() {
		return supportOrtiISR2;
	}
	
	/**
	 * @return the packIsrPriorities
	 */
	public boolean isPackIsrPriorities() {
		return packIsrPriorities;
	}
	
	public McuCounterDevice getMcuDevice(String deviceId) {
		return mcuCounterDevices.get(deviceId);
	}
	
	protected void addMcuDevices(Collection<McuCounterDevice> devices) {
		for (McuCounterDevice device : devices) {
			mcuCounterDevices.put(device.getDeviveId(), device);
		}
	}
	
	/**
	 * @return the osApplicationNames
	 */
	public OsApplicationAreas getOsApplicationNames() {
		return osApplicationNames;
	}

	/**
	 * @return
	 */
	public boolean hasMMU() {
		return mmuAvailable;
	}

	/**
	 *
	 * @return the lowest available priority. The default is 0, when there is no low priority reserved
	 */
	public int getStartingIsrPriorities() {
		return startingIsrPriority;
	}
}