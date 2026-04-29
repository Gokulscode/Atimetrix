# OOP Concepts - Interview Questions

## 1. Four Pillars of OOP
- **Encapsulation** - Wrapping data + methods. Private fields + public getters/setters
- **Inheritance** - Child class inherits from parent class
- **Polymorphism** - Same method, different behavior (overloading/overriding)
- **Abstraction** - Hide implementation, show only functionality

## 2. Abstract Class vs Interface
| Abstract Class | Interface |
|---------------|-----------|
| Can have constructors | No constructors |
| Can have instance variables | Only constants (public static final) |
| Can have concrete methods | Only abstract methods (before Java 8) |
| Single inheritance | Multiple inheritance |
| `extends` keyword | `implements` keyword |
| Can have any access modifier | Methods are `public` by default |

**Java 8+**: Interfaces can have `default` and `static` methods.

## 3. Can a class implement multiple interfaces?
**Yes**. This is how Java achieves multiple inheritance.

## 4. Diamond Problem (Multiple Inheritance)
When two interfaces have same default method, implementing class must **override** to resolve ambiguity.
```java
interface A { default void show() { System.out.println("A"); } }
interface B { default void show() { System.out.println("B"); } }
class C implements A, B {
    public void show() { A.super.show(); } // must override
}
```

## 5. How to call abstract class constructor?
Cannot instantiate directly, but constructor is called via **super()** from child class.
```java
abstract class Animal {
    Animal(String name) { System.out.println("Animal: " + name); }
}
class Dog extends Animal {
    Dog() { super("Dog"); }
}
```

## 6. Private Constructor
- Cannot instantiate class from outside
- Used in: **Singleton**, **Utility classes**, **Factory pattern**

## 7. Types of Inheritance
- **Single** - A extends B
- **Multilevel** - A extends B, B extends C
- **Hierarchical** - B extends A, C extends A
- **Multiple** - Not supported via classes (use interfaces)
- **Hybrid** - Combination (use interfaces)

## 8. Generics
Provide **type safety** at compile time. Avoid ClassCastException.
```java
List<String> list = new ArrayList<>(); // only String allowed
```

## 9. Serialization & Deserialization
- **Serialization**: Convert object to byte stream (`ObjectOutputStream`)
- **Deserialization**: Convert byte stream back to object (`ObjectInputStream`)
- Implement `Serializable` interface
- `transient` keyword - exclude field from serialization
- `serialVersionUID` - version control for serialized class

