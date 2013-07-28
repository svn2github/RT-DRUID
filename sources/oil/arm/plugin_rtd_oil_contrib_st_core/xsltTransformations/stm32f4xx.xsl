<?xml version="1.0" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.1">
 <xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes" omit-xml-declaration="no"/>  


<!-- ============================================================================================================ -->
<!--                                           LIB         (makefile)                                             -->
<!-- ============================================================================================================ -->
<xsl:template match="object[@Type='OS']/parameter[@Name='LIB']/enumerator[@Name='ENABLE']" mode="build_makefile">


<!-- ======================================( STM32F4XX_SPD )============================================== -->

<xsl:if test="parameter[@Name='NAME']/@CurrValue='STM32F4XX_SPD'">

############################################################################
#
# STM32F4XX_SPD Options
#
############################################################################
EEOPT += __USE_STM32F4XX_SPD__

<xsl:if test="parameter[@Name='STM32F4XX_SPD']/enumerator[@Name='ENABLE']/parameter[@Name='USEALL']/enumerator[@Name='TRUE']">
EEOPT += __USE_STM32F4XX_SPD_ALL__
</xsl:if>

<xsl:if test="parameter[@Name='STM32F4XX_SPD']/enumerator[@Name='ENABLE']/parameter[@Name='USEADC']/enumerator[@Name='TRUE']">
EEOPT += __USE_STM32F4XX_SPD_ADC__
</xsl:if>

<xsl:if test="parameter[@Name='STM32F4XX_SPD']/enumerator[@Name='ENABLE']/parameter[@Name='USECAN']/enumerator[@Name='TRUE']">
EEOPT += __USE_STM32F4XX_SPD_CAN__
</xsl:if>

<xsl:if test="parameter[@Name='STM32F4XX_SPD']/enumerator[@Name='ENABLE']/parameter[@Name='USECRC']/enumerator[@Name='TRUE']">
EEOPT += __USE_STM32F4XX_SPD_CRC__
</xsl:if>

<xsl:if test="parameter[@Name='STM32F4XX_SPD']/enumerator[@Name='ENABLE']/parameter[@Name='USECRYP']/enumerator[@Name='TRUE']">
EEOPT += __USE_STM32F4XX_SPD_CRYP__
</xsl:if>

<xsl:if test="parameter[@Name='STM32F4XX_SPD']/enumerator[@Name='ENABLE']/parameter[@Name='USEDAC']/enumerator[@Name='TRUE']">
EEOPT += __USE_STM32F4XX_SPD_DAC__
</xsl:if>

<xsl:if test="parameter[@Name='STM32F4XX_SPD']/enumerator[@Name='ENABLE']/parameter[@Name='USEDBGMCU']/enumerator[@Name='TRUE']">
EEOPT += __USE_STM32F4XX_SPD_DBGMCU__
</xsl:if>

<xsl:if test="parameter[@Name='STM32F4XX_SPD']/enumerator[@Name='ENABLE']/parameter[@Name='USEDBGMCU']/enumerator[@Name='TRUE']">
EEOPT += __USE_STM32F4XX_SPD_DCMI__
</xsl:if>

<xsl:if test="parameter[@Name='STM32F4XX_SPD']/enumerator[@Name='ENABLE']/parameter[@Name='USEDMA']/enumerator[@Name='TRUE']">
EEOPT += __USE_STM32F4XX_SPD_DMA__
</xsl:if>

<xsl:if test="parameter[@Name='STM32F4XX_SPD']/enumerator[@Name='ENABLE']/parameter[@Name='USEEXTI']/enumerator[@Name='TRUE']">
EEOPT += __USE_STM32F4XX_SPD_EXTI__
</xsl:if>

<xsl:if test="parameter[@Name='STM32F4XX_SPD']/enumerator[@Name='ENABLE']/parameter[@Name='USEFLASH']/enumerator[@Name='TRUE']">
EEOPT += __USE_STM32F4XX_SPD_FLASH__
</xsl:if>

<xsl:if test="parameter[@Name='STM32F4XX_SPD']/enumerator[@Name='ENABLE']/parameter[@Name='USEFSMC']/enumerator[@Name='TRUE']">
EEOPT += __USE_STM32F4XX_SPD_FSMC__
</xsl:if>

<xsl:if test="parameter[@Name='STM32F4XX_SPD']/enumerator[@Name='ENABLE']/parameter[@Name='USEGPIO']/enumerator[@Name='TRUE']">
EEOPT += __USE_STM32F4XX_SPD_GPIO__
</xsl:if>

<xsl:if test="parameter[@Name='STM32F4XX_SPD']/enumerator[@Name='ENABLE']/parameter[@Name='USEHASH']/enumerator[@Name='TRUE']">
EEOPT += __USE_STM32F4XX_SPD_HASH__
</xsl:if>

<xsl:if test="parameter[@Name='STM32F4XX_SPD']/enumerator[@Name='ENABLE']/parameter[@Name='USEI2C']/enumerator[@Name='TRUE']">
EEOPT += __USE_STM32F4XX_SPD_I2C__
</xsl:if>

<xsl:if test="parameter[@Name='STM32F4XX_SPD']/enumerator[@Name='ENABLE']/parameter[@Name='USEIWDG']/enumerator[@Name='TRUE']">
EEOPT += __USE_STM32F4XX_SPD_IWDG__
</xsl:if>

<xsl:if test="parameter[@Name='STM32F4XX_SPD']/enumerator[@Name='ENABLE']/parameter[@Name='USEPWR']/enumerator[@Name='TRUE']">
EEOPT += __USE_STM32F4XX_SPD_PWR__
</xsl:if>

<xsl:if test="parameter[@Name='STM32F4XX_SPD']/enumerator[@Name='ENABLE']/parameter[@Name='USERCC']/enumerator[@Name='TRUE']">
EEOPT += __USE_STM32F4XX_SPD_RCC__
</xsl:if>

<xsl:if test="parameter[@Name='STM32F4XX_SPD']/enumerator[@Name='ENABLE']/parameter[@Name='USERNG']/enumerator[@Name='TRUE']">
EEOPT += __USE_STM32F4XX_SPD_RNG__
</xsl:if>

<xsl:if test="parameter[@Name='STM32F4XX_SPD']/enumerator[@Name='ENABLE']/parameter[@Name='USERTC']/enumerator[@Name='TRUE']">
EEOPT += __USE_STM32F4XX_SPD_RTC__
</xsl:if>

<xsl:if test="parameter[@Name='STM32F4XX_SPD']/enumerator[@Name='ENABLE']/parameter[@Name='USESDIO']/enumerator[@Name='TRUE']">
EEOPT += __USE_STM32F4XX_SPD_SDIO__
</xsl:if>

<xsl:if test="parameter[@Name='STM32F4XX_SPD']/enumerator[@Name='ENABLE']/parameter[@Name='USESPI']/enumerator[@Name='TRUE']">
EEOPT += __USE_STM32F4XX_SPD_SPI__
</xsl:if>

<xsl:if test="parameter[@Name='STM32F4XX_SPD']/enumerator[@Name='ENABLE']/parameter[@Name='USESYSCFG']/enumerator[@Name='TRUE']">
EEOPT += __USE_STM32F4XX_SPD_SYSCFG__
</xsl:if>

<xsl:if test="parameter[@Name='STM32F4XX_SPD']/enumerator[@Name='ENABLE']/parameter[@Name='USETIM']/enumerator[@Name='TRUE']">
EEOPT += __USE_STM32F4XX_SPD_TIM__
</xsl:if>

<xsl:if test="parameter[@Name='STM32F4XX_SPD']/enumerator[@Name='ENABLE']/parameter[@Name='USEUSART']/enumerator[@Name='TRUE']">
EEOPT += __USE_STM32F4XX_SPD_USART__
</xsl:if>

<xsl:if test="parameter[@Name='STM32F4XX_SPD']/enumerator[@Name='ENABLE']/parameter[@Name='USEWWDG']/enumerator[@Name='TRUE']">
EEOPT += __USE_STM32F4XX_SPD_WWDG__
</xsl:if>

<xsl:if test="parameter[@Name='STM32F4XX_SPD']/enumerator[@Name='ENABLE']/parameter[@Name='USEMISC']/enumerator[@Name='TRUE']">
EEOPT += __USE_STM32F4XX_SPD_MISC__
</xsl:if>

</xsl:if>

 <!-- ================================================( STM32F4_DISCOVERY )============================================ -->

<xsl:if test="parameter[@Name='NAME']/@CurrValue='STM32F4_DISCOVERY'">

############################################################################
#
# STM32F4_DISCOVERY Options
#
############################################################################
EEOPT += __USE_STM32F4_DISCOVERY__

<xsl:if test="parameter[@Name='STM32F4_DISCOVERY']/enumerator[@Name='ENABLE']/parameter[@Name='USEALL']/enumerator[@Name='TRUE']">
EEOPT += __USE_STM32F4_DISCOVERY_ALL__
</xsl:if>

<xsl:if test="parameter[@Name='STM32F4_DISCOVERY']/enumerator[@Name='ENABLE']/parameter[@Name='USELEDS']/enumerator[@Name='TRUE']">
EEOPT += __USE_STM32F4_DISCOVERY_LEDS__
EEOPT += __USE_STM32F4XX_SPD_GPIO__
EEOPT += __USE_STM32F4XX_SPD_RCC__
</xsl:if>

<xsl:if test="parameter[@Name='STM32F4_DISCOVERY']/enumerator[@Name='ENABLE']/parameter[@Name='USEBUTTONS']/enumerator[@Name='TRUE']">
EEOPT += __USE_STM32F4_DISCOVERY_BUTTONS__
EEOPT += __USE_STM32F4XX_SPD_GPIO__
EEOPT += __USE_STM32F4XX_SPD_RCC__
EEOPT += __USE_STM32F4XX_SPD_EXTI__
EEOPT += __USE_STM32F4XX_SPD_SYSCFG__
</xsl:if>

<xsl:if test="parameter[@Name='STM32F4_DISCOVERY']/enumerator[@Name='ENABLE']/parameter[@Name='USECOM']/enumerator[@Name='TRUE']">
EEOPT += __USE_STM32F4_DISCOVERY_COM__
EEOPT += __USE_STM32F4XX_SPD_GPIO__
EEOPT += __USE_STM32F4XX_SPD_RCC__
EEOPT += __USE_STM32F4XX_SPD_USART__
</xsl:if>

<xsl:if test="parameter[@Name='STM32F4_DISCOVERY']/enumerator[@Name='ENABLE']/parameter[@Name='USEAUDIO']/enumerator[@Name='TRUE']">
EEOPT += __USE_STM32F4_DISCOVERY_AUDIO__
EEOPT += __USE_STM32F4XX_SPD_GPIO__
EEOPT += __USE_STM32F4XX_SPD_RCC__
EEOPT += __USE_STM32F4XX_SPD_DMA__
EEOPT += __USE_STM32F4XX_SPD_SPI__
EEOPT += __USE_STM32F4XX_SPD_DAC__
EEOPT += __USE_STM32F4XX_SPD_I2C__
</xsl:if>

<xsl:if test="parameter[@Name='STM32F4_DISCOVERY']/enumerator[@Name='ENABLE']/parameter[@Name='USELCD']/enumerator[@Name='TRUE']">
EEOPT += __USE_STM32F4_DISCOVERY_LCD__
EEOPT += __USE_STM32F4XX_SPD_GPIO__
EEOPT += __USE_STM32F4XX_SPD_RCC__
EEOPT += __USE_STM32F4XX_SPD_FSMC__
</xsl:if>

<xsl:if test="parameter[@Name='STM32F4_DISCOVERY']/enumerator[@Name='ENABLE']/parameter[@Name='USELCDLOG']/enumerator[@Name='TRUE']">
EEOPT += __USE_STM32F4_DISCOVERY_LCD__
EEOPT += __USE_STM32F4XX_SPD_GPIO__
EEOPT += __USE_STM32F4XX_SPD_RCC__
EEOPT += __USE_STM32F4XX_SPD_FSMC__
EEOPT += __USE_STM32F4_DISCOVERY_LCD_LOG__
</xsl:if>

<xsl:if test="parameter[@Name='STM32F4_DISCOVERY']/enumerator[@Name='ENABLE']/parameter[@Name='USEACCEL']/enumerator[@Name='TRUE']">
EEOPT += __USE_STM32F4_DISCOVERY_ACCEL__
EEOPT += __USE_STM32F4XX_SPD_GPIO__
EEOPT += __USE_STM32F4XX_SPD_RCC__
EEOPT += __USE_STM32F4XX_SPD_SPI__
</xsl:if>

<xsl:if test="parameter[@Name='STM32F4_DISCOVERY']/enumerator[@Name='ENABLE']/parameter[@Name='USESD']/enumerator[@Name='TRUE']">
EEOPT += __USE_STM32F4_DISCOVERY_SD__
EEOPT += __USE_STM32F4XX_SPD_GPIO__
EEOPT += __USE_STM32F4XX_SPD_RCC__
EEOPT += __USE_STM32F4XX_SPD_DMA__
EEOPT += __USE_STM32F4XX_SPD_SDIO__
</xsl:if>

<xsl:if test="parameter[@Name='STM32F4_DISCOVERY']/enumerator[@Name='ENABLE']/parameter[@Name='USEUARTDEBUG']/enumerator[@Name='TRUE']">
EEOPT += __USE_STM32F4_DISCOVERY_UART_DEBUG__
EEOPT += __USE_STM32F4_DISCOVERY_COM__
EEOPT += __USE_STM32F4XX_SPD_USART__
</xsl:if>

</xsl:if>

</xsl:template>




<!-- ============================================================================================================ -->
<!--                                            LIB         (eecfg.h)                                             -->
<!-- ============================================================================================================ -->


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
