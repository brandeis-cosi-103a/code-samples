package edu.brandeis.cosi103a.samples.lecture5.modularity.v3;

import java.util.Scanner;

interface InputService {
    String getName();
    int getAge();
}

class TestInput implements InputService {
    public String getName() { return "Joe"; }
    public int getAge() { return 27; }
}

class UserInput implements InputService {
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