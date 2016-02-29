package io.tracee.examples.microservicedemo.jaxrs;

import io.tracee.examples.microservicedemo.calculationclient.AddParameters;
import io.tracee.examples.microservicedemo.calculationclient.CalculationWS;
import io.tracee.examples.microservicedemo.calculationclient.DivParameters;
import io.tracee.examples.microservicedemo.calculationclient.MulParameters;
import io.tracee.examples.microservicedemo.calculationclient.SubParameters;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Component
@Path("/calculate")
public class CalculationEndpoint {

    Logger logger = org.slf4j.LoggerFactory.getLogger(CalculationEndpoint.class);

    @Autowired
    private CalculationWS calculationService;

    @GET
    @Produces("application/json")
    public Double calculate(@QueryParam("calculation") String calculation) {

        logger.info("Solve calculation: {}", calculation);

        // handle multiplication
        Calculation parsedCalculation = Calculation.parseCalculation(calculation);

        // first handle multiplication and division
        logger.info("Calculate multiplications and division");

        for (int i = 0; i < parsedCalculation.countOperations(); ) {

            SingleOperation singleOperation = parsedCalculation.getSingleOperation(i);
            if (singleOperation.getOperation() == Operation.MULTIPLICATION) {

                MulParameters mulParameters = new MulParameters();
                mulParameters.setParam1(singleOperation.getOperand1());
                mulParameters.setParam2(singleOperation.getOperand2());
                double subResult = calculationService.multiplication(mulParameters);

                parsedCalculation = parsedCalculation.solvePartCalculation(i, subResult);
            } else if (singleOperation.getOperation() == Operation.DIVISION) {

                DivParameters divParameters = new DivParameters();
                divParameters.setParam1(singleOperation.getOperand1());
                divParameters.setParam2(singleOperation.getOperand2());
                double subResult = calculationService.division(divParameters);

                parsedCalculation = parsedCalculation.solvePartCalculation(i, subResult);
            } else {
                i++;
            }

        }

        // now do sums
        logger.info("Calculate addition and substraction");
        while (parsedCalculation.countOperations() > 0) {
            SingleOperation singleOperation = parsedCalculation.getSingleOperation(0);
            if (singleOperation.getOperation() == Operation.SUBSTRACTION) {

                SubParameters subParameters = new SubParameters();
                subParameters.setParam1(singleOperation.getOperand1());
                subParameters.setParam2(singleOperation.getOperand2());
                double subResult = calculationService.substraction(subParameters);

                parsedCalculation = parsedCalculation.solvePartCalculation(0, subResult);
            } else {

                AddParameters addParameters = new AddParameters();
                addParameters.setParam1(singleOperation.getOperand1());
                addParameters.setParam2(singleOperation.getOperand2());
                double subResult = calculationService.addition(addParameters);

                parsedCalculation = parsedCalculation.solvePartCalculation(0, subResult);
            }
        }

        return parsedCalculation.getResult();

    }


}
