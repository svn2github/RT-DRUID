/*
 * Created on Jul 12, 2004
 *
 * $ID$
 */
package com.eu.evidence.rtdruid.test.modules.jscan.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.junit.Test;

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

	private static final boolean ENABLE_DEBUG = true;
	
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
		"      <BOUND Type=\"mit\" Value=\"15ms\"/>\n" +
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
		"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE SYSTEM SYSTEM \"evidence_0.4.dtd\">\n" +
		"<SYSTEM xmlns:com.eu.evidence.rtdruid.data=\"http://www.evidence.eu.com/rtdruid/data\" Name=\"Test\">\n" +
		"<FUNCTIONAL>\n" +
		"<EVENT Name=\"sys1_startup.act\" Type=\"activation\" MethodRefName=\"AcceptKeyOnEvent/sys1_startup.trigger\"/>\n" +
		"<EVENT Name=\"sys2_startup.act\" Type=\"activation\" MethodRefName=\"AcceptKeyOnEvent/sys2_startup.trigger\"/>\n" +
		"<EVENT Name=\"sys1_startup.begin\" Type=\"begin\" MethodRefName=\"AcceptKeyOnEvent/sys1_startup.trigger\"/>\n" +
		"<EVENT Name=\"sys2_startup.begin\" Type=\"begin\" MethodRefName=\"AcceptKeyOnEvent/sys2_startup.trigger\"/>\n" +
		"<EVENT Name=\"sys1_startup.end\" Type=\"end\" MethodRefName=\"AcceptKeyOnEvent/sys1_startup.trigger\"/>\n" +
		"<EVENT Name=\"sys2_startup.end\" Type=\"end\" MethodRefName=\"AcceptKeyOnEvent/sys2_startup.trigger\"/>\n" +
		"<EVENT Name=\"sys1_fastTime.act\" Type=\"activation\" MethodRefName=\"AcceptEventTimeFast/sys1_fastTime.trigger\"/>\n" +
		"<EVENT Name=\"sys1_fastTime.begin\" Type=\"begin\" MethodRefName=\"AcceptEventTimeFast/sys1_fastTime.trigger\"/>\n" +
		"<EVENT Name=\"sys1_fastTime.end\" Type=\"end\" MethodRefName=\"AcceptEventTimeFast/sys1_fastTime.trigger\"/>\n" +
		"<EVENT Name=\"sys1_configSynch.act\" Type=\"activation\" MethodRefName=\"AcceptEventPsmHigh/sys1_configSynch.trigger\"/>\n" +
		"<EVENT Name=\"sys1_configSynch.begin\" Type=\"begin\" MethodRefName=\"AcceptEventPsmHigh/sys1_configSynch.trigger\"/>\n" +
		"<EVENT Name=\"sys1_configSynch.end\" Type=\"end\" MethodRefName=\"AcceptEventPsmHigh/sys1_configSynch.trigger\"/>\n" +
		"<EVENT Name=\"sys1_excepCam.act\" Type=\"activation\" MethodRefName=\"AcceptEventIntCam/sys1_excepCam.trigger\"/>\n" +
		"<EVENT Name=\"tg1_excepCam.act\" Type=\"activation\" MethodRefName=\"AcceptEventIntCam/tg1_excepCam.trigger\"/>\n" +
		"<EVENT Name=\"tg2_excepCam.act\" Type=\"activation\" MethodRefName=\"AcceptEventIntCam/tg2_excepCam.trigger\"/>\n" +
		"<EVENT Name=\"tg3_excepCam.act\" Type=\"activation\" MethodRefName=\"AcceptEventIntCam/tg3_excepCam.trigger\"/>\n" +
		"<EVENT Name=\"sys2_excepCam.act\" Type=\"activation\" MethodRefName=\"AcceptEventIntCam/sys2_excepCam.trigger\"/>\n" +
		"<EVENT Name=\"sys1_excepFault.begin\" Type=\"begin\" MethodRefName=\"sys1_excepCam/sys1_excepFault.run\"/>\n" +
		"<EVENT Name=\"sys1_excepTooth.begin\" Type=\"begin\" MethodRefName=\"sys1_excepFault/sys1_excepTooth.run\"/>\n" +
		"<EVENT Name=\"sys1_excepCam.begin\" Type=\"begin\" MethodRefName=\"AcceptEventIntCam/sys1_excepCam.trigger\"/>\n" +
		"<EVENT Name=\"tg1_excepCam.begin\" Type=\"begin\" MethodRefName=\"AcceptEventIntCam/tg1_excepCam.trigger\"/>\n" +
		"<EVENT Name=\"tg2_excepCam.begin\" Type=\"begin\" MethodRefName=\"AcceptEventIntCam/tg2_excepCam.trigger\"/>\n" +
		"<EVENT Name=\"tg3_excepCam.begin\" Type=\"begin\" MethodRefName=\"AcceptEventIntCam/tg3_excepCam.trigger\"/>\n" +
		"<EVENT Name=\"sys2_excepCam.begin\" Type=\"begin\" MethodRefName=\"AcceptEventIntCam/sys2_excepCam.trigger\"/>\n" +
		"<EVENT Name=\"sys1_excepFault.end\" Type=\"end\" MethodRefName=\"sys1_excepCam/sys1_excepFault.run\"/>\n" +
		"<EVENT Name=\"sys1_excepTooth.end\" Type=\"end\" MethodRefName=\"sys1_excepFault/sys1_excepTooth.run\"/>\n" +
		"<EVENT Name=\"sys1_excepCam.end\" Type=\"end\" MethodRefName=\"AcceptEventIntCam/sys1_excepCam.trigger\"/>\n" +
		"<EVENT Name=\"tg1_excepCam.end\" Type=\"end\" MethodRefName=\"AcceptEventIntCam/tg1_excepCam.trigger\"/>\n" +
		"<EVENT Name=\"tg2_excepCam.end\" Type=\"end\" MethodRefName=\"AcceptEventIntCam/tg2_excepCam.trigger\"/>\n" +
		"<EVENT Name=\"tg3_excepCam.end\" Type=\"end\" MethodRefName=\"AcceptEventIntCam/tg3_excepCam.trigger\"/>\n" +
		"<EVENT Name=\"sys2_excepCam.end\" Type=\"end\" MethodRefName=\"AcceptEventIntCam/sys2_excepCam.trigger\"/>\n" +
		"<EVENT Name=\"tg3_mediumTime.act\" Type=\"activation\" MethodRefName=\"AcceptEventTimeMedium/tg3_mediumTime.trigger\"/>\n" +
		"<EVENT Name=\"tg2_mediumTime.act\" Type=\"activation\" MethodRefName=\"AcceptEventTimeMedium/tg2_mediumTime.trigger\"/>\n" +
		"<EVENT Name=\"tg3_mediumTime.begin\" Type=\"begin\" MethodRefName=\"AcceptEventTimeMedium/tg3_mediumTime.trigger\"/>\n" +
		"<EVENT Name=\"tg2_mediumTime.begin\" Type=\"begin\" MethodRefName=\"AcceptEventTimeMedium/tg2_mediumTime.trigger\"/>\n" +
		"<EVENT Name=\"tg3_mediumTime.end\" Type=\"end\" MethodRefName=\"AcceptEventTimeMedium/tg3_mediumTime.trigger\"/>\n" +
		"<EVENT Name=\"tg2_mediumTime.end\" Type=\"end\" MethodRefName=\"AcceptEventTimeMedium/tg2_mediumTime.trigger\"/>\n" +
		"<EVENT Name=\"tg1_slowTime.act\" Type=\"activation\" MethodRefName=\"AcceptEventTimeSlow/tg1_slowTime.trigger\"/>\n" +
		"<EVENT Name=\"tg1_slowTime.begin\" Type=\"begin\" MethodRefName=\"AcceptEventTimeSlow/tg1_slowTime.trigger\"/>\n" +
		"<EVENT Name=\"tg1_slowTime.end\" Type=\"end\" MethodRefName=\"AcceptEventTimeSlow/tg1_slowTime.trigger\"/>\n" +
		"<PARTIALORDER>\n" +
		"<ORDER>\n" +
		"<EVENTREF Name=\"sys1_excepCam.end\"/>\n" +
		"<EVENTREF Name=\"sys1_excepFault.begin\"/>\n" +
		"</ORDER>\n" +
		"<ORDER>\n" +
		"<EVENTREF Name=\"sys1_excepFault.end\"/>\n" +
		"<EVENTREF Name=\"sys1_excepTooth.begin\"/>\n" +
		"</ORDER>\n" +
		"</PARTIALORDER>\n" +
		"<PROC Name=\"sys1_startup\">\n" +
		"<METHOD Name=\"run\"/>\n" +
		"</PROC>\n" +
		"<PROC Name=\"sys2_startup\">\n" +
		"<METHOD Name=\"run\"/>\n" +
		"</PROC>\n" +
		"<PROC Name=\"sys1_fastTime\">\n" +
		"<METHOD Name=\"run\"/>\n" +
		"</PROC>\n" +
		"<PROC Name=\"sys1_configSynch\">\n" +
		"<METHOD Name=\"run\"/>\n" +
		"</PROC>\n" +
		"<PROC Name=\"sys1_excepCam\">\n" +
		"<METHOD Name=\"run\"/>\n" +
		"<METHODREF Name=\"sys1_excepFault.run\" MethodName=\"sys1_excepFault/run\"/>\n" +
		"</PROC>\n" +
		"<PROC Name=\"tg1_excepCam\">\n" +
		"<METHOD Name=\"run\"/>\n" +
		"</PROC>\n" +
		"<PROC Name=\"tg2_excepCam\">\n" +
		"<METHOD Name=\"run\"/>\n" +
		"</PROC>\n" +
		"<PROC Name=\"tg3_excepCam\">\n" +
		"<METHOD Name=\"run\"/>\n" +
		"</PROC>\n" +
		"<PROC Name=\"sys1_excepFault\">\n" +
		"<METHOD Name=\"run\"/>\n" +
		"<METHODREF Name=\"sys1_excepTooth.run\" MethodName=\"sys1_excepTooth/run\"/>\n" +
		"</PROC>\n" +
		"<PROC Name=\"sys1_excepTooth\">\n" +
		"<METHOD Name=\"run\"/>\n" +
		"</PROC>\n" +
		"<PROC Name=\"sys2_excepCam\">\n" +
		"<METHOD Name=\"run\"/>\n" +
		"</PROC>\n" +
		"<PROC Name=\"tg3_mediumTime\">\n" +
		"<METHOD Name=\"run\"/>\n" +
		"</PROC>\n" +
		"<PROC Name=\"tg2_mediumTime\">\n" +
		"<METHOD Name=\"run\"/>\n" +
		"</PROC>\n" +
		"<PROC Name=\"tg1_slowTime\">\n" +
		"<METHOD Name=\"run\"/>\n" +
		"</PROC>\n" +
		"<TRIGGER Name=\"AcceptKeyOnEvent\">\n" +
		"<METHODREF Name=\"sys1_startup.trigger\" MethodName=\"sys1_startup/run\"/>\n" +
		"<METHODREF Name=\"sys2_startup.trigger\" MethodName=\"sys2_startup/run\"/>\n" +
		"</TRIGGER>\n" +
		"<TRIGGER Name=\"AcceptEventTimeFast\">\n" +
		"<METHODREF Name=\"sys1_fastTime.trigger\" MethodName=\"sys1_fastTime/run\"/>\n" +
		"</TRIGGER>\n" +
		"<TRIGGER Name=\"AcceptEventPsmHigh\">\n" +
		"<METHODREF Name=\"sys1_configSynch.trigger\" MethodName=\"sys1_configSynch/run\"/>\n" +
		"</TRIGGER>\n" +
		"<TRIGGER Name=\"AcceptEventIntCam\">\n" +
		"<METHODREF Name=\"sys1_excepCam.trigger\" MethodName=\"sys1_excepCam/run\"/>\n" +
		"<METHODREF Name=\"tg1_excepCam.trigger\" MethodName=\"tg1_excepCam/run\"/>\n" +
		"<METHODREF Name=\"tg2_excepCam.trigger\" MethodName=\"tg2_excepCam/run\"/>\n" +
		"<METHODREF Name=\"tg3_excepCam.trigger\" MethodName=\"tg3_excepCam/run\"/>\n" +
		"<METHODREF Name=\"sys2_excepCam.trigger\" MethodName=\"sys2_excepCam/run\"/>\n" +
		"</TRIGGER>\n" +
		"<TRIGGER Name=\"AcceptEventTimeMedium\">\n" +
		"<METHODREF Name=\"tg3_mediumTime.trigger\" MethodName=\"tg3_mediumTime/run\"/>\n" +
		"<METHODREF Name=\"tg2_mediumTime.trigger\" MethodName=\"tg2_mediumTime/run\"/>\n" +
		"</TRIGGER>\n" +
		"<TRIGGER Name=\"AcceptEventTimeSlow\">\n" +
		"<METHODREF Name=\"tg1_slowTime.trigger\" MethodName=\"tg1_slowTime/run\"/>\n" +
		"</TRIGGER>\n" +
		"<TIMECONST>\n" +
		"<EVENTREF Name=\"sys1_startup.act\"/>\n" +
		"<BOUND Type=\"mit\" Value=\"1000.0ms\"/>\n" +
		"</TIMECONST>\n" +
		"<TIMECONST>\n" +
		"<EVENTREF Name=\"sys2_startup.act\"/>\n" +
		"<BOUND Type=\"mit\" Value=\"1000.0ms\"/>\n" +
		"</TIMECONST>\n" +
		"<TIMECONST>\n" +
		"<EVENTREF Name=\"sys1_fastTime.act\"/>\n" +
		"<BOUND Type=\"period\" Value=\"4.0ms\"/>\n" +
		"</TIMECONST>\n" +
		"<TIMECONST>\n" +
		"<EVENTREF Name=\"sys1_configSynch.act\"/>\n" +
		"<BOUND Type=\"mit\" Value=\"5.0ms\"/>\n" +
		"</TIMECONST>\n" +
		"<TIMECONST>\n" +
		"<EVENTREF Name=\"sys1_excepCam.act\"/>\n" +
		"<BOUND Type=\"mit\" Value=\"5.0ms\"/>\n" +
		"</TIMECONST>\n" +
		"<TIMECONST>\n" +
		"<EVENTREF Name=\"tg1_excepCam.act\"/>\n" +
		"<BOUND Type=\"mit\" Value=\"5.0ms\"/>\n" +
		"</TIMECONST>\n" +
		"<TIMECONST>\n" +
		"<EVENTREF Name=\"tg2_excepCam.act\"/>\n" +
		"<BOUND Type=\"mit\" Value=\"15.0ms\"/>\n" +
		"</TIMECONST>\n" +
		"<TIMECONST>\n" +
		"<EVENTREF Name=\"tg3_excepCam.act\"/>\n" +
		"<BOUND Type=\"mit\" Value=\"5.0ms\"/>\n" +
		"</TIMECONST>\n" +
		"<TIMECONST>\n" +
		"<EVENTREF Name=\"sys2_excepCam.act\"/>\n" +
		"<BOUND Type=\"mit\" Value=\"5.0ms\"/>\n" +
		"</TIMECONST>\n" +
		"<TIMECONST>\n" +
		"<EVENTREF Name=\"tg3_mediumTime.act\"/>\n" +
		"<BOUND Type=\"period\" Value=\"12.0ms\"/>\n" +
		"</TIMECONST>\n" +
		"<TIMECONST>\n" +
		"<EVENTREF Name=\"tg2_mediumTime.act\"/>\n" +
		"<BOUND Type=\"period\" Value=\"12.0ms\"/>\n" +
		"</TIMECONST>\n" +
		"<TIMECONST>\n" +
		"<EVENTREF Name=\"tg1_slowTime.act\"/>\n" +
		"<BOUND Type=\"period\" Value=\"100.0ms\"/>\n" +
		"</TIMECONST>\n" +
		"</FUNCTIONAL>\n" +
		"<ARCHITECTURAL>\n" +
		"<ECU Name=\"ecu\">\n" +
		"<CPU Name=\"ecuCpu\">\n" +
		"<RTOS Name=\"ecuRtos\"/>\n" +
		"</CPU>\n" +
		"</ECU>\n" +
		"<TASK Name=\"startup\" Type=\"task\">\n" +
		"<SCHEDULING Priority=\"1\"/>\n" +
		"<ACTIVATION Deadline=\"1000.0ms\" Period=\"1000.0ms\" Type=\"sporadic\"/>\n" +
		"</TASK>\n" +
		"<TASK Name=\"intCam\" Type=\"task\">\n" +
		"<SCHEDULING Priority=\"6\"/>\n" +
		"<ACTIVATION Deadline=\"5.0ms\" Period=\"5.0ms\" Type=\"sporadic\"/>\n" +
		"</TASK>\n" +
		"<TASK Name=\"timeSlow\" Type=\"task\">\n" +
		"<SCHEDULING Priority=\"2\"/>\n" +
		"<ACTIVATION Deadline=\"100.0ms\" Period=\"100.0ms\" Type=\"periodic\"/>\n" +
		"</TASK>\n" +
		"<TASK Name=\"timeMedium\" Type=\"task\">\n" +
		"<SCHEDULING Priority=\"3\"/>\n" +
		"<ACTIVATION Deadline=\"12.0ms\" Period=\"12.0ms\" Type=\"periodic\"/>\n" +
		"</TASK>\n" +
		"<TASK Name=\"timeFast\" Type=\"task\">\n" +
		"<SCHEDULING Priority=\"4\"/>\n" +
		"<ACTIVATION Deadline=\"4.0ms\" Period=\"4.0ms\" Type=\"periodic\"/>\n" +
		"</TASK>\n" +
		"<TASK Name=\"psmHigh\" Type=\"task\">\n" +
		"<SCHEDULING Priority=\"5\"/>\n" +
		"<ACTIVATION Deadline=\"5.0ms\" Period=\"5.0ms\" Type=\"sporadic\"/>\n" +
		"</TASK>\n" +
		"</ARCHITECTURAL>\n" +
		"<MAPPING>\n" +
		"<PROCMAP ProcRef=\"sys1_startup\" TaskRef=\"startup\"/>\n" +
		"<PROCMAP ProcRef=\"sys2_startup\" TaskRef=\"startup\"/>\n" +
		"<PROCMAP ProcRef=\"sys1_excepCam\" TaskRef=\"intCam\"/>\n" +
		"<PROCMAP ProcRef=\"tg1_excepCam\" TaskRef=\"intCam\"/>\n" +
		"<PROCMAP ProcRef=\"tg2_excepCam\" TaskRef=\"intCam\"/>\n" +
		"<PROCMAP ProcRef=\"tg3_excepCam\" TaskRef=\"intCam\"/>\n" +
		"<PROCMAP ProcRef=\"sys1_excepFault\" TaskRef=\"intCam\"/>\n" +
		"<PROCMAP ProcRef=\"sys1_excepTooth\" TaskRef=\"intCam\"/>\n" +
		"<PROCMAP ProcRef=\"sys2_excepCam\" TaskRef=\"intCam\"/>\n" +
		"<PROCMAP ProcRef=\"tg1_slowTime\" TaskRef=\"timeSlow\"/>\n" +
		"<PROCMAP ProcRef=\"tg3_mediumTime\" TaskRef=\"timeMedium\"/>\n" +
		"<PROCMAP ProcRef=\"tg2_mediumTime\" TaskRef=\"timeMedium\"/>\n" +
		"<PROCMAP ProcRef=\"sys1_fastTime\" TaskRef=\"timeFast\"/>\n" +
		"<PROCMAP ProcRef=\"sys1_configSynch\" TaskRef=\"psmHigh\"/>\n" +
		"<TASKMAP rtosRef=\"ecuRtos\" TaskRef=\"startup\"/>\n" +
		"<TASKMAP rtosRef=\"ecuRtos\" TaskRef=\"intCam\"/>\n" +
		"<TASKMAP rtosRef=\"ecuRtos\" TaskRef=\"timeSlow\"/>\n" +
		"<TASKMAP rtosRef=\"ecuRtos\" TaskRef=\"timeMedium\"/>\n" +
		"<TASKMAP rtosRef=\"ecuRtos\" TaskRef=\"timeFast\"/>\n" +
		"<TASKMAP rtosRef=\"ecuRtos\" TaskRef=\"psmHigh\"/>\n" +
		"</MAPPING>\n" +
		"<ANNOTATION>\n" +
		"<EXECTIME Type=\"PROC\" Ref=\"sys1_startup\">\n" +
		"<WORST Value=\"20.0us\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"PROC\" Ref=\"sys2_startup\">\n" +
		"<WORST Value=\"25.0us\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"PROC\" Ref=\"sys1_fastTime\">\n" +
		"<WORST Value=\"45.0us\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"PROC\" Ref=\"sys1_configSynch\">\n" +
		"<WORST Value=\"15.0us\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"PROC\" Ref=\"sys1_excepCam\">\n" +
		"<WORST Value=\"12.0us\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"PROC\" Ref=\"tg1_excepCam\">\n" +
		"<WORST Value=\"15.0us\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"PROC\" Ref=\"tg2_excepCam\">\n" +
		"<WORST Value=\"13.0us\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"PROC\" Ref=\"tg3_excepCam\">\n" +
		"<WORST Value=\"7.0us\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"PROC\" Ref=\"sys1_excepFault\">\n" +
		"<WORST Value=\"12.0us\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"PROC\" Ref=\"sys1_excepTooth\">\n" +
		"<WORST Value=\"12.0us\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"PROC\" Ref=\"sys2_excepCam\">\n" +
		"<WORST Value=\"5.0us\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"PROC\" Ref=\"tg3_mediumTime\">\n" +
		"<WORST Value=\"40.0us\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"PROC\" Ref=\"tg2_mediumTime\">\n" +
		"<WORST Value=\"25.0us\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"PROC\" Ref=\"tg1_slowTime\">\n" +
		"<WORST Value=\"30.0us\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"TASK\" Ref=\"intCam\">\n" +
		"<WORST Value=\"0.076ms\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"TASK\" Ref=\"psmHigh\">\n" +
		"<WORST Value=\"0.015ms\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"TASK\" Ref=\"timeFast\">\n" +
		"<WORST Value=\"0.045ms\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"TASK\" Ref=\"timeMedium\">\n" +
		"<WORST Value=\"0.065ms\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"TASK\" Ref=\"timeSlow\">\n" +
		"<WORST Value=\"0.03ms\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"TASK\" Ref=\"startup\">\n" +
		"<WORST Value=\"0.045ms\"/>\n" +
		"</EXECTIME>\n" +
		"</ANNOTATION>\n" +
		"<SCHEDULABILITY>\n" +
		"<SCHEDULINGSCENARIO>\n" +
		"<CPUSCHED CpuRef=\"ecuRtos\" Utilization=\"0.035211666666666676\" SpeedFactor=\"0.0382\" Boundary=\"0.7347722898562381\" Schedulable=\"true\"/>\n" +
		"<TASKSCHED TaskRef=\"intCam\" Utilization=\"0.0152\" CDelta=\"3.864\" Schedulable=\"true\" ResponseTime=\"0.076ms\"/>\n" +
		"<TASKSCHED TaskRef=\"psmHigh\" Utilization=\"0.0030\" CDelta=\"3.864\" Schedulable=\"true\" ResponseTime=\"0.091ms\"/>\n" +
		"<TASKSCHED TaskRef=\"timeFast\" Utilization=\"0.01125\" CDelta=\"3.842333333333333\" Schedulable=\"true\" ResponseTime=\"0.136ms\"/>\n" +
		"<TASKSCHED TaskRef=\"timeMedium\" Utilization=\"0.005416666666666667\" CDelta=\"11.527\" Schedulable=\"true\" ResponseTime=\"0.201ms\"/>\n" +
		"<TASKSCHED TaskRef=\"timeSlow\" Utilization=\"3.0E-4\" CDelta=\"96.44\" Schedulable=\"true\" ResponseTime=\"0.231ms\"/>\n" +
		"<TASKSCHED TaskRef=\"startup\" Utilization=\"4.4999999999999996E-5\" CDelta=\"964.745\" Schedulable=\"true\" ResponseTime=\"0.276ms\"/>\n" +
		"</SCHEDULINGSCENARIO>\n" +
		"</SCHEDULABILITY>\n" +
		"</SYSTEM>\n"
	};
	
	public final static String[] example1b = {
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
		"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE SYSTEM SYSTEM \"evidence_0.4.dtd\">\n" +
		"<SYSTEM xmlns:com.eu.evidence.rtdruid.data=\"http://www.evidence.eu.com/rtdruid/data\" Name=\"Test\">\n" +
		"<FUNCTIONAL>\n" +
		"<EVENT Name=\"sys1_startup.act\" Type=\"activation\" MethodRefName=\"AcceptKeyOnEvent/sys1_startup.trigger\"/>\n" +
		"<EVENT Name=\"sys2_startup.act\" Type=\"activation\" MethodRefName=\"AcceptKeyOnEvent/sys2_startup.trigger\"/>\n" +
		"<EVENT Name=\"sys1_startup.begin\" Type=\"begin\" MethodRefName=\"AcceptKeyOnEvent/sys1_startup.trigger\"/>\n" +
		"<EVENT Name=\"sys2_startup.begin\" Type=\"begin\" MethodRefName=\"AcceptKeyOnEvent/sys2_startup.trigger\"/>\n" +
		"<EVENT Name=\"sys1_startup.end\" Type=\"end\" MethodRefName=\"AcceptKeyOnEvent/sys1_startup.trigger\"/>\n" +
		"<EVENT Name=\"sys2_startup.end\" Type=\"end\" MethodRefName=\"AcceptKeyOnEvent/sys2_startup.trigger\"/>\n" +
		"<EVENT Name=\"sys1_fastTime.act\" Type=\"activation\" MethodRefName=\"AcceptEventTimeFast/sys1_fastTime.trigger\"/>\n" +
		"<EVENT Name=\"sys1_fastTime.begin\" Type=\"begin\" MethodRefName=\"AcceptEventTimeFast/sys1_fastTime.trigger\"/>\n" +
		"<EVENT Name=\"sys1_fastTime.end\" Type=\"end\" MethodRefName=\"AcceptEventTimeFast/sys1_fastTime.trigger\"/>\n" +
		"<EVENT Name=\"sys1_configSynch.act\" Type=\"activation\" MethodRefName=\"AcceptEventPsmHigh/sys1_configSynch.trigger\"/>\n" +
		"<EVENT Name=\"sys1_configSynch.begin\" Type=\"begin\" MethodRefName=\"AcceptEventPsmHigh/sys1_configSynch.trigger\"/>\n" +
		"<EVENT Name=\"sys1_configSynch.end\" Type=\"end\" MethodRefName=\"AcceptEventPsmHigh/sys1_configSynch.trigger\"/>\n" +
		"<EVENT Name=\"sys1_excepCam.act\" Type=\"activation\" MethodRefName=\"AcceptEventIntCam/sys1_excepCam.trigger\"/>\n" +
		"<EVENT Name=\"tg1_excepCam.act\" Type=\"activation\" MethodRefName=\"AcceptEventIntCam/tg1_excepCam.trigger\"/>\n" +
		"<EVENT Name=\"tg2_excepCam.act\" Type=\"activation\" MethodRefName=\"AcceptEventIntCam/tg2_excepCam.trigger\"/>\n" +
		"<EVENT Name=\"tg3_excepCam.act\" Type=\"activation\" MethodRefName=\"AcceptEventIntCam/tg3_excepCam.trigger\"/>\n" +
		"<EVENT Name=\"sys2_excepCam.act\" Type=\"activation\" MethodRefName=\"AcceptEventIntCam/sys2_excepCam.trigger\"/>\n" +
		"<EVENT Name=\"sys1_excepFault.begin\" Type=\"begin\" MethodRefName=\"sys1_excepCam/sys1_excepFault.run\"/>\n" +
		"<EVENT Name=\"sys1_excepTooth.begin\" Type=\"begin\" MethodRefName=\"sys1_excepFault/sys1_excepTooth.run\"/>\n" +
		"<EVENT Name=\"sys1_excepCam.begin\" Type=\"begin\" MethodRefName=\"AcceptEventIntCam/sys1_excepCam.trigger\"/>\n" +
		"<EVENT Name=\"tg1_excepCam.begin\" Type=\"begin\" MethodRefName=\"AcceptEventIntCam/tg1_excepCam.trigger\"/>\n" +
		"<EVENT Name=\"tg2_excepCam.begin\" Type=\"begin\" MethodRefName=\"AcceptEventIntCam/tg2_excepCam.trigger\"/>\n" +
		"<EVENT Name=\"tg3_excepCam.begin\" Type=\"begin\" MethodRefName=\"AcceptEventIntCam/tg3_excepCam.trigger\"/>\n" +
		"<EVENT Name=\"sys2_excepCam.begin\" Type=\"begin\" MethodRefName=\"AcceptEventIntCam/sys2_excepCam.trigger\"/>\n" +
		"<EVENT Name=\"sys1_excepFault.end\" Type=\"end\" MethodRefName=\"sys1_excepCam/sys1_excepFault.run\"/>\n" +
		"<EVENT Name=\"sys1_excepTooth.end\" Type=\"end\" MethodRefName=\"sys1_excepFault/sys1_excepTooth.run\"/>\n" +
		"<EVENT Name=\"sys1_excepCam.end\" Type=\"end\" MethodRefName=\"AcceptEventIntCam/sys1_excepCam.trigger\"/>\n" +
		"<EVENT Name=\"tg1_excepCam.end\" Type=\"end\" MethodRefName=\"AcceptEventIntCam/tg1_excepCam.trigger\"/>\n" +
		"<EVENT Name=\"tg2_excepCam.end\" Type=\"end\" MethodRefName=\"AcceptEventIntCam/tg2_excepCam.trigger\"/>\n" +
		"<EVENT Name=\"tg3_excepCam.end\" Type=\"end\" MethodRefName=\"AcceptEventIntCam/tg3_excepCam.trigger\"/>\n" +
		"<EVENT Name=\"sys2_excepCam.end\" Type=\"end\" MethodRefName=\"AcceptEventIntCam/sys2_excepCam.trigger\"/>\n" +
		"<EVENT Name=\"tg3_mediumTime.act\" Type=\"activation\" MethodRefName=\"AcceptEventTimeMedium/tg3_mediumTime.trigger\"/>\n" +
		"<EVENT Name=\"tg2_mediumTime.act\" Type=\"activation\" MethodRefName=\"AcceptEventTimeMedium/tg2_mediumTime.trigger\"/>\n" +
		"<EVENT Name=\"tg3_mediumTime.begin\" Type=\"begin\" MethodRefName=\"AcceptEventTimeMedium/tg3_mediumTime.trigger\"/>\n" +
		"<EVENT Name=\"tg2_mediumTime.begin\" Type=\"begin\" MethodRefName=\"AcceptEventTimeMedium/tg2_mediumTime.trigger\"/>\n" +
		"<EVENT Name=\"tg3_mediumTime.end\" Type=\"end\" MethodRefName=\"AcceptEventTimeMedium/tg3_mediumTime.trigger\"/>\n" +
		"<EVENT Name=\"tg2_mediumTime.end\" Type=\"end\" MethodRefName=\"AcceptEventTimeMedium/tg2_mediumTime.trigger\"/>\n" +
		"<EVENT Name=\"tg1_slowTime.act\" Type=\"activation\" MethodRefName=\"AcceptEventTimeSlow/tg1_slowTime.trigger\"/>\n" +
		"<EVENT Name=\"tg1_slowTime.begin\" Type=\"begin\" MethodRefName=\"AcceptEventTimeSlow/tg1_slowTime.trigger\"/>\n" +
		"<EVENT Name=\"tg1_slowTime.end\" Type=\"end\" MethodRefName=\"AcceptEventTimeSlow/tg1_slowTime.trigger\"/>\n" +
		"<PARTIALORDER>\n" +
		"<ORDER>\n" +
		"<EVENTREF Name=\"sys1_excepCam.end\"/>\n" +
		"<EVENTREF Name=\"sys1_excepFault.begin\"/>\n" +
		"</ORDER>\n" +
		"<ORDER>\n" +
		"<EVENTREF Name=\"sys1_excepFault.end\"/>\n" +
		"<EVENTREF Name=\"sys1_excepTooth.begin\"/>\n" +
		"</ORDER>\n" +
		"</PARTIALORDER>\n" +
		"<PROC Name=\"sys1_startup\">\n" +
		"<METHOD Name=\"run\"/>\n" +
		"</PROC>\n" +
		"<PROC Name=\"sys2_startup\">\n" +
		"<METHOD Name=\"run\"/>\n" +
		"</PROC>\n" +
		"<PROC Name=\"sys1_fastTime\">\n" +
		"<METHOD Name=\"run\"/>\n" +
		"</PROC>\n" +
		"<PROC Name=\"sys1_configSynch\">\n" +
		"<METHOD Name=\"run\"/>\n" +
		"</PROC>\n" +
		"<PROC Name=\"sys1_excepCam\">\n" +
		"<METHOD Name=\"run\"/>\n" +
		"<METHODREF Name=\"sys1_excepFault.run\" MethodName=\"sys1_excepFault/run\"/>\n" +
		"</PROC>\n" +
		"<PROC Name=\"tg1_excepCam\">\n" +
		"<METHOD Name=\"run\"/>\n" +
		"</PROC>\n" +
		"<PROC Name=\"tg2_excepCam\">\n" +
		"<METHOD Name=\"run\"/>\n" +
		"</PROC>\n" +
		"<PROC Name=\"tg3_excepCam\">\n" +
		"<METHOD Name=\"run\"/>\n" +
		"</PROC>\n" +
		"<PROC Name=\"sys1_excepFault\">\n" +
		"<METHOD Name=\"run\"/>\n" +
		"<METHODREF Name=\"sys1_excepTooth.run\" MethodName=\"sys1_excepTooth/run\"/>\n" +
		"</PROC>\n" +
		"<PROC Name=\"sys1_excepTooth\">\n" +
		"<METHOD Name=\"run\"/>\n" +
		"</PROC>\n" +
		"<PROC Name=\"sys2_excepCam\">\n" +
		"<METHOD Name=\"run\"/>\n" +
		"</PROC>\n" +
		"<PROC Name=\"tg3_mediumTime\">\n" +
		"<METHOD Name=\"run\"/>\n" +
		"</PROC>\n" +
		"<PROC Name=\"tg2_mediumTime\">\n" +
		"<METHOD Name=\"run\"/>\n" +
		"</PROC>\n" +
		"<PROC Name=\"tg1_slowTime\">\n" +
		"<METHOD Name=\"run\"/>\n" +
		"</PROC>\n" +
		"<TRIGGER Name=\"AcceptKeyOnEvent\">\n" +
		"<METHODREF Name=\"sys1_startup.trigger\" MethodName=\"sys1_startup/run\"/>\n" +
		"<METHODREF Name=\"sys2_startup.trigger\" MethodName=\"sys2_startup/run\"/>\n" +
		"</TRIGGER>\n" +
		"<TRIGGER Name=\"AcceptEventTimeFast\">\n" +
		"<METHODREF Name=\"sys1_fastTime.trigger\" MethodName=\"sys1_fastTime/run\"/>\n" +
		"</TRIGGER>\n" +
		"<TRIGGER Name=\"AcceptEventPsmHigh\">\n" +
		"<METHODREF Name=\"sys1_configSynch.trigger\" MethodName=\"sys1_configSynch/run\"/>\n" +
		"</TRIGGER>\n" +
		"<TRIGGER Name=\"AcceptEventIntCam\">\n" +
		"<METHODREF Name=\"sys1_excepCam.trigger\" MethodName=\"sys1_excepCam/run\"/>\n" +
		"<METHODREF Name=\"tg1_excepCam.trigger\" MethodName=\"tg1_excepCam/run\"/>\n" +
		"<METHODREF Name=\"tg2_excepCam.trigger\" MethodName=\"tg2_excepCam/run\"/>\n" +
		"<METHODREF Name=\"tg3_excepCam.trigger\" MethodName=\"tg3_excepCam/run\"/>\n" +
		"<METHODREF Name=\"sys2_excepCam.trigger\" MethodName=\"sys2_excepCam/run\"/>\n" +
		"</TRIGGER>\n" +
		"<TRIGGER Name=\"AcceptEventTimeMedium\">\n" +
		"<METHODREF Name=\"tg3_mediumTime.trigger\" MethodName=\"tg3_mediumTime/run\"/>\n" +
		"<METHODREF Name=\"tg2_mediumTime.trigger\" MethodName=\"tg2_mediumTime/run\"/>\n" +
		"</TRIGGER>\n" +
		"<TRIGGER Name=\"AcceptEventTimeSlow\">\n" +
		"<METHODREF Name=\"tg1_slowTime.trigger\" MethodName=\"tg1_slowTime/run\"/>\n" +
		"</TRIGGER>\n" +
		"</FUNCTIONAL>\n" +
		"<ARCHITECTURAL>\n" +
		"<ECU Name=\"ecu\">\n" +
		"<CPU Name=\"ecuCpu\">\n" +
		"<RTOS Name=\"ecuRtos\"/>\n" +
		"</CPU>\n" +
		"</ECU>\n" +
		"<TASK Name=\"startup\" Type=\"task\">\n" +
		"<SCHEDULING Priority=\"1\"/>\n" +
		"<ACTIVATION Deadline=\"1000.0ms\" Period=\"1000.0ms\" Type=\"sporadic\"/>\n" +
		"</TASK>\n" +
		"<TASK Name=\"intCam\" Type=\"task\">\n" +
		"<SCHEDULING Priority=\"6\"/>\n" +
		"<ACTIVATION Deadline=\"5.0ms\" Period=\"5.0ms\" Type=\"sporadic\"/>\n" +
		"</TASK>\n" +
		"<TASK Name=\"timeSlow\" Type=\"task\">\n" +
		"<SCHEDULING Priority=\"2\"/>\n" +
		"<ACTIVATION Deadline=\"100.0ms\" Period=\"100.0ms\" Type=\"periodic\"/>\n" +
		"</TASK>\n" +
		"<TASK Name=\"timeMedium\" Type=\"task\">\n" +
		"<SCHEDULING Priority=\"3\"/>\n" +
		"<ACTIVATION Deadline=\"12.0ms\" Period=\"12.0ms\" Type=\"periodic\"/>\n" +
		"</TASK>\n" +
		"<TASK Name=\"timeFast\" Type=\"task\">\n" +
		"<SCHEDULING Priority=\"4\"/>\n" +
		"<ACTIVATION Deadline=\"4.0ms\" Period=\"4.0ms\" Type=\"periodic\"/>\n" +
		"</TASK>\n" +
		"<TASK Name=\"psmHigh\" Type=\"task\">\n" +
		"<SCHEDULING Priority=\"5\"/>\n" +
		"<ACTIVATION Deadline=\"5.0ms\" Period=\"5.0ms\" Type=\"sporadic\"/>\n" +
		"</TASK>\n" +
		"</ARCHITECTURAL>\n" +
		"<MAPPING>\n" +
		"<PROCMAP ProcRef=\"sys1_startup\" TaskRef=\"startup\"/>\n" +
		"<PROCMAP ProcRef=\"sys2_startup\" TaskRef=\"startup\"/>\n" +
		"<PROCMAP ProcRef=\"sys1_excepCam\" TaskRef=\"intCam\"/>\n" +
		"<PROCMAP ProcRef=\"tg1_excepCam\" TaskRef=\"intCam\"/>\n" +
		"<PROCMAP ProcRef=\"tg2_excepCam\" TaskRef=\"intCam\" OnceEveryK=\"3\"/>\n" +
		"<PROCMAP ProcRef=\"tg3_excepCam\" TaskRef=\"intCam\"/>\n" +
		"<PROCMAP ProcRef=\"sys1_excepFault\" TaskRef=\"intCam\"/>\n" +
		"<PROCMAP ProcRef=\"sys1_excepTooth\" TaskRef=\"intCam\"/>\n" +
		"<PROCMAP ProcRef=\"sys2_excepCam\" TaskRef=\"intCam\"/>\n" +
		"<PROCMAP ProcRef=\"tg1_slowTime\" TaskRef=\"timeSlow\"/>\n" +
		"<PROCMAP ProcRef=\"tg3_mediumTime\" TaskRef=\"timeMedium\"/>\n" +
		"<PROCMAP ProcRef=\"tg2_mediumTime\" TaskRef=\"timeMedium\" OnceEveryK=\"5\"/>\n" +
		"<PROCMAP ProcRef=\"sys1_fastTime\" TaskRef=\"timeFast\"/>\n" +
		"<PROCMAP ProcRef=\"sys1_configSynch\" TaskRef=\"psmHigh\"/>\n" +
		"<TASKMAP rtosRef=\"ecuRtos\" TaskRef=\"startup\"/>\n" +
		"<TASKMAP rtosRef=\"ecuRtos\" TaskRef=\"intCam\"/>\n" +
		"<TASKMAP rtosRef=\"ecuRtos\" TaskRef=\"timeSlow\"/>\n" +
		"<TASKMAP rtosRef=\"ecuRtos\" TaskRef=\"timeMedium\"/>\n" +
		"<TASKMAP rtosRef=\"ecuRtos\" TaskRef=\"timeFast\"/>\n" +
		"<TASKMAP rtosRef=\"ecuRtos\" TaskRef=\"psmHigh\"/>\n" +
		"</MAPPING>\n" +
		"<ANNOTATION>\n" +
		"<EXECTIME Type=\"PROC\" Ref=\"sys1_startup\">\n" +
		"<WORST Value=\"20.0us\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"PROC\" Ref=\"sys2_startup\">\n" +
		"<WORST Value=\"25.0us\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"PROC\" Ref=\"sys1_fastTime\">\n" +
		"<WORST Value=\"45.0us\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"PROC\" Ref=\"sys1_configSynch\">\n" +
		"<WORST Value=\"15.0us\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"PROC\" Ref=\"sys1_excepCam\">\n" +
		"<WORST Value=\"12.0us\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"PROC\" Ref=\"tg1_excepCam\">\n" +
		"<WORST Value=\"15.0us\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"PROC\" Ref=\"tg2_excepCam\">\n" +
		"<WORST Value=\"13.0us\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"PROC\" Ref=\"tg3_excepCam\">\n" +
		"<WORST Value=\"7.0us\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"PROC\" Ref=\"sys1_excepFault\">\n" +
		"<WORST Value=\"12.0us\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"PROC\" Ref=\"sys1_excepTooth\">\n" +
		"<WORST Value=\"12.0us\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"PROC\" Ref=\"sys2_excepCam\">\n" +
		"<WORST Value=\"5.0us\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"PROC\" Ref=\"tg3_mediumTime\">\n" +
		"<WORST Value=\"40.0us\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"PROC\" Ref=\"tg2_mediumTime\">\n" +
		"<WORST Value=\"25.0us\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"PROC\" Ref=\"tg1_slowTime\">\n" +
		"<WORST Value=\"30.0us\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"TASK\" Ref=\"intCam\">\n" +
		"<WORST Value=\"0.076ms\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"TASK\" Ref=\"psmHigh\">\n" +
		"<WORST Value=\"0.015ms\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"TASK\" Ref=\"timeFast\">\n" +
		"<WORST Value=\"0.045ms\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"TASK\" Ref=\"timeMedium\">\n" +
		"<WORST Value=\"0.065ms\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"TASK\" Ref=\"timeSlow\">\n" +
		"<WORST Value=\"0.03ms\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"TASK\" Ref=\"startup\">\n" +
		"<WORST Value=\"0.045ms\"/>\n" +
		"</EXECTIME>\n" +
		"</ANNOTATION>\n" +
		"<SCHEDULABILITY>\n" +
		"<SCHEDULINGSCENARIO>\n" +
		"<CPUSCHED CpuRef=\"ecuRtos\" Utilization=\"0.035211666666666676\" SpeedFactor=\"0.0382\" Boundary=\"0.7347722898562381\" Schedulable=\"true\"/>\n" +
		"<TASKSCHED TaskRef=\"intCam\" Utilization=\"0.0152\" CDelta=\"3.864\" Schedulable=\"true\" ResponseTime=\"0.076ms\"/>\n" +
		"<TASKSCHED TaskRef=\"psmHigh\" Utilization=\"0.0030\" CDelta=\"3.864\" Schedulable=\"true\" ResponseTime=\"0.091ms\"/>\n" +
		"<TASKSCHED TaskRef=\"timeFast\" Utilization=\"0.01125\" CDelta=\"3.842333333333333\" Schedulable=\"true\" ResponseTime=\"0.136ms\"/>\n" +
		"<TASKSCHED TaskRef=\"timeMedium\" Utilization=\"0.005416666666666667\" CDelta=\"11.527\" Schedulable=\"true\" ResponseTime=\"0.201ms\"/>\n" +
		"<TASKSCHED TaskRef=\"timeSlow\" Utilization=\"3.0E-4\" CDelta=\"96.44\" Schedulable=\"true\" ResponseTime=\"0.231ms\"/>\n" +
		"<TASKSCHED TaskRef=\"startup\" Utilization=\"4.4999999999999996E-5\" CDelta=\"964.745\" Schedulable=\"true\" ResponseTime=\"0.276ms\"/>\n" +
		"</SCHEDULINGSCENARIO>\n" +
		"</SCHEDULABILITY>\n" +
		"</SYSTEM>"
	};

	
	public final static String[] example1c = {
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
		"      <METHODREF MethodName=\"tg3_excepCam/run\" Name=\"tg3_excepCam.trigger\"/>\n" +
		"      <METHODREF MethodName=\"sys2_excepCam/run\" Name=\"sys2_excepCam.trigger\"/>\n" +
		"    </TRIGGER>\n" +
		"    <TRIGGER Name=\"AcceptEventIntCam15\">\n" +
		"      <METHODREF MethodName=\"tg2_excepCam/run\" Name=\"tg2_excepCam.trigger\"/>\n" +
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
		"    <EVENT MethodRefName=\"AcceptEventIntCam15/tg2_excepCam.trigger\" Name=\"tg2_excepCam.act\" Type=\"activation\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventIntCam/tg3_excepCam.trigger\" Name=\"tg3_excepCam.act\" Type=\"activation\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventIntCam/sys2_excepCam.trigger\" Name=\"sys2_excepCam.act\" Type=\"activation\"/>\n" +
		"    <EVENT MethodRefName=\"sys1_excepCam/sys1_excepFault.run\" Name=\"sys1_excepFault.begin\" Type=\"begin\"/>\n" +
		"    <EVENT MethodRefName=\"sys1_excepFault/sys1_excepTooth.run\" Name=\"sys1_excepTooth.begin\" Type=\"begin\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventIntCam/sys1_excepCam.trigger\" Name=\"sys1_excepCam.begin\" Type=\"begin\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventIntCam/tg1_excepCam.trigger\" Name=\"tg1_excepCam.begin\" Type=\"begin\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventIntCam15/tg2_excepCam.trigger\" Name=\"tg2_excepCam.begin\" Type=\"begin\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventIntCam/tg3_excepCam.trigger\" Name=\"tg3_excepCam.begin\" Type=\"begin\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventIntCam/sys2_excepCam.trigger\" Name=\"sys2_excepCam.begin\" Type=\"begin\"/>\n" +
		"    <EVENT MethodRefName=\"sys1_excepCam/sys1_excepFault.run\" Name=\"sys1_excepFault.end\" Type=\"end\"/>\n" +
		"    <EVENT MethodRefName=\"sys1_excepFault/sys1_excepTooth.run\" Name=\"sys1_excepTooth.end\" Type=\"end\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventIntCam/sys1_excepCam.trigger\" Name=\"sys1_excepCam.end\" Type=\"end\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventIntCam/tg1_excepCam.trigger\" Name=\"tg1_excepCam.end\" Type=\"end\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventIntCam15/tg2_excepCam.trigger\" Name=\"tg2_excepCam.end\" Type=\"end\"/>\n" +
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
		"      <BOUND Type=\"mit\" Value=\"15ms\"/>\n" +
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
		"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE SYSTEM SYSTEM \"evidence_0.4.dtd\">\n" +
		"<SYSTEM xmlns:com.eu.evidence.rtdruid.data=\"http://www.evidence.eu.com/rtdruid/data\" Name=\"Test\">\n" +
		"<FUNCTIONAL>\n" +
		"<EVENT Name=\"sys1_startup.act\" Type=\"activation\" MethodRefName=\"AcceptKeyOnEvent/sys1_startup.trigger\"/>\n" +
		"<EVENT Name=\"sys2_startup.act\" Type=\"activation\" MethodRefName=\"AcceptKeyOnEvent/sys2_startup.trigger\"/>\n" +
		"<EVENT Name=\"sys1_startup.begin\" Type=\"begin\" MethodRefName=\"AcceptKeyOnEvent/sys1_startup.trigger\"/>\n" +
		"<EVENT Name=\"sys2_startup.begin\" Type=\"begin\" MethodRefName=\"AcceptKeyOnEvent/sys2_startup.trigger\"/>\n" +
		"<EVENT Name=\"sys1_startup.end\" Type=\"end\" MethodRefName=\"AcceptKeyOnEvent/sys1_startup.trigger\"/>\n" +
		"<EVENT Name=\"sys2_startup.end\" Type=\"end\" MethodRefName=\"AcceptKeyOnEvent/sys2_startup.trigger\"/>\n" +
		"<EVENT Name=\"sys1_fastTime.act\" Type=\"activation\" MethodRefName=\"AcceptEventTimeFast/sys1_fastTime.trigger\"/>\n" +
		"<EVENT Name=\"sys1_fastTime.begin\" Type=\"begin\" MethodRefName=\"AcceptEventTimeFast/sys1_fastTime.trigger\"/>\n" +
		"<EVENT Name=\"sys1_fastTime.end\" Type=\"end\" MethodRefName=\"AcceptEventTimeFast/sys1_fastTime.trigger\"/>\n" +
		"<EVENT Name=\"sys1_configSynch.act\" Type=\"activation\" MethodRefName=\"AcceptEventPsmHigh/sys1_configSynch.trigger\"/>\n" +
		"<EVENT Name=\"sys1_configSynch.begin\" Type=\"begin\" MethodRefName=\"AcceptEventPsmHigh/sys1_configSynch.trigger\"/>\n" +
		"<EVENT Name=\"sys1_configSynch.end\" Type=\"end\" MethodRefName=\"AcceptEventPsmHigh/sys1_configSynch.trigger\"/>\n" +
		"<EVENT Name=\"sys1_excepCam.act\" Type=\"activation\" MethodRefName=\"AcceptEventIntCam/sys1_excepCam.trigger\"/>\n" +
		"<EVENT Name=\"tg1_excepCam.act\" Type=\"activation\" MethodRefName=\"AcceptEventIntCam/tg1_excepCam.trigger\"/>\n" +
		"<EVENT Name=\"tg2_excepCam.act\" Type=\"activation\" MethodRefName=\"AcceptEventIntCam15/tg2_excepCam.trigger\"/>\n" +
		"<EVENT Name=\"tg3_excepCam.act\" Type=\"activation\" MethodRefName=\"AcceptEventIntCam/tg3_excepCam.trigger\"/>\n" +
		"<EVENT Name=\"sys2_excepCam.act\" Type=\"activation\" MethodRefName=\"AcceptEventIntCam/sys2_excepCam.trigger\"/>\n" +
		"<EVENT Name=\"sys1_excepFault.begin\" Type=\"begin\" MethodRefName=\"sys1_excepCam/sys1_excepFault.run\"/>\n" +
		"<EVENT Name=\"sys1_excepTooth.begin\" Type=\"begin\" MethodRefName=\"sys1_excepFault/sys1_excepTooth.run\"/>\n" +
		"<EVENT Name=\"sys1_excepCam.begin\" Type=\"begin\" MethodRefName=\"AcceptEventIntCam/sys1_excepCam.trigger\"/>\n" +
		"<EVENT Name=\"tg1_excepCam.begin\" Type=\"begin\" MethodRefName=\"AcceptEventIntCam/tg1_excepCam.trigger\"/>\n" +
		"<EVENT Name=\"tg2_excepCam.begin\" Type=\"begin\" MethodRefName=\"AcceptEventIntCam15/tg2_excepCam.trigger\"/>\n" +
		"<EVENT Name=\"tg3_excepCam.begin\" Type=\"begin\" MethodRefName=\"AcceptEventIntCam/tg3_excepCam.trigger\"/>\n" +
		"<EVENT Name=\"sys2_excepCam.begin\" Type=\"begin\" MethodRefName=\"AcceptEventIntCam/sys2_excepCam.trigger\"/>\n" +
		"<EVENT Name=\"sys1_excepFault.end\" Type=\"end\" MethodRefName=\"sys1_excepCam/sys1_excepFault.run\"/>\n" +
		"<EVENT Name=\"sys1_excepTooth.end\" Type=\"end\" MethodRefName=\"sys1_excepFault/sys1_excepTooth.run\"/>\n" +
		"<EVENT Name=\"sys1_excepCam.end\" Type=\"end\" MethodRefName=\"AcceptEventIntCam/sys1_excepCam.trigger\"/>\n" +
		"<EVENT Name=\"tg1_excepCam.end\" Type=\"end\" MethodRefName=\"AcceptEventIntCam/tg1_excepCam.trigger\"/>\n" +
		"<EVENT Name=\"tg2_excepCam.end\" Type=\"end\" MethodRefName=\"AcceptEventIntCam15/tg2_excepCam.trigger\"/>\n" +
		"<EVENT Name=\"tg3_excepCam.end\" Type=\"end\" MethodRefName=\"AcceptEventIntCam/tg3_excepCam.trigger\"/>\n" +
		"<EVENT Name=\"sys2_excepCam.end\" Type=\"end\" MethodRefName=\"AcceptEventIntCam/sys2_excepCam.trigger\"/>\n" +
		"<EVENT Name=\"tg3_mediumTime.act\" Type=\"activation\" MethodRefName=\"AcceptEventTimeMedium/tg3_mediumTime.trigger\"/>\n" +
		"<EVENT Name=\"tg2_mediumTime.act\" Type=\"activation\" MethodRefName=\"AcceptEventTimeMedium/tg2_mediumTime.trigger\"/>\n" +
		"<EVENT Name=\"tg3_mediumTime.begin\" Type=\"begin\" MethodRefName=\"AcceptEventTimeMedium/tg3_mediumTime.trigger\"/>\n" +
		"<EVENT Name=\"tg2_mediumTime.begin\" Type=\"begin\" MethodRefName=\"AcceptEventTimeMedium/tg2_mediumTime.trigger\"/>\n" +
		"<EVENT Name=\"tg3_mediumTime.end\" Type=\"end\" MethodRefName=\"AcceptEventTimeMedium/tg3_mediumTime.trigger\"/>\n" +
		"<EVENT Name=\"tg2_mediumTime.end\" Type=\"end\" MethodRefName=\"AcceptEventTimeMedium/tg2_mediumTime.trigger\"/>\n" +
		"<EVENT Name=\"tg1_slowTime.act\" Type=\"activation\" MethodRefName=\"AcceptEventTimeSlow/tg1_slowTime.trigger\"/>\n" +
		"<EVENT Name=\"tg1_slowTime.begin\" Type=\"begin\" MethodRefName=\"AcceptEventTimeSlow/tg1_slowTime.trigger\"/>\n" +
		"<EVENT Name=\"tg1_slowTime.end\" Type=\"end\" MethodRefName=\"AcceptEventTimeSlow/tg1_slowTime.trigger\"/>\n" +
		"<PARTIALORDER>\n" +
		"<ORDER>\n" +
		"<EVENTREF Name=\"sys1_excepCam.end\"/>\n" +
		"<EVENTREF Name=\"sys1_excepFault.begin\"/>\n" +
		"</ORDER>\n" +
		"<ORDER>\n" +
		"<EVENTREF Name=\"sys1_excepFault.end\"/>\n" +
		"<EVENTREF Name=\"sys1_excepTooth.begin\"/>\n" +
		"</ORDER>\n" +
		"</PARTIALORDER>\n" +
		"<PROC Name=\"sys1_startup\">\n" +
		"<METHOD Name=\"run\"/>\n" +
		"</PROC>\n" +
		"<PROC Name=\"sys2_startup\">\n" +
		"<METHOD Name=\"run\"/>\n" +
		"</PROC>\n" +
		"<PROC Name=\"sys1_fastTime\">\n" +
		"<METHOD Name=\"run\"/>\n" +
		"</PROC>\n" +
		"<PROC Name=\"sys1_configSynch\">\n" +
		"<METHOD Name=\"run\"/>\n" +
		"</PROC>\n" +
		"<PROC Name=\"sys1_excepCam\">\n" +
		"<METHOD Name=\"run\"/>\n" +
		"<METHODREF Name=\"sys1_excepFault.run\" MethodName=\"sys1_excepFault/run\"/>\n" +
		"</PROC>\n" +
		"<PROC Name=\"tg1_excepCam\">\n" +
		"<METHOD Name=\"run\"/>\n" +
		"</PROC>\n" +
		"<PROC Name=\"tg2_excepCam\">\n" +
		"<METHOD Name=\"run\"/>\n" +
		"</PROC>\n" +
		"<PROC Name=\"tg3_excepCam\">\n" +
		"<METHOD Name=\"run\"/>\n" +
		"</PROC>\n" +
		"<PROC Name=\"sys1_excepFault\">\n" +
		"<METHOD Name=\"run\"/>\n" +
		"<METHODREF Name=\"sys1_excepTooth.run\" MethodName=\"sys1_excepTooth/run\"/>\n" +
		"</PROC>\n" +
		"<PROC Name=\"sys1_excepTooth\">\n" +
		"<METHOD Name=\"run\"/>\n" +
		"</PROC>\n" +
		"<PROC Name=\"sys2_excepCam\">\n" +
		"<METHOD Name=\"run\"/>\n" +
		"</PROC>\n" +
		"<PROC Name=\"tg3_mediumTime\">\n" +
		"<METHOD Name=\"run\"/>\n" +
		"</PROC>\n" +
		"<PROC Name=\"tg2_mediumTime\">\n" +
		"<METHOD Name=\"run\"/>\n" +
		"</PROC>\n" +
		"<PROC Name=\"tg1_slowTime\">\n" +
		"<METHOD Name=\"run\"/>\n" +
		"</PROC>\n" +
		"<TRIGGER Name=\"AcceptKeyOnEvent\">\n" +
		"<METHODREF Name=\"sys1_startup.trigger\" MethodName=\"sys1_startup/run\"/>\n" +
		"<METHODREF Name=\"sys2_startup.trigger\" MethodName=\"sys2_startup/run\"/>\n" +
		"</TRIGGER>\n" +
		"<TRIGGER Name=\"AcceptEventTimeFast\">\n" +
		"<METHODREF Name=\"sys1_fastTime.trigger\" MethodName=\"sys1_fastTime/run\"/>\n" +
		"</TRIGGER>\n" +
		"<TRIGGER Name=\"AcceptEventPsmHigh\">\n" +
		"<METHODREF Name=\"sys1_configSynch.trigger\" MethodName=\"sys1_configSynch/run\"/>\n" +
		"</TRIGGER>\n" +
		"<TRIGGER Name=\"AcceptEventIntCam\">\n" +
		"<METHODREF Name=\"sys1_excepCam.trigger\" MethodName=\"sys1_excepCam/run\"/>\n" +
		"<METHODREF Name=\"tg1_excepCam.trigger\" MethodName=\"tg1_excepCam/run\"/>\n" +
		"<METHODREF Name=\"tg3_excepCam.trigger\" MethodName=\"tg3_excepCam/run\"/>\n" +
		"<METHODREF Name=\"sys2_excepCam.trigger\" MethodName=\"sys2_excepCam/run\"/>\n" +
		"</TRIGGER>\n" +
		"<TRIGGER Name=\"AcceptEventIntCam15\">\n" +
		"<METHODREF Name=\"tg2_excepCam.trigger\" MethodName=\"tg2_excepCam/run\"/>\n" +
		"</TRIGGER>\n" +
		"<TRIGGER Name=\"AcceptEventTimeMedium\">\n" +
		"<METHODREF Name=\"tg3_mediumTime.trigger\" MethodName=\"tg3_mediumTime/run\"/>\n" +
		"<METHODREF Name=\"tg2_mediumTime.trigger\" MethodName=\"tg2_mediumTime/run\"/>\n" +
		"</TRIGGER>\n" +
		"<TRIGGER Name=\"AcceptEventTimeSlow\">\n" +
		"<METHODREF Name=\"tg1_slowTime.trigger\" MethodName=\"tg1_slowTime/run\"/>\n" +
		"</TRIGGER>\n" +
		"<TIMECONST>\n" +
		"<EVENTREF Name=\"sys1_startup.act\"/>\n" +
		"<BOUND Type=\"mit\" Value=\"1000.0ms\"/>\n" +
		"</TIMECONST>\n" +
		"<TIMECONST>\n" +
		"<EVENTREF Name=\"sys2_startup.act\"/>\n" +
		"<BOUND Type=\"mit\" Value=\"1000.0ms\"/>\n" +
		"</TIMECONST>\n" +
		"<TIMECONST>\n" +
		"<EVENTREF Name=\"sys1_fastTime.act\"/>\n" +
		"<BOUND Type=\"period\" Value=\"4.0ms\"/>\n" +
		"</TIMECONST>\n" +
		"<TIMECONST>\n" +
		"<EVENTREF Name=\"sys1_configSynch.act\"/>\n" +
		"<BOUND Type=\"mit\" Value=\"5.0ms\"/>\n" +
		"</TIMECONST>\n" +
		"<TIMECONST>\n" +
		"<EVENTREF Name=\"sys1_excepCam.act\"/>\n" +
		"<BOUND Type=\"mit\" Value=\"5.0ms\"/>\n" +
		"</TIMECONST>\n" +
		"<TIMECONST>\n" +
		"<EVENTREF Name=\"tg1_excepCam.act\"/>\n" +
		"<BOUND Type=\"mit\" Value=\"5.0ms\"/>\n" +
		"</TIMECONST>\n" +
		"<TIMECONST>\n" +
		"<EVENTREF Name=\"tg2_excepCam.act\"/>\n" +
		"<BOUND Type=\"mit\" Value=\"15.0ms\"/>\n" +
		"</TIMECONST>\n" +
		"<TIMECONST>\n" +
		"<EVENTREF Name=\"tg3_excepCam.act\"/>\n" +
		"<BOUND Type=\"mit\" Value=\"5.0ms\"/>\n" +
		"</TIMECONST>\n" +
		"<TIMECONST>\n" +
		"<EVENTREF Name=\"sys2_excepCam.act\"/>\n" +
		"<BOUND Type=\"mit\" Value=\"5.0ms\"/>\n" +
		"</TIMECONST>\n" +
		"<TIMECONST>\n" +
		"<EVENTREF Name=\"tg3_mediumTime.act\"/>\n" +
		"<BOUND Type=\"period\" Value=\"12.0ms\"/>\n" +
		"</TIMECONST>\n" +
		"<TIMECONST>\n" +
		"<EVENTREF Name=\"tg2_mediumTime.act\"/>\n" +
		"<BOUND Type=\"period\" Value=\"12.0ms\"/>\n" +
		"</TIMECONST>\n" +
		"<TIMECONST>\n" +
		"<EVENTREF Name=\"tg1_slowTime.act\"/>\n" +
		"<BOUND Type=\"period\" Value=\"100.0ms\"/>\n" +
		"</TIMECONST>\n" +
		"</FUNCTIONAL>\n" +
		"<ARCHITECTURAL>\n" +
		"<ECU Name=\"ecu\">\n" +
		"<CPU Name=\"ecuCpu\">\n" +
		"<RTOS Name=\"ecuRtos\"/>\n" +
		"</CPU>\n" +
		"</ECU>\n" +
		"<TASK Name=\"startup\" Type=\"task\">\n" +
		"<SCHEDULING Priority=\"1\"/>\n" +
		"<ACTIVATION Deadline=\"1000.0ms\" Period=\"1000.0ms\" Type=\"sporadic\"/>\n" +
		"</TASK>\n" +
		"<TASK Name=\"intCam\" Type=\"task\">\n" +
		"<SCHEDULING Priority=\"6\"/>\n" +
		"<ACTIVATION Deadline=\"5.0ms\" Period=\"5.0ms\" Type=\"sporadic\"/>\n" +
		"</TASK>\n" +
		"<TASK Name=\"timeSlow\" Type=\"task\">\n" +
		"<SCHEDULING Priority=\"2\"/>\n" +
		"<ACTIVATION Deadline=\"100.0ms\" Period=\"100.0ms\" Type=\"periodic\"/>\n" +
		"</TASK>\n" +
		"<TASK Name=\"timeMedium\" Type=\"task\">\n" +
		"<SCHEDULING Priority=\"3\"/>\n" +
		"<ACTIVATION Deadline=\"12.0ms\" Period=\"12.0ms\" Type=\"periodic\"/>\n" +
		"</TASK>\n" +
		"<TASK Name=\"timeFast\" Type=\"task\">\n" +
		"<SCHEDULING Priority=\"4\"/>\n" +
		"<ACTIVATION Deadline=\"4.0ms\" Period=\"4.0ms\" Type=\"periodic\"/>\n" +
		"</TASK>\n" +
		"<TASK Name=\"psmHigh\" Type=\"task\">\n" +
		"<SCHEDULING Priority=\"5\"/>\n" +
		"<ACTIVATION Deadline=\"5.0ms\" Period=\"5.0ms\" Type=\"sporadic\"/>\n" +
		"</TASK>\n" +
		"</ARCHITECTURAL>\n" +
		"<MAPPING>\n" +
		"<PROCMAP ProcRef=\"sys1_startup\" TaskRef=\"startup\"/>\n" +
		"<PROCMAP ProcRef=\"sys2_startup\" TaskRef=\"startup\"/>\n" +
		"<PROCMAP ProcRef=\"sys1_excepCam\" TaskRef=\"intCam\"/>\n" +
		"<PROCMAP ProcRef=\"tg1_excepCam\" TaskRef=\"intCam\"/>\n" +
		"<PROCMAP ProcRef=\"tg2_excepCam\" TaskRef=\"intCam\" OnceEveryK=\"3\"/>\n" +
		"<PROCMAP ProcRef=\"tg3_excepCam\" TaskRef=\"intCam\"/>\n" +
		"<PROCMAP ProcRef=\"sys1_excepFault\" TaskRef=\"intCam\"/>\n" +
		"<PROCMAP ProcRef=\"sys1_excepTooth\" TaskRef=\"intCam\"/>\n" +
		"<PROCMAP ProcRef=\"sys2_excepCam\" TaskRef=\"intCam\"/>\n" +
		"<PROCMAP ProcRef=\"tg1_slowTime\" TaskRef=\"timeSlow\"/>\n" +
		"<PROCMAP ProcRef=\"tg3_mediumTime\" TaskRef=\"timeMedium\"/>\n" +
		"<PROCMAP ProcRef=\"tg2_mediumTime\" TaskRef=\"timeMedium\"/>\n" +
		"<PROCMAP ProcRef=\"sys1_fastTime\" TaskRef=\"timeFast\"/>\n" +
		"<PROCMAP ProcRef=\"sys1_configSynch\" TaskRef=\"psmHigh\"/>\n" +
		"<TASKMAP rtosRef=\"ecuRtos\" TaskRef=\"startup\"/>\n" +
		"<TASKMAP rtosRef=\"ecuRtos\" TaskRef=\"intCam\"/>\n" +
		"<TASKMAP rtosRef=\"ecuRtos\" TaskRef=\"timeSlow\"/>\n" +
		"<TASKMAP rtosRef=\"ecuRtos\" TaskRef=\"timeMedium\"/>\n" +
		"<TASKMAP rtosRef=\"ecuRtos\" TaskRef=\"timeFast\"/>\n" +
		"<TASKMAP rtosRef=\"ecuRtos\" TaskRef=\"psmHigh\"/>\n" +
		"</MAPPING>\n" +
		"<ANNOTATION>\n" +
		"<EXECTIME Type=\"PROC\" Ref=\"sys1_startup\">\n" +
		"<WORST Value=\"20.0us\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"PROC\" Ref=\"sys2_startup\">\n" +
		"<WORST Value=\"25.0us\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"PROC\" Ref=\"sys1_fastTime\">\n" +
		"<WORST Value=\"45.0us\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"PROC\" Ref=\"sys1_configSynch\">\n" +
		"<WORST Value=\"15.0us\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"PROC\" Ref=\"sys1_excepCam\">\n" +
		"<WORST Value=\"12.0us\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"PROC\" Ref=\"tg1_excepCam\">\n" +
		"<WORST Value=\"15.0us\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"PROC\" Ref=\"tg2_excepCam\">\n" +
		"<WORST Value=\"13.0us\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"PROC\" Ref=\"tg3_excepCam\">\n" +
		"<WORST Value=\"7.0us\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"PROC\" Ref=\"sys1_excepFault\">\n" +
		"<WORST Value=\"12.0us\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"PROC\" Ref=\"sys1_excepTooth\">\n" +
		"<WORST Value=\"12.0us\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"PROC\" Ref=\"sys2_excepCam\">\n" +
		"<WORST Value=\"5.0us\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"PROC\" Ref=\"tg3_mediumTime\">\n" +
		"<WORST Value=\"40.0us\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"PROC\" Ref=\"tg2_mediumTime\">\n" +
		"<WORST Value=\"25.0us\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"PROC\" Ref=\"tg1_slowTime\">\n" +
		"<WORST Value=\"30.0us\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"TASK\" Ref=\"intCam\">\n" +
		"<WORST Value=\"0.076ms\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"TASK\" Ref=\"psmHigh\">\n" +
		"<WORST Value=\"0.015ms\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"TASK\" Ref=\"timeFast\">\n" +
		"<WORST Value=\"0.045ms\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"TASK\" Ref=\"timeMedium\">\n" +
		"<WORST Value=\"0.065ms\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"TASK\" Ref=\"timeSlow\">\n" +
		"<WORST Value=\"0.03ms\"/>\n" +
		"</EXECTIME>\n" +
		"<EXECTIME Type=\"TASK\" Ref=\"startup\">\n" +
		"<WORST Value=\"0.045ms\"/>\n" +
		"</EXECTIME>\n" +
		"</ANNOTATION>\n" +
		"<SCHEDULABILITY>\n" +
		"<SCHEDULINGSCENARIO>\n" +
		"<CPUSCHED CpuRef=\"ecuRtos\" Utilization=\"0.035211666666666676\" SpeedFactor=\"0.0382\" Boundary=\"0.7347722898562381\" Schedulable=\"true\"/>\n" +
		"<TASKSCHED TaskRef=\"intCam\" Utilization=\"0.0152\" CDelta=\"3.864\" Schedulable=\"true\" ResponseTime=\"0.076ms\"/>\n" +
		"<TASKSCHED TaskRef=\"psmHigh\" Utilization=\"0.0030\" CDelta=\"3.864\" Schedulable=\"true\" ResponseTime=\"0.091ms\"/>\n" +
		"<TASKSCHED TaskRef=\"timeFast\" Utilization=\"0.01125\" CDelta=\"3.842333333333333\" Schedulable=\"true\" ResponseTime=\"0.136ms\"/>\n" +
		"<TASKSCHED TaskRef=\"timeMedium\" Utilization=\"0.005416666666666667\" CDelta=\"11.527\" Schedulable=\"true\" ResponseTime=\"0.201ms\"/>\n" +
		"<TASKSCHED TaskRef=\"timeSlow\" Utilization=\"3.0E-4\" CDelta=\"96.44\" Schedulable=\"true\" ResponseTime=\"0.231ms\"/>\n" +
		"<TASKSCHED TaskRef=\"startup\" Utilization=\"4.4999999999999996E-5\" CDelta=\"964.745\" Schedulable=\"true\" ResponseTime=\"0.276ms\"/>\n" +
		"</SCHEDULINGSCENARIO>\n" +
		"</SCHEDULABILITY>\n" +
		"</SYSTEM>\n"
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

	
	
	@Test
	public void testPrepareData1a() throws IOException {
		IVarTree vt =Vt2StringUtilities.loadString(example1[0]);
		
		System.out.println(Vt2StringUtilities.varTreeToStringErtd(vt));
		
		MultiFrameTaskSchedulability test = (new JScanImplTest()).prepareMultiFrameTest(vt, Search.systemName(vt), null);

		int[][] every = new int[][] {
				{1,1},
				{1,1,1,1,1,1,1},
				{1},
				{1,1},
				{1},
				{1}
		};

		doTest(test, every, null, null);

	}

	@Test
	public void test1a() throws IOException {
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
		
		if (ENABLE_DEBUG) {
			System.out.println(report + "\n" + report2 + Vt2StringUtilities.varTreeToStringRtd(vt));
			System.out.println(Vt2StringUtilities.varTreeToStringErtd(Vt2StringUtilities.loadString(example1[1])));
		}	
		
		check(vt, Vt2StringUtilities.loadString(example1[1]));
	}
	
	
	@Test
	public void testPrepareData1b() throws IOException {
		IVarTree vt =Vt2StringUtilities.loadString(example1b[0]);
		
		System.out.println(Vt2StringUtilities.varTreeToStringErtd(vt));
		
		MultiFrameTaskSchedulability test = (new JScanImplTest()).prepareMultiFrameTest(vt, Search.systemName(vt), null);

		int[][] every = new int[][] {
				{1,1},
				{1,1,3,1,1,1,1},
				{1},
				{1,5},
				{1},
				{1}
		};

		doTest(test, every, null, null);

	}

	@Test
	public void test1b() throws IOException {
		IVarTree vt =Vt2StringUtilities.loadString(example1b[0]);
		
		String system = (vt.newTreeInterface()).getAllName(null, "System")[0];

		
		String report = JScan.startTest(vt, system, JScan.MULTIFRAME_FP_ID, null);
		String report2 = JScan.startTest(vt, system, JScan.NO_OFFSET_ID, null);
		
		vt.newTreeInterface().setValue(system+IVarTree.SEPARATOR
				+"Schedulability"+IVarTree.SEPARATOR
				+"SchedulingScenarioList"+IVarTree.SEPARATOR
				+DataPath.makeSlashedId((String)null)+IVarTree.SEPARATOR
				+"Reports"+IVarTree.SEPARATOR
				, (IVariable) null);
		
		if (ENABLE_DEBUG) {
			System.out.println(report + "\n" + report2 + Vt2StringUtilities.varTreeToStringRtd(vt));
			System.out.println(Vt2StringUtilities.varTreeToStringErtd(Vt2StringUtilities.loadString(example1b[1])));
		}			
		check(vt, Vt2StringUtilities.loadString(example1b[1]));
	}
	
	@Test
	public void testPrepareData1c() throws IOException {
		IVarTree vt =Vt2StringUtilities.loadString(example1c[0]);
		
		System.out.println(Vt2StringUtilities.varTreeToStringErtd(vt));
		
		MultiFrameTaskSchedulability test = (new JScanImplTest()).prepareMultiFrameTest(vt, Search.systemName(vt), null);

		int[][] every = new int[][] {
				{1,1},
				{1,1,3,1,1,1,1},
				{1},
				{1,1},
				{1},
				{1}
		};

		doTest(test, every, null, null);

	}

	@Test
	public void test1c() throws IOException {
		IVarTree vt =Vt2StringUtilities.loadString(example1c[0]);
		
		String system = (vt.newTreeInterface()).getAllName(null, "System")[0];

		
		String report = JScan.startTest(vt, system, JScan.MULTIFRAME_FP_ID, null);
		String report2 = JScan.startTest(vt, system, JScan.NO_OFFSET_ID, null);
		
		vt.newTreeInterface().setValue(system+IVarTree.SEPARATOR
				+"Schedulability"+IVarTree.SEPARATOR
				+"SchedulingScenarioList"+IVarTree.SEPARATOR
				+DataPath.makeSlashedId((String)null)+IVarTree.SEPARATOR
				+"Reports"+IVarTree.SEPARATOR
				, (IVariable) null);
		
		if (ENABLE_DEBUG) {
			System.out.println(report + "\n" + report2 + Vt2StringUtilities.varTreeToStringRtd(vt));
			System.out.println(Vt2StringUtilities.varTreeToStringErtd(Vt2StringUtilities.loadString(example1b[1])));
		}
		
		check(vt, Vt2StringUtilities.loadString(example1c[1]));
	}
	
	@Test
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

		
		doTest(test, every, wcets, null);

	}

	@Test
	public void test2() throws IOException {
		IVarTree vt =Vt2StringUtilities.loadString(example2[0]);
		
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
		
		System.out.println("___\n" + rep + "\n\n" + Vt2StringUtilities.varTreeToStringRtd(vt));
		
		
		
		// internal check
		
		int[][] every = new int[][] {
				{1,2},
				{1}
		};
		double response[] = new double[] {2,6};
		assertTrue(options.containsKey(JScanImpl.EXPORT_SCHEDULING_DATA));
		assertTrue(options.get(JScanImpl.EXPORT_SCHEDULING_DATA) instanceof ArrayList);
		
		@SuppressWarnings("unchecked")
		ArrayList<Schedulability> schedulers = (ArrayList<Schedulability>) options.get(JScanImpl.EXPORT_SCHEDULING_DATA);
		assertEquals(schedulers.size() , 1);
		Schedulability sched = schedulers.get(0);
		assertTrue(sched instanceof MultiFrameTaskSchedulability);
		
		doTest(sched, every, null, response);
	}

	@Test
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
		assertEquals(1, schedulers.size());
		Schedulability sched = schedulers.get(0);
		assertTrue(sched instanceof MultiFrameTaskSchedulability);
		
		doTest(sched, null, null, response);

	}

	

	/**
	 * @param test
	 * @param every
	 * @param wcets
	 */
	protected void doTest(Schedulability test, int[][] every, int[][] wcets, double response[]) {
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

		          if (every != null) {
		        	  @SuppressWarnings("unchecked")
			          ArrayList<Task.ProcData>  plist = (ArrayList<Task.ProcData>)proc_list;
			          assertEquals(plist.size() , every[i].length);
			          for (int k=0; k<plist.size(); k++) {
			        	  assertEquals("i= " + i + " ,k= " + k, every[i][k] , plist.get(k).getOnceEveryK());
			          }
		          }
		          
		          if (wcets != null) {
		        	  IGeneralMultiframeTaskWcet gwcet = (IGeneralMultiframeTaskWcet) gen_wcet;
		        	  double tot = 0;
		        	  for (int k=0; k<wcets[i].length; k++) {
		        		  System.out.println(".. k " + k + " " + wcets[i][k] + " -> " + gwcet.getWcet(k+1) + "(" + gwcet.getCumulativeWcet(k+1) + ")");
		        		  assertEquals(wcets[i][k] , gwcet.getWcet(k+1), 0.001);
		        		  tot += wcets[i][k];

		        		  assertEquals(tot , gwcet.getCumulativeWcet(k+1), 0.001);
		        	  }
		          }
		          
		          if (response != null) {
		        	  assertEquals(("" + response[i]), t.getProperty(Task.STR_RESPONSE_TIME));
		          }
		          
		      }
		}
	}
	
}

