package com.eu.evidence.rtdruid.vartree.abstractions.old;

// project package

import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

import com.eu.evidence.rtdruid.desk.Messages;
import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.IMultiValues;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVariable;
import com.eu.evidence.rtdruid.vartree.variables.DoubleVar;
import com.eu.evidence.rtdruid.vartree.variables.FloatVar;
import com.eu.evidence.rtdruid.vartree.variables.IntegerVar;
import com.eu.evidence.rtdruid.vartree.variables.LongVar;
import com.eu.evidence.rtdruid.vartree.variables.MultiValues;
import com.eu.evidence.rtdruid.vartree.variables.TimeMVar;
import com.eu.evidence.rtdruid.vartree.variables.TimeVar;

// exceptions

/**
 * GenRes
 * 
 * @author Giuseppe Lipari && Nicola Serreli
 */

public class GenRes {
	public final static int ALL = 0;

	public final static int REQUIRED = 1;

	public final static int OPTIONAL = 2;

	/**
	 * Contains the list of values that have not been found. It is  used
	 * for error reporting.
	 */
	protected class NotFoundValues {

		protected ArrayList<String> requiredList = new ArrayList<String>();

		protected ArrayList<String> optionalList = new ArrayList<String>();

		public void add(String key, boolean required) {

			ArrayList<String> curr = required ? requiredList : optionalList;

			if (!curr.contains(key)) {
				curr.add(key);
			}
		}

		public void clear() {
			requiredList.clear();
			optionalList.clear();
		}

		public String[] get(int what) {
			ArrayList<String> curr;
			switch (what) {

			case ALL:
				curr = new ArrayList<String>();
				curr.addAll(requiredList);
				curr.addAll(optionalList);
				break;

			case REQUIRED:
				curr = requiredList;
				break;

			case OPTIONAL:
				curr = optionalList;
				break;
			default : 
				curr = new ArrayList<String>();
			}

			return (String[]) curr.toArray(new String[0]);
		}

		public String toString() {
			return "Required = " + requiredList.toString() + "\nOptional = "
					+ optionalList.toString();
		}
	}

	/** Abbreviation for VarTree.SEPARATOR */
	protected final static String S = "" + IVarTree.SEPARATOR;

	protected Hashtable<String, Object> prop;

	/**
	 * Temporary values. These values are never saved on the tree.
	 * (not even if save is set to true).
	 */
	protected Hashtable<String, Object> tempP;

	protected String nome;

	protected String pref;

	protected String path;

	/**
	 * The father of this structure. Example, a TaskSet is the father of a Task.
	 */
	protected GenResList padre;

	protected ITreeInterface ti;

	protected NotFoundValues notFoundValues;

	/**
	 * True if the info are to be saved back on the tree
	 */
	protected boolean save;

	/**
	 * prefix can be null (children of root node)
	 */
	public GenRes(GenResList parent, String name, String prefix) {
		if (parent == null)
			throw new NullPointerException(
					"Try to make a new GenRes with a null parent.");
		if (name == null)
			throw new NullPointerException(
					"Try to make a new GenRes with a null name.");

		ti = parent.getVarTree().newTreeInterface();

		prop = new Hashtable<String, Object>();
		tempP = new Hashtable<String, Object>();
		nome = DataPath.removeSlash(name);
		pref = prefix; //(prefix == null ? S : (prefix.startsWith(S) ? prefix :
		// S + prefix) );
		path = pref + S + DataPath.addSlash(name);
		padre = parent;
		save = false;

		notFoundValues = new NotFoundValues();
	}

	//------------------- SET

	/**
	 * Sets the value of a property
	 */
	public void setProperty(String p, String v) {
		p = p.toLowerCase();
		if (padre.getProperty(p) == null) {
			throw new IllegalStateException(
					"Try to set an unsupported property " + p + ".\n\twhere ="
							+ getPath());
		}

		prop.put(p, v);

		if (save) {
			store(p, v);
		}
	}

	public void setProperty(String p, int v) {
		setProperty(p.toLowerCase(), "" + v);
	}

	public void setProperty(String p, long v) {
		setProperty(p.toLowerCase(), "" + v);
	}

	public void setProperty(String p, double v) {
		setProperty(p.toLowerCase(), "" + v);
	}

	public void setProperty(String p, float v) {
		setProperty(p.toLowerCase(), v + "");
	}

	/**
	 * Sets the value of a property
	 */
	public void setProperty(String p, Collection<?> v) {
		p = p.toLowerCase();
		if (padre.getProperty(p) == null) {
			throw new IllegalStateException(
					"Try to set an unsupported property " + p + ".\n\twhere ="
							+ getPath());
		}

		prop.put(p, v);

		if (save) {
			store(p, v);
		}
	}

	//------------------- SET Temporary Properties

	/**
	 * Sets the value of a property that will be not saved to VarTree
	 */
	public void setTempProperty(String p, int v) {
		tempP.put(p.toLowerCase(), "" + v);
	}

	public void setTempProperty(String p, double v) {
		tempP.put(p.toLowerCase(), "" + v);
	}

	public void setTempProperty(String p, float v) {
		tempP.put(p.toLowerCase(), "" + v);
	}

	public void setTempProperty(String p, Object v) {
		tempP.put(p.toLowerCase(), v);
	}

	//------------------- GET Properties

	public Object getProperty(String k) {
		k = k.toLowerCase();
		if (!existProperty(k))
			throw new IllegalStateException(
					"Try to get an unsetted or unsupported property " + k
							+ ".\n\twhere =" + getPath());
		return prop.get(k);
	}

	public Collection<?> getCollection(String k) {
		return (Collection<?>) getProperty(k);
	}

	public String getString(String k) {
		return (String) getProperty(k);
	}

	public long getLong(String k) {
		Long l;
		try {
			l = Long.valueOf("" + getProperty(k));
		} catch (NumberFormatException e) {
			throw new NumberFormatException("Illegal value for '" + k
					+ "' property of " + getPath() + "\n\tvalue = "
					+ getProperty(k));
		}
		return l.longValue();
	}

	public int getInt(String k) {
		Integer i = null;
		try {
			i = Integer.valueOf("" + getProperty(k));
		} catch (NumberFormatException e) {
			throw new NumberFormatException("Illegal value for '" + k
					+ "' property of " + getPath() + "\n\tvalue = "
					+ getProperty(k));
		}
		return i.intValue();
	}

	public double getDouble(String k) {
		Double d = null;
		try {
			d = Double.valueOf("" + getProperty(k));
		} catch (NumberFormatException e) {
			throw new NumberFormatException("Illegal value for property " + k
					+ " (" + getPath() + ")\n\tvalue = " + getProperty(k));
		}
		return d.doubleValue();
	}

	public float getFloat(String k) {
		Float f = Float.valueOf("" + getProperty(k));
		return f.floatValue();
	}

	//------------------- GET Temporary Properties

	public Object getTempProperty(String k) {
		k = k.toLowerCase();
		if (!existTempProperty(k))
			throw new IllegalStateException("Try to get a noy setted property "
					+ k + ".\n\twhere =" + getPath());
		return tempP.get(k);
	}

	public Collection<?> getTempCollection(String k) {
		return (Collection<?>) getTempProperty(k);
	}

	public String getTempString(String k) {
		return (String) getTempProperty(k);
	}

	public int getTempInt(String k) {
		Integer i = Integer.valueOf("" + getTempProperty(k));
		return i.intValue();
	}

	public double getTempDouble(String k) {
		Double d = Double.valueOf("" + getTempProperty(k));
		return d.doubleValue();
	}

	public float getTempFloat(String k) {
		Float f = Float.valueOf("" + getTempProperty(k));
		return f.floatValue();
	}

	//------------------- GET

	public String getName() {
		return nome;
	}

	public String getPrefix() {
		return pref;
	}

	public String getPath() {
		return path;
	}

	public Enumeration<String> getAllKeys() {
		return prop.keys();
	}

	public Enumeration<Object> getAllValues() {
		return prop.elements();
	}

	public Enumeration<String> getAllTempKeys() {
		return tempP.keys();
	}

	public Enumeration<Object> getAllTempValues() {
		return tempP.elements();
	}

	public boolean existProperty(String name) {
		return prop.containsKey(name.toLowerCase());
	}

	public boolean existTempProperty(String name) {
		return tempP.containsKey(name.toLowerCase());
	}

	//------------------- Utilities
	/**
	 * Used to add one or more dynamic sublevel in the path of a property. es.
	 * &lt;path of current element&gt &lt;dynamic nodes&gt; &lt;path stored in
	 * the parent GenResList&gt
	 */
	protected String getPath(String what) {
		return getPath() + S + padre.getProperty(what);
	}

	/**
	 * Adds or update a property from the tree.
	 * 
	 * @return false if there was an error
	 */
	public boolean load(String name, boolean required) {
		Object valore = "";
		boolean risp = true;
		try {
			IVariable var = ti.getValue(getPath(name));

			if (var instanceof TimeVar) {
				((TimeVar) var).setType(TimeVar.MILLI_SECOND);
			} else if (var instanceof TimeMVar) {
				((TimeMVar) var).setType(TimeVar.MILLI_SECOND);
			}

			//			a MultiValues var returns a ArrayList
			valore = var.get();
			if (valore == null) {
				valore = "";
				notFoundValues.add(name, required);
			}
		} catch (Exception e) {

			notFoundValues.add(name, required);

			/*
			 * String txt = nome + ": Value not loaded:" + "\n\twhere =" +
			 * getPath(name) + "\n\twhat (property)=" + name;
			 * Messages.sendDebug(txt, this.getClass().getName() + " - " + txt +
			 * "\n\twhy: " + e.toString(), "GenRes" , null);
			 */
			risp = false;
		}

		name = name.toLowerCase();
		prop.put(name, valore);
		return risp;
	}

	/**
	 * Say if the values must be saved back on the tree. 
	 * The temp properties are never saved on the tree.
	 * 
	 * @param newValue
	 */
	final public void setSave(boolean newValue) {
		save = newValue;
		if (save) {
			for (Enumeration<String> keys = prop.keys(); keys.hasMoreElements();) {
				String k = (String) keys.nextElement();
				store(k, prop.get(k));
			}
		}
	}

	/**
	 * Stores a single value
	 * 
	 * @param key
	 * @param o
	 * @return
	 */
	final private boolean store(String key, Object o) {
		boolean lock = false;
		try {
			lock = padre.vt.getThreadMonitor().lock();
			return doStore(key, o);
		} finally {
			if (lock) {
				padre.vt.getThreadMonitor().unlock();
			}
		}
	}

	/**
	 * Effectively stores the value on the tree.
	 * 
	 * @param key
	 * @param o
	 * @return
	 */
	protected boolean doStore(String key, Object o) {
		try {
			String tmpPath = getPath(key);

			if (o instanceof Collection) {
				Collection<?> v = (Collection<?>) o;
				// try to save convert all elements ...
				String[] tmp = new String[v.size()];

				Iterator<?> it = v.iterator();
				for (int i = 0; it.hasNext(); i++) {
					tmp[i] = "" + it.next();
				}

				// ... store them into a MultiValues var ...
				IVariable var = ti.getValue(tmpPath);
				if (!(var instanceof MultiValues)) {
					throw new IllegalArgumentException(
							"Try to set a collection to a not multivalues Node"
									+ "\n\tpath = " + tmpPath);
				}
				if (var instanceof TimeMVar) {
					((TimeMVar) var).setType(TimeVar.MILLI_SECOND);
				}
				((IMultiValues) var).setValues(tmp);

				// .. and store in the tree
				ti.setValue(tmpPath, var);
			} else {
				// check if is a TimeVar
				IVariable var = ti.getValue(tmpPath);
				if (var instanceof TimeVar) {
					((TimeVar) var).setType(TimeVar.MILLI_SECOND);
					// .. store value
					var.set(o == null || "".equals("" + o) ? null : "" + o);
				} else {

					if (var instanceof IntegerVar || var instanceof LongVar
							|| var instanceof DoubleVar
							|| var instanceof FloatVar) {

						// unset void values
						var.set(o == null || "".equals("" + o) ? null : "" + o);
					} else {

						// .. store value
						var.set(o == null ? null : "" + o);
					}
				}

				// .. and store var in the tree
				ti.setValue(tmpPath, var);
			}
		} catch (Exception e) {
			String txt = "aValue not stored:\n\twhere =" + getPath(key)
					+ "\n\twhat (property)=" + key + "\n\twhat (value)=" + o;
			Messages.sendWarningNl(txt, this.getClass().getName() + " - " + txt
					+ "\n\twhy: " + e.toString(), "GenRes", null);

			// disable detailed report
			//
			return false;
		}
		return true;
	}

	/**
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer("Name = " + nome + "\n" + "Path = "
				+ pref + "\n" + "Properties:\n");

		for (Enumeration<String> keys = prop.keys(); keys.hasMoreElements();) {
			String k = (String) keys.nextElement();
			// Collections are printed as [obj1.toString(), obj2.toString() ,
			// ...]
			sb.append("\tname = " + k + " \tvalue = " + prop.get(k) + "\n");
		}

		sb.append("Temporary properties:\n");
		for (Enumeration<String> keys = tempP.keys(); keys.hasMoreElements();) {
			String k = (String) keys.nextElement();
			// Collections are printed as [obj1.toString(), obj2.toString() ,
			// ...]
			sb.append("\tname = " + k + " \tvalue = " + tempP.get(k) + "\n");
		}

		return sb.toString();
	}

	// --------------------
	/**
	 * @param what
	 *            one of ALL, REQUIRED and OPTIONAL
	 * @return all names of not found properties
	 */
	public String[] getNotFoundValues(int what) {
		return notFoundValues.get(what);
	}

} // GenRes
