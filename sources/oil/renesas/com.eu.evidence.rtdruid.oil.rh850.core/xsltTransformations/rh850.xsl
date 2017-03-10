<?xml version="1.0" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.1">
 <xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes" omit-xml-declaration="no"/>  

    <!-- ============================================================================================================ -->
    <!--                              OS    (eecfg.c, stack definition)                                               -->
    <!-- ============================================================================================================ -->
<xsl:template match="object[@Type='OS']/parameter[@Name='CPU_DATA']/enumerator[@Name='RH850']/parameter[@Name='MULTI_STACK']/enumerator[@Name='TRUE']" mode="build_eecfg_c">
#include "ee.h"

// STACK configuration
<xsl:if test="parameter[@Name='IRQ_STACK']/enumerator[@Name='TRUE']/parameter[@Name='SYS_SIZE']">
#define STACK_IRQ_SIZE <xsl:value-of select="parameter[@Name='IRQ_STACK']/enumerator[@Name='TRUE']/parameter[@Name='SYS_SIZE']/@CurrValue"/><xsl:text> </xsl:text>
int EE_stack_IRQ[STACK_IRQ_SIZE];

/* stack used only by IRQ handlers */
struct EE_TOS EE_rh850_IRQ_tos = {
    (EE_ADDR)(&amp;EE_stack_IRQ[STACK_IRQ_SIZE - 33])
};

</xsl:if>

<xsl:for-each select="../../../../../object[@Type='TASK']/parameter[@Name='STACK']/enumerator[@Name='PRIVATE']/parameter[@Name='SYS_SIZE']">
#define STACK_<xsl:value-of select="../../../@Name"/>_ID <xsl:value-of select="position()" />U
#define STACK_<xsl:value-of select="../../../@Name"/>_SIZE <xsl:value-of select="@CurrValue"/>
int EE_stack_<xsl:value-of select="../../../@Name"/>[STACK_<xsl:value-of select="../../../@Name"/>_SIZE];
</xsl:for-each>


const EE_UREG EE_rh850_thread_tos[EE_MAX_TASK+1] = {
        0U, /* dummy */<xsl:for-each select="../../../../../object[@Type='TASK']"><xsl:choose><xsl:when test="parameter[@Name='STACK']/enumerator[@Name='PRIVATE']/parameter[@Name='SYS_SIZE']">
        STACK_<xsl:value-of select="@Name"/>_ID,</xsl:when><xsl:otherwise>
        0U,</xsl:otherwise></xsl:choose>
</xsl:for-each>
};

/* STACK_SIZE - OFFSET for initial stack change (1+32 Registers) */
struct EE_TOS EE_rh850_system_tos[<xsl:value-of select="count(../../../../../object[@Type='TASK']/parameter[@Name='STACK']/enumerator[@Name='PRIVATE']/parameter[@Name='SYS_SIZE'])+1"/>] = {
        {0}, /* shared */<xsl:for-each select="../../../../../object[@Type='TASK']/parameter[@Name='STACK']/enumerator[@Name='PRIVATE']/parameter[@Name='SYS_SIZE']">
        {(EE_ADDR)(&amp;EE_stack_<xsl:value-of select="../../../@Name"/>[STACK_<xsl:value-of select="../../../@Name"/>_SIZE - 33])},</xsl:for-each>
};


EE_UREG EE_rh850_active_tos = 0U; /* dummy */

</xsl:template> 
    
    
    <!-- ============================================================================================================ -->
    <!--                              OS    (eecfg.h)                                                                 -->
    <!-- ============================================================================================================ -->
    
<xsl:template match="object[@Type='OS']/parameter[@Name='CPU_DATA']/enumerator[@Name='RH850']" mode="build_eecfg_h">
</xsl:template>

    <!-- ============================================================================================================ -->
    <!--                              OS    (makefile)                                                                 -->
    <!-- ============================================================================================================ -->
    
<xsl:template match="object[@Type='OS']/parameter[@Name='CPU_DATA']/enumerator[@Name='RH850']" mode="build_makefile">
APPBASE := ..
OUTBASE := Debug
EEOPT += __RTD_CYGWIN__
</xsl:template>


    <!-- ============================================================================================================ -->
    <!--                              CPU         (makefile, add a define)                                             -->
    <!-- ============================================================================================================ -->
<xsl:template match="object[@Type='OS']/parameter[@Name='CPU_DATA']/enumerator[@Name='RH850']" mode="build_makefile">
## CPU OPTIONS ##
# CPU Family
EEOPT += __<xsl:value-of select="@Name"/>__
# CPU Model 
EEOPT += __<xsl:value-of select="@Name"/><xsl:value-of select="parameter[@Name='MODEL']/@CurrValue"/>__
# Compiler Type
EEOPT += __<xsl:value-of select="parameter[@Name='COMPILER_TYPE']/@CurrValue"/>__
# Compiler path
COMP_DIR := $(shell cygpath `cygpath -wa '<xsl:value-of select="parameter[@Name='COMPILER_PATH']/@CurrValue"/>'`)
# Crystal Speed
EEOPT += __CRYSTAL<xsl:value-of select="parameter[@Name='CRYSTAL']/@CurrValue"/>__
#################
</xsl:template>
    
    <!-- ============================================================================================================ -->
    <!--                              MCU         (makefile, add a define)                                            -->
    <!-- ============================================================================================================ -->
<xsl:template match="object[@Type='OS']/parameter[@Name='MCU_DATA']/enumerator[@Name='F1H']" mode="build_makefile">
## MCU OPTIONS ## 
EEOPT += __<xsl:value-of select="parameter[@Name='MODEL']/@CurrValue"/>__
<xsl:if test="parameter[@Name='CUSTOM_STARTUP']/enumerator[@Name='TRUE']/parameter[@Name='STARTUP_SRCS']">
STARTUP_SRCS += <xsl:value-of select="parameter[@Name='CUSTOM_STARTUP']/enumerator[@Name='TRUE']/parameter[@Name='STARTUP_SRCS']/@CurrValue"/>
</xsl:if>
<xsl:if test="parameter[@Name='CUSTOM_LINKER']/enumerator[@Name='TRUE']/parameter[@Name='LINKERFILE']">
MCU_LINKERSCRIPT = <xsl:value-of select="parameter[@Name='CUSTOM_LINKER']/enumerator[@Name='TRUE']/parameter[@Name='LINKERFILE']/@CurrValue"/>
</xsl:if>
<xsl:if test="parameter[@Name='USE_CLOCK_INIT']/enumerator[@Name='TRUE']">
EEOPT += __USE_CLOCK_INIT__
</xsl:if>
<xsl:if test="parameter[@Name='USE_TIMER_INT']/enumerator[@Name='TRUE']">
EEOPT += __USE_TIMER_INT__
</xsl:if>
#################
</xsl:template>

<xsl:template match="object[@Type='OS']/parameter[@Name='MCU_DATA']/enumerator[@Name='F1L']" mode="build_makefile">
## MCU OPTIONS ## 
EEOPT += __<xsl:value-of select="parameter[@Name='MODEL']/@CurrValue"/>__
<xsl:if test="parameter[@Name='CUSTOM_STARTUP']/enumerator[@Name='TRUE']/parameter[@Name='STARTUP_SRCS']">
STARTUP_SRCS += <xsl:value-of select="parameter[@Name='CUSTOM_STARTUP']/enumerator[@Name='TRUE']/parameter[@Name='STARTUP_SRCS']/@CurrValue"/>
</xsl:if>
<xsl:if test="parameter[@Name='CUSTOM_LINKER']/enumerator[@Name='TRUE']/parameter[@Name='LINKERFILE']">
MCU_LINKERSCRIPT = <xsl:value-of select="parameter[@Name='CUSTOM_LINKER']/enumerator[@Name='TRUE']/parameter[@Name='LINKERFILE']/@CurrValue"/>
</xsl:if>
<xsl:if test="parameter[@Name='USE_CLOCK_INIT']/enumerator[@Name='TRUE']">
EEOPT += __USE_CLOCK_INIT__
</xsl:if>
<xsl:if test="parameter[@Name='USE_TIMER_INT']/enumerator[@Name='TRUE']">
EEOPT += __USE_TIMER_INT__
</xsl:if>
#################
</xsl:template>

    <!-- ============================================================================================================ -->
    <!--                              BOARD      (makefile, add a define)                                             -->
    <!-- ============================================================================================================ -->
<xsl:template match="object[@Type='OS']/parameter[@Name='BOARD_DATA']/enumerator[@Name='Y_ASK_RH850F1X_V2']" mode="build_makefile">
## BOARD OPTIONS ##
# Board Model
EEOPT += __<xsl:value-of select="@Name"/>__
<xsl:if test="parameter[@Name='USE_LEDS']/enumerator[@Name='TRUE']">
# Use Board LEDS 
EEOPT += __USE_LEDS__
</xsl:if>
#################
</xsl:template>

    <!-- ============================================================================================================ -->
    <!--                             STARTING POINT                                                                   -->
    <!-- ============================================================================================================ -->

<xsl:template match="application">
<CODE_GENERATION>
<OUTPUT_BUFFER name="eecfg.h">
		<xsl:apply-templates select="/" mode="build_eecfg_h"/> 
</OUTPUT_BUFFER>
<OUTPUT_BUFFER name="eecfg.c">
        <xsl:apply-templates select="/" mode="build_eecfg_c"/>
</OUTPUT_BUFFER>
<OUTPUT_BUFFER name="makefile">
        <xsl:apply-templates select="/" mode="build_makefile"/>
</OUTPUT_BUFFER>
</CODE_GENERATION>
</xsl:template>

</xsl:stylesheet>