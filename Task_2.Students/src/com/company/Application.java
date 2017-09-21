package com.company;

import Enums.Params;
import Enums.SimpleTexts;
import Objects.Group;
import Objects.Student;
import Objects.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printMsg(SimpleTexts.WELCOME_MSG.getValue());
        scanner.nextLine();

        List<Group> groups = generateGroup(
                Params.STUDENTS_COUNT.getValue(),
                Params.GROUPS_COUNT.getValue());
        List<Ticket> tickets = generateTicketsArray(Params.COUNT_TICKETS.getValue());

        startExamination(groups, tickets);

        printMsg(SimpleTexts.END_MSG.getValue());
        scanner.nextLine();
    }

    /**
     * Method to start execute "exam": Generate random marks for Student Object
     * and calculate Average and save best and worst students from all groups,
     * with printing in console
     *
     * @param groups  - List Group objects, that will be processed
     * @param tickets - List Ticket objects, for getting random exemplar for Student object
     */
    private static void startExamination(List<Group> groups, List<Ticket> tickets) {
        int bestMark = Params.BEST_MARK_DEFAULT.getValue();
        int worstMark = Params.WORST_MARK_DEFAULT.getValue();

        for (Group group : groups) {
            List<Integer> usedTicketIds = new ArrayList<>();
            for (Student student : group.getGroup()) {
                Integer ticketId = null;
                do {
                    ticketId = tickets.get(getRandomNumber(1, tickets.size() - 1)).getId();
                    if (usedTicketIds.size() == tickets.size()) {
                        usedTicketIds.clear();
                    }
                } while (ticketIsUsed(ticketId, usedTicketIds));


                student.setTicketId(ticketId);
                student.setMark(getRandomNumber(
                        Params.MIN_MARK.getValue(),
                        Params.MAX_MARK.getValue()));
                usedTicketIds.add(ticketId);

                if (bestMark <= student.getMarkValue()) {
                    bestMark = student.getMarkValue();
                } else if (worstMark >= student.getMarkValue()) {
                    worstMark = student.getMarkValue();
                }
            }
            group.printInfoAboutGroup();
            printMsg(String.format(SimpleTexts.INFO_MSG.getValue(), group.getGroupName()));
            printMsg(String.format(SimpleTexts.AVERAGE_MARK_TEMPLATE.getValue(), group.getGroupName(), group.getAverageMarkOfGroup()));
        }

        if (worstMark != Params.WORST_MARK_DEFAULT.getValue()) {
            printStudentByMark(bestMark,groups,SimpleTexts.BEST_STUDENT_TEMPLATE.getValue());
            printStudentByMark(worstMark,groups,SimpleTexts.WORST_STUDENT_TEMPLATE.getValue());
        } else {
            printMsg(String.format(SimpleTexts.MSG_SIMILAR_MARKS.getValue(), bestMark));
        }
    }

    /**
     * Method for printing students by mark from all groups
     * @param mark - marks' value for choosing students
     * @param groupsList - all groups in an array
     * @param message - message, that need to print
     */
    private static void printStudentByMark(int mark, List<Group> groupsList, String message) {
        for (Group group : groupsList) {
            for(Student student : group.getStudentsByMark(mark)){
                printMsg(String.format(
                        message,
                        student.getName()+" "+student.getLastName(),
                        mark,
                        group.getGroupName()));
            }
        }
    }

    /**
     * Method for checking that ticket with Id was not used
     * @param ticketId - ID of ticket that need to check
     * @param ticketIds -  array IDs of used tickets
     * @return boolean value, true if ticket was used, false if not
     */
    private static boolean ticketIsUsed(int ticketId, List<Integer> ticketIds) {
        return ticketIds.contains(ticketId);
    }

    /**
     * Method to generate List Group objects
     *
     * @param countStudentsInGroup - count of Student objects in one group
     * @param groupCount           - count of group, that need to generate
     * @return - return List Group Objects
     */
    private static List<Group> generateGroup(int countStudentsInGroup, int groupCount) {
        List<Group> groups = new ArrayList<>();
        for (int j = 1; j <= groupCount; j++) {
            Group group = new Group();
            for (int i = 0; i < countStudentsInGroup; i++) {
                Student student = new Student();
                student.setName(generateRandomText(
                        1,
                        Params.LENGTH_WORD.getValue(),
                        SimpleTexts.LETTERS.getValue()));
                student.setLastName(generateRandomText(
                        1,
                        Params.LENGTH_WORD.getValue(),
                        SimpleTexts.LETTERS.getValue()));
                group.addStudentToGroup(student);
            }
            groups.add(group);
            group.setGroupName(String.format(SimpleTexts.GROUP_NAME_TEMPLATE.getValue(), j));
        }
        return groups;
    }

    /**
     * Method to generate List Ticket objects
     *
     * @param count - count of ticket objects, that need to generate
     * @return - return List Ticket objects
     */
    private static List<Ticket> generateTicketsArray(int count) {
        List<Ticket> tickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Ticket ticket = new Ticket();
            ticket.setId(i);
            ticket.setQuestion(String.format("%s?",
                    generateRandomText(
                            Params.WORDS_COUNT.getValue(),
                            Params.LENGTH_WORD.getValue(),
                            SimpleTexts.LETTERS.getValue())));
            tickets.add(ticket);
        }
        return tickets;
    }

    /**
     * Mathod for generating a randomly text.
     *
     * @param words_count - count of word in text (if more than 1 - will separate via space
     * @param length      - length of each word in text
     * @param characters  - input string with characters, whom need to use for generating the text
     * @return text in String
     */
    private static String generateRandomText(int words_count, int length, String characters) {
        String result = "";
        while (words_count > 0) {
            char[] text = new char[length];
            for (int i = 0; i < length; i++) {
                text[i] = characters.charAt(new Random().nextInt(characters.length()));
            }
            result += new String(text);
            words_count--;
            if (words_count != 0) {
                result += "\\s";
            }
        }
        return result;
    }

    /**
     * Simple method to generate number from min value to max
     *
     * @param min - max threshold for generating
     * @param max - min threshold for generating
     * @return - random number
     */
    private static int getRandomNumber(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    /**
     * Method to print some message in console
     *
     * @param msg - text, that need to print
     */
    private static void printMsg(String msg) {
        System.out.print(msg);
    }
}
