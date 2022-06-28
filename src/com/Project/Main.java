package com.Project;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Password password = new Password();

        System.out.println("Podaj liczbę znaków w swoim haśle");
        int numberOfCharacters = scanner.nextInt();
        password.setLength(numberOfCharacters);

        System.out.println("Podaj liczbę dużych liter w haśle");
        int numberOfUppercaseLetters = scanner.nextInt();
        password.setNumberOfUppercaseLetters(numberOfUppercaseLetters);

        System.out.println("Podaj liczbę małych liter w haśle");
        int numberOfLowercaseLetters = scanner.nextInt();
        password.setNumberOfLowercaseLetters(numberOfLowercaseLetters);

        System.out.println("Podaj liczbę cyfr w haśle");
        int numberOfDigits = scanner.nextInt();
        password.setNumberOfDigits(numberOfDigits);

        System.out.println("Podaj liczbę znaków specjalnych w haśle");
        int numberOfSpecialCharacters = scanner.nextInt();
        password.setNumberOfSpecialCharacters(numberOfSpecialCharacters);

    }
}
