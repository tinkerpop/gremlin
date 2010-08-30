#!/bin/bash

# Path to JAR
JAR=`dirname $0`/target/gremlin-*-standalone.jar

# Find Java
if [ "$JAVA_HOME" = "" ] ; then
	JAVA="java -server"
else
	JAVA="$JAVA_HOME/bin/java -server"
fi

# Set Java options
if [ "$JAVA_OPTIONS" = "" ] ; then
	JAVA_OPTIONS="-Xms32M -Xmx512M"
fi

# Launch the application
if [ "$1" = "-e" ]; then
  $JAVA $JAVA_OPTIONS -cp $JAR com.tinkerpop.gremlin.ScriptExecutor $2
else
  if [ "$1" = "-v" ]; then
    echo "Gremlin 0.5"
  else
    $JAVA $JAVA_OPTIONS -cp $JAR com.tinkerpop.gremlin.Console
  fi
fi

# Return the program's exit code
exit $?
