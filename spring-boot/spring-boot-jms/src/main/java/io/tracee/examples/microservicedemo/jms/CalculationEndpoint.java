package io.tracee.examples.microservicedemo.jms;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.ArrayList;
import java.util.List;

@Component
@Path("/asyncCalculate")
public class CalculationEndpoint {

    Logger logger = org.slf4j.LoggerFactory.getLogger(CalculationEndpoint.class);

    @Autowired
    private JmsMessageProducerService jmsMessageProducerService;

    @GET
    public String calculate(@QueryParam("calculations") String calculations) {

        List<String> parsedCalculations = getCalculations(calculations);

        logger.info("Got {} calculations to be calculate asynchronously: {}", parsedCalculations.size(), parsedCalculations);

        for (String parsedCalculation : parsedCalculations) {
            jmsMessageProducerService.produceCalculationMessage(parsedCalculation);
        }

        return "OK";
    }

    public List<String> getCalculations(String calculations) {

        List<String> result = new ArrayList<String>();

        if (calculations != null) {
            for (String calculation : calculations.split("[;]")) {
                if (!calculation.trim().isEmpty()) {
                    result.add(calculation.trim());
                }
            }
        }

        return result;
    }


}
