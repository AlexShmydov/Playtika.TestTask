package com.company;

import java.io.IOException;

public class Main {
    final static String TEXT_TO_PRINT = "Hello, world!";

    public static void main(String[] args) {
        try {
            System.out.print(TEXT_TO_PRINT);
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
