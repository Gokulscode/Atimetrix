# Java 8 Features - Interview Questions

## 1. What are Java 8 features?
- **Lambda Expressions** - Anonymous functions for concise code
- **Functional Interfaces** - Interface with single abstract method (`@FunctionalInterface`)
- **Stream API** - Process collections in functional/declarative way
- **Optional Class** - Handle null values gracefully
- **Default & Static methods in interfaces**
- **Method References** - Shorthand for lambdas (`Class::method`)
- **Date/Time API** (`java.time`)
- **Predicate, Function, Consumer, Supplier** - Predefined functional interfaces

## 2. What is a Lambda Expression?
An anonymous function (no name, no return type declaration, no access modifier).
```java
// Before Java 8
Runnable r = new Runnable() {
    public void run() { System.out.println("Hello"); }
};

// With Lambda
Runnable r = () -> System.out.println("Hello");
```

## 3. What is a Functional Interface?
An interface with **exactly one abstract method**. Can have multiple default/static methods.
- `@FunctionalInterface` is optional but recommended
- Predefined: `Predicate<T>`, `Function<T,R>`, `Consumer<T>`, `Supplier<T>`

## 4. What is Optional Class?
Wrapper to handle `null` values and avoid `NullPointerException`.
```java
Optional<String> opt = Optional.ofNullable(getName());
String name = opt.orElse("Default");
opt.ifPresent(System.out::println);
```

## 5. What is Stream API?
Process collections functionally without modifying original data.
- **Intermediate ops** (lazy): `filter()`, `map()`, `sorted()`, `distinct()`, `flatMap()`
- **Terminal ops** (trigger execution): `collect()`, `forEach()`, `reduce()`, `count()`, `min()`, `max()`
- Supports **lazy evaluation** - intermediate operations execute only when terminal operation is called

## 6. What is a Predicate?
A functional interface that takes one argument and returns `boolean`.
```java
Predicate<Integer> isEven = n -> n % 2 == 0;
isEven.test(4); // true
```
**Purpose beyond null-checking**: Composable conditions with `.and()`, `.or()`, `.negate()`. Used in `filter()`, validation, specification pattern.

## 7. Difference between Stream and for loop?
| Stream | For Loop |
|--------|----------|
| Declarative | Imperative |
| Supports parallel processing | Sequential by default |
| Lazy evaluation | Eager |
| Immutable (no side effects) | Can modify external state |
| Cannot reuse | Can iterate multiple times |

## 8. What is Method Reference?
Shorthand for lambda when calling existing method:
- `ClassName::staticMethod` → `Math::abs`
- `instance::method` → `System.out::println`
- `ClassName::instanceMethod` → `String::toUpperCase`
- `ClassName::new` → Constructor reference

## 9. What is Type Inference in Java 8?
Compiler automatically determines the type of lambda parameters.
```java
// No need to specify type
List<String> list = Arrays.asList("a", "b");
list.forEach(s -> System.out.println(s)); // s inferred as String
```

