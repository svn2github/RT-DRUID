/*
 * Created on Aug 26, 2004
 *
 */
package com.eu.evidence.rtdruid.internal.modules.jscan.offset;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

import junit.framework.TestCase;

import com.eu.evidence.rtdruid.internal.modules.jscan.common.PlaneConstraint;

/**
 * @author sachin
 */


public class OffSetSchedulabilityHyperplanesAnalysisTest extends TestCase {

	public static void main(String[] args) {
	}

	
	public void testBuildKeyPoints() {

	long [] period = { 4 , 5,  8 };

	double[]  offset =  { 3 ,5 , 7 };

	double[] blocking = {0 , 0 , 0 } ;

	double[] wcet = 	{ 1 , 2 , 2.5 } ;	

	double[]  deadline = 	{ 4 ,5, 8  };

	//double[] zerooffset = {0 , 0 , 0} ;

	int testtasks[]    = { 2 } ;
	int testinstance[] = { 5 } ;
	
	double  resource[][] = { 
							{4,6,8 }
						}	;
	
	int     resultcoef[][][] = {
								{
									{1,1 },
									{2,1 },
									{2,2 }
								}
							};
	
	int testcases = 1 ;
	
	//int numTasks = 3 ;
	int i , j ;
	OffsetSchedulabilityHyperplanesAnalysis o ;
	SortedSet s ;
	o = new OffsetSchedulabilityHyperplanesAnalysis();
	o.setTotalFixedTask(2);	
	o.initTest(period,deadline,blocking,wcet,offset) ;
	o.setRunTimeTestOffset(offset);
	
	for(i = 0 ; i < testcases ; i++){
		s = new TreeSet() ;
	
		o.buildKeyPoints(testtasks[i],testinstance[i],s);
	Iterator iterOnCx;
	iterOnCx = s.iterator();		
	j = 0 ;
	while ( iterOnCx.hasNext() ) {
		PlaneConstraint myCx ;
		myCx = (PlaneConstraint) iterOnCx.next();
		System.out.println(myCx.b + "\t" + myCx.a[0] + "\t" + myCx.a[1]);
		assertEquals(myCx.a[0],resultcoef[i][j][0]);
		assertEquals(myCx.a[1],resultcoef[i][j][1]);
		assertEquals(myCx.b, resource[i][j] , 0.001);
		j++;
	  }		
	 }
	}
	

	
public void testWorkLoadStarterForFirstInstance() {

	long [][] period = 		{
				{ 4 , 5,  8 }, 
				{ 4 , 5 , 8 },
				{ 4 , 5,  8 }, 
				{ 4 , 5 , 8 },
			};

	double[][]  offset =  { 
			{ 3 ,6 ,16 }, 
			{ 3 ,6 ,16 },
			{ 3 ,6 ,16 }, 
			{ 3 ,6 ,16 }
		 };


	double[][] blocking = 	{ 	
				{0 , 0 , 0 },
				{0 , 0 , 0 },
				{0 , 0 , 0 },
				{0 , 0 , 0 }
			};


	double[][] wcet = 	{	
			{ 2 , 2 , 0.1 },
			{ 2 , 2 , 0.1 },
			{ 2 , 2 , 0.1 },
			{ 2 , 1 , 1 },
		};	

	
	double[][]  deadline = 	{ 
			{ 4 ,5, 8  }, 
			{ 4 , 5 ,8 },
			{ 4 ,5, 8  },
			{ 4 ,5, 8  }
		};
		
		int  testTask[] = {2 , 1 , 1 , 2 };
		int  testinstance[] = {1 , 4 , 1 , 1 } ;
		double Wmin[] = { 0.0 , 0.0 , 0.0 , 0 } ;
		double Wmax[] = { 8 , 5 , 7 , 10 } ;
		double  realWorkloadStarter[] = {1,0,0 ,1 }	;
		double  realInterference[] = {1,0,0,1};

// Expected Results ::::::::::::::::::::::::::::::::::::::::::::::::::::	
		
		int testcases = 2 ;
		
		//int numTasks = 3 ;
		int i , j ;
		OffsetSchedulabilityHyperplanesAnalysis o ;
		//SortedSet s ;
		
		o = new OffsetSchedulabilityHyperplanesAnalysis();
		o.setTotalFixedTask(2);	
		
		double W , I ;
		double[] delta = new double[3];
		
		for( i = 0 ; i < testcases ; i++ ){
			//System.out.println("Test " + i + ":::::::::::::::::::::::::::::::::::::::");
			o.initTest(period[i],deadline[i],blocking[i],wcet[i],offset[i]) ;
			o.setRunTimeTestOffset(offset[i]);
			
			double temp ;
			temp = offset[i][testTask[i]] + period[i][testTask[i]] * ( testinstance[i] - 1 );
			//System.out.println("\nTEMP = " + temp);
			for(j = 0 ; j <= testTask[i] ; j++ ){
				if(temp > offset[i][j])
					delta[j] = Math.ceil( (temp - offset[i][j]) / period[i][j] ) * period[i][j] - temp + offset[i][j];
				else
					delta[j] = offset[i][j] - temp ;
				
				//System.out.println("Itask = " + j + "\tDelta" + delta[j]);
				
			}
			
			double[] result = o.WorkloadStarter(Wmax[i] ,Wmin[i] , testTask[i],testinstance[i],delta ,wcet[i]);
			W = result[0] ;
			I = result[1] ;
			
			assertEquals(W, realWorkloadStarter[i],0.001);
			//System.out.println("Interference Got" + I + "\tWorload" + W );
			assertEquals(I,realInterference[i],0.001);		
		}
	}


public void testSchedulabilityOfInstance() {
// 	About Test Cases .......
//  For Test case three it changes WorkLoad Starter to long value.   
		
	long [][] period = 	{
				{ 4 , 5,  8 }, 
				{ 4 , 5 , 8 },
				{ 4 , 5,  8 }, 
				{ 4 , 5 , 8 },
				{ 4 , 5 , 8 },
				{5,20,30,45,120,300}
			};

	double[][]  offset = { 
			{ 3 ,6 ,16 }, 
			{ 3 ,6 ,16 },
			{ 3 ,6 ,16 }, 
			{ 3 ,6 ,16 },
			{ 3 ,6 ,16 },
			{0,2,20,10,28,201}
			
		 };


	double[][] blocking = 	{ 	
				{0 , 0 , 0 },
				{0 , 0 , 0 },
				{0 , 0 , 0 },
				{0 , 0 , 0 },
				{0 , 0 , 0 },
				{0,0,0,0,0,0}
			};


	double[][] wcet = 	{	
			{ 2 , 1 , 1 },
			{ 2 , 1 , 1 },
			{ 2 , 1 , 1 },
			{ 2 , 1 , 1 },
			{ 2 , 2 , 2 },
			{1,2,4,2,2,6}
		};	

	
	double[][]  deadline = 	
		{ 
			{ 4 ,5, 8  }, 
			{ 4 ,5 ,8  },
			{ 4 ,5, 8  },
			{ 4 ,5, 8  },
			{ 4 ,5, 8  },
			{5,20,30,40,130,300}
		};
		
		int  testTask[] = { 2 , 1 , 0 , 2 , 2,5};
		int  testinstance[] = { 1 , 4 , 1 , 2 , 1,1} ;

		
//	    Expected Results ::::::::::::::::::::::::::::::::::::::::::::::::::::
		
		//boolean  realschedulable[] = {true,true}	;
		double realincreament[][] = {
									{0.5,0.5,1.0},
									{1,1.333333333333},
									{2},
									{0.75,1,1.5},
									{-1,-1,-2},
									{2.4444444,9.777777777,14.666666667,22,58.666666666666,148}
									};
		
		//double realresponsetime[] = {};
		
	

		int testcases = 6;
		int numTasks ;
		int i , j ;
		
		OffsetSchedulabilityHyperplanesAnalysis o ;
		o = new OffsetSchedulabilityHyperplanesAnalysis();
		o.setTotalFixedTask(2);	
		
		//double W , I ;
		double[] maxInc = new double[10];
		double[] rs = new double[10];
		//boolean result ;
		
		for(i = 0 ; i < 10 ;i++){
			maxInc[i] = Double.MAX_VALUE ;
			rs[i] = 0 ;
		}
		
		for( i = 0 ; i < testcases ; i++ ){
    		numTasks = period[i].length ;
			
    		//System.out.println("****************Test " + i + ":::::::::::::::::::::::::::::::::::::::");
			o.initTest(period[i],deadline[i],blocking[i],wcet[i],offset[i]) ;
			o.setRunTimeTestOffset(offset[i]);
			o.setSensitivityPrecision(0.00001);
			
			for(j=0; j < numTasks ; j++){
				maxInc[j] = Double.MAX_VALUE ;
				rs[j] = Double.MIN_VALUE ;
			}
				
			o.isSchedulableWithCurrentOffsets(testTask[i] , testinstance[i] , maxInc , rs ,false ) ;
			//result =  
			
			//for(j = 0 ; j < numTasks ;j++)
				//System.out.println("Task :: " + j + " Increament :: " + maxInc[j] );
						
			//System.out.println("\t\tResponse Time :: " + rs[testTask[i]] );
			
			for( j = 0 ; j <= testTask[i] ; j++ )

				assertEquals(maxInc[j] , realincreament[i][j] , 0.0001);
//				assertEquals(rs[testTask[i]],realresponsetime[i], 0.001);			
		}
	}


public void testIsTaskSchedulableWithSensitivity() {


long [][]  	period = 	{
			{ 4 , 5,  8 }, 
			{ 4 , 5 , 8 },
			{ 4 , 5,  8 }, 
			{ 4 , 5 , 8 },
			{12 ,67,81 },
			{900,13405,20000},
			{5,20,30,46,120,309},
			{2,50,12323,236666,6666666},
			{3000,2323,2366},
			{300,56,236},
			{300,5,23},
			{230,4,123,45,100},
			{100,100,100},
			{1023420,100,10}
			};


double[][] 	offset = { 
		{ 2 ,4 ,32 }, 
		{ 1 ,1 ,11 },
		{ 24 ,0 ,1 }, 
		{ 5 ,2 ,16 },
		{ 1 ,1 ,1 },
		{ 6 ,1444 ,144444 },
		{1,3,1,6,9,2},
		{23,333,21,23,12},
		{ 123 , 324 ,163 },
		{ 0 , 0 ,0 },
		{ 1 , 2 ,2 },
		{0,2,0,0,453},
		{23,11,31},
		{20,0,5}
		
		// { 11,333,21,13,12} is not working
	 	};


double[][] 	blocking = 	{ 	
			{0 , 0 , 0 },
			{0 , 0 , 0 },
			{0 , 0 , 0 },
			{0 , 0 , 0 },
			{0 , 0 , 0 },
			{0 , 0 , 0 },
			{0,0,0,0,0,0},
			{0,0,0,0,0},
			{0 , 0 , 0 },
			{0 , 0 , 0 },
			{0 , 0 , 0 },
			{0,0,0,0,0},
			{0 , 0 , 0 },
			{0 , 0 , 0 }
		};



double[][] 	wcet = 	
		{	
			{1 , 1 , 1 },
			{2 , 2 , 2 },
			{3 , 5 , 1 },
			{0.1 , 0.1 , 0.1 },
			{10 , 0.1 , 3 },
			{5 , 5 , 5 },
			{0.001,0.001,0.001,0,1,20},
			{1.59,10,1,100,1,1},
			{ 4 , 1 , 4 },
			{ 5 , 100 , 12 },
			{ 0.0012 , 0.0112 , 12},
			{0.000001,2,2,2,2},
			{1,0,1},
			{1231 ,2 , 1 }
		};	



double[][]  deadline = 	
		{ 
			{ 4 ,5, 8  }, 
			{ 4 ,5 ,8  },
			{ 4 ,5, 8  },
			{ 4 ,5, 8  },
			{ 10,60, 70},
			{ 9,13405,20000},
			{ 5,20,30,46,120,300},
			{ 2,50,12323,236666,6666666},
			{ 3000,2323,2366},
			{ 300,56,236},
			{ 10,4,20},
			{30,4,123,45,100},
			{4,4,4},
			{1023420,100,10}
		};
	
	int testcases = 14;
	
	int i , j ;
	
	
	OffsetSchedulabilityHyperplanesAnalysis o ;
	OffsetSchedulabilityRTA tester ;
	
	int F = 1 ;
	
	int numTasks;
	double[] maxInc = new double[6];
	double[] rs = new double[6] ;
	//boolean result ;
	boolean sch , newsch , newsch2 ,correctsch;
	
	double Correction = 0.000001 ; // Nano Correction
	
	for( i = 0 ; i < testcases ; i++ ) {
		
		numTasks = period[i].length ;
		//System.out.println("Length " + numTasks	);
		//System.out.println("****************Test " + i + ":::::::::::::::::::::::::::::::::::::::");
		
		o = new OffsetSchedulabilityHyperplanesAnalysis();
		o.setTotalFixedTask(F);	
				
		tester = new OffsetSchedulabilityRTA();
		tester.setTotalFixedTask(F);	

		o.initTest(period[i],deadline[i],blocking[i],wcet[i],offset[i]) ;
		o.setSensitivityPrecision(Correction);
		
		tester.initTest( period[i],deadline[i],blocking[i],wcet[i],offset[i] ) ;
		correctsch = tester.isTaskSetSchedulable() ;	
		
				
		sch = o.isTaskSetSchedulable();
		o.getResult(maxInc, rs);
		
		
		
		double U  = 0;
		for( j = 0 ; j < numTasks ; j++ ){
			//System.out.println("Task :::: " + j + " \t" +  maxInc[j] ) ;
			U +=  wcet[i][j] / period[i][j];
		}
		
		//System.out.println("\nUtilization ::::  " + U + "  Schedulability  :::  "  + sch + "  Correct = " + correctsch) ;
		assertEquals(sch,correctsch);
		
		double oldwcet ;
		
		for( j = 0 ; j < numTasks ;j++){ 
			oldwcet = wcet[i][j] ; 
			
			//System.out.println("********** Final  Task  " + j + " \t" +  maxInc[j] ) ;
			
			if( wcet[i][j] + maxInc[j] < 0)
				continue ;
			
			
			wcet[i][j] += maxInc[j]  - Correction ;
			tester.initTest( period[i],deadline[i],blocking[i],wcet[i],offset[i] ) ;
			newsch = tester.isLowerPriorityTasksSchedulableWithCurrentOffsets(j) ;	
			
			
			
			wcet[i][j] +=   2 * Correction;
			tester.initTest(period[i],deadline[i],blocking[i],wcet[i],offset[i]) ;
			newsch2 = tester.isLowerPriorityTasksSchedulableWithCurrentOffsets(j) ;
			
						
			if( sch == true ) {
				assertEquals(true,newsch);
			}
			
			if( (oldwcet + maxInc[j]) > 0 )	{
				assertEquals(newsch,true);
				assertEquals(newsch2,false);
			}
			
			//System.out.println("Correct One " ) ;
			
			wcet[i][j] = oldwcet  ;
			
			//System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			}
		}
	}



public void testIsTaskSchedulableWithSensitivityWithMoreFixedTasks() 
{


	long [][]  	period = 	{
				{ 4 , 5,  8 }, 
				{12 ,67,81 },
				{90,1345,2000},
				{5,20,30,41,120,300},
				{5,8,10,15,24,50,75}
				};


	double[][] 	offset = { 
				{ 2 ,4 ,32 }, 
				{ 1 ,1 ,1 },
				{ 6 ,1444 ,144444 },
				{ 1,3,1,6,9,2},
				{1,3,2,10,5,7,11}
			
			// { 11,333,21,13,12} is not working
		 	};


	double[][] 	blocking = 	{ 	
				{0 , 0 , 0 },
				{0 , 0 , 0 },
				{0 , 0 , 0 },
				{0,0,0,0,0,0},
				{0,0,0,0,0,0,0}
			
			
			};



	double[][] 	wcet = 	
			{	
				{1,1,1},
				{10,0.1,3 },
				{5 , 5 , 5 },
				{1, 2, 4, 2, 2, 6},
				{1,2,1,2,4,6,7}
			
			};	



	double[][]  deadline = 	
			{ 
				{ 4 ,5, 8  }, 
				{ 10,60, 70},
				{ 9,1345,2000},// { 9,13405,20000},
				{ 5,20,30,40,120,300},
				{5,8,10,15,20,40,75}
			
			};
		
		int testcases = 5;
		
		int i , j ;
		
		
		OffsetSchedulabilityHyperplanesAnalysis o ;
		OffsetSchedulabilityRTA tester ;
		
		int F = 2 ;
		
		int numTasks;
		double[] maxInc = new double[10];
		double[] rs = new double[10] ;
		//boolean result ;
		boolean sch , newsch , newsch2 ,correctsch;
		
		//System.out.println(" TEST With " + F + "  Fixed Tasks");
		
		double Correction = 0.000001 ; // Nano Correction
		
		for( i = 0 ; i < testcases ; i++ ) {
			
			numTasks = period[i].length ;
			//System.out.println("Length " + numTasks	);
			//System.out.println("****************TEST " + i + ":::::::::::::::::::::::::::::::::::::::");
			
			o = new OffsetSchedulabilityHyperplanesAnalysis();
			o.setTotalFixedTask(F);	
					
			tester = new OffsetSchedulabilityRTA();
			tester.setTotalFixedTask(F);	

			o.initTest(period[i],deadline[i],blocking[i],wcet[i],offset[i]) ;
			o.setSensitivityPrecision(Correction);
			
			tester.initTest( period[i],deadline[i],blocking[i],wcet[i],offset[i] ) ;
			correctsch = tester.isTaskSetSchedulable() ;	
			
			//System.out.println("\nI got the Schedulability " ) ;
					
			sch = o.isTaskSetSchedulable();
			o.getResult(maxInc, rs);
			
			
			double U  = 0;
			for( j = 0 ; j < numTasks ; j++ ){
				//System.out.println("Task :::: " + j + " \t" +  maxInc[j] ) ;
				U +=  wcet[i][j] / period[i][j];
			}
			
			//System.out.println("\nUtilization ::::  " + U + "  Schedulability  :::  "  + sch + "  Correct = " + correctsch) ;
			assertEquals(sch,correctsch);
			
			double oldwcet ;
			
			for( j = 0 ; j < numTasks ;j++){ 
				oldwcet = wcet[i][j] ; 
				
				//System.out.println("********** Final  Task  " + j + " \t" +  maxInc[j] ) ;
				
				if( wcet[i][j] + maxInc[j] < 0)
					continue ;
				
				
				wcet[i][j] += maxInc[j]  - Correction ;
				tester.initTest( period[i],deadline[i],blocking[i],wcet[i],offset[i] ) ;
				newsch = tester.isLowerPriorityTasksSchedulableWithCurrentOffsets(j) ;	
				
				
				
				wcet[i][j] +=   2 * Correction;
				tester.initTest(period[i],deadline[i],blocking[i],wcet[i],offset[i]) ;
				newsch2 = tester.isLowerPriorityTasksSchedulableWithCurrentOffsets(j) ;
				
							
				if( sch == true ) {
					assertEquals(true,newsch);
				}
				
				if( (oldwcet + maxInc[j]) > 0 )	{
					assertEquals(newsch,true);
					assertEquals(newsch2,false);
				}
				
				//System.out.println("Correct One " ) ;
				
				wcet[i][j] = oldwcet  ;
				
				//System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			}
		}
	}
}