/**
 * 26/set/2012
 */
package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise;

import java.awt.image.Kernel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

import com.eu.evidence.modules.oil.tricore.constants.TricoreConstants;
import com.eu.evidence.rtdruid.desk.Messages;
import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.ISimpleGenResKeywords;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.abstractions.ISimpleGenRes;
import com.eu.evidence.rtdruid.modules.oil.abstractions.SimpleGenRes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.AbstractRtosWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.CommonUtils;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SectionWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.FileTypes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.ICommentWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.SectionWriterIsr;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.SectionWriterKernelCounterHw;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.CpuHwDescription;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.EEStackData;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.EEStacks;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.EmptyMacrosForSharedData;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.CpuHwDescription.OsApplicationAreas;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEWriterKeywords;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IMacrosForSharedData;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVariable;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class TricoreModel_tc27x extends TricoreAbstractModel implements IEEWriterKeywords {
	
	public static class TricoreModelProvider_tc27x implements ITricoreModelProvider {
		
		private final String modelName;
		
		/**
		 * 
		 */
		public TricoreModelProvider_tc27x(String modelName) {
			this.modelName = modelName;
		}
		
		/* (non-Javadoc)
		 * @see com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.TricoreAbstractModel.ITricoreModelProvider#newTricoreModel()
		 */
		@Override
		public TricoreAbstractModel newTricoreModel() {
			return new TricoreModel_tc27x(modelName);
		}
	}
	
	
	private static final String STACK_BASE_NAME = "EE_tc_stack_";
	private static final String STACK_SYS_BASE_NAME = "EE_tc_sys_stack_";
	private static final String SGR_OS_CPU_SYS_STACK_SIZE = "sgr__os_cpu_system_stack_size";
	private static final String SGR_OS_CPU_SYS_CSA_SIZE = "sgr__os_cpu_system_csa_size";
	private static final String SGR_OS_APPL_SHARED_STACK_ID = "sgr__os_application__shared_stack_id__integer";
	private static final String SGR_OS_APPL_STARTUP_ADDRESS = "sgr__os_application__startup_address";
	private static final long DEFAULT_SYS_STACK_SIZE = 8192;
	private static final long DEFAULT_SYS_CSA_SIZE = 16384;
	
	protected final String ERR_CPU_TYPE = "TriCore";
	private static final String EE_TRICORE_SYSTEM_TIMER_HANDLER = "EE_tc_system_timer_handler";
	private static final String EE_TRICORE_HANDLER_BASEID = "TC";
	
	private final static String[] Tasking_systemStackSymbols = new String[] {
		"_lc_ub_ustack_tc0", // core0
		"_lc_ub_ustack_tc1", // core1
		"_lc_ub_ustack_tc2", // core2
	};

	private final static String[] Gcc_Diab_systemStackSymbols = new String[] {
		"__USTACK", // core0
		"__USTACK", // core1
		"__USTACK", // core2
	};
	
	private SectionWriterIsr isrWriter; 
	private SectionWriterKernelCounterHw counterHwWriter;
	
	private final String modelName;
	
	/**
	 * 
	 */
	public TricoreModel_tc27x(String modelName) {
		this.modelName = modelName;
	}
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.TricoreAbstractModel#isPackIsrPriorities()
	 */
	@Override
	public boolean isPackIsrPriorities() {
		return false;
	}
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.TricoreAbstractModel#getMacros()
	 */
	@Override
	public IMacrosForSharedData getMacros() {
		return new TricoreMacrosForSharedData();
	}
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.TricoreAbstractModel#getEEopts()
	 */
	@Override
	public String[] getEEopts(int currentRtosId, IOilObjectList ool) {
		ArrayList<String> tmp = new ArrayList<String>();
		
		if (currentRtosId == -1) {
			tmp.add(SectionWriterHalTricore.EEOPT_HAL_TRICORE);
			tmp.add("EE_" + modelName.toUpperCase()+"__");
			
			boolean hasExportFile = false;
			for (IOilObjectList objs : parent.getOilObjects()) {
				
				ISimpleGenRes sgrCpu = objs.getList(IOilObjectList.OS).get(0);
				if (sgrCpu.containsProperty(TricoreConstants.SGRK__Tricore_COMPILER_EXPORT_FILE__) && 
					sgrCpu.getString(TricoreConstants.SGRK__Tricore_COMPILER_EXPORT_FILE__) != "") {
					hasExportFile = true;
					break;
				}
			}
			if (hasExportFile) {
				tmp.add("EE_BUILD_SINGLE_ELF");
			}
		} else {
			{ // compiler
				switch (currentCompiler) {
					case DEFAULT:
					case TASKING:
						tmp.add(SectionWriterHalTricore.EEOPT_TASKING);
						break;
					case GNU:
						tmp.add(SectionWriterHalTricore.EEOPT_GNU);
						break;
					case DIAB:
						tmp.add(SectionWriterHalTricore.EEOPT_DIAB);
						break;
					default:
						Messages.sendWarningNl("Unsupported compiler");
				}
			}
		}
		
		// only for master cpu
		if (currentRtosId == 0) {
			int cpuNumber = parent.getOilObjects().length;
			if (cpuNumber >1) {
				tmp.add("EE_START_CPU1"); 
			}
			if (cpuNumber >2) {
				tmp.add("EE_START_CPU2");
			}
		}
		return (String[]) tmp.toArray(new String[tmp.size()]);
    }
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.TricoreAbstractModel#updateObjects(com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.ErikaEnterpriseWriter, int)
	 */
	@Override
	public void updateObjects(ErikaEnterpriseWriter parent, int currentRtosId) throws OilCodeWriterException {
		super.updateObjects(parent, currentRtosId);
		final IOilObjectList[] oilObjects = parent.getOilObjects();

		if (isrWriter == null) {
			isrWriter = new SectionWriterIsr(parent, EE_TRICORE_HANDLER_BASEID);
			isrWriter.setComputeEntryFromPriority(true);
			isrWriter.setComputeIDFromPriority(true);
			isrWriter.setGenerateDefineCategory(true);
			isrWriter.setGenerateDefineIsrId(true);
			isrWriter.setEnableOsAppRpcIsr(true);
			isrWriter.setRpcIsrId(1);
	//		isrWriter.setValidEntries(ISR_LIST);
			isrWriter.updateObjects();
		}
		if (counterHwWriter == null) {
			counterHwWriter = new SectionWriterKernelCounterHw(parent, EE_TRICORE_HANDLER_BASEID, EE_TRICORE_SYSTEM_TIMER_HANDLER);
			counterHwWriter.setAllowSystemTimerPriority(true);
			counterHwWriter.setGenerateIsr2Defines(isrWriter);
			counterHwWriter.setComputeIsrEntryFromPriority(true);
			counterHwWriter.setComputeIsrIDFromPriority(true);
			counterHwWriter.updateObjects();
		}
		
		
		/***********************************************************************
		 * 
		 * System stack size
		 *  
		 **********************************************************************/
		{
			final IOilObjectList ool = oilObjects[currentRtosId];
			String[] stack_size = parent.getCpuDataValue(ool, "SYS_STACK_SIZE");
			if (stack_size != null && stack_size.length>0 && stack_size[0] != null) {
				
				boolean valid = false;
				int value = -1;
				try {
					value = Integer.decode(stack_size[0]);
					valid = true;
				} catch (NumberFormatException e) {
					Messages.sendWarningNl("Invalid value for System stack size : " + stack_size[0]);
				}
				
				if (valid && value <0) {
					Messages.sendWarningNl("System stack size cannot be negative (" + value + ")");
				} else {
					
					ISimpleGenRes sgrCpu = ool.getList(IOilObjectList.OS).get(0);
					sgrCpu.setProperty(SGR_OS_CPU_SYS_STACK_SIZE, ""+value);
				}
			}
		}
		
		/***********************************************************************
		 * 
		 * Context Save Area size
		 *  
		 **********************************************************************/
		{
			final IOilObjectList ool = oilObjects[currentRtosId];
			String[] stack_size = parent.getCpuDataValue(ool, "SYS_CSA_SIZE");
			if (stack_size != null && stack_size.length>0 && stack_size[0] != null) {
				
				boolean valid = false;
				int value = -1;
				try {
					value = Integer.decode(stack_size[0]);
					valid = true;
				} catch (NumberFormatException e) {
					Messages.sendWarningNl("Invalid value for  Context Save Area size : " + stack_size[0]);
				}
				
				if (valid && value <0) {
					Messages.sendWarningNl("Context Save Area size cannot be negative (" + value + ")");
				} else {
					
					ISimpleGenRes sgrCpu = ool.getList(IOilObjectList.OS).get(0);
					sgrCpu.setProperty(SGR_OS_CPU_SYS_CSA_SIZE, ""+value);
				}
			}
		}
		
		/***********************************************************************
		 * 
		 * Startup Address
		 *  
		 **********************************************************************/
		{
			boolean master = true;
			for (IOilObjectList ool : oilObjects) {
		        final List<String> currentCpuPrefixes = AbstractRtosWriter.getOsProperties(ool, SGRK_OS_CPU_DATA_PREFIX);
		        prefix_loop:
		        for (String currentCpuPrefix: currentCpuPrefixes) {
					String[] tmp1 = CommonUtils.getValue(vt, currentCpuPrefix + "STARTUP_ADDRESS");
					if (tmp1 != null && tmp1.length > 0) {
						ool.getList(IOilObjectList.OS).get(0).setProperty(SGR_OS_APPL_STARTUP_ADDRESS, tmp1[0]);
						if (master) {
							Messages.sendWarningNl("Startup address is ignored for core master. Instead enable Custom Startup Code flag.");
						}
						break prefix_loop;
					}
		        }
		        master = false;
			}
		}
		
		/***********************************************************************
		 * 
		 * Context Save Area size
		 *  
		 **********************************************************************/
		{
			final IOilObjectList ool = oilObjects[currentRtosId];
			String[] stack_size = parent.getCpuDataValue(ool, "SYS_CSA_SIZE");
			if (stack_size != null && stack_size.length>0 && stack_size[0] != null) {
				
				boolean valid = false;
				int value = -1;
				try {
					value = Integer.decode(stack_size[0]);
					valid = true;
				} catch (NumberFormatException e) {
					Messages.sendWarningNl("Invalid value for  Context Save Area size : " + stack_size[0]);
				}
				
				if (valid && value <0) {
					Messages.sendWarningNl("Context Save Area size cannot be negative (" + value + ")");
				} else {
					
					ISimpleGenRes sgrCpu = ool.getList(IOilObjectList.OS).get(0);
					sgrCpu.setProperty(SGR_OS_CPU_SYS_CSA_SIZE, ""+value);
				}
			}
		}
	}
	
	
	@Override
	public void write(final int currentRtosId, final IOilObjectList ool, final IOilWriterBuffer buffers) throws OilCodeWriterException {
		
		if (currentRtosId == 0 && parent.getOilObjects().length>1) {
			writeMulticoreCommon(currentRtosId, buffers);
		}
		
		writeCfg(currentRtosId, ool, buffers);
		writeMultistack(currentRtosId, ool, buffers);
		writeKernelMaxIsrPriority(currentRtosId, ool, buffers);
	}

	/**
	 * @param buffers
	 */
	private void writeCfg(final int currentRtosId, final IOilObjectList ool, final IOilWriterBuffer buffers) {
		final String indent = IWritersKeywords.INDENT;
		StringBuffer sbInithal_h = buffers.get(FILE_EE_CFG_H);
		
		ISimpleGenRes sgrCpu = ool.getList(IOilObjectList.OS).get(0);
		if (sgrCpu.containsProperty(SectionWriterHalTricore.SGR_OS_CPU_HW_END_INIT)) {
			
			
			sbInithal_h.append(indent + SectionWriter.getCommentWriter(ool, FileTypes.H).writerSingleLineComment("Hardware startup end initialization function") + 
					indent + "#define EE_START_UP_USER_ENDINIT     " + sgrCpu.getString(SectionWriterHalTricore.SGR_OS_CPU_HW_END_INIT)
					+ "\n\n");
			
		}
	}

	
	/**
	 * @param buffers
	 */
	private void writeMulticoreCommon(final int currentRtosId, final IOilWriterBuffer buffers) {
		final String indent = IWritersKeywords.INDENT;
		boolean binaryDistr = parent.checkKeyword(IEEWriterKeywords.DEF__EE_USE_BINARY_DISTRIBUTION__);
		boolean customBoot = parent.checkKeyword(IEEWriterKeywords.DEF__CUSTOM_STARTUP_CODE__);
		final String MAX_CPU = (binaryDistr ? "RTD_" : "EE_") + "MAX_CPU";
		final IOilObjectList[] objects = parent.getOilObjects();
		
		ICommentWriter commentWriter = SectionWriter.getCommentWriter(objects[0], FileTypes.C);
		IMacrosForSharedData macros = new EmptyMacrosForSharedData();
		CpuHwDescription currentStackDescription = ErikaEnterpriseWriter.getCpuHwDescription(objects[0]);
		if (currentStackDescription != null) {
			macros =currentStackDescription.getShareDataMacros();
		}
		StringBuffer sbCommon_c = buffers.get(FILE_EE_COMMON_C);
		{
			sbCommon_c.append(commentWriter.writerBanner("Slave core StartUp Address"));
			StringBuilder buff = new StringBuilder(" = {\n");
			StringBuilder decl = new StringBuilder();
		
			String pre = "";
			for (int index = 1; index<objects.length; index++) {
				IOilObjectList ool = objects[index];
				String addr = AbstractRtosWriter.getOsProperty(ool, SGR_OS_APPL_STARTUP_ADDRESS);
				boolean isNumber = true;
				if (addr == null) {
					addr = "EE_CPU"+index + "_START_ADDR";
					isNumber = false;
					
					if (customBoot) {
						Messages.sendWarningNl("Even if the option USE CUSTOM STARTUP is enabled, the core " + index + " is using the default startup address/symbol.");
					}
				} else {
					try {
						Integer.decode(addr);
					} catch (NumberFormatException e) {
						isNumber = false;
					}
				}
				
				if (!isNumber) {
					// add symbol declaration
					decl.append(indent + "extern void "+addr+" ( void );\n");
				}
				
				buff.append(pre + indent+indent+ (isNumber ? "(EE_ADDR)" : "&") +addr);
				pre = ",\n";
			}
		
			sbCommon_c.append(
					decl.toString() + "\n" +
					macros.constVectorRom(
								IWritersKeywords.INDENT + "EE_ADDR const ",
			    				"EE_as_core_start_addresses",
			    				"["+MAX_CPU+" -1]",
			    				buff + "\n"+indent +"};\n\n"));
		}
	}

	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.ITricoreModel#writeMultistack()
	 */
	protected void writeMultistack(final int currentRtosId, final IOilObjectList ool, final IOilWriterBuffer answer) throws OilCodeWriterException {
		final String indent = IWritersKeywords.INDENT;

		{
			/***********************************************************************
			 * SYSTEM STACK SIZE
			 **********************************************************************/
			ISimpleGenRes sgrCpu = ool.getList(IOilObjectList.OS).get(0);
			StringBuilder builder = new StringBuilder();
			if (sgrCpu.containsProperty(SGRK__MAKEFILE_CPU_EXT_VARS__)) {
				builder.append(sgrCpu.getString(SGRK__MAKEFILE_CPU_EXT_VARS__));
			}
			
			{ // compiler
				switch (currentCompiler) {
					case DEFAULT:
					case TASKING:
					{
						int csa_size = Integer.parseInt( "" + ErikaEnterpriseWriter.checkOrDefault(AbstractRtosWriter.getOsProperty(ool, SGR_OS_CPU_SYS_CSA_SIZE),
								DEFAULT_SYS_CSA_SIZE));
						csa_size = (int) Math.ceil(csa_size/64.0);
						builder.append("\n" + SectionWriter.getCommentWriter(ool, FileTypes.MAKEFILE).writerSingleLineComment("Add a flag for the linkerscript to set the minimum size of system stack") + 
								"LDFLAGS += -Wl-DUSTACK_TC"+currentRtosId+"=" + 
									( ErikaEnterpriseWriter.checkOrDefault(AbstractRtosWriter.getOsProperty(ool, SGR_OS_CPU_SYS_STACK_SIZE),
											DEFAULT_SYS_STACK_SIZE)) + "\n"+
								"LDFLAGS += -Wl-DCSA_TC"+currentRtosId+"=" + csa_size
								+ "\n\n");
					}
						break;
					case GNU:
					{
						builder.append("\n" + SectionWriter.getCommentWriter(ool, FileTypes.MAKEFILE).writerSingleLineComment("Add a flag for the linkerscript to set the minimum size of system stack") + 
								"LDFLAGS += -Wl,--defsym=__USTACK_SIZE=" +//+currentRtosId+"=" + 
									( ErikaEnterpriseWriter.checkOrDefault(AbstractRtosWriter.getOsProperty(ool, SGR_OS_CPU_SYS_STACK_SIZE),
											DEFAULT_SYS_STACK_SIZE)) + "\n"+
								"LDFLAGS += -Wl,--defsym=__CSA_SIZE=" +//+currentRtosId+"=" + 
									( ErikaEnterpriseWriter.checkOrDefault(AbstractRtosWriter.getOsProperty(ool, SGR_OS_CPU_SYS_CSA_SIZE),
										DEFAULT_SYS_CSA_SIZE))
								+ "\n\n");
					}
						break;
					case DIAB:
					{
						builder.append("\n" + SectionWriter.getCommentWriter(ool, FileTypes.MAKEFILE).writerSingleLineComment("Add a flag for the linkerscript to set the minimum size of system stack") + 
								"LDFLAGS += -D__USTACK_SIZE=" +//+currentRtosId+"=" + 
									( ErikaEnterpriseWriter.checkOrDefault(AbstractRtosWriter.getOsProperty(ool, SGR_OS_CPU_SYS_STACK_SIZE),
											DEFAULT_SYS_STACK_SIZE)) + "\n"+
								"LDFLAGS += -D__CSA_SIZE=" +//+currentRtosId+"=" + 
									( ErikaEnterpriseWriter.checkOrDefault(AbstractRtosWriter.getOsProperty(ool, SGR_OS_CPU_SYS_CSA_SIZE),
										DEFAULT_SYS_CSA_SIZE))
								+ "\n\n");
					}
						break;
					default:
				}
			}
			
			
			sgrCpu.setProperty(SGRK__MAKEFILE_CPU_EXT_VARS__, builder.toString());
			
			ICommentWriter commentH = SectionWriter.getCommentWriter(ool, FileTypes.H);
			StringBuffer sbInithal_h = answer.get(FILE_EE_CFG_H);
			sbInithal_h.append(indent + commentH.writerSingleLineComment("System stack size") + 
					indent + "#define EE_SYS_STACK_SIZE     " + 
						( ErikaEnterpriseWriter.checkOrDefault(AbstractRtosWriter.getOsProperty(ool, SGR_OS_CPU_SYS_STACK_SIZE),
								DEFAULT_SYS_STACK_SIZE))
					+ "\n\n");
		}

		// used by ORTI
		final String stackSymbol;
		switch (currentCompiler) {
		case TASKING : stackSymbol =  Tasking_systemStackSymbols[currentRtosId];
						break;
		case GNU:
		case DIAB:
				stackSymbol =  Gcc_Diab_systemStackSymbols[currentRtosId];
				break;
		default: stackSymbol = ""; break;
		}
		EEStackData sys_stack = new EEStackData(0,
				new long[] { Long.decode(ErikaEnterpriseWriter.checkOrDefault(AbstractRtosWriter.getOsProperty(ool, SGR_OS_CPU_SYS_STACK_SIZE), "" + DEFAULT_SYS_STACK_SIZE))},
				new long[] {0},
				new String[] {" (int)(&"+stackSymbol+")"}, true);

		if (DEF__MULTI_STACK__.equals(parent.getStackType())) {
			ICommentWriter commentC = SectionWriter.getCommentWriter(ool, FileTypes.C);
			final boolean needStackMonitoring = parent.checkKeyword(ISimpleGenResKeywords.OS_STACK_MONITORING);
	
			/*
			 * Define a string for each MAX_OBJECT_NUMBER (OBJECT=task, RESOURCE, ...).
			 * Binary distribution uses the suffix RTD_. 
			 */
			final boolean binaryDistr = parent.checkKeyword(IEEWriterKeywords.DEF__EE_USE_BINARY_DISTRIBUTION__);
			final String MAX_TASK = (binaryDistr ? "RTD_" : "EE_") + "MAX_TASK";
			final boolean kernelStack_enabled = parent.checkKeyword(IWritersKeywords.KERNEL_KERNEL_STACKS);
			final boolean osApplication_enabled = parent.checkKeyword(IWritersKeywords.KERNEL_OS_APPLICATION);
			final boolean enableMemoryProtection = parent.checkKeyword(IWritersKeywords.KERNEL_MEMORY_PROTECTION);
	
			
			// ------------- Buffers --------------------
			StringBuffer sbInithal_c = answer.get(FILE_EE_CFG_C);
			
			/* A buffer about stack  */
			final StringBuffer sbStack = new StringBuffer();
	
			/* A buffer about declarations of stacks  */
			final StringBuffer sbStackDecl = new StringBuffer();
			final StringBuffer sbStackDeclSize = new StringBuffer();
			
			
			ArrayList<EEStackData> stackTmp = new ArrayList<EEStackData>();
	
			// ------------- Buffers --------------------
			
			final int STACK_ALIGNMENT_UNIT = 8;// ErikaEnterpriseWriter.getStackUnit(ool);
			final int STACK_SIZE_UNIT = 1;// ErikaEnterpriseWriter.getStackUnit(ool);
			final ICommentWriter commentWriterC = SectionWriter.getCommentWriter(ool, FileTypes.C);
			List<ISimpleGenRes> taskNames = ool.getList(IOilObjectList.TASK);
			List<ISimpleGenRes> osApplications = ool.getList(IOilObjectList.OSAPPLICATION);
	
			String pre = "";
			String post = "";
	
	
			sbInithal_c.append("\n#include \"ee.h\"\n");
			sbInithal_c.append(commentWriterC
					.writerBanner("Stack definition for TriCore" ));
			
			ITreeInterface ti = vt.newTreeInterface();
	
			if (osApplication_enabled || needStackMonitoring) {
				sbInithal_c.append(commentWriterC.writerSingleLineComment("User Stack Base.")+
						indent + "extern EE_STACK_T EE_B_USTACK[];\n"+
						commentWriterC.writerSingleLineComment("User Stack end.")+
						indent + "extern EE_STACK_T EE_E_USTACK[];\n");
			}
	
			
			int[] irqSize = null;
			if (parent.checkKeyword(DEF__IRQ_STACK_NEEDED__)) {
				/***************************************************************
				 * IRQ_STACK
				 **************************************************************/				
				final List<String> currentCpuPrefixes = AbstractRtosWriter.getOsProperties(ool, SGRK_OS_CPU_DATA_PREFIX);
				for (String currentCpuPrefix: currentCpuPrefixes) {
					if (irqSize != null) {
						break;
					}
	
					String[] child = new String[1];
					String type = CommonUtils
							.getFirstChildEnumType(vt, currentCpuPrefix
									+ "MULTI_STACK", child);
	
					if ("TRUE".equalsIgnoreCase(type)) {
						String prefixIRQ = currentCpuPrefix
							+ "MULTI_STACK" + VARIANT_ELIST+child[0] + PARAMETER_LIST
							+ "IRQ_STACK";
						boolean ok = "TRUE".equalsIgnoreCase(CommonUtils
						.getFirstChildEnumType(vt, prefixIRQ, child));
						
						if (ok) {
							
							prefixIRQ += VARIANT_ELIST + child[0] +PARAMETER_LIST;
							irqSize = new int[1];
							{ // get data for IRQ STACK ...
								String path[] = { "SYS_SIZE" };
	
								for (int i = 0; i < path.length; i++) {
									String tmp = null;
									IVariable var = ti.getValue(prefixIRQ + path[i]
											+ VALUE_VALUE);
									if (var != null && var.get() != null) {
										tmp = var.toString();
									}
									if (tmp == null)
										throw new RuntimeException(
												ERR_CPU_TYPE + " : Expected " + path[i]);
	
									// check for value
									try {
										// ... store them inside the irqSize vector
										irqSize[0] = (Integer.decode("" + tmp))
												.intValue();
										// ... and increase the memory requirement
	//									stackEnd += irqSize[0];
									} catch (Exception e) {
										throw new RuntimeException(
												ERR_CPU_TYPE + " : Wrong int" + path[i]
														+ ", value = " + tmp + ")");
									}
								}
							}
						}
					}
				}
	
			}
	
			/*
			 * elStack contains all data about stack, for current rtos and its
			 * tasks.
			 * 
			 * tList and tListN are used to identify all tasks (theirs name and
			 * system id).
			 * 
			 * elStack accepts the list of task's names (tList) to compute all
			 * required stack and theirs size/position
			 */
			EEStacks elStack = new EEStacks(parent, ool, irqSize);
			elStack.setDummyStackPolicy(elStack.FORCE_ALWAYS | elStack.FORCE_FIRST);
			ArrayList<String> tList = new ArrayList<String>();
			ArrayList<String> tListN = new ArrayList<String>();
	
			{
				/***************************************************************
				 * STACK FOR EACH TASK
				 **************************************************************/
				
				// add the dummy task
				tListN.add(" ");
				tList.add(IWritersKeywords.dummyName);
				
				// fill data for each task
				for (Iterator<ISimpleGenRes> iter = taskNames.iterator(); iter.hasNext();) {
	
					ISimpleGenRes sgr = (ISimpleGenRes) iter.next();
					tList.add(sgr.getName());
					tListN.add(sgr.getString(ISimpleGenResKeywords.TASK_SYS_ID));
				}
	
				// fill data for each shared stack, related to OS applications
				for (Iterator<ISimpleGenRes> iter = osApplications.iterator(); iter.hasNext();) {

					ISimpleGenRes sgr = (ISimpleGenRes) iter.next();
					tList.add(EEStacks.APPLICATION_SHARED_PREFIX+ sgr.getName());
					tListN.add(" ");

					if (enableMemoryProtection) {
						tList.add(EEStacks.APPLICATION_IRQ_PREFIX+ sgr.getName());
						tListN.add("");
					}
					
					sgr.setObject(SGR_OS_APPL_SHARED_STACK_ID, new Integer((tList.size()-1)));
					sgr.setObject(EEStacks.STACK_BASE_NAME_PREFIX, STACK_BASE_NAME);
				}

				// compute total stack size and add it to memory requirement
	//			int offset[][] = elStack.taskOffsets((String[]) tList
	//					.toArray(new String[0]));
	//			stackEnd += offset[offset.length - 1][0]; // tot sys
			}
	
			
			{
				/***************************************************************
				 * PREPARE BUFFERS
				 **************************************************************/
	
				pre = "";
				post = "";
	
				/* get the link between a task and its stack. */
				int pos[] = elStack.taskStackLink(tList
						.toArray(new String[1]));
				/* get the size of each stack. */
				int size[][] = elStack.stackSize(tList
						.toArray(new String[1]));
				/* get the size of each kernel stack. */
				int sysSize[] = elStack.stackSysSize(tList
						.toArray(new String[1]));
				/* get the memory section id of each stack. */
				String memoryId[] = elStack.stackMemoryId(tList
						.toArray(new String[1]));
				/* descrStack contains a description for each stack. */ 
				String[] descrStack = new String[size.length];
				/* Number of  for each stack. */ 
				
				sbStack.append(indent
						+ "const EE_UREG EE_std_thread_tos["+MAX_TASK+"+1] = {\n");
	
				
				 // fill data for each shared stack, related to OS applications
				for (Iterator<ISimpleGenRes> iter = osApplications.iterator(); iter.hasNext();) {

					ISimpleGenRes sgr = (ISimpleGenRes) iter.next();
					Integer index = (Integer) sgr.getObject(SGR_OS_APPL_SHARED_STACK_ID);

					sgr.setProperty(ISimpleGenResKeywords.OS_APPL_SHARED_STACK_ID,"" + pos[index.intValue()]);
					
				}
				
					
				// DESCRIPTIONS
				BitSet is_irq_stack = new BitSet();
				for (int j = 0; j < pos.length; j++) {
	
					/*
					 * add the name of current task to the description of the /
					 * right stack. Check also if there is already something or
					 * not, infact in the second case append the new description
					 * to the old one
					 */ 
					String id = tList.get(j);
					boolean task = true;
					if (id != null) {
						if (id.startsWith(EEStacks.APPLICATION_SHARED_PREFIX)) {
							id = "Shared stack " + id.substring(EEStacks.APPLICATION_SHARED_PREFIX.length());
							task = false;
						} else if (id.startsWith(EEStacks.APPLICATION_IRQ_PREFIX)) {
							is_irq_stack.set(pos[j]);
							id = "Irq stack " + id.substring(EEStacks.APPLICATION_IRQ_PREFIX.length()); 
							task = false;
						}
					}
					
					if (j<=taskNames.size()) {
						sbStack.append(pre + post + indent + indent + +pos[j]+"U");
						// set new values for "post" and "pre"
						post = commentC.writerSingleLineComment(tList.get(j));
						pre = ",\t";
					}

					
					
					String txt = task ? "Task " + tListN.get(j) + " (" + id + ")" : id; 
					
					descrStack[pos[j]] = (descrStack[pos[j]] == null) ?
							// The first description
							txt
							:
							// other descriptions
							(descrStack[pos[j]] + ", " + txt); // others
				}
	
				// close sbStack
				sbStack.append(" \t" + post + indent + "};\n\n");
				
				pre = "";
				post = "";
				
				// USED BY ORTI
				stackTmp.add(sys_stack);
				
	//			 DECLARE STACK SIZE && STACK (ARRAY)
				for (int j = 1; j < size.length; j++) {
			    	final String memId = memoryId[j];
//				    value  = (value + (value%STACK_ALIGNMENT_UNIT)) / STACK_SIZE_UNIT; // arrotondo a 2
					sbStackDecl.append(indent + "EE_STACK_T "+
							(memId == null ? "EE_STACK_ATTRIB " : "EE_STACK_ATTRIB_NAME("+memId+") ") +
							STACK_BASE_NAME+j+"[EE_STACK_WLEN(STACK_"+j+"_SIZE)] EE_TC_FILL_STACK("+STACK_BASE_NAME+j+");\t" + commentC.writerSingleLineComment(descrStack[j]));
					sbStackDeclSize.append(indent + "#define STACK_"+j+"_SIZE "+size[j][0]+ " " + commentC.writerSingleLineComment("size = "+size[j][0]+" bytes"));
					// USED BY ORTI
					stackTmp.add(new EEStackData(j, new long[] {size[j][0]}, new long[] {size[j][0]},
							new String[] {" (int)(&"+STACK_BASE_NAME+j+")"}, true)); // DELTA
					
					if (kernelStack_enabled) {
						sbStackDecl.append(indent + "EE_STACK_T "+
								(memId == null ? "EE_STACK_ATTRIB " : "EE_STACK_ATTRIB_NAME("+memId+") ") +
								STACK_SYS_BASE_NAME+j+"[EE_STACK_WLEN(SYS_STACK_"+j+"_SIZE)] EE_TC_FILL_STACK("+STACK_SYS_BASE_NAME+j+");\t" + commentC.writerSingleLineComment(descrStack[j]));
						sbStackDeclSize.append(indent + "#define SYS_STACK_"+j+"_SIZE "+(sysSize[j]<2 ? "EE_KERNEL_STACK_SIZE\n" : sysSize[j]+ "*EE_KERNEL_STACK_SIZE\n"));
						// USED BY ORTI
//						stackTmp.add(new EEStackData(j, new long[] {sys_size}, new long[] {sys_size},
//								new String[] {" (int)(&"+STACK_SYS_BASE_NAME+j+")"}, true)); // DELTA
					}
				}
				
				/*
				 * For each stack prepare the configuration's vectors and
				 * descriptions
				 */
				final String additional_elements = ", 0U" + (osApplication_enabled ? ", 0U" : "");
				sbStack.append(indent + "struct EE_TC_TOS EE_tc_system_tos["
						+ ErikaEnterpriseWriter.addVectorSizeDefine(ool, "EE_tc_system_tos", size.length /* - is_irq_stack.cardinality()*/)
						+ "] = {\n"
						+ writeSystemTos(commentC, size, descrStack, new String[] {
								(osApplication_enabled ? "(EE_ADDR)EE_E_USTACK" : "0"), "0",  "EE_STACK_INITP("+STACK_BASE_NAME+size.length+")",  "EE_STACK_ENDP("+STACK_BASE_NAME+size.length+")"}, is_irq_stack, additional_elements, false, kernelStack_enabled));
				    
				if (osApplication_enabled || needStackMonitoring) {
					sbStack.append(indent + "struct EE_TC_BOS const EE_tc_system_bos["
							+ ErikaEnterpriseWriter.addVectorSizeDefine(ool, "EE_tc_system_bos", size.length /* - is_irq_stack.cardinality()*/)
							+ "] = {\n"
							+ writeSystemTos(commentC, size, descrStack, new String[] {"(EE_ADDR)EE_E_USTACK", "(EE_ADDR)EE_B_USTACK",  "EE_STACK_INITP("+STACK_BASE_NAME+size.length+")",  "EE_STACK_ENDP("+STACK_BASE_NAME+size.length+")"}, is_irq_stack, "", true /*needStackMonitoring*/, kernelStack_enabled));
				}
	
				sbStack.append(indent+ "EE_UREG EE_tc_active_tos = 0U; " +commentC.writerSingleLineComment("dummy") + "\n");
				sbStack.append(indent
						+ "EE_tc_task_save_data EE_tc_tasks_RA["+MAX_TASK+"+1];\n\n");
	
				{ // if required, init also the irq stack
					if (irqSize != null) {
					    int j = size.length;
					    long value = irqSize[0];
					    value  = (value + (value%STACK_ALIGNMENT_UNIT)) / STACK_SIZE_UNIT; // arrotondo a 2
						sbStackDecl.append(indent + "EE_STACK_T EE_STACK_ATTRIB "+STACK_BASE_NAME+j+"[EE_STACK_WLEN(STACK_"+j+"_SIZE)] EE_TC_FILL_STACK("+STACK_BASE_NAME+j+");\t" + commentC.writerSingleLineComment("irq stack"));
						sbStackDeclSize.append(indent + "#define STACK_"+j+"_SIZE "+value+" " + commentC.writerSingleLineComment("size = "+irqSize[0]+" bytes"));
	
						sbStack
								.append(indent+commentC.writerSingleLineComment("stack used only by IRQ handlers")
										+ indent+"struct EE_TOS EE_tc_IRQ_tos = {\n"
										+ indent+indent+"EE_STACK_INITP("+STACK_BASE_NAME+j+")"
//										+ (needStackMonitoring ? ", EE_STACK_ENDP("+STACK_BASE_NAME+j+")" : "")
										+ "\n" + indent+"};\n\n");
	
						// REQUIRED By ORTI's STACK
						int eesdID = stackTmp.size();
						stackTmp.add(new EEStackData(eesdID, new long[] {irqSize[0]}, new long[] {irqSize[0]},
								new String[] {" (int)(&"+STACK_BASE_NAME+j+")"}, true)); // DELTA
						
					} else if (kernelStack_enabled) {
						int j = size.length;
						sbStackDecl.append(indent + "EE_STACK_T EE_STACK_ATTRIB " +
								STACK_BASE_NAME+j+"[EE_STACK_WLEN(STACK_"+j+"_SIZE)] EE_TC_FILL_STACK("+STACK_BASE_NAME+j+");\t" + commentC.writerSingleLineComment("kernel stack"));
						sbStackDeclSize.append(indent + "#define STACK_"+j+"_SIZE EE_KERNEL_STACK_SIZE\n");
						// USED BY ORTI
//						stackTmp.add(new EEStackData(j, new long[] {sys_size}, new long[] {sys_size},
//								new String[] {" (int)(&"+STACK_SYS_BASE_NAME+j+")"}, true)); // DELTA

					}
				}
				
				{// ORTI : Store link between task and stack
					int j = 1;
					for (Iterator<ISimpleGenRes> iter = taskNames.iterator(); iter.hasNext(); j++) {
						ISimpleGenRes sgr = iter.next();
						sgr.setObject(SGRK_TASK_STACK, stackTmp.get(pos[j]));
					}
					ISimpleGenRes sgrCpu = ool.getList(IOilObjectList.OS).get(0);
					sgrCpu.setObject(SGRK_OS_STACK_LIST, stackTmp.toArray(new EEStackData[0]));
					sgrCpu.setObject(SGRK_OS_STACK_VECTOR_NAME, "EE_tc_system_tos");
					sgrCpu.setObject(SGRK_OS_STACK_VECTOR_FIELD, ".ram_tos");
				}
			}
	
			// ------------- Write --------------------
			//  add stack buffers
			sbInithal_c.append(sbStackDeclSize+"\n"+
			        sbStackDecl + "\n" +
			        sbStack);
		} else {
			
			ISimpleGenRes sgrCpu = ool.getList(IOilObjectList.OS).get(0);
			sgrCpu.setObject(SGRK_OS_STACK_LIST, new EEStackData[] {sys_stack});
		}
	}

	/**
	 * @param indent
	 * @param commentC
	 * @param sbStack
	 * @param pre
	 * @param post
	 * @param size
	 * @param descrStack
	 * @param is_irq_stack
	 * @param additional_elements
	 */
	private String writeSystemTos(ICommentWriter commentC, 
				int[][] size, String[] descrStack, String[] globalStackNames, BitSet is_irq_stack, final String additional_elements, final boolean needStackMonitoring, final boolean needKernelStack) {
		
		final StringBuilder sbStack = new StringBuilder();
		final String indent = IWritersKeywords.INDENT;
		String pre = "";
		String post = "";
		for (int j = 0; j < size.length; j++) {
		    //if (!is_irq_stack.get(j))
		    {
		        String value = "{" + 
		        			(j == 0 ? (globalStackNames == null ? "0" : globalStackNames[0]) : "EE_STACK_INITP("+STACK_BASE_NAME+j+")")
		        			+ (needStackMonitoring ? (j == 0 ? (globalStackNames == null ? ", 0" : ", " +globalStackNames[1]) : ", EE_STACK_ENDP("+STACK_BASE_NAME+j+")") : "")
		        			+ (needKernelStack     ? (j == 0 ? (globalStackNames == null ? ", 0" : ", " +globalStackNames[2]) : ", EE_STACK_INITP("+STACK_SYS_BASE_NAME+j+")") : "")
		        			+ (needKernelStack && needStackMonitoring ? (j == 0 ? (globalStackNames == null ? ", 0" : ", " +globalStackNames[3]) : ", EE_STACK_ENDP("+STACK_SYS_BASE_NAME+j+")") : "")
		        			+ additional_elements+"}";

				sbStack.append(pre
						+ post
						+ indent
						+ indent
						+ value);

				// set new values for size
				pre = ",";
				post = "\t" + commentC.writerSingleLineComment(descrStack[j]);
		    }
		}

		// complete the stack's buffer
		sbStack.append(" " + post + indent + "};\n\n");
		
		return sbStack.toString();
	}
	
	
	/**
	 * @param ool
	 * @param buffers
	 * @throws OilCodeWriterException 
	 */
	protected void writeKernelMaxIsrPriority(int currentRtosId, IOilObjectList ool, IOilWriterBuffer buffers) throws OilCodeWriterException {
		isrWriter.writeIsr(currentRtosId, ool, buffers);
		counterHwWriter.writeCounterHw(currentRtosId, ool, buffers);
		if (ool.getList(IOilObjectList.ISR).size()>0 || ool.getList(IOilObjectList.COUNTER).size()>0) {
			int max_isr_prio = 0;
			String max_isr_string = "EE_ISR_UNMASKED";
			for (ISimpleGenRes isr : ool.getList(IOilObjectList.ISR)) {
				if (isr.containsProperty(ISimpleGenResKeywords.ISR_GENERATED_PRIORITY_VALUE)) {
					final int current_prio = isr.getInt(ISimpleGenResKeywords.ISR_GENERATED_PRIORITY_VALUE);
					if (max_isr_prio< current_prio) {
						max_isr_prio = current_prio;
						max_isr_string = isr.getString(ISimpleGenResKeywords.ISR_GENERATED_PRIORITY_STRING);
					}
				}
			}
			for (ISimpleGenRes isr : ool.getList(IOilObjectList.COUNTER)) {
				if (isr.containsProperty(ISimpleGenResKeywords.COUNTER_GENERATED_PRIORITY_VALUE)) {
					final int current_prio = isr.getInt(ISimpleGenResKeywords.COUNTER_GENERATED_PRIORITY_VALUE);
					if (max_isr_prio< current_prio) {
						max_isr_prio = current_prio;
						max_isr_string = isr.getString(ISimpleGenResKeywords.COUNTER_GENERATED_PRIORITY_STRING);
					}
				}
			}

			StringBuffer sbInithal_h = buffers.get(FILE_EE_CFG_H);

			sbInithal_h.append("\n" +SectionWriter.getCommentWriter(ool, FileTypes.H).writerSingleLineComment("Max ISR priority") + 
					"#define EE_TC_MAX_ISR_ID     " + max_isr_string + "\n\n");
		}
	}
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.TricoreAbstractModel#osApplicationAreas()
	 */
	@Override
	public OsApplicationAreas osApplicationAreas() {
		return new OsApplicationAreas(new String[] {}, new String[] {"ee_ssec", "ee_esec", "ee_sstack", "ee_estack"}, new String[] {}, new String[] {"ee_skernel_ram", "ee_ekernel_ram", "ee_sstack_kernel", "ee_estack_kernel"});
	}
}
