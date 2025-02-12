package edu.brandeis.cosi103a.samples.lecture10.refactoring.inject.before;

public class Example {

    public static void printTempStats(double tempFahrenheit) {
        double tempCelsius = (tempFahrenheit - 32) * 5 / 9;
        System.out.println("Temperature is: " + tempCelsius + "C");

        if (tempCelsius > 37) {
            System.out.println("It's really hot!");
        } else if (tempCelsius < 10) {
            System.out.println("It's really cold!");
        } else {
            System.out.println("It's moderate!");
        }
    }

    public static void main(String[] args) {
        printTempStats(100); // Example usage
    }
}