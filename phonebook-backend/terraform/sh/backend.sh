#!/usr/bin/env bash

yum update
yum install docker -y
usermod -aG docker ec2-user
systemctl enable docker
systemctl start docker

yum install git -y

mkdir -p /backend

cd backend

git clone https://github.com/FikratMammadov/phonebook.git

cd phonebook
cd phonebook-backend

docker build -t phonebook-backend-api-img:v1.0.0 .
docker run -di -e SPRING_DATASOURCE_URL=${datasource_url} -e SPRING_DATASOURCE_USERNAME=${datasource_username} -e SPRING_DATASOURCE_PASSWORD=${datasource_password} --name phonebook-backend-api -p 8080:8080 phonebook-backend-api-img:v1.0.0
