# jaxrs tracee microservice demo
#
# VERSION       1.0

FROM java:openjdk-8-jre
MAINTAINER Tobias Stamann "tobias.stamann@holisticon.de"

ENV DEBIAN_FRONTEND noninteractive
EXPOSE 8001 8081

ADD spring-boot-jaxrs.jar /jaxrs/spring-boot-jaxrs.jar

ENTRYPOINT cd /jaxrs && java -jar spring-boot-jaxrs.jar

