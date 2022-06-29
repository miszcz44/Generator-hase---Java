package com.Project;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Password {
    private int numberOfCharactersLeft;
    private int numberOfUppercaseLetters;
    private int numberOfLowercaseLetters;
    private int numberOfDigits;
    private int numberOfSpecialCharacters;
    private int numberOfCategoriesLeft =  4;
    private ArrayList<String> characters;
    private Random random;

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

    public void printTheCurrentStateOfCharactersLeft(){
        System.out.printf("Znakow do wykorzystania: %d\n", this.numberOfCharactersLeft);
    }

    public int validateNumberOfCharacters(int minimumValueOfCharactersNumber, int valueToStoreInteger){
        while(valueToStoreInteger < minimumValueOfCharactersNumber) {
            valueToStoreInteger = askForCorrectInteger();
        }
        return valueToStoreInteger;
    }

    public int validateNumberOfCharacterForCharacterCategories(int minimumValueOfCharactersNumber, int valueToStoreInteger){
        while(valueToStoreInteger < minimumValueOfCharactersNumber ||
        valueToStoreInteger > this.numberOfCharactersLeft - this.numberOfCategoriesLeft + 1){
            valueToStoreInteger = askForCorrectInteger();
        }
        return valueToStoreInteger;
    }

    public int askForCorrectInteger(){
        System.out.println("Upewnij sie, że wprowadziłeś prawidłową liczbę znaków");
        int valueToStoreInteger = safeIntInputFromUser();
        return valueToStoreInteger;
    }

    public void assignLeftCharactersToLowercase(){
        this.numberOfLowercaseLetters += this.numberOfCharactersLeft;
        this.numberOfCharactersLeft = 0;
        System.out.println("Pozostałe znaki zostały przypisane do małych liter");
    }

    public void createThePassword(){

    }

    public void generateLowercaseLetters(){
        for(int i = 0; i < this.numberOfLowercaseLetters; i++){
            char randomLowercaseLetter = ((char)(random.nextInt(26) + 'a'));
            turnRandomCharacterToStringAndAddToTheArray(randomLowercaseLetter);
        }
    }

    public void generateUppercaseLetters(){
        for(int i = 0; i < this.numberOfUppercaseLetters; i++){
            char randomUppercaseLetter = ((char)(random.nextInt(26) + 'a'));
            turnRandomCharacterToStringAndAddToTheArray(randomUppercaseLetter);
        }
    }

    public void generateDigits(){
        for(int i = 0; i < this.numberOfDigits; i++){
            char randomDigit = (char)(random.nextInt(10));
            turnRandomCharacterToStringAndAddToTheArray(randomDigit);
        }
    }

    public void generateSpecialCharacters(){
        for(int i = 0; i < this.numberOfSpecialCharacters; i++){
            char randomSpecialCharacter = (char)(random.nextInt(0xB4 - 21 + 1) + 21);
            turnRandomCharacterToStringAndAddToTheArray(randomSpecialCharacter);
        }
    }

    public void turnRandomCharacterToStringAndAddToTheArray(char randomCharacter){
        String randomCharacterToStr = "" + randomCharacter;
        characters.add(randomCharacterToStr);
    }
}
