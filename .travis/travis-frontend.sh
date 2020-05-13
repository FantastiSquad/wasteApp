#!/usr/bin/env bash

npm install npm@latest @ionic/cli

cd src/wasteApp_client/wasteApp_mob_front

npm install fund && ionic build
