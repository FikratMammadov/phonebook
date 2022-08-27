#!/usr/bin/env bash

yum update
yum install docker -y
usermod -aG docker ec2-user
systemctl enable docker
systemctl start docker

yum install git -y

mkdir -p /frontend

cd frontend

git https://github.com/FikratMammadov/phonebook.git

cd phonebook
cd phonebook-frontend

docker build -t react-phonebook-app-img:v1.0.0 .
docker run -di -e --name phonebook-frontend -p 3000:3000 react-phonebook-app-img:v1.0.0