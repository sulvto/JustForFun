#!/usr/bin/env bash

mkdir -p `pwd`/.data/mysql-5.7

podman stop mysql
podman rm mysql

podman run  --privileged=true -idt  -p 3306:3306 \
		-v `pwd`/.data/mysql-5.7:/var/lib/mysql \
		--name mysql \
		-e TMPDIR=/var/lib/mysql \
		-e MYSQL_ROOT_PASSWORD=a111111 \
		mysql:5.7 
