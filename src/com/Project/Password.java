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

    public void updateNumberOfCharactersLeft(int usedCharacters){
        this.numberOfCharactersLeft -= usedCharacters;
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
            valueToStoreInteger = askForCorrectInteger();
        }
        return valueToStoreInteger;
    }

    public int askForCorrectInteger(){
        System.out.println("Upewnij sie, że wprowadziłeś prawidłową liczbę znaków");
        int valueToStoreInteger = safeIntInputFromUser();
        return valueToStoreInteger;
    }

    public int validateNumberOfCharacterForCharacterCategories(int minimumValueOfCharactersNumber, int valueToStoreInteger){
        while(valueToStoreInteger < minimumValueOfCharactersNumber ||
              valueToStoreInteger > this.numberOfCharactersLeft - this.numberOfCategoriesLeft + 1){
            System.out.println(valueToStoreInteger - this.numberOfCharactersLeft);
            valueToStoreInteger = askForCorrectInteger();
        }
        return valueToStoreInteger;
    }

    public void assignLeftCharactersToLowercase(){
        this.numberOfLowercaseLetters += this.numberOfCharactersLeft;
        this.numberOfCharactersLeft = 0;
        System.out.println("Pozostałe znaki zostały przypisane do małych liter");
    }
}
