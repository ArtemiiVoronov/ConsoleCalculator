package ru.mephi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Locale;
import java.util.Scanner;

import static ru.mephi.Constants.*;

public class ConsoleReader {
    private static final Logger logger = LoggerFactory.getLogger(ConsoleReader.class);

    public double readNumber(Scanner sc) {
        while (true) {
            System.out.printf("%s\n%s", LINE, MSG_ENTER_NUMBER);
            String input = sc.nextLine().trim();

            if (input.contains(",")) {
                logger.warn("Пользователь ввёл запятую: {}", input);
                System.out.println("Ошибка: используйте точку вместо запятой!");
                continue;
            }
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                logger.warn("Некорректный ввод числа: {}", input);
                System.out.println(MSG_INPUT_ERROR_NOT_A_NUMBER);
            }
        }
    }

    public String readToken(Scanner sc) {
        while (true) {
            String choice;
            System.out.printf("%s\n%s\nПоле ввода: ", LINE, MSG_OPERATION_MENU);
            choice = sc.nextLine().trim().toLowerCase(Locale.ROOT);
            if (Operation.fromSymbol(choice) != null || Command.fromSymbol(choice) != null) {
                return choice;
            } else {
                logger.warn("Некорректная операция: {}", choice);
                System.out.println(MSG_INVALID_OPERATION);
            }
        }

    }
}
