package me.satisdev.calculator.parsers;

import me.satisdev.calculator.Calculator;

public class InputParser {

    private Calculator calc;
    private FileParser fparser;

    public InputParser() {
        calc = new Calculator();
        fparser = new FileParser();
    }

    public void parse(String[] input){
        if (input.length == 0) {
            calc.calculate();
        } else if (input.length == 1) {
            calc.calculate(input[0].split(""));
        } else if (input.length == 3) {
            calc.calculate(input);
        } else {
            fparser.getFailureFile();
        }
    }
}