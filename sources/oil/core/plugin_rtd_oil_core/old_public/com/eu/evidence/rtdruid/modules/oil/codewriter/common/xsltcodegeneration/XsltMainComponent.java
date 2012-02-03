package com.eu.evidence.rtdruid.modules.oil.codewriter.common.xsltcodegeneration;

import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SWCategoryManager;
import com.eu.evidence.rtdruid.modules.oil.interfaces.ISWCategory;

/**
 * This component contains also others xslt writer parameters, like ISWCategory
 * 
 * @author Nicola Serreli
 * 
 */
public class XsltMainComponent extends XsltComponent {
	
	protected ISWCategory category;

	public XsltMainComponent(String id, ISWCategory category) {
		super(id);
		if (category == null) {
			category = SWCategoryManager.defaultInstance.newCategory((String)null, SWCategoryManager.defaultPriority);
		}
		this.category = category;
	}
	
	public ISWCategory getCategory() {
		return category;
	}
}
