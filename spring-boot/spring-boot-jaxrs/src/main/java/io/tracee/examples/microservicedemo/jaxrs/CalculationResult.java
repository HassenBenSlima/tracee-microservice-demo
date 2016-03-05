package io.tracee.examples.microservicedemo.jaxrs;


public class CalculationResult {

    public final String calculation;
    public final Double result;

    public CalculationResult(String calculation, Double result) {
        this.calculation = calculation;
        this.result = result;
    }

    public Double getResult() {
        return result;
    }

    public String getCalculation() {
        return calculation;
    }
}
