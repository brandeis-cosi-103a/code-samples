package edu.brandeis.cosi103a.samples.lecture10.refactoring.extract_private_method.after;

import java.util.ArrayList;
import java.util.List;

// We've simplified the individual methods on the PriceCalculator class by factoring out repeated logic into
// private methods. It's also a little easier to read with well-named functions.


class Item {
    double price;
    int quantity;
    double discount;

    Item(double price, int quantity, double discount) {
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
    }
}

class PriceCalculator {
    private List<Item> items;

    public PriceCalculator() {
        this.items = new ArrayList<>();
    }

    private static double applyBulkDiscount(Item item) {
        if (item.quantity > 10) {
            // 5% discount over 10 items
            return item.price * 0.95;
        } else {
            return item.price;
        }
    }

    private static double addShippingToTotal(double totalPrice) {
        if (totalPrice < 250) {
            return totalPrice + 20; // add shipping
        } else {
            return totalPrice; // free shipping over 250
        }
    }

    private static double calculateItemPrice(Item item) {
        return applyBulkDiscount(item) * item.quantity;
    }

    public double calculateItemPrice(int index) {
        return calculateItemPrice(items.get(index));
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Item item : this.items) {
            totalPrice += calculateItemPrice(item);
        }
        return addShippingToTotal(totalPrice);
    }
}