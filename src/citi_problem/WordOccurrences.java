package citi_problem;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem: Calculate the occurrences of words in a statement / string.
 * Asked in: Mihir, Manikandan, Ritwika, Abinaya rounds
 */
public class WordOccurrences {

    public static void main(String[] args) {
        String sentence = "hello world hello java world hello stream java";

        // Using Stream API
        Map<String, Long> wordCount = Arrays.stream(sentence.split("\\s+"))
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()));

        System.out.println("Word occurrences: " + wordCount);

        // Ordered by frequency (descending)
        Map<String, Long> orderedByFreq = wordCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));

        System.out.println("Ordered by frequency: " + orderedByFreq);
    }
}

