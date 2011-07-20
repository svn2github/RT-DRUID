#$Id$

#############################################################
#
# COMPLETE STANDALONE BUILDS
#
#############################################################


#
# External vars
#

# TEMP_DIR : where unzip and collect files
ifndef TEMP_DIR
	TEMP_DIR:= temp_dir
endif

# RTD_SCRIPT_BASE : where RT-Druid script are located
ifndef RTD_SCRIPT_BASE
	RTD_SCRIPT_BASE:= rootfiles
endif



# BUILDER_PATH : eclipse (builder - SDK) directory
ifndef BUILDER_PATH
	BUILDER_PATH:= __ERROR___missing_eclipse_sdk_path__
endif
# BUILDER_JAR : eclipse (builder - SDK) org.eclipse.equinox.launcher_xxxx.jar
ifndef BUILDER_JAR
	BUILDER_JAR:= __ERROR___missing_eclipse_sdk_JAR_name__
endif

# ABS_OUTPUT_SITE : RT-Druid site absolute path
ifndef ABS_OUTPUT_SITE
	ABS_OUTPUT_SITE:= __ERROR___missing_rtdruid_site_absolutepath__
endif

# DISTR_INPUT_PATH : where RT-Druid distributions are located
ifndef DISTR_INPUT_PATH
	DISTR_INPUT_PATH:=  __ERROR___missing_rtdruid_distributions_input_path__
endif
 
# DISTR_OUTPUT_PATH : where RT-Druid complete distributions will be stored
ifndef DISTR_OUTPUT_PATH
	DISTR_OUTPUT_PATH:=  __ERROR___missing_rtdruid_distributions_output_path__
endif




#
# Internal vars
#

DISTR_DIR_NAME := RT-Druid


ANT_iZIP_FILES :=  $(shell ls ${DISTR_INPUT_PATH}/*ant*.zip)
FULL_iZIP_FILES:= $(shell ls ${DISTR_INPUT_PATH}/*full*.zip)
MINI_iZIP_FILES:= $(shell ls ${DISTR_INPUT_PATH}/*mini*.zip)

ANT_oZIP_FILES :=$(patsubst ${DISTR_INPUT_PATH}/%,${DISTR_OUTPUT_PATH}/%, $(ANT_iZIP_FILES))
FULL_oZIP_FILES:=$(patsubst ${DISTR_INPUT_PATH}/%,${DISTR_OUTPUT_PATH}/%, $(FULL_iZIP_FILES))
MINI_oZIP_FILES:=$(patsubst ${DISTR_INPUT_PATH}/%,${DISTR_OUTPUT_PATH}/%, $(MINI_iZIP_FILES))


ANT_TEMP_DIR  :=${TEMP_DIR}/ending/ant
FULL_TEMP_DIR :=${TEMP_DIR}/ending/full
MINI_TEMP_DIR :=${TEMP_DIR}/ending/mini




FULL_LINUX_SCRIPTS := ${RTD_SCRIPT_BASE}/instantiate_template.sh ${RTD_SCRIPT_BASE}/generate_code.sh 
FULL_WIN_SCRIPTS := ${RTD_SCRIPT_BASE}/instantiate_template.bat ${RTD_SCRIPT_BASE}/generate_code.bat ${FULL_LINUX_SCRIPTS} 

MINI_LINUX_SCRIPTS := ${FULL_LINUX_SCRIPTS} 
MINI_WIN_SCRIPTS := ${FULL_WIN_SCRIPTS} 

ANT_LINUX_SCRIPTS := ${RTD_SCRIPT_BASE}/start_ant.sh ${RTD_SCRIPT_BASE}/build.xml ${FULL_LINUX_SCRIPTS}
ANT_WIN_SCRIPTS := ${RTD_SCRIPT_BASE}/start_ant.bat ${ANT_LINUX_SCRIPTS} ${FULL_WIN_SCRIPTS}


ANT_IU ?= com.eu.evidence.ee,com.eu.evidence.ee.templates.avr,com.eu.evidence.ee.templates.ppc,com.eu.evidence.ee.templates.dspic,com.eu.evidence.ee.templates.s12,com.eu.evidence.ee.templates.tricore
FULL_IU ?= com.eu.evidence.ee,com.eu.evidence.ee.templates.avr,com.eu.evidence.ee.templates.ppc,com.eu.evidence.ee.templates.dspic,com.eu.evidence.ee.templates.s12,com.eu.evidence.ee.templates.tricore


.PHONY: complete_rtdruid_light
complete_rtdruid_light: ${ANT_oZIP_FILES} ${FULL_oZIP_FILES} ${MINI_oZIP_FILES}


${ANT_oZIP_FILES} :
	@echo $@
	rm -rf ${ANT_TEMP_DIR}
	mkdir -p ${ANT_TEMP_DIR}
	unzip -oq ${DISTR_INPUT_PATH}/$(@F) -d ${ANT_TEMP_DIR} 
	java -jar ${BUILDER_PATH}/plugins/${BUILDER_JAR} \
		-application org.eclipse.equinox.p2.director \
		-repository file:///${ABS_OUTPUT_SITE} \
		-destination ${ANT_TEMP_DIR}/${DISTR_DIR_NAME} \
		-installIU ${ANT_IU}
	mkdir ${ANT_TEMP_DIR}/${DISTR_DIR_NAME}/evidence
	case $(@F) in \
		*linux*) \
			rm ${ANT_TEMP_DIR}/${DISTR_DIR_NAME}/eclipse ${ANT_TEMP_DIR}/${DISTR_DIR_NAME}/eclipse.ini ; \
			cp ${ANT_LINUX_SCRIPTS} ${ANT_TEMP_DIR}/${DISTR_DIR_NAME}/evidence/;; \
		*win*) \
			rm ${ANT_TEMP_DIR}/${DISTR_DIR_NAME}/eclipse.exe ${ANT_TEMP_DIR}/${DISTR_DIR_NAME}/eclipse.ini ; \
			cp ${ANT_WIN_SCRIPTS} ${ANT_TEMP_DIR}/${DISTR_DIR_NAME}/evidence/;; \
		*) \
			echo "unknown type for $(@F)" ; exit 1 ;; \
	esac
	cd ${ANT_TEMP_DIR} ; rm output_file.zip; zip -r output_file.zip ${DISTR_DIR_NAME}
	mkdir -p $(@D)
	mv ${ANT_TEMP_DIR}/output_file.zip $@
	
${FULL_oZIP_FILES} :
	@echo $@
	rm -rf ${FULL_TEMP_DIR}
	mkdir -p ${FULL_TEMP_DIR}
	unzip -oq ${DISTR_INPUT_PATH}/$(@F) -d ${FULL_TEMP_DIR} 
	java -jar ${BUILDER_PATH}/plugins/${BUILDER_JAR} \
		-application org.eclipse.equinox.p2.director \
		-repository file:///${ABS_OUTPUT_SITE} \
		-destination ${FULL_TEMP_DIR}/${DISTR_DIR_NAME} \
		-installIU ${FULL_IU}
	mkdir ${FULL_TEMP_DIR}/${DISTR_DIR_NAME}/evidence
	case $(@F) in \
		*linux*) \
			rm ${FULL_TEMP_DIR}/${DISTR_DIR_NAME}/eclipse ${FULL_TEMP_DIR}/${DISTR_DIR_NAME}/eclipse.ini ; \
			cp ${FULL_LINUX_SCRIPTS} ${FULL_TEMP_DIR}/${DISTR_DIR_NAME}/evidence/;; \
		*win*) \
			rm ${FULL_TEMP_DIR}/${DISTR_DIR_NAME}/eclipse.exe ${FULL_TEMP_DIR}/${DISTR_DIR_NAME}/eclipse.ini ; \
			cp ${FULL_WIN_SCRIPTS} ${FULL_TEMP_DIR}/${DISTR_DIR_NAME}/evidence/;; \
		*) \
			echo "unknown type for $(@F)" ; exit 1 ;; \
	esac
	cd ${FULL_TEMP_DIR} ; rm output_file.zip; zip -r output_file.zip ${DISTR_DIR_NAME}
	mkdir -p $(@D)
	mv ${FULL_TEMP_DIR}/output_file.zip $@
	
${MINI_oZIP_FILES} :
	@echo $@
	rm -rf ${MINI_TEMP_DIR}
	mkdir -p ${MINI_TEMP_DIR}
	unzip -oq ${DISTR_INPUT_PATH}/$(@F) -d ${MINI_TEMP_DIR} 
	mkdir ${MINI_TEMP_DIR}/${DISTR_DIR_NAME}/evidence
	case $(@F) in \
		*linux*) \
			rm ${MINI_TEMP_DIR}/${DISTR_DIR_NAME}/eclipse ${MINI_TEMP_DIR}/${DISTR_DIR_NAME}/eclipse.ini ; \
			cp ${MINI_LINUX_SCRIPTS} ${MINI_TEMP_DIR}/${DISTR_DIR_NAME}/evidence/;; \
		*win*) \
			rm ${MINI_TEMP_DIR}/${DISTR_DIR_NAME}/eclipse.exe ${MINI_TEMP_DIR}/${DISTR_DIR_NAME}/eclipse.ini ; \
			cp ${MINI_WIN_SCRIPTS} ${MINI_TEMP_DIR}/${DISTR_DIR_NAME}/evidence/;; \
		*) \
			echo "unknown type for $(@F)" ; exit 1 ;; \
	esac
	cd ${MINI_TEMP_DIR} ; rm output_file.zip; zip -r output_file.zip ${DISTR_DIR_NAME}
	mkdir -p $(@D)
	mv ${MINI_TEMP_DIR}/output_file.zip $@

