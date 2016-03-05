# jms tracee microservice demo
#
# VERSION       1.0

FROM java:openjdk-8-jre
MAINTAINER Tobias Stamann "tobias.stamann@holisticon.de"

ENV DEBIAN_FRONTEND noninteractive

ADD spring-boot-jms.jar spring-boot-jms.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/spring-boot-jms.jar"]
