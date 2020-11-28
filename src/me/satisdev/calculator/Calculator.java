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

    public void calculate() {
        boolean unverified = true;

        while (unverified) {
            System.out.print("\nPlease input your first number: ");
            first = verifier.verifyNumber(scanner.next());

            if (!Double.isNaN(first)) break;
        }

        while (unverified) {
            System.out.print("\nPlease input an arithmetic operator: ");
            operator = verifier.verifyOperator(scanner.next());

            if (operator != null) break;
        }

        while (unverified) {
            System.out.print("\nPlease input your second number: ");
            second = verifier.verifyNumber(scanner.next());

            if (!Double.isNaN(second)) break;
        }

        result = verifier.result(first, operator, second);

        System.out.println();
        System.out.println(first + " " + operator + " " + second + " = " + result);
        System.out.println();
    }
}
