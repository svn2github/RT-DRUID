/*
 * Created on Jul 12, 2004
 *
 * $ID$
 */
package com.eu.evidence.rtdruid.test.modules.jscan.common;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import com.eu.evidence.rtdruid.internal.modules.jscan.AbstractCompleteTest;
import com.eu.evidence.rtdruid.internal.modules.jscan.JScan;
import com.eu.evidence.rtdruid.internal.modules.jscan.JScanImplTest;
import com.eu.evidence.rtdruid.internal.modules.jscan.Schedulability;
import com.eu.evidence.rtdruid.internal.modules.jscan.common.JScanImpl;
import com.eu.evidence.rtdruid.internal.modules.jscan.multiframe.MultiFrameTaskSchedulability;
import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVariable;
import com.eu.evidence.rtdruid.vartree.Vt2StringUtilities;
import com.eu.evidence.rtdruid.vartree.abstractions.old.GenRes;
import com.eu.evidence.rtdruid.vartree.abstractions.old.IGeneralMultiframeTaskWcet;
import com.eu.evidence.rtdruid.vartree.abstractions.old.Task;
import com.eu.evidence.rtdruid.vartree.abstractions.old.TaskSet;
import com.eu.evidence.rtdruid.vartree.tools.Search;

/**
 * @author Nicola Serreli
 */
public class JScanMultiFrameTest extends AbstractCompleteTest {
	
	public JScanMultiFrameTest(String name) {
		super(name);
	}
	
	public final static String[] example1 = {
		// input
		"<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n" +
		"<!DOCTYPE SYSTEM SYSTEM \"evidence_0.4.dtd\">" +
		"<SYSTEM Name=\"Test\">\n" +
		"  <ARCHITECTURAL>\n" +
		"    <ECU Name=\"ecu\">\n" +
		"      <CPU Name=\"ecuCpu\">\n" +
		"        <RTOS Name=\"ecuRtos\"/>\n" +
		"      </CPU>\n" +
		"    </ECU>\n" +
		"    <TASK Name=\"startup\" Type=\"task\">\n" +
		"      <SCHEDULING Priority=\"1\"/>\n" +
		"      <ACTIVATION Deadline=\"1000ms\" Period=\"1000ms\" Type=\"sporadic\"/>\n" +
		"    </TASK>\n" +
		"    <TASK Name=\"intCam\" Type=\"task\">\n" +
		"      <SCHEDULING Priority=\"6\"/>\n" +
		"      <ACTIVATION Deadline=\"5ms\" Period=\"5ms\" Type=\"sporadic\"/>\n" +
		"    </TASK>\n" +
		"    <TASK Name=\"timeSlow\" Type=\"task\">\n" +
		"      <SCHEDULING Priority=\"2\"/>\n" +
		"      <ACTIVATION Deadline=\"100ms\" Period=\"100ms\" Type=\"periodic\"/>\n" +
		"    </TASK>\n" +
		"    <TASK Name=\"timeMedium\" Type=\"task\">\n" +
		"      <SCHEDULING Priority=\"3\"/>\n" +
		"      <ACTIVATION Deadline=\"12ms\" Period=\"12ms\" Type=\"periodic\"/>\n" +
		"    </TASK>\n" +
		"    <TASK Name=\"timeFast\" Type=\"task\">\n" +
		"      <SCHEDULING Priority=\"4\"/>\n" +
		"      <ACTIVATION Deadline=\"4ms\" Period=\"4ms\" Type=\"periodic\"/>\n" +
		"    </TASK>\n" +
		"    <TASK Name=\"psmHigh\" Type=\"task\">\n" +
		"      <SCHEDULING Priority=\"5\"/>\n" +
		"      <ACTIVATION Deadline=\"5ms\" Period=\"5ms\" Type=\"sporadic\"/>\n" +
		"    </TASK>\n" +
		"  </ARCHITECTURAL>\n" +
		"  <FUNCTIONAL>\n" +
		"    <PROC Name=\"sys1_startup\">\n" +
		"      <METHOD Name=\"run\"/>\n" +
		"    </PROC>\n" +
		"    <PROC Name=\"sys2_startup\">\n" +
		"      <METHOD Name=\"run\"/>\n" +
		"    </PROC>\n" +
		"    <PROC Name=\"sys1_fastTime\">\n" +
		"      <METHOD Name=\"run\"/>\n" +
		"    </PROC>\n" +
		"    <PROC Name=\"sys1_configSynch\">\n" +
		"      <METHOD Name=\"run\"/>\n" +
		"    </PROC>\n" +
		"    <PROC Name=\"sys1_excepCam\">\n" +
		"      <METHOD Name=\"run\"/>\n" +
		"      <METHODREF MethodName=\"sys1_excepFault/run\" Name=\"sys1_excepFault.run\"/>\n" +
		"    </PROC>\n" +
		"    <PROC Name=\"tg1_excepCam\">\n" +
		"      <METHOD Name=\"run\"/>\n" +
		"    </PROC>\n" +
		"    <PROC Name=\"tg2_excepCam\">\n" +
		"      <METHOD Name=\"run\"/>\n" +
		"    </PROC>\n" +
		"    <PROC Name=\"tg3_excepCam\">\n" +
		"      <METHOD Name=\"run\"/>\n" +
		"    </PROC>\n" +
		"    <PROC Name=\"sys1_excepFault\">\n" +
		"      <METHOD Name=\"run\"/>\n" +
		"      <METHODREF MethodName=\"sys1_excepTooth/run\" Name=\"sys1_excepTooth.run\"/>\n" +
		"    </PROC>\n" +
		"    <PROC Name=\"sys1_excepTooth\">\n" +
		"      <METHOD Name=\"run\"/>\n" +
		"    </PROC>\n" +
		"    <PROC Name=\"sys2_excepCam\">\n" +
		"      <METHOD Name=\"run\"/>\n" +
		"    </PROC>\n" +
		"    <PROC Name=\"tg3_mediumTime\">\n" +
		"      <METHOD Name=\"run\"/>\n" +
		"    </PROC>\n" +
		"    <PROC Name=\"tg2_mediumTime\">\n" +
		"      <METHOD Name=\"run\"/>\n" +
		"    </PROC>\n" +
		"    <PROC Name=\"tg1_slowTime\">\n" +
		"      <METHOD Name=\"run\"/>\n" +
		"    </PROC>\n" +
		"    <TRIGGER Name=\"AcceptKeyOnEvent\">\n" +
		"      <METHODREF MethodName=\"sys1_startup/run\" Name=\"sys1_startup.trigger\"/>\n" +
		"      <METHODREF MethodName=\"sys2_startup/run\" Name=\"sys2_startup.trigger\"/>\n" +
		"    </TRIGGER>\n" +
		"    <TRIGGER Name=\"AcceptEventTimeFast\">\n" +
		"      <METHODREF MethodName=\"sys1_fastTime/run\" Name=\"sys1_fastTime.trigger\"/>\n" +
		"    </TRIGGER>\n" +
		"    <TRIGGER Name=\"AcceptEventPsmHigh\">\n" +
		"      <METHODREF MethodName=\"sys1_configSynch/run\" Name=\"sys1_configSynch.trigger\"/>\n" +
		"    </TRIGGER>\n" +
		"    <TRIGGER Name=\"AcceptEventIntCam\">\n" +
		"      <METHODREF MethodName=\"sys1_excepCam/run\" Name=\"sys1_excepCam.trigger\"/>\n" +
		"      <METHODREF MethodName=\"tg1_excepCam/run\" Name=\"tg1_excepCam.trigger\"/>\n" +
		"      <METHODREF MethodName=\"tg2_excepCam/run\" Name=\"tg2_excepCam.trigger\"/>\n" +
		"      <METHODREF MethodName=\"tg3_excepCam/run\" Name=\"tg3_excepCam.trigger\"/>\n" +
		"      <METHODREF MethodName=\"sys2_excepCam/run\" Name=\"sys2_excepCam.trigger\"/>\n" +
		"    </TRIGGER>\n" +
		"    <TRIGGER Name=\"AcceptEventTimeMedium\">\n" +
		"      <METHODREF MethodName=\"tg3_mediumTime/run\" Name=\"tg3_mediumTime.trigger\"/>\n" +
		"      <METHODREF MethodName=\"tg2_mediumTime/run\" Name=\"tg2_mediumTime.trigger\"/>\n" +
		"    </TRIGGER>\n" +
		"    <TRIGGER Name=\"AcceptEventTimeSlow\">\n" +
		"      <METHODREF MethodName=\"tg1_slowTime/run\" Name=\"tg1_slowTime.trigger\"/>\n" +
		"    </TRIGGER>\n" +
		"    <EVENT MethodRefName=\"AcceptKeyOnEvent/sys1_startup.trigger\" Name=\"sys1_startup.act\" Type=\"activation\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptKeyOnEvent/sys2_startup.trigger\" Name=\"sys2_startup.act\" Type=\"activation\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptKeyOnEvent/sys1_startup.trigger\" Name=\"sys1_startup.begin\" Type=\"begin\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptKeyOnEvent/sys2_startup.trigger\" Name=\"sys2_startup.begin\" Type=\"begin\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptKeyOnEvent/sys1_startup.trigger\" Name=\"sys1_startup.end\" Type=\"end\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptKeyOnEvent/sys2_startup.trigger\" Name=\"sys2_startup.end\" Type=\"end\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventTimeFast/sys1_fastTime.trigger\" Name=\"sys1_fastTime.act\" Type=\"activation\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventTimeFast/sys1_fastTime.trigger\" Name=\"sys1_fastTime.begin\" Type=\"begin\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventTimeFast/sys1_fastTime.trigger\" Name=\"sys1_fastTime.end\" Type=\"end\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventPsmHigh/sys1_configSynch.trigger\" Name=\"sys1_configSynch.act\" Type=\"activation\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventPsmHigh/sys1_configSynch.trigger\" Name=\"sys1_configSynch.begin\" Type=\"begin\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventPsmHigh/sys1_configSynch.trigger\" Name=\"sys1_configSynch.end\" Type=\"end\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventIntCam/sys1_excepCam.trigger\" Name=\"sys1_excepCam.act\" Type=\"activation\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventIntCam/tg1_excepCam.trigger\" Name=\"tg1_excepCam.act\" Type=\"activation\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventIntCam/tg2_excepCam.trigger\" Name=\"tg2_excepCam.act\" Type=\"activation\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventIntCam/tg3_excepCam.trigger\" Name=\"tg3_excepCam.act\" Type=\"activation\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventIntCam/sys2_excepCam.trigger\" Name=\"sys2_excepCam.act\" Type=\"activation\"/>\n" +
		"    <EVENT MethodRefName=\"sys1_excepCam/sys1_excepFault.run\" Name=\"sys1_excepFault.begin\" Type=\"begin\"/>\n" +
		"    <EVENT MethodRefName=\"sys1_excepFault/sys1_excepTooth.run\" Name=\"sys1_excepTooth.begin\" Type=\"begin\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventIntCam/sys1_excepCam.trigger\" Name=\"sys1_excepCam.begin\" Type=\"begin\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventIntCam/tg1_excepCam.trigger\" Name=\"tg1_excepCam.begin\" Type=\"begin\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventIntCam/tg2_excepCam.trigger\" Name=\"tg2_excepCam.begin\" Type=\"begin\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventIntCam/tg3_excepCam.trigger\" Name=\"tg3_excepCam.begin\" Type=\"begin\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventIntCam/sys2_excepCam.trigger\" Name=\"sys2_excepCam.begin\" Type=\"begin\"/>\n" +
		"    <EVENT MethodRefName=\"sys1_excepCam/sys1_excepFault.run\" Name=\"sys1_excepFault.end\" Type=\"end\"/>\n" +
		"    <EVENT MethodRefName=\"sys1_excepFault/sys1_excepTooth.run\" Name=\"sys1_excepTooth.end\" Type=\"end\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventIntCam/sys1_excepCam.trigger\" Name=\"sys1_excepCam.end\" Type=\"end\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventIntCam/tg1_excepCam.trigger\" Name=\"tg1_excepCam.end\" Type=\"end\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventIntCam/tg2_excepCam.trigger\" Name=\"tg2_excepCam.end\" Type=\"end\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventIntCam/tg3_excepCam.trigger\" Name=\"tg3_excepCam.end\" Type=\"end\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventIntCam/sys2_excepCam.trigger\" Name=\"sys2_excepCam.end\" Type=\"end\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventTimeMedium/tg3_mediumTime.trigger\" Name=\"tg3_mediumTime.act\" Type=\"activation\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventTimeMedium/tg2_mediumTime.trigger\" Name=\"tg2_mediumTime.act\" Type=\"activation\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventTimeMedium/tg3_mediumTime.trigger\" Name=\"tg3_mediumTime.begin\" Type=\"begin\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventTimeMedium/tg2_mediumTime.trigger\" Name=\"tg2_mediumTime.begin\" Type=\"begin\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventTimeMedium/tg3_mediumTime.trigger\" Name=\"tg3_mediumTime.end\" Type=\"end\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventTimeMedium/tg2_mediumTime.trigger\" Name=\"tg2_mediumTime.end\" Type=\"end\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventTimeSlow/tg1_slowTime.trigger\" Name=\"tg1_slowTime.act\" Type=\"activation\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventTimeSlow/tg1_slowTime.trigger\" Name=\"tg1_slowTime.begin\" Type=\"begin\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventTimeSlow/tg1_slowTime.trigger\" Name=\"tg1_slowTime.end\" Type=\"end\"/>\n" +
		"    <PARTIALORDER>\n" +
		"      <ORDER>\n" +
		"        <EVENTREF Name=\"sys1_excepCam.end\"/>\n" +
		"        <EVENTREF Name=\"sys1_excepFault.begin\"/>\n" +
		"      </ORDER>\n" +
		"      <ORDER>\n" +
		"        <EVENTREF Name=\"sys1_excepFault.end\"/>\n" +
		"        <EVENTREF Name=\"sys1_excepTooth.begin\"/>\n" +
		"      </ORDER>\n" +
		"    </PARTIALORDER>\n" +
		"    <TIMECONST>\n" +
		"      <EVENTREF Name=\"sys1_startup.act\"/>\n" +
		"      <BOUND Type=\"mit\" Value=\"1000ms\"/>\n" +
		"    </TIMECONST>\n" +
		"    <TIMECONST>\n" +
		"      <EVENTREF Name=\"sys2_startup.act\"/>\n" +
		"      <BOUND Type=\"mit\" Value=\"1000ms\"/>\n" +
		"    </TIMECONST>\n" +
		"    <TIMECONST>\n" +
		"      <EVENTREF Name=\"sys1_fastTime.act\"/>\n" +
		"      <BOUND Type=\"period\" Value=\"4ms\"/>\n" +
		"    </TIMECONST>\n" +
		"    <TIMECONST>\n" +
		"      <EVENTREF Name=\"sys1_configSynch.act\"/>\n" +
		"      <BOUND Type=\"mit\" Value=\"5ms\"/>\n" +
		"    </TIMECONST>\n" +
		"    <TIMECONST>\n" +
		"      <EVENTREF Name=\"sys1_excepCam.act\"/>\n" +
		"      <BOUND Type=\"mit\" Value=\"5ms\"/>\n" +
		"    </TIMECONST>\n" +
		"    <TIMECONST>\n" +
		"      <EVENTREF Name=\"tg1_excepCam.act\"/>\n" +
		"      <BOUND Type=\"mit\" Value=\"5ms\"/>\n" +
		"    </TIMECONST>\n" +
		"    <TIMECONST>\n" +
		"      <EVENTREF Name=\"tg2_excepCam.act\"/>\n" +
		"      <BOUND Type=\"mit\" Value=\"5ms\"/>\n" +
		"    </TIMECONST>\n" +
		"    <TIMECONST>\n" +
		"      <EVENTREF Name=\"tg3_excepCam.act\"/>\n" +
		"      <BOUND Type=\"mit\" Value=\"5ms\"/>\n" +
		"    </TIMECONST>\n" +
		"    <TIMECONST>\n" +
		"      <EVENTREF Name=\"sys2_excepCam.act\"/>\n" +
		"      <BOUND Type=\"mit\" Value=\"5ms\"/>\n" +
		"    </TIMECONST>\n" +
		"    <TIMECONST>\n" +
		"      <EVENTREF Name=\"tg3_mediumTime.act\"/>\n" +
		"      <BOUND Type=\"period\" Value=\"12ms\"/>\n" +
		"    </TIMECONST>\n" +
		"    <TIMECONST>\n" +
		"      <EVENTREF Name=\"tg2_mediumTime.act\"/>\n" +
		"      <BOUND Type=\"period\" Value=\"12ms\"/>\n" +
		"    </TIMECONST>\n" +
		"    <TIMECONST>\n" +
		"      <EVENTREF Name=\"tg1_slowTime.act\"/>\n" +
		"      <BOUND Type=\"period\" Value=\"100ms\"/>\n" +
		"    </TIMECONST>\n" +
		"  </FUNCTIONAL>\n" +
		"  <MAPPING>\n" +
		"    <PROCMAP ProcRef=\"sys1_startup\" TaskRef=\"startup\"/>\n" +
		"    <PROCMAP ProcRef=\"sys2_startup\" TaskRef=\"startup\"/>\n" +
		"    <PROCMAP ProcRef=\"sys1_excepCam\" TaskRef=\"intCam\"/>\n" +
		"    <PROCMAP ProcRef=\"tg1_excepCam\" TaskRef=\"intCam\"/>\n" +
		"    <PROCMAP ProcRef=\"tg2_excepCam\" TaskRef=\"intCam\" OnceEveryK=\"3\"/>\n" +
		"    <PROCMAP ProcRef=\"tg3_excepCam\" TaskRef=\"intCam\"/>\n" +
		"    <PROCMAP ProcRef=\"sys1_excepFault\" TaskRef=\"intCam\"/>\n" +
		"    <PROCMAP ProcRef=\"sys1_excepTooth\" TaskRef=\"intCam\"/>\n" +
		"    <PROCMAP ProcRef=\"sys2_excepCam\" TaskRef=\"intCam\"/>\n" +
		"    <PROCMAP ProcRef=\"tg1_slowTime\" TaskRef=\"timeSlow\"/>\n" +
		"    <PROCMAP ProcRef=\"tg3_mediumTime\" TaskRef=\"timeMedium\"/>\n" +
		"    <PROCMAP ProcRef=\"tg2_mediumTime\" TaskRef=\"timeMedium\" OnceEveryK=\"5\"/>\n" +
		"    <PROCMAP ProcRef=\"sys1_fastTime\" TaskRef=\"timeFast\"/>\n" +
		"    <PROCMAP ProcRef=\"sys1_configSynch\" TaskRef=\"psmHigh\"/>\n" +
		"    <TASKMAP rtosRef=\"ecuRtos\" TaskRef=\"startup\"/>\n" +
		"    <TASKMAP rtosRef=\"ecuRtos\" TaskRef=\"intCam\"/>\n" +
		"    <TASKMAP rtosRef=\"ecuRtos\" TaskRef=\"timeSlow\"/>\n" +
		"    <TASKMAP rtosRef=\"ecuRtos\" TaskRef=\"timeMedium\"/>\n" +
		"    <TASKMAP rtosRef=\"ecuRtos\" TaskRef=\"timeFast\"/>\n" +
		"    <TASKMAP rtosRef=\"ecuRtos\" TaskRef=\"psmHigh\"/>\n" +
		"  </MAPPING>\n" +
		"  <ANNOTATION>\n" +
		"    <EXECTIME Ref=\"sys1_startup\" Type=\"PROC\">\n" +
		"      <WORST Value=\"20us\"/>\n" +
		"    </EXECTIME>\n" +
		"    <EXECTIME Ref=\"sys2_startup\" Type=\"PROC\">\n" +
		"      <WORST Value=\"25us\"/>\n" +
		"    </EXECTIME>\n" +
		"    <EXECTIME Ref=\"sys1_fastTime\" Type=\"PROC\">\n" +
		"      <WORST Value=\"45us\"/>\n" +
		"    </EXECTIME>\n" +
		"    <EXECTIME Ref=\"sys1_configSynch\" Type=\"PROC\">\n" +
		"      <WORST Value=\"15us\"/>\n" +
		"    </EXECTIME>\n" +
		"    <EXECTIME Ref=\"sys1_excepCam\" Type=\"PROC\">\n" +
		"      <WORST Value=\"12us\"/>\n" +
		"    </EXECTIME>\n" +
		"    <EXECTIME Ref=\"tg1_excepCam\" Type=\"PROC\">\n" +
		"      <WORST Value=\"15us\"/>\n" +
		"    </EXECTIME>\n" +
		"    <EXECTIME Ref=\"tg2_excepCam\" Type=\"PROC\">\n" +
		"      <WORST Value=\"13us\"/>\n" +
		"    </EXECTIME>\n" +
		"    <EXECTIME Ref=\"tg3_excepCam\" Type=\"PROC\">\n" +
		"      <WORST Value=\"7us\"/>\n" +
		"    </EXECTIME>\n" +
		"    <EXECTIME Ref=\"sys1_excepFault\" Type=\"PROC\">\n" +
		"      <WORST Value=\"12us\"/>\n" +
		"    </EXECTIME>\n" +
		"    <EXECTIME Ref=\"sys1_excepTooth\" Type=\"PROC\">\n" +
		"      <WORST Value=\"12us\"/>\n" +
		"    </EXECTIME>\n" +
		"    <EXECTIME Ref=\"sys2_excepCam\" Type=\"PROC\">\n" +
		"      <WORST Value=\"5us\"/>\n" +
		"    </EXECTIME>\n" +
		"    <EXECTIME Ref=\"tg3_mediumTime\" Type=\"PROC\">\n" +
		"      <WORST Value=\"40us\"/>\n" +
		"    </EXECTIME>\n" +
		"    <EXECTIME Ref=\"tg2_mediumTime\" Type=\"PROC\">\n" +
		"      <WORST Value=\"25us\"/>\n" +
		"    </EXECTIME>\n" +
		"    <EXECTIME Ref=\"tg1_slowTime\" Type=\"PROC\">\n" +
		"      <WORST Value=\"30us\"/>\n" +
		"    </EXECTIME>\n" +
		"  </ANNOTATION>\n" +
		"</SYSTEM>",
		
		// results
		"<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
		"<!DOCTYPE SYSTEM SYSTEM \"evidence_0.2.dtd\">" +
		"<SYSTEM xmlns:rtdruid.vartree.data=\"http://rtdruid.vartree.data\" Name=\"strano\">" +
		"<ARCHITECTURAL>" +
		"<ECU Name=\"ECU0\">" +
		"<CPU Name=\"CPU0\" Model=\"ARM7\">" +
		"<RTOS Name=\"CPU0.erika\"/>" +
		"</CPU>" +
		"</ECU>" +
		"<TASK Name=\"DeviceReader\" Type=\"task\">" +
//		"<SCHEDULING PreemptionGroupName=\"4\" Priority=\"4\"/>" +
		"<SCHEDULING Priority=\"4\"/>" +
		"<ACTIVATION Deadline=\"40.0ms\" Period=\"40.0ms\" Type=\"periodic\"/>" +
		"<RESOURCEREF>" +
		"<METHODREF Name=\"unused\" MethodName=\"Res8/read\"/>" +
		"</RESOURCEREF>" +
		"</TASK>" +
		"<TASK Name=\"QueueHandler\" Type=\"task\">" +
//		"<SCHEDULING PreemptionGroupName=\"3\" Priority=\"3\"/>" +
		"<SCHEDULING Priority=\"3\"/>" +
		"<ACTIVATION Deadline=\"45.0ms\" Period=\"45.0ms\" Type=\"periodic\"/>" +
		"<RESOURCEREF>" +
		"<METHODREF Name=\"unused\" MethodName=\"Res12/read\"/>" +
		"</RESOURCEREF>" +
		"</TASK>" +
		"<TASK Name=\"Writer\" Type=\"task\">" +
//		"<SCHEDULING PreemptionGroupName=\"2\" Priority=\"2\"/>" +
		"<SCHEDULING Priority=\"2\"/>" +
		"<ACTIVATION Deadline=\"45.0ms\" Period=\"45.0ms\" Type=\"periodic\"/>" +
		"<RESOURCEREF>" +
		"<METHODREF Name=\"unused\" MethodName=\"Res8/write\"/>" +
		"<METHODREF Name=\"unused\" MethodName=\"Res12/write\"/>" +
		"<METHODREF Name=\"unused\" MethodName=\"Res6/read\"/>" +
		"</RESOURCEREF>" +
		"</TASK>" +
		"<TASK Name=\"Driver\" Type=\"task\">" +
//		"<SCHEDULING PreemptionGroupName=\"1\" Priority=\"1\"/>" +
		"<SCHEDULING Priority=\"1\"/>" +
		"<ACTIVATION Deadline=\"100.0ms\" Period=\"100.0ms\" Type=\"periodic\"/>" +
		"<RESOURCEREF>" +
		"<METHODREF Name=\"unused\" MethodName=\"Res6/write\"/>" +
		"</RESOURCEREF>" +
		"</TASK>" +
		"<RESOURCE Name=\"Res2\">" +
		"<MUTEXREF MutexName=\"Mutex2\"/>" +
		"</RESOURCE>" +
		"<RESOURCE Name=\"Res6\">" +
		"<MUTEXREF MutexName=\"Mutex6\"/>" +
		"</RESOURCE>" +
		"<RESOURCE Name=\"Res6b\">" +
		"<MUTEXREF MutexName=\"Mutex6b\"/>" +
		"</RESOURCE>" +
		"<RESOURCE Name=\"Res8\">" +
		"<MUTEXREF MutexName=\"Mutex8\"/>" +
		"</RESOURCE>" +
		"<RESOURCE Name=\"Res12\">" +
		"<MUTEXREF MutexName=\"Mutex12\"/>" +
		"</RESOURCE>" +
		"<MUTEX Name=\"Mutex1\"/>" +
		"<MUTEX Name=\"Mutex2\"/>" +
		"<MUTEX Name=\"Mutex6\"/>" +
		"<MUTEX Name=\"Mutex6b\"/>" +
		"<MUTEX Name=\"Mutex8\"/>" +
		"<MUTEX Name=\"Mutex12\"/>" +
		"</ARCHITECTURAL>" +
		"<MAPPING>" +
		"<TASKMAP rtosRef=\"CPU0.erika\" TaskRef=\"DeviceReader\"/>" +
		"<TASKMAP rtosRef=\"CPU0.erika\" TaskRef=\"QueueHandler\"/>" +
		"<TASKMAP rtosRef=\"CPU0.erika\" TaskRef=\"Writer\"/>" +
		"<TASKMAP rtosRef=\"CPU0.erika\" TaskRef=\"Driver\"/>" +
		"</MAPPING>" +
		"<ANNOTATION>" +
		"<EXECTIME Type=\"TASK\" Ref=\"DeviceReader\">" +
		"<WORST Value=\"13.0ms\"/>" +
		"</EXECTIME>" +
		"<EXECTIME Type=\"TASK\" Ref=\"QueueHandler\">" +
		"<WORST Value=\"6.0ms\"/>" +
		"</EXECTIME>" +
		"<EXECTIME Type=\"TASK\" Ref=\"Writer\">" +
		"<WORST Value=\"12.0ms\"/>" +
		"</EXECTIME>" +
		"<EXECTIME Type=\"TASK\" Ref=\"Driver\">" +
		"<WORST Value=\"21.0ms\"/>" +
		"</EXECTIME>" +
		"<EXECTIME Type=\"RESOURCE_METHOD\" Ref=\"Res6/write\">" +
		"<WORST Value=\"6.0ms\"/>" +
		"</EXECTIME>" +
		"<EXECTIME Type=\"RESOURCE_METHOD\" Ref=\"Res6/read\">" +
		"<WORST Value=\"1.0ms\"/>" +
		"</EXECTIME>" +
		"<EXECTIME Type=\"RESOURCE_METHOD\" Ref=\"Res6b/read\">" +
		"<WORST Value=\"1.0ms\"/>" +
		"</EXECTIME>" +
		"<EXECTIME Type=\"RESOURCE_METHOD\" Ref=\"Res6b/write\">" +
		"<WORST Value=\"6.0ms\"/>" +
		"</EXECTIME>" +
		"<EXECTIME Type=\"RESOURCE_METHOD\" Ref=\"Res2/read\">" +
		"<WORST Value=\"1.0ms\"/>" +
		"</EXECTIME>" +
		"<EXECTIME Type=\"RESOURCE_METHOD\" Ref=\"Res2/write\">" +
		"<WORST Value=\"2.0ms\"/>" +
		"</EXECTIME>" +
		"<EXECTIME Type=\"RESOURCE_METHOD\" Ref=\"Res12/read\">" +
		"<WORST Value=\"1.0ms\"/>" +
		"</EXECTIME>" +
		"<EXECTIME Type=\"RESOURCE_METHOD\" Ref=\"Res12/write\">" +
		"<WORST Value=\"12.0ms\"/>" +
		"</EXECTIME>" +
		"<EXECTIME Type=\"RESOURCE_METHOD\" Ref=\"Res8/read\">" +
		"<WORST Value=\"1.0ms\"/>" +
		"</EXECTIME>" +
		"<EXECTIME Type=\"RESOURCE_METHOD\" Ref=\"Res8/write\">" +
		"<WORST Value=\"8.0ms\"/>" +
		"</EXECTIME>" +
		"</ANNOTATION>" +
		"<SCHEDULABILITY>" +
		"<SCHEDULINGSCENARIO>" +
		"<CPUSCHED CpuRef=\"CPU0.erika\" Utilization=\"0.935\" SpeedFactor=\"1.0375\" Boundary=\"0.7568284600108841\" Schedulable=\"false\"/>" +
		"<TASKSCHED TaskRef=\"DeviceReader\" Utilization=\"0.325\" CDelta=\"-1.5\" Schedulable=\"true\" ResponseTime=\"21.0ms\"/>" +
		"<TASKSCHED TaskRef=\"QueueHandler\" Utilization=\"0.13333333333333333\" CDelta=\"-1.5\" Schedulable=\"true\" ResponseTime=\"31.0ms\"/>" +
		"<TASKSCHED TaskRef=\"Writer\" Utilization=\"0.26666666666666666\" CDelta=\"-1.5\" Schedulable=\"true\" ResponseTime=\"37.0ms\"/>" +
		"<TASKSCHED TaskRef=\"Driver\" Utilization=\"0.21\" CDelta=\"-3.0\" Schedulable=\"false\" ResponseTime=\"114.0ms\"/>" +
		"</SCHEDULINGSCENARIO>" +
		"</SCHEDULABILITY>" +
		"</SYSTEM>"
	};



	public final static String[] example2 = {
		// input
		"<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n" +
		"<!DOCTYPE SYSTEM SYSTEM \"evidence_0.4.dtd\">" +
		"<SYSTEM Name=\"Test\">\n" +
		"  <ARCHITECTURAL>\n" +
		"    <ECU Name=\"ecu\">\n" +
		"      <CPU Name=\"ecuCpu\">\n" +
		"        <RTOS Name=\"ecuRtos\"/>\n" +
		"      </CPU>\n" +
		"    </ECU>\n" +
		"    <TASK Name=\"t1\" Type=\"task\">\n" +
		"      <SCHEDULING Priority=\"10\"/>\n" +
		"      <ACTIVATION Deadline=\"3ms\" Period=\"3ms\" Type=\"sporadic\"/>\n" +
		"    </TASK>\n" +
		"    <TASK Name=\"t2\" Type=\"task\">\n" +
		"      <SCHEDULING Priority=\"5\"/>\n" +
		"      <ACTIVATION Deadline=\"7ms\" Period=\"7ms\" Type=\"sporadic\"/>\n" +
		"    </TASK>\n" +
		"  </ARCHITECTURAL>\n" +
		"  <FUNCTIONAL>\n" +
		"    <PROC Name=\"p1_a\"/>\n" +
		"    <PROC Name=\"p1_b\"/>\n" +
		"    <PROC Name=\"p2\"/>\n" +
		"  </FUNCTIONAL>\n" +
		"  <MAPPING>\n" +
		"    <PROCMAP ProcRef=\"p1_a\" TaskRef=\"t1\" />\n" +
		"    <PROCMAP ProcRef=\"p1_b\" TaskRef=\"t1\" OnceEveryK=\"2\"/>\n" +
		"    <PROCMAP ProcRef=\"p2\" TaskRef=\"t2\"/>\n" +
		"    <TASKMAP rtosRef=\"ecuRtos\" TaskRef=\"t1\"/>\n" +
		"    <TASKMAP rtosRef=\"ecuRtos\" TaskRef=\"t2\"/>\n" +
		"  </MAPPING>\n" +
		"  <ANNOTATION>\n" +
		"    <EXECTIME Ref=\"p1_a\" Type=\"PROC\">\n" +
		"      <WORST Value=\"1ms\"/>\n" +
		"    </EXECTIME>\n" +
		"    <EXECTIME Ref=\"p1_b\" Type=\"PROC\">\n" +
		"      <WORST Value=\"1ms\"/>\n" +
		"    </EXECTIME>\n" +
		"    <EXECTIME Ref=\"p2\" Type=\"PROC\">\n" +
		"      <WORST Value=\"3ms\"/>\n" +
		"    </EXECTIME>\n" +
		"  </ANNOTATION>\n" +
		"</SYSTEM>",
		
		// results
		""	};

	public final static String[] example3 = {
		// input
		"<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n" +
		"<!DOCTYPE SYSTEM SYSTEM \"evidence_0.4.dtd\">" +
		"<SYSTEM Name=\"Test\">\n" +
		"  <ARCHITECTURAL>\n" +
		"    <ECU Name=\"ecu\">\n" +
		"      <CPU Name=\"ecuCpu\">\n" +
		"        <RTOS Name=\"ecuRtos\"/>\n" +
		"      </CPU>\n" +
		"    </ECU>\n" +
		"    <TASK Name=\"t1\" Type=\"task\">\n" +
		"      <SCHEDULING Priority=\"10\"/>\n" +
		"      <ACTIVATION Deadline=\"3ms\" Period=\"3ms\" Type=\"sporadic\"/>\n" +
		"    </TASK>\n" +
		"    <TASK Name=\"t2\" Type=\"task\">\n" +
		"      <SCHEDULING Priority=\"5\"/>\n" +
		"      <ACTIVATION Deadline=\"7ms\" Period=\"7ms\" Type=\"sporadic\"/>\n" +
		"    </TASK>\n" +
		"  </ARCHITECTURAL>\n" +
		"  <MAPPING>\n" +
		"    <TASKMAP rtosRef=\"ecuRtos\" TaskRef=\"t1\"/>\n" +
		"    <TASKMAP rtosRef=\"ecuRtos\" TaskRef=\"t2\"/>\n" +
		"  </MAPPING>\n" +
		"  <ANNOTATION>\n" +
		"    <EXECTIME Ref=\"t1\" Type=\"TASK\">\n" +
		"      <WORST Value=\"1ms\"/>\n" +
		"    </EXECTIME>\n" +
		"    <EXECTIME Ref=\"t2\" Type=\"TASK\">\n" +
		"      <WORST Value=\"2ms\"/>\n" +
		"    </EXECTIME>\n" +
		"  </ANNOTATION>\n" +
		"</SYSTEM>",
		
		// results
		""	};


	public void testPrepareData() throws IOException {
		IVarTree vt =Vt2StringUtilities.loadString(example1[0]);
		
//		System.out.println(Utility.varTreeToStringRtd(vt));
		
		MultiFrameTaskSchedulability test = (new JScanImplTest()).prepareMultiFrameTest(vt, Search.systemName(vt), null);

		int[][] every = new int[][] {
				{1,1},
				{1,1,3,1,1,1,1},
				{1},
				{1,5},
				{1},
				{1}
		};

		
		TaskSet tset = test.getTaskSet();
		for (int cpuId = 0; cpuId < tset.getPrefixNumber(); cpuId ++) {
		      for (int i=0; i<tset.getSize(cpuId); ++i) {
		          GenRes t = tset.getItem(cpuId,i);
		          assertTrue(t.existProperty(Task.STR_PROC_LIST));
		          Object proc_list = t.getProperty(Task.STR_PROC_LIST);
		          assertTrue(proc_list instanceof ArrayList);
		
		          assertTrue(t.existProperty(Task.STR_GENERIC_WCET));
		          Object gen_wcet = t.getProperty(Task.STR_GENERIC_WCET);
		          assertTrue(gen_wcet instanceof IGeneralMultiframeTaskWcet);		          

		          System.out.println("Task : " + t.getName());
		          System.out.println("\tplist : " + proc_list);
		          System.out.println("\tgenwcet : " + gen_wcet);

		          {
			          ArrayList<Task.ProcData>  plist = (ArrayList<Task.ProcData>)proc_list;
			          assertEquals(plist.size() , every[i].length);
			          for (int k=0; k<plist.size(); k++) {
			        	  assertEquals(every[i][k] , plist.get(k).getOnceEveryK());
			          }
		          }
		          
		      }
		}

	}

	
	public void test1() throws IOException {
		IVarTree vt =Vt2StringUtilities.loadString(example1[0]);
		
		String system = (vt.newTreeInterface()).getAllName(null, "System")[0];

		
		String report = JScan.startTest(vt, system, JScan.MULTIFRAME_FP_ID, null);
		String report2 = JScan.startTest(vt, system, JScan.NO_OFFSET_ID, null);
		
		vt.newTreeInterface().setValue(system+IVarTree.SEPARATOR
				+"Schedulability"+IVarTree.SEPARATOR
				+"SchedulingScenarioList"+IVarTree.SEPARATOR
				+DataPath.makeSlashedId((String)null)+IVarTree.SEPARATOR
				+"Reports"+IVarTree.SEPARATOR
				, (IVariable) null);
		
		System.out.println(report + "\n" + report2 + 
				Vt2StringUtilities.varTreeToStringRtd(vt)
				);
		
		//check(vt, Utility.loadString(example1[1]));
	}

	public void testPrepareData2() throws IOException {
		IVarTree vt =Vt2StringUtilities.loadString(example2[0]);
		
//		System.out.println(Utility.varTreeToStringRtd(vt));
		
		MultiFrameTaskSchedulability test = (new JScanImplTest()).prepareMultiFrameTest(vt, Search.systemName(vt), null);

		int[][] every = new int[][] {
				{1,2},
				{1}
		};

		
		int[][] wcets = new int[][] {
				{2,1,2,1,2,1,2,1},
				{3,3,3,3,3,3,3,3}
		};

		
		TaskSet tset = test.getTaskSet();
		for (int cpuId = 0; cpuId < tset.getPrefixNumber(); cpuId ++) {
		      for (int i=0; i<tset.getSize(cpuId); ++i) {
		          GenRes t = tset.getItem(cpuId,i);
		          assertTrue(t.existProperty(Task.STR_PROC_LIST));
		          Object proc_list = t.getProperty(Task.STR_PROC_LIST);
		          assertTrue(proc_list instanceof ArrayList);
		
		          assertTrue(t.existProperty(Task.STR_GENERIC_WCET));
		          Object gen_wcet = t.getProperty(Task.STR_GENERIC_WCET);
		          assertTrue(gen_wcet instanceof IGeneralMultiframeTaskWcet);		          

		          System.out.println("Task : " + t.getName());
		          System.out.println("\tplist : " + proc_list);
		          System.out.println("\tgenwcet : " + gen_wcet);

		          {
			          ArrayList<Task.ProcData>  plist = (ArrayList<Task.ProcData>)proc_list;
			          assertEquals(plist.size() , every[i].length);
			          for (int k=0; k<plist.size(); k++) {
			        	  assertEquals(every[i][k] , plist.get(k).getOnceEveryK());
			          }
		          }
		          
		          {
		        	  IGeneralMultiframeTaskWcet gwcet = (IGeneralMultiframeTaskWcet) gen_wcet;
		        	  double tot = 0;
		        	  for (int k=0; k<wcets[i].length; k++) {
		        		  System.out.println(".. k " + k + " " + wcets[i][k] + " -> " + gwcet.getWcet(k+1) + "(" + gwcet.getCumulativeWcet(k+1) + ")");
		        		  assertEquals(wcets[i][k] , gwcet.getWcet(k+1));
		        		  tot += wcets[i][k];

		        		  assertEquals(tot , gwcet.getCumulativeWcet(k+1));
		        	  }
		          }
		          
		          
		      }
		}

	}

	public void test2() throws IOException {
		IVarTree vt =Vt2StringUtilities.loadString(example2[0]);
		
		String system = (vt.newTreeInterface()).getAllName(null, "System")[0];

		
		Properties options = new Properties();
		
		{
			options.put("abc", new Double(2));
			//boolean valida = options.contains("abc");
			boolean valida2 = options.containsKey("abc");
			assertTrue(valida2);
			Object o1 =options.get("abc2");
			System.out.println(o1);
	
			options.setProperty("abc2", "2..");
			//boolean valid = options.contains("abc2");
			boolean valid2 = options.containsKey("abc2");
			assertTrue(valid2);
			Object o2 =options.get("abc2");
			System.out.println(o2);
		}

		options.setProperty(JScanImpl.EXPORT_SCHEDULING_DATA, "true");

		String rep = JScan.startTest(vt, system, JScan.MULTIFRAME_FP_ID, options);
		
		vt.newTreeInterface().setValue(system+IVarTree.SEPARATOR
				+"Schedulability"+IVarTree.SEPARATOR
				+"SchedulingScenarioList"+IVarTree.SEPARATOR
				+DataPath.makeSlashedId((String)null)+IVarTree.SEPARATOR
				+"Reports"+IVarTree.SEPARATOR
				, (IVariable) null);
		
		System.out.println("___\n" + rep + "\n\n" + Vt2StringUtilities.varTreeToStringRtd(vt));
		
		
		
		// internal check
		
		int[][] every = new int[][] {
				{1,2},
				{1}
		};
		double response[] = new double[] {2,6};
		assertTrue(options.containsKey(JScanImpl.EXPORT_SCHEDULING_DATA));
		assertTrue(options.get(JScanImpl.EXPORT_SCHEDULING_DATA) instanceof ArrayList);
		
		ArrayList<Schedulability> schedulers = (ArrayList<Schedulability>) options.get(JScanImpl.EXPORT_SCHEDULING_DATA);
		assertEquals(schedulers.size() , 1);
		Schedulability sched = schedulers.get(0);
		assertTrue(sched instanceof MultiFrameTaskSchedulability);
		
		TaskSet tset = sched.getTaskSet();
		for (int cpuId = 0; cpuId < tset.getPrefixNumber(); cpuId ++) {
		      for (int i=0; i<tset.getSize(cpuId); ++i) {
		          GenRes t = tset.getItem(cpuId,i);
		          assertTrue(t.existProperty(Task.STR_PROC_LIST));
		          Object proc_list = t.getProperty(Task.STR_PROC_LIST);
		          assertTrue(proc_list instanceof ArrayList);
		
		          assertTrue(t.existProperty(Task.STR_GENERIC_WCET));
		          Object gen_wcet = t.getProperty(Task.STR_GENERIC_WCET);
		          assertTrue(gen_wcet instanceof IGeneralMultiframeTaskWcet);		          

		          System.out.println("Task : " + t.getName());
		          System.out.println("\tplist : " + proc_list);
		          System.out.println("\tgenwcet : " + gen_wcet);

		         {
			          ArrayList<Task.ProcData>  plist = (ArrayList<Task.ProcData>)proc_list;
			          assertEquals(plist.size() , every[i].length);
			          for (int k=0; k<plist.size(); k++) {
			        	  assertEquals(every[i][k] , plist.get(k).getOnceEveryK());
			          }
		          }
		          
		          assertTrue(("" + response[i]).equals(t.getProperty(Task.STR_RESPONSE_TIME)));
		      }
		}

		

		//check(vt, Utility.loadString(example1[1]));
	}


	public void test3() throws IOException {
		IVarTree vt =Vt2StringUtilities.loadString(example3[0]);
		
		String system = (vt.newTreeInterface()).getAllName(null, "System")[0];

		
		Properties options = new Properties();
		options.setProperty(JScanImpl.EXPORT_SCHEDULING_DATA, "true");

		String rep = JScan.startTest(vt, system, JScan.MULTIFRAME_FP_ID, options);
		
		vt.newTreeInterface().setValue(system+IVarTree.SEPARATOR
				+"Schedulability"+IVarTree.SEPARATOR
				+"SchedulingScenarioList"+IVarTree.SEPARATOR
				+DataPath.makeSlashedId((String)null)+IVarTree.SEPARATOR
				+"Reports"+IVarTree.SEPARATOR
				, (IVariable) null);
		
		System.out.println(rep + "\n\n" + Vt2StringUtilities.varTreeToStringRtd(vt));
		
		
		
		// internal check
		double response[] = new double[] {1,3};
		assertTrue(options.containsKey(JScanImpl.EXPORT_SCHEDULING_DATA));
		assertTrue(options.get(JScanImpl.EXPORT_SCHEDULING_DATA) instanceof ArrayList);
		
		@SuppressWarnings("unchecked")
		ArrayList<Schedulability> schedulers = (ArrayList<Schedulability>) options.get(JScanImpl.EXPORT_SCHEDULING_DATA);
		assertEquals(schedulers.size() , 1);
		Schedulability sched = schedulers.get(0);
		assertTrue(sched instanceof MultiFrameTaskSchedulability);
		
		TaskSet tset = sched.getTaskSet();
		for (int cpuId = 0; cpuId < tset.getPrefixNumber(); cpuId ++) {
		      for (int i=0; i<tset.getSize(cpuId); ++i) {
		          GenRes t = tset.getItem(cpuId,i);
		          assertTrue(t.existProperty(Task.STR_PROC_LIST));
		          Object proc_list = t.getProperty(Task.STR_PROC_LIST);
		          assertTrue(proc_list instanceof ArrayList);
		
		          assertTrue(t.existProperty(Task.STR_GENERIC_WCET));
		          Object gen_wcet = t.getProperty(Task.STR_GENERIC_WCET);
		          assertTrue(gen_wcet instanceof IGeneralMultiframeTaskWcet);		          

		          System.out.println("Task data : " + t);

		         {
			          ArrayList<Task.ProcData>  plist = (ArrayList<Task.ProcData>)proc_list;
			          assertEquals(plist.size() , 0);
			          
		          }
		          
		          assertTrue(("" + response[i]).equals(t.getProperty(Task.STR_RESPONSE_TIME)));
		      }
		}

		

		//check(vt, Utility.loadString(example1[1]));
	}

}

