#!/usr/bin/env bash
@echo off
docker-compose -f hibernate-mysql.yml down
docker-compose -f hibernate-mysql.yml up -d
echo 'Build Complete'