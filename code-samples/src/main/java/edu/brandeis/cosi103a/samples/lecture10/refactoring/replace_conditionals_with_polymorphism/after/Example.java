package edu.brandeis.cosi103a.samples.lecture10.refactoring.replace_conditionals_with_polymorphism.after;

// We've created classes for the different property types, and moved the price calculation logic into
// them. This has vastly improved upon the original code, which had a deeply nested and confusing conditionals.

// Note that we've now separated seemingly related logic - calculating the price of a property - into
// separate classes. This is a tradeoff for improved readability of the property price calculation.

// This type of change would be more justified if we expected price calculation logic to diverge over time,
// and less justified if we expected it to stay very similar, and differ only by price ranges.

abstract class GenericProperty {
    protected int size;

    public GenericProperty(int size) {
        this.size = size;
    }

    public abstract Integer getPropertyPrice();
}

class SuburbanProperty extends GenericProperty {

    public SuburbanProperty(int size) {
        super(size);
    }

    @Override
    public Integer getPropertyPrice() {
        if (size < 1000) {
            return 150000;
        } else if (size < 2000) {
            return 250000;
        } else {
            return 350000;
        }
    }
}

class UrbanProperty extends GenericProperty {

    public UrbanProperty(int size) {
        super(size);
    }

    @Override
    public Integer getPropertyPrice() {
        if (size < 1000) {
            return 200000;
        } else if (size < 2000) {
            return 300000;
        } else {
            return 400000;
        }
    }
}

public class Example {

    public static Integer calculatePropertyPrice(GenericProperty property) {
        if (property == null) {
            return null;
        }
        return property.getPropertyPrice();
    }

    public static void main(String[] args) {
        GenericProperty suburbanProperty = new SuburbanProperty(1500);
        GenericProperty urbanProperty = new UrbanProperty(1500);

        System.out.println("Suburban Property Price: " + calculatePropertyPrice(suburbanProperty));
        System.out.println("Urban Property Price: " + calculatePropertyPrice(urbanProperty));
    }
}