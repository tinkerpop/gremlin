#!/bin/bash

DIR="$( cd "$( dirname "$0" )" && pwd )"
$DIR/target/gremlin-*-standalone/bin/gremlin.sh $@
