package ru.mephi;

public enum Command {
    RESET("c"),
    EXIT("s"),
    SHOW_RESULT("r");

    private final String symbol;

    Command(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public static Command fromSymbol(String symbol) {
        for (Command cmd : values()) {
            if (cmd.getSymbol().equals(symbol)) {
                return cmd;
            }
        }
        return null;
    }


}
