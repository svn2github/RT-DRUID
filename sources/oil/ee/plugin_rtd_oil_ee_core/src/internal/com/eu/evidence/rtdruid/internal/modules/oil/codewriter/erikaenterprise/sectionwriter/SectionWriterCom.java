/*
 * Created on 5-apr-2006
 *
 * $Id: SectionWriterHalMico32.java,v 1.17 2008/02/05 10:15:18 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.sectionwriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.eu.evidence.rtdruid.desk.Messages;
import com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.ErikaEnterpriseWriter;
import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.abstractions.ISimpleGenRes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.CommonUtils;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SWCategoryManager;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SectionWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.CommentWriterEmpty;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.FileTypes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.ICommentWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.CpuUtility;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEWriterKeywords;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractKeywordsExtentions;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractObjectsExtentions;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IGetEEOPTExtentions;
import com.eu.evidence.rtdruid.modules.oil.implementation.OilObjectType;
import com.eu.evidence.rtdruid.modules.oil.implementation.OilPath;
import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;

/**
 * This writer build files for the intercommunication among two cores using a "fake" autosar com
 * 
 * @author Nicola Serreli
 */
public class SectionWriterCom extends SectionWriter 
	implements IEEWriterKeywords,
			IExtractObjectsExtentions,
			IExtractKeywordsExtentions,
			IGetEEOPTExtentions {
	
	
	private static final String FILE_COM_C = "Com.c";
	public final static String WriterID = "ee_com_writer";
	public final static String KEY_COM_FOUND = "ee_com_found";

	static final String indent1 = IWritersKeywords.INDENT;
	static final String indent2 = indent1 + IWritersKeywords.INDENT;

	protected static final DataPackage DPKG = DataPackage.eINSTANCE;
	protected static final char S = DataPath.SEPARATOR;
	
	/*
	 * Simple Gen Res Keywords
	 * 
	 */
	private static final String SGRK_COM_COMTYPE = "SimpleGenResKey_com_comtype";
	private static final String SGRK_COM_COMSTATUS = "SimpleGenResKey_com_comStatus";
	private static final String SGRK_COM_COMERRORHOOK = "SimpleGenResKey_com_comErrorHook";
	private static final String SGRK_COM_COMAPPMODE = "SimpleGenResKey_com_comAPPMODE_stringArray";
	private static final String SGRK_COM_STARTCOMEXTENSION = "SimpleGenResKey_com_comstartcomeextension";
	private static final String SGRK_COM_INCLUDES = "SimpleGenResKey_com_include_files";
	
	
	private static final String SGRK_MESSAGE_INIT_VALUE = "SimpleGenResKeyword__message_initial_value";

	private static final String SGRK_MESSAGE_TYPE = "SimpleGenResKeyword__message_type";
	private static final String MESSAGE_TYPE__SEND_STATIC_INTERNAL = "SEND_STATIC_INTERNAL";
	private static final String MESSAGE_TYPE__RECEIVE_UNQUEUED_INTERNAL = "RECEIVE_UNQUEUED_INTERNAL";
	private static final String MESSAGE_TYPE__RECEIVE_QUEUED_INTERNAL = "RECEIVE_QUEUED_INTERNAL";

	private static final String SGRK_MESSAGE_SEND_INTERNAL_DATATYPE = "SimpleGenResKeyword__message_send_internal_datatype";
	private static final String SGRK_MESSAGE_SEND_INTERNAL_DATASIZE = "SimpleGenResKeyword__message_send_internal_datasize";

	private static final String SGRK_MESSAGE_RECEIVE_SENDINGMSG = "SimpleGenResKeyword__message_receive__sending_message";
	private static final String SGRK_MESSAGE_RECEIVE_UQ_INITVALUE = SGRK_MESSAGE_INIT_VALUE;
	private static final String SGRK_MESSAGE_RECEIVE_Q_QUEUESIZE = "SimpleGenResKeyword__message_receive__queue_size";

	
	private static final String SGRK_MESSAGE_NOTIFICATION_TYPE = "SimpleGenResKeyword__message_notification__";
	private static final String NOTIFICATION__COMCALLBACK = "COMCALLBACK";
	private static final String NOTIFICATION__FLAG = "FLAG";
	private static final String NOTIFICATION__SETEVENT = "SETEVENT";
	private static final String NOTIFICATION__ACTIVATETASK = "ACTIVATETASK";

	private static final String SGRK_MESSAGE_NOTIFICATION_TASK_TASKNAME = "SimpleGenResKeyword__message_notification__task_task_name";
	private static final String SGRK_MESSAGE_NOTIFICATION_EVENT_TASKNAME = "SimpleGenResKeyword__message_notification__event_task_name";
	private static final String SGRK_MESSAGE_NOTIFICATION_EVENT_EVENTNAME = "SimpleGenResKeyword__message_notification__event_event_name";
	private static final String SGRK_MESSAGE_NOTIFICATION_COMCB__CBNAME = "SimpleGenResKeyword__message_notification__callback_name";
	private static final String SGRK_MESSAGE_NOTIFICATION_COMCB__MESSAGES = "SimpleGenResKeyword__message_notification__comcb_messages_array";
	private static final String SGRK_MESSAGE_NOTIFICATION_FLAG__NAME = "SimpleGenResKeyword__message_notification__flag_name";

	
	
	/*
	 * 
	 */
	private static final Map<String, String> VALID_CDATATYPES;
	private static final Map<String, String> COM_EEOPTS;
	
	static {
		VALID_CDATATYPES = new LinkedHashMap<String, String>();
		
		// 8
		VALID_CDATATYPES.put("BYTE", "8");
		VALID_CDATATYPES.put("INT8", "8");
		VALID_CDATATYPES.put("UINT8", "8");
		VALID_CDATATYPES.put("EE_INT8", "8");
		VALID_CDATATYPES.put("EE_UINT8", "8");

		// 16
		VALID_CDATATYPES.put("SHORT", "16");
		VALID_CDATATYPES.put("INT16", "16");
		VALID_CDATATYPES.put("UINT16", "16");
		VALID_CDATATYPES.put("EE_INT16", "16");
		VALID_CDATATYPES.put("EE_UINT16", "16");

		// 32
		VALID_CDATATYPES.put("INT", "32");
		VALID_CDATATYPES.put("UINT", "32");
		VALID_CDATATYPES.put("FLOAT", "32");
		VALID_CDATATYPES.put("INT32", "32");
		VALID_CDATATYPES.put("UINT32", "32");
		VALID_CDATATYPES.put("EE_INT32", "32");
		VALID_CDATATYPES.put("EE_UINT32", "32");
		VALID_CDATATYPES.put("EE_FLOAT", "32");

		// 64
		VALID_CDATATYPES.put("LONG", "64");
		VALID_CDATATYPES.put("DOUBLE", "64");
		VALID_CDATATYPES.put("EE_LONG", "64");
		VALID_CDATATYPES.put("EE_DOUBLE", "64");

		
		
		COM_EEOPTS = new HashMap<String, String>();
		
		COM_EEOPTS.put("CCCA", "__COM_CCCA__");
		COM_EEOPTS.put("CCCB", "__COM_CCCB__");
	};
	
	
	/** The Erika Enterprise Writer that call this section writer */
	protected final ErikaEnterpriseWriter parent;
	
	/** All data */
	protected final IVarTree vt;
	
	/**
	 * 
	 */
	public SectionWriterCom() {
		this(null);
	}
	
	/**
	 * 
	 */
	public SectionWriterCom(ErikaEnterpriseWriter parent) {
		super(WriterID,
				new String[] {}, //
				new String[] {},
					SWCategoryManager.defaultInstance.newCategory(SWCategoryManager.TYPE_CPU));
		
		this.parent = parent;
		this.vt = parent == null ? null : parent.getVt();
	}

	@Override
	protected boolean enabled() {
		return parent.checkKeyword(KEY_COM_FOUND);
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

		return writeCom();
	}
	
	/**
	 * This method add new keywords enabled by this writer.
	 */
	public void updateKeywords(ArrayList<String> keywords, String[] rtosPrefix) {
		
		if (!keywords.contains(KEY_COM_FOUND)) {
			if (parent.existObject(IOilObjectList.COM)) {
				keywords.add(KEY_COM_FOUND);
			}
		}
		
	}

	/**
	 * This method makes some changes to computed Oil Object
	 * @throws OilCodeWriterException if some ISR's attribute is missing 
	 */
	public void updateObjects() throws OilCodeWriterException {
		final IOilObjectList[] oilObjects = parent.getOilObjects();
		
        String comType = null;
        int messagesNumber = 0;

        final String oilHwRtosPrefix = parent.getOilHwRtosPrefix();
		
		for (final IOilObjectList ool : oilObjects) {
			
			for (ISimpleGenRes sgr : ool.getList(IOilObjectList.COM)) {
//				System.out.println("-- COM -- " + sgr.getName() + " " + sgr.getPath());
				final String path = sgr.getPath() + S + (new OilPath(OilObjectType.COM, sgr.getName())).getPath() + "/";
				
				{ // get COM TYPE
					String chType = CommonUtils.getFirstChildEnumType(vt, path+"COMTYPE");
					if (chType!= null) {
						if (comType == null) {
							comType = chType;
						} else {
							if (!comType.equals(chType)) {
								throw new OilCodeWriterException("Found different values for COM/COMTYPE");
							}
						}
						sgr.setProperty(SGRK_COM_COMTYPE, chType);
						
					}
				}
				
				{// get COM COMAPPMODE
					String[] values = CommonUtils.getValue(vt, path+"COMAPPMODE");
					if (values!= null && values.length>0) {
						sgr.setObject(SGRK_COM_COMAPPMODE, values);
					} else {
						throw new OilCodeWriterException("Expected a value for COM/COMAPPMODE");
					}
				}
				
				{ // get COM TYPE
					String chType = CommonUtils.getFirstChildEnumType(vt, path+"COMSTARTCOMEXTENSION");
					if ("true".equalsIgnoreCase(chType)) {
						sgr.setProperty(SGRK_COM_STARTCOMEXTENSION, "true");
					}
				}
				{ // get COM STATUS
					String chType = CommonUtils.getFirstChildEnumType(vt, path+"COMSTATUS");
					if (chType != null) {
						sgr.setProperty(SGRK_COM_COMSTATUS, chType);
					}
				}
				{ // get COM ErrorHook
					String chType = CommonUtils.getFirstChildEnumType(vt, path+"COMERRORHOOK");
					if ("true".equalsIgnoreCase(chType)) {
						sgr.setProperty(SGRK_COM_COMERRORHOOK, "true");
					}
				}
				
				{ // get INCLUDE files
					String[] includes = CommonUtils.getValue(vt, path+"INCLUDES");
					if (includes != null) {
						sgr.setObject(SGRK_COM_INCLUDES, includes);
					}
				}
				
				
				
//				System.out.println("\t" + sgr);
			}
			
			for (ISimpleGenRes sgr : ool.getList(IOilObjectList.MESSAGE)) {
				messagesNumber++;
				System.out.println("-- MESSAGE -- " + sgr.getName() + " " + sgr.getPath());
				final String path = sgr.getPath() +S+ (new OilPath(OilObjectType.MESSAGE, sgr.getName())).getPath();
				
				boolean sending = false;
				
				{ // get MESSAGEPROPERTY
					String[] chName = new String[1];
					String tPath = path+"MESSAGEPROPERTY";
					String chType = CommonUtils.getFirstChildEnumType(vt, tPath, chName);
					tPath += VARIANT_ELIST+chName[0]+ PARAMETER_LIST;
					if (MESSAGE_TYPE__SEND_STATIC_INTERNAL.equals(chType)) {
						//        SEND INTERNAL
						sending = true;
						
						sgr.setProperty(SGRK_MESSAGE_TYPE, chType);
						tPath += "CDATATYPE";
						
						String[] value = CommonUtils.getValue(vt, tPath);
						if (value != null && value.length>0) {
							String length = getLength(value[0]);
							if (length == null) {
//								Messages.sendWarningNl("Found an unknown value for CDATATYPE in message " + sgr.getName());
								length = "8U*sizeof("+value[0]+")";
							}
							
							sgr.setProperty(SGRK_MESSAGE_SEND_INTERNAL_DATATYPE, value[0]);
							sgr.setProperty(SGRK_MESSAGE_SEND_INTERNAL_DATASIZE, length);
						} else {
							throw new OilCodeWriterException("Expected a value for CDATATYPE in message " + sgr.getName());
						}

						
					} else if (MESSAGE_TYPE__RECEIVE_UNQUEUED_INTERNAL.equals(chType)) {
						//        RECIVE UNQUEUED
						sgr.setProperty(SGRK_MESSAGE_TYPE, chType);
						
						
						{
							String tName = getReference(ool, tPath+"SENDINGMESSAGE", IOilObjectList.MESSAGE);
							if (tName == null) {
								throw new OilCodeWriterException("Cannot find the sending message related to " + sgr.getName());
							} else {
								sgr.setProperty(SGRK_MESSAGE_RECEIVE_SENDINGMSG, tName);
							}
						}

						{
							long found = 0;
							String[] value = CommonUtils.getValue(vt, tPath+"INITIALVALUE");
							if (value != null && value.length>0) {
								try {
									found = Long.decode(value[0]);
								} catch (NumberFormatException e) {
									throw new OilCodeWriterException("IntialValue of " + sgr.getName() + " message is not a valid number ("+value[0]+")");
								}
							}
							
							sgr.setProperty(SGRK_MESSAGE_RECEIVE_UQ_INITVALUE, ""+ found);
						}
						
					} else if (MESSAGE_TYPE__RECEIVE_QUEUED_INTERNAL.equals(chType)) {
						//        RECIVE QUEUED
						if ("CCCA".equals(comType)) {
							throw new OilCodeWriterException("Com type CCCA does not support queued messages");
						}
						sgr.setProperty(SGRK_MESSAGE_TYPE, chType);
						
						{
							String tName = getReference(ool, tPath+"SENDINGMESSAGE", IOilObjectList.MESSAGE);
							if (tName == null) {
								throw new OilCodeWriterException("Cannot find the sending message related to " + sgr.getName());
							} else {
								sgr.setProperty(SGRK_MESSAGE_RECEIVE_SENDINGMSG, tName);
							}
						}

						{
							long found = 0;
							String[] value = CommonUtils.getValue(vt, tPath+"QUEUESIZE");
							if (value != null && value.length>0) {
								try {
									found = Long.decode(value[0]);
								} catch (NumberFormatException e) {
									throw new OilCodeWriterException("The queue size of " + sgr.getName() + " message is not a valid number ("+value[0]+")");
								}
							} else {
								throw new OilCodeWriterException("Missing the queue size of " + sgr.getName() + " message");
							}
							
							sgr.setProperty(SGRK_MESSAGE_RECEIVE_Q_QUEUESIZE, ""+ found);
						}
						
					}
					
				} // end messageProperty enum
				
				
				{ // get NOTIFICATION
					String[] chName = new String[1];
					String tPath = path+"NOTIFICATION";
					String chType = CommonUtils.getFirstChildEnumType(vt, tPath, chName);
					tPath += VARIANT_ELIST+chName[0]+ PARAMETER_LIST;
					
					if (chType == null || "NONE".equals(chType)) {
						// do nothing
					} else {
						if (sending && "CCCA".equals(comType)) {
							throw new OilCodeWriterException("Sending messages does not support notification while COM class is CCCA (message = " + sgr.getName()+ ")");
						}
						
						if (NOTIFICATION__ACTIVATETASK.equals(chType)) {
						
							//        Activate Task
							sgr.setProperty(SGRK_MESSAGE_NOTIFICATION_TYPE, chType);

							String tName = getReference(ool, tPath+"TASK", IOilObjectList.TASK);
							if (tName == null) {
								throw new OilCodeWriterException("Cannot find the task that should be activated by " + sgr.getName() + " message");
							} else {
								sgr.setProperty(SGRK_MESSAGE_NOTIFICATION_TASK_TASKNAME, tName);
							}
	
							
						} else if (NOTIFICATION__SETEVENT.equals(chType)) {
							//        Set Event
							sgr.setProperty(SGRK_MESSAGE_NOTIFICATION_TYPE, chType);

							String tName = getReference(ool, tPath+"TASK", IOilObjectList.TASK);
							if (tName == null) {
								throw new OilCodeWriterException("Cannot find the task that should be activated by " + sgr.getName() + " message");
							} else {
								sgr.setProperty(SGRK_MESSAGE_NOTIFICATION_EVENT_TASKNAME, tName);
							}

							String eName = getReference(ool, tPath+"EVENT", IOilObjectList.EVENT);
							if (eName == null) {
								throw new OilCodeWriterException("Cannot find the event that should be activated by " + sgr.getName() + " message");
							} else {
								sgr.setProperty(SGRK_MESSAGE_NOTIFICATION_EVENT_EVENTNAME, eName);
							}
	
							
						} else if (NOTIFICATION__COMCALLBACK.equals(chType)) {
							//        com callback
							sgr.setProperty(SGRK_MESSAGE_NOTIFICATION_TYPE, chType);
							
							
							String[] value = CommonUtils.getValue(vt, tPath+"CALLBACKROUTINENAME");
							if (value != null && value.length>0) {
								sgr.setProperty(SGRK_MESSAGE_NOTIFICATION_COMCB__CBNAME, value[0]);
							} else {
								throw new OilCodeWriterException("Missing the call back name for the message " + sgr.getName());
							}
							
							String[][] tNames = getReferences(ool, tPath+"MESSAGE", IOilObjectList.MESSAGE);
							if (tNames[1].length == 0) {
								sgr.setObject(SGRK_MESSAGE_NOTIFICATION_COMCB__MESSAGES, tNames[0]);
							} else {
								throw new OilCodeWriterException("The message " + sgr.getName() + " contains references to unknown message " + Arrays.asList(tNames[1]));
							}

								
						} else if (NOTIFICATION__FLAG.equals(chType)) {
							
							if ("CCCA".equals(comType)) {
								throw new OilCodeWriterException("Com type CCCA does not support FLAG notifications");
							}
							sgr.setProperty(SGRK_MESSAGE_NOTIFICATION_TYPE, chType);
							
							{
								String[] value = CommonUtils.getValue(vt, tPath+"FLAGNAME");
								if (value != null && value.length>0) {
									sgr.setProperty(SGRK_MESSAGE_NOTIFICATION_FLAG__NAME, value[0]);
								} else {
									throw new OilCodeWriterException("Missing the flag name for the message " + sgr.getName());
								}
							}
							
						}
					}
				} // end message Notification enum
				
				
				System.out.println("\t" + sgr);
			
				
				
			} // END MESSAGE

		} // END for OilObjects

		if (comType == null && messagesNumber>0) {
			throw new OilCodeWriterException("Expected a value for COM/COMTYPE when there is at least one message");
		}
	}
	
	/**
	 * Check all references to the specified object type stored in the givne path.
	 * 
	 * return two arrays. the first one is the list of "valid" names, while the second one contains the wrong values. 
	 * 
	 * @param ool
	 * @param string
	 * @param objType
	 * @return
	 */
	private String[][] getReferences(IOilObjectList ool, String path,
			int objType) {
		ArrayList<String> good = new ArrayList<String>();
		ArrayList<String> bad = new ArrayList<String>();
		
		String[] value = CommonUtils.getValue(vt, path);
		if (value != null) {
			for (String id: value) {
				boolean found = false;
				
				for (ISimpleGenRes tmpSgr : ool.getList(objType)) {
					if (tmpSgr.getName().equals(id)) {
						found = true;
						break;
					}
				}
				
				if (found) {
					good.add(id);
				} else {
					bad.add(id);
				}
				
			}
			
		}
		
		return new String[][] {
				(String[]) good.toArray(new String[good.size()]),
				(String[]) bad.toArray(new String[bad.size()])
		};
	}

	private String getReference(IOilObjectList ool, String tPath, int objType) {
		String[] value = CommonUtils.getValue(vt, tPath);
		if (value != null && value.length>0) {
			for (ISimpleGenRes tmpSgr : ool.getList(objType)) {
				if (tmpSgr.getName().equals(value[0])) {
					return value[0];
				}
			}
		}
		return null;
	}

	private String getLength(String key) {
		
		if (key != null) {
			key = key.toUpperCase();
			if (VALID_CDATATYPES.containsKey(key)) {
				return VALID_CDATATYPES.get(key);
			}
		}
		return null;
	}
	
	private boolean enableCom(IOilObjectList[] ools) {
		boolean answer = false;
		for (IOilObjectList ool : ools) {
			answer |= enableCom(ool);
		}
		return answer;
	}
	
	private boolean enableCom(IOilObjectList ool) {
		boolean answer = false;
		for (ISimpleGenRes sgr : ool.getList(IOilObjectList.COM)) {
			answer |= sgr.containsProperty(SGRK_COM_COMTYPE) && sgr.getString(SGRK_COM_COMTYPE) != null &&  sgr.getString(SGRK_COM_COMTYPE).length()>0;
		}
		return answer;
	}
	
	
	/**
	 * Write configuration's files for Com initialization
	 * 
	 * @return buffers with configuration for the Com initialization
	 * 
	 * @throws OilCodeWriterException
	 *             if there are some problems
	 */
	protected IOilWriterBuffer[] writeCom()
			throws OilCodeWriterException {
		
		
		final IOilObjectList[] oilObjects = parent.getOilObjects();
		if (!enableCom(oilObjects)) {
			return new IOilWriterBuffer[0];
		}
		
		IOilWriterBuffer[] answer = new IOilWriterBuffer[oilObjects.length];//new IOilWriterBuffer[oilObjects.length];

		final int rtosNumber = oilObjects.length;

		IOilWriterBuffer common_buf = prepareCommonCom_c();

		/***********************************************************************
		 * prepare and write buffers for All OS
		 **********************************************************************/
		for (int currentRtosId = 0; currentRtosId < rtosNumber; currentRtosId++) {
			final IOilObjectList ool = oilObjects[currentRtosId];
			answer[currentRtosId] = new OilWriterBuffer();
			
			// Write only if there is something to do, else continue with the next cpu
			if (!enableCom(ool)) {
				continue;
			}
			
			
			answer[currentRtosId].append(common_buf);
			StringBuffer buff_c = answer[currentRtosId].get(FILE_COM_C);
			StringBuffer buff_h = answer[currentRtosId].get(FILE_EE_CFG_H);

			ICommentWriter commentWriter;
			{
				commentWriter = getCommentWriter(ool, FileTypes.C);
				CpuUtility.addSources(ool, new String[] {answer[currentRtosId].getFileName(FILE_COM_C)});
			}
			

			buff_c.append("#include \"com/com/inc/ee_cominit.h\"\n");
			
			{
				Set<String> added = new HashSet<String>();
				for (ISimpleGenRes com: ool.getList(IOilObjectList.COM)) {
					
					if (com.containsProperty(SGRK_COM_INCLUDES)) {
						for (String s: (String[]) com.getObject(SGRK_COM_INCLUDES)) {
							if (s != null && !added.contains(s)) {
								added.add(s);
								buff_c.append("#include \"" + s.replace("\\","/") + "\"\n");
							}
						}
					}
				}
			}
			
			
			{
				StringBuffer messages_define = new StringBuffer(commentWriter.writerBanner("Messages")+
						"#define EE_COM_N_MSG " + ool.getList(IOilObjectList.MESSAGE).size()+ "U\n\n");
				int message_id = 0;
				
				StringBuffer messages_ram = new StringBuffer(commentWriter.writerSingleLineComment("Messages (RAM)")+
						"struct EE_com_msg_RAM_TYPE * EE_com_msg_RAM[EE_COM_N_MSG] = {");
				StringBuffer messages_rom = new StringBuffer(commentWriter.writerSingleLineComment("Messages (ROM)")+
						"const struct EE_com_msg_ROM_TYPE * EE_com_msg_ROM[EE_COM_N_MSG] = {");
				StringBuffer messages_init_rom = new StringBuffer(commentWriter.writerSingleLineComment("Messages initial Value (ROM)")+
						"const EE_UINT64 EE_com_msg_init_val[EE_COM_N_MSG] = {");
				
				// use set to prevent multiple definition of the same id
				Set<String> callBackIds = new HashSet<String>();
				Set<String> flagIds = new HashSet<String>();
				Set<String> taskIds = new HashSet<String>();
				// buffers
				StringBuffer callBackDecls = new StringBuffer();
				StringBuffer flagDecls = new StringBuffer();
				StringBuffer taskDecls = new StringBuffer();
				TaskEventMap taskEventMap = new TaskEventMap();
				LinkedHashMap<String, String> sendDecls = new LinkedHashMap<String, String>();
				LinkedHashMap<String, String> sendSize = new LinkedHashMap<String, String>();
				LinkedHashMap<String, List<ISimpleGenRes>> receiving = new LinkedHashMap<String, List<ISimpleGenRes>>();
				
				String sep = "\n";
				for (ISimpleGenRes sgr : ool.getList(IOilObjectList.MESSAGE)) {
					
					String initValue = "0";
					if (sgr.containsProperty(SGRK_MESSAGE_INIT_VALUE)) {
						initValue = sgr.getString(SGRK_MESSAGE_INIT_VALUE);
					}
					
					if (MESSAGE_TYPE__SEND_STATIC_INTERNAL.equals(sgr.getString(SGRK_MESSAGE_TYPE))) {
						sendDecls.put(sgr.getName(), "EE_COM_DEFINE_INTERNAL_MESSAGE("
								+sgr.getName()+", "
								+sgr.getString(SGRK_MESSAGE_SEND_INTERNAL_DATASIZE)+", "
								);
						sendSize.put(sgr.getName(), sgr.getString(SGRK_MESSAGE_SEND_INTERNAL_DATASIZE));
					} else if (MESSAGE_TYPE__RECEIVE_UNQUEUED_INTERNAL.equals(sgr.getString(SGRK_MESSAGE_TYPE)) 
							||MESSAGE_TYPE__RECEIVE_QUEUED_INTERNAL.equals(sgr.getString(SGRK_MESSAGE_TYPE))) {
						String sender = sgr.getString(SGRK_MESSAGE_RECEIVE_SENDINGMSG);
						List<ISimpleGenRes> list;
						if (receiving.containsKey(sender)) {
							list = receiving.get(sender);
						} else {
							list = new ArrayList<ISimpleGenRes>();
							receiving.put(sender, list);
						}
						list.add(sgr);
					}
					
					if (sgr.containsProperty(SGRK_MESSAGE_NOTIFICATION_TYPE)) { 
						if (NOTIFICATION__COMCALLBACK.equals(sgr.getString(SGRK_MESSAGE_NOTIFICATION_TYPE))) {
							String id = sgr.getString(SGRK_MESSAGE_NOTIFICATION_COMCB__CBNAME);
							if (!callBackIds.contains(id)) {
								callBackDecls.append("EE_COM_DECLARE_CALLBACK(" + id + ");\n");
								callBackIds.add(id);
							}
						} else if (NOTIFICATION__FLAG.equals(sgr.getString(SGRK_MESSAGE_NOTIFICATION_TYPE))) {
							String id = sgr.getString(SGRK_MESSAGE_NOTIFICATION_FLAG__NAME);
							if (!flagIds.contains(id)) {
								flagDecls.append("EE_COM_DEFINE_FLAG(" + id + ");\n");
								flagIds.add(id);
							}
						} else if (NOTIFICATION__SETEVENT.equals(sgr.getString(SGRK_MESSAGE_NOTIFICATION_TYPE))) {
							taskEventMap.add(sgr.getString(SGRK_MESSAGE_NOTIFICATION_EVENT_TASKNAME), sgr.getString(SGRK_MESSAGE_NOTIFICATION_EVENT_EVENTNAME));
							
						} else if (NOTIFICATION__ACTIVATETASK.equals(sgr.getString(SGRK_MESSAGE_NOTIFICATION_TYPE))) {
							String id = sgr.getString(SGRK_MESSAGE_NOTIFICATION_TASK_TASKNAME);
							if (!taskIds.contains(id)) {
								taskDecls.append("EE_TID task_to_call__" + id + " = " + id + ";\n");
								taskIds.add(id);
							}
						}

					}
				
					messages_define.append("#define " +sgr.getName() + " " + message_id+ "U\n");
					messages_ram.append(sep + indent1 + "EE_com_msg_RAM("+sgr.getName()+")");
					messages_rom.append(sep + indent1 + "EE_com_msg_ROM("+sgr.getName()+")");
					messages_init_rom.append(sep + indent1 + initValue);
					
					message_id++;
					sep = ",\n";
				}
				messages_ram.append("\n};\n\n");
				messages_rom.append("\n};\n\n");
				messages_init_rom.append("\n};\n\n");


				StringBuffer receiveDecls = new StringBuffer();
				for (Entry<String, List<ISimpleGenRes>> entry: receiving.entrySet()) {
					String size;
					{
						// complete the send message declaration
						String sendName = entry.getKey();
						size = sendSize.get(sendName);
						if (size == null) {
							// this error is already checked before and cannot happen here !
							throw new OilCodeWriterException("Cannot find the send message " + sendName);
						}
					}
					
				
					
					boolean chain = false;
					for (ISimpleGenRes sgr : entry.getValue()) {
						if (chain) {
							receiveDecls.append(sgr.getName() + ");\n");
						} else {
							// complete the send message declaration
							String sendName = entry.getKey();
							String sendDeclaration = sendDecls.get(sendName);
							if (sendDeclaration == null) {
								// this error is already checked before and cannot happen here !
								throw new OilCodeWriterException("Cannot find the send message " + sendName);
							}
							
							//if (!sendDeclaration.endsWith(");")) { // always true
								sendDecls.put(sendName, sendDeclaration + sgr.getName() + ");");
							//}
							
							
							receiveDecls.append("\n" +
									commentWriter.writerSingleLineComment("Receiving " +sendName));
						}
						chain = true;
						
						
						
						String queue_size = "";
						
						// Message Type
						if (MESSAGE_TYPE__RECEIVE_UNQUEUED_INTERNAL.equals(sgr.getString(SGRK_MESSAGE_TYPE))) {
							receiveDecls.append("EE_COM_DEFINE_INTERNAL_UNQUEUED_MESSAGE(" 
									+ sgr.getName()+ ", "+size+", F_Always, NULL,\n" +
										"                                        ");
							
						} else if (MESSAGE_TYPE__RECEIVE_QUEUED_INTERNAL.equals(sgr.getString(SGRK_MESSAGE_TYPE))) {
							receiveDecls.append("EE_COM_DEFINE_INTERNAL_QUEUED_MESSAGE(" 
									+ sgr.getName()+ ", "+size+", F_Always, NULL,\n" +
											"                                      ");
							queue_size = sgr.getString(SGRK_MESSAGE_RECEIVE_Q_QUEUESIZE)+", ";
						}
						
						// Notification
						String decl_type = "EE_COM_NO_OK";
						String ref = "NULL";
						
						if (sgr.containsProperty(SGRK_MESSAGE_NOTIFICATION_TYPE)) {
							String chType = sgr.getString(SGRK_MESSAGE_NOTIFICATION_TYPE);
							
							if (NOTIFICATION__ACTIVATETASK.equals(chType)) {
								decl_type = "EE_COM_T_OK";
								ref = "&task_to_call__" +sgr.getString(SGRK_MESSAGE_NOTIFICATION_TASK_TASKNAME);
								
							} else if (NOTIFICATION__SETEVENT.equals(chType)) {
								decl_type = "EE_COM_E_OK";
								ref = "&"+taskEventMap.getStructureName(sgr.getString(SGRK_MESSAGE_NOTIFICATION_EVENT_TASKNAME), sgr.getString(SGRK_MESSAGE_NOTIFICATION_EVENT_EVENTNAME));
								
							} else if (NOTIFICATION__COMCALLBACK.equals(chType)) {
								decl_type = "EE_COM_CB_OK";
								ref = "(void*)" +sgr.getString(SGRK_MESSAGE_NOTIFICATION_COMCB__CBNAME);
									
							} else if (NOTIFICATION__FLAG.equals(chType)) {
								decl_type = "EE_COM_F_OK";
								ref = "&" +sgr.getString(SGRK_MESSAGE_NOTIFICATION_FLAG__NAME);
							}
						}
						
						receiveDecls.append(decl_type + ", "+ ref + ", " + queue_size);
						
					}
					
					receiveDecls.append("EE_COM_NULL);\n\n");
				}
				
				buff_h.append(messages_define.toString());
				
				if (taskDecls.length()>0) {
					// add call backs
					buff_c.append("\n" +
							commentWriter.writerSingleLineComment("Tasks") +
							taskDecls + "\n");
				}
				if (callBackDecls.length()>0) {
					// add call backs
					buff_c.append("\n" +
							commentWriter.writerSingleLineComment("Callbacks") +
							callBackDecls + "\n");
				}
				if (flagDecls.length()>0) {
					// add call backs
					buff_c.append("\n" +
							commentWriter.writerSingleLineComment("Flags") +
							flagDecls + "\n");
				}
				if (taskEventMap.size()>0) {
					// add SetEvents
					buff_c.append("\n" +
							commentWriter.writerSingleLineComment("Set Events") +
							taskEventMap.getInitStructures() + "\n");
				}
				
				
				buff_c.append("\n" +
						commentWriter.writerSingleLineComment("Transmission"));
				for (Entry<String, String> entry: sendDecls.entrySet()) {
					String s = entry.getValue();
					if (s.endsWith(");")) {
						buff_c.append(s+"\n");
					} else {
						buff_c.append(s+"EE_COM_NULL);\n");
						Messages.sendWarningNl("Send message " + entry.getKey() + " does not have any receiver");
					}
				}
				
				
				buff_c.append(
						receiveDecls.toString() + "\n" +
						messages_ram.toString() + 
						messages_rom.toString() +
						messages_init_rom.toString());
			}

			
			
		}
		
		return answer;
	}
	
	protected IOilWriterBuffer prepareCommonCom_c()
			throws OilCodeWriterException {
		IOilWriterBuffer answer = new OilWriterBuffer();
		StringBuffer buff_c = answer.get(FILE_COM_C);
		StringBuffer buff_h = answer.get(FILE_EE_CFG_H);

		
		ArrayList<String> allComModes = new ArrayList<String>();
		ICommentWriter commentWriter = null;

		final IOilObjectList[] oilObjects = parent.getOilObjects();		
		/***********************************************************************
		 * prepare and write buffers for All OS
		 **********************************************************************/
		for (IOilObjectList ool: oilObjects) {
			
			if (commentWriter == null) {
				commentWriter = getCommentWriter(ool, FileTypes.C);
			}
			
			
			for (ISimpleGenRes sgr : ool.getList(IOilObjectList.COM)) {
				allComModes.addAll(Arrays.asList((String[]) sgr.getObject(SGRK_COM_COMAPPMODE)));
			}
		}
		if (commentWriter == null) {
			commentWriter = new CommentWriterEmpty();
		}

		/*
		 * COM APP MODE
		 */
		String sep = "";
		buff_c.append(commentWriter.writerBanner("COM application modes") + 
				"COMApplicationModeType EE_com_validmodes[EE_COM_N_MODE] = {");
		buff_h.append(commentWriter.writerBanner("COM application modes") + 
				"#define EE_COM_N_MODE "+ allComModes.size()+"U\n\n");
		int com_appmode_id = 0;
		for (String s: allComModes) {
			buff_h.append("#define "+s+" " + com_appmode_id + "U\n");
			buff_c.append(sep + s);
			sep = ",";
			com_appmode_id ++;
		}
		buff_c.append("};\n");
		buff_h.append("\n");
		
		
		
		return answer;
	}

	@Override
	public List<String> getEEOpt(int type, int rtosId) {
		ArrayList<String> answer = new ArrayList<String>();
		
		if ((type & EE_OPT_CPU_ONLY) != 0 && rtosId >= 0) {
		
			final IOilObjectList[] oilObjects = parent.getOilObjects();
			final IOilObjectList ool = oilObjects[rtosId];
			
			for (ISimpleGenRes sgr : ool.getList(IOilObjectList.COM)) {
				if (sgr.containsProperty(SGRK_COM_COMTYPE)) {
					String comType = sgr.getString(SGRK_COM_COMTYPE);
					if (COM_EEOPTS.containsKey(comType)) {
						answer.add(COM_EEOPTS.get(comType));
					}
				}
				
				if (sgr.containsProperty(SGRK_COM_COMERRORHOOK)) {
					if ("true".equalsIgnoreCase(sgr.getString(SGRK_COM_COMERRORHOOK))) {
						answer.add("__COM_HAS_ERRORHOOK__");
					}
				}
				
				if (sgr.containsProperty(SGRK_COM_COMSTATUS)) {
					if ("COMEXTENDED".equalsIgnoreCase(sgr.getString(SGRK_COM_COMSTATUS))) {
						answer.add("__EE_COM_EXTENDED__");
					}
				}
				
				if (sgr.containsProperty(SGRK_COM_STARTCOMEXTENSION)) {
					if ("true".equalsIgnoreCase(sgr.getString(SGRK_COM_STARTCOMEXTENSION))) {
						answer.add("__USE_STARTCOM_EXTENSION__");
					}
				}
			}
		}
		
		return answer;
	}
	

}
