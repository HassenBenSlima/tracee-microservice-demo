package io.tracee.examples.microservicedemo.jms;


public class CalculationResult {

    public String calculation;
    public Double result;

    public Double getResult() {
        return result;
    }

    public String getCalculation() {
        return calculation;
    }

    public void setCalculation(String calculation) {
        this.calculation = calculation;
    }

    public void setResult(Double result) {
        this.result = result;
    }
}
