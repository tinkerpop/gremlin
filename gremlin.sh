#!/bin/bash

# Launch the application
if [ "$1" = "-l" ]; then
  if [ "$2" = "groovy" ]; then
    `dirname $0`/gremlin-groovy/target/gremlin-*-standalone/bin/gremlin.sh $@
  elif [ "$2" = "scala" ]; then
    `dirname $0`/gremlin-scala/target/gremlin-*-standalone/bin/gremlin.sh $@
  else
    echo "The only Gremlin REPL JVM languages are 'groovy' and 'scala'"
  fi
else
  `dirname $0`/gremlin-groovy/target/gremlin-*-standalone/bin/gremlin.sh $@
fi