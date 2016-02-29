package io.tracee.examples.microservicedemo.jaxrs;


public class SingleOperation {

    private final int index;
    private final double operand1;
    private final double operand2;
    private final Operation operation;

    public SingleOperation(int index,
                           double operand1,
                           double operand2,
                           Operation operation) {
        this.index = index;
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operation = operation;
    }

    public int getIndex() {
        return index;
    }

    public double getOperand1() {
        return operand1;
    }

    public double getOperand2() {
        return operand2;
    }

    public Operation getOperation() {
        return operation;
    }
}
