package me.satisdev.calculator;

import java.lang.NumberFormatException;

public class Verifier {

    public double verifyNumber(String input) {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            return Double.NaN;
        }
    }

    public Operators verifyOperator(String input) {
        if (input.length() > 1) return Operators.NONE;

        for (Operators operator : Operators.values())
            if (input.charAt(0) == operator.getOperator())
                return operator;

        return Operators.NONE;
    }

    public void result(double first, Operators operator, double second) {
        double result = switch (operator) {
            case ADDITION       -> Operations.add(first, second);
            case SUBTRACTION    -> Operations.subtract(first, second);
            case MULTIPLICATION -> Operations.multiply(first, second);
            case DIVISION       -> Operations.divide(first, second);
            case MODULUS        -> Operations.remainder(first, second);
            case EXPONENT       -> Math.pow(first, second);
            default             -> Double.NaN;
        };

        System.out.println(first + " " + operator.getOperator() + " " + second + " = " + result);
    }
}