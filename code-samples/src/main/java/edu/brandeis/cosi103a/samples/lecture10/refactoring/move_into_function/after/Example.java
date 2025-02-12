package edu.brandeis.cosi103a.samples.lecture10.refactoring.move_into_function.after;

// We've simplified calcPrice, without really adding to the complexity of discountedPrice,
// by moving all the logic for calculating the price into the calcPrice function.

class PriceCalculator {
    private double getSeasonalDiscount() { 
        // Implementation here
        return 0.0;
    }

    private double getFees() { 
        // Implementation here
        return 0.0;
    }

    public double calcPrice(int quantity, double itemPrice) {
        return this.discountedPrice(quantity * itemPrice);
    }

    double discountedPrice(double basePrice) {
        return basePrice - this.getSeasonalDiscount() + this.getFees();
    }
}