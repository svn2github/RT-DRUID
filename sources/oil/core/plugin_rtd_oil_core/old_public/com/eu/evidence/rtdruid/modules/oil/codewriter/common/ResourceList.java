/*
 * Created on Dec 17, 2004
 *
 * $Id: ResourceList.java,v 1.5 2008/05/14 17:13:29 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.codewriter.common;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.eu.evidence.rtdruid.internal.modules.oil.keywords.ISimpleGenResKeywords;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList;
import com.eu.evidence.rtdruid.modules.oil.abstractions.ISimpleGenRes;
import com.eu.evidence.rtdruid.modules.oil.abstractions.SimpleGenRes;
import com.eu.evidence.rtdruid.modules.oil.keywords.IOilXMLLabels;
import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;

/**
 * Stores all resource, groupping chains and calculating ceiling
 * 
 * @author Nicola Serreli
 * 
 * UPDRTD split in "common" part and "EE" part 
 */
public class ResourceList {
	
	/* Where found data inside the oil var of a resource */
	protected final static String RESOURCE_PROPERTY = "RESOURCEPROPERTY";
	protected final static String RESOURCE_LINKED = "LINKEDRESOURCE";
	
	public static final String RES_INTERNAL = "INTERNAL";
	public static final String RES_LINKED = "LINKED";
	public static final String RES_STANDARD = "STANDARD";
	
	// --------------------------
	
	/** Abbreviation for VarTree.SEPARATOR */
	private final static char S = IVarTree.SEPARATOR;

	/** Identifies an INTERNAL reource */
	public static final int INTERNAL = ISimpleGenResKeywords.RESOURCE_INTERNAL;

	/** Identifies a LINKED reource */
	public static final int LINKED = ISimpleGenResKeywords.RESOURCE_LINKED;

	/** Identifies a STANDARD reource */
	public static final int STANDARD = ISimpleGenResKeywords.RESOURCE_STANDARD;
	

	/**
	 * This little class group all info about a resource (or a group of
	 * resource), without name (for name, see
	 * {@link ResourceList.ResName ResName}).
	 * 
	 * @author Nicola Serreli
	 */
	protected class ResInfo {
		/** The ceiling of this resource */
		int[] ceiling;

		/** The type of this resource */
		int type;

		/** True if this reource is global */
		boolean global = false;

		/** Identifies where this resource is allocated */
		BitSet cpu;

		/** Explicit Source files (null if none) */
		String[] srcFiles = null;
		
		/** List of resources that compose a chain */
		ArrayList<String> chainNames = new ArrayList<String>();
		
		/** Name of the root resource of a chain */
		String chainRoot = null;

		/** Make a new Res Info */
		public ResInfo(int numOfRtos) {
			cpu = new BitSet();
			ceiling = new int[numOfRtos];
		}

		/**
		 * Returns the ceiling
		 * 
		 * @return the ceiling of current resource
		 */
		public int[] getCeiling() {
			return ceiling;
		}

		/**
		 * Returns the type
		 * 
		 * @return the type of current resource
		 */
		public int getType() {
			return type;
		}

		/**
		 * Returns if this reource is global
		 * 
		 * @return true if this reource is global
		 */
		public boolean getGlobal() {
			return global;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		public String toString() {
			StringBuffer ceilingTxt = new StringBuffer();
			if (ceiling == null) {
				ceilingTxt.append("null");
			} else {
				ceilingTxt.append("[");
				for (int i=0; i<ceiling.length; i++) {
					ceilingTxt.append(
							(i==0 ? "" : ",") + ceiling[i]);
				}
				ceilingTxt.append("]");
			}
			return ">>ResInfo: type "+type +"; global "+global
				+ "; cpu "+cpu+" & ceiling "+ceilingTxt+"); "
				+ "chainRoot " + chainRoot + " & chain " + chainNames
				+ "; src"
				+ (srcFiles!=null? Arrays.asList(srcFiles) : null)
				+ "<<";
		}
	}

	/**
	 * This little class makes a link between a resource and it's name
	 * 
	 * @author Nicola Serreli
	 */
	protected class ResName implements Comparable {
		/** The name (whitout protection for special characters) */
		private String nome;
		
		private String path;

		/** The position in "infoRis" list */
		private int pos;

		private final int resType;
		
		/**
		 * Makes a new link
		 * 
		 * @param name
		 *            the resource Name (whitout protection for special
		 *            characters)
		 * @param index
		 *            the position of current resource's description in
		 *            "infoRis" list
		 */
		ResName(String name, int index, int type) {
			nome = name;
			pos = index;
			resType = type;
		}

		/**
		 * Compares this object to given object (a ResName or a String)
		 */
		public int compareTo(Object o) {
			if (o instanceof ResName) { // "o" is a ResName
				ResName p = (ResName) o;
				return nome.compareTo(p.nome); // compare between two string
			}
			// else -> No problem if "o" is a string, exception otherwise
			return nome.compareTo(""+o);
		}

		/**
		 * Returns the position of current resource's description in "infoRis"
		 * list
		 * 
		 * @return position of current resource's description in "infoRis" list
		 */
		public int getIndex() {
			return pos;
		}

		/**
		 * Returns the name of current resource
		 * 
		 * @return the name of current resource
		 */
		public String getName() {
			return nome;
		}
		
		/**
		 * @return Returns the resource Type.
		 */
		public int getResType() {
			return resType;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		public String toString() {
			return "ResName " + nome + " (type "+resType
			+"; index "+pos+"; path "+path+")";			
		}
	}

	/**
	 * This little class group, for each resource, this data : name, type,
	 * resources linked
	 * 
	 * @author Nicola Serreli
	 */
	private class ResourceTmp implements Comparable {
		/** The name */
		public String name;

		/**
		 * A list of dependence, for chains of resource (which resources are
		 * linked to currente respurce)
		 */
		public LinkedList dep;

		/** The type */
		public int type;

		/**
		 * A dependence for chains of resource (this resource is linked to which
		 * resource)
		 */
		public String linkTo = null;
		
		/** Explicit Source files (null if none) */
		public String[] srcFiles = null;

		/**
		 * Make a new ResourceTmp. <br>
		 * Takes "pname" with special characters protection and remove it before
		 * store the name.
		 * 
		 * @param pname
		 *            the name
		 * @param ptype
		 *            the type
		 */
		public ResourceTmp(String pname, int ptype) {
			name = DataPath.removeSlash(pname);
			type = ptype;
			dep = new LinkedList();
		}

		/**
		 * Make a void ResourceTmp
		 */
		public ResourceTmp() {
			name = null;
			type = 0;
			dep = null;
		}

		/**
		 * Searches a ResourceTmp with given name. Doesn't do any check.
		 * 
		 * @param vet
		 *            a list of ResourceTmp
		 * @param size
		 *            the current size of legal ResourceTmp in vet
		 * @param name
		 *            the name to search
		 */
		public int search(ResourceTmp[] vet, int size, String name) {
			for (int i = 0; i < size; i++) {
				if (name.equals(vet[i].name))
					return i;
			}
			return -1;
		}

		/**
		 * Compare this object to given object (a ResName or a String)
		 */
		public int compareTo(Object o) {
			if (o instanceof ResourceTmp) { // "o" is a ResName
				ResourceTmp p = (ResourceTmp) o;
				return name.compareTo(p.name); // compare between two string
			}
			// else -> No problem if "o" is a string, exception otherwise
			return name.compareTo(""+o);
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		public String toString() {
			return ">>ResourceTmp " + name + " (type "+type
				+"; src "
				+ (srcFiles!=null? Arrays.asList(srcFiles) : null)
				+"); linked to " + linkTo+ " & from " + dep+"<<";			
		}
	}

	/** Resource's Names */
	private ArrayList nomiRis;

	/** Resource's Data */
	private ArrayList infoRis;

	/**
	 * Searces all resources and stores all data inside the given OilObjectList array.
	 * 
	 * @param prefix
	 *            contains the path in which look for resources
	 * @param oilObjects
	 *            contains all objects (only tasks are required)
	 */
	public ResourceList(IVarTree vt, String prefix, String oilPrefix,
			IOilObjectList[] oilObjects, boolean useResScheduler) {

		final LinkedList rTt;
		{
			ITreeInterface ti = vt.newTreeInterface();
			LinkedList pendenti = new LinkedList(); // store a link to a resource
													// Not already visited
			final DataPackage dpkg = DataPackage.eINSTANCE;
	
			/***********************************************************************
			 * 
			 * get all resource data
			 *  
			 **********************************************************************/
			String tmpPref = prefix + S
					+ dpkg.getArchitectural_MutexList().getName() +S;
			String[] resName = ti.getAllName(tmpPref, dpkg.getMutex().getName());
	
			ResourceTmp[] rTemp = new ResourceTmp[resName.length];
			int resNumb = resName.length;
			for (int i = 0; i < resNumb; i++) {
	
				String currPrefix = tmpPref + resName[i]+S+dpkg.getMutex_OilVar().getName() +S+IOilXMLLabels.OBJ_RESOURCE+ oilPrefix;
				
				String[] newName = new String[1];
				// if the function returns a null type, it's always different from AutoOption 
				String resType = CommonUtils.getFirstChildEnumType(vt, currPrefix + RESOURCE_PROPERTY, newName);
				currPrefix += RESOURCE_PROPERTY+CommonUtils.VARIANT_ELIST + newName[0] + CommonUtils.PARAMETER_LIST;
	
				if (RES_STANDARD.equalsIgnoreCase(resType)) {
					// -------- RES_STANDARD ------------
					rTemp[i] = new ResourceTmp(resName[i], STANDARD);
	
					// --------- SRC ----------
					String[] srcFiles = CommonUtils.getValue(vt, currPrefix + "APP_SRC");
					if (srcFiles != null) {
						rTemp[i].srcFiles = srcFiles;
					}
	
				} else if (RES_LINKED.equalsIgnoreCase(resType)) {
					// -------- RES_LINKED ------------
	
					String[] tmp = CommonUtils.getValue(vt, currPrefix + RESOURCE_LINKED);
					if (tmp == null || tmp.length !=1)
						throw new RuntimeException(
								"Resources : Expected a not null resource type for a linked resource."
										+ " (resource = " + resName[i] + ")");
	
					rTemp[i] = new ResourceTmp(resName[i], LINKED);
					rTemp[i].linkTo = tmp[0];
	
					int pos = (new ResourceTmp()).search(rTemp, i, tmp[0]);
	
					if (pos == -1) { // store a link
						String[] link = { tmp[0], resName[i] };
						pendenti.add(link);
					} else {
						rTemp[pos].dep.add(resName[i]);
					}
					
				} else if (RES_INTERNAL.equalsIgnoreCase(resType)) {
					// -------- RES_INTERNAL ------------
					rTemp[i] = new ResourceTmp(resName[i], INTERNAL);
	
				} else {
					throw new RuntimeException(
							"Resources: unexpected resource type : resource = "
									+ resName[i] + ", type = " + resType);
				}
	
	
			}
	
			/***********************************************************************
			 * 
			 * check links between resources
			 *  
			 **********************************************************************/
	
			// set stored link
			for (Iterator iter = pendenti.iterator(); iter.hasNext(); ) {
				String[] p = (String[]) iter.next();
	
				int pos = (new ResourceTmp()).search(rTemp, resNumb, p[0]);
	
				if (pos == -1) { // store a link
					throw new RuntimeException(
							"Resources: link to a non-existent resource : from = "
									+ p[1] + " -> to = " + p[0]);
				}
	
				rTemp[pos].dep.add(p[1]);
			}
			
			rTt = new LinkedList(Arrays.asList(rTemp));
		}

		// move data and check for chains
		int pos = 0; // contains the Index of last added resourceInfo
		nomiRis = new ArrayList();
		infoRis = new ArrayList();
		//rTt = new LinkedList(Arrays.asList(rTemp));
		Collections.sort(rTt);
		while (rTt.size() > 0) {
			ResourceTmp risorsa = (ResourceTmp) rTt.removeFirst();

			ResInfo r = new ResInfo(oilObjects.length);
			infoRis.add(r);
			
			/*
			 * Fill the ResInfo fields :
			 * - The type.
			 * 
			 * The method makeGroup'll fill other fields 
			 * - The list of sources (usefull only for INTERNAL and STANDARD resources).
			 * - The first element of a chain of resources
			 * - If this resource isn't linked to another, it's the root of a chain (if exist a chain) 
			 */
			r.type = risorsa.type;
			
			// search where store new name
			int i = Collections.binarySearch(nomiRis, risorsa.name);
			// if (i>0) { // impossible !!
			nomiRis.add(-i - 1, new ResName(risorsa.name, pos, risorsa.type));

			makeGroup(risorsa, null, rTt, r, pos);
			pos++; // update index
		}
		
		/***********************************************************************
		 * 
		 * check links between resources and tasks
		 *  
		 **********************************************************************/

		// set resource ceiling and "local/global"
		// 1) get for each task, its priority and list of resources
		// 2) if necessary, increment the priority of task's resources and all
		// resources linked to them
		// 3) if task has remote activation, set to "global" all resources used
		// by this task (and all resources linked to them)
		
		// remember the max priorities
		int[] maxpriorities = new int[oilObjects.length];

		for (int cpuId = 0; cpuId < oilObjects.length; cpuId++) {
			
			maxpriorities[cpuId] = 0;
			
			for (Iterator iter = (oilObjects[cpuId].getList(IOilObjectList.TASK)).iterator(); iter.hasNext(); ) {

				ISimpleGenRes currTask = (ISimpleGenRes) iter.next();

				/** TASK's PRIORITY ==> RESOURCE's CEILING (prio) */
				int prio = currTask.getInt(ISimpleGenResKeywords.TASK_READY_PRIORITY);
				
				if (maxpriorities[cpuId] < prio) { // check max priority of this cpu
					maxpriorities[cpuId] = prio;
				}

				/** GLOBAL TASK ? ==> GLOBAL RESOURCE (remote) */
				// remote ?
				//boolean remote = currTask.containsProperty(SimpleGenResKeywords.TASK_REMOTE) ? "true".equalsIgnoreCase(currTask
				//		.getString(SimpleGenResKeywords.TASK_REMOTE))
				//		: false;

				/** CPU for this TASK (cpuId) */
				// int cpuId;
				
				/** PREEMPTABLE TASK */
				boolean preemptable = "FULL".equals(currTask.getString(ISimpleGenResKeywords.TASK_SCHEDULE));
				
				/** LIST of RESOURCES (tRes) */
				String[] tRes;
				if (currTask.containsProperty(ISimpleGenResKeywords.TASK_RESOURCE_LIST)) {
					tRes = (String[]) ((List) currTask.getObject(ISimpleGenResKeywords.TASK_RESOURCE_LIST)).toArray(new String[0]);
				} else {
					tRes = new String[0];
				}

				// check all values for each resource
				for (int j = 0; j < tRes.length; j++) {
					// search resource's description
					int tmppos = Collections.binarySearch(nomiRis, tRes[j]);

					if (tmppos < 0) { // store a link
						throw new RuntimeException(
								"Resources: link to a non-existent resource : from task = "
										+ currTask.getName() + " -> to = "
										+ tRes[j]);
					}
					ResInfo rinfo = (ResInfo) infoRis.get(((ResName) nomiRis
							.get(tmppos)).getIndex()); // description of current
													   // resource

					if (rinfo.ceiling[cpuId] < prio) {
						rinfo.ceiling[cpuId] = prio;
					} // ceiling

					// first set cpuId ..
					rinfo.cpu.set(cpuId); // cpuID

					if (rinfo.type == INTERNAL) {
						if (rinfo.cpu.cardinality() > 1) {
							throw new RuntimeException(
									"Resources: an internal resource ("
											+ tRes[j]
											+ ") is shared between tasks assigned to different processors");
						}
						
						if (!preemptable) {
							throw new RuntimeException(
									"Resources: an internal resource ("
											+ tRes[j]
											+ ") is required by a non preemptable task ("+currTask.getName()+")");
						}
						
					} else {

						// .. then set global
						rinfo.global |= /*remote ||*/ (rinfo.cpu.cardinality() > 1); // global
					}
				}
			}
		}
		
		// set ResScheduler
		if (useResScheduler) {
			addResScheduler(oilObjects);
		}
		
		{ // store all inside the OilObjectList
		
			List[] tmpList = new List[oilObjects.length];
			for (int i=0; i<tmpList.length; i++) {
				tmpList[i] = oilObjects[i].getList(IOilObjectList.RESOURCE);
				
				if (tmpList[i].size()!=0) {
					throw new RuntimeException("already found old resources");
				}
				tmpList[i] = new ArrayList();
			}
			
			// store all names, in each rtos that uses it
			for (Iterator iter = nomiRis.iterator(); iter.hasNext(); ) {
				ResName rname = (ResName) iter.next();
				ISimpleGenRes sgr = new SimpleGenRes(rname.getName(), null);
				
				ResInfo info = (ResInfo) infoRis.get(rname.getIndex());

				if (info.global) {
					// Increase ceiling of global resources !!
					info.ceiling = maxpriorities;
				}

				int type = rname.getResType()
					| (rname.getName().equals(info.chainRoot) ? ISimpleGenResKeywords.RESOURCE_CHAIN_ROOT : 0);
				
				sgr.setProperty(ISimpleGenResKeywords.RESOURCE_GLOBAL, "" + info.global);
				sgr.setProperty(ISimpleGenResKeywords.RESOURCE_TYPE, "" + type);
				sgr.setObject(ISimpleGenResKeywords.RESOURCE_ALLOCATION, info.cpu.clone());
				sgr.setObject(ISimpleGenResKeywords.RESOURCE_CHAIN_LIST, info.chainNames);

				if (info.srcFiles != null) {
					sgr.setObject(ISimpleGenResKeywords.RESOURCE_SRC, info.srcFiles);
				}
//System.err.println(">>" + sgr + "<<\n\n");
				// clone a copy inside all list of resources (they can have differt ceiling and position/id)
				for (int i=0; i<info.cpu.length() && i<tmpList.length; i++) {
					if (info.cpu.get(i)) {
						ISimpleGenRes copy = (ISimpleGenRes) sgr.clone();

						// set an id
						//int id = tmpList[i].size();
						//copy.setProperty(SimpleGenResKeywords.RESOURCE_ID, "" + id);

						copy.setProperty(ISimpleGenResKeywords.RESOURCE_CEILING, "" + info.ceiling[i]);
						tmpList[i].add(copy);
					}
				}
				
			}
			
			for (int i=0; i<tmpList.length; i++) {
				oilObjects[i].setList(IOilObjectList.RESOURCE, (ArrayList) tmpList[i]);
			}
		}
		
		setResourceId(oilObjects);
	}

	/**
	 * Searchs for chains and groups
	 * 
	 * @param current
	 *            the current resource
	 * @param previous
	 *            the previous resource
	 * @param remainder
	 *            remained resources
	 * @param index
	 *            the position of description in infoRis
	 */
	private void makeGroup(ResourceTmp current, ResourceTmp previous,
			LinkedList remainder, final ResInfo resInfo, final int index) {

		// try to store link between a name and a resource description
		if (previous != null) {
			if (resInfo.type == INTERNAL) {
				throw new RuntimeException(
						"Resources: found a chain with an internal resource (contains "
								+ current.name + ")");
			}

			// search where store new name
			int i = Collections.binarySearch(nomiRis, current.name);
			// if (i>0) { // impossible !!
			nomiRis.add(-i - 1, new ResName(current.name, index, current.type));
		}

		/*
		 * Fill the ResInfo fields :
		 * - The type (already set).
		 * - The list of sources (usefull only for INTERNAL and STANDARD resources).
		 * - The first element of a chain of resources
		 * - If this resource isn't linked to another, it's the root of a chain (if exist a chain) 
		 */
		if (current.type == STANDARD) {
			// note : inside a chain/group there is only one STANDARD resource 
			resInfo.srcFiles = current.srcFiles;
		}
		resInfo.chainNames.add(current.name);

		
		if (current.linkTo != null) {

			// only if is a new node
			if (!current.linkTo.equals(previous.name)) {
				int i = Collections.binarySearch(remainder, current.linkTo);
				if (i < 0) {
					throw new RuntimeException(
							"Resources: Wrong link or found a loop (current resource = "
									+ current.name + ", required resource = "
									+ current.linkTo + ")");
				}
				// ok
				ResourceTmp prossima = (ResourceTmp) remainder.remove(i);
				makeGroup(prossima, current, remainder, resInfo, index);
			}
		} else {
			
			// it's the root of a chain/group
			resInfo.chainRoot = current.name;
		}

		// some resources are linked to this resource
		if (resInfo.type == INTERNAL
				&& current.dep.size() > 0) {
			throw new RuntimeException(
					"Resources: found a chain with an internal resource (contains "
							+ current.name + ")");
		}
		// stores linked resources
		Iterator iter = current.dep.iterator();
		while (iter.hasNext()) {
			String tmpName = (String) iter.next();
			// only if is a new node
			if (previous == null || !tmpName.equals(previous.name)) {
				int i = Collections.binarySearch(remainder, tmpName);
				if (i < 0) {
					throw new RuntimeException(
							"Resources: Wrong link or found a loop (current resource = "
									+ current.name + ", required resource = "
									+ tmpName + ")");
				}
				// ok
				ResourceTmp prossima = (ResourceTmp) remainder.remove(i);
				makeGroup(prossima, current, remainder, resInfo, index);
			}
		}
	}

	/**
	 * Returns the list of resources (see {@link ResourceList.ResName ResName})
	 * 
	 * @return all resource's names
	 */
	private ResName[] getResNames() {
		return (ResName[]) nomiRis.toArray(new ResName[0]);
	}

	/**
	 * Returns the descriptions of all resources (see
	 * {@link ResourceList.ResInfo ResInfo})
	 * 
	 * @return all resource's descriptions
	 */
	private ResInfo[] getResDescr() {
		return (ResInfo[]) infoRis.toArray(new ResInfo[0]);
	}

	/**
	 * Adds the "RES_SCHEDULER" resource.
	 * 
	 * @param oilObjects
	 *            contains all objects (only tasks are required)
	 * 
	 * @throws IllegalStateException
	 *             if already exist an "RES_SCHEDULER" resource.
	 */
	private void addResScheduler(IOilObjectList[] oilObjects) {
		/* NB: on Erika Enterprise higher values mean higher priorities.
		 * Set ResScheduler's ceiling as highet values to "disable" preemption. */

		// search where store new name
		int posName = Collections.binarySearch(nomiRis, IWritersKeywords.RES_SCHEDULER);
		if (posName > 0) {
			throw new IllegalStateException(
					"Resources: Try to store more times the RES_SCHEDUER resource.");
		}

		// search the max priority
		ResInfo res_sched = new ResInfo(oilObjects.length);
		res_sched.type = STANDARD;
		res_sched.chainRoot = IWritersKeywords.RES_SCHEDULER;
		res_sched.chainNames.add(IWritersKeywords.RES_SCHEDULER);
		for (int cpuId = 0; cpuId < oilObjects.length; cpuId++) {
			
			int maxPrio = 0;
			for (Iterator iter = (oilObjects[cpuId].getList(IOilObjectList.TASK)).iterator(); iter.hasNext(); ) {

				ISimpleGenRes currTask = (ISimpleGenRes) iter.next();

				/** TASK's PRIORITY */
				int prio = currTask.getInt(ISimpleGenResKeywords.TASK_READY_PRIORITY);

				// store maximum
				if (maxPrio < prio)
					maxPrio = prio;

				/** TASK's DISPATCH PRIORITY */
				//prio = currTask.getInt(SimpleGenResKeywords.TASK_DISPATCH_PRIORITY);

				// store maximum
				//if (maxPrio < prio) maxPrio = prio;
			}
			
			// store data of RES_SCHEDULER for this cpu
			res_sched.ceiling[cpuId] = maxPrio;
			res_sched.cpu.set(cpuId);
		}

		res_sched.global = false;

		infoRis.add(res_sched);
		nomiRis.add(-posName - 1, new ResName(IWritersKeywords.RES_SCHEDULER, 
				infoRis.size() - 1, STANDARD));
	}
	
	
	/**
	 * This method sets an ID for each resource.
	 * 
	 * First it sets id for global resource, using littler numbers.
	 * Then, for each cpu it sets id of local resources using littler free numbers. As example :
	 * <code>
	 * cpu1 uses resB and resC<br>
	 * cpu2 uses resA, resC and resD<br>
	 * cpu3 uses resB, resD and resE<br>
	 * <br>
	 * Then global id are : <br>
	 * resB = 0, resC = 1, resD = 2<br>
	 * <br>
	 * And local id are : <br>
	 * resA = 0, resE = 1
	 * because cpu2 doen't use resB and then id =0 is free;
	 * in the same way id = 1 is free for cpu3 
	 * </code>
	 */
	public static void setResourceId(IOilObjectList[] oilObjects) {
		
		// Nothing to do with less than two cpu
		if (oilObjects == null) {
			return;
		}

		// remember all used id of each cpu 
		BitSet[] usedId = new BitSet[oilObjects.length];

		if (oilObjects.length >1) {
			/***********************************************************************
			 * Set global id
			 **********************************************************************/
			// remember computed "ResName <-> Id"
			HashMap resIdMap = new HashMap();
			
			
			int nextGlobalId = 0;
			for (int ooId = 0; ooId<oilObjects.length; ooId++) {
				List resources = oilObjects[ooId].getList(IOilObjectList.RESOURCE);
				
				usedId[ooId] = new BitSet(resources.size());
				
				for (Iterator iter = resources.iterator(); iter.hasNext(); ) {
					ISimpleGenRes curr = (ISimpleGenRes) iter.next();
					
					if (curr.containsProperty(ISimpleGenResKeywords.RESOURCE_GLOBAL) && 
							"true".equalsIgnoreCase(curr.getString(ISimpleGenResKeywords.RESOURCE_GLOBAL))) {
	
					
						String name = curr.getName();
						final int currentId;
						
						if (resIdMap.containsKey(name)) {
							/*
							 * Already checked 
							 */
							currentId = ((Integer) resIdMap.get(name)).intValue();
							
						} else {
							/*
							 * Use a new ID 
							 */
							currentId = nextGlobalId;
							resIdMap.put(name, new Integer(currentId));
							nextGlobalId++;
						}
	
						// set id inside current resource
						curr.setProperty(ISimpleGenResKeywords.RESOURCE_SYS_ID, "" + currentId);
						// remember that this id is used
						// NB : cannot be ==> usedId[ooId].get(currentId) == true
						usedId[ooId].set(currentId);
					}
				}
				
			}
		}

		/***********************************************************************
		 * Set local id
		 **********************************************************************/
		for (int ooId = 0; ooId<oilObjects.length; ooId++) {
			List resources = oilObjects[ooId].getList(IOilObjectList.RESOURCE);
			
			if (usedId[ooId] == null) {
				usedId[ooId] = new BitSet(resources.size());
			}
			
			for (Iterator iter = resources.iterator(); iter.hasNext(); ) {
				ISimpleGenRes curr = (ISimpleGenRes) iter.next();
				
				boolean global = curr.containsProperty(ISimpleGenResKeywords.RESOURCE_GLOBAL) && 
					"true".equalsIgnoreCase(curr.getString(ISimpleGenResKeywords.RESOURCE_GLOBAL));
				
				if (!global) {
					
					// NB : 
					// if (resIdMap.containsKey(name)) {
					//		throw Error("!!!");
					// }

					// search a free id and set as used
					int newId = usedId[ooId].nextClearBit(0);
					usedId[ooId].set(newId);
					
					curr.setProperty(ISimpleGenResKeywords.RESOURCE_SYS_ID, "" + newId);
				}
			}
			
		}

	}
	
	

}