package com.eu.evidence.rtdruid.internal.modules.jscan.offset;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Vector;

import com.eu.evidence.rtdruid.internal.modules.jscan.Schedulability;
import com.eu.evidence.rtdruid.vartree.abstractions.old.GenRes;
import com.eu.evidence.rtdruid.vartree.abstractions.old.TaskSet;



/**
 * Computes Offset assignments.
 */


public class OffSetSchedulabilityAssignment extends Schedulability   
{
	protected int NumTasks;
	/**
	 * The total utilization of the task set.
	 */
	protected long Period[];
	/**
	 * The worst-case execution times of the tasks. Its length is
	 * <CODE>numTasks</CODE>.
	 */
	protected double Offset[] ;
	
	private boolean Computed[] ;
	
	Random rgenerator ;
	
public void setRandomSeed(int  d){
	rgenerator = new Random(d); 
}
	
public OffSetSchedulabilityAssignment(){
	rgenerator = null;
	}
protected void addSteps() {}

    /**
     * Override parent method: first set Task set and then set "computed" array
     */
    public void setTaskSet(TaskSet t) {
        super.setTaskSet(t);
        int i;
        int totalcpus = tasks.getPrefixNumber();
        Computed = new boolean[totalcpus];
        for (i = 0; i < totalcpus; i++) {
            Computed[i] = false;
        }
    }

public void compute(int cpuid)	{
	if(!Computed[cpuid] )	{
	
		if( !init(cpuid))	return;
		
		setDissimilarTaskOffsets(Period,NumTasks , Offset ) ;
		storeData(cpuid);
		Computed[cpuid] = true ;
	}
}


public boolean isSchedulable(int cpuid)	{
	compute(cpuid);
	return true;
}


public String getReport(int cpuId) {
	if (tasks == null) {
		throw new IllegalStateException("Set a taskList before compute something!");
	}
	if (tasks.getPrefixNumber() <= cpuId) {
		throw new IndexOutOfBoundsException("Required a non-existent cpuId : max id =" + tasks.getPrefixNumber() + " , required id = " + cpuId);
	}
	if (tasks.getSize(cpuId) == 0) {
		return "Offset Assignment:\n\tNo tasks\n";
	}

	if (risorse == null) {
		throw new IllegalStateException("Set a resourceList before compute something!");
	}
	if (risorse.getPrefixNumber() == 0) {
		throw new IllegalStateException("Set a not empty resourceList before compute something!");
	}


	String rep = new String("Offset Assignment\n");
	rep +=  "Task name\t|| Period\t||	 Offset\n\n" ;
	int i ;
	for (i=0; i< tasks.getSize(cpuId); i++) {
	    GenRes task = tasks.getItem(cpuId, i);
		rep +=  " " + task.getName()  + "\t||\t " + "\tPeriod " + task.getProperty("period") ; 
		rep += "\t||\tOffset " + task.getProperty("offset") + "\n";
	}
	
	rep += " \n\nCheck Shcedulability of the Task Set using the Feasible or Exaustive Techniques. \n" +
			"Be sure before using the Exaustive Technique" ;
	
	return rep ;
}


public void storeData(int cpuId) {
	for (int i=0; i< tasks.getSize(cpuId); i++) {
		
		// store offset % period
		GenRes t = tasks.getItem(cpuId, i);
		long per = Period[i];
		double offs = Offset[i];
		
		if (per !=0 && offs>per) {
			offs %= per;
		}
		
		t.setProperty("offset", offs/1000);
	}
	setSave(true);
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
		
		
		int iTask;
		
		NumTasks = tasks.getSize(cpuId);
		Period = new long[NumTasks];
		Offset = new double[NumTasks] ;

		
		for (iTask = 0; iTask < NumTasks; iTask++) {
			GenRes t = tasks.getItem(cpuId,iTask);
			Period[iTask] = (new Double( t.getDouble("period") * 1000 )).longValue();
			
			}
		return true;
	}


/************* This function makes offset assinged according to Goosens Algorithum *********************/

public void setDissimilarTaskOffsets(long[] P , int N , double offset[])
{
/* Class implements the Comparator which is the policy used for Sorting all task pairs in the array */	
class node implements Comparator {
		public int task1;
		public int task2;
		public int gcd ;
		
		public node(){ task1 = 0 ; task2 = 0 ; gcd = 0 ;} 
		
		public node(int t1 , int t2 , int g) {
			task1 = t1 ;
			task2 = t2 ;
			gcd = g ;
		}
		public int compare(Object o1 , Object o2) {
			node n1 = (node)(o1) ;
			node n2 = (node)(o2) ;
			if(n1.gcd > n2.gcd)
				return -1 ;
			else
				if(n1.gcd == n2.gcd)
					return 0 ;
				else 
					return 1 ;
			}
	};
	
/* This comparator policy sorts the task pairs in ascending order of periods when there gcds are same */
	
class periodcomparator implements Comparator {
		public long[] P ;
		public periodcomparator(long[] p)
		{
			P = p ;
		}
		
		public int compare(Object o1 , Object o2) {
			node n1 = (node)(o1) ;
			node n2 = (node)(o2) ;
			
			if(n1.gcd == n2.gcd)
				{
				if( P[n1.task1] <= P[n2.task1] &&  P[n1.task1] <= P[n2.task2] )
						return -1 ;
				else
					if( P[n1.task2] <= P[n2.task1] &&  P[n1.task2] <= P[n2.task2] )
						return -1 ;
					else
						return 1 ;
				}
			else
				return -1 ;
				}
		}

	boolean isoffsetassignedtotask[] ;
	node temp ;
	Object[] nodes ;
	int i , j , r  ;
	long hp ; 
	
	if(rgenerator == null)
		rgenerator = new Random();
	
	isoffsetassignedtotask = new boolean[N];
	Vector v = new Vector();
	
	for( i = 0 ; i < N ; i++) 
		isoffsetassignedtotask[i] = false ;
	
	
	for(i = 0 ; i < N -1 ; i++)
		for(j = i + 1 ; j < N ; j++)	{
		temp = new node(i,j,(int) gcd(P[i],P[j])) ;
		v.add(temp);
		}
	
	nodes = v.toArray() ;
	v = null ;
	
	
	Arrays.sort(nodes, (Comparator)nodes[0]) ;
	Arrays.sort(nodes, new periodcomparator(P));
	
	for( i = 0 ; i < nodes.length ; i++){
		temp = (node) nodes[i] ;
		System.out.println(P[temp.task1] + " " + P[temp.task2] + " " + temp.gcd) ;
	}

	
	hp = 1 ;
	
	for( i = 0 ; i < nodes.length ; i++) {
		temp = (node) nodes[i] ;
		if(!isoffsetassignedtotask[temp.task1])			
			if(!isoffsetassignedtotask[temp.task2])
			{
				// Offsets for both tasks are not assigned //
				hp = ( hp * P[temp.task1] ) / gcd(hp, P[temp.task1]);
				r = rgenerator.nextInt((int) hp);
				r = rgenerator.nextInt((int)(P[temp.task1])); // Random Value //
//				r = rgenerator.nextInt((int) hp);
				
				offset[temp.task1] = r ;
				offset[temp.task2] =  r +  (temp.gcd + 0.0) / 2 ;
				System.out.println("Assignment " + P[temp.task1] + " " + offset[temp.task1]) ;
				System.out.println("Assignment " + P[temp.task2] + " " + offset[temp.task2]) ;
				isoffsetassignedtotask[temp.task1] = true ;
				isoffsetassignedtotask[temp.task2] = true ;
			}
			else
			{	// Offset for first task is not assigned but second task is assigned //
				offset[temp.task1] =  offset[temp.task2] + ( temp.gcd + 0.0) / 2 ;
				isoffsetassignedtotask[temp.task1] = true ;
				System.out.println("Assignment " + P[temp.task1] + " " + offset[temp.task1]) ;
			}
		else
			if(!isoffsetassignedtotask[temp.task2])
			{
				// Offsets for first task is assigned but offset for second task is not assigned //
				
				offset[temp.task2] =  offset[temp.task1] + ( temp.gcd + 0.0 )/ 2 ;
				isoffsetassignedtotask[temp.task2] = true ;
				System.out.println("Assignment " + P[temp.task2] + " " + offset[temp.task2]) ;
			}
			else
			{	
				// Offset for both tasks are assigned //
			}
	}
	nodes = null ;
}

/* Euclidean method to Find GCD of the Number */	

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
