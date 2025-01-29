package edu.brandeis.cosi103a.samples.lecture5.modularity.v2;

import java.util.Scanner;

class UserInput {
    private Scanner scanner;

    public UserInput() {
        this.scanner = new Scanner(System.in);
    }

    public String getName() {
        System.out.println("Enter your name: ");
        return scanner.nextLine();
    }

    public int getAge() {
        System.out.println("Enter your age: ");
        return scanner.nextInt();
    }
}

class AgeProcessor {
    public String generateMessage(String name, int age) {
        if (age < 18) {
            return "Hello, " + name + ". You are a minor.";
        } else {
            return "Hello, " + name + ". You are an adult.";
        }
    }
}

class ConsoleOutput {
    public void displayMessage(String message) {
        System.out.println(message);
    }
}

public class ImprovedApp {
    public static void main(String[] args) {
        UserInput input = new UserInput();
        AgeProcessor processor = new AgeProcessor();
        ConsoleOutput output = new ConsoleOutput();

        String name = input.getName();
        int age = input.getAge();
        String message = processor.generateMessage(name, age);
        output.displayMessage(message);
    }
}
