package com.eu.evidence.rtdruid.modules.oil.erikaenterprise.location;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.variables.IStringVariableManager;
import org.eclipse.core.variables.VariablesPlugin;
import org.osgi.framework.Bundle;

import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.modules.oil.codewriter.options.PreferenceStorage;


/**
 * 
 * This class 
 * 
 * @author Nicola Serreli
 */
public final class EEPaths {
	
	final static String CONFIG_FILE___EE_LOCATION = "erika_enterprise_location";
	public final static String ENV___EE_LOCATION = "ERIKA_FILES";
	private static final Integer SEMAPHORE = new Integer(1);

	
	
	
	public static String getEe_base() {
		if (eeSrcPaths == null) {
			doInit();
		}
		if (eeSrcPaths.size() > 0) {
			return eeSrcPaths.get(0).erikaFilesLocation;
		}
		return null;
	}

	public static List<EE_src_distr> getAllEe_base() {
		doInit();
		return Collections.unmodifiableList(eeSrcPaths);
	}
	
	
	private static ArrayList<EE_src_distr> eeSrcPaths = null;
	
	private static void doInit() {
		/*
		 * NOTE: This class uses VariableManager to resolve eclipse_location and other variables,
		 * but the user may set erika_enterprise_location variable that uses this class ...
		 * then may have a loop.
		 * 
		 * to avoid this, set eeSrcPaths to an temporary empty array and then prepare
		 * the correct one.
		 */
		boolean reload=false;
		synchronized (SEMAPHORE) {
			if (eeSrcPaths == null) {
				eeSrcPaths = new ArrayList<EE_src_distr>();
				reload = true;
			}
		}
		
		if (reload) {
			eeSrcPaths = parseAllEEsrcExtensions();
		}
	}
	

	static ArrayList<EE_src_distr> parseAllEEsrcExtensions() {
		ArrayList<EE_src_distr> answer = new ArrayList<EE_src_distr>();
		checkConfigurationOptions(answer);
		parseExtSourceDistribution(answer);
		parseSourceDistribution(answer);
		return answer;
	}		

	private static void parseExtSourceDistribution(ArrayList<EE_src_distr> answer) {
	
StringBuffer buffer = new StringBuffer();
		IConfigurationElement[] config = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(
					"com.eu.evidence.rtdruid.oil.ee.core.eeSrc");
		assert (config != null);
		int l = config.length;

buffer.append("Config.length = " + config.length + "\n");
		for (int i = 0; i < l; i++) {
buffer.append("\n__" + i + " = " + config[i].getName() + "  " + config[i] +"\n");
			if ("extSourceDistribution".equals(config[i].getName())) {
				String bundleName = "";
				String srcAttr = "";
				String contribs = "";
				try {
					srcAttr = config[i].getAttribute("erikaFiles");
					String version = config[i].getAttribute("VersionFile");
					contribs = config[i].getAttribute("contribs");
					
buffer.append("_____Src " + " = " + srcAttr +"\n");
buffer.append("_____Vrs " + " = " + version +"\n");
buffer.append("_____cntr" + " = " + contribs +"\n");
					
					if (srcAttr == null && contribs == null) {
						continue;
					}
					
					
					IStringVariableManager isvm = VariablesPlugin.getDefault().getStringVariableManager();
					if (isvm != null) {
						if (srcAttr != null) {
							try {
								srcAttr = isvm.performStringSubstitution(srcAttr, true);
							} catch (Exception e) {
								RtdruidLog.log(e);
							}
						}
						if (contribs != null) {
							try {
								contribs = isvm.performStringSubstitution(contribs, true);
							} catch (Exception e) {
								RtdruidLog.log(e);
							}
						}
					}
					
					
					String srcBase = null;
					if (srcAttr != null) {
						File base = new File(srcAttr);
						if (base.exists() && base.isDirectory() && base.canRead()) {
							srcBase = base.getCanonicalPath();
						}
buffer.append("_____Src path = "+srcBase +"\n");
					}
					
					String contrBase = null;
					if (contribs != null) {
						File base = new File(contribs);
						if (base.exists() && base.isDirectory() && base.canRead()) {
							contrBase = base.getCanonicalPath();
buffer.append("_____Contr path = "+contrBase +"\n");
						}
					}
										
					answer.add(new EE_src_distr(version, srcBase, contrBase, EE_src_distr.Reporter.EXTPOINT_FILESYSTEM_SOURCES));
					
				} catch (Exception e) {
					RtdruidLog.log("Unable to get the specified source/contribution directory:\n bundle= " + 
							bundleName + "\n source= " + srcAttr + "\n contribs= " + contribs,
							e);
				}
			}
		}
	}

	
	private static void parseSourceDistribution(ArrayList<EE_src_distr> answer) {
	
StringBuffer buffer = new StringBuffer();
		IConfigurationElement[] config = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(
					"com.eu.evidence.rtdruid.oil.ee.core.eeSrc");
		assert (config != null);
		int l = config.length;

buffer.append("Config.length = " + config.length + "\n");
		for (int i = 0; i < l; i++) {
buffer.append("\n__" + i + " = " + config[i].getName() + "  " + config[i] +"\n");
			if ("sourceDistribution".equals(config[i].getName())) {
				String bundleName = "";
				String srcAttr = "";
				String contribs = "";
				try {
					srcAttr = config[i].getAttribute("erikaFiles");
					String version = config[i].getAttribute("VersionFile");
					contribs = config[i].getAttribute("contribs");
					
buffer.append("_____Src " + " = " + srcAttr +"\n");
buffer.append("_____Vrs " + " = " + version +"\n");
buffer.append("_____cntr" + " = " + contribs +"\n");
					
					if (srcAttr == null && contribs == null) {
						continue;
					}

					bundleName = config[i].getContributor().getName();
					Bundle bundle = Platform.getBundle(bundleName);
					assert (bundle != null);

					File f = FileLocator.getBundleFile(bundle);
					String bundlePath = null;
					if (f != null) {
						bundlePath = f.getAbsolutePath();
					}

					String srcBase = null;
					if (srcAttr != null) {
						if (FileLocator.find(bundle, new Path(srcAttr),
								new HashMap<Object, Object>()) == null) {
buffer.append("_____Bundle not found" +"\n");
							continue;
						}
						
						File base = new File(bundlePath + File.separatorChar + srcAttr);
						if (base.exists() && base.canRead()) {
							srcBase = base.getAbsolutePath();
buffer.append("_____Src path = "+srcBase +"\n");
						}
					}
					
					String contrBase = null;
					if (contribs != null) {
						if (FileLocator.find(bundle, new Path(contribs),
								new HashMap<Object, Object>()) == null) {
buffer.append("_____Bundle not found" +"\n");
							continue;
						}
						
						File base = new File(bundlePath + File.separatorChar + contribs);
						if (base.exists() && base.canRead()) {
							contrBase = base.getAbsolutePath();
buffer.append("_____Contr path = "+contrBase +"\n");
						}
					}
					
					
					answer.add(new EE_src_distr(version, srcBase, contrBase, EE_src_distr.Reporter.EXTPOINT_PLUGIN_SOURCES));
					
				} catch (Exception e) {
					RtdruidLog.log("Unable to get the specified source/contribution directory:\n bundle= " + 
							bundleName + "\n source= " + srcAttr + "\n contribs= " + contribs,
							e);
				}
			}
		}
	}
	
	private static void checkConfigurationOptions(ArrayList<EE_src_distr> answer) {
		PreferenceStorage prefs = PreferenceStorage.getCommonIstance();
		String base = prefs.getValue(CONFIG_FILE___EE_LOCATION);
		if (base != null) {
			IStringVariableManager isvm = VariablesPlugin.getDefault().getStringVariableManager();
			if (isvm != null) {
				if (base != null) {
					try {
						base = isvm.performStringSubstitution(base, true);
						
						File file = new File(base);
						if (file.exists() && file.isDirectory() && file.canRead()) {
							base = file.getCanonicalPath();
						} else {
							base = null;
						}
					} catch (Exception e) {
						RtdruidLog.log(e);
					}
				}
			}			
			if (base != null) {
				answer.add(new EE_src_distr("", base, null, EE_src_distr.Reporter.RTD_CONFIGURATION));
			}
		}
		
	}

	
}
