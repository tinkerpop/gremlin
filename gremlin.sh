#!/bin/bash

NAME="gremlin-0.6-SNAPSHOT"

if [ -d "target/$NAME" ]
then
  target/$NAME/bin/gremlin $@
else
  mvn clean package -Dmaven.test.skip=true && unzip target/$NAME-standalone.zip -d target
  target/$NAME/bin/gremlin $@
fi

