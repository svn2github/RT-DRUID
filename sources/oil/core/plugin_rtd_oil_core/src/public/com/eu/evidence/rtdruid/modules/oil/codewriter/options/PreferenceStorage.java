package com.eu.evidence.rtdruid.modules.oil.codewriter.options;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.osgi.service.datalocation.Location;

import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.modules.oil.Rtd_oil_corePlugin;

/**
 * This class is a selector of the file that contains the common preferences.
 * 
 * @author Nicola Serreli
 *
 */
public class PreferenceStorage {
	
	/**
	 * If this preference is set to true, this preference manager will use the file stored
	 * inside the main configuration directory of the current installation of eclipse. 
	 */
	public final static String USE_INSTALLATION_PREFERENCES = "use_installation_preferences";
	
	protected final static String DEFAULT_NAME = "common_oil.pref";
	
	private final static PreferenceStorage common = new PreferenceStorage();
	
	public static PreferenceStorage getCommonIstance() {
		return common;
	}
	
	protected final Properties values = new Properties();;
	
	protected File currentFile = null;
	
	public PreferenceStorage() {
		
		// first: check if there is a file inside the workspace
		lookForWorkspaceFile();
		
		// Second: check if is required to switch to the installation file
		if (currentFile != null) {
			if (values.contains(USE_INSTALLATION_PREFERENCES)) {
				if (Boolean.parseBoolean(values.getProperty(USE_INSTALLATION_PREFERENCES, "false"))) {
					values.clear();
					currentFile = null;
				}
			}
		}
		
		// third: check if there is a file inside the workspace
		if (currentFile == null) {
			lookForInstallationFile();
		}
	}
	
	
	
	public void load() {
		if (currentFile == null) {
			// nothing to load
			RtdruidLog.log("Called 'load preferences' method without set a file to load");
			return;
		}
		
		// clear old values
		values.clear();
		
		if (currentFile.exists() && currentFile.isFile() && currentFile.canRead()) {
			try {
				values.load(new FileInputStream(currentFile));
			} catch (FileNotFoundException e) {
				// cannot be
				RtdruidLog.log(e);
			} catch (IOException e) {
				// some problems reading the file
				RtdruidLog.log(e);
			}
		}	
	}
	
	public void save() {
		if (currentFile != null) {
			Properties tmp = new Properties();
			try {
				tmp.store(new FileOutputStream(currentFile), "");
			} catch (FileNotFoundException e) {
				// cannot be
				RtdruidLog.log(e);
			} catch (IOException e) {
				// some problems reading the file
				RtdruidLog.log(e);
			}
		}	
	}
	
	/**
	 * 
	 */
	protected void lookForWorkspaceFile() {
		currentFile = null;
		String dbg = "";

		try {
			IPath path = Rtd_oil_corePlugin.getDefault().getStateLocation();
			dbg += "\n>>lookForWorkspaceFile :";
			if (path != null) { 
				
				path = path.append(DEFAULT_NAME);
				dbg += path + " ... ";
				
				File file = new File(path.toOSString());
				if (file.exists() && file.isFile() && file.canRead()) {
					Properties tmp = new Properties();
					try {
						tmp.load(new FileInputStream(file));
						currentFile = file;
						dbg += " ... done ";
					} catch (FileNotFoundException e) {
						// cannot be
						RtdruidLog.log(e);
					} catch (IOException e) {
						// some problems reading the file
						RtdruidLog.log(e);
						dbg += " ... " + e.getMessage();
					}
				} else {
					dbg += " ... not found";
				}
			}
		} finally {
			dbg += "<<\n\n";
//			System.out.println(dbg);
		}
	}


	/**
	 * 
	 */
	protected void lookForInstallationFile() {
		currentFile = null;
		String dbg = "";

		try {
			Location location = Platform.getConfigurationLocation();
			dbg += "\n>>lookForInstallationFile :" + location + " ... ";
			if (location != null) {
				URL url = location.getURL();
				String url_f = url == null ? null : url.getFile();
				
				if (url_f != null) { 
				
					IPath path = new Path(url_f);
					path = path.append(DEFAULT_NAME);
					dbg += path + " ... ";
					
					File file = new File(path.toOSString());
					if (file.exists() && file.isFile() && file.canRead()) {
						Properties tmp = new Properties();
						try {
							tmp.load(new FileInputStream(file));
							currentFile = file;
							dbg += " ... done ";
						} catch (FileNotFoundException e) {
							// cannot be
							RtdruidLog.log(e);
						} catch (IOException e) {
							// some problems reading the file
							RtdruidLog.log(e);
							dbg += " ... " + e.getMessage();
						}
					} else {
						dbg += " ... not found";
					}
				}
			}
		} finally {
			dbg += "<<\n\n";
//			System.out.println(dbg);
		}
	}

	/**
	 * @return all values handled set in this Preference Storage
	 */
	public HashMap<String, String> getAllValue() {
		HashMap<String, String> answer = new HashMap<String, String>();
		for (Enumeration<String> keys = (Enumeration<String>) values.propertyNames();
			keys.hasMoreElements(); ) {
			String key = keys.nextElement();
			answer.put(key, values.getProperty(key));
		}
		return answer;
	}

	
	public String getValue(String ID) {
		throw new UnsupportedOperationException();
	}
	
	public void setValue(String ID, String value) {
		throw new UnsupportedOperationException();
	}
	
	public void setCurrentFile(File f) {
		currentFile = f;
	}
	
	public File getCurrentFile() {
		return currentFile;
	}
}
