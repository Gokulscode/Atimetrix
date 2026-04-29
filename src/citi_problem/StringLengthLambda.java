package citi_problem;

import java.util.Arrays;
import java.util.List;

/**
 * Problem: Use lambda to print the length of each string of a given list.
 * Asked in: Shrinivas round
 */
public class StringLengthLambda {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello", "World", "Java", "Stream", "Lambda");

        // Using lambda
        words.forEach(word -> System.out.println(word + " -> " + word.length()));

        // Using method reference with map
        words.stream()
                .map(w -> w + " : " + w.length())
                .forEach(System.out::println);
    }
}

