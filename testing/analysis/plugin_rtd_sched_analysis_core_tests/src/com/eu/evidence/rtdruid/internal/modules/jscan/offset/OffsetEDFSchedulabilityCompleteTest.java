/*
 * Created on Jul 28, 2004
 *
 * $Id: OffsetEDFSchedulabilityCompleteTest.java,v 1.1 2005/09/28 15:22:29 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.jscan.offset;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.eu.evidence.rtdruid.tests.AbstractNamedTest;

/**
 * @author sachin
 *
 */
public class OffsetEDFSchedulabilityCompleteTest extends AbstractNamedTest {
	
	int 	numTasks = 3 ;
	int 	testCases = 1 ;
	
	long[][] period = 	{	
							{ 3,4,6},
							{ 8 , 12,16 },
							{ 4 ,6 ,10 },
							{ 4 ,6 ,10 },
							{ 4 ,5 ,8 }
						};
	
	double[][] offset = 	{
								{ 0,0,0 },
								{ 0 ,2, 0 },
								{ 0, 0, 0 },	
								{ 0 ,0, 1 },
								{ 0 ,0, 1.5 }
							};

	double[][] deadline = 	{
								{ 3 , 3,5 },
								{ 8 , 12,16 },
								{ 4 ,6 ,10},
								{ 4 ,6 ,10},
								{ 4 ,5 ,8 }
							};

	
	double[][] blocking = 	{ 	
								{0 , 0 , 0 },
								{0 , 0 , 0 },
								{0 , 0 , 0 },
								{0 , 0 , 0 },
								{0 , 0 , 0 }
							};
	
	double[][] wcet = 		{	
								{ 1 , 1 , 2   }, 
								{ 2 , 3 , 7  },
								{ 2 , 1 ,3  }, 
								{ 2 , 1 ,3  },
								{ 1 , 2 ,3}
							};
	
	
	boolean expected[] = { true , true , true ,true ,false} ; 
		
	double[][] rt = {  { 2,2 ,4 } };
	
@Test	
public void testCheckTask() {
	OffsetEDFSchedulabilityComplete o = new OffsetEDFSchedulabilityComplete();
		int i , k;
		
		boolean[] IsSchedulable ;
		double WorstCaseBusyPeriod[] ;
		double WorstCaseResponceTime[];
		double CriticalActivation[];
		double WcetSensitivity[];
		
		WorstCaseBusyPeriod = new double[numTasks] ;
		IsSchedulable = new boolean[numTasks] ;
		CriticalActivation = new double[numTasks];
		WorstCaseResponceTime = new double[numTasks] ;
		WcetSensitivity = new double[numTasks];
		boolean result ;
		for(i = 0 ; i < testCases ; i++){
				o.setTestParameters(period[i] , deadline[i] , blocking[i] ,wcet[i] , offset[i]) ; 
				o.checkTask(numTasks - 1,IsSchedulable,WorstCaseBusyPeriod,CriticalActivation, WorstCaseResponceTime ,WcetSensitivity);
				result = true ;
				for(k = 0 ; k < numTasks ;k++){
					
					assertEquals(WorstCaseResponceTime[k],rt[i][k],0.00001);
					
					if(IsSchedulable[k] == false )	{
							result = false ;
							break ;
					}
				}
				
			assertEquals(result,expected[i]);
			}		
	}

}
