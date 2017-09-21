package Enums;

/**
 * Enum class for saving and comfortable editing parameters with getting value
 */

public enum Params {
    COUNT_TICKETS(10),
    LENGTH_WORD(10),
    WORDS_COUNT(2),
    STUDENTS_COUNT(5),
    GROUPS_COUNT(2),
    MAX_MARK(5),
    MIN_MARK(1),
    WORST_MARK_DEFAULT(999),
    BEST_MARK_DEFAULT(0);

    private final int value;

    Params(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}