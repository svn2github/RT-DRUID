#!/bin/sh 

set -e

# Run it using something like 
# sh start_ant.sh
# sh start_ant.sh -buildfile build_file.xml 
# sh start_ant.sh -buildfile build_file.xml  target
# sh start_ant.sh -buildfile build_file.xml  -DANT_VAR=value target

# Try to get RT-Druid and Erika svn versions

RTD_SVN_SET=""
EE_SVN_SET=""
EE_SVN_PATH=""

SVN_NUMBERS=""
for a in "$@"; do
    if [ "${a#-Drtd.svn.number=}" != "$a" ]; then
        RTD_SVN_SET="true";
    fi
    if [ "${a#-Dee.svn.number=}" != "$a" ]; then
        EE_SVN_SET="true";
    fi
    if [ "${a#-Dee.base.location=}" != "$a" ]; then
        EE_SVN_PATH="DESTINATION=\"${a#-Dee.base.location=}\" ";
    fi
done



if [ "_$RTD_SVN_VERSION" == "_" -a "_$RTD_SVN_SET" = "_" ]; then
	RTD_SVN_VERSION=`bash getSvnNumber.sh`
	
	if [ "_$RTD_SVN_VERSION" == "_" ]; then
		echo >&2 "Cannot find the RT-Druid SVN version number."
	exit 12
	fi
fi

if [ "_$RTD_SVN_SET" = "_" ]; then
	SVN_NUMBERS="${SVN_NUMBERS} -Drtd.svn.number=$RTD_SVN_VERSION"
fi

if [ "_$EE_SVN_VERSION" == "_" -a "_$EE_SVN_SET" = "_" ]; then
	EE_SVN_VERSION=`bash -c "${EE_SVN_PATH} bash getSvnNumber.sh"`
	
	if [ "_$EE_SVN_VERSION" == "_" ]; then
		echo >&2 "Cannot find the Erika Enterprise SVN version number."
		exit 13
	fi
fi

if [ "_$EE_SVN_SET" = "_" ]; then
	SVN_NUMBERS="${SVN_NUMBERS} -Dee.svn.number=$EE_SVN_VERSION"
fi

if [ "_$RTD_BUILD_ID" = "_" ]; then
	SVN_NUMBERS="${SVN_NUMBERS} -Drtd.build.number=$RTD_BUILD_ID"
fi

# run ant
sh ../product_standalone_rtd_oil/rootfiles/start_ant.sh "$@" ${SVN_NUMBERS}
