package com.eu.evidence.rtdruid.modules.oil.implementations;

import java.io.File;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.util.Properties;

import junit.framework.TestCase;

import com.eu.evidence.rtdruid.desk.RTDFactory;
import com.eu.evidence.rtdruid.internal.modules.oil.implementation.OilImplFactory_Impl;
import com.eu.evidence.rtdruid.internal.modules.oil.implementation.OilImplPointer;
import com.eu.evidence.rtdruid.internal.modules.oil.reader.OilReader;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OilImplFactory;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OilImplID;
import com.eu.evidence.rtdruid.modules.oil.interfaces.IOilImplElementDescr;
import com.eu.evidence.rtdruid.modules.oil.interfaces.IOilImplPointer;
import com.eu.evidence.rtdruid.modules.oil.interfaces.IOilImplementation;
import com.eu.evidence.rtdruid.vartree.IVarTree;

public class mp_oil_Test extends TestCase implements FilenameFilter {

	private int count_org;
	private int count_ni;
	private int count_mi;

	public boolean accept(File dir, String name) {
		return ( (name.length() > 4) && (name.endsWith(".oil")) );
	}

	public void test_list_load() {
		String base_path = "com/eu/evidence/rtdruid/modules/oil/implementation/components/";
		//String base = null;
		 //File file = new File(base + base_path);
         //String[] file_list = file.list(this);
		 String[] file_list = {
				 				"ee_Implementation.oil",
				 				"arm7.oil",
				 				"avr.oil",
				 				"dspic.oil",
				 				"fp_edf.oil",
				 				"iris_cbs.oil",
				 				"nios.oil",
				 				"osek.oil",
				 				"ppc.oil",
		};
         int l = file_list.length;
         for (int i = 0; i < l; i++) {
        	 try {
        		 System.out.print("\nTrying to load file: " + file_list[i]);
        		 IVarTree vt = (IVarTree) RTDFactory.get(IVarTree.class);
        		 assertNotNull(vt);
        		 InputStream is = this.getClass().getClassLoader().getResourceAsStream(base_path + file_list[i]);
        		 assertNotNull(is);
        		 (new OilReader()).load(is, vt);
        		 is.close();
        	 }
        	 catch(Exception e) {
        		 System.out.print(e.getMessage());
        	 }
         }
         System.out.print("\n\n");
         return;
	}

	public void test() {
		IVarTree vt = (IVarTree) RTDFactory.get(IVarTree.class);
		
		OilImplID[] oids = OilImplFactory_Impl.getAnInstance(vt).getImplNames();
		assertTrue(oids != null);
	    assertTrue(oids.length == 0);
		final String filename = "com/eu/evidence/rtdruid/modules/oil/templates/ee_appl.oil";

	    try {
	    	InputStream reader = this.getClass().getClassLoader().getResourceAsStream(filename);
	    	(new OilReader()).load(reader, vt);
	        reader.close();
		} catch (Exception e) {
			System.out.println("opening file failed");
		}

		OilImplFactory oif = OilImplFactory_Impl.getAnInstance(vt);
		OilImplFactory oif2 = OilImplFactory_Impl.getAnInstance(vt);
		OilImplID[] oif_ids = oif.getImplNames();
		OilImplID[] oif_ids2 = oif2.getImplNames();
		IOilImplPointer oip = oif.getImpl(oif_ids[0]).getPointer();
		IOilImplPointer oip2 = oif2.getImpl(oif_ids2[0]).getPointer();

		{ // core tests
			visit_vt(oip);
			try {
				
				count_org = 0;
				count_ni = 0;
				count_mi = 0;
				assertTrue("Identity Comparing failed (OIF)", compare_oif(oif, oif2));
				assertTrue("Different visit number:\norg = " + count_org + "\nni = " + count_ni + "\nmi = " +  count_mi,
						(count_org == count_ni) && (count_mi == count_ni));
				
				assertTrue("Identity Comparing failed (OIF)", compare_oif(oif, oif2));
				assertTrue("Identity Comparing failed (OIP)", compare_vt_pointer(oip, oip2));

				IVarTree vt2 = (IVarTree) RTDFactory.get(IVarTree.class);
			    try {
			    	InputStream reader = this.getClass().getClassLoader().getResourceAsStream(filename);
			    	(new OilReader()).load(reader, vt2);
			        reader.close();
				} catch (Exception e) {
					System.out.println("opening/parsing file failed");
				}

				OilImplFactory oif_clone = OilImplFactory_Impl.getAnInstance(vt2);
				IOilImplPointer oip_clone = oif_clone.getImpl(oif_ids[0]).getPointer();
//				oip_clone.goFirstChild();
				((OilImplPointer) oip_clone).setName("abc");
				System.out.println(oif_clone.getImpl(oif_ids[0]).toOil());
				assertFalse("Different object resulted equals (OIF)", compare_oif(oif_clone, oif));
			}
			catch(Exception e) {
				e.printStackTrace();
			}

			boolean ok = false;
			try {
				compare_oif(null, null);
			}
			catch(NullPointerException e) {
				ok = true;
				System.out.println("null pointer exception");
			}
			assertTrue(ok);

			ok = false;
			try {
				compare_oif(null, oif);
			}
			catch(NullPointerException e) {
				ok = true;
				System.out.println("null pointer exception");
			}
			assertTrue(ok);

			ok = false;
			try {
				compare_oif(oif, null);
			}
			catch(NullPointerException e) {
				ok = true;
				System.out.println("null pointer exception");
			}
			assertTrue(ok);
		}
		
		vt = null;
	}
	
	
	public void test_merge() {
		IVarTree vt_orig = (IVarTree) RTDFactory.get(IVarTree.class);
		IVarTree vt_merge = (IVarTree) RTDFactory.get(IVarTree.class);

		final String filename_arm = "com/eu/evidence/rtdruid/modules/oil/templates/arm7.oil";
		final String filename_witout_arm = "com/eu/evidence/rtdruid/modules/oil/templates/ee_appl_senza_arm7.oil";
		final String filename_all = "com/eu/evidence/rtdruid/modules/oil/templates/ee_appl.oil";

		 try {
			ClassLoader loader = this.getClass().getClassLoader();
			InputStream reader = null;

			// VT Merge (arm7)
//	    	reader = loader.getResourceAsStream(filename_arm);
//	    	(new OilReader()).load(reader, vt_merge);
//	    	reader.close();

			// VT Merge (all but arm7)
//	    	reader = loader.getResourceAsStream(filename_witout_arm);
//	    	(new OilReader()).load(reader, vt_merge);
//	    	reader.close();

			// VT orig (all)	    	
	    	reader = loader.getResourceAsStream(filename_all);
	    	(new OilReader()).load(reader, vt_orig);
	    	reader.close();
	    	
		} catch (Exception e) {
			System.out.println("opening/parsing file failed");
		}
		OilImplFactory oif_m = OilImplFactory_Impl.getAnInstance(vt_merge);
		OilImplFactory oif_o = OilImplFactory_Impl.getAnInstance(vt_orig);
		count_org = 0;
		count_ni = 0;
		count_mi = 0;
		assertFalse(compare_oif(oif_m, oif_o));
		assertTrue("Different visit number:\norg = " + count_org + "\nni = " + count_ni + "\nmi = " +  count_mi,
				(count_org == count_ni) && (count_mi == count_ni));
	}

	public void visit_vt(IOilImplPointer oip) throws NullPointerException {
		IOilImplElementDescr[] descrs = oip.getChildrenDescr();
		int l = descrs.length;

		for (int i = 0; i < l; i++) {
			IOilImplPointer oip2 = (IOilImplPointer)oip.clone();
			if (!oip2.goChild(descrs[i].getName()))
				System.out.println("Error while going to: " + descrs[i].getName());
			visit_vt(oip2);
		}

		return;

	}

	public boolean compare_oif(OilImplFactory oif1, OilImplFactory oif2) throws NullPointerException {
		OilImplID[] oif1_ids = oif1.getImplNames();
		OilImplID[] oif2_ids = oif2.getImplNames();
		if ( (oif1_ids == null) || (oif2_ids == null) )
			throw new NullPointerException();
		int l = oif1_ids.length;
		if (l != oif2_ids.length) {
			System.out.println("Implementations number mismatch.");
			return false;
		}

		for (int i = 0; i < l; i++) {
			IOilImplPointer oip1 = oif1.getImpl(oif1_ids[i]).getPointer();
			IOilImplementation id2 = null;

			for (int j = 0; j < l; j++) {
				id2 = oif2.getImpl(oif1_ids[i]);
				if (id2 != null)
					break;
			}
			if (id2 == null) {
				System.out.println("Missing Implementation ID: " + oif1_ids[i]);
				return false;
			}

			IOilImplPointer oip2 = id2.getPointer();
//			if (!compare_vt_pointer(oip1, oip2))
//				return false;
			
			boolean org = compare_vt_pointer(oip1, oip2);
			boolean ni  = compare_vt_pointer_ni(oip1, oip2);
			boolean mi  = compare_vt_pointer_mi(oip1, oip2);
			if (!( (org == ni) && (ni == mi) ) ) {
				System.out.println("Two different results for " + oif1_ids[i] + ":\norg = " + org + " ni = " + ni + " mi = " + mi);
				return false;
			}
			return org;
		}

		return true;

	}

	public boolean compare_vt_pointer_ni(IOilImplPointer oip1, IOilImplPointer oip2) throws NullPointerException {
		count_ni++;
		IOilImplElementDescr descrs1 = oip1.getCurrentDescr();
		IOilImplElementDescr descrs2 = oip2.getCurrentDescr();
		if (!compare_desc(descrs1, descrs2)) {
			return false;
		}
		
		if (oip1.getChildrenDescr().length !=  oip2.getChildrenDescr().length) {
			System.out.println("Different children number.");
			return false;
		}

		IOilImplPointer oip_child = (IOilImplPointer) oip1.clone();
		for (boolean go = oip_child.goFirstChild(); go; go=oip_child.goNextSibling()) {
		
			IOilImplPointer oip_child2 = (IOilImplPointer) oip2.clone();
			if (!oip_child2.goChild(oip_child.getCurrentDescr().getName()))
				return false;
			if (!compare_vt_pointer_ni(oip_child, oip_child2)) {
				return false;
			}
		}

		return true;

	}
	
	public boolean compare_vt_pointer_mi(IOilImplPointer oip1, IOilImplPointer oip2) throws NullPointerException {
		count_mi++;
		
		if (!compare_desc(oip1.getCurrentDescr(), oip2.getCurrentDescr()))
			return false;

		if (oip1.getChildrenDescr().length !=  oip2.getChildrenDescr().length) {
			System.out.println("Different children number.");
			return false;
		}

		IOilImplPointer oip1_clone = (IOilImplPointer)oip1.clone();
		if (oip1_clone.goFirstChild())
			do {
				IOilImplPointer oip2_clone = (IOilImplPointer)oip2.clone();
				if (!oip2_clone.goChild(oip1_clone.getCurrentDescr().getName()))
					return false;
				if (!compare_vt_pointer_mi(oip1_clone, oip2_clone))
					return false;
			}
			while (oip1_clone.goNextSibling());

		return true;

	}

	public boolean compare_vt_pointer(IOilImplPointer oip1, IOilImplPointer oip2) throws NullPointerException {
		count_org++;
		if (!compare_desc(oip1.getCurrentDescr(), oip2.getCurrentDescr()))
			return false;
		IOilImplElementDescr[] descrs1 = oip1.getChildrenDescr();
		IOilImplElementDescr[] descrs2 = oip2.getChildrenDescr();
		int i, j, l = descrs1.length;
		if (l != descrs2.length) {
			System.out.println("Different children number.");
			return false;
		}

		for (i = 0; i < l; i++) {
			boolean found = false;
			for (j = 0; j < l; j++) {
				if (compare_desc(descrs1[i], descrs2[j])) {
					found = true;
					break;
				}
			}
			if (!found) {
				System.out.println("Missing Child: " + descrs1[i].getName());
				return false;
			}

			IOilImplPointer oipc1 = (IOilImplPointer)oip1.clone();
			IOilImplPointer oipc2 = (IOilImplPointer)oip2.clone();
			if (!(oipc1.goChild(descrs1[i].getName()))) {
				System.out.println("Unable to seek to child: " + descrs1[i].getName());
			}
			if (!(oipc2.goChild(descrs2[j].getName()))) {
				System.out.println("Unable to seek to child: " + descrs2[j].getName());
			}
			if (!compare_vt_pointer(oipc1, oipc2))
				return false;
		}

		return true;

	}

	private boolean compare_desc(IOilImplElementDescr descrs1, IOilImplElementDescr descrs2) throws NullPointerException {
		if (
				( (descrs1.getName() == null) && (descrs2.getName() != null) ) ||
				( (descrs2.getName() != null) && (descrs2.getName() == null) )
		)
			return false;
		if (descrs1.getName() != null)
			if (!(descrs1.getName().equals(descrs2.getName())))
				return false;

		if (descrs1.getType() != descrs2.getType())
			return false;

		Properties p1 = descrs1.getAttributes();
		Properties p2 = descrs2.getAttributes();
		if ( ((p1 == null) && (p2 != null)) || ((p1 != null) && (p2 == null)) )
			return false;
		if (p1 != null)
			return p1.equals(p2);
		return true;
	}

}
