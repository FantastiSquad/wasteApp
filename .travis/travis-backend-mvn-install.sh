#!/usr/bin/env bash

mvn clean install -f src/wasteApp_server/pom.xml -Dspring-boot.run.profiles=test -DskipTests
