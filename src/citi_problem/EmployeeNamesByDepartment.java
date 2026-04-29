package citi_problem;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem: Employee class with id, name, department. Print name for each department using stream.
 * Asked in: Ritwika round
 */
public class EmployeeNamesByDepartment {

    static class Employee {
        int id;
        String name;
        String department;

        Employee(int id, String name, String department) {
            this.id = id;
            this.name = name;
            this.department = department;
        }

        public String getName() { return name; }
        public String getDepartment() { return department; }
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "IT"),
                new Employee(2, "Bob", "HR"),
                new Employee(3, "Charlie", "IT"),
                new Employee(4, "Diana", "Finance"),
                new Employee(5, "Eve", "HR"),
                new Employee(6, "Frank", "Finance")
        );

        // Group and print names per department
        Map<String, List<String>> namesByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.mapping(Employee::getName, Collectors.toList())
                ));

        namesByDept.forEach((dept, names) ->
                System.out.println(dept + " -> " + names));
    }
}

