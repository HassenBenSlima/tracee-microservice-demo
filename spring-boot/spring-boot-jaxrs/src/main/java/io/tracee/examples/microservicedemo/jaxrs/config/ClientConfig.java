package io.tracee.examples.microservicedemo.jaxrs.config;

import io.tracee.binding.jaxws.TraceeClientHandlerResolver;
import io.tracee.examples.microservicedemo.calculationclient.CalculationService;
import io.tracee.examples.microservicedemo.calculationclient.CalculationWS;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.MalformedURLException;
import java.net.URL;

@Configuration
public class ClientConfig {

    @Value("io.tracee.jaxwsCalculationService.url")
    private String jaxWsCalculationServiceUrl;


    @Bean
    public CalculationWS createJaxWsCalculatorClient2() throws MalformedURLException {

        CalculationService calculationService = new CalculationService(new URL("http://jaxws:8082/calculation/CalculationService?wsdl"));
        calculationService.setHandlerResolver(new TraceeClientHandlerResolver());

        return calculationService.getPort(CalculationWS.class);

    }

}
