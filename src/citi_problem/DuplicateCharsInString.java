package citi_problem;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem: Find duplicate characters in a string using Stream API.
 * Asked in: Manikandan round
 */
public class DuplicateCharsInString {

    public static void main(String[] args) {
        String input = "programming";

        // Way 1: Using groupingBy and filtering
        Map<Character, Long> charCount = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        System.out.println("All char counts: " + charCount);

        List<Character> duplicates = charCount.entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("Duplicate chars: " + duplicates);

        // Way 2: Using Set to detect duplicates
        Set<Character> seen = new HashSet<>();
        Set<Character> dups = input.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> !seen.add(c))
                .collect(Collectors.toSet());

        System.out.println("Duplicate chars (way 2): " + dups);
    }
}

