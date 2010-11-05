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
  k=$2
  if [ $# > 2 ]; then
    for (( i=3 ; i < $# + 1 ; i++ ))
    do
      eval a=\$$i
      k="$k \"$a\""
    done
  fi

  eval "$JAVA $JAVA_OPTIONS -cp $JAR com.tinkerpop.gremlin.ScriptExecutor $k"
else
  if [ "$1" = "-v" ]; then
    echo "Gremlin 0.6"
  else
    $JAVA $JAVA_OPTIONS -cp $JAR com.tinkerpop.gremlin.Console
  fi
fi

# Return the program's exit code
exit $?
