/**
 * 24/apr/2012
 */
package com.eu.evidence.rtdruid.modules.oil.implementation;

import static com.eu.evidence.rtdruid.vartree.DataPath.SEPARATOR;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.eu.evidence.rtdruid.vartree.DataPath;

/**
 * 
 * @author Nicola Serreli
 * @since 2.0
 * 
 */
public class OilPath {
	
	private final OilObjectType objType;
	
	private ArrayList<String> pathElements;
	private ArrayList<String> typeElements;
	private String path;
	private String type;
	
	private static boolean requiredName(OilObjectType type) {
		return type == OilObjectType.COM || type == OilObjectType.IPDU || type == OilObjectType.MESSAGE || type == OilObjectType.NM;
	}
	
	/**
	 * Constructor used by clone method
	 * 
	 * @param type
	 */
	private OilPath(OilPath old) {
		this.objType = old.objType;

		this.pathElements = old.pathElements == null ? null : new ArrayList<String>(old.pathElements);
		this.typeElements = old.typeElements == null ? null : new ArrayList<String>(old.typeElements);
		this.path = old.path;
		this.type = old.type;
	}

	/**
	 * Default constructor
	 */
	public OilPath(OilObjectType type, String name) {
		this(type, name, requiredName(type));
	}
	public OilPath(OilObjectType type, String name, boolean addName) {
		this.objType = type;
		
		String[][] values = makeOilVarPrefix(addName, name, objType.getText(), null);
		pathElements = new ArrayList<String>(Arrays.asList(values[0]));
		typeElements = new ArrayList<String>(Arrays.asList(values[1]));
		this.type= values[2][0];
		path = null;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected OilPath clone() {
		return new OilPath(this);
	}
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * @return the path
	 */
	public String getPath() {
		if (path == null) {
			path = DataPath.makePath(pathElements)+SEPARATOR;
		}
		return path;
	}
	
	/**
	 * @return the path
	 */
	public List<String> getPathElements() {
		return Collections.unmodifiableList(pathElements);
	}
	
	/**
	 * @return the typePath
	 */
	public List<String> getTypeElements() {
		return Collections.unmodifiableList(typeElements);
	}

	
	
	// -----------------------------------------------------------------
	
	/**
	 * Prepare the prefix for all data that will be stored inside the OilVar.
	 * 
	 * 
	 */
	private static String[][] makeOilVarPrefix(boolean addName, String name, String objType, IOilImplID id) {

		String objId = (addName ? DataPath.makeSlashedId(new String[] { objType, name }) : objType);

		final String ext = objType + "_OIL_EXT";
		final String type = incremental_compute_full_name((String) null, objType);
		// if ("os".equalsIgnoreCase(objType)) {
		// ext = "RTOS";
		// } else {
		// ext = objType;
		// }

		String[][] answer = new String[3][];
		answer[0] = new String[] { ext, objId };
		answer[1] = new String[] { ext, type };
		answer[2] = new String[] { type };

		return answer;
		//
		//
		// return new String[] { objId, OAPKG.getRoot_HwList().getName(),
		// DataPath.makeId(id.getHW()), OAPKG.getHW_RtosList().getName(),
		// DataPath.makeId(id.getRtos()) };
	}

	/**
	 * Creates a Emf type identifier corresponding to an Oil type path
	 * 
	 * @param path
	 * @return
	 */
	public static String compute_full_name(ArrayList<String> path) {
		StringBuffer answer = new StringBuffer();

		for (String elem : path) {
			OilPath.incremental_compute_full_name(answer, elem);
		}

		return answer.toString();
	}

	/**
	 * Creates a Emf type identifier corresponding to an Oil type path
	 * 
	 * @param path
	 * @return
	 */
	public static String incremental_compute_full_name(String base, String newElement) {
		return OilPath.incremental_compute_full_name(new StringBuffer(base == null ? "" : base), newElement);
	}

	/**
	 * Creates a Emf type identifier corresponding to an Oil type path
	 * 
	 * @param base
	 *            the
	 * @param newElement
	 * @return
	 */
	private static String incremental_compute_full_name(StringBuffer base, String newElement) {
		StringBuffer answer = base;

		final String sep;
		if (answer.length() == 0) {
			sep = "";
			newElement = "OIL" + newElement;
		} else {
			sep = "__";
		}
		answer.append(sep);

		// this loop searches all sequences of _ and replace them with _counter
		// where the counter is the number of consecutive _ (max 9)
		int counter = 0;
		for (byte c : newElement.getBytes()) {
			if (((char) c) == '_') {
				counter++;
				if (counter == 9) {
					answer.append("_9");
					counter = 0;
				}
			} else {
				if (counter > 0) {
					answer.append("_" + counter);
					counter = 0;
				}
				answer.append((char) c);
			}
		}

		return answer.toString();
	}

}
