# Multithreading & Concurrency - Interview Questions

## 1. What is Multithreading?
Multiple threads executing concurrently within a process, sharing memory space.

## 2. Race Condition
When multiple threads access shared data simultaneously and result depends on execution order.
**Solution**: `synchronized`, `Lock`, `ConcurrentHashMap`, `Atomic` classes.

## 3. Thread vs Callable/Future
| Runnable/Thread | Callable/Future |
|-----------------|-----------------|
| `run()` returns void | `call()` returns result |
| Cannot throw checked exception | Can throw exception |
| No result | `Future.get()` to get result |

## 4. CompletableFuture
Non-blocking async programming (Java 8+).
```java
CompletableFuture.supplyAsync(() -> fetchData())
    .thenApply(data -> process(data))
    .thenAccept(result -> save(result));
```
- `thenApply` - transform result
- `thenAccept` - consume result
- `thenCombine` - combine two futures
- `exceptionally` - handle errors

## 5. Distributed Concurrency
Concurrency across multiple JVMs/servers.
- **Distributed Locks** (Redis, Zookeeper)
- **Database-level locking** (optimistic/pessimistic)
- **Idempotent operations**

## 6. Executor Framework
```java
ExecutorService executor = Executors.newFixedThreadPool(5);
executor.submit(() -> doWork());
executor.shutdown();
```
Types: `newFixedThreadPool`, `newCachedThreadPool`, `newSingleThreadExecutor`, `newScheduledThreadPool`

## 7. Difference between throw and throws
| throw | throws |
|-------|--------|
| Throws an exception explicitly | Declares exceptions method might throw |
| Used inside method body | Used in method signature |
| Single exception | Multiple exceptions |

## 8. @Scheduled Job
```java
@Scheduled(fixedRate = 5000)  // every 5 seconds
@Scheduled(cron = "0 0 * * * *")  // every hour
```
**Ensure runs only once in containerized env**: Use distributed lock (Redis/ShedLock).

## 9. How to handle thread safety on DB updates?
- **Optimistic Locking**: `@Version` column, retry on conflict
- **Pessimistic Locking**: `@Lock(LockModeType.PESSIMISTIC_WRITE)`
- **Database-level**: `SELECT ... FOR UPDATE`

## 10. Atomicity between datasources
- **JTA (Java Transaction API)** with distributed transaction manager
- **SAGA pattern** for microservices
- **Two-Phase Commit (2PC)**

