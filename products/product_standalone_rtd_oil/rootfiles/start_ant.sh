#!/bin/sh

set -e

if [ -n "$1" -a -d "$1" ]; then
    ECLIPSE_HOME="$1"
    shift
elif [ -z "$ECLIPSE_HOME" ]; then
    echo >&2 "Insufficient parameters"
    echo >&2 "Usage:  start_ant.sh <RT-Druid_dir> [more ant options]"
    exit 2
fi
LAUNCHER_JAR=`find "${ECLIPSE_HOME}/plugins" -name "org.eclipse.equinox.launcher_*.jar" | sort | tail -1`

case "`uname -s`" in
    *CYGWIN*)
#
#           CYGWIN
#
	LAUNCHER_JAR="`cygpath -w "$LAUNCHER_JAR"`"
	;;

    *)
#
#           Linux/Unix
#    
	;;
esac

WSOPT=""
WSOPT_set=""
for a in "$@"; do
    if [ "$a" = "-data" ]; then
        WSOPT_set="true"
    fi

    if [ "${a#-Dconf_output_dir=}" != "$a" ]; then
        WSOPT="-data ${a#-Dconf_output_dir=}/workspace"
    fi
done

if [ "$WSOPT_set" = "true" ]; then
        WSOPT=""
fi

exec java -jar "$LAUNCHER_JAR" $WSOPT -application org.eclipse.ant.core.antRunner "$@"


