package io.tracee.examples.microservicedemo.jaxrs.config;

import io.tracee.binding.jaxrs2.TraceeContainerFilter;
import io.tracee.examples.microservicedemo.jaxrs.CalculationEndpoint;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(CalculationEndpoint.class);
        register(TraceeContainerFilter.class);
    }
}
