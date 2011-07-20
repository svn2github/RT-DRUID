/*
 * Created on 11-nov-2004
 *
 * $Id: OilReaderTest.java,v 1.6 2008/03/26 18:23:51 durin Exp $
 */
package com.eu.evidence.rtdruid.hidden.modules.oil.reader;



import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import junit.framework.TestCase;

import org.w3c.dom.Document;

import com.eu.evidence.rtdruid.desk.RTDFactory;
import com.eu.evidence.rtdruid.internal.modules.oil.implementation.OilImplFactory_Impl;
import com.eu.evidence.rtdruid.internal.modules.oil.reader.OilReader;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OilImplID;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.data.init.Vt2StringUtilities;
import com.eu.evidence.rtdruid.vartree.data.init.VtCompare;

/**
 * @author Nicola Serreli
 */
public class OilReaderTest extends TestCase {

    final static protected String OIL_TEST_1 =
        "OIL_VERSION = \"2.4\";"+
		"IMPLEMENTATION ee {" + 
    	"    OS {" + 
    	"        STRING ERIKA_OPT[];" + 
    	"        STRING APP_SRC0[];" + 
    	"        STRING APP_SRC1[];" + 
    	"        STRING THUMB_SRC0[];" + 
    	"        STRING THUMB_SRC1[];" + 
    	"        ENUM [STANDARD, EXTENDED] STATUS;" + 
    	"        BOOLEAN STARTUPHOOK;" + 
    	"        BOOLEAN ERRORHOOK;" + 
    	"        BOOLEAN SHUTDOWNHOOK;" + 
    	"        BOOLEAN PRETASKHOOK;" + 
    	"        BOOLEAN POSTTASKHOOK;" + 
    	"        BOOLEAN USEGETSERVICEID;" + 
    	"        BOOLEAN USEPARAMETERACCESS;" + 
    	"        BOOLEAN USERESSCHEDULER = TRUE;" + 
    	"        BOOLEAN [" + 
    	"                TRUE {" + 
    	"                        BOOLEAN [" + 
    	"                                TRUE {" + 
    	"                                        UINT32 SYS_SIZE;" + 
    	"                                        UINT32 IRQ_SIZE;" + 
    	"                                        }," + 
    	"                                FALSE" + 
    	"                        ] IRQ_STACK;" + 
    	"                        ENUM [" + 
    	"                            SHARED," + 
    	"                            PRIVATE {" + 
    	"                                UINT32 SYS_SIZE;" + 
    	"                                UINT32 IRQ_SIZE;" + 
    	"                            }" + 
    	"                        ] DUMMY_STACK;" + 
    	"                }," + 
    	"                FALSE" + 
    	"        ] MULTI_STACK;" + 
    	"        UINT32 STACK0_TOP;" + 
    	"        UINT32 STACK0_BOTTOM;" + 
    	"        UINT32 SYS0_SIZE;" + 
    	"        UINT32 IRQ0_SIZE;" + 
    	"        UINT32 SVC0_SIZE;" + 
    	"        UINT32 FIQ0_SIZE;" + 
    	"        UINT32 ABT0_SIZE;" + 
    	"        UINT32 UND0_SIZE;" + 
    	"        UINT32 WITH_AUTO STACK1_TOP = AUTO;" + 
    	"        UINT32 WITH_AUTO STACK1_BOTTOM = AUTO;" + 
    	"        UINT32 WITH_AUTO SYS1_SIZE = AUTO;" + 
    	"        UINT32 WITH_AUTO IRQ1_SIZE = AUTO;" + 
    	"        UINT32 WITH_AUTO SVC1_SIZE = AUTO;" + 
    	"        UINT32 WITH_AUTO FIQ1_SIZE = AUTO;" + 
    	"        UINT32 WITH_AUTO ABT1_SIZE = AUTO;" + 
    	"        UINT32 WITH_AUTO UND1_SIZE = AUTO;" + 
    	"        STRING HW_TYPE = \"Janus\";" + 
    	"        ENUM [" + 
    	"                FP {" + 
    	"					BOOLEAN NESTED_IRQ;" + 
    	"                }," + 
    	"                SRPT {" + 
    	"                        BOOLEAN NESTED_IRQ;" + 
    	"                }," + 
    	"                BCC1," + 
    	"                BCC2," + 
    	"                ECC1," + 
    	"                ECC2" + 
    	"        ] KERNEL_TYPE = BCC1;" + 
    	"    };" + 
    	"    TASK {" +
    	"        BOOLEAN AUTOSTART;" +
    	"        UINT32 PRIORITY;" + 
    	"        UINT32 ACTIVATION = 1;" + 
    	"        ENUM [NON, FULL] SCHEDULE;" + 
    	"        EVENT_TYPE EVENT[];" + 
    	"        UINT32 DISPATCH_PRIORITY;" + 
		"        ENUM [" + 
		"            SHARED," + 
		"            PRIVATE {" + 
		"                UINT32 SIZE;" + 
		"                UINT32 SYSTEM_SIZE;" + 
		"            }" + 
		"        ] STACK;" + 
		"        RESOURCE_TYPE RESOURCE[];" + 
		"        INT32 [0,1] CPU_NUMBER = 0;" + 
		"        TASK_TYPE LINKED[];" + 
		"    };" + 
		"    RESOURCE {" + 
		"                ENUM [" + 
		"                        STANDARD," + 
		"                        LINKED {" + 
		"                                RESOURCE_TYPE LINKEDRESOURCE;" + 
		"                        }," + 
		"                        INTERNAL" + 
		"                ] RESOURCEPROPERTY;" + 
		"    };" + 
		"    EVENT {" + 
		"        UINT32 WITH_AUTO MASK = AUTO;" + 
		"    };" + 
		"    COUNTER {" + 
		"        UINT32 MINCYCLE;" + 
		"        UINT32 MAXALLOWEDVALUE;" + 
		"        UINT32 TICKSPERBASE;" + 
		"    };" + 
		"    ALARM {" + 
		"        COUNTER_TYPE COUNTER;" + 
		"        ENUM [" + 
		"                ACTIVATETASK {" + 
		"                        TASK_TYPE TASK;" + 
		"                }," + 
		"                SETEVENT {" + 
		"                        TASK_TYPE TASK;" + 
		"                        EVENT_TYPE EVENT;" + 
		"                }," + 
		"                ALARMCALLBACK {" + 
		"                        STRING ALARTMCALLBACKNAME;" + 
		"                }" + 
		"        ] ACTION;" + 
		"    };\n" + 
		"};\n" + 
		"CPU prova_Janus {\n" + 
		"    OS erika_Janus {" + 
		"        ERIKA_OPT = \"__ASSERT__\";" + 
		"        ERIKA_OPT = \"__OSEKOS_NO_ALARMS__\";" + 
		"        ERIKA_OPT = \"DEBUG\";" + 
		"        APP_SRC0 = \"code.c\";" + 
		"        STATUS = EXTENDED;" + 
		"        STARTUPHOOK = TRUE;" + 
		"        ERRORHOOK = FALSE;" + 
		"        SHUTDOWNHOOK = FALSE;" + 
		"        PRETASKHOOK = FALSE;" + 
		"        POSTTASKHOOK = FALSE;" + 
		"        USEGETSERVICEID = FALSE;" + 
		"        USEPARAMETERACCESS = FALSE;" + 
		"        USERESSCHEDULER = TRUE;" + 
		"        MULTI_STACK = TRUE {" + 
		"            IRQ_STACK = FALSE;" + 
		"            DUMMY_STACK = SHARED;" + 
		"        };" + 
		"        STACK0_TOP = 0x20004000;" + 
		"        STACK0_BOTTOM = 0x20001800;" + 
		"        STACK1_TOP = 0x20014000;" + 
		"        STACK1_BOTTOM = 0x20011800;" + 
		"        SYS0_SIZE = 0x1000;" + 
		"        IRQ0_SIZE = 0x1000;" + 
		"        SVC0_SIZE = 0x200;" + 
		"        FIQ0_SIZE = 0x200;" + 
		"        ABT0_SIZE = 0x200;" + 
		"        UND0_SIZE = 0x200;" + 
		"        HW_TYPE = \"Janus\";" + 
		"        KERNEL_TYPE = BCC1;" + 
		"    };" + 
		"    TASK Task1 {" + 
		"        PRIORITY = 0x01;" + 
		"        ACTIVATION = 1;" + 
		"        SCHEDULE = FULL;" + 
		"        DISPATCH_PRIORITY = 0x01;" + 
		"        AUTOSTART = TRUE;" + 
		"        STACK = SHARED;" + 
		"        EVENT = evento1;" + 
		"    };" + 
		"    TASK Task2 {" + 
		"        PRIORITY = 0x02;" + 
		"        ACTIVATION = 1;" + 
		"        SCHEDULE = FULL;" + 
		"        DISPATCH_PRIORITY = 0x02;" + 
		"        AUTOSTART = TRUE;" + 
		"        STACK = SHARED;" + 
		"        CPU_NUMBER = 1;" + 
		"    };" + 
		"	 EVENT evento1 {};" + 
		"};";
    
    final static protected String OIL_TEST_1_IMPL_ONLY =
        "OIL_VERSION = \"2.4\";"+
		"IMPLEMENTATION ee {" + 
    	"    OS {" + 
    	"        STRING ERIKA_OPT[];" + 
    	"        STRING APP_SRC0[];" + 
    	"        STRING APP_SRC1[];" + 
    	"        STRING THUMB_SRC0[];" + 
    	"        STRING THUMB_SRC1[];" + 
    	"        ENUM [STANDARD, EXTENDED] STATUS;" + 
    	"        BOOLEAN STARTUPHOOK;" + 
    	"        BOOLEAN ERRORHOOK;" + 
    	"        BOOLEAN SHUTDOWNHOOK;" + 
    	"        BOOLEAN PRETASKHOOK;" + 
    	"        BOOLEAN POSTTASKHOOK;" + 
    	"        BOOLEAN USEGETSERVICEID;" + 
    	"        BOOLEAN USEPARAMETERACCESS;" + 
    	"        BOOLEAN USERESSCHEDULER = TRUE;" + 
    	"        BOOLEAN [" + 
    	"                TRUE {" + 
    	"                        BOOLEAN [" + 
    	"                                TRUE {" + 
    	"                                        UINT32 SYS_SIZE;" + 
    	"                                        UINT32 IRQ_SIZE;" + 
    	"                                        }," + 
    	"                                FALSE" + 
    	"                        ] IRQ_STACK;" + 
    	"                        ENUM [" + 
    	"                            SHARED," + 
    	"                            PRIVATE {" + 
    	"                                UINT32 SYS_SIZE;" + 
    	"                                UINT32 IRQ_SIZE;" + 
    	"                            }" + 
    	"                        ] DUMMY_STACK;" + 
    	"                }," + 
    	"                FALSE" + 
    	"        ] MULTI_STACK;" + 
    	"        UINT32 STACK0_TOP;" + 
    	"        UINT32 STACK0_BOTTOM;" + 
    	"        UINT32 SYS0_SIZE;" + 
    	"        UINT32 IRQ0_SIZE;" + 
    	"        UINT32 SVC0_SIZE;" + 
    	"        UINT32 FIQ0_SIZE;" + 
    	"        UINT32 ABT0_SIZE;" + 
    	"        UINT32 UND0_SIZE;" + 
    	"        UINT32 WITH_AUTO STACK1_TOP = AUTO;" + 
    	"        UINT32 WITH_AUTO STACK1_BOTTOM = AUTO;" + 
    	"        UINT32 WITH_AUTO SYS1_SIZE = AUTO;" + 
    	"        UINT32 WITH_AUTO IRQ1_SIZE = AUTO;" + 
    	"        UINT32 WITH_AUTO SVC1_SIZE = AUTO;" + 
    	"        UINT32 WITH_AUTO FIQ1_SIZE = AUTO;" + 
    	"        UINT32 WITH_AUTO ABT1_SIZE = AUTO;" + 
    	"        UINT32 WITH_AUTO UND1_SIZE = AUTO;" + 
    	"        STRING HW_TYPE = \"Janus\";" + 
    	"        ENUM [" + 
    	"                FP {" + 
    	"					BOOLEAN NESTED_IRQ;" + 
    	"                }," + 
    	"                SRPT {" + 
    	"                        BOOLEAN NESTED_IRQ;" + 
    	"                }," + 
    	"                BCC1," + 
    	"                BCC2," + 
    	"                ECC1," + 
    	"                ECC2" + 
    	"        ] KERNEL_TYPE = BCC1;" + 
    	"    };" + 
    	"    TASK {" + 
    	"        UINT32 PRIORITY;" + 
    	"        BOOLEAN AUTOSTART;" +
    	"        UINT32 ACTIVATION = 1;" + 
    	"        ENUM [NON, FULL] SCHEDULE;" + 
    	"        EVENT_TYPE EVENT[];" + 
    	"        UINT32 DISPATCH_PRIORITY;" + 
		"        ENUM [" + 
		"            SHARED," + 
		"            PRIVATE {" + 
		"                UINT32 SIZE;" + 
		"                UINT32 SYSTEM_SIZE;" + 
		"            }" + 
		"        ] STACK;" + 
		"        RESOURCE_TYPE RESOURCE[];" + 
		"        INT32 [0,1] CPU_NUMBER = 0;" + 
		"        TASK_TYPE LINKED[];" + 
		"    };" + 
		"    RESOURCE {" + 
		"                ENUM [" + 
		"                        STANDARD," + 
		"                        LINKED {" + 
		"                                RESOURCE_TYPE LINKEDRESOURCE;" + 
		"                        }," + 
		"                        INTERNAL" + 
		"                ] RESOURCEPROPERTY;" + 
		"    };" + 
		"    EVENT {" + 
		"        UINT32 WITH_AUTO MASK = AUTO;" + 
		"    };" + 
		"    COUNTER {" + 
		"        UINT32 MINCYCLE;" + 
		"        UINT32 MAXALLOWEDVALUE;" + 
		"        UINT32 TICKSPERBASE;" + 
		"    };" + 
		"    ALARM {" + 
		"        COUNTER_TYPE COUNTER;" + 
		"        ENUM [" + 
		"                ACTIVATETASK {" + 
		"                        TASK_TYPE TASK;" + 
		"                }," + 
		"                SETEVENT {" + 
		"                        TASK_TYPE TASK;" + 
		"                        EVENT_TYPE EVENT;" + 
		"                }," + 
		"                ALARMCALLBACK {" + 
		"                        STRING ALARTMCALLBACKNAME;" + 
		"                }" + 
		"        ] ACTION;" + 
		"    };\n" + 
		"};\n" + 
		"CPU prova_Janus {\n" + 
		"};";
    final static protected String OIL_TEST_1_IMPL_ONLY_OS =
        "OIL_VERSION = \"2.4\";"+
		"IMPLEMENTATION ee {" + 
    	"    OS {" + 
    	"        STRING ERIKA_OPT[];" + 
    	"        STRING APP_SRC0[];" + 
    	"        STRING APP_SRC1[];" + 
    	"        STRING THUMB_SRC0[];" + 
    	"        STRING THUMB_SRC1[];" + 
    	"        ENUM [STANDARD, EXTENDED] STATUS;" + 
    	"        BOOLEAN STARTUPHOOK;" + 
    	"        BOOLEAN ERRORHOOK;" + 
    	"        BOOLEAN SHUTDOWNHOOK;" + 
    	"        BOOLEAN PRETASKHOOK;" + 
    	"        BOOLEAN POSTTASKHOOK;" + 
    	"        BOOLEAN USEGETSERVICEID;" + 
    	"        BOOLEAN USEPARAMETERACCESS;" + 
    	"        BOOLEAN USERESSCHEDULER = TRUE;" + 
    	"        BOOLEAN [" + 
    	"                TRUE {" + 
    	"                        BOOLEAN [" + 
    	"                                TRUE {" + 
    	"                                        UINT32 SYS_SIZE;" + 
    	"                                        UINT32 IRQ_SIZE;" + 
    	"                                        }," + 
    	"                                FALSE" + 
    	"                        ] IRQ_STACK;" + 
    	"                        ENUM [" + 
    	"                            SHARED," + 
    	"                            PRIVATE {" + 
    	"                                UINT32 SYS_SIZE;" + 
    	"                                UINT32 IRQ_SIZE;" + 
    	"                            }" + 
    	"                        ] DUMMY_STACK;" + 
    	"                }," + 
    	"                FALSE" + 
    	"        ] MULTI_STACK;" + 
    	"        UINT32 STACK0_TOP;" + 
    	"        UINT32 STACK0_BOTTOM;" + 
    	"        UINT32 SYS0_SIZE;" + 
    	"        UINT32 IRQ0_SIZE;" + 
    	"        UINT32 SVC0_SIZE;" + 
    	"        UINT32 FIQ0_SIZE;" + 
    	"        UINT32 ABT0_SIZE;" + 
    	"        UINT32 UND0_SIZE;" + 
    	"        UINT32 WITH_AUTO STACK1_TOP = AUTO;" + 
    	"        UINT32 WITH_AUTO STACK1_BOTTOM = AUTO;" + 
    	"        UINT32 WITH_AUTO SYS1_SIZE = AUTO;" + 
    	"        UINT32 WITH_AUTO IRQ1_SIZE = AUTO;" + 
    	"        UINT32 WITH_AUTO SVC1_SIZE = AUTO;" + 
    	"        UINT32 WITH_AUTO FIQ1_SIZE = AUTO;" + 
    	"        UINT32 WITH_AUTO ABT1_SIZE = AUTO;" + 
    	"        UINT32 WITH_AUTO UND1_SIZE = AUTO;" + 
    	"        STRING HW_TYPE = \"Janus\";" + 
    	"        ENUM [" + 
    	"                FP {" + 
    	"					BOOLEAN NESTED_IRQ;" + 
    	"                }," + 
    	"                SRPT {" + 
    	"                        BOOLEAN NESTED_IRQ;" + 
    	"                }," + 
    	"                BCC1," + 
    	"                BCC2," + 
    	"                ECC1," + 
    	"                ECC2" + 
    	"        ] KERNEL_TYPE = BCC1;" + 
    	"    };" + 
		"};" +
		"CPU prova_Janus {\n" + 
		"};";
    final static protected String OIL_TEST_1_IMPL_ONLY_ALARM =
        "OIL_VERSION = \"2.4\";"+
		"IMPLEMENTATION ee {" + 
		"    ALARM {" + 
		"        COUNTER_TYPE COUNTER;" + 
		"        ENUM [" + 
		"                ACTIVATETASK {" + 
		"                        TASK_TYPE TASK;" + 
		"                }," + 
		"                SETEVENT {" + 
		"                        TASK_TYPE TASK;" + 
		"                        EVENT_TYPE EVENT;" + 
		"                }," + 
		"                ALARMCALLBACK {" + 
		"                        STRING ALARTMCALLBACKNAME;" + 
		"                }" + 
		"        ] ACTION;" + 
		"    };\n" + 
		"};\n" + 
		"CPU prova_Janus {\n" + 
		"};";
    final static protected String OIL_TEST_1_SPLITTED_IMPL_ONLY_ALARM =
        "OIL_VERSION = \"2.4\";"+
		"IMPLEMENTATION ee {" + 
		"    ALARM {" + 
		"        COUNTER_TYPE COUNTER;" + 
		"    };\n" + 
		"    ALARM {" + 
		"        ENUM [" + 
		"                ACTIVATETASK {" + 
		"                        TASK_TYPE TASK;" + 
		"                }," + 
		"                ALARMCALLBACK" + 
		"        ] ACTION;" +
		"    };\n" + 
		"    ALARM {" + 
		"        ENUM [" + 
		"                SETEVENT {" + 
		"                        EVENT_TYPE EVENT;" + 
		"                }" + 
		"        ] ACTION;" +
		"    };\n" + 
		"    ALARM {" + 
		"        ENUM [" + 
		"                SETEVENT {" + 
		"                        TASK_TYPE TASK;" + 
		"                }," + 
		"                ALARMCALLBACK {" + 
		"                        STRING ALARTMCALLBACKNAME;" + 
		"                }" + 
		"        ] ACTION;" +
		"    };\n" + 
		"};\n" + 
		"CPU prova_Janus {\n" + 
		"};";
    
    
    
    /** Clear the OilImplFactory after each test */
    protected void setUp() throws Exception {
 //       OilImplFactory.getAnInstance(vt).clear();
        super.setUp();
    }
    /** Clear the OilImplFactory after each test */
    protected void tearDown() throws Exception {
  //      OilImplFactory.getAnInstance(vt).clear();
        super.tearDown();
    }

    
    /** Try to load a splitted Oil Implementation Section */
    public void testLoad_test_1_splitted() {
    	IVarTree vt = (IVarTree) RTDFactory.get(IVarTree.class);
        OilImplID[] oids = OilImplFactory_Impl.getAnInstance(vt).getImplNames();
        assertTrue(oids != null);
        assertTrue(oids.length == 0);
        
        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1_IMPL_ONLY_ALARM.getBytes()), vt);
        vt.clear();
        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1_SPLITTED_IMPL_ONLY_ALARM.getBytes()), vt);
        oids = OilImplFactory_Impl.getAnInstance(vt).getImplNames();
        assertTrue(oids != null);
        assertTrue(oids.length == 1);
    }

    public void testLoad_test_1_vt() {
    	IVarTree vt = (IVarTree) RTDFactory.get(IVarTree.class);
        OilImplID[] oids = OilImplFactory_Impl.getAnInstance(vt).getImplNames();
        assertTrue(oids != null);
        assertTrue(oids.length == 0);
        
        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1.getBytes()), vt);
        String vt_rappr = Vt2StringUtilities.varTreeToString(vt);
        System.out.println(vt_rappr);
        IVarTree vt2 =Vt2StringUtilities.loadString(vt_rappr);
		String t = (new VtCompare(vt, vt2)).getText(); assertTrue(t, t== null);
        
        String vt_ertd = Vt2StringUtilities.varTreeToStringErtd(vt);
        System.out.println("\n\n\n" + vt_ertd);
        IVarTree vt3 =Vt2StringUtilities.loadString(vt_rappr);
		t = (new VtCompare(vt, vt3)).getText(); assertTrue(t, t== null);

    }
    
    public void testLoad_test_1() {
    	IVarTree vt = (IVarTree) RTDFactory.get(IVarTree.class);
        OilImplID[] oids = OilImplFactory_Impl.getAnInstance(vt).getImplNames();
        assertTrue(oids != null);
        assertTrue(oids.length == 0);
        
        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1.getBytes()), vt);
        vt.clear();
        
        oids = OilImplFactory_Impl.getAnInstance(vt).getImplNames();
        assertTrue(oids != null);
        assertTrue(oids.length == 1);
        
        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1.getBytes()), vt);
        vt.clear();
        
        oids = OilImplFactory_Impl.getAnInstance(vt).getImplNames();
        assertTrue(oids != null);
        assertTrue(oids.length == 1);
        
        OilImplFactory_Impl.getAnInstance(vt).clear();
        oids = OilImplFactory_Impl.getAnInstance(vt).getImplNames();
        assertTrue(oids != null);
        assertTrue(oids.length == 0);

        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1.getBytes()), vt);
        vt.clear();
        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1_IMPL_ONLY.getBytes()), vt);
        vt.clear();
        oids = OilImplFactory_Impl.getAnInstance(vt).getImplNames();
        assertTrue(oids != null);
        assertTrue(oids.length == 1);
        
        boolean ok = false;
        try {
            (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1_IMPL_ONLY_OS.getBytes()), vt);
            vt.clear();
        } catch(RuntimeException e){
            ok = true;
        }
        assertTrue(ok);
        
        ok = false;
        try {
	        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1_IMPL_ONLY_ALARM.getBytes()), vt);
	        vt.clear();
	    } catch(RuntimeException e){
	        ok = true;
	    }
	    assertTrue(ok);

        assertTrue(OilImplFactory_Impl.getAnInstance(vt).getImplNames().length == 1);
        
        OilImplFactory_Impl.getAnInstance(vt).clear();

        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1_IMPL_ONLY_OS.getBytes()), vt);
        vt.clear();
        ok = false;
        try {
            (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1_IMPL_ONLY_ALARM.getBytes()), vt);
            vt.clear();
	    } catch(RuntimeException e){
	        ok = true;
	    }
	    assertTrue(ok);
        assertTrue(OilImplFactory_Impl.getAnInstance(vt).getImplNames().length == 1);
    }
    
    final static protected String OIL_TEST_2 =
		"    OIL_VERSION = \"2.4\";" +
		"    IMPLEMENTATION something {" +
		"        OS {" +
		"            STRING ERIKA_OPT[];" +
		"            STRING APP_SRC[];" +
		"            STRING THUMB_SRC[];" +
		"            ENUM [STANDARD, EXTENDED] STATUS;" +
		"            BOOLEAN STARTUPHOOK;" +
		"            BOOLEAN ERRORHOOK;" +
		"            BOOLEAN SHUTDOWNHOOK;" +
		"            BOOLEAN PRETASKHOOK;" +
		"            BOOLEAN POSTTASKHOOK;" +
		"            BOOLEAN USEGETSERVICEID;" +
		"            BOOLEAN USEPARAMETERACCESS;" +
		"            BOOLEAN USERESSCHEDULER = TRUE;" +
		"            BOOLEAN [" +
		"                    TRUE {" +
		"                            BOOLEAN [" +
		"                                    TRUE {" +
		"                                            UINT32 SYS_SIZE;" +
		"                                            UINT32 IRQ_SIZE;" +
		"                                            }," +
		"                                    FALSE" +
		"                            ] IRQ_STACK;" +
		"                            ENUM [" +
		"                                SHARED," +
		"                                PRIVATE {" +
		"                                    UINT32 SYS_SIZE;" +
		"                                    UINT32 IRQ_SIZE;" +
		"                                }" +
		"                            ] DUMMY_STACK;" +
		"                    }," +
		"                    FALSE" +
		"            ] MULTI_STACK;" +
		"            UINT32 STACK_TOP;" +
		"            UINT32 STACK_BOTTOM;" +
		"            UINT32 SYS_SIZE;" +
		"            UINT32 IRQ_SIZE;" +
		"            UINT32 SVC_SIZE;" +
		"            UINT32 FIQ_SIZE;" +
		"            UINT32 ABT_SIZE;" +
		"            UINT32 UND_SIZE;" +
		"            STRING HW_TYPE = \"ARM7\";" +
		"            ENUM [" +
		"                    FP {" +
		"                            BOOLEAN NESTED_IRQ;" +
		"                    }," +
		"                    SRPT {" +
		"                            BOOLEAN NESTED_IRQ;" +
		"                    }," +
		"                    BCC1," +
		"                    BCC2," +
		"                    ECC1," +
		"                    ECC2" +
		"            ] KERNEL_TYPE = BCC1;" +
		"" +
		"    	ENUM [ALL, OS_SECTION, TASK_SECTION, RESOURCE_SECTION, STACK_SECTION, ALARM_SECTION] ORTI_SECTIONS[];" +
		"        };" +
		"        TASK {" +
		"            UINT32 PRIORITY;" +
		"            UINT32 ACTIVATION = 1;" +
		"            ENUM [NON, FULL] SCHEDULE;" +
		"    	EVENT_TYPE EVENT[];" +
		"            UINT32 DISPATCH_PRIORITY;" +
		"            ENUM [" +
		"                SHARED," +
		"                PRIVATE {" +
		"                    UINT32 SIZE;" +
		"                    UINT32 SYSTEM_SIZE;" +
		"                }" +
		"            ] STACK;" +
		"            RESOURCE_TYPE RESOURCE[];" +
		"            BOOLEAN [" +
		"                TRUE" +
		"                {" +
		"                    APPMODE_TYPE APPMODE[];" +
		"                }," +
		"                FALSE" +
		"            ] AUTOSTART;" +
		"        };" +
		"        RESOURCE {" +
		"                    ENUM [" +
		"                            STANDARD," +
		"                            LINKED {" +
		"                                    RESOURCE_TYPE LINKEDRESOURCE;" +
		"                            }," +
		"                            INTERNAL" +
		"                    ] RESOURCEPROPERTY;" +
		"        };" +
		"        EVENT {" +
		"            UINT32 WITH_AUTO MASK = AUTO;" +
		"        };" +
		"        COUNTER {" +
		"            UINT32 MINCYCLE;" +
		"            UINT32 MAXALLOWEDVALUE;" +
		"            UINT32 TICKSPERBASE;" +
		"        };" +
		"        APPMODE {};" +
		"        ALARM {" +
		"            COUNTER_TYPE COUNTER;" +
		"            ENUM [" +
		"                    ACTIVATETASK {" +
		"                            TASK_TYPE TASK;" +
		"                    }," +
		"                    SETEVENT {" +
		"                            TASK_TYPE TASK;" +
		"                            EVENT_TYPE EVENT;" +
		"                    }," +
		"                    ALARMCALLBACK {" +
		"                            STRING ALARTMCALLBACKNAME;" +
		"                    }" +
		"            ] ACTION;" +
		"        };" +
		"    };" +
		"    CPU prova_Janus {" +
		"        OS erika_Janus {" +
		"            ERIKA_OPT = \"__ASSERT__\";" +
		"            ERIKA_OPT = \"__OSEKOS_NO_ALARMS__\";" +
		"            ERIKA_OPT = \"DEBUG\";" +
		"            APP_SRC = \"code.c\";" +
		"            STATUS = EXTENDED;" +
		"            STARTUPHOOK = TRUE;" +
		"            ERRORHOOK = FALSE;" +
		"            SHUTDOWNHOOK = FALSE;" +
		"            PRETASKHOOK = FALSE;" +
		"            POSTTASKHOOK = FALSE;" +
		"            USEGETSERVICEID = FALSE;" +
		"            USEPARAMETERACCESS = FALSE;" +
		"            USERESSCHEDULER = TRUE;" +
		"                    MULTI_STACK = TRUE {" +
		"    		IRQ_STACK = FALSE;" +
		"    		DUMMY_STACK = SHARED;" +
		"    	};" +
		"    	STACK_TOP = 0x20004000;" +
		"            STACK_BOTTOM = 0x20001800;" +
		"            SYS_SIZE = 0x1000;" +
		"            IRQ_SIZE = 0x1000;" +
		"            SVC_SIZE = 0x200;" +
		"            FIQ_SIZE = 0x200;" +
		"            ABT_SIZE = 0x200;" +
		"            UND_SIZE = 0x200;" +
		"            KERNEL_TYPE = ECC1;" +
		"    	ORTI_SECTIONS = OS_SECTION;" +
		"    	ORTI_SECTIONS = TASK_SECTION;" +
		"        };" +
		"        APPMODE modo_1 {};" +
		"        APPMODE modo_2 {};" +
		"        TASK Task1 {" +
		"                    PRIORITY = 0x01;" +
		"                    ACTIVATION = 1;" +
		"                    SCHEDULE = FULL;" +
		"                    DISPATCH_PRIORITY = 0x01;" +
		"                    AUTOSTART = TRUE;" +
		"                    STACK = SHARED;" +
		"    		EVENT = evento1;" +
		"        };" +
		"        TASK Task2 {" +
		"                    PRIORITY = 0x02;" +
		"                    ACTIVATION = 1;" +
		"                    SCHEDULE = FULL;" +
		"                    DISPATCH_PRIORITY = 0x02;" +
		"                    AUTOSTART = TRUE { APPMODE = modo_2;};" +
		"                    STACK = SHARED;" +
		"        };" +
		"        EVENT evento1 {};" +
		"" +
		"        RESOURCE prima {" +
		"    	RESOURCEPROPERTY = STANDARD;	" +
		"        };" +
		"    };";
    
    public void testLoad_test_1_and_2() {
    	IVarTree vt = (IVarTree) RTDFactory.get(IVarTree.class);
        OilImplID[] oids = OilImplFactory_Impl.getAnInstance(vt).getImplNames();
        assertTrue(oids != null);
        assertTrue(oids.length == 0);
        
        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1.getBytes()), vt);
        vt.clear();
        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_2.getBytes()), vt);
        vt.clear();
        
        oids = OilImplFactory_Impl.getAnInstance(vt).getImplNames();
        assertTrue(oids != null);
        assertTrue(oids.length == 2);
        
        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1.getBytes()), vt);
        vt.clear();
        
        oids = OilImplFactory_Impl.getAnInstance(vt).getImplNames();
        assertTrue(oids != null);
        assertTrue(oids.length == 2);
        
        OilImplFactory_Impl.getAnInstance(vt).clear();
        oids = OilImplFactory_Impl.getAnInstance(vt).getImplNames();
        assertTrue(oids != null);
        assertTrue(oids.length == 0);

        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_2.getBytes()), vt);
        vt.clear();
        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1.getBytes()), vt);
        vt.clear();
        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1_IMPL_ONLY.getBytes()), vt);
        vt.clear();
        oids = OilImplFactory_Impl.getAnInstance(vt).getImplNames();
        assertTrue(oids != null);
        assertTrue(oids.length == 2);
        
        boolean ok = false;
        try {
            (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1_IMPL_ONLY_OS.getBytes()), vt);
            vt.clear();
        } catch(RuntimeException e){
            ok = true;
        }
        assertTrue(ok);
        
        ok = false;
        try {
	        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1_IMPL_ONLY_ALARM.getBytes()), vt);
	        vt.clear();
	    } catch(RuntimeException e){
	        ok = true;
	    }
	    assertTrue(ok);

        assertTrue(OilImplFactory_Impl.getAnInstance(vt).getImplNames().length == 2);
        
        OilImplFactory_Impl.getAnInstance(vt).clear();

        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_2.getBytes()), vt);
        vt.clear();
        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1_IMPL_ONLY_OS.getBytes()), vt);
        vt.clear();
        ok = false;
        try {
            (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1_IMPL_ONLY_ALARM.getBytes()), vt);
            vt.clear();
	    } catch(RuntimeException e){
	        ok = true;
	    }
	    assertTrue(ok);
        assertTrue(OilImplFactory_Impl.getAnInstance(vt).getImplNames().length == 2);
    }

    final static protected String OIL_TEST_SENZA_IMPL =
		"    CPU prova_Janus {" +
		"        OS erika_Janus {" +
		 "        EE_OPT = \"__ASSERT__\";\n"
		+ "        EE_OPT = \"__OSEKOS_NO_ALARMS__\";\n"
		+ "        EE_OPT = \"DEBUG\";\n"

		+ "        CFLAGS = \"-DALT_DEBUG -G0 -O0 -g\";\n"
		+ "        CFLAGS = \"-Wall -Wl,-Map -Wl,project.map\";\n"
		+ "        ASFLAGS = \"-g\";\n"
		+ "        LDDEPS = \"\\\";\n"
		+ "        LIBS = \"-lm\";\n"
		+ "        NIOS2_SYS_CONFIG = \"DEBUG\";\n"
		+ "        NIOS2_APP_CONFIG = \"DEBUG\";\n"
		+ "        NIOS2_DO_MAKE_OBJDUMP = FALSE;\n"+
		
		"		CPU_DATA = NIOSII {\n" +
		"			ID = \"cpu1\";\n" +
		"			MULTI_STACK = TRUE {\n" +
		"				IRQ_STACK = FALSE;\n" +
		"				DUMMY_STACK = SHARED;\n" +
		"			};\n" +
		"			\n" +
		"			APP_SRC = \"code_1.c\";\n" +
		"	\n" 
		+ "        STACK_TOP = 0x20004000;\n"
		//+ "        STACK_BOTTOM = 0x20001800;\n"
		+ "        SYS_SIZE = 0x1000;\n" 
		+ "        SYSTEM_LIBRARY_NAME = \"library_name\";\n"
		+ "        SYSTEM_LIBRARY_PATH = \"path/library_name\";\n" +

		"	\n" +
		"		};\n"+ 
		
		"		CPU_DATA = NIOSII {\n" +
		"			ID = \"cpu2\";\n" +
		"			MULTI_STACK = TRUE {\n" +
		"				IRQ_STACK = FALSE;\n" +
		"				DUMMY_STACK = SHARED;\n" +
		"			};\n" +
		"			\n" +
		"			APP_SRC = \"code_2.c\";\n" +
		"	\n" 
		+ "        STACK_TOP = 0x20008000;\n"
//		+ "        STACK_BOTTOM = 0x20004000;\n"
		+ "        SYS_SIZE = 0x1000;\n"
		+ "        SYSTEM_LIBRARY_NAME = \"library_name\";\n"
		+ "        SYSTEM_LIBRARY_PATH = \"path/library_name\";\n" +
		"	\n" +
		"		};\n"+ 
		
		  "        STATUS = EXTENDED;\n"
		+ "        STARTUPHOOK = TRUE;\n"
		+ "        ERRORHOOK = FALSE;\n"
		+ "        SHUTDOWNHOOK = FALSE;\n"
		+ "        PRETASKHOOK = FALSE;\n"
		+ "        POSTTASKHOOK = FALSE;\n"
		+ "        USEGETSERVICEID = FALSE;\n"
		+ "        USEPARAMETERACCESS = FALSE;\n"
		+ "        USERESSCHEDULER = TRUE;\n"
		+ "        KERNEL_TYPE = BCC1;\n"
		+ "    };\n"
		+ "    TASK Task1 {\n"
		+ "        CPU_ID = \"cpu1\";"
		+ "        PRIORITY = 0x01;\n"
		+ "        ACTIVATION = 4;\n"
		+ "        SCHEDULE = FULL;\n"
		+ "        AUTOSTART = TRUE;\n"
		+ "        STACK = PRIVATE {\n"
		+ "            SYS_SIZE = 0x100;\n"
		+ "        };\n"
		+ "        EVENT = evento1;\n"
		+ "    };\n"
		+ "    TASK Task2 {\n"
		+ "        CPU_ID = \"cpu1\";"
		+ "        PRIORITY = 0x02;\n"
		+ "        ACTIVATION = 1;\n"
		+ "        SCHEDULE = FULL;\n"
		+ "        AUTOSTART = TRUE;\n"
		+ "        STACK = SHARED;\n"
		+ "    };\n"
		+ "    TASK Task3 {\n"
		+ "        CPU_ID = \"cpu2\";"
		+ "        PRIORITY = 0x04;\n"
		+ "        ACTIVATION = 1;\n"
		+ "        SCHEDULE = FULL;\n"
		+ "        AUTOSTART = TRUE;\n"
		+ "        STACK = SHARED;\n"
		+ "    };\n"
		+ "	 EVENT evento1 {};\n"
		+ "};\n";
    public void testLoad_test_SenzaImplementation() {
        OilImplID[] oids = OilImplFactory_Impl.getAnInstance((IVarTree) RTDFactory.get(IVarTree.class)).getImplNames();
        assertTrue(oids != null);
        assertTrue(oids.length == 0);
        
        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_SENZA_IMPL.getBytes()), (IVarTree) RTDFactory.get(IVarTree.class));
    }
    
    final static protected String OIL_TEST_WRONG_ENUM =
		"    CPU prova_Janus {" +
		"        OS erika_Janus {" +
		 "        EE_OPT = \"__ASSERT__\";\n"
		+ "        EE_OPT = \"__OSEKOS_NO_ALARMS__\";\n"
		+ "        EE_OPT = \"DEBUG\";\n"
		+ "        NIOS2_DO_MAKE_OBJDUMP = FALSE;\n"+
		"		CPU_DATA = NIOSII {\n" +
		"			ID = \"cpu2\";\n" +
		"	\n" +
		"		};\n" 
		+ "    };\n"
		+ "ALARM AllIncluded {\n"
		+ "    COUNTER = cc1;\n"
		+ "    ACTION = ACTIVATETASK {\n"
		+ "        TASK = Task2;\n"
		+ "    };\n"
		+ "    ACTION = SETEVENT {\n"
		+ "        TASK = Task1;\n"
		+ "       EVENT = vv;\n"
		+ "   };\n"
		+ "    ACTION = ALARMCALLBACK {\n"
		+ "        ALARMCALLBACKNAME = \"WakeTaskB\";\n"
		+ "    };\n"
		+ "    AUTOSTART = TRUE {\n"
		+ "        ALARMTIME = 50;\n"
		+ "        CYCLETIME = 100;\n"
		+ "    };\n"
		+ "};\n"
		+ "};\n";
    public void testLoad_test_enumWrong() {
        OilImplID[] oids = OilImplFactory_Impl.getAnInstance((IVarTree) RTDFactory.get(IVarTree.class)).getImplNames();
        assertTrue(oids != null);
        assertTrue(oids.length == 0);
        
        IVarTree vt = (IVarTree) RTDFactory.get(IVarTree.class);
        boolean ok = false;
        try {
        	(new OilReader()).load(new ByteArrayInputStream(OIL_TEST_WRONG_ENUM.getBytes()), vt);
        } catch (RuntimeException e) {
        	ok = true;
        }
        assertTrue(ok);
        
        System.out.println(Vt2StringUtilities.varTreeToString(vt));
    }
    
    
    public void testLoad_xml() {
    	System.out.println("INIZIO");
    	System.err.println("INIZIO");
           Document xml = (new OilReader()).loadAsXml(new ByteArrayInputStream(OIL_TEST_SENZA_IMPL.getBytes()), null, null);
        System.out.println(xmlToText(xml));
    }
    
    public static String xmlToText(Document doc) {
    	ByteArrayOutputStream output = new ByteArrayOutputStream();
		try {
			Transformer transformer = TransformerFactory.newInstance()
					.newTransformer();

			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			// Transform the source XML
			transformer.transform(new DOMSource(doc), new StreamResult(output));

		} catch (TransformerConfigurationException tce) {
			// Error generated by the parser
			System.out.println("* Transformer Factory error");
			System.out.println("  " + tce.getMessage());

			// Use the contained exception, if any
			Throwable x = tce;
			if (tce.getException() != null)
				x = tce.getException();
			x.printStackTrace();

		} catch (TransformerException te) {
			// Error generated by the parser
			System.out.println("* Transformation error");
			System.out.println("  " + te.getMessage());

			// Use the contained exception, if any
			Throwable x = te;
			if (te.getException() != null)
				x = te.getException();
			x.printStackTrace();

		}

		return output.toString();
    }
    
    
}

