/*
 * Created on Dec 7, 2004
 *
 * $Id: SimpleGenRes.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.abstractions;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.eu.evidence.rtdruid.desk.RtdruidLog;



/**
 * A simple class that store a name, a path and a group of properties
 * 
 * @author Nicola Serreli
 */
public class SimpleGenRes implements ISimpleGenRes {

	/** The object name */
	protected String name;

	/** The path of current object inside the tree */
	protected String path;

	/** All properties */
	protected HashMap<String, Object> properties = new HashMap<String, Object>();

	/**
	 * Constructor
	 * 
	 * @param name
	 *            is the name of this object
	 * @param path
	 *            where this object is located inside the tree
	 */
	public SimpleGenRes(String name, String path) {
		this.name = name;
		this.path = path;
	}

	//--------------------------------------------------

	/**
	 * Remove a property
	 * 
	 * @param pName
	 *            the property identifier
	 * @param value
	 *            the property value
	 * 
	 * @return the old value, or null if no value was setted
	 */
	public Object removeAProperty(String pName) {
		return properties.remove(pName.toLowerCase());
	}
	
	/**
	 * Sets a property
	 * 
	 * @param pName
	 *            the property identifier
	 * @param value
	 *            the property value
	 * 
	 * @return the old value, or null if no value was setted
	 */
	public Object setProperty(String pName, String value) {
		return properties.put(pName.toLowerCase(), value);
	}

	/**
	 * Sets an object
	 * 
	 * @param pName
	 *            the identifier
	 * @param value
	 *            the value
	 * 
	 * @return the old value, or null if no value was setted
	 */
	public Object setObject(String pName, Object value) {
		return properties.put(pName.toLowerCase(), value);
	}
	
	/**
	 * Returns a property as a String
	 * 
	 * @param pName
	 *            identifies the property
	 * 
	 * @return a property
	 * 
	 * @throws IllegalArgumentException
	 *             if the property doesn't exist
	 */
	public String getString(String pName) {
		Object o = properties.get(check(pName));
		return o == null ? null : o.toString() ;
	}

	/**
	 * Returns a property as an int
	 * 
	 * @param pName
	 *            identifies the property
	 * 
	 * @return a property
	 * 
	 * @throws IllegalArgumentException
	 *             if the property doesn't exist
	 */
	public int getInt(String pName) {
		return Integer.decode(properties.get(check(pName)).toString()).intValue();
	}

	/**
	 * Returns a property as a long
	 * 
	 * @param pName
	 *            identifies the property
	 * 
	 * @return a property
	 * 
	 * @throws IllegalArgumentException
	 *             if the property doesn't exist
	 */
	public long getLong(String pName) {
		return Long.decode(properties.get(check(pName)).toString()).intValue();
	}

	/**
	 * Returns a property as a double
	 * 
	 * @param pName
	 *            identifies the property
	 * 
	 * @return a property
	 * 
	 * @throws IllegalArgumentException
	 *             if the property doesn't exist
	 */
	public double getDouble(String pName) {
		return Double.parseDouble(properties.get(check(pName)).toString());
	}
	
	/**
	 * Returns a property as a object
	 * 
	 * @param pName
	 *            identifies the property
	 * 
	 * @return a property
	 * 
	 * @throws IllegalArgumentException
	 *             if the property doesn't exist
	 */
	public Object getObject(String pName) {
		return properties.get(check(pName));
	}
	
	/**
	 * Returns the name of this object
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the path of this object
	 * 
	 * @return the path
	 */
	public String getPath() {
		return path;
	}
		

	// ----------------------------------

	/**
	 * Returns a copy of all properties of current object
	 * 
	 * @return a copy of all properties of current object
	 */
	public HashMap<String, Object> getAllProperties() {
		return (HashMap<String, Object>) properties.clone();
	}

	/**
	 * Returns true if this object contains the specified property
	 * 
	 * @param pName
	 *            identifies the property
	 * 
	 * @return true if this object contains the specified property, false
	 *         otherwise
	 */
	public boolean containsProperty(String pName) {
		return properties.containsKey(pName.toLowerCase());
	}

	/**
	 * Check if a property exist and, if true, returns the property name.
	 * 
	 * @param pName
	 *            identifies the property
	 * 
	 * @return the property name
	 * 
	 * @throws IllegalArgumentException
	 *             if the property doesn't exist
	 */
	protected String check(String pName) {
		pName = pName.toLowerCase();
		if (!properties.containsKey(pName)) {
			throw new IllegalArgumentException("Property not found:\n" + pName
					+ "\n" + properties);
		}
		return pName;
	}

	/**
	 * Returns a String rapresentation of this object
	 * 
	 * @return a String rapresentation of this object
	 */
	public String toString() {
		return "Simple Gen Res (name = " + name + "; path = " + path + ")\n"
				+ properties;
	}
	
	// ------------------------------------
	
	@SuppressWarnings("unchecked")
	public ISimpleGenRes clone() {
		SimpleGenRes answer = new SimpleGenRes(name, path);
		answer.properties = (HashMap<String, Object>) properties.clone();
		
		return answer;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void merge(ISimpleGenRes source) {
		Map<String, ? extends Object> map = source.getAllProperties();
		for (Entry<String, ? extends Object> entry : map.entrySet()) {
			String key = entry.getKey();
			
			if (containsProperty(key)) {
				Object oldValue = getObject(key);
				Object newValue = entry.getValue();
				if (newValue != null) {
					
					if (oldValue == null) {
						setObject(key, entry.getValue());
					} else {
						if (oldValue.getClass() != newValue.getClass()) {
							boolean both_collections = (oldValue instanceof Collection) && (newValue instanceof Collection); 
							boolean both_map = (oldValue instanceof Map) && (newValue instanceof Map); 
							if (!both_collections && !both_map) {
								throw new IllegalArgumentException("Incompatible elements (key="+key+")\n\t"+this+"\n\t"+source);
							}
						}

						
						if (oldValue instanceof Map) {
							try {
								((Map) oldValue).putAll((Map) newValue);
							} catch (UnsupportedOperationException e) {
								LinkedHashMap nmap = new LinkedHashMap();
								nmap.putAll((Map)oldValue);
								nmap.putAll((Map)newValue);
								setObject(key, nmap);
							}
						} else if (oldValue instanceof Collection) {
							ArrayList nlist = new ArrayList();
							nlist.addAll((Collection)oldValue);
							
							boolean failed = true;
							try {
								for (Object o: (Collection) newValue) {
									if (!((Collection) oldValue).contains(o)) {
										((Collection) oldValue).add(o);
									}
								}
								failed = false;
							} catch (UnsupportedOperationException e) {
							}
							if (failed) {
								for (Object o: (Collection) newValue) {
									if (!(nlist.contains(o))) {
										nlist.add(o);
									}
								}
								setObject(key, nlist);
							}
						} else if (oldValue instanceof String[]) {
							setObject(key, merge((String[])oldValue, (String[])newValue));
						} else if (oldValue instanceof int[]) {
							setObject(key, merge((int[])oldValue, (int[])newValue));
						} else if (oldValue instanceof double[]) {
							setObject(key, merge((double[])oldValue, (double[])newValue));
						} else if (oldValue instanceof Object[]) {
							setObject(key, merge((Object[])oldValue, (Object[])newValue));
						} else if ((""+oldValue).equals(""+newValue) || oldValue.equals(newValue)) {
							// the same value, do nothing
						} else {
							RtdruidLog.showDebug("Different values of properties (key="+key+", v1 = "+oldValue+", v2 = "+newValue+")\n\t"+this+"\n\t"+source);
						}
						
						
						
					}
					
					
				}
				
				
				
				
				
				
			} else {
				setObject(key, entry.getValue());
			}
		}
	}
	
	private int[] merge(int[] v1, int[] v2) {
		if (v1.length == 0) {
			return Arrays.copyOf(v2, v2.length);
		}
		if (v2.length == 0) {
			return Arrays.copyOf(v1, v1.length);
		}
		
		// v1>0 && v2>0
		
		int finalSize = v1.length;
		int[] temp = Arrays.copyOf(v1, v1.length + v2.length);
		
		for (int newElem: v2) {
			
			boolean add = true;
			for (int oldElem: temp) {
				if (add && oldElem == newElem) {
					add = false;
				}
			}
			
			if (add) {
				temp[finalSize] = newElem;
				finalSize ++;
			}
		}
		
		int[] answer;
		if (finalSize == temp.length) {
			answer = temp;
		} else {
			answer = Arrays.copyOf(temp, finalSize);
		}
		
		
		return answer;
	}
	private double[] merge(double[] v1, double[] v2) {
		if (v1.length == 0) {
			return Arrays.copyOf(v2, v2.length);
		}
		if (v2.length == 0) {
			return Arrays.copyOf(v1, v1.length);
		}
		
		// v1>0 && v2>0
		
		int finalSize = v1.length;
		double[] temp = Arrays.copyOf(v1, v1.length + v2.length);
		
		for (double newElem: v2) {
			
			boolean add = true;
			for (double oldElem: temp) {
				if (add && oldElem == newElem) {
					add = false;
				}
			}
			
			if (add) {
				temp[finalSize] = newElem;
				finalSize ++;
			}
		}
		
		double[] answer;
		if (finalSize == temp.length) {
			answer = temp;
		} else {
			answer = Arrays.copyOf(temp, finalSize);
		}
		
		
		return answer;
	}
	private <T> T[] merge(T[] v1, T[] v2) {
		if (v1.length == 0) {
			return Arrays.copyOf(v2, v2.length);
		}
		if (v2.length == 0) {
			return Arrays.copyOf(v1, v1.length);
		}
		
		// v1>0 && v2>0
		
		int finalSize = v1.length;
		T[] temp = Arrays.copyOf(v1, v1.length + v2.length);
		
		for (T newElem: v2) {
			
			if (newElem != null) {
				
				boolean add = true;
				for (T oldElem: temp) {
					if (add && oldElem != null && (
							(oldElem == newElem) || oldElem.equals(newElem))
							) {
						add = false;
					}
				}
				
				if (add) {
					temp[finalSize] = newElem;
					finalSize ++;
				}
			}
		}
		
		T[] answer;
		if (finalSize == temp.length) {
			answer = temp;
		} else {
			answer = Arrays.copyOf(temp, finalSize);
		}
		
		
		return answer;
	}
}