package edu.brandeis.cosi103a.samples.lecture10.refactoring.rename.before;

import java.util.List;
import java.util.stream.Collectors;

public class Example {
    public static List<Integer> process(List<Integer> items, int limit) {
        return items.stream()
                .filter(item -> item <= limit)
                .collect(Collectors.toList());
    }
}
