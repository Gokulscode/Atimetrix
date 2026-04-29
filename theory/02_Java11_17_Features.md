# Java 11/17 Features - Interview Questions

## Java 11 Features
- **var keyword** - Local variable type inference: `var list = new ArrayList<String>();`
- **String methods**: `isBlank()`, `lines()`, `strip()`, `repeat()`
- **Files**: `readString()`, `writeString()`
- **Garbage Collection**: **ZGC** (Z Garbage Collector) introduced - low latency GC
- **HTTP Client API** (standardized from Java 9 incubator)
- **Running .java files directly**: `java HelloWorld.java`

## Java 17 Features
- **Sealed Classes** - Restrict which classes can extend a superclass
  ```java
  public sealed class Shape permits Circle, Rectangle {}
  ```
- **Records** - Immutable data classes with auto-generated constructor, getters, equals, hashCode, toString
  ```java
  public record Point(int x, int y) {}
  ```
- **Pattern Matching for instanceof**
  ```java
  if (obj instanceof String s) { System.out.println(s.length()); }
  ```
- **Text Blocks** (from Java 13+)
  ```java
  String json = """
      { "name": "John" }
      """;
  ```
- **Switch Expressions** (from Java 14+)

## Does Java 8 resolve multiple inheritance issue?
Yes, with **default methods** in interfaces. If two interfaces have same default method, the implementing class MUST override it to resolve ambiguity.

## Garbage Collection in Java 11
- Java 11 uses **G1 GC** by default (replaces Parallel GC from Java 8)
- **ZGC** introduced for ultra-low latency (< 10ms pause)
- Heap divided into: **Young Gen** (Eden + Survivor) → **Old Gen** → **Metaspace**

## var keyword
- Only for local variables (not fields, parameters, or return types)
- Compiler infers type at compile time (still strongly typed)
- Cannot use with `null`: `var x = null;` ❌

## How to make a List immutable?
```java
// Java 9+
List<String> immutable = List.of("a", "b", "c");

// Java 8
List<String> immutable = Collections.unmodifiableList(Arrays.asList("a", "b"));

// Java 10+
var immutable = List.copyOf(mutableList);
```

