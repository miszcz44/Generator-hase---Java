package com.Project;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Password password = new Password();

        System.out.println("Podaj liczbę znaków w swoim haśle (conajmniej 5)");
        int numberOfCharacters = password.safeIntInputFromUser(5);
        password.setNumberOfCharactersLeft(numberOfCharacters);

        System.out.println("Podaj liczbę dużych liter w haśle");
        int numberOfUppercaseLetters = password.safeIntInputFromUser(0);
        password.setNumberOfUppercaseLetters(numberOfUppercaseLetters);

        System.out.println("Podaj liczbę małych liter w haśle");
        int numberOfLowercaseLetters = password.safeIntInputFromUser(0);
        password.setNumberOfLowercaseLetters(numberOfLowercaseLetters);

        System.out.println("Podaj liczbę cyfr w haśle");
        int numberOfDigits = password.safeIntInputFromUser(0);
        password.setNumberOfDigits(numberOfDigits);

        System.out.println("Podaj liczbę znaków specjalnych w haśle");
        int numberOfSpecialCharacters = password.safeIntInputFromUser(0);
        password.setNumberOfSpecialCharacters(numberOfSpecialCharacters);

    }
}
