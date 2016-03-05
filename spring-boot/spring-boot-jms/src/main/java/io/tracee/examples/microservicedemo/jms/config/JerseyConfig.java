package io.tracee.examples.microservicedemo.jms.config;

import io.tracee.examples.microservicedemo.jms.CalculationEndpoint;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(CalculationEndpoint.class);
    }
}
