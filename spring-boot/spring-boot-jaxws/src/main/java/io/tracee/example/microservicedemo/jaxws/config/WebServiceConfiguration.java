package io.tracee.example.microservicedemo.jaxws.config;

import io.tracee.example.microservicedemo.jaxws.endpoint.CalculationServiceEndpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;
import java.util.Map;

@Configuration
public class WebServiceConfiguration {

    public static final String SERVLET_MAPPING_URL_PATH = "/calculation";
    public static final String SERVICE_NAME_URL_PATH = "/CalculationService";
    public static final String SERVICE_LIST_TITLE = "Calculation Services";

    @Bean
    public ServletRegistrationBean dispatcherServlet() {
        CXFServlet cxfServlet = new CXFServlet();
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(cxfServlet, SERVLET_MAPPING_URL_PATH + "/*");

        Map<String, String> initParameters = servletRegistrationBean.getInitParameters();
        initParameters.put("service-list-title", SERVICE_LIST_TITLE);

        return servletRegistrationBean;
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }


    @Bean
    public CalculationServiceEndpoint divisionService() {
        return new CalculationServiceEndpoint();
    }

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), divisionService());
        endpoint.publish(SERVICE_NAME_URL_PATH);
        endpoint.setWsdlLocation("calculation.wsdl");
        return endpoint;
    }


}
