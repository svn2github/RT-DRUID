#!/bin/bash

set -e

if [ $# -lt 3 ]; then
    echo >&2 "Insufficient parameters"
    echo >&2 "Usage: code_generation.sh <RT-Druid_dir> <oil_file> <output_dir>"
    exit 2
fi
LAUNCHER_JAR=`find "$1/plugins" -name "org.eclipse.equinox.launcher_*.jar" | sort | tail -1`

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

# compact multiple inputs
shift
INPUTS=( )
OUTPUT="$1"
shift
while (( "$#" )); do
INPUTS[${#INPUTS[*]}]="$OUTPUT"
OUTPUT="$1"
shift
done
	
exec java -jar "$LAUNCHER_JAR" -data "$OUTPUT/workspace" -application com.eu.evidence.rtdruid.oil.standalone.writer --inputFile "${INPUTS[@]}" --outputDir "$OUTPUT"
