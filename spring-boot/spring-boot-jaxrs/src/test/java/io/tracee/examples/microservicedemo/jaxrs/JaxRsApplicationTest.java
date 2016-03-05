package io.tracee.examples.microservicedemo.jaxrs;


import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Ignore;
import org.junit.Test;

public class JaxRsApplicationTest {


    @Test
    @Ignore
    public void doCalculation() {
        String calculation = "5+10/5*4-45";

        CalculationEndpoint calculationEndpoint = new CalculationEndpoint();
        MatcherAssert.assertThat(calculationEndpoint.calculate(calculation), CoreMatchers.is(-32.0));

    }

}
