#!/bin/sh

if [ -n "$1" -a -d "$1" ]; then
    ECLIPSE_HOME="$1"
    shift
elif [ -z "$ECLIPSE_HOME" ]; then
    echo >&2 "Insufficient parameters"
    echo >&2 "Usage:  start_ant.sh <RT-Druid_dir> [more ant options]"
    exit 2
fi
LAUNCHER_JAR="`find "${ECLIPSE_HOME}/plugins" -iname "org.eclipse.equinox.launcher_*.jar"`"
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
exec java -jar "$LAUNCHER_JAR" -application org.eclipse.ant.core.antRunner "$@" 

