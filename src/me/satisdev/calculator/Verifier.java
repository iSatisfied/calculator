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

        for (var operator : Operators.values())
            if (input.charAt(0) == operator.getOperator())
                return operator;

        return Operators.NONE;
    }

    public void result(double first, Operators operator, double second) {
        var result = operator.apply(first, second);

        System.out.println(first + " " + operator + " " + second + " = " + result);
    }
}