package edu.brandeis.cosi103a.samples.lecture10.refactoring.replace_nested_conditionals.before;

class Property {
    public String location;
    public Integer size;
    public Integer bedrooms;
}

public class Example {
    public Integer calculatePropertyPrice(Property property) {
        if (property != null) {
            if (property.location != null && property.size != null && property.bedrooms != null) {
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
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}

