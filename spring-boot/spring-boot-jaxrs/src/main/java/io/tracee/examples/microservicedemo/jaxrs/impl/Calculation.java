package io.tracee.examples.microservicedemo.jaxrs.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Please ignore this messy implementation ...
 */
public class Calculation {

    private List<Double> parameters = new ArrayList<Double>();
    private List<Operation> operations = new ArrayList<Operation>();

    public Calculation(double value) {
        parameters.add(value);
    }

    private Calculation(List<Double> parameters, List<Operation> operations, int operation, double result) {
        this.parameters = new ArrayList<>(parameters);
        this.operations = new ArrayList<>(operations);

        this.operations.remove(operation);
        this.parameters.set(operation, result);
        this.parameters.remove(operation + 1);

    }

    public void addOperation(Operation operation, double operand) {
        if (operation != null) {
            parameters.add(operand);
            operations.add(operation);
        }
    }

    public Calculation solvePartCalculation(int operation, double result) {
        return new Calculation(this.parameters, this.operations, operation, result);
    }

    public int countOperations() {
        return operations.size();
    }

    public double getResult(){
        if (this.operations.size() == 0){
            return parameters.get(0);
        } else {
            throw new RuntimeException("Calculation not done");
        }
    }

    public SingleOperation getSingleOperation(int count) {
        if (count < 0 || count > operations.size()) {
            throw new IllegalArgumentException();
        }

        return new SingleOperation(count, parameters.get(count), parameters.get(count + 1), operations.get(count));
    }

    public static Calculation parseCalculation(String calculation) {

        Pattern operandPattern = Pattern.compile("([+-]{0,1}\\d+(?:[.]\\d+)?)(.*)?");
        Pattern operationPattern = Pattern.compile("([*/+-])(.*)");

        Matcher firstOperandMatcher = operandPattern.matcher(calculation);
        Calculation resultCalculation = null;
        if (firstOperandMatcher.matches() && firstOperandMatcher.groupCount() == 2) {
            resultCalculation = new Calculation(Double.valueOf(firstOperandMatcher.group(1)));

            String restCalculation = firstOperandMatcher.group(2);
            while (!restCalculation.isEmpty()) {

                Matcher operationMatcher = operationPattern.matcher(restCalculation);
                if (operationMatcher.matches() && operationMatcher.groupCount() == 2) {

                    Operation operation = Operation.getOperation(operationMatcher.group(1).charAt(0));

                    Matcher secondOperandMatcher = operandPattern.matcher(operationMatcher.group(2));
                    if (secondOperandMatcher.matches() && secondOperandMatcher.groupCount() == 2) {

                        double operand = Double.valueOf(secondOperandMatcher.group(1));
                        resultCalculation.addOperation(operation, operand);
                        restCalculation = secondOperandMatcher.group(2);
                    } else {
                        throw new IllegalArgumentException();
                    }


                } else {
                    throw new IllegalArgumentException();
                }
            }

        }


        return resultCalculation;
    }


}
