package me.satisdev.calculator;

import java.lang.NumberFormatException;

public class Verifier {

    protected static String[] operators = {"+", "-", "*", "/", "%"};

    public double verifyNumber(String input) {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            return Double.NaN;
        }
    }

    public String verifyOperator(String input) {
        for (String operator : operators) if (input.equals(operator)) return input;

        return null;
    }

    public double result(double firstNum, String operator, double secondNum) {
        switch (operator) {
            case "+":
                return Operations.add(firstNum, secondNum);

            case "-":
                return Operations.subtract(firstNum, secondNum);

            case "*":
                return Operations.multiply(firstNum, secondNum);

            case "/":
                return Operations.divide(firstNum, secondNum);

            case "%":
                return Operations.remainder(firstNum, secondNum);
            default:
                return Double.NaN;
        }
    }
}
