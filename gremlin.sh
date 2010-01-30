#!/bin/bash

# Path to JAR
JAR=`dirname $0`/target/gremlin-*-standalone.jar

# Find Java
if [ "$JAVA_HOME" = "" ] ; then
	JAVA="java"
else
	JAVA="$JAVA_HOME/bin/java"
fi

# Set Java options
if [ "$JAVA_OPTIONS" = "" ] ; then
	JAVA_OPTIONS="-Xms32M -Xmx512M"
fi

# Launch the application
if [ "$1" = "-e" ]
then
  $JAVA $JAVA_OPTIONS -cp $JAR com.tinkerpop.gremlin.ScriptExecutor $2
else 
  $JAVA $JAVA_OPTIONS -cp $JAR com.tinkerpop.gremlin.Console
fi

# Return the program's exit code
exit $?
