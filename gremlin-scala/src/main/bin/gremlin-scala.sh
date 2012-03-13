#!/bin/bash

CP=$( echo `dirname $0`/../lib/*.jar . | sed 's/ /:/g')
#echo $CP

# Find Java
if [ "$JAVA_HOME" = "" ] ; then
    JAVA="java -server"
else
    JAVA="$JAVA_HOME/bin/java -server"
fi

# Set Java options
if [ "$JAVA_OPTIONS" = "" ] ; then
    JAVA_OPTIONS="-Xms32m -Xmx512m"
fi

# Launch the application
if [ "$1" = "-v" ]; then
  $JAVA $JAVA_OPTIONS -cp $CP:$CLASSPATH com.tinkerpop.gremlin.Version
else
  $JAVA $JAVA_OPTIONS -cp $CP:$CLASSPATH com.tinkerpop.gremlin.scala.console.Console
fi

#Something in JLine 2.9.1 is leaving stty in "no echo" (-echo) mode; try to repair that on exit...
stty echo

# Return the program's exit code
exit $?
