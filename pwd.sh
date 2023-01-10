#!/usr/bin/env bash
set +x
echo "90909090909099090"
pwd
ls
./gradlew clean compileJava compileTestJava bootJar --info
echo "1111111111111111111111"
cd /Users/yandi.lin/.jenkins/workspace/demo/
ls
