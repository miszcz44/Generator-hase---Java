package com.Project;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.Key;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Password {
    private int numberOfCharactersLeft;
    private int numberOfUppercaseLetters;
    private int numberOfLowercaseLetters;
    private int numberOfDigits;
    private int numberOfSpecialCharacters;
    private int numberOfCategoriesLeft =  4;
    private ArrayList<String> characters = new ArrayList<>();
    private String passwordContent = "" ;
    private Random random = new Random();
    private File file = new File("Passwords.txt");

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
                System.out.println("Niepoprawne dane. Spr??buj ponownie.");
                continue;
            }
        }
        return valueToStoreInteger;
    }

    public void printTheCurrentStateOfCharactersLeft(){
        System.out.printf("Znakow do wykorzystania: %d\n", this.numberOfCharactersLeft);
    }

    public int validateNumberOfCharacters(int minimumValueOfCharactersNumber, int valueToStoreInteger){
        while(valueToStoreInteger < minimumValueOfCharactersNumber || valueToStoreInteger > 50) {
            valueToStoreInteger = askForCorrectInteger();
        }
        return valueToStoreInteger;
    }

    public int validateNumberOfCharacterForCharacterCategories(int minimumValueOfCharactersNumber, int valueToStoreInteger){
        while(valueToStoreInteger < minimumValueOfCharactersNumber ||
        valueToStoreInteger > this.numberOfCharactersLeft - this.numberOfCategoriesLeft + 1 || valueToStoreInteger > 50){
            valueToStoreInteger = askForCorrectInteger();
        }
        return valueToStoreInteger;
    }

    public int askForCorrectInteger(){
        System.out.println("Upewnij sie, ??e wprowadzi??e?? prawid??ow?? liczb?? znak??w");
        int valueToStoreInteger = safeIntInputFromUser();
        return valueToStoreInteger;
    }

    public void assignLeftCharactersToLowercase(){
        this.numberOfLowercaseLetters += this.numberOfCharactersLeft;
        this.numberOfCharactersLeft = 0;
        System.out.println("Pozosta??e znaki zosta??y przypisane do ma??ych liter");
    }

    public void createThePassword(){
        generateLowercaseLetters();
        generateUppercaseLetters();
        generateDigits();
        generateSpecialCharacters();
        Collections.shuffle(characters);
        assignPasswordContentToString();
        System.out.println("Twoje has??o:");
        characters.forEach(System.out::printf);
        System.out.println("");
    }

    public void assignPasswordContentToString(){
        for(String character : characters){
            this.passwordContent += character;
        }
    }


    public void generateLowercaseLetters(){
        for(int i = 0; i < this.numberOfLowercaseLetters; i++){
            char randomLowercaseLetter = ((char)(random.nextInt(26) + 'a'));
            turnRandomCharacterToStringAndAddToTheArray(randomLowercaseLetter);
        }
    }

    public void generateUppercaseLetters(){
        for(int i = 0; i < this.numberOfUppercaseLetters; i++){
            char randomUppercaseLetter = ((char)(random.nextInt(26) + 'A'));
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

    public boolean askIfUserWantsToSaveThePassword(){
        System.out.println("Czy chcesz zapisa?? has??o do pliku?");
        System.out.println("1.Tak");
        System.out.println("2.Nie");
        int userChoice = safeIntInputFromUser();
        if(userChoice == 1){
            return true;
        }
        return false;
    }

    public String askForAKeyToStoreThePassword() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj klucz pod jakim zapisane b??dzie has??o");
        String KeyToStoreThePassword = scan.nextLine();
        return KeyToStoreThePassword;
    }

    public void addThePasswordToTheFile(String keyToStoreThePassword) throws IOException {
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(keyToStoreThePassword + ": " + this.passwordContent);
        bufferedWriter.newLine();
        bufferedWriter.close();
        fileWriter.close();
    }
}
