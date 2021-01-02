package me.satisdev.calculator;

public interface Operations {

    static double add(double x, double y) {
        return x + y;
    }

    static double subtract(double x, double y) {
        return x - y;
    }

    static double multiply(double x, double y) {
        return x * y;
    }

    static double divide(double x, double y) {
        return x / y;
    }

    static double remainder(double x, double y) {
        return x % y;
    }
}