package io.tracee.examples.microservicedemo.jms;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.jms.ConnectionFactory;


@SpringBootApplication
@ComponentScan("io.tracee.examples.microservicedemo.jms")
public class JmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(JmsApplication.class, args);
    }
}

