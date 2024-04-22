#!/usr/bin/env bash

#cd docker || { echo "Failure"; exit 1; }

docker-compose -f jdbc-mysql.yml down
docker-compose -f jdbc-mysql.yml up -d
echo 'Build Complete'