package com.Project;

import java.util.Scanner;

public class Password {
    private int length;
    private int numberOfUppercaseLetters;
    private int numberOfLowercaseLetters;
    private int numberOfDigits;
    private int numberOfSpecialCharacters;

    public void setLength(int length) {
        this.length = length;
    }

    public void setNumberOfUppercaseLetters(int numberOfUppercaseLetters) {
        this.numberOfUppercaseLetters = numberOfUppercaseLetters;
    }

    public void setNumberOfLowercaseLetters(int numberOfLowercaseLetters) {
        this.numberOfLowercaseLetters = numberOfLowercaseLetters;
    }

    public void setNumberOfDigits(int numberOfDigits) {
        this.numberOfDigits = numberOfDigits;
    }

    public void setNumberOfSpecialCharacters(int numberOfSpecialCharacters) {
        this.numberOfSpecialCharacters = numberOfSpecialCharacters;
    }

    public int safeIntInputFromUser() {
        int valueToStoreInteger = -1;
        Scanner scanner = new Scanner(System.in);
        while(true) {
            try {
                valueToStoreInteger = Integer.parseInt(scanner.next());
                break;
            } catch (Exception e) {
                System.out.println("Incorrect data. Try again.");
                continue;
            }
        }
        return valueToStoreInteger;
    }
}
