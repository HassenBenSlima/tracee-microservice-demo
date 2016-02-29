# jaxws tracee microservice demo
#
# VERSION       1.0

FROM java:openjdk-6-jre
MAINTAINER Tobias Stamann "tobias.stamann@holisticon.de"

ENV DEBIAN_FRONTEND noninteractive
EXPOSE 8002 8082

ADD spring-boot-cxf.jar /jaxws/spring-boot-cxf.jar

ENTRYPOINT cd /jaxws && java -jar spring-boot-cxf.jar