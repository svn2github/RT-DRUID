/*
 * Created on Jul 21, 2004
 *
 * $Id: OffsetSchedulabilityEDFTest.java,v 1.1 2005/09/28 15:22:29 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.jscan.offset;

import junit.framework.TestCase;

/**
 * @author sachin
 *
 */
public class OffsetSchedulabilityEDFTest extends TestCase {
	
	
public void testIsTaskSetSchedulable() {

long [][] period = 	{
						{ 3 , 5,  10 }, 
						{ 5 , 9 , 12 },
						{ 5 , 9 ,12  },
						
					};


double[][]  offset =  { 
						{ 1 ,0 ,2 }, 
						{ 0 ,1 ,4 },
						{ 0 ,1 ,4 },
					};


double[][] blocking = 	{ 	
							{0 , 0 , 0 },
							{0 , 0 , 0 },
							{0 , 0 , 0 },
						};


double[][] wcet = 	{	
					{ 1 , 2 , 2 },
					{ 2 , 3 , 2  },
					{ 2.29 , 3 , 2 },
					};	


double[][]  deadline = 	{ 
						{ 3 ,4, 8  }, 
						{ 4 , 7 ,10 },
						{ 4 , 7 ,10 },
					};

double[] zerooffset = {0 , 0 , 0} ;

int testcases = 3 ;
int numTasks = 3 ;

boolean[] result = {true,true,false} ;

int i , j ;

OffsetSchedulabilityEDF e ;

for( i = 0 ; i < testcases ;i++){
	e = new OffsetSchedulabilityEDF();	
	e.setTotalFixedTask(3);
	e.initTest(period[i],deadline[i],blocking[i],wcet[i],offset[i]);
	assertEquals(result[i] , e.isTaskSetSchedulable() );
	}


boolean currentresult1 , currentresult2 ;

for( i = 0 ; i < testcases ;i++){
	e = new OffsetSchedulabilityEDF();	
	
	e.setTotalFixedTask(2);	
	e.initTest(period[i],deadline[i],blocking[i],wcet[i],zerooffset);
	currentresult1 = e.isTaskSetSchedulable() ;
	
	e.initTest(period[i],deadline[i],blocking[i],wcet[i],offset[i]);
	currentresult2 = e.isTaskSetSchedulable() ;
	
	if(currentresult1 == true)
		assertEquals(true,currentresult2 );
	
	}		


for( i = 0 ; i < testcases ;i++){
		currentresult2 = false ;
		for(j = 1 ; j < numTasks ; j++)	{
			e = new OffsetSchedulabilityEDF();		
			e.setTotalFixedTask(j);	
			e.initTest(period[i],deadline[i],blocking[i],wcet[i],zerooffset);
			currentresult1 = e.isTaskSetSchedulable() ;
			
			if(currentresult2 == true)
				assertEquals(true,currentresult1 );
			
			currentresult2 = currentresult2 || currentresult1 ;
		}
	}


}







public void testIsSchedulableWithCurrentOffsets() {

long [][] period = 	{
				{ 3 , 5,  7  }, 
				{ 5 , 7 ,10  },
				{ 5 , 7 ,10  }
			};

double[][]  offset =  { 
				{ 1 ,0,  2  }, 
				{ 0 ,1 ,4 },
				{ 0 ,1 ,4 }
			};
int[] starter = { 1,0,0};
	 
double[][] blocking = 	{ 	
				{0 , 0 , 0 },
				{0 , 0 , 0 },
				{0 , 0 , 0 }
			};

double[][] wcet = 
{	
				{ 1 , 2 , 2 },
				{ 2 , 3 , 2  },
				{ 2.00001 , 3 , 2  }
			};	

double[][]  deadline = 	{ 
				{ 3 ,4, 6  }, 
				{ 4 , 6 ,8 },
				{ 4 , 6 ,8 }
			};

int testcases = 3 ;

boolean[] result = {true,true,false} ;



int i ;
OffsetSchedulabilityEDF e = new OffsetSchedulabilityEDF();

for( i = 0 ; i < testcases ;i++){
	e.initTest(period[i],deadline[i],blocking[i],wcet[i],offset[i]);
		assertEquals(result[i],e.isSchedulableWithCurrentOffsets(starter[i],offset[i],(boolean[])null,(double[])null));
	}		
}

	




public void testIdleTimeFromWithGivenOffset() {

long[] period = { 5 , 10,13 };

double[] offset = { 0 ,2, 1 };

double[] deadline = { 4 ,8 ,7};


double[] blocking = {0 , 0 , 0 };

double[] wcet = { 2 , 3 ,2  } ;

int testcases = 1 ;

double[] start = {0  , 6 , 5 , 7} ;
double[] result = {0 , 9, 9, 9 } ;
	   
int i ;
OffsetSchedulabilityEDF e = new OffsetSchedulabilityEDF();
e.initTest(period,deadline,blocking,wcet,offset);

for( i = 0 ; i < testcases ;i++){
	assertEquals(result[i],e.idleTimeFromWithGivenOffset(start[i],offset),0.001);
	}		
}


public void testDemandFunctionWithGivenOffset() {

	long[] period = { 5 , 10,13 };

	double[] offset = { 0 ,2, 1 };

	double[] deadline = { 4 ,8 ,7};


	double[] blocking = {0 , 0 , 0 };

	double[] wcet = { 2 , 3 ,2  } ;

	int testcases = 3 ;

	double[][] t = {
					{0 , 2},
					{0 , 8},
					{5, 15}
					};
	double[] result = { 0 ,7 , 4} ;
		   
	int i ;
	OffsetSchedulabilityEDF e = new OffsetSchedulabilityEDF();
	e.initTest(period,deadline,blocking,wcet,offset);

	for( i = 0 ; i < testcases ;i++){
		assertEquals(result[i],e.demandFunctionWithGivenOffset(t[i][0],t[i][1],offset),0.0001);
		}	
	}
}
