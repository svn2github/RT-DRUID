package com.eu.evidence.rtdruid.modules.oil.codewriter.common;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertNotSame;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

import com.eu.evidence.rtdruid.modules.oil.interfaces.ISWCategory;

public class SWCategoryManagerTest {

	
	@Test
	public void testNewCategory() {
		SWCategoryManager man = SWCategoryManager.defaultInstance;

		{
			ISWCategory cat = man.newCategory(SWCategoryManager.TYPE_BOARD, -5);
			String[] vals = cat.getKeys();
			assertEquals(vals.length , 1);
			assertSame(vals[0] , SWCategoryManager.TYPE_BOARD);
			assertEquals(cat.getPriority() , -5);
		}
		{
			ISWCategory cat = man.newCategory(SWCategoryManager.TYPE_CPU, 4);
			String[] vals = cat.getKeys();
			assertEquals(vals.length , 1);
			assertSame(vals[0] , SWCategoryManager.TYPE_CPU);
			assertEquals(cat.getPriority() , 4);
		}
		{
			ISWCategory cat = man.newCategory((new StringBuffer(SWCategoryManager.TYPE_CPU).toString()), 4);
			String[] vals = cat.getKeys();
			assertEquals(vals.length , 1);
			assertTrue(vals[0].equals(SWCategoryManager.TYPE_CPU));
			assertNotSame(vals[0] , SWCategoryManager.TYPE_CPU); // !!!
			assertEquals(cat.getPriority() , 4);
		}
		{
			ISWCategory cat = man.newCategory("" + SWCategoryManager.TYPE_CPU, 4);
			String[] vals = cat.getKeys();
			assertEquals(vals.length , 1);
			assertTrue(vals[0].equals(SWCategoryManager.TYPE_CPU));
			assertSame(vals[0] , SWCategoryManager.TYPE_CPU);
			assertEquals(cat.getPriority() , 4);
		}
	}

	@Test
	public void testNewCategoryV() {
		SWCategoryManager man = SWCategoryManager.defaultInstance;

		{
			ISWCategory cat = man.newCategory(new String[] {SWCategoryManager.TYPE_BOARD}, -5);
			String[] vals = cat.getKeys();
			assertEquals(vals.length , 1);
			assertSame(vals[0] , SWCategoryManager.TYPE_BOARD);
			assertEquals(cat.getPriority() , -5);
		}
		{
			ISWCategory cat = man.newCategory(new String[] {(new StringBuffer(SWCategoryManager.TYPE_CPU).toString())}, 4);
			String[] vals = cat.getKeys();
			assertEquals(vals.length , 1);
			assertTrue(vals[0].equals(SWCategoryManager.TYPE_CPU));
			assertNotSame(vals[0] , SWCategoryManager.TYPE_CPU); // !!!
			assertEquals(cat.getPriority() , 4);
		}
		{
			ISWCategory cat = man.newCategory(
					new String[] {
							SWCategoryManager.TYPE_CPU,
							SWCategoryManager.TYPE_BOARD,
							SWCategoryManager.TYPE_END,
					}, 4);
			String[] vals = cat.getKeys();
			assertEquals(vals.length , 3);
			List<String> values = Arrays.asList(vals);
			assertTrue(values.contains(SWCategoryManager.TYPE_CPU));
			assertTrue(values.contains(SWCategoryManager.TYPE_BOARD));
			assertTrue(values.contains(SWCategoryManager.TYPE_END));
			assertEquals(cat.getPriority() , 4);
		}
		{
			ISWCategory cat = man.newCategory(
					new String[] {
							new StringBuffer(SWCategoryManager.TYPE_CPU).toString(),
							SWCategoryManager.TYPE_BOARD,
							"" + SWCategoryManager.TYPE_END,
					}, 4);
			String[] vals = cat.getKeys();
			assertEquals(vals.length , 3);
			List<String> values = Arrays.asList(vals);
			assertTrue(values.contains(SWCategoryManager.TYPE_CPU));
			assertTrue(values.contains(SWCategoryManager.TYPE_BOARD));
			assertTrue(values.contains(SWCategoryManager.TYPE_END));
			assertEquals(cat.getPriority() , 4);
		}
	}

	@Test
	public void testSortKeys() {
		SWCategoryManager defaultinstance = SWCategoryManager.defaultInstance;
		
		{
			String[] values = new String[] {
					SWCategoryManager.TYPE_CPU,
					SWCategoryManager.TYPE_END,
					null,
					SWCategoryManager.TYPE_INIT,
					SWCategoryManager.TYPE_OTHERS,
					"",
					new StringBuffer(SWCategoryManager.TYPE_MAKEFILE).toString(),
					"abc"
			};
			List<String> arr = Arrays.asList(values);
			defaultinstance.sortKeys(arr);
			
			assertEquals(arr.size() , values.length);
			for (String s : values) {
				assertTrue(arr.contains(s));
			}
			
			for (int i=1; i<arr.size(); i++) {
				assertTrue(defaultinstance.categoryLevel(arr.get(i-1)) <= defaultinstance.categoryLevel(arr.get(i)));
				if (defaultinstance.categoryLevel(arr.get(i-1)) == defaultinstance.categoryLevel(arr.get(i))) {
					assertEquals(defaultinstance.categoryLevel(arr.get(i)) , defaultinstance.categoryLevel(SWCategoryManager.TYPE_OTHERS));
				}
			}
		}
	}

	@Test
	public void testGetKeysComparator() {
		Comparator<String> comp = SWCategoryManager.defaultInstance.getKeysComparator();
		assertNotSame(comp , null);
	}

	@Test
	public void testCategoryLevel() {
		int others = SWCategoryManager.defaultInstance.categoryLevel(SWCategoryManager.TYPE_OTHERS);
		assertEquals(others , SWCategoryManager.defaultInstance.categoryLevel(null));
		assertEquals(others , SWCategoryManager.defaultInstance.categoryLevel(""));
		assertEquals(others , SWCategoryManager.defaultInstance.categoryLevel("abcde"));

		assertNotSame(others, SWCategoryManager.defaultInstance.categoryLevel(SWCategoryManager.TYPE_BOARD));
		assertTrue(others > SWCategoryManager.defaultInstance.categoryLevel(SWCategoryManager.TYPE_INIT));
		assertTrue(others < SWCategoryManager.defaultInstance.categoryLevel(SWCategoryManager.TYPE_END));

	}

}
