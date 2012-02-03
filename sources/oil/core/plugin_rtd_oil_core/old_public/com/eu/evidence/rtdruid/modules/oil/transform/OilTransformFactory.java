/*
 * Created on 11-nov-2004
 *
 * $Id: OilTransformFactory.java,v 1.1 2008/03/27 12:16:47 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.transform;



import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OilImplID;
import com.eu.evidence.rtdruid.modules.oil.implementation.IOilImplID;



/** Collects all implementations of interface {@link IOilTransform IOilTransform}
 *  Collecting is done by using extension point mechanism.  
 * @author Nicola Serreli
 */

final public class OilTransformFactory {
	private static final TransformDescr[] TRANSFORMS;

 	static {
		IConfigurationElement[] config = Platform.getExtensionRegistry()
				.getConfigurationElementsFor("com.eu.evidence.rtdruid.oil.core.oilTransform");
		assert(config != null);
		int v = 0, l = config.length;
		TransformDescr[] t = new TransformDescr[l];
		for (int i = 0; i < l; i++) {
			IConfigurationElement ce = config[i];
			assert(ce != null);
			if ("transformer".equals(ce.getName())) {
				try {
					Object o = ((IConfigurationElement)ce).createExecutableExtension("class");
					if ( (o != null) && (o instanceof IOilTransform) ) {
						String name = ce.getAttribute("name");
						String rtos = ce.getAttribute("rtos");
						String hw = ce.getAttribute("hw"); // not required
						assert( (name != null) && (rtos != null) );
						t[v++] = new TransformDescr(name, hw, rtos, ((IOilTransform)o).getClass());
					}
				} catch (Throwable e) {
					RtdruidLog.log("Unable to get oil implementation InputStream.", e);
				}
			}
		}
		TRANSFORMS = new TransformDescr[v];
		while (--v > -1)
			TRANSFORMS[v] = t[v];
	}
    /** The default transformer. */
 	static final private TransformDescr DEFAULT_TRANSFORMS =  new TransformDescr("default_transform", "default_hw", "default_rtos", SimpleTransform.class);
    /** the unique instance of OilTransformFactory */
    static final public OilTransformFactory INSTANCE = new OilTransformFactory();

    /** Just to prevent dynamic object creating. */
    private OilTransformFactory() {}
    
    /**
     * Returns the requested transformer if found, or the default otherwise. 
     * @param id The transformer id.
     * @return the OilTransform instance.  
     */
    public IOilTransform getTransform(String id) {
    	try {
        for (int i = 0; i < TRANSFORMS.length; i++) {
				if (id.equalsIgnoreCase(TRANSFORMS[i].getName())) {
					return (IOilTransform) TRANSFORMS[i].getTransformer()
							.getConstructor().newInstance();
				}
			}

			return (IOilTransform) DEFAULT_TRANSFORMS.getTransformer()
					.getConstructor().newInstance();
            
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Oil Transform Factory : " + e.getMessage());
        } catch (InstantiationException e) {
            throw new RuntimeException("Oil Transform Factory : " + e.getMessage());
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Oil Transform Factory : " + e.getMessage());
        } catch (InvocationTargetException e) {
            throw new RuntimeException("Oil Transform Factory : " + e.getMessage());
        } catch (NoClassDefFoundError e) {
            throw new RuntimeException("Oil Transform Factory : " + e.getMessage());
        }
        //throw new IllegalArgumentException("Unknow oil id : " + id);
    }
    
    /**
     * This method searches the given id inside the list of know ids, and convert
     * it into an OilImplId.
     * 
     * @param id the id taken from Oil Stream.
     * @return the OilImplId associated to given id. 
     */
    public IOilImplID getOilId(String oilImplName) {

        Assert.isLegal(oilImplName != null);

        for (int i = 0; i < TRANSFORMS.length; i++) {
            if (oilImplName.equalsIgnoreCase(TRANSFORMS[i].getName())) {
                return new OilImplID(
                		oilImplName,
                        TRANSFORMS[i].getHw(),
                        TRANSFORMS[i].getRtos());
            }
        }
        
        // use default transformer
        return new OilImplID(oilImplName,IWritersKeywords.CPU_UNKNOW, oilImplName);

//        throw new IllegalArgumentException("Unknow oil id : " + oilImplName);
    }

	private static class TransformDescr {
	    private String name;
	    private String hw;
	    private String rtos;
	    private Class<? extends IOilTransform> transformer;

	    TransformDescr(String name, String hw, String rtos, Class<? extends IOilTransform> transformer) {
	        this.name = name;
	        this.hw = hw;
	        this.rtos = rtos;
	        this.transformer = transformer;
	    }

	    public String getName() { return name; }
	    public String getHw() { return hw; }
	    public String getRtos() { return rtos; }
	    public Class<? extends IOilTransform>  getTransformer() { return transformer; }
	}

}
