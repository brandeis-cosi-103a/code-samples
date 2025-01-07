package edu.brandeis.cosi103a.samples.lecture5.v3;

import java.util.Scanner;

interface InputService {
    String getName();
    int getAge();
}

class UserInput implements InputService {
    public String getName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        return scanner.nextLine();
    }

    public int getAge() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your age: ");
        return scanner.nextInt();
    }
}

interface OutputService {
    void displayMessage(String message);
}

class ConsoleOutputService implements OutputService {
    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }
}

interface AgeProcessor {
    String generateMessage(String name, int age);
}

class AgeToGreetingsProcessor implements AgeProcessor {
    public String generateMessage(String name, int age) {
        if (age < 18) {
            return "Hello, " + name + ". You are a minor.";
        } else {
            return "Hello, " + name + ". You are an adult.";
        }
    }
}

public class DependencyInjectionApp {
    private final InputService inputService;
    private final AgeProcessor processorService;
    private final OutputService outputService;

    public DependencyInjectionApp(InputService inputService, AgeProcessor processorService, OutputService outputService) {
        this.inputService = inputService;
        this.processorService = processorService;
        this.outputService = outputService;
    }

    public void run() {
        String name = inputService.getName();
        int age = inputService.getAge();
        String message = processorService.generateMessage(name, age);
        outputService.displayMessage(message);
    }

    public static void main(String[] args) {
        InputService input = new UserInput();
        AgeProcessor processor = new AgeToGreetingsProcessor();
        OutputService output = new ConsoleOutputService();

        DependencyInjectionApp app = new DependencyInjectionApp(input, processor, output);
        app.run();
    }
}