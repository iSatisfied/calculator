package me.satisdev.calculator;

import me.satisdev.calculator.parsers.InputParser;

public class Main {

    public static void main(String[] args) {
        InputParser inputParser = new InputParser();

        inputParser.parse(args);
    }
}