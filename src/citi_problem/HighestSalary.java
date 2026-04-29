package citi_problem;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem: Find the highest salary using Stream API.
 * Asked in: Harshatej round
 */
public class HighestSalary {

    static class Employee {
        String name;
        String department;
        double salary;

        Employee(String name, String department, double salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        public String getName() { return name; }
        public String getDepartment() { return department; }
        public double getSalary() { return salary; }

        @Override
        public String toString() { return name + "(" + salary + ")"; }
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "IT", 90000),
                new Employee("Bob", "HR", 75000),
                new Employee("Charlie", "IT", 120000),
                new Employee("Diana", "HR", 85000),
                new Employee("Eve", "IT", 110000)
        );

        // Highest salary overall
        Optional<Employee> highest = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary));
        highest.ifPresent(e -> System.out.println("Highest salary: " + e));

        // Highest salary per department
        Map<String, Optional<Employee>> highestByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))
                ));

        highestByDept.forEach((dept, emp) ->
                System.out.println(dept + " -> " + emp.orElse(null)));
    }
}

