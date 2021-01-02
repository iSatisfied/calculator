package me.satisdev.calculator;

public enum Operators {
    NONE(-1, '0'),
    // TO DO: implement solving more than one expression at time
    // PARETHESIS(0, '('),
    EXPONENT(1, '^'),
    MULTIPLICATION(2, '*'),
    DIVISION(3, '/'),
    MODULUS(4, '%'),
    ADDITION(5, '+'),
    SUBTRACTION(6, '-');

    private final int order;
    private final char operator;

    private Operators(int order, char operator) {
        this.order = order;
        this.operator = operator;
    }

    public int getOrder() {
        return this.order;
    }

    public char getOperator() {
        return this.operator;
    }
}