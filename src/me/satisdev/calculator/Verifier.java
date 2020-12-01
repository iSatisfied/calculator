package me.satisdev.calculator;

import java.lang.NumberFormatException;

public class Verifier {

    private double result;

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

        return "";
    }

    public void result(double first, String operator, double second) {
        switch (operator) {
            case "+":
                result = Operations.add(first, second);
                break;

            case "-":
                result = Operations.subtract(first, second);
                break;

            case "*":
                result =  Operations.multiply(first, second);
                break;

            case "/":
                result =  Operations.divide(first, second);
                break;

            case "%":
                result =  Operations.remainder(first, second);
                break;

            default:
                result = Double.NaN;
        }

        System.out.println();
        System.out.println(first + " " + operator + " " + second + " = " + result);
        System.out.println();
    }
}
