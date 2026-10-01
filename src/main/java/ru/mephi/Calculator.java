package ru.mephi;

import java.util.Scanner;

import static ru.mephi.Constants.*;

public class Calculator {
    private double result;

    public Calculator() {
        this.result = 0;
    }


    public Calculator(double initialValue) {
        this.result = initialValue;
    }

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
            System.out.printf("%s\n%s", LINE, MSG_ENTER_NUMBER);
            String input = sc.nextLine().trim();

            if (input.contains(",")) {
                System.out.println("Ошибка: используйте точку вместо запятой!");
                continue;
            }
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введено не число!");
            }
        }
    }

    public String readOperation(Scanner sc) {
        while (true) {
            String choice;
            System.out.printf("%s\n%s\nПоле ввода: ", LINE, MSG_OPERATION_MENU);
            choice = sc.nextLine().trim().toLowerCase();
            if (choice.equals("+") || choice.equals("-") || choice.equals("*") || choice.equals("/")
                    || choice.equals("s") || choice.equals("c") || choice.equals("r")) {
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