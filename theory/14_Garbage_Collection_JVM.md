# Garbage Collection & JVM - Interview Questions

## 1. What is Garbage Collection?
Automatic memory management. JVM identifies and removes objects that are no longer referenced.

## 2. How does GC work?
- **Mark**: Identify reachable objects from GC roots (stack, static fields)
- **Sweep**: Remove unreachable objects
- **Compact**: Defragment remaining memory

## 3. Heap Memory Generations
```
Heap Memory
├── Young Generation
│   ├── Eden Space (new objects created here)
│   ├── Survivor S0
│   └── Survivor S1
├── Old Generation (long-lived objects promoted here)
└── Metaspace (class metadata, replaces PermGen in Java 8+)
```

**Flow**: New object → Eden → Minor GC → Survivor → (after threshold) → Old Gen → Major GC

## 4. Types of GC
- **Serial GC** - Single thread, small apps
- **Parallel GC** - Multiple threads (Java 8 default)
- **G1 GC** - Regionalized, low pause (Java 11 default)
- **ZGC** - Ultra-low latency (<10ms), Java 11+
- **Shenandoah GC** - Concurrent, low pause

## 5. How to manually invoke GC?
```java
System.gc(); // Suggests GC (not guaranteed)
Runtime.getRuntime().gc();
```
**Note**: GC invocation is just a suggestion. JVM decides when to actually run it.

## 6. How does GC know which objects to clean?
Objects without any **reachable reference** from GC roots:
- Local variables on stack
- Active threads
- Static fields
- JNI references

## 7. Which memory space does GC use in Heap?
GC operates on **Young Gen** (Minor GC - frequent, fast) and **Old Gen** (Major/Full GC - less frequent, slower).

## 8. Java 11 GC changes
- **G1 GC** became default (was Parallel GC in Java 8)
- **ZGC** introduced (experimental) - concurrent, <10ms pauses
- **Epsilon GC** - No-op GC for performance testing

