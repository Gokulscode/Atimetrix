package citi_problem;

import java.util.*;

/**
 * Problem: Find the minimum value in a given list of integers.
 * Also: Find min and max with and without stream.
 * Asked in: Kavya, Abinaya rounds
 */
public class MinMaxInList {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(34, 12, 56, 3, 89, 7, 45);

        // Using Stream
        OptionalInt min = numbers.stream().mapToInt(Integer::intValue).min();
        OptionalInt max = numbers.stream().mapToInt(Integer::intValue).max();
        System.out.println("Min (stream): " + min.orElse(0));
        System.out.println("Max (stream): " + max.orElse(0));

        // Without Stream
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        for (int n : numbers) {
            if (n < minVal) minVal = n;
            if (n > maxVal) maxVal = n;
        }
        System.out.println("Min (loop): " + minVal);
        System.out.println("Max (loop): " + maxVal);

        // Using Collections
        System.out.println("Min (Collections): " + Collections.min(numbers));
        System.out.println("Max (Collections): " + Collections.max(numbers));
    }
}

