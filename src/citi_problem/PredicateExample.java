package citi_problem;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: Write examples for Predicate Functional Interface and other functional interfaces.
 * Asked in: SDET-Gautham, Harshatej rounds
 */
public class PredicateExample {

    public static void main(String[] args) {
        // Predicate - takes input, returns boolean
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Predicate<Integer> isPositive = n -> n > 0;

        System.out.println("Is 4 even? " + isEven.test(4));
        System.out.println("Is -3 positive? " + isPositive.test(-3));

        // Combining predicates
        Predicate<Integer> isEvenAndPositive = isEven.and(isPositive);
        System.out.println("Is 4 even and positive? " + isEvenAndPositive.test(4));

        // Filter list using Predicate
        List<Integer> numbers = Arrays.asList(-5, 3, -2, 8, 0, -1, 7);
        System.out.print("Even and positive: ");
        numbers.stream().filter(isEvenAndPositive).forEach(n -> System.out.print(n + " "));
        System.out.println();

        // Function - takes input, returns output
        Function<String, Integer> strLength = String::length;
        System.out.println("Length of 'Hello': " + strLength.apply("Hello"));

        // Consumer - takes input, returns nothing
        Consumer<String> printer = System.out::println;
        printer.accept("Consumer example");

        // Supplier - takes nothing, returns output
        Supplier<Double> randomValue = Math::random;
        System.out.println("Random: " + randomValue.get());
    }
}

