package com.eu.evidence.rtdruid.internal.modules.jscan.offset;



import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Vector;

import com.eu.evidence.rtdruid.internal.modules.jscan.common.PlaneConstraint;
import com.eu.evidence.rtdruid.vartree.abstractions.old.Task;



// exceptions

/**
 * This class implements the Fixed Priority (either Rate Monotonic or
 * other fixed priority assignment) Analysis using the Hyperplanes
 * theory with consideration of the Offsets. This analysis may be applied i
 * n the following hypothesis:
 * <UL>
 * <LI>deadlines smaller than or equal to the periods;
 * <LI>presence of blocking time (possibly equal to zero), due to
 * critical sections;
 * <LI>generic fixed priority assignment possibly not RM;
 * <LI>Task has the initial offset;
 * </UL>
 * In the internal data structure of the object, tasks are ordered by
 * decreasing priority. <BR>An important restriction applies: <B>the
 * number of tasks must be smaller than the number of bits used to
 * represent an <CODE>int</CODE></B>, otherwise some, not tested,
 * misbehaviour may happen.<br>
 *<br>
 *For each task is required:
 *<ul>
 * <li>Period</li>
 * <li>DeadLine</li>
 * <li>Wcet</li>
 * <li>Offset</li>
 * <li>Utilization      (calculated)</li>
 * <li>schedulable      (calculated)</li>

 * <li>dline-utilization</li>
 * <li>priority         (calculated)</li>
 * <li>preemption level (calculated)</li>
 * <li>Blocking         (calculated)</li>
 * <li>List of reources with Wcet for each resource</li>
 *</u
 *For each resource is required:
 *<ul>
 * <li>ceiling          (calculated)</li>
 *</ul>
 *For the Hyperplane Analysis see following
 * @author  <A href="http://feanor.sssup.it/~bini/">Enrico Bini</A> 
 * @see <A href="http://feanor.sssup.it/~bini/papers/2002BinBut.html">The Space of Rate Monotonic Schedulability</A>
 */




public class OffsetSchedulabilityHyperplanesAnalysis extends OffSetSchedulability {
	
//	IsTaskSchedulable array contains the schedulability of the the each task. It may be true or false. 
	private boolean IsTaskSchedulable[] ;

//	WorstCaseAlalysis contains the Response Time of the Task Set.
	private double WorstCaseAnalysis[] ;

// MaxAllowedInc contains the Cdelta of each task. If cdelta is negetive ,then it indicates 
// that taskset is not schedulable but decreasing the Wcet task may be schedulable.
	private double MaxAllowedInc[] ;
	
//  constraints contains the all constraints for each task. If one of the constraint of task
//	is satisfied then task is schedulable.
	protected Vector constraints;
	
	protected double SensitivityPrecision ;
	protected void addSteps() {}
	
	public OffsetSchedulabilityHyperplanesAnalysis() {
		constraints = new Vector();
	}

	public void setSensitivityPrecision(double p){
		SensitivityPrecision = p;
	}
	
/* This function calculates the all Schedulability Points in the Task set. Schedulability points can
 	be defined as the points in the task set where the demand of all the previos instances should 
 	be satisfied. If at any of the point the demand is satisfied then task is schedulable. But if
 	demand is not satisfied at any of the point then task is not schedulable.
 */
	public void assignExistingPriorities() {
	
	}



/*
* This is function is same as before one but only change is in the W calculations which is based on the
* max instnace and min instances here in this module.
*/

public double[] WorkloadStarter(double Wmax, double Wmin, int iTask, int instance, double[] delta ,double[] Wcet){
// Find the WStar from where you will start the calculation of the W.
		double WStar,WStar1;
		int i, j, k ;
		WStar = Wmax ;
		WStar1 = Wmax ;
		double S; // , startW ,endW ;
		S = Offset[iTask] + (instance-1) * Period[iTask];

		double c ;
//		System.out.println("WS = " + WStar + "\tWS1  " + WStar1 + "\t\tS = " + S );
//		 Wmax should not be less than the Wmin
		if(Wmax < Wmin) return null ; 
						
		do{

			WStar = WStar1 ;
			WStar1 = 0 ;
			double temp ; //Wdelta
			for( i = 0 ; i <= iTask ; i++ ){
				temp = Math.ceil( (S-WStar-Offset[i]) / Period[i] ) ;
				c =  Math.ceil(( S - Offset[i]) / Period[i]) -  (temp > 0 ? temp : 0 );
//				System.out.println("C = " + c + "\t\tTemp = " + temp);
				if(c >  0)	
					WStar1 += c * Wcet[i] ;
				}
//			System.out.println("WS = " + WStar + "\tWS1  " + WStar1);
			if(WStar1 < Wmin){
				WStar = Wmin ;
				break ;
				}
		}while( WStar >  WStar1 );
		
		double W = 0 	, 	Wopt = 0 ;
		double I = 0 	, 	Imax = 0 ;
		int mininstance , maxinstance; // , totalinstances;
		double FirstInstanceAfterWStar = 0 , FirstInstanceAfterWmin = 0; 


//		System.out.println("\n\nFinal WS = " + WStar);
		for( i = 0 ; i <= iTask ; i++ ) {			
			
			if( S-WStar < Offset[i] )
				FirstInstanceAfterWStar = Offset[i];
			else
				FirstInstanceAfterWStar = Math.ceil(( S - WStar - Offset[i] )/Period[i]) * Period[i] + Offset[i] ;

//		System.out.println("FirstInstanceAfterWStar = " + FirstInstanceAfterWStar ) ;
			if( S-Wmin < Offset[i] )
				FirstInstanceAfterWmin = Offset[i];
			else
				FirstInstanceAfterWmin = Math.ceil( ( S - Wmin - Offset[i] ) / Period[i] ) * Period[i] + Offset[i]  ;
			
//			System.out.println("FirstInstanceAfterWmin = " + FirstInstanceAfterWmin ) ;
			
			mininstance =  (int) ((S + delta[i] - FirstInstanceAfterWmin) /Period[i] );
			maxinstance =  (int)( (S + delta[i] - FirstInstanceAfterWStar) /Period[i] );
			
//			System.out.println("Itask = " + i + "\tMaxInstance " + maxinstance + "\tMinInstance" + mininstance + "\t Delta" + delta[i]);		

			for( j = maxinstance ; j > mininstance ; j-- ) {

//	 		Here We are going to find the W which starts from the S
				W =  j * Period[i] - delta[i] ; 
				I = 0 ;
				for ( k = 0 ; k <= iTask  ;  k++ )
					I += Math.floor( ( W + delta[k] )/Period[k] ) * Wcet[k];

// Interference which will affect at the S.
				I = Math.max( 0, I -  W );
			
				if( I == Imax ) {
					if(W < Wopt)
						Wopt = W ;
				}
				if( I > Imax ) {
					Imax = I ;
					Wopt = W ;
				}		
// System.out.println("Instance ::  " + j + "\tWorkloadStarter " + W + "\tInterference " + I + "\tImax" + Imax);
			}
		}
		double[] result = { Wopt, Imax} ;
//		System.out.println("\tWorkloadStarter " + Wopt + "\tInterference " + Imax );
		return result ;
}



// Not Yet Tested ............................
// This workloadStarter finder doesn't take into consideration the starting offsets.
// Means it is useful to calculate the workload when task is in middle of the timeline. So
// there is no instance from start can contribute to this situation.

public double[] WorkloadStarter( double Wmax , double Wmin , int iTask , double[] delta ,double[] Wcet){

// Find the WStar from where you will start the calculation of the W.
		double WStar,WStar1;
		int i, j ;
		WStar = Wmax ;
		WStar1 = Wmin ;
 
		while( WStar  <=   WStar1 ){
			WStar = WStar1 ;
			WStar1 = 0 ;
			for(i = 0 ; i <= iTask  ;  i++)
				WStar1 += Math.floor( (delta[i] + WStar) / Period[i] ) * Wcet[i];
		}
		
		double W = 0 , Wopt = 0 ;
		double I = 0 , Imax = 0 ;
		int mininstance , maxinstance;
		
		
		for( i = 0 ; i <= iTask ; i++ ) {
			maxinstance =  (int)Math.floor((delta[i] + WStar)/Period[i]);
			mininstance =  (int)Math.floor((delta[i] + Wmin )/Period[i]);
			
			for(j = maxinstance ; j >= mininstance ; j++){
//	 Here We are going to find the W which starts from the S
				W =  Period[j] - delta[i] ; 
				I = 0 ;
				for ( i = 0 ; i < iTask  ;  i++ )
					I += Math.floor( (W + delta[i]) / Period[i] ) * Wcet[i];
// Interference which will affect at the S.
				
				I = Math.max( 0, I -  W );
				if( I > Imax){
					Imax = I ;
					Wopt = W ;
				}
			}
		}
		double[] result = { Wopt, I} ;
		return result ;
}





public boolean isSchedulableWithCurrentOffsets(int iTask , int instance , double[] rightInc , double rs[] , boolean GlobalFixedPonints){
		int i , j ;

//		For Each Task  .......   Data Structure *********************************		
		double[] modifiedWcet = (double[])(Wcet.clone());
		double[] maxInc = new double[this.NumTasks];
		double[] delta = new double[this.NumTasks];
		double oldWcet;
		double[] result ;
		double responsetime = Double.MAX_VALUE; 

		double WminCorrection = 0.000001;
		
		modifiedWcet[iTask] += Blocking[iTask];
		
//		Caculate the delta for each task from the given task instance ...
//		System.out.println("Task to Be Schedulable = " + iTask + "\tInstance = " + instance + "\n");
		
		double temp ;
		temp = Offset[iTask] + ( instance - 1 ) * Period[iTask] ;
		for(i = 0 ; i <= iTask ; i++ ){
			if(temp >Offset[i])
				delta[i] = Math.ceil ( (temp - Offset[i])/Period[i] ) * Period[i] - temp  + Offset[i];
			else
				delta[i] = Offset[i] - temp;
//		System.out.println( "Itask = " + i + "\tDelta" + delta[i]);
		}
		
				
		for( j = 0; j <= iTask; j++ )
			maxInc[j] = Double.NEGATIVE_INFINITY;
		
		
//		Variables Used For the Sensitivity
		boolean flag = false ;
		double remainingresource ;
		double S,K,WStartermax,WStartermin,Cdelta=0,WStarter,D,Cnew = 0,I,Ioriginal,WStarteroriginal;// ,Cdeltapast1= 0.001;//,Cdeltapast2 = 0.001;
		//Double tempinterference = null ;
		int N ;
		
		S = Offset[iTask] + ( instance - 1 ) * Period[iTask];
		
		WStartermax = S ;
		WStartermin = 0 ;
		
		
		result = WorkloadStarter(WStartermax,WStartermin,iTask,instance,delta, modifiedWcet);
		WStarteroriginal= result[0];
		Ioriginal = result[1];
//		System.out.println("\nInterference Got" + Ioriginal + "\tWorload" + WStarteroriginal +"\n");
		
		SortedSet constrSet = null ;
		Iterator iterOnCx = null ;
		
		if( GlobalFixedPonints ){
			constrSet = (SortedSet) constraints.get(iTask);
			iterOnCx = constrSet.iterator();
		}
		else {
			constrSet = new TreeSet();
			buildKeyPoints(iTask,instance,constrSet);
			iterOnCx = constrSet.iterator();
		}
		
//	System.out.println("\nTask  " + iTask + "  Total Schedulability Points = " + constrSet.size() );
		
		boolean responsetimefoundflag = false;
		
		
		while ( iterOnCx.hasNext() ) {
//  For Each Schedulability Point in the Task .... .... Data Structure *************************
			
			
			PlaneConstraint myCx ;
			myCx = (PlaneConstraint) iterOnCx.next();	
			K = myCx.b ;
			remainingresource = -myCx.planeDistance(modifiedWcet);
			
			//System.out.println("\nTask  " + iTask + "  Schedulability Point At  = " + (S + K) +"::::::::::::::::::::::::::::::::::::::::::::::\n");
			
			if ( remainingresource - Ioriginal >= 0 ){
					flag = flag || true ;  // Indicates that the task is schedulable
			}
					
			
			
			if( !responsetimefoundflag && (responsetime >  ( K - remainingresource + Ioriginal)) ) 
				responsetime =   K - remainingresource + Ioriginal;
			
			for (j = 0; j <= iTask; j++) {
				
					
				//	Limiting Condition1
				//	In the following situation we are going to check that first activation of the task
				//	is away from the (S+K). If YES then we check the schedulability. If the task 
				//  is schedulable at K then maxInc[j] is Positive infinity else it is negetive 
				//  infinity. 
				
				
				if( Offset[j]  >=  ( S + K )  ){
					if( remainingresource >= 0 ){
						maxInc[j] = Double.POSITIVE_INFINITY ;
					}
		
					continue ;
				}
				
				
				//	System.out.println("\nI am here");
				//	For Each Cdelta ...........    Data Structure *****************************************

				
				N = myCx.a[j];
				D = remainingresource +  modifiedWcet[j] * N ;
				oldWcet = modifiedWcet[j];
				
//				modifiedWcet[j] = this.getEDFBoundForWcet(j,iTask);
//  			Because if we keep the utilazation less than 1 to keep the system with some ideal times.
//				modifiedWcet[j] -= this.SensitivityPrecision ;  
							
				WStartermax = S ;
				WStartermin = 0 ;
				
				I = Ioriginal ;
				WStarter = WStarteroriginal ;
				boolean sensitivityExists = true ;
				
				while(  ( WStartermax - WStartermin ) > WminCorrection ) {
				
									
					if(N != 0 ){
						Cnew = ( D - I ) / N ;
						Cdelta = Cnew - modifiedWcet[j];
					}
					else{
						Cdelta = D - I ;
				
				//  	Limiting Condition 2 .. When any decrease in wcet of task j  can't make task i schedulable.
				//		In this case if Workload is starting after the last instance of task j from S and cdelta is negetive.
				// 		It indicates that any decrease in the Cj does not affect the Workload.
						if( Cdelta < 0 &&  WStarter < ( Period[j] - delta[j] )  ){
							modifiedWcet[j] = Double.NEGATIVE_INFINITY ;
						 	sensitivityExists = false ;
						 	break ;
						}
													
					}
					
					
					
				
		//System.out.println("Cold = " + (Cnew - Cdelta) + "\tCnew = " + Cnew + "\tCdelta = " + Cdelta ) ;
			//	Varification Routine which sees that current Cnew Plan is good or not or it is proper or not.
						double varificationcnew = 0 ,varificationwstarter; //, varificationcdelta = 0  ;  
						double NbeforeS = Math.floor( (WStarter + delta[j]) / Period[j] ) ;
						if(  ( NbeforeS + N )  !=  0 ) {
							varificationcnew  = ( D - I + NbeforeS * modifiedWcet[j] ) / ( N + NbeforeS);
							//varificationcdelta = varificationcnew - oldWcet ;
							
							double temp1 = modifiedWcet[j];
							modifiedWcet[j] = varificationcnew ;
							result = WorkloadStarter(WStartermax,WStartermin,iTask,instance,delta, modifiedWcet);
							varificationwstarter = result[0];
							modifiedWcet[j] = temp1;
							
							if( WStarter == varificationwstarter ){
								break ;
							}
						}
						
			
			// It very important to have the SensitivityPrecision because when we are unable to find the
			// WStarter from which we had a busy period. This situaion will occur when the task under schedulability
			// has very high period and task under sensitivity has very low period. 
			// This situation will also can occur if there is no instance of Task under sensitivity in
			// the schedulability region. 
			if ( Cdelta  >=  0  && Cdelta < SensitivityPrecision){
							break ;
				}
	
	
			
				modifiedWcet[j]  +=  Cdelta / 2 ;
										
					
/* To Optimize performance of the Workload finder  we need to modify WStartermin and WStartermax. WStartermin and WStartermax limits
 * the serach of activation from where workload is going to start. It is possible to modify WStartermin and WStartermax if WStarter is going
 * to converge in the    
 * 
 */ 

					
					if( Cdelta > 0 ){
						if( WStarter - WminCorrection >  0)
							WStartermin = WStarter - WminCorrection  ;
					}
					else
					WStartermax = WStarter ; 
//					System.out.println("WStartermax = "  + WStartermax + "\tWStartermin = "  + WStartermin + "\n") ;
//					System.out.println("------------------------------------------------------------------------");
					
						
					result = WorkloadStarter(WStartermax,WStartermin,iTask,instance,delta, modifiedWcet);
					WStarter = result[0];
					I = result[1];
					
					//Cdeltapast2 = Cdeltapast1 ;
					//Cdeltapast1 = Cdelta ;
					
				
				}
				
				double NbeforeS = Math.floor(  (WStarter + delta[j]) / Period[j] ) ;
				if( (NbeforeS + N ) != 0  && sensitivityExists ){
					Cnew  = ( D - I + NbeforeS * modifiedWcet[j] ) / ( N + NbeforeS) ;
					Cdelta = Cnew - oldWcet ;
//					System.out.println("Cdelta :: " + Cdelta );
					if ( Cdelta > maxInc[j] ){ 
						maxInc[j] = Cdelta ;
					}
				}			
				
				modifiedWcet[j] = oldWcet ;
			}
		}

		
		for(i = 0 ; i <= iTask ; i++ ){
			if (maxInc[i] < rightInc[i]) 
				rightInc[i] = maxInc[i];
//			System.out.println("Task ::: " + i + "\t"  + maxInc[i] );
		}
		


//		Response Time of the Task is indicated
//		if( rs[iTask] <  responsetime ) 
//			rs[iTask] = responsetime ;
//		System.out.println("I am here 3\n");
	return flag ;
}





public boolean isSchedulableWithCurrentOffsets( boolean isschedulable[] , double[] rightInc , double rs[] ){

// For Each Task Set  .......   Data Structure ********************************* 	

		int iTask; //, j ,i;
		boolean schedulable = true ;
		int FirstInstance  = 1 ;
				
		for (iTask = 0; iTask < NumTasks; iTask++){
			boolean temp ;
			temp = isSchedulableWithCurrentOffsets( iTask , FirstInstance , rightInc ,  rs ,true ) ;
			schedulable = schedulable && temp ; 
		}
		
		return schedulable ;
	}




/**	
 	 * Build the internal data structure of the object. For the
	 * details, please refer to the <A
	 * href="http://feanor.sssup.it/~bini/papers/2002BinBut.html">paper</A>.
	 * @param toBeSchedTask the task index, the whole
	 * <CODE>constrSet</CODE> belong to. It ranges from 0 to
	 * <CODE>NumTasksss</CODE>-1.
	 * @param tPoint the task must terminated not later than
	 * <CODE>tPoint</CODE>. It is the argument of the set
	 * <B>P</B><SUB>i</SUB>.
	 * @param iTask the higher priority task we are considering in the
	 * current execution.
	 * @param iPlane the index of the constraint/plane.
	 * @param constrSet the data structure containing all the
	 * constraints relative to the task <CODE>toBeSchedTask</CODE>.
*/



public void buildKeyPointsForFirstInstance(){
	int iTask ;
	constraints.clear();
		
	for (iTask = 0; iTask < NumTasks; iTask++) {
		SortedSet constrSet ;
		constrSet = new TreeSet();
		
		buildKeyPoints(iTask,1 ,constrSet) ;
		constraints.add(iTask, constrSet);
	}
}
	

public void buildKeyPoints(int iTask, long instance, SortedSet constrSet){
	
	buildKeyPoints(
			iTask,
			Offset[iTask] + (instance - 1 ) * Period[iTask] + Deadline[iTask],
			Offset[iTask] + (instance-1) * Period[iTask],
			iTask,
			iTask,
			constrSet);
}


private void buildKeyPoints(
		int toBeSchedTask,
		double tPoint,
		double StartOfSchedulabilityRegion,
		int iTask,
		int iPlane,
		SortedSet constrSet) {

		/* Safety check */
		
		if (tPoint > StartOfSchedulabilityRegion) {
			if (iTask == 0) {
//				System.out.println(toBeSchedTask + "\t" + tPoint );
				int[] coef = new int[toBeSchedTask + 1];
				coef[toBeSchedTask] = 1;
				//double delta ;
				for (int i = toBeSchedTask - 1; i >= 0; i--){
					coef[i] = (int) (Math.ceil((tPoint - Offset[i])/Period[i]) -  Math.ceil((StartOfSchedulabilityRegion - Offset[i])/Period[i]));
//					System.out.println("Coef[" + i + "]\t" + coef[i] );
				}
				// In this Plane 
				PlaneConstraint oneConstr =	new PlaneConstraint(tPoint - StartOfSchedulabilityRegion , coef , iPlane);
				constrSet.add(oneConstr);
			} 
			else {

				/* If the constrain is already present, dont branch */
				if (!constrSet.contains(new PlaneConstraint(tPoint))) {

					/* CORE */
					buildKeyPoints(
						toBeSchedTask,
						Math.floor( (tPoint - Offset[iTask-1]) / Period[iTask-1] ) * Period[iTask - 1] + Offset[iTask-1],
						StartOfSchedulabilityRegion,
						iTask - 1,
						iPlane << 1,
						constrSet);
					
					buildKeyPoints(
						toBeSchedTask,
						tPoint,
						StartOfSchedulabilityRegion,
						iTask - 1,
						iPlane << 1 | 1,
						constrSet);
				}
			}
		}
	}
	

	public String getReport(int cpuId) {
		int i ;
		
		final String SPAZI = "                              "; 
		
		
		if (tasks == null) {
			throw new IllegalStateException("Set a taskList before compute something!");
		}
		
		if (tasks.getPrefixNumber() <= cpuId) {
			throw new IndexOutOfBoundsException("Required a non-existent cpuId : max id =" + tasks.getPrefixNumber() + " , required id = " + cpuId);
		}
		
		if (tasks.getSize(cpuId) == 0) {
			return "Hyperplane Analysis:\n\tNo tasks\n";
		}

		if (risorse == null) {
			throw new IllegalStateException("Set a resourceList before compute something!");
		}
		
		if (risorse.getPrefixNumber() == 0) {
			throw new IllegalStateException("Set a not empty resourceList before compute something!");
		}

		
		String rep = new String("\nSufficient Sensitivity Analysis With Offset .. Fixed Priority \n");
		rep += "Using Response Time Calculation\n" ;
		
		DecimalFormat d = new DecimalFormat("##0.000");  
		DecimalFormat d1 = new DecimalFormat("000.00000");  
		
		if(TotalUtilization > 1) rep += "\nUtilization of the Task Set is greater than 1\nTotalUtilization =" + d.format(TotalUtilization) +"\n";

		if ( isSchedulable(cpuId) )
			rep += "\n\nTASK SET IS SCHEDULABLE WITH   " + F + "  Fixed Tasks\n "  ;
		else
			rep	+= "\n\nTASK SET IS NOT SCHEDULABLE WITH " + F + "Fixed Tasks.\nBut Task set may be schedulable with More Number of Tasks.  " ;
		
		
		rep += "\n\nGeneral results\n\n"
			+ "Schedulable : " +  ( isSchedulable(cpuId) ? "YES" : "NO") + "\n"
			+ "Speed factor: " + "?" + "\n" 
			+ "Load        : " + TotalUtilization + "\n"
			+ "\nSummary of results for each task:\n\n" 
			+ "TASK,              WCET, PERIOD, DEADLINE, PRIORITY, Resp. Time, CDELTA, Sched.\n";
			
		for (int j =0; j<tasks.getSize(cpuId); j++) {
			Task task = (Task) tasks.getItem(cpuId, j);
			String pad = task.getName().length() < 17 ? SPAZI.substring(0,17- task.getName().length()) : "";
			rep  +=   task.getName() + ", " + pad 
					+ task.getProperty("wcet") + ", "
					+ task.getProperty("period") + ", "
					+ task.getProperty("deadline") + ", "
					+ task.getProperty("priority") + ", "
					+ task.getProperty("cdelta") + ", "
					+ "??" + ", "
					+ task.getProperty("schedulable") ;
			rep += "\n" ;
		}
	
	rep  += "\n\nDetailed results\n\n" ;
		
		
		
		for (i=0; i<tasks.getSize(cpuId);i++) {
	        rep += "Task " + tasks.getItem(cpuId,i).getName() + " : ";
	        if	(tasks.getItem(cpuId, i).getTempInt("schedulable") == 1)
	       	 rep += "SCHEDULABLE\n";
	       else 
	         rep += "NOT SCHEDULABLE\n";
	        
	        rep += "\tPeriod: " + tasks.getItem(cpuId, i).getProperty("Period")  + "\n" ;
	        rep += "\tDeadline: " + tasks.getItem(cpuId, i).getProperty("Deadline") + "\n";
	        rep += "\tWcet " + tasks.getItem(cpuId, i).getProperty("Wcet")  + "\n" ;
	        rep += "\tOffset: " + tasks.getItem(cpuId, i).getProperty("offset") + "\n";
	         
	        rep += "\tUtilization \t\t\t" + d.format( tasks.getItem(cpuId, i).getDouble("utilization")) + "\n";
	        rep += "\tBlocking Time: " +tasks.getItem(cpuId, i).getProperty("blocking") + "\n";
			rep += "\tWorst Case Response Time :" + "??"   + "\n" ;
	        rep += "\tCDelta : " + d1.format(tasks.getItem(cpuId, i).getDouble("cdelta"));
	        rep += "\n\n" ;
	      }
//	    System.out.print(rep);
	    return rep;
	}


public void compute(int cpuid)	{
		if(!Computed[cpuid])	{
		
		if(!init(cpuid))	return;			
		Schedulable[cpuid] = isTaskSetSchedulable();
//		System.out.print("\n" + Schedulable[cpuid] ); 
		storedata(cpuid); 
		Computed[cpuid]= true ;
		}
	}



public boolean isSchedulable(int cpuid)	{
		compute(cpuid);
		return Schedulable[cpuid];
		}



public void storedata(int cpuId) {
		
		for (int i=0; i< tasks.getSize(cpuId); i++) {
				
			tasks.getItem(cpuId,i).setProperty("cdelta", MaxAllowedInc[i]/1000);			
			//System.out.println(MaxAllowedInc[i]/1000);
		}
				
		
	}



/*****     *****     *****     Checks Task set is schedulable or not on the Given CPU    *****     *****     *****/
public boolean isTaskSetSchedulable()
	{
		int i , temp;
		boolean schedulable = true;
		
		IsTaskSchedulable = new boolean[NumTasks];
		WorstCaseAnalysis = new double[NumTasks] ;
		MaxAllowedInc = new double[NumTasks];
		
		for( i = 0 ; i < NumTasks ; i++ ){
			IsTaskSchedulable[i] = true ;
			WorstCaseAnalysis[i] = 0.0 ;
			MaxAllowedInc[i] = Double.MAX_VALUE ;
		}
					
		initAnalysis();
		
			do{
				initInterference();
				temp = 0 ;
				do{
					shiftOffsets(temp);
					buildKeyPointsForFirstInstance() ;
					if(!isSchedulableWithCurrentOffsets(IsTaskSchedulable,MaxAllowedInc,WorstCaseAnalysis) )
					{	
//						System.out.println("\nNot Schedulable");
						schedulable = schedulable && false ;
					}
				else{
//					System.out.println("\nSchedulable");
					}
							
				} while(( temp = nextInterference()) != -1);
				
			} while( nextFixedTaskPermutation() );
		return schedulable ;
	}



public double getEDFBoundForWcet(int iTask ,int limit) {
	double e = 0 ;
	int i ;	
		for(i = 0 ; i <= limit ; i++) {
			e +=  Wcet[i] / Period[i];
		}		
		e -=  Wcet[iTask] / Period[iTask] ;
		e = 1 - e;
		
		e = e  * Period[iTask];
		return e;	 
	}



/*****     *****    *****     *****      Testing Function      *****      *****    *****     *****/
public void getResult(double[] maxwcet , double[] rs){
	int j ;
	for(j = 0 ; j < this.NumTasks ; j++) {
		System.out.println("Task :::: " + j + " \t" +  MaxAllowedInc[j] ) ;	
		maxwcet[j]	=  MaxAllowedInc[j];
		rs[j] = WorstCaseAnalysis[j];
		}
	}


}
