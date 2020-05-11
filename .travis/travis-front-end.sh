#!/usr/bin/env bash

npm install npm@latest @ionic/cli

cd src/wasteApp_client && npm install fund && ionic build
