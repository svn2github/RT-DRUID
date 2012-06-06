#! /bin/bash

PLUGIN_NAME=test1_tests
PLUGIN_VERSION=1.0.0.201202071317
PLUGIN_TEST_CLASS=test1.Test1Test

ECLIPSE_HOME=$PWD
ECLIPSE_TEST_VERSION=3.3.100
ECLIPSE_LAUNCHER_VERSION=1.2.0.v20110502

java \
 -jar "$ECLIPSE_HOME"/plugins/org.eclipse.equinox.launcher_"$ECLIPSE_LAUNCHER_VERSION".jar\
 -application org.eclipse.ant.core.antRunner\
 -buildfile "$ECLIPSE_HOME"/plugins/"$PLUGIN_NAME"_"$PLUGIN_VERSION"/test.xml\
 -Declipse-home=$ECLIPSE_HOME\
 -Dos=linux\
 -Dws=gtk\
 -Darch=x86\
 -Dorg.eclipse.test="$ECLIPSE_TEST_VERSION"\
 -Dplugin-name="$PLUGIN_NAME"\
 -Dclass-tests="$PLUGIN_TEST_CLASS"

