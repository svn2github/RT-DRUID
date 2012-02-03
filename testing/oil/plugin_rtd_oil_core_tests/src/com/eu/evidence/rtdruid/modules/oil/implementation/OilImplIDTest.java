/*
 * Created on Aug 26, 2004
 *
 * $Id: OilImplIDTest.java,v 1.2 2007/03/09 09:12:41 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.implementation;

import junit.framework.TestCase;

import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OilImplID;

/**
 * @author Nicola Serreli
 */
public class OilImplIDTest extends TestCase {

	public void testOilImplID() {
		IOilImplID a = new OilImplID("a","a","b");
		IOilImplID b = new OilImplID("a","a","b");
		assertTrue(a!=null);
		assertTrue(b!=null);
		assertTrue(a!=b);
		
		// check null values
		IOilImplID c = a;
		a = new OilImplID(null, "a", "b");
		assertTrue(a!=c);

		c = a;
		a = new OilImplID("a", null, "b");
		assertTrue(a!=c);
		
		c = a;
		a = new OilImplID("a", "b", null);
		assertTrue(a!=c);

		c = a;
		a = new OilImplID(null, null, "a");
		assertTrue(a!=c);

		c = a;
		a = new OilImplID(null, "a", null);
		assertTrue(a!=c);
		
		c = a;
		a = new OilImplID("a", null, null);
		assertTrue(a!=c);

		c = a;
		a = new OilImplID(null, null, null);
		assertTrue(a!=c);
	}

	/*
	 * Class under test for String toString()
	 */
	public void testToString() {
		IOilImplID a = new OilImplID("?","a","b");
		IOilImplID b = new OilImplID(null,"a","b");
		assertTrue(a.toString() != null);
		assertTrue(a.toString().equals(b.toString()));
		assertTrue("HW = a, RT-OS = b".equals(a.toString()));
		
		// check null values
		a = new OilImplID(null, "a", "b");
		assertTrue(a.toString() != null);

		a = new OilImplID("a", null, "b");
		assertTrue(a.toString() != null);
		
		a = new OilImplID("a", "b", null);
		assertTrue(a.toString() != null);
		
		a = new OilImplID(null, null, "a");
		assertTrue(a.toString() != null);
		
		a = new OilImplID(null, "a", null);
		assertTrue(a.toString() != null);
		
		a = new OilImplID("a", null, null);
		assertTrue(a.toString() != null);
		
		a = new OilImplID(null, null, null);
		assertTrue(a.toString() != null);
	}

	/*
	 * Class under test for String toString()
	 */
	public void testToString2() {
		IOilImplID a = new OilImplID("?","a","b");
		assertTrue("HW = a, RT-OS = b".equals(a.toString()));
		
		// check null values
		a = new OilImplID("?",null, "b");
		assertTrue("HW = null, RT-OS = b".equals(a.toString()));
		
		a = new OilImplID("?","a", null);
		assertTrue("HW = a, RT-OS = null".equals(a.toString()));

		a = new OilImplID("?",null, null);
		assertTrue("HW = null, RT-OS = null".equals(a.toString()));
	}

	/*
	 * Class under test for boolean equals(Object)
	 */
	public void testEqualsObject() {
		IOilImplID a1 = new OilImplID("?","a","b");
		IOilImplID a2 = new OilImplID("??","a","b");
		IOilImplID b1 = new OilImplID("?",null, "b");
		IOilImplID b2 = new OilImplID("?",null, "b");
		IOilImplID c1 = new OilImplID("?","a", null);
		IOilImplID c2 = new OilImplID("?","a", null);
		IOilImplID d1 = new OilImplID("?",null, null);
		IOilImplID d2 = new OilImplID("?",null, null);
		IOilImplID e1 = new OilImplID("?","a","c");
		IOilImplID e2 = new OilImplID("?","c","b");
		IOilImplID e3 = new OilImplID("?","c","d");

		// a1
		assertTrue(a1==a1 &&  a1.equals(a1));
		assertTrue(a1!=a2 &&  a1.equals(a2));
		assertTrue(a1!=b1 && !a1.equals(b1));
		assertTrue(a1!=b2 && !a1.equals(b2));
		assertTrue(a1!=c1 && !a1.equals(c1));
		assertTrue(a1!=c2 && !a1.equals(c2));
		assertTrue(a1!=d1 && !a1.equals(d1));
		assertTrue(a1!=d2 && !a1.equals(d2));
		assertTrue(a1!=e1 && !a1.equals(e1));
		assertTrue(a1!=e2 && !a1.equals(e2));
		assertTrue(a1!=e3 && !a1.equals(e3));

		//a2
		assertTrue(a2!=a1 &&  a2.equals(a1));
		assertTrue(a2==a2 &&  a2.equals(a2));
		assertTrue(a2!=b1 && !a2.equals(b1));
		assertTrue(a2!=b2 && !a2.equals(b2));
		assertTrue(a2!=c1 && !a2.equals(c1));
		assertTrue(a2!=c2 && !a2.equals(c2));
		assertTrue(a2!=d1 && !a2.equals(d1));
		assertTrue(a2!=d2 && !a2.equals(d2));
		assertTrue(a2!=e1 && !a2.equals(e1));
		assertTrue(a2!=e2 && !a2.equals(e2));
		assertTrue(a2!=e3 && !a2.equals(e3));

		//b1
		assertTrue(b1!=a1 && !b1.equals(a1));
		assertTrue(b1!=a2 && !b1.equals(a2));
		assertTrue(b1==b1 &&  b1.equals(b1));
		assertTrue(b1!=b2 &&  b1.equals(b2));
		assertTrue(b1!=c1 && !b1.equals(c1));
		assertTrue(b1!=c2 && !b1.equals(c2));
		assertTrue(b1!=d1 && !b1.equals(d1));
		assertTrue(b1!=d2 && !b1.equals(d2));
		assertTrue(b1!=e1 && !b1.equals(e1));
		assertTrue(b1!=e2 && !b1.equals(e2));
		assertTrue(b1!=e3 && !b1.equals(e3));

		//b2
		assertTrue(b2!=a1 && !b2.equals(a1));
		assertTrue(b2!=a2 && !b2.equals(a2));
		assertTrue(b2!=b1 &&  b2.equals(b1));
		assertTrue(b2==b2 &&  b2.equals(b2));
		assertTrue(b2!=c1 && !b2.equals(c1));
		assertTrue(b2!=c2 && !b2.equals(c2));
		assertTrue(b2!=d1 && !b2.equals(d1));
		assertTrue(b2!=d2 && !b2.equals(d2));
		assertTrue(b2!=e1 && !b2.equals(e1));
		assertTrue(b2!=e2 && !b2.equals(e2));
		assertTrue(b2!=e3 && !b2.equals(e3));

		//c1
		assertTrue(c1!=a1 && !c1.equals(a1));
		assertTrue(c1!=a2 && !c1.equals(a2));
		assertTrue(c1!=b1 && !c1.equals(b1));
		assertTrue(c1!=b2 && !c1.equals(b2));
		assertTrue(c1==c1 &&  c1.equals(c1));
		assertTrue(c1!=c2 &&  c1.equals(c2));
		assertTrue(c1!=d1 && !c1.equals(d1));
		assertTrue(c1!=d2 && !c1.equals(d2));
		assertTrue(c1!=e1 && !c1.equals(e1));
		assertTrue(c1!=e2 && !c1.equals(e2));
		assertTrue(c1!=e3 && !c1.equals(e3));

		//c2
		assertTrue(c2!=a1 && !c2.equals(a1));
		assertTrue(c2!=a2 && !c2.equals(a2));
		assertTrue(c2!=b1 && !c2.equals(b1));
		assertTrue(c2!=b2 && !c2.equals(b2));
		assertTrue(c2!=c1 &&  c2.equals(c1));
		assertTrue(c2==c2 &&  c2.equals(c2));
		assertTrue(c2!=d1 && !c2.equals(d1));
		assertTrue(c2!=d2 && !c2.equals(d2));
		assertTrue(c2!=e1 && !c2.equals(e1));
		assertTrue(c2!=e2 && !c2.equals(e2));
		assertTrue(c2!=e3 && !c2.equals(e3));

		//d1
		assertTrue(d1!=a1 && !d1.equals(a1));
		assertTrue(d1!=a2 && !d1.equals(a2));
		assertTrue(d1!=b1 && !d1.equals(b1));
		assertTrue(d1!=b2 && !d1.equals(b2));
		assertTrue(d1!=c1 && !d1.equals(c1));
		assertTrue(d1!=c2 && !d1.equals(c2));
		assertTrue(d1==d1 &&  d1.equals(d1));
		assertTrue(d1!=d2 &&  d1.equals(d2));
		assertTrue(d1!=e1 && !d1.equals(e1));
		assertTrue(d1!=e2 && !d1.equals(e2));
		assertTrue(d1!=e3 && !d1.equals(e3));

		//d2
		assertTrue(d2!=a1 && !d2.equals(a1));
		assertTrue(d2!=a2 && !d2.equals(a2));
		assertTrue(d2!=b1 && !d2.equals(b1));
		assertTrue(d2!=b2 && !d2.equals(b2));
		assertTrue(d2!=c1 && !d2.equals(c1));
		assertTrue(d2!=c2 && !d2.equals(c2));
		assertTrue(d2!=d1 &&  d2.equals(d1));
		assertTrue(d2==d2 &&  d2.equals(d2));
		assertTrue(d2!=e1 && !d2.equals(e1));
		assertTrue(d2!=e2 && !d2.equals(e2));
		assertTrue(d2!=e3 && !d2.equals(e3));
		
	}

	public void testCompareTo() {
		OilImplID a1 = new OilImplID("?","a","b");
		OilImplID a2 = new OilImplID("??","a","b");
		OilImplID b1 = new OilImplID("?",null, "b");
		OilImplID b2 = new OilImplID("?",null, "b");
		OilImplID c1 = new OilImplID("?","a", null);
		OilImplID c2 = new OilImplID("?","a", null);
		OilImplID d1 = new OilImplID("?",null, null);
		OilImplID d2 = new OilImplID("?",null, null);
		OilImplID e1 = new OilImplID("?","a","c");
		OilImplID e2 = new OilImplID("?","c","b");
		OilImplID e3 = new OilImplID("?","c","d");

		//order :
		// 1)  d1 & d2
		// 2)  b1 & b2
		// 3)  c1 & c2
		// 4)  a1 & a2
		// 5)  e1
		// 6)  e2
		// 6)  e3
		
		
		// a1
		assertTrue(a1.compareTo(a1)   ==0 );
		assertTrue(a1.compareTo(a2)   ==0 );
		assertTrue(a1.compareTo(b1) >0    );
		assertTrue(a1.compareTo(b2) >0    );
		assertTrue(a1.compareTo(c1) >0    );
		assertTrue(a1.compareTo(c2) >0    );
		assertTrue(a1.compareTo(d1) >0    );
		assertTrue(a1.compareTo(d2) >0    );
		assertTrue(a1.compareTo(e1)     <0);
		assertTrue(a1.compareTo(e2)     <0);
		assertTrue(a1.compareTo(e3)     <0);

		//a2
		assertTrue(a2.compareTo(a1)   ==0 );
		assertTrue(a2.compareTo(a2)   ==0 );
		assertTrue(a2.compareTo(b1) >0    );
		assertTrue(a2.compareTo(b2) >0    );
		assertTrue(a2.compareTo(c1) >0    );
		assertTrue(a2.compareTo(c2) >0    );
		assertTrue(a2.compareTo(d1) >0    );
		assertTrue(a2.compareTo(d2) >0    );
		assertTrue(a2.compareTo(e1)     <0);
		assertTrue(a2.compareTo(e2)     <0);
		assertTrue(a2.compareTo(e3)     <0);

		//b1
		assertTrue(b1.compareTo(a1)     <0);
		assertTrue(b1.compareTo(a2)     <0);
		assertTrue(b1.compareTo(b1)   ==0 );
		assertTrue(b1.compareTo(b2)   ==0 );
		assertTrue(b1.compareTo(c1)     <0);
		assertTrue(b1.compareTo(c2)     <0);
		assertTrue(b1.compareTo(d1) >0    );
		assertTrue(b1.compareTo(d2) >0    );
		assertTrue(b1.compareTo(e1)     <0);
		assertTrue(b1.compareTo(e2)     <0);
		assertTrue(b1.compareTo(e3)     <0);

		//b2
		assertTrue(b2.compareTo(a1)     <0);
		assertTrue(b2.compareTo(a2)     <0);
		assertTrue(b2.compareTo(b1)   ==0 );
		assertTrue(b2.compareTo(b2)   ==0 );
		assertTrue(b2.compareTo(c1)     <0);
		assertTrue(b2.compareTo(c2)     <0);
		assertTrue(b2.compareTo(d1) >0    );
		assertTrue(b2.compareTo(d2) >0    );
		assertTrue(b2.compareTo(e1)     <0);
		assertTrue(b2.compareTo(e2)     <0);
		assertTrue(b2.compareTo(e3)     <0);

		//c1
		assertTrue(c1.compareTo(a1)     <0);
		assertTrue(c1.compareTo(a2)     <0);
		assertTrue(c1.compareTo(b1) >0    );
		assertTrue(c1.compareTo(b2) >0    );
		assertTrue(c1.compareTo(c1)   ==0 );
		assertTrue(c1.compareTo(c2)   ==0 );
		assertTrue(c1.compareTo(d1) >0    );
		assertTrue(c1.compareTo(d2) >0    );
		assertTrue(c1.compareTo(e1)     <0);
		assertTrue(c1.compareTo(e2)     <0);
		assertTrue(c1.compareTo(e3)     <0);

		//c2
		assertTrue(c2.compareTo(a1)     <0);
		assertTrue(c2.compareTo(a2)     <0);
		assertTrue(c2.compareTo(b1) >0    );
		assertTrue(c2.compareTo(b2) >0    );
		assertTrue(c2.compareTo(c1)   ==0 );
		assertTrue(c2.compareTo(c2)   ==0 );
		assertTrue(c2.compareTo(d1) >0    );
		assertTrue(c2.compareTo(d2) >0    );
		assertTrue(c2.compareTo(e1)     <0);
		assertTrue(c2.compareTo(e2)     <0);
		assertTrue(c2.compareTo(e3)     <0);

		//d1
		assertTrue(d1.compareTo(a1)     <0);
		assertTrue(d1.compareTo(a2)     <0);
		assertTrue(d1.compareTo(b1)     <0);
		assertTrue(d1.compareTo(b2)     <0);
		assertTrue(d1.compareTo(c1)     <0);
		assertTrue(d1.compareTo(c2)     <0);
		assertTrue(d1.compareTo(d1)   ==0 );
		assertTrue(d1.compareTo(d2)   ==0 );
		assertTrue(d1.compareTo(e1)     <0);
		assertTrue(d1.compareTo(e2)     <0);
		assertTrue(d1.compareTo(e3)     <0);

		//d2
		assertTrue(d2.compareTo(a1)     <0);
		assertTrue(d2.compareTo(a2)     <0);
		assertTrue(d2.compareTo(b1)     <0);
		assertTrue(d2.compareTo(b2)     <0);
		assertTrue(d2.compareTo(c1)     <0);
		assertTrue(d2.compareTo(c2)     <0);
		assertTrue(d2.compareTo(d1)   ==0 );
		assertTrue(d2.compareTo(d2)   ==0 );
		assertTrue(d2.compareTo(e1)     <0);
		assertTrue(d2.compareTo(e2)     <0);
		assertTrue(d2.compareTo(e3)     <0);
		
		// e1
		assertTrue(e1.compareTo(a1) >0    );
		assertTrue(e1.compareTo(a2) >0    );
		assertTrue(e1.compareTo(b1) >0    );
		assertTrue(e1.compareTo(b2) >0    );
		assertTrue(e1.compareTo(c1) >0    );
		assertTrue(e1.compareTo(c2) >0    );
		assertTrue(e1.compareTo(d1) >0    );
		assertTrue(e1.compareTo(d2) >0    );
		assertTrue(e1.compareTo(e1)   ==0 );
		assertTrue(e1.compareTo(e2)     <0);
		assertTrue(e1.compareTo(e3)     <0);

		//e2
		assertTrue(e2.compareTo(a1) >0    );
		assertTrue(e2.compareTo(a2) >0    );
		assertTrue(e2.compareTo(b1) >0    );
		assertTrue(e2.compareTo(b2) >0    );
		assertTrue(e2.compareTo(c1) >0    );
		assertTrue(e2.compareTo(c2) >0    );
		assertTrue(e2.compareTo(d1) >0    );
		assertTrue(e2.compareTo(d2) >0    );
		assertTrue(e2.compareTo(e1) >0    );
		assertTrue(e2.compareTo(e2)   ==0 );
		assertTrue(e2.compareTo(e3)     <0);

		//e3
		assertTrue(e3.compareTo(a1) >0    );
		assertTrue(e3.compareTo(a2) >0    );
		assertTrue(e3.compareTo(b1) >0    );
		assertTrue(e3.compareTo(b2) >0    );
		assertTrue(e3.compareTo(c1) >0    );
		assertTrue(e3.compareTo(c2) >0    );
		assertTrue(e3.compareTo(d1) >0    );
		assertTrue(e3.compareTo(d2) >0    );
		assertTrue(e3.compareTo(e1) >0    );
		assertTrue(e3.compareTo(e2) >0    );
		assertTrue(e3.compareTo(e3)   ==0 );
	}

	
	/*
	 * Class under test for boolean equals(Object)
	 */
	public void testHashCode() {
		IOilImplID a1 = new OilImplID("?","a","b");
		IOilImplID a2 = new OilImplID("??","a","b");
		IOilImplID b1 = new OilImplID("?",null, "b");
		IOilImplID b2 = new OilImplID("?",null, "b");
		IOilImplID c1 = new OilImplID("?","a", null);
		IOilImplID c2 = new OilImplID("?","a", null);
		IOilImplID d1 = new OilImplID("?",null, null);
		IOilImplID d2 = new OilImplID("?",null, null);
		IOilImplID e1 = new OilImplID("?","a","c");
		IOilImplID e2 = new OilImplID("?","c","b");
		IOilImplID e3 = new OilImplID("?","c","d");

		// a1
		assertTrue(a1==a1 &&  (a1.hashCode() == a1.hashCode()));
		assertTrue(a1!=a2 &&  (a1.hashCode() == a2.hashCode()));
		assertTrue(a1!=b1 && !(a1.hashCode() == b1.hashCode()));
		assertTrue(a1!=b2 && !(a1.hashCode() == b2.hashCode()));
		assertTrue(a1!=c1 && !(a1.hashCode() == c1.hashCode()));
		assertTrue(a1!=c2 && !(a1.hashCode() == c2.hashCode()));
		assertTrue(a1!=d1 && !(a1.hashCode() == d1.hashCode()));
		assertTrue(a1!=d2 && !(a1.hashCode() == d2.hashCode()));
		assertTrue(a1!=e1 && !(a1.hashCode() == e1.hashCode()));
		assertTrue(a1!=e2 && !(a1.hashCode() == e2.hashCode()));
		assertTrue(a1!=e3 && !(a1.hashCode() == e3.hashCode()));

		//a2
		assertTrue(a2!=a1 &&  (a2.hashCode() == a1.hashCode()));
		assertTrue(a2==a2 &&  (a2.hashCode() == a2.hashCode()));
		assertTrue(a2!=b1 && !(a2.hashCode() == b1.hashCode()));
		assertTrue(a2!=b2 && !(a2.hashCode() == b2.hashCode()));
		assertTrue(a2!=c1 && !(a2.hashCode() == c1.hashCode()));
		assertTrue(a2!=c2 && !(a2.hashCode() == c2.hashCode()));
		assertTrue(a2!=d1 && !(a2.hashCode() == d1.hashCode()));
		assertTrue(a2!=d2 && !(a2.hashCode() == d2.hashCode()));
		assertTrue(a2!=e1 && !(a2.hashCode() == e1.hashCode()));
		assertTrue(a2!=e2 && !(a2.hashCode() == e2.hashCode()));
		assertTrue(a2!=e3 && !(a2.hashCode() == e3.hashCode()));

		//b1
		assertTrue(b1!=a1 && !(b1.hashCode() == a1.hashCode()));
		assertTrue(b1!=a2 && !(b1.hashCode() == a2.hashCode()));
		assertTrue(b1==b1 &&  (b1.hashCode() == b1.hashCode()));
		assertTrue(b1!=b2 &&  (b1.hashCode() == b2.hashCode()));
		assertTrue(b1!=c1 && !(b1.hashCode() == c1.hashCode()));
		assertTrue(b1!=c2 && !(b1.hashCode() == c2.hashCode()));
		assertTrue(b1!=d1 && !(b1.hashCode() == d1.hashCode()));
		assertTrue(b1!=d2 && !(b1.hashCode() == d2.hashCode()));
		assertTrue(b1!=e1 && !(b1.hashCode() == e1.hashCode()));
		assertTrue(b1!=e2 && !(b1.hashCode() == e2.hashCode()));
		assertTrue(b1!=e3 && !(b1.hashCode() == e3.hashCode()));

		//b2
		assertTrue(b2!=a1 && !(b2.hashCode() == a1.hashCode()));
		assertTrue(b2!=a2 && !(b2.hashCode() == a2.hashCode()));
		assertTrue(b2!=b1 &&  (b2.hashCode() == b1.hashCode()));
		assertTrue(b2==b2 &&  (b2.hashCode() == b2.hashCode()));
		assertTrue(b2!=c1 && !(b2.hashCode() == c1.hashCode()));
		assertTrue(b2!=c2 && !(b2.hashCode() == c2.hashCode()));
		assertTrue(b2!=d1 && !(b2.hashCode() == d1.hashCode()));
		assertTrue(b2!=d2 && !(b2.hashCode() == d2.hashCode()));
		assertTrue(b2!=e1 && !(b2.hashCode() == e1.hashCode()));
		assertTrue(b2!=e2 && !(b2.hashCode() == e2.hashCode()));
		assertTrue(b2!=e3 && !(b2.hashCode() == e3.hashCode()));

		//c1
		assertTrue(c1!=a1 && !(c1.hashCode() == a1.hashCode()));
		assertTrue(c1!=a2 && !(c1.hashCode() == a2.hashCode()));
		assertTrue(c1!=b1 && !(c1.hashCode() == b1.hashCode()));
		assertTrue(c1!=b2 && !(c1.hashCode() == b2.hashCode()));
		assertTrue(c1==c1 &&  (c1.hashCode() == c1.hashCode()));
		assertTrue(c1!=c2 &&  (c1.hashCode() == c2.hashCode()));
		assertTrue(c1!=d1 && !(c1.hashCode() == d1.hashCode()));
		assertTrue(c1!=d2 && !(c1.hashCode() == d2.hashCode()));
		assertTrue(c1!=e1 && !(c1.hashCode() == e1.hashCode()));
		assertTrue(c1!=e2 && !(c1.hashCode() == e2.hashCode()));
		assertTrue(c1!=e3 && !(c1.hashCode() == e3.hashCode()));

		//c2
		assertTrue(c2!=a1 && !(c2.hashCode() == a1.hashCode()));
		assertTrue(c2!=a2 && !(c2.hashCode() == a2.hashCode()));
		assertTrue(c2!=b1 && !(c2.hashCode() == b1.hashCode()));
		assertTrue(c2!=b2 && !(c2.hashCode() == b2.hashCode()));
		assertTrue(c2!=c1 &&  (c2.hashCode() == c1.hashCode()));
		assertTrue(c2==c2 &&  (c2.hashCode() == c2.hashCode()));
		assertTrue(c2!=d1 && !(c2.hashCode() == d1.hashCode()));
		assertTrue(c2!=d2 && !(c2.hashCode() == d2.hashCode()));
		assertTrue(c2!=e1 && !(c2.hashCode() == e1.hashCode()));
		assertTrue(c2!=e2 && !(c2.hashCode() == e2.hashCode()));
		assertTrue(c2!=e3 && !(c2.hashCode() == e3.hashCode()));

		//d1
		assertTrue(d1!=a1 && !(d1.hashCode() == a1.hashCode()));
		assertTrue(d1!=a2 && !(d1.hashCode() == a2.hashCode()));
		assertTrue(d1!=b1 && !(d1.hashCode() == b1.hashCode()));
		assertTrue(d1!=b2 && !(d1.hashCode() == b2.hashCode()));
		assertTrue(d1!=c1 && !(d1.hashCode() == c1.hashCode()));
		assertTrue(d1!=c2 && !(d1.hashCode() == c2.hashCode()));
		assertTrue(d1==d1 &&  (d1.hashCode() == d1.hashCode()));
		assertTrue(d1!=d2 &&  (d1.hashCode() == d2.hashCode()));
		assertTrue(d1!=e1 && !(d1.hashCode() == e1.hashCode()));
		assertTrue(d1!=e2 && !(d1.hashCode() == e2.hashCode()));
		assertTrue(d1!=e3 && !(d1.hashCode() == e3.hashCode()));

		//d2
		assertTrue(d2!=a1 && !(d2.hashCode() == a1.hashCode()));
		assertTrue(d2!=a2 && !(d2.hashCode() == a2.hashCode()));
		assertTrue(d2!=b1 && !(d2.hashCode() == b1.hashCode()));
		assertTrue(d2!=b2 && !(d2.hashCode() == b2.hashCode()));
		assertTrue(d2!=c1 && !(d2.hashCode() == c1.hashCode()));
		assertTrue(d2!=c2 && !(d2.hashCode() == c2.hashCode()));
		assertTrue(d2!=d1 &&  (d2.hashCode() == d1.hashCode()));
		assertTrue(d2==d2 &&  (d2.hashCode() == d2.hashCode()));
		assertTrue(d2!=e1 && !(d2.hashCode() == e1.hashCode()));
		assertTrue(d2!=e2 && !(d2.hashCode() == e2.hashCode()));
		assertTrue(d2!=e3 && !(d2.hashCode() == e3.hashCode()));

		
		IOilImplID h1 = new OilImplID("?","a","b");
		IOilImplID h2 = new OilImplID("??","b","a");
		assertTrue(h1!=h2 && !(h1.hashCode() == h2.hashCode()));
		

	}
}
