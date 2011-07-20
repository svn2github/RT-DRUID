package com.eu.evidence.rtdruid.internal.modules.jscan.offset;

import com.eu.evidence.rtdruid.internal.modules.jscan.common.RMSchedulability;
import com.eu.evidence.rtdruid.vartree.abstractions.old.GenRes;



/*
 * Created on Jun 21, 2004
 */

/**
 * @deprecated not more used
 * */
public class OffsetRMSchedulabilityComplete extends RMSchedulability {

	protected int NumTasks;
	protected double TotalUtilization ;
	protected long Period[] ;
	protected double Wcet[];
	protected double Utilization[];
	protected double Blocking[];
	protected double Offset[] ;
	protected boolean[] IsSchedulable ;
	private double WorstCaseBusyPeriod[] ;	
	private boolean Schedulable ;
	private boolean Computed ; 
	

public OffsetRMSchedulabilityComplete(){
		Computed = false ;
		Schedulable = true ;
		}
	

public void compute(int cpuid)
	{
	if(!Computed)	{
	
	if( !init(cpuid))	return;
		
	checkTask(NumTasks - 1 , IsSchedulable , WorstCaseBusyPeriod , cpuid); 
	
/* 	storeData(cpuid); */
	Computed = true ;
	}
}


public boolean isSchedulable(int cpuid)	{
	int i ; 
	boolean flag = true ;
	compute(cpuid);
	for( i = 0 ; i < NumTasks ; i++)
		flag = flag && IsSchedulable[i] ;
	return flag ;
	}


/**************** For Testing **************************************/

public void init(long p[] , double[] w , double[] o)	{
		
		int i ;
	
		NumTasks = p.length ;
		Period = new long[NumTasks];
		Wcet = new double[NumTasks];
		Utilization = new double[NumTasks];
		Blocking = new double[NumTasks];
		Offset = new double[NumTasks] ;
		WorstCaseBusyPeriod = new double[NumTasks] ;
		IsSchedulable = new boolean[NumTasks] ;
		TotalUtilization = 0;
		
	
	for (i = 0 ; i < p.length ; i++)	{
		Period[i] = p[i] ;
		Wcet[i] = w[i] ;
		Offset[i] = o[i] ;
		IsSchedulable[i] = true ;
		}
	}


	
public boolean init(int cpuId) {
		if (tasks == null) {
			throw new IllegalStateException("Set a taskList before compute something!");
		}
		if (tasks.getPrefixNumber() <= cpuId) {
			throw new IndexOutOfBoundsException("Required a non-existent cpuId : max id =" + tasks.getPrefixNumber() + " , required id = " + cpuId);
		}
		if (tasks.getSize(cpuId) == 0) {
			return false;
		}

		if (risorse == null) {
			throw new IllegalStateException("Set a resourceList before compute something!");
		}
		if (risorse.getPrefixNumber() == 0) {
			throw new IllegalStateException("Set a not empty resourceList before compute something!");
		}
		
		tasks.sortByPeriod();
		computeCeilings(cpuId);
		computeBlockingTimes(cpuId);
		
		int iTask;

		NumTasks = tasks.getSize(cpuId);
		Period = new long[NumTasks];
		Wcet = new double[NumTasks];
		Utilization = new double[NumTasks];
		Blocking = new double[NumTasks];
		Offset = new double[NumTasks] ;
		WorstCaseBusyPeriod = new double[NumTasks] ;
		IsSchedulable = new boolean[NumTasks] ;
		TotalUtilization = 0;
		
		for (iTask = 0; iTask < NumTasks; iTask++) {
			GenRes t = tasks.getItem(cpuId,iTask);

			Period[iTask] = (new Double( t.getDouble("period"))).longValue();
			/* Deadlines are equal to periods, when not specified */
			
			/* WCETs set to zero when not specified */
			if (t.existProperty("wcet")) {
				Wcet[iTask] = t.getProperty("wcet") == "" ? 0 : t.getDouble("wcet");
			} else {
				Wcet[iTask] = 0;
			}
			/* Blocking times set to zero when not specified */
			if (t.existProperty("blocking")) {
				Blocking[iTask] = t.getProperty("blocking") == "" ? 0 : t.getDouble("blocking");
			} else {
				Blocking[iTask] = 0;
			}
			
			if ( t.existProperty("offset")) {
				Offset[iTask] = t.getProperty("offset") == "" ? 0 : t.getDouble("offset");
			}else
			{
				Offset[iTask] = 0 ;
			}
			
			/* Set utilization */
			Utilization[iTask] = Wcet[iTask] / Period[iTask];
			t.setProperty("utilization",Utilization[iTask]);
			
			TotalUtilization += Utilization[iTask];
			}
		return true;
	}

    
public String getReport(int cpuId)
  {
	  if (tasks == null) {
		  throw new IllegalStateException("Set a taskList before get Report!");
	  }
	  if (tasks.getPrefixNumber() <= cpuId) {
		  throw new IndexOutOfBoundsException("Required a non-existent cpuId : max id =" + tasks.getPrefixNumber() + " , required id = " + cpuId);
	  }
	  if (tasks.getSize(cpuId) == 0) {
		  return "No task";//throw new IllegalStateException("Set a not empty taskList before get utilization!");
	  }

	String rep = new String("Rate Monotonic Utilization Test\n");
    rep += "Priorities have been assigned according to the Rate Monotonic Order:\n";
    rep += "tasks with shorter periods have higher priority.\n";
    rep += "Blocking times have been computed according to the Priority Ceiling\n";
    rep += "Protocol\n";

    int i;
    for (i=0; i<tasks.getSize(cpuId);i++) {
      rep += "Task " + tasks.getItem(cpuId,i).getName() + ":\n";
      rep += "\t Utilization: " + Utilization[i] + "\n";
      rep += "\t Blocking factor: " + Blocking[i] + "\n";
      
      if( IsSchedulable[i])
      	 rep += "SCHEDULABLE\n";
      else 
      	rep += "NOT SCHEDULABLE\n\n";
      rep += "Worst Case Busy Period :" + WorstCaseBusyPeriod[i] + "\n" ; 
      
    }
	
	rep += "--------------------------------------------------\n";
    return rep;
  }

	
	
public long checkTask( int taskid , boolean[] isSchedulable , double[] WorstCaseAnalysis , int cpuid  ) {
	 	int i ;
	 	long hp ;
	 	
	 	if(taskid == 0)	{
	 		isSchedulable[0] = true ;
	 		return Period[0] ;
	 	}
	 	
	 	long sat ,activations ; /* Shortest Activation Time */
	 	
	 	hp = checkTask(taskid - 1 , isSchedulable,WorstCaseAnalysis , cpuid) ;
	 	sat = gcd(hp,Period[taskid]); 
	 	
	 	isSchedulable[taskid] = true ; 	
	 	
	 	hp = ( hp * Period[taskid]) / sat ;
	 	
	 	if ( getUtilization(taskid + 1 , cpuid) <  getRMBound(taskid + 1 ) ) { 
	 		WorstCaseAnalysis[taskid] = 0 ;
	 		return hp ;
	 		}
	 		
	 	
	  	int bpsid = 0 ;
	 	double bps = 0 , bpe , l ,nextidletime ; /**** Busy Period Starting and Busy Period Ending */
	 	
	 	for(i = 0 ; i <= taskid ; i++) 
	 		if ( Offset[i] > bps ){
	 			bps = Offset[i] ;
	 			bpsid = i ;
	 		}

		bpe = bps + Wcet[bpsid] ;

	 	do{
	 		do	{
	 			l = bpe ;
	 			bpe = bps ;	
	 			
	 			if ( (l - bps)  > 3 * Period[taskid] ){
	 				WorstCaseAnalysis[taskid] = 0 ;
	 				break ; }
	 			
	 			for( i = 0 ; i <= taskid ; i++)
					bpe += (  Math.ceil( (l - Offset[i])/Period[i]) - Math.ceil( (bps - Offset[i])/Period[i]) ) * Wcet[i] ;
			
	 		}while(bpe != l) ;
	 		
	 		if( WorstCaseAnalysis[taskid] < (bpe - bps) )
	 			WorstCaseAnalysis[taskid] = bpe - bps ; 
	 		
	 		activations = (long) (Math.ceil( (bpe - Offset[taskid])/Period[taskid]) - Math.ceil( (bps - Offset[taskid])/Period[taskid])) ;
	 		
	 	if( activations > 1 ){
	 		isSchedulable[taskid] = isSchedulable[taskid] && false ; 
	 	}
	 	
	 	bps  = bpe ;  
	 	nextidletime =  Offset[0] + Math.ceil( (bps - Offset[0]) / Period[0] ) * Period[0] ;	
//	 	nextidletime =  Offset[0] + Math.floor(  ( (bps - Offset[0]) / Period[0] )  + 1 )* Period[0] ;
	 	bpsid = 0 ;
	 	double  temp ;
	 	
	 	for(i = 1 ; i <= taskid ; i++) 	{
	 		temp =  Offset[i] +  Math.ceil( (bps - Offset[i])  / Period[i] ) * Period[i] ;  
	 	
	 		if (temp < nextidletime ){
	 			bpsid = i ;
	 			nextidletime = temp ; 
	 			}
	 		}
	 		
	 		bps = nextidletime ;
	 		bpe = nextidletime + Wcet[bpsid] ;
	 
	 	}while(bpe < hp );

	  	return hp ;
	 }


public long gcd(long m, long n)
   {
      while ((m > 0) && (n>0))
         if (m > n)
            m %= n;
         else
            n %= m;
      return m + n;
   } 

}
/****************** Working Module ***********************************
public long CheckTask( int taskid , boolean[] isSchedulable , double[] WorstCaseAnalysis , int cpuid  ) {
	 	int i , j , k ;
	 	long hp ;
	 	
	 	if(taskid == 0)	{
	 		isSchedulable[0] = true ;
	 		return Period[0] ;
	 	}
	 	
	 	long sat ,activations ; /* Shortest Activation Time */
/*	 	
	 	hp = CheckTask(taskid - 1 , isSchedulable,WorstCaseAnalysis , cpuid) ;
	 	sat = gcd(hp,Period[taskid]); 
	 	
	 	isSchedulable[taskid] = true ; 	
	 	
	 	hp = ( hp * Period[taskid]) / sat ;
	 	
	 	if ( getUtilization(taskid + 1 , cpuid) <  getRMBound(taskid + 1 ) ) { 
	 		WorstCaseAnalysis[taskid] = 0 ;
	 		return hp ;
	 		}
	 		
	 	
	  	int bpsid = 0 ;
	 	double bps = 0 , bpe , l ,nextidletime ; /**** Busy Period Starting and Busy Period Ending */
/*	 	
	 	for(i = 0 ; i <= taskid ; i++) 
	 		if ( Offset[i] > bps ){
	 			bps = Offset[i] ;
	 			bpsid = i ;
	 		}

		bpe = bps + Wcet[bpsid] ;

	 	do{
	 		do	{
	 			l = bpe ;
	 			bpe = bps ;	
	 			
	 			if ( (l - bps)  > 3 * Period[taskid] ){
	 				WorstCaseAnalysis[taskid] = 0 ;
	 				break ; }
	 			
	 			for( i = 0 ; i <= taskid ; i++)
					bpe += (  Math.ceil( (l - Offset[i])/Period[i]) - Math.ceil( (bps - Offset[i])/Period[i]) ) * Wcet[i] ;
			
	 		}while(bpe != l) ;
	 		
	 		if( WorstCaseAnalysis[taskid] < (bpe - bps) )
	 			WorstCaseAnalysis[taskid] = bpe - bps ; 
	 		
	 		activations = (long) (Math.ceil( (bpe - Offset[taskid])/Period[taskid]) - Math.ceil( (bps - Offset[taskid])/Period[taskid])) ;
	 		
	 	if( activations > 1 ){
	 		isSchedulable[taskid] = isSchedulable[taskid] && false ; 
	 	}
	 	
	 	bps  = bpe ;  
	 	nextidletime =  Offset[0] + Math.ceil( (bps - Offset[0]) / Period[0] ) * Period[0] ;	
//	 	nextidletime =  Offset[0] + Math.floor(  ( (bps - Offset[0]) / Period[0] )  + 1 )* Period[0] ;
	 	bpsid = 0 ;
	 	double  temp ;
	 	
	 	for(i = 1 ; i <= taskid ; i++) 	{
	 		temp =  Offset[i] +  Math.ceil( (bps - Offset[i])  / Period[i] ) * Period[i] ;  
	 	
	 		if (temp < nextidletime ){
	 			bpsid = i ;
	 			nextidletime = temp ; 
	 			}
	 		}
	 		
	 		bps = nextidletime ;
	 		bpe = nextidletime + Wcet[bpsid] ;
	 
	 	}while(bpe < hp );

	  	return hp ;
	 }
*/
