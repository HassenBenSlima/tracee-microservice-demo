package io.tracee.example.microservicedemo.jaxws.endpoint;

import https.github_com.tracee.tracee.examples.jaxws.service.wsdl.AddParameters;
import https.github_com.tracee.tracee.examples.jaxws.service.wsdl.CalculationWS;
import https.github_com.tracee.tracee.examples.jaxws.service.wsdl.DivParameters;
import https.github_com.tracee.tracee.examples.jaxws.service.wsdl.MulParameters;
import https.github_com.tracee.tracee.examples.jaxws.service.wsdl.SubParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jws.HandlerChain;
import javax.jws.WebService;

@WebService(serviceName = "CalculationService", portName = "CalculationPort",
        targetNamespace = "https://github.com/tracee/tracee/examples/jaxws/service/wsdl")
@HandlerChain(file = "/traceeHandlerChain.xml")
public class CalculationServiceEndpoint implements CalculationWS {

    private final static Logger LOGGER = LoggerFactory.getLogger(CalculationServiceEndpoint.class);


    @Override
    public double division(DivParameters parameters) {
        LOGGER.info("divide {} by {}", parameters.getParam1(), parameters.getParam2());
        return parameters.getParam1() / parameters.getParam2();
    }

    @Override
    public double multiplication(MulParameters parameters) {
        LOGGER.info("multiply {} by {}", parameters.getParam1(), parameters.getParam2());
        return parameters.getParam1() * parameters.getParam2();
    }

    @Override
    public double addition(AddParameters parameters) {
        LOGGER.info("add {} to {}", parameters.getParam2(), parameters.getParam1());
        return parameters.getParam1() + parameters.getParam2();
    }

    @Override
    public double substraction(SubParameters parameters) {
        LOGGER.info("substract {} from {}", parameters.getParam2(), parameters.getParam1());
        return parameters.getParam1() - parameters.getParam2();
    }
}
