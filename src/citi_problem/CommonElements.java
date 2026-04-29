package citi_problem;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem: Find common elements from two input lists using streams.
 * Asked in: Sri Valli round
 */
public class CommonElements {

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> list2 = Arrays.asList(4, 5, 6, 7, 8, 9);

        List<Integer> common = list1.stream()
                .filter(list2::contains)
                .collect(Collectors.toList());

        System.out.println("Common elements: " + common);
    }
}

