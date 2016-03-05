package io.tracee.example.microservicedemo.jaxws.endpoint;

import io.tracee.examples.microservicedemo.jaxws.service.AddParameters;
import io.tracee.examples.microservicedemo.jaxws.service.CalculationWS;
import io.tracee.examples.microservicedemo.jaxws.service.DivParameters;
import io.tracee.examples.microservicedemo.jaxws.service.MulParameters;
import io.tracee.examples.microservicedemo.jaxws.service.SubParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jws.HandlerChain;
import javax.jws.WebService;

@WebService(serviceName = "CalculationService", portName = "CalculationServicePort",
        targetNamespace = "https://github.com/tracee/tracee/examples/microservicedemo/jaxws/service/wsdl")
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
        LOGGER.info("subtract {} from {}", parameters.getParam2(), parameters.getParam1());
        return parameters.getParam1() - parameters.getParam2();
    }
}
