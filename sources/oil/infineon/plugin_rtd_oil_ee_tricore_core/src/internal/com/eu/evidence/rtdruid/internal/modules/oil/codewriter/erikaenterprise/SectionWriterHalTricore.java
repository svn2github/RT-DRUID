package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise;


import static com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEWriterKeywords.S;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import com.eu.evidence.modules.oil.tricore.constants.TricoreCompiler;
import com.eu.evidence.modules.oil.tricore.constants.TricoreConstants;
import com.eu.evidence.rtdruid.desk.Messages;
import com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.TricoreAbstractModel.ITricoreModelProvider;
import com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.TricoreModel_tc1796.TricoreModelProvider_tc1796;
import com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.TricoreModel_tc27x.TricoreModelProvider_tc27x;
import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.ISimpleGenResKeywords;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.abstractions.ISimpleGenRes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.AbstractRtosWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.CommonUtils;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.HostOsUtils;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OsType;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SWCategoryManager;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SectionWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.FileTypes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.ICommentWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.CpuHwDescription;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEWriterKeywords;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractKeywordsExtentions;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractObjectsExtentions;
import com.eu.evidence.rtdruid.vartree.IVarTree;

/**
 * This writer build files for a Tricore CPU - Board
 * 
 * @author Nicola Serreli
 */
public class SectionWriterHalTricore extends SectionWriter 
	implements IEEWriterKeywords,
			IExtractObjectsExtentions,
			IExtractKeywordsExtentions {

	enum TcModels {
		tc1796("tc1796", new TricoreModelProvider_tc1796(), TricoreCompiler.GNU),
		tc26x("tc26x", new TricoreModelProvider_tc27x("tc26x"), TricoreCompiler.TASKING),
		tc27x("tc27x", new TricoreModelProvider_tc27x("tc27x"), TricoreCompiler.TASKING);
		
		public final String name;
		public final String default_compiler_txt;
		public final TricoreCompiler default_compiler;
		public final ITricoreModelProvider provider;
		/**
		 * 
		 */
		private TcModels(String name, ITricoreModelProvider provider, TricoreCompiler default_compiler) {
			this.name = name;
			this.default_compiler = default_compiler;
			this.default_compiler_txt = default_compiler == null ? null : default_compiler.getName();
			this.provider = provider;
		}
		
		public static TcModels get(String model) {
			for (TcModels current : TcModels.values()) {
				if (current.name.equalsIgnoreCase(model)) {
					return current;
				}
			}
			return null;
		}
	}
	
	public static final String SGR_OS_CPU_HW_END_INIT = "sgr__os_cpu_hw_end_init";
	public static final String SGR_OS_CPU_LINKERSCRIPT = "sgr__os_cpu_linker_script";
	public static final String SGR_OS_MCU_LINKERSCRIPT = "sgr__os_mcu_linker_script";
	
	public static final String KEY_HAL_TRICORE = "__TRICORE1__";
	public static final String EEOPT_HAL_TRICORE__OLD = "__TRICORE1__";
	public static final String EEOPT_HAL_TRICORE = "EE_TRICORE__";

	static final String EEOPT_DIAB = "EE_DIAB__";
	static final String EEOPT_GNU = "EE_GNU__";
	static final String EEOPT_TASKING = "EE_TASKING__";
	
	/** Old EEopt for old tricore model */
	static final String EEOPT_TRICORE_GNU = "__TRICORE_GNU__";

	static final String TRICORE_MCU = "TRICORE";
	
	/** The Erika Enterprise Writer that call this section writer */
	protected final ErikaEnterpriseWriter parent;
	
	/** All data */
	protected final IVarTree vt;

	/**
	 * 
	 */
	public SectionWriterHalTricore() {
		this(null);
	}
	
	/**
	 * 
	 */
	public SectionWriterHalTricore(ErikaEnterpriseWriter parent) {
		super(IWritersKeywords.CPU_TRICORE,
				new String[] {}, //
				new String[] { //
					IWritersKeywords.CPU_NIOSII,//
					IWritersKeywords.CPU_JANUS,//
					IWritersKeywords.CPU_MPC5xx,//
					IWritersKeywords.CPU_NIOSII, //
					IWritersKeywords.CPU_AVR5 },
					SWCategoryManager.defaultInstance.newCategory(SWCategoryManager.TYPE_CPU));
		
		this.parent = parent;
		this.vt = parent == null ? null : parent.getVt();
	}

	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.modules.oil.codewriter.common.SectionWriter#enabled()
	 */
	@Override
	protected boolean enabled() {
		return Collections.binarySearch(keywords, id) >= 0 || Collections.binarySearch(keywords, IWritersKeywords.CPU_TRICORE1) >= 0;
	}
	
	/**
	 * This method parse the data, prepares all buffers for
	 * <code>.c/.h/.s/.asm</code> files and store them inside a
	 * {@link OilWriterBuffer OilWriterBuffer}. If there are more than one cpu,
	 * uses one {@link OilWriterBuffer OilWriterBuffer}for each cpu.
	 * 
	 * @param vt
	 *            all data (cannot be null)
	 * 
	 * @return one {@link OilWriterBuffer OilWriterBuffer}for each cpu.
	 * 
	 * @throws OilCodeWriterException
	 *             if there are some errors
	 */
	public IOilWriterBuffer[] internalWrite(IVarTree vt)
			throws OilCodeWriterException {
		parent.check(vt);

		return writeEE_Tricore_CPU();
	}
	
	/**
	 * This method add new keywords enabled by this writer.
	 */
	public void updateKeywords(ArrayList<String> keywords, String[] rtosPrefix) {
		
		if (!keywords.contains(KEY_HAL_TRICORE)) {
			keywords.add(KEY_HAL_TRICORE);
		}
		
	}

	/**
	 * This method makes some changes to computed Oil Object
	 * @throws OilCodeWriterException 
	 */
	public void updateObjects() throws OilCodeWriterException {
		if (parent.checkKeyword(IWritersKeywords.CPU_TRICORE)) {
			updateObjects_new();
		} else if (parent.checkKeyword(IWritersKeywords.CPU_TRICORE1)) {
			updateObjects_old();
		}
	
	}
	public void updateObjects_new() throws OilCodeWriterException {
		final IOilObjectList[] oilObjects = parent.getOilObjects();		
		
        String model = null;
        String board = null;
        String board_eeopt = null;
        String mcu_linker_script = null;
        {
    		for (IOilObjectList ool : oilObjects) {

				/***********************************************************************
				 * get values
				 **********************************************************************/
				ArrayList<String> childPaths = new ArrayList<String>();
				List<String> childFound = parent.getRtosCommonChildType(ool, "MCU_DATA", childPaths);

				for (int index = 0; index<childFound.size(); index++) {
					
					String mcu_type = childFound.get(index);
					
					if (TRICORE_MCU.equals(mcu_type)) {
						if (model == null) {
							// ... and compete it 
							String currentMcuPrefix = childPaths.get(index) + PARAMETER_LIST + "MODEL";
							model = CommonUtils.getFirstChildEnumType(vt, currentMcuPrefix, null);
						}
						{    							
							String currentMcuPrefix = childPaths.get(index) + PARAMETER_LIST + "LINKERSCRIPT";
							String[] tmp1 = CommonUtils.getValue(vt, currentMcuPrefix);
							if (tmp1 != null && tmp1.length >0 && tmp1[0] != null) {
								mcu_linker_script = tmp1[0];
							}
						}
					}
					
					
				}
    		}
        }
        {
    		for (IOilObjectList ool : oilObjects) {

				/***********************************************************************
				 * get values
				 **********************************************************************/
				ArrayList<String> childPaths = new ArrayList<String>();
				List<String> childFound = parent.getRtosCommonChildType(ool, "BOARD_DATA", childPaths);

				for (int index = 0; index<childFound.size(); index++) {
					
					String mcu_type = childFound.get(index);
					
					if ("TRIBOARD_TC2X5".equals(mcu_type)) {
						board = mcu_type;
						board_eeopt = "EE_TRIBOARD_TC2X5";
					}
				}
    		}
        }
        
		TcModels tcModel = TcModels.get(model);
        String default_compiler = null;
        {
			if (tcModel == null) {
				Messages.sendWarning("Unknown tricore cpu model " + model + "\n", null, "tricore_writer_model", null);
			} else {
				default_compiler = tcModel.default_compiler_txt;
			}
        }

        ArrayList<String> tmp_common_eeopts = new ArrayList<String>();
        
        if (board_eeopt != null) {
        	tmp_common_eeopts.add(board_eeopt);
        }
        TricoreCompiler masterCompiler = TricoreCompiler.UNKNOWN; 
        
        if (board_eeopt != null) {
        	tmp_common_eeopts.add(board_eeopt);
        }
		
		for (int currentRtosId = 0; currentRtosId < oilObjects.length; currentRtosId++) {
			final IOilObjectList ool = oilObjects[currentRtosId];
	        ArrayList<String> tmp = new ArrayList<String>();

		        
	        // store all older values (if there are)
	        ISimpleGenRes sgrCpu = ool.getList(IOilObjectList.OS).get(0);
	        
			/***********************************************************************
			 * 
			 * Hardware End Init function
			 *  
			 **********************************************************************/
			{
				String[] endInitFunction = parent.getCpuDataValue(ool, "HW_ENDINIT");
				if (endInitFunction != null && endInitFunction.length>0 && endInitFunction[0] != null) {
					sgrCpu.setProperty(SGR_OS_CPU_HW_END_INIT, ""+endInitFunction[0]);
				}
			}
	        
			/***********************************************************************
			 * 
			 * CPU linker script
			 *  
			 **********************************************************************/
			{
				String[] cpu_linkerscript = parent.getCpuDataValue(ool, "LINKERSCRIPT");
				boolean linker = false;
				if (cpu_linkerscript != null && cpu_linkerscript.length>0 && cpu_linkerscript[0] != null) {
					sgrCpu.setProperty(SGR_OS_CPU_LINKERSCRIPT, ""+cpu_linkerscript[0]);
					linker = true;
				}
				if (mcu_linker_script != null) {
					sgrCpu.setProperty(SGR_OS_MCU_LINKERSCRIPT, ""+mcu_linker_script);
					linker = true;
				}
				if (parent.checkKeyword(DEF__CUSTOM_STARTUP_CODE__) && !linker) {
					throw new OilCodeWriterException("A custom linker script is needed if the custom startup code flag is enabled.");
				}
			}

			/***********************************************************************
			 * 
			 * Compiler
			 *  
			 **********************************************************************/
			final TricoreCompiler currentCompiler; 
	        {
	        	
	        	String tmp1 = null;
	        	String gnuExpFile = null;
	        	String[] childName = new String[1];
	    		for (String currentCpuPrefix: AbstractRtosWriter.getOsProperties(ool, SGRK_OS_CPU_DATA_PREFIX)) {
	    			String lPath = currentCpuPrefix + S + "COMPILER_TYPE";
	    			tmp1 = CommonUtils.getFirstChildEnumType(vt, lPath, childName);
	    			if (tmp1 != null) {
	    				
	    				if ( TricoreCompiler.get(tmp1) == TricoreCompiler.GNU) {
	    					lPath += S+childName[0];
	    					String[] value = CommonUtils.getValue(vt, lPath +S+"EXPORT_FILE");
							if (value != null && value.length>0) {
								gnuExpFile = value[0];
							}
	    				}
	    				
	    				break;
	    			}
	    		}
	        	
				if (tmp1 == null && default_compiler != null) {
					tmp1 = default_compiler;
				}
				if (tmp1 == null) {
					Messages.sendErrorNl("Explicit selection of compiler is needed for unknow tricore model" , null, "tricore_writer_model", null);
				} else {
					sgrCpu.setProperty(TricoreConstants.SGRK__Tricore_COMPILER_TYPE__, tmp1);
				}
				
				if (gnuExpFile != null) {
					sgrCpu.setProperty(TricoreConstants.SGRK__Tricore_COMPILER_EXPORT_FILE__, gnuExpFile);
				}
				
				TricoreCompiler tmpCompiler = TricoreCompiler.get(tmp1);
				if (currentRtosId == 0) {
					masterCompiler = tmpCompiler;
				} else {
					if (tmpCompiler == TricoreCompiler.DEFAULT) {
						tmpCompiler = masterCompiler;
					} else {
						if (tmpCompiler != masterCompiler) {
							throw new OilCodeWriterException("All cpu should use the same compiler type.");
						}
					}
				}
				currentCompiler = tmpCompiler;
	        }
	        
	        /***********************************************************************
			 * 
			 * MCU and BOARD Model
			 *  
			 **********************************************************************/
	        if (board != null) {
	        	sgrCpu.setProperty(TricoreConstants.SGRK__TRICORE_BOARD_MODEL__, board);
	        }
		
			{
				//List requiredOilObjects = (List) sgrCpu.getObject(SGRK__FORCE_ARRAYS_LIST__);
	
				if (tcModel == null) {
					sgrCpu.setProperty(TricoreConstants.SGRK__TRICORE_MODEL__, model);
				} else {
					TricoreAbstractModel modelInfo = null;
					CpuHwDescription descr = ErikaEnterpriseWriter.getCpuHwDescription(ool);
					if (descr instanceof CpuDescrTricore) {
						modelInfo = ((CpuDescrTricore) descr).getModel();
					}
					if (modelInfo == null) {
						modelInfo = tcModel.provider.newTricoreModel();
					}
					
	            	sgrCpu.setObject(TricoreConstants.SGRK__TRICORE_MODEL_INFO__, modelInfo);
	            	modelInfo.setCompiler(currentCompiler);
	            	modelInfo.updateObjects(parent, currentRtosId);
	            	if (currentRtosId == 0) {
						for (String s: modelInfo.getEEopts(-1, ool)) {
							tmp_common_eeopts.add(s);
						}
	            	}
					for (String s: modelInfo.getEEopts(currentRtosId, ool)) {
						tmp.add(s);
					}
					sgrCpu.setProperty(TricoreConstants.SGRK__TRICORE_MODEL__, tcModel.name);
				}
		
						
	            sgrCpu.setProperty(TricoreConstants.SGRK__TRICORE_MODEL__, model);
		        if (model == null) {
		        	tmp_common_eeopts.add(EEOPT_HAL_TRICORE);
		        }
	
				
		        // get all older values (if there are)
		        if (sgrCpu.containsProperty(ISimpleGenResKeywords.OS_CPU_EE_OPTS)) {
		        	String[] old = (String[]) sgrCpu.getObject(ISimpleGenResKeywords.OS_CPU_EE_OPTS);
		        	tmp.addAll(Arrays.asList(old));
		        }
	
				// store ee_opts
				sgrCpu.setObject(ISimpleGenResKeywords.OS_CPU_EE_OPTS, tmp.toArray(new String[tmp.size()]));
			}
		}
		for (int currentRtosId = 0; currentRtosId < oilObjects.length; currentRtosId ++) { 
			IOilObjectList ool = oilObjects[currentRtosId];
			
			/* COMMON VARIABLES */
			ISimpleGenRes sgrCpu = (ISimpleGenRes) ool.getList(IOilObjectList.OS).get(0);
			sgrCpu.setObject(ISimpleGenResKeywords.OS_CPU_COMMON_EE_OPTS, tmp_common_eeopts.toArray(new String[tmp_common_eeopts.size()]));			
		}
	}
	
	public void updateObjects_old() throws OilCodeWriterException {
		final IOilObjectList[] oilObjects = parent.getOilObjects();		
		
		for (int currentRtosId = 0; currentRtosId < oilObjects.length; currentRtosId++) {
			final IOilObjectList ool = oilObjects[currentRtosId];
	
			/***********************************************************************
			 * 
			 * EE OPTS
			 *  
			 **********************************************************************/
			{
				//List requiredOilObjects = (List) sgrCpu.getObject(SGRK__FORCE_ARRAYS_LIST__);
	
		        ArrayList<String> tmp = new ArrayList<String>();
		        
		        // store all older values (if there are)
		        ISimpleGenRes sgrCpu = ool.getList(IOilObjectList.OS).get(0);
		
		        
		        String default_compiler = TricoreConstants.SGRK__GNU_COMPILER__;
				
		        String model = null;
		        {
					String[] tmp1 = parent.getCpuDataValue(ool, "MODEL");
					if (tmp1 != null && tmp1.length >0 && tmp1[0] != null) {
						model = tmp1[0];
	
						TcModels tcModel = TcModels.get(model);
						
						if (tcModel == null) {
							Messages.sendWarning("Unknown tricore cpu model " + model + "\n", null, "tricore_writer_model", null);
						} else {
							TricoreAbstractModel modelInfo = tcModel.provider.newTricoreModel();
			            	sgrCpu.setObject(TricoreConstants.SGRK__TRICORE_MODEL_INFO__, modelInfo);
			            	modelInfo.updateObjects(parent, currentRtosId);
			            	for (String s: modelInfo.getEEopts(-1, ool)) {
			            		tmp.add(s);
							}
							for (String s: modelInfo.getEEopts(currentRtosId, ool)) {
								tmp.add(s);
							}
							default_compiler = tcModel.default_compiler_txt;
						}
						
			            sgrCpu.setProperty(TricoreConstants.SGRK__TRICORE_MODEL__, model);
			        }
				}
		        if (model == null) {
					tmp.add(EEOPT_HAL_TRICORE__OLD);
		        }
	
	
		        { // select compiler
					sgrCpu.setProperty(TricoreConstants.SGRK__Tricore_COMPILER_TYPE__, default_compiler);
					if (TricoreConstants.SGRK__GNU_COMPILER__.equalsIgnoreCase(default_compiler)) {
						if (!TcModels.tc1796.name.equalsIgnoreCase(model)) {
							Messages.sendWarningNl("GNU compiler tested only with tc1796");
				        }
						tmp.add(TcModels.tc1796.name.equalsIgnoreCase(model) ? EEOPT_TRICORE_GNU : EEOPT_GNU);
				    } else 	if (TricoreConstants.SGRK__TASKING_COMPILER__.equalsIgnoreCase(default_compiler)) {
						if (!TcModels.tc27x.name.equalsIgnoreCase(model)) {
							Messages.sendWarningNl("TASKING compiler tested only with tc27x");
				        }
			            tmp.add(EEOPT_TASKING);
					}
		        }
	
		        
				
		        // get all older values (if there are)
		        if (sgrCpu.containsProperty(ISimpleGenResKeywords.OS_CPU_EE_OPTS)) {
		        	String[] old = (String[]) sgrCpu.getObject(ISimpleGenResKeywords.OS_CPU_EE_OPTS);
		        	tmp.addAll(Arrays.asList(old));
		        }
	
				// store ee_opts
				sgrCpu.setObject(ISimpleGenResKeywords.OS_CPU_EE_OPTS, tmp.toArray(new String[tmp.size()]));
			}
		}
	}
	
	/**
	 * Write configuration's files for TriCore
	 * 
	 * @return buffers with configuration for TriCore
	 * 
	 * @throws OilCodeWriterException
	 *             if there are some problems
	 */
	protected IOilWriterBuffer[] writeEE_Tricore_CPU()
			throws OilCodeWriterException {

		final IOilObjectList[] oilObjects = parent.getOilObjects();
		IOilWriterBuffer[] all_results = new IOilWriterBuffer[oilObjects.length];
		
		for (int currentRtosId = 0; currentRtosId < oilObjects.length; currentRtosId++) {
			IOilWriterBuffer answer = all_results[currentRtosId] = new OilWriterBuffer();
			
			
			final IOilObjectList ool = oilObjects[currentRtosId];
			
			// ------------- Compute --------------------
			TricoreAbstractModel tricoreModel = (TricoreAbstractModel) AbstractRtosWriter.getOsObject(ool, TricoreConstants.SGRK__TRICORE_MODEL_INFO__);
			/***********************************************************************
			 * tricore model specifics
			 **********************************************************************/
			if (tricoreModel != null) {
				tricoreModel.write(currentRtosId, ool, answer);
			}
	
			/***********************************************************************
			 * MakeFile
			 **********************************************************************/
			writeMakeFile(currentRtosId, ool);
		}
		return all_results;
	}


	/**
	 * MakeFile
	 */
	private void writeMakeFile(final int currentRtosId, final IOilObjectList ool) {
		final ICommentWriter commentWriterMf = getCommentWriter(ool, FileTypes.MAKEFILE);
		final boolean multicore = parent.getOilObjects().length>1;
		OsType wrapper = HostOsUtils.common.getTarget();

		StringBuffer sbMakefile = new StringBuffer(commentWriterMf
				.writerBanner("Tricore"));
		
		StringBuilder sbVariables = new StringBuilder();
		StringBuilder sbCommon = new StringBuilder();

		{ // PATHs
			HashMap<String, ?> options = parent.getOptions();

			String outputDir = "Debug";
			String appBase = "..";
			// Get Default values

			if (options.containsKey(IWritersKeywords.WRITER_OUTPUT_DIR_SET)) {
				outputDir = (String) options
						.get(IWritersKeywords.WRITER_LAST_OUTPUT_DIR);
				outputDir = (String) options
						.get(IWritersKeywords.WRITER_FS_PATH_OUTPUT_DIR);

				appBase = (String) options
						.get(IWritersKeywords.WRITER_WS_OUTPUT_projectbase_DIR);// "..";
				if (options
						.containsKey(IWritersKeywords.WRITER_WS_PATH_OUTPUT_DIR)) {
					outputDir = (String) options
							.get(IWritersKeywords.WRITER_WS_PATH_OUTPUT_DIR);
				}
			}
			IPath p = new Path(outputDir);
			if (p.isAbsolute()) {
				outputDir = wrapper.wrapPath(outputDir);
			}
			
			String platformStr = "";
			if (wrapper == OsType.Linux) {
				platformStr = "export PLATFORM := LINUX\n\n";
			} else {
				platformStr = "export PLATFORM := CYGWIN\n\n";
			}
			
			String model = ErikaEnterpriseWriter.checkOrDefault(AbstractRtosWriter.getOsProperty(ool, TricoreConstants.SGRK__TRICORE_MODEL__), "");
			final String baseID = TcModels.tc1796.name.equals(model) ? "TRICORE1" : "TRICORE";
			// compiler
			String compiler_define = "";
			{
		        String compiler_type = AbstractRtosWriter.getOsProperty(ool,TricoreConstants.SGRK__Tricore_COMPILER_TYPE__);
		        if (TricoreConstants.SGRK__GNU_COMPILER__.equalsIgnoreCase(compiler_type)) {
		        	String temp_path = "$(shell dirname \"$(shell which tricore-gcc)\")/../";
		        	
			    	if (options.containsKey(TricoreConstants.PREF_TRICORE_GNU_CC_PATH)) {
						String tmp = (String) options.get(TricoreConstants.PREF_TRICORE_GNU_CC_PATH);
						if (tmp != null && tmp.length()>0) temp_path = tmp;
					} 
			    	 compiler_define = CommonUtils.compilerMakefileDefines(temp_path, baseID +"_GCCDIR", wrapper);
			    	
		        } else if (TricoreConstants.SGRK__TASKING_COMPILER__.equalsIgnoreCase(compiler_type)) {
		        	
		        	String temp_path = "$(shell dirname \"$(shell which cctc)\")/../../";
		        	
			    	if (options.containsKey(TricoreConstants.PREF_TRICORE_TASKING_CC_PATH)) {
						String tmp = (String) options.get(TricoreConstants.PREF_TRICORE_TASKING_CC_PATH);
						if (tmp != null && tmp.length()>0) temp_path = tmp;
					} 
			    	 compiler_define = CommonUtils.compilerMakefileDefines(temp_path, baseID +"_TASKINGDIR", wrapper);

		        } else if (TricoreConstants.SGRK__DIAB_COMPILER__.equalsIgnoreCase(compiler_type)) {
		        	
		        	String temp_path = "$(shell dirname \"$(shell which dcc)\")/../";
		        	
			    	if (options.containsKey(TricoreConstants.PREF_TRICORE_DIAB_CC_PATH)) {
						String tmp = (String) options.get(TricoreConstants.PREF_TRICORE_DIAB_CC_PATH);
						if (tmp != null && tmp.length()>0) temp_path = tmp;
					} 
			    	 compiler_define = CommonUtils.compilerMakefileDefines(temp_path, baseID +"_DIABDIR", wrapper);

		        } else {
		        	compiler_define = "$(warning No compiler set)\n";
		        }
			}
			String model_txt = TcModels.get(model) == null ? model : TcModels.get(model).name ;
			
			sbMakefile.append(platformStr
							+ "APPBASE := " + appBase + "\n"
							+ "OUTBASE := " + outputDir + "\n");
			
			sbCommon.append(baseID +"_MODEL  := " + model_txt + "\n");

			if (multicore) {
				sbCommon.append("\n"+
						CommonUtils.addMakefileDefinesInclude()
						+ compiler_define);
			} else {
				sbVariables.append("\n"+
						CommonUtils.addMakefileDefinesInclude()
						+ compiler_define);
			}
		}

		ISimpleGenRes sgrCpu = ool.getList(IOilObjectList.OS).get(0);

		{ // linker script
			String link = null;
			if (sgrCpu.containsProperty(SGR_OS_CPU_LINKERSCRIPT)) {
				link = sgrCpu.getString(SGR_OS_CPU_LINKERSCRIPT);
			}
			if (link == null && sgrCpu.containsProperty(SGR_OS_MCU_LINKERSCRIPT)) {
				link = sgrCpu.getString(SGR_OS_MCU_LINKERSCRIPT);
			}
			
			if (link != null) {
				sbVariables.append("EE_LINKERSCRIPT := " + link+ "\n");
			}
			
		}
		
		{ // export file
			String exportFile = null;
			if (sgrCpu.containsProperty(TricoreConstants.SGRK__Tricore_COMPILER_EXPORT_FILE__)) {
				exportFile = sgrCpu.getString(TricoreConstants.SGRK__Tricore_COMPILER_EXPORT_FILE__);
			}
			
			if (exportFile != null) {
				sbVariables.append("EE_USER_EXPORT_FILE := " + exportFile+ "\n");
			}
			
		}

		
		if (multicore) {
			if (sgrCpu.containsProperty(SGRK__COMMON_MAKEFILE_MP_EXT_VARS__)) {
				sbCommon.append(sgrCpu.getString(SGRK__COMMON_MAKEFILE_MP_EXT_VARS__));
			}
			sgrCpu.setProperty(SGRK__COMMON_MAKEFILE_MP_EXT_VARS__, sbCommon.toString());
		} else {
			sbVariables.append(sbCommon.toString());
		}
		
		if (sgrCpu.containsProperty(SGRK__MAKEFILE_EXTENTIONS__)) {
			sbMakefile.append(sgrCpu.getString(SGRK__MAKEFILE_EXTENTIONS__));
		}
		sgrCpu.setProperty(SGRK__MAKEFILE_EXTENTIONS__, sbMakefile.toString());

		if (sgrCpu.containsProperty(SGRK__MAKEFILE_CPU_EXT_VARS__)) {
			sbVariables.append(sgrCpu.getString(SGRK__MAKEFILE_CPU_EXT_VARS__));
		}
		sgrCpu.setProperty(SGRK__MAKEFILE_CPU_EXT_VARS__, sbVariables.toString());
	}
	
	/**
	 * This metod takes an array and returns the first element, or null if the
	 * array is a zero-length array or if the first element is empty ("" or
	 * null)
	 */
	protected String clean(String[] arr) {
		String answer = null;
		if (arr != null && arr.length>0) {
			if (arr[0].trim().length()>0) {
				answer= arr[0].trim();
			}
		}
		return answer;
	}
}
