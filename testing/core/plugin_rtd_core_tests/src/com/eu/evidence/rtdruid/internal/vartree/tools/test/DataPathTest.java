/*
 * Created on 29-mar-2004
 *
 * $Id: DataPathTest.java,v 1.1 2005/09/28 15:22:29 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.vartree.tools.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.eu.evidence.rtdruid.tests.RtdAssert;
import com.eu.evidence.rtdruid.vartree.DataPath;

/**
 *  @author  Nicola Serreli
 */
public class DataPathTest {
	final static char P = DataPath.PROTECTOR;
	final static char S = DataPath.SEPARATOR;

	final static String PP = "" + P + P;
	final static String PS = "" + P + S;
	final static String D = " " + S + " ";
	final static String NULL_ID = DataPath.NULL_ID;
	


	/**
	 * Test for String makeId(String)
	 */
	@Test
	public void testMakeIdString() {
		assertEquals( NULL_ID, DataPath.makeId( (String) null ) );
		
		assertEquals( ("ciao"), DataPath.makeId( "ciao" ) );
		assertEquals( ("ciao" + PS+ "abc"), DataPath.makeId( "ciao" + S + "abc" ) );
		assertEquals( ("" +PS+ "ciao" + PS + "abc" +PP), DataPath.makeId( "" +S+ "ciao" + S + "abc" +P) );
	}

	/*
	 * Test for String makeId(String[])
	 */
	@Test
	public void testMakeIdStringArray() {
		new RtdAssert(NullPointerException.class) {
			@Override
			protected void doCheck() throws Throwable {
				assertEquals( (""+ P), DataPath.makeId( (String[]) null ) );
			}
		};
		
		{ 
			String[] tmp = { null };
			assertEquals( NULL_ID, DataPath.makeId( tmp ) );
		}
		{ 
			String[] tmp = { null, null };
			assertEquals( (NULL_ID + D + NULL_ID), DataPath.makeId( tmp ) );
		}
		{ 
			String[] tmp = { null, "Ciao", null };
			assertEquals( (NULL_ID + D + "Ciao" + D + NULL_ID), DataPath.makeId( tmp ) );
		}
		{ 
			String[] tmp = { "a"+S+"b", ""+S+"Ciao"+S+S+P+P, "m"+P };
			assertEquals( ( ("a" +PS + "b")+ D + (""+PS+"Ciao"+PS+PS+PP+PP) + D + ( "m" + PP ) ), DataPath.makeId( tmp ) );
		}
	}

	/*
	 * Test for String makeSlashedId(String)
	 */
	@Test
	public void testMakeSlashedIdString() {
		assertEquals( (DataPath.addSlash(NULL_ID)), DataPath.makeSlashedId( (String) null ) );
		
		assertEquals( ("ciao"), DataPath.makeSlashedId( "ciao" ) );
		assertEquals( ("ciao" +PP+ PS+ "abc"), DataPath.makeSlashedId( "ciao" + S + "abc" ) );
		assertEquals( ("" +PP+PS+ "ciao" + PP+PS + "abc" +PP+PP), DataPath.makeSlashedId( "" +S+ "ciao" + S + "abc" +P) );
	}


	/*
	 * Test for String makeSlashedId(String[])
	 */
	@Test
	public void testMakeSlashedIdStringArray() {
		new RtdAssert(NullPointerException.class) {
			@Override
			protected void doCheck() throws Throwable {
				assertEquals( (""+ PP), DataPath.makeId( (String[]) null ) );
			}
		};
		
		String slashedNullId = DataPath.addSlash(NULL_ID);
		{ 
			String[] tmp = { null };
			assertEquals( (slashedNullId), DataPath.makeSlashedId( tmp ) );
		}
		{ 
			String[] tmp = { null, null };
			assertEquals( DataPath.addSlash(NULL_ID + D + NULL_ID), DataPath.makeSlashedId( tmp ) );
		}
		{ 
			String[] tmp = { null, "Ciao", null };
			assertEquals( DataPath.addSlash(NULL_ID + D + "Ciao" + D + NULL_ID), DataPath.makeSlashedId( tmp ) );
		}
		{ 
			String[] tmp = { "a"+S+"b", ""+S+"Ciao"+S+S+P+P, "m"+P };
			assertEquals( DataPath.addSlash( ("a" +PS + "b")
						+ D + (""+PS+"Ciao"+PS+PS+PP+PP)
						+ D + ( "m" + PP ) ), DataPath.makeSlashedId( tmp ) );
		}
	}

	/*
	 * 
	 */
	@Test
	public void testResolveId() {
		// makeId(String)	
		{ 
			String[] tmp = { null };
			assertArrayEquals(tmp, DataPath.resolveId(DataPath.makeId((String) null )));
		}
		{ 
			String[] tmp = { null };
			assertArrayEquals(tmp, DataPath.resolveId(DataPath.makeId((String) null )));
		}
		{
			String[] tmp = { "ciao" };
			assertArrayEquals(tmp, DataPath.resolveId(DataPath.makeId("ciao" )));
		}
		{
			String[] tmp = {"ciao" + S + "abc"};
			assertArrayEquals(tmp, DataPath.resolveId(DataPath.makeId("ciao" + S + "abc" )));
		}
		{
			String[] tmp = {"" +S+ "ciao" + S + "abc" +P};
			assertArrayEquals(tmp, DataPath.resolveId(DataPath.makeId("" +S+ "ciao" + S + "abc" +P )));
		}
		
		{ // print a warning but work
			String[] tmp = { null };
			assertArrayEquals(tmp, DataPath.resolveId(null));
		}
		{ // the correct way
			String[] tmp = { null };
			assertArrayEquals(tmp, DataPath.resolveId(NULL_ID));
		}
		
		// makeId(String[])
		{ 
			String[] tmp = { null };
			assertArrayEquals(tmp, DataPath.resolveId(DataPath.makeId(tmp)));
		}
		{ 
			String[] tmp = { "a", "b" };
			assertArrayEquals(tmp, DataPath.resolveId(DataPath.makeId(tmp)));
		}
		{ 
			String[] tmp = { null, null };
			assertArrayEquals(tmp, DataPath.resolveId(DataPath.makeId(tmp)));
		}
		{ 
			String[] tmp = { null, "Ciao", null };
			assertArrayEquals(tmp, DataPath.resolveId(DataPath.makeId(tmp)));
		}
		{ 
			String[] tmp = { "a"+S+"b", ""+S+"Ciao"+S+S+P+P, "m"+P };
			assertArrayEquals(tmp, DataPath.resolveId(DataPath.makeId(tmp)));
		}
	}
}
