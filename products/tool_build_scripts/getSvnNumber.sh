#!/bin/bash

set -e

if [ "_$DESTINATION" != "_" ]; then
	cd "$DESTINATION"
fi


SVNVERSION=`svnversion 2>/dev/null`
if [ "X$SVNVERSION" == "Xexported" -o "X$SVNVERSION" == "X" ]; then
	git svn find-rev `git log -1 --pretty=format:%H 2>/dev/null` 2>/dev/null
else
	echo $SVNVERSION
fi
