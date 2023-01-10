#!/usr/bin/env bash
set +x
echo "90909090909099090"
pwd
ls
./gradlew clean compileJava compileTestJava bootJar --info
