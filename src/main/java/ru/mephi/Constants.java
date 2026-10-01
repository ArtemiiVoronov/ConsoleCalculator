package ru.mephi;

public final class Constants {
    public static final String LINE = "---------------------------";


    public static final String MSG_CALCULATOR_STARTED = "Калькулятор запущен!";
    public static final String MSG_EXIT = "До свидания!\n";

    public static final String MSG_ENTER_NUMBER = "Введите число (используйте точку для дробной части): ";
    public static final String MSG_RESET_RESULT = "Результат сброшен.\nТекущий результат = 0";
    public static final String MSG_CURRENT_RESULT = "Текущий результат: %.2f%n";

    public static final String MSG_OPERATION_MENU =
            """
                    Введите операцию:
                    + - Сложение\s
                    - - Вычитание\s
                    * - Умножение\s
                    / - Деление
                    C - для сброса результата
                    S - для выхода
                    R - Текущий результат:""";

    public static final String MSG_RESET_RESULT_WITH_VALUE = "Текущий результат сброшен на %.2f%n";

    public static final String MSG_YOUR_RESULT = "Ваш результат: %.2f%n";
    public static final String MSG_INPUT_ERROR_NOT_A_NUMBER = "Ошибка: введено не число!";
    public static final String MSG_INVALID_OPERATION = "Данная операция не предусмотрена";


    private Constants() {
    }
}