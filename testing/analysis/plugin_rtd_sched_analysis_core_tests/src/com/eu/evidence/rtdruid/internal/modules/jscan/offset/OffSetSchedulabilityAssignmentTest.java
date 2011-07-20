/*
 * Created on Jul 20, 2004
 *
 * $Id: OffSetSchedulabilityAssignmentTest.java,v 1.1 2005/09/28 15:22:29 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.jscan.offset;

import junit.framework.TestCase;

/**
 * @author sachin
 *
 */
public class OffSetSchedulabilityAssignmentTest extends TestCase {
	/*
	 * @see TestCase#setUp()
	 */
	int testCases = 2 ;
	int numTasks = 5 ;
	
	long P[][] = { 
					{ 5,10,20,40,60},
					{ 8,14,28,50,125}
				};
	int depend[][] 	= { 
					{2,2,2,2,2},
					{1,1,1,3,3}
					};
	
	double result[][] = {
						{7.5, 5 , 0 ,10 ,10},
						{9,0,7,0,12.5}
						};
	OffSetSchedulabilityAssignment o ;
	protected void setUp() throws Exception {
		
		o = new OffSetSchedulabilityAssignment();
		super.setUp();
	}
	public void testSetDissimilarTaskOffsets() {
		int i , j ;
		double[] offset = new double[numTasks];
		double expected ;
		for(i = 0 ; i < testCases ;i++){
			o.setDissimilarTaskOffsets(P[i],numTasks,offset);
			for(j = 0 ; j < numTasks ; j++){
				expected = offset[ depend[i][j]] + result[i][j];
//				expected = expected  % P[j]
				assertEquals(offset[j],expected,0.0001);
//				assertEquals(true, (offset[j]< P[i][j]));
			}		
		}
	}

public void testGcd() {
	long T[][] = {
						{ 10 ,30},
						{24,25},
						{30,35},
						{40,100},
						{23,25},
						{1,1},
						{10,10}
					};
		long result[]={10,1,5,20,1,1,10};
		
		int i  ;
		for(i = 0 ; i < result.length ;i++)
			assertEquals(result[i],o.gcd(T[i][0],T[i][1]));					
	}
}
