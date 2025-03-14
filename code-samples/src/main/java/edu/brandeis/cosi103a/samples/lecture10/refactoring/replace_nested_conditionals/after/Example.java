package edu.brandeis.cosi103a.samples.lecture10.refactoring.replace_nested_conditionals.after;

class Property {
    public String location;
    public Integer size;
    public Integer bedrooms;
}

// We've simplified logic and improved readability by replacing nested conditionals with 
// a series of "guard clauses". (Clauses that return early if a condition is not met.)

public class Example {
    public static Integer calculatePropertyPrice(Property property) {
        if (property == null) {
            return null;
        }

        if (property.location == null || property.size == null || property.bedrooms == null) {
            return null;
        }

        if (!property.location.equals("city") && !property.location.equals("suburb")) {
            return null;
        }

        if (property.location.equals("city")) {
            if (property.size < 1000) {
                return 200000;
            } else if (property.size < 2000) {
                return 300000;
            } else {
                return 400000;
            }
        } else if (property.location.equals("suburb")) {
            if (property.size < 1000) {
                return 150000;
            } else if (property.size < 2000) {
                return 250000;
            } else {
                return 350000;
            }
        }

        return null;
    }
}