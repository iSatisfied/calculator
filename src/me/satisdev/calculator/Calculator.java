package me.satisdev.calculator;

import java.util.Scanner;

public class Calculator {

    private double first, second;
    private String operator;

    private FileParser fparser;
    private Scanner scanner;
    private Verifier verifier;

    public Calculator() {
        this.first = Double.NaN;
        this.second = Double.NaN;
        this.operator = "";

        this.scanner = new Scanner(System.in);
        this.verifier = new Verifier();
        this.fparser = new FileParser();
    }

    public void calculate() {
        boolean unverified = true;

        while (unverified) {

            if (Double.isNaN(this.first)) {
                System.out.print("\nPlease input a valid first number: ");
                this.first = verifier.verifyNumber(scanner.next());

                continue;
            }

            if (this.operator.isEmpty()) {
                System.out.print("\nPlease input a valid arithmetic operator: ");
                this.operator = verifier.verifyOperator(scanner.next());

                continue;
            }

            if (Double.isNaN(this.second)) {
                System.out.print("\nPlease input a valid second number: ");
                this.second = verifier.verifyNumber(scanner.next());

                continue;

            }
            unverified = false;
        }
        verifier.result(this.first, this.operator, this.second);
    }

    public void calculate(String input) {
        for (String operator : verifier.operators) {
            if (!input.contains(operator)) continue;

            String[] numbers = operator.equals("+") || operator.equals("*")
                              ? input.split("\\" + operator) : input.split(operator);

            this.first = verifier.verifyNumber(numbers[0]);
            this.second = verifier.verifyNumber(numbers[1]);

            if (Double.isNaN(this.first) || Double.isNaN(this.second)) break;

            verifier.result(this.first, operator, this.second);
            return;
        }
        fparser.getFailureFile();
    }

    public void calculate(String[] input) {
        this.first = verifier.verifyNumber(input[0]);
        this.operator = verifier.verifyOperator(input[1]);
        this.second = verifier.verifyNumber(input[2]);

        if (Double.isNaN(this.first) ||
            Double.isNaN(this.second) ||
            operator.isEmpty()) {
                fparser.getFailureFile();
                return;
        }
        verifier.result(this.first, operator, this.second);
    }
}
