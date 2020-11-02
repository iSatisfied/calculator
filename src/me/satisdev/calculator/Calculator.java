import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    private Scanner scanner;

    public Calculator() {
        this.scanner = new Scanner(System.in);
    }

    public void calculate(String expression) {
        char[] sections = expression.toCharArray();
    }

    public void calculate() {
        String s1 = "\nPlease input your first number: ";
        String s2 = "\nPlease input an arithmetic operator (ie. + - * / % ): ";
        String s3 = "\nPlease input your second number: ";

        double firstNum = verifyNumber(s1);
        String operator = verifyOperator(s2);
        double secondNum = verifyNumber(s3);

        System.out.print("\n" + firstNum + " " + operator + " " + secondNum + " = ");

        result(firstNum, operator, secondNum);
    }

    public void result(double firstNum, String operator, double secondNum) {
        switch (operator) {
            case "+":
                System.out.println((firstNum + secondNum) + "\n");
                break;

            case "-":
                System.out.println((firstNum - secondNum) + "\n");
                break;

            case "*":
                System.out.println((firstNum * secondNum) + "\n");
                break;

            case "/":
                System.out.println((firstNum / secondNum) + "\n");
                break;

            case "%":
                System.out.println((firstNum % secondNum) + "\n");
                break;
        }
    }

    public String verifyOperator(String prompt) {
        String[] operators = {"+", "-", "*", "/", "%"};

        while (true) {
            System.out.print(prompt);
            String input = scanner.next();

            for (String operator : operators) {
                if (input.equals(operator)) return input;
            }

            System.out.println("\nYou must input a proper operator!");
            System.out.println("Please try again.");
        }
    }

    public double verifyNumber(String prompt) {

        while (true) {
            try {

                System.out.print(prompt);
                return scanner.nextDouble();

            } catch (InputMismatchException e) {
                System.out.println("\nYou must input a number!");
                System.out.println("Please try again.");
                scanner.next();
            }
        }
    }
}
