package com.Project;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbę znaków w swoim haśle");
        int numberOfCharacters = scanner.nextInt();
        System.out.println("Podaj liczbę dużych liter w haśle");
        int numberOfUppercaseLetters = scanner.nextInt();
        System.out.println("Podaj liczbę małych liter w haśle");
        int numberOfLowercaseLetters = scanner.nextInt();
        System.out.println("Podaj liczbę cyfr w haśle");
        int numberOfDigits = scanner.nextInt();
        System.out.println("Podaj liczbę znaków specjalnych w haśle");
        int numberOfSpecialCharacters = scanner.nextInt();

    }
}
