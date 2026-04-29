package citi_problem;

/**
 * Problem: Implement Factory Design Pattern.
 * Asked in: Sri Valli, Sunen rounds
 */
public class FactoryDesignPattern {

    // Product interface
    interface Shape {
        void draw();
    }

    // Concrete products
    static class Circle implements Shape {
        public void draw() { System.out.println("Drawing Circle"); }
    }

    static class Rectangle implements Shape {
        public void draw() { System.out.println("Drawing Rectangle"); }
    }

    static class Triangle implements Shape {
        public void draw() { System.out.println("Drawing Triangle"); }
    }

    // Factory
    static class ShapeFactory {
        public static Shape getShape(String type) {
            switch (type.toLowerCase()) {
                case "circle": return new Circle();
                case "rectangle": return new Rectangle();
                case "triangle": return new Triangle();
                default: throw new IllegalArgumentException("Unknown shape: " + type);
            }
        }
    }

    public static void main(String[] args) {
        Shape s1 = ShapeFactory.getShape("circle");
        Shape s2 = ShapeFactory.getShape("rectangle");
        Shape s3 = ShapeFactory.getShape("triangle");

        s1.draw();
        s2.draw();
        s3.draw();
    }
}

