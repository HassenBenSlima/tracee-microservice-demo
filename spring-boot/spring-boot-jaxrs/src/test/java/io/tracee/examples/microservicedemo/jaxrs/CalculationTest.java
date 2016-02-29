package io.tracee.examples.microservicedemo.jaxrs;


import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

public class CalculationTest {

    @Test
    public void testCalculationExtraction() {
        Calculation calculation = Calculation.parseCalculation("5*3+4-18/9");

        MatcherAssert.assertThat(calculation.countOperations(), CoreMatchers.is(4));

        // 5 * 3
        SingleOperation singleOperation = calculation.getSingleOperation(0);
        MatcherAssert.assertThat(singleOperation.getOperand1(), CoreMatchers.is(5.0));
        MatcherAssert.assertThat(singleOperation.getOperand2(), CoreMatchers.is(3.0));
        MatcherAssert.assertThat(singleOperation.getOperation(), CoreMatchers.is(Operation.MULTIPLICATION));

        // 3 + 4
        singleOperation = calculation.getSingleOperation(1);
        MatcherAssert.assertThat(singleOperation.getOperand1(), CoreMatchers.is(3.0));
        MatcherAssert.assertThat(singleOperation.getOperand2(), CoreMatchers.is(4.0));
        MatcherAssert.assertThat(singleOperation.getOperation(), CoreMatchers.is(Operation.ADDITION));

        // 4 - 18
        singleOperation = calculation.getSingleOperation(2);
        MatcherAssert.assertThat(singleOperation.getOperand1(), CoreMatchers.is(4.0));
        MatcherAssert.assertThat(singleOperation.getOperand2(), CoreMatchers.is(18.0));
        MatcherAssert.assertThat(singleOperation.getOperation(), CoreMatchers.is(Operation.SUBSTRACTION));

        // 18 / 9
        singleOperation = calculation.getSingleOperation(3);
        MatcherAssert.assertThat(singleOperation.getOperand1(), CoreMatchers.is(18.0));
        MatcherAssert.assertThat(singleOperation.getOperand2(), CoreMatchers.is(9.0));
        MatcherAssert.assertThat(singleOperation.getOperation(), CoreMatchers.is(Operation.DIVISION));

    }


    @Test
    public void testCalculationExtraction2() {
        Calculation calculation = Calculation.parseCalculation("5*-3.0+-4-18.0/9");

        MatcherAssert.assertThat(calculation.countOperations(), CoreMatchers.is(4));

        // 5 * -3.0
        SingleOperation singleOperation = calculation.getSingleOperation(0);
        MatcherAssert.assertThat(singleOperation.getOperand1(), CoreMatchers.is(5.0));
        MatcherAssert.assertThat(singleOperation.getOperand2(), CoreMatchers.is(-3.0));
        MatcherAssert.assertThat(singleOperation.getOperation(), CoreMatchers.is(Operation.MULTIPLICATION));

        // -3 + -4
        singleOperation = calculation.getSingleOperation(1);
        MatcherAssert.assertThat(singleOperation.getOperand1(), CoreMatchers.is(-3.0));
        MatcherAssert.assertThat(singleOperation.getOperand2(), CoreMatchers.is(-4.0));
        MatcherAssert.assertThat(singleOperation.getOperation(), CoreMatchers.is(Operation.ADDITION));

        // 4 - 18.0
        singleOperation = calculation.getSingleOperation(2);
        MatcherAssert.assertThat(singleOperation.getOperand1(), CoreMatchers.is(-4.0));
        MatcherAssert.assertThat(singleOperation.getOperand2(), CoreMatchers.is(18.0));
        MatcherAssert.assertThat(singleOperation.getOperation(), CoreMatchers.is(Operation.SUBSTRACTION));

        // 18 / 9
        singleOperation = calculation.getSingleOperation(3);
        MatcherAssert.assertThat(singleOperation.getOperand1(), CoreMatchers.is(18.0));
        MatcherAssert.assertThat(singleOperation.getOperand2(), CoreMatchers.is(9.0));
        MatcherAssert.assertThat(singleOperation.getOperation(), CoreMatchers.is(Operation.DIVISION));

    }
}
