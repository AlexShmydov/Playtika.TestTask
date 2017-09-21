package Enums;

/**
 * Enum class for saving and comfortable editing texts, that use in program,
 * with getting value
 */

public enum SimpleTexts {
    WELCOME_MSG("Hello!" +
            "\nTask #3. Calculator." +
            "\nInput 'help' to see options of program." +
            "\nInput 'quit' to exit\n"),
    MSG_INPUT("\nInput number and press ENTER\n"),
    MSG_OPERATIONS("\nInput operations and press ENTER\n"),
    MSG_RESULT("\nRESULT: %s\nPlease,Continue\n"),
    OPTIONS_MSG("\nCalculator gets to you calculate simple operations and has simple possibilities:\n" +
            "calculator accept an integer and fractional numbers, separate the comma (.)\n" +
            "input '-' if you want to execute a subtraction operation between two numbers,\n" +
            "input '+' if you want to execute an addition operation between two numbers,\n" +
            "input '/' if you want to execute a division operation between two numbers,\n" +
            "input '*' if you want to execute a multiplication operation between two numbers,\n"),
    ERROR_MSG_DEVISION_BY_ZERO("\nError!\nDivision by zero!\n"),
    ERROR_MSG_WRONG_OPERATIONS("\nError!\nWrong operations. Possible operations: -,+,/,*" +
            "\nInput 'help' to see options of program.\n"),
    ERROR_MSG_WRONG_NUMBER("\nInputting value is wrong!\nPlease, try again.\n"),
    ERROR_MSG_GENERAL("\n\n Something going wrong!\nCheck input value and try again!\n\n"),
    QUIT("quit"),
    HELP("help"),
    MINUS("-"),
    DIV("/"),
    PLUS("+"),
    MULTI("*");

    private final String value;

    SimpleTexts(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
