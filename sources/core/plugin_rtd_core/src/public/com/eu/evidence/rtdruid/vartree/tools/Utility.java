/*
 * Created on 10-mar-2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.eu.evidence.rtdruid.vartree.tools;

// projects package
import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;


// standard java package

// exceptions

/**
 *  @author  Nicola Serreli
 */
public class Utility {
	/** Abbreviation for VarTree.SEPARATOR */
	private final static char S = IVarTree.SEPARATOR;

	public final static String DEFAULT_MODE = null;//"__Default_Mode__";
	
	public final static String T_SUBSYSTEM = "SubSystem";  


	/** Search a node with given  path and  a name made of given idList using {@link Utility#makeId Utility.makeId}
	 * 
	 * @return the path to required node. Null if this node doesn't exist.
	 * */
	public static String chooseModeRef(ITreeInterface ti, String path, String[] idList, int modeIndex, String modeName) {
		if (modeName != null) {
			idList[modeIndex] = pathToEvidence(modeName);
			String tmp = path + S + DataPath.makeSlashedId(idList);
			if (ti.exist(tmp, null)
				) {
				return tmp;
			}
			// rtdruid.desk.Messages.sendDebug("Required mode (" + modeRef +") doesn't exist in given path ("+ path +"). Try to use default mode.");
		}
		
		idList[modeIndex] = null;
		String tmp = path + S + DataPath.makeSlashedId(idList);
		if (ti.exist(tmp, null)) {
			return tmp;
		}
		//rtdruid.desk.Messages.sendDebug("Default mode doesn't exist in given path");
		
		return null;
	}
	
	// -------------------- convert from / to evidence_reference_path - varTree_path
	
	/**	Searches for all TreeInterface.SPECIAL characters and protects them
	*/ 
	public static String pathToVarTree(String path) {
		if (path == null) { return path;}
		
		StringBuffer tmp = new StringBuffer(path.length()*2);

		// check char after char
		char[] tmpString = path.toCharArray();
		boolean protect= false;
		for (int curr=0; curr<tmpString.length; curr++) {
			protect= false;
			switch (tmpString[curr]) {
				case ITreeInterface.SPECIAL  :
							protect = true;
							break;
				default   : protect = false;
			}
			tmp.append("" + (protect ? "" + IVarTree.PROTECTOR : "") + tmpString[curr]);
		}
		return tmp.toString();
	}
	
	/**	Searches for all protected TreeInterface.SPECIAL and remove the "protection"
	*/ 
	public static String pathToEvidence(String path) {
		if (path == null) { return path;}
		
		StringBuffer tmp = new StringBuffer(path.length());

		// check char after char
		char[] tmpString = path.toCharArray();
		for (int curr=0; curr<tmpString.length; curr++) {
			switch (tmpString[curr]) {
				case IVarTree.PROTECTOR :
							if (curr + 1<tmpString.length) {
								switch (tmpString[curr+1]) {
									case ITreeInterface.SPECIAL  :
												curr++;
												break;
									default   : break;
								}
							}
				default   : break;
			}
			tmp.append(tmpString[curr]);
		}
		return tmp.toString();
	}

	/** Converts a varTree path into a Evidence identificator.
	 * For now : system, subSystem, proc, var, provided and required interface, event and trigger. 
	 * 
	 */
	public static String makeEvidenceID(String path ) {
		final String[] DROP = {
			"Functional",
			"Implementation",
			"MethodRefList",
			"ProvidedInterfaceList",
			"RequiredInterfaceList",
			"TriggerList",
			"EventList"
		};
		
		if (path == null) {
			throw new NullPointerException("Required a not null path");
		}
		
		String[] pieces = DataPath.splitPath(path);
		
		if (!"Functional".equals(pieces[1])) {
			throw new RuntimeException("Warning: try to use makeEvidenceID with a not supported section !!!\n\t" + path);
		}
		
		String risp = "";
		for (int i=0; i<pieces.length; i++) {
			boolean ok = true;
			for (int j=0; j<DROP.length && ok; j++) {
				ok = ! (DROP[j].equals(pieces[i]));
			}
			if (ok) {
				risp += S+ /*DataPath.addSlash(pieces[i]);*/ pieces[i];
			}
		}
		
		return pathToEvidence(risp);
	}


	/** Converts a varTree path into a SubSyetem/.../functional_object identificator.
	 * For now : subSystem, proc, var, provided and required interface, event and trigger. 
	 * 
	 */
	public static String makeFunctionalPath(String path ) {
		final String[] DROP = {
			"Functional",
			"Implementation",
			"MethodRefList",
			"ProvidedInterfaceList",
			"RequiredInterfaceList",
			"TriggerList",
			"EventList"
		};
		
		if (path == null) {
			throw new NullPointerException("Required a not null path");
		}
		
		String[] pieces = DataPath.splitPath(path);
		
		if (!"Functional".equals(pieces[1])) {
			throw new RuntimeException("Warning: try to use makeEvidenceID with a not supported section !!!\n\t" + path);
		}
		
		String risp = "";
		String pre = "";
		for (int i=2; i<pieces.length; i++) {
			boolean ok = true;
			for (int j=0; j<DROP.length && ok; j++) {
				ok = ! (DROP[j].equals(pieces[i]));
			}
			if (ok) {
				risp += pre+ DataPath.removeSlash(pieces[i]);
				pre = "" + S;
			}
		}
		
		return pathToEvidence(risp);
	}

}
