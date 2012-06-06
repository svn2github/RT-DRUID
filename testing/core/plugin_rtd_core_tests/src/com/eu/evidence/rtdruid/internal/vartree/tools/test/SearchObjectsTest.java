/*
 * Created on 26/set/07
 *
 * $Id: SearchObjectsTest.java,v 1.1 2007/09/28 14:16:05 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.vartree.tools.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

import com.eu.evidence.rtdruid.tests.vartree.data.SimpleExamples;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.Vt2StringUtilities;
import com.eu.evidence.rtdruid.vartree.tools.IData;
import com.eu.evidence.rtdruid.vartree.tools.IProcData;
import com.eu.evidence.rtdruid.vartree.tools.SearchObjects;

public class SearchObjectsTest {

	@Test
	public void testGetAllProcs1() throws IOException {
		IVarTree vt = Vt2StringUtilities.loadString(SimpleExamples.testLoadExample1());

		SearchObjects search = new SearchObjects(vt);
		IData[] procs = search.getAllProcs();

		assertNotNull(procs);

		assertEquals(5, procs.length );

		for (int i = 0; i < procs.length; i++) {
			System.out.println("" + procs[i]);
		}

	}

	@Test
	public void testGetAllProcs2() throws IOException {
		IVarTree vt = Vt2StringUtilities.loadString(SimpleExamples.testLoadExample2());

		SearchObjects search = new SearchObjects(vt);
		IData[] procs = search.getAllProcs();

		assertNotNull(procs);

		for (int i = 0; i < procs.length; i++) {
			System.out.println("" + procs[i]);
		}
		assertEquals(25, procs.length );

	}

	@Test
	public void testGetAllTasks1() throws IOException {
		IVarTree vt = Vt2StringUtilities.loadString(SimpleExamples.testLoadExample1());

		SearchObjects search = new SearchObjects(vt);
		IData[] tasks = search.getAllTasks();

		assertNotNull(tasks);

		for (int i = 0; i < tasks.length; i++) {
			System.out.println("" + tasks[i]);
		}

		assertEquals(4, tasks.length );

	}

	@Test
	public void testGetAllTasks2() throws IOException {
		IVarTree vt = Vt2StringUtilities.loadString(SimpleExamples.testLoadExample2());

		SearchObjects search = new SearchObjects(vt);
		IData[] tasks = search.getAllTasks();

		assertNotNull(tasks);

		for (int i = 0; i < tasks.length; i++) {
			System.out.println("" + tasks[i]);
		}
		assertEquals(14, tasks.length );

	}

	// SORT

	@Test
	public void testSortAll1() throws IOException {
		IVarTree vt = Vt2StringUtilities.loadString(SimpleExamples.testLoadExample1());

		SearchObjects search = new SearchObjects(vt);
		IData[] tasks = search.getAllTasks();
		IData[] procs = search.getAllProcs();

		assertNotNull(tasks);
		assertNotNull(procs);

		ArrayList<IData> all = new ArrayList<IData>();
		all.addAll(Arrays.asList(tasks));
		all.addAll(Arrays.asList(procs));

		Collections.sort(all, new SearchObjects.DataComparatorSort());

		System.out.println("\n\n>>>");

		for (int i = 0; i < all.size(); i++) {
			System.out.println("" + all.get(i));
		}
		System.out.println("<<<\n\n");

	}

	@Test
	public void testSortAll2() throws IOException {
		IVarTree vt = Vt2StringUtilities.loadString(SimpleExamples.testLoadExample2());

		SearchObjects search = new SearchObjects(vt);
		IData[] tasks = search.getAllTasks();
		IData[] procs = search.getAllProcs();

		assertNotNull(tasks);
		assertNotNull(procs);

		ArrayList<IData> all = new ArrayList<IData>();
		all.addAll(Arrays.asList(tasks));
		all.addAll(Arrays.asList(procs));

		Collections.sort(all, new SearchObjects.DataComparatorSort());

		System.out.println("\n\n>>>");

		for (int i = 0; i < all.size(); i++) {
			System.out.println("" + all.get(i));
		}
		System.out.println("<<<\n\n");
		
	}

	// SEARCH

	@Test
	public void testSearchAll1() throws IOException {
		IVarTree vt = Vt2StringUtilities.loadString(SimpleExamples.testLoadExample1());

		SearchObjects search = new SearchObjects(vt);
		IData[] tasks = search.getAllTasks();
		IData[] procs = search.getAllProcs();

		assertNotNull(tasks);
		assertNotNull(procs);

		ArrayList<IData> all = new ArrayList<IData>();
		all.addAll(Arrays.asList(tasks));
		all.addAll(Arrays.asList(procs));

		SearchObjects.DataComparatorSearch comp = new SearchObjects.DataComparatorSearch();
		Collections.sort(all, comp);

		System.out.println("\n\n>>>");

		for (int i = 0; i < all.size(); i++) {
			System.out.println("" + all.get(i));
		}
		System.out.println("<<<\n\n");

		for (int i = 0; i < all.size(); i++) {
			IData run = (IData) all.get(i);

			String[] id = new String[3];
			id[0] = run.getCpuID();
			if (run instanceof IProcData) {
				id[1] = ((IProcData) run).getFullName();
				id[2] = "PROC";
			} else {
				id[1] = run.getName();
				id[2] = "TASK";
			}
			int pos = Collections.binarySearch(all, id, comp);
			assertEquals(i, pos );

			// in general, the anser can be different from pos, but cannot be <0
			// in this example it is the same
			id[2] = null;
			pos = Collections.binarySearch(all, id, comp);
			assertEquals(i, pos );

		}

	}

	@Test
	public void testSearchAll2() throws IOException {
		IVarTree vt = Vt2StringUtilities.loadString(SimpleExamples.testLoadExample2());

		SearchObjects search = new SearchObjects(vt);
		IData[] tasks = search.getAllTasks();
		IData[] procs = search.getAllProcs();

		assertNotNull(tasks);
		assertNotNull(procs);

		ArrayList<IData> all = new ArrayList<IData>();
		all.addAll(Arrays.asList(tasks));
		all.addAll(Arrays.asList(procs));

		SearchObjects.DataComparatorSearch comp = new SearchObjects.DataComparatorSearch();
		Collections.sort(all, comp);

		System.out.println("\n\n>>>");

		for (int i = 0; i < all.size(); i++) {
			System.out.println("" + all.get(i));
		}
		System.out.println("<<<\n\n");
		

		for (int i = 0; i < all.size(); i++) {
			IData run = (IData) all.get(i);

			String[] id = new String[3];
			id[0] = run.getCpuID();
			if (run instanceof IProcData) {
				id[1] = ((IProcData) run).getFullName();
				id[2] = SearchObjects.DataComparatorSearch.PROC_ID;
			} else {
				id[1] = run.getName();
				id[2] = SearchObjects.DataComparatorSearch.TASK_ID;
			}
			int pos = Collections.binarySearch(all, id, comp);
			assertEquals(i, pos );

			// in general, the anser can be different from pos, but cannot be <0
			// in this example it is the same
			id[2] = null;
			pos = Collections.binarySearch(all, id, comp);
			assertEquals(i, pos );

		}

	}

}
