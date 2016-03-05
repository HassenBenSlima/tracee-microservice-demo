package io.tracee.examples.microservicedemo.jaxrs.impl;


public enum Operation {
    ADDITION, SUBSTRACTION, MULTIPLICATION, DIVISION;

    public static Operation getOperation(char operation) {
        switch (operation) {
            case '-':
                return SUBSTRACTION;
            case '+':
                return ADDITION;
            case '*':
                return MULTIPLICATION;
            case '/':
                return DIVISION;
        }

        return null;
    }
}
