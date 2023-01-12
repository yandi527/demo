#!/usr/bin/env bash
set +x
./gradlew clean compileJava compileTestJava bootJar --info
docker build -t demo -f ./Dockerfile .

