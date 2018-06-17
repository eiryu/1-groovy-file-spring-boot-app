#!/bin/sh

tar zxf spring-boot-cli-2.0.3.RELEASE-bin.tar.gz
spring-2.0.3.RELEASE/bin/spring jar app.jar *.groovy
java -jar app.jar --server.port=$PORT
