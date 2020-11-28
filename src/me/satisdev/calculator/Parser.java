package me.satisdev.calculator;

public class Parser {

    Calculator calc;

    public Parser() {
        calc = new Calculator();
    }

    public void parse(String[] input){

        if (input.length == 0) calc.calculate();

//        if (input.length == 1) calc.calculate(input[0]);

    }

}
