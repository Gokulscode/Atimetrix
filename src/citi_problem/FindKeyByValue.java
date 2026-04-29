package citi_problem;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Problem: Find key if value is given for a hashmap of thousands of records.
 * Asked in: Hemant round
 */
public class FindKeyByValue {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Alice", 90);
        map.put("Bob", 85);
        map.put("Charlie", 92);
        map.put("Diana", 88);

        int targetValue = 92;

        // Way 1: Using entrySet stream
        Optional<String> key = map.entrySet().stream()
                .filter(e -> e.getValue() == targetValue)
                .map(Map.Entry::getKey)
                .findFirst();

        System.out.println("Key for value " + targetValue + ": " + key.orElse("Not found"));

        // Way 2: Traditional loop
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == targetValue) {
                System.out.println("Key (loop): " + entry.getKey());
                break;
            }
        }
    }
}

