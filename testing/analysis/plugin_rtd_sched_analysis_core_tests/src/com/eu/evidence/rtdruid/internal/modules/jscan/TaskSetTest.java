/*
 * Created on 16-mar-2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.eu.evidence.rtdruid.internal.modules.jscan;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import com.eu.evidence.rtdruid.tests.AbstractNamedTest;
import com.eu.evidence.rtdruid.tests.vartree.data.SimpleExamples;
import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.Vt2StringUtilities;
import com.eu.evidence.rtdruid.vartree.abstractions.old.Task;
import com.eu.evidence.rtdruid.vartree.abstractions.old.TaskSet;

/**
 * @author Nicola Serreli
 */
public class TaskSetTest extends AbstractNamedTest {

	@Test
	public void testExample1() throws IOException {
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
	
	@Test
	public void testExample2() throws IOException {
		IVarTree vt = Vt2StringUtilities.loadString(SimpleExamples.testLoadExample2());
		
		TaskSet ts = new TaskSet(vt, DataPath.makeSlashedId("Root/"));
		
		assertEquals(5, ts.getPrefixNumber());
		assertEquals(1, ts.getSize(0));
		assertEquals(3, ts.getSize(1));
		assertEquals(4, ts.getSize(2));
		assertEquals(5, ts.getSize(3));
		assertEquals(1, ts.getSize(4));
		
		
		
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
