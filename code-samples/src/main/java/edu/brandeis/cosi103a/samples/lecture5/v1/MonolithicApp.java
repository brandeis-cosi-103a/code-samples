package edu.brandeis.cosi103a.samples.lecture5.v1;

import java.util.Scanner;

public class MonolithicApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Enter your age: ");
        int age = scanner.nextInt();

        String message;
        if (age < 18) {
            message = "Hello, " + name + ". You are a minor.";
        } else {
            message = "Hello, " + name + ". You are an adult.";
        }

        System.out.println(message);
    }
}