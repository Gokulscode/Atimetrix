package citi_problem;

import java.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem: Race condition in HashMap and how to overcome it.
 * Asked in: Mihir round
 */
public class RaceConditionHashMap {

    public static void main(String[] args) throws InterruptedException {

        // === Problem: HashMap is NOT thread-safe ===
        Map<Integer, Integer> unsafeMap = new HashMap<>();

        Runnable unsafeTask = () -> {
            for (int i = 0; i < 1000; i++) {
                unsafeMap.put(i, i);
            }
        };

        Thread t1 = new Thread(unsafeTask);
        Thread t2 = new Thread(unsafeTask);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("HashMap size (may be inconsistent): " + unsafeMap.size());

        // === Solution: Use ConcurrentHashMap ===
        Map<Integer, Integer> safeMap = new ConcurrentHashMap<>();

        Runnable safeTask = () -> {
            for (int i = 0; i < 1000; i++) {
                safeMap.put(i, i);
            }
        };

        Thread t3 = new Thread(safeTask);
        Thread t4 = new Thread(safeTask);
        t3.start();
        t4.start();
        t3.join();
        t4.join();
        System.out.println("ConcurrentHashMap size (always correct): " + safeMap.size());
    }
}

