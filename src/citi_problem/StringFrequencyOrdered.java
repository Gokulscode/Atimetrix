package citi_problem;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem: Find frequency of strings and order by frequency.
 * Asked in: Abinaya round
 */
public class StringFrequencyOrdered {

    public static void main(String[] args) {
        List<String> words = Arrays.asList(
                "apple", "banana", "apple", "cherry", "banana", "apple",
                "date", "cherry", "banana", "date", "date", "date"
        );

        // Count frequency and order by frequency descending
        Map<String, Long> frequencyMap = words.stream()
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()));

        LinkedHashMap<String, Long> orderedByFrequency = frequencyMap.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));

        System.out.println("Ordered by frequency: " + orderedByFrequency);
    }
}

