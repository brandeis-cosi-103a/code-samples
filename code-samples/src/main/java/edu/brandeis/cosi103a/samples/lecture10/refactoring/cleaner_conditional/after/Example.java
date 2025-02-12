package edu.brandeis.cosi103a.samples.lecture10.refactoring.cleaner_conditional.after;

interface Emitter {
    void emit(String message);
}

// We've reduced duplication by pulling a repeated statement out of a chain of conditionals.

public class Example {

    public static void printTempStats(double tempFahrenheit, Emitter emitter) {
        double tempCelsius = (tempFahrenheit - 32) * 5 / 9;

        System.out.println("Temperature is: " + tempCelsius + "C");

        if (tempCelsius > 37) {
            emitter.emit("It's really hot!");
        } else if (tempCelsius < 10) {
            emitter.emit("It's really cold!");
        } else {
            emitter.emit("It's moderate!");
        }
    }

    static class ConsoleEmitter implements Emitter {
        public void emit(String message) {
            System.out.println(message);
        }
    }

    public static void main(String[] args) {
        printTempStats(100, new ConsoleEmitter());
        printTempStats(50, new ConsoleEmitter());
        printTempStats(20, new ConsoleEmitter());
    }
}
