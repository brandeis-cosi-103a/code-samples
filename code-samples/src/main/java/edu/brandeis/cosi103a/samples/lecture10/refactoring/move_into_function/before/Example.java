package edu.brandeis.cosi103a.samples.lecture10.refactoring.move_into_function.before;

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
        double basePrice = quantity * itemPrice;
        double seasonDiscount = this.getSeasonalDiscount();
        double fees = this.getFees();
        return this.discountedPrice(basePrice, seasonDiscount, fees);
    }

    private double discountedPrice(double basePrice, double seasonDiscount, double fees) {
        return basePrice - seasonDiscount + fees;
    }
}