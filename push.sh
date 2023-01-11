#!/usr/bin/env bash
set +x
docker login localhost:5005 -u admin -p 0000
docker tag demo:latest localhost:5005/demo:demo
docker push localhost:5005/demo:demo

