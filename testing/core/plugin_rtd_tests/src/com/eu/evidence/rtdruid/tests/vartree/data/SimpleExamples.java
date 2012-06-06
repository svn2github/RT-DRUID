/*
 * Created on 16-mar-2004
 *
 * $Id: EvidenceTest.java,v 1.2 2007/09/28 11:16:27 durin Exp $
 */
package com.eu.evidence.rtdruid.tests.vartree.data;




/**
 * @author  Nicola Serreli
 */
public class SimpleExamples {

	public final static SimpleExamples instance = new SimpleExamples();
	
	/**	test : try to load an example
	*/
	public static String testLoadExample1() {
		String testo = 

			"<!DOCTYPE SYSTEM SYSTEM \"evidence_0.2.dtd\">" +
			"<SYSTEM Name=\"defaultSystem\" >" +
				"<FUNCTIONAL>" +
					"<!-- Procedure -->" +
					"<PROC Name=\"filter1\" >" +
						"<METHOD Name=\"run\" />" +
						"<METHODREF Name=\"image.read\"  MethodName=\"image/read\" />" +
						"<METHODREF Name=\"x.write\"     MethodName=\"x/write\" />" +
					"</PROC>" +
					"<PROC Name=\"der1\" >" +
						"<METHOD Name=\"run\" />" +
						"<METHODREF Name=\"x.read\"    MethodName=\"x/read\" />" +
						"<METHODREF Name=\"dx.write\"  MethodName=\"dx/write\" />" +
					"</PROC>" +
					"<PROC Name=\"filter2\" >" +
						"<METHOD Name=\"run\" />" +
						"<METHODREF Name=\"angle.read\"  MethodName=\"angle/read\" />" +
						"<METHODREF Name=\"teta.write\"   MethodName=\"teta/write\" />" +
					"</PROC>" +
					"<PROC Name=\"der2\" >" +
						"<METHOD Name=\"run\" />" +
						"<METHODREF Name=\"teta.read\"    MethodName=\"teta/read\" />" +	"<!-- lettura variabile teta -->" +
						"<METHODREF Name=\"dteta.write\"  MethodName=\"dteta/write\" />" +	"<!-- scrittura variabile dteta -->" +
					"</PROC>" +
					"<PROC Name=\"mat\" >" +
						"<METHOD Name=\"run\" />" +
						"<METHODREF Name=\"x.read\"      MethodName=\"x/read\" />" +	"<!-- lettura variabile x -->" +
						"<METHODREF Name=\"dx.read\"     MethodName=\"dx/read\" />" +	"<!-- lettura variabile dx -->" +
						"<METHODREF Name=\"teta.read\"   MethodName=\"teta/read\" />" +	"<!-- lettura variabile teta -->" +
						"<METHODREF Name=\"dteta.read\"  MethodName=\"dteta/read\" />" +	"<!-- lettura variabile dteta -->" +
						"<METHODREF Name=\"f.write\"     MethodName=\"f/write\" />" +	"<!-- scrittura variabile f -->" +
					"</PROC>" +

					"<!-- Trigger -->" +
					"<TRIGGER Name=\"nextImage\"  >" +
						"<METHODREF Name=\"image.write\"      MethodName=\"image/write\" />" +
						"<METHODREF Name=\"filter1.decodeX\"  MethodName=\"filter1/run\" />" +
						"<METHODREF Name=\"der1.run\"         MethodName=\"der1/run\" />" +
					"</TRIGGER>" +
					"<TRIGGER Name=\"nextAngle\"  >" +
						"<METHODREF Name=\"angle.write\"  MethodName=\"angle/write\" />" +	"<!-- scrittura dell'immagine -->" +
						"<METHODREF Name=\"filter2.run\"   MethodName=\"filter2/run\" />" +	"<!-- inizio decodifica -->" +
						"<METHODREF Name=\"der2.run\"      MethodName=\"der2/run\" />" +"<!-- avvio derivata -->" +
						"<METHODREF Name=\"mat.run\"       MethodName=\"mat/run\" />" +	"<!-- computazione -->" +
					"</TRIGGER>" +
					"<TRIGGER Name=\"letturaF\"  >" +
						"<METHODREF Name=\"f.read\"  MethodName=\"f/read\" />" +	"<!-- lettura del valore finale -->" +
					"</TRIGGER>" +

					"<!-- Variabili -->" +
					"<VAR Name=\"image\"   Type=\"int[][]\" />" +
					"<VAR Name=\"x\"       Type=\"double\" />" +
					"<VAR Name=\"dx\"      Type=\"double\" />" +
					"<VAR Name=\"angle\"  Type=\"double\" />" +
					"<VAR Name=\"teta\"    Type=\"double\" />" +
					"<VAR Name=\"dteta\"   Type=\"double\" />" +
					"<VAR Name=\"f\"       Type=\"double\" />" +

					"<!-- Eventi significativi -->" +
						"<!-- Periodicita' -->" +
					"<EVENT Name=\"triggerX.act\" Type=\"activation\" MethodRefName=\"nextImage/image.write\" />" +
					"<EVENT Name=\"triggerTeta.act\" Type=\"activation\" MethodRefName=\"nextAngle/angle.write\" />" +
					"<EVENT Name=\"letturaF.act\" Type=\"activation\" MethodRefName=\"letturaF/f.read\" />" +

						"<!-- Eventi di precedenza del trigger X -->" +
					"<EVENT Name=\"triggerX.image.begin\" Type=\"begin\" MethodRefName=\"nextImage/image.write\" />" +
					"<EVENT Name=\"triggerX.image.end\" Type=\"end\" MethodRefName=\"nextImage/image.write\" />" +
					"<EVENT Name=\"triggerX.filter1.begin\" Type=\"begin\" MethodRefName=\"nextImage/filter1.decodeX\" />" +
					"<EVENT Name=\"triggerX.filter1.end\" Type=\"end\" MethodRefName=\"nextImage/filter1.decodeX\" />" +
					"<EVENT Name=\"triggerX.der1.begin\" Type=\"begin\" MethodRefName=\"nextImage/der1.run\" />" +
					"<EVENT Name=\"triggerX.der1.end\" Type=\"end\" MethodRefName=\"nextImage/der1.run\" />" +

						"<!-- Eventi di precedenza del trigger Teta -->" +
					"<EVENT Name=\"triggerTeta.angle\" Type=\"end\" MethodRefName=\"nextAngle/angle.write\" />" +
					"<EVENT Name=\"triggerTeta.filter2.begin\"  Type=\"begin\" MethodRefName=\"nextAngle/filter2.run\" />" +
					"<EVENT Name=\"triggerTeta.filter2.end\" Type=\"end\" MethodRefName=\"nextAngle/filter2.run\" />" +
					"<EVENT Name=\"triggerTeta.der2.begin\" Type=\"begin\" MethodRefName=\"nextAngle/der2.run\" />" +
					"<EVENT Name=\"triggerTeta.der2.end\" Type=\"end\" MethodRefName=\"nextAngle/der2.run\" />" +
					"<EVENT Name=\"triggerTeta.mat.begin\" Type=\"begin\" MethodRefName=\"nextAngle/mat.run\" />" +
					"<EVENT Name=\"triggerTeta.mat.end\" Type=\"end\" MethodRefName=\"nextAngle/mat.run\" />" +

					"<!-- OrdiNamento parziale -->" +
					"<PARTIALORDER>" +

					"<!-- Linea X -->" +
						"<!-- Attivazioni -->" +
						"<ORDER>" + 
							"<EVENTREF Name=\"triggerX.act\" />" +
							"<EVENTREF Name=\"triggerX.image.begin\" />" +
						"</ORDER>" +

						"<ORDER>" +
							"<EVENTREF Name=\"triggerX.image.end\" />" +
							"<EVENTREF Name=\"triggerX.filter1.begin\" />" +
						"</ORDER>" +

						"<ORDER>" +
							"<EVENTREF Name=\"triggerX.filter1.end\" />" +
							"<EVENTREF Name=\"triggerX.der1.begin\" />" +
						"</ORDER>" +


					"<!-- Linea Teta -->" +
						"<!-- Attivazioni -->" +
						"<ORDER>" + 
							"<EVENTREF Name=\"triggerTeta.act\" />" +
							"<EVENTREF Name=\"triggerTeta.angle.begin\" />" +
						"</ORDER>" +
						"<ORDER>" +
							"<EVENTREF Name=\"triggerTeta.angle.end\" />" +
							"<EVENTREF Name=\"triggerTeta.filter2.begin\" />" +
						"</ORDER>" +
						"<ORDER>" +
							"<EVENTREF Name=\"triggerTeta.filter2.end\" />" +
							"<EVENTREF Name=\"triggerTeta.der2.begin\" />" +
						"</ORDER>" +
						"<ORDER>" +
							"<EVENTREF Name=\"triggerTeta.der2.end\" />" +
							"<EVENTREF Name=\"triggerTeta.mat.begin\" />" +
						"</ORDER>" +


					"</PARTIALORDER>" +


					"<!-- Relazioni temporali tra eventi -->" +
					"<TIMECONST>" + "<!-- periodicita' del trigger dell'immagine -->" +
						"<EVENTREF Name=\"triggerX.act\" />" +
						"<BOUND Type=\"period\"  Value=\"40ms\" />" +
					"</TIMECONST>" +
					"<TIMECONST>" + "<!-- periodicita' del trigger sull'angle -->" +
						"<EVENTREF Name=\"triggerTeta.act\" />" +
						"<BOUND Type=\"period\"  Value=\"5ms\" />" +
					"</TIMECONST>" +
					"<TIMECONST>" + "<!-- periodicita' del trigger di lettura del risultato -->" +
						"<EVENTREF Name=\"letturaF.period\" />" +
						"<BOUND Type=\"period\"  Value=\"5ms\" />" +
					"</TIMECONST>" +

					"<!-- Linea X -->" +
					"<TIMECONST>" + 
						"<EVENTREF Name=\"triggerX.act\" />" +
						"<EVENTREF Name=\"der1.end\" />" +
						"<BOUND Type=\"deadline\"  Value=\"35ms\" />" +
					"</TIMECONST>" +
					"<TIMECONST>" + 
						"<EVENTREF Name=\"triggerX.act\" />" +
						"<EVENTREF Name=\"mat.end\" />" +
						"<BOUND Type=\"deadline\"  Value=\"40ms\" />" +
					"</TIMECONST>" +
					"<TIMECONST>" + 
						"<EVENTREF Name=\"triggerTeta.act\" />" +
						"<EVENTREF Name=\"mat.end\" />" +
						"<BOUND Type=\"deadline\"  Value=\"5ms\" />" +
					"</TIMECONST>" +
				"</FUNCTIONAL>" +

				"<ARCHITECTURAL>" +
					"<ECU Name=\"ECU0\" >" +
						"<CPU Name=\"CPU0\"  Model=\"ARM7\" >" +
							"<RTOS Name=\"CPU0.erika\" >" +
							"</RTOS>" +
						"</CPU>" +
					"</ECU>" +

					"<!-- Elenco task -->" +
					"<TASK Name=\"Task1\"  Type=\"task\" >" +

						"<SCHEDULING Priority=\"1\"  />" +

						"<ACTIVATION Type=\"periodic\"  Period=\"40ms\"  Deadline=\"35ms\"  />" +
					"</TASK>" +

					"<TASK Name=\"Task2\"  Type=\"task\" >" +
						"<SCHEDULING Priority=\"2\"  />" +
						"<ACTIVATION Type=\"periodic\"  Period=\"5ms\"  Deadline=\"5ms\"  />" +
					"</TASK>" +

					"<TASK Name=\"TaskISR1\"  Type=\"ISR\" >" +
						"<SCHEDULING Priority=\"3\"  />" +
						"<ACTIVATION Type=\"periodic\"  Period=\"40ms\"  Deadline=\"5ms\" />" +
					"</TASK>" +
					"<TASK Name=\"TaskISR2\"  Type=\"ISR\" >" +
						"<SCHEDULING Priority=\"4\"  />" +
						"<ACTIVATION Type=\"periodic\"  Period=\"5ms\"  Deadline=\"1ms\" />" +
					"</TASK>" +

					"<!-- Elenco mutex -->" +
					"<MUTEX Name=\"Mutex1\" />" +
				"</ARCHITECTURAL>" +

				"<MAPPING>" +
					"<!-- Task 1 -->" +
					"<PROCMAP ProcRef=\"filter1\"  TaskRef=\"Task1\"  Order=\"1\" />" +
					"<PROCMAP ProcRef=\"der1\"     TaskRef=\"Task1\"  Order=\"2\" />" +
					"<TASKMAP rtosRef =\"CPU0.erika\"     TaskRef=\"Task1\" />" +

					"<!-- Task 2 -->" +
					"<PROCMAP ProcRef=\"filter2\"  TaskRef=\"Task2\"  Order=\"1\" />" +
					"<PROCMAP ProcRef=\"der2\"     TaskRef=\"Task2\"  Order=\"2\" />" +
					"<PROCMAP ProcRef=\"mat\"      TaskRef=\"Task2\"  Order=\"3\" />" +
					"<TASKMAP rtosRef =\"CPU0.erika\"     TaskRef=\"Task2\" />" +

					"<TASKMAP rtosRef =\"CPU0.erika\"     TaskRef=\"TaskISR1\" />" +
					"<TASKMAP rtosRef =\"CPU0.erika\"     TaskRef=\"TaskISR2\" />" +

					"<!-- Mutex 1 -->" +
					"<VARMAP VarRef=\"x\"   MutexRef=\"Mutex1\" />" +
					"<VARMAP VarRef=\"dx\"  MutexRef=\"Mutex1\" />" +
				"</MAPPING>" +

				"<ANNOTATION>" +
					"<EXECTIME Ref=\"x/read\"  Type=\"METHOD\" >" +
						"<WORST Value=\"0.1ms\"  />" +
					"</EXECTIME>" +
					"<EXECTIME Ref=\"x/write\"  Type=\"METHOD\" >" +
						"<WORST Value=\"0.1ms\"  />" +
					"</EXECTIME>" +

					"<EXECTIME Ref=\"dx/read\"  Type=\"METHOD\" >" +
						"<WORST Value=\"0.1ms\"  />" +
					"</EXECTIME>" +
					"<EXECTIME Ref=\"dx/write\"  Type=\"METHOD\" >" +
						"<WORST Value=\"0.1ms\"  />" +
					"</EXECTIME>" +

					"<EXECTIME Ref=\"teta/read\"  Type=\"METHOD\" >" +
						"<WORST Value=\"0.1ms\"  />" +
					"</EXECTIME>" +
					"<EXECTIME Ref=\"teta/write\"  Type=\"METHOD\" >" +
						"<WORST Value=\"0.1ms\"  />" +
					"</EXECTIME>" +

					"<EXECTIME Ref=\"dteta/read\"  Type=\"METHOD\" >" +
						"<WORST Value=\"0.1ms\"  />" +
					"</EXECTIME>" +
					"<EXECTIME Ref=\"dteta/write\"  Type=\"METHOD\" >" +
						"<WORST Value=\"0.1ms\"  />" +
					"</EXECTIME>" +

					"<EXECTIME Ref=\"image/read\"  Type=\"METHOD\" >" +
						"<WORST Value=\"0.2ms\"  />" +
					"</EXECTIME>" +
					"<EXECTIME Ref=\"image/write\"  Type=\"METHOD\" >" +
						"<WORST Value=\"0.2ms\"  />" +
					"</EXECTIME>" +

					"<EXECTIME Ref=\"angle/read\"  Type=\"METHOD\" >" +
						"<WORST Value=\"0.2ms\"  />" +
					"</EXECTIME>" +
					"<EXECTIME Ref=\"angle/write\"  Type=\"METHOD\" >" +
						"<WORST Value=\"0.2ms\"  />" +
					"</EXECTIME>" +

					"<EXECTIME Ref=\"f/read\"  Type=\"METHOD\" >" +
						"<WORST Value=\"0.1ms\"  />" +
					"</EXECTIME>" +
					"<EXECTIME Ref=\"f/write\"  Type=\"METHOD\" >" +
						"<WORST Value=\"0.1ms\"  />" +
					"</EXECTIME>" +


					"<EXECTIME Ref=\"Task1\"  Type=\"TASK\" >" +
						"<WORST Value=\"12ms\"  />" +
					"</EXECTIME>" +
					"<EXECTIME Ref=\"Task2\"  Type=\"TASK\" >" +
						"<WORST Value=\"1ms\"  />" +
					"</EXECTIME>" +

					"<EXECTIME Ref=\"TaskISR1\"  Type=\"TASK\" >" +
						"<WORST Value=\"2ms\"  />" +
					"</EXECTIME>" +
					"<EXECTIME Ref=\"TaskISR2\"  Type=\"TASK\" >" +
						"<WORST Value=\"1ms\" />" +
					"</EXECTIME>" +
				"</ANNOTATION>" +
			"</SYSTEM>";

		return testo;
	}

	/**	test : try to load an example
	*/
	public static String testLoadExample2() {
		String testo = 
		"<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
		"<!DOCTYPE SYSTEM SYSTEM \"evidence_0.2.dtd\">" +
		"<SYSTEM Name=\"Root/\">" +
		"<FUNCTIONAL>" +
		"<SUBSYSTEM Name=\"Sub1\"> <IMPLEMENTATION>" +
			"<PROC Name=\"/Behavior/Project_SFA_v06/Lenkfunktion_Int/Lenkfunktion_Int_CalcProcess\">" +
			"	<METHOD Name=\"run\"/>" +
			"</PROC>" +
			"<PROC Name=\"/Behavior/Project_SFA_v06/CAN_Input/CAN_Input_GetFromCAN\">" +
			"	<METHOD Name=\"run\"/>" +
			"</PROC>" +
			"<PROC Name=\"/Behavior/Project_SFA_v06/Lenkfunktion_Float/Lenkfunktion_Float_CalcProcess\">" +
			"	<METHOD Name=\"run\"/>" +
			"</PROC>" +
		"</IMPLEMENTATION><PROVIDED_INTERFACE/><REQUIRED_INTERFACE/></SUBSYSTEM>" +
		
		"<SUBSYSTEM Name=\"Sub2\"> <IMPLEMENTATION>" +
			"<PROC Name=\"/Behavior/Project_Steer_Control_v06/Vote_steer/Vote_steer_init\">				<METHOD Name=\"run\"/></PROC>" +
			"<PROC Name=\"/Behavior/Project_Steer_Control_v06/Interrupt_Counter/Interrupt_Counter_init\"><METHOD Name=\"run\"/></PROC>" +
			"<PROC Name=\"/Behavior/Project_Steer_Control_v06/Control_steer/Control_steer_init\">		<METHOD Name=\"run\"/></PROC>" +
			"<PROC Name=\"/Behavior/Project_Steer_Control_v06/Vote_steer/Vote_steer_process\">			<METHOD Name=\"run\"/></PROC>" +
			"<PROC Name=\"/Behavior/Project_Steer_Control_v06/Control_steer/Control_steer_process\">	<METHOD Name=\"run\"/></PROC>" +
			"<PROC Name=\"/Behavior/Project_Steer_Control_v06/Interrupt_Counter/Interrupt_Counter_sw_irq1\"><METHOD Name=\"run\"/></PROC>" +
			"<PROC Name=\"/Behavior/Project_Steer_Control_v06/Vote_steer/Vote_steer_process_count_B\">	<METHOD Name=\"run\"/></PROC>" +
			"<PROC Name=\"/Behavior/Project_Steer_Control_v06/Control_steer/Control_steer_process_count_A\"><METHOD Name=\"run\"/></PROC>" +
		"</IMPLEMENTATION><PROVIDED_INTERFACE/><REQUIRED_INTERFACE/></SUBSYSTEM>" +
		"<PROC Name=\"/Behavior/Project_Car_v06/Plant_steer/Plant_steer_init\">							<METHOD Name=\"run\"/></PROC>" +
		"<PROC Name=\"/Behavior/Project_Car_v06/Car_brake/Car_brake_reset\">							<METHOD Name=\"run\"/></PROC>" +
		"<PROC Name=\"/Behavior/Project_Car_v06/Car_steer/Car_steer_reset\">							<METHOD Name=\"run\"/></PROC>" +
		"<PROC Name=\"/Behavior/Project_Car_v06/Plant_brake/Plant_brake_init\">							<METHOD Name=\"run\"/></PROC>" +
		"<PROC Name=\"/Behavior/Project_Car_v06/Car_brake/Car_brake_process\">							<METHOD Name=\"run\"/></PROC>" +
		"<PROC Name=\"/Behavior/Project_Car_v06/Car_steer/Car_steer_process\">							<METHOD Name=\"run\"/></PROC>" +
		"<PROC Name=\"/Behavior/Project_Car_v06/Plant_steer/Plant_steer_process\">						<METHOD Name=\"run\"/></PROC>" +
		"<PROC Name=\"/Behavior/Project_Car_v06/Plant_brake/Plant_brake_process\">						<METHOD Name=\"run\"/></PROC>" +
		"<PROC Name=\"/Behavior/Project_Driver_v06/Driver/Driver_init\">								<METHOD Name=\"run\"/></PROC>" +
		"<PROC Name=\"/Behavior/Project_Driver_v06/Driver/Driver_process\">								<METHOD Name=\"run\"/></PROC>" +
		"<PROC Name=\"/Behavior/Project_Brake_Control_v06/Control_brake/Control_brake_init\">			<METHOD Name=\"run\"/></PROC>" +
		"<PROC Name=\"/Behavior/Project_Brake_Control_v06/Vote_brake/Vote_brake_init\">					<METHOD Name=\"run\"/></PROC>" +
		"<PROC Name=\"/Behavior/Project_Brake_Control_v06/Vote_brake/Vote_brake_process\">				<METHOD Name=\"run\"/></PROC>" +
		"<PROC Name=\"/Behavior/Project_Brake_Control_v06/Control_brake/Control_brake_process\">		<METHOD Name=\"run\"/></PROC>" +
		"</FUNCTIONAL>" +
		"<ARCHITECTURAL>" +
		"<ECU Name=\"ECU4\">" +
		"<CPU Name=\"ECU4/CPU_0\">" +
		"<RTOS Name=\"OSEK4\"/>" +
		"</CPU>" +
		"</ECU>" +
		"<ECU Name=\"ECU3\">" +
		"<CPU Name=\"ECU3/CPU_0\">" +
		"<RTOS Name=\"OSEK3\"/>" +
		"</CPU>" +
		"</ECU>" +
		"<ECU Name=\"ECU2\">" +
		"<CPU Name=\"ECU2/CPU_0\">" +
		"<RTOS Name=\"OSEK2\"/>" +
		"</CPU>" +
		"</ECU>" +
		"<ECU Name=\"ECU1\">" +
		"<CPU Name=\"ECU1/CPU_0\">" +
		"<RTOS Name=\"OSEK1\"/>" +
		"</CPU>" +
		"</ECU>" +
		"<TASK Name=\"/Architecture/ECU4/OSEK/Timer10ms\">" +
		"<SCHEDULING Priority=\"0\" Threshold=\"0\" PreemptionGroupName=\"COOPERATIVE\"/>" +
		"<ACTIVATION Offset=\"0\" Deadline=\"0\" Type=\"periodic\" Class=\"PeriodicTask\" Period=\"0.01\"/>" +
		"</TASK>" +
		"<TASK Name=\"/Architecture/ECU3/OSEK/Init\">" +
		"<SCHEDULING Priority=\"0\" Threshold=\"0\" PreemptionGroupName=\"0\"/>" +
		"<ACTIVATION Offset=\"0\" Deadline=\"0\" Type=\"sporadic\" Class=\"InitTask\"/>" +
		"</TASK>" +
		"<TASK Name=\"/Architecture/ECU3/OSEK/Task_2msec\">" +
		"<SCHEDULING Priority=\"10\" Threshold=\"10\" PreemptionGroupName=\"PREEMPTIVE\"/>" +
		"<ACTIVATION Offset=\"0\" Deadline=\"0\" Type=\"periodic\" Class=\"PeriodicTask\" Period=\"0.002\"/>" +
		"</TASK>" +
		"<TASK Name=\"/Architecture/ECU3/OSEK/Task_10msec\">" +
		"<SCHEDULING Priority=\"2\" Threshold=\"2\" PreemptionGroupName=\"PREEMPTIVE\"/>" +
		"<ACTIVATION Offset=\"0\" Deadline=\"0\" Type=\"periodic\" Class=\"PeriodicTask\" Period=\"0.01\"/>" +
		"</TASK>" +
		"<TASK Name=\"/Architecture/ECU3/OSEK/SW_IRQ1\">" +
		"<SCHEDULING Priority=\"0\" Threshold=\"0\" PreemptionGroupName=\"PREEMPTIVE\"/>" +
		"<ACTIVATION Offset=\"0\" Deadline=\"0\" Type=\"sporadic\" Class=\"SwIntTask\"/>" +
		"</TASK>" +
		"<TASK Name=\"/Architecture/ECU3/OSEK/Prc_count\">" +
		"<SCHEDULING Priority=\"12\" Threshold=\"12\" PreemptionGroupName=\"PREEMPTIVE\"/>" +
		"<ACTIVATION Offset=\"0\" Deadline=\"0\" Type=\"periodic\" Class=\"PeriodicTask\" Period=\"0.01\"/>" +
		"</TASK>" +
		"<TASK Name=\"/Architecture/ECU2/OSEK/Init\">" +
		"<SCHEDULING Priority=\"0\" Threshold=\"0\" PreemptionGroupName=\"0\"/>" +
		"<ACTIVATION Offset=\"0\" Deadline=\"0\" Type=\"sporadic\" Class=\"InitTask\"/>" +
		"</TASK>" +
		"<TASK Name=\"/Architecture/ECU2/OSEK/Task_1msec\">" +
		"<SCHEDULING Priority=\"10\" Threshold=\"10\" PreemptionGroupName=\"PREEMPTIVE\"/>" +
		"<ACTIVATION Offset=\"0\" Deadline=\"0\" Type=\"periodic\" Class=\"PeriodicTask\" Period=\"0.001\"/>" +
		"</TASK>" +
		"<TASK Name=\"/Architecture/ECU2/OSEK/Task_10msec\">" +
		"<SCHEDULING Priority=\"5\" Threshold=\"5\" PreemptionGroupName=\"PREEMPTIVE\"/>" +
		"<ACTIVATION Offset=\"0\" Deadline=\"0\" Type=\"periodic\" Class=\"PeriodicTask\" Period=\"0.01\"/>" +
		"</TASK>" +
		"<TASK Name=\"/Architecture/ECU2/OSEK/Init_bis\">" +
		"<SCHEDULING Priority=\"0\" Threshold=\"0\" PreemptionGroupName=\"0\"/>" +
		"<ACTIVATION Offset=\"0\" Deadline=\"0\" Type=\"sporadic\" Class=\"InitTask\"/>" +
		"</TASK>" +
		"<TASK Name=\"/Architecture/ECU2/OSEK/Task_4msec\">" +
		"<SCHEDULING Priority=\"0\" Threshold=\"0\" PreemptionGroupName=\"PREEMPTIVE\"/>" +
		"<ACTIVATION Offset=\"0\" Deadline=\"0\" Type=\"periodic\" Class=\"PeriodicTask\" Period=\"0.004\"/>" +
		"</TASK>" +
		"<TASK Name=\"/Architecture/ECU1/OSEK1/Init\">" +
		"<SCHEDULING Priority=\"0\" Threshold=\"0\" PreemptionGroupName=\"0\"/>" +
		"<ACTIVATION Offset=\"0\" Deadline=\"0\" Type=\"sporadic\" Class=\"InitTask\"/>" +
		"</TASK>" +
		"<TASK Name=\"/Architecture/ECU1/OSEK1/Task_2msec\">" +
		"<SCHEDULING Priority=\"10\" Threshold=\"10\" PreemptionGroupName=\"PREEMPTIVE\"/>" +
		"<ACTIVATION Offset=\"0\" Deadline=\"0\" Type=\"periodic\" Class=\"PeriodicTask\" Period=\"0.002\"/>" +
		"</TASK>" +
		"<TASK Name=\"/Architecture/ECU1/OSEK1/Task_10msec\">" +
		"<SCHEDULING Priority=\"2\" Threshold=\"2\" PreemptionGroupName=\"PREEMPTIVE\"/>" +
		"<ACTIVATION Offset=\"0\" Deadline=\"0\" Type=\"periodic\" Class=\"PeriodicTask\" Period=\"0.01\"/>" +
		"</TASK>" +
		"</ARCHITECTURAL>" +
		"<MAPPING>" +
		"<PROCMAP ProcRef=\"Sub1/\\/Behavior\\/Project_SFA_v06\\/Lenkfunktion_Int\\/Lenkfunktion_Int_CalcProcess\"  TaskRef=\"\\/Architecture\\/ECU4\\/OSEK\\/Timer10ms\" Order=\"1\"/>" +
		"<PROCMAP ProcRef=\"Sub1/\\/Behavior\\/Project_SFA_v06\\/CAN_Input\\/CAN_Input_GetFromCAN\"  TaskRef=\"\\/Architecture\\/ECU4\\/OSEK\\/Timer10ms\" Order=\"0\"/>" +
		"<PROCMAP ProcRef=\"Sub1/\\/Behavior\\/Project_SFA_v06\\/Lenkfunktion_Float\\/Lenkfunktion_Float_CalcProcess\" TaskRef=\"\\/Architecture\\/ECU4\\/OSEK\\/Timer10ms\" Order=\"2\"/>" +

		"<PROCMAP ProcRef=\"Sub2/\\/Behavior\\/Project_Steer_Control_v06\\/Vote_steer\\/Vote_steer_init\"  TaskRef=\"\\/Architecture\\/ECU3\\/OSEK\\/Init\" Order=\"2\"/>" +
		"<PROCMAP ProcRef=\"Sub2/\\/Behavior\\/Project_Steer_Control_v06\\/Interrupt_Counter\\/Interrupt_Counter_init\"  TaskRef=\"\\/Architecture\\/ECU3\\/OSEK\\/Init\" Order=\"0\"/>" +
		"<PROCMAP ProcRef=\"Sub2/\\/Behavior\\/Project_Steer_Control_v06\\/Control_steer\\/Control_steer_init\"  TaskRef=\"\\/Architecture\\/ECU3\\/OSEK\\/Init\" Order=\"1\"/>" +

		"<PROCMAP ProcRef=\"Sub2/\\/Behavior\\/Project_Steer_Control_v06\\/Vote_steer\\/Vote_steer_process\"  TaskRef=\"\\/Architecture\\/ECU3\\/OSEK\\/Task_2msec\" Order=\"0\"/>" +

		"<PROCMAP ProcRef=\"Sub2/\\/Behavior\\/Project_Steer_Control_v06\\/Control_steer\\/Control_steer_process\"  TaskRef=\"\\/Architecture\\/ECU3\\/OSEK\\/Task_10msec\" Order=\"0\"/>" +
		"<PROCMAP ProcRef=\"Sub2/\\/Behavior\\/Project_Steer_Control_v06\\/Interrupt_Counter\\/Interrupt_Counter_sw_irq1\"  TaskRef=\"\\/Architecture\\/ECU3\\/OSEK\\/SW_IRQ1\" Order=\"0\"/>" +
		"<PROCMAP ProcRef=\"Sub2/\\/Behavior\\/Project_Steer_Control_v06\\/Vote_steer\\/Vote_steer_process_count_B\"  TaskRef=\"\\/Architecture\\/ECU3\\/OSEK\\/Prc_count\" Order=\"1\"/>" +
		"<PROCMAP ProcRef=\"Sub2/\\/Behavior\\/Project_Steer_Control_v06\\/Control_steer\\/Control_steer_process_count_A\"  TaskRef=\"\\/Architecture\\/ECU3\\/OSEK\\/Prc_count\" Order=\"0\"/>" +

		"<PROCMAP ProcRef=\"\\/Behavior\\/Project_Car_v06\\/Plant_steer\\/Plant_steer_init\"  TaskRef=\"\\/Architecture\\/ECU2\\/OSEK\\/Init\" Order=\"3\"/>" +
		"<PROCMAP ProcRef=\"\\/Behavior\\/Project_Car_v06\\/Car_brake\\/Car_brake_reset\"  TaskRef=\"\\/Architecture\\/ECU2\\/OSEK\\/Init\" Order=\"0\"/>" +
		"<PROCMAP ProcRef=\"\\/Behavior\\/Project_Car_v06\\/Car_steer\\/Car_steer_reset\"  TaskRef=\"\\/Architecture\\/ECU2\\/OSEK\\/Init\" Order=\"1\"/>" +
		"<PROCMAP ProcRef=\"\\/Behavior\\/Project_Car_v06\\/Plant_brake\\/Plant_brake_init\"  TaskRef=\"\\/Architecture\\/ECU2\\/OSEK\\/Init\" Order=\"2\"/>" +

		"<PROCMAP ProcRef=\"\\/Behavior\\/Project_Car_v06\\/Car_brake\\/Car_brake_process\"  TaskRef=\"\\/Architecture\\/ECU2\\/OSEK\\/Task_1msec\" Order=\"0\"/>" +
		"<PROCMAP ProcRef=\"\\/Behavior\\/Project_Car_v06\\/Car_steer\\/Car_steer_process\"  TaskRef=\"\\/Architecture\\/ECU2\\/OSEK\\/Task_1msec\" Order=\"1\"/>" +

		"<PROCMAP ProcRef=\"\\/Behavior\\/Project_Car_v06\\/Plant_steer\\/Plant_steer_process\"  TaskRef=\"\\/Architecture\\/ECU2\\/OSEK\\/Task_10msec\" Order=\"1\"/>" +
		"<PROCMAP ProcRef=\"\\/Behavior\\/Project_Car_v06\\/Plant_brake\\/Plant_brake_process\"  TaskRef=\"\\/Architecture\\/ECU2\\/OSEK\\/Task_10msec\" Order=\"0\"/>" +

		"<PROCMAP ProcRef=\"\\/Behavior\\/Project_Driver_v06\\/Driver\\/Driver_init\"  TaskRef=\"\\/Architecture\\/ECU2\\/OSEK\\/Task_4msec\" Order=\"0\"/>" +
		"<PROCMAP ProcRef=\"\\/Behavior\\/Project_Driver_v06\\/Driver\\/Driver_process\"  TaskRef=\"\\/Architecture\\/ECU2\\/OSEK\\/Task_4msec\" Order=\"1\"/>" +

		"<PROCMAP ProcRef=\"\\/Behavior\\/Project_Brake_Control_v06\\/Control_brake\\/Control_brake_init\"  TaskRef=\"\\/Architecture\\/ECU1\\/OSEK1\\/Init\" Order=\"0\"/>" +
		"<PROCMAP ProcRef=\"\\/Behavior\\/Project_Brake_Control_v06\\/Vote_brake\\/Vote_brake_init\"  TaskRef=\"\\/Architecture\\/ECU1\\/OSEK1\\/Init\" Order=\"1\"/>" +

		"<PROCMAP ProcRef=\"\\/Behavior\\/Project_Brake_Control_v06\\/Vote_brake\\/Vote_brake_process\"  TaskRef=\"\\/Architecture\\/ECU1\\/OSEK1\\/Task_2msec\" Order=\"0\"/>" +
		"<PROCMAP ProcRef=\"\\/Behavior\\/Project_Brake_Control_v06\\/Control_brake\\/Control_brake_process\" TaskRef=\"\\/Architecture\\/ECU1\\/OSEK1\\/Task_10msec\" Order=\"0\"/>" +


		"<TASKMAP rtosRef=\"OSEK4\" TaskRef=\"\\/Architecture\\/ECU4\\/OSEK\\/Timer10ms\"/>" +

		"<TASKMAP rtosRef=\"OSEK3\" TaskRef=\"\\/Architecture\\/ECU3\\/OSEK\\/Init\"/>" +
		"<TASKMAP rtosRef=\"OSEK3\" TaskRef=\"\\/Architecture\\/ECU3\\/OSEK\\/Task_2msec\"/>" +
		"<TASKMAP rtosRef=\"OSEK3\" TaskRef=\"\\/Architecture\\/ECU3\\/OSEK\\/Task_10msec\"/>" +
		"<TASKMAP rtosRef=\"OSEK3\" TaskRef=\"\\/Architecture\\/ECU3\\/OSEK\\/SW_IRQ1\"/>" +
		"<TASKMAP rtosRef=\"OSEK3\" TaskRef=\"\\/Architecture\\/ECU3\\/OSEK\\/Prc_count\"/>" +

		"<TASKMAP rtosRef=\"OSEK2\" TaskRef=\"\\/Architecture\\/ECU2\\/OSEK\\/Init\"/>" +
		"<TASKMAP rtosRef=\"OSEK2\" TaskRef=\"\\/Architecture\\/ECU2\\/OSEK\\/Task_1msec\"/>" +
		"<TASKMAP rtosRef=\"OSEK2\" TaskRef=\"\\/Architecture\\/ECU2\\/OSEK\\/Task_10msec\"/>" +
		"<TASKMAP rtosRef=\"OSEK2\" TaskRef=\"\\/Architecture\\/ECU2\\/OSEK\\/Task_4msec\"/>" +

		"<TASKMAP rtosRef=\"OSEK1\" TaskRef=\"\\/Architecture\\/ECU1\\/OSEK1\\/Init\"/>" +
		"<TASKMAP rtosRef=\"OSEK1\" TaskRef=\"\\/Architecture\\/ECU1\\/OSEK1\\/Task_2msec\"/>" +
		"<TASKMAP rtosRef=\"OSEK1\" TaskRef=\"\\/Architecture\\/ECU1\\/OSEK1\\/Task_10msec\"/>" +
		"</MAPPING>" +
		"</SYSTEM>";
		
		return testo;
	}
}
