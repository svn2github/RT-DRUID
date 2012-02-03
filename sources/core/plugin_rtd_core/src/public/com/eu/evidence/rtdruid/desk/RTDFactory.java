/*
 * Created on 2-set-2005
 *
 * $Id: RTDFactory.java,v 1.4 2008/03/26 18:23:51 durin Exp $
 */
package com.eu.evidence.rtdruid.desk;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import com.eu.evidence.rtdruid.internal.vartree.VarTree;
import com.eu.evidence.rtdruid.internal.vartree.VarTreeRequiredFactories;
import com.eu.evidence.rtdruid.internal.vartree.data.impl.DataFactoryImpl;
import com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.data.DataFactory;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;

/**
 * This class can be used to build every main object of RT-Druid
 * 
 * @author Nicola Serreli
 */
public final class RTDFactory {

	private static RTDFactory instance = new RTDFactory();

	private ArrayList<IRTDSubFactory> factories = new ArrayList<IRTDSubFactory>();

	public static RTDFactory getDefault() {
		return instance;
	}

	/**
	 * The correct way to build a new VarTree
	 */
	public static IVarTree newVarTree() {
		return new VarTree();
	}

	/**
	 * Used to build a generic object
	 * 
	 * @param type
	 *            identifies the type that have to be build
	 * 
	 * @return a new object or null if this factory doesn't support the required
	 *         type
	 */
	public static Object get(Class<?> type) {
		if (type == IVarTree.class) {
			return newVarTree();
		}

		for (IRTDSubFactory subF : instance.factories) {
			if (subF.isSupported(type)) {
				return subF.get(type);
			}
		}

		// default constructors
		if (type == DataPackage.class) {
			return DataPackage.eINSTANCE;
		}
		if (type == DataFactory.class) {
			return new DataFactoryImpl();
		}
		if (type == IVarTreeRequiredFactories.class) {
			return new VarTreeRequiredFactories();
		}

		return null;
	}

	/**
	 * Used to build a generic object. This method doesn't work if one or more
	 * elements of "values" are null; if is required to use null elements or if
	 * could be some problems with the constructor, use the function get(class,
	 * Class[], Object[]) ).
	 * 
	 * 
	 * @param type
	 *            identifies the type that have to be build
	 * 
	 * @param values
	 *            contains every datum passed to the constructor. They cannot be
	 *            null.
	 * 
	 * @return a new object or null if this factory doesn't support the required
	 *         type
	 * 
	 * @throws NullPointerException
	 *             if one element of values is null. (in that case use
	 *             get(class, Class[], Object[]))
	 */
	public static Object get_(Class<?> type, Object[] values) {

		if (values == null) {
			return get(type);
		}
		
		Class<?>[] cs = new Class[values.length];
		for (int i = 0; i < values.length; i++) {
			if (values[i] != null) {
				cs[i] = values[i].getClass();
			} else {
				throw new NullPointerException(
						"Every value must be not null");
			}
		}
		
		return get(type, cs, values);
	}

	/**
	 * Used to build a generic object. This method work if one or more
	 * elements of "values" are null and calls the constructor that support types specified inside the 
	 * vector value_types.
	 * 
	 * 
	 * @param type
	 *            identifies the type that have to be build
	 *            
	 *            @param value_types specifies the type of each element of the vector "values"
	 * 
	 * @param values
	 *            contains every datum passed to the constructor. They cannot be
	 *            null.
	 * 
	 * @return a new object or null if this factory doesn't support the required
	 *         type
	 * 
	 * @throws NullPointerException
	 *             if value_types is null
	 * @throws IllegalArgumentException
	 *             if value_types and values have different sizes
	 */
	public static Object get(Class<?> type, Class<?>[] value_types,
			Object[] values) {

		if (values == null) {
			return get(type);
		}
		if (value_types == null) {
			throw new NullPointerException("Parameter types cannot be null");
		}
		if (value_types.length != values.length) {
			throw new IllegalArgumentException("Parameter types and values cannot have different sizes");
		}

		/*
		 * Trying to build a new VarTree
		 */
		if (type == IVarTree.class) {

			Constructor<?> constr = null;
			try {
				constr = VarTree.class.getConstructor(value_types);
			} catch (Exception e) {
				RtdruidLog.log(e);
			}
			if (constr != null) {
				try {
					return constr.newInstance(values);
				} catch (Exception e) {
					RtdruidLog.log(e);
				}
			}
		}

		for (IRTDSubFactory subF : instance.factories) {
			if (subF.isSupported(type, value_types)) {
				return subF.get(type, value_types, values);
			}
		}
		//
		// // default constructors
		// if (type == DataPackage.class) {
		// return new DataPackageImpl.Stupid().clone();
		// }
		// if (type == DataFactory.class) {
		// return new DataFactoryImpl();
		// }

		return null;
	}

	/**
	 * This method adds a new factory. If it already exist, it's ignored.
	 * 
	 * @throws NullPointerException if factory is null
	 */
	public static void addFactory(IRTDSubFactory factory) {
		if (factory == null) {
			throw new NullPointerException("The factory cannot be null");
		}
			
		if (!instance.factories.contains(factory)) {
			instance.factories.add(factory);
		}
	}

	/**
	 * This method adds a collection of factories. If a factory already exist,
	 * it's ignored.
	 * 
	 * @throws NullPointerException if one factory is null
	 */
	public static void addFactories(List<IRTDSubFactory> factories) {
		if (factories != null) {
			for (IRTDSubFactory factory : factories) {
				addFactory(factory);
			}
		}
	}
}
