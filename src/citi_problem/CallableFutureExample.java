package citi_problem;

import java.util.concurrent.*;

/**
 * Problem: Callable and Future Object / CompletableFuture examples.
 * Asked in: Ritwika, Sunen rounds
 */
public class CallableFutureExample {

    public static void main(String[] args) throws Exception {
        // === Callable + Future ===
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Callable<Integer> task1 = () -> {
            Thread.sleep(1000);
            return 10 + 20;
        };

        Future<Integer> future = executor.submit(task1);
        System.out.println("Future result: " + future.get()); // blocks until done

        executor.shutdown();

        // === CompletableFuture ===
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            try { Thread.sleep(500); } catch (InterruptedException e) {}
            return "Hello";
        });

        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> {
            try { Thread.sleep(300); } catch (InterruptedException e) {}
            return "World";
        });

        // Chain operations
        CompletableFuture<String> result = cf1.thenCombine(cf2, (s1, s2) -> s1 + " " + s2);
        System.out.println("CompletableFuture result: " + result.get());

        // thenApply, thenAccept
        CompletableFuture.supplyAsync(() -> "Java")
                .thenApply(s -> s + " Interview")
                .thenApply(String::toUpperCase)
                .thenAccept(System.out::println);

        Thread.sleep(1000); // wait for async
    }
}

