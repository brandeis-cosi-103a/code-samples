package edu.brandeis.cosi103a.samples.lecture5.modularity.v4;

// Refactored Sample 3: Adding Design Patterns (Observer and Decorator)

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface InputService {
    String getName();
    int getAge();
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

// Observer Pattern for Output
interface MessageObserver {
    void update(String message);
}

class ConsoleObserver implements MessageObserver {
    @Override
    public void update(String message) {
        System.out.println("Console: " + message);
    }
}

class LogObserver implements MessageObserver {
    @Override
    public void update(String message) {
        System.out.println("Log: " + message);
    }
}

class MessagePublisher {
    private final List<MessageObserver> observers = new ArrayList<>();

    public void subscribe(MessageObserver observer) {
        observers.add(observer);
    }

    public void publish(String message) {
        for (MessageObserver observer : observers) {
            observer.update(message);
        }
    }
}

// Decorator Pattern for Message Formatting
interface MessageFormatter {
    String format(String message);
}

class BasicFormatter implements MessageFormatter {
    @Override
    public String format(String message) {
        return message;
    }
}

class FancyFormatter implements MessageFormatter {
    private final MessageFormatter inner;

    public FancyFormatter(MessageFormatter inner) {
        this.inner = inner;
    }

    @Override
    public String format(String message) {
        return "*** " + inner.format(message) + " ***";
    }
}

public class DesignPatternsApp {
    public static void main(String[] args) {
        InputService inputService = new UserInput();
        AgeProcessor processorService = new AgeToGreetingsProcessor();

        MessagePublisher publisher = new MessagePublisher();
        publisher.subscribe(new ConsoleObserver());
        publisher.subscribe(new LogObserver());

        MessageFormatter formatter = new FancyFormatter(new BasicFormatter());

        String name = inputService.getName();
        int age = inputService.getAge();
        String rawMessage = processorService.generateMessage(name, age);
        String formattedMessage = formatter.format(rawMessage);

        publisher.publish(formattedMessage);
    }
}
