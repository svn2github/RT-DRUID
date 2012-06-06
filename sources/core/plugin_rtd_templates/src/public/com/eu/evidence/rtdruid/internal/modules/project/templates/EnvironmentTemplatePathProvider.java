package com.eu.evidence.rtdruid.internal.modules.project.templates;

import java.io.File;

import com.eu.evidence.templates.interfaces.ITemplatePathProvider;

class EnvironmentTemplatePathProvider implements ITemplatePathProvider {

	private static final Object RTD_TEMPLATE_ENV_VARIABLE_ID = "RTDRUID_TEMPLATES_PATH";
	
	@Override
	public int priority() {
		return ENVIRONMENT_PRIORITY;
	}

	@Override
	public boolean isDynamic() {
		return false;
	}

	@Override
	public String[] getPaths() {
		String paths = System.getenv().containsKey(RTD_TEMPLATE_ENV_VARIABLE_ID) ? System.getenv().get(RTD_TEMPLATE_ENV_VARIABLE_ID) : null;
		return paths != null ? paths.split(File.pathSeparator) : new String[0];
	}

}
