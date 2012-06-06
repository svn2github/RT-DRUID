/*
 * Created on Jun 21, 2004
 */
package com.eu.evidence.rtdruid.internal.modules.jscan.offset;


import java.text.DecimalFormat;
import java.util.SortedSet;
import java.util.TreeSet;

import com.eu.evidence.rtdruid.internal.modules.jscan.Schedulability;
import com.eu.evidence.rtdruid.internal.modules.jscan.common.RMSchedulability;
import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.abstractions.old.GenRes;
import com.eu.evidence.rtdruid.vartree.abstractions.old.TaskSet;



/**
 * OffsetDMSchedulabilityComplete class performs the Exact analysis on the Task
 * set scheduled usiing DM fixed priority order. Class implements
 * RMSchedulability cos it uses some functions of Sorting the task and assigning
 * the Ceilings to the resources.
 */


public class OffsetEDFSchedulabilityComplete extends Schedulability {
	
	protected int NumTasks;
	protected double TotalUtilization ;
	protected long Period[] ;
	protected double Wcet[];
	protected double Utilization[];
	protected double Blocking[];
	protected double Deadline[] ;
	protected double Offset[] ;
	protected boolean[] IsSchedulable ;
	
	private double WorstCaseBusyPeriod[] ;
	private double WorstCaseResponceTime[];
	private double CriticalActivation[];
	private double WcetSensitivity[];
	
	private boolean Schedulable[] ;
	private boolean Computed[] ; 
	
public OffsetEDFSchedulabilityComplete() 
{;}
protected void addSteps() {}

/**
* Override parent method: first set Task set and then set all arrays
*/
public void setTaskSet(TaskSet t) {
 	
	int totalcpus, i;
	super.setTaskSet(t);
	
	totalcpus = tasks.getPrefixNumber();
	Computed = new boolean[totalcpus];
	Schedulable = new boolean[totalcpus];
	
	for (i = 0; i < totalcpus; i++) {
		Computed[i] = false;
		Schedulable[i] = true;
	}
 }

public void compute(int cpuid)
	{
	if(!Computed[cpuid])	
		{
	if(!init(cpuid))	return;

	if( TotalUtilization >= 1 )	{
//			return ;
		}
		
	
		checkTask( NumTasks - 1, IsSchedulable,WorstCaseBusyPeriod,CriticalActivation,WorstCaseResponceTime,WcetSensitivity);
		int i ;
		Schedulable[cpuid] = true;
		for(i = 0 ; i < NumTasks ;i++){
			if(IsSchedulable[i] == false ) Schedulable[cpuid] = Schedulable[cpuid] && false ; 
		}
		storeData(cpuid); 
		Computed[cpuid] = true ;
		}
	}



public boolean isSchedulable(int cpuid)	{
	compute(cpuid);
	return Schedulable[cpuid] ;
}


/*******************************************************************/
/**************** For Testing **************************************/
/*******************************************************************/
public void setTestParameters(long p[] , double d[] , double[] b , double[] w , double[] o ){
		
		NumTasks = p.length ;
		Period = (long[])(p.clone());
		Wcet = (double[])(w.clone());
		Blocking = (double[])(b.clone());
		Deadline = (double[])(d.clone());
		Offset = (double[])(o.clone()); ;
	}



// Initializes the Data structure reading from the Tree 
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

	{	

//			compute Resource Ceiling and  Blocking times
			RMSchedulability tmpSched = new RMSchedulability();
			tmpSched.setTaskSet(tasks);
			tmpSched.setResourceSet(risorse);
			tasks.sortByPeriod();
			
			tmpSched.computeCeilings(cpuId);
			tmpSched.computeBlockingTimes(cpuId);
	}

		
		int iTask ;
/*		for (iTask = 0; iTask < tasks.getSize(cpuId); iTask++) {
			GenRes t = tasks.getItem(cpuId,iTask);
			System.out.println("Blocking Time " + t.getDouble("blocking") );
		}*/

		NumTasks = tasks.getSize(cpuId);
		Period = new long[NumTasks];
		Wcet = new double[NumTasks];
		Utilization = new double[NumTasks];
		Blocking = new double[NumTasks];
		Deadline = new double[NumTasks];
		Offset = new double[NumTasks] ;
		WorstCaseBusyPeriod = new double[NumTasks] ;
		IsSchedulable = new boolean[NumTasks] ;
		CriticalActivation = new double[NumTasks];
		WorstCaseResponceTime = new double[NumTasks] ;
		WcetSensitivity = new double[NumTasks];
		
		TotalUtilization = 0;
		
		for (iTask = 0; iTask < NumTasks; iTask++) {
			GenRes t = tasks.getItem(cpuId,iTask);
				
			if (t.existProperty("period") || t.getDouble("period") == 0.0) {
				Period[iTask] = (new Double( t.getDouble("period") * 1000 )).longValue();		
			} else {
				throw new IllegalArgumentException("Period argument should be set and should not be Zero");
			}
			
			Period[iTask] = (new Double( t.getDouble("period") * 1000 )).longValue();
			/* Deadlines are equal to periods, when not specified */
			
			
			if (t.existProperty("wcet")) {
				Wcet[iTask] = t.getProperty("wcet") == "" ? 0 : t.getDouble("wcet");
				Wcet[iTask] *= 1000 ;
			} else {
				throw new IllegalStateException("Worst Case Execution Time is not Present");

			}
			
			if (t.existProperty("deadline")) {
				Deadline[iTask] = t.getProperty("deadline") == "" ? t.getDouble("period") : t.getDouble("deadline");
				Deadline[iTask] *= 1000 ;
			} else {
				Deadline[iTask] = Period[iTask];
			}
			
			/* Blocking times set to zero when not specified */
			if (t.existProperty("blocking")) {
				Blocking[iTask] = t.getProperty("blocking") == "" ? 0 : t.getDouble("blocking");
				Blocking[iTask] *= 1000 ;
			} else {
				Blocking[iTask] = 0;
			}
			
			if ( t.existProperty("offset")) {
				Offset[iTask] = t.getProperty("offset") == "" ? 0 : t.getDouble("offset");
				Offset[iTask] *= 1000 ;
			}else
			{
				Offset[iTask] = 0 ;
			}
			
			/* Set utilization */
			Utilization[iTask] = Wcet[iTask] / Period[iTask];
			t.setProperty("utilization",Utilization[iTask]);
			
			TotalUtilization += Utilization[iTask];
			}
		if ( TotalUtilization == 0)
			throw new IllegalStateException("System is With Zero Utlization");
		return true;
	}





//Generates the Report     
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

	String rep = new String("Exact Schedulability Analysis : EDF with Offsets\n");
    
	DecimalFormat d = new DecimalFormat("##0.000");  
	if(TotalUtilization > 1){
		rep += "\nUtilization of the Task Set is greater than 1\nTotalUtilization = " + d.format(TotalUtilization) +"\n";  		
    }
    
    int i;
    rep +=  "\n\nFollowing Report Shows the Actual Parameters in the \nMilliseconds but Test is carried our in" ;
    rep +=  "MicroSeconds to improve the precison.\n";
    
    boolean sch = true ;
    
    for (i=0; i<tasks.getSize(cpuId);i++) {
        if( tasks.getItem(cpuId,i).getTempInt("schedulable") != 1 ){
        	sch = false ; 
        break ;
        }
    }
    
    if(sch)
    	rep += "\nTask Set is Schedulable \n\n";
    else
    	rep += "\nTask Set is not Schedulable \n\n" ;
    
    for (i=0; i<tasks.getSize(cpuId);i++) {
    	
      rep += "Task " + tasks.getItem(cpuId,i).getName() + "\t";
      
      if( tasks.getItem(cpuId,i).getTempInt("schedulable") == 1 ){
     	 rep += "SCHEDULABLE\n";
     	 }
      else{
     	rep += "NOT SCHEDULABLE     ....  ";
     	rep += "Critical Activation of Task at " + tasks.getItem(cpuId,i).getTempProperty("CriticalActivation") + "\n\n";
     }
      rep += "\tPeriod \t\t\t" + tasks.getItem(cpuId, i).getProperty("period")  + ":\n" ;
      rep += "\tWcet \t\t\t" + tasks.getItem(cpuId, i).getProperty("wcet")  + ":\n" ;
      rep += "\tOffset \t\t\t" + tasks.getItem(cpuId, i).getProperty("offset") + "\n";
      rep += "\tDeadline \t\t\t" + tasks.getItem(cpuId, i).getProperty("deadline") + "\n";
      
      rep += "\tUtilization \t\t\t" + d.format( tasks.getItem(cpuId, i).getDouble("utilization")) + "\n";
      
      rep += "\tBlocking Time\t\t\t" + tasks.getItem(cpuId, i).getProperty("blocking") + "\n";
      
//      rep += "\tWorst Case Busy Period \t\t" + tasks.getItem(cpuId, i).getTempProperty("WorstCaseBusyPeriod") ;
//      rep += "\n" ;
      
      rep += "\tWorst Case Response Time \t\t" + d.format(tasks.getItem(cpuId, i).getTempDouble("WorstCaseResponceTime")) ;
      rep += "\n" ;
      
//      if(sch) 
//    		rep += "\tCdelta\t\t" +tasks.getItem(cpuId, i).getTempProperty("WcetSensitivity"); 
//      else
      		rep += "\tCdelta\t\t ?? "  ;
		
      	rep += "\n" ;
      }
    
	rep += "--------------------------------------------------\n";
	System.out.print(rep);
    return rep ;
  }



public void checkTask(int taskid , boolean[] isSchedulable , double[] worstCaseBusyPeriod,  double[] criticalActivation ,double[] worstCaseResponceTime,double[] wcetSensitivity ) {
 
class event implements Comparable {
	    public double time;
	    public int taskid ;
	    
	    public event(int i , double v) {
			time =  v;
			taskid = i ;
	    }
	   
	    public boolean equals(event constr) {
			 return (constr.time == time);
	    }

	    public int compareTo(Object o) {
			double v;
			
			if (o instanceof Double) {	// "o" is a PlaneConstraint
				v = ((Double) o).doubleValue();
			} 
			else {
				v = ((event)o).time;
			}
			
			if (time < v)
				return -1;
			if (time > v)
				return 1;
			//if (b == valore)
			
			int i = ((event)o).taskid ;
			if(taskid < i)
				return -1 ;
			else 
				if(taskid > i)
					return 1 ;
				
			return 0;
	    }
	};


	
	int i ;
 	long hp = 0  ;
 	
 	double requirement[] = new double[this.NumTasks];
 	double resource,startduration = 0 , maxoffset ,currenttime;
 	SortedSet activations  ;
 	SortedSet deadlines ;
 	
 	activations = new TreeSet();
 	deadlines = new TreeSet();
 	
 	event temp,nextactivation ;
 	
 	for(i = 0 ; i < NumTasks ; i++){
 		isSchedulable[i] = true ;
 		criticalActivation[i] = -1 ;
 	}
 	
 	
 	maxoffset = Offset[0] ;
 	for(i = 1 ; i < NumTasks ; i++) 
 		if ( Offset[i] > maxoffset )
 			maxoffset = Offset[i] ;
// System.out.println("\nMax Offset :::" + maxoffset) ; 		
 	 	
 	hp = Period[0] ;
 	for(i = 1 ; i < NumTasks ; i++)
 		hp = ( hp * Period[i]) / gcd(hp,Period[i]);
 		
// System.out.println("\nHyper Period :::" + hp) ;		
 		
// Initialize the activations with the offset value ......
	for(i = 0 ; i < this.NumTasks ; i++)
 		activations.add(new event(i,this.Offset[i]));
 	
 	currenttime = 0.0 ;
 	
 	while(currenttime < (2 * hp + maxoffset)  ){
 		
 		nextactivation = (event) activations.first();
 		
 		resource = nextactivation.time - startduration;
 		currenttime = startduration ;
// 		System.out.println("\n" + currenttime + "\t Resource :: "+ resource	);
 	
 		while( !deadlines.isEmpty() ) {
 			
 //			System.out.println("\n" + currenttime + "\t Resource :: "+ resource	+ "\tWaiting to Complete :: " + deadlines.size()) ;
 			 			
 			if(resource <= 0.0)	break ;
 		
 			temp = (event) deadlines.first();
 			
			if (temp.time < currenttime ){
//			 	Dead line Miss
//				System.out.println("\nDeadline Miss1 ::  " + temp.taskid);
				isSchedulable[temp.taskid] =  false ;
				worstCaseResponceTime[temp.taskid] = Double.POSITIVE_INFINITY ;
				
				if(criticalActivation[temp.taskid] == -1) 
					criticalActivation[temp.taskid] = temp.time - Deadline[temp.taskid]; 
								
				deadlines.remove(temp);
			}
			
			else 
				
			if(requirement[temp.taskid] <= resource ) {
			// Dead line Meet Calculate Responce Time
				
				double possibleincrease = requirement[temp.taskid] ;
				
				if(currenttime + possibleincrease > temp.time){
					possibleincrease = temp.time - currenttime ;
					isSchedulable[temp.taskid] =  false ;
					worstCaseResponceTime[temp.taskid] = Double.POSITIVE_INFINITY ;
					
					if(criticalActivation[temp.taskid] == -1) 
						criticalActivation[temp.taskid] = temp.time - Deadline[temp.taskid];
//					
					System.out.println("\nDeadline Miss2 :: " + temp.taskid);
				}
				else
//					System.out.println("\nDeadline Met :: " + temp.taskid +"  at  " + currenttime);
				
				currenttime += possibleincrease ;
				resource -= possibleincrease ;
				double r = temp.time - Deadline[temp.taskid] ;
				
				if( currenttime - r > worstCaseResponceTime[temp.taskid])
					worstCaseResponceTime[temp.taskid] = currenttime - r  ;
				
				deadlines.remove(temp);
			}
			else if	(requirement[temp.taskid] >  resource){
			//	Deadline is not yet met
				double possibleincrease = resource ;
				
				if(currenttime + possibleincrease > temp.time){
					possibleincrease = temp.time - currenttime ;
					isSchedulable[temp.taskid] =  false ;
					worstCaseResponceTime[temp.taskid] = Double.POSITIVE_INFINITY ;
//					System.out.println("\nDeadline Miss3 :: " + temp.taskid);
					
					if(criticalActivation[temp.taskid] == -1) 
						criticalActivation[temp.taskid] = temp.time - Deadline[temp.taskid];
					
					deadlines.remove(temp) ;
				}
				else
//					System.out.println("\nDeadline not Still met :: " + temp.taskid);
				
				currenttime += possibleincrease;
				resource -= possibleincrease ;
				requirement[temp.taskid] -=  possibleincrease ;				
			}
		} 		
 		
 		if(deadlines.isEmpty())	{
// 			System.out.println("\nIdle Time at ::: " + currenttime + "\tAmount = " + (nextactivation.time - currenttime) );
 		}
 		
 		startduration = nextactivation.time ;
 		deadlines.add(new event(nextactivation.taskid, nextactivation.time + Deadline[nextactivation.taskid]));
 		activations.add(new event(nextactivation.taskid, nextactivation.time + Period[nextactivation.taskid])) ;
 		requirement[nextactivation.taskid] = Wcet[nextactivation.taskid];
		activations.remove(nextactivation);
//		System.out.println("\nCurrent Time :: " + currenttime );
 	}
}

// It stores the data on the Tree regarding the Scheduling of the Task set. 
public void storeData(int cpuId) {
	
	
	for (int i=0; i< tasks.getSize(cpuId); i++) {
		
		tasks.getItem(cpuId, i).setTempProperty("WorstCaseBusyPeriod",WorstCaseBusyPeriod[i]/1000);
		tasks.getItem(cpuId, i).setTempProperty("CriticalActivation",CriticalActivation[i]/1000 );
		tasks.getItem(cpuId, i).setTempProperty("WorstCaseResponceTime", WorstCaseResponceTime[i]/1000);
		tasks.getItem(cpuId, i).setTempProperty("WcetSensitivity",WcetSensitivity[i]/1000);
		tasks.getItem(cpuId,i).setTempProperty("CDelta", WcetSensitivity[i]);
		
//		In the Current Version the CDelta is not yet calculated.
		tasks.getItem(cpuId,i).setProperty("CDelta", "");

		
		if(IsSchedulable[i]){
			tasks.getItem(cpuId, i).setTempProperty("schedulable",1);
			tasks.getItem(cpuId, i).setProperty("schedulable","true");
		}
		else{
			tasks.getItem(cpuId, i).setTempProperty("schedulable",0);
			tasks.getItem(cpuId, i).setProperty("schedulable","false");
		}
			
		tasks.getItem(cpuId, i).setProperty("blocking", Blocking[i]/1000);
		tasks.getItem(cpuId, i).setProperty("utilization", Utilization[i]);
		tasks.getItem(cpuId, i).setProperty("ResponseTime", WorstCaseResponceTime[i]/1000);
		
	}
	setSave(true);
	
addCpuSched(tasks.getSystem(), DataPath.removeSlash(tasks.getPrefix(cpuId)), tasks.getMode(),
			new Double(TotalUtilization), null,null, 
			Schedulable[cpuId]);	
}


//new Double(getUtilization(tasks.getSize(cpuId), cpuId))


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
