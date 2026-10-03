package ru.mephi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Calculator {
    private double result;
    private static final Logger logger = LoggerFactory.getLogger(Calculator.class);

    public Calculator() {
        this.result = 0;
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


    public void calculate(double operand, Operation operation) {

        switch (operation) {
            case ADD:
                this.result += operand;
                break;
            case SUBTRACT:
                this.result -= operand;
                break;
            case MULTIPLY:
                this.result *= operand;
                break;
            case DIVIDE:
                if (operand == 0) {
                    logger.warn("Попытка деления на ноль");
                    System.out.println("На ноль делить нельзя!");
                } else {
                    this.result /= operand;
                }
                break;
            default:
                logger.warn("Неизвестная операция: {}", operation);
                System.out.println("Неизвестная операция");
                break;
        }
        logger.info("Операция выполнена: {} {} = {}", operation, operand, this.result);
    }


}