package com.eu.evidence.modules.oil.erikaenterprise.constants;

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
	
	final static String CONFIG_FILE___EE_BASE = "eebase";
	
	
//	protected static String evidence_base = null;
//	protected static String ee_base = null;
	
	public static String getEe_base() {
		if (eeSrcPaths.size() > 0) {
			return eeSrcPaths.get(0).srcPath;
		}
		return null;
	}

	public static List<EE_src_distr> getAllEe_base() {
		return Collections.unmodifiableList(eeSrcPaths);
	}
	
	/** @deprecated no more supported */
	private static String getEvidence_base() {
		if (eviPaths.size() > 0) {
			return eviPaths.get(0);
		}
		return null;
	}
	
	
	
	private static ArrayList<String> eviPaths = parseAllEviExtensions();
	private static ArrayList<EE_src_distr> eeSrcPaths = parseAllEEsrcExtensions();

	

	@SuppressWarnings("unchecked")
	static ArrayList<String> parseAllEviExtensions() {
//StringBuffer buffer = new StringBuffer();
		ArrayList<String> answer = new ArrayList<String>();
		
		IConfigurationElement[] config = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(
						"com.eu.evidence.rtdruid.oil.ee.core.eeSrc");
		assert (config != null);
		int l = config.length;
		
//buffer.append("Config.length = " + config.length + "\n");
		for (int i = 0; i < l; i++) {
//buffer.append("\n__" + i + " = " + config[i].getName() + "  " + config[i] +"\n");
			if ("evidenceBase".equals(config[i].getName())) {
				String bundleName = "";
				String fileName = "";
				try {
					fileName = config[i].getAttribute("path");
					
//buffer.append("_____Base" + " = " + fileName +"\n");
					if (fileName == null) {
						continue;
					}

					bundleName = config[i].getContributor().getName();
					Bundle bundle = Platform.getBundle(bundleName);
					assert (bundle != null);
					
					if (FileLocator.find(bundle, new Path(fileName),
							new HashMap()) == null) {
//buffer.append("_____Bundle not found" +"\n");
						continue;
					}
					File f = FileLocator.getBundleFile(bundle);
					String bundlePath = null;
					if (f != null) {
						bundlePath = f.getAbsolutePath();
					}
//buffer.append("_____Bundle path = "+bundlePath +"\n");
					File base = new File(bundlePath + File.separatorChar + fileName);
					if (base.exists() && base.canRead()) {
						answer.add(base.getAbsolutePath());
//buffer.append("_____base path = "+base.getAbsolutePath() +"\n");
					}
					
				} catch (Exception e) {
					RtdruidLog.log("Unable to get the specified template directory:\n bundle= " + 
							bundleName + "\n dir= " + fileName,
							e);
				}
			}
		}
//buffer.append("\n Res = "+answer +"\n");
//RtdruidLog.log(buffer.toString());
//System.out.println(buffer.toString());
		
		return answer;
	}

	

	static ArrayList<EE_src_distr> parseAllEEsrcExtensions() {
		ArrayList<EE_src_distr> answer = new ArrayList<EE_src_distr>();
		
		checkConfigurationOptions(answer);
		parseExtSourceDistribution(answer);
		parseSourceDistribution(answer);
		
		return answer;
	}		

	@SuppressWarnings("unchecked")
	static void parseExtSourceDistribution(ArrayList<EE_src_distr> answer) {
	
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
					srcAttr = config[i].getAttribute("sources");
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
										
					answer.add(new EE_src_distr(version, srcBase, contrBase));
					
				} catch (Exception e) {
					RtdruidLog.log("Unable to get the specified source/contribution directory:\n bundle= " + 
							bundleName + "\n source= " + srcAttr + "\n contribs= " + contribs,
							e);
				}
			}
		}
	}

	
	@SuppressWarnings("unchecked")
	static void parseSourceDistribution(ArrayList<EE_src_distr> answer) {
	
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
					srcAttr = config[i].getAttribute("sources");
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
								new HashMap()) == null) {
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
								new HashMap()) == null) {
buffer.append("_____Bundle not found" +"\n");
							continue;
						}
						
						File base = new File(bundlePath + File.separatorChar + contribs);
						if (base.exists() && base.canRead()) {
							contrBase = base.getAbsolutePath();
buffer.append("_____Contr path = "+contrBase +"\n");
						}
					}
					
					
					answer.add(new EE_src_distr(version, srcBase, contrBase));
					
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
		String base = prefs.getValue(CONFIG_FILE___EE_BASE);
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
				answer.add(new EE_src_distr("", base, null));
			}
		}
		
	}

	
}
