package com.Project;

import java.util.Scanner;

public class Password {
    private int numberOfCharactersLeft;
    private int numberOfUppercaseLetters;
    private int numberOfLowercaseLetters;
    private int numberOfDigits;
    private int numberOfSpecialCharacters;
    private int numberOfCategoriesLeft =  4;

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

    public void updateNumberOfCategoriesLeft(){
        numberOfCategoriesLeft -= 1;
    }

    public int safeIntInputFromUser() {
        Scanner scanner = new Scanner(System.in);
        int valueToStoreInteger = -1;
        while (true) {
            try {
                valueToStoreInteger = Integer.parseInt(scanner.next());
                break;
            } catch (Exception e) {
                System.out.println("Niepoprawne dane. Spróbuj ponownie.");
                continue;
            }
        }
        return valueToStoreInteger;
    }



    public int validateNumberOfCharacters(int minimumValueOfCharactersNumber, int valueToStoreInteger){
        while(valueToStoreInteger < minimumValueOfCharactersNumber) {
            valueToStoreInteger = askForCorrectInteger(minimumValueOfCharactersNumber, valueToStoreInteger);
        }
        return valueToStoreInteger;
    }

    public int askForCorrectInteger(int minimumValueOfCharactersNumber, int valueToStoreInteger){
        System.out.println("Upewnij sie, że wprowadziłeś prawidłową liczbę znaków");
        valueToStoreInteger = safeIntInputFromUser();
        return valueToStoreInteger;
    }

    public int validateNumberOfCharacterForCharacterCategories(int minimumValueOfCharactersNumber, int valueToStoreInteger){
        while(valueToStoreInteger < minimumValueOfCharactersNumber ||
              valueToStoreInteger > this.numberOfCharactersLeft - this.numberOfCategoriesLeft){
            valueToStoreInteger = askForCorrectInteger(minimumValueOfCharactersNumber, valueToStoreInteger);
        }
        return valueToStoreInteger;
    }
}
