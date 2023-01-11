#!/usr/bin/env bash
set +x
docker login -u aishasha111 -p L27705.yandi
docker tag demo:latest aishasha111/demo:demo
docker push aishasha111/demo:demo

