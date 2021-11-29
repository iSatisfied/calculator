package me.satisdev.calculator.parsers;

import me.satisdev.calculator.Calculator;

public class InputParser {

    private final Calculator calc;
    private final FileParser parser;

    public InputParser() {
        calc = new Calculator();
        parser = new FileParser();
    }

    public void parse(String[] input){
        if (input.length == 0) {
            calc.calculate();
        } else if (input.length == 1) {
            calc.calculate(input[0].split(""));
        } else if (input.length == 3) {
            calc.calculate(input);
        } else {
            parser.getFailureFile();
        }
    }
}