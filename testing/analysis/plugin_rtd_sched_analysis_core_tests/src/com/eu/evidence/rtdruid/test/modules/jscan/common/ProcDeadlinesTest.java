package com.eu.evidence.rtdruid.test.modules.jscan.common;

import java.io.IOException;
import java.util.Properties;

import junit.framework.TestCase;

import com.eu.evidence.rtdruid.internal.modules.jscan.JScan;
import com.eu.evidence.rtdruid.internal.modules.jscan.common.JScanImpl;
import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVariable;
import com.eu.evidence.rtdruid.vartree.Vt2StringUtilities;


public class ProcDeadlinesTest extends TestCase {

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

			
			
			
		"    <TIMECONST>\n" +
		"      <EVENTREF Name=\"AcceptSpeed.act\"/>\n" +
		"      <EVENTREF Name=\"UserInterface_displayOnMP.end\"/>\n" +
		"      <BOUND Type=\"deadline\" Value=\"1000ms\"/>\n" +
		"    </TIMECONST>\n" +

		"    <TIMECONST>\n" +
		"      <EVENTREF Name=\"AcceptSpeed.act\"/>\n" +
		"      <EVENTREF Name=\"UserInterface_displayOnSpeedViolation.end\"/>\n" +
		"      <BOUND Type=\"deadline\" Value=\"200ms\"/>\n" +
		"    </TIMECONST>\n" +

		
			
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

		
		public void test1() throws IOException {
			IVarTree vt =Vt2StringUtilities.loadString(test_1);
			
			String system = (vt.newTreeInterface()).getAllName(null, "System")[0];

			
			Properties options = new Properties();
			options.setProperty(JScanImpl.EXPORT_SCHEDULING_DATA, "true");

			String rep = JScan.startTest(vt, system, JScan.PROC_SCHED_MULTIFRAME_FP_ID, options);
			
			vt.newTreeInterface().setValue(system+IVarTree.SEPARATOR
					+"Schedulability"+IVarTree.SEPARATOR
					+"SchedulingScenarioList"+IVarTree.SEPARATOR
					+DataPath.makeSlashedId((String)null)+IVarTree.SEPARATOR
					+"Reports"+IVarTree.SEPARATOR
					, (IVariable) null);
			
			System.out.println(rep); // + "\n\n" + Utility.varTreeToStringRtd(vt));
			
		}
	
}
