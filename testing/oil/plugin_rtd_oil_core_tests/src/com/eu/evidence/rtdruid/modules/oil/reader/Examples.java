/**
 * 30/dic/2011
 */
package com.eu.evidence.rtdruid.modules.oil.reader;

import com.eu.evidence.rtdruid.test.modules.oil.codewriter.CodeWritertTest;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
interface Examples {


    String OIL_TEST_1 =
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
    
    String OIL_TEST_1_IMPL_ONLY =
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
    String OIL_TEST_1_IMPL_ONLY_OS =
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
    String OIL_TEST_1_IMPL_ONLY_ALARM =
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
    String OIL_TEST_1_SPLITTED_IMPL_ONLY_ALARM =
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

    
    String OIL_TEST_2 =
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

    String OIL_TEST_2_IMPL_ONLY =
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
		"    };";

    String OIL_TEST_SENZA_IMPL =
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

    String OIL_TEST_WRONG_ENUM =
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

	String OIL_TEST_ARM7 = CodeWritertTest.DEFAULT_EE_IMPLEMENTATION
			+ "CPU EE {\n"
			+ "    OS EE {\n"
			+ "        EE_OPT = \"__ASSERT__\";\n"
			+ "        EE_OPT = \"__OSEKOS_NO_ALARMS__\";\n"
			+ "        EE_OPT = \"DEBUG\";\n"+
			
			"		CPU_DATA = ARM7 {\n" +
			"			MULTI_STACK = TRUE {\n" +
			"				IRQ_STACK = FALSE;\n" +
			"				DUMMY_STACK = SHARED;\n" +
			"			};\n" +
			"			\n" +
			"			APP_SRC = \"code.c\";\n" +
			"	\n" 
			+ "        STACK_TOP = 0x20004000;\n"
			+ "        STACK_BOTTOM = 0x20001800;\n"
			+ "        SYS_SIZE = 0x1000;\n"
			+ "        IRQ_SIZE = 0x1000;\n"
			+ "        SVC_SIZE = 0x200;\n"
			+ "        FIQ_SIZE = 0x200;\n"
			+ "        ABT_SIZE = 0x200;\n"
			+ "        UND_SIZE = 0x200;\n"+
			"	\n" +
			"		};\n"+ 
		
			"		MCU_DATA = SAMSUNG_KS32C50100 {\n"+
			"          IRQ_EXT0       =\"Ext 0\";\n" +
			"          IRQ_EXT1       =\"Ext 1\";\n" +
			"          IRQ_EXT2       =\"Ext 2\";\n" +
			"          IRQ_EXT3       =\"Ext 3\";\n" +
			"          IRQ_UART0TX    =\"UART0 Tx\";\n" +
			"          IRQ_UART0RX    =\"UART0 Rx & error\";\n" +
			"          IRQ_UART1TX    =\"UART1 Tx\";\n" +
			"          IRQ_UART1RX    =\"UART1 Rx & error\";\n" +
			"          IRQ_GDMA0      =\"GDMA ch. 0\";\n" +
			"          IRQ_GDMA1      =\"GDMA ch. 1\";\n" +
			"          IRQ_TIMER0     =\"Timer 0\";\n" +
			"          IRQ_TIMER1     =\"Timer 1\";\n" +
			"          IRQ_HDLCATX    =\"HDLC A Tx\";\n" +
			"          IRQ_HDLCARX    =\"HDLC A Rx\";\n" +
			"          IRQ_HDLCBTX    =\"HDLC B Tx\";\n" +
			"          IRQ_HDLCBRX    =\"HDLC B Rx\";\n" +
			"          IRQ_ETHBDMATX  =\"Ethernet BDMA Tx\";\n" +
			"          IRQ_ETHBDMARX  =\"Ethernet BDMA Rx\";\n" +
			"          IRQ_ETHMACTX   =\"Ethernet MAC Tx\";\n" +
			"          IRQ_ETHMACRX   =\"Ethernet MAC Rx\";\n" +
			"          IRQ_I2C        =\"I2C-bus\";\n"+
			"          IRQ_NO_PENDING =\"No Pending Interrupt\";\n" +
			"		};\n"
			
			+ "        STATUS = EXTENDED;\n"
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
			+ "    TASK Task1Act4 {\n"
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
			+ "        PRIORITY = 0x02;\n"
			+ "        ACTIVATION = 1;\n"
			+ "        SCHEDULE = FULL;\n"
			+ "        AUTOSTART = TRUE;\n"
			+ "        STACK = SHARED;\n"
			+ "    };\n"
			+ "	 EVENT evento1 {};\n"
			+ "};\n";

	String OIL_TEST_WITH_RESOURCE = CodeWritertTest.DEFAULT_EE_IMPLEMENTATION
			+ "CPU test_application {\n" +

			"    OS EE {\n" +
			"  EE_OPT = \"__OSEKOS_STARTOS_WITHOUT_IDLELOOP__\";\n" +
			"        EE_OPT = \"__ASSERT__\";\n" +
			"        EE_OPT = \"DEBUG\";\n" +

			"  STATUS = EXTENDED;\n" +

			"  STARTUPHOOK = FALSE;\n" +
			"  ERRORHOOK = FALSE;\n" +
			"  SHUTDOWNHOOK = FALSE;\n" +
			"  PRETASKHOOK = FALSE;\n" +
			"  POSTTASKHOOK = FALSE;\n" +
			"  USEGETSERVICEID = FALSE;\n" +
			"  USEPARAMETERACCESS = FALSE;\n" +
			"  USERESSCHEDULER = FALSE;\n" +

			"  MCU_DATA = SAMSUNG_KS32C50100 {\n" +
			"     IRQ_TIMER0 = \"myISR2\";\n" +
			"  };\n" +
			"        EE_OPT = \"__TIMER_0_USED__\";\n" +

			"  CPU_DATA = ARM7 {\n" +
			"   APP_SRC = \"code.c\";\n" +

			"   STACK_TOP = 0x80000;\n" +
			"   STACK_BOTTOM = 0x20000;\n" +
			"   SYS_SIZE = 0x4000;\n" +
			"   IRQ_SIZE = 0x4000;\n" +
			"   SVC_SIZE = 0x4000;\n" +
			"   FIQ_SIZE = 0x4000;\n" +
			"   ABT_SIZE = 0x4000;\n" +
			"   UND_SIZE = 0x4000;\n" +
			"   MULTI_STACK = FALSE;\n" +
			"  };\n" +

			"        KERNEL_TYPE = BCC1;\n" +
			"    };\n" +

			"    TASK Task1 {\n" +
			"  PRIORITY = 1;\n" +
			"  ACTIVATION = 1;\n" +
			"  SCHEDULE = FULL;\n" +
			"  AUTOSTART = TRUE;\n" +
			"  STACK = SHARED;\n" +
			"  RESOURCE = \"Resource1\";\n" +
			"  RESOURCE = \"Resource2\";\n" +
			"  RESOURCE = \"Resource3\";\n" +
			"  RESOURCE = \"Resource4\";\n" +
			"  RESOURCE = \"Resource5\";\n" +
			"  RESOURCE = \"Resource6\";\n" +
			"    };\n" +

			"    TASK Task2 {\n" +
			"  PRIORITY = 2;\n" +
			"  ACTIVATION = 1;\n" +
			"  SCHEDULE = FULL;\n" +
			"  AUTOSTART = FALSE;\n" +
			"  STACK = SHARED;\n" +
			"  RESOURCE = \"ResourceA\";\n" +
			"    };\n" +

			"    RESOURCE Resource1 { RESOURCEPROPERTY = STANDARD; };\n" +
			"    RESOURCE Resource2 { RESOURCEPROPERTY = STANDARD; };\n" +
			"    RESOURCE Resource3 { RESOURCEPROPERTY = STANDARD; };\n" +
			"    RESOURCE Resource4 { RESOURCEPROPERTY = STANDARD; };\n" +
			"    RESOURCE Resource5 { RESOURCEPROPERTY = STANDARD; };\n" +
			"    RESOURCE Resource6 { RESOURCEPROPERTY = STANDARD; };\n" +
			"    RESOURCE ResourceA { RESOURCEPROPERTY = STANDARD; };\n" +
			"};\n";

	String OIL_TEST_DEFAULT_VALUE = CodeWritertTest.DEFAULT_EE_IMPLEMENTATION
	+ "CPU EE {\n"
	+ "    OS EE {};\n"
	+ "    TASK Task1Act4 {\n"
	+ "        PRIORITY = 0x01;\n"
	+ "        STACK = PRIVATE {\n"
	+ "            SYS_SIZE = 0x100;\n"
	+ "        };\n"
	+ "        EVENT = evento1;\n"
	+ "    };\n"
	+ "};\n";

	String OIL_TEST_2_NIOS = CodeWritertTest.DEFAULT_EE_IMPLEMENTATION
			+ "CPU EE {\n"
			+ "    OS EE {\n"
			+ "        EE_OPT = \"__ASSERT__\";\n"
			+ "        EE_OPT = \"__OSEKOS_NO_ALARMS__\";\n"
			+ "        EE_OPT = \"DEBUG\";\n"+
			
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
			+ "        SYS_SIZE = 0x1000;\n" +
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
			//+ "        STACK_BOTTOM = 0x20004000;\n"
			+ "        SYS_SIZE = 0x1000;\n" +
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

}
