package me.satisdev.calculator;

public class CalculatorParser {

    private Calculator calc;
    private FileParser fparser;

    public CalculatorParser() {
        calc = new Calculator();
        fparser = new FileParser();
    }

    public void parse(String[] input){
        if (input.length == 0) {
            calc.calculate();
        } else if (input.length == 1) {
            calc.calculate(input[0]);
        } else if (input.length == 3) {
            calc.calculate(input);
        } else {
            fparser.getFailureFile();
        }
    }
}
