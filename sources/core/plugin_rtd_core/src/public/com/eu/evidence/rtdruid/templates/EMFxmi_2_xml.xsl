<?xml version="1.0" encoding="ISO-8859-1"?>
<!-- Edited with XML Spy v4.2 -->
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
xmlns:com.eu.evidence.rtdruid.data="http://www.evidence.eu.com/rtdruid/data"
>
<!-- xmlns:xsi="xsi"-->

<xsl:output method="xml" indent="yes" doctype-system="evidence_0.4.dtd"/>


<xsl:template match="/">

<xsl:for-each select="com.eu.evidence.rtdruid.data:System">

<SYSTEM>
  <xsl:apply-templates select="@Name"/>

  <xsl:apply-templates select="Modes"/>
  <xsl:apply-templates select="Functional"/>
  <xsl:apply-templates select="Architectural"/>
  <xsl:apply-templates select="Mapping"/>
  <xsl:apply-templates select="Annotation"/>
  <xsl:apply-templates select="Schedulability"/>
  
</SYSTEM>
</xsl:for-each>
</xsl:template>


<!--

    	ANNOTATION

-->
<xsl:template match="Annotation">
  <ANNOTATION>
  
  <xsl:for-each select="ExecTimeLists">
    <xsl:for-each select="ExecTimeItemsList">
  
      <EXECTIME>
	  	<xsl:apply-templates select="../@ModeRef"/>
		<xsl:apply-templates select="@Type"/>
		<xsl:apply-templates select="@Ref"/>
		
		<xsl:apply-templates select="@Worst"/>
		<xsl:apply-templates select="@Best"/>
		
		<xsl:apply-templates select="Distribution"/>

      </EXECTIME>
	  
	</xsl:for-each>
  </xsl:for-each>

  <xsl:for-each select="CacheMissCostLists">
    <xsl:for-each select="CacheMissCostItemsList">
  
      <CACHE_MISS_COST>
	  	<xsl:apply-templates select="../@ModeRef"/>
		<xsl:apply-templates select="@Type"/>
		<xsl:apply-templates select="@Ref"/>
		
		<xsl:apply-templates select="@Worst"/>
		<xsl:apply-templates select="@Best"/>
		
		<xsl:apply-templates select="Distribution"/>

      </CACHE_MISS_COST>
	  
	</xsl:for-each>
  </xsl:for-each>

  </ANNOTATION>
</xsl:template>

<xsl:template match="Distribution">
    <DISTRIBUTION>
      <xsl:apply-templates select="@Type"/>
	  
      <xsl:apply-templates select="@Avg"/>
      <xsl:apply-templates select="@Variance"/>

      <xsl:apply-templates select="SampleList"/>
    </DISTRIBUTION>
</xsl:template>

<xsl:template match="SampleList">
    <SAMPLE>
       <xsl:apply-templates select="@Probability"/>
       <xsl:apply-templates select="@Value"/>
	</SAMPLE>
</xsl:template>

<!-- 

    ARCHITECTURAL

-->
<xsl:template match="Architectural">
  <ARCHITECTURAL>
  
    <xsl:for-each select="EcuList">
      <ECU>
	   <xsl:apply-templates select="@Name"/>

		 <xsl:for-each select="CpuList">
		 <CPU>
			<xsl:apply-templates select="@Name"/>
			<xsl:apply-templates select="@Model"/>

			<xsl:if test="count(Rtos) > 0">
			  <RTOS>
				<xsl:apply-templates select="Rtos/@Name"/>
				<xsl:apply-templates select="Rtos/@Type"/>
				
				<xsl:if test="count(Rtos/Methods) > 0">
				  <OSMODEL>
				  	<xsl:for-each select="Rtos/Methods">
						<METHOD>
							<xsl:attribute name="Name">
								<xsl:value-of select="."/>
							</xsl:attribute>
						</METHOD>
					</xsl:for-each>
				  </OSMODEL>
				</xsl:if>

				<xsl:apply-templates select="Rtos/@OilVar"/>
			  
			  </RTOS>
			</xsl:if>
		 </CPU>
		 </xsl:for-each>
    </ECU>
  </xsl:for-each> <!-- END ECU List-->

  <xsl:apply-templates select="TaskList"/><!-- END TASK List-->


  <xsl:for-each select="ResourceList">
	<RESOURCE>
	  <xsl:apply-templates select="@Name"/>
  
	  <xsl:for-each select="Methods">
		<METHOD>
			<xsl:attribute name="Name">
				<xsl:value-of select="."/>
			</xsl:attribute>
		</METHOD>
	  </xsl:for-each>
	   
	  <xsl:for-each select="MutexRefList">
	    <MUTEXREF>
			 <xsl:apply-templates select="@ModeRef"/>
			 <xsl:apply-templates select="@MutexName"/>
		</MUTEXREF>
	  </xsl:for-each>

     </RESOURCE>
   </xsl:for-each><!-- END RESOURCE List-->

   
  <xsl:for-each select="BusList">
	  <BUS>
		 <xsl:apply-templates select="@Name"/>
		 <xsl:apply-templates select="@Type"/>
		 <xsl:apply-templates select="@Speed"/>
	  </BUS>
  </xsl:for-each><!-- END BUS List-->


  <xsl:for-each select="FrameList">
	<FRAME>
	   <xsl:apply-templates select="@Name"/>
	   <xsl:apply-templates select="@Id"/>
	   <xsl:apply-templates select="@ActivationType"/>
	   <xsl:apply-templates select="@ActivationClass"/>
	   <xsl:apply-templates select="@ActivationRate"/>
	   <xsl:apply-templates select="@Length"/>
	</FRAME>
  </xsl:for-each><!-- END FRAME List-->


  <xsl:for-each select="SignalList">
	<SIGNAL>
	   <xsl:apply-templates select="@Name"/>
	   <xsl:apply-templates select="@Type"/>
	   <xsl:apply-templates select="@OilVar"/>
	</SIGNAL>
  </xsl:for-each><!-- END SIGNAL List-->


  <xsl:for-each select="MutexList">
	<MUTEX>
	   <xsl:apply-templates select="@Name"/>
	   <xsl:apply-templates select="@Policy"/>
	   <xsl:apply-templates select="@OilVar"/>
	</MUTEX>
  </xsl:for-each><!-- END MUTEX List-->

    
  </ARCHITECTURAL>
</xsl:template>

<!-- 
	TASK
-->
<xsl:template match="TaskList">

 <TASK>
   <xsl:apply-templates select="@Name"/>
   <xsl:apply-templates select="@Type"/>
   
   
   <xsl:apply-templates select="SchedulingList"/>
   <xsl:apply-templates select="ActivationList"/>
   <xsl:apply-templates select="ResourceRefList"/>

   <xsl:apply-templates select="@OilVar"/>
   
 </TASK>
</xsl:template>
			
			
<xsl:template match="ActivationList">
  <ACTIVATION>
    <xsl:apply-templates select="@ActNumber"/>
	<xsl:for-each select="@ActivationClass">
		<xsl:attribute name="Class">
			<xsl:value-of select="." disable-output-escaping="no"/>
		</xsl:attribute>
	</xsl:for-each>
    <xsl:apply-templates select="@Deadline"/>
    <xsl:apply-templates select="@ModeRef"/>
    <xsl:apply-templates select="@Offset"/>
    <xsl:apply-templates select="@Period"/>
    <xsl:apply-templates select="@Type"/>
  </ACTIVATION>
</xsl:template>

<xsl:template match="SchedulingList">
  <SCHEDULING>
    <xsl:apply-templates select="@ModeRef"/>
    <xsl:apply-templates select="@PreemptionGroupName"/>
	<xsl:apply-templates select="@Priority"/>
	<xsl:apply-templates select="@Threshold"/>
	<xsl:apply-templates select="@Stack"/>
  </SCHEDULING>
</xsl:template>

<xsl:template match="ResourceRefList">
  <RESOURCEREF>
    <xsl:apply-templates select="@ModeRef"/>
			
    <xsl:for-each select="ResourceMethodRef">
       <METHODREF>
	      <!--<xsl:apply-templates select="@Name"/>-->
	      <xsl:attribute name="Name">unused</xsl:attribute>
	      <xsl:attribute name="MethodName"><xsl:value-of select="."/></xsl:attribute>
	   </METHODREF>
    </xsl:for-each>
  </RESOURCEREF>
</xsl:template>


<!--

		FUNCTIONAL

-->
<xsl:template match="Functional">
  <FUNCTIONAL>
  
  
  <xsl:for-each select="EventList">
    <EVENT>
	  <xsl:apply-templates select="@Name"/>
	  <xsl:apply-templates select="@Type"/>
	  <xsl:apply-templates select="@MethodRefName"/>
	</EVENT>
  </xsl:for-each>

  <xsl:for-each select="PartialOrderList">
    <PARTIALORDER>
	  <xsl:apply-templates select="@ModeRef"/>
	  
      <xsl:for-each select="OrderList">
         <ORDER>
	       <xsl:if test="count(@FirstEvent) >0">
		     <EVENTREF>
		     <xsl:attribute name="Name">
			    <xsl:value-of select="@FirstEvent"/>
			 </xsl:attribute>
			 </EVENTREF>
		   </xsl:if>
	       <xsl:if test="count(@SecondEvent) >0">
		     <EVENTREF>
		     <xsl:attribute name="Name">
			    <xsl:value-of select="@SecondEvent"/>
			 </xsl:attribute>
			 </EVENTREF>
		   </xsl:if>
		</ORDER>
	  </xsl:for-each>
    </PARTIALORDER>
  </xsl:for-each>

  
  <xsl:apply-templates select='Implementation'/>
  
    
   <xsl:for-each select="TypeList">
    <TYPE>
    	<xsl:apply-templates select="@Name"/>
		<xsl:apply-templates select="@Dim"/>
    
	    <xsl:for-each select="Field">
			<FIELD>
    			<xsl:apply-templates select="@Name"/>
				<xsl:apply-templates select="@Size"/>
				<xsl:apply-templates select="@Type"/>
			</FIELD>
  		</xsl:for-each>
	</TYPE>
  </xsl:for-each>

  <xsl:for-each select="TimeConstList">
    <xsl:apply-templates select="TimeConstElementList"/>
  </xsl:for-each>

  </FUNCTIONAL>
</xsl:template>


<!--
	MethodRef
-->
<xsl:template match="MethodRefList">
	<METHODREF>
		<xsl:apply-templates select="@Name"/>
		<xsl:apply-templates select="@MethodName"/>
	</METHODREF>
</xsl:template>

<!--
	Proc
-->
<xsl:template match='Implementation[attribute::*[1] = "com.eu.evidence.rtdruid.data:Proc"]'>
<!--
<a1><xsl:value-of select="attribute::*[1]"/></a1>
<a2><xsl:value-of select="attribute::*[2]"/></a2>
<a3><xsl:value-of select="attribute::*[3]"/></a3>
<b><xsl:value-of select="@type"/></b>
<c><xsl:value-of select="@xsi:type"/></c>
<a1><xsl:value-of select="attribute::type"/></a1>
<a2><xsl:value-of select="attribute::xsi:type"/></a2>
-->

  <PROC>
	<xsl:apply-templates select="@Name"/>

    <xsl:for-each select="Methods">
		<METHOD>
			<xsl:attribute name="Name">
				<xsl:value-of select="."/>
			</xsl:attribute>
		</METHOD>
	</xsl:for-each>
	
    <xsl:apply-templates select="MethodRefList"/>
	
  </PROC>
</xsl:template>

<!--
	Provided_interface
-->
<xsl:template match="ProvidedInterfaceList">
	<METHOD>
		<xsl:apply-templates select="@Name"/>
	</METHOD>
			
	<!-- Make an EXPORTED_METHOD ? -->
	<xsl:if test=" count(@LocalMethodRef) >0 or count(LocalObjectRef) >0">
		<EXPORTED_METHOD>
			<xsl:attribute name="MethodRef">
				<xsl:value-of select="@LocalMethodRef"/>
			</xsl:attribute>
			<xsl:attribute name="ObjRef">
				<xsl:value-of select="@LocalObjectRef"/>
			</xsl:attribute>
		</EXPORTED_METHOD>
	</xsl:if>
</xsl:template>

<!--
	Requided_interface
-->
<xsl:template match="RequiredInterfaceList">
	<METHOD>
		<xsl:apply-templates select="@Name"/>
	</METHOD>
			
	<!-- Make a METHODREF ? -->
	<xsl:if test=" count(@ExternalMethodRef) >0">
		<METHODREF>
			<xsl:attribute name="Name">unused</xsl:attribute>
			<xsl:attribute name="MethodName">
				<xsl:value-of select="@ExternalMethodRef"/>
			</xsl:attribute>
		</METHODREF>
	</xsl:if>
</xsl:template>

<!--
	SubSystem
-->
<xsl:template match='Implementation[attribute::*[1] = "com.eu.evidence.rtdruid.data:SubSystem"]'>

  <SUBSYSTEM>
	<xsl:apply-templates select="@Name"/>

	<IMPLEMENTATION>
		<xsl:apply-templates select="Implementation"/>
	</IMPLEMENTATION>

	<PROVIDED_INTERFACE>
		<xsl:apply-templates select="ProvidedInterfaceList"/>
	</PROVIDED_INTERFACE>

	<REQUIRED_INTERFACE>
		<xsl:apply-templates select="RequiredInterfaceList"/>
	</REQUIRED_INTERFACE>

  </SUBSYSTEM>
</xsl:template>

<!--
	TimeConst
-->
<xsl:template match="TimeConstElementList">
    <TIMECONST>
		<xsl:apply-templates select="../@ModeRef"/>
	  
	   <xsl:if test="count(@FirstEvent) >0">
	     <EVENTREF>
		 <xsl:attribute name="Name">
			<xsl:value-of select="@FirstEvent"/>
		 </xsl:attribute>
		 </EVENTREF>
	   </xsl:if>
	   <xsl:if test="count(@SecondEvent) >0">
	     <EVENTREF>
		 <xsl:attribute name="Name">
			<xsl:value-of select="@SecondEvent"/>
		 </xsl:attribute>
		 </EVENTREF>
	   </xsl:if>
	   
	   <xsl:if test="count(@BoundType) >0 or count(@BoundValue) >0">
		 <BOUND>
		   <xsl:if test="count(@BoundType) >0">
			 <xsl:attribute name="Type">
				<xsl:value-of select="@BoundType"/>
			 </xsl:attribute>
		   </xsl:if>
	
		   <xsl:if test="count(@BoundValue) >0">
			 <xsl:attribute name="Value">
				<xsl:value-of select="@BoundValue"/>
			 </xsl:attribute>
		   </xsl:if>
		 </BOUND>
	   </xsl:if>

	</TIMECONST>
</xsl:template>

<!--
	Trigger
-->
<xsl:template match='Implementation[attribute::*[1] = "com.eu.evidence.rtdruid.data:Trigger"]'>

  <TRIGGER>
	<xsl:apply-templates select="@Name"/>

    <xsl:apply-templates select="MethodRefList"/>
	
  </TRIGGER>
</xsl:template>



<!--
	Var
-->
<xsl:template match='Implementation[attribute::*[1] = "com.eu.evidence.rtdruid.data:Var"]'>

  <VAR>
	<xsl:apply-templates select="@Name"/>
	<xsl:apply-templates select="@Type"/>

    <xsl:for-each select="Methods">
		<METHOD>
			<xsl:attribute name="Name">
				<xsl:value-of select="."/>
			</xsl:attribute>
		</METHOD>
	</xsl:for-each>
  </VAR>
</xsl:template>

<!--

		MAPPING

-->
<xsl:template match="Mapping">

  <MAPPING>

    <xsl:apply-templates select="ProcMapList"/>

    <xsl:apply-templates select="TaskMapList"/>

    <xsl:apply-templates select="VarMapList"/>
		
  </MAPPING>
</xsl:template>
			
			
<xsl:template match="ProcMapList">		
   <PROCMAP>
      <xsl:apply-templates select="@ProcRef"/>
	  <xsl:apply-templates select="@TaskRef"/>
	  <xsl:apply-templates select="@ModeRef"/>
	  <xsl:apply-templates select="@OnceEveryK"/>
	  <xsl:apply-templates select="@Order"/>
   </PROCMAP>
</xsl:template>

<xsl:template match="TaskMapList">
  <TASKMAP>
	<xsl:apply-templates select="@ModeRef"/>
	<xsl:apply-templates select="@RtosRef"/>
	<xsl:apply-templates select="@TaskRef"/>
  </TASKMAP>
</xsl:template>

<xsl:template match="VarMapList">
  <VARMAP>
     <xsl:apply-templates select="@ModeRef"/>
     <xsl:apply-templates select="@VarRef"/>
	 <xsl:apply-templates select="@FrameRef"/>
	 <xsl:apply-templates select="@BusRef"/>
	 <xsl:apply-templates select="@MutexRef"/>
  </VARMAP>
</xsl:template>

<!--

		MODES

-->
<xsl:template match="Modes">
  <MODES>
  
     <xsl:for-each select="ModeList">
        <MODE><xsl:apply-templates select="@Name"/></MODE>
     </xsl:for-each>

  </MODES>
</xsl:template>


<!--

		SCHEDULABILITY

-->
<xsl:template match="Schedulability">

  <SCHEDULABILITY>

      <xsl:apply-templates select="SchedulingScenarioList"/>

  </SCHEDULABILITY>
</xsl:template>
			
<xsl:template match="SchedulingScenarioList">

  <SCHEDULINGSCENARIO>
	  <xsl:apply-templates select="@ModeRef"/>

	  <xsl:apply-templates select="Reports"/>

      <xsl:apply-templates select="CpuSchedList"/>

      <xsl:apply-templates select="TaskSchedList"/>

  </SCHEDULINGSCENARIO>
</xsl:template>

			
<xsl:template match="Reports">		
    <REPORT><xsl:value-of select="."/></REPORT>
</xsl:template>

<xsl:template match="CpuSchedList">
  <CPUSCHED>
     <xsl:apply-templates select="@CpuRef"/>
	 <xsl:apply-templates select="@Utilization"/>
	 <xsl:apply-templates select="@SpeedFactor"/>
	 <xsl:apply-templates select="@Boundary"/>
	 <xsl:apply-templates select="@Schedulable"/>
	 <xsl:apply-templates select="@MaxStackSize"/>
  </CPUSCHED>
</xsl:template>

<xsl:template match="TaskSchedList">
  <TASKSCHED>
     <xsl:apply-templates select="@TaskRef"/>
	 <xsl:apply-templates select="@Utilization"/>
	 <xsl:apply-templates select="@CDelta"/>
	 <xsl:apply-templates select="@TDelta"/>
	 <xsl:apply-templates select="@Schedulable"/>
	 <xsl:apply-templates select="@ResponseTime"/>
  </TASKSCHED>
</xsl:template>


<xsl:template match="@ActNumber">      <xsl:attribute name="ActNumber">      <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@ActivationClass"><xsl:attribute name="ActivationClass"><xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@ActivationType"> <xsl:attribute name="ActivationType"> <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@ActivationRate"> <xsl:attribute name="ActivationRate"> <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@Boundary">       <xsl:attribute name="Boundary">       <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@BusRef">         <xsl:attribute name="BusRef">         <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@CDelta">         <xsl:attribute name="CDelta">         <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@CpuRef">         <xsl:attribute name="CpuRef">         <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@Dim">            <xsl:attribute name="Dim">            <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@Deadline">       <xsl:attribute name="Deadline">       <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@FrameRef">       <xsl:attribute name="FrameRef">       <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@Id">             <xsl:attribute name="ID">             <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@Length">         <xsl:attribute name="Length">         <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@MaxStackSize">    <xsl:attribute name="MaxStackSize">    <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@MethodName">     <xsl:attribute name="MethodName">     <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@MethodRefName">  <xsl:attribute name="MethodRefName"> <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@Model">          <xsl:attribute name="Model">          <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@ModeRef">        <xsl:attribute name="ModeRef">        <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@MutexName">      <xsl:attribute name="MutexName">      <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@MutexRef">       <xsl:attribute name="MutexRef">       <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@Name">           <xsl:attribute name="Name">           <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@Offset">         <xsl:attribute name="Offset">         <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@OnceEveryK">     <xsl:attribute name="OnceEveryK">     <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@Order">          <xsl:attribute name="Order">          <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@Period">         <xsl:attribute name="Period">         <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@Policy">         <xsl:attribute name="Policy">         <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@PreemptionGroupName"><xsl:attribute name="PreemptionGroupName"><xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@Priority">       <xsl:attribute name="Priority">       <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@Probability">    <xsl:attribute name="Probability">    <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@ProcRef">        <xsl:attribute name="ProcRef">        <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@Ref">            <xsl:attribute name="Ref">            <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@ResponseTime">   <xsl:attribute name="ResponseTime">   <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@RtosRef">        <xsl:attribute name="rtosRef">        <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@Schedulable">    <xsl:attribute name="Schedulable">    <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@Size">           <xsl:attribute name="Size">           <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@Speed">          <xsl:attribute name="Speed">          <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@SpeedFactor">    <xsl:attribute name="SpeedFactor">    <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@Stack">       <xsl:attribute name="Stack">       <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@TaskRef">        <xsl:attribute name="TaskRef">        <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@TDelta">         <xsl:attribute name="TDelta">         <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@Threshold">      <xsl:attribute name="Threshold">      <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@Type">           <xsl:attribute name="Type">           <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@Utilization">    <xsl:attribute name="Utilization">    <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@Value">          <xsl:attribute name="Value">          <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@VarRef">         <xsl:attribute name="VarRef">         <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>

<xsl:template match="@Avg"><AVG>          <xsl:attribute name="Value">       <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></AVG></xsl:template>
<xsl:template match="@Best"><BEST>        <xsl:attribute name="Value">       <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></BEST></xsl:template>
<xsl:template match="@Variance"><VARIANCE><xsl:attribute name="Value">       <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></VARIANCE></xsl:template>
<xsl:template match="@Worst"><WORST>      <xsl:attribute name="Value">       <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></WORST></xsl:template>

<xsl:template match="@OilVar"><OILVAR>                                       <xsl:value-of select="." disable-output-escaping="no"/>                </OILVAR></xsl:template>

</xsl:stylesheet>
