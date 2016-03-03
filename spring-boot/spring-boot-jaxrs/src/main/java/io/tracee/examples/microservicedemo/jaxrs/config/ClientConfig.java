package io.tracee.examples.microservicedemo.jaxrs.config;

import io.tracee.binding.jaxws.TraceeClientHandlerResolver;
import io.tracee.examples.microservicedemo.calculationclient.CalculationService;
import io.tracee.examples.microservicedemo.calculationclient.CalculationWS;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

@Configuration
public class ClientConfig {

    @Value("io.tracee.jaxwsCalculationService.url")
    private String jaxWsCalculationServiceUrl;


    @Bean
    public CalculationWS createJaxWsCalculatorClient2() throws MalformedURLException {


        final URL wsdlUrl = ClientConfig.class.getResource("/META-INF/wsdl/calculation.wsdl");

        Service yourService= CalculationService.create(
                wsdlUrl,new QName("https://github.com/tracee/tracee/examples/jaxws/service/wsdl","CalculationService"));
        yourService.setHandlerResolver(new TraceeClientHandlerResolver());

        CalculationWS calculationService = yourService.getPort(
                new QName("https://github.com/tracee/tracee/examples/jaxws/service/wsdl", "DivisionPort"),
                CalculationWS.class);
        BindingProvider bp = (BindingProvider) calculationService;
        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
                "http://jaxws:8082/calculation/CalculationService");

        return calculationService;

    }

}
