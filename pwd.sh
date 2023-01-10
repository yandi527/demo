#!/usr/bin/env bash
set +x
./gradlew clean compileJava compileTestJava bootJar --info

