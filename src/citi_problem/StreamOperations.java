package citi_problem;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem: Java 8 stream operations - concat, groupingBy, partitioningBy.
 * Asked in: Sunen round
 */
public class StreamOperations {

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);

        // Concat two streams
        List<Integer> concatenated = java.util.stream.Stream.concat(list1.stream(), list2.stream())
                .collect(Collectors.toList());
        System.out.println("Concat: " + concatenated);

        // GroupingBy - group numbers by even/odd label
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<String, List<Integer>> grouped = numbers.stream()
                .collect(Collectors.groupingBy(n -> n % 2 == 0 ? "Even" : "Odd"));
        System.out.println("GroupingBy: " + grouped);

        // PartitioningBy - partition into even and odd
        Map<Boolean, List<Integer>> partitioned = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("PartitioningBy (true=even): " + partitioned);
    }
}

