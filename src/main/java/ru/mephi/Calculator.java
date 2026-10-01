package ru.mephi;

import java.util.Scanner;

import static ru.mephi.Constants.LINE;

public class Calculator {
    private double result;

    public double getResult() {
        return this.result;
    }

    public void setResult(double value) {
        this.result = value;
    }

    public void reset() {
        this.result = 0;
    }

    public double readNumber(Scanner sc) {
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

    public String readOperation(Scanner sc) {
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

    public void calculate(double num2, String operation) {

        switch (operation) {
            case "+":
                this.result = this.result + num2;
                break;
            case "-":
                this.result = this.result - num2;
                break;
            case "*":
                this.result = this.result * num2;
                break;
            case "/":
                if (num2 == 0) {
                    System.out.println("На ноль делить нельзя!");
                } else {
                    this.result = this.result / num2;
                }
                break;
        }
    }


}