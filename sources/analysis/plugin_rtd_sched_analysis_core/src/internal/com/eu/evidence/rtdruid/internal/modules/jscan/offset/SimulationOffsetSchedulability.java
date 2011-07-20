/*
 * Created on Jun 23, 2004
 */
package com.eu.evidence.rtdruid.internal.modules.jscan.offset;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * @author sachin
 */

public class SimulationOffsetSchedulability {
	public static void main(String[] argv) {
		int N = 5 , i ;
		
		double[] deadline = new double[N] ;
		double[] wcet = new double[N] ;
		long [] period = new long[N] ;
		double[] offset = new double[N] ;
		double[] blocking = new double[N] ;
		
		FileInputStream f = null  ;
		DataInputStream d  = null ;
		PrintWriter p  = null ;
		FileOutputStream  outputfile = null ;
		
		
		 
//		OffSetSchedulabilityAssignment oa = new OffSetSchedulabilityAssignment();
//		OffsetDMSchedulabilityComplete dms = new OffsetDMSchedulabilityComplete();

		try{
			
		f = new FileInputStream("/home/sachin/work/new/rtdruid/src/rtdruid_base/src/rtdruid/modules/jscan/Offset/test.txt");
		d = new DataInputStream(f);
		
//		/home/sachin/work/new/rtdruid/src/rtdruid_base/src/rtdruid/modules/jscan/Offset/testout.txt
		
		outputfile = new FileOutputStream("/home/sachin/work/new/rtdruid/src/rtdruid_base/src/rtdruid/modules/jscan/Offset/testout.txt") ; 
		p = new PrintWriter(outputfile);
		
	int testcount = 0 ;

	do{
			p.print("\n Test Case ::: " + testcount++ +"\n" );
			for( i = 0 ; i < N ; i++){
				wcet[i] = d.readInt() ;
				p.print(wcet[i] +"\t" ) ;
				d.readChar();
				
				deadline[i] = d.readInt() ;
				p.print(deadline[i] +"\t" ) ;
				d.readChar();
				
				period[i] = d.readInt() ; 
				p.print(period[i] +"\t" ) ;
				d.readChar();	
							
				offset[i] = d.readInt();
				d.readChar();
				p.print(offset[i] +"\t" ) ;
				
				blocking[i] = 0 ;
				}
			
			d.readChar();	
			d.readChar();
			d.readChar();
	/*********  Put Fixed Task Test ............. **********/
			
/*			p.println("\n\n Exact Test For Original Task Set..................\n\n") ;
			dms.init(period,wcet,blocking,wcet,offset);
			dms.checkTask(N - 1 , 0);
			p.println(dms.getTestReport(0));
			
			for(i = 0 ; i < N ; i++)	offset[i] = 0;
			
			p.println("\n\n Exact Test For Original Task Set with No Offsets.............. \n\n") ;
			dms.init(period,wcet,blocking,wcet,offset);
			dms.checkTask(N - 1 , 0);
			p.println(dms.getTestReport(0));
			
			
			p.println("\n\nNew Offset Assignments ....................\n\n");
			oa.setDissimilarTaskOffsets(period,N,offset);
			
			
			String rep = new String();
			rep +=  "Task id\t|| Period\t||	 Offset\n\n" ;
	
			for (i=0; i < N; i++) {
				rep +=  " " + i  + "\t||\t " + period[i] + "\t||\t" + offset[i]  + "\n";
			}
			p.println(rep) ;
			
			
			for ( i = 1 ; i <= 3 ; i++) {
				p.println("\n\nSufficient Test For New Task Set with " + i + "  Fixed Task............... \n") ;
				rsoffset.initTest( period ,deadline,blocking,wcet,offset);
				rsoffset.setTotalFixedTask(i) ;
				p.println(rsoffset.getTestReport(0));
				
				if(rsoffset.isTaskSetSchedulable(0)) {
					break ;
				}
			}
			
			p.println("\n\n Exact Test For Newly Gnerated Task Set.......................\n\n") ;
			dms.init(period,wcet,blocking,wcet,offset);
			dms.checkTask(N - 1 , 0);
			p.println(dms.getTestReport(0));
*/				
		}while(testcount < 10);
		
		p.close() ;
		d.close() ;
		outputfile.close();
		f.close();
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	System.out.println("File Not Found" + e.getLocalizedMessage() + e.getMessage()) ;
	}
	
	}
		
}
