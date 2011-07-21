#!/bin/sh -v

set -e

# Run it using something like 
# sh start_ant.sh
# sh start_ant.sh -buildfile build_file.xml 
# sh start_ant.sh -buildfile build_file.xml  target
# sh start_ant.sh -buildfile build_file.xml  -DANT_VAR=value target


#
#           Set parameters
#

if (test "XXX$ECLIPSE_HOME" = XXX) then
        echo >&2 "export ECLIPSE_HOME=/path/to/eclipse before starting this script"
        exit 1
fi

# Eclipse 3.3 and 3.4
LAUNCHER_JAR="`find "$ECLIPSE_HOME/plugins" -iname "org.eclipse.equinox.launcher_*.jar"`"
if (test "$LAUNCHER_JAR" = "") then
    # Eclipse 3.2 or earlier
    if (test -r "$ECLIPSE_HOME/startup.jar") then
	LAUNCHER_CLASS=org.eclipse.core.launcher.Main
	LAUNCHER_JAR="$ECLIPSE_HOME/startup.jar"
    else
	echo >&2 "Cannot find launcher plugin"
	exit 1
    fi
else
    LAUNCHER_CLASS=
fi


case "`uname -s`" in
    *CYGWIN*)
#
#           CYGWIN
#
	LAUNCHER_JAR="`cygpath -w "$LAUNCHER_JAR"`"
	export CLASSPATH="$CLASSPATH;$LAUNCHER_JAR"
        # Debug message
        #echo "classpath (cygwin)= $CLASSPATH"
#  example of how set the eclipse home
#  export ECLIPSE_HOME="C:\\Programmi\\eclipse3.4"
	;;

    *)
#
#           Linux/Unix
#    
	export CLASSPATH="$CLASSPATH:$LAUNCHER_JAR"
        # Debug message
	#echo "classpath (linux)= $CLASSPATH"
#  example of how set the eclipse home
#  export ECLIPSE_HOME="/home/abc/programs/eclipse3.4"
	;;
esac


#
#           COMMON SECTION
#

if (test "$LAUNCHER_CLASS" != "") then
# Valid only for Eclipse 3.0 3.1 3.2 ( < 3.3)
    #echo java org.eclipse.core.launcher.Main -application org.eclipse.ant.core.antRunner "$@"
    java org.eclipse.core.launcher.Main -application org.eclipse.ant.core.antRunner "$@"

else

# Valid for Eclipse 3.3 3.4
    #echo java -jar "$LAUNCHER_JAR" -application org.eclipse.ant.core.antRunner \
#    	-Dbuild_numer=`date +"%Y%m%d_%H%M"` "$@"
    java -jar "$LAUNCHER_JAR" -application org.eclipse.ant.core.antRunner \
	-Dbuild_numer=`date +"%Y%m%d_%H%M"` "$@"
fi

# example of how set an ant variable 
#java -jar "$ECLIPSE_HOME/plugins/$LAUNCHER_JAR" -application org.eclipse.ant.core.antRunner  -Dbuild_numer=`date +"%Y%m%d_%H%M"` $@
