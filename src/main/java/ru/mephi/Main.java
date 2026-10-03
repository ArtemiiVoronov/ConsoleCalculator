package ru.mephi;

import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static ru.mephi.Constants.*;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        logger.info("Калькулятор запущен");
        System.out.printf("%s\n%s\n", LINE, MSG_CALCULATOR_STARTED);
        Calculator calculator = new Calculator();
        ConsoleReader consoleReader = new ConsoleReader();
        calculator.setResult(consoleReader.readNumber(sc));

        while (true) {
            String token = consoleReader.readToken(sc);
            Command command = Command.fromSymbol(token);
            Operation operation = Operation.fromSymbol(token);
            if (command == Command.EXIT) {
                logger.info("Калькулятор завершает работу");
                System.out.printf("%s\n%s\n", MSG_EXIT, LINE);
                break;
            } else if (command == Command.RESET) {
                calculator.reset();
                System.out.printf("%s\n%s\n", LINE, MSG_RESET_RESULT);
                continue;
            } else if (command == Command.SHOW_RESULT) {
                System.out.printf("%s\n" + MSG_CURRENT_RESULT, LINE, calculator.getResult());
                continue;
            }
            double calNum = consoleReader.readNumber(sc);
            calculator.calculate(calNum, operation);
            System.out.printf("%s\n" + MSG_YOUR_RESULT, LINE, calculator.getResult());
        }
    }

}


