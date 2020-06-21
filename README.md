# wasteApp

| Master status | Develop status |
| --- | --- |
|  [![Build Status](https://travis-ci.com/FantastiSquad/wasteApp.svg?branch=master)](https://travis-ci.com/FantastiSquad/wasteApp) | [![Build Status](https://travis-ci.com/FantastiSquad/wasteApp.svg?branch=develop)](https://travis-ci.com/FantastiSquad/wasteApp)

WasteApp Mobile Application with Ionic and Java

# Build

## Clone the repository

git clone https://github.com/FantastiSquad/wasteApp.git

## Build and run back (depuis skillful_network) :
cd src/wasteApp_server
mvn clean package spring-boot:run -DskipTests -Dspring-boot.run.profiles=dev -f pom.xml 

## Build and run front :
- npm installation :
cd src/wasteApp_client/wasteApp_mob_front
npm install

- following mught be required (check PR #24 for more details and instructions) :
npm update
ionic build
ionic capacitor add android
ionic capacitor update

- run from web browser and try out https://localhost:8100 :
ionic serve --ssl

- build and run on an android mobile platform (using android studio IDE) :
ionic cordova run android -l --ssl --external

- build an apk : 
ionic cap build android --ssl

