package me.satisdev.calculator;

import java.util.Scanner;

public class Calculator {

    private double first, second, result;
    private String operator;

    private Scanner scanner;
    private Verifier verifier;

    public Calculator() {
        this.scanner = new Scanner(System.in);
        this.verifier = new Verifier();
    }

    private void invalidExpression() {
        System.out.println("\nYou have provided an improper expression.");
        System.out.println("A proper expression example is provided below:");
        System.out.println();
        System.out.println("  First Number    Operator    Second Number");
        System.out.println("       5             +              5\n");
    }

    public void calculate() {
        boolean unverified = true;

        while (unverified) {
            System.out.print("\nPlease input your first number: ");
            this.first = verifier.verifyNumber(scanner.next());

            if (!Double.isNaN(this.first)) break;
        }

        while (unverified) {
            System.out.print("\nPlease input an arithmetic operator: ");
            this.operator = verifier.verifyOperator(scanner.next());

            if (this.operator != null) break;
        }

        while (unverified) {
            System.out.print("\nPlease input your second number: ");
            this.second = verifier.verifyNumber(scanner.next());

            if (!Double.isNaN(this.second)) break;
        }

        this.result = verifier.result(this.first, this.operator, this.second);

        System.out.println();
        System.out.println(this.first + " " + this.operator + " " +
                            this.second + " = " + this.result);
        System.out.println();
    }

    public void calculate(String input) {
        for (String operator : verifier.operators) {
            if (!input.contains(operator)) continue;

            String[] numbers = operator.equals("+") || operator.equals("*")
                              ? input.split("\\" + operator) : input.split(operator);

            first = verifier.verifyNumber(numbers[0]);
            second = verifier.verifyNumber(numbers[1]);

            if (Double.isNaN(first) || Double.isNaN(second)) break;

            this.result = verifier.result(this.first, operator, this.second);

            System.out.println();
            System.out.println(this.first + " " + operator + " " +
                                this.second + " = " + this.result);
            System.out.println();
            return;
        }
        invalidExpression();
    }
}
