#!/usr/bin/env bash

# navigate to wasty ionic front
cd src/wasteApp_client/wasteApp_mob_front

# install npm modules and install the application
npm install npm@latest @ionic/cli
npm install fund

# start the front process and get its pid
ionic serve --no-open &
pid_front=$!

# start waiting room
time=90
echo "start waiting room of $time sec"
sleep $time &
pid_sleep=$!

# check every 3 sec front status
echo "> $time sec"
while ps -p $pid_front -o pid= > /dev/null && ps -p $pid_sleep -o pid=  > /dev/null
do
	sleep 3
	((time = time -3))
	echo "> $time sec ..."
done

# the front should be still running
ps -p $pid_front
status=$?
# if front is running, we kiill its process
if [ $status -eq 0 ]
then
  kill -9 $pid_front
fi
exit $status
