/*
 * Created on 11-nov-2004
 *
 * $Id: OilReaderTest.java,v 1.6 2008/03/26 18:23:51 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.oil.implementation;



import java.io.ByteArrayInputStream;

import junit.framework.TestCase;

import com.eu.evidence.rtdruid.desk.RTDFactory;
import com.eu.evidence.rtdruid.internal.modules.oil.reader.OilReader;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OilImplFactory;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OilImplID;
import com.eu.evidence.rtdruid.modules.oil.interfaces.IOilImplementation;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.data.init.Vt2StringUtilities;

/**
 * @author Nicola Serreli
 */
public class OilImplementationMergeTest extends TestCase {
    
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
    
    
    
    /** Try to load a splitted Oil Implementation Section */
    public void testLoad_test_1_splitted() {
    	IVarTree vt = (IVarTree) RTDFactory.get(IVarTree.class);
        OilImplID[] oids = OilImplFactory_Impl.getAnInstance(vt).getImplNames();
        assertTrue(oids != null);
        assertTrue(oids.length == 0);
        
        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1_IMPL_ONLY_ALARM.getBytes()), vt);
        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1_SPLITTED_IMPL_ONLY_ALARM.getBytes()), vt);
        oids = OilImplFactory_Impl.getAnInstance(vt).getImplNames();
        assertTrue(oids != null);
        assertTrue(oids.length == 1);
    }

    public void testLoad_test_1() {
    	IVarTree vt = (IVarTree) RTDFactory.get(IVarTree.class);
        OilImplID[] oids = OilImplFactory_Impl.getAnInstance(vt).getImplNames();
        assertTrue(oids != null);
        assertTrue(oids.length == 0);
        
        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1_IMPL_ONLY.getBytes()), vt);
        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1_IMPL_ONLY.getBytes()), vt);
        oids = OilImplFactory_Impl.getAnInstance(vt).getImplNames();
        assertTrue(oids != null);
        assertTrue(oids.length == 1);
        
        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1_IMPL_ONLY_OS.getBytes()), vt);
        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1_IMPL_ONLY_ALARM.getBytes()), vt);

        assertTrue(OilImplFactory_Impl.getAnInstance(vt).getImplNames().length == 1);
        
        OilImplFactory_Impl.getAnInstance(vt).clear();

        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1_IMPL_ONLY_OS.getBytes()), vt);
        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1_IMPL_ONLY_ALARM.getBytes()), vt);
        
        assertTrue(OilImplFactory_Impl.getAnInstance(vt).getImplNames().length == 1);
    }

    
    public void testLoad_test_implementationsMerge() {
    	IVarTree vt1 = (IVarTree) RTDFactory.get(IVarTree.class);
    	IVarTree vt2 = (IVarTree) RTDFactory.get(IVarTree.class);
    	OilImplFactory oif_1 = OilImplFactory.getAnInstance(vt1);
    	OilImplFactory oif_2 = OilImplFactory.getAnInstance(vt2);
    	
    	OilImplID[] oids = null;
    	
    	oids = oif_1.getImplNames();
        assertTrue(oids != null);
        assertTrue(oids.length == 0);
        oids = oif_2.getImplNames();
        assertTrue(oids != null);
        assertTrue(oids.length == 0);
        
        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1_IMPL_ONLY_OS.getBytes()), vt1);
        (new OilReader()).load(new ByteArrayInputStream(OIL_TEST_1_IMPL_ONLY_ALARM.getBytes()), vt2);

        assertTrue(oif_1.getImplNames().length == 1);
        assertTrue(oif_2.getImplNames().length == 1);
        
    	assertTrue(oif_1 == OilImplFactory.getAnInstance(vt1));
    	assertTrue(oif_2 == OilImplFactory.getAnInstance(vt2));
        
    	IOilImplementation oi_1 = oif_1.getImpl(oif_1.getImplNames()[0]);
    	IOilImplementation oi_2 = oif_2.getImpl(oif_1.getImplNames()[0]);
    	
    	String s1 = oi_1.toOil();
    	String s2 = oi_2.toOil();
    	
    	assertTrue(oi_1.equals(oi_2) == false);
    	assertTrue(oi_1.equalsImpl(oi_2) == false);
    	assertTrue(oi_2.equalsImpl(oi_1) == false);
    	assertTrue(s1.equals(s2) == false);
    	
    	
    	assertTrue(oi_1.mergeImpl(oi_2) == true);
    	String s3 = oi_1.toOil();
    	System.out.println(">>>>>>> S1 \n"+ s1+"S1 <<<<<<<<\n");
    	System.out.println(">>>>>>> S2 \n"+ s2+"S2 <<<<<<<<\n");
    	System.out.println(">>>>>>> S3 \n"+ s3+"S3 <<<<<<<<\n");
    	assertTrue(s1.equals(s3) == false);
    	
    }

    
    final static protected String OIL_TEST_WRONG_ENUM =
		"    CPU test {" +
		"        OS testOS {" +
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
}

