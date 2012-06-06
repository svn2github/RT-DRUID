package com.eu.evidence.rtdruid.test.modules.jscan.common;

import java.io.IOException;
import java.util.List;

import junit.framework.TestCase;

import com.eu.evidence.rtdruid.internal.modules.jscan.CompleteTest1;
import com.eu.evidence.rtdruid.internal.modules.jscan.partialorder.PartialOrderChecker;
import com.eu.evidence.rtdruid.internal.modules.jscan.partialorder.PartialOrderData;
import com.eu.evidence.rtdruid.internal.modules.jscan.partialorder.ProcData;
import com.eu.evidence.rtdruid.internal.modules.jscan.partialorder.StandarOutputReporter;
import com.eu.evidence.rtdruid.internal.modules.jscan.partialorder.TaskData;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.Vt2StringUtilities;


public class PartialOrderDataTest extends TestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		System.out.println("\n\n************\n TEST " + getClass().getName() + " - " + getName() + "\n************\n\n");
	}
	
	private final static String test_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+
			"<!DOCTYPE SYSTEM SYSTEM \"evidence_0.2.dtd\">\n"+
			"<SYSTEM xmlns:rtdruid.vartree.data=\"http://rtdruid.vartree.data\" Name=\"NominalSA_Context\">\n"+
			"<FUNCTIONAL>\n"+
			"<EVENT Name=\"AcceptSpeed.act\" Type=\"activation\" MethodRefName=\"AcceptSpeed/AcceptSpeed.trigger\"/>\n"+
			"<EVENT Name=\"SpeedController_doSpeedViolationControl.begin\" Type=\"begin\" MethodRefName=\"SpeedController_doSpeedViolationControl/SpeedController_doSpeedViolationControl.SpeedController_doSpeedViolationControl\"/>\n"+
			"<EVENT Name=\"SpeedController_writeOnPortSpeedViolation.begin\" Type=\"begin\" MethodRefName=\"SpeedController_writeOnPortSpeedViolation/SpeedController_writeOnPortSpeedViolation.SpeedController_writeOnPortSpeedViolation\"/>\n"+
			"<EVENT Name=\"UserInterface_displayOnSpeedViolation.begin\" Type=\"begin\" MethodRefName=\"UserInterface_displayOnSpeedViolation/UserInterface_displayOnSpeedViolation.UserInterface_displayOnSpeedViolation\"/>\n"+
			"<EVENT Name=\"SpeedController_doSpeedViolationControl.end\" Type=\"end\" MethodRefName=\"SpeedController_doSpeedViolationControl/SpeedController_doSpeedViolationControl.SpeedController_doSpeedViolationControl\"/>\n"+
			"<EVENT Name=\"SpeedController_writeOnPortSpeedViolation.end\" Type=\"end\" MethodRefName=\"SpeedController_writeOnPortSpeedViolation/SpeedController_writeOnPortSpeedViolation.SpeedController_writeOnPortSpeedViolation\"/>\n"+
			"<EVENT Name=\"UserInterface_displayOnSpeedViolation.end\" Type=\"end\" MethodRefName=\"UserInterface_displayOnSpeedViolation/UserInterface_displayOnSpeedViolation.UserInterface_displayOnSpeedViolation\"/>\n"+
			"<EVENT Name=\"AcceptPosition.act\" Type=\"activation\" MethodRefName=\"AcceptPosition/AcceptPosition.trigger\"/>\n"+
			"<EVENT Name=\"SpeedController_setPosition.begin\" Type=\"begin\" MethodRefName=\"SpeedController_setPosition/SpeedController_setPosition.SpeedController_setPosition\"/>\n"+
			"<EVENT Name=\"OffRouteDetector_doOffRouteDetection.begin\" Type=\"begin\" MethodRefName=\"OffRouteDetector_doOffRouteDetection/OffRouteDetector_doOffRouteDetection.OffRouteDetector_doOffRouteDetection\"/>\n"+
			"<EVENT Name=\"ManoeuvrePointDetector_writeOnPortOnMP.begin\" Type=\"begin\" MethodRefName=\"ManoeuvrePointDetector_writeOnPortOnMP/ManoeuvrePointDetector_writeOnPortOnMP.ManoeuvrePointDetector_writeOnPortOnMP\"/>\n"+
			"<EVENT Name=\"RouteDataManager_computeNextRouteSection.begin\" Type=\"begin\" MethodRefName=\"RouteDataManager_computeNextRouteSection/RouteDataManager_computeNextRouteSection.RouteDataManager_computeNextRouteSection\"/>\n"+
			"<EVENT Name=\"OffRouteDetector_writeOnPortOffRoute.begin\" Type=\"begin\" MethodRefName=\"OffRouteDetector_writeOnPortOffRoute/OffRouteDetector_writeOnPortOffRoute.OffRouteDetector_writeOnPortOffRoute\"/>\n"+
			"<EVENT Name=\"OffRouteDetector_setRouteSection.begin\" Type=\"begin\" MethodRefName=\"OffRouteDetector_setRouteSection/OffRouteDetector_setRouteSection.OffRouteDetector_setRouteSection\"/>\n"+
			"<EVENT Name=\"ManoeuvrePointDetector_setRouteSection.begin\" Type=\"begin\" MethodRefName=\"ManoeuvrePointDetector_setRouteSection/ManoeuvrePointDetector_setRouteSection.ManoeuvrePointDetector_setRouteSection\"/>\n"+
			"<EVENT Name=\"ManoeuvrePointDetector_doManoeuvrePointDetection.begin\" Type=\"begin\" MethodRefName=\"ManoeuvrePointDetector_doManoeuvrePointDetection/ManoeuvrePointDetector_doManoeuvrePointDetection.ManoeuvrePointDetector_doManoeuvrePointDetection\"/>\n"+
			"<EVENT Name=\"UserInterface_displayOnMP.begin\" Type=\"begin\" MethodRefName=\"UserInterface_displayOnMP/UserInterface_displayOnMP.UserInterface_displayOnMP\"/>\n"+
			"<EVENT Name=\"SpeedController_setRouteSection.begin\" Type=\"begin\" MethodRefName=\"SpeedController_setRouteSection/SpeedController_setRouteSection.SpeedController_setRouteSection\"/>\n"+
			"<EVENT Name=\"SpeedController_setPosition.end\" Type=\"end\" MethodRefName=\"SpeedController_setPosition/SpeedController_setPosition.SpeedController_setPosition\"/>\n"+
			"<EVENT Name=\"OffRouteDetector_doOffRouteDetection.end\" Type=\"end\" MethodRefName=\"OffRouteDetector_doOffRouteDetection/OffRouteDetector_doOffRouteDetection.OffRouteDetector_doOffRouteDetection\"/>\n"+
			"<EVENT Name=\"ManoeuvrePointDetector_writeOnPortOnMP.end\" Type=\"end\" MethodRefName=\"ManoeuvrePointDetector_writeOnPortOnMP/ManoeuvrePointDetector_writeOnPortOnMP.ManoeuvrePointDetector_writeOnPortOnMP\"/>\n"+
			"<EVENT Name=\"RouteDataManager_computeNextRouteSection.end\" Type=\"end\" MethodRefName=\"RouteDataManager_computeNextRouteSection/RouteDataManager_computeNextRouteSection.RouteDataManager_computeNextRouteSection\"/>\n"+
			"<EVENT Name=\"OffRouteDetector_writeOnPortOffRoute.end\" Type=\"end\" MethodRefName=\"OffRouteDetector_writeOnPortOffRoute/OffRouteDetector_writeOnPortOffRoute.OffRouteDetector_writeOnPortOffRoute\"/>\n"+
			"<EVENT Name=\"OffRouteDetector_setRouteSection.end\" Type=\"end\" MethodRefName=\"OffRouteDetector_setRouteSection/OffRouteDetector_setRouteSection.OffRouteDetector_setRouteSection\"/>\n"+
			"<EVENT Name=\"ManoeuvrePointDetector_setRouteSection.end\" Type=\"end\" MethodRefName=\"ManoeuvrePointDetector_setRouteSection/ManoeuvrePointDetector_setRouteSection.ManoeuvrePointDetector_setRouteSection\"/>\n"+
			"<EVENT Name=\"ManoeuvrePointDetector_doManoeuvrePointDetection.end\" Type=\"end\" MethodRefName=\"ManoeuvrePointDetector_doManoeuvrePointDetection/ManoeuvrePointDetector_doManoeuvrePointDetection.ManoeuvrePointDetector_doManoeuvrePointDetection\"/>\n"+
			"<EVENT Name=\"UserInterface_displayOnMP.end\" Type=\"end\" MethodRefName=\"UserInterface_displayOnMP/UserInterface_displayOnMP.UserInterface_displayOnMP\"/>\n"+
			"<EVENT Name=\"SpeedController_setRouteSection.end\" Type=\"end\" MethodRefName=\"SpeedController_setRouteSection/SpeedController_setRouteSection.SpeedController_setRouteSection\"/>\n"+
			"<PARTIALORDER>\n"+
			"<ORDER>\n"+
			"<EVENTREF Name=\"SpeedController_doSpeedViolationControl.begin\"/>\n"+
			"<EVENTREF Name=\"SpeedController_doSpeedViolationControl.end\"/>\n"+
			"</ORDER>\n"+
			"<ORDER>\n"+
			"<EVENTREF Name=\"SpeedController_writeOnPortSpeedViolation.begin\"/>\n"+
			"<EVENTREF Name=\"SpeedController_writeOnPortSpeedViolation.end\"/>\n"+
			"</ORDER>\n"+
			"<ORDER>\n"+
			"<EVENTREF Name=\"UserInterface_displayOnSpeedViolation.begin\"/>\n"+
			"<EVENTREF Name=\"UserInterface_displayOnSpeedViolation.end\"/>\n"+
			"</ORDER>\n"+
			"<ORDER>\n"+
			"<EVENTREF Name=\"SpeedController_doSpeedViolationControl.end\"/>\n"+
			"<EVENTREF Name=\"SpeedController_writeOnPortSpeedViolation.begin\"/>\n"+
			"</ORDER>\n"+
			"<ORDER>\n"+
			"<EVENTREF Name=\"SpeedController_writeOnPortSpeedViolation.end\"/>\n"+
			"<EVENTREF Name=\"UserInterface_displayOnSpeedViolation.begin\"/>\n"+
			"</ORDER>\n"+
			"<ORDER>\n"+
			"<EVENTREF Name=\"AcceptSpeed.act\"/>\n"+
			"<EVENTREF Name=\"SpeedController_doSpeedViolationControl.begin\"/>\n"+
			"</ORDER>\n"+
			"</PARTIALORDER>\n"+
			"<PROC Name=\"SpeedController_writeOnPortSpeedViolation\">\n"+
			"<METHOD Name=\"SpeedController_writeOnPortSpeedViolation\"/>\n"+
			"<METHODREF Name=\"SpeedController_writeOnPortSpeedViolation.SpeedController_writeOnPortSpeedViolation\" MethodName=\"SpeedController_writeOnPortSpeedViolation/SpeedController_writeOnPortSpeedViolation\"/>\n"+
			"</PROC>\n"+
			"<PROC Name=\"UserInterface_displayOnSpeedViolation\">\n"+
			"<METHOD Name=\"UserInterface_displayOnSpeedViolation\"/>\n"+
			"<METHODREF Name=\"UserInterface_displayOnSpeedViolation.UserInterface_displayOnSpeedViolation\" MethodName=\"UserInterface_displayOnSpeedViolation/UserInterface_displayOnSpeedViolation\"/>\n"+
			"</PROC>\n"+
			"<PROC Name=\"SpeedController_doSpeedViolationControl\">\n"+
			"<METHOD Name=\"SpeedController_doSpeedViolationControl\"/>\n"+
			"<METHODREF Name=\"SpeedController_doSpeedViolationControl.SpeedController_doSpeedViolationControl\" MethodName=\"SpeedController_doSpeedViolationControl/SpeedController_doSpeedViolationControl\"/>\n"+
			"</PROC>\n"+
			"<PROC Name=\"OffRouteDetector_writeOnPortOffRoute\">\n"+
			"<METHOD Name=\"OffRouteDetector_writeOnPortOffRoute\"/>\n"+
			"<METHODREF Name=\"OffRouteDetector_writeOnPortOffRoute.OffRouteDetector_writeOnPortOffRoute\" MethodName=\"OffRouteDetector_writeOnPortOffRoute/OffRouteDetector_writeOnPortOffRoute\"/>\n"+
			"</PROC>\n"+
			"<PROC Name=\"RouteDataManager_computeNextRouteSection\">\n"+
			"<METHOD Name=\"RouteDataManager_computeNextRouteSection\"/>\n"+
			"<METHODREF Name=\"RouteDataManager_computeNextRouteSection.RouteDataManager_computeNextRouteSection\" MethodName=\"RouteDataManager_computeNextRouteSection/RouteDataManager_computeNextRouteSection\"/>\n"+
			"</PROC>\n"+
			"<PROC Name=\"OffRouteDetector_doOffRouteDetection\">\n"+
			"<METHOD Name=\"OffRouteDetector_doOffRouteDetection\"/>\n"+
			"<METHODREF Name=\"OffRouteDetector_doOffRouteDetection.OffRouteDetector_doOffRouteDetection\" MethodName=\"OffRouteDetector_doOffRouteDetection/OffRouteDetector_doOffRouteDetection\"/>\n"+
			"</PROC>\n"+
			"<PROC Name=\"ManoeuvrePointDetector_writeOnPortOnMP\">\n"+
			"<METHOD Name=\"ManoeuvrePointDetector_writeOnPortOnMP\"/>\n"+
			"<METHODREF Name=\"ManoeuvrePointDetector_writeOnPortOnMP.ManoeuvrePointDetector_writeOnPortOnMP\" MethodName=\"ManoeuvrePointDetector_writeOnPortOnMP/ManoeuvrePointDetector_writeOnPortOnMP\"/>\n"+
			"</PROC>\n"+
			"<PROC Name=\"ManoeuvrePointDetector_setRouteSection\">\n"+
			"<METHOD Name=\"ManoeuvrePointDetector_setRouteSection\"/>\n"+
			"<METHODREF Name=\"ManoeuvrePointDetector_setRouteSection.ManoeuvrePointDetector_setRouteSection\" MethodName=\"ManoeuvrePointDetector_setRouteSection/ManoeuvrePointDetector_setRouteSection\"/>\n"+
			"</PROC>\n"+
			"<PROC Name=\"OffRouteDetector_setRouteSection\">\n"+
			"<METHOD Name=\"OffRouteDetector_setRouteSection\"/>\n"+
			"<METHODREF Name=\"OffRouteDetector_setRouteSection.OffRouteDetector_setRouteSection\" MethodName=\"OffRouteDetector_setRouteSection/OffRouteDetector_setRouteSection\"/>\n"+
			"</PROC>\n"+
			"<PROC Name=\"UserInterface_displayOnMP\">\n"+
			"<METHOD Name=\"UserInterface_displayOnMP\"/>\n"+
			"<METHODREF Name=\"UserInterface_displayOnMP.UserInterface_displayOnMP\" MethodName=\"UserInterface_displayOnMP/UserInterface_displayOnMP\"/>\n"+
			"</PROC>\n"+
			"<PROC Name=\"ManoeuvrePointDetector_doManoeuvrePointDetection\">\n"+
			"<METHOD Name=\"ManoeuvrePointDetector_doManoeuvrePointDetection\"/>\n"+
			"<METHODREF Name=\"ManoeuvrePointDetector_doManoeuvrePointDetection.ManoeuvrePointDetector_doManoeuvrePointDetection\" MethodName=\"ManoeuvrePointDetector_doManoeuvrePointDetection/ManoeuvrePointDetector_doManoeuvrePointDetection\"/>\n"+
			"</PROC>\n"+
			"<PROC Name=\"SpeedController_setRouteSection\">\n"+
			"<METHOD Name=\"SpeedController_setRouteSection\"/>\n"+
			"<METHODREF Name=\"SpeedController_setRouteSection.SpeedController_setRouteSection\" MethodName=\"SpeedController_setRouteSection/SpeedController_setRouteSection\"/>\n"+
			"</PROC>\n"+
			"<PROC Name=\"SpeedController_setPosition\">\n"+
			"<METHOD Name=\"SpeedController_setPosition\"/>\n"+
			"<METHODREF Name=\"SpeedController_setPosition.SpeedController_setPosition\" MethodName=\"SpeedController_setPosition/SpeedController_setPosition\"/>\n"+
			"</PROC>\n"+
			"<TRIGGER Name=\"AcceptSpeed\">\n"+
			"<METHODREF Name=\"AcceptSpeed.trigger\" MethodName=\"SpeedController_doSpeedViolationControl/SpeedController_doSpeedViolationControl\"/>\n"+
			"</TRIGGER>\n"+
			"<TRIGGER Name=\"AcceptPosition\">\n"+
			"<METHODREF Name=\"AcceptPosition.trigger\" MethodName=\"SpeedController_setPosition/SpeedController_setPosition\"/>\n"+
			"</TRIGGER>\n"+
			"</FUNCTIONAL>\n"+
			"<ARCHITECTURAL>\n"+
			"<ECU Name=\"cpu\">\n"+
			"<CPU Name=\"cpuCpu\">\n"+
			"<RTOS Name=\"cpuRtos\"/>\n"+
			"</CPU>\n"+
			"</ECU>\n"+
			"<TASK Name=\"task1\" Type=\"task\">\n"+
			"<SCHEDULING Priority=\"10\"/>\n"+
			"<ACTIVATION Deadline=\"64.0ms\" Period=\"64.0ms\" Type=\"periodic\"/>\n"+
			"</TASK>\n"+
			"<TASK Name=\"task2\" Type=\"task\">\n"+
			"<SCHEDULING Priority=\"10\"/>\n"+
			"<ACTIVATION Deadline=\"64.0ms\" Period=\"64.0ms\" Type=\"periodic\"/>\n"+
			"</TASK>\n"+
			"<TASK Name=\"task3\" Type=\"task\">\n"+
			"<SCHEDULING Priority=\"10\"/>\n"+
			"<ACTIVATION Deadline=\"100.0ms\" Period=\"100.0ms\" Type=\"periodic\"/>\n"+
			"</TASK>\n"+
			"<TASK Name=\"task4\" Type=\"task\">\n"+
			"<SCHEDULING Priority=\"10\"/>\n"+
			"<ACTIVATION Deadline=\"64.0ms\" Period=\"64.0ms\" Type=\"periodic\"/>\n"+
			"</TASK>\n"+
			"<TASK Name=\"task5\" Type=\"task\">\n"+
			"<SCHEDULING Priority=\"20\"/>\n"+
			"<ACTIVATION Deadline=\"100.0ms\" Period=\"100.0ms\" Type=\"periodic\"/>\n"+
			"</TASK>\n"+
			"</ARCHITECTURAL>\n"+
			"<MAPPING>\n"+
			"<PROCMAP ProcRef=\"OffRouteDetector_doOffRouteDetection\" TaskRef=\"task1\"/>\n"+
			"<PROCMAP ProcRef=\"OffRouteDetector_setRouteSection\" TaskRef=\"task1\"/>\n"+
			"<PROCMAP ProcRef=\"ManoeuvrePointDetector_doManoeuvrePointDetection\" TaskRef=\"task2\"/>\n"+
			"<PROCMAP ProcRef=\"ManoeuvrePointDetector_writeOnPortOnMP\" TaskRef=\"task2\"/>\n"+
			"<PROCMAP ProcRef=\"ManoeuvrePointDetector_setRouteSection\" TaskRef=\"task2\"/>\n"+
			"<PROCMAP ProcRef=\"SpeedController_doSpeedViolationControl\" TaskRef=\"task3\"/>\n"+
			"<PROCMAP ProcRef=\"SpeedController_writeOnPortSpeedViolation\" TaskRef=\"task3\"/>\n"+
			"<PROCMAP ProcRef=\"SpeedController_setPosition\" TaskRef=\"task3\"/>\n"+
			"<PROCMAP ProcRef=\"SpeedController_setRouteSection\" TaskRef=\"task3\"/>\n"+
			"<PROCMAP ProcRef=\"RouteDataManager_computeNextRouteSection\" TaskRef=\"task4\"/>\n"+
			"<PROCMAP ProcRef=\"OffRouteDetector_writeOnPortOffRoute\" TaskRef=\"task4\"/>\n"+
			"<PROCMAP ProcRef=\"UserInterface_displayOnSpeedViolation\" TaskRef=\"task5\"/>\n"+
			"<PROCMAP ProcRef=\"UserInterface_displayOnMP\" TaskRef=\"task5\"/>\n"+
			"<TASKMAP rtosRef=\"cpuRtos\" TaskRef=\"task1\"/>\n"+
			"<TASKMAP rtosRef=\"cpuRtos\" TaskRef=\"task2\"/>\n"+
			"<TASKMAP rtosRef=\"cpuRtos\" TaskRef=\"task3\"/>\n"+
			"<TASKMAP rtosRef=\"cpuRtos\" TaskRef=\"task4\"/>\n"+
			"<TASKMAP rtosRef=\"cpuRtos\" TaskRef=\"task5\"/>\n"+
			"</MAPPING>\n"+
			"<ANNOTATION>\n"+
			"<EXECTIME Type=\"PROC\" Ref=\"SpeedController_doSpeedViolationControl\">\n"+
			"<WORST Value=\"5.0ms\"/>\n"+
			"</EXECTIME>\n"+
			"<EXECTIME Type=\"PROC\" Ref=\"SpeedController_writeOnPortSpeedViolation\">\n"+
			"<WORST Value=\"7.0ms\"/>\n"+
			"</EXECTIME>\n"+
			"<EXECTIME Type=\"PROC\" Ref=\"UserInterface_displayOnSpeedViolation\">\n"+
			"<WORST Value=\"5.0ms\"/>\n"+
			"</EXECTIME>\n"+
			"<EXECTIME Type=\"PROC\" Ref=\"ManoeuvrePointDetector_doManoeuvrePointDetection\">\n"+
			"<WORST Value=\"5.0ms\"/>\n"+
			"</EXECTIME>\n"+
			"<EXECTIME Type=\"PROC\" Ref=\"ManoeuvrePointDetector_writeOnPortOnMP\">\n"+
			"<WORST Value=\"7.0ms\"/>\n"+
			"</EXECTIME>\n"+
			"<EXECTIME Type=\"PROC\" Ref=\"SpeedController_setPosition\">\n"+
			"<WORST Value=\"5.0ms\"/>\n"+
			"</EXECTIME>\n"+
			"<EXECTIME Type=\"PROC\" Ref=\"OffRouteDetector_doOffRouteDetection\">\n"+
			"<WORST Value=\"5.0ms\"/>\n"+
			"</EXECTIME>\n"+
			"<EXECTIME Type=\"PROC\" Ref=\"RouteDataManager_computeNextRouteSection\">\n"+
			"<WORST Value=\"5.0ms\"/>\n"+
			"</EXECTIME>\n"+
			"<EXECTIME Type=\"PROC\" Ref=\"OffRouteDetector_writeOnPortOffRoute\">\n"+
			"<WORST Value=\"5.0ms\"/>\n"+
			"</EXECTIME>\n"+
			"<EXECTIME Type=\"PROC\" Ref=\"UserInterface_displayOnMP\">\n"+
			"<WORST Value=\"5.0ms\"/>\n"+
			"</EXECTIME>\n"+
			"<EXECTIME Type=\"PROC\" Ref=\"OffRouteDetector_setRouteSection\">\n"+
			"<WORST Value=\"5.0ms\"/>\n"+
			"</EXECTIME>\n"+
			"<EXECTIME Type=\"PROC\" Ref=\"ManoeuvrePointDetector_setRouteSection\">\n"+
			"<WORST Value=\"5.0ms\"/>\n"+
			"</EXECTIME>\n"+
			"<EXECTIME Type=\"PROC\" Ref=\"SpeedController_setRouteSection\">\n"+
			"<WORST Value=\"5.0ms\"/>\n"+
			"</EXECTIME>\n"+
			"<!--\n"+
			"	<EXECTIME Type=\"TASK\" Ref=\"task1\"/>\n"+
			"	<EXECTIME Type=\"TASK\" Ref=\"task2\"/>\n"+
			"	<EXECTIME Type=\"TASK\" Ref=\"task3\"/>\n"+
			"	<EXECTIME Type=\"TASK\" Ref=\"task4\"/>\n"+
			"	<EXECTIME Type=\"TASK\" Ref=\"task5\"/>\n"+
			"-->\n"+
			"</ANNOTATION>\n"+
			"<SCHEDULABILITY>\n"+
			"<SCHEDULINGSCENARIO>\n"+
			"<CPUSCHED CpuRef=\"cpuRtos\"/>\n"+
			"</SCHEDULINGSCENARIO>\n"+
			"</SCHEDULABILITY>\n"+
			"</SYSTEM>";

	private final static String test_2 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+
		"<!DOCTYPE SYSTEM SYSTEM \"evidence_0.2.dtd\">\n"+
		"<SYSTEM xmlns:rtdruid.vartree.data=\"http://rtdruid.vartree.data\" Name=\"NominalSA_Context\">\n"+
		"<FUNCTIONAL>\n"+
		"<EVENT Name=\"AcceptSpeed.act\" Type=\"activation\" MethodRefName=\"AcceptSpeed/AcceptSpeed.trigger\"/>\n"+
		"<EVENT Name=\"SpeedController_doSpeedViolationControl.begin\" Type=\"begin\" MethodRefName=\"SpeedController_doSpeedViolationControl/SpeedController_doSpeedViolationControl.SpeedController_doSpeedViolationControl\"/>\n"+
		"<EVENT Name=\"SpeedController_writeOnPortSpeedViolation.begin\" Type=\"begin\" MethodRefName=\"SpeedController_writeOnPortSpeedViolation/SpeedController_writeOnPortSpeedViolation.SpeedController_writeOnPortSpeedViolation\"/>\n"+
		"<EVENT Name=\"UserInterface_displayOnSpeedViolation.begin\" Type=\"begin\" MethodRefName=\"UserInterface_displayOnSpeedViolation/UserInterface_displayOnSpeedViolation.UserInterface_displayOnSpeedViolation\"/>\n"+
		"<EVENT Name=\"SpeedController_doSpeedViolationControl.end\" Type=\"end\" MethodRefName=\"SpeedController_doSpeedViolationControl/SpeedController_doSpeedViolationControl.SpeedController_doSpeedViolationControl\"/>\n"+
		"<EVENT Name=\"SpeedController_writeOnPortSpeedViolation.end\" Type=\"end\" MethodRefName=\"SpeedController_writeOnPortSpeedViolation/SpeedController_writeOnPortSpeedViolation.SpeedController_writeOnPortSpeedViolation\"/>\n"+
		"<EVENT Name=\"UserInterface_displayOnSpeedViolation.end\" Type=\"end\" MethodRefName=\"UserInterface_displayOnSpeedViolation/UserInterface_displayOnSpeedViolation.UserInterface_displayOnSpeedViolation\"/>\n"+
		"<EVENT Name=\"AcceptPosition.act\" Type=\"activation\" MethodRefName=\"AcceptPosition/AcceptPosition.trigger\"/>\n"+
		"<EVENT Name=\"SpeedController_setPosition.begin\" Type=\"begin\" MethodRefName=\"SpeedController_setPosition/SpeedController_setPosition.SpeedController_setPosition\"/>\n"+
		"<EVENT Name=\"OffRouteDetector_doOffRouteDetection.begin\" Type=\"begin\" MethodRefName=\"OffRouteDetector_doOffRouteDetection/OffRouteDetector_doOffRouteDetection.OffRouteDetector_doOffRouteDetection\"/>\n"+
		"<EVENT Name=\"ManoeuvrePointDetector_writeOnPortOnMP.begin\" Type=\"begin\" MethodRefName=\"ManoeuvrePointDetector_writeOnPortOnMP/ManoeuvrePointDetector_writeOnPortOnMP.ManoeuvrePointDetector_writeOnPortOnMP\"/>\n"+
		"<EVENT Name=\"RouteDataManager_computeNextRouteSection.begin\" Type=\"begin\" MethodRefName=\"RouteDataManager_computeNextRouteSection/RouteDataManager_computeNextRouteSection.RouteDataManager_computeNextRouteSection\"/>\n"+
		"<EVENT Name=\"OffRouteDetector_writeOnPortOffRoute.begin\" Type=\"begin\" MethodRefName=\"OffRouteDetector_writeOnPortOffRoute/OffRouteDetector_writeOnPortOffRoute.OffRouteDetector_writeOnPortOffRoute\"/>\n"+
		"<EVENT Name=\"OffRouteDetector_setRouteSection.begin\" Type=\"begin\" MethodRefName=\"OffRouteDetector_setRouteSection/OffRouteDetector_setRouteSection.OffRouteDetector_setRouteSection\"/>\n"+
		"<EVENT Name=\"ManoeuvrePointDetector_setRouteSection.begin\" Type=\"begin\" MethodRefName=\"ManoeuvrePointDetector_setRouteSection/ManoeuvrePointDetector_setRouteSection.ManoeuvrePointDetector_setRouteSection\"/>\n"+
		"<EVENT Name=\"ManoeuvrePointDetector_doManoeuvrePointDetection.begin\" Type=\"begin\" MethodRefName=\"ManoeuvrePointDetector_doManoeuvrePointDetection/ManoeuvrePointDetector_doManoeuvrePointDetection.ManoeuvrePointDetector_doManoeuvrePointDetection\"/>\n"+
		"<EVENT Name=\"UserInterface_displayOnMP.begin\" Type=\"begin\" MethodRefName=\"UserInterface_displayOnMP/UserInterface_displayOnMP.UserInterface_displayOnMP\"/>\n"+
		"<EVENT Name=\"SpeedController_setRouteSection.begin\" Type=\"begin\" MethodRefName=\"SpeedController_setRouteSection/SpeedController_setRouteSection.SpeedController_setRouteSection\"/>\n"+
		"<EVENT Name=\"SpeedController_setPosition.end\" Type=\"end\" MethodRefName=\"SpeedController_setPosition/SpeedController_setPosition.SpeedController_setPosition\"/>\n"+
		"<EVENT Name=\"OffRouteDetector_doOffRouteDetection.end\" Type=\"end\" MethodRefName=\"OffRouteDetector_doOffRouteDetection/OffRouteDetector_doOffRouteDetection.OffRouteDetector_doOffRouteDetection\"/>\n"+
		"<EVENT Name=\"ManoeuvrePointDetector_writeOnPortOnMP.end\" Type=\"end\" MethodRefName=\"ManoeuvrePointDetector_writeOnPortOnMP/ManoeuvrePointDetector_writeOnPortOnMP.ManoeuvrePointDetector_writeOnPortOnMP\"/>\n"+
		"<EVENT Name=\"RouteDataManager_computeNextRouteSection.end\" Type=\"end\" MethodRefName=\"RouteDataManager_computeNextRouteSection/RouteDataManager_computeNextRouteSection.RouteDataManager_computeNextRouteSection\"/>\n"+
		"<EVENT Name=\"OffRouteDetector_writeOnPortOffRoute.end\" Type=\"end\" MethodRefName=\"OffRouteDetector_writeOnPortOffRoute/OffRouteDetector_writeOnPortOffRoute.OffRouteDetector_writeOnPortOffRoute\"/>\n"+
		"<EVENT Name=\"OffRouteDetector_setRouteSection.end\" Type=\"end\" MethodRefName=\"OffRouteDetector_setRouteSection/OffRouteDetector_setRouteSection.OffRouteDetector_setRouteSection\"/>\n"+
		"<EVENT Name=\"ManoeuvrePointDetector_setRouteSection.end\" Type=\"end\" MethodRefName=\"ManoeuvrePointDetector_setRouteSection/ManoeuvrePointDetector_setRouteSection.ManoeuvrePointDetector_setRouteSection\"/>\n"+
		"<EVENT Name=\"ManoeuvrePointDetector_doManoeuvrePointDetection.end\" Type=\"end\" MethodRefName=\"ManoeuvrePointDetector_doManoeuvrePointDetection/ManoeuvrePointDetector_doManoeuvrePointDetection.ManoeuvrePointDetector_doManoeuvrePointDetection\"/>\n"+
		"<EVENT Name=\"UserInterface_displayOnMP.end\" Type=\"end\" MethodRefName=\"UserInterface_displayOnMP/UserInterface_displayOnMP.UserInterface_displayOnMP\"/>\n"+
		"<EVENT Name=\"SpeedController_setRouteSection.end\" Type=\"end\" MethodRefName=\"SpeedController_setRouteSection/SpeedController_setRouteSection.SpeedController_setRouteSection\"/>\n"+
		"<PARTIALORDER>\n"+
		"<ORDER>\n"+
		"<EVENTREF Name=\"SpeedController_doSpeedViolationControl.begin\"/>\n"+
		"<EVENTREF Name=\"SpeedController_doSpeedViolationControl.end\"/>\n"+
		"</ORDER>\n"+
		"<ORDER>\n"+
		"<EVENTREF Name=\"SpeedController_writeOnPortSpeedViolation.begin\"/>\n"+
		"<EVENTREF Name=\"SpeedController_writeOnPortSpeedViolation.end\"/>\n"+
		"</ORDER>\n"+
		"<ORDER>\n"+
		"<EVENTREF Name=\"UserInterface_displayOnSpeedViolation.begin\"/>\n"+
		"<EVENTREF Name=\"UserInterface_displayOnSpeedViolation.end\"/>\n"+
		"</ORDER>\n"+
		"<ORDER>\n"+
		"<EVENTREF Name=\"SpeedController_doSpeedViolationControl.end\"/>\n"+
		"<EVENTREF Name=\"SpeedController_writeOnPortSpeedViolation.begin\"/>\n"+
		"</ORDER>\n"+
		"<ORDER>\n"+
		"<EVENTREF Name=\"SpeedController_writeOnPortSpeedViolation.end\"/>\n"+
		"<EVENTREF Name=\"UserInterface_displayOnSpeedViolation.begin\"/>\n"+
		"</ORDER>\n"+
		"<ORDER>\n"+
		"<EVENTREF Name=\"AcceptSpeed.act\"/>\n"+
		"<EVENTREF Name=\"SpeedController_doSpeedViolationControl.begin\"/>\n"+
		"</ORDER>\n"+
		"</PARTIALORDER>\n"+
		"<PROC Name=\"SpeedController_writeOnPortSpeedViolation\">\n"+
		"<METHOD Name=\"SpeedController_writeOnPortSpeedViolation\"/>\n"+
		"<METHODREF Name=\"SpeedController_writeOnPortSpeedViolation.SpeedController_writeOnPortSpeedViolation\" MethodName=\"SpeedController_writeOnPortSpeedViolation/SpeedController_writeOnPortSpeedViolation\"/>\n"+
		"<METHODREF Name=\"SpeedController_writeOnPortSpeedViolation.UserInterface_displayOnSpeedViolation\" MethodName=\"UserInterface_displayOnSpeedViolation/UserInterface_displayOnSpeedViolation\"/>\n"+
		"</PROC>\n"+
		"<PROC Name=\"UserInterface_displayOnSpeedViolation\">\n"+
		"<METHOD Name=\"UserInterface_displayOnSpeedViolation\"/>\n"+
		"<METHODREF Name=\"UserInterface_displayOnSpeedViolation.UserInterface_displayOnSpeedViolation\" MethodName=\"UserInterface_displayOnSpeedViolation/UserInterface_displayOnSpeedViolation\"/>\n"+
		"</PROC>\n"+
		"<PROC Name=\"SpeedController_doSpeedViolationControl\">\n"+
		"<METHOD Name=\"SpeedController_doSpeedViolationControl\"/>\n"+
		"<METHODREF Name=\"SpeedController_doSpeedViolationControl.SpeedController_doSpeedViolationControl\" MethodName=\"SpeedController_doSpeedViolationControl/SpeedController_doSpeedViolationControl\"/>\n"+
		"<METHODREF Name=\"SpeedController_doSpeedViolationControl.SpeedController_writeOnPortSpeedViolation\" MethodName=\"SpeedController_writeOnPortSpeedViolation/SpeedController_writeOnPortSpeedViolation\"/>\n"+
		"</PROC>\n"+
		"<PROC Name=\"OffRouteDetector_writeOnPortOffRoute\">\n"+
		"<METHOD Name=\"OffRouteDetector_writeOnPortOffRoute\"/>\n"+
		"<METHODREF Name=\"OffRouteDetector_writeOnPortOffRoute.OffRouteDetector_writeOnPortOffRoute\" MethodName=\"OffRouteDetector_writeOnPortOffRoute/OffRouteDetector_writeOnPortOffRoute\"/>\n"+
		"</PROC>\n"+
		"<PROC Name=\"RouteDataManager_computeNextRouteSection\">\n"+
		"<METHOD Name=\"RouteDataManager_computeNextRouteSection\"/>\n"+
		"<METHODREF Name=\"RouteDataManager_computeNextRouteSection.RouteDataManager_computeNextRouteSection\" MethodName=\"RouteDataManager_computeNextRouteSection/RouteDataManager_computeNextRouteSection\"/>\n"+
		"</PROC>\n"+
		"<PROC Name=\"OffRouteDetector_doOffRouteDetection\">\n"+
		"<METHOD Name=\"OffRouteDetector_doOffRouteDetection\"/>\n"+
		"<METHODREF Name=\"OffRouteDetector_doOffRouteDetection.OffRouteDetector_doOffRouteDetection\" MethodName=\"OffRouteDetector_doOffRouteDetection/OffRouteDetector_doOffRouteDetection\"/>\n"+
		"</PROC>\n"+
		"<PROC Name=\"ManoeuvrePointDetector_writeOnPortOnMP\">\n"+
		"<METHOD Name=\"ManoeuvrePointDetector_writeOnPortOnMP\"/>\n"+
		"<METHODREF Name=\"ManoeuvrePointDetector_writeOnPortOnMP.ManoeuvrePointDetector_writeOnPortOnMP\" MethodName=\"ManoeuvrePointDetector_writeOnPortOnMP/ManoeuvrePointDetector_writeOnPortOnMP\"/>\n"+
		"</PROC>\n"+
		"<PROC Name=\"ManoeuvrePointDetector_setRouteSection\">\n"+
		"<METHOD Name=\"ManoeuvrePointDetector_setRouteSection\"/>\n"+
		"<METHODREF Name=\"ManoeuvrePointDetector_setRouteSection.ManoeuvrePointDetector_setRouteSection\" MethodName=\"ManoeuvrePointDetector_setRouteSection/ManoeuvrePointDetector_setRouteSection\"/>\n"+
		"</PROC>\n"+
		"<PROC Name=\"OffRouteDetector_setRouteSection\">\n"+
		"<METHOD Name=\"OffRouteDetector_setRouteSection\"/>\n"+
		"<METHODREF Name=\"OffRouteDetector_setRouteSection.OffRouteDetector_setRouteSection\" MethodName=\"OffRouteDetector_setRouteSection/OffRouteDetector_setRouteSection\"/>\n"+
		"</PROC>\n"+
		"<PROC Name=\"UserInterface_displayOnMP\">\n"+
		"<METHOD Name=\"UserInterface_displayOnMP\"/>\n"+
		"<METHODREF Name=\"UserInterface_displayOnMP.UserInterface_displayOnMP\" MethodName=\"UserInterface_displayOnMP/UserInterface_displayOnMP\"/>\n"+
		"</PROC>\n"+
		"<PROC Name=\"ManoeuvrePointDetector_doManoeuvrePointDetection\">\n"+
		"<METHOD Name=\"ManoeuvrePointDetector_doManoeuvrePointDetection\"/>\n"+
		"<METHODREF Name=\"ManoeuvrePointDetector_doManoeuvrePointDetection.ManoeuvrePointDetector_doManoeuvrePointDetection\" MethodName=\"ManoeuvrePointDetector_doManoeuvrePointDetection/ManoeuvrePointDetector_doManoeuvrePointDetection\"/>\n"+
		"</PROC>\n"+
		"<PROC Name=\"SpeedController_setRouteSection\">\n"+
		"<METHOD Name=\"SpeedController_setRouteSection\"/>\n"+
		"<METHODREF Name=\"SpeedController_setRouteSection.SpeedController_setRouteSection\" MethodName=\"SpeedController_setRouteSection/SpeedController_setRouteSection\"/>\n"+
		"</PROC>\n"+
		"<PROC Name=\"SpeedController_setPosition\">\n"+
		"<METHOD Name=\"SpeedController_setPosition\"/>\n"+
		"<METHODREF Name=\"SpeedController_setPosition.SpeedController_setPosition\" MethodName=\"SpeedController_setPosition/SpeedController_setPosition\"/>\n"+
		"<METHODREF Name=\"SpeedController_setPosition.SpeedController_setRouteSection\" MethodName=\"SpeedController_setRouteSection/SpeedController_setRouteSection\"/>\n"+
		"</PROC>\n"+
		"<TRIGGER Name=\"AcceptSpeed\">\n"+
		"<METHODREF Name=\"AcceptSpeed.trigger\" MethodName=\"SpeedController_doSpeedViolationControl/SpeedController_doSpeedViolationControl\"/>\n"+
		"</TRIGGER>\n"+
		"<TRIGGER Name=\"AcceptPosition\">\n"+
		"<METHODREF Name=\"AcceptPosition.trigger\" MethodName=\"SpeedController_setPosition/SpeedController_setPosition\"/>\n"+
		"</TRIGGER>\n"+
		
		"<TIMECONST>\n"+
			"<EVENTREF Name=\"AcceptSpeed.act\"/>\n"+
			"<BOUND Type=\"period\" Value=\"100ms\"/>\n"+
			"</TIMECONST>\n"+
		"<TIMECONST>\n"+
			"<EVENTREF Name=\"UserInterface_displayOnMP.begin\"/>\n"+
			"<BOUND Type=\"mit\" Value=\"400ms\"/>\n"+
			"</TIMECONST>\n"+
		"<TIMECONST>\n"+
			"<EVENTREF Name=\"SpeedController_setPosition.begin\"/>\n"+
			"<BOUND Type=\"period\" Value=\"200ms\"/>\n"+
			"</TIMECONST>\n"+

			
		"</FUNCTIONAL>\n"+
		"<ARCHITECTURAL>\n"+
		"<ECU Name=\"cpu\">\n"+
		"<CPU Name=\"cpuCpu\">\n"+
		"<RTOS Name=\"cpuRtos\"/>\n"+
		"</CPU>\n"+
		"</ECU>\n"+
		"<TASK Name=\"task1\" Type=\"task\">\n"+
		"<SCHEDULING Priority=\"10\"/>\n"+
		"<ACTIVATION Deadline=\"64.0ms\" Period=\"64.0ms\" Type=\"periodic\"/>\n"+
		"</TASK>\n"+
		"<TASK Name=\"task2\" Type=\"task\">\n"+
		"<SCHEDULING Priority=\"10\"/>\n"+
		"<ACTIVATION Deadline=\"64.0ms\" Period=\"64.0ms\" Type=\"periodic\"/>\n"+
		"</TASK>\n"+
		"<TASK Name=\"task3\" Type=\"task\">\n"+
		"<SCHEDULING Priority=\"10\"/>\n"+
		"<ACTIVATION Deadline=\"100.0ms\" Period=\"100.0ms\" Type=\"periodic\"/>\n"+
		"</TASK>\n"+
		"<TASK Name=\"task4\" Type=\"task\">\n"+
		"<SCHEDULING Priority=\"10\"/>\n"+
		"<ACTIVATION Deadline=\"64.0ms\" Period=\"64.0ms\" Type=\"periodic\"/>\n"+
		"</TASK>\n"+
		"<TASK Name=\"task5\" Type=\"task\">\n"+
		"<SCHEDULING Priority=\"20\"/>\n"+
		"<ACTIVATION Deadline=\"100.0ms\" Period=\"100.0ms\" Type=\"periodic\"/>\n"+
		"</TASK>\n"+
		"</ARCHITECTURAL>\n"+
		"<MAPPING>\n"+
		"<PROCMAP ProcRef=\"OffRouteDetector_doOffRouteDetection\" TaskRef=\"task1\"/>\n"+
		"<PROCMAP ProcRef=\"OffRouteDetector_setRouteSection\" TaskRef=\"task1\"/>\n"+
		"<PROCMAP ProcRef=\"ManoeuvrePointDetector_doManoeuvrePointDetection\" TaskRef=\"task2\"/>\n"+
		"<PROCMAP ProcRef=\"ManoeuvrePointDetector_writeOnPortOnMP\" TaskRef=\"task2\"/>\n"+
		"<PROCMAP ProcRef=\"ManoeuvrePointDetector_setRouteSection\" TaskRef=\"task2\"/>\n"+
		"<PROCMAP ProcRef=\"SpeedController_doSpeedViolationControl\" TaskRef=\"task3\"/>\n"+
		"<PROCMAP ProcRef=\"SpeedController_writeOnPortSpeedViolation\" TaskRef=\"task3\"/>\n"+
		"<PROCMAP ProcRef=\"SpeedController_setPosition\" TaskRef=\"task3\"/>\n"+
		"<PROCMAP ProcRef=\"SpeedController_setRouteSection\" TaskRef=\"task3\"/>\n"+
		"<PROCMAP ProcRef=\"RouteDataManager_computeNextRouteSection\" TaskRef=\"task4\"/>\n"+
		"<PROCMAP ProcRef=\"OffRouteDetector_writeOnPortOffRoute\" TaskRef=\"task4\"/>\n"+
		"<PROCMAP ProcRef=\"UserInterface_displayOnSpeedViolation\" TaskRef=\"task5\"/>\n"+
		"<PROCMAP ProcRef=\"UserInterface_displayOnMP\" TaskRef=\"task5\"/>\n"+
		"<TASKMAP rtosRef=\"cpuRtos\" TaskRef=\"task1\"/>\n"+
		"<TASKMAP rtosRef=\"cpuRtos\" TaskRef=\"task2\"/>\n"+
		"<TASKMAP rtosRef=\"cpuRtos\" TaskRef=\"task3\"/>\n"+
		"<TASKMAP rtosRef=\"cpuRtos\" TaskRef=\"task4\"/>\n"+
		"<TASKMAP rtosRef=\"cpuRtos\" TaskRef=\"task5\"/>\n"+
		"</MAPPING>\n"+
		"<ANNOTATION>\n"+
		"<EXECTIME Type=\"PROC\" Ref=\"SpeedController_doSpeedViolationControl\">\n"+
		"<WORST Value=\"5.0ms\"/>\n"+
		"</EXECTIME>\n"+
		"<EXECTIME Type=\"PROC\" Ref=\"SpeedController_writeOnPortSpeedViolation\">\n"+
		"<WORST Value=\"7.0ms\"/>\n"+
		"</EXECTIME>\n"+
		"<EXECTIME Type=\"PROC\" Ref=\"UserInterface_displayOnSpeedViolation\">\n"+
		"<WORST Value=\"5.0ms\"/>\n"+
		"</EXECTIME>\n"+
		"<EXECTIME Type=\"PROC\" Ref=\"ManoeuvrePointDetector_doManoeuvrePointDetection\">\n"+
		"<WORST Value=\"5.0ms\"/>\n"+
		"</EXECTIME>\n"+
		"<EXECTIME Type=\"PROC\" Ref=\"ManoeuvrePointDetector_writeOnPortOnMP\">\n"+
		"<WORST Value=\"7.0ms\"/>\n"+
		"</EXECTIME>\n"+
		"<EXECTIME Type=\"PROC\" Ref=\"SpeedController_setPosition\">\n"+
		"<WORST Value=\"5.0ms\"/>\n"+
		"</EXECTIME>\n"+
		"<EXECTIME Type=\"PROC\" Ref=\"OffRouteDetector_doOffRouteDetection\">\n"+
		"<WORST Value=\"5.0ms\"/>\n"+
		"</EXECTIME>\n"+
		"<EXECTIME Type=\"PROC\" Ref=\"RouteDataManager_computeNextRouteSection\">\n"+
		"<WORST Value=\"5.0ms\"/>\n"+
		"</EXECTIME>\n"+
		"<EXECTIME Type=\"PROC\" Ref=\"OffRouteDetector_writeOnPortOffRoute\">\n"+
		"<WORST Value=\"5.0ms\"/>\n"+
		"</EXECTIME>\n"+
		"<EXECTIME Type=\"PROC\" Ref=\"UserInterface_displayOnMP\">\n"+
		"<WORST Value=\"5.0ms\"/>\n"+
		"</EXECTIME>\n"+
		"<EXECTIME Type=\"PROC\" Ref=\"OffRouteDetector_setRouteSection\">\n"+
		"<WORST Value=\"5.0ms\"/>\n"+
		"</EXECTIME>\n"+
		"<EXECTIME Type=\"PROC\" Ref=\"ManoeuvrePointDetector_setRouteSection\">\n"+
		"<WORST Value=\"5.0ms\"/>\n"+
		"</EXECTIME>\n"+
		"<EXECTIME Type=\"PROC\" Ref=\"SpeedController_setRouteSection\">\n"+
		"<WORST Value=\"5.0ms\"/>\n"+
		"</EXECTIME>\n"+
		"</ANNOTATION>\n"+
		"<SCHEDULABILITY>\n"+
		"<SCHEDULINGSCENARIO>\n"+
		"<CPUSCHED CpuRef=\"cpuRtos\"/>\n"+
		"</SCHEDULINGSCENARIO>\n"+
		"</SCHEDULABILITY>\n"+
		"</SYSTEM>";

	
	private String test_3 = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n" +
		"<SYSTEM Name=\"MAGSynchronizer_NominalAnalysisContext\">\n" +
		"  <ARCHITECTURAL>\n" +
		"    <ECU Name=\"ecu\">\n" +
		"      <CPU Name=\"ecuCpu\">\n" +
		"        <RTOS Name=\"ecuRtos\"/>\n" +
		"      </CPU>\n" +
		"    </ECU>\n" +
		"    <TASK Name=\"keyOn\" Type=\"task\">\n" +
		"      <SCHEDULING Priority=\"10\"/>\n" +
		"      <ACTIVATION Deadline=\"1000ms\" Period=\"1000ms\" Type=\"sporadic\"/>\n" +
		"    </TASK>\n" +
		"    <TASK Name=\"intCam\" Type=\"task\">\n" +
		"      <SCHEDULING Priority=\"60\"/>\n" +
		"      <ACTIVATION Deadline=\"5ms\" Period=\"5ms\" Type=\"sporadic\"/>\n" +
		"    </TASK>\n" +
		"    <TASK Name=\"timeSlow\" Type=\"task\">\n" +
		"      <SCHEDULING Priority=\"20\"/>\n" +
		"      <ACTIVATION Deadline=\"100ms\" Period=\"100ms\" Type=\"periodic\"/>\n" +
		"    </TASK>\n" +
		"    <TASK Name=\"timeMedium\" Type=\"task\">\n" +
		"      <SCHEDULING Priority=\"30\"/>\n" +
		"      <ACTIVATION Deadline=\"12ms\" Period=\"12ms\" Type=\"periodic\"/>\n" +
		"    </TASK>\n" +
		"    <TASK Name=\"timeFast\" Type=\"task\">\n" +
		"      <SCHEDULING Priority=\"40\"/>\n" +
		"      <ACTIVATION Deadline=\"4ms\" Period=\"4ms\" Type=\"periodic\"/>\n" +
		"    </TASK>\n" +
		"    <TASK Name=\"psmHigh\" Type=\"task\">\n" +
		"      <SCHEDULING Priority=\"50\"/>\n" +
		"      <ACTIVATION Deadline=\"5ms\" Period=\"5ms\" Type=\"sporadic\"/>\n" +
		"    </TASK>\n" +
		"  </ARCHITECTURAL>\n" +
		"  <FUNCTIONAL>\n" +
		"    <PROC Name=\"SYNCMGM_keyOn\">\n" +
		"      <METHOD Name=\"run\"/>\n" +
		"    </PROC>\n" +
		"    <PROC Name=\"SYNCDVRS_keyOn\">\n" +
		"      <METHOD Name=\"run\"/>\n" +
		"    </PROC>\n" +
		"    <PROC Name=\"SYNCMGM_fastTime\">\n" +
		"      <METHOD Name=\"run\"/>\n" +
		"    </PROC>\n" +
		"    <PROC Name=\"SYNCMGM_configSynch\">\n" +
		"      <METHOD Name=\"run\"/>\n" +
		"    </PROC>\n" +
		"    <PROC Name=\"SYNCMGM_excepCam\">\n" +
		"      <METHOD Name=\"run\"/>\n" +
		"      <METHODREF MethodName=\"SYNCMGM_excepFault/run\" Name=\"SYNCMGM_excepFault.run\"/>\n" +
		"    </PROC>\n" +
		"    <PROC Name=\"ACAM_excepCam\">\n" +
		"      <METHOD Name=\"run\"/>\n" +
		"    </PROC>\n" +
		"    <PROC Name=\"DCAM_excepCam\">\n" +
		"      <METHOD Name=\"run\"/>\n" +
		"    </PROC>\n" +
		"    <PROC Name=\"RVRS_excepCam\">\n" +
		"      <METHOD Name=\"run\"/>\n" +
		"    </PROC>\n" +
		"    <PROC Name=\"SYNCMGM_excepFault\">\n" +
		"      <METHOD Name=\"run\"/>\n" +
		"      <METHODREF MethodName=\"SYNCMGM_excepTooth/run\" Name=\"SYNCMGM_excepTooth.run\"/>\n" +
		"    </PROC>\n" +
		"    <PROC Name=\"SYNCMGM_excepTooth\">\n" +
		"      <METHOD Name=\"run\"/>\n" +
		"    </PROC>\n" +
		"    <PROC Name=\"SYNCDVRS_excepCam\">\n" +
		"      <METHOD Name=\"run\"/>\n" +
		"    </PROC>\n" +
		"    <PROC Name=\"RVRS_mediumTime\">\n" +
		"      <METHOD Name=\"run\"/>\n" +
		"    </PROC>\n" +
		"    <PROC Name=\"DCAM_mediumTime\">\n" +
		"      <METHOD Name=\"run\"/>\n" +
		"    </PROC>\n" +
		"    <PROC Name=\"ACAM_slowTime\">\n" +
		"      <METHOD Name=\"run\"/>\n" +
		"    </PROC>\n" +
		"    <TRIGGER Name=\"AcceptKeyOnEvent\">\n" +
		"      <METHODREF MethodName=\"SYNCMGM_keyOn/run\" Name=\"SYNCMGM_keyOn.trigger\"/>\n" +
		"      <METHODREF MethodName=\"SYNCDVRS_keyOn/run\" Name=\"SYNCDVRS_keyOn.trigger\"/>\n" +
		"    </TRIGGER>\n" +
		"    <TRIGGER Name=\"AcceptEventTimeFast\">\n" +
		"      <METHODREF MethodName=\"SYNCMGM_fastTime/run\" Name=\"SYNCMGM_fastTime.trigger\"/>\n" +
		"    </TRIGGER>\n" +
		"    <TRIGGER Name=\"AcceptEventPsmHigh\">\n" +
		"      <METHODREF MethodName=\"SYNCMGM_configSynch/run\" Name=\"SYNCMGM_configSynch.trigger\"/>\n" +
		"    </TRIGGER>\n" +
		"    <TRIGGER Name=\"AcceptEventIntCam\">\n" +
		"      <METHODREF MethodName=\"SYNCMGM_excepCam/run\" Name=\"SYNCMGM_excepCam.trigger\"/>\n" +
		"      <METHODREF MethodName=\"ACAM_excepCam/run\" Name=\"ACAM_excepCam.trigger\"/>\n" +
		"      <METHODREF MethodName=\"DCAM_excepCam/run\" Name=\"DCAM_excepCam.trigger\"/>\n" +
		"      <METHODREF MethodName=\"RVRS_excepCam/run\" Name=\"RVRS_excepCam.trigger\"/>\n" +
		"      <METHODREF MethodName=\"SYNCDVRS_excepCam/run\" Name=\"SYNCDVRS_excepCam.trigger\"/>\n" +
		"    </TRIGGER>\n" +
		"    <TRIGGER Name=\"AcceptEventTimeMedium\">\n" +
		"      <METHODREF MethodName=\"RVRS_mediumTime/run\" Name=\"RVRS_mediumTime.trigger\"/>\n" +
		"      <METHODREF MethodName=\"DCAM_mediumTime/run\" Name=\"DCAM_mediumTime.trigger\"/>\n" +
		"    </TRIGGER>\n" +
		"    <TRIGGER Name=\"AcceptEventTimeSlow\">\n" +
		"      <METHODREF MethodName=\"ACAM_slowTime/run\" Name=\"ACAM_slowTime.trigger\"/>\n" +
		"    </TRIGGER>\n" +
		"    <EVENT MethodRefName=\"AcceptKeyOnEvent/SYNCMGM_keyOn.trigger\" Name=\"SYNCMGM_keyOn.act\" Type=\"activation\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptKeyOnEvent/SYNCDVRS_keyOn.trigger\" Name=\"SYNCDVRS_keyOn.act\" Type=\"activation\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptKeyOnEvent/SYNCMGM_keyOn.trigger\" Name=\"SYNCMGM_keyOn.begin\" Type=\"begin\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptKeyOnEvent/SYNCDVRS_keyOn.trigger\" Name=\"SYNCDVRS_keyOn.begin\" Type=\"begin\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptKeyOnEvent/SYNCMGM_keyOn.trigger\" Name=\"SYNCMGM_keyOn.end\" Type=\"end\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptKeyOnEvent/SYNCDVRS_keyOn.trigger\" Name=\"SYNCDVRS_keyOn.end\" Type=\"end\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventTimeFast/SYNCMGM_fastTime.trigger\" Name=\"SYNCMGM_fastTime.act\" Type=\"activation\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventTimeFast/SYNCMGM_fastTime.trigger\" Name=\"SYNCMGM_fastTime.begin\" Type=\"begin\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventTimeFast/SYNCMGM_fastTime.trigger\" Name=\"SYNCMGM_fastTime.end\" Type=\"end\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventPsmHigh/SYNCMGM_configSynch.trigger\" Name=\"SYNCMGM_configSynch.act\" Type=\"activation\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventPsmHigh/SYNCMGM_configSynch.trigger\" Name=\"SYNCMGM_configSynch.begin\" Type=\"begin\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventPsmHigh/SYNCMGM_configSynch.trigger\" Name=\"SYNCMGM_configSynch.end\" Type=\"end\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventIntCam/SYNCMGM_excepCam.trigger\" Name=\"SYNCMGM_excepCam.act\" Type=\"activation\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventIntCam/ACAM_excepCam.trigger\" Name=\"ACAM_excepCam.act\" Type=\"activation\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventIntCam/DCAM_excepCam.trigger\" Name=\"DCAM_excepCam.act\" Type=\"activation\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventIntCam/RVRS_excepCam.trigger\" Name=\"RVRS_excepCam.act\" Type=\"activation\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventIntCam/SYNCDVRS_excepCam.trigger\" Name=\"SYNCDVRS_excepCam.act\" Type=\"activation\"/>\n" +
		"    <EVENT MethodRefName=\"SYNCMGM_excepCam/SYNCMGM_excepFault.run\" Name=\"SYNCMGM_excepFault.begin\" Type=\"begin\"/>\n" +
		"    <EVENT MethodRefName=\"SYNCMGM_excepFault/SYNCMGM_excepTooth.run\" Name=\"SYNCMGM_excepTooth.begin\" Type=\"begin\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventIntCam/SYNCMGM_excepCam.trigger\" Name=\"SYNCMGM_excepCam.begin\" Type=\"begin\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventIntCam/ACAM_excepCam.trigger\" Name=\"ACAM_excepCam.begin\" Type=\"begin\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventIntCam/DCAM_excepCam.trigger\" Name=\"DCAM_excepCam.begin\" Type=\"begin\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventIntCam/RVRS_excepCam.trigger\" Name=\"RVRS_excepCam.begin\" Type=\"begin\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventIntCam/SYNCDVRS_excepCam.trigger\" Name=\"SYNCDVRS_excepCam.begin\" Type=\"begin\"/>\n" +
		"    <EVENT MethodRefName=\"SYNCMGM_excepCam/SYNCMGM_excepFault.run\" Name=\"SYNCMGM_excepFault.end\" Type=\"end\"/>\n" +
		"    <EVENT MethodRefName=\"SYNCMGM_excepFault/SYNCMGM_excepTooth.run\" Name=\"SYNCMGM_excepTooth.end\" Type=\"end\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventIntCam/SYNCMGM_excepCam.trigger\" Name=\"SYNCMGM_excepCam.end\" Type=\"end\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventIntCam/ACAM_excepCam.trigger\" Name=\"ACAM_excepCam.end\" Type=\"end\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventIntCam/DCAM_excepCam.trigger\" Name=\"DCAM_excepCam.end\" Type=\"end\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventIntCam/RVRS_excepCam.trigger\" Name=\"RVRS_excepCam.end\" Type=\"end\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventIntCam/SYNCDVRS_excepCam.trigger\" Name=\"SYNCDVRS_excepCam.end\" Type=\"end\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventTimeMedium/RVRS_mediumTime.trigger\" Name=\"RVRS_mediumTime.act\" Type=\"activation\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventTimeMedium/DCAM_mediumTime.trigger\" Name=\"DCAM_mediumTime.act\" Type=\"activation\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventTimeMedium/RVRS_mediumTime.trigger\" Name=\"RVRS_mediumTime.begin\" Type=\"begin\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventTimeMedium/DCAM_mediumTime.trigger\" Name=\"DCAM_mediumTime.begin\" Type=\"begin\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventTimeMedium/RVRS_mediumTime.trigger\" Name=\"RVRS_mediumTime.end\" Type=\"end\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventTimeMedium/DCAM_mediumTime.trigger\" Name=\"DCAM_mediumTime.end\" Type=\"end\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventTimeSlow/ACAM_slowTime.trigger\" Name=\"ACAM_slowTime.act\" Type=\"activation\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventTimeSlow/ACAM_slowTime.trigger\" Name=\"ACAM_slowTime.begin\" Type=\"begin\"/>\n" +
		"    <EVENT MethodRefName=\"AcceptEventTimeSlow/ACAM_slowTime.trigger\" Name=\"ACAM_slowTime.end\" Type=\"end\"/>\n" +
		"    <PARTIALORDER>\n" +
		"      <ORDER>\n" +
		"        <EVENTREF Name=\"SYNCMGM_keyOn.begin\"/>\n" +
		"        <EVENTREF Name=\"SYNCMGM_keyOn.end\"/>\n" +
		"      </ORDER>\n" +
		"      <ORDER>\n" +
		"        <EVENTREF Name=\"SYNCDVRS_keyOn.begin\"/>\n" +
		"        <EVENTREF Name=\"SYNCDVRS_keyOn.end\"/>\n" +
		"      </ORDER>\n" +
		"      <ORDER>\n" +
		"        <EVENTREF Name=\"SYNCMGM_keyOn.act\"/>\n" +
		"        <EVENTREF Name=\"SYNCMGM_keyOn.begin\"/>\n" +
		"      </ORDER>\n" +
		"      <ORDER>\n" +
		"        <EVENTREF Name=\"SYNCDVRS_keyOn.act\"/>\n" +
		"        <EVENTREF Name=\"SYNCDVRS_keyOn.begin\"/>\n" +
		"      </ORDER>\n" +
		"      <ORDER>\n" +
		"        <EVENTREF Name=\"SYNCMGM_fastTime.begin\"/>\n" +
		"        <EVENTREF Name=\"SYNCMGM_fastTime.end\"/>\n" +
		"      </ORDER>\n" +
		"      <ORDER>\n" +
		"        <EVENTREF Name=\"SYNCMGM_fastTime.act\"/>\n" +
		"        <EVENTREF Name=\"SYNCMGM_fastTime.begin\"/>\n" +
		"      </ORDER>\n" +
		"      <ORDER>\n" +
		"        <EVENTREF Name=\"SYNCMGM_configSynch.begin\"/>\n" +
		"        <EVENTREF Name=\"SYNCMGM_configSynch.end\"/>\n" +
		"      </ORDER>\n" +
		"      <ORDER>\n" +
		"        <EVENTREF Name=\"SYNCMGM_configSynch.act\"/>\n" +
		"        <EVENTREF Name=\"SYNCMGM_configSynch.begin\"/>\n" +
		"      </ORDER>\n" +
		"      <ORDER>\n" +
		"        <EVENTREF Name=\"SYNCMGM_excepCam.begin\"/>\n" +
		"        <EVENTREF Name=\"SYNCMGM_excepCam.end\"/>\n" +
		"      </ORDER>\n" +
		"      <ORDER>\n" +
		"        <EVENTREF Name=\"ACAM_excepCam.begin\"/>\n" +
		"        <EVENTREF Name=\"ACAM_excepCam.end\"/>\n" +
		"      </ORDER>\n" +
		"      <ORDER>\n" +
		"        <EVENTREF Name=\"DCAM_excepCam.begin\"/>\n" +
		"        <EVENTREF Name=\"DCAM_excepCam.end\"/>\n" +
		"      </ORDER>\n" +
		"      <ORDER>\n" +
		"        <EVENTREF Name=\"RVRS_excepCam.begin\"/>\n" +
		"        <EVENTREF Name=\"RVRS_excepCam.end\"/>\n" +
		"      </ORDER>\n" +
		"      <ORDER>\n" +
		"        <EVENTREF Name=\"SYNCMGM_excepFault.begin\"/>\n" +
		"        <EVENTREF Name=\"SYNCMGM_excepFault.end\"/>\n" +
		"      </ORDER>\n" +
		"      <ORDER>\n" +
		"        <EVENTREF Name=\"SYNCMGM_excepTooth.begin\"/>\n" +
		"        <EVENTREF Name=\"SYNCMGM_excepTooth.end\"/>\n" +
		"      </ORDER>\n" +
		"      <ORDER>\n" +
		"        <EVENTREF Name=\"SYNCDVRS_excepCam.begin\"/>\n" +
		"        <EVENTREF Name=\"SYNCDVRS_excepCam.end\"/>\n" +
		"      </ORDER>\n" +
		"      <ORDER>\n" +
		"        <EVENTREF Name=\"SYNCMGM_excepCam.end\"/>\n" +
		"        <EVENTREF Name=\"SYNCMGM_excepFault.begin\"/>\n" +
		"      </ORDER>\n" +
		"      <ORDER>\n" +
		"        <EVENTREF Name=\"SYNCMGM_excepFault.end\"/>\n" +
		"        <EVENTREF Name=\"SYNCMGM_excepTooth.begin\"/>\n" +
		"      </ORDER>\n" +
		"      <ORDER>\n" +
		"        <EVENTREF Name=\"SYNCMGM_excepCam.act\"/>\n" +
		"        <EVENTREF Name=\"SYNCMGM_excepCam.begin\"/>\n" +
		"      </ORDER>\n" +
		"      <ORDER>\n" +
		"        <EVENTREF Name=\"ACAM_excepCam.act\"/>\n" +
		"        <EVENTREF Name=\"ACAM_excepCam.begin\"/>\n" +
		"      </ORDER>\n" +
		"      <ORDER>\n" +
		"        <EVENTREF Name=\"DCAM_excepCam.act\"/>\n" +
		"        <EVENTREF Name=\"DCAM_excepCam.begin\"/>\n" +
		"      </ORDER>\n" +
		"      <ORDER>\n" +
		"        <EVENTREF Name=\"RVRS_excepCam.act\"/>\n" +
		"        <EVENTREF Name=\"RVRS_excepCam.begin\"/>\n" +
		"      </ORDER>\n" +
		"      <ORDER>\n" +
		"        <EVENTREF Name=\"SYNCDVRS_excepCam.act\"/>\n" +
		"        <EVENTREF Name=\"SYNCDVRS_excepCam.begin\"/>\n" +
		"      </ORDER>\n" +
		"      <ORDER>\n" +
		"        <EVENTREF Name=\"RVRS_mediumTime.begin\"/>\n" +
		"        <EVENTREF Name=\"RVRS_mediumTime.end\"/>\n" +
		"      </ORDER>\n" +
		"      <ORDER>\n" +
		"        <EVENTREF Name=\"DCAM_mediumTime.begin\"/>\n" +
		"        <EVENTREF Name=\"DCAM_mediumTime.end\"/>\n" +
		"      </ORDER>\n" +
		"      <ORDER>\n" +
		"        <EVENTREF Name=\"RVRS_mediumTime.act\"/>\n" +
		"        <EVENTREF Name=\"RVRS_mediumTime.begin\"/>\n" +
		"      </ORDER>\n" +
		"      <ORDER>\n" +
		"        <EVENTREF Name=\"DCAM_mediumTime.act\"/>\n" +
		"        <EVENTREF Name=\"DCAM_mediumTime.begin\"/>\n" +
		"      </ORDER>\n" +
		"      <ORDER>\n" +
		"        <EVENTREF Name=\"ACAM_slowTime.begin\"/>\n" +
		"        <EVENTREF Name=\"ACAM_slowTime.end\"/>\n" +
		"      </ORDER>\n" +
		"      <ORDER>\n" +
		"        <EVENTREF Name=\"ACAM_slowTime.act\"/>\n" +
		"        <EVENTREF Name=\"ACAM_slowTime.begin\"/>\n" +
		"      </ORDER>\n" +
		"    </PARTIALORDER>\n" +
		
		
		"    <TIMECONST>\n" +
		"      <EVENTREF Name=\"SYNCMGM_keyOn.act\"/>\n" +
		"      <EVENTREF Name=\"ACAM_slowTime.end\"/>\n" +
		"      <BOUND Type=\"deadline\" Value=\"1000ms\"/>\n" +
		"    </TIMECONST>\n" +

		
		"    <TIMECONST>\n" +
		"      <EVENTREF Name=\"SYNCMGM_keyOn.act\"/>\n" +
		"      <BOUND Type=\"mit\" Value=\"1000ms\"/>\n" +
		"    </TIMECONST>\n" +
		"    <TIMECONST>\n" +
		"      <EVENTREF Name=\"SYNCDVRS_keyOn.act\"/>\n" +
		"      <BOUND Type=\"mit\" Value=\"1000ms\"/>\n" +
		"    </TIMECONST>\n" +
		"    <TIMECONST>\n" +
		"      <EVENTREF Name=\"SYNCMGM_fastTime.act\"/>\n" +
		"      <BOUND Type=\"period\" Value=\"4ms\"/>\n" +
		"    </TIMECONST>\n" +
		"    <TIMECONST>\n" +
		"      <EVENTREF Name=\"SYNCMGM_configSynch.act\"/>\n" +
		"      <BOUND Type=\"mit\" Value=\"5ms\"/>\n" +
		"    </TIMECONST>\n" +
		"    <TIMECONST>\n" +
		"      <EVENTREF Name=\"SYNCMGM_excepCam.act\"/>\n" +
		"      <BOUND Type=\"mit\" Value=\"5ms\"/>\n" +
		"    </TIMECONST>\n" +
		"    <TIMECONST>\n" +
		"      <EVENTREF Name=\"ACAM_excepCam.act\"/>\n" +
		"      <BOUND Type=\"mit\" Value=\"5ms\"/>\n" +
		"    </TIMECONST>\n" +
		"    <TIMECONST>\n" +
		"      <EVENTREF Name=\"DCAM_excepCam.act\"/>\n" +
		"      <BOUND Type=\"mit\" Value=\"5ms\"/>\n" +
		"    </TIMECONST>\n" +
		"    <TIMECONST>\n" +
		"      <EVENTREF Name=\"RVRS_excepCam.act\"/>\n" +
		"      <BOUND Type=\"mit\" Value=\"5ms\"/>\n" +
		"    </TIMECONST>\n" +
		"    <TIMECONST>\n" +
		"      <EVENTREF Name=\"SYNCDVRS_excepCam.act\"/>\n" +
		"      <BOUND Type=\"mit\" Value=\"5ms\"/>\n" +
		"    </TIMECONST>\n" +
		"    <TIMECONST>\n" +
		"      <EVENTREF Name=\"RVRS_mediumTime.act\"/>\n" +
		"      <BOUND Type=\"period\" Value=\"12ms\"/>\n" +
		"    </TIMECONST>\n" +
		"    <TIMECONST>\n" +
		"      <EVENTREF Name=\"DCAM_mediumTime.act\"/>\n" +
		"      <BOUND Type=\"period\" Value=\"12ms\"/>\n" +
		"    </TIMECONST>\n" +
		"    <TIMECONST>\n" +
		"      <EVENTREF Name=\"ACAM_slowTime.act\"/>\n" +
		"      <BOUND Type=\"period\" Value=\"100ms\"/>\n" +
		"    </TIMECONST>\n" +
		"  </FUNCTIONAL>\n" +
		"  <MAPPING>\n" +
		"    <PROCMAP ProcRef=\"SYNCMGM_keyOn\" TaskRef=\"keyOn\"/>\n" +
		"    <PROCMAP ProcRef=\"SYNCDVRS_keyOn\" TaskRef=\"keyOn\"/>\n" +
		"    <PROCMAP ProcRef=\"SYNCMGM_excepCam\" TaskRef=\"intCam\"/>\n" +
		"    <PROCMAP ProcRef=\"ACAM_excepCam\" TaskRef=\"intCam\"/>\n" +
		"    <PROCMAP ProcRef=\"DCAM_excepCam\" TaskRef=\"intCam\"/>\n" +
		"    <PROCMAP ProcRef=\"RVRS_excepCam\" TaskRef=\"intCam\"/>\n" +
		"    <PROCMAP ProcRef=\"SYNCMGM_excepFault\" TaskRef=\"intCam\"/>\n" +
		"    <PROCMAP ProcRef=\"SYNCMGM_excepTooth\" TaskRef=\"intCam\"/>\n" +
		"    <PROCMAP ProcRef=\"SYNCDVRS_excepCam\" TaskRef=\"intCam\"/>\n" +
		"    <PROCMAP ProcRef=\"ACAM_slowTime\" TaskRef=\"timeSlow\"/>\n" +
		"    <PROCMAP ProcRef=\"RVRS_mediumTime\" TaskRef=\"timeMedium\"/>\n" +
		"    <PROCMAP ProcRef=\"DCAM_mediumTime\" TaskRef=\"timeMedium\"/>\n" +
		"    <PROCMAP ProcRef=\"SYNCMGM_fastTime\" TaskRef=\"timeFast\"/>\n" +
		"    <PROCMAP ProcRef=\"SYNCMGM_configSynch\" TaskRef=\"psmHigh\"/>\n" +
		"    <TASKMAP rtosRef=\"ecuRtos\" TaskRef=\"keyOn\"/>\n" +
		"    <TASKMAP rtosRef=\"ecuRtos\" TaskRef=\"intCam\"/>\n" +
		"    <TASKMAP rtosRef=\"ecuRtos\" TaskRef=\"timeSlow\"/>\n" +
		"    <TASKMAP rtosRef=\"ecuRtos\" TaskRef=\"timeMedium\"/>\n" +
		"    <TASKMAP rtosRef=\"ecuRtos\" TaskRef=\"timeFast\"/>\n" +
		"    <TASKMAP rtosRef=\"ecuRtos\" TaskRef=\"psmHigh\"/>\n" +
		"  </MAPPING>\n" +
		"  <ANNOTATION>\n" +
		"    <EXECTIME Ref=\"SYNCMGM_keyOn\" Type=\"PROC\">\n" +
		"      <WORST Value=\"20us\"/>\n" +
		"    </EXECTIME>\n" +
		"    <EXECTIME Ref=\"SYNCDVRS_keyOn\" Type=\"PROC\">\n" +
		"      <WORST Value=\"25us\"/>\n" +
		"    </EXECTIME>\n" +
		"    <EXECTIME Ref=\"SYNCMGM_fastTime\" Type=\"PROC\">\n" +
		"      <WORST Value=\"45us\"/>\n" +
		"    </EXECTIME>\n" +
		"    <EXECTIME Ref=\"SYNCMGM_configSynch\" Type=\"PROC\">\n" +
		"      <WORST Value=\"15us\"/>\n" +
		"    </EXECTIME>\n" +
		"    <EXECTIME Ref=\"SYNCMGM_excepCam\" Type=\"PROC\">\n" +
		"      <WORST Value=\"12us\"/>\n" +
		"    </EXECTIME>\n" +
		"    <EXECTIME Ref=\"ACAM_excepCam\" Type=\"PROC\">\n" +
		"      <WORST Value=\"15us\"/>\n" +
		"    </EXECTIME>\n" +
		"    <EXECTIME Ref=\"DCAM_excepCam\" Type=\"PROC\">\n" +
		"      <WORST Value=\"13us\"/>\n" +
		"    </EXECTIME>\n" +
		"    <EXECTIME Ref=\"RVRS_excepCam\" Type=\"PROC\">\n" +
		"      <WORST Value=\"7us\"/>\n" +
		"    </EXECTIME>\n" +
		"    <EXECTIME Ref=\"SYNCMGM_excepFault\" Type=\"PROC\">\n" +
		"      <WORST Value=\"12us\"/>\n" +
		"    </EXECTIME>\n" +
		"    <EXECTIME Ref=\"SYNCMGM_excepTooth\" Type=\"PROC\">\n" +
		"      <WORST Value=\"12us\"/>\n" +
		"    </EXECTIME>\n" +
		"    <EXECTIME Ref=\"SYNCDVRS_excepCam\" Type=\"PROC\">\n" +
		"      <WORST Value=\"5us\"/>\n" +
		"    </EXECTIME>\n" +
		"    <EXECTIME Ref=\"RVRS_mediumTime\" Type=\"PROC\">\n" +
		"      <WORST Value=\"40us\"/>\n" +
		"    </EXECTIME>\n" +
		"    <EXECTIME Ref=\"DCAM_mediumTime\" Type=\"PROC\">\n" +
		"      <WORST Value=\"25us\"/>\n" +
		"    </EXECTIME>\n" +
		"    <EXECTIME Ref=\"ACAM_slowTime\" Type=\"PROC\">\n" +
		"      <WORST Value=\"30us\"/>\n" +
		"    </EXECTIME>\n" +
		"  </ANNOTATION>\n" +
		"</SYSTEM>";
	
	
	private String test_4 = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n" +
	"<SYSTEM Name=\"MAGSynchronizer_NominalAnalysisContext\">\n" +
	"  <ARCHITECTURAL>\n" +
	"    <ECU Name=\"ecu\">\n" +
	"      <CPU Name=\"ecuCpu\">\n" +
	"        <RTOS Name=\"ecuRtos\"/>\n" +
	"      </CPU>\n" +
	"    </ECU>\n" +
	"    <TASK Name=\"keyOn\" Type=\"task\">\n" +
	"      <SCHEDULING Priority=\"10\"/>\n" +
	"      <ACTIVATION Deadline=\"1000ms\" Period=\"1000ms\" Type=\"sporadic\"/>\n" +
	"    </TASK>\n" +
	"    <TASK Name=\"intCam\" Type=\"task\">\n" +
	"      <SCHEDULING Priority=\"60\"/>\n" +
	"      <ACTIVATION Deadline=\"5ms\" Period=\"5ms\" Type=\"sporadic\"/>\n" +
	"    </TASK>\n" +
	"    <TASK Name=\"timeSlow\" Type=\"task\">\n" +
	"      <SCHEDULING Priority=\"20\"/>\n" +
	"      <ACTIVATION Deadline=\"100ms\" Period=\"100ms\" Type=\"periodic\"/>\n" +
	"    </TASK>\n" +
	"    <TASK Name=\"timeMedium\" Type=\"task\">\n" +
	"      <SCHEDULING Priority=\"30\"/>\n" +
	"      <ACTIVATION Deadline=\"12ms\" Period=\"12ms\" Type=\"periodic\"/>\n" +
	"    </TASK>\n" +
	"    <TASK Name=\"timeFast\" Type=\"task\">\n" +
	"      <SCHEDULING Priority=\"40\"/>\n" +
	"      <ACTIVATION Deadline=\"4ms\" Period=\"4ms\" Type=\"periodic\"/>\n" +
	"    </TASK>\n" +
	"    <TASK Name=\"psmHigh\" Type=\"task\">\n" +
	"      <SCHEDULING Priority=\"50\"/>\n" +
	"      <ACTIVATION Deadline=\"5ms\" Period=\"5ms\" Type=\"sporadic\"/>\n" +
	"    </TASK>\n" +
	"  </ARCHITECTURAL>\n" +
	"  <FUNCTIONAL>\n" +
	"    <PROC Name=\"SYNCMGM_keyOn\">\n" +
	"      <METHOD Name=\"run\"/>\n" +
	"    </PROC>\n" +
	"    <PROC Name=\"SYNCDVRS_keyOn\">\n" +
	"      <METHOD Name=\"run\"/>\n" +
	"    </PROC>\n" +
	"    <PROC Name=\"SYNCMGM_fastTime\">\n" +
	"      <METHOD Name=\"run\"/>\n" +
	"    </PROC>\n" +
	"    <PROC Name=\"SYNCMGM_configSynch\">\n" +
	"      <METHOD Name=\"run\"/>\n" +
	"    </PROC>\n" +
	"    <PROC Name=\"SYNCMGM_excepCam\">\n" +
	"      <METHOD Name=\"run\"/>\n" +
	"      <METHODREF MethodName=\"SYNCMGM_excepFault/run\" Name=\"SYNCMGM_excepFault.run\"/>\n" +
	"    </PROC>\n" +
	"    <PROC Name=\"ACAM_excepCam\">\n" +
	"      <METHOD Name=\"run\"/>\n" +
	"    </PROC>\n" +
	"    <PROC Name=\"DCAM_excepCam\">\n" +
	"      <METHOD Name=\"run\"/>\n" +
	"    </PROC>\n" +
	"    <PROC Name=\"RVRS_excepCam\">\n" +
	"      <METHOD Name=\"run\"/>\n" +
	"    </PROC>\n" +
	"    <PROC Name=\"SYNCMGM_excepFault\">\n" +
	"      <METHOD Name=\"run\"/>\n" +
	"      <METHODREF MethodName=\"SYNCMGM_excepTooth/run\" Name=\"SYNCMGM_excepTooth.run\"/>\n" +
	"    </PROC>\n" +
	"    <PROC Name=\"SYNCMGM_excepTooth\">\n" +
	"      <METHOD Name=\"run\"/>\n" +
	"    </PROC>\n" +
	"    <PROC Name=\"SYNCDVRS_excepCam\">\n" +
	"      <METHOD Name=\"run\"/>\n" +
	"    </PROC>\n" +
	"    <PROC Name=\"RVRS_mediumTime\">\n" +
	"      <METHOD Name=\"run\"/>\n" +
	"    </PROC>\n" +
	"    <PROC Name=\"DCAM_mediumTime\">\n" +
	"      <METHOD Name=\"run\"/>\n" +
	"    </PROC>\n" +
	"    <PROC Name=\"ACAM_slowTime\">\n" +
	"      <METHOD Name=\"run\"/>\n" +
	"    </PROC>\n" +
	"    <TRIGGER Name=\"AcceptKeyOnEvent\">\n" +
	"      <METHODREF MethodName=\"SYNCMGM_keyOn/run\" Name=\"SYNCMGM_keyOn.trigger\"/>\n" +
	"      <METHODREF MethodName=\"SYNCDVRS_keyOn/run\" Name=\"SYNCDVRS_keyOn.trigger\"/>\n" +
	"    </TRIGGER>\n" +
	"    <TRIGGER Name=\"AcceptEventTimeFast\">\n" +
	"      <METHODREF MethodName=\"SYNCMGM_fastTime/run\" Name=\"SYNCMGM_fastTime.trigger\"/>\n" +
	"    </TRIGGER>\n" +
	"    <TRIGGER Name=\"AcceptEventPsmHigh\">\n" +
	"      <METHODREF MethodName=\"SYNCMGM_configSynch/run\" Name=\"SYNCMGM_configSynch.trigger\"/>\n" +
	"    </TRIGGER>\n" +
	"    <TRIGGER Name=\"AcceptEventIntCam\">\n" +
	"      <METHODREF MethodName=\"SYNCMGM_excepCam/run\" Name=\"SYNCMGM_excepCam.trigger\"/>\n" +
	"      <METHODREF MethodName=\"ACAM_excepCam/run\" Name=\"ACAM_excepCam.trigger\"/>\n" +
	"      <METHODREF MethodName=\"DCAM_excepCam/run\" Name=\"DCAM_excepCam.trigger\"/>\n" +
	"      <METHODREF MethodName=\"RVRS_excepCam/run\" Name=\"RVRS_excepCam.trigger\"/>\n" +
	"      <METHODREF MethodName=\"SYNCDVRS_excepCam/run\" Name=\"SYNCDVRS_excepCam.trigger\"/>\n" +
	"    </TRIGGER>\n" +
	"    <TRIGGER Name=\"AcceptEventTimeMedium\">\n" +
	"      <METHODREF MethodName=\"RVRS_mediumTime/run\" Name=\"RVRS_mediumTime.trigger\"/>\n" +
	"      <METHODREF MethodName=\"DCAM_mediumTime/run\" Name=\"DCAM_mediumTime.trigger\"/>\n" +
	"    </TRIGGER>\n" +
	"    <TRIGGER Name=\"AcceptEventTimeSlow\">\n" +
	"      <METHODREF MethodName=\"ACAM_slowTime/run\" Name=\"ACAM_slowTime.trigger\"/>\n" +
	"    </TRIGGER>\n" +
	"    <EVENT MethodRefName=\"AcceptKeyOnEvent/SYNCMGM_keyOn.trigger\" Name=\"SYNCMGM_keyOn.act\" Type=\"activation\"/>\n" +
	"    <EVENT MethodRefName=\"AcceptKeyOnEvent/SYNCDVRS_keyOn.trigger\" Name=\"SYNCDVRS_keyOn.act\" Type=\"activation\"/>\n" +
	"    <EVENT MethodRefName=\"AcceptKeyOnEvent/SYNCMGM_keyOn.trigger\" Name=\"SYNCMGM_keyOn.begin\" Type=\"begin\"/>\n" +
	"    <EVENT MethodRefName=\"AcceptKeyOnEvent/SYNCDVRS_keyOn.trigger\" Name=\"SYNCDVRS_keyOn.begin\" Type=\"begin\"/>\n" +
	"    <EVENT MethodRefName=\"AcceptKeyOnEvent/SYNCMGM_keyOn.trigger\" Name=\"SYNCMGM_keyOn.end\" Type=\"end\"/>\n" +
	"    <EVENT MethodRefName=\"AcceptKeyOnEvent/SYNCDVRS_keyOn.trigger\" Name=\"SYNCDVRS_keyOn.end\" Type=\"end\"/>\n" +
	"    <EVENT MethodRefName=\"AcceptEventTimeFast/SYNCMGM_fastTime.trigger\" Name=\"SYNCMGM_fastTime.act\" Type=\"activation\"/>\n" +
	"    <EVENT MethodRefName=\"AcceptEventTimeFast/SYNCMGM_fastTime.trigger\" Name=\"SYNCMGM_fastTime.begin\" Type=\"begin\"/>\n" +
	"    <EVENT MethodRefName=\"AcceptEventTimeFast/SYNCMGM_fastTime.trigger\" Name=\"SYNCMGM_fastTime.end\" Type=\"end\"/>\n" +
	"    <EVENT MethodRefName=\"AcceptEventPsmHigh/SYNCMGM_configSynch.trigger\" Name=\"SYNCMGM_configSynch.act\" Type=\"activation\"/>\n" +
	"    <EVENT MethodRefName=\"AcceptEventPsmHigh/SYNCMGM_configSynch.trigger\" Name=\"SYNCMGM_configSynch.begin\" Type=\"begin\"/>\n" +
	"    <EVENT MethodRefName=\"AcceptEventPsmHigh/SYNCMGM_configSynch.trigger\" Name=\"SYNCMGM_configSynch.end\" Type=\"end\"/>\n" +
	"    <EVENT MethodRefName=\"AcceptEventIntCam/SYNCMGM_excepCam.trigger\" Name=\"SYNCMGM_excepCam.act\" Type=\"activation\"/>\n" +
	"    <EVENT MethodRefName=\"AcceptEventIntCam/ACAM_excepCam.trigger\" Name=\"ACAM_excepCam.act\" Type=\"activation\"/>\n" +
	"    <EVENT MethodRefName=\"AcceptEventIntCam/DCAM_excepCam.trigger\" Name=\"DCAM_excepCam.act\" Type=\"activation\"/>\n" +
	"    <EVENT MethodRefName=\"AcceptEventIntCam/RVRS_excepCam.trigger\" Name=\"RVRS_excepCam.act\" Type=\"activation\"/>\n" +
	"    <EVENT MethodRefName=\"AcceptEventIntCam/SYNCDVRS_excepCam.trigger\" Name=\"SYNCDVRS_excepCam.act\" Type=\"activation\"/>\n" +
	"    <EVENT MethodRefName=\"SYNCMGM_excepCam/SYNCMGM_excepFault.run\" Name=\"SYNCMGM_excepFault.begin\" Type=\"begin\"/>\n" +
	"    <EVENT MethodRefName=\"SYNCMGM_excepFault/SYNCMGM_excepTooth.run\" Name=\"SYNCMGM_excepTooth.begin\" Type=\"begin\"/>\n" +
	"    <EVENT MethodRefName=\"AcceptEventIntCam/SYNCMGM_excepCam.trigger\" Name=\"SYNCMGM_excepCam.begin\" Type=\"begin\"/>\n" +
	"    <EVENT MethodRefName=\"AcceptEventIntCam/ACAM_excepCam.trigger\" Name=\"ACAM_excepCam.begin\" Type=\"begin\"/>\n" +
	"    <EVENT MethodRefName=\"AcceptEventIntCam/DCAM_excepCam.trigger\" Name=\"DCAM_excepCam.begin\" Type=\"begin\"/>\n" +
	"    <EVENT MethodRefName=\"AcceptEventIntCam/RVRS_excepCam.trigger\" Name=\"RVRS_excepCam.begin\" Type=\"begin\"/>\n" +
	"    <EVENT MethodRefName=\"AcceptEventIntCam/SYNCDVRS_excepCam.trigger\" Name=\"SYNCDVRS_excepCam.begin\" Type=\"begin\"/>\n" +
	"    <EVENT MethodRefName=\"SYNCMGM_excepCam/SYNCMGM_excepFault.run\" Name=\"SYNCMGM_excepFault.end\" Type=\"end\"/>\n" +
	"    <EVENT MethodRefName=\"SYNCMGM_excepFault/SYNCMGM_excepTooth.run\" Name=\"SYNCMGM_excepTooth.end\" Type=\"end\"/>\n" +
	"    <EVENT MethodRefName=\"AcceptEventIntCam/SYNCMGM_excepCam.trigger\" Name=\"SYNCMGM_excepCam.end\" Type=\"end\"/>\n" +
	"    <EVENT MethodRefName=\"AcceptEventIntCam/ACAM_excepCam.trigger\" Name=\"ACAM_excepCam.end\" Type=\"end\"/>\n" +
	"    <EVENT MethodRefName=\"AcceptEventIntCam/DCAM_excepCam.trigger\" Name=\"DCAM_excepCam.end\" Type=\"end\"/>\n" +
	"    <EVENT MethodRefName=\"AcceptEventIntCam/RVRS_excepCam.trigger\" Name=\"RVRS_excepCam.end\" Type=\"end\"/>\n" +
	"    <EVENT MethodRefName=\"AcceptEventIntCam/SYNCDVRS_excepCam.trigger\" Name=\"SYNCDVRS_excepCam.end\" Type=\"end\"/>\n" +
	"    <EVENT MethodRefName=\"AcceptEventTimeMedium/RVRS_mediumTime.trigger\" Name=\"RVRS_mediumTime.act\" Type=\"activation\"/>\n" +
	"    <EVENT MethodRefName=\"AcceptEventTimeMedium/DCAM_mediumTime.trigger\" Name=\"DCAM_mediumTime.act\" Type=\"activation\"/>\n" +
	"    <EVENT MethodRefName=\"AcceptEventTimeMedium/RVRS_mediumTime.trigger\" Name=\"RVRS_mediumTime.begin\" Type=\"begin\"/>\n" +
	"    <EVENT MethodRefName=\"AcceptEventTimeMedium/DCAM_mediumTime.trigger\" Name=\"DCAM_mediumTime.begin\" Type=\"begin\"/>\n" +
	"    <EVENT MethodRefName=\"AcceptEventTimeMedium/RVRS_mediumTime.trigger\" Name=\"RVRS_mediumTime.end\" Type=\"end\"/>\n" +
	"    <EVENT MethodRefName=\"AcceptEventTimeMedium/DCAM_mediumTime.trigger\" Name=\"DCAM_mediumTime.end\" Type=\"end\"/>\n" +
	"    <EVENT MethodRefName=\"AcceptEventTimeSlow/ACAM_slowTime.trigger\" Name=\"ACAM_slowTime.act\" Type=\"activation\"/>\n" +
	"    <EVENT MethodRefName=\"AcceptEventTimeSlow/ACAM_slowTime.trigger\" Name=\"ACAM_slowTime.begin\" Type=\"begin\"/>\n" +
	"    <EVENT MethodRefName=\"AcceptEventTimeSlow/ACAM_slowTime.trigger\" Name=\"ACAM_slowTime.end\" Type=\"end\"/>\n" +
	"    <PARTIALORDER>\n" +
	"      <ORDER>\n" +
	"        <EVENTREF Name=\"SYNCMGM_excepCam.end\"/>\n" +
	"        <EVENTREF Name=\"SYNCMGM_excepFault.begin\"/>\n" +
	"      </ORDER>\n" +
	"      <ORDER>\n" +
	"        <EVENTREF Name=\"SYNCMGM_excepFault.end\"/>\n" +
	"        <EVENTREF Name=\"SYNCMGM_excepTooth.begin\"/>\n" +
	"      </ORDER>\n" +
	"    </PARTIALORDER>\n" +
	"    <TIMECONST>\n" +
	"      <EVENTREF Name=\"SYNCMGM_keyOn.act\"/>\n" +
	"      <BOUND Type=\"mit\" Value=\"1000ms\"/>\n" +
	"    </TIMECONST>\n" +
	"    <TIMECONST>\n" +
	"      <EVENTREF Name=\"SYNCDVRS_keyOn.act\"/>\n" +
	"      <BOUND Type=\"mit\" Value=\"1000ms\"/>\n" +
	"    </TIMECONST>\n" +
	"    <TIMECONST>\n" +
	"      <EVENTREF Name=\"SYNCMGM_fastTime.act\"/>\n" +
	"      <BOUND Type=\"period\" Value=\"4ms\"/>\n" +
	"    </TIMECONST>\n" +
	"    <TIMECONST>\n" +
	"      <EVENTREF Name=\"SYNCMGM_configSynch.act\"/>\n" +
	"      <BOUND Type=\"mit\" Value=\"5ms\"/>\n" +
	"    </TIMECONST>\n" +
	"    <TIMECONST>\n" +
	"      <EVENTREF Name=\"SYNCMGM_excepCam.act\"/>\n" +
	"      <BOUND Type=\"mit\" Value=\"5ms\"/>\n" +
	"    </TIMECONST>\n" +
	"    <TIMECONST>\n" +
	"      <EVENTREF Name=\"ACAM_excepCam.act\"/>\n" +
	"      <BOUND Type=\"mit\" Value=\"5ms\"/>\n" +
	"    </TIMECONST>\n" +
	"    <TIMECONST>\n" +
	"      <EVENTREF Name=\"DCAM_excepCam.act\"/>\n" +
	"      <BOUND Type=\"mit\" Value=\"5ms\"/>\n" +
	"    </TIMECONST>\n" +
	"    <TIMECONST>\n" +
	"      <EVENTREF Name=\"RVRS_excepCam.act\"/>\n" +
	"      <BOUND Type=\"mit\" Value=\"5ms\"/>\n" +
	"    </TIMECONST>\n" +
	"    <TIMECONST>\n" +
	"      <EVENTREF Name=\"SYNCDVRS_excepCam.act\"/>\n" +
	"      <BOUND Type=\"mit\" Value=\"5ms\"/>\n" +
	"    </TIMECONST>\n" +
	"    <TIMECONST>\n" +
	"      <EVENTREF Name=\"RVRS_mediumTime.act\"/>\n" +
	"      <BOUND Type=\"period\" Value=\"12ms\"/>\n" +
	"    </TIMECONST>\n" +
	"    <TIMECONST>\n" +
	"      <EVENTREF Name=\"DCAM_mediumTime.act\"/>\n" +
	"      <BOUND Type=\"period\" Value=\"12ms\"/>\n" +
	"    </TIMECONST>\n" +
	"    <TIMECONST>\n" +
	"      <EVENTREF Name=\"ACAM_slowTime.act\"/>\n" +
	"      <BOUND Type=\"period\" Value=\"100ms\"/>\n" +
	"    </TIMECONST>\n" +
	"  </FUNCTIONAL>\n" +
	"  <MAPPING>\n" +
	"    <PROCMAP ProcRef=\"SYNCMGM_keyOn\" TaskRef=\"keyOn\"/>\n" +
	"    <PROCMAP ProcRef=\"SYNCDVRS_keyOn\" TaskRef=\"keyOn\"/>\n" +
	"    <PROCMAP ProcRef=\"SYNCMGM_excepCam\" TaskRef=\"intCam\"/>\n" +
	"    <PROCMAP ProcRef=\"ACAM_excepCam\" TaskRef=\"intCam\"/>\n" +
	"    <PROCMAP ProcRef=\"DCAM_excepCam\" TaskRef=\"intCam\"/>\n" +
	"    <PROCMAP ProcRef=\"RVRS_excepCam\" TaskRef=\"intCam\"/>\n" +
	"    <PROCMAP ProcRef=\"SYNCMGM_excepFault\" TaskRef=\"intCam\"/>\n" +
	"    <PROCMAP ProcRef=\"SYNCMGM_excepTooth\" TaskRef=\"intCam\"/>\n" +
	"    <PROCMAP ProcRef=\"SYNCDVRS_excepCam\" TaskRef=\"intCam\"/>\n" +
	"    <PROCMAP ProcRef=\"ACAM_slowTime\" TaskRef=\"timeSlow\"/>\n" +
	"    <PROCMAP ProcRef=\"RVRS_mediumTime\" TaskRef=\"timeMedium\"/>\n" +
	"    <PROCMAP ProcRef=\"DCAM_mediumTime\" TaskRef=\"timeMedium\"/>\n" +
	"    <PROCMAP ProcRef=\"SYNCMGM_fastTime\" TaskRef=\"timeFast\"/>\n" +
	"    <PROCMAP ProcRef=\"SYNCMGM_configSynch\" TaskRef=\"psmHigh\"/>\n" +
	"    <TASKMAP rtosRef=\"ecuRtos\" TaskRef=\"keyOn\"/>\n" +
	"    <TASKMAP rtosRef=\"ecuRtos\" TaskRef=\"intCam\"/>\n" +
	"    <TASKMAP rtosRef=\"ecuRtos\" TaskRef=\"timeSlow\"/>\n" +
	"    <TASKMAP rtosRef=\"ecuRtos\" TaskRef=\"timeMedium\"/>\n" +
	"    <TASKMAP rtosRef=\"ecuRtos\" TaskRef=\"timeFast\"/>\n" +
	"    <TASKMAP rtosRef=\"ecuRtos\" TaskRef=\"psmHigh\"/>\n" +
	"  </MAPPING>\n" +
	"  <ANNOTATION>\n" +
	"    <EXECTIME Ref=\"SYNCMGM_keyOn\" Type=\"PROC\">\n" +
	"      <WORST Value=\"20us\"/>\n" +
	"    </EXECTIME>\n" +
	"    <EXECTIME Ref=\"SYNCDVRS_keyOn\" Type=\"PROC\">\n" +
	"      <WORST Value=\"25us\"/>\n" +
	"    </EXECTIME>\n" +
	"    <EXECTIME Ref=\"SYNCMGM_fastTime\" Type=\"PROC\">\n" +
	"      <WORST Value=\"45us\"/>\n" +
	"    </EXECTIME>\n" +
	"    <EXECTIME Ref=\"SYNCMGM_configSynch\" Type=\"PROC\">\n" +
	"      <WORST Value=\"15us\"/>\n" +
	"    </EXECTIME>\n" +
	"    <EXECTIME Ref=\"SYNCMGM_excepCam\" Type=\"PROC\">\n" +
	"      <WORST Value=\"12us\"/>\n" +
	"    </EXECTIME>\n" +
	"    <EXECTIME Ref=\"ACAM_excepCam\" Type=\"PROC\">\n" +
	"      <WORST Value=\"15us\"/>\n" +
	"    </EXECTIME>\n" +
	"    <EXECTIME Ref=\"DCAM_excepCam\" Type=\"PROC\">\n" +
	"      <WORST Value=\"13us\"/>\n" +
	"    </EXECTIME>\n" +
	"    <EXECTIME Ref=\"RVRS_excepCam\" Type=\"PROC\">\n" +
	"      <WORST Value=\"7us\"/>\n" +
	"    </EXECTIME>\n" +
	"    <EXECTIME Ref=\"SYNCMGM_excepFault\" Type=\"PROC\">\n" +
	"      <WORST Value=\"12us\"/>\n" +
	"    </EXECTIME>\n" +
	"    <EXECTIME Ref=\"SYNCMGM_excepTooth\" Type=\"PROC\">\n" +
	"      <WORST Value=\"12us\"/>\n" +
	"    </EXECTIME>\n" +
	"    <EXECTIME Ref=\"SYNCDVRS_excepCam\" Type=\"PROC\">\n" +
	"      <WORST Value=\"5us\"/>\n" +
	"    </EXECTIME>\n" +
	"    <EXECTIME Ref=\"RVRS_mediumTime\" Type=\"PROC\">\n" +
	"      <WORST Value=\"40us\"/>\n" +
	"    </EXECTIME>\n" +
	"    <EXECTIME Ref=\"DCAM_mediumTime\" Type=\"PROC\">\n" +
	"      <WORST Value=\"25us\"/>\n" +
	"    </EXECTIME>\n" +
	"    <EXECTIME Ref=\"ACAM_slowTime\" Type=\"PROC\">\n" +
	"      <WORST Value=\"30us\"/>\n" +
	"    </EXECTIME>\n" +
	"  </ANNOTATION>\n" +
	"</SYSTEM>";
	
	
	protected void abstractLoad(String txt) throws IOException {
		IVarTree vt =Vt2StringUtilities.loadString(txt);

		System.out.println("Load ..");
		PartialOrderData pod = new PartialOrderData(vt, new StandarOutputReporter());
		
		System.out.println("\nResult ..");
		List<TaskData> tasks = pod.getTasks();
		System.out.println("\n\ntasks:");
		for (TaskData t : tasks)
			System.out.println(t);
	}
	
	
	protected void abstractCheck(String txt) throws IOException {
		IVarTree vt =Vt2StringUtilities.loadString(txt);

		System.out.println("Load ..");
		PartialOrderData pod = new PartialOrderData(vt, new StandarOutputReporter());

		System.out.println("\nResult ..");
		List<TaskData> tasks = pod.getTasks();
		System.out.println("  .. tasks:");
		for (TaskData t : tasks)
			System.out.println(t);

		List<ProcData> procs = pod.getProcs();
		System.out.println("  .. procs:");
		for (ProcData t : procs)
			System.out.println(t);

		System.out.println("\nCheck ..");
		PartialOrderChecker checker = new PartialOrderChecker(pod);
		boolean result = checker.checkAll();
		
		System.out.println("The result of check is : " + result);
	}


	
	/* --------------------------- 
	 * 
	 *            LOAD
	 * 
	 * --------------------------- */
	
	public void testLoad_a() throws IOException {
		abstractLoad(CompleteTest1.example1[0]);
	}

	public void testLoad_b() throws IOException {
		abstractLoad(test_1);
	}

	public void testLoad_c() throws IOException {
		abstractLoad(test_3);
	}
	
	/* --------------------------- 
	 * 
	 *            CHECK
	 * 
	 * --------------------------- */
	
	public void testCheck_a() throws IOException {
		abstractCheck(CompleteTest1.example1[0]);
	}

	public void testCheck_b() throws IOException {
		abstractCheck(test_1);
	}

	public void testCheck_c() throws IOException {
		abstractCheck(test_2);
	}

	public void testCheck_d() throws IOException {
		abstractCheck(test_3);
	}

	public void testCheck_e() throws IOException {
		abstractCheck(test_4);
	}
	
}
