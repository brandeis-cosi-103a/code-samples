package edu.brandeis.cosi103a.samples.lecture10.refactoring.rename.after;

import java.util.List;
import java.util.stream.Collectors;

// We've made this code more readable by using descriptive, precise names.

public class Example {
    public static List<Integer> removeAboveLimit(List<Integer> items, int maxValueInclusive) {
        return items.stream()
                .filter(item -> item <= maxValueInclusive)
                .collect(Collectors.toList());
    }
}
