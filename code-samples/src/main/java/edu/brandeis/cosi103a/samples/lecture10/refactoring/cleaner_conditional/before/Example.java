package edu.brandeis.cosi103a.samples.lecture10.refactoring.cleaner_conditional.before;

interface Emitter {
    void emit(String message);
}

public class Example {

    public static void printTempStats(double tempFahrenheit, Emitter emitter) {
        double tempCelsius = (tempFahrenheit - 32) * 5 / 9;

        if (tempCelsius > 37) {
            emitter.emit("Temperature is: " + tempCelsius + "C");
            emitter.emit("It's really hot!");
        } else if (tempCelsius < 10) {
            emitter.emit("Temperature is: " + tempCelsius + "C");
            emitter.emit("It's really cold!");
        } else {
            emitter.emit("Temperature is: " + tempCelsius + "C");
            emitter.emit("It's moderate!");
        }
    }

    static class ConsoleEmitter implements Emitter {
        public void emit(String message) {
            System.out.println(message);
        }
    }

    public static void main(String[] args) {
        printTempStats(100, new ConsoleEmitter()); // Example usage
    }
}