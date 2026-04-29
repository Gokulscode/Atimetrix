package citi_problem;

/**
 * Problem: Composition and Aggregation - write code.
 * Asked in: SDET-Gautham, Sunen, Abinaya rounds
 */
public class CompositionAggregation {

    // === COMPOSITION: Strong relationship. Part cannot exist without the whole. ===
    // If Car is destroyed, Engine is also destroyed.
    static class Engine {
        String type;
        Engine(String type) { this.type = type; }
        @Override public String toString() { return "Engine(" + type + ")"; }
    }

    static class Car {
        String model;
        Engine engine; // Composition: Engine is created inside Car

        Car(String model, String engineType) {
            this.model = model;
            this.engine = new Engine(engineType); // Engine lifecycle tied to Car
        }

        @Override public String toString() { return model + " with " + engine; }
    }

    // === AGGREGATION: Weak relationship. Part can exist independently. ===
    // If Department is destroyed, Professors still exist.
    static class Professor {
        String name;
        Professor(String name) { this.name = name; }
        @Override public String toString() { return name; }
    }

    static class Department {
        String name;
        Professor professor; // Aggregation: Professor exists independently

        Department(String name, Professor professor) {
            this.name = name;
            this.professor = professor; // Professor passed from outside
        }

        @Override public String toString() { return name + " -> " + professor; }
    }

    public static void main(String[] args) {
        // Composition
        Car car = new Car("Tesla Model 3", "Electric");
        System.out.println("Composition: " + car);

        // Aggregation
        Professor prof = new Professor("Dr. Smith");
        Department dept = new Department("CS", prof);
        System.out.println("Aggregation: " + dept);
        // prof still exists even if dept is set to null
    }
}

