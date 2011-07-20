/*
 * Created on Jul 20, 2004
 *
 * $Id: OffsetDMSchedulabilityCompleteTest.java,v 1.1 2005/09/28 15:22:29 durin Exp $
 */

package com.eu.evidence.rtdruid.internal.modules.jscan.offset;

import junit.framework.TestCase;

/**
 * @author sachin
 *
 */


public class OffsetDMSchedulabilityCompleteTest extends TestCase {
	
	OffsetDMSchedulabilityComplete o ;
	
	int 	numTasks = 3 ;
	int 	testCases = 5 ;
	
	long[][] period = 	{	
							{ 8 , 12,16 },
							{ 8 , 12,16 },
							{ 4 ,6 ,10 },
							{ 4 ,6 ,10 },
							{ 4 ,5 ,8 }
						};
	
	double[][] offset = 
						{
								{ 0 ,0, 0 },
								{ 0 ,2, 0 },
								{ 0, 0, 0 },	
								{ 0 ,0, 1 },
								{ 0 ,0, 1.5 }
						};

	double[][] deadline = 	{
								{ 8 , 12,16 },
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
								{ 2 , 3 , 7  }, 
								{ 2 , 3 , 7  },
								{ 2 , 1 ,3  }, 
								{ 2 , 1 ,3  },
								{ 1 , 2 , 2.5}
							};
	
	boolean expected[] = { false , true , false ,true ,true } ; 
	
	
	
	/*
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		this.o = new OffsetDMSchedulabilityComplete();
		super.setUp();
	}
	
	
public void testCheckTask() {
		int i , k;
		
		int testCases = 5 ;
		
		boolean[] IsSchedulable ;
		double WorstCaseResponceTime[];
		double CriticalActivation[];
		double WcetSensitivity[];
		
		IsSchedulable = new boolean[numTasks] ;
		CriticalActivation = new double[numTasks];
		WorstCaseResponceTime = new double[numTasks] ;
		WcetSensitivity = new double[numTasks];
		boolean result ;
		for(i = 0 ; i < testCases ; i++){
				o.setTestParameters(period[i] , deadline[i] , blocking[i] ,wcet[i] , offset[i]) ; 
				o.checkTask(numTasks - 1,IsSchedulable,CriticalActivation, WorstCaseResponceTime ,WcetSensitivity);
				result = true ;
				for(k = 0 ; k < numTasks ;k++)
					if(IsSchedulable[k] == false )	{
							result = false ;
							break ;
					}
			assertEquals(result,expected[i]);
		}		
	}


public void testResponseTime() {
	int 	numTasks = 3 ;
	int 	testCases = 1 ;
	
	long[][] period = 	{	{ 3 , 4, 6 }
						};
	
	double[][] offset = {
							{ 0 ,1, 2 }
						};

	double[][] deadline = 	{
								{ 4 ,5 ,8 }
							};

	
	double[][] blocking = 	{ 	
								{0 , 0 , 0 }
							};
	
	double[][] wcet = 		{	
								{ 1 , 1 , 2}
							};
	
	//boolean expected[] = { true } ;
	double rs[][] = {
					{ 1 , 2 , 4}
				};

	
		int i , k;
		
		boolean[] IsSchedulable ;
		double WorstCaseResponceTime[];
		double CriticalActivation[];
		double WcetSensitivity[];
		
		IsSchedulable = new boolean[numTasks] ;
		CriticalActivation = new double[numTasks];
		WorstCaseResponceTime = new double[numTasks] ;
		WcetSensitivity = new double[numTasks];
		//boolean result ;
		for(i = 0 ; i < testCases ; i++){
			o.setTestParameters(period[i] , deadline[i] , blocking[i] ,wcet[i] , offset[i]) ; 
			o.checkTask(numTasks - 1,IsSchedulable,CriticalActivation, WorstCaseResponceTime ,WcetSensitivity);
			//result = true ;
			for(k = 0 ; k < numTasks ;k++){	
//				System.out.println(WorstCaseResponceTime[k]+"\t");
				assertEquals(rs[i][k],WorstCaseResponceTime[k],0.00001);
			}		
		}
	}



public void testWhenWcetZero() {
	int 	numTasks = 3 ;
	int 	testCases = 3 ;
	
	long[][] period = 	{	{ 3 , 4, 6 },
							{ 3 , 4, 6 },
							{ 3 , 4, 6 }
						};
	
	double[][] offset = {
							{ 0 ,1, 2 },
							{ 0 ,1, 2 },
							{ 0 ,1, 2 }
							};

	double[][] deadline = 	{
							{ 4 ,5 ,8 },
							{ 4 ,5 ,8 },
							{ 4 ,5 ,8 }
							};

	
	double[][] blocking = 	{ 	
							{0 , 0 , 0 },
							{0 , 0 , 0 },
							{0 , 0 , 0 }
							};
	
	double[][] wcet = 		{	
							{ 0 , 0 , 0},
							{ 0 , 1 , 0},
							{ 0 , 1 , 3}
							};
	
	//boolean expected[] = {true,true } ;
	double rs[][] = {
					{ 0 , 0 , 0},
					{ 0 , 1 , 0},
					{ 0 , 1 , 4}
				};

		int i , k;
		
		boolean[] IsSchedulable ;
		double WorstCaseResponceTime[];
		double CriticalActivation[];
		double WcetSensitivity[];
		
		IsSchedulable = new boolean[numTasks] ;
		CriticalActivation = new double[numTasks];
		WorstCaseResponceTime = new double[numTasks] ;
		WcetSensitivity = new double[numTasks];
		//boolean result ;
		for(i = 0 ; i < testCases ; i++){
			o.setTestParameters(period[i] , deadline[i] , blocking[i] ,wcet[i] , offset[i]) ; 
			o.checkTask(numTasks - 1,IsSchedulable,CriticalActivation, WorstCaseResponceTime ,WcetSensitivity);
			//result = true ;
			for(k = 0 ; k < numTasks ;k++){	
				System.out.println(WorstCaseResponceTime[k]+"\t");
				assertEquals(rs[i][k],WorstCaseResponceTime[k],0.00001);
			}		
		}
	}


public void testWhenHighLoad() {
	
	int 	testCases = 1 ;
	
	long[][] period = 	{	
							{ 4, 6, 9 },
							{ 3, 5, 6 }
						};
	
	double[][] offset = 	{
								{ 0, 0, 2 },
								{ 0, 0, 0 }
						};

	double[][] deadline = 	{
								{ 4, 6, 9 },
								{ 3, 5, 6 }
							};

	
	double[][] blocking = 	{ 	
								{0, 0, 0 },
								{0, 0, 0 }
							};
	
	double[][] wcet = 		{	
								{ 1, 2, 5},
								{ 1, 2.5, 1}
							};
	
	
	double rs[][] = {
						{ 1 , 3 , Double.POSITIVE_INFINITY},
						{ 1 , 4.5 , 11}
					};

	
		int i , k;
		
		boolean[] IsSchedulable ;
		double WorstCaseResponceTime[];
		double CriticalActivation[];
		double WcetSensitivity[];
		
		IsSchedulable = new boolean[numTasks] ;
		CriticalActivation = new double[numTasks];
		WorstCaseResponceTime = new double[numTasks] ;
		WcetSensitivity = new double[numTasks];
		//boolean result ;
		for(i = 0 ; i < testCases ; i++){
			int numTasks = period[i].length ;
			
			o.setTestParameters(period[i] , deadline[i] , blocking[i] ,wcet[i] , offset[i]) ; 
			o.checkTask(numTasks - 1,IsSchedulable,CriticalActivation, WorstCaseResponceTime ,WcetSensitivity);
			//result = true ;
			for(k = 0 ; k < numTasks ;k++){	
				System.out.println(WorstCaseResponceTime[k]+"\t");
				assertEquals(rs[i][k],WorstCaseResponceTime[k],0.00001);
			}		
		}
	}


}

