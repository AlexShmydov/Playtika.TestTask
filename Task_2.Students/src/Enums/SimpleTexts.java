package Enums;

/**
 * Enum class for saving and comfortable editing texts, that use in program,
 * with getting value
 */

public enum SimpleTexts {
    WELCOME_MSG("Hello!\nTask #2. Students on exam.\nTo start EXAM - press ENTER key."),
    INFO_MSG("\n\nGroup '%s' passed exam successful!"),
    LETTERS("ABCDEFGHIJKLMNOPQRSTUVWXYZ"),
    AVERAGE_MARK_TEMPLATE("\nIn group '%s' average mark is %s\n\n"),
    BEST_STUDENT_TEMPLATE("\nBest student is %s with mark is %s from '%s'"),
    WORST_STUDENT_TEMPLATE("\nWorst student is %s with mark is %s from '%s'"),
    END_MSG("\n\nExam was finished!\nPress any key to quit the program!\n"),
    GROUP_NAME_TEMPLATE("GROUP '%s'"),
    MSG_SIMILAR_MARKS("\nSorry, but all students got similar marks!\nMark is %s"),
    INFO_GROUP_TEMPLATE("\nStudent: %s %s with ticketId: %s and mark for ticket: %s");

    private final String value;

    SimpleTexts(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
