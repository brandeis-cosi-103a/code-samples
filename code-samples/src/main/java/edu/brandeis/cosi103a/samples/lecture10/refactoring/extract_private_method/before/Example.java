package edu.brandeis.cosi103a.samples.lecture10.refactoring.extract_private_method.before;

import java.util.ArrayList;
import java.util.List;

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

    void addItem(Item item) {
        items.add(item);
    }

    public double calculateItemPrice(int index) {
        Item item = items.get(index);
        double price = item.price;
        if (item.quantity > 10) {
            // 5% discount over 10 items
            price = item.price * 0.95;
        }
        return price * item.discount * item.quantity;
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Item item : items) {
            double price = item.price;
            if (item.quantity > 10) {
                // 5% discount over 10 items
                price = item.price * 0.95;
            }
            totalPrice += price * item.discount * item.quantity;
        }
        if (totalPrice < 250) {
            return totalPrice + 20; // add shipping
        } else {
            return totalPrice; // free shipping over 250
        }
    }
}