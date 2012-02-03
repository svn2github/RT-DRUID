/*
 * Created on 16-mar-2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.eu.evidence.rtdruid.internal.modules.jscan;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.eu.evidence.rtdruid.tests.vartree.data.SimpleExamples;
import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.Vt2StringUtilities;
import com.eu.evidence.rtdruid.vartree.abstractions.old.Task;
import com.eu.evidence.rtdruid.vartree.abstractions.old.TaskSet;

/**
 * @author Nicola Serreli
 */
public class TaskSetTest extends TestCase {

	/**
	 * Constructor for TaskSetTest.
	 */
	public TaskSetTest(String name) {
		super(name);
	}

	/*
	 * @see TestCase#setUp()
	 */
	
	public static Test suite() {
		return new TestSuite(TaskSetTest.class);
	}

	//----------------------------------------

	public void testExample1() {
		IVarTree vt = Vt2StringUtilities.loadString(SimpleExamples.testLoadExample1());
		
		TaskSet ts = new TaskSet(vt, "DefaultSystem");
		
		String[][] taskP = {
			{ "resource",      "__see_task__"  },
			{ Task.STR_ACT_TYPE,              "Type"              },
			{ "period",            "Period"            },
			{ "wcet",              "__see_task__"   },
			{ "deadline",          "Deadline"          },
			{ "offset",            "Offset"            },
			{ "priority",          "Priority"          },
			{ "ResponseTime",          "ResponseTime"          },
//			{ "PreemptionGroupName",  "PreemptionGroupName"  },
			{ "blocking",          "Blocking"          },
			{ "schedulable",       "Schedulable"       }
		};
		for (int i=0; i<taskP.length; i++) {
			ts.setProperty(taskP[i][0],taskP[i][1], false);
		}


		
	}
	
	public void testExample2() {
		IVarTree vt = Vt2StringUtilities.loadString(SimpleExamples.testLoadExample2());
		
		TaskSet ts = new TaskSet(vt, DataPath.makeSlashedId("Root/"));
		
		assertEquals(ts.getPrefixNumber() , 5);
		assertEquals(ts.getSize(0) , 1);
		assertEquals(ts.getSize(1) , 3);
		assertEquals(ts.getSize(2) , 4);
		assertEquals(ts.getSize(3) , 5);
		assertEquals(ts.getSize(4) , 1);
		
		
		
		String[][] taskP = {
			{ "resource",      "__see_task__"  },
			{ Task.STR_ACT_TYPE,              "Type"              },
			{ "period",            "Period"            },
			//{ "wcet",              "__see_task__"   },
			{ "deadline",          "Deadline"          },
			{ "offset",            "Offset"            },
			{ "priority",          "Priority"          },
			{ "ResponseTime",          "ResponseTime"          },
//			{ "PreemptionGroupName",  "PreemptionGroupName"  },
			{ "blocking",          "Blocking"          },
			{ "schedulable",       "Schedulable"       }
		};
		for (int i=0; i<taskP.length; i++) {
			ts.setProperty(taskP[i][0],taskP[i][1], false);
		}

		

		
	}
	

}
