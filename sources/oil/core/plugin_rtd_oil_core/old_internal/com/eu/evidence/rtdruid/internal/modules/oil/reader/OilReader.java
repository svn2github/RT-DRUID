/*
 * Created on 11-nov-2004
 *
 * $Id: OilReader.java,v 1.7 2008/03/26 18:23:51 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.oil.reader;



import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.w3c.dom.Document;

import com.eu.evidence.rtdruid.Rtd_corePlugin;
import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.epackage.EPackageFactory;
import com.eu.evidence.rtdruid.epackage.EPackageUtility;
import com.eu.evidence.rtdruid.epackage.IEPackageMerge;
import com.eu.evidence.rtdruid.epackage.RTDEPackageBuildException;
import com.eu.evidence.rtdruid.internal.modules.oil.implementation.OilImplCollector;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OilImplFactory;
import com.eu.evidence.rtdruid.modules.oil.implementation.IOilImplID;
import com.eu.evidence.rtdruid.modules.oil.implementation.IOilImplementation;
import com.eu.evidence.rtdruid.modules.oil.implementation.OilEcoreCreator;
import com.eu.evidence.rtdruid.modules.oil.interfaces.IOilReader;
import com.eu.evidence.rtdruid.modules.oil.transform.IOilTransform;
import com.eu.evidence.rtdruid.modules.oil.transform.OilTransformFactory;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.VarTreeUtil;

/**
 * This class asks for a Oil file, looks through it and stores its data in
 * BuilderStorage and in the tree of shared Variables.
 * 
 * @see OilParser
 * 
 * @author Nicola Serreli
 */
final public class OilReader implements IOilReader {
	
	/** Default Contructor. */
    public OilReader() {
    }

    /**
     * This method loads an Oil File. To do it, this uses
     * {@link #load(InputStream, IVarTree) load(InputStream, IVarTree)}.
     * 
     * @param where
     *            identifies the file from which load all data.
     * @param vt
     *            the data tree where store all results
     */
    public void load(String where, IVarTree vt) {

    	IncludeSupport incSup = new IncludeSupport(".");
    	incSup.addLibPath(new OilLibsFactory().getDirectories());
    	
        try {
        	String content = incSup.compose(where, false);
            do_load(new ByteArrayInputStream(content.getBytes()), vt);
        } catch (java.io.FileNotFoundException e) {
        	RtdruidLog.log(e);
            throw new RuntimeException(
                    "OilReader: file to load not found . File name =" + where);
        } catch (IOException e) {
        	RtdruidLog.log(e);
        	throw new RuntimeException(
                    "OilReader: Cannot to load the file " + where, e);
		}
    }

    
    /**
     * This method tries to parse an input stream as Oil Data; then it stores
     * the implementation part into OilImplFactory and the application part
     * inside the given VarTree. To do this last point, uses Oil-Transform
     * classes. <br>
     * <br>
     * If there is some errors, it throw some Runtime exception and doen't store
     * data inside the OilImplFactory and, only if a transaction is started
     * inside this function, it tries to undo all changes inside the VarTree.
     * 
     * @param stream
     *            identifies the stream of data.
     * @param vt
     *            the data tree where store all results
     *            
     * @deprecated
     */
    public void load(InputStream stream, IVarTree vt) {
    	load(stream, vt, null, null);
    }
    
    /**
	 * This method tries to parse an input stream as Oil Data; then it stores
	 * the implementation part into OilImplFactory and the application part
	 * inside the given VarTree. To do this last point, uses Oil-Transform
	 * classes. <br>
	 * <br>
	 * If there is some errors, it throw some Runtime exception and doen't store
	 * data inside the OilImplFactory and, only if a transaction is started
	 * inside this function, it tries to undo all changes inside the VarTree.
	 * 
	 * @param stream
	 *            identifies the stream of data.
	 * @param vt
	 *            the data tree where store all results
	 * @param fileName
	 *            used for error messages
	 * @param filePath
	 *            used to include relative paths
	 */
	public void load(InputStream stream, IVarTree vt, String fileName, String filePath) {
    	IncludeSupport incSup = new IncludeSupport(".");
    	incSup.addLibPath(new OilLibsFactory().getDirectories());
    	
        try {
        	String content = incSup.compose(stream, fileName, filePath);
            do_load(new ByteArrayInputStream(content.getBytes()), vt);
        } catch (IOException e) {
        	RtdruidLog.log(e);
        	throw new RuntimeException(
                    "OilReader: Cannot to load the oil file", e);
		}
    }
    
    /**
     * This method tries to parse an input stream as Oil Data; then it stores
     * the implementation part into OilImplFactory and the application part
     * inside the given VarTree. To do this last point, uses Oil-Transform
     * classes. <br>
     * <br>
     * If there is some errors, it throw some Runtime exception and doen't store
     * data inside the OilImplFactory and, only if a transaction is started
     * inside this function, it tries to undo all changes inside the VarTree.
     * 
     * @param stream
     *            identifies the stream of data.
     * @param vt
     *            the data tree where store all results
     */
    protected void do_load(InputStream stream, IVarTree vt) {
        OilInfo parsed = null;

        // Create the parser
        OilParser op = new OilParser(stream);
        
//        // enable Default Implemental x E.E.
//        op.setDefaultImplementationFile(DEFAULT_EE_IMPL);

        // Parse the Oil stream
        try {
            parsed = op.start();
        } catch (ParseException e) {
        	//e.printStackTrace();
            throw new RuntimeException(
                    "OilReader: exception during the parse.\n" + e.getMessage(), 
                            e);
        } catch (RuntimeException e) {
        	//e.printStackTrace();
            throw new RuntimeException(
                    "OilReader: exception during the parse." //\n\t"+ e.getMessage());
            				, e);
        }
        
        IOilImplID oid;
		OilImplFactory oif = OilImplFactory.getAnInstance(vt);
        if (parsed.getName() == null) {
        	// add every implementation defined using Extention Point
    		for (IOilImplementation impl : OilImplCollector.getAllOilImplementation()) {
    			oif.merge(impl);
    		}
    		
    		IOilImplID[] ids = oif.getImplNames();
    		if (ids.length == 1) {
    			oid = ids[0];
    		} else {
    			throw new RuntimeException("Cannot choose which ID use.");
    		}
    		
        	
        } else {
	
	        // make an oil id
	        oid = OilTransformFactory.INSTANCE.getOilId(parsed.name);
	
	        // Add the implemetation part to OilImplFactory
	        IOilImplementation oldImpl = oif.getImpl(oid);
	        if (oif.merge(oid, parsed.getImpl())) {
	        	// compute a new EPackage !!!
	        	if (vt.newVarTreePointer().goFirstChild()) {

	        		try {
	    				EPackage ePkg = createEPackage(oif, false);
						VarTreeUtil.mergeEPackage(vt, ePkg);
					} catch (RTDEPackageBuildException e) {
						oif.remove(oid);
						if (oldImpl != null) {
							oif.add(oldImpl);
						}
						
						throw new RuntimeException(e);
					}

	        	} else {

	        		try {
		        		VarTreeUtil.VarTreeCreator.addEPackage(vt, createEPackage(oif, true));
		    		} catch (RTDEPackageBuildException e) {
						oif.remove(oid);
						if (oldImpl != null) {
							oif.add(oldImpl);
						}
		    			throw new RuntimeException(e);
		    		}

	        	}
	        } else {
	            throw new RuntimeException("The oil id ("+oid+") is already assigned to a different Oil Implementation: It's impossible to load the given oil data.");
	        }
        }

        // Ask to store all data
        boolean startTransaction = vt.getCurrentTransaction() == null;
        if (startTransaction) {
            vt.beginTransaction().setLabel("Oil Import");
        }
        try {

        	IOilTransform ot = OilTransformFactory.INSTANCE.getTransform(oid.getImplementationName());
        	ot.load(vt, parsed.getAppl(), oid);

        } catch (RuntimeException e) {
        	//Messages.sendError(e.getMessage(), null, "oil_reader", null);
            if (startTransaction) {
                vt.rollbackTransaction();
            }
            throw e;
        } finally {
            if (startTransaction) {
                vt.commitTransaction();
            }
        }

    }
    
    
    private EPackage createEPackage(OilImplFactory oif, boolean addBase) throws RTDEPackageBuildException {
		IEPackageMerge merger = EPackageUtility.instance.getPackageMerge();
		merger.addEPackage(EcoreFactory.eINSTANCE.createEPackage());

		if (addBase) {
    		EPackageFactory epkgFactory = EPackageFactory.getFactory();
    		EPackage base = epkgFactory.getEPackageFactoryElement(Rtd_corePlugin.EPACKAGE_BASE_ID).getFactory().getEPackage();
    		merger.addEPackage(base);
		}

		IOilImplID[] ids = oif.getImplNames();
		for (IOilImplID id : ids) {
			IOilImplementation impl = oif.getImpl(id);
			
			OilEcoreCreator oec = OilEcoreCreator.getCreator(impl);
			EPackage ePkg = oec.buildPackage();
			if (ePkg != null) {
				merger.addEPackage(ePkg);
			}
		}
		return merger.getResult();
    }
    
    public Document loadAsXml(InputStream stream, String fileName, String filePath) {
    	IncludeSupport incSup = new IncludeSupport(".");
    	incSup.addLibPath(new OilLibsFactory().getDirectories());
    	
        try {
        	String content = incSup.compose(stream, fileName, filePath);
        	
        	
        	
            OilInfo parsed = null;

            // Create the parser
            OilParser op = new OilParser(new ByteArrayInputStream(content.getBytes()));
            
            // Parse the Oil stream
            try {
                parsed = op.start();
            } catch (ParseException e) {
            	//e.printStackTrace();
                throw new RuntimeException(
                        "OilReader: exception during the parse.\n" + e.getMessage(), 
                                e);
            } catch (RuntimeException e) {
            	//e.printStackTrace();
                throw new RuntimeException(
                        "OilReader: exception during the parse." //\n\t"+ e.getMessage());
                				, e);
            }
        	
            return parsed.getAppl();
        } catch (IOException e) {
        	RtdruidLog.log(e);
        	throw new RuntimeException(
                    "OilReader: Cannot to load the oil file", e);
		}
    }

//    /**
//	 * This method tries to stores the default EE implementation part into
//	 * OilImplFactory and the application part inside the given VarTree. To do
//	 * this last point, uses Oil-Transform classes. <br>
//	 * <br>
//	 * If there is some errors, it throw some Runtime exception and doen't store
//	 * data inside the OilImplFactory and, only if a transaction is started
//	 * inside this function, it tries to undo all changes inside the VarTree.
//	 * 
//	 * @param vt
//	 *            the data tree where store all results
//	 */
//    public void storeDefaultEEImpl(IVarTree vt) {
//        OilInfo parsed = null;
//
//        // Create the parser
//        OilParser op = new OilParser(new ByteArrayInputStream("".getBytes()));
//        
//        // enable Default Implemental x E.E.
//        op.setDefaultImplementationFile(DEFAULT_EE_IMPL);
//
//        // Parse the Oil stream
//        try {
//            parsed = op.start();
//        } catch (ParseException e) {
//        	//e.printStackTrace();
//            throw new RuntimeException(
//                    "OilReader: exception during the parse.\n" + e.getMessage(), 
//                            e);
//        } catch (RuntimeException e) {
//        	//e.printStackTrace();
//            throw new RuntimeException(
//                    "OilReader: exception during the parse." //\n\t"+ e.getMessage());
//            				, e);
//        }
//        
//
//        // make an oil id
//        OilImplID oid = OilTransformFactory.INSTANCE.getOilId(parsed.name);
//
//        // Add the implemetation part to OilImplFactory
//        OilImplFactory oif = OilImplFactory_Impl.getAnInstance(vt);
//        if (!oif.add(oid, parsed.getImpl())) {
//            throw new RuntimeException("The oil id ("+oid+") is already assigned to a different Oil Implementation: It's impossible to load the given oil data.");
//        }
//
//    }

}