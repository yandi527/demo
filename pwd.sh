#!/usr/bin/env bash
set +x
echo "90909090909099090"
pwd
cd /Users/yandi.lin/.jenkins/workspace/demo/
ls
./gradlew clean compileJava compileTestJava bootJar --info
