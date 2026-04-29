package citi_problem;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem: Print marks greater than 75 using streams.
 * Asked in: Abinaya round
 */
public class FilterMarks {

    public static void main(String[] args) {
        List<Integer> marks = Arrays.asList(45, 80, 67, 92, 75, 88, 55, 100, 30, 76);

        List<Integer> above75 = marks.stream()
                .filter(m -> m > 75)
                .collect(Collectors.toList());

        System.out.println("Marks greater than 75: " + above75);
    }
}

