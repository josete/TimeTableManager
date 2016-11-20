#!/bin/bash

#Obtencion e instalacion de nodejs
curl -sL https://deb.nodesource.com/setup_6.x | sudo -E bash -
sudo apt-get install -y nodejs
sudo apt-get install git
#Clonado del repositorio
git clone https://github.com/josete/TimeTableManager.git ./horarios
cd horarios
#Cambio de rama
git checkout pruebas
