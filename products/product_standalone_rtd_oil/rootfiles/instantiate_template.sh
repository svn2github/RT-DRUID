#!/bin/sh

if [ $# -lt 3 ]; then
    echo >&2 "Insufficient parameters"
    echo >&2 "Usage:  templates.sh <RT-Druid_dir> <template_id> <output_dir>"
    exit 2
fi

LAUNCHER_JAR="`find "$1/plugins" -iname "org.eclipse.equinox.launcher_*.jar"`"
case "`uname -s`" in
    *CYGWIN*)
#
#           CYGWIN
#
	LAUNCHER_JAR="`cygpath -w "$LAUNCHER_JAR"`"
#	export CLASSPATH="$CLASSPATH;$LAUNCHER_JAR"
        # Debug message
        #echo "classpath (cygwin)= $CLASSPATH"
#  example of how set the eclipse home
#  export ECLIPSE_HOME="C:\\Programmi\\eclipse3.4"
	;;

    *)
#
#           Linux/Unix
#    
#	export CLASSPATH="$CLASSPATH:$LAUNCHER_JAR"
        # Debug message
	#echo "classpath (linux)= $CLASSPATH"
#  example of how set the eclipse home
#  export ECLIPSE_HOME="/home/abc/programs/eclipse3.4"
	;;
esac
exec java -jar "$LAUNCHER_JAR" -application com.eu.evidence.rtdruid.oil.standalone.templates --templateId "$2" --outputDir "$3"
