/*
 * Created on Jul 12, 2004
 *
 * $Id: CompleteTest2.java,v 1.2 2008/03/26 18:23:51 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.jscan;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

import org.junit.Test;

import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVariable;
import com.eu.evidence.rtdruid.vartree.Vt2StringUtilities;
import com.eu.evidence.rtdruid.vartree.abstractions.old.Task;
import com.eu.evidence.rtdruid.vartree.abstractions.old.TaskSet;

/**
 * @author Nicola Serreli
 */
public class CompleteTest2 extends AbstractCompleteTest {
	
	@Test
	public void test1() throws IOException {

		String[] testcase1 = {
				"<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
						"<!DOCTYPE SYSTEM SYSTEM \"evidence_0.2.dtd\">" +
						"<SYSTEM xmlns:rtdruid.vartree.data=\"http://rtdruid.vartree.data\" Name=\"d/e/f\\au/\\\\/\\\\ltSystem\">" +
						"<FUNCTIONAL>" +
						"<PROC Name=\"filt*er/1\">" +
						"<METHOD Name=\"dec*ode/X\"/>" +
						"<METHODREF Name=\"i\\/m*age.r\\\\\\\\ead\" MethodName=\"i\\/m*age/r\\\\\\\\ead\"/>" +
						"<METHODREF Name=\"x.w\\/rit*e\" MethodName=\"x/w\\/rit*e\"/>" +
						"</PROC>" +
						"<PROC Name=\"der\\1\">" +
						"<METHOD Name=\"der\\X\"/>" +
						"<METHODREF Name=\"x.r\\\\\\\\ead\" MethodName=\"x/r\\\\\\\\ead\"/>" +
						"<METHODREF Name=\"dx.w\\/rit*e\" MethodName=\"dx/w\\/rit*e\"/>" +
						"</PROC>" +
						"<PROC Name=\"filt*er\\2\">" +
						"<METHOD Name=\"dec*ode\\\\teta/\"/>" +
						"<METHODREF Name=\"\\/angolo\\/.r\\\\\\\\ead\" MethodName=\"\\/angolo\\//r\\\\\\\\ead\"/>" +
						"<METHODREF Name=\"\\\\teta\\/.w\\/rit*e\" MethodName=\"\\\\teta\\//w\\/rit*e\"/>" +
						"</PROC>" +
						"<PROC Name=\"/d/e/r/2/\">" +
						"<METHOD Name=\"der\\teta/\"/>" +
						"<METHODREF Name=\"\\\\teta\\/.r\\\\\\\\ead\" MethodName=\"\\\\teta\\//r\\\\\\\\ead\"/>" +
						"<METHODREF Name=\"d\\\\teta\\/.w\\/rit*e\" MethodName=\"d\\\\teta\\//w\\/rit*e\"/>" +
						"</PROC>" +
						"<PROC Name=\"\\//\\mat\">" +
						"<METHOD Name=\"compute/\"/>" +
						"<METHODREF Name=\"x.r\\\\\\\\ead\" MethodName=\"x/r\\\\\\\\ead\"/>" +
						"<METHODREF Name=\"dx.r\\\\\\\\ead\" MethodName=\"dx/r\\\\\\\\ead\"/>" +
						"<METHODREF Name=\"\\\\teta\\/.r\\\\\\\\ead\" MethodName=\"\\\\teta\\//r\\\\\\\\ead\"/>" +
						"<METHODREF Name=\"d\\\\teta\\/.r\\\\\\\\ead\" MethodName=\"d\\\\teta\\//r\\\\\\\\ead\"/>" +
						"<METHODREF Name=\"*f.w\\/rit*e\" MethodName=\"*f/w\\/rit*e\"/>" +
						"</PROC>" +
						"<TRIGGER Name=\"arrivo/Immagine\">" +
						"<METHODREF Name=\"period\" MethodName=\"\"/>" +
						"<METHODREF Name=\"i/m*age.w\\/rit*e\" MethodName=\"i\\/m*age/w\\/rit*e\"/>" +
						"<METHODREF Name=\"filt*er\\/1.dec*ode\\/X\" MethodName=\"filt*er\\/1/dec*ode\\/X\"/>" +
						"<METHODREF Name=\"der\\\\1.der\\\\X\" MethodName=\"der\\\\1/der\\\\X\"/>" +
						"</TRIGGER>" +
						"<TRIGGER Name=\"arrivo/angolo/\">" +
						"<METHODREF Name=\"period\"  MethodName=\"\"/>" +
						"<METHODREF Name=\"\\/angolo\\/.w\\/rit*e\" MethodName=\"\\/angolo\\//w\\/rit*e\"/>" +
						"<METHODREF Name=\"filt*er\\\\2.dec*ode\\\\\\\\teta\\/\" MethodName=\"filt*er\\\\2/dec*ode\\\\\\\\teta\\/\"/>" +
						"<METHODREF Name=\"\\/d\\/e\\/r\\/2\\/.der\\\\teta\\/\" MethodName=\"\\/d\\/e\\/r\\/2\\//der\\\\teta\\/\"/>" +
						"<METHODREF Name=\"\\\\\\/\\/\\\\mat.compute\\/\" MethodName=\"\\\\\\/\\/\\\\mat/compute\\/\"/>" +
						"</TRIGGER>" +
						"<TRIGGER Name=\"lettura/F\">" +
						"<METHODREF Name=\"*f.r\\\\\\\\ead\" MethodName=\"*f/r\\\\\\\\ead\"/>" +
						"</TRIGGER>" +
						"<VAR Name=\"i/m*age\" Type=\"int[][]\">" +
						"<METHOD Name=\"r\\\\ead\"/>" +
						"<METHOD Name=\"w/rit*e\"/>" +
						"</VAR>" +
						"<VAR Name=\"x\" Type=\"double\">" +
						"<METHOD Name=\"r\\\\ead\"/>" +
						"<METHOD Name=\"w/rit*e\"/>" +
						"</VAR>" +
						"<VAR Name=\"dx\" Type=\"double\">" +
						"<METHOD Name=\"r\\\\ead\"/>" +
						"<METHOD Name=\"w/rit*e\"/>" +
						"</VAR>" +
						"<VAR Name=\"/angolo/\" Type=\"double\">" +
						"<METHOD Name=\"r\\\\ead\"/>" +
						"<METHOD Name=\"w/rit*e\"/>" +
						"</VAR>" +
						"<VAR Name=\"\\teta/\" Type=\"double\">" +
						"<METHOD Name=\"r\\\\ead\"/>" +
						"<METHOD Name=\"w/rit*e\"/>" +
						"</VAR>" +
						"<VAR Name=\"d\\teta/\" Type=\"double\">" +
						"<METHOD Name=\"r\\\\ead\"/>" +
						"<METHOD Name=\"w/rit*e\"/>" +
						"</VAR>" +
						"<VAR Name=\"*f\" Type=\"double\">" +
						"<METHOD Name=\"r\\\\ead\"/>" +
						"<METHOD Name=\"w/rit*e\"/>" +
						"</VAR>" +
						"</FUNCTIONAL>" +
						"<ARCHITECTURAL>" +
						"<ECU Name=\"ECU/0\">" +
						"<CPU Name=\"CPU/0\" Model=\"ARM7\">" +
						"<RTOS Name=\"CPU/0.erika\"/>" +
						"</CPU>" +
						"</ECU>" +
						"<TASK Name=\"Task\\\\1\" Type=\"task\">" +
						"<SCHEDULING Priority=\"1\"/>" +
						"<ACTIVATION Deadline=\"35.0ms\" Period=\"40.0ms\" Type=\"periodic\"/>" +
						"</TASK>" +
						"<TASK Name=\"Task//2\" Type=\"task\">" +
						"<SCHEDULING Priority=\"2\"/>" +
						"<ACTIVATION Deadline=\"5.0ms\" Period=\"5.0ms\" Type=\"periodic\"/>" +
						"</TASK>" +
						"<TASK Name=\"/Task\\\\ISR1/\" Type=\"ISR\">" +
						"<SCHEDULING Priority=\"3\"/>" +
						"<ACTIVATION Deadline=\"5.0ms\" Period=\"40.0ms\" Type=\"periodic\"/>" +
						"</TASK>" +
						"<TASK Name=\"Task/ISR2\" Type=\"ISR\">" +
						"<SCHEDULING Priority=\"4\"/>" +
						"<ACTIVATION Deadline=\"1.0ms\" Period=\"5.0ms\" Type=\"periodic\"/>" +
						"</TASK>" +
						"<MUTEX Name=\"Mutex/1\"/>" +
						"</ARCHITECTURAL>" +
						"<MAPPING>" +
						"<PROCMAP ProcRef=\"filt*er\\/1\" TaskRef=\"Task\\\\1\" Order=\"1\"/>" +
						"<PROCMAP ProcRef=\"der\\\\1\" TaskRef=\"Task\\\\1\" Order=\"2\"/>" +
						"<PROCMAP ProcRef=\"filt*er\\\\2\" TaskRef=\"Task//2\" Order=\"1\"/>" +
						"<PROCMAP ProcRef=\"\\/d\\/e\\/r\\/2\\/\" TaskRef=\"Task//2\" Order=\"2\"/>" +
						"<PROCMAP ProcRef=\"\\\\\\/\\/\\\\mat\" TaskRef=\"Task//2\" Order=\"3\"/>" +
						"<TASKMAP rtosRef=\"CPU/0.erika\" TaskRef=\"Task\\\\1\"/>" +
						"<TASKMAP rtosRef=\"CPU/0.erika\" TaskRef=\"Task//2\"/>" +
						"<TASKMAP rtosRef=\"CPU/0.erika\" TaskRef=\"/Task\\\\ISR1/\"/>" +
						"<TASKMAP rtosRef=\"CPU/0.erika\" TaskRef=\"Task/ISR2\"/>" +
						"<VARMAP VarRef=\"x\" MutexRef=\"Mutex\\/1\"/>" +
						"<VARMAP VarRef=\"dx\" MutexRef=\"Mutex\\/1\"/>" +
						"</MAPPING>" +
						"<ANNOTATION>" +
						"<EXECTIME Type=\"METHOD\" Ref=\"x/r\\\\\\\\ead\">" +
						"<WORST Value=\"0.1ms\"/>" +
						"</EXECTIME>" +
						"<EXECTIME Type=\"METHOD\" Ref=\"x/w\\/rit*e\">" +
						"<WORST Value=\"0.1ms\"/>" +
						"</EXECTIME>" +
						"<EXECTIME Type=\"METHOD\" Ref=\"dx/r\\\\\\\\ead\">" +
						"<WORST Value=\"0.1ms\"/>" +
						"</EXECTIME>" +
						"<EXECTIME Type=\"METHOD\" Ref=\"dx/w\\/rit*e\">" +
						"<WORST Value=\"0.1ms\"/>" +
						"</EXECTIME>" +
						"<EXECTIME Type=\"METHOD\" Ref=\"\\\\teta\\//r\\\\\\\\ead\">" +
						"<WORST Value=\"0.1ms\"/>" +
						"</EXECTIME>" +
						"<EXECTIME Type=\"METHOD\" Ref=\"\\\\teta\\//w\\/rit*e\">" +
						"<WORST Value=\"0.1ms\"/>" +
						"</EXECTIME>" +
						"<EXECTIME Type=\"METHOD\" Ref=\"d\\\\teta\\//r\\\\\\\\ead\">" +
						"<WORST Value=\"0.1ms\"/>" +
						"</EXECTIME>" +
						"<EXECTIME Type=\"METHOD\" Ref=\"d\\\\teta\\//w\\/rit*e\">" +
						"<WORST Value=\"0.1ms\"/>" +
						"</EXECTIME>" +
						"<EXECTIME Type=\"METHOD\" Ref=\"i\\/m*age/r\\\\\\\\ead\">" +
						"<WORST Value=\"0.2ms\"/>" +
						"</EXECTIME>" +
						"<EXECTIME Type=\"METHOD\" Ref=\"i\\/m*age/w\\/rit*e\">" +
						"<WORST Value=\"0.2ms\"/>" +
						"</EXECTIME>" +
						"<EXECTIME Type=\"METHOD\" Ref=\"\\/angolo\\//r\\\\\\\\ead\">" +
						"<WORST Value=\"0.2ms\"/>" +
						"</EXECTIME>" +
						"<EXECTIME Type=\"METHOD\" Ref=\"\\/angolo\\//w\\/rit*e\">" +
						"<WORST Value=\"0.2ms\"/>" +
						"</EXECTIME>" +
						"<EXECTIME Type=\"METHOD\" Ref=\"*f/r\\\\\\\\ead\">" +
						"<WORST Value=\"0.1ms\"/>" +
						"</EXECTIME>" +
						"<EXECTIME Type=\"METHOD\" Ref=\"*f/w\\/rit*e\">" +
						"<WORST Value=\"0.1ms\"/>" +
						"</EXECTIME>" +
						"<EXECTIME Type=\"TASK\" Ref=\"Task\\\\1\">" +
						"<WORST Value=\"12.0ms\"/>" +
						"</EXECTIME>" +
						"<EXECTIME Type=\"TASK\" Ref=\"Task//2\">" +
						"<WORST Value=\"4.0ms\"/>" +
						"</EXECTIME>" +
						"<EXECTIME Type=\"TASK\" Ref=\"/Task\\\\ISR1/\">" +
						"<WORST Value=\"2.0ms\"/>" +
						"</EXECTIME>" +
						"<EXECTIME Type=\"TASK\" Ref=\"Task/ISR2\">" +
						"<WORST Value=\"1.0ms\"/>" +
						"</EXECTIME>" +
						"</ANNOTATION>" +
						"</SYSTEM>",
						
						// results
						
						"<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
						"<!DOCTYPE SYSTEM SYSTEM \"evidence_0.2.dtd\">" +
						"<SYSTEM xmlns:rtdruid.vartree.data=\"http://rtdruid.vartree.data\" Name=\"d/e/f\\au/\\\\/\\\\ltSystem\">" +
						"<FUNCTIONAL>" +
						"<PROC Name=\"filt*er/1\">" +
						"<METHOD Name=\"dec*ode/X\"/>" +
						"<METHODREF Name=\"i\\/m*age.r\\\\\\\\ead\" MethodName=\"i\\/m*age/r\\\\\\\\ead\"/>" +
						"<METHODREF Name=\"x.w\\/rit*e\" MethodName=\"x/w\\/rit*e\"/>" +
						"</PROC>" +
						"<PROC Name=\"der\\1\">" +
						"<METHOD Name=\"der\\X\"/>" +
						"<METHODREF Name=\"x.r\\\\\\\\ead\" MethodName=\"x/r\\\\\\\\ead\"/>" +
						"<METHODREF Name=\"dx.w\\/rit*e\" MethodName=\"dx/w\\/rit*e\"/>" +
						"</PROC>" +
						"<PROC Name=\"filt*er\\2\">" +
						"<METHOD Name=\"dec*ode\\\\teta/\"/>" +
						"<METHODREF Name=\"\\/angolo\\/.r\\\\\\\\ead\" MethodName=\"\\/angolo\\//r\\\\\\\\ead\"/>" +
						"<METHODREF Name=\"\\\\teta\\/.w\\/rit*e\" MethodName=\"\\\\teta\\//w\\/rit*e\"/>" +
						"</PROC>" +
						"<PROC Name=\"/d/e/r/2/\">" +
						"<METHOD Name=\"der\\teta/\"/>" +
						"<METHODREF Name=\"\\\\teta\\/.r\\\\\\\\ead\" MethodName=\"\\\\teta\\//r\\\\\\\\ead\"/>" +
						"<METHODREF Name=\"d\\\\teta\\/.w\\/rit*e\" MethodName=\"d\\\\teta\\//w\\/rit*e\"/>" +
						"</PROC>" +
						"<PROC Name=\"\\//\\mat\">" +
						"<METHOD Name=\"compute/\"/>" +
						"<METHODREF Name=\"x.r\\\\\\\\ead\" MethodName=\"x/r\\\\\\\\ead\"/>" +
						"<METHODREF Name=\"dx.r\\\\\\\\ead\" MethodName=\"dx/r\\\\\\\\ead\"/>" +
						"<METHODREF Name=\"\\\\teta\\/.r\\\\\\\\ead\" MethodName=\"\\\\teta\\//r\\\\\\\\ead\"/>" +
						"<METHODREF Name=\"d\\\\teta\\/.r\\\\\\\\ead\" MethodName=\"d\\\\teta\\//r\\\\\\\\ead\"/>" +
						"<METHODREF Name=\"*f.w\\/rit*e\" MethodName=\"*f/w\\/rit*e\"/>" +
						"</PROC>" +
						"<TRIGGER Name=\"arrivo/Immagine\">" +
						"<METHODREF Name=\"period\" MethodName=\"\"/>" +
						"<METHODREF Name=\"i/m*age.w\\/rit*e\" MethodName=\"i\\/m*age/w\\/rit*e\"/>" +
						"<METHODREF Name=\"filt*er\\/1.dec*ode\\/X\" MethodName=\"filt*er\\/1/dec*ode\\/X\"/>" +
						"<METHODREF Name=\"der\\\\1.der\\\\X\" MethodName=\"der\\\\1/der\\\\X\"/>" +
						"</TRIGGER>" +
						"<TRIGGER Name=\"arrivo/angolo/\">" +
						"<METHODREF Name=\"period\" MethodName=\"\"/>" +
						"<METHODREF Name=\"\\/angolo\\/.w\\/rit*e\" MethodName=\"\\/angolo\\//w\\/rit*e\"/>" +
						"<METHODREF Name=\"filt*er\\\\2.dec*ode\\\\\\\\teta\\/\" MethodName=\"filt*er\\\\2/dec*ode\\\\\\\\teta\\/\"/>" +
						"<METHODREF Name=\"\\/d\\/e\\/r\\/2\\/.der\\\\teta\\/\" MethodName=\"\\/d\\/e\\/r\\/2\\//der\\\\teta\\/\"/>" +
						"<METHODREF Name=\"\\\\\\/\\/\\\\mat.compute\\/\" MethodName=\"\\\\\\/\\/\\\\mat/compute\\/\"/>" +
						"</TRIGGER>" +
						"<TRIGGER Name=\"lettura/F\">" +
						"<METHODREF Name=\"*f.r\\\\\\\\ead\" MethodName=\"*f/r\\\\\\\\ead\"/>" +
						"</TRIGGER>" +
						"<VAR Name=\"i/m*age\" Type=\"int[][]\">" +
						"<METHOD Name=\"r\\\\ead\"/>" +
						"<METHOD Name=\"w/rit*e\"/>" +
						"</VAR>" +
						"<VAR Name=\"x\" Type=\"double\">" +
						"<METHOD Name=\"r\\\\ead\"/>" +
						"<METHOD Name=\"w/rit*e\"/>" +
						"</VAR>" +
						"<VAR Name=\"dx\" Type=\"double\">" +
						"<METHOD Name=\"r\\\\ead\"/>" +
						"<METHOD Name=\"w/rit*e\"/>" +
						"</VAR>" +
						"<VAR Name=\"/angolo/\" Type=\"double\">" +
						"<METHOD Name=\"r\\\\ead\"/>" +
						"<METHOD Name=\"w/rit*e\"/>" +
						"</VAR>" +
						"<VAR Name=\"\\teta/\" Type=\"double\">" +
						"<METHOD Name=\"r\\\\ead\"/>" +
						"<METHOD Name=\"w/rit*e\"/>" +
						"</VAR>" +
						"<VAR Name=\"d\\teta/\" Type=\"double\">" +
						"<METHOD Name=\"r\\\\ead\"/>" +
						"<METHOD Name=\"w/rit*e\"/>" +
						"</VAR>" +
						"<VAR Name=\"*f\" Type=\"double\">" +
						"<METHOD Name=\"r\\\\ead\"/>" +
						"<METHOD Name=\"w/rit*e\"/>" +
						"</VAR>" +
						"</FUNCTIONAL>" +
						"<ARCHITECTURAL>" +
						"<ECU Name=\"ECU/0\">" +
						"<CPU Name=\"CPU/0\" Model=\"ARM7\">" +
						"<RTOS Name=\"CPU/0.erika\"/>" +
						"</CPU>" +
						"</ECU>" +
						"<TASK Name=\"Task\\\\1\" Type=\"task\">" +
						"<SCHEDULING Priority=\"1\"/>" +
						"<ACTIVATION Deadline=\"35.0ms\" Period=\"40.0ms\" Type=\"periodic\"/>" +
						"</TASK>" +
						"<TASK Name=\"Task//2\" Type=\"task\">" +
						"<SCHEDULING Priority=\"2\"/>" +
						"<ACTIVATION Deadline=\"5.0ms\" Period=\"5.0ms\" Type=\"periodic\"/>" +
						"</TASK>" +
						"<TASK Name=\"/Task\\\\ISR1/\" Type=\"ISR\">" +
						"<SCHEDULING Priority=\"3\"/>" +
						"<ACTIVATION Deadline=\"5.0ms\" Period=\"40.0ms\" Type=\"periodic\"/>" +
						"</TASK>" +
						"<TASK Name=\"Task/ISR2\" Type=\"ISR\">" +
						"<SCHEDULING Priority=\"4\"/>" +
						"<ACTIVATION Deadline=\"1.0ms\" Period=\"5.0ms\" Type=\"periodic\"/>" +
						"</TASK>" +
						"<MUTEX Name=\"Mutex/1\"/>" +
						"</ARCHITECTURAL>" +
						"<MAPPING>" +
						"<PROCMAP ProcRef=\"filt*er\\/1\" TaskRef=\"Task\\\\1\" Order=\"1\"/>" +
						"<PROCMAP ProcRef=\"der\\\\1\" TaskRef=\"Task\\\\1\" Order=\"2\"/>" +
						"<PROCMAP ProcRef=\"filt*er\\\\2\" TaskRef=\"Task//2\" Order=\"1\"/>" +
						"<PROCMAP ProcRef=\"\\/d\\/e\\/r\\/2\\/\" TaskRef=\"Task//2\" Order=\"2\"/>" +
						"<PROCMAP ProcRef=\"\\\\\\/\\/\\\\mat\" TaskRef=\"Task//2\" Order=\"3\"/>" +
						"<TASKMAP rtosRef=\"CPU/0.erika\" TaskRef=\"Task\\\\1\"/>" +
						"<TASKMAP rtosRef=\"CPU/0.erika\" TaskRef=\"Task//2\"/>" +
						"<TASKMAP rtosRef=\"CPU/0.erika\" TaskRef=\"/Task\\\\ISR1/\"/>" +
						"<TASKMAP rtosRef=\"CPU/0.erika\" TaskRef=\"Task/ISR2\"/>" +
						"<VARMAP VarRef=\"x\" MutexRef=\"Mutex\\/1\"/>" +
						"<VARMAP VarRef=\"dx\" MutexRef=\"Mutex\\/1\"/>" +
						"</MAPPING>" +
						"<ANNOTATION>" +
						"<EXECTIME Type=\"METHOD\" Ref=\"x/r\\\\\\\\ead\">" +
						"<WORST Value=\"0.1ms\"/>" +
						"</EXECTIME>" +
						"<EXECTIME Type=\"METHOD\" Ref=\"x/w\\/rit*e\">" +
						"<WORST Value=\"0.1ms\"/>" +
						"</EXECTIME>" +
						"<EXECTIME Type=\"METHOD\" Ref=\"dx/r\\\\\\\\ead\">" +
						"<WORST Value=\"0.1ms\"/>" +
						"</EXECTIME>" +
						"<EXECTIME Type=\"METHOD\" Ref=\"dx/w\\/rit*e\">" +
						"<WORST Value=\"0.1ms\"/>" +
						"</EXECTIME>" +
						"<EXECTIME Type=\"METHOD\" Ref=\"\\\\teta\\//r\\\\\\\\ead\">" +
						"<WORST Value=\"0.1ms\"/>" +
						"</EXECTIME>" +
						"<EXECTIME Type=\"METHOD\" Ref=\"\\\\teta\\//w\\/rit*e\">" +
						"<WORST Value=\"0.1ms\"/>" +
						"</EXECTIME>" +
						"<EXECTIME Type=\"METHOD\" Ref=\"d\\\\teta\\//r\\\\\\\\ead\">" +
						"<WORST Value=\"0.1ms\"/>" +
						"</EXECTIME>" +
						"<EXECTIME Type=\"METHOD\" Ref=\"d\\\\teta\\//w\\/rit*e\">" +
						"<WORST Value=\"0.1ms\"/>" +
						"</EXECTIME>" +
						"<EXECTIME Type=\"METHOD\" Ref=\"i\\/m*age/r\\\\\\\\ead\">" +
						"<WORST Value=\"0.2ms\"/>" +
						"</EXECTIME>" +
						"<EXECTIME Type=\"METHOD\" Ref=\"i\\/m*age/w\\/rit*e\">" +
						"<WORST Value=\"0.2ms\"/>" +
						"</EXECTIME>" +
						"<EXECTIME Type=\"METHOD\" Ref=\"\\/angolo\\//r\\\\\\\\ead\">" +
						"<WORST Value=\"0.2ms\"/>" +
						"</EXECTIME>" +
						"<EXECTIME Type=\"METHOD\" Ref=\"\\/angolo\\//w\\/rit*e\">" +
						"<WORST Value=\"0.2ms\"/>" +
						"</EXECTIME>" +
						"<EXECTIME Type=\"METHOD\" Ref=\"*f/r\\\\\\\\ead\">" +
						"<WORST Value=\"0.1ms\"/>" +
						"</EXECTIME>" +
						"<EXECTIME Type=\"METHOD\" Ref=\"*f/w\\/rit*e\">" +
						"<WORST Value=\"0.1ms\"/>" +
						"</EXECTIME>" +
						"<EXECTIME Type=\"TASK\" Ref=\"Task\\\\1\">" +
						"<WORST Value=\"12.0ms\"/>" +
						"</EXECTIME>" +
						"<EXECTIME Type=\"TASK\" Ref=\"Task//2\">" +
						"<WORST Value=\"4.0ms\"/>" +
						"</EXECTIME>" +
						"<EXECTIME Type=\"TASK\" Ref=\"/Task\\\\ISR1/\">" +
						"<WORST Value=\"2.0ms\"/>" +
						"</EXECTIME>" +
						"<EXECTIME Type=\"TASK\" Ref=\"Task/ISR2\">" +
						"<WORST Value=\"1.0ms\"/>" +
						"</EXECTIME>" +
						"</ANNOTATION>" +
						"<SCHEDULABILITY>" +
							"<SCHEDULINGSCENARIO>" +
								"<CPUSCHED CpuRef=\"CPU/0.erika\" Utilization=\"1.35\" SpeedFactor=\"1.42\" Boundary=\"0.7568284600108841\" Schedulable=\"false\"/>" +
								"<TASKSCHED TaskRef=\"Task/ISR2\" Utilization=\"0.2\" CDelta=\"-2.0999999999999996\" Schedulable=\"true\" ResponseTime=\"1.0ms\"/>" +
								"<TASKSCHED TaskRef=\"Task//2\" Utilization=\"0.8\" CDelta=\"-2.0999999999999996\" Schedulable=\"false\" ResponseTime=\"Infinity\"/>" +
								"<TASKSCHED TaskRef=\"Task\\\\1\" Utilization=\"0.3\" CDelta=\"-14.0\" Schedulable=\"false\" ResponseTime=\"Infinity\"/>" +
								"<TASKSCHED TaskRef=\"/Task\\\\ISR1/\" Utilization=\"0.05\" CDelta=\"-14.0\" Schedulable=\"true\" ResponseTime=\"3.0ms\"/>" +
							"</SCHEDULINGSCENARIO>" +
						"</SCHEDULABILITY>" +
						"</SYSTEM>"
		};

	
		IVarTree vt =Vt2StringUtilities.loadString(testcase1[0]);
		
		String system = (vt.newTreeInterface()).getAllName(null, "System")[0];

		String s = JScan.startTest(vt, system, JScan.NO_OFFSET_ID, null);
		System.out.println(s);
		System.out.println(Vt2StringUtilities.varTreeToStringRtd(vt));
		
		String path = system+IVarTree.SEPARATOR
				+"Schedulability"+IVarTree.SEPARATOR
				+"SchedulingScenarioList"+IVarTree.SEPARATOR
				+DataPath.makeSlashedId((String)null)+IVarTree.SEPARATOR
				+"Reports"+IVarTree.SEPARATOR;
		if (vt.newTreeInterface().exist(path, null)) {
			vt.newTreeInterface().setValue(system+IVarTree.SEPARATOR
					+"Schedulability"+IVarTree.SEPARATOR
					+"SchedulingScenarioList"+IVarTree.SEPARATOR
					+DataPath.makeSlashedId((String)null)+IVarTree.SEPARATOR
					+"Reports"+IVarTree.SEPARATOR
					, (IVariable) null);
		}
		
		System.out.println(Vt2StringUtilities.varTreeToStringErtd(vt));
		
		IVarTree vt2 =Vt2StringUtilities.loadString(testcase1[1]);
		System.out.println(Vt2StringUtilities.varTreeToStringErtd(vt2));
		check(vt, vt2);
	}
	

	@Test
	public void test2() throws IOException {

		String[] testcase4 = {
	"<!DOCTYPE SYSTEM SYSTEM \"evidence_0.2.dtd\">" +
	"<SYSTEM Name=\"d/e/f\\au/\\\\/\\\\ltSystem\">" +
		"<MODES>" +
			"<MODE Name=\"a/b/c*\\/\"/>" +
		"</MODES>" +

		"<FUNCTIONAL>" +
			"<!-- Procedure -->" +
			"<PROC Name=\"filt*er/1\">" +
				"<METHOD Name=\"dec*ode/X\"/>" +
				"<METHODREF Name=\"i\\/m*age.r\\\\\\\\ead\" MethodName=\"i\\/m*age/r\\\\\\\\ead\"/>" +	"<!-- lettura variabile i/m*age -->" +
				"<METHODREF Name=\"x.w\\/rit*e\"        MethodName=\"x/w\\/rit*e\"/>" +	"<!-- scrittura variabile x -->" +
			"</PROC>" +
			"<PROC Name=\"der\\1\">" +
				"<METHOD Name=\"der\\X\"/>" +
				"<METHODREF Name=\"x.r\\\\\\\\ead\"  MethodName=\"x/r\\\\\\\\ead\"/>" +	"<!-- lettura variabile x -->" +
				"<METHODREF Name=\"dx.w\\/rit*e\"  MethodName=\"dx/w\\/rit*e\"/>" +	"<!-- scrittura variabile dx -->" +
			"</PROC>" +
			"<PROC Name=\"filt*er\\2\">" +
				"<METHOD Name=\"dec*ode\\\\teta/\" />" +
				"<METHODREF Name=\"\\/angolo\\/.r\\\\\\\\ead\" MethodName=\"\\/angolo\\//r\\\\\\\\ead\"/>" +	"<!-- lettura variabile \\/angolo\\/ -->" +
				"<METHODREF Name=\"\\\\teta\\/.w\\/rit*e\"    MethodName=\"\\\\teta\\//w\\/rit*e\"/>" +"<!-- scrittura variabile \\\\teta\\/ -->" +
			"</PROC>" +
			"<PROC Name=\"/d/e/r/2/\">" +
				"<METHOD Name=\"der\\teta/\" />" +
				"<METHODREF Name=\"\\\\teta\\/.r\\\\\\\\ead\"  MethodName=\"\\\\teta\\//r\\\\\\\\ead\"/>" +	"<!-- lettura variabile \\\\teta\\/ -->" +
				"<METHODREF Name=\"d\\\\teta\\/.w\\/rit*e\"  MethodName=\"d\\\\teta\\//w\\/rit*e\"/>" +	"<!-- scrittura variabile d\\\\teta\\/ -->" +
			"</PROC>" +
			"<PROC Name=\"\\//\\mat\">" +
				"<METHOD Name=\"compute/\" />" +
				"<METHODREF Name=\"x.r\\\\\\\\ead\"         MethodName=\"x/r\\\\\\\\ead\"/>" +	"<!-- lettura variabile x -->" +
				"<METHODREF Name=\"dx.r\\\\\\\\ead\"        MethodName=\"dx/r\\\\\\\\ead\"/>" +	"<!-- lettura variabile dx -->" +
				"<METHODREF Name=\"\\\\teta\\/.r\\\\\\\\ead\"  MethodName=\"\\\\teta\\//r\\\\\\\\ead\"/>" +	"<!-- lettura variabile \\\\teta\\/ -->" +
				"<METHODREF Name=\"d\\\\teta\\/.r\\\\\\\\ead\" MethodName=\"d\\\\teta\\//r\\\\\\\\ead\"/>" +	"<!-- lettura variabile d\\\\teta\\/ -->" +
				"<METHODREF Name=\"*f.w\\/rit*e\"          MethodName=\"*f/w\\/rit*e\"/>" +	"<!-- scrittura variabile f -->" +
			"</PROC>" +

			"<!-- Trigger -->" +
			"<TRIGGER Name=\"arrivo/Immagine\" >" +
				"<METHODREF Name=\"period\"              MethodName=\"\"/>" +	"<!-- metodo fittizzio per gestire la periodicita' -->" +
				"<METHODREF Name=\"i/m*age.w\\/rit*e\"      MethodName=\"i\\/m*age/w\\/rit*e\"/>" +	"<!-- scrittura dell'immagine -->" +
				"<METHODREF Name=\"filt*er\\/1.dec*ode\\/X\" MethodName=\"filt*er\\/1/dec*ode\\/X\"/>" +	"<!-- inizio decodifica -->" +
				"<METHODREF Name=\"der\\\\1.der\\\\X\"       MethodName=\"der\\\\1/der\\\\X\"/>" +	"<!-- avvio derivata -->" +
			"</TRIGGER>" +
			"<TRIGGER Name=\"arrivo/angolo/\" >" +
				"<METHODREF Name=\"period\" MethodName=\"\"/>" +	"<!-- metodo fittizzio per gestire la periodicita' -->" +
				"<METHODREF Name=\"\\/angolo\\/.w\\/rit*e\"         MethodName=\"\\/angolo\\//w\\/rit*e\"/>" +	"<!-- scrittura dell'immagine -->" +
				"<METHODREF Name=\"filt*er\\\\2.dec*ode\\\\\\\\teta\\/\" MethodName=\"filt*er\\\\2/dec*ode\\\\\\\\teta\\/\"/>" +	"<!-- inizio decodifica -->" +
				"<METHODREF Name=\"\\/d\\/e\\/r\\/2\\/.der\\\\teta\\/\" MethodName=\"\\/d\\/e\\/r\\/2\\//der\\\\teta\\/\"/>" +"<!-- avvio derivata -->" +
				"<METHODREF Name=\"\\\\\\/\\/\\\\mat.compute\\/\"      MethodName=\"\\\\\\/\\/\\\\mat/compute\\/\"/>" +	"<!-- computazione -->" +
			"</TRIGGER>" +
			"<TRIGGER Name=\"lettura/F\" >" +
				"<METHODREF Name=\"*f.r\\\\\\\\ead\" MethodName=\"*f/r\\\\\\\\ead\"/>" +	"<!-- lettura del valore finale -->" +
			"</TRIGGER>" +

			"<!-- Variabili -->" +
			"<VAR Name=\"i/m*age\" Type=\"int[][]\">" +
				"<METHOD Name=\"r\\\\ead\"/>" +
				"<METHOD Name=\"w/rit*e\"/>" +
			"</VAR>" +
			"<VAR Name=\"x\" Type=\"double\">" +
				"<METHOD Name=\"r\\\\ead\"/>" +
				"<METHOD Name=\"w/rit*e\"/>" +
			"</VAR>" +
			"<VAR Name=\"dx\" Type=\"double\">" +
				"<METHOD Name=\"r\\\\ead\"/>" +
				"<METHOD Name=\"w/rit*e\"/>" +
			"</VAR>" +
			"<VAR Name=\"/angolo/\" Type=\"double\">" +
				"<METHOD Name=\"r\\\\ead\"/>" +
				"<METHOD Name=\"w/rit*e\"/>" +
			"</VAR>" +
			"<VAR Name=\"\\teta/\" Type=\"double\">" +
				"<METHOD Name=\"r\\\\ead\"/>" +
				"<METHOD Name=\"w/rit*e\"/>" +
			"</VAR>" +
			"<VAR Name=\"d\\teta/\" Type=\"double\">" +
				"<METHOD Name=\"r\\\\ead\"/>" +
				"<METHOD Name=\"w/rit*e\"/>" +
			"</VAR>" +
			"<VAR Name=\"*f\" Type=\"double\">" +
				"<METHOD Name=\"r\\\\ead\"/>" +
				"<METHOD Name=\"w/rit*e\"/>" +
			"</VAR>" +

		"</FUNCTIONAL>" +

		"<ARCHITECTURAL>" +
			"<ECU Name=\"ECU/0\">" +
				"<CPU Name=\"CPU/0\" Model=\"ARM7\">" +
					"<RTOS Name=\"CPU/0.erika\">" +
					"</RTOS>" +
				"</CPU>" +
			"</ECU>" +

			"<!-- Elenco task -->" +
			"<TASK Name=\"Task\\\\1\" Type=\"task\">" +

				"<SCHEDULING Priority=\"1\" ModeRef=\"a/b/c*\\/\"/>" +

				"<ACTIVATION Type=\"periodic\" Period=\"40ms\" Deadline=\"35ms\" ModeRef=\"a/b/c*\\/\"/>" +
			"</TASK>" +

			"<TASK Name=\"Task//2\" Type=\"task\">" +
				"<SCHEDULING Priority=\"2\" ModeRef=\"a/b/c*\\/\"/>" +
				"<ACTIVATION Type=\"periodic\" Period=\"5ms\" Deadline=\"5ms\" ModeRef=\"a/b/c*\\/\"/>" +
			"</TASK>" +

			"<TASK Name=\"/Task\\\\ISR1/\" Type=\"ISR\">" +
				"<SCHEDULING Priority=\"3\" />" +
				"<ACTIVATION Type=\"periodic\" Period=\"40ms\" Deadline=\"5ms\"/>" +
			"</TASK>" +
			"<TASK Name=\"Task/ISR2\" Type=\"ISR\">" +
				"<SCHEDULING Priority=\"4\" />" +
				"<ACTIVATION Type=\"periodic\" Period=\"5ms\" Deadline=\"1ms\"/>" +
			"</TASK>" +

			"<!-- Elenco mutex -->" +
			"<MUTEX Name=\"Mutex/1\"/>" +
		"</ARCHITECTURAL>" +

		"<MAPPING>" +
			"<!-- Task 1 -->" +
			"<PROCMAP ProcRef=\"filt*er\\/1\" TaskRef=\"Task\\\\1\" Order=\"1\" ModeRef=\"a/b/c*\\/\"/>" +
			"<PROCMAP ProcRef=\"der\\\\1\"    TaskRef=\"Task\\\\1\" Order=\"2\" ModeRef=\"a/b/c*\\/\"/>" +
			"<TASKMAP rtosRef =\"CPU/0.erika\"    TaskRef=\"Task\\\\1\" ModeRef=\"a/b/c*\\/\"/>" +

			"<!-- Task 2 -->" +
			"<PROCMAP ProcRef=\"filt*er\\\\2\" TaskRef=\"Task//2\" Order=\"1\"/>" +
			"<PROCMAP ProcRef=\"\\/d\\/e\\/r\\/2\\/\"    TaskRef=\"Task//2\" Order=\"2\"/>" +
			"<PROCMAP ProcRef=\"\\\\\\/\\/\\\\mat\"     TaskRef=\"Task//2\" Order=\"3\"/>" +
			"<TASKMAP rtosRef =\"CPU/0.erika\"    TaskRef=\"Task//2\"/>" +

			"<TASKMAP rtosRef =\"CPU/0.erika\"    TaskRef=\"/Task\\\\ISR1/\"/>" +
			"<TASKMAP rtosRef =\"CPU/0.erika\"    TaskRef=\"Task/ISR2\"/>" +

			"<!-- Mutex 1 -->" +
			"<VARMAP VarRef=\"x\"  MutexRef=\"Mutex\\/1\" ModeRef=\"a/b/c*\\/\"/>" +
			"<VARMAP VarRef=\"dx\" MutexRef=\"Mutex\\/1\"/>" +
		"</MAPPING>" +

		"<ANNOTATION>" +
			"<EXECTIME Ref=\"x/r\\\\\\\\ead\" Type=\"METHOD\" ModeRef=\"a/b/c*\\/\">" +
				"<WORST Value=\"0.1ms\" />" +
			"</EXECTIME>" +
			"<EXECTIME Ref=\"x/w\\/rit*e\" Type=\"METHOD\" ModeRef=\"a/b/c*\\/\">" +
				"<WORST Value=\"0.1ms\" />" +
			"</EXECTIME>" +

			"<EXECTIME Ref=\"dx/r\\\\\\\\ead\" Type=\"METHOD\" ModeRef=\"a/b/c*\\/\">" +
				"<WORST Value=\"0.1ms\" />" +
			"</EXECTIME>" +
			"<EXECTIME Ref=\"dx/w\\/rit*e\" Type=\"METHOD\" ModeRef=\"a/b/c*\\/\">" +
				"<WORST Value=\"0.1ms\" />" +
			"</EXECTIME>" +

			"<EXECTIME Ref=\"\\\\teta\\//r\\\\\\\\ead\" Type=\"METHOD\">" +
				"<WORST Value=\"0.1ms\" />" +
			"</EXECTIME>" +
			"<EXECTIME Ref=\"\\\\teta\\//w\\/rit*e\" Type=\"METHOD\">" +
				"<WORST Value=\"0.1ms\" />" +
			"</EXECTIME>" +

			"<EXECTIME Ref=\"d\\\\teta\\//r\\\\\\\\ead\" Type=\"METHOD\">" +
				"<WORST Value=\"0.1ms\" />" +
			"</EXECTIME>" +
			"<EXECTIME Ref=\"d\\\\teta\\//w\\/rit*e\" Type=\"METHOD\">" +
				"<WORST Value=\"0.1ms\" />" +
			"</EXECTIME>" +

			"<EXECTIME Ref=\"i\\/m*age/r\\\\\\\\ead\" Type=\"METHOD\">" +
				"<WORST Value=\"0.2ms\" />" +
			"</EXECTIME>" +
			"<EXECTIME Ref=\"i\\/m*age/w\\/rit*e\" Type=\"METHOD\">" +
				"<WORST Value=\"0.2ms\" />" +
			"</EXECTIME>" +

			"<EXECTIME Ref=\"\\/angolo\\//r\\\\\\\\ead\" Type=\"METHOD\">" +
				"<WORST Value=\"0.2ms\" />" +
			"</EXECTIME>" +
			"<EXECTIME Ref=\"\\/angolo\\//w\\/rit*e\" Type=\"METHOD\">" +
				"<WORST Value=\"0.2ms\" />" +
			"</EXECTIME>" +

			"<EXECTIME Ref=\"*f/r\\\\\\\\ead\" Type=\"METHOD\">" +
				"<WORST Value=\"0.1ms\" />" +
			"</EXECTIME>" +
			"<EXECTIME Ref=\"*f/w\\/rit*e\" Type=\"METHOD\">" +
				"<WORST Value=\"0.1ms\" />" +
			"</EXECTIME>" +


			"<EXECTIME Ref=\"Task\\\\1\" Type=\"TASK\" ModeRef=\"a/b/c*\\/\">" +
				"<WORST Value=\"12ms\" />" +
			"</EXECTIME>" +
			"<EXECTIME Ref=\"Task//2\" Type=\"TASK\" ModeRef=\"a/b/c*\\/\">" +
				"<WORST Value=\"4ms\" />" +
			"</EXECTIME>" +

			"<EXECTIME Ref=\"/Task\\\\ISR1/\" Type=\"TASK\">" +
				"<WORST Value=\"2ms\" />" +
			"</EXECTIME>" +
			"<EXECTIME Ref=\"Task/ISR2\" Type=\"TASK\">" +
				"<WORST Value=\"1ms\" />" +
			"</EXECTIME>" +
		"</ANNOTATION>" +
	"</SYSTEM>"
	,
	/*
	 *
	 */
	"<!DOCTYPE SYSTEM SYSTEM \"evidence_0.2.dtd\">" +
	"<SYSTEM Name=\"d/e/f\\au/\\\\/\\\\ltSystem\">" +
	"<MODES>" +
		"<MODE Name=\"a/b/c*\\/\"/>" +
	"</MODES>" +

	"<FUNCTIONAL>" +
		"<!-- Procedure -->" +
		"<PROC Name=\"filt*er/1\">" +
			"<METHOD Name=\"dec*ode/X\"/>" +
			"<METHODREF Name=\"i\\/m*age.r\\\\\\\\ead\" MethodName=\"i\\/m*age/r\\\\\\\\ead\"/>" +	"<!-- lettura variabile i/m*age -->" +
			"<METHODREF Name=\"x.w\\/rit*e\"        MethodName=\"x/w\\/rit*e\"/>" +	"<!-- scrittura variabile x -->" +
		"</PROC>" +
		"<PROC Name=\"der\\1\">" +
			"<METHOD Name=\"der\\X\"/>" +
			"<METHODREF Name=\"x.r\\\\\\\\ead\"  MethodName=\"x/r\\\\\\\\ead\"/>" +	"<!-- lettura variabile x -->" +
			"<METHODREF Name=\"dx.w\\/rit*e\"  MethodName=\"dx/w\\/rit*e\"/>" +	"<!-- scrittura variabile dx -->" +
		"</PROC>" +
		"<PROC Name=\"filt*er\\2\">" +
			"<METHOD Name=\"dec*ode\\\\teta/\" />" +
			"<METHODREF Name=\"\\/angolo\\/.r\\\\\\\\ead\" MethodName=\"\\/angolo\\//r\\\\\\\\ead\"/>" +	"<!-- lettura variabile \\/angolo\\/ -->" +
			"<METHODREF Name=\"\\\\teta\\/.w\\/rit*e\"    MethodName=\"\\\\teta\\//w\\/rit*e\"/>" +"<!-- scrittura variabile \\\\teta\\/ -->" +
		"</PROC>" +
		"<PROC Name=\"/d/e/r/2/\">" +
			"<METHOD Name=\"der\\teta/\" />" +
			"<METHODREF Name=\"\\\\teta\\/.r\\\\\\\\ead\"  MethodName=\"\\\\teta\\//r\\\\\\\\ead\"/>" +	"<!-- lettura variabile \\\\teta\\/ -->" +
			"<METHODREF Name=\"d\\\\teta\\/.w\\/rit*e\"  MethodName=\"d\\\\teta\\//w\\/rit*e\"/>" +	"<!-- scrittura variabile d\\\\teta\\/ -->" +
		"</PROC>" +
		"<PROC Name=\"\\//\\mat\">" +
			"<METHOD Name=\"compute/\" />" +
			"<METHODREF Name=\"x.r\\\\\\\\ead\"         MethodName=\"x/r\\\\\\\\ead\"/>" +	"<!-- lettura variabile x -->" +
			"<METHODREF Name=\"dx.r\\\\\\\\ead\"        MethodName=\"dx/r\\\\\\\\ead\"/>" +	"<!-- lettura variabile dx -->" +
			"<METHODREF Name=\"\\\\teta\\/.r\\\\\\\\ead\"  MethodName=\"\\\\teta\\//r\\\\\\\\ead\"/>" +	"<!-- lettura variabile \\\\teta\\/ -->" +
			"<METHODREF Name=\"d\\\\teta\\/.r\\\\\\\\ead\" MethodName=\"d\\\\teta\\//r\\\\\\\\ead\"/>" +	"<!-- lettura variabile d\\\\teta\\/ -->" +
			"<METHODREF Name=\"*f.w\\/rit*e\"          MethodName=\"*f/w\\/rit*e\"/>" +	"<!-- scrittura variabile f -->" +
		"</PROC>" +

		"<!-- Trigger -->" +
		"<TRIGGER Name=\"arrivo/Immagine\" >" +
			"<METHODREF Name=\"period\"              MethodName=\"\"/>" +	"<!-- metodo fittizzio per gestire la periodicita' -->" +
			"<METHODREF Name=\"i/m*age.w\\/rit*e\"      MethodName=\"i\\/m*age/w\\/rit*e\"/>" +	"<!-- scrittura dell'immagine -->" +
			"<METHODREF Name=\"filt*er\\/1.dec*ode\\/X\" MethodName=\"filt*er\\/1/dec*ode\\/X\"/>" +	"<!-- inizio decodifica -->" +
			"<METHODREF Name=\"der\\\\1.der\\\\X\"       MethodName=\"der\\\\1/der\\\\X\"/>" +	"<!-- avvio derivata -->" +
		"</TRIGGER>" +
		"<TRIGGER Name=\"arrivo/angolo/\" >" +
			"<METHODREF Name=\"period\" MethodName=\"\"/>" +	"<!-- metodo fittizzio per gestire la periodicita' -->" +
			"<METHODREF Name=\"\\/angolo\\/.w\\/rit*e\"         MethodName=\"\\/angolo\\//w\\/rit*e\"/>" +	"<!-- scrittura dell'immagine -->" +
			"<METHODREF Name=\"filt*er\\\\2.dec*ode\\\\\\\\teta\\/\" MethodName=\"filt*er\\\\2/dec*ode\\\\\\\\teta\\/\"/>" +	"<!-- inizio decodifica -->" +
			"<METHODREF Name=\"\\/d\\/e\\/r\\/2\\/.der\\\\teta\\/\" MethodName=\"\\/d\\/e\\/r\\/2\\//der\\\\teta\\/\"/>" +"<!-- avvio derivata -->" +
			"<METHODREF Name=\"\\\\\\/\\/\\\\mat.compute\\/\"      MethodName=\"\\\\\\/\\/\\\\mat/compute\\/\"/>" +	"<!-- computazione -->" +
		"</TRIGGER>" +
		"<TRIGGER Name=\"lettura/F\" >" +
			"<METHODREF Name=\"*f.r\\\\\\\\ead\" MethodName=\"*f/r\\\\\\\\ead\"/>" +	"<!-- lettura del valore finale -->" +
		"</TRIGGER>" +

		"<!-- Variabili -->" +
		"<VAR Name=\"i/m*age\" Type=\"int[][]\">" +
			"<METHOD Name=\"r\\\\ead\"/>" +
			"<METHOD Name=\"w/rit*e\"/>" +
		"</VAR>" +
		"<VAR Name=\"x\" Type=\"double\">" +
			"<METHOD Name=\"r\\\\ead\"/>" +
			"<METHOD Name=\"w/rit*e\"/>" +
		"</VAR>" +
		"<VAR Name=\"dx\" Type=\"double\">" +
			"<METHOD Name=\"r\\\\ead\"/>" +
			"<METHOD Name=\"w/rit*e\"/>" +
		"</VAR>" +
		"<VAR Name=\"/angolo/\" Type=\"double\">" +
			"<METHOD Name=\"r\\\\ead\"/>" +
			"<METHOD Name=\"w/rit*e\"/>" +
		"</VAR>" +
		"<VAR Name=\"\\teta/\" Type=\"double\">" +
			"<METHOD Name=\"r\\\\ead\"/>" +
			"<METHOD Name=\"w/rit*e\"/>" +
		"</VAR>" +
		"<VAR Name=\"d\\teta/\" Type=\"double\">" +
			"<METHOD Name=\"r\\\\ead\"/>" +
			"<METHOD Name=\"w/rit*e\"/>" +
		"</VAR>" +
		"<VAR Name=\"*f\" Type=\"double\">" +
			"<METHOD Name=\"r\\\\ead\"/>" +
			"<METHOD Name=\"w/rit*e\"/>" +
		"</VAR>" +

	"</FUNCTIONAL>" +

	"<ARCHITECTURAL>" +
		"<ECU Name=\"ECU/0\">" +
			"<CPU Name=\"CPU/0\" Model=\"ARM7\">" +
				"<RTOS Name=\"CPU/0.erika\">" +
				"</RTOS>" +
			"</CPU>" +
		"</ECU>" +

		"<!-- Elenco task -->" +
		"<TASK Name=\"Task\\\\1\" Type=\"task\">" +

			"<SCHEDULING Priority=\"1\" ModeRef=\"a/b/c*\\/\"/>" +

			"<ACTIVATION Type=\"periodic\" Period=\"40ms\" Deadline=\"35ms\" ModeRef=\"a/b/c*\\/\"/>" +
		"</TASK>" +

		"<TASK Name=\"Task//2\" Type=\"task\">" +
			"<SCHEDULING Priority=\"2\" ModeRef=\"a/b/c*\\/\"/>" +
			"<ACTIVATION Type=\"periodic\" Period=\"5ms\" Deadline=\"5ms\" ModeRef=\"a/b/c*\\/\"/>" +
		"</TASK>" +

		"<TASK Name=\"/Task\\\\ISR1/\" Type=\"ISR\">" +
			"<SCHEDULING Priority=\"3\" />" +
			"<SCHEDULING Priority=\"3\" ModeRef=\"a/b/c*\\/\"/>" +
			"<ACTIVATION Type=\"periodic\" Period=\"40ms\" Deadline=\"5ms\"/>" +
			"<ACTIVATION Type=\"periodic\" Period=\"40ms\" Deadline=\"5ms\" ModeRef=\"a/b/c*\\/\"/>" +
		"</TASK>" +
		"<TASK Name=\"Task/ISR2\" Type=\"ISR\">" +
			"<SCHEDULING Priority=\"4\" />" +
			"<SCHEDULING Priority=\"4\" ModeRef=\"a/b/c*\\/\"/>" +
			"<ACTIVATION Type=\"periodic\" Period=\"5ms\" Deadline=\"1ms\"/>" +
			"<ACTIVATION Type=\"periodic\" Period=\"5ms\" Deadline=\"1ms\" ModeRef=\"a/b/c*\\/\"/>" +
		"</TASK>" +

		"<!-- Elenco mutex -->" +
		"<MUTEX Name=\"Mutex/1\"/>" +
	"</ARCHITECTURAL>" +

	"<MAPPING>" +
		"<!-- Task 1 -->" +
		"<PROCMAP ProcRef=\"filt*er\\/1\" TaskRef=\"Task\\\\1\" Order=\"1\" ModeRef=\"a/b/c*\\/\"/>" +
		"<PROCMAP ProcRef=\"der\\\\1\"    TaskRef=\"Task\\\\1\" Order=\"2\" ModeRef=\"a/b/c*\\/\"/>" +
		"<TASKMAP rtosRef =\"CPU/0.erika\"    TaskRef=\"Task\\\\1\" ModeRef=\"a/b/c*\\/\"/>" +

		"<!-- Task 2 -->" +
		"<PROCMAP ProcRef=\"filt*er\\\\2\" TaskRef=\"Task//2\" Order=\"1\"/>" +
		"<PROCMAP ProcRef=\"\\/d\\/e\\/r\\/2\\/\"    TaskRef=\"Task//2\" Order=\"2\"/>" +
		"<PROCMAP ProcRef=\"\\\\\\/\\/\\\\mat\"     TaskRef=\"Task//2\" Order=\"3\"/>" +
		"<TASKMAP rtosRef =\"CPU/0.erika\"    TaskRef=\"Task//2\"/>" +

		"<TASKMAP rtosRef =\"CPU/0.erika\"    TaskRef=\"/Task\\\\ISR1/\"/>" +
		"<TASKMAP rtosRef =\"CPU/0.erika\"    TaskRef=\"Task/ISR2\"/>" +

		"<!-- Mutex 1 -->" +
		"<VARMAP VarRef=\"x\"  MutexRef=\"Mutex\\/1\" ModeRef=\"a/b/c*\\/\"/>" +
		"<VARMAP VarRef=\"dx\" MutexRef=\"Mutex\\/1\"/>" +
	"</MAPPING>" +

	"<ANNOTATION>" +
		"<EXECTIME Ref=\"x/r\\\\\\\\ead\" Type=\"METHOD\" ModeRef=\"a/b/c*\\/\">" +
			"<WORST Value=\"0.1ms\" />" +
		"</EXECTIME>" +
		"<EXECTIME Ref=\"x/w\\/rit*e\" Type=\"METHOD\" ModeRef=\"a/b/c*\\/\">" +
			"<WORST Value=\"0.1ms\" />" +
		"</EXECTIME>" +

		"<EXECTIME Ref=\"dx/r\\\\\\\\ead\" Type=\"METHOD\" ModeRef=\"a/b/c*\\/\">" +
			"<WORST Value=\"0.1ms\" />" +
		"</EXECTIME>" +
		"<EXECTIME Ref=\"dx/w\\/rit*e\" Type=\"METHOD\" ModeRef=\"a/b/c*\\/\">" +
			"<WORST Value=\"0.1ms\" />" +
		"</EXECTIME>" +

		"<EXECTIME Ref=\"\\\\teta\\//r\\\\\\\\ead\" Type=\"METHOD\">" +
			"<WORST Value=\"0.1ms\" />" +
		"</EXECTIME>" +
		"<EXECTIME Ref=\"\\\\teta\\//w\\/rit*e\" Type=\"METHOD\">" +
			"<WORST Value=\"0.1ms\" />" +
		"</EXECTIME>" +

		"<EXECTIME Ref=\"d\\\\teta\\//r\\\\\\\\ead\" Type=\"METHOD\">" +
			"<WORST Value=\"0.1ms\" />" +
		"</EXECTIME>" +
		"<EXECTIME Ref=\"d\\\\teta\\//w\\/rit*e\" Type=\"METHOD\">" +
			"<WORST Value=\"0.1ms\" />" +
		"</EXECTIME>" +

		"<EXECTIME Ref=\"i\\/m*age/r\\\\\\\\ead\" Type=\"METHOD\">" +
			"<WORST Value=\"0.2ms\" />" +
		"</EXECTIME>" +
		"<EXECTIME Ref=\"i\\/m*age/w\\/rit*e\" Type=\"METHOD\">" +
			"<WORST Value=\"0.2ms\" />" +
		"</EXECTIME>" +

		"<EXECTIME Ref=\"\\/angolo\\//r\\\\\\\\ead\" Type=\"METHOD\">" +
			"<WORST Value=\"0.2ms\" />" +
		"</EXECTIME>" +
		"<EXECTIME Ref=\"\\/angolo\\//w\\/rit*e\" Type=\"METHOD\">" +
			"<WORST Value=\"0.2ms\" />" +
		"</EXECTIME>" +

		"<EXECTIME Ref=\"*f/r\\\\\\\\ead\" Type=\"METHOD\">" +
			"<WORST Value=\"0.1ms\" />" +
		"</EXECTIME>" +
		"<EXECTIME Ref=\"*f/w\\/rit*e\" Type=\"METHOD\">" +
			"<WORST Value=\"0.1ms\" />" +
		"</EXECTIME>" +


		"<EXECTIME Ref=\"Task\\\\1\" Type=\"TASK\" ModeRef=\"a/b/c*\\/\">" +
			"<WORST Value=\"12ms\" />" +
		"</EXECTIME>" +
		"<EXECTIME Ref=\"Task//2\" Type=\"TASK\" ModeRef=\"a/b/c*\\/\">" +
			"<WORST Value=\"4ms\" />" +
		"</EXECTIME>" +

		"<EXECTIME Ref=\"/Task\\\\ISR1/\" Type=\"TASK\">" +
			"<WORST Value=\"2ms\" />" +
		"</EXECTIME>" +
		"<EXECTIME Ref=\"Task/ISR2\" Type=\"TASK\">" +
			"<WORST Value=\"1ms\" />" +
		"</EXECTIME>" +

		"<EXECTIME Ref=\"/Task\\\\ISR1/\" Type=\"TASK\" ModeRef=\"a/b/c*\\/\">" +
			"<WORST Value=\"2ms\" />" +
		"</EXECTIME>" +
		"<EXECTIME Ref=\"Task/ISR2\" Type=\"TASK\" ModeRef=\"a/b/c*\\/\">" +
			"<WORST Value=\"1ms\" />" +
		"</EXECTIME>" +
		
	"</ANNOTATION>" +
	"<SCHEDULABILITY>" +
		"<SCHEDULINGSCENARIO ModeRef=\"a/b/c*\\/\">" +
			"<CPUSCHED CpuRef=\"CPU/0.erika\" Utilization=\"1.35\" SpeedFactor=\"1.42\" Boundary=\"0.7568284600108841\" Schedulable=\"false\"/>" +
			"<TASKSCHED TaskRef=\"Task/ISR2\" Utilization=\"0.2\" CDelta=\"-2.0999999999999996\" Schedulable=\"true\" ResponseTime=\"1.0ms\"/>" +
			"<TASKSCHED TaskRef=\"Task//2\" Utilization=\"0.8\" CDelta=\"-2.0999999999999996\" Schedulable=\"false\" ResponseTime=\"Infinity\"/>" +
			"<TASKSCHED TaskRef=\"Task\\\\1\" Utilization=\"0.3\" CDelta=\"-14.0\" Schedulable=\"false\" ResponseTime=\"Infinity\"/>" +
			"<TASKSCHED TaskRef=\"/Task\\\\ISR1/\" Utilization=\"0.05\" CDelta=\"-14.0\" Schedulable=\"true\" ResponseTime=\"3.0ms\"/>" +
		"</SCHEDULINGSCENARIO>" +
	"</SCHEDULABILITY>" +
"</SYSTEM>"
		};

		char S = DataPath.SEPARATOR;
		
		IVarTree vt =Vt2StringUtilities.loadString(testcase4[0]);
		
/* Is equals to TestCase 004
 	
 	 	Resource res = (new MyXMIResourceFactoryImpl()).createResource(
				URI.createFileURI("/home/durin/work/rtdruid/src/rtdruid_base/testcase/004/data.rtd")
		);
		try {
			res.load(new HashMap());
		} catch (Exception e) {
			assertTrue(false);
		}
		
System.out.println("\nFirst check\n");
		check(vt, (EObject) res.getContents().get(0));
*/		

		ITreeInterface ti = vt.newTreeInterface();
		String system = ti.getAllName(null, "System")[0];
		String mode = ti.getAllName(system + S + "Modes" + S + "ModeList", "Mode")[0];

		mode = DataPath.removeSlash(DataPath.removeSlash(mode));
		
		// check for resources
		TaskSet ts = new TaskSet(vt, system, mode);
		ts.setProperty("resource", "", false);
		assertEquals(2, ts.getPrefixNumber());
		final int cpuId = 1;
		assertEquals(4, ts.getSize(cpuId));
		{
			Task t = (Task) ts.getItem(cpuId, 0);
			assertEquals("Task\\\\1", t.getName());
			Enumeration<String> en = t.getAllResources();
			assertTrue(en.hasMoreElements());
			assertEquals("Mutex/1",  en.nextElement());
			assertEquals(false, en.hasMoreElements());
		}
		{
			Task t = (Task) ts.getItem(cpuId, 1);
			assertEquals("Task//2", t.getName());
			Enumeration<String> en = t.getAllResources();
			assertTrue(en.hasMoreElements());
			assertEquals("Mutex/1",  en.nextElement());
			assertEquals(false, en.hasMoreElements());
		}
		{
			Task t = (Task) ts.getItem(cpuId, 2);
			assertEquals("/Task\\\\ISR1/", t.getName());
			assertEquals(false, t.getAllResources().hasMoreElements());
		}
		{
			Task t = (Task) ts.getItem(cpuId, 3);
			assertEquals("Task/ISR2", t.getName());
			assertEquals(false, t.getAllResources().hasMoreElements());
		}
		
		
System.out.println("\nStart test with mode ..." + mode + "\n");
		Properties prop = new Properties();
		prop.setProperty(JScan.MODE_STR, mode);
		JScan.startTest(vt, system, JScan.NO_OFFSET_ID, prop);
		//System.out.println(JScan.startTest(vt, system, JScan.NO_OFFSET_ID, prop));
		
		vt.newTreeInterface().setValue(system+IVarTree.SEPARATOR
				+"Schedulability"+IVarTree.SEPARATOR
				+"SchedulingScenarioList"+IVarTree.SEPARATOR
				+DataPath.makeSlashedId(mode)+IVarTree.SEPARATOR
				+"Reports"+IVarTree.SEPARATOR
				, (IVariable) null);
		check(vt, Vt2StringUtilities.loadString(testcase4[1]));
	}
	
	
}
