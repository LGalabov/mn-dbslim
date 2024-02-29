#!/bin/bash

SCRIPT_DIR=$( cd -- "$( dirname -- "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )
LIBS_DIR=$SCRIPT_DIR/../build/libs
DEPS_FILE="$SCRIPT_DIR"/deps-list.info
GRADLEW=$SCRIPT_DIR/../gradlew

$GRADLEW shadowJar --no-daemon
echo "> Generated shadow jar"

jdeps --ignore-missing-deps -q \
  --recursive --multi-release 21 \
  --print-module-deps --class-path 'BOOT-INF/lib/*' \
  "$LIBS_DIR"/*-all.jar > "$DEPS_FILE"
echo "> Generated dependency list"

# Additional dependency modules:
# jdk.zipfs - required to run on Docker
ADD_MODULES=,jdk.zipfs

sed -i '' "1s/$/$ADD_MODULES/g" "$DEPS_FILE"
echo "> Added additional modules"

echo "> Successfully generated JPMS dependency list"
