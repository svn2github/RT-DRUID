/*
 * Created on 14-giu-2004
 */
package com.eu.evidence.rtdruid.test.vartree.data;

import org.junit.Before;
import org.junit.Test;

import com.eu.evidence.rtdruid.io.IVTResource;
import com.eu.evidence.rtdruid.io.RTD_XMI_Factory;
import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.VarTreeUtil;
import com.eu.evidence.rtdruid.vartree.data.DataFactory;
import com.eu.evidence.rtdruid.vartree.data.ExecTime;
import com.eu.evidence.rtdruid.vartree.data.ExecTimeList;
import com.eu.evidence.rtdruid.vartree.data.Mapping;
import com.eu.evidence.rtdruid.vartree.data.Order;
import com.eu.evidence.rtdruid.vartree.data.PartialOrder;
import com.eu.evidence.rtdruid.vartree.data.ProcMap;
import com.eu.evidence.rtdruid.vartree.data.TaskMap;
import com.eu.evidence.rtdruid.vartree.data.TimeConst;
import com.eu.evidence.rtdruid.vartree.data.TimeConstElement;
import com.eu.evidence.rtdruid.vartree.data.VarMap;

/**
 * This class thes if "clone tree" and "merge tree" work well
 * 
 * @author Nicola Serreli
 */
public class ComposedIdTest {
	
	IVarTree vt;

	@Before
	public void setup() {
		
		vt = VarTreeUtil.newVarTree();
	}


	@Test
	public void testExecTime() {

		{
			ExecTimeList etl = DataFactory.eINSTANCE.createExecTimeList();
			ExecTime ex1 = DataFactory.eINSTANCE.createExecTime();
			ex1.setObjectID( DataPath.makeId( new String[] {"A", "B"}));
			ExecTime ex2 = DataFactory.eINSTANCE.createExecTime();
			ex2.setObjectID( DataPath.makeId( new String[] {"B", "B"}));
			
			etl.getExecTimeItemsList().add(ex1);
			etl.getExecTimeItemsList().add(ex2);
			
			ex2.setObjectID(DataPath.makeId( new String[] {"A", "A"}));
			ex2.setObjectID(DataPath.makeId( new String[] {"B", "A"}));
			boolean ok = false;
			try {
				ex2.setObjectID(DataPath.makeId( new String[] {"A", "B"}));
			} catch (Exception e) {
				ok = true;
			}
			assertTrue(ok);
		}

		{
			ExecTimeList etl = DataFactory.eINSTANCE.createExecTimeList();
			ExecTime ex1 = DataFactory.eINSTANCE.createExecTime();
			ex1.setObjectID( DataPath.makeId( new String[] {"B", "A"}));
			ExecTime ex2 = DataFactory.eINSTANCE.createExecTime();
			ex2.setObjectID( DataPath.makeId( new String[] {"B", "B"}));
			
			etl.getExecTimeItemsList().add(ex1);
			etl.getExecTimeItemsList().add(ex2);
			
			ex2.setObjectID(DataPath.makeId( new String[] {"A", "A"}));
			ex2.setObjectID(DataPath.makeId( new String[] {"B", "B"}));
			boolean ok = false;
			try {
				ex2.setObjectID(DataPath.makeId( new String[] {"B", "A"}));
			} catch (Exception e) {
				ok = true;
			}
			assertTrue(ok);
		}

		// with resource !
		
		{
			ExecTimeList etl = DataFactory.eINSTANCE.createExecTimeList();
			ExecTime ex1 = DataFactory.eINSTANCE.createExecTime();
			ex1.setObjectID( DataPath.makeId( new String[] {"A", "B"}));
			ExecTime ex2 = DataFactory.eINSTANCE.createExecTime();
			ex2.setObjectID( DataPath.makeId( new String[] {"B", "B"}));
			
			// set resource !!!
			IVTResource mxri = (IVTResource) new RTD_XMI_Factory().createResource();
			mxri.getContents().add(etl);
			
			etl.getExecTimeItemsList().add(ex1);
			etl.getExecTimeItemsList().add(ex2);
			
			ex2.setObjectID(DataPath.makeId( new String[] {"A", "A"}));
			boolean ok = false;
			try {
				ex2.setObjectID(DataPath.makeId( new String[] {"A", "B"}));
			} catch (RuntimeException e) {
				ok = true;
			}
			assertTrue(ok);
		}

		{
			ExecTimeList etl = DataFactory.eINSTANCE.createExecTimeList();
			ExecTime ex1 = DataFactory.eINSTANCE.createExecTime();
			ex1.setObjectID( DataPath.makeId( new String[] {"B", "A"}));
			ExecTime ex2 = DataFactory.eINSTANCE.createExecTime();
			ex2.setObjectID( DataPath.makeId( new String[] {"B", "B"}));
			
			// set resource !!!
			IVTResource mxri = createResource();
			mxri.getContents().add(etl);
			
			etl.getExecTimeItemsList().add(ex1);
			etl.getExecTimeItemsList().add(ex2);
			
			assertTrue(ex1.eResource() != null);
			assertTrue(ex2.eResource() != null);
			
			ex2.setObjectID(DataPath.makeId( new String[] {"A", "A"}));
			boolean ok = false;
			try {
				ex2.setObjectID(DataPath.makeId( new String[] {"B", "A"}));
			} catch (RuntimeException e) {
				ok = true;
			}
			assertTrue(ok);
		}
	}


	@Test
	public void testOrder() {

		{
			PartialOrder po = DataFactory.eINSTANCE.createPartialOrder();
			Order ex1 = DataFactory.eINSTANCE.createOrder();
			ex1.setObjectID( DataPath.makeId( new String[] {"A", "B"}));
			Order ex2 = DataFactory.eINSTANCE.createOrder();
			ex2.setObjectID( DataPath.makeId( new String[] {"B", "B"}));
			
			po.getOrderList().add(ex1);
			po.getOrderList().add(ex2);
			
			ex2.setObjectID(DataPath.makeId( new String[] {"A", "A"}));
			boolean ok = false;
			try {
				ex2.setObjectID(DataPath.makeId( new String[] {"A", "B"}));
			} catch (Exception e) {
				ok = true;
			}
			assertTrue(ok);
		}

		{
			PartialOrder po = DataFactory.eINSTANCE.createPartialOrder();
			Order ex1 = DataFactory.eINSTANCE.createOrder();
			ex1.setObjectID( DataPath.makeId( new String[] {"B", "A"}));
			Order ex2 = DataFactory.eINSTANCE.createOrder();
			ex2.setObjectID( DataPath.makeId( new String[] {"B", "B"}));
			
			po.getOrderList().add(ex1);
			po.getOrderList().add(ex2);
			
			ex2.setObjectID(DataPath.makeId( new String[] {"A", "A"}));
			ex2.setObjectID(DataPath.makeId( new String[] {"B", "B"}));
			boolean ok = false;
			try {
				ex2.setObjectID(DataPath.makeId( new String[] {"B", "A"}));
			} catch (Exception e) {
				ok = true;
			}
			assertTrue(ok);
		}

		// with resource !
		
		{
			PartialOrder po = DataFactory.eINSTANCE.createPartialOrder();
			Order ex1 = DataFactory.eINSTANCE.createOrder();
			ex1.setObjectID( DataPath.makeId( new String[] {"A", "B"}));
			Order ex2 = DataFactory.eINSTANCE.createOrder();
			ex2.setObjectID( DataPath.makeId( new String[] {"B", "B"}));
			
			// set resource !!!
			IVTResource mxri = createResource();
			mxri.getContents().add(po);

			po.getOrderList().add(ex1);
			po.getOrderList().add(ex2);
			
			ex2.setObjectID(DataPath.makeId( new String[] {"A", "A"}));
			boolean ok = false;
			try {
				ex2.setObjectID(DataPath.makeId( new String[] {"A", "B"}));
			} catch (RuntimeException e) {
				ok = true;
			}
			assertTrue(ok);
		}

		{
			PartialOrder po = DataFactory.eINSTANCE.createPartialOrder();
			Order ex1 = DataFactory.eINSTANCE.createOrder();
			ex1.setObjectID( DataPath.makeId( new String[] {"B", "A"}));
			Order ex2 = DataFactory.eINSTANCE.createOrder();
			ex2.setObjectID( DataPath.makeId( new String[] {"B", "B"}));
			
			// set resource !!!
			IVTResource mxri = createResource();
			mxri.getContents().add(po);

			po.getOrderList().add(ex1);
			po.getOrderList().add(ex2);
			
			ex2.setObjectID(DataPath.makeId( new String[] {"A", "A"}));
			boolean ok = false;
			try {
				ex2.setObjectID(DataPath.makeId( new String[] {"B", "A"}));
			} catch (RuntimeException e) {
				ok = true;
			}
			assertTrue(ok);
		}
	}
	
	@Test
	public void testProcMap() {
		{
			Mapping etl = DataFactory.eINSTANCE.createMapping();
			ProcMap ex1 = DataFactory.eINSTANCE.createProcMap();
			ex1.setObjectID( DataPath.makeId( new String[] {"A", "B"}));
			ProcMap ex2 = DataFactory.eINSTANCE.createProcMap();
			ex2.setObjectID( DataPath.makeId( new String[] {"B", "B"}));
			
			etl.getProcMapList().add(ex1);
			etl.getProcMapList().add(ex2);
			
			ex2.setObjectID(DataPath.makeId( new String[] {"A", "A"}));
			ex2.setObjectID(DataPath.makeId( new String[] {"B", "B"}));
			boolean ok = false;
			try {
				ex2.setObjectID(DataPath.makeId( new String[] {"A", "B"}));
			} catch (Exception e) {
				ok = true;
			}
			assertTrue(ok);
		}

		{
			Mapping etl = DataFactory.eINSTANCE.createMapping();
			ProcMap ex1 = DataFactory.eINSTANCE.createProcMap();
			ex1.setObjectID( DataPath.makeId( new String[] {"B", "A"}));
			ProcMap ex2 = DataFactory.eINSTANCE.createProcMap();
			ex2.setObjectID( DataPath.makeId( new String[] {"B", "B"}));
			
			etl.getProcMapList().add(ex1);
			etl.getProcMapList().add(ex2);
			
			ex2.setObjectID(DataPath.makeId( new String[] {"A", "A"}));
			boolean ok = false;
			try {
				ex2.setObjectID(DataPath.makeId( new String[] {"B", "A"}));
			} catch (Exception e) {
				ok = true;
			}
			assertTrue(ok);
		}

		// with resource !
		
		{
			Mapping etl = DataFactory.eINSTANCE.createMapping();
			ProcMap ex1 = DataFactory.eINSTANCE.createProcMap();
			ex1.setObjectID( DataPath.makeId( new String[] {"A", "B"}));
			ProcMap ex2 = DataFactory.eINSTANCE.createProcMap();
			ex2.setObjectID( DataPath.makeId( new String[] {"B", "B"}));
			
			// set resource !!!
			IVTResource mxri = createResource();
			mxri.getContents().add(etl);
			
			etl.getProcMapList().add(ex1);
			etl.getProcMapList().add(ex2);
			
			ex2.setObjectID(DataPath.makeId( new String[] {"A", "A"}));
			boolean ok = false;
			try {
				ex2.setObjectID(DataPath.makeId( new String[] {"A", "B"}));
			} catch (RuntimeException e) {
				ok = true;
			}
			assertTrue(ok);
		}

		{
			Mapping etl = DataFactory.eINSTANCE.createMapping();
			ProcMap ex1 = DataFactory.eINSTANCE.createProcMap();
			ex1.setObjectID( DataPath.makeId( new String[] {"B", "A"}));
			ProcMap ex2 = DataFactory.eINSTANCE.createProcMap();
			ex2.setObjectID( DataPath.makeId( new String[] {"B", "B"}));
			
			// set resource !!!
			IVTResource mxri = createResource();
			mxri.getContents().add(etl);
			
			etl.getProcMapList().add(ex1);
			etl.getProcMapList().add(ex2);
			
			ex2.setObjectID(DataPath.makeId( new String[] {"A", "A"}));
			boolean ok = false;
			try {
				ex2.setObjectID(DataPath.makeId( new String[] {"B", "A"}));
			} catch (RuntimeException e) {
				ok = true;
			}
			assertTrue(ok);
		}
	}
	
	@Test
	public void testTaskMap() {
		{
			Mapping etl = DataFactory.eINSTANCE.createMapping();
			TaskMap ex1 = DataFactory.eINSTANCE.createTaskMap();
			ex1.setObjectID( DataPath.makeId( new String[] {"A", "B"}));
			TaskMap ex2 = DataFactory.eINSTANCE.createTaskMap();
			ex2.setObjectID( DataPath.makeId( new String[] {"B", "B"}));
			
			etl.getTaskMapList().add(ex1);
			etl.getTaskMapList().add(ex2);
			
			ex2.setObjectID(DataPath.makeId( new String[] {"A", "A"}));
			ex2.setObjectID(DataPath.makeId( new String[] {"V", "B"}));
			boolean ok = false;
			try {
				ex2.setObjectID(DataPath.makeId( new String[] {"A", "B"}));
			} catch (Exception e) {
				ok = true;
			}
			assertTrue(ok);
		}

		{
			Mapping etl = DataFactory.eINSTANCE.createMapping();
			TaskMap ex1 = DataFactory.eINSTANCE.createTaskMap();
			ex1.setObjectID( DataPath.makeId( new String[] {"B", "A"}));
			TaskMap ex2 = DataFactory.eINSTANCE.createTaskMap();
			ex2.setObjectID( DataPath.makeId( new String[] {"B", "B"}));
			
			etl.getTaskMapList().add(ex1);
			etl.getTaskMapList().add(ex2);
			
			ex2.setObjectID(DataPath.makeId( new String[] {"A", "A"}));
			boolean ok = false;
			try {
				ex2.setObjectID(DataPath.makeId( new String[] {"B", "A"}));
			} catch (Exception e) {
				ok = true;
			}
			assertTrue(ok);
		}

		// with resource !
		
		{
			Mapping etl = DataFactory.eINSTANCE.createMapping();
			TaskMap ex1 = DataFactory.eINSTANCE.createTaskMap();
			ex1.setObjectID( DataPath.makeId( new String[] {"A", "B"}));
			TaskMap ex2 = DataFactory.eINSTANCE.createTaskMap();
			ex2.setObjectID( DataPath.makeId( new String[] {"B", "B"}));
			
			// set resource !!!
			IVTResource mxri = createResource();
			mxri.getContents().add(etl);
			
			etl.getTaskMapList().add(ex1);
			etl.getTaskMapList().add(ex2);
			
			ex2.setObjectID(DataPath.makeId( new String[] {"A", "A"}));
			boolean ok = false;
			try {
				ex2.setObjectID(DataPath.makeId( new String[] {"A", "B"}));
			} catch (RuntimeException e) {
				ok = true;
			}
			assertTrue(ok);
		}

		{
			Mapping etl = DataFactory.eINSTANCE.createMapping();
			TaskMap ex1 = DataFactory.eINSTANCE.createTaskMap();
			ex1.setObjectID( DataPath.makeId( new String[] {"B", "A"}));
			TaskMap ex2 = DataFactory.eINSTANCE.createTaskMap();
			ex2.setObjectID( DataPath.makeId( new String[] {"B", "B"}));
			
			// set resource !!!
			IVTResource mxri = createResource();
			mxri.getContents().add(etl);
			
			etl.getTaskMapList().add(ex1);
			etl.getTaskMapList().add(ex2);
			
			ex2.setObjectID(DataPath.makeId( new String[] {"A", "A"}));
			boolean ok = false;
			try {
				ex2.setObjectID(DataPath.makeId( new String[] {"B", "A"}));
			} catch (RuntimeException e) {
				ok = true;
			}
			assertTrue(ok);
		}
	}

	@Test
	public void testTimeConsElement() {
		{
			TimeConst etl = DataFactory.eINSTANCE.createTimeConst();
			TimeConstElement ex1 = DataFactory.eINSTANCE.createTimeConstElement();
			ex1.setObjectID( DataPath.makeId( new String[] {"A", "B", "B"}));
			TimeConstElement ex2 = DataFactory.eINSTANCE.createTimeConstElement();
			ex2.setObjectID( DataPath.makeId( new String[] {"B", "B", "B"}));
			
			etl.getTimeConstElementList().add(ex1);
			etl.getTimeConstElementList().add(ex2);
			
			ex2.setObjectID(DataPath.makeId( new String[] {"A", "A", "A"}));
			ex2.setObjectID(DataPath.makeId( new String[] {"A", "B", "A"}));
			boolean ok = false;
			try {
				ex2.setObjectID(DataPath.makeId( new String[] {"A", "B", "B"}));
			} catch (Exception e) {
				ok = true;
			}
			assertTrue(ok);
		}

		{
			TimeConst etl = DataFactory.eINSTANCE.createTimeConst();
			TimeConstElement ex1 = DataFactory.eINSTANCE.createTimeConstElement();
			ex1.setObjectID( DataPath.makeId( new String[] {"B", "A", "B"}));
			TimeConstElement ex2 = DataFactory.eINSTANCE.createTimeConstElement();
			ex2.setObjectID( DataPath.makeId( new String[] {"B", "B", "B"}));
			
			etl.getTimeConstElementList().add(ex1);
			etl.getTimeConstElementList().add(ex2);
			
			ex2.setObjectID(DataPath.makeId( new String[] {"A", "A", "A"}));
			boolean ok = false;
			try {
				ex2.setObjectID(DataPath.makeId( new String[] {"B", "A", "B"}));
			} catch (Exception e) {
				ok = true;
			}
			assertTrue(ok);
		}

		{
			TimeConst etl = DataFactory.eINSTANCE.createTimeConst();
			TimeConstElement ex1 = DataFactory.eINSTANCE.createTimeConstElement();
			ex1.setObjectID( DataPath.makeId( new String[] {"B", "B", "A"}));
			TimeConstElement ex2 = DataFactory.eINSTANCE.createTimeConstElement();
			ex2.setObjectID( DataPath.makeId( new String[] {"B", "B", "B"}));
			
			etl.getTimeConstElementList().add(ex1);
			etl.getTimeConstElementList().add(ex2);
			
			ex2.setObjectID(DataPath.makeId( new String[] {"A", "A", "A"}));
			boolean ok = false;
			try {
				ex2.setObjectID(DataPath.makeId( new String[] {"B", "B", "A"}));
			} catch (Exception e) {
				ok = true;
			}
			assertTrue(ok);
		}

		// with resource !
		
		{
			TimeConst etl = DataFactory.eINSTANCE.createTimeConst();
			TimeConstElement ex1 = DataFactory.eINSTANCE.createTimeConstElement();
			ex1.setObjectID( DataPath.makeId( new String[] {"A", "B", "B"}));
			TimeConstElement ex2 = DataFactory.eINSTANCE.createTimeConstElement();
			ex2.setObjectID( DataPath.makeId( new String[] {"B", "B", "B"}));
			
			// set resource !!!
			IVTResource mxri = createResource();
			mxri.getContents().add(etl);
			
			etl.getTimeConstElementList().add(ex1);
			etl.getTimeConstElementList().add(ex2);
			
			ex2.setObjectID(DataPath.makeId( new String[] {"A", "A", "A"}));
			boolean ok = false;
			try {
				ex2.setObjectID(DataPath.makeId( new String[] {"A", "B", "B"}));
			} catch (RuntimeException e) {
				ok = true;
			}
			assertTrue(ok);
		}
		
		{
			TimeConst etl = DataFactory.eINSTANCE.createTimeConst();
			TimeConstElement ex1 = DataFactory.eINSTANCE.createTimeConstElement();
			ex1.setObjectID( DataPath.makeId( new String[] {"B", "A", "B"}));
			TimeConstElement ex2 = DataFactory.eINSTANCE.createTimeConstElement();
			ex2.setObjectID( DataPath.makeId( new String[] {"B", "B", "B"}));
			
			// set resource !!!
			IVTResource mxri = createResource();
			mxri.getContents().add(etl);
			
			etl.getTimeConstElementList().add(ex1);
			etl.getTimeConstElementList().add(ex2);
			
			ex2.setObjectID(DataPath.makeId( new String[] {"A", "A", "A"}));
			boolean ok = false;
			try {
				ex2.setObjectID(DataPath.makeId( new String[] {"B", "A", "B"}));
			} catch (RuntimeException e) {
				ok = true;
			}
			assertTrue(ok);
		}
		
		{
			TimeConst etl = DataFactory.eINSTANCE.createTimeConst();
			TimeConstElement ex1 = DataFactory.eINSTANCE.createTimeConstElement();
			ex1.setObjectID( DataPath.makeId( new String[] {"B", "B", "A"}));
			TimeConstElement ex2 = DataFactory.eINSTANCE.createTimeConstElement();
			ex2.setObjectID( DataPath.makeId( new String[] {"B", "B", "B"}));
			
			// set resource !!!
			IVTResource mxri = createResource();
			mxri.getContents().add(etl);
			
			etl.getTimeConstElementList().add(ex1);
			etl.getTimeConstElementList().add(ex2);
			
			ex2.setObjectID(DataPath.makeId( new String[] {"A", "A", "A"}));
			boolean ok = false;
			try {
				ex2.setObjectID(DataPath.makeId( new String[] {"B", "B", "A"}));
			} catch (RuntimeException e) {
				ok = true;
			}
			assertTrue(ok);
		}
	}

	@Test
	public void testVarMap() {
		{
			Mapping etl = DataFactory.eINSTANCE.createMapping();
			VarMap ex1 = DataFactory.eINSTANCE.createVarMap();
			ex1.setObjectID( DataPath.makeId( new String[] {"A", "B"}));
			VarMap ex2 = DataFactory.eINSTANCE.createVarMap();
			ex2.setObjectID( DataPath.makeId( new String[] {"B", "B"}));
			
			etl.getVarMapList().add(ex1);
			etl.getVarMapList().add(ex2);
			
			ex2.setObjectID(DataPath.makeId( new String[] {"A", "A"}));
			boolean ok = false;
			try {
				ex2.setObjectID(DataPath.makeId( new String[] {"A", "B"}));
			} catch (Exception e) {
				ok = true;
			}
			assertTrue(ok);

		}

		{
			Mapping etl = DataFactory.eINSTANCE.createMapping();
			VarMap ex1 = DataFactory.eINSTANCE.createVarMap();
			ex1.setObjectID( DataPath.makeId( new String[] {"B", "A"}));
			VarMap ex2 = DataFactory.eINSTANCE.createVarMap();
			ex2.setObjectID( DataPath.makeId( new String[] {"B", "B"}));
			
			etl.getVarMapList().add(ex1);
			etl.getVarMapList().add(ex2);
			
			ex2.setObjectID(DataPath.makeId( new String[] {"A", "A"}));
			boolean ok = false;
			try {
				ex2.setObjectID(DataPath.makeId( new String[] {"B", "A"}));
			} catch (Exception e) {
				ok = true;
			}
			assertTrue(ok);

		}

		// with resource !
		
		{
			Mapping etl = DataFactory.eINSTANCE.createMapping();
			VarMap ex1 = DataFactory.eINSTANCE.createVarMap();
			ex1.setObjectID( DataPath.makeId( new String[] {"A", "B"}));
			VarMap ex2 = DataFactory.eINSTANCE.createVarMap();
			ex2.setObjectID( DataPath.makeId( new String[] {"B", "B"}));
			
			// set resource !!!
			IVTResource mxri = createResource();
			mxri.getContents().add(etl);
			
			etl.getVarMapList().add(ex1);
			etl.getVarMapList().add(ex2);
			
			ex2.setObjectID(DataPath.makeId( new String[] {"A", "A"}));
			boolean ok = false;
			try {
				ex2.setObjectID(DataPath.makeId( new String[] {"A", "B"}));
			} catch (RuntimeException e) {
				ok = true;
			}
			assertTrue(ok);
		}

		{
			Mapping etl = DataFactory.eINSTANCE.createMapping();
			VarMap ex1 = DataFactory.eINSTANCE.createVarMap();
			ex1.setObjectID( DataPath.makeId( new String[] {"B", "A"}));
			VarMap ex2 = DataFactory.eINSTANCE.createVarMap();
			ex2.setObjectID( DataPath.makeId( new String[] {"B", "B"}));
			
			// set resource !!!
			IVTResource mxri = createResource();
			mxri.getContents().add(etl);
			
			etl.getVarMapList().add(ex1);
			etl.getVarMapList().add(ex2);
			
			ex2.setObjectID(DataPath.makeId( new String[] {"A", "A"}));
			boolean ok = false;
			try {
				ex2.setObjectID(DataPath.makeId( new String[] {"B", "A"}));
			} catch (RuntimeException e) {
				ok = true;
			}
			assertTrue(ok);
		}
	}

	/**
	 * @param ok
	 */
	private void assertTrue(boolean ok) {
		// TODO Auto-generated method stub
		
	}


	protected IVTResource createResource() {
		return (IVTResource) new RTD_XMI_Factory().createResource();
	}
}