#!/usr/bin/env bash

# To add later : -Dspring-boot.run.profiles=test
mvn clean package spring-boot:run -DskipTests -f src/wasteApp_server/pom.xml -Dspring-boot.run.profiles=test &
pid_backend=$!

sleep 30 &
pid_sleep=$!

while ps -p $pid_backend -o pid= && ps -p $pid_sleep -o pid=
do
	sleep 3
done

# the server should be still running
ps -p $pid_backend
status=$?
if [ $status -eq 0 ]
then
  kill -9 $pid_backend
fi
exit $status
