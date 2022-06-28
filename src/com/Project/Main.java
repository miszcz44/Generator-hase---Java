package com.Project;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Password password = new Password();

        System.out.println("Podaj liczbę znaków w swoim haśle (conajmniej 5)");
        int numberOfCharacters = password.safeIntInputFromUser();
        numberOfCharacters = password.validateNumberOfCharacters(5, numberOfCharacters);
        password.setNumberOfCharactersLeft(numberOfCharacters);

        System.out.println("Podaj liczbę dużych liter w haśle");
        int numberOfUppercaseLetters = password.safeIntInputFromUser();
        numberOfUppercaseLetters = password.validateNumberOfCharacterForCharacterCategories(0,
                                                                                            numberOfUppercaseLetters);
        password.setNumberOfUppercaseLetters(numberOfUppercaseLetters);

        System.out.println("Podaj liczbę małych liter w haśle");
        int numberOfLowercaseLetters = password.safeIntInputFromUser();
        numberOfLowercaseLetters = password.validateNumberOfCharacterForCharacterCategories(0,
                                                                                            numberOfLowercaseLetters);
        password.setNumberOfLowercaseLetters(numberOfLowercaseLetters);

        System.out.println("Podaj liczbę cyfr w haśle");
        int numberOfDigits = password.safeIntInputFromUser();
        numberOfDigits = password.validateNumberOfCharacterForCharacterCategories(0,
                                                                                            numberOfDigits);
        password.setNumberOfDigits(numberOfDigits);

        System.out.println("Podaj liczbę znaków specjalnych w haśle");
        int numberOfSpecialCharacters = password.safeIntInputFromUser();
        numberOfSpecialCharacters = password.validateNumberOfCharacterForCharacterCategories(0,
                                                                                            numberOfUppercaseLetters);
        password.setNumberOfSpecialCharacters(numberOfSpecialCharacters);

    }
}
