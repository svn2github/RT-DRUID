package com.eu.evidence.modules.oil.erikaenterprise.constants;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

import com.eu.evidence.rtdruid.desk.RtdruidLog;


/**
 * 
 * This class 
 * 
 * @author Nicola Serreli
 */
public final class EEPaths {
	
//	protected static String evidence_base = null;
//	protected static String ee_base = null;
	
	public static String getEe_base() {
		if (eeSrcPaths.size() > 0) {
			return eeSrcPaths.get(0).srcPath;
		}
		return null;
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

	
	@SuppressWarnings("unchecked")
	static ArrayList<EE_src_distr> parseAllEEsrcExtensions() {
StringBuffer buffer = new StringBuffer();
		ArrayList<EE_src_distr> answer = new ArrayList<EE_src_distr>();

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
//buffer.append("\n Res = "+answer +"\n");
//RtdruidLog.log(buffer.toString());
//System.out.println(buffer.toString());
		return answer;
	}

	
}
