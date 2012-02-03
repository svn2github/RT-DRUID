#!/bin/sh

set -e

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
	;;

    *)
#
#           Linux/Unix
#    
	;;
esac
exec java -jar "$LAUNCHER_JAR" -data "$3/workspace" -application com.eu.evidence.rtdruid.oil.standalone.templates --templateId "$2" --outputDir "$3"
