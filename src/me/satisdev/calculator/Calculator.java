package me.satisdev.calculator;

import java.util.Scanner;

import me.satisdev.calculator.parsers.FileParser;

public class Calculator {

    private double first, second;
    private Operators operator;

    private final FileParser fileParser;
    private final Scanner scanner;
    private final Verifier verifier;

    public Calculator() {
        this.first = Double.NaN;
        this.second = Double.NaN;
        this.operator = Operators.NONE;

        this.scanner = new Scanner(System.in);
        this.verifier = new Verifier();
        this.fileParser = new FileParser();
    }

    public void calculate() {
        boolean unverified = true;

        while (unverified) {

            if (Double.isNaN(this.first)) {
                System.out.print("\nPlease input a valid first number: ");
                this.first = verifier.verifyNumber(scanner.next());

                continue;
            }

            if (this.operator == Operators.NONE) {
                System.out.print("\nPlease input a valid arithmetic operator: ");
                this.operator = verifier.verifyOperator(this.scanner.next());

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

    public void calculate(String[] input) {
        this.first = verifier.verifyNumber(input[0]);
        this.operator = verifier.verifyOperator(input[1]);
        this.second = verifier.verifyNumber(input[2]);

        if (Double.isNaN(this.first) ||
            Double.isNaN(this.second) ||
            this.operator == Operators.NONE) {
                fileParser.getFailureFile();
                return;
        }
        verifier.result(this.first, operator, this.second);
    }
}