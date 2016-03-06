> This document contains documentation for TracEE examples. Click [here](/README.md) to get an overview that TracEE is about.

# tracee-microservice-examples

This folder contains Dockerfiles and a `docker-compose.yml` descriptor for tracee-microservice-demo. It starts a jaxws, jaxrs and jms spring boot application docker containers.
Additionally it starts an ELK stack which is used by collect logs of all spring boot applications.

![overview](docker.png?raw=true)

## Start the enviroment

### Prerequisites

1. Run `mvn install` on the tracee-examples parent project
2. Install [`docker`](https://docs.docker.com/installation/)
3. Install `docker-compose` [1.1.0-rc2](https://github.com/docker/fig/releases/tag/1.1.0-rc2) or newer.

Depending on your operation system you also need to create a virtual machine to be able to run the docker containers (needed for Max OS, Windows and other non linux systems)

4. Create a docker machine if you are using a non Linux systems `docker-machine create --virtualbox-memory "4096" --virtualbox-disk-size "20000" --virtualbox-cpu-count "2" --driver virtualbox default`
5. Start the virtusl machine by executing `docker-machine start default` 
6. Execute `eval $(docker-machine env default)` in terminal before you start working

### Run the applications
1. Run `docker-compose build` in this directory
2. Run `docker-compose up` in this directory

## Accessing the applications

If you are using a VM for docker then replace localhost in urls by the ip of the VM (`docker-machine ip default`) 

### JaxRS calculation application 

Used to calculate complex calculations. Internally calls the JaxWS calculation application to solve simple calculations with two operands.

* [http://localhost:8081/api/calculate?calculation=3-2](http://localhost:8081/api/calculate?calculation=3-2) - the rest endpoint for calculation, replace calculation parameter with your calculation
* [http://localhost:9001/actuator](http://localhost:9001/actuator) spring boot actuator root

Example: Calling service by using curl:

    curl -G -v  --data-urlencode "calculation=4*5-10*4+33" http://localhost:8081/api/calculate



### JaxWS calculation application

Used to calculate simple calulations with two operands.

* [http://localhost:8082/calculation/CalculationService?wsdl](http://localhost:8082/calculation/CalculationService?wsdl) webservice WSDL
* [http://localhost:8082/calculation/CalculationService](http://localhost:8082/calculation/CalculationService) webservice endpoint
* [http://localhost:9002/actuator](http://localhost:9002/actuator) spring boot actuator root

### JMS calculation application

Used to asynchronously perform multiple calculations. Asynchronously calls JaxWs service.

* [http://localhost:8080/api/calculate?calculation=3-2;3-43](http://localhost:8080/api/calculate?calculations=3-2;3-43) - the rest endpoint for calculation, replace calculations parameter with your ';' separated calculation
* [http://localhost:9000/actuator](http://localhost:9000/actuator) spring boot actuator root

Example: Calling service by using curl:

    curl -G -v  --data-urlencode "calculations=4*5-10*4+33;354/34-45*43;4-3+3*45" http://localhost:8080/api/calculate

### ELK Stack

* [http://localhost:5601](http://localhost:5601) Kibana
* [http://localhost:9200](http://localhost:9200) Elasticsearch






