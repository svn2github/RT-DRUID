/*
 * Created on Jul 14, 2004
 *
 * $Id: PeriodSensitivity.java,v 1.1 2005/09/28 15:22:29 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.jscan.common;

import java.text.DecimalFormat;




/**
 * @author sachin
 *
 *  This class is build to give period Sensitivity analysis in the Fixed Priority System. Period Sensitivity is calculated by apprroxiamtion.
 * In the given class we calculate the Upper Bound and lower bound for the periods. And Using the Bisection method we find the the best possible 
 * point of the Schedulability with the given Precision. Upper bound for the Schedulability is given by the EDF Bound.
 * Lower bound for the task schedulability is given by the Hyper Bound.
 **/

public class PeriodSensitivity extends HyperplanesAnalysis {

	// FPSensitivityIndividual represents period sensitivity of the task scheduled in the Fixed Static Priority ordering keeping all high 
	// priority tasks schedulable.   
	double [] FPSensitivityIndividual ;
	
	//	 FPSensitivityAll represents period sensitivity of the task scheduled in the Fixed Static Priority ordering keeping all the tasks
	// in the system schedulable.
	double [] FPSensitivityAll ;
	
	// RMSensitivityIndividual represents period sensitivity of the task scheduled in the Rate Monotonic Priority ordering keeping all higher 
	//	pririty tasks schedulable. 
	double [] RMSensitivityIndividual ;
	
	//  RMSensitivityAll represents period sensitivity of the task scheduled in the Rate Monotonic Priority ordering keeping all the tasks
	//  in the system schedulable.
	double [] RMSensitivityAll ;
	
	// Used to run the the computation for the specified scheme
	// 0 ..... Static Priority 
	// 1 ..... RM 
	// 2 ..... RM and Static Priority
	int schedulingscheme ;
	
	// Provides the precision on the Frequency of the Task.
	double Precision ;
	
	public PeriodSensitivity()	{
		Precision = 0.00001 ;
		schedulingscheme = 2 ;
	}
	
	public void setPrecision(double p){
		Precision = p ;
	}
	
	void setSchedulingScheme(int scheme){
		schedulingscheme = scheme ;		// 0 indicates Fixed Static Priority. 
										// 1 indicates Rate Monotonic priority.
										// 2 Make sensitivity analysis with both.	
	}
	
	
	public void compute(int cpuId) {
		if (!init(cpuId)) 
				return;	// tasks.size == 0
		/* Make All Deadlines Equals to Zero ........*/
		deadline = (double[]) period.clone() ;
		
		if(schedulingscheme == 0 || schedulingscheme == 2 )	
		{
		FPSensitivityIndividual = new double[numTasks];
		FPSensitivityAll = new double[numTasks];
		getSensitivityFP(FPSensitivityIndividual,FPSensitivityAll);
		}
		 
		if(schedulingscheme == 1 || schedulingscheme == 2 )	{
		RMSensitivityAll = new double[numTasks];
		RMSensitivityIndividual = new double[numTasks];
		getSensitivityRM(RMSensitivityIndividual,RMSensitivityAll);
		}		
		storeData(cpuId);
	}
	
	
	
	public String getReport(int cpuId){
		String rep = new String();
		int i ;
		rep += "\nSensitivity Analysis on Periods with Precision :: " + Precision + "\n";
	
		rep += "\nTask Set ::::::: Sorted According To Priority\n";
		rep += "\nTotal Tasks ::: " + numTasks + "\n";
		
		rep +=  "\nName\t\tPeriod\t\twcet\tBlocking\tPriority \n" ;
		
		DecimalFormat d = new DecimalFormat("##0.0000");  
//		DecimalFormat d1 = new DecimalFormat("000.00000");
		
		for (i = 0; i < numTasks; i++) 
			rep += 	tasks.getItem(cpuId,i).getName()  + "\t\t\t"
				+ 	d.format(tasks.getItem(cpuId, i).getDouble("period")) + "\t\t"
				+	d.format(tasks.getItem(cpuId, i).getDouble("wcet"))+"\t\t"
				+	d.format(tasks.getItem(cpuId, i).getDouble("blocking")) +"\t\t" 
				+ 	tasks.getItem(cpuId,i).getProperty("priority") +"\n";
		
		rep += "\nAll the Deadlines in the Given Task set are stretched towords Period\n";
		
		if(schedulingscheme == 0 || schedulingscheme == 2 )	{
			
			rep += "\nFixed Static Priority Ordering\n ::::::::::";
			rep += "\nSensitivity of Task Period Keeping All High Priority Tasks Schedulable" ;
			rep += "\nName\t\tPeriod\t\tTMinimum\n" ;
			for (i = 0; i < numTasks; i++) 
				rep += 	tasks.getItem(cpuId,i).getName() + "\t\t\t"
					+	tasks.getItem(cpuId,i).getProperty("period")+"\t\t" 
					+ 	tasks.getItem(cpuId,i).getTempProperty("FPTDeltaIndividual")+ "\n" ;
								

			rep += "\n\nSensitivity of Task Period Keeping All Tasks Schedulable" ;
			rep += "\nName\t\tPeriod\t\tTMinimum \n" ;
			for (i = 0; i < numTasks; i++) 
				rep += 	tasks.getItem(cpuId,i).getName() + "\t\t\t"
					+	tasks.getItem(cpuId,i).getProperty("period")+"\t\t" 
					+ 	tasks.getItem(cpuId,i).getTempProperty("FPTDeltaAll")+"\n" ;			
		}
		 
		if(schedulingscheme == 1 || schedulingscheme == 2 )
		{
			rep += "\nRate Monotonic Priority Ordering\n ::::::::::";
/*			rep += "\nSensitivity of Task Period Keeping All High Priority Tasks Schedulable" ;
			rep += "\nName\t\tPeriod\t\tTDelta\n" ;
			for (i = 0; i < numTasks; i++) 
				rep += 	tasks.getItem(cpuId,i).getName() + "\t\t"
					+	tasks.getItem(cpuId,i).getProperty("period")+"\t\t" 
					+ 	tasks.getItem(cpuId,i).getTempProperty("RMTDeltaIndividual")+ "\n" ;
*/								
			rep += "\nSensitivity of Task Period Keeping All Tasks Schedlable" ;
			rep += "\nName\t\tPeriod\t\tTMinimum \n" ;
			for (i = 0; i < numTasks; i++) 
				rep += 	tasks.getItem(cpuId,i).getName() + "\t\t\t"
					+	tasks.getItem(cpuId,i).getProperty("period")+"\t\t" 
					+ 	tasks.getItem(cpuId,i).getTempProperty("RMTDeltaAll")+"\n" ;		

		}
		
		rep += "\n" ;
	
		assignExistingPriorities() ;
		rep += "IS Schedulable :: " + isFPSchedulable() + "  With Static Priority Ordering \t\t\tTotalUtilization :: " + totalU + "\n";
		
		assignDMPriorities() ;

		rep += "IS Schedulable :: " + isFPSchedulable() + "  With RM Priority Ordering\t\t\tTotalUtilization :: " + totalU + "\n";

		System.out.println( rep + "\n\n");	
		return rep ;
	}
	

// Stores the Calculated data in the the Tree as Temporory value
public void storeData(int cpuId) {
		if(schedulingscheme == 0 || schedulingscheme == 2 )	
			for (int i=0; i< tasks.getSize(cpuId); i++) {
			tasks.getItem(cpuId, i).setTempProperty("FPTDeltaIndividual", FPSensitivityIndividual[i]);
			tasks.getItem(cpuId, i).setTempProperty("FPTDeltaAll", FPSensitivityAll[i]);
			}
		
		if(schedulingscheme == 1 || schedulingscheme == 2 )
			for (int i=0; i< tasks.getSize(cpuId); i++) {
			tasks.getItem(cpuId, i).setTempProperty("RMTDeltaIndividual", RMSensitivityIndividual[i]);
			tasks.getItem(cpuId, i).setTempProperty("RMTDeltaAll", RMSensitivityAll[i]);
		}
//	tasks.setSave(false);
	}


// Returns the Sensitivity of the Tasks set when it is scheduled according to the Static Priority ordering
public void getSensitivityFP(double[] individual , double[] all ){
		int i ;
		for(i = 0 ; i < numTasks ;i++)			
			individual[i] = getTaskSensivityIndividualTaskSchedulableFP(i);
		
		for(i = 0 ; i < numTasks ;i++)			
			all[i] = 		getTaskSensivityAllTaskSchedulableFP(i);
		
	}


//Returns the Sensitivity of the Tasks set when it is scheduled according to the Rate Monotonic ordering
public void getSensitivityRM(double[] individual , double[] all ) {
		int i ;
	
//		for(i = 0 ; i < numTasks ;i++)			
//			individual[i] = getTaskSensivityIndividualTaskSchedulableRM(i,periodsensitivity);
		
		for(i = 0 ; i < numTasks ;i++)			
			all[i] = 	getTaskSensivityAllTaskSchedulableRM(i);
	}

// Returns the Sensitivity of the Tasks set when it is scheduled according to the Static Priority ordering. The
// sensitivity signifies that any change in the period in the range of sensitivity does not affect schedulability
// of the current tasks and all high priority tasks.
public double getTaskSensivityIndividualTaskSchedulableFP(int iTask) {
			double edfbound , hyperbound  ;
			double bisection ;	
			double taskperiod ;
			boolean flag = false ;		
					
			edfbound   = getEDFBoundForPeriod(iTask);
			hyperbound = getHyperBoundForPeriod(iTask);
			
			if(edfbound <= 0 ) return -1 ;
			if(hyperbound <= 0 )	hyperbound = Precision ;
			
//			System.out.print("\n*********************************Task :: " +iTask + "\t" + 1/edfbound + "\t" + 1/hyperbound);		

			taskperiod = period[iTask];
			
			while(Math.abs(1/edfbound - 1/hyperbound) > Precision){
				
				bisection = ( edfbound + hyperbound) / 2 ;
				period[iTask] = 1 / bisection ;	
				deadline[iTask] = period[iTask] ;
							
//				for(j = 0 ; j < numTasks ;j++)
//					System.out.print("\nTask :: " + j + "\t" +  period[j] );
					
				assignExistingPriorities();			
				if( isFPSchedulable(iTask) ){			
//					System.out.print("\tYES");
					hyperbound = bisection ;					
				}
				else {
					edfbound = bisection ;
//					System.out.print("\tNO");
				}
			}
			
			period[iTask] =  1/hyperbound ;
			deadline[iTask] = period[iTask];
			
			assignExistingPriorities();		
			if(isFPSchedulable(iTask)){
					flag = true ;
			}
			
			period[iTask] = taskperiod ;
			deadline[iTask] = taskperiod;
						
			if(flag) return 	1/hyperbound ;			
			return -1 ;
	}


// Returns the Period Sensitivity of the Task when it is scheduled according to the Static Priority ordering. The
//sensitivity signifies that any change in the period in the range of sensitivity does not affect schedulability
//of all high priority tasks.
public double getTaskSensivityAllTaskSchedulableFP(int iTask ) {
	double edfbound , hyperbound ;
	double bisection ;	
	double taskperiod ;
	
	boolean flag = false ;
	
	edfbound   = getEDFBoundForPeriodWithAllSchedulable(iTask);
	hyperbound = getHyperBoundForPeriodWithAllSchedulable(iTask);

//	System.out.print("\n*********************************Task :: " +iTask + "\t" + 1/edfbound + "\t" + 1/hyperbound);		

	if(edfbound <= 0   ) return -1 ;
	if(hyperbound <= 0 )	hyperbound = Precision ;
	
	
	taskperiod = period[iTask];

	while(Math.abs(1/edfbound - 1/hyperbound) > Precision) {
		
		bisection = ( edfbound + hyperbound) / 2 ;
		period[iTask] = 1 / bisection ;	
		deadline[iTask] = period[iTask] ;

//		for(j = 0 ; j < numTasks ;j++)
//			System.out.print("\nTask :: " + j + "\t" +  period[j] );
		
		assignExistingPriorities();
				
		if( isFPSchedulable() ){
//			System.out.print("\tYES");
			hyperbound = bisection ;
		}
		else {
			edfbound = bisection ;
//			System.out.print("\tNO");
		}
	}
	
	period[iTask] =  1/hyperbound ;
	deadline[iTask] = period[iTask];
	
	assignExistingPriorities();		
	
	if(isFPSchedulable()){
			flag = true ;
	}
	
	period[iTask] = taskperiod ;
	deadline[iTask] = taskperiod ;
	
	if(flag)	return 1/hyperbound ;
	return -1 ;
}




//Returns the Period Sensitivity of the Task when it is scheduled according to the Static Priority ordering. The
//sensitivity signifies that any change in the period in the range of sensitivity does not affect schedulability
//of all high priority tasks.
public double getTaskSensivityAllTaskSchedulableRM(int iTask ) {
		
		double edfbound , hyperbound;//  ,actualedfbound;
		double bisection ;	
		boolean flag = false ;
		double taskperiod[] ,taskdeadline[] , taskwcet[],taskblocking[];
		int i , k ;
		
			
		taskperiod = new double[numTasks] ;	
		taskdeadline = new double[numTasks] ; 
		taskwcet = new double[numTasks] ; 
		taskblocking = new double[numTasks];			
		
		for(i = 0 ; i < numTasks ;i++){
			taskperiod[i] = period[i] ;
			taskdeadline[i] = period[i] ;
			taskwcet[i] = wcet[i] ;
			taskblocking[i] = blocking[i];
			}
			
		iTask = sortperiods(iTask) ;
		assignExistingPriorities() ;
		
		edfbound   = getEDFBoundForPeriodWithAllSchedulable(iTask);
		hyperbound = getHyperBoundForPeriodWithAllSchedulable(iTask);

//		System.out.print("\nR **************************Task :: " + iTask  + "\tPeriod ::" + period[iTask] + "\tEDF " + 1/edfbound + "\tHyper " + 1/hyperbound);
		
// 	If the EDF Bound is less than or equal to zero indicates that Task is not schedulable 
//	with any change in period	of the current task. 
// If the Hyperbound is below the zero then in real condition we should back it to the Period
// Precision which is very small value in the terms of the Frequency.
		
		if(edfbound <= 0 ) 
			{	
			for(i = 0 ; i < numTasks ;i++){
				period[i] = taskperiod[i] ;
				deadline[i] = taskperiod[i] ;
				wcet[i] = taskwcet[i] ;
				blocking[i] = taskblocking[i];
				}	
				return -1 ;
			}
		
		if(hyperbound <= 0 )	hyperbound = Precision ;
		
		// actualedfbound = edfbound ;
		
		while(Math.abs(1/edfbound - 1/hyperbound ) > Precision) {
			
			bisection = ( edfbound + hyperbound) / 2 ;
			period[iTask] = 1 / bisection ;	
			deadline[iTask] = period[iTask] ;
					
//			for(j = 0 ; j < numTasks ;j++)
//			System.out.print("\nTask :: " + j + "\t" +  period[j] + "\t" + wcet[j]);
			
			k = sortperiods(iTask) ;
			assignExistingPriorities() ;
	
			// Its must to rearrage the EDFbound when period of the current task becomes lesser 
			// than any of the higher priority task.

			iTask = k ;
						
			if( isFPSchedulable() ){
				System.out.print("\tYES\n");
				hyperbound = bisection ;
			}
			else {
				edfbound = bisection ;
				System.out.print("\tNO\n");
			}
		}
	
		period[iTask] = 1/hyperbound ;	
		deadline[iTask] = period[iTask] ;				
		
		sortperiods(0);
		assignExistingPriorities();
		if(isFPSchedulable()) flag = true ;
		
		for(i = 0 ; i < numTasks ;i++){
			period[i] = taskperiod[i] ;
			deadline[i] = taskperiod[i] ;
			wcet[i] = taskwcet[i] ;
			blocking[i] = taskblocking[i];
			}
					
//		for(j = 0 ; j < numTasks ;j++)
//			System.out.print("\nR Task :: " + j + "\t" +  period[j] );
//		System.out.print("\nR Task :: " + iTask  + "\t" + 1/ hyperbound + "\n" );	
		if(flag){
			System.out.print("\t YES" );
			return 1/hyperbound ;			
		}
		return -1 ;
}


public int sortperiods(int iTask){
	int originalorder[];
	int i , j , k ;
	double temp ;
	originalorder = new int[numTasks];
	
	double[] b = new double[numTasks] ;
	double[] w = new double[numTasks] ;
 
	
	for(i = 0 ; i < numTasks ;i++)
		originalorder[i] = i ;
	
	for(i = 0 ; i < numTasks ; i++) {
		for(j = i + 1 ; j < numTasks ;j++)
			if(period[j-1] > period[j])	{
					
				temp = period[j]; 			
				period[j] = period[j-1] ;
				period[j-1] = temp ;
				
				k = originalorder[j] ;
				originalorder[j] = originalorder[j - 1];
				originalorder[j - 1] = k ;
				
				if(iTask == j)	iTask = j-1 ;
				else
					if(iTask == j-1) 
						iTask = j ;
			}
		}
	
	
	for(i = 0 ; i < numTasks ; i++) {
		k = originalorder[i] ;
		
		b[i] = blocking[k] ;
		w[i] = wcet[k] ;		
	}
	
	for(i = 0 ; i < numTasks ; i++) {
		blocking[i] =  b[i];
		wcet[i] = w[i];
		deadline[i] = period[i] ;
	}
	
	return iTask ;
}
	

// Calculate the EDFBound for the period which signifies the bound is valid for the EDF. EDF provides the maximum utilization
// so it is used as upper bound for the period.
public double getEDFBoundForPeriodWithAllSchedulable(int iTask) {
		double e = 0 ;
		int i ;	
			for(i = 0 ; i < numTasks ; i++) {
				if( i != iTask)	
					e +=  wcet[i] / period[i];
			}
//			System.out.print("\n****** Task :: " +iTask + "\t" + (1-e)/wcet[iTask] + "\t" + (0.69-e)/wcet[iTask]);
			e = 1 - e ;
			e = e / wcet[iTask];
			return e;	 
		}

//Calculate the EDFBound for the period considering only high priority tasks 
// which signifies the bound is valid for the EDF. EDF provides the maximum utilization
//so it is used as upper bound for the task frequency. Its used to set upper bound when we are going to 
// calcuate the period sensitivity considering only higher priority tasks.
public double getEDFBoundForPeriod(int iTask) {
		double e = 0 ;
		int i ;	
			for(i = 0 ; i < iTask ; i++) {
				e +=  wcet[i] / period[i];
			}		
//			System.out.print("\n****** Task :: " +iTask + "\t" + (1-e)/wcet[iTask] + "\t" + (0.69-e)/wcet[iTask]);
			e = 1 - e ;
			e = e / wcet[iTask];
			return e;	 
		}

// Calculate the HyperBound for the frequency keeping all tasks schedulable which signifies the bound is valid for the Fixed Priority. 
// It provides the sufficient bound 
// schedulability in the Fixed Priority Scheme. so it is used as lower bound for the task frequency. 

public double getHyperBoundForPeriodWithAllSchedulable( int iTask) {		
		double u1 = 0 , u2 = 0 , u3 = 0 , u4 = 0 , fmin,fmintemp ;
		int i , k;

	for(i = 0 ; i < iTask ;i++){
			u1 += wcet[i] / period[i] ;
			u2 += wcet[i] * ( 1 - wcet[i] / period[i]) ;
		}
		
	fmin = ( 1 - u1)/(wcet[iTask] + u2) ;
//	System.out.print("\nTask :: " + iTask + "  " + 1/fmin); 
	for( k = iTask + 1 ; k < numTasks  ; k++){
		u3 += wcet[k] / period[k] ;
		fmintemp = ( 1 - u1 -  u2/period[k] -  u3 - u4/period[k] - wcet[iTask]/period[k]) / 
		( wcet[iTask] - ( wcet[iTask] * wcet[iTask])/period[k]) ;
//		System.out.print("\nTask :: " + iTask + "  " + 1/fmintemp); 
		
		if( fmintemp < fmin ) fmin = fmintemp ;	
		
		u4 += wcet[k] * ( 1 - wcet[k]/period[k]) ;
		}
		return fmin ;		
	}	

//Calculate the HyperBound for the period considering only high priority tasks 
//which signifies the bound is valid for the Fixed Priority. 
//so it is used as lower bound for the task frequency. Its used to set lower bound when we are going to 
//calcuate the period sensitivity considering only higher priority tasks.

public double getHyperBoundForPeriod( int iTask) {
		double u1 = 0 , u2 = 0 ;
			int i ;
			
			for(i = 0 ; i < iTask ;i++){
				u1 += wcet[i]/period[i] ;
				u2 += wcet[i] * ( 1 - wcet[i] / period[i]) ;
			}
			return ( 1 - u1)/(wcet[iTask] + u2) ;	
		}




/*****************************************************************************************************************/	
/************************************************** TESTING ******************************************************/
/*****************************************************************************************************************/
	
public boolean setTestParameters(double[] myperiod , double[] myblocking , double[] mywcet ){
		int i = 0 ;
		numTasks = myperiod.length ;
		if( (numTasks != mywcet.length) && (numTasks != myblocking.length)  )
				return false;
		
		period = (double[]) (myperiod.clone());
		wcet = (double[]) (mywcet.clone());
		deadline = (double[]) (myperiod.clone());
		blocking = (double[]) (myblocking.clone());
		utilization = (new double[numTasks]);
		
		totalU = 0 ;
		for(i = 0 ; i < numTasks ; i++)	{
			utilization[i] = wcet[i] / period[i] ;
			totalU += utilization[i] ;
			}
		
		assignExistingPriorities();
		return true ;
	}
public void setTestPeriod(int i , double p){
	period[i] = p ;
	deadline[i] = p ;
}


}
