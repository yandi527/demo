#!/usr/bin/env bash
set +x
./gradlew clean compileJava compileTestJava bootJar --info
echo "+++++++++++++++++++++++"
pwd
docker build -t demo -f ./Dockerfile .
