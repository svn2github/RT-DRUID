package com.eu.evidence.rtdruid.vartree.variables;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map.Entry;

import com.eu.evidence.rtdruid.vartree.IVariable;


/**
 * This class can be used to maintain, for each mode, a HashMap from a Task to
 * every proc that is mapped to it. It implements the IVariable interface to be
 * compatible with IVarTreePoint.
 * 
 * Note: set(String) has no meaning.
 * 
 * @see rtdruid.vartree.variables.IVariable
 * 
 * @author Nicola Serreli
 */
public class FastTaskToProcVar implements IVariable  {

	/**
	 * This class is used to store the mapping from a Task to every proc that is
	 * mapped to it.
	 */
	public final static class Task2ProcMap implements Cloneable {
		/**
		 * This structure is used to store the link from a mode to a task and from a
		 * task to procs
		 */
		protected HashMap<String, LinkedHashSet<String>> task2proc 
				= new LinkedHashMap<String, LinkedHashSet<String>>();
		
		
		/** Returns the internal structure */
		public HashMap<String, LinkedHashSet<String>> getTask2proc() {
			return task2proc;
		}
		
		/**
		 * Returns a copy of this object.
		 */
		public Task2ProcMap clone() {
			Task2ProcMap answer = new Task2ProcMap();
			for (Iterator<Entry<String, LinkedHashSet<String>> > iter = task2proc.entrySet().iterator(); iter.hasNext(); ) {
				Entry<String, LinkedHashSet<String>> entry = iter.next();
				answer.addProcs(entry.getKey(), entry.getValue());
			}
			return answer;
		}
		
		
		// ---------- GET LIST ----------
		
		/**
		 * Returns the list of procs mapped to specified task. can return null
		 * if there is no mapping for specified task.
		 */
		public LinkedHashSet<String> getProcs(String task) {
			return task2proc.get(task);
		}

		/**
		 * Returns the list of procs mapped to specified task. Is different from
		 * getProcs, because if there is no mapping for specified task, this
		 * method creates a new (and empty) list.
		 */
		public LinkedHashSet<String> createProcList(String task) {
			LinkedHashSet<String> answer;
			if (task2proc.containsKey(task)) {
				answer = task2proc.get(task);
			} else {
				answer = new LinkedHashSet<String>();
				task2proc.put(task, answer);
			}
			return answer;
		}
		
		// ---------- CHECK ----------
		
		/** Returns true if there is a list of mapped procs for the specified task */
		public boolean containsTask(String task) {
			return task2proc.containsKey(task);
		}

		/** Returns true if there is the specified proc is mapped to the specified task */
		public boolean containsProc(String task, String proc) {
			LinkedHashSet<String> t = task2proc.get(task);
			return t!= null && t.contains(proc);
		}
		
		// ---------- ADD ----------

		/** Adds an empty relation for specified task. (see also createProcList) */
		public void addTask(String task) {
			createProcList(task);
		}

		/** Adds the relation from task to each proc */
		public void addProcs(String task, String[] procs) {
			LinkedHashSet<String> list = createProcList(task);
			for (String proc: procs) {
				list.add(proc);
			}
		}
		/** Adds the relation from task to each proc */
		public void addProcs(String task, Collection<String> procs) {
			createProcList(task).addAll(procs);
		}
		/** Adds the relation from task to a proc */
		public void addProc(String task, String proc) {
			createProcList(task).add(proc);
		}
		
		// ---------- REMOVE ----------

		/** Removes every relations */
		public void clear() {
			task2proc.clear();
		}

		/** Removes every relations for the specified task */
		public void removeTask(String task) {
			LinkedHashSet<String> list = getProcs(task);
			if (list != null) {
				task2proc.remove(task);
			}
		}

		/** Removes the relation from task to each proc */
		public void removeProcs(String task, String[] procs) {
			LinkedHashSet<String> list = getProcs(task);
			if (list != null) {
				for (String proc: procs) {
					list.remove(proc);
				}
			}
		}
		/** Removes the relation from task to each proc */
		public void removeProcs(String task, Collection<String> procs) {
			LinkedHashSet<String> list = getProcs(task);
			if (list != null) {
				list.removeAll(procs);
			}
		}
		/** Removes the relation from task to a proc */
		public void removeProc(String task, String proc) {
			LinkedHashSet<String> list = getProcs(task);
			if (list != null) {
				list.remove(proc);
			}
		}
		
		/** To String */
		public String toString() {
			
			StringBuffer buffer = new StringBuffer();
			
			for (Iterator<Entry<String, LinkedHashSet<String>> > iter = task2proc.entrySet().iterator(); iter.hasNext(); ) {
				Entry<String, LinkedHashSet<String>> entry = iter.next();
				
				buffer.append("Task -> " + entry.getKey());
				for (String proc : entry.getValue()) {
					buffer.append(" '" + proc + "'");
				}
				buffer.append("\n");
			}
			
			
			return buffer.toString();
		}
	};

	/*
	 * 
	 * 
	 * 
	 * 
	 */
	
	/**
	 * This structure is used to store the link from a mode to a task and from a
	 * task to procs
	 */
	protected HashMap<String, Task2ProcMap> mode2task2proc = new LinkedHashMap<String, Task2ProcMap>();
	
	
	public FastTaskToProcVar() {}
	
	public FastTaskToProcVar(String value) {
		set(value);
	}
	
	/**	This method is a front-end to default constructor
	*
	*	@return a new instance of this BooleanVar
	*/
	public IVariable instance() {
		return new FastTaskToProcVar();
	}
	
// ----------------------   Creation   ----------------------
	
	
	@Override
	public Object clone()  {
		FastTaskToProcVar answer = new FastTaskToProcVar();
		
		for (Entry<String, Task2ProcMap> entry : mode2task2proc.entrySet()) {
			answer.mode2task2proc.put(entry.getKey(), entry.getValue().clone());
		}
		
		return answer;
	}
	
	

	// ----------------------   IVariable Methods   ----------------------

	/**	Sets the value of this IVariable
	*
	*	@param	value	the datum: only "true"  means true (case insensitive); all other values means false.
	*/
	public void set(String value) {
		// do nothing
	}

	
	//@Override
	public Object get() {
		return mode2task2proc;
	}
	//@Override
	public void dispose() {
		mode2task2proc.clear();
	}
	
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		
		for (Entry<String, Task2ProcMap> entry : mode2task2proc.entrySet()) {
			buffer.append("Mode -> " + entry.getKey() + ":\n" + entry.getValue());
		}
		
		return buffer.toString();
	}
	

	// ----------------------   SET && GET  ----------------------

	/**	Returns the map for a specified mode. Note: the result can be null
	*/
	public Task2ProcMap getMap(String mode) {
		return mode2task2proc.get(mode);
	}
	
	/**	Returns the map for a specified mode. Note: the result can be null
	*/
	public LinkedHashSet<String> getProcs(String mode, String task) {
		LinkedHashSet<String> answer = mode2task2proc.containsKey(mode) ? mode2task2proc.get(mode).getProcs(task) : null ;
		return answer == null ? new LinkedHashSet<String>() : answer;
	}
	
	/**	Returns true if there is a map for a specified mode.
	*/
	public boolean containsMap(String mode) {
		return mode2task2proc.containsKey(mode);
	}

	/**
	 * Returns the map for a specific mode. If there wasn't any map, this method
	 * creates a new one, before return it.
	 */
	public Task2ProcMap createMap(String mode) {
		Task2ProcMap answer;
		if (mode2task2proc.containsKey(mode)) {
			answer = mode2task2proc.get(mode);
		} else {
			answer = new Task2ProcMap();
			mode2task2proc.put(mode, answer);
		}
		return answer;
	}

	/**	Remove the map for a specified mode.
	*/
	public void removeMap(String mode) {
		mode2task2proc.remove(mode);
	}

}

