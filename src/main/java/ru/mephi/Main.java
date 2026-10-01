package ru.mephi;

import java.util.Scanner;

import static ru.mephi.Constants.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String operation;

        System.out.printf("%s\n%s\n", LINE, MSG_CALCULATOR_STARTED);
        double firstNum = new Calculator().readNumber(sc);
        Calculator calculator = new Calculator(firstNum);

        while (true) {
            operation = calculator.readOperation(sc);
            if (operation.equals("s")) {
                System.out.printf("%s\n%s\n", MSG_EXIT, LINE);
                break;
            } else if (operation.equals("c")) {
                calculator.reset();
                System.out.printf("%s\n%s\n", LINE, MSG_RESET_RESULT);
                continue;
            } else if (operation.equals("r")) {
                System.out.printf("%s\n" + MSG_CURRENT_RESULT, LINE, calculator.getResult());
                continue;
            }
            double calNum = calculator.readNumber(sc);
            calculator.calculate(calNum, operation);
            System.out.printf("%s\n" + MSG_YOUR_RESULT, LINE, calculator.getResult());
        }
    }

}


