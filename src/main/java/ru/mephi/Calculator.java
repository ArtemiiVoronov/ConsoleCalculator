package ru.mephi;

import java.util.Scanner;

public class Calculator {
    static final String LINE = "------------------------------";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double result = 0;
        String operation;

        System.out.println("Калькулятор запущен");
        result = readNumber(sc);
        while (true) {
            operation = readOperation(sc);
            if (operation.equals("s")) {
                System.out.println("До свидания!\n" + LINE);
                break;
            } else if (operation.equals("c")) {
                System.out.println("Результат сброшен.\nРезультат = 0");
                result = readNumber(sc);
                continue;
            }

            double calNum = readNumber(sc);
            result = calculate(result, calNum, operation);
            System.out.printf(LINE + "\nВаш результат: %.2f%n", result);

        }
    }

    public static double readNumber(Scanner sc) {
        while (true) {
            try {
                System.out.print(LINE + "\nВведите число: ");
                String input = sc.nextLine().trim().replace(',', '.');
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введено не число!");
            }
        }
    }

    public static String readOperation(Scanner sc) {
        while (true) {
            String choice;
            System.out.print(LINE + "\nВведите операцию:\n+ - Сложение \n- - Вычитание \n* - Умножение " +
                    "\n/ - Деление\nC - для сброса результата\nS - для выхода\n" + LINE + "\nПоле ввода:");
            choice = sc.nextLine().trim().toLowerCase();
            if (choice.equals("+") || choice.equals("-") || choice.equals("*") || choice.equals("/")
                    || choice.equals("s") || choice.equals("c")) {
                return choice;
            } else {
                System.out.println("Данная операция не предусмотрена");
            }
        }
    }

    public static double calculate(double num1, double num2, String operation) {
        double result = num1;

        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    System.out.println("На ноль делить нельзя!");
                    result = num1;
                } else {
                    result = num1 / num2;
                }
                break;
        }
        return result;
    }

}