package com.eu.evidence.rtdruid.internal.modules.oil.implementation;

import static org.junit.Assert.fail;

import org.eclipse.emf.ecore.EPackage;
import org.junit.Test;

import com.eu.evidence.rtdruid.internal.modules.oil.reader.OilInfo;
import com.eu.evidence.rtdruid.internal.modules.oil.reader.OilParser;
import com.eu.evidence.rtdruid.modules.oil.implementation.OilEcoreCreator;
import com.eu.evidence.rtdruid.modules.oil.implementation.OilImplementation;
import com.eu.evidence.rtdruid.modules.oil.interfaces.IOilImplID;
import com.eu.evidence.rtdruid.modules.oil.interfaces.IOilImplementation;

public class OilEcoreCreatorTest {
	class SimpleOilID implements IOilImplID {
		private final String name;
		
		public SimpleOilID(String name) {
			this.name = name;
		}
		
		public int compareTo(IOilImplID o) {
			return name.compareTo(o.getImplementationName());
		}
		
		public String getImplementationName() {
			return name;
		}
		public IOilImplID clone() {
			return new SimpleOilID(name);
		}
		
	}

	@Test
	public void testBuildPackage() {
		String res_path =// "/" + getClass().getPackage().getName().replace(".", "/")+ "/" + 
						"oil_impl_test.oil";
		OilParser op = new OilParser(this.getClass().getResourceAsStream(res_path));
		OilInfo oi = null;
		try {
			oi = op.start();
		} catch (Exception e) {
			fail(e.getMessage());
		}
		IOilImplementation impl = new OilImplementation(new SimpleOilID("test"), oi.getImpl());
		OilEcoreCreator oec = new OilEcoreCreatorImpl(impl);
		EPackage ePkg = oec.buildPackage();
		OilEcoreCreatorImpl.save(ePkg, "./prova.ecore");
	}

}
