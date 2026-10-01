package ru.mephi;

import java.util.Scanner;

import static ru.mephi.Constants.LINE;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();
        String operation;

        System.out.println("Калькулятор запущен!");
        calculator.setResult(calculator.readNumber(sc));

        while (true) {
            operation = calculator.readOperation(sc);
            if (operation.equals("s")) {
                System.out.println("До свидания!\n" + LINE);
                break;
            } else if (operation.equals("c")) {
                System.out.println("Результат сброшен.\nРезультат = 0");
                calculator.setResult(calculator.readNumber(sc));
                continue;
            }
            double calNum = calculator.readNumber(sc);
            calculator.calculate(calNum, operation);
            System.out.printf(LINE + "\nВаш результат: %.2f%n", calculator.getResult());
        }
    }

}


