package com.Project;

import java.util.Scanner;

public class Password {
    private int numberOfCharactersLeft = 5;
    private int numberOfUppercaseLetters;
    private int numberOfLowercaseLetters;
    private int numberOfDigits;
    private int numberOfSpecialCharacters;

    public int getNumberOfCharactersLeft() {
        return numberOfCharactersLeft;
    }

    public void setNumberOfCharactersLeft(int numberOfCharactersLeft) {
        this.numberOfCharactersLeft = numberOfCharactersLeft;
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

    public int safeIntInputFromUser(int minimumValueOfCharactersNumber) {
        Scanner scanner = new Scanner(System.in);
        int valueToStoreInteger = -1;
        while (true) {
            try {
                valueToStoreInteger = Integer.parseInt(scanner.next());
                if(validateNumberOfCharacters(minimumValueOfCharactersNumber, valueToStoreInteger)){
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Niepoprawne dane. Spróbuj ponownie.");
                continue;
            }
        }
        return valueToStoreInteger;
    }



    public boolean validateNumberOfCharacters(int minimumValueOfCharactersNumber, int valueToStoreInteger){
       return true;
    }
}
