package com.eu.evidence.rtdruid.modules.oil.codewriter.common;

import java.util.Properties;

import com.eu.evidence.rtdruid.modules.oil.implementation.IOilImplElementDescr;
import com.eu.evidence.rtdruid.modules.oil.implementation.IOilImplPointer;

/**
 * This pointer is empty and return always false
 * 
 * @author Ni
 *
 */
public class EmptyOilImplPointer implements IOilImplPointer {
	private static class EmptyElemDescr implements IOilImplElementDescr {
		private Properties p = new Properties();
		@Override
		public Properties getAttributes() {
			return p;
		}
		@Override
		public String getName() {
			return null;
		}
		
		@Override
		public int getType() {
			return 0;
		}
		
	}

	@Override
	public boolean goParent() {
		return false;
	}

	@Override
	public boolean goFirstChild() {
		return false;
	}

	@Override
	public boolean goNextSibling() {
		return false;
	}

	@Override
	public boolean goChild(String childName) {
		return false;
	}

	@Override
	public IOilImplElementDescr getCurrentDescr() {
		return new EmptyElemDescr();
	}

	@Override
	public IOilImplElementDescr[] getChildrenDescr() {
		return new IOilImplElementDescr[0];
	}

	@Override
	public IOilImplPointer clone() {
		return new EmptyOilImplPointer();
	}
}
