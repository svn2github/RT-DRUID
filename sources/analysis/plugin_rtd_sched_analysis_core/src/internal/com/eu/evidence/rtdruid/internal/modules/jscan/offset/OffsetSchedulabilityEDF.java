/*
 * Created on Jun 15, 2004
 */
package com.eu.evidence.rtdruid.internal.modules.jscan.offset;



import java.text.DecimalFormat;

import com.eu.evidence.rtdruid.internal.modules.jscan.common.RMSchedulability;
import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.abstractions.old.GenRes;


/**
 * 
 * This class implements the OffsetScheduler Interface. OffsetScheduler
 * interface contains the method which checks the current task set with offset
 * configuration is schedulable or not and make some worst case analysis
 * 
 * @author sachin
 */

public class OffsetSchedulabilityEDF extends OffSetSchedulability {

	private boolean IsTaskSchedulable[];
	private double WorstCaseAnalysis[] ;

	public OffsetSchedulabilityEDF()
		{ ; 
		}

	protected void addSteps() {}
	
public boolean init(int cpuId) {
			super.init(cpuId);
							
				RMSchedulability tmpSched = new RMSchedulability();
				tmpSched.setTaskSet(tasks);
				tmpSched.setResourceSet(risorse);
	 
				tasks.sortByDeadline() ;
				tmpSched.computeCeilings(cpuId);
				tmpSched.computeBlockingTimes(cpuId);
				
				int iTask ;
				for (iTask = 0; iTask < NumTasks; iTask++) {
				GenRes t = tasks.getItem(cpuId,iTask);

				/* Blocking times set to zero when not specified */
				if (t.existProperty("blocking")) {
					Blocking[iTask] = t.getProperty("blocking") == "" ? 0 : t.getDouble("blocking");
					Blocking[iTask] *= 1000 ;
				} else {
					Blocking[iTask] = 0.0;
				}
			}			
			return true;
	}

	
	
	
	public String getReport(int cpuId) {
		int i ;
		if (tasks == null) {
			throw new IllegalStateException("Set a taskList before compute something!");
		}
		if (tasks.getPrefixNumber() <= cpuId) {
			throw new IndexOutOfBoundsException("Required a non-existent cpuId : max id =" + tasks.getPrefixNumber() + " , required id = " + cpuId);
		}
		if (tasks.getSize(cpuId) == 0) {
			return "Offset Analysis:\n\tNo tasks\n";
		}

		if (risorse == null) {
			throw new IllegalStateException("Set a resourceList before compute something!");
		}
		if (risorse.getPrefixNumber() == 0) {
			throw new IllegalStateException("Set a not empty resourceList before compute something!");
		}

		String rep = new String("\nSufficient Feasibility Analysis With Offset .. EDF\n");

		DecimalFormat d = new DecimalFormat("##0.000");  
		if(TotalUtilization > 1)
			rep += "\nUtilization of the Task Set is greater than 1\nTotalUtilization = " + d.format(TotalUtilization) +"\n";
		
		if ( isSchedulable(cpuId) )
			rep += "\n\nTask Set is Schedulable With   " + F + "  Fixed Tasks\n "  ;
		else
			rep	+= "\n\nTask Set Is Not Schedulable With " + F + "Fixed Tasks. \nBut Task set may be schedulable \n with More Number of Tasks.  " ;
		rep += "\n\nTask Summary ------------------------------------------------\n";
		
		
	    for (i=0; i<tasks.getSize(cpuId);i++) {
	        rep += "Task " + tasks.getItem(cpuId,i).getName() + " : ";
	        if	(tasks.getItem(cpuId, i).getTempInt("schedulable") == 1)
	       	 rep += "SCHEDULABLE\n";
	       else 
	         rep += "NOT SCHEDULABLE\n";
	        
	        
	        rep += "\tPeriod: " + tasks.getItem(cpuId, i).getProperty("period")  + "\n" ;
	        rep += "\tDeadline: " + tasks.getItem(cpuId, i).getProperty("deadline") + "\n";
	        rep += "\tWcet " + tasks.getItem(cpuId, i).getProperty("wcet")  + "\n" ;
	        rep += "\tOffset: " + tasks.getItem(cpuId, i).getProperty("offset") + "\n";
	        
	        rep += "\tUtilization \t\t\t" + d.format( tasks.getItem(cpuId, i).getDouble("utilization")) + "\n";

	        
	        rep += "\tBlocking Time: " +tasks.getItem(cpuId, i).getProperty("blocking") + "\n";
//	        rep += "\tWorst Case Analysis :" + tasks.getItem(cpuId, i).getTempProperty("WorstCaseAnalysis")   + "\n\n" ;
	        rep += "\tWorst Case Response Time: ?? \n" ;
	        rep += "\tCDelta : ??";
	        rep += "\n\n" ;
	      }
	    
//	    System.out.print(rep);
	    
	    return rep;
	}


	public void compute(int cpuid)	{
		if(!Computed[cpuid])	{
		
		if(!init(cpuid))	return;		
		
		Schedulable[cpuid] = isTaskSetSchedulable();
		System.out.print("\n" + Schedulable[cpuid] ); 
		storeData(cpuid); 
		Computed[cpuid]= true ;
		}
	}


	public boolean isSchedulable(int cpuid)	{
		compute(cpuid);
		return Schedulable[cpuid];
		}


	public void storeData(int cpuId) {
		
		for (int i=0; i< tasks.getSize(cpuId); i++) {
			tasks.getItem(cpuId, i).setProperty("utilization", Utilization[i]);
			tasks.getItem(cpuId, i).setTempProperty("schedulable", IsTaskSchedulable[i] ? 1 : 0 );
			tasks.getItem(cpuId, i).setTempProperty("WorstCaseAnalysis",WorstCaseAnalysis[i]);

			if(IsTaskSchedulable[i]){
				tasks.getItem(cpuId, i).setProperty("schedulable","true");
			}
			else{
				tasks.getItem(cpuId, i).setProperty("schedulable","false");
			}		

//		In the Current Version the CDelta is not yet calculated.

			tasks.getItem(cpuId, i).setProperty("ResponseTime", "");
			tasks.getItem(cpuId,i).setProperty("CDelta", "");
					
		//		rtdruid.desk.Messages.sendDebug(tasks.getItem(cpuId,i).toString());
		
		}
		
		addCpuSched(tasks.getSystem(), DataPath.removeSlash(tasks.getPrefix(cpuId)), tasks.getMode(),
				new Double(TotalUtilization), null,
				null, 
				Schedulable[cpuId]);
	}

	/******* Checks Task set is schedulable or not on the Given CPU ***************/
	public boolean isTaskSetSchedulable()
	{
		int i , temp;
		boolean schedulable = true;
		
		IsTaskSchedulable = new boolean[NumTasks];
		WorstCaseAnalysis = new double[NumTasks] ;
		
		for(i = 0 ; i < NumTasks ; i++){
			IsTaskSchedulable[i] = true ;
			WorstCaseAnalysis[i] = 0.0 ;
		}
		
		initAnalysis();
		
		if (TotalUtilization > 1 ){
//			return false ;		
		}
		
				do{
				initInterference();
				temp = 0 ;
				do{
					shiftOffsets(temp);
//					System.out.print("\nFixed Tasks ::: ");
					
//					for( i = 0 ; i < F ; i++)	System.out.print(" " + FixedTask[i] ) ;
					
					if(!isSchedulableWithCurrentOffsets(FixedTask[0],Offset,IsTaskSchedulable,WorstCaseAnalysis)  )	{	
						System.out.println("\nNot Schedulable");
						schedulable = schedulable && false ;
					}
					else
						System.out.println("\nSchedulable");
						
				} while(( temp = nextInterference()) != -1);
				
			} while( nextFixedTaskPermutation() );
		return schedulable ;
	}


	
     /**
     * Checks the current task set is schedulable or not by given offsets using
     * EDF, for first busy period
     */
    public boolean isSchedulableWithCurrentOffsets(int busyperiodstarter,final double Offset[], boolean[] IsTaskSchedulable,
            double[] worstcasebusyperiods)   {
        
        double l = 0, demand;
        double absolutedeadline;
        int i;
        double firstbusyperiod;
        boolean schedulable = true;

 /*       for (i = 0; i < NumTasks; i++) {
            l +=  Wcet[i];
        }
*/
 
        l = Wcet[busyperiodstarter] ;
        firstbusyperiod = idleTimeFromWithGivenOffset(l, Offset);
        
/*        if( firstbusyperiod == Double.POSITIVE_INFINITY ){
            if (worstcasebusyperiods != null)
            		worstcasebusyperiods[busyperiodstarter] = Double.POSITIVE_INFINITY ;
        	return false ;
        }
*/        	
        if (worstcasebusyperiods != null)
            if (worstcasebusyperiods[busyperiodstarter] < firstbusyperiod)
                worstcasebusyperiods[busyperiodstarter] = firstbusyperiod;


        //			System.out.print("\n Total Tasks " +  getTotalTasks()) ;
        //			System.out.print("L = " + l) ;
        //			System.out.print("\n Offsets ::");
        //			for(i = 0 ; i < Offset.length ; i++)
        //				System.out.print(Offset[i] + " " );
        //			System.out.print("\nFirst Busy Period ::" + firstbusyperiod);


		boolean checkblocking = true ;  
        double currentblocking = 0 ;
        
        for (i = 0; i <  NumTasks; i++) {
        	checkblocking = true ;
            
            for (absolutedeadline = Offset[i] +  Deadline[i];
            		absolutedeadline < firstbusyperiod;
            		absolutedeadline +=  Period[i]) {
            	
         demand = demandFunctionWithGivenOffset(0, absolutedeadline,Offset);
       
       //   Consider the Blocking Time while the calculation of Busy Period.
            if(checkblocking){
            	int j ;
            	for (j = 0; j < NumTasks; j++)
            		if ( Deadline[i] >= absolutedeadline ){
            			currentblocking = Blocking[j] ;
            			break ;
              	}
            	if(j == NumTasks) {
            		currentblocking = 0 ;
            		checkblocking = false ;
            	}
            	
            }
            
        demand += currentblocking ; 
              
		//	System.out.println("DeadLine = " + absolutedeadline + "  Demand =" + demand);

           if ( demand > absolutedeadline) {
                if(IsTaskSchedulable != null)
                  	IsTaskSchedulable[i] = IsTaskSchedulable[i] && false;
           		
           		schedulable = schedulable && false;
                return false;

                }
		//	System.out.println("Demand =" + demand +"\n");
            }
        }
        return schedulable;
    }

    /*
     * This Function Calcuate First deadline from the given instance where CPU
     * is idle.
     */

    public double idleTimeFromWithGivenOffset(double start, double[] Offset) {
        double l1, l ,temp;
        
       
		int i;
        l1 = start ;
        
        do{
            l = l1;
            l1 = 0.0;
            
            for (i = 0; i < NumTasks; i++){
//            	l1 += Math.floor (  ( l - Offset[i] + Deadline[i] ) / Period[i]) * Wcet[i];           	
            	temp = Math.ceil (( l - Offset[i] ) / Period[i])   ;
            if(temp > 0)            
                l1 += temp * Wcet[i];
                    	
            }

             
        } while (l != l1);
        
	System.out.println("Idle  " + l );
        
        return l;
    }

    
    /** Calculate the Demand of the Task set between instance t1 and instance t2 */
    public double demandFunctionWithGivenOffset(double t1, double t2,
            double[] Offset) {
        double demand = 0, m;
        int i;
        for (i = 0; i < NumTasks; i++) {

            m = Math.floor((t2 - Deadline[i])/Period[i] ) 
			  - Math.ceil((t1 - Offset[i]) / Period[i]) + 1;
            
            demand += m * Wcet[i];
        }
        System.out.println("Demand : " + demand) ;
        return demand;
    }
}