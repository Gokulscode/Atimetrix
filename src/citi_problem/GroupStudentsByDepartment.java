package citi_problem;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem: Using Java 8, group the List of Students based on their departments.
 * Asked in: Multiple rounds (Mihir, Mayank, Abinaya, Ritwika)
 */
public class GroupStudentsByDepartment {

    static class Student {
        String name;
        String department;

        Student(String name, String department) {
            this.name = name;
            this.department = department;
        }

        public String getName() { return name; }
        public String getDepartment() { return department; }

        @Override
        public String toString() { return name; }
    }

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alice", "CS"),
                new Student("Bob", "EE"),
                new Student("Charlie", "CS"),
                new Student("Diana", "ME"),
                new Student("Eve", "EE"),
                new Student("Frank", "CS")
        );

        // Group students by department
        Map<String, List<Student>> studentsByDept = students.stream()
                .collect(Collectors.groupingBy(Student::getDepartment));

        studentsByDept.forEach((dept, studs) ->
                System.out.println(dept + " -> " + studs));
    }
}

