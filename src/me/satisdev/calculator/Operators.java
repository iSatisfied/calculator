package me.satisdev.calculator;

import java.util.function.DoubleBinaryOperator;

public enum Operators {
    NONE(-1),
    // TO DO: implement solving more than one expression at time
    // PARETHESIS(0, '('),
    EXPONENT(1, '^', (x, y) -> Math.pow(x, y)),
    MULTIPLICATION(2, '*', (x, y) -> x * y),
    DIVISION(3, '/', (x, y) -> x / y),
    MODULUS(4, '%', (x, y) -> x % y),
    ADDITION(5, '+', (x, y) -> x + y),
    SUBTRACTION(6, '-', (x, y) -> x - y);

    private final int order;
    private final char operator;
    private final DoubleBinaryOperator dbo;

    private Operators(int order) {
        this.order = order;
        this.operator = Character.UNASSIGNED;
        this.dbo = (x, y) -> Double.NaN;
    }

    private Operators(int order, char operator) {
        this.order = order;
        this.operator = operator;
        this.dbo = (x, y) -> Double.NaN;
    }

    private Operators(int order, char operator, DoubleBinaryOperator dbo) {
        this.order = order;
        this.operator = operator;
        this.dbo = dbo;
    }

    public int getOrder() {
        return this.order;
    }

    public char getOperator() {
        return this.operator;
    }

    public double apply(double x, double y) {
        return dbo.applyAsDouble(x, y);
    }

    @Override
    public String toString() {
        return String.valueOf(this.operator); 
    }
}