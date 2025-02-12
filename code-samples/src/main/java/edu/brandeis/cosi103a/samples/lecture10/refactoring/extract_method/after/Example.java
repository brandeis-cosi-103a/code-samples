package edu.brandeis.cosi103a.samples.lecture10.refactoring.extract_method.after;

import java.util.Scanner;

// We've made this code more readable by extracting related logic into a function with a clear name.
// We also renamed some variables to clearly denote the units they hold.

public class Example {

    public static double calcBmi(double weightKg, double heightCm) {
        double heightM = heightCm / 100;
        return weightKg / (heightM * heightM);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Weight in kgs: ");
        double weightKg = scanner.nextDouble();

        System.out.print("Enter height in cms: ");
        double heightCm = scanner.nextDouble();

        System.out.println("BMI is: " + calcBmi(weightKg, heightCm));
        
        scanner.close();
    }
}