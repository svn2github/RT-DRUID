package com.eu.evidence.rtdruid.modules.oil.ee.ui.location;

import com.eu.evidence.rtdruid.modules.oil.ee.ui.location.ErikaEnterpriseLocationHandler.Choice;

public interface IErikaEnterpriseLocationWorkingCopy {

	public void reload();
	
	// -----------------------------------------------
	// -----------------  GET   ----------------------
	// -----------------------------------------------
	
	public Choice getCurrentChoice();

	public String getUserPath();
	public String getResolvedUserPath();

	public String getConfigFileEeLocation();
	public String getPluginEeLocation();

	public String getErikaFilesEnv();

	public String getAutoPath();

	public String getChoosedErikaEnterpriseLocation();
	
	// -----------------------------------------------
	// -----------------  SET   ----------------------
	// -----------------------------------------------

	public void setDefaults();

	public void setCurrentChoice(Choice c);

	public void setUserPath(String path);
}
