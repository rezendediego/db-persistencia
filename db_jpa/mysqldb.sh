#!/usr/bin/env bash
@echo off
docker-compose -f jpa-mysql.yml down
docker-compose -f jpa-mysql.yml up -d
echo 'Build Complete'