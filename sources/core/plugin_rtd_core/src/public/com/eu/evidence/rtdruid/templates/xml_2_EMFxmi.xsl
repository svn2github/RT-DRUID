<?xml version="1.0" encoding="ISO-8859-1"?>
<!-- Edited with XML Spy v4.2 -->
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
xmlns:xsi=" "
>

<xsl:output method="xml" indent="yes"/>


<xsl:template match="/">

<xsl:for-each select="SYSTEM">

<com.eu.evidence.rtdruid.data:System xmi:version="2.0"
  xmlns:xmi="http://www.omg.org/XMI"
  xmlns:com.eu.evidence.rtdruid.data="http://www.evidence.eu.com/rtdruid/data"
>
  <xsl:apply-templates select="@Name"/>

  <xsl:if test='count(ANNOTATION) > 0'>
    <Annotation>
      <xsl:apply-templates select="ANNOTATION"/>
    </Annotation>
  </xsl:if>

  <xsl:if test='count(ARCHITECTURAL) > 0'>
    <Architectural>
      <xsl:apply-templates select="ARCHITECTURAL"/>
    </Architectural>
  </xsl:if>

  <xsl:if test='count(FUNCTIONAL) > 0'>
    <Functional>
      <xsl:apply-templates select="FUNCTIONAL"/>
    </Functional>
  </xsl:if>

  <xsl:if test='count(MAPPING) > 0'>
    <Mapping>
      <xsl:apply-templates select="MAPPING"/>
    </Mapping>
  </xsl:if>

  <xsl:if test='count(MODES) > 0'>
    <Modes>
      <xsl:apply-templates select="MODES"/>
    </Modes>
  </xsl:if>

  <xsl:if test='count(SCHEDULABILITY) > 0'>
    <Schedulability>
      <xsl:apply-templates select="SCHEDULABILITY"/>
    </Schedulability>
  </xsl:if>
 
</com.eu.evidence.rtdruid.data:System>
</xsl:for-each>
</xsl:template>


<!--

    	ANNOTATION

-->
<xsl:template match="ANNOTATION">
  
    
  <!--
  first : elements without mode
-->
  <xsl:if test='count(CACHE_MISS_COST[count(@ModeRef) = 0]) > 0'>
      <CacheMissCostLists>
	  <xsl:apply-templates select="CACHE_MISS_COST[count(@ModeRef) = 0]"/>
      </CacheMissCostLists>
  </xsl:if>
  
<!--
  then : elements with not null mode
-->
  <xsl:for-each select="CACHE_MISS_COST[count(@ModeRef) != 0]">
	<xsl:variable name="currentValue" select="@ModeRef"/>
	<xsl:if test='count(preceding-sibling::CACHE_MISS_COST[@ModeRef = $currentValue]) = 0'>
	      <CacheMissCostLists>
	  	<xsl:attribute name="ModeRef"><xsl:value-of select="@ModeRef"/></xsl:attribute>

		<xsl:apply-templates select="."/>
		<xsl:apply-templates select="following-sibling::CACHE_MISS_COST[@ModeRef = $currentValue]"/>
	      </CacheMissCostLists>
	</xsl:if>
  </xsl:for-each>
  
  
<!--
  first : elements without mode
-->
  <xsl:if test='count(EXECTIME[count(@ModeRef) = 0]) > 0'>
      <ExecTimeLists>
	  <xsl:apply-templates select="EXECTIME[count(@ModeRef) = 0]"/>
      </ExecTimeLists>
  </xsl:if>
  
<!--
  then : elements with not null mode
-->
  <xsl:for-each select="EXECTIME[count(@ModeRef) != 0]">
	<xsl:variable name="currentValue" select="@ModeRef"/>
	<xsl:if test='count(preceding-sibling::EXECTIME[@ModeRef = $currentValue]) = 0'>
	      <ExecTimeLists>
	  	<xsl:attribute name="ModeRef"><xsl:value-of select="@ModeRef"/></xsl:attribute>

		<xsl:apply-templates select="."/>
		<xsl:apply-templates select="following-sibling::EXECTIME[@ModeRef = $currentValue]"/>
	      </ExecTimeLists>
	</xsl:if>
  </xsl:for-each>
  
</xsl:template>

<xsl:template match="EXECTIME">
  <ExecTimeItemsList>
    <xsl:apply-templates select="@Ref"/>
    <xsl:apply-templates select="@Type"/>
    <xsl:apply-templates select="WORST/@Value"/>
    <xsl:apply-templates select="BEST/@Value"/>

    <xsl:apply-templates select="DISTRIBUTION"/>

  </ExecTimeItemsList>
</xsl:template>  
  
  
  


<xsl:template match="CACHE_MISS_COST">
  <CacheMissCostItemsList>
    <xsl:apply-templates select="@Ref"/>
    <xsl:apply-templates select="@Type"/>
    <xsl:apply-templates select="WORST/@Value"/>
    <xsl:apply-templates select="BEST/@Value"/>

    <xsl:apply-templates select="DISTRIBUTION"/>

  </CacheMissCostItemsList>
</xsl:template>

<xsl:template match="DISTRIBUTION">
    <Distribution>
      <xsl:apply-templates select="AVG/@Value"/>
      <xsl:apply-templates select="@Type"/>
      <xsl:apply-templates select="VARIANCE/@Value"/>

      <xsl:apply-templates select="SAMPLE"/>
    </Distribution>
</xsl:template>

<xsl:template match="SAMPLE">
    <SampleList>
       <xsl:apply-templates select="@Probability"/>
       <xsl:apply-templates select="@Value"/>
	</SampleList>
</xsl:template>

<!-- 

    ARCHITECTURAL

-->
<xsl:template match="ARCHITECTURAL">
  
    <xsl:for-each select="ECU">
      <EcuList>  
	   <xsl:apply-templates select="@Name"/>

		 <xsl:for-each select="CPU">
		 <CpuList>
			<xsl:apply-templates select="@Name"/>
			<xsl:apply-templates select="@Model"/>

			<xsl:if test="count(RTOS) > 0">
			  <Rtos>
				<xsl:apply-templates select="RTOS/@Name"/>
				<xsl:apply-templates select="RTOS/@Type"/>
				<xsl:apply-templates select="RTOS/OILVAR"/>
				
				<xsl:if test="count(RTOS/OSMODEL) > 0">
					 <xsl:for-each select="RTOS/OSMODEL/METHOD/@Name">
						<Methods><xsl:value-of select="."/></Methods>
					</xsl:for-each>
				</xsl:if>
				
			  </Rtos>
			</xsl:if>
		 </CpuList>
		 </xsl:for-each>
    </EcuList>
  </xsl:for-each> <!-- END ECU List-->

    <xsl:apply-templates select="TASK"/><!-- END TASK List-->


  <xsl:for-each select="RESOURCE">
	<ResourceList>
	  <xsl:apply-templates select="@Name"/>
  
	  <xsl:for-each select="METHOD/@Name">
			<Methods><xsl:value-of select="."/></Methods>
	  </xsl:for-each>
	   
	  <xsl:for-each select="MUTEXREF">
	    <MutexRefList>
			 <xsl:apply-templates select="@ModeRef"/>
			 <xsl:apply-templates select="@MutexName"/>
		</MutexRefList>
	  </xsl:for-each>

     </ResourceList>
   </xsl:for-each><!-- END RESOURCE List-->


  <xsl:for-each select="BUS">
	  <BusList>
		 <xsl:apply-templates select="@Name"/>
		 <xsl:apply-templates select="@Type"/>
		 <xsl:apply-templates select="@Speed"/>
	  </BusList>
  </xsl:for-each><!-- END BUS List-->


  <xsl:for-each select="FRAME">
	<FrameList>
	   <xsl:apply-templates select="@Name"/>
	   <xsl:apply-templates select="@ID"/>
	   <xsl:apply-templates select="@ActivationType"/>
	   <xsl:apply-templates select="@ActivationClass"/>
	   <xsl:apply-templates select="@ActivationRate"/>
	   <xsl:apply-templates select="@Length"/>
	</FrameList>
  </xsl:for-each><!-- END FRAME List-->


  <xsl:for-each select="SIGNAL">
	<SignalList>
	   <xsl:apply-templates select="@Name"/>
	   <xsl:apply-templates select="@Type"/>
	   <xsl:apply-templates select="OILVAR"/>
	</SignalList>
  </xsl:for-each><!-- END SIGNAL List-->


  <xsl:for-each select="MUTEX">
	<MutexList>
	   <xsl:apply-templates select="@Name"/>
	   <xsl:apply-templates select="@Policy"/>
	   <xsl:apply-templates select="OILVAR"/>
	</MutexList>
  </xsl:for-each><!-- END MUTEX List-->

</xsl:template>

<!-- 
	TASK
-->
<xsl:template match="TASK">

 <TaskList>
   <xsl:apply-templates select="@Name"/>
   <xsl:apply-templates select="@Type"/>
   <xsl:apply-templates select="OILVAR"/>
   
   
   <xsl:apply-templates select="ACTIVATION"/>

   <xsl:apply-templates select="RESOURCEREF"/>

   <xsl:apply-templates select="SCHEDULING"/>
   
 </TaskList>
</xsl:template>
			
			
<xsl:template match="ACTIVATION">
  <ActivationList>
    <xsl:apply-templates select="@ActNumber"/>
	<xsl:apply-templates select="@Class"/>
    <xsl:apply-templates select="@Deadline"/>
    <xsl:apply-templates select="@ModeRef"/>
    <xsl:apply-templates select="@Offset"/>
    <xsl:apply-templates select="@Period"/>
    <xsl:apply-templates select="@Type"/>
  </ActivationList>
</xsl:template>

<xsl:template match="SCHEDULING">
  <SchedulingList>
    <xsl:apply-templates select="@ModeRef"/>
    <xsl:apply-templates select="@PreemptionGroupName"/>
	<xsl:apply-templates select="@Priority"/>
	<xsl:apply-templates select="@Threshold"/>
	<xsl:apply-templates select="@Stack"/>
  </SchedulingList>
</xsl:template>
      
<xsl:template match="RESOURCEREF">
  <ResourceRefList>
    <xsl:apply-templates select="@ModeRef"/>
			
    <xsl:for-each select="METHODREF">
       <ResourceMethodRef>
	      <xsl:value-of select="@MethodName"/>
	   </ResourceMethodRef>
    </xsl:for-each>
  </ResourceRefList>
</xsl:template>


<!--

		FUNCTIONAL

-->
<xsl:template match="FUNCTIONAL">
  
  <xsl:for-each select="EVENT">
    <EventList>
	  <xsl:apply-templates select="@Name"/>
	  <xsl:apply-templates select="@Type"/>
	  <xsl:apply-templates select="@MethodRefName"/>
	</EventList>
  </xsl:for-each>

  <xsl:for-each select="PARTIALORDER">
    <PartialOrderList>
	  <xsl:apply-templates select="@ModeRef"/>
	  
      <xsl:for-each select="ORDER">
         <OrderList>
	       <xsl:if test="count(EVENTREF) >0">
		     <xsl:attribute name="FirstEvent">
			    <xsl:value-of select="EVENTREF[position()=1]/@Name"/>
			 </xsl:attribute>
		   </xsl:if>
	       <xsl:if test="count(EVENTREF) >1">
		     <xsl:attribute name="SecondEvent">
			    <xsl:value-of select="EVENTREF[position()=2]/@Name"/>
			 </xsl:attribute>
		   </xsl:if>
		</OrderList>
	  </xsl:for-each>
    </PartialOrderList>
  </xsl:for-each>

  
  <xsl:apply-templates select="PROC"/>
  <xsl:apply-templates select="VAR"/>
  <xsl:apply-templates select="TRIGGER"/>
  <xsl:apply-templates select="SUBSYSTEM"/>
  
  <xsl:apply-templates select="TYPE"/>
  

	<!-- TIMECONST:
	  first : elements without mode
	-->
  <xsl:if test='count(TIMECONST[count(@ModeRef) = 0]) > 0'>
      <TimeConstList>
	  <xsl:apply-templates select="TIMECONST[count(@ModeRef) = 0]"/>
      </TimeConstList>
  </xsl:if>
  
	<!-- TIMECONST:
	  then : elements with not null mode
	-->
  <xsl:for-each select="TIMECONST[count(@ModeRef) != 0]">
	<xsl:variable name="currentValue" select="@ModeRef"/>
	<xsl:if test='count(preceding-sibling::TIMECONST[@ModeRef = $currentValue]) = 0'>
	      <TimeConstList>
	  	<xsl:attribute name="ModeRef"><xsl:value-of select="@ModeRef"/></xsl:attribute>

		<xsl:apply-templates select="."/>
		<xsl:apply-templates select="following-sibling::TIMECONST[@ModeRef = $currentValue]"/>
	      </TimeConstList>
	</xsl:if>
  </xsl:for-each>

</xsl:template>


<!--
	MethodRef
-->
<xsl:template match="METHODREF">
	<MethodRefList>
		<xsl:apply-templates select="@Name"/>
		<xsl:apply-templates select="@MethodName"/>
	</MethodRefList>
</xsl:template>

<!--
	Proc
-->
<xsl:template match="PROC">

  <Implementation>
    <xsl:attribute name="xsi:type">com.eu.evidence.rtdruid.data:Proc</xsl:attribute>
	<xsl:apply-templates select="@Name"/>

    <xsl:for-each select="METHOD/@Name">
		<Methods><xsl:value-of select="."/></Methods>
	</xsl:for-each>
	
    <xsl:apply-templates select="METHODREF"/>
	
  </Implementation>
</xsl:template>

<!--
	Provided_interface
-->
<xsl:template match="PROVIDED_INTERFACE">

	<!--
		check only Methods, because each method checks if its next sibling is a Exported_method
	-->
    <xsl:for-each select="METHOD">
		<ProvidedInterfaceList>
			<xsl:apply-templates select="@Name"/>
			
			<!-- check the next sibling -->
			<xsl:if test=" count(following-sibling::EXPORTED_METHOD)>0  and  following-sibling::EXPORTED_METHOD[position()=1] = following-sibling::*[position()=1]">
				<xsl:attribute name="LocalMethodRef">
					<xsl:value-of select="following-sibling::EXPORTED_METHOD[position()=1]/@MethodRef"/>
				</xsl:attribute>
				<xsl:attribute name="LocalObjectRef">
					<xsl:value-of select="following-sibling::EXPORTED_METHOD[position()=1]/@ObjRef"/>
				</xsl:attribute>
			</xsl:if>
			
		</ProvidedInterfaceList>
	</xsl:for-each>
</xsl:template>

<!--
	Requided_interface
-->
<xsl:template match="REQUIRED_INTERFACE">

	<!--
		check only Methods, because each method checks if its next sibling is a MethodRef
	-->
    <xsl:for-each select="METHOD">
		<RequiredInterfaceList>
			<xsl:apply-templates select="@Name"/>
			
			<!-- check the next sibling -->
			<xsl:if test=" count(following-sibling::METHODREF)>0  and  following-sibling::METHODREF[position()=1] = following-sibling::*[position()=1]">
				<xsl:attribute name="ExternalMethodRef">
					<xsl:value-of select="following-sibling::METHODREF[position()=1]/@MethodName"/>
				</xsl:attribute>
			</xsl:if>
			
		</RequiredInterfaceList>
	</xsl:for-each>
</xsl:template>

<!--
	SubSystem
-->
<xsl:template match="SUBSYSTEM">

  <Implementation>
    <xsl:attribute name="xsi:type">com.eu.evidence.rtdruid.data:SubSystem</xsl:attribute>
	<xsl:apply-templates select="@Name"/>

    <xsl:apply-templates select="IMPLEMENTATION/PROC"/>
	<xsl:apply-templates select="IMPLEMENTATION/VAR"/>
    <xsl:apply-templates select="IMPLEMENTATION/SUBSYSTEM"/>
	
    <xsl:apply-templates select="PROVIDED_INTERFACE"/>
    <xsl:apply-templates select="REQUIRED_INTERFACE"/>

  </Implementation>
</xsl:template>

<!--
	TimeConst
-->
<xsl:template match="TIMECONST">
    <TimeConstElementList>
	  
	   <xsl:if test="count(EVENTREF) >0">
		 <xsl:attribute name="FirstEvent">
			<xsl:value-of select="EVENTREF[position()=1]/@Name"/>
		 </xsl:attribute>
	   </xsl:if>
	   <xsl:if test="count(EVENTREF) >1">
		 <xsl:attribute name="SecondEvent">
			<xsl:value-of select="EVENTREF[position()=2]/@Name"/>
		 </xsl:attribute>
	   </xsl:if>
	   
	   <xsl:if test="count(BOUND/@Type) >0">
		 <xsl:attribute name="BoundType">
			<xsl:value-of select="BOUND/@Type"/>
		 </xsl:attribute>
	   </xsl:if>

	   <xsl:if test="count(BOUND/@Value) >0">
		 <xsl:attribute name="BoundValue">
			<xsl:value-of select="BOUND/@Value"/>
		 </xsl:attribute>
	   </xsl:if>

	</TimeConstElementList>
</xsl:template>

<!--
	Trigger
-->
<xsl:template match="TRIGGER">

  <Implementation>
    <xsl:attribute name="xsi:type">com.eu.evidence.rtdruid.data:Trigger</xsl:attribute>
	<xsl:apply-templates select="@Name"/>

    <xsl:apply-templates select="METHODREF"/>
	
  </Implementation>
</xsl:template>


<!--
	Type
-->
<xsl:template match="TYPE">

  <TypeList>
	<xsl:apply-templates select="@Name"/>
	<xsl:apply-templates select="@Dim"/>
	
    <xsl:apply-templates select="FIELD"/>
	
  </TypeList>
</xsl:template>


<!--
	Field
-->
<xsl:template match="FIELD">
	<Field>
		<xsl:apply-templates select="@Name"/>
		<xsl:apply-templates select="@Type"/>
		<xsl:apply-templates select="@Size"/>
	</Field>
</xsl:template>


<!--
	Var
-->
<xsl:template match="VAR">

  <Implementation>
    <xsl:attribute name="xsi:type">com.eu.evidence.rtdruid.data:Var</xsl:attribute>
	<xsl:apply-templates select="@Name"/>
	<xsl:apply-templates select="@Type"/>

    <xsl:for-each select="METHOD/@Name">
		<Methods><xsl:value-of select="."/></Methods>
	</xsl:for-each>
  </Implementation>
</xsl:template>

<!--

		MAPPING

-->
<xsl:template match="MAPPING">

    <xsl:apply-templates select="PROCMAP"/>

    <xsl:apply-templates select="TASKMAP"/>

    <xsl:apply-templates select="VARMAP"/>
		
</xsl:template>
			
			
<xsl:template match="PROCMAP">		
   <ProcMapList>
      <xsl:apply-templates select="@ProcRef"/>
	  <xsl:apply-templates select="@TaskRef"/>
	  <xsl:apply-templates select="@ModeRef"/>
	  <xsl:apply-templates select="@OnceEveryK"/>
	  <xsl:apply-templates select="@Order"/>
   </ProcMapList>
</xsl:template>

<xsl:template match="TASKMAP">
  <TaskMapList>
	<xsl:apply-templates select="@ModeRef"/>
	<xsl:apply-templates select="@rtosRef"/>
	<xsl:apply-templates select="@TaskRef"/>
  </TaskMapList>
</xsl:template>

<xsl:template match="VARMAP">
  <VarMapList>
     <xsl:apply-templates select="@ModeRef"/>
     <xsl:apply-templates select="@VarRef"/>
	 <xsl:apply-templates select="@FrameRef"/>
	 <xsl:apply-templates select="@BusRef"/>
	 <xsl:apply-templates select="@MutexRef"/>
  </VarMapList>
</xsl:template>

<!--

		MODES

-->
<xsl:template match="MODES">
  
     <xsl:for-each select="MODE">
        <ModeList><xsl:apply-templates select="@Name"/></ModeList>
     </xsl:for-each>

</xsl:template>


<!--

		SCHEDULABILITY

-->
<xsl:template match="SCHEDULABILITY">

      <xsl:apply-templates select="SCHEDULINGSCENARIO"/>

</xsl:template>
			
<xsl:template match="SCHEDULINGSCENARIO">

  <SchedulingScenarioList>
	  <xsl:apply-templates select="@ModeRef"/>

	  <xsl:apply-templates select="REPORT"/>

      <xsl:apply-templates select="CPUSCHED"/>

      <xsl:apply-templates select="TASKSCHED"/>

  </SchedulingScenarioList>
</xsl:template>

			
<xsl:template match="REPORT">		
    <Reports><xsl:value-of select="."/></Reports>
</xsl:template>

<xsl:template match="CPUSCHED">
  <CpuSchedList>
     <xsl:apply-templates select="@CpuRef"/>
	 <xsl:apply-templates select="@Utilization"/>
	 <xsl:apply-templates select="@SpeedFactor"/>
	 <xsl:apply-templates select="@Boundary"/>
	 <xsl:apply-templates select="@Schedulable"/>
	 <xsl:apply-templates select="@MaxStackSize"/>	 
  </CpuSchedList>
</xsl:template>

<xsl:template match="TASKSCHED">
  <TaskSchedList>
     <xsl:apply-templates select="@TaskRef"/>
	 <xsl:apply-templates select="@Utilization"/>
	 <xsl:apply-templates select="@CDelta"/>
	 <xsl:apply-templates select="@TDelta"/>
	 <xsl:apply-templates select="@Schedulable"/>
	 <xsl:apply-templates select="@ResponseTime"/>
  </TaskSchedList>
</xsl:template>


<xsl:template match="@ActNumber">      <xsl:attribute name="ActNumber">      <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@ActivationClass"><xsl:attribute name="ActivationClass"><xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@ActivationType"> <xsl:attribute name="ActivationType"> <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@ActivationRate"> <xsl:attribute name="ActivationRate"> <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@Boundary">       <xsl:attribute name="Boundary">       <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@BusRef">         <xsl:attribute name="BusRef">         <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@Class">          <xsl:attribute name="ActivationClass"><xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@CDelta">         <xsl:attribute name="CDelta">         <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@CpuRef">         <xsl:attribute name="CpuRef">         <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@Deadline">       <xsl:attribute name="Deadline">       <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@Dim">            <xsl:attribute name="Dim">            <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@FrameRef">       <xsl:attribute name="FrameRef">       <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@ID">             <xsl:attribute name="Id">             <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
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
<xsl:template match="@rtosRef">        <xsl:attribute name="RtosRef">        <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@Schedulable">    <xsl:attribute name="Schedulable">    <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@Size">           <xsl:attribute name="Size">           <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@Speed">          <xsl:attribute name="Speed">          <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@SpeedFactor">    <xsl:attribute name="SpeedFactor">    <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@Stack">          <xsl:attribute name="Stack">          <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@TaskRef">        <xsl:attribute name="TaskRef">        <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@TDelta">         <xsl:attribute name="TDelta">         <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@Threshold">      <xsl:attribute name="Threshold">      <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@Type">           <xsl:attribute name="Type">           <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@Utilization">    <xsl:attribute name="Utilization">    <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@Value">          <xsl:attribute name="Value">          <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="@VarRef">         <xsl:attribute name="VarRef">         <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>

<xsl:template match="AVG/@Value">      <xsl:attribute name="Avg">            <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="BEST/@Value">     <xsl:attribute name="Best">           <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="VARIANCE/@Value"> <xsl:attribute name="Variance">       <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>
<xsl:template match="WORST/@Value">    <xsl:attribute name="Worst">          <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>

<xsl:template match="OILVAR">          <xsl:attribute name="OilVar">         <xsl:value-of select="." disable-output-escaping="no"/></xsl:attribute></xsl:template>

</xsl:stylesheet>
