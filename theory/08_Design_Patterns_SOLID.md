# Design Patterns & SOLID Principles - Interview Questions

## SOLID Principles

### S - Single Responsibility Principle
A class should have **only one reason to change**. One class = one job.

### O - Open/Closed Principle
Classes should be **open for extension, closed for modification**. Use interfaces/abstract classes.

### L - Liskov Substitution Principle
Subtypes must be **substitutable** for their base types without breaking behavior.

### I - Interface Segregation Principle
Clients should not be forced to depend on interfaces they don't use. **Many small interfaces > one large interface**.

### D - Dependency Inversion Principle
High-level modules should not depend on low-level modules. Both should depend on **abstractions**.
```java
// Bad: Controller depends on concrete MySQLRepository
// Good: Controller depends on Repository interface
interface Repository { void save(Data d); }
class MySQLRepository implements Repository { ... }
class Controller {
    private Repository repo; // depends on abstraction
}
```

## Design Patterns

### Singleton
One instance throughout application. See `citi_problem/SingletonPattern.java`.
- **Ways to break**: Reflection, Serialization, Cloning
- **Prevention**: Throw exception in constructor (reflection), `readResolve()` (serialization), override `clone()`

### Factory
Create objects without exposing creation logic. See `citi_problem/FactoryDesignPattern.java`.

### Builder
Step-by-step construction of complex objects.
```java
User user = User.builder().name("John").age(30).email("john@mail.com").build();
```

### Strategy
Define family of algorithms, encapsulate each, make them interchangeable.
```java
interface PaymentStrategy { void pay(int amount); }
class CreditCardPayment implements PaymentStrategy { ... }
class UPIPayment implements PaymentStrategy { ... }
```

### CQRS (Command Query Responsibility Segregation)
Separate **read** and **write** operations into different models/databases.

### SAGA Pattern
Manage distributed transactions across microservices.
- **Choreography**: Events drive the flow
- **Orchestration**: Central coordinator

## Event-Driven Design Pattern
Services communicate via **events** (messages).
- Producer publishes event → Event Bus (Kafka) → Consumer reacts
- Loosely coupled, scalable, resilient

