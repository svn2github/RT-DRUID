/*
 * Created on Jan 17, 2005
 *
 * $Id: OilVarMPTest.java,v 1.6 2008/03/26 18:23:52 durin Exp $
 */
package com.eu.evidence.rtdruid.vartree.variables;


import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Stack;

import junit.framework.TestCase;

import com.eu.evidence.rtdruid.desk.RTDFactory;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IOilXMLLabels;
import com.eu.evidence.rtdruid.internal.modules.oil.reader.OilReader;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.CodeWritertTest;
import com.eu.evidence.rtdruid.vartree.ISubVarTreePointer;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVarTreePointer;
import com.eu.evidence.rtdruid.vartree.IVariable;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.data.init.DataPath;
import com.eu.evidence.rtdruid.vartree.data.init.Vt2StringUtilities;
import com.eu.evidence.rtdruid.vartree.data.init.VtCompare;
import com.eu.evidence.rtdruid.vartree.data.oil.OilApplPackage;
import com.eu.evidence.rtdruid.vartree.tools.Search;

/**
 *
 * Tests about OilVar MP  
 *
 * @author Nicola Serreli
 */
public class OilVarMPTest extends TestCase {

	final static String S = "" + DataPath.SEPARATOR;
	
	
	public void testToString() {
		
		OilApplPackage oapkg = OilApplPackage.eINSTANCE;
		
		
		IVarTree vt = (IVarTree) RTDFactory.get(IVarTree.class);
		OilVarMP var = new OilVarMP();
		ISubVarTreePointer svtp = var.getPointer(vt);
		svtp.add("root", oapkg.getRoot().getName());
		
		String answer = var.toString();
		assertTrue(!(""+null).equals(answer) && answer != null);
		
		System.err.print(answer);
		
	}
	public void testConvert() {
		
		OilApplPackage oapkg = OilApplPackage.eINSTANCE;
		
		// prepare the string
		IVarTree vt = (IVarTree) RTDFactory.get(IVarTree.class);
		String answer;
		{
			OilVarMP var = new OilVarMP();
			ISubVarTreePointer svtp = var.getPointer(vt);
			svtp.add("root", oapkg.getRoot().getName());
			
			answer = var.toString();
			assertTrue(!(""+null).equals(answer) && answer != null);
		}
		
		{ // store the string
			OilVarMP var2 = new OilVarMP();
			var2.set(answer);
			ISubVarTreePointer svtp2 = var2.getPointer(vt);
			
			assertTrue(svtp2.subGoFirstChild()==ISubVarTreePointer.OK);
			assertTrue("root".equals(svtp2.getName()));
			
			assertTrue(svtp2.subGoNextSibling()==ISubVarTreePointer.ERROR);
			
			Stack<String> path = new Stack<String>();
			path.push(OilApplPackage.eINSTANCE.getRoot_HwList().getName());
			assertTrue(svtp2.makeSteps(path)==ISubVarTreePointer.OK);
			
			assertTrue(OilApplPackage.eINSTANCE.getRoot_HwList().getName().equals(svtp2.getName()));
			assertTrue(svtp2.subGoFirstChild()==ISubVarTreePointer.ERROR);
		}
		
		
	}
	

	public void testToString2() {
		final String input = 
			"<Root ObjectType=\"TASK\">" +
				"<HW>" +
					"<RTOS Name=\"EE\">" +
						"<ATTRIBUTE Name=\"PRIORITY\">" +
							"<VALUE CurrValue=\"0x01\" />" +
						"</ATTRIBUTE>" +
						"<ATTRIBUTE Name=\"ACTIVATION\">" +
							"<VALUE CurrValue=\"1\" />" +
						"</ATTRIBUTE>" +
						"<VARIANT Name=\"SCHEDULE\">" +
							"<ENUMERATOR Value=\"FULL\" />" +
						"</VARIANT>" +
						"<ATTRIBUTE Name=\"DISPATCH_PRIORITY\">" +
							"<VALUE CurrValue=\"0x01\" />" +
						"</ATTRIBUTE>" +
						"<VARIANT Name=\"AUTOSTART\">" +
							"<ENUMERATOR Value=\"TRUE\" />" +
						"</VARIANT>" +
						"<VARIANT Name=\"STACK\">" +
							"<ENUMERATOR Value=\"SHARED\" />" +
						"</VARIANT>" +
						"<ATTRIBUTE Name=\"EVENT\">" +
							"<VALUE CurrValue=\"evento1\" />" +
						"</ATTRIBUTE>" +
					"</RTOS>" +
				"</HW>" +
			"</Root>";
		
		final String output = 
			"<Root ObjectType=\"TASK\">" +
				"<HW>" +
					"<RTOS Name=\"EE\">" +
						"<ATTRIBUTE Name=\"PRIORITY\"/>" +
						"<VARIANT Name=\"SCHEDULE\">" +
							"<ENUMERATOR Value=\"FULL\"/>" +
						"</VARIANT>" +
						"<ATTRIBUTE Name=\"DISPATCH_PRIORITY\">" +
							"<VALUE CurrValue=\"0x01\"/>" +
						"</ATTRIBUTE>" +
						"<VARIANT Name=\"AUTOSTART\">" +
							"<ENUMERATOR Value=\"TRUE\"/>" +
						"</VARIANT>" +
						"<VARIANT Name=\"STACK\">" +
							"<ENUMERATOR Value=\"SHARED\"/>" +
						"</VARIANT>" +
						"<ATTRIBUTE Name=\"EVENT\">" +
							"<VALUE CurrValue=\"evento1\"/>" +
						"</ATTRIBUTE>" +
					"</RTOS>" +
				"</HW>" +
			"</Root>";
		
		final IVarTree vt = (IVarTree) RTDFactory.get(IVarTree.class);
		
		final OilApplPackage OAPKG = OilApplPackage.eINSTANCE; 
		
		// ----- set and read the var (as string)
		IVariable var = new OilVarMP();
		var.set(input);
		String txt = var.toString();
		
		assertTrue(input.equals(txt));
		
		// ----- get some values as a IVarTreePointer
		ISubVarTreePointer svtp = ((OilVarMP) var).getPointer(vt);
		
		Stack<String> path = new Stack<String>();
		path.addAll(Arrays.asList(new String[] {
				OAPKG.getRTOS_ParameterList().getName(),				
				DataPath.makeId("EE"),
				OAPKG.getHW_RtosList().getName(),
				DataPath.makeId((String) null),
				OAPKG.getRoot_HwList().getName(),
				IOilXMLLabels.OBJ_TASK,
		}));
			
		assertTrue(svtp.makeSteps(path) == ISubVarTreePointer.OK);
		
		txt = var.toString();
		
		assertTrue(input.equals(txt));
		
		
		// ----- modify some values and check the output
		ISubVarTreePointer svtp1 = (ISubVarTreePointer) svtp.clone();
		path.addAll(Arrays.asList(new String[] {
				OAPKG.getValue_Values().getName(),				
				"PRIORITY"
		}));
			
		assertTrue(svtp1.makeSteps(path) == ISubVarTreePointer.OK);
		svtp1.setVar(null);
		
		ISubVarTreePointer svtp2 = (ISubVarTreePointer) svtp.clone();
		path.addAll(Arrays.asList(new String[] {
				"ACTIVATION"				
		}));
			
		assertTrue(svtp2.makeSteps(path) == ISubVarTreePointer.OK);
		svtp2.subDestroy();
		
		txt = var.toString();
		
		System.err.println(txt);
		assertTrue(output.equals(txt));
	}

	public void testToString3() {
		final String input = 
			"<Root ObjectType=\"TASK\">" +
				"<HW>" +
					"<RTOS Name=\"EE\">" +
						"<ATTRIBUTE Name=\"PRIORITY\">" +
							"<VALUE CurrValue=\"0x01\" />" +
						"</ATTRIBUTE>" +
						"<ATTRIBUTE Name=\"ACTIVATION\">" +
							"<VALUE CurrValue=\"1\" />" +
						"</ATTRIBUTE>" +
						"<VARIANT Name=\"SCHEDULE\">" +
							"<ENUMERATOR Value=\"FULL\" />" +
						"</VARIANT>" +
						"<ATTRIBUTE Name=\"DISPATCH_PRIORITY\">" +
							"<VALUE CurrValue=\"0x01\" />" +
						"</ATTRIBUTE>" +
						"<VARIANT Name=\"AUTOSTART\">" +
							"<ENUMERATOR Value=\"TRUE\" />" +
						"</VARIANT>" +
						"<VARIANT Name=\"STACK\">" +
							"<ENUMERATOR Value=\"SHARED\" />" +
						"</VARIANT>" +
						"<ATTRIBUTE Name=\"EVENT\">" +
							"<VALUE CurrValue=\"evento1\" />" +
						"</ATTRIBUTE>" +
					"</RTOS>" +
				"</HW>" +
			"</Root>";
		
		final String output = 
			"<Root ObjectType=\"TASK\">" +
				"<HW>" +
					"<RTOS Name=\"EE\">" +
						"<ATTRIBUTE Name=\"PRIORITY\"/>" +
						"<VARIANT Name=\"SCHEDULE\">" +
							"<ENUMERATOR Value=\"FULL\"/>" +
						"</VARIANT>" +
						"<ATTRIBUTE Name=\"DISPATCH_PRIORITY\">" +
							"<VALUE CurrValue=\"0x01\"/>" +
						"</ATTRIBUTE>" +
						"<VARIANT Name=\"AUTOSTART\">" +
							"<ENUMERATOR Value=\"TRUE\"/>" +
						"</VARIANT>" +
						"<VARIANT Name=\"STACK\">" +
							"<ENUMERATOR Value=\"SHARED\"/>" +
						"</VARIANT>" +
						"<ATTRIBUTE Name=\"EVENT\">" +
							"<VALUE CurrValue=\"evento1\"/>" +
						"</ATTRIBUTE>" +
					"</RTOS>" +
				"</HW>" +
			"</Root>";
		
		final IVarTree vt = (IVarTree) RTDFactory.get(IVarTree.class);
		
		final DataPackage DPKG = DataPackage.eINSTANCE;
		final OilApplPackage OAPKG = OilApplPackage.eINSTANCE; 
		
		
		IVarTreePointer vtp = vt.newVarTreePointer();
		assertTrue("System".equals(vtp.add("System", DPKG.getSystem().getName())));
		assertTrue(vtp.go("System"));
		
		assertTrue(DPKG.getSystem_Architectural().getName()
				.equals(vtp.add(DPKG.getSystem_Architectural().getName(), DPKG.getSystem_Architectural().getName())));
		assertTrue(vtp.go(DPKG.getSystem_Architectural().getName()));
		assertTrue(vtp.go(DPKG.getArchitectural_TaskList().getName()));
		
		assertTrue("Task1".equals(vtp.add("Task1", DPKG.getTask().getName())));
		assertTrue(vtp.go("Task1"));
		
		assertTrue(vtp.go(DPKG.getTask_OilVar().getName()));
		
		
		// ----- set and read the var (as string)
		IVariable var = new OilVarMP();
		var.set(input);
		vtp.setVar(var);
		String txt = vtp.getVar().toString();
		
		assertTrue(input.equals(txt));

		IVarTreePointer orig = (IVarTreePointer) vtp.clone();
		
		// ----- get some values as a IVarTreePointer
		assertTrue(vtp.go(
				IOilXMLLabels.OBJ_TASK + S +
				OAPKG.getRoot_HwList().getName() + S +
				DataPath.makeId((String) null) + S +
				OAPKG.getHW_RtosList().getName() + S +
				DataPath.makeId("EE") + S +
				OAPKG.getRTOS_ParameterList().getName()				
		));
		
		
		txt = orig.getVar().toString();
		
		assertTrue(input.equals(txt));
				
		// ----- modify some values and check the output
		assertTrue(vtp.go(	"PRIORITY" + S + OAPKG.getValue_Values().getName()));
			
		vtp.setVar(null);
		
		vtp.goParent();
		vtp.goParent();
		
		
		assertTrue(vtp.go("ACTIVATION"));
		vtp.destroy();
		
		txt = orig.getVar().toString();
		
		System.err.println(txt);
		System.err.println("\n\n--------\n\n" + output);
		assertTrue(output.equals(txt));
	}

	public void testTask_event() {

		final String TEST_ALARM = CodeWritertTest.DEFAULT_EE_IMPLEMENTATION
		+ "CPU EE_1 {\n"
		+ "    EVENT ev1 { MASK = 1; };\n"
		+ "};\n";

		IVarTree vt = (IVarTree) RTDFactory.get(IVarTree.class);
		(new OilReader()).load(new ByteArrayInputStream(TEST_ALARM.getBytes()),
				vt);

		{
			// show the "xml" view of the loaded tree
			String answer = Vt2StringUtilities.varTreeToStringErtd(vt);
			System.out.println(answer);
	
			IVarTree vt2 = Vt2StringUtilities.loadString(answer, "ertd"); 
			String t = (new VtCompare(vt, vt2)).getText(); assertTrue(t, t== null);
		}
		{
			// show the "xml" view of the loaded tree
			String answer = Vt2StringUtilities.varTreeToStringRtd(vt);
			System.out.println(answer);
	
			IVarTree vt2 = Vt2StringUtilities.loadString(answer, "rtd"); 
			String t = (new VtCompare(vt, vt2)).getText(); assertTrue(t, t== null);
		}
			

	}

	

	public void testMultiRoots() {
		final String input = 
			"<Root ObjectType=\"TASK\">" +
				"<HW>" +
					"<RTOS Name=\"EE\">" +
						"<ATTRIBUTE Name=\"DISPATCH_PRIORITY\">" +
							"<VALUE CurrValue=\"0x01\" />" +
						"</ATTRIBUTE>" +
						"<VARIANT Name=\"AUTOSTART\">" +
							"<ENUMERATOR Value=\"TRUE\" />" +
						"</VARIANT>" +
						"<VARIANT Name=\"STACK\">" +
							"<ENUMERATOR Value=\"SHARED\" />" +
						"</VARIANT>" +
						"<ATTRIBUTE Name=\"EVENT\">" +
							"<VALUE CurrValue=\"evento1\" />" +
						"</ATTRIBUTE>" +
					"</RTOS>" +
				"</HW>" +
			"</Root>" +
			"<Root ObjectType=\"OSAPPLICATION\">" +
				"<HW>" +
					"<RTOS Name=\"EE\">" +
						"<ATTRIBUTE Name=\"PRIORITY\">" +
							"<VALUE CurrValue=\"0x01\" />" +
						"</ATTRIBUTE>" +
					"</RTOS>" +
				"</HW>" +
			"</Root>" +
			"<Root ObjectType=\"OSAPPLICATION\">" +
				"<HW>" +
					"<RTOS Name=\"EE\">" +
						"<ATTRIBUTE Name=\"PRIORITY\">" +
							"<VALUE CurrValue=\"0x02\" />" +
						"</ATTRIBUTE>" +
					"</RTOS>" +
				"</HW>" +
			"</Root>";

		
		final String TEST_ALARM = CodeWritertTest.DEFAULT_EE_IMPLEMENTATION
				+ "CPU EE_1 {\n"
				+ "    EVENT ev1 { MASK = 1; };\n"
				+ "};\n";

		
		final IVarTree vt = (IVarTree) RTDFactory.get(IVarTree.class);
		(new OilReader()).load(new ByteArrayInputStream(TEST_ALARM.getBytes()),
				vt);
		
		final OilApplPackage OAPKG = OilApplPackage.eINSTANCE; 
		ITreeInterface ti = vt.newTreeInterface();
		String path = Search.systemName(vt) 
				+S+ DataPackage.eINSTANCE.getArchitectural().getName() 
				+S+ DataPackage.eINSTANCE.getArchitectural_SignalList().getName()
				+S+ "ev1" 
				+S+ DataPackage.eINSTANCE.getSignal_OilVar().getName();

		
		String[] names = ti.getAllName(path, null);
		assertTrue(names.length == 1);
		assertTrue("EVENT".equals(names[0]));
		
		System.out.println("--PRIMA--");
		System.out.println(Vt2StringUtilities.explodeOilVar(Vt2StringUtilities.varTreeToStringErtd(vt)));
		
		// ----- set and read the var (as string)
		IVariable var = new OilVarMP();
		var.set(input);
		String txt = var.toString();
		
		assertTrue(input.equals(txt));
		
		ti.setValue(path, var);

		
		System.out.println("--DOPO--");
		System.out.println(Vt2StringUtilities.explodeOilVar(Vt2StringUtilities.varTreeToStringErtd(vt)));
		

		names = ti.getAllName(path, null);
		System.out.println("--Nomi :" + Arrays.asList(names));
		assertTrue(names.length == 3);
		assertTrue("TASK".equals(names[0]));
		assertTrue("OSAPPLICATION".equals(names[1]));
		assertTrue("OSAPPLICATION".equals(names[2]));
	}
}