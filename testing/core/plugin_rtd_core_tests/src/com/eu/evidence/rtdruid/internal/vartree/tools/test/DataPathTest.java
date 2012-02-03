/*
 * Created on 29-mar-2004
 *
 * $Id: DataPathTest.java,v 1.1 2005/09/28 15:22:29 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.vartree.tools.test;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.eu.evidence.rtdruid.vartree.data.init.DataPath;

/**
 *  @author  Nicola Serreli
 */
public class DataPathTest extends TestCase {
	final static char P = DataPath.PROTECTOR;
	final static char S = DataPath.SEPARATOR;

	final static String PP = "" + P + P;
	final static String PS = "" + P + S;
	final static String D = " " + S + " ";
	final static String NULL_ID = DataPath.NULL_ID;
	

	/**
	 * Constructor for UtilityTest.
	 * @param arg0
	 */
	public DataPathTest(String arg0) {
		super(arg0);
	}

	public static Test suite() {
		return new TestSuite(DataPathTest.class) ;
	}

	/**
	 * Test for String makeId(String)
	 */
	public void testMakeIdString() {
		assertTrue( NULL_ID.equals(DataPath.makeId( (String) null )) );
		
		assertTrue( ("ciao").equals(DataPath.makeId( "ciao" )) );
		assertTrue( ("ciao" + PS+ "abc").equals(DataPath.makeId( "ciao" + S + "abc" )) );
		assertTrue( ("" +PS+ "ciao" + PS + "abc" +PP).equals(DataPath.makeId( "" +S+ "ciao" + S + "abc" +P)) );
	}

	/*
	 * Test for String makeId(String[])
	 */
	public void testMakeIdStringArray() {
		boolean ok = false;
		try {
			assertTrue( (""+ P).equals(DataPath.makeId( (String[]) null )) );
		} catch (NullPointerException e) { ok = true; } assertTrue(ok);
		
		{ 
			String[] tmp = { null };
			assertTrue( NULL_ID.equals(DataPath.makeId( tmp )) );
		}
		{ 
			String[] tmp = { null, null };
			assertTrue( (NULL_ID + D + NULL_ID).equals(DataPath.makeId( tmp )) );
		}
		{ 
			String[] tmp = { null, "Ciao", null };
			assertTrue( (NULL_ID + D + "Ciao" + D + NULL_ID).equals(DataPath.makeId( tmp )) );
		}
		{ 
			String[] tmp = { "a"+S+"b", ""+S+"Ciao"+S+S+P+P, "m"+P };
			assertTrue( ( ("a" +PS + "b")+ D + (""+PS+"Ciao"+PS+PS+PP+PP) + D + ( "m" + PP ) ).equals(DataPath.makeId( tmp )) );
		}
	}

	/*
	 * Test for String makeSlashedId(String)
	 */
	public void testMakeSlashedIdString() {
		assertTrue( (DataPath.addSlash(NULL_ID)).equals(DataPath.makeSlashedId( (String) null )) );
		
		assertTrue( ("ciao").equals(DataPath.makeSlashedId( "ciao" )) );
		assertTrue( ("ciao" +PP+ PS+ "abc").equals(DataPath.makeSlashedId( "ciao" + S + "abc" )) );
		assertTrue( ("" +PP+PS+ "ciao" + PP+PS + "abc" +PP+PP).equals(DataPath.makeSlashedId( "" +S+ "ciao" + S + "abc" +P)) );
	}


	/*
	 * Test for String makeSlashedId(String[])
	 */
	public void testMakeSlashedIdStringArray() {
		boolean ok = false;
		try {
			assertTrue( (""+ PP).equals(DataPath.makeId( (String[]) null )) );
		} catch (NullPointerException e) { ok = true; } assertTrue(ok);
		
		String slashedNullId = DataPath.addSlash(NULL_ID);
		{ 
			String[] tmp = { null };
			assertTrue( (slashedNullId).equals(DataPath.makeSlashedId( tmp )) );
		}
		{ 
			String[] tmp = { null, null };
			assertTrue( DataPath.addSlash(NULL_ID + D + NULL_ID).equals(DataPath.makeSlashedId( tmp )) );
		}
		{ 
			String[] tmp = { null, "Ciao", null };
			assertTrue( DataPath.addSlash(NULL_ID + D + "Ciao" + D + NULL_ID).equals(DataPath.makeSlashedId( tmp )) );
		}
		{ 
			String[] tmp = { "a"+S+"b", ""+S+"Ciao"+S+S+P+P, "m"+P };
			assertTrue( DataPath.addSlash( ("a" +PS + "b")
						+ D + (""+PS+"Ciao"+PS+PS+PP+PP)
						+ D + ( "m" + PP ) ).equals(DataPath.makeSlashedId( tmp )) );
		}
	}

	/*
	 * 
	 */
	public void testResolveId() {
		// makeId(String)	
		{ 
			String[] tmp = { null };
			assertTrue( equlArrays(tmp, DataPath.resolveId(DataPath.makeId((String) null ))) );
		}
		{ 
			String[] tmp = { null };
			assertTrue( equlArrays(tmp, DataPath.resolveId(DataPath.makeId((String) null ))) );
		}
		{
			String[] tmp = { "ciao" };
			assertTrue( equlArrays(tmp, DataPath.resolveId(DataPath.makeId("ciao" ))) );
		}
		{
			String[] tmp = {"ciao" + S + "abc"};
			assertTrue( equlArrays(tmp, DataPath.resolveId(DataPath.makeId("ciao" + S + "abc" ))) );
		}
		{
			String[] tmp = {"" +S+ "ciao" + S + "abc" +P};
			assertTrue( equlArrays(tmp, DataPath.resolveId(DataPath.makeId("" +S+ "ciao" + S + "abc" +P ))) );
		}
		
		{ // print a warning but work
			String[] tmp = { null };
			assertTrue( equlArrays(tmp, DataPath.resolveId(null)) );
		}
		{ // the correct way
			String[] tmp = { null };
			assertTrue( equlArrays(tmp, DataPath.resolveId(NULL_ID)) );
		}
		
		// makeId(String[])
		{ 
			String[] tmp = { null };
			assertTrue( equlArrays(tmp, DataPath.resolveId(DataPath.makeId(tmp))) );
		}
		{ 
			String[] tmp = { "a", "b" };
			assertTrue( equlArrays(tmp, DataPath.resolveId(DataPath.makeId(tmp))) );
		}
		{ 
			String[] tmp = { null, null };
			assertTrue( equlArrays(tmp, DataPath.resolveId(DataPath.makeId(tmp))) );
		}
		{ 
			String[] tmp = { null, "Ciao", null };
			assertTrue( equlArrays(tmp, DataPath.resolveId(DataPath.makeId(tmp))) );
		}
		{ 
			String[] tmp = { "a"+S+"b", ""+S+"Ciao"+S+S+P+P, "m"+P };
			assertTrue( equlArrays(tmp, DataPath.resolveId(DataPath.makeId(tmp))) );
		}
	}
	
	private boolean equlArrays(String[] a, String[] b) {
		if (a == b) return true; // stesso oggetto oppure entrambi nulli

		if ( a != null && b != null) { // entrambi non nulli
			if (a.length != b.length) return false; // dimensioni diverse
			
			for (int i =0; i<a.length; i++) {
				if (a[i] == b[i]) continue; // stesso elemento o entrambi nulli
				
				if (a[i] == null) return false; // a e' nullo ma b non lo e' (avrebbe dato vero l'if precedente
				
				if (!a[i].equals(b[i])) return false; // trovato un elemento diverso   
				
				// prossimo elemento
			}
			return true;
		}
		// uno dei due e' nullo e l'altro no 
		return false;
	}

}
