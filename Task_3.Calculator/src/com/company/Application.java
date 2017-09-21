package com.company;

import Enums.SimpleTexts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {

    private static Double firstNumber;
    private static Double secondNumber;
    private static String operation;

    public static void main(String[] args) {
        printMsg(SimpleTexts.WELCOME_MSG.getValue());
        do {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                if (firstNumber == null) {
                    firstNumber = getNumber(br);
                } else if (operation == null) {
                    operation = getOperation(br);
                } else if (secondNumber == null) {
                    secondNumber = getNumber(br);
                } else {
                    executeOperation(firstNumber, secondNumber, operation);
                    firstNumber = null;
                    secondNumber = null;
                    operation = null;
                }
            } catch (IOException e) {
                printMsg(SimpleTexts.ERROR_MSG_GENERAL.getValue());
            }

        } while (true);
    }


    private static Boolean executeOperation(Double firstNumber, Double secondNumber, String operation) {
        Double result = null;
        if (operation.equals(SimpleTexts.DIV.getValue()) && secondNumber == 0) {
            printMsg(SimpleTexts.ERROR_MSG_DEVISION_BY_ZERO.getValue());
            return false;
        } else {
            if (operation.equals(SimpleTexts.MINUS.getValue())) {
                result = firstNumber - secondNumber;
            } else if (operation.equals(SimpleTexts.PLUS.getValue())) {
                result = firstNumber + secondNumber;
            } else if (operation.equals(SimpleTexts.DIV.getValue())) {
                result = firstNumber / secondNumber;
            } else if (operation.equals(SimpleTexts.MULTI.getValue())) {
                result = firstNumber * secondNumber;
            }
            printMsg(String.format(SimpleTexts.MSG_RESULT.getValue(), result));
            return true;
        }
    }

    private static String getOperation(BufferedReader br) throws IOException {

        printMsg(SimpleTexts.MSG_OPERATIONS.getValue());
        String data = br.readLine();
        if (!data.equals(SimpleTexts.QUIT.getValue())) {
            if (data.equals(SimpleTexts.HELP.getValue())) {
                printMsg(SimpleTexts.OPTIONS_MSG.getValue());
                return null;
            } else {
                if (!data.equals(SimpleTexts.MINUS.getValue())
                        && !data.equals(SimpleTexts.PLUS.getValue())
                        && !data.equals(SimpleTexts.DIV.getValue())
                        && !data.equals(SimpleTexts.MULTI.getValue())) {
                    printMsg(SimpleTexts.ERROR_MSG_WRONG_OPERATIONS.getValue());
                    return null;
                }
            }
        } else {
            System.exit(0);
        }
        return data;
    }

    private static Double getNumber(BufferedReader br) throws IOException {
        Double value = null;
        printMsg(SimpleTexts.MSG_INPUT.getValue());
        String data = br.readLine();
        if (!data.equals(SimpleTexts.QUIT.getValue())) {
            if (data.equals(SimpleTexts.HELP.getValue())) {
                printMsg(SimpleTexts.OPTIONS_MSG.getValue());
                return null;
            } else {
                try {
                    value = Double.parseDouble(data);
                } catch (NumberFormatException e) {
                    printMsg(SimpleTexts.ERROR_MSG_WRONG_NUMBER.getValue());
                    value = null;
                }
            }
        } else {
            System.exit(0);
        }
        return value;
    }

    private static void printMsg(String value) {
        System.out.print(value);
    }
}
